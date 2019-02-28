package com.tencent.mm.plugin.sns.model;

import com.tencent.mm.a.g;
import com.tencent.mm.f.a.qg;
import com.tencent.mm.modelcdntran.d;
import com.tencent.mm.modelcdntran.i;
import com.tencent.mm.modelcdntran.keep_ProgressInfo;
import com.tencent.mm.modelcdntran.keep_SceneResult;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.modelvideo.n;
import com.tencent.mm.plugin.mmsight.model.h;
import com.tencent.mm.plugin.sns.storage.q;
import com.tencent.mm.protocal.c.aqp;
import com.tencent.mm.protocal.c.arb;
import com.tencent.mm.protocal.c.arh;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.ByteArrayOutputStream;

public final class ab {
    private String beo;
    private String clientId;
    private String fwx;
    String hCY;
    int hCZ;
    private com.tencent.mm.modelcdntran.i.a hDi;
    int hXa;
    private String jfL;
    private int qXb;
    private long raP;
    q rbg;
    a rbh;
    private arh rbi;
    long startTime;

    public interface a {
        void io(boolean z);
    }

    static /* synthetic */ void a(ab abVar) {
        try {
            abVar.rbi = (arh) new arh().aH(abVar.rbg.rvw);
            abVar.jfL = g.bV(abVar.beo);
            abVar.rbi.frM = abVar.jfL;
            abVar.rbg.rvw = abVar.rbi.toByteArray();
            x.i("MicroMsg.SightCdnUpload", "new md5 is %s %s", abVar.beo, abVar.jfL);
            ae.bvU().a(abVar.rbg.ruM, abVar.rbg);
        } catch (Exception e) {
            x.e("MicroMsg.SightCdnUpload", "parseFrom MediaUploadInfo error in updateMd5Info %s", e.getMessage());
        }
    }

    public ab(int i, q qVar, String str, String str2, a aVar) {
        this.clientId = "";
        this.raP = 0;
        this.startTime = 0;
        this.hCZ = 0;
        this.jfL = "";
        this.rbi = new arh();
        this.hDi = new com.tencent.mm.modelcdntran.i.a() {
            public final int a(String str, int i, keep_ProgressInfo keep_progressinfo, keep_SceneResult keep_sceneresult, boolean z) {
                if (i == -21005) {
                    x.d("MicroMsg.SightCdnUpload", "cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", ab.this.hCY, Integer.valueOf(i), keep_progressinfo, keep_sceneresult);
                    ab.this.rbh.io(true);
                    return 0;
                } else if (keep_sceneresult != null && keep_sceneresult.field_retCode == 0) {
                    x.i("MicroMsg.SightCdnUpload", "cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", ab.this.hCY, Integer.valueOf(i), keep_progressinfo, keep_sceneresult);
                    ab.this.U(keep_sceneresult.field_fileUrl, keep_sceneresult.field_thumbUrl, "upload_" + ab.this.hCY);
                    com.tencent.mm.plugin.report.service.g.pWK.h(10421, Integer.valueOf(0), Integer.valueOf(1), Long.valueOf(ab.this.startTime), Long.valueOf(bi.Wy()), Integer.valueOf(d.bi(ad.getContext())), Integer.valueOf(ab.this.hCZ), Integer.valueOf(keep_sceneresult.field_fileLength), keep_sceneresult.field_transInfo, "", "", "", "", "", "", "", keep_sceneresult.report_Part2);
                    n TZ = n.TZ();
                    int i2 = ab.this.hXa;
                    if (keep_sceneresult != null) {
                        String str2 = keep_sceneresult.field_fileUrl;
                        String str3 = str2.hashCode();
                        a aVar = (a) TZ.hWJ.get(str3);
                        if (aVar == null) {
                            aVar = new a();
                        }
                        String str4 = "";
                        aVar.gkD = str4;
                        aVar.toUser = str4;
                        aVar.hWW = str4;
                        aVar.hXa = i2;
                        aVar.hWZ = 1;
                        aVar.fAO = str2;
                        aVar.hWn = keep_sceneresult;
                        aVar.startTime = bi.Wy();
                        TZ.hWJ.put(str3, aVar);
                        x.i("MicroMsg.SubCoreMediaRpt", "note sns video sendScene %d snsKey[%s] url[%s]", Integer.valueOf(i2), str3, str2);
                    }
                    ab.this.rbh.io(true);
                    return 0;
                } else if (keep_sceneresult != null && keep_sceneresult.field_retCode != 0) {
                    x.i("MicroMsg.SightCdnUpload", "cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", ab.this.hCY, Integer.valueOf(i), keep_progressinfo, keep_sceneresult);
                    ab.this.wR(0);
                    com.tencent.mm.plugin.report.service.g.pWK.h(10421, Integer.valueOf(keep_sceneresult.field_retCode), Integer.valueOf(1), Long.valueOf(ab.this.startTime), Long.valueOf(bi.Wy()), Integer.valueOf(d.bi(ad.getContext())), Integer.valueOf(ab.this.hCZ), Integer.valueOf(keep_sceneresult.field_fileLength), keep_sceneresult.field_transInfo, "", "", "", "", "", "", "", keep_sceneresult.report_Part2);
                    com.tencent.mm.plugin.report.service.g.pWK.h(13937, Integer.valueOf(keep_sceneresult.field_retCode), Integer.valueOf(1), Long.valueOf(ab.this.startTime), Long.valueOf(bi.Wy()), Integer.valueOf(d.bi(ad.getContext())), Integer.valueOf(ab.this.hCZ), Integer.valueOf(keep_sceneresult.field_fileLength), keep_sceneresult.field_transInfo, "", "", "", "", "", "", "", keep_sceneresult.report_Part2);
                    ab.this.rbh.io(false);
                    return 0;
                } else if (i != 0) {
                    x.i("MicroMsg.SightCdnUpload", "cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", ab.this.hCY, Integer.valueOf(i), keep_progressinfo, keep_sceneresult);
                    ab.this.wR(0);
                    if (keep_sceneresult != null) {
                        com.tencent.mm.plugin.report.service.g.pWK.h(10421, Integer.valueOf(i), Integer.valueOf(1), Long.valueOf(ab.this.startTime), Long.valueOf(bi.Wy()), Integer.valueOf(d.bi(ad.getContext())), Integer.valueOf(ab.this.hCZ), Integer.valueOf(keep_sceneresult.field_fileLength), keep_sceneresult.field_transInfo, "", "", "", "", "", "", "", keep_sceneresult.report_Part2);
                    }
                    ab.this.rbh.io(false);
                    return 0;
                } else {
                    x.d("MicroMsg.SightCdnUpload", "cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", ab.this.hCY, Integer.valueOf(i), keep_progressinfo, keep_sceneresult);
                    return 0;
                }
            }

            public final void a(String str, ByteArrayOutputStream byteArrayOutputStream) {
            }

            public final byte[] h(String str, byte[] bArr) {
                return null;
            }
        };
        this.raP = System.currentTimeMillis();
        this.beo = str;
        this.fwx = str2;
        this.rbh = aVar;
        this.qXb = i;
        this.rbg = qVar;
        try {
            this.rbi = (arh) new arh().aH(qVar.rvw);
            this.clientId = this.rbi.wFM;
            this.jfL = this.rbi.frM;
            if (bi.oN(this.clientId)) {
                this.clientId = g.s((bi.Wz()).getBytes());
                this.rbi.wFM = this.clientId;
                try {
                    qVar.rvw = this.rbi.toByteArray();
                    ae.bvU().a(qVar.ruM, qVar);
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.SightCdnUpload", e, "", new Object[0]);
                }
            }
            int mi = (int) FileOp.mi(str);
            x.i("MicroMsg.SightCdnUpload", "sightupload %d videopath %s sightFileSize %d md5 %s", Integer.valueOf(i), str, Integer.valueOf(mi), this.jfL);
        } catch (Exception e2) {
            x.e("MicroMsg.SightCdnUpload", "parseFrom MediaUploadInfo error in NetSceneSnsUpload");
        }
    }

