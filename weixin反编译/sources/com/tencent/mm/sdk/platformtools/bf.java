package com.tencent.mm.sdk.platformtools;

import com.tencent.mm.a.d;

public final class bf {
    private final d xqE;
    private aa<String, String> xqF = new aa(256);

    public bf(String str) {
        this.xqE = new d(str);
    }

    public final String decryptTag(String str) {
        Throwable e;
        try {
            if (str.startsWith("!")) {
                if (this.xqF.bu(str)) {
                    return (String) this.xqF.get(str);
                }
                String substring = str.substring(1);
                try {
                    String[] split = substring.split("@");
                    if (split.length > 1) {
                        String str2 = split[0];
                        int intValue = Integer.valueOf(split[0]).intValue();
                        String substring2 = substring.substring(str2.length() + 1, (str2.length() + 1) + intValue);
                        String str3 = this.xqE.bM(substring2) + substring.substring(intValue + (str2.length() + 1));
                        this.xqF.put(str, str3);
                        return str3;
                    }
                    str = substring;
                } catch (Throwable e2) {
                    str = substring;
                    e = e2;
                    x.printErrStackTrace("MicroMsg.TagDecrypter", e, "", new Object[0]);
                    str = "[td]" + str;
                    return str;
                }
            }
        } catch (Exception e3) {
            e = e3;
            x.printErrStackTrace("MicroMsg.TagDecrypter", e, "", new Object[0]);
            str = "[td]" + str;
            return str;
        }
        return str;
    }
}
