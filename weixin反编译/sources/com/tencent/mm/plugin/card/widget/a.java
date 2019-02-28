package com.tencent.mm.plugin.card.widget;

import android.content.Context;
import android.graphics.drawable.ShapeDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.card.b.m;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public abstract class a implements g {
    protected LayoutInflater DF;
    private final String TAG = "MicroMsg.CardWidgetCouponBase";
    protected OnClickListener iqi;
    protected b kOv;
    protected View ldH;
    protected ImageView ldI;
    protected TextView ldJ;
    protected Context mContext;

    protected abstract void axU();

    protected abstract void axV();

    public a(Context context) {
        this.mContext = context;
    }

    public final void k(b bVar) {
        this.kOv = bVar;
    }

    public final View axS() {
        if (this.kOv == null || this.kOv.aui() == null) {
            x.e("MicroMsg.CardWidgetCouponBase", "mCardInfo == null or mCardInfo.getCardTpInfo() == null");
            return null;
        }
        int i;
        this.DF = (LayoutInflater) this.mContext.getSystemService("layout_inflater");
        LayoutInflater layoutInflater = this.DF;
        if (!this.kOv.atQ()) {
            if (this.kOv.atR()) {
                i = R.i.dcQ;
            } else if (this.kOv.atP()) {
                i = R.i.dcw;
            } else if (this.kOv.atS()) {
                i = R.i.dcd;
            } else if (this.kOv.atT()) {
                i = R.i.dco;
            }
            this.ldH = layoutInflater.inflate(i, null);
            this.ldI = (ImageView) this.ldH.findViewById(R.h.bKC);
            this.ldJ = (TextView) this.ldH.findViewById(R.h.app_name);
            axU();
            amN();
            return this.ldH;
        }
        i = R.i.dbZ;
        this.ldH = layoutInflater.inflate(i, null);
        this.ldI = (ImageView) this.ldH.findViewById(R.h.bKC);
        this.ldJ = (TextView) this.ldH.findViewById(R.h.app_name);
        axU();
        amN();
        return this.ldH;
    }

    private void amN() {
        if (this.kOv == null || this.kOv.aui() == null) {
            x.e("MicroMsg.CardWidgetCouponBase", "mCardInfo == null or mCardInfo.getCardTpInfo() == null");
            return;
        }
        if (!bi.oN(this.kOv.aui().kPA)) {
            int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(R.f.bwn);
            if (this.kOv.atN() && this.kOv.atQ()) {
                dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(R.f.bwl);
            } else if (this.kOv.atN() && this.kOv.atP()) {
                dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(R.f.bwB);
            } else if (this.kOv.atN() && this.kOv.atR()) {
                dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(R.f.bwH);
            } else if (this.kOv.atT()) {
                dimensionPixelSize = 0;
            }
            if (dimensionPixelSize > 0) {
                m.a(this.ldI, this.kOv.aui().kPA, dimensionPixelSize, R.g.bDU, true);
            }
        }
        if (!bi.oN(this.kOv.aui().kQL)) {
            this.ldJ.setText(this.kOv.aui().kQL);
        }
        axV();
    }

    protected final View axT() {
        return this.ldH;
    }

    public final void release() {
        this.iqi = null;
        this.mContext = null;
    }

    public void ot(int i) {
    }

    public void ej(boolean z) {
    }

    public final void f(b bVar) {
        this.kOv = bVar;
        amN();
    }

    public void a(ShapeDrawable shapeDrawable) {
    }

    public void ek(boolean z) {
    }

    public void r(boolean z, boolean z2) {
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        this.iqi = onClickListener;
    }
}
