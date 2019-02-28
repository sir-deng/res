package com.tencent.mm.cache;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.util.SparseArray;
import com.tencent.mm.s.d;
import com.tencent.mm.s.d.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Stack;

public final class g implements d<d> {
    private Stack<d> gDc;
    private Stack<d> gDd;
    public int gDf;
    public SparseArray<String> gDk;
    public HashMap<String, Bitmap> gDl;

    /* renamed from: com.tencent.mm.cache.g$1 */
    class AnonymousClass1 implements Runnable {
        final /* synthetic */ Bitmap gDm;
        final /* synthetic */ String gDn;

        public AnonymousClass1(Bitmap bitmap, String str) {
            this.gDm = bitmap;
            this.gDn = str;
        }

        public final void run() {
            try {
                com.tencent.mm.sdk.platformtools.d.a(this.gDm, 50, CompressFormat.PNG, this.gDn, true);
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.MosaicCache", e, "", new Object[0]);
            }
        }
    }

    public final /* synthetic */ void add(Object obj) {
        a((d) obj);
    }

    public final /* synthetic */ Object pop() {
        if (this.gDc.size() > 0) {
            return (d) this.gDc.pop();
        }
        x.e("MicroMsg.MosaicCache", "[pop]");
        return null;
    }

    public final void onCreate() {
        x.i("MicroMsg.MosaicCache", "[onCreate]");
        this.gDc = new Stack();
        this.gDk = new SparseArray();
        this.gDl = new HashMap();
    }

    public final void onDestroy() {
        Iterator it;
        if (this.gDc != null) {
            it = this.gDc.iterator();
            while (it.hasNext()) {
                it.next();
                d.clear();
            }
            this.gDc.clear();
        }
        if (this.gDd != null) {
            it = this.gDd.iterator();
            while (it.hasNext()) {
                it.next();
                d.clear();
            }
            this.gDd.clear();
        }
        this.gDk.clear();
        for (Entry value : this.gDl.entrySet()) {
            Bitmap bitmap = (Bitmap) value.getValue();
            if (!(bitmap == null || bitmap.isRecycled())) {
                bitmap.recycle();
            }
        }
        this.gDl.clear();
    }

    public final void ba(boolean z) {
        x.i("MicroMsg.MosaicCache", "[onSave] size:%s", Integer.valueOf(this.gDc.size()));
        if (this.gDd != null) {
            this.gDd.clear();
        }
        this.gDd = (Stack) this.gDc.clone();
        if (z) {
            this.gDc.clear();
        }
    }

    public final void xC() {
        x.i("MicroMsg.MosaicCache", "[onRestore] size:%s", Integer.valueOf(this.gDc.size()));
        this.gDc.clear();
        if (this.gDd != null) {
            x.i("MicroMsg.MosaicCache", "[onRestore] %s", Integer.valueOf(this.gDd.size()));
            this.gDc.addAll(this.gDd);
        }
    }

    public final void a(Canvas canvas, boolean z) {
        if (!z) {
            d dVar = (this.gDc == null || this.gDc.size() <= 0) ? null : (d) this.gDc.peek();
            if (dVar != null && dVar.fjH == a.gPI) {
                dVar.draw(canvas);
            }
        }
    }

    public final void c(Canvas canvas) {
        Bitmap xJ = xJ();
        if (xJ != null && !xJ.isRecycled()) {
            canvas.drawBitmap(xJ, 0.0f, 0.0f, null);
        }
    }

    public final Bitmap xJ() {
        String str = (String) this.gDk.get(bb(true));
        if (bi.oN(str)) {
            x.w("MicroMsg.MosaicCache", "[getCacheFromLocal] path is null");
            return null;
        }
        Bitmap bitmap;
        x.i("MicroMsg.MosaicCache", "[getCacheFromLocal] path:%s size:%s", str, Integer.valueOf(bb(true)));
        if (this.gDl.containsKey(str)) {
            bitmap = (Bitmap) this.gDl.get(str);
        } else {
            bitmap = null;
        }
        if (bitmap == null || bitmap.isRecycled()) {
            x.i("MicroMsg.MosaicCache", "");
            bitmap = com.tencent.mm.sdk.platformtools.d.Vs(str);
            x.i("MicroMsg.MosaicCache", "[getCacheFromLocal] get from local!");
        }
        if (bitmap == null) {
            x.e("MicroMsg.MosaicCache", "[getCacheFromLocal] null == bitmap path:%s", str);
            return null;
        }
        Bitmap copy = bitmap.copy(Config.ARGB_8888, true);
        bitmap.recycle();
        return copy;
    }

    public final void a(d dVar) {
        if (this.gDc != null) {
            this.gDc.push(dVar);
        }
    }

    public final int bb(boolean z) {
        if (z) {
            if (this.gDc != null) {
                return this.gDc.size();
            }
            return 0;
        } else if (this.gDd != null) {
            return this.gDd.size();
        } else {
            return 0;
        }
    }

    public final void uQ() {
        this.gDf++;
    }
}
