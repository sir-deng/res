package com.tencent.mm.plugin.radar.ui;

import android.content.Context;
import android.media.MediaPlayer;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.widget.RelativeLayout;
import b.c.b.e;
import com.tencent.mm.sdk.platformtools.x;

public final class RadarWaveView extends RelativeLayout {
    static final String TAG = TAG;
    public static final a pGd = new a();
    MediaPlayer pGa;
    View pGb;
    Animation pGc;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }
    }

    public RadarWaveView(Context context, AttributeSet attributeSet) {
        e.i(context, "context");
        e.i(attributeSet, "attrs");
        super(context, attributeSet);
    }

    public final void bmQ() {
        x.d(TAG, "start wave animation");
        setVisibility(0);
        View view = this.pGb;
        if (view == null) {
            e.cKr();
        }
        view.startAnimation(this.pGc);
    }

    public final void bmR() {
        x.d(TAG, "stop wave animation. forces, %d, %d", Integer.valueOf(getMeasuredHeight()), Integer.valueOf(getMeasuredWidth()));
        setVisibility(4);
        View view = this.pGb;
        if (view == null) {
            e.cKr();
        }
        view.clearAnimation();
    }
}
