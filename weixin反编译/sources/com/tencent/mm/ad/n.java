package com.tencent.mm.ad;

import android.os.Looper;
import android.os.Message;
import com.tencent.mm.hardcoder.HardCoderJNI;
import com.tencent.mm.network.e;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.platformtools.ListenerInstanceMonitor;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Vector;
import junit.framework.Assert;

public final class n implements e {
    private static n hoE = null;
    private static int hoP = 1;
    public boolean foreground = false;
    private final ag handler = new ag(Looper.getMainLooper()) {
        public final void handleMessage(Message message) {
            n.this.a((k) message.obj, 0);
        }
    };
    public e hoF;
    public ah hoG = null;
    private Vector<k> hoH = new Vector();
    private Vector<k> hoI = new Vector();
    private final Map<Integer, Set<e>> hoJ = new HashMap();
    private Boolean hoK = null;
    private final a hoL;
    private long hoM = 21600000;
    private boolean hoN = false;
    private al hoO = new al(Looper.getMainLooper(), new com.tencent.mm.sdk.platformtools.al.a() {
        public final boolean uG() {
            boolean z = false;
            if (n.this.hoL == null) {
                return false;
            }
            x.v("MicroMsg.NetSceneQueue", "onQueueIdle, running=%d, waiting=%d, foreground=%b", Integer.valueOf(n.this.hoH.size()), Integer.valueOf(n.this.hoI.size()), Boolean.valueOf(n.this.foreground));
            a b = n.this.hoL;
            n nVar = n.this;
            if (n.this.hoN && n.this.hoH.isEmpty() && n.this.hoI.isEmpty()) {
                z = true;
            }
            b.a(nVar, z);
            return true;
        }
    }, true);
    private final Object lock = new Object();

    /* renamed from: com.tencent.mm.ad.n$4 */
    class AnonymousClass4 implements Runnable {
        final /* synthetic */ int hoR;

        public AnonymousClass4(int i) {
            this.hoR = i;
        }

        public final void run() {
            n.b(n.this, this.hoR);
        }

        public final String toString() {
            return super.toString() + "|cancelImp_" + this.hoR;
        }
    }

    public interface a {
        void a(n nVar);

        void a(n nVar, boolean z);
    }

    static /* synthetic */ void a(n nVar, int i) {
        synchronized (nVar.lock) {
            k kVar;
            Iterator it = nVar.hoH.iterator();
            while (it.hasNext()) {
                kVar = (k) it.next();
                if (kVar != null && kVar.hashCode() == i) {
                    nVar.c(kVar);
                    return;
                }
            }
            it = nVar.hoI.iterator();
            while (it.hasNext()) {
                kVar = (k) it.next();
                if (kVar != null && kVar.hashCode() == i) {
                    nVar.c(kVar);
                    return;
                }
            }
        }
    }

    static /* synthetic */ void b(n nVar, int i) {
        synchronized (nVar.lock) {
            k kVar;
            Iterator it = nVar.hoH.iterator();
            while (it.hasNext()) {
                kVar = (k) it.next();
                if (kVar != null && kVar.hashCode() == i) {
                    x.k("MicroMsg.NetSceneQueue", "cancelAllImp sceneHashCode:%d", Integer.valueOf(kVar.hashCode()));
                    kVar.cancel();
                    it.remove();
                }
            }
            it = nVar.hoI.iterator();
            while (it.hasNext()) {
                kVar = (k) it.next();
                if (kVar != null && kVar.hashCode() == i) {
                    x.k("MicroMsg.NetSceneQueue", "cancelAllImp sceneHashCode:%d", Integer.valueOf(kVar.hashCode()));
                    kVar.cancel();
                    it.remove();
                }
            }
        }
    }

    public final void bE(boolean z) {
        this.hoN = z;
        if (this.hoN) {
            x.e("MicroMsg.NetSceneQueue", "the working process is ready to be killed");
            al alVar = this.hoO;
            long j = this.hoM;
            alVar.K(j, j);
            return;
        }
        this.hoO.TN();
    }

