package com.tencent.mm.plugin.appbrand.jsapi.voicejoint.b;

import com.tencent.mm.a.e;
import com.tencent.mm.audio.voicejoint.model.VoiceJointResult;
import com.tencent.mm.audio.voicejoint.model.VoiceSplitResult;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.c.azd;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.concurrent.ConcurrentHashMap;

public enum c {
    ;
    
    c jzh;
    public ConcurrentHashMap<String, VoiceJointResult> jzi;
    ConcurrentHashMap<String, d> jzj;
    public ConcurrentHashMap<String, com.tencent.mm.plugin.appbrand.jsapi.voicejoint.resdownload.b> jzk;
    public ConcurrentHashMap<String, a> jzl;

    public static class a {
        public String fXl;
        public String name;

        public a(String str, String str2) {
            this.name = str;
            this.fXl = str2;
        }
    }

    public interface c {
        void a(String str, d dVar);

        boolean ahS();

        d to(String str);
    }

    private class b implements c {
        private b() {
        }

        /* synthetic */ b(c cVar, byte b) {
            this();
        }

        public final boolean ahS() {
            if (com.tencent.mm.plugin.appbrand.jsapi.voicejoint.b.M(101, com.tencent.mm.plugin.appbrand.jsapi.voicejoint.d.a.lc(101)) == 0) {
                return true;
            }
            x.e("MicroMsg.VoiceBlackCheckMAnager", "alvinluo init checkBlack failed");
            return false;
        }

        public final d to(String str) {
            int i = -1;
            VoiceJointResult voiceJointResult = (VoiceJointResult) c.this.jzi.get(str);
            if (voiceJointResult == null) {
                x.e("MicroMsg.VoiceBlackCheckMAnager", "alvinluo jointResult not save");
                return null;
            }
            VoiceSplitResult voiceSplitResult = voiceJointResult.userSplitResult;
            if (voiceSplitResult == null) {
                x.e("MicroMsg.VoiceBlackCheckMAnager", "alvinluo userSplitResult is null");
                return null;
            }
            byte[] d = e.d(voiceSplitResult.userOriginPcmFilePath, 0, -1);
            if (bi.by(d)) {
                x.e("MicroMsg.VoiceBlackCheckMAnager", "alvinluo checkVoiceBlack user pcm is null");
                return null;
            }
            try {
                int i2 = voiceSplitResult.nameStartPos;
                int i3 = voiceSplitResult.nameLen;
                x.i("MicroMsg.VoiceBlackCheckMAnager", "alvinluo checkName start: %d, len: %d", Integer.valueOf(i2), Integer.valueOf(i3));
                Object obj = new byte[i3];
                System.arraycopy(d, i2, obj, 0, i3);
                i2 = x.i("MicroMsg.VoiceBlackCheckMAnager", "alvinluo magicCheck result: %d", Integer.valueOf(com.tencent.mm.plugin.appbrand.jsapi.voicejoint.b.checkBlack(obj, i3)));
                if (voiceSplitResult.hasCity()) {
                    i = voiceSplitResult.cityStartPos;
                    int i4 = voiceSplitResult.cityLen;
                    x.i("MicroMsg.VoiceBlackCheckMAnager", "alvinluo checkCity start: %d, len: %d", Integer.valueOf(i), Integer.valueOf(i4));
                    Object obj2 = new byte[i4];
                    System.arraycopy(d, i, obj2, 0, i4);
                    i = x.i("MicroMsg.VoiceBlackCheckMAnager", "alvinluo magicCheck result: %d", Integer.valueOf(com.tencent.mm.plugin.appbrand.jsapi.voicejoint.b.checkBlack(obj2, i4)));
                }
                x.i("MicroMsg.VoiceBlackCheckMAnager", "alvinluo checkVoiceBlack nameBlackId: %d, cityBlackId: %d", Integer.valueOf(i2), Integer.valueOf(i));
                return new d(voiceJointResult.starId, a(voiceJointResult, 0, i2), a(voiceJointResult, 1, i));
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.VoiceBlackCheckMAnager", e, "alvinluo checkVoiceBlack exception", new Object[0]);
                return null;
            }
        }

        public final void a(String str, d dVar) {
            int i = -1;
            c.this.jzj.put(str, dVar);
            if (dVar != null) {
                int i2;
                if (dVar.jzo != null) {
                    i2 = dVar.jzo.wgW;
                } else {
                    i2 = -1;
                }
                if (dVar.jzp != null) {
                    i = dVar.jzp.wgW;
                }
                if (i2 > 0 || i > 0) {
                    i2 = f.jzB;
                    f.kP(-100);
                    i2 = f.jzB;
                    f.bL(dVar.starId, -100);
                }
                c.this.tn(str);
            }
            com.tencent.mm.plugin.appbrand.jsapi.voicejoint.b.kO(101);
        }

        private static azd a(VoiceJointResult voiceJointResult, int i, int i2) {
            if (i2 < 0 || voiceJointResult == null || voiceJointResult.keywordStartPosList.length <= i || voiceJointResult.keywordLengthList.length <= i) {
                return null;
            }
            azd azd = new azd();
            azd.wMO = voiceJointResult.keywordStartPosList[i];
            azd.wgA = voiceJointResult.keywordLengthList[i];
            azd.wgW = i2;
            return azd;
        }
    }

    private c(String str) {
        this.jzh = new b();
        this.jzi = new ConcurrentHashMap();
        this.jzj = new ConcurrentHashMap();
        this.jzk = new ConcurrentHashMap();
        this.jzl = new ConcurrentHashMap();
    }

    public final void tn(String str) {
        x.i("MicroMsg.VoiceBlackCheckMAnager", "alvinluo triggerUploadCheckResult userKey: %s", str);
        d dVar = (d) this.jzj.get(str);
        com.tencent.mm.plugin.appbrand.jsapi.voicejoint.resdownload.b bVar = (com.tencent.mm.plugin.appbrand.jsapi.voicejoint.resdownload.b) this.jzk.get(str);
        VoiceJointResult voiceJointResult = (VoiceJointResult) this.jzi.get(str);
        a aVar = (a) this.jzl.get(str);
        if (dVar == null || bVar == null || voiceJointResult == null || aVar == null) {
            x.e("MicroMsg.VoiceBlackCheckMAnager", "alvinluo voiceCheckBlack upload info not ready");
            return;
        }
        x.i("MicroMsg.VoiceBlackCheckMAnager", "alvinluo uploadBlackCheckResult");
        g.Dp().gRu.a(new a(bVar.fAM, bVar.hda, voiceJointResult.voiceMd5, aVar, dVar), 0);
        if (this.jzi != null) {
            this.jzi.remove(str);
        }
        if (this.jzk != null) {
            this.jzk.remove(str);
        }
        if (this.jzj != null) {
            this.jzj.remove(str);
        }
        if (this.jzl != null) {
            this.jzl.remove(str);
        }
    }
}
