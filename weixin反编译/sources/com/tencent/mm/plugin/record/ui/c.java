package com.tencent.mm.plugin.record.ui;

import android.content.Context;
import android.graphics.Bitmap;
import com.tencent.mm.f.a.ft;
import com.tencent.mm.plugin.record.ui.h.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.x;

public final class c implements a {
    public c(Context context) {
        b ftVar = new ft();
        ftVar.fvX.context = context;
        com.tencent.mm.sdk.b.a.xmy.m(ftVar);
    }

    public final void a(a.a aVar) {
        x.d("MicroMsg.FavImageServiceProxy", "attachThumb favLocalId %s", Long.valueOf(aVar.pLM));
        b ftVar = new ft();
        ftVar.fvX.opType = 1;
        ftVar.fvX.fwa = aVar.fwa;
        ftVar.fvX.fvZ = aVar.fvZ;
        ftVar.fvX.frf = aVar.pLM;
        ftVar.fvX.fwb = aVar.fwb;
        ftVar.fvX.width = aVar.width;
        ftVar.fvX.height = aVar.height;
        com.tencent.mm.sdk.b.a.xmy.m(ftVar);
    }

    public final Bitmap a(com.tencent.mm.plugin.record.ui.h.a.c cVar) {
        b ftVar = new ft();
        ftVar.fvX.opType = 0;
        ftVar.fvX.fvZ = cVar.fvZ;
        ftVar.fvX.frf = cVar.pLM;
        com.tencent.mm.sdk.b.a.xmy.m(ftVar);
        x.d("MicroMsg.FavImageServiceProxy", "getThumb favLocalId %s, retBmp %s", Long.valueOf(cVar.pLM), ftVar.fvY.fwf);
        return ftVar.fvY.fwf;
    }

    public final Bitmap a(a.b bVar) {
        b ftVar = new ft();
        ftVar.fvX.opType = 2;
        ftVar.fvX.fwe = false;
        if (bVar.fwc) {
            ftVar.fvX.fvZ = bVar.fvZ;
            ftVar.fvX.fwc = bVar.fwc;
        } else {
            ftVar.fvX.fvZ = bVar.fvZ;
            ftVar.fvX.frf = bVar.pLM;
            ftVar.fvX.maxWidth = bVar.maxWidth;
            ftVar.fvX.fwd = bVar.fwd;
        }
        com.tencent.mm.sdk.b.a.xmy.m(ftVar);
        x.d("MicroMsg.FavImageServiceProxy", "getSuitableBigImg favLocalId %s, dataId %s, retBmp %s, fromCache", Long.valueOf(bVar.pLM), bVar.fvZ.mBr, ftVar.fvY.fwf, Boolean.valueOf(ftVar.fvX.fwc));
        return ftVar.fvY.fwf;
    }

    public final void bnB() {
        b ftVar = new ft();
        ftVar.fvX.opType = 4;
        com.tencent.mm.sdk.b.a.xmy.m(ftVar);
    }
}
