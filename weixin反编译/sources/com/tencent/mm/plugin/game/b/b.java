package com.tencent.mm.plugin.game.b;

import com.tencent.mm.plugin.fts.a.a.g;
import com.tencent.mm.plugin.fts.a.l;
import com.tencent.mm.plugin.fts.a.m;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.sdk.platformtools.x;

public final class b extends com.tencent.mm.plugin.fts.a.b {
    l gKV;
    private com.tencent.mm.sdk.e.j.a iZf = new com.tencent.mm.sdk.e.j.a() {
        public final void a(String str, com.tencent.mm.sdk.e.l lVar) {
            x.i("MicroMsg.FTS.FTS5SearchGameLogic", "appinfo storage change: event=%s | eventData=%s", str, lVar);
            switch (lVar.jcn) {
                case 2:
                case 3:
                    b.this.gKV.a(65606, new b(lVar.obj.toString()));
                    return;
                case 5:
                    b.this.gKV.a(65606, new a(lVar.obj.toString()));
                    return;
                default:
                    return;
            }
        }
    };
    a nbs;

    class b extends com.tencent.mm.plugin.fts.a.a.a {
        private String appId;
        private String name;

        public b(String str) {
            this.appId = str;
        }

        public final boolean execute() {
            f Sk = com.tencent.mm.plugin.y.a.a.a.biY().biW().Sk(this.appId);
            if (Sk != null && Sk.YI()) {
                b.this.nbs.beginTransaction();
                b.this.nbs.a(com.tencent.mm.plugin.fts.a.c.mPO, this.appId);
                b.this.nbs.a(327680, 1, 0, Sk.field_appId, System.currentTimeMillis(), Sk.field_appName);
                b.this.nbs.commit();
                this.name = Sk.field_appName;
            }
            return true;
        }

        public final String adF() {
            return String.format("{name: %s appId: %s}", new Object[]{this.name, this.appId});
        }

        public final String getName() {
            return "InsertGameTask";
        }
    }

    class d extends com.tencent.mm.plugin.fts.a.a.a {
        private int iZh;

