package com.tencent.mm.plugin.bottle;

import android.content.Context;
import com.tencent.mm.plugin.bottle.a.i;
import com.tencent.mm.plugin.bottle.ui.e;
import com.tencent.mm.pluginsdk.c.a;
import com.tencent.mm.pluginsdk.c.b;
import com.tencent.mm.pluginsdk.c.c;
import com.tencent.mm.pluginsdk.p;
import com.tencent.mm.y.ap;

public final class Plugin implements c {
    private b kGm = new b() {
        public final a Q(Context context, String str) {
            return new e(context);
        }
    };

    public final p createApplication() {
        return new a();
    }

    public final ap createSubCore() {
        return new i();
    }

    public final b getContactWidgetFactory() {
        return this.kGm;
    }
}
