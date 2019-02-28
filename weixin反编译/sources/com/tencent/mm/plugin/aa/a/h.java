package com.tencent.mm.plugin.aa.a;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.mm.a.g;
import com.tencent.mm.ap.o;
import com.tencent.mm.f.b.cg;
import com.tencent.mm.plugin.aa.a.b.c;
import com.tencent.mm.plugin.aa.b;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.protocal.c.y;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bj;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.w;
import com.tencent.mm.x.g.a;
import com.tencent.mm.y.bb;
import com.tencent.mm.y.q;
import com.tencent.mm.y.s;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

public final class h {
    private static synchronized void aG(String str, String str2) {
        boolean z = true;
        synchronized (h.class) {
            if (!bi.oN(str)) {
                a fV = a.fV(str);
                if (!(fV == null || bi.oN(fV.heA))) {
                    long j;
                    c oV = b.WJ().oV(fV.heA);
                    String str3 = "MicroMsg.AAUtil";
                    String str4 = "insertAAMsg, billNo: %s, chatroom: %s, oldRecord: %s, insertMsg: %s, localMsgId: %s";
                    Object[] objArr = new Object[5];
                    objArr[0] = fV.heA;
                    objArr[1] = str2;
                    objArr[2] = oV;
                    if (oV == null || !oV.field_insertmsg) {
                        z = false;
                    }
                    objArr[3] = Boolean.valueOf(z);
                    if (oV != null) {
                        j = oV.field_localMsgId;
                    } else {
                        j = 0;
                    }
                    objArr[4] = Long.valueOf(j);
                    x.i(str3, str4, objArr);
                    if (oV == null) {
                        x.e("MicroMsg.AAUtil", "insertAAMsg, record is null!!");
                    } else if (!oV.field_insertmsg || oV.field_localMsgId <= 0) {
                        cg auVar = new au();
                        auVar.aq(bb.hU(str2));
                        auVar.setType(436207665);
                        auVar.setContent(q.FY() + ":\n" + str);
                        String s = g.s((bi.Wy()).getBytes());
                        String fullPath = o.PC().getFullPath(s);
                        o.PC();
                        s = com.tencent.mm.ap.g.lo(s);
                        com.tencent.mm.ap.a.a PG = o.PG();
                        String str5 = fV.hek;
                        com.tencent.mm.ap.a.a.c.a aVar = new com.tencent.mm.ap.a.a.c.a();
                        aVar.hFn = fullPath;
                        aVar.hFl = true;
                        PG.a(str5, null, aVar.PQ());
                        auVar.dV(s);
                        auVar.eS(1);
                        auVar.dU(str2);
                        auVar.eR(3);
                        auVar.ao(bb.i(auVar));
                        x.i("MicroMsg.AAUtil", "finish insert aa msg");
                        a(fV.heA, true, auVar.field_msgId);
                        com.tencent.mm.x.g gVar = new com.tencent.mm.x.g();
                        fV.a(gVar);
                        gVar.field_msgId = auVar.field_msgId;
                        com.tencent.mm.plugin.y.a.biU().b((com.tencent.mm.sdk.e.c) gVar);
                    }
                }
            }
        }
    }

    public static synchronized void a(String str, boolean z, long j) {
        synchronized (h.class) {
            if (!bi.oN(str)) {
                x.i("MicroMsg.AAUtil", "insertOrUpdateAARecord, billNo: %s, insertMsg: %s", str, Boolean.valueOf(z));
                c cVar = new c();
                cVar.field_billNo = str;
                cVar.field_insertmsg = z;
                cVar.field_localMsgId = j;
                b.WJ().b(cVar);
            }
        }
    }

