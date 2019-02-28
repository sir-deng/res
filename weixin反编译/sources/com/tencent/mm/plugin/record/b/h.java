package com.tencent.mm.plugin.record.b;

import android.content.Context;
import android.graphics.Bitmap.CompressFormat;
import android.util.SparseIntArray;
import com.tencent.mm.R;
import com.tencent.mm.a.f;
import com.tencent.mm.ac.b;
import com.tencent.mm.af.a.e;
import com.tencent.mm.ap.o;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.f.a.cg;
import com.tencent.mm.f.a.ry;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.pluginsdk.model.app.am;
import com.tencent.mm.pluginsdk.model.app.an;
import com.tencent.mm.protocal.b.a.c;
import com.tencent.mm.protocal.b.a.d;
import com.tencent.mm.protocal.c.uz;
import com.tencent.mm.protocal.c.va;
import com.tencent.mm.protocal.c.vb;
import com.tencent.mm.protocal.c.vg;
import com.tencent.mm.protocal.c.vh;
import com.tencent.mm.protocal.c.vm;
import com.tencent.mm.protocal.c.vn;
import com.tencent.mm.protocal.c.vw;
import com.tencent.mm.protocal.c.wc;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bj;
import com.tencent.mm.sdk.platformtools.p;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.x.g.a;
import com.tencent.mm.y.as;
import com.tencent.mm.y.bb;
import com.tencent.mm.y.m;
import com.tencent.mm.y.q;
import com.tencent.mm.y.r;
import com.tencent.mm.y.s;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public final class h {
    private static final f<Integer, c> hfz = new f(32);

    public static String a(String str, String str2, vn vnVar, String str3) {
        if (vnVar == null || vnVar.wlY == null) {
            x.e("MicroMsg.RecordMsgLogic", "buildRecordAppMsgXML error: protoItem or datalist is null");
            return "";
        }
        List list = vnVar.wlY;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<recordinfo>");
        stringBuilder.append("<title>").append(bi.Wm(str)).append("</title>");
        stringBuilder.append("<desc>").append(bi.Wm(str2)).append("</desc>");
        a(stringBuilder, vnVar);
        stringBuilder.append(i.aI(list));
        stringBuilder.append("<favusername>").append(bi.Wm(str3)).append("</favusername>");
        stringBuilder.append("</recordinfo>");
        a aVar = new a();
        aVar.title = str;
        aVar.description = str2;
        if (bi.oN(((uz) list.get(0)).wkc) || !((uz) list.get(0)).wkc.equals(".htm")) {
            aVar.type = 19;
            aVar.url = "https://support.weixin.qq.com/cgi-bin/mmsupport-bin/readtemplate?t=page/favorite_record__w_unsupport&from=singlemessage&isappinstalled=0";
        } else {
            aVar.type = 24;
            aVar.url = "https://support.weixin.qq.com/cgi-bin/mmsupport-bin/readtemplate?t=page/common_page__upgrade&btn_text=btn_text_0&text=text008";
        }
        aVar.action = "view";
        aVar.hdm = stringBuilder.toString();
        return a.a(aVar, null, null);
    }

    public static a a(String str, String str2, vn vnVar) {
        List list = vnVar.wlY;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<recordinfo>");
        stringBuilder.append("<title>").append(bi.Wm(str)).append("</title>");
        stringBuilder.append("<desc>").append(bi.Wm(str2)).append("</desc>");
        a(stringBuilder, vnVar);
        stringBuilder.append(i.aI(list));
        stringBuilder.append("<favusername>").append(bi.Wm(q.FY())).append("</favusername>");
        stringBuilder.append("</recordinfo>");
        a aVar = new a();
        aVar.title = str;
        if (str2 != null && str2.length() > 200) {
            str2 = str2.substring(0, 200);
        }
        aVar.description = str2;
        if (bi.cC(list) || bi.oN(((uz) list.get(0)).wkc) || !((uz) list.get(0)).wkc.equals(".htm")) {
            aVar.type = 19;
            aVar.url = "https://support.weixin.qq.com/cgi-bin/mmsupport-bin/readtemplate?t=page/favorite_record__w_unsupport&from=singlemessage&isappinstalled=0";
        } else {
            aVar.type = 24;
            aVar.url = "https://support.weixin.qq.com/cgi-bin/mmsupport-bin/readtemplate?t=page/common_page__upgrade&btn_text=btn_text_0&text=text008";
        }
        aVar.action = "view";
        aVar.hdm = stringBuilder.toString();
        return aVar;
    }

    private static void a(StringBuilder stringBuilder, vn vnVar) {
        if (vnVar.vJG != null) {
            stringBuilder.append("<noteinfo>");
            stringBuilder.append("<noteauthor>").append(bi.Wm(vnVar.vJG.wlP)).append("</noteauthor>");
            stringBuilder.append("<noteeditor>").append(bi.Wm(vnVar.vJG.wlQ)).append("</noteeditor>");
            stringBuilder.append("</noteinfo>");
            stringBuilder.append("<edittime>").append(vnVar.vJH).append("</edittime>");
        }
    }

    public static int a(Context context, String str, String str2, List<au> list, cg cgVar, d dVar) {
        if (bi.oN(str)) {
            x.w("MicroMsg.RecordMsgLogic", "send record msg error, touser is null");
            return -1;
        } else if (list == null || list.isEmpty()) {
            x.w("MicroMsg.RecordMsgLogic", "send record msg error, msginfo error");
            return -1;
        } else {
            if (cgVar == null || dVar == null) {
                cg cgVar2 = new cg();
                if (!com.tencent.mm.pluginsdk.model.h.a(context, cgVar2, str2, list, true, true)) {
                    return -1;
                }
                dVar = a(context, cgVar2, str2);
                cgVar = cgVar2;
            }
            a a = a(dVar.title, dVar.desc, cgVar.frk.frm);
            com.tencent.mm.f.b.cg auVar = new au();
            byte[] bArr = null;
            if (!bi.oN(dVar.fwx)) {
                bArr = bi.readFromFile(dVar.fwx);
            } else if (dVar.fFD == 0 && !bi.oN(dVar.mvs)) {
                bArr = com.tencent.mm.sdk.platformtools.d.Q(b.a(dVar.mvs, false, -1));
            }
            if (bArr != null) {
                String a2;
                if (bArr.length > WXMediaMessage.THUMB_LENGTH_LIMIT) {
                    a2 = o.PC().a(bArr, false, CompressFormat.JPEG);
                } else {
                    a2 = o.PC().f(8, bArr);
                }
                x.d("MicroMsg.RecordMsgLogic", g.zo() + " thumbData MsgInfo path:" + a2);
                if (!bi.oN(a2)) {
                    auVar.dV(a2);
                }
            }
            auVar.setContent(a.a(a, null, null));
            auVar.eR(1);
            auVar.dU(str);
            auVar.aq(bb.hU(str));
            auVar.eS(1);
            auVar.setType(49);
            if (com.tencent.mm.af.f.eG(str)) {
                auVar.ea(e.HJ());
            }
            as.Hm();
            long Q = com.tencent.mm.y.c.Fh().Q(auVar);
            x.d("MicroMsg.RecordMsgLogic", g.zo() + " msginfo insert id: " + Q);
            if (Q < 0) {
                x.e("MicroMsg.RecordMsgLogic", g.zo() + "insert msg failed :" + Q);
                return 0 - g.getLine();
            }
            x.i("MicroMsg.RecordMsgLogic", g.getLine() + " new msg inserted to db , local id = " + Q);
            auVar.ao(Q);
            com.tencent.mm.sdk.e.c gVar = new com.tencent.mm.x.g();
            gVar.field_xml = auVar.field_content;
            gVar.field_title = a.title;
            gVar.field_type = a.type;
            gVar.field_description = a.description;
            gVar.field_msgId = Q;
            an.bZF().b(gVar);
            Iterator it = cgVar.frk.frm.wlY.iterator();
            boolean z = false;
            while (it.hasNext()) {
                uz uzVar = (uz) it.next();
                String obj = uzVar.toString();
                uzVar.Ui(com.tencent.mm.a.g.s((obj + uzVar.bjS + System.currentTimeMillis()).getBytes()));
                if (z || com.tencent.mm.a.e.bO(uzVar.wkl) || com.tencent.mm.a.e.bO(uzVar.wkn) || !bi.oN(uzVar.wjN) || !bi.oN(uzVar.hcU)) {
                    z = true;
                }
            }
            x.d("MicroMsg.RecordMsgLogic", "summerrecord needNetScene:%b", Boolean.valueOf(z));
            if (z) {
                gVar = new com.tencent.mm.plugin.record.a.g();
                gVar.field_msgId = Q;
                gVar.field_title = a.title;
                gVar.field_desc = a.description;
                gVar.field_toUser = str;
                gVar.field_dataProto = cgVar.frk.frm;
                gVar.field_type = 3;
                gVar.field_localId = new Random().nextInt(2147483645) + 1;
                x.i("MicroMsg.RecordMsgLogic", "summerrecord needNetScene insert ret:%b, id:%d, localid:%d", Boolean.valueOf(n.bny().b(gVar)), Long.valueOf(Q), Integer.valueOf(gVar.field_localId));
                n.bnz().a(gVar);
            } else {
                x.d("MicroMsg.RecordMsgLogic", "summerrecord do not trans cdn, directly send msg id:%d", Long.valueOf(Q));
                an.bZH();
                am.a.fu(Q);
            }
            return 0;
        }
    }

    public static d a(Context context, cg cgVar, String str) {
        String str2;
        int i = 0;
        d dVar = new d();
        SparseIntArray sparseIntArray = new SparseIntArray();
        if (com.tencent.mm.af.f.eG(str)) {
            dVar.title = cgVar.frk.frm.title;
        } else if (s.eX(str)) {
            dVar.title = context.getString(R.l.eCN);
        } else {
            if (q.Ga().equals(r.gv(str))) {
                dVar.title = context.getString(R.l.egw, new Object[]{q.Ga()});
            } else {
                dVar.title = context.getString(R.l.egv, new Object[]{q.Ga(), r.gv(str)});
            }
        }
        x.d("MicroMsg.RecordMsgLogic", "msgInfo title %s", dVar.title);
        List linkedList = new LinkedList();
        List list;
        if (cgVar.frk.frm != null) {
            list = cgVar.frk.frm.wlY;
        } else {
            list = new LinkedList();
        }
        for (uz uzVar : list) {
            sparseIntArray.put(uzVar.bjS, sparseIntArray.get(uzVar.bjS) + 1);
            switch (uzVar.bjS) {
                case 1:
                    if (linkedList.size() >= 5) {
                        break;
                    }
                    linkedList.add(uzVar.wkJ + ":" + uzVar.desc + "\n");
                    break;
                case 2:
                    if (linkedList.size() < 5) {
                        linkedList.add(uzVar.wkJ + ":" + context.getString(R.l.dGu) + "\n");
                    }
                    if (i != 0) {
                        break;
                    }
                    a(dVar, uzVar, R.g.byW);
                    i = 1;
                    break;
                case 3:
                    if (linkedList.size() >= 5) {
                        break;
                    }
                    linkedList.add(uzVar.wkJ + ":" + context.getString(R.l.dHj) + "\n");
                    break;
                case 4:
                    if (linkedList.size() < 5) {
                        linkedList.add(uzVar.wkJ + ":" + context.getString(R.l.dHi) + "\n");
                    }
                    if (i != 0) {
                        break;
                    }
                    a(dVar, uzVar, R.k.dvL);
                    i = 1;
                    break;
                case 5:
                    if (linkedList.size() < 5) {
                        linkedList.add(uzVar.wkJ + ":" + context.getString(R.l.dHf) + uzVar.title + "\n");
                    }
                    if (i != 0) {
                        break;
                    }
                    a(dVar, uzVar, R.k.dvO);
                    i = 1;
                    break;
                case 6:
                    if (linkedList.size() < 5) {
                        vg vgVar = uzVar.wkH.wld;
                        StringBuilder append = new StringBuilder().append(uzVar.wkJ).append(":").append(context.getString(R.l.dFK));
                        str2 = (bi.oN(vgVar.fEp) || vgVar.fEp.equals(context.getString(R.l.etu))) ? vgVar.label : vgVar.fEp;
                        linkedList.add(append.append(str2).append("\n").toString());
                    }
                    if (i != 0) {
                        break;
                    }
                    dVar.fFD = R.k.dvx;
                    i = 1;
                    break;
                    break;
                case 7:
                    if (linkedList.size() < 5) {
                        linkedList.add(uzVar.wkJ + ":" + context.getString(R.l.dFU) + uzVar.title + "\n");
                    }
                    if (i != 0) {
                        break;
                    }
                    a(dVar, uzVar, R.k.dvy);
                    i = 1;
                    break;
                case 8:
                    if (linkedList.size() < 5) {
                        linkedList.add(uzVar.wkJ + ":" + context.getString(R.l.dFu) + uzVar.title + "\n");
                    }
                    if (i != 0) {
                        break;
                    }
                    a(dVar, uzVar, R.k.dvI);
                    i = 1;
                    break;
                case 10:
                case 11:
                    if (linkedList.size() < 5) {
                        linkedList.add(uzVar.wkJ + ":" + context.getString(R.l.dGw) + uzVar.wkH.wlh.title + "\n");
                    }
                    if (i != 0) {
                        break;
                    }
                    a(dVar, uzVar, R.k.dvI);
                    i = 1;
                    break;
                case 14:
                    if (linkedList.size() < 5) {
                        linkedList.add(uzVar.wkJ + ":" + context.getString(R.l.dDY) + "\n");
                    }
                    if (i != 0) {
                        break;
                    }
                    a(dVar, uzVar, R.k.dvI);
                    i = 1;
                    break;
                case 15:
                    if (linkedList.size() < 5) {
                        linkedList.add(uzVar.wkJ + ":" + context.getString(R.l.dHi) + "\n");
                    }
                    if (i != 0) {
                        break;
                    }
                    a(dVar, uzVar, R.k.dvL);
                    i = 1;
                    break;
                case 16:
                    if (linkedList.size() < 5) {
                        linkedList.add(uzVar.wkJ + ":" + context.getString(R.l.dFy) + "\n");
                    }
                    if (i != 0) {
                        break;
                    }
                    as.Hm();
                    dVar.mvs = com.tencent.mm.y.c.Fh().Fq(uzVar.desc).sfb;
                    i = 1;
                    break;
                case 17:
                    if (linkedList.size() >= 5) {
                        break;
                    }
                    linkedList.add(uzVar.wkJ + ":" + context.getString(R.l.dGD) + "\n");
                    break;
                default:
                    break;
            }
        }
        str2 = "";
        dVar.desc = "";
        Iterator it = linkedList.iterator();
        while (true) {
            String str3 = str2;
            if (it.hasNext()) {
                str2 = str3 + ((String) it.next());
            } else {
                str2 = str3.trim();
                if (linkedList.size() >= 5) {
                    str2 = str2 + "...";
                }
                dVar.desc = str2;
                return dVar;
            }
        }
    }

    private static void a(d dVar, uz uzVar, int i) {
        String str = uzVar.wkn;
        if (com.tencent.mm.a.e.bO(str)) {
            dVar.fwx = str;
        } else {
            dVar.fFD = i;
        }
    }

    public static int a(String str, String str2, au auVar) {
        if (bi.oN(str)) {
            x.w("MicroMsg.RecordMsgLogic", "send record msg error, touser is null");
            return -1;
        } else if (auVar == null || bi.oN(auVar.field_content)) {
            x.w("MicroMsg.RecordMsgLogic", "send record msg error, msginfo error");
            return -1;
        } else if (1 == auVar.field_status) {
            x.w("MicroMsg.RecordMsgLogic", "send record msg error, msginfo is sending");
            return -1;
        } else {
            for (String str3 : bi.F(str.split(","))) {
                x.i("MicroMsg.RecordMsgLogic", "send recordMsg, toUser[%s] msgId[%d], msgType[%d]", str3, Long.valueOf(auVar.field_msgId), Integer.valueOf(auVar.field_status));
                String hT = bb.hT(auVar.field_content);
                a fV = a.fV(hT);
                if (fV == null) {
                    x.w("MicroMsg.RecordMsgLogic", "send record msg error, parse appmsg error");
                    return -1;
                }
                c IP = IP(fV.hdm);
                if (IP == null) {
                    x.w("MicroMsg.RecordMsgLogic", "send record msg error, parse record data error");
                    return -1;
                }
                com.tencent.mm.f.b.cg auVar2 = new au();
                if (!bi.oN(auVar.field_imgPath)) {
                    String f = o.PC().f(8, bi.readFromFile(o.PC().B(auVar.field_imgPath, true)));
                    x.d("MicroMsg.RecordMsgLogic", g.zo() + " thumbData from msg MsgInfo path:" + f);
                    if (!bi.oN(f)) {
                        auVar2.dV(f);
                    }
                }
                auVar2.setContent(hT);
                auVar2.eR(1);
                auVar2.dU(str3);
                auVar2.aq(bb.hU(str3));
                auVar2.eS(1);
                auVar2.setType(49);
                as.Hm();
                long Q = com.tencent.mm.y.c.Fh().Q(auVar2);
                x.d("MicroMsg.RecordMsgLogic", g.zo() + " msginfo insert id: " + Q);
                if (Q < 0) {
                    x.e("MicroMsg.RecordMsgLogic", g.zo() + "insert msg failed :" + Q);
                    return 0 - g.getLine();
                }
                Object obj;
                x.i("MicroMsg.RecordMsgLogic", g.getLine() + " new msg inserted to db , local id = " + Q);
                auVar2.ao(Q);
                com.tencent.mm.sdk.b.b ryVar = new ry();
                ryVar.fKy.fKz = auVar.field_msgId;
                ryVar.fKy.fKA = Q;
                com.tencent.mm.sdk.b.a.xmy.m(ryVar);
                com.tencent.mm.sdk.e.c gVar = new com.tencent.mm.x.g();
                gVar.field_xml = auVar2.field_content;
                gVar.field_title = fV.title;
                gVar.field_type = fV.type;
                gVar.field_description = fV.description;
                gVar.field_msgId = Q;
                an.bZF().b(gVar);
                Iterator it = IP.hfI.iterator();
                while (it.hasNext()) {
                    uz uzVar = (uz) it.next();
                    if (bi.oN(uzVar.wjN)) {
                        if (!bi.oN(uzVar.hcU)) {
                        }
                    }
                    obj = 1;
                }
                obj = null;
                if (obj != null) {
                    gVar = new com.tencent.mm.plugin.record.a.g();
                    vn vnVar = new vn();
                    vnVar.wlY.addAll(IP.hfI);
                    gVar.field_msgId = Q;
                    gVar.field_oriMsgId = auVar.field_msgId;
                    gVar.field_toUser = str3;
                    gVar.field_title = fV.title;
                    gVar.field_desc = bi.aD(IP.desc, fV.description);
                    gVar.field_dataProto = vnVar;
                    gVar.field_type = 0;
                    gVar.field_favFrom = IP.vJF;
                    gVar.field_localId = new Random().nextInt(2147483645) + 1;
                    n.bny().b(gVar);
                    n.bnz().a(gVar);
                } else {
                    x.d("MicroMsg.RecordMsgLogic", "do not check upload, directly send msg");
                    an.bZH();
                    am.a.fu(Q);
                }
                if (!bi.oN(str2)) {
                    com.tencent.mm.plugin.messenger.a.f.aZN().C(str3, str2, s.hs(str3));
                }
            }
            return 0;
        }
    }

    public static int a(String str, vn vnVar, String str2, String str3, String str4, int i, String str5) {
        if (bi.oN(str)) {
            x.w("MicroMsg.RecordMsgLogic", "send record msg error, touser is null");
            return -1;
        } else if (vnVar == null || vnVar.wlY.isEmpty()) {
            x.w("MicroMsg.RecordMsgLogic", "send record msg error, favprotoitem error");
            return -1;
        } else {
            a a = a(str2, str3, vnVar);
            com.tencent.mm.f.b.cg auVar = new au();
            byte[] bArr = null;
            if (!bi.oN(str4)) {
                bArr = bi.readFromFile(str4);
            } else if (i != 0) {
                bArr = com.tencent.mm.sdk.platformtools.d.Q(com.tencent.mm.sdk.platformtools.d.Ds(i));
            } else if (!bi.oN(str5)) {
                bArr = com.tencent.mm.sdk.platformtools.d.Q(b.a(str5, false, -1));
            }
            if (bArr != null) {
                String a2;
                if (bArr.length > WXMediaMessage.THUMB_LENGTH_LIMIT) {
                    a2 = o.PC().a(bArr, false, CompressFormat.JPEG);
                } else {
                    a2 = o.PC().f(8, bArr);
                }
                x.d("MicroMsg.RecordMsgLogic", g.zo() + " thumbData MsgInfo path:" + a2);
                if (!bi.oN(a2)) {
                    auVar.dV(a2);
                }
            }
            auVar.setContent(a.a(a, null, null));
            auVar.eR(1);
            auVar.dU(str);
            auVar.aq(bb.hU(str));
            auVar.eS(1);
            auVar.setType(49);
            if (com.tencent.mm.af.f.eG(str)) {
                auVar.ea(e.HJ());
            }
            as.Hm();
            long Q = com.tencent.mm.y.c.Fh().Q(auVar);
            x.d("MicroMsg.RecordMsgLogic", g.zo() + " msginfo insert id: " + Q);
            if (Q < 0) {
                x.e("MicroMsg.RecordMsgLogic", g.zo() + "insert msg failed :" + Q);
                return 0 - g.getLine();
            }
            Object obj;
            x.i("MicroMsg.RecordMsgLogic", g.getLine() + " new msg inserted to db , local id = " + Q);
            auVar.ao(Q);
            com.tencent.mm.sdk.e.c gVar = new com.tencent.mm.x.g();
            gVar.field_xml = auVar.field_content;
            gVar.field_title = a.title;
            gVar.field_type = a.type;
            gVar.field_description = a.description;
            gVar.field_msgId = Q;
            an.bZF().b(gVar);
            Iterator it = vnVar.wlY.iterator();
            while (it.hasNext()) {
                uz uzVar = (uz) it.next();
                if (bi.oN(uzVar.wjN)) {
                    if (!bi.oN(uzVar.hcU)) {
                    }
                }
                obj = 1;
            }
            obj = null;
            if (obj != null || com.tencent.mm.pluginsdk.model.c.vjO) {
                gVar = new com.tencent.mm.plugin.record.a.g();
                gVar.field_msgId = Q;
                gVar.field_title = a.title;
                gVar.field_desc = a.description;
                gVar.field_toUser = str;
                gVar.field_dataProto = vnVar;
                gVar.field_type = 1;
                gVar.field_localId = new Random().nextInt(2147483645) + 1;
                n.bny().b(gVar);
                n.bnz().a(gVar);
            } else {
                x.d("MicroMsg.RecordMsgLogic", "do not trans cdn, directly send msg");
                an.bZH();
                am.a.fu(Q);
            }
            return 0;
        }
    }

    private static File ec(long j) {
        r2 = new Object[2];
        as.Hm();
        r2[0] = com.tencent.mm.y.c.FD();
        r2[1] = Long.valueOf(j);
        File file = new File(String.format("%s/%d/", r2));
        if (!(file.exists() && file.isDirectory())) {
            file.mkdirs();
        }
        return file;
    }

    public static void ed(long j) {
        boolean g = com.tencent.mm.a.e.g(ec(j));
        x.i("MicroMsg.RecordMsgLogic", "do clear resource, path %s, result %B", r0.getAbsolutePath(), Boolean.valueOf(g));
    }

    public static String c(uz uzVar, long j) {
        int i = 1;
        if (uzVar == null) {
            return "";
        }
        String str = uzVar.mBr;
        if (bi.oN(str) || !as.Hp()) {
            return "";
        }
        File file;
        String str2;
        File ec = ec(j);
        if (uzVar.bjS != 8 || bi.oN(uzVar.title)) {
            i = 0;
            file = ec;
            str2 = str;
        } else {
            str = uzVar.title;
            int hashCode = uzVar.mBr.hashCode() & 255;
            r6 = new Object[3];
            as.Hm();
            r6[0] = com.tencent.mm.y.c.FD();
            r6[1] = Long.valueOf(j);
            r6[2] = Integer.valueOf(hashCode);
            ec = new File(String.format("%s/%d/%d/", r6));
            if (!(ec.exists() && ec.isDirectory())) {
                ec.mkdirs();
            }
            file = ec;
            str2 = str;
        }
        if (uzVar.wkc != null && uzVar.wkc.trim().length() > 0 && i == 0) {
            str2 = str2 + "." + uzVar.wkc;
        }
        return new File(file, str2).getAbsolutePath();
    }

    public static boolean d(uz uzVar, long j) {
        return new File(c(uzVar, j)).exists();
    }

    public static boolean e(uz uzVar, long j) {
        return new File(f(uzVar, j)).exists();
    }

    public static String f(uz uzVar, long j) {
        if (uzVar == null || bi.oN(uzVar.mBr)) {
            return "";
        }
        return new File(ec(j), AH(uzVar.mBr)).getAbsolutePath();
    }

    public static String AH(String str) {
        return str + "_t";
    }

    public static String d(String str, long j, boolean z) {
        if (z) {
            return str + "@record_download@" + j;
        }
        return str + "@record_upload@" + j;
    }

    public static c IP(String str) {
        if (bi.oN(str)) {
            x.e("MicroMsg.RecordMsgLogic", "xml is null");
            return null;
        }
        int hashCode = str.hashCode();
        c cVar = (c) hfz.get(Integer.valueOf(hashCode));
        if (cVar != null) {
            x.d("MicroMsg.RecordMsgLogic", "get record msg data from cache");
            return cVar;
        }
        Map y;
        if (str.trim().startsWith("<recordinfo>")) {
            y = bj.y(str, "recordinfo");
        } else {
            y = bj.y("<recordinfo>" + str + "</recordinfo>", "recordinfo");
        }
        if (y == null) {
            x.e("MicroMsg.RecordMsgLogic", "values is null: %s", str);
            return null;
        }
        c cVar2 = new c();
        cVar2.title = (String) y.get(".recordinfo.title");
        cVar2.desc = (String) y.get(".recordinfo.desc");
        cVar2.vJF = (String) y.get(".recordinfo.favusername");
        if (y.get(".recordinfo.noteinfo") != null) {
            vh vhVar = new vh();
            vhVar.wlQ = (String) y.get(".recordinfo.noteinfo.noteeditor");
            vhVar.wlP = (String) y.get(".recordinfo.noteinfo.noteauthor");
            cVar2.vJG = vhVar;
            cVar2.vJH = bi.getLong((String) y.get(".recordinfo.edittime"), 0);
        }
        a(str, cVar2);
        hfz.put(Integer.valueOf(hashCode), cVar2);
        return cVar2;
    }

    private static void a(String str, c cVar) {
        cVar.hfI.clear();
        try {
            Document parse = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new InputSource(new ByteArrayInputStream(str.getBytes())));
            parse.normalize();
            NodeList elementsByTagName = parse.getDocumentElement().getElementsByTagName("datalist");
            if (elementsByTagName != null) {
                NodeList childNodes = elementsByTagName.item(0).getChildNodes();
                if (childNodes != null && childNodes.getLength() > 0) {
                    int length = childNodes.getLength();
                    for (int i = 0; i < length; i++) {
                        String str2;
                        Map y;
                        Object obj;
                        Node item = childNodes.item(i);
                        String b = bj.b(item);
                        NodeList elementsByTagName2 = ((Element) item).getElementsByTagName("recordxml");
                        if (elementsByTagName2 == null || elementsByTagName2.getLength() <= 0) {
                            str2 = null;
                        } else {
                            str2 = bj.b(elementsByTagName2.item(0).getFirstChild());
                        }
                        if (b.trim().startsWith("<dataitem")) {
                            y = bj.y(b, "dataitem");
                        } else {
                            y = null;
                        }
                        if (y == null) {
                            obj = null;
                        } else {
                            uz uzVar = new uz();
                            String str3 = ".dataitem";
                            uzVar.Dc(bi.getInt((String) y.get(str3 + ".$datatype"), 0));
                            uzVar.Un((String) y.get(str3 + ".$datasourceid"));
                            uzVar.Dd(bi.getInt((String) y.get(str3 + ".$datastatus"), 0));
                            uzVar.Uf((String) y.get(str3 + ".datafmt"));
                            uzVar.TV((String) y.get(str3 + ".datatitle"));
                            uzVar.TW((String) y.get(str3 + ".datadesc"));
                            uzVar.TX((String) y.get(str3 + ".cdnthumburl"));
                            uzVar.TY((String) y.get(str3 + ".cdnthumbkey"));
                            uzVar.CZ(bi.getInt((String) y.get(str3 + ".thumbwidth"), 0));
                            uzVar.Da(bi.getInt((String) y.get(str3 + ".thumbheight"), 0));
                            uzVar.TZ((String) y.get(str3 + ".cdndataurl"));
                            uzVar.Ua((String) y.get(str3 + ".cdndatakey"));
                            String str4 = (String) y.get(str3 + ".duration");
                            if (str4 != null && str4.length() > 0) {
                                uzVar.Db(bi.getInt(str4, 0));
                            }
                            uzVar.Uc((String) y.get(str3 + ".streamdataurl"));
                            uzVar.Ud((String) y.get(str3 + ".streamlowbandurl"));
                            uzVar.Ub((String) y.get(str3 + ".streamweburl"));
                            uzVar.Ug((String) y.get(str3 + ".fullmd5"));
                            uzVar.Uh((String) y.get(str3 + ".head256md5"));
                            str4 = (String) y.get(str3 + ".datasize");
                            if (!bi.oN(str4)) {
                                uzVar.fx((long) bi.getInt(str4, 0));
                            }
                            uzVar.Ue((String) y.get(str3 + ".dataext"));
                            uzVar.Ul((String) y.get(str3 + ".thumbfullmd5"));
                            uzVar.Um((String) y.get(str3 + ".thumbhead256md5"));
                            str4 = (String) y.get(str3 + ".thumbsize");
                            if (!bi.oN(str4)) {
                                uzVar.fy((long) bi.getInt(str4, 0));
                            }
                            uzVar.Uo((String) y.get(str3 + ".streamvideoid"));
                            str4 = (String) y.get(str3 + ".$dataid");
                            if (bi.oN(str4)) {
                                str4 = String.valueOf(i);
                            }
                            uzVar.Ui(str4);
                            str4 = (String) y.get(str3 + ".$htmlid");
                            if (!bi.oN(str4)) {
                                uzVar.Us(str4);
                            }
                            uzVar.De(bi.getInt((String) y.get(str3 + ".$dataillegaltype"), 0));
                            uzVar.Up((String) y.get(str3 + ".sourcetitle"));
                            uzVar.Uq((String) y.get(str3 + ".sourcename"));
                            uzVar.Ur((String) y.get(str3 + ".sourcetime"));
                            uzVar.Ut((String) y.get(str3 + ".statextstr"));
                            if (str2 != null) {
                                uzVar.Uv(str2);
                            }
                            va vaVar = new va();
                            vb vbVar = new vb();
                            vbVar.Dg(bi.getInt((String) y.get(str3 + ".$sourcetype"), 0));
                            str4 = (String) y.get(str3 + ".dataitemsource.fromusr");
                            if (!bi.oN(str4)) {
                                vbVar.Uw(str4);
                                x.d("MicroMsg.RecordMsgParser", "fromusr %s", vbVar.fAJ);
                            }
                            str4 = (String) y.get(str3 + ".dataitemsource.realchatname");
                            if (!bi.oN(str4)) {
                                vbVar.Uz(str4);
                                x.d("MicroMsg.RecordMsgParser", "realChatname %s", vbVar.wlx);
                            }
                            vbVar.UB((String) y.get(str3 + ".appid"));
                            vbVar.UC((String) y.get(str3 + ".link"));
                            vbVar.UD((String) y.get(str3 + ".brandid"));
                            vaVar.c(vbVar);
                            String str5 = str3 + ".locitem";
                            if (y.containsKey(str5)) {
                                vg vgVar = new vg();
                                if (!bi.oN((String) y.get(str5 + ".label"))) {
                                    vgVar.UE((String) y.get(str5 + ".label"));
                                }
                                if (!bi.oN((String) y.get(str5 + ".poiname"))) {
                                    vgVar.UF((String) y.get(str5 + ".poiname"));
                                }
                                str4 = (String) y.get(str5 + ".lng");
                                if (!bi.oN(str4)) {
                                    vgVar.r(bi.getDouble(str4, 0.0d));
                                }
                                str4 = (String) y.get(str5 + ".lat");
                                if (!bi.oN(str4)) {
                                    vgVar.s(bi.getDouble(str4, 0.0d));
                                }
                                str4 = (String) y.get(str5 + ".scale");
                                if (!bi.oN(str4)) {
                                    if (str4.indexOf(46) != -1) {
                                        vgVar.Dh(bi.getInt(str4.substring(0, str4.indexOf(46)), -1));
                                    } else {
                                        vgVar.Dh(bi.getInt(str4, -1));
                                    }
                                }
                                vaVar.a(vgVar);
                            } else {
                                x.w("MicroMsg.RecordMsgParser", "cur fav not contains %s", str5);
                            }
                            str5 = str3 + ".weburlitem";
                            if (y.containsKey(str5)) {
                                wc wcVar = new wc();
                                wcVar.Va((String) y.get(str5 + ".title"));
                                wcVar.Vb((String) y.get(str5 + ".desc"));
                                wcVar.Vd((String) y.get(str5 + ".thumburl"));
                                wcVar.Vc((String) y.get(str5 + ".link"));
                                wcVar.Dm(bi.getInt((String) y.get(str5 + ".opencache"), 0));
                                vaVar.a(wcVar);
                            } else {
                                x.w("MicroMsg.RecordMsgParser", "cur fav not contains %s", str5);
                            }
                            str5 = str3 + ".productitem";
                            if (y.containsKey(str5)) {
                                vm vmVar = new vm();
                                vmVar.UG((String) y.get(str5 + ".title"));
                                vmVar.UH((String) y.get(str5 + ".desc"));
                                vmVar.UI((String) y.get(str5 + ".thumburl"));
                                vmVar.UJ((String) y.get(str5 + ".productinfo"));
                                vmVar.Di(bi.getInt((String) y.get(str5 + ".$type"), 0));
                                vaVar.a(vmVar);
                            } else {
                                x.w("MicroMsg.RecordMsgParser", "cur fav not contains %s", str5);
                            }
                            str3 = str3 + ".tvitem";
                            if (y.containsKey(str3)) {
                                vw vwVar = new vw();
                                vwVar.UW((String) y.get(str3 + ".title"));
                                vwVar.UX((String) y.get(str3 + ".desc"));
                                vwVar.UY((String) y.get(str3 + ".thumburl"));
                                vwVar.UZ((String) y.get(str3 + ".tvinfo"));
                                vaVar.a(vwVar);
                            } else {
                                x.w("MicroMsg.RecordMsgParser", "cur fav not contains %s", str3);
                            }
                            uzVar.a(vaVar);
                            uz obj2 = uzVar;
                        }
                        try {
                            cVar.hfI.add(obj2);
                        } catch (Throwable e) {
                            x.e("MicroMsg.RecordMsgLogic", "get record msg data from xml error: %s", e.getMessage());
                            x.printErrStackTrace("MicroMsg.RecordMsgLogic", e, "", new Object[0]);
                            cVar.hfI.clear();
                        }
                    }
                }
            }
        } catch (Exception e2) {
            x.e("MicroMsg.RecordMsgLogic", "[parser] parseXML exception:%s", e2.toString());
        }
    }

    public static int vK(int i) {
        if (2 == i) {
            return com.tencent.mm.modelcdntran.b.MediaType_FULLSIZEIMAGE;
        }
        if (4 == i) {
            return com.tencent.mm.modelcdntran.b.MediaType_VIDEO;
        }
        return com.tencent.mm.modelcdntran.b.MediaType_FILE;
    }

    public static boolean a(uz uzVar, long j, boolean z) {
        if (uzVar == null) {
            x.w("MicroMsg.RecordMsgLogic", "try download data fail, dataitem is null");
            return false;
        }
        String d = d(uzVar.mBr, j, true);
        com.tencent.mm.plugin.record.a.f IO = n.getRecordMsgCDNStorage().IO(d);
        if (IO == null) {
            IO = new com.tencent.mm.plugin.record.a.f();
            IO.field_cdnKey = uzVar.wjP;
            IO.field_cdnUrl = uzVar.wjN;
            IO.field_dataId = uzVar.mBr;
            IO.field_mediaId = d;
            IO.field_totalLen = (int) uzVar.wki;
            IO.field_localId = new Random().nextInt(2147483645) + 1;
            IO.field_path = c(uzVar, j);
            IO.field_type = 1;
            IO.field_fileType = vK(uzVar.bjS);
            IO.field_isThumb = false;
            boolean a = n.getRecordMsgCDNStorage().a(IO);
            x.d("MicroMsg.RecordMsgLogic", "insert localId[%d] result[%B]", Integer.valueOf(IO.field_localId), Boolean.valueOf(a));
            if (!bi.oN(uzVar.wkP) && uzVar.wkP.equals("WeNoteHtmlFile")) {
                n.bnA().a(IO, true);
            }
        }
        x.d("MicroMsg.RecordMsgLogic", "try download data, dump record cdninfo: %s", IO);
        if (4 == IO.field_status) {
            x.w("MicroMsg.RecordMsgLogic", "try download, but cdn info out of date, code[%d]", Integer.valueOf(IO.field_errCode));
            return false;
        }
        if (3 == IO.field_status) {
            x.i("MicroMsg.RecordMsgLogic", "try download, but cdn info error, code[%d], can retry[%B]", Integer.valueOf(IO.field_errCode), Boolean.valueOf(z));
            if (!z) {
                return false;
            }
            IO.field_status = 1;
            n.getRecordMsgCDNStorage().b(IO, "localId");
        }
        n.bnA().run();
        return true;
    }

    public static boolean g(uz uzVar, long j) {
        if (uzVar == null) {
            x.w("MicroMsg.RecordMsgLogic", "checkDataOutOfDate fail, dataitem is null");
            return true;
        }
        com.tencent.mm.plugin.record.a.f IO = n.getRecordMsgCDNStorage().IO(d(uzVar.mBr, j, true));
        if (IO == null) {
            x.d("MicroMsg.RecordMsgLogic", "checkDataOutOfDate ok, not find cdn info");
            return false;
        } else if (4 == IO.field_status) {
            x.w("MicroMsg.RecordMsgLogic", "checkDataOutOfDate ok, status err, code %d", Integer.valueOf(IO.field_errCode));
            return true;
        } else {
            x.d("MicroMsg.RecordMsgLogic", "checkDataOutOfDate ok, find cdn info, status %d", Integer.valueOf(IO.field_status));
            return false;
        }
    }

    public static boolean b(uz uzVar, long j, boolean z) {
        if (uzVar == null) {
            x.w("MicroMsg.RecordMsgLogic", "try download thumb error, dataitem is null");
            return false;
        }
        String AH = AH(uzVar.mBr);
        String d = d(AH, j, true);
        com.tencent.mm.plugin.record.a.f IO = n.getRecordMsgCDNStorage().IO(d);
        if (IO == null) {
            IO = new com.tencent.mm.plugin.record.a.f();
            IO.field_cdnKey = uzVar.wjJ;
            IO.field_cdnUrl = uzVar.hcU;
            IO.field_dataId = AH;
            IO.field_mediaId = d;
            IO.field_totalLen = (int) uzVar.wkt;
            IO.field_localId = new Random().nextInt(2147483645) + 1;
            IO.field_path = f(uzVar, j);
            IO.field_type = 1;
            IO.field_fileType = com.tencent.mm.modelcdntran.b.MediaType_FULLSIZEIMAGE;
            IO.field_isThumb = true;
            boolean a = n.getRecordMsgCDNStorage().a(IO);
            x.d("MicroMsg.RecordMsgLogic", "insert localId[%d] result[%B]", Integer.valueOf(IO.field_localId), Boolean.valueOf(a));
        }
        x.v("MicroMsg.RecordMsgLogic", "try download thumb, dump record cdninfo: %s", IO);
        if (4 == IO.field_status) {
            x.w("MicroMsg.RecordMsgLogic", "try download thumb, but cdn info out of date, code[%d]", Integer.valueOf(IO.field_errCode));
            return false;
        }
        if (3 == IO.field_status) {
            x.i("MicroMsg.RecordMsgLogic", "try download thumb, but cdn info error, code[%d], can retry[%B]", Integer.valueOf(IO.field_errCode), Boolean.valueOf(z));
            if (!z) {
                return false;
            }
            IO.field_status = 1;
            n.getRecordMsgCDNStorage().b(IO, "localId");
        }
        n.bnA().run();
        return true;
    }

    public static String gx(String str) {
        as.Hm();
        com.tencent.mm.storage.x Xv = com.tencent.mm.y.c.Ff().Xv(str);
        if (Xv == null) {
            x.w("MicroMsg.RecordMsgLogic", "wtf get contact null, username %s", str);
            return "";
        }
        String AX = Xv.AX();
        if (!s.eX(AX)) {
            return AX;
        }
        List gl = m.gl(str);
        String FY = q.FY();
        if (gl == null || gl.isEmpty()) {
            x.w("MicroMsg.RecordMsgLogic", "get members from username error, content empty");
            return AX;
        }
        gl.remove(FY);
        gl.add(0, FY);
        return m.b(gl, 3);
    }

    public static boolean h(uz uzVar, long j) {
        return p.Vw(c(uzVar, j));
    }
}
