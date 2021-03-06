package com.tencent.mm.ap.a.b;

import android.graphics.Bitmap;
import android.os.Build.VERSION;
import com.tencent.mm.ap.a.c.m;
import com.tencent.mm.ap.a.d.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Map;
import java.util.Map.Entry;

public final class f implements m {
    private a<String, Bitmap> hFQ = new a(50);
    private a<String, Bitmap> hFR = new a(10);

    public final Bitmap iJ(String str) {
        if (bi.oN(str)) {
            return null;
        }
        return this.hFQ.get(str) == null ? (Bitmap) this.hFR.get(str) : (Bitmap) this.hFQ.get(str);
    }

    public final void c(String str, Bitmap bitmap) {
        if (bi.oN(str)) {
            x.w("MicroMsg.imageloader.DefaultImageMemoryCacheListener", "[cpan] put failed. key is null.");
        } else if (bitmap == null) {
            x.w("MicroMsg.imageloader.DefaultImageMemoryCacheListener", "[cpan] put failed.value is null.");
        } else {
            long j;
            if (bitmap == null || !(bitmap instanceof Bitmap)) {
                j = 0;
            } else {
                Bitmap bitmap2 = bitmap;
                if (VERSION.SDK_INT >= 12) {
                    j = (long) bitmap2.getByteCount();
                } else {
                    j = (long) (bitmap2.getHeight() * bitmap2.getRowBytes());
                }
            }
            x.d("MicroMsg.imageloader.DefaultImageMemoryCacheListener", "[cpan] put key:%s,bitmap size:%d B newsize:%s", str, Long.valueOf(j), bi.by(j));
            if (j > 524288) {
                this.hFR.put(str, bitmap);
            } else {
                this.hFQ.put(str, bitmap);
            }
        }
    }

    public final void clear() {
        synchronized (this) {
            Map snapshot;
            Bitmap bitmap;
            if (this.hFQ != null) {
                snapshot = this.hFQ.snapshot();
                if (!snapshot.isEmpty() && snapshot.size() > 0) {
                    for (Entry value : snapshot.entrySet()) {
                        bitmap = (Bitmap) value.getValue();
                        if (!(bitmap == null || bitmap.isRecycled())) {
                            x.i("MicroMsg.imageloader.DefaultImageMemoryCacheListener", "recycle bitmap:%s, not need", bitmap.toString());
                        }
                    }
                }
                this.hFQ.clear();
            }
            if (this.hFR != null) {
                snapshot = this.hFR.snapshot();
                if (!snapshot.isEmpty() && snapshot.size() > 0) {
                    for (Entry value2 : snapshot.entrySet()) {
                        bitmap = (Bitmap) value2.getValue();
                        if (!(bitmap == null || bitmap.isRecycled())) {
                            x.i("MicroMsg.imageloader.DefaultImageMemoryCacheListener", "recycle bitmap:%s. not need", bitmap.toString());
                        }
                    }
                }
                this.hFR.clear();
            }
        }
    }
}
