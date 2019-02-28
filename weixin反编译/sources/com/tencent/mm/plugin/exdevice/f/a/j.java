package com.tencent.mm.plugin.exdevice.f.a;

import com.tencent.mm.network.q;
import com.tencent.mm.plugin.exdevice.a.b;
import com.tencent.mm.plugin.exdevice.f.b.a.c;
import com.tencent.mm.plugin.exdevice.f.b.a.d;
import com.tencent.mm.plugin.exdevice.f.b.a.e;
import com.tencent.mm.plugin.exdevice.f.b.f;
import com.tencent.mm.plugin.exdevice.model.ad;
import com.tencent.mm.protocal.c.ahu;
import com.tencent.mm.protocal.c.ahv;
import com.tencent.mm.protocal.c.cdz;
import com.tencent.mm.protocal.c.cea;
import com.tencent.mm.protocal.c.wk;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.as;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

public final class j extends com.tencent.mm.plugin.exdevice.a.a<ahu, ahv> {
    public String appName;
    public String lUI;
    public String lUJ;
    public boolean lUS;
    public boolean lUT;
    public String lUU;
    public String lUV;
    public com.tencent.mm.plugin.exdevice.f.b.a.a lUW;
    public ArrayList<d> lUX;
    public ArrayList<c> lUY;
    public ArrayList<e> lUZ;
    public ArrayList<String> lVa;
    public String lVb;
    public String lVc;
    public boolean lVd;
    public boolean lVe;
    public String lVf;
    private final WeakReference<b<j>> lVg;
    public a lVh;

    public interface a {
        void a(j jVar);
    }

    protected final /* synthetic */ com.tencent.mm.bp.a aEj() {
        return new ahu();
    }

    protected final /* synthetic */ com.tencent.mm.bp.a aEk() {
        return new ahv();
    }

    protected final /* bridge */ /* synthetic */ void g(com.tencent.mm.bp.a aVar) {
        ahu ahu = (ahu) aVar;
        ahu.mcb = this.appName;
        ahu.hds = this.lUU;
        ahu.wvT = this.lUT;
        ahu.wvU = this.lUV;
    }

    public j(String str, String str2, String str3, boolean z, b<j> bVar) {
        this.lVg = new WeakReference(bVar);
        this.lVb = str;
        this.lUU = str;
        this.appName = bi.oM(str2);
        this.lUT = z;
        this.lUV = str3;
    }

