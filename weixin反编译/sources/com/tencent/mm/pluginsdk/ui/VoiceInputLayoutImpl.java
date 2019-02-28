package com.tencent.mm.pluginsdk.ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import com.tencent.mm.R;
import com.tencent.mm.bp.a;
import com.tencent.mm.plugin.report.kvdata.VoiceInputBehavior;
import com.tencent.mm.plugin.report.kvdata.log_13905;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.as;

@TargetApi(16)
public class VoiceInputLayoutImpl extends VoiceInputLayout {
    private OnTouchListener oEW = new OnTouchListener() {
        public final boolean onTouch(View view, MotionEvent motionEvent) {
            switch (motionEvent.getAction()) {
                case 0:
                    VoiceInputLayoutImpl.this.vsP = false;
                    VoiceInputLayoutImpl.this.vsQ = bi.Wz();
                    x.d("MicroMsg.VoiceInputLayoutImp", "btn onTouch ACTION_DOWN currentState %s longClickStartTime %s", Integer.valueOf(VoiceInputLayoutImpl.this.vsl), Long.valueOf(VoiceInputLayoutImpl.this.vsQ));
                    VoiceInputLayoutImpl.this.vsO.cbf();
                    VoiceInputLayoutImpl.this.O(false, false);
                    break;
                case 1:
                    x.d("MicroMsg.VoiceInputLayoutImp", "btn onTouch ACTION_UP currentState %s longClickDown %s", Integer.valueOf(VoiceInputLayoutImpl.this.vsl), Boolean.valueOf(VoiceInputLayoutImpl.this.vsP));
                    if (!VoiceInputLayoutImpl.this.vsP) {
                        VoiceInputLayoutImpl.this.O(false, true);
                        break;
                    }
                    VoiceInputLayoutImpl.this.O(true, false);
                    VoiceInputLayoutImpl.this.vsP = false;
                    VoiceInputLayoutImpl.this.vsQ = 0;
                    break;
            }
            return false;
        }
    };
    private View vsN;
    private m vsO;
    private boolean vsP = false;
    private long vsQ;
    private OnLongClickListener vsR = new OnLongClickListener() {
        public final boolean onLongClick(View view) {
            x.d("MicroMsg.VoiceInputLayoutImp", "btn onLongClickListener currentState %s", Integer.valueOf(VoiceInputLayoutImpl.this.vsl));
            VoiceInputLayoutImpl.this.vsP = true;
            VoiceInputLayoutImpl.this.vsO.cbd();
            return true;
        }
    };

