package com.tencent.mm.plugin.sight.base;

import com.tencent.mm.sdk.platformtools.bi;

public final class a {
    public int height = 0;
    public int hvN = 0;
    public int mDe = 0;
    public int oBL = 0;
    public int qyX = 0;
    public int videoBitrate = 0;
    public int width = 0;

    public final int btk() {
        return bi.fN((long) this.mDe);
    }

    public final String toString() {
        return "[ videoDuration: " + this.mDe + " videoBitrate: " + this.videoBitrate + " width: " + this.width + " height: " + this.height + " frameRate: " + this.oBL + " audioChannel: " + this.qyX + " audioBitrate: " + this.hvN + "]";
    }
}
