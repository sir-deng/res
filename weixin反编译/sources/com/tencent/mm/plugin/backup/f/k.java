package com.tencent.mm.plugin.backup.f;

import com.tencent.mm.plugin.backup.h.af;
import com.tencent.mm.plugin.backup.h.ag;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.LinkedList;

public final class k extends b {
    private af kvq = new af();
    private ag kvr = new ag();
    private a kvs;

    public interface a {
        void y(LinkedList<Long> linkedList);
    }

    public k(String str, HashMap<Long, com.tencent.mm.plugin.backup.e.h.a> hashMap, a aVar) {
        this.kvs = aVar;
        this.kvq.kyy = str;
        x.i("MicroMsg.BackupSvrIdScene", "init sessionName:%s", str);
        this.kvq.kzV = new LinkedList();
        this.kvq.kzW = new LinkedList();
        this.kvq.kzX = new LinkedList();
        for (Long l : hashMap.keySet()) {
            com.tencent.mm.plugin.backup.e.h.a aVar2 = (com.tencent.mm.plugin.backup.e.h.a) hashMap.get(l);
            this.kvq.kzV.add(Long.valueOf(aVar2.ksO));
            this.kvq.kzW.add(aVar2.ksP);
            this.kvq.kzX.add(aVar2.frM);
        }
    }

    public final int getType() {
        return 13;
    }

    public final com.tencent.mm.bp.a aqo() {
        return this.kvr;
    }

    public final com.tencent.mm.bp.a aqp() {
        return this.kvq;
    }

    public final void nd(int i) {
        x.i("MicroMsg.BackupSvrIdScene", "onSceneEnd");
        f(0, 0, "success");
        this.kvs.y(this.kvr.kzV);
    }
}
