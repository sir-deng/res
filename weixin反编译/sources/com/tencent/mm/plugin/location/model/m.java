package com.tencent.mm.plugin.location.model;

import android.graphics.Bitmap;
import com.tencent.mm.bq.a.a;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.x;

public final class m implements a {
    private Bitmap kNe = null;
    aa<String, Bitmap> nXn = new aa(20);

    public m() {
        try {
            this.kNe = b.a(ad.getContext().getAssets().open("avatar/default_nor_avatar.png"), com.tencent.mm.bu.a.getDensity(null));
            this.kNe = d.a(this.kNe, false, (float) (this.kNe.getWidth() >> 1));
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.TrackAvatarCacheService", e, "", new Object[0]);
        }
    }

    public final Bitmap Ee(String str) {
        if (bi.oN(str)) {
            return null;
        }
        x.d("MicroMsg.TrackAvatarCacheService", "getAvatar, tag = %s, cacheSize = %d", str, Integer.valueOf(this.nXn.size()));
        Bitmap bitmap = (Bitmap) this.nXn.get(str);
        if (bitmap == null || bitmap.isRecycled()) {
            return null;
        }
        return bitmap;
    }

    public final void p(String str, Bitmap bitmap) {
        if (this.nXn.get(str) != null) {
            Bitmap bitmap2 = (Bitmap) this.nXn.get(str);
            if (!bitmap2.isRecycled()) {
                bitmap2.recycle();
            }
            this.nXn.remove(str);
        }
        this.nXn.put(str, bitmap);
        x.d("MicroMsg.TrackAvatarCacheService", "updateCache, tag = %s, cacheSize = %d", str, Integer.valueOf(this.nXn.size()));
    }
}
