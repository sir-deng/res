package com.tencent.mm.plugin.voiceprint;

import com.tencent.mm.plugin.voiceprint.a.a;
import com.tencent.mm.plugin.voiceprint.model.k;
import com.tencent.mm.pluginsdk.c.b;
import com.tencent.mm.pluginsdk.c.c;
import com.tencent.mm.pluginsdk.p;
import com.tencent.mm.y.ap;

public class Plugin implements c {
    public p createApplication() {
        return new a();
    }

    public b getContactWidgetFactory() {
        return null;
    }

    public ap createSubCore() {
        return new k();
    }
}
