package com.tencent.mm.plugin.ipcall.a.b;

import com.tencent.mm.sdk.platformtools.SensorController;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.az;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class d implements com.tencent.mm.sdk.platformtools.SensorController.a {
    public SensorController kIB = new SensorController(ad.getContext());
    public az kIF = new az(ad.getContext());
    public long kIG = -1;
    private boolean kIL = false;
    public a nKk = null;

    public interface a {
        void gb(boolean z);
    }

    public final void dX(final boolean z) {
        boolean z2 = true;
        x.i("MicroMsg.IPCallSensorManager", "onSensorEvent, isON:" + z + "  hasSkip:" + this.kIL + " tick:" + bi.bB(this.kIG) + "  lt:" + this.kIG);
        if (this.kIL) {
            if (z) {
                z2 = false;
            }
            this.kIL = z2;
        } else if (z || this.kIG == -1 || bi.bB(this.kIG) <= 400) {
            this.kIL = false;
            x.i("MicroMsg.IPCallSensorManager", "onSensorEvent, isNeedOffScreen: %b", Boolean.valueOf(z));
            new al(new com.tencent.mm.sdk.platformtools.al.a() {
                public final boolean uG() {
                    if (z) {
                        x.i("MicroMsg.IPCallSensorManager", "light screen");
                        if (d.this.nKk != null) {
                            d.this.nKk.gb(false);
                        }
                    } else {
                        x.i("MicroMsg.IPCallSensorManager", "off screen");
                        if (d.this.nKk != null) {
                            d.this.nKk.gb(true);
                        }
                    }
                    return false;
                }
            }, false).K(50, 50);
        } else {
            this.kIL = true;
        }
    }
}
