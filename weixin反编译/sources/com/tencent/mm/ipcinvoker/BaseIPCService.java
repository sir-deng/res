package com.tencent.mm.ipcinvoker;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Process;
import android.os.RemoteException;
import com.tencent.mm.ipcinvoker.b.a.a;
import com.tencent.mm.ipcinvoker.b.b;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashSet;
import java.util.Set;

public abstract class BaseIPCService extends Service {
    private volatile boolean gNM;
    private volatile boolean gNN;
    private a gNO = new a() {
        public final void a(final Bundle bundle, String str, final b bVar) {
            if (str == null || str.length() == 0) {
                x.e("IPC.BaseIPCService", "invokeAsync failed, class is null or nil.");
                return;
            }
            final a aVar = (a) o.d(str, a.class);
            if (aVar == null) {
                x.e("IPC.BaseIPCService", "invokeAsync failed, can not newInstance by class %s.", str);
                return;
            }
            if (bundle != null) {
                bundle.setClassLoader(BaseIPCService.class.getClassLoader());
            }
            n.post(new Runnable() {
                public final void run() {
                    aVar.a(bundle, new c() {
                        public final void i(Bundle bundle) {
                            if (bVar != null) {
                                if (bundle != null) {
                                    try {
                                        bundle.setClassLoader(BaseIPCService.class.getClassLoader());
                                    } catch (RemoteException e) {
                                        x.e("IPC.BaseIPCService", "%s", e);
                                        return;
                                    }
                                }
                                bVar.i(bundle);
                            }
                        }
                    });
                }
            });
        }

        public final Bundle d(Bundle bundle, String str) {
            if (str == null || str.length() == 0) {
                x.e("IPC.BaseIPCService", "invokeAsync failed, class is null or nil.");
                return null;
            }
            l lVar = (l) o.d(str, l.class);
            if (lVar == null) {
                x.e("IPC.BaseIPCService", "invokeSync failed, can not newInstance by class %s.", str);
                return null;
            }
            if (bundle != null) {
                bundle.setClassLoader(BaseIPCService.class.getClassLoader());
            }
            return lVar.j(bundle);
        }
    };

    public abstract String By();

    public IBinder onBind(Intent intent) {
        x.i("IPC.BaseIPCService", "onBind(%s), killSelf(%s)", intent, Boolean.valueOf(this.gNM));
        if (this.gNM) {
            x.i("IPC.BaseIPCService", "need to kill self, return null Binder object.");
            return null;
        }
        k BC = k.BC();
        String BB = e.BB();
        if (!(BB == null || BB.length() == 0 || this == null)) {
            BC.gOs.put(BB, this);
        }
        this.gNN = true;
        return this.gNO;
    }

    public boolean onUnbind(Intent intent) {
        x.i("IPC.BaseIPCService", "onUnbind(%s)", intent);
        boolean onUnbind = super.onUnbind(intent);
        this.gNN = false;
        return onUnbind;
    }

    public final void bu(boolean z) {
        if (!this.gNN || z) {
            x.i("IPC.BaseIPCService", "kill self(%s)", By());
            this.gNM = true;
            b.Bz().BA();
            b Bz = b.Bz();
            x.i("IPC.IPCBridgeManager", "releaseAllIPCBridge");
            if (!Bz.gNW.isEmpty()) {
                synchronized (Bz.gNW) {
                    if (Bz.gNW.isEmpty()) {
                    } else {
                        Set<String> hashSet = new HashSet(Bz.gNW.keySet());
                        if (!hashSet.isEmpty()) {
                            for (String fi : hashSet) {
                                Bz.fi(fi);
                            }
                        }
                    }
                }
            }
            stopSelf();
            k BC = k.BC();
            BC.gOs.remove(By());
            n.h(new Runnable() {
                public final void run() {
                    Process.killProcess(Process.myPid());
                }
            });
            return;
        }
        x.i("IPC.BaseIPCService", "abort kill self(%s), the service was connected by other process.", By());
    }
}
