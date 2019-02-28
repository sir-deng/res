package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.j.g;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.plugin.a.f;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.model.aq;
import com.tencent.mm.plugin.sns.model.aq.AnonymousClass5;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.c.are;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;

public final class af {
    are fIx;
    String fsC;
    int hBH;
    String hVi;
    String hVj;
    int hVl = 0;
    int hVm = 0;
    f hVn;
    int hVo;
    int hVp;
    boolean hVr;
    int hVs = 0;
    private int hVt;
    boolean hVu = false;
    boolean hVv = false;
    long hvr;
    int progress;
    int qnf;
    private int rBA;
    private b rBB;
    HashMap<String, Integer> rBt = null;
    a rBu;
    int rBv;
    private int rBw = 0;
    long rBx;
    private long rBy;
    private long rBz;

    public interface a {
        void TM();

        void aI(String str, boolean z);

        int bAA();

        int bAB();

        boolean bAw();

        int bAz();

        void sV(int i);
    }

    private static class b {
        int hVB;
        int hVC;
        int rBD;

        private b() {
        }

        /* synthetic */ b(byte b) {
            this();
        }
    }

    public af(a aVar) {
        this.rBu = aVar;
        this.hVn = new f();
        this.rBt = new HashMap();
        this.rBB = new b();
        this.rBB.hVB = g.Af().getInt("SnsVideoPreloadSec", 5);
        this.rBB.hVC = g.Af().getInt("SnsVideoDownloadSec", 1);
        this.rBB.rBD = g.Af().getInt("SnsVideoFullDownloadPercent", 101);
        x.i("MicroMsg.OnlineVideoViewHelper", "parseConfig preload[%d] downloadSec[%d], needFinish[%d]", Integer.valueOf(this.rBB.hVB), Integer.valueOf(this.rBB.hVC), Integer.valueOf(this.rBB.rBD));
        reset();
    }

    public final void clear() {
        x.i("MicroMsg.OnlineVideoViewHelper", "clear");
        reset();
        this.rBu = null;
        this.hVn = null;
    }

    private void reset() {
        this.hVi = "";
        this.hVp = -1;
        this.hVs = 0;
        this.hVo = 0;
        this.rBw = 0;
        this.hVm = 0;
        this.hVl = 0;
        this.hVr = false;
        this.hVu = false;
        this.hVv = false;
        this.rBt.clear();
        this.fIx = null;
        this.hBH = 0;
        this.fsC = null;
        if (this.rBB != null) {
            this.hVt = this.rBB.hVB;
        }
        this.rBx = 0;
        this.hvr = 0;
        this.rBA = 0;
        this.rBz = 0;
        this.rBy = 0;
    }

    public final boolean bAE() {
        if (!bi.oN(this.hVi)) {
            x.i("MicroMsg.OnlineVideoViewHelper", "stop online download video %s isFinish %b percent %d", this.hVi, Boolean.valueOf(this.hVl == 3), Integer.valueOf(this.rBv));
            aq bwd = ae.bwd();
            String str = this.hVi;
            Object[] objArr = new Object[7];
            objArr[0] = Integer.valueOf(this.rBu.bAz());
            if (this.rBy <= 0) {
                this.rBy = bi.Wy();
            }
            int i = (int) (this.rBy - this.hvr);
            if (i <= 0) {
                i = 0;
            }
            objArr[1] = Integer.valueOf(i);
            if (this.rBx <= 0) {
                this.rBx = bi.Wy();
            }
            i = (int) (this.rBx - this.hvr);
            if (i <= 0) {
                i = 0;
            }
            objArr[2] = Integer.valueOf(i);
            objArr[3] = Integer.valueOf(this.rBw);
            if (this.rBw > 0) {
                if (this.rBA == 0) {
                    this.rBA = (int) (((long) this.rBA) + bi.bA(this.rBz));
                }
                objArr[4] = Integer.valueOf(this.rBA / this.rBw);
            } else {
                objArr[4] = Integer.valueOf(0);
            }
            objArr[5] = Integer.valueOf(this.rBu.bAB());
            objArr[6] = Integer.valueOf(this.rBu.bAA());
            if (!bi.oN(str)) {
                com.tencent.mm.kernel.g.Dr();
                com.tencent.mm.kernel.g.Dt().F(new AnonymousClass5(str, objArr));
            }
            if (this.rBv >= this.rBB.rBD && !r0) {
                ae.bwd().a(this.fIx, this.hBH, this.fsC, false, false, 36);
            }
            com.tencent.mm.plugin.report.service.g.pWK.a(354, 203, 1, false);
        }
        return true;
    }

    public final boolean My(String str) {
        return bi.fA(this.hVi, str);
    }

