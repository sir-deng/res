package com.tencent.mm.app;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Process;
import com.tencent.mm.ad.p;
import com.tencent.mm.booter.CoreService;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.c;
import com.tencent.mm.network.e;
import com.tencent.mm.network.f;
import com.tencent.mm.network.h;
import com.tencent.mm.network.i;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.ab;
import com.tencent.mm.protocal.n;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.bw;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.concurrent.locks.ReentrantLock;
import junit.framework.Assert;

public final class d implements ServiceConnection {
    private static boolean ffc = false;
    private static Object lock = new Object();
    private ReentrantLock ffd = new ReentrantLock();
    private boolean ffe = false;
    private IBinder fff = null;
    private Runnable ffg = new Runnable() {
        private int ffm = 0;

        public final void run() {
            int i = 0;
            try {
                d.this.ffd.lock();
                boolean z = d.this.fff != null && d.this.fff.isBinderAlive();
                x.i("MicroMsg.CoreServiceConnection", "mZombieWaker run serviceBinder: %s, binderAlive: %b", d.this.fff, Boolean.valueOf(z));
                if (z) {
                    x.w("MicroMsg.CoreServiceConnection", "mZombieWaker run binderAlive return directly.");
                    return;
                }
                d.this.ffd.unlock();
                x.e("MicroMsg.CoreServiceConnection", String.format("CoreService started but not responding, possibly zombie. Use step %d to restart CoreService.", new Object[]{Integer.valueOf(this.ffm)}));
                if (this.ffm == 1) {
                    int cp = d.co("com.tencent.mm:push");
                    if (cp != -1) {
                        x.i("MicroMsg.CoreServiceConnection", String.format("Push Process %d killed.", new Object[]{Integer.valueOf(cp)}));
                        x.cfX();
                        Process.killProcess(cp);
                    } else {
                        x.i("MicroMsg.CoreServiceConnection", "Push Process not found.");
                    }
                }
                Context context = ad.getContext();
                Intent intent = new Intent(context, CoreService.class);
                try {
                    x.i("MicroMsg.CoreServiceConnection", "unbinding CoreService...");
                    context.unbindService(d.this);
                } catch (Exception e) {
                } finally {
                    context.stopService(intent);
                    i = d.this;
                    context.bindService(intent, i, 1);
                    context.startService(intent);
                }
                if (this.ffm == 1) {
                    this.ffm = i;
                } else {
                    this.ffm++;
                }
                ah.h(this, 10000);
                x.i("MicroMsg.CoreServiceConnection", String.format("ZombieWaker posted again with step %d", new Object[]{Integer.valueOf(this.ffm)}));
            } finally {
                d.this.ffd.unlock();
            }
        }
    };

    static /* synthetic */ void a(d dVar) {
        try {
            dVar.ffd.lock();
            dVar.ffe = false;
            dVar.fff = null;
            g.Do();
            if (!a.CE() || a.Cz()) {
                g.Dr();
                g.Dp().gRu.Kv();
                g.Dr();
                g.Dp().gRu.reset();
                return;
            }
            g.Dr();
            g.Dp().gRu.Ku();
            dVar.am(ad.getContext());
        } finally {
            dVar.ffd.unlock();
        }
    }

