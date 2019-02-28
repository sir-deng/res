package com.tencent.mm.modelvideo;

import android.os.HandlerThread;
import android.os.SystemClock;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelcontrol.d;
import com.tencent.mm.plugin.appbrand.jsapi.g.f;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bi;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import junit.framework.Assert;

public final class x {
    public static String hXY = null;

    public static class a implements e {
        private static int fmp = 0;
        Queue<String> fmh = new LinkedList();
        Queue<String> fmi = new LinkedList();
        Map<String, com.tencent.mm.compatible.util.g.a> fmj = new HashMap();
        boolean fmk = false;
        private boolean fml = false;
        private boolean fmm = false;
        int fmn = 0;
        private long fmo = 0;
        com.tencent.mm.compatible.util.g.a fmr = new com.tencent.mm.compatible.util.g.a();
        private al fms = null;
        HandlerThread hXZ = com.tencent.mm.sdk.f.e.dc("VideoService_runThread", 0);
        ag hYa;
        boolean hYb = false;
        public List<v> hYc = new ArrayList();
        Queue<String> hYd = new LinkedList();
        Queue<String> hYe = new LinkedList();
        public d hYf = null;
        g hYg = null;

        static /* synthetic */ int JU() {
            int i = fmp;
            fmp = i + 1;
            return i;
        }

        static /* synthetic */ int UA() {
            int i = fmp;
            fmp = i - 1;
            return i;
        }

