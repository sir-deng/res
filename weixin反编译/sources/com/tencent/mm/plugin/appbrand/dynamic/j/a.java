package com.tencent.mm.plugin.appbrand.dynamic.j;

import android.os.Bundle;
import android.os.Parcelable;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.ipcinvoker.h;
import com.tencent.mm.ipcinvoker.i;
import com.tencent.mm.ipcinvoker.j;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.ak;
import com.tencent.mm.plugin.appbrand.appcache.al;
import com.tencent.mm.plugin.appbrand.appcache.aq;
import com.tencent.mm.plugin.appbrand.config.AppBrandGlobalSystemConfig;
import com.tencent.mm.plugin.appbrand.dynamic.debugger.DebuggerInfo;
import com.tencent.mm.plugin.appbrand.dynamic.launching.WidgetRuntimeConfig;
import com.tencent.mm.plugin.appbrand.dynamic.launching.WidgetSysConfig;
import com.tencent.mm.plugin.appbrand.widget.l;
import com.tencent.mm.protocal.c.aix;
import com.tencent.mm.protocal.c.aiy;
import com.tencent.mm.protocal.c.cbu;
import com.tencent.mm.protocal.c.cbv;
import com.tencent.mm.protocal.c.cbw;
import com.tencent.mm.protocal.c.cdu;
import com.tencent.mm.protocal.c.nk;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.rtmp.TXLiveConstants;
import java.io.IOException;
import java.util.LinkedList;

public final class a {

    /* renamed from: com.tencent.mm.plugin.appbrand.dynamic.j.a$2 */
    static class AnonymousClass2 implements i<Bundle> {
        final /* synthetic */ e iYd;

        public AnonymousClass2(e eVar) {
            this.iYd = eVar;
        }

        public final /* synthetic */ void as(Object obj) {
            Bundle bundle = (Bundle) obj;
            if (this.iYd != null) {
                this.iYd.Q(bundle.getString("appId"), bundle.getBoolean("result"));
            }
        }
    }

    private static class b implements h<Bundle, Bundle> {
        private b() {
        }

        public final /* synthetic */ void a(Object obj, i iVar) {
            com.tencent.mm.plugin.appbrand.dynamic.b.e.removeAll();
            x.v("MicroMsg.DynamicPkgUpdater", "clearCache");
            com.tencent.mm.plugin.appbrand.dynamic.i.b.adB();
        }
    }

    private static class c implements j<Bundle, Bundle> {
        private c() {
        }

        public final /* synthetic */ Object at(Object obj) {
            return j((Bundle) obj);
        }

        private static Bundle j(Bundle bundle) {
            boolean z = true;
            String string = bundle.getString("appId");
            int i = bundle.getInt("pkgType");
            int i2 = bundle.getInt("pkgVersion");
            int i3 = bundle.getInt("scene");
            int i4 = bundle.getInt("widgetType");
            String string2 = bundle.getString("preloadLaunchData", "");
            Bundle bundle2 = new Bundle();
            try {
                com.tencent.mm.plugin.appbrand.widget.j adr = new com.tencent.mm.plugin.appbrand.dynamic.launching.a(string, i, i2, i3, i4, string2).adr();
                if (adr == null) {
                    return bundle2;
                }
                boolean z2;
                if (adr.field_jsApiInfo != null) {
                    bundle2.putByteArray("jsApiInfo", adr.field_jsApiInfo.toByteArray());
                }
                if (adr.field_launchAction != null) {
                    bundle2.putByteArray("launchAction", adr.field_launchAction.toByteArray());
                }
                if (adr.field_versionInfo != null) {
                    bundle2.putByteArray("versionInfo", adr.field_versionInfo.toByteArray());
                }
                Parcelable widgetRuntimeConfig = new WidgetRuntimeConfig();
                widgetRuntimeConfig.appId = string;
                widgetRuntimeConfig.iXt = i4;
                cdu cdu = adr.field_widgetSetting;
                if (cdu != null) {
                    widgetRuntimeConfig.iXJ = cdu.xjh;
                    widgetRuntimeConfig.iXL = cdu.xjj;
                    widgetRuntimeConfig.iXK = cdu.xji;
                }
                bundle2.putParcelable("runtimeConfig", widgetRuntimeConfig);
                l vy = ((com.tencent.mm.plugin.appbrand.widget.a.a) g.h(com.tencent.mm.plugin.appbrand.widget.a.a.class)).Zv().vy(string);
                DebuggerInfo rN = com.tencent.mm.plugin.appbrand.dynamic.debugger.b.rN(string);
                widgetRuntimeConfig = new DebuggerInfo();
                if (vy == null || !vy.field_openDebug) {
                    z2 = false;
                } else {
                    z2 = true;
                }
                widgetRuntimeConfig.iWg = z2;
                if (com.tencent.mm.plugin.appbrand.appcache.d.a.hi(i) || (rN != null && rN.iWf)) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                widgetRuntimeConfig.iWf = z2;
                if (rN == null || !rN.iWh) {
                    z = false;
                }
                widgetRuntimeConfig.iWh = z;
                bundle2.putParcelable("debuggerInfo", widgetRuntimeConfig);
                AppBrandGlobalSystemConfig aci = AppBrandGlobalSystemConfig.aci();
                Parcelable widgetSysConfig = new WidgetSysConfig();
                widgetSysConfig.iQE = aci.iQE;
                widgetSysConfig.iQF = aci.iQF;
                widgetSysConfig.iQG = aci.iQG;
                bundle2.putParcelable("sysConfig", widgetSysConfig);
                return bundle2;
            } catch (Exception e) {
                x.w("MicroMsg.DynamicPkgUpdater", "check widget launch info error : %s", e);
            }
        }
    }

