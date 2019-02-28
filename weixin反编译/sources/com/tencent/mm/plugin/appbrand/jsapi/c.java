package com.tencent.mm.plugin.appbrand.jsapi;

import android.util.SparseArray;
import com.tencent.mm.plugin.appbrand.e;
import com.tencent.mm.plugin.appbrand.g.b;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

public abstract class c {
    public h jeV = new h();
    private final AtomicInteger jeW = new AtomicInteger(0);
    private final SparseArray<a> jeX = new SparseArray();

    private static class a {
        int id;
        b jeY;

        a(b bVar, int i) {
            this.jeY = bVar;
            this.id = i;
        }
    }

    public abstract e YZ();

    public abstract b Za();

    public abstract void a(String str, String str2, int[] iArr);

    public abstract boolean isRunning();

    public void j(String str, String str2, int i) {
        if (bi.oN(str2)) {
            str2 = "{}";
        }
        x.d("MicroMsg.AppBrandComponent", "dispatch, event: %s, data size: %s, srcId: %d", str, Integer.valueOf(str2.length()), Integer.valueOf(i));
        b Za = Za();
        String str3 = "typeof WeixinJSCoreAndroid !== 'undefined' && WeixinJSCoreAndroid.subscribeHandler(\"%s\", %s, %s, %s)";
        Object[] objArr = new Object[4];
        objArr[0] = str;
        objArr[1] = str2;
        objArr[2] = i == 0 ? "undefined" : String.valueOf(i);
        objArr[3] = Cj();
        Za.evaluateJavascript(String.format(str3, objArr), null);
    }

    public void E(int i, String str) {
        if (isRunning()) {
            if (bi.oN(str)) {
                str = "{}";
            }
            x.d("MicroMsg.AppBrandComponent", "callbackId: %d, data size: %d", Integer.valueOf(i), Integer.valueOf(str.length()));
            a kr = kr(i);
            if (kr == null) {
                x.e("MicroMsg.AppBrandComponent", "callbackid = [%d] This is a Sync Api, No callback runtime stored.");
                return;
            }
            kr.jeY.evaluateJavascript(String.format("typeof WeixinJSCoreAndroid !== 'undefined' && WeixinJSCoreAndroid.invokeCallbackHandler(%d, %s)", new Object[]{Integer.valueOf(kr.id), str}), null);
            this.jeV.H(i, str);
            return;
        }
        x.e("MicroMsg.AppBrandComponent", "callback but destroyed, callbackId %d", Integer.valueOf(i));
    }

    public static String Cj() {
        Map hashMap = new HashMap();
        hashMap.put("nativeTime", Long.valueOf(System.currentTimeMillis()));
        return new JSONObject(hashMap).toString();
    }

    public String getAppId() {
        return YZ().mAppId;
    }

    public void cleanup() {
        synchronized (this.jeX) {
            this.jeX.clear();
        }
    }

    public int a(b bVar, int i) {
        if (i == 0) {
            return 0;
        }
        int incrementAndGet = this.jeW.incrementAndGet();
        synchronized (this.jeX) {
            this.jeX.put(incrementAndGet, new a(bVar, i));
        }
        return incrementAndGet;
    }

    private a kr(int i) {
        a aVar;
        synchronized (this.jeX) {
            aVar = (a) this.jeX.get(i);
        }
        return aVar;
    }

    public void onResume() {
    }

    public String acN() {
        return null;
    }
}
