package com.tencent.mm.ui.chatting.gallery;

import com.tencent.mm.j.g;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.q;
import com.tencent.mm.modelvideo.r;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.plugin.a.f;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;

public final class l {
    String filename;
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
    int iHW;
    String mediaId;
    private int rBA;
    HashMap<String, Integer> rBt = new HashMap();
    int rBv;
    int rBw = 0;
    long rBx;
    long rBy;
    private long rBz;
    i yPI;
    a yPJ;

    private static class a {
        int hVB;
        int hVC;
        int rBD;
        int yPL;

        private a() {
        }

        /* synthetic */ a(byte b) {
            this();
        }
    }

    public l(i iVar) {
        int i;
        this.yPI = iVar;
        reset();
        this.hVn = new f();
        this.yPJ = new a();
        String value = g.Af().getValue("AndroidOnlineVideoArgs");
        if (!bi.oN(value)) {
            x.i("MicroMsg.OnlineVideoUIHelper", "online video config : " + value);
            String[] split = value.split(";");
            if (split != null && split.length >= 4) {
                this.yPJ.hVB = bi.getInt(split[0], 5);
                this.yPJ.hVC = bi.getInt(split[1], 1);
                this.yPJ.rBD = bi.getInt(split[2], 75);
                this.yPJ.yPL = bi.getInt(split[3], 1) * 1048576;
                i = 1;
                if (i == 0) {
                    this.yPJ.hVB = 5;
                    this.yPJ.hVC = 1;
                    this.yPJ.rBD = 75;
                    this.yPJ.yPL = 1048576;
                }
                x.i("MicroMsg.OnlineVideoUIHelper", "parseConfig preload[%d] downloadSec[%d], needFinish[%d], minStreamSize[%d]", Integer.valueOf(this.yPJ.hVB), Integer.valueOf(this.yPJ.hVC), Integer.valueOf(this.yPJ.rBD), Integer.valueOf(this.yPJ.yPL));
                this.hVt = this.yPJ.hVB;
            }
        }
        boolean i2 = false;
        if (i2 == 0) {
            this.yPJ.hVB = 5;
            this.yPJ.hVC = 1;
            this.yPJ.rBD = 75;
            this.yPJ.yPL = 1048576;
        }
        x.i("MicroMsg.OnlineVideoUIHelper", "parseConfig preload[%d] downloadSec[%d], needFinish[%d], minStreamSize[%d]", Integer.valueOf(this.yPJ.hVB), Integer.valueOf(this.yPJ.hVC), Integer.valueOf(this.yPJ.rBD), Integer.valueOf(this.yPJ.yPL));
        this.hVt = this.yPJ.hVB;
    }

    public final void reset() {
        String str = "";
        this.mediaId = str;
        this.filename = str;
        this.hVp = -1;
        this.rBv = 0;
        this.iHW = 0;
        this.hVs = 0;
        this.hVo = 0;
        this.rBw = 0;
        this.hVm = 0;
        this.hVl = 0;
        this.hVr = false;
        this.hVu = false;
        this.hVv = false;
        this.rBt.clear();
        if (this.yPJ != null) {
            this.hVt = this.yPJ.hVB;
        }
        this.rBx = 0;
        this.hvr = 0;
        this.rBA = 0;
        this.rBz = 0;
        this.rBy = 0;
    }

    public final void cwb() {
        int i;
        x.i("MicroMsg.OnlineVideoUIHelper", "stop stream download video.");
        if (this.hVl == 3) {
            i = 1;
        } else {
            boolean i2 = false;
        }
        this.hVl = 0;
        if (!bi.oN(this.mediaId)) {
            if (i2 != 0) {
                cwd();
            } else if (this.rBv >= this.yPJ.rBD) {
                x.i("MicroMsg.OnlineVideoUIHelper", "start complete video, downloaded (%d) more than config (%d).", Integer.valueOf(this.rBv), Integer.valueOf(this.yPJ.rBD));
                t.Y(this.filename, 2);
                com.tencent.mm.plugin.report.service.g.pWK.a(354, 10, 1, false);
            }
            o.Uc().b(this.mediaId, cwe());
            com.tencent.mm.plugin.report.service.g.pWK.a(354, 2, 1, false);
        }
    }

    public final boolean isStreaming() {
        return !bi.oN(this.mediaId) && (this.hVl == 1 || this.hVl == 3);
    }

    public final boolean My(String str) {
        return bi.fA(str, this.mediaId);
    }

