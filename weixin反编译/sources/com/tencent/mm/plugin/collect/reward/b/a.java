package com.tencent.mm.plugin.collect.reward.b;

import com.tencent.mm.modelcdntran.keep_ProgressInfo;
import com.tencent.mm.modelcdntran.keep_SceneResult;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.q;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.Map;

public final class a implements com.tencent.mm.modelcdntran.i.a {
    public static final String lpm = (com.tencent.mm.loader.stub.a.hbv + "wallet/img/");
    private static a lpn;
    private String filename;
    public Map<String, a> gLL;

    public interface a {
        void F(String str, int i, int i2);
    }

    public static a azA() {
        if (lpn == null) {
            lpn = new a();
        }
        return lpn;
    }

    public final boolean azB() {
        return new File(lpm + azC()).exists();
    }

    public final String azC() {
        if (bi.oN(this.filename)) {
            this.filename = ac.VF(q.FY() + "_reward_img");
        }
        return this.filename;
    }

    public final int a(final String str, final int i, keep_ProgressInfo keep_progressinfo, final keep_SceneResult keep_sceneresult, boolean z) {
        x.i("MicroMsg.QrRewardCdnDownloadHelper", "cdn callback, id: %s, ret: %s, sceneResult: %s", str, Integer.valueOf(i), keep_sceneresult);
        ah.y(new Runnable() {
            public final void run() {
                a aVar = (a) a.this.gLL.get(str);
                if (aVar == null) {
                    x.w("MicroMsg.QrRewardCdnDownloadHelper", "no callback");
                } else if (keep_sceneresult != null) {
                    aVar.F(str, i, keep_sceneresult.field_retCode);
                    a.this.gLL.remove(str);
                    if (keep_sceneresult.field_retCode == 0) {
                        g.pWK.a(724, 8, 1, false);
                    } else {
                        g.pWK.a(724, 9, 1, false);
                    }
                } else {
                    x.v("MicroMsg.QrRewardCdnDownloadHelper", "download is not end");
                }
            }
        });
        return 0;
    }

    public final void a(String str, ByteArrayOutputStream byteArrayOutputStream) {
    }

    public final byte[] h(String str, byte[] bArr) {
        return new byte[0];
    }
}
