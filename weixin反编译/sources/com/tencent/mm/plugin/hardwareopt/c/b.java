package com.tencent.mm.plugin.hardwareopt.c;

import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.c.akn;
import com.tencent.mm.protocal.c.arp;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w;
import com.tencent.mm.vending.c.a;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;

public final class b implements a<Boolean, akn> {
    private boolean nFS = false;

    public final /* synthetic */ Object call(Object obj) {
        akn akn = (akn) obj;
        long longValue = ((Long) g.Dq().Db().get(w.a.USERINFO_HARDWARE_LAST_UPLOAD_TICKS_LONG_SYNC, Long.valueOf(-1))).longValue();
        long currentTimeMillis = System.currentTimeMillis();
        x.i("MicroMsg.TaskReportHardwareInfo", "hy: last ticks: %d, current ticks: %d, interval: %d", Long.valueOf(longValue), Long.valueOf(currentTimeMillis), Long.valueOf(currentTimeMillis - longValue));
        if (!this.nFS && currentTimeMillis - longValue < 86400000) {
            x.d("MicroMsg.TaskReportHardwareInfo", "hy: should not upload. too small interval");
            return Boolean.valueOf(false);
        } else if (!this.nFS && (akn == null || akn.wyo == null)) {
            x.w("MicroMsg.TaskReportHardwareInfo", "hy: error when finding hardware");
            com.tencent.mm.plugin.report.service.g.pWK.a(661, 1, 1, false);
            return Boolean.valueOf(false);
        } else if (this.nFS || !bi.oN(akn.wyo.imei)) {
            x.i("MicroMsg.TaskReportHardwareInfo", "hy: found hardware infos. start report");
            com.tencent.mm.plugin.report.service.g gVar = com.tencent.mm.plugin.report.service.g.pWK;
            Object[] objArr = new Object[41];
            objArr[0] = akn.wyo.imei;
            objArr[1] = akn.wyo.vRM;
            objArr[2] = akn.wyo.vRN;
            objArr[3] = akn.wyo.vRO;
            objArr[4] = akn.wyp.vXL;
            objArr[5] = akn.wyp.vXJ;
            objArr[6] = akn.wyp.vRN;
            objArr[7] = akn.wyp.vXM;
            objArr[8] = Integer.valueOf(akn.wyp.vXK);
            objArr[9] = Integer.valueOf(akn.wyq.wFV);
            objArr[10] = Integer.valueOf(akn.wyq.wFW);
            objArr[11] = Integer.valueOf(akn.wyr.wXy);
            objArr[12] = Integer.valueOf(akn.wyr.wXz ? 1 : 0);
            objArr[13] = Integer.valueOf(akn.wyv.wnR ? 1 : 0);
            objArr[14] = Integer.valueOf(akn.wyv.wnS ? 1 : 0);
            objArr[15] = akn.wys.wRA;
            objArr[16] = Integer.valueOf(akn.wys.density);
            objArr[17] = akn.wyt.wev;
            objArr[18] = Integer.valueOf(akn.wyu.wnb ? 1 : 0);
            objArr[19] = Integer.valueOf(akn.wyu.wnc ? 1 : 0);
            objArr[20] = Integer.valueOf(akn.wyu.wnd ? 1 : 0);
            objArr[21] = Integer.valueOf(akn.wyu.wne ? 1 : 0);
            objArr[22] = Integer.valueOf(akn.wyu.wnf ? 1 : 0);
            objArr[23] = Integer.valueOf(akn.wyu.wng ? 1 : 0);
            objArr[24] = Integer.valueOf(akn.wyu.wnh ? 1 : 0);
            objArr[25] = Integer.valueOf(akn.wyu.wns ? 1 : 0);
            objArr[26] = Integer.valueOf(akn.wyu.wni ? 1 : 0);
            objArr[27] = Integer.valueOf(akn.wyu.wnj ? 1 : 0);
            objArr[28] = Integer.valueOf(akn.wyu.wnk ? 1 : 0);
            objArr[29] = Integer.valueOf(akn.wyu.wnl ? 1 : 0);
            objArr[30] = Integer.valueOf(akn.wyu.wnm ? 1 : 0);
            objArr[31] = Integer.valueOf(akn.wyu.wnn ? 1 : 0);
            objArr[32] = Integer.valueOf(akn.wyu.wno ? 1 : 0);
            objArr[33] = Integer.valueOf(akn.wyu.wnp ? 1 : 0);
            objArr[34] = Integer.valueOf(akn.wyu.wnq ? 1 : 0);
            objArr[35] = Integer.valueOf(akn.wyu.wnr ? 1 : 0);
            objArr[36] = Integer.valueOf(akn.wyq.wFY);
            objArr[37] = Integer.valueOf(akn.wyq.wFX);
            objArr[38] = akn.wyt.wew;
            objArr[39] = W(akn.wyt.wex);
            objArr[40] = Integer.valueOf(akn.wyv.wnT ? 1 : 0);
            gVar.h(14552, objArr);
            g.Dq().Db().a(w.a.USERINFO_HARDWARE_LAST_UPLOAD_TICKS_LONG_SYNC, Long.valueOf(currentTimeMillis));
            com.tencent.mm.plugin.report.service.g.pWK.a(661, 0, 1, false);
            return Boolean.valueOf(true);
        } else {
            x.w("MicroMsg.TaskReportHardwareInfo", "hy: no imei detected. maybe not grant permission. ignore");
            com.tencent.mm.plugin.report.service.g.pWK.a(661, 2, 1, false);
            return Boolean.valueOf(false);
        }
    }

    public b(boolean z) {
        this.nFS = z;
    }

    private static String W(LinkedList<arp> linkedList) {
        JSONArray jSONArray = new JSONArray();
        if (linkedList != null) {
            try {
                Iterator it = linkedList.iterator();
                while (it.hasNext()) {
                    arp arp = (arp) it.next();
                    if (!(arp == null || bi.oN(arp.ovp))) {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("mimeName", arp.ovp);
                        JSONArray jSONArray2 = new JSONArray();
                        if (arp.wGh != null) {
                            Iterator it2 = arp.wGh.iterator();
                            while (it2.hasNext()) {
                                jSONArray2.put((String) it2.next());
                            }
                        }
                        jSONObject.put("codecName", jSONArray2);
                        jSONArray.put(jSONObject);
                    }
                }
                return jSONArray.toString();
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.TaskReportHardwareInfo", e, "hy: error when build up json", new Object[0]);
                return "";
            }
        }
        x.w("MicroMsg.TaskReportHardwareInfo", "hy: no mime info retrieved!");
        return "";
    }
}
