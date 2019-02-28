package com.tencent.mm.be;

import android.content.Context;
import android.database.Cursor;
import com.tencent.mm.bx.h;
import com.tencent.mm.f.a.kl;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.au.d;
import com.tencent.mm.y.as;
import java.util.ArrayList;
import java.util.List;

public final class c extends i<b> implements a {
    public static final String[] gLy = new String[]{i.a(b.gKN, "fmessage_conversation")};
    private static final String[] hUJ = new String[]{"CREATE INDEX IF NOT EXISTS  fmessageConversationTalkerIndex ON fmessage_conversation ( talker )", "CREATE INDEX IF NOT EXISTS  fmconversation_isnew_Index ON fmessage_conversation ( isNew )"};
    private final int fgH = 1;
    public e gLA;
    private Runnable hUK = new Runnable() {
        public final void run() {
            x.v("MicroMsg.FMessageConversationStorage", "onNotifyChange, newCount update to = %d", Integer.valueOf(c.this.Ts()));
            as.Hm();
            com.tencent.mm.y.c.Db().set(143618, Integer.valueOf(r0));
        }
    };
    protected Context mContext = null;

    public c(e eVar) {
        super(eVar, b.gKN, "fmessage_conversation", hUJ);
        this.gLA = eVar;
        this.mContext = ad.getContext();
    }

    public final Cursor Tq() {
        return this.gLA.rawQuery("select * from fmessage_conversation  ORDER BY lastModifiedTime DESC", null);
    }

    public final int getCount() {
        int i = 0;
        Cursor a = this.gLA.a("select count(*) from fmessage_conversation", null, 2);
        if (a.moveToFirst()) {
            i = a.getInt(0);
        }
        a.close();
        x.d("MicroMsg.FMessageConversationStorage", "getCount = " + i);
        return i;
    }

    public final boolean T(String str, int i) {
        if (str == null || str.length() == 0) {
            x.w("MicroMsg.FMessageConversationStorage", "updateState fail, talker is null");
            return false;
        }
        com.tencent.mm.sdk.e.c mX = mX(str);
        if (mX == null) {
            x.w("MicroMsg.FMessageConversationStorage", "updateState fail, get fail, talker = " + str);
            return false;
        } else if (i == mX.field_state) {
            x.d("MicroMsg.FMessageConversationStorage", "updateState, no need to update");
            return true;
        } else {
            mX.field_state = i;
            mX.field_lastModifiedTime = System.currentTimeMillis();
            if (!super.c(mX, new String[0])) {
                return false;
            }
            WI(str);
            return true;
        }
    }

    public final boolean Tr() {
        if (this.gLA.fD("fmessage_conversation", "update fmessage_conversation set isNew = 0")) {
            x.d("MicroMsg.FMessageConversationStorage", "clearAllNew success");
            doNotify();
            return true;
        }
        x.e("MicroMsg.FMessageConversationStorage", "clearAllNew fail");
        return false;
    }

    public final int Ts() {
        int i = 0;
        Cursor a = this.gLA.a(String.format("select count(*) from %s where %s = 1 and %s < 2", new Object[]{"fmessage_conversation", "isNew", "fmsgIsSend"}), null, 2);
        if (a.moveToFirst()) {
            i = a.getInt(0);
        }
        a.close();
        x.d("MicroMsg.FMessageConversationStorage", "getNewCount = " + i);
        return i;
    }

    public final List<String> Tt() {
        Cursor a = this.gLA.a(String.format("select %s from %s where isNew = 1 ORDER BY lastModifiedTime DESC limit %d", new Object[]{"contentNickname", "fmessage_conversation", Integer.valueOf(2)}), null, 2);
        List<String> arrayList = new ArrayList();
        while (a.moveToNext()) {
            arrayList.add(a.getString(a.getColumnIndex("contentNickname")));
        }
        a.close();
        return arrayList;
    }

    public final boolean mW(String str) {
        if (str == null || str.length() == 0) {
            x.w("MicroMsg.FMessageConversationStorage", "unsetNew fail, talker is null");
            return false;
        }
        com.tencent.mm.sdk.e.c mX = mX(str);
        if (mX == null || !str.equals(mX.field_talker)) {
            x.w("MicroMsg.FMessageConversationStorage", "unsetNew fail, conversation does not exist, talker = " + str);
            return false;
        }
        mX.field_isNew = 0;
        return super.c(mX, new String[0]);
    }

