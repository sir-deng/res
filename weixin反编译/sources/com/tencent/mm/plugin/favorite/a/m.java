package com.tencent.mm.plugin.favorite.a;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.appbrand.jsapi.ap;
import com.tencent.mm.plugin.appbrand.jsapi.media.JsApiUploadEncryptedFileToCDN;
import com.tencent.mm.protocal.c.fl;
import com.tencent.mm.protocal.c.fm;
import com.tencent.mm.protocal.c.qj;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class m extends k implements com.tencent.mm.network.k {
    private final b gLB;
    private e gLE = null;
    private LinkedList<Integer> mwh;
    private int mwi = 0;

    public m(LinkedList<Integer> linkedList) {
        a aVar = new a();
        aVar.hnT = new fl();
        aVar.hnU = new fm();
        aVar.uri = "/cgi-bin/micromsg-bin/batchdelfavitem";
        aVar.hnS = ap.CTRL_INDEX;
        aVar.hnV = JsApiUploadEncryptedFileToCDN.CTRL_INDEX;
        aVar.hnW = 1000000194;
        this.gLB = aVar.Kf();
        this.mwh = linkedList;
    }

    private boolean aJy() {
        boolean z;
        if (this.mwh == null || this.mwi >= this.mwh.size()) {
            z = false;
        } else {
            z = true;
        }
        x.i("MicroMsg.NetSceneBatchDelFavItem", "check need continue, indexOK %B", Boolean.valueOf(z));
        return z;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        if (this.mwh == null || this.mwh.isEmpty() || this.mwi >= this.mwh.size()) {
            x.e("MicroMsg.NetSceneBatchDelFavItem", "klem doScene idList null, begIndex %d", Integer.valueOf(this.mwi));
            return -1;
        }
        int i;
        this.gLE = eVar2;
        x.i("MicroMsg.NetSceneBatchDelFavItem", "ashutest::do netscene size %d, begIndex %d, total %s", Integer.valueOf(this.mwh.size()), Integer.valueOf(this.mwi), this.mwh);
        fl flVar = (fl) this.gLB.hnQ.hnY;
        flVar.vRW.clear();
        int i2 = this.mwi;
        int i3 = 0;
        while (true) {
            i = i2;
            if (i >= this.mwh.size()) {
                break;
            }
            i2 = ((Integer) this.mwh.get(i)).intValue();
            if (i2 > 0) {
                flVar.vRW.add(Integer.valueOf(i2));
                i2 = i3 + 1;
            } else {
                i2 = i3;
            }
            if (i2 >= 20) {
                break;
            }
            i3 = i + 1;
            i = i3;
        }
        this.mwi = i + 1;
        flVar.kyA = flVar.vRW.size();
        x.i("MicroMsg.NetSceneBatchDelFavItem", "ashutest::do netscene checkd size %d, %s", Integer.valueOf(flVar.kyA), flVar.vRW);
        return a(eVar, this.gLB, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneBatchDelFavItem", "netId %d errType %d errCode %d begIndex %d idListSize %d errMsg %s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(this.mwi), Integer.valueOf(this.mwh.size()), str);
        if (i2 == 0 && i3 == 0) {
            LinkedList linkedList = ((fm) ((b) qVar).hnR.hnY).kyB;
            if (linkedList == null || linkedList.size() == 0) {
                x.e("MicroMsg.NetSceneBatchDelFavItem", "klem onGYNet resp list null");
                if (aJy()) {
                    a(this.hok, this.gLE);
                    return;
                } else {
                    this.gLE.a(i2, i3, str, this);
                    return;
                }
            }
            List arrayList = new ArrayList();
            x.i("MicroMsg.NetSceneBatchDelFavItem", "klem onGYNet respList size:%d", Integer.valueOf(linkedList.size()));
            for (int i4 = 0; i4 < linkedList.size(); i4++) {
                qj qjVar = (qj) linkedList.get(i4);
                if (qjVar.vQL < 0) {
                    x.w("MicroMsg.NetSceneBatchDelFavItem", "klem onGYNet favId:%d, delete failed", Integer.valueOf(qjVar.vNB));
                } else {
                    arrayList.add(Integer.valueOf(qjVar.vNB));
                    x.i("MicroMsg.NetSceneBatchDelFavItem", "klem onGYNet favId:%d deleted", Integer.valueOf(qjVar.vNB));
                }
            }
            j.aN(arrayList);
            if (aJy()) {
                a(this.hok, this.gLE);
            } else {
                this.gLE.a(i2, i3, str, this);
            }
        } else if (aJy()) {
            a(this.hok, this.gLE);
        } else {
            this.gLE.a(i2, i3, str, this);
        }
    }

    protected final int a(q qVar) {
        return b.hoz;
    }

    protected final int Bo() {
        return 10;
    }

    public final int getType() {
        return ap.CTRL_INDEX;
    }
}
