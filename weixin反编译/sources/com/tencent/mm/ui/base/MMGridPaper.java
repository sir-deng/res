package com.tencent.mm.ui.base;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.MMFlipper.a;
import com.tencent.mm.ui.base.MMFlipper.b;
import com.tencent.mm.v.a.g;
import com.tencent.mm.v.a.h;
import junit.framework.Assert;

public final class MMGridPaper extends LinearLayout {
    protected View Lr;
    protected MMDotView kgN;
    protected int lkz = 0;
    protected int mNumColumns = 0;
    protected ag pLF = new ag(Looper.getMainLooper());
    protected int ygr = 10;
    protected int ygs = 10;
    final b yiQ = new b() {
        public final void wb(final int i) {
            x.d("MicroMsg.MMGridPaper", "onScreenChanged:curScreen[%d], topEdge[%d], bottomEdge[%d], virtualPage[%d]", Integer.valueOf(i), Integer.valueOf(MMGridPaper.this.yjt), Integer.valueOf(MMGridPaper.this.yju), Integer.valueOf(MMGridPaper.this.yjv));
            if (i <= MMGridPaper.this.yjt && MMGridPaper.this.yjt > 0) {
                MMGridPaper.this.pLF.post(new Runnable() {
                    public final void run() {
                        MMGridPaperGridView mMGridPaperGridView = (MMGridPaperGridView) MMGridPaper.this.yjm.getChildAt(MMGridPaper.this.yjm.getChildCount() - 1);
                        x.i("MicroMsg.MMGridPaper", "move up, old index[%d], new index[%d]", Integer.valueOf(MMGridPaper.this.yjm.getChildCount() - 1), Integer.valueOf(i - (MMGridPaper.this.yjm.getChildCount() >> 1)));
                        MMGridPaper.this.yjm.removeViewAt(MMGridPaper.this.yjm.getChildCount() - 1);
                        mMGridPaperGridView.a(r1, MMGridPaper.this.lkz, MMGridPaper.this.mNumColumns, MMGridPaper.this.yjn);
                        MMGridPaper.this.yjm.addView(mMGridPaperGridView, 0);
                        MMGridPaper.this.yjm.Fc(MMGridPaper.this.yjm.getChildCount() >> 1);
                        MMGridPaper.a(MMGridPaper.this, -1);
                    }
                });
            } else if (i >= MMGridPaper.this.yju && MMGridPaper.this.yju < MMGridPaper.this.yjv - 1) {
                MMGridPaper.this.pLF.post(new Runnable() {
                    public final void run() {
                        MMGridPaperGridView mMGridPaperGridView = (MMGridPaperGridView) MMGridPaper.this.yjm.getChildAt(0);
                        x.i("MicroMsg.MMGridPaper", "move down, old index[0], new index[%d]", Integer.valueOf(i + (MMGridPaper.this.yjm.getChildCount() >> 1)));
                        MMGridPaper.this.yjm.removeViewAt(0);
                        mMGridPaperGridView.a(r1, MMGridPaper.this.lkz, MMGridPaper.this.mNumColumns, MMGridPaper.this.yjn);
                        MMGridPaper.this.yjm.addView(mMGridPaperGridView);
                        MMGridPaper.this.yjm.Fc(MMGridPaper.this.yjm.getChildCount() >> 1);
                        MMGridPaper.a(MMGridPaper.this, 1);
                    }
                });
            }
            MMGridPaper.this.yjr = i;
            MMGridPaper.this.kgN.Fb(i);
        }
    };
    final a yiR = new a() {
        public final void dq(int i, int i2) {
            x.v("MicroMsg.MMGridPaper", "onMeasure width:[new %d, old %d] height:[new %d, old %d], dialogMode[%B], orientationChange[%B]", Integer.valueOf(i), Integer.valueOf(MMGridPaper.this.yjo), Integer.valueOf(i2), Integer.valueOf(MMGridPaper.this.yjp), Boolean.valueOf(MMGridPaper.this.yjD), Boolean.valueOf(MMGridPaper.this.yjC));
            if ((Math.abs(MMGridPaper.this.yjp - i2) < 50 && Math.abs(MMGridPaper.this.yjo - i) < 50) || i2 == 0 || i == 0) {
                x.d("MicroMsg.MMGridPaper", "match width height limit, return");
            } else if (!MMGridPaper.this.yjD || MMGridPaper.this.yjo <= i || MMGridPaper.this.yjC) {
                x.v("MicroMsg.MMGridPaper", "onMeasure: match");
                x.v("MicroMsg.MMGridPaper", "onMeasure: mIsManualMeasureMode[%b]", Boolean.valueOf(MMGridPaper.this.yjJ));
                MMGridPaper.this.yjC = false;
                if (!MMGridPaper.this.yjJ) {
                    MMGridPaper.this.yjp = i2;
                    MMGridPaper.this.yjo = i;
                }
                MMGridPaper.this.refresh();
            } else {
                x.d("MicroMsg.MMGridPaper", "match ori limit, return");
            }
        }
    };
    protected int yjA = 96;
    protected int yjB = 96;
    protected boolean yjC = false;
    protected boolean yjD = false;
    protected int yjE = -1;
    protected int yjF = -1;
    protected int yjG = 0;
    protected int yjH = -1;
    protected int yjI = -1;
    protected boolean yjJ = false;
    protected int yjK = 0;
    protected int yjL = 0;
    protected MMFlipper yjm;
    protected l yjn;
    protected int yjo;
    protected int yjp;
    protected int yjq = 0;
    protected int yjr = 0;
    protected int yjs = 3;
    protected int yjt = 0;
    protected int yju = (this.yjs - 1);
    protected int yjv = 0;
    protected boolean yjw = false;
    protected int yjx = 9;
    protected int yjy = -1;
    protected int yjz = -1;