    public final void a(int i, String str, int i2, boolean z) {
        if (this.hoF == null) {
            x.e("MicroMsg.NetSceneQueue", "logUtil autoAuth  == null");
        } else {
            this.hoF.a(i, str, i2, z);
        }
    }

    public final void bF(boolean z) {
        this.foreground = z;
        this.hoK = Boolean.valueOf(z);
        b.bF(z);
        HardCoderJNI.foreground = z;
        if (this.hoF == null) {
            x.e("MicroMsg.NetSceneQueue", "setForeground autoAuth  == null");
        } else {
            this.hoF.bG(z);
        }
    }

    public final int Ks() {
        try {
            if (this.hoF != null && this.hoF.KE() != null) {
                return this.hoF.KE().Vy();
            }
            x.e("MicroMsg.NetSceneQueue", "[arthurdan.getNetworkStatus] Notice!!! autoAuth and autoAuth.getNetworkEvent() is null!!!!");
            if (ao.isConnected(ad.getContext())) {
                return 6;
            }
            return 0;
        } catch (Throwable e) {
            x.e("MicroMsg.NetSceneQueue", "exception:%s", bi.i(e));
        }
    }

    public final boolean Kt() {
        if (this.hoF != null) {
            return this.hoF.Kt();
        }
        return true;
    }

    public final String getNetworkServerIp() {
        if (this.hoF != null) {
            return this.hoF.getNetworkServerIp();
        }
        return "unknown";
    }

    private n(a aVar) {
        this.hoL = aVar;
    }

    public final void d(e eVar) {
        this.hoF = eVar;
        eVar.bG(this.foreground);
        Kw();
    }

    public static n a(a aVar) {
        if (hoE == null) {
            hoE = new n(aVar);
        }
        return hoE;
    }

    public final void a(int i, e eVar) {
        synchronized (this.hoJ) {
            if (!this.hoJ.containsKey(Integer.valueOf(i))) {
                this.hoJ.put(Integer.valueOf(i), new HashSet());
            }
            if (!((Set) this.hoJ.get(Integer.valueOf(i))).contains(eVar) && ((Set) this.hoJ.get(Integer.valueOf(i))).add(eVar)) {
                ListenerInstanceMonitor.bV(eVar);
            }
        }
    }

    public final void b(int i, e eVar) {
        synchronized (this.hoJ) {
            try {
                if (this.hoJ.get(Integer.valueOf(i)) != null && ((Set) this.hoJ.get(Integer.valueOf(i))).remove(eVar)) {
                    ListenerInstanceMonitor.bW(eVar);
                }
            } catch (Exception e) {
            }
        }
    }

    public final void reset() {
        if (this.hoF != null) {
            this.hoF.reset();
        }
        Ku();
        List<k> list = this.hoI;
        this.hoI = new Vector();
        for (k kVar : list) {
            x.i("MicroMsg.NetSceneQueue", "reset::cancel scene " + kVar.getType());
            kVar.cancel();
            c(3, -1, "doScene failed clearWaitingQueue", kVar);
        }
        list.clear();
    }

    public final void Ku() {
        List<k> list = this.hoH;
        this.hoH = new Vector();
        for (k kVar : list) {
            x.i("MicroMsg.NetSceneQueue", "reset::cancel scene " + kVar.getType());
            kVar.cancel();
            c(3, -1, "doScene failed clearRunningQueue", kVar);
        }
        list.clear();
    }

    public final void Kv() {
        x.i("MicroMsg.NetSceneQueue", "resetDispatcher");
        if (this.hoF != null) {
            this.hoF.reset();
            this.hoF = null;
        }
    }

    public final e CR() {
        return this.hoF;
    }

    public final void cancel(final int i) {
        x.k("MicroMsg.NetSceneQueue", "cancel sceneHashCode:%d", Integer.valueOf(i));
        this.hoG.F(new Runnable() {
            public final void run() {
                n.a(n.this, i);
            }

            public final String toString() {
                return super.toString() + "|cancelImp_" + i;
            }
        });
    }

