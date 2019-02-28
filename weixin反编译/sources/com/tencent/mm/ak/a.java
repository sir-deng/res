package com.tencent.mm.ak;

import android.os.Message;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.y.as;
import com.tencent.mm.y.bb;
import com.tencent.mm.y.c;
import com.tencent.mm.y.s;
import junit.framework.Assert;

public final class a extends k implements com.tencent.mm.network.k {
    private au fou = new au();
    private e gLE;
    private ag handler = new ag() {
        public final void handleMessage(Message message) {
            a.this.a(999, 0, 0, "", null, null);
        }
    };

    public a(String str, String str2) {
        boolean z = true;
        this.fou.eR(1);
        this.fou.dU(str);
        this.fou.aq(bb.hU(str));
        this.fou.eS(1);
        this.fou.setContent(str2);
        this.fou.setType(s.hs(str));
        as.Hm();
        long Q = c.Fh().Q(this.fou);
        if (Q == -1) {
            z = false;
        }
        Assert.assertTrue(z);
        x.i("MicroMsg.NetSceneSendMsgFake", "new msg inserted to db , local id = " + Q);
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        x.i("MicroMsg.NetSceneSendMsgFake", "send local msg, msgId = " + this.fou.field_msgId);
        this.handler.sendEmptyMessageDelayed(0, 500);
        return 999;
    }

    public final int getType() {
        return 522;
    }

    protected final int a(q qVar) {
        return b.hoz;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneSendMsgFake", "recv local msg, msgId = " + this.fou.field_msgId);
        this.fou.eR(2);
        this.fou.aq(bb.n(this.fou.field_talker, System.currentTimeMillis() / 1000));
        as.Hm();
        c.Fh().a(this.fou.field_msgId, this.fou);
        this.gLE.a(0, 0, str, this);
    }
}
