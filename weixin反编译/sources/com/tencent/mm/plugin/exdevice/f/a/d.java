package com.tencent.mm.plugin.exdevice.f.a;

import android.graphics.Bitmap.CompressFormat;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bi;
import java.io.File;

public final class d {
    private static final String lUA = (e.gJn + "temp/");
    private static final String lUz = (e.gJn + "uploaded_photos/");

    public static String zD(String str) {
        String str2;
        if (bi.oN(str)) {
            str2 = "";
        } else {
            str2 = new File(aFe(), ac.VF(str) + "_t").getAbsolutePath();
        }
        com.tencent.mm.sdk.platformtools.d.b(str, 640, 640, CompressFormat.JPEG, 100, str2);
        System.currentTimeMillis();
        return str2;
    }

    public static File aFe() {
        File file = new File(lUz);
        if (!(file.exists() && file.isDirectory())) {
            file.mkdirs();
        }
        return file;
    }
}
