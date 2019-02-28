package com.tencent.mm.ui.chatting.gallery;

import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import java.util.ArrayList;
import java.util.Iterator;

public final class g {
    public ArrayList<au> yLS;
    public boolean yNu;
    ArrayList<b> yNv;

    private static final class a {
        private static final g yNw = new g();
    }

    public interface b {
        void clear();

        void cvr();
    }

    /* synthetic */ g(byte b) {
        this();
    }

    private g() {
        this.yLS = new ArrayList();
        this.yNu = false;
        this.yNv = new ArrayList();
    }

    public final void bm(au auVar) {
        if (auVar != null) {
            x.i("MicroMsg.ImageGallerySelectedHandle", "add : %s", Long.valueOf(auVar.field_msgId));
            this.yLS.remove(auVar);
            this.yLS.remove(gm(auVar.field_msgId));
            this.yLS.add(auVar);
            cvs();
        }
    }

    private au gm(long j) {
        Iterator it = this.yLS.iterator();
        while (it.hasNext()) {
            au auVar = (au) it.next();
            if (auVar.field_msgId == j) {
                return auVar;
            }
        }
        return null;
    }

    public final void bn(au auVar) {
        if (auVar != null) {
            x.i("MicroMsg.ImageGallerySelectedHandle", "remove : %s", Long.valueOf(auVar.field_msgId));
            this.yLS.remove(auVar);
            this.yLS.remove(gm(auVar.field_msgId));
            cvs();
        }
    }

    public final void clear() {
        x.i("MicroMsg.ImageGallerySelectedHandle", "clear..");
        this.yLS.clear();
        Iterator it = this.yNv.iterator();
        while (it.hasNext()) {
            ((b) it.next()).clear();
        }
    }

    public final void detach() {
        this.yNv.clear();
        clear();
        this.yNu = false;
    }

    public final boolean bo(au auVar) {
        if (auVar == null) {
            return false;
        }
        Iterator it = this.yLS.iterator();
        while (it.hasNext()) {
            if (((au) it.next()).field_msgId == auVar.field_msgId) {
                return true;
            }
        }
        return false;
    }

    private void cvs() {
        Iterator it = this.yNv.iterator();
        while (it.hasNext()) {
            ((b) it.next()).cvr();
        }
    }

    public final void a(b bVar) {
        if (bVar != null) {
            this.yNv.remove(bVar);
            this.yNv.add(bVar);
        }
    }
}
