package com.tencent.mm.plugin.profile.ui;

import android.os.Looper;
import com.tencent.mm.plugin.fts.a.a.h;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.k;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.storage.x;
import com.tencent.mm.ui.contact.a.e;
import com.tencent.mm.ui.contact.l;
import com.tencent.mm.ui.contact.o;
import com.tencent.mm.y.as;
import com.tencent.mm.y.c;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public final class a extends o implements k {
    ag handler = new ag(Looper.getMainLooper());
    x jQP;
    private List<j> mUI;

    private class a implements Comparator<j> {
        private a() {
        }

        /* synthetic */ a(a aVar, byte b) {
            this();
        }

        public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
            j jVar = (j) obj;
            j jVar2 = (j) obj2;
            if (jVar2.timestamp > jVar.timestamp) {
                return 1;
            }
            return jVar2.timestamp < jVar.timestamp ? -1 : 0;
        }
    }

    public a(l lVar, int i, x xVar) {
        super(lVar, new ArrayList(), true, false, i);
        this.jQP = xVar;
    }

    protected final com.tencent.mm.ui.contact.a.a je(int i) {
        com.tencent.mm.ui.contact.a.a eVar = new e(i);
        as.Hm();
        eVar.jQP = c.Ff().Xv(((j) this.mUI.get(i)).mRd);
        return eVar;
    }

    public final int getCount() {
        if (this.mUI == null) {
            return 0;
        }
        return this.mUI.size();
    }

    public final void b(h hVar) {
        if (hVar.bjW == 0) {
            this.mUI = hVar.mRN;
        }
        notifyDataSetChanged();
    }
}
