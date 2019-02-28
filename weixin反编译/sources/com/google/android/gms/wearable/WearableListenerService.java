package com.google.android.gms.wearable;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.util.Log;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.e;
import com.google.android.gms.common.k;
import com.google.android.gms.wearable.c.b;
import com.google.android.gms.wearable.internal.AmsEntityUpdateParcelable;
import com.google.android.gms.wearable.internal.AncsNotificationParcelable;
import com.google.android.gms.wearable.internal.CapabilityInfoParcelable;
import com.google.android.gms.wearable.internal.ChannelEventParcelable;
import com.google.android.gms.wearable.internal.MessageEventParcelable;
import com.google.android.gms.wearable.internal.NodeParcelable;
import com.google.android.gms.wearable.n.c;
import java.util.List;

public abstract class WearableListenerService extends Service implements com.google.android.gms.wearable.a.a, com.google.android.gms.wearable.b.a, b, com.google.android.gms.wearable.k.a, n.b, c {
    private boolean aFS;
    private IBinder aMY;
    private volatile int bdE = -1;
    private String bdF;
    private Handler bdG;
    private Object bdH = new Object();

    private class a extends com.google.android.gms.wearable.internal.w.a {
        boolean bdI = false;

        a() {
            this.bdI = WearableListenerService.this instanceof zzj;
        }

        public final void a(final DataHolder dataHolder) {
            if (Log.isLoggable("WearableLS", 3)) {
                new StringBuilder("onDataItemChanged: ").append(WearableListenerService.this.bdF).append(": ").append(dataHolder);
            }
            WearableListenerService.b(WearableListenerService.this);
            synchronized (WearableListenerService.this.bdH) {
                if (WearableListenerService.this.aFS) {
                    dataHolder.close();
                    return;
                }
                WearableListenerService.this.bdG.post(new Runnable() {
                    public final void run() {
                        e eVar = new e(dataHolder);
                        try {
                            WearableListenerService.this.a(eVar);
                        } finally {
                            eVar.release();
                        }
                    }
                });
            }
        }

        public final void a(final AmsEntityUpdateParcelable amsEntityUpdateParcelable) {
            if (Log.isLoggable("WearableLS", 3)) {
                new StringBuilder("onEntityUpdate: ").append(amsEntityUpdateParcelable);
            }
            if (this.bdI) {
                WearableListenerService.b(WearableListenerService.this);
                final zzj zzj = (zzj) WearableListenerService.this;
                synchronized (WearableListenerService.this.bdH) {
                    if (WearableListenerService.this.aFS) {
                        return;
                    }
                    WearableListenerService.this.bdG.post(new Runnable() {
                        public final void run() {
                        }
                    });
                }
            }
        }

        public final void a(final AncsNotificationParcelable ancsNotificationParcelable) {
            if (Log.isLoggable("WearableLS", 3)) {
                new StringBuilder("onNotificationReceived: ").append(ancsNotificationParcelable);
            }
            if (this.bdI) {
                WearableListenerService.b(WearableListenerService.this);
                final zzj zzj = (zzj) WearableListenerService.this;
                synchronized (WearableListenerService.this.bdH) {
                    if (WearableListenerService.this.aFS) {
                        return;
                    }
                    WearableListenerService.this.bdG.post(new Runnable() {
                        public final void run() {
                        }
                    });
                }
            }
        }

        public final void a(final CapabilityInfoParcelable capabilityInfoParcelable) {
            if (Log.isLoggable("WearableLS", 3)) {
                new StringBuilder("onConnectedCapabilityChanged: ").append(capabilityInfoParcelable);
            }
            WearableListenerService.b(WearableListenerService.this);
            synchronized (WearableListenerService.this.bdH) {
                if (WearableListenerService.this.aFS) {
                    return;
                }
                WearableListenerService.this.bdG.post(new Runnable() {
                    public final void run() {
                    }
                });
            }
        }

        public final void a(final ChannelEventParcelable channelEventParcelable) {
            if (Log.isLoggable("WearableLS", 3)) {
                new StringBuilder("onChannelEvent: ").append(channelEventParcelable);
            }
            WearableListenerService.b(WearableListenerService.this);
            synchronized (WearableListenerService.this.bdH) {
                if (WearableListenerService.this.aFS) {
                    return;
                }
                WearableListenerService.this.bdG.post(new Runnable() {
                    public final void run() {
                        channelEventParcelable.a(WearableListenerService.this);
                    }
                });
            }
        }

