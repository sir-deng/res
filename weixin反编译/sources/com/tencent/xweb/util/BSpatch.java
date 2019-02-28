package com.tencent.xweb.util;

import com.tencent.mm.compatible.util.k;
import org.xwalk.core.Log;

public class BSpatch {
    public native int nativeDoPatch(String str, String str2, String str3);

    public static int an(String str, String str2, String str3) {
        Log.i("BSpatch", "doPatch oldFile:" + str + ",patchFile:" + str2 + ",newFile:" + str3);
        long currentTimeMillis = System.currentTimeMillis();
        e.cJH();
        Object obj = null;
        if (str.equals(str3)) {
            str3 = str + ".temp";
            obj = 1;
        }
        int nativeDoPatch = new BSpatch().nativeDoPatch(str, str2, str3);
        if (nativeDoPatch < 0) {
            Log.i("BSpatch", "doPatch failed");
            e.cJI();
        } else {
            Log.i("BSpatch", "doPatch successful");
            if (obj != null) {
                if (a.fv(str3, str)) {
                    a.deleteFile(str3);
                } else {
                    Log.e("BSpatch", "doPatch same path, copy failed");
                    return -1;
                }
            }
            e.gJ(System.currentTimeMillis() - currentTimeMillis);
        }
        return nativeDoPatch;
    }

    static {
        k.b("bspatch_utils", BSpatch.class.getClassLoader());
    }
}
