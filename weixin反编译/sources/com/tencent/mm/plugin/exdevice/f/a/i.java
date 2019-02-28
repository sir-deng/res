package com.tencent.mm.plugin.exdevice.f.a;

import com.tencent.mm.network.q;
import com.tencent.mm.plugin.exdevice.a.a;
import com.tencent.mm.plugin.exdevice.a.b;
import com.tencent.mm.plugin.exdevice.model.ad;
import com.tencent.mm.protocal.c.ahs;
import com.tencent.mm.protocal.c.aht;
import com.tencent.mm.protocal.c.bnl;
import com.tencent.mm.protocal.c.ceb;
import com.tencent.mm.protocal.c.cec;
import com.tencent.mm.protocal.c.ju;
import com.tencent.mm.protocal.c.wk;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.as;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class i extends a<ahs, aht> {
    public String appName;
    public String bhd;
    private final WeakReference<b<i>> lQe;
    public String lUF;
    public String lUG;
    public String lUH;
    public String lUI;
    public String lUJ;
    public List<bnl> lUK;
    public List<cec> lUL;
    public ceb lUM;
    public ArrayList<String> lUN;
    public List<wk> lUO;
    public List<ju> lUP;
    public boolean lUQ;
    public int lUR;
    public boolean lUS;
    public String username;

    protected final /* synthetic */ com.tencent.mm.bp.a aEj() {
        return new ahs();
    }

    protected final /* synthetic */ com.tencent.mm.bp.a aEk() {
        return new aht();
    }

    protected final /* bridge */ /* synthetic */ void g(com.tencent.mm.bp.a aVar) {
        ahs ahs = (ahs) aVar;
        ahs.mcb = this.appName;
        ahs.username = this.username;
    }

    public i(String str, String str2, b<i> bVar) {
        x.d("MicroMsg.NetSceneGetProfileDetail", "appusername: %s, username: %s", str2, str);
        this.username = str;
        this.appName = str2;
        this.lQe = new WeakReference(bVar);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        super.a(i, i2, i3, str, qVar, bArr);
        x.d("MicroMsg.NetSceneGetProfileDetail", "hy: getdetail scene gy end. errType: %d, errCode: %d, errMsg: %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (i2 == 0 && i3 == 0) {
            aht aht = (aht) aqo();
            this.lUG = aht.wvK;
            this.lUH = aht.lUH;
            this.lUL = aht.wvN;
            this.lUM = aht.wvL;
            this.lUI = aht.wvP;
            this.bhd = aht.bhd;
            this.lUJ = aht.wvQ;
            this.lUK = aht.vOn;
            this.lUQ = aht.lUQ;
            this.lUO = aht.vNK;
            this.lUP = aht.wvR;
            this.lUN = new ArrayList();
            this.lUR = aht.mbA;
            this.lUS = aht.wvS;
            this.lUF = aht.lUF;
            if (aht.wvO != null) {
                this.lUN.addAll(aht.wvO);
            }
            this.lUK = new LinkedList();
            if (aht.vOn != null) {
                this.lUK.addAll(aht.vOn);
            }
            if (!(this.username == null || this.username.equalsIgnoreCase(com.tencent.mm.y.q.FY()))) {
                if (this.lUQ) {
                    com.tencent.mm.plugin.exdevice.f.b.b.a aET = ad.aET();
                    String str2 = this.username;
                    if (aET.a(new com.tencent.mm.plugin.exdevice.f.b.b("hardcode_rank_id", "hardcode_app_name", str2)) == null) {
                        c cVar = new com.tencent.mm.plugin.exdevice.f.b.a.c();
                        cVar.field_rankID = "hardcode_rank_id";
                        cVar.field_appusername = "hardcode_app_name";
                        cVar.field_username = str2;
                        cVar.field_step = 0;
                        aET.b(cVar);
                    }
                } else {
                    ad.aET().zH(this.username);
                }
            }
            if (aht.vNK != null) {
                List arrayList = new ArrayList();
                Iterator it = aht.vNK.iterator();
                while (it.hasNext()) {
                    wk wkVar = (wk) it.next();
                    as.Hm();
                    if (com.tencent.mm.y.c.Ff().Xr(wkVar.username)) {
                        com.tencent.mm.plugin.exdevice.f.b.a.c cVar2 = new com.tencent.mm.plugin.exdevice.f.b.a.c();
                        cVar2.field_username = wkVar.username;
                        cVar2.field_step = wkVar.jhF;
                        arrayList.add(cVar2);
                    } else {
                        as.CN().a(new h(wkVar.username, null), 0);
                    }
                }
                x.d("MicroMsg.NetSceneGetProfileDetail", "follows %d %s", Integer.valueOf(arrayList.size()), arrayList.toString());
                if (com.tencent.mm.y.q.FY().equalsIgnoreCase(this.username)) {
                    ad.aET().aG(arrayList);
                }
            }
            this.lUP = new ArrayList();
            if (aht.wvR != null) {
                this.lUP.addAll(aht.wvR);
            }
            this.lUQ = aht.lUQ;
            com.tencent.mm.plugin.exdevice.f.b.a.a aVar = new com.tencent.mm.plugin.exdevice.f.b.a.a();
            aVar.field_championMotto = this.lUH;
            aVar.field_championUrl = this.lUG;
            aVar.field_username = this.username;
            LinkedList linkedList = aht.vOn;
            ad.aEV().a(aVar, true);
        }
        b bVar = (b) this.lQe.get();
        if (bVar != null) {
            bVar.b(i2, i3, str, this);
        }
    }

    protected final String getUri() {
        return "/cgi-bin/mmbiz-bin/rank/getuserrankdetail";
    }

    public final int getType() {
        return 1043;
    }
}
