package com.tencent.neattextview.textview.view;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint.FontMetricsInt;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.text.Layout;
import android.text.Spannable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.text.style.CharacterStyle;
import android.util.AttributeSet;
import android.util.LruCache;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnTouchListener;
import android.widget.TextView;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.neattextview.textview.layout.NeatLayout;
import com.tencent.smtt.sdk.WebView;

public class NeatTextView extends View implements a {
    private static final LruCache<String, Boolean> zGb = new LruCache(500);
    private static final HandlerThread zUA;
    private static Handler zUB;
    private static final LruCache<a, com.tencent.neattextview.textview.layout.b> zUz = new LruCache(500);
    private int KD = 0;
    private ColorStateList ek;
    public TextPaint gu;
    private int iX = Integer.MAX_VALUE;
    private CharSequence kV;
    public CharSequence mText;
    private int nDk = Integer.MAX_VALUE;
    private int vxz = Integer.MAX_VALUE;
    private int yoj;
    private TruncateAt yom;
    private float yos = 0.0f;
    public boolean zFV;
    private int zGA = 0;
    private int zGH = 8388659;
    public TextView zUC;
    private ColorStateList zUD;
    private ColorStateList zUE;
    private int zUF;
    private b zUG;
    private boolean zUH = true;
    public b zUI;
    private boolean zUJ = true;
    private d zUK;
    public com.tencent.neattextview.textview.layout.b zUl;

    public interface b {
        boolean dF(View view);
    }

    public interface c extends OnTouchListener {
    }

    static final class d implements Runnable {
        static TextPaint gVm = new TextPaint();
        volatile boolean hjU = false;
        String text;
        float[] zUP;

        d(String str, TextPaint textPaint) {
            gVm.set(textPaint);
            this.text = str;
        }

        public final float[] cDi() {
            return this.hjU ? this.zUP : null;
        }

        public final void run() {
            this.zUP = new float[this.text.length()];
            gVm.getTextWidths(this.text, this.zUP);
            this.hjU = true;
        }
    }

    class a {
        float fontScale;
        float gVS;
        int orientation;
        CharSequence text;
        int zUL = 1;
        FontMetricsInt zUM;
        int[] zUN;
        final /* synthetic */ NeatTextView zUO;

        a(NeatTextView neatTextView, CharSequence charSequence, int[] iArr, float f, FontMetricsInt fontMetricsInt) {
            int i = 0;
            this.zUO = neatTextView;
            this.zUN = iArr;
            this.text = TextUtils.isEmpty(charSequence) ? "" : charSequence;
            this.gVS = f;
            this.zUM = fontMetricsInt;
            this.fontScale = neatTextView.getResources().getConfiguration().fontScale;
            this.orientation = neatTextView.getResources().getConfiguration().orientation;
            if (charSequence instanceof Spannable) {
                CharacterStyle[] characterStyleArr = (CharacterStyle[]) ((Spannable) charSequence).getSpans(0, charSequence.length(), CharacterStyle.class);
                int length = characterStyleArr.length;
                while (i < length) {
                    this.zUL = characterStyleArr[i].hashCode() + this.zUL;
                    i++;
                }
            }
        }

        public final int hashCode() {
            return (int) (((((float) (this.zUL + this.text.hashCode())) + ((this.gVS * this.fontScale) * ((float) this.orientation))) + ((float) this.zUN[0])) + ((float) this.zUN[1]));
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            if (this.gVS == aVar.gVS && this.fontScale == aVar.fontScale && this.zUN[0] == aVar.zUN[0] && this.zUN[1] == aVar.zUN[1] && this.zUM.descent == aVar.zUM.descent && this.zUM.top == aVar.zUM.top && this.zUM.bottom == aVar.zUM.bottom && this.zUM.ascent == aVar.zUM.ascent && this.zUM.leading == aVar.zUM.leading && this.text.equals(aVar.text)) {
                return true;
            }
            return false;
        }
    }

