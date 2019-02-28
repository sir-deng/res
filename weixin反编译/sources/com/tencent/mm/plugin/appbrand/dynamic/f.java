package com.tencent.mm.plugin.appbrand.dynamic;

import android.os.Bundle;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.ipcinvoker.c;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class f {
    private static f iVn = new f();
    Map<String, b> iVo = new ConcurrentHashMap();
    com.tencent.mm.ipcinvoker.wx_extension.b.a iVp = new com.tencent.mm.ipcinvoker.wx_extension.b.a() {
        public final void a(int i, int i2, String str, com.tencent.mm.ad.b bVar) {
            if (i != 0 || i2 != 0) {
                x.e("MicroMsg.DynamicPageViewStateMonitor", "widget alarm cgi fail, msg[%s]", str);
            }
        }
    };

    public static class a implements com.tencent.mm.ipcinvoker.a {
        public final void a(Bundle bundle, c cVar) {
            f.acX().av(bundle.getString(SlookAirButtonFrequentContactAdapter.ID), bundle.getInt("widgetState"));
        }
    }

    public static class b {
        String appId = "";
        int hqv = 0;
        String iVr = "";
        LinkedList<Integer> iVs = new LinkedList();

        public b(String str, String str2, int i) {
            this.iVr = str;
            this.appId = str2;
            this.hqv = i;
        }
    }

    public static f acX() {
        return iVn;
    }

    public final boolean av(String str, int i) {
        if (this.iVo.containsKey(str)) {
            return ((b) this.iVo.get(str)).iVs.add(Integer.valueOf(i));
        }
        x.w("MicroMsg.DynamicPageViewStateMonitor", "no keyList exists, widgetId[%s]", str);
        return false;
    }
}
