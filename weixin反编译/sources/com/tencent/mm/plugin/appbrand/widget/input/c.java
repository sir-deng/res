package com.tencent.mm.plugin.appbrand.widget.input;

import android.graphics.Rect;
import android.text.Editable;
import android.text.Selection;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.widget.EditText;
import com.tencent.mm.plugin.appbrand.jsapi.map.b;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.appbrand.widget.input.b.e;
import com.tencent.mm.plugin.appbrand.widget.input.b.h;
import com.tencent.mm.ui.widget.j;
import java.lang.ref.WeakReference;

public abstract class c<Input extends EditText & z> extends j implements y {
    private final com.tencent.mm.ui.tools.a.c.a inputExceedMaxLengthCallback = new com.tencent.mm.plugin.appbrand.widget.input.n.a() {
        public final void aeD() {
            if (c.this.anc() != null) {
                c.this.b(c.this.anc().getEditableText());
            }
        }
    };
    public ab kct;
    public aa kcu;
    final String kcv;
    public final WeakReference<p> kcw;
    public final OnFocusChangeListener kcx = new OnFocusChangeListener() {
        public final void onFocusChange(View view, boolean z) {
            c.this.dv(z);
            if (z) {
                m.a((p) c.this.kcw.get(), (z) c.this.anc());
                ((z) c.this.anc()).mu(c.this.getInputId());
                m.a(c.this.getInputId(), c.this);
            }
        }
    };

    enum a {
        ;

        public static c a(String str, p pVar, e eVar) {
            if ("digit".equalsIgnoreCase(str) || "idcard".equalsIgnoreCase(str) || "number".equalsIgnoreCase(str)) {
                return new d(str, pVar, eVar);
            }
            return null;
        }
    }

    public abstract Input anc();

    public abstract Rect and();

    protected abstract h b(h hVar);

    protected abstract boolean dv(boolean z);

    public abstract int getInputId();

    public abstract boolean vC(String str);

    c(String str, p pVar) {
        this.kcv = str;
        this.kcw = new WeakReference(pVar);
    }

    public boolean removeSelf() {
        return ane();
    }

    public Input getWidget() {
        return anc();
    }

    public final boolean ane() {
        View anc = anc();
        if (anc == null) {
            return false;
        }
        ((z) anc).b(this.kcx);
        anc.removeTextChangedListener(this);
        ((z) anc).destroy();
        p pVar = (p) this.kcw.get();
        if (pVar == null) {
            return false;
        }
        f fVar = pVar.jJv;
        if (fVar == null) {
            return false;
        }
        fVar.bR(anc);
        return true;
    }

    public boolean isAttachedTo(p pVar) {
        return pVar != null && pVar == this.kcw.get();
    }

    final void a(Editable editable) {
        if (this.kct != null) {
            this.kct.a(editable == null ? "" : editable.toString(), Selection.getSelectionEnd(editable), com.tencent.mm.plugin.appbrand.widget.input.ab.a.COMPLETE);
        }
    }

    public final void kB(int i) {
        if (this.kcu != null) {
            this.kcu.ml(i);
        }
    }

    public final void afterTextChanged(Editable editable) {
        b(editable);
    }

    private void b(Editable editable) {
        if (this.kct != null) {
            this.kct.a(editable == null ? "" : editable.toString(), Selection.getSelectionEnd(editable), com.tencent.mm.plugin.appbrand.widget.input.ab.a.CHANGED);
        }
    }

    public final boolean a(h hVar) {
        h b = b(hVar);
        if (b == null) {
            return false;
        }
        if (b.khG == null) {
            b.khG = Integer.valueOf(b.CTRL_INDEX);
        } else if (b.khG.intValue() <= 0) {
            b.khG = Integer.valueOf(Integer.MAX_VALUE);
        }
        if (anc() == null) {
            return false;
        }
        com.tencent.mm.ui.tools.a.c Hg = n.a(anc()).Hg(b.khG.intValue());
        Hg.zwQ = false;
        Hg.kdI = com.tencent.mm.ui.tools.h.a.ztX;
        Hg.a(this.inputExceedMaxLengthCallback);
        return true;
    }

    public final void updateValue(String str, Integer num) {
        vC(str);
        Integer valueOf = Integer.valueOf(num == null ? -1 : num.intValue());
        setInputSelection(valueOf.intValue(), valueOf.intValue());
    }

    public final Editable anf() {
        return anc() == null ? null : anc().getEditableText();
    }

    protected final void setInputSelection(int i, int i2) {
        b.a(anc(), i, i2);
    }
}
