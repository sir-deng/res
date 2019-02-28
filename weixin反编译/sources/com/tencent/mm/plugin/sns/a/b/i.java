package com.tencent.mm.plugin.sns.a.b;

import android.database.Cursor;
import android.os.SystemClock;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.bp.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.protocal.c.aob;
import com.tencent.mm.protocal.c.bld;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w.a;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public final class i implements e {
    public static int qVA = 20480;
    public static int qVB = 30720;
    public static int qVC = 51200;
    public static int qVD = 60;
    public static int qVE = 1800;
    public static int qVF = 43200;
    private long qVG = 0;
    private bld qVH = new bld();
    private boolean qVI = false;
    private long qVJ = 0;
    private int qVK = 0;
    private int qVz = 0;
    private Random random = new Random(System.currentTimeMillis());

    static /* synthetic */ void d(i iVar) {
        if (iVar.qVH.vNr.size() > 0) {
            x.i("MicroMsg.SnsLogMgr", "trigerSave " + iVar.qVH.vNr.size());
            ae.bvY().a(iVar.qVH);
            iVar.qVH.vNr.clear();
        }
    }

    static /* synthetic */ void e(i iVar) {
        int i;
        String str;
        int i2;
        if (bi.bB(iVar.qVJ) >= 100 || iVar.qVK <= 0) {
            iVar.qVK = qVA;
            if (ao.isWifi(ad.getContext())) {
                iVar.qVK = qVC;
            }
            if (ao.is3G(ad.getContext()) || ao.is4G(ad.getContext())) {
                iVar.qVK = qVB;
            }
            if (ao.is2G(ad.getContext())) {
                iVar.qVK = qVA;
            }
            iVar.qVJ = SystemClock.elapsedRealtime();
            i = iVar.qVK;
        } else {
            i = iVar.qVK;
        }
        List linkedList = new LinkedList();
        bld dE = ae.bvY().dE(i, iVar.qVz);
        aob aob;
        if (dE.vNr.size() == 0) {
            str = "read from memery";
            i2 = 0;
            while (iVar.qVH.vNr.size() > 0) {
                aob = (aob) iVar.qVH.vNr.remove();
                if (aob.wBG.oz.length + i2 >= i) {
                    break;
                }
                i2 += aob.wBG.oz.length;
                linkedList.add(aob);
            }
        } else {
            str = "read from db";
            i2 = 0;
            while (dE.vNr.size() > 0) {
                aob = (aob) dE.vNr.remove();
                linkedList.add(aob);
                i2 = aob.wBG.oz.length + i2;
            }
        }
        String str2 = str;
        if (linkedList.size() == 0) {
            x.i("MicroMsg.SnsLogMgr", "nothing for report");
            return;
        }
        x.i("MicroMsg.SnsLogMgr", "size " + i2 + " " + linkedList.size() + " " + i + " logItemList.LogList.size  " + iVar.qVH.vNr.size() + " label:  " + str2);
        k eVar = new e(linkedList);
        g.Dr();
        g.Dp().gRu.a(eVar, 0);
    }

    public final void h(final int i, final Object... objArr) {
        ae.bvS().post(new Runnable() {
            public final void run() {
                aob aob = new aob();
                aob.wBF = i;
                aob.wBN = (int) (System.currentTimeMillis() / 1000);
                aob.kyA = 1;
                String l = i.l(objArr);
                aob.wBG = new b(l.getBytes());
                i.this.qVH.vNr.add(aob);
                x.i("MicroMsg.SnsLogMgr", "snsadlog " + i + " " + l);
                if (i.this.qVG == 0) {
                    i.this.qVG = System.currentTimeMillis();
                }
            }
        });
        if (!this.qVI) {
            this.qVI = true;
            ae.bvS().postDelayed(new Runnable() {
                public final void run() {
                    i.this.qVI = false;
                    i.this.buL();
                }
            }, 2000);
        }
    }

    public final void buL() {
        if (ae.rbr) {
            g.Dr();
            int intValue = ((Integer) g.Dq().Db().get(a.BUSINESS_SNS_ADLOG_CNTTIME_INT, Integer.valueOf(0))).intValue();
            g.Dr();
            int intValue2 = ((Integer) g.Dq().Db().get(a.BUSINESS_SNS_ADLOG_FREQUENCY_INT, Integer.valueOf(-1))).intValue();
            if (intValue2 > qVF || intValue2 < 0) {
                intValue2 = this.random.nextInt((qVE - qVD) + 1) + qVD;
            }
            if ((System.currentTimeMillis() / 1000) - ((long) intValue) > ((long) intValue2)) {
                intValue2 = 1;
            } else {
                intValue2 = 0;
            }
            if (intValue2 == 0) {
                buM();
                x.d("MicroMsg.SnsLogMgr", "pass report ");
                return;
            }
            p bvY = ae.bvY();
            String str = "select rowid from SnsReportKv order by rowid desc  limit 1";
            x.i("MicroMsg.SnsKvReportStg", " getLast " + str);
            Cursor a = bvY.hiZ.a(str, null, 2);
            if (a.moveToFirst()) {
                intValue2 = a.getInt(0);
            } else {
                intValue2 = 0;
            }
            a.close();
            this.qVz = intValue2;
            buN();
            buM();
        }
    }

    private void buM() {
        ae.bvS().post(new Runnable() {
            public final void run() {
                if (System.currentTimeMillis() - i.this.qVG >= 60000 || i.this.qVH.vNr.size() > 1000) {
                    if (i.this.qVH != null && i.this.qVH.vNr.size() > 0) {
                        i.d(i.this);
                    }
                    i.this.qVG = 0;
                }
            }
        });
    }

    private void buN() {
        ae.bvS().post(new Runnable() {
            public final void run() {
                i.e(i.this);
            }
        });
    }

    public static String l(Object... objArr) {
        if (objArr == null || objArr.length <= 0) {
            x.w("MicroMsg.SnsLogMgr", "vals is null, use '' as value");
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        int length = objArr.length - 1;
        for (int i = 0; i < length; i++) {
            stringBuilder.append(String.valueOf(objArr[i])).append(',');
        }
        stringBuilder.append(String.valueOf(objArr[length]));
        return stringBuilder.toString();
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (kVar.getType() == 1802 && (kVar instanceof e)) {
            e eVar = (e) kVar;
            if (i == 0 && i2 == 0) {
                g.Dr();
                g.Dq().Db().a(a.BUSINESS_SNS_ADLOG_CNTTIME_INT, Integer.valueOf((int) (System.currentTimeMillis() / 1000)));
                buN();
                return;
            }
            List<aob> list = eVar.jTs;
            p bvY = ae.bvY();
            bld bld = new bld();
            for (aob add : list) {
                bld.vNr.add(add);
            }
            bvY.a(bld);
        }
    }
}
