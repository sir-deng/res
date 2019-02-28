package com.tencent.mm.modelcdntran;

import android.os.Looper;
import android.os.Message;
import com.tencent.mars.BaseEvent;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.f.a.jb;
import com.tencent.mm.modelcdntran.b.b;
import com.tencent.mm.network.n;
import com.tencent.mm.network.n.a;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;

public final class c implements e, b, m.b {
    ag hua = new ag(Looper.getMainLooper()) {
        public final void handleMessage(Message message) {
            if (ao.isConnected(ad.getContext())) {
                x.i("MicroMsg.CdnTransportService", "cdntra mm on network change to get dns.");
                g.pWK.a(546, 5, 1, true);
                BaseEvent.onNetworkChange();
            }
        }
    };
    com.tencent.mm.sdk.b.c<jb> hub = new com.tencent.mm.sdk.b.c<jb>() {
        {
            this.xmG = jb.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            if (ao.isConnected(ad.getContext())) {
                x.i("MicroMsg.CdnTransportService", "cdntra mm on network change callback ");
                c.this.hua.removeMessages(1);
                c.this.hua.sendEmptyMessageDelayed(1, 10000);
            }
            return false;
        }
    };
    n huc = new a() {
        public final void eq(int i) {
            x.d("MicroMsg.CdnTransportService", "cdntra onNetworkChange st:%d ", Integer.valueOf(i));
            if ((i == 4 || i == 6) && com.tencent.mm.kernel.g.Do().CF()) {
                c.this.hua.removeMessages(1);
                BaseEvent.onNetworkChange();
            }
        }
    };
    Queue<String> hud = new LinkedList();
    public Map<String, i> hue = new HashMap();
    public Map<String, i> huf = new ConcurrentHashMap();
    public Map<String, Integer> hug = new HashMap();
    private String huh = "";
    private long hui = 0;
    public HashSet<String> huj = new HashSet();

