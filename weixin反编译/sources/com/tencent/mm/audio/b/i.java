package com.tencent.mm.audio.b;

import android.os.SystemClock;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.compatible.util.g.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelvoice.f;
import com.tencent.mm.modelvoice.m;
import com.tencent.mm.modelvoice.p;
import com.tencent.mm.modelvoice.q;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.wcdb.FileUtils;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public final class i implements e {
    private static int fmp = 0;
    public static boolean fmq = true;
    Queue<String> fmh = new LinkedList();
    Queue<p> fmi = new LinkedList();
    Map<String, a> fmj = new HashMap();
    private boolean fmk = false;
    private boolean fml = false;
    private boolean fmm = false;
    public int fmn = 0;
    private long fmo = 0;
    a fmr = new a();
    private al fms = new al(g.Dt().oFY.getLooper(), new al.a() {
        public final boolean uG() {
            x.d("MicroMsg.SceneVoiceService", "onTimerExpired");
            i.h(i.this);
            return false;
        }

        public final String toString() {
            return super.toString() + "|scenePusher";
        }
    }, false);

    static /* synthetic */ void h(i iVar) {
        p pVar;
        iVar.fmo = System.currentTimeMillis();
        if ((!iVar.fmk && iVar.fmi.size() == 0) || (!iVar.fml && iVar.fmh.size() == 0)) {
            List<p> UP = q.UP();
            if (!(UP == null || UP.size() == 0)) {
                long currentTimeMillis = System.currentTimeMillis() / 1000;
                String fK = bi.fK(currentTimeMillis);
                for (p pVar2 : UP) {
                    if (iVar.fmj.containsKey(pVar2.fileName)) {
                        x.d("MicroMsg.SceneVoiceService", "File is Already running:" + pVar2.fileName);
                    } else {
                        x.i("MicroMsg.SceneVoiceService", "Get file:" + pVar2.fileName + " status:" + pVar2.status + " user" + pVar2.fEx + " human:" + pVar2.hXn + " create:" + bi.fK(pVar2.hXs) + " last:" + bi.fK(pVar2.hXt) + " now:" + bi.fK(currentTimeMillis) + " " + (currentTimeMillis - pVar2.hXt));
                        if (pVar2.UN()) {
                            if (currentTimeMillis - pVar2.hXt > 80 && pVar2.status == 5) {
                                x.e("MicroMsg.SceneVoiceService", "time out file: " + pVar2.fileName + " last:" + bi.fK(pVar2.hXt) + " now:" + fK + " msgLocalId:" + pVar2.hXw + " status:" + pVar2.status);
                                if (pVar2.hXw == 0) {
                                    pVar2.hXt = System.currentTimeMillis() / 1000;
                                    pVar2.fEo = 320;
                                    m.UK().a(pVar2.fileName, pVar2);
                                } else {
                                    q.nC(pVar2.fileName);
                                }
                            }
                            if (currentTimeMillis - pVar2.hXt > 300 && pVar2.status == 6) {
                                x.e("MicroMsg.SceneVoiceService", "time out file: " + pVar2.fileName + " last:" + bi.fK(pVar2.hXt) + " now:" + fK + " msgLocalId:" + pVar2.hXw + " status:" + pVar2.status);
                                if (pVar2.hXw == 0) {
                                    pVar2.hXt = System.currentTimeMillis() / 1000;
                                    pVar2.fEo = 320;
                                    m.UK().a(pVar2.fileName, pVar2);
                                } else {
                                    q.nC(pVar2.fileName);
                                }
                            }
                            if (pVar2.hXp >= pVar2.hWd) {
                                x.i("MicroMsg.SceneVoiceService", "file: " + pVar2.fileName + " stat:" + pVar2.status + " now:" + pVar2.hXp + " net:" + pVar2.hWd);
                            } else {
                                iVar.fmi.offer(pVar2);
                                iVar.fmj.put(pVar2.fileName, null);
                            }
                        }
                        if (pVar2.UO()) {
                            x.i("MicroMsg.SceneVoiceService", "now " + currentTimeMillis + "info.getLastModifyTime()  " + pVar2.hXt + "  info.getStatus() " + pVar2.status + "  info.getCreateTime() " + pVar2.hXs);
                            if (currentTimeMillis - pVar2.hXt > 10 && (pVar2.status == 2 || pVar2.status == 1)) {
                                x.e("MicroMsg.SceneVoiceService", "time out file: " + pVar2.fileName + " last:" + bi.fK(pVar2.hXt) + " now:" + fK);
                                q.nC(pVar2.fileName);
                            } else if (currentTimeMillis - pVar2.hXs > 600 && pVar2.status == 3) {
                                x.e("MicroMsg.SceneVoiceService", "time out file: " + pVar2.fileName + " last:" + bi.fK(pVar2.hXt) + " now:" + fK);
                                q.nC(pVar2.fileName);
                            } else if (pVar2.fEx.length() <= 0) {
                                x.e("MicroMsg.SceneVoiceService", "Create a new ChatRoom? , set username first :" + pVar2.fileName);
                            } else {
                                iVar.fmh.offer(pVar2.fileName);
                                iVar.fmj.put(pVar2.fileName, null);
                            }
                        }
                    }
                }
                x.i("MicroMsg.SceneVoiceService", "GetNeedRun procing:" + iVar.fmj.size() + " [recv:" + iVar.fmi.size() + ",send:" + iVar.fmh.size() + "]");
                iVar.fmi.size();
                iVar.fmh.size();
            }
        }
        if (iVar.fmk || iVar.fmi.size() != 0 || iVar.fml || iVar.fmh.size() != 0) {
            if (!iVar.fmk && iVar.fmi.size() > 0) {
                Object obj;
                pVar2 = (p) iVar.fmi.poll();
                String str = pVar2.fileName;
                if (((h) g.h(h.class)).aZO().dK(pVar2.fGj)) {
                    x.i("MicroMsg.SceneVoiceService", "[oneliang] msg svrid:%s,it is in delete msg list,may be revoke msg come first,msg info insert last,so no need to add msg info and delete voice info", Long.valueOf(pVar2.fGj));
                    obj = 1;
                } else {
                    obj = null;
                }
                if (obj == null) {
                    x.i("MicroMsg.SceneVoiceService", "Start Recv :" + str);
                    if (str != null) {
                        iVar.fmj.put(str, new a());
                        iVar.fmk = true;
                        g.CN().a(new com.tencent.mm.modelvoice.e(pVar2), 0);
                    }
                } else if (bi.oM(pVar2.fileName).length() > 0) {
                    m.UK().iI(pVar2.fileName);
                    return;
                } else {
                    x.i("MicroMsg.SceneVoiceService", "[oneliang] the length of voice info file name is zero");
                    return;
                }
            }
            if (!iVar.fml && iVar.fmh.size() > 0) {
                String str2 = (String) iVar.fmh.poll();
                x.i("MicroMsg.SceneVoiceService", "Start Send :" + str2);
                if (str2 != null) {
                    iVar.fmj.put(str2, new a());
                    iVar.fml = true;
                    g.CN().a(new f(str2), 0);
                    return;
                }
                return;
            }
            return;
        }
        iVar.vC();
        x.i("MicroMsg.SceneVoiceService", "No Data Any More , Stop Service");
    }

    static /* synthetic */ int vD() {
        int i = fmp;
        fmp = i + 1;
        return i;
    }

    static /* synthetic */ int vE() {
        int i = fmp;
        fmp = i - 1;
        return i;
    }

    public i() {
        g.CN().a(127, (e) this);
        g.CN().a((int) FileUtils.S_IWUSR, (e) this);
    }

    public final void a(final int i, final int i2, String str, final k kVar) {
        g.Dt().F(new Runnable() {
            public final void run() {
                int i;
                String str;
                i.vD();
                String str2;
                if (kVar.getType() == FileUtils.S_IWUSR) {
                    i.this.fmk = false;
                    str2 = ((com.tencent.mm.modelvoice.e) kVar).fileName;
                    i = ((com.tencent.mm.modelvoice.e) kVar).retCode;
                    str = str2;
                } else if (kVar.getType() == 127) {
                    i.this.fml = false;
                    str2 = ((f) kVar).fileName;
                    i = ((f) kVar).retCode;
                    str = str2;
                } else {
                    x.e("MicroMsg.SceneVoiceService", "onSceneEnd Error SceneType:" + kVar.getType());
                    i.vE();
                    return;
                }
                long j = 0;
                if (!(str == null || i.this.fmj.get(str) == null)) {
                    j = ((a) i.this.fmj.get(str)).zp();
                    i.this.fmj.remove(str);
                }
                x.i("MicroMsg.SceneVoiceService", "onSceneEnd SceneType:" + kVar.getType() + " errtype:" + i + " errCode:" + i2 + " retCode:" + i + " file:" + str + " time:" + j);
                if (i == 3 && i != 0) {
                    i.this.fmn = i.this.fmn - 1;
                } else if (i != 0) {
                    i.this.fmn = 0;
                }
                x.i("MicroMsg.SceneVoiceService", "onSceneEnd  inCnt:" + i.fmp + " stop:" + i.this.fmn + " running:" + i.this.fmm + " recving:" + i.this.fmk + " sending:" + i.this.fml);
                if (i.this.fmn > 0) {
                    i.h(i.this);
                } else if (!(i.this.fml || i.this.fmk)) {
                    i.this.vC();
                    x.i("MicroMsg.SceneVoiceService", "onSceneEnd fin and try next delay 3s [%d, %d] [%b]", Integer.valueOf(i), Integer.valueOf(i), Boolean.valueOf(i.fmq));
                    if (i.fmq && i == 4) {
                        g.Dt().g(new Runnable() {
                            public final void run() {
                                x.i("MicroMsg.SceneVoiceService", "onSceneEnd fin and try run");
                                i.this.run();
                            }
                        }, 10000);
                    }
                }
                i.vE();
            }

            public final String toString() {
                return super.toString() + "|onSceneEnd";
            }
        });
    }

    private void vC() {
        this.fmj.clear();
        this.fmh.clear();
        this.fmi.clear();
        this.fml = false;
        this.fmk = false;
        this.fmm = false;
        x.i("MicroMsg.SceneVoiceService", "Finish service use time(ms):" + this.fmr.zp());
    }

    public final void run() {
        g.Dt().F(new Runnable() {
            public final void run() {
                long currentTimeMillis = System.currentTimeMillis() - i.this.fmo;
                x.i("MicroMsg.SceneVoiceService", "Try Run service runningFlag:" + i.this.fmm + " timeWait:" + currentTimeMillis + " sending:" + i.this.fml + " recving:" + i.this.fmk);
                if (i.this.fmm) {
                    if (currentTimeMillis >= 60000) {
                        x.e("MicroMsg.SceneVoiceService", "ERR: Try Run service runningFlag:" + i.this.fmm + " timeWait:" + currentTimeMillis + ">=MAX_TIME_WAIT sending:" + i.this.fml + " recving:" + i.this.fmk);
                    } else {
                        return;
                    }
                }
                i.this.fmm = true;
                i.this.fml = false;
                i.this.fmn = 3;
                i.this.fmk = false;
                i.this.fmr.gJu = SystemClock.elapsedRealtime();
                i.this.fms.K(10, 10);
            }

            public final String toString() {
                return super.toString() + "|run";
            }
        });
    }
}
