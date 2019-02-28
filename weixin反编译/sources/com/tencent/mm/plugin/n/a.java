package com.tencent.mm.plugin.n;

import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.UnsupportedEncodingException;

public final class a {
    public String nHe;
    public String nHf;
    public int nHg;
    public int nHh;
    public int nHi;
    public int nHj;
    public int nHk;
    public int nHl;

    public static String bQ(String str) {
        byte[] d = FileOp.d(str, 0, 6);
        if (d == null || d.length != 6) {
            return "";
        }
        String str2 = "";
        try {
            return new String(d, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            x.e("MicroMsg.ImgExtInfoReport", "getFileExt UnsupportedEncodingException:" + e);
            return str2;
        }
    }

    public static String Dd(String str) {
        if (bi.oN(str)) {
            return "";
        }
        return str.replace(",", ";");
    }
}
