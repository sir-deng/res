package com.tencent.mm.plugin.backup.f;

import com.tencent.mm.ad.e;
import com.tencent.mm.bp.a;
import com.tencent.mm.plugin.backup.h.aa;
import com.tencent.mm.plugin.backup.h.z;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;

public final class d extends b {
    private e hpx;
    private z kuN = new z();
    public aa kuO = new aa();

    public d(String str, long j, long j2, String str2, String str3, LinkedList<String> linkedList, e eVar) {
        x.i("MicroMsg.BackupDataTagScene", "init DataTag, BakChatName:%s, startTime:%d, endTime:%d, mediaIdList size:%d", str, Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(linkedList.size()));
        this.kuN.kyy = str;
        this.kuN.kzK = j;
        this.kuN.kzL = j2;
        this.kuN.kzM = str2;
        this.kuN.kzN = str3;
        this.kuN.kzq = linkedList;
        this.hpx = eVar;
    }

    public final boolean aqx() {
        boolean aqy = super.aqy();
        if (!aqy) {
            this.hpx.a(1, -2, "doScene failed", this);
        }
        return aqy;
    }

    public final int getType() {
        return 15;
    }

    public final a aqo() {
        return this.kuO;
    }

    public final a aqp() {
        return this.kuN;
    }

    public final void nd(int i) {
        x.i("MicroMsg.BackupDataTagScene", "onSceneEnd");
        f(0, 0, "success");
        this.hpx.a(0, 0, "", this);
    }
}
