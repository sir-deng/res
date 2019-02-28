package com.tencent.mm.plugin.wenote.model.nativenote.spans;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.drawable.Drawable;
import android.support.v4.content.a;
import android.text.Layout;
import android.text.Spannable;
import android.text.Spanned;
import android.text.style.LeadingMarginSpan;
import android.view.MotionEvent;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.wenote.model.a.b;
import com.tencent.mm.plugin.wenote.model.a.h;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.WXRTEditText;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.ref.WeakReference;

public class k implements LeadingMarginSpan, f<Boolean>, g<Boolean> {
    private int uca;
    public boolean ucb;
    public boolean uce = false;
    public boolean ucf = false;
    public boolean ucg = false;
    public boolean uch = false;
    private WeakReference<Drawable> uci;

    public final /* synthetic */ f bYj() {
        return bYl();
    }

    public final /* bridge */ /* synthetic */ Object getValue() {
        return Boolean.TRUE;
    }

    public k(boolean z, int i, boolean z2, boolean z3, boolean z4) {
        boolean z5 = false;
        this.uca = i;
        if (z2 && z4 && !z3) {
            z5 = true;
        }
        this.ucb = z5;
        this.uch = z;
        this.uce = z3;
        this.ucf = z4;
        this.ucg = z2;
    }

    public int getLeadingMargin(boolean z) {
        return this.ucb ? 0 : this.uca;
    }

    public void drawLeadingMargin(Canvas canvas, Paint paint, int i, int i2, int i3, int i4, int i5, CharSequence charSequence, int i6, int i7, boolean z, Layout layout) {
        Spanned spanned = (Spanned) charSequence;
        if (!this.ucb && spanned.getSpanStart(this) == i6) {
            WeakReference weakReference = this.uci;
            Drawable drawable = null;
            if (weakReference != null) {
                drawable = (Drawable) weakReference.get();
            }
            if (drawable == null) {
                drawable = this.uch ? a.b(ad.getContext(), R.g.bEo) : a.b(ad.getContext(), R.g.bEp);
                this.uci = new WeakReference(drawable);
            }
            if (drawable != null) {
                drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                canvas.save();
                FontMetricsInt fontMetricsInt = paint.getFontMetricsInt();
                canvas.translate(0.0f, (float) (((fontMetricsInt.ascent + ((fontMetricsInt.descent + i4) + i4)) / 2) - (drawable.getBounds().bottom / 2)));
                drawable.draw(canvas);
                canvas.restore();
            }
        }
    }

    private k bYl() {
        return new k(this.uch, this.uca, this.ucg, this.uce, this.ucf);
    }

    public final void a(TextView textView, Spannable spannable, MotionEvent motionEvent, k kVar) {
        if (motionEvent.getX() > ((float) this.uca)) {
            x.e("MicroMsg.NoteTodoSpan", "x > mGapWidth");
            return;
        }
        boolean z;
        int spanStart = spannable.getSpanStart(kVar);
        int spanEnd = spannable.getSpanEnd(kVar);
        String str = "MicroMsg.NoteTodoSpan";
        String str2 = "current mIsTodoCheck: %s";
        Object[] objArr = new Object[1];
        objArr[0] = this.uch ? "true" : "false";
        x.i(str, str2, objArr);
        spannable.removeSpan(this);
        if (this.uch) {
            z = false;
        } else {
            z = true;
        }
        this.uch = z;
        spannable.setSpan(bYl(), spanStart, spanEnd, 33);
        WXRTEditText wXRTEditText = (WXRTEditText) textView;
        if (wXRTEditText.tZU == 0) {
            b BL = c.bXc().BL(wXRTEditText.bXB());
            if (BL != null && BL.getType() == 1) {
                ((h) BL).content = com.tencent.mm.plugin.wenote.model.nativenote.a.b.a(spannable);
            }
        }
    }
}
