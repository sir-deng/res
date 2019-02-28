package com.tencent.mm.plugin.sns;

import com.tencent.mm.ad.k;
import com.tencent.mm.f.a.lv;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sns.model.v;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

public final class h extends c<lv> {
    public h() {
        this.xmG = lv.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        lv lvVar = (lv) bVar;
        if (!(lvVar instanceof lv)) {
            x.f("MicroMsg.PostSnsTagMemberOptionListener", "mismatched event");
            return false;
        } else if (lvVar.fEb.list == null) {
            x.e("MicroMsg.PostSnsTagMemberOptionListener", "event.data.list is null!");
            return false;
        } else {
            k vVar = new v(lvVar.fEb.fvo, lvVar.fEb.fEc, "", lvVar.fEb.list.size(), lvVar.fEb.list, lvVar.fEb.scene);
            x.i("MicroMsg.PostSnsTagMemberOptionListener", "opCode " + lvVar.fEb.fvo + " memberList " + lvVar.fEb.list.size() + " scene " + lvVar.fEb.scene);
            g.Dp().gRu.a(vVar, 0);
            return true;
        }
    }
}