    public VoiceInputLayoutImpl(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    public VoiceInputLayoutImpl(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    private void init(Context context) {
        this.vsN = inflate(context, R.i.dtI, this).findViewById(R.h.cXe);
        this.vsN.setLayerType(1, null);
        this.vsO = new m(context);
        this.vsN.setBackground(this.vsO);
        this.vsN.setEnabled(true);
        this.vsN.setOnTouchListener(this.oEW);
        this.vsN.setOnLongClickListener(this.vsR);
        reset(true);
        if (!isInEditMode() && !cbv()) {
            cbu();
        }
    }

    public final void O(boolean z, boolean z2) {
        x.d("MicroMsg.VoiceInputLayoutImp", "directStart currentState = %s longUp = %s clickUp = %s", Integer.valueOf(this.vsl), Boolean.valueOf(z), Boolean.valueOf(z2));
        if (this.vsl == 1) {
            if (z || z2) {
                if (z && !z2) {
                    aa(4, this.vsP);
                    aa(this.vsl, this.vsP);
                    this.vsO.cbe();
                }
            } else if (cbv()) {
                cbl();
            } else {
                cbu();
            }
        } else if (this.vsl == 2) {
            if (z2) {
                this.vsO.cbe();
                cbm();
                if (this.vsK != null) {
                    this.vsK.cbo();
                }
                aa(5, this.vsP);
                return;
            }
            if (z) {
                aa(4, this.vsP);
            }
            aa(this.vsl, this.vsP);
            bc();
        } else if (!z && !z2) {
            aa(this.vsl, this.vsP);
            cbm();
        } else if (z && !z2) {
            aa(4, this.vsP);
            aa(this.vsl, this.vsP);
            this.vsO.cbe();
        }
    }

    private void cbu() {
        runOnUiThread(new Runnable() {
            public final void run() {
                VoiceInputLayoutImpl.this.vsO.cbh();
            }
        });
        cbn();
    }

    private static boolean cbv() {
        int Ks = as.CN().Ks();
        return Ks == 4 || Ks == 6;
    }

    protected final void le(boolean z) {
        runOnUiThread(new Runnable(true) {
            public final void run() {
                VoiceInputLayoutImpl.this.vsO.lb(true);
            }
        });
    }

    protected final void cL(boolean z) {
        if (!z) {
            aa(17, false);
        }
        runOnUiThread(new Runnable() {
            public final void run() {
                VoiceInputLayoutImpl.this.vsO.cbg();
            }
        });
    }

    protected final void onReset() {
        runOnUiThread(new Runnable() {
            public final void run() {
                VoiceInputLayoutImpl.this.vsO.cbe();
            }
        });
    }

    protected final void Cl(final int i) {
        runOnUiThread(new Runnable() {
            public final void run() {
                VoiceInputLayoutImpl.this.vsO.Ck(i);
            }
        });
    }

    private static void runOnUiThread(Runnable runnable) {
        if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
            ah.y(runnable);
        } else {
            runnable.run();
        }
    }

    private void aa(int i, boolean z) {
        a log_13905 = new log_13905();
        VoiceInputBehavior voiceInputBehavior = new VoiceInputBehavior();
        if (!z) {
            voiceInputBehavior.click = i;
        } else if (this.vsH) {
            voiceInputBehavior.fullScreenVoiceLongClick = i;
            if (!(i == 4 || !this.vsP || this.vsQ == 0)) {
                voiceInputBehavior.fullScreenVoiceLongClickTime = bi.bB(this.vsQ);
            }
        } else {
            voiceInputBehavior.longClick = i;
            if (!(i == 4 || !this.vsP || this.vsQ == 0)) {
                voiceInputBehavior.longClickTime = bi.bB(this.vsQ);
            }
        }
        log_13905.viOp_ = voiceInputBehavior;
        g.pWK.c(13905, log_13905);
        x.i("MicroMsg.VoiceInputLayoutImp", "report cancel = %s send = %s click = %s longClick = %s longClickTime = %s textClick = %s textChangeCount = %s textChangeTime = %s textChangeReturn = %s voiceInputTime = %s fail = %s clear = %s smileIconClick = %s voiceIconClick = %s fullScreenVoiceLongClick = %s fullScreenVoiceLongClickTime = %s", Integer.valueOf(voiceInputBehavior.cancel), Integer.valueOf(voiceInputBehavior.send), Integer.valueOf(voiceInputBehavior.click), Integer.valueOf(voiceInputBehavior.longClick), Long.valueOf(voiceInputBehavior.longClickTime), Integer.valueOf(voiceInputBehavior.textClick), Integer.valueOf(voiceInputBehavior.textChangeCount), Long.valueOf(voiceInputBehavior.textChangeTime), Integer.valueOf(voiceInputBehavior.textChangeReturn), Long.valueOf(voiceInputBehavior.voiceInputTime), Integer.valueOf(voiceInputBehavior.fail), Integer.valueOf(voiceInputBehavior.clear), Integer.valueOf(voiceInputBehavior.smileIconClick), Integer.valueOf(voiceInputBehavior.voiceIconClick), Integer.valueOf(voiceInputBehavior.fullScreenVoiceLongClick), Long.valueOf(voiceInputBehavior.fullScreenVoiceLongClickTime));
    }
}
