package com.tencent.mm.ui;

import android.os.Bundle;
import android.view.KeyEvent;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.preference.i;

public abstract class a extends i implements l {
    private Bundle rDI;
    private boolean xLQ;
    private boolean xLR;
    private boolean xLS;
    private boolean xLT;
    protected boolean xLU = false;
    protected boolean xLV = false;
    protected boolean xLW;

    protected abstract void cmi();

    protected abstract void cmj();

    protected abstract void cmk();

    protected abstract void cml();

    protected abstract void cmm();

    protected abstract void cmn();

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.rDI = bundle;
        this.xLR = true;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && keyEvent.getAction() == 0) {
            return false;
        }
        return super.onKeyDown(i, keyEvent);
    }

    public void onResume() {
        super.onResume();
        cms();
        LauncherUI cnu = LauncherUI.cnu();
        if (cnu != null && cnu.xPy) {
            this.xLU = true;
            if (this.xLV) {
                cmu();
                this.xLV = false;
            }
        }
    }

    public final void cmr() {
        cmp();
        this.xLS = true;
    }

    public final void cmu() {
        if (this.xLU) {
            if (this.xLR) {
                cmi();
                this.xLR = false;
            } else if (this.xLQ) {
                cmn();
                cmi();
                x.v("MicroMsg.INIT", "KEVIN tab onRecreate ");
                this.xLQ = false;
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (this.xLS) {
                cmq();
                this.xLS = false;
            }
            if (!this.ysb) {
                int XK = XK();
                if (XK != -1) {
                    this.yrJ.addPreferencesFromResource(XK);
                    this.ysb = true;
                }
            }
            cmj();
            x.d("MicroMsg.INIT", "KEVIN " + toString() + " OnTabResume last : " + (System.currentTimeMillis() - currentTimeMillis));
            this.xLT = true;
            this.xLU = false;
        }
    }

    public final void cmt() {
        this.xLV = true;
    }

    public void onPause() {
        super.onPause();
        this.xLW = true;
        if (!this.xLW) {
            return;
        }
        if (this.xLT) {
            long currentTimeMillis = System.currentTimeMillis();
            cml();
            x.d("MicroMsg.INIT", "KEVIN " + toString() + " onTabPause last : " + (System.currentTimeMillis() - currentTimeMillis));
            this.xLT = false;
            this.xLW = false;
            return;
        }
        this.xLW = false;
    }

    public void onStop() {
        super.onStop();
        cmm();
    }

    public void onStart() {
        super.onStart();
        LauncherUI cnu = LauncherUI.cnu();
        if (cnu != null && cnu.xPy) {
            cmk();
        }
    }

    public void onDestroy() {
        cmn();
        super.onDestroy();
    }
}
