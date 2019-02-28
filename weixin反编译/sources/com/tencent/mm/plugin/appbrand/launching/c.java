package com.tencent.mm.plugin.appbrand.launching;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Pair;
import com.tencent.mm.bl.d;
import com.tencent.mm.j.g;
import com.tencent.mm.plugin.appbrand.app.e;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.f;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.plugin.appbrand.launching.ad.AnonymousClass1;
import com.tencent.mm.plugin.appbrand.launching.params.LaunchParcel;
import com.tencent.mm.plugin.appbrand.q.j;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.ui.AppBrand404PageUI;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.wcdb.database.SQLiteDatabase;
import org.json.JSONObject;

public final class c implements Runnable {
    private volatile String appId;
    private final int iJb;
    private final int iNi;
    private final String iRi;
    private final a jCp;
    private AppBrandStatObject jCq;
    private final String username;

    public interface a {
        void c(AppBrandInitConfig appBrandInitConfig, AppBrandStatObject appBrandStatObject);
    }

    public c(LaunchParcel launchParcel, a aVar) {
        this.jCp = aVar;
        this.iNi = launchParcel.iNi;
        this.appId = launchParcel.appId;
        this.username = launchParcel.username;
        this.iJb = launchParcel.version;
        this.jCq = launchParcel.jEr;
        this.iRi = launchParcel.iRi;
    }

    public c(String str, int i, AppBrandStatObject appBrandStatObject, a aVar) {
        this.jCp = aVar;
        this.appId = str;
        this.iNi = i;
        this.username = null;
        this.iJb = 0;
        this.jCq = appBrandStatObject;
        this.iRi = null;
    }

