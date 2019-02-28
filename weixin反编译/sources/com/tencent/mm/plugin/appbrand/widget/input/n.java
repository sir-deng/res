package com.tencent.mm.plugin.appbrand.widget.input;

import android.text.Spanned;
import android.widget.EditText;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.ui.tools.a.c;
import com.tencent.mm.ui.tools.h;
import java.lang.ref.WeakReference;

public final class n extends c {

    private final class b extends h {
        private final int kdH;
        private final int kdI;

        b(int i, int i2) {
            super(i, i2);
            this.kdH = i;
            this.kdI = i2;
        }

        public final CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
            int i5 = 0;
            if (h.dx(spanned.subSequence(0, i3).toString() + spanned.subSequence(i4, spanned.length()).toString(), this.kdI) + h.dx(charSequence.subSequence(i, i2).toString(), this.kdI) > this.kdH) {
                i5 = 1;
            }
            if (i5 != 0) {
                charSequence = charSequence.subSequence(i, Math.max(i, Math.min(this.kdH - (spanned.length() - (i4 - i3)), i2)));
            }
            if (i5 != 0 && bi.N(charSequence)) {
                EditText editText = n.this.zwR == null ? null : (EditText) n.this.zwR.get();
                final com.tencent.mm.ui.tools.a.c.a aVar = n.this.zwV;
                if (!(editText == null || aVar == null)) {
                    editText.post(new Runnable() {
                        public final void run() {
                            aVar.aeD();
                        }
                    });
                }
            }
            return charSequence;
        }
    }

    public static abstract class a implements com.tencent.mm.ui.tools.a.c.a {
        public final void vE(String str) {
        }

        public final void anp() {
        }

        public void aeD() {
        }
    }

    private n(WeakReference<EditText> weakReference) {
        super(weakReference);
    }

    public static n a(EditText editText) {
        return new n(new WeakReference(editText));
    }

    protected final h bZ(int i, int i2) {
        return new b(i, i2);
    }
}
