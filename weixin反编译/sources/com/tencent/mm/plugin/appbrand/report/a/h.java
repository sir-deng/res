package com.tencent.mm.plugin.appbrand.report.a;

import com.tencent.mm.plugin.appbrand.report.e;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class h {
    private String foi;
    public b jNW;
    public int jNX;
    public String jNY;
    private long jNZ;
    public a jOa;

    public enum a {
        NEARBY_H5(1),
        EMPTY_PAGE(2),
        LBS_NOT_ALLOW(3),
        NEARBY_MINI_PROGRAM(4);
        
        public final int value;

        private a(int i) {
            this.value = i;
        }
    }

    public enum b {
        DESKTOP_SEARCH(1),
        RESUME_FROM_WEAPP_EXIT(2),
        BOTTOM_ENTRANCE_IN_DESKTOP(3),
        TOP_ENTRANCE_IN_DESKTOP(4);
        
        public final int value;

        private b(int i) {
            this.value = i;
        }
    }

    public final String toString() {
        return "kv_13917{scene=" + this.jNW.value + ", appCount=" + this.jNX + ", nearbyListId='" + this.jNY + '\'' + ", clickTime=" + this.jNZ + ", sceneNote='" + this.foi + '\'' + ", openType=" + this.jOa.value + '}';
    }

    public final void xd() {
        if (this.jNW != null && this.jOa != null) {
            x.i("MicroMsg.AppBrand.kv_13917", "report " + toString());
            this.jNZ = bi.Wy();
            g.pWK.h(13917, e.h(Integer.valueOf(this.jNW.value), Integer.valueOf(this.jNX), this.jNY, Long.valueOf(this.jNZ), this.foi, Integer.valueOf(this.jOa.value)));
        }
    }
}