    public final void run() {
        Pair pair;
        WxaAttributes wxaAttributes;
        Throwable e;
        String str;
        v vVar;
        boolean z;
        Intent putExtra;
        Context context;
        int adu;
        com.tencent.mm.plugin.appbrand.launching.ae.a li;
        int i;
        AppBrandInitConfig a;
        JSONObject fA;
        AppBrandStatObject appBrandStatObject;
        Pair aiI;
        try {
            aiI = new ac(this.username, this.appId, this.iNi, this.iJb, this.jCq == null ? 0 : this.jCq.scene, this.iRi).aiI();
            try {
                pair = aiI;
                wxaAttributes = (WxaAttributes) aiI.first;
            } catch (Exception e2) {
                e = e2;
                x.printErrStackTrace("MicroMsg.AppBrandPreLaunchProcess", e, "get attr ", new Object[0]);
                pair = aiI;
                wxaAttributes = null;
                if (wxaAttributes != null) {
                    str = wxaAttributes.field_appId;
                    vVar = new v(str);
                    if (g.Af().getInt("WeAppForbiddenSwitch", 0) != 1) {
                        z = false;
                    } else {
                        x.i("MicroMsg.AppBrand.PreLaunchCheckForOversea", "startApp, WeAppForbiddenSwitch == 1, go webview, appId %s", vVar.appId);
                        putExtra = new Intent().putExtra("rawUrl", l.pI(vVar.appId)).putExtra("forceHideShare", true);
                        context = ad.getContext();
                        if (!(context instanceof Activity)) {
                            putExtra.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                        }
                        d.b(context, "webview", ".ui.tools.WebViewUI", putExtra);
                        z = true;
                    }
                    if (z) {
                        z = true;
                    } else {
                        if (2 == this.iNi) {
                            z = com.tencent.mm.plugin.appbrand.task.d.uT(str);
                            adu = new ae(str, ad.aH(str, 2), ad.aH(str, 10001), z).adu();
                            x.i("MicroMsg.AppBrand.PrepareStepOpBan", "checkDemoInfo, appId %s, ret %d, ignoreCgiError %b", str, Integer.valueOf(adu), Boolean.valueOf(z));
                            li = com.tencent.mm.plugin.appbrand.launching.ae.a.li(adu);
                            if (li != null) {
                                switch (adu) {
                                    case -13003:
                                        y.lh(j.iBm);
                                        com.tencent.mm.plugin.appbrand.report.a.C(str, 12, 3);
                                        z = false;
                                        break;
                                    case -13002:
                                        y.lh(j.iBl);
                                        com.tencent.mm.plugin.appbrand.report.a.C(str, 13, 3);
                                        z = false;
                                        break;
                                    default:
                                        if (!z) {
                                            y.tF(ad.getResources().getString(j.iDr, new Object[]{Integer.valueOf(3), Integer.valueOf(adu)}));
                                            z = false;
                                            break;
                                        }
                                        z = true;
                                        break;
                                }
                            } else if (z) {
                                switch (AnonymousClass1.jDS[li.ordinal()]) {
                                    case 1:
                                        z = true;
                                        break;
                                    case 2:
                                        y.lh(j.iBk);
                                        com.tencent.mm.plugin.appbrand.report.a.C(str, 13, 3);
                                        z = false;
                                        break;
                                    default:
                                        y.lh(j.iBj);
                                        com.tencent.mm.plugin.appbrand.report.a.C(str, 13, 3);
                                        z = false;
                                        break;
                                }
                            } else {
                                z = true;
                            }
                            if (!z) {
                                z = true;
                            }
                        }
                        if (this.iNi == 0) {
                            if (1 != wxaAttributes.acs().iSR) {
                                z = true;
                            } else {
                                AppBrand404PageUI.show(j.iCA);
                                com.tencent.mm.plugin.appbrand.report.a.C(wxaAttributes.field_appId, 14, 1);
                                i = 0;
                            }
                            if (i == 0) {
                                z = true;
                            }
                        }
                        z = false;
                    }
                    if (z) {
                        onError();
                        return;
                    }
                    f.acm();
                    a = f.a(wxaAttributes);
                    a.iIZ = this.iNi;
                    a.iRk = ((Boolean) pair.second).booleanValue();
                    this.appId = a.appId;
                    if (this.iNi != 0) {
                        a.extInfo = ((i) e.u(i.class)).aG(this.appId, this.iNi);
                        try {
                            fA = com.tencent.mm.u.g.fA(a.extInfo);
                            a.iRe = fA.optString("device_orientation");
                            a.iRf = fA.optString("client_js_ext_info");
                            a.iRh = fA.optBoolean("open_remote", false);
                        } catch (Exception e3) {
                        }
                    } else {
                        a.iRe = wxaAttributes.acs().iPM;
                        a.iRf = wxaAttributes.acs().iRf;
                    }
                    if (this.jCq == null) {
                        this.jCq = new AppBrandStatObject();
                    }
                    appBrandStatObject = this.jCq;
                    if (this.jCp != null) {
                        this.jCp.c(a, appBrandStatObject);
                    }
                }
                x.i("MicroMsg.AppBrandPreLaunchProcess", "onGetWxaAttr null return");
                onError();
                return;
            }
        } catch (Exception e4) {
            e = e4;
            aiI = null;
        }
        if (wxaAttributes != null) {
            x.i("MicroMsg.AppBrandPreLaunchProcess", "onGetWxaAttr null return");
            onError();
            return;
        }
        str = wxaAttributes.field_appId;
        vVar = new v(str);
        if (g.Af().getInt("WeAppForbiddenSwitch", 0) != 1) {
            x.i("MicroMsg.AppBrand.PreLaunchCheckForOversea", "startApp, WeAppForbiddenSwitch == 1, go webview, appId %s", vVar.appId);
            putExtra = new Intent().putExtra("rawUrl", l.pI(vVar.appId)).putExtra("forceHideShare", true);
            context = ad.getContext();
            if (context instanceof Activity) {
                putExtra.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            }
            d.b(context, "webview", ".ui.tools.WebViewUI", putExtra);
            z = true;
        } else {
            z = false;
        }
        if (z) {
            z = true;
        } else {
            if (2 == this.iNi) {
                z = com.tencent.mm.plugin.appbrand.task.d.uT(str);
                adu = new ae(str, ad.aH(str, 2), ad.aH(str, 10001), z).adu();
                x.i("MicroMsg.AppBrand.PrepareStepOpBan", "checkDemoInfo, appId %s, ret %d, ignoreCgiError %b", str, Integer.valueOf(adu), Boolean.valueOf(z));
                li = com.tencent.mm.plugin.appbrand.launching.ae.a.li(adu);
                if (li != null) {
                    if (z) {
                        switch (AnonymousClass1.jDS[li.ordinal()]) {
                            case 1:
                                z = true;
                                break;
                            case 2:
                                y.lh(j.iBk);
                                com.tencent.mm.plugin.appbrand.report.a.C(str, 13, 3);
                                z = false;
                                break;
                            default:
                                y.lh(j.iBj);
                                com.tencent.mm.plugin.appbrand.report.a.C(str, 13, 3);
                                z = false;
                                break;
                        }
                    }
                    z = true;
                } else {
                    switch (adu) {
                        case -13003:
                            y.lh(j.iBm);
                            com.tencent.mm.plugin.appbrand.report.a.C(str, 12, 3);
                            z = false;
                            break;
                        case -13002:
                            y.lh(j.iBl);
                            com.tencent.mm.plugin.appbrand.report.a.C(str, 13, 3);
                            z = false;
                            break;
                        default:
                            if (!z) {
                                z = true;
                                break;
                            }
                            y.tF(ad.getResources().getString(j.iDr, new Object[]{Integer.valueOf(3), Integer.valueOf(adu)}));
                            z = false;
                            break;
                    }
                }
                if (z) {
                    z = true;
                }
            }
            if (this.iNi == 0) {
                if (1 != wxaAttributes.acs().iSR) {
                    AppBrand404PageUI.show(j.iCA);
                    com.tencent.mm.plugin.appbrand.report.a.C(wxaAttributes.field_appId, 14, 1);
                    i = 0;
                } else {
                    z = true;
                }
                if (i == 0) {
                    z = true;
                }
            }
            z = false;
        }
        if (z) {
            onError();
            return;
        }
        f.acm();
        a = f.a(wxaAttributes);
        a.iIZ = this.iNi;
        a.iRk = ((Boolean) pair.second).booleanValue();
        this.appId = a.appId;
        if (this.iNi != 0) {
            a.iRe = wxaAttributes.acs().iPM;
            a.iRf = wxaAttributes.acs().iRf;
        } else {
            a.extInfo = ((i) e.u(i.class)).aG(this.appId, this.iNi);
            fA = com.tencent.mm.u.g.fA(a.extInfo);
            a.iRe = fA.optString("device_orientation");
            a.iRf = fA.optString("client_js_ext_info");
            a.iRh = fA.optBoolean("open_remote", false);
        }
        if (this.jCq == null) {
            this.jCq = new AppBrandStatObject();
        }
        appBrandStatObject = this.jCq;
        if (this.jCp != null) {
            this.jCp.c(a, appBrandStatObject);
        }
    }

    private void onError() {
        if (this.jCp != null) {
            this.jCp.c(null, null);
        }
    }
}
