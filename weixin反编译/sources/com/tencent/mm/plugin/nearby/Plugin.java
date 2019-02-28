package com.tencent.mm.plugin.nearby;

import android.content.Context;
import com.tencent.mm.plugin.nearby.a.f;
import com.tencent.mm.pluginsdk.c.a;
import com.tencent.mm.pluginsdk.c.b;
import com.tencent.mm.pluginsdk.c.c;
import com.tencent.mm.pluginsdk.p;
import com.tencent.mm.y.ap;

public class Plugin implements c {
    private b kGm = new b() {
        public final a Q(Context context, String str) {
            return new com.tencent.mm.plugin.nearby.ui.a(context);
        }
    };

    public p createApplication() {
        return new a();
    }

    public b getContactWidgetFactory() {
        return this.kGm;
    }

    public ap createSubCore() {
        return new f();
    }
}
