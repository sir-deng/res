package com.tencent.mm.plugin.appbrand.launching;

import android.util.Pair;
import com.tencent.mm.f.a.ty;
import com.tencent.mm.plugin.appbrand.app.e;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.ak;
import com.tencent.mm.plugin.appbrand.appcache.al;
import com.tencent.mm.plugin.appbrand.appcache.aq;
import com.tencent.mm.plugin.appbrand.appcache.b.b.f;
import com.tencent.mm.plugin.appbrand.appcache.j;
import com.tencent.mm.plugin.appbrand.appcache.p;
import com.tencent.mm.plugin.appbrand.appcache.w;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.d;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.appbrand.q.h;
import com.tencent.mm.pointers.PLong;
import com.tencent.mm.protocal.c.aja;
import com.tencent.mm.protocal.c.ccs;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Locale;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import junit.framework.Assert;

abstract class z extends x<WxaPkgWrappingInfo> implements j {
    final String appId;
    private final int iJb;
    final int iNi;
    final d iSx;
    String iXx = null;
    final int jCV;
    private WxaPkgWrappingInfo jDG;

    private final class a implements Callable<WxaPkgWrappingInfo> {
        private final int jDH;
        private final int jDI;
        private final aja jDJ;

        /* synthetic */ a(z zVar, int i, int i2, aja aja, byte b) {
            this(i, i2, aja);
        }

        public final /* synthetic */ Object call() {
            return (bi.oN(this.jDJ.fzB) || !j.ZR()) ? new b(z.this, this.jDI, (byte) 0).ads() : aiG();
        }

        private a(int i, int i2, aja aja) {
            this.jDH = i;
            this.jDI = i2;
            this.jDJ = aja;
        }

        private WxaPkgWrappingInfo aiG() {
            final CountDownLatch countDownLatch = new CountDownLatch(1);
            final h hVar = new h();
            if (!com.tencent.mm.plugin.appbrand.appcache.h.a(z.this.appId, this.jDH, this.jDI, this.jDJ.fzB, new o(z.this.iNi) {
                final String aiC() {
                    return String.format(Locale.US, "Incremental %d|%d", new Object[]{Integer.valueOf(a.this.jDH), Integer.valueOf(a.this.jDI)});
                }

                final void c(WxaPkgWrappingInfo wxaPkgWrappingInfo) {
                    hVar.jXv = wxaPkgWrappingInfo;
                    countDownLatch.countDown();
                }
            })) {
                return null;
            }
            try {
                countDownLatch.await();
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.AppBrand.PrepareStepCheckAppPkg", e, "downloadIncremental semaphore exp ", new Object[0]);
            }
            return (WxaPkgWrappingInfo) hVar.jXv;
        }
    }

    private final class b implements Callable<WxaPkgWrappingInfo> {
        private final int jDM;

        /* synthetic */ b(z zVar, int i, byte b) {
            this(i);
        }

        public final /* synthetic */ Object call() {
            return ads();
        }

        private b(int i) {
            this.jDM = i;
        }

