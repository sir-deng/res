package com.tencent.wecall.talkroom.a;

import com.google.a.a.e;
import com.tencent.mm.plugin.appbrand.jsapi.a.c;
import com.tencent.pb.common.b.a.a.ac;
import com.tencent.pb.common.b.d;

public final class g extends d {
    public String nqU;

    public final int getType() {
        return c.CTRL_INDEX;
    }

    protected final Object bE(byte[] bArr) {
        com.tencent.pb.common.c.c.d("MicroMsg.Voip", this.TAG2, "data2Resp");
        if (bArr == null) {
            return null;
        }
        try {
            return (ac) e.a(new ac(), bArr, bArr.length);
        } catch (Exception e) {
            com.tencent.pb.common.c.c.m(this.TAG2, "data2Resp", e.getMessage());
            return null;
        }
    }

    protected final String cDw() {
        return "CsCmd.Cmd_V_CSModifyVoiceGroupInfoReq";
    }
}
