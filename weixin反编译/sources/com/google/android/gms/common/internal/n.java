package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.IBinder;
import android.os.Message;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

final class n extends m implements Callback {
    private final Context aGj;
    private final long aOA;
    private final HashMap<a, b> aOy = new HashMap();
    private final com.google.android.gms.common.stats.b aOz;
    private final Handler mHandler;

    private final class b {
        IBinder aMY;
        ComponentName aOD;
        final a aOE = new a();
        final Set<ServiceConnection> aOF = new HashSet();
        boolean aOG;
        final a aOH;
        int mState = 2;

        public class a implements ServiceConnection {
            public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                synchronized (n.this.aOy) {
                    b.this.aMY = iBinder;
                    b.this.aOD = componentName;
                    for (ServiceConnection onServiceConnected : b.this.aOF) {
                        onServiceConnected.onServiceConnected(componentName, iBinder);
                    }
                    b.this.mState = 1;
                }
            }

            public final void onServiceDisconnected(ComponentName componentName) {
                synchronized (n.this.aOy) {
                    b.this.aMY = null;
                    b.this.aOD = componentName;
                    for (ServiceConnection onServiceDisconnected : b.this.aOF) {
                        onServiceDisconnected.onServiceDisconnected(componentName);
                    }
                    b.this.mState = 2;
                }
            }
        }

        public b(a aVar) {
            this.aOH = aVar;
        }

        public final void a(ServiceConnection serviceConnection, String str) {
            n.this.aOz.a(n.this.aGj, serviceConnection, str, this.aOH.oQ(), 3);
            this.aOF.add(serviceConnection);
        }

        public final boolean a(ServiceConnection serviceConnection) {
            return this.aOF.contains(serviceConnection);
        }

        public final void aJ(String str) {
            this.aOG = n.this.aOz.a(n.this.aGj, str, this.aOH.oQ(), this.aOE, 129);
            if (this.aOG) {
                this.mState = 3;
                return;
            }
            try {
                n.this.aOz.a(n.this.aGj, this.aOE);
            } catch (IllegalArgumentException e) {
            }
        }

        public final boolean oR() {
            return this.aOF.isEmpty();
        }
    }

    private static final class a {
        private final String aOB;
        private final String aOC;
        private final ComponentName aOD;

        public a(ComponentName componentName) {
            this.aOB = null;
            this.aOC = null;
            this.aOD = (ComponentName) w.ag(componentName);
        }

        public a(String str, String str2) {
            this.aOB = w.aM(str);
            this.aOC = w.aM(str2);
            this.aOD = null;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return v.b(this.aOB, aVar.aOB) && v.b(this.aOD, aVar.aOD);
        }

        public final int hashCode() {
            return Arrays.hashCode(new Object[]{this.aOB, this.aOD});
        }

        public final Intent oQ() {
            return this.aOB != null ? new Intent(this.aOB).setPackage(this.aOC) : new Intent().setComponent(this.aOD);
        }

        public final String toString() {
            return this.aOB == null ? this.aOD.flattenToString() : this.aOB;
        }
    }

    n(Context context) {
        this.aGj = context.getApplicationContext();
        this.mHandler = new Handler(context.getMainLooper(), this);
        this.aOz = com.google.android.gms.common.stats.b.pj();
        this.aOA = 5000;
    }

    private void a(a aVar, ServiceConnection serviceConnection) {
        w.i(serviceConnection, "ServiceConnection must not be null");
        synchronized (this.aOy) {
            b bVar = (b) this.aOy.get(aVar);
            if (bVar == null) {
                throw new IllegalStateException("Nonexistent connection status for service config: " + aVar);
            } else if (bVar.a(serviceConnection)) {
                bVar.aOI.aOz.a(bVar.aOI.aGj, serviceConnection, null, null, 4);
                bVar.aOF.remove(serviceConnection);
                if (bVar.oR()) {
                    this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(0, bVar), this.aOA);
                }
            } else {
                throw new IllegalStateException("Trying to unbind a GmsServiceConnection  that was not bound before.  config=" + aVar);
            }
        }
    }

    private boolean a(a aVar, ServiceConnection serviceConnection, String str) {
        boolean z;
        w.i(serviceConnection, "ServiceConnection must not be null");
        synchronized (this.aOy) {
            b bVar = (b) this.aOy.get(aVar);
            if (bVar != null) {
                this.mHandler.removeMessages(0, bVar);
                if (!bVar.a(serviceConnection)) {
                    bVar.a(serviceConnection, str);
                    switch (bVar.mState) {
                        case 1:
                            serviceConnection.onServiceConnected(bVar.aOD, bVar.aMY);
                            break;
                        case 2:
                            bVar.aJ(str);
                            break;
                    }
                }
                throw new IllegalStateException("Trying to bind a GmsServiceConnection that was already connected before.  config=" + aVar);
            }
            bVar = new b(aVar);
            bVar.a(serviceConnection, str);
            bVar.aJ(str);
            this.aOy.put(aVar, bVar);
            z = bVar.aOG;
        }
        return z;
    }

    public final boolean a(ComponentName componentName, ServiceConnection serviceConnection, String str) {
        return a(new a(componentName), serviceConnection, str);
    }

    public final boolean a(String str, String str2, ServiceConnection serviceConnection, String str3) {
        return a(new a(str, str2), serviceConnection, str3);
    }

    public final void b(ComponentName componentName, ServiceConnection serviceConnection, String str) {
        a(new a(componentName), serviceConnection);
    }

    public final void b(String str, String str2, ServiceConnection serviceConnection, String str3) {
        a(new a(str, str2), serviceConnection);
    }

    public final boolean handleMessage(Message message) {
        switch (message.what) {
            case 0:
                b bVar = (b) message.obj;
                synchronized (this.aOy) {
                    if (bVar.oR()) {
                        if (bVar.aOG) {
                            bVar.aOI.aOz.a(bVar.aOI.aGj, bVar.aOE);
                            bVar.aOG = false;
                            bVar.mState = 2;
                        }
                        this.aOy.remove(bVar.aOH);
                    }
                }
                return true;
            default:
                return false;
        }
    }
}
