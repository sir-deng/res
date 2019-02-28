package com.tencent.mm.plugin.appbrand.ui;

import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager.LayoutParams;
import com.tencent.mm.plugin.appbrand.debugger.DebuggerShell;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.ui.tools.j;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.r;
import com.tencent.mm.ui.e;
import com.tencent.xweb.util.b;
import com.tencent.xweb.x5.sdk.d;
import com.tencent.xweb.x5.sdk.f;
import com.tencent.xweb.x5.sdk.h;

@com.tencent.mm.ui.base.a(7)
public final class AppBrandTBSDownloadProxyUI extends MMActivity {
    private static boolean jSo = false;
    private a jSm = null;
    private Runnable jSn;
    private Handler mHandler;
    r tipDialog;

    private final class a implements h {
        private a() {
        }

        /* synthetic */ a(AppBrandTBSDownloadProxyUI appBrandTBSDownloadProxyUI, byte b) {
            this();
        }

        public final void lQ(int i) {
            x.i("MicroMsg.AppBrandTBSDownloadProxyUI", "onDownloadFinish, result = %d", Integer.valueOf(i));
            j.eE(5, i);
            if (i == 100 || i == 120 || i == 122) {
                g.pWK.a(366, 4, 1, false);
            } else {
                g.pWK.a(366, 5, 1, false);
            }
            SharedPreferences sharedPreferences;
            Editor edit;
            if (i != 110) {
                if (i == 100 || i == 120 || i == 122) {
                    g.pWK.a(64, 64, 4, 3, 1, 1, false);
                } else {
                    AppBrandTBSDownloadProxyUI.this.jSm = null;
                    d.a(AppBrandTBSDownloadProxyUI.this.jSm);
                    g.pWK.a(64, 3, 1, false);
                    AppBrandTBSDownloadProxyUI.this.setResult(0, new Intent());
                    AppBrandTBSDownloadProxyUI.this.finish();
                }
                sharedPreferences = ad.getContext().getSharedPreferences("com.tencent.mm_webview_x5_preferences", 4);
                if (sharedPreferences != null) {
                    x.i("MicroMsg.AppBrandTBSDownloadProxyUI", "tbs has download finished, save to sharedpreference");
                    edit = sharedPreferences.edit();
                    edit.putBoolean("tbs_download_finished", true);
                    edit.apply();
                    return;
                }
                return;
            }
            sharedPreferences = ad.getContext().getSharedPreferences("com.tencent.mm_webview_x5_preferences", 4);
            if (sharedPreferences != null) {
                x.i("MicroMsg.AppBrandTBSDownloadProxyUI", "tbs has download finished, save to sharedpreference");
                edit = sharedPreferences.edit();
                edit.putBoolean("tbs_download_finished", true);
                edit.apply();
            }
            AppBrandTBSDownloadProxyUI.this.jSm = null;
            d.a(AppBrandTBSDownloadProxyUI.this.jSm);
            AppBrandTBSDownloadProxyUI.this.setResult(0, new Intent());
            AppBrandTBSDownloadProxyUI.this.finish();
        }

        public final void lR(int i) {
            x.i("MicroMsg.AppBrandTBSDownloadProxyUI", "onInstallFinish, result = %d", Integer.valueOf(i));
            if (AppBrandTBSDownloadProxyUI.this.tipDialog != null) {
                AppBrandTBSDownloadProxyUI.this.tipDialog.dismiss();
                AppBrandTBSDownloadProxyUI.this.tipDialog = null;
            }
            j.eE(6, i);
            if (i == 200 || i == 220) {
                g.pWK.a(64, 64, 7, 6, 1, 1, false);
                g.pWK.a(366, 6, 1, false);
                x.i("MicroMsg.AppBrandTBSDownloadProxyUI", "onInstallFinish, restart tool");
                Intent intent = new Intent();
                intent.setComponent(new ComponentName(e.h.xMS, "com.tencent.mm.booter.MMReceivers$ToolsProcessReceiver"));
                intent.putExtra("tools_process_action_code_key", "com.tencent.mm.intent.ACTION_START_TOOLS_PROCESS");
                AppBrandTBSDownloadProxyUI.this.sendBroadcast(intent);
                AppBrandTBSDownloadProxyUI.this.jSm = null;
                d.a(AppBrandTBSDownloadProxyUI.this.jSm);
                AppBrandTBSDownloadProxyUI.this.setResult(-1, new Intent());
                AppBrandTBSDownloadProxyUI.this.finish();
                return;
            }
            g.pWK.a(64, 6, 1, false);
            g.pWK.a(366, 7, 1, false);
            AppBrandTBSDownloadProxyUI.this.jSm = null;
            d.a(AppBrandTBSDownloadProxyUI.this.jSm);
            AppBrandTBSDownloadProxyUI.this.setResult(0, new Intent());
            AppBrandTBSDownloadProxyUI.this.finish();
        }

