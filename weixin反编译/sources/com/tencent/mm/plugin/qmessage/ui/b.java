package com.tencent.mm.plugin.qmessage.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Message;
import com.tencent.mm.R;
import com.tencent.mm.ax.n;
import com.tencent.mm.bl.d;
import com.tencent.mm.plugin.qmessage.a.g;
import com.tencent.mm.pluginsdk.c.a;
import com.tencent.mm.pluginsdk.ui.preference.HelperHeaderPreference;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.storage.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.o;
import com.tencent.mm.y.as;
import com.tencent.mm.y.c;
import com.tencent.mm.y.q;
import com.tencent.mm.y.s;
import java.util.Timer;
import java.util.TimerTask;
import junit.framework.Assert;

public final class b implements a, com.tencent.mm.sdk.e.m.b {
    Context context;
    private f inW;
    private x jQP;
    private boolean pnl;

    /* renamed from: com.tencent.mm.plugin.qmessage.ui.b$7 */
    static class AnonymousClass7 extends ag {
        final /* synthetic */ boolean kIh;
        final /* synthetic */ o kIi = null;

        AnonymousClass7(boolean z, o oVar) {
            this.kIh = z;
        }

        public final void handleMessage(Message message) {
            int i;
            b.d(64, this.kIh, 5);
            b.d(8192, this.kIh, 12);
            int Gj = q.Gj();
            if (this.kIh) {
                i = Gj & -33;
            } else {
                i = Gj | 32;
            }
            as.Hm();
            c.Db().set(34, Integer.valueOf(i));
            as.Hm();
            c.Fe().b(new n("", "", "", "", "", "", "", "", i, "", ""));
            if (!this.kIh) {
                g.bkH();
            }
            if (this.kIi != null) {
                this.kIi.a(null, null);
            }
        }
    }

    public b(Context context) {
        this.context = context;
    }

    public final boolean ww(String str) {
        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ContactWidgetQMessage", "handleEvent : key = " + str);
        if (bi.oM(str).length() <= 0) {
            return false;
        }
        if (str.equals("contact_info_view_message")) {
            Intent intent = new Intent(this.context, QConversationUI.class);
            if (this.pnl) {
                ((Activity) this.context).setResult(-1, intent);
            } else {
                this.context.startActivity(intent);
            }
            ((Activity) this.context).finish();
            return true;
        } else if (str.equals("contact_info_qmessage_recv_offline_msg")) {
            final CheckBoxPreference checkBoxPreference = (CheckBoxPreference) this.inW.Zu(str);
            if (checkBoxPreference.isChecked()) {
                d(64, true, 5);
            } else if (vp(8192)) {
                h.a(this.context, R.l.dWb, R.l.dGZ, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        b.d(8192, false, 12);
                        b.d(64, false, 5);
                    }
                }, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        checkBoxPreference.tYU = true;
                        b.this.asy();
                    }
                });
            } else {
                d(64, false, 5);
                return true;
            }
            return true;
        } else if (str.equals("contact_info_qmessage_display_weixin_online")) {
            d(8192, ((CheckBoxPreference) this.inW.Zu(str)).isChecked(), 12);
            return true;
        } else if (str.equals("contact_info_qmessage_clear_data")) {
            h.a(this.context, this.context.getString(R.l.dUR), "", this.context.getString(R.l.dEz), this.context.getString(R.l.dEy), new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    g.bkH();
                }
            }, null);
            return true;
        } else if (str.equals("contact_info_qmessage_install")) {
            as.Hm();
            if (bi.e((Integer) c.Db().get(9, null)) == 0) {
                h.b(this.context, R.l.eOi, R.l.dGZ, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        d.a(b.this.context, "accountsync", "com.tencent.mm.ui.bindqq.BindQQUI", null);
                    }
                }, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
                return true;
            }
            g(this.context, true);
            return true;
        } else if (str.equals("contact_info_qmessage_uninstall")) {
            h.a(this.context, this.context.getString(R.l.eMR), "", this.context.getString(R.l.dEz), this.context.getString(R.l.dEy), new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    b.g(b.this.context, false);
                }
            }, null);
            return true;
        } else {
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.ContactWidgetQMessage", "handleEvent : unExpected key = " + str);
            return false;
        }
    }

    public static void g(Context context, boolean z) {
        String string = z ? context.getString(R.l.eMO) : context.getString(R.l.eMV);
        context.getString(R.l.dGZ);
        final ProgressDialog a = h.a(context, string, true, null);
        final ag anonymousClass7 = new AnonymousClass7(z, null);
        new Timer().schedule(new TimerTask() {
            public final void run() {
                if (a != null) {
                    a.dismiss();
                    anonymousClass7.sendEmptyMessage(0);
                }
            }
        }, 5000);
    }

    private static boolean vp(int i) {
        return (q.Gc() & i) != 0;
    }

    public final boolean a(f fVar, x xVar, boolean z, int i) {
        boolean z2 = false;
        Assert.assertTrue(xVar != null);
        Assert.assertTrue(s.gP(xVar.field_username));
        if (fVar != null) {
            z2 = true;
        }
        Assert.assertTrue(z2);
        as.Hm();
        c.Db().a(this);
        this.jQP = xVar;
        this.pnl = z;
        this.inW = fVar;
        asy();
        return true;
    }

    final void asy() {
        int i = 1;
        int i2 = (q.Gj() & 32) == 0 ? 1 : 0;
        boolean vp = vp(64);
        vp(8192);
        this.inW.removeAll();
        this.inW.addPreferencesFromResource(R.o.fbO);
        HelperHeaderPreference helperHeaderPreference = (HelperHeaderPreference) this.inW.Zu("contact_info_header_helper");
        helperHeaderPreference.af(this.jQP.field_username, this.jQP.AX(), this.context.getString(R.l.dWc));
        if (i2 == 0) {
            i = 0;
        }
        helperHeaderPreference.nP(i);
        if (i2 == 0) {
            this.inW.Zv("contact_info_view_message");
            this.inW.Zv("contact_info_qmessage_recv_offline_msg");
            this.inW.Zv("contact_info_qmessage_uninstall");
            this.inW.Zv("contact_info_qmessage_clear_data");
            return;
        }
        this.inW.Zv("contact_info_qmessage_install");
        ((CheckBoxPreference) this.inW.Zu("contact_info_qmessage_recv_offline_msg")).tYU = vp;
    }

    static void d(int i, boolean z, int i2) {
        int Gc = q.Gc();
        if (z) {
            Gc |= i;
        } else {
            Gc &= i ^ -1;
        }
        as.Hm();
        c.Db().set(7, Integer.valueOf(Gc));
        Gc = z ? 1 : 2;
        as.Hm();
        c.Fe().b(new com.tencent.mm.ax.g(i2, Gc));
    }

    public final boolean asz() {
        as.Hm();
        c.Db().b(this);
        com.tencent.mm.plugin.qmessage.a.pta.un();
        return true;
    }

    public final void a(int i, m mVar, Object obj) {
        as.Hm();
        if (mVar == c.Db()) {
            asy();
        }
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
    }
}
