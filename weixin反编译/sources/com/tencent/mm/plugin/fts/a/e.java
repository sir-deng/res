package com.tencent.mm.plugin.fts.a;

import com.tencent.mars.smc.IDKey;
import com.tencent.mm.a.o;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.jsapi.share.f;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;

public final class e {
    public static final int[] mQt = new int[]{8, 9, 10, 11, 12, 14, 19, 20, 21, 22, 24, 25, 26};
    public static final a mQu = new a();

    public static final class a {
        public long mQv = 0;
        public long mQw = 0;
        public long mQx = 0;
        public long mQy = 0;
        public long mQz = 0;
    }

    public static final void h(int i, long j, long j2) {
        if (d.b(i, mQt)) {
            g.Do();
            long longValue = new o(com.tencent.mm.kernel.a.Cn()).longValue();
            if (d.vHm) {
                if (longValue % 100 != 1) {
                    return;
                }
            } else if (d.vHn && longValue % 10 != 1) {
                return;
            }
            String str = "%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s";
            Object[] objArr = new Object[11];
            objArr[0] = Integer.valueOf(0);
            objArr[1] = Integer.valueOf(i);
            objArr[2] = Long.valueOf(j);
            objArr[3] = Integer.valueOf(0);
            objArr[4] = Integer.valueOf(mQu.mQv >= 1536 ? 1 : 0);
            objArr[5] = Long.valueOf(mQu.mQv);
            objArr[6] = Long.valueOf(mQu.mQw);
            objArr[7] = Long.valueOf(mQu.mQx);
            objArr[8] = Long.valueOf(mQu.mQy);
            objArr[9] = Long.valueOf(mQu.mQz);
            objArr[10] = Long.valueOf(j2);
            x.v("MicroMsg.FTS.FTSReportLogic", "reportKVSearchTime: %d %s", Integer.valueOf(14175), String.format(str, objArr));
            com.tencent.mm.plugin.report.d.pVE.k(14175, r0);
        }
    }

    public static void u(int i, long j) {
        if (i > 0) {
            int i2 = ((i - 1) * 2) + 1;
            x.v("MicroMsg.FTS.FTSReportLogic", "reportIDKeySearchTime: reportKey=%d taskId=%d time=%d", Integer.valueOf(i2), Integer.valueOf(i), Long.valueOf(j));
            ArrayList arrayList = new ArrayList();
            IDKey iDKey = new IDKey();
            iDKey.SetID(601);
            iDKey.SetKey(i2);
            iDKey.SetValue((long) ((int) j));
            arrayList.add(iDKey);
            iDKey = new IDKey();
            iDKey.SetID(601);
            iDKey.SetKey(i2 + 1);
            iDKey.SetValue(1);
            arrayList.add(iDKey);
            com.tencent.mm.plugin.report.d.pVE.a(arrayList, false);
        }
    }

    public static void v(int i, long j) {
        if (i > 0) {
            int i2 = ((i - 1) * 4) + 1;
            ArrayList arrayList = new ArrayList();
            IDKey iDKey = new IDKey();
            iDKey.SetID(602);
            iDKey.SetKey(i2);
            iDKey.SetValue(1);
            arrayList.add(iDKey);
            if (j <= 100) {
                iDKey = new IDKey();
                iDKey.SetID(602);
                iDKey.SetKey(i2 + 1);
                iDKey.SetValue(1);
                arrayList.add(iDKey);
            } else if (j <= 500) {
                iDKey = new IDKey();
                iDKey.SetID(602);
                iDKey.SetKey(i2 + 2);
                iDKey.SetValue(1);
                arrayList.add(iDKey);
            } else {
                iDKey = new IDKey();
                iDKey.SetID(602);
                iDKey.SetKey(i2 + 3);
                iDKey.SetValue(1);
                arrayList.add(iDKey);
            }
            com.tencent.mm.plugin.report.d.pVE.a(arrayList, false);
        }
    }

    public static void qt(int i) {
        IDKey iDKey = new IDKey();
        iDKey.SetID(f.CTRL_INDEX);
        iDKey.SetKey(0);
        iDKey.SetValue(1);
        ArrayList arrayList = new ArrayList();
        arrayList.add(iDKey);
        if (i != 1) {
            iDKey = new IDKey();
            iDKey.SetID(f.CTRL_INDEX);
            iDKey.SetKey(2);
            iDKey.SetValue(1);
            arrayList.add(iDKey);
            iDKey = new IDKey();
            iDKey.SetID(f.CTRL_INDEX);
            iDKey.SetKey(i);
            iDKey.SetValue(1);
            arrayList.add(iDKey);
        } else {
            iDKey = new IDKey();
            iDKey.SetID(f.CTRL_INDEX);
            iDKey.SetKey(1);
            iDKey.SetValue(1);
            arrayList.add(iDKey);
        }
        com.tencent.mm.plugin.report.d.pVE.a(arrayList, false);
    }

    public static final void qu(int i) {
        x.i("MicroMsg.FTS.FTSReportLogic", "reportCommonChatroom: %d %d", Integer.valueOf(14731), Integer.valueOf(i));
        com.tencent.mm.plugin.report.d.pVE.h(14731, Integer.valueOf(i));
    }

    public static final void aND() {
        x.i("MicroMsg.FTS.FTSReportLogic", "reportIDKeyFTSData %d %d %d %d %d", Long.valueOf(mQu.mQv), Long.valueOf(mQu.mQw), Long.valueOf(mQu.mQx), Long.valueOf(mQu.mQz), Long.valueOf(mQu.mQy));
        ArrayList arrayList = new ArrayList();
        c(arrayList, 0);
        if (mQu.mQv > 1536) {
            c(arrayList, 1);
        }
        if (mQu.mQw >= 10000) {
            c(arrayList, 2);
        }
        if (mQu.mQx >= 5000) {
            c(arrayList, 3);
        }
        if (mQu.mQz >= 10000) {
            c(arrayList, 4);
        }
        if (mQu.mQy >= 1000000) {
            c(arrayList, 5);
        }
        com.tencent.mm.plugin.report.d.pVE.a(arrayList, false);
    }

    private static final void c(ArrayList<IDKey> arrayList, int i) {
        IDKey iDKey = new IDKey();
        iDKey.SetID(729);
        iDKey.SetKey(i);
        iDKey.SetValue(1);
        arrayList.add(iDKey);
    }
}