    final void bAF() {
        x.i("MicroMsg.OnlineVideoUIHelper", "play offline video %s ", this.filename);
        bAG();
        ah.y(new Runnable() {
            public final void run() {
                if (l.this.yPI != null) {
                    l.this.yPI.aI(l.this.filename, false);
                }
            }
        });
    }

    public final boolean aj(int i, boolean z) {
        boolean z2;
        switch (this.hVl) {
            case 1:
                this.hVm = 2;
                PInt pInt = new PInt();
                PInt pInt2 = new PInt();
                a(i, pInt, pInt2);
                if (!f(pInt.value, pInt2.value, true)) {
                    this.hVp = i;
                    this.hVr = true;
                    this.yPI.TM();
                    z2 = false;
                    break;
                }
                this.hVp = -1;
                this.hVr = false;
                this.hVs = pInt2.value;
                this.hVm = 3;
                break;
            case 3:
                break;
        }
        this.yPI.G(i, z);
        z2 = true;
        x.i("MicroMsg.OnlineVideoUIHelper", "seek video time %d, download status %d playStatus %d", Integer.valueOf(i), Integer.valueOf(this.hVl), Integer.valueOf(this.hVm));
        com.tencent.mm.plugin.report.service.g.pWK.a(354, 4, 1, false);
        return z2;
    }

    public final boolean iK(int i) {
        int i2;
        boolean z = false;
        if (this.hVp != -1) {
            i2 = this.hVp;
        } else {
            i2 = i;
        }
        x.i("MicroMsg.OnlineVideoUIHelper", "check timer playCurrPos %d playTime %d cachePlayTime %d timeDuration %d downloadStatus %d firPlayWait{%d} isPrepareVideo[%b]", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(this.hVs), Integer.valueOf(this.hVo), Integer.valueOf(this.hVl), Long.valueOf(this.rBy - this.hvr), Boolean.valueOf(this.hVu));
        switch (this.hVl) {
            case 1:
                boolean z2;
                if (iL(i2)) {
                    if (this.rBw == 0 && this.rBy == 0) {
                        bAG();
                    }
                    if (this.hVu) {
                        l lVar;
                        int i3;
                        this.yPI.ZW(this.filename);
                        if (this.hVr) {
                            if (this.rBw == 0 && this.rBy == 0) {
                                bAG();
                            } else if (this.rBz > 0) {
                                this.rBA = (int) (((long) this.rBA) + bi.bA(this.rBz));
                            }
                            x.i("MicroMsg.OnlineVideoUIHelper", "resume by data gain.pauseByLoadDataCount %d pauseAllTime %d", Integer.valueOf(this.rBw), Integer.valueOf(this.rBA));
                            if (this.hVp != -1) {
                                this.yPI.G(this.hVp, true);
                                this.hVp = -1;
                                z2 = false;
                                lVar = this;
                            } else if (this.yPI.bAw()) {
                                z2 = false;
                                lVar = this;
                            } else {
                                z2 = true;
                                lVar = this;
                            }
                            lVar.hVr = z2;
                            i3 = 3;
                            lVar = this;
                        } else {
                            if (this.hVm != 3) {
                                x.i("MicroMsg.OnlineVideoUIHelper", "start to play video playStatus[%d]", Integer.valueOf(this.hVm));
                                if (this.yPI.bAw()) {
                                    i3 = 3;
                                    lVar = this;
                                } else {
                                    i3 = this.hVm;
                                    lVar = this;
                                }
                            }
                            z2 = true;
                        }
                        lVar.hVm = i3;
                        z2 = true;
                    } else {
                        x.i("MicroMsg.OnlineVideoUIHelper", "prepare video [%s]", this.filename);
                        this.yPI.aI(this.filename, true);
                        this.hVu = true;
                        z2 = true;
                    }
                } else {
                    this.hVr = true;
                    if (this.hVs > 0) {
                        x.i("MicroMsg.OnlineVideoUIHelper", "pause by load data pauseByLoadDataCount : " + this.rBw + " playStatus : " + this.hVm);
                        this.rBz = bi.Wy();
                        if (!(this.hVm == 2 || this.hVm == 4)) {
                            this.hVt += this.yPJ.hVB;
                            this.hVt = Math.min(this.hVt, 60);
                            this.rBw++;
                            this.hVm = 4;
                        }
                        this.yPI.TM();
                    } else if (this.hVp == -1) {
                        this.hVm = 1;
                    } else {
                        this.hVm = 2;
                    }
                    z2 = false;
                }
                this.yPI.GA(i2);
                PInt pInt = new PInt();
                PInt pInt2 = new PInt();
                if (!a(i2, pInt, pInt2)) {
                    x.d("MicroMsg.OnlineVideoUIHelper", "can not calc download.");
                } else if (f(pInt.value, pInt2.value, false)) {
                    this.hVs = Math.max(this.hVs, pInt2.value);
                    return true;
                }
                return z2;
            case 3:
                bAG();
                if (this.hVu) {
                    if (this.hVr) {
                        l lVar2;
                        if (this.hVp != -1) {
                            this.yPI.G(this.hVp, true);
                            this.hVp = -1;
                            lVar2 = this;
                        } else if (this.yPI.bAw()) {
                            lVar2 = this;
                        } else {
                            z = true;
                            lVar2 = this;
                        }
                        lVar2.hVr = z;
                    }
                    this.yPI.GA(i2);
                    return true;
                }
                this.yPI.aI(this.filename, false);
                this.hVu = true;
                return true;
            default:
                return true;
        }
    }

