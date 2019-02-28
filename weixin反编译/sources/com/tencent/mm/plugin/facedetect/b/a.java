package com.tencent.mm.plugin.facedetect.b;

import android.os.Bundle;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelcdntran.keep_ProgressInfo;
import com.tencent.mm.modelcdntran.keep_SceneResult;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.x;
import java.io.ByteArrayOutputStream;

public final class a implements e {
    public boolean fnH = false;
    public boolean mkA = false;
    public long mkB = 0;
    public int mkC = 0;
    public k mkD = null;
    public k mkE = null;
    public long mkF = -1;
    public int mkG = -1;
    public com.tencent.mm.modelcdntran.i.a mkH = new com.tencent.mm.modelcdntran.i.a() {
        public final int a(String str, int i, keep_ProgressInfo keep_progressinfo, keep_SceneResult keep_sceneresult, boolean z) {
            if (i == -21005) {
                x.i("MicroMsg.FaceUploadProcessor", "hy: ERR_CNDCOM_MEDIA_IS_UPLOADING cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", str, Integer.valueOf(i), keep_progressinfo, keep_sceneresult);
            } else if (keep_sceneresult != null && keep_sceneresult.field_retCode == 0) {
                x.i("MicroMsg.FaceUploadProcessor", "hy: sceneResult.field_retCode == 0 cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", str, Integer.valueOf(i), keep_progressinfo, keep_sceneresult);
                String str2 = keep_sceneresult.field_fileId;
                Bundle bundle = new Bundle();
                bundle.putString("key_pic_cdn_id", str2);
                bundle.putString("key_cdn_aes_key", keep_sceneresult.field_aesKey);
                a aVar = a.this;
                String str3 = "ok";
                if (aVar.mky != null) {
                    aVar.mky.a(0, 0, str3, bundle);
                }
            } else if (keep_sceneresult != null) {
                x.w("MicroMsg.FaceUploadProcessor", "hy: cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", str, Integer.valueOf(i), keep_progressinfo, keep_sceneresult);
                a.this.g(3, 90020, "cdn ret error");
            } else if (i != 0) {
                x.w("MicroMsg.FaceUploadProcessor", "hy: start error!; cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", str, Integer.valueOf(i), keep_progressinfo, keep_sceneresult);
                a.this.g(3, 90021, "cdn start error");
            } else {
                x.i("MicroMsg.FaceUploadProcessor", "hy: on process, cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", str, Integer.valueOf(i), keep_progressinfo, keep_sceneresult);
                if (keep_progressinfo != null) {
                    x.d("MicroMsg.FaceUploadProcessor", "hy: cdn process: %f", Double.valueOf(((double) keep_progressinfo.field_finishedLength) / ((double) keep_progressinfo.field_toltalLength)));
                    a aVar2 = a.this;
                    if (aVar2.mky != null) {
                        aVar2.mky.l(r0);
                    }
                }
            }
            return 0;
        }

        public final void a(String str, ByteArrayOutputStream byteArrayOutputStream) {
        }

        public final byte[] h(String str, byte[] bArr) {
            return null;
        }
    };
    public int mkx = -1;
    public d mky = null;
    public c mkz = null;

    public a(int i) {
        this.mkx = i;
    }

    public final void aGL() {
        if (this.mkE != null) {
            g.CN().b(this.mkE.getType(), (e) this);
        }
    }

    public final void g(final int i, final int i2, final String str) {
        ah.y(new Runnable() {
            public final void run() {
                if (a.this.mky != null) {
                    a.this.mky.a(a.this.mkC, i, i2, str);
                }
            }
        });
    }

    public final void a(int i, int i2, String str, k kVar) {
        boolean z = false;
        x.i("MicroMsg.FaceUploadProcessor", "hy: scene: %s, errType: %d, errCode: %d, errMsg: %s", kVar.toString(), Integer.valueOf(i), Integer.valueOf(i2), str);
        if ((kVar instanceof u) || (kVar instanceof v)) {
            if (i == 0 && i2 == 0) {
                b bVar = (b) kVar;
                this.mkB = bVar.aGM();
                com.tencent.mm.plugin.facedetect.model.e.cS(this.mkB);
                if (bVar.aGN() == null) {
                    x.e("MicroMsg.FaceUploadProcessor", "hy: backend not return config");
                    g(2, 90015, "face motion config from server is null");
                    return;
                }
                byte[] aGN = bVar.aGN();
                String str2 = "MicroMsg.FaceUploadProcessor";
                String str3 = "configLen: %d, mUploadCallback == null: %b";
                Object[] objArr = new Object[2];
                objArr[0] = Integer.valueOf(aGN.length);
                if (this.mky == null) {
                    z = true;
                }
                objArr[1] = Boolean.valueOf(z);
                x.i(str2, str3, objArr);
                if (this.mkz != null) {
                    this.mkz.e(this.mkB, aGN);
                }
            } else if (this.mkz != null) {
                this.mkz.ae(i, "get face bio config failed");
            }
        } else if (this.mkE != null && kVar.getType() == this.mkE.getType()) {
            this.mkG = (int) (System.currentTimeMillis() - this.mkF);
            if (this.mky != null) {
                this.mky.h(i, i2, str, kVar);
            }
        }
    }
}
