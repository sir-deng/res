package com.tencent.mm.plugin.mmsight.ui.cameraglview;

import com.tencent.mm.plugin.mmsight.model.f;
import com.tencent.mm.sdk.platformtools.x;

public final class a {
    public f oJe = new f() {
        public final boolean R(byte[] bArr) {
            if (a.this.oJf != null) {
                MMSightCameraGLSurfaceView mMSightCameraGLSurfaceView = a.this.oJf;
                if (bArr == null || mMSightCameraGLSurfaceView.oJh == null || mMSightCameraGLSurfaceView.oJh.iqW) {
                    x.v("MicroMsg.MMSightCameraGLSurfaceView", "passing draw");
                } else {
                    mMSightCameraGLSurfaceView.oJh.b(bArr, mMSightCameraGLSurfaceView.iqY, mMSightCameraGLSurfaceView.iqZ, mMSightCameraGLSurfaceView.irs, false);
                    mMSightCameraGLSurfaceView.requestRender();
                }
            }
            return false;
        }
    };
    MMSightCameraGLSurfaceView oJf;

    public final void a(byte[] bArr, boolean z, int i) {
        if (this.oJf != null) {
            MMSightCameraGLSurfaceView mMSightCameraGLSurfaceView = this.oJf;
            if (bArr == null || mMSightCameraGLSurfaceView.oJh == null || mMSightCameraGLSurfaceView.oJh.iqW) {
                x.v("MicroMsg.MMSightCameraGLSurfaceView", "passing draw");
                return;
            }
            mMSightCameraGLSurfaceView.oJh.b(bArr, mMSightCameraGLSurfaceView.iqY, mMSightCameraGLSurfaceView.iqZ, i, z);
            mMSightCameraGLSurfaceView.requestRender();
        }
    }

    public a(MMSightCameraGLSurfaceView mMSightCameraGLSurfaceView) {
        this.oJf = mMSightCameraGLSurfaceView;
    }

    public final void R(int i, int i2, int i3) {
        if (this.oJf != null) {
            int i4 = (i3 == 0 || i3 == 180) ? i : i2;
            if (i3 == 0 || i3 == 180) {
                i = i2;
            }
            MMSightCameraGLSurfaceView mMSightCameraGLSurfaceView = this.oJf;
            x.i("MicroMsg.MMSightCameraGLSurfaceView", "setFrameInfo, width: %s, height: %s, rotate: %s this: %s", Integer.valueOf(i4), Integer.valueOf(i), Integer.valueOf(i3), mMSightCameraGLSurfaceView);
            mMSightCameraGLSurfaceView.iqY = i4;
            mMSightCameraGLSurfaceView.iqZ = i;
            mMSightCameraGLSurfaceView.irs = i3;
        }
    }

    public final void bcp() {
        if (this.oJf != null) {
            MMSightCameraGLSurfaceView mMSightCameraGLSurfaceView = this.oJf;
            if (mMSightCameraGLSurfaceView.oJh != null) {
                mMSightCameraGLSurfaceView.oJh.irn = true;
                mMSightCameraGLSurfaceView.requestRender();
            }
        }
    }
}
