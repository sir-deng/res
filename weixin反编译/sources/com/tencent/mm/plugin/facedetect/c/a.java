package com.tencent.mm.plugin.facedetect.c;

import android.content.Context;
import android.os.Bundle;
import android.os.Process;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelcdntran.b;
import com.tencent.mm.modelcdntran.i;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.facedetect.b.c;
import com.tencent.mm.plugin.facedetect.b.d;
import com.tencent.mm.plugin.facedetect.b.u;
import com.tencent.mm.plugin.facedetect.b.v;
import com.tencent.mm.plugin.facedetect.model.FaceDetectReporter;
import com.tencent.mm.plugin.facedetect.model.o;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.common.TMAssistantDownloadSDKErrorCode;
import java.lang.ref.WeakReference;

public abstract class a {
    private Context mContext;
    private int mkx;
    protected d mky = null;
    protected c mkz = null;
    protected WeakReference<e> mll;
    protected boolean mlm = false;
    int mln = -1;
    private com.tencent.mm.remoteservice.d mlo = null;
    protected com.tencent.mm.plugin.facedetect.b.a mlp = null;
    protected boolean mlq = false;

    protected abstract k aGV();

    public abstract Bundle aGW();

    public abstract void af(int i, String str);

    public abstract boolean e(int i, int i2, String str, Bundle bundle);

    public abstract void f(int i, int i2, String str, Bundle bundle);

    public abstract void h(int i, int i2, String str);

    public abstract void h(int i, int i2, String str, k kVar);

    public abstract void onRelease();

    protected abstract void onStart();

    a(Context context, e eVar, int i) {
        this.mContext = context;
        this.mkx = i;
        this.mll = new WeakReference(eVar);
        this.mlp = new com.tencent.mm.plugin.facedetect.b.a(i);
        this.mln = FaceDetectReporter.pN(i);
    }

    public final void a(c cVar) {
        if (this.mlp != null) {
            this.mkz = cVar;
            this.mlp.mkz = this.mkz;
        }
    }

    public final void a(d dVar) {
        if (this.mlp != null) {
            this.mky = dVar;
            this.mlp.mky = dVar;
        }
    }

    public final void aGR() {
        if (this.mlp != null) {
            e eVar = this.mlp;
            g.Do();
            eVar.fnH = com.tencent.mm.kernel.a.CE();
            x.i("MicroMsg.FaceUploadProcessor", "alvinluo isLogin: %b", Boolean.valueOf(eVar.fnH));
            if (eVar.fnH) {
                g.CN().a((int) TMAssistantDownloadSDKErrorCode.DownloadSDKErrorCode_CLIENT_PROTOCOL_EXCEPTION, eVar);
            } else {
                g.CN().a(733, eVar);
            }
            com.tencent.mm.plugin.facedetect.b.a aVar = this.mlp;
            aVar.mkB = 0;
            aVar.mkC = 0;
            if (aVar.mkD != null) {
                g.CN().c(aVar.mkD);
            }
            if (com.tencent.mm.plugin.facedetect.model.e.aHb()) {
                com.tencent.mm.plugin.facedetect.model.e.cS(aVar.mkB);
            }
            if (aVar.fnH) {
                aVar.mkD = new u(aVar.mkx);
            } else {
                aVar.mkD = new v(aVar.mkx);
            }
            g.CN().a(aVar.mkD, 0);
        }
    }

    public final void aGS() {
        if (!(this.mll == null || this.mll.get() == null)) {
            ((e) this.mll.get()).aGS();
        }
        onStart();
    }

    public final void Ap(String str) {
        if (this.mlp != null) {
            com.tencent.mm.plugin.facedetect.b.a aVar = this.mlp;
            if (!aVar.mkA) {
                aVar.mkC = 1;
                if (bi.oN(str)) {
                    x.e("MicroMsg.FaceUploadProcessor", "hy: err face file null");
                    aVar.g(4, 90011, "face file null");
                } else if (!FileOp.bO(str)) {
                    x.e("MicroMsg.FaceUploadProcessor", "hy: file not exist");
                    aVar.g(4, 90011, "get image failed");
                } else if (aVar.mkB == 0) {
                    x.e("MicroMsg.FaceUploadProcessor", "hy: err not init");
                    aVar.g(4, 90014, "uploadId not init");
                } else {
                    x.i("MicroMsg.FaceUploadProcessor", "hy: start upload file : %s", str);
                    if (!aVar.mkA) {
                        i iVar = new i();
                        iVar.hve = aVar.mkH;
                        iVar.field_mediaId = o.tu(str);
                        iVar.field_fullpath = str;
                        iVar.field_thumbpath = "";
                        iVar.field_fileType = b.MediaType_FILE;
                        iVar.field_talker = "";
                        iVar.field_priority = b.htu;
                        iVar.field_needStorage = false;
                        iVar.field_isStreamMedia = false;
                        iVar.field_appType = 0;
                        iVar.field_bzScene = 0;
                        iVar.field_largesvideo = false;
                        if (!com.tencent.mm.modelcdntran.g.MP().c(iVar)) {
                            x.e("MicroMsg.FaceUploadProcessor", "hy: cdntra addSendTask failed. clientid:%s", iVar.field_mediaId);
                            aVar.g(4, 90019, "add to cdn failed");
                        }
                    }
                }
            }
        }
    }