    static /* synthetic */ void a(MMGridPaper mMGridPaper, int i) {
        mMGridPaper.yjt += i;
        if (mMGridPaper.yjt < 0) {
            mMGridPaper.yjt = 0;
        } else if (mMGridPaper.yjt > mMGridPaper.yjv - mMGridPaper.yjs) {
            mMGridPaper.yjt = mMGridPaper.yjv - mMGridPaper.yjs;
        }
        mMGridPaper.yju = (mMGridPaper.yjt + mMGridPaper.yjs) - 1;
    }

    public MMGridPaper(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        View.inflate(getContext(), h.gZj, this);
        this.yjG = cbS();
    }

    public final void cpP() {
        this.yjA = 70;
    }

    public final void cpQ() {
        this.yjB = 70;
    }

    public final void cpR() {
        this.yjI = 3;
    }

    public final void Ff(int i) {
        this.yjH = i;
    }

    public final void cpS() {
        this.yjD = true;
    }

    public final void cpT() {
        this.yjF = 3;
        this.yjE = 3;
    }

    public final void cpU() {
        this.ygr = 8;
        this.ygs = 15;
    }

    public final void cpV() {
        this.Lr = null;
        ViewGroup viewGroup = (ViewGroup) findViewById(g.gXl);
        viewGroup.removeAllViews();
        if (this.Lr != null) {
            viewGroup.addView(this.Lr);
        }
    }

    public final void a(l lVar) {
        boolean z = true;
        this.yjn = lVar;
        String str = "MicroMsg.MMGridPaper";
        String str2 = "setGridPaperAdapter:adapter is null[%B]";
        Object[] objArr = new Object[1];
        if (lVar != null) {
            z = false;
        }
        objArr[0] = Boolean.valueOf(z);
        x.d(str, str2, objArr);
        if (this.yjn != null) {
            this.yjn.yjP = new l.a() {
                public final void cpZ() {
                    MMGridPaper.this.refresh();
                }
            };
        }
        cbT();
    }

