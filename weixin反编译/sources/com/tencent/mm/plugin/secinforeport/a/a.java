package com.tencent.mm.plugin.secinforeport.a;

import com.tencent.mm.protocal.c.arr;
import com.tencent.mm.sdk.platformtools.x;
import java.io.IOException;

public final class a {
    public static final int qlf = 1;
    private static b qlg = new b() {
        public final void a(int i, String str, int i2, byte[] bArr) {
            x.i("MicroMsg.ClipBordReport", "!! Dummy implementation !!");
        }
    };
    private static final /* synthetic */ int[] qlh = new int[]{qlf};

    public static void a(b bVar) {
        if (bVar != null) {
            qlg = bVar;
        }
    }

    public static void d(int i, String str, int i2) {
        x.v("MicroMsg.ClipBordReport", "report ClipboardOperation %d, %s, %d", Integer.valueOf(i), str, Integer.valueOf(i2));
        qlg.a(i, str, i2, null);
    }

    public static void s(int i, String str, String str2) {
        x.v("MicroMsg.ClipBordReport", "report reportMiniProgram %d, %d, %s, %s", Integer.valueOf(5), Integer.valueOf(i), str, str2);
        arr arr = new arr();
        arr.fGh = str;
        arr.wGi = str2;
        byte[] bArr = null;
        try {
            bArr = arr.toByteArray();
        } catch (IOException e) {
            x.w("MicroMsg.ClipBordReport", "getExtInfo exp %s", e.getMessage());
        }
        qlg.a(5, "", i, bArr);
    }
}
