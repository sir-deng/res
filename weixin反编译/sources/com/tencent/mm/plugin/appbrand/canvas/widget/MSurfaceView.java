package com.tencent.mm.plugin.appbrand.canvas.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.os.HandlerThread;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import android.view.View.OnAttachStateChangeListener;
import com.tencent.mm.plugin.appbrand.canvas.d;
import com.tencent.mm.plugin.appbrand.canvas.widget.a.a;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedHashSet;
import java.util.Set;
import org.json.JSONArray;

public class MSurfaceView extends SurfaceView implements Callback, a {
    public final d iOr = new d(this);
    private final Set<OnAttachStateChangeListener> iOs = new LinkedHashSet();
    private SurfaceHolder iOt;
    private ag iOu;
    private Runnable iOv = new Runnable() {
        public final void run() {
            if (!MSurfaceView.this.qG) {
                Canvas lockCanvas = MSurfaceView.this.iOt.lockCanvas();
                if (lockCanvas != null) {
                    lockCanvas.drawColor(-1);
                    MSurfaceView.this.d(lockCanvas);
                    MSurfaceView.this.iOt.unlockCanvasAndPost(lockCanvas);
                }
            }
        }
    };
    private volatile boolean qG;

    public MSurfaceView(Context context) {
        super(context);
        init();
    }

    public MSurfaceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public MSurfaceView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private void init() {
        this.iOt = getHolder();
        this.iOt.addCallback(this);
        this.iOt.setFormat(-3);
        Paint paint = new Paint();
        paint.setColor(-1);
        this.iOr.iND.iNY = paint;
    }

    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        x.i("MicroMsg.MSurfaceView", "surfaceCreated(%s)", Integer.valueOf(hashCode()));
        this.qG = false;
        if (this.iOu == null) {
            HandlerThread dc = e.dc("MSurfaceView#Rending-Thread", -19);
            dc.start();
            this.iOu = new ag(dc.getLooper());
        }
    }

    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        x.i("MicroMsg.MSurfaceView", "surfaceChanged(%s)", Integer.valueOf(hashCode()));
    }

    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        x.i("MicroMsg.MSurfaceView", "surfaceDestroyed(%s)", Integer.valueOf(hashCode()));
        this.qG = true;
        this.iOu.getLooper().quit();
        this.iOu = null;
    }

    public void draw(Canvas canvas) {
        x.i("MicroMsg.MSurfaceView", "draw(%s)", Integer.valueOf(hashCode()));
        canvas.drawColor(0, Mode.CLEAR);
        super.draw(canvas);
    }

    public final void abx() {
        l(new Runnable() {
            public final void run() {
                if (!MSurfaceView.this.qG) {
                    Canvas lockCanvas = MSurfaceView.this.iOt.lockCanvas();
                    if (lockCanvas != null) {
                        lockCanvas.drawColor(-1);
                        MSurfaceView.this.d(lockCanvas);
                        MSurfaceView.this.iOt.unlockCanvasAndPost(lockCanvas);
                    }
                }
            }
        });
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
        return 2;
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
        return 667;
    }

    public final int abA() {
        return 668;
    }

    public final void setStartTime(long j) {
        this.iOr.iNK = j;
    }

    public final void abB() {
        this.iOr.abB();
    }
}
