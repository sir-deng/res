package com.tencent.mm.ui.contact;

import android.database.Cursor;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.contact.a.a;
import com.tencent.mm.ui.contact.a.d;
import java.util.ArrayList;
import java.util.List;

public final class h extends o {
    private Cursor ilb = ((com.tencent.mm.plugin.messenger.foundation.a.h) g.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).Ff().cM(this.zbh);
    private List<String> zbh;

    public h(MMBaseSelectContactUI mMBaseSelectContactUI, boolean z, List<String> list) {
        super(mMBaseSelectContactUI, new ArrayList(), true, z);
        this.zbh = list;
        g.Dr();
    }

    public final int getCount() {
        return this.ilb.getCount();
    }

    protected final a je(int i) {
        if (i < 0 || !this.ilb.moveToPosition(i)) {
            x.e("MicroMsg.CustomContactAdapter", "create Data Item Error position=%d", Integer.valueOf(i));
            return null;
        }
        a dVar = new d(i);
        com.tencent.mm.storage.x xVar = new com.tencent.mm.storage.x();
        xVar.b(this.ilb);
        dVar.jQP = xVar;
        dVar.zbR = buj();
        return dVar;
    }

    public final void finish() {
        super.finish();
        x.i("MicroMsg.CustomContactAdapter", "finish!");
        if (this.ilb != null) {
            this.ilb.close();
            this.ilb = null;
        }
    }
}
