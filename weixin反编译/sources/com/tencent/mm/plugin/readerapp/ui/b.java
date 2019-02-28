package com.tencent.mm.plugin.readerapp.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Message;
import com.tencent.mm.R;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.messenger.foundation.a.a.e;
import com.tencent.mm.plugin.readerapp.b.g;
import com.tencent.mm.pluginsdk.c.a;
import com.tencent.mm.pluginsdk.ui.preference.HelperHeaderPreference;
import com.tencent.mm.protocal.c.ayi;
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
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import com.tencent.wcdb.database.SQLiteGlobal;
import java.util.Timer;
import java.util.TimerTask;
import junit.framework.Assert;

public final class b implements a, com.tencent.mm.sdk.e.m.b {
    Context context;
    private f inW;
    private x jQP;

    /* renamed from: com.tencent.mm.plugin.readerapp.ui.b$3 */
    static class AnonymousClass3 extends ag {
        final /* synthetic */ boolean kIh;
        final /* synthetic */ o kIi = null;
        final /* synthetic */ Context val$context;

        AnonymousClass3(boolean z, Context context, o oVar) {
            this.kIh = z;
            this.val$context = context;
        }

        public final void handleMessage(Message message) {
            if (this.kIh) {
                b.hA(true);
            }
            int Gj = q.Gj();
            if (this.kIh) {
                Gj &= -524289;
            } else {
                Gj |= SQLiteGlobal.journalSizeLimit;
            }
            as.Hm();
            c.Db().set(34, Integer.valueOf(Gj));
            com.tencent.mm.bp.a ayi = new ayi();
            ayi.vMg = SQLiteGlobal.journalSizeLimit;
            if (this.kIh) {
                Gj = 0;
            } else {
                Gj = 1;
            }
            ayi.wLZ = Gj;
            as.Hm();
            c.Fe().b(new e.a(39, ayi));
            if (!this.kIh) {
                final ProgressDialog a = h.a(this.val$context, this.val$context.getString(R.l.eCb), false, null);
                g.a(new g.a() {
                    public final void bmS() {
                        if (a != null) {
                            a.dismiss();
                        }
                    }
                });
                b.hA(false);
            }
            if (this.kIi != null) {
                this.kIi.a(null, null);
            }
        }
    }

    public b(Context context) {
        this.context = context;
    }

    static void hA(boolean z) {
        int Ge = q.Ge();
        if (z) {
            Ge &= -1025;
        } else {
            Ge |= WXMediaMessage.DESCRIPTION_LENGTH_LIMIT;
        }
        as.Hm();
        c.Db().set(40, Integer.valueOf(Ge));
        Ge = z ? 2 : 1;
        as.Hm();
        c.Fe().b(new com.tencent.mm.ax.g(26, Ge));
    }

