package com.tencent.mm.compatible.util;

import android.os.Build.VERSION;
import android.os.StatFs;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;

public final class f {
    public static boolean fN(int i) {
        return VERSION.SDK_INT >= i;
    }

    public static boolean fO(int i) {
        return VERSION.SDK_INT < i;
    }

    public static boolean zl() {
        boolean z = false;
        String absolutePath = h.getExternalStorageDirectory().getAbsolutePath();
        if (e.bnD.equalsIgnoreCase(absolutePath)) {
            try {
                if (h.getExternalStorageState().equals("mounted") && new File(absolutePath).canWrite()) {
                    return true;
                }
                return z;
            } catch (Exception e) {
                x.w("MicroMsg.CUtil", "summer isSDCardAvail 1 e: " + e.getMessage() + " SDCARD_ROOT: " + e.bnD);
                return z;
            }
        }
        try {
            return new File(e.bnD).canWrite();
        } catch (Exception e2) {
            x.w("MicroMsg.CUtil", "summer isSDCardAvail 1 e: " + e2.getMessage() + " SDCARD_ROOT: " + e.bnD);
            return z;
        }
    }

    public static boolean zm() {
        StatFs statFs;
        long blockSize;
        Exception e;
        long j;
        long j2;
        if (!zl()) {
            return false;
        }
        long j3 = 0;
        long j4 = 0;
        StatFs statFs2;
        try {
            statFs2 = new StatFs(e.bnD);
            try {
                j3 = (long) statFs2.getBlockCount();
                j4 = (long) statFs2.getAvailableBlocks();
                statFs = statFs2;
                blockSize = (long) statFs2.getBlockSize();
            } catch (Exception e2) {
                e = e2;
                x.e("MicroMsg.CUtil", "checkSDCardFull", e);
                statFs = statFs2;
                blockSize = 0;
                if (statFs != null) {
                    return false;
                }
                if (j3 > 0) {
                    return false;
                }
                if (j3 - j4 >= 0) {
                    return false;
                }
                j = blockSize * j4;
                j2 = blockSize * j3;
                x.i("MicroMsg.CUtil", "checkSDCardFull blockCount: %d, availCount: %d, blockSize: %d, totalSize: %d, availSize: %d, used percent: %d", Long.valueOf(j3), Long.valueOf(j4), Long.valueOf(blockSize), Long.valueOf(j2), Long.valueOf(j), Integer.valueOf((int) (((j3 - j4) * 100) / j3)));
                if (95 <= ((int) (((j3 - j4) * 100) / j3))) {
                    return false;
                }
                if (j <= 314572800) {
                    return false;
                }
                x.i("MicroMsg.CUtil", "checkSDCardFull is full!");
                return true;
            }
        } catch (Exception e3) {
            e = e3;
            statFs2 = null;
            x.e("MicroMsg.CUtil", "checkSDCardFull", e);
            statFs = statFs2;
            blockSize = 0;
            if (statFs != null) {
                return false;
            }
            if (j3 > 0) {
                return false;
            }
            if (j3 - j4 >= 0) {
                return false;
            }
            j = blockSize * j4;
            j2 = blockSize * j3;
            x.i("MicroMsg.CUtil", "checkSDCardFull blockCount: %d, availCount: %d, blockSize: %d, totalSize: %d, availSize: %d, used percent: %d", Long.valueOf(j3), Long.valueOf(j4), Long.valueOf(blockSize), Long.valueOf(j2), Long.valueOf(j), Integer.valueOf((int) (((j3 - j4) * 100) / j3)));
            if (95 <= ((int) (((j3 - j4) * 100) / j3))) {
                return false;
            }
            if (j <= 314572800) {
                return false;
            }
            x.i("MicroMsg.CUtil", "checkSDCardFull is full!");
            return true;
        }
        if (statFs != null) {
            return false;
        }
        if (j3 > 0) {
            return false;
        }
        if (j3 - j4 >= 0) {
            return false;
        }
        j = blockSize * j4;
        j2 = blockSize * j3;
        x.i("MicroMsg.CUtil", "checkSDCardFull blockCount: %d, availCount: %d, blockSize: %d, totalSize: %d, availSize: %d, used percent: %d", Long.valueOf(j3), Long.valueOf(j4), Long.valueOf(blockSize), Long.valueOf(j2), Long.valueOf(j), Integer.valueOf((int) (((j3 - j4) * 100) / j3)));
        if (95 <= ((int) (((j3 - j4) * 100) / j3))) {
            return false;
        }
        if (j <= 314572800) {
            return false;
        }
        x.i("MicroMsg.CUtil", "checkSDCardFull is full!");
        return true;
    }

    public static boolean aD(long j) {
        Exception e;
        if (zl()) {
            StatFs statFs;
            long blockCount;
            long j2;
            try {
                statFs = new StatFs(e.bnD);
                try {
                    blockCount = (long) statFs.getBlockCount();
                    try {
                        j2 = blockCount;
                        blockCount = (long) statFs.getAvailableBlocks();
                    } catch (Exception e2) {
                        e = e2;
                        x.e("MicroMsg.CUtil", "isSDCardHaveEnoughSpace", e);
                        j2 = blockCount;
                        blockCount = 0;
                        return statFs != null ? false : false;
                    }
                } catch (Exception e3) {
                    e = e3;
                    blockCount = 0;
                    x.e("MicroMsg.CUtil", "isSDCardHaveEnoughSpace", e);
                    j2 = blockCount;
                    blockCount = 0;
                    if (statFs != null) {
                    }
                }
            } catch (Exception e4) {
                e = e4;
                statFs = null;
                blockCount = 0;
                x.e("MicroMsg.CUtil", "isSDCardHaveEnoughSpace", e);
                j2 = blockCount;
                blockCount = 0;
                if (statFs != null) {
                }
            }
            if (statFs != null || j2 <= 0 || j2 - r4 < 0) {
                return false;
            }
            if (((long) statFs.getFreeBlocks()) * ((long) statFs.getBlockSize()) >= j) {
                return true;
            }
            x.i("MicroMsg.CUtil", "summer isSDCardHaveEnoughSpace needSize: " + j + " not enough and ret false");
            return false;
        }
        x.i("MicroMsg.CUtil", "summer isSDCardHaveEnoughSpace sdcard not avail and ret false");
        return false;
    }
}
