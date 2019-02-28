package com.tencent.mm.plugin.backup.backuppcui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.backup.a.b.c;
import com.tencent.mm.plugin.backup.a.e;
import com.tencent.mm.plugin.backup.backuppcmodel.b;
import com.tencent.mm.plugin.backup.backuppcmodel.d;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.y.as;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.DownloadResult;

@a(3)
public class BackupPcUI extends MMWizardActivity {
    private static boolean ksj = false;
    private TextView ksk;
    private TextView ksl;
    private TextView ksm;
    private TextView ksn;
    private TextView kso;
    private ImageView ksp;
    public c kue = new c() {
        public final void aoQ() {
            x.i("MicroMsg.BackupPcUI", "onBackupPcUpdateUICallback onBackupPcStart, commandMode[%d]", Integer.valueOf(b.apZ().aqa().ktp));
            switch (b.apZ().aqa().ktp) {
                case 1:
                    b.apZ().aoS().kov = 11;
                    mR(11);
                    return;
                case 2:
                    b.apZ().aoS().kov = 21;
                    mR(21);
                    return;
                case 3:
                    b.apZ().aoS().kov = 12;
                    mR(12);
                    return;
                case 4:
                    b.apZ().aoS().kov = 22;
                    mR(22);
                    return;
                default:
                    return;
            }
        }

        public final void mR(int i) {
            while (true) {
                x.i("MicroMsg.BackupPcUI", "onUpdateUIProgress backupPcState:%d", Integer.valueOf(i));
                e aoS = b.apZ().aoS();
                TextView c;
                BackupPcUI backupPcUI;
                int i2;
                Object[] objArr;
                switch (i) {
                    case -100:
                        BackupPcUI.this.En(1);
                        return;
                    case DownloadResult.CODE_CONNECTION_TIMEOUT_EXCEPTION /*-23*/:
                        aqn();
                        BackupPcUI.this.ksm.setText(R.l.dJb);
                        BackupPcUI.this.ksn.setVisibility(4);
                        BackupPcUI.this.ksk.setVisibility(4);
                        BackupPcUI.this.ksl.setVisibility(4);
                        apU();
                        return;
                    case DownloadResult.CODE_CLIENT_PROTOCOL_EXCEPTION /*-22*/:
                        aqn();
                        BackupPcUI.this.ksm.setText(R.l.dJe);
                        b.apZ().apz().stop();
                        BackupPcUI.this.ksn.setVisibility(4);
                        BackupPcUI.this.ksk.setVisibility(4);
                        BackupPcUI.this.ksl.setVisibility(4);
                        apU();
                        return;
                    case DownloadResult.CODE_URL_ERROR /*-21*/:
                        aqn();
                        BackupPcUI.this.ksm.setText(R.l.dJj);
                        BackupPcUI.this.ksn.setVisibility(4);
                        BackupPcUI.this.ksk.setVisibility(4);
                        BackupPcUI.this.ksl.setVisibility(4);
                        apU();
                        return;
                    case -13:
                        aqn();
                        BackupPcUI.this.ksm.setText(R.l.dJg);
                        b.apZ().apz().stop();
                        BackupPcUI.this.ksn.setVisibility(4);
                        BackupPcUI.this.ksk.setVisibility(4);
                        BackupPcUI.this.ksl.setVisibility(4);
                        apU();
                        return;
                    case -5:
                        aqn();
                        BackupPcUI.this.ksm.setText(R.l.dJa);
                        BackupPcUI.this.ksn.setVisibility(4);
                        BackupPcUI.this.ksk.setVisibility(4);
                        BackupPcUI.this.ksl.setVisibility(4);
                        apU();
                        return;
                    case -4:
                        if (1 == b.apZ().aqa().ktp || 3 == b.apZ().aqa().ktp) {
                            BackupPcUI.this.ksp.setImageResource(R.k.dwj);
                            BackupPcUI.this.ksm.setText(BackupPcUI.this.getString(R.l.dJR, new Object[]{Integer.valueOf(aoS.kow), Integer.valueOf(aoS.kox), "0M"}));
                            BackupPcUI.this.ksn.setText(R.l.dJf);
                            BackupPcUI.this.ksl.setText(R.l.dJN);
                            BackupPcUI.this.ksl.setOnClickListener(new OnClickListener() {
                                public final void onClick(View view) {
                                    h.a(BackupPcUI.this, R.l.dIU, R.l.dIT, R.l.dJN, R.l.dHz, new DialogInterface.OnClickListener() {
                                        public final void onClick(DialogInterface dialogInterface, int i) {
                                            x.i("MicroMsg.BackupPcUI", "user click close. stop backup.");
                                            g.pWK.a(400, 10, 1, false);
                                            b.apZ().aqb().nb(4);
                                            b.apZ().apz().stop();
                                            b.apZ().aqb().an(true);
                                            b.apZ().aoS().kov = -100;
                                            BackupPcUI.this.En(1);
                                        }
                                    }, null, R.e.brw);
                                }
                            });
                        } else if (2 == b.apZ().aqa().ktp || 4 == b.apZ().aqa().ktp) {
                            BackupPcUI.this.ksp.setImageResource(R.k.dwn);
                            BackupPcUI.this.ksm.setText(BackupPcUI.this.getString(R.l.dJA, new Object[]{Integer.valueOf(aoS.kow), Integer.valueOf(aoS.kox), "0M"}));
                            BackupPcUI.this.ksn.setText(R.l.dJk);
                            BackupPcUI.this.ksl.setText(R.l.dJP);
                            BackupPcUI.this.ksl.setOnClickListener(new OnClickListener() {
                                public final void onClick(View view) {
                                    h.a(BackupPcUI.this, R.l.dIW, R.l.dIV, R.l.dJO, R.l.dHz, new DialogInterface.OnClickListener() {
                                        public final void onClick(DialogInterface dialogInterface, int i) {
                                            x.i("MicroMsg.BackupPcUI", "user click close. stop recover.");
                                            g.pWK.a(400, 18, 1, false);
                                            b.apZ().aqc().nb(4);
                                            b.apZ().apz().stop();
                                            b.apZ().aqc().a(true, true, -100);
                                        }
                                    }, null, R.e.brw);
                                }
                            });
                        }
                        BackupPcUI.this.ksn.setTextColor(BackupPcUI.this.getResources().getColor(R.e.brw));
                        BackupPcUI.this.ksn.setVisibility(0);
                        BackupPcUI.this.ksk.setVisibility(4);
                        BackupPcUI.this.ksl.setVisibility(0);
                        apW();
                        return;
                    case -3:
                        aqn();
                        BackupPcUI.this.ksm.setText(R.l.dIZ);
                        BackupPcUI.this.ksl.setText(R.l.dJl);
                        BackupPcUI.this.ksn.setVisibility(4);
                        BackupPcUI.this.ksk.setVisibility(4);
                        BackupPcUI.this.ksl.setVisibility(0);
                        BackupPcUI.this.ksl.setOnClickListener(new OnClickListener() {
                            public final void onClick(View view) {
                                BackupPcUI.m(BackupPcUI.this);
                            }
                        });
                        apU();
                        return;
                    case -2:
                    case -1:
                        aqn();
                        BackupPcUI.this.ksm.setText(R.l.dJh);
                        String cm = com.tencent.mm.plugin.backup.a.g.cm(BackupPcUI.this);
                        if (cm == null || cm.equals("")) {
                            BackupPcUI.this.ksn.setText(BackupPcUI.this.getString(R.l.dJi, new Object[]{b.apZ().aqa().ktq, "移动网络"}));
                        } else {
                            BackupPcUI.this.ksn.setText(BackupPcUI.this.getString(R.l.dJi, new Object[]{b.apZ().aqa().ktq, cm}));
                        }
                        BackupPcUI.this.ksn.setTextColor(BackupPcUI.this.getResources().getColor(R.e.brw));
                        BackupPcUI.this.ksl.setText(R.l.dJl);
                        BackupPcUI.this.ksn.setVisibility(0);
                        BackupPcUI.this.ksk.setVisibility(4);
                        BackupPcUI.this.ksl.setVisibility(0);
                        BackupPcUI.this.ksl.setOnClickListener(new OnClickListener() {
                            public final void onClick(View view) {
                                BackupPcUI.m(BackupPcUI.this);
                            }
                        });
                        apU();
                        return;
                    case 1:
                        BackupPcUI.this.ksp.setImageResource(R.k.dwl);
                        BackupPcUI.this.ksm.setText(R.l.dIR);
                        BackupPcUI.this.ksn.setVisibility(4);
                        BackupPcUI.this.ksk.setVisibility(4);
                        BackupPcUI.this.ksl.setVisibility(4);
                        apU();
                        return;
                    case 4:
                        switch (b.apZ().aqa().ktp) {
                            case 1:
                            case 3:
                                BackupPcUI.this.ksp.setImageResource(R.k.dwl);
                                c = BackupPcUI.this.ksm;
                                backupPcUI = BackupPcUI.this;
                                i2 = R.l.dJR;
                                objArr = new Object[3];
                                objArr[0] = Integer.valueOf(aoS.kow);
                                objArr[1] = Integer.valueOf(aoS.kox);
                                b.apZ().aqa();
                                objArr[2] = com.tencent.mm.plugin.backup.backuppcmodel.c.aqf();
                                c.setText(backupPcUI.getString(i2, objArr));
                                break;
                            case 2:
                            case 4:
                                BackupPcUI.this.ksp.setImageResource(R.k.dwp);
                                c = BackupPcUI.this.ksm;
                                backupPcUI = BackupPcUI.this;
                                i2 = R.l.dJA;
                                objArr = new Object[3];
                                objArr[0] = Integer.valueOf(aoS.kow);
                                objArr[1] = Integer.valueOf(aoS.kox);
                                b.apZ().aqa();
                                objArr[2] = com.tencent.mm.plugin.backup.backuppcmodel.c.aqf();
                                c.setText(backupPcUI.getString(i2, objArr));
                                break;
                        }
                        BackupPcUI.this.ksn.setText(R.l.dJT);
                        BackupPcUI.this.ksn.setTextColor(BackupPcUI.this.getResources().getColor(R.e.brw));
                        BackupPcUI.this.ksn.setVisibility(0);
                        BackupPcUI.this.ksk.setVisibility(4);
                        BackupPcUI.this.ksl.setVisibility(4);
                        apW();
                        return;
                    case 5:
                        switch (b.apZ().aqa().ktp) {
                            case 1:
                            case 3:
                                BackupPcUI.this.ksp.setImageResource(R.k.dwl);
                                c = BackupPcUI.this.ksm;
                                backupPcUI = BackupPcUI.this;
                                i2 = R.l.dJR;
                                objArr = new Object[3];
                                objArr[0] = Integer.valueOf(aoS.kow);
                                objArr[1] = Integer.valueOf(aoS.kox);
                                b.apZ().aqa();
                                objArr[2] = com.tencent.mm.plugin.backup.backuppcmodel.c.aqf();
                                c.setText(backupPcUI.getString(i2, objArr));
                                BackupPcUI.this.ksl.setText(R.l.dJN);
                                BackupPcUI.this.ksl.setOnClickListener(new OnClickListener() {
                                    public final void onClick(View view) {
                                        h.a(BackupPcUI.this, R.l.dIU, R.l.dIT, R.l.dJN, R.l.dHz, new DialogInterface.OnClickListener() {
                                            public final void onClick(DialogInterface dialogInterface, int i) {
                                                x.i("MicroMsg.BackupPcUI", "user click close. stop backup.");
                                                b.apZ().apz().stop();
                                                b.apZ().aqb().an(true);
                                                b.apZ().aoS().kov = -100;
                                                g.pWK.a(400, 52, 1, false);
                                                b.apZ().aqb().nb(4);
                                                BackupPcUI.this.En(1);
                                            }
                                        }, null, R.e.brw);
                                    }
                                });
                                break;
                            case 2:
                            case 4:
                                BackupPcUI.this.ksp.setImageResource(R.k.dwp);
                                c = BackupPcUI.this.ksm;
                                backupPcUI = BackupPcUI.this;
                                i2 = R.l.dJA;
                                objArr = new Object[3];
                                objArr[0] = Integer.valueOf(aoS.kow);
                                objArr[1] = Integer.valueOf(aoS.kox);
                                b.apZ().aqa();
                                objArr[2] = com.tencent.mm.plugin.backup.backuppcmodel.c.aqf();
                                c.setText(backupPcUI.getString(i2, objArr));
                                BackupPcUI.this.ksl.setText(R.l.dJP);
                                BackupPcUI.this.ksl.setOnClickListener(new OnClickListener() {
                                    public final void onClick(View view) {
                                        h.a(BackupPcUI.this, R.l.dIW, R.l.dIV, R.l.dJO, R.l.dHz, new DialogInterface.OnClickListener() {
                                            public final void onClick(DialogInterface dialogInterface, int i) {
                                                x.i("MicroMsg.BackupPcUI", "user click close. stop recover.");
                                                b.apZ().apz().stop();
                                                b.apZ().aqc().a(true, true, -100);
                                                g.pWK.a(400, 52, 1, false);
                                                b.apZ().aqc().nb(4);
                                            }
                                        }, null, R.e.brw);
                                    }
                                });
                                break;
                        }
                        BackupPcUI.this.ksn.setText(R.l.dJS);
                        BackupPcUI.this.ksn.setTextColor(BackupPcUI.this.getResources().getColor(R.e.brw));
                        BackupPcUI.this.ksn.setVisibility(0);
                        BackupPcUI.this.ksk.setVisibility(4);
                        BackupPcUI.this.ksl.setVisibility(0);
                        apW();
                        return;
                    case 11:
                        BackupPcUI.this.ksp.setImageResource(R.k.dwl);
                        BackupPcUI.this.ksm.setText(R.l.dJM);
                        BackupPcUI.this.ksn.setText(R.l.dJL);
                        BackupPcUI.this.ksn.setTextColor(BackupPcUI.this.getResources().getColor(R.e.brx));
                        BackupPcUI.this.ksk.setText(R.l.dJJ);
                        BackupPcUI.this.ksl.setText(R.l.dJK);
                        BackupPcUI.this.ksn.setVisibility(0);
                        BackupPcUI.this.ksk.setVisibility(0);
                        BackupPcUI.this.ksl.setVisibility(0);
                        apU();
                        BackupPcUI.this.ksk.setOnClickListener(new OnClickListener() {
                            public final void onClick(View view) {
                                as.Hm();
                                x.i("MicroMsg.BackupPcUI", "onBackupPcUpdateUICallback onUpdateUIProgress startbackup all, hasMove:%s", Boolean.valueOf(((Boolean) com.tencent.mm.y.c.Db().get(w.a.USERINFO_BACKUP_OLD_RECORDS_BOOLEAN, Boolean.valueOf(false))).booleanValue()));
                                if (((Boolean) com.tencent.mm.y.c.Db().get(w.a.USERINFO_BACKUP_OLD_RECORDS_BOOLEAN, Boolean.valueOf(false))).booleanValue()) {
                                    h.a(BackupPcUI.this, R.l.dJm, 0, R.l.dKb, 0, new DialogInterface.OnClickListener() {
                                        public final void onClick(DialogInterface dialogInterface, int i) {
                                            b.apZ().aqa().na(2);
                                            b.apZ().aoS().kov = 12;
                                            AnonymousClass3.this.mR(12);
                                            b.apZ().aqd().apw();
                                            b.apZ().aqd().dL(true);
                                            g.pWK.a(400, 7, 1, false);
                                            g.pWK.h(13735, Integer.valueOf(9), Integer.valueOf(b.apZ().aqa().ktv));
                                        }
                                    }, null, R.e.brv);
                                    return;
                                }
                                b.apZ().aqa().na(2);
                                b.apZ().aoS().kov = 12;
                                AnonymousClass3.this.mR(12);
                                b.apZ().aqd().cancel();
                                b.apZ().aqd().apw();
                                b.apZ().aqd().dL(true);
                                g.pWK.a(400, 7, 1, false);
                                g.pWK.h(13735, Integer.valueOf(9), Integer.valueOf(b.apZ().aqa().ktv));
                            }
                        });
                        BackupPcUI.this.ksl.setOnClickListener(new OnClickListener() {
                            public final void onClick(View view) {
                                MMWizardActivity.A(BackupPcUI.this, new Intent(BackupPcUI.this, BackupPcChooseUI.class));
                                b.apZ().aqd().cancel();
                                b.apZ().aqd().apw();
                                b.apZ().aqd().dL(false);
                            }
                        });
                        return;
                    case 12:
                        BackupPcUI.this.ksp.setImageResource(R.k.dwl);
                        BackupPcUI.this.ksm.setText(R.l.dJq);
                        BackupPcUI.this.ksn.setText(R.l.dJr);
                        BackupPcUI.this.ksn.setTextColor(BackupPcUI.this.getResources().getColor(R.e.brx));
                        BackupPcUI.this.ksn.setVisibility(0);
                        BackupPcUI.this.ksk.setVisibility(4);
                        BackupPcUI.this.ksl.setVisibility(4);
                        apW();
                        return;
                    case 14:
                        BackupPcUI.this.ksp.setImageResource(R.k.dwl);
                        c = BackupPcUI.this.ksm;
                        backupPcUI = BackupPcUI.this;
                        i2 = R.l.dJR;
                        objArr = new Object[3];
                        objArr[0] = Integer.valueOf(aoS.kow);
                        objArr[1] = Integer.valueOf(aoS.kox);
                        b.apZ().aqa();
                        objArr[2] = com.tencent.mm.plugin.backup.backuppcmodel.c.aqf();
                        c.setText(backupPcUI.getString(i2, objArr));
                        BackupPcUI.this.ksn.setText(R.l.dJr);
                        BackupPcUI.this.ksn.setTextColor(BackupPcUI.this.getResources().getColor(R.e.brx));
                        BackupPcUI.this.ksn.setVisibility(0);
                        BackupPcUI.this.ksk.setVisibility(4);
                        BackupPcUI.this.ksl.setVisibility(4);
                        apW();
                        return;
                    case 15:
                        BackupPcUI.this.ksp.setImageResource(R.k.dwk);
                        BackupPcUI.this.ksm.setText(R.l.dIN);
                        BackupPcUI.this.ksn.setText(BackupPcUI.this.getString(R.l.dIO, new Object[]{Integer.valueOf(aoS.kow), Integer.valueOf(aoS.kox)}));
                        BackupPcUI.this.ksn.setTextColor(BackupPcUI.this.getResources().getColor(R.e.brx));
                        BackupPcUI.this.ksk.setText(R.l.dHC);
                        BackupPcUI.this.ksn.setVisibility(0);
                        BackupPcUI.this.ksk.setVisibility(0);
                        BackupPcUI.this.ksl.setVisibility(4);
                        BackupPcUI.this.ksk.setOnClickListener(new OnClickListener() {
                            public final void onClick(View view) {
                                b.apZ().apz().stop();
                                b.apZ().aqb().an(true);
                                b.apZ().aoS().kov = -100;
                                BackupPcUI.this.En(1);
                            }
                        });
                        apU();
                        return;
                    case 21:
                        BackupPcUI.this.ksp.setImageResource(R.k.dwp);
                        BackupPcUI.this.ksm.setText(R.l.dJy);
                        BackupPcUI.this.ksk.setText(R.l.dJx);
                        BackupPcUI.this.ksn.setVisibility(4);
                        BackupPcUI.this.ksk.setVisibility(0);
                        BackupPcUI.this.ksl.setVisibility(4);
                        BackupPcUI.this.ksk.setOnClickListener(new OnClickListener() {
                            public final void onClick(View view) {
                                g.pWK.h(13735, Integer.valueOf(23), Integer.valueOf(b.apZ().aqa().ktv));
                                b.apZ().aqa().na(4);
                                b.apZ().aoS().kov = 22;
                                AnonymousClass3.this.mR(22);
                                g.pWK.a(400, 16, 1, false);
                            }
                        });
                        apU();
                        return;
                    case 22:
                        BackupPcUI.this.ksp.setImageResource(R.k.dwp);
                        BackupPcUI.this.ksm.setText(R.l.dJq);
                        BackupPcUI.this.ksn.setText(R.l.dJr);
                        BackupPcUI.this.ksn.setTextColor(BackupPcUI.this.getResources().getColor(R.e.brx));
                        BackupPcUI.this.ksn.setVisibility(0);
                        BackupPcUI.this.ksk.setVisibility(4);
                        BackupPcUI.this.ksl.setVisibility(4);
                        apW();
                        return;
                    case 23:
                        BackupPcUI.this.ksp.setImageResource(R.k.dwp);
                        c = BackupPcUI.this.ksm;
                        backupPcUI = BackupPcUI.this;
                        i2 = R.l.dJA;
                        objArr = new Object[3];
                        objArr[0] = Integer.valueOf(aoS.kow);
                        objArr[1] = Integer.valueOf(aoS.kox);
                        b.apZ().aqa();
                        objArr[2] = com.tencent.mm.plugin.backup.backuppcmodel.c.aqf();
                        c.setText(backupPcUI.getString(i2, objArr));
                        BackupPcUI.this.ksn.setText(R.l.dJr);
                        BackupPcUI.this.ksn.setTextColor(BackupPcUI.this.getResources().getColor(R.e.brx));
                        BackupPcUI.this.ksn.setVisibility(0);
                        BackupPcUI.this.ksk.setVisibility(4);
                        BackupPcUI.this.ksl.setVisibility(4);
                        apW();
                        return;
                    case 24:
                        if (BackupPcUI.ksj) {
                            BackupPcUI.this.ksp.setImageResource(R.k.dwp);
                            BackupPcUI.this.ksm.setText(R.l.dJB);
                            BackupPcUI.this.ksn.setText(R.l.dJD);
                            BackupPcUI.this.ksn.setTextColor(BackupPcUI.this.getResources().getColor(R.e.brx));
                            BackupPcUI.this.ksk.setText(R.l.dJw);
                            BackupPcUI.this.ksl.setText(R.l.dJz);
                            BackupPcUI.this.kso.setText(R.l.dJU);
                            BackupPcUI.this.ksn.setVisibility(0);
                            BackupPcUI.this.ksk.setVisibility(0);
                            BackupPcUI.this.ksl.setVisibility(0);
                            BackupPcUI.this.ksk.setOnClickListener(new OnClickListener() {
                                public final void onClick(View view) {
                                    x.i("MicroMsg.BackupPcUI", "onUpdateUIProgress user click start merge.");
                                    b.apZ().aqc();
                                    if (!d.apD()) {
                                        b.apZ().aqc();
                                        if (!d.apD()) {
                                            b.apZ().aoS().kov = -22;
                                            AnonymousClass3.this.mR(-22);
                                            g.pWK.a(400, 64, 1, false);
                                            return;
                                        }
                                    }
                                    g.pWK.h(13735, Integer.valueOf(27), Integer.valueOf(b.apZ().aqa().ktv));
                                    b.apZ().aqc().apj();
                                }
                            });
                            BackupPcUI.this.ksl.setOnClickListener(new OnClickListener() {
                                public final void onClick(View view) {
                                    h.a(BackupPcUI.this, R.l.dIW, R.l.dIV, R.l.dJO, R.l.dHz, new DialogInterface.OnClickListener() {
                                        public final void onClick(DialogInterface dialogInterface, int i) {
                                            x.i("MicroMsg.BackupPcUI", "user click close. stop recover merge.");
                                            g.pWK.a(400, 26, 1, false);
                                            b.apZ().apz().stop();
                                            b.apZ().aqc().a(true, true, -100);
                                        }
                                    }, null, R.e.brw);
                                }
                            });
                            BackupPcUI.this.kso.setOnClickListener(new OnClickListener() {
                                public final void onClick(View view) {
                                    b.apZ().aoS().kov = 25;
                                    BackupPcUI.this.En(1);
                                }
                            });
                            return;
                        } else if (bi.bF(BackupPcUI.this)) {
                            b.apZ().aqc();
                            if (d.apD()) {
                                b.apZ().aqc().apj();
                                return;
                            }
                            b.apZ().aoS().kov = -22;
                            mR(-22);
                            g.pWK.a(400, 64, 1, false);
                            return;
                        } else {
                            return;
                        }
                    case 25:
                        if (bi.bF(BackupPcUI.this)) {
                            b.apZ().aoS().kov = 24;
                            i = 24;
                        } else {
                            return;
                        }
                    case 26:
                        BackupPcUI.this.ksp.setImageResource(R.k.dwp);
                        BackupPcUI.this.ksm.setText(BackupPcUI.this.getString(R.l.dJs, new Object[]{Integer.valueOf(aoS.kow), Integer.valueOf(aoS.kox)}));
                        BackupPcUI.this.ksn.setText(R.l.dJv);
                        BackupPcUI.this.ksn.setTextColor(BackupPcUI.this.getResources().getColor(R.e.brx));
                        BackupPcUI.this.kso.setText(R.l.dJz);
                        BackupPcUI.this.ksn.setVisibility(0);
                        BackupPcUI.this.ksk.setVisibility(4);
                        BackupPcUI.this.ksl.setVisibility(4);
                        apU();
                        return;
                    case 27:
                        BackupPcUI.this.ksp.setImageResource(R.k.dwo);
                        BackupPcUI.this.ksm.setText(R.l.dJt);
                        BackupPcUI.this.ksn.setText(BackupPcUI.this.getString(R.l.dJu, new Object[]{Integer.valueOf(aoS.kow), Integer.valueOf(aoS.kox)}));
                        BackupPcUI.this.ksn.setTextColor(BackupPcUI.this.getResources().getColor(R.e.brx));
                        BackupPcUI.this.ksk.setText(R.l.dHC);
                        BackupPcUI.this.ksn.setVisibility(0);
                        BackupPcUI.this.ksk.setVisibility(0);
                        BackupPcUI.this.ksl.setVisibility(4);
                        BackupPcUI.this.ksk.setOnClickListener(new OnClickListener() {
                            public final void onClick(View view) {
                                b.apZ().apz().stop();
                                b.apZ().aoS().kov = -100;
                                BackupPcUI.this.En(1);
                            }
                        });
                        apU();
                        return;
                    default:
                        return;
                }
            }
        }

        private void aqn() {
            if (1 == b.apZ().aqa().ktp || 3 == b.apZ().aqa().ktp) {
                BackupPcUI.this.ksp.setImageResource(R.k.dwj);
            } else if (2 == b.apZ().aqa().ktp || 4 == b.apZ().aqa().ktp) {
                BackupPcUI.this.ksp.setImageResource(R.k.dwn);
            }
        }

        private void apU() {
            BackupPcUI.this.kso.setText(R.l.dHB);
            BackupPcUI.this.kso.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    BackupPcUI.this.apV();
                }
            });
        }

        private void apW() {
            BackupPcUI.this.kso.setText(R.l.dHD);
            BackupPcUI.this.kso.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    BackupPcUI.this.En(1);
                }
            });
        }

        public final void aoR() {
        }
    };

    static /* synthetic */ void m(BackupPcUI backupPcUI) {
        x.i("MicroMsg.BackupPcUI", "jumpToNetworkDisconnectDoc.");
        Intent intent = new Intent();
        intent.putExtra("title", backupPcUI.getString(R.l.dJo));
        intent.putExtra("rawUrl", backupPcUI.getString(R.l.dJn, new Object[]{com.tencent.mm.sdk.platformtools.w.cfV()}));
        intent.putExtra("showShare", false);
        intent.putExtra("neverGetA8Key", true);
        com.tencent.mm.bl.d.b(backupPcUI, "webview", ".ui.tools.WebViewUI", intent);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!getIntent().getExtras().getBoolean("WizardRootKillSelf", false)) {
            x.i("MicroMsg.BackupPcUI", "onCreate.");
            getSupportActionBar().hide();
            com.tencent.mm.plugin.backup.a.ihN.uq();
            initView();
            if (b.apZ().aqa().ktw) {
                b.apZ().aqa().ktw = false;
                final int apd = com.tencent.mm.plugin.backup.a.g.apd();
                if (apd < 50) {
                    g.pWK.a(400, 4, 1, false);
                    g.pWK.h(13736, Integer.valueOf(4), b.apZ().aqa().ktq, com.tencent.mm.plugin.backup.a.g.cm(this), Integer.valueOf(0), Integer.valueOf(b.apZ().aqa().ktv));
                    h.a((Context) this, R.l.dJd, R.l.dJc, R.l.dKb, 0, new DialogInterface.OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            x.i("MicroMsg.BackupPcUI", "low battery, user click sure. battery:%d", Integer.valueOf(apd));
                        }
                    }, null, R.e.brv);
                }
            }
        }
    }

    public void onStart() {
        super.onStart();
        x.i("MicroMsg.BackupPcUI", "onStart.");
        ksj = getIntent().getBooleanExtra("isRecoverTransferFinishFromBanner", false);
    }

    public void onPause() {
        super.onPause();
        x.i("MicroMsg.BackupPcUI", "onPause.");
        com.tencent.mm.plugin.backup.backuppcmodel.e aqb = b.apZ().aqb();
        c cVar = this.kue;
        synchronized (aqb.ktB) {
            aqb.ktB.remove(cVar);
        }
        d aqc = b.apZ().aqc();
        cVar = this.kue;
        synchronized (aqc.ktB) {
            aqc.ktB.remove(cVar);
        }
    }

    public void onResume() {
        super.onResume();
        x.i("MicroMsg.BackupPcUI", "onResume.");
        com.tencent.mm.plugin.backup.backuppcmodel.e aqb = b.apZ().aqb();
        c cVar = this.kue;
        synchronized (aqb.ktB) {
            aqb.ktB.add(cVar);
        }
        d aqc = b.apZ().aqc();
        cVar = this.kue;
        synchronized (aqc.ktB) {
            aqc.ktB.add(cVar);
        }
        this.kue.mR(b.apZ().aoS().kov);
    }

    public final void initView() {
        this.kso = (TextView) findViewById(R.h.bMi);
        this.ksp = (ImageView) findViewById(R.h.bMj);
        this.ksm = (TextView) findViewById(R.h.bMq);
        this.ksn = (TextView) findViewById(R.h.brx);
        this.ksk = (TextView) findViewById(R.h.bLX);
        this.ksl = (TextView) findViewById(R.h.bLW);
    }

    protected final int getLayoutId() {
        return R.i.daV;
    }

    public void onDestroy() {
        x.i("MicroMsg.BackupPcUI", "onDestroy. stack:%s", bi.chl());
        super.onDestroy();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        apV();
        return true;
    }

    private void apV() {
        x.i("MicroMsg.BackupPcUI", "closeImpl, backupPcState:%d", Integer.valueOf(b.apZ().aoS().kov));
        switch (b.apZ().aoS().kov) {
            case DownloadResult.CODE_CLIENT_PROTOCOL_EXCEPTION /*-22*/:
            case DownloadResult.CODE_URL_ERROR /*-21*/:
            case -13:
            case -5:
            case -3:
            case -2:
            case -1:
            case 1:
            case 11:
            case 21:
                if (1 != b.apZ().aqa().ktp && 3 != b.apZ().aqa().ktp) {
                    if (2 != b.apZ().aqa().ktp && 4 != b.apZ().aqa().ktp) {
                        b.apZ().aoS().kov = -100;
                        break;
                    } else {
                        b.apZ().aqc().a(false, false, -100);
                        return;
                    }
                }
                b.apZ().aqb().an(false);
                b.apZ().aoS().kov = -100;
                break;
            case 15:
                x.i("MicroMsg.BackupPcUI", "closeImpl backup finish, user click close.");
                aql();
                return;
            case 24:
                b.apZ().aoS().kov = 25;
                break;
            case 26:
                h.a((Context) this, R.l.dIW, R.l.dIV, R.l.dJO, R.l.dHz, new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        x.i("MicroMsg.BackupPcUI", "closeImpl merging user click close. stop recover merge.");
                        g.pWK.a(400, 26, 1, false);
                        b.apZ().apz().stop();
                        b.apZ().aqc().a(true, true, -100);
                    }
                }, null, R.e.brw);
                return;
            case 27:
                x.i("MicroMsg.BackupPcUI", "closeImpl recover finish, user click close.");
                aql();
                return;
        }
        En(1);
    }

    private void aql() {
        x.i("MicroMsg.BackupPcUI", "exitBackupPc.");
        if (1 == b.apZ().aqa().ktp || 3 == b.apZ().aqa().ktp) {
            b.apZ().aqd().cancel();
            b.apZ().aqd().apw();
            b.apZ().aqb().an(true);
            b.apZ().apz().stop();
            b.apZ().aoS().kov = -100;
            En(1);
        } else if (2 == b.apZ().aqa().ktp || 4 == b.apZ().aqa().ktp) {
            b.apZ().aqc().a(true, true, -100);
            b.apZ().apz().stop();
        }
    }
}
