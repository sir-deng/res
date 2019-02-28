package com.tencent.mm.plugin.appbrand.dynamic.b;

import android.database.Cursor;
import android.os.SystemClock;
import com.tencent.mars.smc.IDKey;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.a.c;
import com.tencent.mm.plugin.appbrand.appcache.ap;
import com.tencent.mm.plugin.appbrand.appcache.ar;
import com.tencent.mm.plugin.appbrand.appcache.r.b;
import com.tencent.mm.pluginsdk.i.a.d.l;
import java.util.ArrayList;
import java.util.Locale;

public final class d implements b {

    /* renamed from: com.tencent.mm.plugin.appbrand.dynamic.b.d$1 */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] iVW = new int[a.adj().length];

        static {
            try {
                iVW[a.iVZ - 1] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iVW[a.iWa - 1] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    private static final class a implements com.tencent.mm.plugin.appbrand.appcache.r.a {
        private ArrayList<IDKey> iGG;
        private long iGH;
        private long iGI;
        private final ar iVX;
        private int iVY;

        private enum a {
            ;

            public static int[] adj() {
                return (int[]) iWb.clone();
            }

            static {
                iVZ = 1;
                iWa = 2;
                iWb = new int[]{iVZ, iWa};
            }
        }

        /* synthetic */ a(ar arVar, byte b) {
            this(arVar);
        }

        private a(ar arVar) {
            this.iGH = 0;
            this.iGI = 0;
            this.iVX = arVar;
        }

        private void jX(int i) {
            if (this.iGG == null) {
                this.iGG = new ArrayList();
            }
            this.iGG.add(new IDKey(640, i, 1));
        }

        private void ZU() {
            try {
                com.tencent.mm.plugin.report.d.pVE.a(this.iGG, false);
                this.iGG.clear();
            } catch (Exception e) {
            }
        }

        public final void ZK() {
            int i = 0;
            if (com.tencent.mm.plugin.appbrand.appcache.d.a.jy(this.iVX.fwH)) {
                int i2;
                if (((c) g.h(c.class)).Zf() == null) {
                    i2 = 1;
                } else {
                    ap Zf = ((c) g.h(c.class)).Zf();
                    String str = this.iVX.appId;
                    int i3 = this.iVX.fwH;
                    Cursor a = Zf.iIR.a(String.format(Locale.US, "select count(%s) from %s where %s=? and %s=?", new Object[]{"version", "AppBrandWxaPkgManifestRecord", "appId", "debugType"}), new String[]{str, String.valueOf(i3)}, 2);
                    if (a == null) {
                        i2 = 0;
                    } else {
                        if (a.moveToFirst()) {
                            i2 = a.getInt(0);
                        } else {
                            i2 = 0;
                        }
                        a.close();
                    }
                }
                this.iVY = i2 > 1 ? a.iWa : a.iVZ;
            } else {
                this.iVY = a.iVZ;
            }
            switch (AnonymousClass1.iVW[this.iVY - 1]) {
                case 1:
                    i = 1;
                    break;
                case 2:
                    i = 10;
                    break;
            }
            jX(i);
            this.iGH = SystemClock.elapsedRealtime();
        }

        public final void ZL() {
            jX(32);
        }

        public final void ZM() {
            jX(31);
        }

        public final void a(l lVar) {
            int i;
            boolean z = true;
            int i2 = 2;
            long elapsedRealtime = SystemClock.elapsedRealtime() - this.iGH;
            if (elapsedRealtime <= 1000) {
                i = 0;
            } else if (elapsedRealtime <= 2000) {
                i = 1;
            } else if (elapsedRealtime <= 3000) {
                i = 2;
            } else if (elapsedRealtime <= 4000) {
                i = 3;
            } else if (elapsedRealtime <= 5000) {
                i = 4;
            } else {
                i = 5;
            }
            com.tencent.mm.plugin.report.d.pVE.a(665, (long) i, 1, false);
            if (lVar == null || lVar.status != 2) {
                z = false;
            }
            switch (AnonymousClass1.iVW[this.iVY - 1]) {
                case 1:
                    if (!z) {
                        i2 = 3;
                    }
                    jX(i2);
                    break;
                case 2:
                    jX(z ? 11 : 12);
                    break;
            }
            ZU();
        }

        public final void ZN() {
        }

        public final void jz(int i) {
        }

        public final void ZO() {
        }

        public final void ZP() {
            this.iGI = SystemClock.elapsedRealtime();
            switch (AnonymousClass1.iVW[this.iVY - 1]) {
                case 1:
                    jX(5);
                    return;
                case 2:
                    jX(14);
                    return;
                default:
                    return;
            }
        }

        public final void cq(boolean z) {
            int i;
            SystemClock.elapsedRealtime();
            switch (AnonymousClass1.iVW[this.iVY - 1]) {
                case 1:
                    if (!z) {
                        i = 7;
                        break;
                    } else {
                        i = 6;
                        break;
                    }
                case 2:
                    if (!z) {
                        i = 16;
                        break;
                    } else {
                        i = 15;
                        break;
                    }
                default:
                    i = 0;
                    break;
            }
            jX(i);
            ZU();
        }
    }

    public final com.tencent.mm.plugin.appbrand.appcache.r.a a(com.tencent.mm.plugin.appbrand.appcache.a.a aVar) {
        if (ar.class == aVar.getClass()) {
            return new a((ar) aVar, (byte) 0);
        }
        return null;
    }
}
