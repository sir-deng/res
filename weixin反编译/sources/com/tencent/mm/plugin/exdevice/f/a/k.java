package com.tencent.mm.plugin.exdevice.f.a;

import com.tencent.mm.network.q;
import com.tencent.mm.plugin.exdevice.a.a;
import com.tencent.mm.plugin.exdevice.a.b;
import com.tencent.mm.protocal.c.air;
import com.tencent.mm.protocal.c.ais;
import com.tencent.mm.protocal.c.wm;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.as;
import com.tencent.mm.y.c;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class k extends a<air, ais> {
    private final WeakReference<b<k>> lQe;
    public List<String> lVi;
    public List<String> lVj;
    public List<String> lVk;

    protected final /* synthetic */ com.tencent.mm.bp.a aEj() {
        return new air();
    }

    protected final /* synthetic */ com.tencent.mm.bp.a aEk() {
        return new ais();
    }

    protected final /* bridge */ /* synthetic */ void g(com.tencent.mm.bp.a aVar) {
    }

    public k(b<k> bVar) {
        this.lQe = new WeakReference(bVar);
    }

    public final int getType() {
        return 1758;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneGetWeRunFollowerList", "ap: errType: %s, errCode: %s, errMsg: %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (i2 == 0 && i3 == 0) {
            ais ais = (ais) aqo();
            this.lVk = new ArrayList();
            Iterator it = ais.wwN.iterator();
            while (it.hasNext()) {
                String str2 = (String) it.next();
                as.Hm();
                if (c.Ff().Xr(str2)) {
                    this.lVk.add(str2);
                }
            }
            this.lVi = new ArrayList();
            this.lVj = new ArrayList();
            if (ais.wwO != null) {
                Iterator it2 = ais.wwO.iterator();
                while (it2.hasNext()) {
                    wm wmVar = (wm) it2.next();
                    if (wmVar.wnF) {
                        this.lVj.add(wmVar.username);
                    }
                    as.Hm();
                    if (c.Ff().Xr(wmVar.username)) {
                        this.lVi.add(wmVar.username);
                    }
                }
            }
            x.d("MicroMsg.NetSceneGetWeRunFollowerList", "follow:%s %s", Integer.valueOf(this.lVj.size()), this.lVj.toString());
            x.d("MicroMsg.NetSceneGetWeRunFollowerList", "all follow:%s %s", Integer.valueOf(this.lVi.size()), this.lVi);
        }
        super.a(i, i2, i3, str, qVar, bArr);
        b bVar = (b) this.lQe.get();
        if (bVar != null) {
            x.d("MicroMsg.NetSceneGetWeRunFollowerList", "callback is not null");
            bVar.b(i2, i3, str, this);
            return;
        }
        x.d("MicroMsg.NetSceneGetWeRunFollowerList", "callback is null");
    }

    protected final String getUri() {
        return "/cgi-bin/mmoc-bin/hardware/getwerunfollowerlist";
    }
}
