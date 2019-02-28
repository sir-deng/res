package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.content.d;
import android.view.ViewGroup;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.i;
import com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingPagesUI;
import com.tencent.mm.sdk.platformtools.x;

public abstract class a extends i {
    public boolean rlF;
    protected boolean rlG = SnsAdNativeLandingPagesUI.rDU;
    public boolean rlH;
    private BroadcastReceiver tP = new BroadcastReceiver() {
        public final void onReceive(Context context, Intent intent) {
            if ("com.tencent.mm.adlanding.close_exposure_voice".equals(intent.getAction()) && !a.this.bxO().rmN.equals(intent.getStringExtra("para_id"))) {
                a aVar = a.this;
                if (aVar.rlH) {
                    aVar.bxp();
                }
            }
        }
    };

    public a(Context context, s sVar, ViewGroup viewGroup) {
        super(context, sVar, viewGroup);
        d.m(this.context).a(this.tP, new IntentFilter("com.tencent.mm.adlanding.close_exposure_voice"));
        x.v("AbsVideoPlayComp", "register receiver " + this.tP);
    }

    public void bxp() {
        this.rlF = false;
    }

    public void bxq() {
        super.bxq();
        d.m(this.context).unregisterReceiver(this.tP);
        this.rlH = true;
        x.v("AbsVideoPlayComp", "unregister receiver " + this.tP);
    }

    public void bxr() {
        super.bxr();
        this.rlH = true;
    }

    public void bxs() {
        super.bxs();
        this.rlH = false;
    }

    public void X(int i, int i2, int i3) {
        super.X(i, i2, i3);
    }

    public void bxt() {
        this.rlF = true;
    }

    public final void bxu() {
        Intent intent = new Intent("com.tencent.mm.adlanding.close_exposure_voice");
        intent.putExtra("para_id", bxO().rmN);
        d.m(this.context).a(intent);
    }

    protected final void bxv() {
        super.bxv();
        if (this.rlG) {
            bxt();
        } else {
            bxp();
        }
    }
}
