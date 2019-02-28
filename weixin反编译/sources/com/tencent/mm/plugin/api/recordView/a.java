package com.tencent.mm.plugin.api.recordView;

import android.graphics.Point;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView.Renderer;
import android.opengl.Matrix;
import com.tencent.mm.plugin.mmsight.d;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

final class a implements Renderer {
    static float[] iqR = new float[]{-1.0f, -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f};
    static float[] iqS = new float[]{-1.0f, -0.5f, 1.0f, -0.5f, -1.0f, 0.5f, 1.0f, 0.5f};
    private static final float[] iqT = new float[]{0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f};
    int fGt = 0;
    private int iqU = 0;
    private int iqV = 0;
    boolean iqW = false;
    byte[] iqX = null;
    int iqY = 0;
    int iqZ = 0;
    ByteBuffer ira;
    ByteBuffer irb;
    private int irc;
    private int ird;
    private int ire;
    private int irf;
    private int irg;
    private int irh;
    private int iri;
    private int irj;
    FloatBuffer irk;
    private FloatBuffer irl;
    private float[] irm = new float[16];
    private boolean irn = false;
    float[] iro = iqR;
    boolean irp = false;

    public a() {
        Point bav = d.bav();
        float f = (((float) bav.x) / ((float) bav.y)) / 2.0f;
        iqS = new float[]{-1.0f, -f, 1.0f, -f, -1.0f, f, 1.0f, f};
    }

    public final void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
        x.i("MicroMsg.MMSightCameraGLRenderer", "onSurfaceCreated this %s", this);
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
        GLES20.glDisable(2929);
        this.ire = b.aM("attribute vec4 a_position;                         \nattribute vec2 a_texCoord;                         \nvarying vec2 v_texCoord;                           \nuniform mat4 uMatrix;                              \nvoid main() {                                      \n   gl_Position = uMatrix * a_position;             \n   v_texCoord = a_texCoord;                        \n}                                                  \n", "#ifdef GL_ES                                       \nprecision highp float;                             \n#endif                                             \nvarying vec2 v_texCoord;                           \nuniform sampler2D y_texture;                       \nuniform sampler2D uv_texture;                      \nvoid main (void) {                                 \n   float r, g, b, y, u, v;                         \n   y = texture2D(y_texture, v_texCoord).r;         \n   u = texture2D(uv_texture, v_texCoord).a;        \n   v = texture2D(uv_texture, v_texCoord).r;        \n   u = u - 0.5;                                    \n   v = v - 0.5;                                    \n   r = y + 1.370705 * v;                           \n   g = y - 0.337633 * u - 0.698001 * v;            \n   b = y + 1.732446 * u;                           \n   gl_FragColor = vec4(r, g, b, 1.0);              \n}                                                  \n");
        if (this.ire == 0) {
            x.e("MicroMsg.MMSightCameraGLRenderer", "onSurfaceCreated, load program failed!");
        }
        this.irg = GLES20.glGetAttribLocation(this.ire, "a_position");
        this.irf = GLES20.glGetAttribLocation(this.ire, "a_texCoord");
        this.irh = GLES20.glGetUniformLocation(this.ire, "y_texture");
        this.iri = GLES20.glGetUniformLocation(this.ire, "uv_texture");
        this.irj = GLES20.glGetUniformLocation(this.ire, "uMatrix");
        this.irc = b.Yi();
        this.ird = b.Yi();
        this.irk = ByteBuffer.allocateDirect(this.iro.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.irk.put(this.iro);
        this.irk.position(0);
        this.irl = ByteBuffer.allocateDirect(iqT.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.irl.put(iqT);
        this.irl.position(0);
        x.i("MicroMsg.MMSightCameraGLRenderer", "onSurfaceCreated, yTextureId: %s, uvTextureId: %s this %s", Integer.valueOf(this.irc), Integer.valueOf(this.ird), this);
    }

    public final void onSurfaceChanged(GL10 gl10, int i, int i2) {
        x.i("MicroMsg.MMSightCameraGLRenderer", "onSurfaceChanged, surfaceWidth: %s, height: %s this %s", Integer.valueOf(i), Integer.valueOf(i2), this);
        if (i != this.iqU || i2 != this.iqV) {
            x.i("MicroMsg.MMSightCameraGLRenderer", "onSurfaceChanged change viewpoint");
            GLES20.glViewport(0, 0, i, i2);
            this.iqU = i;
            this.iqV = i2;
        }
    }

    public final void onDrawFrame(GL10 gl10) {
        bi.Wz();
        this.iqW = true;
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        GLES20.glClear(16640);
        if (this.irn) {
            x.i("MicroMsg.MMSightCameraGLRenderer", "clearFrameRequest");
            this.irn = false;
            this.iqW = false;
            this.iqX = null;
            this.iqY = -1;
            this.iqZ = -1;
            return;
        }
        if (!(this.ire == 0 || this.irc == -1 || this.ird == -1 || this.iqY <= 0 || this.iqZ <= 0 || this.iqX == null)) {
            GLES20.glUseProgram(this.ire);
            GLES20.glActiveTexture(33984);
            GLES20.glBindTexture(3553, this.irc);
            GLES20.glTexImage2D(3553, 0, 6409, this.iqY, this.iqZ, 0, 6409, 5121, this.ira);
            GLES20.glTexParameterf(3553, 10241, 9729.0f);
            GLES20.glTexParameterf(3553, 10240, 9729.0f);
            GLES20.glTexParameterf(3553, 10242, 33071.0f);
            GLES20.glTexParameterf(3553, 10243, 33071.0f);
            GLES20.glUniform1i(this.irh, 0);
            GLES20.glActiveTexture(33985);
            GLES20.glBindTexture(3553, this.ird);
            GLES20.glTexImage2D(3553, 0, 6410, this.iqY / 2, this.iqZ / 2, 0, 6410, 5121, this.irb);
            GLES20.glTexParameterf(3553, 10241, 9729.0f);
            GLES20.glTexParameterf(3553, 10240, 9729.0f);
            GLES20.glTexParameterf(3553, 10242, 33071.0f);
            GLES20.glTexParameterf(3553, 10243, 33071.0f);
            GLES20.glUniform1i(this.iri, 1);
            Matrix.setIdentityM(this.irm, 0);
            Matrix.setRotateM(this.irm, 0, (float) this.fGt, 0.0f, 0.0f, -1.0f);
            GLES20.glUniformMatrix4fv(this.irj, 1, false, this.irm, 0);
            this.irk.position(0);
            GLES20.glVertexAttribPointer(this.irg, 2, 5126, false, 0, this.irk);
            GLES20.glEnableVertexAttribArray(this.irg);
            this.irl.position(0);
            GLES20.glVertexAttribPointer(this.irf, 2, 5126, false, 0, this.irl);
            GLES20.glEnableVertexAttribArray(this.irf);
            GLES20.glDrawArrays(5, 0, 4);
            GLES20.glDisableVertexAttribArray(this.irg);
            GLES20.glDisableVertexAttribArray(this.irf);
            GLES20.glBindTexture(3553, 0);
        }
        this.iqW = false;
    }
}
