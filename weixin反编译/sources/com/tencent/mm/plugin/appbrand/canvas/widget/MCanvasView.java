package com.tencent.mm.plugin.appbrand.canvas.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import com.tencent.mm.plugin.appbrand.canvas.d;
import com.tencent.mm.plugin.appbrand.canvas.h;
import com.tencent.mm.plugin.appbrand.canvas.widget.a.a;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedHashSet;
import java.util.Set;
import org.json.JSONArray;

public class MCanvasView extends View implements a {
    public final d iOr = new d(this);
    private final Set<OnAttachStateChangeListener> iOs = new LinkedHashSet();
    private Bitmap mBitmap;

    public MCanvasView(Context context) {
        super(context);
    }

    public MCanvasView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public MCanvasView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    protected void onDraw(Canvas canvas) {
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        if (measuredWidth > 0 && measuredHeight > 0) {
            if (this.mBitmap == null || this.mBitmap.isRecycled() || this.mBitmap.getWidth() != measuredWidth || this.mBitmap.getHeight() != measuredHeight) {
                if (!(this.mBitmap == null || this.mBitmap.isRecycled())) {
                    this.mBitmap.recycle();
                }
                this.mBitmap = Bitmap.createBitmap(measuredWidth, measuredHeight, Config.ARGB_8888);
                x.v("MicroMsg.MCanvasView", "create a new bitmap(id : %s, w : %s, h : %s)", Integer.valueOf(hashCode()), Integer.valueOf(measuredWidth), Integer.valueOf(measuredHeight));
            }
            if (this.mBitmap == null) {
                x.d("MicroMsg.MCanvasView", "bitmap is null.");
                return;
            }
            this.mBitmap.eraseColor(0);
            Canvas hVar = new h(this.mBitmap);
            d(hVar);
            canvas.drawBitmap(hVar.mBitmap, 0.0f, 0.0f, null);
        }
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (!(this.mBitmap == null || this.mBitmap.isRecycled())) {
            this.mBitmap.recycle();
        }
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        if (measuredWidth > 0 && measuredHeight > 0) {
            this.mBitmap = Bitmap.createBitmap(measuredWidth, measuredHeight, Config.ARGB_8888);
            x.v("MicroMsg.MCanvasView", "onSizeChanged, create a new bitmap(id : %s, w : %s, h : %s)", Integer.valueOf(hashCode()), Integer.valueOf(measuredWidth), Integer.valueOf(measuredHeight));
        }
    }

    public final boolean d(Canvas canvas) {
        return this.iOr.d(canvas);
    }

    public final void abx() {
        postInvalidate();
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
        return 3;
    }

    public final void l(Runnable runnable) {
        post(runnable);
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
        return 685;
    }

    public final int abA() {
        return 684;
    }

    public final void setStartTime(long j) {
        this.iOr.iNK = j;
    }

    public final void abB() {
        this.iOr.abB();
    }
}
