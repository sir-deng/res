package com.tencent.mm.plugin.product.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;

public class MallProductSelectAmountView extends LinearLayout {
    TextView ikp = null;
    private ImageView plJ = null;
    private ImageView plK = null;
    int plL = Integer.MAX_VALUE;
    int plM = 1;
    private int plN = 1;
    int plO = this.plN;
    a plP = null;

    public interface a {
        void dm(int i, int i2);

        void es(int i);
    }

    public MallProductSelectAmountView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        View inflate = ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(g.uKc, this, true);
        this.ikp = (TextView) inflate.findViewById(f.uxj);
        this.plJ = (ImageView) inflate.findViewById(f.uxi);
        this.plK = (ImageView) inflate.findViewById(f.uxo);
        this.ikp.setText(this.plO);
        this.plJ.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                if (MallProductSelectAmountView.this.plO + 1 <= MallProductSelectAmountView.this.plL) {
                    MallProductSelectAmountView.this.plO = MallProductSelectAmountView.this.plO + 1;
                    if (MallProductSelectAmountView.this.bjU()) {
                        MallProductSelectAmountView.this.ikp.setText(MallProductSelectAmountView.this.plO);
                    }
                    if (MallProductSelectAmountView.this.plP != null) {
                        MallProductSelectAmountView.this.plP.es(MallProductSelectAmountView.this.plO);
                    }
                } else if (MallProductSelectAmountView.this.plP != null) {
                    MallProductSelectAmountView.this.plP.dm(MallProductSelectAmountView.this.plO, MallProductSelectAmountView.this.plM);
                }
            }
        });
        this.plK.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                if (MallProductSelectAmountView.this.plO - 1 >= MallProductSelectAmountView.this.plN) {
                    MallProductSelectAmountView.this.plO = MallProductSelectAmountView.this.plO - 1;
                    if (MallProductSelectAmountView.this.bjU()) {
                        MallProductSelectAmountView.this.ikp.setText(MallProductSelectAmountView.this.plO);
                    }
                    MallProductSelectAmountView.this.bjU();
                    if (MallProductSelectAmountView.this.plP != null) {
                        MallProductSelectAmountView.this.plP.es(MallProductSelectAmountView.this.plO);
                    }
                } else if (MallProductSelectAmountView.this.plP != null) {
                    MallProductSelectAmountView.this.plP.dm(MallProductSelectAmountView.this.plO, 2);
                }
            }
        });
    }

    final boolean bjU() {
        if (this.plO > this.plL) {
            this.plO = this.plL;
            if (this.plP != null) {
                this.plP.es(this.plO);
            }
            if (this.plP != null) {
                this.plP.dm(this.plO, this.plM);
            }
            this.ikp.setText(this.plO);
            return false;
        }
        if (this.plO > this.plN) {
            this.plK.setEnabled(true);
        } else if (this.plO == this.plN) {
            this.plK.setEnabled(false);
        } else {
            this.plK.setEnabled(false);
            this.plO = this.plN;
            if (this.plP != null) {
                this.plP.es(this.plO);
            }
            if (this.plP != null) {
                this.plP.dm(this.plO, 2);
            }
            this.ikp.setText(this.plO);
            return false;
        }
        return true;
    }
}