    static /* synthetic */ void a(d dVar, IBinder iBinder) {
        com.tencent.mm.blink.a.ee("onServiceConnected");
        synchronized (lock) {
            x.i("MicroMsg.CoreServiceConnection", "remove zombie killer.");
            ah.K(dVar.ffg);
            ffc = false;
        }
        if (iBinder == null) {
            Assert.assertTrue("WorkerProfile onServiceConnected binder == null", false);
            b.z("WorkerProfile onServiceConnected binder == null", "it will result in accInfo being null");
        }
        try {
            dVar.ffd.lock();
            dVar.ffe = false;
            dVar.fff = iBinder;
            e pVar = new p(f.a.B(iBinder));
            try {
                pVar.hoW.a(new s.a() {
                    public final boolean tN() {
                        return true;
                    }
                });
            } catch (Throwable e) {
                x.e("MicroMsg.RDispatcher", "exception:%s", bi.i(e));
            }
            try {
                pVar.hoW.a(new com.tencent.mm.network.g.a() {
                    public final void en(final int i) {
                        ah.y(new Runnable() {
                            public final void run() {
                                if (com.tencent.mm.kernel.b.CL() != null) {
                                    com.tencent.mm.kernel.b.CL().fX(i);
                                }
                            }
                        });
                    }
                });
            } catch (Throwable e2) {
                x.e("MicroMsg.RDispatcher", "exception:%s", bi.i(e2));
            }
            g.Dr();
            com.tencent.mm.kernel.b Dp = g.Dp();
            x.w("MMKernel.CoreNetwork", "setting up remote dispatcher " + pVar);
            Dp.gRt.b(pVar);
            pVar.a(new h.a() {
                public final void networkAnalysisCallBack(int i, int i2, boolean z, String str) {
                    x.i("MMKernel.CoreNetwork", "callback, kv:%s", str);
                    b.a(i, i2, z, str);
                }
            });
            try {
                i KE = pVar.KE();
                if (KE != null) {
                    KE.c(Dp.gRw);
                }
            } catch (Throwable e22) {
                x.e("MMKernel.CoreNetwork", "exception:%s", bi.i(e22));
            }
            pVar.a(new ab.a() {
                private byte[] gRB;

                public final byte[] CP() {
                    if (!g.Do().CF()) {
                        return null;
                    }
                    com.tencent.mm.protocal.aa.a aVar = new com.tencent.mm.protocal.aa.a();
                    g.Dr();
                    g.Do();
                    aVar.uin = a.Cn();
                    g.Dr();
                    aVar.hHj = bi.Wj((String) g.Dq().Db().get(8195, null));
                    aVar.netType = com.tencent.mm.protocal.a.getNetType(ad.getContext());
                    aVar.vIe = com.tencent.mm.protocal.a.ced();
                    try {
                        byte[] Hw = aVar.Hw();
                        this.gRB = aVar.gRB;
                        return Hw;
                    } catch (Throwable e) {
                        x.e("MMKernel.CoreNetwork", "exception:%s", bi.i(e));
                        return null;
                    }
                }

                public final int C(byte[] bArr) {
                    int i = 0;
                    com.tencent.mm.protocal.aa.b bVar = new com.tencent.mm.protocal.aa.b();
                    try {
                        bVar.E(bArr);
                        return (int) bVar.vII;
                    } catch (Throwable e) {
                        x.e("MMKernel.CoreNetwork", "exception:%s", bi.i(e));
                        return i;
                    }
                }

                public final byte[] CQ() {
                    return this.gRB;
                }
            });
            c KD = pVar.KD();
            if (KD == null) {
                x.f("MMKernel.CoreNetwork", "accInfo is null, it would assert before!!!");
                Dp.gRu.reset();
                Dp.gRu.Kv();
            } else {
                String str;
                b.a(new com.tencent.mm.sdk.a.a() {
                    public final void fK(String str) {
                        x.w("MMKernel.CoreNetwork", "CallbackForReset errorStack %s ", str);
                        g.Dr();
                        if (g.Ds() != null) {
                            g.Dr();
                            bw Ds = g.Ds();
                            Ds.bgH = true;
                            for (com.tencent.mm.y.bw.a aVar : Ds.hjG) {
                                if (aVar != null) {
                                    aVar.Il();
                                }
                            }
                            Ds.bgH = false;
                        }
                        g.Dr();
                        if (g.Dq() != null) {
                            g.Dr();
                            g.Dq().ed(str);
                        }
                    }
                });
                g.Dr();
                com.tencent.mm.storage.s sVar = g.Dq().gRO;
                Assert.assertTrue("setAutoAuth, getSysCfg() is null, stack = " + bi.chl(), sVar != null);
                int DE = sVar.DE(47);
                String str2 = (String) sVar.get(2);
                String str3 = (String) sVar.get(3);
                String str4 = (String) sVar.get(25);
                String str5 = (String) sVar.get(24);
                n.a fr = n.fr((String) sVar.get(6), (String) sVar.get(7));
                x.d("MMKernel.CoreNetwork", "dkidc host[s:%s l:%s] builtin[s:%s l:%s] ports[%s] timeout[%s] mmtls[%d]", str5, str4, str2, str3, str, r6, Integer.valueOf(DE));
                Assert.assertTrue("setAutoAuth, autoAuth is null, stack = " + bi.chl(), true);
                pVar.a(false, str2, str3, fr.vIi, fr.vIj, fr.vIk, fr.vIl, str5, str4);
                pVar.bJ((DE & 1) == 0);
                g.Dr();
                g.Do();
                Assert.assertTrue("setAutoAuth, accInfo is null, stack = " + bi.chl(), KD != null);
                if (g.Do().CF() && g.Do().gRj) {
                    Dp.gRu.d(pVar);
                    com.tencent.mm.network.b.a(new com.tencent.mm.network.b.a() {
                        public final e CR() {
                            try {
                                return b.this.gRu.hoF;
                            } catch (Throwable th) {
                                x.e("MMKernel.CoreNetwork", "%s", bi.i(th));
                                return null;
                            }
                        }
                    });
                    x.i("MMKernel.CoreNetwork", "setAutoAuth differrent accStg uin[%d], accInfo uin[%d], acc init[%b]", Integer.valueOf(a.Cn()), Integer.valueOf(KD.Cn()), Boolean.valueOf(g.Do().CF()));
                    if (a.Cn() != KD.Cn()) {
                        x.w("MMKernel.CoreNetwork", "update acc info with acc stg: uin =" + KD.Cn());
                        str = "setAutoAuth, getConfigStg() is null, stack = " + bi.chl();
                        g.Dr();
                        Assert.assertTrue(str, g.Dq().Db() != null);
                        g.Dr();
                        String str6 = (String) g.Dq().Db().get(2, null);
                        KD.v(new byte[0], a.Cn());
                        KD.setUsername(str6);
                    }
                } else {
                    x.w("MMKernel.CoreNetwork", "need to clear acc info and maybe stop networking accHasReady():%b isInitializedNotifyAllDone:%b", Boolean.valueOf(g.Do().CF()), Boolean.valueOf(g.Do().gRj));
                    com.tencent.mm.plugin.report.d.pVE.a(148, g.Do().CF() ? 44 : 43, 1, false);
                    KD.reset();
                    pVar.reset();
                    Dp.gRu.d(pVar);
                    com.tencent.mm.network.b.a(new com.tencent.mm.network.b.a() {
                        public final e CR() {
                            try {
                                return b.this.gRu.hoF;
                            } catch (Throwable th) {
                                x.e("MMKernel.CoreNetwork", "%s", bi.i(th));
                                return null;
                            }
                        }
                    });
                    if (a.Cn() != KD.Cn()) {
                        com.tencent.mm.plugin.report.d.pVE.a(148, 45, 1, false);
                        x.w("MMKernel.CoreNetwork", "summerauth update acc info with acc stg: old acc uin=%d, acc stg uin=%d, acc init %b %b", Integer.valueOf(KD.Cn()), Integer.valueOf(a.Cn()), Boolean.valueOf(g.Do().CF()), Boolean.valueOf(g.Do().gRj));
                        KD.eE(a.Cn());
                    } else {
                        x.i("MMKernel.CoreNetwork", "acc info uin same with acc stg", Integer.valueOf(KD.Cn()), Integer.valueOf(a.Cn()));
                    }
                }
            }
            if (com.tencent.mm.y.a.EW()) {
                try {
                    g.Dr();
                    if (g.Do().gQY != null) {
                        g.Dr();
                        if (g.Dp().gRu.hoF != null) {
                            g.Dr();
                            com.tencent.mm.y.a aVar = g.Do().gQY;
                            g.Dr();
                            c KD2 = g.Dp().gRu.hoF.KD();
                            long Wy = bi.Wy();
                            if (KD2 == null) {
                                x.e("MicroMsg.AccInfoCacheInWorker", "reuseToPush  accinfo == null");
                                com.tencent.mm.plugin.report.d.pVE.a(226, 6, 1, false);
                            } else {
                                x.i("MicroMsg.AccInfoCacheInWorker", "reuseToPush islogin:%b cache:%s", Boolean.valueOf(KD2.Kz()), Integer.valueOf(aVar.EV()));
                                if (KD2.Kz()) {
                                    if (aVar.EV() > 0) {
                                        com.tencent.mm.plugin.report.d.pVE.a(226, 7, 1, false);
                                        x.e("MicroMsg.AccInfoCacheInWorker", "reuseToPush  something Error! islogin && isCacheValid . Clean Cache Now !");
                                        aVar.hgg = null;
                                    } else {
                                        x.w("MicroMsg.AccInfoCacheInWorker", "reuseToPush Here, DANGER! . HERE means worker just init , try set from push now!");
                                        com.tencent.mm.plugin.report.d.pVE.a(226, 8, 1, false);
                                    }
                                    aVar.hgg = KD2.KC();
                                    com.tencent.mm.plugin.report.d.pVE.a(226, aVar.EV() > 0 ? 9 : 10, 1, false);
                                } else if (aVar.EV() <= 0) {
                                    com.tencent.mm.plugin.report.d.pVE.a(226, 11, 1, false);
                                    x.w("MicroMsg.AccInfoCacheInWorker", "reuseToPush something is null. give up %s", aVar.toString());
                                } else {
                                    int G = KD2.G(aVar.hgg);
                                    x.i("MicroMsg.AccInfoCacheInWorker", "reuseToPush parseBuf ret:%s time:%s  cache:%s", Integer.valueOf(G), Long.valueOf(bi.bA(Wy)), Integer.valueOf(aVar.EV()));
                                    if (G != 0) {
                                        x.e("MicroMsg.AccInfoCacheInWorker", "reuseToPush parseBuf ret:%s", Integer.valueOf(G));
                                        aVar.hgg = null;
                                    } else {
                                        aVar.hgh = 0;
                                    }
                                    com.tencent.mm.plugin.report.d.pVE.a(226, (long) (G + 20), 1, false);
                                }
                            }
                        }
                    }
                    r4 = new Object[2];
                    g.Dr();
                    r4[0] = g.Do().gQY;
                    g.Dr();
                    r4[1] = g.Dp().gRu.hoF;
                    x.i("MicroMsg.AccInfoCacheInWorker", "tryReuseToPush but object is null [%s, %s]", r4);
                } catch (Throwable th) {
                    x.e("MicroMsg.AccInfoCacheInWorker", "tryReuseToPush Exception:%s", bi.i(th));
                }
            }
            if (g.Do().CF()) {
                g.Dr();
                if (g.Dp().gRu != null) {
                    g.Dr();
                    if (g.Dp().gRu.hoF != null) {
                        g.Dr();
                        g.Dp().gRu.hoF.bH(true);
                    }
                }
            }
            com.tencent.mm.blink.a.ee("onServiceConnected done");
        } finally {
            dVar.ffd.unlock();
        }
    }

