package com.tencent.mm.plugin.sns.model;

import android.os.Build.VERSION;
import android.os.Looper;
import android.os.MessageQueue.IdleHandler;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.memory.n;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.plugin.sns.data.f;
import com.tencent.mm.plugin.sns.data.g;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.model.a.d;
import com.tencent.mm.plugin.sns.model.a.h;
import com.tencent.mm.plugin.sns.model.g.AnonymousClass9;
import com.tencent.mm.protocal.c.are;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.an;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public final class b implements e, com.tencent.mm.plugin.sns.model.a.c.a {
    static int qYx = 0;
    private static final int qYy = (VERSION.SDK_INT >= 14 ? 100 : 25);
    Set<b> gDT;
    LinkedList<f> gDp;
    private ag handler;
    private int qYA;
    private int qYB;
    private LinkedList<g> qYC;
    public HashMap<String, Long> qYD;
    public boolean qYE;
    public Set<a> qYF;
    Map<String, Long> qYG;
    Map<String, com.tencent.mm.plugin.sns.data.c> qYH;
    private long qYz;

    public interface a {
        void ef(String str, String str2);
    }

    /* renamed from: com.tencent.mm.plugin.sns.model.b$3 */
    class AnonymousClass3 implements Runnable {
        final /* synthetic */ String gDn;
        final /* synthetic */ String uS;

        public AnonymousClass3(String str, String str2) {
            this.uS = str;
            this.gDn = str2;
        }

        public final void run() {
            if (b.this.qYF != null) {
                for (a aVar : b.this.qYF) {
                    if (aVar != null) {
                        aVar.ef(this.uS, this.gDn);
                    }
                }
            }
        }
    }

    class c implements IdleHandler {
        c() {
        }

        public final boolean queueIdle() {
            x.d("MicroMsg.DownloadManager", "I run idleHandler ");
            b.this.qYz = bi.Wx();
            return b.a(b.this);
        }
    }

    public interface b {
        void Ky(String str);

        void aE(String str, boolean z);

        void aF(String str, boolean z);

        void buX();
    }

    static /* synthetic */ void a(b bVar, String str) {
        x.d("MicroMsg.DownloadManager", "onDownLoadFinish by scene %s", str);
        ae.bwe().KO(str);
        bVar.Pc();
    }

    static /* synthetic */ boolean a(b bVar) {
        if (bVar.qYC == null || bVar.qYC.size() <= 0) {
            return false;
        }
        g gVar = (g) bVar.qYC.remove();
        new ar().m(gVar);
        return true;
    }

    static /* synthetic */ boolean a(b bVar, are are, int i, com.tencent.mm.plugin.sns.data.e eVar, an anVar) {
        if (!i.Ku(ae.FJ())) {
            x.i("MicroMsg.DownloadManager", "isHasSdcard is false accpath %s sdcard: %s", ae.FJ(), com.tencent.mm.compatible.util.e.bnD);
            return false;
        } else if (are.nMq.startsWith("Locall_path") || are.nMq.startsWith("pre_temp_sns_pic")) {
            x.d("MicroMsg.DownloadManager", "is a local img not need download");
            return false;
        } else {
            String aK = i.aK(i, are.nMq);
            if (bVar.qYH.containsKey(aK)) {
                Iterator it = bVar.gDp.iterator();
                while (it.hasNext()) {
                    f fVar = (f) it.next();
                    if (fVar.fIx.nMq.equals(are.nMq) && fVar.requestType == i) {
                        if (bVar.gDp.remove(fVar)) {
                            bVar.gDp.addLast(fVar);
                        }
                        x.v("MicroMsg.DownloadManager", "update the donwload list ");
                    }
                }
            } else {
                x.i("MicroMsg.DownloadManager", "add list %s", are.nMq);
                bVar.qYH.put(aK, new com.tencent.mm.plugin.sns.data.c(eVar, i));
                bVar.gDp.add(new f(are, i, aK, anVar));
            }
            x.d("MicroMsg.DownloadManager", "tryStartNetscene size %s Tsize : %s", Integer.valueOf(ae.bwe().bvJ()), Integer.valueOf(bVar.qYG.size()));
            x.v("MicroMsg.DownloadManager", "lockwaitdownload. %s * %s memeryFiles.size() ", Integer.valueOf(bVar.qYH.size()), Integer.valueOf(bVar.qYH.size()), Integer.valueOf(bVar.qYC.size()));
            if (Looper.myLooper() == null) {
                x.w("MicroMsg.DownloadManager", "Looper.myLooper() == null");
                return false;
            }
            Looper.myQueue().addIdleHandler(new c());
            if ((bi.bz(bVar.qYz) * 1000 > 300000 ? 1 : null) != null) {
                bVar.handler.postDelayed(new Runnable() {
                    public final void run() {
                        b.a(b.this);
                    }
                }, 500);
            }
            List<String> linkedList = new LinkedList();
            for (Entry key : bVar.qYG.entrySet()) {
                linkedList.add(key.getKey());
            }
            for (String aK2 : linkedList) {
                if (bVar.qYG.containsKey(aK2) && bi.bz(((Long) bVar.qYG.get(aK2)).longValue()) * 1000 > 300000) {
                    x.d("MicroMsg.DownloadManager", "too long to download");
                    bVar.qYG.remove(aK2);
                    bVar.qYH.remove(aK2);
                }
            }
            if (bVar.gDp.size() > 0) {
                bVar.handler.postDelayed(new Runnable() {
                    public final void run() {
                        b.this.Pc();
                    }
                }, 500);
            }
            return true;
        }
    }

    public static void bvi() {
    }

    public static boolean bvj() {
        return false;
    }

    public final void J(int i, boolean z) {
        this.qYB = i;
        try {
            String value;
            String str;
            if (ao.isWifi(ad.getContext())) {
                value = com.tencent.mm.j.g.Af().getValue("SnsImgDownloadConcurrentCountForWifi");
            } else {
                value = com.tencent.mm.j.g.Af().getValue("SnsImgDownloadConcurrentCountForNotWifi");
            }
            if (bi.oN(value) && com.tencent.mm.sdk.a.b.cfx()) {
                str = "00:00-18:30-1-3;19:30-23:00-1-2;23:00-23:59-1-3;18:30-19:30-3-5;";
            } else {
                str = value;
            }
            if (!bi.oN(str)) {
                int i2;
                String[] split = new SimpleDateFormat("HH:mm").format(new Date()).split(":");
                int Wo = (bi.Wo(split[1]) + (bi.Wo(split[0]) * 60)) - ((((int) i.MW()) - 8) * 60);
                if (Wo < 0) {
                    i2 = Wo + 1440;
                } else if (Wo >= 1440) {
                    i2 = Wo - 1440;
                } else {
                    i2 = Wo;
                }
                String[] split2 = str.split(";");
                Wo = 0;
                while (true) {
                    int i3 = Wo;
                    if (i3 >= split2.length) {
                        break;
                    }
                    if (!bi.oN(split2[i3])) {
                        split = split2[i3].split("-");
                        if (split == null || split.length < 4) {
                            x.e("MicroMsg.DownloadManager", "setMaxThread Err i%d :%s", Integer.valueOf(i3), str);
                        } else {
                            String[] split3 = split[0].split(":");
                            int Wo2 = bi.Wo(split3[1]) + (bi.Wo(split3[0]) * 60);
                            String[] split4 = split[1].split(":");
                            x.i("MicroMsg.DownloadManager", "setMaxThread i:%d [%d,%d] now:%d threadcnt:[%s,%s]", Integer.valueOf(i3), Integer.valueOf(Wo2), Integer.valueOf(bi.Wo(split4[1]) + (bi.Wo(split4[0]) * 60)), Integer.valueOf(i2), split[2], split[3]);
                            if (i2 <= bi.Wo(split4[1]) + (bi.Wo(split4[0]) * 60) && i2 > Wo2) {
                                Wo = bi.Wo(z ? split[2] : split[3]);
                                if (Wo > 0) {
                                    this.qYB = Wo;
                                }
                            }
                        }
                    }
                    Wo = i3 + 1;
                }
            }
        } catch (Throwable e) {
            x.e("MicroMsg.DownloadManager", "setMaxThread :%s", bi.i(e));
        }
        x.i("MicroMsg.DownloadManager", "setMaxThread Res:%d ", Integer.valueOf(this.qYB));
    }

    public b() {
        this.handler = null;
        this.qYz = 0;
        this.qYA = 0;
        this.qYB = 2;
        this.qYC = new LinkedList();
        this.qYD = new HashMap();
        this.qYE = true;
        this.gDT = new HashSet();
        this.qYF = new HashSet();
        this.gDp = new LinkedList();
        this.qYG = new ConcurrentHashMap();
        this.qYH = new HashMap();
        this.handler = ae.aOA();
        bvk();
    }

    private void bvk() {
        this.gDp.clear();
        this.qYH.clear();
        this.qYG.clear();
        this.qYC.clear();
        this.qYD.clear();
    }

    public final void a(final b bVar) {
        this.handler.post(new Runnable() {
            public final void run() {
                e eVar = b.this;
                eVar.gDT.add(bVar);
                int i = b.qYx + 1;
                b.qYx = i;
                if (i <= 1) {
                    com.tencent.mm.kernel.g.Dr();
                    com.tencent.mm.kernel.g.Dp().gRu.a((int) com.tencent.mm.plugin.appbrand.jsapi.a.f.CTRL_INDEX, eVar);
                }
            }
        });
    }

    public final void b(final b bVar) {
        this.handler.post(new Runnable() {
            public final void run() {
                e eVar = b.this;
                eVar.gDT.remove(bVar);
                int i = b.qYx - 1;
                b.qYx = i;
                if (i <= 0) {
                    com.tencent.mm.kernel.g.Dr();
                    com.tencent.mm.kernel.g.Dp().gRu.b((int) com.tencent.mm.plugin.appbrand.jsapi.a.f.CTRL_INDEX, eVar);
                }
            }
        });
    }

    public final boolean a(are are, int i, com.tencent.mm.plugin.sns.data.e eVar, an anVar) {
        if (are == null) {
            x.e("MicroMsg.DownloadManager", "unknow case media is null " + bi.chl().toString());
            return false;
        }
        final are are2 = are;
        final int i2 = i;
        final com.tencent.mm.plugin.sns.data.e eVar2 = eVar;
        final an anVar2 = anVar;
        ae.aOA().post(new Runnable() {
            public final void run() {
                au.La(are2.nMq);
                b.a(b.this, are2, i2, eVar2, anVar2);
            }
        });
        return true;
    }

    public final void KB(String str) {
        x.d("MicroMsg.DownloadManager", "unLockDownLoad the thread id is %s %s", Long.valueOf(Thread.currentThread().getId()), str);
        com.tencent.mm.plugin.sns.data.c cVar = (com.tencent.mm.plugin.sns.data.c) this.qYH.get(str);
        if (cVar != null) {
            com.tencent.mm.plugin.sns.data.e eVar = cVar.qWO;
            if (eVar != null) {
                are are;
                g bwc = ae.bwc();
                are are2 = (are) eVar.list.get(0);
                for (int i = 1; i < eVar.list.size(); i++) {
                    are are3 = (are) eVar.list.get(i);
                    if (str != null && str.indexOf(are3.nMq) >= 0) {
                        are = are3;
                        break;
                    }
                }
                are = are2;
                String r = am.r(ae.getAccSnsPath(), are.nMq);
                String f = eVar.qWU == 0 ? i.f(are) : eVar.qWU == 4 ? i.g(are) : eVar.qWU == 5 ? i.g(are) : eVar.qWU == 3 ? i.l(are) : i.e(are);
                if (!bwc.qYR.bu(i.aJ(eVar.qWU, are.nMq))) {
                    new b(i.aJ(eVar.qWU, are.nMq), r + f, r, are, eVar.qWU).m("");
                }
            }
        }
        this.qYH.remove(str);
    }

    public final void Pc() {
        if (!this.qYE) {
            return;
        }
        if (ae.bvO()) {
            bvk();
        } else if (i.Ku(ae.FJ())) {
            int i = this.qYB;
            if (r.ifs > 0) {
                i = r.ifs;
            }
            if (this.gDp.size() > 0 && ae.bwe().bvJ() + this.qYG.size() <= i) {
                x.i("MicroMsg.DownloadManager", "tryStartNetscene size %s Tsize : %s listsize %s max_thread_downloading: %s", Integer.valueOf(ae.bwe().bvJ()), Integer.valueOf(this.qYG.size()), Integer.valueOf(this.gDp.size()), Integer.valueOf(this.qYB));
                f fVar = (f) this.gDp.removeLast();
                are are = fVar.fIx;
                int i2 = fVar.requestType;
                String str = fVar.aAM;
                if (!this.qYH.containsKey(str) || this.qYH.get(str) == null) {
                    this.qYH.remove(str);
                    return;
                }
                boolean z;
                String str2;
                int i3;
                Object obj;
                com.tencent.mm.plugin.sns.data.e eVar = ((com.tencent.mm.plugin.sns.data.c) this.qYH.get(str)).qWO;
                if (i2 == 1 && are.qWK) {
                    i2 = 8;
                }
                if (i2 == 1 || i2 == 5 || i2 == 7) {
                    z = true;
                    String str3 = are.wEP;
                    if (i2 == 7 && !bi.oN(are.wEZ)) {
                        str3 = are.wEZ;
                    }
                    int i4 = are.wEQ;
                    if (bi.oN(str3) && are.kzz == 2) {
                        str2 = are.nlE;
                        i3 = are.wEO;
                    } else {
                        i3 = i4;
                        str2 = str3;
                    }
                } else if (i2 == 6) {
                    z = false;
                    str2 = are.wEW;
                    i3 = are.wEO;
                } else {
                    z = false;
                    str2 = are.nlE;
                    i3 = are.wEO;
                }
                if (str2 == null || str2.equals("")) {
                    x.d("MicroMsg.DownloadManager", "url  " + str2);
                    obj = null;
                } else {
                    obj = 1;
                }
                if (obj == null) {
                    this.qYH.remove(str);
                } else if (i3 == 2) {
                    if (!ae.bwe().isDownloading(str)) {
                        x.d("MicroMsg.DownloadManager", "to downLoad scene " + are.nMq + "  " + str2);
                        com.tencent.mm.kernel.g.Dr();
                        com.tencent.mm.kernel.g.Dp().gRu.a(new o(are, are.nMq, str2, are.kzz, z, i2, str), 0);
                        ae.bwe().KN(str);
                    }
                } else if (i3 == 1 || i3 == 0) {
                    if (i3 == 0) {
                        x.e("MicroMsg.DownloadManager", "others http: urlType" + i3 + " -- url : " + str2 + " isThumb :" + z);
                    }
                    if (!this.qYG.containsKey(str)) {
                        x.i("MicroMsg.DownloadManager", "to downLoad cdn " + are.nMq + "  " + str2);
                        if (!(are == null || i2 == 6 || !this.qYD.containsKey(str))) {
                            long longValue = ((Long) this.qYD.get(str)).longValue();
                            if (System.currentTimeMillis() - longValue < 300000) {
                                this.qYH.remove(str);
                                x.w("MicroMsg.DownloadManager", "download error pass " + longValue + " url " + str2 + " id: " + are.nMq);
                                return;
                            }
                        }
                        this.qYG.put(str, Long.valueOf(bi.Wx()));
                        if (i2 == 2 || i2 == 8) {
                            com.tencent.mm.kernel.g.Dr();
                            int a = bi.a((Integer) com.tencent.mm.kernel.g.Dq().Db().get(68391, null), 0);
                            com.tencent.mm.kernel.g.Dr();
                            com.tencent.mm.kernel.g.Dq().Db().set(68391, Integer.valueOf(a + 1));
                        }
                        com.tencent.mm.plugin.sns.model.a.a aVar = new com.tencent.mm.plugin.sns.model.a.a(are.nMq);
                        aVar.qZY = are;
                        aVar.reG = fVar.qWV;
                        if (i2 == 4) {
                            aVar.reE = true;
                        } else {
                            aVar.reE = false;
                        }
                        aVar.url = str2;
                        i = are.kzz;
                        aVar.reD = z;
                        aVar.reF = i2;
                        aVar.qZX = str;
                        aVar.qWO = eVar;
                        com.tencent.mm.plugin.sns.model.a.c cVar = null;
                        if (i2 == 1 || i2 == 5 || i2 == 7) {
                            cVar = new com.tencent.mm.plugin.sns.model.a.i(this, aVar);
                        } else if (i2 == 4) {
                            x.w("MicroMsg.DownloadManager", "it can not download sight, may be something warn here.");
                            if (are.qWK) {
                                cVar = new h(this, aVar);
                            } else {
                                cVar = new com.tencent.mm.plugin.sns.model.a.g(this, aVar);
                            }
                        } else if (i2 == 2 || i2 == 8 || i2 == 3) {
                            cVar = new com.tencent.mm.plugin.sns.model.a.e(this, aVar);
                        } else if (i2 == 6) {
                            aVar.url = are.wEW;
                            aVar.frM = are.wEY;
                            cVar = new d(this, aVar);
                        }
                        cVar.m("");
                    }
                } else {
                    this.qYH.remove(str);
                }
            }
        }
    }

    public final void a(int i, are are, int i2, boolean z, String str, int i3) {
        x.i("MicroMsg.DownloadManager", "state:%d, mediaId:%s, reqDownloadType:%d, isThumb:%b, requestKey:%s, totalSize:%d", Integer.valueOf(i), are.nMq, Integer.valueOf(i2), Boolean.valueOf(z), str, Integer.valueOf(i3));
        if (!ae.bvO()) {
            com.tencent.mm.kernel.g.Dr();
            if (com.tencent.mm.kernel.g.Do().CF()) {
                this.qYA += i3;
                if (this.qYA > 512000 && this.gDp.size() == 0) {
                    x.d("MicroMsg.DownloadManager", "netSizeAdd %s", Integer.valueOf(this.qYA));
                    com.tencent.mm.y.ak.a.hhw.aV(this.qYA, 0);
                    this.qYA = 0;
                }
                if (i == 1 || i == 3) {
                    this.qYD.put(str, Long.valueOf(System.currentTimeMillis()));
                }
                if (!(i == 3 || i != 1 || i2 == 3)) {
                    g bwc = ae.bwc();
                    x.d("MicroMsg.LazyerImageLoader2", "updateCache " + are.nMq);
                    n nVar = (n) bwc.qYR.get(i.aJ(1, are.nMq));
                    if (i.b(nVar)) {
                        nVar.EL();
                        x.d("MicroMsg.LazyerImageLoader2", "force update");
                        ae.bvS().post(new AnonymousClass9(are));
                    }
                }
                for (b bVar : this.gDT) {
                    if (bVar != null) {
                        if (i != 2) {
                            if (i2 == 3) {
                                bVar.buX();
                            } else if (i2 == 1 || i2 == 5 || i2 == 7) {
                                bVar.Ky(are.nMq);
                            } else if (i2 == 2 || i2 == 8) {
                                bVar.aE(are.nMq, true);
                            } else if (i2 == 4 || i2 == 6) {
                                bVar.aF(are.nMq, true);
                            }
                        } else if (i2 == 2 || i2 == 8) {
                            bVar.aE(are.nMq, false);
                        } else if (i2 == 4 || i2 == 6) {
                            bVar.aF(are.nMq, false);
                        }
                    }
                }
                x.d("MicroMsg.DownloadManager", "onDownLoadFinish by cdn %s", str);
                this.qYG.remove(str);
                Pc();
                KB(str);
                return;
            }
        }
        bvk();
    }

    public final void KC(final String str) {
        ae.aOA().post(new Runnable() {
            public final void run() {
                b.a(b.this, str);
                b.this.KB(str);
            }
        });
    }

    public final void a(int i, int i2, String str, k kVar) {
        x.i("MicroMsg.DownloadManager", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str + " type = " + kVar.getType() + " @" + hashCode());
        if (kVar.getType() == com.tencent.mm.plugin.appbrand.jsapi.a.f.CTRL_INDEX) {
            o oVar = (o) kVar;
            if (i == 0 && i2 == 0) {
                if (kVar.getType() == com.tencent.mm.plugin.appbrand.jsapi.a.f.CTRL_INDEX) {
                    for (b bVar : this.gDT) {
                        if (bVar != null) {
                            if (oVar.qZV == 3) {
                                bVar.buX();
                            } else if (oVar.qZV == 1 || oVar.qZV == 5 || oVar.qZV == 7) {
                                bVar.Ky(oVar.mediaId);
                            } else if (oVar.qZV == 2 || oVar.qZV == 8) {
                                bVar.aE(oVar.mediaId, true);
                            }
                        }
                    }
                }
            } else if (oVar.qZV == 2 || oVar.qZV == 8) {
                for (b bVar2 : this.gDT) {
                    if (bVar2 != null) {
                        bVar2.aE(oVar.mediaId, false);
                    }
                }
            }
        }
    }
}
