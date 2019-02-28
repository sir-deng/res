package com.tencent.mm.storage;

import android.database.Cursor;
import com.tencent.mm.protocal.c.to;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public final class d extends i<c> {
    public static final String[] gLy = new String[]{i.a(c.gKN, "ABTestItem")};
    private final e gLA;

    public d(e eVar) {
        super(eVar, c.gKN, "ABTestItem", null);
        this.gLA = eVar;
    }

    public final c fp(String str) {
        c cVar = new c();
        cVar.field_layerId = str;
        if (super.b(cVar, new String[0]) && cVar.field_endTime == 0) {
            cVar.field_endTime = Long.MAX_VALUE;
        }
        x.i("MicroMsg.ABTestStorage", "getByLayerId, id: %s, return: %b", str, Boolean.valueOf(r1));
        return cVar;
    }

    public final Map<String, c> WV(String str) {
        Cursor cursor;
        if (bi.oN(str)) {
            cursor = null;
        } else {
            cursor = rawQuery(String.format("select * from %s where %s = %s", new Object[]{"ABTestItem", "business", str}), new String[0]);
        }
        if (cursor == null || !cursor.moveToFirst()) {
            if (cursor != null) {
                cursor.close();
            }
            return new HashMap(0);
        }
        Map<String, c> hashMap = new HashMap();
        do {
            c cVar = new c();
            cVar.b(cursor);
            hashMap.put(cVar.field_layerId, cVar);
        } while (cursor.moveToNext());
        cursor.close();
        return hashMap;
    }

    public final void i(List<c> list, int i) {
        c cVar;
        Object obj = null;
        long Wx = bi.Wx();
        this.gLA.delete("ABTestItem", String.format(Locale.US, "%s<>0 and %s<%d", new Object[]{"endTime", "endTime", Long.valueOf(Wx)}), null);
        if (i == 0) {
            cVar = new c();
            cVar.field_prioritylevel = 1;
            a(cVar, false, "prioritylevel");
        }
        for (c cVar2 : list) {
            boolean z;
            Object obj2;
            if (cVar2 == null || bi.oN(cVar2.field_layerId)) {
                x.e("MicroMsg.ABTestStorage", "saveIfNecessary, Invalid item");
                z = false;
            } else {
                c cVar3 = new c();
                cVar3.field_layerId = cVar2.field_layerId;
                if (!super.b(cVar3, new String[0])) {
                    x.i("MicroMsg.ABTestStorage", "Inserted: %s, Result: %b", cVar2.field_layerId, Boolean.valueOf(super.a(cVar2, false)));
                    z = r2;
                } else if ((cVar2.field_sequence <= cVar3.field_sequence || cVar2.field_prioritylevel != cVar3.field_prioritylevel) && cVar2.field_prioritylevel <= cVar3.field_prioritylevel) {
                    x.i("MicroMsg.ABTestStorage", "Ignored: %s, Seq: %d, %d, PriorityLV: %d, %d", cVar2.field_layerId, Long.valueOf(cVar3.field_sequence), Long.valueOf(cVar2.field_sequence), Integer.valueOf(cVar3.field_prioritylevel), Integer.valueOf(cVar2.field_prioritylevel));
                    z = false;
                } else {
                    x.i("MicroMsg.ABTestStorage", "Updated: %s, Result: %b, Seq: %d, %d, PriorityLV: %d, %d", cVar2.field_layerId, Boolean.valueOf(super.b(cVar2, false, new String[0])), Long.valueOf(cVar3.field_sequence), Long.valueOf(cVar2.field_sequence), Integer.valueOf(cVar3.field_prioritylevel), Integer.valueOf(cVar2.field_prioritylevel));
                    z = r2;
                }
            }
            if (z) {
                obj2 = 1;
            } else {
                obj2 = obj;
            }
            obj = obj2;
        }
        if (obj != null) {
            WI("event_updated");
        }
    }

    public final String ciu() {
        Cursor Tq = Tq();
        if (Tq == null) {
            return "null cursor!!";
        }
        if (Tq.moveToFirst()) {
            StringBuilder stringBuilder = new StringBuilder();
            c cVar = new c();
            do {
                stringBuilder.append("============\n");
                cVar.b(Tq);
                stringBuilder.append("layerId = ").append(cVar.field_layerId).append("\n");
                stringBuilder.append("sequence = ").append(cVar.field_sequence).append("\n");
                stringBuilder.append("priorityLV = ").append(cVar.field_prioritylevel).append("\n");
                stringBuilder.append("expId = ").append(cVar.field_expId).append("\n");
            } while (Tq.moveToNext());
            Tq.close();
            return stringBuilder.toString();
        }
        Tq.close();
        return "cursor empty!!";
    }

    public final LinkedList<to> cit() {
        LinkedList<to> linkedList = new LinkedList();
        Cursor Tq = Tq();
        if (Tq != null && Tq.moveToFirst()) {
            c cVar = new c();
            do {
                cVar.b(Tq);
                to toVar = new to();
                try {
                    toVar.wfY = bi.getInt(cVar.field_expId, 0);
                } catch (Exception e) {
                    x.e("MicroMsg.ABTestStorage", "expId parse failed, %s", cVar.field_expId);
                }
                toVar.priority = cVar.field_prioritylevel;
                linkedList.add(toVar);
            } while (Tq.moveToNext());
            Tq.close();
        }
        return linkedList;
    }
}