    public final boolean iL(int i) {
        Throwable e;
        if (this.hVl == 3) {
            return true;
        }
        if (this.hVs - i <= 2 && this.hVs < this.hVo) {
            return false;
        }
        boolean isVideoDataAvailable;
        PInt pInt = new PInt();
        PInt pInt2 = new PInt();
        try {
            if (this.hVn.a(i, i + 2, pInt, pInt2)) {
                isVideoDataAvailable = o.Uc().isVideoDataAvailable(this.mediaId, pInt.value, pInt2.value);
                if (!isVideoDataAvailable) {
                    try {
                        this.hVs = i;
                    } catch (Exception e2) {
                        e = e2;
                        x.printErrStackTrace("MicroMsg.OnlineVideoUIHelper", e, "", new Object[0]);
                        x.e("MicroMsg.OnlineVideoUIHelper", "check video data error: " + e.toString());
                        return isVideoDataAvailable;
                    }
                }
            }
            isVideoDataAvailable = false;
        } catch (Throwable e3) {
            e = e3;
            isVideoDataAvailable = false;
            x.printErrStackTrace("MicroMsg.OnlineVideoUIHelper", e, "", new Object[0]);
            x.e("MicroMsg.OnlineVideoUIHelper", "check video data error: " + e.toString());
            return isVideoDataAvailable;
        }
        return isVideoDataAvailable;
    }

    private boolean a(int i, PInt pInt, PInt pInt2) {
        pInt.value = Math.max(i, this.hVs);
        if (this.hVm == 1) {
            pInt.value = i;
            pInt2.value = pInt.value + this.hVt;
        }
        if (this.hVm == 2) {
            pInt.value = i - 8;
            if (pInt.value < 0) {
                pInt.value = 0;
            }
            pInt2.value = (pInt.value + this.hVt) + 8;
        }
        if (this.hVm == 3 || this.hVm == 4) {
            pInt.value = this.hVs;
            pInt2.value = ((this.hVt + i) + 2) + this.yPJ.hVC;
        }
        if (pInt2.value >= this.hVo + 1) {
            pInt2.value = this.hVo + 1;
        }
        if (pInt2.value <= pInt.value) {
            pInt2.value = pInt.value + this.yPJ.hVC;
            return false;
        }
        x.i("MicroMsg.OnlineVideoUIHelper", "calcDownloadRange range[%d, %d] playTime[%d] playStatus[%d] cache[%d, %d]", Integer.valueOf(pInt.value), Integer.valueOf(pInt2.value), Integer.valueOf(i), Integer.valueOf(this.hVm), Integer.valueOf(this.hVs), Integer.valueOf(this.hVt));
        return true;
    }

