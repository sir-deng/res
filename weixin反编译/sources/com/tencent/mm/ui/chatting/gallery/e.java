package com.tencent.mm.ui.chatting.gallery;

import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.widget.ImageView;
import com.tencent.mm.a.f;
import com.tencent.mm.a.f.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.as;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

final class e implements android.support.v4.view.ViewPager.e {
    private static int mScreenHeight = 0;
    private static int mScreenWidth = 0;
    private static long yNm = 0;
    private ag hbP = new ag();
    private at hrM = new at(1, "chatting-image-gallery-lazy-loader");
    SparseArray<WeakReference<ImageView>> mZl = new SparseArray();
    HashMap<String, Integer> mZm = new HashMap();
    SparseArray<String> mZn = new SparseArray();
    SparseArray<Bitmap> mZo = new SparseArray();
    protected f<String, Bitmap> mZp = new f(5, new b<String, Bitmap>() {
        public final /* synthetic */ void m(Object obj, Object obj2) {
            Bitmap bitmap = (Bitmap) obj2;
            x.i("MicroMsg.ImageGalleryLazyLoader", "preRemoveCallback %s", (String) obj);
            if (bitmap != null && !bitmap.isRecycled() && e.this.mZq.indexOfKey(bitmap.hashCode()) < 0) {
                if (e.this.yNn.contains(Integer.valueOf(bitmap.hashCode()))) {
                    e.this.yNn.remove(Integer.valueOf(bitmap.hashCode()));
                    return;
                }
                x.i("MicroMsg.ImageGalleryLazyLoader", "recycle bitmap:%s", bitmap.toString());
                bitmap.recycle();
            }
        }
    });
    protected SparseIntArray mZq = new SparseIntArray();
    private boolean mZs = false;
    private int mZw = -1;
    LinkedList<String> tj = new LinkedList();
    a yNk;
    protected f<Integer, Bitmap> yNl = new f(40, new b<Integer, Bitmap>() {
        public final /* synthetic */ void m(Object obj, Object obj2) {
            Bitmap bitmap = (Bitmap) obj2;
            if (bitmap != null && !bitmap.isRecycled()) {
                x.i("MicroMsg.ImageGalleryLazyLoader", "recycle bitmap:%s", bitmap.toString());
                bitmap.recycle();
            }
        }
    });
    private LinkedList<Integer> yNn = new LinkedList();
    private int yi = 0;

    public interface a {
        Bitmap Gs(int i);

        Bitmap ZU(String str);

        void c(ImageView imageView, Bitmap bitmap);
    }

    protected final void u(String str, Bitmap bitmap) {
        int i;
        if (bitmap != null) {
            long width = ((long) bitmap.getWidth()) * ((long) bitmap.getHeight());
            if (mScreenHeight == 0 || mScreenWidth == 0) {
                mScreenWidth = ad.getContext().getResources().getDisplayMetrics().widthPixels;
                mScreenHeight = ad.getContext().getResources().getDisplayMetrics().heightPixels;
                yNm = ((long) mScreenWidth) * yNm;
            }
            if (width > yNm * 2) {
                i = 1;
                if (i == 0) {
                    x.i("MicroMsg.ImageGalleryLazyLoader", "file %s too big to cache");
                }
                this.mZp.l(str, bitmap);
                if (a.yNt.mZp.bu(str)) {
                    x.i("MicroMsg.ImageGalleryLazyLoader", "update origCache and preload cache");
                    try {
                        a.yNt.mZp.l(str, bitmap);
                        return;
                    } catch (Throwable e) {
                        x.printErrStackTrace("MicroMsg.ImageGalleryLazyLoader", e, "update preload cache failed", new Object[0]);
                        return;
                    }
                }
                return;
            }
        }
        i = 0;
        if (i == 0) {
            this.mZp.l(str, bitmap);
            if (a.yNt.mZp.bu(str)) {
                x.i("MicroMsg.ImageGalleryLazyLoader", "update origCache and preload cache");
                a.yNt.mZp.l(str, bitmap);
                return;
            }
            return;
        }
        x.i("MicroMsg.ImageGalleryLazyLoader", "file %s too big to cache");
    }

    public final void ax(Map<String, Bitmap> map) {
        for (String str : map.keySet()) {
            Bitmap bitmap = (Bitmap) map.get(str);
            if (bitmap != null) {
                this.mZp.put(str, bitmap);
                this.yNn.push(Integer.valueOf(bitmap.hashCode()));
                x.i("MicroMsg.ImageGalleryLazyLoader", "we got one cache from preload : %s %s", str, Integer.valueOf(bitmap.hashCode()));
            } else {
                x.e("MicroMsg.ImageGalleryLazyLoader", "we got one null cache from preload");
            }
        }
    }

    public e(a aVar) {
        this.yNk = aVar;
    }

    final void aPa() {
        this.yNl.a(new com.tencent.mm.a.f.a<Integer, Bitmap>() {
        });
        this.mZp.a(new com.tencent.mm.a.f.a<String, Bitmap>() {
        });
    }

