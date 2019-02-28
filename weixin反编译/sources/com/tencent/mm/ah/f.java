package com.tencent.mm.ah;

import com.tencent.mm.be.l;
import com.tencent.mm.f.b.cg;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.au.a;
import com.tencent.mm.storage.au.d;
import com.tencent.mm.y.af;
import com.tencent.mm.y.as;
import com.tencent.mm.y.bb;
import com.tencent.mm.y.c;
import java.util.LinkedList;

public final class f extends af {
    public final boolean gO(int i) {
        return i != 0 && i < 604307701;
    }

    public final void transfer(int i) {
        if (i != 0 && i < 604307701) {
            g.pWK.h(336, 11);
            as.Hm();
            au[] bH = c.Fh().bH("fmessage", 20);
            if (bH == null) {
                x.e("MicroMsg.FMessageDataTransfer", "transfer fail, msglist is empty");
                return;
            }
            l.TE();
            x.d("MicroMsg.FMessageDataTransfer", "transfer, msgList count = " + bH.length);
            for (cg cgVar : bH) {
                if (cgVar != null && cgVar.field_msgId != 0) {
                    x.d("MicroMsg.FMessageDataTransfer", "transfer msg type = " + cgVar.getType());
                    String str = cgVar.field_content;
                    if (str != null && str.length() != 0) {
                        com.tencent.mm.be.f fVar;
                        switch (cgVar.getType()) {
                            case 37:
                                x.d("MicroMsg.FMessageDataTransfer", "processVerifyMsg, msg content = " + cgVar.field_content);
                                d Yb = d.Yb(cgVar.field_content);
                                if (!t.oN(Yb.sfb) && (Yb.scene == 18 || bb.gV(Yb.scene))) {
                                    x.i("MicroMsg.FMessageDataTransfer", "processVerifyMsg, skip lbs & shake, scene = " + Yb.scene);
                                    break;
                                }
                                fVar = new com.tencent.mm.be.f();
                                fVar.field_createTime = cgVar.field_createTime;
                                fVar.field_isSend = 0;
                                fVar.field_msgContent = cgVar.field_content;
                                fVar.field_svrId = cgVar.field_msgSvrId;
                                fVar.field_talker = Yb.sfb;
                                switch (Yb.fvG) {
                                    case 2:
                                        fVar.field_type = 1;
                                        break;
                                    case 5:
                                        fVar.field_type = 2;
                                        break;
                                    case 6:
                                        fVar.field_type = 3;
                                        break;
                                    default:
                                        fVar.field_type = 1;
                                        break;
                                }
                                l.TD().a(fVar);
                                break;
                            case 40:
                                x.d("MicroMsg.FMessageDataTransfer", "processFMessage, msg content = " + cgVar.field_content);
                                a XY = a.XY(cgVar.field_content);
                                fVar = new com.tencent.mm.be.f();
                                fVar.field_createTime = cgVar.field_createTime;
                                fVar.field_isSend = 0;
                                fVar.field_msgContent = cgVar.field_content;
                                fVar.field_svrId = cgVar.field_msgSvrId;
                                fVar.field_talker = XY.sfb;
                                fVar.field_type = 0;
                                l.TD().a(fVar);
                                break;
                            default:
                                x.i("MicroMsg.FMessageDataTransfer", "no need to transfer, msgtype = " + cgVar.getType());
                                break;
                        }
                    }
                    x.e("MicroMsg.FMessageDataTransfer", "transfer fail, content is null, skip this msg, id = " + cgVar.field_msgId);
                } else {
                    x.e("MicroMsg.FMessageDataTransfer", "transfer fail, msg is null, skip this msg");
                }
            }
            as.Hm();
            c.Db().set(143618, Integer.valueOf(0));
            l.TE().Tr();
            x.d("MicroMsg.FMessageDataTransfer", "transfer, try to delete fmessage contact & conversation");
            as.Hm();
            c.Ff().XB("fmessage");
            LinkedList linkedList = new LinkedList();
            linkedList.add("fmessage");
            as.Hm();
            c.Fk().ax(linkedList);
        }
    }

    public final String getTag() {
        return "MicroMsg.FMessageDataTransfer";
    }
}
