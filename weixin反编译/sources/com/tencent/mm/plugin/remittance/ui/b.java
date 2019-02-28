package com.tencent.mm.plugin.remittance.ui;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.plugin.wxpay.a.j;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.wallet_core.ui.e;

public final class b extends k implements OnClickListener {
    private int itU;
    protected View kTo;
    private OnClickListener pUo;

    private b(Context context) {
        this(context, (byte) 0);
    }

    private b(Context context, byte b) {
        super(context, j.vfj);
        this.itU = 0;
        int i = g.uKC;
        if (i > 0) {
            this.kTo = View.inflate(context, i, null);
        }
        setContentView(this.kTo);
        ((Button) this.kTo.findViewById(f.bPp)).setOnClickListener(this);
        ((Button) this.kTo.findViewById(f.urt)).setOnClickListener(this);
    }

    public final void onClick(View view) {
        if (view.getId() != f.cBI) {
            x.i("RemittanceChargeDialog", "click cancel");
            dismiss();
        }
        if (view.getId() != f.bPp) {
            return;
        }
        if (this.itU == 1) {
            com.tencent.mm.plugin.report.service.g.pWK.h(12689, Integer.valueOf(11), Integer.valueOf(1));
            return;
        }
        com.tencent.mm.plugin.report.service.g.pWK.h(12689, Integer.valueOf(2), Integer.valueOf(1));
    }

    public static void a(Context context, int i, String str, double d) {
        x.i("RemittanceChargeDialog", "showAlert");
        Dialog bVar = new b(context);
        bVar.itU = i;
        x.i("RemittanceChargeDialog", "showTips");
        TextView textView = (TextView) bVar.findViewById(f.uCm);
        if (bi.oN(str)) {
            x.e("RemittanceChargeDialog", "desc is null");
        } else {
            textView.setText(str);
            textView.setVisibility(0);
        }
        ((TextView) bVar.findViewById(f.urv)).setText(context.getResources().getString(i.uUv, new Object[]{e.u(d)}));
        bVar.findViewById(f.uDE).setVisibility(0);
        bVar.findViewById(f.urw).setVisibility(0);
        bVar.show();
        h.a(context, bVar);
    }

    public static b a(Context context, int i, double d, double d2, double d3, String str, OnClickListener onClickListener) {
        x.i("RemittanceChargeDialog", "showCostDetail");
        Dialog bVar = new b(context);
        bVar.itU = i;
        if (d == 0.0d) {
            x.i("RemittanceChargeDialog", "showCostDetail ::: remian_fee = 0");
        }
        ((TextView) bVar.findViewById(f.uCH)).setText(e.u(d));
        ((TextView) bVar.findViewById(f.uqy)).setText(e.u(d2));
        if (d3 == 0.0d) {
            x.e("RemittanceChargeDialog", "showCostDetail ::: transaction_costs = 0");
        }
        ((TextView) bVar.findViewById(f.uDN)).setText(e.u(d3));
        bVar.findViewById(f.uCb).setVisibility(0);
        if (!bi.oN(str)) {
            TextView textView = (TextView) bVar.findViewById(f.uCm);
            textView.setText(str);
            textView.setVisibility(0);
        }
        bVar.findViewById(f.uDG).setVisibility(0);
        bVar.pUo = onClickListener;
        bVar.findViewById(f.cBI).setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                if (b.this.pUo != null) {
                    b.this.pUo.onClick(view);
                    b.this.dismiss();
                }
            }
        });
        bVar.show();
        h.a(context, bVar);
        if (i == 1) {
            com.tencent.mm.plugin.report.service.g.pWK.h(12689, Integer.valueOf(10), Integer.valueOf(1));
        } else {
            com.tencent.mm.plugin.report.service.g.pWK.h(12689, Integer.valueOf(1), Integer.valueOf(1));
        }
        return bVar;
    }
}
