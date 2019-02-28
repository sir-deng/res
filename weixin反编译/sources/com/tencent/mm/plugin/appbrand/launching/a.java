package com.tencent.mm.plugin.appbrand.launching;

import android.database.Cursor;
import com.tencent.mm.f.a.qr;
import com.tencent.mm.plugin.appbrand.app.e;
import com.tencent.mm.plugin.appbrand.appcache.ap;
import com.tencent.mm.plugin.appbrand.config.q;
import com.tencent.mm.plugin.appbrand.q.j;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.task.d;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Locale;

public final class a extends c<qr> {
    public a() {
        this.xmG = qr.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        qr qrVar = (qr) bVar;
        if (bi.oN(qrVar.fJd.userName)) {
            qrVar.fJe.fJp = false;
            qrVar.fJe.fJq = "invalid username or appId";
            return true;
        }
        if (!(bi.oN(qrVar.fJd.appId) || bi.oN(qrVar.fJd.fJl.hll))) {
            ((i) e.u(i.class)).n(qrVar.fJd.appId, qrVar.fJd.fJg, qrVar.fJd.fJl.hll);
        }
        AppBrandStatObject appBrandStatObject = new AppBrandStatObject();
        appBrandStatObject.scene = qrVar.fJd.scene;
        appBrandStatObject.foi = qrVar.fJd.foi;
        appBrandStatObject.fJn = com.tencent.mm.plugin.appbrand.report.c.f(appBrandStatObject.scene, qrVar.fJd.frc);
        appBrandStatObject.fJo = com.tencent.mm.plugin.appbrand.report.c.g(appBrandStatObject.scene, qrVar.fJd.frc);
        if (qrVar.fJd.scene == 1037 || qrVar.fJd.scene == 1018) {
            appBrandStatObject.fJm = qrVar.fJd.fJm;
        } else {
            appBrandStatObject.fJm = qrVar.fJd.scene;
        }
        switch (qrVar.fJd.fJg) {
            case 0:
            case 2:
                AppBrandLaunchProxyUI.a(qrVar.fJd.context, qrVar.fJd.userName, qrVar.fJd.appId, qrVar.fJd.fJf, qrVar.fJd.fJg, qrVar.fJd.fJh <= 0 ? -1 : qrVar.fJd.fJh, appBrandStatObject, null, qrVar.fJd.fJl);
                break;
            case 1:
                ap Zz;
                String str;
                int i;
                Cursor a;
                if (!qrVar.fJd.fJj) {
                    if (!bi.oN(qrVar.fJd.appId)) {
                        if (!bi.oN(qrVar.fJd.fwM) && !bi.oN(qrVar.fJd.fJi)) {
                            if (e.Zz().a(qrVar.fJd.appId, qrVar.fJd.fJg, qrVar.fJd.fwM, qrVar.fJd.fJi, 0, 0)) {
                                d.aL(qrVar.fJd.appId, qrVar.fJd.fJg);
                            } else {
                                boolean z;
                                Zz = e.Zz();
                                str = qrVar.fJd.appId;
                                i = qrVar.fJd.fJg;
                                if (bi.oN(str) || i < 0) {
                                    z = false;
                                } else {
                                    a = Zz.iIR.a("AppBrandWxaPkgManifestRecord", new String[]{"version"}, String.format(Locale.US, "%s=? and %s=?", new Object[]{"appId", "debugType"}), new String[]{str, String.valueOf(i)}, null, null, null, 2);
                                    if (a == null) {
                                        z = false;
                                    } else {
                                        z = a.moveToFirst();
                                        a.close();
                                    }
                                }
                                if (!z) {
                                    qrVar.fJe.fJp = false;
                                    qrVar.fJe.fJq = "install app failed";
                                    return true;
                                }
                            }
                            appBrandStatObject.foi = qrVar.fJd.fwM;
                            AppBrandLaunchProxyUI.a(qrVar.fJd.context, qrVar.fJd.userName, qrVar.fJd.fJf, qrVar.fJd.fJg, -1, appBrandStatObject, qrVar.fJd.fJl);
                            break;
                        }
                        qrVar.fJe.fJp = false;
                        qrVar.fJe.fJq = "invalid downloadURL or checkSumMd5";
                        return true;
                    }
                    qrVar.fJe.fJp = false;
                    qrVar.fJe.fJq = "invalid username or appId";
                    return true;
                }
                com.tencent.mm.f.a.qr.a aVar = qrVar.fJd;
                str = q.rl(qrVar.fJd.userName);
                aVar.appId = str;
                if (!bi.oN(str)) {
                    String str2;
                    Zz = e.Zz();
                    str = qrVar.fJd.appId;
                    i = qrVar.fJd.fJg;
                    a = Zz.iIR.query("AppBrandWxaPkgManifestRecord", new String[]{"pkgPath"}, String.format(Locale.US, "%s=? and %s=?", new Object[]{"appId", "debugType"}), new String[]{str, String.valueOf(i)}, null, null, null);
                    if (a == null) {
                        str2 = null;
                    } else {
                        str2 = a.moveToFirst() ? a.getString(0) : null;
                        a.close();
                    }
                    if (bi.oN(str2) || !com.tencent.mm.a.e.bO(str2)) {
                        Object obj;
                        ap Zz2 = e.Zz();
                        String str3 = qrVar.fJd.appId;
                        int i2 = qrVar.fJd.fJg;
                        if ((com.tencent.mm.plugin.appbrand.appcache.d.a.hi(i2) ? 1 : Zz2.ai(str3, i2)) < 0) {
                            x.e("MicroMsg.AppBrandWxaPkgStorage", "hasModuleList, appId(%s), type(%s), version(%d), not records", str3, Integer.valueOf(i2), Integer.valueOf(com.tencent.mm.plugin.appbrand.appcache.d.a.hi(i2) ? 1 : Zz2.ai(str3, i2)));
                        } else {
                            String format = String.format(Locale.US, "where %s like '%s$%%' and %s=%d and %s=%d", new Object[]{"appId", str3, "debugType", Integer.valueOf(i2), "version", Integer.valueOf(com.tencent.mm.plugin.appbrand.appcache.d.a.hi(i2) ? 1 : Zz2.ai(str3, i2))});
                            a = Zz2.iIR.a(String.format(Locale.US, "select count(*) from %s %s", new Object[]{"AppBrandWxaPkgManifestRecord", format}), null, 2);
                            int i3;
                            if (a == null || a.isClosed()) {
                                x.e("MicroMsg.AppBrandWxaPkgStorage", "hasModuleList, appId(%s), type(%s), version(%d), cursor nil", str3, Integer.valueOf(i2), Integer.valueOf(i3));
                            } else {
                                i3 = a.moveToFirst() ? a.getInt(0) : 0;
                                a.close();
                                if (i3 > 0) {
                                    obj = 1;
                                    if (obj != null) {
                                        qrVar.fJe.fJp = true;
                                        x.i("MicroMsg.AppBrandLaunchFromOuterEventListener", "callback with appId(%s) type(%d), hasModuleList=true", qrVar.fJd.appId, Integer.valueOf(qrVar.fJd.fJg));
                                        AppBrandLaunchProxyUI.a(qrVar.fJd.context, qrVar.fJd.userName, qrVar.fJd.fJf, qrVar.fJd.fJg, 0, appBrandStatObject, qrVar.fJd.fJl);
                                        return true;
                                    }
                                }
                            }
                        }
                        obj = null;
                        if (obj != null) {
                            qrVar.fJe.fJp = true;
                            x.i("MicroMsg.AppBrandLaunchFromOuterEventListener", "callback with appId(%s) type(%d), hasModuleList=true", qrVar.fJd.appId, Integer.valueOf(qrVar.fJd.fJg));
                            AppBrandLaunchProxyUI.a(qrVar.fJd.context, qrVar.fJd.userName, qrVar.fJd.fJf, qrVar.fJd.fJg, 0, appBrandStatObject, qrVar.fJd.fJl);
                            return true;
                        }
                    }
                    qrVar.fJe.fJp = true;
                    AppBrandLaunchProxyUI.a(qrVar.fJd.context, qrVar.fJd.userName, qrVar.fJd.fJf, qrVar.fJd.fJg, 0, appBrandStatObject, qrVar.fJd.fJl);
                    return true;
                }
                qrVar.fJe.fJp = false;
                qrVar.fJe.fJq = "local pkg not exists";
                if (qrVar.fJd.fJk) {
                    str = null;
                    if (qrVar.fJd.fJg == 1) {
                        str = com.tencent.mm.plugin.appbrand.r.c.getMMString(j.iBg, new Object[0]);
                    } else if (qrVar.fJd.fJg == 2) {
                        str = com.tencent.mm.plugin.appbrand.r.c.getMMString(j.iCE, new Object[0]);
                    }
                    com.tencent.mm.plugin.appbrand.ipc.a.a(qrVar.fJd.context, str, com.tencent.mm.plugin.appbrand.r.c.getMMString(j.dGZ, new Object[0]), com.tencent.mm.plugin.appbrand.r.c.getMMString(j.dGf, new Object[0]), "", null, null, null);
                }
                return true;
                break;
            default:
                qrVar.fJe.fJp = false;
                qrVar.fJe.fJq = "invalid openType";
                return true;
        }
        qrVar.fJe.fJp = true;
        return true;
    }
}
