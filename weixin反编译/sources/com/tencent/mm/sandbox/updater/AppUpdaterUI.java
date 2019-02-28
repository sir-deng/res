package com.tencent.mm.sandbox.updater;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.h;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sandbox.monitor.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.base.i;
import com.tencent.mm.ui.base.i.a;
import com.tencent.wcdb.database.SQLiteDatabase;

public class AppUpdaterUI extends MMBaseActivity {
    private static AppUpdaterUI xkF = null;
    private Button kxL;
    private i pDT = null;
    private OnClickListener xkB = new OnClickListener() {
        public final void onClick(DialogInterface dialogInterface, int i) {
            x.d("MicroMsg.AppUpdaterUI", "getBtn (ok button) is click");
            if (AppUpdaterUI.this.xkG.rAU == 1) {
                i.af(AppUpdaterUI.this, 6);
            }
            if (!h.getExternalStorageState().equals("mounted")) {
                x.e("MicroMsg.AppUpdaterUI", "no sdcard.");
                AppUpdaterUI.this.pDT.dismiss();
                AppUpdaterUI.c(AppUpdaterUI.this);
            } else if ((AppUpdaterUI.this.xkG.fek & 1) != 0) {
                x.e("MicroMsg.AppUpdaterUI", "package has set external update mode");
                Uri parse = Uri.parse(AppUpdaterUI.this.xkG.fem);
                Intent addFlags = new Intent("android.intent.action.VIEW", parse).addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                if (parse == null || addFlags == null || !bi.k(AppUpdaterUI.this, addFlags)) {
                    x.e("MicroMsg.AppUpdaterUI", "parse market uri failed, jump to weixin.qq.com");
                    AppUpdaterUI.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("http://weixin.qq.com")).addFlags(SQLiteDatabase.CREATE_IF_NECESSARY));
                } else {
                    x.i("MicroMsg.AppUpdaterUI", "parse market uri ok");
                    AppUpdaterUI.this.startActivity(addFlags);
                }
                AppUpdaterUI.this.ceY();
            } else {
                String bf = c.bf(AppUpdaterUI.this.xkG.frM, AppUpdaterUI.this.xkG.xlW);
                if (bi.oN(bf) && AppUpdaterUI.this.xkG.xlR != null) {
                    bf = c.Vi(AppUpdaterUI.this.xkG.xlR.feA);
                }
                x.d("MicroMsg.AppUpdaterUI", bf);
                if (bf != null) {
                    x.i("MicroMsg.AppUpdaterUI", "update package already exist.");
                    i.ae(AppUpdaterUI.this, 8);
                    if (AppUpdaterUI.this.xkG.xlS) {
                        i.ae(AppUpdaterUI.this, 0);
                    } else {
                        i.ae(AppUpdaterUI.this, 9);
                    }
                    AppUpdaterUI.this.xkG.ad(1, true);
                    AppUpdaterUI.this.xkH.LD(bf);
                    return;
                }
                x.d("MicroMsg.AppUpdaterUI", "current downloadMode : %s", Integer.valueOf(AppUpdaterUI.this.xkG.rAU));
                x.d("MicroMsg.AppUpdaterUI", "current updateType : %s", Integer.valueOf(AppUpdaterUI.this.xkG.xku));
                if (AppUpdaterUI.this.xkG.rAU == 0) {
                    AppUpdaterUI.this.xkG.cfp();
                } else if (AppUpdaterUI.this.xkG.rAU == 1) {
                    x.d("MicroMsg.AppUpdaterUI", "gonna start UpdaterService");
                    AppUpdaterUI.this.ceY();
                    Intent intent = new Intent(AppUpdaterUI.this.getIntent());
                    intent.setClass(AppUpdaterUI.this, UpdaterService.class);
                    intent.putExtra("intent_extra_run_in_foreground", true);
                    AppUpdaterUI.this.startService(intent);
                    if (AppUpdaterUI.this.xkG.xlW) {
                        g.pWK.a(614, 56, 1, false);
                        x.d("MicroMsg.AppUpdaterUI", "boots download start.");
                    }
                } else {
                    x.e("MicroMsg.AppUpdaterUI", "silence download never go here!");
                }
            }
        }
    };
    private Button xkE;
    private j xkG;
    private g xkH = new g() {
        public final void bK(int i, int i2) {
            int i3 = (int) (i <= 0 ? 0 : (((long) i2) * 100) / ((long) i));
            if (i3 == 100) {
                AppUpdaterUI.this.xkE.setText(AppUpdaterUI.this.getString(R.l.eSp));
            } else {
                AppUpdaterUI.this.xkE.setText(AppUpdaterUI.this.getString(R.l.eSn) + i3 + "%");
            }
        }

        public final void ceZ() {
            x.e("MicroMsg.AppUpdaterUI", "no sdcard.");
            if (AppUpdaterUI.this.pDT != null) {
                AppUpdaterUI.this.pDT.dismiss();
            }
            if (!AppUpdaterUI.this.isFinishing()) {
                AppUpdaterUI.c(AppUpdaterUI.this);
            }
        }

        public final void cfa() {
            if (AppUpdaterUI.this.pDT != null) {
                AppUpdaterUI.this.pDT.dismiss();
            }
            if (!AppUpdaterUI.this.isFinishing()) {
                AppUpdaterUI.d(AppUpdaterUI.this);
            }
        }

        public final void bxM() {
            if (!AppUpdaterUI.this.isFinishing()) {
                AppUpdaterUI.this.xkE.setText(R.l.eSn);
                AppUpdaterUI.this.xkE.setEnabled(false);
            }
        }

        public final void LD(String str) {
            if (AppUpdaterUI.this.pDT != null) {
                AppUpdaterUI.this.pDT.dismiss();
            }
            if (!AppUpdaterUI.this.isFinishing()) {
                x.d("MicroMsg.AppUpdaterUI", str);
                if (str != null) {
                    AppUpdaterUI.a(AppUpdaterUI.this, str);
                    AppUpdaterUI.this.xkE.setEnabled(false);
                }
            }
        }

        public final void a(c cVar) {
            if (!AppUpdaterUI.this.isFinishing()) {
                if (cVar instanceof c) {
                    g.pWK.a(405, 67, 1, true);
                    x.e("MicroMsg.AppUpdaterUI", "download package from cdn error. switch to webserver");
                    if (AppUpdaterUI.this.pDT != null) {
                        AppUpdaterUI.this.pDT.setMessage(AppUpdaterUI.this.getString(R.l.ejE, new Object[]{AppUpdaterUI.this.xkG.desc, AppUpdaterUI.this.getString(R.l.eSk), bi.by((long) AppUpdaterUI.this.xkG.size)}));
                    }
                    if (AppUpdaterUI.this.xkG.xlS) {
                        g.pWK.a(405, 68, 1, true);
                        AppUpdaterUI.a(AppUpdaterUI.this, cVar);
                        return;
                    }
                    return;
                }
                g.pWK.a(405, 69, 1, true);
                com.tencent.mm.ui.base.h.a(AppUpdaterUI.this, R.l.eSl, R.l.dGZ, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        x.d("MicroMsg.AppUpdaterUI", "go to WebView");
                        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("https://weixin.qq.com/m"));
                        intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                        AppUpdaterUI.this.startActivity(intent);
                    }
                }, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
            }
        }
    };
    private OnClickListener xkI = new OnClickListener() {
        public final void onClick(DialogInterface dialogInterface, int i) {
            AppUpdaterUI.g(AppUpdaterUI.this);
        }
    };

    static /* synthetic */ void a(AppUpdaterUI appUpdaterUI, final c cVar) {
        x.d("MicroMsg.AppUpdaterUI", "showDownloadFullPackAlert()");
        i a = com.tencent.mm.ui.base.h.a((Context) appUpdaterUI, appUpdaterUI.getString(R.l.ejD, new Object[]{bi.by((long) appUpdaterUI.xkG.size)}), appUpdaterUI.getString(R.l.dGZ), new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                x.d("MicroMsg.AppUpdaterUI", "click download button");
                i.ae(AppUpdaterUI.this, 11);
                if (cVar != null) {
                    cVar.deleteTempFile();
                }
                j e = AppUpdaterUI.this.xkG;
                e.xlU = true;
                e.cfp();
            }
        });
        a.setOnCancelListener(new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                x.d("MicroMsg.AppUpdaterUI", "click cancel button");
                i.ae(AppUpdaterUI.this, 12);
                AppUpdaterUI.i(AppUpdaterUI.this);
            }
        });
        a.setCanceledOnTouchOutside(false);
    }

    static /* synthetic */ void a(AppUpdaterUI appUpdaterUI, final String str) {
        g.pWK.a(405, 70, 1, true);
        if (appUpdaterUI.xkG.xlW) {
            g.pWK.a(614, 50, 1, false);
        }
        new ag().postDelayed(new Runnable() {
            public final void run() {
                AppUpdaterUI.this.startActivity(bi.Wc(str));
                AppUpdaterUI.this.ceY();
            }
        }, 300);
    }

    static /* synthetic */ void c(AppUpdaterUI appUpdaterUI) {
        x.d("MicroMsg.AppUpdaterUI", "showNoSDCardAlert");
        g.pWK.a(405, 65, 1, true);
        com.tencent.mm.ui.base.h.a((Context) appUpdaterUI, appUpdaterUI.getString(R.l.eSq), appUpdaterUI.getString(R.l.dGZ), new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppUpdaterUI.i(AppUpdaterUI.this);
            }
        }).setOnCancelListener(new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                AppUpdaterUI.i(AppUpdaterUI.this);
            }
        });
    }

    static /* synthetic */ void d(AppUpdaterUI appUpdaterUI) {
        x.d("MicroMsg.AppUpdaterUI", "showSDCardFullAlert");
        g.pWK.a(405, 66, 1, true);
        com.tencent.mm.ui.base.h.a((Context) appUpdaterUI, appUpdaterUI.getString(R.l.eSt), appUpdaterUI.getString(R.l.dGZ), new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppUpdaterUI.i(AppUpdaterUI.this);
            }
        }).setOnCancelListener(new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                AppUpdaterUI.i(AppUpdaterUI.this);
            }
        });
    }

    static /* synthetic */ void g(AppUpdaterUI appUpdaterUI) {
        x.d("MicroMsg.AppUpdaterUI", "showDownloadCancelAlert");
        if (appUpdaterUI.xkG.xlX) {
            com.tencent.mm.ui.base.h.b(appUpdaterUI, R.l.dNy, R.l.dGZ, new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    x.d("MicroMsg.AppUpdaterUI", "update dialog had been canceled");
                    if (AppUpdaterUI.this.pDT != null && AppUpdaterUI.this.pDT.isShowing()) {
                        AppUpdaterUI.this.pDT.dismiss();
                    }
                    i.ae(AppUpdaterUI.this, 6);
                    if (AppUpdaterUI.this.xkG.xlW) {
                        g.pWK.a(614, 59, 1, true);
                        x.d("MicroMsg.AppUpdaterUI", "boots download cancel when downloading.");
                    }
                    AppUpdaterUI.this.xkG.cancel();
                    AppUpdaterUI.this.xkG.ad(2, true);
                    AppUpdaterUI.this.ceY();
                }
            }, new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    if (AppUpdaterUI.this.pDT != null && !AppUpdaterUI.this.pDT.isShowing()) {
                        AppUpdaterUI.this.pDT.show();
                    }
                }
            });
            return;
        }
        if (appUpdaterUI.xkG.rAU == 1) {
            i.af(appUpdaterUI, 7);
            if (appUpdaterUI.xkG.xlW) {
                g.pWK.a(614, 57, 1, true);
                x.d("MicroMsg.AppUpdaterUI", "boots download cancel.");
            }
        }
        i.ae(appUpdaterUI, 6);
        appUpdaterUI.xkG.ad(2, true);
        appUpdaterUI.ceY();
    }

    static /* synthetic */ void i(AppUpdaterUI appUpdaterUI) {
        appUpdaterUI.xkG.cancel();
        appUpdaterUI.xkG.ad(2, true);
        appUpdaterUI.ceY();
    }

    public static AppUpdaterUI ceW() {
        return xkF;
    }

    public static void ceX() {
        if (xkF != null) {
            xkF.ceY();
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        x.d("MicroMsg.AppUpdaterUI", "onCreate");
        com.tencent.mm.sandbox.c.h(hashCode(), this);
        MMActivity.initLanguage(this);
        if (AppInstallerUI.ceV() != null && !AppInstallerUI.ceV().isFinishing()) {
            x.d("MicroMsg.AppUpdaterUI", "AppInstallerUI is there, finish self");
            finish();
        } else if (xkF == null || xkF.isFinishing() || xkF == this) {
            xkF = this;
            setContentView(R.i.empty);
            this.xkG = a.xme;
            if (!this.xkG.ag(getIntent())) {
                x.e("MicroMsg.AppUpdaterUI", "updaterManager.handleCommand return false");
                ceY();
            } else if (this.xkG.xku != 999 || this.xkG.xkW == null || this.xkG.xkW.length <= 0) {
                String string;
                x.d("MicroMsg.AppUpdaterUI", "showUpdateDlg, downloadUrls = " + this.xkG.xkW);
                a aVar = new a(this);
                aVar.ES(R.l.ejC);
                aVar.mp(true);
                aVar.d(new OnCancelListener() {
                    public final void onCancel(DialogInterface dialogInterface) {
                        AppUpdaterUI.g(AppUpdaterUI.this);
                    }
                });
                if (!this.xkG.xlS || this.xkG.xlR == null) {
                    x.d("MicroMsg.AppUpdaterUI", "had try to download full pack.");
                    string = getString(R.l.ejE, new Object[]{this.xkG.desc, getString(R.l.eSk), bi.by((long) this.xkG.size)});
                } else {
                    string = getString(R.l.ejE, new Object[]{this.xkG.desc, getString(R.l.eSo), bi.by((long) this.xkG.xlR.size)});
                }
                int i = this.xkG.xku != 1 ? R.l.eSg : R.l.eSj;
                aVar.Zn(string);
                aVar.EV(R.l.eSs).a(false, this.xkB);
                aVar.EW(i);
                this.pDT = aVar.ale();
                this.pDT.setCanceledOnTouchOutside(false);
                this.xkE = this.pDT.getButton(-1);
                this.kxL = this.pDT.getButton(-2);
                this.pDT.show();
                if (this.xkG.rAU == 1) {
                    i.af(this, 5);
                }
                if (this.xkG.xlW) {
                    g.pWK.a(614, 60, 1, false);
                }
                j jVar = this.xkG;
                g gVar = this.xkH;
                if (gVar != null && !jVar.xlN.contains(gVar)) {
                    jVar.xlN.add(gVar);
                }
            } else {
                x.d("MicroMsg.AppUpdaterUI", "into emergency status");
                new ag().postDelayed(new Runnable() {
                    public final void run() {
                        com.tencent.mm.ui.base.h.a(AppUpdaterUI.this, AppUpdaterUI.this.xkG.desc, AppUpdaterUI.this.getString(R.l.dGZ), new OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(AppUpdaterUI.this.xkG.xkW[0]));
                                intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                                ad.getContext().startActivity(intent);
                                AppUpdaterUI.this.ceY();
                            }
                        }).setOnCancelListener(new OnCancelListener() {
                            public final void onCancel(DialogInterface dialogInterface) {
                                AppUpdaterUI.this.ceY();
                            }
                        });
                    }
                }, 100);
            }
        } else {
            x.d("MicroMsg.AppUpdaterUI", "duplicate instance, finish self");
            x.d("MicroMsg.AppUpdaterUI", "we already got one instance, does it gonna leak?");
            finish();
        }
    }

    protected void onDestroy() {
        x.d("MicroMsg.AppUpdaterUI", "onDestroy");
        com.tencent.mm.sandbox.c.i(hashCode(), this);
        if (this.xkG != null) {
            j jVar = this.xkG;
            jVar.xlN.remove(this.xkH);
        }
        if (xkF == this) {
            xkF = null;
        }
        super.onDestroy();
    }

    private void ceY() {
        if (this.pDT != null && this.pDT.isShowing()) {
            this.pDT.dismiss();
        }
        finish();
    }
}
