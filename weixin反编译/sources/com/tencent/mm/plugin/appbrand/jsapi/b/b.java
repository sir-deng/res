package com.tencent.mm.plugin.appbrand.jsapi.b;

import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.u;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONObject;

public final class b {
    public static boolean jkS = false;
    public static j jkT = null;
    public static int jkU = 0;
    private static Map<String, JSONObject> jkV;
    private static JSONArray jkW;
    private static JSONArray jkX;

    public static Map<String, JSONObject> agi() {
        if (jkV == null) {
            jkV = new ConcurrentHashMap();
        }
        return jkV;
    }

    public static void agj() {
        if (jkV != null) {
            jkV.clear();
            jkV = null;
        }
    }

    public static j agk() {
        return jkT;
    }

    public static void e(j jVar) {
        jkT = jVar;
    }

    public static int agl() {
        return jkU;
    }

    public static void kx(int i) {
        jkU = i;
    }

    public static void agm() {
        if (jkW != null) {
            jkW = null;
        }
    }

    public static void agn() {
        if (jkX != null) {
            jkX = null;
        }
    }

    private static String f(j jVar) {
        return "JsApi#BluetoothSessionId" + jVar.hashCode();
    }

    public static com.tencent.mm.y.u.b g(j jVar) {
        String f = f(jVar);
        com.tencent.mm.y.u.b hA = u.GQ().hA(f);
        if (hA != null) {
            return hA;
        }
        x.d("MicroMsg.JsApiBluetoothUtil", "getDataStore true!");
        return u.GQ().t(f, true);
    }

    public static void h(j jVar) {
        com.tencent.mm.y.u.b hB = u.GQ().hB(f(jVar));
        if (hB != null) {
            hB.recycle();
            x.d("MicroMsg.JsApiBluetoothUtil", "removeDataKeyValueSet!");
        }
    }
}