    public final void refresh() {
        this.yjq = (this.yjr * this.mNumColumns) * this.lkz;
        x.v("MicroMsg.MMGridPaper", "refreshed:virtualPage[%d], col[%d], row[%d], scrollCount[%d]", Integer.valueOf(this.yjr), Integer.valueOf(this.mNumColumns), Integer.valueOf(this.lkz), Integer.valueOf(this.yjq));
        cbT();
    }

    private int cbS() {
        Display defaultDisplay = ((WindowManager) getContext().getSystemService("window")).getDefaultDisplay();
        if (defaultDisplay.getWidth() < defaultDisplay.getHeight()) {
            return 1;
        }
        return 2;
    }

    private void cpW() {
        View findViewById;
        LayoutParams layoutParams;
        int fromDPToPix;
        if (-1 != this.yjy && cbS() == 2) {
            findViewById = findViewById(g.gXi);
            layoutParams = (LayoutParams) findViewById.getLayoutParams();
            fromDPToPix = com.tencent.mm.bu.a.fromDPToPix(getContext(), this.yjy);
            if (fromDPToPix != layoutParams.height) {
                x.i("MicroMsg.MMGridPaper", "set land mode, special height is %d", Integer.valueOf(this.yjy));
                layoutParams.height = fromDPToPix;
                findViewById.setLayoutParams(layoutParams);
                this.pLF.post(new Runnable() {
                    public final void run() {
                        x.w("MicroMsg.MMGridPaper", "post do setDotView");
                        MMGridPaper.this.cpY();
                    }
                });
            }
        } else if (-1 != this.yjz && cbS() == 1) {
            findViewById = findViewById(g.gXi);
            layoutParams = (LayoutParams) findViewById.getLayoutParams();
            fromDPToPix = com.tencent.mm.bu.a.fromDPToPix(getContext(), this.yjz);
            if (fromDPToPix != layoutParams.height) {
                x.i("MicroMsg.MMGridPaper", "set port mode, special height is %d", Integer.valueOf(this.yjz));
                layoutParams.height = fromDPToPix;
                findViewById.setLayoutParams(layoutParams);
                this.pLF.post(new Runnable() {
                    public final void run() {
                        x.w("MicroMsg.MMGridPaper", "post do setDotView");
                        MMGridPaper.this.cpY();
                    }
                });
            }
        }
    }

    private void cbT() {
        x.v("MicroMsg.MMGridPaper", "MMGridPaper initFlipper");
        if (this.kgN == null) {
            this.kgN = (MMDotView) findViewById(g.gXj);
            MMDotView mMDotView = this.kgN;
            x.d("MicroMsg.MMDotView", "setMaxCount:%d", Integer.valueOf(this.yjx));
            mMDotView.gDq = r1;
        }
        if (this.yjm == null) {
            this.yjm = (MMFlipper) findViewById(g.gXk);
            this.yjm.yiR = this.yiR;
            this.yjm.yiQ = this.yiQ;
        }
        cpW();
        cpX();
    }

