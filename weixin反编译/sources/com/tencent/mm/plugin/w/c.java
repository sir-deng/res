package com.tencent.mm.plugin.w;

import android.database.Cursor;
import com.tencent.mm.a.p;
import com.tencent.mm.f.b.ak;
import com.tencent.mm.f.b.cg;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.backup.g.d;
import com.tencent.mm.plugin.backup.h.k;
import com.tencent.mm.plugin.backup.h.l;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PLong;
import com.tencent.mm.protocal.c.ew;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.y.as;
import java.io.File;
import java.util.Iterator;
import java.util.LinkedList;

public final class c {
    public boolean oKW = false;
    public com.tencent.mm.plugin.w.a.a oKX;

    public static class a {
        public String koz;

        public a(String str) {
            this.koz = str;
        }
    }

    public final void b(final LinkedList<a> linkedList, final long j) {
        e.d(new Runnable() {
            public final void run() {
                long Wy = bi.Wy();
                if (linkedList == null) {
                    x.e("MicroMsg.MsgSynchronizePack", "MsgSynchronizeSessionList is null.");
                    if (c.this.oKX != null) {
                        c.this.oKX.onCancel();
                        return;
                    }
                    return;
                }
                com.tencent.mm.a.e.g(new File(f.bcu()));
                com.tencent.mm.a.e.g(new File(f.bcv()));
                StringBuilder stringBuilder = new StringBuilder();
                as.Hm();
                com.tencent.mm.a.e.g(new File(stringBuilder.append(com.tencent.mm.y.c.FJ()).append("msgsynchronize/").toString()));
                stringBuilder = new StringBuilder();
                as.Hm();
                com.tencent.mm.a.e.g(new File(stringBuilder.append(com.tencent.mm.y.c.FJ()).append("msgsynchronize.zip").toString()));
                LinkedList linkedList = new LinkedList();
                String str = (String) d.aqL().aqM().Db().get(2, null);
                PInt pInt = new PInt();
                PInt pInt2 = new PInt();
                PLong pLong = new PLong();
                Iterator it = linkedList.iterator();
                while (it.hasNext()) {
                    a aVar = (a) it.next();
                    ak XF = d.aqL().aqM().Fk().XF(aVar.koz);
                    int i = XF != null ? XF.field_unReadCount : 0;
                    if (pInt2.value >= b.oKU) {
                        break;
                    }
                    k kVar = new k();
                    kVar.kyG = aVar.koz;
                    kVar.kyE = (int) (d.aqL().aqM().Fh().Fy(aVar.koz) / 1000);
                    kVar.kyF = i;
                    linkedList.add(kVar);
                    pInt2.value++;
                    if (pInt.value < b.oKS) {
                        c.this.a(aVar, str, i, pInt, pLong, j);
                    }
                    if (c.this.oKW) {
                        break;
                    }
                }
                if (c.this.oKW) {
                    x.e("MicroMsg.MsgSynchronizePack", "MsgSynchronizePack canceled!");
                    return;
                }
                l lVar = new l();
                lVar.kyH = linkedList;
                lVar.kyI = com.tencent.mm.be.l.TE().Ts();
                try {
                    f.d(f.bct(), "sessionlist", lVar.toByteArray());
                    x.i("MicroMsg.MsgSynchronizePack", "BackupSessionInfoList pack finish.");
                } catch (Exception e) {
                    x.e("MicroMsg.MsgSynchronizePack", "ERROR: BackupSessionInfoList to Buffer, list:%d :%s", Integer.valueOf(lVar.kyH.size()), e.getMessage());
                }
                p.a(new File(f.bcu()), false, f.bcv());
                x.i("MicroMsg.MsgSynchronizePack", "synchronize finish, backupCostTime[%d]", Long.valueOf(bi.bA(Wy)));
                long bN = (long) com.tencent.mm.a.e.bN(f.bcv());
                if (c.this.oKX != null) {
                    c.this.oKX.a(f.bcv(), linkedList.size(), str, pInt.value, pLong.value, bN / 1024);
                }
            }
        }, "msgSynchronizePackThread", 10).start();
    }

    public final boolean a(a aVar, String str, int i, PInt pInt, PLong pLong, long j) {
        as.Hm();
        if (com.tencent.mm.storage.x.DG(com.tencent.mm.y.c.Ff().Xv(aVar.koz).field_verifyFlag)) {
            return true;
        }
        x.i("MicroMsg.MsgSynchronizePack", "summerbak backupChatMsg convName:%s, unReadCount:%d", aVar.koz, Integer.valueOf(i));
        LinkedList linkedList = new LinkedList();
        LinkedList linkedList2 = new LinkedList();
        Cursor f = d.aqL().aqM().Fh().f(aVar.koz, b.oKT, ((h) g.h(h.class)).FQ().EY(aVar.koz));
        while (f.moveToNext()) {
            if (this.oKW) {
                f.close();
                return false;
            }
            cg auVar = new au();
            auVar.b(f);
            if ((j >= 0 && auVar.field_createTime >= j) || j < 0) {
                linkedList2.add(auVar);
            }
        }
        f.close();
        int i2 = 0;
        int i3 = i;
        while (i2 < linkedList2.size()) {
            Object a;
            int i4;
            try {
                a = com.tencent.mm.plugin.backup.e.h.a((au) linkedList2.get(i2), false, str, new PLong(), new LinkedList(), null, i3 > 0, true, 0);
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.MsgSynchronizePack", e, "backupChatMsg", new Object[0]);
                a = null;
            }
            if (a != null) {
                linkedList.add(a);
                pLong.value++;
                i4 = i3 - 1;
            } else {
                i4 = i3;
            }
            i2++;
            i3 = i4;
        }
        ew ewVar = new ew();
        ewVar.kyB = linkedList;
        ewVar.kyA = linkedList.size();
        try {
            f.d(f.bct(), "MSG_" + linkedList.size() + "_" + aVar.koz + "_" + bi.Wy(), ewVar.toByteArray());
            x.i("MicroMsg.MsgSynchronizePack", "add MsgSynchronize, tagTextClientId:%s", r4);
        } catch (Exception e2) {
            x.e("MicroMsg.MsgSynchronizePack", "ERROR: BakChatMsgList to Buffer list:%d :%s", Integer.valueOf(ewVar.kyA), e2.getMessage());
        }
        pInt.value++;
        return true;
    }
}
