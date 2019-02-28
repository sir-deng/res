package com.tencent.mm.plugin.sns.lucky.ui;

import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import com.tencent.mm.ad.k;
import com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyBaseUI;
import com.tencent.mm.plugin.q.a;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import java.util.LinkedList;
import java.util.List;

public class SnsLuckyMoneyDetailUI extends LuckyMoneyBaseUI {
    private ListView olW;
    OnScrollListener omt = new OnScrollListener() {
        private boolean omu = false;
        private boolean omv;

        public final void onScrollStateChanged(AbsListView absListView, int i) {
            if (absListView.getCount() != 0) {
                switch (i) {
                    case 0:
                        this.omu = false;
                        return;
                    case 1:
                        this.omu = true;
                        return;
                    default:
                        return;
                }
            }
        }

        public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
            boolean z = true;
            if (i3 != 0 && this.omu) {
                if (i <= 0) {
                    int top;
                    View childAt = absListView.getChildAt(i);
                    if (childAt != null) {
                        top = 0 - childAt.getTop();
                    } else {
                        top = 0;
                    }
                    if (top <= 100) {
                        z = false;
                    }
                }
                if (this.omv != z) {
                    if (z) {
                        SnsLuckyMoneyDetailUI.this.r(SnsLuckyMoneyDetailUI.this.getResources().getDrawable(c.uhO));
                    } else {
                        SnsLuckyMoneyDetailUI.this.r(null);
                    }
                    this.omv = z;
                }
            }
        }
    };
    private final int onp = 750;
    private final int onq = 240;
    private b qYh;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
        List Ey = a.Ey(getIntent().getStringExtra("key_feedid"));
        if (!(Ey == null || Ey.size() == 0)) {
            b bVar = this.qYh;
            if (Ey == null) {
                LinkedList linkedList = new LinkedList();
            } else {
                bVar.omo = Ey;
            }
            bVar.notifyDataSetChanged();
        }
        cnG();
        if (VERSION.SDK_INT >= 21) {
            getWindow().setStatusBarColor(getResources().getColor(c.uhP));
        }
        setMMSubTitle(null);
    }

    protected final void initView() {
        r(getResources().getDrawable(e.uji));
        setMMTitle(i.uUP);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                SnsLuckyMoneyDetailUI.this.finish();
                return true;
            }
        });
        this.olW = (ListView) findViewById(f.utS);
        this.qYh = new b(this.mController.xRr);
        this.olW.setAdapter(this.qYh);
        this.olW.setOnScrollListener(this.omt);
        this.olW.setOnItemClickListener(new OnItemClickListener() {
            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            }
        });
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent);
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        return false;
    }

    protected final int getLayoutId() {
        return g.uKL;
    }

    protected void onDestroy() {
        super.onDestroy();
    }
}
