package com.tencent.mm.ac;

import android.database.Cursor;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.List;

public final class m {
    private static List<String> hnu = null;
    private static int hnv = 0;
    private static a hnw = new a(new b());

    static class b implements com.tencent.mm.sdk.platformtools.al.a {
        Runnable hny;

        b() {
        }

        public final boolean uG() {
            int size = m.hnu.size();
            x.e("MicroMsg.RemoveAvatarTask", "RemoveOldAvatar left count:" + size);
            if (size <= MMBitmapFactory.ERROR_IMG_BUG_DETECTED_BEGIN || m.hnv >= 300) {
                if (this.hny != null) {
                    this.hny.run();
                }
                m.hnv = 0;
                return false;
            }
            long dA = g.Dq().gRU.dA(Thread.currentThread().getId());
            int i = size - 1;
            while (true) {
                int i2 = i;
                if (i2 >= size - 30) {
                    m.JU();
                    String str = (String) m.hnu.get(i2);
                    m.hnu.remove(i2);
                    n.JF();
                    d.y(str, false);
                    n.JF();
                    d.y(str, true);
                    n.JW().jq(str);
                    i = i2 - 1;
                } else {
                    g.Dq().gRU.fT(dA);
                    return true;
                }
            }
        }
    }

    static class a extends al {
        final b hnx;

        public a(b bVar) {
            super(bVar, true);
            this.hnx = bVar;
        }
    }

    static /* synthetic */ int JU() {
        int i = hnv;
        hnv = i + 1;
        return i;
    }

    public static void j(Runnable runnable) {
        if (g.Do().CF()) {
            i JW = n.JW();
            List arrayList = new ArrayList();
            Cursor a = JW.hiZ.a("select username from img_flag where username not in (select username from rcontact ) and username not like \"%@qqim\" and username not like \"%@bottle\";", null, 2);
            while (a.moveToNext()) {
                arrayList.add(a.getString(0));
            }
            a.close();
            hnu = arrayList;
            if (arrayList.size() > 0) {
                hnw.hnx.hny = runnable;
                hnw.K(10, 10);
            }
        }
    }

    public static void JQ() {
        hnv = 0;
        hnw.TN();
    }
}
