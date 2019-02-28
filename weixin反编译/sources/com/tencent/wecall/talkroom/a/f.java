package com.tencent.wecall.talkroom.a;

import com.google.a.a.e;
import com.tencent.pb.common.b.a.a.ab;
import com.tencent.pb.common.b.d;
import com.tencent.pb.common.c.c;

public final class f extends d {
    public f(String str, int i, long j, int i2) {
        c.d("MicroMsg.Voip", this.TAG2, "eixt", str, Integer.valueOf(i), Long.valueOf(j), Integer.valueOf(i2));
        e fVar = new com.tencent.pb.common.b.a.a.f();
        try {
            fVar.groupId = str;
            fVar.srH = i;
            fVar.srI = j;
            fVar.aAk = i2;
            this.ndI = 2;
            this.zVs = com.tencent.wecall.talkroom.model.c.cIA().acG(str);
        } catch (Exception e) {
            c.m(this.TAG2, "NetSceneExitVoiceRoom constructor", e);
        }
        c(143, fVar);
    }

    public final int getType() {
        return 203;
    }

    protected final Object bE(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        try {
            return (ab) e.a(new ab(), bArr, bArr.length);
        } catch (Exception e) {
            c.m(this.TAG2, "data2Resp", e.getMessage());
            return null;
        }
    }

    protected final String cDw() {
        return "CsCmd.Cmd_V_CSExitVoiceRoomReq";
    }
}
