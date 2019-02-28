package com.tencent.mm.plugin.report.service;

import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.os.StatFs;
import android.util.SparseArray;
import com.tencent.mm.compatible.util.h;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiOpenWeRunSetting;
import com.tencent.mm.plugin.appbrand.jsapi.be;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.GameJsApiGetOpenDeviceId;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.regex.Pattern;

public final class f {
    private static SparseArray<HashMap<Integer, Integer>> pWA = new SparseArray();
    private static boolean pWB = true;
    private static long pWC = 0;
    private static long pWD = 0;
    private static long pWE = 0;
    private static SparseArray<Long> pWz = new SparseArray();

    public static final class a {
        public static a pWJ;
        public volatile boolean hasInit;
        public long[] pWF;
        public int pWG;
        public String pWH;
        public long pWI;

        class a implements FileFilter {
            a() {
            }

            public final boolean accept(File file) {
                if (Pattern.matches("cpu[0-9]", file.getName())) {
                    return true;
                }
                return false;
            }
        }

        public static synchronized a boU() {
            a aVar;
            synchronized (a.class) {
                if (pWJ == null) {
                    aVar = new a();
                    pWJ = aVar;
                    aVar.pWG = yF();
                    pWJ.pWH = yz();
                    a aVar2 = pWJ;
                    ActivityManager activityManager = (ActivityManager) ad.getContext().getSystemService("activity");
                    MemoryInfo memoryInfo = new MemoryInfo();
                    activityManager.getMemoryInfo(memoryInfo);
                    aVar2.pWI = memoryInfo.availMem >> 10;
                    aVar = pWJ;
                    long[] jArr = new long[2];
                    StatFs statFs = new StatFs(h.getDataDirectory().getPath());
                    jArr[0] = ((long) statFs.getBlockCount()) * ((long) statFs.getBlockSize());
                    StatFs statFs2 = new StatFs(h.getDataDirectory().getPath());
                    jArr[1] = ((long) statFs2.getAvailableBlocks()) * ((long) statFs2.getBlockSize());
                    aVar.pWF = jArr;
                    pWJ.hasInit = true;
                }
                aVar = pWJ;
            }
            return aVar;
        }

