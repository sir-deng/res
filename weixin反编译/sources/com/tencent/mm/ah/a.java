package com.tencent.mm.ah;

import android.database.Cursor;
import com.tencent.mm.af.d;
import com.tencent.mm.af.y;
import com.tencent.mm.bx.h;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.af;
import com.tencent.mm.y.as;
import com.tencent.mm.y.c;
import java.util.ArrayList;
import java.util.List;

public final class a extends af {
    public final boolean gO(int i) {
        return i != 0 && i < 604372991;
    }

    public final String getTag() {
        return "MicroMsg.App.BizInfoDataTransfer";
    }

    public final void transfer(int i) {
        x.d("MicroMsg.App.BizInfoDataTransfer", "the previous version is %d", Integer.valueOf(i));
        if (i != 0 && i < 604372991) {
            g.pWK.h(336, 12);
            as.Hm();
            h Fc = c.Fc();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("select BizInfo.username").append(", BizInfo.extInfo");
            stringBuilder.append(" from rcontact , BizInfo");
            stringBuilder.append(" where rcontact.username").append(" = BizInfo.username");
            stringBuilder.append(" and (rcontact.type").append(" & 1 ) != 0 ");
            stringBuilder.append(" and ( rcontact.verifyFlag").append(" & 8 ) != 0 ");
            String stringBuilder2 = stringBuilder.toString();
            List<String> arrayList = new ArrayList();
            x.d("MicroMsg.App.BizInfoDataTransfer", "sql %s", stringBuilder2);
            Cursor a = Fc.a(stringBuilder.toString(), null, 2);
            if (a != null) {
                while (a.moveToNext()) {
                    d dVar = new d();
                    dVar.b(a);
                    if (dVar.bK(false).LI() == 1) {
                        arrayList.add(dVar.field_username);
                    }
                }
                a.close();
            }
            if (arrayList.size() > 0) {
                stringBuilder = new StringBuilder();
                stringBuilder.append("Update BizInfo set type").append(" = 1 where 1 !=1 ");
                for (String append : arrayList) {
                    stringBuilder.append(" or username = '").append(append).append("'");
                }
                x.d("MicroMsg.App.BizInfoDataTransfer", "update sql %s", stringBuilder.toString());
                y.Ml().fD("BizInfo", append);
            }
        }
    }
}
