package com.tencent.mm.plugin.multitalk.ui;

import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.contact.l;
import com.tencent.mm.ui.contact.o;
import com.tencent.mm.y.as;
import com.tencent.mm.y.c;
import java.util.ArrayList;
import java.util.List;

public final class a extends o {
    private String chatroomName;
    private List<String> ikZ = c.Fo().hK(this.chatroomName);

    public a(l lVar, String str) {
        super(lVar, null, true, true);
        this.chatroomName = str;
        x.i("MicroMsg.multitalk.MultiTalkSelectInitAdapter", "resetData");
        as.Hm();
        if (this.ikZ == null) {
            this.ikZ = new ArrayList();
        }
    }

    protected final com.tencent.mm.ui.contact.a.a je(int i) {
        String str = (String) this.ikZ.get(i);
        as.Hm();
        com.tencent.mm.storage.x Xv = c.Ff().Xv(str);
        com.tencent.mm.ui.contact.a.a aVar = new com.tencent.mm.plugin.multitalk.ui.widget.a(i);
        aVar.jQP = Xv;
        aVar.zbR = buj();
        return aVar;
    }

    public final int getCount() {
        return this.ikZ.size();
    }
}