    private boolean f(int i, int i2, boolean z) {
        boolean isVideoDataAvailable;
        String str;
        PInt pInt = new PInt();
        PInt pInt2 = new PInt();
        try {
            if (this.hVn.a(i, i2, pInt, pInt2)) {
                isVideoDataAvailable = o.Uc().isVideoDataAvailable(this.mediaId, pInt.value, pInt2.value);
                if (!isVideoDataAvailable) {
                    x.i("MicroMsg.OnlineVideoUIHelper", "already had video data.");
                } else if (!this.rBt.containsKey(this.mediaId + 0 + "_-1")) {
                    str = this.mediaId + pInt.value + "_" + pInt2.value;
                    x.i("MicroMsg.OnlineVideoUIHelper", "request video data [%d, %d] isRequestNow[%b] isSeek[%b]", Integer.valueOf(pInt.value), Integer.valueOf(pInt2.value), Boolean.valueOf(this.hVv), Boolean.valueOf(z));
                    if (!this.rBt.containsKey(str) || (this.hVv && !z)) {
                        x.i("MicroMsg.OnlineVideoUIHelper", "already request video : " + str);
                    } else {
                        this.hVv = true;
                        o.Uc();
                        com.tencent.mm.modelcdntran.f.f(this.mediaId, pInt.value, pInt2.value);
                        this.rBt.put(str, Integer.valueOf(i2));
                    }
                }
                return isVideoDataAvailable;
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.OnlineVideoUIHelper", e, "", new Object[0]);
            x.e("MicroMsg.OnlineVideoUIHelper", "check video data error: " + e.toString());
        }
        isVideoDataAvailable = false;
        if (!isVideoDataAvailable) {
            x.i("MicroMsg.OnlineVideoUIHelper", "already had video data.");
        } else if (this.rBt.containsKey(this.mediaId + 0 + "_-1")) {
            str = this.mediaId + pInt.value + "_" + pInt2.value;
            x.i("MicroMsg.OnlineVideoUIHelper", "request video data [%d, %d] isRequestNow[%b] isSeek[%b]", Integer.valueOf(pInt.value), Integer.valueOf(pInt2.value), Boolean.valueOf(this.hVv), Boolean.valueOf(z));
            if (this.rBt.containsKey(str)) {
            }
            x.i("MicroMsg.OnlineVideoUIHelper", "already request video : " + str);
        }
        return isVideoDataAvailable;
    }

    public final void cwc() {
        String str = this.mediaId + 0 + "_-1";
        if (!this.rBt.containsKey(str)) {
            x.i("MicroMsg.OnlineVideoUIHelper", "request all data. [%s]", this.mediaId);
            o.Uc();
            com.tencent.mm.modelcdntran.f.f(this.mediaId, 0, -1);
            this.rBt.put(str, Integer.valueOf(0));
            com.tencent.mm.plugin.report.service.g.pWK.a(354, 24, 1, false);
            x.w("MicroMsg.OnlineVideoUIHelper", "%d rpt request all video %s ", Integer.valueOf(hashCode()), this.filename);
            com.tencent.mm.plugin.report.service.g.pWK.h(13836, Integer.valueOf(303), Long.valueOf(bi.Wx()), "");
        }
        this.hVm = 5;
    }

    final void cwd() {
        o.Ub();
        if (q.ns(s.nx(this.filename))) {
            boolean b;
            x.i("MicroMsg.OnlineVideoUIHelper", "download finish and is hevc need complete %s ", this.filename);
            r nJ = t.nJ(this.filename);
            if (nJ != null) {
                nJ.videoFormat = 2;
                nJ.status = 123;
                nJ.hXu = bi.Wx();
                nJ.hXt = bi.Wx();
                nJ.hvw = 19;
                nJ.fEo = 268438786;
                b = o.Ub().b(nJ);
                x.i("MicroMsg.VideoLogic", "set hevc video Completion ret: " + b + " status: " + nJ.status);
            } else {
                b = false;
            }
            if (b) {
                com.tencent.mm.plugin.report.service.g.pWK.a(354, 134, 1, false);
            }
        }
    }

    final void bAG() {
        if (this.rBy == 0) {
            this.rBy = bi.Wy();
        }
    }

    final Object[] cwe() {
        Object[] objArr = new Object[7];
        i iVar = this.yPI;
        if (iVar.rBm < 0) {
            iVar.rBm = 0;
        }
        x.i("MicroMsg.Imagegallery.handler.video", "get[%s] play video duration [%d]", iVar.filename, Integer.valueOf(iVar.rBm));
        objArr[0] = Integer.valueOf(iVar.rBm);
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
        i iVar2 = this.yPI;
        if (iVar2.rBg <= 0 || iVar2.rBf <= 0) {
            i = 0;
        } else {
            i = (int) (iVar2.rBg - iVar2.rBf);
        }
        if (i < 0) {
            i = 0;
        }
        x.i("MicroMsg.Imagegallery.handler.video", "%d filename[%s] get ui stay time[%d %d %d]", Integer.valueOf(iVar2.hashCode()), iVar2.filename, Integer.valueOf(i), Long.valueOf(iVar2.rBg), Long.valueOf(iVar2.rBf));
        objArr[5] = Integer.valueOf(i);
        objArr[6] = Integer.valueOf(this.yPI.mBn);
        return objArr;
    }
}
