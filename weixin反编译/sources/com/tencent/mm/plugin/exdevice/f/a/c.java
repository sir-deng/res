package com.tencent.mm.plugin.exdevice.f.a;

import com.tencent.mm.modelcdntran.i.a;
import com.tencent.mm.modelcdntran.keep_ProgressInfo;
import com.tencent.mm.modelcdntran.keep_SceneResult;
import com.tencent.mm.plugin.exdevice.model.ad;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.as;
import com.tencent.mm.y.q;
import java.io.ByteArrayOutputStream;

public final class c implements a {
    String appName = null;
    String lUy = null;

    public final void a(String str, ByteArrayOutputStream byteArrayOutputStream) {
    }

    public final byte[] h(String str, byte[] bArr) {
        return null;
    }

    public final int a(String str, int i, keep_ProgressInfo keep_progressinfo, keep_SceneResult keep_sceneresult, boolean z) {
        x.d("MicroMsg.ExdevicePictureUploader", "cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", str, Integer.valueOf(i), keep_progressinfo, keep_sceneresult);
        if (keep_sceneresult == null || !str.equals(this.lUy)) {
            if (keep_progressinfo != null) {
                x.d("MicroMsg.ExdevicePictureUploader", "hy: upload progressing....");
            }
        } else if (i == 0 && keep_sceneresult.field_retCode == 0) {
            x.d("MicroMsg.ExdevicePictureUploader", "hy: transfer done, upload callback success");
            x.i("MicroMsg.ExdevicePictureUploader", "transfer done, mediaid=%s, completeInfo=%s", str, keep_sceneresult.toString());
            com.tencent.mm.plugin.exdevice.f.b.a.a aVar = new com.tencent.mm.plugin.exdevice.f.b.a.a();
            aVar.field_championUrl = keep_sceneresult.field_fileUrl;
            aVar.field_username = q.FY();
            b.zC(aVar.field_championUrl);
            ad.aEV().a(aVar, true);
            ad.aEZ();
            as.CN().a(new m(aVar.field_championUrl, aVar.field_championMotto), 0);
        } else {
            x.w("MicroMsg.ExdevicePictureUploader", "hy: transfer done, fail");
        }
        return 0;
    }
}
