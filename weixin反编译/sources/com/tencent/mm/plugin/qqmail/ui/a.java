package com.tencent.mm.plugin.qqmail.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.a.g;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.plugin.qqmail.b.n;
import com.tencent.mm.plugin.qqmail.b.w;
import com.tencent.mm.pluginsdk.ui.preference.HelperHeaderPreference;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.storage.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.y.as;
import com.tencent.mm.y.c;
import com.tencent.mm.y.q;
import com.tencent.mm.y.s;
import junit.framework.Assert;

public final class a implements e, com.tencent.mm.pluginsdk.c.a, b {
    private static boolean pxG = false;
    private Context context;
    private boolean frK;
    private ProgressDialog inI;
    private f inW;
    private x jQP;
    private ProgressDialog laU;
    private boolean pnl;
    private boolean pxF;

    public a(Context context) {
        Assert.assertTrue(context != null);
        this.context = context;
    }

    public final boolean ww(String str) {
        boolean z = false;
        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ContactWidgetQQMail", "handleEvent : key = " + str);
        if (bi.oM(str).length() <= 0) {
            return false;
        }
        Intent intent;
        if (str.equals("contact_info_qqmailhelper_view")) {
            intent = new Intent();
            if (this.pnl) {
                intent.putExtra("Chat_User", this.jQP.field_username);
                intent.putExtra("Chat_Mode", 1);
                intent.addFlags(67108864);
                ((Activity) this.context).setResult(-1, intent);
            } else {
                intent.putExtra("Chat_User", this.jQP.field_username);
                intent.putExtra("Chat_Mode", 1);
                intent.addFlags(67108864);
                com.tencent.mm.plugin.qqmail.a.a.ihN.e(intent, this.context);
            }
            ((Activity) this.context).finish();
            return true;
        } else if (str.equals("contact_info_qqmailhelper_compose")) {
            intent = new Intent(this.context, ComposeUI.class);
            if (this.pnl) {
                intent.putExtra("Chat_User", this.jQP.field_username);
                intent.addFlags(67108864);
                ((Activity) this.context).setResult(-1, intent);
            } else {
                intent.putExtra("Chat_User", this.jQP.field_username);
                intent.addFlags(67108864);
                this.context.startActivity(intent);
            }
            ((Activity) this.context).finish();
            return true;
        } else if (str.equals("contact_info_qqmailhelper_set_files_view")) {
            as.Hm();
            Intent intent2 = new Intent("android.intent.action.VIEW", Uri.parse(bi.oM((String) c.Db().get(29, null))));
            intent2.putExtra("title", this.context.getString(R.l.dWg));
            intent2.putExtra("zoom", false);
            intent2.putExtra("show_bottom", false);
            intent2.putExtra("showShare", false);
            intent2.putExtra("vertical_scroll", false);
            com.tencent.mm.plugin.qqmail.a.a.ihN.j(intent2, this.context);
            return true;
        } else if (str.equals("contact_info_qqmailhelper_recv_remind")) {
            CheckBoxPreference checkBoxPreference = (CheckBoxPreference) this.inW.Zu(str);
            boolean isChecked = checkBoxPreference.isChecked();
            hu(isChecked);
            if (!isChecked) {
                z = true;
            }
            checkBoxPreference.tYU = z;
            return true;
        } else if (str.equals("contact_info_qqmailhelper_clear_data")) {
            h.a(this.context, this.context.getString(R.l.dUT), "", new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    w.blb();
                }
            }, null);
            return true;
        } else if (str.equals("contact_info_qqmailhelper_install")) {
            as.Hm();
            if (bi.e((Integer) c.Db().get(9, null)) == 0) {
                h.b(this.context, R.l.eOi, R.l.dGZ, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        com.tencent.mm.plugin.qqmail.a.a.ihN.h(null, a.this.context);
                    }
                }, null);
                return true;
            }
            ht(true);
            return true;
        } else if (str.equals("contact_info_qqmailhelper_uninstall")) {
            h.a(this.context, this.context.getString(R.l.eMR), "", this.context.getString(R.l.dEz), this.context.getString(R.l.dEy), new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    a.this.ht(false);
                }
            }, null);
            return true;
        } else {
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.ContactWidgetQQMail", "handleEvent : unExpected key = " + str);
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
        Assert.assertTrue(s.gL(xVar.field_username));
        as.Hm();
        c.Db().a(this);
        as.CN().a(24, (e) this);
        this.pnl = z;
        this.jQP = xVar;
        this.inW = fVar;
        fVar.addPreferencesFromResource(R.o.fbP);
        asy();
        return true;
    }

    private void asy() {
        boolean z;
        int i;
        boolean z2 = true;
        this.frK = (q.Gj() & 1) == 0;
        as.Hm();
        if (bi.e((Integer) c.Db().get(17, null)) == 1) {
            z = true;
        } else {
            z = false;
        }
        this.pxF = z;
        HelperHeaderPreference helperHeaderPreference = (HelperHeaderPreference) this.inW.Zu("contact_info_header_helper");
        helperHeaderPreference.af(this.jQP.field_username, this.jQP.AX(), this.context.getString(R.l.dWh));
        if (this.frK) {
            i = 1;
        } else {
            i = 0;
        }
        helperHeaderPreference.nP(i);
        this.inW.bl("contact_info_qqmailhelper_install", this.frK);
        f fVar = this.inW;
        String str = "contact_info_qqmailhelper_view";
        if (this.frK) {
            z = false;
        } else {
            z = true;
        }
        fVar.bl(str, z);
        fVar = this.inW;
        str = "contact_info_qqmailhelper_compose";
        if (this.frK) {
            z = false;
        } else {
            z = true;
        }
        fVar.bl(str, z);
        CheckBoxPreference checkBoxPreference = (CheckBoxPreference) this.inW.Zu("contact_info_qqmailhelper_recv_remind");
        if (checkBoxPreference != null) {
            checkBoxPreference.tYU = this.pxF;
        }
        fVar = this.inW;
        str = "contact_info_qqmailhelper_recv_remind";
        if (this.frK) {
            z = false;
        } else {
            z = true;
        }
        fVar.bl(str, z);
        fVar = this.inW;
        str = "contact_info_qqmailhelper_set_files_view";
        if ((this.frK & this.pxF) == 0) {
            z = true;
        } else {
            z = false;
        }
        fVar.bl(str, z);
        this.inW.bl("contact_info_qqmailhelper_download_mgr_view", true);
        fVar = this.inW;
        str = "contact_info_qqmailhelper_clear_data";
        if (this.frK) {
            z = false;
        } else {
            z = true;
        }
        fVar.bl(str, z);
        f fVar2 = this.inW;
        String str2 = "contact_info_qqmailhelper_uninstall";
        if (this.frK) {
            z2 = false;
        }
        fVar2.bl(str2, z2);
    }

    private void ht(boolean z) {
        String string = z ? this.context.getString(R.l.eMO) : this.context.getString(R.l.eMV);
        Context context = this.context;
        this.context.getString(R.l.dGZ);
        this.laU = h.a(context, string, true, null);
        pxG = true;
        hu(z);
    }

    public final boolean asz() {
        as.Hm();
        c.Db().b(this);
        as.CN().b(24, (e) this);
        if (this.laU != null) {
            this.laU.dismiss();
            this.laU = null;
        }
        if (this.inI != null) {
            this.inI.dismiss();
            this.inI = null;
        }
        return true;
    }

    public final void a(int i, m mVar, Object obj) {
        int p = bi.p(obj, 0);
        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ContactWidgetQQMail", "onNotifyChange event:%d obj:%d stg:%s", Integer.valueOf(i), Integer.valueOf(p), mVar);
        as.Hm();
        if (mVar != c.Db() || p <= 0) {
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.ContactWidgetQQMail", "onNotifyChange error obj:%d stg:%s", Integer.valueOf(p), mVar);
        } else if (p == 17 || p == 34 || p == 7) {
            asy();
        }
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
    }

    private boolean hu(boolean z) {
        final k nVar = new n(z, "");
        if (!pxG) {
            this.inI = h.a(this.context, this.context.getString(R.l.dHn), true, new OnCancelListener() {
                public final void onCancel(DialogInterface dialogInterface) {
                    as.CN().c(nVar);
                }
            });
        }
        as.CN().a(nVar, 0);
        return false;
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (kVar.getType() != 24) {
            com.tencent.mm.sdk.platformtools.x.w("MicroMsg.ContactWidgetQQMail", "onSceneEnd : unExpected type = " + kVar.getType());
            return;
        }
        if (this.inI != null) {
            this.inI.dismiss();
            this.inI = null;
        }
        if (this.laU != null) {
            this.laU.dismiss();
            this.laU = null;
        }
        if (i == 0 && i2 == 0) {
            boolean z = ((n) kVar).fKG;
            as.Hm();
            c.Db().set(17, Integer.valueOf(z ? 1 : 2));
            if (pxG && bi.bF(this.context)) {
                if (z) {
                    as.Hm();
                    c.Db().set(17, Integer.valueOf(1));
                }
                int Gj = q.Gj();
                int i3 = z ? Gj & -2 : Gj | 1;
                as.Hm();
                c.Db().set(34, Integer.valueOf(i3));
                as.Hm();
                c.Fe().b(new com.tencent.mm.ax.n("", "", "", "", "", "", "", "", i3, "", ""));
                com.tencent.mm.plugin.qqmail.a.a.ihO.un();
                if (!z) {
                    w.blb();
                }
            }
            pxG = false;
            return;
        }
        CharSequence string;
        final boolean z2 = ((n) kVar).fKG;
        com.tencent.mm.sdk.platformtools.x.e("MicroMsg.ContactWidgetQQMail", "NetSceneSwitchPushMail fail : errType = " + i + ", errCode = " + i2);
        if (i == 4) {
            switch (i2) {
                case -31:
                    com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ContactWidgetQQMail", "need second pass");
                    View inflate = View.inflate(this.context, R.i.drF, null);
                    final EditText editText = (EditText) inflate.findViewById(R.h.cKy);
                    h.a(this.context, this.context.getString(R.l.dWf), inflate, new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            final k nVar = new n(z2, g.s(editText.getText().toString().trim().getBytes()));
                            as.CN().a(nVar, 0);
                            a aVar = a.this;
                            Context a = a.this.context;
                            a.this.context.getString(R.l.dWe);
                            aVar.inI = h.a(a, a.this.context.getString(R.l.dHn), true, new OnCancelListener() {
                                public final void onCancel(DialogInterface dialogInterface) {
                                    as.CN().c(nVar);
                                }
                            });
                        }
                    });
                    return;
                case -1:
                    com.tencent.mm.sdk.platformtools.x.w("MicroMsg.ContactWidgetQQMail", "onSceneEnd, sys err");
                    break;
                default:
                    return;
            }
        }
        if (pxG) {
            string = this.context.getString(z2 ? R.l.eML : R.l.eMQ);
        } else {
            string = this.context.getString(R.l.dEZ);
        }
        Toast.makeText(this.context, string, 1).show();
        pxG = false;
    }
}
