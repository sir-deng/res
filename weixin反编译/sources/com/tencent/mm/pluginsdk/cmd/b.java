package com.tencent.mm.pluginsdk.cmd;

import android.content.Context;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Pattern;

public final class b {
    private static final HashMap<String, a> vjr = new HashMap();
    private static final HashMap<String, a> vjs = new HashMap();
    private static final Pattern vjt = Pattern.compile(" +");

    static class a {
        String fNi;
        int vju;
        a vjv;

        a() {
        }
    }

    public static void a(a aVar, String... strArr) {
        synchronized (vjr) {
            for (Object put : strArr) {
                vjr.put(put, aVar);
                x.i("MicroMsg.UnifiedCommandProcessor", "Registered command: %s", put);
            }
        }
    }

    public static void D(String... strArr) {
        synchronized (vjr) {
            for (Object remove : strArr) {
                vjr.remove(remove);
                x.i("MicroMsg.UnifiedCommandProcessor", "Unregistered command: %s", remove);
            }
        }
    }

    public static boolean aU(Context context, String str) {
        a aVar;
        String[] split = vjt.split(str);
        synchronized (vjr) {
            aVar = (a) vjr.get(split[0]);
        }
        if (aVar == null) {
            return false;
        }
        x.i("MicroMsg.UnifiedCommandProcessor", "Command: %s", split[0]);
        return aVar.a(context, split);
    }

    static List<a> bYV() {
        List arrayList;
        synchronized (vjs) {
            arrayList = new ArrayList(vjs.values());
        }
        return arrayList;
    }
}