    public final boolean iK(int i) {
        int i2;
        boolean z = false;
        if (this.hVp != -1) {
            i2 = this.hVp;
        } else {
            i2 = i;
        }
        x.i("MicroMsg.OnlineVideoViewHelper", "check timer playCurrPos %d playTime %d cachePlayTime %d timeDuration %d playStatus %d downloadStatus %d cdnMediaId %s firPlayWait{%d} isPrepareVideo[%b]", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(this.hVs), Integer.valueOf(this.hVo), Integer.valueOf(this.hVm), Integer.valueOf(this.hVl), this.hVi, Long.valueOf(this.rBy - this.hvr), Boolean.valueOf(this.hVu));
        switch (this.hVl) {
            case 1:
                boolean z2;
                boolean z3;
                if (iL(i2)) {
                    bAG();
                    if (!this.hVu) {
                        x.i("MicroMsg.OnlineVideoViewHelper", "prepare cdnMediaId [%s]", this.hVi);
                        if (this.hVm == 5) {
                            this.hVm = 1;
                        }
                        this.rBu.aI(this.hVj, true);
                        this.hVu = true;
                        z2 = true;
                    } else if (this.hVr) {
                        if (this.rBw == 0 && this.rBy == 0) {
                            bAG();
                        } else if (this.rBz > 0) {
                            this.rBA = (int) (((long) this.rBA) + bi.bA(this.rBz));
                        }
                        x.i("MicroMsg.OnlineVideoViewHelper", "resume by data gain.pauseByLoadDataCount %d pauseAllTime %d cdnMediaId %s", Integer.valueOf(this.rBw), Integer.valueOf(this.rBA), this.hVi);
                        this.hVm = 3;
                        if (this.hVp != -1) {
                            this.rBu.sV(this.hVp);
                            this.hVp = -1;
                            this.hVr = false;
                            z2 = true;
                        } else {
                            this.hVr = !this.rBu.bAw();
                            z2 = true;
                        }
                    } else {
                        if (this.hVm != 3) {
                            x.i("MicroMsg.OnlineVideoViewHelper", "start to play video playStatus[%d]", Integer.valueOf(this.hVm));
                            this.hVm = this.rBu.bAw() ? 3 : this.hVm;
                        }
                        z2 = true;
                    }
                } else {
                    this.hVr = true;
                    if (this.hVs > 0) {
                        x.i("MicroMsg.OnlineVideoViewHelper", "pause by load data cdnMediaId %s, pauseByLoadDataCount %d, playStatus %d", this.hVi, Integer.valueOf(this.rBw), Integer.valueOf(this.hVm));
                        this.rBz = bi.Wy();
                        if (!(this.hVm == 2 || this.hVm == 4)) {
                            this.hVt += this.rBB.hVB;
                            this.hVt = Math.min(this.hVt, 60);
                            this.rBw++;
                            this.hVm = 4;
                        }
                        this.rBu.TM();
                    } else if (this.hVp == -1) {
                        this.hVm = 1;
                    } else {
                        this.hVm = 2;
                    }
                    z2 = false;
                }
                PInt pInt = new PInt();
                PInt pInt2 = new PInt();
                pInt.value = Math.max(i2, this.hVs);
                if (this.hVm == 1) {
                    pInt.value = i2;
                    pInt2.value = pInt.value + this.hVt;
                }
                if (this.hVm == 2) {
                    pInt.value = i2 - 8;
                    if (pInt.value < 0) {
                        pInt.value = 0;
                    }
                    pInt2.value = (pInt.value + this.hVt) + 8;
                }
                if (this.hVm == 3 || this.hVm == 4) {
                    pInt.value = this.hVs;
                    pInt2.value = ((this.hVt + i2) + 1) + this.rBB.hVC;
                }
                if (pInt2.value >= this.hVo + 1) {
                    pInt2.value = this.hVo + 1;
                }
                if (pInt2.value < pInt.value) {
                    pInt2.value = pInt.value + this.rBB.hVC;
                    z3 = false;
                } else {
                    x.i("MicroMsg.OnlineVideoViewHelper", "calcDownloadRange range[%d, %d] playTime[%d] playStatus[%d] cache[%d, %d]", Integer.valueOf(pInt.value), Integer.valueOf(pInt2.value), Integer.valueOf(i2), Integer.valueOf(this.hVm), Integer.valueOf(this.hVs), Integer.valueOf(this.hVt));
                    z3 = true;
                }
                if (!z3) {
                    x.d("MicroMsg.OnlineVideoViewHelper", "can not calc download.");
                    o.Uc();
                    com.tencent.mm.modelcdntran.f.f(this.hVi, 0, -1);
                } else if (dG(pInt.value, pInt2.value)) {
                    this.hVs = Math.max(this.hVs, pInt2.value);
                    return true;
                }
                return z2;
            case 2:
                x.w("MicroMsg.OnlineVideoViewHelper", "download error.");
                return true;
            case 3:
                bAG();
                if (this.hVu) {
                    if (this.hVr) {
                        af afVar;
                        if (this.hVp != -1) {
                            this.rBu.sV(this.hVp);
                            this.hVp = -1;
                            afVar = this;
                        } else if (this.rBu.bAw()) {
                            afVar = this;
                        } else {
                            z = true;
                            afVar = this;
                        }
                        afVar.hVr = z;
                    }
                    this.hVm = 3;
                    return true;
                }
                if (this.hVm == 5) {
                    this.hVm = 1;
                }
                this.rBu.aI(this.hVj, false);
                this.hVu = true;
                return true;
            default:
                x.w("MicroMsg.OnlineVideoViewHelper", "check time default.");
                return true;
        }
    }

