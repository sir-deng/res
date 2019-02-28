package com.tencent.mm.bx;

import android.database.Cursor;
import com.tencent.mm.compatible.util.g.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

final class c {
    private static int index = 0;
    private static boolean on = false;
    private static a xJt = null;
    private static long xJu = 0;
    private static int xJv = 0;

    public static void i(Exception exception) {
        if (on) {
            x.e("MicroMsg.DKTest", "exception:%s", bi.i(exception));
        }
    }

    static void begin() {
        if (on) {
            xJt = new a();
            index++;
        }
    }

    private static void m(Cursor cursor) {
        if (on && cursor != null) {
            xJv = cursor.getCount();
            a aVar = new a();
            for (int i = 0; i < xJv; i++) {
                cursor.moveToPosition(i);
            }
            cursor.moveToPosition(-1);
            xJu = aVar.zp();
        }
    }

    static void a(String str, Cursor cursor, long j) {
        if (on) {
            String str2 = ("Thread:[" + Thread.currentThread().getId() + "," + Thread.currentThread().getName() + "]") + "[" + index + "][" + xJt.zp() + "]";
            if (j != 0) {
                str2 = str2 + "[INTRANS]";
            }
            if (cursor != null) {
                m(cursor);
                str2 = str2 + "[cuCnt:" + xJv + ",cuTime:" + xJu + "]";
            }
            str2 = str2 + "[" + str + "]--";
            x.v("MicroMsg.dbtest", str2 + bi.chl());
        }
    }
}
