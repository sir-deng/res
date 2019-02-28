package com.tencent.mm.plugin.i.c;

import com.tencent.mm.plugin.i.b;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;

public final class a implements Runnable {
    private au fou;
    private int opType;

    public a(au auVar, int i) {
        this.fou = auVar;
        this.opType = i;
        x.d("MicroMsg.MsgEventTask", "%d msg id[%d %d] optype[%d]", Integer.valueOf(hashCode()), Long.valueOf(this.fou.field_msgId), Integer.valueOf(this.fou.getType()), Integer.valueOf(this.opType));
    }

    public final void run() {
        switch (this.opType) {
            case 1:
                b.atn().H(this.fou);
                return;
            default:
                x.w("MicroMsg.MsgEventTask", "%d unknow op type [%d]", Integer.valueOf(hashCode()), Integer.valueOf(this.opType));
                return;
        }
    }
}
