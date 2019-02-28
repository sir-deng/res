package com.tencent.mm.storage;

import android.database.Cursor;
import com.tencent.mm.bx.g;
import com.tencent.mm.bx.h;
import com.tencent.mm.f.a.se;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public final class ac extends i<z> implements com.tencent.mm.bx.g.a {
    public static final String[] gLy = new String[]{i.a(z.gKN, "ContactLabel")};
    private e gLA;
    private HashMap<String, int[]> xGr;
    public HashMap<Integer, ArrayList<String>> xGs;

    /* renamed from: com.tencent.mm.storage.ac$1 */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] xGt = new int[a.ciY().length];

        static {
            try {
                xGt[a.xGu - 1] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                xGt[a.xGv - 1] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                xGt[a.xGw - 1] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    public enum a {
        ;

        public static int[] ciY() {
            return (int[]) xGx.clone();
        }

        static {
            xGu = 1;
            xGv = 2;
            xGw = 3;
            xGx = new int[]{xGu, xGv, xGw};
        }
    }

    public final /* synthetic */ boolean a(c cVar) {
        z zVar = (z) cVar;
        boolean a = super.a(zVar);
        if (a) {
            WI(a("replace", zVar));
        }
        aVx();
        return a;
    }

    public final /* synthetic */ boolean b(c cVar) {
        return a(true, (z) cVar);
    }

    public final /* synthetic */ boolean c(c cVar, String[] strArr) {
        return b(true, (z) cVar, strArr);
    }

    public ac(e eVar) {
        this(eVar, z.gKN, "ContactLabel");
    }

    private ac(e eVar, com.tencent.mm.sdk.e.c.a aVar, String str) {
        super(eVar, aVar, str, null);
        this.xGr = null;
        this.xGs = null;
        this.gLA = eVar;
        eVar.fD("ContactLabel", "CREATE INDEX IF NOT EXISTS  contact_label_createtime_index ON ContactLabel ( createTime )");
    }

    public final int a(g gVar) {
        if (gVar != null) {
            this.gLA = gVar;
        }
        return 0;
    }

    public final ArrayList<String> ciU() {
        ArrayList<String> arrayList = null;
        long Wy = bi.Wy();
        Cursor a = this.gLA.a("ContactLabel", new String[]{"labelName"}, null, null, null, null, "createTime ASC ", 2);
        if (a != null) {
            arrayList = new ArrayList();
            while (a.moveToNext()) {
                arrayList.add(a.getString(0));
            }
            a.close();
            x.i("MicroMsg.Label.ContactLabelStorage", "getAllLabel time:%s count:%s stack:%s", Long.valueOf(bi.bA(Wy)), Integer.valueOf(arrayList.size()), bi.chl());
        }
        return arrayList;
    }

    public final ArrayList<z> ciV() {
        ArrayList<z> arrayList = null;
        long Wy = bi.Wy();
        Cursor a = this.gLA.a("select * from ContactLabel order by createTime ASC ", null, 2);
        if (a != null) {
            arrayList = new ArrayList();
            while (a.moveToNext()) {
                z zVar = new z();
                zVar.b(a);
                arrayList.add(zVar);
            }
            a.close();
            x.i("MicroMsg.Label.ContactLabelStorage", "getAllContactLable time:%s count:%s stack:%s", Long.valueOf(bi.bA(Wy)), Integer.valueOf(arrayList.size()), bi.chl());
        }
        return arrayList;
    }

    public final void aVx() {
        x.v("MicroMsg.Label.ContactLabelStorage", "cleanCache %s", bi.chl());
        this.xGr = null;
        this.xGs = null;
    }

    public final void ciW() {
        if (this.xGr == null || this.xGs == null) {
            HashMap hashMap = new HashMap();
            HashMap hashMap2 = new HashMap();
            long Wy = bi.Wy();
            Cursor a = this.gLA.a("select username , contactLabelIds from rcontact where (type & " + com.tencent.mm.k.a.AE() + " !=0 ) and ( contactLabelIds != '') ;", null, 2);
            if (a == null) {
                this.xGr = hashMap;
                this.xGs = hashMap2;
                return;
            }
            while (a.moveToNext()) {
                String string = a.getString(0);
                if (!bi.oN(string)) {
                    String[] split = bi.oM(a.getString(1)).split(",");
                    if (split != null && split.length > 0) {
                        Object obj = new int[split.length];
                        for (int i = 0; i < split.length; i++) {
                            obj[i] = bi.getInt(split[i], -1);
                            if (hashMap2.containsKey(Integer.valueOf(obj[i]))) {
                                ((ArrayList) hashMap2.get(Integer.valueOf(obj[i]))).add(string);
                            } else {
                                ArrayList arrayList = new ArrayList();
                                arrayList.add(string);
                                hashMap2.put(Integer.valueOf(obj[i]), arrayList);
                            }
                        }
                        hashMap.put(string, obj);
                    }
                }
            }
            a.close();
            x.i("MicroMsg.Label.ContactLabelStorage", "checkRebuildCache time:%s user:%s label:%s stack:%s", Long.valueOf(bi.bA(Wy)), Integer.valueOf(hashMap.size()), Integer.valueOf(hashMap2.size()), bi.chl());
            this.xGr = hashMap;
            this.xGs = hashMap2;
        }
    }

    public final ArrayList<String> Xl(String str) {
        int i = -1;
        long Wy = bi.Wy();
        int i2 = bi.getInt(str, -1);
        if (i2 == -1) {
            x.e("MicroMsg.Label.ContactLabelStorage", "getUserNameListById  failed id:%s", str);
            return null;
        }
        ciW();
        ArrayList<String> arrayList = (ArrayList) this.xGs.get(Integer.valueOf(i2));
        String str2 = "MicroMsg.Label.ContactLabelStorage";
        String str3 = "getUserNameListById time:%s id:%s count:%s stack:%s";
        Object[] objArr = new Object[4];
        objArr[0] = Long.valueOf(bi.bA(Wy));
        objArr[1] = str;
        if (arrayList != null) {
            i = arrayList.size();
        }
        objArr[2] = Integer.valueOf(i);
        objArr[3] = bi.chl();
        x.i(str2, str3, objArr);
        return arrayList;
    }

    public final ArrayList<String> o(String str, List<String> list) {
        Exception e;
        Throwable th;
        x.d("MicroMsg.Label.ContactLabelStorage", "cpan[query] SQL:%s", "select labelName from ContactLabel where labelName like ? or labelPYFull like ? or labelPYShort like ?  order by createTime ASC ");
        Cursor a;
        try {
            a = this.gLA.a("select labelName from ContactLabel where labelName like ? or labelPYFull like ? or labelPYShort like ?  order by createTime ASC ", new String[]{"%" + str + "%", "%" + str + "%", "%" + str + "%"}, 2);
            try {
                int columnIndex = a.getColumnIndex("labelName");
                if (a.moveToFirst()) {
                    ArrayList<String> arrayList = new ArrayList();
                    do {
                        String string = a.getString(columnIndex);
                        if (list == null || list.size() <= 0 || !list.contains(string)) {
                            arrayList.add(string);
                        }
                    } while (a.moveToNext());
                    if (a == null) {
                        return arrayList;
                    }
                    a.close();
                    return arrayList;
                }
                if (a != null) {
                    a.close();
                }
                return null;
            } catch (Exception e2) {
                e = e2;
                try {
                    x.w("MicroMsg.Label.ContactLabelStorage", "cpan[query] exception %s", e.toString());
                    if (a != null) {
                        a.close();
                    }
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    if (a != null) {
                        a.close();
                    }
                    throw th;
                }
            }
        } catch (Exception e3) {
            e = e3;
            a = null;
        } catch (Throwable th3) {
            th = th3;
            a = null;
            if (a != null) {
                a.close();
            }
            throw th;
        }
    }

    public final ArrayList<String> H(String[] strArr) {
        Exception e;
        Throwable th;
        if (strArr == null || strArr.length <= 0) {
            return null;
        }
        int length = strArr.length;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("select * from ContactLabel where labelID");
        stringBuilder.append(" in ( ");
        for (int i = 0; i < length; i++) {
            stringBuilder.append("'" + strArr[i] + "'");
            if (i < length - 1) {
                stringBuilder.append(",");
            }
        }
        stringBuilder.append(" )");
        x.d("MicroMsg.Label.ContactLabelStorage", "cpan[getLabelStrList] SQL:%s", stringBuilder.toString());
        Cursor a;
        try {
            a = this.gLA.a(stringBuilder.toString(), null, 2);
            try {
                length = a.getColumnIndex("labelName");
                if (a.moveToFirst()) {
                    ArrayList<String> arrayList = new ArrayList();
                    do {
                        arrayList.add(a.getString(length));
                    } while (a.moveToNext());
                    x.d("MicroMsg.Label.ContactLabelStorage", "cpan[getLabelStrList] resut size:%d", Integer.valueOf(arrayList.size()));
                    if (a == null) {
                        return arrayList;
                    }
                    a.close();
                    return arrayList;
                }
                if (a != null) {
                    a.close();
                }
                return null;
            } catch (Exception e2) {
                e = e2;
                try {
                    x.w("MicroMsg.Label.ContactLabelStorage", "cpan[getLabelStrList] exception:%s", e.toString());
                    if (a != null) {
                        a.close();
                    }
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    if (a != null) {
                        a.close();
                    }
                    throw th;
                }
            }
        } catch (Exception e3) {
            e = e3;
            a = null;
        } catch (Throwable th3) {
            th = th3;
            a = null;
            if (a != null) {
                a.close();
            }
            throw th;
        }
    }

    public final ArrayList<String> ae(ArrayList<String> arrayList) {
        Exception e;
        Throwable th;
        if (arrayList == null || arrayList.size() <= 0) {
            return null;
        }
        int size = arrayList.size();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("select * from ContactLabel where labelName");
        stringBuilder.append(" in ( ");
        for (int i = 0; i < size; i++) {
            stringBuilder.append("\"" + ((String) arrayList.get(i)) + "\"");
            if (i < size - 1) {
                stringBuilder.append(",");
            }
        }
        stringBuilder.append(" )");
        stringBuilder.append(" and isTemporary=0");
        x.d("MicroMsg.Label.ContactLabelStorage", "cpan[getLabelIDList] SQL:%s", stringBuilder.toString());
        Cursor a;
        try {
            a = this.gLA.a(stringBuilder.toString(), null, 2);
            try {
                int columnIndex = a.getColumnIndex("labelID");
                if (a.moveToFirst()) {
                    ArrayList<String> arrayList2 = new ArrayList();
                    do {
                        arrayList2.add(a.getString(columnIndex));
                    } while (a.moveToNext());
                    x.d("MicroMsg.Label.ContactLabelStorage", "cpan[getLabelIDList] resut size:%d", Integer.valueOf(arrayList2.size()));
                    if (a == null) {
                        return arrayList2;
                    }
                    a.close();
                    return arrayList2;
                }
                if (a != null) {
                    a.close();
                }
                return null;
            } catch (Exception e2) {
                e = e2;
                try {
                    x.w("MicroMsg.Label.ContactLabelStorage", "cpan[getLabelIDList] exception:%s", e.toString());
                    if (a != null) {
                        a.close();
                    }
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    if (a != null) {
                        a.close();
                    }
                    throw th;
                }
            }
        } catch (Exception e3) {
            e = e3;
            a = null;
        } catch (Throwable th3) {
            th = th3;
            a = null;
            if (a != null) {
                a.close();
            }
            throw th;
        }
    }

    private boolean a(boolean z, z zVar) {
        boolean b = super.b((c) zVar);
        if (b && z) {
            WI(a("insert", zVar));
        }
        return b;
    }

    public final boolean iI(String str) {
        int delete;
        x.i("MicroMsg.Label.ContactLabelStorage", "cpan[delete] labelID:%s", str);
        x.d("MicroMsg.Label.ContactLabelStorage", "cpan[query] SQL:%s", "labelID =? ");
        try {
            delete = this.gLA.delete("ContactLabel", "labelID =? ", new String[]{str});
        } catch (Exception e) {
            x.w("MicroMsg.Label.ContactLabelStorage", "cpan[delete] exception %s", e.toString());
            delete = -1;
        }
        if (delete > 0) {
            return true;
        }
        return false;
    }

    public boolean a(boolean z, z zVar, String... strArr) {
        boolean a = super.a((c) zVar, strArr);
        if (a && z) {
            WI(a("delete", zVar));
            ciX();
        }
        aVx();
        return a;
    }

    public boolean b(boolean z, z zVar, String... strArr) {
        boolean c = super.c(zVar, strArr);
        if (c && z) {
            WI(a("update", zVar));
        }
        aVx();
        return c;
    }

    public final boolean cG(List<z> list) {
        if (list.size() <= 0) {
            x.i("MicroMsg.Label.ContactLabelStorage", "cpan[insertAddLabel] list is null.");
        } else {
            long dA;
            h hVar;
            if (this.gLA instanceof h) {
                h hVar2 = (h) this.gLA;
                dA = hVar2.dA(Thread.currentThread().getId());
                x.i("MicroMsg.Label.ContactLabelStorage", "begin insertOrUpdateList in a transaction, ticket = %d", Long.valueOf(dA));
                hVar = hVar2;
            } else {
                hVar = null;
                dA = -1;
            }
            int size = list.size();
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < size; i++) {
                String c = c((z) list.get(i));
                if (!bi.oN(c)) {
                    iI(c);
                }
            }
            if (hVar != null) {
                hVar.fT(dA);
                x.i("MicroMsg.Label.ContactLabelStorage", "end deleteLocalLabel transaction");
            }
            aVx();
        }
        return false;
    }

    public final boolean cH(List<z> list) {
        if (list.size() <= 0) {
            x.i("MicroMsg.Label.ContactLabelStorage", "cpan[insertOrUpdateList] list is null.");
            return false;
        }
        long dA;
        h hVar;
        List arrayList = new ArrayList();
        List arrayList2 = new ArrayList();
        if (this.gLA instanceof h) {
            h hVar2 = (h) this.gLA;
            dA = hVar2.dA(Thread.currentThread().getId());
            x.i("MicroMsg.Label.ContactLabelStorage", "begin insertOrUpdateList in a transaction, ticket = %d", Long.valueOf(dA));
            hVar = hVar2;
        } else {
            hVar = null;
            dA = -1;
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            z zVar = (z) list.get(i);
            if (zVar != null) {
                switch (AnonymousClass1.xGt[b(zVar) - 1]) {
                    case 1:
                        break;
                    case 2:
                        b(false, zVar, "labelID");
                        arrayList2.add(zVar);
                        break;
                    case 3:
                        zVar.field_createTime = System.currentTimeMillis();
                        a(false, zVar);
                        arrayList.add(zVar);
                        break;
                    default:
                        x.w("MicroMsg.Label.ContactLabelStorage", "cpan[insertOrUpdateList] unknow result.");
                        break;
                }
            }
        }
        if (hVar != null) {
            hVar.fT(dA);
            x.i("MicroMsg.Label.ContactLabelStorage", "end insertOrUpdateList transaction");
        }
        if (arrayList.size() > 0) {
            WI(p("insert", arrayList));
        }
        if (arrayList2.size() > 0) {
            WI(p("update", arrayList2));
        }
        aVx();
        return false;
    }

    public final String DT(String str) {
        Exception e;
        Throwable th;
        Cursor a;
        try {
            a = this.gLA.a("ContactLabel", new String[]{"labelName"}, "labelID =?", new String[]{str}, null, null, null, 2);
            if (a != null) {
                try {
                    if (a.moveToFirst()) {
                        String string = a.getString(a.getColumnIndex("labelName"));
                        x.i("MicroMsg.Label.ContactLabelStorage", "cpan[getLabelStrById] label string is %s", string);
                        if (a == null) {
                            return string;
                        }
                        a.close();
                        return string;
                    }
                } catch (Exception e2) {
                    e = e2;
                    try {
                        x.w("MicroMsg.Label.ContactLabelStorage", "cpan[getLabelStrById] exception %s", e.toString());
                        if (a != null) {
                            a.close();
                        }
                        return null;
                    } catch (Throwable th2) {
                        th = th2;
                        if (a != null) {
                            a.close();
                        }
                        throw th;
                    }
                }
            }
            if (a != null) {
                a.close();
            }
        } catch (Exception e3) {
            e = e3;
            a = null;
        } catch (Throwable th3) {
            th = th3;
            a = null;
            if (a != null) {
                a.close();
            }
            throw th;
        }
        return null;
    }

    public final String DU(String str) {
        Exception e;
        Throwable th;
        Cursor a;
        try {
            a = this.gLA.a("ContactLabel", new String[]{"labelID"}, "labelName =?", new String[]{str}, null, null, null, 2);
            if (a != null) {
                try {
                    if (a.moveToFirst()) {
                        String string = a.getString(a.getColumnIndex("labelID"));
                        x.i("MicroMsg.Label.ContactLabelStorage", "cpan[getLabelIdByStr] label id is %s", string);
                        if (a == null) {
                            return string;
                        }
                        a.close();
                        return string;
                    }
                } catch (Exception e2) {
                    e = e2;
                    try {
                        x.w("MicroMsg.Label.ContactLabelStorage", "cpan[getLabelIdByStr] exception %s", e.toString());
                        if (a != null) {
                            a.close();
                        }
                        return null;
                    } catch (Throwable th2) {
                        th = th2;
                        if (a != null) {
                            a.close();
                        }
                        throw th;
                    }
                }
            }
            if (a != null) {
                a.close();
            }
        } catch (Exception e3) {
            e = e3;
            a = null;
        } catch (Throwable th3) {
            th = th3;
            a = null;
            if (a != null) {
                a.close();
            }
            throw th;
        }
        return null;
    }

    public final z Xm(String str) {
        Exception e;
        Throwable th;
        Cursor cursor = null;
        Cursor a;
        try {
            a = this.gLA.a("ContactLabel", new String[]{"labelID", "createTime", "isTemporary", "labelName", "labelPYFull", "labelPYShort"}, "labelName =?", new String[]{str}, null, null, null, 2);
            if (a != null) {
                try {
                    if (a.moveToFirst()) {
                        z zVar = new z();
                        zVar.b(a);
                        if (a == null) {
                            return zVar;
                        }
                        a.close();
                        return zVar;
                    }
                } catch (Exception e2) {
                    e = e2;
                    try {
                        x.w("MicroMsg.Label.ContactLabelStorage", "cpan[getLabelIdByStr] exception %s", e.toString());
                        if (a != null) {
                            a.close();
                        }
                        return null;
                    } catch (Throwable th2) {
                        th = th2;
                        cursor = a;
                        if (cursor != null) {
                            cursor.close();
                        }
                        throw th;
                    }
                }
            }
            if (a != null) {
                a.close();
            }
        } catch (Exception e3) {
            e = e3;
            a = null;
        } catch (Throwable th3) {
            th = th3;
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
        return null;
    }

    public final z Xn(String str) {
        Exception e;
        Throwable th;
        Cursor cursor = null;
        Cursor a;
        try {
            a = this.gLA.a("ContactLabel", new String[]{"labelID", "createTime", "isTemporary", "labelName", "labelPYFull", "labelPYShort"}, "labelID =?", new String[]{str}, null, null, null, 2);
            if (a != null) {
                try {
                    if (a.moveToFirst()) {
                        z zVar = new z();
                        zVar.b(a);
                        if (a == null) {
                            return zVar;
                        }
                        a.close();
                        return zVar;
                    }
                } catch (Exception e2) {
                    e = e2;
                    try {
                        x.w("MicroMsg.Label.ContactLabelStorage", "cpan[getLabelByID] exception %s", e.toString());
                        if (a != null) {
                            a.close();
                        }
                        return null;
                    } catch (Throwable th2) {
                        th = th2;
                        cursor = a;
                        if (cursor != null) {
                            cursor.close();
                        }
                        throw th;
                    }
                }
            }
            if (a != null) {
                a.close();
            }
        } catch (Exception e3) {
            e = e3;
            a = null;
        } catch (Throwable th3) {
            th = th3;
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
        return null;
    }

    private int b(z zVar) {
        Cursor cursor = null;
        try {
            cursor = this.gLA.a("select * from ContactLabel where labelID=?", new String[]{zVar.field_labelID}, 2);
            if (cursor == null || !cursor.moveToFirst()) {
                if (cursor != null) {
                    cursor.close();
                }
                return a.xGw;
            }
            int i;
            if (zVar.field_labelName.equalsIgnoreCase(bi.aD(cursor.getString(cursor.getColumnIndex("labelName")), ""))) {
                i = a.xGu;
                if (cursor == null) {
                    return i;
                }
                cursor.close();
                return i;
            }
            i = a.xGv;
            if (cursor == null) {
                return i;
            }
            cursor.close();
            return i;
        } catch (Exception e) {
            x.w("MicroMsg.Label.ContactLabelStorage", "cpan[checkEqualsName] exception %s", e.toString());
            if (cursor != null) {
                cursor.close();
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    private String c(z zVar) {
        Exception e;
        Throwable th;
        String str = null;
        Cursor a;
        try {
            a = this.gLA.a("select * from ContactLabel where labelName=? and isTemporary =?", new String[]{zVar.field_labelName, "1"}, 2);
            if (a != null) {
                try {
                    if (a.moveToFirst()) {
                        boolean equalsIgnoreCase = zVar.field_labelName.equalsIgnoreCase(bi.aD(a.getString(a.getColumnIndex("labelName")), ""));
                        x.i("MicroMsg.Label.ContactLabelStorage", "cpan[checkEqualsName] itemname:%s dbname:%s", zVar.field_labelName, r1);
                        if (equalsIgnoreCase) {
                            str = a.getString(a.getColumnIndex("labelID"));
                            if (a != null) {
                                a.close();
                            }
                            return str;
                        }
                    }
                } catch (Exception e2) {
                    e = e2;
                    try {
                        x.w("MicroMsg.Label.ContactLabelStorage", "cpan[checkEqualsName] exception %s", e.toString());
                        if (a != null) {
                            a.close();
                        }
                        return str;
                    } catch (Throwable th2) {
                        th = th2;
                        if (a != null) {
                            a.close();
                        }
                        throw th;
                    }
                }
            }
            if (a != null) {
                a.close();
            }
        } catch (Exception e3) {
            e = e3;
            a = null;
        } catch (Throwable th3) {
            a = null;
            th = th3;
            if (a != null) {
                a.close();
            }
            throw th;
        }
        return str;
    }

    private static String a(String str, z zVar) {
        if (zVar == null) {
            return null;
        }
        List arrayList = new ArrayList();
        arrayList.add(zVar);
        return p(str, arrayList);
    }

    private static String p(String str, List<z> list) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(" ");
        if (list == null || list.size() <= 0) {
            return null;
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            z zVar = (z) list.get(i);
            if (zVar != null) {
                stringBuilder.append(zVar.field_labelID);
                if (i < size - 1) {
                    stringBuilder.append(" ");
                }
            }
        }
        x.i("MicroMsg.Label.ContactLabelStorage", "cpan[genNotifyString] event:%s", stringBuilder.toString());
        return stringBuilder.toString();
    }

    private static void ciX() {
        x.i("MicroMsg.Label.ContactLabelStorage", "cpan[publishUpdateSearchIndexEvent]");
        b seVar = new se();
        seVar.fKK.fqN = 3000;
        com.tencent.mm.sdk.b.a.xmy.m(seVar);
    }

    public final boolean cI(List<z> list) {
        if (list == null || list.size() <= 0) {
            x.w("MicroMsg.Label.ContactLabelStorage", "cpan[deleteList] list is null.");
            return false;
        }
        long dA;
        h hVar;
        if (this.gLA instanceof h) {
            h hVar2 = (h) this.gLA;
            dA = hVar2.dA(Thread.currentThread().getId());
            x.i("MicroMsg.Label.ContactLabelStorage", "begin deleteList in a transaction, ticket = %d", Long.valueOf(dA));
            hVar = hVar2;
        } else {
            hVar = null;
            dA = -1;
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            a(false, (z) list.get(i), "labelID");
        }
        if (hVar != null) {
            hVar.fT(dA);
            x.i("MicroMsg.Label.ContactLabelStorage", "end insertOrUpdateList transaction");
        }
        WI(p("delete", list));
        ciX();
        return true;
    }

    public final ArrayList<z> cJ(List<z> list) {
        Exception e;
        Throwable th;
        if (list.size() <= 0) {
            return null;
        }
        int size = list.size();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("select * from ContactLabel where labelID");
        stringBuilder.append(" not in ( ");
        for (int i = 0; i < size; i++) {
            stringBuilder.append("'" + ((z) list.get(i)).field_labelID + "'");
            if (i < size - 1) {
                stringBuilder.append(",");
            }
        }
        stringBuilder.append(" )");
        stringBuilder.append(" and isTemporary=0");
        x.d("MicroMsg.Label.ContactLabelStorage", "cpan[getLabelIdListNoInList] SQL:%s", stringBuilder.toString());
        Cursor a;
        try {
            a = this.gLA.a(stringBuilder.toString(), null, 2);
            try {
                if (a.moveToFirst()) {
                    ArrayList<z> arrayList = new ArrayList();
                    do {
                        z zVar = new z();
                        zVar.b(a);
                        arrayList.add(zVar);
                    } while (a.moveToNext());
                    x.d("MicroMsg.Label.ContactLabelStorage", "cpan[getLabelIdListNoInList] resut size:%d", Integer.valueOf(arrayList.size()));
                    if (a == null) {
                        return arrayList;
                    }
                    a.close();
                    return arrayList;
                }
                if (a != null) {
                    a.close();
                }
                return null;
            } catch (Exception e2) {
                e = e2;
                try {
                    x.w("MicroMsg.Label.ContactLabelStorage", "cpan[getLabelIdListNoInList] exception:%s", e.toString());
                    if (a != null) {
                        a.close();
                    }
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    if (a != null) {
                        a.close();
                    }
                    throw th;
                }
            }
        } catch (Exception e3) {
            e = e3;
            a = null;
        } catch (Throwable th3) {
            th = th3;
            a = null;
            if (a != null) {
                a.close();
            }
            throw th;
        }
    }
}
