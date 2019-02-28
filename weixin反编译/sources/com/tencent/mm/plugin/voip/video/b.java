package com.tencent.mm.plugin.voip.video;

import android.opengl.GLSurfaceView.EGLConfigChooser;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLDisplay;

final class b implements EGLConfigChooser {
    private static int EGL_OPENGL_ES2_BIT = 4;
    private static int[] irt = new int[]{12324, 4, 12323, 4, 12322, 4, 12352, EGL_OPENGL_ES2_BIT, 12344};
    private int[] irA = new int[1];
    protected int iru = 5;
    protected int irv = 6;
    protected int irw = 5;
    protected int irx = 0;
    protected int iry = 0;
    protected int irz = 0;

    public final EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay) {
        int[] iArr = new int[1];
        egl10.eglChooseConfig(eGLDisplay, irt, null, 0, iArr);
        int i = iArr[0];
        if (i <= 0) {
            throw new IllegalArgumentException("No configs match configSpec");
        }
        EGLConfig[] eGLConfigArr = new EGLConfig[i];
        egl10.eglChooseConfig(eGLDisplay, irt, eGLConfigArr, i, iArr);
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
}
