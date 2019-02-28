package com.tencent.mm.plugin.api.recordView;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.opengl.GLSurfaceView.EGLConfigChooser;
import android.opengl.GLSurfaceView.EGLContextFactory;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import com.tencent.mm.sdk.platformtools.x;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;

class MMSightCameraGLSurfaceView extends GLSurfaceView {
    int iqY;
    int iqZ;
    a irq = null;
    private int irr = 0;
    int irs;

    class b implements EGLContextFactory {
        private int EGL_CONTEXT_CLIENT_VERSION = 12440;

        b() {
        }

        public final EGLContext createContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig) {
            x.w("MicroMsg.MMSightCameraGLSurfaceView", "creating OpenGL ES 2.0 context");
            return egl10.eglCreateContext(eGLDisplay, eGLConfig, EGL10.EGL_NO_CONTEXT, new int[]{this.EGL_CONTEXT_CLIENT_VERSION, 2, 12344});
        }

        public final void destroyContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLContext eGLContext) {
            egl10.eglDestroyContext(eGLDisplay, eGLContext);
        }
    }

    class a implements EGLConfigChooser {
        private int EGL_OPENGL_ES2_BIT = 4;
        private int[] irA = new int[1];
        private int[] irt = new int[]{12324, 4, 12323, 4, 12322, 4, 12352, this.EGL_OPENGL_ES2_BIT, 12344};
        protected int iru = 5;
        protected int irv = 6;
        protected int irw = 5;
        protected int irx = 0;
        protected int iry = 0;
        protected int irz = 0;

        public final EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay) {
            int[] iArr = new int[1];
            egl10.eglChooseConfig(eGLDisplay, this.irt, null, 0, iArr);
            int i = iArr[0];
            if (i <= 0) {
                throw new IllegalArgumentException("No configs match configSpec");
            }
            EGLConfig[] eGLConfigArr = new EGLConfig[i];
            egl10.eglChooseConfig(eGLDisplay, this.irt, eGLConfigArr, i, iArr);
            c(egl10, eGLDisplay, eGLConfigArr);
            return b(egl10, eGLDisplay, eGLConfigArr);
        }

        private EGLConfig b(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr) {
            for (EGLConfig eGLConfig : eGLConfigArr) {
                int a = a(egl10, eGLDisplay, eGLConfig, 12325);
                int a2 = a(egl10, eGLDisplay, eGLConfig, 12326);
                if (a >= this.iry && a2 >= this.irz) {
                    a = a(egl10, eGLDisplay, eGLConfig, 12324);
                    a2 = a(egl10, eGLDisplay, eGLConfig, 12323);
                    int a3 = a(egl10, eGLDisplay, eGLConfig, 12322);
                    int a4 = a(egl10, eGLDisplay, eGLConfig, 12321);
                    if (a == this.iru && a2 == this.irv && a3 == this.irw && a4 == this.irx) {
                        return eGLConfig;
                    }
                }
            }
            return null;
        }

        private int a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, int i) {
            if (egl10.eglGetConfigAttrib(eGLDisplay, eGLConfig, i, this.irA)) {
                return this.irA[0];
            }
            return 0;
        }

        private static void c(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr) {
            x.i("GLConfigChooser", String.format("%d configurations", new Object[]{Integer.valueOf(eGLConfigArr.length)}));
            for (EGLConfig eGLConfig : eGLConfigArr) {
                x.i("GLConfigChooser", String.format("Configuration %d:\n", new Object[]{Integer.valueOf(r2)}));
                int[] iArr = new int[]{12320, 12321, 12322, 12323, 12324, 12325, 12326, 12327, 12328, 12329, 12330, 12331, 12332, 12333, 12334, 12335, 12336, 12337, 12338, 12339, 12340, 12343, 12342, 12341, 12345, 12346, 12347, 12348, 12349, 12350, 12351, 12352, 12354};
                String[] strArr = new String[]{"EGL_BUFFER_SIZE", "EGL_ALPHA_SIZE", "EGL_BLUE_SIZE", "EGL_GREEN_SIZE", "EGL_RED_SIZE", "EGL_DEPTH_SIZE", "EGL_STENCIL_SIZE", "EGL_CONFIG_CAVEAT", "EGL_CONFIG_ID", "EGL_LEVEL", "EGL_MAX_PBUFFER_HEIGHT", "EGL_MAX_PBUFFER_PIXELS", "EGL_MAX_PBUFFER_WIDTH", "EGL_NATIVE_RENDERABLE", "EGL_NATIVE_VISUAL_ID", "EGL_NATIVE_VISUAL_TYPE", "EGL_PRESERVED_RESOURCES", "EGL_SAMPLES", "EGL_SAMPLE_BUFFERS", "EGL_SURFACE_TYPE", "EGL_TRANSPARENT_TYPE", "EGL_TRANSPARENT_RED_VALUE", "EGL_TRANSPARENT_GREEN_VALUE", "EGL_TRANSPARENT_BLUE_VALUE", "EGL_BIND_TO_TEXTURE_RGB", "EGL_BIND_TO_TEXTURE_RGBA", "EGL_MIN_SWAP_INTERVAL", "EGL_MAX_SWAP_INTERVAL", "EGL_LUMINANCE_SIZE", "EGL_ALPHA_MASK_SIZE", "EGL_COLOR_BUFFER_TYPE", "EGL_RENDERABLE_TYPE", "EGL_CONFORMANT"};
                int[] iArr2 = new int[1];
                for (int i = 0; i < 33; i++) {
                    egl10.eglGetConfigAttrib(eGLDisplay, eGLConfig, iArr[i], iArr2);
                }
            }
        }
    }

    public MMSightCameraGLSurfaceView(Context context) {
        super(context);
        init();
    }

    public MMSightCameraGLSurfaceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    private void init() {
        getHolder().addCallback(this);
        try {
            getHolder().setType(2);
        } catch (Exception e) {
            try {
                getHolder().setType(1);
            } catch (Exception e2) {
                try {
                    getHolder().setType(0);
                } catch (Exception e3) {
                }
            }
        }
        setEGLContextFactory(new b());
        setEGLConfigChooser(new a());
        this.irq = new a();
        setRenderer(this.irq);
        setRenderMode(0);
    }

    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        super.surfaceCreated(surfaceHolder);
        x.i("MicroMsg.MMSightCameraGLSurfaceView", "surfaceCreated: %s this: %s %s", surfaceHolder, this, Integer.valueOf(getId()));
    }

    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        super.surfaceDestroyed(surfaceHolder);
        x.i("MicroMsg.MMSightCameraGLSurfaceView", "surfaceDestroyed: %s this: %s", surfaceHolder, this);
    }

    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        super.surfaceChanged(surfaceHolder, i, i2, i3);
        x.i("MicroMsg.MMSightCameraGLSurfaceView", "surfaceChanged, format: %s, w: %s, h: %s this: %s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), this);
    }
}
