package com.tencent.mm.bm;

import android.os.StatFs;
import android.util.DisplayMetrics;
import com.tencent.mm.compatible.util.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.as;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public final class c {
    private static String TO(String str) {
        if (bi.oN(str)) {
            return "";
        }
        return str.replaceAll(" ", "").trim().replaceAll("kB", "").trim().replaceAll("\\t", "").trim();
    }

    public static String cdL() {
        String replace;
        Throwable th;
        Closeable bufferedReader;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("/proc/cpuinfo"), "UTF-8"));
            try {
                StringBuilder stringBuilder = new StringBuilder(256);
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    } else if (!bi.oN(readLine)) {
                        stringBuilder.append(TO(readLine)).append(';');
                    }
                }
                replace = stringBuilder.toString().replace(',', '_');
                bi.d(bufferedReader);
            } catch (Throwable th2) {
                th = th2;
                try {
                    x.printErrStackTrace("MicroMsg.PostTaskHardwareInfo", th, "unexpected exception occurred.", new Object[0]);
                    replace = "";
                    bi.d(bufferedReader);
                    return replace;
                } catch (Throwable th3) {
                    th = th3;
                    bi.d(bufferedReader);
                    throw th;
                }
            }
        } catch (Throwable th4) {
            th = th4;
            bufferedReader = null;
            bi.d(bufferedReader);
            throw th;
        }
        return replace;
    }

    public static String cdM() {
        String replace;
        Throwable th;
        Closeable bufferedReader;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("/proc/meminfo"), "UTF-8"));
            try {
                StringBuilder stringBuilder = new StringBuilder(256);
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    } else if (!bi.oN(readLine)) {
                        stringBuilder.append(TO(readLine)).append(';');
                    }
                }
                replace = stringBuilder.toString().replace(',', '_');
                bi.d(bufferedReader);
            } catch (Throwable th2) {
                th = th2;
                try {
                    x.printErrStackTrace("MicroMsg.PostTaskHardwareInfo", th, "unexpected exception occurred.", new Object[0]);
                    replace = "";
                    bi.d(bufferedReader);
                    return replace;
                } catch (Throwable th3) {
                    th = th3;
                    bi.d(bufferedReader);
                    throw th;
                }
            }
        } catch (Throwable th4) {
            th = th4;
            bufferedReader = null;
            bi.d(bufferedReader);
            throw th;
        }
        return replace;
    }

    public static String cdN() {
        String str = "";
        try {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            displayMetrics = ad.getContext().getResources().getDisplayMetrics();
            int i = displayMetrics.widthPixels;
            int i2 = displayMetrics.heightPixels;
            float f = displayMetrics.density;
            float f2 = displayMetrics.xdpi;
            float f3 = displayMetrics.ydpi;
            str = (((("" + "width:" + String.valueOf(i) + ";") + "height:" + String.valueOf(i2) + ";") + "density:" + String.valueOf(f) + ";") + "xd:" + String.valueOf(f2) + ";") + "yd:" + String.valueOf(f3) + ";";
        } catch (Throwable e) {
            x.e("MicroMsg.PostTaskHardwareInfo", "exception:%s", bi.i(e));
        }
        return str.replace(",", "_");
    }

    public static String getRomInfo() {
        String str;
        String str2 = "";
        try {
            StatFs statFs = new StatFs(h.getDataDirectory().getPath());
            long blockSize = (long) statFs.getBlockSize();
            str2 = (str2 + "AvailableSizes:" + (((long) statFs.getAvailableBlocks()) * blockSize) + ";") + "FreeSizes:" + (((long) statFs.getFreeBlocks()) * blockSize) + ";";
            str = str2 + "AllSize:" + (((long) statFs.getBlockCount()) * blockSize) + ";";
        } catch (Throwable e) {
            Throwable th = e;
            str = str2;
            x.e("MicroMsg.PostTaskHardwareInfo", "exception:%s", bi.i(th));
        }
        return str.replace(",", "_");
    }

    public static String cdO() {
        String str;
        String str2 = "";
        try {
            StatFs statFs = new StatFs(h.getExternalStorageDirectory().getPath());
            long blockSize = (long) statFs.getBlockSize();
            str2 = (str2 + "AvailableSizes:" + (((long) statFs.getAvailableBlocks()) * blockSize) + ";") + "FreeSizes:" + (((long) statFs.getFreeBlocks()) * blockSize) + ";";
            str = str2 + "AllSize:" + (((long) statFs.getBlockCount()) * blockSize) + ";";
        } catch (Throwable e) {
            Throwable th = e;
            str = str2;
            x.e("MicroMsg.PostTaskHardwareInfo", "exception:%s", bi.i(th));
        }
        return str.replace(",", "_");
    }

    public static String cdP() {
        as.Hm();
        return (String) com.tencent.mm.y.c.Db().get(71, null);
    }
}
