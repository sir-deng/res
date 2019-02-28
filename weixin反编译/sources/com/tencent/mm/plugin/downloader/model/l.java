package com.tencent.mm.plugin.downloader.model;

import com.tencent.mm.f.a.fz;
import com.tencent.mm.f.a.ga;
import com.tencent.mm.f.a.gb;
import com.tencent.mm.f.a.gc;
import com.tencent.mm.f.a.gd;
import com.tencent.mm.f.a.ge;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;

final class l extends j {
    private c hkk = new c<ga>() {
        {
            this.xmG = ga.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            ga gaVar = (ga) bVar;
            switch (gaVar.fwT.fwU) {
                case 1:
                    l.this.lya.i(gaVar.fwT.id, gaVar.fwT.path);
                    break;
                case 2:
                    l.this.lya.cd(gaVar.fwT.id);
                    break;
                case 4:
                    l.this.lya.b(gaVar.fwT.id, gaVar.fwT.errCode, gaVar.fwT.fwV);
                    break;
                case 5:
                    l.this.lya.cc(gaVar.fwT.id);
                    break;
                case 6:
                    l.this.lya.j(gaVar.fwT.id, gaVar.fwT.path);
                    break;
                case 7:
                    l.this.lya.ce(gaVar.fwT.id);
                    break;
                case 101:
                    f aAK = f.aAK();
                    aAK.lxT = aAK.aAM();
                    break;
            }
            return true;
        }
    };

    public l(c cVar) {
        super(cVar);
        a.xmy.b(this.hkk);
    }

    public final long a(g gVar) {
        b fzVar = new fz();
        fzVar.fwK.fwM = gVar.iIj;
        fzVar.fwK.fwN = gVar.lyg;
        fzVar.fwK.fileSize = gVar.lyh;
        fzVar.fwK.fileName = gVar.mFileName;
        fzVar.fwK.fwO = gVar.lyi;
        fzVar.fwK.fileType = gVar.lyj;
        fzVar.fwK.appId = gVar.mAppId;
        fzVar.fwK.fwP = gVar.lyk;
        fzVar.fwK.fwQ = gVar.lyl;
        fzVar.fwK.fwR = gVar.lym;
        fzVar.fwK.packageName = gVar.mPackageName;
        fzVar.fwK.fwS = gVar.lyn;
        fzVar.fwK.scene = gVar.itU;
        a.xmy.m(fzVar);
        return fzVar.fwL.fnS;
    }

    public final int bY(long j) {
        b gdVar = new gd();
        gdVar.fxc.fnS = j;
        a.xmy.m(gdVar);
        return gdVar.fxd.count;
    }

    public final FileDownloadTaskInfo bZ(long j) {
        b gcVar = new gc();
        gcVar.fwY.fnS = j;
        a.xmy.m(gcVar);
        FileDownloadTaskInfo fileDownloadTaskInfo = new FileDownloadTaskInfo();
        fileDownloadTaskInfo.id = j;
        fileDownloadTaskInfo.url = gcVar.fwZ.url;
        fileDownloadTaskInfo.status = gcVar.fwZ.status;
        fileDownloadTaskInfo.path = gcVar.fwZ.path;
        fileDownloadTaskInfo.frM = gcVar.fwZ.frM;
        fileDownloadTaskInfo.fxa = gcVar.fwZ.fxa;
        fileDownloadTaskInfo.fxb = gcVar.fwZ.fxb;
        return fileDownloadTaskInfo;
    }

    public final boolean ca(long j) {
        b gbVar = new gb();
        gbVar.fwW.fnS = j;
        a.xmy.m(gbVar);
        return gbVar.fwX.foB;
    }

    public final boolean cb(long j) {
        b geVar = new ge();
        geVar.fxe.fnS = j;
        a.xmy.m(geVar);
        return geVar.fxf.foB;
    }
}
