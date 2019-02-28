package com.tencent.mm.plugin.luckymoney.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.ad.k;
import com.tencent.mm.plugin.luckymoney.b.h;
import com.tencent.mm.plugin.luckymoney.b.y;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.ui.base.MMLoadMoreListView;
import com.tencent.mm.ui.base.MMLoadMoreListView.a;
import java.util.LinkedList;
import java.util.List;

public class LuckyMoneyCanShareListUI extends LuckyMoneyBaseUI {
    private boolean lGi = false;
    private MMLoadMoreListView omV;
    private d omW;
    private boolean omh = true;
    private List<h> omo = new LinkedList();
    private String omr = "";
    private int wn = 0;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
        aYg();
    }

    protected final void initView() {
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                LuckyMoneyCanShareListUI.this.finish();
                return true;
            }
        });
        this.omV = (MMLoadMoreListView) findViewById(f.uuN);
        setMMTitle(getString(i.uQP));
        this.omW = new e(this.mController.xRr);
        this.omV.setAdapter(this.omW);
        this.omV.setOnItemClickListener(new OnItemClickListener() {
            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                h sz = LuckyMoneyCanShareListUI.this.omW.sz((int) j);
                if (sz != null && !bi.oN(sz.oeH)) {
                    Intent intent = new Intent();
                    intent.setClass(LuckyMoneyCanShareListUI.this.mController.xRr, LuckyMoneyDetailUI.class);
                    intent.putExtra("key_sendid", sz.oeH);
                    LuckyMoneyCanShareListUI.this.startActivity(intent);
                }
            }
        });
        this.omV.ykC = new a() {
            public final void ayD() {
                if (LuckyMoneyCanShareListUI.this.omh && !LuckyMoneyCanShareListUI.this.lGi) {
                    LuckyMoneyCanShareListUI.this.aYg();
                }
            }
        };
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        if (!(kVar instanceof y) || i != 0 || i2 != 0) {
            return false;
        }
        y yVar = (y) kVar;
        List list = yVar.oiS.ohN;
        this.omr = yVar.oiI;
        if (list != null) {
            for (int i3 = 0; i3 < list.size(); i3++) {
                this.omo.add(list.get(i3));
            }
            this.wn += list.size();
            this.omh = yVar.aXO();
            this.lGi = false;
            this.omW.bf(this.omo);
        }
        if (this.omh) {
            this.omV.cqd();
        } else {
            this.omV.cqe();
        }
        return true;
    }

    protected final int getLayoutId() {
        return g.uJa;
    }

    private void aYg() {
        this.lGi = true;
        if (this.wn == 0) {
            this.omr = "";
        }
        l(new y(10, this.wn, 3, "", "v1.0", this.omr));
    }
}
