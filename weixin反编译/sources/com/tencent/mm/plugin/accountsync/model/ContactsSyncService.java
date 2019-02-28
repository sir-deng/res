package com.tencent.mm.plugin.accountsync.model;

import android.accounts.Account;
import android.app.Service;
import android.content.AbstractThreadedSyncAdapter;
import android.content.ContentProviderClient;
import android.content.Context;
import android.content.Intent;
import android.content.SyncResult;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Looper;
import com.jg.EType;
import com.jg.JgClassChecked;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.modelfriend.a.b;
import com.tencent.mm.modelfriend.aa;
import com.tencent.mm.modelfriend.m;
import com.tencent.mm.modelfriend.v;
import com.tencent.mm.plugin.appbrand.jsapi.map.d;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.as;
import com.tencent.mm.y.c;

@JgClassChecked(author = 20, fComment = "checked", lastDate = "20140422", reviewer = 20, vComment = {EType.SERVICESCHECK})
public class ContactsSyncService extends Service implements e {
    private static Account hOk;
    private a inu = null;
    private Looper inv;

    private class a extends AbstractThreadedSyncAdapter {
        private Context mContext;

        public a(Context context) {
            super(context, true);
            this.mContext = context;
            x.i("MicroMsg.ContactsSyncService", "ContactsSyncService SyncAdapterImpl construction");
        }

        public final void onPerformSync(Account account, Bundle bundle, String str, ContentProviderClient contentProviderClient, SyncResult syncResult) {
            x.i("MicroMsg.ContactsSyncService", "ContactsSyncService SyncAdapterImpl onPerformSync");
            if (as.Hp()) {
                try {
                    Looper.prepare();
                    ContactsSyncService.this.inv = Looper.myLooper();
                    ContactsSyncService.a(ContactsSyncService.this, account);
                    Looper.loop();
                    return;
                } catch (Exception e) {
                    ContactsSyncService.this.Xz();
                    x.e("MicroMsg.ContactsSyncService", "ContactsSyncService.onPerformSync error: " + e.getMessage());
                    return;
                }
            }
            x.e("MicroMsg.ContactsSyncService", "ContactsSyncService account not ready, ignore this sync");
        }
    }

    static /* synthetic */ void a(ContactsSyncService contactsSyncService, Account account) {
        hOk = account;
        if (!as.Ho() || as.Cz()) {
            contactsSyncService.Xz();
            x.e("MicroMsg.ContactsSyncService", "performSync error: no user login");
        } else if (m.NR()) {
            x.i("MicroMsg.ContactsSyncService", "performSync start");
            if (!com.tencent.mm.modelfriend.a.a(new b() {
                public final void bO(boolean z) {
                    x.i("MicroMsg.ContactsSyncService", "performSync end, succ:%b", Boolean.valueOf(z));
                    if (z) {
                        as.CN().a((int) d.CTRL_INDEX, ContactsSyncService.this);
                        System.currentTimeMillis();
                        as.CN().a(new aa(m.Oa(), m.NZ()), 0);
                        return;
                    }
                    ContactsSyncService.this.Xz();
                }
            })) {
                contactsSyncService.Xz();
                x.i("MicroMsg.ContactsSyncService", "performSync result false");
            }
        } else {
            x.e("MicroMsg.ContactsSyncService", "this user has not agreed to upload address book");
            contactsSyncService.Xz();
        }
    }

    public ContactsSyncService() {
        x.i("MicroMsg.ContactsSyncService", "ContactsSyncService construction");
    }

    public IBinder onBind(Intent intent) {
        IBinder iBinder = null;
        if (com.tencent.mm.pluginsdk.g.a.aZ(this, "android.permission.READ_CONTACTS")) {
            if (this.inu == null) {
                this.inu = new a(getApplicationContext());
            }
            iBinder = this.inu.getSyncAdapterBinder();
        } else {
            x.i("MicroMsg.ContactsSyncService", "ContactsSyncService onBind no permission");
        }
        x.i("MicroMsg.ContactsSyncService", "ContactsSyncService onBind ret[%s]", iBinder);
        return iBinder;
    }

    public final void a(int i, int i2, String str, k kVar) {
        x.i("MicroMsg.ContactsSyncService", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str + " type = " + kVar.getType());
        if (kVar.getType() == d.CTRL_INDEX) {
            as.CN().b((int) d.CTRL_INDEX, (e) this);
            x.i("MicroMsg.ContactsSyncService", "uploadcontact onSceneEnd: errType = " + i + ", errCode = " + i2);
            as.Hm();
            long longValue = ((Long) c.Db().get(327728, Long.valueOf(0))).longValue();
            long currentTimeMillis = System.currentTimeMillis();
            x.d("MicroMsg.ContactsSyncService", "getMFriend : curTime=" + currentTimeMillis + ", lastTime=" + longValue);
            if (i2 == 0 || currentTimeMillis - longValue >= 86400000) {
                as.Hm();
                c.Db().set(327728, Long.valueOf(currentTimeMillis));
                as.CN().a(32, (e) this);
                aa aaVar = (aa) kVar;
                as.CN().a(new v(aaVar.hyp, aaVar.hyq), 0);
            } else {
                Xz();
                x.e("MicroMsg.ContactsSyncService", "uploadmcontact list null, do not do getmfriend.");
                return;
            }
        }
        if (kVar.getType() == 32) {
            as.CN().b(32, (e) this);
            x.i("MicroMsg.ContactsSyncService", "getmfriend onSceneEnd: errType = " + i + ", errCode = " + i2);
            if (i == 0 && i2 == 0) {
                com.tencent.mm.sdk.f.e.b(new com.tencent.mm.modelsimple.b(this, hOk), "MMAccountManager_updateLocalContacts").start();
            }
            Xz();
        }
    }

    private void Xz() {
        if (this.inv != null) {
            this.inv.quit();
        }
    }

    public void onDestroy() {
        x.i("MicroMsg.ContactsSyncService", "contacts sync service destory");
        super.onDestroy();
    }
}
