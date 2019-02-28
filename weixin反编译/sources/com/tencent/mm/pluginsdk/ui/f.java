package com.tencent.mm.pluginsdk.ui;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import com.tencent.mm.R;
import com.tencent.mm.ac.d;
import com.tencent.mm.ac.e;
import com.tencent.mm.ac.n;
import com.tencent.mm.af.m;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.q;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.y.as;
import com.tencent.mm.y.c;

public final class f {
    private static final Drawable opr = new ColorDrawable();
    private Activity activity;
    private String iSZ;
    public q opq;
    private GetHdHeadImageGalleryView ops;
    private e qnt;
    private String username;
    private String vqx;
    private b vqy;
    private int vqz;

    public enum a {
        ;

        public static int[] caO() {
            return (int[]) vqF.clone();
        }

        static {
            vqC = 1;
            vqD = 2;
            vqE = 3;
            vqF = new int[]{vqC, vqD, vqE};
        }
    }

    /* renamed from: com.tencent.mm.pluginsdk.ui.f$2 */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] vqB = new int[a.caO().length];

        static {
            try {
                vqB[a.vqC - 1] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                vqB[a.vqD - 1] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                vqB[a.vqE - 1] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    public interface b {
    }

    public f(Activity activity, String str) {
        this(activity, str, null);
    }

    public f(Activity activity, String str, String str2) {
        this(activity, str, str2, a.vqC);
    }

    public f(Activity activity, String str, String str2, int i) {
        this(activity, str, str2, i, (byte) 0);
    }

    private f(Activity activity, String str, String str2, int i, byte b) {
        this.vqx = null;
        this.iSZ = null;
        this.activity = activity;
        this.username = str;
        this.iSZ = str2;
        this.vqy = null;
        this.vqz = i;
    }

    public final void caN() {
        View inflate = LayoutInflater.from(this.activity).inflate(R.i.dlA, null);
        this.opq = new q(inflate, -1, -1);
        switch (AnonymousClass2.vqB[this.vqz - 1]) {
            case 1:
                this.opq.setAnimationStyle(R.m.eZh);
                break;
            case 2:
                this.opq.setAnimationStyle(R.m.eZi);
                break;
            case 3:
                this.opq.setAnimationStyle(R.m.eZg);
                break;
        }
        this.opq.setFocusable(true);
        this.opq.setOutsideTouchable(true);
        this.opq.setBackgroundDrawable(opr);
        this.opq.showAtLocation(this.activity.getWindow().getDecorView(), 49, 0, 0);
        this.ops = (GetHdHeadImageGalleryView) inflate.findViewById(R.h.ckv);
        this.ops.vqp = this.opq;
        this.ops.username = this.username;
        as.Hm();
        if (c.isSDCardAvailable()) {
            Bitmap d = !bi.oN(this.iSZ) ? m.d(this.username, this.iSZ, R.g.bEl) : com.tencent.mm.ac.b.a(this.username, true, -1);
            if (d == null) {
                d = BitmapFactory.decodeResource(this.activity.getResources(), R.g.bBC);
            }
            if (d == null || d.isRecycled()) {
                x.i("MicroMsg.GetHdHeadImg", "The avatar of %s is not in the cache, use default avatar", this.username);
            } else {
                x.i("MicroMsg.GetHdHeadImg", "The avatar of %s is in the cache", this.username);
                this.ops.setThumbImage(d);
            }
            if (!bi.oN(this.vqx)) {
                this.username = this.vqx;
            }
            n.JF();
            Bitmap jh = d.jh(this.username);
            if (jh == null || jh.isRecycled()) {
                this.qnt = new e();
                this.qnt.a(this.username, new com.tencent.mm.ac.e.b() {
                    public final int ba(int i, int i2) {
                        f.this.qnt.JJ();
                        x.i("MicroMsg.GetHdHeadImg", "onSceneEnd: errType=%d, errCode=%d", Integer.valueOf(i), Integer.valueOf(i2));
                        if (i == 0 && i2 == 0) {
                            n.JF();
                            Bitmap jh = d.jh(f.this.username);
                            if (jh != null) {
                                f fVar = f.this;
                                n.JF();
                                fVar.d(jh, d.x(f.this.username, true));
                            } else {
                                f.this.d(d, null);
                            }
                            if (f.this.vqy != null) {
                                f.this.vqy;
                                f.this.username;
                            }
                        } else {
                            f.this.d(d, null);
                            if (f.this.vqy != null) {
                                f.this.vqy;
                                f.this.username;
                            }
                        }
                        return 0;
                    }
                });
                return;
            }
            x.i("MicroMsg.GetHdHeadImg", "The HDAvatar of %s is already exists", this.username);
            n.JF();
            d(jh, d.x(this.username, true));
            return;
        }
        u.fJ(this.activity);
        d(n.JF().bg(this.activity), null);
    }

    private void d(Bitmap bitmap, String str) {
        try {
            Bitmap createBitmap;
            if (bitmap.getWidth() < 480) {
                float width = (float) (480 / bitmap.getWidth());
                Matrix matrix = new Matrix();
                matrix.postScale(width, width);
                createBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
            } else {
                createBitmap = bitmap;
            }
            x.d("MicroMsg.GetHdHeadImg", "dkhdbm old[%d %d] new[%d %d]", Integer.valueOf(bitmap.getWidth()), Integer.valueOf(bitmap.getHeight()), Integer.valueOf(createBitmap.getWidth()), Integer.valueOf(createBitmap.getHeight()));
            this.ops.N(createBitmap);
            this.ops.qnu = str;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.GetHdHeadImg", e, "", new Object[0]);
        }
    }
}
