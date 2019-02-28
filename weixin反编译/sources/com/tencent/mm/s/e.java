package com.tencent.mm.s;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.text.SpannableString;
import android.text.TextPaint;
import android.widget.TextView;
import com.tencent.mm.bi.a.c;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.sdk.platformtools.ad;

public final class e extends c {
    private static final float gPM = ad.getResources().getDimension(c.vhN);
    private static final int gPN = ((int) ad.getResources().getDimension(c.vhT));
    private static final int gPO = ((int) ad.getResources().getDimension(c.vhU));
    private static TextPaint gu;
    public SpannableString gPP;
    public int su = -1;

    static {
        TextPaint textPaint = new TextPaint(1);
        gu = textPaint;
        textPaint.setStrokeCap(Cap.ROUND);
        gu.setStyle(Style.FILL);
        gu.setDither(true);
        gu.setTextSize(gPM);
    }

    public e(Context context, Matrix matrix, String str, Rect rect, SpannableString spannableString, int i) {
        super(context, matrix, str, rect);
        this.su = i;
        this.gPP = spannableString;
    }

    protected final Bitmap BR() {
        gu.setColor(this.su);
        if (this.gPP == null) {
            return null;
        }
        TextView textView = new TextView(this.mContext);
        textView.setTextSize((float) Math.round(gPM / this.mContext.getResources().getDisplayMetrics().density));
        textView.setText(i.b(this.mContext, this.gPP, gPM / 1.3f));
        textView.setSingleLine(false);
        textView.setMaxWidth((int) (((float) this.mContext.getResources().getDisplayMetrics().widthPixels) - (this.mContext.getResources().getDimension(c.vhM) * 2.0f)));
        textView.measure(0, 0);
        Bitmap createBitmap = Bitmap.createBitmap(textView.getMeasuredWidth(), textView.getMeasuredHeight(), Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        textView.getLayout().getPaint().setColor(this.su);
        textView.getLayout().draw(canvas);
        return createBitmap;
    }

    public final void setSelected(boolean z) {
        super.setSelected(z);
        if (!z) {
            this.gPx = false;
        }
    }
}
