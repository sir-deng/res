package com.tencent.mm.aw;

import android.view.View;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import junit.framework.Assert;

public abstract class a {
    public static String hKf = "";
    public static String hKg = "";
    public String TEXT;
    public String TYPE;
    public au fFE;
    public String hKh = "";
    public String hKi;
    public LinkedList<String> hKj = new LinkedList();
    public LinkedList<Integer> hKk = new LinkedList();
    public LinkedList<Integer> hKl = new LinkedList();
    public Map<String, String> values;

    public static abstract class a {
        private static HashMap<String, a> hKm = new HashMap();

        public abstract a a(Map<String, String> map, au auVar);

        public static void a(String str, a aVar) {
            Assert.assertNotNull(str);
            Assert.assertNotNull(aVar);
            synchronized (hKm) {
                hKm.put(str.toLowerCase(), aVar);
            }
        }

        public static a b(Map<String, String> map, au auVar) {
            if (map == null) {
                x.e("MicroMsg.BaseNewXmlMsg", "values is null !!!");
                return null;
            }
            String str = (String) map.get(".sysmsg.$type");
            synchronized (hKm) {
                a aVar = (a) hKm.get(str.toLowerCase());
                if (aVar == null) {
                    x.w("MicroMsg.BaseNewXmlMsg", "TYPE %s is unDefine", str);
                    return null;
                }
                a a = aVar.a((Map) map, auVar);
                return a;
            }
        }
    }

    public interface b {
        void a(View view, au auVar, a aVar, int i);
    }

    public abstract boolean QH();

    public a(Map<String, String> map, au auVar) {
        this.values = map;
        this.fFE = auVar;
    }
}
