package com.tencent.mm.plugin.readerapp.b;

import com.tencent.mm.R;
import com.tencent.mm.f.a.cg;
import com.tencent.mm.f.a.mj;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.bg;
import java.util.List;

public final class d extends c<mj> {
    public d() {
        this.xmG = mj.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        mj mjVar = (mj) bVar;
        switch (mjVar.fEZ.opType) {
            case 3:
                boolean a;
                mj.b bVar2 = mjVar.fFa;
                cg cgVar = mjVar.fEZ.fFb;
                int i = mjVar.fEZ.fFc;
                x.i("MicroMsg.Sns.GetFavDataSource", "fav info, newsSvrid is %d, tweetId is %s", Integer.valueOf(i), mjVar.fEZ.fFd);
                List a2 = g.bmV().a((long) i, 20);
                if (!a2.isEmpty()) {
                    x.i("MicroMsg.Sns.GetFavDataSource", "fav news msgs");
                    String aD = bi.aD(r1, "");
                    for (int i2 = 0; i2 < a2.size(); i2++) {
                        if (aD.equals(((bg) a2.get(i2)).HN())) {
                            a = b.a(cgVar, (bg) a2.get(i2), i2);
                            bVar2.fqR = a;
                            break;
                        }
                    }
                }
                cgVar.frk.frq = R.l.efu;
                a = false;
                bVar2.fqR = a;
            case 4:
                g.bmV().gZ(mjVar.fEZ.fFe);
                break;
        }
        return false;
    }
}
