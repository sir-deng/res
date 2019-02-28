package com.google.android.gms.analytics.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.google.android.gms.analytics.internal.m.AnonymousClass1;
import com.google.android.gms.common.internal.w;

class g extends BroadcastReceiver {
    static final String aFn = g.class.getName();
    final q aFo;
    boolean aFp;
    boolean aFq;

    g(q qVar) {
        w.ag(qVar);
        this.aFo = qVar;
    }

    void mp() {
        this.aFo.mT();
        this.aFo.mV();
    }

    boolean mq() {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.aFo.mContext.getSystemService("connectivity")).getActiveNetworkInfo();
            return activeNetworkInfo != null && activeNetworkInfo.isConnected();
        } catch (SecurityException e) {
            return false;
        }
    }

    public void onReceive(Context context, Intent intent) {
        mp();
        String action = intent.getAction();
        this.aFo.mT().c("NetworkBroadcastReceiver received action", action);
        if ("android.net.conn.CONNECTIVITY_CHANGE".equals(action)) {
            boolean mq = mq();
            if (this.aFq != mq) {
                this.aFq = mq;
                n mV = this.aFo.mV();
                mV.c("Network connectivity status changed", Boolean.valueOf(mq));
                mV.aFo.mU().d(new AnonymousClass1(mq));
            }
        } else if (!"com.google.analytics.RADIO_POWERED".equals(action)) {
            this.aFo.mT().e("NetworkBroadcastReceiver received unknown action", action);
        } else if (!intent.hasExtra(aFn)) {
            m mV2 = this.aFo.mV();
            mV2.au("Radio powered up");
            mV2.mK();
        }
    }

    public final void unregister() {
        if (this.aFp) {
            this.aFo.mT().au("Unregistering connectivity change receiver");
            this.aFp = false;
            this.aFq = false;
            try {
                this.aFo.mContext.unregisterReceiver(this);
            } catch (IllegalArgumentException e) {
                this.aFo.mT().f("Failed to unregister the network broadcast receiver", e);
            }
        }
    }
}
