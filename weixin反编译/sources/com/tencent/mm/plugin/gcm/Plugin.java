package com.tencent.mm.plugin.gcm;

import com.tencent.mm.f.a.av;
import com.tencent.mm.f.a.gv;
import com.tencent.mm.plugin.gcm.modelgcm.GcmBroadcastReceiver;
import com.tencent.mm.plugin.gcm.modelgcm.a;
import com.tencent.mm.pluginsdk.c.c;
import com.tencent.mm.pluginsdk.p;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.ap;

public class Plugin implements c {
    com.tencent.mm.sdk.b.c nDJ = new com.tencent.mm.sdk.b.c<av>() {
        {
            this.xmG = av.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            a aSH = a.aSH();
            if (aSH == null) {
                return false;
            }
            aSH.aSI();
            return true;
        }
    };
    com.tencent.mm.sdk.b.c nDK = new com.tencent.mm.sdk.b.c<gv>() {
        {
            this.xmG = gv.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            a aSH = a.aSH();
            if (aSH == null) {
                return false;
            }
            x.i("GcmRegister", "GCM onLogout. isRegToSvr:" + aSH.aSP());
            GcmBroadcastReceiver.aSG();
            if (aSH.aSP()) {
                aSH.aSO();
            }
            return true;
        }
    };

    public Plugin() {
        com.tencent.mm.sdk.b.a.xmy.b(this.nDJ);
        com.tencent.mm.sdk.b.a.xmy.b(this.nDK);
    }

    public p createApplication() {
        return new com.tencent.mm.plugin.gcm.a.a();
    }

    public com.tencent.mm.pluginsdk.c.b getContactWidgetFactory() {
        return null;
    }

    public ap createSubCore() {
        return new com.tencent.mm.plugin.gcm.modelgcm.b();
    }
}
