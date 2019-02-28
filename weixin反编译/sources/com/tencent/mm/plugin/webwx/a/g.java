package com.tencent.mm.plugin.webwx.a;

import android.app.Notification;
import android.app.Notification.Builder;
import android.app.PendingIntent;
import android.content.Intent;
import android.database.Cursor;
import android.media.RingtoneManager;
import com.tencent.mm.R;
import com.tencent.mm.ad.d;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.bx.h;
import com.tencent.mm.f.a.op;
import com.tencent.mm.f.b.cg;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.plugin.messenger.foundation.a.q;
import com.tencent.mm.plugin.webwx.ui.ExtDeviceWXLoginUI;
import com.tencent.mm.protocal.c.bx;
import com.tencent.mm.protocal.c.tz;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bj;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.ao;
import com.tencent.mm.y.ap;
import com.tencent.mm.y.as;
import com.tencent.mm.y.bq;
import com.tencent.mm.y.bt.a;
import com.tencent.mm.y.c;
import com.tencent.mm.y.s;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.util.HashMap;

public final class g implements ap {
    private a kAd = new a() {
        public final void a(d.a aVar) {
            String str = (String) bj.y(n.a(aVar.hoa.vNO), "sysmsg").get(".sysmsg.pushloginurl.url");
            if (bi.oN(str)) {
                x.e("MicroMsg.SubCoreWebWX.pushloginurl", "pushloginurl is null");
            }
            b opVar = new op();
            opVar.fHq.fHr = str;
            opVar.fHq.type = 1;
            com.tencent.mm.sdk.b.a.xmy.m(opVar);
            aVar.hoa.vNS = null;
        }
    };
    private f tUM = new f();
    private a tUN;
    private ao tUO = new ao() {
        public final void Hd() {
            as.Hm();
            if (c.Fa()) {
                g.bWf();
            }
        }
    };
    private com.tencent.mm.sdk.b.c tUP = new com.tencent.mm.sdk.b.c<op>() {
        {
            this.xmG = op.class.getName().hashCode();
        }

        private boolean a(final op opVar) {
            if (opVar != null && (opVar instanceof op)) {
                final k dVar = new d(opVar.fHq.fHr);
                as.CN().a(971, new e() {
                    public final void a(int i, int i2, String str, k kVar) {
                        CharSequence charSequence;
                        Intent intent;
                        Object charSequence2;
                        as.CN().b(971, (e) this);
                        tz tzVar = (tz) dVar.hGV.hnR.hnY;
                        x.d("MicroMsg.SubCoreWebWX", "errCode:%d,errMsg:%s", Integer.valueOf(i2), str);
                        if (i == 0 && i2 == 0) {
                            if (tzVar.wiG != null) {
                                Intent intent2 = new Intent();
                                intent2.putExtra("intent.key.login.url", opVar.fHq.fHr);
                                intent2.putExtra("intent.key.type", 0);
                                intent2.putExtra("intent.key.icon.type", tzVar.wiG.wiC);
                                intent2.putExtra("intent.key.ok.string", tzVar.wiG.wiQ);
                                intent2.putExtra("intent.key.cancel.string", tzVar.wiG.wiR);
                                intent2.putExtra("intent.key.title.string", tzVar.wiG.wiD);
                                intent2.putExtra("intent.key.content.string", tzVar.wiG.wiV);
                                intent2.putExtra("intent.key.login.client.version", tzVar.wiK);
                                intent2.putExtra("intent.key.function.control", tzVar.wiL);
                                String str2 = tzVar.wiG.wiD;
                                StringBuilder stringBuilder = new StringBuilder();
                                Cursor cursor = null;
                                try {
                                    as.Hm();
                                    cursor = c.Fk().a(s.hgU, null, com.tencent.mm.l.a.gKQ, true);
                                    if (cursor != null) {
                                        int count;
                                        if (cursor.getCount() < tzVar.wiG.wiS) {
                                            count = cursor.getCount();
                                        } else {
                                            count = tzVar.wiG.wiS;
                                        }
                                        int columnIndex = cursor.getColumnIndex("username");
                                        for (int i3 = 0; i3 < count; i3++) {
                                            if (cursor.moveToPosition(i3)) {
                                                stringBuilder.append(cursor.getString(columnIndex));
                                                if (i3 < count - 1) {
                                                    stringBuilder.append(",");
                                                }
                                            }
                                        }
                                    }
                                    intent2.putExtra("intent.key.ok.session.list", stringBuilder.toString());
                                    if (cursor != null) {
                                        cursor.close();
                                        charSequence2 = str2;
                                        intent = intent2;
                                    }
                                } catch (Throwable e) {
                                    x.printErrStackTrace("MicroMsg.SubCoreWebWX", e, "[oneliang]get session list error.", new Object[0]);
                                    if (cursor != null) {
                                        cursor.close();
                                        charSequence2 = str2;
                                        intent = intent2;
                                    }
                                } catch (Throwable th) {
                                    if (cursor != null) {
                                        cursor.close();
                                    }
                                }
                                charSequence2 = str2;
                                intent = intent2;
                            }
                            charSequence2 = null;
                            intent = null;
                        } else if (i2 == -1) {
                            if (tzVar.wiH != null) {
                                intent = new Intent();
                                intent.putExtra("intent.key.login.url", opVar.fHq.fHr);
                                intent.putExtra("intent.key.type", -1);
                                intent.putExtra("intent.key.title.string", tzVar.wiH.wiE);
                                intent.putExtra("intent.key.icon.type", tzVar.wiH.wiC);
                                intent.putExtra("intent.key.ok.string", tzVar.wiH.wiF);
                                intent.putExtra("intent.key.content.string", tzVar.wiH.wiD);
                                charSequence2 = tzVar.wiH.wiD;
                            }
                            charSequence2 = null;
                            intent = null;
                        } else {
                            if (i2 == -2 && tzVar.wiI != null) {
                                intent = new Intent();
                                intent.putExtra("intent.key.login.url", opVar.fHq.fHr);
                                intent.putExtra("intent.key.type", -2);
                                intent.putExtra("intent.key.title.string", tzVar.wiI.wiE);
                                intent.putExtra("intent.key.icon.type", tzVar.wiI.wiC);
                                intent.putExtra("intent.key.ok.string", tzVar.wiI.wiF);
                                intent.putExtra("intent.key.content.string", tzVar.wiI.wiD);
                                charSequence2 = tzVar.wiI.wiD;
                            }
                            charSequence2 = null;
                            intent = null;
                        }
                        if (intent != null) {
                            intent.setFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                            intent.setClass(ad.getContext(), ExtDeviceWXLoginUI.class);
                            ad.getContext().startActivity(intent);
                            Intent intent3 = new Intent(intent);
                            intent3.setFlags(67108864);
                            if (opVar.fHq.type == 1) {
                                Notification notification = new Builder(ad.getContext()).setTicker(null).setWhen(System.currentTimeMillis()).setContentTitle(ad.getContext().getString(R.l.app_name)).setContentText(charSequence2).setContentIntent(PendingIntent.getActivity(ad.getContext(), 0, intent3, 134217728)).getNotification();
                                notification.icon = com.tencent.mm.bk.a.bYI();
                                notification.flags |= 16;
                                notification.sound = RingtoneManager.getDefaultUri(2);
                                as.getNotification().notify(38, notification);
                            }
                        }
                    }
                });
                as.CN().a(dVar, 0);
            }
            return false;
        }
    };
    private q tUQ = new q<bx>() {
        public final /* synthetic */ void e(com.tencent.mm.bp.a aVar) {
            bx bxVar = (bx) aVar;
            if (bxVar.nlX != 51 && com.tencent.mm.y.q.FY().equals(bxVar.vNM.wRo)) {
                as.Hm();
                cg G = c.Fh().G(bxVar.vNN.wRo, bxVar.vNT);
                if (G.field_msgSvrId == 0) {
                    x.i("MicroMsg.SubCoreWebWX", "[MicroMsg.MultiTerminalSyncMgr] msg not exit, svrID:%d", Long.valueOf(bxVar.vNT));
                    return;
                }
                x.i("MicroMsg.SubCoreWebWX", "[MicroMsg.MultiTerminalSyncMgr] selfSend msg, svrID:%d, localId:%d", Long.valueOf(bxVar.vNT), Long.valueOf(G.field_msgId));
                g.bWe().bWg().fn(G.field_msgId);
            }
        }

        public final /* bridge */ /* synthetic */ void f(com.tencent.mm.bp.a aVar) {
        }
    };

