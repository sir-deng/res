package com.tencent.mm.insane_statistic;

import com.tencent.mm.ap.e;
import com.tencent.mm.f.a.mr;
import com.tencent.mm.f.a.ms;
import com.tencent.mm.f.a.mt;
import com.tencent.mm.modelcdntran.keep_SceneResult;
import com.tencent.mm.modelsns.d;
import com.tencent.mm.modelstat.o;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.bsg;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.y.m;
import java.net.URLEncoder;

public final class b implements com.tencent.mm.ap.r.a {

    private static class a {
        au fou = null;
        final com.tencent.mm.ad.b gLB;
        long gNA;
        int gNB;
        e gNC;
        String gND;
        boolean gNE = false;
        String gNF;
        int gNG = 0;
        keep_SceneResult gNH;
        boolean gNI = false;
        c gNJ = new c<mt>() {
            {
                this.xmG = mt.class.getName().hashCode();
            }

            private boolean a(mt mtVar) {
                if (mtVar.fFy.filePath.equals(a.this.gNF)) {
                    String encode;
                    String str = "";
                    try {
                        encode = URLEncoder.encode(mtVar.fFy.result, "UTF-8");
                    } catch (Throwable e) {
                        x.printErrStackTrace("MicroMsg.OnNetSceneUploadMsgImgEnd", e, "", new Object[0]);
                        encode = str;
                    }
                    if (a.this.gNI) {
                        x.i("MicroMsg.OnNetSceneUploadMsgImgEnd", "androidSystemShareFixed(13717) , imgLocalId:%d, scene.hash:%d, %s, filePath:%s", Long.valueOf(a.this.gNA), Integer.valueOf(a.this.hashCode()), a.this.gND + encode, mtVar.fFy.filePath);
                        g.pWK.k(13717, str);
                    }
                    if (a.this.gNG == 1) {
                        d dVar = new d();
                        bsg bsg = (bsg) a.this.gLB.hnQ.hnY;
                        dVar.q("20toUser", bsg.vNN.wRo + ",");
                        dVar.q("21source", a.this.gNB + ",");
                        dVar.q("22qrUrl", encode + ",");
                        dVar.q("23md5", (a.this.gNH == null ? "" : a.this.gNH.field_filemd5) + ",");
                        dVar.q("24cdnFileId", (a.this.gNH == null ? "" : a.this.gNH.field_fileId) + ",");
                        dVar.q("25cdnAesKey", (a.this.gNH == null ? "" : a.this.gNH.field_aesKey) + ",");
                        encode = "";
                        if (a.this.fou.aNJ()) {
                            com.tencent.mm.x.g.a fV = com.tencent.mm.x.g.a.fV(a.this.fou.field_content);
                            if (fV != null) {
                                encode = fV.appId;
                            }
                        }
                        dVar.q("26appip", encode + ",");
                        dVar.q("27toUsersCount", m.gn(bsg.vNN.wRo) + ",");
                        dVar.q("28codeType", Integer.valueOf(mtVar.fFy.fqW));
                        x.i("MicroMsg.OnNetSceneUploadMsgImgEnd", "report qrCodeImgChatting(13628): " + dVar.SG());
                        o.w(13628, dVar.toString());
                    }
                    a.a(a.this);
                }
                return false;
            }
        };
        c gNK = new c<ms>() {
            {
                this.xmG = ms.class.getName().hashCode();
            }

            public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
                if (((ms) bVar).fFx.filePath.equals(a.this.gNF)) {
                    if (a.this.gNI) {
                        x.i("MicroMsg.OnNetSceneUploadMsgImgEnd", "androidSystemShareFixed(13717), imgLocalId:%d, scene.hash:%d, %s", Long.valueOf(a.this.gNA), Integer.valueOf(a.this.hashCode()), a.this.gND);
                        g.pWK.k(13717, a.this.gND);
                    }
                    a.a(a.this);
                }
                return false;
            }
        };

        static /* synthetic */ void a(a aVar) {
            com.tencent.mm.sdk.b.a.xmy.c(aVar.gNJ);
            com.tencent.mm.sdk.b.a.xmy.c(aVar.gNK);
        }

        a(long j, au auVar, com.tencent.mm.ad.b bVar, boolean z, int i) {
            this.gNA = j;
            this.fou = auVar;
            this.gLB = bVar;
            this.gNB = i;
            this.gNI = z;
        }
    }

    public final void a(long j, au auVar, com.tencent.mm.ad.b bVar, int i, boolean z, keep_SceneResult keep_sceneresult) {
        a aVar = new a(j, auVar, bVar, z, i);
        com.tencent.mm.storage.c fp = com.tencent.mm.y.c.c.IL().fp("100131");
        if (fp.isValid()) {
            aVar.gNG = t.getInt((String) fp.civ().get("needUploadData"), 1);
        }
        if (!aVar.gNE) {
            if (aVar.gNI || aVar.gNG != 0) {
                aVar.gNH = keep_sceneresult;
                aVar.gNE = true;
                String str = ((bsg) aVar.gLB.hnQ.hnY).vNN.wRo;
                Object obj = (bi.oN(str) || !str.endsWith("@chatroom")) ? null : 1;
                aVar.gND = "2," + (obj != null ? 2 : 1) + ",,";
                if (aVar.gNC == null) {
                    aVar.gNC = com.tencent.mm.ap.o.PC().b(Long.valueOf(aVar.gNA));
                }
                e eVar = aVar.gNC;
                if (eVar != null) {
                    com.tencent.mm.sdk.b.b mrVar = new mr();
                    com.tencent.mm.sdk.b.a.xmy.b(aVar.gNJ);
                    com.tencent.mm.sdk.b.a.xmy.b(aVar.gNK);
                    aVar.gNF = com.tencent.mm.ap.o.PC().m(eVar.hBB, "", "");
                    mrVar.fFv.filePath = aVar.gNF;
                    com.tencent.mm.sdk.b.a.xmy.m(mrVar);
                }
            }
        }
    }
}
