package com.tencent.mm.plugin.label;

import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.f.b.ag;
import com.tencent.mm.plugin.label.b.d;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.btc;
import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ac;
import com.tencent.mm.storage.z;
import com.tencent.mm.y.as;
import com.tencent.mm.y.c;
import com.tencent.mm.y.q;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public final class b implements com.tencent.mm.plugin.label.a.b {
    ArrayList<String> nUd;
    ArrayList<String> nUe;
    private e nUf = new e() {
        public final void a(int i, int i2, String str, k kVar) {
            x.e("MicroMsg.Label.ContactLabelManagerImpl", "onSceneEnd");
            switch (kVar.getType()) {
                case 635:
                    if (i == 0 && i2 == 0) {
                        b.g(b.this.username, b.this.nUd);
                        return;
                    }
                    b.this.aVz();
                    x.e("MicroMsg.Label.ContactLabelManagerImpl", "add contact lable faild");
                    return;
                case 638:
                    if (i == 0 && i2 == 0) {
                        int i3;
                        int i4;
                        if (b.this.nUe == null || b.this.nUe.isEmpty()) {
                            i3 = 0;
                        } else {
                            i3 = b.this.nUe.size();
                        }
                        if (b.this.nUd == null || b.this.nUd.isEmpty()) {
                            i4 = 0;
                        } else {
                            i4 = b.this.nUd.size() - i3;
                        }
                        if (i3 > 0 || i4 > 0) {
                            x.d("MicroMsg.Label.ContactLabelManagerImpl", "cpan[saveContact]addLabelNum:%d,updateLabelNum:%d", Integer.valueOf(i3), Integer.valueOf(i4));
                            g.pWK.h(11220, q.FY(), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(0));
                        }
                    }
                    b.this.aVz();
                    return;
                default:
                    return;
            }
        }
    };
    String username;

    public final /* synthetic */ List DW(String str) {
        if (bi.oN(str)) {
            x.d("MicroMsg.Label.ContactLabelManagerImpl", "cpan[getLabelStrList]");
            return null;
        }
        if (str.endsWith("\u0000")) {
            str = str.replace("\u0000", "");
        }
        return e.aVC().H(str.split(","));
    }

    public final /* synthetic */ List DX(String str) {
        return e.aVC().Xl(str);
    }

    public final /* synthetic */ List aVA() {
        return e.aVC().ciU();
    }

    public final void aVx() {
        e.aVC().aVx();
    }

    public final String DT(String str) {
        return e.aVC().DT(str);
    }

    public final String DU(String str) {
        return e.aVC().DU(str);
    }

    public final void a(a aVar) {
        e.aVC().c(aVar);
    }

    public final void b(a aVar) {
        e.aVC().j(aVar);
    }

    public final List<String> aVy() {
        ac aVC = e.aVC();
        long Wy = bi.Wy();
        ArrayList ciV = aVC.ciV();
        if (ciV == null) {
            return null;
        }
        aVC.ciW();
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < ciV.size(); i++) {
            ArrayList arrayList2 = (ArrayList) aVC.xGs.get(Integer.valueOf(((z) ciV.get(i)).field_labelID));
            if (arrayList2 != null && arrayList2.size() > 0) {
                arrayList.add(((z) ciV.get(i)).field_labelName);
            }
        }
        x.i("MicroMsg.Label.ContactLabelStorage", "getAllLabelHasContact time:%s all:%s hascontact:%s stack:%s", Long.valueOf(bi.bA(Wy)), Integer.valueOf(ciV.size()), Integer.valueOf(arrayList.size()), bi.chl());
        return arrayList;
    }

    public final List<String> DV(String str) {
        if (bi.oN(str)) {
            x.w("MicroMsg.Label.ContactLabelManagerImpl", "labels is null.");
            return null;
        }
        String[] split = str.split(",");
        if (split == null || split.length <= 0) {
            return null;
        }
        List<String> arrayList = new ArrayList();
        arrayList.addAll(Arrays.asList(split));
        return arrayList;
    }

    public final String aY(List<String> list) {
        if (list == null || list.isEmpty()) {
            x.w("MicroMsg.Label.ContactLabelManagerImpl", "labelList is empty");
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            stringBuilder.append((String) list.get(i));
            if (i < size - 1) {
                stringBuilder.append(",");
            }
        }
        return stringBuilder.toString();
    }

    public final synchronized void di(String str, String str2) {
        x.i("MicroMsg.Label.ContactLabelManagerImpl", "cpan[saveStrangerLabel] user:%s labels:%s", str, str2);
        if (bi.oN(str2)) {
            x.w("MicroMsg.Label.ContactLabelManagerImpl", "cpan[saveStrangerLabel] labels is null.");
        } else {
            ArrayList arrayList = (ArrayList) DV(str2);
            if (arrayList == null || arrayList.isEmpty()) {
                x.w("MicroMsg.Label.ContactLabelManagerImpl", "cpan[saveStrangerLabel] labelList is null.");
            } else {
                this.username = str;
                this.nUd = arrayList;
                int size = arrayList.size();
                this.nUe = new ArrayList();
                for (int i = 0; i < size; i++) {
                    z Xm = e.aVC().Xm((String) arrayList.get(i));
                    if (Xm != null && Xm.field_isTemporary) {
                        this.nUe.add(arrayList.get(i));
                    }
                }
                as.CN().a(635, this.nUf);
                as.CN().a(638, this.nUf);
                if (this.nUe == null || this.nUe.isEmpty()) {
                    g(str, arrayList);
                    aVz();
                } else {
                    x.i("MicroMsg.Label.ContactLabelManagerImpl", "cpan[saveStrangerLabel]addList:%s", this.nUe.toString());
                    as.CN().a(new com.tencent.mm.plugin.label.b.a(this.nUe), 0);
                }
            }
        }
    }

    final void aVz() {
        this.username = null;
        this.nUd = null;
        this.nUe = null;
        as.CN().b(635, this.nUf);
        as.CN().b(638, this.nUf);
    }

    static void g(String str, ArrayList<String> arrayList) {
        String str2 = "MicroMsg.Label.ContactLabelManagerImpl";
        String str3 = "cpan[saveContact] username:%s,list:%s";
        Object[] objArr = new Object[2];
        objArr[0] = str;
        objArr[1] = arrayList == null ? "" : arrayList.toString();
        x.d(str2, str3, objArr);
        if (bi.oN(str) || arrayList == null || arrayList.size() <= 0) {
            x.e("MicroMsg.Label.ContactLabelManagerImpl", "add contact label faild.");
            return;
        }
        String str4 = "";
        if (arrayList != null && arrayList.size() > 0) {
            str4 = c.ba(e.aVC().ae(arrayList));
        }
        LinkedList linkedList = new LinkedList();
        btc btc = new btc();
        btc.wfP = str4;
        btc.kyG = str;
        linkedList.add(btc);
        as.CN().a(new d(linkedList), 0);
    }

    public final void aZ(List<String> list) {
        as.CN().a(new com.tencent.mm.plugin.label.b.a((List) list), 0);
    }

    public final void h(List<String> list, List<String> list2) {
        String str;
        String str2;
        Map hashMap = new HashMap();
        LinkedList linkedList = new LinkedList();
        if (list.size() > 0) {
            Iterator it = list2.iterator();
            for (String str22 : list) {
                List<String> F = bi.F(((String) it.next()).split(","));
                if (F != null && F.size() > 0) {
                    for (String str3 : F) {
                        String str4;
                        String dj;
                        if (hashMap.containsKey(str3)) {
                            str4 = (String) hashMap.get(str3);
                            dj = c.dj(str4, str22);
                            if (!dj.equalsIgnoreCase(str4)) {
                                hashMap.put(str3, dj);
                            }
                        } else {
                            as.Hm();
                            ag Xv = c.Ff().Xv(str3);
                            if (Xv != null) {
                                str4 = Xv.field_contactLabelIds;
                                dj = c.dj(str4, str22);
                                if (!dj.equalsIgnoreCase(str4)) {
                                    hashMap.put(str3, dj);
                                }
                            }
                        }
                    }
                }
            }
        }
        for (Entry entry : hashMap.entrySet()) {
            str3 = (String) entry.getKey();
            str22 = (String) entry.getValue();
            btc btc = new btc();
            btc.kyG = str3;
            btc.wfP = str22;
            linkedList.add(btc);
        }
        if (linkedList.size() > 0) {
            as.CN().a(new d(linkedList), 0);
        }
    }
}
