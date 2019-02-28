package com.tencent.mm.plugin.mmsight.segment;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.HandlerThread;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.k;
import android.support.v7.widget.RecyclerView.t;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mm.memory.o;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.locks.Lock;

public class RecyclerThumbSeekBar extends RelativeLayout implements c {
    public int hQf = -1;
    private int hcY;
    private int hcZ;
    private RecyclerView jTh;
    private int oEb;
    public com.tencent.mm.plugin.mmsight.segment.c.a oEc;
    public com.tencent.mm.plugin.mmsight.segment.c.b oEd;
    private c oEe;
    private n oEf;
    private int oEg;
    private com.tencent.mm.plugin.mmsight.segment.d.a oEh = new com.tencent.mm.plugin.mmsight.segment.d.a(new Callable<d>() {
        public final /* synthetic */ Object call() {
            d fFmpegSightJNIThumbFetcher = new FFmpegSightJNIThumbFetcher();
            fFmpegSightJNIThumbFetcher.init(RecyclerThumbSeekBar.this.path, RecyclerThumbSeekBar.this.oEb, RecyclerThumbSeekBar.this.hcZ, RecyclerThumbSeekBar.this.hcY);
            return fFmpegSightJNIThumbFetcher;
        }
    });
    private Runnable oEi = new Runnable() {
        public final void run() {
            if (RecyclerThumbSeekBar.this.getHeight() == 0 || RecyclerThumbSeekBar.this.getWidth() == 0) {
                RecyclerThumbSeekBar.this.post(RecyclerThumbSeekBar.this.oEi);
                return;
            }
            RecyclerThumbSeekBar.this.oEb = 1000;
            RecyclerThumbSeekBar.this.hcY = RecyclerThumbSeekBar.this.getHeight();
            RecyclerThumbSeekBar.this.hcZ = (RecyclerThumbSeekBar.this.getWidth() - (RecyclerThumbSeekBar.this.oEg * 2)) / 10;
            com.tencent.mm.sdk.f.e.post(new Runnable() {
                public final void run() {
                    int i;
                    try {
                        d bbI = RecyclerThumbSeekBar.this.oEh.bbI();
                        RecyclerThumbSeekBar.this.hQf = bbI.getDurationMs();
                        RecyclerThumbSeekBar.this.oEh.a(bbI);
                        i = 1;
                    } catch (Throwable e) {
                        x.printErrStackTrace("RecyclerThumbSeekBar", e, "Try to init fetcher error : %s", e.getMessage());
                        i = 0;
                    }
                    if (i == 0) {
                        RecyclerThumbSeekBar.this.bbR();
                        return;
                    }
                    if (RecyclerThumbSeekBar.this.hQf >= 10000) {
                        RecyclerThumbSeekBar.this.oEb = 1000;
                    } else if (RecyclerThumbSeekBar.this.hQf > 0) {
                        RecyclerThumbSeekBar.this.oEb = RecyclerThumbSeekBar.this.hQf / 10;
                    } else {
                        x.e("RecyclerThumbSeekBar", "RecyclerThumbSeekBar duration invalid %d", Integer.valueOf(RecyclerThumbSeekBar.this.hQf));
                        RecyclerThumbSeekBar.this.bbR();
                        return;
                    }
                    x.d("RecyclerThumbSeekBar", "duration %d interval %d", Integer.valueOf(RecyclerThumbSeekBar.this.hQf), Integer.valueOf(RecyclerThumbSeekBar.this.oEb));
                    ah.y(new Runnable() {
                        public final void run() {
                            try {
                                RecyclerThumbSeekBar.this.oEf.am(-1.0f);
                                RecyclerThumbSeekBar.this.oEe = new c(RecyclerThumbSeekBar.this, (byte) 0);
                                int e = RecyclerThumbSeekBar.e(RecyclerThumbSeekBar.this, 10000);
                                int e2 = RecyclerThumbSeekBar.e(RecyclerThumbSeekBar.this, 1000);
                                RecyclerThumbSeekBar.this.oEg = (RecyclerThumbSeekBar.this.getWidth() - e) / 2;
                                n k = RecyclerThumbSeekBar.this.oEf;
                                k.post(new com.tencent.mm.plugin.mmsight.segment.n.AnonymousClass1(e, RecyclerThumbSeekBar.this.oEg, e2));
                                x.i("RecyclerThumbSeekBar", "RecyclerThumbSeekBar.run(212) width %d", Integer.valueOf(RecyclerThumbSeekBar.this.getWidth()));
                                RecyclerThumbSeekBar.this.oEe.oEr = (RecyclerThumbSeekBar.this.getWidth() - RecyclerThumbSeekBar.this.oEg) - e;
                                RecyclerThumbSeekBar.this.oEe.oEq = RecyclerThumbSeekBar.this.oEg;
                                RecyclerThumbSeekBar.this.jTh.a(RecyclerThumbSeekBar.this.oEe);
                                x.d("RecyclerThumbSeekBar", "init segment thumb fetcher end, adapter.getItemCount() %d", Integer.valueOf(RecyclerThumbSeekBar.this.oEe.getItemCount()));
                                if (RecyclerThumbSeekBar.this.oEc != null) {
                                    RecyclerThumbSeekBar.this.oEc.gJ(false);
                                }
                            } catch (Throwable e3) {
                                x.printErrStackTrace("RecyclerThumbSeekBar", e3, "RecyclerThumbSeekBar notifySuccess error : %s", e3.getMessage());
                                if (RecyclerThumbSeekBar.this.oEc != null) {
                                    RecyclerThumbSeekBar.this.oEc.gJ(true);
                                }
                            }
                        }
                    });
                }
            }, "check duration of ");
        }
    };
    private k oEj = new k() {
        public final void e(RecyclerView recyclerView, int i) {
            if (i == 0 && RecyclerThumbSeekBar.this.oEd != null) {
                RecyclerThumbSeekBar.this.oEd.A(RecyclerThumbSeekBar.this.bbF(), RecyclerThumbSeekBar.this.bbG());
            }
        }
    };
    private com.tencent.mm.plugin.mmsight.segment.n.a oEk = new com.tencent.mm.plugin.mmsight.segment.n.a() {
        public final void bbS() {
            if (RecyclerThumbSeekBar.this.oEd != null && RecyclerThumbSeekBar.this.oEe != null) {
                com.tencent.mm.plugin.mmsight.segment.c.b o = RecyclerThumbSeekBar.this.oEd;
                RecyclerThumbSeekBar.this.bbF();
                RecyclerThumbSeekBar.this.bbG();
                o.bbH();
            }
        }

        public final void bbT() {
            if (RecyclerThumbSeekBar.this.oEd != null && RecyclerThumbSeekBar.this.oEe != null) {
                RecyclerThumbSeekBar.this.oEd.B(RecyclerThumbSeekBar.this.bbF(), RecyclerThumbSeekBar.this.bbG());
            }
        }

        public final void gK(boolean z) {
            if (!(RecyclerThumbSeekBar.this.oEd == null || RecyclerThumbSeekBar.this.oEe == null)) {
                RecyclerThumbSeekBar.this.oEd.C(RecyclerThumbSeekBar.this.bbF(), RecyclerThumbSeekBar.this.bbG());
            }
            if (z) {
                RecyclerThumbSeekBar.this.oEe.o(true, RecyclerThumbSeekBar.this.oEf.bbU());
            } else {
                RecyclerThumbSeekBar.this.oEe.o(false, RecyclerThumbSeekBar.this.oEf.getWidth() - RecyclerThumbSeekBar.this.oEf.bbV());
            }
        }
    };
    private String path;

