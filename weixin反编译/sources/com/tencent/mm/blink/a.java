package com.tencent.mm.blink;

import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;

public final class a {
    private static long gyH;
    public static final int[] gyI = new int[]{0, 1, 2};
    public static final int[] gyJ = new int[]{3, 13, 23};
    public static final int[] gyK = new int[]{4, 14, 24};
    public static final int[] gyL = new int[]{5, 15, 25};
    public static final int[] gyM = new int[]{6, 16, 26};
    public static final int[] gyN = new int[]{7, 17, 27};
    public static final int[] gyO = new int[]{8, 18, 28};
    public static final int[] gyP = new int[]{9, 19, 29};
    public static final int[] gyQ = new int[]{63, 69, 75};
    public static final int[] gyR = new int[]{64, 70, 76};
    public static final int[] gyS = new int[]{65, 71, 77};
    public static final int[] gyT = new int[]{66, 72, 78};
    private static final ArrayList<long[]> gyU = new ArrayList();
    private static long gyV = 0;
    private static boolean gyW = false;
    private static long gyX = 0;
    private static long gyY = 0;
    private static byte gyZ = (byte) 0;

    public static void at(long j) {
        gyH = j;
    }

    public static void h(String str, long j) {
        long nanoTime = System.nanoTime() - j;
        x.i("Blink-LOG", "since the %s : %s", str, Long.valueOf(nanoTime));
    }

    public static void ee(String str) {
        long currentTimeMillis = System.currentTimeMillis() - gyH;
        x.i("Blink-LOG", "since startup %s : %s", str, Long.valueOf(currentTimeMillis));
        String.format("since startup %s : %s", new Object[]{str, Long.valueOf(currentTimeMillis)});
    }

    public static void i(long j, long j2) {
        gyU.add(new long[]{709, j, j2});
    }

    public static void j(long j, long j2) {
        gyU.add(new long[]{783, j, j2});
    }

    public static void wo() {
        gyV = System.currentTimeMillis();
    }

    public static void wp() {
        if (fh(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT)) {
            j(1, System.currentTimeMillis() - gyV);
            j(2, 1);
        }
    }

    public static void ef(String str) {
        if (fh(WXMediaMessage.TITLE_LENGTH_LIMIT) && ad.cgd().equals(str)) {
            gyW = true;
            x.i("MicroMsg.BlinkStartup", "report this time");
        }
    }

    public static void wq() {
        fh(WXMediaMessage.TITLE_LENGTH_LIMIT);
    }

    public static void au(long j) {
        if (System.currentTimeMillis() - j > 200) {
            fh(WXMediaMessage.TITLE_LENGTH_LIMIT);
            gyW = false;
        }
    }

    public static void wr() {
        fh(WXMediaMessage.TITLE_LENGTH_LIMIT);
        gyW = false;
    }

    public static void av(long j) {
        gyX = j;
        gyY = j;
    }

    private static void a(int[] iArr, long j) {
        x.i("MicroMsg.BlinkStartup", "%s %s", Integer.valueOf(iArr[0]), Long.valueOf(j));
        i((long) iArr[0], j);
        if (com.tencent.mm.e.a.oG) {
            i((long) iArr[1], j);
        } else {
            i((long) iArr[2], j);
        }
    }

    public static boolean ws() {
        if (gyW) {
            return fh(256);
        }
        return false;
    }

    private static boolean fh(int i) {
        if ((gyZ & i) != 0) {
            return false;
        }
        gyZ = (byte) (gyZ | i);
        x.i("MicroMsg.BlinkStartup", "checkAndMark bit 0x%x", Integer.valueOf(i));
        return true;
    }

    private static void aw(long j) {
        if (j > 10000) {
            wr();
        }
    }

    public static void fi(int i) {
        if (gyY == 0) {
            x.e("MicroMsg.BlinkStartup", "sLastPhaseTimestamp is 0");
            return;
        }
        long currentTimeMillis = System.currentTimeMillis() - gyY;
        switch (i) {
            case 1:
                if (fh(1)) {
                    a(gyJ, currentTimeMillis);
                    gyY = System.currentTimeMillis();
                    return;
                }
                return;
            case 2:
                if (fh(2)) {
                    a(gyK, currentTimeMillis);
                    gyY = System.currentTimeMillis();
                    return;
                }
                return;
            case 3:
                if (fh(4)) {
                    a(gyL, currentTimeMillis);
                    gyY = System.currentTimeMillis();
                    return;
                }
                return;
            case 4:
                if (fh(8)) {
                    a(gyM, currentTimeMillis);
                    gyY = System.currentTimeMillis();
                    return;
                }
                return;
            case 5:
                if (fh(16)) {
                    aw(currentTimeMillis);
                    a(gyN, currentTimeMillis);
                    gyY = System.currentTimeMillis();
                    return;
                }
                return;
            case 6:
                if (fh(32)) {
                    aw(currentTimeMillis);
                    a(gyO, currentTimeMillis);
                    gyY = System.currentTimeMillis();
                    return;
                }
                return;
            default:
                return;
        }
    }

    public static void wt() {
        long currentTimeMillis = System.currentTimeMillis() - gyX;
        a(gyP, currentTimeMillis);
        if (currentTimeMillis <= 3000) {
            a(gyQ, 1);
        } else if (currentTimeMillis > 3000 && currentTimeMillis <= 6000) {
            a(gyR, 1);
        } else if (currentTimeMillis <= 6000 || currentTimeMillis > 10000) {
            a(gyT, 1);
        } else {
            a(gyS, 1);
        }
        a(gyI, 1);
    }

    public static ArrayList<long[]> wu() {
        return gyU;
    }
}
