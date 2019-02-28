package com.tencent.mm.plugin.sight.encode.ui;

import android.content.Context;
import android.hardware.Camera.Parameters;
import android.os.Looper;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.mm.R;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.as;
import com.tencent.mm.y.d;

public abstract class SightCameraView extends FrameLayout implements com.tencent.mm.y.d.a {
    private d jwC;
    private Animation nPW;
    protected int oAC;
    protected e qDA;
    protected com.tencent.mm.plugin.sight.encode.a.a qDB;
    protected ImageView qDC;
    protected long qDD;
    protected int qDE;
    protected boolean qDF;
    protected boolean qDG;
    protected int qDH;
    private al qDI;
    private int qDJ;
    private Runnable qDK;
    private Runnable qDL;
    private long qvY;

    /* renamed from: com.tencent.mm.plugin.sight.encode.ui.SightCameraView$4 */
    class AnonymousClass4 implements Runnable {
        final /* synthetic */ Runnable gOB = null;

        AnonymousClass4(Runnable runnable) {
        }

        public final void run() {
        }

        public final String toString() {
            return super.toString() + "|stopRecord";
        }
    }

    protected enum a {
        ;

        static {
            qDN = 1;
            qDO = 2;
            qDP = 3;
            qDQ = new int[]{qDN, qDO, qDP};
        }
    }

    protected abstract void aB(String str, boolean z);

    public abstract void at(float f);

    protected abstract void but();

    protected abstract int buu();

    protected abstract int buv();

    protected abstract void il(boolean z);

    public abstract boolean isPlaying();

    static /* synthetic */ void b(SightCameraView sightCameraView) {
        x.i("MicroMsg.SightCameraView", "stop record");
        if (sightCameraView.qDB == null) {
            throw new IllegalStateException("The mSightMedia must be set!");
        }
        as.Dt().F(new AnonymousClass4(null));
        sightCameraView.qDI.TN();
        sightCameraView.au(0.0f);
        sightCameraView.buw();
        sightCameraView.setKeepScreenOn(false);
    }

    public final void wH(int i) {
        this.oAC = i;
    }

