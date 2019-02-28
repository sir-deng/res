package com.tencent.mm.plugin.appbrand.jsapi.coverview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ScrollView;
import com.tencent.mm.plugin.appbrand.jsapi.m.e;

public class WxaScrollView extends FrameLayout implements n, o, e {
    private float fF;
    FrameLayout jmD;
    private ScrollView jmE;
    l jmF;
    private float jmu;
    private int jmv;
    private int jmw;
    private Paint jmx = new Paint();

    public WxaScrollView(Context context) {
        super(context);
        init();
    }

    public WxaScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public WxaScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private void init() {
        this.jmE = new ScrollView(getContext()) {
            protected final void onScrollChanged(int i, int i2, int i3, int i4) {
                super.onScrollChanged(i, i2, i3, i4);
                if (WxaScrollView.this.jmF != null) {
                    WxaScrollView.this.jmF.h(WxaScrollView.this, i, i2);
                }
            }
        };
        this.jmD = new FrameLayout(getContext());
        super.addView(this.jmE, 0, new LayoutParams(-1, -1));
        this.jmE.addView(this.jmD, 0, new LayoutParams(-1, -2));
        this.jmx.setStyle(Style.STROKE);
        this.jmx.setAntiAlias(true);
        setWillNotDraw(false);
    }

    public void draw(Canvas canvas) {
        Object obj;
        float f = 0.0f;
        Object obj2 = this.jmu > 0.0f ? 1 : null;
        if (obj2 != null) {
            canvas.save();
            Path path = new Path();
            path.addRoundRect(new RectF(0.0f, 0.0f, (float) getWidth(), (float) getHeight()), this.jmu, this.jmu, Direction.CW);
            canvas.clipPath(path);
        }
        if (this.jmw != 0) {
            canvas.drawColor(this.jmw);
        }
        if (this.fF > 0.0f) {
            float f2 = this.fF / 2.0f;
            canvas.drawRoundRect(new RectF(f2, f2, ((float) getWidth()) - f2, ((float) getHeight()) - f2), this.jmu, this.jmu, this.jmx);
            if (obj2 != null) {
                canvas.restore();
            }
            canvas.save();
            Path path2 = new Path();
            if (this.jmu > 0.0f && this.jmu - this.fF > 0.0f) {
                f = this.jmu - this.fF;
            }
            path2.addRoundRect(new RectF(this.fF, this.fF, ((float) getWidth()) - this.fF, ((float) getHeight()) - this.fF), f, f, Direction.CW);
            canvas.clipPath(path2);
            obj = 1;
        } else {
            obj = obj2;
        }
        int save = canvas.save();
        super.draw(canvas);
        canvas.restoreToCount(save);
        if (obj != null) {
            canvas.restore();
        }
    }

    public final int agy() {
        return this.jmD.getChildCount();
    }

    public void addView(View view, int i) {
        this.jmD.addView(view, i);
    }

    public void addView(View view, int i, LayoutParams layoutParams) {
        this.jmD.addView(view, i, layoutParams);
    }

    public void removeView(View view) {
        this.jmD.removeView(view);
    }

    public final void V(float f) {
        this.jmu = f;
    }

    public final void ky(int i) {
        this.jmv = i;
        this.jmx.setColor(i);
    }

    public final void W(float f) {
        this.fF = f;
        this.jmx.setStrokeWidth(f);
    }

    public final void kz(int i) {
        this.jmw = i;
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getActionMasked() == 0) {
            boolean z;
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            if (this.jmu > 0.0f) {
                double pow = Math.pow((double) this.jmu, 2.0d);
                float width = (float) getWidth();
                float height = (float) getHeight();
                if (x < this.jmu) {
                    if (y < this.jmu) {
                        if (Math.pow((double) (this.jmu - y), 2.0d) + Math.pow((double) (this.jmu - x), 2.0d) > pow) {
                            z = false;
                            if (!z) {
                                return false;
                            }
                        }
                    } else if (y > height - this.jmu) {
                        if (Math.pow((double) ((this.jmu + y) - height), 2.0d) + Math.pow((double) (this.jmu - x), 2.0d) > pow) {
                            z = false;
                            if (z) {
                                return false;
                            }
                        }
                    }
                } else if (x > width - this.jmu) {
                    if (y < this.jmu) {
                        if (Math.pow((double) (this.jmu - y), 2.0d) + Math.pow((double) ((x + this.jmu) - width), 2.0d) > pow) {
                            z = false;
                            if (z) {
                                return false;
                            }
                        }
                    } else if (y > height - this.jmu) {
                        if (Math.pow((double) ((this.jmu + y) - height), 2.0d) + Math.pow((double) ((x + this.jmu) - width), 2.0d) > pow) {
                            z = false;
                            if (z) {
                                return false;
                            }
                        }
                    }
                }
            }
            z = true;
            if (z) {
                return false;
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }
}
