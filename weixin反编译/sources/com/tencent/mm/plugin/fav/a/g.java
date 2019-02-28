package com.tencent.mm.plugin.fav.a;

import com.tencent.mm.plugin.report.d;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Map;

public final class g {
    private static Map<Long, Long> mtG = new HashMap();
    private static Map<Long, Long> mtH = new HashMap();

    public static class a {
        public int cPf;
        public int index;
        public long mtI;
        public String mtJ;
        public long mtK;
        public long mtL;
        public boolean mtM;
        public int mtN;
        public int mtO;
        public int mtP;
        public int mtQ;
        public int mtR;
        public boolean mtS;
        public boolean mtT;
        public int mtU;
        public int scene;
        public long timestamp;
        public int type;

        public final String toString() {
            int i;
            int i2 = 1;
            String str = "%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s";
            Object[] objArr = new Object[18];
            objArr[0] = Integer.valueOf(this.scene);
            objArr[1] = Integer.valueOf(this.index);
            objArr[2] = Long.valueOf(this.mtI);
            objArr[3] = Integer.valueOf(this.type);
            objArr[4] = this.mtJ;
            objArr[5] = Integer.valueOf(this.cPf);
            objArr[6] = Long.valueOf(this.timestamp);
            objArr[7] = Long.valueOf(this.mtK);
            objArr[8] = Long.valueOf(this.mtL);
            if (this.mtM) {
                i = 1;
            } else {
                i = 0;
            }
            objArr[9] = Integer.valueOf(i);
            objArr[10] = Integer.valueOf(this.mtN);
            objArr[11] = Integer.valueOf(this.mtO);
            objArr[12] = Integer.valueOf(this.mtP);
            objArr[13] = Integer.valueOf(this.mtQ);
            objArr[14] = Integer.valueOf(this.mtR);
            objArr[15] = Integer.valueOf(this.mtS ? 1 : 0);
            if (!this.mtT) {
                i2 = 0;
            }
            objArr[16] = Integer.valueOf(i2);
            objArr[17] = Integer.valueOf(this.mtU);
            return String.format(str, objArr);
        }
    }

    public static final void pW(int i) {
        d.pVE.a(802, (long) i, 1, false);
    }

    public static final void pX(int i) {
        d.pVE.a(802, 4, (long) i, false);
    }

    public static void cU(long j) {
        if (!mtG.containsKey(Long.valueOf(j))) {
            mtG.put(Long.valueOf(j), Long.valueOf(System.currentTimeMillis()));
        }
    }

    public static long cV(long j) {
        Long l = (Long) mtG.get(Long.valueOf(j));
        return l == null ? -1 : System.currentTimeMillis() - l.longValue();
    }

    public static void cW(long j) {
        if (!mtH.containsKey(Long.valueOf(j))) {
            mtH.put(Long.valueOf(j), Long.valueOf(System.currentTimeMillis()));
        }
    }

    public static int cA(int i, int i2) {
        if (i2 == -401) {
            return -4;
        }
        if (i == 4) {
            return -2;
        }
        return -1;
    }

    public static String a(a aVar) {
        int i = 1;
        x.v("MicroMsg.Fav.FavReportApiLogic", "reportDetailObj %s", aVar.toString());
        d.pVE.k(15098, r0);
        String str = "scene[%s],index[%s],favId[%s],type[%s],infoLength[%s],source[%s],timestamp[%s],detailPeriod[%s],subDetailPeriod[%s],needOpenOtherApp[%s],subDetailCount[%s],shareFriendCount[%s],shareSnsCount[%s],editContentCount[%s],editTagCount[%s],isDelete[%s],isScrollBottom[%s],subScene[%s]";
        Object[] objArr = new Object[18];
        objArr[0] = Integer.valueOf(aVar.scene);
        objArr[1] = Integer.valueOf(aVar.index);
        objArr[2] = Long.valueOf(aVar.mtI);
        objArr[3] = Integer.valueOf(aVar.type);
        objArr[4] = aVar.mtJ;
        objArr[5] = Integer.valueOf(aVar.cPf);
        objArr[6] = Long.valueOf(aVar.timestamp);
        objArr[7] = Long.valueOf(aVar.mtK);
        objArr[8] = Long.valueOf(aVar.mtL);
        objArr[9] = Integer.valueOf(aVar.mtM ? 1 : 0);
        objArr[10] = Integer.valueOf(aVar.mtN);
        objArr[11] = Integer.valueOf(aVar.mtO);
        objArr[12] = Integer.valueOf(aVar.mtP);
        objArr[13] = Integer.valueOf(aVar.mtQ);
        objArr[14] = Integer.valueOf(aVar.mtR);
        objArr[15] = Integer.valueOf(aVar.mtS ? 1 : 0);
        if (!aVar.mtT) {
            i = 0;
        }
        objArr[16] = Integer.valueOf(i);
        objArr[17] = Integer.valueOf(aVar.mtU);
        return String.format(str, objArr);
    }
}
