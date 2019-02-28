package com.tencent.mm.plugin.downloader.d;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import com.tencent.mm.plugin.downloader.a.b;
import com.tencent.mm.plugin.downloader.ipc.CDNDownloadService;
import com.tencent.mm.plugin.downloader.ipc.CDNTaskInfo;
import com.tencent.mm.plugin.downloader.ipc.CDNTaskState;
import com.tencent.mm.plugin.downloader.model.d;
import com.tencent.mm.plugin.downloader.model.q;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Set;

public final class a implements com.tencent.mm.ipcinvoker.wx_extension.b.a {
    private static a lwS;
    private long lwT = 0;
    long lwU = 0;
    com.tencent.mm.plugin.downloader.a.a lwV;
    Set<CDNTaskInfo> lwW = new com.tencent.mm.plugin.downloader.model.a(new q() {
        public final void aAD() {
            x.i("MicroMsg.CDNDownloadClient", "notify add");
            a.this.aAx();
            a aVar = a.this;
            x.i("MicroMsg.CDNDownloadClient", "startCheckProcessActiveTimer");
            aVar.lwZ.K(20000, 20000);
        }

        public final void remove() {
            x.i("MicroMsg.CDNDownloadClient", "notify remove");
            if (a.this.lwW.size() == 0) {
                a.a(a.this);
                a.b(a.this);
            }
        }

        public final void clear() {
            x.i("MicroMsg.CDNDownloadClient", "notify clear");
            a.a(a.this);
            a.b(a.this);
        }
    });
    public b lwX = this.lwX;
    private ServiceConnection lwY = new ServiceConnection() {
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            x.i("MicroMsg.CDNDownloadClient", "onServiceConnected");
            a.this.lwV = com.tencent.mm.plugin.downloader.a.a.a.H(iBinder);
            a aVar = a.this;
            try {
                x.i("MicroMsg.CDNDownloadClient", "registerCallback");
                aVar.lwV.a(aVar.lxa);
            } catch (RemoteException e) {
                x.e("MicroMsg.CDNDownloadClient", "registerCallback: " + e.getMessage());
            }
            a.c(a.this);
        }

