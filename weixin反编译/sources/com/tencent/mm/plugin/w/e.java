package com.tencent.mm.plugin.w;

import com.tencent.mm.ad.k;
import com.tencent.mm.modelcdntran.b;
import com.tencent.mm.modelcdntran.i;
import com.tencent.mm.modelcdntran.keep_ProgressInfo;
import com.tencent.mm.modelcdntran.keep_SceneResult;
import com.tencent.mm.plugin.backup.g.d;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.w.a.a;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.protocal.MMProtocalJni;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.ao;
import com.tencent.mm.y.as;
import com.tencent.mm.y.c;
import java.io.ByteArrayOutputStream;
import java.io.File;

public final class e implements a, ao {
    public static e oLc;
    public int fBj;
    private String gAM;
    private i.a hDi = new i.a() {
        public final int a(String str, int i, keep_ProgressInfo keep_progressinfo, keep_SceneResult keep_sceneresult, boolean z) {
            x.d("MicroMsg.MsgSynchronizeServer", "msgSynchronize cdnCallback clientid:%s, startRet:%d proginfo:[%s], res:[%s]", str, Integer.valueOf(i), keep_progressinfo, keep_sceneresult);
            if (i == -21005) {
                x.d("MicroMsg.MsgSynchronizeServer", "msgSynchronize  ERR_CNDCOM_MEDIA_IS_UPLOADING clientid:%s", str);
                return 0;
            } else if (i != 0) {
                x.e("MicroMsg.MsgSynchronizeServer", "msgSynchronize cdn callback startRet failed. clientid:%s, startRet:%d", str, Integer.valueOf(i));
                g.pWK.a(466, 2, 1, false);
                g.pWK.h(14108, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(e.this.fBj));
                return 0;
            } else {
                if (keep_sceneresult != null) {
                    if (keep_sceneresult.field_retCode != 0) {
                        x.e("MicroMsg.MsgSynchronizeServer", "msgSynchronize cdn callback failed. sceneResult.retCode[%d], arg[%s], info[%s], clientid[%s], filemd5[%s]", Integer.valueOf(keep_sceneresult.field_retCode), keep_sceneresult.field_arg, keep_sceneresult.field_transInfo, str, keep_sceneresult.field_filemd5);
                        g.pWK.a(466, 2, 1, false);
                        g.pWK.h(14108, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(e.this.fBj));
                    } else {
                        x.i("MicroMsg.MsgSynchronizeServer", "msgSynchronize cdn callback success. clientid[%s], filemd5[%s], isHitCacheUpload[%d]", str, keep_sceneresult.field_filemd5, Integer.valueOf(keep_sceneresult.field_UploadHitCacheType));
                        PByteArray pByteArray = new PByteArray();
                        if (MMProtocalJni.rsaPublicEncryptPemkey(keep_sceneresult.field_aesKey.getBytes(), pByteArray, e.this.oLe)) {
                            String bA = bi.bA(pByteArray.value);
                            e.this.oLf = keep_sceneresult.field_fileId;
                            e.this.oLg = bA;
                            e.this.oLh = keep_sceneresult.field_fileLength;
                            if (com.tencent.mm.kernel.a.gC(com.tencent.mm.kernel.g.Do().gRd)) {
                                x.i("MicroMsg.MsgSynchronizeServer", "sendAppMsg immediately.");
                                e.this.bcs();
                            } else {
                                x.i("MicroMsg.MsgSynchronizeServer", "wait getOnlineInfoExtDeviceOnlineListener to sendAppMsg.");
                                as.Hm();
                                c.a(e.this);
                                e.this.oLm = true;
                            }
                        } else {
                            x.e("MicroMsg.MsgSynchronizeServer", "msgSynchronize MMProtocalJni rsaPublicEncryptPemkey failed!");
                            return -1;
                        }
                    }
                }
                return 0;
            }
        }

        public final void a(String str, ByteArrayOutputStream byteArrayOutputStream) {
        }

        public final byte[] h(String str, byte[] bArr) {
            return new byte[0];
        }
    };
    public c oLd = new c();
    public byte[] oLe;
    String oLf;
    String oLg;
    int oLh;
    public long oLi;
    long oLj;
    long oLk;
    long oLl;
    boolean oLm = false;
    final com.tencent.mm.ad.e oLn = new com.tencent.mm.ad.e() {
        public final void a(int i, int i2, String str, k kVar) {
            as.CN().b(222, e.this.oLn);
            if (i == 0 && i2 == 0) {
                x.i("MicroMsg.MsgSynchronizeServer", "msgSynchronize success. ");
                com.tencent.mm.a.e.g(new File(f.bcu()));
                com.tencent.mm.a.e.g(new File(f.bcv()));
                long bA = bi.bA(e.this.oLi);
                g.pWK.a(466, 1, 1, false);
                g.pWK.a(466, 5, e.this.oLl, false);
                g.pWK.a(466, 7, bA, false);
                g.pWK.a(466, 11, e.this.oLk, false);
                g.pWK.a(466, 12, e.this.oLj, false);
                g.pWK.h(14108, Long.valueOf(e.this.oLl), Long.valueOf(bA), Long.valueOf(e.this.oLk), Long.valueOf(e.this.oLj), Integer.valueOf(0), Integer.valueOf(e.this.fBj));
                return;
            }
            x.e("MicroMsg.MsgSynchronizeServer", "msgSynchronize appmsg.  errType:%d, errCode:%d, errMsg:%s", Integer.valueOf(i), Integer.valueOf(i2), str);
            g.pWK.a(466, 3, 1, false);
            g.pWK.h(14108, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(2), Integer.valueOf(e.this.fBj));
        }
    };

