package com.tencent.mm.plugin.multitalk.ui.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.SurfaceTexture;
import android.util.AttributeSet;
import android.view.TextureView.SurfaceTextureListener;
import com.tencent.mm.plugin.multitalk.a.o;
import com.tencent.mm.plugin.voip.video.OpenGlRender;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.MMTextureView;
import com.tencent.smtt.sdk.WebView;

public class MultiTalkVideoView extends MMTextureView implements SurfaceTextureListener {
    private static final int[] oOI = new int[]{452984831, 369098751, 268435455, 369098751, 268435455, 184549375, 268435455, 184549375, 100663295};
    private SurfaceTexture aDa;
    int index;
    private int iqU;
    private int iqV;
    private Paint oOJ;
    private a oOK = a.None;
    public int position;
    public String username;

    public enum a {
        Avatar,
        Video,
        None
    }

    public MultiTalkVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initView();
    }

    public MultiTalkVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initView();
    }

    private void initView() {
        this.oOJ = new Paint();
        this.oOJ.setColor(WebView.NIGHT_MODE_COLOR);
        this.oOJ.setFilterBitmap(false);
        this.oOJ.setTextSize(40.0f);
        setSurfaceTextureListener(this);
    }

    public final synchronized void a(int[] iArr, int i, int i2, int i3, int i4) {
        if (bdQ()) {
            o.bdC().a(this, iArr, i, i2, i3, i4);
        }
    }

    public final synchronized void b(Bitmap bitmap, int i, int i2) {
        if (bitmap != null) {
            if (!bitmap.isRecycled()) {
                int width = bitmap.getWidth();
                int height = bitmap.getHeight();
                if (!(this.aDa == null || this.iqU == 0 || this.iqV == 0)) {
                    Canvas lockCanvas = lockCanvas(null);
                    if (lockCanvas == null) {
                        x.e("MicroMsg.MT.MultiTalkVideoView", "%s getCanvasError", this.username);
                    } else {
                        Matrix matrix = new Matrix();
                        if (i == OpenGlRender.sAo) {
                            matrix.setRotate(270.0f, (float) (width / 2), (float) (height / 2));
                        } else if (i == OpenGlRender.sAn) {
                            matrix.setRotate(90.0f, (float) (width / 2), (float) (height / 2));
                        }
                        if (i2 == OpenGlRender.sAp) {
                            matrix.postScale(-1.0f, 1.0f);
                            matrix.postTranslate((float) width, 0.0f);
                        }
                        matrix.postScale(((float) lockCanvas.getWidth()) / ((float) height), ((float) lockCanvas.getHeight()) / ((float) width));
                        lockCanvas.drawColor(0, Mode.CLEAR);
                        if (!bitmap.isRecycled()) {
                            lockCanvas.drawBitmap(bitmap, matrix, this.oOJ);
                        }
                        try {
                            unlockCanvasAndPost(lockCanvas);
                        } catch (Throwable e) {
                            x.printErrStackTrace("MicroMsg.MT.MultiTalkVideoView", e, "drawBitmap unlockCanvasAndPost crash", new Object[0]);
                        }
                    }
                }
            }
        }
        x.e("MicroMsg.MT.MultiTalkVideoView", "DrawBitmap, bitmap is null or recycled");
    }

    public final void bdK() {
        if (bdP()) {
            o.bdC().a(this, true);
        }
    }

    public final void bdL() {
        if (!bi.oN(this.username)) {
            x.i("MicroMsg.MT.MultiTalkVideoView", "changeToAvatar %s from %s", this.username, this.oOK.name());
            this.oOK = a.Avatar;
            bdK();
        }
    }

    public final void bdM() {
        x.i("MicroMsg.MT.MultiTalkVideoView", "changeToVideo %s from %s", this.username, this.oOK.name());
        this.oOK = a.Video;
    }

    public final void bdN() {
        x.i("MicroMsg.MT.MultiTalkVideoView", "changeToNone %s from %s", this.username, this.oOK.name());
        this.oOK = a.None;
        this.username = null;
        bdO();
    }

    private void bdO() {
        if (this.aDa != null && this.iqU != 0 && this.iqV != 0) {
            Canvas lockCanvas = lockCanvas(null);
            if (lockCanvas == null) {
                x.e("MicroMsg.MT.MultiTalkVideoView", "getCanvasError canvas is null");
                return;
            }
            lockCanvas.drawColor(0, Mode.CLEAR);
            lockCanvas.drawColor(-14737113);
            lockCanvas.drawColor(oOI[this.index]);
            try {
                unlockCanvasAndPost(lockCanvas);
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.MT.MultiTalkVideoView", e, "drawNone unlockCanvasAndPost crash", new Object[0]);
            }
        }
    }

    public final void Go(String str) {
        x.i("MicroMsg.MT.MultiTalkVideoView", "changeUser from %s to %s", this.username, str);
        this.username = str;
    }

    public final void amN() {
        if (bdP()) {
            o.bdC().a(this, false);
        } else if (bdQ()) {
            a aVar = (a) o.bdC().oMS.get(this.username);
            Bitmap bitmap = aVar != null ? aVar.oMV : null;
            if (bitmap != null) {
                b(bitmap, aVar.angle, aVar.oMD);
            }
        } else {
            bdO();
        }
    }

    private boolean bdP() {
        return this.oOK == a.Avatar;
    }

    public final boolean bdQ() {
        return this.oOK == a.Video;
    }

    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        boolean z = false;
        String str = "MicroMsg.MT.MultiTalkVideoView";
        String str2 = "onSurfaceTextureAvailable %s %b %d %d";
        Object[] objArr = new Object[4];
        objArr[0] = this.username;
        if (surfaceTexture != null) {
            z = true;
        }
        objArr[1] = Boolean.valueOf(z);
        objArr[2] = Integer.valueOf(i);
        objArr[3] = Integer.valueOf(i2);
        x.i(str, str2, objArr);
        this.aDa = surfaceTexture;
        this.iqU = i;
        this.iqV = i2;
        cqy();
        e.post(new Runnable() {
            public final void run() {
                MultiTalkVideoView.this.amN();
            }
        }, "onSurfaceTextureAvailable_refreshView");
    }

    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        boolean z = false;
        String str = "MicroMsg.MT.MultiTalkVideoView";
        String str2 = "onSurfaceTextureSizeChanged %s %b %d %d";
        Object[] objArr = new Object[4];
        objArr[0] = this.username;
        if (surfaceTexture != null) {
            z = true;
        }
        objArr[1] = Boolean.valueOf(z);
        objArr[2] = Integer.valueOf(i);
        objArr[3] = Integer.valueOf(i2);
        x.i(str, str2, objArr);
        this.iqU = i;
        this.iqV = i2;
        e.post(new Runnable() {
            public final void run() {
                MultiTalkVideoView.this.amN();
            }
        }, "onSurfaceTextureSizeChanged_refreshView");
    }

    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        boolean z;
        String str = "MicroMsg.MT.MultiTalkVideoView";
        String str2 = "onSurfaceTextureDestroyed %s %b";
        Object[] objArr = new Object[2];
        objArr[0] = this.username;
        if (surfaceTexture != null) {
            z = true;
        } else {
            z = false;
        }
        objArr[1] = Boolean.valueOf(z);
        x.i(str, str2, objArr);
        this.aDa = null;
        this.iqV = 0;
        this.iqU = 0;
        return false;
    }

    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        boolean z = false;
        String str = "MicroMsg.MT.MultiTalkVideoView";
        String str2 = "onSurfaceTextureUpdated %s %b";
        Object[] objArr = new Object[2];
        objArr[0] = this.username;
        if (surfaceTexture != null) {
            z = true;
        }
        objArr[1] = Boolean.valueOf(z);
        x.v(str, str2, objArr);
    }
}
