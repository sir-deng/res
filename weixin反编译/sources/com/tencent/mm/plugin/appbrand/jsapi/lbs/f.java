package com.tencent.mm.plugin.appbrand.jsapi.lbs;

import android.os.Looper;
import android.os.Message;
import com.tencent.mm.plugin.appbrand.b.b.a;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.sdk.d.c;
import com.tencent.mm.sdk.d.d;

final class f extends d implements a {
    final j jga;
    final b jnU;
    int jnV = 0;
    final c jnW = new c() {
        public final String getName() {
            return f.this.mName + "$StateNotListening";
        }

        public final boolean j(Message message) {
            if (1 != message.what) {
                return super.j(message);
            }
            f.this.b(f.this.jnX);
            return true;
        }

        public final void enter() {
            super.enter();
            b.jYv.b(f.this.jnU);
            com.tencent.mm.plugin.appbrand.page.a.q(f.this.jga.iuk).ls(f.this.jnV);
        }
    };
    final c jnX = new c() {
        public final String getName() {
            return f.this.mName + "$StateListening";
        }

        public final void enter() {
            super.enter();
            b.jYv.a(f.this.jnU);
            f.this.jnV = com.tencent.mm.plugin.appbrand.page.a.q(f.this.jga.iuk).a(com.tencent.mm.plugin.appbrand.page.a.a.LBS);
        }

        public final void exit() {
            super.exit();
            b.jYv.b(f.this.jnU);
        }

        public final boolean j(Message message) {
            if (2 == message.what) {
                f.this.b(f.this.jnW);
                return true;
            } else if (3 != message.what) {
                return super.j(message);
            } else {
                f.this.b(f.this.jnY);
                return true;
            }
        }
    };
    final c jnY = new c() {
        public final String getName() {
            return f.this.mName + "$StateListeningButSuspend";
        }

        public final boolean j(Message message) {
            if (2 == message.what) {
                f.this.b(f.this.jnW);
                return true;
            } else if (4 != message.what) {
                return super.j(message);
            } else {
                f.this.b(f.this.jnX);
                return true;
            }
        }
    };

    f(j jVar) {
        super("AppBrand$RuntimeLocationUpdateStateManager[" + jVar.mAppId + "]", Looper.getMainLooper());
        this.jga = jVar;
        this.jnU = new b(jVar);
        jVar.iuk.itj.a((a) this);
        a(this.jnW);
        a(this.jnX);
        a(this.jnY);
        b(this.jnW);
    }

    public final void a(com.tencent.mm.plugin.appbrand.b.a aVar) {
        if (aVar == com.tencent.mm.plugin.appbrand.b.a.DESTROYED) {
            quit();
        } else if (aVar == com.tencent.mm.plugin.appbrand.b.a.SUSPEND) {
            DA(3);
        } else if (aVar == com.tencent.mm.plugin.appbrand.b.a.FOREGROUND) {
            DA(4);
        }
    }
}