    private void cpX() {
        x.v("MicroMsg.MMGridPaper", "initSubGrid, grid width %d, grid height %d", Integer.valueOf(this.yjo), Integer.valueOf(this.yjp));
        if (this.yjo == 0 || this.yjp == 0) {
            x.w("MicroMsg.MMGridPaper", "initSubGrid:gridWithd or gridHeight is 0");
            return;
        }
        boolean z;
        int min;
        int fromDPToPix = com.tencent.mm.bu.a.fromDPToPix(getContext(), this.yjA);
        int fromDPToPix2 = com.tencent.mm.bu.a.fromDPToPix(getContext(), this.yjB);
        fromDPToPix = Math.max(this.yjo / fromDPToPix, 1);
        fromDPToPix2 = Math.max(this.yjp / fromDPToPix2, 1);
        if (!(fromDPToPix == this.mNumColumns && fromDPToPix2 == this.lkz)) {
            this.yjw = true;
        }
        this.mNumColumns = fromDPToPix;
        if (this.yjH != -1) {
            this.mNumColumns = Math.min(this.mNumColumns, this.yjH);
        }
        this.lkz = fromDPToPix2;
        if (this.yjI != -1) {
            this.lkz = Math.min(this.lkz, this.yjI);
        }
        int i = this.mNumColumns * this.lkz;
        this.yjv = 0;
        fromDPToPix2 = (this.yjn == null ? 0 : this.yjn.getCount()) + 0;
        x.d("MicroMsg.MMGridPaper", "totalCount is %d, dialogMode is %B", Integer.valueOf(fromDPToPix2), Boolean.valueOf(this.yjD));
        if (fromDPToPix2 >= 0) {
            z = true;
        } else {
            z = false;
        }
        Assert.assertTrue(z);
        if (this.yjD) {
            fromDPToPix = eS(fromDPToPix2, this.mNumColumns);
            switch (cbS()) {
                case 1:
                    min = ((this.yjB + 10) * Math.min(fromDPToPix, this.yjE)) + 8;
                    x.d("MicroMsg.MMGridPaper", "orientation[%d], minRows[%d], targetHeight[%d], displayHeight[%d], orientationChange[%B]", Integer.valueOf(cbS()), Integer.valueOf(Math.min(fromDPToPix, this.yjE)), Integer.valueOf(min), Integer.valueOf(this.yjz), Boolean.valueOf(this.yjC));
                    if (this.yjz == min) {
                        z = true;
                        break;
                    }
                    this.yjz = min;
                    z = false;
                    break;
                case 2:
                    min = ((this.yjB + 10) * Math.min(fromDPToPix, this.yjF)) + 8;
                    x.d("MicroMsg.MMGridPaper", "orientation[%d], minRows[%d], targetHeight[%d], displayHeight[%d], orientationChange[%B]", Integer.valueOf(cbS()), Integer.valueOf(Math.min(fromDPToPix, this.yjF)), Integer.valueOf(min), Integer.valueOf(this.yjy), Boolean.valueOf(this.yjC));
                    if (this.yjy == min) {
                        z = true;
                        break;
                    }
                    this.yjy = min;
                    z = false;
                    break;
            }
        }
        z = true;
        if (z) {
            this.yjv = eS(fromDPToPix2, i);
            min = this.yjv - 1;
            int i2 = this.yjq;
            if (i2 == 0 || i <= 0) {
                x.w("MicroMsg.MMGridPaper", "floor:total[%d], length[%d]", Integer.valueOf(i2), Integer.valueOf(i));
                fromDPToPix = 0;
            } else {
                fromDPToPix2 = i2;
                fromDPToPix = 0;
                while (fromDPToPix2 >= i) {
                    fromDPToPix2 -= i;
                    fromDPToPix++;
                }
                x.i("MicroMsg.MMGridPaper", "floor:num[%d], length[%d], result[%d]", Integer.valueOf(i2), Integer.valueOf(i), Integer.valueOf(fromDPToPix));
            }
            this.yjr = Math.min(min, fromDPToPix);
            this.yjs = Math.min(3, this.yjv);
            this.yjt = Math.min(this.yjv - this.yjs, Math.max(0, this.yjr - (this.yjs >> 1)));
            this.yju = (this.yjt + this.yjs) - 1;
            x.d("MicroMsg.MMGridPaper", "initSubGrid:item[%ddp,%ddp], row[%d], column[%d], activePage[%d], virtualPage[%d], curVirtualPage[%d], edge[%d, %d]", Integer.valueOf(this.yjA), Integer.valueOf(this.yjB), Integer.valueOf(this.lkz), Integer.valueOf(this.mNumColumns), Integer.valueOf(this.yjs), Integer.valueOf(this.yjv), Integer.valueOf(this.yjr), Integer.valueOf(this.yjt), Integer.valueOf(this.yju));
            MMGridPaperGridView mMGridPaperGridView;
            if (this.yjm.getChildCount() != this.yjs || this.yjw) {
                x.w("MicroMsg.MMGridPaper", "error child count or RowOrColChanged(%B), reset child view", Boolean.valueOf(this.yjw));
                this.yjw = false;
                this.yjm.removeAllViews();
                fromDPToPix = this.yjt;
                while (true) {
                    int i3 = fromDPToPix;
                    if (i3 <= this.yju) {
                        mMGridPaperGridView = (MMGridPaperGridView) inflate(getContext(), h.gZh, null);
                        mMGridPaperGridView.a(i3, this.lkz, this.mNumColumns, this.yjn);
                        mMGridPaperGridView.setHorizontalSpacing(com.tencent.mm.bu.a.fromDPToPix(getContext(), this.ygr));
                        mMGridPaperGridView.setVerticalSpacing(com.tencent.mm.bu.a.fromDPToPix(getContext(), this.ygs));
                        this.yjm.addView(mMGridPaperGridView, new LayoutParams(-1, -1));
                        fromDPToPix = i3 + 1;
                    }
                }
            } else {
                fromDPToPix = this.yjt;
                while (true) {
                    fromDPToPix2 = fromDPToPix;
                    if (fromDPToPix2 <= this.yju) {
                        mMGridPaperGridView = (MMGridPaperGridView) this.yjm.getChildAt(fromDPToPix2 - this.yjt);
                        if (mMGridPaperGridView.mIndex != fromDPToPix2) {
                            x.w("MicroMsg.MMGridPaper", "old index %d, new index %d, reset it", Integer.valueOf(mMGridPaperGridView.mIndex), Integer.valueOf(fromDPToPix2));
                            mMGridPaperGridView.a(fromDPToPix2, this.lkz, this.mNumColumns, this.yjn);
                            if (mMGridPaperGridView.yjV != null) {
                                mMGridPaperGridView.yjV.notifyDataSetChanged();
                            }
                        } else {
                            x.v("MicroMsg.MMGridPaper", "same grid index, continus");
                        }
                        fromDPToPix = fromDPToPix2 + 1;
                    }
                }
            }
            cpY();
            return;
        }
        cpW();
    }

