package com.tencent.mm.ui.tools;

import android.content.Context;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.x;

public final class k implements OnGestureListener {
    private final Context context;
    private final int wO;
    private final int wP;
    public final GestureDetector zub = new GestureDetector(this.context, this);
    public a zuc;
    private final float zud;
    private final float zue;

    public interface a {
    }

    public k(Context context) {
        this.context = context;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.wO = viewConfiguration.getScaledMinimumFlingVelocity();
        this.wP = viewConfiguration.getScaledMaximumFlingVelocity();
        this.zud = (float) b.b(context, 70.0f);
        this.zue = (float) b.b(context, 50.0f);
    }

    public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        if (this.zuc == null) {
            return true;
        }
        x.v("MicroMsg.MMGestureDetector", "lastX:%f, curX:%f, lastY:%f, curY:%f, vX:%f, vY:%f", Float.valueOf(motionEvent.getX()), Float.valueOf(motionEvent2.getX()), Float.valueOf(motionEvent.getY()), Float.valueOf(motionEvent2.getY()), Float.valueOf(f), Float.valueOf(f2));
        float abs = Math.abs(motionEvent2.getY() - motionEvent.getY());
        float abs2 = Math.abs(motionEvent2.getX() - motionEvent.getX());
        if (abs < this.zue && f > 800.0f && abs2 > this.zud) {
            return true;
        }
        if (abs < this.zue && f < -800.0f && abs2 < (-this.zud)) {
            return true;
        }
        if (abs2 < this.zue && f2 > 800.0f) {
            return true;
        }
        if (abs2 >= this.zue || f2 >= -800.0f) {
            return false;
        }
        return true;
    }

    public final boolean onDown(MotionEvent motionEvent) {
        return false;
    }

    public final void onShowPress(MotionEvent motionEvent) {
    }

    public final boolean onSingleTapUp(MotionEvent motionEvent) {
        return false;
    }

    public final boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        return false;
    }

    public final void onLongPress(MotionEvent motionEvent) {
    }
}
