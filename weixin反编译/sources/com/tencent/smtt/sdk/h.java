package com.tencent.smtt.sdk;

import android.content.Context;
import android.os.Build.VERSION;
import com.tencent.smtt.sdk.m.a;
import com.tencent.smtt.utils.TbsLog;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Properties;

class h {
    private static int AfB = 0;
    private static int AfC = 0;
    static boolean AfD = false;
    private static int AfE = 3;
    private static String AfG = null;
    private static h Afy = null;
    boolean AfA = false;
    private File AfF = null;
    aa Afx = null;
    boolean Afz = false;

    private h() {
    }

    static void Ij(int i) {
        AfB = i;
    }

    private void Ik(int i) {
        String valueOf = String.valueOf(i);
        Properties properties = new Properties();
        properties.setProperty(AfG, valueOf);
        try {
            properties.store(new FileOutputStream(new File(this.AfF, "count.prop")), null);
        } catch (FileNotFoundException e) {
        } catch (IOException e2) {
        }
    }

    static void abN(String str) {
        AfG = str;
    }

    public static int cEP() {
        return AfB;
    }

    static boolean cEQ() {
        AfD = true;
        return true;
    }

    private int cER() {
        Throwable th;
        int i = 0;
        BufferedInputStream bufferedInputStream = null;
        BufferedInputStream bufferedInputStream2;
        try {
            File file = new File(this.AfF, "count.prop");
            if (file.exists()) {
                bufferedInputStream2 = new BufferedInputStream(new FileInputStream(file));
                try {
                    Properties properties = new Properties();
                    properties.load(bufferedInputStream2);
                    i = Integer.valueOf(properties.getProperty(AfG, "1")).intValue();
                    try {
                        bufferedInputStream2.close();
                    } catch (IOException e) {
                    }
                } catch (Exception e2) {
                } catch (Throwable th2) {
                    th = th2;
                    bufferedInputStream = bufferedInputStream2;
                    if (bufferedInputStream != null) {
                        try {
                            bufferedInputStream.close();
                        } catch (IOException e3) {
                        }
                    }
                    throw th;
                }
            }
        } catch (Exception e4) {
            bufferedInputStream2 = null;
            if (bufferedInputStream2 != null) {
                try {
                    bufferedInputStream2.close();
                } catch (IOException e5) {
                }
            }
            return i;
        } catch (Throwable th3) {
            th = th3;
            if (bufferedInputStream != null) {
                bufferedInputStream.close();
            }
            throw th;
        }
        return i;
    }

    public static h nW(boolean z) {
        if (Afy == null && z) {
            synchronized (h.class) {
                if (Afy == null) {
                    Afy = new h();
                }
            }
        }
        return Afy;
    }

    public static boolean useSoftWare() {
        return QbSdk.useSoftWare();
    }

    public final synchronized void a(Context context, s sVar) {
        Object obj = null;
        synchronized (this) {
            TbsLog.addLog(999, null, new Object[0]);
            TbsLog.initIfNeed(context);
            AfC++;
            if (sVar != null) {
                sVar.AgR = AfC == 1;
            }
            m cEY = m.cEY();
            if (cEY.Agn != null) {
                a aVar = cEY.Agn;
                Arrays.fill(aVar.Ags, 0);
                aVar.Agt = 0;
                aVar.Agu = 0;
            }
            cEY.Ago = false;
            if (sVar != null) {
                sVar.b("tbs_rename_task", (byte) 1);
            }
            t.cFy().x(context, AfC == 1);
            if (sVar != null) {
                sVar.b("tbs_rename_task", (byte) 2);
            }
            x.z(context, true);
            if (sVar != null) {
                sVar.b("can_load_x5", (byte) 1);
            }
            boolean r = QbSdk.r(context, false);
            if (sVar != null) {
                sVar.b("can_load_x5", (byte) 2);
            }
            boolean z = VERSION.SDK_INT >= 7;
            Object obj2 = (r && z) ? 1 : null;
            if (obj2 == null) {
                String str = "can_load_x5=" + r + "; is_compatible=" + z;
                TbsLog.e("SDKEngine", "SDKEngine.init canLoadTbs=false; failure: " + str);
                if (!(QbSdk.AeV && this.Afz)) {
                    this.Afz = false;
                    m.cEY().a(context, 405, new Throwable(str));
                }
                this.AfF = t.hk(context);
                this.AfA = true;
            } else if (!this.Afz) {
                try {
                    if (x.hs(context)) {
                        TbsLog.addLog(TbsLog.TBSLOG_CODE_SDK_THIRD_MODE, null, new Object[0]);
                        if (sVar != null) {
                            sVar.b("read_core_info", (byte) 1);
                        }
                        if (sVar != null) {
                            sVar.b("read_core_info", (byte) 2);
                        }
                        this.Afz = false;
                        QbSdk.bG(context, "SDKEngine::useSystemWebView by error_host_unavailable");
                    } else {
                        TbsLog.addLog(TbsLog.TBSLOG_CODE_SDK_SELF_MODE, null, new Object[0]);
                        t.cFy();
                        File hi = t.hi(context);
                        if (AfB == 25436 || AfB == 25437) {
                            obj = 1;
                        }
                        Context applicationContext = obj != null ? context.getApplicationContext() : context;
                        if (hi == null) {
                            this.Afz = false;
                            QbSdk.bG(context, "SDKEngine::useSystemWebView by tbs_core_share_dir null!");
                        } else {
                            String[] dexLoaderFileList = QbSdk.getDexLoaderFileList(context, applicationContext, hi.getAbsolutePath());
                            String cFJ = x.cFJ() != null ? x.cFJ() : hi.getAbsolutePath();
                            TbsLog.i("SDKEngine", "SDKEngine init optDir is " + cFJ);
                            this.Afx = new aa(context, applicationContext, hi.getAbsolutePath(), cFJ, dexLoaderFileList, QbSdk.Afc, sVar);
                            this.Afz = true;
                            this.AfF = t.hk(context);
                            this.AfA = true;
                        }
                    }
                } catch (Throwable th) {
                    TbsLog.e("SDKEngine", "useSystemWebView by exception: " + th);
                    m.cEY().a(context, 327, th);
                    this.Afz = false;
                    QbSdk.bG(context, "SDKEngine::useSystemWebView by exception: " + th);
                }
            }
        }
    }

    public final aa cEO() {
        return this.Afz ? this.Afx : null;
    }

    final boolean getTbsNeedReboot() {
        if (AfD) {
            if (AfG == null) {
                return false;
            }
            int cER = cER();
            if (cER == 0) {
                Ik(1);
            } else if (cER + 1 > AfE) {
                return false;
            } else {
                Ik(cER + 1);
            }
        }
        return AfD;
    }
}
