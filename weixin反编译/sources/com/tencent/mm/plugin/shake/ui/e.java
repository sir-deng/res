package com.tencent.mm.plugin.shake.ui;

import android.database.Cursor;
import android.widget.ImageView;
import com.tencent.mm.ap.a.a.c.a;
import com.tencent.mm.ap.o;
import com.tencent.mm.plugin.shake.b.f;
import com.tencent.mm.plugin.shake.b.g;
import com.tencent.mm.plugin.shake.b.m;
import com.tencent.mm.sdk.platformtools.bi;
import java.util.ArrayList;
import java.util.List;

public final class e {
    public static void a(ImageView imageView, String str, int i, boolean z) {
        if (imageView != null) {
            imageView.setImageBitmap(null);
            if (!bi.oN(str)) {
                a aVar = new a();
                aVar.hFn = m.lx(str);
                aVar.hFl = true;
                aVar.hFI = true;
                aVar.hFJ = z;
                if (i != 0) {
                    aVar.hFE = i;
                }
                o.PG().a(str, imageView, aVar.PQ());
            }
        }
    }

    public static String btj() {
        g bsn = m.bsn();
        List<f> arrayList = new ArrayList();
        Cursor a = bsn.gLA.a("SELECT * FROM " + bsn.getTableName() + " where status != 1", null, 2);
        if (a != null) {
            while (a.moveToNext()) {
                f fVar = new f();
                fVar.b(a);
                arrayList.add(fVar);
            }
            a.close();
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (f fVar2 : arrayList) {
            stringBuilder.append(fVar2.field_reserved1);
            stringBuilder.append("|");
        }
        return stringBuilder.toString();
    }
}
