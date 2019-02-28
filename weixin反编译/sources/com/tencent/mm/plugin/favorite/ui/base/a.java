package com.tencent.mm.plugin.favorite.ui.base;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.favorite.a.j;
import com.tencent.mm.plugin.favorite.d;
import com.tencent.mm.sdk.platformtools.w;

public final class a {
    public Button lmo;
    public TextView lmv;
    public View mAA;
    public a mAB;
    public long mAx = j.aJr();
    public boolean mAz = false;

    public interface a {
        void aJN();
    }

    public final void show() {
        if (!this.mAz) {
            if (this.mAA != null) {
                if (this.mAA instanceof ViewStub) {
                    this.mAA = ((ViewStub) this.mAA).inflate();
                }
                this.lmv = (TextView) this.mAA.findViewById(R.h.cgs);
                if (!w.cfR()) {
                    this.lmv.setTextSize(1, 14.0f);
                }
                this.lmo = (Button) this.mAA.findViewById(R.h.cgr);
                aKf();
                this.lmo.setOnClickListener(new OnClickListener() {
                    public final void onClick(View view) {
                        if (a.this.mAB != null) {
                            a.this.mAB.aJN();
                        }
                    }
                });
                this.mAz = true;
            } else {
                return;
            }
        }
        if (this.mAA.getVisibility() != 0) {
            this.mAA.setVisibility(0);
            this.mAA.startAnimation(AnimationUtils.loadAnimation(this.mAA.getContext(), R.a.bpZ));
        }
    }

    public final void hide() {
        if (this.mAz && this.mAA.getVisibility() != 8) {
            this.mAA.setVisibility(8);
            this.mAA.startAnimation(AnimationUtils.loadAnimation(this.mAA.getContext(), R.a.bqa));
        }
    }

    public final void aKf() {
        this.lmv.setText(this.lmv.getContext().getString(R.l.eeL, new Object[]{d.dh(this.mAx)}));
        this.lmo.setEnabled(false);
    }
}
