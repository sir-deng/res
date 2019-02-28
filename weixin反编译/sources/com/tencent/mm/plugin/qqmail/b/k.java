package com.tencent.mm.plugin.qqmail.b;

import android.util.Base64;
import com.tencent.mm.a.g;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class k {
    String fAJ = null;
    String ptS = null;
    a[] puA = null;
    private String[] puv = null;
    private String[] puw = null;
    private String[] pux = null;
    String puy = null;
    a[] puz = null;

    public static class a {
        String fileName;
        int fileSize;
        String name;
        String puB;
    }

    public k(String str, String[] strArr, String[] strArr2, String[] strArr3, String str2) {
        if (!bi.oN(str)) {
            this.fAJ = str;
        }
        if (strArr == null || strArr.length <= 0) {
            this.puv = null;
        } else {
            this.puv = strArr;
        }
        if (strArr2 == null || strArr2.length <= 0) {
            this.puw = null;
        } else {
            this.puw = strArr2;
        }
        if (strArr3 == null || strArr3.length <= 0) {
            this.pux = null;
        } else {
            this.pux = strArr3;
        }
        if (bi.oN(str2)) {
            this.ptS = null;
        } else {
            this.ptS = str2;
        }
    }

    final String bkQ() {
        if (this.puv == null) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder("");
        stringBuilder.append("To: ");
        for (String str : this.puv) {
            stringBuilder.append("\"");
            stringBuilder.append("=?utf-8?B?");
            stringBuilder.append(Base64.encodeToString(str.getBytes(), 2));
            stringBuilder.append("?=");
            stringBuilder.append("\"");
            stringBuilder.append(" ");
            stringBuilder.append("<");
            stringBuilder.append(str);
            stringBuilder.append(">");
            stringBuilder.append(" ,");
        }
        String stringBuilder2 = stringBuilder.toString();
        int lastIndexOf = stringBuilder2.lastIndexOf(" ,");
        if (lastIndexOf != -1) {
            return stringBuilder2.substring(0, lastIndexOf);
        }
        return stringBuilder2;
    }

    final String bkR() {
        if (this.puw == null) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder("");
        stringBuilder.append("Cc: ");
        for (String str : this.puw) {
            stringBuilder.append("\"");
            stringBuilder.append("=?utf-8?B?");
            stringBuilder.append(Base64.encodeToString(str.getBytes(), 2));
            stringBuilder.append("?=");
            stringBuilder.append("\"");
            stringBuilder.append(" ");
            stringBuilder.append("<");
            stringBuilder.append(str);
            stringBuilder.append(">");
            stringBuilder.append(" ,");
        }
        String stringBuilder2 = stringBuilder.toString();
        int lastIndexOf = stringBuilder2.lastIndexOf(" ,");
        if (lastIndexOf != -1) {
            return stringBuilder2.substring(0, lastIndexOf);
        }
        return stringBuilder2;
    }

    final String bkS() {
        if (this.pux == null) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder("");
        stringBuilder.append("Bcc: ");
        for (String str : this.puw) {
            stringBuilder.append("\"");
            stringBuilder.append("=?utf-8?B?");
            stringBuilder.append(Base64.encodeToString(str.getBytes(), 2));
            stringBuilder.append("?=");
            stringBuilder.append("\"");
            stringBuilder.append(" ");
            stringBuilder.append("<");
            stringBuilder.append(str);
            stringBuilder.append(">");
            stringBuilder.append(" ,");
        }
        String stringBuilder2 = stringBuilder.toString();
        int lastIndexOf = stringBuilder2.lastIndexOf(" ,");
        if (lastIndexOf != -1) {
            return stringBuilder2.substring(0, lastIndexOf);
        }
        return stringBuilder2;
    }

    public static String Iq(String str) {
        String s;
        String str2 = null;
        String str3 = "abEdf4&^^*sxcSD$%&1sdfz@!~AZcT4s322dA%^&&*$##C$%__SDy4d_(*%";
        int length = str3.length();
        try {
            s = g.s((str + "d$3^&xRw%&*_(").getBytes());
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.MailContentFormatter", e, "", new Object[0]);
            x.e("MicroMsg.MailContentFormatter", "attachIdToKey, error:" + e.getLocalizedMessage());
            s = str2;
        }
        char[] cArr = new char[(s.length() * 2)];
        int i = 0;
        for (int i2 = 0; i2 < s.length(); i2++) {
            int i3 = i + 1;
            cArr[i] = s.charAt(i2);
            char charAt = s.charAt(i2);
            i = i3 + 1;
            cArr[i3] = (char) (str3.charAt(charAt % length) + s.charAt(i2));
        }
        try {
            return g.s(new String(cArr).getBytes("ISO-8859-1"));
        } catch (Throwable e2) {
            x.printErrStackTrace("MicroMsg.MailContentFormatter", e2, "", new Object[0]);
            x.e("MicroMsg.MailContentFormatter", "attachIdToKey, error:" + e2.getLocalizedMessage());
            return str2;
        }
    }
}
