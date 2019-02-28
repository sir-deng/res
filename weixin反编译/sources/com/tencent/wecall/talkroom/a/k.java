package com.tencent.wecall.talkroom.a;

import com.google.a.a.e;
import com.tencent.pb.common.b.a.a.ae;
import com.tencent.pb.common.b.a.a.h;
import com.tencent.pb.common.b.d;
import com.tencent.pb.common.c.c;

public final class k extends d {
    public long AwJ;
    public int nPD;
    public String nqU;

    public k(String str, int i, long j, String str2) {
        c.d("MicroMsg.Voip", this.TAG2, "NetSceneSubscribeLargeVideo");
        e hVar = new h();
        try {
            hVar.groupId = str;
            this.nqU = str;
            hVar.nJe = i;
            this.nPD = i;
            hVar.nJf = j;
            this.AwJ = j;
            hVar.liU = str2;
            hVar.timestamp = System.currentTimeMillis();
            c.l("MicroMsg.Voip", "roomId: %d, roomKey: %d, groupId: %s, ownerUserName: %s, timestamp: %d", Integer.valueOf(hVar.nJe), Long.valueOf(hVar.nJf), hVar.groupId, hVar.liU, Long.valueOf(hVar.timestamp));
            this.ndI = 3;
            this.zVs = com.tencent.wecall.talkroom.model.c.cIA().acG(str);
        } catch (Exception e) {
            c.m(this.TAG2, "NetSceneSwitchVideoGroup constructor", e);
        }
        c(245, hVar);
    }

    public final int getType() {
        return 800;
    }

    protected final Object bE(byte[] bArr) {
        c.d("MicroMsg.Voip", this.TAG2, "data2Resp");
        if (bArr == null) {
            return null;
        }
        try {
            return (ae) e.a(new ae(), bArr, bArr.length);
        } catch (Exception e) {
            c.m(this.TAG2, "data2Resp", e.getMessage());
            return null;
        }
    }

    protected final String cDw() {
        return "CsCmd.Cmd_V_CSSubscribeLargeVideoReq";
    }
}
