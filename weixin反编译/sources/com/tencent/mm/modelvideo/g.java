package com.tencent.mm.modelvideo;

import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory.Options;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.mm.a.h;
import com.tencent.mm.ad.b;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.hardcoder.HardCoderJNI;
import com.tencent.mm.modelcdntran.d;
import com.tencent.mm.modelcdntran.i;
import com.tencent.mm.modelcdntran.i.a;
import com.tencent.mm.modelcdntran.keep_ProgressInfo;
import com.tencent.mm.modelcdntran.keep_SceneResult;
import com.tencent.mm.network.ab;
import com.tencent.mm.network.q;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.plugin.a.c;
import com.tencent.mm.plugin.appbrand.jsapi.g.f;
import com.tencent.mm.protocal.c.bes;
import com.tencent.mm.protocal.c.bnp;
import com.tencent.mm.protocal.c.bso;
import com.tencent.mm.protocal.c.bsp;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bj;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.bd;
import com.tencent.mm.y.s;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;
import java.util.Vector;
import junit.framework.Assert;

public final class g extends k implements com.tencent.mm.network.k {
    private static int hWa = 32000;
    private final int MAX_TIMES;
    private String fIf = "";
    String fileName;
    private b gLB;
    private e gLE;
    private String hCY = "";
    private a hDi = new a() {
        public final int a(String str, int i, keep_ProgressInfo keep_progressinfo, final keep_SceneResult keep_sceneresult, boolean z) {
            x.d("MicroMsg.NetSceneUploadVideo", "%s cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", g.this.TS(), g.this.hCY, Integer.valueOf(i), keep_progressinfo, keep_sceneresult);
            if (i == -21005) {
                x.d("MicroMsg.NetSceneUploadVideo", "cdntra  ERR_CNDCOM_MEDIA_IS_UPLOADING clientid:%s", g.this.hCY);
                return 0;
            } else if (i != 0) {
                t.nC(g.this.fileName);
                com.tencent.mm.plugin.report.service.g.pWK.h(10421, Integer.valueOf(i), Integer.valueOf(1), Long.valueOf(g.this.startTime), Long.valueOf(bi.Wy()), Integer.valueOf(d.bi(ad.getContext())), Integer.valueOf(g.this.hVH), Integer.valueOf(0), "");
                g.this.gLE.a(3, i, "", g.this);
                return 0;
            } else {
                g.this.hVF = t.nJ(g.this.fileName);
                int i2;
                if (g.this.hVF == null || g.this.hVF.status == 105) {
                    x.i("MicroMsg.NetSceneUploadVideo", "%s info is null or has paused, status:%d", g.this.TS(), Integer.valueOf(g.this.hVF == null ? -1 : g.this.hVF.status));
                    com.tencent.mm.modelcdntran.g.MP().kK(g.this.hCY);
                    g.this.gLE.a(3, i, "info is null or has paused, status" + i2, g.this);
                    return 0;
                } else if (keep_progressinfo == null) {
                    if (keep_sceneresult != null) {
                        if (keep_sceneresult.field_retCode != 0) {
                            x.e("MicroMsg.NetSceneUploadVideo", "%s cdntra sceneResult.retCode :%d arg[%s] info[%s]", g.this.TS(), Integer.valueOf(keep_sceneresult.field_retCode), keep_sceneresult.field_arg, keep_sceneresult.field_transInfo);
                            t.nC(g.this.fileName);
                            com.tencent.mm.plugin.report.service.g.pWK.h(10421, Integer.valueOf(keep_sceneresult.field_retCode), Integer.valueOf(1), Long.valueOf(g.this.startTime), Long.valueOf(bi.Wy()), Integer.valueOf(d.bi(ad.getContext())), Integer.valueOf(g.this.hVH), Integer.valueOf(keep_sceneresult.field_fileLength), keep_sceneresult.field_transInfo, "", "", "", "", "", "", "", keep_sceneresult.report_Part2);
                            com.tencent.mm.plugin.report.service.g.pWK.h(13937, Integer.valueOf(keep_sceneresult.field_retCode), Integer.valueOf(1), Long.valueOf(g.this.startTime), Long.valueOf(bi.Wy()), Integer.valueOf(d.bi(ad.getContext())), Integer.valueOf(g.this.hVH), Integer.valueOf(keep_sceneresult.field_fileLength), keep_sceneresult.field_transInfo, "", "", "", "", "", "", "", keep_sceneresult.report_Part2);
                            g.this.gLE.a(3, keep_sceneresult.field_retCode, "", g.this);
                        } else {
                            x.i("MicroMsg.NetSceneUploadVideo", "%s summersafecdn uploadvideo by cdn, videohash isHitCacheUpload: %d, enableHitcheck:%b", g.this.TS(), Integer.valueOf(keep_sceneresult.field_UploadHitCacheType), Boolean.valueOf(g.this.hDq));
                            com.tencent.mm.plugin.report.service.g gVar = com.tencent.mm.plugin.report.service.g.pWK;
                            Object[] objArr = new Object[2];
                            i2 = g.this.hWf ? 810 : g.this.hWe ? 820 : 830;
                            objArr[0] = Integer.valueOf(i2 + keep_sceneresult.field_UploadHitCacheType);
                            objArr[1] = Integer.valueOf(g.this.hVF.hmZ);
                            gVar.h(12696, objArr);
                            boolean z2 = keep_sceneresult.field_isVideoReduced;
                            x.i("MicroMsg.NetSceneUploadVideo", "%s it video was reduced by cdn %b %s", g.this.TS(), Boolean.valueOf(z2), g.this.fileName);
                            if (z2) {
                                com.tencent.mm.plugin.report.service.g.pWK.a(106, 200, 1, false);
                            } else {
                                com.tencent.mm.plugin.report.service.g.pWK.a(106, 205, 1, false);
                                if (g.this.hWg > 0 && keep_sceneresult.field_thumbimgLength > 0) {
                                    x.i("MicroMsg.NetSceneUploadVideo", "%s send video thumb too big thumb length [%d, %d] ", g.this.TS(), Integer.valueOf(g.this.hWg), Integer.valueOf(keep_sceneresult.field_thumbimgLength));
                                    if (g.this.hWg * 2 > keep_sceneresult.field_thumbimgLength) {
                                        com.tencent.mm.plugin.report.service.g.pWK.a(106, 206, 1, false);
                                    } else {
                                        com.tencent.mm.plugin.report.service.g.pWK.a(106, 207, 1, false);
                                    }
                                }
                                o.Ub();
                                x.i("MicroMsg.NetSceneUploadVideo", "%s send video too big thumb length [%d, %d] ", g.this.TS(), Integer.valueOf(g.this.hVF.hmZ), Integer.valueOf(com.tencent.mm.a.e.bN(s.nx(g.this.fileName))));
                                if (g.this.hVF.hmZ != com.tencent.mm.a.e.bN(s.nx(g.this.fileName))) {
                                    com.tencent.mm.plugin.report.service.g.pWK.a(106, 208, 1, false);
                                } else {
                                    com.tencent.mm.plugin.report.service.g.pWK.a(106, 209, 1, false);
                                }
                            }
                            g.this.hVF = t.nJ(g.this.fileName);
                            if (bi.oN(g.this.hVF.Un())) {
                                x.i("MicroMsg.NetSceneUploadVideo", "%s cdn callback new build cdnInfo:%s", g.this.TS(), ((("<msg><videomsg aeskey=\"" + keep_sceneresult.field_aesKey + "\" cdnthumbaeskey=\"" + keep_sceneresult.field_aesKey + "\" cdnvideourl=\"" + keep_sceneresult.field_fileId + "\" ") + "cdnthumburl=\"" + keep_sceneresult.field_fileId + "\" ") + "length=\"" + keep_sceneresult.field_fileLength + "\" ") + "cdnthumblength=\"" + keep_sceneresult.field_thumbimgLength + "\"/></msg>");
                                g.this.hVF.hXB = r0;
                                t.e(g.this.hVF);
                            }
                            Map y = bj.y(g.this.hVF.Un(), "msg");
                            if (y != null) {
                                s Ub = o.Ub();
                                o.Ub();
                                boolean p = Ub.p(s.nx(g.this.fileName), (String) y.get(".msg.videomsg.$cdnvideourl"), (String) y.get(".msg.videomsg.$aeskey"));
                                gVar = com.tencent.mm.plugin.report.service.g.pWK;
                                objArr = new Object[2];
                                objArr[0] = Integer.valueOf((p ? 1 : 2) + 900);
                                objArr[1] = Integer.valueOf(g.this.hVF.hmZ);
                                gVar.h(12696, objArr);
                            }
                            com.tencent.mm.kernel.g.CN().a(new h(g.this.fileName, z2 ? 0 : g.l(g.this), keep_sceneresult, new a() {
                                public final void bn(int i, int i2) {
                                    if (i == 4 && i2 == 102) {
                                        com.tencent.mm.kernel.g.Dt().F(new Runnable() {
                                            public final void run() {
                                                g.this.hDq = false;
                                                g.this.hVF.status = 104;
                                                g.this.hVF.hXs = bi.Wx();
                                                g.this.hVF.hXt = bi.Wx();
                                                g.this.hVF.hWd = 0;
                                                g.this.hVF.fEo = 1800;
                                                boolean e = t.e(g.this.hVF);
                                                x.i("MicroMsg.NetSceneUploadVideo", "%s summersafecdn MM_ERR_GET_AESKEY_FAILED doScene again enableHitcheck[%b], ret[%b] new createtime:%d", g.this.TS(), Boolean.valueOf(g.this.hDq), Boolean.valueOf(e), Long.valueOf(g.this.hVF.hXs));
                                                g.this.a(g.this.hok, g.this.gLE);
                                            }
                                        });
                                        return;
                                    }
                                    com.tencent.mm.plugin.report.service.g.pWK.h(10421, Integer.valueOf(i2), Integer.valueOf(1), Long.valueOf(g.this.startTime), Long.valueOf(bi.Wy()), Integer.valueOf(d.bi(ad.getContext())), Integer.valueOf(g.this.hVH), Integer.valueOf(keep_sceneresult.field_fileLength), keep_sceneresult.field_transInfo, "", "", "", "", "", "", "", keep_sceneresult.report_Part2);
                                    a.a(g.this.hVF, 0);
                                    g.a(g.this, keep_sceneresult);
                                    g.this.gLE.a(i, i2, "", g.this);
                                }
                            }), 0);
                        }
                    }
                    return 0;
                } else if (g.this.hVF.hWd > keep_progressinfo.field_finishedLength) {
                    x.w("MicroMsg.NetSceneUploadVideo", "%s cdntra cdnEndProc error oldpos:%d newpos:%d", g.this.TS(), Integer.valueOf(g.this.hVF.hWd), Integer.valueOf(keep_progressinfo.field_finishedLength));
                    return 0;
                } else {
                    g.this.hVF.hXt = bi.Wx();
                    g.this.hVF.hWd = keep_progressinfo.field_finishedLength;
                    g.this.hVF.fEo = 1032;
                    t.e(g.this.hVF);
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
    private boolean hDq = true;
    com.tencent.mm.compatible.util.g.a hGM = null;
    private r hVF;
    private int hVH = com.tencent.mm.modelcdntran.b.MediaType_VIDEO;
    private boolean hVI = false;
    private final long hWb = 1800000;
    boolean hWc = false;
    private int hWd = -1;
    private boolean hWe = false;
    private boolean hWf = false;
    private int hWg = 0;
    private int hWh = 0;
    int hWi = 0;
    al hmy = new al(new al.a() {
        public final boolean uG() {
            if (g.this.a(g.this.hok, g.this.gLE) == -1) {
                g.this.retCode = 0 - (com.tencent.mm.compatible.util.g.getLine() + 10000);
                g.this.gLE.a(3, -1, "doScene failed", g.this);
            }
            return false;
        }
    }, true);
    int retCode = 0;
    private long startTime = 0;

    static /* synthetic */ void a(g gVar, keep_SceneResult keep_sceneresult) {
        n TZ = n.TZ();
        o.Ub();
        TZ.a(keep_sceneresult, s.nx(gVar.fileName));
    }

    static /* synthetic */ int l(g gVar) {
        o.Ub();
        String nx = s.nx(gVar.hVF.getFileName());
        if (c.oQ(nx)) {
            int i;
            com.tencent.mm.plugin.a.b bVar = new com.tencent.mm.plugin.a.b();
            long oP = bVar.oP(nx);
            long j = bVar.igY;
            if (oP >= HardCoderJNI.ACTION_NET_RX || oP <= 0 || gVar.hVF.hXv <= 5 || bVar.igZ <= 0 || j <= 0) {
                i = 0;
            } else {
                i = ((int) j) + ((int) ((bVar.igZ * 5) / ((long) gVar.hVF.hXv)));
                if (i <= WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT) {
                    i += WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT;
                }
            }
            x.i("MicroMsg.NetSceneUploadVideo", "%s check preload length[%d] moovPos[%d %d] duration[%d] filelen[%d]", gVar.TS(), Integer.valueOf(i), Long.valueOf(oP), Long.valueOf(j), Integer.valueOf(gVar.hVF.hXv), Long.valueOf(bVar.igZ));
            return i;
        }
        x.w("MicroMsg.NetSceneUploadVideo", "%s check preload length but it not mp4.", gVar.TS());
        return 0;
    }

    protected final void cancel() {
        x.i("MicroMsg.NetSceneUploadVideo", "%s stop %s", TS(), this.hCY);
        if (!bi.oN(this.hCY)) {
            com.tencent.mm.modelcdntran.g.MP().kK(this.hCY);
        }
        this.hVI = true;
        super.cancel();
    }

    private boolean TR() {
        if (s.hr(this.hVF.Uk())) {
            x.w("MicroMsg.NetSceneUploadVideo", "%s cdntra not use cdn user:%s", TS(), this.hVF.Uk());
            return false;
        }
        com.tencent.mm.modelcdntran.g.MP();
        if (com.tencent.mm.modelcdntran.c.hx(2) || this.hVF.hXA == 1) {
            this.hCY = d.a("upvideo", this.hVF.hXs, this.hVF.Uk(), this.hVF.getFileName());
            if (bi.oN(this.hCY)) {
                x.w("MicroMsg.NetSceneUploadVideo", "%s cdntra genClientId failed not use cdn file:%s", TS(), this.hVF.getFileName());
                return false;
            }
            o.Ub();
            String ny = s.ny(this.fileName);
            o.Ub();
            String nx = s.nx(this.fileName);
            i iVar = new i();
            iVar.hve = this.hDi;
            iVar.field_mediaId = this.hCY;
            iVar.field_fullpath = nx;
            iVar.field_thumbpath = nn(ny);
            iVar.field_fileType = com.tencent.mm.modelcdntran.b.MediaType_VIDEO;
            iVar.field_enable_hitcheck = this.hDq;
            iVar.field_largesvideo = com.tencent.mm.modelcontrol.d.Na().kP(nx);
            if (this.hVF != null && 3 == this.hVF.hXC) {
                iVar.field_smallVideoFlag = 1;
            }
            String str = "MicroMsg.NetSceneUploadVideo";
            String str2 = "%s upload video MMSightExtInfo is null? %b %s";
            Object[] objArr = new Object[3];
            objArr[0] = TS();
            objArr[1] = Boolean.valueOf(this.hVF.hXF == null);
            objArr[2] = this.fileName;
            x.i(str, str2, objArr);
            if (this.hVF.hXF != null && this.hVF.hXF.wEa) {
                x.i("MicroMsg.NetSceneUploadVideo", "%s local capture video, mark use large video", TS());
                o.Ub();
                n.TZ().a("", s.nx(this.fileName), this.hVF.Uk(), "", "", 2, 2);
                iVar.field_largesvideo = true;
            }
            str = "MicroMsg.NetSceneUploadVideo";
            str2 = "%s checkAD file:%s adinfo:%s";
            objArr = new Object[3];
            objArr[0] = TS();
            objArr[1] = this.hVF.getFileName();
            objArr[2] = this.hVF.hXE == null ? "null" : this.hVF.hXE.hff;
            x.i(str, str2, objArr);
            if (!(this.hVF.hXE == null || bi.oN(this.hVF.hXE.hff))) {
                iVar.field_advideoflag = 1;
            }
            iVar.field_talker = this.hVF.Uk();
            iVar.field_chattype = s.eX(this.hVF.Uk()) ? 1 : 0;
            iVar.field_priority = com.tencent.mm.modelcdntran.b.htu;
            iVar.field_needStorage = false;
            iVar.field_isStreamMedia = false;
            iVar.field_trysafecdn = true;
            this.hWh = com.tencent.mm.a.e.bN(iVar.field_fullpath);
            this.hWg = com.tencent.mm.a.e.bN(iVar.field_thumbpath);
            if (this.hWg >= com.tencent.mm.modelcdntran.b.htQ) {
                x.w("MicroMsg.NetSceneUploadVideo", "%s cdntra thumb[%s][%d] Too Big Not Use CDN TRANS", TS(), iVar.field_thumbpath, Integer.valueOf(this.hWg));
                return false;
            }
            int i;
            Map y = bj.y(this.hVF.Un(), "msg");
            if (y != null) {
                iVar.field_fileId = (String) y.get(".msg.videomsg.$cdnvideourl");
                iVar.field_aesKey = (String) y.get(".msg.videomsg.$aeskey");
                this.hWf = true;
            } else {
                x.i("MicroMsg.NetSceneUploadVideo", "%s cdntra parse video recv xml failed", TS());
                try {
                    boolean z;
                    boolean z2;
                    boolean z3;
                    String[] split;
                    String[] split2 = bi.oM(((com.tencent.mm.plugin.zero.b.a) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.zero.b.a.class)).Af().getValue("UseVideoHash")).split(",");
                    com.tencent.mm.kernel.g.Dr();
                    com.tencent.mm.kernel.g.Do();
                    int aJ = h.aJ(com.tencent.mm.kernel.a.Cn(), 100);
                    boolean z4 = (split2 == null || split2.length <= 0) ? false : bi.getInt(split2[0], 0) >= aJ;
                    boolean z5 = (split2 == null || split2.length < 2) ? false : bi.getInt(split2[1], 0) >= aJ;
                    boolean z6 = (split2 == null || split2.length < 3) ? false : bi.getInt(split2[2], 0) >= aJ;
                    if (com.tencent.mm.sdk.a.b.cfx()) {
                        z = true;
                        z2 = true;
                        z3 = true;
                    } else {
                        z = z5;
                        z2 = z4;
                        z3 = z6;
                    }
                    if (z2) {
                        s Ub = o.Ub();
                        x.i("MicroMsg.VideoInfoStorage", "checkVideoHash in fullCheckRatio:%s path:%s stack:%s", Integer.valueOf(bi.getInt(split2[2], 0)), nx, bi.chl());
                        long Wy = bi.Wy();
                        if (bi.oN(nx)) {
                            x.e("MicroMsg.VideoInfoStorage", "checkVideoHash failed , path:%s ", nx);
                            ny = "";
                        } else {
                            int[] nA = s.nA(nx);
                            if (nA == null || nA.length < 33) {
                                x.e("MicroMsg.VideoInfoStorage", "checkVideoHash  readHash failed :%s", nx);
                                ny = "";
                            } else {
                                int i2;
                                Ub.hiZ.fD("VideoHash", "delete from VideoHash where CreateTime < " + (bi.Wx() - 432000));
                                int i3 = nA[32];
                                StringBuffer stringBuffer = new StringBuffer();
                                for (i = 0; i < 32; i++) {
                                    stringBuffer.append(Integer.toHexString(nA[i]));
                                }
                                int length = stringBuffer.length();
                                Vector vector = new Vector();
                                Vector vector2 = new Vector();
                                Vector vector3 = new Vector();
                                Vector vector4 = new Vector();
                                int i4 = -1;
                                Cursor a = Ub.hiZ.a("select size, CreateTime, hash, cdnxml, orgpath from VideoHash where size = " + i3, null, 0);
                                while (a.moveToNext()) {
                                    long j = a.getLong(1);
                                    String string = a.getString(2);
                                    String string2 = a.getString(3);
                                    String string3 = a.getString(4);
                                    x.v("MicroMsg.VideoInfoStorage", "checkVideoHash select [%s][%s]", string, string2);
                                    if (bi.oN(string) || bi.oN(string2)) {
                                        com.tencent.mm.plugin.report.service.g.pWK.h(12696, Integer.valueOf(104), Integer.valueOf(i3));
                                        x.w("MicroMsg.VideoInfoStorage", "checkVideoHash select error [%s][%s]", string, string2);
                                    } else if (length != string.length()) {
                                        com.tencent.mm.plugin.report.service.g.pWK.h(12696, Integer.valueOf(105), Integer.valueOf(i3));
                                        x.w("MicroMsg.VideoInfoStorage", "checkVideoHash err length file:%d cursor:%d", Integer.valueOf(length), Integer.valueOf(string.length()));
                                    } else {
                                        i2 = 0;
                                        i = 0;
                                        while (true) {
                                            aJ = i;
                                            if (aJ >= length) {
                                                break;
                                            }
                                            if (stringBuffer.charAt(aJ) == string.charAt(aJ)) {
                                                i = i2 + 1;
                                            } else {
                                                i = i2;
                                            }
                                            i2 = aJ + 1;
                                            aJ = i2;
                                        }
                                        if (i4 < 0 || vector3.size() <= i4 || ((Integer) vector3.get(i4)).intValue() < i2) {
                                            i = vector3.size();
                                        } else {
                                            i = i4;
                                        }
                                        vector3.add(Integer.valueOf(i2));
                                        vector.add(string2);
                                        vector2.add(string3);
                                        vector4.add(Long.valueOf(j));
                                        x.d("MicroMsg.VideoInfoStorage", "checkVideoHash cursor hitCount:%d/%d ,max:%d vector:%d/%d", Integer.valueOf(i2), Integer.valueOf(length), vector3.get(i), Integer.valueOf(i), Integer.valueOf(vector3.size()));
                                        i4 = i;
                                    }
                                }
                                a.close();
                                if (i4 < 0 || vector3.size() <= 0) {
                                    com.tencent.mm.plugin.report.service.g.pWK.h(12696, Integer.valueOf(201), Integer.valueOf(i3));
                                    x.w("MicroMsg.VideoInfoStorage", "checkVideoHash cursor empty maxHitIndex:%d vector:%d", Integer.valueOf(i4), Integer.valueOf(vector3.size()));
                                    ny = "";
                                } else {
                                    int intValue = ((Integer) vector3.get(i4)).intValue();
                                    length = (intValue * 100) / 256;
                                    if (length < 77) {
                                        com.tencent.mm.plugin.report.service.g.pWK.h(12696, Integer.valueOf(202), Integer.valueOf(i3), Integer.valueOf(intValue), Integer.valueOf(0), Integer.valueOf(vector4.size()));
                                        x.w("MicroMsg.VideoInfoStorage", "checkVideoHash NotEnoughHit. time:%d hit:%d percentMatch:%s arr:%d path:%s", Long.valueOf(bi.bA(Wy)), Integer.valueOf(intValue), Integer.valueOf(length), Integer.valueOf(nA.length - 1), nx);
                                        ny = "";
                                    } else {
                                        str2 = bi.oM((String) vector.get(i4));
                                        i2 = 0;
                                        i = 0;
                                        while (true) {
                                            int i5 = i;
                                            if (i5 >= vector3.size()) {
                                                break;
                                            }
                                            if (i5 == i4 || ((Integer) vector3.get(i5)).intValue() < intValue || str2.hashCode() == ((String) vector.get(i5)).hashCode()) {
                                                i = i2;
                                            } else {
                                                i = i2 + 1;
                                            }
                                            i2 = i5 + 1;
                                            i5 = i2;
                                        }
                                        if (i2 > 0) {
                                            Ub.hiZ.fD("VideoHash", "delete from VideoHash where size = " + i3);
                                            com.tencent.mm.plugin.report.service.g.pWK.h(12696, Integer.valueOf(203), Integer.valueOf(i3), Integer.valueOf(intValue), Integer.valueOf(0), Integer.valueOf(vector4.size()), Integer.valueOf(0), "", "", "", Integer.valueOf(i2));
                                            x.e("MicroMsg.VideoInfoStorage", "checkVideoHash Not ONE hash hit this path, give up duplicate:%s path:%s", Integer.valueOf(i2), nx);
                                            ny = "";
                                        } else {
                                            Wy = bi.bA(Wy);
                                            long a2 = bi.a((Long) vector4.get(i4), 0);
                                            com.tencent.mm.plugin.report.service.g.pWK.h(12696, (Object[]) new Object[]{Integer.valueOf(300), String.format("%s,%s,%s,%s,%s", new Object[]{Integer.valueOf(i3), Integer.valueOf(intValue), Long.valueOf(a2), Integer.valueOf(vector4.size()), Long.valueOf(Wy)})});
                                            com.tencent.mm.plugin.report.service.g.pWK.h(12696, (Object[]) new Object[]{Integer.valueOf(length + 3000), r5});
                                            x.i("MicroMsg.VideoInfoStorage", "checkVideoHash Succ time:%s hit:%s match:%s%% savetime:%s path:%s xml:%s orgpath:%s", Long.valueOf(Wy), Integer.valueOf(intValue), Integer.valueOf(length), Long.valueOf(a2), nx, str2, vector2.get(i4));
                                            ny = (String) vector2.get(i4);
                                            z4 = bi.Wy() % 1000 < ((long) (r14 * 10)) || length < 90;
                                            x.i("MicroMsg.VideoInfoStorage", "checkVideoHashByteDiff should:%s now:%s ratio:%s percentMatch:%s debuger:%s", Boolean.valueOf(z4), Long.valueOf(Wy), Integer.valueOf(r14), Integer.valueOf(length), Boolean.valueOf(com.tencent.mm.sdk.a.b.cfx()));
                                            if (z4 || com.tencent.mm.sdk.a.b.cfx()) {
                                                com.tencent.mm.sdk.f.e.b(new com.tencent.mm.modelvideo.s.AnonymousClass2(nx, ny, r5), "checkVideoHashByteDiff", 1);
                                            }
                                            ny = str2;
                                        }
                                    }
                                }
                            }
                        }
                        if (!bi.oN(ny)) {
                            split = ny.split("##");
                            if (z && split != null && split.length == 2) {
                                iVar.field_fileId = split[0];
                                iVar.field_aesKey = split[1];
                                this.hWe = true;
                            }
                            x.i("MicroMsg.NetSceneUploadVideo", "%s CheckUseVideoHash debug:%s str:%s [%s,%s,%s] hasHash:%s [%s,%s]", TS(), Boolean.valueOf(com.tencent.mm.sdk.a.b.cfx()), r12, Boolean.valueOf(z2), Boolean.valueOf(z), Boolean.valueOf(z3), Boolean.valueOf(this.hWe), iVar.field_fileId, iVar.field_aesKey);
                        }
                    }
                    split = null;
                    iVar.field_fileId = split[0];
                    iVar.field_aesKey = split[1];
                    this.hWe = true;
                    x.i("MicroMsg.NetSceneUploadVideo", "%s CheckUseVideoHash debug:%s str:%s [%s,%s,%s] hasHash:%s [%s,%s]", TS(), Boolean.valueOf(com.tencent.mm.sdk.a.b.cfx()), r12, Boolean.valueOf(z2), Boolean.valueOf(z), Boolean.valueOf(z3), Boolean.valueOf(this.hWe), iVar.field_fileId, iVar.field_aesKey);
                } catch (Throwable e) {
                    x.e("MicroMsg.NetSceneUploadVideo", "Check use videohash :%s", bi.i(e));
                }
            }
            com.tencent.mm.plugin.report.service.g gVar = com.tencent.mm.plugin.report.service.g.pWK;
            objArr = new Object[2];
            i = this.hWe ? 1 : this.hWf ? 2 : 0;
            objArr[0] = Integer.valueOf(i + 700);
            objArr[1] = Integer.valueOf(this.hVF.hmZ);
            gVar.h(12696, objArr);
            if (bi.oN(iVar.field_aesKey) || bi.oN(iVar.field_aesKey)) {
                ny = "";
                iVar.field_aesKey = ny;
                iVar.field_fileId = ny;
            }
            x.i("MicroMsg.NetSceneUploadVideo", "%s summersafecdn check hit cache VideoHash :%s %s %s %b %b", TS(), iVar.field_mediaId, iVar.field_fileId, iVar.field_aesKey, Boolean.valueOf(this.hDq), Boolean.valueOf(iVar.field_largesvideo));
            if (com.tencent.mm.modelcdntran.g.MP().c(iVar)) {
                if (this.hVF.hXA != 1) {
                    this.hVF.hXA = 1;
                    this.hVF.status = 104;
                    this.hVF.clientId = this.hCY;
                    this.hVF.fEo = 524544;
                    t.e(this.hVF);
                }
                return true;
            }
            com.tencent.mm.plugin.report.service.g.pWK.a(111, 226, 1, false);
            x.e("MicroMsg.NetSceneUploadVideo", "%s cdntra addSendTask failed.", TS());
            this.hCY = "";
            return false;
        }
        r4 = new Object[3];
        com.tencent.mm.modelcdntran.g.MP();
        r4[1] = Boolean.valueOf(com.tencent.mm.modelcdntran.c.hx(2));
        r4[2] = Integer.valueOf(this.hVF.hXA);
        x.w("MicroMsg.NetSceneUploadVideo", "%s cdntra not use cdn flag:%b getCdnInfo:%d", r4);
        return false;
    }

    public g(String str) {
        Assert.assertTrue(str != null);
        x.d("MicroMsg.NetSceneUploadVideo", "NetSceneUploadVideo:  file:" + str);
        this.fileName = str;
        this.hVF = t.nJ(str);
        if (this.hVF != null) {
            this.MAX_TIMES = 2500;
        } else {
            this.MAX_TIMES = 0;
        }
        this.hGM = new com.tencent.mm.compatible.util.g.a();
        if (this.hVF != null && 3 == this.hVF.hXC) {
            this.hVH = com.tencent.mm.modelcdntran.b.MediaType_TinyVideo;
        }
        x.i("MicroMsg.NetSceneUploadVideo", "%s NetSceneUploadVideo:  videoType:[%d]", TS(), Integer.valueOf(this.hVH));
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        this.hVF = t.nJ(this.fileName);
        if (this.hVF == null || !(this.hVF.status == 104 || this.hVF.status == 103)) {
            x.e("MicroMsg.NetSceneUploadVideo", "%s Get info Failed file:", TS(), this.fileName);
            this.retCode = 0 - (com.tencent.mm.compatible.util.g.getLine() + 10000);
            return -1;
        }
        StringBuilder append = new StringBuilder("doscene file:").append(this.fileName).append(" stat:").append(this.hVF.status).append(" [").append(this.hVF.hXq).append(",").append(this.hVF.hXr).append("] [").append(this.hVF.hWd).append(",").append(this.hVF.hmZ).append("]  netTimes:").append(this.hVF.hXx).append(" times:");
        int i = this.hWi;
        this.hWi = i + 1;
        x.d("MicroMsg.NetSceneUploadVideo", append.append(i).toString());
        if (this.startTime == 0) {
            this.startTime = bi.Wy();
            this.hWd = this.hVF.hWd;
        }
        o.Ub();
        if (q.nr(s.nx(this.fileName))) {
            x.w("MicroMsg.NetSceneUploadVideo", "%s it is mm h265 video xml[%s]", TS(), this.hVF.Un());
            com.tencent.mm.plugin.report.service.g.pWK.a(354, 139, 1, false);
        }
        if (TR()) {
            x.d("MicroMsg.NetSceneUploadVideo", "cdntra use cdn return -1 for onGYNetEnd clientid:%s", this.fileName);
            return 0;
        }
        String bV;
        if (this.hVF.hXz == 1) {
            this.hWc = true;
        } else if (this.hVF.hXs + 600 < bi.Wx()) {
            x.e("MicroMsg.NetSceneUploadVideo", "create time check error:" + this.fileName);
            t.nC(this.fileName);
            this.retCode = 0 - (com.tencent.mm.compatible.util.g.getLine() + 10000);
            return -1;
        } else if (!t.nB(this.fileName)) {
            x.e("MicroMsg.NetSceneUploadVideo", "checkVoiceNetTimes Failed file:" + this.fileName);
            t.nC(this.fileName);
            this.retCode = 0 - (com.tencent.mm.compatible.util.g.getLine() + 10000);
            return -1;
        }
        b.a aVar = new b.a();
        aVar.hnT = new bso();
        aVar.hnU = new bsp();
        aVar.uri = "/cgi-bin/micromsg-bin/uploadvideo";
        aVar.hnS = f.CTRL_INDEX;
        aVar.hnV = 39;
        aVar.hnW = 1000000039;
        this.gLB = aVar.Kf();
        bso bso = (bso) this.gLB.hnQ.hnY;
        bso.npW = (String) com.tencent.mm.kernel.g.Dq().Db().get(2, (Object) "");
        bso.npV = this.hVF.Uk();
        bso.vOL = this.fileName;
        if (this.hWc) {
            bso.xas = 2;
        }
        if (this.hVF.hXC == 3) {
            bso.xas = 3;
        }
        bso.xar = this.hVF.hXv;
        bso.wEA = this.hVF.hXr;
        bso.xao = this.hVF.hmZ;
        bso.wgy = ab.bC(ad.getContext()) ? 1 : 2;
        bso.wED = 2;
        bso.xap = 0;
        bso.xaq = new bes().bl(new byte[0]);
        bso.wEC = new bes().bl(new byte[0]);
        if (bi.oN(this.fIf)) {
            o.Ub();
            bV = com.tencent.mm.a.g.bV(s.nx(this.fileName));
            this.fIf = bV;
        } else {
            bV = this.fIf;
        }
        bso.xav = bV;
        bso.vNR = bd.HJ();
        bso.xaE = this.hVF.fHB;
        bnp bnp = this.hVF.hXE;
        if (bnp != null && !bi.oN(bnp.heZ)) {
            bso.xaw = bi.aD(bnp.heZ, "");
            bso.xax = bnp.wlG;
            bso.xay = bi.aD(bnp.hfb, "");
            bso.xaA = bi.aD(bnp.hfd, "");
            bso.xaz = bi.aD(bnp.hfc, "");
            bso.xaB = bi.aD(bnp.hfe, "");
        } else if (!(bnp == null || bi.oN(bnp.hfd) || bi.oN(bnp.hfc))) {
            bso.xaA = bnp.hfd;
            bso.xaz = bnp.hfc;
        }
        if (bnp != null) {
            bso.xaD = bi.aD(bnp.hff, "");
            bso.xaC = bi.aD(bnp.hfg, "");
        }
        x.d("MicroMsg.NetSceneUploadVideo", "upload video: play length %d, thumb totalLen %d, video totalLen %d, funcFlag %d, videoMd5: %s stream %s streamtime: %d title %s thumburl %s", Integer.valueOf(bso.xar), Integer.valueOf(bso.wEB), Integer.valueOf(bso.xao), Integer.valueOf(bso.xas), bso.xav, bso.xaw, Integer.valueOf(bso.xax), bso.xay, bso.xaB);
        s.b i2;
        Object obj;
        if (this.hVF.status == 103) {
            o.Ub();
            i2 = s.i(s.ny(this.fileName), this.hVF.hXq, hWa);
            if (i2.ret < 0 || i2.flJ == 0) {
                com.tencent.mm.plugin.report.service.g.pWK.a(111, 225, 1, false);
                t.nC(this.fileName);
                x.e("MicroMsg.NetSceneUploadVideo", "doScene READ THUMB[" + this.fileName + "]  Error ");
                this.retCode = 0 - (com.tencent.mm.compatible.util.g.getLine() + 10000);
                return -1;
            }
            x.d("MicroMsg.NetSceneUploadVideo", "doScene READ THUMB[" + this.fileName + "] read ret:" + i2.ret + " readlen:" + i2.flJ + " newOff:" + i2.hXV + " netOff:" + this.hVF.hXq);
            if (i2.hXV < this.hVF.hXq) {
                x.e("MicroMsg.NetSceneUploadVideo", "Err doScene READ THUMB[" + this.fileName + "] newOff:" + i2.hXV + " OldtOff:" + this.hVF.hXq);
                t.nC(this.fileName);
                this.retCode = 0 - (com.tencent.mm.compatible.util.g.getLine() + 10000);
                return -1;
            }
            obj = new byte[i2.flJ];
            System.arraycopy(i2.buf, 0, obj, 0, i2.flJ);
            bso.wEB = this.hVF.hXq;
            bso.wEC = new bes().bl(obj);
        } else {
            o.Ub();
            i2 = s.i(s.nx(this.fileName), this.hVF.hWd, hWa);
            if (i2.ret < 0 || i2.flJ == 0) {
                com.tencent.mm.plugin.report.service.g.pWK.a(111, 224, 1, false);
                t.nC(this.fileName);
                x.e("MicroMsg.NetSceneUploadVideo", "doScene READ VIDEO[" + this.fileName + "]  Error ");
                this.retCode = 0 - (com.tencent.mm.compatible.util.g.getLine() + 10000);
                return -1;
            }
            x.d("MicroMsg.NetSceneUploadVideo", "doScene READ VIDEO[" + this.fileName + "] read ret:" + i2.ret + " readlen:" + i2.flJ + " newOff:" + i2.hXV + " netOff:" + this.hVF.hWd);
            if (i2.hXV < this.hVF.hWd) {
                x.e("MicroMsg.NetSceneUploadVideo", "Err doScene READ VIDEO[" + this.fileName + "] newOff:" + i2.hXV + " OldtOff:" + this.hVF.hWd);
                t.nC(this.fileName);
                this.retCode = 0 - (com.tencent.mm.compatible.util.g.getLine() + 10000);
                return -1;
            } else if (i2.hXV >= c.hVb) {
                com.tencent.mm.plugin.report.service.g.pWK.a(111, 222, 1, false);
                x.e("MicroMsg.NetSceneUploadVideo", "Err doScene READ VIDEO[" + this.fileName + "] maxsize:" + c.hVb);
                t.nC(this.fileName);
                this.retCode = 0 - (com.tencent.mm.compatible.util.g.getLine() + 10000);
                return -1;
            } else {
                obj = new byte[i2.flJ];
                System.arraycopy(i2.buf, 0, obj, 0, i2.flJ);
                bso.xap = this.hVF.hWd;
                bso.wEB = this.hVF.hXq;
                bso.xaq = new bes().bl(obj);
            }
        }
        return a(eVar, this.gLB, this);
    }

    protected final int a(q qVar) {
        bso bso = (bso) ((b) qVar).hnQ.hnY;
        if (!bi.oN(bso.vOL) && bso.wED > 0 && !bi.oN(bso.npW) && !bi.oN(bso.npV) && bso.wgy > 0 && bso.wEB <= bso.wEA && bso.wEB >= 0 && bso.xap <= bso.xao && bso.xap >= 0 && ((bso.xap != bso.xao || bso.wEB != bso.wEA) && bso.wEA > 0 && bso.xao > 0 && (bso.xaq.wRk > 0 || bso.wEC.wRk > 0))) {
            return b.hoz;
        }
        x.e("MicroMsg.NetSceneUploadVideo", "ERR: Security Check Failed file:" + this.fileName + " user:" + bso.npV);
        return b.hoA;
    }

    protected final int Bo() {
        return this.MAX_TIMES;
    }

    protected final void a(a aVar) {
        com.tencent.mm.plugin.report.service.g.pWK.a(111, 221, 1, false);
        t.nC(this.fileName);
    }

    public final boolean Kk() {
        boolean Kk = super.Kk();
        if (Kk) {
            com.tencent.mm.plugin.report.service.g.pWK.a(111, 210, 1, false);
        }
        return Kk;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneUploadVideo", "cdntra onGYNetEnd errtype:" + i2 + " errcode:" + i3 + " useCdnTransClientId:" + this.hCY);
        if (this.hVI) {
            x.d("MicroMsg.NetSceneUploadVideo", "onGYNetEnd Call Stop by Service   file:" + this.fileName + " user:" + this.hVF.Uk());
            this.gLE.a(i2, i3, str, this);
        } else if (i2 == 3 && i3 == -1 && !bi.oN(this.hCY)) {
            x.w("MicroMsg.NetSceneUploadVideo", "cdntra using cdn trans,  wait cdn service callback! clientid:%s", this.hCY);
        } else {
            bsp bsp = (bsp) ((b) qVar).hnR.hnY;
            bso bso = (bso) ((b) qVar).hnQ.hnY;
            this.hVF = t.nJ(this.fileName);
            if (this.hVF == null) {
                x.e("MicroMsg.NetSceneUploadVideo", "ERR: onGYNetEnd Get INFO FAILED :" + this.fileName);
                this.retCode = (0 - com.tencent.mm.compatible.util.g.getLine()) - 10000;
                this.gLE.a(i2, i3, str, this);
            } else if (this.hVF.status == 105) {
                x.w("MicroMsg.NetSceneUploadVideo", "onGYNetEnd STATUS PAUSE [" + this.fileName + "," + this.hVF.fGj + "," + this.hVF.Ul() + "," + this.hVF.Uk() + "] ");
                this.gLE.a(i2, i3, str, this);
            } else if (this.hVF.status != 104 && this.hVF.status != 103) {
                x.e("MicroMsg.NetSceneUploadVideo", "ERR: onGYNetEnd STATUS ERR: status:" + this.hVF.status + " [" + this.fileName + "," + this.hVF.fGj + "," + this.hVF.Ul() + "," + this.hVF.Uk() + "] ");
                this.gLE.a(i2, i3, str, this);
            } else if (i2 == 4 && i3 == -22) {
                x.e("MicroMsg.NetSceneUploadVideo", "ERR: onGYNetEnd BLACK  errtype:" + i2 + " errCode:" + i3 + "  file:" + this.fileName + " user:" + this.hVF.Uk());
                t.nD(this.fileName);
                this.gLE.a(i2, i3, str, this);
            } else if (i2 == 4 && i3 != 0) {
                com.tencent.mm.plugin.report.service.g.pWK.a(111, 220, 1, false);
                x.e("MicroMsg.NetSceneUploadVideo", "ERR: onGYNetEnd SERVER FAILED errtype:" + i2 + " errCode:" + i3 + "  file:" + this.fileName + " user:" + this.hVF.Uk());
                t.nC(this.fileName);
                com.tencent.mm.plugin.report.service.g.pWK.h(10420, Integer.valueOf(i3), Integer.valueOf(1), Long.valueOf(this.startTime), Long.valueOf(bi.Wy()), Integer.valueOf(d.bi(ad.getContext())), Integer.valueOf(this.hVH), Integer.valueOf(0));
                this.gLE.a(i2, i3, str, this);
            } else if (i2 != 0 || i3 != 0) {
                com.tencent.mm.plugin.report.service.g.pWK.a(111, 219, 1, false);
                x.e("MicroMsg.NetSceneUploadVideo", "ERR: onGYNetEnd FAILED (WILL RETRY) errtype:" + i2 + " errCode:" + i3 + "  file:" + this.fileName + " user:" + this.hVF.Uk());
                this.gLE.a(i2, i3, str, this);
            } else if (!bi.by(bso.wEC.wRm.oz) && bso.wEB != bsp.wEB - bso.wEC.wRk) {
                x.e("MicroMsg.NetSceneUploadVideo", "onGYNetEnd Err Thumb Pos:[" + bso.wEB + "," + bso.wEC.wRk + "," + bsp.wEB + "] file:" + this.fileName + " user:" + bso.npV);
                t.nC(this.fileName);
                this.gLE.a(i2, i3, str, this);
            } else if (bi.by(bso.xaq.wRm.oz) || bso.xap == bsp.xap - bso.xaq.wRk) {
                this.hVF.hXt = bi.Wx();
                this.hVF.fGj = bsp.vNT;
                this.hVF.fEo = 1028;
                x.d("MicroMsg.NetSceneUploadVideo", "dkmsgid  set svrmsgid %d -> %d", Long.valueOf(this.hVF.fGj), Integer.valueOf(r.ifO));
                if (!(CdnLogic.kMediaTypeFavoriteBigFile != r.ifN || r.ifO == 0 || this.hVF.fGj == 0)) {
                    this.hVF.fGj = (long) r.ifO;
                    r.ifO = 0;
                }
                Object obj = null;
                int i4 = this.hVF.status;
                if (i4 == 103) {
                    this.hVF.hXq = bso.wEC.wRk + bso.wEB;
                    this.hVF.fEo |= 64;
                    if (this.hVF.hXq >= this.hVF.hXr) {
                        this.hVF.status = 104;
                        this.hVF.fEo |= 256;
                    }
                } else if (i4 == 104) {
                    this.hVF.hWd = bso.xaq.wRk + bso.xap;
                    this.hVF.fEo |= 8;
                    if (this.hVF.hWd >= this.hVF.hmZ) {
                        this.hVF.status = 199;
                        this.hVF.fEo |= 256;
                        t.c(this.hVF);
                        obj = 1;
                    }
                } else {
                    x.e("MicroMsg.NetSceneUploadVideo", "onGYNetEnd ERROR STATUS:" + i4 + " file:" + this.fileName + " user:" + bso.npV);
                    t.nC(this.fileName);
                    this.gLE.a(i2, i3, str, this);
                    return;
                }
                t.e(this.hVF);
                if (this.hVI) {
                    this.gLE.a(i2, i3, str, this);
                } else if (obj == null) {
                    this.hmy.K(10, 10);
                } else {
                    boolean z;
                    com.tencent.mm.modelstat.b.hRo.f(((com.tencent.mm.plugin.messenger.foundation.a.h) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aZO().dI((long) this.hVF.hXw));
                    com.tencent.mm.plugin.report.service.g.pWK.h(10420, Integer.valueOf(0), Integer.valueOf(1), Long.valueOf(this.startTime), Long.valueOf(bi.Wy()), Integer.valueOf(d.bi(ad.getContext())), Integer.valueOf(this.hVH), Integer.valueOf(this.hVF.hmZ - this.hWd));
                    if (this.hVF == null) {
                        z = false;
                    } else {
                        com.tencent.mm.k.a Xv = ((com.tencent.mm.plugin.messenger.foundation.a.h) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).Ff().Xv(this.hVF.Uk());
                        z = (Xv == null || ((int) Xv.gKO) <= 0) ? false : Xv.ciN();
                    }
                    if (z || s.gU(this.hVF.Uk())) {
                        x.i("MicroMsg.NetSceneUploadVideo", "upload to biz :%s", this.hVF.Uk());
                        if (this.hVF.fGj < 0) {
                            x.e("MicroMsg.NetSceneUploadVideo", "ERR: finish video invaild MSGSVRID :" + this.hVF.fGj + " file:" + this.fileName + " toUser:" + this.hVF.Uk());
                            t.nC(this.fileName);
                        }
                    } else {
                        x.i("MicroMsg.NetSceneUploadVideo", "not upload to biz");
                        if (this.hVF.fGj <= 0) {
                            x.e("MicroMsg.NetSceneUploadVideo", "ERR: finish video invaild MSGSVRID :" + this.hVF.fGj + " file:" + this.fileName + " toUser:" + this.hVF.Uk());
                            t.nC(this.fileName);
                        }
                    }
                    long zp = this.hGM != null ? this.hGM.zp() : 0;
                    x.d("MicroMsg.NetSceneUploadVideo", "!!!FIN: file:" + this.fileName + " toUser:" + this.hVF.Uk() + " msgsvrid:" + this.hVF.fGj + " thumbsize:" + this.hVF.hXr + " videosize:" + this.hVF.hmZ + " useTime:" + zp);
                    x.d("MicroMsg.NetSceneUploadVideo", "FinishLogForTime file:" + this.fileName + " packSize:" + hWa + " filesize:" + this.hVF.hmZ + " useTime:" + zp);
                    a.a(this.hVF, 0);
                    this.gLE.a(i2, i3, str, this);
                }
            } else {
                x.e("MicroMsg.NetSceneUploadVideo", "onGYNetEnd Err Thumb Pos:[" + bso.xap + "," + bso.xaq.wRk + "," + bsp.xap + "] file:" + this.fileName + " user:" + bso.npV);
                t.nC(this.fileName);
                this.gLE.a(i2, i3, str, this);
            }
        }
    }

    public final int getType() {
        return f.CTRL_INDEX;
    }

    private String nn(String str) {
        boolean z;
        Throwable e;
        File file = new File(str);
        File file2 = new File(file.getParentFile(), "send" + file.getName());
        InputStream inputStream = null;
        OutputStream outputStream = null;
        boolean z2 = false;
        x.d("MicroMsg.NetSceneUploadVideo", "getSendThumbnailPath:origin file: %d", Long.valueOf(file.length()));
        InputStream fileInputStream;
        OutputStream fileOutputStream;
        try {
            if (file.length() <= 32768) {
                z = z2;
            } else if (file2.exists()) {
                x.d("MicroMsg.NetSceneUploadVideo", "dst file %s exist!", file2.getAbsolutePath());
                z = true;
            } else {
                Options Vq = com.tencent.mm.sdk.platformtools.d.Vq(file.getAbsolutePath());
                String str2 = "MicroMsg.NetSceneUploadVideo";
                String str3 = "getSendThumbnailPath:options %s";
                Object[] objArr = new Object[1];
                objArr[0] = Vq == null ? "null" : Vq.outWidth + "-" + Vq.outHeight;
                x.i(str2, str3, objArr);
                if (Vq == null || (Vq.outWidth <= 288 && Vq.outHeight <= 288)) {
                    fileInputStream = new FileInputStream(file);
                    try {
                        Bitmap a = com.tencent.mm.sdk.platformtools.d.a(fileInputStream, 0.0f, 288, 288);
                        if (a != null) {
                            fileOutputStream = new FileOutputStream(file2);
                            try {
                                z = a.compress(CompressFormat.JPEG, 60, fileOutputStream);
                                outputStream = fileOutputStream;
                                inputStream = fileInputStream;
                            } catch (Exception e2) {
                                e = e2;
                                try {
                                    x.e("MicroMsg.NetSceneUploadVideo", "exception: %s", bi.i(e));
                                    if (fileInputStream != null) {
                                        try {
                                            fileInputStream.close();
                                        } catch (IOException e3) {
                                        }
                                    }
                                    if (fileOutputStream != null) {
                                        try {
                                            fileOutputStream.close();
                                            z = z2;
                                        } catch (IOException e4) {
                                            z = z2;
                                        }
                                    } else {
                                        z = z2;
                                    }
                                    if (z) {
                                        x.i("MicroMsg.NetSceneUploadVideo", "%s compress success: length=%d | path=%s", TS(), Long.valueOf(file2.length()), file2.getAbsolutePath());
                                        return file2.getAbsolutePath();
                                    }
                                    x.i("MicroMsg.NetSceneUploadVideo", "%s compress fail: origin length=%d | path=%s", TS(), Long.valueOf(file.length()), file.getAbsolutePath());
                                    return str;
                                } catch (Throwable th) {
                                    e = th;
                                    outputStream = fileOutputStream;
                                    inputStream = fileInputStream;
                                    if (inputStream != null) {
                                        try {
                                            inputStream.close();
                                        } catch (IOException e5) {
                                        }
                                    }
                                    if (outputStream != null) {
                                        try {
                                            outputStream.close();
                                        } catch (IOException e6) {
                                        }
                                    }
                                    throw e;
                                }
                            }
                        }
                        z = z2;
                        inputStream = fileInputStream;
                    } catch (Exception e7) {
                        e = e7;
                        fileOutputStream = null;
                        x.e("MicroMsg.NetSceneUploadVideo", "exception: %s", bi.i(e));
                        if (fileInputStream != null) {
                            fileInputStream.close();
                        }
                        if (fileOutputStream != null) {
                            z = z2;
                        } else {
                            fileOutputStream.close();
                            z = z2;
                        }
                        if (z) {
                            x.i("MicroMsg.NetSceneUploadVideo", "%s compress success: length=%d | path=%s", TS(), Long.valueOf(file2.length()), file2.getAbsolutePath());
                            return file2.getAbsolutePath();
                        }
                        x.i("MicroMsg.NetSceneUploadVideo", "%s compress fail: origin length=%d | path=%s", TS(), Long.valueOf(file.length()), file.getAbsolutePath());
                        return str;
                    } catch (Throwable th2) {
                        e = th2;
                        inputStream = fileInputStream;
                        if (inputStream != null) {
                            inputStream.close();
                        }
                        if (outputStream != null) {
                            outputStream.close();
                        }
                        throw e;
                    }
                }
                z = com.tencent.mm.sdk.platformtools.d.a(file.getAbsolutePath(), 288, 288, CompressFormat.JPEG, 60, file2.getParentFile().getAbsolutePath() + "/", file2.getName());
            }
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e8) {
                }
            }
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e9) {
                }
            }
        } catch (Exception e10) {
            e = e10;
            fileOutputStream = null;
            fileInputStream = null;
            x.e("MicroMsg.NetSceneUploadVideo", "exception: %s", bi.i(e));
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            if (fileOutputStream != null) {
                fileOutputStream.close();
                z = z2;
            } else {
                z = z2;
            }
            if (z) {
                x.i("MicroMsg.NetSceneUploadVideo", "%s compress fail: origin length=%d | path=%s", TS(), Long.valueOf(file.length()), file.getAbsolutePath());
                return str;
            }
            x.i("MicroMsg.NetSceneUploadVideo", "%s compress success: length=%d | path=%s", TS(), Long.valueOf(file2.length()), file2.getAbsolutePath());
            return file2.getAbsolutePath();
        } catch (Throwable th3) {
            e = th3;
            if (inputStream != null) {
                inputStream.close();
            }
            if (outputStream != null) {
                outputStream.close();
            }
            throw e;
        }
        if (z) {
            x.i("MicroMsg.NetSceneUploadVideo", "%s compress success: length=%d | path=%s", TS(), Long.valueOf(file2.length()), file2.getAbsolutePath());
            return file2.getAbsolutePath();
        }
        x.i("MicroMsg.NetSceneUploadVideo", "%s compress fail: origin length=%d | path=%s", TS(), Long.valueOf(file.length()), file.getAbsolutePath());
        return str;
    }

    private String TS() {
        return this.fileName + "_" + hashCode();
    }
}
