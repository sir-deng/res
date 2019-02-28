package com.tencent.mm.plugin.ipcall;

import com.tencent.mm.plugin.ipcall.a.i;
import com.tencent.mm.pluginsdk.c.b;
import com.tencent.mm.pluginsdk.c.c;
import com.tencent.mm.pluginsdk.p;
import com.tencent.mm.y.ap;

public class Plugin implements c {
    b nHR = new b();

    public p createApplication() {
        return this.nHR;
    }

    public b getContactWidgetFactory() {
        return null;
    }

    public ap createSubCore() {
        return i.aUd();
    }
}
