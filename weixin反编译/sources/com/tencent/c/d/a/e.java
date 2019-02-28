package com.tencent.c.d.a;

import android.text.TextUtils;
import com.tencent.c.f.h;
import java.io.File;

public final class e {
    public static boolean cEl() {
        try {
            Object obj = System.getenv("PATH");
            if (TextUtils.isEmpty(obj)) {
                for (String file : obj.split(":")) {
                    File file2 = new File(file, "su");
                    if (file2.exists()) {
                        h.abG("SuFile found : " + file2.toString());
                        return true;
                    }
                }
            } else if (new File("/system/bin/su").exists()) {
                h.abG("SuFile found : /system/bin/su");
                return true;
            } else if (new File("/system/xbin/su").exists()) {
                h.abG("SuFile found : /system/xbin/su");
                return true;
            }
        } catch (Throwable th) {
            h.k(th);
        }
        h.abG("SuFile not found");
        return false;
    }
}
