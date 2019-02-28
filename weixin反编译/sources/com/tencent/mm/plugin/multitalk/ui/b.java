package com.tencent.mm.plugin.multitalk.ui;

import android.database.Cursor;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.contact.MMBaseSelectContactUI;
import com.tencent.mm.ui.contact.a.a;
import com.tencent.mm.ui.contact.q;
import com.tencent.mm.y.as;
import com.tencent.mm.y.c;
import java.util.List;

public final class b extends q {
    private String chatroomName;
    private String fEe;
    private String[] ila;
    private Cursor ilb;

    public b(MMBaseSelectContactUI mMBaseSelectContactUI, String str) {
        super(mMBaseSelectContactUI, null, true, 0);
        this.chatroomName = str;
        as.Hm();
        List hK = c.Fo().hK(this.chatroomName);
        if (hK != null) {
            this.ila = bi.cB(hK);
        }
    }

    public final void a(String str, int[] iArr, boolean z) {
        x.i("MicroMsg.multitalk.MultiTalkSelectSearchAdapter", "doSearch: %s", str);
        clearCache();
        this.fEe = str;
        if (this.ilb != null) {
            this.ilb.close();
            this.ilb = null;
        }
        if (!(bi.oN(this.fEe) || this.ila == null)) {
            as.Hm();
            this.ilb = c.Ff().a(this.ila, "@all.chatroom", this.fEe, null, null);
        }
        notifyDataSetChanged();
        bp(str, true);
    }

    protected final a je(int i) {
        if (!this.ilb.moveToPosition(i)) {
            return null;
        }
        com.tencent.mm.storage.x xVar = new com.tencent.mm.storage.x();
        xVar.b(this.ilb);
        a aVar = new com.tencent.mm.plugin.multitalk.ui.widget.a(i);
        aVar.jQP = xVar;
        aVar.zbR = buj();
        aVar.fEe = this.fEe;
        return aVar;
    }

    public final void finish() {
        super.finish();
        if (this.ilb != null) {
            this.ilb.close();
            this.ilb = null;
        }
    }

    public final int getCount() {
        if (this.ilb == null) {
            return 0;
        }
        return this.ilb.getCount();
    }
}
