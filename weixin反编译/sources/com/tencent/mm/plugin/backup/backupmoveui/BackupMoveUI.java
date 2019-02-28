package com.tencent.mm.plugin.backup.backupmoveui;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.BitmapFactory;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.backup.a.b.d;
import com.tencent.mm.plugin.backup.a.c;
import com.tencent.mm.plugin.backup.a.e;
import com.tencent.mm.plugin.backup.c.b;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.DownloadResult;
import java.lang.reflect.Method;

@a(3)
public class BackupMoveUI extends MMWizardActivity implements d {
    public TextView ksk;
    public TextView ksl;
    public TextView ksm;
    public TextView ksn;
    public TextView kso;
    public ImageView ksp;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!getIntent().getExtras().getBoolean("WizardRootKillSelf", false)) {
            x.i("MicroMsg.BackupMoveUI", "onCreate.");
            getSupportActionBar().hide();
            com.tencent.mm.plugin.backup.a.ihN.uq();
            initView();
            try {
                Method method = WifiManager.class.getMethod("isWifiApEnabled", new Class[0]);
                WifiManager wifiManager = (WifiManager) getSystemService("wifi");
                b.apy().apA().kqQ = ((Boolean) method.invoke(wifiManager, new Object[0])).booleanValue();
                x.d("MicroMsg.BackupMoveUI", "old isWifiAp:%s", Boolean.valueOf(b.apy().apA().kqQ));
            } catch (Exception e) {
                x.e("MicroMsg.BackupMoveUI", "no such method WifiManager.isWifiApEnabled:%s", new aj());
            }
        }
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

    public void onResume() {
        super.onResume();
        b.apy().apA().kpP = this;
        mR(b.apy().aoS().kov);
    }

    public void onDestroy() {
        x.d("MicroMsg.BackupMoveUI", "BackupMoveUI onDestroy.");
        if (b.apy().apA().krx != null) {
            b.apy().apA().krx.stop();
        }
        super.onDestroy();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        apV();
        return true;
    }

    public final void mR(int i) {
        e aoS = b.apy().aoS();
        x.i("MicroMsg.BackupMoveUI", "onUpdateUIProgress state:%d, transferSession:%d, totalSession:%d", Integer.valueOf(i), Integer.valueOf(aoS.kow), Integer.valueOf(aoS.kox));
        TextView textView;
        int i2;
        Object[] objArr;
        switch (i) {
            case -100:
                En(1);
                return;
            case DownloadResult.CODE_CONNECTION_TIMEOUT_EXCEPTION /*-23*/:
                this.ksp.setImageResource(R.k.dwc);
                this.ksm.setText(R.l.dHQ);
                this.ksn.setVisibility(4);
                this.ksk.setVisibility(4);
                this.ksl.setVisibility(4);
                apU();
                return;
            case DownloadResult.CODE_URL_ERROR /*-21*/:
                this.ksp.setImageResource(R.k.dwc);
                this.ksm.setText(R.l.dId);
                this.ksn.setVisibility(4);
                this.ksk.setVisibility(4);
                this.ksl.setVisibility(4);
                apU();
                return;
            case -11:
                this.ksp.setImageResource(R.k.dwe);
                this.ksm.setText(getString(R.l.dIk, new Object[]{Integer.valueOf(aoS.kow), Integer.valueOf(aoS.kox), "0M"}));
                this.ksn.setText(R.l.dHT);
                this.ksn.setTextColor(this.mController.xRr.getResources().getColor(R.e.btC));
                this.ksn.setVisibility(0);
                this.ksk.setVisibility(4);
                this.ksl.setVisibility(4);
                apU();
                return;
            case -4:
                this.ksp.setImageResource(R.k.dwe);
                b.apy().apA().krx.start();
                this.ksm.setText(getString(R.l.dIk, new Object[]{Integer.valueOf(aoS.kow), Integer.valueOf(aoS.kox), "0M"}));
                this.ksn.setText(R.l.dHV);
                this.ksn.setTextColor(this.mController.xRr.getResources().getColor(R.e.btC));
                this.ksn.setVisibility(0);
                this.ksk.setVisibility(4);
                this.ksl.setVisibility(4);
                this.kso.setText(R.l.dHD);
                this.kso.setOnClickListener(new OnClickListener() {
                    public final void onClick(View view) {
                        BackupMoveUI.this.En(1);
                    }
                });
                b.apy().apA().krs = c.koh;
                return;
            case 1:
                this.ksp.setImageResource(R.k.dwa);
                this.ksm.setText(R.l.dHH);
                this.ksn.setText(R.l.dIj);
                this.ksn.setVisibility(0);
                this.ksk.setVisibility(4);
                this.ksl.setVisibility(4);
                apU();
                return;
            case 3:
                finish();
                return;
            case 4:
                this.ksp.setImageResource(R.k.dwa);
                textView = this.ksm;
                i2 = R.l.dIL;
                objArr = new Object[3];
                objArr[0] = Integer.valueOf(aoS.kow);
                objArr[1] = Integer.valueOf(aoS.kox);
                b.apy().apA();
                objArr[2] = com.tencent.mm.plugin.backup.c.d.apO();
                textView.setText(getString(i2, objArr));
                this.ksn.setText(R.l.dJT);
                this.ksn.setTextColor(getResources().getColor(R.e.brw));
                this.ksn.setVisibility(0);
                this.ksk.setVisibility(4);
                this.ksl.setVisibility(4);
                apU();
                return;
            case 12:
                this.ksp.setImageResource(R.k.dwa);
                this.ksm.setText(R.l.dIn);
                this.ksn.setText(R.l.dIj);
                this.ksn.setTextColor(getResources().getColor(R.e.brx));
                this.ksn.setVisibility(0);
                this.ksk.setVisibility(4);
                this.ksl.setVisibility(4);
                apU();
                return;
            case 13:
                this.ksp.setImageResource(R.k.dwa);
                this.ksm.setText(getString(R.l.dHE, new Object[]{Integer.valueOf(aoS.kow), Integer.valueOf(aoS.kox)}));
                this.ksn.setText(R.l.dIj);
                this.ksn.setTextColor(getResources().getColor(R.e.brx));
                this.ksn.setVisibility(0);
                this.ksk.setVisibility(4);
                this.ksl.setVisibility(4);
                apU();
                return;
            case 14:
                this.ksp.setImageResource(R.k.dwa);
                textView = this.ksm;
                i2 = R.l.dIL;
                objArr = new Object[3];
                objArr[0] = Integer.valueOf(aoS.kow);
                objArr[1] = Integer.valueOf(aoS.kox);
                b.apy().apA();
                objArr[2] = com.tencent.mm.plugin.backup.c.d.apO();
                textView.setText(getString(i2, objArr));
                this.ksn.setText(R.l.dIj);
                this.ksn.setTextColor(getResources().getColor(R.e.brx));
                this.ksn.setVisibility(0);
                this.ksk.setVisibility(4);
                this.ksl.setVisibility(4);
                apU();
                return;
            case 15:
                this.ksp.setImageResource(R.k.dwd);
                this.ksm.setText(R.l.dwd);
                this.ksn.setText(getString(R.l.dIf, new Object[]{Integer.valueOf(aoS.kow), Integer.valueOf(aoS.kox)}));
                this.ksn.setTextColor(getResources().getColor(R.e.brx));
                this.ksk.setText(R.l.dHC);
                this.ksn.setVisibility(0);
                this.ksk.setVisibility(0);
                this.ksl.setVisibility(4);
                this.ksk.setOnClickListener(new OnClickListener() {
                    public final void onClick(View view) {
                        b.apy().apz().stop();
                        b.apy().apA().an(true);
                        b.apy().aoS().kov = -100;
                        BackupMoveUI.this.En(1);
                    }
                });
                apU();
                return;
            case 51:
                byte[] bArr = b.apy().apA().bitmapData;
                this.ksp.setImageBitmap(BitmapFactory.decodeByteArray(bArr, 0, bArr.length));
                this.ksm.setText(R.l.dIq);
                this.ksm.setTextColor(this.mController.xRr.getResources().getColor(R.e.black));
                this.ksn.setVisibility(4);
                this.ksk.setVisibility(4);
                this.ksl.setVisibility(4);
                apU();
                return;
            default:
                return;
        }
    }

    public final void aoR() {
    }

    private void apU() {
        this.kso.setText(R.l.dHB);
        this.kso.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                BackupMoveUI.this.apV();
            }
        });
    }

    private void apV() {
        x.i("MicroMsg.BackupMoveUI", "close btn, backupMoveState:%d", Integer.valueOf(b.apy().aoS().kov));
        switch (b.apy().aoS().kov) {
            case DownloadResult.CODE_CONNECTION_TIMEOUT_EXCEPTION /*-23*/:
            case DownloadResult.CODE_URL_ERROR /*-21*/:
            case -11:
            case -4:
            case 1:
            case 4:
            case 12:
            case 13:
            case 14:
            case 51:
                h.a((Context) this, R.l.dIp, R.l.dIo, R.l.dIK, R.l.dHz, new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        x.i("MicroMsg.BackupMoveUI", "user click close. stop move.");
                        g.pWK.a(485, 25, 1, false);
                        b.apy().apz().stop();
                        b.apy().apA().an(false);
                        b.apy().aoS().kov = -100;
                        BackupMoveUI.this.En(1);
                    }
                }, null, R.e.brw);
                return;
            case 15:
                x.i("MicroMsg.BackupMoveUI", "backup move finish, user click close.");
                b.apy().apC().cancel();
                b.apy().apC().apw();
                b.apy().apA().an(true);
                b.apy().apz().stop();
                b.apy().aoS().kov = -100;
                En(1);
                return;
            default:
                En(1);
                return;
        }
    }
}
