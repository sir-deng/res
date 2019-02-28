package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Message;
import com.tencent.mm.R;
import com.tencent.mm.ax.n;
import com.tencent.mm.j.g;
import com.tencent.mm.pluginsdk.c.a;
import com.tencent.mm.pluginsdk.ui.preference.HelperHeaderPreference;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.storage.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.base.r;
import com.tencent.mm.ui.o;
import com.tencent.mm.y.as;
import com.tencent.mm.y.bb;
import com.tencent.mm.y.c;
import com.tencent.mm.y.q;
import com.tencent.mm.y.s;
import java.util.Timer;
import java.util.TimerTask;
import junit.framework.Assert;

public final class j implements a, b {
    private static boolean isDeleteCancel = false;
    private Context context;
    private f inW;
    private x jQP;

    /* renamed from: com.tencent.mm.plugin.profile.ui.j$4 */
    static class AnonymousClass4 extends ag {
        final /* synthetic */ boolean kIh;
        final /* synthetic */ o kIi = null;
        final /* synthetic */ Context val$context;

        AnonymousClass4(boolean z, Context context, o oVar) {
            this.kIh = z;
            this.val$context = context;
        }

        public final void handleMessage(Message message) {
            int i;
            if (this.kIh) {
                j.hn(true);
            }
            int Gj = q.Gj();
            if (this.kIh) {
                i = Gj & -17;
            } else {
                i = Gj | 16;
            }
            as.Hm();
            c.Db().set(34, Integer.valueOf(i));
            as.Hm();
            c.Fe().b(new n("", "", "", "", "", "", "", "", i, "", ""));
            if (!this.kIh) {
                j.do(this.val$context);
            }
            if (this.kIi != null) {
                this.kIi.a(null, null);
            }
        }
    }