    private boolean iL(int i) {
        if (this.hVl == 3) {
            return true;
        }
        if (this.hVs - i <= 1 && this.hVs < this.hVo) {
            return false;
        }
        PInt pInt = new PInt();
        PInt pInt2 = new PInt();
        try {
            if (!this.hVn.a(i, i + 1, pInt, pInt2)) {
                return false;
            }
            boolean isVideoDataAvailable = o.Uc().isVideoDataAvailable(this.hVi, pInt.value, pInt2.value);
            if (isVideoDataAvailable) {
                return isVideoDataAvailable;
            }
            this.hVs = i;
            return isVideoDataAvailable;
        } catch (Exception e) {
            x.e("MicroMsg.OnlineVideoViewHelper", "check video data error: " + e.toString());
            return false;
        }
    }

    private boolean dG(int i, int i2) {
        boolean isVideoDataAvailable;
        String str;
        PInt pInt = new PInt();
        PInt pInt2 = new PInt();
        try {
            if (this.hVn.a(i, i2, pInt, pInt2)) {
                pInt2.value += 81920;
                isVideoDataAvailable = o.Uc().isVideoDataAvailable(this.hVi, pInt.value, pInt2.value);
                if (!isVideoDataAvailable) {
                    x.i("MicroMsg.OnlineVideoViewHelper", "already had video data.");
                } else if (!this.rBt.containsKey(this.hVi + 0 + "_-1")) {
                    str = this.hVi + pInt.value + "_" + pInt2.value;
                    x.i("MicroMsg.OnlineVideoViewHelper", "request video data [%d, %d] isRequestNow[%b] isSeek[%b]", Integer.valueOf(pInt.value), Integer.valueOf(pInt2.value), Boolean.valueOf(this.hVv), Boolean.valueOf(false));
                    if (!this.rBt.containsKey(str) || this.hVv) {
                        x.i("MicroMsg.OnlineVideoViewHelper", "already request video : " + str);
                    } else {
                        this.hVv = true;
                        o.Uc();
                        com.tencent.mm.modelcdntran.f.f(this.hVi, pInt.value, pInt2.value);
                        this.rBt.put(str, Integer.valueOf(i2));
                    }
                }
                return isVideoDataAvailable;
            }
        } catch (Exception e) {
            x.e("MicroMsg.OnlineVideoViewHelper", "check video data error: " + e.toString());
        }
        isVideoDataAvailable = false;
        if (!isVideoDataAvailable) {
            x.i("MicroMsg.OnlineVideoViewHelper", "already had video data.");
        } else if (this.rBt.containsKey(this.hVi + 0 + "_-1")) {
            str = this.hVi + pInt.value + "_" + pInt2.value;
            x.i("MicroMsg.OnlineVideoViewHelper", "request video data [%d, %d] isRequestNow[%b] isSeek[%b]", Integer.valueOf(pInt.value), Integer.valueOf(pInt2.value), Boolean.valueOf(this.hVv), Boolean.valueOf(false));
            if (this.rBt.containsKey(str)) {
            }
            x.i("MicroMsg.OnlineVideoViewHelper", "already request video : " + str);
        }
        return isVideoDataAvailable;
    }

    final void bAF() {
        x.i("MicroMsg.OnlineVideoViewHelper", "play offline video %s ", this.hVi);
        bAG();
        ah.y(new Runnable() {
            public final void run() {
                if (af.this.rBu != null) {
                    af.this.rBu.aI(af.this.hVj, false);
                }
            }
        });
    }

    final void bAG() {
        if (this.rBy == 0) {
            this.rBy = bi.Wy();
        }
    }
}