    public static synchronized void aH(String str, String str2) {
        boolean z = true;
        synchronized (h.class) {
            if (!bi.oN(str)) {
                a fV = a.fV(str);
                String str3 = "MicroMsg.AAUtil";
                String str4 = "checkIfInsertAAMsg, billNo: %s, appMsgContent: %s";
                Object[] objArr = new Object[2];
                objArr[0] = fV != null ? fV.heA : "";
                objArr[1] = str.trim().replace(" ", "");
                x.d(str3, str4, objArr);
                if (!(fV == null || bi.oN(fV.heA))) {
                    boolean z2;
                    long j;
                    String str5 = fV.heA;
                    c oV = b.WJ().oV(str5);
                    str4 = "MicroMsg.AAUtil";
                    String str6 = "checkIfInsertAAMsg, record==null: %s, billNo: %s, insertMsg: %s, chatroom: %s, localMsgId: %s";
                    Object[] objArr2 = new Object[5];
                    if (oV == null) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    objArr2[0] = Boolean.valueOf(z2);
                    objArr2[1] = str5;
                    if (oV == null || !oV.field_insertmsg) {
                        z = false;
                    }
                    objArr2[2] = Boolean.valueOf(z);
                    objArr2[3] = str2;
                    if (oV != null) {
                        j = oV.field_localMsgId;
                    } else {
                        j = 0;
                    }
                    objArr2[4] = Long.valueOf(j);
                    x.i(str4, str6, objArr2);
                    if (oV != null && oV.field_insertmsg && oV.field_localMsgId > 0 && ((com.tencent.mm.plugin.messenger.foundation.a.h) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aZO().dI(oV.field_localMsgId).field_msgId <= 0) {
                        x.i("MicroMsg.AAUtil", "checkIfInsertAAMsg, the oldMsgInfo has deleted, ignore this");
                        b.WJ().a(oV, new String[0]);
                    } else if (oV == null || !oV.field_insertmsg || oV.field_localMsgId <= 0) {
                        x.i("MicroMsg.AAUtil", "checkIfInsertAAMsg, insert new aa msg");
                        aG(str, str2);
                    } else {
                        x.i("MicroMsg.AAUtil", "checkIfInsertAAMsg, update aa msg");
                        g(oV.field_localMsgId, str);
                    }
                }
            }
        }
    }

    public static synchronized void t(String str, String str2, String str3) {
        synchronized (h.class) {
            x.i("MicroMsg.AAUtil", "setAARecordAfterLaunchAA, billNo: %s, chatroom: %s, msgContent==null:%s, oldRecord: %s", str, str2, Boolean.valueOf(bi.oN(str3)), b.WJ().oV(str));
            if (b.WJ().oV(str) == null) {
                a(str, false, 0);
            }
            aH(str3, str2);
        }
    }

    public static synchronized void b(String str, String str2, String str3, String str4, String str5) {
        boolean z = true;
        synchronized (h.class) {
            x.d("MicroMsg.AAUtil", "insertPayMsgAfterPaySucc, launcherUsername: %s, billNo: %s, payMsgId: %s", str, str3, str4);
            if (!(bi.oN(str) || bi.oN(str3) || bi.oN(str4))) {
                com.tencent.mm.plugin.aa.a.b.a oU = b.WK().oU(str4);
                String str6 = "MicroMsg.AAUtil";
                String str7 = "insertPayMsgAfterPaySucc, launcherUsername: %s, chatroom: %s, payMsgId: %s, record: %s, insertmsg: %s";
                Object[] objArr = new Object[5];
                objArr[0] = str;
                objArr[1] = str2;
                objArr[2] = str4;
                objArr[3] = oU;
                if (oU == null || !oU.field_insertmsg) {
                    z = false;
                }
                objArr[4] = Boolean.valueOf(z);
                x.i(str6, str7, objArr);
                if (oU == null || !oU.field_insertmsg) {
                    String str8 = "weixin://weixinnewaa/opendetail?billno=" + str3 + "&launcherusername=" + str;
                    if (bi.oN(str5)) {
                        x.i("MicroMsg.AAUtil", "empty msgxml, insert local msgcontent");
                        if (str.equals(q.FY())) {
                            str5 = ad.getContext().getString(i.uSJ, new Object[]{str8});
                        } else {
                            String L = ((com.tencent.mm.plugin.messenger.a.b) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.messenger.a.b.class)).L(str, str2);
                            str5 = ad.getContext().getString(i.uSK, new Object[]{L, str8});
                        }
                    } else {
                        x.d("MicroMsg.AAUtil", "insert msgxml: %s", str5);
                    }
                    a(str5, str2, oU, str4);
                }
            }
        }
    }