        public final void lg(final int i) {
            x.i("MicroMsg.AppBrandTBSDownloadProxyUI", "onDownloadProgress, percent = %d", Integer.valueOf(i));
            if (AppBrandTBSDownloadProxyUI.this.tipDialog != null) {
                ah.y(new Runnable() {
                    public final void run() {
                        AppBrandTBSDownloadProxyUI.this.tipDialog.setMessage(AppBrandTBSDownloadProxyUI.this.mController.xRr.getString(q.j.iDV, new Object[]{String.valueOf(i)}));
                    }
                });
            }
        }
    }

    static /* synthetic */ void a(AppBrandTBSDownloadProxyUI appBrandTBSDownloadProxyUI) {
        if (!appBrandTBSDownloadProxyUI.isFinishing() && !appBrandTBSDownloadProxyUI.xQV) {
            OnClickListener anonymousClass6 = new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    g.pWK.a(366, 2, 1, false);
                    com.tencent.mm.pluginsdk.model.x.a.kY(false);
                    j.qq(2);
                    if (!AppBrandTBSDownloadProxyUI.this.isFinishing() && !AppBrandTBSDownloadProxyUI.this.xQV) {
                        AppBrandTBSDownloadProxyUI appBrandTBSDownloadProxyUI = AppBrandTBSDownloadProxyUI.this;
                        Context context = AppBrandTBSDownloadProxyUI.this.mController.xRr;
                        AppBrandTBSDownloadProxyUI.this.mController.xRr.getString(q.j.dGZ);
                        appBrandTBSDownloadProxyUI.tipDialog = com.tencent.mm.ui.base.h.a(context, AppBrandTBSDownloadProxyUI.this.mController.xRr.getString(q.j.iDU), true, null);
                        AppBrandTBSDownloadProxyUI.this.tipDialog.setOnCancelListener(new OnCancelListener() {
                            public final void onCancel(DialogInterface dialogInterface) {
                                x.i("MicroMsg.AppBrandTBSDownloadProxyUI", "cancel loading download background");
                                AppBrandTBSDownloadProxyUI.this.setResult(2, new Intent());
                                AppBrandTBSDownloadProxyUI.this.finish();
                            }
                        });
                        AppBrandTBSDownloadProxyUI.b(AppBrandTBSDownloadProxyUI.this);
                        AppBrandTBSDownloadProxyUI.this.alw();
                    }
                }
            };
            if (DebuggerShell.acx()) {
                anonymousClass6.onClick(null, 0);
                return;
            }
            OnClickListener anonymousClass7 = new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    g.pWK.a(366, 3, 1, false);
                    x.i("MicroMsg.AppBrandTBSDownloadProxyUI", "user cancel");
                    com.tencent.mm.pluginsdk.model.x.a.kY(false);
                    AppBrandTBSDownloadProxyUI.this.setResult(2, new Intent());
                    AppBrandTBSDownloadProxyUI.this.finish();
                }
            };
            com.tencent.mm.ui.base.i.a aVar = new com.tencent.mm.ui.base.i.a(appBrandTBSDownloadProxyUI.mController.xRr);
            aVar.Zn(appBrandTBSDownloadProxyUI.mController.xRr.getString(q.j.iDT));
            aVar.mp(false);
            aVar.EV(q.j.iDS).a(anonymousClass6);
            aVar.EW(q.j.iDR).b(anonymousClass7);
            aVar.ale().show();
            com.tencent.mm.pluginsdk.model.x.a.kY(true);
            g.pWK.a(366, 1, 1, false);
        }
    }

    static /* synthetic */ void b(AppBrandTBSDownloadProxyUI appBrandTBSDownloadProxyUI) {
        if (appBrandTBSDownloadProxyUI.jSm == null) {
            appBrandTBSDownloadProxyUI.jSm = new a(appBrandTBSDownloadProxyUI, (byte) 0);
        }
        d.a(appBrandTBSDownloadProxyUI.jSm);
        j.qq(3);
        f.t(ad.getContext(), true);
    }

    static {
        x.i("MicroMsg.AppBrandTBSDownloadProxyUI", "TRACE_ORDER:AppBrandTBSDownloadProxyUI.java");
        com.tencent.xweb.r.a(ad.getContext(), new b() {
            public final void i(String str, String str2) {
                x.i(str, str2);
            }

            public final void e(String str, String str2) {
                x.e(str, str2);
            }

            public final void w(String str, String str2) {
                x.w(str, str2);
            }

            public final void d(String str, String str2) {
                x.d(str, str2);
            }

            public final void v(String str, String str2) {
                x.v(str, str2);
            }
        }, null, null);
    }

    protected final int getLayoutId() {
        return -1;
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        x.i("MicroMsg.AppBrandTBSDownloadProxyUI", "onCreate");
        this.tipDialog = com.tencent.mm.ui.base.h.a(this.mController.xRr, null, true, null);
        this.tipDialog.setOnCancelListener(new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                x.i("MicroMsg.AppBrandTBSDownloadProxyUI", "cancle loading download background");
                AppBrandTBSDownloadProxyUI.this.setResult(2, new Intent());
                AppBrandTBSDownloadProxyUI.this.finish();
            }
        });
        j.a(getWindow());
        x.i("MicroMsg.AppBrandTBSDownloadProxyUI", "onCreate, kill tool");
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(e.h.xMS, "com.tencent.mm.booter.MMReceivers$ToolsProcessReceiver"));
        intent.putExtra("tools_process_action_code_key", "com.tencent.mm.intent.ACTION_KILL_TOOLS_PROCESS");
        sendBroadcast(intent);
        boolean isDownloading = f.isDownloading();
        boolean tBSInstalling = d.getTBSInstalling();
        boolean cFl = f.cFl();
        x.i("MicroMsg.AppBrandTBSDownloadProxyUI", "now status, downloading = %b, installing = %b", Boolean.valueOf(isDownloading), Boolean.valueOf(tBSInstalling));
        if (isDownloading || tBSInstalling) {
            if (cFl) {
                x.i("MicroMsg.AppBrandTBSDownloadProxyUI", "is foreground download");
                if (jSo) {
                    setResult(0, new Intent());
                    finish();
                    return;
                }
                if (this.jSm == null) {
                    this.jSm = new a();
                }
                d.a(this.jSm);
                x.i("MicroMsg.AppBrandTBSDownloadProxyUI", "is foreground download TBS already downloading, ignore duplicated request");
                Context context = this.mController.xRr;
                this.mController.xRr.getString(q.j.dGZ);
                this.tipDialog = com.tencent.mm.ui.base.h.a(context, this.mController.xRr.getString(q.j.iDU), true, null);
                if (this.tipDialog.getWindow() != null) {
                    LayoutParams attributes = this.tipDialog.getWindow().getAttributes();
                    attributes.dimAmount = 0.0f;
                    this.tipDialog.getWindow().setAttributes(attributes);
                }
                this.tipDialog.setOnCancelListener(new OnCancelListener() {
                    public final void onCancel(DialogInterface dialogInterface) {
                        x.i("MicroMsg.AppBrandTBSDownloadProxyUI", "cancle loading download background");
                        AppBrandTBSDownloadProxyUI.this.setResult(2, new Intent());
                        AppBrandTBSDownloadProxyUI.this.finish();
                    }
                });
                alw();
                return;
            }
            x.i("MicroMsg.AppBrandTBSDownloadProxyUI", "isBackGroundDownload reset download");
            f.stopDownload();
        }
        x.i("MicroMsg.AppBrandTBSDownloadProxyUI", "try to get need download");
        f.a(this.mController.xRr, false, true, new com.tencent.xweb.x5.sdk.f.a() {
            public final void g(boolean z, int i) {
                if (!z || i < 36824) {
                    x.i("MicroMsg.AppBrandTBSDownloadProxyUI", "try to get need download fail result %s version %d", Boolean.valueOf(z), Integer.valueOf(i));
                    AppBrandTBSDownloadProxyUI.this.setResult(0, new Intent());
                    AppBrandTBSDownloadProxyUI.this.finish();
                    return;
                }
                x.i("MicroMsg.AppBrandTBSDownloadProxyUI", "try to get need download success result %s version %d", Boolean.valueOf(z), Integer.valueOf(i));
                ah.y(new Runnable() {
                    public final void run() {
                        x.i("MicroMsg.AppBrandTBSDownloadProxyUI", "onNeedDownloadFinish : showDialog");
                        AppBrandTBSDownloadProxyUI.a(AppBrandTBSDownloadProxyUI.this);
                    }
                });
            }
        });
    }

    private void alw() {
        this.mHandler = new Handler();
        this.jSn = new Runnable() {
            public final void run() {
                AppBrandTBSDownloadProxyUI.jSo = true;
                AppBrandTBSDownloadProxyUI.this.setResult(0, new Intent());
                AppBrandTBSDownloadProxyUI.this.finish();
            }
        };
        this.mHandler.postDelayed(this.jSn, 20000);
    }

    protected final void onDestroy() {
        x.i("MicroMsg.AppBrandTBSDownloadProxyUI", "onDestroy");
        if (!(this.mHandler == null || this.jSn == null)) {
            this.mHandler.removeCallbacks(this.jSn);
        }
        super.onDestroy();
    }
}
