package com.tencent.mm.plugin.profile.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import com.tencent.mm.R;
import com.tencent.mm.ax.n;
import com.tencent.mm.plugin.downloader.model.g;
import com.tencent.mm.pluginsdk.c.a;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.pluginsdk.ui.preference.HelperHeaderPreference;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.storage.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.y.as;
import com.tencent.mm.y.bb;
import com.tencent.mm.y.bp;
import com.tencent.mm.y.c;
import com.tencent.mm.y.q;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import com.tencent.wcdb.FileUtils;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.net.URI;
import java.net.URL;

public final class m implements a, b {
    Context context;
    private boolean frK;
    private f inW;
    private x jQP;

    public m(Context context) {
        this.context = context;
    }

    public final boolean ww(String str) {
        if (bi.oM(str).length() <= 0) {
            return false;
        }
        if ("contact_info_go_to_sync".equals(str)) {
            if (p.m(this.context, "com.tencent.qqpim")) {
                Intent launchIntentForPackage = this.context.getPackageManager().getLaunchIntentForPackage("com.tencent.qqpim");
                launchIntentForPackage.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                this.context.startActivity(launchIntentForPackage);
            } else {
                h.a(this.context, R.l.dWi, R.l.dGZ, R.l.dEK, R.l.dEy, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        String str = "http://tools.3g.qq.com/j/wechatandriodpim";
                        if (com.tencent.mm.sdk.platformtools.f.fei == 1) {
                            Intent addFlags = new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=com.tencent.qqpim")).addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                            if (bi.k(m.this.context, addFlags)) {
                                m.this.context.startActivity(addFlags);
                                return;
                            }
                            str = "https://play.google.com/store/apps/details?id=com.tencent.qqpim";
                        }
                        try {
                            URL url = new URL(str);
                            URL toURL = new URI(url.getProtocol(), url.getUserInfo(), url.getHost(), url.getPort(), url.getPath(), url.getQuery(), url.getRef()).toURL();
                            g.a aVar = new g.a();
                            aVar.yt("qqpim.apk");
                            aVar.yr(toURL.toString());
                            aVar.et(true);
                            aVar.oP(1);
                            com.tencent.mm.plugin.downloader.model.f.aAK().a(aVar.lyp);
                        } catch (Exception e) {
                            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.ContactWidgetQQSync", "dz[download qq mail error:%s]", e.toString());
                        }
                    }
                }, null);
            }
            return true;
        } else if ("contact_info_remind_me_syncing".equals(str)) {
            CheckBoxPreference checkBoxPreference = (CheckBoxPreference) this.inW.Zu("contact_info_remind_me_syncing");
            as.Hm();
            c.Db().set(65792, Boolean.valueOf(checkBoxPreference.isChecked()));
            bp.r(6, checkBoxPreference.isChecked() ? "1" : "2");
            return true;
        } else if (str.equals("contact_info_qqsync_install")) {
            j(this.context, true);
            return true;
        } else if (!str.equals("contact_info_qqsync_uninstall")) {
            return false;
        } else {
            h.a(this.context, this.context.getString(R.l.eMR), "", this.context.getString(R.l.dEz), this.context.getString(R.l.dEy), new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    m.this.j(m.this.context, false);
                }
            }, null);
            return true;
        }
    }

    final void j(Context context, final boolean z) {
        String string = z ? context.getString(R.l.eMO) : context.getString(R.l.eMV);
        context.getString(R.l.dGZ);
        final ProgressDialog a = h.a(context, string, true, null);
        as.Dt().F(new Runnable() {
            public final void run() {
                boolean z = z;
                bp.r(6, z ? TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL : "4");
                int Gj = q.Gj();
                int i = z ? Gj & -129 : Gj | FileUtils.S_IWUSR;
                as.Hm();
                c.Db().set(34, Integer.valueOf(i));
                as.Hm();
                c.Fe().b(new n("", "", "", "", "", "", "", "", i, "", ""));
                if (!z) {
                    bb.hV("qqsync");
                    as.Hm();
                    c.Fk().XE("qqsync");
                }
                ah.y(new Runnable() {
                    public final void run() {
                        a.dismiss();
                    }
                });
            }
        });
    }

    public final boolean a(f fVar, x xVar, boolean z, int i) {
        as.Hm();
        c.Db().a(this);
        this.inW = fVar;
        this.jQP = xVar;
        fVar.addPreferencesFromResource(R.o.fbQ);
        asy();
        return true;
    }

    public final boolean asz() {
        as.Hm();
        c.Db().b(this);
        return true;
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
    }

    public final void a(int i, com.tencent.mm.sdk.e.m mVar, Object obj) {
        if (this.frK != q.Gt()) {
            asy();
        }
    }

    private void asy() {
        boolean z;
        boolean z2 = true;
        this.frK = q.Gt();
        HelperHeaderPreference helperHeaderPreference = (HelperHeaderPreference) this.inW.Zu("contact_info_header_helper");
        helperHeaderPreference.af(this.jQP.field_username, this.jQP.AX(), this.context.getString(R.l.dWj));
        helperHeaderPreference.nP(this.frK ? 1 : 0);
        f fVar = this.inW;
        String str = "contact_info_go_to_sync";
        if (this.frK) {
            z = false;
        } else {
            z = true;
        }
        fVar.bl(str, z);
        fVar = this.inW;
        str = "contact_info_remind_me_syncing_tip";
        if (this.frK) {
            z = false;
        } else {
            z = true;
        }
        fVar.bl(str, z);
        this.inW.bl("contact_info_qqsync_install", this.frK);
        f fVar2 = this.inW;
        String str2 = "contact_info_qqsync_uninstall";
        if (this.frK) {
            z2 = false;
        }
        fVar2.bl(str2, z2);
    }
}
