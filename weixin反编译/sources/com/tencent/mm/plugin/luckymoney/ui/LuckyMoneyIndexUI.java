package com.tencent.mm.plugin.luckymoney.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.mm.ad.k;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.luckymoney.a.a;
import com.tencent.mm.plugin.luckymoney.b.c;
import com.tencent.mm.plugin.luckymoney.b.w;
import com.tencent.mm.plugin.walletlock.a.b;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.h.d;
import com.tencent.mm.ui.p;
import java.util.LinkedList;
import java.util.List;

public class LuckyMoneyIndexUI extends LuckyMoneyBaseUI {
    private int oli;
    private LinearLayout ons;
    private LinearLayout ont;
    private LinearLayout onu;

    static /* synthetic */ void a(LuckyMoneyIndexUI luckyMoneyIndexUI, int i) {
        Intent intent = new Intent();
        intent.setClass(luckyMoneyIndexUI.mController.xRr, LuckyMoneyPrepareUI.class);
        intent.putExtra("key_way", 3);
        intent.putExtra("key_type", i);
        intent.putExtra("pay_channel", luckyMoneyIndexUI.oli);
        luckyMoneyIndexUI.startActivity(intent);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ((b) g.h(b.class)).a(this, null);
        initView();
        b(new w("v1.0", (byte) 0), false);
        this.oli = getIntent().getIntExtra("pay_channel", -1);
        com.tencent.mm.plugin.report.service.g.pWK.h(11701, Integer.valueOf(3), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1));
    }

    protected void onResume() {
        super.onResume();
        b bVar = (b) g.h(b.class);
        bVar.a(this, bVar.bOm(), null);
    }

    protected final void initView() {
        setMMTitle(i.uRy);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                LuckyMoneyIndexUI.this.finish();
                return true;
            }
        });
        this.ons = (LinearLayout) findViewById(f.uuv);
        this.ont = (LinearLayout) findViewById(f.uut);
        this.onu = (LinearLayout) findViewById(f.uur);
        ((Button) findViewById(f.uuu)).setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                com.tencent.mm.plugin.report.service.g.pWK.h(11701, Integer.valueOf(3), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(3));
                LuckyMoneyIndexUI.a(LuckyMoneyIndexUI.this, 0);
            }
        });
        ((Button) findViewById(f.uus)).setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                com.tencent.mm.plugin.report.service.g.pWK.h(11701, Integer.valueOf(3), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(2));
                LuckyMoneyIndexUI.a(LuckyMoneyIndexUI.this, 1);
            }
        });
        a(0, getString(i.uQT), new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                com.tencent.mm.plugin.report.service.g.pWK.h(11701, Integer.valueOf(3), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(4));
                List linkedList = new LinkedList();
                List linkedList2 = new LinkedList();
                linkedList.add(LuckyMoneyIndexUI.this.getString(i.uQV));
                linkedList2.add(Integer.valueOf(0));
                linkedList.add(LuckyMoneyIndexUI.this.getString(i.uQW));
                linkedList2.add(Integer.valueOf(1));
                h.a(LuckyMoneyIndexUI.this.mController.xRr, "", linkedList, linkedList2, "", false, new d() {
                    public final void cr(int i, int i2) {
                        int i3 = 1;
                        switch (i2) {
                            case 1:
                                com.tencent.mm.plugin.report.service.g.pWK.h(11701, Integer.valueOf(3), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(6));
                                break;
                            default:
                                com.tencent.mm.plugin.report.service.g.pWK.h(11701, Integer.valueOf(3), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(5));
                                i3 = 2;
                                break;
                        }
                        Intent intent = new Intent();
                        intent.setClass(LuckyMoneyIndexUI.this.mController.xRr, LuckyMoneyMyRecordUI.class);
                        intent.putExtra("key_type", i3);
                        LuckyMoneyIndexUI.this.startActivity(intent);
                    }
                });
                return true;
            }
        }, p.b.xSl);
        aYj();
    }

    private void aYj() {
        a.aXv();
        c aXH = a.aXw().aXH();
        if (aXH != null) {
            ImageView imageView = (ImageView) findViewById(f.ujB);
            if ((aXH.ohm & 1) == 1) {
                x.i("MicroMsg.LuckyMoneyIndexUI", "initView: topBg use money bg");
                imageView.setImageResource(e.ujB);
                return;
            }
            imageView.setImageResource(e.ujC);
        }
    }

    protected final int getLayoutId() {
        return com.tencent.mm.plugin.wxpay.a.g.uIW;
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        if (!(kVar instanceof w)) {
            return false;
        }
        if (i == 0 && i2 == 0) {
            w wVar = (w) kVar;
            g.c cVar = new g.c();
            cVar.textColor = getResources().getColor(com.tencent.mm.plugin.wxpay.a.c.uhu);
            cVar.ooX = 101;
            g.a(this, this.ons, wVar.ohJ, cVar, "Text");
            cVar = new g.c();
            cVar.textColor = getResources().getColor(com.tencent.mm.plugin.wxpay.a.c.uhu);
            cVar.ooX = 100;
            g.a(this, this.ont, wVar.oiP, cVar, "Text");
            cVar = new g.c();
            cVar.ooX = 102;
            g.a(this, this.onu, wVar.oiN, cVar, "Pic");
            aYj();
        }
        return true;
    }
}
