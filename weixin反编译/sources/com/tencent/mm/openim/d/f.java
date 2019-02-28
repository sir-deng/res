package com.tencent.mm.openim.d;

import android.database.Cursor;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;
import java.util.List;

public final class f extends i<e> {
    public static final String[] gLy = new String[]{i.a(e.gKN, "OpenIMWordingInfo")};
    private e gLA;

    public f(e eVar) {
        super(eVar, e.gKN, "OpenIMWordingInfo", null);
        this.gLA = eVar;
    }

    public final boolean a(e eVar) {
        eVar.field_updateTime = bi.Wx();
        return super.a(eVar);
    }

    public final List<String> bl(int i, String str) {
        List<String> linkedList = new LinkedList();
        x.d("MicroMsg.OpenIMWordingInfoStg", "getLastWording sql:%s", " select wordingId from OpenIMWordingInfo where language='" + str + "' order by updateTime limit " + i);
        Cursor a = this.gLA.a(r1, null, 2);
        if (a.moveToFirst()) {
            do {
                String string = a.getString(0);
                if (!bi.oN(string)) {
                    linkedList.add(string);
                }
            } while (a.moveToNext());
        }
        x.d("MicroMsg.OpenIMWordingInfoStg", "getLastWording result cnt: %d, language:%s", Integer.valueOf(linkedList.size()), str);
        a.close();
        return linkedList;
    }
}
