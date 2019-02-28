package com.tencent.mm.plugin.card.ui;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.R;
import com.tencent.mm.ad.k;
import com.tencent.mm.plugin.card.b.d;
import com.tencent.mm.plugin.card.base.CardBaseUI;
import com.tencent.mm.plugin.card.model.CardInfo;
import com.tencent.mm.plugin.card.model.n.a;
import com.tencent.mm.plugin.card.model.r;
import com.tencent.mm.ui.base.h;
import java.util.LinkedList;

public class CardInvalidCardUI extends CardBaseUI {
    static /* synthetic */ LinkedList c(CardInvalidCardUI cardInvalidCardUI) {
        LinkedList linkedList = new LinkedList();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= cardInvalidCardUI.kNQ.getCount()) {
                return linkedList;
            }
            CardInfo cardInfo = (CardInfo) cardInvalidCardUI.kNW.nV(i2);
            if (cardInfo != null) {
                linkedList.add(cardInfo.field_card_id);
            }
            i = i2 + 1;
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        super.initView();
    }

    protected final void initView() {
        super.initView();
    }

    protected final int atA() {
        return a.kRs;
    }

    protected final void atz() {
        setMMTitle(R.l.dOC);
        addTextOptionMenu(0, getString(R.l.dNX), new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                d.a(CardInvalidCardUI.this, new d.a() {
                    public final void awH() {
                        CardInvalidCardUI.this.kNU = true;
                        CardInvalidCardUI.this.C(CardInvalidCardUI.c(CardInvalidCardUI.this));
                    }
                });
                return true;
            }
        });
        if (this.kNQ.getCount() > 0) {
            enableOptionMenu(true);
        } else {
            enableOptionMenu(false);
        }
    }

    protected final int getLayoutId() {
        return R.i.dcn;
    }

    public final void a(int i, int i2, String str, k kVar) {
        super.a(i, i2, str, kVar);
        if (i == 0 && i2 == 0 && (kVar instanceof r)) {
            if (this.kNU) {
                h.bu(this, getResources().getString(R.l.dNZ));
            } else {
                h.bu(this, getResources().getString(R.l.dOj));
            }
        }
        this.kNU = false;
    }
}
