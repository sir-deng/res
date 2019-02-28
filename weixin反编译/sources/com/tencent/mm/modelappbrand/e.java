package com.tencent.mm.modelappbrand;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.tencent.mm.kernel.c.a;

public interface e extends a {
    d Jc();

    h Jd();

    void a(String str, View view);

    boolean a(String str, View view, Bundle bundle, q qVar);

    void bA(View view);

    j bB(View view);

    View be(Context context);

    void iA(String str);

    void initialize();

    void shutdown();
}
