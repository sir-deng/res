package com.tencent.mm.af.a;

import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.af.a.b.a.b;
import com.tencent.mm.af.o;
import com.tencent.mm.af.y;
import com.tencent.mm.f.b.cg;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.plugin.n.c;
import com.tencent.mm.protocal.c.hr;
import com.tencent.mm.protocal.c.ws;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ae;
import com.tencent.mm.y.bb.a;
import java.io.File;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class e {
    public static String gkD = null;
    public static final Object hsB = new Object();

    /* renamed from: com.tencent.mm.af.a.e$1 */
    static class AnonymousClass1 implements Runnable {
        final /* synthetic */ a hgL = null;
        final /* synthetic */ String hsC;
        final /* synthetic */ boolean hsD;

        AnonymousClass1(String str, boolean z, a aVar) {
            this.hsC = str;
            this.hsD = z;
        }

        public final void run() {
            b Mo = y.Mo();
            String str = this.hsC;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("delete from BizChatConversation");
            stringBuilder.append(" where brandUserName = '").append(str).append("' ");
            x.i("MicroMsg.BizConversationStorage", "deleteByBrandUserName sql %s,%s", stringBuilder.toString(), Boolean.valueOf(Mo.gLA.fD("BizChatConversation", stringBuilder.toString())));
            if (Mo.gLA.fD("BizChatConversation", stringBuilder.toString())) {
                a aVar = new a();
                b bVar = new b();
                bVar.hsp = -1;
                bVar.fsi = str;
                bVar.hso = b.a.a.hsl;
                bVar.hsq = aVar;
                Mo.hpN.cb(bVar);
                Mo.hpN.doNotify();
            }
            ((h) g.h(h.class)).Fk().XE(this.hsC);
            d Mn = y.Mn();
            str = this.hsC;
            stringBuilder = new StringBuilder();
            stringBuilder.append("delete from BizChatInfo");
            stringBuilder.append(" where brandUserName = '").append(str).append("' ");
            x.i("MicroMsg.BizChatInfoStorage", "deleteByBrandUserName sql %s,%s", stringBuilder.toString(), Boolean.valueOf(Mn.gLA.fD("BizChatInfo", stringBuilder.toString())));
            if (Mn.gLA.fD("BizChatInfo", stringBuilder.toString())) {
                c cVar = new c();
                d.a.b bVar2 = new d.a.b();
                bVar2.hsp = -1;
                bVar2.fsi = str;
                bVar2.hsz = d.a.a.hsw;
                bVar2.hsA = cVar;
                Mn.hpN.cb(bVar2);
                Mn.hpN.doNotify();
            }
            com.tencent.mm.a.e.g(new File(e.bZ(this.hsC)));
            if (this.hsD) {
                k Mp = y.Mp();
                str = this.hsC;
                stringBuilder = new StringBuilder();
                stringBuilder.append("delete from BizChatUserInfo");
                stringBuilder.append(" where brandUserName = '").append(str).append("' ");
                x.i("MicroMsg.BizChatUserInfoStorage", "deleteByBrandUserName sql %s,%s", stringBuilder.toString(), Boolean.valueOf(Mp.gLA.fD("BizChatUserInfo", stringBuilder.toString())));
                if (Mp.gLA.fD("BizChatUserInfo", stringBuilder.toString())) {
                    j jVar = new j();
                    k.a.b bVar3 = new k.a.b();
                    bVar3.htb = k.a.a.hsY;
                    bVar3.htc = jVar;
                    Mp.hpN.cb(bVar3);
                    Mp.hpN.doNotify();
                }
                y.Mq().kz(this.hsC);
                com.tencent.mm.a.e.g(new File(e.kx(this.hsC)));
            }
            ah.y(new Runnable() {
                public final void run() {
                    if (AnonymousClass1.this.hgL != null) {
                        AnonymousClass1.this.hgL.HG();
                    }
                }
            });
        }

        public final String toString() {
            return super.toString() + "|deleteMsgByTalkers";
        }
    }

    public static boolean kp(String str) {
        if (str == null) {
            return false;
        }
        if (str.endsWith("@qy_u") || str.endsWith("@qy_g")) {
            return true;
        }
        return false;
    }

    public static boolean kq(String str) {
        if (str != null) {
            return str.endsWith("@qy_g");
        }
        x.i("MicroMsg.BizChatInfoStorageLogic", "isGroupChat chatId == null");
        return false;
    }

    public static boolean c(c cVar) {
        if (cVar == null) {
            return false;
        }
        List<String> My = cVar.My();
        String cb = ((com.tencent.mm.api.g) g.h(com.tencent.mm.api.g.class)).cb(cVar.field_brandUserName);
        if (cb == null) {
            x.w("MicroMsg.BaseBizChatInfo", "bizchat myUserId is null");
            return false;
        }
        for (String equals : My) {
            if (cb.equals(equals)) {
                return true;
            }
        }
        x.w("MicroMsg.BaseBizChatInfo", "bizchat not in chatroom myUserId is %s", cb);
        x.w("MicroMsg.BaseBizChatInfo", "bizchat not in chatroom memberlist is %s", Arrays.toString(My.toArray()));
        return false;
    }

    public static int aZ(long j) {
        List ba = ba(j);
        if (ba != null) {
            return ba.size();
        }
        x.w("MicroMsg.BizChatInfoStorageLogic", "getMembersCountByBizChatId list == null");
        return 0;
    }

    public static List<String> ba(long j) {
        return y.Mn().ag(j).My();
    }

    public static String kr(String str) {
        if (str == null) {
            x.w("MicroMsg.BizChatInfoStorageLogic", "getUserName bizChatId == null");
            return null;
        }
        j ca = y.Mp().ca(str);
        if (ca != null) {
            return ca.field_userName;
        }
        x.i("MicroMsg.BizChatInfoStorageLogic", "getUserName userInfo == null");
        return null;
    }

    public static String ks(String str) {
        j ca = y.Mp().ca(str);
        if (ca != null) {
            return ca.field_headImageUrl;
        }
        return null;
    }

    public static c a(c cVar, long j) {
        String str = "MicroMsg.BizChatInfoStorageLogic";
        String str2 = "protectBizChatNotExist bizChatId:%s BizChatInfo:%s ";
        Object[] objArr = new Object[2];
        objArr[0] = Long.valueOf(j);
        objArr[1] = Long.valueOf(cVar == null ? -1 : cVar.field_bizChatLocalId);
        x.w(str, str2, objArr);
        if (cVar != null) {
            return cVar;
        }
        c cVar2 = new c();
        cVar2.field_bizChatLocalId = j;
        y.Mn().b(cVar2);
        return y.Mn().ag(j);
    }

    public static j a(j jVar, String str) {
        String str2 = "MicroMsg.BizChatInfoStorageLogic";
        String str3 = "protectBizChatNotExist userId:%s BizChatUserInfo:%s ";
        Object[] objArr = new Object[2];
        objArr[0] = str;
        objArr[1] = jVar == null ? Integer.valueOf(-1) : jVar.field_userId;
        x.w(str2, str3, objArr);
        if (jVar != null) {
            return jVar;
        }
        j jVar2 = new j();
        jVar2.field_userId = str;
        y.Mp().b(jVar2);
        jVar = y.Mp().ca(str);
        if (jVar != null) {
            return jVar;
        }
        x.e("MicroMsg.BizChatInfoStorageLogic", "protectContactNotExist contact get from db is null!");
        return jVar2;
    }

    public static j kt(String str) {
        j jVar = null;
        if (bi.oN(str)) {
            x.w("MicroMsg.BizChatInfoStorageLogic", "getBizChatMyUserInfo brandUserName==null");
        } else {
            f ky = y.Mq().ky(str);
            if (ky == null) {
                x.w("MicroMsg.BizChatInfoStorageLogic", "getBizChatMyUserInfo bizChatMyUserInfo==null");
            } else {
                jVar = y.Mp().ca(ky.field_userId);
                if (jVar == null) {
                    x.w("MicroMsg.BizChatInfoStorageLogic", "getBizChatMyUserInfo bizChatUserInfo==null");
                }
            }
        }
        return jVar;
    }

    public static String ku(String str) {
        if (str == null) {
            x.w("MicroMsg.BizChatInfoStorageLogic", "getFormatMsgSource msgSource==null");
            return null;
        }
        int indexOf = str.indexOf("<enterprise_info>") + 17;
        int indexOf2 = str.indexOf("</enterprise_info>");
        if (indexOf == -1 || indexOf2 == -1 || indexOf >= indexOf2) {
            x.w("MicroMsg.BizChatInfoStorageLogic", "getFormatMsgSource error start:%s,end:%s", Integer.valueOf(indexOf), Integer.valueOf(indexOf2));
            return null;
        }
        CharSequence substring = str.substring(indexOf, indexOf2);
        return str.replace(substring, substring.replace("<", "&lt;").replace(">", "&gt;"));
    }

    public static String HJ() {
        String str;
        synchronized (hsB) {
            str = gkD;
        }
        return str;
    }

    public static String d(c cVar) {
        if (cVar == null) {
            x.w("MicroMsg.BizChatInfoStorageLogic", "getMsgSource bizChatInfo=%s");
            return null;
        }
        x.d("MicroMsg.BizChatInfoStorageLogic", "format msgSource");
        if (cVar.field_bizChatServId == null) {
            x.d("MicroMsg.BizChatInfoStorageLogic", "getMsgSource field_bizChatId=%s", cVar.field_bizChatServId);
            return null;
        }
        j kt = kt(cVar.field_brandUserName);
        if (kt == null || kt.field_userId == null) {
            x.d("MicroMsg.BizChatInfoStorageLogic", " bizChatMyUserInfo.field_userId is null getMsgSource field_bizChatId=%s", cVar.field_bizChatServId);
            return null;
        }
        synchronized (hsB) {
            gkD = String.format("<msgsource><enterprise_info><qy_msg_type>%d</qy_msg_type><bizchat_id>%s</bizchat_id><bizchat_ver>%d</bizchat_ver><user_id>%s</user_id></enterprise_info></msgsource>", new Object[]{Integer.valueOf(1), cVar.field_bizChatServId, Integer.valueOf(cVar.field_chatVersion), kt.field_userId});
        }
        x.d("MicroMsg.BizChatInfoStorageLogic", "send msgSource:%s", gkD);
        return gkD;
    }

    public static void kv(String str) {
        synchronized (hsB) {
            gkD = str;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.tencent.mm.af.a.c e(com.tencent.mm.af.a.c r4) {
        /*
        r3 = 1;
        r0 = r4.field_bizChatServId;
        if (r0 != 0) goto L_0x0007;
    L_0x0005:
        r4 = 0;
    L_0x0006:
        return r4;
    L_0x0007:
        r0 = com.tencent.mm.af.y.Mn();
        r1 = r4.field_bizChatServId;
        r0 = r0.ko(r1);
        if (r0 == 0) goto L_0x0057;
    L_0x0013:
        r1 = r4.field_chatVersion;
        r2 = r0.field_chatVersion;
        if (r1 > r2) goto L_0x0021;
    L_0x0019:
        r1 = r0.field_brandUserName;
        r1 = com.tencent.mm.sdk.platformtools.bi.oN(r1);
        if (r1 == 0) goto L_0x0063;
    L_0x0021:
        r1 = r4.field_chatName;
        r1 = com.tencent.mm.sdk.platformtools.bi.oN(r1);
        if (r1 != 0) goto L_0x002d;
    L_0x0029:
        r1 = r4.field_chatName;
        r0.field_chatName = r1;
    L_0x002d:
        r1 = r4.field_brandUserName;
        r0.field_brandUserName = r1;
        r0.field_needToUpdate = r3;
        r1 = r4.field_chatType;
        r0.field_chatType = r1;
        r1 = com.tencent.mm.af.y.Mn();
        r1.b(r0);
        r4 = r0;
    L_0x003f:
        r0 = r4.MA();
        if (r0 == 0) goto L_0x0006;
    L_0x0045:
        r0 = r4.Mz();
        if (r0 == 0) goto L_0x0065;
    L_0x004b:
        r0 = com.tencent.mm.af.y.Mr();
        r1 = r4.field_bizChatServId;
        r2 = r4.field_brandUserName;
        r0.ah(r1, r2);
        goto L_0x0006;
    L_0x0057:
        r4.field_needToUpdate = r3;
        r1 = com.tencent.mm.af.y.Mn();
        r1 = r1.a(r4);
        if (r1 != 0) goto L_0x003f;
    L_0x0063:
        r4 = r0;
        goto L_0x003f;
    L_0x0065:
        r0 = com.tencent.mm.af.y.Mr();
        r1 = r4.field_bizChatServId;
        r2 = r4.field_brandUserName;
        r0.ai(r1, r2);
        goto L_0x0006;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.af.a.e.e(com.tencent.mm.af.a.c):com.tencent.mm.af.a.c");
    }

    public static boolean f(c cVar) {
        x.d("MicroMsg.BizChatInfoStorageLogic", "updateBizChatMember");
        if (cVar == null) {
            x.w("MicroMsg.BizChatInfoStorageLogic", "updateBizChatMember: bizChatInfo == null");
            return false;
        }
        List<String> My = cVar.My();
        if (My == null) {
            x.w("MicroMsg.BizChatInfoStorageLogic", "updateBizChatMember: list == null");
            return false;
        }
        LinkedList linkedList = new LinkedList();
        for (String str : My) {
            j ca = y.Mp().ca(str);
            if (ca != null && ca.MA()) {
                linkedList.add(str);
            }
        }
        if (linkedList.size() > 0) {
            y.Mr().b(linkedList, cVar.field_brandUserName);
            return true;
        }
        x.w("MicroMsg.BizChatInfoStorageLogic", "updateBizChatMember: no need to update");
        return false;
    }

    public static String bb(long j) {
        return y.Mn().ag(j).field_bizChatServId;
    }

    public static long kw(String str) {
        if (bi.oN(str)) {
            x.w("MicroMsg.BizChatInfoStorageLogic", "chatId == null");
            return -1;
        }
        c ko = y.Mn().ko(str);
        if (ko != null) {
            return ko.field_bizChatLocalId;
        }
        x.w("MicroMsg.BizChatInfoStorageLogic", "bizChatInfo == null");
        return -1;
    }

    public static void A(String str, boolean z) {
        if (bi.oN(str)) {
            x.d("MicroMsg.BizChatInfoStorageLogic", "delEnterpriseChatConvAndHeadImg, empty brandUserName");
            return;
        }
        x.d("MicroMsg.BizChatInfoStorageLogic", "deleteMsgByTalkers");
        g.Dt().F(new AnonymousClass1(str, z, null));
    }

    public static void l(final String str, final String str2, final String str3) {
        x.i("MicroMsg.BizChatInfoStorageLogic", "qy_chat_update %s, %s, %s", str, str2, str3);
        g.Dt().F(new Runnable() {
            public final void run() {
                c ko = y.Mn().ko(str2);
                if (ko != null) {
                    if (ko.field_chatVersion < bi.getInt(str3, Integer.MAX_VALUE)) {
                        ko.field_needToUpdate = true;
                        y.Mn().b(ko);
                    }
                    if (ko.Mz()) {
                        y.Mr().ah(ko.field_bizChatServId, str);
                    } else {
                        y.Mr().ai(ko.field_bizChatServId, str);
                    }
                }
            }
        });
    }

    public static String bZ(String str) {
        return com.tencent.mm.api.a.bZ(str);
    }

    public static String kx(String str) {
        if (bi.oN(str)) {
            str = "tempUser";
        }
        StringBuilder stringBuilder = new StringBuilder(c.Fq());
        stringBuilder.append(com.tencent.mm.a.g.s(str.getBytes())).append("/");
        stringBuilder.append("user/");
        return stringBuilder.toString();
    }

    public static boolean a(c cVar, String str, String str2, ws wsVar) {
        if (!(str == null || bi.oN(cVar.field_brandUserName))) {
            try {
                JSONArray jSONArray = new JSONArray(str);
                if (jSONArray.length() == 1 && bi.oN(str2)) {
                    j jVar;
                    boolean z;
                    JSONObject jSONObject = jSONArray.getJSONObject(0);
                    String string = jSONObject.getString(SlookAirButtonFrequentContactAdapter.ID);
                    j ca = y.Mp().ca(string);
                    if (ca == null) {
                        jVar = new j();
                        z = true;
                    } else {
                        jVar = ca;
                        z = false;
                    }
                    jVar.field_userId = string;
                    jVar.field_userName = jSONObject.getString("nick_name");
                    jVar.field_headImageUrl = jSONObject.getString("head_img_url");
                    jVar.field_profileUrl = jSONObject.getString("profile_url");
                    jVar.field_UserVersion = jSONObject.getInt("ver");
                    if (jVar.field_brandUserName == null || jVar.field_brandUserName.length() == 0) {
                        jVar.field_brandUserName = cVar.field_brandUserName;
                        z = true;
                    }
                    if (jVar.field_addMemberUrl == null || jVar.field_addMemberUrl.length() == 0) {
                        jVar.field_addMemberUrl = cVar.field_addMemberUrl;
                        z = true;
                    }
                    if (!y.Mp().b(jVar)) {
                        y.Mp().a(jVar);
                    }
                    if (z) {
                        y.Mr().aj(jVar.field_userId, jVar.field_brandUserName);
                    }
                    c cVar2 = new c();
                    cVar2.field_bizChatServId = jVar.field_userId;
                    cVar2.field_brandUserName = jVar.field_brandUserName;
                    cVar2.field_chatName = jVar.field_userName;
                    cVar2.field_chatType = 1;
                    cVar2 = e(cVar2);
                    if (cVar2 == null) {
                        return false;
                    }
                    cVar.field_bizChatLocalId = cVar2.field_bizChatLocalId;
                    cVar.field_chatName = jVar.field_userName;
                    return true;
                }
                LinkedList linkedList = new LinkedList();
                if (!bi.oN(str2)) {
                    hr hrVar = new hr();
                    hrVar.vUi = str2;
                    linkedList.add(hrVar);
                }
                for (int i = 0; i < jSONArray.length(); i++) {
                    j jVar2 = new j();
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                    jVar2.field_userId = jSONObject2.getString(SlookAirButtonFrequentContactAdapter.ID);
                    jVar2.field_userName = jSONObject2.getString("nick_name");
                    jVar2.field_brandUserName = cVar.field_brandUserName;
                    jVar2.field_headImageUrl = jSONObject2.getString("head_img_url");
                    jVar2.field_profileUrl = jSONObject2.getString("profile_url");
                    jVar2.field_UserVersion = jSONObject2.getInt("ver");
                    jVar2.field_addMemberUrl = cVar.field_addMemberUrl;
                    if (!y.Mp().b(jVar2)) {
                        y.Mp().a(jVar2);
                    }
                    hr hrVar2 = new hr();
                    hrVar2.vUi = jVar2.field_userId;
                    linkedList.add(hrVar2);
                }
                wsVar.vUj = linkedList;
                cVar.field_bizChatLocalId = -1;
                return true;
            } catch (Throwable e) {
                x.i("MicroMsg.BizChatInfoStorageLogic", "parse memberJson Exception:%s", e.getMessage());
                x.printErrStackTrace("MicroMsg.BizChatInfoStorageLogic", e, "", new Object[0]);
            }
        }
        return false;
    }

    public static void g(c cVar) {
        if (cVar == null) {
            x.w("MicroMsg.BizChatInfoStorageLogic", "bizChatInfo is null");
            return;
        }
        boolean aW = y.Mo().aW(cVar.field_bizChatLocalId);
        boolean hr = cVar.hr(16);
        x.d("MicroMsg.BizChatInfoStorageLogic", "convPlaceTop: %s ,bizChatPlaceTop: %s, chatName: %s ", Boolean.valueOf(aW), Boolean.valueOf(hr), cVar.field_chatName);
        if (hr && !aW) {
            y.Mo().aX(cVar.field_bizChatLocalId);
        } else if (!hr && aW) {
            y.Mo().aY(cVar.field_bizChatLocalId);
        }
    }

    public static void h(c cVar) {
        if (cVar == null) {
            x.w("MicroMsg.BizChatInfoStorageLogic", "updateBrandUserConvName bizChatInfo is null");
            return;
        }
        ae XF = ((h) g.h(h.class)).Fk().XF(cVar.field_brandUserName);
        if (XF == null) {
            x.w("MicroMsg.BizChatInfoStorageLogic", "updateBrandUserConvName cvs is null");
            return;
        }
        cg Fd = ((h) g.h(h.class)).aZO().Fd(cVar.field_brandUserName);
        cg ao = ((o) g.h(o.class)).Fi().ao(cVar.field_brandUserName, cVar.field_bizChatLocalId);
        if (Fd != null && ao != null && Fd.field_msgId == ao.field_msgId) {
            String str = XF.field_digest;
            if (str != null) {
                int indexOf = str.indexOf(":");
                if (indexOf != -1) {
                    String substring = str.substring(0, indexOf);
                    str = str.substring(indexOf + 1);
                    if (substring != null && !substring.equals(cVar.field_chatName)) {
                        XF.dH(cVar.field_chatName + ":" + str);
                        ((h) g.h(h.class)).Fk().a(XF, XF.field_username);
                    }
                }
            }
        }
    }
}
