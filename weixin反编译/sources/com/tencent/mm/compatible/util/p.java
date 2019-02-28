package com.tencent.mm.compatible.util;

import java.io.CharArrayWriter;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.charset.IllegalCharsetNameException;
import java.nio.charset.UnsupportedCharsetException;
import java.security.AccessController;
import java.util.BitSet;

public final class p {
    static BitSet gJG = new BitSet(256);
    static String gJH;

    static {
        int i;
        gJH = null;
        for (i = 97; i <= 122; i++) {
            gJG.set(i);
        }
        for (i = 65; i <= 90; i++) {
            gJG.set(i);
        }
        for (i = 48; i <= 57; i++) {
            gJG.set(i);
        }
        gJG.set(45);
        gJG.set(95);
        gJG.set(46);
        gJG.set(42);
        gJH = (String) AccessController.doPrivileged(new i("file.encoding"));
    }

    @Deprecated
    public static String encode(String str) {
        String str2 = null;
        try {
            return encode(str, gJH);
        } catch (UnsupportedEncodingException e) {
            return str2;
        }
    }

    public static String encode(String str, String str2) {
        StringBuffer stringBuffer = new StringBuffer(str.length());
        CharArrayWriter charArrayWriter = new CharArrayWriter();
        if (str2 == null) {
            throw new NullPointerException("charsetName");
        }
        try {
            Charset forName = Charset.forName(str2);
            Object obj = null;
            int i = 0;
            while (i < str.length()) {
                char charAt = str.charAt(i);
                if (gJG.get(charAt)) {
                    if (charAt == ' ') {
                        obj = 1;
                    }
                    stringBuffer.append((char) charAt);
                    i++;
                } else {
                    int i2;
                    char i22 = charAt;
                    while (true) {
                        charArrayWriter.write(i22);
                        if (i22 >= 55296 && i22 <= 56319 && i + 1 < str.length()) {
                            i22 = str.charAt(i + 1);
                            if (i22 >= 56320 && i22 <= 57343) {
                                charArrayWriter.write(i22);
                                i++;
                            }
                        }
                        i22 = i + 1;
                        if (i22 >= str.length()) {
                            break;
                        }
                        BitSet bitSet = gJG;
                        char charAt2 = str.charAt(i22);
                        if (bitSet.get(charAt2)) {
                            break;
                        }
                        char c = charAt2;
                        i = i22;
                        i22 = c;
                    }
                    charArrayWriter.flush();
                    String str3 = new String(charArrayWriter.toCharArray());
                    o oVar = new o();
                    byte[] bytes = str3.getBytes(forName);
                    if (bytes == null) {
                        bytes = str3.getBytes();
                    }
                    for (int i3 = 0; i3 < bytes.length; i3++) {
                        stringBuffer.append('%');
                        charAt = Character.forDigit((bytes[i3] >> 4) & 15, 16);
                        if (Character.isLetter(charAt)) {
                            charAt = (char) (charAt - 32);
                        }
                        stringBuffer.append(charAt);
                        charAt = Character.forDigit(bytes[i3] & 15, 16);
                        if (Character.isLetter(charAt)) {
                            charAt = (char) (charAt - 32);
                        }
                        stringBuffer.append(charAt);
                    }
                    charArrayWriter.reset();
                    i = i22;
                    obj = 1;
                }
            }
            return obj != null ? stringBuffer.toString() : str;
        } catch (IllegalCharsetNameException e) {
            throw new UnsupportedEncodingException(str2);
        } catch (UnsupportedCharsetException e2) {
            throw new UnsupportedEncodingException(str2);
        }
    }
}
