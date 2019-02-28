package com.tencent.mm.plugin.appbrand.canvas.widget;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.SurfaceTexture;
import android.os.HandlerThread;
import android.util.AttributeSet;
import android.util.Log;
import android.view.TextureView;
import android.view.TextureView.SurfaceTextureListener;
import android.view.View.OnAttachStateChangeListener;
import com.tencent.mm.plugin.appbrand.canvas.d;
import com.tencent.mm.plugin.appbrand.canvas.widget.a.a;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedHashSet;
import java.util.Set;
import org.json.JSONArray;

public class MTextureView extends TextureView implements SurfaceTextureListener, a {
    public final d iOr = new d(this);
    private final Set<OnAttachStateChangeListener> iOs = new LinkedHashSet();
    private volatile ag iOu;
    private Runnable iOv = new Runnable() {
        public final void run() {
            if (MTextureView.this.isAvailable()) {
                Canvas lockCanvas = MTextureView.this.lockCanvas();
                if (lockCanvas != null) {
                    synchronized (MTextureView.this.mLock) {
                        MTextureView.this.iOx = true;
                    }
                    lockCanvas.drawColor(-1);
                    MTextureView.this.d(lockCanvas);
                    MTextureView.this.unlockCanvasAndPost(lockCanvas);
                    synchronized (MTextureView.this.mLock) {
                        MTextureView.this.iOx = false;
                        MTextureView.this.mLock.notifyAll();
                    }
                }
            }
        }
    };
    private volatile boolean iOx;
    private volatile Object mLock = new Object();

    public MTextureView(Context context) {
        super(context);
        init();
    }

    public MTextureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public MTextureView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private void init() {
        setSurfaceTextureListener(this);
        ((Activity) getContext()).getWindow().setFlags(16777216, 16777216);
        Paint paint = new Paint();
        paint.setColor(-1);
        this.iOr.iND.iNY = paint;
    }

    public final void abx() {
        if (this.iOu != null) {
            this.iOu.removeCallbacks(this.iOv);
            this.iOu.post(this.iOv);
        }
    }

    public final void l(Runnable runnable) {
        if (this.iOu != null) {
            this.iOu.post(runnable);
        }
    }

    public final boolean d(Canvas canvas) {
        return this.iOr.d(canvas);
    }

    public final void a(JSONArray jSONArray, a aVar) {
        this.iOr.a(jSONArray, aVar);
    }

    public final void b(JSONArray jSONArray, a aVar) {
        this.iOr.b(jSONArray, aVar);
    }

    public final void aby() {
        this.iOr.aby();
    }

    public final void qz(String str) {
        this.iOr.qz(str);
    }

    public final int getType() {
        return 1;
    }

    public void addOnAttachStateChangeListener(OnAttachStateChangeListener onAttachStateChangeListener) {
        if (!this.iOs.contains(onAttachStateChangeListener)) {
            this.iOs.add(onAttachStateChangeListener);
            super.addOnAttachStateChangeListener(onAttachStateChangeListener);
        }
    }

    public void removeOnAttachStateChangeListener(OnAttachStateChangeListener onAttachStateChangeListener) {
        this.iOs.remove(onAttachStateChangeListener);
        super.removeOnAttachStateChangeListener(onAttachStateChangeListener);
    }

    public final void onPause() {
        this.iOr.onPause();
    }

    public final void onResume() {
        this.iOr.onResume();
    }

    public final boolean isPaused() {
        return this.iOr.iNH;
    }

    public final void qA(String str) {
        this.iOr.iNG = str;
    }

    public final int abz() {
        return 682;
    }

    public final int abA() {
        return 683;
    }

    public final void setStartTime(long j) {
        this.iOr.iNK = j;
    }

    public final void abB() {
        this.iOr.abB();
    }

    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        x.v("MicroMsg.MTextureView", "onSurfaceTextureAvailable");
        if (this.iOu == null) {
            HandlerThread dc = e.dc("MTextureView#Rending-Thread", -19);
            dc.start();
            this.iOu = new ag(dc.getLooper());
        }
        Canvas lockCanvas = lockCanvas();
        if (lockCanvas != null) {
            lockCanvas.drawColor(-1);
            unlockCanvasAndPost(lockCanvas);
        }
    }

    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        x.v("MicroMsg.MTextureView", "onSurfaceTextureSizeChanged");
    }

    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        x.v("MicroMsg.MTextureView", "onSurfaceTextureDestroyed");
        this.iOu.removeCallbacks(this.iOv);
        this.iOu.getLooper().quit();
        synchronized (this.mLock) {
            if (this.iOx) {
                try {
                    this.mLock.wait(1000);
                } catch (Throwable e) {
                    x.e("MicroMsg.MTextureView", "await error : %s", Log.getStackTraceString(e));
                }
            }
        }
        this.iOu = null;
        return true;
    }

    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }
}
