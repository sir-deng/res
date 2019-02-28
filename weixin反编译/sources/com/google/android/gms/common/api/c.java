package com.google.android.gms.common.api;

import android.accounts.Account;
import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import com.google.android.gms.c.m;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.h;
import com.google.android.gms.common.internal.w;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public interface c {

    public static final class a {
        private Account aIz;
        public final Set<Scope> aJU = new HashSet();
        private int aJV;
        private View aJW;
        private String aJX;
        private String aJY;
        private final Map<a<?>, com.google.android.gms.common.internal.h.a> aJZ = new m();
        public final Map<a<?>, Object> aKa = new m();
        public FragmentActivity aKb;
        public int aKc = -1;
        public int aKd = -1;
        public c aKe;
        public Looper aKf;
        public com.google.android.gms.common.b aKg = com.google.android.gms.common.b.nS();
        public com.google.android.gms.common.api.a.a<? extends com.google.android.gms.signin.d, com.google.android.gms.signin.e> aKh = com.google.android.gms.signin.b.baV;
        public final ArrayList<b> aKi = new ArrayList();
        public final ArrayList<c> aKj = new ArrayList();
        private com.google.android.gms.signin.e.a aKk = new com.google.android.gms.signin.e.a();
        public final Context mContext;

        /* renamed from: com.google.android.gms.common.api.c$a$1 */
        class AnonymousClass1 implements Runnable {
            final /* synthetic */ c aKl;

            public AnonymousClass1(c cVar) {
                this.aKl = cVar;
            }

            public final void run() {
                if (!a.this.aKb.isFinishing() && !a.this.aKb.getSupportFragmentManager().isDestroyed()) {
                    a.this.a(u.b(a.this.aKb), this.aKl);
                }
            }
        }

        public a(Context context) {
            this.mContext = context;
            this.aKf = context.getMainLooper();
            this.aJX = context.getPackageName();
            this.aJY = context.getClass().getName();
        }

        public final void a(u uVar, c cVar) {
            int i = this.aKc;
            c cVar2 = this.aKe;
            w.i(cVar, "GoogleApiClient instance cannot be null");
            w.d(uVar.aLS.indexOfKey(i) < 0, "Already managing a GoogleApiClient with id " + i);
            uVar.aLS.put(i, new a(i, cVar, cVar2));
            if (uVar.oO && !uVar.aLO) {
                cVar.connect();
            }
        }

        public final h od() {
            return new h(this.aIz, this.aJU, this.aJZ, this.aJV, this.aJW, this.aJX, this.aJY, this.aKk.qw());
        }
    }

    public interface c {
        void a(ConnectionResult connectionResult);
    }

    public interface e {
        void b(ConnectionResult connectionResult);

        void c(ConnectionResult connectionResult);
    }

    public interface b {
        void dh(int i);

        void e(Bundle bundle);
    }

    public interface d {

        public static class a {
            public boolean aKn;
            public Set<Scope> aKo;
        }

        a oe();

        boolean of();
    }

    ConnectionResult a(TimeUnit timeUnit);

    <A extends com.google.android.gms.common.api.a.b, R extends g, T extends com.google.android.gms.common.api.k.a<R, A>> T a(T t);

    void a(b bVar);

    void a(c cVar);

    void a(String str, PrintWriter printWriter);

    <A extends com.google.android.gms.common.api.a.b, T extends com.google.android.gms.common.api.k.a<? extends g, A>> T b(T t);

    void b(b bVar);

    void b(c cVar);

    void connect();

    void disconnect();

    Looper getLooper();

    boolean isConnected();

    boolean isConnecting();
}
