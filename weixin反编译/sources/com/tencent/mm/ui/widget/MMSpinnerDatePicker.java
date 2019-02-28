package com.tencent.mm.ui.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.DatePicker;
import android.widget.DatePicker.OnDateChangedListener;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.NumberPicker;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.reflect.Field;

public class MMSpinnerDatePicker extends DatePicker implements OnDateChangedListener {
    public NumberPicker zDS;
    public NumberPicker zDT;
    public NumberPicker zDU;
    public int zDV = 0;

    public MMSpinnerDatePicker(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public MMSpinnerDatePicker(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private void init() {
        setCalendarViewShown(false);
        Resources system = Resources.getSystem();
        int identifier = system.getIdentifier("year", SlookAirButtonFrequentContactAdapter.ID, "android");
        int identifier2 = system.getIdentifier("month", SlookAirButtonFrequentContactAdapter.ID, "android");
        int identifier3 = system.getIdentifier("day", SlookAirButtonFrequentContactAdapter.ID, "android");
        this.zDS = (NumberPicker) findViewById(identifier);
        this.zDT = (NumberPicker) findViewById(identifier2);
        this.zDU = (NumberPicker) findViewById(identifier3);
        View childAt = getChildAt(0);
        LayoutParams layoutParams = childAt.getLayoutParams();
        layoutParams.width = -1;
        childAt.setLayoutParams(layoutParams);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.zDS.getLayoutParams();
        layoutParams2.topMargin = 0;
        layoutParams2.bottomMargin = 0;
        layoutParams2.leftMargin = 0;
        layoutParams2.rightMargin = 0;
        layoutParams2.weight = 1.0f;
        this.zDS.setLayoutParams(layoutParams2);
        this.zDT.setLayoutParams(layoutParams2);
        this.zDU.setLayoutParams(layoutParams2);
        setDescendantFocusability(393216);
        Hs(2);
    }

    public final void Hs(int i) {
        this.zDV = i;
        if (this.zDV == 0) {
            this.zDS.setVisibility(0);
            this.zDT.setVisibility(0);
            this.zDU.setVisibility(0);
        } else if (this.zDV == 1) {
            this.zDS.setVisibility(0);
            this.zDT.setVisibility(0);
            this.zDU.setVisibility(8);
        } else {
            this.zDS.setVisibility(0);
            this.zDT.setVisibility(8);
            this.zDU.setVisibility(8);
        }
    }

    public void onDateChanged(DatePicker datePicker, int i, int i2, int i3) {
    }

    public final boolean Ht(int i) {
        try {
            Field declaredField = NumberPicker.class.getDeclaredField("mSelectionDivider");
            declaredField.setAccessible(true);
            ColorDrawable colorDrawable = new ColorDrawable();
            colorDrawable.setColor(getResources().getColor(i));
            declaredField.set(this.zDS, colorDrawable);
            declaredField.set(this.zDT, colorDrawable);
            declaredField.set(this.zDU, colorDrawable);
            invalidate();
            return true;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.MMSpinnerDatePicker", e, "", new Object[0]);
        } catch (Throwable e2) {
            x.printErrStackTrace("MicroMsg.MMSpinnerDatePicker", e2, "", new Object[0]);
        }
        return false;
    }

    public final void a(NumberPicker numberPicker, int i) {
        if (numberPicker != null) {
            EditText editText = (EditText) numberPicker.findViewById(Resources.getSystem().getIdentifier("numberpicker_input", SlookAirButtonFrequentContactAdapter.ID, "android"));
            editText.setTextSize(0, getResources().getDimension(i));
            int textSize = (int) editText.getTextSize();
            try {
                Field declaredField = NumberPicker.class.getDeclaredField("mTextSize");
                declaredField.setAccessible(true);
                declaredField.set(numberPicker, Integer.valueOf(textSize));
                Field declaredField2 = NumberPicker.class.getDeclaredField("mSelectorWheelPaint");
                declaredField2.setAccessible(true);
                Paint paint = (Paint) declaredField2.get(numberPicker);
                paint.setTextSize((float) textSize);
                declaredField2.set(numberPicker, paint);
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.MMSpinnerDatePicker", e, "", new Object[0]);
            } catch (Throwable e2) {
                x.printErrStackTrace("MicroMsg.MMSpinnerDatePicker", e2, "", new Object[0]);
            }
        }
    }
}
