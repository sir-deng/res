package com.tencent.mm.ah;

import android.database.Cursor;
import com.tencent.mm.bx.h;
import com.tencent.mm.f.b.ak;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.as.b;
import com.tencent.mm.storage.au;
import com.tencent.mm.y.af;
import com.tencent.mm.y.as;
import com.tencent.mm.y.c;
import com.tencent.mm.y.s;

public final class e extends af {
    public final boolean gO(int i) {
        return i != 0 && i < 604372991;
    }

    public final void transfer(int i) {
        x.d("MicroMsg.ConversationDataTransfer", "the previous version is %d", Integer.valueOf(i));
        if (i != 0 && i < 604372991) {
            g.pWK.h(336, 14);
            as.Hm();
            h Fc = c.Fc();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("select rconversation.username").append(" from rconversation, rcontact").append(", bizinfo where rconversation").append(".username = rcontact").append(".username and rconversation").append(".username = bizinfo").append(".username and ( rcontact").append(".verifyFlag & 8").append(" ) != 0 ");
            x.d("MicroMsg.ConversationDataTransfer", "select sql %s", stringBuilder.toString());
            Cursor a = Fc.a(r1, null, 2);
            if (a != null && a.moveToFirst()) {
                ae aeVar;
                stringBuilder = new StringBuilder();
                stringBuilder.append("Update rconversation set parentRef").append(" = 'officialaccounts' where 1 !=1 ");
                do {
                    String string = a.getString(0);
                    if (!s.ho(string)) {
                        stringBuilder.append(" or username = '").append(string).append("'");
                    }
                } while (a.moveToNext());
                a.close();
                x.d("MicroMsg.ConversationDataTransfer", "changed[%B] exec sql[%s]", Boolean.valueOf(true), stringBuilder.toString());
                Fc.fD("rconversation", r1);
                as.Hm();
                ak XF = c.Fk().XF("officialaccounts");
                if (XF == null) {
                    XF = new ae("officialaccounts");
                    XF.cjn();
                    as.Hm();
                    c.Fk().d(XF);
                    aeVar = XF;
                } else {
                    ak aeVar2 = XF;
                }
                as.Hm();
                String cjx = c.Fk().cjx();
                if (bi.oN(cjx)) {
                    x.w("MicroMsg.ConversationDataTransfer", "last convBiz is null");
                    return;
                }
                as.Hm();
                au Fd = c.Fh().Fd(cjx);
                if (Fd == null || Fd.field_msgId == 0) {
                    x.w("MicroMsg.ConversationDataTransfer", "last biz msg is error");
                    return;
                }
                aeVar2.ac(Fd);
                aeVar2.setContent(Fd.field_talker + ":" + Fd.field_content);
                aeVar2.dG(Integer.toString(Fd.getType()));
                as.Hm();
                b ux = c.Fk().ux();
                if (ux != null) {
                    PString pString = new PString();
                    PString pString2 = new PString();
                    PInt pInt = new PInt();
                    Fd.dU("officialaccounts");
                    Fd.setContent(aeVar2.field_content);
                    ux.a(Fd, pString, pString2, pInt, false);
                    aeVar2.dH(pString.value);
                    aeVar2.dI(pString2.value);
                    aeVar2.eT(pInt.value);
                }
                as.Hm();
                c.Fk().a(aeVar2, aeVar2.field_username);
            }
            if (a != null && !a.isClosed()) {
                a.close();
            }
        }
    }

    public final String getTag() {
        return "MicroMsg.ConversationDataTransfer";
    }
}
