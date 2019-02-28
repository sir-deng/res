package com.tencent.mm.plugin.remittance.b;

import android.database.Cursor;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Map;

public final class d extends i<c> {
    public static final String[] gLy = new String[]{i.a(c.gKN, "RemittanceRecord")};
    public static Map<String, c> ijA = new HashMap();
    private static final String[] ijz = new String[]{"*", "rowid"};
    private e gLA;

    public final /* synthetic */ boolean a(c cVar, String[] strArr) {
        cVar = (c) cVar;
        if (cVar != null && ijA.containsKey(cVar.field_transferId)) {
            ijA.remove(cVar.field_transferId);
        }
        return super.a(cVar, strArr);
    }

    public final /* synthetic */ boolean b(c cVar) {
        cVar = (c) cVar;
        if (cVar != null && ijA.containsKey(cVar.field_transferId)) {
            ijA.put(cVar.field_transferId, cVar);
        }
        return super.b(cVar);
    }

    public d(e eVar) {
        super(eVar, c.gKN, "RemittanceRecord", null);
        this.gLA = eVar;
    }

    public final c IU(String str) {
        if (bi.oN(str)) {
            return null;
        }
        Cursor a = this.gLA.a("RemittanceRecord", ijz, "transferId=?", new String[]{str}, null, null, null, 2);
        c cVar;
        try {
            if (a.moveToFirst()) {
                cVar = new c();
                cVar.b(a);
                return cVar;
            }
            a.close();
            return null;
        } catch (Exception e) {
            cVar = e;
            x.printErrStackTrace("MicroMsg.RemittanceSendRecordStorage", cVar, "getRecordByTransferId error: %s", cVar.getMessage());
            return null;
        } finally {
            a.close();
        }
    }

    public final boolean a(c cVar) {
        if (cVar != null && ijA.containsKey(cVar.field_transferId)) {
            ijA.put(cVar.field_transferId, cVar);
        }
        return super.a(cVar);
    }
}
