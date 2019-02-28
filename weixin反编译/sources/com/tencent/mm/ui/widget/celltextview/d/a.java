package com.tencent.mm.ui.widget.celltextview.d;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.View.MeasureSpec;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.widget.celltextview.c.b;
import com.tencent.mm.ui.widget.celltextview.c.c;
import com.tencent.mm.ui.widget.celltextview.c.d;
import com.tencent.smtt.sdk.WebView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class a implements com.tencent.mm.ui.widget.celltextview.b.a.a {
    private int KD;
    private int et;
    private int eu;
    private int iX;
    private TextPaint kfD;
    private Context mContext;
    private float nDj;
    private int vxz;
    private int yg = WebView.NIGHT_MODE_COLOR;
    private int ypi;
    private ArrayList<d> zFX;
    private LinkedList<b> zFY;
    private int zGA;
    private int zGB;
    private float zGC;
    private boolean zGD = true;
    private CharSequence zGE;
    private int zGF;
    private int zGG;
    private int zGH;
    private int zGI;
    private int zGJ = -16776961;
    private boolean zGK = true;
    private Drawable zGL;
    private int zGM;
    private LinkedList<a> zGN;
    private LinkedList<a> zGO;
    private b zGP;
    int zGQ = 0;
    private int zGR;
    private ArrayList<c> zGd;
    private float zGe;
    private com.tencent.mm.ui.widget.celltextview.b.a.b zGx;
    private com.tencent.mm.ui.widget.celltextview.f.a zGy;
    private int zGz = Integer.MAX_VALUE;

    private class a {
        int zGS;
        Rect zGT;

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || !(obj instanceof a)) {
                return false;
            }
            if (this.zGS != ((a) obj).zGS) {
                return false;
            }
            return true;
        }
    }

    public final /* bridge */ /* synthetic */ Paint getPaint() {
        return this.kfD;
    }

    public a(Context context, TextPaint textPaint) {
        this.mContext = context;
        this.zGd = new ArrayList();
        this.zGy = new com.tencent.mm.ui.widget.celltextview.f.b();
        this.nDj = com.tencent.mm.ui.widget.celltextview.g.b.i(context, 14.0f);
        this.zGI = (int) com.tencent.mm.ui.widget.celltextview.g.b.i(context, 6.0f);
        this.kfD = textPaint;
        this.kfD.setColor(this.yg);
        this.kfD.setTextSize(this.nDj);
    }

    public final void onMeasure(int i, int i2) {
        if (this.zGD) {
            Object obj;
            c cVar;
            float f;
            float f2;
            float f3;
            this.zGD = false;
            int mode = MeasureSpec.getMode(i);
            int mode2 = MeasureSpec.getMode(i2);
            int size = MeasureSpec.getSize(i);
            int size2 = MeasureSpec.getSize(i2);
            if (size <= 0) {
                Context context = this.mContext;
                size = context == null ? 0 : context.getResources().getDisplayMetrics().widthPixels;
            }
            if (this.iX > 0 && this.iX < r2) {
                size = this.iX;
            }
            int i3 = (this.KD <= 0 || this.KD <= size) ? size : this.KD;
            size = (this.vxz <= 0 || this.vxz >= size2) ? size2 : this.vxz;
            int i4 = (this.zGA <= 0 || this.zGA <= size) ? size : this.zGA;
            int aD = aD(this.zGN) + aD(this.zGO);
            int i5 = ((i3 - aD) - this.zGF) - this.zGG;
            if (this.zGK) {
                com.tencent.mm.ui.widget.celltextview.a.b cAa = com.tencent.mm.ui.widget.celltextview.a.b.cAa();
                ArrayList arrayList = this.zFX;
                CharSequence charSequence = this.zGE;
                com.tencent.mm.ui.widget.celltextview.a.a aVar = new com.tencent.mm.ui.widget.celltextview.a.a(charSequence == null ? "" : charSequence.toString(), this.nDj, (float) i5);
                aVar.am(arrayList);
                com.tencent.mm.ui.widget.celltextview.a.a aVar2 = (com.tencent.mm.ui.widget.celltextview.a.a) cAa.zGh.get(aVar);
                if (aVar2 != null) {
                    ArrayList arrayList2 = this.zFX;
                    if (!(aVar2.zFX == null || arrayList2 == null)) {
                        arrayList2.clear();
                        arrayList2.addAll(aVar2.zFX);
                    }
                    arrayList2 = this.zGd;
                    if (!(aVar2.zGd == null || arrayList2 == null)) {
                        arrayList2.clear();
                        arrayList2.addAll(aVar2.zGd);
                    }
                    obj = 1;
                    cAk();
                } else {
                    obj = null;
                    HB(i5);
                    com.tencent.mm.ui.widget.celltextview.a.b.cAa().a(this.zGE, this.nDj, (float) i5, this.zGd, this.zFX);
                }
            } else {
                obj = null;
                HB(i5);
                com.tencent.mm.ui.widget.celltextview.a.b.cAa().a(this.zGE, this.nDj, (float) i5, this.zGd, this.zFX);
            }
            this.zGB = this.zGd.size();
            if (obj == null) {
                float f4 = (float) i5;
                float b = this.zGy.b(this.kfD);
                Iterator it = this.zGd.iterator();
                size2 = -1;
                while (it.hasNext()) {
                    cVar = (c) it.next();
                    size2++;
                    int size3 = cVar.getSize();
                    RectF Hz = cVar.Hz(size3 - 1);
                    float f5 = f4 - (Hz == null ? 0.0f : Hz.right);
                    if (f5 != 0.0f && Math.abs(f5) <= b) {
                        int i6;
                        int i7 = -1;
                        for (i6 = 0; i6 < size3; i6++) {
                            d Hy = cVar.Hy(i6);
                            i7 = Hy.getType() == 2 ? i7 + 1 : i7 + Hy.getLength();
                        }
                        f = i7 == 0 ? 0.0f : f5 / ((float) i7);
                        f2 = 0.0f;
                        int i8 = 0;
                        while (true) {
                            int i9 = i8;
                            f5 = f2;
                            if (i9 >= size3) {
                                break;
                            }
                            RectF Hz2 = cVar.Hz(i9);
                            d Hy2 = cVar.Hy(i9);
                            i6 = Hy2.getLength();
                            if (Hy2.getType() == 2) {
                                i6 = 1;
                            }
                            float width = Hz2.width();
                            Hz2.left = f5;
                            Hz2.right = (((float) i6) * f) + (width + f5);
                            f2 = Hz2.width() + f5;
                            i8 = i9 + 1;
                        }
                        cVar.zGo = f5;
                        cVar.zGs = f;
                        String str = "CellLayout";
                        String str2 = "[adaptLetterSpacing] line:%s size:%s letterSpacing:%s textSize:%s lineRight:%s";
                        Object[] objArr = new Object[5];
                        objArr[0] = Integer.valueOf(size2);
                        objArr[1] = Integer.valueOf(size3);
                        objArr[2] = Float.valueOf(f);
                        objArr[3] = Float.valueOf(b);
                        objArr[4] = Float.valueOf(Hz == null ? 0.0f : Hz.right);
                        x.i(str, str2, objArr);
                    }
                }
                cAk();
            }
            f = (float) i5;
            f2 = (float) cAh();
            float f6 = 0.0f;
            Iterator it2 = this.zGd.iterator();
            while (true) {
                f3 = f6;
                if (!it2.hasNext()) {
                    break;
                }
                cVar = (c) it2.next();
                if (cVar.zGo > f3) {
                    x.i("CellLayout", "[getEdgeWidth] MeasuredLine:%s", Float.valueOf(cVar.zGo));
                    f6 = cVar.zGo;
                } else {
                    f6 = f3;
                }
            }
            if (mode == 1073741824) {
                this.zGe = (float) i3;
                f6 = f;
            } else {
                f6 = Math.min((float) i5, f3);
                this.zGe = ((((float) this.zGF) + f6) + ((float) this.zGG)) + ((float) aD);
            }
            if (mode2 == 1073741824) {
                this.zGC = (float) i4;
            } else {
                this.zGC = Math.max((float) this.zGM, ((float) (this.et + this.eu)) + f2);
            }
            this.zGe = Math.max(this.zGe, (float) this.KD);
            this.zGC = Math.max(this.zGC, (float) this.zGA);
            if (this.iX > 0) {
                this.zGe = Math.min(this.zGe, (float) this.iX);
            }
            if (this.vxz > 0) {
                this.zGC = Math.min(this.zGC, (float) this.vxz);
            }
            x.i("CellLayout", String.format("[measureImpl] adaptWidth:%s mMeasuredWidth:%s mMeasuredHeight:%s", new Object[]{Float.valueOf(f6), Float.valueOf(this.zGe), Float.valueOf(this.zGC)}));
        }
    }

    public final void onDraw(Canvas canvas) {
        canvas.save();
        float cAh = (float) cAh();
        if (this.zGH == 80) {
            canvas.translate((float) aD(this.zGN), this.zGC - cAh);
        } else if (this.zGH == 3) {
            canvas.translate((float) (this.zGF + aD(this.zGN)), (this.zGC - cAh) / 2.0f);
        } else if (this.zGH == 16) {
            canvas.translate((float) (this.zGF + aD(this.zGN)), (this.zGC - cAh) / 2.0f);
        }
        if (this.zGP != null) {
            b bVar = this.zGP;
            Iterator it = bVar.zGl.iterator();
            while (it.hasNext()) {
                RectF rectF = (RectF) it.next();
                canvas.save();
                canvas.clipRect(rectF);
                canvas.drawColor(bVar.jmw);
                canvas.restore();
            }
        }
        int size = this.zGd.size();
        for (int i = 0; i < size; i++) {
            c cVar = (c) this.zGd.get(i);
            int size2 = cVar.getSize();
            canvas.save();
            if (this.zGH == 1 || this.zGH == 17) {
                float f = (this.zGe - cVar.zGo) / 2.0f;
                cVar.zGt = f;
                canvas.translate(f, 0.0f);
            }
            for (int i2 = 0; i2 < size2; i2++) {
                cVar.Hy(i2).a(canvas, cVar.Hz(i2), cVar.zGs, this.zGy.b(this.kfD));
            }
            canvas.restore();
        }
        canvas.restore();
    }

    public final void requestLayout() {
        this.zGD = true;
    }

    public final void setTextColor(int i) {
        this.yg = i;
        this.kfD.setColor(i);
    }

    public final void Hu(int i) {
        this.zGz = i;
    }

    public final void setTextSize(float f) {
        this.nDj = f;
        this.kfD.setTextSize(f);
    }

    public final void setMaxWidth(int i) {
        this.iX = i;
    }

    public final void setMaxHeight(int i) {
        this.vxz = i;
    }

    public final void setMinWidth(int i) {
        this.KD = i;
    }

    public final void a(ArrayList<d> arrayList, CharSequence charSequence) {
        this.zFX = arrayList;
        this.zGE = charSequence;
    }

    public final void a(b bVar) {
        this.zGP = bVar;
    }

    public final List<b> cAb() {
        return this.zFY;
    }

    public final void setPadding(int i, int i2, int i3, int i4) {
        this.zGF = i;
        this.et = i2;
        this.eu = i4;
        this.zGG = i3;
        if (this.zGL != null) {
            Rect rect = new Rect();
            this.zGL.getPadding(rect);
            x.i("CellLayout", "[setPadding] drawableRect:%s", rect);
            this.zGF = rect.left;
            this.zGG = rect.right;
            this.et = rect.top;
            this.eu = rect.bottom;
            this.KD = this.zGL.getMinimumWidth();
            this.zGA = this.zGL.getMinimumHeight();
        }
    }

    public final void Hv(int i) {
        this.zGH = i;
    }

    public final void Hw(int i) {
        this.zGI = i;
    }

    public final void setMinHeight(int i) {
        this.zGA = i;
    }

    public final void Hx(int i) {
        this.zGJ = i;
    }

    public final void setBackgroundDrawable(Drawable drawable) {
        this.zGL = drawable;
    }

    public final String cAc() {
        if (this.zFX == null) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        Iterator it = this.zFX.iterator();
        while (it.hasNext()) {
            String text = ((d) it.next()).getText();
            if (text != null) {
                stringBuilder.append(text);
            }
        }
        return stringBuilder.toString();
    }

    public final String getText() {
        if (this.zGE == null) {
            return "";
        }
        return this.zGE.toString();
    }

    public final int getMaxLines() {
        return this.zGz;
    }

    public final float getTextSize() {
        return this.nDj;
    }

    public final int getMeasuredWidth() {
        return (int) this.zGe;
    }

    public final int getMeasuredHeight() {
        return (int) this.zGC;
    }

    public final int getPaddingLeft() {
        return this.zGF;
    }

    public final int getPaddingRight() {
        return this.zGG;
    }

    public final int getPaddingTop() {
        return this.et;
    }

    public final int getPaddingBottom() {
        return this.eu;
    }

    private void HB(int i) {
        if (this.zFX != null && this.zFX.size() != 0) {
            Object obj;
            this.zGd.clear();
            c cAi = cAi();
            int i2 = 0;
            loop0:
            while (i2 < this.zFX.size()) {
                d dVar = (d) this.zFX.get(i2);
                dVar.cAg();
                c cVar = cAi;
                d dVar2 = dVar;
                while (dVar2 != null && !TextUtils.isEmpty(dVar2.getText())) {
                    if (this.zGz > 0 && this.zGz < this.zGd.size()) {
                        obj = 1;
                        break loop0;
                    }
                    d dVar3;
                    com.tencent.mm.ui.widget.celltextview.c.a a = this.zGy.a(dVar2, this.kfD, i - this.zGR, i, i2 < this.zFX.size() + -1);
                    this.zGy.b(this.kfD);
                    int i3 = a.zGj;
                    float f = a.width;
                    if (i3 > 0) {
                        d.cAd();
                        d cAf = dVar2.cAf();
                        cAf.v(0, i3, null);
                        int i4 = 0;
                        float f2 = 0.0f;
                        while (true) {
                            int i5 = i4;
                            if (i5 >= this.zGd.size() - 1) {
                                break;
                            }
                            f2 += ((c) this.zGd.get(i5)).zGp;
                            i4 = i5 + 1;
                        }
                        cVar.a(cAf, new RectF((float) this.zGR, f2, ((float) this.zGR) + f, cAf.HA(this.zGI) + f2));
                        this.zGR = (int) (((float) this.zGR) + f);
                        if (i3 >= dVar2.getLength()) {
                            dVar3 = null;
                        } else {
                            dVar3 = dVar2.cAf();
                            dVar3.v(i3, -1, null);
                        }
                    } else if (this.zGQ == 0) {
                        x.e("CellLayout", "lastBreakAt == 0 and nowBreakAt == 0");
                        throw new Exception("lastBreakAt == 0 and nowBreakAt == 0");
                    } else {
                        dVar3 = dVar2;
                    }
                    this.zGQ = i3;
                    if (dVar3 != null || (dy(dVar.getText(), dVar.getText().length() - 1) != 10 && (i2 + 1 >= this.zFX.size() || i - this.zGR > 0))) {
                        if (dVar3 != null) {
                            cVar = cAi();
                        }
                        dVar2 = dVar3;
                    } else {
                        cVar = cAi();
                        dVar2 = dVar3;
                    }
                }
                i2++;
                cAi = cVar;
            }
            cAj();
            obj = null;
            if (obj != null) {
                HC(i);
            }
        }
    }

    private int cAh() {
        int i = 0;
        Iterator it = this.zGd.iterator();
        while (true) {
            int i2 = i;
            if (!it.hasNext()) {
                return i2;
            }
            i = (int) (((c) it.next()).zGp + ((float) i2));
        }
    }

    private void HC(int i) {
        d Hy;
        RectF rectF;
        d dVar;
        Object obj;
        if (this.zGd.size() < 2) {
            cAi();
        }
        c cVar = (c) this.zGd.get(this.zGd.size() - 2);
        float measureText = this.kfD.measureText("...", 0, 3);
        this.zGR = 0;
        int size = cVar.getSize();
        int i2 = 0;
        while (i2 < size) {
            Hy = cVar.Hy(i2);
            int i3 = (int) ((((float) i) - measureText) - ((float) this.zGR));
            if (i3 > 0) {
                com.tencent.mm.ui.widget.celltextview.c.a a = this.zGy.a(Hy, this.kfD, i3, i, i2 < size + -1);
                int i4 = a.zGj;
                float width = cVar.Hz(i2).width();
                if (width <= ((float) i3)) {
                    this.zGR = (int) (((float) this.zGR) + width);
                    i2++;
                } else {
                    d.cAd();
                    if (dy(Hy.getText(), i4 - 1) == 10) {
                        i4--;
                    }
                    Hy.v(0, i4, "...");
                    int i5 = i2 + 1;
                    if (cVar.zGm != null) {
                        int size2 = cVar.zGm.size();
                        if (i5 < size2) {
                            i4 = 0;
                            while (true) {
                                i3 = i4;
                                if (i3 >= size2 - i5) {
                                    break;
                                }
                                cVar.zGm.remove((size2 - i3) - 1);
                                rectF = (RectF) cVar.zGn.remove((size2 - i3) - 1);
                                if (rectF != null) {
                                    cVar.zGo -= rectF.width();
                                    if (cVar.zGp >= rectF.height()) {
                                        cVar.zGp = 0.0f;
                                        Iterator it = cVar.zGm.iterator();
                                        int i6 = 0;
                                        while (it.hasNext()) {
                                            dVar = (d) it.next();
                                            RectF rectF2 = (RectF) cVar.zGn.get(i6);
                                            if (dVar.getType() == 0) {
                                                cVar.zGp = (float) ((int) rectF2.height());
                                            } else if (dVar.getType() == 2 && cVar.zGp == 0.0f) {
                                                cVar.zGp = (float) ((int) rectF2.height());
                                            }
                                            i6++;
                                        }
                                    }
                                }
                                i4 = i3 + 1;
                            }
                        }
                    }
                    this.zGR = (int) (((float) this.zGR) + a.width);
                    obj = 1;
                    this.zGR += (int) measureText;
                    if (this.zGd.size() == 2 && r1 == null && ((c) this.zGd.get(1)).Hy(0) == null) {
                        dVar = cVar.Hy(cVar.getSize() - 1);
                        if (dVar != null) {
                            d.cAd();
                            dVar.v(0, -1, "...");
                            obj = 1;
                        }
                    }
                    this.zGe = ((float) this.zGR) <= this.zGe ? (float) this.zGR : this.zGe;
                    if (obj == null) {
                        rectF = new RectF(cVar.Hz(cVar.getSize() - 1));
                        Hy = cVar.Hy(cVar.getSize() - 1);
                        d.cAd();
                        if (Hy.getText().endsWith("\n")) {
                            Hy.v(0, Hy.getText().length() - 1, null);
                        }
                        rectF.left = rectF.right;
                        rectF.right = (float) this.zGR;
                        cVar.a(new d(this.kfD, "...", this.nDj), rectF);
                    }
                }
            }
            return;
        }
        obj = null;
        this.zGR += (int) measureText;
        dVar = cVar.Hy(cVar.getSize() - 1);
        if (dVar != null) {
            d.cAd();
            dVar.v(0, -1, "...");
            obj = 1;
        }
        if (((float) this.zGR) <= this.zGe) {
        }
        this.zGe = ((float) this.zGR) <= this.zGe ? (float) this.zGR : this.zGe;
        if (obj == null) {
            rectF = new RectF(cVar.Hz(cVar.getSize() - 1));
            Hy = cVar.Hy(cVar.getSize() - 1);
            d.cAd();
            if (Hy.getText().endsWith("\n")) {
                Hy.v(0, Hy.getText().length() - 1, null);
            }
            rectF.left = rectF.right;
            rectF.right = (float) this.zGR;
            cVar.a(new d(this.kfD, "...", this.nDj), rectF);
        }
    }

    private c cAi() {
        cAj();
        this.zGR = 0;
        c cVar = new c();
        cVar.zGp = 0.0f;
        this.zGd.add(cVar);
        return cVar;
    }

    private void cAj() {
        int size = this.zGd.size() - 1;
        if (size >= 0) {
            int i;
            c cVar = (c) this.zGd.get(size);
            int i2 = 0;
            for (i = 0; i < cVar.getSize(); i++) {
                i2 += cVar.Hy(i).getLength();
            }
            if (size == 0) {
                cVar.fs(0, i2);
                return;
            }
            i = ((c) this.zGd.get(size - 1)).zGr;
            cVar.fs(i, i + i2);
        }
    }

    private void cAk() {
        if (this.zFY != null) {
            Iterator it = this.zFY.iterator();
            while (it.hasNext()) {
                c cVar;
                b bVar = (b) it.next();
                int i = bVar.Ww;
                int i2 = bVar.wq;
                LinkedList linkedList = new LinkedList();
                LinkedList linkedList2 = new LinkedList();
                Iterator it2 = this.zGd.iterator();
                while (it2.hasNext()) {
                    cVar = (c) it2.next();
                    if (cVar.zGq <= i && i <= cVar.zGr) {
                        if (cVar.zGq <= i2 && i2 <= cVar.zGr) {
                            linkedList.add(cVar);
                            break;
                        }
                        linkedList.add(cVar);
                    } else if (cVar.zGq <= i2 && i2 <= cVar.zGr) {
                        linkedList.add(cVar);
                        break;
                    } else if (linkedList.size() > 0) {
                        linkedList.add(cVar);
                    }
                }
                Iterator it3 = linkedList.iterator();
                while (it3.hasNext()) {
                    cVar = (c) it3.next();
                    x.i("CellLayout", "[getLineIndex] line:[%s:%s]", Integer.valueOf(cVar.zGq), Integer.valueOf(cVar.zGr));
                    int i3 = cVar.zGq;
                    float f = -1.0f;
                    float f2 = -1.0f;
                    for (int i4 = 0; i4 < cVar.getSize(); i4++) {
                        int length = cVar.Hy(i4).getLength();
                        if (i3 <= i && i <= i3 + length) {
                            f = (float) ((int) (cVar.Hz(i4).left + cVar.Hy(i4).l(i - i3, cVar.zGs)));
                        }
                        if (i3 <= i2 && i2 < i3 + length) {
                            f2 = (float) ((int) (cVar.Hz(i4).left + cVar.Hy(i4).l(i2 - i3, cVar.zGs)));
                        }
                        i3 += length;
                    }
                    if (f >= 0.0f && r3 < 0.0f) {
                        f2 = cVar.zGo;
                    } else if (f < 0.0f && r3 >= 0.0f) {
                        f = 0.0f;
                    } else if (f < 0.0f && r3 < 0.0f) {
                        f = 0.0f;
                        f2 = cVar.zGo;
                    }
                    if (f >= 0.0f && f2 >= 0.0f && f < f2) {
                        x.i("CellLayout", "[getLineIndex] rect:[%s:%s]", Float.valueOf(f), Float.valueOf(f2));
                        linkedList2.add(new RectF(f, cVar.Hz(0).top, f2, cVar.Hz(0).bottom));
                    }
                }
                bVar.zGl = linkedList2;
            }
        }
    }

    private static char dy(String str, int i) {
        if (i < 0 || str == null || i >= str.length()) {
            return 0;
        }
        return str.charAt(i);
    }

    private int aD(LinkedList<a> linkedList) {
        int i = 0;
        if (linkedList == null || linkedList.isEmpty()) {
            return 0;
        }
        Iterator it = linkedList.iterator();
        while (true) {
            int i2 = i;
            if (!it.hasNext()) {
                return i2;
            }
            i = (((a) it.next()).zGT.width() + this.ypi) + i2;
        }
    }
}
