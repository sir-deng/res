package com.tencent.mm.ap;

import com.tencent.mm.BuildConfig;
import com.tencent.mm.ad.b;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.f;
import com.tencent.mm.modelcdntran.d;
import com.tencent.mm.modelcdntran.i;
import com.tencent.mm.modelcdntran.i.a;
import com.tencent.mm.modelcdntran.keep_ProgressInfo;
import com.tencent.mm.modelcdntran.keep_SceneResult;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.modelstat.h;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.messenger.foundation.a.a.c.c;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.aea;
import com.tencent.mm.protocal.c.aeb;
import com.tencent.mm.protocal.c.bet;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory.DecodeResultLogger;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory.KVStatHelper;
import com.tencent.mm.sdk.platformtools.MMNativeJpeg;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bj;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.y.s;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.Map;
import junit.framework.Assert;

public final class k extends com.tencent.mm.ad.k implements com.tencent.mm.network.k {
    String TAG;
    au fou;
    private long frh;
    private final b gLB;
    e gLE;
    long gNA;
    private int hBE;
    final f hCU;
    public final long hCV;
    private int hCW;
    private h hCX;
    String hCY;
    int hCZ;
    private String hDa;
    public String hDb;
    int hDc;
    public boolean hDd;
    private int hDe;
    private String hDf;
    private int hDg;
    boolean hDh;
    private a hDi;
    int hmZ;
    private int startOffset;
    long startTime;
    private int token;

    public k(long j, long j2, int i, f fVar) {
        this(j, j2, i, fVar, -1);
    }

