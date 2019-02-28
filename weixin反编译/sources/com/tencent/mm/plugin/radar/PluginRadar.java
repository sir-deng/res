package com.tencent.mm.plugin.radar;

import b.c.b.e;
import com.tencent.mm.bl.c;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.p;

public final class PluginRadar extends f implements com.tencent.mm.plugin.radar.a.a {
    private static final String TAG = TAG;
    public static final a pAS = new a();

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }
    }

    public final void configure(g gVar) {
        e.i(gVar, "profile");
        if (gVar.DZ()) {
            x.i(TAG, "PluginRadar configure");
            pin(new p(c.class));
        }
    }

    public final void execute(g gVar) {
        e.i(gVar, "profile");
        c.TG("radar");
    }
}
