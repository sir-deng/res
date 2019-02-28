package com.tencent.mm.sandbox.updater;

import android.app.Notification;
import android.app.Notification.Builder;
import android.app.PendingIntent;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build.VERSION;
import android.os.IBinder;
import com.jg.EType;
import com.jg.JgClassChecked;
import com.tencent.mm.sandbox.c;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import java.util.HashMap;
import java.util.Map;

@JgClassChecked(author = 20, fComment = "checked", lastDate = "20141015", reviewer = 20, vComment = {EType.RECEIVERCHECK})
public class UpdaterService extends Service {
    private static UpdaterService xmf = null;
    static final long xmh = 1800000;
    private boolean hJu = false;
    Map<Integer, a> xmg = new HashMap();
    private al xmi = new al(new com.tencent.mm.sdk.platformtools.al.a() {
        public final boolean uG() {
            return !UpdaterService.this.cfu();
        }
    }, true);
    private a xmj = null;

    @JgClassChecked(author = 20, fComment = "checked", lastDate = "20141015", reviewer = 20, vComment = {EType.RECEIVERCHECK})
    static final class a extends BroadcastReceiver {
        a() {
        }

        public final void onReceive(Context context, Intent intent) {
            if (UpdaterService.cft() != null) {
                UpdaterService cft = UpdaterService.cft();
                boolean isWifi = ao.isWifi(context);
                if (cft.xmg.size() > 0) {
                    for (a lC : cft.xmg.values()) {
                        lC.lC(isWifi);
                    }
                }
            }
        }
    }

    public static void cm() {
        x.i("MicroMsg.UpdaterService", "UpdaterService stopInstance()");
        if (xmf != null) {
            xmf.cfu();
        }
    }

    public static UpdaterService cft() {
        return xmf;
    }

    public void onCreate() {
        super.onCreate();
        x.i("MicroMsg.UpdaterService", "onCreate");
        c.h(hashCode(), this);
        xmf = this;
        this.xmg.put(Integer.valueOf(0), a.xme);
        this.xmg.put(Integer.valueOf(1), d.cfc());
        this.xmg.put(Integer.valueOf(2), d.cfc());
        this.xmg.put(Integer.valueOf(3), a.xmm);
        MMActivity.initLanguage(this);
        al alVar = this.xmi;
        long j = xmh;
        alVar.K(j, j);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        this.xmj = new a();
        registerReceiver(this.xmj, intentFilter);
    }

    public void onStart(Intent intent, int i) {
        x.i("MicroMsg.UpdaterService", "onStart intent = %s", intent);
        k(intent);
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        x.i("MicroMsg.UpdaterService", "onStartCommand intent = %s", intent);
        if (intent != null) {
            if (intent.getBooleanExtra("intent_extra_run_in_foreground", false)) {
                x.i("MicroMsg.UpdaterService", "runServiceInForground");
                startForeground(0, new Builder(this).setTicker("updater service running forground").setWhen(System.currentTimeMillis()).setContentTitle("Updater Service").setContentText("updater service running forground").setContentIntent(PendingIntent.getService(this, 0, new Intent(), 0)).getNotification());
                this.hJu = true;
            } else if (VERSION.SDK_INT < 18 && !this.hJu) {
                startForeground(-1314, new Notification());
                this.hJu = true;
            }
        }
        k(intent);
        return 2;
    }

    public void onDestroy() {
        x.i("MicroMsg.UpdaterService", "onDestroy");
        this.xmi.TN();
        if (this.xmj != null) {
            unregisterReceiver(this.xmj);
        }
        if (this.hJu) {
            stopForeground(true);
        }
        for (a onDestroy : this.xmg.values()) {
            onDestroy.onDestroy();
        }
        this.xmg.clear();
        xmf = null;
        c.i(hashCode(), this);
        super.onDestroy();
    }

    public IBinder onBind(Intent intent) {
        return null;
    }

    private void k(Intent intent) {
        if (intent != null) {
            x.i("MicroMsg.UpdaterService", "handleCommand, downloadType = %d", Integer.valueOf(intent.getIntExtra("intent_extra_download_type", 0)));
            a aVar = (a) this.xmg.get(Integer.valueOf(r0));
            if (aVar != null) {
                x.i("MicroMsg.UpdaterService", "handleCommand ret = %b", Boolean.valueOf(aVar.af(intent)));
                if (!aVar.af(intent)) {
                    cfu();
                }
            }
        }
    }

    private boolean cfu() {
        if (this.xmg.size() > 0) {
            for (a isBusy : this.xmg.values()) {
                if (isBusy.isBusy()) {
                    x.i("MicroMsg.UpdaterService", "checkAndTryStopSelf, dont stop, some download mgr still busy");
                    return false;
                }
            }
        }
        x.i("MicroMsg.UpdaterService", "checkAndTryStopSelf, UpdaterService killed self");
        ah.h(new Runnable() {
            public final void run() {
                if (UpdaterService.this.xmg.size() > 0) {
                    for (a isBusy : UpdaterService.this.xmg.values()) {
                        if (isBusy.isBusy()) {
                            x.i("MicroMsg.UpdaterService", "checkAndTryStopSelf2, dont stop, some download mgr still busy");
                            return;
                        }
                    }
                }
                if (com.tencent.mm.pluginsdk.model.x.a.bZj()) {
                    x.i("TBSDownloadMgr", "is still busy");
                } else {
                    UpdaterService.this.stopSelf();
                }
            }
        }, 10000);
        return true;
    }
}
