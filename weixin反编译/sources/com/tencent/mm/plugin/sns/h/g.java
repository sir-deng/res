package com.tencent.mm.plugin.sns.h;

import com.tencent.mm.modelsns.b;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Iterator;
import java.util.Vector;

public abstract class g {
    private Vector<b> rjK = new Vector();

    public final b b(b bVar) {
        this.rjK.add(bVar);
        return bVar;
    }

    public final boolean c(b bVar) {
        boolean z;
        Iterator it = this.rjK.iterator();
        while (it.hasNext()) {
            b bVar2 = (b) it.next();
            if (bVar2.hQv == bVar.hQv) {
                this.rjK.remove(bVar2);
                z = true;
                break;
            }
        }
        z = false;
        this.rjK.add(bVar);
        return z;
    }

    public final b bL(Object obj) {
        if (obj == null) {
            return null;
        }
        try {
            Iterator it = this.rjK.iterator();
            while (it.hasNext()) {
                b bVar = (b) it.next();
                if (obj.equals(bVar.hQs)) {
                    this.rjK.remove(bVar);
                    return bVar;
                }
            }
        } catch (Exception e) {
            x.e("MicroMsg.Ss_log_base_helper", "report by key " + e.getMessage() + " " + obj);
        }
        return null;
    }
}