    public final void a(int i, m mVar, Object obj) {
        if (com.tencent.mm.kernel.g.Do().CF()) {
            int p = bi.p(obj, 0);
            x.d("MicroMsg.CdnTransportService", "onNotifyChange event:%d obj:%d stg:%s", Integer.valueOf(i), Integer.valueOf(p), mVar);
            if (mVar != com.tencent.mm.kernel.g.Dq().Db() || p <= 0) {
                x.e("MicroMsg.CdnTransportService", "onNotifyChange error obj:%d stg:%s", Integer.valueOf(p), mVar);
            } else if (p == 144385) {
                g.MM().MR();
            }
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (kVar.getType() == 379) {
            x.d("MicroMsg.CdnTransportService", "cdntra onSceneEnd it will tryStart sceneType:%d [%d,%d]", Integer.valueOf(kVar.getType()), Integer.valueOf(i), Integer.valueOf(i2));
            if (com.tencent.mm.kernel.g.Do().CF()) {
                com.tencent.mm.kernel.g.Dt().F(new Runnable() {
                    public final void run() {
                        c.this.bL(true);
                    }

                    public final String toString() {
                        return super.toString() + "|onSceneEnd";
                    }
                });
            }
        }
    }

    public static boolean hx(int i) {
        com.tencent.mm.kernel.g.Do();
        if (!com.tencent.mm.kernel.a.CE()) {
            return true;
        }
        x.d("MicroMsg.CdnTransportService", "summersafecdn cdntra cdnBitSet:%d grayScaleFlag:%d res:%d Test.forceCDNTrans:%b", Integer.valueOf(bi.a((Integer) com.tencent.mm.kernel.g.Dq().Db().get(144385, null), 0)), Integer.valueOf(i), Integer.valueOf(bi.a((Integer) com.tencent.mm.kernel.g.Dq().Db().get(144385, null), 0) & i), Boolean.valueOf(r.ifH));
        if (r.ifH) {
            return true;
        }
        return (r0 & i) > 0;
    }

    public c() {
        com.tencent.mm.kernel.g.Dp().a(this.huc);
        if (com.tencent.mm.kernel.g.Do().CF()) {
            com.tencent.mm.kernel.g.Dq().Db().a(this);
        }
        com.tencent.mm.kernel.g.CN().a(379, (e) this);
        com.tencent.mm.sdk.b.a.xmy.b(this.hub);
        x.i("MicroMsg.CdnTransportService", "summersafecdn CdnTransportService init[%s] stack[%s]", Integer.valueOf(hashCode()), bi.chl());
    }

    public final boolean b(final i iVar, final int i) {
        if (iVar == null) {
            x.e("MicroMsg.CdnTransportService", "addRecvTask task info is null");
            return false;
        } else if (bi.oN(iVar.field_mediaId)) {
            x.e("MicroMsg.CdnTransportService", "addRecvTask mediaId is null");
            return false;
        } else {
            if (iVar.field_fileId == null) {
                iVar.field_fileId = "";
            }
            if (iVar.field_aesKey == null) {
                iVar.field_aesKey = "";
            }
            iVar.fMC = false;
            com.tencent.mm.kernel.g.Dt().F(new Runnable() {
                public final void run() {
                    if (i != -1) {
                        c.this.hug.put(iVar.field_mediaId, Integer.valueOf(i));
                    }
                    c.this.hud.add(iVar.field_mediaId);
                    c.this.hue.put(iVar.field_mediaId, iVar);
                    c.this.bL(false);
                }

                public final String toString() {
                    return super.toString() + "|addRecvTask";
                }
            });
            return true;
        }
    }

    public final boolean c(final i iVar) {
        if (bi.oN(iVar.field_mediaId)) {
            x.e("MicroMsg.CdnTransportService", "summersafecdn addSendTask mediaId is null");
            return false;
        }
        if (iVar.field_fileId == null) {
            iVar.field_fileId = "";
        }
        if (iVar.field_aesKey == null) {
            iVar.field_aesKey = "";
        }
        iVar.fMC = true;
        com.tencent.mm.kernel.g.Dt().F(new Runnable() {
            public final void run() {
                c.this.hud.add(iVar.field_mediaId);
                c.this.hue.put(iVar.field_mediaId, iVar);
                c.this.bL(false);
            }

            public final String toString() {
                return super.toString() + "|addSendTask";
            }
        });
        return true;
    }

    public final boolean kK(String str) {
        if (((i) this.huf.remove(str)) != null) {
            g.MQ();
            b.kC(str);
            g.pWK.h(10769, Integer.valueOf(d.huA), Integer.valueOf(r0.field_fileType), Long.valueOf(bi.Wy() - r0.field_startTime));
        }
        this.hue.remove(str);
        x.i("MicroMsg.CdnTransportService", "summersafecdn cdntra cancelSendTask mediaid:%s mapremove:%s engine ret:%d", str, r0, Integer.valueOf(0));
        return true;
    }

    public final boolean kL(String str) {
        i iVar = (i) this.huf.remove(str);
        if (iVar != null) {
            if (iVar.field_fileType == b.htG || iVar.field_fileType == b.htI) {
                g.MQ();
                b.kH(str);
            } else if (iVar.hvk) {
                g.MQ();
                b.kI(str);
            } else {
                g.MQ();
                b.kD(str);
            }
            g.pWK.h(10769, Integer.valueOf(d.huz), Integer.valueOf(iVar.field_fileType), Long.valueOf(bi.Wy() - iVar.field_startTime));
        }
        this.hue.remove(str);
        this.hug.remove(str);
        x.i("MicroMsg.CdnTransportService", "summersafecdn cdntra cancelRecvTask mediaid:%s mapremove:%s engine ret:%d", str, iVar, Integer.valueOf(0));
        return true;
    }

    public final void bL(boolean z) {
        if (!z && g.MQ().MJ()) {
            com.tencent.mm.kernel.g.Do();
            if (com.tencent.mm.kernel.a.CE()) {
                x.w("MicroMsg.CdnTransportService", "summersafecdn cdntra Not init cdn dnsinfo , will retry after set info");
                g.MM().MR();
                return;
            }
        }
        MK();
        x.i("MicroMsg.CdnTransportService", "summersafecdn tryStart queue:%d", Integer.valueOf(this.hud.size()));
        while (!this.hud.isEmpty()) {
            i iVar = (i) this.hue.remove((String) this.hud.poll());
            if (iVar == null) {
                x.e("MicroMsg.CdnTransportService", "summersafecdn task queue is empty , maybe bug here");
                return;
            }
            x.i("MicroMsg.CdnTransportService", "summersafecdn id:%s cdnautostart :%s chatroom:%s", iVar.field_mediaId, Boolean.valueOf(iVar.field_autostart), Integer.valueOf(iVar.field_chattype));
            iVar.field_startTime = bi.Wy();
            String str;
            int i;
            i iVar2;
            int b;
            String str2;
            Object[] objArr;
            if (iVar.fMC) {
                String str3;
                String str4 = "MicroMsg.CdnTransportService";
                str = "summersafecdn tryStart send file:%d thumb:%d, field_svr_signature[%s], field_aesKey[%s], field_fileType[%d], field_mediaId[%s], onlycheckexist[%b]";
                Object[] objArr2 = new Object[7];
                if (iVar.field_fullpath == null) {
                    i = -1;
                } else {
                    i = iVar.field_fullpath.length();
                }
                objArr2[0] = Integer.valueOf(i);
                if (iVar.field_thumbpath == null) {
                    i = -1;
                } else {
                    i = iVar.field_thumbpath.length();
                }
                objArr2[1] = Integer.valueOf(i);
                objArr2[2] = bi.Wz(iVar.field_svr_signature);
                objArr2[3] = bi.Wz(iVar.field_aesKey);
                objArr2[4] = Integer.valueOf(iVar.field_fileType);
                objArr2[5] = iVar.field_mediaId;
                objArr2[6] = Boolean.valueOf(iVar.field_onlycheckexist);
                x.i(str4, str, objArr2);
                if (iVar.field_fullpath == null) {
                    iVar.field_fullpath = "";
                }
                if (iVar.field_thumbpath == null) {
                    iVar.field_thumbpath = "";
                }
                iVar2 = (i) this.huf.put(iVar.field_mediaId, iVar);
                i iVar3 = (i) this.huf.get(iVar.field_mediaId);
                if (iVar3 == null) {
                    g.pWK.a(594, 5, 1, true);
                }
                g.MQ();
                b = b.b(iVar);
                str4 = "MicroMsg.CdnTransportService";
                str2 = "summersafecdn startupUploadMedia ok, field_mediaId[%s] ret[%s, %s, %s] hash[%s]";
                objArr = new Object[5];
                objArr[0] = iVar.field_mediaId;
                objArr[1] = Integer.valueOf(b);
                objArr[2] = iVar2 == null ? null : iVar2.field_mediaId;
                if (iVar3 == null) {
                    str3 = null;
                } else {
                    str3 = iVar3.field_mediaId;
                }
                objArr[3] = str3;
                objArr[4] = Integer.valueOf(hashCode());
                x.i(str4, str2, objArr);
                if (b != 0) {
                    iVar2 = (i) this.huf.remove(iVar.field_mediaId);
                    x.e("MicroMsg.CdnTransportService", "summersafecdn startupUploadMedia error:%d clientid:%s remove[%s]", Integer.valueOf(b), iVar.field_mediaId, iVar2);
                    if (iVar.hve != null) {
                        iVar.hve.a(iVar.field_mediaId, b, null, null, iVar.field_onlycheckexist);
                    }
                }
            } else {
                i = -1;
                int i2;
                if (iVar.field_fileType == b.htG || iVar.field_fileType == b.htI) {
                    if (!(iVar.field_fullpath == null || iVar.field_fullpath.isEmpty())) {
                        g.MQ();
                        i = b.a(iVar.field_mediaId, iVar.hvf, iVar.field_fullpath, iVar.field_fileType, iVar.hvg, iVar.hvh, iVar.hvi, iVar.hvj);
                    }
                    str = "MicroMsg.CdnTransportService";
                    str2 = "url download tryStart recv file:%d field_mediaId[%s], download_url[%s], filetype:[%d]";
                    objArr = new Object[4];
                    if (iVar.field_fullpath == null) {
                        i2 = -1;
                    } else {
                        i2 = iVar.field_fullpath.length();
                    }
                    objArr[0] = Integer.valueOf(i2);
                    objArr[1] = iVar.field_mediaId;
                    objArr[2] = iVar.hvf;
                    objArr[3] = Integer.valueOf(iVar.field_fileType);
                    x.i(str, str2, objArr);
                    b = i;
                } else if (iVar.hvk) {
                    if (!(iVar.field_fullpath == null || iVar.field_fullpath.isEmpty())) {
                        g.MQ();
                        i = b.a(iVar.field_mediaId, iVar.field_fullpath, iVar.hvf, iVar.hvl, iVar.hvm, iVar.allow_mobile_net_download, iVar.hvg, iVar.hvh, iVar.is_resume_task, iVar.hvi);
                    }
                    str = "MicroMsg.CdnTransportService";
                    str2 = "game package download tryStart recv file:%d field_mediaId[%s], download_url[%s] https url[%s]";
                    objArr = new Object[4];
                    if (iVar.field_fullpath == null) {
                        i2 = -1;
                    } else {
                        i2 = iVar.field_fullpath.length();
                    }
                    objArr[0] = Integer.valueOf(i2);
                    objArr[1] = iVar.field_mediaId;
                    objArr[2] = iVar.hvf;
                    objArr[3] = iVar.hvl;
                    x.i(str, str2, objArr);
                    b = i;
                } else {
                    if (!iVar.hvn) {
                        str = "MicroMsg.CdnTransportService";
                        str2 = "summersafecdn tryStart recv file:%d thumb:%d, field_svr_signature[%s], field_aesKey[%s], field_fileType[%d], field_mediaId[%s], onlycheckexist[%b]";
                        objArr = new Object[7];
                        if (iVar.field_fullpath == null) {
                            i2 = -1;
                        } else {
                            i2 = iVar.field_fullpath.length();
                        }
                        objArr[0] = Integer.valueOf(i2);
                        if (iVar.field_thumbpath == null) {
                            i2 = -1;
                        } else {
                            i2 = iVar.field_thumbpath.length();
                        }
                        objArr[1] = Integer.valueOf(i2);
                        objArr[2] = iVar.field_svr_signature;
                        objArr[3] = iVar.field_aesKey;
                        objArr[4] = Integer.valueOf(iVar.field_fileType);
                        objArr[5] = iVar.field_mediaId;
                        objArr[6] = Boolean.valueOf(iVar.field_onlycheckexist);
                        x.i(str, str2, objArr);
                        if (iVar.hvo != 2) {
                            g.MQ();
                            b = CdnLogic.startC2CDownload(b.a(iVar));
                        } else if (iVar instanceof j) {
                            j jVar = (j) iVar;
                            if (jVar.MT()) {
                                g.MQ();
                                b = b.a(iVar, 2);
                            } else {
                                if (jVar.MS()) {
                                    g.MQ();
                                    i = b.a(jVar.field_mediaId, jVar.url, jVar.referer, jVar.field_fullpath, jVar.hvu, jVar.huZ, jVar.initialDownloadOffset, jVar.initialDownloadLength, jVar.isColdSnsData, jVar.signalQuality, jVar.snsScene, jVar.field_preloadRatio);
                                }
                                b = i;
                            }
                        }
                    } else if (iVar instanceof h) {
                        h hVar = (h) iVar;
                        g.MQ();
                        b = b.a(hVar.field_mediaId, hVar.url, hVar.referer, hVar.huY, hVar.huZ, hVar.hva, hVar.hvb, hVar.hvc, hVar.isColdSnsData, hVar.signalQuality, hVar.snsScene, hVar.snsCipherKey, hVar.fXs, hVar.hvd, hVar.fileType);
                    }
                    b = -1;
                }
                if (b != 0) {
                    x.e("MicroMsg.CdnTransportService", "summersafecdn startupDownloadMedia error:%d clientid:%s", Integer.valueOf(b), iVar.field_mediaId);
                    if (iVar.hve != null) {
                        iVar.hve.a(iVar.field_mediaId, b, null, null, iVar.field_onlycheckexist);
                    }
                } else {
                    iVar2 = (i) this.huf.put(iVar.field_mediaId, iVar);
                    i iVar4 = (i) this.huf.get(iVar.field_mediaId);
                    if (iVar4 == null) {
                        g.pWK.a(594, 6, 1, true);
                    }
                    str2 = "MicroMsg.CdnTransportService";
                    String str5 = "summersafecdn startupDownloadMedia ok, field_mediaId[%s] ret[%s, %s, %s] hash[%s]";
                    Object[] objArr3 = new Object[5];
                    objArr3[0] = iVar.field_mediaId;
                    objArr3[1] = Integer.valueOf(b);
                    objArr3[2] = iVar2 == null ? null : iVar2.field_mediaId;
                    objArr3[3] = iVar4 == null ? null : iVar4.field_mediaId;
                    objArr3[4] = Integer.valueOf(hashCode());
                    x.i(str2, str5, objArr3);
                }
            }
        }
    }

    public static void MK() {
        com.tencent.mm.kernel.g.Do();
        if (com.tencent.mm.kernel.a.CE()) {
            c cVar = new c();
            String value = ((com.tencent.mm.plugin.zero.b.a) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.zero.b.a.class)).Af().getValue("EnableCDNUploadImg");
            String value2 = ((com.tencent.mm.plugin.zero.b.a) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.zero.b.a.class)).Af().getValue("EnableCDNVerifyConnect");
            String value3 = ((com.tencent.mm.plugin.zero.b.a) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.zero.b.a.class)).Af().getValue("EnableCDNVideoRedirectOC");
            String value4 = ((com.tencent.mm.plugin.zero.b.a) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.zero.b.a.class)).Af().getValue("EnableStreamUploadVideo");
            String value5 = ((com.tencent.mm.plugin.zero.b.a) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.zero.b.a.class)).Af().getValue("C2COverloadDelaySeconds");
            String value6 = ((com.tencent.mm.plugin.zero.b.a) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.zero.b.a.class)).Af().getValue("SNSOverloadDelaySeconds");
            String value7 = ((com.tencent.mm.plugin.zero.b.a) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.zero.b.a.class)).Af().getValue("EnableSnsStreamDownload");
            String value8 = ((com.tencent.mm.plugin.zero.b.a) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.zero.b.a.class)).Af().getValue("EnableSnsImageDownload");
            String value9 = ((com.tencent.mm.plugin.zero.b.a) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.zero.b.a.class)).Af().getValue("ApprovedVideoPrivateProtocolHosts");
            try {
                if (!bi.oN(value)) {
                    cVar.field_UseStreamCDN = Integer.valueOf(value).intValue();
                }
                if (!bi.oN(value2)) {
                    cVar.field_EnableCDNVerifyConnect = Integer.valueOf(value2).intValue();
                }
                if (!bi.oN(value3)) {
                    cVar.field_EnableCDNVideoRedirectOC = Integer.valueOf(value3).intValue();
                }
                if (!bi.oN(value4)) {
                    cVar.field_EnableStreamUploadVideo = Integer.valueOf(value4).intValue();
                }
                if (!bi.oN(value5)) {
                    cVar.field_C2COverloadDelaySeconds = Integer.valueOf(value5).intValue();
                }
                if (!bi.oN(value6)) {
                    cVar.field_SNSOverloadDelaySeconds = Integer.valueOf(value6).intValue();
                }
                if (!bi.oN(value7)) {
                    cVar.field_EnableSnsStreamDownload = Integer.valueOf(value7).intValue();
                }
                if (!bi.oN(value8)) {
                    cVar.field_EnableSnsImageDownload = Integer.valueOf(value8).intValue();
                }
                if (!bi.oN(value9)) {
                    cVar.field_ApprovedVideoHosts = value9;
                }
                g.MP();
                cVar.field_EnableSafeCDN = hx(256) ? 1 : 0;
                if (cVar.field_UseStreamCDN != 0) {
                    value = ((com.tencent.mm.plugin.zero.b.a) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.zero.b.a.class)).Af().getValue("ProgJPEGUploadSizeLimitWifi");
                    value2 = ((com.tencent.mm.plugin.zero.b.a) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.zero.b.a.class)).Af().getValue("ProgJPEGUploadSizeLimit3G");
                    value3 = ((com.tencent.mm.plugin.zero.b.a) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.zero.b.a.class)).Af().getValue("ProgJPEGDownloadSizeLimit");
                    value4 = ((com.tencent.mm.plugin.zero.b.a) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.zero.b.a.class)).Af().getValue("ProgJPEGOnlyRecvPTL");
                    value5 = ((com.tencent.mm.plugin.zero.b.a) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.zero.b.a.class)).Af().getValue("EnableJPEGDyncmicETL");
                    if (!bi.oN(value)) {
                        cVar.field_WifiEtl = Integer.valueOf(value).intValue();
                    }
                    if (!bi.oN(value2)) {
                        cVar.field_noWifiEtl = Integer.valueOf(value2).intValue();
                    }
                    if (!bi.oN(value3)) {
                        cVar.field_Ptl = Integer.valueOf(value3).intValue();
                    }
                    if (!bi.oN(value4)) {
                        cVar.field_onlyrecvPtl = Integer.valueOf(value4).intValue() != 0;
                    }
                    if (!bi.oN(value5)) {
                        cVar.field_UseDynamicETL = Integer.valueOf(value5).intValue();
                    }
                }
                x.i("MicroMsg.CdnTransportService", "summersafecdn streamcdn config[SVR]:%s", cVar);
                g.MQ();
                b.a(cVar);
            } catch (NumberFormatException e) {
                x.e("MicroMsg.CdnTransportService", e.toString());
            }
            if (r.igg) {
                int i;
                x.w("MicroMsg.CdnTransportService", "use cdn debug configure.");
                cVar.field_UseStreamCDN = r.igc ? 1 : 0;
                if (cVar.field_UseStreamCDN != 0) {
                    cVar.field_onlysendETL = r.igd;
                    cVar.field_onlyrecvPtl = r.ige;
                    if (!bi.oN(r.ifZ)) {
                        cVar.field_WifiEtl = Integer.valueOf(r.ifZ).intValue();
                    }
                    if (!bi.oN(r.iga)) {
                        cVar.field_noWifiEtl = Integer.valueOf(r.iga).intValue();
                    }
                    if (!bi.oN(r.igb)) {
                        cVar.field_Ptl = Integer.valueOf(r.igb).intValue();
                    }
                }
                cVar.field_EnableCDNVerifyConnect = r.igh ? 1 : 0;
                if (r.igi) {
                    i = 1;
                } else {
                    i = 0;
                }
                cVar.field_EnableCDNVideoRedirectOC = i;
                x.i("MicroMsg.CdnTransportService", "streamcdn config[DEBUG]:%s", cVar);
                g.MQ();
                b.a(cVar);
            }
        }
    }

    public final int a(final String str, final keep_ProgressInfo keep_progressinfo, final keep_SceneResult keep_sceneresult) {
        if (bi.oN(str)) {
            x.e("MicroMsg.CdnTransportService", "cdn callback mediaid is null mediaId:%s", str);
            return -1;
        } else if (keep_progressinfo == null && keep_sceneresult == null) {
            x.e("MicroMsg.CdnTransportService", "cdn callback info all null mediaId:%s", str);
            return -2;
        } else {
            boolean z;
            if (keep_progressinfo != null) {
                x.d("MicroMsg.CdnTransportService", "CDN progress. total:%d, cur:%d, canshow:%b", Integer.valueOf(keep_progressinfo.field_toltalLength), Integer.valueOf(keep_progressinfo.field_finishedLength), Boolean.valueOf(keep_progressinfo.field_mtlnotify));
            }
            long Wy = bi.Wy();
            String str2 = "MicroMsg.CdnTransportService";
            String str3 = "callback mediaId:%s, sceneResult is null:%b";
            Object[] objArr = new Object[2];
            objArr[0] = str;
            if (keep_sceneresult == null) {
                z = true;
            } else {
                z = false;
            }
            objArr[1] = Boolean.valueOf(z);
            x.i(str2, str3, objArr);
            this.hui = Wy;
            this.huh = str;
            com.tencent.mm.kernel.g.Dt().F(new Runnable() {
                public final void run() {
                    int i = 0;
                    i iVar = (i) c.this.huf.get(str);
                    if (iVar == null) {
                        x.e("MicroMsg.CdnTransportService", " task in jni get info failed mediaid[%s] hash[%s]", str, Integer.valueOf(c.this.hashCode()));
                        g.pWK.a(594, 7, 1, true);
                        return;
                    }
                    if (keep_progressinfo != null) {
                        keep_progressinfo.mediaId = str;
                        x.i("MicroMsg.CdnTransportService", "MTL: total:%d, cur:%d, mtl:%b", Integer.valueOf(keep_progressinfo.field_toltalLength), Integer.valueOf(keep_progressinfo.field_finishedLength), Boolean.valueOf(keep_progressinfo.field_mtlnotify));
                    }
                    if (keep_sceneresult != null) {
                        keep_sceneresult.mediaId = str;
                    }
                    if (iVar.hve != null) {
                        long Wy = bi.Wy();
                        if (keep_sceneresult != null || keep_progressinfo == null || keep_progressinfo.field_mtlnotify || ao.getNetWorkType(ad.getContext()) != -1) {
                            iVar.field_lastProgressCallbackTime = Wy;
                            iVar.hve.a(str, 0, keep_progressinfo, keep_sceneresult, iVar.field_onlycheckexist);
                        } else {
                            x.e("MicroMsg.CdnTransportService", "callback sceneResult is null and no network, %s", str);
                            return;
                        }
                    }
                    x.e("MicroMsg.CdnTransportService", "taskCallback is null:%s", str);
                    keep_ProgressInfo keep_progressinfo = keep_progressinfo;
                    if (keep_progressinfo == null || keep_progressinfo.field_finishedLength == keep_progressinfo.field_toltalLength) {
                        i = 1;
                    }
                    if (i != 0) {
                        c.this.hug.remove(str);
                    }
                    if (keep_sceneresult != null) {
                        c.this.huf.remove(str);
                        if (keep_sceneresult.field_retCode == -5103011) {
                            x.i("MicroMsg.CdnTransportService", "summersafecdn ERR_VALIDATE_AUTHKEY");
                            g.pWK.a(546, 4, 1, true);
                            g.MQ().keep_OnRequestDoGetCdnDnsInfo(999);
                        }
                    }
                }

                public final String toString() {
                    return super.toString() + "|callback";
                }
            });
            return 0;
        }
    }

    public final void a(String str, ByteArrayOutputStream byteArrayOutputStream) {
        if (bi.oN(str)) {
            x.e("MicroMsg.CdnTransportService", "cdn callback getauthbuf mediaid is null");
            return;
        }
        i iVar = (i) this.huf.get(str);
        if (iVar == null) {
            x.e("MicroMsg.CdnTransportService", " getauthbuf task in jni get info failed mediaid:%s", str);
        } else if (iVar.hve != null) {
            iVar.hve.a(str, byteArrayOutputStream);
        } else {
            x.e("MicroMsg.CdnTransportService", "getCdnAuthInfo fail, null taskcallback.");
        }
    }

    public final byte[] h(String str, byte[] bArr) {
        if (bi.oN(str)) {
            x.e("MicroMsg.CdnTransportService", "cdn callback decodePrepareResponse mediaid is null");
            return null;
        }
        i iVar = (i) this.huf.get(str);
        if (iVar == null) {
            x.e("MicroMsg.CdnTransportService", " decodePrepareResponse task in jni get info failed mediaid:%s", str);
            return null;
        } else if (iVar.hve != null) {
            return iVar.hve.h(str, bArr);
        } else {
            x.e("MicroMsg.CdnTransportService", "decodePrepareResponse fail, null taskcallback.");
            return null;
        }
    }

    public final void b(final String str, final keep_SceneResult keep_sceneresult) {
        if (!bi.oN(str)) {
            com.tencent.mm.kernel.g.Dt().F(new Runnable() {
                public final void run() {
                    i iVar = (i) c.this.huf.get(str);
                    if (iVar == null) {
                        x.d("MicroMsg.CdnTransportService", " task in jni get info failed mediaid:%s", str);
                    } else if (iVar.hvq != null) {
                        iVar.hvq.b(str, keep_sceneresult);
                    }
                }
            });
        }
    }
}