    public final void c(k kVar) {
        if (kVar != null) {
            x.k("MicroMsg.NetSceneQueue", "cancel sceneHashCode:%d", Integer.valueOf(kVar.hashCode()));
            kVar.cancel();
            synchronized (this.lock) {
                this.hoI.remove(kVar);
                this.hoH.remove(kVar);
            }
        }
    }

    public final boolean d(k kVar) {
        return a(kVar, 0);
    }

    public final boolean a(k kVar, int i) {
        boolean z = kVar != null || i >= 0;
        Assert.assertTrue(z);
        String str = "worker thread has not been set";
        if (this.hoG != null) {
            z = true;
        } else {
            z = false;
        }
        Assert.assertTrue(str, z);
        if (!e(kVar)) {
            return false;
        }
        b(kVar, i);
        return true;
    }

    private void b(final k kVar, int i) {
        boolean Kx = Kx();
        int size = this.hoH.size();
        String str = "MicroMsg.NetSceneQueue";
        String str2 = "doSceneImp start: mmcgi type:%d hash[%d,%d] run:%d wait:%d afterSec:%d canDo:%b autoauth:%d";
        Object[] objArr = new Object[8];
        objArr[0] = Integer.valueOf(kVar.getType());
        objArr[1] = Integer.valueOf(kVar.hashCode());
        objArr[2] = Integer.valueOf(kVar.Kn());
        objArr[3] = Integer.valueOf(size);
        objArr[4] = Integer.valueOf(this.hoI.size());
        objArr[5] = Integer.valueOf(i);
        objArr[6] = Boolean.valueOf(Kx);
        objArr[7] = Integer.valueOf(this.hoF == null ? 0 : this.hoF.hashCode());
        x.i(str, str2, objArr);
        if (i == 0 && Kx && this.hoF != null) {
            synchronized (this.lock) {
                this.hoH.add(kVar);
                if (size == this.hoH.size()) {
                    x.w("MicroMsg.NetSceneQueue", "doSceneImp mmcgi  Add to runningQueue wrong  type:%d hash:%d run:[%d ,%d] wait:%d ", Integer.valueOf(kVar.getType()), Integer.valueOf(kVar.hashCode()), Integer.valueOf(size), Integer.valueOf(this.hoH.size()), Integer.valueOf(this.hoI.size()));
                }
            }
            this.hoG.F(new Runnable() {
                public final void run() {
                    int i;
                    String str;
                    String str2;
                    Object[] objArr;
                    int i2 = 0;
                    kVar.hoo = n.this;
                    if (kVar.aBT || n.this.hoF == null) {
                        i = 0;
                    } else {
                        i = kVar.a(n.this.hoF, n.this);
                        if (i >= 0) {
                            str = "MicroMsg.NetSceneQueue";
                            str2 = "On doscene  mmcgi type:%d hash[%d,%d] run:%d wait:%d ret:%d autoauth:%d";
                            objArr = new Object[7];
                            objArr[0] = Integer.valueOf(kVar.getType());
                            objArr[1] = Integer.valueOf(kVar.hashCode());
                            objArr[2] = Integer.valueOf(kVar.Kn());
                            objArr[3] = Integer.valueOf(n.this.hoH.size());
                            objArr[4] = Integer.valueOf(n.this.hoI.size());
                            objArr[5] = Integer.valueOf(i);
                            if (n.this.hoF == null) {
                                i = 0;
                            } else {
                                i = n.this.hoF.hashCode();
                            }
                            objArr[6] = Integer.valueOf(i);
                            x.i(str, str2, objArr);
                            kVar.hop = false;
                            return;
                        }
                    }
                    str = "MicroMsg.NetSceneQueue";
                    str2 = "doscene mmcgi Failed type:%d hash[%d,%d] cancel[%b] run:%d wait:%d ret:%d autoauth:%d";
                    objArr = new Object[8];
                    objArr[0] = Integer.valueOf(kVar.getType());
                    objArr[1] = Integer.valueOf(kVar.hashCode());
                    objArr[2] = Integer.valueOf(kVar.Kn());
                    objArr[3] = Boolean.valueOf(kVar.aBT);
                    objArr[4] = Integer.valueOf(n.this.hoH.size());
                    objArr[5] = Integer.valueOf(n.this.hoI.size());
                    objArr[6] = Integer.valueOf(i);
                    if (n.this.hoF != null) {
                        i2 = n.this.hoF.hashCode();
                    }
                    objArr[7] = Integer.valueOf(i2);
                    x.w(str, str2, objArr);
                    kVar.hoo = null;
                    synchronized (n.this.lock) {
                        n.this.hoH.remove(kVar);
                    }
                    if (!kVar.aBT) {
                        n.this.handler.post(new Runnable() {
                            public final void run() {
                                n.this.a(3, -1, "doScene failed", kVar);
                            }
                        });
                    }
                }

                public final String toString() {
                    return super.toString() + "|doSceneImp_" + kVar + "_type=" + kVar.getType();
                }
            });
        } else if (i > 0) {
            Message obtain = Message.obtain();
            obtain.obj = kVar;
            this.handler.sendMessageDelayed(obtain, (long) i);
            x.i("MicroMsg.NetSceneQueue", "timed: type=" + kVar.getType() + " id=" + kVar.hashCode() + " cur_after_sec=" + i);
        } else {
            x.i("MicroMsg.NetSceneQueue", "waited: type=" + kVar.getType() + " id=" + kVar.hashCode() + " cur_waiting_cnt=" + this.hoI.size());
            synchronized (this.lock) {
                this.hoI.add(kVar);
            }
            x.i("MicroMsg.NetSceneQueue", "waitingQueue_size = " + this.hoI.size());
        }
        if (this.hoF != null) {
            hoP = 1;
        } else if (this.hoL == null) {
            x.e("MicroMsg.NetSceneQueue", "prepare dispatcher failed, queue idle:%s", this.hoL);
        } else {
            this.hoL.a(this);
            al alVar = new al(Looper.getMainLooper(), new com.tencent.mm.sdk.platformtools.al.a() {
                private long hoU = 10;

                public final boolean uG() {
                    if (n.this.hoF == null) {
                        long j = this.hoU;
                        this.hoU = j - 1;
                        if (j > 0) {
                            return true;
                        }
                    }
                    n.this.Kw();
                    return false;
                }
            }, true);
            long j = (long) (hoP * 100);
            alVar.K(j, j);
            if (hoP < WXMediaMessage.TITLE_LENGTH_LIMIT) {
                hoP *= 2;
            }
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
        int i3 = 0;
        kVar.hop = true;
        synchronized (this.lock) {
            this.hoH.remove(kVar);
        }
        String str2 = "MicroMsg.NetSceneQueue";
        String str3 = "onSceneEnd mmcgi type:%d hash[%d,%d] run:%d wait:%d autoauth:%d [%d,%d,%s]";
        Object[] objArr = new Object[9];
        objArr[0] = Integer.valueOf(kVar.getType());
        objArr[1] = Integer.valueOf(kVar.hashCode());
        objArr[2] = Integer.valueOf(kVar.Kn());
        objArr[3] = Integer.valueOf(this.hoH.size());
        objArr[4] = Integer.valueOf(this.hoI.size());
        if (this.hoF != null) {
            i3 = this.hoF.hashCode();
        }
        objArr[5] = Integer.valueOf(i3);
        objArr[6] = Integer.valueOf(i);
        objArr[7] = Integer.valueOf(i2);
        objArr[8] = str;
        x.i(str2, str3, objArr);
        Kw();
        c(i, i2, str, kVar);
        if (this.hoN && this.hoH.isEmpty() && this.hoI.isEmpty()) {
            al alVar = this.hoO;
            long j = this.hoM;
            alVar.K(j, j);
        }
    }

    private void c(int i, int i2, String str, k kVar) {
        final k kVar2 = kVar;
        final int i3 = i;
        final int i4 = i2;
        final String str2 = str;
        this.handler.post(new Runnable() {
            public final void run() {
                Set<e> hashSet;
                Set set = (Set) n.this.hoJ.get(Integer.valueOf(kVar2.getType()));
                if (set != null && set.size() > 0) {
                    hashSet = new HashSet();
                    hashSet.addAll(set);
                    for (e eVar : hashSet) {
                        if (eVar != null && set.contains(eVar)) {
                            eVar.a(i3, i4, str2, kVar2);
                        }
                    }
                }
                set = (Set) n.this.hoJ.get(Integer.valueOf(-1));
                if (set != null && set.size() > 0) {
                    hashSet = new HashSet();
                    hashSet.addAll(set);
                    for (e eVar2 : hashSet) {
                        if (eVar2 != null && set.contains(eVar2)) {
                            eVar2.a(i3, i4, str2, kVar2);
                        }
                    }
                }
            }
        });
    }

    private void Kw() {
        synchronized (this.lock) {
            if (this.hoI.size() > 0) {
                k kVar = (k) this.hoI.get(0);
                int i = 1;
                int i2 = kVar.priority;
                k kVar2 = kVar;
                while (i < this.hoI.size()) {
                    k kVar3;
                    int i3;
                    if (((k) this.hoI.get(i)).priority > i2) {
                        this.hoI.get(i);
                        if (Kx()) {
                            kVar = (k) this.hoI.get(i);
                            kVar3 = kVar;
                            i3 = kVar.priority;
                            i++;
                            kVar2 = kVar3;
                            i2 = i3;
                        }
                    }
                    i3 = i2;
                    kVar3 = kVar2;
                    i++;
                    kVar2 = kVar3;
                    i2 = i3;
                }
                this.hoI.remove(kVar2);
                x.i("MicroMsg.NetSceneQueue", "waiting2running waitingQueue_size = " + this.hoI.size());
                b(kVar2, 0);
            }
        }
    }

    private boolean Kx() {
        if (this.hoH.size() >= 50) {
            return false;
        }
        return true;
    }

    private boolean e(k kVar) {
        int type = kVar.getType();
        if (kVar.Kj()) {
            synchronized (this.lock) {
                k kVar2;
                Iterator it = this.hoH.iterator();
                while (it.hasNext()) {
                    kVar2 = (k) it.next();
                    if (kVar2.getType() == type) {
                        x.i("MicroMsg.NetSceneQueue", "forbid in running: type=" + kVar.getType() + " id=" + kVar.hashCode() + " cur_running_cnt=" + this.hoH.size());
                        if (kVar.b(kVar2)) {
                            return true;
                        } else if (kVar.a(kVar2)) {
                            x.e("MicroMsg.NetSceneQueue", "forbid in running diagnostic: type=" + kVar.getType() + " id=" + kVar.hashCode() + " cur_running_cnt=" + this.hoH.size() + " ---" + kVar2.hashCode());
                            if (!this.foreground) {
                                x.e("MicroMsg.NetSceneQueue", "forbid in running diagnostic: type=" + kVar.getType() + "acinfo[" + kVar2.getInfo() + "] scinfo[" + kVar.getInfo() + "]");
                                x.cfX();
                                Assert.assertTrue("NetsceneQueue forbid in running diagnostic: type=" + kVar.getType(), false);
                            }
                            c(kVar2);
                            return true;
                        } else {
                            return false;
                        }
                    }
                }
                it = this.hoI.iterator();
                while (it.hasNext()) {
                    kVar2 = (k) it.next();
                    if (kVar2.getType() == type) {
                        x.i("MicroMsg.NetSceneQueue", "forbid in waiting: type=" + kVar.getType() + " id=" + kVar.hashCode() + " cur_waiting_cnt=" + this.hoI.size());
                        if (kVar.b(kVar2)) {
                            return true;
                        } else if (kVar.a(kVar2)) {
                            x.e("MicroMsg.NetSceneQueue", "forbid in waiting diagnostic: type=" + kVar.getType() + " id=" + kVar.hashCode() + " cur_waiting_cnt=" + this.hoI.size() + " ---" + kVar2.hashCode());
                            if (!this.foreground) {
                                x.cfX();
                                Assert.assertTrue("NetsceneQueue forbid in waiting diagnostic: type=" + kVar.getType(), false);
                            }
                            c(kVar2);
                            return true;
                        } else {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}