    public final boolean ww(String str) {
        boolean z = false;
        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ContactWidgetReaderAppNews", "handleEvent : key = " + str);
        if (bi.oM(str).length() <= 0) {
            return false;
        }
        if (str.equals("contact_info_readerappnews_view")) {
            Intent intent = new Intent(this.context, ReaderAppUI.class);
            intent.addFlags(67108864);
            intent.putExtra(Columns.TYPE, 20);
            this.context.startActivity(intent);
            ((Activity) this.context).finish();
            com.tencent.mm.plugin.readerapp.a.a.ihO.un();
            return true;
        } else if (str.equals("contact_info_readerappnews_subscribe")) {
            this.context.startActivity(new Intent(this.context, ReaderAppSubscribeUI.class));
            return true;
        } else if (str.equals("contact_info_readerappnews_clear_data")) {
            h.a(this.context, this.context.getString(R.l.dUS), "", this.context.getString(R.l.dEz), this.context.getString(R.l.dEy), new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    final ProgressDialog a = h.a(b.this.context, b.this.context.getString(R.l.eCb), false, null);
                    g.a(new g.a() {
                        public final void bmS() {
                            a.dismiss();
                        }
                    });
                }
            }, null);
            return true;
        } else if (str.equals("contact_info_readerappnews_recv_remind")) {
            boolean z2;
            CheckBoxPreference checkBoxPreference = (CheckBoxPreference) this.inW.Zu(str);
            boolean bmT = com.tencent.mm.plugin.readerapp.b.c.bmT();
            if (bmT) {
                z2 = false;
            } else {
                z2 = true;
            }
            checkBoxPreference.tYU = z2;
            if (!bmT) {
                z = true;
            }
            hA(z);
            return true;
        } else if (str.equals("contact_info_readerappnews_install")) {
            g(this.context, true);
            return true;
        } else if (str.equals("contact_info_readerappnews_uninstall")) {
            h.a(this.context, this.context.getString(R.l.eMR), "", this.context.getString(R.l.dEz), this.context.getString(R.l.dEy), new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    b.g(b.this.context, false);
                }
            }, null);
            return true;
        } else {
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.ContactWidgetReaderAppNews", "handleEvent : unExpected key = " + str);
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
        Assert.assertTrue(s.gY(xVar.field_username));
        as.Hm();
        c.Db().a(this);
        this.jQP = xVar;
        this.inW = fVar;
        asy();
        return true;
    }

    private void asy() {
        int i = 1;
        int i2 = (q.Gj() & SQLiteGlobal.journalSizeLimit) == 0 ? 1 : 0;
        this.inW.removeAll();
        this.inW.addPreferencesFromResource(R.o.fbR);
        HelperHeaderPreference helperHeaderPreference = (HelperHeaderPreference) this.inW.Zu("contact_info_header_helper");
        helperHeaderPreference.af(this.jQP.field_username, this.jQP.AX(), this.context.getString(R.l.dWn));
        if (i2 == 0) {
            i = 0;
        }
        helperHeaderPreference.nP(i);
        CheckBoxPreference checkBoxPreference = (CheckBoxPreference) this.inW.Zu("contact_info_readerappnews_recv_remind");
        boolean bmT = com.tencent.mm.plugin.readerapp.b.c.bmT();
        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ContactWidgetReaderAppNews", "wantToReceiveNews = " + bmT);
        checkBoxPreference.tYU = bmT;
        if (i2 != 0) {
            this.inW.Zv("contact_info_readerappnews_install");
            return;
        }
        this.inW.Zv("contact_info_readerappnews_subscribe");
        this.inW.Zv("contact_info_readerappnews_view");
        this.inW.Zv("contact_info_readerappnews_clear_data");
        this.inW.Zv("contact_info_readerappnews_uninstall");
        this.inW.Zv("contact_info_readerappnews_recv_remind");
    }

    public static void g(Context context, boolean z) {
        String string = z ? context.getString(R.l.eMO) : context.getString(R.l.eMV);
        context.getString(R.l.dGZ);
        final ProgressDialog a = h.a(context, string, true, null);
        final ag anonymousClass3 = new AnonymousClass3(z, context, null);
        new Timer().schedule(new TimerTask() {
            public final void run() {
                if (a != null) {
                    a.dismiss();
                    anonymousClass3.sendEmptyMessage(0);
                }
            }
        }, 5000);
    }

    public final boolean asz() {
        as.Hm();
        c.Db().b(this);
        com.tencent.mm.plugin.readerapp.a.a.ihO.un();
        return true;
    }

    public final void a(int i, m mVar, Object obj) {
        int p = bi.p(obj, 0);
        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ContactWidgetReaderAppNews", "onNotifyChange event:%d obj:%d stg:%s", Integer.valueOf(i), Integer.valueOf(p), mVar);
        as.Hm();
        if (mVar != c.Db() || p <= 0) {
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.ContactWidgetReaderAppNews", "onNotifyChange error obj:%d stg:%s", Integer.valueOf(p), mVar);
        } else if (p == 40 || p == 34 || p == 7) {
            asy();
        }
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
    }
}
