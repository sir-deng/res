package com.tencent.mm.plugin.exdevice.f.a;

import com.tencent.mm.network.q;
import com.tencent.mm.plugin.exdevice.a.a;
import com.tencent.mm.plugin.exdevice.a.b;
import com.tencent.mm.plugin.exdevice.model.ad;
import com.tencent.mm.protocal.c.qk;
import com.tencent.mm.protocal.c.ql;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.ref.WeakReference;

public final class h extends a<qk, ql> {
    private final WeakReference<b<h>> lQe;
    String username;

    protected final /* synthetic */ com.tencent.mm.bp.a aEj() {
        return new qk();
    }

    protected final /* synthetic */ com.tencent.mm.bp.a aEk() {
        return new ql();
    }

    protected final /* bridge */ /* synthetic */ void g(com.tencent.mm.bp.a aVar) {
        ((qk) aVar).wfR = this.username;
    }

    public h(String str, b<h> bVar) {
        this.username = str;
        this.lQe = new WeakReference(bVar);
    }

    public final int getType() {
        return 1792;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneDelFollow", "hy: del follow end. errType: %d, errCode: %d, errMsg: %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        super.a(i, i2, i3, str, qVar, bArr);
        if (i2 == 0 && i3 == 0) {
            ad.aET().zH(this.username);
        }
        b bVar = (b) this.lQe.get();
        if (bVar != null) {
            bVar.b(i2, i3, str, this);
        }
    }

    protected final String getUri() {
        return "/cgi-bin/mmoc-bin/hardware/delfollow";
    }
}
