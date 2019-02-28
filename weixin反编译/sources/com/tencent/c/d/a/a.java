package com.tencent.c.d.a;

import com.tencent.c.f.h;
import java.io.File;

public final class a {
    public static boolean abA(String str) {
        if (!new File(str).exists()) {
            return true;
        }
        try {
            boolean abA = com.tencent.c.d.b.a.abA(str);
            if (!abA) {
                h.abG("BootScriptChecker found no-elf file : " + str);
            }
            return abA;
        } catch (Throwable e) {
            h.k(e);
            return true;
        }
    }

    public static boolean abB(String str) {
        boolean z = true;
        File file = new File(str);
        if (file.exists() && file.length() <= 51200) {
            try {
                String str2 = new String(com.tencent.c.d.b.a.abC(file.getAbsolutePath()));
                z = str2.contains("applypatch ");
                h.abH("BootScriptChecker script (" + str + ") content : \n" + str2);
                if (!z) {
                    h.abG("BootScriptChecker found unofficial file : " + str);
                }
            } catch (Throwable e) {
                h.k(e);
            }
        }
        return z;
    }
}
