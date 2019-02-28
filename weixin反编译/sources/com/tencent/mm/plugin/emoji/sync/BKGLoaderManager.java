package com.tencent.mm.plugin.emoji.sync;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.TrafficStats;
import android.os.Looper;
import android.os.Process;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.f.a.cr;
import com.tencent.mm.f.a.e;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.al.a;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Vector;

public final class BKGLoaderManager implements e {
    int hBf;
    public Vector<d> lFA = new Vector();
    public Set<c> lFB = new HashSet();
    public ConnectivityReceiver lFC;
    long lFD = 0;
    long lFE = 0;
    al lFF = new al(Looper.getMainLooper(), new a() {
        public final boolean uG() {
            if (BKGLoaderManager.this.lFp || BKGLoaderManager.this.lFq || BKGLoaderManager.this.lFr) {
                long uidTxBytes = TrafficStats.getUidTxBytes(BKGLoaderManager.this.hBf);
                long uidRxBytes = TrafficStats.getUidRxBytes(BKGLoaderManager.this.hBf);
                long j = (uidTxBytes - BKGLoaderManager.this.lFD) + (uidRxBytes - BKGLoaderManager.this.lFE);
                x.d("MicroMsg.BKGLoader.BKGLoaderManager", "delta of data: " + (j / 1024));
                if (j <= 20480) {
                    BKGLoaderManager.this.aCG();
                } else {
                    BKGLoaderManager.this.lFD = uidTxBytes;
                    BKGLoaderManager.this.lFE = uidRxBytes;
                    BKGLoaderManager.this.lFF.K(1000, 1000);
                }
            }
            return false;
        }
    }, false);
    public c lFG = new c<e>() {
        {
            this.xmG = e.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            e eVar = (e) bVar;
            if ((eVar instanceof e) && !eVar.fnJ.fnK) {
                BKGLoaderManager.this.aCG();
            }
            return false;
        }
    };
    public c lFH = new c<cr>() {
        {
            this.xmG = cr.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            cr crVar = (cr) bVar;
            if ((crVar instanceof cr) && !bi.oN(crVar.frL.frM)) {
                BKGLoaderManager.this.k(crVar.frL.frM, crVar.frL.fql, crVar.frL.success);
            }
            return false;
        }
    };
    public int lFm = 0;
    private int lFn = 0;
    public boolean lFo = false;
    boolean lFp = false;
    boolean lFq = false;
    public boolean lFr = false;
    public boolean lFs = false;
    private boolean lFt = false;
    boolean lFu = false;
    boolean lFv = false;
    d lFw = null;
    private b lFx;
    public Vector<d> lFy = new Vector();
    public Vector<d> lFz = new Vector();
    int mNetWorkType = -1;

    final class ConnectivityReceiver extends BroadcastReceiver {
        public final void onReceive(Context context, Intent intent) {
            int netType = ao.getNetType(context);
            if (BKGLoaderManager.this.mNetWorkType != netType) {
                x.i("MicroMsg.BKGLoader.BKGLoaderManager", "[cpan] network change type:%d", Integer.valueOf(netType));
                if (BKGLoaderManager.aBw()) {
                    BKGLoaderManager.this.aCH();
                } else if (BKGLoaderManager.aCJ()) {
                    BKGLoaderManager.this.aCG();
                } else if (ao.isConnected(ad.getContext())) {
                    BKGLoaderManager.this.aCI();
                } else {
                    BKGLoaderManager.this.aCH();
                }
                BKGLoaderManager.this.mNetWorkType = netType;
            }
        }
    }

    public BKGLoaderManager(b bVar) {
        this.lFx = bVar;
        this.hBf = Process.myUid();
        this.mNetWorkType = ao.getNetType(ad.getContext());
    }

