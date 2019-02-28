package com.tencent.mm.plugin.appbrand.canvas.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import com.tencent.mm.plugin.appbrand.canvas.d;
import com.tencent.mm.plugin.appbrand.canvas.widget.a.a;
import java.util.LinkedHashSet;
import java.util.Set;
import org.json.JSONArray;

public class MHardwareAccelerateDrawableView extends View implements a {
    public final d iOr = new d(this);
    private final Set<OnAttachStateChangeListener> iOs = new LinkedHashSet();

    public MHardwareAccelerateDrawableView(Context context) {
        super(context);
        setLayerType(2, null);
    }

    public MHardwareAccelerateDrawableView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setLayerType(2, null);
    }

    public MHardwareAccelerateDrawableView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setLayerType(2, null);
    }

    protected void onDraw(Canvas canvas) {
        d(canvas);
    }

    public final void abx() {
        postInvalidate();
    }

    public final void l(Runnable runnable) {
        post(runnable);
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
        return 0;
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