    public final void af(int i) {
        int i2 = 0;
        this.yi = i;
        if (aPb()) {
            int[] iArr = new int[this.mZo.size()];
            for (int i3 = 0; i3 < iArr.length; i3++) {
                iArr[i3] = this.mZo.keyAt(i3);
            }
            while (i2 < iArr.length) {
                int i4 = iArr[i2];
                a(i4, (Bitmap) this.mZo.get(i4));
                i2++;
            }
        }
    }

    public final void ae(int i) {
        if (((d) this.yNk).yLG.yLI.adD) {
            if (this.mZw == -1) {
                int i2 = 0;
                while (true) {
                    if (i2 != 0) {
                        if (i + i2 > i + 3 && i - i2 < Math.max(i - 3, 0)) {
                            break;
                        }
                        if (i + i2 <= i + 3) {
                            qS(i + i2);
                        }
                        if (i - i2 >= Math.max(i - 3, 0)) {
                            qS(i - i2);
                        }
                    } else {
                        qS(i);
                    }
                    i2++;
                }
            } else if (this.mZw > i) {
                qS(Math.max(i - 3, 0));
            } else if (this.mZw < i) {
                qS(i + 3);
            }
            this.mZw = i;
        }
    }

    private void qS(final int i) {
        if (!this.yNl.bu(Integer.valueOf(i))) {
            as.Dt().g(new Runnable() {
                public final void run() {
                    if (e.this.yNk == null) {
                        x.e("MicroMsg.ImageGalleryLazyLoader", "loader is null!");
                        return;
                    }
                    final Bitmap Gs = e.this.yNk.Gs(i);
                    if (Gs != null) {
                        e.this.hbP.post(new Runnable() {
                            public final void run() {
                                e.this.yNl.put(Integer.valueOf(i), Gs);
                            }
                        });
                    }
                }
            }, 300);
        }
    }

    private boolean aPb() {
        return this.yi == 0;
    }

    final void qR(int i) {
        if (this.mZn.get(i) != null) {
            String str = (String) this.mZn.get(i);
            this.mZl.remove(i);
            this.mZn.remove(i);
            this.mZm.remove(str);
            this.mZo.remove(i);
        }
    }

    private void a(int i, Bitmap bitmap) {
        if (this.mZl.get(i) != null) {
            ImageView imageView = (ImageView) ((WeakReference) this.mZl.get(i)).get();
            this.mZn.get(i);
            this.yNk.c(imageView, bitmap);
            qR(i);
        }
    }

    public final boolean b(ImageView imageView, int i) {
        x.i("MicroMsg.ImageGalleryLazyLoader", "loadThumb position %s", Integer.valueOf(i));
        Bitmap bitmap = (Bitmap) this.yNl.get(Integer.valueOf(i));
        if (bitmap == null || bitmap.isRecycled()) {
            return false;
        }
        this.yNk.c(imageView, bitmap);
        return true;
    }

    final void aPc() {
        if (!this.mZs && this.tj.size() != 0) {
            final String str = (String) this.tj.removeLast();
            if (this.mZm.containsKey(str)) {
                this.mZs = true;
                this.hrM.c(new com.tencent.mm.sdk.platformtools.at.a() {
                    private Bitmap mZu = null;

                    public final boolean JI() {
                        int intValue;
                        e.this.mZs = false;
                        if (e.this.mZm.containsKey(str)) {
                            intValue = ((Integer) e.this.mZm.get(str)).intValue();
                            if (e.this.aPb()) {
                                e.this.a(intValue, this.mZu);
                            } else {
                                e.this.mZo.put(intValue, this.mZu);
                            }
                        }
                        e.this.u(str, this.mZu);
                        String str = "MicroMsg.ImageGalleryLazyLoader";
                        String str2 = "bmp size : %s";
                        Object[] objArr = new Object[1];
                        Bitmap bitmap = this.mZu;
                        if (bitmap == null || bitmap.isRecycled()) {
                            intValue = 0;
                        } else {
                            intValue = VERSION.SDK_INT >= 12 ? bitmap.getByteCount() : bitmap.getRowBytes() * bitmap.getHeight();
                            if (intValue < 0) {
                                throw new IllegalStateException("Negative size: " + bitmap);
                            }
                        }
                        objArr[0] = Integer.valueOf(intValue);
                        x.i(str, str2, objArr);
                        this.mZu = null;
                        e.this.aPc();
                        return false;
                    }

                    public final boolean JH() {
                        if (e.this.yNk == null || TextUtils.isEmpty(str)) {
                            return false;
                        }
                        try {
                            this.mZu = e.this.yNk.ZU(str);
                            return true;
                        } catch (Exception e) {
                            x.w("MicroMsg.ImageGalleryLazyLoader", "try to load Bmp fail: %s", e.getMessage());
                            this.mZu = null;
                            return false;
                        }
                    }
                });
            }
        }
    }

    public final void a(int i, float f, int i2) {
    }
}
