package com.tencent.mm.view.a;

import android.content.Context;
import android.widget.BaseAdapter;

public abstract class a extends BaseAdapter {
    public int kLd;
    public Context mContext;
    public int nxB;
    public com.tencent.mm.view.f.a zMD;
    public int zMu;
    public int zMw;
    public int zNu;
    public int zNv;
    public String zNw;
    public int zNx;

    public a(Context context, com.tencent.mm.view.f.a aVar) {
        this.mContext = context;
        this.zMD = aVar;
    }

    public final void c(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        this.zMu = i;
        this.kLd = i2;
        this.zNu = i3;
        this.zMw = i4;
        this.zNv = i5;
        this.zNx = i6;
        this.nxB = i7;
    }
}
