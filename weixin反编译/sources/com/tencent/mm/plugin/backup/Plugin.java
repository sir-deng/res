package com.tencent.mm.plugin.backup;

import com.tencent.mm.plugin.backup.i.a;
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
        if (a.kzY == null) {
            a.kzY = new a();
        }
        return a.kzY;
    }
}
