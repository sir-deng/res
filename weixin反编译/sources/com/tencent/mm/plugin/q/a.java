package com.tencent.mm.plugin.q;

import com.tencent.mm.protocal.c.bes;
import java.util.List;

public final class a {
    private static List<a> oen;
    private static String oeo;

    public static class a {
        public String jPV;
        public int oep;
        public bes oeq;
    }

    public static synchronized void i(String str, List<a> list) {
        synchronized (a.class) {
            oeo = str;
            oen = list;
        }
    }

    public static synchronized List<a> Ey(String str) {
        List<a> list;
        synchronized (a.class) {
            if (str != null) {
                if (str.equals(oeo)) {
                    list = oen;
                }
            }
            list = null;
        }
        return list;
    }
}
