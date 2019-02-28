package com.tencent.mm.plugin.appbrand.appusage;

import android.database.Cursor;
import com.tencent.mm.ad.k;
import com.tencent.mm.bx.h;
import com.tencent.mm.f.b.m;
import com.tencent.mm.plugin.appbrand.config.q;
import com.tencent.mm.protocal.c.brh;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.bi;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Locale;

public final class l extends j {
    public static final String[] iHj = new String[]{i.a(a.iHk, "AppBrandStarApp")};
    public final h iIR;
    public final c iMR;
    public volatile int iMS = 10;

    /* renamed from: com.tencent.mm.plugin.appbrand.appusage.l$1 */
    class AnonymousClass1 implements com.tencent.mm.ad.u.a {
        final /* synthetic */ String gKE;
        final /* synthetic */ int iMT;
        final /* synthetic */ long iMU;

        public AnonymousClass1(String str, int i, long j) {
            this.gKE = str;
            this.iMT = i;
            this.iMU = j;
        }

        public final int a(int i, int i2, String str, com.tencent.mm.ad.b bVar, k kVar) {
            if (!(i == 0 && i2 == 0 && ((brh) bVar.hnR.hnY).wcE.lUc == 0) && l.this.iIR.isOpen()) {
                com.tencent.mm.sdk.e.c aVar = new a();
                aVar.field_username = this.gKE;
                aVar.field_versionType = this.iMT;
                aVar.field_updateTime = this.iMU;
                l.this.iMR.a(aVar, false, "updateTime", "username", "versionType");
                if (!l.this.ao(this.gKE, this.iMT)) {
                    l.this.b("single", 3, aVar);
                }
            }
            return 0;
        }
    }

    static final class a extends m {
        static final String[] iHh = new String[]{"username", "versionType"};
        static final com.tencent.mm.sdk.e.c.a iHk;

        protected final com.tencent.mm.sdk.e.c.a Aj() {
            return iHk;
        }

        static {
            int i = 0;
            com.tencent.mm.sdk.e.c.a aVar = new com.tencent.mm.sdk.e.c.a();
            aVar.hUM = new Field[3];
            aVar.columns = new String[4];
            StringBuilder stringBuilder = new StringBuilder();
            aVar.columns[0] = "username";
            aVar.xrT.put("username", "TEXT");
            stringBuilder.append(" username TEXT");
            stringBuilder.append(", ");
            aVar.columns[1] = "versionType";
            aVar.xrT.put("versionType", "INTEGER");
            stringBuilder.append(" versionType INTEGER");
            stringBuilder.append(", ");
            aVar.columns[2] = "updateTime";
            aVar.xrT.put("updateTime", "LONG");
            stringBuilder.append(" updateTime LONG");
            aVar.columns[3] = "rowid";
            aVar.xrU = stringBuilder.toString();
            iHk = aVar;
            String str = " PRIMARY KEY ( ";
            String[] strArr = iHh;
            int length = strArr.length;
            while (i < length) {
                str = str + ", " + strArr[i];
                i++;
            }
            String str2 = str.replaceFirst(",", "") + " )";
            StringBuilder stringBuilder2 = new StringBuilder();
            com.tencent.mm.sdk.e.c.a aVar2 = iHk;
            aVar2.xrU = stringBuilder2.append(aVar2.xrU).append(",").append(str2).toString();
        }
    }

    private static final class c extends i<a> {
        c(h hVar) {
            super(hVar, a.iHk, "AppBrandStarApp", a.fNF);
        }
    }

    public enum b {
        ;

        static {
            iMX = 1;
            iMY = 2;
            iMZ = new int[]{iMX, iMY};
        }
    }

    public l(h hVar) {
        this.iIR = hVar;
        this.iMR = new c(hVar);
    }

    public final void c(com.tencent.mm.sdk.e.j.a aVar) {
        a(aVar, com.tencent.mm.plugin.appbrand.r.c.Dt().oFY.getLooper());
    }

    public final b<ArrayList> jI(int i) {
        b<ArrayList> bVar = null;
        if (i == 0) {
            i = b.iMX;
        }
        Cursor query = this.iIR.query("AppBrandStarApp", new String[]{"username", "versionType"}, null, null, null, null, String.format(Locale.US, "%s desc limit %d offset 0", new Object[]{"updateTime", Integer.valueOf(this.iMS)}));
        if (query != null) {
            if (b.iMY == i) {
                query.close();
            } else {
                query.close();
            }
            Collection linkedList = new LinkedList();
            a aVar = new a();
            while (true) {
                aVar.b(query);
                linkedList.add(q.a(String.format(Locale.US, "$%s$%d@starapp", new Object[]{aVar.field_username, Integer.valueOf(aVar.field_versionType)}), aVar.field_username, aVar.field_versionType, -1));
                if (b.iMY == i) {
                    if (!query.moveToPrevious()) {
                        break;
                    }
                } else if (!query.moveToNext()) {
                    break;
                }
            }
            bVar = new ArrayList(linkedList.size());
            bVar.addAll(linkedList);
            query.close();
        }
        return bVar;
    }

    public final boolean ao(String str, int i) {
        Cursor cursor = null;
        if (!bi.oN(str)) {
            cursor = this.iIR.query("AppBrandStarApp", null, String.format(Locale.US, "%s=? and %s=?", new Object[]{"username", "versionType"}), new String[]{str, String.valueOf(i)}, null, null, null);
        }
        if (cursor == null) {
            return false;
        }
        boolean moveToFirst = cursor.moveToFirst();
        cursor.close();
        return moveToFirst;
    }

    public final boolean h(final String str, final int i, boolean z) {
        if (bi.oN(str)) {
            return false;
        }
        boolean z2;
        s sVar;
        final com.tencent.mm.sdk.e.c aVar = new a();
        aVar.field_username = str;
        aVar.field_versionType = i;
        if (this.iMR.b(aVar, "versionType", "username")) {
            this.iMR.a(aVar, false, a.iHh);
            if (ao(str, i)) {
                z2 = false;
                if (z2 && z) {
                    sVar = new s(1003, false, i, 1, 2, str, 1, null);
                    sVar.iNq = new com.tencent.mm.ad.u.a() {
                        public final int a(int i, int i2, String str, com.tencent.mm.ad.b bVar, k kVar) {
                            if (!(i == 0 && i2 == 0 && ((brh) bVar.hnR.hnY).wcE.lUc == 0) && l.this.iIR.isOpen()) {
                                l.this.iMR.a(aVar, false);
                                if (l.this.ao(str, i)) {
                                    l.this.b("single", 2, aVar);
                                }
                            }
                            return 0;
                        }
                    };
                    sVar.Kb();
                }
                return z2;
            }
            b("single", 5, aVar);
        }
        z2 = true;
        sVar = new s(1003, false, i, 1, 2, str, 1, null);
        sVar.iNq = /* anonymous class already generated */;
        sVar.Kb();
        return z2;
    }
}