        public final WxaPkgWrappingInfo ads() {
            final CountDownLatch countDownLatch = new CountDownLatch(1);
            final h hVar = new h();
            com.tencent.mm.plugin.appbrand.appcache.aq.a anonymousClass1 = new o(z.this.iNi) {
                final String aiC() {
                    return String.format(Locale.US, "NonIncremental %d", new Object[]{Integer.valueOf(b.this.jDM)});
                }

                final void c(WxaPkgWrappingInfo wxaPkgWrappingInfo) {
                    hVar.jXv = wxaPkgWrappingInfo;
                    countDownLatch.countDown();
                }
            };
            x.i("MicroMsg.AppBrand.PrepareStepCheckAppPkg", "tryDownload, not incremental before start appId(%s), type(%d), pkgVersion(%d)", z.this.appId, Integer.valueOf(z.this.iNi), Integer.valueOf(this.jDM));
            if (z.this.iNi != 0) {
                z.this.iXx = e.Zz().ah(z.this.appId, z.this.iNi);
                if (bi.oN(z.this.iXx)) {
                    x.e("MicroMsg.AppBrand.PrepareStepCheckAppPkg", "tryDownload, get EMPTY url appId(%s), type(%d)", z.this.appId, Integer.valueOf(z.this.iNi));
                    z.this.a(com.tencent.mm.plugin.appbrand.appcache.ak.a.iIv);
                    return null;
                }
            }
            if (aq.a(z.this.appId, z.this.iNi, this.jDM, z.this.iSx.iST, z.this.iXx, anonymousClass1)) {
                new c<ty>() {
                    {
                        this.xmG = ty.class.getName().hashCode();
                    }

                    public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
                        ty tyVar = (ty) bVar;
                        if (tyVar.fNC.fND.startsWith("WxaPkg_" + z.this.appId)) {
                            if (tyVar.fNC.fNE >= 100) {
                                dead();
                            }
                            z.this.lg(tyVar.fNC.fNE);
                        }
                        return false;
                    }
                }.cfB();
                try {
                    countDownLatch.await();
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.AppBrand.PrepareStepCheckAppPkg", e, "downloadNonIncremental semaphore exp ", new Object[0]);
                }
                return (WxaPkgWrappingInfo) hVar.jXv;
            }
            x.e("MicroMsg.AppBrand.PrepareStepCheckAppPkg", "tryDownload, not incremental FATAL ERROR appId(%s), type(%d), pkgVersion(%d)", z.this.appId, Integer.valueOf(z.this.iNi), Integer.valueOf(this.jDM));
            z.this.a(com.tencent.mm.plugin.appbrand.appcache.ak.a.iIz);
            return null;
        }
    }

    public /* synthetic */ Object call() {
        return ads();
    }

    z(String str, int i, int i2, int i3, d dVar) {
        this.appId = str;
        this.iNi = i;
        this.iJb = i2;
        this.jCV = i3;
        this.iSx = dVar;
    }

    public void aiu() {
    }

    public void aiw() {
    }

    private WxaPkgWrappingInfo ads() {
        Pair r = ak.r(this.appId, this.iNi, this.iJb);
        if (r.second != null) {
            x.i("MicroMsg.AppBrand.PrepareStepCheckAppPkg", "call, using existing pkg with appId(%s) versionType(%d) pkgVersion(%d)", this.appId, Integer.valueOf(this.iNi), Integer.valueOf(this.iJb));
            return (WxaPkgWrappingInfo) r.second;
        }
        Pair r2;
        int i;
        al a;
        long Wy;
        int i2;
        int i3;
        com.tencent.mm.ad.a.a c;
        String mMString;
        Object[] objArr;
        a aVar;
        String str;
        Object[] objArr2;
        WxaPkgWrappingInfo c2;
        if (com.tencent.mm.plugin.appbrand.appcache.d.a.jy(this.iNi)) {
            w o = ((com.tencent.mm.plugin.appbrand.appcache.x) e.u(com.tencent.mm.plugin.appbrand.appcache.x.class)).o(this.appId, 1, this.iJb);
            if (o != null) {
                PLong pLong = new PLong();
                x.i("MicroMsg.AppBrand.PrepareStepCheckAppPkg", "decrypt ret %b, with appId(%s) version(%d)", Boolean.valueOf(f.a(o, com.tencent.mm.plugin.appbrand.appcache.b.b.f.a.iJE, pLong)), this.appId, Integer.valueOf(this.iJb));
                if (f.a(o, com.tencent.mm.plugin.appbrand.appcache.b.b.f.a.iJE, pLong)) {
                    r2 = ak.r(this.appId, this.iNi, this.iJb);
                    if (r2.second != null) {
                        i = com.tencent.mm.plugin.appbrand.appcache.b.c.a.iJQ;
                        com.tencent.mm.plugin.appbrand.appcache.b.c.a.o(pLong.value, 180);
                        return (WxaPkgWrappingInfo) r2.second;
                    }
                    i = com.tencent.mm.plugin.appbrand.appcache.b.c.a.iJQ;
                    com.tencent.mm.plugin.appbrand.appcache.b.c.a.o(pLong.value, 181);
                    if (com.tencent.mm.plugin.appbrand.appcache.ak.a.iIy.equals(r2.first)) {
                        if (this.iNi != 0) {
                            this.jDG = f.aF(this.appId, 1);
                            WxaPkgWrappingInfo c3;
                            try {
                                a = e.Zz().a(this.appId, 0, "version", "versionMd5", "versionState");
                                if (a != null) {
                                    throw new a().f(com.tencent.mm.plugin.appbrand.r.c.getMMString(q.j.iDt, com.tencent.mm.plugin.appbrand.appcache.a.jx(this.iNi)), new Object[0]).g("get NULL record with md5", new Object[0]).aiB();
                                }
                                Wy = bi.Wy();
                                i2 = a.field_version;
                                i3 = this.jDG != null ? 0 : this.jDG.iJb;
                                c = com.tencent.mm.plugin.appbrand.i.d.c(new com.tencent.mm.plugin.appbrand.appcache.b(this.appId, a.field_version, a.field_versionMd5, 0, i3).gLB);
                                if (c == null && c.errType == 0 && c.errCode == 0) {
                                    s.a(com.tencent.mm.plugin.appbrand.launching.s.a.GET_DOWNLOAD_URL, this.appId, i2, this.iNi, this.jCV, bi.Wy() - Wy);
                                    if (bi.oN(((aja) c.fKE).url)) {
                                        throw new a().g("CgiGetDownloadURL return EMPTY url, ret = %d", Integer.valueOf(((aja) c.fKE).ret)).aiB();
                                    }
                                    ccs ccs = new ccs();
                                    String str2 = ((aja) c.fKE).url;
                                    this.iXx = str2;
                                    ccs.xiq = str2;
                                    ccs.vTR = a.field_version;
                                    ccs.xio = a.field_versionState;
                                    ccs.xip = a.field_versionMd5;
                                    e.Zz().a(this.appId, ccs, 0);
                                    if (this.iSx.iST > 0) {
                                        long Wy2 = bi.Wy();
                                        com.tencent.mm.plugin.appbrand.appcache.p.a bD = p.bD((long) this.iSx.iST);
                                        Wy2 = bi.Wy() - Wy2;
                                        x.d("MicroMsg.AppBrand.PrepareStepCheckAppPkg", "trimOff %d, cost %d, result %s", Integer.valueOf(this.iSx.iST), Long.valueOf(Wy2), bD.name());
                                    }
                                    c3 = c(new a(this, i3, i2, (aja) c.fKE, (byte) 0));
                                    if (c3 != null) {
                                        return c3;
                                    }
                                    throw new a().g("Download Fail", new Object[0]).aiB();
                                }
                                if (c == null && c.errCode == -1001) {
                                    mMString = y.getMMString(q.j.iDq, new Object[0]);
                                } else {
                                    i = q.j.iDo;
                                    objArr = new Object[2];
                                    objArr[0] = Integer.valueOf(c != null ? -1 : c.errType);
                                    objArr[1] = Integer.valueOf(c != null ? -1 : c.errCode);
                                    mMString = y.getMMString(i, objArr);
                                }
                                aVar = new a();
                                str = "fail get download url, resp %s";
                                objArr2 = new Object[1];
                                objArr2[0] = c != null ? null : String.format(Locale.US, "(%d, %d)", new Object[]{Integer.valueOf(c.errType), Integer.valueOf(c.errCode)});
                                throw aVar.g(str, objArr2).f(mMString, new Object[0]).aiB();
                            } catch (com.tencent.mm.plugin.appbrand.launching.j.a e) {
                                com.tencent.mm.plugin.appbrand.launching.j.a aVar2 = e;
                                x.e("MicroMsg.AppBrand.PrepareStepCheckAppPkg", "release_pkg APP_BROKEN obtain appId %s, message %s", this.appId, aVar2.getMessage());
                                if (this.iJb <= 0) {
                                    c3 = f.aF(this.appId, 1);
                                    if (c3 != null) {
                                        return c3;
                                    }
                                }
                                if (!bi.oN(aVar2.jDj)) {
                                    y.tF(aVar2.jDj);
                                }
                                return null;
                            }
                        }
                        c2 = c(new b(this, 0, (byte) 0));
                        if (c2 != null) {
                            return c2;
                        }
                    }
                    a((com.tencent.mm.plugin.appbrand.appcache.ak.a) r2.first);
                    return null;
                }
            }
        }
        r2 = r;
        if (com.tencent.mm.plugin.appbrand.appcache.ak.a.iIy.equals(r2.first)) {
            if (this.iNi != 0) {
                c2 = c(new b(this, 0, (byte) 0));
                if (c2 != null) {
                    return c2;
                }
            }
            this.jDG = f.aF(this.appId, 1);
            a = e.Zz().a(this.appId, 0, "version", "versionMd5", "versionState");
            if (a != null) {
                Wy = bi.Wy();
                i2 = a.field_version;
                if (this.jDG != null) {
                }
                c = com.tencent.mm.plugin.appbrand.i.d.c(new com.tencent.mm.plugin.appbrand.appcache.b(this.appId, a.field_version, a.field_versionMd5, 0, i3).gLB);
                if (c == null) {
                }
                if (c == null) {
                }
                i = q.j.iDo;
                objArr = new Object[2];
                if (c != null) {
                }
                objArr[0] = Integer.valueOf(c != null ? -1 : c.errType);
                if (c != null) {
                }
                objArr[1] = Integer.valueOf(c != null ? -1 : c.errCode);
                mMString = y.getMMString(i, objArr);
                aVar = new a();
                str = "fail get download url, resp %s";
                objArr2 = new Object[1];
                if (c != null) {
                }
                objArr2[0] = c != null ? null : String.format(Locale.US, "(%d, %d)", new Object[]{Integer.valueOf(c.errType), Integer.valueOf(c.errCode)});
                throw aVar.g(str, objArr2).f(mMString, new Object[0]).aiB();
            }
            throw new a().f(com.tencent.mm.plugin.appbrand.r.c.getMMString(q.j.iDt, com.tencent.mm.plugin.appbrand.appcache.a.jx(this.iNi)), new Object[0]).g("get NULL record with md5", new Object[0]).aiB();
        }
        a((com.tencent.mm.plugin.appbrand.appcache.ak.a) r2.first);
        return null;
    }

    private WxaPkgWrappingInfo c(Callable<WxaPkgWrappingInfo> callable) {
        if (callable == this) {
            Assert.assertTrue("Why the hell you pass 'this' to this method", false);
            return null;
        }
        WxaPkgWrappingInfo wxaPkgWrappingInfo;
        aiu();
        try {
            wxaPkgWrappingInfo = (WxaPkgWrappingInfo) callable.call();
        } catch (Exception e) {
            wxaPkgWrappingInfo = null;
        }
        aiw();
        return wxaPkgWrappingInfo;
    }

    final void a(com.tencent.mm.plugin.appbrand.appcache.ak.a aVar) {
        if (com.tencent.mm.plugin.appbrand.appcache.ak.a.iIv.equals(aVar)) {
            String mMString;
            if (this.iNi == 1) {
                mMString = com.tencent.mm.plugin.appbrand.r.c.getMMString(q.j.iCx, new Object[0]);
            } else {
                mMString = com.tencent.mm.plugin.appbrand.r.c.getMMString(q.j.iDt, com.tencent.mm.plugin.appbrand.appcache.a.jx(this.iNi));
            }
            if (this.iNi == 1) {
                com.tencent.mm.plugin.appbrand.task.d.aL(this.appId, this.iNi);
                com.tencent.mm.plugin.appbrand.report.a.C(this.appId, 10, this.iNi + 1);
            }
            y.tF(mMString);
        } else if (com.tencent.mm.plugin.appbrand.appcache.ak.a.iIx.equals(aVar) || com.tencent.mm.plugin.appbrand.appcache.ak.a.iIw.equals(aVar)) {
            y.lh(this.iNi != 0 ? q.j.iCx : q.j.iCz);
            if (this.iNi == 1) {
                com.tencent.mm.plugin.appbrand.report.a.C(this.appId, 10, this.iNi + 1);
            }
            com.tencent.mm.plugin.appbrand.task.d.aL(this.appId, this.iNi);
        } else {
            y.tF(com.tencent.mm.plugin.appbrand.r.c.getMMString(q.j.iDr, Integer.valueOf(1), Integer.valueOf(aVar.aav())));
        }
    }

    final String getTag() {
        return "MicroMsg.AppBrand.PrepareStepCheckAppPkg";
    }
}
