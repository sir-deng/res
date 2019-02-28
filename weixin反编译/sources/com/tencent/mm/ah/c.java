package com.tencent.mm.ah;

import android.database.Cursor;
import com.tencent.mm.f.b.ag;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.af;
import com.tencent.mm.y.as;
import java.util.LinkedList;
import java.util.List;

public final class c extends af {
    public final boolean gO(int i) {
        return i != 0 && i < 620757033;
    }

    public final void transfer(int i) {
        x.d("MicroMsg.DataTransfer.BlackListConvDataTransfer", "the previous version is %d", Integer.valueOf(i));
        if (i != 0 && i < 620757033) {
            g.pWK.h(336, 13);
            List<String> linkedList = new LinkedList();
            as.Hm();
            Cursor c = com.tencent.mm.y.c.Ff().c("@black.android", "", null);
            if (c != null) {
                c.moveToFirst();
                while (!c.isAfterLast()) {
                    ag xVar = new com.tencent.mm.storage.x();
                    xVar.b(c);
                    linkedList.add(xVar.field_username);
                    c.moveToNext();
                }
                c.close();
            }
            if (linkedList.size() > 0) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Update rconversation");
                stringBuilder.append(" set parentRef = '@blacklist").append("' where 1 != 1 ");
                for (String append : linkedList) {
                    stringBuilder.append(" or username = '").append(append).append("'");
                }
                x.d("MicroMsg.DataTransfer.BlackListConvDataTransfer", "update sql: %s", stringBuilder.toString());
                as.Hm();
                com.tencent.mm.y.c.Fc().fD("rconversation", append);
            }
        }
    }

    public final String getTag() {
        return "MicroMsg.DataTransfer.BlackListConvDataTransfer";
    }
}
