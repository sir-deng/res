package com.tencent.mm.plugin.ipcall.a.b;

import com.tencent.mm.plugin.appbrand.jsapi.a.e;
import com.tencent.mm.plugin.ipcall.a.i;
import com.tencent.mm.plugin.voip.model.b;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.as;

public final class a {
    public boolean fBn = false;
    public b nJL = null;
    public final Object nJM = new Object();
    public int nJN = 0;
    public boolean nJO = false;

    class a implements Runnable {
        private b nJQ = null;

        public a(b bVar) {
            this.nJQ = bVar;
        }

        public final void run() {
            if (this.nJQ != null) {
                this.nJQ.bGP();
                this.nJQ.bGM();
                this.nJQ = null;
                a.this.nJO = false;
            }
            as.Hn().setMode(0);
        }
    }

    public final void ga(boolean z) {
        x.i("MicroMsg.IPCallAudioPlayer", "setSpeakerPhoneOn, old isSpeakerPhoneOn: %b, new isSpeakerPhoneOn: %b", Boolean.valueOf(this.nJO), Boolean.valueOf(z));
        as.Hn().bd(z);
        com.tencent.mm.plugin.ipcall.a.c.a aUf = i.aUf();
        if ((z ? aUf.nKn.tv(401) : aUf.nKn.tv(e.CTRL_INDEX)) < 0) {
            x.e("MicroMsg.IPCallEngineManager", "setSpeakerPhoneOn, failed, ret: %d", Integer.valueOf(z ? aUf.nKn.tv(401) : aUf.nKn.tv(e.CTRL_INDEX)));
        }
        if (z != this.nJO) {
            this.nJO = z;
            if (this.nJL != null && this.nJL.soN) {
                this.nJL.ji(z);
            }
        }
    }

    public static boolean xX() {
        return as.Hn().gDM.isSpeakerphoneOn();
    }
}
