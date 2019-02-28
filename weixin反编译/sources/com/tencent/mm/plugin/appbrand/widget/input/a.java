package com.tencent.mm.plugin.appbrand.widget.input;

import android.app.Activity;
import android.graphics.Point;
import android.os.Build.VERSION;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.pluginsdk.e;
import com.tencent.mm.sdk.platformtools.x;

public final class a {
    public final Activity activity;
    public boolean kcq = false;
    public int kcr = 0;

    public a(Activity activity) {
        this.activity = activity;
    }

    public final void anb() {
        if (this.kcq && !this.activity.isFinishing() && VERSION.SDK_INT < 20) {
            l k = l.k(this.activity);
            if (k == null) {
                x.w("MicroMsg.AppBrandFixInputIssuesActivityHelper", "fixLayoutHeightIfNeed get null rootLayout");
            } else {
                a(k);
            }
        }
    }

    public final void a(l lVar) {
        int i;
        Point point = new Point();
        this.activity.getWindowManager().getDefaultDisplay().getSize(point);
        int ec = e.ec(this.activity);
        int i2 = point.y;
        if (this.activity.getWindow() == null || (this.activity.getWindow().getAttributes().flags & WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) <= 0) {
            i = 0;
        } else {
            i = 1;
        }
        if (i != 0) {
            ec = 0;
        }
        x.i("MicroMsg.AppBrandFixInputIssuesActivityHelper", "fixLayoutHeightBelow20 forceHeight %d", Integer.valueOf(i2 - ec));
        lVar.kdp = ec;
    }
}
