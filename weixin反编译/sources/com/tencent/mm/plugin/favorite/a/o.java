package com.tencent.mm.plugin.favorite.a;

import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.modelcdntran.g;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.fav.a.f;
import com.tencent.mm.plugin.favorite.h;
import com.tencent.mm.protocal.c.mu;
import com.tencent.mm.protocal.c.mv;
import com.tencent.mm.protocal.c.mw;
import com.tencent.mm.protocal.c.uy;
import com.tencent.mm.protocal.c.uz;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.xwalk.core.XWalkUpdater;

public final class o extends k implements com.tencent.mm.network.k {
    private final b gLB;
    private e gLE = null;
    private int mwm = 0;
    public f mwn;
    private boolean mwo = true;
    private boolean mwp = false;
    HashMap<uz, Boolean> mwq = new HashMap();

    public o(f fVar) {
        a aVar = new a();
        aVar.hnT = new mv();
        aVar.hnU = new mw();
        aVar.uri = "/cgi-bin/micromsg-bin/checkcdn";
        aVar.hnS = TencentLocation.ERROR_UNKNOWN;
        aVar.hnV = 197;
        aVar.hnW = 1000000197;
        this.gLB = aVar.Kf();
        this.mwn = fVar;
        Iterator it = fVar.field_favProto.wlY.iterator();
        while (it.hasNext()) {
            this.mwq.put((uz) it.next(), Boolean.valueOf(false));
        }
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        int i;
        this.gLE = eVar2;
        int i2 = 0;
        Iterator it = this.mwq.keySet().iterator();
        while (true) {
            i = i2;
            if (!it.hasNext()) {
                break;
            }
            if (((Boolean) this.mwq.get((uz) it.next())).booleanValue()) {
                i2 = i;
            } else {
                i2 = i + 1;
            }
        }
        if (i == 0) {
            x.e("MicroMsg.NetSceneCheckCDN", "klem doScene data list null");
            this.mwm = -100;
            return -100;
        }
        int i3;
        int i4 = 0;
        mv mvVar = (mv) this.gLB.hnQ.hnY;
        mvVar.kyB.clear();
        List list = this.mwn.field_favProto.wlY;
        int i5 = 0;
        while (true) {
            i3 = i5;
            int i6 = i4;
            if (i3 >= list.size()) {
                i4 = i6;
                break;
            }
            uz uzVar = (uz) list.get(i3);
            if (!((Boolean) this.mwq.get(uzVar)).booleanValue()) {
                if (!uzVar.wkz) {
                    mu muVar = new mu();
                    muVar.wcn = (int) uzVar.wki;
                    muVar.wcl = uzVar.wke;
                    muVar.wcm = uzVar.wkg;
                    muVar.wck = String.valueOf(i3);
                    muVar.wcp = uzVar.wkv;
                    muVar.wco = this.mwn.field_sourceType;
                    muVar.wcq = 0;
                    mvVar.kyB.add(muVar);
                    i6++;
                    x.i("MicroMsg.NetSceneCheckCDN", "check CDN, dataId %s, dataSourceId %s, DataSourceType %s, FullSize %d, FullMd5 %s, Head256Md5 %s", muVar.wck, muVar.wcp, Integer.valueOf(muVar.wco), Integer.valueOf(muVar.wcn), muVar.wcl, muVar.wcm);
                }
                if (uzVar.wkB) {
                    i4 = i6;
                } else {
                    mu muVar2 = new mu();
                    muVar2.wcn = (int) uzVar.wkt;
                    muVar2.wcl = uzVar.wkp;
                    muVar2.wcm = uzVar.wkr;
                    muVar2.wcp = uzVar.wkv;
                    muVar2.wco = this.mwn.field_sourceType;
                    muVar2.wck = i3 + "t";
                    muVar2.wcq = 1;
                    mvVar.kyB.add(muVar2);
                    i4 = i6 + 1;
                    x.i("MicroMsg.NetSceneCheckCDN", "check CDN thumb, dataId %s, dataSourceId %s, DataSourceType %s, FullSize %d, FullMd5 %s, Head256Md5 %s", muVar2.wck, muVar2.wcp, Integer.valueOf(muVar2.wco), Integer.valueOf(muVar2.wcn), muVar2.wcl, muVar2.wcm);
                }
                if (i4 >= 19) {
                    break;
                }
            } else {
                i4 = i6;
            }
            i5 = i3 + 1;
        }
        x.i("MicroMsg.NetSceneCheckCDN", "doScene:  usedCount %d, dataSize %d, nextBegIndex %d", Integer.valueOf(i4), Integer.valueOf(i), Integer.valueOf(i3 + 1));
        mvVar.kyA = i4;
        if (i4 != 0) {
            return a(eVar, this.gLB, this);
        }
        x.w("MicroMsg.NetSceneCheckCDN", "no more data, must not check cdn!");
        this.mwm = XWalkUpdater.ERROR_SET_VERNUM;
        return XWalkUpdater.ERROR_SET_VERNUM;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneCheckCDN", "netId %d errType %d errCode %d localErrCode %d errMsg %s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(this.mwm), str);
        if (!(i2 == 0 && i3 == 0)) {
            if (i2 == 3 && this.mwm == -100) {
                x.d("MicroMsg.NetSceneCheckCDN", "need not check cdn, add fav now");
                h.getFavItemInfoStorage().t(9, this.mwn.field_localId);
                h.aIU().run();
                this.gLE.a(i2, i3, str, this);
                return;
            } else if (i2 == 3 && this.mwm == XWalkUpdater.ERROR_SET_VERNUM) {
                i3 = 0;
            } else {
                this.gLE.a(i2, i3, str, this);
                return;
            }
        }
        if (this.mwm != XWalkUpdater.ERROR_SET_VERNUM && i2 == 0 && i3 == 0) {
            int i4;
            List list = ((mw) ((b) qVar).hnR.hnY).kyB;
            List list2 = this.mwn.field_favProto.wlY;
            int i5 = 0;
            while (true) {
                int i6 = i5;
                if (i6 >= list.size()) {
                    break;
                }
                uy uyVar = (uy) list.get(i6);
                String str2 = uyVar.wck;
                if (!bi.oN(str2)) {
                    uz uzVar;
                    x.i("MicroMsg.NetSceneCheckCDN", "klem OnGYNet status:%d, tmpId %s", Integer.valueOf(uyVar.kyY), str2);
                    if (uyVar.kyY == 1) {
                        if (str2.endsWith("t")) {
                            uzVar = (uz) list2.get(bi.getInt(str2.substring(0, str2.length() - 1), 0));
                            x.i("MicroMsg.NetSceneCheckCDN", "klem OnGYNet cdn thumb exist, update url:%s, key:%s, DataId %s, FullMd5 %s, FullSize %d, Head256Md5 %s", uyVar.wjD, uyVar.vXE, uyVar.wck, uyVar.wcl, Integer.valueOf(uyVar.wcn), uyVar.wcm);
                            uzVar.TY(uyVar.vXE);
                            uzVar.TX(uyVar.wjD);
                            if (uyVar.wcn > 0) {
                                uzVar.fy((long) uyVar.wcn);
                                if (!(bi.oN(uyVar.wcl) || uyVar.wcl.equals(uzVar.wkp))) {
                                    x.w("MicroMsg.NetSceneCheckCDN", "svrThumbMd5 %s, localThumbMd5 %s", uyVar.wcl, uzVar.wkp);
                                    uzVar.Ul(uyVar.wcl);
                                }
                                if (!(bi.oN(uyVar.wcm) || uyVar.wcm.equals(uzVar.wkr))) {
                                    x.w("MicroMsg.NetSceneCheckCDN", "svrThumbHead256md5 %s, localThumbHead256md5 %s", uyVar.wcm, uzVar.wkr);
                                    uzVar.Um(uyVar.wcm);
                                }
                            }
                        } else {
                            uzVar = (uz) list2.get(bi.getInt(str2, 0));
                            x.i("MicroMsg.NetSceneCheckCDN", "klem OnGYNet cdn data exist, update url:%s, key:%s, DataId %s, FullMd5 %s, FullSize %d, Head256Md5 %s", uyVar.wjD, uyVar.vXE, uyVar.wck, uyVar.wcl, Integer.valueOf(uyVar.wcn), uyVar.wcm);
                            uzVar.Ua(uyVar.vXE);
                            uzVar.TZ(uyVar.wjD);
                            if (!bi.oN(uyVar.wjE)) {
                                uzVar.Uo(uyVar.wjE);
                            }
                            if (bi.oN(uzVar.wke)) {
                                x.i("MicroMsg.NetSceneCheckCDN", "klem OnGYNet cdn exist, local not exist");
                                uzVar.Ug(uyVar.wcl);
                                uzVar.fx((long) uyVar.wcn);
                                uzVar.Uh(uyVar.wcm);
                                j.a(uzVar, this.mwn, 1, false);
                            }
                            if (!(bi.oN(uyVar.wcl) || uyVar.wcl.equals(uzVar.wke))) {
                                x.w("MicroMsg.NetSceneCheckCDN", "svrFullMd5 %s, localMd5 %s", uyVar.wcl, uzVar.wke);
                                uzVar.Ug(uyVar.wcl);
                            }
                            if (!(bi.oN(uyVar.wcm) || uyVar.wcm.equals(uzVar.wkg))) {
                                x.w("MicroMsg.NetSceneCheckCDN", "svrHead256md5 %s, localHead256md5 %s", uyVar.wcm, uzVar.wkg);
                                uzVar.Uh(uyVar.wcm);
                            }
                            if (uyVar.wcn > 0 && ((long) uyVar.wcn) != uzVar.wki) {
                                x.w("MicroMsg.NetSceneCheckCDN", "svrFullSize %d, localFullSize %d", Integer.valueOf(uyVar.wcn), Long.valueOf(uzVar.wki));
                                uzVar.fx((long) uyVar.wcn);
                            }
                        }
                    }
                    if (str2.endsWith("t")) {
                        this.mwq.put((uz) list2.get(bi.getInt(str2.substring(0, str2.length() - 1), 0)), Boolean.valueOf(true));
                    } else {
                        this.mwq.put((uz) list2.get(bi.getInt(str2, 0)), Boolean.valueOf(true));
                    }
                    if (uyVar.kyY == 3 || uyVar.kyY == -2 || uyVar.kyY == -1) {
                        if (str2.endsWith("t")) {
                            uzVar = (uz) list2.get(bi.getInt(str2.substring(0, str2.length() - 1), 0));
                            if (bi.oN(uzVar.wkp)) {
                                x.i("MicroMsg.NetSceneCheckCDN", "klem OnGYNet thumb cdn not exist, local not exist ", uzVar.wkp);
                            } else {
                                this.mwo = false;
                                if (bi.oN(uzVar.wjP)) {
                                    g.MQ();
                                    uzVar.Ua(com.tencent.mm.modelcdntran.b.MI());
                                    x.i("MicroMsg.NetSceneCheckCDN", "local not exist cdn data key, generate %s", r10);
                                }
                                x.i("MicroMsg.NetSceneCheckCDN", "klem OnGYNet cdn not exist, insert thumb md5:%s cdnkey:%s", uzVar.wke, uzVar.wjP);
                                j.a(uzVar, this.mwn, 0);
                            }
                        } else {
                            uzVar = (uz) list2.get(bi.getInt(str2, 0));
                            if (bi.oN(uzVar.wke)) {
                                x.i("MicroMsg.NetSceneCheckCDN", "klem OnGYNet data cdn not exist, local not exist ", uzVar.wke);
                            } else {
                                this.mwo = false;
                                if (bi.oN(uzVar.wjP)) {
                                    g.MQ();
                                    uzVar.Ua(com.tencent.mm.modelcdntran.b.MI());
                                    x.i("MicroMsg.NetSceneCheckCDN", "local not exist cdn data key, generate %s", r10);
                                }
                                x.i("MicroMsg.NetSceneCheckCDN", "klem OnGYNet cdn not exist, insert data md5:%s cdnkey:%s", uzVar.wke, uzVar.wjP);
                                j.a(uzVar, this.mwn, 0, false);
                            }
                        }
                    }
                    if (uyVar.kyY == 2) {
                        this.mwp = true;
                        if (str2.endsWith("t")) {
                            x.e("MicroMsg.NetSceneCheckCDN", "klem OnGYNet svr uploading thumb?! should not reach here!!");
                        } else {
                            x.i("MicroMsg.NetSceneCheckCDN", "klem OnGYNet data cdn not exist svr upload, dataStatus:%d, CdnUrl:%s, CdnKey:%s", Integer.valueOf(uyVar.wjF), uyVar.wjD, uyVar.vXE);
                            uzVar = (uz) list2.get(bi.getInt(str2, 0));
                            uzVar.Dd(uyVar.wjF);
                            uzVar.Ua(uyVar.vXE);
                            uzVar.TZ(uyVar.wjD);
                            if (!bi.oN(uyVar.wjE)) {
                                uzVar.Uo(uyVar.wjE);
                            }
                            if (!(bi.oN(uyVar.wcl) || uyVar.wcl.equals(uzVar.wke))) {
                                x.w("MicroMsg.NetSceneCheckCDN", "SVR_UPLOADING::svrFullMd5 %s, localMd5 %s", uyVar.wcl, uzVar.wke);
                                uzVar.Ug(uyVar.wcl);
                            }
                            if (!(bi.oN(uyVar.wcm) || uyVar.wcm.equals(uzVar.wkg))) {
                                x.w("MicroMsg.NetSceneCheckCDN", "SVR_UPLOADING::svrHead256md5 %s, localHead256md5 %s", uyVar.wcm, uzVar.wkg);
                                uzVar.Uh(uyVar.wcm);
                            }
                            if (uyVar.wcn > 0 && ((long) uyVar.wcn) != uzVar.wki) {
                                x.w("MicroMsg.NetSceneCheckCDN", "SVR_UPLOADING::svrFullSize %d, localFullSize %d", Integer.valueOf(uyVar.wcn), Long.valueOf(uzVar.wki));
                                uzVar.fx((long) uyVar.wcn);
                            }
                        }
                    }
                }
                i5 = i6 + 1;
            }
            i5 = 0;
            Iterator it = this.mwq.keySet().iterator();
            while (true) {
                i4 = i5;
                if (!it.hasNext()) {
                    break;
                }
                if (((Boolean) this.mwq.get((uz) it.next())).booleanValue()) {
                    i5 = i4;
                } else {
                    i5 = i4 + 1;
                }
            }
            x.i("MicroMsg.NetSceneCheckCDN", "onGYSceneEnd:  resultCount %d, dataSize %d", Integer.valueOf(list.size()), Integer.valueOf(list2.size()));
            if (i4 > 0) {
                x.w("MicroMsg.NetSceneCheckCDN", "check cdn list not end, continues");
                i5 = a(this.hok, this.gLE);
                if (!(i5 == -100 || i5 == XWalkUpdater.ERROR_SET_VERNUM)) {
                    return;
                }
            }
        }
        if (this.mwp) {
            x.i("MicroMsg.NetSceneCheckCDN", "klem onGYNet waitServerUpload, send item now");
            this.mwn.field_itemStatus = 12;
            h.getFavItemInfoStorage().a(this.mwn, "localId");
            h.aIU().run();
            this.gLE.a(i2, i3, str, this);
            return;
        }
        if (this.mwo) {
            x.i("MicroMsg.NetSceneCheckCDN", "klem onGYNet all data exist, start send item");
            if (this.mwn.field_id > 0) {
                this.mwn.field_itemStatus = 17;
                h.getFavItemInfoStorage().a(this.mwn, "localId");
                h.aIW().run();
            } else {
                if (this.mwn.field_type == 18) {
                    this.mwn.field_favProto.Dk(1);
                }
                this.mwn.field_itemStatus = 9;
                h.getFavItemInfoStorage().a(this.mwn, "localId");
                h.aIU().run();
            }
        } else {
            if (this.mwn.field_id > 0) {
                this.mwn.field_itemStatus = 15;
            } else {
                if (this.mwn.field_type == 18) {
                    this.mwn.field_favProto.Dk(1);
                }
                this.mwn.field_itemStatus = 4;
            }
            h.getFavItemInfoStorage().a(this.mwn, "localId");
            h.aIY().run();
        }
        this.gLE.a(i2, i3, str, this);
    }

    protected final int a(q qVar) {
        return b.hoz;
    }

    protected final int Bo() {
        return 10;
    }

    public final int getType() {
        return TencentLocation.ERROR_UNKNOWN;
    }
}
