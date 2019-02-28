package com.google.android.gms.signin.internal;

import android.accounts.Account;
import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.c;
import com.google.android.gms.common.api.c.b;
import com.google.android.gms.common.internal.AuthAccountRequest;
import com.google.android.gms.common.internal.BinderWrapper;
import com.google.android.gms.common.internal.ResolveAccountRequest;
import com.google.android.gms.common.internal.ResolveAccountResponse;
import com.google.android.gms.common.internal.h;
import com.google.android.gms.common.internal.k;
import com.google.android.gms.common.internal.p;
import com.google.android.gms.common.internal.t;
import com.google.android.gms.common.internal.w;
import com.google.android.gms.signin.d;
import com.google.android.gms.signin.e;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutorService;

public final class i extends k<f> implements d {
    private final h aKY;
    private final e aNR;
    private Integer aNS;
    private final boolean baM;
    private final ExecutorService baN;

    private static class a extends com.google.android.gms.signin.internal.d.a {
        private final e aNR;
        private final ExecutorService baN;

        public a(e eVar, ExecutorService executorService) {
            this.aNR = eVar;
            this.baN = executorService;
        }

        public final void a(final String str, final String str2, final f fVar) {
            this.baN.submit(new Runnable() {
                public final void run() {
                    try {
                        fVar.aw(a.this.aNR.bbf.of());
                    } catch (RemoteException e) {
                    }
                }
            });
        }

        public final void a(final String str, final List<Scope> list, final f fVar) {
            this.baN.submit(new Runnable() {
                public final void run() {
                    try {
                        c.d a = a.this.aNR.bbf;
                        Collections.unmodifiableSet(new HashSet(list));
                        com.google.android.gms.common.api.c.d.a oe = a.oe();
                        fVar.a(new CheckServerAuthResult(oe.aKn, oe.aKo));
                    } catch (RemoteException e) {
                    }
                }
            });
        }
    }

    public i(Context context, Looper looper, boolean z, h hVar, b bVar, c.c cVar, ExecutorService executorService) {
        super(context, looper, 44, hVar, bVar, cVar);
        this.baM = z;
        this.aKY = hVar;
        this.aNR = hVar.aNR;
        this.aNS = hVar.aNS;
        this.baN = executorService;
    }

    public final void a(p pVar, Set<Scope> set, e eVar) {
        w.i(eVar, "Expecting a valid ISignInCallbacks");
        try {
            ((f) oL()).a(new AuthAccountRequest(pVar, set), eVar);
        } catch (RemoteException e) {
            try {
                eVar.a(new ConnectionResult(8, null), new AuthAccountResult());
            } catch (RemoteException e2) {
                Log.wtf("SignInClientImpl", "ISignInCallbacks#onAuthAccount should be executed from the same process, unexpected RemoteException.");
            }
        }
    }

    public final void a(p pVar, boolean z) {
        try {
            ((f) oL()).a(pVar, this.aNS.intValue(), z);
        } catch (RemoteException e) {
        }
    }

    public final void a(t tVar) {
        w.i(tVar, "Expecting a valid IResolveAccountCallbacks");
        try {
            h hVar = this.aKY;
            ((f) oL()).a(new ResolveAccountRequest(hVar.aIz != null ? hVar.aIz : new Account("<<default account>>", "com.google"), this.aNS.intValue()), tVar);
        } catch (RemoteException e) {
            try {
                tVar.a(new ResolveAccountResponse());
            } catch (RemoteException e2) {
                Log.wtf("SignInClientImpl", "IResolveAccountCallbacks#onAccountResolutionComplete should be executed from the same process, unexpected RemoteException.");
            }
        }
    }

    public final void connect() {
        a(new f());
    }

    protected final /* synthetic */ IInterface f(IBinder iBinder) {
        return com.google.android.gms.signin.internal.f.a.p(iBinder);
    }

    public final boolean nW() {
        return this.baM;
    }

    protected final String nY() {
        return "com.google.android.gms.signin.service.START";
    }

    protected final String nZ() {
        return "com.google.android.gms.signin.internal.ISignInService";
    }

    protected final Bundle oK() {
        e eVar = this.aNR;
        Integer num = this.aKY.aNS;
        ExecutorService executorService = this.baN;
        Bundle bundle = new Bundle();
        bundle.putBoolean("com.google.android.gms.signin.internal.offlineAccessRequested", eVar.bbd);
        bundle.putBoolean("com.google.android.gms.signin.internal.idTokenRequested", eVar.bbe);
        bundle.putString("com.google.android.gms.signin.internal.serverClientId", eVar.aJx);
        if (eVar.bbf != null) {
            bundle.putParcelable("com.google.android.gms.signin.internal.signInCallbacks", new BinderWrapper(new a(eVar, executorService).asBinder()));
        }
        if (num != null) {
            bundle.putInt("com.google.android.gms.common.internal.ClientSettings.sessionId", num.intValue());
        }
        if (!this.mContext.getPackageName().equals(this.aKY.aJX)) {
            bundle.putString("com.google.android.gms.signin.internal.realClientPackageName", this.aKY.aJX);
        }
        return bundle;
    }

    public final void qv() {
        try {
            ((f) oL()).dL(this.aNS.intValue());
        } catch (RemoteException e) {
        }
    }
}
