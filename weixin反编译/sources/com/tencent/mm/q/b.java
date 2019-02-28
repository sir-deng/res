package com.tencent.mm.q;

import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.c.acs;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.List;

public final class b implements e {
    private List<d> gLq = null;
    private List<d> gLr = null;
    private d gLs = null;
    private a gLt;

    public interface a {
        void z(List<d> list);
    }

    public b(List<d> list, a aVar) {
        this.gLq = list;
        this.gLr = new ArrayList();
        this.gLt = aVar;
    }

    public final boolean start() {
        if (this.gLq == null || this.gLq.size() <= 0) {
            return false;
        }
        x.i("MicroMsg.FunctionMsgFetchLooper", "start, fetchItemList.size: %s", Integer.valueOf(this.gLq.size()));
        g.CN().a(825, (e) this);
        Bi();
        return true;
    }

    private void Bi() {
        x.d("MicroMsg.FunctionMsgFetchLooper", "fetchNext, fetchItemList.size: %s", Integer.valueOf(this.gLq.size()));
        if (this.gLq.size() > 0) {
            this.gLs = (d) this.gLq.remove(0);
            d dVar = this.gLs;
            if (dVar != null) {
                x.i("MicroMsg.FunctionMsgFetchLooper", "fetchInternal, functionMsgId: %s", dVar.field_functionmsgid);
                dVar.field_status = 0;
                g.CN().a(new g(dVar), 0);
                return;
            }
            return;
        }
        g.CN().b(825, (e) this);
        if (this.gLt != null) {
            this.gLt.z(this.gLr);
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
        x.i("MicroMsg.FunctionMsgFetchLooper", "errType: %s, errCode: %s, errMsg: %s", Integer.valueOf(i), Integer.valueOf(i2), str);
        if (kVar.getType() == 825) {
            g gVar = (g) kVar;
            acs acs = gVar.gLD;
            d dVar = gVar.gLF;
            if (dVar != null && dVar.field_functionmsgid.equals(this.gLs.field_functionmsgid)) {
                if (i == 0 || i2 == 0) {
                    x.i("MicroMsg.FunctionMsgFetchLooper", "functionMsgId: %s fetch success, response.version: %s, fetchItem.version: %s", dVar.field_functionmsgid, Long.valueOf(acs.wsk), Long.valueOf(dVar.field_version));
                    if (acs.wsk >= dVar.field_version) {
                        dVar.field_preVersion = dVar.field_version;
                        dVar.field_version = acs.wsk;
                        dVar.field_status = 2;
                        dVar.b(acs.wsl);
                        i.Bs().a(dVar.field_functionmsgid, dVar);
                        this.gLr.add(dVar);
                    }
                } else {
                    x.i("MicroMsg.FunctionMsgFetchLooper", "functionMsgId: %s, fetch failed, mark as fetch failed, preVersion: %s, version: %s", dVar.field_functionmsgid, Long.valueOf(dVar.field_preVersion), Long.valueOf(dVar.field_version));
                    dVar.field_status = 3;
                    dVar.field_version = dVar.field_preVersion;
                    i.Bs().a(dVar.field_functionmsgid, dVar);
                }
                Bi();
            }
        }
    }
}
