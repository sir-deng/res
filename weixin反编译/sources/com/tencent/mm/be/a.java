package com.tencent.mm.be;

import android.database.Cursor;
import com.tencent.mm.f.b.cg;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.au.d;
import com.tencent.mm.y.as;
import com.tencent.mm.y.c;
import java.util.ArrayList;

public final class a {
    public static ArrayList<String> mT(String str) {
        ArrayList<String> arrayList = new ArrayList();
        h[] V = l.TF().V(str, 10);
        if (V != null) {
            for (h hVar : V) {
                arrayList.add(hVar.field_sayhicontent);
            }
        }
        x.d("MicroMsg.ExposeDataLogic", "get lbs sayhi msg content");
        return arrayList;
    }

    public static ArrayList<String> mU(String str) {
        ArrayList<String> arrayList = new ArrayList();
        j[] W = l.TG().W(str, 10);
        if (W != null) {
            for (j jVar : W) {
                arrayList.add(jVar.field_sayhicontent);
            }
        }
        x.d("MicroMsg.ExposeDataLogic", "get shake sayhi msg content");
        return arrayList;
    }

    public static ArrayList<String> mV(String str) {
        ArrayList<String> arrayList = new ArrayList();
        as.Hm();
        Cursor Fm = c.Fh().Fm(str);
        if (!(Fm == null || Fm.getCount() == 0)) {
            if (Fm.moveToFirst()) {
                int i = 0;
                while (!Fm.isAfterLast()) {
                    cg auVar = new au();
                    auVar.b(Fm);
                    Fm.moveToNext();
                    if (auVar.cjV()) {
                        arrayList.add(auVar.field_content);
                    } else {
                        arrayList.add("");
                    }
                    i++;
                    if (i == 10) {
                        break;
                    }
                }
            }
            Fm.close();
        }
        return arrayList;
    }

    public static ArrayList<String> x(int i, String str) {
        ArrayList<String> arrayList = new ArrayList();
        f[] U = l.TD().U(str, 10);
        if (U != null) {
            for (f fVar : U) {
                if (fVar.field_type == 1) {
                    arrayList.add(bi.oM(d.Yb(fVar.field_msgContent).content));
                }
            }
        }
        x.d("MicroMsg.ExposeDataLogic", "getFMessageContent,scene:%d", Integer.valueOf(i));
        return arrayList;
    }

    public static ArrayList<au> b(long[] jArr) {
        ArrayList<au> arrayList = new ArrayList();
        if (jArr != null) {
            for (long dI : jArr) {
                as.Hm();
                arrayList.add(c.Fh().dI(dI));
            }
        }
        return arrayList;
    }
}
