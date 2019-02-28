package com.tencent.mm.pluginsdk;

import android.content.Context;
import android.os.Bundle;
import com.tencent.mm.f.a.lg;
import com.tencent.mm.kernel.c.a;
import com.tencent.mm.pluginsdk.wallet.c;
import com.tencent.mm.pluginsdk.wallet.j;
import com.tencent.mm.pluginsdk.wallet.k;
import java.util.Map;

public interface l extends a {
    int a(c cVar, int i, boolean z);

    void a(lg lgVar, int i);

    void a(lg lgVar, int i, String str);

    boolean a(boolean z, boolean z2, Bundle bundle);

    boolean aKD();

    boolean aKE();

    boolean aKF();

    void aKH();

    j aKJ();

    boolean aKK();

    boolean aKL();

    void aKM();

    boolean aKO();

    boolean aKP();

    void aKQ();

    void aKR();

    void aKS();

    Map<String, String> aKT();

    k aKU();

    Map<String, String> aKV();

    boolean aKW();

    void cC(Context context);

    void cD(Context context);

    void fm(boolean z);

    int type();
}
