package com.tencent.mm.plugin.traceroute;

import com.tencent.mm.plugin.traceroute.a.a;
import com.tencent.mm.pluginsdk.c.b;
import com.tencent.mm.pluginsdk.c.c;
import com.tencent.mm.pluginsdk.p;
import com.tencent.mm.y.ap;

public final class Plugin implements c {
    public final p createApplication() {
        return new a();
    }

    public final b getContactWidgetFactory() {
        return null;
    }

    public final ap createSubCore() {
        return null;
    }
}
