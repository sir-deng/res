package com.tencent.mm.f.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.mm.protocal.c.uz;

public final class ft extends com.tencent.mm.sdk.b.b {
    public a fvX;
    public b fvY;

    public static final class a {
        public Context context;
        public long frf;
        public uz fvZ;
        public ImageView fwa;
        public int fwb;
        public boolean fwc = false;
        public boolean fwd = false;
        public boolean fwe = true;
        public int height;
        public int maxWidth;
        public int opType = -1;
        public int width;
    }

    public static final class b {
        public Bitmap fwf;
        public int ret = -1;
    }

    public ft() {
        this((byte) 0);
    }

    private ft(byte b) {
        this.fvX = new a();
        this.fvY = new b();
        this.xmE = false;
        this.frD = null;
    }
}
