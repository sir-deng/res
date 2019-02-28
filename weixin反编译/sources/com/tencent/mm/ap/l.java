package com.tencent.mm.ap;

import com.tencent.mars.cdn.CdnLogic;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.f;
import com.tencent.mm.ad.k;
import com.tencent.mm.ad.r;
import com.tencent.mm.ad.t;
import com.tencent.mm.f.b.cg;
import com.tencent.mm.modelcdntran.d;
import com.tencent.mm.modelcdntran.i;
import com.tencent.mm.modelcdntran.keep_ProgressInfo;
import com.tencent.mm.modelcdntran.keep_SceneResult;
import com.tencent.mm.modelstat.h;
import com.tencent.mm.network.ab;
import com.tencent.mm.network.c;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.c.bek;
import com.tencent.mm.protocal.c.bes;
import com.tencent.mm.protocal.c.bet;
import com.tencent.mm.protocal.c.bsg;
import com.tencent.mm.protocal.c.bsh;
import com.tencent.mm.protocal.c.jz;
import com.tencent.mm.protocal.c.ka;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bj;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.y.bb;
import com.tencent.mm.y.bd;
import com.tencent.mm.y.q;
import com.tencent.mm.y.s;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.io.ByteArrayOutputStream;
import java.util.Map;
import junit.framework.Assert;

public final class l extends k implements com.tencent.mm.network.k {
    public static boolean DEBUG = true;
    private static long hDz;
    private String TAG;
    private float fAo;
    public String fHE;
    public au fou;
    private final com.tencent.mm.ad.b gLB;
    private e gLE;
    private long gNA;
    private int gNB;
    private e gNC;
    private boolean gNI;
    private int hBE;
    private long hBI;
    private final f hCU;
    public long hCV;
    private h hCX;
    private String hCY;
    private int hCZ;
    private int hDc;
    private com.tencent.mm.modelcdntran.i.a hDi;
    private String hDo;
    private String hDp;
    private boolean hDq;
    private e hDr;
    private int hDs;
    b hDt;
    private String hDu;
    private boolean hDv;
    private float hDw;
    private String hDx;
    private String hDy;
    private int scene;
    private int startOffset;
    private long startTime;

    public interface a {
        void Pp();
    }

    private class b {
        public a hDE;

        final void Pp() {
            e d;
            if (l.this.hCV == l.this.gNA) {
                d = l.this.Pq();
            } else {
                d = l.this.Pr();
            }
            if (d.hBM == 1) {
                com.tencent.mm.plugin.report.service.f.vS(23);
                com.tencent.mm.plugin.report.service.f.vS(21);
            }
            if (o.PC().a(Long.valueOf(l.this.gNA), l.this.Pq()) < 0) {
                x.e(l.this.TAG, "update db failed local id:" + l.this.gNA + " server id:" + l.this.Pq().fGj);
                i.hX((int) l.this.hCV);
                i.hW((int) l.this.hCV);
                l.this.gLE.a(3, -1, "", l.this);
            }
            if (l.this.gNA != l.this.hCV) {
                o.PC().a(Long.valueOf(l.this.hCV), l.this.Pr());
            }
            ah.y(new Runnable(l.this.gNA) {
                public final void run() {
                    n.Pt().hDH.remove(Long.valueOf(r2));
                }
            });
            if (l.this.hCV != l.this.gNA) {
                ah.y(/* anonymous class already generated */);
            }
            if (this.hDE != null) {
                this.hDE.Pp();
            }
            l.this.hY(l.this.hBE);
            l.this.hDt = null;
        }

        public b(a aVar) {
            this.hDE = aVar;
        }
    }

    private e Pq() {
        if (this.gNC == null) {
            this.gNC = o.PC().b(Long.valueOf(this.gNA));
        }
        return this.gNC;
    }

    private e Pr() {
        if (this.hDr == null) {
            this.hDr = o.PC().b(Long.valueOf(this.hCV));
        }
        return this.hDr;
    }

    public l(String str, String str2, String str3, int i) {
        this(4, str, str2, str3, i, null, "", "");
    }

    public l(int i, String str, String str2, String str3, int i2, f fVar, int i3, a aVar, int i4) {
        this(3, str, str2, str3, i2, fVar, i3, "", "", true, i4);
        this.hDt = new b(aVar);
    }

    private l(int i, String str, String str2, String str3, int i2, f fVar, String str4, String str5) {
        this(4, str, str2, str3, i2, null, 0, str4, str5, false, -1);
    }

    public l(int i, String str, String str2, String str3, int i2, f fVar, int i3, String str4, String str5, boolean z, int i4) {
        this(i, str, str2, str3, i2, fVar, i3, str4, str5, z, i4, 0, -1000.0f, -1000.0f);
    }

