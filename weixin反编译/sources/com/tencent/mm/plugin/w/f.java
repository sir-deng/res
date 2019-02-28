package com.tencent.mm.plugin.w;

import android.text.TextUtils;
import com.tencent.mm.a.e;
import com.tencent.mm.plugin.backup.a.g;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.as;
import com.tencent.mm.y.c;

public final class f {
    public static String bct() {
        StringBuilder stringBuilder = new StringBuilder();
        as.Hm();
        return stringBuilder.append(c.FI()).append("msgsynchronize/syncFile/").toString();
    }

    public static String bcu() {
        StringBuilder stringBuilder = new StringBuilder();
        as.Hm();
        return stringBuilder.append(c.FI()).append("msgsynchronize/").toString();
    }

    public static String bcv() {
        StringBuilder stringBuilder = new StringBuilder();
        as.Hm();
        return stringBuilder.append(c.FI()).append("msgsynchronize.zip").toString();
    }

    public static void d(String str, String str2, byte[] bArr) {
        if (TextUtils.isEmpty(str) || bArr == null) {
            x.e("MicroMsg.MsgSynchronizeUtil", "appendFile dir:%s fileName:%s ", str, str2);
            return;
        }
        int i = 3;
        while (true) {
            int i2 = i - 1;
            if (i > 0) {
                long vQ = g.vQ(str + str2);
                i = e.a(str, str2, bArr);
                long vQ2 = g.vQ(str + str2);
                if (i != 0 || vQ2 < ((long) bArr.length)) {
                    x.e("MicroMsg.MsgSynchronizeUtil", "appendFile retry:%d append:%d  old:%d  new:%d  data:%d", Integer.valueOf(i2), Integer.valueOf(i), Long.valueOf(vQ), Long.valueOf(vQ2), Integer.valueOf(bArr.length));
                    i = i2;
                } else {
                    x.d("MicroMsg.MsgSynchronizeUtil", "appendFile retry:%d append:%d  old:%d  new:%d  data:%d", Integer.valueOf(i2), Integer.valueOf(i), Long.valueOf(vQ), Long.valueOf(vQ2), Integer.valueOf(bArr.length));
                    return;
                }
            }
            return;
        }
    }
}
