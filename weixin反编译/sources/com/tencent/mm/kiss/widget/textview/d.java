package com.tencent.mm.kiss.widget.textview;

import android.annotation.TargetApi;
import android.graphics.Typeface;
import android.os.Build.VERSION;
import android.text.InputFilter.LengthFilter;
import android.text.Layout.Alignment;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.TextUtils.TruncateAt;
import android.text.style.MetricAffectingSpan;
import com.tencent.mm.kiss.widget.textview.a.a;
import com.tencent.mm.sdk.platformtools.x;

public final class d {
    private static e gVg = new e();
    private static final SpannableString gVh = new SpannableString("");
    CharSequence gVi = null;
    CharSequence gVj = null;
    int gVk = 0;
    int gVl = 0;
    TextPaint gVm = null;
    Alignment gVn = Alignment.ALIGN_NORMAL;
    TruncateAt gVo = null;
    int gVp = -1;
    TextDirectionHeuristic gVq = null;
    float gVr = 0.0f;
    float gVs = 1.0f;
    boolean gVt = false;
    LengthFilter gVu = null;
    int gravity = 51;
    int maxLength = -1;
    int maxLines = Integer.MAX_VALUE;
    int width = 0;

    public static d a(CharSequence charSequence, int i, a aVar) {
        boolean z = false;
        if (charSequence == null) {
            charSequence = "";
        }
        int length = charSequence.length();
        if (charSequence == null) {
            charSequence = "";
        }
        d Ek = gVg.Ek();
        if (Ek == null) {
            Ek = new d();
        }
        Ek.gVi = charSequence.toString();
        Ek.gVj = charSequence;
        Ek.gVk = 0;
        Ek.gVl = length;
        Ek.width = i;
        Ek.gVm = new TextPaint();
        if (aVar.maxLines != -1) {
            length = aVar.maxLines;
            if (length >= 0) {
                Ek.maxLines = length;
            }
        }
        if (aVar.maxLength != -1) {
            length = aVar.maxLength;
            if (length >= 0) {
                Ek.maxLength = length;
                Ek.gVu = new LengthFilter(Ek.maxLength);
            }
        }
        Alignment alignment = aVar.gVn;
        if (alignment != null) {
            Ek.gVn = alignment;
        }
        if (aVar.gVo != null) {
            TruncateAt truncateAt = aVar.gVo;
            if (truncateAt != null) {
                Ek.gVo = truncateAt;
            }
        }
        Ek.gravity = aVar.gravity;
        if (aVar.gVQ != -1) {
            length = aVar.gVQ;
            if (length >= 0) {
                Ek.gVp = length;
            }
        }
        if (aVar.gVq != null) {
            TextDirectionHeuristic textDirectionHeuristic = aVar.gVq;
            if (VERSION.SDK_INT >= 18) {
                Ek.gVq = textDirectionHeuristic;
            }
        }
        float f = aVar.gVr;
        float f2 = aVar.gVs;
        Ek.gVr = f;
        Ek.gVs = f2;
        Ek.gVt = aVar.gVt;
        if (aVar.boj != null) {
            if (aVar.gVR != -1) {
                Typeface typeface = aVar.boj;
                int i2 = aVar.gVR;
                if (i2 > 0) {
                    typeface = typeface == null ? Typeface.defaultFromStyle(i2) : Typeface.create(typeface, i2);
                    Ek.a(typeface);
                    length = ((typeface != null ? typeface.getStyle() : 0) ^ -1) & i2;
                    TextPaint textPaint = Ek.gVm;
                    if ((length & 1) != 0) {
                        z = true;
                    }
                    textPaint.setFakeBoldText(z);
                    Ek.gVm.setTextSkewX((length & 2) != 0 ? -0.25f : 0.0f);
                } else {
                    Ek.gVm.setFakeBoldText(false);
                    Ek.gVm.setTextSkewX(0.0f);
                    Ek.a(typeface);
                }
            } else {
                Ek.a(aVar.boj);
            }
        }
        if (aVar.gVS != -1.0f) {
            Ek.gVm.setTextSize(aVar.gVS);
        }
        if (aVar.textColor != -1) {
            Ek.gVm.setColor(aVar.textColor);
        }
        if (aVar.linkColor != -1) {
            Ek.gVm.linkColor = aVar.linkColor;
        }
        if (aVar.gVy != null) {
            Ek.gVm = aVar.gVy;
        }
        return Ek;
    }

    private d a(Typeface typeface) {
        this.gVm.setTypeface(typeface);
        return this;
    }

