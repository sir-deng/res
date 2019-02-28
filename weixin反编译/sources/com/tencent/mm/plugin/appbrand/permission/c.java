package com.tencent.mm.plugin.appbrand.permission;

import android.text.TextUtils;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.plugin.appbrand.e;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bd;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Locale;

public class c {
    private static final int iWY = (-bi.getInt(r.ifI, 0));
    private static final android.support.v4.e.a<String, c> jMi = new android.support.v4.e.a();
    private static final c jMj = new c() {
        public final a a(com.tencent.mm.plugin.appbrand.jsapi.c cVar, com.tencent.mm.plugin.appbrand.jsapi.b bVar, b bVar2) {
            return a.jMs;
        }

        public final void a(AppRuntimeApiPermissionBundle appRuntimeApiPermissionBundle) {
        }
    };
    private final e iuk;
    private final LinkedList<b> jMk;
    private final Object jMl;
    private AppRuntimeApiPermissionBundle jMm;

    public static final class a {
        private static final a jMp = new a(2, "fail:auth canceled");
        private static final a jMq = new a(2, "fail:auth denied");
        private static final a jMr = new a(3, "");
        private static final a jMs = new a(2, "fail:access denied");
        private static final a jMt = new a(1, "");
        public final int code;
        public final String fpV;

        a(int i, String str) {
            this.code = i;
            this.fpV = str;
        }
    }

    public interface b {
        void a(a aVar);
    }

    /* synthetic */ c(e eVar, byte b) {
        this(null);
    }

    static /* synthetic */ void a(c cVar) {
        synchronized (cVar.jMk) {
            cVar.jMk.clear();
        }
    }

