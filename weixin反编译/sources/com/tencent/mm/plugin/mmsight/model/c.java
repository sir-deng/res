package com.tencent.mm.plugin.mmsight.model;

import android.content.Context;
import android.view.OrientationEventListener;
import com.tencent.mm.plugin.appbrand.jsapi.share.i;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class c extends OrientationEventListener {
    public int orientation = -1;
    public int oxo = -1;
    public int oxp = -1;
    private long oxq = 0;
    private long oxr = 0;
    public a oxs;

    public interface a {
        void td(int i);
    }

    public c(Context context) {
        super(context, 2);
    }

    public final void onOrientationChanged(int i) {
        if (!j.oyA) {
            return;
        }
        if (bi.bB(this.oxr) < 2000) {
            x.v("MicroMsg.DeviceOrientationListener", "onOrientationChanged, not reach DETECT_THRESHOLD");
        } else if (Math.abs(this.oxo - i) >= 30 || bi.bB(this.oxq) >= 300) {
            this.oxo = i;
            this.oxq = bi.Wz();
            if (i <= 60 || i >= 300) {
                if (i <= 30 || i >= 330) {
                    this.orientation = 0;
                }
            } else if (i < 30 || i > 150) {
                if (i < 120 || i > 240) {
                    if (i >= i.CTRL_INDEX && i <= 330 && i >= 240 && i <= 300) {
                        this.orientation = 270;
                    }
                } else if (i >= 150 && i <= i.CTRL_INDEX) {
                    this.orientation = 180;
                }
            } else if (i >= 60 && i <= 120) {
                this.orientation = 90;
            }
            if (this.oxs != null) {
                this.oxs.td(this.orientation);
            }
        }
    }

    public final void enable() {
        x.i("MicroMsg.DeviceOrientationListener", "enable, config isEnableLandscapeMode: %s", Boolean.valueOf(j.oyA));
        if (j.oyA) {
            super.enable();
            this.oxr = bi.Wz();
        }
    }

    public final int getOrientation() {
        if (j.oyA) {
            return this.orientation;
        }
        return 0;
    }

    public final boolean baC() {
        if (!j.oyA) {
            return false;
        }
        x.i("MicroMsg.DeviceOrientationListener", "isLandscape, tickToNow: %s, orientation: %s", Long.valueOf(bi.bB(this.oxr)), Integer.valueOf(this.orientation));
        if (bi.bB(this.oxr) < 2000 || this.orientation < 0) {
            return false;
        }
        if (this.orientation == 90 || this.orientation == 270) {
            return true;
        }
        return false;
    }
}
