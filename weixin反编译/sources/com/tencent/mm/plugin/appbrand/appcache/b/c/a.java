package com.tencent.mm.plugin.appbrand.appcache.b.c;

import android.util.SparseIntArray;
import com.tencent.mm.plugin.appbrand.appcache.b.b.b;
import com.tencent.mm.plugin.appbrand.appcache.b.b.c;
import com.tencent.mm.plugin.appbrand.appcache.b.b.d;
import com.tencent.mm.plugin.appbrand.appcache.b.b.e;
import com.tencent.mm.plugin.appbrand.appcache.b.b.f;
import com.tencent.mm.plugin.appbrand.appcache.b.b.g;
import com.tencent.mm.plugin.appbrand.appcache.b.b.h;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiOperateBackgroundAudio;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiSetBackgroundAudioState;
import com.tencent.mm.sdk.platformtools.x;

public final class a {
    public static final int iJQ = 1;
    public static final a iJR = new a<Class<? extends com.tencent.mm.plugin.appbrand.appcache.b.b.a>>() {
        {
            o(d.class, 20);
            o(c.class, 40);
            o(e.class, 80);
            o(g.class, 100);
            o(f.class, 120);
            o(h.class, 150);
            o(b.class, JsApiSetBackgroundAudioState.CTRL_INDEX);
        }
    };
    public static final a iJS = new a<Class<? extends com.tencent.mm.plugin.appbrand.appcache.b.b.a>>() {
        {
            o(d.class, 21);
            o(c.class, 41);
            o(e.class, 81);
            o(g.class, 101);
            o(f.class, 121);
            o(h.class, 151);
            o(b.class, JsApiOperateBackgroundAudio.CTRL_INDEX);
        }
    };
    public static final a iJT = new a<Class<? extends com.tencent.mm.plugin.appbrand.appcache.b.b.a>>() {
        {
            o(d.class, 22);
            o(c.class, 42);
            o(e.class, 82);
            o(g.class, 102);
            o(f.class, 122);
            o(h.class, com.tencent.mm.plugin.appbrand.jsapi.contact.d.CTRL_INDEX);
            o(b.class, 162);
        }
    };
    public static final a iJU = new a<Class<? extends com.tencent.mm.plugin.appbrand.appcache.b.b.a>>() {
        {
            o(d.class, 23);
            o(c.class, 43);
            o(e.class, 83);
            o(g.class, 103);
            o(f.class, 123);
            o(h.class, 153);
            o(b.class, 163);
        }
    };
    private static final /* synthetic */ int[] iJV = new int[]{iJQ};

    public static class a<_Key> extends SparseIntArray {
        public final void o(_Key _key, int i) {
            super.put(_key.hashCode(), i);
        }

        public final int get(_Key _key) {
            return _key == null ? -1 : super.get(_key.hashCode(), -1);
        }
    }

    public static void o(long j, long j2) {
        if (j2 < 0) {
            x.e("MicroMsg.AppBrand.PredownloadReporter", "idkeyStat with invalid ID(%d), key (%d)", Long.valueOf(j), Long.valueOf(j2));
            return;
        }
        if (j > 0) {
            com.tencent.mm.plugin.report.service.g.pWK.h(j, j2);
            com.tencent.mm.plugin.report.service.g.pWK.h(15272, Long.valueOf(j), Long.valueOf(j2));
        }
        if (843 != j) {
            com.tencent.mm.plugin.report.service.g.pWK.h(843, j2);
            com.tencent.mm.plugin.report.service.g.pWK.h(15272, Integer.valueOf(843), Long.valueOf(j2));
        }
    }
}
