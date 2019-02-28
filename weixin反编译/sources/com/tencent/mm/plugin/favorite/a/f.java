package com.tencent.mm.plugin.favorite.a;

import android.os.Looper;
import com.tencent.mm.plugin.favorite.h;
import com.tencent.mm.protocal.c.vx;
import com.tencent.mm.protocal.c.vy;
import com.tencent.mm.protocal.c.vz;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.as;
import com.tencent.mm.y.c;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public final class f {
    public HashMap<String, WeakReference<a>> hzv = new HashMap();
    public vz mvt = new vz();
    private HashSet<Integer> mvu = new HashSet();
    private boolean mvv = true;
    private List<vx> mvw = new LinkedList();

    public interface a {
        void aJf();

        void aJg();
    }

    public f() {
        as.Hm();
        try {
            this.mvt.aH(bi.Wj((String) c.Db().get(225283, (Object) "")));
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.FavTagSetMgr", e, "", new Object[0]);
            x.w("MicroMsg.FavTagSetMgr", "init tag info set fail, %s", e.getMessage());
            this.mvt = new vz();
        }
        x.i("MicroMsg.FavTagSetMgr", "tag:\n%s", this.mvt.wml);
    }

    public final void a(a aVar) {
        if (aVar != null) {
            this.hzv.put(aVar.toString(), new WeakReference(aVar));
        }
    }

    private void fa(boolean z) {
        for (WeakReference weakReference : this.hzv.values()) {
            if (!(weakReference == null || weakReference.get() == null)) {
                if (z) {
                    ((a) weakReference.get()).aJf();
                } else {
                    ((a) weakReference.get()).aJg();
                }
            }
        }
    }

    private void save() {
        byte[] toByteArray;
        try {
            toByteArray = this.mvt.toByteArray();
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.FavTagSetMgr", e, "", new Object[0]);
            x.w("MicroMsg.FavTagSetMgr", "save tag info set fail, %s", e.getMessage());
            toByteArray = null;
        }
        as.Dt().F(new Runnable() {
            public final void run() {
                String bA = bi.bA(toByteArray);
                as.Hm();
                c.Db().set(225283, bA);
            }

            public final String toString() {
                return super.toString() + "|save";
            }
        });
        this.mvv = true;
    }

    public final List<vx> qa(int i) {
        if (i < 0 || i > 1) {
            return null;
        }
        if (this.mvv) {
            x.w("MicroMsg.FavTagSetMgr", "want get tag list, it is dirty, reload data");
            this.mvw.clear();
            Iterator it = this.mvt.wml.iterator();
            while (it.hasNext()) {
                this.mvw.addAll(((vy) it.next()).wmk);
            }
            this.mvv = false;
        }
        x.i("MicroMsg.FavTagSetMgr", "want get tag list, tag list size is %d", Integer.valueOf(this.mvw.size()));
        return this.mvw;
    }

    public final int aJe() {
        int i = 0;
        Iterator it = this.mvt.wml.iterator();
        while (true) {
            int i2 = i;
            if (!it.hasNext()) {
                return i2;
            }
            i = ((vy) it.next()).wmk.size() + i2;
        }
    }

    public final void AC(final String str) {
        if (!bi.oN(str)) {
            if (this.mvu.contains(Integer.valueOf(str.hashCode()))) {
                x.d("MicroMsg.FavTagSetMgr", "has add tag %s", str);
                return;
            }
            this.mvu.add(Integer.valueOf(str.hashCode()));
            if (Looper.myLooper() != Looper.getMainLooper()) {
                x.d("MicroMsg.FavTagSetMgr", "add tag %s, post", str);
                ah.y(new Runnable() {
                    public final void run() {
                        f.this.AD(str);
                    }
                });
                return;
            }
            x.d("MicroMsg.FavTagSetMgr", "add tag %s", str);
            AD(str);
        }
    }

    final void AD(String str) {
        int i;
        vy vyVar;
        vy vyVar2;
        vx vxVar;
        int i2 = 0;
        String oD = com.tencent.mm.platformtools.c.oD(str.toLowerCase());
        if (oD == null || oD.length() <= 0) {
            i = 35;
        } else {
            i = oD.charAt(0);
        }
        Iterator it = this.mvt.wml.iterator();
        int i3 = 0;
        while (it.hasNext()) {
            vyVar = (vy) it.next();
            if (vyVar.wmj == i) {
                break;
            } else if (vyVar.wmj > i) {
                vyVar = new vy();
                vyVar.wmj = i;
                this.mvt.wml.add(i3, vyVar);
                break;
            } else {
                i3++;
            }
        }
        vyVar = null;
        if (vyVar == null) {
            vyVar = new vy();
            vyVar.wmj = i;
            this.mvt.wml.add(vyVar);
            vyVar2 = vyVar;
        } else {
            vyVar2 = vyVar;
        }
        Iterator it2 = vyVar2.wmk.iterator();
        while (it2.hasNext()) {
            int compareTo;
            vxVar = (vx) it2.next();
            i3 = vxVar.wmi.compareTo(oD);
            if (i3 == 0) {
                compareTo = vxVar.tIP.compareTo(str);
            } else {
                compareTo = i3;
            }
            if (compareTo != 0) {
                if (compareTo > 0) {
                    vxVar = new vx();
                    vxVar.tIP = str;
                    vxVar.wmi = oD;
                    vyVar2.wmk.add(i2, vxVar);
                    save();
                    fa(true);
                    return;
                }
                i2++;
            } else {
                return;
            }
        }
        vxVar = new vx();
        vxVar.tIP = str;
        vxVar.wmi = oD;
        vyVar2.wmk.add(vxVar);
        fa(true);
        save();
    }

    public final void l(com.tencent.mm.plugin.fav.a.f fVar) {
        if (fVar != null) {
            for (String removeTag : fVar.field_tagProto.wmn) {
                removeTag(removeTag);
            }
        }
    }

    public final void c(Set<String> set) {
        if (set != null && !set.isEmpty()) {
            x.d("MicroMsg.FavTagSetMgr", "do remove tags: %s", set);
            for (String removeTag : set) {
                removeTag(removeTag);
            }
        }
    }

    private void removeTag(final String str) {
        if (!bi.oN(str)) {
            this.mvu.remove(Integer.valueOf(str.hashCode()));
            if (Looper.myLooper() != Looper.getMainLooper()) {
                x.d("MicroMsg.FavTagSetMgr", "remove tag %s, post", str);
                ah.y(new Runnable() {
                    public final void run() {
                        f.this.AE(str);
                    }
                });
                return;
            }
            x.d("MicroMsg.FavTagSetMgr", "remove tag %s", str);
            AE(str);
        }
    }

    final void AE(String str) {
        char c;
        vy vyVar;
        String oD = com.tencent.mm.platformtools.c.oD(str.toLowerCase());
        if (oD == null || oD.length() <= 0) {
            c = '#';
        } else {
            c = oD.charAt(0);
        }
        Iterator it = this.mvt.wml.iterator();
        int i = 0;
        while (it.hasNext()) {
            vy vyVar2 = (vy) it.next();
            if (vyVar2.wmj == c) {
                vyVar = vyVar2;
                break;
            } else if (vyVar2.wmj <= c) {
                i++;
            } else {
                return;
            }
        }
        vyVar = null;
        if (vyVar != null) {
            Iterator it2 = vyVar.wmk.iterator();
            int i2 = 0;
            while (it2.hasNext()) {
                vx vxVar = (vx) it2.next();
                int compareTo = vxVar.wmi.compareTo(oD);
                if (compareTo == 0) {
                    compareTo = vxVar.tIP.compareTo(str);
                }
                if (compareTo == 0) {
                    if (!h.aJc().AA(vxVar.tIP)) {
                        vyVar.wmk.remove(i2);
                        if (vyVar.wmk.isEmpty()) {
                            this.mvt.wml.remove(i);
                        }
                        fa(false);
                        save();
                        return;
                    }
                    return;
                } else if (compareTo <= 0) {
                    i2++;
                } else {
                    return;
                }
            }
        }
    }
}
