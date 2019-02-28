package com.tencent.mm.plugin.talkroom.model;

import android.content.Context;
import com.tencent.mm.R;
import com.tencent.mm.f.b.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.y.as;
import com.tencent.mm.y.c;
import com.tencent.mm.y.r;
import com.tencent.mm.y.s;

public final class h {
    private static final int sgK = a.sgK;

    public static String aA(Context context, String str) {
        if (bi.oN(str)) {
            return null;
        }
        as.Hm();
        ag Xv = c.Ff().Xv(str);
        if (Xv == null) {
            return null;
        }
        if (!s.eX(str)) {
            return r.gw(str);
        }
        if (bi.oN(Xv.field_nickname)) {
            return context.getString(R.l.eRf);
        }
        return Xv.AW();
    }
}
