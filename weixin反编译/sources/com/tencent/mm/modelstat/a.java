package com.tencent.mm.modelstat;

import com.tencent.mm.modelsns.d;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.y.bb;
import com.tencent.mm.y.q;

public final class a {

    public enum a {
        Expose(1),
        Click(2);
        
        public int value;

        private a(int i) {
            this.value = 0;
            this.value = i;
        }
    }

    public static void a(au auVar, a aVar) {
        if (!bi.oN(auVar.gkM)) {
            int i;
            d dVar = new d();
            dVar.q("20ExpIdStr", auVar.gkM + ",");
            dVar.q("21OpType", aVar.value + ",");
            dVar.q("22msgId", auVar.field_msgSvrId + ",");
            dVar.q("23MessageType", auVar.getType() + ",");
            if (auVar.aNJ()) {
                com.tencent.mm.x.g.a I = com.tencent.mm.x.g.a.I(auVar.field_content, auVar.field_reserved);
                i = I == null ? 0 : I.type;
            } else {
                i = 0;
            }
            String str = auVar.field_talker;
            dVar.q("24AppMsgInnerType", i + ",");
            dVar.q("25curUsername", str + ",");
            String str2 = "";
            if (auVar.field_isSend == 1) {
                str2 = q.FY();
            } else if (str == null || !str.endsWith("@chatroom")) {
                str2 = str;
            } else if (auVar.field_content != null) {
                int hR = bb.hR(auVar.field_content);
                if (hR != -1) {
                    str2 = auVar.field_content.substring(0, hR).trim();
                }
            }
            dVar.q("26msgPostUserName", str2 + ",");
            dVar.q("27MediaState", auVar.gkN + ",");
            x.v("MicroMsg.ChattingExpUtil", "report logbuffer(13564): [chatting_exp]" + dVar.SG());
            g.pWK.h(13564, dVar);
        }
    }
}
