package com.tencent.mm.ap.a.a;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.mm.ap.a.b.c;
import com.tencent.mm.ap.a.b.d;
import com.tencent.mm.ap.a.c.e;
import com.tencent.mm.ap.a.c.f;
import com.tencent.mm.ap.a.c.h;
import com.tencent.mm.ap.a.c.j;
import com.tencent.mm.ap.a.c.k;
import com.tencent.mm.ap.a.c.m;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public final class b {
    public static final int hEU = Runtime.getRuntime().availableProcessors();
    public final Resources hEV;
    public final int hEW;
    public final int hEX;
    public final c hEY;
    public final m hEZ;
    public final com.tencent.mm.ap.a.c.a hFa;
    public final com.tencent.mm.ap.a.c.b hFb;
    public final f hFc;
    public final j hFd;
    public final k hFe;
    public final e hFf;
    public final h hFg;
    public final Executor hFh;
    public final String packageName;

    public static class a {
        Context context;
        int hEW = b.hEU;
        int hEX = 5;
        c hEY = null;
        public m hEZ = null;
        com.tencent.mm.ap.a.c.a hFa = null;
        public com.tencent.mm.ap.a.c.b hFb = null;
        f hFc = null;
        j hFd = null;
        e hFf = null;
        h hFg = null;
        Executor hFh;
        k hFi = null;

        public a(Context context) {
            this.context = context.getApplicationContext();
        }

        public final b PP() {
            if (this.hEY == null) {
                this.hEY = new com.tencent.mm.ap.a.a.c.a().PQ();
            }
            if (this.hEZ == null) {
                this.hEZ = new com.tencent.mm.ap.a.b.f();
            }
            if (this.hFa == null) {
                this.hFa = new com.tencent.mm.ap.a.b.a();
            }
            if (this.hFb == null) {
                this.hFb = new com.tencent.mm.ap.a.b.b();
            }
            if (this.hFc == null) {
                this.hFc = new d();
            }
            if (this.hFd == null) {
                this.hFd = new com.tencent.mm.ap.a.b.h();
            }
            if (this.hFg == null) {
                this.hFg = a.bb(this.hEW, this.hEX);
            }
            if (this.hFh == null) {
                this.hFh = Executors.newSingleThreadExecutor();
            }
            if (this.hFi == null) {
                this.hFi = new com.tencent.mm.ap.a.b.e();
            }
            if (this.hFf == null) {
                this.hFf = new c();
            }
            return new b(this);
        }
    }

    public b(a aVar) {
        this.packageName = aVar.context.getPackageName();
        this.hEV = aVar.context.getResources();
        this.hEW = aVar.hEW;
        this.hEX = aVar.hEX;
        this.hEY = aVar.hEY;
        this.hEZ = aVar.hEZ;
        this.hFa = aVar.hFa;
        this.hFb = aVar.hFb;
        this.hFc = aVar.hFc;
        this.hFd = aVar.hFd;
        this.hFg = aVar.hFg;
        this.hFh = aVar.hFh;
        this.hFe = aVar.hFi;
        this.hFf = aVar.hFf;
    }

    public static b bl(Context context) {
        return new a(context).PP();
    }
}
