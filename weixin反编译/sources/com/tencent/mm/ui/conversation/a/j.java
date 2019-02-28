package com.tencent.mm.ui.conversation.a;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.mm.pluginsdk.ui.b.a;
import com.tencent.mm.pluginsdk.ui.b.b;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.ba;

public final class j extends b {
    LinearLayout zjU = null;

    public j(final Context context) {
        super(context);
        this.zjU = new LinearLayout(context);
        this.zjU.setVisibility(8);
        ba.Hy().hic = new ba.b() {
            public final void HB() {
                j.this.zjU.post(new Runnable() {
                    public final void run() {
                        if (j.this.zjU != null) {
                            j.this.zjU.setVisibility(8);
                            j.this.zjU.removeAllViews();
                        }
                        a a = e.a(context, e.a.zjG, null);
                        if (a == null) {
                            a = e.a(context, e.a.zjA, null);
                        }
                        if (a != null && a.getView() != null) {
                            x.i("MicroMsg.MainFrameAndAbtestBanner", "summerinit MainFrameBannerStorage onNotify banner[%s], view[%s]", a, a.getView());
                            j.this.zjU.setVisibility(0);
                            j.this.zjU.addView(a.getView(), new LayoutParams(-1, -2));
                        }
                    }
                });
            }
        };
        ba.Hy().hic.HB();
    }

    public final boolean alN() {
        return this.zjU != null && this.zjU.getVisibility() == 0;
    }

    public final View getView() {
        return this.zjU;
    }

    public final int getLayoutId() {
        return -1;
    }

    public final void destroy() {
        ba.Hy().hic = null;
    }
}