        private static String yz() {
            String trim;
            Throwable e;
            Throwable th;
            String str = "N/A";
            FileReader fileReader;
            BufferedReader bufferedReader;
            try {
                fileReader = new FileReader("/sys/devices/system/cpu/cpu0/cpufreq/scaling_cur_freq");
                try {
                    bufferedReader = new BufferedReader(fileReader);
                    try {
                        trim = bufferedReader.readLine().trim();
                        try {
                            bufferedReader.close();
                            try {
                                fileReader.close();
                            } catch (Throwable e2) {
                                x.printErrStackTrace("MicroMsg.ReportLogInfo", e2, "", new Object[0]);
                            }
                            try {
                                bufferedReader.close();
                            } catch (Throwable e22) {
                                x.printErrStackTrace("MicroMsg.ReportLogInfo", e22, "", new Object[0]);
                            }
                        } catch (FileNotFoundException e3) {
                            e22 = e3;
                            try {
                                x.printErrStackTrace("MicroMsg.ReportLogInfo", e22, "", new Object[0]);
                                if (fileReader != null) {
                                    try {
                                        fileReader.close();
                                    } catch (Throwable e222) {
                                        x.printErrStackTrace("MicroMsg.ReportLogInfo", e222, "", new Object[0]);
                                    }
                                }
                                if (bufferedReader != null) {
                                    try {
                                        bufferedReader.close();
                                    } catch (Throwable e2222) {
                                        x.printErrStackTrace("MicroMsg.ReportLogInfo", e2222, "", new Object[0]);
                                    }
                                }
                                return trim;
                            } catch (Throwable th2) {
                                th = th2;
                                if (fileReader != null) {
                                    try {
                                        fileReader.close();
                                    } catch (Throwable e22222) {
                                        x.printErrStackTrace("MicroMsg.ReportLogInfo", e22222, "", new Object[0]);
                                    }
                                }
                                if (bufferedReader != null) {
                                    try {
                                        bufferedReader.close();
                                    } catch (Throwable e222222) {
                                        x.printErrStackTrace("MicroMsg.ReportLogInfo", e222222, "", new Object[0]);
                                    }
                                }
                                throw th;
                            }
                        } catch (IOException e4) {
                            e222222 = e4;
                            x.printErrStackTrace("MicroMsg.ReportLogInfo", e222222, "", new Object[0]);
                            if (fileReader != null) {
                                try {
                                    fileReader.close();
                                } catch (Throwable e2222222) {
                                    x.printErrStackTrace("MicroMsg.ReportLogInfo", e2222222, "", new Object[0]);
                                }
                            }
                            if (bufferedReader != null) {
                                try {
                                    bufferedReader.close();
                                } catch (Throwable e22222222) {
                                    x.printErrStackTrace("MicroMsg.ReportLogInfo", e22222222, "", new Object[0]);
                                }
                            }
                            return trim;
                        }
                    } catch (Throwable th3) {
                        e22222222 = th3;
                        trim = str;
                    } catch (Throwable th32) {
                        e22222222 = th32;
                        trim = str;
                        x.printErrStackTrace("MicroMsg.ReportLogInfo", e22222222, "", new Object[0]);
                        if (fileReader != null) {
                            fileReader.close();
                        }
                        if (bufferedReader != null) {
                            bufferedReader.close();
                        }
                        return trim;
                    }
                } catch (Throwable th322) {
                    bufferedReader = null;
                    e22222222 = th322;
                    trim = str;
                    x.printErrStackTrace("MicroMsg.ReportLogInfo", e22222222, "", new Object[0]);
                    if (fileReader != null) {
                        fileReader.close();
                    }
                    if (bufferedReader != null) {
                        bufferedReader.close();
                    }
                    return trim;
                } catch (Throwable th3222) {
                    bufferedReader = null;
                    e22222222 = th3222;
                    trim = str;
                    x.printErrStackTrace("MicroMsg.ReportLogInfo", e22222222, "", new Object[0]);
                    if (fileReader != null) {
                        fileReader.close();
                    }
                    if (bufferedReader != null) {
                        bufferedReader.close();
                    }
                    return trim;
                } catch (Throwable th4) {
                    th3222 = th4;
                    bufferedReader = null;
                    if (fileReader != null) {
                        fileReader.close();
                    }
                    if (bufferedReader != null) {
                        bufferedReader.close();
                    }
                    throw th3222;
                }
            } catch (Throwable th32222) {
                bufferedReader = null;
                fileReader = null;
                e22222222 = th32222;
                trim = str;
                x.printErrStackTrace("MicroMsg.ReportLogInfo", e22222222, "", new Object[0]);
                if (fileReader != null) {
                    fileReader.close();
                }
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
                return trim;
            } catch (Throwable th322222) {
                bufferedReader = null;
                fileReader = null;
                e22222222 = th322222;
                trim = str;
                x.printErrStackTrace("MicroMsg.ReportLogInfo", e22222222, "", new Object[0]);
                if (fileReader != null) {
                    fileReader.close();
                }
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
                return trim;
            } catch (Throwable th5) {
                th322222 = th5;
                bufferedReader = null;
                fileReader = null;
                if (fileReader != null) {
                    fileReader.close();
                }
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
                throw th322222;
            }
            return trim;
        }

        private static int yF() {
            try {
                return new File("/sys/devices/system/cpu/").listFiles(new a()).length;
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.ReportLogInfo", e, "", new Object[0]);
                return 1;
            }
        }
    }

    public static void vR(int i) {
        if (pWB) {
            pWz.put(i, Long.valueOf(bi.Wy()));
            x.d("MicroMsg.ReportLogInfo", "ReportLogInfo operationBegin eventID:%d  time:%d", Integer.valueOf(i), Long.valueOf(bi.Wy()));
        }
    }

