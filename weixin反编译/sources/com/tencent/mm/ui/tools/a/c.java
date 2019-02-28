package com.tencent.mm.ui.tools.a;

import android.text.InputFilter;
import android.widget.EditText;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.tools.h;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class c extends a {
    private String kav;
    public int kdI;
    public boolean zwQ = true;
    public WeakReference<EditText> zwR;
    private int zwS;
    private int zwT;
    private ArrayList<InputFilter> zwU;
    public a zwV;

    public interface a {
        void aeD();

        void anp();

        void vE(String str);
    }

    public c(WeakReference<EditText> weakReference) {
        this.zwR = weakReference;
        this.kdI = com.tencent.mm.ui.tools.h.a.ztY;
        this.zwQ = false;
    }

    public static c d(EditText editText) {
        return new c(new WeakReference(editText));
    }

    public final c fl(int i, int i2) {
        this.zwT = i;
        this.zwS = i2;
        return this;
    }

    public final c Hg(int i) {
        this.zwT = 0;
        this.zwS = i;
        return this;
    }

    public final void a(a aVar) {
        this.zwV = aVar;
        ccW();
    }

    protected final int adu() {
        Object obj;
        if (bi.oN(this.kav)) {
            if (this.zwR == null) {
                return 1;
            }
            this.kav = ((EditText) this.zwR.get()).getText().toString().trim();
        }
        int dx = h.dx(this.kav, this.kdI);
        if (dx < 0) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj != null) {
            x.w("MicroMsg.InputTextBoundaryCheck", "you are crazy =.=!that is 2 GB character!");
            return 2;
        } else if (dx < this.zwT) {
            return 1;
        } else {
            if (dx > this.zwS) {
                return 2;
            }
            return 0;
        }
    }

    protected final void ccW() {
        if (!this.zwQ) {
            if (this.zwR == null) {
                x.w("MicroMsg.InputTextBoundaryCheck", "edit text view is null");
                return;
            } else if (bi.cC(this.zwU)) {
                ((EditText) this.zwR.get()).setFilters(new InputFilter[]{bZ(this.zwS, this.kdI)});
            } else {
                this.zwU.add(bZ(this.zwS, this.kdI));
                ((EditText) this.zwR.get()).setFilters((InputFilter[]) this.zwU.toArray(new InputFilter[this.zwU.size()]));
            }
        }
        if (this.zwV != null) {
            switch (adu()) {
                case 0:
                    this.zwV.vE(this.kav);
                    return;
                case 1:
                    this.zwV.anp();
                    return;
                case 2:
                    this.zwV.aeD();
                    return;
                default:
                    return;
            }
        }
    }

    public h bZ(int i, int i2) {
        return new h(i, i2);
    }
}
