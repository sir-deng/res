package com.tencent.mm.plugin.favorite.ui.base;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.mm.R;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.a.f;
import com.tencent.mm.plugin.favorite.a.j;
import com.tencent.mm.plugin.favorite.h;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.x;
import java.util.List;

public final class c extends LinearLayout {
    private View mAI;
    public View mAJ;
    public View mAK;
    public a mAL;
    private boolean mAM = false;
    private boolean mAN = false;
    private int mAO;

    public interface a {
        void aJU();
    }

    public c(Context context) {
        super(context);
        setOrientation(1);
        MarginLayoutParams layoutParams = new LayoutParams(-1, -2);
        this.mAI = View.inflate(getContext(), R.i.dhN, null);
        View inflate = View.inflate(getContext(), R.i.dhA, null);
        inflate.findViewById(R.h.cBK).setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                if (c.this.mAO == 1 || c.this.mAO == 3) {
                    x.i("MicroMsg.FavHeaderView", "click clear fav item");
                    if (c.this.mAL != null) {
                        c.this.mAL.aJU();
                    }
                }
            }
        });
        this.mAJ = inflate;
        inflate = View.inflate(getContext(), R.i.dhM, null);
        inflate.findViewById(R.h.chw).setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                x.i("MicroMsg.FavHeaderView", "click retry item");
                List<f> aIL = h.getFavItemInfoStorage().aIL();
                if (aIL != null && !aIL.isEmpty()) {
                    for (f fVar : aIL) {
                        if (fVar.aIt()) {
                            j.n(fVar);
                        } else {
                            x.w("MicroMsg.FavHeaderView", "item id is %d, status is not upload fail", Integer.valueOf(fVar.field_id));
                        }
                    }
                    c.this.mAK.setVisibility(8);
                    c.this.mAJ.setVisibility(8);
                }
            }
        });
        this.mAK = inflate;
        addView(this.mAI, new LayoutParams(layoutParams));
        addView(this.mAJ, new LayoutParams(layoutParams));
        addView(this.mAK, new LayoutParams(layoutParams));
    }

    public final void fh(boolean z) {
        this.mAI.setVisibility(z ? 0 : 8);
    }

    private void qf(int i) {
        this.mAO = i;
        x.i("MicroMsg.FavHeaderView", "showStatusBar status:" + i);
        if (i == 0) {
            this.mAK.setVisibility(8);
            this.mAJ.setVisibility(8);
        } else if (i == 1) {
            if (!this.mAM) {
                g.pWK.h(14109, Integer.valueOf(1));
            }
            this.mAM = true;
            this.mAK.setVisibility(8);
            this.mAJ.setVisibility(0);
            this.mAJ.findViewById(R.h.cBL).setVisibility(0);
            this.mAJ.findViewById(R.h.cBM).setVisibility(8);
        } else if (i == 2) {
            this.mAK.setVisibility(0);
            this.mAJ.setVisibility(8);
        } else if (i == 3) {
            if (!this.mAN) {
                g.pWK.h(14109, Integer.valueOf(0));
            }
            this.mAN = true;
            this.mAK.setVisibility(8);
            this.mAJ.setVisibility(0);
            this.mAJ.findViewById(R.h.cBL).setVisibility(8);
            this.mAJ.findViewById(R.h.cBM).setVisibility(0);
        }
    }

    public final void aKg() {
        long j;
        int i;
        List<f> aIL = h.getFavItemInfoStorage().aIL();
        if (aIL != null) {
            j = 0;
            i = 0;
            for (f a : aIL) {
                j = b.a(a) + j;
                i = 1;
            }
            x.i("MicroMsg.FavHeaderView", "triggerStatusBar uploadFailedItemList size:%d,totalSize:%d", Integer.valueOf(aIL.size()), Long.valueOf(j));
        } else {
            j = 0;
            i = 0;
        }
        if (i != 0) {
            if (j > j.aJr()) {
                qf(1);
            } else {
                qf(2);
            }
        } else if (j.aJv()) {
            qf(3);
        } else {
            qf(0);
        }
    }
}
