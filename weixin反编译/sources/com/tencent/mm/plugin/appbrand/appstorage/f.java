package com.tencent.mm.plugin.appbrand.appstorage;

import com.tencent.mm.sdk.platformtools.bi;

public final class f {
    public String bgo;
    public String fXd;
    public b iLf;
    public String iLg;
    public a iLh;
    public a iLi;
    public a iLj;
    public String iLk;
    public String iLl;
    public String iLm;
    public String iLn;
    public String iLo;
    public String iLp;
    public String iLq;
    public String iLr;
    public String iLs;
    public String title;
    public String url;

    public static class a {
        private String country;
        private String fXl;
        private String iLt;
        public String iLu;
        private String state;

        public a(String str, String str2, String str3, String str4, String str5) {
            this.country = bi.oM(str);
            this.state = bi.oM(str2);
            this.fXl = bi.oM(str3);
            this.iLt = bi.oM(str4);
            this.iLu = bi.oM(str5);
        }

        public final String Rm() {
            StringBuilder stringBuilder;
            if (bi.VW(this.country) || bi.VW(this.state) || bi.VW(this.fXl) || bi.VW(this.iLt) || bi.VW(this.iLu)) {
                stringBuilder = new StringBuilder();
                if (this.country.length() > 0) {
                    stringBuilder.append(this.country);
                }
                if (this.state.length() > 0) {
                    stringBuilder.append(this.state);
                }
                if (this.fXl.length() > 0) {
                    stringBuilder.append(this.fXl);
                }
                if (this.iLt.length() > 0) {
                    stringBuilder.append(this.iLt);
                }
                if (this.iLu.length() > 0) {
                    stringBuilder.append(" ");
                    stringBuilder.append(this.iLu);
                }
                return stringBuilder.toString();
            }
            stringBuilder = new StringBuilder();
            if (this.iLt.length() > 0) {
                stringBuilder.append(this.iLt);
                stringBuilder.append(" ");
            }
            if (this.fXl.length() > 0) {
                stringBuilder.append(this.fXl + " ");
            }
            if (this.state.length() > 0) {
                stringBuilder.append(this.state + " ");
            }
            if (this.country.length() > 0) {
                stringBuilder.append(this.country);
            }
            if (this.iLu.length() > 0) {
                stringBuilder.append(" ");
                stringBuilder.append(this.iLu);
            }
            return stringBuilder.toString();
        }
    }

    public static class b {
        public String iLv;
        public String iLw;
        public String iLx;

        public b(String str, String str2, String str3) {
            this.iLv = bi.oM(str);
            this.iLw = bi.oM(str2);
            this.iLx = bi.oM(str3);
        }
    }
}
