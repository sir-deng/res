package com.tencent.mm.sandbox.monitor;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.SystemClock;
import com.tencent.mm.modelrecovery.a;
import com.tencent.mm.sandbox.c;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.wcdb.database.SQLiteDatabase;

public class ExceptionMonitorService extends Service {
    public static long hjl = 0;
    public static int xkm = 0;
    private static ExceptionMonitorService xkq = null;
    private long xkn = 300000;
    private ag xko = new ag();
    private Runnable xkp = new Runnable() {
        public final void run() {
            x.d("MicroMsg.CrashMonitorService", "stopSelf");
            ExceptionMonitorService.this.stopSelf();
        }
    };
    private long xkr;

    public void onCreate() {
        super.onCreate();
        xkq = this;
        c.h(hashCode(), this);
        this.xko.postDelayed(this.xkp, this.xkn);
    }

    public void onStart(Intent intent, int i) {
        super.onStart(intent, i);
        k(intent);
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        k(intent);
        return 1;
    }

    public void onDestroy() {
        super.onDestroy();
        xkq = null;
        c.i(hashCode(), this);
        this.xko.removeCallbacks(this.xkp);
    }

    private void k(Intent intent) {
        if (intent != null) {
            this.xko.removeCallbacks(this.xkp);
            this.xko.postDelayed(this.xkp, this.xkn);
            String action = intent.getAction();
            x.d("MicroMsg.CrashMonitorService", "dkcrash handleCommand action:" + action);
            try {
                String stringExtra = intent.getStringExtra("tag");
                if (stringExtra == null) {
                    stringExtra = "exception";
                }
                int intExtra = intent.getIntExtra("exceptionPid", 0);
                stringExtra.equals("exception");
                xkm = intExtra;
                hjl = intent.getLongExtra("exceptionTime", SystemClock.elapsedRealtime());
                String stringExtra2 = intent.getStringExtra("exceptionMsg");
                String stringExtra3 = intent.getStringExtra("userName");
                boolean booleanExtra = intent.getBooleanExtra("exceptionWriteSdcard", true);
                x.d("MicroMsg.CrashMonitorService", "dkcrash handleCommand. action=" + action + " pid:" + intExtra + " tag=" + stringExtra + ", userName=" + stringExtra3 + ", message" + stringExtra2);
                if (!bi.oN(stringExtra2)) {
                    if (a.a(stringExtra3, stringExtra, new a(stringExtra3, stringExtra, bi.Wx(), stringExtra2, booleanExtra)) == 0) {
                        eE(this);
                    }
                    if (System.currentTimeMillis() - this.xkr > 600000) {
                        this.xkr = System.currentTimeMillis();
                        e.post(new Runnable() {
                            public final void run() {
                                a.QQ();
                            }
                        }, "RecoveryWriteLogThread");
                    }
                }
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.CrashMonitorService", e, "", new Object[0]);
            }
        }
    }

    public IBinder onBind(Intent intent) {
        return null;
    }

    public static void eE(Context context) {
        Intent intent = new Intent(context, CrashUploadAlarmReceiver.class);
        if (PendingIntent.getBroadcast(context, 0, intent, SQLiteDatabase.ENABLE_WRITE_AHEAD_LOGGING) == null) {
            PendingIntent broadcast = PendingIntent.getBroadcast(context, 0, intent, 0);
            ((AlarmManager) context.getSystemService("alarm")).set(0, bi.Wy() + 1800000, broadcast);
            x.d("MicroMsg.CrashMonitorService", "dkcrash startAlarmMgr pendingIntent:%d %d", Integer.valueOf(broadcast.hashCode()), Long.valueOf(r2));
        }
    }
}
