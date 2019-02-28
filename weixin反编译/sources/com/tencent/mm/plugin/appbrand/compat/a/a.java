package com.tencent.mm.plugin.appbrand.compat.a;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;

public interface a extends com.tencent.mm.kernel.c.a {

    public interface a {
        void m(boolean z, boolean z2);
    }

    void J(Context context, String str);

    void K(Context context, String str);

    void a(a aVar);

    void a(com.tencent.mm.x.g.a aVar, String str, String str2, String str3, byte[] bArr);

    int abJ();

    Intent bK(Context context);

    String bL(Context context);

    String bM(Context context);

    String bN(Context context);

    String bO(Context context);

    View c(Context context, ViewGroup viewGroup);

    Intent k(Context context, String str, String str2);
}
