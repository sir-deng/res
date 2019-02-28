package com.tencent.mm.plugin.ipcall.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Looper;
import android.widget.ImageView;
import com.tencent.mm.ac.b;
import com.tencent.mm.ac.n;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.at.a;
import com.tencent.mm.sdk.platformtools.bi;
import java.lang.ref.WeakReference;

public final class d {
    Context context;
    private ag hbP = new ag(Looper.getMainLooper());
    at nNJ = new at(5, "IPCallAddressAvatarLoader", 1, Looper.getMainLooper());
    aa<String, WeakReference<Bitmap>> nNK = new aa(50);

    /* renamed from: com.tencent.mm.plugin.ipcall.ui.d$2 */
    class AnonymousClass2 implements a {
        final /* synthetic */ String gJY;
        final /* synthetic */ String gKE;
        final /* synthetic */ ImageView jpk;

        AnonymousClass2(String str, ImageView imageView, String str2) {
            this.gKE = str;
            this.jpk = imageView;
            this.gJY = str2;
        }

        public final boolean JH() {
            Bitmap a = b.a(this.gKE, false, -1);
            if (a == null) {
                n.JF();
                a = com.tencent.mm.ac.d.jg(this.gKE);
            }
            d.a(d.this, this.jpk, this.gJY, a);
            return true;
        }

        public final boolean JI() {
            return false;
        }
    }

    static /* synthetic */ void a(d dVar, final ImageView imageView, final String str, final Bitmap bitmap) {
        if (bitmap != null) {
            dVar.nNK.put(str, new WeakReference(bitmap));
            dVar.hbP.post(new Runnable() {
                public final void run() {
                    if (imageView.getTag() != null && imageView.getTag().equals(str) && bitmap != null && !bitmap.isRecycled()) {
                        imageView.setImageBitmap(bitmap);
                    }
                }
            });
        }
    }

    public d(Context context) {
        this.context = context;
    }

    public final void a(String str, String str2, ImageView imageView) {
        if (!bi.oN(str) && !bi.oN(str2) && imageView != null) {
            final String de = de(str, str2);
            imageView.setTag(de);
            if (!d(de(str, str2), imageView)) {
                final String str3 = str;
                final ImageView imageView2 = imageView;
                final String str4 = str2;
                this.nNJ.c(new a() {
                    private boolean nNL = false;

                    public final boolean JH() {
                        Bitmap an = com.tencent.mm.plugin.ipcall.b.a.an(d.this.context, str3);
                        if (an != null) {
                            d.this.nNK.put(de, new WeakReference(an));
                            this.nNL = true;
                            d.a(d.this, imageView2, de, an);
                        }
                        return true;
                    }

                    public final boolean JI() {
                        if (!this.nNL) {
                            d dVar = d.this;
                            String str = str3;
                            String str2 = str4;
                            dVar.nNJ.c(new AnonymousClass2(str2, imageView2, d.de(str, str2)));
                        }
                        return true;
                    }
                });
            }
        }
    }

    public final void b(final String str, final ImageView imageView) {
        if (!bi.oN(str) && imageView != null) {
            final String Dv = Dv(str);
            imageView.setTag(Dv);
            if (!d(Dv(str), imageView)) {
                this.nNJ.c(new a() {
                    public final boolean JH() {
                        d.a(d.this, imageView, Dv, com.tencent.mm.plugin.ipcall.b.a.an(d.this.context, str));
                        return true;
                    }

                    public final boolean JI() {
                        return true;
                    }
                });
            }
        }
    }

    public final void c(final String str, final ImageView imageView) {
        if (!bi.oN(str) && imageView != null) {
            final String Du = Du(str);
            imageView.setTag(Du);
            if (!d(Du(str), imageView)) {
                this.nNJ.c(new a() {
                    public final boolean JH() {
                        Bitmap a = b.a(str, false, -1);
                        if (a == null) {
                            n.JF();
                            a = com.tencent.mm.ac.d.jg(str);
                        }
                        d.a(d.this, imageView, Du, a);
                        return true;
                    }

                    public final boolean JI() {
                        return false;
                    }
                });
            }
        }
    }

    private boolean d(String str, ImageView imageView) {
        WeakReference weakReference = (WeakReference) this.nNK.get(str);
        if (weakReference != null) {
            Bitmap bitmap = (Bitmap) weakReference.get();
            if (!(bitmap == null || imageView.getTag() == null || !imageView.getTag().toString().equals(str))) {
                if (!(bitmap == null || bitmap.isRecycled())) {
                    imageView.setImageBitmap(bitmap);
                }
                return true;
            }
        }
        return false;
    }

    private static String Du(String str) {
        return str + "@username";
    }

    private static String Dv(String str) {
        return str + "@contactId";
    }

    public static String de(String str, String str2) {
        return str + "@" + str2 + "@contactId@username";
    }
}
