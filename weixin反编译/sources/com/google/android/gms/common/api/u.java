package com.google.android.gms.common.api;

import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.IntentSender.SendIntentException;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.m;
import android.util.SparseArray;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.c.c;
import com.google.android.gms.common.e;
import com.google.android.gms.common.internal.w;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public final class u extends Fragment implements OnCancelListener {
    boolean aLO;
    private int aLP = -1;
    private ConnectionResult aLQ;
    private final Handler aLR = new Handler(Looper.getMainLooper());
    final SparseArray<a> aLS = new SparseArray();
    boolean oO;

    private class b implements Runnable {
        private final int aLX;
        private final ConnectionResult aLY;

        public b(int i, ConnectionResult connectionResult) {
            this.aLX = i;
            this.aLY = connectionResult;
        }

        public final void run() {
            if (u.this.oO && !u.this.aLO) {
                u.this.aLO = true;
                u.this.aLP = this.aLX;
                u.this.aLQ = this.aLY;
                if (this.aLY.nR()) {
                    try {
                        this.aLY.a(u.this.getActivity(), ((u.this.getActivity().getSupportFragmentManager().aU().indexOf(u.this) + 1) << 16) + 1);
                    } catch (SendIntentException e) {
                        u.this.ow();
                    }
                } else if (e.df(this.aLY.aJD)) {
                    e.a(this.aLY.aJD, u.this.getActivity(), u.this, u.this);
                } else {
                    u.this.a(this.aLX, this.aLY);
                }
            }
        }
    }

    private class a implements c {
        public final int aLT;
        public final c aLU;
        public final c aLV;

        public a(int i, c cVar, c cVar2) {
            this.aLT = i;
            this.aLU = cVar;
            this.aLV = cVar2;
            cVar.a((c) this);
        }

        public final void a(ConnectionResult connectionResult) {
            u.this.aLR.post(new b(this.aLT, connectionResult));
        }
    }

    public static u a(FragmentActivity fragmentActivity) {
        w.aN("Must be called from main thread of process");
        try {
            u uVar = (u) fragmentActivity.getSupportFragmentManager().p("GmsSupportLifecycleFragment");
            return (uVar == null || uVar.isRemoving()) ? null : uVar;
        } catch (Throwable e) {
            throw new IllegalStateException("Fragment with tag GmsSupportLifecycleFragment is not a SupportLifecycleFragment", e);
        }
    }

    private void a(int i, ConnectionResult connectionResult) {
        a aVar = (a) this.aLS.get(i);
        if (aVar != null) {
            c cVar = (a) this.aLS.get(i);
            this.aLS.remove(i);
            if (cVar != null) {
                cVar.aLU.b(cVar);
                cVar.aLU.disconnect();
            }
            c cVar2 = aVar.aLV;
            if (cVar2 != null) {
                cVar2.a(connectionResult);
            }
        }
        ow();
    }

    public static u b(FragmentActivity fragmentActivity) {
        u a = a(fragmentActivity);
        m supportFragmentManager = fragmentActivity.getSupportFragmentManager();
        if (a != null) {
            return a;
        }
        Fragment uVar = new u();
        supportFragmentManager.aT().a(uVar, "GmsSupportLifecycleFragment").commitAllowingStateLoss();
        supportFragmentManager.executePendingTransactions();
        return uVar;
    }

    private void ow() {
        boolean z = false;
        this.aLO = false;
        this.aLP = -1;
        this.aLQ = null;
        while (true) {
            boolean z2 = z;
            if (z2 < this.aLS.size()) {
                ((a) this.aLS.valueAt(z2)).aLU.connect();
                z = z2 + 1;
            } else {
                return;
            }
        }
    }

    public final void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.dump(str, fileDescriptor, printWriter, strArr);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.aLS.size()) {
                a aVar = (a) this.aLS.valueAt(i2);
                printWriter.append(str).append("GoogleApiClient #").print(aVar.aLT);
                printWriter.println(":");
                aVar.aLU.a(str + "  ", printWriter);
                i = i2 + 1;
            } else {
                return;
            }
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
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.u.onActivityResult(int, int, android.content.Intent):void");
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
        this.oO = true;
        if (!this.aLO) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.aLS.size()) {
                    ((a) this.aLS.valueAt(i2)).aLU.connect();
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public final void onStop() {
        boolean z = false;
        super.onStop();
        this.oO = false;
        while (true) {
            boolean z2 = z;
            if (z2 < this.aLS.size()) {
                ((a) this.aLS.valueAt(z2)).aLU.disconnect();
                z = z2 + 1;
            } else {
                return;
            }
        }
    }
}
