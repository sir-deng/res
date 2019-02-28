package com.tencent.mm.sdk.platformtools;

public final class h {
    public static String ksD = "]]>";
    public StringBuffer ksI = new StringBuffer();
    public String xmX = "";

    public h(String str) {
        this.xmX = str;
        vY(this.xmX);
    }

    private void vY(String str) {
        this.ksI.append("<" + str + ">");
    }

    public final void vZ(String str) {
        this.ksI.append("</" + str + ">");
    }

    public final void bN(String str, String str2) {
        vY(str);
        if (!bi.oN(str2)) {
            if (str2.contains(ksD)) {
                this.ksI.append("<![CDATA[" + bi.Wm(str2) + "]]>");
            } else {
                this.ksI.append("<![CDATA[" + str2 + "]]>");
            }
        }
        vZ(str);
    }
}
