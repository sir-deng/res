package com.tencent.mm.plugin.appbrand.widget.picker;

import android.text.Editable;
import android.text.Editable.Factory;
import android.text.SpannableStringBuilder;
import android.widget.EditText;
import android.widget.NumberPicker;
import com.tencent.mm.compatible.loader.c;

final class f {
    static void a(NumberPicker numberPicker) {
        if (numberPicker != null) {
            try {
                EditText editText = (EditText) new c(numberPicker, "mInputText", null).get();
                if (editText != null) {
                    editText.setEditableFactory(new Factory() {
                        public final Editable newEditable(CharSequence charSequence) {
                            return new SpannableStringBuilder(charSequence) {
                                public final void setSpan(Object obj, int i, int i2, int i3) {
                                    try {
                                        super.setSpan(obj, i, i2, i3);
                                    } catch (Exception e) {
                                    }
                                }
                            };
                        }
                    });
                }
            } catch (Exception e) {
            }
        }
    }
}
