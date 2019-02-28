package com.tencent.mm.plugin.gallery;

import com.tencent.mm.bx.h.d;
import com.tencent.mm.pluginsdk.c.b;
import com.tencent.mm.pluginsdk.c.c;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.pluginsdk.n;
import com.tencent.mm.pluginsdk.p;
import com.tencent.mm.y.ap;
import java.util.HashMap;

public class Plugin implements c {
    public p createApplication() {
        return new p() {
            public final void a(n nVar) {
            }

            public final void a(m mVar) {
            }
        };
    }

    public b getContactWidgetFactory() {
        return null;
    }

    public ap createSubCore() {
        return new ap() {
            public final HashMap<Integer, d> Bu() {
                return null;
            }

            public final void ge(int i) {
            }

            public final void bs(boolean z) {
            }

            public final void bt(boolean z) {
            }

            public final void onAccountRelease() {
            }
        };
    }
}
