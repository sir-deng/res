package com.tencent.mm.sdk.platformtools;

import com.tencent.mm.sdk.platformtools.aq.a;
import com.tencent.mm.sdk.platformtools.aq.b;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class ap {
    public static aq xpp = null;

    public static String fw(String str, String str2) {
        String replace = VQ(str).replace("+", "");
        if (xpp == null) {
            xpp = new aq();
        }
        int length;
        if (bi.oN(str2)) {
            for (a aVar : xpp.xpq) {
                if (replace.startsWith(aVar.xps)) {
                    length = replace.length() - aVar.xps.length();
                    if (length >= aVar.xpt && length <= aVar.xpu) {
                        x.i("MicroMsg.PhoneFormater", "[extractCountryCode] countrycode:%s country isocode: %s country.minlen:%d country.maxlen:%d", aVar.xps, aVar.xpr, Integer.valueOf(aVar.xpu), Integer.valueOf(aVar.xpu));
                        return aVar.xps;
                    }
                }
            }
        } else {
            for (a aVar2 : xpp.xpq) {
                if (replace.startsWith(aVar2.xps)) {
                    length = replace.length() - aVar2.xps.length();
                    if (length >= aVar2.xpt && length <= aVar2.xpu && str2.equalsIgnoreCase(aVar2.xpr)) {
                        x.i("MicroMsg.PhoneFormater", "[extractCountryCode] countrycode:%s country isocode: %s country.minlen:%d country.maxlen:%d", aVar2.xps, aVar2.xpr, Integer.valueOf(aVar2.xpu), Integer.valueOf(aVar2.xpu));
                        return aVar2.xps;
                    }
                }
            }
        }
        return null;
    }

    public static String DK(String str) {
        return fw(str, null);
    }

    public static String VP(String str) {
        if (bi.oN(str) || !bi.Wx(str).booleanValue()) {
            return str;
        }
        ap apVar = new ap();
        String str2 = "86";
        if (str.startsWith("+")) {
            str = str.replace("+", "");
            str2 = fw(str, null);
            if (str2 != null) {
                str = str.substring(str2.length());
            }
        }
        return formatNumber(str2, str);
    }

    public static String VQ(String str) {
        if (bi.oN(str)) {
            return "";
        }
        return str.replaceAll("[\\.\\-\\ ]", "").trim();
    }

    public static String VR(String str) {
        if (bi.oN(str)) {
            return "";
        }
        return str.replace("+", "");
    }

    public static String VS(String str) {
        if (bi.oN(str)) {
            return "";
        }
        return !str.startsWith("+") ? "+" + str : str;
    }

    public static String fx(String str, String str2) {
        if (bi.oN(str) || bi.oN(str2)) {
            return "";
        }
        return str + "（+" + str2 + "）";
    }

    public static String formatNumber(String str, String str2) {
        if (bi.oN(str) || bi.oN(str2)) {
            return str2;
        }
        if (xpp == null) {
            xpp = new aq();
        }
        for (a aVar : xpp.xpq) {
            if (!(aVar.xps == null || !str.trim().toLowerCase().equals(aVar.xps.trim().toLowerCase()) || aVar.xpv == null)) {
                String VQ = VQ(str2);
                if (VQ != null && VQ.length() > aVar.xpt) {
                    return VQ;
                }
                for (b bVar : aVar.xpv) {
                    String ag;
                    int i;
                    int i2;
                    char charAt;
                    StringBuffer stringBuffer;
                    int length;
                    if (bi.oN(bVar.xpw)) {
                        if (aVar.xpv.size() > 1) {
                            StringBuffer stringBuffer2 = new StringBuffer();
                            stringBuffer2.append(VQ);
                            int length2 = VQ.length();
                            if (length2 <= cZ(bVar.xpy, aVar.xpu)) {
                                while (stringBuffer2.toString().length() < aVar.xpu) {
                                    stringBuffer2.append("0");
                                }
                                ag = ag(bVar.xpy, bVar.xpx, stringBuffer2.toString());
                                VQ = ag;
                                i = 0;
                                for (i2 = 0; i2 < VQ.length(); i2++) {
                                    charAt = VQ.charAt(i2);
                                    if (i >= length2) {
                                        VQ = VQ.substring(0, i2);
                                    }
                                    if (!(charAt == ' ' || charAt == '-' || charAt == 12290)) {
                                        i++;
                                    }
                                }
                                return VQ;
                            }
                        } else {
                            stringBuffer = new StringBuffer();
                            stringBuffer.append(VQ);
                            length = VQ.length();
                            while (stringBuffer.toString().length() < aVar.xpu) {
                                stringBuffer.append("0");
                            }
                            String ag2 = ag(bVar.xpy, bVar.xpx, stringBuffer.toString());
                            i = 0;
                            for (int i3 = 0; i3 < ag2.length(); i3++) {
                                charAt = ag2.charAt(i3);
                                if (i >= length) {
                                    ag2 = ag2.substring(0, i3);
                                }
                                if (!(charAt == ' ' || charAt == '-' || charAt == 12290)) {
                                    i++;
                                }
                            }
                            return ag2;
                        }
                    } else if (Pattern.compile(bVar.xpw).matcher(VQ).lookingAt()) {
                        stringBuffer = new StringBuffer();
                        stringBuffer.append(VQ);
                        length = VQ.length();
                        while (stringBuffer.toString().length() < aVar.xpu) {
                            stringBuffer.append(VQ.charAt(length - 1));
                        }
                        ag = ag(bVar.xpy, bVar.xpx, stringBuffer.toString());
                        VQ = ag;
                        i = 0;
                        for (i2 = 0; i2 < VQ.length(); i2++) {
                            charAt = VQ.charAt(i2);
                            if (i >= length) {
                                VQ = VQ.substring(0, i2);
                            }
                            if (!(charAt == ' ' || charAt == '-' || charAt == 12290)) {
                                i++;
                            }
                        }
                        return VQ;
                    }
                }
                continue;
            }
        }
        return str2;
    }

    private static int cZ(String str, int i) {
        Pattern compile = Pattern.compile(str);
        Object obj = "1";
        int i2 = 0;
        while (i2 < i && !compile.matcher(obj).find()) {
            obj = obj + "1";
            i2++;
        }
        return i2 + 1;
    }

    private static String ag(String str, String str2, String str3) {
        Matcher matcher = Pattern.compile(str).matcher(str3);
        if (matcher.find()) {
            return matcher.replaceAll(str2);
        }
        return str3;
    }
}
