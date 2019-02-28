package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.LinearLayout;
import com.tencent.mm.plugin.sns.i.e;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;

public class MaskLinearLayout extends LinearLayout {
    boolean frK = false;
    private List<MaskImageView> list = new LinkedList();
    private ag rxb = new ag();
    private Runnable rxc = new Runnable() {
        public final void run() {
            MaskLinearLayout.this.setPressed(false);
            MaskLinearLayout.a(MaskLinearLayout.this);
            MaskLinearLayout.this.invalidate();
        }
    };

    static /* synthetic */ void a(MaskLinearLayout maskLinearLayout) {
        if (maskLinearLayout.isPressed()) {
            maskLinearLayout.setBackgroundResource(e.qFS);
        } else {
            maskLinearLayout.setBackgroundResource(0);
        }
    }

    public MaskLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        super.setOnTouchListener(new OnTouchListener() {
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                x.e("test", "touch: " + motionEvent.getAction());
                if (MaskLinearLayout.this.frK) {
                    switch (motionEvent.getAction()) {
                        case 0:
                            view.setPressed(true);
                            MaskLinearLayout.a(MaskLinearLayout.this);
                            view.invalidate();
                            MaskLinearLayout.this.rxb.removeCallbacks(MaskLinearLayout.this.rxc);
                            break;
                        case 1:
                        case 3:
                            MaskLinearLayout.this.rxb.post(MaskLinearLayout.this.rxc);
                            break;
                    }
                    if (MaskLinearLayout.this.list != null) {
                        for (MaskImageView maskImageView : MaskLinearLayout.this.list) {
                            maskImageView.c(maskImageView, motionEvent);
                        }
                    }
                }
                return false;
            }
        });
    }

    public final void b(MaskImageView maskImageView) {
        this.list.add(maskImageView);
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Deprecated
    public void setOnTouchListener(OnTouchListener onTouchListener) {
        Assert.assertTrue(false);
    }
}
