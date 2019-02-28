package com.tencent.mm.ap;

import android.graphics.Bitmap;
import com.tencent.mm.a.f;
import com.tencent.mm.cache.e;

final class j implements e {
    private f<String, Bitmap> hCT = new f(5);

    j() {
    }

    public final void n(Object obj, Object obj2) {
        this.hCT.l((String) obj, (Bitmap) obj2);
    }

    public final Object get(Object obj) {
        return this.hCT.get((String) obj);
    }

    public final Object remove(Object obj) {
        this.hCT.remove((String) obj);
        return null;
    }
}
