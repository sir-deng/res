package com.tencent.mm.plugin.notification.d;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Build.VERSION;
import com.tencent.mm.R;
import com.tencent.mm.bl.d;
import com.tencent.mm.f.a.kv;
import com.tencent.mm.f.a.nu;
import com.tencent.mm.f.a.qe;
import com.tencent.mm.f.a.qf;
import com.tencent.mm.plugin.notification.c.a;
import com.tencent.mm.plugin.sns.b.n;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.as;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.util.ArrayList;
import java.util.List;

public final class e extends a<c> {
    private c pab = new c<qf>() {
        {
            this.xmG = qf.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            final qf qfVar = (qf) bVar;
            ah.y(new Runnable() {
                public final void run() {
                    qf qfVar = qfVar;
                    c cVar = new c();
                    cVar.id = qfVar.fIH.fIG;
                    e.this.bD(cVar);
                }
            });
            return false;
        }
    };
    private c pac = new c<qe>() {
        {
            this.xmG = qe.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            final qe qeVar = (qe) bVar;
            ah.y(new Runnable() {
                public final void run() {
                    as.Hm();
                    com.tencent.mm.y.c.Db().set(589825, Boolean.valueOf(true));
                    qe qeVar = qeVar;
                    c cVar = new c();
                    cVar.id = qeVar.fIF.fIG;
                    e.this.bC(cVar);
                }
            });
            return false;
        }
    };

    protected final /* bridge */ /* synthetic */ long bE(Object obj) {
        return ((c) obj).id;
    }

    protected final /* synthetic */ ArrayList bF(Object obj) {
        ArrayList buR = n.qWH.buR();
        if (buR.size() == 0) {
            x.e("MicroMsg.SendSnsFailNotification", "getAllFailMsgFromDb, resendList is empty");
        }
        return buR;
    }

    protected final void bhd() {
        List runningTasks = ((ActivityManager) this.mContext.getSystemService("activity")).getRunningTasks(1);
        if (runningTasks != null && runningTasks.size() > 0) {
            ComponentName componentName = ((RunningTaskInfo) runningTasks.get(0)).topActivity;
            if (componentName != null) {
                x.d("MicroMsg.SendSnsFailNotification", "onNotificationClick, currentActivity name:%s", componentName.getClassName());
                if (componentName.getClassName().contains("SnsTimeLineUI")) {
                    x.d("MicroMsg.SendSnsFailNotification", "onNotificationClick, already in SnsTimlineUI");
                    return;
                }
            }
        }
        Intent intent = new Intent();
        intent.putExtra("sns_resume_state", false);
        intent.putExtra("sns_timeline_NeedFirstLoadint", true);
        intent.putExtra("preferred_tab", 2);
        if (VERSION.SDK_INT < 16) {
            intent.putExtra("is_need_resend_sns", true);
        }
        intent.putExtra("From_fail_notify", true);
        intent.putExtra("jump_sns_from_notify", true);
        intent.addFlags(67108864);
        intent.addFlags(SQLiteDatabase.ENABLE_WRITE_AHEAD_LOGGING);
        d.a(this.mContext, "com.tencent.mm.ui.LauncherUI", intent);
    }

    protected final int getType() {
        return 2;
    }

    protected final void K(ArrayList<Long> arrayList) {
        b kvVar = new kv();
        kvVar.fCY.fya = arrayList;
        com.tencent.mm.sdk.b.a.xmy.m(kvVar);
    }

    public final void bhi() {
        com.tencent.mm.sdk.b.a.xmy.b(this.pac);
    }

    public final void bhj() {
        com.tencent.mm.sdk.b.a.xmy.b(this.pab);
    }

    public final void dU(final long j) {
        ah.y(new Runnable() {
            public final void run() {
                x.d("MicroMsg.SendSnsFailNotification", "resend snsInfo id:%d", Long.valueOf(j));
                b nuVar = new nu();
                nuVar.fGF.fGG = (int) j;
                com.tencent.mm.sdk.b.a.xmy.m(nuVar);
            }
        });
    }

    public final void bhk() {
        com.tencent.mm.sdk.b.a.xmy.c(this.pac);
    }

    public final void bhl() {
        com.tencent.mm.sdk.b.a.xmy.c(this.pab);
    }

    protected final String uA(int i) {
        return this.mContext.getString(R.l.eyI, new Object[]{Integer.valueOf(i)});
    }

    protected final String dd(int i, int i2) {
        return this.mContext.getString(R.l.ezp, new Object[]{Integer.valueOf(i2), Integer.valueOf(i)});
    }

    protected final String U(int i, int i2, int i3) {
        return this.mContext.getString(R.l.ezq, new Object[]{Integer.valueOf(i2), Integer.valueOf(i), Integer.valueOf(i3)});
    }

    protected final String de(int i, int i2) {
        if (i2 <= 0) {
            return this.mContext.getString(R.l.ezm, new Object[]{Integer.valueOf(i)});
        }
        return this.mContext.getString(R.l.eyJ, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
    }

    public final boolean dV(long j) {
        x.d("MicroMsg.SendSnsFailNotification", "checkMsgIfExist, msgId:%d, result:%b", Long.valueOf(j), Boolean.valueOf(n.qWH.wK((int) j)));
        return n.qWH.wK((int) j);
    }

    protected final void bgT() {
        if (as.Hp()) {
            as.Hm();
            com.tencent.mm.y.c.Db().set(589825, Boolean.valueOf(false));
        }
    }
}
