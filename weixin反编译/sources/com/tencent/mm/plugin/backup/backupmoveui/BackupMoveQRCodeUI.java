package com.tencent.mm.plugin.backup.backupmoveui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.backup.a.b.d;
import com.tencent.mm.plugin.backup.a.c;
import com.tencent.mm.plugin.backup.c.b;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.y.as;

public class BackupMoveQRCodeUI extends MMWizardActivity implements d {
    private ImageView kse;
    private TextView ksf;
    private TextView ksg;
    private boolean ksh = false;

    static /* synthetic */ void d(BackupMoveQRCodeUI backupMoveQRCodeUI) {
        backupMoveQRCodeUI.ksh = false;
        b.apy().apA().dJ(false);
        b.apy().apz().stop();
        b.apy().apA().an(false);
        b.apy().aoS().kov = -100;
        backupMoveQRCodeUI.En(1);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!getIntent().getExtras().getBoolean("WizardRootKillSelf", false)) {
            if (as.Hp()) {
                initView();
                com.tencent.mm.plugin.backup.f.b.clear();
                com.tencent.mm.plugin.backup.f.b.d apA = b.apy().apA();
                com.tencent.mm.plugin.backup.f.b.a(apA.kri);
                com.tencent.mm.plugin.backup.a.d.mS(21);
                com.tencent.mm.plugin.backup.f.b.a(apA.krg);
                b.apy().aoT();
                com.tencent.mm.plugin.backup.f.b.a(apA);
                com.tencent.mm.plugin.backup.f.b.a(b.apy().apz());
                com.tencent.mm.plugin.backup.f.b.mS(2);
                b.apy().koq = null;
                apA.krr = false;
                b.apy().apA().krs = c.kog;
                com.tencent.mm.plugin.backup.a.d.aoY();
                return;
            }
            finish();
        }
    }

    public void onStart() {
        super.onStart();
        com.tencent.mm.plugin.backup.f.b.a(b.apy().apA());
        b.apy().apA().kpP = this;
        b.apy().apA().krx.start();
    }

    public void onResume() {
        super.onResume();
        mR(b.apy().aoS().kov);
    }

    public final void initView() {
        setMMTitle(R.l.dwa);
        this.kse = (ImageView) findViewById(R.h.bMm);
        this.ksf = (TextView) findViewById(R.h.bMo);
        this.ksg = (TextView) findViewById(R.h.bMn);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                BackupMoveQRCodeUI.this.apT();
                return true;
            }
        });
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        apT();
        return true;
    }

    private void apT() {
        if (as.Cz()) {
            h.a((Context) this, R.l.dIp, R.l.dIo, R.l.dIK, R.l.dHz, new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    x.i("MicroMsg.BackupMoveQRCodeUI", "user click close. stop move.");
                    b.apy().apz().stop();
                    b.apy().apA().an(true);
                    b.apy().aoS().kov = -100;
                    BackupMoveQRCodeUI.this.En(1);
                }
            }, null, R.e.brw);
            return;
        }
        x.i("MicroMsg.BackupMoveQRCodeUI", "user click close. stop move.");
        b.apy().apz().stop();
        b.apy().apA().an(true);
        b.apy().aoS().kov = -100;
        En(1);
    }

    public void onStop() {
        x.i("MicroMsg.BackupMoveQRCodeUI", "BackupMoveQRCodeUI onStop.");
        if (b.apy().apA().krx != null) {
            b.apy().apA().krx.stop();
        }
        super.onStop();
    }

    protected final int getLayoutId() {
        return R.i.daU;
    }

    public final void mR(int i) {
        x.i("MicroMsg.BackupMoveQRCodeUI", "onUpdateUIProgress backupState:%d", Integer.valueOf(i));
        if (!this.ksh) {
            switch (i) {
                case -33:
                    this.ksh = true;
                    h.a((Context) this, R.l.dIa, 0, R.l.dHy, R.l.dHz, new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            x.i("MicroMsg.BackupMoveQRCodeUI", "CLIENT_NOT_SUPPORT_QUICK_BACKUP, user click move all.");
                            BackupMoveQRCodeUI.this.ksh = false;
                            b.apy().apA().dJ(true);
                        }
                    }, new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            x.i("MicroMsg.BackupMoveQRCodeUI", "CLIENT_NOT_SUPPORT_QUICK_BACKUP, user click cancel.");
                            BackupMoveQRCodeUI.d(BackupMoveQRCodeUI.this);
                        }
                    }, R.e.brv);
                    return;
                case -32:
                    this.ksh = true;
                    h.a((Context) this, R.l.dIb, 0, R.l.dHx, R.l.dHz, new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            x.i("MicroMsg.BackupMoveQRCodeUI", "CLIENT_NOT_SUPPORT_SELECT_TIME, user click move all.");
                            BackupMoveQRCodeUI.this.ksh = false;
                            b.apy().apA().dJ(true);
                        }
                    }, new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            x.i("MicroMsg.BackupMoveQRCodeUI", "CLIENT_NOT_SUPPORT_SELECT_TIME, user click cancel.");
                            BackupMoveQRCodeUI.d(BackupMoveQRCodeUI.this);
                        }
                    }, R.e.brv);
                    return;
                case -31:
                    this.ksh = true;
                    h.a((Context) this, R.l.dIc, 0, R.l.dHy, R.l.dHz, new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            x.i("MicroMsg.BackupMoveQRCodeUI", "CLIENT_NOT_SUPPORT_SELECT_TIME_AND_QUICK_BACKUP, user click move all.");
                            BackupMoveQRCodeUI.this.ksh = false;
                            b.apy().apA().dJ(true);
                        }
                    }, new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            x.i("MicroMsg.BackupMoveQRCodeUI", "CLIENT_NOT_SUPPORT_SELECT_TIME_AND_QUICK_BACKUP, user click cancel.");
                            BackupMoveQRCodeUI.d(BackupMoveQRCodeUI.this);
                        }
                    }, R.e.brv);
                    return;
                case -12:
                    h.a((Context) this, R.l.dIe, 0, R.l.dKb, 0, new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            x.i("MicroMsg.BackupMoveQRCodeUI", "move phone old version");
                        }
                    }, null, R.e.brv);
                    return;
                case -11:
                case -4:
                    this.ksf.setText(R.l.dHT);
                    this.ksf.setTextColor(this.mController.xRr.getResources().getColor(R.e.btC));
                    this.kse.setImageResource(R.k.dwf);
                    this.ksg.setVisibility(4);
                    return;
                case 2:
                    x.i("MicroMsg.BackupMoveQRCodeUI", "auth success. go to BackupMoveUI.");
                    b.apy().aoS().kov = 12;
                    MMWizardActivity.A(this, new Intent(this, BackupMoveUI.class));
                    return;
                case 51:
                    byte[] bArr = b.apy().apA().bitmapData;
                    this.kse.setImageBitmap(BitmapFactory.decodeByteArray(bArr, 0, bArr.length));
                    this.ksf.setText(R.l.dIq);
                    this.ksf.setTextColor(this.mController.xRr.getResources().getColor(R.e.black));
                    this.ksg.setVisibility(4);
                    return;
                default:
                    return;
            }
        }
    }

    public final void aoR() {
    }
}