    public final void a(String str, int i, String str2, int i2, long j, long j2) {
        x.i("MicroMsg.MsgSynchronizeServer", "onMsgSynchronizePackFinish filePath:%s, conversationSize:%d", str, Integer.valueOf(i));
        this.oLj = (long) i2;
        this.oLk = j;
        this.oLl = j2;
        this.gAM = str2;
        String str3 = "MSG_SYNCHRONIZE_" + i + "_" + bi.Wy();
        i iVar = new i();
        iVar.hve = this.hDi;
        iVar.field_mediaId = str3;
        iVar.field_fullpath = str;
        iVar.field_fileType = b.MediaType_FILE;
        iVar.field_talker = (String) d.aqL().aqM().Db().get(2, null);
        iVar.field_priority = b.htu;
        if (!com.tencent.mm.modelcdntran.g.MP().c(iVar)) {
            x.e("MicroMsg.MsgSynchronizeServer", "msgSynchronize addSendTask failed. clientid:%s", str3);
            g.pWK.a(466, 2, 1, false);
            g.pWK.h(14108, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(this.fBj));
        }
    }

    public final void Hd() {
        x.i("MicroMsg.MsgSynchronizeServer", "receive onNotifyUserStatusChange, needWaitExtLoginCallback[%b], isWebWXOnline:[%b]", Boolean.valueOf(this.oLm), Boolean.valueOf(com.tencent.mm.kernel.a.gC(com.tencent.mm.kernel.g.Do().gRd)));
        if (this.oLm && com.tencent.mm.kernel.a.gC(com.tencent.mm.kernel.g.Do().gRd)) {
            x.i("MicroMsg.MsgSynchronizeServer", "onNotifyUserStatusChange need send msgSynchronize appMsg.");
            as.Hm();
            c.b(this);
            this.oLm = false;
            bcs();
        }
    }

    final void bcs() {
        x.i("MicroMsg.MsgSynchronizeServer", "msgSynchronize start send AppMsg.");
        as.CN().a(222, this.oLn);
        as.CN().a(new d(this.oLf, this.oLg, this.oLh, this.gAM), 0);
    }

    public final void onCancel() {
        x.e("MicroMsg.MsgSynchronizeServer", "MsgSynchronizeServer cancel, Caller:%s", aj.cgu());
        this.oLd.oKW = true;
    }
}