    static {
        HandlerThread handlerThread = new HandlerThread("PreMeasuredThread", -8);
        zUA = handlerThread;
        handlerThread.start();
        Looper looper = zUA.getLooper();
        if (looper != null) {
            zUB = new Handler(looper);
        }
    }

    public NeatTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context, attributeSet, 0);
    }

    public NeatTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context, attributeSet, i);
    }

    private void a(Context context, AttributeSet attributeSet, int i) {
        this.zUG = new b(getContext(), this);
        TextView textView = new TextView(context);
        textView.setClickable(true);
        textView.setFocusable(true);
        this.zUC = textView;
        this.gu = this.zUC.getPaint();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.tencent.neattextview.textview.a.a.fbb, i, 0);
        int i2 = WebView.NIGHT_MODE_COLOR;
        int i3 = -7829368;
        int i4 = -16776961;
        int i5 = -1;
        int i6 = 0;
        try {
            int indexCount = obtainStyledAttributes.getIndexCount();
            CharSequence charSequence = null;
            i6 = -1;
            i5 = -16776961;
            i4 = -7829368;
            i3 = WebView.NIGHT_MODE_COLOR;
            i2 = 15;
            for (int i7 = 0; i7 < indexCount; i7++) {
                int index = obtainStyledAttributes.getIndex(i7);
                if (index == com.tencent.neattextview.textview.a.a.zTh) {
                    i2 = obtainStyledAttributes.getDimensionPixelSize(index, 15);
                } else if (index == com.tencent.neattextview.textview.a.a.zTi) {
                    i3 = obtainStyledAttributes.getColor(index, WebView.NIGHT_MODE_COLOR);
                } else if (index == com.tencent.neattextview.textview.a.a.zTx) {
                    if (obtainStyledAttributes.getBoolean(index, false)) {
                        index = 1;
                    } else {
                        index = -1;
                    }
                    setMaxLines(index);
                } else if (index == com.tencent.neattextview.textview.a.a.zTu) {
                    index = obtainStyledAttributes.getInt(index, -1);
                    this.nDk = index;
                    this.zUC.setLines(index);
                    requestLayout();
                    invalidate();
                } else if (index == com.tencent.neattextview.textview.a.a.zTm) {
                    index = obtainStyledAttributes.getInt(index, 16);
                    this.zUC.setGravity(index);
                    if ((8388615 & index) == 0) {
                        index |= 8388611;
                    }
                    if ((index & MMGIFException.D_GIF_ERR_IMAGE_DEFECT) == 0) {
                        index |= 48;
                    }
                    this.zGH = index;
                    if (index != this.zGH) {
                        invalidate();
                    }
                } else if (index == com.tencent.neattextview.textview.a.a.zTn) {
                    index = obtainStyledAttributes.getDimensionPixelSize(index, -1);
                    this.iX = index;
                    this.zUC.setMaxWidth(index);
                    requestLayout();
                    invalidate();
                } else if (index == com.tencent.neattextview.textview.a.a.zTy) {
                    index = obtainStyledAttributes.getDimensionPixelSize(index, (int) this.yos);
                    this.yos = (float) index;
                    this.zUC.setLineSpacing((float) index, 1.0f);
                    requestLayout();
                    invalidate();
                } else if (index == com.tencent.neattextview.textview.a.a.zTp) {
                    index = obtainStyledAttributes.getDimensionPixelSize(index, -1);
                    this.KD = index;
                    this.zUC.setMinWidth(index);
                    requestLayout();
                    invalidate();
                } else if (index == com.tencent.neattextview.textview.a.a.zTq) {
                    index = obtainStyledAttributes.getDimensionPixelSize(index, -1);
                    this.zGA = index;
                    this.zUC.setMinHeight(index);
                    requestLayout();
                    invalidate();
                } else if (index == com.tencent.neattextview.textview.a.a.zTo) {
                    index = obtainStyledAttributes.getDimensionPixelSize(index, -1);
                    this.vxz = index;
                    this.zUC.setMaxHeight(index);
                    requestLayout();
                    invalidate();
                } else if (index == com.tencent.neattextview.textview.a.a.zTt) {
                    setMaxLines(obtainStyledAttributes.getInt(index, -1));
                } else if (index == com.tencent.neattextview.textview.a.a.zTr) {
                    charSequence = obtainStyledAttributes.getString(index);
                } else if (index == com.tencent.neattextview.textview.a.a.zTw) {
                    index = obtainStyledAttributes.getDimensionPixelSize(index, -1);
                    this.iX = index;
                    this.zUC.setMaxWidth(index);
                    requestLayout();
                    invalidate();
                } else if (index == com.tencent.neattextview.textview.a.a.zTv) {
                    index = obtainStyledAttributes.getDimensionPixelSize(index, -1);
                    this.vxz = index;
                    this.zUC.setMaxHeight(index);
                    requestLayout();
                    invalidate();
                } else if (index == com.tencent.neattextview.textview.a.a.zTs) {
                    this.kV = TextUtils.stringOrSpannedString(obtainStyledAttributes.getText(index));
                    this.zUC.setHint(this.kV);
                    if (TextUtils.isEmpty(this.mText)) {
                        cDv();
                    }
                } else if (index == com.tencent.neattextview.textview.a.a.zTj) {
                    i4 = obtainStyledAttributes.getColor(index, -7829368);
                } else if (index == com.tencent.neattextview.textview.a.a.zTk) {
                    i5 = obtainStyledAttributes.getColor(index, -16776961);
                } else if (index == com.tencent.neattextview.textview.a.a.zTl) {
                    i6 = obtainStyledAttributes.getInt(index, i6);
                } else if (index == com.tencent.neattextview.textview.a.a.zTz) {
                    this.zUJ = obtainStyledAttributes.getBoolean(index, true);
                }
            }
            this.ek = ColorStateList.valueOf(i3);
            this.zUC.setTextColor(i3);
            updateTextColors();
            ai((float) i2);
            this.zUE = ColorStateList.valueOf(i5);
            updateTextColors();
            this.zUD = ColorStateList.valueOf(i4);
            this.zUC.setHintTextColor(i4);
            updateTextColors();
            switch (i6) {
                case 1:
                    setEllipsize(TruncateAt.START);
                    break;
                case 2:
                    setEllipsize(TruncateAt.MIDDLE);
                    break;
                case 3:
                    setEllipsize(TruncateAt.END);
                    break;
            }
            if (!TextUtils.isEmpty(charSequence)) {
                W(charSequence);
            }
            this.zUC.setPadding(getPaddingLeft(), getPaddingTop(), getPaddingRight(), getPaddingBottom());
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public final com.tencent.neattextview.textview.layout.b cDs() {
        return this.zUl;
    }

    public final b cDt() {
        return this.zUI;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.zUG == null || !this.zUG.onTouch(this, motionEvent)) {
            return super.onTouchEvent(motionEvent);
        }
        return true;
    }

    public void onMeasure(int i, int i2) {
        if (TextUtils.isEmpty(this.mText) && TextUtils.isEmpty(this.kV)) {
            super.onMeasure(i, i2);
        } else if (this.zFV) {
            this.zUC.measure(i, i2);
            setMeasuredDimension(this.zUC.getMeasuredWidth(), this.zUC.getMeasuredHeight());
        } else {
            int i3;
            int i4;
            int mode = MeasureSpec.getMode(i);
            int mode2 = MeasureSpec.getMode(i2);
            int size = MeasureSpec.getSize(i);
            int size2 = MeasureSpec.getSize(i2);
            if (size <= 0 && mode2 == 0) {
                size = getResources().getDisplayMetrics().widthPixels;
            }
            if (size2 <= 0 && mode2 == 0) {
                size2 = Integer.MAX_VALUE;
            }
            if (this.iX <= 0 || this.iX >= size) {
                i3 = size;
            } else {
                i3 = this.iX;
            }
            if (this.vxz <= 0 || this.vxz >= size2) {
                i4 = size2;
            } else {
                i4 = this.vxz;
            }
            size2 = (i3 - getPaddingLeft()) - getPaddingRight();
            size = (i4 - getPaddingTop()) - getPaddingBottom();
            a aVar = new a(this, this.mText, new int[]{size2, size}, this.gu.getTextSize(), this.gu.getFontMetricsInt());
            this.zUl = (com.tencent.neattextview.textview.layout.b) zUz.get(aVar);
            if (this.zUl == null) {
                if (!TextUtils.isEmpty(this.mText) || TextUtils.isEmpty(this.kV)) {
                    this.zUl = new NeatLayout(this.mText, this.zUK == null ? null : this.zUK.cDi());
                } else {
                    this.zUl = new NeatLayout(this.kV, this.zUK == null ? null : this.zUK.cDi());
                }
                this.zUl.a(this.gu, (float) aVar.zUN[0], (float) aVar.zUN[1], this.yos, this.nDk, this.yom, this.zUJ);
                zUz.put(aVar, this.zUl);
            }
            float[] cDn = this.zUl.cDn();
            if (mode != 1073741824) {
                i3 = (int) Math.min((cDn[0] + ((float) getPaddingLeft())) + ((float) getPaddingRight()), (float) this.iX);
            }
            if (mode2 != 1073741824) {
                i4 = (int) Math.min((cDn[1] + ((float) getPaddingTop())) + ((float) getPaddingBottom()), (float) this.vxz);
            }
            setMeasuredDimension(Math.max(i3, this.KD), Math.max(i4, this.zGA));
        }
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int i = this.yoj;
        if (!(TextUtils.isEmpty(this.kV) || !TextUtils.isEmpty(this.mText) || this.zUD == null)) {
            i = this.zUF;
        }
        this.gu.setColor(i);
        this.gu.drawableState = getDrawableState();
        if (this.zFV) {
            canvas.save();
            canvas.translate((float) getPaddingLeft(), (float) getPaddingTop());
            Layout layout = this.zUC.getLayout();
            if (layout != null) {
                layout.draw(canvas);
            }
            canvas.restore();
        } else if (this.zUl != null) {
            if (this.zUl.cDo() != null) {
                this.zUl.cDo().set(this.gu);
            }
            this.zUl.a(canvas, (float) getPaddingLeft(), czD());
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void W(java.lang.CharSequence r7) {
        /*
        r6 = this;
        r1 = 1;
        r2 = 0;
        if (r7 != 0) goto L_0x0007;
    L_0x0004:
        r7 = "";
    L_0x0007:
        r6.mText = r7;
        r0 = r6.czE();
        if (r0 == 0) goto L_0x0032;
    L_0x000f:
        r3 = r7.toString();
        r0 = zGb;
        r0 = r0.get(r3);
        r0 = (java.lang.Boolean) r0;
        if (r0 != 0) goto L_0x0056;
    L_0x001d:
        r0 = "^[\\u0001-\\u00b7\\u4E00-\\u9FA5\\ue001-\\ue537\\u2005-\\u2027\\u3001-\\u3011\\uff01-\\uffe5\\u2100-\\u2900[\\ud83c\\udc00-\\ud83c\\udfff]|[\\ud83d\\udc00-\\ud83d\\udfff]]+$";
        r0 = r3.matches(r0);
        if (r0 != 0) goto L_0x0054;
    L_0x0026:
        r0 = r1;
    L_0x0027:
        r4 = zGb;
        r5 = java.lang.Boolean.valueOf(r0);
        r4.put(r3, r5);
    L_0x0030:
        if (r0 == 0) goto L_0x0033;
    L_0x0032:
        r2 = r1;
    L_0x0033:
        r6.zFV = r2;
        r0 = r6.zFV;
        if (r0 == 0) goto L_0x005b;
    L_0x0039:
        r0 = r6.getLayoutParams();
        if (r0 == 0) goto L_0x0048;
    L_0x003f:
        r0 = r6.zUC;
        r1 = r6.getLayoutParams();
        r0.setLayoutParams(r1);
    L_0x0048:
        r0 = r6.zUC;
        r0.setText(r7);
        r6.requestLayout();
        r6.invalidate();
    L_0x0053:
        return;
    L_0x0054:
        r0 = r2;
        goto L_0x0027;
    L_0x0056:
        r0 = r0.booleanValue();
        goto L_0x0030;
    L_0x005b:
        r6.cDv();
        goto L_0x0053;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.neattextview.textview.view.NeatTextView.W(java.lang.CharSequence):void");
    }

    public float czD() {
        if ((this.zGH & MMGIFException.D_GIF_ERR_IMAGE_DEFECT) == 48 || this.zUl == null) {
            return (float) getPaddingTop();
        }
        return (((float) getMeasuredHeight()) - this.zUl.cDn()[1]) / 2.0f;
    }

    public final float cDu() {
        if ((this.zGH & 7) == 3 || this.zUl == null) {
            return (float) getPaddingLeft();
        }
        return (((float) getMeasuredHeight()) - this.zUl.cDn()[0]) / 2.0f;
    }

    private void setEllipsize(TruncateAt truncateAt) {
        if (this.yom != truncateAt) {
            this.yom = truncateAt;
            if (this.zUl != null) {
                this.zUl = null;
                requestLayout();
                invalidate();
            }
        }
    }

    public void setPadding(int i, int i2, int i3, int i4) {
        if (!(i == getPaddingLeft() && i3 == getPaddingRight() && i2 == getPaddingTop() && i4 == getPaddingBottom())) {
            this.zUl = null;
        }
        super.setPadding(i, i2, i3, i4);
        this.zUC.setPadding(i, i2, i3, i4);
        invalidate();
    }

    public boolean czE() {
        return this.zUH;
    }

    private void setMaxLines(int i) {
        this.nDk = i;
        this.zUC.setMaxLines(i);
        requestLayout();
        invalidate();
    }

    private void cDv() {
        this.zUl = null;
        if (zUB != null) {
            Handler handler;
            Runnable dVar;
            if (this.mText == null && this.kV != null) {
                handler = zUB;
                dVar = new d(this.kV.toString(), this.gu);
                this.zUK = dVar;
                handler.post(dVar);
            } else if (this.mText != null) {
                handler = zUB;
                dVar = new d(this.mText.toString(), this.gu);
                this.zUK = dVar;
                handler.post(dVar);
            } else {
                return;
            }
        }
        requestLayout();
        invalidate();
    }

    private void updateTextColors() {
        int colorForState = this.ek.getColorForState(getDrawableState(), 0);
        if (colorForState != this.yoj) {
            this.yoj = colorForState;
            colorForState = 1;
        } else {
            colorForState = 0;
        }
        if (this.zUE != null) {
            int colorForState2 = this.zUE.getColorForState(getDrawableState(), 0);
            if (colorForState2 != this.gu.linkColor) {
                this.gu.linkColor = colorForState2;
                colorForState = 1;
            }
        }
        if (this.zUD != null) {
            int colorForState3 = this.zUD.getColorForState(getDrawableState(), 0);
            if (colorForState3 != this.zUF) {
                this.zUF = colorForState3;
                if (this.mText == null || this.mText.length() == 0) {
                    colorForState = 1;
                }
            }
        }
        if (colorForState != 0) {
            invalidate();
        }
    }

    public final void ai(float f) {
        if (f != this.gu.getTextSize()) {
            this.gu.setTextSize(f);
            if (this.zUl != null) {
                cDv();
                requestLayout();
                invalidate();
            }
        }
    }
}
