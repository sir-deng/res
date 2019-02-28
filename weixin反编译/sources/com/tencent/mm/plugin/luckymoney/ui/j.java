package com.tencent.mm.plugin.luckymoney.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.view.Window;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.ui.MMActivity;

public final class j {
    MMActivity isO;
    int opS;
    int opT;

    public static final class a {
        public int kjx;
        public Drawable opU;
        public int opV;
        public int opW;
        public int opX;
        public int opY;
    }

    public j(MMActivity mMActivity) {
        this.isO = mMActivity;
        if (aYw()) {
            Window window = mMActivity.getWindow();
            window.addFlags(Integer.MIN_VALUE);
            this.opT = window.getStatusBarColor();
        }
    }

    private static boolean aYw() {
        return VERSION.SDK_INT >= 21;
    }

    final void sE(int i) {
        if (aYw()) {
            Window window = this.isO.getWindow();
            window.addFlags(Integer.MIN_VALUE);
            window.setStatusBarColor(i);
        }
    }

    static a G(Context context, int i) {
        a aVar = new a();
        Resources resources = context.getResources();
        switch (i) {
            case 1:
                aVar.opU = new ColorDrawable(resources.getColor(c.uhl));
                aVar.kjx = resources.getColor(c.uhm);
                aVar.opV = resources.getColor(c.uhq);
                aVar.opW = resources.getColor(c.uhq);
                aVar.opX = e.ujj;
                aVar.opY = resources.getColor(c.uhs);
                break;
            default:
                aVar.opU = resources.getDrawable(e.uji);
                aVar.kjx = -1;
                aVar.opW = resources.getColor(c.uhw);
                aVar.opY = resources.getColor(c.uhj);
                break;
        }
        return aVar;
    }
}
