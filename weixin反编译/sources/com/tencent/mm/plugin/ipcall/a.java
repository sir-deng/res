package com.tencent.mm.plugin.ipcall;

import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.f.a.ho;
import com.tencent.mm.plugin.ipcall.a.g.c;
import com.tencent.mm.plugin.ipcall.a.i;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.as;
import java.util.ArrayList;
import java.util.Iterator;

public final class a implements e {
    private static a nHD = null;
    private boolean hlc = false;
    private long nHA = -1;
    private long nHB = -1;
    private long nHC = -1;
    private long nHz = -1;

    static /* synthetic */ void a(a aVar) {
        x.d("MicroMsg.IPCallAddressBookUsernameUpdater", "updateUsernameAfterGetMFriend");
        aVar.nHB = System.currentTimeMillis();
        ArrayList aUN = i.aUk().aUN();
        if (aUN != null && aUN.size() > 0) {
            x.d("MicroMsg.IPCallAddressBookUsernameUpdater", "addressitemList.size: %d", Integer.valueOf(aUN.size()));
            long dA = i.aUk().dA(Thread.currentThread().getId());
            Iterator it = aUN.iterator();
            while (it.hasNext()) {
                c cVar = (c) it.next();
                String DG = com.tencent.mm.plugin.ipcall.b.a.DG(cVar.field_contactId);
                if (cVar.xrR > 0 && !bi.oN(DG)) {
                    x.d("MicroMsg.IPCallAddressBookUsernameUpdater", "update username for contactId: %s, newUsername: %s, oldUsername: %s", cVar.field_contactId, DG, cVar.field_wechatUsername);
                    if ((!bi.oN(cVar.field_wechatUsername) && !cVar.field_wechatUsername.equals(DG)) || bi.oN(cVar.field_wechatUsername)) {
                        cVar.field_wechatUsername = DG;
                        i.aUk().a(cVar.xrR, (com.tencent.mm.sdk.e.c) cVar);
                    }
                }
            }
            i.aUk().dB(dA);
        }
        aVar.nHC = System.currentTimeMillis();
        x.d("MicroMsg.IPCallAddressBookUsernameUpdater", "update username use %dms", Long.valueOf(aVar.nHC - aVar.nHB));
        aVar.hlc = false;
        aTv();
    }

    private a() {
    }

    public static a aTu() {
        if (nHD == null) {
            nHD = new a();
        }
        return nHD;
    }

    public final void Wj() {
        if (!com.tencent.mm.plugin.ipcall.b.a.NW()) {
            x.d("MicroMsg.IPCallAddressBookUsernameUpdater", "tryUpdate, can't sync addr book");
        }
        if (this.hlc) {
            x.d("MicroMsg.IPCallAddressBookUsernameUpdater", "tryUpdate, updating");
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        as.Hm();
        if (Math.abs(currentTimeMillis - ((Long) com.tencent.mm.y.c.Db().get(com.tencent.mm.storage.w.a.USERINFO_IPCALL_ADDRESS_GETMFRIEND_LASTUPDATE_TIME_LONG, Long.valueOf(0))).longValue()) >= 86400000) {
            this.hlc = true;
            this.nHz = -1;
            this.nHA = -1;
            this.nHB = -1;
            this.nHC = -1;
            as.CN().a(32, (e) this);
            com.tencent.mm.sdk.f.e.post(new Runnable() {
                public final void run() {
                    x.d("MicroMsg.IPCallAddressBookUsernameUpdater", "start GetMFriend");
                    b hoVar = new ho();
                    hoVar.fyL.scene = 2;
                    com.tencent.mm.sdk.b.a.xmy.m(hoVar);
                    a.this.nHz = System.currentTimeMillis();
                }
            }, "IPCallAddressBookUpdater_updateUsername");
            return;
        }
        x.d("MicroMsg.IPCallAddressBookUsernameUpdater", "tryUpdate, not reach time limit");
    }

    public final void a(int i, int i2, String str, k kVar) {
        x.d("MicroMsg.IPCallAddressBookUsernameUpdater", "onSceneEnd, errType: %d, errCode: %d, isUpdating: %b", Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(this.hlc));
        if (this.hlc) {
            as.CN().b(32, (e) this);
            this.nHA = System.currentTimeMillis();
            x.d("MicroMsg.IPCallAddressBookUsernameUpdater", "GetMFriend used %dms", Long.valueOf(this.nHA - this.nHz));
            if (i == 0 && i2 == 0) {
                com.tencent.mm.sdk.f.e.post(new Runnable() {
                    public final void run() {
                        a.a(a.this);
                    }
                }, "IPCallAddressBookUsernameUpdater_updateUsernameAfterGetMFriend");
                return;
            }
            x.d("MicroMsg.IPCallAddressBookUsernameUpdater", "GetMFriend failed");
            this.hlc = false;
            aTv();
        }
    }

    private static void aTv() {
        long currentTimeMillis = System.currentTimeMillis();
        as.Hm();
        com.tencent.mm.y.c.Db().a(com.tencent.mm.storage.w.a.USERINFO_IPCALL_ADDRESS_GETMFRIEND_LASTUPDATE_TIME_LONG, Long.valueOf(currentTimeMillis));
    }
}
