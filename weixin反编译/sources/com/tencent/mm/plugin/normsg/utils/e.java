package com.tencent.mm.plugin.normsg.utils;

import com.tencent.mm.sdk.platformtools.ad;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public final class e {
    private static String[] oZg = new String[]{Hq(ad.getContext().getFilesDir().getParent() + "/dumeq/tekcos/ved/"), Hq(ad.getContext().getFilesDir().getParent() + "/epip_umeq/ved/")};
    private static String[] oZh = new String[]{Hq(ad.getContext().getFilesDir().getParent() + "/hsifdlog")};
    private static String[] oZi = new String[]{Hq(ad.getContext().getFilesDir().getParent() + "/os.umeq_gubed_collam_cbil/bil/metsys/"), Hq(ad.getContext().getFilesDir().getParent() + "/ecart_umeq/sys/"), Hq(ad.getContext().getFilesDir().getParent() + "/sporp-umeq/nib/metsys/")};
    public static boolean oZj;
    public static boolean oZk;
    public static boolean oZl;

    static {
        String str;
        Throwable th;
        oZj = false;
        oZk = false;
        oZl = false;
        for (String file : oZg) {
            if (new File(file).exists()) {
                oZj = true;
                break;
            }
        }
        File file2 = new File("/proc/tty/drivers");
        if (file2.exists() && file2.canRead() && file2.length() > 0) {
            byte[] bArr = new byte[((int) file2.length())];
            InputStream inputStream = null;
            InputStream fileInputStream;
            try {
                fileInputStream = new FileInputStream(file2);
                try {
                    fileInputStream.read(bArr);
                    try {
                        fileInputStream.close();
                    } catch (IOException e) {
                    }
                } catch (Throwable th2) {
                    Throwable th3 = th2;
                    inputStream = fileInputStream;
                    th = th3;
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e2) {
                        }
                    }
                    throw th;
                }
            } catch (Throwable th4) {
                th = th4;
                if (inputStream != null) {
                    inputStream.close();
                }
                throw th;
            }
            str = new String(bArr);
            while (r0 < r4) {
                if (!str.contains(r5)) {
                    oZk = true;
                    break;
                }
            }
        }
        while (r0 < r3) {
            if (new File(r2).exists()) {
                oZl = true;
                return;
            }
        }
    }

    private static String Hq(String str) {
        String[] strArr = new String[]{ad.getContext().getFilesDir().getParent(), str, e.class.toString()};
        return new StringBuilder(strArr[1].substring(strArr[0].length() + 1)).reverse().toString();
    }
}
