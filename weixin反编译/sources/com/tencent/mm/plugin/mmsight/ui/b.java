package com.tencent.mm.plugin.mmsight.ui;

import android.os.Looper;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class b {
    private int duration;
    boolean fBn;
    al hJi = null;
    private float oHE = 0.0f;
    private float oHF;
    float oHG;
    long oHH;
    float oHI;
    a oHJ;
    private Runnable oHK = new Runnable() {
        public final void run() {
            b.a(b.this);
            if (!b.this.fBn) {
                x.i("MicroMsg.ProgressHandlerAnimator", "isStart is false now");
            } else if (b.this.oHI < b.this.oHG) {
                b.this.hJi.post(this);
            } else {
                b.this.fBn = false;
                x.i("MicroMsg.ProgressHandlerAnimator", "reach end, currentValue: %s, end: %s", Float.valueOf(b.this.oHI), Float.valueOf(b.this.oHG));
                if (b.this.oHJ != null) {
                    b.this.oHJ.onAnimationEnd();
                }
            }
        }
    };

    public interface a {
        void an(float f);

        void onAnimationEnd();
    }

    static /* synthetic */ void a(b bVar) {
        x.d("MicroMsg.ProgressHandlerAnimator", "updateImpl, currentValue: %s", Float.valueOf(bVar.oHI));
        bVar.oHI = (((float) bi.bB(bVar.oHH)) / ((float) bVar.duration)) * (bVar.oHG - bVar.oHF);
        if (bVar.oHJ != null) {
            bVar.oHJ.an(bVar.oHI);
        }
    }

    public b(float f, float f2, int i) {
        this.oHF = f;
        this.oHG = f2;
        this.duration = i;
        if (f2 > f) {
            this.oHE = ((f2 - f) / ((float) this.duration)) * 20.0f;
        }
        x.i("MicroMsg.ProgressHandlerAnimator", "create ProgressHandlerAnimator, start: %s, end: %s, duration: %s, updateStep: %s", Float.valueOf(f), Float.valueOf(f2), Integer.valueOf(i), Float.valueOf(this.oHE));
        this.fBn = false;
        this.oHH = 0;
        this.hJi = new al(Looper.getMainLooper(), new com.tencent.mm.sdk.platformtools.al.a() {
            public final boolean uG() {
                b.a(b.this);
                if (!b.this.fBn) {
                    x.i("MicroMsg.ProgressHandlerAnimator", "isStart is false now");
                    return false;
                } else if (b.this.oHI < b.this.oHG) {
                    return true;
                } else {
                    b.this.fBn = false;
                    x.i("MicroMsg.ProgressHandlerAnimator", "reach end, currentValue: %s, end: %s, callback: %s", Float.valueOf(b.this.oHI), Float.valueOf(b.this.oHG), b.this.oHJ);
                    if (b.this.oHJ != null) {
                        b.this.oHJ.onAnimationEnd();
                    }
                    return false;
                }
            }
        }, true);
    }
}