    public l(int i, String str, String str2, String str3, int i2, f fVar, int i3, String str4, String str5, boolean z, int i4, int i5, float f, float f2) {
        this.TAG = "MicroMsg.NetSceneUploadMsgImg";
        this.hDo = "";
        this.hDp = "";
        this.hDq = true;
        this.hDs = 16384;
        this.hBE = 0;
        this.fou = null;
        this.hCX = null;
        this.hCY = "";
        this.startTime = 0;
        this.startOffset = -1;
        this.hCZ = 0;
        this.hDt = new b(null);
        this.hDi = new com.tencent.mm.modelcdntran.i.a() {
            public final int a(String str, int i, keep_ProgressInfo keep_progressinfo, final keep_SceneResult keep_sceneresult, boolean z) {
                Throwable th;
                x.d(l.this.TAG, "cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", l.this.hCY, Integer.valueOf(i), keep_progressinfo, keep_sceneresult);
                g gVar;
                String str2;
                if (i == -21005) {
                    x.w(l.this.TAG, "cdntra  ERR_CNDCOM_MEDIA_IS_UPLOADING clientid:%s", l.this.hCY);
                    if (l.this.hDt != null) {
                        l.this.hDt.Pp();
                    }
                    l.this.gLE.a(3, i, "", l.this);
                    return 0;
                } else if (i != 0) {
                    x.e(l.this.TAG, "cdntra cdnCallback clientid:%s startRet:%d", l.this.hCY, Integer.valueOf(i));
                    i.hX((int) l.this.hCV);
                    i.hW((int) l.this.hCV);
                    if (keep_sceneresult != null) {
                        gVar = g.pWK;
                        Object[] objArr = new Object[16];
                        objArr[0] = Integer.valueOf(i);
                        objArr[1] = Integer.valueOf(1);
                        objArr[2] = Long.valueOf(l.this.startTime);
                        objArr[3] = Long.valueOf(bi.Wy());
                        objArr[4] = Integer.valueOf(d.bi(ad.getContext()));
                        objArr[5] = Integer.valueOf(l.this.hCZ);
                        objArr[6] = Integer.valueOf(keep_sceneresult.field_fileLength);
                        objArr[7] = keep_sceneresult.field_transInfo;
                        objArr[8] = "";
                        objArr[9] = "";
                        objArr[10] = "";
                        objArr[11] = "";
                        objArr[12] = "";
                        objArr[13] = "";
                        objArr[14] = "";
                        if (keep_sceneresult == null) {
                            str2 = "";
                        } else {
                            str2 = l.lr(keep_sceneresult.report_Part2);
                        }
                        objArr[15] = str2;
                        gVar.h(10421, objArr);
                    }
                    l.this.gLE.a(3, i, "", l.this);
                    if (l.this.hDt != null) {
                        l.this.hDt.Pp();
                    }
                    return 0;
                } else {
                    final e d = l.this.Pq();
                    if (d == null || d.hBA != l.this.gNA) {
                        com.tencent.mm.modelcdntran.g.MP().kK(l.this.hCY);
                        x.e(l.this.TAG, "cdntra get imginfo failed maybe delete by user imgLocalId:%d client:%s", Long.valueOf(l.this.gNA), l.this.hCY);
                        if (l.this.hDt != null) {
                            l.this.hDt.Pp();
                        }
                        return 0;
                    } else if (keep_progressinfo != null) {
                        l.this.a(d, keep_progressinfo.field_finishedLength, 0, 0, keep_sceneresult);
                        return 0;
                    } else {
                        if (keep_sceneresult != null) {
                            x.i(l.this.TAG, "dkupimg sceneResult:%s", keep_sceneresult);
                            bsh bsh;
                            Object[] objArr2;
                            if (keep_sceneresult.field_retCode != 0) {
                                x.e(l.this.TAG, "cdntra clientid:%s sceneResult.retCode:%d sceneResult[%s]", l.this.hCY, Integer.valueOf(keep_sceneresult.field_retCode), keep_sceneresult);
                                if (keep_sceneresult.field_retCode == -21111) {
                                    x.w(l.this.TAG, "summersafecdn cdntra  ERR_CDNCOM_SAFEPROTO_NOAESKEY clientid:%s, enableHitcheck:%b", l.this.hCY, Boolean.valueOf(l.this.hDq));
                                    com.tencent.mm.kernel.g.Dr();
                                    com.tencent.mm.kernel.g.Dt().F(new Runnable() {
                                        public final void run() {
                                            l.this.hDq = false;
                                            l.this.startTime = 0;
                                            l.this.startOffset = 0;
                                            e d = l.this.Pq();
                                            d.hM(0);
                                            l.this.fou.aq(bb.hU(l.this.fou.field_talker));
                                            l.this.hCY = d.a("upimg", l.this.fou.field_createTime, l.this.fou.field_talker, l.this.fou.field_msgId + "_" + l.this.gNA + "_" + l.this.hBE);
                                            boolean a = l.this.a(d, 0, 0, 0, keep_sceneresult);
                                            bsg bsg = (bsg) l.this.gLB.hnQ.hnY;
                                            if (bsg == null) {
                                                x.w(l.this.TAG, "summersafecdn ERR_CDNCOM_SAFEPROTO_NOAESKEY doScene again but old req is null");
                                            } else {
                                                bsg.xaa = new bet().Vf(l.this.hCY);
                                            }
                                            x.i(l.this.TAG, "summersafecdn ERR_CDNCOM_SAFEPROTO_NOAESKEY doScene again enableHitcheck[%b], ret[%b] new clientid[%s] createtime[%d]", Boolean.valueOf(l.this.hDq), Boolean.valueOf(a), l.this.hCY, Long.valueOf(l.this.fou.field_createTime));
                                            l.this.a(l.this.hok, l.this.gLE);
                                        }
                                    });
                                    return 0;
                                }
                                bsh = null;
                                if (!bi.by(keep_sceneresult.field_sKeyrespbuf)) {
                                    bsh = new bsh();
                                    try {
                                        bsh.aH(keep_sceneresult.field_sKeyrespbuf);
                                        x.d(l.this.TAG, "parse skeyrespbuf: ret:%d,msg:%s", Integer.valueOf(bsh.wRa.vQL), bsh.wRa.vRT.toString());
                                    } catch (Throwable e) {
                                        th = e;
                                        bsh = null;
                                        x.e(l.this.TAG, "UploadMsgImgResponse parse fail: %s", th);
                                        x.e(l.this.TAG, "exception:%s", bi.i(th));
                                    } catch (Throwable e2) {
                                        th = e2;
                                        bsh = null;
                                        x.e(l.this.TAG, "UploadMsgImgResponse parse UninitializedMessageException: %s", th);
                                        x.e(l.this.TAG, "exception:%s", bi.i(th));
                                    }
                                }
                                i.hX((int) l.this.hCV);
                                i.hW((int) l.this.hCV);
                                g gVar2 = g.pWK;
                                objArr2 = new Object[16];
                                objArr2[0] = Integer.valueOf(keep_sceneresult.field_retCode);
                                objArr2[1] = Integer.valueOf(1);
                                objArr2[2] = Long.valueOf(l.this.startTime);
                                objArr2[3] = Long.valueOf(bi.Wy());
                                objArr2[4] = Integer.valueOf(d.bi(ad.getContext()));
                                objArr2[5] = Integer.valueOf(l.this.hCZ);
                                objArr2[6] = Integer.valueOf(keep_sceneresult.field_fileLength);
                                objArr2[7] = keep_sceneresult.field_transInfo;
                                objArr2[8] = "";
                                objArr2[9] = "";
                                objArr2[10] = "";
                                objArr2[11] = "";
                                objArr2[12] = "";
                                objArr2[13] = "";
                                objArr2[14] = "";
                                objArr2[15] = keep_sceneresult == null ? "" : l.lr(keep_sceneresult.report_Part2);
                                gVar2.h(10421, objArr2);
                                gVar2 = g.pWK;
                                objArr2 = new Object[16];
                                objArr2[0] = Integer.valueOf(keep_sceneresult.field_retCode);
                                objArr2[1] = Integer.valueOf(1);
                                objArr2[2] = Long.valueOf(l.this.startTime);
                                objArr2[3] = Long.valueOf(bi.Wy());
                                objArr2[4] = Integer.valueOf(d.bi(ad.getContext()));
                                objArr2[5] = Integer.valueOf(l.this.hCZ);
                                objArr2[6] = Integer.valueOf(keep_sceneresult.field_fileLength);
                                objArr2[7] = keep_sceneresult.field_transInfo;
                                objArr2[8] = "";
                                objArr2[9] = "";
                                objArr2[10] = "";
                                objArr2[11] = "";
                                objArr2[12] = "";
                                objArr2[13] = "";
                                objArr2[14] = "";
                                objArr2[15] = keep_sceneresult == null ? "" : l.lr(keep_sceneresult.report_Part2);
                                gVar2.h(13937, objArr2);
                                if (bsh == null || bsh.wRa.vQL == 0) {
                                    l.this.gLE.a(3, keep_sceneresult.field_retCode, "", l.this);
                                } else {
                                    l.this.gLE.a(4, bsh.wRa.vQL, bsh.wRa.vRT.toString(), l.this);
                                }
                                if (l.this.hDt != null) {
                                    l.this.hDt.Pp();
                                }
                            } else {
                                String str3;
                                x.i(l.this.TAG, "summersafecdn uploadMsgImg by cdn, UploadHitCacheType: %d, needSendMsg:%b", Integer.valueOf(keep_sceneresult.field_UploadHitCacheType), Boolean.valueOf(keep_sceneresult.field_needSendMsgField));
                                gVar = g.pWK;
                                objArr2 = new Object[3];
                                objArr2[0] = Integer.valueOf(d.cPf == 0 ? 3 : d.cPf);
                                objArr2[1] = l.this.hDo;
                                objArr2[2] = Integer.valueOf(keep_sceneresult.field_UploadHitCacheType);
                                gVar.h(13230, objArr2);
                                String v = l.this.hDu;
                                str2 = "";
                                a ln = f.ln(v);
                                if (ln == null || bi.oN(ln.appId)) {
                                    str3 = str2;
                                } else {
                                    str3 = f.c(ln.appId, ln.mediaTagName, ln.messageExt, ln.messageAction);
                                }
                                if (bi.oN(v)) {
                                    str2 = (("<msg><img aeskey=\"" + keep_sceneresult.field_aesKey + "\" cdnmidimgurl=\"" + keep_sceneresult.field_fileId + "\" cdnbigimgurl=\"" + keep_sceneresult.field_fileId + "\" ") + "cdnthumburl=\"" + keep_sceneresult.field_fileId + "\" cdnthumbaeskey=\"" + keep_sceneresult.field_aesKey + "\" cdnthumblength=\"" + keep_sceneresult.field_thumbimgLength + "\" ") + "length=\"" + (keep_sceneresult.field_midimgLength == 0 ? keep_sceneresult.field_fileLength : keep_sceneresult.field_midimgLength) + "\" hdlength=\"" + keep_sceneresult.field_fileLength + "\"/>" + str3 + "</msg>";
                                    x.i(l.this.TAG, "cdn callback new build cdnInfo:%s", str2);
                                } else {
                                    Map y = bj.y(v, "msg");
                                    if (y != null) {
                                        if (d.hBE == 0) {
                                            str2 = (("<msg><img aeskey=\"" + ((String) y.get(".msg.img.$aeskey")) + "\" cdnmidimgurl=\"" + keep_sceneresult.field_fileId + "\" cdnbigimgurl=\"" + ((String) y.get(".msg.img.$cdnbigimgurl")) + "\" ") + "cdnthumburl=\"" + ((String) y.get(".msg.img.$cdnthumburl")) + "\" cdnthumbaeskey=\"" + ((String) y.get(".msg.img.$cdnthumbaeskey")) + "\" cdnthumblength=\"" + ((String) y.get(".msg.img.cdnthumblength")) + "\" ") + "length=\"" + (keep_sceneresult.field_midimgLength == 0 ? keep_sceneresult.field_fileLength : keep_sceneresult.field_midimgLength) + "\" hdlength=\"" + ((String) y.get(".msg.img.$hdlength")) + "\"/>" + str3 + "</msg>";
                                        } else {
                                            str2 = (("<msg><img aeskey=\"" + ((String) y.get(".msg.img.$aeskey")) + "\" cdnmidimgurl=\"" + ((String) y.get(".msg.img.$cdnmidimgurl")) + "\" cdnbigimgurl=\"" + keep_sceneresult.field_fileId + "\" ") + "cdnthumburl=\"" + ((String) y.get(".msg.img.$cdnthumburl")) + "\" cdnthumbaeskey=\"" + ((String) y.get(".msg.img.$cdnthumbaeskey")) + "\" cdnthumblength=\"" + ((String) y.get(".msg.img.cdnthumblength")) + "\" ") + "length=\"" + ((String) y.get(".msg.img.$length")) + "\" hdlength=\"" + keep_sceneresult.field_fileLength + "\"/>" + str3 + "</msg>";
                                        }
                                        x.i(l.this.TAG, "cdn callback rebuild cdnInfo:%s", str2);
                                    } else {
                                        str2 = v;
                                    }
                                }
                                if (keep_sceneresult.isUploadBySafeCDNWithMD5()) {
                                    if (bi.oN(l.this.hDy)) {
                                        x.w(l.this.TAG, "summersafecdn sceneResult isUploadBySafeCDNWithMD5 but prepareResponse AESKey is null");
                                    } else {
                                        str2 = (("<msg><img aeskey=\"" + l.this.hDy + "\" cdnmidimgurl=\"" + keep_sceneresult.field_fileId + "\" cdnbigimgurl=\"" + keep_sceneresult.field_fileId + "\" ") + "cdnthumburl=\"" + keep_sceneresult.field_fileId + "\" cdnthumbaeskey=\"" + l.this.hDy + "\" ") + "length=\"" + keep_sceneresult.field_midimgLength + "\" hdlength=\"" + keep_sceneresult.field_fileLength + "\"/>" + str3 + "</msg>";
                                    }
                                }
                                d.lm(str2);
                                if (l.this.hCV != l.this.gNA) {
                                    l.this.Pr().lm(str2);
                                }
                                if (keep_sceneresult.field_needSendMsgField) {
                                    com.tencent.mm.kernel.g.Dp().gRu.a(new m(l.this.gNB, (bsg) l.this.gLB.hnQ.hnY, d, keep_sceneresult, new a() {
                                        public final void a(long j, int i, int i2, int i3) {
                                            g.pWK.h(10421, Integer.valueOf(i3), Integer.valueOf(1), Long.valueOf(l.this.startTime), Long.valueOf(bi.Wy()), Integer.valueOf(d.bi(ad.getContext())), Integer.valueOf(l.this.hCZ), Integer.valueOf(keep_sceneresult.field_fileLength), keep_sceneresult.field_transInfo, "", "", "", "", "", "", "", l.lr(keep_sceneresult.report_Part2));
                                            x.i(l.this.TAG, "cdntra clientid:%s NetSceneUploadMsgImgForCdn ret:[%d,%d]", l.this.hCY, Integer.valueOf(i2), Integer.valueOf(i3));
                                            if (i2 == 0 && i3 == 0) {
                                                l.this.a(d, d.hmZ, j, i, keep_sceneresult);
                                                return;
                                            }
                                            i.hX((int) l.this.hCV);
                                            i.hW((int) l.this.hCV);
                                            l.this.gLE.a(i2, i3, "", l.this);
                                            if (l.this.hDt != null) {
                                                l.this.hDt.Pp();
                                            }
                                        }
                                    }), 0);
                                } else {
                                    g.pWK.h(10421, Integer.valueOf(0), Integer.valueOf(1), Long.valueOf(l.this.startTime), Long.valueOf(bi.Wy()), Integer.valueOf(d.bi(ad.getContext())), Integer.valueOf(l.this.hCZ), Integer.valueOf(keep_sceneresult.field_fileLength), keep_sceneresult.field_transInfo, "", "", "", "", "", "", "", l.lr(keep_sceneresult.report_Part2));
                                    bsh = new bsh();
                                    try {
                                        bsh.aH(keep_sceneresult.field_sKeyrespbuf);
                                        long j = bsh.vNT != 0 ? bsh.vNT : (long) bsh.vNL;
                                        x.d(l.this.TAG, "parse skeyrespbuf: ret:%d,msg:%s", Integer.valueOf(bsh.wRa.vQL), bsh.wRa.vRT.toString());
                                        l.this.a(d, d.hmZ, j, bsh.pgR, keep_sceneresult);
                                        l.this.gLE.a(0, 0, "", l.this);
                                        if (l.this.hDt != null) {
                                            l.this.hDt.Pp();
                                        }
                                        return 0;
                                    } catch (Throwable e22) {
                                        x.e(l.this.TAG, "UploadMsgImgResponse parse fail: %s", e22);
                                        x.e(l.this.TAG, "exception:%s", bi.i(e22));
                                        l.this.gLE.a(3, keep_sceneresult.field_retCode, "", l.this);
                                        if (l.this.hDt != null) {
                                            l.this.hDt.Pp();
                                        }
                                    }
                                }
                            }
                        }
                        return 0;
                    }
                }
            }

            public final void a(String str, ByteArrayOutputStream byteArrayOutputStream) {
                bsg bsg = (bsg) l.this.gLB.hnQ.hnY;
                com.tencent.mm.bp.a jzVar = new jz();
                jzVar.vXt = bsg.xaa.wRo;
                jzVar.npW = bsg.vNM.wRo;
                jzVar.npV = bsg.vNN.wRo;
                jzVar.vXu = bsg.xah;
                jzVar.vXv = bsg.xai;
                jzVar.sfa = l.this.scene;
                jzVar.vXx = l.this.hDw;
                jzVar.vXy = l.this.fAo;
                jzVar.vXz = l.this.hDx;
                jzVar.vNR = bsg.vNR;
                jzVar.vXE = l.this.hDp;
                jzVar.nlV = bsg.nlV;
                jzVar.vMr = bsg.vMr;
                jzVar.vMt = bsg.vMt;
                jzVar.vMs = bsg.vMs;
                e d = l.this.Pq();
                String m = o.PC().m(d.hBB, "", "");
                com.tencent.mm.modelcdntran.g.MQ();
                jzVar.vXG = com.tencent.mm.modelcdntran.b.kF(m);
                jzVar.vXH = d.hBF;
                if (jzVar.vXH <= 0) {
                    jzVar.vXH = l.this.gNB == 4 ? 2 : 1;
                }
                switch (l.this.gNB) {
                    case 1:
                    case 2:
                        jzVar.vON = 1;
                        break;
                    case 4:
                        jzVar.vON = 3;
                        break;
                    case 6:
                        jzVar.vON = 5;
                        break;
                    default:
                        jzVar.vON = 2;
                        break;
                }
                if (jzVar.vXH == 3) {
                    jzVar.vON = 4;
                }
                x.i(l.this.TAG, "getCdnAuthInfo: mediaid:%s thumbwidth:%d, thumbheight:%d,MsgSource:%s,touser:%s aeskey[%s], imgLocalId[%d], msgLocalId[%d], getBigImgPath()[%s], fullpath[%s], prereq.CRC32[%d] prereq.MsgForwardType[%d], prereq.Source[%d]", str, Integer.valueOf(jzVar.vXu), Integer.valueOf(jzVar.vXv), jzVar.vNR, jzVar.npV, jzVar.vXE, Long.valueOf(l.this.gNA), Long.valueOf(l.this.hBI), d.hBB, m, Integer.valueOf(jzVar.vXG), Integer.valueOf(jzVar.vXH), Integer.valueOf(jzVar.vON));
                com.tencent.mm.ad.b.a aVar = new com.tencent.mm.ad.b.a();
                aVar.hnT = jzVar;
                aVar.hnU = new bsh();
                aVar.uri = "/cgi-bin/micromsg-bin/uploadmsgimg";
                aVar.hnS = 625;
                aVar.hnV = 9;
                aVar.hnW = 1000000009;
                com.tencent.mm.ad.b Kf = aVar.Kf();
                c KD = l.this.hok.KD();
                String f = l.this.TAG;
                String str2 = "getCdnAuthInfo login:%s";
                Object[] objArr = new Object[1];
                objArr[0] = KD == null ? "acc == null" : Boolean.valueOf(KD.Kz());
                x.i(f, str2, objArr);
                if (KD == null || !KD.Kz()) {
                    x.e(l.this.TAG, "getCdnAuthInfo accinfo return null. clientimgid:%s", jzVar.vXt);
                    return;
                }
                if (r.a(KD.CM(), KD.Ky(), KD.KA(), Kf.Kh(), byteArrayOutputStream, KD.KB())) {
                    x.d(l.this.TAG, "getCdnAuthInfo successed.clientimgid:%s", jzVar.vXt);
                } else {
                    x.e(l.this.TAG, "getCdnAuthInfo failed. clientimgid:%s", jzVar.vXt);
                }
            }

            public final byte[] h(String str, byte[] bArr) {
                PInt pInt = new PInt();
                bek kaVar = new ka();
                try {
                    byte[] a = t.a(bArr, com.tencent.mm.kernel.g.Dp().gRu.hoF.KD().CM(), pInt, kaVar);
                    x.i(l.this.TAG, "decodePrepareResponse aeskey[%s], fileid[%s], clientimgid[%s]", kaVar.vXE, kaVar.vXI, kaVar.vXt);
                    l.this.hDy = kaVar.vXE;
                    x.i(l.this.TAG, "decodePrepareResponse, clientmediaid:%s, ret:%d", str, Integer.valueOf(pInt.value));
                    return a;
                } catch (Exception e) {
                    x.e(l.this.TAG, "decodePrepareResponse Exception:%s", e);
                    l.this.hDy = null;
                    return null;
                }
            }
        };
        this.gNI = false;
        x.i(this.TAG, "dkupimg init uploadsrc:%d from:%s to:%s ori:%s cmptype:%d prog:%s rotate:%d cdn:%s thumb:%s chatt:%b , res:%d run:%b [%s], scene: %d, longtitude: %f, latitude: %f", Integer.valueOf(i), str, str2, str3, Integer.valueOf(i2), fVar, Integer.valueOf(i3), str4, str5, Boolean.valueOf(z), Integer.valueOf(i4), Boolean.valueOf(true), bi.chl(), Integer.valueOf(i5), Float.valueOf(f), Float.valueOf(f2));
        this.hDv = z;
        this.hDc = i4;
        this.hCU = fVar;
        this.hBE = i2;
        this.scene = i5;
        this.fAo = f2;
        this.hDw = f;
        this.gNB = i;
        PString pString = new PString();
        PInt pInt = new PInt();
        PInt pInt2 = new PInt();
        this.hDu = str4;
        pString.value = str5;
        this.hCV = o.PC().a(str3, i2, i, i3, pString, pInt, pInt2);
        this.gNA = this.hCV;
        x.i(this.TAG, "FROM A UI :" + str2 + " " + this.hCV);
        if (this.hCV < 0 || !i.hV((int) this.hCV)) {
            x.e(this.TAG, "insert to img storage failed id:" + this.hCV);
            this.hBI = -1;
            this.gLB = null;
            return;
        }
        e Pq;
        Assert.assertTrue(this.hCV >= 0);
        com.tencent.mm.ad.b.a aVar = new com.tencent.mm.ad.b.a();
        aVar.hnT = new bsg();
        aVar.hnU = new bsh();
        aVar.uri = "/cgi-bin/micromsg-bin/uploadmsgimg";
        aVar.hnS = 110;
        aVar.hnV = 9;
        aVar.hnW = 1000000009;
        this.gLB = aVar.Kf();
        this.fHE = str2;
        this.fou = new au();
        this.fou.setType(s.ht(str2));
        this.fou.dU(str2);
        this.fou.eS(1);
        this.fou.eR(1);
        this.fou.dV(pString.value);
        this.fou.fd(pInt.value);
        this.fou.fe(pInt2.value);
        this.fou.aq(bb.hU(this.fou.field_talker));
        this.fou.setContent(str4);
        com.tencent.mm.i.a.a.xK().b(this.fou);
        this.hBI = ((com.tencent.mm.plugin.messenger.foundation.a.h) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aZO().Q(this.fou);
        Assert.assertTrue(this.hBI >= 0);
        x.i(this.TAG, "NetSceneUploadMsgImg: local msgId = " + this.hBI);
        e Pr = Pr();
        Pr.bg((long) ((int) this.hBI));
        o.PC().a(Long.valueOf(this.hCV), Pr);
        if (i2 == 1) {
            this.gNA = (long) Pr.hBK;
            Pq = Pq();
        } else {
            Pq = Pr;
        }
        Pq.hO(com.tencent.mm.a.e.bN(o.PC().m(Pq.hBB, "", "")));
        o.PC().a(Long.valueOf(this.gNA), Pq);
        x.i(this.TAG, "NetSceneUploadMsgImg: local imgId = " + this.gNA + " img len = " + Pq.hmZ);
        bsg bsg = (bsg) this.gLB.hnQ.hnY;
        bsg.vNM = new bet().Vf(str);
        bsg.vNN = new bet().Vf(str2);
        bsg.vPt = Pq.offset;
        bsg.vPs = Pq.hmZ;
        bsg.nlX = this.fou.getType();
        bsg.wto = i2;
        bsg.wdO = ab.bC(ad.getContext()) ? 1 : 2;
        bsg.wWg = Pq.cPf;
        bsg.vXH = Pq.hBF;
        bsg.xah = pInt2.value;
        bsg.xai = pInt.value;
        a ln = f.ln(str4);
        if (!(ln == null || bi.oN(ln.appId))) {
            bsg.nlV = ln.appId;
            bsg.vMr = ln.mediaTagName;
            bsg.vMt = ln.messageAction;
            bsg.vMs = ln.messageExt;
        }
        x.i(this.TAG, "LINE237 thumb.width:%d,thumb.height:%d", Integer.valueOf(bsg.xah), Integer.valueOf(bsg.xai));
        if (bsg.vXH == 0) {
            bsg.vXH = i == 4 ? 2 : 1;
        }
        x.d(this.TAG, "dkimgsource: %d, forwardtype:%d", Integer.valueOf(Pq.cPf), Integer.valueOf(bsg.vXH));
        if (Pq.offset == 0) {
            this.hCX = new h(110, true, (long) Pq.hmZ);
        }
        long currentTimeMillis = System.currentTimeMillis();
        hY(i2);
        x.d(this.TAG, "hy: create HDThumb using %d ms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        if (fVar != null) {
            final int i6 = Pq.offset;
            final int i7 = Pq.hmZ;
            final f fVar2 = fVar;
            ah.y(new Runnable() {
                public final void run() {
                    fVar2.a(i6, i7, l.this);
                }
            });
        }
    }

    public l(long j, int i, String str, String str2, String str3, int i2, f fVar, int i3, String str4, String str5, int i4) {
        e Pq;
        String str6;
        this.TAG = "MicroMsg.NetSceneUploadMsgImg";
        this.hDo = "";
        this.hDp = "";
        this.hDq = true;
        this.hDs = 16384;
        this.hBE = 0;
        this.fou = null;
        this.hCX = null;
        this.hCY = "";
        this.startTime = 0;
        this.startOffset = -1;
        this.hCZ = 0;
        this.hDt = new b(null);
        this.hDi = /* anonymous class already generated */;
        this.gNI = false;
        x.i(this.TAG, "dkupimg init id:%d uploadsrc:%d from:%s to:%s ori:%s cmptype:%d prog:%s rotate:%d cdn:%s thumb:%s chatt:%b , res:%d run:%b [%s]", Long.valueOf(j), Integer.valueOf(3), str, str2, str3, Integer.valueOf(i2), fVar, Integer.valueOf(i3), str4, str5, Boolean.valueOf(true), Integer.valueOf(i4), Boolean.valueOf(true), bi.chl());
        this.hDv = true;
        this.hDc = i4;
        this.hCU = fVar;
        this.hBE = i2;
        this.gNB = 3;
        PInt pInt = new PInt();
        PInt pInt2 = new PInt();
        this.hDu = str4;
        this.hCV = j;
        this.gNA = this.hCV;
        e Pr = Pr();
        this.fou = ((com.tencent.mm.plugin.messenger.foundation.a.h) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aZO().dI(Pr.hBI);
        this.hBI = this.fou.field_msgId;
        pInt2.value = this.fou.gkF;
        pInt.value = this.fou.gkE;
        if (i2 == 1) {
            this.gNA = (long) Pr.hBK;
            this.gNC = null;
            Pq = Pq();
        } else {
            Pq = Pr;
        }
        if (this.fou.field_talker.equals(str2)) {
            str6 = str2;
        } else {
            x.e(this.TAG, "fatal!! Send user mis-match, want:%s, fact:%s", str2, this.fou.field_talker);
            g.pWK.a(594, 4, 1, true);
            str6 = this.fou.field_talker;
        }
        x.i(this.TAG, "NetSceneUploadMsgImg: local msgId = " + this.fou.field_msgId);
        x.d(this.TAG, "FROM A UI :" + str2 + "   msg:" + str6 + this.hCV);
        if (this.hCV < 0 || !i.hV((int) this.hCV)) {
            x.e(this.TAG, "insert to img storage failed id:" + this.hCV);
            this.hBI = -1;
            this.gLB = null;
            return;
        }
        Assert.assertTrue(this.hCV >= 0);
        com.tencent.mm.ad.b.a aVar = new com.tencent.mm.ad.b.a();
        aVar.hnT = new bsg();
        aVar.hnU = new bsh();
        aVar.uri = "/cgi-bin/micromsg-bin/uploadmsgimg";
        aVar.hnS = 110;
        aVar.hnV = 9;
        aVar.hnW = 1000000009;
        this.gLB = aVar.Kf();
        x.i(this.TAG, "NetSceneUploadMsgImg: local imgId = " + this.gNA + " img len = " + Pq.hmZ);
        bsg bsg = (bsg) this.gLB.hnQ.hnY;
        bsg.vNM = new bet().Vf(str);
        bsg.vNN = new bet().Vf(str6);
        bsg.vPt = Pq.offset;
        bsg.vPs = Pq.hmZ;
        bsg.nlX = this.fou.getType();
        bsg.wto = i2;
        bsg.wdO = ab.bC(ad.getContext()) ? 1 : 2;
        bsg.wWg = Pq.cPf;
        bsg.vXH = Pq.hBF;
        bsg.xah = pInt2.value;
        bsg.xai = pInt.value;
        x.i(this.TAG, "LINE350 thumb.width:%d,thumb.height:%d", Integer.valueOf(bsg.xah), Integer.valueOf(bsg.xai));
        if (bsg.vXH == 0) {
            bsg.vXH = 1;
        }
        x.d(this.TAG, "dkimgsource: %d, forwardtype:%d", Integer.valueOf(Pq.cPf), Integer.valueOf(bsg.vXH));
        if (Pq.offset == 0) {
            this.hCX = new h(110, true, (long) Pq.hmZ);
        }
        if (fVar != null) {
            final int i5 = Pq.offset;
            final int i6 = Pq.hmZ;
            final f fVar2 = fVar;
            ah.y(new Runnable() {
                public final void run() {
                    fVar2.a(i5, i6, l.this);
                }
            });
        }
    }

    public final void hY(int i) {
        int i2 = 0;
        if (this.fou == null) {
            x.w(this.TAG, "createHDThumb but msg is null msgLocalId[%d], compressType[%d]", Long.valueOf(this.hBI), Integer.valueOf(i));
        } else if (!this.hDv) {
            o.PC().a(this.fou.field_imgPath, com.tencent.mm.bu.a.getDensity(ad.getContext()), true);
        } else if (this.fou.gkI == 0) {
            boolean z;
            g PC = o.PC();
            cg cgVar = this.fou;
            int i3 = this.hDc;
            String p = g.p(cgVar);
            if (bi.oN(p)) {
                z = false;
            } else {
                z = PC.a(p, cgVar.field_imgPath, i3, i);
            }
            cgVar = this.fou;
            if (z) {
                i2 = 1;
            }
            cgVar.gkI = i2;
            cgVar.ggu = true;
            ((com.tencent.mm.plugin.messenger.foundation.a.h) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aZO().a(this.hBI, this.fou);
        }
    }

    public l(int i, int i2) {
        this.TAG = "MicroMsg.NetSceneUploadMsgImg";
        this.hDo = "";
        this.hDp = "";
        this.hDq = true;
        this.hDs = 16384;
        this.hBE = 0;
        this.fou = null;
        this.hCX = null;
        this.hCY = "";
        this.startTime = 0;
        this.startOffset = -1;
        this.hCZ = 0;
        this.hDt = new b(null);
        this.hDi = /* anonymous class already generated */;
        this.gNI = false;
        x.i(this.TAG, "dkupimg init id:%d cmptype:%d  [%s]", Integer.valueOf(i), Integer.valueOf(i2), bi.chl());
        this.hCV = (long) i;
        this.gNA = (long) i;
        this.hBE = i2;
        com.tencent.mm.ad.b.a aVar = new com.tencent.mm.ad.b.a();
        aVar.hnT = new bsg();
        aVar.hnU = new bsh();
        aVar.uri = "/cgi-bin/micromsg-bin/uploadmsgimg";
        aVar.hnS = 110;
        aVar.hnV = 9;
        aVar.hnW = 1000000009;
        this.gLB = aVar.Kf();
        this.hCU = null;
        x.d(this.TAG, "FROM B SERVICE:" + this.hCV);
        if (i.hV((int) this.hCV)) {
            e b;
            e b2 = o.PC().b(Long.valueOf(this.hCV));
            this.hBI = b2.hBI;
            if (i2 == 1) {
                this.gNA = (long) b2.hBK;
                b = o.PC().b(Long.valueOf(this.gNA));
            } else {
                b = b2;
            }
            b2 = o.PC().hU((int) b.hBA);
            if (b2 != null) {
                this.hBI = b2.hBI;
            }
            this.fou = ((com.tencent.mm.plugin.messenger.foundation.a.h) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aZO().dI(this.hBI);
            if (this.fou != null && this.fou.field_msgId != this.hBI) {
                x.w(this.TAG, "init get msg by id failed:%d", Long.valueOf(this.hBI));
                g.pWK.a(111, 206, 1, false);
                this.fou = null;
                return;
            } else if (this.fou != null) {
                bsg bsg = (bsg) this.gLB.hnQ.hnY;
                bsg.vNM = new bet().Vf(q.FY());
                bsg.vNN = new bet().Vf(this.fou.field_talker);
                bsg.vPt = b.offset;
                bsg.vPs = b.hmZ;
                bsg.nlX = this.fou.getType();
                bsg.wto = i2;
                bsg.wdO = ab.bC(ad.getContext()) ? 1 : 2;
                bsg.wWg = b.cPf;
                bsg.vXH = b.hBF;
                bsg.vXH = b.hBF;
                bsg.xah = this.fou.gkF;
                bsg.xai = this.fou.gkE;
                x.i(this.TAG, "LINE425 thumb.width:%d,thumb.height:%d", Integer.valueOf(bsg.xah), Integer.valueOf(bsg.xai));
                x.d(this.TAG, "dkimgsource: %d, forwardtype:%d", Integer.valueOf(b.cPf), Integer.valueOf(bsg.vXH));
                if (b.offset == 0) {
                    this.hCX = new h(110, true, (long) b.hmZ);
                    return;
                }
                return;
            } else {
                return;
            }
        }
        this.hCV = -1;
    }

    public l(int i, int i2, byte b) {
        this.TAG = "MicroMsg.NetSceneUploadMsgImg";
        this.hDo = "";
        this.hDp = "";
        this.hDq = true;
        this.hDs = 16384;
        this.hBE = 0;
        this.fou = null;
        this.hCX = null;
        this.hCY = "";
        this.startTime = 0;
        this.startOffset = -1;
        this.hCZ = 0;
        this.hDt = new b(null);
        this.hDi = /* anonymous class already generated */;
        this.gNI = false;
        x.i(this.TAG, "dkupimg init id:%d cmptype:%d pro:%s  [%s]", Integer.valueOf(i), Integer.valueOf(i2), null, bi.chl());
        this.hCV = (long) i;
        this.gNA = (long) i;
        this.hBE = i2;
        com.tencent.mm.ad.b.a aVar = new com.tencent.mm.ad.b.a();
        aVar.hnT = new bsg();
        aVar.hnU = new bsh();
        aVar.uri = "/cgi-bin/micromsg-bin/uploadmsgimg";
        aVar.hnS = 110;
        aVar.hnV = 9;
        aVar.hnW = 1000000009;
        this.gLB = aVar.Kf();
        this.hCU = null;
        x.d(this.TAG, "FROM C SERVICE:" + this.hCV);
        if (i.hV((int) this.hCV)) {
            e b2;
            e b3 = o.PC().b(Long.valueOf(this.hCV));
            this.hBI = b3.hBI;
            b3.eR(0);
            b3.ap(0);
            b3.setOffset(0);
            o.PC().a((int) this.gNA, b3);
            if (i2 == 1) {
                this.gNA = (long) b3.hBK;
                b2 = o.PC().b(Long.valueOf(this.gNA));
            } else {
                b2 = b3;
            }
            this.fou = ((com.tencent.mm.plugin.messenger.foundation.a.h) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aZO().dI(this.hBI);
            if (this.fou != null) {
                this.fou.eR(1);
                String str = b2.hBD;
                if (str == null || !str.startsWith("THUMBNAIL_DIRPATH://")) {
                    this.fou.dV("THUMBNAIL://" + b2.hBA);
                } else {
                    this.fou.dV(str);
                }
                ((com.tencent.mm.plugin.messenger.foundation.a.h) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aZO().a(this.hBI, this.fou);
                bsg bsg = (bsg) this.gLB.hnQ.hnY;
                bsg.vNM = new bet().Vf(q.FY());
                bsg.vNN = new bet().Vf(this.fou.field_talker);
                bsg.vPt = b2.offset;
                bsg.vPs = b2.hmZ;
                bsg.nlX = this.fou.getType();
                bsg.wto = i2;
                bsg.wdO = ab.bC(ad.getContext()) ? 1 : 2;
                bsg.wWg = b2.cPf;
                bsg.vXH = b2.hBF;
                bsg.xah = this.fou.gkF;
                bsg.xai = this.fou.gkE;
                x.i(this.TAG, "LINE492 thumb.width:%d,thumb.height:%d", Integer.valueOf(bsg.xah), Integer.valueOf(bsg.xai));
                x.d(this.TAG, "dkimgsource: %d, forwardtype:%d", Integer.valueOf(b2.cPf), Integer.valueOf(bsg.vXH));
                if (b2.offset == 0) {
                    this.hCX = new h(110, true, (long) b2.hmZ);
                    return;
                }
                return;
            }
            return;
        }
        this.hCV = -1;
    }

    protected final int a(com.tencent.mm.network.q qVar) {
        return b.hoz;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        com.tencent.mm.kernel.g.Dr();
        com.tencent.mm.kernel.g.Dt().g(new Runnable() {
            public final void run() {
                ((com.tencent.mm.plugin.messenger.foundation.a.h) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aZO().Fa("SendImgSpeeder");
            }
        }, 100);
        if (this.gNA < 0) {
            g.pWK.a(111, 204, 1, false);
            x.e(this.TAG, "doScene invalid imgLocalId:" + this.gNA);
            return hZ(-1);
        } else if (this.fou == null) {
            g.pWK.a(111, 203, 1, false);
            x.e(this.TAG, "doScene msg is null imgid:%d", Long.valueOf(this.gNA));
            i.hX((int) this.hCV);
            return hZ(-2);
        } else {
            String HJ;
            this.gLE = eVar2;
            c(eVar);
            bsg bsg = (bsg) this.gLB.hnQ.hnY;
            e Pq = Pq();
            e hU = o.PC().hU((int) Pq.hBA);
            if (hU != null) {
                if (hU.status == -1) {
                    g.pWK.a(111, 202, 1, false);
                    x.e(this.TAG, "doScene hd img info is null or error.");
                    return hZ(-3);
                }
            } else if (Pq == null || Pq.status == -1) {
                x.e(this.TAG, "doScene img info is null or error.");
                return hZ(-4);
            }
            if (com.tencent.mm.i.a.a.xK().eG(this.fou.field_talker)) {
                bsg.vNR = com.tencent.mm.i.a.a.xK().c(this.fou);
            } else {
                HJ = bd.HJ();
                if (!(HJ == null || HJ.equals(this.fou.gkD)) || (HJ == null && !bi.oN(this.fou.gkD))) {
                    this.fou.ea(HJ);
                    ((com.tencent.mm.plugin.messenger.foundation.a.h) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aZO().a(this.fou.field_msgId, this.fou);
                }
                bsg.vNR = this.fou.gkD;
            }
            String m = o.PC().m(Pq.hBB, "", "");
            String m2 = o.PC().m(Pq.hBD, "", "");
            HJ = "";
            if (!bi.oN(Pq.hBC)) {
                HJ = o.PC().m(Pq.hBC, "", "");
            }
            if (com.tencent.mm.a.e.bN(m) <= 0 || com.tencent.mm.a.e.bN(m2) <= 0) {
                x.e(this.TAG, "doScene invalid imgLocalId:%d filesize:[%d,%d] %s %s", Long.valueOf(this.gNA), Integer.valueOf(com.tencent.mm.a.e.bN(m)), Integer.valueOf(com.tencent.mm.a.e.bN(m2)), m, m2);
                return hZ(-5);
            }
            Object obj;
            if (bsg.xaa == null || bi.oN(bsg.xaa.wRo)) {
                if (bi.oN(this.hCY)) {
                    x.i(this.TAG, "createMediaId time:%d talker:%s msg:%d img:%d compressType:%d", Long.valueOf(this.fou.field_createTime), this.fou.field_talker, Long.valueOf(this.fou.field_msgId), Long.valueOf(this.gNA), Integer.valueOf(this.hBE));
                    this.hCY = d.a("upimg", this.fou.field_createTime, this.fou.field_talker, this.fou.field_msgId + "_" + this.gNA + "_" + this.hBE);
                }
                bsg.xaa = new bet().Vf(this.hCY);
                cg cgVar = this.fou;
                cgVar.gkK = this.hCY;
                cgVar.ggu = true;
            }
            if (this.startTime == 0) {
                this.startTime = bi.Wy();
                this.startOffset = Pq.offset;
                this.hCZ = this.hBE == 1 ? com.tencent.mm.modelcdntran.b.MediaType_FULLSIZEIMAGE : com.tencent.mm.modelcdntran.b.MediaType_IMAGE;
            }
            x.i(this.TAG, "before checkUseCdn %s, %s, imgBitPath:%s", m, m2, Pq.hBB);
            if (s.hr(this.fou.field_talker)) {
                x.w(this.TAG, "cdntra not use cdn user:%s", this.fou.field_talker);
                obj = null;
            } else {
                com.tencent.mm.modelcdntran.g.MP();
                if (!com.tencent.mm.modelcdntran.c.hx(1) && bi.oN(Pq.hBL)) {
                    r7 = new Object[2];
                    com.tencent.mm.modelcdntran.g.MP();
                    r7[0] = Boolean.valueOf(com.tencent.mm.modelcdntran.c.hx(1));
                    r7[1] = Pq.hBL;
                    x.w(this.TAG, "cdntra not use cdn flag:%b getCdnInfo:%s", r7);
                    obj = null;
                } else if (bi.oN(this.hCY)) {
                    x.w(this.TAG, "cdntra genClientId failed not use cdn imgLocalId:%d", Long.valueOf(this.gNA));
                    obj = null;
                } else {
                    i iVar = new i();
                    iVar.hve = this.hDi;
                    iVar.field_mediaId = this.hCY;
                    iVar.field_fullpath = m;
                    iVar.field_thumbpath = m2;
                    iVar.field_fileType = this.hCZ;
                    iVar.field_talker = this.fou.field_talker;
                    iVar.field_chattype = s.eX(this.fou.field_talker) ? 1 : 0;
                    iVar.field_priority = com.tencent.mm.modelcdntran.b.htu;
                    iVar.field_needStorage = false;
                    iVar.field_isStreamMedia = false;
                    iVar.field_sendmsg_viacdn = true;
                    iVar.field_enable_hitcheck = this.hDq;
                    iVar.field_midimgpath = HJ;
                    iVar.field_force_aeskeycdn = false;
                    iVar.field_trysafecdn = true;
                    if (iVar.field_fileType == com.tencent.mm.modelcdntran.b.MediaType_FULLSIZEIMAGE && bi.oN(iVar.field_midimgpath)) {
                        com.tencent.mm.modelcdntran.g.MP();
                        if (com.tencent.mm.modelcdntran.c.hx(256)) {
                            x.w(this.TAG, "summersafecdn send fullsizeimage but midimgpath is null set field_force_aeskeycdn true");
                            iVar.field_force_aeskeycdn = true;
                            iVar.field_trysafecdn = false;
                        }
                    }
                    Map y = bj.y(this.hDu, "msg");
                    if (y != null) {
                        if (this.hBE != 1) {
                            iVar.field_fileId = (String) y.get(".msg.img.$cdnmidimgurl");
                            iVar.field_midFileLength = bi.getInt((String) y.get(".msg.img.$length"), 0);
                            iVar.field_totalLen = 0;
                        } else {
                            iVar.field_fileId = (String) y.get(".msg.img.$cdnbigimgurl");
                            iVar.field_midFileLength = bi.getInt((String) y.get(".msg.img.$length"), 0);
                            iVar.field_totalLen = 0;
                        }
                        iVar.field_aesKey = (String) y.get(".msg.img.$aeskey");
                    } else {
                        x.i(this.TAG, "parse cdnInfo failed. [%s]", Pq.hBL);
                    }
                    if (bi.oN(iVar.field_aesKey)) {
                        com.tencent.mm.modelcdntran.g.MQ();
                        iVar.field_aesKey = com.tencent.mm.modelcdntran.b.MI();
                        x.i(this.TAG, "summersafecdn cdntra oldAeskey is null and gen new[%s]", iVar.field_aesKey);
                    }
                    x.i(this.TAG, "dkupimg src:%d fileid:%s", Integer.valueOf(Pq.cPf), iVar.field_fileId);
                    this.hDo = iVar.field_fileId;
                    this.hDp = iVar.field_aesKey;
                    x.d(this.TAG, "summersafecdn checkUseCdn field_enable_hitcheck[%b], field_fileType[%d], field_midimgpath[%s], field_fullpath[%s], aeskey[%s], fileid[%s], enable_hitcheck[%b], aeskeycdn[%b], trysafecdn[%b]", Boolean.valueOf(iVar.field_enable_hitcheck), Integer.valueOf(iVar.field_fileType), iVar.field_midimgpath, iVar.field_fullpath, iVar.field_aesKey, iVar.field_fileId, Boolean.valueOf(iVar.field_enable_hitcheck), Boolean.valueOf(iVar.field_force_aeskeycdn), Boolean.valueOf(iVar.field_trysafecdn));
                    this.hDy = null;
                    if (com.tencent.mm.modelcdntran.g.MP().c(iVar)) {
                        if (bi.oM(Pq.hBL).length() <= 0) {
                            Pq.lm("CDNINFO_SEND");
                            Pq.fEo = Downloads.RECV_BUFFER_SIZE;
                        }
                        obj = 1;
                    } else {
                        g.pWK.a(111, 205, 1, false);
                        x.e(this.TAG, "cdntra addSendTask failed. clientid:%s", this.hCY);
                        this.hCY = "";
                        obj = null;
                    }
                }
            }
            if (obj != null) {
                x.d(this.TAG, "cdntra use cdn return -1 for onGYNetEnd clientid:%s", bsg.xaa.wRo);
                return 0;
            }
            x.i(this.TAG, "after checkUseCdn, it use cgi to upload image.");
            int i = Pq.hBJ;
            if (i >= Bo()) {
                g.pWK.a(111, 201, 1, false);
                x.e(this.TAG, "doScene limit net time:" + i);
                i.hX((int) this.hCV);
                return hZ(-6);
            }
            Pq.hM(i + 1);
            Pq.fEo = WXMediaMessage.TITLE_LENGTH_LIMIT;
            o.PC().a(Long.valueOf(this.gNA), Pq);
            int i2 = Pq.hmZ - Pq.offset;
            if (i2 > this.hDs) {
                i2 = this.hDs;
            }
            if (com.tencent.mm.a.e.bN(m) > 10485760) {
                g.pWK.a(111, 200, 1, false);
                x.e(this.TAG, "doScene, file size is too large");
                return hZ(-7);
            }
            byte[] d = com.tencent.mm.a.e.d(m, Pq.offset, i2);
            if (d == null || d.length <= 0) {
                g.pWK.a(111, 199, 1, false);
                x.e(this.TAG, "doScene, file read buf error.");
                return hZ(-8);
            }
            bsg.vPu = d.length;
            bsg.vPt = Pq.offset;
            bsg.weD = new bes().bl(d);
            if (this.hCX != null) {
                this.hCX.Td();
            }
            int a = a(eVar, this.gLB, this);
            if (a >= 0) {
                return a;
            }
            x.e(this.TAG, "doScene netId error");
            i.hX((int) this.hCV);
            return hZ(-9);
        }
    }

    private int hZ(int i) {
        x.e(this.TAG, "do Scene error code : " + i + " hashcode : " + hashCode());
        if (this.hDt != null) {
            this.hDt.Pp();
        }
        return -1;
    }

    public final int getType() {
        return 110;
    }

    protected final int Bo() {
        if (this.hBE == 0) {
            return 100;
        }
        return 1350;
    }

    public final void a(int i, int i2, int i3, String str, com.tencent.mm.network.q qVar, byte[] bArr) {
        bsh bsh = (bsh) ((com.tencent.mm.ad.b) qVar).hnR.hnY;
        x.i(this.TAG, "cdntra onGYNetEnd errtype:" + i2 + " errcode:" + i3 + " useCdnTransClientId:" + this.hCY);
        if (i2 == 3 && i3 == -1 && !bi.oN(this.hCY)) {
            x.w(this.TAG, "cdntra using cdn trans,  wait cdn service callback! clientid:%s", this.hCY);
        } else if (i2 == 0 && i3 == 0) {
            this.hDs = bsh.vPu;
            if (this.hDs > 16384) {
                this.hDs = 16384;
            }
            e Pq = Pq();
            x.v(this.TAG, "onGYNetEnd localId:" + this.gNA + "  totalLen:" + Pq.hmZ + " offSet:" + Pq.offset);
            if (bsh.vPt < 0 || (bsh.vPt > Pq.hmZ && Pq.hmZ > 0)) {
                g.pWK.a(111, 197, 1, false);
                x.e(this.TAG, "onGYNetEnd invalid server return value : startPos = " + bsh.vPt + " img totalLen = " + Pq.hmZ);
                i.hX((int) this.hCV);
                i.hW((int) this.hCV);
                g.pWK.h(10420, Integer.valueOf(-2), Integer.valueOf(1), Long.valueOf(this.startTime), Long.valueOf(bi.Wy()), Integer.valueOf(d.bi(ad.getContext())), Integer.valueOf(this.hCZ), Integer.valueOf(0));
                this.gLE.a(4, -2, "", this);
                if (this.hDt != null) {
                    this.hDt.Pp();
                }
            } else if (bsh.vPt < Pq.offset || (f.b(Pq) && this.hDs <= 0)) {
                x.e(this.TAG, "onGYNetEnd invalid data startPos = " + bsh.vPt + " totalLen = " + Pq.hmZ + " off:" + Pq.offset);
                i.hX((int) this.hCV);
                i.hW((int) this.hCV);
                this.gLE.a(4, -1, "", this);
                if (this.hDt != null) {
                    this.hDt.Pp();
                }
            } else {
                x.d("ImgInfoLogic", "resp.rImpl.getStartPos() " + bsh.vPt);
                if (a(Pq, bsh.vPt, bsh.vNT, bsh.pgR, null) && a(this.hok, this.gLE) < 0) {
                    i.hW((int) this.hCV);
                    this.gLE.a(3, -1, "", this);
                    if (this.hDt != null) {
                        this.hDt.Pp();
                    }
                }
            }
        } else {
            x.e(this.TAG, "onGYNetEnd failed errtype:" + i2 + " errcode:" + i3);
            g.pWK.a(111, 198, 1, false);
            i.hX((int) this.hCV);
            i.hW((int) this.hCV);
            g.pWK.h(10420, Integer.valueOf(i3), Integer.valueOf(1), Long.valueOf(this.startTime), Long.valueOf(bi.Wy()), Integer.valueOf(d.bi(ad.getContext())), Integer.valueOf(this.hCZ), Integer.valueOf(0));
            this.gLE.a(i2, i3, str, this);
            if (this.hDt != null) {
                this.hDt.Pp();
            }
        }
    }

    public final void Ps() {
        x.i(this.TAG, "send img from system");
        this.gNI = true;
    }

    private boolean a(e eVar, int i, long j, int i2, keep_SceneResult keep_sceneresult) {
        x.d(this.TAG, "cdntra clientid:%s start:%d svrid:%d createtime:%d", this.hCY, Integer.valueOf(i), Long.valueOf(j), Integer.valueOf(i2));
        x.d(this.TAG, "dkmsgid  set svrmsgid %d -> %d", Long.valueOf(j), Integer.valueOf(com.tencent.mm.platformtools.r.ifO));
        if (CdnLogic.kMediaTypeFavoriteBigFile == com.tencent.mm.platformtools.r.ifN && com.tencent.mm.platformtools.r.ifO != 0) {
            j = (long) com.tencent.mm.platformtools.r.ifO;
            com.tencent.mm.platformtools.r.ifO = 0;
        }
        final long j2 = eVar.hBA;
        final int i3 = eVar.hmZ;
        if (this.hCU != null) {
            final int i4 = i;
            ah.y(new Runnable() {
                public final void run() {
                    n Pt = n.Pt();
                    long j = j2;
                    long j2 = (long) i3;
                    long j3 = (long) i4;
                    n.d dVar = Pt.hDH.containsKey(Long.valueOf(j)) ? (n.d) Pt.hDH.get(Long.valueOf(j)) : new n.d();
                    dVar.oJ = j3;
                    dVar.fAH = j2;
                    Pt.hDH.put(Long.valueOf(j), dVar);
                    l.this.hCU.a(i4, i3, l.this);
                }
            });
        }
        eVar.setOffset(i);
        eVar.ap(j);
        if (f.b(eVar) && this.hCV != this.gNA) {
            e b = o.PC().b(Long.valueOf(this.hCV));
            b.ap(j);
            b.hO(eVar.hmZ);
            b.setOffset(eVar.hmZ);
            o.PC().a(Long.valueOf(this.hCV), b);
        }
        if (!f.b(eVar)) {
            return true;
        }
        if (bi.oN(this.hCY)) {
            g.pWK.h(10420, Integer.valueOf(0), Integer.valueOf(1), Long.valueOf(this.startTime), Long.valueOf(bi.Wy()), Integer.valueOf(d.bi(ad.getContext())), Integer.valueOf(this.hCZ), Integer.valueOf(eVar.hmZ - this.startOffset));
        }
        this.fou.eR(2);
        this.fou.ap(j);
        ((com.tencent.mm.plugin.messenger.foundation.a.h) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aZO().a(this.hBI, this.fou);
        if (com.tencent.mm.modelstat.r.hUI != null) {
            com.tencent.mm.modelstat.r.hUI.f(this.fou);
        }
        i.hW((int) this.hCV);
        if (this.hCX != null) {
            this.hCX.bs(0);
        }
        this.gLE.a(0, 0, "", this);
        if (r.hEB != null) {
            r.hEB.a(this.gNA, this.fou, this.gLB, this.gNB, this.gNI, keep_sceneresult);
        }
        if (this.hDt != null) {
            this.hDt.Pp();
        }
        return false;
    }

    public static void bk(long j) {
        hDz = j;
    }

    public static String lr(String str) {
        try {
            if (bi.oN(str)) {
                return str;
            }
            String[] split = str.split(",");
            if (split == null || split.length <= 19) {
                return str;
            }
            StringBuilder stringBuilder = new StringBuilder();
            long j = hDz;
            hDz = -1;
            split[19] = stringBuilder.append(j).toString();
            return bi.d(bi.F(split), ",");
        } catch (Exception e) {
            return str;
        }
    }
}