    private class a implements Runnable {
        private Bitmap bitmap;
        private ImageView fwa;
        private b oEn;

        a(Bitmap bitmap, ImageView imageView, b bVar) {
            this.bitmap = bitmap;
            this.fwa = imageView;
            this.oEn = bVar;
        }

        public final void run() {
            boolean z = true;
            if (this.bitmap == null || this.bitmap.isRecycled()) {
                String str = "RecyclerThumbSeekBar";
                String str2 = "bitmap is null %b in DrawBitmapOnViewTask";
                Object[] objArr = new Object[1];
                if (this.bitmap != null) {
                    z = false;
                }
                objArr[0] = Boolean.valueOf(z);
                x.i(str, str2, objArr);
            } else if (this.oEn == null || this.oEn.hGJ || this.fwa == null) {
                x.i("RecyclerThumbSeekBar", "bitmap in DrawBitmapOnViewTask");
            } else {
                ImageView imageView = this.fwa;
                imageView.setTag(null);
                ObjectAnimator.ofInt(imageView, "imageAlpha", new int[]{50, 255}).setDuration(200).start();
                imageView.setImageBitmap(this.bitmap);
            }
        }
    }

    private class b implements Runnable {
        boolean hGJ = false;
        private ag handler;
        private WeakReference<ImageView> hlN;
        private Bitmap oEo;
        private int time;

