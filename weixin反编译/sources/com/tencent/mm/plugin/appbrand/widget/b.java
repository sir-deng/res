package com.tencent.mm.plugin.appbrand.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.widget.ImageView;
import com.tencent.mm.plugin.appbrand.jsapi.base.e;

@SuppressLint({"AppCompatCustomView"})
public class b extends ImageView implements e {
    private boolean kad;

    public b(Context context) {
        super(context);
    }

    public final boolean age() {
        return this.kad;
    }
}
