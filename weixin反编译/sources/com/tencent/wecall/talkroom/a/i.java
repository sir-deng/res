package com.tencent.wecall.talkroom.a;

import com.google.a.a.e;
import com.tencent.pb.common.b.a.a.ad;
import com.tencent.pb.common.b.a.a.g;
import com.tencent.pb.common.b.d;
import com.tencent.pb.common.c.c;

public final class i extends d {
    public i(String str, int i, long j, int i2) {
        c.d("MicroMsg.Voip", this.TAG2, "NetSceneRejectVoiceGroup");
        e gVar = new g();
        try {
            gVar.groupId = str;
            gVar.srH = i;
            gVar.srI = j;
            gVar.aAk = i2;
            this.ndI = 3;
            this.zVs = com.tencent.wecall.talkroom.model.c.cIA().acG(str);
        } catch (Exception e) {
            c.m(this.TAG2, "NetSceneRejectVoiceGroup constructor", e);
        }
        c(181, gVar);
    }

    public final int getType() {
        return 207;
    }

    protected final Object bE(byte[] bArr) {
        c.d("MicroMsg.Voip", this.TAG2, "data2Resp");
        if (bArr == null) {
            return null;
        }
        try {
            return (ad) e.a(new ad(), bArr, bArr.length);
        } catch (Exception e) {
            c.m(this.TAG2, "data2Resp", e.getMessage());
            return null;
        }
    }

    protected final String cDw() {
        return "CsCmd.Cmd_V_CSRejectEnterVoiceRoomReq";
    }
}