        b(int i, ImageView imageView, Bitmap bitmap, ag agVar) {
            this.time = i;
            this.hlN = new WeakReference(imageView);
            this.handler = agVar;
            this.oEo = bitmap;
        }

        public final void run() {
            if (this.hGJ) {
                o.hbY.g(this.oEo);
            } else if (((ImageView) this.hlN.get()) == null) {
                o.hbY.g(this.oEo);
            } else {
                try {
                    d bbI = RecyclerThumbSeekBar.this.oEh.bbI();
                    if (this.oEo == null) {
                        this.oEo = o.hbY.a(new com.tencent.mm.memory.o.b(bbI.getScaledWidth(), bbI.getScaledHeight()));
                    }
                    bbI.reuseBitmap(this.oEo);
                    if (!this.hGJ) {
                        this.oEo = bbI.getFrameAtTime((long) this.time);
                    }
                    RecyclerThumbSeekBar.this.oEh.a(bbI);
                    if (this.oEo == null || this.hGJ || this.hlN.get() == null) {
                        o.hbY.g(this.oEo);
                    } else {
                        this.handler.post(new a(this.oEo, (ImageView) this.hlN.get(), this));
                    }
                } catch (Exception e) {
                    x.e("RecyclerThumbSeekBar", "get bitmap error " + e.getMessage());
                    o.hbY.g(this.oEo);
                }
            }
        }
    }

    private class d {
        ag handler = new ag();
        HandlerThread[] oEu = new HandlerThread[this.ozh];
        int oEv = 0;
        private BlockingDeque<b> oEw = new LinkedBlockingDeque();
        int ozh = 4;

        public d() {
            for (int i = 0; i < this.oEu.length; i++) {
                this.oEu[i] = com.tencent.mm.sdk.f.e.dc("RecyclerThumbSeekBar_SimpleImageLoader_" + i, -1);
                this.oEu[i].start();
            }
            this.oEv = 0;
        }
    }

    private class e extends t {
        ImageView fwa;

        e(View view, int i) {
            super(view);
            if (i == 0) {
                this.fwa = (ImageView) ((LinearLayout) view).getChildAt(0);
            }
        }
    }

    private class c extends android.support.v7.widget.RecyclerView.a<e> {
        d oEp;
        int oEq;
        int oEr;
        private View oEs;
        private View oEt;

        private c() {
            this.oEp = new d();
            this.oEq = RecyclerThumbSeekBar.this.oEg;
            this.oEr = RecyclerThumbSeekBar.this.oEg;
        }

        /* synthetic */ c(RecyclerThumbSeekBar recyclerThumbSeekBar, byte b) {
            this();
        }

        public final /* synthetic */ t a(ViewGroup viewGroup, int i) {
            View view;
            if (i == 1 || i == 2) {
                view = new View(RecyclerThumbSeekBar.this.getContext());
                if (i == 1) {
                    this.oEs = view;
                } else {
                    this.oEt = view;
                }
                return new e(view, 1);
            }
            View imageView = new ImageView(RecyclerThumbSeekBar.this.getContext());
            imageView.setScaleType(ScaleType.CENTER_CROP);
            imageView.setMinimumWidth(RecyclerThumbSeekBar.this.hcZ);
            imageView.setMinimumHeight(RecyclerThumbSeekBar.this.hcY);
            view = new LinearLayout(RecyclerThumbSeekBar.this.getContext());
            view.addView(imageView, RecyclerThumbSeekBar.this.hcZ, RecyclerThumbSeekBar.this.hcY);
            return new e(view, 0);
        }

