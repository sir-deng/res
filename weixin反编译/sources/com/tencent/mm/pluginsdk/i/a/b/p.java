package com.tencent.mm.pluginsdk.i.a.b;

import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.storage.w.a;

final class p {
    static void arC() {
        g.Dp().gRu.a(new m(), 0);
        if (g.Do().CF()) {
            g.Dq().Db().a(a.USERINFO_RES_DOWNLOADER_CHECK_RES_UPDATE_INTERVAL_LONG, Long.valueOf(bi.Wx() + 86400));
        }
    }
}
