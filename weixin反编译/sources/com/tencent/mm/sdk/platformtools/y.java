package com.tencent.mm.sdk.platformtools;

import android.util.Base64;
import com.tencent.mm.a.k;
import java.io.UnsupportedEncodingException;
import java.util.regex.Pattern;

public final class y {
    private static final Pattern xny;
    private byte[] key;
    public final bf xnA;
    private final aa<String, String> xnz = new aa(256);

    static {
        String str = "⍆[0-9]+@";
        xny = Pattern.compile(((char) (str.charAt(0) ^ 56506)) + str.substring(1));
    }

    public y(String str) {
        try {
            this.key = str.getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            this.key = str.getBytes();
        }
        this.xnA = new bf(str);
    }

    public final String cY(String str, int i) {
        String substring = str.substring(0, i);
        if (this.xnz.bX(substring)) {
            return (String) this.xnz.get(substring);
        }
        int indexOf = str.indexOf(64, 1);
        int i2 = indexOf + 1;
        try {
            String str2 = new String(k.a(Base64.decode(str.substring(i2, Integer.parseInt(str.substring(1, indexOf)) + i2), 0), this.key), "UTF-8");
            this.xnz.put(substring, str2);
            return str2;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.LogDecryptor", e, "", new Object[0]);
            return "[TD]" + substring;
        }
    }
}
