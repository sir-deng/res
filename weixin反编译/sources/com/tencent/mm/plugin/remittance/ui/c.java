package com.tencent.mm.plugin.remittance.ui;

import android.database.Cursor;
import android.database.MergeCursor;
import com.tencent.mm.f.b.ak;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ae;
import com.tencent.mm.ui.contact.MMBaseSelectContactUI;
import com.tencent.mm.ui.contact.a.a;
import com.tencent.mm.ui.contact.a.e;
import com.tencent.mm.ui.contact.o;
import com.tencent.mm.y.s;
import java.util.ArrayList;
import java.util.List;

public final class c extends o implements b {
    private int fromScene;
    private Cursor ilb;
    int pUq;
    int pUr;
    private List<String> pUs;
    private int pUt = 0;

    public c(MMBaseSelectContactUI mMBaseSelectContactUI, List<String> list, List<String> list2, int i) {
        super(mMBaseSelectContactUI, list2, true, false);
        this.pUs = list;
        this.fromScene = i;
        x.i("MicroMsg.RecentConversationAdapter", "create!");
        aJO();
        ((h) g.h(h.class)).Fk().a(this);
    }

    private void aJO() {
        int i;
        Cursor cN;
        List list;
        x.i("MicroMsg.RecentConversationAdapter", "resetData");
        if (this.ilb != null) {
            this.ilb.close();
            this.ilb = null;
        }
        this.pUt = 0;
        List arrayList = new ArrayList();
        this.pUq = -1;
        this.pUr = -1;
        if (this.pUs == null || this.pUs.size() <= 0) {
            i = 0;
        } else {
            g.Dr();
            cN = ((h) g.h(h.class)).Ff().cN(this.pUs);
            arrayList.add(cN);
            int count = cN.getCount();
            if (count > 0) {
                this.pUq = this.zbQ.buq().getHeaderViewsCount();
                this.pUt++;
                i = count;
            } else {
                this.pUq = -1;
                i = count;
            }
        }
        List list2 = this.koG;
        if (list2 != null) {
            list2.addAll(this.pUs);
            list = list2;
        } else {
            list = this.pUs;
        }
        if (this.fromScene == 1) {
            cN = ((h) g.h(h.class)).Fk().b(s.hgU, list, this.zch, "");
        } else {
            cN = ((h) g.h(h.class)).Fk().b(s.hgY, list, this.zch, "");
        }
        if (cN.getCount() > 0) {
            this.pUt++;
            if (i > 0) {
                this.pUr = (i + this.pUq) + 1;
            } else {
                this.pUr = this.zbQ.buq().getHeaderViewsCount();
            }
        } else {
            this.pUr = -1;
        }
        arrayList.add(cN);
        this.ilb = new MergeCursor((Cursor[]) arrayList.toArray(new Cursor[0]));
    }

    protected final a je(int i) {
        if (i == this.pUr || i == this.pUq) {
            a gVar = new com.tencent.mm.ui.contact.a.g(i);
            if (i == this.pUq) {
                if (this.fromScene == 1) {
                    gVar.mVt = this.zbQ.getActivity().getResources().getString(i.uNJ);
                    return gVar;
                }
                gVar.mVt = this.zbQ.getActivity().getResources().getString(i.uUB);
                return gVar;
            } else if (i != this.pUr) {
                return gVar;
            } else {
                gVar.mVt = this.zbQ.getActivity().getResources().getString(i.vdd);
                return gVar;
            }
        }
        int i2;
        if (this.pUt == 2) {
            if (i > this.pUr) {
                i2 = i - 2;
            } else {
                i2 = i - 1;
            }
        } else if (this.pUt == 1) {
            i2 = i - 1;
        } else {
            x.e("MicroMsg.RecentConversationAdapter", "Actually dead branch. position=%d", Integer.valueOf(i));
            i2 = i;
        }
        if (!this.ilb.moveToPosition(i2)) {
            return null;
        }
        a eVar = new e(i);
        ak aeVar = new ae();
        aeVar.b(this.ilb);
        g.Dr();
        eVar.jQP = ((h) g.h(h.class)).Ff().Xq(aeVar.field_username);
        if (eVar.jQP == null) {
            g.Dr();
            eVar.jQP = ((h) g.h(h.class)).Ff().Xu(aeVar.field_username);
        }
        return eVar;
    }

    public final int getCount() {
        return this.ilb.getCount() + this.pUt;
    }

    public final void finish() {
        super.finish();
        x.i("MicroMsg.RecentConversationAdapter", "finish!");
        if (this.ilb != null) {
            this.ilb.close();
            this.ilb = null;
        }
        ((h) g.h(h.class)).Fk().b(this);
    }

    public final void a(int i, m mVar, Object obj) {
        aJO();
        notifyDataSetChanged();
    }
}
