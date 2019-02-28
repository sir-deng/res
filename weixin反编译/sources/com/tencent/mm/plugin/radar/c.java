package com.tencent.mm.plugin.radar;

import android.graphics.Bitmap;
import b.c.b.e;
import b.i;
import com.tencent.mm.a.f;
import com.tencent.mm.ac.n;
import com.tencent.mm.bx.h;
import com.tencent.mm.pluginsdk.ui.j;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.ap;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.HashMap;

public final class c implements ap {
    private static final String TAG = TAG;
    public static final a pCc = new a();

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }
    }

    public static final class b implements com.tencent.mm.pluginsdk.ui.j.a {
        private Bitmap feZ;
        private Bitmap pCd;
        private final f<String, WeakReference<Bitmap>> pre = new f(15);

        b() {
            try {
                Object context = ad.getContext();
                e.h(context, "MMApplicationContext.getContext()");
                this.feZ = com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.a(context.getAssets().open("avatar/default_nor_avatar.png"), com.tencent.mm.bu.a.getDensity(null));
                Bitmap bitmap = this.feZ;
                Bitmap bitmap2 = this.feZ;
                if (bitmap2 == null) {
                    e.cKr();
                }
                this.pCd = d.a(bitmap, false, (float) (bitmap2.getWidth() / 2));
            } catch (IOException e) {
                a aVar = c.pCc;
                x.printErrStackTrace(c.TAG, e, "", new Object[0]);
            }
        }

        public final void a(j jVar) {
            e.i(jVar, "drawable");
            if (jVar instanceof com.tencent.mm.ac.d.a) {
                n.JF().a((com.tencent.mm.ac.d.a) jVar);
            }
        }

        public final Bitmap cm(String str) {
            e.i(str, "tag");
            WeakReference weakReference = (WeakReference) this.pre.get(str);
            if (!(weakReference == null || weakReference.get() == null)) {
                Object obj = weakReference.get();
                if (obj == null) {
                    throw new i("null cannot be cast to non-null type android.graphics.Bitmap");
                } else if (!((Bitmap) obj).isRecycled() && (e.h((Bitmap) weakReference.get(), this.feZ) ^ 1) == 0) {
                    return (Bitmap) weakReference.get();
                }
            }
            Bitmap iY = com.tencent.mm.ac.b.iY(str);
            if (iY == null || iY.isRecycled()) {
                return this.pCd;
            }
            iY = d.a(iY, false, (float) (iY.getWidth() / 2));
            this.pre.l(str, new WeakReference(iY));
            return iY;
        }

        public final Bitmap tK() {
            return this.feZ;
        }

        public final Bitmap cn(String str) {
            e.i(str, "tag");
            return null;
        }

        public final Bitmap b(String str, int i, int i2, int i3) {
            e.i(str, "tag");
            return null;
        }
    }

    public final HashMap<Integer, h.d> Bu() {
        return null;
    }

    public final void ge(int i) {
    }

    public final void bt(boolean z) {
    }

    public final void bs(boolean z) {
        com.tencent.mm.plugin.radar.ui.b.a aVar = com.tencent.mm.plugin.radar.ui.b.a.pDB;
        com.tencent.mm.plugin.radar.ui.b.a.a(new b());
    }

    public final void onAccountRelease() {
    }
}
