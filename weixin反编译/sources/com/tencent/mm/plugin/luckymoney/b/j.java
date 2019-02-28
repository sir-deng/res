package com.tencent.mm.plugin.luckymoney.b;

import com.tencent.mm.modelcdntran.b;
import com.tencent.mm.modelcdntran.d;
import com.tencent.mm.modelcdntran.g;
import com.tencent.mm.modelcdntran.i;
import com.tencent.mm.modelcdntran.keep_ProgressInfo;
import com.tencent.mm.modelcdntran.keep_SceneResult;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.q;
import java.io.ByteArrayOutputStream;

public final class j implements com.tencent.mm.modelcdntran.i.a {
    private boolean jzD = true;
    public String lUy = null;
    public a oie;
    public String oif;

    public interface a {
        void a(keep_SceneResult keep_sceneresult, String str, boolean z);
    }

    public static String aXL() {
        return bi.oM(d.a("NewYearImg", System.currentTimeMillis(), q.GE().field_username, ""));
    }

    public final boolean a(String str, String str2, int i, String str3, a aVar) {
        x.i("MicroMsg.LuckyMoneyNewYearImageUploader", "ljd: downloadImage. imageId:%s", str);
        this.jzD = false;
        this.lUy = aXL();
        x.i("MicroMsg.LuckyMoneyNewYearImageUploader", "ljd: downloadImage. client id:%s", this.lUy);
        this.oif = str3;
        this.oie = aVar;
        i iVar = new i();
        iVar.fMC = false;
        iVar.hve = this;
        iVar.field_fullpath = str3;
        iVar.field_mediaId = this.lUy;
        iVar.field_fileId = str;
        iVar.field_aesKey = str2;
        iVar.field_totalLen = i;
        iVar.field_fileType = b.MediaType_FILE;
        iVar.field_priority = b.htu;
        iVar.field_needStorage = false;
        iVar.field_isStreamMedia = false;
        iVar.field_appType = 0;
        iVar.field_bzScene = 0;
        if (g.MP().b(iVar, -1)) {
            return true;
        }
        x.e("MicroMsg.LuckyMoneyNewYearImageUploader", "ljd: cdntra addSendTask failed. imageId:%s", str);
        return false;
    }

    public final int a(String str, int i, keep_ProgressInfo keep_progressinfo, keep_SceneResult keep_sceneresult, boolean z) {
        x.d("MicroMsg.LuckyMoneyNewYearImageUploader", "ljd:cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", str, Integer.valueOf(i), keep_progressinfo, keep_sceneresult);
        if (keep_sceneresult != null && this.lUy.equals(str) && !bi.oN(keep_sceneresult.field_fileId)) {
            x.i("MicroMsg.LuckyMoneyNewYearImageUploader", "ljd: transfer success, sceneResult.field_retCode:" + keep_sceneresult.field_retCode);
            if (i == 0 && keep_sceneresult.field_retCode == 0) {
                if (this.jzD) {
                    x.i("MicroMsg.LuckyMoneyNewYearImageUploader", "ljd: transfer done, upload callback success");
                } else {
                    x.i("MicroMsg.LuckyMoneyNewYearImageUploader", "ljd: transfer done, download callback success");
                }
                x.i("MicroMsg.LuckyMoneyNewYearImageUploader", "ljd:transfer done, mediaid=%s, completeInfo=%s", str, keep_sceneresult.toString());
                if (this.oie != null) {
                    this.oie.a(keep_sceneresult, this.oif, true);
                }
            } else {
                x.e("MicroMsg.LuckyMoneyNewYearImageUploader", "ljd: transfer done, fail");
                if (this.oie != null) {
                    this.oie.a(keep_sceneresult, this.oif, false);
                }
            }
        } else if (keep_sceneresult != null && this.lUy.equals(str) && keep_sceneresult.field_retCode != 0) {
            x.e("MicroMsg.LuckyMoneyNewYearImageUploader", "ljd: transfer done, fail, sceneResult.field_retCode:" + keep_sceneresult.field_retCode);
            if (this.oie != null) {
                this.oie.a(keep_sceneresult, this.oif, false);
            }
        } else if (keep_progressinfo != null) {
            x.d("MicroMsg.LuckyMoneyNewYearImageUploader", "ljd: upload progressing....");
        }
        return 0;
    }

    public final void a(String str, ByteArrayOutputStream byteArrayOutputStream) {
    }

    public final byte[] h(String str, byte[] bArr) {
        return null;
    }
}
