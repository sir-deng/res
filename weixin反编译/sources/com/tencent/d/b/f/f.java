package com.tencent.d.b.f;

import android.util.SparseArray;
import com.tencent.d.a.c.c;
import com.tencent.d.b.a.e;

public class f {
    private static volatile f Amv = null;
    public static volatile SparseArray<d> Amw = null;
    public final Object Amx = new Object();

    /* renamed from: com.tencent.d.b.f.f$3 */
    class AnonymousClass3 implements Runnable {
        final /* synthetic */ int tCg;

        public AnonymousClass3(int i) {
            this.tCg = i;
        }

        public final void run() {
            synchronized (f.this.Amx) {
                d dVar = (d) f.Amw.get(this.tCg);
                if (!(dVar == null || !(dVar instanceof a) || ((a) dVar).isCancelled())) {
                    ((a) dVar).cGY();
                }
            }
        }
    }

    private f() {
        Amw = new SparseArray(5);
    }

    public static f cHb() {
        if (Amv != null) {
            return Amv;
        }
        f fVar;
        synchronized (f.class) {
            if (Amv == null) {
                Amv = new f();
            }
            fVar = Amv;
        }
        return fVar;
    }

    public final boolean a(final d dVar, e eVar) {
        if (dVar.cGZ()) {
            c.d("Soter.SoterTaskManager", "soter: prepare eat execute.", new Object[0]);
            return false;
        }
        int hashCode = dVar.hashCode();
        synchronized (this.Amx) {
            int i = 0;
            while (i < Amw.size()) {
                int keyAt = Amw.keyAt(i);
                if (Amw.get(keyAt) == null || !((d) Amw.get(keyAt)).getClass().getName().equals(dVar.getClass().getName())) {
                    i++;
                } else {
                    c.w("Soter.SoterTaskManager", "soter: already such type of task. abandon add task", new Object[0]);
                    eVar.errCode = 26;
                    eVar.foE = "add SOTER task to queue failed. check the logcat for further information";
                    dVar.b(eVar);
                    return false;
                }
            }
            Amw.put(hashCode, dVar);
            g.cHd().A(new Runnable() {
                public final void run() {
                    dVar.execute();
                }
            });
            return true;
        }
    }

    public final void cHc() {
        synchronized (this.Amx) {
            c.i("Soter.SoterTaskManager", "soter: request cancel all", new Object[0]);
            if (Amw.size() != 0) {
                for (int i = 0; i < Amw.size(); i++) {
                    final int keyAt = Amw.keyAt(i);
                    g.cHd().A(new Runnable() {
                        public final void run() {
                            synchronized (f.this.Amx) {
                                d dVar = (d) f.Amw.get(keyAt);
                                if (dVar != null) {
                                    dVar.cHa();
                                }
                            }
                        }
                    });
                }
            }
            Amw.clear();
        }
    }
}
