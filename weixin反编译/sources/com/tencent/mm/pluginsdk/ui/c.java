package com.tencent.mm.pluginsdk.ui;

import android.graphics.Bitmap;
import com.tencent.mm.pluginsdk.ui.a.b;

public final class c extends j implements com.tencent.mm.ac.d.a {
    a vpU;
    int vpV;

    private static class a implements com.tencent.mm.pluginsdk.ui.j.a {
        Bitmap kNe = null;
        private com.tencent.mm.pluginsdk.ui.j.a prd;

        public a(com.tencent.mm.pluginsdk.ui.j.a aVar) {
            this.prd = aVar;
        }

        public final Bitmap b(String str, int i, int i2, int i3) {
            if (this.prd != null) {
                return this.prd.b(str, i, i2, i3);
            }
            return null;
        }

        public final Bitmap cm(String str) {
            if (this.prd != null) {
                return this.prd.cm(str);
            }
            return null;
        }

        public final Bitmap cn(String str) {
            if (this.prd != null) {
                return this.prd.cn(str);
            }
            return null;
        }

        public final Bitmap tK() {
            if (this.kNe != null && !this.kNe.isRecycled()) {
                return this.kNe;
            }
            if (this.prd != null) {
                return this.prd.tK();
            }
            return null;
        }

        public final void a(j jVar) {
            if (this.prd != null) {
                this.prd.a(jVar);
            }
        }
    }

    public c(String str) {
        this(str, (byte) 0);
    }

    private c(String str, byte b) {
        super(new a(b.caI()), str, false);
        this.vpU = (a) this.prd;
    }
}
