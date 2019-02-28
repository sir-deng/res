package com.tencent.mm.plugin.scanner.a;

import com.tencent.mm.sdk.platformtools.bi;
import java.util.LinkedList;
import java.util.Map;

public final class a {
    public LinkedList<a> hPU = new LinkedList();
    public String iconUrl;
    public int lqi;
    public int pYl;
    public int pYm;
    public String pYn;
    public boolean pYo;
    public String title;
    public int type = 1;

    public static class a {
        public String aAM;
        public String content;
        public String desc = "";
        public String fqG = "";
        public String hPT = "";
        public String hfQ = "";
        public String iconUrl = "";
        public String name = "";
        public String pYn;
        public String pYp = "";
        public String pYq = "";
        public String pYr = "";
        public String pYs = "";
        public String pYt = "";
        public String pYu = "";
        public String pYv = "";
        public String pYw = "";
        public String pYx = "";
        public String pYy;
        public String pYz;
        public int showType;
        public String thumburl = "";
        public int type;
        public String username = "";

        public a(int i) {
            this.type = i;
        }
    }

    public static LinkedList<a> l(Map<String, String> map, String str) {
        LinkedList<a> linkedList = new LinkedList();
        int i = 0;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= 1000) {
                return linkedList;
            }
            a aVar = new a();
            String str2 = str + ".actionlist" + (i3 > 0 ? Integer.valueOf(i3) : "");
            if (!bi.oN((String) map.get(str2 + ".$type"))) {
                aVar.type = Integer.valueOf((String) map.get(str2 + ".$type")).intValue();
            }
            aVar.title = bi.oM((String) map.get(str2 + ".$title"));
            aVar.iconUrl = bi.oM((String) map.get(str2 + ".$iconurl"));
            aVar.lqi = bi.getInt((String) map.get(str2 + ".$iconwidth"), 34);
            aVar.pYl = bi.getInt((String) map.get(str2 + ".$iconheight"), 34);
            aVar.pYn = bi.oM((String) map.get(str2 + ".$referkey"));
            aVar.pYm = bi.getInt((String) map.get(str2 + ".$listshowtype"), 0);
            boolean z = false;
            LinkedList linkedList2 = new LinkedList();
            i2 = 0;
            while (true) {
                int i4 = i2;
                if (i4 >= 1000) {
                    i2 = i;
                    break;
                }
                String str3 = str2 + ".action" + (i4 > 0 ? Integer.valueOf(i4) : "");
                if (!bi.oN((String) map.get(str3 + ".$type"))) {
                    boolean z2;
                    i = 0;
                    a m = m(map, str3);
                    if (m != null) {
                        linkedList2.add(m);
                        if (!k.a(m)) {
                            i2 = 1;
                            z = i4 + 1;
                            z2 = z;
                        }
                    }
                    boolean z3 = z;
                    z = i4 + 1;
                    z2 = z;
                } else if (i != 0) {
                    return linkedList;
                } else {
                    i2 = 1;
                    aVar.hPU = linkedList2;
                }
            }
            aVar.pYo = z;
            linkedList.add(aVar);
            i3++;
        }
    }

    public static a m(Map<String, String> map, String str) {
        int i = bi.getInt((String) map.get(str + ".$type"), 0);
        a aVar = new a(i);
        aVar.type = i;
        aVar.pYu = bi.oM((String) map.get(str + ".statid"));
        aVar.name = bi.oM((String) map.get(str + ".name"));
        aVar.desc = bi.oM((String) map.get(str + ".desc"));
        aVar.hfQ = bi.oM((String) map.get(str + ".digest"));
        aVar.showType = bi.getInt((String) map.get(str + ".showtype"), 0);
        aVar.pYp = bi.oM((String) map.get(str + ".image"));
        aVar.aAM = bi.oM((String) map.get(str + ".$key"));
        aVar.iconUrl = bi.oM((String) map.get(str + ".iconurl"));
        if (i == 1) {
            aVar.hPT = bi.oM((String) map.get(str + ".link"));
            return aVar;
        } else if (i == 2) {
            aVar.username = bi.oM((String) map.get(str + ".username"));
            aVar.fqG = bi.oM((String) map.get(str + ".nickname"));
            aVar.pYy = bi.oM((String) map.get(str + ".strbeforefollow"));
            aVar.pYz = bi.oM((String) map.get(str + ".strafterfollow"));
            return aVar;
        } else if (i == 3) {
            aVar.thumburl = bi.oM((String) map.get(str + ".thumburl"));
            aVar.hPT = bi.oM((String) map.get(str + ".link"));
            return aVar;
        } else if (i == 4) {
            aVar.thumburl = bi.oM((String) map.get(str + ".thumburl"));
            aVar.username = bi.oM((String) map.get(str + ".username"));
            aVar.fqG = bi.oM((String) map.get(str + ".nickname"));
            return aVar;
        } else {
            if (i == 5) {
                aVar.pYr = bi.oM((String) map.get(str + ".wifiurl"));
                aVar.pYs = bi.oM((String) map.get(str + ".wapurl"));
                aVar.pYt = bi.oM((String) map.get(str + ".weburl"));
                if (bi.oN(aVar.pYr) && bi.oN(aVar.pYs) && bi.oN(aVar.pYt)) {
                    return null;
                }
            } else if (i != 6) {
                if (i == 7) {
                    aVar.thumburl = bi.oM((String) map.get(str + ".thumburl"));
                    aVar.pYq = bi.oM((String) map.get(str + ".playurl"));
                    return aVar;
                } else if (i == 9) {
                    aVar.pYv = bi.oM((String) map.get(str + ".productid"));
                    return aVar;
                } else if (i == 8) {
                    aVar.pYw = bi.oM((String) map.get(str + ".cardext"));
                    aVar.pYx = bi.oM((String) map.get(str + ".cardid"));
                    return aVar;
                } else if (i == 10) {
                    aVar.pYv = bi.oM((String) map.get(str + ".id"));
                    return aVar;
                } else if (i == 12) {
                    aVar.thumburl = bi.oM((String) map.get(str + ".image"));
                    aVar.hPT = bi.oM((String) map.get(str + ".link"));
                    return aVar;
                } else if (i == 22) {
                    aVar.content = bi.oM((String) map.get(str + ".content"));
                    aVar.hPT = bi.oM((String) map.get(str + ".link"));
                    aVar.fqG = bi.oM((String) map.get(str + ".nickname"));
                    aVar.thumburl = bi.oM((String) map.get(str + ".image"));
                    return aVar;
                } else if (i == 21) {
                    aVar.pYn = bi.oM((String) map.get(str + ".referkey"));
                    return aVar;
                } else {
                    aVar.hPT = bi.oM((String) map.get(str + ".link"));
                }
            }
            return aVar;
        }
    }
}