    private static class d implements h<Bundle, Bundle> {
        private d() {
        }

        public final /* synthetic */ void a(Object obj, final i iVar) {
            Bundle bundle = (Bundle) obj;
            final String string = bundle.getString(SlookAirButtonFrequentContactAdapter.ID);
            String string2 = bundle.getString("appId");
            int i = bundle.getInt("debugType");
            al a = ((com.tencent.mm.plugin.appbrand.a.c) g.h(com.tencent.mm.plugin.appbrand.a.c.class)).Zf().a(string2, i, "downloadURL");
            String str = a != null ? a.field_downloadURL : null;
            if (a == null) {
                x.e("MicroMsg.DynamicPkgUpdater", "WxaPkgManifestRecord(%s, %d) is null.", string2, Integer.valueOf(i));
                Bundle bundle2 = new Bundle();
                bundle2.putString("appId", string2);
                bundle2.putBoolean("result", false);
                iVar.as(bundle2);
            } else if (!bi.oN(str)) {
                aq.a(string2, i, str, new com.tencent.mm.plugin.appbrand.appcache.aq.a() {
                    public final /* synthetic */ void a(String str, com.tencent.mm.plugin.appbrand.appcache.a.b.a.a aVar, Object obj) {
                        Bundle bundle;
                        if (!com.tencent.mm.plugin.appbrand.appcache.a.b.a.a.OK.equals(aVar)) {
                            bundle = new Bundle();
                            bundle.putString(SlookAirButtonFrequentContactAdapter.ID, string);
                            bundle.putInt("widgetState", TXLiveConstants.PLAY_WARNING_HW_ACCELERATION_FAIL);
                            f.a("com.tencent.mm:support", bundle, com.tencent.mm.plugin.appbrand.dynamic.f.a.class, null);
                        }
                        if (iVar != null) {
                            bundle = new Bundle();
                            bundle.putString("appId", str);
                            bundle.putBoolean("result", com.tencent.mm.plugin.appbrand.appcache.a.b.a.a.OK.equals(aVar));
                            iVar.as(bundle);
                        }
                    }
                });
            }
        }
    }

    public interface e {
        void Q(String str, boolean z);
    }

    private static class a implements j<Bundle, WxaPkgWrappingInfo> {
        private a() {
        }

        public final /* synthetic */ Object at(Object obj) {
            return p((Bundle) obj);
        }

