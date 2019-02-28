package com.tencent.mm.plugin.wallet_core.ui.view;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.h;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.k.c;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.as;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.v;

public class WalletAwardShakeAnimView extends RelativeLayout {
    long kIG;
    c oTo;
    private View tdQ;
    private TextView tdR;
    private boolean tdS = false;
    private boolean tdT = false;
    private String tdU;
    private int tdV = 0;
    String tdW;
    int tdX = 0;
    private ValueAnimator tdY;
    a tdZ;
    Runnable tea = new Runnable() {
        public final void run() {
            WalletAwardShakeAnimView.a(WalletAwardShakeAnimView.this);
        }
    };

    public interface a {
        void jZ(boolean z);
    }

    static /* synthetic */ void a(WalletAwardShakeAnimView walletAwardShakeAnimView) {
        x.i("MicroMsg.WalletAwardShakeAnimView", "delayNotifyClick, isInvokeCallback: %s", Boolean.valueOf(walletAwardShakeAnimView.tdT));
        if (!walletAwardShakeAnimView.tdT) {
            if (bi.oN(walletAwardShakeAnimView.tdW)) {
                walletAwardShakeAnimView.tdR.setText(walletAwardShakeAnimView.getContext().getString(i.vdu));
            } else {
                walletAwardShakeAnimView.tdR.setText(walletAwardShakeAnimView.tdW);
            }
            if (walletAwardShakeAnimView.tdX != 0) {
                walletAwardShakeAnimView.tdR.setTextColor(walletAwardShakeAnimView.tdX);
            }
        }
    }

    static /* synthetic */ void g(WalletAwardShakeAnimView walletAwardShakeAnimView) {
        x.i("MicroMsg.WalletAwardShakeAnimView", "onStartShakeOrClick");
        as.H(walletAwardShakeAnimView.getContext(), i.ePm);
        walletAwardShakeAnimView.bNN();
        if (walletAwardShakeAnimView.tdZ != null) {
            walletAwardShakeAnimView.tdZ.jZ(true);
        }
    }

    public WalletAwardShakeAnimView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public WalletAwardShakeAnimView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private void init() {
        v.fw(getContext()).inflate(g.uKQ, this);
        findViewById(f.background).setBackground(getResources().getDrawable(h.uNm));
        this.tdQ = findViewById(f.uCX);
        this.tdR = (TextView) findViewById(f.uCW);
    }

    public final void NZ(String str) {
        this.tdU = str;
        this.tdR.setText(str);
    }

    public final void zL(int i) {
        this.tdV = i;
        this.tdR.setTextColor(i);
    }

    private void bNN() {
        if (this.tdY != null) {
            this.tdY.cancel();
        }
        this.tdY = ValueAnimator.ofFloat(new float[]{-30.0f, 30.0f});
        this.tdY.setInterpolator(new LinearInterpolator());
        this.tdY.setRepeatMode(2);
        this.tdY.setRepeatCount(-1);
        this.tdY.setDuration(300);
        this.tdY.addUpdateListener(new AnimatorUpdateListener() {
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                WalletAwardShakeAnimView.this.tdQ.setRotation(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        this.tdY.start();
    }

    public final void destroy() {
        if (this.oTo != null) {
            this.oTo.aQC();
            this.oTo = null;
        }
        this.tdT = false;
        this.tdS = false;
        if (this.tdY != null) {
            this.tdY.cancel();
        }
        this.tdQ.setRotation(0.0f);
        if (bi.oN(this.tdU)) {
            this.tdR.setText(getResources().getText(i.vdv));
        } else {
            this.tdR.setText(this.tdU);
        }
        if (this.tdV != 0) {
            this.tdR.setTextColor(this.tdV);
        } else {
            this.tdR.setTextColor(Color.parseColor("#E24C4C"));
        }
        ah.K(this.tea);
    }
}
