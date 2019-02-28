package com.tencent.mm.plugin.appbrand.dynamic.b;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.TextUtils;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.modelappbrand.a.b;
import com.tencent.mm.modelappbrand.a.b.h;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObject;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObjectManager;
import com.tencent.mm.plugin.appbrand.canvas.g;
import com.tencent.mm.plugin.appbrand.canvas.g.a;
import com.tencent.rtmp.TXLiveConstants;

final class c implements g {
    c() {
    }

    public final Bitmap aT(String str, String str2) {
        return a(str, str2, null);
    }

    public final Bitmap a(String str, String str2, a aVar) {
        return a(str, str2, null, aVar);
    }

    public final Bitmap a(final String str, final String str2, Rect rect, final a aVar) {
        if (str2.startsWith(AppBrandLocalMediaObjectManager.OBJECT_NAME_PREFIX)) {
            AppBrandLocalMediaObject itemByLocalId = AppBrandLocalMediaObjectManager.getItemByLocalId(str, str2);
            if (itemByLocalId == null || TextUtils.isEmpty(itemByLocalId.hjJ)) {
                return null;
            }
            String str3 = itemByLocalId.hjJ;
            if (!str3.startsWith("file://")) {
                str3 = "file://" + str3;
            }
            return b.Jp().a(str3, null);
        } else if (!str2.startsWith("https://") && !str2.startsWith("http://")) {
            return a.aT(str, str2);
        } else {
            Bitmap a = b.Jp().a(str2, null);
            if (a != null) {
                return a;
            }
            b.Jp().a(new h() {
                public final void Js() {
                }

                public final void j(Bitmap bitmap) {
                    if (aVar != null && bitmap != null && !bitmap.isRecycled()) {
                        aVar.abC();
                    }
                }

                public final void Jt() {
                    Bundle bundle = new Bundle();
                    bundle.putString(SlookAirButtonFrequentContactAdapter.ID, str);
                    bundle.putInt("widgetState", TXLiveConstants.PLAY_WARNING_RECONNECT);
                    f.a("com.tencent.mm:support", bundle, com.tencent.mm.plugin.appbrand.dynamic.f.a.class, null);
                }

                public final String Ju() {
                    return "WxaWidgetIcon";
                }
            }, str2, null, null);
            return a;
        }
    }
}
