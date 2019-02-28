package com.tencent.mm.plugin.webview.fts.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.x;

public class FtsWebVideoViewControlBar extends FtsVideoPlayerSeekBar {
    private static int jwr = -1;
    private ImageView jwg;
    private ImageView jwj;
    private FrameLayout jwl;
    private al jwn;
    private al jwo;
    public boolean jwp;
    private ImageView txE;
    private ImageView txT;
    public RelativeLayout txU;
    public a txV;

    public interface a {
        int ahg();

        int ahh();

        int bQO();
    }

    public FtsWebVideoViewControlBar(Context context) {
        super(context);
    }

    public FtsWebVideoViewControlBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public FtsWebVideoViewControlBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public final void onDestroy() {
        if (this.jwo != null) {
            this.jwo.TN();
        }
        if (this.jwn != null) {
            this.jwn.TN();
        }
    }

    public int getLayoutId() {
        return R.i.djs;
    }

    public void init() {
        super.init();
        this.jwg = (ImageView) this.contentView.findViewById(R.h.ckm);
        this.txT = (ImageView) this.contentView.findViewById(R.h.cWp);
        this.jwj = (ImageView) this.contentView.findViewById(R.h.cCU);
        this.jwl = (FrameLayout) this.contentView.findViewById(R.h.cCV);
        this.txU = (RelativeLayout) findViewById(R.h.cIB);
        this.txE = (ImageView) this.contentView.findViewById(R.h.cfJ);
        if (jwr < 0) {
            jwr = getResources().getDimensionPixelSize(R.f.bxv);
        }
    }

    public final void dd(boolean z) {
        this.fwB = z;
        aho();
    }

    protected final int btK() {
        return this.qAq.getWidth();
    }

    private void aho() {
        if (this.jwp) {
            if (this.fwB) {
                this.qAr.setImageResource(R.g.bCt);
            } else {
                this.qAr.setImageResource(R.g.bCw);
            }
        } else if (this.fwB) {
            this.qAr.setImageResource(R.g.bCt);
        } else {
            this.qAr.setImageResource(R.g.bCw);
        }
    }

    public final void AA() {
        this.txT.setImageResource(R.g.bCy);
    }

    public final void bRc() {
        this.txT.setImageResource(R.g.bCv);
    }

    public final void j(OnClickListener onClickListener) {
        this.txT.setOnClickListener(onClickListener);
    }

    public final void k(OnClickListener onClickListener) {
        this.jwg.setOnClickListener(onClickListener);
    }

    public final void l(OnClickListener onClickListener) {
        this.txE.setOnClickListener(onClickListener);
    }

    public void kp(boolean z) {
        setVisibility(0);
        if (z) {
            bRh();
        } else {
            bRi();
        }
        if (this.jwn == null) {
            this.jwn = new al(new com.tencent.mm.sdk.platformtools.al.a() {
                public final boolean uG() {
                    FtsWebVideoViewControlBar.this.setVisibility(8);
                    FtsWebVideoViewControlBar.this.jwn.TN();
                    return false;
                }
            }, false);
        }
        this.jwn.TN();
        this.jwn.K(2000, 2000);
    }

    public final void bRd() {
        if (this.jwn != null) {
            this.jwn.TN();
        }
    }

    public final void bRe() {
        if (this.jwn != null) {
            this.jwn.TN();
            this.jwn.K(2000, 2000);
        }
    }

    public final void ku(boolean z) {
        if ((getVisibility() == 0 ? 1 : null) != null) {
            setVisibility(8);
        } else {
            kp(z);
        }
    }

    public void bQV() {
        this.jwp = true;
        ahs();
    }

    public void agI() {
        this.jwp = false;
        ahs();
    }

    private void ahs() {
        LayoutParams layoutParams = this.txU.getLayoutParams();
        if (this.jwp) {
            layoutParams.height = getResources().getDimensionPixelSize(R.f.bxt);
        } else {
            layoutParams.height = getResources().getDimensionPixelSize(R.f.bxr);
        }
        this.txU.setLayoutParams(layoutParams);
        if (this.jwp) {
            this.jwg.setImageResource(R.k.dyT);
            this.jwg.setVisibility(8);
            this.txE.setVisibility(0);
        } else {
            this.txE.setVisibility(8);
            this.jwg.setVisibility(0);
            this.jwg.setImageResource(R.g.bCu);
        }
        aho();
        float dimensionPixelSize = this.jwp ? (float) getResources().getDimensionPixelSize(R.f.bxu) : (float) getResources().getDimensionPixelSize(R.f.bxs);
        this.qAs.setTextSize(0, dimensionPixelSize);
        this.qAt.setTextSize(0, dimensionPixelSize);
    }

    public final void bRf() {
        if (this.jwo == null) {
            this.jwo = new al(new com.tencent.mm.sdk.platformtools.al.a() {
                public final boolean uG() {
                    if (FtsWebVideoViewControlBar.this.aht()) {
                        return true;
                    }
                    return false;
                }
            }, true);
        }
        aht();
        this.jwo.TN();
        this.jwo.K(500, 500);
    }

    public final void bRg() {
        if (this.jwo != null) {
            this.jwo.TN();
        }
    }

    private boolean aht() {
        if (this.txV == null) {
            x.i("MicroMsg.FtsWebVideoViewControlBar", "updateMiddleBar mStatePorter null");
            return false;
        }
        int ahg = this.txV.ahg();
        int ahh = this.txV.ahh();
        if (ahg < 0 || ahh < 0) {
            return false;
        }
        int width = this.jwl.getWidth();
        if (width <= 0) {
            return true;
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.jwj.getLayoutParams();
        if (ahh != 0) {
            width = (int) (((float) width) * (1.0f - (((float) ahg) / ((float) ahh))));
        }
        if (width <= 0) {
            width = 0;
        }
        layoutParams.rightMargin = width + jwr;
        this.jwj.setLayoutParams(layoutParams);
        if (ahg < ahh || ahh == 0) {
            return true;
        }
        return false;
    }

    public final void bRh() {
        this.qAr.setVisibility(8);
    }

    public final void bRi() {
        this.qAr.setVisibility(0);
    }

    public final void xr(int i) {
        seek((int) Math.ceil((((double) this.txV.bQO()) * 1.0d) / 1000.0d));
    }
}
