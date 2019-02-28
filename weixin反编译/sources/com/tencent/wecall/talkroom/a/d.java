package com.tencent.wecall.talkroom.a;

import com.google.a.a.e;
import com.tencent.mm.plugin.appbrand.jsapi.v;
import com.tencent.pb.a.a.a;
import com.tencent.pb.common.b.a.a.al;
import com.tencent.pb.common.b.a.a.at;
import com.tencent.pb.common.b.a.a.ay;
import com.tencent.pb.common.b.a.a.ba;
import com.tencent.pb.common.b.a.a.z;
import com.tencent.pb.common.c.c;
import com.tencent.wecall.talkroom.model.k;

public final class d extends com.tencent.pb.common.b.d {
    public String AwI;
    public boolean AyD = true;
    public int mType;

    public d(String str, String[] strArr, byte[] bArr, String str2, ay ayVar, int i, int i2, long j, String str3, boolean z, String str4) {
        c.d("MicroMsg.Voip", this.TAG2, "create");
        e dVar = new com.tencent.pb.common.b.a.a.d();
        try {
            dVar.zVY = str;
            this.AwI = str;
            dVar.zWd = i;
            this.zVs = i;
            if (ayVar != null) {
                dVar.zWf = ayVar;
            }
            at atVar = new at();
            atVar.name = str2;
            atVar.zYs = str4;
            atVar.zYr = a.cDO();
            atVar.fws = i2;
            this.mType = i2;
            this.AyD = z;
            atVar.zYk = j;
            dVar.zWa = atVar;
            dVar.zWh = strArr;
            if (str3 == null) {
                str3 = "";
            }
            dVar.zWg = str3;
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
            dVar.zWc = baVar;
            this.ndI = 3;
            dVar.zWe = 2;
            dVar.netType = k.iO(com.tencent.pb.common.c.d.syL);
        } catch (Exception e) {
            c.m(this.TAG2, "NetSceneCreateVoiceGroup constructor", e);
        }
        c(v.CTRL_INDEX, dVar);
    }

    public final int getType() {
        return 201;
    }

    protected final Object bE(byte[] bArr) {
        c.d("MicroMsg.Voip", this.TAG2, "data2Resp");
        if (bArr == null) {
            return null;
        }
        try {
            return (z) e.a(new z(), bArr, bArr.length);
        } catch (Exception e) {
            c.m(this.TAG2, "data2Resp", e.getMessage());
            return null;
        }
    }

    protected final String cDw() {
        return "CsCmd.Cmd_V_CSCreateVoiceGroupReq";
    }
}