        public final /* synthetic */ void a(t tVar, int i) {
            e eVar = (e) tVar;
            if (getItemViewType(i) == 1 || getItemViewType(i) == 2) {
                if (i == 0) {
                    eVar.VU.setMinimumWidth(this.oEq);
                } else {
                    eVar.VU.setMinimumWidth(this.oEr);
                }
                eVar.VU.setBackgroundColor(0);
                eVar.VU.setMinimumHeight(RecyclerThumbSeekBar.this.hcY);
            } else if (this.oEp != null) {
                d dVar = this.oEp;
                int b = RecyclerThumbSeekBar.this.oEb * (i - 1);
                ImageView imageView = eVar.fwa;
                if (imageView != null && b >= 0) {
                    x.i("RecyclerThumbSeekBar", "loadImageAsync() called with: time = [" + b + "], view = [" + imageView + "]");
                    Object tag = imageView.getTag();
                    b bVar = (tag == null || !(tag instanceof b)) ? null : (b) tag;
                    if (bVar == null || bVar.time != b) {
                        if (bVar != null) {
                            bVar.hGJ = true;
                        }
                        Bitmap bitmap = (imageView.getDrawable() == null || !(imageView.getDrawable() instanceof BitmapDrawable)) ? null : ((BitmapDrawable) imageView.getDrawable()).getBitmap();
                        imageView.setImageBitmap(null);
                        Runnable bVar2 = new b(b, imageView, bitmap, dVar.handler);
                        imageView.setTag(bVar2);
                        int i2 = dVar.oEv % dVar.ozh;
                        dVar.oEv++;
                        if (dVar.oEu[i2] != null) {
                            new ag(dVar.oEu[i2].getLooper()).post(bVar2);
                            return;
                        }
                        return;
                    }
                    x.i("RecyclerThumbSeekBar", "SimpleImageLoader.loadImageAsync time equals %d return directly", Integer.valueOf(b));
                }
            } else {
                x.e("RecyclerThumbSeekBar", "onBindViewHolder ImageLoader invoked after released.");
            }
        }

        public final int getItemViewType(int i) {
            if (i == 0) {
                return 1;
            }
            if (i == getItemCount() - 1) {
                return 2;
            }
            return 0;
        }

        public final void o(boolean z, int i) {
            if (z) {
                if (this.oEs != null) {
                    this.oEs.setMinimumWidth(i);
                }
                if (((LinearLayoutManager) RecyclerThumbSeekBar.this.jTh.TV).fa() == 0) {
                    RecyclerThumbSeekBar.this.jTh.scrollBy(i - this.oEq, 0);
                }
                this.oEq = i;
                return;
            }
            this.oEr = i;
            if (this.oEt != null) {
                this.oEt.setMinimumWidth(this.oEr);
            }
        }

        public final int getItemCount() {
            return RecyclerThumbSeekBar.this.hQf <= 0 ? 0 : Math.max(0, (int) Math.floor((double) (((float) RecyclerThumbSeekBar.this.hQf) / ((float) RecyclerThumbSeekBar.this.oEb)))) + 2;
        }
    }

    static /* synthetic */ int e(RecyclerThumbSeekBar recyclerThumbSeekBar, int i) {
        if (recyclerThumbSeekBar.oEe == null) {
            throw new IllegalStateException("recyclerAdapter is null");
        } else if (recyclerThumbSeekBar.hQf <= 0) {
            throw new IllegalStateException("durationMs <= 0");
        } else {
            recyclerThumbSeekBar.oEe.getItemCount();
            return (int) ((Math.min(Math.max(0.0f, ((float) i) / ((float) recyclerThumbSeekBar.hQf)), 1.0f) * ((float) recyclerThumbSeekBar.hcZ)) * ((float) (recyclerThumbSeekBar.oEe.getItemCount() - 2)));
        }
    }

    public RecyclerThumbSeekBar(Context context) {
        super(context);
        init();
    }

    public RecyclerThumbSeekBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public RecyclerThumbSeekBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private void init() {
        this.jTh = new RecyclerView(getContext());
        getContext();
        this.jTh.a(new LinearLayoutManager(0, false));
        this.jTh.Ub = true;
        int aa = com.tencent.mm.bu.a.aa(getContext(), com.tencent.mm.plugin.mmsight.segment.k.b.oDT);
        this.oEg = com.tencent.mm.bu.a.aa(getContext(), com.tencent.mm.plugin.mmsight.segment.k.b.oDS);
        addView(this.jTh, new LayoutParams(-1, aa));
        this.oEf = new n(getContext());
        addView(this.oEf, new LayoutParams(-1, -1));
        this.oEf.oEx = this.oEk;
        this.jTh.a(this.oEj);
    }

