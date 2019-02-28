package com.tencent.mm.plugin.location.model;

import com.tencent.mm.ad.d.a;
import com.tencent.mm.ad.d.b;
import com.tencent.mm.protocal.c.bx;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bj;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.as;
import com.tencent.mm.y.c;
import com.tencent.mm.y.e;
import com.tencent.mm.y.q;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class n extends e {
    public final b b(a aVar) {
        bx bxVar = aVar.hoa;
        if (bxVar == null) {
            x.e("MicroMsg.TrackMsgExtension", "onPreAddMessage cmdAM is null");
        } else {
            Object linkedList = new LinkedList();
            String a = com.tencent.mm.platformtools.n.a(bxVar.vNM);
            String a2 = com.tencent.mm.platformtools.n.a(bxVar.vNN);
            as.Hm();
            String str = ((String) c.Db().get(2, null)).equals(a) ? a2 : a;
            String a3 = com.tencent.mm.platformtools.n.a(bxVar.vNO);
            x.d("MicroMsg.TrackMsgExtension", "cmd " + a3);
            Map y = bj.y(a3, "sysmsg");
            if (y != null) {
                try {
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append("talk  " + str + "\r\n");
                    stringBuffer.append("from fromUser " + a + "\r\n");
                    stringBuffer.append("from toUser " + a2 + "\r\n");
                    String str2 = (String) y.get(".sysmsg.trackmsg.trackroominfo.trackroompoi.addr");
                    double Ef = Ef((String) y.get(".sysmsg.trackmsg.trackroominfo.trackroompoi.latitude"));
                    stringBuffer.append("lat " + Ef + "\r\n");
                    double Ef2 = Ef((String) y.get(".sysmsg.trackmsg.trackroominfo.trackroompoi.longitude"));
                    stringBuffer.append("lng " + Ef2 + "\r\n");
                    stringBuffer.append("times " + bi.getInt((String) y.get(".sysmsg.trackmsg.trackroominfo.timestamp"), 0) + "\r\n");
                    int i = 0;
                    while (true) {
                        a3 = (String) y.get((".sysmsg.trackmsg.trackroominfo.trackmemberlist.member" + (i == 0 ? "" : Integer.valueOf(i))) + ".username");
                        if (bi.oN(a3)) {
                            String bb;
                            String bc;
                            stringBuffer.append("userNameList size " + linkedList.size() + "\r\n");
                            x.i("MicroMsg.TrackMsgExtension", "xml : " + stringBuffer.toString());
                            if (str.equals(l.aWa().nXy)) {
                                bb = bb(linkedList);
                                bc = bi.oN(bb) ? bc(linkedList) : null;
                            } else {
                                bc = null;
                                bb = null;
                            }
                            l.aWb().a(str, linkedList, Ef, Ef2, str2, bb, bc);
                        } else {
                            i++;
                            linkedList.add(a3);
                        }
                    }
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.TrackMsgExtension", e, "", new Object[0]);
                }
            }
        }
        return null;
    }

    private static double Ef(String str) {
        if (str == null) {
            return 0.0d;
        }
        return bi.getDouble(str, 0.0d);
    }

    private static String bb(List<String> list) {
        String str;
        List<String> aWi = l.aWa().aWi();
        List linkedList = new LinkedList();
        for (String str2 : list) {
            Object obj;
            for (String equals : aWi) {
                if (equals.equals(str2)) {
                    obj = 1;
                    break;
                }
            }
            obj = null;
            if (obj == null) {
                linkedList.add(str2);
            }
        }
        if (linkedList.isEmpty()) {
            return null;
        }
        for (int i = 0; i < linkedList.size(); i++) {
            str2 = (String) linkedList.get(i);
            if (!str2.equals(q.FY())) {
                return str2;
            }
        }
        return null;
    }

    private static String bc(List<String> list) {
        String str;
        List<String> aWi = l.aWa().aWi();
        List linkedList = new LinkedList();
        for (String str2 : aWi) {
            Object obj;
            for (String str3 : list) {
                if (str3.equals(str2)) {
                    obj = 1;
                    break;
                }
            }
            obj = null;
            if (obj == null) {
                linkedList.add(str2);
            }
        }
        if (linkedList.isEmpty()) {
            return null;
        }
        for (int i = 0; i < linkedList.size(); i++) {
            str3 = (String) linkedList.get(i);
            if (!str3.equals(q.FY())) {
                return str3;
            }
        }
        return null;
    }
}