        static /* synthetic */ void a(a aVar) {
            String str;
            boolean z = true;
            aVar.fmo = System.currentTimeMillis();
            if ((!aVar.fmk && aVar.fmi.size() + aVar.hYd.size() == 0) || (!aVar.fml && aVar.fmh.size() == 0)) {
                long Wz = bi.Wz();
                List<String> Ux = o.Ub().Ux();
                List<String> Uu = o.Ub().Uu();
                List<String> Uv = o.Ub().Uv();
                List<String> Uw = o.Ub().Uw();
                if (Ux != null) {
                    com.tencent.mm.sdk.platformtools.x.d("MicroMsg.VideoService", "getNeedRunInfo needSendList size: " + Ux.size());
                    for (String str2 : Ux) {
                        if (aVar.fmj.containsKey(str2)) {
                            com.tencent.mm.sdk.platformtools.x.d("MicroMsg.VideoService", "need sendList File is Already running:" + str2);
                        } else {
                            aVar.fmh.offer(str2);
                            aVar.fmj.put(str2, null);
                        }
                    }
                }
                if (Uu != null) {
                    com.tencent.mm.sdk.platformtools.x.d("MicroMsg.VideoService", "getNeedRunInfo needRecvList size: " + Uu.size());
                    for (String str22 : Uu) {
                        if (aVar.fmj.containsKey(str22)) {
                            com.tencent.mm.sdk.platformtools.x.d("MicroMsg.VideoService", "need recvList File is Already running:" + str22);
                        } else {
                            aVar.fmi.offer(str22);
                            aVar.fmj.put(str22, null);
                        }
                    }
                }
                if (Uv != null) {
                    com.tencent.mm.sdk.platformtools.x.d("MicroMsg.VideoService", "getNeedRunInfo online video list size: " + Uv.size());
                    for (String str222 : Uv) {
                        if (aVar.fmj.containsKey(str222)) {
                            com.tencent.mm.sdk.platformtools.x.d("MicroMsg.VideoService", "online videoList File is Already running:" + str222);
                        } else {
                            aVar.hYd.offer(str222);
                            aVar.fmj.put(str222, null);
                        }
                    }
                }
                if (Uw != null) {
                    com.tencent.mm.sdk.platformtools.x.d("MicroMsg.VideoService", "getNeedRunInfo hevc video list size: " + Uw.size());
                    for (String str2222 : Uw) {
                        if (aVar.fmj.containsKey(str2222)) {
                            com.tencent.mm.sdk.platformtools.x.d("MicroMsg.VideoService", "hevc videoList File is Already running:" + str2222);
                        } else {
                            aVar.hYe.offer(str2222);
                            aVar.fmj.put(str2222, null);
                        }
                    }
                }
                com.tencent.mm.sdk.platformtools.x.i("MicroMsg.VideoService", "GetNeedRun cost time[%d] procing[%d] [recv:%d, online:%d, send:%d hevc:%d]", Long.valueOf(bi.bB(Wz)), Integer.valueOf(aVar.fmj.size()), Integer.valueOf(aVar.fmi.size()), Integer.valueOf(aVar.hYd.size()), Integer.valueOf(aVar.fmh.size()), Integer.valueOf(aVar.hYe.size()));
                aVar.fmi.size();
                aVar.fmh.size();
                aVar.hYd.size();
                aVar.hYe.size();
            }
            int i = (aVar.hYe.size() == 0 || !d.Ni()) ? true : 0;
            if (aVar.fmk || aVar.fmi.size() + aVar.hYd.size() != 0 || i == 0 || aVar.fml || aVar.fmh.size() != 0) {
                if (!aVar.fmk && (aVar.fmi.size() > 0 || aVar.hYd.size() > 0 || i == 0)) {
                    if (aVar.hYd.size() > 0) {
                        str2222 = (String) aVar.hYd.poll();
                        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.VideoService", "Start Recv :" + str2222);
                        if (!bi.oN(str2222)) {
                            aVar.fmj.put(str2222, new com.tencent.mm.compatible.util.g.a());
                            aVar.fmk = true;
                            Assert.assertTrue("sceneDown should null", aVar.hYf == null);
                            aVar.hYf = new d(str2222, true);
                            g.CN().a(aVar.hYf, 0);
                        }
                    }
                    if (!aVar.fmk && aVar.fmi.size() > 0) {
                        str2222 = (String) aVar.fmi.poll();
                        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.VideoService", "Start Recv :" + str2222);
                        if (str2222 != null) {
                            aVar.fmj.put(str2222, new com.tencent.mm.compatible.util.g.a());
                            aVar.fmk = true;
                            Assert.assertTrue("sceneDown should null", aVar.hYf == null);
                            aVar.hYf = new d(str2222);
                            g.CN().a(aVar.hYf, 0);
                        }
                    }
                    if (!aVar.fmk) {
                        str2222 = (String) aVar.hYe.poll();
                        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.VideoService", "Start recv hecv: " + str2222);
                        if (!bi.oN(str2222)) {
                            aVar.fmj.put(str2222, new com.tencent.mm.compatible.util.g.a());
                            aVar.fmk = true;
                            Assert.assertTrue("sceneDown should null", aVar.hYf == null);
                            aVar.hYf = new d(str2222, true);
                            g.CN().a(aVar.hYf, 0);
                        }
                    }
                }
                if (!aVar.fml && aVar.fmh.size() > 0) {
                    str2222 = (String) aVar.fmh.poll();
                    com.tencent.mm.sdk.platformtools.x.i("MicroMsg.VideoService", "Start Send :" + str2222);
                    if (str2222 != null) {
                        aVar.fmj.put(str2222, new com.tencent.mm.compatible.util.g.a());
                        aVar.fml = true;
                        String str3 = "sceneUp should null";
                        if (aVar.hYg != null) {
                            z = false;
                        }
                        Assert.assertTrue(str3, z);
                        if (aVar.hYc != null && aVar.hYc.size() > 0) {
                            for (v nO : aVar.hYc) {
                                nO.nO(str2222);
                            }
                        }
                        aVar.hYg = new g(str2222);
                        g.CN().a(aVar.hYg, 0);
                        return;
                    }
                    return;
                }
                return;
            }
            aVar.vC();
            com.tencent.mm.sdk.platformtools.x.d("MicroMsg.VideoService", "No Data Any More , Stop Service");
        }

        public a() {
            g.CN().a((int) f.CTRL_INDEX, (e) this);
            g.CN().a(150, (e) this);
            this.hXZ.start();
            this.hYb = true;
            this.hYa = new ag(this.hXZ.getLooper());
            this.fms = new al(this.hXZ.getLooper(), new com.tencent.mm.sdk.platformtools.al.a() {
                public final boolean uG() {
                    a.a(a.this);
                    return false;
                }

                public final String toString() {
                    return super.toString() + "|scenePusher";
                }
            }, false);
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.VideoService", "create VideoService, start video send thread");
        }

