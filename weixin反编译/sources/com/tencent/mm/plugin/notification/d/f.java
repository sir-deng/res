package com.tencent.mm.plugin.notification.d;

import com.tencent.mm.bx.h.d;
import com.tencent.mm.f.a.cf;
import com.tencent.mm.f.a.fs;
import com.tencent.mm.f.a.kt;
import com.tencent.mm.f.a.ku;
import com.tencent.mm.f.a.nq;
import com.tencent.mm.f.a.nr;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.plugin.notification.a.a;
import com.tencent.mm.plugin.notification.c.c;
import com.tencent.mm.plugin.notification.ui.FailSendMsgNotification;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.y.ap;
import com.tencent.mm.y.as;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public final class f implements ap {
    private static f pai = null;
    c paj = null;
    c pak = null;
    private a pal = null;
    private boolean pam = false;
    private com.tencent.mm.sdk.b.c pan = new com.tencent.mm.sdk.b.c<nq>() {
        {
            this.xmG = nq.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            f.this.paj.bgU();
            return false;
        }
    };
    private com.tencent.mm.sdk.b.c pao = new com.tencent.mm.sdk.b.c<nr>() {
        {
            this.xmG = nr.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            f.this.pak.bgU();
            return false;
        }
    };
    private com.tencent.mm.sdk.b.c pap = new com.tencent.mm.sdk.b.c<kt>() {
        {
            this.xmG = kt.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            f.this.paj.bgX();
            return false;
        }
    };
    private com.tencent.mm.sdk.b.c paq = new com.tencent.mm.sdk.b.c<ku>() {
        {
            this.xmG = ku.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            f.this.pak.bgX();
            return false;
        }
    };
    private com.tencent.mm.sdk.b.c par = new com.tencent.mm.sdk.b.c<cf>() {
        {
            this.xmG = cf.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            f.this.paj.bgZ().dismiss();
            f.this.pak.bgZ().dismiss();
            x.i("MicroMsg.SubCoreNotification", "dismiss all fail msg notification");
            return false;
        }
    };
    private com.tencent.mm.sdk.b.c pas = new com.tencent.mm.sdk.b.c<fs>() {
        {
            this.xmG = fs.class.getName().hashCode();
        }

        public final /* bridge */ /* synthetic */ boolean a(b bVar) {
            f.this.pam = ((fs) bVar).fvW.fob;
            return false;
        }
    };

    private f() {
        b.init();
        if (this.pak == null) {
            this.pak = new e();
        }
        if (this.paj == null) {
            this.paj = new d();
        }
    }

    public static FailSendMsgNotification uD(int i) {
        if (i == 2 && bhn().pak != null) {
            x.d("MicroMsg.SubCoreNotification", "get sns notificaiton");
            return bhn().pak.bgZ();
        } else if (i != 1 || bhn().paj == null) {
            return null;
        } else {
            x.d("MicroMsg.SubCoreNotification", "get msg notificaiton");
            return bhn().paj.bgZ();
        }
    }

    public static f bhn() {
        if (pai == null) {
            pai = new f();
            as.Hg().a("plugin.notification", pai);
        }
        return pai;
    }

    public final HashMap<Integer, d> Bu() {
        return null;
    }

    public final void ge(int i) {
    }

    public final void bs(boolean z) {
        this.paj.bhi();
        this.paj.bhj();
        this.pak.bhi();
        this.pak.bhj();
        if (this.pal == null) {
            this.pal = new a();
        }
        Object obj = this.pal;
        if (as.Hp()) {
            x.d("MicroMsg.NotificationObserver", "added");
            try {
                as.Hm();
                com.tencent.mm.y.c.Fk().a(obj);
                obj.oZs = true;
            } catch (Throwable e) {
                x.e("MicroMsg.NotificationObserver", "exception:%s", bi.i(e));
            }
        } else {
            x.e("MicroMsg.NotificationObserver", "account not ready!");
        }
        com.tencent.mm.sdk.b.a.xmy.b(this.pan);
        com.tencent.mm.sdk.b.a.xmy.b(this.pao);
        com.tencent.mm.sdk.b.a.xmy.b(this.pap);
        com.tencent.mm.sdk.b.a.xmy.b(this.paq);
        com.tencent.mm.sdk.b.a.xmy.b(this.par);
        com.tencent.mm.sdk.b.a.xmy.b(this.pas);
        com.tencent.mm.j.f.zY();
        as.getNotification().fm(com.tencent.mm.j.f.Ab());
        as.getNotification().aX(false);
        x.d("MicroMsg.SubCoreNotification", "onAccountPostReset");
    }

    public final void bt(boolean z) {
    }

    public final void onAccountRelease() {
        this.paj.bhk();
        this.paj.bhl();
        this.pak.bhk();
        this.pak.bhl();
        if (this.pal != null) {
            m.b bVar = this.pal;
            if (as.Hp()) {
                try {
                    as.Hm();
                    com.tencent.mm.y.c.Fk().b(bVar);
                } catch (Throwable e) {
                    x.e("MicroMsg.NotificationObserver", "exception:%s", bi.i(e));
                }
            }
        }
        com.tencent.mm.sdk.b.a.xmy.c(this.pan);
        com.tencent.mm.sdk.b.a.xmy.c(this.pao);
        com.tencent.mm.sdk.b.a.xmy.c(this.pap);
        com.tencent.mm.sdk.b.a.xmy.c(this.paq);
        com.tencent.mm.sdk.b.a.xmy.c(this.par);
        com.tencent.mm.sdk.b.a.xmy.c(this.pas);
        as.getNotification().fm(0);
        as.getNotification().aX(true);
        x.d("MicroMsg.SubCoreNotification", "onAccountRelease");
    }

    public static boolean bho() {
        return bhn().pam;
    }

    public static ArrayList<Long> U(au auVar) {
        if (auVar == null) {
            return null;
        }
        as.Hm();
        com.tencent.mm.y.c.Fh().a(auVar.field_msgId, auVar);
        ArrayList aZV = ((h) g.h(h.class)).aZO().aZV();
        ArrayList<Long> arrayList = new ArrayList();
        Iterator it = aZV.iterator();
        while (it.hasNext()) {
            arrayList.add(Long.valueOf(((au) it.next()).field_msgId));
        }
        return arrayList;
    }
}
