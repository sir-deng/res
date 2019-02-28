package com.tencent.mm.plugin.tmassistant.a;

import com.tencent.mm.bx.h.d;
import com.tencent.mm.f.a.fz;
import com.tencent.mm.f.a.gb;
import com.tencent.mm.f.a.gc;
import com.tencent.mm.f.a.gd;
import com.tencent.mm.f.a.ge;
import com.tencent.mm.plugin.downloader.model.FileDownloadTaskInfo;
import com.tencent.mm.plugin.downloader.model.g.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.ap;
import java.util.HashMap;

public final class b implements ap {
    private a sjX;
    private c sjY = new c<fz>() {
        {
            this.xmG = fz.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            fz fzVar = (fz) bVar;
            x.i("MicroMsg.SubCoreTMAssistant", "addDownloadTask");
            a bFV = b.this.bFV();
            a aVar = new a();
            aVar.yr(fzVar.fwK.fwM);
            aVar.ys(fzVar.fwK.fwN);
            aVar.cj(fzVar.fwK.fileSize);
            aVar.yt(fzVar.fwK.fileName);
            aVar.yu(fzVar.fwK.fwO);
            aVar.oP(fzVar.fwK.fileType);
            aVar.setAppId(fzVar.fwK.appId);
            aVar.et(fzVar.fwK.fwP);
            aVar.eu(fzVar.fwK.fwQ);
            aVar.lyp.lym = fzVar.fwK.fwR;
            aVar.cu(fzVar.fwK.packageName);
            aVar.ev(fzVar.fwK.fwS);
            aVar.lO(fzVar.fwK.scene);
            fzVar.fwL.fnS = bFV.a(aVar.lyp);
            return true;
        }
    };
    private c sjZ = new c<gd>() {
        {
            this.xmG = gd.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            gd gdVar = (gd) bVar;
            x.i("MicroMsg.SubCoreTMAssistant", "removeDownloadTask");
            gdVar.fxd.count = b.this.bFV().bY(gdVar.fxc.fnS);
            return true;
        }
    };
    private c ska = new c<gc>() {
        {
            this.xmG = gc.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            gc gcVar = (gc) bVar;
            FileDownloadTaskInfo bZ = b.this.bFV().bZ(gcVar.fwY.fnS);
            gcVar.fwZ.url = bZ.url;
            gcVar.fwZ.status = bZ.status;
            gcVar.fwZ.path = bZ.path;
            gcVar.fwZ.frM = bZ.frM;
            gcVar.fwZ.fxa = bZ.fxa;
            gcVar.fwZ.fxb = bZ.fxb;
            return true;
        }
    };
    private c skb = new c<gb>() {
        {
            this.xmG = gb.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            gb gbVar = (gb) bVar;
            x.i("MicroMsg.SubCoreTMAssistant", "pauseDownloadTask");
            gbVar.fwX.foB = b.this.bFV().ca(gbVar.fwW.fnS);
            return true;
        }
    };
    private c skc = new c<ge>() {
        {
            this.xmG = ge.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            ge geVar = (ge) bVar;
            x.i("MicroMsg.SubCoreTMAssistant", "resumeDownloadTask");
            geVar.fxf.foB = b.this.bFV().cb(geVar.fxe.fnS);
            return true;
        }
    };

    public final a bFV() {
        if (this.sjX == null) {
            this.sjX = new a();
        }
        return this.sjX;
    }

    public final void bs(boolean z) {
        com.tencent.mm.sdk.b.a.xmy.b(this.sjY);
        com.tencent.mm.sdk.b.a.xmy.b(this.sjZ);
        com.tencent.mm.sdk.b.a.xmy.b(this.ska);
        com.tencent.mm.sdk.b.a.xmy.b(this.skb);
        com.tencent.mm.sdk.b.a.xmy.b(this.skc);
    }

    public final void onAccountRelease() {
        com.tencent.mm.sdk.b.a.xmy.c(this.sjY);
        com.tencent.mm.sdk.b.a.xmy.c(this.sjZ);
        com.tencent.mm.sdk.b.a.xmy.c(this.ska);
        com.tencent.mm.sdk.b.a.xmy.c(this.skb);
        com.tencent.mm.sdk.b.a.xmy.c(this.skc);
    }

    public final HashMap<Integer, d> Bu() {
        return null;
    }

    public final void ge(int i) {
    }

    public final void bt(boolean z) {
    }
}
