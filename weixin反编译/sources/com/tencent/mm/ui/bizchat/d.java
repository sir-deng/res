package com.tencent.mm.ui.bizchat;

import android.database.Cursor;
import com.tencent.mm.R;
import com.tencent.mm.af.a.c;
import com.tencent.mm.af.a.j;
import com.tencent.mm.af.y;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.contact.MMBaseSelectContactUI;
import com.tencent.mm.ui.contact.a.a;
import com.tencent.mm.ui.contact.a.g;
import com.tencent.mm.ui.contact.o;

public final class d extends o implements b {
    private Cursor ilb;
    private String kMt;
    private int pUr;

    public d(MMBaseSelectContactUI mMBaseSelectContactUI, String str) {
        super(mMBaseSelectContactUI, null, false, false);
        x.i("MicroMsg.RecentConversationAdapter", "create!");
        this.kMt = str;
        aJO();
    }

    private void aJO() {
        x.i("MicroMsg.RecentConversationAdapter", "resetData");
        if (this.ilb != null) {
            this.ilb.close();
            this.ilb = null;
        }
        this.ilb = y.Mo().km(this.kMt);
        this.pUr = 0;
    }

    public final int getCount() {
        return this.ilb.getCount() + 1;
    }

    protected final a je(int i) {
        a gVar;
        if (i == this.pUr) {
            gVar = new g(i);
            gVar.mVt = this.zbQ.getActivity().getResources().getString(R.l.eJA);
            return gVar;
        } else if (i <= this.pUr || !this.ilb.moveToPosition((i - this.pUr) - 1)) {
            x.e("MicroMsg.RecentConversationAdapter", "create Data Item Error position=%d", Integer.valueOf(i));
            return null;
        } else {
            gVar = new a(i);
            com.tencent.mm.af.a.a aVar = new com.tencent.mm.af.a.a();
            aVar.b(this.ilb);
            if (gVar.kMn != -1) {
                return gVar;
            }
            gVar.kMn = aVar.field_bizChatId;
            c ag = y.Mn().ag(aVar.field_bizChatId);
            if (ag.Mz()) {
                gVar.ikG = ag.field_chatName;
                gVar.yvP = ag.field_headImageUrl;
                gVar.username = ag.field_brandUserName;
            } else {
                j ca = y.Mp().ca(ag.field_bizChatServId);
                if (ca != null) {
                    gVar.ikG = ca.field_userName;
                    gVar.yvP = ca.field_headImageUrl;
                    gVar.username = ca.field_brandUserName;
                }
            }
            if (bi.N(gVar.ikG)) {
                gVar.ikG = this.zbQ.getActivity().getResources().getString(R.l.eFK);
            }
            if (!bi.oN(gVar.username)) {
                return gVar;
            }
            gVar.username = aVar.field_brandUserName;
            return gVar;
        }
    }

    public final void finish() {
        super.finish();
        x.i("MicroMsg.RecentConversationAdapter", "finish!");
        if (this.ilb != null) {
            this.ilb.close();
            this.ilb = null;
        }
    }

    public final void a(int i, m mVar, Object obj) {
        aJO();
        notifyDataSetChanged();
    }
}
