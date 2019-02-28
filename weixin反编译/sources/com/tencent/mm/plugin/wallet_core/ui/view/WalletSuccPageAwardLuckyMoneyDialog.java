package com.tencent.mm.plugin.wallet_core.ui.view;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.OvershootInterpolator;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import d.a.a.e;

@a(3)
public class WalletSuccPageAwardLuckyMoneyDialog extends MMActivity {
    private ViewGroup teC;
    private ImageView teD;
    private e teE;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        if (d.fN(19)) {
            getWindow().setFlags(67108864, 67108864);
        }
        byte[] byteArrayExtra = getIntent().getByteArrayExtra("key_layer_info");
        if (byteArrayExtra == null) {
            x.e("MicroMsg.WalletSuccPageAwardLuckyMoneyDialog", "WalletSuccPageAwardLuckyMoneyDialog onCreate error! cannot get layerInfoBytes!");
            finish();
        }
        this.teE = new e();
        try {
            this.teE.aH(byteArrayExtra);
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.WalletSuccPageAwardLuckyMoneyDialog", e, "parse layer info byte error! %s", e.getMessage());
            finish();
        }
        this.teC = (ViewGroup) findViewById(f.bYQ);
        this.teD = (ImageView) findViewById(f.bWm);
        this.teD.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                WalletSuccPageAwardLuckyMoneyDialog.this.finish();
            }
        });
        final View view = this.teC;
        AnimationListener anonymousClass2 = new AnimationListener() {
            public final void onAnimationStart(Animation animation) {
            }

            public final void onAnimationEnd(Animation animation) {
            }

            public final void onAnimationRepeat(Animation animation) {
            }
        };
        Animation scaleAnimation = new ScaleAnimation(0.0f, 0.96f, 0.0f, 0.96f, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setDuration(300);
        scaleAnimation.setInterpolator(new OvershootInterpolator());
        scaleAnimation.setFillAfter(true);
        final ScaleAnimation scaleAnimation2 = new ScaleAnimation(0.96f, 1.0f, 0.96f, 1.0f, 1, 0.5f, 1, 0.5f);
        scaleAnimation2.setDuration(100);
        scaleAnimation2.setFillAfter(true);
        scaleAnimation.setAnimationListener(new AnimationListener() {
            public final void onAnimationStart(Animation animation) {
            }

            public final void onAnimationRepeat(Animation animation) {
            }

            public final void onAnimationEnd(Animation animation) {
                view.startAnimation(scaleAnimation2);
            }
        });
        scaleAnimation2.setAnimationListener(anonymousClass2);
        if (view != null) {
            view.startAnimation(scaleAnimation);
        }
    }

    protected final int getLayoutId() {
        return g.uMt;
    }

    protected final int getForceOrientation() {
        return 1;
    }
}
