package com.d.a.a;

import android.content.Context;
import android.os.Handler;

abstract class a extends d implements m {
    private final d[] bgA;
    private final Handler[] bgB = new Handler[this.bgA.length];
    private final a[] bgC = new a[this.bgB.length];

    abstract void a(Handler handler, Handler[] handlerArr);

    abstract void a(a aVar, a[] aVarArr);

    a(d... dVarArr) {
        this.bgA = dVarArr;
    }

    final void U(Context context) {
        for (d a : this.bgA) {
            try {
                a.a(context, this);
            } catch (Exception e) {
            }
        }
    }

    void a(Context context, Handler handler, a aVar) {
        a(handler, this.bgB);
        a(aVar, this.bgC);
        for (int i = 0; i < this.bgA.length; i++) {
            try {
                this.bgA[i].a(this.bgB[i], this.bgC[i]);
            } catch (Exception e) {
            }
        }
    }

    final void V(Context context) {
        for (d stop : this.bgA) {
            stop.stop();
        }
    }

    final void rS() {
        for (d rV : this.bgA) {
            rV.rV();
        }
    }
}