    public final void onServiceConnected(final ComponentName componentName, final IBinder iBinder) {
        x.w("MicroMsg.CoreServiceConnection", "onServiceConnected ");
        com.tencent.mm.blink.b.wv().f(new Runnable() {
            public final void run() {
                d.a(d.this, iBinder);
            }
        });
    }

    public final void onServiceDisconnected(final ComponentName componentName) {
        x.w("MicroMsg.CoreServiceConnection", "onServiceDisconnected ");
        com.tencent.mm.blink.b.wv().f(new Runnable() {
            public final void run() {
                d.a(d.this);
            }
        });
    }

    public final void am(Context context) {
        boolean z = false;
        com.tencent.mm.blink.a.ee("bindCore");
        try {
            this.ffd.lock();
            if (this.fff != null && this.fff.isBinderAlive()) {
                z = true;
            }
            x.i("MicroMsg.CoreServiceConnection", "enter bindCore, isBinding: %b, binderAlive: %b", Boolean.valueOf(this.ffe), Boolean.valueOf(z));
            if (this.ffe || z) {
                x.w("MicroMsg.CoreServiceConnection", "bindCore reenter, isBinding: %b, binderAlive: %b, return directly.", Boolean.valueOf(this.ffe), Boolean.valueOf(z));
                return;
            }
            this.ffd.unlock();
            if (com.tencent.mm.booter.b.q(context, "noop")) {
                Intent intent = new Intent(context, CoreService.class);
                x.i("MicroMsg.CoreServiceConnection", "prepare dispatcher / bind core service");
                if (context.bindService(intent, this, 1)) {
                    try {
                        this.ffd.lock();
                        this.ffe = true;
                        synchronized (lock) {
                            if (!ffc) {
                                ffc = true;
                                x.i("MicroMsg.CoreServiceConnection", "ZombieWaker posted.");
                                ah.h(this.ffg, 10000);
                            }
                        }
                        return;
                    } finally {
                        this.ffd.unlock();
                    }
                } else {
                    x.e("MicroMsg.CoreServiceConnection", "bindService failed, may be caused by some crashes");
                    return;
                }
            }
            x.i("MicroMsg.CoreServiceConnection", "ensureServiceInstance return false");
        } finally {
            this.ffd.unlock();
        }
    }

