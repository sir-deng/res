package com.tencent.mm.ui.tools;

import android.content.Context;
import android.content.res.ColorStateList;
import com.tencent.mm.bu.a;
import com.tencent.mm.v.a.d;
import junit.framework.Assert;

public final class r {
    private static r zwq = null;
    private ColorStateList[] yvY = new ColorStateList[2];
    private boolean zwr = false;

    private r(Context context) {
        this.yvY[0] = a.Z(context, d.gWk);
        this.yvY[1] = a.Z(context, d.gWl);
    }

    private static r gb(Context context) {
        Assert.assertTrue(context != null);
        if (zwq == null || !zwq.zwr) {
            zwq = new r(context);
        }
        return zwq;
    }

    public static ColorStateList gc(Context context) {
        return gb(context).yvY[0];
    }

    public static ColorStateList gd(Context context) {
        return gb(context).yvY[1];
    }
}
