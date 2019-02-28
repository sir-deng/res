package com.tencent.mm.plugin.wear.model.f;

import com.tencent.mm.plugin.wear.model.a;
import com.tencent.mm.plugin.wear.model.e.r;
import com.tencent.mm.plugin.wear.model.h;
import com.tencent.mm.protocal.c.cbc;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

public final class l extends c {
    private String talker;
    private int toS;

    public l(int i, String str) {
        this.toS = i;
        this.talker = str;
    }

    public final String getName() {
        return "WearVoipControllerTask";
    }

    protected final void send() {
        switch (this.toS) {
            case 20010:
                cbc cbc = new cbc();
                cbc.xgB = this.talker;
                cbc.kzN = h.Or(this.talker);
                try {
                    a.bPh();
                    r.a(this.toS, cbc.toByteArray(), false);
                    return;
                } catch (IOException e) {
                    return;
                }
            case 20011:
            case 20012:
                try {
                    a.bPh();
                    r.a(this.toS, this.talker.getBytes("utf8"), false);
                    return;
                } catch (UnsupportedEncodingException e2) {
                    return;
                }
            default:
                return;
        }
    }
}
