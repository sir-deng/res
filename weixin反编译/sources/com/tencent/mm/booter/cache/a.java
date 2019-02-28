package com.tencent.mm.booter.cache;

import android.content.Context;
import android.graphics.Bitmap;
import com.tencent.mm.a.f;
import com.tencent.mm.cache.MCacheItem;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.r;
import com.tencent.mm.sdk.platformtools.x;

public final class a extends com.tencent.mm.cache.f.a {
    public static a gBb;
    private final f<String, Bitmap> gBc;

    private a() {
        Context context = ad.getContext();
        String str = "BACKGROUND_BITMAP_CACHE_LIMIT";
        if (com.tencent.mm.platformtools.a.a.values == null) {
            try {
                com.tencent.mm.platformtools.a.a.values = r.Vz(bi.convertStreamToString(context.getAssets().open("profile.ini")));
            } catch (Throwable e) {
                x.e("MicroMsg.ProfileUtil", "exception:%s", bi.i(e));
            }
        }
        this.gBc = new f(bi.getInt(com.tencent.mm.platformtools.a.a.values == null ? null : (String) com.tencent.mm.platformtools.a.a.values.get(str), MMBitmapFactory.ERROR_IMG_BUG_DETECTED_BEGIN));
    }

    public static void prepare() {
        if (gBb == null) {
            gBb = new a();
        }
    }

    public static void destroy() {
        if (gBb != null) {
            gBb.gBc.clear();
        }
    }

    public final Bitmap getBitmap(String str) {
        x.v("MicroMsg.MMCacheImpl", "getting bitmap: %s", str);
        return (Bitmap) this.gBc.get(str);
    }

    public final MCacheItem eo(String str) {
        x.v("MicroMsg.MMCacheImpl", "getting cache item: %s", str);
        return null;
    }

    public final void b(String str, Bitmap bitmap) {
        x.v("MicroMsg.MMCacheImpl", "setting bitmap: %s", str);
        this.gBc.l(str, bitmap);
    }

    public final void ep(String str) {
        x.v("MicroMsg.MMCacheImpl", "setting cache item: %s", str);
    }
}
