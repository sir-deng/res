package com.tencent.mm.ap.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Looper;
import android.widget.ImageView;
import com.tencent.mm.ap.a.a.b;
import com.tencent.mm.ap.a.a.c;
import com.tencent.mm.ap.a.b.g;
import com.tencent.mm.ap.a.c.d;
import com.tencent.mm.ap.a.c.e;
import com.tencent.mm.ap.a.c.i;
import com.tencent.mm.ap.a.c.j;
import com.tencent.mm.ap.a.c.l;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.concurrent.ExecutorService;

public final class a {
    private static a hEF = null;
    public b hEC;
    private b hED;
    private final i hEE = new g();

    public static synchronized a PN() {
        a aVar;
        synchronized (a.class) {
            if (hEF == null) {
                hEF = new a(ad.getContext());
            }
            aVar = hEF;
        }
        return aVar;
    }

    public a(Context context) {
        a(b.bl(context));
    }

    public a(b bVar) {
        a(bVar);
    }

    private synchronized void a(b bVar) {
        if (bVar == null) {
            throw new IllegalArgumentException("[cpan] image loader configuration is null.");
        } else if (this.hED == null) {
            this.hEC = new b(bVar);
            this.hED = bVar;
        } else {
            x.w("MicroMsg.imageloader.ImageLoader", "[cpan] image loader had init.");
        }
    }

    public final void a(String str, ImageView imageView) {
        a(str, imageView, null, null, null, null, null, null, null);
    }

    public final void a(String str, ImageView imageView, com.tencent.mm.ap.a.c.g gVar) {
        a(str, imageView, null, null, null, gVar, null, null, null);
    }

    public final void a(String str, ImageView imageView, c cVar, com.tencent.mm.ap.a.c.g gVar) {
        a(str, imageView, cVar, null, null, gVar, null, null, null);
    }

    public final void a(String str, ImageView imageView, c cVar, i iVar, com.tencent.mm.ap.a.c.g gVar) {
        a(str, imageView, cVar, iVar, null, gVar, null, null, null);
    }

    public final void a(String str, ImageView imageView, c cVar) {
        a(str, imageView, cVar, null, null, null, null, null, null);
    }

    public final void a(String str, ImageView imageView, c cVar, e eVar, d dVar, l lVar) {
        a(str, imageView, cVar, null, null, null, eVar, dVar, lVar);
    }

    public final void a(String str, ImageView imageView, c cVar, i iVar) {
        a(str, imageView, cVar, iVar, null, null, null, null, null);
    }

