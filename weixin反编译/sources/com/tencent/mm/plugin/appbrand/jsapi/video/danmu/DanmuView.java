package com.tencent.mm.plugin.appbrand.jsapi.video.danmu;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class DanmuView extends View {
    private Paint jxA;
    private long jxB;
    private LinkedList<Float> jxC;
    public int jxm;
    public int jxn;
    public int jxo;
    public float jxp;
    public float jxq;
    private boolean jxr;
    private boolean jxs;
    public c jxt;
    public HashMap<Integer, ArrayList<d>> jxu;
    public final Deque<d> jxv;
    public List<d> jxw;
    private int[] jxx;
    private volatile boolean jxy;
    private LinkedList<Long> jxz;
    private final Context mContext;
    public volatile int status;

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.video.danmu.DanmuView$3 */
    class AnonymousClass3 implements Runnable {
        final /* synthetic */ d jxE;

        public AnonymousClass3(d dVar) {
            this.jxE = dVar;
        }

        public final void run() {
            synchronized (DanmuView.this.jxw) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= DanmuView.this.jxw.size()) {
                        break;
                    } else if (this.jxE.ahG() <= ((d) DanmuView.this.jxw.get(i2)).ahG()) {
                        DanmuView.this.jxw.add(i2, this.jxE);
                        break;
                    } else {
                        i = i2 + 1;
                    }
                }
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.video.danmu.DanmuView$4 */
    class AnonymousClass4 extends Thread {
        final /* synthetic */ List jxF;

        public AnonymousClass4(List list) {
            this.jxF = list;
        }

        public final void run() {
            synchronized (DanmuView.this.jxv) {
                DanmuView.this.jxv.addAll(this.jxF);
            }
            synchronized (DanmuView.this.jxw) {
                DanmuView.this.jxw.addAll(this.jxF);
            }
            DanmuView.this.postInvalidate();
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.video.danmu.DanmuView$5 */
    class AnonymousClass5 implements Runnable {
        final /* synthetic */ int jxG;

        public AnonymousClass5(int i) {
            this.jxG = i;
        }

        public final void run() {
            synchronized (DanmuView.this.jxv) {
                for (int size = DanmuView.this.jxw.size() - 1; size >= 0; size--) {
                    d dVar = (d) DanmuView.this.jxw.get(size);
                    if (dVar.ahG() < this.jxG) {
                        break;
                    }
                    x.v("MicroMsg.DanmuView", "seekToPlayTime addBack i=%d showTime=%d", Integer.valueOf(size), Integer.valueOf(dVar.ahG()));
                    DanmuView.this.jxv.addFirst(dVar);
                }
            }
            DanmuView.this.ahL();
        }
    }

    public DanmuView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DanmuView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jxm = 5;
        this.jxn = 500;
        this.jxo = 10;
        this.jxp = 0.0f;
        this.jxq = 0.6f;
        this.jxr = false;
        this.jxs = false;
        this.jxv = new LinkedList();
        this.jxw = new LinkedList();
        this.status = 3;
        this.jxB = 0;
        this.mContext = context;
    }

    public final void prepare() {
        float f = this.jxp;
        float f2 = this.jxq;
        if (f >= f2) {
            throw new IllegalArgumentException("start_Y_offset must < end_Y_offset");
        } else if (f < 0.0f || f >= 1.0f || f2 < 0.0f || f2 > 1.0f) {
            throw new IllegalArgumentException("start_Y_offset and end_Y_offset must between 0 and 1)");
        } else {
            setBackgroundColor(0);
            setDrawingCacheBackgroundColor(0);
            ahI();
        }
    }

    public final void ahI() {
        this.jxu = new HashMap(this.jxm);
        for (int i = 0; i < this.jxm; i++) {
            this.jxu.put(Integer.valueOf(i), new ArrayList(this.jxo));
        }
        ahJ();
    }

    private void ahJ() {
        int i = 0;
        this.jxx = new int[this.jxm];
        float bY = b.bY(this.mContext);
        float height = this.jxp * ((float) getHeight());
        for (int i2 = 0; i2 < this.jxm; i2++) {
            this.jxx[i2] = (int) (((((float) (i2 + 1)) * bY) + height) - ((3.0f * bY) / 4.0f));
        }
        if (this.jxs) {
            this.jxC.clear();
            this.jxC.add(Float.valueOf(height));
            while (i < this.jxm) {
                this.jxC.add(Float.valueOf((((float) (i + 1)) * bY) + height));
                i++;
            }
        }
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int i;
        Iterator it;
        Iterator it2;
        float floatValue;
        if (this.jxy) {
            x.i("MicroMsg.DanmuView", "inTransition");
        } else if (this.status == 1) {
            d dVar;
            canvas.drawColor(0);
            for (i = 0; i < this.jxu.size(); i++) {
                it = ((ArrayList) this.jxu.get(Integer.valueOf(i))).iterator();
                while (it.hasNext()) {
                    dVar = (d) it.next();
                    if (dVar.ahF()) {
                        it.remove();
                    } else {
                        try {
                            dVar.b(canvas, false);
                        } catch (Exception e) {
                            x.w("MicroMsg.DanmuView", "STATUS_RUNNING onDraw e=%s", e);
                        }
                    }
                }
            }
            if (System.currentTimeMillis() - this.jxB > ((long) this.jxn)) {
                this.jxB = System.currentTimeMillis();
                synchronized (this.jxv) {
                    if (this.jxv.size() > 0) {
                        dVar = (d) this.jxv.getFirst();
                        int MV = this.jxt.MV();
                        d dVar2 = dVar;
                        while (dVar2 != null && dVar2.kN(MV)) {
                            this.jxv.pollFirst();
                            dVar2 = (d) this.jxv.getFirst();
                        }
                        if (dVar2 != null && dVar2.kM(MV)) {
                            int b = b(dVar2);
                            if (b >= 0) {
                                dVar2.bJ(canvas.getWidth() - 2, this.jxx[b]);
                                dVar2.b(canvas, false);
                                ((ArrayList) this.jxu.get(Integer.valueOf(b))).add(dVar2);
                                this.jxv.pollFirst();
                            }
                        }
                    }
                }
            }
            if (this.jxr && this.jxz != null) {
                canvas.drawText("FPS:" + ((int) ahN()), 5.0f, 20.0f, this.jxA);
            }
            if (this.jxs && this.jxC != null) {
                it2 = this.jxC.iterator();
                while (it2.hasNext()) {
                    floatValue = ((Float) it2.next()).floatValue();
                    canvas.drawLine(0.0f, floatValue, (float) getWidth(), floatValue, this.jxA);
                }
            }
            invalidate();
        } else if (this.status == 2) {
            try {
                canvas.drawColor(0);
                for (i = 0; i < this.jxu.size(); i++) {
                    it = ((ArrayList) this.jxu.get(Integer.valueOf(i))).iterator();
                    while (it.hasNext()) {
                        ((d) it.next()).b(canvas, true);
                    }
                }
                if (this.jxr && this.jxz != null) {
                    canvas.drawText("FPS:" + ((int) ahN()), 5.0f, 20.0f, this.jxA);
                }
                if (this.jxs && this.jxC != null) {
                    it2 = this.jxC.iterator();
                    while (it2.hasNext()) {
                        floatValue = ((Float) it2.next()).floatValue();
                        canvas.drawLine(0.0f, floatValue, (float) getWidth(), floatValue, this.jxA);
                    }
                }
            } catch (Exception e2) {
                x.w("MicroMsg.DanmuView", "STATUS_PAUSE onDraw e=%s", e2);
            }
            invalidate();
        }
    }

    private int b(d dVar) {
        int i = 0;
        while (true) {
            try {
                int i2 = i;
                if (i2 >= this.jxm) {
                    break;
                }
                int i3 = (i2 + 0) % this.jxm;
                ArrayList arrayList = (ArrayList) this.jxu.get(Integer.valueOf(i3));
                if (arrayList.size() == 0) {
                    return i3;
                }
                if (arrayList.size() <= this.jxo && !dVar.a((d) arrayList.get(arrayList.size() - 1))) {
                    return i3;
                }
                i = i2 + 1;
            } catch (Exception e) {
                x.w("MicroMsg.DanmuView", "findVacant,Exception:" + e.getMessage());
            }
        }
        return -1;
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        ahJ();
    }

    public final void ahK() {
        if (isMainThread()) {
            this.jxy = true;
        } else {
            post(new Runnable() {
                public final void run() {
                    DanmuView.this.jxy = true;
                }
            });
        }
    }

    public final void ahL() {
        if (isMainThread()) {
            this.jxy = false;
            invalidate();
            return;
        }
        post(new Runnable() {
            public final void run() {
                DanmuView.this.jxy = false;
                DanmuView.this.invalidate();
            }
        });
    }

    public final void show() {
        this.status = 1;
        invalidate();
    }

    public final void pause() {
        this.status = 2;
        invalidate();
    }

    public final void hide() {
        this.status = 4;
        invalidate();
    }

    public final void ahM() {
        if (!(this.jxu == null || this.jxu.isEmpty())) {
            this.jxu.clear();
        }
        synchronized (this.jxv) {
            if (!this.jxv.isEmpty()) {
                this.jxv.clear();
            }
        }
    }

    private double ahN() {
        long nanoTime = System.nanoTime();
        this.jxz.addLast(Long.valueOf(nanoTime));
        double longValue = ((double) (nanoTime - ((Long) this.jxz.getFirst()).longValue())) / 1.0E9d;
        if (this.jxz.size() > 100) {
            this.jxz.removeFirst();
        }
        return longValue > 0.0d ? ((double) this.jxz.size()) / longValue : 0.0d;
    }

    private static boolean isMainThread() {
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }
}
