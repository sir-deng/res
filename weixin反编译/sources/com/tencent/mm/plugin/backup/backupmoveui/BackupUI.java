package com.tencent.mm.plugin.backup.backupmoveui;

import android.content.Intent;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Looper;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.backup.a.d;
import com.tencent.mm.plugin.backup.a.g;
import com.tencent.mm.plugin.backup.c.b;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.al.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMWizardActivity;

public class BackupUI extends MMWizardActivity {
    private static boolean ksz = false;
    private al krE = new al(Looper.getMainLooper(), new a() {
        public final boolean uG() {
            if (bi.oN(g.cm(BackupUI.this))) {
                if (BackupUI.ksz) {
                    BackupUI.this.ksn.setText(R.l.dJZ);
                    BackupUI.this.ksn.setTextColor(BackupUI.this.getResources().getColor(R.e.brw));
                    BackupUI.this.ksy.setEnabled(false);
                    BackupUI.ksz = false;
                    com.tencent.mm.plugin.report.service.g.pWK.h(11788, Integer.valueOf(2));
                }
            } else if (!BackupUI.ksz) {
                BackupUI.this.ksn.setText(R.l.dKa);
                BackupUI.this.ksn.setTextColor(BackupUI.this.getResources().getColor(R.e.brv));
                BackupUI.this.ksy.setEnabled(true);
                BackupUI.ksz = true;
            }
            return true;
        }
    }, true);
    private TextView ksl;
    private TextView ksn;
    private Button ksy;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!getIntent().getExtras().getBoolean("WizardRootKillSelf", false)) {
            setMMTitle(R.l.dwa);
            com.tencent.mm.plugin.report.service.g.pWK.h(11788, Integer.valueOf(1));
            this.ksn = (TextView) findViewById(R.h.bMp);
            this.ksy = (Button) findViewById(R.h.bMl);
            this.ksl = (TextView) findViewById(R.h.bMk);
            b.apy();
            Editor edit = d.aoX().edit();
            edit.putInt("BACKUP_MOVE_CHOOSE_SELECT_TIME_MODE", 0);
            edit.putInt("BACKUP_MOVE_CHOOSE_SELECT_CONTENT_TYPE", 0);
            edit.putLong("BACKUP_MOVE_CHOOSE_SELECT_START_TIME", 0);
            edit.putLong("BACKUP_MOVE_CHOOSE_SELECT_END_TIME", 0);
            edit.commit();
            if (b.apy().apC().kqs) {
                b.apy().apC().apx();
            } else {
                com.tencent.mm.plugin.backup.c.a apC = b.apy().apC();
                com.tencent.mm.plugin.backup.g.d.aqL().aqO();
                e.post(new Runnable() {
                    public final void run() {
                        if (a.this.kqm != null) {
                            a.this.kqm.cancel();
                        }
                        a.this.kqm = new com.tencent.mm.plugin.backup.b.b();
                        if (a.this.apt() == null || a.this.apt().size() == 0) {
                            x.e("MicroMsg.BackupMoveChooseServer", "backupSessionInfo is null or nill!");
                            a.this.kqm.a(a.this);
                        }
                    }
                }, "BakMoveChooseServer.calculateToChoose");
            }
            if (bi.oN(g.cm(this))) {
                this.ksn.setText(R.l.dJZ);
                this.ksn.setTextColor(getResources().getColor(R.e.brw));
                this.ksy.setEnabled(false);
                ksz = false;
                com.tencent.mm.plugin.report.service.g.pWK.h(11788, Integer.valueOf(2));
            } else {
                this.ksn.setText(R.l.dKa);
                this.ksn.setTextColor(getResources().getColor(R.e.brv));
                this.ksy.setEnabled(true);
                ksz = true;
            }
            this.ksy.setOnClickListener(new OnClickListener() {
                /* JADX WARNING: inconsistent code. */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public final void onClick(android.view.View r12) {
                    /*
                    r11 = this;
                    r6 = 1;
                    r4 = 335544320; // 0x14000000 float:6.4623485E-27 double:1.65780921E-315;
                    r10 = 1;
                    r3 = -100;
                    r8 = 0;
                    com.tencent.mm.y.as.Hm();
                    r0 = com.tencent.mm.y.c.Db();
                    r1 = com.tencent.mm.storage.w.a.USERINFO_BACKUP_MOVE_RECOVERING_BOOLEAN;
                    r2 = java.lang.Boolean.valueOf(r8);
                    r0 = r0.get(r1, r2);
                    r0 = (java.lang.Boolean) r0;
                    r0 = r0.booleanValue();
                    if (r0 == 0) goto L_0x003d;
                L_0x0021:
                    r0 = com.tencent.mm.plugin.backup.c.b.apy();
                    r0 = r0.aoS();
                    r0 = r0.kov;
                    if (r0 != r3) goto L_0x00d2;
                L_0x002d:
                    com.tencent.mm.y.as.Hm();
                    r0 = com.tencent.mm.y.c.Db();
                    r1 = com.tencent.mm.storage.w.a.USERINFO_BACKUP_MOVE_RECOVERING_BOOLEAN;
                    r2 = java.lang.Boolean.valueOf(r8);
                    r0.a(r1, r2);
                L_0x003d:
                    com.tencent.mm.y.as.Hm();
                    r0 = com.tencent.mm.y.c.Db();
                    r1 = com.tencent.mm.storage.w.a.USERINFO_BACKUP_PC_BACKUPING_BOOLEAN;
                    r2 = java.lang.Boolean.valueOf(r8);
                    r0 = r0.get(r1, r2);
                    r0 = (java.lang.Boolean) r0;
                    r0 = r0.booleanValue();
                    if (r0 != 0) goto L_0x006f;
                L_0x0056:
                    com.tencent.mm.y.as.Hm();
                    r0 = com.tencent.mm.y.c.Db();
                    r1 = com.tencent.mm.storage.w.a.USERINFO_BACKUP_PC_RECOVERING_BOOLEAN;
                    r2 = java.lang.Boolean.valueOf(r8);
                    r0 = r0.get(r1, r2);
                    r0 = (java.lang.Boolean) r0;
                    r0 = r0.booleanValue();
                    if (r0 == 0) goto L_0x009b;
                L_0x006f:
                    r0 = com.tencent.mm.plugin.backup.backuppcmodel.b.apZ();
                    r0 = r0.aoS();
                    r0 = r0.kov;
                    if (r0 != r3) goto L_0x00f6;
                L_0x007b:
                    com.tencent.mm.y.as.Hm();
                    r0 = com.tencent.mm.y.c.Db();
                    r1 = com.tencent.mm.storage.w.a.USERINFO_BACKUP_PC_BACKUPING_BOOLEAN;
                    r2 = java.lang.Boolean.valueOf(r8);
                    r0.a(r1, r2);
                    com.tencent.mm.y.as.Hm();
                    r0 = com.tencent.mm.y.c.Db();
                    r1 = com.tencent.mm.storage.w.a.USERINFO_BACKUP_PC_RECOVERING_BOOLEAN;
                    r2 = java.lang.Boolean.valueOf(r8);
                    r0.a(r1, r2);
                L_0x009b:
                    r9 = com.tencent.mm.plugin.backup.a.g.apd();
                    r0 = 50;
                    if (r9 >= r0) goto L_0x011a;
                L_0x00a3:
                    r1 = com.tencent.mm.plugin.report.service.g.pWK;
                    r2 = 485; // 0x1e5 float:6.8E-43 double:2.396E-321;
                    r4 = 7;
                    r1.a(r2, r4, r6, r8);
                    r0 = com.tencent.mm.plugin.report.service.g.pWK;
                    r1 = 11787; // 0x2e0b float:1.6517E-41 double:5.8236E-320;
                    r2 = new java.lang.Object[r10];
                    r3 = 4;
                    r3 = java.lang.Integer.valueOf(r3);
                    r2[r8] = r3;
                    r0.h(r1, r2);
                    r0 = com.tencent.mm.plugin.backup.backupmoveui.BackupUI.this;
                    r1 = com.tencent.mm.R.l.dHS;
                    r2 = com.tencent.mm.R.l.dHR;
                    r3 = com.tencent.mm.R.l.dKb;
                    r4 = com.tencent.mm.R.l.dHz;
                    r5 = new com.tencent.mm.plugin.backup.backupmoveui.BackupUI$1$1;
                    r5.<init>(r9);
                    r6 = 0;
                    r7 = com.tencent.mm.R.e.brv;
                    com.tencent.mm.ui.base.h.a(r0, r1, r2, r3, r4, r5, r6, r7);
                L_0x00d1:
                    return;
                L_0x00d2:
                    r0 = new android.content.Intent;
                    r0.<init>();
                    r1 = com.tencent.mm.sdk.platformtools.ad.getContext();
                    r2 = "com.tencent.mm.ui.LauncherUI";
                    r0 = r0.setClassName(r1, r2);
                    r0.addFlags(r4);
                    r1 = "nofification_type";
                    r2 = "backup_move_notification";
                    r0.putExtra(r1, r2);
                    r1 = com.tencent.mm.sdk.platformtools.ad.getContext();
                    r1.startActivity(r0);
                    goto L_0x00d1;
                L_0x00f6:
                    r0 = new android.content.Intent;
                    r0.<init>();
                    r1 = com.tencent.mm.sdk.platformtools.ad.getContext();
                    r2 = "com.tencent.mm.ui.LauncherUI";
                    r0 = r0.setClassName(r1, r2);
                    r0.addFlags(r4);
                    r1 = "nofification_type";
                    r2 = "back_to_pcmgr_notification";
                    r0.putExtra(r1, r2);
                    r1 = com.tencent.mm.sdk.platformtools.ad.getContext();
                    r1.startActivity(r0);
                    goto L_0x00d1;
                L_0x011a:
                    r1 = com.tencent.mm.plugin.report.service.g.pWK;
                    r2 = 485; // 0x1e5 float:6.8E-43 double:2.396E-321;
                    r4 = 21;
                    r1.a(r2, r4, r6, r8);
                    r0 = com.tencent.mm.plugin.report.service.g.pWK;
                    r1 = 11788; // 0x2e0c float:1.6519E-41 double:5.824E-320;
                    r2 = new java.lang.Object[r10];
                    r3 = 3;
                    r3 = java.lang.Integer.valueOf(r3);
                    r2[r8] = r3;
                    r0.h(r1, r2);
                    r0 = new android.content.Intent;
                    r1 = com.tencent.mm.plugin.backup.backupmoveui.BackupUI.this;
                    r2 = com.tencent.mm.plugin.backup.backupmoveui.BackupMoveChooseUI.class;
                    r0.<init>(r1, r2);
                    r1 = com.tencent.mm.plugin.backup.backupmoveui.BackupUI.this;
                    com.tencent.mm.ui.MMWizardActivity.A(r1, r0);
                    goto L_0x00d1;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.backup.backupmoveui.BackupUI.1.onClick(android.view.View):void");
                }
            });
            this.ksl.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    Intent intent = new Intent();
                    intent.putExtra("title", BackupUI.this.getString(R.l.dIS));
                    intent.putExtra("rawUrl", BackupUI.this.getString(R.l.dJQ, new Object[]{w.cfV()}));
                    intent.putExtra("showShare", false);
                    intent.putExtra("neverGetA8Key", true);
                    com.tencent.mm.bl.d.b(BackupUI.this, "webview", ".ui.tools.WebViewUI", intent);
                }
            });
            setBackBtn(new OnMenuItemClickListener() {
                public final boolean onMenuItemClick(MenuItem menuItem) {
                    BackupUI.this.finish();
                    return true;
                }
            });
        }
    }

    public void onStart() {
        super.onStart();
        this.krE.K(5000, 5000);
    }

    public void onStop() {
        super.onStop();
        this.krE.TN();
    }

    public void onDestroy() {
        x.d("MicroMsg.BackupUI", "BackupUI onDestroy.");
        super.onDestroy();
        b.apy().apC().cancel();
        b.apy().apC().apw();
    }

    protected final int getLayoutId() {
        return R.i.daX;
    }
}
