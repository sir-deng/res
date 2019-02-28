package com.tencent.mm.storage.emotion;

import android.database.Cursor;
import com.tencent.mm.bx.g;
import com.tencent.mm.bx.g.a;
import com.tencent.mm.protocal.c.ack;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class l extends i<k> implements a {
    public static final String[] gLy = new String[]{i.a(k.gKN, "EmotionRewardInfo")};
    public e gLA;

    public l(e eVar) {
        super(eVar, k.gKN, "EmotionRewardInfo", null);
        this.gLA = eVar;
    }

    public final int a(g gVar) {
        if (gVar != null) {
            this.gLA = gVar;
        }
        return 0;
    }

    public final ack YI(String str) {
        ack ack = null;
        if (bi.oN(str)) {
            x.w("MicroMsg.emoji.EmotionRewardInfoStorage", "getEmotionRewardResponseByPID failed. productID is null.");
        } else {
            String[] strArr = new String[]{"content"};
            String[] strArr2 = new String[]{str};
            Cursor a = this.gLA.a("EmotionRewardInfo", strArr, "productID=?", strArr2, null, null, null, 2);
            if (a != null && a.moveToFirst()) {
                try {
                    ack ack2 = new ack();
                    ack2.aH(a.getBlob(0));
                    ack = ack2;
                } catch (Throwable e) {
                    x.e("MicroMsg.emoji.EmotionRewardInfoStorage", "exception:%s", bi.i(e));
                }
            }
            if (a != null) {
                a.close();
            }
        }
        return ack;
    }
}
