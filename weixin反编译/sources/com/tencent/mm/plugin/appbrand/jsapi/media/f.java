package com.tencent.mm.plugin.appbrand.jsapi.media;

import android.content.Context;
import android.widget.Toast;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.tencent.mm.platformtools.d;
import com.tencent.mm.plugin.appbrand.q.j;
import com.tencent.mm.plugin.appbrand.r.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.k;

public final class f extends a {
    public static final int CTRL_INDEX = 216;
    public static final String NAME = "saveVideoToPhotosAlbum";

    final boolean l(Context context, String str, String str2) {
        String oF = d.oF("mp4");
        if (!k.fv(str, oF)) {
            oF = null;
        }
        if (bi.oN(oF)) {
            return false;
        }
        Toast.makeText(context, c.getMMString(j.eTu, oF), 1).show();
        com.tencent.mm.pluginsdk.ui.tools.k.b(oF, context);
        return true;
    }

    final boolean sP(String str) {
        return bi.oM(str).toLowerCase().contains(SlookAirButtonRecentMediaAdapter.VIDEO_TYPE);
    }
}
