package com.tencent.mm.loader.stub;

import android.content.Context;
import android.os.Environment;
import com.tencent.mm.sdk.platformtools.ad;
import java.io.File;

public class a {
    public static String bnD = Environment.getExternalStorageDirectory().getAbsolutePath();
    public static String bnE = "/tencent/MicroMsg/";
    public static String bnF = (bnD + bnE);
    public static final String hbu;
    public static final String hbv = (hbu + "MicroMsg/");
    public static final String hbw = (hbu + "files/public/");
    public static String hbx = (bnF + "crash/");

    static {
        Context context = ad.getContext();
        if (context == null) {
            throw new RuntimeException("MMApplicationContext not initialized.");
        }
        hbu = context.getFilesDir().getParentFile().getAbsolutePath() + "/";
        try {
            File file = new File(hbv);
            if (!file.exists()) {
                file.mkdirs();
            }
        } catch (Error e) {
        }
    }
}
