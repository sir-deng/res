package com.google.android.gms.common.api;

import android.content.Context;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.internal.h;
import com.google.android.gms.common.internal.p;
import com.google.android.gms.common.internal.w;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public final class a<O> {
    private final a<?, O> aJQ;
    final e<?, O> aJR = null;
    private final c<?> aJS;
    final f<?> aJT;
    final String mName;

    public static abstract class a<T extends b, O> {
        public abstract T a(Context context, Looper looper, h hVar, O o, com.google.android.gms.common.api.c.b bVar, com.google.android.gms.common.api.c.c cVar);

        public List<Scope> nV() {
            return Collections.emptyList();
        }
    }

    public static final class c<C extends b> {
    }

    public interface e<T extends d, O> {
        T ob();

        int oc();
    }

    public interface b {
        void a(com.google.android.gms.common.api.c.e eVar);

        void a(p pVar);

        void a(p pVar, Set<Scope> set);

        void a(String str, PrintWriter printWriter);

        void disconnect();

        boolean isConnected();

        boolean nW();

        boolean nX();
    }

    public interface d<T extends IInterface> {
        String nY();

        String nZ();

        T oa();
    }

    public static final class f<C extends d> {
    }

    public <C extends b> a(String str, a<C, O> aVar, c<C> cVar) {
        w.i(aVar, "Cannot construct an Api with a null ClientBuilder");
        w.i(cVar, "Cannot construct an Api with a null ClientKey");
        this.mName = str;
        this.aJQ = aVar;
        this.aJS = cVar;
        this.aJT = null;
    }

    public final a<?, O> nT() {
        w.d(this.aJQ != null, "This API was constructed with a SimpleClientBuilder. Use getSimpleClientBuilder");
        return this.aJQ;
    }

    public final c<?> nU() {
        w.d(this.aJS != null, "This API was constructed with a SimpleClientKey. Use getSimpleClientKey");
        return this.aJS;
    }
}