        public final void a(final MessageEventParcelable messageEventParcelable) {
            if (Log.isLoggable("WearableLS", 3)) {
                new StringBuilder("onMessageReceived: ").append(messageEventParcelable);
            }
            WearableListenerService.b(WearableListenerService.this);
            synchronized (WearableListenerService.this.bdH) {
                if (WearableListenerService.this.aFS) {
                    return;
                }
                WearableListenerService.this.bdG.post(new Runnable() {
                    public final void run() {
                        WearableListenerService.this.a(messageEventParcelable);
                    }
                });
            }
        }

        public final void a(final NodeParcelable nodeParcelable) {
            if (Log.isLoggable("WearableLS", 3)) {
                new StringBuilder("onPeerConnected: ").append(WearableListenerService.this.bdF).append(": ").append(nodeParcelable);
            }
            WearableListenerService.b(WearableListenerService.this);
            synchronized (WearableListenerService.this.bdH) {
                if (WearableListenerService.this.aFS) {
                    return;
                }
                WearableListenerService.this.bdG.post(new Runnable() {
                    public final void run() {
                        WearableListenerService.this.a(nodeParcelable);
                    }
                });
            }
        }

        public final void b(final NodeParcelable nodeParcelable) {
            if (Log.isLoggable("WearableLS", 3)) {
                new StringBuilder("onPeerDisconnected: ").append(WearableListenerService.this.bdF).append(": ").append(nodeParcelable);
            }
            WearableListenerService.b(WearableListenerService.this);
            synchronized (WearableListenerService.this.bdH) {
                if (WearableListenerService.this.aFS) {
                    return;
                }
                WearableListenerService.this.bdG.post(new Runnable() {
                    public final void run() {
                        WearableListenerService.this.b(nodeParcelable);
                    }
                });
            }
        }

        public final void u(final List<NodeParcelable> list) {
            if (Log.isLoggable("WearableLS", 3)) {
                new StringBuilder("onConnectedNodes: ").append(WearableListenerService.this.bdF).append(": ").append(list);
            }
            WearableListenerService.b(WearableListenerService.this);
            synchronized (WearableListenerService.this.bdH) {
                if (WearableListenerService.this.aFS) {
                    return;
                }
                WearableListenerService.this.bdG.post(new Runnable() {
                    public final void run() {
                    }
                });
            }
        }
    }

    static /* synthetic */ void b(WearableListenerService wearableListenerService) {
        int callingUid = Binder.getCallingUid();
        if (callingUid == wearableListenerService.bdE) {
            return;
        }
        if (e.a(wearableListenerService, callingUid, "com.google.android.wearable.app.cn")) {
            if (k.pp().a(wearableListenerService.getPackageManager(), "com.google.android.wearable.app.cn")) {
                wearableListenerService.bdE = callingUid;
                return;
            }
            throw new SecurityException("Caller is not Android Wear.");
        } else if (e.m(wearableListenerService, callingUid)) {
            wearableListenerService.bdE = callingUid;
        } else {
            throw new SecurityException("Caller is not GooglePlayServices");
        }
    }

    public void a(Channel channel) {
    }

    public void a(Channel channel, int i, int i2) {
    }

    public void a(e eVar) {
    }

    public void a(l lVar) {
    }

    public void a(m mVar) {
    }

    public void b(Channel channel, int i, int i2) {
    }

    public void b(m mVar) {
    }

    public void c(Channel channel, int i, int i2) {
    }

    public final IBinder onBind(Intent intent) {
        return "com.google.android.gms.wearable.BIND_LISTENER".equals(intent.getAction()) ? this.aMY : null;
    }

    public void onCreate() {
        super.onCreate();
        if (Log.isLoggable("WearableLS", 3)) {
            new StringBuilder("onCreate: ").append(getPackageName());
        }
        this.bdF = getPackageName();
        HandlerThread handlerThread = new HandlerThread("WearableListenerService");
        handlerThread.start();
        this.bdG = new Handler(handlerThread.getLooper());
        this.aMY = new a();
    }

    public void onDestroy() {
        synchronized (this.bdH) {
            this.aFS = true;
            if (this.bdG == null) {
                throw new IllegalStateException("onDestroy: mServiceHandler not set, did you override onCreate() but forget to call super.onCreate()?");
            }
            this.bdG.getLooper().quit();
        }
        super.onDestroy();
    }
}
