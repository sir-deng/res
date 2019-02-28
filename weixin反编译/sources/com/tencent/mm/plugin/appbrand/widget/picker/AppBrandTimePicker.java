package com.tencent.mm.plugin.appbrand.widget.picker;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.annotation.Keep;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.widget.NumberPicker;
import android.widget.NumberPicker.OnValueChangeListener;
import android.widget.TimePicker;
import com.tencent.mm.compatible.loader.c;
import com.tencent.mm.plugin.appbrand.q.f;
import com.tencent.mm.plugin.appbrand.q.k;
import com.tencent.mm.ui.widget.picker.d;
import java.util.Locale;

public final class AppBrandTimePicker extends TimePicker implements e<String> {
    public int jta = -1;
    public int jtb = -1;
    public int jtc = -1;
    public int jtd = -1;
    public NumberPicker kjh;
    private NumberPicker kji;

    public final /* synthetic */ Object aoq() {
        return String.format(Locale.US, "%02d:%02d", new Object[]{getCurrentHour(), getCurrentMinute()});
    }

    @Keep
    public AppBrandTimePicker(Context context) {
        super(new ContextThemeWrapper(context, k.iEx));
        setIs24HourView(Boolean.valueOf(true));
        this.kjh = vI("mHourSpinner");
        this.kji = vI("mMinuteSpinner");
        d.c(this.kjh);
        d.c(this.kji);
        f.a(this.kjh);
        f.a(this.kji);
        Drawable drawable = getResources().getDrawable(f.ivD);
        d.a(this.kjh, drawable);
        d.a(this.kji, drawable);
        if (this.kjh != null) {
            this.kjh.setOnValueChangedListener(new OnValueChangeListener() {
                public final void onValueChange(NumberPicker numberPicker, int i, int i2) {
                    AppBrandTimePicker.this.aou();
                }
            });
        }
        if (this.kji != null && VERSION.SDK_INT >= 21) {
            this.kji.setOnValueChangedListener(new OnValueChangeListener() {
                public final void onValueChange(NumberPicker numberPicker, int i, int i2) {
                }
            });
        }
        d.e(this.kjh);
        d.e(this.kji);
    }

    public final void aou() {
        if (g.mG(this.jta) && g.mF(this.jtb) && this.kjh != null && this.kji != null) {
            if (this.kjh.getValue() == this.jta) {
                this.kji.setMinValue(this.jtb);
            } else {
                this.kji.setMinValue(0);
            }
        }
        if (g.mG(this.jtc) && this.kjh != null && this.kji != null) {
            if (this.kjh.getValue() == this.jtc) {
                this.kji.setMaxValue(this.jtd);
            } else {
                this.kji.setMaxValue(59);
            }
        }
    }

    public final void setCurrentMinute(Integer num) {
        super.setCurrentMinute(Integer.valueOf(num == null ? 0 : num.intValue()));
        aou();
    }

    public final void setCurrentHour(Integer num) {
        super.setCurrentHour(Integer.valueOf(num == null ? 0 : num.intValue()));
        aou();
    }

    private NumberPicker vI(String str) {
        if (VERSION.SDK_INT >= 21) {
            return vK(str);
        }
        return vJ(str);
    }

    private NumberPicker vJ(String str) {
        try {
            return (NumberPicker) new c(this, str, null).get();
        } catch (Exception e) {
            return null;
        }
    }

    private NumberPicker vK(String str) {
        try {
            Object obj = new c(this, "mDelegate", null).get();
            if (obj != null) {
                return (NumberPicker) new c(obj, str, null).get();
            }
        } catch (Exception e) {
        }
        return null;
    }

    protected final void onAttachedToWindow() {
        super.onAttachedToWindow();
        d.d(this.kjh);
        d.d(this.kji);
    }

    public final View getView() {
        return this;
    }

    public final void a(d dVar) {
    }

    public final void aoo() {
    }

    public final void b(d dVar) {
    }

    public final void aop() {
    }
}
