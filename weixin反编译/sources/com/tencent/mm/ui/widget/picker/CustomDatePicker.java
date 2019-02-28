package com.tencent.mm.ui.widget.picker;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.NumberPicker;
import android.widget.NumberPicker.OnValueChangeListener;
import com.tencent.mm.ca.a.d;
import com.tencent.mm.ui.widget.picker.YADatePicker.c;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class CustomDatePicker extends YADatePicker {
    public boolean kiD = true;
    public boolean kiE = true;
    public boolean kiF = true;
    public NumberPicker kiG;
    public NumberPicker kiH;
    public NumberPicker kiI;
    private Date kiJ;
    private Date kiK;
    private Calendar kiL;
    private String[] kiM;

    public CustomDatePicker(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initView();
    }

    public CustomDatePicker(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initView();
    }

    private void initView() {
        this.kiM = new String[12];
        for (int i = 0; i < this.kiM.length; i++) {
            this.kiM[i] = (i + 1);
        }
        this.kiL = Calendar.getInstance(Locale.US);
        cAp();
        cAq();
        this.kiG = ((c) getUIDelegate()).zHG;
        this.kiH = ((c) getUIDelegate()).zHF;
        this.kiI = ((c) getUIDelegate()).zHE;
        Drawable drawable = getResources().getDrawable(d.zIj);
        d.a(this.kiG, drawable);
        d.a(this.kiH, drawable);
        d.a(this.kiI, drawable);
        d.c(this.kiG);
        d.c(this.kiH);
        d.c(this.kiI);
        OnValueChangeListener anonymousClass1 = new OnValueChangeListener() {
            public final void onValueChange(NumberPicker numberPicker, int i, int i2) {
                CustomDatePicker.this.aon();
            }
        };
        if (this.kiG != null) {
            this.kiG.setOnValueChangedListener(anonymousClass1);
            this.kiG.setMinValue(1900);
        }
        if (this.kiH != null) {
            this.kiH.setOnValueChangedListener(anonymousClass1);
        }
        if (this.kiI != null) {
            this.kiI.setOnValueChangedListener(anonymousClass1);
        }
        aon();
        d.e(this.kiG);
        d.e(this.kiH);
        d.e(this.kiI);
    }

    public final void aon() {
        int i = 0;
        if (this.kiG != null && this.kiH != null && this.kiI != null) {
            boolean z;
            this.kiH.setDisplayedValues(null);
            if (this.kiG.getValue() != this.kiG.getMaxValue() || this.kiK == null) {
                this.kiH.setMaxValue(11);
                z = false;
            } else {
                this.kiH.setMaxValue(this.kiK.getMonth());
                if (this.kiH.getValue() == this.kiH.getMaxValue() && this.kiK != null) {
                    this.kiI.setMaxValue(this.kiK.getDate());
                    z = true;
                }
                z = false;
            }
            if (!z) {
                this.kiL.set(this.kiG.getValue(), this.kiH.getValue(), 1);
                this.kiI.setMaxValue(this.kiL.getActualMaximum(5));
            }
            if (this.kiG.getValue() != this.kiG.getMinValue() || this.kiJ == null) {
                this.kiH.setMinValue(0);
            } else {
                this.kiH.setMinValue(this.kiJ.getMonth());
                if (this.kiH.getValue() == this.kiH.getMinValue() && this.kiJ != null) {
                    this.kiI.setMinValue(this.kiJ.getDate());
                    i = 1;
                }
            }
            if (i == 0) {
                this.kiI.setMinValue(1);
            }
            this.kiH.setDisplayedValues((String[]) Arrays.copyOfRange(this.kiM, this.kiH.getMinValue(), this.kiH.getMaxValue() + 1));
            this.kiG.setWrapSelectorWheel(true);
            this.kiH.setWrapSelectorWheel(true);
            this.kiI.setWrapSelectorWheel(true);
        }
    }

    public final void setMaxDate(long j) {
        super.setMaxDate(j);
        this.kiK = new Date(j);
        if (this.kiG != null) {
            this.kiG.setMaxValue(this.kiK.getYear() + 1900);
        }
        aon();
    }

    public final void setMinDate(long j) {
        super.setMinDate(j);
        this.kiJ = new Date(j);
        if (this.kiG != null) {
            this.kiG.setMinValue(this.kiJ.getYear() + 1900);
        }
    }

    public final void an(int i, int i2, int i3) {
        a(i, i2, 1, null);
    }

    public final void a(int i, int i2, int i3, YADatePicker.d dVar) {
        super.a(i, Math.max(i2 - 1, 0), i3, dVar);
        aon();
    }

    public final int getYear() {
        if (this.kiG != null) {
            return this.kiG.getValue();
        }
        return super.getYear();
    }

    public final int getMonth() {
        int value;
        if (this.kiH != null) {
            value = this.kiH.getValue() + 1;
        } else {
            value = super.getMonth() + 1;
        }
        return Math.max(Math.min(value, 12), 0);
    }

    public final int getDayOfMonth() {
        if (this.kiI != null) {
            return this.kiI.getValue();
        }
        return super.getDayOfMonth();
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        d.d(this.kiG);
        d.d(this.kiH);
        d.d(this.kiI);
    }

    public final String aos() {
        if (this.kiF) {
            return String.format(Locale.US, "%04d-%02d-%02d", new Object[]{Integer.valueOf(getYear()), Integer.valueOf(getMonth()), Integer.valueOf(getDayOfMonth())});
        } else if (this.kiE) {
            return String.format(Locale.US, "%04d-%02d", new Object[]{Integer.valueOf(getYear()), Integer.valueOf(getMonth())});
        } else {
            return String.format(Locale.US, "%04d", new Object[]{Integer.valueOf(getYear())});
        }
    }
}
