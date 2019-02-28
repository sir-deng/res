package com.tencent.mm.plugin.favorite.a;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.fav.a.f;
import com.tencent.mm.plugin.favorite.h;
import com.tencent.mm.protocal.c.fx;
import com.tencent.mm.protocal.c.fy;
import com.tencent.mm.protocal.c.uz;
import com.tencent.mm.protocal.c.vi;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.as;
import com.tencent.mm.y.c;
import java.io.File;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public final class n extends k implements com.tencent.mm.network.k {
    private static AtomicInteger mwl = new AtomicInteger(0);
    private final b gLB;
    private e gLE = null;
    private LinkedList<Integer> mwh;
    private int mwi = 0;
    private boolean mwj = false;
    private boolean mwk = false;

    public n(LinkedList<Integer> linkedList) {
        a aVar = new a();
        aVar.hnT = new fx();
        aVar.hnU = new fy();
        aVar.uri = "/cgi-bin/micromsg-bin/batchgetfavitem";
        aVar.hnS = com.tencent.mm.plugin.appbrand.jsapi.a.e.CTRL_INDEX;
        aVar.hnV = 0;
        aVar.hnW = 0;
        this.gLB = aVar.Kf();
        this.mwh = linkedList;
        mwl.incrementAndGet();
    }

    public static void aJz() {
        mwl.set(0);
    }

    public static void aJA() {
        mwl.decrementAndGet();
    }

    public static int aJB() {
        return mwl.get();
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        x.i("MicroMsg.NetSceneBatchgetFav", "ashutest::doscene count:%d", Integer.valueOf(mwl.get()));
        if (this.mwh == null || this.mwh.isEmpty() || this.mwi >= this.mwh.size()) {
            x.e("MicroMsg.NetSceneBatchgetFav", "klem doScene, idlist null, begIndex %d", Integer.valueOf(this.mwi));
            return -1;
        }
        x.i("MicroMsg.NetSceneBatchgetFav", "ashutest::do netscene size %d, begIndex %d, total %s", Integer.valueOf(this.mwh.size()), Integer.valueOf(this.mwi), this.mwh);
        as.Hm();
        if (bi.e((Integer) c.Db().get(8217, null)) == 0) {
            x.w("MicroMsg.NetSceneBatchgetFav", "klem doScene, init not done, do not batchget");
            return -1;
        }
        fx fxVar = (fx) this.gLB.hnQ.hnY;
        LinkedList linkedList = new LinkedList();
        linkedList.addAll(this.mwh.subList(this.mwi, Math.min(this.mwi + 15, this.mwh.size())));
        fxVar.vRW = linkedList;
        fxVar.kyA = linkedList.size();
        this.mwi += 15;
        x.i("MicroMsg.NetSceneBatchgetFav", "ashutest::do netscene checkd size %d, %s", Integer.valueOf(linkedList.size()), linkedList);
        this.gLE = eVar2;
        return a(eVar, this.gLB, this);
    }

    private boolean aJy() {
        boolean z;
        boolean z2;
        as.Hm();
        if (bi.e((Integer) c.Db().get(8217, null)) == 0) {
            z = true;
        } else {
            z = false;
        }
        if (this.mwh == null || this.mwi >= this.mwh.size()) {
            z2 = false;
        } else {
            z2 = true;
        }
        x.i("MicroMsg.NetSceneBatchgetFav", "check needContinue, notInit %B indexOK %B", Boolean.valueOf(z), Boolean.valueOf(z2));
        if (z || !z2) {
            return false;
        }
        return true;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneBatchgetFav", "netId %d errType %d errCode %d begIndex %d idListSize %d errMsg[%s]", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(this.mwi), Integer.valueOf(this.mwh.size()), str);
        if (i2 == 0 && i3 == 0) {
            fy fyVar = (fy) ((b) qVar).hnR.hnY;
            int i4 = fyVar.kyA;
            int size = fyVar.vSf.size();
            if (i4 != size) {
                String str2 = "MicroMsg.NetSceneBatchgetFav";
                String str3 = "klem onGYNet resp list size:%d, return count %d, request count %d";
                Object[] objArr = new Object[3];
                objArr[0] = Integer.valueOf(size);
                objArr[1] = Integer.valueOf(i4);
                objArr[2] = Integer.valueOf(this.mwi > this.mwh.size() ? this.mwh.size() % 15 : 15);
                x.e(str2, str3, objArr);
                if (aJy()) {
                    a(this.hok, this.gLE);
                    return;
                }
                mwl.decrementAndGet();
                this.gLE.a(i2, -1, str, this);
                return;
            }
            for (int i5 = 0; i5 < size; i5++) {
                vi viVar = (vi) fyVar.vSf.get(i5);
                x.i("MicroMsg.NetSceneBatchgetFav", "klem onGYNet favid:%d, status:%d", Integer.valueOf(viVar.vNB), Integer.valueOf(viVar.kyY));
                if (viVar.kyY == 0) {
                    f dd = h.getFavItemInfoStorage().dd((long) viVar.vNB);
                    if (dd == null) {
                        x.e("MicroMsg.NetSceneBatchgetFav", "klem onGYNet favid:%d not exist!", Integer.valueOf(viVar.vNB));
                    } else {
                        dd.field_xml = viVar.vNI;
                        dd.Av(viVar.vNI);
                        dd.field_flag = viVar.vNC;
                        dd.field_localSeq = viVar.vNE;
                        dd.field_updateTime = (((long) viVar.vND) * 1000) + ((long) i5);
                        x.i("MicroMsg.NetSceneBatchgetFav", "huahuahailang:item field_xml batgch get :\n %s", dd.field_xml);
                        int size2 = dd.field_favProto.wlY.size();
                        if (size2 == 0) {
                            x.v("MicroMsg.NetSceneBatchgetFav", "this item has no data, favId:%d", Integer.valueOf(dd.field_id));
                        } else {
                            List list = dd.field_favProto.wlY;
                            for (int i6 = size2 - 1; i6 >= 0; i6--) {
                                uz uzVar = (uz) list.get(i6);
                                if (!bi.oN(uzVar.wke)) {
                                    x.i("MicroMsg.NetSceneBatchgetFav", "dataFIle: %s", new File(j.h(uzVar)).getName());
                                    if (new File(j.h(uzVar)).exists()) {
                                        if (uzVar.wkD != 0) {
                                            x.v("MicroMsg.NetSceneBatchgetFav", "server upload data failed, client upload, md5%s", uzVar.wke);
                                            this.mwk = true;
                                            j.a(uzVar, dd, 0, false);
                                        }
                                        x.d("MicroMsg.NetSceneBatchgetFav", "data exist, favId:%d, dataIndex:%d", Integer.valueOf(dd.field_id), Integer.valueOf(i6));
                                    } else if (bi.oN(uzVar.wjP) || bi.oN(uzVar.wjN)) {
                                        x.e("MicroMsg.NetSceneBatchgetFav", "data key or url null. favId:%d", Integer.valueOf(dd.field_id));
                                    } else {
                                        x.d("MicroMsg.NetSceneBatchgetFav", "local data not exist, insert cdninfo, favId:%d, dataIndex:%d", Integer.valueOf(dd.field_id), Integer.valueOf(i6));
                                        j.a(uzVar, dd, 1, false);
                                        this.mwj = true;
                                    }
                                }
                                if (!bi.oN(uzVar.wkp)) {
                                    if (new File(j.i(uzVar)).exists()) {
                                        x.d("MicroMsg.NetSceneBatchgetFav", "thumb exist, favId:%d, dataIndex:%d", Integer.valueOf(dd.field_id), Integer.valueOf(i6));
                                    } else if (bi.oN(uzVar.wjJ) || bi.oN(uzVar.hcU)) {
                                        x.w("MicroMsg.NetSceneBatchgetFav", "thumb key or url null. favId:%d", Integer.valueOf(dd.field_id));
                                    } else {
                                        x.d("MicroMsg.NetSceneBatchgetFav", "local thumb not exist, insert cdninfo, favId:%d, dataIndex:%d", Integer.valueOf(dd.field_id), Integer.valueOf(i6));
                                        j.a(uzVar, dd, 1);
                                        this.mwj = true;
                                    }
                                }
                            }
                        }
                        x.i("MicroMsg.NetSceneBatchgetFav", "data dealed needUpload:%b  needDownload:%b", Boolean.valueOf(this.mwk), Boolean.valueOf(this.mwj));
                        if (this.mwk) {
                            dd.field_itemStatus = 15;
                            h.getFavItemInfoStorage().a(dd, "localId");
                            h.aIY().run();
                        } else if (this.mwj) {
                            dd.field_itemStatus = 10;
                            h.getFavItemInfoStorage().a(dd, "localId");
                        } else {
                            dd.field_itemStatus = 10;
                            h.getFavItemInfoStorage().a(dd, "localId");
                        }
                        j.t(dd);
                        dd.Aw("MicroMsg.NetSceneBatchgetFav");
                    }
                }
                if ((viVar.vNC & 1) != 0) {
                    x.d("MicroMsg.NetSceneBatchgetFav", "klem onGYNet favId: %d status not exist, delete local item", Integer.valueOf(viVar.vNB));
                    j.a(h.getFavItemInfoStorage().dd((long) viVar.vNB), null);
                }
            }
            h.aIY().run();
            if (aJy()) {
                a(this.hok, this.gLE);
                return;
            }
            mwl.decrementAndGet();
            this.gLE.a(i2, i3, str, this);
        } else if (aJy()) {
            a(this.hok, this.gLE);
        } else {
            mwl.decrementAndGet();
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
        return com.tencent.mm.plugin.appbrand.jsapi.a.e.CTRL_INDEX;
    }
}
