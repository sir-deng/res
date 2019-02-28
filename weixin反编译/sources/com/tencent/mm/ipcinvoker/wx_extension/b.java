package com.tencent.mm.ipcinvoker.wx_extension;

import com.tencent.mm.ad.k;
import com.tencent.mm.ad.u;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.h;
import com.tencent.mm.ipcinvoker.i;
import com.tencent.mm.ipcinvoker.wx_extension.service.IPCRunCgiRespWrapper;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;

public final class b {

    public interface a {
        void a(int i, int i2, String str, com.tencent.mm.ad.b bVar);
    }

    private static final class b implements h<com.tencent.mm.ad.b, IPCRunCgiRespWrapper> {
        private b() {
        }

        public final /* synthetic */ void a(Object obj, final i iVar) {
            com.tencent.mm.ad.b bVar = (com.tencent.mm.ad.b) obj;
            if (bVar == null || bVar.hnR.hnY.getClass() == com.tencent.mm.bp.a.class) {
                x.e("MicroMsg.IPCRunCgi", "InvokeTask, mm received invalid rr %s", bVar);
                iVar.as(IPCRunCgiRespWrapper.BN());
                return;
            }
            u.a(bVar, new com.tencent.mm.ad.u.a() {
                public final int a(int i, int i2, String str, com.tencent.mm.ad.b bVar, k kVar) {
                    if (iVar != null) {
                        IPCRunCgiRespWrapper iPCRunCgiRespWrapper = new IPCRunCgiRespWrapper();
                        iPCRunCgiRespWrapper.errType = i;
                        iPCRunCgiRespWrapper.errCode = i2;
                        iPCRunCgiRespWrapper.foE = str;
                        iPCRunCgiRespWrapper.gLB = bVar;
                        iVar.as(iPCRunCgiRespWrapper);
                    }
                    return 0;
                }
            }, true);
        }
    }

    public static void a(com.tencent.mm.ad.b bVar, final a aVar) {
        if (ad.cgj()) {
            u.a(bVar, new com.tencent.mm.ad.u.a() {
                public final int a(int i, int i2, String str, com.tencent.mm.ad.b bVar, k kVar) {
                    if (aVar != null) {
                        aVar.a(i, i2, str, bVar);
                    }
                    return 0;
                }
            }, true);
        } else {
            XIPCInvoker.a("com.tencent.mm", bVar, b.class, new i<IPCRunCgiRespWrapper>() {
                public final /* synthetic */ void as(Object obj) {
                    IPCRunCgiRespWrapper iPCRunCgiRespWrapper = (IPCRunCgiRespWrapper) obj;
                    if (aVar != null && iPCRunCgiRespWrapper != null) {
                        aVar.a(iPCRunCgiRespWrapper.errType, iPCRunCgiRespWrapper.errCode, iPCRunCgiRespWrapper.foE, iPCRunCgiRespWrapper.gLB);
                    }
                }
            });
        }
    }
}
