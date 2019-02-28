package com.tencent.mm.plugin.pwdgroup;

import android.graphics.Bitmap;
import com.tencent.mm.a.f;
import com.tencent.mm.ac.n;
import com.tencent.mm.bx.h.d;
import com.tencent.mm.plugin.pwdgroup.b.a;
import com.tencent.mm.pluginsdk.ui.j;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.ap;
import java.lang.ref.WeakReference;
import java.util.HashMap;

public final class c implements ap {
    public final HashMap<Integer, d> Bu() {
        return null;
    }

    public final void ge(int i) {
    }

    public final void bs(boolean z) {
        a.prd = new j.a() {
            private Bitmap feZ = null;
            private f<String, WeakReference<Bitmap>> pre;

            {
                try {
                    this.feZ = b.a(ad.getContext().getAssets().open("avatar/default_nor_avatar.png"), com.tencent.mm.bu.a.getDensity(null));
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.Facing.SubCorePwdGroup", e, "", new Object[0]);
                }
                this.pre = new f(15);
            }

            public final void a(j jVar) {
                if (jVar instanceof com.tencent.mm.ac.d.a) {
                    n.JF().a((com.tencent.mm.ac.d.a) jVar);
                }
            }

            public final Bitmap cm(String str) {
                WeakReference weakReference = (WeakReference) this.pre.get(str);
                if (weakReference != null && weakReference.get() != null && !((Bitmap) weakReference.get()).isRecycled() && weakReference.get() == this.feZ) {
                    return (Bitmap) weakReference.get();
                }
                Bitmap a = com.tencent.mm.ac.b.a(str, false, -1);
                if (a == null || a.isRecycled()) {
                    return this.feZ;
                }
                this.pre.l(str, new WeakReference(a));
                return a;
            }

            public final Bitmap tK() {
                return this.feZ;
            }

            public final Bitmap cn(String str) {
                return null;
            }

            public final Bitmap b(String str, int i, int i2, int i3) {
                return null;
            }
        };
    }

    public final void bt(boolean z) {
    }

    public final void onAccountRelease() {
    }
}
