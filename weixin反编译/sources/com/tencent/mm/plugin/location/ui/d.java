package com.tencent.mm.plugin.location.ui;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import com.tencent.mm.plugin.location.model.LocationInfo;
import com.tencent.mm.plugin.location.model.e;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.net.URLEncoder;

public final class d {
    public Context context;
    public int hLe = -1;
    private ActivityManager mrt;
    public int nYn = 0;
    public int nYo = 0;
    public boolean nYp = false;

    public static int gq(boolean z) {
        x.d("MicroMsg.MapHelper", new StringBuilder("getDefaultZoom isGoogle : false").toString());
        return 16;
    }

    public d(Context context) {
        this.context = context;
        this.mrt = (ActivityManager) context.getSystemService("activity");
    }

    private static Intent a(LocationInfo locationInfo, LocationInfo locationInfo2, boolean z) {
        if (z || !locationInfo2.aVQ()) {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("geo:" + locationInfo.nWe + "," + locationInfo.nWf + "?z=" + locationInfo.zoom));
            intent.setPackage("com.baidu.BaiduMap");
            return intent;
        }
        String format = String.format("intent://map/direction?origin=%f,%f&destination=%f,%f&mode=driving&coord_type=gcj02", new Object[]{Double.valueOf(locationInfo2.nWe), Double.valueOf(locationInfo2.nWf), Double.valueOf(locationInfo.nWe), Double.valueOf(locationInfo.nWf)});
        x.d("MicroMsg.MapHelper", "url " + format);
        try {
            format = format + "&referer=tencent|weixin#Intent;scheme=bdapp;package=com.baidu.BaiduMap;end";
            x.d("MicroMsg.MapHelper", "all: " + format);
            return Intent.getIntent(format);
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.MapHelper", e, "", new Object[0]);
            return null;
        }
    }

    private static Intent b(LocationInfo locationInfo, LocationInfo locationInfo2, boolean z) {
        Intent intent;
        if (z || !locationInfo2.aVQ()) {
            intent = new Intent("android.intent.action.VIEW", Uri.parse("geo:" + locationInfo.nWe + "," + locationInfo.nWf + "?z=" + locationInfo.zoom));
            intent.setClassName("com.google.android.apps.maps", "com.google.android.maps.MapsActivity");
            return intent;
        }
        intent = new Intent("android.intent.action.VIEW", Uri.parse(String.format("http://maps.google.com/maps?f=d&saddr=%f,%f&daddr=%f,%f&hl=" + (bi.oN(locationInfo.nWh) ? "zh-cn" : locationInfo.nWh), new Object[]{Double.valueOf(locationInfo2.nWe), Double.valueOf(locationInfo2.nWf), Double.valueOf(locationInfo.nWe), Double.valueOf(locationInfo.nWf)})));
        intent.setClassName("com.google.android.apps.maps", "com.google.android.maps.MapsActivity");
        return intent;
    }

    private static Intent a(Context context, LocationInfo locationInfo, LocationInfo locationInfo2, boolean z) {
        Intent intent;
        if (z || !locationInfo2.aVQ()) {
            intent = new Intent("android.intent.action.VIEW", Uri.parse("geo:" + locationInfo.nWe + "," + locationInfo.nWf + "?z=" + locationInfo.zoom));
            intent.setPackage("com.tencent.map");
            return intent;
        }
        String str = "&from=%s";
        String str2 = "&to=%s";
        String format = String.format("sosomap://type=nav&fromcoord=%f,%f&tocoord=%f,%f", new Object[]{Double.valueOf(locationInfo2.nWf), Double.valueOf(locationInfo2.nWe), Double.valueOf(locationInfo.nWf), Double.valueOf(locationInfo.nWe)});
        if (!bi.oN(locationInfo2.nWg)) {
            String encode = URLEncoder.encode(locationInfo2.nWg);
            format = format + String.format(str, new Object[]{encode});
        }
        if (!bi.oN(locationInfo.nWg)) {
            str = URLEncoder.encode(locationInfo.nWg);
            format = format + String.format(str2, new Object[]{str});
        }
        x.d("MicroMsg.MapHelper", "tencentluxian, url=%s", format + "&referer=wx_client");
        intent = new Intent("android.intent.action.VIEW", Uri.parse(format));
        intent.setPackage("com.tencent.map");
        if (bi.k(context, intent)) {
            return intent;
        }
        intent = new Intent("android.intent.action.VIEW", Uri.parse("geo:" + locationInfo.nWe + "," + locationInfo.nWf));
        intent.setPackage("com.tencent.map");
        return intent;
    }

    private static Intent a(Context context, LocationInfo locationInfo, LocationInfo locationInfo2, boolean z, String str) {
        Intent intent;
        if (z || !locationInfo2.aVQ()) {
            intent = new Intent("android.intent.action.VIEW", Uri.parse("geo:" + locationInfo.nWe + "," + locationInfo.nWf + "?z=" + locationInfo.zoom));
            intent.setPackage(str);
            return intent;
        }
        String str2 = "&from=%s&to=%s";
        String format = String.format("wechatnav://type=nav&fromcoord=%f,%f&tocoord=%f,%f", new Object[]{Double.valueOf(locationInfo2.nWe), Double.valueOf(locationInfo2.nWf), Double.valueOf(locationInfo.nWe), Double.valueOf(locationInfo.nWf)});
        if (!(bi.oN(locationInfo2.nWg) || bi.oN(locationInfo.nWg))) {
            format = format + String.format(str2, new Object[]{locationInfo2.nWg, locationInfo.nWg});
        }
        intent = new Intent("android.intent.action.VIEW", Uri.parse(format));
        intent.setPackage(str);
        if (bi.k(context, intent)) {
            return intent;
        }
        intent = new Intent("android.intent.action.VIEW", Uri.parse("geo:" + locationInfo.nWe + "," + locationInfo.nWf));
        intent.setPackage(str);
        return intent;
    }

    public final void a(LocationInfo locationInfo, LocationInfo locationInfo2, String str, boolean z) {
        if ("com.tencent.map".equals(str)) {
            if (z) {
                g.pWK.h(11091, Integer.valueOf(4), Integer.valueOf(2));
            } else {
                g.pWK.h(11091, Integer.valueOf(4), Integer.valueOf(1));
            }
        } else if (z) {
            g.pWK.h(11091, Integer.valueOf(5), Integer.valueOf(2));
        } else {
            g.pWK.h(11091, Integer.valueOf(5), Integer.valueOf(1));
        }
        PackageManager packageManager = this.context.getPackageManager();
        Intent b;
        String charSequence;
        PackageInfo aq;
        if ("com.google.android.apps.maps".equals(str)) {
            b = b(locationInfo, locationInfo2, false);
            if (!bi.k(this.context, b)) {
                b = b(locationInfo, locationInfo2, true);
            }
            g.pWK.h(10997, "4", "", Integer.valueOf(0), Integer.valueOf(0));
            this.context.startActivity(b);
        } else if ("com.baidu.BaiduMap".equals(str)) {
            b = a(locationInfo, locationInfo2, false);
            if (!bi.k(this.context, b)) {
                b = a(locationInfo, locationInfo2, true);
            }
            charSequence = e.aq(this.context, "com.baidu.BaiduMap").applicationInfo.loadLabel(packageManager).toString();
            g.pWK.h(10997, "5", charSequence, Integer.valueOf(0), Integer.valueOf(0));
            this.context.startActivity(b);
        } else if ("com.tencent.map".equals(str)) {
            b = a(this.context, locationInfo, locationInfo2, false);
            if (!bi.k(this.context, b)) {
                b = a(this.context, locationInfo, locationInfo2, true);
            }
            g.pWK.h(10997, "2", "", Integer.valueOf(0), Integer.valueOf(0));
            this.context.startActivity(b);
        } else if ("com.autonavi.minimap".equals(str)) {
            aq = e.aq(this.context, str);
            if (aq != null) {
                b = a(this.context, locationInfo, locationInfo2, false, str);
                if (!bi.k(this.context, b)) {
                    b = a(this.context, locationInfo, locationInfo2, true, str);
                }
                charSequence = aq.applicationInfo.loadLabel(packageManager).toString();
                g.pWK.h(10997, "5", charSequence, Integer.valueOf(0), Integer.valueOf(0));
                this.context.startActivity(b);
            }
        } else if ("com.sogou.map.android.maps".equals(str)) {
            aq = e.aq(this.context, str);
            if (aq != null) {
                b = a(this.context, locationInfo, locationInfo2, false, str);
                if (!bi.k(this.context, b)) {
                    b = a(this.context, locationInfo, locationInfo2, true, str);
                }
                charSequence = aq.applicationInfo.loadLabel(packageManager).toString();
                g.pWK.h(10997, "5", charSequence, Integer.valueOf(0), Integer.valueOf(0));
                this.context.startActivity(b);
            }
        }
    }
}
