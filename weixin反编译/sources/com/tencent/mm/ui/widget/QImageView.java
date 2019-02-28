package com.tencent.mm.ui.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Matrix.ScaleToFit;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.PictureDrawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.RemoteViews.RemoteView;
import com.tencent.mm.sdk.platformtools.x;

@RemoteView
public class QImageView extends View {
    private static final a[] zFd = new a[]{a.MATRIX, a.FIT_XY, a.FIT_START, a.FIT_CENTER, a.FIT_END, a.CENTER, a.CENTER_CROP, a.CENTER_INSIDE};
    private static final ScaleToFit[] zFe = new ScaleToFit[]{ScaleToFit.FILL, ScaleToFit.START, ScaleToFit.CENTER, ScaleToFit.END};
    private int Dd;
    private boolean RQ;
    private Uri aMK;
    private int iX;
    private Context mContext;
    public Drawable mDrawable;
    public Matrix mMatrix;
    private ColorFilter mr;
    private int vxz;
    private int zEO;
    private a zEP;
    private boolean zEQ;
    private boolean zER;
    private int zES;
    private boolean zET;
    private int[] zEU;
    private boolean zEV;
    private int zEW;
    private int zEX;
    private int zEY;
    private Matrix zEZ;
    private final RectF zFa;
    private final RectF zFb;
    private boolean zFc;

    public enum a {
        MATRIX(0),
        FIT_XY(1),
        FIT_START(2),
        FIT_CENTER(3),
        FIT_END(4),
        CENTER(5),
        CENTER_CROP(6),
        CENTER_INSIDE(7);
        
        final int zFn;

        private a(int i) {
            this.zFn = i;
        }
    }