    public static g bWe() {
        as.Hg();
        g gVar = (g) bq.ib("plugin.webwx");
        if (gVar != null) {
            return gVar;
        }
        Object gVar2 = new g();
        as.Hg().a("plugin.webwx", gVar2);
        return gVar2;
    }

    public final void onAccountRelease() {
        d.c.b(Integer.valueOf(51), this.tUM);
        as.getSysCmdMsgExtension().b("pushloginurl", this.kAd, true);
        as.Hm();
        c.b(this.tUO);
        com.tencent.mm.sdk.b.a.xmy.c(this.tUP);
        bWf();
        if (this.tUN != null) {
            e eVar = this.tUN;
            o.Ub().a((com.tencent.mm.modelvideo.s.a) eVar);
            com.tencent.mm.kernel.g.CN().b(221, eVar);
        }
        com.tencent.mm.plugin.messenger.foundation.a.s.a(this.tUQ);
    }

    public final HashMap<Integer, h.d> Bu() {
        return null;
    }

    public final void ge(int i) {
    }

    public final void bs(boolean z) {
        d.c.a(Integer.valueOf(51), this.tUM);
        as.getSysCmdMsgExtension().a("pushloginurl", this.kAd, true);
        as.Hm();
        c.a(this.tUO);
        com.tencent.mm.sdk.b.a.xmy.b(this.tUP);
        this.tUN = null;
        com.tencent.mm.plugin.messenger.foundation.a.s.a(5, this.tUQ);
    }

    public final void bt(boolean z) {
    }

    static void bWf() {
        as.getNotification().cancel(38);
    }

    public final a bWg() {
        com.tencent.mm.kernel.g.Do().CA();
        if (this.tUN == null) {
            this.tUN = new a();
        }
        return this.tUN;
    }
}
