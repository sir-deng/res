package com.tencent.mm.plugin.photoedit;

import com.tencent.mm.pluginsdk.c.b;
import com.tencent.mm.pluginsdk.c.c;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.pluginsdk.n;
import com.tencent.mm.pluginsdk.p;
import com.tencent.mm.y.ap;

public class Plugin implements c {
    public p createApplication() {
        return new p() {
            public final void a(n nVar) {
            }

            public final void a(m mVar) {
            }
        };
    }

    public b getContactWidgetFactory() {
        return null;
    }

    public ap createSubCore() {
        return new a();
    }
}
