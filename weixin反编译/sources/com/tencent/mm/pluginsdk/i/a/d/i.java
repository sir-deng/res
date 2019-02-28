package com.tencent.mm.pluginsdk.i.a.d;

import android.util.SparseArray;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.List;

public final class i implements c {
    private final ag vom;
    public final SparseArray<List<d>> von = new SparseArray();
    public final Object voo = new Object();

    i(ag agVar) {
        this.vom = agVar;
    }

    public final void a(e eVar, final l lVar) {
        x.i("MicroMsg.ResDownloader.NetworkEventDispatcher", "dispatchResponse, response = " + lVar);
        q SB;
        final List SA;
        final String bZW;
        switch (lVar.status) {
            case 2:
                SB = a.voG.SB(lVar.vmK);
                if (SB != null) {
                    SB.field_status = 2;
                    a.voG.g(SB);
                }
                x.d("MicroMsg.ResDownloader.NetworkEventDispatcher", "dispatchComplete, groupId = " + eVar.aam());
                SA = SA(eVar.aam());
                if (bi.cC(SA)) {
                    x.d("MicroMsg.ResDownloader.NetworkEventDispatcher", "dispatchComplete, listeners.size = null");
                    return;
                }
                x.d("MicroMsg.ResDownloader.NetworkEventDispatcher", "dispatchComplete, listeners.size = " + SA.size());
                bZW = eVar.bZW();
                this.vom.post(new Runnable() {
                    public final void run() {
                        for (d dVar : SA) {
                            if (bi.oM(dVar.aam()).equals(lVar.groupId)) {
                                dVar.a(bZW, lVar);
                            }
                        }
                    }
                });
                return;
            case 3:
                SB = a.voG.SB(lVar.vmK);
                if (SB != null) {
                    SB.field_status = 3;
                    a.voG.g(SB);
                }
                SA = SA(eVar.aam());
                if (!bi.cC(SA)) {
                    bZW = eVar.bZW();
                    this.vom.post(new Runnable() {
                        public final void run() {
                            for (d dVar : SA) {
                                if (bi.oM(dVar.aam()).equals(lVar.groupId)) {
                                    dVar.b(bZW, lVar);
                                }
                            }
                        }
                    });
                    return;
                }
                return;
            case 4:
                SB = a.voG.SB(lVar.vmK);
                if (SB != null) {
                    SB.field_status = 4;
                    a.voG.g(SB);
                }
                SA = SA(eVar.aam());
                if (!bi.cC(SA)) {
                    bZW = eVar.bZW();
                    this.vom.post(new Runnable() {
                        public final void run() {
                            for (d dVar : SA) {
                                if (bi.oM(dVar.aam()).equals(lVar.groupId)) {
                                    dVar.Pj(bZW);
                                }
                            }
                        }
                    });
                    return;
                }
                return;
            default:
                return;
        }
    }

    public final void q(String str, int i, int i2) {
        x.i("MicroMsg.ResDownloader.NetworkEventDispatcher", "dispatchRetry, urlKey = %s, max = %d, count = %d", str, Integer.valueOf(i), Integer.valueOf(i2));
        q SB = a.voG.SB(str);
        if (SB != null) {
            SB.field_maxRetryTimes = i;
            SB.field_retryTimes = i2;
            a.voG.g(SB);
        }
    }

    public final void s(String str, long j) {
        q SB = a.voG.SB(str);
        if (SB != null) {
            SB.field_contentLength = j;
            a.voG.g(SB);
        }
    }

    private List<d> SA(String str) {
        List<d> list;
        int hashCode = str.hashCode();
        synchronized (this.voo) {
            list = (List) this.von.get(hashCode);
        }
        return list;
    }
}
