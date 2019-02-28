package com.tencent.mm.plugin.gif;

import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class e {
    public final int[] nEp = new int[6];

    public e(String str) {
        try {
            MMGIFJNI.recycle(MMGIFJNI.openByFilePath(str, this.nEp));
            x.i("MMGIFInfo", "width:%d height:%d", Integer.valueOf(this.nEp[0]), Integer.valueOf(this.nEp[1]));
        } catch (Throwable e) {
            x.e("MMGIFInfo", bi.i(e));
        }
    }
}
