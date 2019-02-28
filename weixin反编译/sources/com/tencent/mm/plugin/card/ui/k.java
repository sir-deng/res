package com.tencent.mm.plugin.card.ui;

import android.content.Context;
import android.database.Cursor;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mm.plugin.card.base.c;
import com.tencent.mm.plugin.card.model.CardInfo;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.ui.view.aa;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;

public final class k extends c {
    private final String TAG = "MicroMsg.CardTicketAdapter";
    private int count = 0;
    private c kUm;
    private int kVT;
    private final String lbi = "PRIVATE_TICKET_TITLE";
    private final String lbj = "PRIVATE_INVOICE_TITLE";
    private ArrayList<CardInfo> lbk;
    private ArrayList<CardInfo> lbl;
    private ArrayList<CardInfo> lbm;

    public final /* synthetic */ Object getItem(int i) {
        return oh(i);
    }

    public k(Context context, int i) {
        super(context, i);
        this.kVT = i;
        this.kUm = new aa(context, this);
        this.lbk = new ArrayList();
        this.lbl = new ArrayList();
        this.lbm = new ArrayList();
    }

    private void awU() {
        CardInfo cardInfo;
        int i = 0;
        this.lbk.clear();
        this.lbl.clear();
        this.lbm.clear();
        while (true) {
            int i2 = i;
            if (i2 >= this.count) {
                break;
            }
            cardInfo = (CardInfo) super.getItem(i2);
            if (cardInfo != null) {
                if (cardInfo.atT()) {
                    this.lbm.add(cardInfo);
                } else {
                    this.lbl.add(cardInfo);
                }
            }
            i = i2 + 1;
        }
        if (!this.lbl.isEmpty()) {
            cardInfo = new CardInfo();
            cardInfo.field_card_id = "PRIVATE_TICKET_TITLE";
            this.lbk.add(cardInfo);
            this.lbk.addAll(this.lbl);
        }
        if (!this.lbm.isEmpty()) {
            cardInfo = new CardInfo();
            cardInfo.field_card_id = "PRIVATE_INVOICE_TITLE";
            this.lbk.add(cardInfo);
            this.lbk.addAll(this.lbm);
        }
        this.count = this.lbk.size();
    }

    public final void XH() {
        x.v("MicroMsg.CardTicketAdapter", "resetCursor");
        Cursor nZ = am.avh().nZ(this.kVT);
        if (nZ != null) {
            this.count = nZ.getCount();
            x.v("MicroMsg.CardTicketAdapter", "card count:" + this.count);
        }
        setCursor(nZ);
        awU();
        notifyDataSetChanged();
    }

    protected final void XI() {
        aUU();
        XH();
    }

    private CardInfo oh(int i) {
        return (CardInfo) this.lbk.get(i);
    }

    public final int getItemViewType(int i) {
        CardInfo oh = oh(i);
        if (oh.field_card_id.equals("PRIVATE_TICKET_TITLE") || oh.field_card_id.equals("PRIVATE_INVOICE_TITLE")) {
            return 0;
        }
        if (oh.atT()) {
            return 2;
        }
        return 1;
    }

    public final int getCount() {
        if (this.lbk.isEmpty()) {
            return super.getCount();
        }
        return this.lbk.size();
    }

    public final int getViewTypeCount() {
        return 3;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        return this.kUm.a(i, view, oh(i));
    }

    public final void release() {
        aUU();
        this.kUm.release();
        this.kUm = null;
    }
}
