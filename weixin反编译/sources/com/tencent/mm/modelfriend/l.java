package com.tencent.mm.modelfriend;

import com.tencent.mm.bx.h;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.x;
import java.util.List;

public final class l extends j {
    public static final String[] gLy = new String[]{"CREATE TABLE IF NOT EXISTS friend_ext ( username text  PRIMARY KEY , sex int  , personalcard int  , province text  , city text  , signature text  , reserved1 text  , reserved2 text  , reserved3 text  , reserved4 text  , reserved5 int  , reserved6 int  , reserved7 int  , reserved8 int  ) "};
    public h hiZ;

    public l(h hVar) {
        this.hiZ = hVar;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a(com.tencent.mm.modelfriend.k r9) {
        /*
        r8 = this;
        r6 = -1;
        r0 = 1;
        r1 = 0;
        r2 = r9.getUsername();
        r3 = new java.lang.StringBuilder;
        r4 = "select friend_ext.username,friend_ext.sex,friend_ext.personalcard,friend_ext.province,friend_ext.city,friend_ext.signature from friend_ext   where friend_ext.username = \"";
        r3.<init>(r4);
        r2 = com.tencent.mm.sdk.platformtools.bi.oL(r2);
        r2 = r3.append(r2);
        r3 = "\"";
        r2 = r2.append(r3);
        r2 = r2.toString();
        r3 = r8.hiZ;
        r4 = 0;
        r5 = 2;
        r2 = r3.a(r2, r4, r5);
        r3 = r2.moveToFirst();
        r2.close();
        if (r3 == 0) goto L_0x005a;
    L_0x0033:
        if (r9 == 0) goto L_0x0058;
    L_0x0035:
        r2 = r9.vP();
        r3 = r2.size();
        if (r3 <= 0) goto L_0x0073;
    L_0x003f:
        r3 = r8.hiZ;
        r4 = "friend_ext";
        r5 = "username=?";
        r6 = new java.lang.String[r0];
        r7 = "username";
        r6[r1] = r7;
        r2 = r3.update(r4, r2, r5, r6);
    L_0x0052:
        if (r2 <= 0) goto L_0x0058;
    L_0x0054:
        r8.doNotify();
        return r0;
    L_0x0058:
        r0 = r1;
        goto L_0x0054;
    L_0x005a:
        if (r9 == 0) goto L_0x0071;
    L_0x005c:
        r9.fEo = r6;
        r2 = r9.vP();
        r3 = r8.hiZ;
        r4 = "friend_ext";
        r5 = "username";
        r2 = r3.insert(r4, r5, r2);
        r2 = (int) r2;
        if (r2 != r6) goto L_0x0054;
    L_0x0071:
        r0 = r1;
        goto L_0x0054;
    L_0x0073:
        r2 = r1;
        goto L_0x0052;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.modelfriend.l.a(com.tencent.mm.modelfriend.k):boolean");
    }

    public final boolean H(List<k> list) {
        if (list.size() <= 0) {
            return false;
        }
        boolean z;
        bg bgVar = new bg("MicroMsg.FriendExtStorage", "batchSetFriendExt transaction");
        bgVar.addSplit("transation begin");
        long dA = this.hiZ.dA(Thread.currentThread().getId());
        int i = 0;
        while (i < list.size()) {
            try {
                k kVar = (k) list.get(i);
                if (kVar != null) {
                    a(kVar);
                }
                i++;
            } catch (Exception e) {
                x.e("MicroMsg.FriendExtStorage", e.getMessage());
                z = false;
            }
        }
        z = true;
        this.hiZ.fT(dA);
        bgVar.addSplit("transation end");
        bgVar.dumpToLog();
        doNotify();
        return z;
    }
}
