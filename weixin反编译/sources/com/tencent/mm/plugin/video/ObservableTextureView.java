package com.tencent.mm.plugin.video;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.util.AttributeSet;
import android.view.TextureView.SurfaceTextureListener;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.MMTextureView;

public class ObservableTextureView extends MMTextureView implements SurfaceTextureListener {
    protected SurfaceTexture aDa;
    private boolean smA = false;
    protected b smz;

    public ObservableTextureView(Context context) {
        super(context);
        init();
    }

    public ObservableTextureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public ObservableTextureView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    private void init() {
        setSurfaceTextureListener(this);
        this.aDa = getSurfaceTexture();
    }

    public boolean isAvailable() {
        return this.smA;
    }

    public final void a(b bVar) {
        this.smz = bVar;
    }

    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        x.i("MicroMsg.ObservableTextureView", "onSurfaceTextureAvailable");
        cqy();
        this.smA = true;
        if (this.smz != null) {
            this.smz.d(surfaceTexture);
        }
    }

    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        x.d("MicroMsg.ObservableTextureView", "onSurfaceTextureSizeChanged");
    }

    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        x.i("MicroMsg.ObservableTextureView", "onSurfaceTextureDestroyed");
        this.smA = false;
        return false;
    }

    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }
}
