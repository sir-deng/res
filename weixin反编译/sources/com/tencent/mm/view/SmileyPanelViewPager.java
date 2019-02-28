package com.tencent.mm.view;

import android.content.Context;
import android.os.Build.VERSION;
import android.support.v4.view.u;
import android.util.AttributeSet;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.CustomViewPager;
import com.tencent.mm.view.a.d;

public class SmileyPanelViewPager extends CustomViewPager {
    private final String TAG = "MicroMsg.emoji.SmileyPanel.SmileyPanelViewPager";
    private int kgV = 0;
    private int kgW = 0;
    public com.tencent.mm.view.f.a zMB;
    public a zNc;
    private boolean zNd = j.aS(getContext());

    public interface a {
        void HJ(int i);
    }

    public SmileyPanelViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        if (bi.getInt(VERSION.SDK, 0) >= 9) {
            setOverScrollMode(2);
        }
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        x.d("MicroMsg.emoji.SmileyPanel.SmileyPanelViewPager", "alvinluo w: %d, h: %d, oldw: %d, oldh: %d", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4));
        boolean aS = j.aS(getContext());
        if (this.zMB != null && (((i > 0 && i3 != i) || (i2 > 0 && i4 != i2)) && ((i2 > 0 && i2 != this.kgV) || (i > 0 && i != this.kgW)))) {
            if (this.zMB.kgS <= 0) {
                this.zMB.HP(i2);
            }
            this.zMB.kgT = i;
            this.zMB.znV = 0;
            if (!(this.zNc == null || (this.zMB.zPW && !this.zMB.zPX && this.zNd == aS))) {
                x.d("MicroMsg.emoji.SmileyPanel.SmileyPanelViewPager", "need deal cache size.");
                this.zMB.zPX = false;
                this.zNc.HJ(i2);
            }
        }
        this.zNd = aS;
        if (i2 > 0) {
            this.kgV = i2;
        }
        if (i > 0) {
            this.kgW = i;
        }
    }

    public final void a(u uVar) {
        super.a(uVar);
    }

    public final void a(d dVar) {
        if (dVar != null) {
            dVar.cBi();
            dVar.zNC = false;
        }
        super.a((u) dVar);
    }
}
