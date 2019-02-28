package com.tencent.mm.storage;

import android.database.Cursor;
import com.tencent.mm.plugin.messenger.foundation.a.a.g;
import com.tencent.mm.plugin.messenger.foundation.a.a.g.a;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.e.k;
import com.tencent.mm.sdk.platformtools.x;
import junit.framework.Assert;

public final class bg extends i<bf> implements g {
    public static final String[] gLy = new String[]{i.a(bf.gKN, "Stranger")};
    private e gLA;
    private final k<a, bf> xIl = new k<a, bf>() {
        protected final /* synthetic */ void p(Object obj, Object obj2) {
            ((a) obj).a((bf) obj2);
        }
    };

    public final /* synthetic */ boolean a(c cVar) {
        int i;
        bf bfVar = (bf) cVar;
        Assert.assertTrue("stranger NULL !", bfVar != null);
        x.d("MicroMsg.StrangerStorage", "replace : encryptUsername=%s, conRemark=%s", bfVar.field_encryptUsername, bfVar.field_conRemark);
        if (this.gLA.replace("Stranger", "", bfVar.vP()) > 0) {
            i = 1;
        } else {
            boolean i2 = false;
        }
        if (i2 == 0) {
            return false;
        }
        b(bfVar);
        return true;
    }

    private void b(bf bfVar) {
        if (this.xIl.cb(bfVar)) {
            this.xIl.doNotify();
        }
    }

    public final void a(a aVar) {
        this.xIl.a(aVar, null);
    }

    public final void b(a aVar) {
        this.xIl.remove(aVar);
    }

    public bg(e eVar) {
        super(eVar, bf.gKN, "Stranger", null);
        this.gLA = eVar;
    }

    public final bf FF(String str) {
        if (str == null || str.length() <= 0) {
            return null;
        }
        bf bfVar = new bf();
        Cursor a = this.gLA.a("Stranger", null, "encryptUsername = ?", new String[]{str}, null, null, null, 2);
        if (a.moveToFirst()) {
            bfVar.b(a);
        }
        a.close();
        return bfVar;
    }

    public final int FG(String str) {
        int delete = this.gLA.delete("Stranger", "(encryptUsername=?)", new String[]{str});
        if (delete > 0) {
            doNotify();
        }
        x.i("MicroMsg.StrangerStorage", "delByEncryptUsername:" + str + " result:" + delete);
        return delete;
    }
}
