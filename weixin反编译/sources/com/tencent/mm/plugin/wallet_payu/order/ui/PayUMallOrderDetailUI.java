package com.tencent.mm.plugin.wallet_payu.order.ui;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.ad.k;
import com.tencent.mm.plugin.wallet_payu.order.a.c;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.protocal.c.axl;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.e;

public class PayUMallOrderDetailUI extends WalletBaseUI {
    private TextView jIe;
    private TextView onI;
    private TextView pSp;
    private String pbT = "";
    private axl tja;
    private LinearLayout tjb;
    private LinearLayout tjc;
    private LinearLayout tjd;
    private LinearLayout tje;
    private LinearLayout tjf;
    private LinearLayout tjg;
    private LinearLayout tjh;
    private TextView tji;
    private TextView tjj;
    private TextView tjk;
    private TextView tjl;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        jl(1520);
        this.pbT = this.vf.getString("key_trans_id");
        if (bi.oN(this.pbT)) {
            x.e("MicroMsg.PayUMallOrderDetailUI", "hy: trans id is null");
            finish();
        }
        l(new c(this.pbT));
        this.tjb = (LinearLayout) findViewById(f.upT);
        this.tjc = (LinearLayout) findViewById(f.upH);
        this.tjd = (LinearLayout) findViewById(f.upK);
        this.tje = (LinearLayout) findViewById(f.upN);
        this.tjf = (LinearLayout) findViewById(f.upR);
        this.tjg = (LinearLayout) findViewById(f.upP);
        this.tjh = (LinearLayout) findViewById(f.upV);
        this.tji = (TextView) findViewById(f.upU);
        this.tjj = (TextView) findViewById(f.upI);
        this.tjk = (TextView) findViewById(f.upL);
        this.pSp = (TextView) findViewById(f.upO);
        this.onI = (TextView) findViewById(f.upS);
        this.jIe = (TextView) findViewById(f.upQ);
        this.tjl = (TextView) findViewById(f.upW);
        bOk();
    }

    private void bOk() {
        if (this.tja != null) {
            if (bi.oN(this.tja.pgO)) {
                this.tjb.setVisibility(8);
            } else {
                this.tjb.setVisibility(0);
                this.tji.setText(this.tja.pgO);
            }
            if (bi.oN(this.tja.pgY)) {
                this.tjc.setVisibility(8);
            } else {
                this.tjc.setVisibility(0);
                this.tjj.setText(this.tja.pgY);
            }
            if (bi.oN(this.tja.pgQ)) {
                this.tjd.setVisibility(8);
            } else {
                this.tjd.setVisibility(0);
                this.tjk.setText(this.tja.pgQ);
            }
            if (bi.oN(this.tja.pgU)) {
                this.tje.setVisibility(8);
            } else {
                this.tje.setVisibility(0);
                this.pSp.setText(e.d(((double) this.tja.wLB) / 100.0d, this.tja.pgU));
            }
            if (this.tja.pgR >= 0) {
                this.tjf.setVisibility(0);
                this.onI.setText(e.gT(this.tja.pgR));
            } else {
                this.tjf.setVisibility(8);
            }
            if (bi.oN(this.tja.pgS)) {
                this.tjg.setVisibility(8);
            } else {
                this.tjg.setVisibility(0);
                this.jIe.setText(this.tja.pgS);
            }
            switch (this.tja.pgW) {
                case 3:
                    this.tjl.setText(i.uVQ);
                    return;
                case 5:
                    this.tjl.setText(i.uYE);
                    return;
                default:
                    this.tjl.setText(i.vbF);
                    return;
            }
        }
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        if (i != 0 || i2 != 0) {
            return false;
        }
        if (kVar instanceof c) {
            this.tja = ((c) kVar).tiZ;
            bOk();
        }
        return true;
    }

    public void onDestroy() {
        super.onDestroy();
        jm(1520);
    }

    protected final int getLayoutId() {
        return g.uJO;
    }
}
