package com.tencent.wecall.talkroom.a;

import com.google.a.a.e;
import com.tencent.pb.common.b.a.a.a;
import com.tencent.pb.common.b.a.a.x;
import com.tencent.pb.common.b.d;
import com.tencent.pb.common.c.c;

public final class b extends d {
    public long AwJ;
    public int nPD;
    public String nqU;

    public b(String str, int i, long j, String[] strArr) {
        c.d("MicroMsg.Voip", this.TAG2, "addmember", str);
        e aVar = new a();
        try {
            aVar.groupId = str;
            this.nqU = str;
            aVar.srH = i;
            this.nPD = i;
            aVar.srI = j;
            this.AwJ = j;
            aVar.zVX = strArr;
            aVar.srH = i;
            this.ndI = 3;
            this.zVs = com.tencent.wecall.talkroom.model.c.cIA().acG(str);
        } catch (Exception e) {
            c.m(this.TAG2, "NetSceneAddVoiceGroupMember constructor", e);
        }
        c(com.tencent.mm.plugin.appbrand.jsapi.contact.c.CTRL_INDEX, aVar);
    }

    public final int getType() {
        return com.tencent.mm.plugin.appbrand.jsapi.a.d.CTRL_INDEX;
    }

    protected final Object bE(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        try {
            return (x) e.a(new x(), bArr, bArr.length);
        } catch (Exception e) {
            c.m(this.TAG2, "data2Resp", e.getMessage());
            return null;
        }
    }

    protected final String cDw() {
        return "CsCmd.Cmd_V_CSAddVoiceGroupMemberReq";
    }
}
