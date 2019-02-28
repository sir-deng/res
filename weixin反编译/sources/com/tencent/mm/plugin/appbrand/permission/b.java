package com.tencent.mm.plugin.appbrand.permission;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.appbrand.e;
import com.tencent.mm.plugin.appbrand.q.j;
import com.tencent.mm.plugin.appbrand.widget.c.h;
import com.tencent.mm.protocal.c.ang;
import com.tencent.mm.protocal.c.anh;
import com.tencent.mm.protocal.c.ani;
import com.tencent.mm.protocal.c.anj;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public final class b {
    private static final LinkedList<Runnable> jLS = new LinkedList();
    private static final a jLT = new a();
    private static boolean jLU = false;
    private final b jLQ;
    private final String jLR;
    private final String mAppId;

    private static final class a {
        final HashMap<String, HashSet<String>> jMc;

        private a() {
            this.jMc = new HashMap();
        }

        /* synthetic */ a(byte b) {
            this();
        }

        final boolean bF(String str, String str2) {
            if (bi.oN(str) || bi.oN(str2)) {
                return false;
            }
            boolean z;
            synchronized (this) {
                HashSet hashSet = (HashSet) this.jMc.get(str);
                if (hashSet == null || !hashSet.contains(str2)) {
                    z = false;
                } else {
                    z = true;
                }
            }
            return z;
        }

        final void put(String str, String str2) {
            if (!bi.oN(str) && !bi.oN(str2)) {
                synchronized (this) {
                    HashSet hashSet = (HashSet) this.jMc.get(str);
                    if (hashSet == null) {
                        hashSet = new HashSet();
                        this.jMc.put(str, hashSet);
                    }
                    hashSet.add(str2);
                }
            }
        }

        final void E(String str, String str2) {
            if (!bi.oN(str) && !bi.oN(str2)) {
                synchronized (this) {
                    HashSet hashSet = (HashSet) this.jMc.get(str);
                    if (hashSet != null) {
                        hashSet.remove(str2);
                    }
                }
            }
        }
    }

    private static final class c implements b {
        private final b jMd;

        /* synthetic */ c(b bVar, byte b) {
            this(bVar);
        }

        private c(b bVar) {
            this.jMd = bVar;
        }

        public final void akc() {
            if (this.jMd != null) {
                this.jMd.akc();
            }
            ake();
        }

        public final void akd() {
            if (this.jMd != null) {
                this.jMd.akd();
            }
            ake();
        }

        public final void onCancel() {
            if (this.jMd != null) {
                this.jMd.onCancel();
            }
            ake();
        }

        private void ake() {
            com.tencent.mm.plugin.appbrand.r.c.Dt().F(new Runnable() {
                public final void run() {
                    Runnable runnable = (Runnable) b.jLS.pollFirst();
                    if (runnable != null) {
                        runnable.run();
                        return;
                    }
                    x.i("MicroMsg.AppBrandJsApiUserAuth", "requireUserAuth, poll null from queue, all requests done");
                    b.jLU = false;
                }
            });
        }
    }

    public interface b {
        void akc();

        void akd();

        void onCancel();
    }

    static /* synthetic */ void a(b bVar, anh anh) {
        x.i("MicroMsg.AppBrandJsApiUserAuth", "requireUserAuth, appId %s, api %s, checkAuth Response.errcode %d", bVar.mAppId, bVar.jLR, Integer.valueOf(anh.wAp.fun));
        if (anh.wAp.fun == 0) {
            jLT.put(bVar.mAppId, bVar.jLR);
            bVar.jLQ.akc();
        } else if (anh.wAp.fun != -12000) {
            bVar.jLQ.akd();
        } else {
            final String str = anh.vVe;
            final String str2 = anh.wAB;
            final e pi = com.tencent.mm.plugin.appbrand.a.pi(bVar.mAppId);
            ah.y(new Runnable() {
                public final void run() {
                    if (pi != null && pi.isX != null) {
                        h bVar = new com.tencent.mm.plugin.appbrand.widget.c.b(pi.isX.getContext());
                        bVar.setMessage(str);
                        bVar.a(j.iCr, new OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                                b.a(b.this, str2, 1);
                                b.jLT.put(b.this.mAppId, b.this.jLR);
                                x.i("MicroMsg.AppBrandJsApiUserAuth", "requestUserAuth, user confirm, appId %s, api %s", b.this.mAppId, b.this.jLR);
                                b.this.jLQ.akc();
                            }
                        });
                        bVar.b(j.iCs, new OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                                b.a(b.this, str2, 2);
                                b.jLT.E(b.this.mAppId, b.this.jLR);
                                x.i("MicroMsg.AppBrandJsApiUserAuth", "requestUserAuth, user deny, appId %s, api %s", b.this.mAppId, b.this.jLR);
                                b.this.jLQ.akd();
                            }
                        });
                        bVar.setOnCancelListener(new OnCancelListener() {
                            public final void onCancel(DialogInterface dialogInterface) {
                                b.jLT.E(b.this.mAppId, b.this.jLR);
                                x.i("MicroMsg.AppBrandJsApiUserAuth", "requestUserAuth, user cancel, appId %s, api %s", b.this.mAppId, b.this.jLR);
                                b.this.jLQ.onCancel();
                            }
                        });
                        pi.a(bVar);
                    }
                }
            });
        }
    }

    static /* synthetic */ void a(b bVar, String str, final int i) {
        com.tencent.mm.ad.b.a aVar = new com.tencent.mm.ad.b.a();
        aVar.hnS = 1027;
        aVar.uri = "/cgi-bin/mmbiz-bin/js-usersetauth";
        com.tencent.mm.bp.a ani = new ani();
        ani.nlV = bVar.mAppId;
        ani.vVc = str;
        ani.wAm = i;
        aVar.hnT = ani;
        aVar.hnU = new anj();
        com.tencent.mm.ipcinvoker.wx_extension.b.a(aVar.Kf(), new com.tencent.mm.ipcinvoker.wx_extension.b.a() {
            public final void a(int i, int i2, String str, com.tencent.mm.ad.b bVar) {
                if (i != 0 || i2 != 0 || bVar.hnR.hnY == null) {
                    x.e("MicroMsg.AppBrandJsApiUserAuth", "setAuth, cgi failed, errType = %d, errCode = %d, errMsg = %s, rr.resp = %s", Integer.valueOf(i), Integer.valueOf(i2), str, bVar.hnR.hnY);
                } else if (((anj) bVar.hnR.hnY).wAp.fun == 0 && 1 == i) {
                    x.i("MicroMsg.AppBrandJsApiUserAuth", "setAuth, add allow cache appId = %s, api = %s", b.this.mAppId, b.this.jLR);
                    b.jLT.put(b.this.mAppId, b.this.jLR);
                }
            }
        });
    }

    static /* synthetic */ void b(String str, String str2, b bVar) {
        if (jLT.bF(str, str2)) {
            x.i("MicroMsg.AppBrandJsApiUserAuth", "requireUserAuth, before cgi, appId %s, api %s, found in AUTH_CACHE, return ok", str, str2);
            bVar.akc();
            return;
        }
        x.i("MicroMsg.AppBrandJsApiUserAuth", "requestUSerAuth, before cgi, appId %s, api %s", str, str2);
        b bVar2 = new b(bVar, str, str2);
        com.tencent.mm.ad.b.a aVar = new com.tencent.mm.ad.b.a();
        aVar.hnS = 1116;
        aVar.uri = "/cgi-bin/mmbiz-bin/js-userauth";
        com.tencent.mm.bp.a ang = new ang();
        ang.nlV = bVar2.mAppId;
        ang.wAA = bVar2.jLR;
        aVar.hnT = ang;
        aVar.hnU = new anh();
        com.tencent.mm.ipcinvoker.wx_extension.b.a(aVar.Kf(), new com.tencent.mm.ipcinvoker.wx_extension.b.a() {
            public final void a(int i, int i2, String str, com.tencent.mm.ad.b bVar) {
                if (i == 0 && i2 == 0 && bVar.hnR.hnY != null) {
                    b.a(b.this, (anh) bVar.hnR.hnY);
                    return;
                }
                x.e("MicroMsg.AppBrandJsApiUserAuth", "checkAuth, cgi failed, errType = %d, errCode = %d, errMsg = %s, rr.resp = %s", Integer.valueOf(i), Integer.valueOf(i2), str, bVar.hnR.hnY);
                b.jLT.E(b.this.mAppId, b.this.jLR);
                b.this.jLQ.akd();
            }
        });
    }

    private b(b bVar, String str, String str2) {
        this.jLQ = bVar;
        this.mAppId = str;
        this.jLR = str2;
    }

    public static boolean bE(String str, String str2) {
        return jLT.bF(str, str2);
    }

    public static void a(final String str, final String str2, final b bVar) {
        if (!bi.oN(str) && !bi.oN(str2)) {
            final Runnable anonymousClass4 = new Runnable() {
                public final void run() {
                    b.b(str, str2, new c(bVar, (byte) 0));
                }
            };
            com.tencent.mm.plugin.appbrand.r.c.Dt().F(new Runnable() {
                public final void run() {
                    if (b.jLU) {
                        b.jLS.add(anonymousClass4);
                        x.i("MicroMsg.AppBrandJsApiUserAuth", "requireUserAuth, another request already running, put this in queue, appId %s, api %s", str, str2);
                        return;
                    }
                    b.jLU = true;
                    anonymousClass4.run();
                }
            });
        }
    }

    public static void uC(String str) {
        a aVar = jLT;
        if (!bi.oN(str)) {
            synchronized (aVar) {
                aVar.jMc.remove(str);
            }
        }
    }
}
