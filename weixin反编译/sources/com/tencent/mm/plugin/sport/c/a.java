package com.tencent.mm.plugin.sport.c;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import com.tencent.mm.f.a.qq;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sport.service.SportService;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.be;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.util.Calendar;

public final class a {
    public c<qq> rZH = new c<qq>() {
        {
            this.xmG = qq.class.getName().hashCode();
        }

        private boolean a(qq qqVar) {
            long bDV;
            boolean fc;
            switch (qqVar.fJc.action) {
                case 1:
                case 2:
                case 3:
                    g.bEa();
                    if (a.bDX()) {
                        a.this.bDW();
                        bDV = a.this.bDV();
                        if (qqVar.fJc.action == 1) {
                            fc = a.this.fc(bDV);
                        } else if (n.H(a.this.bDU(), bDV)) {
                            fc = a.this.fc(bDV);
                        } else {
                            fc = false;
                        }
                        x.i("MicroMsg.Sport.DeviceStepManager", "upload step %d %d %b", Integer.valueOf(qqVar.fJc.action), Long.valueOf(bDV), Boolean.valueOf(fc));
                        break;
                    }
                    break;
                case 4:
                case 5:
                    g.bEa();
                    if (a.bDX()) {
                        a.this.bDW();
                        bDV = a.this.bDV();
                        a aVar = a.this;
                        if (aVar.rZK == 0) {
                            aVar.rZK = i.K(3, 0);
                        }
                        boolean G = n.G(aVar.rZK, System.currentTimeMillis());
                        if (n.H(a.this.bDU(), bDV) || G) {
                            fc = a.this.fc(bDV);
                        } else {
                            fc = false;
                        }
                        x.i("MicroMsg.Sport.DeviceStepManager", "upload step %d %d result %b timeCondition %b stepCountCondition %b", Integer.valueOf(qqVar.fJc.action), Long.valueOf(bDV), Boolean.valueOf(fc), Boolean.valueOf(G), Boolean.valueOf(r5));
                        break;
                    }
                    break;
            }
            return false;
        }
    };
    public f rZI;
    private long rZJ;
    long rZK;
    public com.tencent.mm.plugin.sport.a.a rZL;
    private ServiceConnection rZM = new ServiceConnection() {
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            x.i("MicroMsg.Sport.DeviceStepManager", "onServiceConnected %s", componentName.toShortString());
            a.this.rZL = com.tencent.mm.plugin.sport.a.a.a.S(iBinder);
        }

        public final void onServiceDisconnected(ComponentName componentName) {
            x.i("MicroMsg.Sport.DeviceStepManager", "onServiceDisconnected %s", componentName.toShortString());
            a.this.rZL = null;
        }
    };

    static /* synthetic */ boolean bDX() {
        return n.dA(ad.getContext()) && n.bDN();
    }

    public a() {
        this.rZH.cfB();
    }

    public final boolean fc(long j) {
        if (this.rZI != null) {
            g.CN().c(this.rZI);
        }
        Calendar instance = Calendar.getInstance();
        instance.set(11, 0);
        instance.set(12, 0);
        instance.set(13, 0);
        long timeInMillis = instance.getTimeInMillis();
        x.i("MicroMsg.Sport.DeviceStepManager", "update device Step time: %s stepCount: %s", n.bq(System.currentTimeMillis()), Long.valueOf(j));
        this.rZI = new f("", "gh_43f2581f6fd6", (int) (timeInMillis / 1000), (int) (r6 / 1000), (int) j, be.ckL(), 1);
        g.CN().a(this.rZI, 0);
        long currentTimeMillis = System.currentTimeMillis();
        this.rZK = currentTimeMillis;
        i.L(3, currentTimeMillis);
        this.rZJ = j;
        i.L(4, this.rZJ);
        return true;
    }

    public final long bDU() {
        if (this.rZJ == 0) {
            this.rZJ = i.K(4, 0);
        }
        return this.rZJ;
    }

    public final long bDV() {
        long bDR;
        long currentTimeMillis = System.currentTimeMillis();
        String str = "";
        if (this.rZL != null) {
            try {
                bDR = this.rZL.bDR();
                try {
                    str = "exdevice";
                } catch (RemoteException e) {
                }
            } catch (RemoteException e2) {
                bDR = -1;
            }
        } else {
            bDR = -1;
        }
        if (bDR == -1) {
            long chg = bi.chg() / 10000;
            long yv = i.yv(202);
            bDR = i.yv(201);
            if (yv == chg) {
                str = "mm";
            } else {
                str = "unknow";
                bDR = 0;
            }
        }
        x.i("MicroMsg.Sport.DeviceStepManager", "get today step from %s process %d use time %d", str, Long.valueOf(bDR), Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        return bDR;
    }

    public final void bDW() {
        if (!n.dA(ad.getContext())) {
            try {
                if (this.rZL != null) {
                    ad.getContext().unbindService(this.rZM);
                }
                ad.getContext().stopService(new Intent(ad.getContext(), SportService.class));
            } catch (Exception e) {
            }
            this.rZL = null;
        } else if (this.rZL != null) {
            x.i("MicroMsg.Sport.DeviceStepManager", "Not need bind");
        } else {
            x.i("MicroMsg.Sport.DeviceStepManager", "start to bind sport aidl");
            try {
                Intent intent = new Intent(ad.getContext(), SportService.class);
                intent.setFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                ad.getContext().bindService(intent, this.rZM, 1);
            } catch (Exception e2) {
            }
        }
    }
}
