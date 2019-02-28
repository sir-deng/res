package com.tencent.mm.plugin.video;

import android.content.Context;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import com.tencent.mm.sdk.platformtools.x;

public class ObservableSurfaceView extends SurfaceView implements Callback {
    protected SurfaceHolder iOt;
    private a smv = null;
    protected boolean smw = false;
    protected boolean smx = false;
    protected boolean smy = false;

    public ObservableSurfaceView(Context context) {
        super(context);
        init();
    }

    public ObservableSurfaceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public ObservableSurfaceView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private void init() {
        this.iOt = getHolder();
        this.iOt.addCallback(this);
    }

    public final SurfaceHolder getSurfaceHolder() {
        return this.iOt;
    }

    public final void bGm() {
        this.smy = true;
        if (this.smy) {
            this.iOt.setType(3);
        }
    }

    public final void a(a aVar) {
        this.smv = aVar;
        if (this.smy) {
            this.iOt.setType(3);
        }
    }

    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        this.smw = true;
    }

    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        x.d("MicroMsg.ObservableSurfaceView", "surfaceChanged");
        this.smx = true;
        try {
            this.iOt.removeCallback(this);
        } catch (Exception e) {
        }
        this.iOt = surfaceHolder;
        this.iOt.addCallback(this);
        if (this.smv != null) {
            this.smv.a(this.iOt);
        }
    }

    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        this.smw = false;
        this.smx = false;
    }

    public final boolean bGn() {
        return this.smw;
    }
}
