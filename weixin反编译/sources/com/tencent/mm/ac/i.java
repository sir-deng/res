package com.tencent.mm.ac;

import android.database.Cursor;
import com.tencent.mm.a.f;
import com.tencent.mm.bx.h;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.List;
import junit.framework.Assert;

public final class i extends j {
    public static final String[] gLy = new String[]{"CREATE TABLE IF NOT EXISTS img_flag ( username VARCHAR(40) PRIMARY KEY , imgflag int , lastupdatetime int , reserved1 text ,reserved2 text ,reserved3 int ,reserved4 int )", "CREATE INDEX IF NOT EXISTS img_flag_small_url_index ON img_flag ( reserved2 )"};
    h hiZ;
    final f<String, h> hnl = new f(800);

    public i(h hVar) {
        this.hiZ = hVar;
    }

    public final h jp(String str) {
        h hVar = (h) this.hnl.get(str);
        if (hVar != null && hVar.getUsername().equals(str)) {
            return hVar;
        }
        Cursor a = this.hiZ.a("select img_flag.username,img_flag.imgflag,img_flag.lastupdatetime,img_flag.reserved1,img_flag.reserved2,img_flag.reserved3,img_flag.reserved4 from img_flag where img_flag.username=\"" + bi.oL(str) + "\"", null, 2);
        if (a == null) {
            return null;
        }
        if (a.moveToFirst()) {
            hVar = new h();
            hVar.b(a);
        } else {
            hVar = null;
        }
        a.close();
        this.hnl.l(str, hVar);
        return hVar;
    }

    public final boolean a(h hVar) {
        boolean z;
        x.i("MicroMsg.ImgFlagStorage", "new smallImageUrl = %s, bigImageUrl = %s", hVar.JN(), hVar.JM());
        if (jp(hVar.getUsername()) == null) {
            this.hnl.l(hVar.getUsername(), hVar);
            if (hVar == null || hVar.getUsername() == null) {
                z = false;
            } else {
                z = true;
            }
            Assert.assertTrue(z);
            hVar.hng = (int) (System.currentTimeMillis() / 1000);
            hVar.JO();
            hVar.fEo = -1;
            z = ((int) this.hiZ.insert("img_flag", "username", hVar.JL())) >= 0;
            if (z) {
                b(hVar.getUsername(), 2, hVar.getUsername());
            }
        } else {
            x.i("MicroMsg.ImgFlagStorage", "old, smallImageUrl = %s, bigImageUrl = %s", jp(hVar.getUsername()).JN(), jp(hVar.getUsername()).JM());
            this.hnl.remove(hVar.getUsername());
            z = (hVar == null || hVar.getUsername() == null) ? false : true;
            Assert.assertTrue(z);
            hVar.hng = (int) (System.currentTimeMillis() / 1000);
            hVar.fEo |= 4;
            z = this.hiZ.update("img_flag", hVar.JL(), "username=?", new String[]{new StringBuilder().append(hVar.getUsername()).toString()}) > 0;
            if (z) {
                b(hVar.getUsername(), 3, hVar.getUsername());
            }
        }
        return z;
    }

    public final boolean H(List<h> list) {
        if (list.size() == 0) {
            return false;
        }
        boolean z;
        long dA = this.hiZ.dA(Thread.currentThread().getId());
        int i = 0;
        while (i < list.size()) {
            try {
                a((h) list.get(i));
                i++;
            } catch (Exception e) {
                x.e("MicroMsg.ImgFlagStorage", e.getMessage());
                z = false;
            }
        }
        z = true;
        this.hiZ.fT(dA);
        return z;
    }

    public final void jq(String str) {
        if (!bi.oN(str)) {
            this.hnl.remove(str);
            this.hiZ.delete("img_flag", "username=?", new String[]{str});
        }
    }
}
