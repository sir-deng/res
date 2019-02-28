package com.tencent.mm.plugin.appbrand.media;

import android.text.TextUtils;
import com.tencent.mm.f.a.s;
import com.tencent.mm.plugin.appbrand.app.e;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService.a;
import com.tencent.mm.plugin.appbrand.media.record.RecordParam;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public final class c {
    private static String jES = "";
    private static Map<String, com.tencent.mm.sdk.b.c> jET = new HashMap();
    private static ArrayList<String> jEU = new ArrayList();
    private static Map<String, com.tencent.mm.sdk.b.c> jEV = new HashMap();
    private static ArrayList<String> jEW = new ArrayList();
    private static a jEX = null;
    private static boolean jEY = false;

    public static void tK(String str) {
        jES = str;
    }

    public static void aiR() {
        com.tencent.mm.sdk.b.c cVar;
        x.i("MicroMsg.Audio.AppBrandAudioService", "clearAudioListener");
        Iterator it = jEU.iterator();
        while (it.hasNext()) {
            cVar = (com.tencent.mm.sdk.b.c) jET.remove((String) it.next());
            if (cVar != null) {
                com.tencent.mm.sdk.b.a.xmy.c(cVar);
            }
        }
        jET.clear();
        jEU.clear();
        it = jEW.iterator();
        while (it.hasNext()) {
            cVar = (com.tencent.mm.sdk.b.c) jEV.remove((String) it.next());
            if (cVar != null) {
                com.tencent.mm.sdk.b.a.xmy.c(cVar);
            }
        }
        jEV.clear();
        jEW.clear();
    }

    public static void a(String str, com.tencent.mm.sdk.b.c cVar) {
        if (jET.containsKey(str)) {
            x.e("MicroMsg.Audio.AppBrandAudioService", "appId:%s has add listener", str);
        } else if (cVar == null) {
            x.e("MicroMsg.Audio.AppBrandAudioService", "listener is null");
        } else {
            x.i("MicroMsg.Audio.AppBrandAudioService", "addRecordListener,appId:%s", str);
            jET.put(str, cVar);
            if (!jEU.contains(str)) {
                jEU.add(str);
            }
            com.tencent.mm.sdk.b.a.xmy.a(cVar);
        }
    }

    public static void tL(String str) {
        if (jET.containsKey(str)) {
            x.i("MicroMsg.Audio.AppBrandAudioService", "removeRecordListener,appId:%s", str);
            jEU.remove(str);
            com.tencent.mm.sdk.b.c cVar = (com.tencent.mm.sdk.b.c) jET.remove(str);
            if (cVar != null) {
                com.tencent.mm.sdk.b.a.xmy.c(cVar);
                return;
            }
            return;
        }
        x.e("MicroMsg.Audio.AppBrandAudioService", "appId:%s not exist the appId for listener", str);
    }

    public static void b(String str, com.tencent.mm.sdk.b.c cVar) {
        if (TextUtils.isEmpty(str)) {
            x.e("MicroMsg.Audio.AppBrandAudioService", "appId is empty");
        } else if (cVar == null) {
            x.e("MicroMsg.Audio.AppBrandAudioService", "listener is null");
        } else {
            if (jEV.containsKey(str)) {
                tM(str);
            }
            x.i("MicroMsg.Audio.AppBrandAudioService", "addAudioPlayerListener,appId:%s", str);
            jEV.put(str, cVar);
            if (!jEW.contains(str)) {
                jEW.add(str);
            }
            com.tencent.mm.sdk.b.a.xmy.a(cVar);
        }
    }

    public static void tM(String str) {
        if (jEV.containsKey(str)) {
            x.i("MicroMsg.Audio.AppBrandAudioService", "removeAudioPlayerListener,appId:%s", str);
            jEW.remove(str);
            com.tencent.mm.sdk.b.c cVar = (com.tencent.mm.sdk.b.c) jEV.remove(str);
            if (cVar != null) {
                com.tencent.mm.sdk.b.a.xmy.c(cVar);
                return;
            }
            return;
        }
        x.e("MicroMsg.Audio.AppBrandAudioService", "appId:%s not exist the appId for listener", str);
    }

    public static void aiS() {
        if (jEX == null) {
            jEX = new a() {
                public final void onDisconnected(String str) {
                    super.onDisconnected(str);
                    x.e("MicroMsg.Audio.AppBrandAudioService", "The process is be killed by system, processName:%s, and do destroyAllAudioPlayerByProcessName", str);
                    x.i("MicroMsg.AudioPlayerHelper", "destroyAllAudioPlayerByProcessName processName:%s", str);
                    b sVar = new s();
                    sVar.fow.action = 15;
                    sVar.fow.processName = str;
                    com.tencent.mm.sdk.b.a.xmy.m(sVar);
                    x.i("MicroMsg.AudioRecordHelper", "stopRecordByProcessName processName:%s", str);
                    RecordParam recordParam = e.ZD().jFi;
                    if (recordParam != null && str != null && str.equalsIgnoreCase(recordParam.processName)) {
                        x.i("MicroMsg.AudioRecordHelper", "stop the record by processName");
                        e.ZD().vj();
                    } else if (recordParam == null || str == null || str.equalsIgnoreCase(recordParam.processName)) {
                        x.i("MicroMsg.AudioRecordHelper", "record has been stopped or not start");
                    } else {
                        x.i("MicroMsg.AudioRecordHelper", "%s processName is diff, don't stop record", recordParam.processName);
                    }
                }
            };
        }
        if (!jEY) {
            x.i("MicroMsg.Audio.AppBrandAudioService", "addMainServiceEventListener success");
            jEY = true;
            AppBrandMainProcessService.a(jEX);
        }
    }

    public static void aiT() {
        if (jEX != null && jEY) {
            x.i("MicroMsg.Audio.AppBrandAudioService", "removeServiceEventListener success");
            jEY = false;
            AppBrandMainProcessService.b(jEX);
        }
    }
}
