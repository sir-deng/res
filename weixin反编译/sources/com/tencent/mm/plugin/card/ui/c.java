package com.tencent.mm.plugin.card.ui;

import android.content.Context;
import android.database.Cursor;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mm.plugin.card.model.CardInfo;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.o;

public class c extends o<CardInfo> {
    private final String TAG = "MicroMsg.CardAdapter";
    private int count = 0;
    private com.tencent.mm.plugin.card.base.c kUm;
    private int kVT;

    public final /* synthetic */ Object a(Object obj, Cursor cursor) {
        CardInfo cardInfo = (CardInfo) obj;
        if (cardInfo == null) {
            cardInfo = new CardInfo();
        }
        if (cursor.isClosed()) {
            x.e("MicroMsg.CardAdapter", "cursor is closed!");
        } else {
            cardInfo.b(cursor);
        }
        return cardInfo;
    }

    public c(Context context, int i) {
        super(context, new CardInfo());
        this.kVT = i;
        mb(true);
        this.kUm = new l(context, this);
    }

    public void XH() {
        x.v("MicroMsg.CardAdapter", "resetCursor");
        Cursor nZ = am.avh().nZ(this.kVT);
        if (nZ != null) {
            this.count = nZ.getCount();
            x.v("MicroMsg.CardAdapter", "card count:" + this.count);
        }
        setCursor(nZ);
        notifyDataSetChanged();
    }

    protected void XI() {
        aUU();
        XH();
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        return this.kUm.a(i, view, (CardInfo) getItem(i));
    }

    public void release() {
        aUU();
        this.kUm.release();
        this.kUm = null;
    }
}
