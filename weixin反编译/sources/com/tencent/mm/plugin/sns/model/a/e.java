package com.tencent.mm.plugin.sns.model.a;

import android.graphics.BitmapFactory.Options;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.h.c;
import com.tencent.mm.plugin.sns.model.a.c.a;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.storage.r;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.MMNativeJpeg;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class e extends f {
    public e(a aVar, a aVar2) {
        super(aVar, aVar2);
    }

    public final boolean bwR() {
        Object obj;
        long Wz;
        long j = -1;
        String l = i.l(this.fIx);
        String str = this.reJ.getPath() + this.reJ.bwP();
        Options options = new Options();
        options.inJustDecodeBounds = true;
        MMBitmapFactory.decodeFile(str, options, null, 0, new int[0]);
        String toLowerCase = options.outMimeType != null ? options.outMimeType.toLowerCase() : "";
        long mi = FileOp.mi(str);
        int obj2;
        if (this.rfi || toLowerCase.contains("webp")) {
            obj2 = null;
        } else if (this.rfj || toLowerCase.contains("vcodec")) {
            obj2 = 1;
        } else {
            obj2 = 2;
        }
        long Wz2;
        long bB;
        switch (obj2) {
            case null:
                g.pWK.a(22, 64, 1, true);
                FileOp.deleteFile(this.reJ.getPath() + l);
                Wz2 = bi.Wz();
                r.d(this.reJ.getPath(), this.reJ.getPath() + this.reJ.bwP(), l, false);
                bB = bi.bB(Wz2);
                FileOp.deleteFile(this.reJ.getPath() + this.reJ.bwP());
                j = bi.bB(Wz2);
                c.a(this.reJ.getPath() + l, this.reJ.url, 0, options.outMimeType, options.outWidth, options.outHeight, -1, mi, bB);
                break;
            case 1:
                x.i("MicroMsg.SnsDownloadImage", "found vcodec:%s, reencoded.", this.reJ.getPath() + this.reJ.bwP());
                FileOp.deleteFile(this.reJ.getPath() + l);
                Wz2 = bi.Wz();
                r.d(this.reJ.getPath(), this.reJ.getPath() + this.reJ.bwP(), l, false);
                bB = bi.bB(Wz2);
                FileOp.deleteFile(this.reJ.getPath() + this.reJ.bwP());
                j = bi.bB(Wz2);
                c.a(this.reJ.getPath() + l, this.reJ.url, 0, options.outMimeType, options.outWidth, options.outHeight, -1, mi, bB);
                break;
            case 2:
                bB = -1;
                if (i.Kw(this.reJ.getPath() + this.reJ.bwP())) {
                    x.w("MicroMsg.SnsDownloadImage", "the " + this.reJ.mediaId + " is too max ! " + this.reJ.url);
                    FileOp.deleteFile(this.reJ.getPath() + l);
                    Wz = bi.Wz();
                    r.Y(this.reJ.getPath(), this.reJ.getPath() + this.reJ.bwP(), l);
                    bB = bi.bB(Wz);
                    FileOp.deleteFile(this.reJ.getPath() + this.reJ.bwP());
                    j = bi.bB(Wz);
                } else {
                    FileOp.g(this.reJ.getPath(), this.reJ.bwP(), l);
                    j = 0;
                }
                int i = -1;
                if (toLowerCase.contains("jpg") || toLowerCase.contains("jpeg")) {
                    i = MMNativeJpeg.queryQuality(this.reJ.getPath() + l);
                    if (i == 0) {
                        i = -1;
                    }
                }
                c.a(this.reJ.getPath() + l, this.reJ.url, 0, options.outMimeType, options.outWidth, options.outHeight, i, mi, bB);
                break;
        }
        x.i("MicroMsg.SnsDownloadImage", "donwload big pic isWebp " + (obj2 == null));
        Wz = FileOp.mi(this.reJ.getPath() + l);
        g.pWK.h(11696, Integer.valueOf(3), Long.valueOf(j), Long.valueOf(Wz), Thread.currentThread().getName(), ae.bwt(), com.tencent.mm.compatible.util.e.bnD);
        Object obj3 = this.reJ.reF != 3 ? 1 : null;
        if (!(this.reJ.qWO == null || this.reJ.qWO.qWU == 4 || this.reJ.qWO.qWU == 5)) {
            obj3 = null;
        }
        if (obj3 != null) {
            toLowerCase = i.e(this.fIx);
            if (FileOp.bO(this.reJ.getPath() + toLowerCase)) {
                FileOp.deleteFile(this.reJ.getPath() + toLowerCase);
            }
            long Wz3 = bi.Wz();
            r.a(this.reJ.getPath(), l, toLowerCase, (float) ae.bwo());
            Wz3 = bi.bB(Wz3);
            FileOp.mi(this.reJ.getPath() + toLowerCase);
            g.pWK.h(11696, Integer.valueOf(3), Long.valueOf(Wz3), Long.valueOf(Wz), Thread.currentThread().getName(), ae.bwt(), com.tencent.mm.compatible.util.e.bnD);
            toLowerCase = i.f(this.fIx);
            if (!FileOp.bO(this.reJ.getPath() + toLowerCase)) {
                r.b(this.reJ.getPath(), l, toLowerCase, (float) ae.bwn());
            }
        }
        return true;
    }

    protected final int bwS() {
        return 1;
    }
}
