package com.tencent.mm.plugin.wallet_core.model;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Vector;

public abstract class m<K> {
    Map<String, Integer> sTp = new HashMap();
    List<K> sTq = new LinkedList();
    public Vector<b> sTr = new Vector();
    List<String> sTs = new LinkedList();

    public enum a {
        ;

        static {
            sTu = 1;
            sTv = 2;
            sTw = 3;
            sTx = new int[]{sTu, sTv, sTw};
        }

        public static int[] bLW() {
            return (int[]) sTx.clone();
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_core.model.m$1 */
    static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] sTt = new int[a.bLW().length];

        static {
            try {
                sTt[a.sTw - 1] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                sTt[a.sTv - 1] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                sTt[a.sTu - 1] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    public class b {
        public K sTy;
        public int sTz;
    }

    public abstract String a(Vector<b> vector, int i);

    public final void d(List<K> list, List<K> list2, List<String> list3) {
        int i;
        this.sTs = list3;
        this.sTq = list2;
        this.sTr.clear();
        this.sTr = new Vector(list.size());
        for (i = 0; i < list.size(); i++) {
            b bVar = new b();
            Object obj = list.get(i);
            bVar.sTy = obj;
            if (this.sTq.contains(obj)) {
                bVar.sTz = a.sTv;
            } else {
                bVar.sTz = a.sTu;
            }
            this.sTr.add(bVar);
        }
        this.sTp.clear();
        for (i = 0; i < list3.size(); i++) {
            this.sTp.put(list3.get(i), Integer.valueOf(0));
        }
        bLV();
    }

    public final void ed(int i, int i2) {
        ((b) this.sTr.get(i)).sTz = i2;
    }

    public final void bLV() {
        for (int i = 0; i < this.sTr.size(); i++) {
            if (((b) this.sTr.get(i)).sTz != a.sTv) {
                String a = a(this.sTr, i);
                if (!this.sTp.containsKey(a)) {
                    Object obj;
                    String[] NO = com.tencent.mm.plugin.wallet_core.ui.a.NO(a);
                    for (int i2 = 0; i2 < this.sTs.size(); i2++) {
                        for (CharSequence contains : NO) {
                            if (!((String) this.sTs.get(i2)).contains(contains)) {
                                obj = null;
                                break;
                            }
                        }
                        int obj2 = 1;
                        if (obj2 != null) {
                            obj2 = 1;
                            break;
                        }
                    }
                    obj2 = null;
                    if (obj2 == null) {
                        ed(i, a.sTu);
                    }
                }
                ed(i, a.sTw);
            }
        }
    }
}
