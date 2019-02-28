package com.tencent.mm.booter;

import android.app.Notification;
import android.app.Service;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.os.Build.VERSION;
import android.os.IBinder;
import android.os.Looper;
import android.os.Process;
import com.jg.EType;
import com.jg.JgMethodChecked;
import com.tencent.mars.Mars;
import com.tencent.mars.comm.Alarm;
import com.tencent.mars.comm.PlatformComm;
import com.tencent.mars.comm.PlatformComm.IResetProcess;
import com.tencent.mars.comm.WakerLock;
import com.tencent.mars.magicbox.IPxxLogic;
import com.tencent.mars.stn.StnLogic;
import com.tencent.mm.booter.MMReceivers.AlarmReceiver;
import com.tencent.mm.compatible.util.h;
import com.tencent.mm.f.a.nl;
import com.tencent.mm.kernel.g;
import com.tencent.mm.kernel.k;
import com.tencent.mm.network.aa;
import com.tencent.mm.network.aa.a;
import com.tencent.mm.network.ac;
import com.tencent.mm.network.af;
import com.tencent.mm.network.m;
import com.tencent.mm.network.p;
import com.tencent.mm.network.t;
import com.tencent.mm.network.t.AnonymousClass12;
import com.tencent.mm.network.w;
import com.tencent.mm.network.y;
import com.tencent.mm.network.z;
import com.tencent.mm.platformtools.f;
import com.tencent.mm.plugin.report.d;
import com.tencent.mm.plugin.zero.PluginZero;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ab.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public class CoreService extends Service implements IResetProcess, a, m {
    private int gzA = -1;
    private long gzB = 0;
    private long gzC = 0;
    private long gzD = 0;
    private WakerLock gzE = null;
    private f gzF = new f();
    private al gzG = new al(new al.a() {
        public final boolean uG() {
            boolean z;
            f a = CoreService.this.gzF;
            if (bi.bB(a.iet) < a.ier) {
                x.i("MicroMsg.FrequncyLimiter", "frequency limited, last=" + a.iet + ", cur=" + bi.Wz() + ", retries=" + a.ieu);
                if (a.ieu <= 0) {
                    z = false;
                } else {
                    a.ieu--;
                    a.iet = bi.Wz();
                    z = true;
                }
            } else {
                a.ieu = a.ies;
                a.iet = bi.Wz();
                z = true;
            }
            if (z) {
                x.i("MicroMsg.CoreService", "setNetworkAvailable  deal with Sync Check isSessionKeyNull:%b, isMMProcessExist:%b", Boolean.valueOf(bi.by(CoreService.this.gzw.iby.CM())), Boolean.valueOf(aa.VX().VE()));
                if (bi.by(CoreService.this.gzw.iby.CM()) || r3 || !f.a(1, 0, null, CoreService.this.gzw.iby.CM(), bi.Wy())) {
                    CoreService.wJ();
                } else {
                    x.i("MicroMsg.CoreService", "setNetworkAvailable deal with notify sync in push");
                    return true;
                }
            }
            x.e("MicroMsg.CoreService", "setNetworkAvailable checker frequency limited");
            x.i("MicroMsg.CoreService", "setNetworkAvailable finish lockCount:%d delayCount:%d delayDur:%d", Long.valueOf(CoreService.this.gzB), Long.valueOf(CoreService.this.gzD), Long.valueOf(bi.Wy() - CoreService.this.gzC));
            CoreService.this.gzB = 0;
            CoreService.this.gzD = 0;
            CoreService.this.gzC = 0;
            new al(new al.a() {
                public final boolean uG() {
                    CoreService.this.gzE.unLock();
                    return false;
                }
            }, false).K(500, 500);
            return true;
        }
    }, false);
    private t gzw;
    private e gzx = new e();
    private boolean gzy = true;
    private final b gzz = new b() {
        public final void prepare() {
            AlarmReceiver.aB(CoreService.this.getApplicationContext());
        }

        public final void cancel() {
            AlarmReceiver.aC(CoreService.this.getApplicationContext());
        }
    };

    public static class InnerService extends Service {
        public void onCreate() {
            super.onCreate();
            try {
                startForeground(-1213, new Notification());
            } catch (NullPointerException e) {
                x.e("MicroMsg.CoreService", "set service for push exception:%s.", e);
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

    @JgMethodChecked(author = 20, fComment = "checked", lastDate = "20140429", reviewer = 20, vComment = {EType.RECEIVERCHECK})
    public void onCreate() {
        String string;
        String string2;
        String str;
        NetworkInfo networkInfo = null;
        x.d("MicroMsg.CoreService", "onCreate~~~threadID:" + Thread.currentThread());
        super.onCreate();
        if (VERSION.SDK_INT < 24 && !h.zq()) {
            if (VERSION.SDK_INT < 18) {
                startForeground(-1213, new Notification());
            } else if (getSharedPreferences("system_config_prefs", 4).getBoolean("set_service", false)) {
                startForeground(-1213, new Notification());
                startService(new Intent(this, InnerService.class));
                x.i("MicroMsg.CoreService", "set service for push.");
            }
        }
        ag agVar = new ag(Looper.getMainLooper());
        Mars.init(ad.getContext(), agVar);
        StnLogic.setCallBack(new af());
        IPxxLogic.setCallBack(new p());
        com.tencent.mm.jni.a.a.BU();
        com.tencent.mm.sdk.b.a.xmy.b(new c<nl>() {
            {
                this.xmG = nl.class.getName().hashCode();
            }

            public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
                String str = ((nl) bVar).fGn.fGo;
                if (bi.oN(str)) {
                    return false;
                }
                d.pVE.a(12900, str, true, false);
                return true;
            }
        });
        aa.VR();
        ab.a(this.gzz);
        if (PlatformComm.resetprocessimp == null) {
            PlatformComm.resetprocessimp = this;
        }
        aa.a(agVar);
        aa.setContext(getApplicationContext());
        aa.a(new com.tencent.mm.network.ab());
        aa.a(new ac());
        aa.a((a) this);
        aa.a(new w());
        this.gzw = aa.VX();
        if (this.gzw == null) {
            x.i("MicroMsg.CoreService", "autoAuth is null and new one");
            this.gzw = new t(aa.VV());
            aa.b(this.gzw);
        } else {
            x.w("MicroMsg.CoreService", "autoAuth is not null and reset");
            this.gzw.reset();
        }
        Mars.onCreate(true);
        if (aa.VY() == null) {
            x.i("MicroMsg.CoreService", "NetTaskAdapter is null and new one");
            aa.a(new z());
        } else {
            x.w("MicroMsg.CoreService", "NetTaskAdapter is not null and reset");
            aa.VY().reset();
        }
        if (aa.VZ() == null) {
            x.i("MicroMsg.CoreService", "NetNotifyAdapter is null and new one");
            aa.a(new y());
            aa.VZ().ics = this;
            if (aa.Wc()) {
                aa.ch(false);
                aa.VV().post(new Runnable() {
                    public final void run() {
                        x.i("MicroMsg.CoreService", "NetNotifyAdapter NeedNotifyGCM after init");
                        aa.VZ().onPush(2147480001, new byte[0]);
                    }

                    public final String toString() {
                        return "NotifyGCM";
                    }
                });
            }
        }
        c cVar = ((com.tencent.mm.kernel.b.h) g.Dn().CU()).gAA;
        if (cVar != null) {
            this.gzw.e(cVar.getString(".com.tencent.mm.debug.server.host.http"), cVar.getString(".com.tencent.mm.debug.server.ports.http"), cVar.getString(".com.tencent.mm.debug.server.host.socket"), cVar.getString(".com.tencent.mm.debug.server.ports.socket"));
            string = cVar.getString(".com.tencent.mm.debug.server.wallet.host");
            string2 = cVar.getString(".com.tencent.mm.debug.server.wallet.ip");
            t tVar = this.gzw;
            if (!(bi.oN(string) || bi.G(new String[0]))) {
                new AnonymousClass12(string, string2).b(tVar.handler);
            }
        }
        if (cVar == null) {
            str = networkInfo;
        } else {
            str = cVar.getString(".com.tencent.mm.debug.server.host.newdns");
        }
        if (str == null || !str.contains(":")) {
            string = str;
            Object obj = networkInfo;
        } else {
            String[] split = str.split(":");
            string = split[0];
            str = split[1];
        }
        this.gzw.setNewDnsDebugHost(string, str);
        AlarmReceiver.aE(getApplicationContext());
        AlarmReceiver.aD(getApplicationContext());
        try {
            networkInfo = ((ConnectivityManager) getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.CoreService", e, "", new Object[0]);
            x.e("MicroMsg.CoreService", "getActiveNetworkInfo failed. %s", e.getMessage());
        }
        if (networkInfo == null || networkInfo.getState() != State.CONNECTED) {
            string = "MicroMsg.CoreService";
            string2 = "networkInfo.state: %s";
            Object[] objArr = new Object[1];
            objArr[0] = networkInfo == null ? "null" : networkInfo.getState();
            x.e(string, string2, objArr);
            aa.VT().icL = false;
            aa.VU().iW(0);
        } else {
            aa.VT().icL = true;
            aa.VU().iW(6);
        }
        ((PluginZero) g.k(PluginZero.class)).vho.a(this);
        x.i("MicroMsg.CoreService", "CoreService OnCreate ");
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        int myPid = Process.myPid();
        x.i("MicroMsg.CoreService", "onStartCommand lastpid:%d  pid:%d flags:%d startId:%d", Integer.valueOf(this.gzA), Integer.valueOf(myPid), Integer.valueOf(i), Integer.valueOf(i2));
        if (myPid != this.gzA) {
            this.gzA = myPid;
            d.pVE.a(99, 141, 1, false);
            if (intent != null && "auto".equals(intent.getStringExtra("START_TYPE"))) {
                d.pVE.a(99, 140, 1, false);
            }
        }
        return 1;
    }

    public void onDestroy() {
        x.d("MicroMsg.CoreService", "onDestroy~~~ threadID:" + Thread.currentThread());
        ((PluginZero) g.k(PluginZero.class)).vho.b(this);
        com.tencent.mm.jni.a.a.BV();
        super.onDestroy();
        wK();
    }

    public boolean onUnbind(Intent intent) {
        x.d("MicroMsg.CoreService", "onUnbind~~~ threadID:" + Thread.currentThread());
        aa.VT().icK = null;
        aa.Wb().icl = null;
        return super.onUnbind(intent);
    }

    public IBinder onBind(Intent intent) {
        x.d("MicroMsg.CoreService", "onBind~~~ threadID:" + Thread.currentThread());
        return this.gzw;
    }

    public void onRebind(Intent intent) {
        x.d("MicroMsg.CoreService", "onRebind~~~ threadID:" + Thread.currentThread());
        super.onRebind(intent);
    }

    public final boolean d(int i, byte[] bArr) {
        if (k.aX(this)) {
            x.i("MicroMsg.CoreService", "fully exited, no need to notify worker");
            return false;
        }
        int i2;
        if (i == -255) {
            i2 = 138;
        } else {
            i2 = i;
        }
        boolean z = aa.VQ().getBoolean("is_in_notify_mode", false);
        boolean by = bi.by(this.gzw.iby.CM());
        boolean VE = aa.VX().VE();
        if (!(!z || by || VE)) {
            if (f.a(2, i2, bArr, this.gzw.iby.CM(), bi.Wy())) {
                x.i("MicroMsg.CoreService", "deal with notify sync in push");
                return true;
            }
        }
        x.i("MicroMsg.CoreService", "deal with notify sync to mm by broast, isSessionKeyNull:%b, isMMProcessExist:%b, isInNotifyMode:%b", Boolean.valueOf(by), Boolean.valueOf(VE), Boolean.valueOf(z));
        Intent intent = new Intent(this, NotifyReceiver.class);
        intent.putExtra("notify_option_type", 2);
        intent.putExtra("notify_uin", this.gzw.iby.Cn());
        intent.putExtra("notify_respType", i2);
        intent.putExtra("notify_respBuf", bArr);
        intent.putExtra("notfiy_recv_time", bi.Wy());
        intent.putExtra("notify_skey", this.gzw.iby.CM());
        x.i("MicroMsg.CoreService", "notify broadcast:" + intent.getAction() + ", type=" + i2);
        try {
            x.i("MicroMsg.CoreService", "notify broadcast: dknot recvTime:%d uin:%d type:%d buf:%d", Long.valueOf(intent.getLongExtra("notfiy_recv_time", 0)), Integer.valueOf(intent.getIntExtra("notify_uin", 0)), Integer.valueOf(intent.getIntExtra("notify_respType", 0)), Integer.valueOf(bi.i(intent.getByteArrayExtra("notify_respBuf"), new byte[0]).length));
            sendBroadcast(intent);
            com.tencent.mm.ai.a.hA(i2);
        } catch (Throwable th) {
            x.e("MicroMsg.CoreService", "dknot sendBroadcast  failed:%s", bi.i(th));
        }
        return true;
    }

    public final void aU(boolean z) {
        if (z) {
            x.w("MicroMsg.CoreService", "[NETWORK CONNECTED]");
            aa.VT().icL = true;
            boolean wL = this.gzx.wL();
            if (!this.gzy || wL) {
                if (wL) {
                    aa.VX().Vw();
                }
                this.gzy = true;
                aa.VU().iW(6);
                if (this.gzE == null) {
                    this.gzE = new WakerLock(getApplicationContext());
                }
                if (!this.gzE.isLocking()) {
                    this.gzE.lock(6000, "CoreService.setNetworkAvailable");
                    this.gzB++;
                }
                if (0 == this.gzD) {
                    this.gzC = bi.Wy();
                }
                this.gzD++;
                x.i("MicroMsg.CoreService", "setNetworkAvailable start lockCount:%d delayCount:%d delayDur:%d", Long.valueOf(this.gzB), Long.valueOf(this.gzD), Long.valueOf(bi.Wy() - this.gzC));
                this.gzG.K(3000, 3000);
                return;
            }
            x.i("MicroMsg.CoreService", "network not change or can't get network info, lastStatus connect:%b", Boolean.valueOf(this.gzy));
            return;
        }
        x.w("MicroMsg.CoreService", "[NETWORK LOST]");
        aa.VT().icL = false;
        aa.VU().iW(0);
        if (this.gzy) {
            aa.VX().Vw();
            e eVar = this.gzx;
            eVar.gzP = null;
            eVar.gzQ = null;
        }
        this.gzy = false;
    }

    public static void wJ() {
        Intent intent = new Intent(aa.getContext(), NotifyReceiver.class);
        intent.putExtra("notify_option_type", 1);
        intent.putExtra("notify_uin", aa.VX().iby.Cn());
        try {
            aa.getContext().sendBroadcast(intent);
        } catch (Exception e) {
            x.f("MicroMsg.CoreService", "checker frequency limited hasDestroyed %s", e.toString());
        }
    }

    private void wK() {
        x.w("MicroMsg.CoreService", "[COMPLETE EXIT]");
        aa.VY().e(3, 10000, "");
        Mars.onDestroy();
        try {
            AlarmReceiver.aE(getApplicationContext());
            AlarmReceiver.aC(getApplicationContext());
            Alarm.resetAlarm(getApplicationContext());
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.CoreService", e, "", new Object[0]);
        }
        x.appenderClose();
        Process.killProcess(Process.myPid());
    }

    public void restartProcess() {
        x.w("MicroMsg.CoreService", "restartProcess");
        wK();
    }
}
