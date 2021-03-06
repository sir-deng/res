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
import com.tencent.mm.plugin.appbrand.jsapi.container.AppBrandNativeContainerView;
import com.tencent.mm.plugin.appbrand.jsapi.m.e;

public class CoverViewContainer extends AppBrandNativeContainerView implements e {
    private View Vy;
    private float fF;
    private float jmu;
    private int jmv;
    private int jmw;
    private Paint jmx = new Paint();

    public CoverViewContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public CoverViewContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    public CoverViewContainer(Context context, View view) {
        super(context);
        this.Vy = view;
        super.addView(view, 0, new LayoutParams(-1, -1));
        init();
    }

    private void init() {
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
        super.draw(canvas);
        if (obj != null) {
            canvas.restore();
        }
    }

    public final <T extends View> T w(Class<T> cls) {
        try {
            if (cls.isAssignableFrom(this.Vy.getClass())) {
                return this.Vy;
            }
        } catch (Exception e) {
        }
        return null;
    }

    public void addView(View view, int i) {
        if (i < 0) {
            i = 0;
        } else if (i > getChildCount() - 1) {
            i = getChildCount() - 1;
        }
        super.addView(view, i + 1);
    }

    public void addView(View view, int i, LayoutParams layoutParams) {
        if (i < 0) {
            i = 0;
        } else if (i > getChildCount() - 1) {
            i = getChildCount() - 1;
        }
        super.addView(view, i + 1, layoutParams);
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