        private static WxaPkgWrappingInfo p(Bundle bundle) {
            String string = bundle.getString(SlookAirButtonFrequentContactAdapter.ID);
            String string2 = bundle.getString("appId");
            int i = bundle.getInt("pkgType");
            int i2 = bundle.getInt("pkgVersion");
            bundle.getInt("scene");
            String string3 = bundle.getString("searchId");
            al a;
            String str;
            switch (i) {
                case 10000:
                    return (WxaPkgWrappingInfo) ak.r(string2, i, i2).second;
                case 10001:
                    if (new com.tencent.mm.plugin.appbrand.dynamic.launching.c(string2, "", "", (byte) 0).adu() == com.tencent.mm.plugin.appbrand.dynamic.launching.c.a.iXC - 1) {
                        al a2 = ((com.tencent.mm.plugin.appbrand.a.c) g.h(com.tencent.mm.plugin.appbrand.a.c.class)).Zf().a(string2, i, "downloadURL");
                        if (a2 == null) {
                            x.e("MicroMsg.DynamicPkgUpdater", "WxaPkgManifestRecord(%s, %d) is null.", string2, Integer.valueOf(i));
                            return null;
                        }
                        try {
                            return new com.tencent.mm.plugin.appbrand.dynamic.launching.b(string, string2, string3, i, i2, com.tencent.mm.plugin.appbrand.dynamic.launching.b.iXv, a2.field_downloadURL).ads();
                        } catch (Exception e) {
                            x.e("MicroMsg.DynamicPkgUpdater", "getWxaPkgInfo(%s, %d) error : %s", string2, Integer.valueOf(i), e);
                            return null;
                        }
                    }
                    break;
                case 10100:
                case 10101:
                    a = ((com.tencent.mm.plugin.appbrand.a.c) g.h(com.tencent.mm.plugin.appbrand.a.c.class)).Zf().a(string2, i, "downloadURL");
                    g.Do();
                    int Cn = com.tencent.mm.kernel.a.Cn();
                    com.tencent.mm.ad.b.a aVar = new com.tencent.mm.ad.b.a();
                    com.tencent.mm.bp.a aix = new aix();
                    aix.fGh = string2;
                    aix.wwR = Cn;
                    cbu cbu = new cbu();
                    switch (i) {
                        case 10100:
                            cbu.vVl = 1;
                            cbu.xhL = 1;
                            break;
                        case 10101:
                            cbu.vVl = 2;
                            cbu.xhL = 1;
                            break;
                        default:
                            cbu.vVl = 0;
                            cbu.xhL = 0;
                            break;
                    }
                    if (a != null) {
                        cbu.frM = a.field_versionMd5;
                    } else {
                        cbu.frM = "";
                    }
                    aix.wwS = new LinkedList();
                    aix.wwS.add(cbu);
                    aVar.hnT = aix;
                    aVar.hnU = new aiy();
                    aVar.uri = "/cgi-bin/mmbiz-bin/wxaapp/getwidgetinfo";
                    aVar.hnS = 1186;
                    com.tencent.mm.ad.a.a c = com.tencent.mm.plugin.appbrand.i.d.c(aVar.Kf());
                    if (c.errType == 0 && c.errCode == 0) {
                        aiy aiy = (aiy) c.fKE;
                        if (!(aiy == null || aiy.wwS == null || aiy.wwS.size() <= 0)) {
                            cbu cbu2 = (cbu) aiy.wwS.getFirst();
                            x.i("MicroMsg.DynamicPkgUpdater", "getWidgetInfo debugType %d, md5 %s, url %s", Integer.valueOf(i), cbu2.frM, cbu2.url);
                            if (cbu2.url != null && cbu2.url.length() > 0) {
                                switch (i) {
                                    case 10000:
                                        ((com.tencent.mm.plugin.appbrand.a.c) g.h(com.tencent.mm.plugin.appbrand.a.c.class)).Zf().a(string2, 10000, cbu2.url, cbu2.frM, 0, 0);
                                        break;
                                    case 10001:
                                        ((com.tencent.mm.plugin.appbrand.a.c) g.h(com.tencent.mm.plugin.appbrand.a.c.class)).Zf().a(string2, 10001, cbu2.url, cbu2.frM, 0, 0);
                                        break;
                                    case 10100:
                                        ((com.tencent.mm.plugin.appbrand.a.c) g.h(com.tencent.mm.plugin.appbrand.a.c.class)).Zf().a(string2, 10100, cbu2.url, cbu2.frM, 0, 0);
                                        break;
                                    case 10101:
                                        ((com.tencent.mm.plugin.appbrand.a.c) g.h(com.tencent.mm.plugin.appbrand.a.c.class)).Zf().a(string2, 10101, cbu2.url, cbu2.frM, 0, 0);
                                        break;
                                }
                            }
                        }
                    }
                    x.i("MicroMsg.DynamicPkgUpdater", "cgi fail errType %d, errCode %d,errMsg %s, appid %s , pkgType %d", Integer.valueOf(c.errType), Integer.valueOf(c.errCode), c.foE, string2, Integer.valueOf(i));
                    return (WxaPkgWrappingInfo) ak.r(string2, i, i2).second;
                case 10102:
                    try {
                        str = "";
                        a = ((com.tencent.mm.plugin.appbrand.a.c) g.h(com.tencent.mm.plugin.appbrand.a.c.class)).Zf().a(string2, i, "downloadURL", "version");
                        if (a != null) {
                            str = a.field_downloadURL;
                            i2 = a.field_version;
                        }
                        return new com.tencent.mm.plugin.appbrand.dynamic.launching.b(string, string2, string3, i, i2, com.tencent.mm.plugin.appbrand.dynamic.launching.b.iXw, str).ads();
                    } catch (Exception e2) {
                        x.e("MicroMsg.DynamicPkgUpdater", "CheckWidgetPkg error : %s", e2);
                        break;
                    }
                default:
                    try {
                        str = "";
                        a = ((com.tencent.mm.plugin.appbrand.a.c) g.h(com.tencent.mm.plugin.appbrand.a.c.class)).Zf().a(string2, i, "downloadURL", "version");
                        if (a != null) {
                            str = a.field_downloadURL;
                            i2 = a.field_version;
                        }
                        return new com.tencent.mm.plugin.appbrand.dynamic.launching.b(string, string2, string3, i, i2, com.tencent.mm.plugin.appbrand.dynamic.launching.b.iXv, str).ads();
                    } catch (Exception e22) {
                        x.e("MicroMsg.DynamicPkgUpdater", "CheckWidgetPkg error : %s", e22);
                        break;
                    }
            }
            return null;
        }
    }

