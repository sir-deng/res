package com.google.android.gms.common.api;

import android.os.RemoteException;
import com.google.android.gms.common.api.a.c;
import com.google.android.gms.common.internal.w;
import java.util.concurrent.atomic.AtomicReference;

public final class k {

    public static abstract class a<R extends g, A extends com.google.android.gms.common.api.a.b> extends i<R> implements b<R>, e<A> {
        final c<A> aJS;
        private AtomicReference<d> aKG = new AtomicReference();

        public a(c<A> cVar, c cVar2) {
            super(((c) w.i(cVar2, "GoogleApiClient must not be null")).getLooper());
            this.aJS = (c) w.ag(cVar);
        }

        private void a(RemoteException remoteException) {
            c(new Status(remoteException.getLocalizedMessage()));
        }

        public final void a(A a) {
            try {
                b(a);
            } catch (RemoteException e) {
                a(e);
                throw e;
            } catch (RemoteException e2) {
                a(e2);
            }
        }

        public final void a(d dVar) {
            this.aKG.set(dVar);
        }

        public final /* synthetic */ void ac(Object obj) {
            super.a((g) obj);
        }

        public abstract void b(A a);

        public final void c(Status status) {
            w.e(!status.isSuccess(), "Failed result must not be success");
            a(b(status));
        }

        public final c<A> nU() {
            return this.aJS;
        }

        protected final void oi() {
            d dVar = (d) this.aKG.getAndSet(null);
            if (dVar != null) {
                dVar.c(this);
            }
        }
    }

    public interface b<R> {
        void ac(R r);

        void c(Status status);
    }
}
