package com.tencent.mm.plugin.i.a;

import com.tencent.mm.a.e;
import com.tencent.mm.ap.o;
import com.tencent.mm.plugin.i.b.a;
import com.tencent.mm.pluginsdk.model.app.an;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.x.g;
import java.util.ArrayList;
import java.util.List;

public final class b extends a {
    protected final List<a> J(au auVar) {
        String str = null;
        if (auVar == null) {
            return null;
        }
        g.a fV;
        String Wn = bi.Wn(auVar.field_content);
        if (Wn != null) {
            fV = g.a.fV(Wn);
        } else {
            fV = null;
        }
        if (fV == null) {
            x.e("MicroMsg.AppMsgImgMsgHandler", "content is null");
            return null;
        }
        a K = a.K(auVar);
        com.tencent.mm.pluginsdk.model.app.b Se = an.aqK().Se(fV.for);
        long j = 0;
        if (Se != null) {
            str = Se.field_fileFullPath;
            j = (long) e.bN(str);
        }
        K.field_msgSubType = 30;
        K.field_path = wy(str);
        K.field_size = j;
        Wn = o.PC().B(auVar.field_imgPath, true);
        long bN = (long) e.bN(Wn);
        a K2 = a.K(auVar);
        K2.field_msgSubType = 31;
        K2.field_path = wy(Wn);
        K2.field_size = bN;
        x.i("MicroMsg.AppMsgImgMsgHandler", "%s create app msg wx file index app[%s] thumb[%s]", atw(), K, K2);
        List<a> arrayList = new ArrayList();
        arrayList.add(K);
        arrayList.add(K2);
        return arrayList;
    }

    protected final String atw() {
        return "AppMsgImg_" + hashCode();
    }
}