    public final boolean bvF() {
        String bV = g.bV(this.beo);
        if (bi.oN(this.jfL) || this.jfL.equals(bV)) {
            aqp aqp;
            if (this.rbi.wFP != null) {
                aqp = this.rbi.wFP;
            } else {
                aqp = new aqp();
            }
            x.i("MicroMsg.SightCdnUpload", "check upload %s %d %s", this.beo, Integer.valueOf(aqp.wEb), Boolean.valueOf(aqp.wEa));
            if (aqp.wEa) {
                int i = h.oyy;
                if (aqp.wEb >= 3) {
                    onError();
                    return false;
                }
                x.i("MicroMsg.SightCdnUpload", "try need remux %d %s", Integer.valueOf(i), this.beo);
                final b qgVar = new qg();
                qgVar.frD = new Runnable() {
                    public final void run() {
                        x.i("MicroMsg.SightCdnUpload", "event callback errcode %d", Integer.valueOf(qgVar.fIJ.result));
                        if (qgVar.fIJ.result >= 0) {
                            ab.a(ab.this);
                            ab.this.a(aqp);
                            return;
                        }
                        ab.this.onError();
                    }
                };
                qgVar.fII.fIM = new com.tencent.mm.plugin.mmsight.model.d() {
                    public final boolean aZH() {
                        x.i("MicroMsg.SightCdnUpload", "iUpdateVideoFile");
                        ab.a(ab.this);
                        return false;
                    }
                };
                qgVar.fII.fIv = this.beo;
                qgVar.fII.scene = i;
                qgVar.fII.fIK = aqp;
                qgVar.fII.fIL = new Runnable() {
                    public final void run() {
                        aqp.wEb++;
                        try {
                            x.i("MicroMsg.SightCdnUpload", "add try count %d", Integer.valueOf(aqp.wEb));
                            arh arh = (arh) new arh().aH(ab.this.rbg.rvw);
                            arh.wFP = aqp;
                            ab.this.rbg.rvw = arh.toByteArray();
                            ae.bvU().a(ab.this.rbg.ruM, ab.this.rbg);
                        } catch (Exception e) {
                            x.e("MicroMsg.SightCdnUpload", "parseFrom MediaUploadInfo error in checkUploadaddCount %s", e.getMessage());
                        }
                    }
                };
                com.tencent.mm.sdk.b.a.xmy.a(qgVar, ae.bvS().getLooper());
                return true;
            }
            a(aqp);
            return true;
        }
        x.i("MicroMsg.SightCdnUpload", "checkUpload isNotSafeSightVideo old srcmd5 %s newmd5 %s ", this.jfL, bV);
        wR(-2);
        this.rbh.io(false);
        return false;
    }