    public final b mX(String str) {
        if (str == null || str.length() == 0) {
            x.w("MicroMsg.FMessageConversationStorage", "get fail, talker is null");
            return null;
        }
        com.tencent.mm.sdk.e.c bVar = new b();
        bVar.field_talker = str;
        if (super.b(bVar, new String[0])) {
            return bVar;
        }
        x.i("MicroMsg.FMessageConversationStorage", "get fail, maybe not exist, talker = " + str);
        return null;
    }

    public final b mY(String str) {
        b bVar = null;
        if (str == null || str.length() == 0) {
            x.w("MicroMsg.FMessageConversationStorage", "get fail, encryptTalker is null");
        } else {
            Cursor a = this.gLA.a("select * from fmessage_conversation  where encryptTalker=" + h.fg(str), null, 2);
            if (a.moveToFirst()) {
                bVar = new b();
                bVar.b(a);
            }
            a.close();
        }
        return bVar;
    }

    public final void a(String str, l lVar) {
        int i = 0;
        if (str == null || str.length() == 0) {
            x.e("MicroMsg.FMessageConversationStorage", "onNotifyChange, id is null");
            return;
        }
        long j;
        try {
            j = bi.getLong(str, 0);
        } catch (Exception e) {
            x.w("MicroMsg.FMessageConversationStorage", "onNotifyChange, id = " + str + ", ex = " + e.getMessage());
            j = 0;
        }
        if (j == 0) {
            x.w("MicroMsg.FMessageConversationStorage", "onNotifyChange fail, sysRowId is invalid");
        } else if (g.Do().CF()) {
            com.tencent.mm.sdk.e.c fVar = new f();
            if (l.TD().b(j, fVar)) {
                x.d("MicroMsg.FMessageConversationStorage", "onNotifyChange succ, sysRowId = " + j);
                com.tencent.mm.sdk.e.c mX = l.TE().mX(fVar.field_talker);
                if (mX == null) {
                    x.i("MicroMsg.FMessageConversationStorage", "onNotifyChange, fmessage conversation does not exist, insert a new one, talker = " + fVar.field_talker);
                    if (bi.oN(fVar.field_talker)) {
                        x.i("MicroMsg.FMessageConversationStorage", "onNotifyChange, fmessage info talker is null, quit insert fmessage conversation.");
                        return;
                    }
                    com.tencent.mm.sdk.e.c bVar = new b();
                    if (fVar.field_type == 0) {
                        au.a XY = au.a.XY(fVar.field_msgContent);
                        bVar.field_displayName = XY.getDisplayName();
                        if (XY.scene == 4 && XY.ckv() != null) {
                            bVar.field_displayName = XY.ckv();
                        }
                        bVar.field_addScene = XY.scene;
                        bVar.field_isNew = 1;
                        bVar.field_contentFromUsername = XY.sfb;
                        bVar.field_contentNickname = XY.fqG;
                        bVar.field_contentPhoneNumMD5 = XY.xHI;
                        bVar.field_contentFullPhoneNumMD5 = XY.xHJ;
                        x.i("MicroMsg.FMessageConversationStorage", "push, new friend Username: " + bVar.field_contentFromUsername + "new friend Nickname: " + bVar.field_contentNickname);
                    } else if (fVar.Tv()) {
                        d Yb = d.Yb(fVar.field_msgContent);
                        bVar.field_displayName = Yb.getDisplayName();
                        bVar.field_addScene = Yb.scene;
                        bVar.field_isNew = 1;
                        bVar.field_contentFromUsername = Yb.sfb;
                        bVar.field_contentNickname = Yb.fqG;
                        bVar.field_contentVerifyContent = Yb.content;
                        x.i("MicroMsg.FMessageConversationStorage", "receive, new friend Username: " + bVar.field_contentFromUsername + "new friend Nickname: " + bVar.field_contentNickname);
                    }
                    bVar.field_lastModifiedTime = System.currentTimeMillis();
                    bVar.field_state = 0;
                    bVar.field_talker = fVar.field_talker;
                    bVar.field_encryptTalker = fVar.field_encryptTalker;
                    bVar.field_fmsgSysRowId = j;
                    bVar.field_fmsgIsSend = fVar.field_isSend;
                    bVar.field_fmsgType = fVar.field_type;
                    bVar.field_fmsgContent = fVar.field_msgContent;
                    if (fVar.Tv()) {
                        i = fVar.field_type;
                    }
                    bVar.field_recvFmsgType = i;
                    x.i("MicroMsg.FMessageConversationStorage", "field_fmsgContent: " + bVar.field_fmsgContent);
                    l.TE().b(bVar);
                } else {
                    x.d("MicroMsg.FMessageConversationStorage", "onNotifyChange, fmessage conversation has existed, talker = " + fVar.field_talker);
                    if (fVar.Tv()) {
                        mX.field_isNew = 1;
                    }
                    mX.field_lastModifiedTime = System.currentTimeMillis();
                    mX.field_encryptTalker = fVar.field_encryptTalker;
                    mX.field_fmsgSysRowId = j;
                    mX.field_fmsgIsSend = fVar.field_isSend;
                    mX.field_fmsgType = fVar.field_type;
                    mX.field_fmsgContent = fVar.field_msgContent;
                    if (fVar.Tv()) {
                        mX.field_recvFmsgType = fVar.field_type;
                        x.i("MicroMsg.FMessageConversationStorage", "field_recvFmsgType: " + mX.field_recvFmsgType);
                    }
                    if (fVar.field_type == 0) {
                        au.a XY2 = au.a.XY(fVar.field_msgContent);
                        mX.field_contentFromUsername = XY2.sfb;
                        mX.field_contentNickname = XY2.fqG;
                        mX.field_contentPhoneNumMD5 = XY2.xHI;
                        mX.field_contentFullPhoneNumMD5 = XY2.xHJ;
                        x.i("MicroMsg.FMessageConversationStorage", "TYPE_SYSTEM_PUSH, new friend Username: " + mX.field_contentFromUsername + "new friend Nickname: " + mX.field_contentNickname);
                    } else if (fVar.Tv()) {
                        if ((fVar.field_isSend >= 2 ? 1 : 0) == 0) {
                            d Yb2 = d.Yb(fVar.field_msgContent);
                            mX.field_contentVerifyContent = Yb2.content;
                            mX.field_contentFromUsername = Yb2.sfb;
                            mX.field_contentNickname = Yb2.fqG;
                            x.i("MicroMsg.FMessageConversationStorage", "field_contentVerifyContent: " + mX.field_contentVerifyContent + " receive, new friend Username: " + mX.field_contentFromUsername + " new friend Nickname: " + mX.field_contentNickname);
                            String str2 = mX.field_contentFromUsername;
                            String str3 = mX.field_contentNickname;
                            b klVar = new kl();
                            klVar.fCD.userName = str2;
                            klVar.fCD.bgo = str3;
                            klVar.fCD.type = 1;
                            com.tencent.mm.sdk.b.a.xmy.m(klVar);
                        }
                    }
                    l.TE().c(mX, new String[0]);
                    if (Ts() == 0) {
                        as.Hm();
                        com.tencent.mm.y.c.Db().set(340225, Long.valueOf(System.currentTimeMillis()));
                    }
                }
                Tu();
                return;
            }
            x.w("MicroMsg.FMessageConversationStorage", "onNotifyChange, get fail, id = " + j);
        } else {
            x.e("MicroMsg.FMessageConversationStorage", "onNotifyChange, account not ready, can not insert fmessageconversation");
        }
    }

    public final void Tu() {
        ah.K(this.hUK);
        ah.h(this.hUK, 500);
    }

    public final boolean d(long j, String str) {
        String str2;
        x.i("MicroMsg.FMessageConversationStorage", "deleteByTalker rowId: %d, talker: %s", Long.valueOf(j), str);
        if (!bi.oN(str)) {
            str2 = "delete from fmessage_conversation where talker = '" + bi.oL(str) + "'";
        } else if (j <= 0) {
            return false;
        } else {
            str2 = "delete from fmessage_conversation where fmsgSysRowId = '" + j + "'";
        }
        if (!this.gLA.fD("fmessage_conversation", str2)) {
            return false;
        }
        x.i("MicroMsg.FMessageConversationStorage", "deleteByTalker success, rowId: %d, talker: %s", Long.valueOf(j), str);
        WI(str);
        return true;
    }
}