    public k(long j, long j2, int i, final f fVar, int i2) {
        e b;
        this.TAG = "MicroMsg.NetSceneGetMsgImg";
        this.hCX = null;
        this.frh = -1;
        this.fou = null;
        this.hCY = "";
        this.startTime = 0;
        this.startOffset = -1;
        this.hCZ = 0;
        this.hDa = "";
        this.hDb = "";
        this.hmZ = 0;
        this.hDc = -1;
        this.hDd = false;
        this.hDe = -1;
        this.hDf = null;
        this.hDg = 0;
        this.token = -1;
        this.hDh = false;
        this.hDi = new a() {
            public final int a(String str, int i, keep_ProgressInfo keep_progressinfo, keep_SceneResult keep_sceneresult, boolean z) {
                g gVar;
                Object[] objArr;
                if (i == -21006) {
                    x.i(k.this.TAG, "cdntra  ERR_CNDCOM_MEDIA_IS_DOWNLOADING clientid:%s", k.this.hCY);
                    return 0;
                } else if (i != 0) {
                    i.hX((int) k.this.hCV);
                    i.hW((int) k.this.hCV);
                    gVar = g.pWK;
                    objArr = new Object[16];
                    objArr[0] = Integer.valueOf(i);
                    objArr[1] = Integer.valueOf(2);
                    objArr[2] = Long.valueOf(k.this.startTime);
                    objArr[3] = Long.valueOf(bi.Wy());
                    objArr[4] = Integer.valueOf(d.bi(ad.getContext()));
                    objArr[5] = Integer.valueOf(k.this.hCZ);
                    objArr[6] = Integer.valueOf(k.this.hmZ);
                    objArr[7] = keep_sceneresult == null ? "" : keep_sceneresult.field_transInfo;
                    objArr[8] = "";
                    objArr[9] = "";
                    objArr[10] = "";
                    objArr[11] = "";
                    objArr[12] = "";
                    objArr[13] = "";
                    objArr[14] = "";
                    objArr[15] = keep_sceneresult == null ? "" : keep_sceneresult.report_Part2;
                    gVar.h(10421, objArr);
                    gVar = g.pWK;
                    objArr = new Object[16];
                    objArr[0] = Integer.valueOf(i);
                    objArr[1] = Integer.valueOf(2);
                    objArr[2] = Long.valueOf(k.this.startTime);
                    objArr[3] = Long.valueOf(bi.Wy());
                    objArr[4] = Integer.valueOf(d.bi(ad.getContext()));
                    objArr[5] = Integer.valueOf(k.this.hCZ);
                    objArr[6] = Integer.valueOf(k.this.hmZ);
                    objArr[7] = keep_sceneresult == null ? "" : keep_sceneresult.field_transInfo;
                    objArr[8] = "";
                    objArr[9] = "";
                    objArr[10] = "";
                    objArr[11] = "";
                    objArr[12] = "";
                    objArr[13] = "";
                    objArr[14] = "";
                    objArr[15] = keep_sceneresult == null ? "" : keep_sceneresult.report_Part2;
                    gVar.h(13937, objArr);
                    k.this.gLE.a(3, i, "", k.this);
                    return 0;
                } else {
                    e b = o.PC().b(Long.valueOf(k.this.gNA));
                    if (keep_progressinfo == null) {
                        if (keep_sceneresult != null) {
                            if (keep_sceneresult.field_retCode != 0) {
                                i.hW((int) k.this.hCV);
                                x.e(k.this.TAG, "cdntra sceneResult.retCode :%d", Integer.valueOf(keep_sceneresult.field_retCode));
                                k.this.gLE.a(3, keep_sceneresult.field_retCode, "", k.this);
                            } else {
                                x.i(k.this.TAG, "cdntra getimg ok. need convert:%b", Boolean.valueOf(keep_sceneresult.field_convert2baseline));
                                if (b.hBE == 1) {
                                    g.pWK.a(198, 26, (long) b.hmZ, false);
                                    g.pWK.a(198, 27, 1, false);
                                    g.pWK.a(198, s.eX(k.this.fou != null ? k.this.fou.field_talker : "") ? 29 : 28, 1, false);
                                } else {
                                    long j;
                                    g.pWK.a(198, 21, (long) b.hmZ, false);
                                    g.pWK.a(198, 22, 1, false);
                                    gVar = g.pWK;
                                    if (s.eX(k.this.fou != null ? k.this.fou.field_talker : "")) {
                                        j = 24;
                                    } else {
                                        j = 23;
                                    }
                                    gVar.a(198, j, 1, false);
                                }
                                if (keep_sceneresult.field_convert2baseline) {
                                    x.i(k.this.TAG, "cdntra need convert2baseline. file:%s", k.this.hDb);
                                    boolean Convert2Baseline = MMNativeJpeg.Convert2Baseline(k.this.hDb, 60);
                                    x.i(k.this.TAG, "convert result:%b", Boolean.valueOf(Convert2Baseline));
                                }
                                if (k.this.hDh) {
                                    k.this.a(b, b.offset, b.offset, 0, null);
                                } else {
                                    k.this.a(b, k.this.hmZ, b.offset, k.this.hmZ - b.offset, null);
                                }
                            }
                            gVar = g.pWK;
                            objArr = new Object[16];
                            objArr[0] = Integer.valueOf(keep_sceneresult.field_retCode);
                            objArr[1] = Integer.valueOf(2);
                            objArr[2] = Long.valueOf(k.this.startTime);
                            objArr[3] = Long.valueOf(bi.Wy());
                            objArr[4] = Integer.valueOf(d.bi(ad.getContext()));
                            objArr[5] = Integer.valueOf(k.this.hCZ);
                            objArr[6] = Integer.valueOf(k.this.hmZ);
                            objArr[7] = keep_sceneresult == null ? "" : keep_sceneresult.field_transInfo;
                            objArr[8] = "";
                            objArr[9] = "";
                            objArr[10] = "";
                            objArr[11] = "";
                            objArr[12] = "";
                            objArr[13] = "";
                            objArr[14] = "";
                            objArr[15] = keep_sceneresult == null ? "" : keep_sceneresult.report_Part2;
                            gVar.h(10421, objArr);
                            if (keep_sceneresult.field_retCode != 0) {
                                gVar = g.pWK;
                                objArr = new Object[16];
                                objArr[0] = Integer.valueOf(keep_sceneresult.field_retCode);
                                objArr[1] = Integer.valueOf(2);
                                objArr[2] = Long.valueOf(k.this.startTime);
                                objArr[3] = Long.valueOf(bi.Wy());
                                objArr[4] = Integer.valueOf(d.bi(ad.getContext()));
                                objArr[5] = Integer.valueOf(k.this.hCZ);
                                objArr[6] = Integer.valueOf(k.this.hmZ);
                                objArr[7] = keep_sceneresult == null ? "" : keep_sceneresult.field_transInfo;
                                objArr[8] = "";
                                objArr[9] = "";
                                objArr[10] = "";
                                objArr[11] = "";
                                objArr[12] = "";
                                objArr[13] = "";
                                objArr[14] = "";
                                objArr[15] = keep_sceneresult == null ? "" : keep_sceneresult.report_Part2;
                                gVar.h(13937, objArr);
                            }
                        }
                        return 0;
                    } else if (keep_progressinfo.field_finishedLength == k.this.hmZ) {
                        x.d(k.this.TAG, "cdntra ignore progress 100%");
                        return 0;
                    } else {
                        k.this.hDh = true;
                        if (!k.this.hDd) {
                            k.this.hDd = keep_progressinfo.field_mtlnotify;
                        }
                        x.i(k.this.TAG, "cdntra progresscallback id:%s finish:%d total:%d,  canshowProgressimg:%b", k.this.hCY, Integer.valueOf(keep_progressinfo.field_finishedLength), Integer.valueOf(keep_progressinfo.field_toltalLength), Boolean.valueOf(k.this.hDd));
                        k.this.a(b, k.this.hmZ, b.offset, keep_progressinfo.field_finishedLength - b.offset, null);
                        return 0;
                    }
                }
            }

            public final void a(String str, ByteArrayOutputStream byteArrayOutputStream) {
            }

            public final byte[] h(String str, byte[] bArr) {
                return null;
            }
        };
        boolean z = j >= 0 && j2 >= 0 && fVar != null;
        Assert.assertTrue(z);
        this.hCU = fVar;
        this.hBE = i;
        this.hCV = j;
        this.gNA = j;
        this.frh = j2;
        this.hDe = i2;
        e b2 = o.PC().b(Long.valueOf(this.gNA));
        if (i == 1) {
            this.gNA = (long) b2.hBK;
            b = o.PC().b(Long.valueOf(this.gNA));
        } else {
            b = b2;
        }
        this.TAG += "[" + this.gNA + "]";
        b.a aVar = new b.a();
        aVar.hnT = new aea();
        aVar.hnU = new aeb();
        aVar.uri = "/cgi-bin/micromsg-bin/getmsgimg";
        aVar.hnS = 109;
        aVar.hnV = 10;
        aVar.hnW = 1000000010;
        this.gLB = aVar.Kf();
        aea aea = (aea) this.gLB.hnQ.hnY;
        this.fou = ((com.tencent.mm.plugin.messenger.foundation.a.h) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aZO().dI(j2);
        aea.vPt = b.offset;
        aea.vPs = b.hmZ;
        x.d(this.TAG, "cdntra offset:%d total:%d stack:[%s]", Integer.valueOf(b.offset), Integer.valueOf(b.hmZ), bi.chl());
        aea.vNT = this.fou.field_msgSvrId;
        aea.vNM = new bet().Vf(this.fou.field_talker);
        aea.vNN = new bet().Vf((String) com.tencent.mm.kernel.g.Dq().Db().get(2, null));
        aea.wto = i;
        if (b.offset == 0) {
            this.hCX = new h(109, false, (long) b.hmZ);
        }
        this.hCW = 8192;
        if (fVar != null) {
            final int i3 = b.offset;
            final int i4 = b.hmZ;
            ah.y(new Runnable() {
                public final void run() {
                    fVar.a(i3, i4, k.this);
                }
            });
        }
    }

    protected final int Bo() {
        if (this.hBE == 0) {
            return 100;
        }
        return BuildConfig.VERSION_CODE;
    }

    protected final int a(q qVar) {
        return b.hoz;
    }

    protected final void cancel() {
        if (!(bi.oN(this.hCY) || com.tencent.mm.modelcdntran.g.MP() == null)) {
            x.d(this.TAG, "cancel recv task");
            com.tencent.mm.modelcdntran.g.MP().kL(this.hCY);
        }
        super.cancel();
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        aea aea = (aea) this.gLB.hnQ.hnY;
        e b = o.PC().b(Long.valueOf(this.gNA));
        if (b.hBA == 0) {
            g.pWK.a(111, 195, 1, false);
            x.e(this.TAG, "doScene id:%d  img:%s", Long.valueOf(this.gNA), b);
            return -1;
        } else if (b.status != 0) {
            g.pWK.a(111, 194, 1, false);
            x.e(this.TAG, "doSceneError, id:%d, status:%d", Long.valueOf(b.hBA), Integer.valueOf(b.status));
            return -1;
        } else {
            Object obj;
            if (b.hBB.startsWith("SERVERID://")) {
                this.hDa = com.tencent.mm.a.g.s(b.hBB.getBytes());
                this.hDb = o.PC().m(this.hDa, null, ".temp");
                b.lj(this.hDa + ".temp");
                o.PC().a(Long.valueOf(this.gNA), b);
            } else {
                this.hDa = b.hBB;
                this.hDb = o.PC().m(this.hDa, null, "");
            }
            x.i(this.TAG, "doscene id:%d comp:%d off:%d total:%d name:%s tmp:%s full:%s", Long.valueOf(b.hBA), Integer.valueOf(this.hBE), Integer.valueOf(b.offset), Integer.valueOf(b.hmZ), r4, this.hDa, this.hDb);
            if (this.startTime == 0) {
                this.startTime = bi.Wy();
                this.startOffset = b.offset;
                this.hCZ = this.hBE == 1 ? com.tencent.mm.modelcdntran.b.MediaType_FULLSIZEIMAGE : com.tencent.mm.modelcdntran.b.MediaType_IMAGE;
            }
            String str = aea.vNM.wRo;
            long j = aea.vNT;
            if (bi.oN(b.hBL)) {
                obj = null;
            } else {
                Map y = bj.y(b.hBL, "msg");
                if (y == null) {
                    x.e(this.TAG, "parse cdnInfo failed. [%s]", b.hBL);
                    obj = null;
                } else {
                    String str2;
                    this.hmZ = 0;
                    if (this.hBE != 1) {
                        str = (String) y.get(".msg.img.$cdnmidimgurl");
                        this.hmZ = bi.getInt((String) y.get(".msg.img.$length"), 0);
                        str2 = str;
                    } else {
                        str = (String) y.get(".msg.img.$cdnbigimgurl");
                        this.hmZ = bi.getInt((String) y.get(".msg.img.$hdlength"), 0);
                        str2 = str;
                    }
                    x.d(this.TAG, "cdntra read xml  comptype:%d totallen:%d url:[%s]", Integer.valueOf(this.hBE), Integer.valueOf(this.hmZ), str2);
                    if (bi.oN(str2)) {
                        x.e(this.TAG, "cdntra get cdnUrlfailed.");
                        obj = null;
                    } else {
                        str = (String) y.get(".msg.img.$aeskey");
                        if (bi.oN(str)) {
                            x.e(this.TAG, "cdntra get aes key failed.");
                            obj = null;
                        } else {
                            this.hCY = d.a("downimg", (long) b.hBH, this.fou.field_talker, this.fou.field_msgId);
                            if (bi.oN(this.hCY)) {
                                x.w(this.TAG, "cdntra genClientId failed not use cdn imgLocalId:%d", Long.valueOf(this.gNA));
                                obj = null;
                            } else {
                                String str3 = (String) y.get(".msg.img.$md5");
                                if (!bi.oN(str3) && (bi.oN((String) y.get(".msg.img.$cdnbigimgurl")) || this.hBE == 1)) {
                                    com.tencent.mm.plugin.n.b.aTs();
                                    String df = com.tencent.mm.plugin.n.b.Fm().df(str3, this.hmZ);
                                    int bN = com.tencent.mm.a.e.bN(df);
                                    int i = this.hmZ - bN;
                                    String str4 = this.TAG;
                                    String str5 = "MediaCheckDuplicationStorage: totallen:%s md5:%s big:%s NOcompress:%s  dup(len:%d path:%s) diffLen:%d to:%s";
                                    Integer[] numArr = new Object[8];
                                    numArr[0] = Integer.valueOf(this.hmZ);
                                    numArr[1] = str3;
                                    numArr[2] = y.get(".msg.img.$cdnbigimgurl");
                                    numArr[3] = Boolean.valueOf(this.hBE == 1);
                                    numArr[4] = Integer.valueOf(bN);
                                    numArr[5] = df;
                                    numArr[6] = Integer.valueOf(i);
                                    numArr[7] = this.hDb;
                                    x.i(str4, str5, numArr);
                                    if (bi.oN(df)) {
                                        this.hDf = str3;
                                        this.hDg = this.hmZ;
                                    } else if (i >= 0 && i <= 16) {
                                        boolean fv = com.tencent.mm.sdk.platformtools.k.fv(df, this.hDb);
                                        x.i(this.TAG, "MediaCheckDuplicationStorage copy dup file now :%s -> %s [%b]", df, this.hDb, Boolean.valueOf(fv));
                                        a(b, this.hmZ, this.hmZ, 0, null);
                                        if (this.fou != null) {
                                            ((com.tencent.mm.plugin.messenger.foundation.a.h) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aZO().a(new c(this.fou.field_talker, "update", this.fou));
                                        }
                                        g.pWK.h(13267, str2, Long.valueOf(this.fou.field_msgSvrId), str3, Long.valueOf(this.fou.field_createTime / 1000), this.fou.field_talker, Integer.valueOf(3), Integer.valueOf(bN));
                                        obj = 1;
                                    }
                                }
                                i iVar = new i();
                                iVar.field_mediaId = this.hCY;
                                iVar.field_fullpath = this.hDb;
                                iVar.field_fileType = this.hCZ;
                                iVar.field_totalLen = this.hmZ;
                                iVar.field_aesKey = str;
                                iVar.field_fileId = str2;
                                iVar.field_priority = com.tencent.mm.modelcdntran.b.htu;
                                iVar.hve = this.hDi;
                                iVar.field_chattype = s.eX(this.fou.field_talker) ? 1 : 0;
                                x.i(this.TAG, "cdnautostart %s %b", "image_" + this.fou.field_msgId, Boolean.valueOf(com.tencent.mm.modelcdntran.g.MP().huj.contains("image_" + this.fou.field_msgId)));
                                if (com.tencent.mm.modelcdntran.g.MP().huj.contains("image_" + this.fou.field_msgId)) {
                                    com.tencent.mm.modelcdntran.g.MP().huj.remove("image_" + this.fou.field_msgId);
                                    iVar.field_autostart = true;
                                } else {
                                    iVar.field_autostart = false;
                                }
                                if (com.tencent.mm.modelcdntran.g.MP().b(iVar, this.hDe)) {
                                    x.d(this.TAG, "add recv task");
                                    obj = 1;
                                } else {
                                    g.pWK.a(111, 196, 1, false);
                                    x.e(this.TAG, "addRecvTask failed :%s", this.hCY);
                                    this.hCY = "";
                                    obj = null;
                                }
                            }
                        }
                    }
                }
            }
            if (obj != null) {
                x.d(this.TAG, "cdntra this img use cdn : %s", this.hCY);
                return 0;
            }
            x.d(this.TAG, "cdntra this img NOT USE CDN: %s", this.hCY);
            b.lm("");
            b.fEo = Downloads.RECV_BUFFER_SIZE;
            o.PC().a(Long.valueOf(this.gNA), b);
            aea.vPt = b.offset;
            aea.vPu = this.hCW;
            aea.vPs = b.hmZ;
            if (this.hCX != null) {
                this.hCX.Td();
            }
            return a(eVar, this.gLB, this);
        }
    }

    public final int getType() {
        return 109;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        if (i2 == 3 && i3 == -1 && !bi.oN(this.hCY)) {
            x.w(this.TAG, "cdntra using cdn trans,  wait cdn service callback! clientid:%s", this.hCY);
        } else if (i2 == 0 && i3 == 0) {
            aeb aeb = (aeb) ((b) qVar).hnR.hnY;
            e b = o.PC().b(Long.valueOf(this.gNA));
            Object obj = null;
            if (aeb.vPu <= 0) {
                x.e(this.TAG, "flood control, malformed data_len");
                obj = -1;
            } else if (aeb.weD == null || aeb.vPu != aeb.weD.wRk) {
                x.e(this.TAG, "flood control, malformed data is null or dataLen not match with data buf length");
                obj = -1;
            } else if (aeb.vPt < 0 || aeb.vPt + aeb.vPu > aeb.vPs) {
                x.e(this.TAG, "flood control, malformed start pos");
                obj = -1;
            } else if (aeb.vPt != b.offset) {
                x.e(this.TAG, "flood control, malformed start_pos");
                obj = -1;
            } else if (aeb.vPs <= 0) {
                x.e(this.TAG, "flood control, malformed total_len");
                obj = -1;
            }
            if (obj != null) {
                g.pWK.a(111, 192, 1, false);
                g.pWK.h(10420, Integer.valueOf(-1), Integer.valueOf(2), Long.valueOf(this.startTime), Long.valueOf(bi.Wy()), Integer.valueOf(d.bi(ad.getContext())), Integer.valueOf(this.hCZ), Integer.valueOf(this.hmZ - this.startOffset));
                this.gLE.a(4, -1, "", this);
                return;
            }
            if (a(b, aeb.vPs, aeb.vPt, aeb.vPu, aeb.weD.wRm.oz) && a(this.hok, this.gLE) < 0) {
                this.gLE.a(3, -1, "", this);
            }
        } else {
            if (i2 == 4) {
                g.pWK.a(111, 193, 1, false);
                g.pWK.h(10420, Integer.valueOf(i3), Integer.valueOf(2), Long.valueOf(this.startTime), Long.valueOf(bi.Wy()), Integer.valueOf(d.bi(ad.getContext())), Integer.valueOf(this.hCZ), Integer.valueOf(this.hmZ - this.startOffset));
            }
            this.gLE.a(i2, i3, str, this);
        }
    }

    private boolean a(final e eVar, int i, int i2, int i3, byte[] bArr) {
        String str;
        boolean z;
        eVar.hO(i);
        eVar.setOffset(i2 + i3);
        this.hCW = i3;
        if (bArr != null) {
            com.tencent.mm.a.e.d(this.hDb, bArr);
        }
        x.d(this.TAG, "onGYNetEnd : offset = " + eVar.offset + " totalLen = " + eVar.hmZ + " stack:[%s]", bi.chl());
        if (eVar.Pj()) {
            String str2 = this.hDb;
            if (str2 == null || str2.equals("")) {
                str2 = "";
            } else {
                byte[] d = com.tencent.mm.a.e.d(str2, 0, 2);
                if (d == null || d.length < 2) {
                    str2 = "";
                } else {
                    str = ".jpg";
                    byte b = d[0];
                    if (b < (byte) 0) {
                        b += 256;
                    }
                    byte b2 = d[1];
                    if (b2 < (byte) 0) {
                        b2 += 256;
                    }
                    str2 = (b == (byte) 66 && b2 == (byte) 77) ? ".bmp" : (b == (byte) -1 && b2 == (byte) -40) ? ".jpg" : (b == (byte) -119 && b2 == (byte) 80) ? ".png" : (b == (byte) 71 && b2 == (byte) 73) ? ".gif" : str;
                }
            }
            DecodeResultLogger decodeResultLogger = new DecodeResultLogger();
            boolean checkIsImageLegal = MMBitmapFactory.checkIsImageLegal(this.hDb, decodeResultLogger);
            File file = new File(this.hDb);
            if (checkIsImageLegal) {
                str = o.PC().m(this.hDa, null, str2);
                x.i(this.TAG, "sceneEndproc ext:%s tmp:%s tmpfull:%s full:%s ", str2, this.hDa, this.hDb, str);
                file.renameTo(new File(str));
                eVar.lj(this.hDa + str2);
                eVar.li(FileOp.mo(str));
                eVar.hS(this.hBE);
                if (o.PC().a(Long.valueOf(this.gNA), eVar) >= 0) {
                    x.e(this.TAG, "onGYNetEnd : update img fail");
                    this.gLE.a(3, -1, "", this);
                    return false;
                }
                if (this.hCU != null) {
                    ah.y(new Runnable() {
                        public final void run() {
                            k.this.hCU.a(eVar.offset, eVar.hmZ, k.this);
                        }
                    });
                }
                x.d(this.TAG, "cdntra check iscompleted :%b clientid:%s", Boolean.valueOf(eVar.Pj()), this.hCY);
                if (eVar.Pj()) {
                    return true;
                }
                if (bi.oN(this.hCY)) {
                    g.pWK.h(10420, Integer.valueOf(0), Integer.valueOf(2), Long.valueOf(this.startTime), Long.valueOf(bi.Wy()), Integer.valueOf(d.bi(ad.getContext())), Integer.valueOf(this.hCZ), Integer.valueOf(i - this.startOffset));
                }
                z = false;
                if (this.hDc > 0) {
                    z = o.PC().a(str, eVar.hBD, this.hDc, 1);
                }
                if (z) {
                    eVar.gkI = 1;
                    eVar.hCb = true;
                    ((com.tencent.mm.plugin.messenger.foundation.a.h) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aZO().a(this.fou.field_msgId, this.fou);
                }
                o.PC().a(Long.valueOf(this.gNA), eVar);
                x.d(this.TAG, "cdntra ext:%s %s %s  MediaCheckDuplicationStorage md5:%s", this.hDb, str, eVar.hBB, this.hDf);
                if (this.hCX != null) {
                    this.hCX.bs((long) eVar.hmZ);
                }
                if (!bi.oN(this.hDf) && this.hDg > 0) {
                    com.tencent.mm.plugin.n.b.aTs();
                    com.tencent.mm.plugin.n.b.Fm().z(this.hDf, this.hDg, str);
                }
                this.gLE.a(0, 0, "", this);
                return false;
            }
            file.delete();
            if (decodeResultLogger.getDecodeResult() >= MMBitmapFactory.ERROR_IMG_BUG_DETECTED_BEGIN) {
                g.pWK.k(12712, KVStatHelper.getKVStatString(this.hDb, 2, decodeResultLogger));
            }
        }
        str = null;
        if (o.PC().a(Long.valueOf(this.gNA), eVar) >= 0) {
            if (this.hCU != null) {
                ah.y(/* anonymous class already generated */);
            }
            x.d(this.TAG, "cdntra check iscompleted :%b clientid:%s", Boolean.valueOf(eVar.Pj()), this.hCY);
            if (eVar.Pj()) {
                return true;
            }
            if (bi.oN(this.hCY)) {
                g.pWK.h(10420, Integer.valueOf(0), Integer.valueOf(2), Long.valueOf(this.startTime), Long.valueOf(bi.Wy()), Integer.valueOf(d.bi(ad.getContext())), Integer.valueOf(this.hCZ), Integer.valueOf(i - this.startOffset));
            }
            z = false;
            if (this.hDc > 0) {
                z = o.PC().a(str, eVar.hBD, this.hDc, 1);
            }
            if (z) {
                eVar.gkI = 1;
                eVar.hCb = true;
                ((com.tencent.mm.plugin.messenger.foundation.a.h) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aZO().a(this.fou.field_msgId, this.fou);
            }
            o.PC().a(Long.valueOf(this.gNA), eVar);
            x.d(this.TAG, "cdntra ext:%s %s %s  MediaCheckDuplicationStorage md5:%s", this.hDb, str, eVar.hBB, this.hDf);
            if (this.hCX != null) {
                this.hCX.bs((long) eVar.hmZ);
            }
            com.tencent.mm.plugin.n.b.aTs();
            com.tencent.mm.plugin.n.b.Fm().z(this.hDf, this.hDg, str);
            this.gLE.a(0, 0, "", this);
            return false;
        }
        x.e(this.TAG, "onGYNetEnd : update img fail");
        this.gLE.a(3, -1, "", this);
        return false;
    }
}
