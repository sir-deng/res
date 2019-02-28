package com.tencent.mm.plugin.product.ui;

import android.graphics.Bitmap;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.platformtools.j.a;
import com.tencent.mm.plugin.product.b.n;
import com.tencent.mm.sdk.platformtools.bi;

public final class m implements a {
    public TextView ikn;
    public ImageView jTd;
    public n.a pmm;

    public final void l(String str, final Bitmap bitmap) {
        if (this.pmm != null && !bi.oN(this.pmm.iconUrl) && str.equals(this.pmm.iconUrl)) {
            this.jTd.post(new Runnable() {
                public final void run() {
                    m.this.jTd.setImageBitmap(bitmap);
                }
            });
        }
    }
}