    public final void al(float f) {
        float f2 = 0.0f;
        n nVar = this.oEf;
        if (!(this.oEe == null || this.jTh == null)) {
            float itemCount = ((float) (this.oEe.getItemCount() - 2)) * f;
            int floor = (int) Math.floor((double) itemCount);
            itemCount -= (float) floor;
            t bi = this.jTh.bi(floor + 1);
            if (bi != null) {
                View view = bi.VU;
                f2 = ((((float) view.getWidth()) * itemCount) + ((float) view.getLeft())) / ((float) getWidth());
            }
        }
        nVar.am(f2);
    }

    public final void FR(String str) {
        if (bi.oN(str) || !FileOp.bO(str)) {
            bbR();
            return;
        }
        this.path = str;
        post(this.oEi);
    }

    public final int getDurationMs() {
        return this.hQf;
    }

    public final void gI(boolean z) {
        if (z) {
            this.oEf.oEz = true;
        } else {
            this.oEf.oEz = false;
        }
    }

    private void bbR() {
        ah.y(new Runnable() {
            public final void run() {
                if (RecyclerThumbSeekBar.this.oEc != null) {
                    RecyclerThumbSeekBar.this.oEc.gJ(true);
                }
            }
        });
    }

    public final void release() {
        Lock lock = null;
        this.hQf = -1;
        this.path = null;
        if (this.oEh != null) {
            com.tencent.mm.plugin.mmsight.segment.d.a aVar = this.oEh;
            if (aVar.oDa != null) {
                aVar.mHC.lock();
                if (aVar.oDa == null) {
                    aVar.mHC.unlock();
                } else {
                    try {
                        Iterator it = aVar.oDa.iterator();
                        while (it.hasNext()) {
                            ((d) it.next()).release();
                        }
                    } catch (Throwable e) {
                        x.printErrStackTrace("FetcherPool", e, "destroy fetcher %s", e.getMessage());
                    } finally {
                        aVar.oDa = null;
                        lock = aVar.mHC;
                        lock.unlock();
                    }
                }
            }
        }
        if (!(this.oEe == null || this.oEe.oEp == null)) {
            d dVar = this.oEe.oEp;
            if (!(dVar.oEu == null || dVar.oEu.length == 0)) {
                for (int i = lock; i < dVar.oEu.length; i++) {
                    if (dVar.oEu[i] != null) {
                        dVar.oEu[i].quit();
                        dVar.oEu[i] = null;
                    }
                }
            }
            this.oEe.oEp = null;
            this.oEe = null;
        }
        if (this.oEf != null) {
            n nVar = this.oEf;
            if (nVar.oEU != null && nVar.oEV != null) {
                nVar.oEC.setBounds(nVar.oEU);
                nVar.oED.setBounds(nVar.oEV);
                nVar.oEH = -1.0f;
                nVar.postInvalidate();
            }
        }
    }

    public final void a(com.tencent.mm.plugin.mmsight.segment.c.a aVar) {
        this.oEc = aVar;
    }

    public final void a(com.tencent.mm.plugin.mmsight.segment.c.b bVar) {
        this.oEd = bVar;
    }

    public final float bbF() {
        if (this.oEf == null) {
            return 0.0f;
        }
        return tm(this.oEf.bbU());
    }

    public final float bbG() {
        if (this.oEf == null) {
            return 0.0f;
        }
        return tm(this.oEf.bbV());
    }

    private float tm(int i) {
        if (this.oEe == null || this.jTh == null) {
            return 0.0f;
        }
        View j = this.jTh.j((float) i, 0.0f);
        int aZ = RecyclerView.aZ(j);
        int itemCount = this.oEe.getItemCount();
        if (aZ <= 0) {
            return 0.0f;
        }
        if (aZ >= itemCount - 1) {
            return 1.0f;
        }
        return (((float) (aZ - 1)) + (((float) (i - j.getLeft())) / ((float) j.getWidth()))) / ((float) (itemCount - 2));
    }
}
