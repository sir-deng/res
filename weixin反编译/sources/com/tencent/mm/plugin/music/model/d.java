package com.tencent.mm.plugin.music.model;

import android.graphics.Bitmap;
import android.os.Looper;
import android.view.View;
import com.tencent.mm.a.f;
import com.tencent.mm.ap.a.c.g;
import com.tencent.mm.au.c;
import com.tencent.mm.plugin.sns.b.n;
import com.tencent.mm.protocal.c.are;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.x;

public final class d {
    public f<String, Bitmap> gBc = new f(5);
    public a oOZ;
    public g oPa = new g() {
        public final void lF(String str) {
        }

        public final Bitmap a(String str, com.tencent.mm.ap.a.d.b bVar) {
            return null;
        }

        public final void a(String str, View view, com.tencent.mm.ap.a.d.b bVar) {
            String str2 = "MicroMsg.Music.MusicImageLoader";
            String str3 = "onImageLoadFinish %s %b";
            Object[] objArr = new Object[2];
            objArr[0] = str;
            objArr[1] = Boolean.valueOf(bVar.bitmap != null);
            x.i(str2, str3, objArr);
            final com.tencent.mm.au.a aVar = (com.tencent.mm.au.a) view.getTag();
            if (bVar.bitmap != null && aVar != null) {
                d.this.a(aVar, bVar.bitmap);
                final int[] o = c.o(bVar.bitmap);
                if (!aVar.e(o)) {
                    h.beg().P(aVar.field_musicId, o[0], o[1]);
                }
                if (d.this.oOZ != null) {
                    ah.y(new Runnable() {
                        public final void run() {
                            d.this.oOZ.a(aVar, o);
                        }
                    });
                }
            }
        }
    };
    public ag oPb = new ag(Looper.getMainLooper());

    public interface a {
        void a(com.tencent.mm.au.a aVar, int[] iArr);
    }

    private class b implements Runnable {
        com.tencent.mm.au.a fBv;

        public b(com.tencent.mm.au.a aVar) {
            this.fBv = aVar;
        }

        public final void run() {
            are are = new are();
            are.nMq = this.fBv.field_songMediaId;
            are.wEP = this.fBv.field_songAlbumUrl;
            are.wEQ = this.fBv.field_songAlbumType;
            are.nlE = are.wEP;
            Bitmap b = n.qWB.b(are);
            if (b != null) {
                b = com.tencent.mm.sdk.platformtools.d.c(b, 10);
                d.this.a(this.fBv, b);
                int[] o = c.o(b);
                if (!this.fBv.e(o)) {
                    this.fBv = h.beg().P(this.fBv.field_musicId, o[0], o[1]);
                }
                if (d.this.oOZ != null && this.fBv != null) {
                    d.this.oOZ.a(this.fBv, o);
                }
            }
        }
    }

    public final void a(com.tencent.mm.au.a aVar, Bitmap bitmap) {
        x.i("MicroMsg.Music.MusicImageLoader", "putBitmapToCache %s", aVar.field_musicId);
        this.gBc.put(aVar.field_musicId, bitmap);
    }
}
