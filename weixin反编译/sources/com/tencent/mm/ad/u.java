package com.tencent.mm.ad;

import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class u {
    public static b hpw = null;

    public interface a {
        int a(int i, int i2, String str, b bVar, k kVar);
    }

    public interface b {
        n CO();
    }

    static /* synthetic */ int a(boolean z, a aVar, int i, int i2, String str, b bVar, k kVar) {
        if (aVar != null) {
            final a aVar2;
            final int i3;
            final int i4;
            final String str2;
            final b bVar2;
            final k kVar2;
            if (z) {
                aVar2 = aVar;
                i3 = i;
                i4 = i2;
                str2 = str;
                bVar2 = bVar;
                kVar2 = kVar;
                hpw.CO().hoG.F(new Runnable() {
                    public final void run() {
                        aVar2.a(i3, i4, str2, bVar2, kVar2);
                    }

                    public final String toString() {
                        return super.toString() + "|tryCallback";
                    }
                });
            } else {
                aVar2 = aVar;
                i3 = i;
                i4 = i2;
                str2 = str;
                bVar2 = bVar;
                kVar2 = kVar;
                ah.y(new Runnable() {
                    public final void run() {
                        aVar2.a(i3, i4, str2, bVar2, kVar2);
                    }
                });
            }
        }
        return 0;
    }

    public static boolean La() {
        if (hpw == null) {
            x.e("MicroMsg.RunCgi", "ERROR: MMCore Not init interface IGetNetSceneQueue.");
            return false;
        } else if (hpw.CO() != null) {
            return true;
        } else {
            x.e("MicroMsg.RunCgi", "ERROR: Get NetscneQueue is null.");
            return false;
        }
    }

    public static b a(b bVar) {
        a(bVar, null, false);
        return bVar;
    }

    public static b a(b bVar, a aVar) {
        a(bVar, aVar, false);
        return bVar;
    }

    public static k a(final b bVar, final a aVar, final boolean z) {
        if (hpw == null) {
            x.e("MicroMsg.RunCgi", "ERROR: MMCore Not init interface IGetNetSceneQueue.");
            return null;
        } else if (hpw.CO() == null) {
            x.e("MicroMsg.RunCgi", "ERROR: Get NetscneQueue is null.");
            return null;
        } else if (bVar == null) {
            x.e("MicroMsg.RunCgi", "ERROR: Param CommReqResp is null");
            return null;
        } else {
            k anonymousClass1 = new k() {
                private k hnO = new k() {
                    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
                        if (AnonymousClass1.this.hpz != 2) {
                            AnonymousClass1.this.hpA.TN();
                            AnonymousClass1.this.hpz = 1;
                            u.a(z, aVar, i2, i3, str, bVar, AnonymousClass1.this.hpy);
                        } else {
                            x.w("MicroMsg.RunCgi", "Has been callback by protect:%d func:%d time:%d [%d,%d,%s]", Integer.valueOf(AnonymousClass1.this.hpy.hashCode()), Integer.valueOf(AnonymousClass1.this.getType()), Long.valueOf(bi.Wy() - AnonymousClass1.this.startTime), Integer.valueOf(i2), Integer.valueOf(i3), str);
                        }
                        AnonymousClass1.this.hpx.a(i2, i3, str, AnonymousClass1.this.hpy);
                        x.i("MicroMsg.RunCgi", "onGYNetEnd:%d func:%d time:%d [%d,%d,%s]", Integer.valueOf(AnonymousClass1.this.hpy.hashCode()), Integer.valueOf(AnonymousClass1.this.getType()), Long.valueOf(bi.Wy() - AnonymousClass1.this.startTime), Integer.valueOf(i2), Integer.valueOf(i3), str);
                    }
                };
                al hpA = new al(u.hpw.CO().hoG.oFY.getLooper(), new com.tencent.mm.sdk.platformtools.al.a() {
                    public final boolean uG() {
                        x.w("MicroMsg.RunCgi", "Warning: Never should go here. usr canceled:%b Or NetsceneQueue Not call onGYNetEnd! %d func:%d time:%d", Boolean.valueOf(AnonymousClass1.this.hpy.aBT), Integer.valueOf(AnonymousClass1.this.hpy.hashCode()), Integer.valueOf(AnonymousClass1.this.getType()), Long.valueOf(bi.Wy() - AnonymousClass1.this.startTime));
                        if (!(AnonymousClass1.this.hpy.aBT || AnonymousClass1.this.hpz == 1)) {
                            AnonymousClass1.this.hpz = 2;
                            u.a(z, aVar, 3, -1, "", bVar, AnonymousClass1.this.hpy);
                        }
                        return false;
                    }

                    public final String toString() {
                        return super.toString() + "|protectNotCallback";
                    }
                }, false);
                e hpx = null;
                final k hpy = this;
                int hpz = 0;
                final long startTime = bi.Wy();

                public final int getType() {
                    return bVar.hnS;
                }

                public final int a(e eVar, e eVar2) {
                    this.hpx = eVar2;
                    int a = a(eVar, bVar, this.hnO);
                    x.i("MicroMsg.RunCgi", "Start doScene:%d func:%d netid:%d time:%d", Integer.valueOf(this.hpy.hashCode()), Integer.valueOf(bVar.hnS), Integer.valueOf(a), Long.valueOf(bi.Wy() - this.startTime));
                    if (aVar != null) {
                        if (a < 0) {
                            u.a(z, aVar, 3, -1, "", bVar, this.hpy);
                        } else {
                            this.hpA.K(60000, 60000);
                        }
                    }
                    return a;
                }
            };
            if (hpw.CO().a(anonymousClass1, 0)) {
                return anonymousClass1;
            }
            return null;
        }
    }
}
