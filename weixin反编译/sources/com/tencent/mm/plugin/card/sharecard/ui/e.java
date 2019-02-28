package com.tencent.mm.plugin.card.sharecard.ui;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.sharecard.a.b;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;

public final class e {
    private ImageView fzb;
    View kUp;
    b kUq;
    protected LinearLayout kUr;
    protected LinearLayout kUs;
    private TextView kUt;
    private MMActivity kgL;

    public e(MMActivity mMActivity) {
        this.kgL = mMActivity;
    }

    public final void avL() {
        if (this.kUp == null) {
            this.kUp = View.inflate(this.kgL, R.i.dcB, null);
            this.fzb = (ImageView) this.kUp.findViewById(R.h.bJS);
            this.kUt = (TextView) this.kUp.findViewById(R.h.cOr);
            this.kUr = (LinearLayout) this.kUp.findViewById(R.h.ctB);
            this.kUs = (LinearLayout) this.kUp.findViewById(R.h.ctz);
            this.kUr.setVisibility(8);
            this.kUs.setVisibility(8);
            Animation rotateAnimation = new RotateAnimation(0.0f, 359.0f, 1, 0.5f, 1, 0.5f);
            rotateAnimation.setDuration(1000);
            rotateAnimation.setRepeatCount(-1);
            rotateAnimation.setInterpolator(new LinearInterpolator());
            this.fzb.startAnimation(rotateAnimation);
        }
        av();
    }

    public final void avM() {
        this.kUr.setVisibility(0);
        this.kUs.setVisibility(8);
    }

    public final void avN() {
        this.kUr.setVisibility(8);
    }

    private void avO() {
        this.kUr.setVisibility(8);
        this.kUs.setVisibility(8);
    }

    public final void avP() {
        avO();
        this.kUt.setVisibility(8);
    }

    public final void av() {
        Integer num = (Integer) am.avm().getValue("key_share_card_show_type");
        if (num == null) {
            num = Integer.valueOf(0);
        }
        if (this.kUq != null && b.avF() && ((num.intValue() == 1 || num.intValue() == 4) && b.avC())) {
            this.kUt.setVisibility(0);
        } else {
            this.kUt.setVisibility(8);
            if (this.kUq != null) {
                x.d("MicroMsg.ShareCardFooterController", "updateView isLocalEnd %s isOtherEnd %s ", Boolean.valueOf(b.avF()), Boolean.valueOf(b.avG()));
                if (!b.avF() || !b.avG()) {
                    avM();
                    return;
                } else if (b.avF() && b.avG()) {
                    this.kUr.setVisibility(8);
                    this.kUs.setVisibility(8);
                    return;
                } else {
                    return;
                }
            }
        }
        avO();
    }
}
