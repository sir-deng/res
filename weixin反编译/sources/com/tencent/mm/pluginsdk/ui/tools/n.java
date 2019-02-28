package com.tencent.mm.pluginsdk.ui.tools;

import android.content.Context;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.compatible.e.y;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class n {
    public static f es(Context context) {
        if (bi.aD(q.gHP.gHg, "").equals("surface")) {
            x.i("MicroMsg.VideoViewFactory", "match full type surface");
            return new VideoSurfaceView(context);
        }
        String str = y.get("ro.mediatek.platform");
        Object obj = (str == null || !(str.startsWith("MT") || str.startsWith("mt"))) ? null : 1;
        if (obj != null) {
            x.i("MicroMsg.VideoViewFactory", "IS MTK platform");
            return new VideoSightView(context);
        }
        x.i("MicroMsg.VideoViewFactory", "default settings, use sightview");
        return new VideoSightView(context);
    }
}
