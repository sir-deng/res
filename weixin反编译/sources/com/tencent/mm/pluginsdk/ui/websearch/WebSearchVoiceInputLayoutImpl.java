package com.tencent.mm.pluginsdk.ui.websearch;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.ui.VoiceInputLayout;
import com.tencent.mm.pluginsdk.ui.m;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.as;

@TargetApi(16)
public class WebSearchVoiceInputLayoutImpl extends VoiceInputLayout {
    private OnTouchListener oEW = new OnTouchListener() {
        public final boolean onTouch(View view, MotionEvent motionEvent) {
            switch (motionEvent.getAction()) {
                case 0:
                    WebSearchVoiceInputLayoutImpl.this.vsP = false;
                    WebSearchVoiceInputLayoutImpl.this.vsQ = bi.Wz();
                    x.d("MicroMsg.WebSearchVoiceInputLayoutImpl", "btn onTouch ACTION_DOWN currentState %s longClickStartTime %s", Integer.valueOf(WebSearchVoiceInputLayoutImpl.this.vsl), Long.valueOf(WebSearchVoiceInputLayoutImpl.this.vsQ));
                    WebSearchVoiceInputLayoutImpl.this.vsO.cbf();
                    WebSearchVoiceInputLayoutImpl.this.O(false, false);
                    break;
                case 1:
                    x.d("MicroMsg.WebSearchVoiceInputLayoutImpl", "btn onTouch ACTION_UP currentState %s longClickDown %s", Integer.valueOf(WebSearchVoiceInputLayoutImpl.this.vsl), Boolean.valueOf(WebSearchVoiceInputLayoutImpl.this.vsP));
                    if (!WebSearchVoiceInputLayoutImpl.this.vsP) {
                        WebSearchVoiceInputLayoutImpl.this.O(false, true);
                        break;
                    }
                    WebSearchVoiceInputLayoutImpl.this.O(true, false);
                    WebSearchVoiceInputLayoutImpl.this.vsP = false;
                    WebSearchVoiceInputLayoutImpl.this.vsQ = 0;
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
            x.d("MicroMsg.WebSearchVoiceInputLayoutImpl", "btn onLongClickListener currentState %s", Integer.valueOf(WebSearchVoiceInputLayoutImpl.this.vsl));
            WebSearchVoiceInputLayoutImpl.this.vsP = true;
            WebSearchVoiceInputLayoutImpl.this.vsO.cbd();
            return true;
        }
    };

    public WebSearchVoiceInputLayoutImpl(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    public WebSearchVoiceInputLayoutImpl(Context context, AttributeSet attributeSet) {
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
        x.d("MicroMsg.WebSearchVoiceInputLayoutImpl", "directStart currentState = %s longUp = %s clickUp = %s", Integer.valueOf(this.vsl), Boolean.valueOf(z), Boolean.valueOf(z2));
        if (this.vsl == 1) {
            if (z || z2) {
                if (z && !z2) {
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
                    return;
                }
                return;
            }
            bc();
        } else if (!z && !z2) {
            cbm();
        } else if (z && !z2) {
            this.vsO.cbe();
        }
    }

    private void cbu() {
        runOnUiThread(new Runnable() {
            public final void run() {
                WebSearchVoiceInputLayoutImpl.this.vsO.cbh();
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
                WebSearchVoiceInputLayoutImpl.this.vsO.lb(true);
            }
        });
    }

    protected final void cL(boolean z) {
        runOnUiThread(new Runnable() {
            public final void run() {
                WebSearchVoiceInputLayoutImpl.this.vsO.cbg();
            }
        });
    }

    protected final void onReset() {
        runOnUiThread(new Runnable() {
            public final void run() {
                WebSearchVoiceInputLayoutImpl.this.vsO.cbe();
            }
        });
    }

    protected final void Cl(final int i) {
        runOnUiThread(new Runnable() {
            public final void run() {
                WebSearchVoiceInputLayoutImpl.this.vsO.Ck(i);
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
}
