package com.tencent.mm.plugin.luckymoney.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public class LuckyMoneyAutoScrollView extends RelativeLayout implements b {
    private View contentView;
    private Context mContext;
    private RelativeLayout olF;
    private RelativeLayout olG;
    private RelativeLayout olH;
    LuckyMoneyAutoScrollItem olI;
    LuckyMoneyAutoScrollItem olJ;
    LuckyMoneyAutoScrollItem olK;
    ImageView olL;
    ImageView olM;
    ImageView olN;
    private String olO;
    private String olP;
    private String olQ;
    boolean olR;
    private a olS;

    public interface a {
        void aYd();
    }

    public LuckyMoneyAutoScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.olO = "0";
        this.olP = "0";
        this.olQ = "0";
        this.olR = false;
        this.mContext = context;
        View inflate = LayoutInflater.from(this.mContext).inflate(g.uIK, this);
        this.contentView = inflate;
        this.olI = (LuckyMoneyAutoScrollItem) inflate.findViewById(f.ula);
        this.olJ = (LuckyMoneyAutoScrollItem) inflate.findViewById(f.ulb);
        this.olK = (LuckyMoneyAutoScrollItem) inflate.findViewById(f.ulc);
        this.olL = (ImageView) inflate.findViewById(f.uDp);
        this.olM = (ImageView) inflate.findViewById(f.uDq);
        this.olN = (ImageView) inflate.findViewById(f.uDr);
        this.olF = (RelativeLayout) inflate.findViewById(f.urH);
        this.olG = (RelativeLayout) inflate.findViewById(f.urI);
        this.olH = (RelativeLayout) inflate.findViewById(f.urJ);
    }

    public LuckyMoneyAutoScrollView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public final void ED(String str) {
        x.i("MicroMsg.LuckyMoneyAutoScrollView", "hy: setting text: %s", str);
        this.olO = str.substring(0, 1);
        this.olP = str.substring(2, 3);
        this.olQ = str.substring(3, 4);
        this.olI.olv = bi.getInt(this.olO, 0);
        this.olJ.olv = bi.getInt(this.olP, 0);
        this.olK.olv = bi.getInt(this.olQ, 0);
        this.olL.setImageResource(((Integer) LuckyMoneyAutoScrollItem.olz.get(bi.getInt(this.olO, 0))).intValue());
        this.olM.setImageResource(((Integer) LuckyMoneyAutoScrollItem.olz.get(bi.getInt(this.olP, 0))).intValue());
        this.olN.setImageResource(((Integer) LuckyMoneyAutoScrollItem.olz.get(bi.getInt(this.olQ, 0))).intValue());
        this.olL.setVisibility(4);
        this.olM.setVisibility(4);
        this.olN.setVisibility(4);
        this.olI.oly = this;
        this.olJ.oly = this;
        this.olK.oly = this;
        x.i("MicroMsg.LuckyMoneyAutoScrollView", "hy: first: %s, second :%s, third: %s", this.olO, this.olP, this.olQ);
    }

    public final void a(a aVar) {
        this.olS = aVar;
        ah.y(new Runnable() {
            public final void run() {
                LuckyMoneyAutoScrollView.this.olI.aYb();
                LuckyMoneyAutoScrollView.this.olJ.aYb();
                LuckyMoneyAutoScrollView.this.olK.aYb();
            }
        });
    }

    public final void aYc() {
        if (!this.olR) {
            this.olR = true;
            ah.y(new Runnable() {
                public final void run() {
                    LuckyMoneyAutoScrollView.this.olI.setVisibility(8);
                    LuckyMoneyAutoScrollView.this.olJ.setVisibility(8);
                    LuckyMoneyAutoScrollView.this.olK.setVisibility(8);
                    LuckyMoneyAutoScrollView.this.olL.setVisibility(0);
                    LuckyMoneyAutoScrollView.this.olM.setVisibility(0);
                    LuckyMoneyAutoScrollView.this.olN.setVisibility(0);
                    if (LuckyMoneyAutoScrollView.this.olS != null) {
                        LuckyMoneyAutoScrollView.this.olS.aYd();
                    }
                }
            });
        }
    }

    public final void cP(int i, int i2) {
        if (i > 0 && i2 > 0) {
            LayoutParams layoutParams = (LayoutParams) this.contentView.getLayoutParams();
            layoutParams.height = i2;
            this.contentView.setLayoutParams(layoutParams);
            this.contentView.invalidate();
            layoutParams = (LayoutParams) this.olF.getLayoutParams();
            layoutParams.height = i2;
            layoutParams.width = i;
            this.olF.setLayoutParams(layoutParams);
            this.olF.invalidate();
            layoutParams = (LayoutParams) this.olG.getLayoutParams();
            layoutParams.height = i2;
            layoutParams.width = i;
            this.olG.setLayoutParams(layoutParams);
            this.olG.invalidate();
            layoutParams = (LayoutParams) this.olH.getLayoutParams();
            layoutParams.height = i2;
            layoutParams.width = i;
            layoutParams.leftMargin = 0;
            this.olH.setLayoutParams(layoutParams);
            this.olH.invalidate();
        }
    }
}
