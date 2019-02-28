package com.tencent.mm.plugin.sns.ui;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.ad.e;
import com.tencent.mm.f.a.aj;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sns.i;
import com.tencent.mm.plugin.sns.i.c;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.storage.m;
import com.tencent.mm.plugin.sns.ui.t.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.tools.MMGestureGallery;

public abstract class SnsBaseGalleryUI extends MMActivity implements a {
    private boolean kHl = true;
    private LinearLayout rEV;
    s rEW;
    private LinearLayout rEX;
    t rEY;
    private boolean rEZ = true;
    private TextView rFa = null;
    protected SnsInfoFlip rFb;
    protected Button rFc;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ae.bwa().J(3, true);
        this.rEV = (LinearLayout) findViewById(f.qIG);
        this.rEX = (LinearLayout) findViewById(f.content);
        this.rEY = new t(this, this);
        e eVar = this.rEY;
        x.i("MicroMsg.GalleryTitleManager", "onAttach");
        g.Dr();
        g.Dp().gRu.a(218, eVar);
        com.tencent.mm.sdk.b.a.xmy.b(eVar.myb);
        com.tencent.mm.sdk.b.a.xmy.b(eVar.ryL);
    }

    public void onResume() {
        super.onResume();
        if (this.rEW != null) {
            this.rEW.refresh();
        }
    }

    public final void addView(View view) {
        this.rEV.addView(view, new LayoutParams(-1, -1));
    }

    @SuppressLint({"ResourceAsColor"})
    public final void u(boolean z, int i) {
        this.rEW = new s(this, i, z);
        this.rEW.setBackgroundColor(c.transparent);
        ViewGroup.LayoutParams layoutParams = new LayoutParams(-1, -2);
        this.rEW.getBackground().setAlpha(50);
        this.rEX.addView(this.rEW, layoutParams);
        this.rEW.fvb = getIntent().getIntExtra("sns_source", 0);
    }

    public void onDestroy() {
        super.onDestroy();
        if (this.rEY != null) {
            e eVar = this.rEY;
            x.i("MicroMsg.GalleryTitleManager", "onDetch");
            g.Dr();
            g.Dp().gRu.b(218, eVar);
            com.tencent.mm.sdk.b.a.xmy.c(eVar.myb);
            com.tencent.mm.sdk.b.a.xmy.c(eVar.ryL);
        }
        if (this.rFb != null) {
            SnsInfoFlip snsInfoFlip = this.rFb;
            if (snsInfoFlip.rHX != null && (snsInfoFlip.rHX instanceof MMGestureGallery)) {
                MMGestureGallery mMGestureGallery = (MMGestureGallery) snsInfoFlip.rHX;
                mMGestureGallery.zug.release();
                mMGestureGallery.zuh.release();
                mMGestureGallery.zuf.release();
            }
            this.rFb.onDestroy();
        }
    }

    protected int getLayoutId() {
        return i.g.qNr;
    }

    public void cl(String str, int i) {
        if (this.rEZ && !ae.bvO()) {
            m LR = ae.bwf().LR(str);
            if (LR == null || LR.field_snsId == 0) {
                enableOptionMenu(false);
            } else {
                enableOptionMenu(true);
            }
        }
    }

    protected void onPause() {
        if (this.rFb != null) {
            this.rFb.onPause();
        }
        if (this.rEY != null) {
            t tVar = this.rEY;
            if (tVar.ryI != null) {
                b ajVar = new aj();
                ajVar.fpn.activity = (Activity) tVar.context;
                ajVar.fpn.fpo = tVar.ryI;
                com.tencent.mm.sdk.b.a.xmy.m(ajVar);
                tVar.ryI = null;
                tVar.fqX = 0;
                tVar.fqW = 0;
            }
        }
        super.onPause();
    }

    public final void ew(String str, String str2) {
        if (this.rEZ) {
            setMMTitle(str);
            setMMSubTitle(str2);
        }
    }

    public void ck(String str, int i) {
    }

    public void asq() {
        int i = 8;
        boolean z = false;
        if (this.rEZ) {
            int i2;
            if (this.kHl) {
                i2 = 8;
            } else {
                i2 = 0;
            }
            setTitleVisibility(i2);
            if (this.rEW != null) {
                s sVar = this.rEW;
                if (!this.kHl) {
                    i = 0;
                }
                sVar.setVisibility(i);
            }
            if (!this.kHl) {
                z = true;
            }
            this.kHl = z;
        }
    }

    public final void bAa() {
        this.kHl = false;
        setTitleVisibility(8);
        if (this.rEW != null) {
            this.rEW.setVisibility(8);
        }
    }
}
