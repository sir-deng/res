package com.tencent.mm.plugin.appbrand.launching.a;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.mm.compatible.util.p;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.modelappbrand.LaunchParamsOptional;
import com.tencent.mm.plugin.appbrand.app.e;
import com.tencent.mm.plugin.appbrand.launching.AppBrandLaunchProxyUI;
import com.tencent.mm.plugin.appbrand.launching.i;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.report.c;
import com.tencent.mm.plugin.appbrand.task.d;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;

abstract class a {

    enum a {
        ;

        public static int[] aiJ() {
            return (int[]) jEh.clone();
        }

        static {
            jEd = 1;
            jEe = 2;
            jEf = 3;
            jEg = 4;
            jEh = new int[]{jEd, jEe, jEf, jEg};
        }
    }

    abstract void a(Uri uri, int i);

    a() {
    }

    final int a(Context context, String str, int i, Bundle bundle) {
        int i2;
        x.i("MicroMsg.AppBrand.AbsLinkOpener", "handle url = %s", str);
        Uri uri = null;
        if (bi.oN(str)) {
            i2 = a.jEe;
        } else {
            Uri parse = Uri.parse(str);
            String queryParameter;
            String queryParameter2;
            AppBrandStatObject appBrandStatObject;
            if ((bi.getInt(parse.getQueryParameter("debug"), 0) > 0 ? 1 : null) != null) {
                i2 = bi.getInt(parse.getQueryParameter("ret"), 0);
                if (i2 == 1) {
                    i2 = a.jEf;
                    uri = parse;
                } else if (i2 == 2) {
                    i2 = a.jEg;
                    uri = parse;
                } else {
                    queryParameter = parse.getQueryParameter("appid");
                    String queryParameter3 = parse.getQueryParameter("username");
                    String oM = bi.oM(parse.getQueryParameter("path"));
                    String queryParameter4 = parse.getQueryParameter("codeurl");
                    String queryParameter5 = parse.getQueryParameter("md5");
                    String queryParameter6 = parse.getQueryParameter("pageurl");
                    String queryParameter7 = parse.getQueryParameter("pagemd5");
                    long j = bi.getLong(parse.getQueryParameter("test_lifespan"), 7200);
                    if (bi.oN(queryParameter) || bi.oN(queryParameter3) || bi.oN(queryParameter4)) {
                        x.i("MicroMsg.AppBrand.AbsLinkOpener", "appId = %s, username = %s, codeURL = %s, invalid, return", queryParameter, queryParameter3, queryParameter4);
                        i2 = a.jEe;
                        uri = parse;
                    } else {
                        boolean a = e.Zz().a(queryParameter, 1, queryParameter4, queryParameter5, 0, bi.Wx() + j);
                        if (!(bi.oN(queryParameter6) || bi.oN(queryParameter7))) {
                            e.Zz().a(queryParameter, 10000, queryParameter6, queryParameter7, 0, bi.Wx() + j);
                            i2 = com.tencent.mm.plugin.appbrand.dynamic.k.a.bD(0, 1);
                            if (i2 == 10000) {
                                Parcelable bundle2 = new Bundle();
                                bundle2.putString("appId", queryParameter);
                                bundle2.putInt("debugType", i2);
                                f.a("com.tencent.mm", bundle2, d.class, null);
                            }
                        }
                        if (a) {
                            d.aL(queryParameter, 1);
                        }
                        queryParameter2 = parse.getQueryParameter("json_extinfo");
                        LaunchParamsOptional launchParamsOptional = new LaunchParamsOptional();
                        launchParamsOptional.hll = queryParameter2;
                        ((i) e.u(i.class)).n(queryParameter, 1, queryParameter2);
                        appBrandStatObject = new AppBrandStatObject();
                        a(str, i, appBrandStatObject, bundle);
                        AppBrandLaunchProxyUI.a(context, queryParameter3, oM, 1, -1, appBrandStatObject, launchParamsOptional);
                        i2 = a.jEd;
                        uri = parse;
                    }
                }
            } else {
                queryParameter2 = parse.getQueryParameter("username");
                queryParameter = bi.oM(parse.getQueryParameter("path"));
                int i3 = bi.getInt(parse.getQueryParameter("version"), 0);
                int i4 = bi.getInt(parse.getQueryParameter(Columns.TYPE), 0);
                if (bi.oN(queryParameter2)) {
                    x.i("MicroMsg.AppBrand.AbsLinkOpener", "username = %s, invalid, return", queryParameter2);
                    i2 = a.jEe;
                    uri = parse;
                } else {
                    appBrandStatObject = new AppBrandStatObject();
                    a(str, i, appBrandStatObject, bundle);
                    AppBrandLaunchProxyUI.a(context, queryParameter2, queryParameter, i4, i3, appBrandStatObject, null);
                    i2 = a.jEd;
                    uri = parse;
                }
            }
        }
        a(uri, i2);
        return i2;
    }

    private static void a(String str, int i, AppBrandStatObject appBrandStatObject, Bundle bundle) {
        appBrandStatObject.scene = i;
        appBrandStatObject.foi = p.encode(str);
        appBrandStatObject.fJn = c.f(i, bundle);
        appBrandStatObject.fJo = c.g(i, bundle);
        if (i == 1037 || i == 1018) {
            appBrandStatObject.fJm = 0;
        } else {
            appBrandStatObject.fJm = i;
        }
    }
}
