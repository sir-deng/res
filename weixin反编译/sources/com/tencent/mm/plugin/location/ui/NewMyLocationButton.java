package com.tencent.mm.plugin.location.ui;

import android.content.Context;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import com.tencent.mm.R;
import com.tencent.mm.modelgeo.a.a;
import com.tencent.mm.modelgeo.c;
import com.tencent.mm.plugin.p.d;
import com.tencent.mm.sdk.platformtools.ag;

public class NewMyLocationButton extends FrameLayout {
    private Context context;
    private a gAn = new a() {
        public final boolean a(boolean z, float f, float f2, int i, double d, double d2, double d3) {
            if (!z) {
                return false;
            }
            NewMyLocationButton.this.nYr.setVisibility(8);
            NewMyLocationButton.this.nYq.setVisibility(0);
            if (NewMyLocationButton.this.nYs != null && NewMyLocationButton.this.nYt) {
                NewMyLocationButton.this.nYs.getIController().setCenter((double) f2, (double) f);
                if (NewMyLocationButton.this.nYs.getZoomLevel() < 16) {
                    NewMyLocationButton.this.nYs.getIController().setZoom(16);
                }
            }
            new ag(Looper.getMainLooper()).post(new Runnable() {
                public final void run() {
                    c.OV().c(NewMyLocationButton.this.gAn);
                }
            });
            return false;
        }
    };
    private ImageButton nYq;
    private LinearLayout nYr;
    private d nYs;
    private boolean nYt = true;

    public NewMyLocationButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.context = context;
        init();
    }

    public NewMyLocationButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.context = context;
        init();
    }

    private void init() {
        View inflate = View.inflate(this.context, R.i.dpe, this);
        this.nYq = (ImageButton) inflate.findViewById(R.h.cAe);
        this.nYr = (LinearLayout) inflate.findViewById(R.h.cAg);
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        this.nYq.setOnClickListener(onClickListener);
    }
}
