package com.tencent.mm.plugin.scanner.a;

import com.tencent.mm.sdk.platformtools.bi;
import java.util.List;

public final class o {
    public static o pZC;
    public String bgo;
    public String fXd;
    public String iLg;
    public String iLp;
    public String pZA;
    public String pZB;
    public b pZl;
    c pZm;
    public c pZn;
    c pZo;
    public String pZp;
    public a pZq;
    public a pZr;
    public a pZs;
    public a pZt;
    public List<String> pZu;
    public List<String> pZv;
    public List<String> pZw;
    public List<String> pZx;
    public List<String> pZy;
    public String pZz;
    public String title;
    public String url;

    public static class a {
        private String country;
        private String hQS;
        private String hzh;
        private String iLt;
        private String iLu;
        private String pZD;
        private String pZE;

        public a(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
            if (str == null) {
                str = "";
            }
            this.pZD = str;
            if (str2 == null) {
                str2 = "";
            }
            this.pZE = str2;
            if (str3 == null) {
                str3 = "";
            }
            this.iLt = str3;
            if (str4 == null) {
                str4 = "";
            }
            this.hzh = str4;
            if (str5 == null) {
                str5 = "";
            }
            this.hQS = str5;
            if (str6 == null) {
                str6 = "";
            }
            this.iLu = str6;
            if (str7 == null) {
                str7 = "";
            }
            this.country = str7;
        }

        public final String Rm() {
            StringBuilder stringBuilder;
            String stringBuilder2;
            if (bi.VW(this.pZD) || bi.VW(this.pZE) || bi.VW(this.iLt) || bi.VW(this.hzh) || bi.VW(this.hQS) || bi.VW(this.country)) {
                stringBuilder = new StringBuilder();
                if (this.country.length() > 0) {
                    stringBuilder.append(this.country);
                    stringBuilder.append("\n");
                }
                if (this.hQS.length() > 0) {
                    stringBuilder.append(this.hQS + " ");
                }
                if (this.hzh.length() > 0) {
                    stringBuilder.append(this.hzh);
                }
                if (this.hQS.length() > 0 || this.hzh.length() > 0) {
                    stringBuilder.append("\n");
                }
                if (this.iLt.length() > 0) {
                    stringBuilder.append(this.iLt + " ");
                    stringBuilder.append("\n");
                }
                if (this.pZE.length() > 0) {
                    stringBuilder.append(this.pZE);
                    stringBuilder.append("\n");
                }
                if (this.pZD.length() > 0) {
                    stringBuilder.append(this.pZD);
                    stringBuilder.append("\n");
                }
                if (this.iLu.length() > 0) {
                    stringBuilder.append(this.iLu);
                }
                stringBuilder2 = stringBuilder.toString();
                if (stringBuilder2.endsWith("\n")) {
                    return stringBuilder2.substring(0, stringBuilder2.length() - 1);
                }
                return stringBuilder2;
            }
            stringBuilder = new StringBuilder();
            if (this.pZD.length() > 0) {
                stringBuilder.append(this.pZD);
                stringBuilder.append("\n");
            }
            if (this.pZE.length() > 0) {
                stringBuilder.append(this.pZE);
                stringBuilder.append("\n");
            }
            if (this.iLt.length() > 0) {
                stringBuilder.append(this.iLt);
                stringBuilder.append("\n");
            }
            if (this.hzh.length() > 0) {
                stringBuilder.append(this.hzh + " ");
            }
            if (this.hQS.length() > 0) {
                stringBuilder.append(this.hQS + " ");
            }
            if (this.iLu.length() > 0) {
                stringBuilder.append(this.iLu);
            }
            if (this.hzh.length() > 0 || this.hQS.length() > 0) {
                stringBuilder.append("\n");
            }
            if (this.country.length() > 0) {
                stringBuilder.append(this.country);
            }
            stringBuilder2 = stringBuilder.toString();
            return stringBuilder2.endsWith("\n") ? stringBuilder2.substring(0, stringBuilder2.length() - 1) : stringBuilder2;
        }
    }

    public static class b {
        private String iLv;
        private String iLw;
        private String iLx;

        public b(String str, String str2, String str3) {
            if (str == null) {
                str = "";
            }
            this.iLv = str;
            if (str2 == null) {
                str2 = "";
            }
            this.iLw = str2;
            if (str3 == null) {
                str3 = "";
            }
            this.iLx = str3;
        }

        public final String Rm() {
            StringBuilder stringBuilder = new StringBuilder();
            if (bi.VW(this.iLv) || bi.VW(this.iLw) || bi.VW(this.iLx)) {
                if (this.iLx.trim().length() > 0) {
                    stringBuilder.append(this.iLx);
                }
                if (this.iLw.trim().length() > 0) {
                    stringBuilder.append(this.iLw);
                }
                if (this.iLv.trim().length() > 0) {
                    stringBuilder.append(this.iLv);
                }
            } else {
                if (this.iLv.trim().length() > 0) {
                    stringBuilder.append(this.iLv);
                }
                if (this.iLw.trim().length() > 0) {
                    stringBuilder.append(" ");
                    stringBuilder.append(this.iLw);
                }
                if (this.iLx.trim().length() > 0) {
                    stringBuilder.append(" ");
                    stringBuilder.append(this.iLx);
                }
            }
            return stringBuilder.toString();
        }
    }

    public static class c {
        public String pZF;
        public String pZG;

        public c(String str, String str2) {
            this.pZF = str;
            this.pZG = str2;
        }
    }
}
