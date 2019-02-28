package com.tencent.mm.plugin.sns.model.a;

import android.graphics.BitmapFactory.Options;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.appbrand.jsapi.v;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.sns.h.c;
import com.tencent.mm.plugin.sns.lucky.a.b;
import com.tencent.mm.plugin.sns.model.a.c.a;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.storage.r;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.MMNativeJpeg;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class i extends f {
    private boolean hhq = false;

    public i(a aVar, a aVar2) {
        super(aVar, aVar2);
        g.pWK.a(150, 10, 1, true);
    }

    public final boolean bwR() {
        if (this.reJ.qWO != null) {
            int queryQuality;
            String str;
            String e = com.tencent.mm.plugin.sns.data.i.e(this.fIx);
            this.hhq = r.Mh(this.reJ.getPath() + this.reJ.bwP());
            if (this.rfi) {
                this.hhq = true;
            }
            if (this.hhq) {
                g.pWK.a(22, 64, 1, true);
            }
            String str2 = this.reJ.getPath() + this.reJ.bwP();
            Options options = new Options();
            options.inJustDecodeBounds = true;
            MMBitmapFactory.decodeFile(str2, options, null, 0, new int[0]);
            String toLowerCase = options.outMimeType != null ? options.outMimeType.toLowerCase() : "";
            if (options.outMimeType == null || bi.oN(options.outMimeType)) {
                g.pWK.a(150, 35, 1, true);
            }
            if (toLowerCase.contains("jpg") || toLowerCase.contains("jpeg")) {
                queryQuality = MMNativeJpeg.queryQuality(str2);
                if (queryQuality == 0) {
                    queryQuality = -1;
                }
            } else {
                queryQuality = -1;
            }
            long mi = FileOp.mi(str2);
            if (mi <= 0) {
                g.pWK.a(150, 23, 1, true);
            }
            long Wz = bi.Wz();
            String i = com.tencent.mm.plugin.sns.data.i.i(this.fIx);
            FileOp.x(this.reJ.getPath() + this.reJ.bwP(), this.reJ.getPath() + i);
            x.v("MicroMsg.SnsDownloadThumb", "file src" + FileOp.bO(this.reJ.getPath() + i));
            long Wz2 = bi.Wz();
            if (!r.a(this.reJ.getPath(), this.reJ.bwP(), e, (float) ae.bwo())) {
                x.e("MicroMsg.SnsDownloadThumb", "decodeInfo createThumb failed");
                g.pWK.a(150, 27, 1, true);
            }
            Wz2 = bi.bB(Wz2);
            FileOp.deleteFile(this.reJ.getPath() + this.reJ.bwP());
            Wz = bi.bB(Wz);
            if (!FileOp.bO(this.reJ.getPath() + e)) {
                g.pWK.a(150, 31, 1, true);
            }
            g.pWK.h(11696, Integer.valueOf(3), Long.valueOf(Wz), Integer.valueOf(this.rfd), Thread.currentThread().getName(), ae.bwt(), e.bnD);
            if (this.reJ.qWO.qWU == 0 || this.reJ.qWO.qWU == 5) {
                i = com.tencent.mm.plugin.sns.data.i.f(this.fIx);
                r.b(this.reJ.getPath(), e, i, (float) ae.bwn());
                str = i;
            } else {
                str = e;
            }
            c.a(this.reJ.getPath() + str, this.reJ.url, 1, options.outMimeType, options.outWidth, options.outHeight, queryQuality, mi, Wz2);
            this.reI = com.tencent.mm.plugin.sns.data.i.Kr(this.reJ.getPath() + str);
            boolean b = com.tencent.mm.plugin.sns.data.i.b(this.reI);
            x.i("MicroMsg.SnsDownloadThumb", "download decode bitmap done : succ: " + b + " isWebp: " + this.hhq + " srcImgFileSize: " + mi);
            if (!b) {
                g.pWK.a(150, 65, 1, true);
                if (this.rfk) {
                    g.pWK.a(150, 50, 1, true);
                } else {
                    g.pWK.a(150, 51, 1, true);
                }
                if (this.rfj) {
                    g.pWK.a(150, 54, 1, true);
                }
                if (this.rfi) {
                    g.pWK.a(150, 57, 1, true);
                }
            }
            if (this.hhq && !b) {
                g.pWK.a(22, 65, 1, true);
            }
            if (this.rfk && b) {
                b.qq(v.CTRL_INDEX);
            }
        }
        return true;
    }

    protected final int bwS() {
        return 3;
    }
}
