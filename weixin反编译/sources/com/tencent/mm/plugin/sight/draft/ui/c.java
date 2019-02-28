package com.tencent.mm.plugin.sight.draft.ui;

import android.graphics.Bitmap;
import com.tencent.mm.R;
import com.tencent.mm.a.f;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.y.as;
import java.lang.ref.WeakReference;

public abstract class c {
    f<String, Bitmap> qBY = new f(24);
    private Bitmap qBZ;

    private static final class a implements Runnable {
        String aAM;
        String path;
        boolean qCa;
        WeakReference<c> qCb;

        private a() {
        }

        /* synthetic */ a(byte b) {
            this();
        }

        public final void run() {
            Bitmap Vs = d.Vs(this.path);
            c cVar = (c) this.qCb.get();
            if (cVar != null) {
                if (!(bi.oN(this.aAM) || Vs == null)) {
                    cVar.qBY.put(this.aAM, Vs);
                }
                Runnable bVar = new b();
                bVar.aAM = this.aAM;
                bVar.mZu = Vs;
                bVar.qCb = this.qCb;
                if (this.qCa) {
                    ah.y(bVar);
                }
            }
        }
    }

    private static final class b implements Runnable {
        String aAM;
        Bitmap mZu;
        WeakReference<c> qCb;

        private b() {
        }

        /* synthetic */ b(byte b) {
            this();
        }

        public final void run() {
            c cVar = (c) this.qCb.get();
            if (cVar != null) {
                cVar.r(this.aAM, this.mZu);
            }
        }
    }

    public abstract void r(String str, Bitmap bitmap);

    public final Bitmap o(String str, String str2, boolean z) {
        if (bi.oN(str)) {
            return btZ();
        }
        Bitmap bitmap = (Bitmap) this.qBY.get(str);
        if (bitmap != null) {
            return bitmap;
        }
        Object aVar = new a();
        aVar.aAM = str;
        aVar.path = str2;
        aVar.qCa = z;
        aVar.qCb = new WeakReference(this);
        if (z) {
            as.Dt().F(aVar);
        } else {
            aVar.run();
            bitmap = (Bitmap) this.qBY.get(str);
            if (bitmap != null) {
                return bitmap;
            }
        }
        return btZ();
    }

    private Bitmap btZ() {
        if (this.qBZ == null) {
            this.qBZ = d.Ds(R.k.dAo);
        }
        return this.qBZ;
    }
}
