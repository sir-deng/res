package com.tencent.mm.plugin.gallery.ui;

import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.SparseArray;
import android.util.SparseIntArray;
import com.tencent.mm.a.f;
import com.tencent.mm.a.f.a;
import com.tencent.mm.a.f.b;
import com.tencent.mm.plugin.gallery.model.j;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.MultiTouchImageView;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.LinkedList;

final class d {
    private at hrM = new at(1, "album-image-gallery-lazy-loader");
    SparseArray<WeakReference<MultiTouchImageView>> mZl = new SparseArray();
    HashMap<String, Integer> mZm = new HashMap();
    SparseArray<String> mZn = new SparseArray();
    SparseArray<Bitmap> mZo = new SparseArray();
    protected f<String, Bitmap> mZp = new f(5, new b<String, Bitmap>() {
        public final /* synthetic */ void m(Object obj, Object obj2) {
            Bitmap bitmap = (Bitmap) obj2;
            if (bitmap != null && !bitmap.isRecycled() && d.this.mZq.indexOfKey(bitmap.hashCode()) < 0) {
                bitmap.recycle();
            }
        }
    });
    protected SparseIntArray mZq = new SparseIntArray();
    c mZr;
    boolean mZs = false;
    LinkedList<String> tj = new LinkedList();
    private int yi = 0;

    public d(c cVar) {
        this.mZr = cVar;
    }

    final void aPa() {
        this.mZp.a(new a<String, Bitmap>() {
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

    final boolean aPb() {
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
            MultiTouchImageView multiTouchImageView = (MultiTouchImageView) ((WeakReference) this.mZl.get(i)).get();
            String str = (String) this.mZn.get(i);
            if (!(bitmap == null || multiTouchImageView == null)) {
                int hashCode = bitmap.hashCode();
                int indexOfValue = this.mZq.indexOfValue(i);
                if (indexOfValue >= 0) {
                    this.mZq.removeAt(indexOfValue);
                }
                this.mZq.put(hashCode, i);
            }
            this.mZr.mYU.remove(str);
            if (!(bitmap == null || multiTouchImageView == null)) {
                c.a(multiTouchImageView, bitmap);
            }
            qR(i);
        }
    }

    final void aPc() {
        if (!this.mZs && this.tj.size() != 0) {
            final String str = (String) this.tj.removeLast();
            if (this.mZm.containsKey(str)) {
                this.mZs = true;
                this.hrM.c(new at.a() {
                    private Bitmap mZu = null;

                    public final boolean JI() {
                        d.this.mZs = false;
                        if (d.this.mZm.containsKey(str)) {
                            int intValue = ((Integer) d.this.mZm.get(str)).intValue();
                            if (d.this.aPb()) {
                                d.this.a(intValue, this.mZu);
                            } else {
                                d.this.mZo.put(intValue, this.mZu);
                            }
                        }
                        d.this.mZp.l(str, this.mZu);
                        this.mZu = null;
                        d.this.aPc();
                        return false;
                    }

                    public final boolean JH() {
                        if (d.this.mZr == null || TextUtils.isEmpty(str)) {
                            return false;
                        }
                        String str = str;
                        long Wz = bi.Wz();
                        Bitmap Ca = j.Ca(str);
                        x.v("MicroMsg.ImageAdapter", "test decode: %d filePath:%s", Long.valueOf(bi.bB(Wz)), str);
                        this.mZu = Ca;
                        return true;
                    }
                });
            }
        }
    }
}
