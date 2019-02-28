package com.tencent.mm.plugin.ipcall.a;

import android.database.Cursor;
import com.tencent.mm.f.a.ik;
import com.tencent.mm.plugin.ipcall.a.g.k;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.as;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public final class b {
    private static c nHV = new c<ik>() {
        {
            this.xmG = ik.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            if (((ik) bVar) instanceof ik) {
                e.post(new Runnable() {
                    public final void run() {
                        b.uc();
                    }
                }, "IPCall_SyncAddressBook");
            }
            return false;
        }
    };

    static /* synthetic */ void uc() {
        try {
            if (as.Hp()) {
                x.d("MicroMsg.IPCallAddressUpdater", "start updateAddressStorage");
                long currentTimeMillis = System.currentTimeMillis();
                com.tencent.mm.plugin.ipcall.a.g.b bVar = new com.tencent.mm.plugin.ipcall.a.g.b();
                ArrayList aUN = i.aUk().aUN();
                if (aUN != null && aUN.size() > 0) {
                    HashMap aUM = com.tencent.mm.plugin.ipcall.a.g.b.aUM();
                    if (aUM != null && aUM.size() >= 0) {
                        com.tencent.mm.plugin.ipcall.a.g.c cVar;
                        long dA = i.aUk().dA(Thread.currentThread().getId());
                        x.d("MicroMsg.IPCallAddressUpdater", "start delete not exist address");
                        x.d("MicroMsg.IPCallAddressUpdater", "oldItemList.size: %d", Integer.valueOf(aUN.size()));
                        Iterator it = aUN.iterator();
                        while (it.hasNext()) {
                            cVar = (com.tencent.mm.plugin.ipcall.a.g.c) it.next();
                            if (!aUM.containsKey(cVar.field_contactId)) {
                                long j = cVar.xrR;
                                i.aUk().delete(j);
                                x.d("MicroMsg.IPCallAddressUpdater", "updateDeleteAddressRecord, id: %d", Long.valueOf(j));
                                Cursor dC = i.aUl().dC(j);
                                if (dC != null) {
                                    try {
                                        if (dC.moveToFirst()) {
                                            while (!dC.isAfterLast()) {
                                                k kVar = new k();
                                                kVar.b(dC);
                                                kVar.field_addressId = -1;
                                                kVar.field_phoneType = -1;
                                                i.aUl().a(kVar);
                                                dC.moveToNext();
                                            }
                                        }
                                    } catch (Exception e) {
                                        x.e("MicroMsg.IPCallAddressUpdater", "updateDeleteAddressRecord error: %s", e.getMessage());
                                        if (dC != null) {
                                            dC.close();
                                        } else {
                                            continue;
                                        }
                                    } catch (Throwable th) {
                                        if (dC != null) {
                                            dC.close();
                                        }
                                    }
                                }
                                if (dC != null) {
                                    dC.close();
                                } else {
                                    continue;
                                }
                            }
                        }
                        x.d("MicroMsg.IPCallAddressUpdater", "start update or insert address");
                        for (com.tencent.mm.plugin.ipcall.a.g.c cVar2 : aUM.values()) {
                            com.tencent.mm.plugin.ipcall.a.g.c Di = i.aUk().Di(cVar2.field_contactId);
                            if (Di == null || Di.xrR == -1) {
                                i.aUk().b((com.tencent.mm.sdk.e.c) cVar2);
                            } else {
                                Object obj = (cVar2 != null && com.tencent.mm.plugin.ipcall.a.g.c.dc(Di.field_contactId, cVar2.field_contactId) && com.tencent.mm.plugin.ipcall.a.g.c.dc(Di.field_systemAddressBookUsername, cVar2.field_systemAddressBookUsername) && com.tencent.mm.plugin.ipcall.a.g.c.dc(Di.field_wechatUsername, cVar2.field_wechatUsername)) ? 1 : null;
                                if (obj == null) {
                                    i.aUk().a(Di.xrR, (com.tencent.mm.sdk.e.c) cVar2);
                                }
                            }
                        }
                        i.aUk().dB(dA);
                        x.d("MicroMsg.IPCallAddressUpdater", "updateAddressStorage, used %dms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                        return;
                    }
                    return;
                }
                return;
            }
            x.e("MicroMsg.IPCallAddressUpdater", "updateAddressStorage, acc not ready");
        } catch (Exception e2) {
            x.e("MicroMsg.IPCallAddressUpdater", "updateAddressStorage error:" + e2.getMessage());
        }
    }

    public static void init() {
        a.xmy.b(nHV);
    }

    public static void release() {
        a.xmy.c(nHV);
    }
}
