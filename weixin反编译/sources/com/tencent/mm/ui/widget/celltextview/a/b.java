package com.tencent.mm.ui.widget.celltextview.a;

import android.util.LruCache;
import com.tencent.mm.ui.widget.celltextview.c.c;
import com.tencent.mm.ui.widget.celltextview.c.d;
import java.util.ArrayList;

public final class b {
    private static b zGg;
    private static Object zGi = new Object();
    public LruCache<a, a> zGh = new LruCache(200);

    private b() {
    }

    public static b cAa() {
        if (zGg == null) {
            synchronized (zGi) {
                if (zGg == null) {
                    zGg = new b();
                }
            }
        }
        return zGg;
    }

    public final void a(CharSequence charSequence, float f, float f2, ArrayList<c> arrayList, ArrayList<d> arrayList2) {
        a aVar = new a(charSequence == null ? "" : charSequence.toString(), f, f2);
        if (arrayList != null) {
            if (aVar.zGd == null) {
                aVar.zGd = new ArrayList(arrayList.size());
            }
            aVar.zGd.addAll(arrayList);
        }
        aVar.am(arrayList2);
        this.zGh.put(aVar, aVar);
    }
}
