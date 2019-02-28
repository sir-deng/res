package com.tencent.mm.plugin.shake;

import android.content.Context;
import com.tencent.mm.plugin.shake.b.m;
import com.tencent.mm.pluginsdk.c.a;
import com.tencent.mm.pluginsdk.c.b;
import com.tencent.mm.pluginsdk.c.c;
import com.tencent.mm.pluginsdk.p;
import com.tencent.mm.y.ap;

public class Plugin implements c {
    private b qtp = new b() {
        public final a Q(Context context, String str) {
            return new com.tencent.mm.plugin.shake.ui.a(context);
        }
    };

    public p createApplication() {
        return new a();
    }

    public b getContactWidgetFactory() {
        return this.qtp;
    }

    public ap createSubCore() {
        return new m();
    }
}
