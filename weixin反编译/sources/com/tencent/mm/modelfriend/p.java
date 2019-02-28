package com.tencent.mm.modelfriend;

import android.database.Cursor;
import android.text.TextUtils;
import com.tencent.mm.bx.g;
import com.tencent.mm.bx.g.a;
import com.tencent.mm.bx.h;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;

public final class p extends i<o> implements a {
    public static final String[] gLy = new String[]{i.a(o.gKN, "GoogleFriend")};
    public e gLA;
    public m hxW = new m() {
        protected final boolean NK() {
            if (p.this.gLA != null && !p.this.gLA.chz()) {
                return true;
            }
            String str = "MicroMsg.GoogleContact.GoogleFriendUI";
            String str2 = "shouldProcessEvent db is close :%s";
            Object[] objArr = new Object[1];
            objArr[0] = p.this.gLA == null ? "null" : Boolean.valueOf(p.this.gLA.chz());
            x.w(str, str2, objArr);
            return false;
        }
    };

    public final /* synthetic */ boolean b(c cVar) {
        return a((o) cVar);
    }

    public p(e eVar) {
        super(eVar, o.gKN, "GoogleFriend", null);
        this.gLA = eVar;
    }

    public final String getTableName() {
        return "GoogleFriend";
    }

    public final int a(g gVar) {
        if (gVar != null) {
            this.gLA = gVar;
        }
        return 0;
    }

    private boolean a(o oVar) {
        if (oVar == null) {
            return false;
        }
        if (((int) this.gLA.insert("GoogleFriend", "googleitemid", oVar.vP())) > 0) {
            return true;
        }
        return false;
    }

    public final boolean f(ArrayList<o> arrayList) {
        int i = 0;
        if (arrayList.size() <= 0) {
            x.d("MicroMsg.GoogleContact.GoogleFriendUI", "insertList . list is null.");
            return false;
        }
        long dA;
        h hVar;
        if (this.gLA instanceof h) {
            h hVar2 = (h) this.gLA;
            dA = hVar2.dA(Thread.currentThread().getId());
            x.i("MicroMsg.GoogleContact.GoogleFriendUI", "surround insertList in a transaction, ticket = %d", Long.valueOf(dA));
            hVar = hVar2;
        } else {
            hVar = null;
            dA = -1;
        }
        while (i < arrayList.size()) {
            a((o) arrayList.get(i));
            i++;
        }
        if (hVar != null) {
            hVar.fT(dA);
            x.i("MicroMsg.GoogleContact.GoogleFriendUI", "end updateList transaction");
        }
        this.hxW.b(2, this.hxW, "");
        return true;
    }

    public final Cursor lc(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        if (!TextUtils.isEmpty(str)) {
            stringBuilder.append(" WHERE ( ");
            stringBuilder.append("GoogleFriend.googleid='" + str + "'");
            stringBuilder.append(" ) ");
        }
        return this.gLA.rawQuery("SELECT GoogleFriend.googleid,GoogleFriend.googlename,GoogleFriend.googlephotourl,GoogleFriend.googlegmail,GoogleFriend.username,GoogleFriend.nickname,GoogleFriend.nicknameqp,GoogleFriend.usernamepy,GoogleFriend.small_url,GoogleFriend.big_url,GoogleFriend.ret,GoogleFriend.status,GoogleFriend.googleitemid,GoogleFriend.googlecgistatus,GoogleFriend.contecttype,GoogleFriend.googlenamepy FROM GoogleFriend  " + stringBuilder, null);
    }

    public final boolean b(o oVar) {
        Cursor a = this.gLA.a("SELECT GoogleFriend.googleid,GoogleFriend.googlename,GoogleFriend.googlephotourl,GoogleFriend.googlegmail,GoogleFriend.username,GoogleFriend.nickname,GoogleFriend.nicknameqp,GoogleFriend.usernamepy,GoogleFriend.small_url,GoogleFriend.big_url,GoogleFriend.ret,GoogleFriend.status,GoogleFriend.googleitemid,GoogleFriend.googlecgistatus,GoogleFriend.contecttype,GoogleFriend.googlenamepy FROM GoogleFriend   WHERE GoogleFriend.googleitemid = \"" + bi.oL(oVar.field_googleitemid) + "\"", null, 2);
        boolean moveToFirst = a.moveToFirst();
        a.close();
        if (!moveToFirst) {
            return a(oVar);
        }
        int update = this.gLA.update("GoogleFriend", oVar.vP(), new StringBuilder("googleitemid=?").toString(), new String[]{oVar.field_googleitemid});
        if (update > 0) {
            doNotify();
        }
        if (update <= 0) {
            return false;
        }
        return true;
    }

    public final boolean M(String str, int i) {
        return this.gLA.fD("GoogleFriend", "UPDATE GoogleFriend SET googlecgistatus='" + i + "' WHERE googleitemid='" + str + "'");
    }

    public final boolean N(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return this.gLA.fD("GoogleFriend", "UPDATE GoogleFriend SET googlecgistatus='" + i + "' , status='0" + "' WHERE username='" + str + "'");
    }

    public final void clear() {
        this.gLA.fD("GoogleFriend", " delete from GoogleFriend");
        this.hxW.b(5, this.hxW, "");
    }
}
