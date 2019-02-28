package com.tencent.mm.plugin.sport.service;

import android.app.Service;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.IBinder;
import android.os.Process;
import com.tencent.mm.plugin.sport.PluginSport;
import com.tencent.mm.plugin.sport.a.a.a;
import com.tencent.mm.plugin.sport.c.c;
import com.tencent.mm.plugin.sport.c.g;
import com.tencent.mm.plugin.sport.c.i;
import com.tencent.mm.plugin.sport.c.k;
import com.tencent.mm.plugin.sport.c.n;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public class SportService extends Service implements c {
    private SensorManager hSO;
    private k sap;
    private boolean saq = false;
    private final a sar = new a() {
        public final long bDR() {
            try {
                long chg = bi.chg() / 10000;
                long yv = i.yv(202);
                long yv2 = i.yv(201);
                int bEg = (int) k.bEg();
                if (k.bEh() == chg) {
                    x.i("MicroMsg.Sport.SportService", "cacheTime %s cacheStep:%s", Long.valueOf(k.bEh()), Integer.valueOf(bEg));
                    return (long) bEg;
                } else if (yv == chg) {
                    x.i("MicroMsg.Sport.SportService", "saveTime %s saveStep:%s", Long.valueOf(yv), Long.valueOf(yv2));
                    return (long) ((int) yv2);
                } else {
                    x.i("MicroMsg.Sport.SportService", "getStepCount:0, new day");
                    x.i("MicroMsg.Sport.SportService", "saveTime:%s, cacheTime: %S, beginOfToday:%s", Long.valueOf(yv), Long.valueOf(r8), Long.valueOf(chg));
                    return 0;
                }
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.Sport.SportService", e, "exception in :exdevice getTodayDeviceStepCount", new Object[0]);
                return 0;
            }
        }

        public final void ML(String str) {
            g.MM(str);
            if (!SportService.this.bEl()) {
                SportService.this.stopSelf();
            }
        }

        public final void bDS() {
        }

        public final void J(int i, long j) {
            ((PluginSport) com.tencent.mm.kernel.g.k(PluginSport.class)).getSportFileStorage().setLong(i, j);
        }

        public final long getLong(int i, long j) {
            return ((PluginSport) com.tencent.mm.kernel.g.k(PluginSport.class)).getSportFileStorage().getLong(i, j);
        }

        public final void bDT() {
            ((PluginSport) com.tencent.mm.kernel.g.k(PluginSport.class)).getSportFileStorage().reset();
            Process.killProcess(Process.myPid());
        }
    };
    private Sensor sensor;

    public void onCreate() {
        super.onCreate();
        x.i("MicroMsg.Sport.SportService", "onCreate");
        this.saq = n.dA(this);
        x.i("MicroMsg.Sport.SportService", "isSupportDeviceStep %b", Boolean.valueOf(this.saq));
        if (this.saq) {
            bEj();
            return;
        }
        x.i("MicroMsg.Sport.SportService", "stop self");
        stopSelf();
    }

    public IBinder onBind(Intent intent) {
        return this.sar;
    }

    private boolean bEj() {
        try {
            if (this.hSO == null) {
                this.hSO = (SensorManager) getSystemService("sensor");
            }
            if (this.sap == null) {
                this.sap = new k();
                this.sap.sai = this;
            }
            if (this.hSO == null || !getPackageManager().hasSystemFeature("android.hardware.sensor.stepcounter")) {
                x.i("MicroMsg.Sport.SportService", "no step sensor");
                return false;
            }
            this.sensor = this.hSO.getDefaultSensor(19);
            if (this.sensor == null) {
                x.i("MicroMsg.Sport.SportService", " TYPE_STEP_COUNTER sensor null");
                return false;
            }
            boolean registerListener = this.hSO.registerListener(this.sap, this.sensor, g.bEb().optInt("stepCounterRateUs", 60000));
            if (!registerListener) {
                bEk();
            }
            x.i("MicroMsg.Sport.SportService", "registerDetector() ok.(result : %s)", Boolean.valueOf(registerListener));
            return registerListener;
        } catch (Exception e) {
            x.e("MicroMsg.Sport.SportService", "Exception in registerDetector %s", e.getMessage());
        }
    }

    private void bEk() {
        try {
            if (this.hSO == null) {
                this.hSO = (SensorManager) getSystemService("sensor");
            }
            this.hSO.unregisterListener(this.sap);
            x.i("MicroMsg.Sport.SportService", "unregisterDetector() success!");
        } catch (Exception e) {
            x.e("MicroMsg.Sport.SportService", "Exception in unregisterDetector %s", e.getMessage());
        }
    }

    public void onDestroy() {
        x.i("MicroMsg.Sport.SportService", "onDestroy");
        if (this.saq) {
            bEk();
        }
        super.onDestroy();
    }

    public final boolean bEl() {
        this.saq = n.dA(this);
        if (!this.saq) {
            return false;
        }
        bEk();
        return bEj();
    }

    public final void bDZ() {
        bEk();
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        x.i("MicroMsg.Sport.SportService", "onStartCommand");
        try {
            if (this.saq) {
                if (this.sap != null) {
                    this.sap.sai = this;
                }
                if (bEl()) {
                    return 1;
                }
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.Sport.SportService", e, "Exception onStartCommand %s", new Object[0]);
        }
        return super.onStartCommand(intent, i, i2);
    }
}
