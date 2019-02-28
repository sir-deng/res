package com.tencent.mm.bz;

import android.app.ActivityManager;
import android.os.Build.VERSION;
import android.os.Debug;
import android.os.Debug.MemoryInfo;
import android.os.Environment;
import android.os.Process;
import android.widget.Toast;
import com.tencent.mm.a.p;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class b {
    public static final String xLy = (Environment.getExternalStorageDirectory() + "/tencent/MicroMsg/memory/");

    private static boolean cmb() {
        if (c.zl()) {
            File file = new File(xLy);
            if (!file.exists()) {
                file.mkdirs();
            }
            return true;
        }
        x.i("MicroMsg.MemoryDumpManager", "Hprof sdcard is invalid");
        return false;
    }

    private static boolean Q(boolean z, boolean z2) {
        if (!cmb()) {
            return false;
        }
        File file = new File(xLy);
        File[] listFiles = file.listFiles();
        if (listFiles.length == 0) {
            return true;
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
        long time = new Date().getTime();
        boolean z3 = true;
        for (File file2 : listFiles) {
            String name = file2.getName();
            int indexOf = name.indexOf(".hprof");
            if (indexOf > 0) {
                Object substring = name.substring(0, indexOf);
                try {
                    Date parse = simpleDateFormat.parse(substring);
                    if (parse == null) {
                        file2.delete();
                    } else {
                        long time2 = parse.getTime();
                        if (time2 >= time) {
                            file2.delete();
                        } else {
                            time2 = (time - time2) / 86400000;
                            if (time2 >= 3) {
                                file2.delete();
                            } else if (z && time2 < 1) {
                                z3 = false;
                            }
                        }
                    }
                } catch (ParseException e) {
                    x.e("MicroMsg.MemoryDumpManager", "hprofFileCheck parse date fail %s", substring);
                    file2.delete();
                }
            } else {
                file2.delete();
            }
        }
        File[] listFiles2 = file.listFiles();
        if (listFiles2.length <= 5) {
            return z3;
        }
        if (z2) {
            Toast.makeText(ad.getContext(), "dump fail, hprof file size exceed", 0).show();
        }
        x.w("MicroMsg.MemoryDumpManager", "hprofFileCheck hprofFileDir.length() too large " + listFiles2.length);
        return false;
    }

    public static String R(boolean z, boolean z2) {
        if (!Q(z, z2)) {
            return null;
        }
        long currentTimeMillis = System.currentTimeMillis();
        String format = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(new Date());
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(xLy).append(format).append(".hprof");
        String stringBuffer2 = stringBuffer.toString();
        if (J(new File(stringBuffer2).getParentFile())) {
            try {
                cmc();
                Debug.dumpHprofData(stringBuffer2);
                if (z2) {
                    Toast.makeText(ad.getContext(), stringBuffer2 + " hprof file has saved ", 0).show();
                }
                x.i("MicroMsg.MemoryDumpManager", "dump file %s, use time %d", format, Long.valueOf(bi.bA(currentTimeMillis)));
                return stringBuffer2;
            } catch (Exception e) {
                x.e("MicroMsg.MemoryDumpManager", " dumpHprofFile Exception");
                return null;
            }
        }
        x.i("MicroMsg.MemoryDumpManager", "failed to create dir for hprof file: %s", stringBuffer2);
        return null;
    }

    public static String YR(String str) {
        if (!cmb()) {
            return null;
        }
        long currentTimeMillis = System.currentTimeMillis();
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(xLy).append(str).append(".hprof");
        String stringBuffer2 = stringBuffer.toString();
        if (J(new File(stringBuffer2).getParentFile())) {
            try {
                cmc();
                Debug.dumpHprofData(stringBuffer2);
                Toast.makeText(ad.getContext(), stringBuffer2 + " hprof file has saved ", 0).show();
                x.i("MicroMsg.MemoryDumpManager", "dump file %s, use time %d", str, Long.valueOf(bi.bA(currentTimeMillis)));
                File file = new File(stringBuffer2);
                if (file.exists()) {
                    stringBuffer2 = p.a(file, true, null);
                    if (stringBuffer2 != null) {
                        return stringBuffer2;
                    }
                    x.e("MicroMsg.MemoryDumpManager", "zip hprof file fail");
                    return null;
                }
                x.e("MicroMsg.MemoryDumpManager", "Hprof dump file is not exist");
                return null;
            } catch (Exception e) {
                x.e("MicroMsg.MemoryDumpManager", " dumpHprofFile Exception");
                return null;
            }
        }
        x.i("MicroMsg.MemoryDumpManager", "failed to create dir for hprof file: %s", stringBuffer2);
        return null;
    }

    private static boolean J(File file) {
        if (file.exists() || file.mkdirs()) {
            return true;
        }
        return file.exists();
    }

    public static void cmc() {
        Runtime.getRuntime().gc();
        System.runFinalization();
    }

    public static void cmd() {
        InputStreamReader inputStreamReader;
        Throwable th;
        Throwable th2;
        LineNumberReader lineNumberReader = null;
        if (VERSION.SDK_INT >= 14) {
            cme();
            return;
        }
        InputStreamReader inputStreamReader2;
        LineNumberReader lineNumberReader2;
        try {
            Process exec = Runtime.getRuntime().exec("dumpsys meminfo " + Process.myPid());
            inputStreamReader2 = new InputStreamReader(exec.getInputStream());
            try {
                lineNumberReader2 = new LineNumberReader(inputStreamReader2);
                while (true) {
                    try {
                        String readLine = lineNumberReader2.readLine();
                        if (readLine != null) {
                            x.i("MicroMsg.MemoryDumpManager", readLine);
                        } else {
                            exec.waitFor();
                            exec.destroy();
                            try {
                                lineNumberReader2.close();
                                inputStreamReader2.close();
                                return;
                            } catch (IOException e) {
                                return;
                            }
                        }
                    } catch (IOException e2) {
                        inputStreamReader = inputStreamReader2;
                    } catch (InterruptedException e3) {
                        lineNumberReader = lineNumberReader2;
                    } catch (Throwable th3) {
                        th = th3;
                        lineNumberReader = lineNumberReader2;
                        th2 = th;
                    }
                }
            } catch (IOException e4) {
                lineNumberReader2 = null;
                inputStreamReader = inputStreamReader2;
                try {
                    x.e("MicroMsg.MemoryDumpManager", " dumpSysMeminfo IOException");
                    if (lineNumberReader2 != null) {
                        try {
                            lineNumberReader2.close();
                        } catch (IOException e5) {
                            return;
                        }
                    }
                    if (inputStreamReader != null) {
                        inputStreamReader.close();
                    }
                } catch (Throwable th4) {
                    th = th4;
                    inputStreamReader2 = inputStreamReader;
                    lineNumberReader = lineNumberReader2;
                    th2 = th;
                    if (lineNumberReader != null) {
                        try {
                            lineNumberReader.close();
                        } catch (IOException e6) {
                            throw th2;
                        }
                    }
                    if (inputStreamReader2 != null) {
                        inputStreamReader2.close();
                    }
                    throw th2;
                }
            } catch (InterruptedException e7) {
                try {
                    x.e("MicroMsg.MemoryDumpManager", " dumpSysMeminfo InterruptedException");
                    if (lineNumberReader != null) {
                        try {
                            lineNumberReader.close();
                        } catch (IOException e8) {
                            return;
                        }
                    }
                    if (inputStreamReader2 != null) {
                        inputStreamReader2.close();
                    }
                } catch (Throwable th5) {
                    th2 = th5;
                    if (lineNumberReader != null) {
                        lineNumberReader.close();
                    }
                    if (inputStreamReader2 != null) {
                        inputStreamReader2.close();
                    }
                    throw th2;
                }
            }
        } catch (IOException e9) {
            lineNumberReader2 = null;
            x.e("MicroMsg.MemoryDumpManager", " dumpSysMeminfo IOException");
            if (lineNumberReader2 != null) {
                lineNumberReader2.close();
            }
            if (inputStreamReader != null) {
                inputStreamReader.close();
            }
        } catch (InterruptedException e10) {
            inputStreamReader2 = null;
            x.e("MicroMsg.MemoryDumpManager", " dumpSysMeminfo InterruptedException");
            if (lineNumberReader != null) {
                lineNumberReader.close();
            }
            if (inputStreamReader2 != null) {
                inputStreamReader2.close();
            }
        } catch (Throwable th6) {
            th2 = th6;
            inputStreamReader2 = null;
            if (lineNumberReader != null) {
                lineNumberReader.close();
            }
            if (inputStreamReader2 != null) {
                inputStreamReader2.close();
            }
            throw th2;
        }
    }

    public static void cme() {
        ActivityManager activityManager = (ActivityManager) ad.getContext().getSystemService("activity");
        x.i("MicroMsg.MemoryDumpManager", " wechat heap info ");
        x.i("MicroMsg.MemoryDumpManager", " Runtime.totalMemory " + Runtime.getRuntime().totalMemory());
        x.i("MicroMsg.MemoryDumpManager", " Runtime.freeMemory " + Runtime.getRuntime().freeMemory());
        x.i("MicroMsg.MemoryDumpManager", " Runtime.maxMemory " + Runtime.getRuntime().maxMemory());
        x.i("MicroMsg.MemoryDumpManager", " Debug.nativeHeapSize " + Debug.getNativeHeapSize());
        x.i("MicroMsg.MemoryDumpManager", " Debug.nativeHeapAllocatedSize " + Debug.getNativeHeapAllocatedSize());
        for (MemoryInfo memoryInfo : activityManager.getProcessMemoryInfo(new int[]{Process.myPid()})) {
            x.i("MicroMsg.MemoryDumpManager", " wechat memory info");
            x.i("MicroMsg.MemoryDumpManager", " pidMemoryInfo.getTotalPrivateDirty(): " + memoryInfo.getTotalPrivateDirty() + "\n");
            x.i("MicroMsg.MemoryDumpManager", " pidMemoryInfo.getTotalPss(): " + memoryInfo.getTotalPss() + "\n");
            x.i("MicroMsg.MemoryDumpManager", " pidMemoryInfo.getTotalSharedDirty(): " + memoryInfo.getTotalSharedDirty() + "\n");
        }
    }
}