    public QImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        this.mContext = context;
        czQ();
    }

    public QImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.zEO = 0;
        this.zEQ = false;
        this.zER = false;
        this.iX = Integer.MAX_VALUE;
        this.vxz = Integer.MAX_VALUE;
        this.Dd = 255;
        this.zES = 256;
        this.zET = false;
        this.mDrawable = null;
        this.zEU = null;
        this.zEV = false;
        this.zEW = 0;
        this.zEZ = null;
        this.zFa = new RectF();
        this.zFb = new RectF();
        this.RQ = false;
        this.mContext = context;
        czQ();
        this.RQ = false;
        this.zER = false;
        this.iX = Integer.MAX_VALUE;
        this.vxz = Integer.MAX_VALUE;
        this.zFc = false;
    }

    private void czQ() {
        this.mMatrix = new Matrix();
        this.zEP = a.FIT_CENTER;
    }

    protected boolean verifyDrawable(Drawable drawable) {
        return this.mDrawable == drawable || super.verifyDrawable(drawable);
    }

    public void invalidateDrawable(Drawable drawable) {
        if (drawable == this.mDrawable) {
            invalidate();
        } else {
            super.invalidateDrawable(drawable);
        }
    }

    protected boolean onSetAlpha(int i) {
        if (getBackground() != null) {
            return false;
        }
        int i2 = (i >> 7) + i;
        if (this.zES == i2) {
            return true;
        }
        this.zES = i2;
        this.zET = true;
        czT();
        return true;
    }

    public final void setImageResource(int i) {
        if (this.aMK != null || this.zEO != i) {
            x(null);
            this.zEO = i;
            this.aMK = null;
            czR();
            invalidate();
        }
    }

    @TargetApi(11)
    public void setLayerType(int i, Paint paint) {
        if (!(this.mDrawable instanceof PictureDrawable) || i == 1) {
            super.setLayerType(i, paint);
        }
    }

    public void setImageDrawable(Drawable drawable) {
        if (this.mDrawable != drawable) {
            this.zEO = 0;
            this.aMK = null;
            x(drawable);
            invalidate();
        }
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
    }

    public void setImageBitmap(Bitmap bitmap) {
        setImageDrawable(new BitmapDrawable(this.mContext.getResources(), bitmap));
    }

    private void czR() {
        Drawable drawable = null;
        if (this.mDrawable == null) {
            Resources resources = getResources();
            if (resources != null) {
                if (this.zEO != 0) {
                    try {
                        drawable = resources.getDrawable(this.zEO);
                    } catch (Exception e) {
                        x.w("ImageView", "Unable to find resource: " + this.zEO, e);
                        this.aMK = drawable;
                    }
                } else if (this.aMK == null) {
                    return;
                }
                x(drawable);
            }
        }
    }

    public void setSelected(boolean z) {
        super.setSelected(z);
        Drawable drawable = this.mDrawable;
        if (drawable != null) {
            int intrinsicWidth = drawable.getIntrinsicWidth();
            if (intrinsicWidth < 0) {
                intrinsicWidth = this.zEX;
            }
            int intrinsicHeight = drawable.getIntrinsicHeight();
            if (intrinsicHeight < 0) {
                intrinsicHeight = this.zEY;
            }
            if (intrinsicWidth != this.zEX || intrinsicHeight != this.zEY) {
                this.zEX = intrinsicWidth;
                this.zEY = intrinsicHeight;
                requestLayout();
            }
        }
    }

    public final void a(a aVar) {
        if (aVar == null) {
            throw new NullPointerException();
        } else if (this.zEP != aVar) {
            this.zEP = aVar;
            setWillNotCacheDrawing(this.zEP == a.CENTER);
            requestLayout();
            invalidate();
        }
    }

    public int[] onCreateDrawableState(int i) {
        if (this.zEU == null) {
            return super.onCreateDrawableState(i);
        }
        if (this.zEV) {
            return mergeDrawableStates(super.onCreateDrawableState(this.zEU.length + i), this.zEU);
        }
        return this.zEU;
    }

    private void x(Drawable drawable) {
        if (this.mDrawable != null) {
            this.mDrawable.setCallback(null);
            unscheduleDrawable(this.mDrawable);
        }
        this.mDrawable = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            if (drawable.isStateful()) {
                drawable.setState(getDrawableState());
            }
            drawable.setLevel(this.zEW);
            this.zEX = drawable.getIntrinsicWidth();
            this.zEY = drawable.getIntrinsicHeight();
            czT();
            czS();
        }
    }

    public void onMeasure(int i, int i2) {
        int i3;
        int i4;
        Object obj;
        float f;
        int i5;
        int mode;
        czR();
        Object obj2 = null;
        if (this.mDrawable == null) {
            this.zEX = -1;
            this.zEY = -1;
            i3 = 0;
            i4 = 0;
            obj = null;
            f = 0.0f;
        } else {
            i3 = this.zEX;
            i5 = this.zEY;
            if (i3 <= 0) {
                i3 = 1;
            }
            if (i5 <= 0) {
                i5 = 1;
            }
            if (this.zER) {
                mode = MeasureSpec.getMode(i);
                i4 = MeasureSpec.getMode(i2);
                Object obj3 = mode != 1073741824 ? 1 : null;
                obj2 = i4 != 1073741824 ? 1 : null;
                Object obj4 = obj3;
                f = ((float) i3) / ((float) i5);
                i4 = i5;
                obj = obj4;
            } else {
                f = 0.0f;
                i4 = i5;
                obj = null;
            }
        }
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        if (obj == null && obj2 == null) {
            mode = (paddingTop + paddingBottom) + i4;
            i5 = Math.max((paddingLeft + paddingRight) + i3, getSuggestedMinimumWidth());
            int max = Math.max(mode, getSuggestedMinimumHeight());
            mode = resolveSize(i5, i);
            i5 = resolveSize(max, i2);
        } else {
            i3 = am((i3 + paddingLeft) + paddingRight, this.iX, i);
            i4 = am((i4 + paddingTop) + paddingBottom, this.vxz, i2);
            if (f != 0.0f && ((double) Math.abs((((float) ((i3 - paddingLeft) - paddingRight)) / ((float) ((i4 - paddingTop) - paddingBottom))) - f)) > 1.0E-7d) {
                if (obj != null) {
                    int i6 = (((int) (((float) ((i4 - paddingTop) - paddingBottom)) * f)) + paddingLeft) + paddingRight;
                    if (i6 <= i3) {
                        obj = 1;
                        i3 = i6;
                        if (obj == null && obj2 != null) {
                            i5 = (((int) (((float) ((i3 - paddingLeft) - paddingRight)) / f)) + paddingTop) + paddingBottom;
                            if (i5 <= i4) {
                                mode = i3;
                            }
                        }
                    }
                }
                obj = null;
                i5 = (((int) (((float) ((i3 - paddingLeft) - paddingRight)) / f)) + paddingTop) + paddingBottom;
                if (i5 <= i4) {
                    mode = i3;
                }
            }
            i5 = i4;
            mode = i3;
        }
        setMeasuredDimension(mode, i5);
    }

    private static int am(int i, int i2, int i3) {
        int mode = MeasureSpec.getMode(i3);
        int size = MeasureSpec.getSize(i3);
        switch (mode) {
            case Integer.MIN_VALUE:
                return Math.min(Math.min(i, size), i2);
            case 0:
                return Math.min(i, i2);
            case 1073741824:
                return size;
            default:
                return i;
        }
    }

    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.zEQ = true;
        czS();
    }

    private void czS() {
        float f = 0.0f;
        if (this.mDrawable != null && this.zEQ) {
            int i = this.zEX;
            int i2 = this.zEY;
            int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
            int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
            int i3 = ((i < 0 || width == i) && (i2 < 0 || height == i2)) ? 1 : 0;
            if (i <= 0 || i2 <= 0 || a.FIT_XY == this.zEP) {
                this.mDrawable.setBounds(0, 0, width, height);
                this.zEZ = null;
                return;
            }
            this.mDrawable.setBounds(0, 0, i, i2);
            float f2;
            float f3;
            if (a.MATRIX == this.zEP) {
                if (this.mMatrix.isIdentity()) {
                    this.zEZ = null;
                } else {
                    this.zEZ = this.mMatrix;
                }
            } else if (i3 != 0) {
                this.zEZ = null;
            } else if (a.CENTER == this.zEP) {
                this.zEZ = this.mMatrix;
                this.zEZ.setTranslate((float) ((int) ((((float) (width - i)) * 0.5f) + 0.5f)), (float) ((int) ((((float) (height - i2)) * 0.5f) + 0.5f)));
            } else if (a.CENTER_CROP == this.zEP) {
                this.zEZ = this.mMatrix;
                if (i * height > width * i2) {
                    f2 = ((float) height) / ((float) i2);
                    f3 = (((float) width) - (((float) i) * f2)) * 0.5f;
                } else {
                    f2 = ((float) width) / ((float) i);
                    f3 = 0.0f;
                    f = (((float) height) - (((float) i2) * f2)) * 0.5f;
                }
                this.zEZ.setScale(f2, f2);
                this.zEZ.postTranslate((float) ((int) (f3 + 0.5f)), (float) ((int) (f + 0.5f)));
            } else if (a.CENTER_INSIDE == this.zEP) {
                this.zEZ = this.mMatrix;
                if (i > width || i2 > height) {
                    f = Math.min(((float) width) / ((float) i), ((float) height) / ((float) i2));
                } else {
                    f = 1.0f;
                }
                f3 = (float) ((int) (((((float) width) - (((float) i) * f)) * 0.5f) + 0.5f));
                f2 = (float) ((int) (((((float) height) - (((float) i2) * f)) * 0.5f) + 0.5f));
                this.zEZ.setScale(f, f);
                this.zEZ.postTranslate(f3, f2);
            } else {
                this.zFa.set(0.0f, 0.0f, (float) i, (float) i2);
                this.zFb.set(0.0f, 0.0f, (float) width, (float) height);
                this.zEZ = this.mMatrix;
                this.zEZ.setRectToRect(this.zFa, this.zFb, zFe[this.zEP.zFn - 1]);
            }
        }
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.mDrawable;
        if (drawable != null && drawable.isStateful()) {
            drawable.setState(getDrawableState());
        }
    }

    public void onDraw(Canvas canvas) {
        canvas.setDrawFilter(new PaintFlagsDrawFilter(0, 3));
        super.onDraw(canvas);
        if (this.mDrawable != null && this.zEX != 0 && this.zEY != 0) {
            if (this.zEZ == null && getPaddingTop() == 0 && getPaddingLeft() == 0) {
                this.mDrawable.draw(canvas);
                return;
            }
            int saveCount = canvas.getSaveCount();
            canvas.save();
            if (this.zFc) {
                int scrollX = getScrollX();
                int scrollY = getScrollY();
                canvas.clipRect(getPaddingLeft() + scrollX, getPaddingTop() + scrollY, ((scrollX + getRight()) - getLeft()) - getPaddingRight(), ((scrollY + getBottom()) - getTop()) - getPaddingBottom());
            }
            canvas.translate((float) getPaddingLeft(), (float) getPaddingTop());
            if (this.zEZ != null) {
                canvas.concat(this.zEZ);
            }
            this.mDrawable.draw(canvas);
            canvas.restoreToCount(saveCount);
        }
    }

    public int getBaseline() {
        return this.RQ ? getMeasuredHeight() : -1;
    }

    public final void setAlpha(int i) {
        int i2 = i & 255;
        if (this.Dd != i2) {
            this.Dd = i2;
            this.zET = true;
            czT();
            invalidate();
        }
    }

    private void czT() {
        if (this.mDrawable != null && this.zET) {
            this.mDrawable = this.mDrawable.mutate();
            this.mDrawable.setColorFilter(this.mr);
            this.mDrawable.setAlpha((this.Dd * this.zES) >> 8);
        }
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }
}
