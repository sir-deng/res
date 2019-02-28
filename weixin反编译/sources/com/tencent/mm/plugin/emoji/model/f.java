package com.tencent.mm.plugin.emoji.model;

import com.tencent.mm.protocal.c.sm;
import com.tencent.mm.protocal.c.so;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import java.util.ArrayList;
import java.util.List;

public final class f {
    public int lDm;
    public List<com.tencent.mm.plugin.emoji.a.a.f> lDn;
    public sm lDo;
    public List<sm> lDp;
    public List<so> lDq;
    public List<so> lDr;

    public final void pd(int i) {
        this.lDm += i;
    }

    public final void aCc() {
        if (this.lDr != null && !this.lDr.isEmpty()) {
            List arrayList = new ArrayList();
            arrayList.addAll(this.lDr);
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                this.lDn.add(0, new com.tencent.mm.plugin.emoji.a.a.f((so) arrayList.get(size)));
                this.lDm++;
                this.lDr.remove(arrayList.get(size));
            }
        }
    }

    public final void aC(List<com.tencent.mm.plugin.emoji.a.a.f> list) {
        if (this.lDn == null) {
            this.lDn = new ArrayList();
        } else {
            int size = this.lDn.size() - 1;
            if (size >= 0 && size < this.lDn.size()) {
                com.tencent.mm.plugin.emoji.a.a.f fVar = (com.tencent.mm.plugin.emoji.a.a.f) this.lDn.get(size);
                if (!(fVar == null || fVar.lAy == null || bi.oN(fVar.lAy.vPI) || !fVar.lAy.vPI.equals(EmojiGroupInfo.xIE))) {
                    this.lDn.remove(fVar);
                }
            }
        }
        this.lDn.addAll(list);
    }
}
