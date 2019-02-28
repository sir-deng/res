package com.tencent.wecall.talkroom.a;

import com.tencent.mm.plugin.appbrand.jsapi.map.j;
import com.tencent.pb.common.b.a.a.aa;
import com.tencent.pb.common.b.a.a.al;
import com.tencent.pb.common.b.a.a.ba;
import com.tencent.pb.common.b.d;
import com.tencent.pb.common.c.c;
import com.tencent.wecall.talkroom.model.k;

public final class e extends d {
    public long AwJ = 0;
    public int AyE = 0;
    public int nPD = 0;
    public String nqU = null;

    public e(e eVar) {
        this.nqU = eVar.nqU;
        this.nPD = eVar.nPD;
        this.AwJ = eVar.AwJ;
        this.AyE = eVar.AyE;
        this.zVp = eVar.zVp;
        this.zVr = eVar.zVr;
        this.zVs = eVar.zVs;
        this.ndI = 1;
    }

    public e(String str, int i, long j, byte[] bArr, int i2, int i3) {
        c.d("MicroMsg.Voip", this.TAG2, "enter", str, Integer.valueOf(i), Long.valueOf(j));
        com.google.a.a.e eVar = new com.tencent.pb.common.b.a.a.e();
        try {
            eVar.groupId = str;
            this.nqU = str;
            eVar.srH = i;
            this.nPD = i;
            eVar.srI = j;
            this.AwJ = j;
            eVar.zWk = i3;
            this.AyE = i3;
            al alVar = new al();
            if (bArr != null) {
                alVar.buffer = bArr;
                alVar.wRk = bArr.length;
            } else {
                alVar.wRk = 0;
            }
            ba baVar = new ba();
            baVar.type = 3;
            baVar.zZn = alVar;
            eVar.zWc = baVar;
            this.ndI = 2;
            this.zVs = i2;
            eVar.zWe = 2;
            eVar.netType = k.iO(com.tencent.pb.common.c.d.syL);
        } catch (Exception e) {
            c.m(this.TAG2, "NetSceneEnterVoiceRoom constructor", e);
        }
        c(j.CTRL_INDEX, eVar);
    }

    public final int getType() {
        return 202;
    }

    protected final Object bE(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        try {
            return (aa) com.google.a.a.e.a(new aa(), bArr, bArr.length);
        } catch (Exception e) {
            c.m(this.TAG2, "data2Resp", e.getMessage());
            return null;
        }
    }

    protected final String cDw() {
        return "CsCmd.Cmd_V_CSEnterVoiceRoomReq";
    }
}
