package com.tencent.mm.plugin.voip.video;

import android.app.ActivityManager;
import android.graphics.Bitmap;
import android.opengl.GLSurfaceView.Renderer;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Looper;
import android.os.Message;
import com.tencent.mm.compatible.util.k;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.ref.WeakReference;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public final class OpenGlRender implements Renderer {
    static String TAG = "OpenGlRender";
    public static int sAB = 0;
    static boolean sAD = false;
    public static int sAe = 0;
    public static int sAf = 1;
    public static int sAg = 2;
    public static int sAh = 0;
    public static int sAi = 1;
    public static int sAj = 0;
    public static int sAk = 1;
    public static int sAl = 2;
    public static int sAm = 3;
    public static int sAn = 4;
    public static int sAo = 12;
    public static int sAp = 16;
    public static int sAq = 0;
    public static int sAr = 1;
    int mRenderMode = sAq;
    private int sAA;
    WeakReference<Object> sAC;
    boolean sAa = false;
    int sAb = 0;
    int sAc = 0;
    WeakReference<OpenGlView> sAd;
    public boolean sAs = false;
    public Bitmap sAt = null;
    private int sAu = 0;
    private int sAv = 0;
    private byte[] sAw = null;
    private int[] sAx = null;
    private int sAy;
    private int sAz;
    boolean szN = false;
    int szO = 0;
    long szP = 0;
    long szQ = 0;
    int szR = 0;
    a szS;
    public float szT = 1.2f;
    public float szU = 1.93f;
    public float szV = 1.05f;
    boolean szW = false;
    public boolean szX = false;
    boolean szY = false;
    boolean szZ = false;

    private class a extends ag {
        public a(Looper looper) {
            super(looper);
        }

        public final void handleMessage(Message message) {
            OpenGlRender.this.requestRender();
        }
    }

    private native void render32(int[] iArr, int i, int i2, int i3, int i4);

    private native void render8(byte[] bArr, int i, int i2, int i3, int i4);

    final native void Init(int i, Object obj, int i2);

    final native void Uninit(int i);

    final native void setMode(int i, int i2, int i3, int i4);

    final native void setParam(float f, float f2, float f3, int i);

    public static int bJn() {
        if (sAB == 0) {
            sAB = ((ActivityManager) ad.getContext().getSystemService("activity")).getDeviceConfigurationInfo().reqGlEsVersion == WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT ? 2 : 1;
            if (Build.MODEL.equals("Nexus 6")) {
                sAB = 2;
            }
        }
        return sAB;
    }

    public OpenGlRender(OpenGlView openGlView, int i) {
        if (!sAD) {
            k.b("mm_gl_disp", OpenGlRender.class.getClassLoader());
            sAD = true;
        }
        this.mRenderMode = i;
        this.sAd = new WeakReference(openGlView);
        Looper myLooper = Looper.myLooper();
        if (myLooper != null) {
            this.szS = new a(myLooper);
        } else {
            myLooper = Looper.getMainLooper();
            if (myLooper != null) {
                this.szS = new a(myLooper);
            } else {
                this.szS = null;
            }
        }
        this.sAC = null;
    }

    public final void onDrawFrame(GL10 gl10) {
        if (this.szX && this.szW && this.sAd.get() != null) {
            if (this.sAw != null) {
                render8(this.sAw, this.sAy, this.sAz, this.sAA, this.mRenderMode);
                this.sAw = null;
            }
            if (this.sAx != null) {
                render32(this.sAx, this.sAy, this.sAz, this.sAA, this.mRenderMode);
                this.sAx = null;
                return;
            }
            return;
        }
        this.sAw = null;
        this.sAx = null;
    }

    public final void c(byte[] bArr, int i, int i2, int i3) {
        if (this.szW && this.sAw == null) {
            this.sAy = i;
            this.sAz = i2;
            this.sAA = i3;
            this.sAw = bArr;
            requestRender();
        }
    }

    public final void a(int[] iArr, int i, int i2, int i3) {
        if (this.szW && this.sAx == null) {
            this.sAy = i;
            this.sAz = i2;
            this.sAA = i3;
            this.sAx = iArr;
            requestRender();
        }
    }

    public final void onSurfaceChanged(GL10 gl10, int i, int i2) {
        x.i(TAG, "onSurfaceChanged, width: %s, height: %s", Integer.valueOf(i), Integer.valueOf(i2));
        if (this.sAb != i || this.sAc != i2) {
            gl10.glViewport(0, 0, i, i2);
            this.sAb = i;
            this.sAc = i2;
            if (VERSION.SDK_INT >= 23) {
                setMode(this.sAb, this.sAc, 1, this.mRenderMode);
            }
        }
    }

    public final void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
    }

    public final void bJo() {
        this.szX = false;
        this.sAa = false;
    }

    public final void bJp() {
        x.i(TAG, "steve: try to reset GLRender mode=%d, inited:%b, started:%b", Integer.valueOf(this.mRenderMode), Boolean.valueOf(this.szW), Boolean.valueOf(this.szX));
        if (this.szW && this.szX) {
            x.i(TAG, "steve: Reset GLRender first! mode=%d", Integer.valueOf(this.mRenderMode));
            this.szW = false;
            this.szX = false;
            Uninit(this.mRenderMode);
        }
    }

    public final void requestRender() {
        if (this.szW) {
            if (!this.sAa) {
                setMode(((OpenGlView) this.sAd.get()).getWidth(), ((OpenGlView) this.sAd.get()).getHeight(), 0, this.mRenderMode);
                this.sAa = true;
            }
            if (this.sAd.get() != null) {
                OpenGlView openGlView = (OpenGlView) this.sAd.get();
                openGlView.sAF = true;
                openGlView.requestRender();
            }
        }
    }
}