    @TargetApi(18)
    public final f Ej() {
        int i;
        boolean z;
        StaticLayout a;
        if (this.gVo == null || this.gVp <= 0) {
            i = this.width;
        } else {
            i = this.gVp;
        }
        if (this.gVo == null && this.maxLines == 1) {
            this.gVo = TruncateAt.END;
        }
        if (this.maxLength > 0 && this.gVu != null) {
            CharSequence filter = this.gVu.filter(this.gVj, 0, this.gVj.length(), gVh, 0, 0);
            if (filter != null) {
                this.gVj = filter;
                if (this.gVl > this.gVj.length()) {
                    this.gVl = this.gVj.length();
                }
            }
        }
        if (h.DEBUG) {
            x.i("StaticTextView.StaticLayoutBuilder", "StaticLayoutWrapper build " + this.gVj + " " + this.width);
        }
        if (this.gVn == Alignment.ALIGN_NORMAL) {
            switch (this.gravity & 8388615) {
                case 1:
                    this.gVn = Alignment.ALIGN_CENTER;
                    break;
                case 3:
                case 8388611:
                    this.gVn = Alignment.ALIGN_NORMAL;
                    break;
                case 5:
                case 8388613:
                    this.gVn = Alignment.ALIGN_OPPOSITE;
                    break;
                default:
                    this.gVn = Alignment.ALIGN_NORMAL;
                    break;
            }
        }
        this.gVm.setAntiAlias(true);
        StaticLayout staticLayout = null;
        if ((this.gVq == null || (com.tencent.mm.compatible.util.d.fN(18) && this.gVq == TextDirectionHeuristics.FIRSTSTRONG_LTR)) && (this.maxLines == Integer.MAX_VALUE || this.maxLines == -1)) {
            z = true;
        } else {
            z = false;
        }
        try {
            a = a(this.gVj, z, i);
        } catch (Exception e) {
            x.i("StaticTextView.StaticLayoutBuilder", "build static layout error: %s", e.getMessage());
            int i2 = 0;
            while (i2 < 3) {
                try {
                    CharSequence spannableStringBuilder = new SpannableStringBuilder(this.gVj);
                    MetricAffectingSpan[] metricAffectingSpanArr = (MetricAffectingSpan[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), MetricAffectingSpan.class);
                    if (metricAffectingSpanArr == null || metricAffectingSpanArr.length <= 0) {
                        i2 = 100;
                    } else {
                        spannableStringBuilder.insert(spannableStringBuilder.getSpanStart(metricAffectingSpanArr[0]) - 1, " ");
                        i2++;
                    }
                    this.gVj = spannableStringBuilder;
                    staticLayout = a(this.gVj, z, i);
                    x.i("StaticTextView.StaticLayoutBuilder", "fix from build static layout, fixCount: %s", Integer.valueOf(i2));
                    a = staticLayout;
                } catch (Exception e2) {
                    x.i("StaticTextView.StaticLayoutBuilder", "fix, build static layout error: %s, fixCount: %s", e2.getMessage(), Integer.valueOf(i2));
                }
            }
            a = staticLayout;
        }
        if (a == null) {
            this.gVj = this.gVj.toString();
            a = a(this.gVj, z, i);
        }
        f fVar = new f(a);
        fVar.gVx = this.gVi;
        fVar.text = this.gVj;
        fVar.maxLength = this.maxLength;
        fVar.maxLines = this.maxLines;
        fVar.gVn = this.gVn;
        fVar.gVo = this.gVo;
        fVar.gVy = this.gVm;
        fVar.gravity = this.gravity;
        gVg.a(this);
        return fVar;
    }

    private StaticLayout a(CharSequence charSequence, boolean z, int i) {
        if (z) {
            return new StaticLayout(charSequence, this.gVk, this.gVl, this.gVm, this.width, this.gVn, this.gVs, this.gVr, this.gVt, this.gVo, i);
        } else if (VERSION.SDK_INT >= 18) {
            if (this.gVq == null) {
                this.gVq = TextDirectionHeuristics.FIRSTSTRONG_LTR;
            }
            return com.tencent.mm.kiss.widget.textview.b.a.a(charSequence, this.gVk, this.gVl, this.gVm, this.width, this.gVn, this.gVq, this.gVs, this.gVr, this.gVt, this.gVo, i, this.maxLines);
        } else {
            return com.tencent.mm.kiss.widget.textview.b.a.a(charSequence, this.gVk, this.gVl, this.gVm, this.width, this.gVn, this.gVs, this.gVr, this.gVt, this.gVo, i, this.maxLines);
        }
    }
}
