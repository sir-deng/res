package com.tencent.mm.af;

import android.database.Cursor;
import android.os.Looper;
import com.tencent.mm.af.d.b;
import com.tencent.mm.f.b.ak;
import com.tencent.mm.f.b.cg;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.e.k;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.y.s;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public final class e extends i<d> {
    public static final String[] fNF = new String[]{"CREATE  INDEX IF NOT EXISTS type_username_index ON bizinfo ( type,username ) ", "CREATE  INDEX IF NOT EXISTS  username_acceptType_index ON bizinfo ( username,acceptType ) "};
    public static final String[] gLy = new String[]{i.a(d.gKN, "bizinfo")};
    public static Map<String, String> hrh = new HashMap();
    private final k<a, b> hpN = new k<a, b>() {
        protected final /* synthetic */ void p(Object obj, Object obj2) {
            ((a) obj).a((b) obj2);
        }
    };

    public interface a {

        public static class b {
            public String hpQ;
            public boolean hqq;
            public int hrn;
            public d hro;
        }

        public enum a {
            ;

            static {
                hrj = 1;
                hrk = 2;
                hrl = 3;
                hrm = new int[]{hrj, hrk, hrl};
            }
        }

        void a(b bVar);
    }

    public final /* synthetic */ boolean a(c cVar) {
        return e((d) cVar);
    }

    public final /* synthetic */ boolean b(c cVar) {
        return d((d) cVar);
    }

    public e(com.tencent.mm.sdk.e.e eVar) {
        super(eVar, d.gKN, "bizinfo", fNF);
    }

    public final void a(a aVar, Looper looper) {
        this.hpN.a(aVar, looper);
    }

    public final void a(a aVar) {
        if (this.hpN != null) {
            this.hpN.remove(aVar);
        }
    }

    public final d jN(String str) {
        c dVar = new d();
        dVar.field_username = str;
        super.b(dVar, new String[0]);
        return dVar;
    }

    public final void jO(String str) {
        c dVar = new d();
        dVar.field_username = str;
        String[] strArr = new String[]{"username"};
        x.i("MicroMsg.BizInfoStorage", "delete biz ret = %b, username = %s", Boolean.valueOf(super.a(dVar, strArr)), str);
        b bVar = new b();
        bVar.hpQ = str;
        bVar.hrn = a.hrk;
        bVar.hro = dVar;
        this.hpN.cb(bVar);
        this.hpN.doNotify();
    }

    public final void c(d dVar) {
        String[] strArr = new String[]{"username"};
        x.i("MicroMsg.BizInfoStorage", "delete biz ret = %b, username = %s", Boolean.valueOf(super.a((c) dVar, strArr)), dVar.field_username);
        b bVar = new b();
        bVar.hpQ = dVar.field_username;
        bVar.hrn = a.hrk;
        bVar.hro = dVar;
        this.hpN.cb(bVar);
        this.hpN.doNotify();
    }

    public final boolean d(d dVar) {
        dVar.field_updateTime = System.currentTimeMillis();
        dVar.Lf();
        x.v("MicroMsg.BizInfoStorage", "username is %s, %s, %d, %s, %s, %s, %d", dVar.field_username, dVar.field_brandList, Integer.valueOf(dVar.field_brandFlag), dVar.field_brandInfo, dVar.field_extInfo, dVar.field_brandIconURL, Long.valueOf(dVar.field_updateTime));
        b bK = dVar.bK(false);
        if (bK != null) {
            b.b LE = bK.LE();
            if (LE != null) {
                dVar.field_specialType = LE.hqM;
            }
        }
        boolean b = super.b((c) dVar);
        if (b && !s.eX(dVar.field_username)) {
            b bVar = new b();
            bVar.hpQ = dVar.field_username;
            bVar.hqq = dVar.Lg();
            bVar.hrn = a.hrj;
            bVar.hro = dVar;
            this.hpN.cb(bVar);
            this.hpN.doNotify();
        }
        return b;
    }

    public final boolean e(d dVar) {
        dVar.field_updateTime = System.currentTimeMillis();
        dVar.Lf();
        b bK = dVar.bK(false);
        if (bK != null) {
            b.b LE = bK.LE();
            if (LE != null) {
                dVar.field_specialType = LE.hqM;
            }
        }
        boolean a = super.a(dVar);
        if (a && !s.eX(dVar.field_username)) {
            b bVar = new b();
            bVar.hpQ = dVar.field_username;
            bVar.hqq = dVar.Lg();
            bVar.hrn = a.hrl;
            bVar.hro = dVar;
            this.hpN.cb(bVar);
            this.hpN.doNotify();
        }
        return a;
    }

    public final List<String> ht(int i) {
        x.i("MicroMsg.BizInfoStorage", "getList: sql[%s]", String.format(Locale.US, "select %s from %s where %s & %d > 0", new Object[]{"username", "bizinfo", "acceptType", Integer.valueOf(i)}));
        long Wz = bi.Wz();
        Cursor rawQuery = rawQuery(r0, new String[0]);
        List<String> linkedList = new LinkedList();
        if (rawQuery != null) {
            if (rawQuery.moveToFirst()) {
                do {
                    linkedList.add(rawQuery.getString(0));
                } while (rawQuery.moveToNext());
            }
            rawQuery.close();
            x.i("MicroMsg.BizInfoStorage", "getMyAcceptList: type[%d], use time[%d ms]", Integer.valueOf(i), Long.valueOf(bi.bB(Wz)));
            return ((h) g.h(h.class)).Ff().cU(linkedList);
        }
        x.i("MicroMsg.BizInfoStorage", "getMyAcceptList: cursor not null, type[%d], use time[%d ms]", Integer.valueOf(i), Long.valueOf(bi.bB(Wz)));
        return linkedList;
    }

    public final int hu(int i) {
        List ht = ht(i);
        if (bi.cC(ht)) {
            return 0;
        }
        return ht.size();
    }

    public static String LO() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("rcontact.showHead asc, ");
        stringBuffer.append(" case when length(rcontact.conRemarkPYFull) > 0 then upper(").append("rcontact.conRemarkPYFull) ");
        stringBuffer.append(" else upper(rcontact.quanPin) end asc, ");
        stringBuffer.append(" case when length(rcontact.conRemark) > 0 then upper(").append("rcontact.conRemark) ");
        stringBuffer.append(" else upper(rcontact.quanPin) end asc, ");
        stringBuffer.append(" upper(rcontact.quanPin) asc, ");
        stringBuffer.append(" upper(rcontact.nickname) asc, ");
        stringBuffer.append(" upper(rcontact.username) asc ");
        return stringBuffer.toString();
    }

    public static String LP() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("rcontact.type & ").append(2048).append(" desc, ");
        stringBuffer.append("rcontact.showHead asc, ");
        stringBuffer.append(" case when length(rcontact.conRemarkPYFull) > 0 then upper(").append("rcontact.conRemarkPYFull) ");
        stringBuffer.append(" else upper(rcontact.quanPin) end asc, ");
        stringBuffer.append(" case when length(rcontact.conRemark) > 0 then upper(").append("rcontact.conRemark) ");
        stringBuffer.append(" else upper(rcontact.quanPin) end asc, ");
        stringBuffer.append(" upper(rcontact.quanPin) asc, ");
        stringBuffer.append(" upper(rcontact.nickname) asc, ");
        stringBuffer.append(" upper(rcontact.username) asc ");
        return stringBuffer.toString();
    }

    public static void a(StringBuilder stringBuilder) {
        stringBuilder.append("select bizinfo.username").append(" ");
    }

    public static void b(StringBuilder stringBuilder) {
        stringBuilder.append("select bizinfo.brandIconURL");
        stringBuilder.append(", bizinfo.type");
        stringBuilder.append(", bizinfo.status");
        stringBuilder.append(", bizinfo.enterpriseFather");
        stringBuilder.append(", bizinfo.brandFlag");
        stringBuilder.append(", bizinfo.extInfo");
        stringBuilder.append(", rcontact.username");
        stringBuilder.append(", rcontact.conRemark");
        stringBuilder.append(", rcontact.quanPin");
        stringBuilder.append(", rcontact.nickname");
        stringBuilder.append(", rcontact.alias");
        stringBuilder.append(", rcontact.type").append(" ");
    }

    public static void c(StringBuilder stringBuilder) {
        stringBuilder.append(" from rcontact, bizinfo");
        stringBuilder.append(" where rcontact.username").append(" = bizinfo.username");
        stringBuilder.append(" and (rcontact.verifyFlag").append(" & ").append(com.tencent.mm.storage.x.ciP()).append(") != 0 ");
        stringBuilder.append(" and (rcontact.type").append(" & 1) != 0 ");
    }

    public static void d(StringBuilder stringBuilder) {
        stringBuilder.append(" and bizinfo.type").append(" = 3 ");
    }

    public static void a(StringBuilder stringBuilder, String str) {
        stringBuilder.append(" and bizinfo.type").append(" = 3");
        stringBuilder.append(" and bizinfo.enterpriseFather").append(" = '").append(str).append("' ");
    }

    public static void a(StringBuilder stringBuilder, boolean z) {
        stringBuilder.append(" and (bizinfo.bitFlag").append(" & 1) ");
        stringBuilder.append(z ? "!=" : "==").append(" 0 ");
    }

    public static void b(StringBuilder stringBuilder, boolean z) {
        stringBuilder.append(" and (bizinfo.brandFlag").append(" & 1) ");
        stringBuilder.append(z ? "==" : "!=").append(" 0 ");
    }

    public static Cursor J(String str, int i) {
        StringBuilder stringBuilder = new StringBuilder();
        b(stringBuilder);
        c(stringBuilder);
        a(stringBuilder, str);
        a(stringBuilder, false);
        b(stringBuilder, true);
        stringBuilder.append(" and (bizinfo.acceptType").append(" & ").append(i).append(") > 0 ");
        stringBuilder.append(" order by ");
        stringBuilder.append(LO());
        x.i("MicroMsg.BizInfoStorage", "getEnterpriseChildOfAcceptType sql %s", stringBuilder.toString());
        return g.Dq().gRU.a(stringBuilder.toString(), null, 0);
    }

    public final Cursor jP(String str) {
        String str2;
        List<String> jQ = jQ(str);
        List arrayList = new ArrayList();
        for (String str22 : jQ) {
            if (!bi.oN(jN(str22).Lr())) {
                arrayList.add(str22);
            }
        }
        if (arrayList.size() <= 0) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        b(stringBuilder);
        c(stringBuilder);
        a(stringBuilder, str);
        b(stringBuilder, true);
        stringBuilder.append(" and (");
        for (int i = 0; i < arrayList.size(); i++) {
            str22 = (String) arrayList.get(i);
            if (i > 0) {
                stringBuilder.append(" or ");
            }
            stringBuilder.append("rcontact.username = '").append(str22).append("'");
        }
        stringBuilder.append(") order by ");
        stringBuilder.append(LP());
        x.i("MicroMsg.BizInfoStorage", "getEnterpriseChatConnector sql %s", stringBuilder.toString());
        return g.Dq().gRU.a(stringBuilder.toString(), null, 0);
    }

    public static List<String> LQ() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("select rcontact.username");
        stringBuilder.append(", bizinfo.enterpriseFather");
        stringBuilder.append(", bizinfo.bitFlag").append(" & 1");
        c(stringBuilder);
        d(stringBuilder);
        stringBuilder.append(" and (");
        stringBuilder.append(" (bizinfo.bitFlag").append(" & 1) != 0");
        stringBuilder.append(" or ");
        stringBuilder.append(" (bizinfo.acceptType").append(" & 128) > 0 ");
        stringBuilder.append(" and (bizinfo.brandFlag").append(" & 1) == 0) ");
        x.i("MicroMsg.BizInfoStorage", "getEnterpriseConnectorList sql %s", stringBuilder.toString());
        Cursor a = g.Dq().gRU.a(r0, null, 2);
        List<String> arrayList = new ArrayList();
        if (a == null) {
            return arrayList;
        }
        while (a.moveToNext()) {
            int i;
            if (a.getInt(2) > 0) {
                i = 1;
            } else {
                i = 0;
            }
            if (i != 0) {
                i = 0;
            } else {
                i = 1;
            }
            arrayList.add(a.getString(i));
        }
        a.close();
        return ((h) g.h(h.class)).Ff().cU(arrayList);
    }

    public static Cursor z(String str, boolean z) {
        StringBuilder stringBuilder = new StringBuilder();
        b(stringBuilder);
        c(stringBuilder);
        a(stringBuilder, str);
        b(stringBuilder, true);
        if (z) {
            a(stringBuilder, false);
        }
        stringBuilder.append(" order by ");
        stringBuilder.append(LP());
        x.i("MicroMsg.BizInfoStorage", "getEnterpriseEnableChild sql %s", stringBuilder.toString());
        return g.Dq().gRU.a(stringBuilder.toString(), null, 0);
    }

    public static List<String> jQ(String str) {
        List<String> list = null;
        StringBuilder stringBuilder = new StringBuilder();
        a(stringBuilder);
        c(stringBuilder);
        a(stringBuilder, str);
        x.i("MicroMsg.BizInfoStorage", "getEnterpriseChildNameList sql %s", stringBuilder.toString());
        Cursor a = g.Dq().gRU.a(r1, null, 2);
        if (a != null) {
            list = new ArrayList();
            while (a.moveToNext()) {
                list.add(a.getString(0));
            }
            a.close();
        }
        return list;
    }

    public static String jR(String str) {
        String string;
        if (bi.oN(str)) {
            x.w("MicroMsg.BizInfoStorage", "getBizChatBrandUserName userName is null");
            return null;
        } else if (hrh == null || !hrh.containsKey(str)) {
            StringBuilder stringBuilder = new StringBuilder();
            a(stringBuilder);
            c(stringBuilder);
            a(stringBuilder, str);
            a(stringBuilder, true);
            x.i("MicroMsg.BizInfoStorage", "getEnterpriseBizChatChild sql %s", stringBuilder.toString());
            Cursor a = g.Dq().gRU.a(string, null, 2);
            if (a == null) {
                return null;
            }
            if (a.moveToFirst()) {
                string = a.getString(0);
                hrh.put(str, string);
            } else {
                string = null;
            }
            a.close();
            return string;
        } else {
            string = (String) hrh.get(str);
            if (bi.oN(string) || !s.gH(string)) {
                return null;
            }
            return string;
        }
    }

    public static List<String> hv(int i) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("select bizinfo.username");
        stringBuilder.append(" from rcontact, bizinfo");
        stringBuilder.append(" where bizinfo.specialType").append(" = 1");
        stringBuilder.append(" and rcontact.username").append(" = bizinfo.username");
        stringBuilder.append(" and (rcontact.verifyFlag").append(" & ").append(com.tencent.mm.storage.x.ciP()).append(") != 0 ");
        stringBuilder.append(" and (rcontact.type").append(" & 1) != 0 ");
        x.i("MicroMsg.BizInfoStorage", "getSpecialInternalBizUsernames sql %s", stringBuilder.toString());
        List<String> arrayList = new ArrayList();
        Cursor a = g.Dq().gRU.a(r0, null, 2);
        int columnIndex = a.getColumnIndex("username");
        while (a.moveToNext()) {
            arrayList.add(a.getString(columnIndex));
        }
        a.close();
        return arrayList;
    }

    public static boolean jS(String str) {
        boolean z = false;
        if (!bi.oN(str) && f.kb(str)) {
            d jV = f.jV(str);
            if (!(jV.bK(false) == null || jV.bK(false).LM() == null || bi.oN(jV.Ls()))) {
                ak XR = ((h) g.h(h.class)).Fk().XR(jV.Ls());
                if (XR != null && XR.field_username.equals(str) && XR.field_unReadCount > 0) {
                    ((h) g.h(h.class)).Fk().XH(jV.Ls());
                }
            }
            Cursor Fn = ((h) g.h(h.class)).aZO().Fn(str);
            Fn.moveToFirst();
            while (!Fn.isAfterLast()) {
                cg auVar = new au();
                auVar.b(Fn);
                auVar.eR(4);
                x.d("MicroMsg.BizInfoStorage", "writeOpLog: msgSvrId = " + auVar.field_msgSvrId + " status = " + auVar.field_status);
                Fn.moveToNext();
                z = true;
            }
            Fn.close();
            if (z) {
                ((h) g.h(h.class)).Fk().XH(str);
                ((h) g.h(h.class)).aZO().Fl(str);
            }
        }
        return z;
    }

    public static void jT(String str) {
        if (!bi.oN(str) && f.kb(str)) {
            ((com.tencent.mm.plugin.notification.b.a) g.k(com.tencent.mm.plugin.notification.b.a.class)).getNotification().eq(str);
            ((com.tencent.mm.plugin.notification.b.a) g.k(com.tencent.mm.plugin.notification.b.a.class)).getNotification().uq();
        }
    }

    public static void jU(String str) {
        if (!bi.oN(str) && f.kb(str)) {
            ((com.tencent.mm.plugin.notification.b.a) g.k(com.tencent.mm.plugin.notification.b.a.class)).getNotification().eq("");
        }
    }
}