    public SightCameraView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.qDD = -1;
        this.qDE = a.qDP;
        this.qDF = false;
        this.qDG = false;
        this.oAC = 320;
        this.qDH = 6500;
        this.qvY = 0;
        this.qDI = new al(Looper.getMainLooper(), new com.tencent.mm.sdk.platformtools.al.a() {
            public final boolean uG() {
                float bub = ((float) SightCameraView.this.qDB.bub()) / ((float) SightCameraView.this.qDH);
                if (Float.compare(bub, 0.0f) > 0 || System.currentTimeMillis() - SightCameraView.this.qvY <= 20000) {
                    if (Float.compare(bub, 1.0f) <= 0 || SightCameraView.this.qDB.buc() != com.tencent.mm.plugin.sight.encode.a.a.a.qCi) {
                        SightCameraView.this.au(bub);
                    } else if (!SightCameraView.this.qDB.bua()) {
                        SightCameraView.b(SightCameraView.this);
                    }
                    return true;
                }
                x.e("MicroMsg.SightCameraView", "ERROR record duration, %dms !!!", Long.valueOf(20000));
                SightCameraView.this.aIc();
                return false;
            }
        }, true);
        this.qDJ = -1;
        this.qDK = new Runnable() {
            public final void run() {
            }

            public final String toString() {
                return super.toString() + "|startRecord";
            }
        };
        this.qDL = new Runnable() {
            public final void run() {
            }

            public final String toString() {
                return super.toString() + "|cancelRecord";
            }
        };
        this.jwC = new d();
        if (com.tencent.mm.plugin.sight.base.d.btl()) {
            inflate(getContext(), R.i.dsS, this);
        } else {
            inflate(getContext(), R.i.dsR, this);
        }
        this.qDF = false;
        this.qDG = false;
        this.qDA = new e();
        e eVar = this.qDA;
        x.i("MicroMsg.SightCamera", "init needRotate %s", Boolean.valueOf(false));
        if (q.gHH.gIj) {
            eVar.qDx.oyV = q.gHH.mVideoHeight;
            eVar.qDx.oyW = q.gHH.mVideoWidth;
            eVar.qDx.oyU = q.gHH.gIl;
        }
        eVar.qDx.ozf = com.tencent.mm.compatible.e.d.getNumberOfCameras();
        eVar.qDx.fGt = 0;
        this.qDC = (ImageView) findViewById(R.h.cEh);
        buw();
    }

    public SightCameraView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public final void au(float f) {
        x.d("MicroMsg.SightCameraView", "update progress %f", Float.valueOf(f));
        if (this.qDJ < 0) {
            this.qDJ = getResources().getDisplayMetrics().widthPixels;
        }
        int i;
        LayoutParams layoutParams;
        if (f < 0.0f) {
            LayoutParams layoutParams2 = this.qDC.getLayoutParams();
            layoutParams2.width = this.qDJ;
            this.qDC.setLayoutParams(layoutParams2);
        } else if (f > 1.0f) {
            i = (this.qDJ / 2) - 1;
            layoutParams = this.qDC.getLayoutParams();
            layoutParams.width = this.qDJ - (i * 2);
            this.qDC.setLayoutParams(layoutParams);
        } else {
            i = (int) ((((float) getResources().getDisplayMetrics().widthPixels) * f) / 2.0f);
            layoutParams = this.qDC.getLayoutParams();
            layoutParams.width = this.qDJ - (i * 2);
            this.qDC.setLayoutParams(layoutParams);
        }
    }

    private void buw() {
        if (this.qDC.getVisibility() != 4) {
            if (this.nPW != null) {
                this.nPW.cancel();
            }
            this.qDC.setVisibility(4);
        }
    }

    protected final void aIc() {
        x.w("MicroMsg.SightCameraView", "cancel record");
        if (this.qDB == null) {
            throw new IllegalStateException("The mSightMedia must be set!");
        }
        as.Dt().cgs().removeCallbacks(this.qDK);
        as.Dt().F(this.qDL);
        this.qDI.TN();
        au(0.0f);
        buw();
        setKeepScreenOn(false);
    }

    protected final void bux() {
        this.jwC.a(this);
    }

    protected final void buy() {
        this.jwC.bz(false);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        if (motionEvent.getAction() == 0 && this.qDF && this.qDG) {
            x.i("MicroMsg.SightCameraView", "check double click %dms", Long.valueOf(SystemClock.elapsedRealtime() - this.qDD));
            if (SystemClock.elapsedRealtime() - this.qDD < 400) {
                this.qDA.qDz.removeMessages(4354);
                e eVar = this.qDA;
                if (eVar.oxy) {
                    Parameters parameters;
                    try {
                        parameters = eVar.gGm.getParameters();
                    } catch (Throwable e) {
                        x.e("MicroMsg.SightCamera", "getParameters failed %s", e.getMessage());
                        x.printErrStackTrace("MicroMsg.SightCamera", e, "", new Object[0]);
                        parameters = null;
                    }
                    if (parameters != null) {
                        x.i("MicroMsg.SightCamera", "trigger zoom, has zoomed %B, isSupported %B", Boolean.valueOf(eVar.oxw), Boolean.valueOf(parameters.isZoomSupported()));
                        if (parameters.isZoomSupported()) {
                            eVar.qDz.removeMessages(4353);
                            if (eVar.oxw) {
                                eVar.qDz.oym = false;
                                eVar.qDz.oxw = false;
                                eVar.qDz.oyl = a.d(parameters) * -1;
                                eVar.qDz.sendMessage(eVar.qDz.obtainMessage(4353, eVar.gGm));
                            } else {
                                eVar.qDz.oym = false;
                                eVar.qDz.oxw = true;
                                eVar.qDz.oyl = a.d(parameters);
                                eVar.qDz.sendMessage(eVar.qDz.obtainMessage(4353, eVar.gGm));
                            }
                            if (!eVar.oxw) {
                                z = true;
                            }
                            eVar.oxw = z;
                        }
                    }
                } else {
                    x.w("MicroMsg.SightCamera", "want to trigger zoom, but current status is not preview");
                }
            } else {
                e eVar2 = this.qDA;
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                int buu = buu();
                int buv = buv();
                if (!com.tencent.mm.compatible.util.d.fO(14)) {
                    eVar2.qDz.removeMessages(4354);
                    eVar2.qDz.oyo = x;
                    eVar2.qDz.nOR = y;
                    eVar2.qDz.oyp = buu;
                    eVar2.qDz.oyq = buv;
                    eVar2.qDz.sendMessageDelayed(eVar2.qDz.obtainMessage(4354, eVar2.gGm), 400);
                }
            }
            this.qDD = SystemClock.elapsedRealtime();
            motionEvent.getX();
            motionEvent.getY();
            com.tencent.mm.compatible.util.d.fO(14);
        }
        return true;
    }
}
