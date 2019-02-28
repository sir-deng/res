package com.tencent.mm.plugin.collect.reward.a;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.ui.base.h;
import java.lang.ref.WeakReference;

public abstract class a extends k implements com.tencent.mm.network.k {
    protected int errCode = 0;
    protected int errType = 0;
    protected String foE;
    protected WeakReference<Activity> lpa;
    protected boolean lpb = false;
    protected boolean lpc = false;

    public interface a {
        void i(k kVar);
    }

    protected abstract void b(int i, int i2, String str, q qVar);

    protected boolean azy() {
        return true;
    }

    public final void m(Activity activity) {
        this.lpa = new WeakReference(activity);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        if (!(i2 == 0 && i3 == 0)) {
            this.lpb = true;
            if (azy() && this.lpa != null) {
                Context context = (Activity) this.lpa.get();
                if (context != null) {
                    h.a(context, context.getString(i.vdG), null, false, new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                        }
                    });
                }
            }
        }
        this.errCode = i3;
        this.errType = i2;
        this.foE = str;
        b(i2, i3, str, qVar);
    }

    public final a a(a aVar) {
        if (!(this.lpb || this.lpc)) {
            aVar.i(this);
        }
        return this;
    }

    public final a b(a aVar) {
        if (this.lpc) {
            aVar.i(this);
        }
        return this;
    }

    public final a c(a aVar) {
        if (this.lpb) {
            aVar.i(this);
        }
        return this;
    }
}
