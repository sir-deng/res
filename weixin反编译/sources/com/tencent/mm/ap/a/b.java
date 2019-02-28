package com.tencent.mm.ap.a;

import android.graphics.Bitmap;
import com.tencent.mm.ap.a.c.h;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;

public final class b {
    public com.tencent.mm.ap.a.a.b hEG;
    h hEH;
    Executor hEI;
    public final Map<Integer, String> hEJ = Collections.synchronizedMap(new HashMap());
    public HashMap<Integer, com.tencent.mm.ap.a.f.b> hEK = new HashMap();

    public b(com.tencent.mm.ap.a.a.b bVar) {
        this.hEG = bVar;
        this.hEH = bVar.hFg;
        this.hEI = bVar.hFh;
        this.hEG.hFa.a(this.hEG.hFc);
    }

    public final Bitmap lC(String str) {
        if (this.hEG != null) {
            return this.hEG.hEZ.iJ(str);
        }
        return null;
    }

    public final void a(c cVar) {
        this.hEJ.remove(Integer.valueOf(cVar.PO()));
        x.d("MicroMsg.imageloader.ImageLoaderManager", "[cpan] remove image weak holder size:%d viewcode:%s", Integer.valueOf(this.hEJ.size()), Integer.valueOf(cVar.PO()));
    }
}
