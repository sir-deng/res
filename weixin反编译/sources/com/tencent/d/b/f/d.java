package com.tencent.d.b.f;

import com.tencent.d.a.c.c;
import com.tencent.d.b.a.b;
import com.tencent.d.b.a.e;

public abstract class d {
    boolean AlZ = false;
    public b Amm;

    abstract boolean cGZ();

    abstract void cHa();

    abstract void execute();

    final synchronized void b(final e eVar) {
        if (this.AlZ) {
            c.w("Soter.BaseSoterTask", "soter: warning: already removed the task!", new Object[0]);
        } else {
            f cHb = f.cHb();
            String str = "Soter.SoterTaskManager";
            String str2 = "soter: removing task: %d";
            Object[] objArr = new Object[1];
            objArr[0] = this != null ? Integer.valueOf(hashCode()) : "null";
            c.i(str, str2, objArr);
            if (this == null) {
                c.e("Soter.SoterTaskManager", "soter: task is null", new Object[0]);
            } else {
                synchronized (cHb.Amx) {
                    if (f.Amw.get(hashCode()) == null) {
                        c.i("Soter.SoterTaskManager", "soter: no such task: %d. maybe this task did not pass preExecute", Integer.valueOf(hashCode()));
                    } else {
                        f.Amw.remove(hashCode());
                    }
                }
            }
            g.cHd().y(new Runnable() {
                public final void run() {
                    d dVar = d.this;
                    e eVar = eVar;
                    if (dVar.Amm != null && !dVar.AlZ) {
                        dVar.Amm.a(eVar);
                        dVar.AlZ = true;
                    }
                }
            });
        }
    }
}
