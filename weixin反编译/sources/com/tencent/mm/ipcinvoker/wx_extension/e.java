package com.tencent.mm.ipcinvoker.wx_extension;

import android.content.Context;
import com.tencent.mm.ipcinvoker.a.b;
import com.tencent.mm.ipcinvoker.a.d;
import com.tencent.mm.ipcinvoker.extension.a;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.ipcinvoker.wx_extension.service.SupportProcessIPCService;
import com.tencent.mm.ipcinvoker.wx_extension.service.ToolsProcessIPCService;
import com.tencent.mm.kernel.b.c;
import com.tencent.mm.kernel.b.h;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;
import junit.framework.Assert;

public final class e implements c {

    private static final class a {
        private static final e gOU = new e();
    }

    /* synthetic */ e(byte b) {
        this();
    }

    private e() {
        Context context = ((h) g.Dn().CU()).gUt;
        b anonymousClass1 = new com.tencent.mm.ipcinvoker.a.a() {
            public final void a(d dVar) {
                super.a(dVar);
                dVar.a(new c());
                dVar.a(new a());
                dVar.a(new d());
            }

            public final void a(com.tencent.mm.ipcinvoker.a.c cVar) {
                cVar.c("com.tencent.mm", MainProcessIPCService.class);
                cVar.c("com.tencent.mm:tools", ToolsProcessIPCService.class);
                cVar.c("com.tencent.mm:support", SupportProcessIPCService.class);
            }
        };
        Assert.assertNotNull(context);
        com.tencent.mm.ipcinvoker.e.gOj = context;
        anonymousClass1.a(new d() {
            public final void a(a aVar) {
                com.tencent.mm.ipcinvoker.extension.c.a(aVar);
            }
        });
        anonymousClass1.a(com.tencent.mm.ipcinvoker.b.Bz());
        x.i("IPC.IPCInvokerBoot", "setup IPCInvoker(process : %s, application : %s)", com.tencent.mm.ipcinvoker.e.BB(), Integer.valueOf(context.hashCode()));
        if (ad.cgl()) {
            com.tencent.mm.ipcinvoker.g.fk("com.tencent.mm:tools");
        }
    }
}
