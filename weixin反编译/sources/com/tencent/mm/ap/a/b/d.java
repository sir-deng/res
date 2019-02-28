package com.tencent.mm.ap.a.b;

import com.tencent.mm.a.g;
import com.tencent.mm.ap.a.c.f;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class d implements f {
    public final String lE(String str) {
        if (bi.oN(str)) {
            return null;
        }
        x.d("MicroMsg.imageloader.DefaultImageFileNameCreater", "[cpan] create image file name :%s", g.s(str.getBytes()));
        return g.s(str.getBytes());
    }
}
