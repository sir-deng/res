package com.tencent.mm.plugin.webview.fts.topstory.ui;

import android.content.Context;
import android.view.OrientationEventListener;
import com.tencent.mm.plugin.appbrand.jsapi.share.i;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class a extends OrientationEventListener {
    public static final a tuH = new a(ad.getContext());
    private int orientation = -1;
    private int oxo = -1;
    private int oxp = -1;
    private long oxq = 0;
    private long oxr = 0;
    a tuG;

    public interface a {
        void td(int i);
    }

    private a(Context context) {
        super(context);
    }

    public final void onOrientationChanged(int i) {
        if (bi.bB(this.oxr) < 2000) {
            x.v("MicroMsg.DeviceOrientationListener", "onOrientationChanged, not reach DETECT_THRESHOLD");
            return;
        }
        x.d("MicroMsg.DeviceOrientationListener", "onOrientationChanged: %s", Integer.valueOf(i));
        if (Math.abs(this.oxo - i) >= 60 && bi.bB(this.oxq) >= 1000) {
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
            if (this.tuG != null) {
                this.tuG.td(this.orientation);
            }
        }
    }

    public final void enable() {
        super.enable();
        this.oxr = bi.Wz();
    }
}
