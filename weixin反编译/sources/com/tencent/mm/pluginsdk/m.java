package com.tencent.mm.pluginsdk;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import com.tencent.mm.ad.f;
import com.tencent.mm.ad.k;
import com.tencent.mm.protocal.c.asc;
import com.tencent.mm.storage.au.a;
import com.tencent.mm.storage.x;

@Deprecated
public interface m {
    String A(String str, String str2);

    Bitmap a(Activity activity, int i, int i2, Intent intent);

    k a(f fVar);

    void a(Context context, a aVar, Bundle bundle);

    void a(Context context, x xVar, a aVar, Bundle bundle, String str);

    void a(Context context, String str, String str2, String str3, int i, int i2, int i3, String str4, String str5);

    void a(Context context, String str, String str2, String str3, long j);

    void a(Intent intent, String str);

    void a(asc asc, String str);

    boolean a(Context context, int i, int i2, String str);

    boolean a(x xVar);

    k aJ(boolean z);

    void aq(Context context);

    boolean b(Context context, int i, int i2, String str);

    boolean cA(String str);

    void cB(String str);

    String cy(String str);

    boolean cz(String str);

    boolean d(Activity activity);

    void e(Activity activity);

    void ep(int i);

    String f(Context context, String str, String str2);

    String l(Context context, String str);

    boolean m(Context context, String str);

    String s(String str, int i);

    void un();

    void up();

    void uq();

    Intent ur();

    boolean us();

    void ut();

    boolean uu();
}
