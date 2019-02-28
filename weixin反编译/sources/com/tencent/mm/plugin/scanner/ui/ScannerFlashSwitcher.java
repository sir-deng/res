package com.tencent.mm.plugin.scanner.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.v;

public class ScannerFlashSwitcher extends LinearLayout {
    ImageView qeG;
    TextView qeH;
    boolean qeI = false;

    public ScannerFlashSwitcher(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public ScannerFlashSwitcher(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private void init() {
        v.fw(getContext()).inflate(R.i.cJl, this, true);
        this.qeG = (ImageView) findViewById(R.h.cim);
        this.qeH = (TextView) findViewById(R.h.cil);
        this.qeI = true;
    }

    public final void hide() {
        x.i("MicroMsg.ScannerFlashSwitcher", "hide");
        setEnabled(false);
        this.qeG.animate().alpha(0.0f).setDuration(500);
        this.qeH.animate().alpha(0.0f).setDuration(500).setListener(new AnimatorListenerAdapter() {
            public final void onAnimationEnd(Animator animator) {
                ScannerFlashSwitcher.this.setVisibility(8);
            }
        });
    }

    public final void bqb() {
        x.i("MicroMsg.ScannerFlashSwitcher", "closeFlashStatus");
        this.qeG.setImageResource(R.k.dAH);
    }
}
