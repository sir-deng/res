package com.tencent.mm.plugin.appbrand.canvas;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.text.TextUtils;
import com.tencent.mm.modelappbrand.a.b;
import com.tencent.mm.modelappbrand.a.b.e;
import com.tencent.mm.modelappbrand.a.b.h;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObject;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObjectManager;
import com.tencent.mm.plugin.appbrand.canvas.g.a;
import com.tencent.mm.plugin.appbrand.page.o;

final class j implements g {
    j() {
    }

    public final Bitmap aT(String str, String str2) {
        return a(str, str2, null);
    }

    public final Bitmap a(String str, String str2, a aVar) {
        return a(str, str2, null, aVar);
    }

    public final Bitmap a(final String str, final String str2, Rect rect, final a aVar) {
        e aVar2;
        Bitmap a;
        if (rect != null) {
            aVar2 = new a(rect.left, rect.top, rect.width(), rect.height());
        } else {
            aVar2 = null;
        }
        if (str2.startsWith(AppBrandLocalMediaObjectManager.OBJECT_NAME_PREFIX)) {
            AppBrandLocalMediaObject itemByLocalId = AppBrandLocalMediaObjectManager.getItemByLocalId(str, str2);
            if (itemByLocalId == null || TextUtils.isEmpty(itemByLocalId.hjJ)) {
                return null;
            }
            String str3 = itemByLocalId.hjJ;
            if (!str3.startsWith("file://")) {
                str3 = "file://" + str3;
            }
            a = b.Jp().a(str3, aVar2);
        } else if (str2.startsWith("https://") || str2.startsWith("http://")) {
            Bitmap a2 = b.Jp().a(str2, aVar2);
            if (a2 == null) {
                b.Jp().a(new h() {
                    public final void Js() {
                    }

                    public final void j(Bitmap bitmap) {
                        if (aVar != null && bitmap != null && !bitmap.isRecycled()) {
                            aVar.abC();
                        }
                    }

                    public final void Jt() {
                    }

                    public final String Ju() {
                        return "WxaIcon";
                    }
                }, str2, null, aVar2);
                a = a2;
            } else {
                a = a2;
            }
        } else {
            a = o.j(com.tencent.mm.plugin.appbrand.a.pi(str), str2);
            if (rect != null) {
                a = new b(rect.left, rect.top, rect.width(), rect.height()).k(a);
            }
        }
        return a;
    }
}
