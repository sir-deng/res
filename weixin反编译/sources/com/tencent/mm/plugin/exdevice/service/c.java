package com.tencent.mm.plugin.exdevice.service;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.as;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class c implements ServiceConnection {
    public a lVO;
    public volatile boolean lVP;
    private List<Runnable> lVQ = new LinkedList();

    public static abstract class a {
        public int ftr;

        public abstract void onServiceConnected();

        public a(int i) {
            this.ftr = i;
        }
    }

    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        List arrayList;
        x.i("MicroMsg.exdevice.ExDeviceServiceConnection", "onServiceConnected");
        x xVar = new x(com.tencent.mm.plugin.exdevice.service.h.a.J(iBinder));
        u.a(xVar);
        ad.cgm();
        xVar.a(com.tencent.mm.plugin.exdevice.b.a.aEl());
        xVar.b(com.tencent.mm.plugin.exdevice.model.a.aEw());
        if (!xVar.a(com.tencent.mm.plugin.exdevice.model.ad.aFd())) {
            x.e("MicroMsg.exdevice.ExDeviceServiceConnection", "simpleBluetoothRegistOnRecv error");
        }
        if (this.lVO != null) {
            this.lVO.onServiceConnected();
        }
        this.lVP = true;
        synchronized (this.lVQ) {
            arrayList = new ArrayList(this.lVQ);
            this.lVQ.clear();
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < arrayList.size()) {
                Runnable runnable = (Runnable) arrayList.get(i2);
                if (runnable != null) {
                    runnable.run();
                }
                i = i2 + 1;
            } else {
                arrayList.clear();
                return;
            }
        }
    }

    public final void onServiceDisconnected(ComponentName componentName) {
        x.i("MicroMsg.exdevice.ExDeviceServiceConnection", "onServiceDisconnected");
        this.lVP = false;
        u.a(null);
        ad.cgm();
        if (!as.Ho() || as.Cz()) {
            x.i("MicroMsg.exdevice.ExDeviceServiceConnection", "no user login, ignore this disconnection");
        } else {
            cy(ad.getContext());
        }
    }

    public final void cy(Context context) {
        if (!d.cz(context)) {
            x.i("MicroMsg.exdevice.ExDeviceServiceConnection", "ensureServiceInstance return false");
        } else if (context.bindService(new Intent(context, ExDeviceService.class), this, 1)) {
            x.i("MicroMsg.exdevice.ExDeviceServiceConnection", "bind exdeviceservice success");
        } else {
            x.e("MicroMsg.exdevice.ExDeviceServiceConnection", "bind exdeviceservice failed");
        }
    }

    public final boolean v(Runnable runnable) {
        if (this.lVP) {
            runnable.run();
        } else {
            synchronized (this.lVQ) {
                this.lVQ.add(runnable);
            }
        }
        return true;
    }
}