        public final void a(final int i, final int i2, String str, final k kVar) {
            if (this.hXZ == null || !this.hYb || this.hYa == null) {
                com.tencent.mm.sdk.platformtools.x.e("MicroMsg.VideoService", "onSceneEnd error!, handler or thread is null!");
            } else {
                this.hYa.post(new Runnable() {
                    public final void run() {
                        int i;
                        String str;
                        a.JU();
                        String str2;
                        if (kVar.getType() == 150) {
                            a.this.fmk = false;
                            str2 = ((d) kVar).fileName;
                            x.hXY = str2;
                            int i2 = ((d) kVar).retCode;
                            a.this.hYf = null;
                            i = i2;
                            str = str2;
                        } else if (kVar.getType() == f.CTRL_INDEX) {
                            a.this.fml = false;
                            a.this.hYg = null;
                            if (kVar instanceof g) {
                                str2 = ((g) kVar).fileName;
                                i = ((g) kVar).retCode;
                                str = str2;
                            } else if (kVar instanceof h) {
                                i = 0;
                                str = ((h) kVar).fileName;
                            } else {
                                i = 0;
                                str = null;
                            }
                        } else {
                            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.VideoService", "onSceneEnd Error SceneType:" + kVar.getType());
                            a.UA();
                            return;
                        }
                        long j = 0;
                        if (!(str == null || a.this.fmj.get(str) == null)) {
                            j = ((com.tencent.mm.compatible.util.g.a) a.this.fmj.get(str)).zp();
                            a.this.fmj.remove(str);
                        }
                        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.VideoService", "onSceneEnd SceneType:" + kVar.getType() + " errtype:" + i + " errCode:" + i2 + " retCode:" + i + " file:" + str + " time:" + j);
                        if (i == 3 && i != 0) {
                            a.this.fmn = a.this.fmn - 1;
                        } else if (i != 0) {
                            a.this.fmn = 0;
                        }
                        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.VideoService", "onSceneEnd  inCnt:" + a.fmp + " stop:" + a.this.fmn + " running:" + a.this.fmm + " recving:" + a.this.fmk + " sending:" + a.this.fml);
                        if (a.this.fmn > 0) {
                            a.a(a.this);
                        } else if (!(a.this.fml || a.this.fmk)) {
                            a.this.vC();
                        }
                        a.UA();
                    }

                    public final String toString() {
                        return super.toString() + "|onSceneEnd";
                    }
                });
            }
        }

        public final void vC() {
            this.fmj.clear();
            this.fmh.clear();
            this.fmi.clear();
            this.hYd.clear();
            this.hYe.clear();
            this.fml = false;
            this.fmk = false;
            this.fmm = false;
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.VideoService", "Finish service use time(ms):" + this.fmr.zp());
        }

        public final void run() {
            if (this.hXZ == null || !this.hYb || this.hYa == null) {
                com.tencent.mm.sdk.platformtools.x.e("MicroMsg.VideoService", "run error!, handler or thread is null!");
            } else {
                this.hYa.post(new Runnable() {
                    public final void run() {
                        long currentTimeMillis = System.currentTimeMillis() - a.this.fmo;
                        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.VideoService", "Try Run service runningFlag:" + a.this.fmm + " timeWait:" + currentTimeMillis + " sending:" + a.this.fml + " recving:" + a.this.fmk);
                        if (a.this.fmm) {
                            if (currentTimeMillis >= 60000) {
                                com.tencent.mm.sdk.platformtools.x.e("MicroMsg.VideoService", "ERR: Try Run service runningFlag:" + a.this.fmm + " timeWait:" + currentTimeMillis + ">=MAX_TIME_WAIT sending:" + a.this.fml + " recving:" + a.this.fmk);
                            } else {
                                return;
                            }
                        }
                        a.this.fmn = 3;
                        a.this.fmm = true;
                        a.this.fml = false;
                        a.this.fmk = false;
                        a.this.hYg = null;
                        a.this.hYf = null;
                        a.this.fmr.gJu = SystemClock.elapsedRealtime();
                        a.this.fms.K(10, 10);
                    }

                    public final String toString() {
                        return super.toString() + "|run";
                    }
                });
            }
        }

        public final boolean Uz() {
            boolean z;
            if (this.hYf != null) {
                g.CN().c(this.hYf);
                z = true;
                this.fmm = false;
            } else {
                z = false;
            }
            this.fmj.clear();
            this.fmh.clear();
            this.fmi.clear();
            this.hYd.clear();
            this.hYe.clear();
            return z;
        }
    }
}
