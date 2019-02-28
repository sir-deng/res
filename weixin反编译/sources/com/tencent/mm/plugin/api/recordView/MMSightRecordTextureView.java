package com.tencent.mm.plugin.api.recordView;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.util.AttributeSet;
import android.view.TextureView.SurfaceTextureListener;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.MMTextureView;

class MMSightRecordTextureView extends MMTextureView implements SurfaceTextureListener {
    private int iqU;
    private int iqV;
    private d irC;
    private c irD;

    public MMSightRecordTextureView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setSurfaceTextureListener(this);
    }

    public MMSightRecordTextureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setSurfaceTextureListener(this);
    }

    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        x.i("MicroMsg.MMSightRecordTextureViewImpl", "onSurfaceTextureAvailable, surface: %s, width: %s, height: %s", surfaceTexture, Integer.valueOf(i), Integer.valueOf(i2));
        this.iqU = i;
        this.iqV = i2;
        this.irC = new d();
        this.irD = new c(surfaceTexture, this.irC);
        this.irC.bv(i, i2);
        this.irD.irJ = true;
        this.irD.start();
    }

    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        x.i("MicroMsg.MMSightRecordTextureViewImpl", "onSurfaceTextureSizeChanged, surface: %s, width: %s, height: %s", surfaceTexture, Integer.valueOf(i), Integer.valueOf(i2));
        this.iqU = i;
        this.iqV = i2;
        this.irC.bv(i, i2);
    }

    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        this.irD.irJ = false;
        try {
            this.irD.join();
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.MMSightRecordTextureViewImpl", e, "onSurfaceTextureDestroyed error: %s", e.getMessage());
        }
        this.irD = null;
        return false;
    }

    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }
}
