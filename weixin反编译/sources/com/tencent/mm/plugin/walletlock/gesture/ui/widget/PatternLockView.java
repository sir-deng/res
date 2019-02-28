package com.tencent.mm.plugin.walletlock.gesture.ui.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import com.tencent.mm.plugin.walletlock.a.h;
import com.tencent.mm.plugin.walletlock.gesture.a.f;
import com.tencent.mm.sdk.platformtools.d;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PatternLockView extends View {
    private static Bitmap tnp = null;
    private static Bitmap tnq = null;
    private static Bitmap tnr = null;
    private static Bitmap tns = null;
    private int mdr;
    private Paint tmZ = new Paint();
    private Paint tna = new Paint();
    private Path tnb = new Path();
    private Matrix tnc = new Matrix();
    private Rect tnd = new Rect();
    private Rect tne = new Rect();
    private ArrayList<f> tnf = new ArrayList(9);
    private boolean[][] tng = ((boolean[][]) Array.newInstance(Boolean.TYPE, new int[]{3, 3}));
    private int tnh = c.tnH;
    private int tni = 6;
    private int tnj = 200;
    private float tnk = 0.66f;
    private boolean tnl = false;
    private boolean tnm = true;
    public boolean tnn = false;
    private b tno;
    private float tnt;
    private float tnu;
    private boolean tnv;
    private long tnw;
    private float tnx;
    private float tny;
    public a tnz;
    private int uo;
    private int uq;

    private static class SavedState extends BaseSavedState {
        public static final Creator<SavedState> CREATOR = new Creator<SavedState>() {
            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new SavedState[i];
            }
        };
        String tnF;
        int tnG;
        boolean tnl;
        boolean tnm;
        boolean tnn;

        public SavedState(Parcel parcel) {
            super(parcel);
            this.tnF = parcel.readString();
            this.tnG = parcel.readInt();
            this.tnm = ((Boolean) parcel.readValue(null)).booleanValue();
            this.tnn = ((Boolean) parcel.readValue(null)).booleanValue();
            this.tnl = ((Boolean) parcel.readValue(null)).booleanValue();
        }

        public SavedState(Parcelable parcelable, String str, int i, boolean z, boolean z2, boolean z3) {
            super(parcelable);
            this.tnF = str;
            this.tnG = i;
            this.tnm = z;
            this.tnn = z2;
            this.tnl = z3;
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeString(this.tnF);
            parcel.writeInt(this.tnG);
            parcel.writeValue(Boolean.valueOf(this.tnm));
            parcel.writeValue(Boolean.valueOf(this.tnn));
            parcel.writeValue(Boolean.valueOf(this.tnl));
        }
    }

    public interface a {
        void a(PatternLockView patternLockView);

        void a(PatternLockView patternLockView, List<f> list);
    }

    public enum b {
        Correct,
        Wrong,
        Animate
    }

    public enum c {
        ;

        static {
            tnH = 1;
            tnI = 2;
            tnJ = new int[]{tnH, tnI};
        }
    }

    public PatternLockView(Context context, AttributeSet attributeSet) {
        int i;
        super(context, attributeSet);
        if (isInEditMode()) {
            i = -1;
        } else {
            i = getResources().getColor(com.tencent.mm.plugin.walletlock.a.b.tkC);
        }
        this.mdr = i;
        this.tno = b.Correct;
        this.tnt = -1.0f;
        this.tnu = -1.0f;
        this.tnv = false;
        this.tnw = 0;
        this.uo = 0;
        this.uq = 0;
        this.tnx = 0.0f;
        this.tny = 0.0f;
        this.tnz = null;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, h.tlQ);
        this.tnm = obtainStyledAttributes.getBoolean(h.tlV, this.tnm);
        this.tnj = obtainStyledAttributes.getInt(h.tlS, this.tnj);
        this.tni = obtainStyledAttributes.getInt(h.tlT, this.tni);
        this.tnl = obtainStyledAttributes.getBoolean(h.tlU, this.tnl);
        switch (obtainStyledAttributes.getInt(h.tlR, this.tnh - 1)) {
            case 0:
                this.tnh = c.tnH;
                break;
            case 1:
                this.tnh = c.tnI;
                break;
            default:
                this.tnh = c.tnH;
                break;
        }
        obtainStyledAttributes.recycle();
        setClickable(true);
        this.tna.setStyle(Style.STROKE);
        this.tna.setStrokeJoin(Join.ROUND);
        this.tna.setStrokeCap(Cap.ROUND);
        this.tna.setAntiAlias(true);
        this.tna.setDither(false);
        this.tna.setAlpha(this.tnj);
        this.tmZ.setAntiAlias(true);
        this.tmZ.setDither(true);
        if (!isInEditMode()) {
            if (tnp == null) {
                tnp = t(com.tencent.mm.bu.a.b(getContext(), com.tencent.mm.plugin.walletlock.a.c.tkG));
                Bitmap t = t(com.tencent.mm.bu.a.b(getContext(), com.tencent.mm.plugin.walletlock.a.c.tkH));
                tnq = t;
                tnr = t;
                tns = t(com.tencent.mm.bu.a.b(getContext(), com.tencent.mm.plugin.walletlock.a.c.tkI));
            }
            this.tni = (int) (((float) this.tni) * d.cfC().density);
            Bitmap[] bitmapArr = new Bitmap[]{tnp, tnq, tnr, tns};
            for (i = 0; i < 4; i++) {
                Bitmap bitmap = bitmapArr[i];
                this.uo = Math.max(bitmap.getWidth(), this.uo);
                this.uq = Math.max(bitmap.getHeight(), this.uq);
            }
        }
    }

    private static Bitmap t(Drawable drawable) {
        Bitmap createBitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), drawable.getOpacity() != -1 ? Config.ARGB_8888 : Config.RGB_565);
        Canvas canvas = new Canvas(createBitmap);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        drawable.draw(canvas);
        return createBitmap;
    }

    private static String cl(List<f> list) {
        if (list == null) {
            throw new IllegalArgumentException("pattern is null");
        }
        int size = list.size();
        byte[] bArr = new byte[size];
        for (int i = 0; i < size; i++) {
            f fVar = (f) list.get(i);
            bArr[i] = (byte) (fVar.tmv + (fVar.tmu * 3));
        }
        return new String(bArr);
    }

    protected Parcelable onSaveInstanceState() {
        return new SavedState(super.onSaveInstanceState(), cl(this.tnf), this.tno.ordinal(), this.tnm, this.tnn, this.tnl);
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        b bVar = b.Correct;
        String str = savedState.tnF;
        if (str == null) {
            throw new IllegalArgumentException("Serialized pattern is null");
        }
        List arrayList = new ArrayList();
        byte[] bytes = str.getBytes();
        for (byte b : bytes) {
            arrayList.add(f.ef(b / 3, b % 3));
        }
        a(bVar, arrayList);
        this.tno = b.values()[savedState.tnG];
        this.tnm = savedState.tnm;
        this.tnn = savedState.tnn;
        this.tnl = savedState.tnl;
    }

    protected int getSuggestedMinimumWidth() {
        return (int) ((3.0d * ((double) ((float) this.uo))) / ((double) getResources().getDisplayMetrics().density));
    }

    protected int getSuggestedMinimumHeight() {
        return (int) ((3.0d * ((double) ((float) this.uq))) / ((double) getResources().getDisplayMetrics().density));
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        this.tnx = ((float) ((i - getPaddingLeft()) - getPaddingRight())) / 3.0f;
        this.tny = ((float) ((i2 - getPaddingTop()) - getPaddingBottom())) / 3.0f;
    }

    private static int eg(int i, int i2) {
        int size = MeasureSpec.getSize(i);
        switch (MeasureSpec.getMode(i)) {
            case Integer.MIN_VALUE:
                return Math.max(size, i2);
            case 0:
                return i2;
            default:
                return size;
        }
    }

    protected void onMeasure(int i, int i2) {
        int suggestedMinimumWidth = getSuggestedMinimumWidth();
        int suggestedMinimumHeight = getSuggestedMinimumHeight();
        int eg = eg(i, suggestedMinimumWidth);
        suggestedMinimumWidth = eg(i2, suggestedMinimumHeight);
        if (this.tnh == c.tnH) {
            suggestedMinimumWidth = Math.min(eg, suggestedMinimumWidth);
            eg = suggestedMinimumWidth;
        }
        setMeasuredDimension(eg, suggestedMinimumWidth);
    }

    protected void onDraw(Canvas canvas) {
        int elapsedRealtime;
        int i;
        f fVar;
        Object obj;
        float zP;
        float zQ;
        float f;
        ArrayList arrayList = this.tnf;
        int size = arrayList.size();
        boolean[][] zArr = this.tng;
        if (this.tno == b.Animate) {
            elapsedRealtime = ((int) (SystemClock.elapsedRealtime() - this.tnw)) % ((size + 1) * 700);
            i = elapsedRealtime / 700;
            bOR();
            for (int i2 = 0; i2 < i; i2++) {
                fVar = (f) arrayList.get(i2);
                zArr[fVar.tmu][fVar.tmv] = true;
            }
            obj = (i <= 0 || i >= size) ? null : 1;
            if (obj != null) {
                float f2 = ((float) (elapsedRealtime % 700)) / 700.0f;
                fVar = (f) arrayList.get(i - 1);
                float zP2 = zP(fVar.tmv);
                float zQ2 = zQ(fVar.tmu);
                fVar = (f) arrayList.get(i);
                zP = (zP(fVar.tmv) - zP2) * f2;
                zQ = (zQ(fVar.tmu) - zQ2) * f2;
                this.tnt = zP2 + zP;
                this.tnu = zQ + zQ2;
            }
            invalidate();
        }
        this.tna.setColor(this.mdr);
        this.tna.setStrokeWidth((float) this.tni);
        Path path = this.tnb;
        path.rewind();
        obj = (this.tnm || this.tno == b.Wrong) ? 1 : null;
        int paddingTop = getPaddingTop();
        int paddingLeft = getPaddingLeft();
        float f3 = this.tnx;
        float f4 = this.tny;
        boolean z = (this.tmZ.getFlags() & 2) != 0;
        this.tmZ.setFilterBitmap(true);
        elapsedRealtime = 0;
        while (true) {
            i = elapsedRealtime;
            if (i >= 3) {
                break;
            }
            f = (((float) i) * f4) + ((float) paddingTop);
            for (elapsedRealtime = 0; elapsedRealtime < 3; elapsedRealtime++) {
                float f5 = ((float) paddingLeft) + (((float) elapsedRealtime) * f3);
                if (!zArr[i][elapsedRealtime]) {
                    a(canvas, (int) f5, (int) f, zArr[i][elapsedRealtime]);
                }
            }
            elapsedRealtime = i + 1;
        }
        if (obj != null) {
            Object obj2 = null;
            for (elapsedRealtime = 0; elapsedRealtime < size; elapsedRealtime++) {
                fVar = (f) arrayList.get(elapsedRealtime);
                if (!zArr[fVar.tmu][fVar.tmv]) {
                    break;
                }
                obj2 = 1;
                f = zP(fVar.tmv);
                zQ = zQ(fVar.tmu);
                if (elapsedRealtime == 0) {
                    path.moveTo(f, zQ);
                } else {
                    path.lineTo(f, zQ);
                }
            }
            if ((this.tnv || this.tno == b.Animate) && obj2 != null) {
                path.lineTo(this.tnt, this.tnu);
            }
            canvas.drawPath(path, this.tna);
        }
        int i3 = 0;
        while (true) {
            elapsedRealtime = i3;
            if (elapsedRealtime < 3) {
                zP = (((float) elapsedRealtime) * f4) + ((float) paddingTop);
                for (i3 = 0; i3 < 3; i3++) {
                    float f6 = ((float) paddingLeft) + (((float) i3) * f3);
                    if (zArr[elapsedRealtime][i3]) {
                        a(canvas, (int) f6, (int) zP, zArr[elapsedRealtime][i3]);
                    }
                }
                i3 = elapsedRealtime + 1;
            } else {
                this.tmZ.setFilterBitmap(z);
                return;
            }
        }
    }

    private void a(Canvas canvas, int i, int i2, boolean z) {
        Bitmap bitmap;
        if (!z || (!this.tnm && this.tno != b.Wrong)) {
            bitmap = tnp;
        } else if (this.tnv) {
            bitmap = tnq;
        } else if (this.tno == b.Wrong) {
            bitmap = tns;
        } else if (this.tno == b.Correct || this.tno == b.Animate) {
            bitmap = tnr;
        } else {
            throw new IllegalStateException("unknown display mode " + this.tno);
        }
        int i3 = this.uo;
        int i4 = this.uq;
        i3 = (int) ((this.tnx - ((float) i3)) * 0.5f);
        i4 = (int) ((this.tny - ((float) i4)) * 0.5f);
        float f = getResources().getDisplayMetrics().density;
        float min = Math.min((this.tnx - (33.0f * f)) / ((float) this.uo), 1.0f);
        f = Math.min((this.tny - (f * 33.0f)) / ((float) this.uq), 1.0f);
        this.tnc.setTranslate((float) (i3 + i), (float) (i4 + i2));
        this.tnc.preTranslate((float) (this.uo / 2), (float) (this.uq / 2));
        this.tnc.preScale(min, f);
        this.tnc.preTranslate((float) ((-this.uo) / 2), (float) ((-this.uq) / 2));
        if (!isInEditMode()) {
            canvas.drawBitmap(bitmap, this.tnc, this.tmZ);
        }
    }

    private f G(float f, float f2) {
        float f3;
        int i = 0;
        f fVar = null;
        float f4 = this.tny;
        float f5 = f4 * this.tnk;
        float paddingTop = ((f4 - f5) / 2.0f) + ((float) getPaddingTop());
        int i2 = 0;
        while (i2 < 3) {
            f3 = (((float) i2) * f4) + paddingTop;
            if (f2 >= f3 && f2 <= f3 + f5) {
                break;
            }
            i2++;
        }
        i2 = -1;
        if (i2 >= 0) {
            f4 = this.tnx;
            f5 = this.tnk * f4;
            paddingTop = ((float) getPaddingLeft()) + ((f4 - f5) / 2.0f);
            while (i < 3) {
                f3 = (((float) i) * f4) + paddingTop;
                if (f >= f3 && f <= f3 + f5) {
                    break;
                }
                i++;
            }
            i = -1;
            if (i >= 0 && !this.tng[i2][i]) {
                fVar = f.ef(i2, i);
            }
        }
        if (fVar == null) {
            return null;
        }
        this.tng[fVar.tmu][fVar.tmv] = true;
        this.tnf.add(fVar);
        if (this.tnz != null) {
            ArrayList arrayList = new ArrayList(this.tnf);
        }
        if (!this.tnl) {
            return fVar;
        }
        performHapticFeedback(1, 3);
        return fVar;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouchEvent(android.view.MotionEvent r14) {
        /*
        r13 = this;
        r0 = r13.tnn;
        if (r0 == 0) goto L_0x000a;
    L_0x0004:
        r0 = r13.isEnabled();
        if (r0 != 0) goto L_0x000c;
    L_0x000a:
        r0 = 0;
    L_0x000b:
        return r0;
    L_0x000c:
        r0 = r14.getAction();
        switch(r0) {
            case 0: goto L_0x0015;
            case 1: goto L_0x0060;
            case 2: goto L_0x0080;
            case 3: goto L_0x0207;
            default: goto L_0x0013;
        };
    L_0x0013:
        r0 = 0;
        goto L_0x000b;
    L_0x0015:
        r13.bOS();
        r0 = r14.getX();
        r1 = r14.getY();
        r2 = r13.G(r0, r1);
        if (r2 == 0) goto L_0x005c;
    L_0x0026:
        r3 = 1;
        r13.tnv = r3;
        r3 = com.tencent.mm.plugin.walletlock.gesture.ui.widget.PatternLockView.b.Correct;
        r13.tno = r3;
        r3 = r13.tnz;
        if (r3 == 0) goto L_0x0031;
    L_0x0031:
        if (r2 == 0) goto L_0x0056;
    L_0x0033:
        r3 = r2.tmv;
        r3 = r13.zP(r3);
        r2 = r2.tmu;
        r2 = r13.zQ(r2);
        r4 = r13.tnx;
        r5 = 1056964608; // 0x3f000000 float:0.5 double:5.222099017E-315;
        r4 = r4 * r5;
        r5 = r13.tny;
        r6 = 1056964608; // 0x3f000000 float:0.5 double:5.222099017E-315;
        r5 = r5 * r6;
        r6 = r3 - r4;
        r6 = (int) r6;
        r7 = r2 - r5;
        r7 = (int) r7;
        r3 = r3 + r4;
        r3 = (int) r3;
        r2 = r2 + r5;
        r2 = (int) r2;
        r13.invalidate(r6, r7, r3, r2);
    L_0x0056:
        r13.tnt = r0;
        r13.tnu = r1;
        r0 = 1;
        goto L_0x000b;
    L_0x005c:
        r3 = 0;
        r13.tnv = r3;
        goto L_0x0031;
    L_0x0060:
        r0 = r13.tnf;
        r0 = r0.isEmpty();
        if (r0 != 0) goto L_0x007e;
    L_0x0068:
        r0 = 0;
        r13.tnv = r0;
        r0 = r13.tnz;
        if (r0 == 0) goto L_0x007b;
    L_0x006f:
        r0 = r13.tnz;
        r1 = new java.util.ArrayList;
        r2 = r13.tnf;
        r1.<init>(r2);
        r0.a(r13, r1);
    L_0x007b:
        r13.invalidate();
    L_0x007e:
        r0 = 1;
        goto L_0x000b;
    L_0x0080:
        r0 = r13.tni;
        r7 = (float) r0;
        r8 = r14.getHistorySize();
        r0 = r13.tnd;
        r0.setEmpty();
        r2 = 0;
        r0 = 0;
        r6 = r0;
    L_0x008f:
        r0 = r8 + 1;
        if (r6 >= r0) goto L_0x0159;
    L_0x0093:
        if (r6 >= r8) goto L_0x014b;
    L_0x0095:
        r0 = r14.getHistoricalX(r6);
        r3 = r0;
    L_0x009a:
        if (r6 >= r8) goto L_0x0152;
    L_0x009c:
        r0 = r14.getHistoricalY(r6);
        r1 = r0;
    L_0x00a1:
        r9 = r13.G(r3, r1);
        r0 = r13.tnf;
        r4 = r0.size();
        if (r9 == 0) goto L_0x00b3;
    L_0x00ad:
        r0 = 1;
        if (r4 != r0) goto L_0x00b3;
    L_0x00b0:
        r0 = 1;
        r13.tnv = r0;
    L_0x00b3:
        r0 = r13.tnt;
        r0 = r3 - r0;
        r0 = java.lang.Math.abs(r0);
        r5 = r13.tnu;
        r5 = r1 - r5;
        r5 = java.lang.Math.abs(r5);
        r10 = 0;
        r0 = (r0 > r10 ? 1 : (r0 == r10 ? 0 : -1));
        if (r0 > 0) goto L_0x00cd;
    L_0x00c8:
        r0 = 0;
        r0 = (r5 > r0 ? 1 : (r5 == r0 ? 0 : -1));
        if (r0 <= 0) goto L_0x00cf;
    L_0x00cd:
        r0 = 1;
        r2 = r0;
    L_0x00cf:
        r0 = r13.tnv;
        if (r0 == 0) goto L_0x0146;
    L_0x00d3:
        if (r4 <= 0) goto L_0x0146;
    L_0x00d5:
        r0 = r13.tnf;
        r4 = r4 + -1;
        r0 = r0.get(r4);
        r0 = (com.tencent.mm.plugin.walletlock.gesture.a.f) r0;
        r4 = r0.tmv;
        r4 = r13.zP(r4);
        r0 = r0.tmu;
        r10 = r13.zQ(r0);
        r0 = java.lang.Math.min(r4, r3);
        r0 = r0 - r7;
        r3 = java.lang.Math.max(r4, r3);
        r5 = r3 + r7;
        r3 = java.lang.Math.min(r10, r1);
        r3 = r3 - r7;
        r1 = java.lang.Math.max(r10, r1);
        r4 = r1 + r7;
        if (r9 == 0) goto L_0x021d;
    L_0x0103:
        r1 = r13.tnx;
        r10 = 1056964608; // 0x3f000000 float:0.5 double:5.222099017E-315;
        r1 = r1 * r10;
        r10 = r13.tny;
        r11 = 1056964608; // 0x3f000000 float:0.5 double:5.222099017E-315;
        r10 = r10 * r11;
        r11 = r9.tmv;
        r11 = r13.zP(r11);
        r9 = r9.tmu;
        r9 = r13.zQ(r9);
        r12 = r11 - r1;
        r0 = java.lang.Math.min(r12, r0);
        r1 = r1 + r11;
        r5 = java.lang.Math.max(r1, r5);
        r1 = r9 - r10;
        r1 = java.lang.Math.min(r1, r3);
        r3 = r9 + r10;
        r3 = java.lang.Math.max(r3, r4);
        r4 = r5;
    L_0x0131:
        r5 = r13.tnd;
        r0 = java.lang.Math.round(r0);
        r1 = java.lang.Math.round(r1);
        r4 = java.lang.Math.round(r4);
        r3 = java.lang.Math.round(r3);
        r5.union(r0, r1, r4, r3);
    L_0x0146:
        r0 = r6 + 1;
        r6 = r0;
        goto L_0x008f;
    L_0x014b:
        r0 = r14.getX();
        r3 = r0;
        goto L_0x009a;
    L_0x0152:
        r0 = r14.getY();
        r1 = r0;
        goto L_0x00a1;
    L_0x0159:
        r0 = r14.getX();
        r13.tnt = r0;
        r0 = r13.tnt;
        r1 = r13.getPaddingLeft();
        r3 = r13.tni;
        r1 = r1 + r3;
        r1 = (float) r1;
        r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1));
        if (r0 >= 0) goto L_0x01ad;
    L_0x016d:
        r0 = r13.getPaddingLeft();
        r1 = r13.tni;
        r0 = r0 + r1;
        r0 = (float) r0;
        r13.tnt = r0;
    L_0x0177:
        r0 = r14.getY();
        r13.tnu = r0;
        r0 = r13.tnu;
        r1 = r13.getPaddingTop();
        r3 = r13.tni;
        r1 = r1 + r3;
        r1 = (float) r1;
        r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1));
        if (r0 >= 0) goto L_0x01da;
    L_0x018b:
        r0 = r13.getPaddingTop();
        r1 = r13.tni;
        r0 = r0 + r1;
        r0 = (float) r0;
        r13.tnu = r0;
    L_0x0195:
        if (r2 == 0) goto L_0x01aa;
    L_0x0197:
        r0 = r13.tne;
        r1 = r13.tnd;
        r0.union(r1);
        r0 = r13.tne;
        r13.invalidate(r0);
        r0 = r13.tne;
        r1 = r13.tnd;
        r0.set(r1);
    L_0x01aa:
        r0 = 1;
        goto L_0x000b;
    L_0x01ad:
        r0 = r13.tnt;
        r1 = r13.getPaddingLeft();
        r3 = r13.getWidth();
        r1 = r1 + r3;
        r3 = r13.getPaddingRight();
        r1 = r1 - r3;
        r3 = r13.tni;
        r1 = r1 - r3;
        r1 = (float) r1;
        r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1));
        if (r0 <= 0) goto L_0x0177;
    L_0x01c5:
        r0 = r13.getPaddingLeft();
        r1 = r13.getWidth();
        r0 = r0 + r1;
        r1 = r13.getPaddingRight();
        r0 = r0 - r1;
        r1 = r13.tni;
        r0 = r0 - r1;
        r0 = (float) r0;
        r13.tnt = r0;
        goto L_0x0177;
    L_0x01da:
        r0 = r13.tnu;
        r1 = r13.getPaddingTop();
        r3 = r13.getHeight();
        r1 = r1 + r3;
        r3 = r13.getPaddingRight();
        r1 = r1 - r3;
        r3 = r13.tni;
        r1 = r1 - r3;
        r1 = (float) r1;
        r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1));
        if (r0 <= 0) goto L_0x0195;
    L_0x01f2:
        r0 = r13.getPaddingTop();
        r1 = r13.getHeight();
        r0 = r0 + r1;
        r1 = r13.getPaddingBottom();
        r0 = r0 - r1;
        r1 = r13.tni;
        r0 = r0 - r1;
        r0 = (float) r0;
        r13.tnu = r0;
        goto L_0x0195;
    L_0x0207:
        r0 = r13.tnv;
        if (r0 == 0) goto L_0x021a;
    L_0x020b:
        r0 = 0;
        r13.tnv = r0;
        r13.bOS();
        r0 = r13.tnz;
        if (r0 == 0) goto L_0x021a;
    L_0x0215:
        r0 = r13.tnz;
        r0.a(r13);
    L_0x021a:
        r0 = 1;
        goto L_0x000b;
    L_0x021d:
        r1 = r3;
        r3 = r4;
        r4 = r5;
        goto L_0x0131;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.walletlock.gesture.ui.widget.PatternLockView.onTouchEvent(android.view.MotionEvent):boolean");
    }

    private void bOR() {
        for (int i = 0; i < 3; i++) {
            for (int i2 = 0; i2 < 3; i2++) {
                this.tng[i][i2] = false;
            }
        }
    }

    private float zP(int i) {
        return (((float) getPaddingLeft()) + (((float) i) * this.tnx)) + (this.tnx * 0.5f);
    }

    private float zQ(int i) {
        return (((float) getPaddingTop()) + (((float) i) * this.tny)) + (this.tny * 0.5f);
    }

    private void a(b bVar, List<f> list) {
        this.tnf.clear();
        bOR();
        this.tnf.addAll(list);
        Iterator it = this.tnf.iterator();
        while (it.hasNext()) {
            f fVar = (f) it.next();
            this.tng[fVar.tmu][fVar.tmv] = true;
        }
        a(bVar);
    }

    private void bOS() {
        this.tnf.clear();
        bOR();
        this.tno = b.Correct;
        invalidate();
    }

    public final void bOT() {
        bOS();
        if (this.tnz != null) {
            this.tnz.a(this);
        }
    }

    public final void a(b bVar) {
        switch (bVar) {
            case Correct:
                this.mdr = getResources().getColor(com.tencent.mm.plugin.walletlock.a.b.tkC);
                break;
            case Wrong:
                this.mdr = getResources().getColor(com.tencent.mm.plugin.walletlock.a.b.tkF);
                break;
            case Animate:
                if (this.tnf.size() != 0) {
                    this.tnn = false;
                    this.mdr = getResources().getColor(com.tencent.mm.plugin.walletlock.a.b.tkC);
                    f fVar = (f) this.tnf.get(0);
                    this.tnt = zP(fVar.tmv);
                    this.tnu = zQ(fVar.tmu);
                    bOR();
                    this.tnw = SystemClock.elapsedRealtime();
                    break;
                }
                throw new IllegalStateException("You should set a pattern before animating.");
        }
        this.tno = bVar;
        invalidate();
    }
}
