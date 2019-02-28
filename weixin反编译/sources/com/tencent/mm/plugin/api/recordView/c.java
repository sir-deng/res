package com.tencent.mm.plugin.api.recordView;

import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import android.opengl.Matrix;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;

final class c extends Thread {
    private d irC;
    private SurfaceTexture irE;
    private EGL10 irF;
    private EGLDisplay irG = EGL10.EGL_NO_DISPLAY;
    private EGLContext irH = EGL10.EGL_NO_CONTEXT;
    private EGLSurface irI = EGL10.EGL_NO_SURFACE;
    volatile boolean irJ;

    public c(SurfaceTexture surfaceTexture, d dVar) {
        this.irE = surfaceTexture;
        this.irC = dVar;
    }

    public final void run() {
        Object obj;
        x.i("MicroMsg.MMSightRecordTextureViewRenderThread", "start render thread");
        this.irF = (EGL10) EGLContext.getEGL();
        this.irG = this.irF.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
        if (this.irG == EGL10.EGL_NO_DISPLAY) {
            x.e("MicroMsg.MMSightRecordTextureViewRenderThread", "egl get display error: %s", GLUtils.getEGLErrorString(this.irF.eglGetError()));
            obj = -1;
        } else {
            if (this.irF.eglInitialize(this.irG, new int[2])) {
                EGLConfig[] eGLConfigArr = new EGLConfig[1];
                if (this.irF.eglChooseConfig(this.irG, new int[]{12324, 4, 12323, 4, 12322, 4, 12352, 4, 12344}, eGLConfigArr, 1, new int[1])) {
                    this.irH = this.irF.eglCreateContext(this.irG, eGLConfigArr[0], EGL10.EGL_NO_CONTEXT, new int[]{12440, 2, 12344});
                    this.irI = this.irF.eglCreateWindowSurface(this.irG, eGLConfigArr[0], this.irE, null);
                    if (this.irI != EGL10.EGL_NO_SURFACE && this.irH != EGL10.EGL_NO_CONTEXT) {
                        if (!this.irF.eglMakeCurrent(this.irG, this.irI, this.irI, this.irH)) {
                            x.e("MicroMsg.MMSightRecordTextureViewRenderThread", "eglMakeCurrent failed : %s", GLUtils.getEGLErrorString(this.irF.eglGetError()));
                        }
                        obj = null;
                    } else if (this.irF.eglGetError() == 12299) {
                        x.e("MicroMsg.MMSightRecordTextureViewRenderThread", "eglCreateWindowSurface returned EGL_BAD_NATIVE_WINDOW. ");
                        obj = -1;
                    } else {
                        x.e("MicroMsg.MMSightRecordTextureViewRenderThread", "eglCreateWindowSurface failed : %s", GLUtils.getEGLErrorString(this.irF.eglGetError()));
                        obj = -1;
                    }
                } else {
                    x.e("MicroMsg.MMSightRecordTextureViewRenderThread", "egl choose config failed: %s", GLUtils.getEGLErrorString(this.irF.eglGetError()));
                    obj = -1;
                }
            } else {
                x.e("MicroMsg.MMSightRecordTextureViewRenderThread", "egl init error: %s", GLUtils.getEGLErrorString(this.irF.eglGetError()));
                obj = -1;
            }
        }
        if (obj < null) {
            x.e("MicroMsg.MMSightRecordTextureViewRenderThread", "init gl failed");
            return;
        }
        d dVar;
        if (this.irC != null) {
            dVar = this.irC;
            synchronized (d.lock) {
                x.i("MicroMsg.MMSightRecordTextureViewRenderer", "init this %s", dVar);
                GLES20.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
                GLES20.glDisable(2929);
                dVar.ire = b.aM("attribute vec4 a_position;                         \nattribute vec2 a_texCoord;                         \nvarying vec2 v_texCoord;                           \nuniform mat4 uMatrix;                              \nvoid main() {                                      \n   gl_Position = uMatrix * a_position;             \n   v_texCoord = a_texCoord;                        \n}                                                  \n", "#ifdef GL_ES                                       \nprecision highp float;                             \n#endif                                             \nvarying vec2 v_texCoord;                           \nuniform sampler2D y_texture;                       \nuniform sampler2D uv_texture;                      \nvoid main (void) {                                 \n   float r, g, b, y, u, v;                         \n   y = texture2D(y_texture, v_texCoord).r;         \n   u = texture2D(uv_texture, v_texCoord).a;        \n   v = texture2D(uv_texture, v_texCoord).r;        \n   u = u - 0.5;                                    \n   v = v - 0.5;                                    \n   r = y + 1.370705 * v;                           \n   g = y - 0.337633 * u - 0.698001 * v;            \n   b = y + 1.732446 * u;                           \n   gl_FragColor = vec4(r, g, b, 1.0);              \n}                                                  \n");
                if (dVar.ire == 0) {
                    x.e("MicroMsg.MMSightRecordTextureViewRenderer", "onSurfaceCreated, load program failed!");
                }
                dVar.irg = GLES20.glGetAttribLocation(dVar.ire, "a_position");
                dVar.irf = GLES20.glGetAttribLocation(dVar.ire, "a_texCoord");
                dVar.irh = GLES20.glGetUniformLocation(dVar.ire, "y_texture");
                dVar.iri = GLES20.glGetUniformLocation(dVar.ire, "uv_texture");
                dVar.irj = GLES20.glGetUniformLocation(dVar.ire, "uMatrix");
                dVar.irc = b.Yi();
                dVar.ird = b.Yi();
                dVar.irk = ByteBuffer.allocateDirect(dVar.iro.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
                dVar.irk.put(dVar.iro);
                dVar.irk.position(0);
                dVar.irl = ByteBuffer.allocateDirect(d.iqT.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
                dVar.irl.put(d.iqT);
                dVar.irl.position(0);
                x.i("MicroMsg.MMSightRecordTextureViewRenderer", "onSurfaceCreated, yTextureId: %s, uvTextureId: %s this %s", Integer.valueOf(dVar.irc), Integer.valueOf(dVar.ird), dVar);
            }
            x.i("MicroMsg.MMSightRecordTextureViewRenderThread", "init renderer finish");
        }
        while (this.irJ) {
            if (this.irC != null) {
                if (!this.irC.irL) {
                    try {
                        Thread.sleep(10);
                    } catch (Throwable e) {
                        x.printErrStackTrace("MicroMsg.MMSightRecordTextureViewRenderThread", e, "", new Object[0]);
                    }
                }
                d dVar2 = this.irC;
                bi.Wz();
                dVar2.iqW = true;
                GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
                GLES20.glClear(16640);
                synchronized (d.lock) {
                    if (dVar2.ire != -1 && dVar2.irc != -1 && dVar2.ird != -1 && dVar2.iqY > 0 && dVar2.iqZ > 0 && dVar2.irb != null && dVar2.ira != null && dVar2.irb.limit() > 0 && dVar2.ira.limit() > 0 && dVar2.irb.position() == 0 && dVar2.ira.position() == 0) {
                        GLES20.glUseProgram(dVar2.ire);
                        GLES20.glActiveTexture(33984);
                        GLES20.glBindTexture(3553, dVar2.irc);
                        GLES20.glTexImage2D(3553, 0, 6409, dVar2.iqY, dVar2.iqZ, 0, 6409, 5121, dVar2.ira);
                        GLES20.glTexParameterf(3553, 10241, 9729.0f);
                        GLES20.glTexParameterf(3553, 10240, 9729.0f);
                        GLES20.glTexParameterf(3553, 10242, 33071.0f);
                        GLES20.glTexParameterf(3553, 10243, 33071.0f);
                        GLES20.glUniform1i(dVar2.irh, 0);
                        GLES20.glActiveTexture(33985);
                        GLES20.glBindTexture(3553, dVar2.ird);
                        GLES20.glTexImage2D(3553, 0, 6410, dVar2.iqY / 2, dVar2.iqZ / 2, 0, 6410, 5121, dVar2.irb);
                        GLES20.glTexParameterf(3553, 10241, 9729.0f);
                        GLES20.glTexParameterf(3553, 10240, 9729.0f);
                        GLES20.glTexParameterf(3553, 10242, 33071.0f);
                        GLES20.glTexParameterf(3553, 10243, 33071.0f);
                        GLES20.glUniform1i(dVar2.iri, 1);
                        Matrix.setIdentityM(dVar2.irm, 0);
                        Matrix.setRotateM(dVar2.irm, 0, (float) dVar2.fGt, 0.0f, 0.0f, -1.0f);
                        GLES20.glUniformMatrix4fv(dVar2.irj, 1, false, dVar2.irm, 0);
                        dVar2.irk.position(0);
                        GLES20.glVertexAttribPointer(dVar2.irg, 2, 5126, false, 0, dVar2.irk);
                        GLES20.glEnableVertexAttribArray(dVar2.irg);
                        dVar2.irl.position(0);
                        GLES20.glVertexAttribPointer(dVar2.irf, 2, 5126, false, 0, dVar2.irl);
                        GLES20.glEnableVertexAttribArray(dVar2.irf);
                        GLES20.glDrawArrays(5, 0, 4);
                        GLES20.glDisableVertexAttribArray(dVar2.irg);
                        GLES20.glDisableVertexAttribArray(dVar2.irf);
                        GLES20.glBindTexture(3553, 0);
                    }
                }
                dVar2.iqW = false;
            }
            if (this.irF != null) {
                this.irF.eglSwapBuffers(this.irG, this.irI);
            }
        }
        x.i("MicroMsg.MMSightRecordTextureViewRenderThread", "finish render loop, start destroy gl");
        if (this.irC != null) {
            dVar = this.irC;
            synchronized (d.lock) {
                if (dVar.ire >= 0) {
                    GLES20.glDeleteProgram(dVar.ire);
                    dVar.ire = -1;
                }
                if (dVar.ird >= 0) {
                    GLES20.glDeleteTextures(1, new int[]{dVar.ird}, 0);
                    dVar.ird = -1;
                }
                if (dVar.irc >= 0) {
                    GLES20.glDeleteTextures(1, new int[]{dVar.irc}, 0);
                    dVar.irc = -1;
                }
                dVar.iqZ = -1;
                dVar.iqY = -1;
                dVar.irK = true;
                dVar.ira = null;
                dVar.irb = null;
            }
        }
        if (!(this.irF == null || this.irH == null || this.irI == null)) {
            this.irF.eglDestroyContext(this.irG, this.irH);
            this.irF.eglDestroySurface(this.irG, this.irI);
            this.irH = EGL10.EGL_NO_CONTEXT;
            this.irI = EGL10.EGL_NO_SURFACE;
        }
        if (this.irE != null) {
            this.irE.release();
        }
        x.i("MicroMsg.MMSightRecordTextureViewRenderThread", "finish render loop, finish destroy gl");
    }
}
