package com.tencent.mm.plugin.mmsight;

import com.tencent.mm.pluginsdk.c.b;
import com.tencent.mm.pluginsdk.c.c;
import com.tencent.mm.pluginsdk.p;
import com.tencent.mm.y.ap;

public class Plugin implements c {
    public p createApplication() {
        return new b();
    }

    public b getContactWidgetFactory() {
        return null;
    }

    public ap createSubCore() {
        return null;
    }
}
