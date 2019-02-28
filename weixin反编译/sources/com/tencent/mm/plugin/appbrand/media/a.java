package com.tencent.mm.plugin.appbrand.media;

import com.tencent.mm.sdk.platformtools.x;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class a {
    private static Map<String, h> jEN = new ConcurrentHashMap();

    public static void onCreate() {
        x.i("MicroMsg.Audio.AppBrandAudioClientService", "onCreate");
        jEN.clear();
    }

    public static void onDestroy() {
        x.i("MicroMsg.Audio.AppBrandAudioClientService", "onDestroy");
        jEN.clear();
    }

    public static void a(String str, h hVar) {
        jEN.put(str, hVar);
    }

    public static h tJ(String str) {
        return (h) jEN.get(str);
    }
}
