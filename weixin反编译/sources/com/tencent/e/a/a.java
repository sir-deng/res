package com.tencent.e.a;

import com.tencent.e.d;
import com.tencent.e.e;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class a {
    public HashMap<String, Object> AvX = new HashMap();
    public Object AvY = new Object();
    c AvZ;

    public final void a(d dVar, String[] strArr) {
        if (dVar != null && strArr != null) {
            synchronized (this.AvY) {
                for (Object obj : strArr) {
                    if (obj != null) {
                        Object obj2 = this.AvX.get(obj);
                        if (obj2 == null) {
                            this.AvX.put(obj, dVar);
                        } else if (obj2 instanceof d) {
                            d dVar2 = (d) obj2;
                            if (dVar2 == dVar) {
                                return;
                            }
                            LinkedList linkedList = new LinkedList();
                            linkedList.add(dVar2);
                            linkedList.add(dVar);
                            this.AvX.put(obj, linkedList);
                        } else if (obj2 instanceof List) {
                            LinkedList linkedList2 = (LinkedList) obj2;
                            if (linkedList2.indexOf(dVar) >= 0) {
                                return;
                            }
                            linkedList2.add(dVar);
                        } else {
                            continue;
                        }
                    }
                }
            }
        }
    }

    public final void c(String str, int i, Object obj) {
        LinkedList linkedList = null;
        d dVar = this.AvZ;
        e cIk = dVar.cIk();
        if (cIk == null) {
            cIk = dVar.cIj();
        } else {
            cIk.reset();
        }
        e eVar = (e) cIk;
        eVar.fBH = str;
        eVar.Awb = i;
        eVar.arg1 = 0;
        eVar.arg2 = 0;
        eVar.obj = obj;
        if (eVar != null && eVar.fBH != null) {
            d dVar2;
            System.currentTimeMillis();
            String str2 = eVar.fBH;
            synchronized (this.AvY) {
                Object obj2 = this.AvX.get(str2);
                if (obj2 != null) {
                    if (obj2 instanceof d) {
                        dVar2 = (d) obj2;
                    } else if (obj2 instanceof List) {
                        linkedList = (LinkedList) ((LinkedList) obj2).clone();
                        obj2 = null;
                    }
                }
                dVar2 = null;
            }
            if (dVar2 != null) {
                dVar2.dM(str2, eVar.Awb);
            }
            if (linkedList != null) {
                Iterator it = linkedList.iterator();
                while (it.hasNext()) {
                    ((d) it.next()).dM(str2, eVar.Awb);
                }
            }
            dVar = this.AvZ;
            synchronized (dVar.mLock) {
                if (dVar.qAu < dVar.AvJ.length) {
                    dVar.AvJ[dVar.qAu] = eVar;
                    dVar.qAu++;
                }
            }
        }
    }
}
