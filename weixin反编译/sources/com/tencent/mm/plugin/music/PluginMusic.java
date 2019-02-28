package com.tencent.mm.plugin.music;

import com.tencent.mm.au.a.a;
import com.tencent.mm.au.a.b;
import com.tencent.mm.au.e;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;

public class PluginMusic extends f implements b {
    public void configure(g gVar) {
        if (gVar.DZ()) {
            com.tencent.mm.kernel.g.Dr();
            com.tencent.mm.kernel.g.a(a.class, new e());
        }
    }

    public void execute(g gVar) {
    }
}
