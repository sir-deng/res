package com.tencent.mm.modelvideo;

import com.tencent.mm.BuildConfig;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.f.b.cg;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelcdntran.b;
import com.tencent.mm.modelcdntran.c;
import com.tencent.mm.modelcdntran.d;
import com.tencent.mm.modelcdntran.i;
import com.tencent.mm.modelcdntran.keep_ProgressInfo;
import com.tencent.mm.modelcdntran.keep_SceneResult;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bj;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.y.bb;
import com.tencent.mm.y.s;
import com.tencent.wcdb.database.SQLiteGlobal;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class m {
    private static int fmp = 0;
    private boolean fml = false;
    private boolean fmm = false;
    int fmn = 0;
    private com.tencent.mm.compatible.util.g.a fmr = new com.tencent.mm.compatible.util.g.a();
    private al fms = new al(g.Dt().oFY.getLooper(), new com.tencent.mm.sdk.platformtools.al.a() {
        public final boolean uG() {
            m.h(m.this);
            return false;
        }

        public final String toString() {
            return super.toString() + "|scenePusher";
        }
    }, false);
    private LinkedList<Long> hWB = new LinkedList();
    private Map<Long, com.tencent.mm.compatible.util.g.a> hWC = new HashMap();
    private Map<Long, String> hWD = new HashMap();
    private Object hWE = new Object();
    String hWF;

    /* renamed from: com.tencent.mm.modelvideo.m$5 */
    class AnonymousClass5 implements Runnable {
        final /* synthetic */ long hWG;

        public AnonymousClass5(long j) {
            this.hWG = j;
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void run() {
            /*
            r10 = this;
            r0 = com.tencent.mm.modelvideo.m.this;
            r8 = r0.hWE;
            monitor-enter(r8);
            r0 = com.tencent.mm.modelvideo.m.this;	 Catch:{ all -> 0x00b1 }
            r0 = r0.hWD;	 Catch:{ all -> 0x00b1 }
            r2 = r10.hWG;	 Catch:{ all -> 0x00b1 }
            r1 = java.lang.Long.valueOf(r2);	 Catch:{ all -> 0x00b1 }
            r0 = r0.get(r1);	 Catch:{ all -> 0x00b1 }
            r0 = (java.lang.String) r0;	 Catch:{ all -> 0x00b1 }
            r1 = "MicroMsg.SightMassSendService";
            r2 = "cancel item, massSendId %d, cdnClientId %s";
            r3 = 2;
            r3 = new java.lang.Object[r3];	 Catch:{ all -> 0x00b1 }
            r4 = 0;
            r6 = r10.hWG;	 Catch:{ all -> 0x00b1 }
            r5 = java.lang.Long.valueOf(r6);	 Catch:{ all -> 0x00b1 }
            r3[r4] = r5;	 Catch:{ all -> 0x00b1 }
            r4 = 1;
            r3[r4] = r0;	 Catch:{ all -> 0x00b1 }
            com.tencent.mm.sdk.platformtools.x.i(r1, r2, r3);	 Catch:{ all -> 0x00b1 }
            r1 = "done_upload_cdn_client_id";
            r1 = r1.equals(r0);	 Catch:{ all -> 0x00b1 }
            if (r1 == 0) goto L_0x0045;
        L_0x003a:
            r0 = "MicroMsg.SightMassSendService";
            r1 = "doing mass send cgi, ignore cancel!";
            com.tencent.mm.sdk.platformtools.x.w(r0, r1);	 Catch:{ all -> 0x00b1 }
            monitor-exit(r8);	 Catch:{ all -> 0x00b1 }
        L_0x0044:
            return;
        L_0x0045:
            r1 = com.tencent.mm.sdk.platformtools.bi.oN(r0);	 Catch:{ all -> 0x00b1 }
            if (r1 != 0) goto L_0x006d;
        L_0x004b:
            r1 = com.tencent.mm.modelvideo.m.this;	 Catch:{ all -> 0x00b1 }
            r1 = r1.hWD;	 Catch:{ all -> 0x00b1 }
            r2 = r10.hWG;	 Catch:{ all -> 0x00b1 }
            r2 = java.lang.Long.valueOf(r2);	 Catch:{ all -> 0x00b1 }
            r3 = "";
            r1.put(r2, r3);	 Catch:{ all -> 0x00b1 }
            r1 = com.tencent.mm.modelcdntran.g.MP();	 Catch:{ all -> 0x00b1 }
            r1.kK(r0);	 Catch:{ all -> 0x00b1 }
            r0 = com.tencent.mm.modelvideo.m.this;	 Catch:{ all -> 0x00b1 }
            r2 = r10.hWG;	 Catch:{ all -> 0x00b1 }
            r1 = 0;
            r4 = 0;
            r0.d(r2, r1, r4);	 Catch:{ all -> 0x00b1 }
        L_0x006d:
            r0 = com.tencent.mm.modelvideo.o.Ub();	 Catch:{ all -> 0x00b1 }
            r6 = r10.hWG;	 Catch:{ all -> 0x00b1 }
            r1 = r0.hiZ;	 Catch:{ all -> 0x00b1 }
            r2 = "videoinfo2";
            r3 = "masssendid= ?";
            r4 = 1;
            r4 = new java.lang.String[r4];	 Catch:{ all -> 0x00b1 }
            r5 = 0;
            r9 = java.lang.String.valueOf(r6);	 Catch:{ all -> 0x00b1 }
            r4[r5] = r9;	 Catch:{ all -> 0x00b1 }
            r1 = r1.delete(r2, r3, r4);	 Catch:{ all -> 0x00b1 }
            if (r1 <= 0) goto L_0x00af;
        L_0x008b:
            r1 = new com.tencent.mm.modelvideo.s$a$a;	 Catch:{ all -> 0x00b1 }
            r2 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00b1 }
            r3 = "DELETE_";
            r2.<init>(r3);	 Catch:{ all -> 0x00b1 }
            r2 = r2.append(r6);	 Catch:{ all -> 0x00b1 }
            r2 = r2.toString();	 Catch:{ all -> 0x00b1 }
            r3 = com.tencent.mm.modelvideo.s.a.b.hXO;	 Catch:{ all -> 0x00b1 }
            r4 = com.tencent.mm.modelvideo.s.a.c.NORMAL;	 Catch:{ all -> 0x00b1 }
            r5 = 3;
            r1.<init>(r2, r3, r4, r5, r6);	 Catch:{ all -> 0x00b1 }
            r2 = r0.hmJ;	 Catch:{ all -> 0x00b1 }
            r2.cb(r1);	 Catch:{ all -> 0x00b1 }
            r0 = r0.hmJ;	 Catch:{ all -> 0x00b1 }
            r0.doNotify();	 Catch:{ all -> 0x00b1 }
        L_0x00af:
            monitor-exit(r8);	 Catch:{ all -> 0x00b1 }
            goto L_0x0044;
        L_0x00b1:
            r0 = move-exception;
            monitor-exit(r8);	 Catch:{ all -> 0x00b1 }
            throw r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.modelvideo.m.5.run():void");
        }
    }

    /* renamed from: com.tencent.mm.modelvideo.m$1 */
    class AnonymousClass1 implements Runnable {
        final /* synthetic */ long hWG;

        AnonymousClass1(long j) {
            this.hWG = j;
        }

        public final void run() {
            long j = 0;
            m.TX();
            m.this.fml = false;
            m.this.hWF = "";
            if (this.hWG > 0 && m.this.hWC.get(Long.valueOf(this.hWG)) != null) {
                j = ((com.tencent.mm.compatible.util.g.a) m.this.hWC.get(Long.valueOf(this.hWG))).zp();
            }
            x.d("MicroMsg.SightMassSendService", "onJobEnd ok massSendId:" + this.hWG + " time:" + j + " inCnt:" + m.fmp + " stop:" + m.this.fmn + " running:" + m.this.fmm + " sending:" + m.this.fml);
            if (m.this.fmn > 0) {
                m.h(m.this);
            } else if (!m.this.fml) {
                m.this.vC();
            }
            m.TY();
        }

        public final String toString() {
            return super.toString() + "|onSceneEnd";
        }
    }

    private final class a implements e, com.tencent.mm.modelcdntran.i.a {
        long hVO;
        r hVP;
        String hWI;
        List<r> hkg;
        long startTime;

        private a() {
        }

        /* synthetic */ a(m mVar, byte b) {
            this();
        }

        public final int a(String str, int i, keep_ProgressInfo keep_progressinfo, keep_SceneResult keep_sceneresult, boolean z) {
            x.d("MicroMsg.SightMassSendService", "cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", this.hWI, Integer.valueOf(i), keep_progressinfo, keep_sceneresult);
            if (i == -21005) {
                x.d("MicroMsg.SightMassSendService", "cdntra  ERR_CNDCOM_MEDIA_IS_UPLOADING clientid:%s", this.hWI);
                return 0;
            } else if (i != 0) {
                m.V(this.hkg);
                x.e("MicroMsg.SightMassSendService", "upload to CDN error, massSendId %d, errCode %d", Long.valueOf(this.hVO), Integer.valueOf(i));
                com.tencent.mm.plugin.report.service.g.pWK.h(10421, Integer.valueOf(i), Integer.valueOf(1), Long.valueOf(this.startTime), Long.valueOf(bi.Wy()), Integer.valueOf(d.bi(ad.getContext())), Integer.valueOf(b.MediaType_TinyVideo), Integer.valueOf(0), "");
                m.this.d(this.hVO, 3, i);
                return 0;
            } else if (keep_progressinfo != null) {
                x.v("MicroMsg.SightMassSendService", "progress length %d", Integer.valueOf(keep_progressinfo.field_finishedLength));
                for (r rVar : this.hkg) {
                    rVar.hXt = bi.Wx();
                    rVar.hWd = keep_progressinfo.field_finishedLength;
                    rVar.fEo = 1032;
                    t.e(rVar);
                }
                return 0;
            } else {
                if (keep_sceneresult != null) {
                    if (keep_sceneresult.field_retCode != 0) {
                        x.e("MicroMsg.SightMassSendService", "cdntra sceneResult.retCode :%d arg[%s] info[%s], massSendId[%d]", Integer.valueOf(keep_sceneresult.field_retCode), keep_sceneresult.field_arg, keep_sceneresult.field_transInfo, Long.valueOf(this.hVO));
                        m.V(this.hkg);
                        com.tencent.mm.plugin.report.service.g.pWK.h(10421, Integer.valueOf(keep_sceneresult.field_retCode), Integer.valueOf(1), Long.valueOf(this.startTime), Long.valueOf(bi.Wy()), Integer.valueOf(d.bi(ad.getContext())), Integer.valueOf(b.MediaType_TinyVideo), Integer.valueOf(keep_sceneresult.field_fileLength), keep_sceneresult.field_transInfo, "", "", "", "", "", "", "", keep_sceneresult.report_Part2);
                        com.tencent.mm.plugin.report.service.g.pWK.h(13937, Integer.valueOf(keep_sceneresult.field_retCode), Integer.valueOf(1), Long.valueOf(this.startTime), Long.valueOf(bi.Wy()), Integer.valueOf(d.bi(ad.getContext())), Integer.valueOf(b.MediaType_TinyVideo), Integer.valueOf(keep_sceneresult.field_fileLength), keep_sceneresult.field_transInfo, "", "", "", "", "", "", "", keep_sceneresult.report_Part2);
                        m.this.d(this.hVO, 3, keep_sceneresult.field_retCode);
                    } else {
                        x.i("MicroMsg.SightMassSendService", "uploadvideo by cdn, isHitCacheUpload[%d] massSendId[%d]", Integer.valueOf(keep_sceneresult.field_UploadHitCacheType), Long.valueOf(this.hVO));
                        x.i("MicroMsg.SightMassSendService", "cdn callback new build cdnInfo:%s", ((("<msg><videomsg aeskey=\"" + keep_sceneresult.field_aesKey + "\" cdnthumbaeskey=\"" + keep_sceneresult.field_aesKey + "\" cdnvideourl=\"" + keep_sceneresult.field_fileId + "\" ") + "cdnthumburl=\"" + keep_sceneresult.field_fileId + "\" ") + "length=\"" + keep_sceneresult.field_fileLength + "\" ") + "cdnthumblength=\"" + keep_sceneresult.field_thumbimgLength + "\"/></msg>");
                        for (r rVar2 : this.hkg) {
                            if (bi.oN(rVar2.Un())) {
                                rVar2.hXB = r1;
                                rVar2.fEo = 2097152;
                                boolean e = t.e(rVar2);
                                x.i("MicroMsg.SightMassSendService", "massSendId[%d] info %s, update recv xml ret %B", Long.valueOf(this.hVO), rVar2.getFileName(), Boolean.valueOf(e));
                            }
                        }
                        synchronized (m.this.hWE) {
                            if (bi.oN((String) m.this.hWD.get(Long.valueOf(this.hVO)))) {
                                x.i("MicroMsg.SightMassSendService", "check cdn client id FAIL do NOTHING, massSendId %d, oldClientId %s, selfClientId %s", Long.valueOf(this.hVO), (String) m.this.hWD.get(Long.valueOf(this.hVO)), this.hWI);
                            } else {
                                x.i("MicroMsg.SightMassSendService", "check cdn client id ok do MASS SEND, massSendId %d, oldClientId %s, selfClientId %s", Long.valueOf(this.hVO), (String) m.this.hWD.get(Long.valueOf(this.hVO)), this.hWI);
                                m.this.hWD.put(Long.valueOf(this.hVO), "done_upload_cdn_client_id");
                                g.CN().a(245, (e) this);
                                if (!g.CN().a(new e(this.hVO, this.hVP, keep_sceneresult, this.hWI), 0)) {
                                    x.e("MicroMsg.SightMassSendService", "try to do NetSceneMassUploadSight fail");
                                    g.CN().b(245, (e) this);
                                    m.this.d(this.hVO, 3, 0);
                                }
                            }
                        }
                    }
                }
                return 0;
            }
        }

        public final void a(String str, ByteArrayOutputStream byteArrayOutputStream) {
        }

        public final byte[] h(String str, byte[] bArr) {
            return null;
        }

        public final void a(int i, int i2, String str, k kVar) {
            g.CN().b(245, (e) this);
            if (i == 4 && i2 == -22) {
                x.e("MicroMsg.SightMassSendService", "ERR: onGYNetEnd BLACK  errtype:" + i + " errCode:" + i2 + " massSendId:" + this.hVO);
                m.W(this.hkg);
                m.this.d(this.hVO, i, i2);
            } else if (i == 4 && i2 != 0) {
                x.e("MicroMsg.SightMassSendService", "ERR: onGYNetEnd SERVER FAILED errtype:" + i + " errCode:" + i2 + "  massSendId:" + this.hVO);
                m.V(this.hkg);
                m.this.d(this.hVO, i, i2);
            } else if (i == 0 && i2 == 0) {
                for (r rVar : this.hkg) {
                    rVar.hXt = bi.Wx();
                    rVar.status = 199;
                    rVar.fEo = BuildConfig.VERSION_CODE;
                    if (t.e(rVar)) {
                        if (rVar == null) {
                            x.e("MicroMsg.VideoLogic", "video info is null");
                        } else if (rVar.hXw > 0) {
                            au dI = ((h) g.h(h.class)).aZO().dI((long) rVar.hXw);
                            int type = dI.getType();
                            x.i("MicroMsg.VideoLogic", "ashutest::updateWriteFinMassMsgInfo, msg type %d", Integer.valueOf(type));
                            if (43 == type || 62 == type) {
                                dI.eS(1);
                                dI.dU(rVar.Uk());
                                dI.ap(rVar.fGj);
                                dI.eR(2);
                                dI.setContent(p.b(rVar.Ul(), (long) rVar.hXv, false));
                                ((h) g.h(h.class)).aZO().a((long) rVar.hXw, dI);
                                x.d("MicroMsg.VideoLogic", "updateWriteFinMassMsgInfo msgId:%d", Long.valueOf(dI.field_msgId));
                            }
                        } else {
                            cg auVar = new au();
                            auVar.dU(rVar.Uk());
                            auVar.setType(62);
                            auVar.eS(1);
                            auVar.dV(rVar.getFileName());
                            auVar.eR(2);
                            auVar.aq(bb.hU(rVar.Uk()));
                            rVar.hXw = (int) bb.i(auVar);
                            rVar.fEo = 8192;
                            t.e(rVar);
                            x.d("MicroMsg.VideoLogic", "updateWriteFinMassMsgInfo insert msgId:%d", Long.valueOf(auVar.field_msgId));
                        }
                    }
                    x.v("MicroMsg.SightMassSendService", "massSendId %d, file %s, set status %d", Long.valueOf(this.hVO), rVar.getFileName(), Integer.valueOf(199));
                }
                g.Dt().F(new AnonymousClass1(this.hVO));
            } else {
                x.e("MicroMsg.SightMassSendService", "ERR: onGYNetEnd FAILED (WILL RETRY) errtype:" + i + " errCode:" + i2 + "  massSendId:" + this.hVO);
                m.V(this.hkg);
                m.this.d(this.hVO, i, i2);
            }
        }
    }

    static /* synthetic */ int TX() {
        int i = fmp;
        fmp = i + 1;
        return i;
    }

    static /* synthetic */ int TY() {
        int i = fmp;
        fmp = i - 1;
        return i;
    }

    static /* synthetic */ void h(m mVar) {
        if (!mVar.fml && mVar.hWB.isEmpty()) {
            List<r> Us = o.Ub().Us();
            if (Us.isEmpty()) {
                x.d("MicroMsg.SightMassSendService", "unfinish massinfo count 0");
            } else {
                long currentTimeMillis = System.currentTimeMillis() / 1000;
                for (r rVar : Us) {
                    if (mVar.hWC.containsKey(Long.valueOf(rVar.hVO))) {
                        x.d("MicroMsg.SightMassSendService", "Mass Send File is Already running %s, massSendId %d", rVar.getFileName(), Long.valueOf(rVar.hVO));
                    } else {
                        x.d("MicroMsg.SightMassSendService", "Get file:" + rVar.getFileName() + " status:" + rVar.status + " user" + rVar.Uk() + " human:" + rVar.Ul() + " massSendId:" + rVar.hVO + " massSendList:" + rVar.hXD + " create:" + bi.fK(rVar.hXs) + " last:" + bi.fK(rVar.hXt) + " now:" + bi.fK(currentTimeMillis) + " " + (currentTimeMillis - rVar.hXt));
                        if (rVar.status == 200) {
                            mVar.hWB.offer(Long.valueOf(rVar.hVO));
                            mVar.hWC.put(Long.valueOf(rVar.hVO), null);
                        }
                    }
                }
                x.d("MicroMsg.SightMassSendService", "GetNeedRun procing:" + mVar.hWC.size() + " [send:" + mVar.hWB.size() + "]");
                mVar.hWB.size();
            }
        }
        if (!mVar.fml && mVar.hWB.isEmpty()) {
            mVar.vC();
            x.d("MicroMsg.SightMassSendService", "No Data Any More , Stop Service");
        } else if (!mVar.fml && mVar.hWB.size() > 0) {
            Long l = (Long) mVar.hWB.poll();
            x.d("MicroMsg.SightMassSendService", "Start Mass Send, ID: %s", l);
            if (l != null) {
                mVar.hWC.put(l, new com.tencent.mm.compatible.util.g.a());
                mVar.fml = true;
                mVar.hWF = mVar.bt(l.longValue());
                if (mVar.hWF == null) {
                    mVar.fml = false;
                    mVar.fms.K(10, 10);
                    return;
                }
                mVar.hWD.put(l, mVar.hWF);
            }
        }
    }

    public static void V(List<r> list) {
        if (list != null && !list.isEmpty()) {
            for (r fileName : list) {
                t.nC(fileName.getFileName());
            }
        }
    }

    public static void W(List<r> list) {
        if (list != null && !list.isEmpty()) {
            for (r fileName : list) {
                t.nD(fileName.getFileName());
            }
        }
    }

    private String bt(long j) {
        List<r> bu = o.Ub().bu(j);
        if (bu.isEmpty()) {
            x.e("MicroMsg.SightMassSendService", "check use cdn fail: mass send video list empty");
            return null;
        }
        r rVar;
        for (r rVar2 : bu) {
            if (s.hr(rVar2.Uk())) {
                x.w("MicroMsg.SightMassSendService", "cdntra not use cdn user:%s, list %s, massSendId %d", rVar2.Uk(), rVar2.hXD, Long.valueOf(j));
                return null;
            }
            com.tencent.mm.modelcdntran.g.MP();
            if (!c.hx(2) && rVar2.hXA != 1) {
                r5 = new Object[4];
                com.tencent.mm.modelcdntran.g.MP();
                r5[0] = Boolean.valueOf(c.hx(2));
                r5[1] = Integer.valueOf(rVar2.hXA);
                r5[2] = rVar2.hXD;
                r5[3] = Long.valueOf(j);
                x.w("MicroMsg.SightMassSendService", "cdntra not use cdn flag:%b getCdnInfo:%d, list %s, massSendId %d", r5);
                return null;
            }
        }
        if (bu == null || bu.isEmpty()) {
            rVar2 = null;
        } else {
            for (int i = 0; i < bu.size(); i++) {
                r nJ = t.nJ(((r) bu.get(i)).getFileName());
                if (nJ != null) {
                    x.i("MicroMsg.SightMassSendService", "check %s ok, index %d, size %d, massSendId %d, massSendList %s", rVar2.getFileName(), Integer.valueOf(i), Integer.valueOf(bu.size()), Long.valueOf(j), rVar2.hXD);
                    bu.remove(i);
                    bu.add(i, nJ);
                    rVar2 = nJ;
                    break;
                }
                x.w("MicroMsg.SightMassSendService", "check %s fail, index %d, size %d, massSendId %d, massSendList %s", rVar2.getFileName(), Integer.valueOf(i), Integer.valueOf(bu.size()), Long.valueOf(j), rVar2.hXD);
            }
            rVar2 = null;
        }
        if (rVar2 == null) {
            x.w("MicroMsg.SightMassSendService", "check use cdn fail: no valid info");
            return null;
        }
        String a = d.a("upvideo", rVar2.hXs, rVar2.hXD, rVar2.getFileName());
        if (bi.oN(a)) {
            x.w("MicroMsg.SightMassSendService", "cdntra genClientId failed not use cdn file:%s, massSendId %d, massSendList %s", rVar2.getFileName(), Long.valueOf(rVar2.hVO), rVar2.hXD);
            return null;
        }
        String fileName = rVar2.getFileName();
        o.Ub();
        String ny = s.ny(fileName);
        o.Ub();
        fileName = s.nx(fileName);
        com.tencent.mm.modelcdntran.i.a aVar = new a();
        aVar.hkg = bu;
        aVar.hVO = j;
        aVar.hWI = a;
        aVar.startTime = bi.Wy();
        aVar.hVP = rVar2;
        i iVar = new i();
        iVar.hve = aVar;
        iVar.field_mediaId = a;
        iVar.field_fullpath = fileName;
        iVar.field_thumbpath = ny;
        iVar.field_fileType = b.MediaType_VIDEO;
        iVar.field_smallVideoFlag = 1;
        iVar.field_talker = rVar2.hXD;
        iVar.field_priority = b.htu;
        iVar.field_needStorage = false;
        iVar.field_isStreamMedia = false;
        Map y = bj.y(rVar2.Un(), "msg");
        if (y != null) {
            iVar.field_fileId = (String) y.get(".msg.videomsg.$cdnvideourl");
            iVar.field_aesKey = (String) y.get(".msg.videomsg.$aeskey");
        } else {
            x.i("MicroMsg.SightMassSendService", "cdntra parse video recv xml failed");
        }
        if (com.tencent.mm.modelcdntran.g.MP().c(iVar)) {
            for (r rVar22 : bu) {
                if (rVar22.hXA != 1) {
                    rVar22.hXA = 1;
                    rVar22.fEo = SQLiteGlobal.journalSizeLimit;
                    boolean e = t.e(rVar22);
                    x.i("MicroMsg.SightMassSendService", "update %s useCDN, result %B", rVar22.getFileName(), Boolean.valueOf(e));
                }
            }
            return a;
        }
        x.e("MicroMsg.SightMassSendService", "cdntra addSendTask failed.");
        return null;
    }

    public final void d(long j, int i, int i2) {
        final long j2 = j;
        final int i3 = i;
        final int i4 = i2;
        g.Dt().F(new Runnable() {
            public final void run() {
                m.TX();
                m.this.fml = false;
                m.this.hWF = "";
                long j = 0;
                if (j2 > 0 && m.this.hWC.get(Long.valueOf(j2)) != null) {
                    j = ((com.tencent.mm.compatible.util.g.a) m.this.hWC.get(Long.valueOf(j2))).zp();
                }
                x.i("MicroMsg.SightMassSendService", "on ERROR massSendId: %d time: %d errType %d errCode %d", Long.valueOf(j2), Long.valueOf(j), Integer.valueOf(i3), Integer.valueOf(i4));
                if (!(i3 == 0 && i4 == 0)) {
                    m.this.fmn = m.this.fmn - 1;
                }
                x.i("MicroMsg.SightMassSendService", "onSceneEnd  inCnt: %d stop: %d running: %B sending: %B", Integer.valueOf(m.fmp), Integer.valueOf(m.this.fmn), Boolean.valueOf(m.this.fmm), Boolean.valueOf(m.this.fml));
                if (m.this.fmn > 0) {
                    m.h(m.this);
                } else if (!m.this.fml) {
                    x.w("MicroMsg.SightMassSendService", "StopFlag ERROR force do stop, fail all job");
                    s Ub = o.Ub();
                    List k = m.this.hWB;
                    if (!(k == null || k.isEmpty())) {
                        long currentTimeMillis = System.currentTimeMillis() / 1000;
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append('(');
                        for (int i = 0; i < k.size() - 1; i++) {
                            stringBuilder.append((Long) k.get(i));
                            stringBuilder.append(',');
                        }
                        Long l = (Long) k.get(k.size() - 1);
                        if (l != null) {
                            stringBuilder.append(l);
                        }
                        stringBuilder.append(')');
                        x.i("MicroMsg.VideoInfoStorage", "fail all massSendInfos, sql %s", "UPDATE videoinfo2 SET status=198, lastmodifytime=" + currentTimeMillis + " WHERE masssendid IN " + stringBuilder.toString());
                        Ub.hiZ.fD("videoinfo2", r0);
                    }
                    m.this.vC();
                }
                m.TY();
            }

            public final String toString() {
                return super.toString() + "|onSceneEnd";
            }
        });
    }

    private void vC() {
        this.hWD.clear();
        this.hWC.clear();
        this.hWB.clear();
        this.fml = false;
        this.fmm = false;
        x.d("MicroMsg.SightMassSendService", "Finish service use time(ms):" + this.fmr.zp());
    }
}
