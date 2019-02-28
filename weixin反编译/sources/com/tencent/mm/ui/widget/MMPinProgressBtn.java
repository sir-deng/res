package com.tencent.mm.ui.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.AttributeSet;
import android.view.View.BaseSavedState;
import android.widget.CompoundButton;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.v.a.d;
import com.tencent.mm.v.a.e;
import com.tencent.mm.v.a.m;

public class MMPinProgressBtn extends CompoundButton {
    private Paint De;
    private int sm;
    private int style;
    public int zDe;
    private Paint zDf;
    private RectF zDg = new RectF();
    private int zDh;
    private final float zDi = 4.0f;
    private Runnable zDj = new Runnable() {
        public final void run() {
            if (MMPinProgressBtn.this.getVisibility() != 0) {
                x.i("MicroMsg.MMPinProgressBtn", "cur progress bar not visiable, stop auto pregress");
                return;
            }
            MMPinProgressBtn.this.sm = MMPinProgressBtn.this.sm + 1;
            if (MMPinProgressBtn.this.sm >= MMPinProgressBtn.this.zDe) {
                MMPinProgressBtn.this.sm = MMPinProgressBtn.this.sm - 1;
                x.i("MicroMsg.MMPinProgressBtn", "match auto progress max, return");
                return;
            }
            MMPinProgressBtn.this.invalidate();
            MMPinProgressBtn.this.postDelayed(MMPinProgressBtn.this.zDj, 200);
        }
    };

    public static class SavedState extends BaseSavedState {
        public static final Creator<SavedState> CREATOR = new Creator<SavedState>() {
            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new SavedState(parcel, (byte) 0);
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new SavedState[i];
            }
        };
        private int sm;
        private int zDe;

        /* synthetic */ SavedState(Parcel parcel, byte b) {
            this(parcel);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.sm = parcel.readInt();
            this.zDe = parcel.readInt();
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.sm);
            parcel.writeInt(this.zDe);
        }
    }

    public MMPinProgressBtn(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        b(context, attributeSet, 0);
    }

    public MMPinProgressBtn(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        b(context, attributeSet, i);
    }

    private void b(Context context, AttributeSet attributeSet, int i) {
        Throwable th;
        TypedArray typedArray;
        this.zDe = 100;
        this.sm = 0;
        Resources resources = getResources();
        int color = resources.getColor(d.gWn);
        int color2 = resources.getColor(d.gWo);
        if (attributeSet != null) {
            TypedArray typedArray2 = null;
            try {
                typedArray2 = context.obtainStyledAttributes(attributeSet, m.faV, i, 0);
                try {
                    this.zDe = typedArray2.getInteger(m.haR, this.zDe);
                    this.sm = typedArray2.getInteger(m.haQ, this.sm);
                    color = typedArray2.getColor(m.haS, color);
                    color2 = typedArray2.getColor(m.haT, color2);
                    this.style = typedArray2.getInteger(m.haV, 0);
                    this.zDh = typedArray2.getDimensionPixelSize(m.haU, resources.getDimensionPixelSize(e.gWz));
                    if (typedArray2 != null) {
                        typedArray2.recycle();
                    }
                } catch (Throwable th2) {
                    th = th2;
                    typedArray = typedArray2;
                    if (typedArray != null) {
                        typedArray.recycle();
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                typedArray = typedArray2;
            }
        }
        this.De = new Paint();
        this.De.setColor(color);
        this.De.setStyle(Style.STROKE);
        this.De.setStrokeWidth(4.0f);
        this.De.setAntiAlias(true);
        this.zDf = new Paint();
        this.zDf.setColor(color2);
        this.zDf.setAntiAlias(true);
        setClickable(false);
    }

    public final void setMax(int i) {
        this.zDe = Math.max(0, i);
        invalidate();
    }

    public final void setProgress(int i) {
        this.sm = Math.max(0, i);
        this.sm = Math.min(i, this.zDe);
        invalidate();
    }

    public final void czF() {
        removeCallbacks(this.zDj);
        post(this.zDj);
    }

    protected void onMeasure(int i, int i2) {
        setMeasuredDimension(resolveSize(this.zDh, i), resolveSize(this.zDh, i2));
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.zDg.set(2.0f, 2.0f, ((float) this.zDh) - 2.0f, ((float) this.zDh) - 2.0f);
        this.zDg.offset((float) ((getWidth() - this.zDh) / 2), (float) ((getHeight() - this.zDh) / 2));
        canvas.drawArc(this.zDg, 0.0f, 360.0f, true, this.De);
        switch (this.style) {
            case 0:
                this.zDg.set(8.0f, 8.0f, ((float) this.zDh) - 8.0f, ((float) this.zDh) - 8.0f);
                this.zDg.offset((float) ((getWidth() - this.zDh) / 2), (float) ((getHeight() - this.zDh) / 2));
                canvas.drawArc(this.zDg, -90.0f, 360.0f * ((((float) this.sm) * 1.0f) / ((float) this.zDe)), true, this.zDf);
                return;
            case 1:
                this.zDg.set(2.0f, 2.0f, ((float) this.zDh) - 2.0f, ((float) this.zDh) - 2.0f);
                this.zDg.offset((float) ((getWidth() - this.zDh) / 2), (float) ((getHeight() - this.zDh) / 2));
                canvas.drawArc(this.zDg, 270.0f, (((((float) this.sm) * 1.0f) / ((float) this.zDe)) * 360.0f) - 360.0f, true, this.zDf);
                return;
            default:
                return;
        }
    }

    public Parcelable onSaveInstanceState() {
        Parcelable onSaveInstanceState = super.onSaveInstanceState();
        if (!isSaveEnabled()) {
            return onSaveInstanceState;
        }
        Parcelable savedState = new SavedState(onSaveInstanceState);
        savedState.zDe = this.zDe;
        savedState.sm = this.sm;
        return savedState;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            super.onRestoreInstanceState(savedState.getSuperState());
            this.zDe = savedState.zDe;
            this.sm = savedState.sm;
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }
}
