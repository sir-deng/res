package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b;

import android.app.Activity;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;

public final class a {
    LayoutParams rtA = ((LayoutParams) this.rty.getLayoutParams());
    View rty;
    int rtz;

    public a(Activity activity) {
        this.rty = ((FrameLayout) activity.findViewById(16908290)).getChildAt(0);
        this.rty.getViewTreeObserver().addOnGlobalLayoutListener(new OnGlobalLayoutListener() {
            public final void onGlobalLayout() {
                a aVar = a.this;
                Rect rect = new Rect();
                aVar.rty.getWindowVisibleDisplayFrame(rect);
                int i = rect.bottom - rect.top;
                if (i != aVar.rtz) {
                    int height = aVar.rty.getRootView().getHeight();
                    int i2 = height - i;
                    if (i2 > height / 4) {
                        aVar.rtA.height = height - i2;
                    } else {
                        aVar.rtA.height = height;
                    }
                    aVar.rty.requestLayout();
                    aVar.rtz = i;
                }
            }
        });
    }
}
