package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint.Align;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.smtt.sdk.WebView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class QTextView extends View {
    private static HashMap<String, a> rCk = new HashMap();
    private Context context;
    private TextPaint gu;
    private String kav = "";
    int nDk;
    private int rCd;
    String rCe;
    String rCf;
    private boolean rCg;
    private int rCh;
    private boolean rCi;
    boolean rCj;
    private a rCl;
    private a rCm;
    int rCn = 0;
    private int textSize = -1;

    private static class a {
        private static HashMap<String, Integer> rCt = new HashMap();
        private String aAM = "";
        private int rCn = 0;
        boolean rCo = false;
        ArrayList<int[]> rCp = new ArrayList();
        float rCq;
        float rCr;
        float rCs;

        public final int a(String str, String str2, String str3, int i, int i2, TextPaint textPaint) {
            String str4 = str + str2 + str3 + i + i2;
            if (str4.equals(this.aAM)) {
                return this.rCn;
            }
            this.aAM = str4;
            this.rCp.clear();
            this.rCo = false;
            this.rCq = 0.0f;
            this.rCr = 0.0f;
            this.rCs = 0.0f;
            if (i2 == -1) {
                this.rCp.add(new int[]{null, str.length()});
                this.rCn = (int) (textPaint.measureText(str) + 0.5f);
                return this.rCn;
            }
            if (str2 != null) {
                this.rCr = textPaint.measureText(str2);
            }
            if (str3 != null) {
                this.rCs = textPaint.measureText(str3);
            }
            int i3 = -1;
            float f = 0.0f;
            Object obj = 1;
            int i4 = 0;
            while (i4 < str.length()) {
                if (i3 == -1) {
                    i3 = i4;
                }
                if (this.rCp.size() == i) {
                    this.rCo = true;
                    break;
                }
                int i5;
                Object obj2;
                float measureText = textPaint.measureText(str.charAt(i4));
                Object obj3 = null;
                if (str.charAt(i4) == 10) {
                    this.rCp.add(new int[]{i3, i4 - 1});
                    i5 = i4;
                    obj2 = 1;
                } else {
                    if (f + measureText >= ((float) i2)) {
                        obj3 = 1;
                        if (str.charAt(i4) == ' ' || obj == null) {
                            i4--;
                            this.rCp.add(new int[]{i3, i4});
                            i5 = i4;
                            i4 = 1;
                        } else {
                            while (str.charAt(i4) != ' ') {
                                i4--;
                                if (i4 == 0) {
                                    break;
                                }
                            }
                            this.rCp.add(new int[]{i3, i4});
                        }
                    }
                    Object obj4 = obj3;
                    i5 = i4;
                    obj2 = obj4;
                }
                if (obj2 != null) {
                    i3 = -1;
                    f = 0.0f;
                    if (this.rCp.size() == i - 1) {
                        i2 = (int) (((float) i2) - (this.rCr + this.rCs));
                        obj = null;
                    }
                } else {
                    f += measureText;
                    if (i5 == str.length() - 1) {
                        this.rCp.add(new int[]{i3, i5});
                    }
                }
                i4 = i5 + 1;
            }
            if (this.rCo) {
                int[] iArr = (int[]) this.rCp.get(this.rCp.size() - 1);
                this.rCq = textPaint.measureText(str.substring(iArr[0], iArr[1] + 1));
            }
            if (this.rCp.size() == 0) {
                this.rCn = 0;
                return this.rCn;
            } else if (this.rCp.size() == 1) {
                this.rCn = (int) (textPaint.measureText(str) + 0.5f);
                return this.rCn;
            } else {
                this.rCn = i2;
                return this.rCn;
            }
        }
    }

    public QTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.context = context;
        init();
    }

    public QTextView(Context context) {
        super(context);
        this.context = context;
        init();
    }

    private void init() {
        this.rCj = false;
        this.rCg = true;
        this.rCi = false;
        this.nDk = -1;
        this.rCe = "...";
        this.rCf = "";
        this.rCh = -16776961;
        this.rCl = new a();
        this.rCm = new a();
        this.gu = new TextPaint();
        this.gu.setAntiAlias(true);
        if (this.textSize == -1) {
            this.textSize = b.b(this.context, 12.0f);
            this.gu.setTextSize((float) this.textSize);
        } else {
            this.gu.setTextSize(13.0f);
        }
        this.gu.setColor(WebView.NIGHT_MODE_COLOR);
        this.gu.setTextAlign(Align.LEFT);
    }

    public final void setText(String str) {
        if (bi.oN(this.kav)) {
            this.kav = "";
        }
        this.kav = str;
        this.rCl.aAM = "";
        this.rCm.aAM = "";
        requestLayout();
        invalidate();
    }

    protected void onMeasure(int i, int i2) {
        int i3;
        int mode = MeasureSpec.getMode(i);
        int size = MeasureSpec.getSize(i);
        if (mode == 1073741824) {
            xR(size);
        } else if (mode == Integer.MIN_VALUE) {
            size = Math.min(xR(size), size);
        } else {
            xR(size);
            size = 0;
        }
        int mode2 = MeasureSpec.getMode(i2);
        mode = MeasureSpec.getSize(i2);
        this.rCd = (int) this.gu.ascent();
        if (mode2 == 1073741824) {
            i3 = mode;
        } else {
            i3 = (((this.rCj ? this.rCl.rCp.size() : this.rCm.rCp.size()) * ((int) (((float) (-this.rCd)) + this.gu.descent()))) + getPaddingTop()) + getPaddingBottom();
            if (mode2 == Integer.MIN_VALUE) {
                i3 = Math.min(i3, mode);
            }
        }
        setMeasuredDimension(size, i3);
    }

    protected void onDraw(Canvas canvas) {
        a aVar;
        List list;
        super.onDraw(canvas);
        if (this.rCj) {
            aVar = this.rCl;
            list = this.rCl.rCp;
        } else {
            aVar = this.rCm;
            Object list2 = this.rCm.rCp;
        }
        float paddingLeft = (float) getPaddingLeft();
        float paddingTop = (float) (getPaddingTop() + (-this.rCd));
        int i = 0;
        while (i < list2.size()) {
            int[] iArr = (int[]) list2.get(i);
            canvas.drawText(this.kav, iArr[0], iArr[1] + 1, paddingLeft, paddingTop, this.gu);
            if (i == list2.size() - 1 && aVar.rCo) {
                canvas.drawText(this.rCe, aVar.rCq + paddingLeft, paddingTop, this.gu);
                if (this.rCg) {
                    int color = this.gu.getColor();
                    this.gu.setColor(this.rCh);
                    if (this.rCi) {
                        canvas.drawText(this.rCf, ((float) canvas.getWidth()) - ((aVar.rCs + ((float) getPaddingRight())) + ((float) getPaddingLeft())), paddingTop, this.gu);
                    } else {
                        canvas.drawText(this.rCf, (aVar.rCq + aVar.rCr) + paddingLeft, paddingTop, this.gu);
                    }
                    this.gu.setColor(color);
                }
            }
            paddingTop += ((float) (-this.rCd)) + this.gu.descent();
            if (paddingTop <= ((float) canvas.getHeight())) {
                i++;
            } else {
                return;
            }
        }
    }

    private int xR(int i) {
        if (this.rCj) {
            if (bi.oN(this.rCl.aAM)) {
                this.rCn = this.rCl.a(this.kav, null, null, -1, (i - getPaddingLeft()) - getPaddingRight(), this.gu);
            }
        } else if (bi.oN(this.rCm.aAM)) {
            this.rCn = this.rCm.a(this.kav, this.rCe, this.rCf, this.nDk, (i - getPaddingLeft()) - getPaddingRight(), this.gu);
        }
        return (this.rCn + getPaddingLeft()) + getPaddingRight();
    }
}
