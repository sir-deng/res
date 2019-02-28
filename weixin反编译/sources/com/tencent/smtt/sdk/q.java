package com.tencent.smtt.sdk;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.smtt.export.external.DexLoader;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.o;
import java.io.File;
import java.io.IOException;

public class q {
    private static q AgO;
    private boolean AgN;

    private q() {
    }

    public static q cFw() {
        if (AgO == null) {
            synchronized (q.class) {
                if (AgO == null) {
                    AgO = new q();
                }
            }
        }
        return AgO;
    }

    public final synchronized boolean bH(Context context, String str) {
        boolean z;
        File file = new File(context.getFilesDir(), str);
        z = file.exists() && file.isFile();
        return z;
    }

    public final synchronized void gO(Context context) {
        if (!this.AgN) {
            if (bH(context, "bugly_switch.txt")) {
                Object cFN;
                if (x.hs(context)) {
                    cFN = x.cFN();
                } else {
                    t.cFy();
                    File hi = t.hi(context);
                    if (hi == null) {
                        TbsLog.i("TbsExtensionFunMana", "getTbsCoreShareDir is null");
                    }
                    if (hi.listFiles() == null || hi.listFiles().length <= 0) {
                        TbsLog.i("TbsExtensionFunMana", "getTbsCoreShareDir is empty!");
                    } else {
                        String cFN2 = hi.getAbsolutePath();
                    }
                }
                if (TextUtils.isEmpty(cFN2)) {
                    TbsLog.i("TbsExtensionFunMana", "bugly init ,corePath is null");
                } else {
                    t.cFy();
                    File hi2 = t.hi(context);
                    if (hi2 == null) {
                        TbsLog.i("TbsExtensionFunMana", "bugly init ,optDir is null");
                    } else {
                        try {
                            String parent = new File(cFN2, "tbs_bugly_dex.jar").getParent();
                            String[] strArr = new String[]{r4.getAbsolutePath()};
                            String absolutePath = hi2.getAbsolutePath();
                            o.b(new DexLoader(parent, context, strArr, absolutePath, null).loadClass("com.tencent.smtt.tbs.bugly.TBSBuglyManager"), "initBugly", new Class[]{Context.class, String.class, String.class, String.class}, context, cFN2, String.valueOf(WebView.getTbsSDKVersion(context)), String.valueOf(WebView.getTbsCoreVersion(context)));
                            this.AgN = true;
                            TbsLog.i("TbsExtensionFunMana", "initTbsBuglyIfNeed success!");
                        } catch (Throwable th) {
                            TbsLog.i("TbsExtensionFunMana", "bugly init ,try init bugly failed(need new core):" + Log.getStackTraceString(th));
                        }
                    }
                }
            } else {
                TbsLog.i("TbsExtensionFunMana", "bugly is forbiden!!");
            }
        }
    }

    public final synchronized boolean m(Context context, String str, boolean z) {
        boolean z2 = false;
        synchronized (this) {
            if (context != null) {
                File file = new File(context.getFilesDir(), str);
                if (z) {
                    if (!file.exists()) {
                        try {
                            if (file.createNewFile()) {
                                z2 = true;
                            }
                        } catch (IOException e) {
                            TbsLog.e("TbsExtensionFunMana", "setFunctionEnable,createNewFile fail:" + str);
                        }
                    }
                } else if (file.exists()) {
                    if (file.delete()) {
                        z2 = true;
                    } else {
                        TbsLog.e("TbsExtensionFunMana", "setFunctionEnable,file.delete fail:" + str);
                    }
                }
                z2 = true;
            }
        }
        return z2;
    }
}
