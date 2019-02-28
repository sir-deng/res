package com.tencent.mm.vending.base;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

public final class c {
    private Handler mVendingHandler;
    private Looper mVendingLooper;
    private Looper zKO;
    private Handler zKP;
    byte[] zKQ = new byte[0];
    a zKR;

    public interface a {
        void cAB();

        void cAC();

        void synchronizing(int i, Object obj);
    }

    public c(Looper looper, Looper looper2) {
        this.zKO = looper;
        this.mVendingLooper = looper2;
        this.zKP = new Handler(this.zKO) {
            public final void handleMessage(Message message) {
                c.this.k(message.what, message.obj);
            }
        };
        this.mVendingHandler = new Handler(this.mVendingLooper) {
            public final void handleMessage(Message message) {
                synchronized (c.this.zKQ) {
                    if (c.this.zKR != null) {
                        c.this.zKR.synchronizing(message.what, message.obj);
                    }
                    c.this.zKQ.notify();
                }
            }
        };
    }

    public final void k(int i, Object obj) {
        if (Looper.myLooper() == this.zKO) {
            if (this.zKR == null) {
                com.tencent.mm.vending.f.a.w("Vending.VendingSync", "This call is pointless.", new Object[0]);
                return;
            }
            this.zKR.cAB();
            synchronized (this.zKQ) {
                this.mVendingHandler.sendMessageAtFrontOfQueue(this.mVendingHandler.obtainMessage(i, obj));
                try {
                    this.zKQ.wait();
                } catch (InterruptedException e) {
                }
            }
            this.zKR.cAC();
        } else if (Looper.myLooper() == this.mVendingLooper) {
            this.zKP.sendMessageAtFrontOfQueue(this.zKP.obtainMessage(i, obj));
        }
    }
}
