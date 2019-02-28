package com.tencent.mm.storage;

import android.database.Cursor;
import com.tencent.mm.protocal.c.to;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

public final class b extends i<a> {
    public static final String[] gLy = new String[]{i.a(a.gKN, "ABTestInfo")};
    private e gLA;

    public b(e eVar) {
        super(eVar, a.gKN, "ABTestInfo", null);
        this.gLA = eVar;
    }

    public final void i(List<a> list, int i) {
        c aVar;
        Object obj = null;
        long Wx = bi.Wx();
        this.gLA.delete("ABTestInfo", String.format(Locale.US, "%s<>0 and %s<%d", new Object[]{"endTime", "endTime", Long.valueOf(Wx)}), null);
        if (1 == i) {
            aVar = new a();
            aVar.field_prioritylevel = 1;
            a(aVar, false, "prioritylevel");
        }
        for (c aVar2 : list) {
            boolean z;
            Object obj2;
            if (aVar2 == null || bi.oN(aVar2.field_abtestkey)) {
                x.e("MicroMsg.ABTestInfoStorage", "saveIfNecessary, Invalid item");
                z = false;
            } else {
                c aVar3 = new a();
                aVar3.field_abtestkey = aVar2.field_abtestkey;
                if (!super.b(aVar3, new String[0])) {
                    x.i("MicroMsg.ABTestInfoStorage", "Inserted: %s, Result: %b", aVar2.field_abtestkey, Boolean.valueOf(super.a(aVar2, false)));
                    z = r2;
                } else if ((aVar2.field_sequence <= aVar3.field_sequence || aVar2.field_prioritylevel != aVar3.field_prioritylevel) && aVar2.field_prioritylevel <= aVar3.field_prioritylevel) {
                    x.i("MicroMsg.ABTestInfoStorage", "Ignored: %s, Seq: %d, %d, PriorityLV: %d, %d", aVar2.field_abtestkey, Long.valueOf(aVar3.field_sequence), Long.valueOf(aVar2.field_sequence), Integer.valueOf(aVar3.field_prioritylevel), Integer.valueOf(aVar2.field_prioritylevel));
                    z = false;
                } else {
                    x.i("MicroMsg.ABTestInfoStorage", "Updated: %s, Result: %b, Seq: %d, %d, PriorityLV: %d, %d", aVar2.field_abtestkey, Boolean.valueOf(super.b(aVar2, false, new String[0])), Long.valueOf(aVar3.field_sequence), Long.valueOf(aVar2.field_sequence), Integer.valueOf(aVar3.field_prioritylevel), Integer.valueOf(aVar2.field_prioritylevel));
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

    public final LinkedList<to> cit() {
        LinkedList<to> linkedList = new LinkedList();
        Cursor Tq = Tq();
        if (Tq != null) {
            if (Tq.moveToFirst()) {
                a aVar = new a();
                do {
                    aVar.b(Tq);
                    to toVar = new to();
                    try {
                        toVar.wfY = bi.getInt(aVar.field_expId, 0);
                    } catch (Exception e) {
                        x.e("MicroMsg.ABTestInfoStorage", "expId parse failed, %s", aVar.field_expId);
                    }
                    toVar.priority = aVar.field_prioritylevel;
                    linkedList.add(toVar);
                } while (Tq.moveToNext());
                Tq.close();
            } else {
                Tq.close();
            }
        }
        return linkedList;
    }

    public final a WU(String str) {
        c aVar = new a();
        aVar.field_abtestkey = str;
        if (super.b(aVar, new String[0]) && aVar.field_endTime == 0) {
            aVar.field_endTime = Long.MAX_VALUE;
        }
        x.i("MicroMsg.ABTestInfoStorage", "getByLayerId, id: %s, return: %b", str, Boolean.valueOf(r1));
        return aVar;
    }

    public final int dd(String str, int i) {
        a WU = WU(str);
        if (WU.isValid()) {
            return bi.getInt(WU.field_value, i);
        }
        return i;
    }

    public final String getExpIdByKey(String str) {
        a WU = WU(str);
        if (WU.isValid()) {
            return WU.field_expId == null ? "" : WU.field_expId;
        } else {
            return "";
        }
    }

    public final String ciu() {
        Cursor Tq = Tq();
        if (Tq == null) {
            return "null cursor!!";
        }
        if (Tq.moveToFirst()) {
            StringBuilder stringBuilder = new StringBuilder();
            a aVar = new a();
            do {
                stringBuilder.append("============\n");
                aVar.b(Tq);
                stringBuilder.append("abtestkey = ").append(aVar.field_abtestkey).append("\n");
                stringBuilder.append("sequence = ").append(aVar.field_sequence).append("\n");
                stringBuilder.append("priorityLV = ").append(aVar.field_prioritylevel).append("\n");
                stringBuilder.append("expId = ").append(aVar.field_expId).append("\n");
            } while (Tq.moveToNext());
            Tq.close();
            return stringBuilder.toString();
        }
        Tq.close();
        return "cursor empty!!";
    }
}
