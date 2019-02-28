package com.tencent.mm.plugin.gallery.model;

import android.graphics.Bitmap;
import com.tencent.mm.a.f;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.sdk.e.k;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;
import java.util.Vector;

public final class b {
    k<b, String> hmJ = new k<b, String>() {
        protected final /* synthetic */ void p(Object obj, Object obj2) {
            ((b) obj).BX((String) obj2);
        }
    };
    public Vector<b> hmK = new Vector();
    f<String, a> mWm = new f(100, new com.tencent.mm.a.f.b<String, a>() {
        public final /* synthetic */ void m(Object obj, Object obj2) {
            String str = (String) obj;
            a aVar = (a) obj2;
            if (aVar == null) {
                x.d("MicroMsg.GalleryCache", "weakReference is null");
            } else if (aVar.bitmap == null) {
                x.d("MicroMsg.GalleryCache", "weakReference getbitmap is null");
            } else {
                aVar.bitmap.recycle();
                x.d("MicroMsg.GalleryCache", "gallery remove ", str);
            }
        }
    });
    d mWn;
    private final b mWo = new b() {
        public final void BX(String str) {
            x.i("MicroMsg.GalleryCache", "now listener size : " + b.this.hmK.size());
            for (int size = b.this.hmK.size() - 1; size >= 0; size--) {
                b bVar;
                try {
                    bVar = (b) b.this.hmK.get(size);
                } catch (Exception e) {
                    x.e("MicroMsg.GalleryCache", "get wathcer failed:[%s]", e.toString());
                    bVar = null;
                }
                if (bVar == null) {
                    x.d("MicroMsg.GalleryCache", "get listener is null");
                } else {
                    bVar.BX(str);
                }
            }
        }
    };

    private class a {
        Bitmap bitmap;
        private int type;

        public a(Bitmap bitmap, int i) {
            this.bitmap = bitmap;
            this.type = i;
        }
    }

    public interface b {
        void BX(String str);
    }

    public b() {
        d dVar = new d(new File(e.bnF + "/diskcache"));
        dVar.mWG = ad.getContext().getSharedPreferences(ad.cgf(), 0).getInt("com.tencent.mm.gallery.cache.suffix", 0);
        dVar.aOt();
        dVar.qB(-1);
        this.mWn = dVar;
        this.hmJ.a(this.mWo, null);
    }

    public final Bitmap getBitmap(String str) {
        if (bi.oN(str)) {
            x.e("MicroMsg.GalleryCache", "null filepath");
            return null;
        } else if (this.mWm == null) {
            x.w("MicroMsg.GalleryCache", "want to get bitmap, but gallery cache is null");
            return null;
        } else {
            if (this.mWm.bu(str)) {
                a aVar = (a) this.mWm.get(str);
                if (aVar == null) {
                    x.d("MicroMsg.GalleryCache", "weakreference is null");
                    this.mWm.remove(str);
                    return null;
                }
                Bitmap bitmap = aVar.bitmap;
                if (bitmap == null) {
                    this.mWm.remove(str);
                    x.i("MicroMsg.GalleryCache", "get bitmap is null");
                } else if (bitmap.isRecycled()) {
                    x.i("MicroMsg.GalleryCache", "cahce bitmap has recycled");
                    this.mWm.remove(str);
                    return null;
                } else {
                    x.i("MicroMsg.GalleryCache", "get cached bitmap:" + str);
                    return bitmap;
                }
            }
            return null;
        }
    }
}
