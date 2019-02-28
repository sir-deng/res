package com.tencent.mm.plugin.hp.a;

import android.content.Context;
import com.tencent.mm.R;
import com.tencent.mm.a.e;
import com.tencent.mm.plugin.hp.d.b;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.h.p;
import com.tencent.mm.protocal.c.bpe;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import java.io.File;

public final class a {

    /* renamed from: com.tencent.mm.plugin.hp.a.a$1 */
    static class AnonymousClass1 implements Runnable {
        final /* synthetic */ String nGh;
        final /* synthetic */ String nGi;
        final /* synthetic */ b nGj;
        final /* synthetic */ Context val$context;

        public AnonymousClass1(String str, Context context, String str2, b bVar) {
            this.nGh = str;
            this.val$context = context;
            this.nGi = str2;
            this.nGj = bVar;
        }

        public final void run() {
            int i;
            if (e.bO(this.nGh)) {
                boolean i2 = false;
            } else {
                long currentTimeMillis = System.currentTimeMillis();
                int b = b.b(p.em(this.val$context), this.nGi, this.nGh, this.nGj.nGY);
                SharePatchFileUtil.ag(new File(this.nGi));
                x.i("MicroMsg.Tinker.CTinkerInstaller", "merge apk use :%d second retCode:%d", Long.valueOf((System.currentTimeMillis() - currentTimeMillis) / 1000), Integer.valueOf(b));
                i2 = b;
            }
            if (i2 == 0) {
                if (com.tencent.mm.c.a.ch(this.nGh)) {
                    String string;
                    x.i("MicroMsg.Tinker.CTinkerInstaller", "checkApk:%s", Boolean.valueOf(com.tencent.mm.c.a.ch(this.nGh)));
                    Context context = ad.getContext();
                    if (bi.oN(this.nGj.aTr())) {
                        string = context.getString(R.l.eSu);
                    } else {
                        string = this.nGj.aTr();
                    }
                    bpe bpe = new bpe();
                    bpe.nGX = this.nGj.nGX;
                    bpe.title = context.getString(R.l.ejC);
                    bpe.wYw = context.getString(R.l.epL);
                    bpe.nBJ = context.getString(R.l.eSg);
                    bpe.nGY = this.nGj.nGY;
                    bpe.nGZ = this.nGj.nGZ;
                    bpe.jOx = this.nGj.fileSize;
                    bpe.nGV = this.nGj.nGV;
                    bpe.feB = this.nGj.nGW;
                    bpe.versionCode = this.nGj.versionCode;
                    bpe.wYv = this.nGh;
                    bpe.fpV = string;
                    p.a(bpe);
                    if (this.nGj.nGT.intValue() == 3) {
                        g.pWK.a(614, 58, 1, false);
                    }
                    x.d("MicroMsg.Tinker.CTinkerInstaller", "boots download success.");
                } else {
                    x.i("MicroMsg.Tinker.CTinkerInstaller", "md5 is no equal.");
                }
            } else {
                x.i("MicroMsg.Tinker.CTinkerInstaller", "merge apk failed.");
            }
            switch (i2) {
                case -2:
                    g.pWK.a(614, 53, 1, false);
                    x.d("MicroMsg.Tinker.CTinkerInstaller", "boots download failed apk md5 no equal.");
                    return;
                case -1:
                    g.pWK.a(614, 52, 1, false);
                    x.d("MicroMsg.Tinker.CTinkerInstaller", "boots download failed sdcard full.");
                    return;
                default:
                    return;
            }
        }
    }
}