    static /* synthetic */ void do(Context context) {
        isDeleteCancel = false;
        context.getString(R.l.dGZ);
        final r a = h.a(context, context.getString(R.l.dHn), true, new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                j.isDeleteCancel = true;
            }
        });
        bb.a("medianote", new bb.a() {
            public final boolean HH() {
                return j.isDeleteCancel;
            }

            public final void HG() {
                if (a != null) {
                    a.dismiss();
                }
            }
        });
        as.Hm();
        c.Fk().XE("medianote");
    }

    public j(Context context) {
        this.context = context;
    }

    public final boolean ww(String str) {
        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ContactWidgetMediaNote", "handleEvent : key = " + str);
        if (bi.oM(str).length() <= 0) {
            return false;
        }
        if (str.equals("contact_info_medianote_view")) {
            Intent intent = new Intent();
            intent.putExtra("Chat_User", "medianote");
            com.tencent.mm.plugin.profile.a.ihN.e(intent, this.context);
            com.tencent.mm.plugin.profile.a.ihO.un();
            return true;
        } else if (str.equals("contact_info_medianote_sync_to_qqmail")) {
            if (q.GF()) {
                hn(((CheckBoxPreference) this.inW.Zu(str)).isChecked());
            } else {
                h.a(this.context, R.l.dVO, R.l.dVN, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        com.tencent.mm.plugin.profile.a.ihN.h(new Intent(), j.this.context);
                    }
                }, null);
                asy();
            }
            return true;
        } else if (str.equals("contact_info_medianote_clear_data")) {
            h.a(this.context, this.context.getString(R.l.dUR), "", this.context.getString(R.l.dEz), this.context.getString(R.l.dEy), new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    j.do(j.this.context);
                }
            }, null);
            return true;
        } else if (str.equals("contact_info_medianote_install")) {
            g(this.context, true);
            return true;
        } else if (str.equals("contact_info_medianote_uninstall")) {
            h.a(this.context, this.context.getString(R.l.eMR), "", this.context.getString(R.l.dEz), this.context.getString(R.l.dEy), new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    j.g(j.this.context, false);
                }
            }, null);
            return true;
        } else {
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.ContactWidgetMediaNote", "handleEvent : unExpected key = " + str);
            return false;
        }
    }

    public final boolean a(f fVar, x xVar, boolean z, int i) {
        boolean z2 = false;
        Assert.assertTrue(fVar != null);
        if (xVar != null) {
            z2 = true;
        }
        Assert.assertTrue(z2);
        Assert.assertTrue(s.gX(xVar.field_username));
        as.Hm();
        c.Db().a(this);
        this.jQP = xVar;
        this.inW = fVar;
        fVar.addPreferencesFromResource(R.o.fbL);
        asy();
        return true;
    }

    private void asy() {
        boolean z;
        int i;
        boolean z2;
        boolean z3 = true;
        boolean z4 = (q.Gj() & 16) == 0;
        int Gc = q.Gc();
        if (q.GF()) {
            z = (Gc & 16384) != 0;
        } else {
            if ((Gc & 16384) != 0) {
                Gc &= -16385;
                as.Hm();
                c.Db().set(7, Integer.valueOf(Gc));
            }
            z = false;
        }
        HelperHeaderPreference helperHeaderPreference = (HelperHeaderPreference) this.inW.Zu("contact_info_header_helper");
        helperHeaderPreference.af(this.jQP.field_username, this.jQP.AX(), this.context.getString(R.l.dVP));
        if (z4) {
            i = 1;
        } else {
            i = 0;
        }
        helperHeaderPreference.nP(i);
        this.inW.bl("contact_info_medianote_install", z4);
        f fVar = this.inW;
        String str = "contact_info_medianote_view";
        if (z4) {
            z2 = false;
        } else {
            z2 = true;
        }
        fVar.bl(str, z2);
        if (!z4 || q.GF()) {
            z2 = z4;
        } else {
            if (bi.getInt(g.Af().getValue("BindQQSwitch"), 1) == 1) {
                z2 = true;
            } else {
                z2 = false;
            }
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ContactWidgetMediaNote", "summerqq BindQQSwitch off");
        }
        fVar = this.inW;
        str = "contact_info_medianote_sync_to_qqmail";
        if (z2) {
            z2 = false;
        } else {
            z2 = true;
        }
        fVar.bl(str, z2);
        fVar = this.inW;
        str = "contact_info_medianote_clear_data";
        if (z4) {
            z2 = false;
        } else {
            z2 = true;
        }
        fVar.bl(str, z2);
        f fVar2 = this.inW;
        String str2 = "contact_info_medianote_uninstall";
        if (z4) {
            z3 = false;
        }
        fVar2.bl(str2, z3);
        ((CheckBoxPreference) this.inW.Zu("contact_info_medianote_sync_to_qqmail")).tYU = z;
    }

    public static void g(Context context, boolean z) {
        String string = z ? context.getString(R.l.eMO) : context.getString(R.l.eMV);
        context.getString(R.l.dGZ);
        final r a = h.a(context, string, true, null);
        final ag anonymousClass4 = new AnonymousClass4(z, context, null);
        new Timer().schedule(new TimerTask() {
            public final void run() {
                if (a != null) {
                    a.dismiss();
                    anonymousClass4.sendEmptyMessage(0);
                }
            }
        }, 1500);
    }

    public final boolean asz() {
        as.Hm();
        c.Db().b(this);
        com.tencent.mm.plugin.profile.a.ihO.un();
        return true;
    }

    public final void a(int i, m mVar, Object obj) {
        int p = bi.p(obj, 0);
        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ContactWidgetMediaNote", "onNotifyChange event:%d obj:%d stg:%s", Integer.valueOf(i), Integer.valueOf(p), mVar);
        as.Hm();
        if (mVar != c.Db() || p <= 0) {
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.ContactWidgetMediaNote", "onNotifyChange error obj:%d stg:%s", Integer.valueOf(p), mVar);
        } else if (p == 40 || p == 34 || p == 7) {
            asy();
        }
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
    }

    static void hn(boolean z) {
        int Gc = q.Gc();
        if (z) {
            Gc |= 16384;
        } else {
            Gc &= -16385;
        }
        as.Hm();
        c.Db().set(7, Integer.valueOf(Gc));
        Gc = z ? 1 : 2;
        as.Hm();
        c.Fe().b(new com.tencent.mm.ax.g(13, Gc));
    }
}