    public final void aD(List<d> list) {
        if (this.lFz == null) {
            this.lFz = new Vector();
        }
        if (list.size() > 0) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                d dVar = (d) list.get(i);
                if (dVar == null || this.lFz.contains(dVar)) {
                    x.i("MicroMsg.BKGLoader.BKGLoaderManager", "[cpan] task is has exist:%s", dVar.getKey());
                } else {
                    this.lFz.add(dVar);
                }
            }
        }
    }

    public final synchronized void aCG() {
        if (ao.isWifi(ad.getContext()) || this.lFo) {
            if (this.lFy != null && this.lFy.size() > 0) {
                this.lFu = f.zm();
                this.lFp = true;
                this.lFq = false;
                this.lFs = false;
                this.lFr = false;
                if (this.lFu) {
                    x.i("MicroMsg.BKGLoader.BKGLoaderManager", "[cpan] sdcard is full.");
                } else {
                    this.lFw = (d) this.lFy.remove(0);
                    this.lFw.a(this);
                    this.lFx.lFk.execute(this.lFw);
                    x.i("MicroMsg.BKGLoader.BKGLoaderManager", "[cpan] tryToStart task is ruing. key:%s donwload list size:%d", this.lFw.getKey(), Integer.valueOf(this.lFy.size()));
                }
                aCI();
            } else if (this.lFz == null || this.lFz.size() <= 0) {
                x.i("MicroMsg.BKGLoader.BKGLoaderManager", "[cpan] tryToStart no task list .");
                if (this.lFy == null || this.lFy.size() <= 0) {
                    if (this.lFp && this.lFv) {
                        this.lFs = true;
                    }
                    this.lFp = false;
                }
                if (this.lFz == null || this.lFz.size() <= 0) {
                    if (this.lFq && this.lFv) {
                        this.lFt = true;
                    }
                    this.lFq = false;
                }
                if ((this.lFy == null || this.lFy.size() <= 0) && ((this.lFz == null || this.lFz.size() <= 0) && ((this.lFp || this.lFq) && this.lFv))) {
                    this.lFq = false;
                    this.lFp = false;
                }
                this.lFo = false;
                aCI();
            } else {
                this.lFq = true;
                this.lFp = false;
                this.lFt = false;
                this.lFr = false;
                this.lFw = (d) this.lFz.remove(0);
                this.lFw.a(this);
                this.lFx.lFk.execute(this.lFw);
                x.i("MicroMsg.BKGLoader.BKGLoaderManager", "[cpan] tryToStart task is ruing. key:%s upload list size:%d", this.lFw.getKey(), Integer.valueOf(this.lFz.size()));
                aCI();
            }
            if (!(this.lFq || this.lFp)) {
                if (this.lFA == null || this.lFA.size() <= 0) {
                    this.lFr = false;
                } else {
                    this.lFr = true;
                    this.lFw = (d) this.lFA.remove(0);
                    this.lFw.a(this);
                    this.lFx.lFk.execute(this.lFw);
                    x.i("MicroMsg.BKGLoader.BKGLoaderManager", "[cpan] tryToStart download store emoji task is runing. productID:%s size:%d", this.lFw.getKey(), Integer.valueOf(this.lFA.size()));
                }
            }
        } else if (aBw()) {
            x.i("MicroMsg.BKGLoader.BKGLoaderManager", "[dz tryToStart is 3g or 4g]");
            this.lFp = false;
            this.lFq = false;
            this.lFs = false;
            this.lFr = false;
            aCI();
        } else {
            x.i("MicroMsg.BKGLoader.BKGLoaderManager", "[dz tryToStart is not wifi, 3g nor 4g]");
        }
    }

    public final void aCH() {
        this.lFp = false;
        this.lFq = false;
        this.lFo = false;
        aCI();
        if (this.lFw != null) {
            this.lFw.cancel();
        }
    }

    public final void aCI() {
        if (this.lFB != null && this.lFB.size() > 0) {
            for (c aCK : this.lFB) {
                aCK.aCK();
            }
        }
    }

    public final void zi(String str) {
        x.i("MicroMsg.BKGLoader.BKGLoaderManager", "[cpan] task is ruing. key:%s", str);
    }

    public final void k(String str, int i, boolean z) {
        x.i("MicroMsg.BKGLoader.BKGLoaderManager", "[cpan] task is finish. key:%s success:%b", str, Boolean.valueOf(z));
        if (this.lFw == null || bi.oN(str)) {
            x.e("MicroMsg.BKGLoader.BKGLoaderManager", "CurrentTask or key is null. or key is no equal crrentkey ");
            return;
        }
        if (this.lFy.contains(this.lFw)) {
            this.lFy.remove(this.lFw);
        } else if (this.lFz.contains(this.lFw)) {
            this.lFz.remove(this.lFw);
        } else if (this.lFA.contains(this.lFw)) {
            this.lFA.remove(this.lFw);
        }
        if (!z) {
            x.i("MicroMsg.BKGLoader.BKGLoaderManager", "retry later.");
        } else if (!(i == 2 || this.lFB == null || this.lFB.size() <= 0)) {
            for (c aCL : this.lFB) {
                aCL.aCL();
            }
        }
        if (i == 2) {
            this.lFF.K(5000, 5000);
        } else {
            this.lFF.K(1000, 1000);
        }
    }

    public static boolean aCJ() {
        NetworkInfo networkInfo = ((ConnectivityManager) ad.getContext().getSystemService("connectivity")).getNetworkInfo(1);
        if (networkInfo != null) {
            return networkInfo.isConnected();
        }
        return false;
    }

    public static boolean aBw() {
        return ao.is3G(ad.getContext()) || ao.is4G(ad.getContext()) || ao.is2G(ad.getContext());
    }
}