    public final int getType() {
        return 1042;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneGetRankInfo", "hy: get rank info end. errType: %d, errCode: %d, errMsg: %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (i2 == 0 && i3 == 0) {
            Iterator it;
            String str2;
            String str3;
            Object obj;
            String str4;
            com.tencent.mm.plugin.exdevice.f.b.a.a aVar;
            ahv ahv = (ahv) aqo();
            String str5 = "";
            this.lUY = new ArrayList();
            if (ahv.vNK != null) {
                it = ahv.vNK.iterator();
                while (it.hasNext()) {
                    wk wkVar = (wk) it.next();
                    as.Hm();
                    if (com.tencent.mm.y.c.Ff().Xr(wkVar.username)) {
                        str2 = ahv.hds;
                        str3 = this.appName;
                        if (bi.oN(str2) || wkVar == null) {
                            x.w("MicroMsg.ExdeviceRankConverter", "hy: param error");
                            obj = null;
                        } else {
                            c cVar = new c();
                            cVar.field_rankID = str2;
                            cVar.field_username = wkVar.username;
                            cVar.field_step = wkVar.jhF;
                            cVar.field_appusername = str3;
                            c obj2 = cVar;
                        }
                        if (obj2 != null) {
                            this.lUY.add(obj2);
                        }
                    } else {
                        as.CN().a(new h(wkVar.username, null), 0);
                    }
                }
            }
            this.lUX = new ArrayList();
            if (ahv.wvV != null) {
                it = ahv.wvV.iterator();
                while (it.hasNext()) {
                    d dVar;
                    cdz cdz = (cdz) it.next();
                    str2 = ahv.hds;
                    str3 = this.appName;
                    if (bi.oN(str2) || cdz == null) {
                        x.w("MicroMsg.ExdeviceRankConverter", "hy: param error");
                        dVar = null;
                    } else {
                        dVar = new d();
                        dVar.field_appusername = str3;
                        dVar.field_rankID = str2;
                        dVar.field_likecount = cdz.xjq;
                        dVar.field_ranknum = cdz.xjp;
                        dVar.field_score = cdz.score;
                        dVar.field_selfLikeState = cdz.xjr;
                        dVar.field_username = cdz.username;
                    }
                    if (dVar != null) {
                        if (dVar.field_ranknum == 1) {
                            str4 = dVar.field_username;
                        } else {
                            str4 = str5;
                        }
                        this.lUX.add(dVar);
                        str5 = str4;
                    }
                }
            }
            this.lUZ = new ArrayList();
            if (ahv.wvW != null) {
                it = ahv.wvW.iterator();
                while (it.hasNext()) {
                    cea cea = (cea) it.next();
                    str2 = ahv.hds;
                    str3 = this.appName;
                    if (bi.oN(str2) || cea == null) {
                        x.w("MicroMsg.ExdeviceRankConverter", "hy: param error");
                        obj2 = null;
                    } else {
                        e eVar = new e();
                        eVar.field_appusername = str3;
                        eVar.field_rankID = str2;
                        eVar.field_timestamp = cea.cRQ;
                        eVar.field_username = cea.username;
                        e eVar2 = eVar;
                    }
                    if (obj2 != null) {
                        this.lUZ.add(obj2);
                    }
                }
            }
            this.lVa = new ArrayList();
            if (ahv.wvO != null) {
                Iterator it2 = ahv.wvO.iterator();
                while (it2.hasNext()) {
                    this.lVa.add((String) it2.next());
                }
            }
            if (!bi.oN(this.lUV)) {
                str5 = this.lUV;
            }
            String str6 = ahv.wvX;
            String str7 = ahv.wvY;
            if (bi.oN(str5)) {
                x.w("MicroMsg.ExdeviceRankConverter", "hy: param error");
                aVar = null;
            } else {
                aVar = new com.tencent.mm.plugin.exdevice.f.b.a.a();
                aVar.field_username = str5;
                aVar.field_championUrl = str6;
                aVar.field_championMotto = str7;
            }
            this.lUW = aVar;
            this.lVb = ahv.hds;
            this.lUJ = ahv.wvQ;
            this.lUI = ahv.wvP;
            this.lVc = ahv.wvZ;
            this.lVd = ahv.lVd;
            this.lVe = ahv.wwc == 1;
            this.lVf = ahv.wwd;
            this.lUS = ahv.wvS;
            x.d("MicroMsg.NetSceneGetRankInfo", "hy: get score info ok.");
            if (this.lUU == null || !this.lUU.equals(this.lVb)) {
                f fVar = ad.aEZ().lVo;
                if (fVar != null) {
                    fVar.zF(this.lVb);
                }
            }
            if (this.lVh != null && this.lUT) {
                this.lVh.a(this);
            }
            if (this.lUT) {
                ad.aET().aG(this.lUY);
            }
            com.tencent.mm.plugin.exdevice.f.b.b.d aES = ad.aES();
            if (bi.oN(this.lVb)) {
                x.w("MicroMsg.ExdeviceRankInfoStg", "delete rankInfo by rankId failed, rankId is null or nil.");
            } else {
                int delete = aES.gLA.delete("HardDeviceRankInfo", "rankID = ? ", new String[]{this.lVb});
                x.i("MicroMsg.ExdeviceRankInfoStg", "delete rankInfo by rankId (%s).(r : %d)", str4, Integer.valueOf(delete));
            }
            ad.aES().e(this.lVb, this.lUX);
            str4 = "MicroMsg.NetSceneGetRankInfo";
            str5 = "isCacheExist(%s), RankFollowInfo size(%s), RankInfo size(%d), LikeInfo size(%d).";
            Object[] objArr = new Object[4];
            objArr[0] = Boolean.valueOf(this.lVd);
            objArr[1] = Integer.valueOf(this.lUY != null ? this.lUY.size() : 0);
            objArr[2] = Integer.valueOf(this.lUX != null ? this.lUX.size() : 0);
            objArr[3] = Integer.valueOf(this.lUZ != null ? this.lUZ.size() : 0);
            x.i(str4, str5, objArr);
            ad.aEW().a(this.lVb, this.appName, this.lUZ);
            if (this.lUW != null) {
                ad.aEV().a(this.lUW, true);
            }
        }
        super.a(i, i2, i3, str, qVar, bArr);
        b bVar = (b) this.lVg.get();
        if (bVar != null) {
            bVar.b(i2, i3, str, this);
        }
    }

    protected final String getUri() {
        return "/cgi-bin/mmbiz-bin/rank/getuserranklike";
    }
}
