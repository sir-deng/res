package com.tencent.mm.booter;

import android.app.Notification;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.IBinder;
import android.os.Looper;
import android.os.MessageQueue.IdleHandler;
import android.os.Process;
import com.tencent.mars.comm.WakerLock;
import com.tencent.mm.a.h;
import com.tencent.mm.a.n;
import com.tencent.mm.ad.e;
import com.tencent.mm.f.a.lw;
import com.tencent.mm.kernel.api.g;
import com.tencent.mm.modelmulti.k;
import com.tencent.mm.modelmulti.m;
import com.tencent.mm.plugin.report.d;
import com.tencent.mm.plugin.zero.PluginZero;
import com.tencent.mm.protocal.aa;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class NotifyReceiver extends BroadcastReceiver {
    private static WakerLock gzE = null;
    private static WakerLock gzR = null;
    private static Set<Long> gzS = new HashSet();
    private static Lock gzT = new ReentrantLock(false);
    private static byte[] gzU = new byte[0];
    private static byte[] gzV = new byte[0];
    private static a gzW;
    private static boolean gzX = true;

    public static class NotifyService extends Service {
        Boolean gAa = null;
        private g gAb;

        public static class InnerService extends Service {
            public void onCreate() {
                super.onCreate();
                try {
                    startForeground(-1212, new Notification());
                } catch (NullPointerException e) {
                    x.e("MicroMsg.NotifyReceiver", "set service for mm exception:%s", e);
                }
                stopSelf();
            }

            public void onDestroy() {
                stopForeground(true);
                super.onDestroy();
            }

            public IBinder onBind(Intent intent) {
                return null;
            }
        }

        public void onStart(Intent intent, int i) {
            k(intent);
        }

        public int onStartCommand(Intent intent, int i, int i2) {
            x.i("MicroMsg.NotifyReceiver", "NotifyService onStartCommand flags :" + i + "startId :" + i2 + " intent " + intent);
            k(intent);
            return 2;
        }

        public IBinder onBind(Intent intent) {
            return null;
        }

        private void k(final Intent intent) {
            if (intent == null) {
                x.e("MicroMsg.NotifyReceiver", "receiveImp receiveIntent == null");
                return;
            }
            int i;
            if (com.tencent.mm.kernel.g.Dr().gSp.gSI) {
                boolean i2 = false;
            } else {
                x.e("MicroMsg.NotifyReceiver", "summerboot WorkerProfile not has create, status %d", Integer.valueOf(0));
                if (this.gAb != null) {
                    com.tencent.mm.kernel.g.Dr().b(this.gAb);
                }
                final long currentTimeMillis = System.currentTimeMillis();
                this.gAb = new g() {
                    public final void um() {
                        com.tencent.mm.kernel.g.Dr().b((g) this);
                        NotifyService.this.gAb = null;
                        long currentTimeMillis = System.currentTimeMillis() - currentTimeMillis;
                        x.i("MicroMsg.NotifyReceiver", "summerboot startupDone[%b] take[%d]ms tid[%d] post last notify task", Boolean.valueOf(com.tencent.mm.kernel.g.Dr().gSp.gSI), Long.valueOf(currentTimeMillis), Long.valueOf(Thread.currentThread().getId()));
                        d.pVE.h(11098, Integer.valueOf(3600), Long.valueOf(currentTimeMillis));
                        d.pVE.a(99, 214, 1, false);
                        ah.h(new Runnable() {
                            public final void run() {
                                x.i("MicroMsg.NotifyReceiver", "summerboot startupDone do delay notify task");
                                NotifyService.this.l(intent);
                                d.pVE.a(99, 215, 1, false);
                            }
                        }, 500);
                    }

                    public final void aI(boolean z) {
                    }
                };
                com.tencent.mm.kernel.g.Dr().a(this.gAb);
                d.pVE.a(99, 213, 1, false);
                i2 = -1;
            }
            if (i2 < 0) {
                x.e("MicroMsg.NotifyReceiver", "summerboot status %s", Integer.valueOf(-1));
                return;
            }
            l(intent);
        }

        private void l(Intent intent) {
            int intExtra = intent.getIntExtra("notify_option_type", 0);
            if (intExtra == 0) {
                x.e("MicroMsg.NotifyReceiver", "receiveImp invalid opcode.");
            } else if (!com.tencent.mm.kernel.g.Do().CF() || com.tencent.mm.kernel.a.Cz()) {
                x.e("MicroMsg.NotifyReceiver", "receiveImp hasSetuin:%b  isHold:%b  opcode:%d", Boolean.valueOf(com.tencent.mm.kernel.g.Do().CF()), Boolean.valueOf(com.tencent.mm.kernel.a.Cz()), Integer.valueOf(intExtra));
            } else {
                int i;
                if (com.tencent.mm.kernel.g.CN().hoF == null) {
                    x.w("MicroMsg.NotifyReceiver", "receiveImp  opcode:%d  getDispatcher == null", Integer.valueOf(intExtra));
                    com.tencent.mm.kernel.g.CN().bE(true);
                }
                if (this.gAa == null) {
                    NotifyService notifyService;
                    boolean z;
                    NotifyService notifyService2;
                    if (b.cfx()) {
                        notifyService = this;
                    } else {
                        i = bi.getInt(((com.tencent.mm.plugin.zero.b.a) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.zero.b.a.class)).Af().getValue("AndroidOldNotifyReceiver"), 0);
                        com.tencent.mm.kernel.g.Dr();
                        com.tencent.mm.kernel.g.Do();
                        if (i > h.aJ(com.tencent.mm.kernel.a.Cn(), 100)) {
                            z = true;
                            notifyService2 = this;
                            notifyService2.gAa = Boolean.valueOf(z);
                        } else {
                            notifyService = this;
                        }
                    }
                    notifyService2 = notifyService;
                    z = false;
                    notifyService2.gAa = Boolean.valueOf(z);
                }
                x.i("MicroMsg.NotifyReceiver", "handleCommand useOld:%s operationCode:%d", this.gAa, Integer.valueOf(intExtra));
                switch (intExtra) {
                    case 1:
                        if (this.gAa.booleanValue()) {
                            r(ad.getContext(), "NotifyReceiver.handleCommand:NOTIFY_OPCODE_NETWORK_AVAILABLE");
                        }
                        Context context = ad.getContext();
                        x.i("MicroMsg.NotifyReceiver", "dealWithLooper");
                        if (!com.tencent.mm.kernel.g.Do().CF() || com.tencent.mm.kernel.a.Cz()) {
                            x.w("MicroMsg.NotifyReceiver", "receiveImp hasSetuin:" + com.tencent.mm.kernel.g.Do().CF() + " isHold:" + com.tencent.mm.kernel.a.Cz());
                            return;
                        }
                        if (!com.tencent.mm.kernel.g.CN().foreground) {
                            Object obj = (context == null || ao.isWap(context)) ? null : 1;
                            if (obj != null) {
                                com.tencent.mm.kernel.g.CN().a(new k(), 0);
                                return;
                            }
                        }
                        ((com.tencent.mm.plugin.zero.b.b) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.zero.b.b.class)).Qj().ig(2);
                        return;
                    case 2:
                        int intExtra2;
                        byte[] byteArrayExtra;
                        byte[] byteArrayExtra2;
                        long longExtra;
                        String str;
                        String str2;
                        Object[] objArr;
                        int i2;
                        String str3;
                        String str4;
                        Object[] objArr2;
                        Object obj2;
                        aa.b bVar;
                        if (this.gAa.booleanValue()) {
                            r(ad.getContext(), "NotifyReceiver.handleCommand:NOTIFY_OPCODE_NOTIFY");
                            intExtra2 = intent.getIntExtra("notify_respType", 0);
                            byteArrayExtra = intent.getByteArrayExtra("notify_respBuf");
                            byteArrayExtra2 = intent.getByteArrayExtra("notify_skey");
                            longExtra = intent.getLongExtra("notfiy_recv_time", -1);
                            str = "MicroMsg.NotifyReceiver";
                            str2 = "dealWithNotify respType:%d recvTime:%d respBuf:%d sessionkey:%s ";
                            objArr = new Object[4];
                            objArr[0] = Integer.valueOf(intExtra2);
                            objArr[1] = Long.valueOf(longExtra);
                            objArr[2] = Integer.valueOf(byteArrayExtra == null ? -1 : byteArrayExtra.length);
                            objArr[3] = bi.Wz(bi.bA(byteArrayExtra2));
                            x.i(str, str2, objArr);
                            switch (intExtra2) {
                                case 39:
                                    com.tencent.mm.kernel.g.CN().a(new k(), 0);
                                    return;
                                case 138:
                                    intExtra = byteArrayExtra == null ? 7 : n.p(byteArrayExtra, 0);
                                    i2 = byteArrayExtra == null ? 2 : 1;
                                    str3 = "MicroMsg.NotifyReceiver";
                                    str4 = "dkpush NOTIFY or SyncCheck selector:%d scnen:%d  respBuf:%d ";
                                    objArr2 = new Object[3];
                                    objArr2[0] = Integer.valueOf(intExtra);
                                    objArr2[1] = Integer.valueOf(i2);
                                    objArr2[2] = Integer.valueOf(byteArrayExtra == null ? -1 : byteArrayExtra.length);
                                    x.d(str3, str4, objArr2);
                                    try {
                                        NotifyReceiver.gzT.lock();
                                        i = ((com.tencent.mm.plugin.zero.b.b) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.zero.b.b.class)).Qj().a((long) intExtra, i2, "");
                                        if (i > 0) {
                                            x.d("MicroMsg.NotifyReceiver", "add scene hash to memo, hash:%d", Integer.valueOf(i));
                                            NotifyReceiver.gzS.add(Long.valueOf((long) i));
                                            s(ad.getContext(), "NotifyReceiver.dealWithNotify:MMFunc_NewSync");
                                        }
                                        try {
                                            NotifyReceiver.gzT.unlock();
                                            return;
                                        } catch (Exception e) {
                                            return;
                                        }
                                    } catch (Throwable th) {
                                        try {
                                            NotifyReceiver.gzT.unlock();
                                        } catch (Exception e2) {
                                        }
                                        throw th;
                                    }
                                case 268369921:
                                    if (bi.by(byteArrayExtra2)) {
                                        x.e("MicroMsg.NotifyReceiver", "dkpush dealWithNotify session:" + byteArrayExtra2);
                                        return;
                                    } else if (bi.by(byteArrayExtra) || byteArrayExtra.length <= 8) {
                                        x.e("MicroMsg.NotifyReceiver", "dkpush dealWithNotify respBuf error ");
                                        return;
                                    } else {
                                        i = n.p(byteArrayExtra, 0);
                                        i2 = n.p(byteArrayExtra, 4);
                                        if (i2 != byteArrayExtra.length - 8) {
                                            x.e("MicroMsg.NotifyReceiver", "dkpush: respBuf length error len:" + byteArrayExtra.length);
                                            return;
                                        }
                                        obj2 = new byte[i2];
                                        System.arraycopy(byteArrayExtra, 8, obj2, 0, i2);
                                        x.i("MicroMsg.NotifyReceiver", "dkpush PUSHDATA flag:%d bufLen:%d respBuf:%d recvTime:%d", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(byteArrayExtra.length), Long.valueOf(longExtra));
                                        try {
                                            NotifyReceiver.gzT.lock();
                                            m.a(i, obj2, byteArrayExtra2, longExtra);
                                            NotifyReceiver.gzS.add(Long.valueOf(longExtra));
                                            s(ad.getContext(), "NotifyReceiver.NotifyData");
                                            try {
                                                NotifyReceiver.gzT.unlock();
                                                return;
                                            } catch (Exception e3) {
                                                return;
                                            }
                                        } catch (Throwable th2) {
                                            try {
                                                NotifyReceiver.gzT.unlock();
                                            } catch (Exception e4) {
                                            }
                                            throw th2;
                                        }
                                    }
                                case 1000000205:
                                    x.d("MicroMsg.NotifyReceiver", "oreh on newsynccheck2 notify, notify=" + (byteArrayExtra != null));
                                    bVar = new aa.b();
                                    try {
                                        bVar.E(byteArrayExtra);
                                        NotifyReceiver.gzT.lock();
                                        i = ((com.tencent.mm.plugin.zero.b.b) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.zero.b.b.class)).Qj().a(bVar.vII, 1, bVar.cex());
                                        if (i > 0) {
                                            x.d("MicroMsg.NotifyReceiver", "add scene hash to memo, hash:%d", Integer.valueOf(i));
                                            NotifyReceiver.gzS.add(Long.valueOf((long) i));
                                            s(ad.getContext(), "NotifyReceiver.dealWithNotify:MM_PKT_NEW_SYNC_CHECK2_RESP");
                                        }
                                        try {
                                            NotifyReceiver.gzT.unlock();
                                            return;
                                        } catch (Exception e5) {
                                            return;
                                        }
                                    } catch (Throwable th22) {
                                        x.printErrStackTrace("MicroMsg.NotifyReceiver", th22, "", new Object[0]);
                                        try {
                                            NotifyReceiver.gzT.unlock();
                                            return;
                                        } catch (Exception e6) {
                                            return;
                                        }
                                    } catch (Throwable th222) {
                                        try {
                                            NotifyReceiver.gzT.unlock();
                                        } catch (Exception e7) {
                                        }
                                        throw th222;
                                    }
                                case 2147480001:
                                    x.d("MicroMsg.NotifyReceiver", "dkpush GCM Notify");
                                    i = ((com.tencent.mm.plugin.zero.b.b) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.zero.b.b.class)).Qj().a(7, 13, "");
                                    try {
                                        NotifyReceiver.gzT.lock();
                                        if (i > 0) {
                                            x.d("MicroMsg.NotifyReceiver", "add scene hash to memo, hash:%d", Integer.valueOf(i));
                                            NotifyReceiver.gzS.add(Long.valueOf((long) i));
                                            s(ad.getContext(), "NotifyReceiver.dealWithNotify:MM_PKT_GCM_NOTIFY");
                                        }
                                        try {
                                            NotifyReceiver.gzT.unlock();
                                            return;
                                        } catch (Exception e8) {
                                            return;
                                        }
                                    } catch (Throwable th2222) {
                                        try {
                                            NotifyReceiver.gzT.unlock();
                                        } catch (Exception e9) {
                                        }
                                        throw th2222;
                                    }
                                default:
                                    ((PluginZero) com.tencent.mm.kernel.g.k(PluginZero.class)).vhn.a(this, intExtra2, byteArrayExtra, byteArrayExtra2, longExtra);
                                    return;
                            }
                        }
                        intExtra2 = intent.getIntExtra("notify_respType", 0);
                        byteArrayExtra = intent.getByteArrayExtra("notify_respBuf");
                        byteArrayExtra2 = intent.getByteArrayExtra("notify_skey");
                        longExtra = intent.getLongExtra("notfiy_recv_time", -1);
                        str = "MicroMsg.NotifyReceiver";
                        str2 = "dealWithNotify respType:%d recvTime:%d respBuf:%d sessionkey:%s ";
                        objArr = new Object[4];
                        objArr[0] = Integer.valueOf(intExtra2);
                        objArr[1] = Long.valueOf(longExtra);
                        objArr[2] = Integer.valueOf(byteArrayExtra == null ? -1 : byteArrayExtra.length);
                        objArr[3] = bi.Wz(bi.bA(byteArrayExtra2));
                        x.i(str, str2, objArr);
                        switch (intExtra2) {
                            case 39:
                                com.tencent.mm.kernel.g.CN().a(new k(), 0);
                                return;
                            case 138:
                                intExtra = byteArrayExtra == null ? 7 : n.p(byteArrayExtra, 0);
                                i2 = byteArrayExtra == null ? 2 : 1;
                                str3 = "MicroMsg.NotifyReceiver";
                                str4 = "dkpush NOTIFY or SyncCheck selector:%d scnen:%d  respBuf:%d ";
                                objArr2 = new Object[3];
                                objArr2[0] = Integer.valueOf(intExtra);
                                objArr2[1] = Integer.valueOf(i2);
                                objArr2[2] = Integer.valueOf(byteArrayExtra == null ? -1 : byteArrayExtra.length);
                                x.i(str3, str4, objArr2);
                                ((com.tencent.mm.plugin.zero.b.b) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.zero.b.b.class)).Qj().a((long) intExtra, i2, "");
                                return;
                            case 268369921:
                                if (bi.by(byteArrayExtra2)) {
                                    x.e("MicroMsg.NotifyReceiver", "dkpush dealWithNotify session:" + byteArrayExtra2);
                                    return;
                                } else if (bi.by(byteArrayExtra) || byteArrayExtra.length <= 8) {
                                    x.e("MicroMsg.NotifyReceiver", "dkpush dealWithNotify respBuf error ");
                                    return;
                                } else {
                                    i = n.p(byteArrayExtra, 0);
                                    i2 = n.p(byteArrayExtra, 4);
                                    if (i2 != byteArrayExtra.length - 8) {
                                        x.e("MicroMsg.NotifyReceiver", "dkpush: respBuf length error len:" + byteArrayExtra.length);
                                        return;
                                    }
                                    obj2 = new byte[i2];
                                    System.arraycopy(byteArrayExtra, 8, obj2, 0, i2);
                                    x.i("MicroMsg.NotifyReceiver", "dkpush PUSHDATA flag:%d bufLen:%d respBuf:%d recvTime:%d", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(byteArrayExtra.length), Long.valueOf(longExtra));
                                    m.a(i, obj2, byteArrayExtra2, longExtra);
                                    return;
                                }
                            case 1000000205:
                                x.i("MicroMsg.NotifyReceiver", "oreh on newsynccheck2 notify, notify=" + (byteArrayExtra != null));
                                bVar = new aa.b();
                                ((com.tencent.mm.plugin.zero.b.b) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.zero.b.b.class)).Qj().a(bVar.vII, 1, bVar.cex());
                                return;
                            case 2147480001:
                                x.i("MicroMsg.NotifyReceiver", "dkpush GCM Notify");
                                ((com.tencent.mm.plugin.zero.b.b) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.zero.b.b.class)).Qj().a(7, 13, "");
                                return;
                            default:
                                ((PluginZero) com.tencent.mm.kernel.g.k(PluginZero.class)).vhn.a(this, intExtra2, byteArrayExtra, byteArrayExtra2, longExtra);
                                return;
                        }
                    default:
                        x.e("MicroMsg.NotifyReceiver", "invald opCode:" + intExtra);
                        return;
                }
            }
        }

        public void onCreate() {
            super.onCreate();
            if (VERSION.SDK_INT < 24 && !com.tencent.mm.compatible.util.h.zq()) {
                if (VERSION.SDK_INT < 18) {
                    startForeground(-1212, new Notification());
                } else if (getSharedPreferences("system_config_prefs", 4).getBoolean("set_service", false)) {
                    startForeground(-1212, new Notification());
                    startService(new Intent(this, InnerService.class));
                    x.i("MicroMsg.NotifyReceiver", "set service for mm.");
                }
                new ag().postDelayed(new Runnable() {
                    public final void run() {
                        NotifyService.this.stopForeground(true);
                    }
                }, ad.cgg().getLong("mm_stop_service_time", 86400000));
            }
        }

        public static void ei(String str) {
            synchronized (NotifyReceiver.gzU) {
                if (NotifyReceiver.gzE == null) {
                    NotifyReceiver.gzE = new WakerLock(ad.getContext());
                }
            }
            NotifyReceiver.gzE.lock(5000, str);
        }

        private static void r(Context context, String str) {
            synchronized (NotifyReceiver.gzU) {
                if (NotifyReceiver.gzE == null) {
                    NotifyReceiver.gzE = new WakerLock(context);
                }
                NotifyReceiver.gzE.lock(14000, str);
            }
        }

        private static void s(Context context, String str) {
            synchronized (NotifyReceiver.gzV) {
                if (NotifyReceiver.gzR == null) {
                    NotifyReceiver.gzR = new WakerLock(context);
                }
                NotifyReceiver.gzR.lock(60000, str);
            }
        }
    }

    public static class a implements e {
        private static long gzY = 0;

        static /* synthetic */ void a(a aVar) {
            com.tencent.mm.kernel.g.Dr();
            com.tencent.mm.kernel.g.Dt().F(new Runnable() {
                public final void run() {
                    if (com.tencent.mm.kernel.g.Do().CF()) {
                        int i;
                        if (bi.e((Integer) com.tencent.mm.kernel.g.Dq().Db().get(15, null)) == 0) {
                            i = 1;
                        } else {
                            i = 0;
                        }
                        if (i != 0) {
                            x.e("MicroMsg.NotifyReceiver", "not init finish , do not post sync task");
                            return;
                        }
                        long Wy = bi.Wy();
                        if (Wy - a.gzY <= 0 || Wy - a.gzY >= 10000) {
                            a.gzY = Wy;
                            x.i("MicroMsg.NotifyReceiver", "begin post sync task");
                            Wy = bi.Wz();
                            com.tencent.mm.sdk.b.a.xmy.m(new lw());
                            x.i("MicroMsg.NotifyReceiver", "end post sync task, cost=%d, Idle done", Long.valueOf(bi.bB(Wy)));
                            a.this.ax(3000);
                            return;
                        }
                        x.d("MicroMsg.NotifyReceiver", "sync task limit now - last : %d", Long.valueOf(Wy - a.gzY));
                    }
                }

                public final String toString() {
                    return super.toString() + "|doPostSyncTask";
                }
            });
        }

        public final void a(int i, int i2, String str, com.tencent.mm.ad.k kVar) {
            long j;
            long hashCode = (long) kVar.hashCode();
            if (kVar.getType() == 268369922) {
                j = ((com.tencent.mm.modelmulti.h) kVar).hGO;
            } else {
                j = hashCode;
            }
            try {
                NotifyReceiver.gzT.lock();
                synchronized (NotifyReceiver.gzV) {
                    String str2 = "MicroMsg.NotifyReceiver";
                    String str3 = "NotifyReceiver onSceneEnd type:%d syncHash: %d hashInMemo: %b isLocking: %b";
                    Object[] objArr = new Object[4];
                    objArr[0] = Integer.valueOf(kVar.getType());
                    objArr[1] = Long.valueOf(j);
                    objArr[2] = Boolean.valueOf(NotifyReceiver.gzS.contains(Long.valueOf(j)));
                    objArr[3] = Boolean.valueOf(NotifyReceiver.gzR != null ? NotifyReceiver.gzR.isLocking() : false);
                    x.i(str2, str3, objArr);
                }
                NotifyReceiver.gzS.remove(Long.valueOf(j));
                try {
                    NotifyReceiver.gzT.unlock();
                } catch (Exception e) {
                }
                try {
                    NotifyReceiver.gzT.lock();
                    if (NotifyReceiver.gzS.isEmpty()) {
                        synchronized (NotifyReceiver.gzV) {
                            if (NotifyReceiver.gzR != null) {
                                NotifyReceiver.gzR.unLock();
                            }
                        }
                        x.i("MicroMsg.NotifyReceiver", "all scene done, unlock wakelock.");
                    } else {
                        x.i("MicroMsg.NotifyReceiver", "rest %d scene undone, keep wakelock.", Integer.valueOf(NotifyReceiver.gzS.size()));
                    }
                    try {
                        NotifyReceiver.gzT.unlock();
                    } catch (Exception e2) {
                    }
                    switch (kVar.getType()) {
                        case 138:
                            if (com.tencent.mm.kernel.g.Do().CF()) {
                                Looper.myQueue().addIdleHandler(new IdleHandler() {
                                    public final boolean queueIdle() {
                                        a.a(a.this);
                                        return false;
                                    }
                                });
                                if (i == 0 && i2 == 0 && com.tencent.mm.y.a.EW()) {
                                    try {
                                        com.tencent.mm.kernel.g.Dr();
                                        com.tencent.mm.y.a aVar = com.tencent.mm.kernel.g.Do().gQY;
                                        if (aVar.hgh > -1) {
                                            aVar.hgh++;
                                        }
                                        x.i("MicroMsg.AccInfoCacheInWorker", "countNormalCgi :%s ", Long.valueOf(aVar.hgh));
                                        if (aVar.hgh == 2 || aVar.hgh == 5) {
                                            d.pVE.a(226, aVar.hgh == 2 ? 37 : 38, 1, false);
                                            d.pVE.h(11098, Integer.valueOf(2001), Long.valueOf(aVar.hgh));
                                            break;
                                        }
                                    } catch (Throwable th) {
                                        x.e("MicroMsg.AccInfoCacheInWorker", "tryBackupToWorker Exception:%s", bi.i(th));
                                        break;
                                    }
                                }
                            }
                            break;
                    }
                    ax(7000);
                } catch (Throwable th2) {
                    try {
                        NotifyReceiver.gzT.unlock();
                    } catch (Exception e3) {
                    }
                    throw th2;
                }
            } catch (Throwable th22) {
                try {
                    NotifyReceiver.gzT.unlock();
                } catch (Exception e4) {
                }
                throw th22;
            }
        }

        private void ax(long j) {
            if (com.tencent.mm.network.aa.VQ().getBoolean("is_in_notify_mode", false)) {
                new ag(Looper.myLooper()).postDelayed(new Runnable() {
                    public final void run() {
                        x.i("MicroMsg.NotifyReceiver", "checkKillProcess, canKillProcess :%b", Boolean.valueOf(NotifyReceiver.gzX));
                        synchronized (NotifyReceiver.gzU) {
                            if (NotifyReceiver.gzE != null) {
                                NotifyReceiver.gzE.unLock();
                            }
                            NotifyReceiver.gzE = null;
                        }
                        if (NotifyReceiver.gzX) {
                            PluginZero pluginZero = (PluginZero) com.tencent.mm.kernel.g.k(PluginZero.class);
                            if (pluginZero.vhm != null) {
                                pluginZero.vhm.arJ();
                            }
                            x.cfY();
                            Process.killProcess(Process.myPid());
                        }
                    }
                }, j);
            }
        }
    }

    public static void wM() {
        x.i("MicroMsg.NotifyReceiver", "markUIShow");
        gzX = false;
        com.tencent.mm.network.aa.VQ().edit().putBoolean("is_in_notify_mode", false).commit();
    }

    public static void wN() {
        com.tencent.mm.kernel.g.CN().b(138, gzW);
        com.tencent.mm.kernel.g.CN().b(39, gzW);
        com.tencent.mm.kernel.g.CN().b(268369922, gzW);
        if (gzW == null) {
            gzW = new a();
        }
        com.tencent.mm.kernel.g.CN().a(138, gzW);
        com.tencent.mm.kernel.g.CN().a(39, gzW);
        com.tencent.mm.kernel.g.CN().a(268369922, gzW);
    }

    public void onReceive(Context context, Intent intent) {
        x.i("MicroMsg.NotifyReceiver", "onReceive intent :%s", intent);
        if (intent != null) {
            if (com.tencent.mm.kernel.k.aX(context)) {
                x.i("MicroMsg.NotifyReceiver", "fully exited, no need to start service");
                return;
            }
            com.tencent.mm.ai.a.hB(intent.getIntExtra("notify_respType", -1));
            Intent intent2 = new Intent(context, NotifyService.class);
            if (intent.getBooleanExtra("intent_from_shoot_key", false)) {
                intent2.putExtra("notify_option_type", 3);
            }
            intent2.putExtras(intent);
            context.startService(intent2);
        }
    }
}