        public final void onServiceDisconnected(ComponentName componentName) {
            x.i("MicroMsg.CDNDownloadClient", "onServiceDisconnected");
            if (a.this.lwW.size() != 0) {
                for (CDNTaskInfo cDNTaskInfo : a.this.lwW) {
                    cDNTaskInfo.lxp = true;
                }
            }
        }
    };
    al lwZ = new al(com.tencent.mm.by.a.cma().getLooper(), new com.tencent.mm.sdk.platformtools.al.a() {
        public final boolean uG() {
            boolean z;
            x.d("MicroMsg.CDNDownloadClient", "checkProcessTimer");
            if (a.this.lwW.size() == 0) {
                return false;
            }
            if (a.this.lwV != null) {
                try {
                    x.d("MicroMsg.CDNDownloadClient", "checkActive");
                    a.this.lwV.aAz();
                } catch (RemoteException e) {
                    x.e("MicroMsg.CDNDownloadClient", "check process active false");
                    g.pWK.a(710, 3, 1, false);
                    if (System.currentTimeMillis() - a.this.lwU > 120000) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (z) {
                        a.this.lwU = System.currentTimeMillis();
                        for (CDNTaskInfo cDNTaskInfo : a.this.lwW) {
                            cDNTaskInfo.lxp = true;
                        }
                        a.this.aAC();
                        return true;
                    }
                    x.i("MicroMsg.CDNDownloadClient", "dead twice in 1 min, something wrong must be happened");
                    g.pWK.a(710, 4, 1, false);
                    for (CDNTaskInfo cDNTaskInfo2 : a.this.lwW) {
                        a.this.lwX.f(cDNTaskInfo2.downloadUrl, 4, d.lxI, null);
                    }
                    a.this.lwW.clear();
                    return false;
                }
            }
            return true;
        }
    }, true);
    b lxa = new com.tencent.mm.plugin.downloader.a.b.a() {
        public final void e(String str, int i, int i2, String str2) {
            x.i("MicroMsg.CDNDownloadClient", "onDownloadStateChange, mediaId = %s, state = %d, errCode = %d, errMsg = %s", str, Integer.valueOf(i), Integer.valueOf(i2), str2);
            if (i != 1) {
                a.this.lwW.remove(new CDNTaskInfo(str));
            }
            if (a.this.lwX != null) {
                a.this.lwX.f(str, i, i2, str2);
            }
        }

        public final void j(String str, long j, long j2) {
            x.d("MicroMsg.CDNDownloadClient", "onDownloadProgressChange, mediaId = %s, receiveLen = %d, totalLen = %d", str, Long.valueOf(j), Long.valueOf(j2));
            if (a.this.lwX != null) {
                a.this.lwX.k(str, j, j2);
            }
        }
    };
    private com.tencent.mm.network.n.a lxb = new com.tencent.mm.network.n.a() {
        public final void eq(int i) {
            a aVar = a.this;
            x.i("MicroMsg.CDNDownloadClient", "notifyNetworkChange: " + i);
            if (aVar.lwV != null) {
                try {
                    aVar.lwV.oO(i);
                } catch (RemoteException e) {
                }
            }
        }
    };
    private Context mContext = ad.getContext();

    static /* synthetic */ void a(a aVar) {
        if (aVar.lwV != null) {
            try {
                aVar.lwV.aAy();
            } catch (RemoteException e) {
                x.e("MicroMsg.CDNDownloadClient", "removeIPCTaskMarker: " + e);
            }
        }
    }

    static /* synthetic */ void b(a aVar) {
        x.i("MicroMsg.CDNDownloadClient", "stopCheckProcessActiveTimer");
        aVar.lwZ.TN();
    }

    static /* synthetic */ void c(a aVar) {
        x.i("MicroMsg.CDNDownloadClient", "resumeTaskWhenSvrConnected");
        if (aVar.lwW.size() > 0) {
            aVar.aAx();
        }
        for (CDNTaskInfo cDNTaskInfo : aVar.lwW) {
            x.i("MicroMsg.CDNDownloadClient", "resumeTaskWhenSvrConnected, url: %s, resume: %b", cDNTaskInfo.downloadUrl, Boolean.valueOf(cDNTaskInfo.lxp));
            try {
                if (cDNTaskInfo.lxp) {
                    aVar.lwV.b(cDNTaskInfo);
                } else {
                    aVar.lwV.a(cDNTaskInfo);
                }
            } catch (RemoteException e) {
                x.e("MicroMsg.CDNDownloadClient", "resumeTaskWhenSvrConnected: " + e);
                g.pWK.a(710, 0, 1, false);
            }
        }
    }

    public static synchronized a aAB() {
        a aVar;
        synchronized (a.class) {
            if (lwS == null) {
                lwS = new a();
            }
            aVar = lwS;
        }
        return aVar;
    }

    public a() {
        com.tencent.mm.kernel.g.Dr();
        com.tencent.mm.kernel.g.Dp().a(this.lxb);
        aAC();
    }

    final synchronized void aAC() {
        try {
            x.i("MicroMsg.CDNDownloadClient", "bindService: " + this.mContext.bindService(new Intent(this.mContext, CDNDownloadService.class), this.lwY, 1));
        } catch (Exception e) {
            x.e("MicroMsg.CDNDownloadClient", "bindService: " + e.getMessage());
        }
        return;
    }

    public final int a(CDNTaskInfo cDNTaskInfo) {
        if (cDNTaskInfo == null || bi.oN(cDNTaskInfo.downloadUrl)) {
            x.w("MicroMsg.CDNDownloadClient", "addDownloadTask, info invalid");
            return -1;
        }
        x.i("MicroMsg.CDNDownloadClient", "addDownloadTask filePath:%s, url:%s", cDNTaskInfo.filePath, cDNTaskInfo.downloadUrl);
        if (this.lwW.contains(cDNTaskInfo)) {
            x.i("MicroMsg.CDNDownloadClient", "addDownloadTask, already in running");
            return -2;
        }
        if (this.lwV != null) {
            try {
                int a = this.lwV.a(cDNTaskInfo);
                if (a == 0 || a == -2) {
                    this.lwW.add(cDNTaskInfo);
                }
                return a;
            } catch (RemoteException e) {
                x.e("MicroMsg.CDNDownloadClient", "addDownloadTask, " + e.getMessage());
            }
        }
        this.lwW.add(cDNTaskInfo);
        aAC();
        return 0;
    }

    public final boolean yg(String str) {
        boolean z = false;
        x.i("MicroMsg.CDNDownloadClient", "pauseDownloadTask: " + str);
        if (bi.oN(str)) {
            x.w("MicroMsg.CDNDownloadClient", "pauseDownloadTask, url invalid");
            return z;
        }
        if (this.lwV != null) {
            try {
                this.lwW.remove(new CDNTaskInfo(str));
                return this.lwV.yg(str);
            } catch (RemoteException e) {
                x.e("MicroMsg.CDNDownloadClient", "pauseDownloadTask, " + e.getMessage());
            }
        }
        x.i("MicroMsg.CDNDownloadClient", "pauseDownloadTask false, service interface is null");
        return z;
    }

    public final int b(CDNTaskInfo cDNTaskInfo) {
        if (cDNTaskInfo == null || bi.oN(cDNTaskInfo.downloadUrl)) {
            x.w("MicroMsg.CDNDownloadClient", "resumeDownloadTask, info invalid");
            return -1;
        }
        x.i("MicroMsg.CDNDownloadClient", "resumeDownloadTask: " + cDNTaskInfo.downloadUrl);
        cDNTaskInfo.lxp = true;
        if (this.lwV != null) {
            try {
                int b = this.lwV.b(cDNTaskInfo);
                if (b != 0 && b != -2) {
                    return b;
                }
                this.lwW.add(cDNTaskInfo);
                return b;
            } catch (RemoteException e) {
                x.e("MicroMsg.CDNDownloadClient", "resumeDownloadTask, " + e.getMessage());
            }
        }
        this.lwW.add(cDNTaskInfo);
        aAC();
        return 0;
    }

    public final boolean yh(String str) {
        boolean z = false;
        x.i("MicroMsg.CDNDownloadClient", "removeDownloadTask: " + str);
        if (bi.oN(str)) {
            x.w("MicroMsg.CDNDownloadClient", "removeDownloadTask, url invalid");
            return z;
        }
        if (this.lwV != null) {
            try {
                this.lwW.remove(new CDNTaskInfo(str));
                return this.lwV.yh(str);
            } catch (RemoteException e) {
                x.e("MicroMsg.CDNDownloadClient", "removeDownloadTask, " + e.getMessage());
            }
        }
        x.i("MicroMsg.CDNDownloadClient", "removeDownloadTask false, service interface is null");
        return z;
    }

    public final CDNTaskState yi(String str) {
        CDNTaskState cDNTaskState = null;
        if (bi.oN(str)) {
            x.w("MicroMsg.CDNDownloadClient", "queryDownloadTask, url invalid");
            return cDNTaskState;
        } else if (this.lwV == null) {
            return cDNTaskState;
        } else {
            try {
                return this.lwV.yi(str);
            } catch (RemoteException e) {
                x.e("MicroMsg.CDNDownloadClient", "queryDownloadTask, " + e.getMessage());
                return cDNTaskState;
            }
        }
    }

    final void aAx() {
        if (this.lwV != null) {
            try {
                this.lwV.aAx();
            } catch (RemoteException e) {
                x.e("MicroMsg.CDNDownloadClient", "addIPCTaskMarker: " + e);
            }
        }
    }
}
