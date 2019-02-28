package com.tencent.mm.plugin.backup.e;

import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public final class k extends com.tencent.mm.plugin.backup.a.a {
    private static String END = "img";
    private static String ksV = "icon_";
    private static String ksW = "iphone";
    private static String ksX = "android";
    private static String ksY = "s60v3";
    private static String ksZ = "s60v5";
    private static k kta;
    private Map<String, a> ktb = null;

    public static class a {
        public String ktc = "";
        public String ktd = "";
        public String kte = "";
        public String ktf = "";

        public a(String str, String str2, String str3, String str4) {
            this.ktc = str;
            this.ktd = str2;
            this.kte = str3;
            this.ktf = str4;
        }

        public final String toString() {
            return this.ktc + " " + this.ktd + " " + this.kte + " " + this.ktf;
        }
    }

    public static a wb(String str) {
        if (kta == null) {
            kta = new k();
        }
        k kVar = kta;
        if (kVar.ktb == null) {
            kVar.apY();
        }
        for (a aVar : kVar.ktb.values()) {
            if (aVar.ktd != null && aVar.ktd.equals(str)) {
                return aVar;
            }
        }
        return null;
    }

    public static a wc(String str) {
        if (kta == null) {
            com.tencent.mm.plugin.backup.a.a kVar = new k();
            kta = kVar;
            com.tencent.mm.plugin.backup.a.a.a(kVar);
        }
        k kVar2 = kta;
        if (kVar2.ktb == null) {
            kVar2.apY();
        }
        return (a) kVar2.ktb.get(str);
    }

    public final void aoN() {
        kta = null;
    }

    public k() {
        apY();
    }

    private void apY() {
        int i;
        Throwable e;
        Throwable e2;
        this.ktb = new HashMap();
        InputStream open;
        BufferedReader bufferedReader;
        try {
            open = ad.getContext().getAssets().open("emojiconf");
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(open, ProtocolPackage.ServerEncoding));
                i = 0;
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        try {
                            bufferedReader.close();
                            if (open != null) {
                                open.close();
                            }
                        } catch (Exception e3) {
                        }
                    } else if (readLine.contains(ksV)) {
                        a aVar = new a();
                        while (true) {
                            String readLine2 = bufferedReader.readLine();
                            if (readLine2 != null && !readLine2.contains(END)) {
                                int indexOf = readLine2.indexOf("=");
                                if (indexOf + 1 >= readLine2.length()) {
                                    break;
                                }
                                String substring = readLine2.substring(indexOf + 1);
                                if (readLine2.startsWith(ksW)) {
                                    aVar.ktd = substring;
                                } else if (readLine2.startsWith(ksX)) {
                                    aVar.ktc = substring;
                                } else {
                                    try {
                                        if (readLine2.startsWith(ksY)) {
                                            aVar.kte = substring;
                                        } else if (readLine2.startsWith(ksZ)) {
                                            aVar.ktf = substring;
                                        }
                                    } catch (IOException e4) {
                                        e = e4;
                                    }
                                }
                                this.ktb.put(aVar.ktc, aVar);
                            } else {
                                break;
                            }
                        }
                        x.d("MicroMsg.EmojiCovertMap", "emojiValue:%s", aVar.toString());
                        i++;
                    }
                }
            } catch (Throwable e22) {
                bufferedReader = null;
                e = e22;
                i = 0;
                try {
                    x.printErrStackTrace("MicroMsg.EmojiCovertMap", e, "", new Object[0]);
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (Exception e5) {
                        }
                    }
                    if (open != null) {
                        open.close();
                    }
                    x.d("MicroMsg.EmojiCovertMap", "id " + i);
                } catch (Throwable th) {
                    e22 = th;
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (Exception e6) {
                            throw e22;
                        }
                    }
                    if (open != null) {
                        open.close();
                    }
                    throw e22;
                }
            } catch (Throwable th2) {
                e22 = th2;
                bufferedReader = null;
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
                if (open != null) {
                    open.close();
                }
                throw e22;
            }
        } catch (Throwable e222) {
            bufferedReader = null;
            open = null;
            e = e222;
            i = 0;
        } catch (Throwable th3) {
            e222 = th3;
            bufferedReader = null;
            open = null;
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            if (open != null) {
                open.close();
            }
            throw e222;
        }
        x.d("MicroMsg.EmojiCovertMap", "id " + i);
    }
}
