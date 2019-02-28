package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint.Align;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.smtt.sdk.WebView;
import java.util.ArrayList;
import java.util.List;

public class TextViewMultilineEllipse extends View {
    private Context context;
    private TextPaint gu;
    private String kav;
    private int nDk;
    private int rCd;
    private String rCe;
    private String rCf;
    private boolean rCg;
    private int rCh;
    private boolean rCi;
    private boolean rCj;
    private a rSi;
    private a rSj;
    private int textSize = -1;

    private static class a {
        boolean rCo = false;
        ArrayList<int[]> rCp = new ArrayList();
        float rCq;
        float rCr;
        float rCs;

        public final int a(String str, String str2, String str3, int i, int i2, TextPaint textPaint) {
            this.rCp.clear();
            this.rCo = false;
            this.rCq = 0.0f;
            this.rCr = 0.0f;
            this.rCs = 0.0f;
            if (i2 == -1) {
                this.rCp.add(new int[]{null, str.length()});
                return (int) (textPaint.measureText(str) + 0.5f);
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
                return 0;
            }
            if (this.rCp.size() == 1) {
                return (int) (textPaint.measureText(str) + 0.5f);
            }
            return i2;
        }
    }

    public TextViewMultilineEllipse(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.context = context;
        this.rCj = false;
        this.rCg = true;
        this.rCi = false;
        this.nDk = -1;
        this.rCe = "...";
        this.rCf = "";
        this.rCh = -16776961;
        this.rSi = new a();
        this.rSj = new a();
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
            i3 = (((this.rCj ? this.rSi.rCp.size() : this.rSj.rCp.size()) * ((int) (((float) (-this.rCd)) + this.gu.descent()))) + getPaddingTop()) + getPaddingBottom();
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
            aVar = this.rSi;
            list = this.rSi.rCp;
        } else {
            aVar = this.rSj;
            Object list2 = this.rSj.rCp;
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
        int a;
        if (this.rCj) {
            a = this.rSi.a(this.kav, null, null, -1, (i - getPaddingLeft()) - getPaddingRight(), this.gu);
        } else {
            a = this.rSj.a(this.kav, this.rCe, this.rCf, this.nDk, (i - getPaddingLeft()) - getPaddingRight(), this.gu);
        }
        return (a + getPaddingLeft()) + getPaddingRight();
    }
}