    private static int eS(int i, int i2) {
        if (i2 <= 0) {
            x.w("MicroMsg.MMGridPaper", "ceil:total[%d], length[%d]", Integer.valueOf(i), Integer.valueOf(i2));
            return 0;
        }
        int i3 = i;
        int i4 = 0;
        while (i3 > 0) {
            i3 -= i2;
            i4++;
        }
        x.i("MicroMsg.MMGridPaper", "ceil:num[%d], length[%d], result[%d]", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i4));
        return i4;
    }

    private void cpY() {
        x.v("MicroMsg.MMGridPaper", "set DotView");
        Assert.assertTrue(this.yjv >= 0);
        this.kgN.Fa(this.yjv);
        if (this.yjn == null || this.yjv <= 1) {
            this.kgN.setVisibility(8);
            x.v("MicroMsg.MMGridPaper", "set DotView gone");
        } else {
            this.kgN.setVisibility(0);
            x.v("MicroMsg.MMGridPaper", "set DotView visible");
        }
        if (this.yjr >= this.yjv) {
            this.yjr = this.yjv - 1;
        }
        this.yjm.Fc(this.yjr - this.yjt);
        this.yjm.Fd(this.yjr);
        this.kgN.Fb(this.yjr);
    }

    protected final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        x.d("MicroMsg.MMGridPaper", "onLayout left=%s top=%s right=%s bottom=%s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4));
        if (this.yjG != cbS()) {
            this.yjG = cbS();
            x.d("MicroMsg.MMGridPaper", "onLayout, currentOrientation changed, reAdjustDisplayArea");
            this.yjC = true;
            clearAnimation();
            cpW();
            cpX();
        }
        super.onLayout(z, i, i2, i3, i4);
    }

    @TargetApi(8)
    public final void onConfigurationChanged(Configuration configuration) {
        if (configuration.orientation == 1 || configuration.orientation == 2) {
            x.d("MicroMsg.MMGridPaper", "onConfigChanged:" + configuration.orientation);
            this.yjC = true;
        }
    }
}