    static /* synthetic */ void b(c cVar) {
        LinkedList linkedList = new LinkedList();
        synchronized (cVar.jMk) {
            linkedList.addAll(cVar.jMk);
            cVar.jMk.clear();
        }
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            ((b) it.next()).a(a.jMt);
        }
    }

    public static c r(e eVar) {
        return a(eVar, true);
    }

    public static c a(e eVar, boolean z) {
        if (eVar == null || TextUtils.isEmpty(eVar.mAppId)) {
            x.e("MicroMsg.AppRuntimeApiPermissionController", "obtain dummy controller, stack %s", bi.i(new Throwable()));
            return jMj;
        }
        c cVar;
        synchronized (jMi) {
            cVar = (c) jMi.get(eVar.mAppId);
            if (cVar == null && z) {
                cVar = new c(eVar);
                jMi.put(eVar.mAppId, cVar);
            }
        }
        return cVar;
    }

    public static int a(com.tencent.mm.plugin.appbrand.jsapi.c cVar, com.tencent.mm.plugin.appbrand.jsapi.b bVar) {
        String appId = cVar.getAppId();
        int i = iWY;
        int afG = bVar.afG();
        if (i == -1) {
            x.d("MicroMsg.AppRuntimeApiPermissionController", "getCtrlByte, appId = %s, ctrlIndex = %d, hard code perm on", appId, Integer.valueOf(afG));
            return 1;
        } else if (i == -2) {
            x.d("MicroMsg.AppRuntimeApiPermissionController", "getCtrlByte, appId = %s, ctrlIndex = %d, hard code perm off", appId, Integer.valueOf(afG));
            return 0;
        } else if (cVar.YZ() == null) {
            x.e("MicroMsg.AppRuntimeApiPermissionController", "getCtrlByte, appId = %s, apiName = %s, null runtime from component", appId, bVar.getName());
            return 0;
        } else {
            byte[] bArr;
            boolean z;
            AppRuntimeApiPermissionBundle akf = a(cVar.YZ(), true).akf();
            if (cVar instanceof j) {
                switch (cVar.YZ().itj.iKb.aaI()) {
                    case SUSPEND:
                    case DESTROYED:
                    case BACKGROUND:
                        bArr = akf.jMg;
                        break;
                    default:
                        bArr = akf.jMf;
                        break;
                }
            }
            bArr = akf.jMf;
            if (afG == -2) {
                i = 1;
            } else if (afG == -1) {
                i = (d.vHq || (d.vHl & 255) <= 47) ? true : 0;
                i = i != 0 ? 1 : 0;
            } else {
                i = (afG >= bArr.length || afG < 0) ? 0 : bArr[afG];
            }
            if (com.tencent.mm.compatible.loader.a.a(m.jfz, bVar.getClass()) || com.tencent.mm.compatible.loader.a.a(m.jfA, bVar.getClass())) {
                z = false;
            } else {
                z = true;
            }
            if (z) {
                x.i("MicroMsg.AppRuntimeApiPermissionController", "getCtrlByte, appId = %s, apiName = %s, ctrlIndex = %d, ctrlIndexLength %d, checkRet %d", appId, bVar.getName(), Integer.valueOf(afG), Integer.valueOf(bArr.length), Integer.valueOf(i));
            }
            return i;
        }
    }

    public static boolean b(com.tencent.mm.plugin.appbrand.jsapi.c cVar, com.tencent.mm.plugin.appbrand.jsapi.b bVar) {
        return a(cVar, bVar) == 1;
    }

    private c(e eVar) {
        this.jMk = new LinkedList();
        this.iuk = eVar;
        this.jMl = new byte[0];
        if (eVar != null) {
            synchronized (this.jMl) {
                this.jMm = eVar.isS.iRy;
            }
            final String str = eVar.mAppId;
            com.tencent.mm.plugin.appbrand.c.a(str, new com.tencent.mm.plugin.appbrand.c.b() {
                public final void onDestroy() {
                    synchronized (c.jMi) {
                        c.jMi.remove(str);
                    }
                    c.a(c.this);
                }
            });
            eVar.itj.a(new com.tencent.mm.plugin.appbrand.b.b.a() {
                public final void a(com.tencent.mm.plugin.appbrand.b.a aVar) {
                    if (com.tencent.mm.plugin.appbrand.b.a.FOREGROUND == aVar) {
                        c.b(c.this);
                    }
                }
            });
        }
    }

    private AppRuntimeApiPermissionBundle akf() {
        AppRuntimeApiPermissionBundle appRuntimeApiPermissionBundle;
        synchronized (this.jMl) {
            appRuntimeApiPermissionBundle = this.jMm;
        }
        return appRuntimeApiPermissionBundle;
    }

    public void a(AppRuntimeApiPermissionBundle appRuntimeApiPermissionBundle) {
        if (appRuntimeApiPermissionBundle != null) {
            synchronized (this.jMl) {
                this.jMm = appRuntimeApiPermissionBundle;
            }
        }
    }

    public a a(com.tencent.mm.plugin.appbrand.jsapi.c cVar, com.tencent.mm.plugin.appbrand.jsapi.b bVar, final b bVar2) {
        if (bVar == null || cVar == null) {
            return a.jMs;
        }
        com.tencent.mm.plugin.appbrand.b.a aaI = cVar.YZ().itj.iKb.aaI();
        int a = a(cVar, bVar);
        String appId = cVar.getAppId();
        if (a == 6) {
            a.a(cVar.YZ(), bVar);
            return a.jMs;
        } else if (a == 1) {
            if (!(cVar instanceof j) || aaI != com.tencent.mm.plugin.appbrand.b.a.SUSPEND || !com.tencent.mm.compatible.loader.a.a(m.jfB, bVar.getClass())) {
                return a.jMt;
            }
            return new a(2, String.format(Locale.US, "fail: jsapi has no permission, event=%s, runningState=%s, permissionMsg=%s, detail=%s", new Object[]{bVar.getName(), aaI.name().toLowerCase(), "permission ok", "network api interrupted in suspend state"}));
        } else if (a == 4) {
            if (b.bE(appId, bVar.getName())) {
                return a.jMt;
            }
            b.a(appId, bVar.getName(), new com.tencent.mm.plugin.appbrand.permission.b.b() {
                public final void akc() {
                    if (bVar2 != null) {
                        bVar2.a(a.jMt);
                    }
                }

                public final void akd() {
                    if (bVar2 != null) {
                        bVar2.a(a.jMq);
                    }
                }

                public final void onCancel() {
                    if (bVar2 != null) {
                        bVar2.a(a.jMp);
                    }
                }
            });
            return a.jMr;
        } else if (a == 7) {
            boolean z;
            com.tencent.mm.sdk.d.d dVar = this.iuk.itj.iKb;
            switch (dVar.aaI()) {
                case FOREGROUND:
                    z = true;
                    break;
                case SUSPEND:
                case DESTROYED:
                    z = false;
                    break;
                case BACKGROUND:
                    z = ((Boolean) new bd<Boolean>() {
                        /* JADX WARNING: inconsistent code. */
                        /* Code decompiled incorrectly, please refer to instructions dump. */
                        protected final /* synthetic */ java.lang.Object run() {
                            /*
                            r4 = this;
                            r0 = 1;
                            r1 = 0;
                            r2 = com.tencent.mm.plugin.appbrand.b.c.this;
                            r2 = r2.chu();
                            r3 = com.tencent.mm.plugin.appbrand.b.c.this;
                            r3 = r3.iKh;
                            if (r2 != r3) goto L_0x0022;
                        L_0x000e:
                            r2 = com.tencent.mm.plugin.appbrand.b.c.this;
                            r2 = r2.iKh;
                            r2 = r2.iKy;
                            r2 = r2 & 1;
                            if (r2 <= 0) goto L_0x0020;
                        L_0x0018:
                            r2 = r0;
                        L_0x0019:
                            if (r2 == 0) goto L_0x0022;
                        L_0x001b:
                            r0 = java.lang.Boolean.valueOf(r0);
                            return r0;
                        L_0x0020:
                            r2 = r1;
                            goto L_0x0019;
                        L_0x0022:
                            r0 = r1;
                            goto L_0x001b;
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.b.c.5.run():java.lang.Object");
                        }
                    }.b(new ag(dVar.xrk.getLooper()))).booleanValue();
                    break;
                default:
                    z = false;
                    break;
            }
            if (z) {
                return a.jMt;
            }
            return new a(2, String.format(Locale.US, "fail: jsapi has no permission, event=%s, runningState=%s, permissionMsg=%s, detail=%s", new Object[]{bVar.getName(), aaI.name().toLowerCase(), "permission ok", "jsapi permission required playing audio but current not playing audio in background state"}));
        } else if (a != 8) {
            return a.jMs;
        } else {
            if (bVar2 != null) {
                synchronized (this.jMk) {
                    this.jMk.addLast(bVar2);
                }
            }
            return a.jMr;
        }
    }
}
