package com.tencent.mm.plugin.chatroom.d;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bil;
import com.tencent.mm.protocal.c.bim;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.smtt.utils.TbsLog;

public final class m extends k implements com.tencent.mm.network.k {
    private final b gLB;
    private e gLE;

    public m(String str, String str2) {
        a aVar = new a();
        com.tencent.mm.bp.a bil = new bil();
        bil.wfN = str;
        bil.wqJ = str2;
        aVar.hnT = bil;
        aVar.hnU = new bim();
        aVar.uri = "/cgi-bin/micromsg-bin/setchatroomannouncement";
        aVar.hnS = TbsLog.TBSLOG_CODE_SDK_CONFLICT_X5CORE;
        this.gLB = aVar.Kf();
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.w("MicroMsg.NetSceneSetChatRoomAnnouncement", "errType = " + i2 + " errCode " + i3 + " errMsg " + str);
        this.gLE.a(i2, i3, str, this);
    }

    public final int getType() {
        return TbsLog.TBSLOG_CODE_SDK_CONFLICT_X5CORE;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        return a(eVar, this.gLB, this);
    }
}
