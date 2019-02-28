package com.tencent.mm.ui.base;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.TextureView;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.reflect.Field;

@TargetApi(14)
public class MMTextureView extends TextureView {
    private Field ymN;

    public MMTextureView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public MMTextureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public MMTextureView(Context context) {
        super(context);
    }

    @TargetApi(14)
    public void onDetachedFromWindow() {
        try {
            super.onDetachedFromWindow();
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.MMTextureView", e, "unkown error", new Object[0]);
        }
    }

    public final void cqy() {
        if (d.fO(16)) {
            x.i("MicroMsg.MMTextureView", "current API Level %d, do not do sly", Integer.valueOf(VERSION.SDK_INT));
        } else if (d.fP(20)) {
            x.i("MicroMsg.MMTextureView", "current API Level %d, do not do sly", Integer.valueOf(VERSION.SDK_INT));
        } else if (q.gHP.gHh == 2) {
            x.i("MicroMsg.MMTextureView", "do not do sly textureView, config ERROR");
        } else {
            x.i("MicroMsg.MMTextureView", "detect texture problem, sly");
            try {
                if (this.ymN == null) {
                    this.ymN = TextureView.class.getDeclaredField("mSurface");
                    this.ymN.setAccessible(true);
                }
                SurfaceTexture surfaceTexture = (SurfaceTexture) this.ymN.get(this);
                if (surfaceTexture == null) {
                    x.i("MicroMsg.MMTextureView", "detect texture problem, no wrap");
                } else if (surfaceTexture instanceof t) {
                    x.i("MicroMsg.MMTextureView", "detect texture problem, wrapped");
                } else {
                    t tVar = new t();
                    tVar.mrs = surfaceTexture;
                    this.ymN.set(this, tVar);
                    x.i("MicroMsg.MMTextureView", "detect texture problem, wrap");
                }
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.MMTextureView", e, "", new Object[0]);
                x.e("MicroMsg.MMTextureView", "detect texture problem, NoSuchFieldException");
            } catch (Throwable e2) {
                x.printErrStackTrace("MicroMsg.MMTextureView", e2, "", new Object[0]);
                x.e("MicroMsg.MMTextureView", "detect texture problem, IllegalArgumentException");
            } catch (Throwable e22) {
                x.printErrStackTrace("MicroMsg.MMTextureView", e22, "", new Object[0]);
                x.e("MicroMsg.MMTextureView", "detect texture problem, IllegalAccessException");
            }
        }
    }

    @TargetApi(16)
    public void setSurfaceTexture(SurfaceTexture surfaceTexture) {
        super.setSurfaceTexture(surfaceTexture);
        cqy();
    }
}
