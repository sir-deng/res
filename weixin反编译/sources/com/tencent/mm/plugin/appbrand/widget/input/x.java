package com.tencent.mm.plugin.appbrand.widget.input;

import android.os.Looper;
import android.text.Editable;
import android.text.SpanWatcher;
import android.text.Spannable;
import android.text.TextWatcher;
import android.widget.EditText;
import com.tencent.mm.plugin.appbrand.widget.input.a.b;
import com.tencent.mm.sdk.platformtools.ag;

public final class x {
    final ag jQE;
    private final EditText kT;
    public b keU;
    final Runnable keV = new Runnable() {
        public final void run() {
            if (x.this.keU != null) {
                x.this.keU.aeE();
            }
        }
    };

    public x(EditText editText) {
        this.kT = editText;
        this.jQE = new ag(Looper.getMainLooper());
    }

    public final Editable c(Editable editable) {
        editable.setSpan(new SpanWatcher() {
            public final void onSpanAdded(Spannable spannable, Object obj, int i, int i2) {
                if (af.bn(obj)) {
                    com.tencent.mm.sdk.platformtools.x.d("MicroMsg.EditTextComposingTextDismissedObserver", "[bindInput] onSpanAdded %s, %s", spannable, obj.getClass().getSimpleName());
                }
            }

            public final void onSpanRemoved(Spannable spannable, Object obj, int i, int i2) {
                if (af.bn(obj)) {
                    com.tencent.mm.sdk.platformtools.x.d("MicroMsg.EditTextComposingTextDismissedObserver", "[bindInput] onSpanRemoved %s, %s", spannable, obj.getClass().getSimpleName());
                    x.this.jQE.removeCallbacks(x.this.keV);
                    x.this.jQE.postDelayed(x.this.keV, 100);
                }
            }

            public final void onSpanChanged(Spannable spannable, Object obj, int i, int i2, int i3, int i4) {
                if (af.bn(obj)) {
                    com.tencent.mm.sdk.platformtools.x.d("MicroMsg.EditTextComposingTextDismissedObserver", "[bindInput] onSpanChanged %s, %s", spannable, obj.getClass().getSimpleName());
                }
            }
        }, 0, editable.length(), 18);
        editable.setSpan(new TextWatcher() {
            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                x.this.jQE.removeCallbacks(x.this.keV);
            }

            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void afterTextChanged(Editable editable) {
            }
        }, 0, editable.length(), 18);
        return editable;
    }
}
