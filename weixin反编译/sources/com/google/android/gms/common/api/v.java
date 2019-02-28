package com.google.android.gms.common.api;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.IntentSender.SendIntentException;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.m;
import android.support.v4.app.t;
import android.util.SparseArray;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.e;
import com.google.android.gms.common.internal.w;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public final class v extends Fragment implements OnCancelListener, android.support.v4.app.t.a<ConnectionResult> {
    private boolean aLO;
    private int aLP = -1;
    private ConnectionResult aLQ;
    private final Handler aLR = new Handler(Looper.getMainLooper());
    public final SparseArray<b> aLS = new SparseArray();

    private class c implements Runnable {
        private final int aLX;
        private final ConnectionResult aLY;

        public c(int i, ConnectionResult connectionResult) {
            this.aLX = i;
            this.aLY = connectionResult;
        }

        public final void run() {
            if (this.aLY.nR()) {
                try {
                    this.aLY.a(v.this.getActivity(), ((v.this.getActivity().getSupportFragmentManager().aU().indexOf(v.this) + 1) << 16) + 1);
                } catch (SendIntentException e) {
                    v.this.ow();
                }
            } else if (e.df(this.aLY.aJD)) {
                e.a(this.aLY.aJD, v.this.getActivity(), v.this, v.this);
            } else {
                v.this.a(this.aLX, this.aLY);
            }
        }
    }

    private static class b {
        public final c aLU;
        public final com.google.android.gms.common.api.c.c aLV;

        private b(c cVar, com.google.android.gms.common.api.c.c cVar2) {
            this.aLU = cVar;
            this.aLV = cVar2;
        }

        public /* synthetic */ b(c cVar, com.google.android.gms.common.api.c.c cVar2, byte b) {
            this(cVar, cVar2);
        }
    }

    static class a extends android.support.v4.content.c<ConnectionResult> implements com.google.android.gms.common.api.c.b, com.google.android.gms.common.api.c.c {
        public final c aLU;
        boolean aLZ;
        private ConnectionResult aMa;

        public a(Context context, c cVar) {
            super(context);
            this.aLU = cVar;
        }

        private void g(ConnectionResult connectionResult) {
            this.aMa = connectionResult;
            if (this.oO && !this.tE) {
                deliverResult(connectionResult);
            }
        }

        public final void a(ConnectionResult connectionResult) {
            this.aLZ = true;
            g(connectionResult);
        }

        public final void dh(int i) {
        }

        public final void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            super.dump(str, fileDescriptor, printWriter, strArr);
            this.aLU.a(str, printWriter);
        }

        public final void e(Bundle bundle) {
            this.aLZ = false;
            g(ConnectionResult.aJC);
        }

        protected final void onReset() {
            this.aMa = null;
            this.aLZ = false;
            this.aLU.b((com.google.android.gms.common.api.c.b) this);
            this.aLU.b((com.google.android.gms.common.api.c.c) this);
            this.aLU.disconnect();
        }

        protected final void onStartLoading() {
            super.onStartLoading();
            this.aLU.a((com.google.android.gms.common.api.c.b) this);
            this.aLU.a((com.google.android.gms.common.api.c.c) this);
            if (this.aMa != null) {
                deliverResult(this.aMa);
            }
            if (!this.aLU.isConnected() && !this.aLU.isConnecting() && !this.aLZ) {
                this.aLU.connect();
            }
        }

        protected final void onStopLoading() {
            this.aLU.disconnect();
        }
    }

    private void a(int i, ConnectionResult connectionResult) {
        b bVar = (b) this.aLS.get(i);
        if (bVar != null) {
            this.aLS.remove(i);
            getLoaderManager().destroyLoader(i);
            com.google.android.gms.common.api.c.c cVar = bVar.aLV;
            if (cVar != null) {
                cVar.a(connectionResult);
            }
        }
        ow();
    }

    public static v c(FragmentActivity fragmentActivity) {
        w.aN("Must be called from main thread of process");
        m supportFragmentManager = fragmentActivity.getSupportFragmentManager();
        try {
            v vVar = (v) supportFragmentManager.p("GmsSupportLoaderLifecycleFragment");
            if (vVar != null && !vVar.isRemoving()) {
                return vVar;
            }
            Fragment vVar2 = new v();
            supportFragmentManager.aT().a(vVar2, "GmsSupportLoaderLifecycleFragment").commit();
            supportFragmentManager.executePendingTransactions();
            return vVar2;
        } catch (Throwable e) {
            throw new IllegalStateException("Fragment with tag GmsSupportLoaderLifecycleFragment is not a SupportLoaderLifecycleFragment", e);
        }
    }

    private void ow() {
        int i = 0;
        this.aLO = false;
        this.aLP = -1;
        this.aLQ = null;
        t loaderManager = getLoaderManager();
        while (i < this.aLS.size()) {
            int keyAt = this.aLS.keyAt(i);
            a dk = dk(keyAt);
            if (dk != null && dk.aLZ) {
                loaderManager.destroyLoader(keyAt);
                loaderManager.a(keyAt, this);
            }
            i++;
        }
    }

    public final android.support.v4.content.c<ConnectionResult> T(int i) {
        return new a(getActivity(), ((b) this.aLS.get(i)).aLU);
    }

    public final /* synthetic */ void a(android.support.v4.content.c cVar, Object obj) {
        ConnectionResult connectionResult = (ConnectionResult) obj;
        if (!connectionResult.isSuccess()) {
            int i = cVar.mId;
            if (!this.aLO) {
                this.aLO = true;
                this.aLP = i;
                this.aLQ = connectionResult;
                this.aLR.post(new c(i, connectionResult));
            }
        }
    }

    public final a dk(int i) {
        try {
            return (a) getLoaderManager().S(i);
        } catch (Throwable e) {
            throw new IllegalStateException("Unknown loader in SupportLoaderLifecycleFragment", e);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onActivityResult(int r4, int r5, android.content.Intent r6) {
        /*
        r3 = this;
        r0 = 1;
        r1 = 0;
        switch(r4) {
            case 1: goto L_0x0017;
            case 2: goto L_0x000c;
            default: goto L_0x0005;
        };
    L_0x0005:
        r0 = r1;
    L_0x0006:
        if (r0 == 0) goto L_0x001b;
    L_0x0008:
        r3.ow();
    L_0x000b:
        return;
    L_0x000c:
        r2 = r3.getActivity();
        r2 = com.google.android.gms.common.e.C(r2);
        if (r2 != 0) goto L_0x0005;
    L_0x0016:
        goto L_0x0006;
    L_0x0017:
        r2 = -1;
        if (r5 != r2) goto L_0x0005;
    L_0x001a:
        goto L_0x0006;
    L_0x001b:
        r0 = r3.aLP;
        r1 = r3.aLQ;
        r3.a(r0, r1);
        goto L_0x000b;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.v.onActivityResult(int, int, android.content.Intent):void");
    }

    public final void onAttach(Activity activity) {
        super.onAttach(activity);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.aLS.size()) {
                int keyAt = this.aLS.keyAt(i2);
                a dk = dk(keyAt);
                if (dk == null || ((b) this.aLS.valueAt(i2)).aLU == dk.aLU) {
                    getLoaderManager().a(keyAt, this);
                } else {
                    getLoaderManager().b(keyAt, this);
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public final void onCancel(DialogInterface dialogInterface) {
        a(this.aLP, new ConnectionResult(13, null));
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            this.aLO = bundle.getBoolean("resolving_error", false);
            this.aLP = bundle.getInt("failed_client_id", -1);
            if (this.aLP >= 0) {
                this.aLQ = new ConnectionResult(bundle.getInt("failed_status"), (PendingIntent) bundle.getParcelable("failed_resolution"));
            }
        }
    }

    public final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("resolving_error", this.aLO);
        if (this.aLP >= 0) {
            bundle.putInt("failed_client_id", this.aLP);
            bundle.putInt("failed_status", this.aLQ.aJD);
            bundle.putParcelable("failed_resolution", this.aLQ.aJE);
        }
    }

    public final void onStart() {
        super.onStart();
        if (!this.aLO) {
            for (int i = 0; i < this.aLS.size(); i++) {
                getLoaderManager().a(this.aLS.keyAt(i), this);
            }
        }
    }
}