    public final void a(String str, ImageView imageView, c cVar, i iVar, j jVar, com.tencent.mm.ap.a.c.g gVar, e eVar, d dVar, l lVar) {
        c cVar2;
        i iVar2;
        if (cVar == null) {
            cVar2 = this.hED.hEY;
        } else {
            cVar2 = cVar;
        }
        if (iVar == null) {
            iVar2 = this.hEE;
        } else {
            iVar2 = iVar;
        }
        c cVar3 = new c(imageView, str);
        if (imageView == null || cVar2 == null) {
            x.w("MicroMsg.imageloader.ImageLoader", "[cpan] should show default background view or options is null.");
        } else {
            Object obj = (cVar2.hFE > 0 || cVar2.hFF != null) ? 1 : null;
            if (obj == null) {
                imageView.setBackgroundDrawable(null);
            } else if (cVar2.hFE == 0) {
                imageView.setBackgroundDrawable(cVar2.hFE != 0 ? this.hED.hEV.getDrawable(cVar2.hFE) : cVar2.hFF);
            } else {
                imageView.setBackgroundResource(cVar2.hFE);
            }
        }
        if (bi.oN(str)) {
            x.w("MicroMsg.imageloader.ImageLoader", "[cpan load image url is null.]");
            a(imageView, cVar2);
            this.hEC.a(cVar3);
            iVar2.a(str, null, cVar2.hFO);
            return;
        }
        ag agVar = cVar2.handler;
        if (agVar == null || Looper.myLooper() == Looper.getMainLooper()) {
            agVar = new ag();
        }
        Runnable bVar = new com.tencent.mm.ap.a.f.b(str, cVar3, agVar, cVar2, iVar2, jVar, this.hEC, gVar, eVar, dVar, lVar);
        Bitmap lC = this.hEC.lC(bVar.lH(str));
        if (lC == null || lC.isRecycled()) {
            if (imageView != null) {
                a(imageView, cVar2);
            }
            if (bVar.hEY.hFm || !this.hEC.hEH.vh()) {
                Object obj2;
                b bVar2;
                com.tencent.mm.ap.a.f.b bVar3;
                boolean z;
                b bVar4 = this.hEC;
                if (!bi.oN(str)) {
                    String str2 = (String) bVar4.hEJ.get(Integer.valueOf(cVar3.PO()));
                    if (bi.oN(str2) || !str.equals(str2)) {
                        bVar4.hEJ.put(Integer.valueOf(cVar3.PO()), str);
                        obj2 = 1;
                        if (obj2 != null) {
                            bVar2 = this.hEC;
                            if (!(bVar2.hEK == null || bVar.hFV == null)) {
                                bVar3 = (com.tencent.mm.ap.a.f.b) bVar2.hEK.get(Integer.valueOf(bVar.hFV.PO()));
                                if (!(bVar3 == null || bVar3.hFV == null || bVar.hFV.PO() != bVar3.hFV.PO())) {
                                    bVar2.hEH.remove(bVar3);
                                    x.d("MicroMsg.imageloader.ImageLoaderManager", "remove taks url:%s", bVar3.url);
                                }
                                bVar2.hEK.put(Integer.valueOf(bVar.hFV.PO()), bVar);
                            }
                            bVar2 = this.hEC;
                            z = cVar2.hFk;
                            if (((ExecutorService) bVar2.hEG.hFg).isShutdown()) {
                                bVar2.hEH = com.tencent.mm.ap.a.a.a.bb(bVar2.hEG.hEW, bVar2.hEG.hEX);
                            }
                            bVar2.hEH.execute(bVar);
                            if (z && com.tencent.mm.ap.a.g.b.PT()) {
                                bVar2.hEI.execute(new com.tencent.mm.ap.a.f.d());
                                return;
                            }
                            return;
                        }
                        return;
                    }
                }
                obj2 = null;
                if (obj2 != null) {
                    bVar2 = this.hEC;
                    bVar3 = (com.tencent.mm.ap.a.f.b) bVar2.hEK.get(Integer.valueOf(bVar.hFV.PO()));
                    bVar2.hEH.remove(bVar3);
                    x.d("MicroMsg.imageloader.ImageLoaderManager", "remove taks url:%s", bVar3.url);
                    bVar2.hEK.put(Integer.valueOf(bVar.hFV.PO()), bVar);
                    bVar2 = this.hEC;
                    z = cVar2.hFk;
                    if (((ExecutorService) bVar2.hEG.hFg).isShutdown()) {
                        bVar2.hEH = com.tencent.mm.ap.a.a.a.bb(bVar2.hEG.hEW, bVar2.hEG.hEX);
                    }
                    bVar2.hEH.execute(bVar);
                    if (z) {
                        return;
                    }
                    return;
                }
                return;
            }
            return;
        }
        x.d("MicroMsg.imageloader.ImageLoader", "[cpan] load from cache. not need to load:%s", r5);
        if (cVar2.hFv) {
            lC = com.tencent.mm.sdk.platformtools.d.c(lC, cVar2.hFw);
        }
        if (imageView != null) {
            imageView.setImageBitmap(lC);
        }
        bVar.bn(0);
        if (gVar != null) {
            gVar.a(str, imageView, new com.tencent.mm.ap.a.d.b(lC));
        }
        this.hEC.a(cVar3);
    }

    public final void bp(int i) {
        x.d("MicroMsg.imageloader.ImageLoader", "[cpan] on scroll state changed :%d", Integer.valueOf(i));
        if (i == 0 || i == 1) {
            x.d("MicroMsg.imageloader.ImageLoader", "[cpan] resume");
            this.hEC.hEH.resume();
            return;
        }
        x.d("MicroMsg.imageloader.ImageLoader", "[cpan] pause");
        this.hEC.hEH.pause();
    }

    public final void detach() {
        if (this.hEC != null) {
            b bVar = this.hEC;
            if (bVar.hEG != null) {
                bVar.hEG.hEZ.clear();
                bVar.hEG.hFa.PR();
            }
        }
    }

    public final Bitmap lC(String str) {
        if (this.hEC != null) {
            return this.hEC.lC(str);
        }
        return null;
    }

    public final void i(String str, Bitmap bitmap) {
        if (this.hEC != null) {
            b bVar = this.hEC;
            if (bVar.hEG != null) {
                bVar.hEG.hEZ.c(str, bitmap);
            }
        }
    }

    private void a(ImageView imageView, c cVar) {
        if (imageView == null || cVar == null) {
            x.w("MicroMsg.imageloader.ImageLoader", "[cpan] should show default image view or options is null.");
            return;
        }
        Object obj = (cVar.hFA > 0 || cVar.hFB != null) ? 1 : null;
        if (obj != null) {
            if (cVar.hFA == 0) {
                imageView.setImageDrawable(cVar.hFA != 0 ? this.hED.hEV.getDrawable(cVar.hFA) : cVar.hFB);
            } else {
                imageView.setImageResource(cVar.hFA);
            }
        } else if (cVar.hFI) {
            imageView.setImageDrawable(null);
        }
    }

    public final void a(String str, c cVar, com.tencent.mm.ap.a.c.c cVar2) {
        this.hEC.hEH.execute(new com.tencent.mm.ap.a.f.a(str, cVar, this.hEC, cVar2));
    }
}
