package com.tencent.mm.plugin.notification.d;

import android.content.Intent;
import android.os.Build.VERSION;
import com.tencent.mm.R;
import com.tencent.mm.f.a.ns;
import com.tencent.mm.f.a.ou;
import com.tencent.mm.f.a.ow;
import com.tencent.mm.f.b.cg;
import com.tencent.mm.plugin.notification.c.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.x;
import com.tencent.mm.y.as;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.util.ArrayList;

public final class d extends a<au> {
    private c oZU = new c<ou>() {
        {
            this.xmG = ou.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            final ou ouVar = (ou) bVar;
            ah.y(new Runnable() {
                public final void run() {
                    cg cgVar = ouVar.fHF.fou;
                    if (d.Hs(cgVar.field_talker)) {
                        d.this.bC(cgVar);
                    }
                }
            });
            return false;
        }
    };
    private c oZV = new c<ow>() {
        {
            this.xmG = ow.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            final ow owVar = (ow) bVar;
            ah.y(new Runnable() {
                public final void run() {
                    cg cgVar = owVar.fHH.fou;
                    if (d.Hs(cgVar.field_talker)) {
                        d.this.bD(cgVar);
                    }
                }
            });
            return false;
        }
    };

    static /* synthetic */ boolean Hs(String str) {
        return !(x.Xd(str) || x.Xf(str)) || x.gB(str);
    }

    protected final /* bridge */ /* synthetic */ long bE(Object obj) {
        return ((au) obj).field_msgId;
    }

    protected final /* synthetic */ ArrayList bF(Object obj) {
        return f.U((au) obj);
    }

    public final void bhi() {
        com.tencent.mm.sdk.b.a.xmy.b(this.oZU);
    }

    public final void bhj() {
        com.tencent.mm.sdk.b.a.xmy.b(this.oZV);
    }

    public final void dU(final long j) {
        as.Hm();
        final au dI = com.tencent.mm.y.c.Fh().dI(j);
        ah.y(new Runnable() {
            public final void run() {
                com.tencent.mm.sdk.platformtools.x.d("MicroMsg.SendNormalMsgFailNotificaiton", "resend msgId:%d", Long.valueOf(j));
                b nsVar = new ns();
                nsVar.fGB.fou = dI;
                com.tencent.mm.sdk.b.a.xmy.m(nsVar);
            }
        });
    }

    public final void bhk() {
        com.tencent.mm.sdk.b.a.xmy.c(this.oZU);
    }

    public final void bhl() {
        com.tencent.mm.sdk.b.a.xmy.c(this.oZV);
    }

    protected final void bhd() {
        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.SendNormalMsgFailNotificaiton", "onNotificationClick, mMsgList.size:%d", Integer.valueOf(this.oZD.oZO.size()));
        if (this.oZD.oZO.size() > 1) {
            Intent intent = new Intent();
            intent.addFlags(67108864);
            intent.addFlags(SQLiteDatabase.ENABLE_WRITE_AHEAD_LOGGING);
            if (VERSION.SDK_INT < 16) {
                intent.putExtra("resend_fail_messages", true);
            }
            intent.putExtra("From_fail_notify", true);
            com.tencent.mm.sdk.platformtools.x.d("MicroMsg.SendNormalMsgFailNotificaiton", "startMainUI");
            com.tencent.mm.bl.d.a(this.mContext, "com.tencent.mm.ui.LauncherUI", intent);
        } else if (this.oZD.oZO.size() == 1) {
            long j = this.oZD.get(0);
            as.Hm();
            String str = com.tencent.mm.y.c.Fh().dI(j).field_talker;
            Intent intent2 = new Intent();
            intent2.putExtra("Main_User", str);
            intent2.putExtra("From_fail_notify", true);
            intent2.addFlags(67108864);
            intent2.addFlags(SQLiteDatabase.ENABLE_WRITE_AHEAD_LOGGING);
            if (VERSION.SDK_INT < 16) {
                intent2.putExtra("resend_fail_messages", true);
            }
            com.tencent.mm.bl.d.a(this.mContext, "com.tencent.mm.ui.LauncherUI", intent2);
        }
    }

    protected final int getType() {
        return 1;
    }

    protected final void K(ArrayList<Long> arrayList) {
        as.Hm();
        com.tencent.mm.y.c.Fh().G(arrayList);
    }

    protected final String uA(int i) {
        return this.mContext.getString(R.l.eyH, new Object[]{Integer.valueOf(i)});
    }

    protected final String dd(int i, int i2) {
        return this.mContext.getString(R.l.ezn, new Object[]{Integer.valueOf(i2), Integer.valueOf(i)});
    }

    protected final String U(int i, int i2, int i3) {
        return this.mContext.getString(R.l.ezo, new Object[]{Integer.valueOf(i2), Integer.valueOf(i), Integer.valueOf(i3)});
    }

    protected final String de(int i, int i2) {
        if (i2 <= 0) {
            return this.mContext.getString(R.l.ezl, new Object[]{Integer.valueOf(i)});
        }
        return this.mContext.getString(R.l.ezk, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
    }

    public final boolean dV(long j) {
        as.Hm();
        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.SendNormalMsgFailNotificaiton", "checkMsgIfExist, msgId:%d, msg.getMsgId:%d", Long.valueOf(j), Long.valueOf(com.tencent.mm.y.c.Fh().dI(j).field_msgId));
        if (com.tencent.mm.y.c.Fh().dI(j).field_msgId != 0) {
            return true;
        }
        return false;
    }
}