    public static synchronized void u(String str, String str2, String str3) {
        synchronized (h.class) {
            try {
                if (!(bi.oN(str) || bi.oN(str2) || bi.oN(str3))) {
                    x.i("MicroMsg.AAUtil", "checkIfInsertPaySysMsg, chatroom: %s, payMsgId: %s", str2, str3);
                    com.tencent.mm.plugin.aa.a.b.a oU = b.WK().oU(str3);
                    if (oU == null || !oU.field_insertmsg) {
                        x.i("MicroMsg.AAUtil", "checkIfInsertPaySysMsg, insert new msg");
                        a(str, str2, oU, str3);
                    } else {
                        au dI = ((com.tencent.mm.plugin.messenger.foundation.a.h) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aZO().dI(oU.field_msgId);
                        x.i("MicroMsg.AAUtil", "checkIfInsertPaySysMsg, update old one, msgId: %s, dbMsginfo.id: %s", Long.valueOf(oU.field_msgId), Long.valueOf(dI.field_msgId));
                        dI.setContent(str);
                        ((com.tencent.mm.plugin.messenger.foundation.a.h) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aZO().a(oU.field_msgId, dI);
                    }
                }
            } catch (Exception e) {
                x.e("MicroMsg.AAUtil", "checkIfInsertPaySysMsg error: %s", e.getMessage());
            }
        }
        return;
    }

    private static synchronized void a(String str, String str2, com.tencent.mm.plugin.aa.a.b.a aVar, String str3) {
        synchronized (h.class) {
            com.tencent.mm.sdk.e.c aVar2;
            au auVar = new au();
            auVar.eS(0);
            auVar.dU(str2);
            auVar.eR(3);
            auVar.setContent(str);
            auVar.aq(bb.n(str2, System.currentTimeMillis() / 1000));
            auVar.setType(10000);
            long Q = ((com.tencent.mm.plugin.messenger.foundation.a.h) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aZO().Q(auVar);
            x.i("MicroMsg.AAUtil", "insertPaySysMsg, inserted msgId: %s", Long.valueOf(Q));
            if (aVar2 == null) {
                aVar2 = new com.tencent.mm.plugin.aa.a.b.a();
            }
            if (Q > 0) {
                aVar2.field_payMsgId = str3;
                aVar2.field_chatroom = str2;
                aVar2.field_insertmsg = true;
                aVar2.field_msgId = Q;
                b.WK().a(aVar2);
            }
        }
    }

    public static synchronized void g(long j, String str) {
        synchronized (h.class) {
            if (j > 0) {
                if (!bi.oN(str)) {
                    a fV = a.fV(str);
                    if (fV == null || bi.oN(fV.heA)) {
                        x.e("MicroMsg.AAUtil", "updateAARecordMsgAfterReceive, parse app msg failed, msgId: %s", Long.valueOf(j));
                    } else {
                        x.i("MicroMsg.AAUtil", "updateAARecordMsgAfterReceive, msgId: %s, billNo: %s", Long.valueOf(j), fV.heA);
                        c oV = b.WJ().oV(fV.heA);
                        if (oV != null) {
                            long j2 = oV.field_localMsgId;
                            au dI = ((com.tencent.mm.plugin.messenger.foundation.a.h) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aZO().dI(j2);
                            if (dI.field_msgId > 0) {
                                dI.setContent(bb.hS(dI.field_content) + ":\n" + str);
                                ((com.tencent.mm.plugin.messenger.foundation.a.h) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aZO().a(j2, dI);
                                x.i("MicroMsg.AAUtil", "updateAARecordMsgAfterReceive, update success, oldMsgId: %s, billNo: %s", Long.valueOf(j2), oV.field_billNo);
                            } else {
                                x.e("MicroMsg.AAUtil", "updateAARecordMsgAfterReceive, cannot find old msg, insert new one, billNo: %s, oldMsgId: %s, newMsgId: %s, needUpdateInfo.msgId: %s", oV.field_billNo, Long.valueOf(oV.field_localMsgId), Long.valueOf(j), Long.valueOf(dI.field_msgId));
                            }
                        } else {
                            oV = new c();
                            oV.field_localMsgId = j;
                            oV.field_billNo = fV.heA;
                            oV.field_insertmsg = true;
                            b.WJ().a(oV);
                            x.i("MicroMsg.AAUtil", "updateAARecordMsgAfterReceive, insert new aa record, msgId: %s, billNo: %s", Long.valueOf(j), fV.heA);
                        }
                    }
                }
            }
            x.e("MicroMsg.AAUtil", "updateAARecordMsgAfterReceive, msgContent is null or msgId invalid, msgId: %s, %s", Long.valueOf(j), Boolean.valueOf(bi.oN(str)));
        }
    }

    public static void h(long j, String str) {
        x.i("MicroMsg.AAUtil", "do update sys msg, %s, %s", Long.valueOf(j), str);
        au dI = ((com.tencent.mm.plugin.messenger.foundation.a.h) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aZO().dI(j);
        String oR = oR(str);
        if (!bi.oN(oR)) {
            dI.setContent(oR);
        }
        ((com.tencent.mm.plugin.messenger.foundation.a.h) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aZO().a(j, dI);
    }

    public static boolean a(Activity activity, y yVar) {
        if (yVar.vKC == 1) {
            x.i("MicroMsg.AAUtil", "need realname verify");
            Bundle bundle = new Bundle();
            bundle.putString("realname_verify_process_jump_activity", ".ui.LaunchAAUI");
            bundle.putString("realname_verify_process_jump_plugin", "aa");
            String str = yVar.oja;
            str = yVar.ojb;
            str = yVar.ojc;
            return com.tencent.mm.plugin.wallet_core.id_verify.util.a.a(activity, bundle, 0);
        } else if (yVar.vKC == 2) {
            x.i("MicroMsg.AAUtil", "need upload credit");
            return com.tencent.mm.plugin.wallet_core.id_verify.util.a.a(activity, yVar.oja, yVar.ojd, yVar.ojb, yVar.ojc, false, null);
        } else {
            x.i("MicroMsg.AAUtil", "realnameGuideFlag =  " + yVar.vKC);
            return false;
        }
    }

    private static String oR(String str) {
        UnsupportedEncodingException e;
        String str2 = (String) bj.y(str, "sysmsg").get(".sysmsg.paymsg.appmsgcontent");
        if (bi.oN(str2)) {
            x.e("MicroMsg.AAUtil", "empty appmsgcontent!");
            return "";
        }
        String str3 = "";
        try {
            str2 = URLDecoder.decode(str2, "UTF-8");
            try {
                x.d("MicroMsg.AAUtil", "msgContent: %s", str2);
                return str2;
            } catch (UnsupportedEncodingException e2) {
                e = e2;
            }
        } catch (UnsupportedEncodingException e3) {
            UnsupportedEncodingException unsupportedEncodingException = e3;
            str2 = str3;
            e = unsupportedEncodingException;
        }
        x.e("MicroMsg.AAUtil", e.getMessage());
        return str2;
    }

    public static double b(String str, String str2, int i, int i2) {
        try {
            return new BigDecimal(bi.getDouble(str.trim(), 0.0d) == 0.0d ? "0" : str.trim()).divide(new BigDecimal(str2.trim()), i, i2).doubleValue();
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.AAUtil", e, "", new Object[0]);
            return 0.0d;
        }
    }

    public static long aI(String str, String str2) {
        try {
            double d = bi.getDouble(str, 0.0d);
            double d2 = bi.getDouble(str2, 0.0d);
            if (d == 0.0d) {
                str = "0";
            }
            BigDecimal bigDecimal = new BigDecimal(str);
            if (d2 == 0.0d) {
                str2 = "0";
            }
            return bigDecimal.multiply(new BigDecimal(str2)).longValue();
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.AAUtil", e, "", new Object[0]);
            return 0;
        }
    }

    public static List<String> oS(String str) {
        List<String> hK;
        if (bi.oN(str)) {
            x.i("MicroMsg.AAUtil", "illegal chatroomName");
            return new ArrayList();
        } else if (s.eX(str)) {
            try {
                hK = ((com.tencent.mm.plugin.chatroom.b.b) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.chatroom.b.b.class)).Fo().hK(str);
                if (hK == null) {
                    return new ArrayList();
                }
                return hK;
            } catch (Exception e) {
                x.e("MicroMsg.AAUtil", "getChatroomMemberList error! %s", e.getMessage());
                return new ArrayList();
            }
        } else {
            hK = new ArrayList();
            hK.add(q.FY());
            hK.add(str);
            return hK;
        }
    }

    public static String WS() {
        com.tencent.mm.kernel.g.Dr();
        return bi.oM((String) com.tencent.mm.kernel.g.Dq().Db().get(w.a.USERINFO_RECENT_LAUNCH_AA_GROUP_STRING_SYNC, null));
    }

    public static void oT(String str) {
        String WS = WS();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(",");
        if (!bi.oN(WS)) {
            String[] split = WS.split(",");
            int i = 1;
            for (String str2 : split) {
                if (!str2.equals(str) && i < 5) {
                    stringBuilder.append(str2);
                    stringBuilder.append(",");
                    i++;
                }
            }
        }
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        x.d("MicroMsg.AAUtil", "recent group: %s", stringBuilder.toString());
        com.tencent.mm.kernel.g.Dr();
        com.tencent.mm.kernel.g.Dq().Db().a(w.a.USERINFO_RECENT_LAUNCH_AA_GROUP_STRING_SYNC, stringBuilder.toString());
    }
}
