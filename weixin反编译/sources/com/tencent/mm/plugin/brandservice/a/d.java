package com.tencent.mm.plugin.brandservice.a;

import android.database.Cursor;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.f.b.ag;
import com.tencent.mm.storage.x;
import com.tencent.mm.y.as;
import com.tencent.mm.y.c;
import com.tencent.mm.y.s;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class d implements e {
    public LinkedList<a> kKq = new LinkedList();
    public boolean kKr = false;
    public List<b> kKs = new LinkedList();
    public List<b> kKt = new LinkedList();

    public interface a {
        void asP();
    }

    public d() {
        as.CN().a(387, (e) this);
        as.CN().a(new f(), 0);
    }

    public final void init() {
        long currentTimeMillis = System.currentTimeMillis();
        this.kKs.clear();
        this.kKt.clear();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("select bizinfo.brandIconURL");
        stringBuilder.append(", bizinfo.type");
        stringBuilder.append(", bizinfo.status");
        stringBuilder.append(", rcontact.username");
        stringBuilder.append(", rcontact.conRemark");
        stringBuilder.append(", rcontact.nickname");
        stringBuilder.append(", rcontact.alias");
        stringBuilder.append(", rcontact.conRemarkPYFull");
        stringBuilder.append(", rcontact.conRemarkPYShort");
        stringBuilder.append(", rcontact.showHead");
        stringBuilder.append(", rcontact.pyInitial");
        stringBuilder.append(", rcontact.quanPin");
        stringBuilder.append(" from rcontact, bizinfo");
        stringBuilder.append(" where rcontact.username").append(" = bizinfo.username");
        stringBuilder.append(" and (rcontact.verifyFlag").append(" & ").append(x.ciP()).append(") != 0 ");
        stringBuilder.append(" and (rcontact.type").append(" & 1) != 0 ");
        stringBuilder.append(" order by showHead asc, ");
        stringBuilder.append(" case when length(conRemarkPYFull) > 0 then upper(conRemarkPYFull) ");
        stringBuilder.append(" else upper(quanPin) end asc, ");
        stringBuilder.append(" case when length(conRemark) > 0 then upper(conRemark) ");
        stringBuilder.append(" else upper(quanPin) end asc, ");
        stringBuilder.append(" upper(quanPin) asc, ");
        stringBuilder.append(" upper(nickname) asc");
        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.BrandService.BrandServiceMgr", "sql %s", stringBuilder.toString());
        as.Hm();
        Cursor a = c.Fc().a(r0, null, 2);
        Map hashMap = new HashMap();
        if (a != null) {
            int i = 0;
            while (a.moveToNext()) {
                i++;
                ag xVar = new x();
                xVar.b(a);
                com.tencent.mm.af.d dVar = new com.tencent.mm.af.d();
                dVar.b(a);
                if (!xVar.field_username.equals("gh_43f2581f6fd6")) {
                    b bVar = new b();
                    bVar.userName = xVar.field_username;
                    bVar.jQP = xVar;
                    bVar.kKo = dVar;
                    if (!s.gU(bVar.userName)) {
                        hashMap.put(bVar.userName, bVar);
                        if (bVar.kKo.field_type != 3) {
                            if (bVar.kKo.field_type == 2) {
                                this.kKs.add(bVar);
                            } else if (bVar.kKo.field_type == 1 || bVar.kKo.field_type == 0) {
                                this.kKt.add(bVar);
                            }
                        }
                    }
                }
            }
            com.tencent.mm.sdk.platformtools.x.d("MicroMsg.BrandService.BrandServiceMgr", "biz contact count %d", Integer.valueOf(i));
            a.close();
        }
        long currentTimeMillis2 = System.currentTimeMillis();
        stringBuilder = new StringBuilder();
        stringBuilder.append("select username");
        stringBuilder.append(" from rcontact");
        stringBuilder.append(" where (verifyFlag & ").append(x.ciP()).append(") != 0 ");
        stringBuilder.append(" and (type & 1").append(") != 0 ");
        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.BrandService.BrandServiceMgr", "sql check %s", stringBuilder.toString());
        as.Hm();
        Cursor a2 = c.Fc().a(r0, null, 0);
        if (a2 != null) {
            ArrayList arrayList = new ArrayList();
            while (a2.moveToNext()) {
                String string = a2.getString(0);
                if (!hashMap.containsKey(string)) {
                    arrayList.add(string);
                }
            }
            a2.close();
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.BrandService.BrandServiceMgr", "need update list size is %d, {%s}", Integer.valueOf(arrayList.size()), arrayList);
            if (!arrayList.isEmpty()) {
                as.Hm();
                long dA = c.Fc().dA(Thread.currentThread().getId());
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    com.tencent.mm.y.ak.a.hhv.Q((String) it.next(), "");
                }
                as.Hm();
                c.Fc().fT(dA);
            }
        }
        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.BrandService.BrandServiceMgr", "check use %d ms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis2));
        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.BrandService.BrandServiceMgr", "service add subscribe count:%d, enterpriseFather count:%d", Integer.valueOf(this.kKt.size()), Integer.valueOf(this.kKs.size()));
        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.BrandService.BrandServiceMgr", "init time: %d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
    }

    public final void a(int i, int i2, String str, k kVar) {
        int i3 = 0;
        com.tencent.mm.sdk.platformtools.x.w("MicroMsg.BrandService.BrandServiceMgr", "on scene end code(%d, %d)", Integer.valueOf(i), Integer.valueOf(i2));
        if (i == 0 && i2 == 0 && kVar.getType() == 387) {
            LinkedList linkedList = ((f) kVar).kKu;
            if (linkedList == null) {
                com.tencent.mm.sdk.platformtools.x.e("MicroMsg.BrandService.BrandServiceMgr", "nameList is null.");
            } else if (this.kKs == null || this.kKt == null) {
                com.tencent.mm.sdk.platformtools.x.e("MicroMsg.BrandService.BrandServiceMgr", "enterpriseItemList or subscribeAndServiceItemList is null.");
            } else {
                int i4;
                if (linkedList.size() != this.kKs.size() + this.kKt.size()) {
                    i4 = 1;
                } else {
                    for (b bVar : this.kKs) {
                        if (bVar != null) {
                            if (!linkedList.contains(bVar.userName)) {
                            }
                        }
                        i3 = 1;
                    }
                    if (i3 == 0) {
                        for (b bVar2 : this.kKt) {
                            if (bVar2 != null) {
                                if (!linkedList.contains(bVar2.userName)) {
                                }
                            }
                            i4 = 1;
                        }
                    }
                    i4 = i3;
                }
                if (i4 != 0) {
                    init();
                    Iterator it = this.kKq.iterator();
                    while (it.hasNext()) {
                        ((a) it.next()).asP();
                    }
                }
            }
        }
    }
}