    private static int co(String str) {
        BufferedReader bufferedReader;
        Throwable th;
        Throwable th2;
        int i = -1;
        BufferedReader bufferedReader2 = null;
        for (File file : new File("/proc").listFiles()) {
            try {
                i = bi.getInt(file.getName(), -1);
                try {
                    File file2 = new File(file, "cmdline");
                    if (file2.canRead()) {
                        bufferedReader = new BufferedReader(new FileReader(file2));
                        try {
                            String readLine = bufferedReader.readLine();
                            if (readLine != null && readLine.startsWith(str)) {
                                if (readLine.length() == str.length()) {
                                    x.i("MicroMsg.CoreServiceConnection", "found process [%s] with pid [%d]", str, Integer.valueOf(i));
                                    try {
                                        bufferedReader.close();
                                        break;
                                    } catch (Throwable th3) {
                                    }
                                } else {
                                    char charAt = readLine.charAt(str.length());
                                    if (charAt <= ' ' || charAt >= 127) {
                                        x.i("MicroMsg.CoreServiceConnection", "found process [%s] with pid [%d]", str, Integer.valueOf(i));
                                        try {
                                            bufferedReader.close();
                                            break;
                                        } catch (Throwable th4) {
                                        }
                                    }
                                }
                            }
                            try {
                                bufferedReader.close();
                            } catch (Throwable th5) {
                            }
                            bufferedReader2 = null;
                        } catch (Throwable th6) {
                            th2 = th6;
                        }
                    } else if (bufferedReader2 != null) {
                        try {
                            bufferedReader2.close();
                        } catch (Throwable th7) {
                        }
                        bufferedReader2 = null;
                    }
                } catch (Throwable th8) {
                    th = th8;
                }
            } catch (Throwable th9) {
                x.printErrStackTrace("MicroMsg.CoreServiceConnection", th9, "", new Object[0]);
            }
        }
        return i;
        throw th2;
        if (bufferedReader != null) {
            try {
                bufferedReader.close();
            } catch (Throwable th10) {
            }
        }
        throw th2;
    }
}
