package com.tencent.mm.ui.chatting.b;

import android.annotation.SuppressLint;
import android.os.Message;
import com.tencent.mm.a.n;
import com.tencent.mm.modelsimple.j;
import com.tencent.mm.network.e;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.as;
import com.tencent.mm.y.be;
import com.tencent.mm.y.be.a;
import java.util.LinkedList;
import java.util.List;

public final class i {
    public p fhH;
    int hZI = -1;
    @SuppressLint({"HandlerLeak"})
    public ag handler = new ag() {
        public final void handleMessage(Message message) {
            if (!i.this.fhH.cte().isFinishing() && i.this.yIs) {
                i.this.yIs = false;
                i.this.fhH.crM();
                i.this.fhH.cpZ();
            }
        }
    };
    int yIr;
    public boolean yIs = false;

    public i(p pVar) {
        this.fhH = pVar;
    }

    public final void keepSignalling() {
        if (this.yIr == -2) {
            as.CN().a(new be(new a() {
                public final void a(e eVar) {
                    if (eVar != null) {
                        eVar.keepSignalling();
                    }
                }
            }), 0);
        }
    }

    public final void stopSignalling() {
        as.CN().a(new be(new a() {
            public final void a(e eVar) {
                if (eVar != null) {
                    eVar.stopSignalling();
                }
            }
        }), 0);
    }

    public final void FX(int i) {
        int intValue = ((Integer) as.Hk().get(35, Integer.valueOf(10))).intValue();
        List linkedList = new LinkedList();
        linkedList.add(this.fhH.csn());
        if (intValue == -2) {
            if (this.fhH.csR() && (i == 1 || i == 2)) {
                x.d("MicroMsg.DirectScendImp", "oreh old logic doDirectSend not support chatStatus:%d", Integer.valueOf(i));
                return;
            }
            x.d("MicroMsg.DirectScendImp", "oreh old logic doDirectSend done chatStatus:%d", Integer.valueOf(i));
            as.CN().a(new j(linkedList, n.eh(i)), 0);
        } else if (this.fhH.csR() || com.tencent.mm.storage.x.Xf(this.fhH.csW().field_username) || com.tencent.mm.storage.x.Xd(this.fhH.csW().field_username) || this.fhH.csW().ciN()) {
            x.d("MicroMsg.DirectScendImp", "oreh doDirectSend not support");
        } else {
            long bA = bi.bA(this.fhH.cth());
            if (intValue == -1 || bA > ((long) intValue) * 1000) {
                x.d("MicroMsg.DirectScendImp", "oreh doDirectSend interval too long: %d;  interval: %d", Long.valueOf(bA / 1000), Integer.valueOf(intValue));
                return;
            }
            x.d("MicroMsg.DirectScendImp", "oreh doDirectSend done chatStatus:%d, delt:%d", Integer.valueOf(i), Long.valueOf(bA / 1000));
            as.CN().a(new j(linkedList, n.eh(i)), 0);
        }
    }
}
