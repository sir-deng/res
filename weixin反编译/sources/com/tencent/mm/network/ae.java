package com.tencent.mm.network;

import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;

public final class ae {
    private static ae icT = null;
    private HashMap<Integer, a> icU = new HashMap();

    public interface a {
        int Wf();
    }

    public static synchronized ae We() {
        ae aeVar;
        synchronized (ae.class) {
            if (icT == null) {
                icT = new ae();
            }
            aeVar = icT;
        }
        return aeVar;
    }

    public final synchronized int h(int i, byte[] bArr) {
        int i2;
        a aVar = (a) this.icU.get(Integer.valueOf(i));
        String str = "MicroMsg.PostPushEventHandler";
        String str2 = "postEvent event:%s cb:%s data:%s [%s]";
        Object[] objArr = new Object[4];
        objArr[0] = Integer.valueOf(i);
        objArr[1] = aVar;
        objArr[2] = Integer.valueOf(bArr == null ? -1 : bArr.length);
        objArr[3] = new aj();
        x.i(str, str2, objArr);
        if (aVar == null) {
            String str3 = "MicroMsg.PostPushEventHandler";
            str = "postEvent cb == null  event:%s cb:%s data:%s [%s]";
            Object[] objArr2 = new Object[4];
            objArr2[0] = Integer.valueOf(i);
            objArr2[1] = aVar;
            objArr2[2] = Integer.valueOf(bArr == null ? -1 : bArr.length);
            objArr2[3] = new aj();
            x.e(str3, str, objArr2);
            i2 = -3;
        } else {
            i2 = aVar.Wf();
        }
        return i2;
    }
}
