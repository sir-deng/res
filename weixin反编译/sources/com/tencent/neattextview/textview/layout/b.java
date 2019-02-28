package com.tencent.neattextview.textview.layout;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.TextUtils.TruncateAt;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.CharacterStyle;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.ImageSpan;
import android.text.style.RelativeSizeSpan;
import com.tencent.neattextview.textview.b.c;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public abstract class b {
    private static final char[] zTE = new char[]{8230};
    private static final String zTF = new String(zTE);
    protected TextPaint gu;
    protected CharSequence mText;
    private float ucl;
    private ArrayList<a> zGd = new ArrayList();
    private int zGz = 0;
    protected String zTG;
    protected char[] zTH;
    protected float[] zTI;
    protected float[] zTJ;
    protected float[] zTK = new float[com.tencent.neattextview.textview.a.a.zTA.length];
    protected float[] zTL = new float[com.tencent.neattextview.textview.a.a.zTB.length];
    protected HashMap<Character, Float> zTM = new HashMap(com.tencent.neattextview.textview.a.a.zTA.length);
    public LinkedList<com.tencent.neattextview.textview.b.b> zTN = new LinkedList();
    private float zTO;
    private float zTP;
    private TextPaint zTQ = new TextPaint();
    private float[] zTR;
    d<ImageSpan> zTS = new d(ImageSpan.class);
    d<AbsoluteSizeSpan> zTT = new d(AbsoluteSizeSpan.class);
    d<RelativeSizeSpan> zTU = new d(RelativeSizeSpan.class);
    d<BackgroundColorSpan> zTV = new d(BackgroundColorSpan.class);
    d<ForegroundColorSpan> zTW = new d(ForegroundColorSpan.class);
    d<ClickableSpan> zTX = new d(ClickableSpan.class);
    private float zTY = 0.0f;
    public LinkedList<c> zTZ;
    protected boolean[] zUa;

    /* renamed from: com.tencent.neattextview.textview.layout.b$1 */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] zUb = new int[a.cDr().length];

        static {
            try {
                zUb[a.zUc - 1] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                zUb[a.zUd - 1] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                zUb[a.zUg - 1] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                zUb[a.zUe - 1] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                zUb[a.zUf - 1] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                zUb[a.zUh - 1] = 6;
            } catch (NoSuchFieldError e6) {
            }
        }
    }

    public enum a {
        ;

        public static int[] cDr() {
            return (int[]) zUi.clone();
        }

        static {
            zUc = 1;
            zUd = 2;
            zUe = 3;
            zUf = 4;
            zUg = 5;
            zUh = 6;
            zUi = new int[]{zUc, zUd, zUe, zUf, zUg, zUh};
        }
    }

    protected abstract void a(TextPaint textPaint, float f, int i, boolean z);

    public b(CharSequence charSequence, float[] fArr) {
        this.mText = charSequence;
        this.zTG = charSequence.toString();
        this.zTH = this.zTG.toCharArray();
        if (fArr != null) {
            this.zTI = new float[fArr.length];
            System.arraycopy(fArr, 0, this.zTI, 0, fArr.length);
        }
    }

    public final void a(TextPaint textPaint, float f, float f2, float f3, int i, TruncateAt truncateAt, boolean z) {
        this.gu = new TextPaint(textPaint);
        this.zTO = f2;
        this.ucl = f;
        this.zGz = i;
        this.zTP = f3;
        this.zTR = null;
        int length = this.mText.length();
        if (this.zTI == null) {
            this.zTI = new float[length];
            textPaint.getTextWidths(this.zTG, this.zTI);
        }
        this.zUa = new boolean[length];
        a(this.mText, textPaint, this.zUa);
        c(textPaint);
        a(textPaint, f, i, z);
        if (truncateAt != TruncateAt.MARQUEE) {
            if (this.mText == null || this.zGd.size() <= 0 || this.mText.length() <= ((a) this.zGd.get(this.zGd.size() - 1)).getEnd()) {
                length = 0;
            } else {
                length = 1;
            }
            if (length != 0) {
                float measureText = textPaint.measureText(zTF);
                length = (this.zGz == 1 && truncateAt == TruncateAt.MIDDLE) ? cDq() : truncateAt == TruncateAt.END ? ((a) this.zGd.get(this.zGd.size() - 1)).getEnd() - 1 : 0;
                this.zTI[length] = measureText;
                this.zTH[length] = zTE[0];
            }
        }
    }

    public final void a(Canvas canvas, float f, float f2) {
        canvas.save();
        canvas.translate(f, f2);
        float f3 = 0.0f;
        Iterator it = this.zTN.iterator();
        while (it.hasNext()) {
            ((com.tencent.neattextview.textview.b.b) it.next()).a(canvas, this.gu, this.zGd);
        }
        it = this.zGd.iterator();
        while (it.hasNext()) {
            a aVar = (a) it.next();
            aVar.a(canvas, this.gu, f3);
            f3 = aVar.getHeight() + f3;
        }
        canvas.restore();
    }

    protected final void a(char[] cArr, int i, int i2, float f, float[] fArr, float f2, boolean z) {
        FontMetrics fontMetrics = this.gu.getFontMetrics();
        float f3 = fontMetrics.bottom - fontMetrics.top;
        if (this.zTJ != null) {
            for (int i3 = i; i3 < i2; i3++) {
                if (f3 < this.zTJ[i3]) {
                    f3 = this.zTJ[i3];
                }
            }
        }
        float f4 = f3 + this.zTP;
        c cVar = new c(this, cArr, i, i2, this.zTY, fArr, f, f4, f2, this.gu, z);
        this.zTY += f4;
        this.zGd.add(cVar);
    }

    private void a(CharSequence charSequence, TextPaint textPaint, boolean[] zArr) {
        int length;
        int i;
        int i2;
        int i3;
        Object obj;
        int i4 = 0;
        if (charSequence instanceof Spanned) {
            Spanned spanned = (Spanned) charSequence;
            length = charSequence.length();
            this.zTS.a(spanned, length);
            this.zTT.a(spanned, length);
            this.zTU.a(spanned, length);
            this.zTW.a(spanned, length);
            this.zTV.a(spanned, length);
            this.zTX.a(spanned, length);
        }
        this.zTQ.set(textPaint);
        for (length = 0; length < this.zTT.zUu; length++) {
            ((AbsoluteSizeSpan[]) this.zTT.zUv)[length].updateMeasureState(this.zTQ);
            i = this.zTT.zUw[length];
            i2 = this.zTT.zUx[length];
            i3 = i2 - i;
            obj = new float[i3];
            this.zTQ.getTextWidths(charSequence, i, i2, obj);
            System.arraycopy(obj, 0, this.zTI, i, i3);
            if (this.zTJ == null) {
                this.zTJ = new float[charSequence.length()];
            }
            this.zTJ[i] = this.zTQ.getTextSize();
        }
        for (length = 0; length < this.zTU.zUu; length++) {
            ((RelativeSizeSpan[]) this.zTU.zUv)[length].updateMeasureState(this.zTQ);
            i = this.zTU.zUw[length];
            i2 = this.zTU.zUx[length];
            i3 = i2 - i;
            obj = new float[i3];
            this.zTQ.getTextWidths(charSequence, i, i2, obj);
            System.arraycopy(obj, 0, this.zTI, i, i3);
            if (this.zTJ == null) {
                this.zTJ = new float[charSequence.length()];
            }
            this.zTJ[i] = this.zTQ.getTextSize();
        }
        for (length = 0; length < this.zTS.zUu; length++) {
            ImageSpan imageSpan = ((ImageSpan[]) this.zTS.zUv)[length];
            i2 = this.zTS.zUw[length];
            i3 = this.zTS.zUx[length] - i2;
            Drawable drawable = imageSpan.getDrawable();
            Rect rect = new Rect();
            if (drawable != null) {
                rect.set(drawable.getBounds());
            }
            this.zTI[i2] = (float) rect.width();
            zArr[i2] = true;
            for (i = i2 + 1; i < i2 + i3; i++) {
                this.zTI[i] = 0.0f;
                zArr[i] = true;
            }
            if (this.zTJ == null) {
                this.zTJ = new float[charSequence.length()];
            }
            this.zTJ[i2] = (float) rect.height();
        }
        for (length = 0; length < this.zTV.zUu; length++) {
            CharacterStyle characterStyle = ((BackgroundColorSpan[]) this.zTV.zUv)[length];
            this.zTN.add(new com.tencent.neattextview.textview.b.a(this.zTV.zUw[length], this.zTV.zUx[length], characterStyle));
        }
        while (i4 < this.zTX.zUu) {
            ClickableSpan clickableSpan = ((ClickableSpan[]) this.zTX.zUv)[i4];
            this.zTN.add(new c(this.zTX.zUw[i4], this.zTX.zUx[i4], clickableSpan));
            i4++;
        }
    }

    public final float[] cDn() {
        float f = 0.0f;
        if (this.zTR == null) {
            float f2;
            Iterator it = this.zGd.iterator();
            float f3 = 0.0f;
            while (true) {
                f2 = f;
                if (!it.hasNext()) {
                    break;
                }
                a aVar = (a) it.next();
                if (f3 < aVar.getWidth()) {
                    f3 = aVar.getWidth();
                }
                f = aVar.getHeight() + f2;
            }
            this.zTR = new float[]{f3, f2};
        }
        return this.zTR;
    }

    public final TextPaint cDo() {
        return this.gu;
    }

    private void c(Paint paint) {
        this.zTM.clear();
        Rect rect = new Rect();
        int i = 0;
        for (char c : com.tencent.neattextview.textview.a.a.zTA) {
            float measureText = paint.measureText(String.valueOf(c));
            paint.getTextBounds(String.valueOf(c), 0, 1, rect);
            this.zTK[i] = measureText - ((float) rect.right);
            i++;
        }
        int i2 = 0;
        for (char valueOf : com.tencent.neattextview.textview.a.a.zTB) {
            paint.getTextBounds(String.valueOf(valueOf), 0, 1, rect);
            float f = rect.left > 0 ? (float) rect.left : 0.0f;
            this.zTL[i2] = f;
            this.zTM.put(Character.valueOf(com.tencent.neattextview.textview.a.a.zTB[i2]), Float.valueOf(f));
            i2++;
        }
    }

    public final HashMap<Character, Float> cDp() {
        return this.zTM;
    }

    private int cDq() {
        float f = 0.0f;
        a aVar = (a) this.zGd.get(0);
        for (int start = aVar.getStart(); start < aVar.getEnd(); start++) {
            f += this.zTI[start];
            if (f >= this.ucl / 2.0f) {
                return start;
            }
        }
        return 0;
    }
}
