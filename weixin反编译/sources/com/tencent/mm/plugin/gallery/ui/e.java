package com.tencent.mm.plugin.gallery.ui;

import com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem;
import com.tencent.mm.plugin.gallery.model.c;
import com.tencent.mm.sdk.platformtools.bi;

final class e {
    int mZw = -1;
    private c mZx;

    public e(c cVar) {
        this.mZx = cVar;
    }

    final void qS(int i) {
        c cVar = this.mZx;
        if (cVar.mXw != null && cVar.mXw.size() > i && i >= 0) {
            long j = ((MediaItem) cVar.mXw.get(i)).mWR;
            String str = ((MediaItem) cVar.mXw.get(i)).mqO;
            String str2 = ((MediaItem) cVar.mXw.get(i)).hQc;
            if (bi.oN(str)) {
                str = str2;
            }
            c.aOk().b(str, ((MediaItem) cVar.mXw.get(i)).getType(), str2, j);
        }
    }
}
