package com.tencent.mm.plugin.topstory;

import com.tencent.mm.kernel.a.b.b;
import com.tencent.mm.kernel.api.bucket.c;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.c.d;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.topstory.a.a;

public class PluginTopStory extends f implements b, c {
    private a ske;

    public void execute(g gVar) {
        if (gVar.DZ()) {
            this.ske = new a();
            com.tencent.mm.kernel.g.a(a.class, new d(this.ske));
        }
    }

    public void parallelsDependency() {
    }

    public void onAccountInitialized(e.c cVar) {
    }

    public void onAccountRelease() {
    }
}
