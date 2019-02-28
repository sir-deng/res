package com.tencent.mm.plugin.product.ui;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AutoCompleteTextView;
import com.tencent.mm.plugin.product.a.a;
import com.tencent.mm.plugin.product.b.c;
import com.tencent.mm.plugin.product.b.d;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.protocal.c.bcn;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.u;

public class MallProductReceiptUI extends MallBaseUI {
    private d plF = null;
    private AutoCompleteTextView plG = null;
    private h plH = null;
    private c plp;

    protected final int getLayoutId() {
        return g.uKb;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.plF = a.bjs().bju();
        a.bjs();
        this.plp = a.bjt();
        initView();
    }

    public final void initView() {
        setMMTitle(i.uSa);
        addTextOptionMenu(0, getString(i.dFw), new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                int i = 0;
                String obj = MallProductReceiptUI.this.plG.getText().toString();
                if (bi.oN(obj)) {
                    u.makeText(MallProductReceiptUI.this, i.uRZ, 0).show();
                } else {
                    c b = MallProductReceiptUI.this.plp;
                    b.pjz = new bcn();
                    bcn bcn = b.pjz;
                    if (!bi.oN(obj)) {
                        i = 1;
                    }
                    bcn.wPp = i;
                    b.pjz.nlZ = obj;
                    MallProductReceiptUI.this.finish();
                }
                return true;
            }
        });
        this.plG = (AutoCompleteTextView) findViewById(f.uxh);
        bcn bjA = this.plp.bjA();
        if (!(bjA == null || bi.oN(bjA.nlZ))) {
            this.plG.setText(bjA.nlZ);
        }
        this.plG.setSelection(this.plG.getText().length());
        this.plH = new h(this);
        this.plG.setAdapter(this.plH);
        this.plG.setOnItemClickListener(new OnItemClickListener() {
            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                d c = MallProductReceiptUI.this.plF;
                CharSequence charSequence = (c.pjK == null || i >= c.pjK.size()) ? null : (String) c.pjK.get(i);
                x.d("MicroMsg.MallProductReceiptUI", "onItemClick receipt = " + charSequence);
                if (!bi.oN(charSequence)) {
                    MallProductReceiptUI.this.plG.setText(charSequence);
                }
            }
        });
        View.inflate(this.mController.xRr, g.uJZ, null).setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                d c = MallProductReceiptUI.this.plF;
                c.pjK.clear();
                c.bjN();
                MallProductReceiptUI.this.plH.notifyDataSetChanged();
            }
        });
    }
}
