package com.tencent.mm.plugin.sns.model.a;

import com.tencent.mars.cdn.CdnLogic;
import com.tencent.mm.a.o;
import com.tencent.mm.memory.n;
import com.tencent.mm.modelcdntran.h;
import com.tencent.mm.modelcdntran.keep_ProgressInfo;
import com.tencent.mm.modelcdntran.keep_SceneResult;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.modelsns.d;
import com.tencent.mm.network.b;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.model.au;
import com.tencent.mm.pluginsdk.model.l;
import com.tencent.mm.protocal.c.are;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.an;
import java.io.ByteArrayOutputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public abstract class c extends l<String, Integer, Integer> {
    private static HashSet<String> rfb = new HashSet();
    private long dnsCostTime = -1;
    protected are fIx = null;
    private String host = "";
    private int ibm = -1;
    protected a reH;
    protected n reI = null;
    protected a reJ = null;
    int rfd = 0;

    public interface a {
        void a(int i, are are, int i2, boolean z, String str, int i3);
    }

    public abstract boolean bwR();

    protected abstract int bwS();

    public /* synthetic */ Object bvz() {
        return bwT();
    }

    public static boolean Lr(String str) {
        if (rfb.contains(i.aK(1, str)) || rfb.contains(i.aK(5, str))) {
            return true;
        }
        return false;
    }

    public c(a aVar, a aVar2) {
        this.reH = aVar;
        this.reJ = aVar2;
        if (aVar2 != null) {
            this.fIx = aVar2.qZY;
            rfb.add(aVar2.qZX);
            aVar2.init();
        }
    }

    public boolean bwQ() {
        return true;
    }

    public String Lp(String str) {
        return str;
    }

    protected final void b(keep_SceneResult keep_sceneresult) {
        String str;
        int i;
        int bwS = bwS();
        String str2 = "";
        switch (bwS) {
            case 1:
                str = "100105";
                break;
            case 2:
                str = "100106";
                break;
            case 3:
                str = "100100";
                break;
            default:
                return;
        }
        com.tencent.mm.storage.c fp = com.tencent.mm.y.c.c.IL().fp(str);
        if (fp.isValid()) {
            i = bi.getInt((String) fp.civ().get("needUploadData"), 1);
            str2 = fp.field_expId;
        } else {
            i = 0;
        }
        if (i != 0) {
            int i2;
            if (this.reJ.reF == 8) {
                i = 1;
            } else if (this.reJ.reF == 6 || this.reJ.reF == 4) {
                i = 2;
            } else if (this.reJ.reF == 5) {
                i = 4;
            } else if (this.reJ.reF == 2 || this.reJ.reF == 1 || this.reJ.reF == 3) {
                i = 0;
            } else {
                i = 5;
            }
            d dVar = new d();
            dVar.q("20ImgSize", keep_sceneresult.field_fileLength + ",");
            String str3 = "21NetType";
            StringBuilder stringBuilder = new StringBuilder();
            if (ao.isWifi(ad.getContext())) {
                i2 = 1;
            } else {
                i2 = 0;
            }
            dVar.q(str3, stringBuilder.append(i2).append(",").toString());
            dVar.q("22DelayTime", keep_sceneresult.field_delayTime + ",");
            dVar.q("23RetCode", keep_sceneresult.field_retCode + ",");
            dVar.q("24DnsCostTime", keep_sceneresult.field_dnsCostTime + ",");
            dVar.q("25ConnectCostTime", keep_sceneresult.field_connectCostTime + ",");
            dVar.q("26SendCostTime", ",");
            dVar.q("27WaitResponseCostTime", keep_sceneresult.field_waitResponseCostTime + ",");
            dVar.q("28ReceiveCostTime", keep_sceneresult.field_receiveCostTime + ",");
            dVar.q("29ClientAddrIP(uint)", keep_sceneresult.field_clientHostIP + ",");
            dVar.q("30ServerAddrIP(uint)", keep_sceneresult.field_serverHostIP + ",");
            dVar.q("31dnstype", this.ibm + ",");
            dVar.q("32signal(int)", ao.getStrength(ad.getContext()) + ",");
            dVar.q("33host(string)", this.host + ",");
            dVar.q("34MediaType", bwS + ",");
            dVar.q("35X_Errno(string)", keep_sceneresult.field_xErrorNo + ",");
            dVar.q("36MaxPackageSize", ",");
            dVar.q("37MaxPackageTimeStamp", ",");
            dVar.q("38PackageRecordList", ",");
            dVar.q("39ExpLayerId", str + ",");
            dVar.q("40ExpId", str2 + ",");
            dVar.q("41FeedId", ",");
            dVar.q("42BizType", i + ",");
            dVar.q("43CSeqCheck(uint)", keep_sceneresult.field_cSeqCheck + ",");
            dVar.q("44isPrivate(uint)", (keep_sceneresult.field_usePrivateProtocol ? 1 : 0) + ",");
            x.i("MicroMsg.SnsCdnDownloadBase", "report logbuffer(13480 TLMediaFielDownloadRecord): " + dVar.SG());
            g.pWK.h(13480, dVar);
            if (keep_sceneresult.field_retCode != 200 && keep_sceneresult.field_retCode != 0) {
                g.pWK.h(14071, dVar);
            }
        }
    }

    public boolean a(an anVar, String str, long j, String str2) {
        if (str == null) {
            return false;
        }
        try {
            URL url = new URL(str);
            if (anVar == null || str2 == null || str2.indexOf(url.getHost()) == -1 || anVar.time == 0 || bi.bz((long) anVar.time) <= j) {
                return false;
            }
            return true;
        } catch (Exception e) {
            x.e("MicroMsg.SnsCdnDownloadBase", "error for check dcip %s", e.getMessage());
            return false;
        }
    }

    public Integer bwT() {
        com.tencent.mm.kernel.g.Dr();
        if (!com.tencent.mm.kernel.g.Dq().isSDCardAvailable() || this.reJ == null) {
            return Integer.valueOf(2);
        }
        int i;
        if (bwQ()) {
            x.i("MicroMsg.SnsCdnDownloadBase", "[tomys] delete img: %s", this.reJ.qZT + this.reJ.bwP());
            FileOp.deleteFile(r0);
        }
        System.currentTimeMillis();
        x.d("MicroMsg.SnsCdnDownloadBase", "to downloadBitmap " + this.reJ.mediaId + " " + this.reJ.reD + " type " + this.reJ.reF);
        FileOp.ml(this.reJ.getPath());
        an anVar = this.reJ.reG;
        String str = "";
        if (anVar == null) {
            str = "";
        } else if (anVar.equals(an.xHq)) {
            str = "album_friend";
        } else if (anVar.equals(an.xHr)) {
            str = "album_self";
        } else if (anVar.equals(an.xHs)) {
            str = "album_stranger";
        } else if (anVar.equals(an.xHt)) {
            str = "profile_friend";
        } else if (anVar.equals(an.xHu)) {
            str = "profile_stranger";
        } else if (anVar.equals(an.xHv)) {
            str = FFmpegMetadataRetriever.METADATA_KEY_COMMENT;
        } else if (anVar.equals(an.xHp)) {
            str = "timeline";
        }
        if (!bi.oN(str)) {
            str = "&scene=" + str;
        }
        String format = String.format("http://weixin.qq.com/?version=%d&uin=%s&nettype=%d&signal=%d%s", new Object[]{Integer.valueOf(com.tencent.mm.protocal.d.vHl), o.getString(ae.bvM()), Integer.valueOf(ao.getNetTypeForStat(ad.getContext())), Integer.valueOf(ao.getStrength(ad.getContext())), str});
        this.reJ.url = Lp(this.reJ.url);
        this.dnsCostTime = bi.Wy();
        long j = (long) com.tencent.mm.j.g.Af().getInt(this.reJ.reE ? "SnsSightMainStandbyIpSwitchTime" : "SnsAlbumMainStandbyIpSwitchTime", 0);
        x.i("MicroMsg.SnsCdnDownloadBase", "pack.isAlbum %s pack.isthumb %s hostvalue %s dcipTime %s", Boolean.valueOf(this.reJ.reE), Boolean.valueOf(this.reJ.reD), com.tencent.mm.j.g.Af().getValue(this.reJ.reE ? "SnsSightDomainList" : "SnsAlbumDomainList"), Long.valueOf(j));
        if (j <= 0) {
            j = 259200;
        }
        boolean a = a(anVar, this.reJ.url, j, r6);
        this.dnsCostTime = bi.bA(this.dnsCostTime);
        com.tencent.mm.modelcdntran.i hVar = new h();
        if (a(hVar, a, format)) {
            hVar.hve = new com.tencent.mm.modelcdntran.i.a() {
                public final int a(final String str, int i, keep_ProgressInfo keep_progressinfo, final keep_SceneResult keep_sceneresult, boolean z) {
                    int i2 = 2;
                    int i3 = 1;
                    String str2 = "MicroMsg.SnsCdnDownloadBase";
                    String str3 = "download done mediaID:%s,  sceneResult is null:%b";
                    Object[] objArr = new Object[2];
                    objArr[0] = str;
                    objArr[1] = Boolean.valueOf(keep_sceneresult == null);
                    x.i(str2, str3, objArr);
                    if (keep_sceneresult != null) {
                        if (keep_sceneresult.field_retCode != 0) {
                            b.reportFailIp(keep_sceneresult.field_serverIP);
                        } else {
                            c.this.rfd = keep_sceneresult.field_fileLength;
                            if (!c.this.bwR()) {
                                i3 = 2;
                            } else if (c.this.reJ.reD) {
                                i3 = 3;
                            }
                            i2 = i3;
                        }
                        c.this.b(keep_sceneresult);
                        ae.aOA().post(new Runnable() {
                            public final void run() {
                                c.rfb.remove(c.this.reJ.qZX);
                                x.i("MicroMsg.SnsCdnDownloadBase", "download done result: %s, %d, url:%s, mediaID:%s, totalSize: %d, runningTasksSize: %d", str, Integer.valueOf(i2), c.this.reJ.url, c.this.reJ.mediaId, Integer.valueOf(keep_sceneresult.field_fileLength), Integer.valueOf(c.rfb.size()));
                                if (c.this.reJ.reD && i2 != 2) {
                                    au.Lb(c.this.reJ.mediaId);
                                    c.this.bwU();
                                } else if (!c.this.reJ.reD && (c.this.reJ.reF == 4 || c.this.reJ.reF == 6)) {
                                    ae.bwc().eg(c.this.reJ.mediaId, c.this.reJ.getPath() + i.j(c.this.fIx));
                                }
                                c.this.reH.a(i2, c.this.fIx, c.this.reJ.reF, c.this.reJ.reD, c.this.reJ.qZX, keep_sceneresult.field_fileLength);
                            }
                        });
                    }
                    return 0;
                }

                public final void a(String str, ByteArrayOutputStream byteArrayOutputStream) {
                }

                public final byte[] h(String str, byte[] bArr) {
                    return new byte[0];
                }
            };
            if (com.tencent.mm.modelcdntran.g.MP().b(hVar, -1)) {
                x.i("MicroMsg.SnsCdnDownloadBase", "SubCoreCdnTransport addRecvTask suc");
                i = 1;
                return Integer.valueOf(i);
            }
            x.w("MicroMsg.SnsCdnDownloadBase", "SubCoreCdnTransport addRecvTask failed");
        }
        i = 2;
        return Integer.valueOf(i);
    }

    private boolean a(h hVar, boolean z, String str) {
        try {
            this.host = new URL(this.reJ.url).getHost();
            List arrayList = new ArrayList();
            this.ibm = b.a(this.host, false, arrayList);
            List arrayList2 = new ArrayList();
            int a = b.a(this.host, true, arrayList2);
            Random random = new Random();
            random.setSeed(bi.Wy());
            Collections.shuffle(arrayList, random);
            Collections.shuffle(arrayList2, random);
            while (arrayList.size() > 2) {
                arrayList.remove(0);
            }
            while (arrayList2.size() > 2) {
                arrayList2.remove(0);
            }
            hVar.field_mediaId = this.reJ.mediaId + "_" + this.reJ.reF;
            hVar.url = this.reJ.url;
            hVar.host = this.host;
            hVar.referer = str;
            hVar.huY = this.reJ.getPath() + this.reJ.bwP();
            hVar.huZ = bQ(arrayList);
            hVar.hva = bQ(arrayList2);
            hVar.hvb = this.ibm;
            hVar.hvc = a;
            hVar.isColdSnsData = z;
            hVar.signalQuality = ao.getStrength(ad.getContext());
            hVar.snsScene = this.reJ.reG.tag;
            if (this.reJ.qZY != null) {
                hVar.snsCipherKey = this.reJ.reD ? this.reJ.qZY.wFj : this.reJ.qZY.wFg;
            }
            if (this.reJ.reF == 8) {
                hVar.fXs = 3;
                hVar.hvd = 109;
                hVar.fileType = 20204;
            } else if (this.reJ.reF == 6 || this.reJ.reF == 4) {
                hVar.fXs = 3;
                hVar.hvd = 105;
                hVar.fileType = CdnLogic.kMediaTypeAdVideo;
            } else if (this.reJ.reF == 5) {
                hVar.fXs = 3;
                hVar.hvd = 150;
                hVar.fileType = 20250;
            } else if (this.reJ.reF == 2 || this.reJ.reF == 1 || this.reJ.reF == 3) {
                hVar.fXs = 3;
                hVar.hvd = 100;
                hVar.fileType = 20201;
            }
            x.i("MicroMsg.SnsCdnDownloadBase", "attachSnsImgTaskInfo reqDownType:%d:%s", Integer.valueOf(this.reJ.reF), hVar);
            return true;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.SnsCdnDownloadBase", e, "", new Object[0]);
            x.w("MicroMsg.SnsCdnDownloadBase", "attachSnsImgTaskInfo fail:" + e);
            return false;
        }
    }

    private static String[] bQ(List<String> list) {
        String[] strArr = new String[list.size()];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= strArr.length) {
                return strArr;
            }
            strArr[i2] = (String) list.get(i2);
            i = i2 + 1;
        }
    }

    public void onPostExecute(Integer num) {
        super.onPostExecute(num);
    }

    public void bwU() {
        int i = 0;
        if (!ae.bvO()) {
            System.currentTimeMillis();
            if (this.reJ.qWO.qWU == 4) {
                x.i("MicroMsg.SnsCdnDownloadBase", "decodeType blur thumb");
                this.reI = com.tencent.mm.plugin.sns.lucky.a.a.ee(this.reJ.getPath() + i.e(this.fIx), this.reJ.getPath() + i.g(this.fIx));
                ae.bwc().a(this.reJ.mediaId, this.reI, this.reJ.qWO.qWU);
            } else if (this.reJ.qWO.qWU == 5) {
                x.i("MicroMsg.SnsCdnDownloadBase", "decodeType blur grid");
                this.reI = com.tencent.mm.plugin.sns.lucky.a.a.ee(this.reJ.getPath() + i.e(this.fIx), this.reJ.getPath() + i.h(this.fIx));
                ae.bwc().a(this.reJ.mediaId, this.reI, this.reJ.qWO.qWU);
            } else if (this.reJ.qWO.list.size() <= 1) {
                ae.bwc().a(this.reJ.mediaId, this.reI, this.reJ.qWO.qWU);
            } else {
                ae.bwc().a(this.reJ.mediaId, this.reI, 0);
                List linkedList = new LinkedList();
                while (true) {
                    int i2 = i;
                    if (i2 >= this.reJ.qWO.list.size() || i2 >= 4) {
                        this.reI = n.i(i.h(linkedList, ae.bwn()));
                        x.i("MicroMsg.SnsCdnDownloadBase", "merge bitmap " + this.reJ.qWO.hMN + " " + this.reI);
                        ae.bwc().a(this.reJ.qWO.hMN, this.reI, this.reJ.qWO.qWU);
                    } else {
                        are are = (are) this.reJ.qWO.list.get(i2);
                        n KG = ae.bwc().KG(are.nMq);
                        if (i.b(KG)) {
                            linkedList.add(KG);
                            x.i("MicroMsg.SnsCdnDownloadBase", "merge bitmap from " + KG + " " + are.nMq);
                            i = i2 + 1;
                        } else {
                            return;
                        }
                    }
                }
                this.reI = n.i(i.h(linkedList, ae.bwn()));
                x.i("MicroMsg.SnsCdnDownloadBase", "merge bitmap " + this.reJ.qWO.hMN + " " + this.reI);
                ae.bwc().a(this.reJ.qWO.hMN, this.reI, this.reJ.qWO.qWU);
            }
            String str = null;
            if (this.reJ.qWO.qWU == 0) {
                str = "0-" + this.reJ.qWO.hMN;
            } else if (this.reJ.qWO.qWU == 1) {
                str = "1-" + this.reJ.qWO.hMN;
            } else if (this.reJ.qWO.qWU == 4) {
                str = "4-" + this.reJ.qWO.hMN;
            } else if (this.reJ.qWO.qWU == 5) {
                str = "5-" + this.reJ.qWO.hMN;
            } else if (this.reJ.qWO.qWU == 3) {
                str = i.aJ(3, this.reJ.qWO.hMN);
            }
            ae.bwc().KF(str);
        }
    }

    public ag bvy() {
        return ae.bvQ();
    }
}