    final boolean a(aqp aqp) {
        if (this.startTime == 0) {
            this.startTime = bi.Wy();
            this.hCZ = com.tencent.mm.modelcdntran.b.htz;
        }
        String str = this.clientId;
        if (bi.oN(str)) {
            x.w("MicroMsg.SightCdnUpload", "cdntra genClientId failed not use cdn");
            return false;
        }
        i iVar = new i();
        iVar.hve = this.hDi;
        iVar.field_mediaId = str;
        iVar.field_fullpath = this.beo;
        iVar.field_thumbpath = this.fwx;
        iVar.field_fileType = com.tencent.mm.modelcdntran.b.htz;
        iVar.field_talker = "";
        iVar.field_priority = com.tencent.mm.modelcdntran.b.htu;
        iVar.field_needStorage = true;
        iVar.field_isStreamMedia = false;
        iVar.field_appType = 102;
        iVar.field_bzScene = 1;
        iVar.field_largesvideo = true;
        String bV = g.bV(this.beo);
        if (!bi.oN(this.jfL) && !this.jfL.equals(bV)) {
            x.i("MicroMsg.SightCdnUpload", "isNotSafeSightVideo old srcmd5 %s newmd5 %s ", this.jfL, bV);
            wR(-2);
            this.rbh.io(false);
            return false;
        } else if (com.tencent.mm.modelcdntran.g.MP().c(iVar)) {
            int i = (aqp == null || !aqp.wEa) ? 5 : 4;
            this.hXa = i;
            return true;
        } else {
            x.e("MicroMsg.SightCdnUpload", "cdntra addSendTask failed. clientid:%s", str);
            return false;
        }
    }

    public final boolean U(String str, String str2, String str3) {
        arh arh;
        q eT = ae.bvU().eT((long) this.qXb);
        x.d("MicroMsg.SightCdnUpload", "upload ok " + str + "  " + str3 + "  1");
        eT.rvv = str3;
        try {
            arh = (arh) new arh().aH(eT.rvw);
        } catch (Exception e) {
            arh = null;
        }
        if (arh == null) {
            arh = new arh();
        }
        arb arb = new arb();
        arb.kzz = 1;
        arb.nlE = str;
        arh.wFI = arb;
        arh.wFL = 0;
        com.tencent.mm.modelcdntran.g.MQ();
        arh.wFk = com.tencent.mm.modelcdntran.b.kG(this.beo);
        x.i("MicroMsg.SightCdnUpload", "onPostScene videomd5 %s", arh.wFk);
        if (!bi.oN(str2)) {
            arb = new arb();
            arb.kzz = 1;
            arb.nlE = str2;
            arh.wFK.add(arb);
        }
        try {
            eT.rvw = arh.toByteArray();
        } catch (Throwable e2) {
            x.printErrStackTrace("MicroMsg.SightCdnUpload", e2, "", new Object[0]);
        }
        eT.bzx();
        ae.bvU().a(this.qXb, eT);
        ae.bwe().wW(this.qXb);
        if (ae.bwb() != null) {
            ae.bwb().buT();
        }
        return true;
    }

    final void wR(int i) {
        x.i("MicroMsg.SightCdnUpload", "snsupload sight by cdn error!");
        q eT = ae.bvU().eT((long) this.qXb);
        try {
            arh arh = (arh) new arh().aH(eT.rvw);
            arh.wFL = 1;
            arh.wFu = i;
            if (this.rbi.wFP != null) {
                this.rbi.wFP.wEb = 0;
            }
            eT.rvw = arh.toByteArray();
        } catch (Exception e) {
        }
        ae.bwe().wW(this.qXb);
        ae.bvU().a(this.qXb, eT);
    }

    final void onError() {
        x.i("MicroMsg.SightCdnUpload", "snsupload sight by cdn error!");
        q eT = ae.bvU().eT((long) this.qXb);
        eT.offset = 0;
        try {
            arh arh = (arh) new arh().aH(eT.rvw);
            arh.wFM = "";
            if (arh.wFP != null) {
                arh.wFP.wEb = 0;
            }
            eT.rvw = arh.toByteArray();
            ae.bvU().a(this.qXb, eT);
            ae.bwe().wW(this.qXb);
        } catch (Exception e) {
            x.e("MicroMsg.SightCdnUpload", "parseFrom MediaUploadInfo error in NetSceneSnsUpload");
        }
    }
}
