package com.tencent.mm.ui.base;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.BoringLayout;
import android.text.BoringLayout.Metrics;
import android.text.Editable.Factory;
import android.text.Layout;
import android.text.Layout.Alignment;
import android.text.Selection;
import android.text.Spannable;
import android.text.Spanned;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.text.method.KeyListener;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.accessibility.AccessibilityNodeInfo;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.mm.sdk.platformtools.bi;

@SuppressLint({"ResourceAsColor"})
public class NoMeasuredTextView extends View {
    private static final Metrics yoQ = new Metrics();
    private int KD;
    private ColorStateList ek;
    public TextPaint gu;
    private int iX;
    private CharSequence mText;
    private int ug;
    private boolean ylN;
    private boolean yoA;
    private BoringLayout yoB;
    private boolean yoC;
    private int yoD;
    private FontMetricsInt yoE;
    private boolean yoF;
    public boolean yoG;
    private b yoH;
    private boolean yoI;
    private boolean yoJ;
    private boolean yoK;
    private boolean yoL;
    private int yoM;
    private int yoN;
    private int yoO;
    private int yoP;
    private int yoj;
    private Factory yok;
    private Spannable.Factory yol;
    private TruncateAt yom;
    private CharSequence yon;
    private int yoo;
    private KeyListener yop;
    private Layout yoq;
    private float yor;
    private float yos;
    private int yot;
    private int you;
    private int yov;
    private int yow;
    private boolean yox;
    private boolean yoy;
    private int yoz;

    public enum a {
        ;

        static {
            yoR = 1;
            yoS = 2;
            yoT = 3;
            yoU = new int[]{yoR, yoS, yoT};
        }
    }

    class b {
        final Rect yoV = new Rect();
        Drawable yoW;
        Drawable yoX;
        Drawable yoY;
        Drawable yoZ;
        int ypa;
        int ypb;
        int ypc;
        int ypd;
        int ype;
        int ypf;
        int ypg;
        int yph;
        int ypi;

        b() {
        }
    }

    public final void mA(boolean z) {
        if (this.yoI != z) {
            invalidate();
        }
        this.yoI = z;
    }

    public final void mB(boolean z) {
        if (this.yoJ != z) {
            invalidate();
        }
        this.yoJ = z;
    }

    static {
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.measureText("H");
    }

