package com.tencent.mm.plugin.wear.model.f;

import com.tencent.mm.plugin.wear.model.a;
import com.tencent.mm.plugin.wear.model.e.r;
import com.tencent.mm.protocal.c.can;
import java.io.IOException;

public final class k extends c {
    private int code;
    private String fpV;

    public k(int i, String str) {
        this.code = i;
        this.fpV = str;
    }

    protected final void send() {
        can can = new can();
        switch (this.code) {
            case 0:
                can.wXj = 0;
                break;
            case 6:
                can.wXj = 196610;
                break;
            case 7:
                can.wXj = 196615;
                break;
            case 8:
                can.wXj = 196614;
                break;
            case 9:
                can.wXj = 196613;
                break;
        }
        can.xfB = this.fpV;
        try {
            a.bPh();
            r.a(20016, can.toByteArray(), true);
        } catch (IOException e) {
        }
    }

    public final String getName() {
        return "WearPushPayResponseTask";
    }
}
