package com.tencent.mm.plugin.appbrand.game.page;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.tencent.mm.sdk.platformtools.x;

public class WAGamePageViewContainerLayout extends FrameLayout {
    private b jdn;
    a jdo;

    interface a {
        void a(b bVar, b bVar2);
    }

    public enum b {
        UNDEFINED,
        PORTRAIT,
        LANDSCAPE,
        PORTRAIT_REVERSE,
        LANDSCAPE_REVERSE
    }

    public WAGamePageViewContainerLayout(Context context) {
        this(context, null);
    }

    public WAGamePageViewContainerLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public WAGamePageViewContainerLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jdn = null;
        this.jdo = null;
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (getContext() instanceof Activity) {
            b bVar;
            switch (((Activity) getContext()).getWindowManager().getDefaultDisplay().getRotation()) {
                case 0:
                    bVar = b.PORTRAIT;
                    break;
                case 1:
                    bVar = b.LANDSCAPE;
                    break;
                case 2:
                    bVar = b.PORTRAIT_REVERSE;
                    break;
                case 3:
                    bVar = b.LANDSCAPE_REVERSE;
                    break;
                default:
                    x.e("MicroMsg.WAContainerView", "hy: invalid rotate: %d!", Integer.valueOf(((Activity) getContext()).getWindowManager().getDefaultDisplay().getRotation()));
                    bVar = b.UNDEFINED;
                    break;
            }
            if (this.jdo != null) {
                this.jdo.a(this.jdn, bVar);
            }
            this.jdn = bVar;
        }
    }
}
