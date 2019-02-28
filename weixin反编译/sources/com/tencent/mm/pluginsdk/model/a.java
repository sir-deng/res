package com.tencent.mm.pluginsdk.model;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import java.util.List;

public final class a extends u {
    private final a vjE;
    private final Intent vjF;
    private final y vjG = new y();

    public enum a {
        TencentMap(0),
        GoogleMap(1),
        SogouMap(2),
        BaiduMap(3),
        AutonaviMap(4);
        
        public final int code;

        private a(int i) {
            this.code = i;
        }

        public final String getPackage() {
            switch (this) {
                case TencentMap:
                    return "com.tencent.map";
                case GoogleMap:
                    return "com.google.android.apps.maps";
                case SogouMap:
                    return "com.sogou.map.android.maps";
                case BaiduMap:
                    return "com.baidu.BaiduMap";
                case AutonaviMap:
                    return "com.autonavi.minimap";
                default:
                    return "com.tencent.map";
            }
        }

        public static a BR(int i) {
            switch (i) {
                case 0:
                    return TencentMap;
                case 1:
                    return GoogleMap;
                case 2:
                    return SogouMap;
                case 3:
                    return BaiduMap;
                case 4:
                    return AutonaviMap;
                default:
                    return TencentMap;
            }
        }
    }

    public a(Bundle bundle) {
        if (bundle == null || bundle.getParcelable("key_target_intent") == null) {
            this.vjE = a.TencentMap;
        } else {
            a BR = a.BR(bundle.getInt("key_map_app", a.TencentMap.code));
            if (a(ad.getContext(), BR, null) == null) {
                this.vjE = a.TencentMap;
            } else {
                this.vjE = BR;
            }
        }
        if (this.vjE == a.TencentMap) {
            this.vjF = null;
        } else {
            this.vjF = (Intent) bundle.getParcelable("key_target_intent");
        }
    }

    private static ResolveInfo a(Context context, a aVar, Intent intent) {
        if (intent == null) {
            intent = new Intent("android.intent.action.VIEW", Uri.parse(String.format("geo:%f,%f", new Object[]{Float.valueOf(0.0f), Float.valueOf(0.0f)})));
        }
        List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 0);
        if (bi.cC(queryIntentActivities)) {
            return null;
        }
        for (ResolveInfo resolveInfo : queryIntentActivities) {
            if (resolveInfo != null && resolveInfo.activityInfo != null && aVar.getPackage().equals(resolveInfo.activityInfo.packageName)) {
                return resolveInfo;
            }
        }
        return null;
    }

    public final boolean ed(Context context) {
        if (this.vjE == a.TencentMap) {
            return this.vjG.ed(context);
        }
        return a(context, this.vjE, this.vjF) != null;
    }

    public final boolean RV(String str) {
        return this.vjE.getPackage().equals(str);
    }

    public final String Wp() {
        return this.vjE == a.TencentMap ? "http://softroute.map.qq.com/downloadfile?cid=00008&referer=wx_client" : null;
    }

    public final String bYX() {
        return this.vjE == a.TencentMap ? "TencentMap.apk" : null;
    }

    public final com.tencent.mm.pluginsdk.model.v.a bYY() {
        if (this.vjE == a.TencentMap) {
            return this.vjG.bYY();
        }
        com.tencent.mm.pluginsdk.model.v.a aVar = new com.tencent.mm.pluginsdk.model.v.a();
        aVar.vkB = -1;
        aVar.vky = -1;
        ResolveInfo a = a(ad.getContext(), this.vjE, this.vjF);
        if (a == null) {
            return aVar;
        }
        aVar.vkC = a(ad.getContext(), a);
        return aVar;
    }

    public final String a(Context context, ResolveInfo resolveInfo) {
        return this.vjG.a(context, resolveInfo);
    }
}