    public NoMeasuredTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.yok = Factory.getInstance();
        this.yol = Spannable.Factory.getInstance();
        this.yom = null;
        this.yoo = a.yoR;
        this.ug = 51;
        this.yor = 1.0f;
        this.yos = 0.0f;
        this.yot = Integer.MAX_VALUE;
        this.you = 1;
        this.yov = 0;
        this.yow = 1;
        this.iX = Integer.MAX_VALUE;
        this.yox = false;
        this.KD = 0;
        this.yoy = false;
        this.yoz = -1;
        this.yoA = true;
        this.yoC = false;
        this.yoF = false;
        this.yoG = false;
        this.yoI = false;
        this.yoJ = false;
        this.yoK = false;
        this.yoL = false;
        this.yoM = -1;
        this.yoN = -1;
        this.yoO = -1;
        this.yoP = -1;
        this.mText = "";
        this.yon = "";
        this.gu = new TextPaint(1);
        this.gu.density = getResources().getDisplayMetrics().density;
        setDrawingCacheEnabled(false);
        this.yoE = this.gu.getFontMetricsInt();
        cqP();
        cqk();
        setEllipsize(null);
    }

    private void a(Drawable drawable, Drawable drawable2) {
        b bVar = this.yoH;
        int i = (drawable == null && drawable2 == null) ? 0 : 1;
        if (i != 0) {
            if (bVar == null) {
                bVar = new b();
                this.yoH = bVar;
            }
            if (!(bVar.yoY == drawable || bVar.yoY == null)) {
                bVar.yoY.setCallback(null);
            }
            bVar.yoY = drawable;
            if (!(bVar.yoW == null || bVar.yoW == null)) {
                bVar.yoW.setCallback(null);
            }
            bVar.yoW = null;
            if (!(bVar.yoZ == drawable2 || bVar.yoZ == null)) {
                bVar.yoZ.setCallback(null);
            }
            bVar.yoZ = drawable2;
            if (!(bVar.yoX == null || bVar.yoX == null)) {
                bVar.yoX.setCallback(null);
            }
            bVar.yoX = null;
            Rect rect = bVar.yoV;
            int[] drawableState = getDrawableState();
            if (drawable != null) {
                drawable.setState(drawableState);
                drawable.copyBounds(rect);
                drawable.setCallback(this);
                bVar.ypc = rect.width();
                bVar.ypg = rect.height();
            } else {
                bVar.ypg = 0;
                bVar.ypc = 0;
            }
            if (drawable2 != null) {
                drawable2.setState(drawableState);
                drawable2.copyBounds(rect);
                drawable2.setCallback(this);
                bVar.ypd = rect.width();
                bVar.yph = rect.height();
                bVar.ype = 0;
                bVar.ypa = 0;
                bVar.ypf = 0;
                bVar.ypb = 0;
            }
            bVar.yph = 0;
            bVar.ypd = 0;
            bVar.ype = 0;
            bVar.ypa = 0;
            bVar.ypf = 0;
            bVar.ypb = 0;
        } else if (bVar != null) {
            if (bVar.ypi == 0) {
                this.yoH = null;
            } else {
                if (bVar.yoY != null) {
                    bVar.yoY.setCallback(null);
                }
                bVar.yoY = null;
                if (bVar.yoW != null) {
                    bVar.yoW.setCallback(null);
                }
                bVar.yoW = null;
                if (bVar.yoZ != null) {
                    bVar.yoZ.setCallback(null);
                }
                bVar.yoZ = null;
                if (bVar.yoX != null) {
                    bVar.yoX.setCallback(null);
                }
                bVar.yoX = null;
                bVar.ypg = 0;
                bVar.ypc = 0;
                bVar.yph = 0;
                bVar.ypd = 0;
                bVar.ype = 0;
                bVar.ypa = 0;
                bVar.ypf = 0;
                bVar.ypb = 0;
            }
        }
        invalidate();
    }

    public final void Fl(int i) {
        if (i != this.yoM) {
            this.yoM = i;
            Drawable drawable = getResources().getDrawable(i);
            if (drawable == null) {
                return;
            }
            if (this.yoH == null || this.yoH.yoY != drawable) {
                drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                a(drawable, null);
            }
        }
    }

    public final void Fm(int i) {
        if (i != this.yoN) {
            this.yoN = i;
            Drawable drawable = getResources().getDrawable(i);
            if (drawable == null) {
                return;
            }
            if (this.yoH == null || this.yoH.yoZ != drawable) {
                drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                a(null, drawable);
            }
        }
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.ek != null && this.ek.isStateful()) {
            updateTextColors();
        }
        b bVar = this.yoH;
        if (bVar != null) {
            int[] drawableState = getDrawableState();
            if (bVar.yoW != null && bVar.yoW.isStateful()) {
                bVar.yoW.setState(drawableState);
            }
            if (bVar.yoX != null && bVar.yoX.isStateful()) {
                bVar.yoX.setState(drawableState);
            }
            if (bVar.yoY != null && bVar.yoY.isStateful()) {
                bVar.yoY.setState(drawableState);
            }
            if (bVar.yoZ != null && bVar.yoZ.isStateful()) {
                bVar.yoZ.setState(drawableState);
            }
        }
    }

    protected boolean verifyDrawable(Drawable drawable) {
        boolean verifyDrawable = super.verifyDrawable(drawable);
        if (verifyDrawable || this.yoH == null) {
            return verifyDrawable;
        }
        return drawable == this.yoH.yoY || drawable == this.yoH.yoW || drawable == this.yoH.yoZ || drawable == this.yoH.yoX;
    }

    public void invalidateDrawable(Drawable drawable) {
        if (verifyDrawable(drawable)) {
            Rect bounds = drawable.getBounds();
            int scrollX = getScrollX();
            int scrollY = getScrollY();
            b bVar = this.yoH;
            if (bVar != null) {
                int compoundPaddingTop;
                if (drawable == bVar.yoY) {
                    compoundPaddingTop = getCompoundPaddingTop();
                    scrollX += getPaddingLeft();
                    scrollY += (((((getBottom() - getTop()) - getCompoundPaddingBottom()) - compoundPaddingTop) - bVar.ypg) / 2) + compoundPaddingTop;
                } else if (drawable == bVar.yoZ) {
                    compoundPaddingTop = getCompoundPaddingTop();
                    scrollX += ((getRight() - getLeft()) - getPaddingRight()) - bVar.ypd;
                    scrollY += (((((getBottom() - getTop()) - getCompoundPaddingBottom()) - compoundPaddingTop) - bVar.yph) / 2) + compoundPaddingTop;
                } else if (drawable == bVar.yoW) {
                    compoundPaddingTop = getCompoundPaddingLeft();
                    scrollX += (((((getRight() - getLeft()) - getCompoundPaddingRight()) - compoundPaddingTop) - bVar.ype) / 2) + compoundPaddingTop;
                    scrollY += getPaddingTop();
                } else if (drawable == bVar.yoX) {
                    compoundPaddingTop = getCompoundPaddingLeft();
                    scrollX += compoundPaddingTop + (((((getRight() - getLeft()) - getCompoundPaddingRight()) - compoundPaddingTop) - bVar.ypf) / 2);
                    scrollY += ((getBottom() - getTop()) - getPaddingBottom()) - bVar.ypb;
                }
            }
            invalidate(bounds.left + scrollX, bounds.top + scrollY, scrollX + bounds.right, scrollY + bounds.bottom);
        }
    }

    private int getCompoundPaddingTop() {
        b bVar = this.yoH;
        if (bVar == null || bVar.yoW == null || !this.yoK) {
            return getPaddingTop();
        }
        return bVar.ypa + (getPaddingTop() + bVar.ypi);
    }

    private int getCompoundPaddingBottom() {
        b bVar = this.yoH;
        if (bVar == null || bVar.yoX == null || !this.yoL) {
            return getPaddingBottom();
        }
        return bVar.ypb + (getPaddingBottom() + bVar.ypi);
    }

    private int getCompoundPaddingLeft() {
        b bVar = this.yoH;
        if (bVar == null || bVar.yoY == null || !this.yoI) {
            return getPaddingLeft();
        }
        return bVar.ypc + (getPaddingLeft() + bVar.ypi);
    }

    private int getCompoundPaddingRight() {
        b bVar = this.yoH;
        if (bVar == null || bVar.yoZ == null || !this.yoJ) {
            return getPaddingRight();
        }
        return bVar.ypd + (getPaddingRight() + bVar.ypi);
    }

    private int getExtendedPaddingTop() {
        if (this.yoq == null || this.you != 1) {
            return getCompoundPaddingTop();
        }
        if (this.yoq.getLineCount() <= this.yot) {
            return getCompoundPaddingTop();
        }
        int compoundPaddingTop = getCompoundPaddingTop();
        int height = (getHeight() - compoundPaddingTop) - getCompoundPaddingBottom();
        int lineTop = this.yoq.getLineTop(this.yot);
        if (lineTop >= height) {
            return compoundPaddingTop;
        }
        int i = this.ug & MMGIFException.D_GIF_ERR_IMAGE_DEFECT;
        if (i == 48) {
            return compoundPaddingTop;
        }
        if (i == 80) {
            return (compoundPaddingTop + height) - lineTop;
        }
        return compoundPaddingTop + ((height - lineTop) / 2);
    }

    private int getExtendedPaddingBottom() {
        if (this.yoq == null || this.you != 1) {
            return getCompoundPaddingBottom();
        }
        if (this.yoq.getLineCount() <= this.yot) {
            return getCompoundPaddingBottom();
        }
        int compoundPaddingTop = getCompoundPaddingTop();
        int compoundPaddingBottom = getCompoundPaddingBottom();
        compoundPaddingTop = (getHeight() - compoundPaddingTop) - compoundPaddingBottom;
        int lineTop = this.yoq.getLineTop(this.yot);
        if (lineTop >= compoundPaddingTop) {
            return compoundPaddingBottom;
        }
        int i = this.ug & MMGIFException.D_GIF_ERR_IMAGE_DEFECT;
        if (i == 48) {
            return (compoundPaddingBottom + compoundPaddingTop) - lineTop;
        }
        return i != 80 ? compoundPaddingBottom + ((compoundPaddingTop - lineTop) / 2) : compoundPaddingBottom;
    }

    public void setPadding(int i, int i2, int i3, int i4) {
        if (!(i == getPaddingLeft() && i3 == getPaddingRight() && i2 == getPaddingTop() && i4 == getPaddingBottom())) {
            cqN();
        }
        super.setPadding(i, i2, i3, i4);
        invalidate();
    }

    public final void O(float f) {
        Resources system;
        Context context = getContext();
        if (context == null) {
            system = Resources.getSystem();
        } else {
            system = context.getResources();
        }
        float applyDimension = TypedValue.applyDimension(0, f, system.getDisplayMetrics());
        if (applyDimension != this.gu.getTextSize()) {
            this.gu.setTextSize(applyDimension);
            this.yoE = this.gu.getFontMetricsInt();
            this.yoD = (int) (Math.ceil((double) (this.yoE.descent - this.yoE.ascent)) + 2.0d);
            if (this.yoq != null) {
                cqN();
                requestLayout();
                invalidate();
            }
        }
    }

    public final void setTextColor(int i) {
        this.ek = ColorStateList.valueOf(i);
        updateTextColors();
    }

    public final void setTextColor(ColorStateList colorStateList) {
        if (colorStateList == null) {
            throw new NullPointerException();
        } else if (this.ek != colorStateList) {
            this.ek = colorStateList;
            updateTextColors();
        }
    }

    public final void En() {
        Object obj = null;
        if (5 != (this.ug & 7)) {
            obj = 1;
        }
        if (53 != this.ug) {
            invalidate();
        }
        this.ug = 53;
        if (this.yoq != null && obj != null) {
            eW(this.yoq.getWidth(), (getWidth() - getCompoundPaddingLeft()) - getCompoundPaddingRight());
        }
    }

    private void updateTextColors() {
        int i = 0;
        int colorForState = this.ek.getColorForState(getDrawableState(), 0);
        if (colorForState != this.yoj) {
            this.yoj = colorForState;
            i = 1;
        }
        if (i != 0) {
            invalidate();
        }
    }

    public final void setText(CharSequence charSequence) {
        int i = this.yoo;
        if (charSequence == null) {
            charSequence = "";
        }
        if (!charSequence.equals(this.mText)) {
            int i2;
            if (charSequence instanceof Spanned) {
                this.yoC = false;
            } else {
                this.yoC = true;
            }
            if (i == a.yoT || this.yop != null) {
                charSequence = this.yok.newEditable(charSequence);
            } else if (i == a.yoS) {
                charSequence = this.yol.newSpannable(charSequence);
            }
            int compoundPaddingLeft = getCompoundPaddingLeft() + getCompoundPaddingRight();
            if (this.yoG) {
                if (this.yox) {
                    i2 = this.iX;
                    if (getMeasuredWidth() > 0) {
                        i2 = Math.min(this.iX, getMeasuredWidth());
                    }
                    charSequence = TextUtils.ellipsize(charSequence, this.gu, (float) (i2 - compoundPaddingLeft), TruncateAt.END);
                } else if (getMeasuredWidth() > 0) {
                    charSequence = TextUtils.ellipsize(charSequence, this.gu, (float) (getMeasuredWidth() - compoundPaddingLeft), TruncateAt.END);
                } else {
                    this.yoF = true;
                }
            }
            this.yoo = i;
            this.mText = charSequence;
            this.yon = charSequence;
            if (this.yoC) {
                cqP();
                invalidate();
                return;
            }
            if (getWidth() != 0) {
                if (this.yoq == null) {
                    cqO();
                    if (this.yoq.getHeight() != getHeight()) {
                        requestLayout();
                    }
                    invalidate();
                    return;
                }
                i2 = this.yoq.getHeight();
                i = this.yoq.getWidth();
                eW(i, i - compoundPaddingLeft);
                if (this.yom != TruncateAt.MARQUEE) {
                    if (getLayoutParams().height == -2 || getLayoutParams().height == -1) {
                        i = this.yoq.getHeight();
                        if (i == i2 && i == getHeight()) {
                            invalidate();
                            return;
                        }
                    }
                    invalidate();
                    return;
                }
            }
            requestLayout();
            invalidate();
        }
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.yoF && getMeasuredWidth() > 0) {
            setText(TextUtils.ellipsize(this.mText, this.gu, (float) ((getMeasuredWidth() - getCompoundPaddingRight()) - getCompoundPaddingLeft()), TruncateAt.END));
            this.yoF = false;
        }
    }

    private int cqM() {
        int i = this.ug & MMGIFException.D_GIF_ERR_IMAGE_DEFECT;
        Layout layout = this.yoq;
        if (i == 48) {
            return 0;
        }
        int measuredHeight = (getMeasuredHeight() - getExtendedPaddingTop()) - getExtendedPaddingBottom();
        int height = layout.getHeight();
        if (height >= measuredHeight) {
            return 0;
        }
        if (i == 80) {
            return measuredHeight - height;
        }
        return (measuredHeight - height) >> 1;
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int compoundPaddingLeft = getCompoundPaddingLeft();
        int compoundPaddingTop = getCompoundPaddingTop();
        int compoundPaddingRight = getCompoundPaddingRight();
        int compoundPaddingBottom = getCompoundPaddingBottom();
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        int right = getRight();
        int left = getLeft();
        int bottom = getBottom();
        int top = getTop();
        int width = getWidth();
        int height = getHeight();
        b bVar = this.yoH;
        float f = -1.0f;
        if (bVar != null) {
            int i = ((bottom - top) - compoundPaddingBottom) - compoundPaddingTop;
            int i2 = ((right - left) - compoundPaddingRight) - compoundPaddingLeft;
            if (this.yoI && bVar.yoY != null) {
                canvas.save();
                canvas.translate((float) (getPaddingLeft() + scrollX), (float) ((scrollY + compoundPaddingTop) + ((i - bVar.ypg) / 2)));
                bVar.yoY.draw(canvas);
                canvas.restore();
            }
            if (this.yoJ && bVar.yoZ != null) {
                float measureText;
                canvas.save();
                if (this.yoC) {
                    measureText = this.gu.measureText(this.mText, 0, this.mText.length());
                    f = measureText;
                } else {
                    measureText = (float) Math.ceil((double) Layout.getDesiredWidth(this.yon, this.gu));
                }
                canvas.translate((measureText + ((float) scrollX)) - ((float) getPaddingRight()), (float) ((compoundPaddingTop + scrollY) + ((i - bVar.yph) / 2)));
                bVar.yoZ.draw(canvas);
                canvas.restore();
            }
            if (this.yoK && bVar.yoW != null) {
                canvas.save();
                canvas.translate((float) ((scrollX + compoundPaddingLeft) + ((i2 - bVar.ype) / 2)), (float) (getPaddingTop() + scrollY));
                bVar.yoW.draw(canvas);
                canvas.restore();
            }
            if (this.yoL && bVar.yoX != null) {
                canvas.save();
                canvas.translate((float) ((scrollX + compoundPaddingLeft) + ((i2 - bVar.ypf) / 2)), (float) ((((scrollY + bottom) - top) - getPaddingBottom()) - bVar.ypb));
                bVar.yoX.draw(canvas);
                canvas.restore();
            }
        }
        this.gu.setColor(this.yoj);
        this.gu.drawableState = getDrawableState();
        canvas.save();
        int extendedPaddingTop = getExtendedPaddingTop();
        Canvas canvas2 = canvas;
        float f2 = (float) (extendedPaddingTop + scrollY);
        canvas2.clipRect((float) (compoundPaddingLeft + scrollX), f2, (float) (((right - left) - compoundPaddingRight) + scrollX), (float) (((bottom - top) - getExtendedPaddingBottom()) + scrollY));
        compoundPaddingTop = 0;
        compoundPaddingBottom = 0;
        if ((this.ug & MMGIFException.D_GIF_ERR_IMAGE_DEFECT) != 48) {
            compoundPaddingTop = cqM();
            compoundPaddingBottom = cqM();
        }
        canvas.translate((float) compoundPaddingLeft, (float) (extendedPaddingTop + compoundPaddingTop));
        if (this.yoC) {
            float f3 = (float) (((height - (this.yoE.bottom - this.yoE.top)) / 2) - this.yoE.top);
            compoundPaddingBottom = 0;
            if ((this.ug & 7) != 3) {
                switch (this.ug & 7) {
                    case 1:
                        if (f == -1.0f) {
                            f = this.gu.measureText(this.mText, 0, this.mText.length());
                        }
                        compoundPaddingBottom = ((int) (((float) (width - getPaddingRight())) - f)) / 2;
                        break;
                    case 5:
                        if (f == -1.0f) {
                            f = this.gu.measureText(this.mText, 0, this.mText.length());
                        }
                        compoundPaddingBottom = (int) (((float) (width - getPaddingRight())) - f);
                        break;
                }
            }
            canvas.drawText(this.mText, 0, this.mText.length(), (float) compoundPaddingBottom, f3, this.gu);
        } else {
            if (this.yoq == null) {
                cqO();
            }
            this.yoq.draw(canvas, null, null, compoundPaddingBottom - compoundPaddingTop);
        }
        canvas.restore();
    }

    public void getFocusedRect(Rect rect) {
        if (this.yoq == null) {
            super.getFocusedRect(rect);
            return;
        }
        int selectionEnd = Selection.getSelectionEnd(this.mText);
        if (selectionEnd < 0) {
            super.getFocusedRect(rect);
            return;
        }
        int lineForOffset = this.yoq.getLineForOffset(selectionEnd);
        rect.top = this.yoq.getLineTop(lineForOffset);
        rect.bottom = this.yoq.getLineBottom(lineForOffset);
        rect.left = (int) this.yoq.getPrimaryHorizontal(selectionEnd);
        rect.right = rect.left + 1;
        lineForOffset = getCompoundPaddingLeft();
        selectionEnd = getExtendedPaddingTop();
        if ((this.ug & MMGIFException.D_GIF_ERR_IMAGE_DEFECT) != 48) {
            selectionEnd += cqM();
        }
        rect.offset(lineForOffset, selectionEnd);
    }

    public int getBaseline() {
        if (this.yoq == null) {
            return super.getBaseline();
        }
        int cqM;
        if ((this.ug & MMGIFException.D_GIF_ERR_IMAGE_DEFECT) != 48) {
            cqM = cqM();
        } else {
            cqM = 0;
        }
        return (cqM + getExtendedPaddingTop()) + this.yoq.getLineBaseline(0);
    }

    private void cqN() {
        if ((this.yoq instanceof BoringLayout) && this.yoB == null) {
            this.yoB = (BoringLayout) this.yoq;
        }
        this.yoq = null;
    }

    private void cqO() {
        int compoundPaddingLeft;
        if (this.yox) {
            compoundPaddingLeft = (this.iX - getCompoundPaddingLeft()) - getCompoundPaddingRight();
        } else {
            compoundPaddingLeft = ((getRight() - getLeft()) - getCompoundPaddingLeft()) - getCompoundPaddingRight();
        }
        if (compoundPaddingLeft <= 0) {
            compoundPaddingLeft = 0;
        }
        eW(compoundPaddingLeft, compoundPaddingLeft);
    }

    private void eW(int i, int i2) {
        int i3;
        Alignment alignment;
        int i4;
        if (i < 0) {
            i3 = 0;
        } else {
            i3 = i;
        }
        switch (this.ug & 7) {
            case 1:
                alignment = Alignment.ALIGN_CENTER;
                break;
            case 5:
                alignment = Alignment.ALIGN_OPPOSITE;
                break;
            default:
                alignment = Alignment.ALIGN_NORMAL;
                break;
        }
        if (this.yom == null || this.yop != null) {
            i4 = 0;
        } else {
            i4 = 1;
        }
        if (i4 != 0) {
            this.yoq = new StaticLayout(this.yon, 0, this.yon.length(), this.gu, i3, alignment, this.yor, this.yos, this.yoA, this.yom, i2);
        } else {
            this.yoq = new StaticLayout(this.yon, this.gu, i3, alignment, this.yor, this.yos, this.yoA);
        }
    }

    protected void onMeasure(int i, int i2) {
        MeasureSpec.getMode(i);
        int mode = MeasureSpec.getMode(i2);
        int size = MeasureSpec.getSize(i);
        int size2 = MeasureSpec.getSize(i2);
        if (size == 0) {
            setMeasuredDimension(size, this.yoD);
        } else if (this.yoC) {
            if (this.yoD == 0) {
                cqP();
            }
            setMeasuredDimension(size, this.yoD);
        } else {
            int i3;
            int compoundPaddingLeft = getCompoundPaddingLeft() + getCompoundPaddingRight();
            if (this.yox) {
                compoundPaddingLeft = this.iX - compoundPaddingLeft;
            } else {
                compoundPaddingLeft = size - compoundPaddingLeft;
            }
            if (this.yoq == null) {
                eW(compoundPaddingLeft, compoundPaddingLeft);
            } else {
                if (this.yoq.getWidth() != compoundPaddingLeft) {
                    i3 = 1;
                } else {
                    i3 = 0;
                }
                if (i3 != 0) {
                    eW(compoundPaddingLeft, compoundPaddingLeft);
                }
            }
            if (mode == 1073741824) {
                this.yoz = -1;
                compoundPaddingLeft = size2;
            } else {
                Layout layout = this.yoq;
                if (layout == null) {
                    compoundPaddingLeft = 0;
                } else {
                    i3 = layout.getLineCount();
                    int compoundPaddingBottom = getCompoundPaddingBottom() + getCompoundPaddingTop();
                    compoundPaddingLeft = layout.getLineTop(i3) + compoundPaddingBottom;
                    if (this.you != 1) {
                        compoundPaddingLeft = Math.min(compoundPaddingLeft, this.yot);
                    } else if (i3 > this.yot) {
                        compoundPaddingLeft = (layout.getLineTop(this.yot) + layout.getBottomPadding()) + compoundPaddingBottom;
                        i3 = this.yot;
                    }
                    if (this.yow != 1) {
                        compoundPaddingLeft = Math.max(compoundPaddingLeft, this.yov);
                    } else if (i3 < this.yov) {
                        compoundPaddingLeft += (this.yov - i3) * Math.round((((float) this.gu.getFontMetricsInt(null)) * this.yor) + this.yos);
                    }
                    compoundPaddingLeft = Math.max(compoundPaddingLeft, getSuggestedMinimumHeight());
                }
                this.yoz = compoundPaddingLeft;
                if (mode == Integer.MIN_VALUE) {
                    compoundPaddingLeft = Math.min(compoundPaddingLeft, size2);
                }
            }
            scrollTo(0, 0);
            setMeasuredDimension(size, compoundPaddingLeft);
        }
    }

    private void cqP() {
        if (this.yoD == 0) {
            this.yoD = (int) (Math.ceil((double) (this.yoE.descent - this.yoE.ascent)) + 2.0d);
        }
    }

    public final void cqk() {
        this.ylN = true;
        this.yov = 1;
        this.yot = 1;
        this.yow = 1;
        this.you = 1;
        requestLayout();
        invalidate();
    }

    public final void setEllipsize(TruncateAt truncateAt) {
        this.yom = truncateAt;
        if (this.yoq != null) {
            cqN();
            requestLayout();
            invalidate();
        }
    }

    protected int computeHorizontalScrollRange() {
        if (this.yoq != null) {
            return this.yoq.getWidth();
        }
        return super.computeHorizontalScrollRange();
    }

    protected int computeVerticalScrollRange() {
        if (this.yoq != null) {
            return this.yoq.getHeight();
        }
        return super.computeVerticalScrollRange();
    }

    protected int computeVerticalScrollExtent() {
        return (getHeight() - getCompoundPaddingTop()) - getCompoundPaddingBottom();
    }

    @TargetApi(14)
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        CharSequence contentDescription = getContentDescription();
        if (bi.oN((String) contentDescription)) {
            contentDescription = this.mText;
        }
        accessibilityNodeInfo.setText(contentDescription);
    }
}
