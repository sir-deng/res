package com.tencent.mm.plugin.notification;

import com.tencent.mm.plugin.notification.d.f;
import com.tencent.mm.pluginsdk.c.b;
import com.tencent.mm.pluginsdk.c.c;
import com.tencent.mm.pluginsdk.p;
import com.tencent.mm.y.ap;

public class Plugin implements c {
    a oZB = new a();

    public p createApplication() {
        return this.oZB;
    }

    public b getContactWidgetFactory() {
        return null;
    }

    public ap createSubCore() {
        return f.bhn();
    }
}