    public static WxaPkgWrappingInfo a(String str, String str2, String str3, int i, int i2) {
        Parcelable bundle = new Bundle();
        bundle.putString(SlookAirButtonFrequentContactAdapter.ID, str);
        bundle.putString("appId", str2);
        bundle.putInt("pkgType", i);
        bundle.putInt("pkgVersion", i2);
        bundle.putString("searchId", str3);
        WxaPkgWrappingInfo rM = com.tencent.mm.plugin.appbrand.dynamic.b.e.rM(B(str2, i, i2));
        if (rM == null) {
            rM = (WxaPkgWrappingInfo) f.a("com.tencent.mm", bundle, a.class);
            if (rM != null) {
                com.tencent.mm.plugin.appbrand.dynamic.b.e.a(B(str2, i, i2), rM);
            }
        }
        return rM;
    }

    public static d a(String str, int i, int i2, int i3, int i4, String str2) {
        Parcelable bundle = new Bundle();
        bundle.putString("appId", str);
        bundle.putInt("pkgType", i);
        bundle.putInt("pkgVersion", i2);
        bundle.putInt("widgetType", i3);
        bundle.putInt("scene", i4);
        bundle.putString("preloadLaunchData", str2);
        Bundle bundle2 = (Bundle) f.a("com.tencent.mm", bundle, c.class);
        if (bundle2 == null) {
            return null;
        }
        d dVar = new d();
        dVar.appId = str;
        dVar.iYf = (DebuggerInfo) bundle2.getParcelable("debuggerInfo");
        byte[] byteArray = bundle2.getByteArray("jsApiInfo");
        if (byteArray != null) {
            dVar.iYj = new nk();
            try {
                dVar.iYj.aH(byteArray);
            } catch (IOException e) {
                x.v("MicroMsg.DynamicPkgUpdater", "parseFrom bytes failed : %s", e);
            }
        }
        byteArray = bundle2.getByteArray("launchAction");
        if (byteArray != null) {
            dVar.iYi = new cbv();
            try {
                dVar.iYi.aH(byteArray);
            } catch (IOException e2) {
                x.v("MicroMsg.DynamicPkgUpdater", "parseFrom bytes failed : %s", e2);
            }
        }
        byteArray = bundle2.getByteArray("versionInfo");
        if (byteArray != null) {
            dVar.iYk = new cbw();
            try {
                dVar.iYk.aH(byteArray);
            } catch (IOException e22) {
                x.v("MicroMsg.DynamicPkgUpdater", "parseFrom bytes failed : %s", e22);
            }
        }
        dVar.iYg = (WidgetSysConfig) bundle2.getParcelable("sysConfig");
        dVar.iYh = (WidgetRuntimeConfig) bundle2.getParcelable("runtimeConfig");
        if (dVar.iYh == null) {
            dVar.iYh = new WidgetRuntimeConfig();
        }
        return dVar;
    }

    private static String B(String str, int i, int i2) {
        return str + "#" + i + "#" + i2;
    }
}
