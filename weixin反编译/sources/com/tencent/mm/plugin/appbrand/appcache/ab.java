package com.tencent.mm.plugin.appbrand.appcache;

import android.util.Pair;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.j;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.kernel.g;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.xweb.m;
import java.io.InputStream;
import java.util.Locale;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class ab {
    private static c iHn;
    private static Future<c> iHo;
    private static final ThreadPoolExecutor iHp = new ThreadPoolExecutor(1, 1, 1, TimeUnit.SECONDS, new LinkedBlockingDeque());

    interface c {
        WxaPkgWrappingInfo aac();

        InputStream openRead(String str);
    }

    private static final class a implements c {
        static final a iHr = new a();
        final WxaPkgWrappingInfo iHq;

        public final InputStream openRead(String str) {
            return af.openRead(str);
        }

        public final WxaPkgWrappingInfo aac() {
            return this.iHq;
        }

        a() {
            this.iHq = new WxaPkgWrappingInfo();
            this.iHq.iJd = true;
            this.iHq.iJa = 0;
            this.iHq.iJb = af.VERSION;
            this.iHq.frM = "";
        }

        public final String toString() {
            return "AssetReader";
        }
    }

    private static final class b implements j<IPCVoid, WxaPkgWrappingInfo> {
        private b() {
        }

        public final /* synthetic */ Object at(Object obj) {
            WxaPkgWrappingInfo cr = cr(false);
            WxaPkgWrappingInfo cr2 = cr != null ? cr : cr(true);
            aa.jB(cr2 == null ? af.VERSION : cr2.iJb);
            return cr2;
        }

        private WxaPkgWrappingInfo cr(boolean z) {
            Pair ct = ak.ct(z);
            if (ct.first == com.tencent.mm.plugin.appbrand.appcache.ak.a.iIy && ct.second == null && !z) {
                e.post(new Runnable() {
                    public final void run() {
                        ((com.tencent.mm.plugin.appbrand.a.a) g.h(com.tencent.mm.plugin.appbrand.a.a.class)).cp(false);
                    }
                }, "AppBrand$checkLibUnbrokenOrDownload_releaseLib(false)");
            }
            if (ct.second != null && ((WxaPkgWrappingInfo) ct.second).iJa == 999) {
                ((WxaPkgWrappingInfo) ct.second).iJb = 0;
            }
            return (WxaPkgWrappingInfo) ct.second;
        }
    }

    private static final class d implements c {
        private final WxaPkgWrappingInfo iHq;
        private final ag iHt;

        /* synthetic */ d(WxaPkgWrappingInfo wxaPkgWrappingInfo, byte b) {
            this(wxaPkgWrappingInfo);
        }

        private d(WxaPkgWrappingInfo wxaPkgWrappingInfo) {
            this.iHq = wxaPkgWrappingInfo;
            this.iHt = new ag(wxaPkgWrappingInfo.iGz);
        }

        public final InputStream openRead(String str) {
            this.iHt.aai();
            return this.iHt.qa(str);
        }

        public final WxaPkgWrappingInfo aac() {
            return this.iHq;
        }

        public final String toString() {
            return String.format(Locale.US, "PkgReader[%d]", new Object[]{Integer.valueOf(this.iHq.iJb)});
        }
    }

    public static synchronized void kt() {
        synchronized (ab.class) {
            if (iHn != null) {
                x.i("MicroMsg.WxaCommLibRuntimeReader", "load(), sReader %s loaded", iHn);
            } else {
                boolean cgn = ad.cgn();
                boolean aag = af.aag();
                if (!cgn || aag) {
                    x.i("MicroMsg.WxaCommLibRuntimeReader", "load(), mmexists %b, forceLocal %b, use AssetReader", Boolean.valueOf(cgn), Boolean.valueOf(aag));
                    iHn = a.iHr;
                } else {
                    c cVar;
                    try {
                        if (iHo != null) {
                            x.i("MicroMsg.WxaCommLibRuntimeReader", "loadAwaitingRetriever(), wait for existing retriever");
                        } else {
                            x.i("MicroMsg.WxaCommLibRuntimeReader", "loadAwaitingRetriever(), new retriever");
                            iHo = iHp.submit(new Callable<c>() {
                                public final /* synthetic */ Object call() {
                                    return AnonymousClass1.aab();
                                }

                                private static c aab() {
                                    WxaPkgWrappingInfo wxaPkgWrappingInfo;
                                    try {
                                        wxaPkgWrappingInfo = (WxaPkgWrappingInfo) XIPCInvoker.a("com.tencent.mm", IPCVoid.gOQ, b.class);
                                    } catch (Throwable e) {
                                        x.printErrStackTrace("MicroMsg.WxaCommLibRuntimeReader", e, "load() ipc read lib", new Object[0]);
                                        wxaPkgWrappingInfo = null;
                                    }
                                    x.i("MicroMsg.WxaCommLibRuntimeReader", "load(), ipc query pkgInfo %s", wxaPkgWrappingInfo);
                                    return (wxaPkgWrappingInfo == null || wxaPkgWrappingInfo.iJd) ? a.iHr : new d(wxaPkgWrappingInfo, (byte) 0);
                                }
                            });
                        }
                        iHn = (c) iHo.get(3, TimeUnit.SECONDS);
                    } catch (Exception e) {
                        x.e("MicroMsg.WxaCommLibRuntimeReader", "load(), by retriever e = %s", e);
                    } finally {
                        iHo.cancel(true);
                        iHo = null;
                    }
                    if (iHn == null) {
                        cVar = a.iHr;
                    } else {
                        cVar = iHn;
                    }
                    iHn = cVar;
                }
            }
        }
    }

    public static synchronized boolean ZY() {
        boolean z = true;
        synchronized (ab.class) {
            x.i("MicroMsg.WxaCommLibRuntimeReader", "loaded(), reader %s", iHn);
            if (iHn == null) {
                z = false;
            }
        }
        return z;
    }

    private static synchronized c ZZ() {
        c cVar;
        synchronized (ab.class) {
            if (iHn == null) {
                kt();
            }
            cVar = iHn;
        }
        return cVar;
    }

    static InputStream pV(String str) {
        if (bi.oN(str)) {
            return null;
        }
        InputStream openRead = ZZ().openRead(str);
        String format = String.format(Locale.US, "[%d | %s | %b]", new Object[]{Integer.valueOf(r1.aac().iJa), bi.fK(r1.aac().iJc), Boolean.valueOf(r1.aac().iJd)});
        try {
            int i;
            String str2 = "MicroMsg.WxaCommLibRuntimeReader";
            String str3 = "read %s, %s, ret %d";
            Object[] objArr = new Object[3];
            objArr[0] = str;
            objArr[1] = format;
            if (openRead == null) {
                i = -1;
            } else {
                i = openRead.available();
            }
            objArr[2] = Integer.valueOf(i);
            x.i(str2, str3, objArr);
            return openRead;
        } catch (Exception e) {
            x.e("MicroMsg.WxaCommLibRuntimeReader", "read %s, %s, e %s", str, format, e);
            return openRead;
        }
    }

    public static String pW(String str) {
        InputStream pV = pV(str);
        if (pV == null) {
            return "";
        }
        return com.tencent.mm.plugin.appbrand.q.c.convertStreamToString(pV);
    }

    public static m pX(String str) {
        InputStream pV = pV(str);
        if (pV == null) {
            return null;
        }
        return new m(s.TB(str), "UTF-8", pV);
    }

    public static WxaPkgWrappingInfo aaa() {
        return ZZ().aac();
    }
}