        d() {
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean execute() {
            /*
            r11 = this;
            r2 = 1;
            r9 = new java.util.LinkedList;
            r9.<init>();
            r0 = com.tencent.mm.plugin.y.a.a.a.biY();
            r0 = r0.biW();
            r1 = r0.bZw();
            if (r1 != 0) goto L_0x001e;
        L_0x0014:
            r0 = "MicroMsg.FTS.FTS5SearchGameLogic";
            r1 = "Game cursor is null!";
            com.tencent.mm.sdk.platformtools.x.i(r0, r1);
        L_0x001d:
            return r2;
        L_0x001e:
            r0 = r1.moveToFirst();	 Catch:{ Throwable -> 0x006f }
            if (r0 == 0) goto L_0x0035;
        L_0x0024:
            r0 = new com.tencent.mm.pluginsdk.model.app.f;	 Catch:{ Throwable -> 0x006f }
            r0.<init>();	 Catch:{ Throwable -> 0x006f }
            r0.b(r1);	 Catch:{ Throwable -> 0x006f }
            r9.add(r0);	 Catch:{ Throwable -> 0x006f }
            r0 = r1.moveToNext();	 Catch:{ Throwable -> 0x006f }
            if (r0 != 0) goto L_0x0024;
        L_0x0035:
            if (r1 == 0) goto L_0x003a;
        L_0x0037:
            r1.close();
        L_0x003a:
            r0 = com.tencent.mm.plugin.game.b.b.this;
            r0 = r0.nbs;
            r0.beginTransaction();
            r0 = com.tencent.mm.plugin.game.b.b.this;
            r0 = r0.nbs;
            r1 = com.tencent.mm.plugin.fts.a.c.mPO;
            r0.h(r1);
            r10 = r9.iterator();
        L_0x004e:
            r0 = r10.hasNext();
            if (r0 == 0) goto L_0x0078;
        L_0x0054:
            r0 = r10.next();
            r8 = r0;
            r8 = (com.tencent.mm.pluginsdk.model.app.f) r8;
            r6 = java.lang.System.currentTimeMillis();
            r0 = com.tencent.mm.plugin.game.b.b.this;
            r0 = r0.nbs;
            r1 = 327680; // 0x50000 float:4.59177E-40 double:1.618954E-318;
            r3 = 0;
            r5 = r8.field_appId;
            r8 = r8.field_appName;
            r0.a(r1, r2, r3, r5, r6, r8);
            goto L_0x004e;
        L_0x006f:
            r0 = move-exception;
            throw r0;	 Catch:{ all -> 0x0071 }
        L_0x0071:
            r0 = move-exception;
            if (r1 == 0) goto L_0x0077;
        L_0x0074:
            r1.close();
        L_0x0077:
            throw r0;
        L_0x0078:
            r0 = com.tencent.mm.plugin.game.b.b.this;
            r0 = r0.nbs;
            r0.commit();
            r0 = r9.size();
            r11.iZh = r0;
            goto L_0x001d;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.game.b.b.d.execute():boolean");
        }

        public final String adF() {
            return String.format("{updateSize: %d}", new Object[]{Integer.valueOf(this.iZh)});
        }

        public final String getName() {
            return "UpdateGameIndexTask";
        }

        public final int getId() {
            return 7;
        }
    }

    class a extends com.tencent.mm.plugin.fts.a.a.a {
        private String appId;

        public a(String str) {
            this.appId = str;
        }

        public final boolean execute() {
            b.this.nbs.a(com.tencent.mm.plugin.fts.a.c.mPO, this.appId);
            return true;
        }

        public final String adF() {
            return String.format("{appId: %s}", new Object[]{this.appId});
        }

        public final String getName() {
            return "DeleteGameTask";
        }
    }

    class c extends com.tencent.mm.plugin.fts.a.a.f {
        c(g gVar) {
            super(gVar);
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        protected final void a(com.tencent.mm.plugin.fts.a.a.h r7) {
            /*
            r6 = this;
            r4 = 1;
            r0 = r6.mRy;
            r0 = r0.fEe;
            r0 = com.tencent.mm.plugin.fts.a.a.e.an(r0, r4);
            r7.mRM = r0;
            r0 = new java.util.ArrayList;
            r0.<init>();
            r7.mRN = r0;
            r0 = com.tencent.mm.plugin.game.b.b.this;
            r0 = r0.nbs;
            r1 = r7.mRM;
            r2 = com.tencent.mm.plugin.fts.a.c.mPO;
            r3 = r6.mRy;
            r3 = r3.mRG;
            r5 = r4;
            r1 = r0.a(r1, r2, r3, r4, r5);
        L_0x0023:
            r0 = r1.moveToNext();	 Catch:{ Throwable -> 0x003a }
            if (r0 == 0) goto L_0x0043;
        L_0x0029:
            r0 = new com.tencent.mm.plugin.fts.a.a.k;	 Catch:{ Throwable -> 0x003a }
            r0.<init>();	 Catch:{ Throwable -> 0x003a }
            r0.h(r1);	 Catch:{ Throwable -> 0x003a }
            r0.aNF();	 Catch:{ Throwable -> 0x003a }
            r2 = r7.mRN;	 Catch:{ Throwable -> 0x003a }
            r2.add(r0);	 Catch:{ Throwable -> 0x003a }
            goto L_0x0023;
        L_0x003a:
            r0 = move-exception;
            throw r0;	 Catch:{ all -> 0x003c }
        L_0x003c:
            r0 = move-exception;
            if (r1 == 0) goto L_0x0042;
        L_0x003f:
            r1.close();
        L_0x0042:
            throw r0;
        L_0x0043:
            if (r1 == 0) goto L_0x0048;
        L_0x0045:
            r1.close();
        L_0x0048:
            r0 = java.lang.Thread.interrupted();
            if (r0 == 0) goto L_0x0054;
        L_0x004e:
            r0 = new java.lang.InterruptedException;
            r0.<init>();
            throw r0;
        L_0x0054:
            r0 = r6.mRy;
            r0 = r0.mRJ;
            if (r0 == 0) goto L_0x0063;
        L_0x005a:
            r0 = r7.mRN;
            r1 = r6.mRy;
            r1 = r1.mRJ;
            java.util.Collections.sort(r0, r1);
        L_0x0063:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.game.b.b.c.a(com.tencent.mm.plugin.fts.a.a.h):void");
        }

        public final String getName() {
            return "SearchGameTask";
        }

        public final int getId() {
            return 10;
        }
    }

    public final com.tencent.mm.plugin.fts.a.a.a a(g gVar) {
        return this.gKV.a(-65536, new c(gVar));
    }

    protected final boolean onCreate() {
        if (((m) com.tencent.mm.kernel.g.k(m.class)).isFTSContextReady()) {
            x.i("MicroMsg.FTS.FTS5SearchGameLogic", "Create Success!");
            this.nbs = (a) ((m) com.tencent.mm.kernel.g.k(m.class)).getFTSIndexStorage(16);
            this.gKV = ((m) com.tencent.mm.kernel.g.k(m.class)).getFTSTaskDaemon();
            this.gKV.a(65606, new d());
            com.tencent.mm.plugin.y.a.a.a.biY().biW().c(this.iZf);
            return true;
        }
        x.i("MicroMsg.FTS.FTS5SearchGameLogic", "Create Fail!");
        return false;
    }

    protected final boolean Bg() {
        com.tencent.mm.plugin.y.a.a.a.biY().biW().j(this.iZf);
        this.nbs = null;
        this.gKV = null;
        return true;
    }

    public final String getName() {
        return "FTS5SearchGameLogic";
    }
}