    public static void ee(long j) {
        if (pWB) {
            x.d("MicroMsg.ReportLogInfo", "ReportLogInfo operationBegin eventID:%d  with time:%d", Integer.valueOf(8), Long.valueOf(j));
            pWz.put(8, Long.valueOf(j));
        }
    }

    public static void vS(int i) {
        if (pWB) {
            Long l = (Long) pWz.get(i);
            if (l != null && l.longValue() != -1) {
                pWz.put(i, Long.valueOf(-1));
                long Wy = bi.Wy() - l.longValue();
                if (Wy > 0) {
                    switch (i) {
                        case 8:
                            if (!ad.xnM) {
                                F(1, Wy);
                                E(GameJsApiGetOpenDeviceId.CTRL_BYTE, Wy);
                                g.pWK.c(23, 1, 2, (int) Wy, false);
                                break;
                            }
                            g.pWK.c(23, 4, 5, (int) Wy, false);
                            break;
                        case 9:
                            F(3, Wy);
                            E(be.CTRL_INDEX, Wy);
                            g.pWK.c(27, 1, 2, (int) Wy, false);
                            break;
                        case 10:
                            F(2, Wy);
                            E(JsApiOpenWeRunSetting.CTRL_INDEX, Wy);
                            g.pWK.c(28, 1, 2, (int) Wy, false);
                            break;
                        case 12:
                            F(6, Wy);
                            break;
                        case 13:
                            F(7, Wy);
                            break;
                        case 14:
                            F(8, Wy);
                            break;
                        case 18:
                            F(10, Wy);
                            break;
                        case 19:
                            F(9, Wy);
                            break;
                        case 20:
                            F(12, Wy);
                            break;
                        case 21:
                            F(11, Wy);
                            break;
                        case 22:
                            F(13, Wy);
                            break;
                        case 23:
                            F(16, Wy);
                            break;
                        case 24:
                            F(15, Wy);
                            break;
                        case 25:
                            F(14, Wy);
                            break;
                    }
                    x.i("MicroMsg.ReportLogInfo", "ReportLogInfo operationEnd eventID:%d  time:%d", Integer.valueOf(i), Long.valueOf(Wy));
                }
            }
        }
    }

    private static void E(int i, long j) {
        if (j > 0) {
            if (j < 1000) {
                g.pWK.V(i, 0, 1);
            } else if (j < 2000) {
                g.pWK.V(i, 0, 3);
            } else if (j < 5000) {
                g.pWK.V(i, 0, 5);
            } else if (j < 10000) {
                g.pWK.V(i, 0, 7);
            } else {
                g.pWK.V(i, 0, 9);
            }
        }
    }

    private static void F(int i, long j) {
        long currentTimeMillis;
        if (i == 6) {
            currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis >= pWC + 60000) {
                pWC = currentTimeMillis;
            } else {
                return;
            }
        } else if (i == 7) {
            currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis >= pWD + 60000) {
                pWD = currentTimeMillis;
            } else {
                return;
            }
        } else if (i == 8) {
            currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis >= pWE + 60000) {
                pWE = currentTimeMillis;
            } else {
                return;
            }
        }
        if (a.boU().hasInit) {
            g.pWK.a(11335, true, false, Integer.valueOf(i), Long.valueOf(j), Integer.valueOf(r0.pWG), Long.valueOf(r0.pWF[0]), Long.valueOf(r0.pWF[1]), Long.valueOf(r0.pWI));
            return;
        }
        g.pWK.a(11335, true, false, Integer.valueOf(i), Long.valueOf(j));
    }

    public static void vT(int i) {
        if (pWB) {
            x.d("MicroMsg.ReportLogInfo", "ReportLogInfo stopOperation stop eventID:%d", Integer.valueOf(i));
            pWz.put(i, Long.valueOf(-1));
        }
    }
}
