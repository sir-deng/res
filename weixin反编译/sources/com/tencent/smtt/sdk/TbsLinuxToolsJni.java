package com.tencent.smtt.sdk;

import android.content.Context;
import com.tencent.smtt.utils.TbsLog;
import java.io.File;

class TbsLinuxToolsJni {
    private static boolean Ahl = false;
    private static boolean Ahm = false;

    public TbsLinuxToolsJni(Context context) {
        synchronized (TbsLinuxToolsJni.class) {
            if (Ahm) {
                return;
            }
            Ahm = true;
            try {
                File file;
                if (x.hs(context)) {
                    file = new File(x.cFN());
                } else {
                    t.cFy();
                    file = t.hi(context);
                }
                if (file != null) {
                    if (!(new File(file.getAbsolutePath() + File.separator + "liblinuxtoolsfortbssdk_jni.so").exists() || x.hs(context))) {
                        t.cFy();
                        file = t.hh(context);
                    }
                    if (file != null) {
                        System.load(file.getAbsolutePath() + File.separator + "liblinuxtoolsfortbssdk_jni.so");
                        Ahl = true;
                    }
                }
                ChmodInner("/checkChmodeExists", "700");
            } catch (Throwable th) {
                Ahl = false;
            }
            return;
        }
    }

    private native int ChmodInner(String str, String str2);

    public final int gd(String str, String str2) {
        if (Ahl) {
            return ChmodInner(str, str2);
        }
        TbsLog.e("TbsLinuxToolsJni", "jni not loaded!", true);
        return -1;
    }
}
