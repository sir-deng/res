package com.tencent.mm.cache;

import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Map;

public interface e {

    public static class a {
        private static Map<String, e> gDg = new HashMap();

        public static void a(String str, e eVar) {
            gDg.put(str, eVar);
        }

        private static e eF(String str) {
            return (e) gDg.get(str);
        }

        public static <T> T D(String str, String str2) {
            return a(eF(str), str2, null);
        }

        public static <T> void a(String str, String str2, T t) {
            e eF = eF(str);
            if (eF == null) {
                x.e("MicroMsg.ICacheService.Factory", "null service");
            } else {
                eF.n(str2, t);
            }
        }

        public static <T> void E(String str, String str2) {
            a(eF(str), str2);
        }

        private static <T> T a(e eVar, String str, T t) {
            T t2 = null;
            if (eVar == null) {
                x.e("MicroMsg.ICacheService.Factory", "null service");
                return t2;
            }
            try {
                return eVar.get(str);
            } catch (Throwable e) {
                x.e("MicroMsg.ICacheService.Factory", "cast failed, different type ?");
                x.e("MicroMsg.ICacheService.Factory", "exception:%s", bi.i(e));
                return t2;
            }
        }

        private static <T> T a(e eVar, String str) {
            T t = null;
            if (eVar == null) {
                x.e("MicroMsg.ICacheService.Factory", "null service");
                return t;
            }
            try {
                return eVar.remove(str);
            } catch (Throwable e) {
                x.e("MicroMsg.ICacheService.Factory", "cast failed, different type ?");
                x.e("MicroMsg.ICacheService.Factory", "exception:%s", bi.i(e));
                return t;
            }
        }
    }

    Object get(Object obj);

    void n(Object obj, Object obj2);

    Object remove(Object obj);
}
