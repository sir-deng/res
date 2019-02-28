package com.tencent.mm.plugin.setting.ui.setting;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Looper;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.ad.n;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsimple.am;
import com.tencent.mm.pluginsdk.q;
import com.tencent.mm.pluginsdk.q.t;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.protocal.c.ahj;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.al.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.account.RegByMobileSetPwdUI;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.IconPreference;
import com.tencent.mm.ui.base.preference.IconSummaryPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.tools.s;
import com.tencent.mm.ui.v;
import com.tencent.mm.y.as;
import com.tencent.mm.y.c;
import com.tencent.wcdb.database.SQLiteDatabase;

public class SettingsAboutMicroMsgUI extends MMPreference implements e {
    private f inW;
    private boolean qnX = false;
    private ahj qnY;
    private int qnZ = 0;
    Intent qoa = null;
    private ProgressDialog qob;
    private al qoc;
    private e qod = null;

    static /* synthetic */ void b(SettingsAboutMicroMsgUI settingsAboutMicroMsgUI) {
        n CN = as.CN();
        e anonymousClass3 = new e() {
            public final void a(final int i, final int i2, String str, final k kVar) {
                x.d("MicroMsg.SettingsAboutMicroMsgUI", "onSceneEnd " + i + " errCode " + i2 + " errMsg " + str + "  " + kVar.getType());
                ah.y(new Runnable() {
                    public final void run() {
                        as.CN().b(255, SettingsAboutMicroMsgUI.this.qod);
                        SettingsAboutMicroMsgUI.this.qod = null;
                        if (SettingsAboutMicroMsgUI.this.qoc != null) {
                            SettingsAboutMicroMsgUI.this.qoc.TN();
                            SettingsAboutMicroMsgUI.this.qoc = null;
                        }
                        if (SettingsAboutMicroMsgUI.this.qob != null) {
                            SettingsAboutMicroMsgUI.this.qob.dismiss();
                        }
                        if (kVar.getType() != 255 || ((com.tencent.mm.modelsimple.x) kVar).hPz != 1) {
                            return;
                        }
                        if (i2 == -3 && i == 4) {
                            Intent intent = new Intent(SettingsAboutMicroMsgUI.this.mController.xRr, RegByMobileSetPwdUI.class);
                            intent.putExtra("kintent_hint", SettingsAboutMicroMsgUI.this.getString(R.l.eEg));
                            SettingsAboutMicroMsgUI.this.startActivityForResult(intent, 0);
                            return;
                        }
                        SettingsAboutMicroMsgUI.g(SettingsAboutMicroMsgUI.this);
                    }
                });
            }
        };
        settingsAboutMicroMsgUI.qod = anonymousClass3;
        CN.a(255, anonymousClass3);
        final k xVar = new com.tencent.mm.modelsimple.x(2);
        xVar.hPz = 1;
        as.CN().a(xVar, 0);
        settingsAboutMicroMsgUI.qoc = new al(Looper.getMainLooper(), new a() {
            public final boolean uG() {
                as.CN().c(xVar);
                as.CN().b(255, SettingsAboutMicroMsgUI.this.qod);
                SettingsAboutMicroMsgUI.this.qod = null;
                if (SettingsAboutMicroMsgUI.this.qoc != null) {
                    SettingsAboutMicroMsgUI.this.qoc.TN();
                    SettingsAboutMicroMsgUI.this.qoc = null;
                }
                if (SettingsAboutMicroMsgUI.this.qob != null) {
                    SettingsAboutMicroMsgUI.this.qob.cancel();
                }
                SettingsAboutMicroMsgUI.g(SettingsAboutMicroMsgUI.this);
                return false;
            }
        }, false);
        settingsAboutMicroMsgUI.qoc.K(3000, 3000);
        Context context = settingsAboutMicroMsgUI.mController.xRr;
        settingsAboutMicroMsgUI.getString(R.l.dGZ);
        settingsAboutMicroMsgUI.qob = h.a(context, settingsAboutMicroMsgUI.getString(R.l.eYW), false, new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                as.CN().c(xVar);
                as.CN().b(255, SettingsAboutMicroMsgUI.this.qod);
                SettingsAboutMicroMsgUI.this.qod = null;
                if (SettingsAboutMicroMsgUI.this.qoc != null) {
                    SettingsAboutMicroMsgUI.this.qoc.TN();
                    SettingsAboutMicroMsgUI.this.qoc = null;
                }
                if (SettingsAboutMicroMsgUI.this.qob != null) {
                    SettingsAboutMicroMsgUI.this.qob.dismiss();
                }
            }
        });
    }

    static /* synthetic */ void g(SettingsAboutMicroMsgUI settingsAboutMicroMsgUI) {
        af.VJ("welcome_page_show");
        com.tencent.mm.kernel.k.e(settingsAboutMicroMsgUI, true);
        com.tencent.mm.plugin.setting.a.ihO.uq();
        as.getNotification().xf();
        q.a.viZ.ar(settingsAboutMicroMsgUI.mController.xRr);
        settingsAboutMicroMsgUI.finish();
    }

    public final int XK() {
        return R.o.fcy;
    }

    public final View brg() {
        LinearLayout linearLayout = (LinearLayout) v.fw(this.mController.xRr).inflate(R.i.dsg, null);
        TextView textView = (TextView) linearLayout.findViewById(R.h.cQH);
        TextView textView2 = (TextView) linearLayout.findViewById(R.h.cQG);
        String obj = g.Dq().Db().get(274436, (Object) "").toString();
        if (bi.oN(obj)) {
            obj = w.cfU();
        }
        obj = getString(R.l.ete, new Object[]{w.cfV(), obj});
        textView.setText(String.format("<a href='%s'>%s</a>", new Object[]{getString(R.l.eSB), getString(R.l.esZ)}));
        textView2.setText(String.format("<a href='%s'>%s</a>", new Object[]{obj, getString(R.l.eBj)}));
        i.f(textView, 1);
        i.f(textView2, 1);
        ((TextView) linearLayout.findViewById(R.h.bZa)).setText(linearLayout.getResources().getString(R.l.dEF, new Object[]{Integer.valueOf(2018)}));
        return linearLayout;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
        as.CN().a(11, (e) this);
        if (q.x.bYQ() != null) {
            as.CN().a((k) q.x.bYQ().bpf(), 0);
            com.tencent.mm.plugin.report.service.g.pWK.a(405, 15, 1, true);
        }
    }

    public void onResume() {
        super.onResume();
        brh();
    }

    public void onDestroy() {
        as.CN().b(11, (e) this);
        super.onDestroy();
    }

    protected final void initView() {
        setMMTitle(R.l.eOj);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                SettingsAboutMicroMsgUI.this.aWY();
                SettingsAboutMicroMsgUI.this.finish();
                return true;
            }
        });
        brh();
    }

    private void brh() {
        IconPreference iconPreference;
        boolean z;
        this.inW = this.yrJ;
        this.inW.removeAll();
        this.inW.addPreferencesFromResource(R.o.fcy);
        SettingsAboutMMHeaderPreference settingsAboutMMHeaderPreference = (SettingsAboutMMHeaderPreference) this.inW.Zu("settings_about_mm_header");
        String ag = com.tencent.mm.sdk.platformtools.f.ag(this.mController.xRr, d.vHl);
        if (d.vHo) {
            ag = ag + " " + getString(R.l.dDO);
        }
        settingsAboutMMHeaderPreference.qnU = ag;
        if (w.cfS()) {
            as.Hm();
            int e = bi.e((Integer) c.Db().get(12304, null));
            iconPreference = (IconPreference) this.inW.Zu("settings_update");
            if (e > 0) {
                iconPreference.Fq(0);
                iconPreference.dk(String.valueOf(e), s.ge(this.mController.xRr));
            } else {
                iconPreference.Fq(8);
                iconPreference.dk("", -1);
            }
        }
        if ((com.tencent.mm.sdk.platformtools.f.fek & 1) != 0) {
            z = true;
        } else {
            z = false;
        }
        IconSummaryPreference iconSummaryPreference;
        if (this.qnX && !com.tencent.mm.sdk.platformtools.f.xmW) {
            iconSummaryPreference = (IconSummaryPreference) this.inW.Zu("funtion_update");
            iconSummaryPreference.qno = 0;
            CharSequence ag2 = com.tencent.mm.sdk.platformtools.f.ag(null, this.qnZ);
            iconSummaryPreference.dk(getString(R.l.dGa), R.g.bEg);
            iconSummaryPreference.setSummary(ag2);
            iconSummaryPreference.yro = 0;
            if (iconSummaryPreference.yrp != null) {
                iconSummaryPreference.yrp.setVisibility(iconSummaryPreference.yro);
            }
            this.inW.Zv("funtion_check_update");
        } else if (z || this.qnY == null || this.qnY.wvx == 0 || bi.oN(this.qnY.wvy) || com.tencent.mm.sdk.platformtools.f.xmW) {
            this.inW.Zv("funtion_update");
        } else {
            x.i("MicroMsg.SettingsAboutMicroMsgUI", "show alpha update. url:%s, hint:%d", this.qnY.wvy, Integer.valueOf(this.qnY.wvz));
            if (this.qnY.wvz != 0) {
                iconSummaryPreference = (IconSummaryPreference) this.inW.Zu("funtion_update");
                iconSummaryPreference.qno = 0;
                iconSummaryPreference.dk(getString(R.l.dGa), R.g.bEg);
                this.inW.Zv("funtion_check_update");
            } else {
                this.inW.Zv("funtion_update");
            }
        }
        if (!w.cfS()) {
            this.inW.bl("settings_report", true);
        }
        q.a.viZ.uA();
        this.inW.bl("funtion_about_wechat", true);
        as.Hm();
        if (bi.oN((String) c.Db().get(com.tencent.mm.storage.w.a.USERINFO_CROWDTEST_APPLY_LINK_STRING, null))) {
            this.inW.Zv("funtion_crowdtest_update");
        } else {
            iconPreference = (IconPreference) this.inW.Zu("funtion_crowdtest_update");
            if (com.tencent.mm.r.c.Bx().aR(262157, 266263)) {
                iconPreference.Fs(0);
            }
        }
        this.inW.notifyDataSetChanged();
    }

    public final boolean a(f fVar, Preference preference) {
        String str = preference.idX;
        x.i("MicroMsg.SettingsAboutMicroMsgUI", str + " item has been clicked!");
        Intent intent;
        if (str.equals("settings_update")) {
            if (w.cfS()) {
                g.Do();
                int Cn = com.tencent.mm.kernel.a.Cn();
                as.Hm();
                int e = bi.e((Integer) c.Db().get(12304, null));
                str = getString(R.l.eNF, new Object[]{Integer.valueOf(Cn), Integer.valueOf(e)});
                if (str == null) {
                    return true;
                }
                as.Hm();
                c.Db().set(12304, Integer.valueOf(0));
                intent = new Intent();
                intent.putExtra("title", getString(R.l.eNE));
                intent.putExtra("rawUrl", str);
                intent.putExtra("showShare", false);
                com.tencent.mm.bl.d.b(this.mController.xRr, "webview", ".ui.tools.WebViewUI", intent);
                return true;
            }
            if (w.cfS()) {
                str = getString(R.l.eLI, new Object[]{w.cfV(), Integer.valueOf(d.vHl)});
            } else {
                str = "http://blog.wechat.com/";
            }
            intent = new Intent();
            intent.putExtra("rawUrl", str);
            intent.putExtra("showShare", false);
            intent.putExtra("show_bottom", false);
            com.tencent.mm.bl.d.b(this.mController.xRr, "webview", ".ui.tools.WebViewUI", intent);
            return true;
        } else if (str.equals("funtion_update")) {
            com.tencent.mm.plugin.report.service.g.pWK.a(405, 16, 1, true);
            str = "";
            if (this.qnX) {
                str = getString(R.l.eLJ, new Object[]{w.cfV(), Integer.valueOf(this.qnZ)});
            } else if (!(this.qnY == null || this.qnY.wvx == 0 || bi.oN(this.qnY.wvy))) {
                str = this.qnY.wvy;
            }
            intent = new Intent();
            intent.putExtra("rawUrl", str);
            intent.putExtra("showShare", true);
            intent.putExtra("show_bottom", false);
            com.tencent.mm.bl.d.b(this.mController.xRr, "webview", ".ui.tools.WebViewUI", intent);
            return true;
        } else if (str.equals("funtion_check_update")) {
            com.tencent.mm.plugin.report.service.g.pWK.a(405, 17, 1, true);
            if (q.x.bYQ() != null) {
                q.x.bYQ().bpe();
                if ((com.tencent.mm.sdk.platformtools.f.fek & 1) != 0) {
                    x.e("MicroMsg.SettingsAboutMicroMsgUI", "package has set external update mode");
                    Uri parse = Uri.parse(com.tencent.mm.sdk.platformtools.f.xmS);
                    intent = new Intent("android.intent.action.VIEW", parse).addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                    if (parse == null || intent == null || !bi.k(this.mController.xRr, intent)) {
                        x.e("MicroMsg.SettingsAboutMicroMsgUI", "parse market uri failed, jump to weixin.qq.com");
                        startActivity(new Intent("android.intent.action.VIEW", Uri.parse("http://weixin.qq.com")).addFlags(SQLiteDatabase.CREATE_IF_NECESSARY));
                        com.tencent.mm.plugin.report.service.g.pWK.a(405, 18, 1, true);
                        return true;
                    }
                    x.i("MicroMsg.SettingsAboutMicroMsgUI", "parse market uri ok");
                    startActivity(intent);
                    com.tencent.mm.plugin.report.service.g.pWK.a(405, 19, 1, true);
                    return true;
                } else if (this.qnY == null || this.qnY.wvx == 0 || bi.oN(this.qnY.wvy)) {
                    ad.getContext().getSharedPreferences("system_config_prefs", 0).edit().putLong("recomended_update_ignore", bi.Wx()).commit();
                    q.s a = q.x.bYQ().a(this, new OnCancelListener() {
                        public final void onCancel(DialogInterface dialogInterface) {
                            com.tencent.mm.plugin.report.service.g.pWK.a(405, 23, 1, true);
                        }
                    });
                    if (a == null) {
                        com.tencent.mm.plugin.report.service.g.pWK.a(405, 21, 1, true);
                    } else {
                        com.tencent.mm.plugin.report.service.g.pWK.a(405, 22, 1, true);
                        a.update(3);
                        return true;
                    }
                } else {
                    str = this.qnY.wvy;
                    intent = new Intent();
                    intent.putExtra("rawUrl", str);
                    intent.putExtra("showShare", false);
                    intent.putExtra("show_bottom", false);
                    com.tencent.mm.bl.d.b(this.mController.xRr, "webview", ".ui.tools.WebViewUI", intent);
                    com.tencent.mm.plugin.report.service.g.pWK.a(405, 20, 1, true);
                    return true;
                }
            }
            return false;
        } else if (str.equals("funtion_about_wechat")) {
            return true;
        } else {
            if (str.equals("settings_report")) {
                intent = new Intent();
                intent.putExtra("showShare", false);
                intent.putExtra("show_feedback", false);
                intent.putExtra("rawUrl", "https://support.weixin.qq.com/security/readtemplate?t=complaints/index");
                com.tencent.mm.bl.d.b(this.mController.xRr, "webview", ".ui.tools.WebViewUI", intent);
                return true;
            } else if (str.equals("settings_quit_wechat")) {
                h.a(this.mController.xRr, R.l.euL, R.l.euK, R.l.dHo, R.l.dGc, new OnClickListener() {
                    private al hJi = null;
                    private e hRg = null;

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        com.tencent.mm.modelstat.c.SV().SW();
                        as.Hm();
                        if (c.Fa()) {
                            n CN = as.CN();
                            e anonymousClass1 = new e() {
                                public final void a(int i, int i2, String str, k kVar) {
                                    as.CN().b(281, AnonymousClass2.this.hRg);
                                    AnonymousClass2.this.hRg = null;
                                    if (AnonymousClass2.this.hJi != null) {
                                        AnonymousClass2.this.hJi.TN();
                                        AnonymousClass2.this.hJi = null;
                                    }
                                    if (SettingsAboutMicroMsgUI.this.qob != null) {
                                        SettingsAboutMicroMsgUI.this.qob.dismiss();
                                    }
                                    SettingsAboutMicroMsgUI.b(SettingsAboutMicroMsgUI.this);
                                }
                            };
                            this.hRg = anonymousClass1;
                            CN.a(281, anonymousClass1);
                            final k amVar = new am(2);
                            as.CN().a(amVar, 0);
                            this.hJi = new al(new a() {
                                public final boolean uG() {
                                    as.CN().c(amVar);
                                    as.CN().b(281, AnonymousClass2.this.hRg);
                                    AnonymousClass2.this.hRg = null;
                                    if (AnonymousClass2.this.hJi != null) {
                                        AnonymousClass2.this.hJi.TN();
                                        AnonymousClass2.this.hJi = null;
                                    }
                                    if (SettingsAboutMicroMsgUI.this.qob != null) {
                                        SettingsAboutMicroMsgUI.this.qob.dismiss();
                                    }
                                    SettingsAboutMicroMsgUI.b(SettingsAboutMicroMsgUI.this);
                                    return false;
                                }
                            }, false);
                            this.hJi.K(5000, 5000);
                            SettingsAboutMicroMsgUI settingsAboutMicroMsgUI = SettingsAboutMicroMsgUI.this;
                            Context context = SettingsAboutMicroMsgUI.this.mController.xRr;
                            SettingsAboutMicroMsgUI.this.getString(R.l.dGZ);
                            settingsAboutMicroMsgUI.qob = h.a(context, SettingsAboutMicroMsgUI.this.getString(R.l.eXC), true, new OnCancelListener() {
                                public final void onCancel(DialogInterface dialogInterface) {
                                    as.CN().c(amVar);
                                    as.CN().b(281, AnonymousClass2.this.hRg);
                                    AnonymousClass2.this.hRg = null;
                                    if (AnonymousClass2.this.hJi != null) {
                                        AnonymousClass2.this.hJi.TN();
                                        AnonymousClass2.this.hJi = null;
                                    }
                                    if (SettingsAboutMicroMsgUI.this.qob != null) {
                                        SettingsAboutMicroMsgUI.this.qob.dismiss();
                                    }
                                }
                            });
                            return;
                        }
                        SettingsAboutMicroMsgUI.b(SettingsAboutMicroMsgUI.this);
                    }
                }, null);
                return true;
            } else if (!str.equals("funtion_crowdtest_update")) {
                return false;
            } else {
                com.tencent.mm.r.c.Bx().aS(262157, 266263);
                as.Hm();
                str = (String) c.Db().get(com.tencent.mm.storage.w.a.USERINFO_CROWDTEST_APPLY_LINK_STRING, null);
                intent = new Intent();
                intent.putExtra("rawUrl", str);
                intent.putExtra("showShare", false);
                intent.putExtra("show_bottom", false);
                com.tencent.mm.bl.d.b(this.mController.xRr, "webview", ".ui.tools.WebViewUI", intent);
                return true;
            }
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
        x.d("MicroMsg.SettingsAboutMicroMsgUI", "onSceneEnd " + i2 + " errType " + i);
        t tVar = (t) kVar;
        x.d("MicroMsg.SettingsAboutMicroMsgUI", "updateInfo.getDownloadUrls() " + tVar.bYO());
        x.d("MicroMsg.SettingsAboutMicroMsgUI", "updateInfo.getPackVersion() " + tVar.bYN());
        x.d("MicroMsg.SettingsAboutMicroMsgUI", "updateInfo.now getPackVersion() " + d.vHl);
        if (q.x.vjk || (i == 0 && i2 == 0)) {
            this.qnZ = tVar.bYN();
            if (this.qnZ <= 0 || this.qnZ <= d.vHl) {
                this.qnX = false;
                if (g.Do().CF()) {
                    com.tencent.mm.r.c.Bx().o(262145, false);
                } else {
                    x.e("MicroMsg.SettingsAboutMicroMsgUI", "SubCoreHub.getNewBadge() uin not ready!");
                }
            } else {
                this.qnX = true;
                if (g.Do().CF()) {
                    com.tencent.mm.r.c.Bx().o(262145, true);
                } else {
                    x.e("MicroMsg.SettingsAboutMicroMsgUI", "SubCoreHub.getNewBadge() uin not ready!");
                }
            }
            this.qnY = tVar.bYP();
        }
        brh();
    }
}
