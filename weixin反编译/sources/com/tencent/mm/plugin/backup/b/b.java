package com.tencent.mm.plugin.backup.b;

import android.database.Cursor;
import com.tencent.mm.f.b.ak;
import com.tencent.mm.plugin.backup.a.g;
import com.tencent.mm.plugin.backup.e.h;
import com.tencent.mm.plugin.backup.g.d;
import com.tencent.mm.pointers.PLong;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.au;
import com.tencent.mm.y.as;
import com.tencent.mm.y.c;
import com.tencent.mm.y.s;
import java.util.LinkedList;

public final class b {
    public boolean koR = false;

    public interface b extends a {
        void a(LinkedList<com.tencent.mm.plugin.backup.a.f.b> linkedList, com.tencent.mm.plugin.backup.a.f.b bVar, int i);

        void x(LinkedList<com.tencent.mm.plugin.backup.a.f.b> linkedList);
    }

    /* renamed from: com.tencent.mm.plugin.backup.b.b$3 */
    class AnonymousClass3 implements Runnable {
        final /* synthetic */ b koV;
        final /* synthetic */ LinkedList koW;
        final /* synthetic */ com.tencent.mm.plugin.backup.a.f.b koX;
        final /* synthetic */ int koY;

        public AnonymousClass3(b bVar, LinkedList linkedList, com.tencent.mm.plugin.backup.a.f.b bVar2, int i) {
            this.koV = bVar;
            this.koW = linkedList;
            this.koX = bVar2;
            this.koY = i;
        }

        public final void run() {
            if (!b.this.koR && this.koV != null) {
                this.koV.a(this.koW, this.koX, this.koY);
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.backup.b.b$4 */
    class AnonymousClass4 implements Runnable {
        final /* synthetic */ b koV;
        final /* synthetic */ LinkedList koW;

        public AnonymousClass4(b bVar, LinkedList linkedList) {
            this.koV = bVar;
            this.koW = linkedList;
        }

        public final void run() {
            if (!b.this.koR && this.koV != null) {
                this.koV.x(this.koW);
            }
        }
    }

    public interface a {
        void w(LinkedList<com.tencent.mm.plugin.backup.a.f.b> linkedList);
    }

    public final void cancel() {
        x.i("MicroMsg.BackupCalculator", "cancel. stack:%s", bi.chl());
        this.koR = true;
    }

    public final void a(final a aVar) {
        x.i("MicroMsg.BackupCalculator", "calculateChooseConversation start");
        long Wy = bi.Wy();
        final LinkedList linkedList = new LinkedList();
        Cursor c = d.aqL().aqM().Fk().c(s.hgU, g.ape(), "*");
        if (c.getCount() == 0) {
            if (aVar != null) {
                ah.y(new Runnable() {
                    public final void run() {
                        if (aVar != null) {
                            aVar.w(linkedList);
                        }
                    }
                });
            }
            x.i("MicroMsg.BackupCalculator", "calculateChooseConversation empty conversation!");
            c.close();
            return;
        }
        c.moveToFirst();
        x.i("MicroMsg.BackupCalculator", "calculateChooseConversation count[%d]", Integer.valueOf(c.getCount()));
        while (!this.koR) {
            ak aeVar = new ae();
            aeVar.b(c);
            if (!bi.oN(aeVar.field_username)) {
                if (d.aqL().aqM().Fh().Fs(aeVar.field_username) <= 0) {
                    x.i("MicroMsg.BackupCalculator", "calculateChooseConversation empty conversation:%s", aeVar.field_username);
                } else {
                    as.Hm();
                    if (com.tencent.mm.storage.x.DG(c.Ff().Xv(aeVar.field_username).field_verifyFlag)) {
                        x.i("MicroMsg.BackupCalculator", "calculateChooseConversation Biz conv:%s, msgCount[%d]", aeVar.field_username, Integer.valueOf(r5));
                    } else {
                        com.tencent.mm.plugin.backup.a.f.b bVar = new com.tencent.mm.plugin.backup.a.f.b();
                        bVar.koB = aeVar.field_username;
                        bVar.koC = d.aqL().aqM().Fh().Fx(aeVar.field_username);
                        bVar.koD = d.aqL().aqM().Fh().Fy(aeVar.field_username);
                        x.i("MicroMsg.BackupCalculator", "calculateChooseConversation add conv:%s, msgCount[%d], firstMsgTime[%d], lastMsgTime[%d]", bVar.koB, Integer.valueOf(r5), Long.valueOf(bVar.koC), Long.valueOf(bVar.koD));
                        linkedList.add(bVar);
                    }
                }
            }
            if (!c.moveToNext()) {
                c.close();
                if (!(this.koR || aVar == null)) {
                    ah.y(new Runnable() {
                        public final void run() {
                            if (!b.this.koR && aVar != null) {
                                aVar.w(linkedList);
                            }
                        }
                    });
                }
                x.i("MicroMsg.BackupCalculator", "calculateChooseConversation finish, use time[%d]", Long.valueOf(bi.bA(Wy)));
                return;
            }
        }
        x.e("MicroMsg.BackupCalculator", "calculateChooseConversation cancel.");
        c.close();
    }

    public final boolean a(com.tencent.mm.plugin.backup.a.f.b bVar, String str, long j) {
        if (bVar == null) {
            return false;
        }
        Cursor Fm = d.aqL().aqM().Fh().Fm(bVar.koB);
        x.i("MicroMsg.BackupCalculator", "calConversation start convName:%s msgCnt:%d[cu.getCount]", bVar.koB, Integer.valueOf(Fm.getCount()));
        if (Fm.moveToFirst()) {
            PLong pLong = new PLong();
            PLong pLong2 = new PLong();
            while (!Fm.isAfterLast()) {
                if (this.koR) {
                    x.i("MicroMsg.BackupCalculator", "calConversation cancel, return");
                    Fm.close();
                    return true;
                }
                au auVar = new au();
                auVar.b(Fm);
                try {
                    h.a(auVar, true, str, pLong, null, null, false, false, j);
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.BackupCalculator", e, "packedMsg", new Object[0]);
                }
                pLong2.value++;
                Fm.moveToNext();
            }
            bVar.koE = pLong.value;
            bVar.koF = pLong2.value;
            x.i("MicroMsg.BackupCalculator", "calConversation convName:%s, convDataSize:%d, convMsgCount:%d", bVar.koB, Long.valueOf(bVar.koE), Long.valueOf(bVar.koF));
        }
        Fm.close();
        return false;
    }
}
