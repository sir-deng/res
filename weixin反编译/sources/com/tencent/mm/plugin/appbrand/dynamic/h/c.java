package com.tencent.mm.plugin.appbrand.dynamic.h;

import android.os.Bundle;
import com.tencent.mm.ipcinvoker.BaseIPCService;
import com.tencent.mm.ipcinvoker.a;
import com.tencent.mm.ipcinvoker.e;
import com.tencent.mm.ipcinvoker.k;
import com.tencent.mm.sdk.platformtools.x;

public class c implements a {
    public final void a(Bundle bundle, com.tencent.mm.ipcinvoker.c cVar) {
        BaseIPCService fn = k.BC().fn(e.BB());
        if (fn != null) {
            x.i("MicroMsg.IPCInvokeTask_KillAllProcess", "killSelf process(%s)", r0);
            fn.bu(true);
        }
    }
}
