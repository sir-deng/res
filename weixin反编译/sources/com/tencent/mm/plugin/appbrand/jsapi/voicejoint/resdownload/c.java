package com.tencent.mm.plugin.appbrand.jsapi.voicejoint.resdownload;

import com.tencent.mm.modelcdntran.g;
import com.tencent.mm.modelcdntran.i;
import com.tencent.mm.modelcdntran.keep_ProgressInfo;
import com.tencent.mm.modelcdntran.keep_SceneResult;
import com.tencent.mm.plugin.appbrand.jsapi.voicejoint.b.f;
import com.tencent.mm.plugin.appbrand.jsapi.voicejoint.resdownload.JointVoiceUploader.b;
import com.tencent.mm.sdk.platformtools.x;
import java.io.ByteArrayOutputStream;

public final class c implements com.tencent.mm.plugin.appbrand.jsapi.voicejoint.resdownload.JointVoiceUploader.c {
    b jzK = null;
    private a jzL = new a();

    private class a implements com.tencent.mm.modelcdntran.i.a {
        private boolean jzD = false;
        private String tag;

        public final void de(boolean z) {
            this.jzD = z;
            this.tag = z ? "upload" : "download";
        }

        public final int a(String str, int i, keep_ProgressInfo keep_progressinfo, keep_SceneResult keep_sceneresult, boolean z) {
            x.d("MicroMsg.JointVoiceUploaderServiceImpl", "alvinluo JointVoice %s cdnCallback mediaId: %s startRet: %d, isUpload: %b, proginfo: %s, res: %s, threadId: %d", this.tag, str, Integer.valueOf(i), Boolean.valueOf(this.jzD), keep_progressinfo, keep_sceneresult, Long.valueOf(Thread.currentThread().getId()));
            if (i == -21005 || i == -21006) {
                x.i("MicroMsg.JointVoiceUploaderServiceImpl", "alvinluo JointVoice %s mediaId: %s, already is doing", this.tag, Boolean.valueOf(this.jzD));
                return 0;
            }
            if (i != 0) {
                x.w("MicroMsg.JointVoiceUploaderServiceImpl", "alvinluo start JointVoiceCDNTask %s failed, startRet: %d", this.tag, Integer.valueOf(i));
                c.this.L(this.jzD ? 8009 : 8017, String.format("joint voice %s cdnTask start failed", new Object[]{this.tag}));
            } else if (keep_sceneresult != null) {
                if (keep_sceneresult.field_retCode == 0) {
                    x.i("MicroMsg.JointVoiceUploaderServiceImpl", "alvinluo JointVoice %s cdnCallback success", this.tag);
                    b bVar = new b();
                    bVar.fAM = keep_sceneresult.field_fileId;
                    bVar.jzD = this.jzD;
                    if (this.jzD) {
                        bVar.hda = keep_sceneresult.field_aesKey;
                    }
                    c cVar = c.this;
                    boolean z2 = this.jzD;
                    if (cVar.jzK != null) {
                        cVar.jzK.a(bVar);
                    }
                    int i2 = z2 ? 8019 : 8020;
                    int i3 = f.jzB;
                    f.kS(i2);
                } else {
                    x.w("MicroMsg.JointVoiceUploaderServiceImpl", "alvinluo JointVoice %s cdnCallback failed, retCode: %d", this.tag, Integer.valueOf(keep_sceneresult.field_retCode));
                    c.this.L(this.jzD ? 8008 : 8018, String.format("joint voice %s failed", new Object[]{this.tag}));
                }
            } else if (keep_progressinfo != null) {
                x.d("MicroMsg.JointVoiceUploaderServiceImpl", "alvinluo JointVoice %s cdnCallback progressInfo not null, update progress, status: %d", this.tag, Integer.valueOf(keep_progressinfo.field_status));
                if (c.this.jzK != null) {
                    c.this.jzK.bK(keep_progressinfo.field_finishedLength, keep_progressinfo.field_toltalLength);
                }
            } else {
                x.w("MicroMsg.JointVoiceUploaderServiceImpl", "alvinluo JointVoice %s cdnCallback unknown error", this.tag);
                c.this.L(this.jzD ? 8008 : 8018, String.format("joint voice %s cdnTask unknown error", new Object[]{this.tag}));
            }
            return 0;
        }

        public final void a(String str, ByteArrayOutputStream byteArrayOutputStream) {
        }

        public final byte[] h(String str, byte[] bArr) {
            return new byte[0];
        }
    }

    public final void a(String str, String str2, b bVar) {
        this.jzK = bVar;
        i iVar = new i();
        this.jzL.de(true);
        iVar.hve = this.jzL;
        iVar.field_mediaId = str;
        iVar.field_fullpath = str2;
        iVar.field_thumbpath = "";
        iVar.field_fileType = com.tencent.mm.modelcdntran.b.htx;
        iVar.field_talker = "";
        iVar.field_priority = com.tencent.mm.modelcdntran.b.htv;
        iVar.field_needStorage = false;
        iVar.field_isStreamMedia = false;
        iVar.field_appType = 0;
        iVar.field_bzScene = 0;
        iVar.field_trysafecdn = true;
        if (!g.MP().c(iVar)) {
            x.e("MicroMsg.JointVoiceUploaderServiceImpl", "alvinluo JointVoice upload cdnTask add failed, mediaId: %s", iVar.field_mediaId);
            L(8009, "upload voice start failed");
        }
    }

    public final void a(String str, String str2, String str3, String str4, b bVar) {
        this.jzK = bVar;
        i iVar = new i();
        this.jzL.de(false);
        iVar.hve = this.jzL;
        iVar.field_fileId = str3;
        iVar.field_aesKey = str4;
        iVar.field_mediaId = str;
        iVar.field_fullpath = str2;
        iVar.field_fileType = com.tencent.mm.modelcdntran.b.htx;
        iVar.field_priority = com.tencent.mm.modelcdntran.b.htv;
        iVar.field_needStorage = false;
        if (!g.MP().b(iVar, -1)) {
            x.e("MicroMsg.JointVoiceUploaderServiceImpl", "alvinluo JointVoice download cdnTask add failed, mediaId: %s", iVar.field_mediaId);
            L(8017, "download voice start failed");
        }
    }

    final void L(int i, String str) {
        if (this.jzK != null) {
            this.jzK.L(i, str);
        }
        int i2 = f.jzB;
        f.kS(i);
    }
}