    public final long aGT() {
        if (this.mlp != null) {
            return this.mlp.mkB;
        }
        return -1;
    }

    public final void aGU() {
        x.i("MicroMsg.FaceDetectBaseController", "alvinluo controller releaseFaceDetect");
        if (!(this.mll == null || this.mll.get() == null)) {
            ((e) this.mll.get()).aGU();
        }
        this.mll = null;
        String r = bi.r(ad.getContext(), Process.myPid());
        String packageName = ad.getPackageName();
        x.i("MicroMsg.FaceDetectBaseController", "process name: %s", r);
        if (r.equalsIgnoreCase(packageName)) {
            if (this.mlp != null) {
                e eVar = this.mlp;
                String str = "MicroMsg.FaceUploadProcessor";
                String str2 = "alvinluo uinit mCurrentNetScene == null: %b";
                Object[] objArr = new Object[1];
                objArr[0] = Boolean.valueOf(eVar.mkD == null);
                x.v(str, str2, objArr);
                eVar.mkA = true;
                if (eVar.mkD != null) {
                    x.i("MicroMsg.FaceUploadProcessor", "alvinluo hy: current scene: %s is not finished yet. cancel.", eVar.mkD.getClass().getSimpleName());
                    g.CN().c(eVar.mkD);
                }
                if (eVar.fnH) {
                    g.CN().b((int) TMAssistantDownloadSDKErrorCode.DownloadSDKErrorCode_CLIENT_PROTOCOL_EXCEPTION, eVar);
                } else {
                    g.CN().b(733, eVar);
                }
                eVar.aGL();
            }
            this.mlp = null;
        }
        onRelease();
    }

    protected final void b(int i, int i2, String str, Bundle bundle) {
        boolean z = true;
        String str2 = "MicroMsg.FaceDetectBaseController";
        String str3 = "alvinluo finishWithResult mUIModel == null: %b";
        Object[] objArr = new Object[1];
        if (this.mll != null) {
            z = false;
        }
        objArr[0] = Boolean.valueOf(z);
        x.i(str2, str3, objArr);
        if (this.mll != null && this.mll.get() != null) {
            ((e) this.mll.get()).b(i, i2, str, bundle);
        }
    }

    public final void a(boolean z, boolean z2, com.tencent.mm.plugin.facedetect.ui.a.b bVar) {
        if (this.mll != null && this.mll.get() != null) {
            ((e) this.mll.get()).a(z, z2, bVar);
        }
    }

    protected final void c(int i, int i2, String str, Bundle bundle) {
        if (this.mll != null && this.mll.get() != null) {
            ((e) this.mll.get()).g(i, i2, str, bundle);
        }
    }

    public final void d(int i, int i2, String str, Bundle bundle) {
        if (i == 0 && i2 == 0 && !e(i, i2, str, bundle)) {
            x.i("MicroMsg.FaceDetectBaseController", "alvinluo onUploadSuccess");
            this.mlm = true;
            if (this.mlq) {
                k aGV = aGV();
                if (aGV == null) {
                    x.e("MicroMsg.FaceDetectBaseController", "alvinluo verifyNetScene is null, stop verify");
                    return;
                }
                x.i("MicroMsg.FaceDetectBaseController", "alvinluo start verify, sceneType: %d", Integer.valueOf(aGV.getType()));
                if (!this.mlm) {
                    x.e("MicroMsg.FaceDetectBaseController", "isUploadDone: %b, upload not done, can't startVerify", Boolean.valueOf(this.mlm));
                } else if (this.mlp != null) {
                    e eVar = this.mlp;
                    if (aGV == null) {
                        x.e("MicroMsg.FaceUploadProcessor", "alvinluo verifyNetScene is null");
                        return;
                    }
                    x.i("MicroMsg.FaceUploadProcessor", "uploader start verify, sceneType: %d", Integer.valueOf(aGV.getType()));
                    eVar.aGL();
                    eVar.mkE = aGV;
                    eVar.mkC = 2;
                    g.CN().a(aGV.getType(), eVar);
                    g.CN().a(aGV, 0);
                    eVar.mkF = System.currentTimeMillis();
                }
            }
        }
    }
}
