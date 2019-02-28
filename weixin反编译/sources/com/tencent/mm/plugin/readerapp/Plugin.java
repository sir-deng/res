package com.tencent.mm.plugin.readerapp;

import android.content.Context;
import com.tencent.mm.plugin.readerapp.b.g;
import com.tencent.mm.pluginsdk.c.a;
import com.tencent.mm.pluginsdk.c.b;
import com.tencent.mm.pluginsdk.c.c;
import com.tencent.mm.pluginsdk.p;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.ap;

public final class Plugin implements c {
    private b kGm = new b() {
        public final a Q(Context context, String str) {
            x.i("MicroMsg.ReaderApp.Plugin", "create contact widget type[%s]", str);
            if ("widget_type_news".equals(str)) {
                return new com.tencent.mm.plugin.readerapp.ui.b(context);
            }
            return null;
        }
    };

    public final p createApplication() {
        return new com.tencent.mm.plugin.readerapp.a.a();
    }

    public final b getContactWidgetFactory() {
        return this.kGm;
    }

    public final ap createSubCore() {
        return new g();
    }
}
