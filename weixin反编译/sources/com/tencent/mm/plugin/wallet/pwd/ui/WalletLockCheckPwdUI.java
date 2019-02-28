package com.tencent.mm.plugin.wallet.pwd.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.TextView;
import com.tencent.mm.ad.k;
import com.tencent.mm.f.a.qw;
import com.tencent.mm.plugin.wallet_core.c.r;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.formview.EditHintPasswdView;
import com.tencent.mm.wallet_core.ui.formview.EditHintPasswdView.a;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;

public class WalletLockCheckPwdUI extends WalletBaseUI {
    private r sHL;
    private EditHintPasswdView sNo;
    private int sNp = -1;
    private TextView soc;
    private String vz;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setMMTitle(i.uXA);
        this.sNp = getIntent().getIntExtra("key_wallet_lock_type", -1);
        this.vz = getIntent().getStringExtra("action");
        x.v("MicroMsg.WalletLockCheckPwdUI", "alvinluo wallet lock type: %d, action: %s", Integer.valueOf(this.sNp), this.vz);
        this.sNo = (EditHintPasswdView) findViewById(f.ury);
        this.soc = (TextView) findViewById(f.urA);
        this.soc.setText(i.uXz);
        CharSequence stringExtra = getIntent().getStringExtra("key_wallet_lock_input_new_fp_tips");
        if (this.sNp == 2) {
            setMMTitle(i.vex);
            if (this.vz.equals("action.touchlock_need_verify_paypwd") && !bi.oN(stringExtra)) {
                this.soc.setText(stringExtra);
            }
        } else if (this.sNp == 1) {
            setMMTitle(i.vey);
        }
        this.sNo.zSM = new a() {
            public final void hB(boolean z) {
                int i = 8;
                if (z && WalletLockCheckPwdUI.this.vz != null) {
                    if (WalletLockCheckPwdUI.this.vz.equals("action.close_wallet_lock")) {
                        WalletLockCheckPwdUI.this.r(new com.tencent.mm.plugin.wallet.pwd.a.a(WalletLockCheckPwdUI.this.sNo.getText()));
                    } else if (WalletLockCheckPwdUI.this.vz.equals("action.verify_paypwd")) {
                        if (WalletLockCheckPwdUI.this.sNp == 1) {
                            i = 6;
                        } else if (WalletLockCheckPwdUI.this.sNp != 2) {
                            i = -1;
                        }
                        WalletLockCheckPwdUI.this.sHL = new r(WalletLockCheckPwdUI.this.sNo.getText(), i, WalletLockCheckPwdUI.this.bKA());
                        WalletLockCheckPwdUI.this.r(WalletLockCheckPwdUI.this.sHL);
                    } else if (WalletLockCheckPwdUI.this.vz.equals("action.touchlock_verify_by_paypwd")) {
                        WalletLockCheckPwdUI.this.r(new com.tencent.mm.plugin.wallet.pwd.a.i(WalletLockCheckPwdUI.this.sNo.getText()));
                    } else if (WalletLockCheckPwdUI.this.vz.equals("action.touchlock_need_verify_paypwd")) {
                        if (WalletLockCheckPwdUI.this.sNp != 2) {
                            i = -1;
                        }
                        WalletLockCheckPwdUI.this.sHL = new r(WalletLockCheckPwdUI.this.sNo.getText(), i, WalletLockCheckPwdUI.this.bKA());
                        WalletLockCheckPwdUI.this.r(WalletLockCheckPwdUI.this.sHL);
                    }
                }
            }
        };
        e(this.sNo, 0, false);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                x.i("MicroMsg.WalletLockCheckPwdUI", "alvinluo cancel by BackBtn");
                WalletLockCheckPwdUI.this.eb(-1, 4);
                return true;
            }
        });
    }

    public void onResume() {
        super.onResume();
        if (this.sNo != null) {
            this.sNo.bnq();
        }
    }

    public void onBackPressed() {
        x.i("MicroMsg.WalletLockCheckPwdUI", "alvinluo onBackPressed");
        eb(-1, 4);
    }

    protected final int getLayoutId() {
        return g.uLq;
    }

    public final void uO(int i) {
        super.uO(i);
        this.sNo.bnq();
    }

    private void eb(int i, int i2) {
        Intent intent = new Intent();
        intent.putExtra("key_err_code", i2);
        setResult(-1, intent);
        finish();
    }

    private void u(int i, String str, String str2) {
        Intent intent = new Intent();
        intent.putExtra("key_err_code", i);
        intent.putExtra("key_token", str);
        intent.putExtra("key_type", str2);
        setResult(-1, intent);
        finish();
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        x.i("MicroMsg.WalletLockCheckPwdUI", "alvinluo WalletLockCheckPwdUI errType: %d, errCode: %d, errMsg: %s", Integer.valueOf(i), Integer.valueOf(i2), str);
        if (kVar instanceof r) {
            r rVar = (r) kVar;
            if (i == 0 && i2 == 0) {
                if ("next_action.switch_on_pattern".equals(getIntent().getStringExtra("next_action"))) {
                    x.i("MicroMsg.WalletLockCheckPwdUI", "alvinluo start to open wallet lock after check pwd");
                    Intent intent = new Intent();
                    intent.putExtra("action", "action.switch_on_pattern");
                    intent.putExtra("next_action", "next_action.switch_on_pattern");
                    intent.putExtra("token", rVar.token);
                    intent.putExtra(Columns.TYPE, rVar.sOM);
                    intent.putExtra("key_wallet_lock_type", this.sNp);
                    intent.setPackage(ad.getPackageName());
                    if (this.sNp == 2) {
                        intent.putExtra("key_pay_passwd", this.sNo.getText());
                    }
                    b qwVar = new qw();
                    qwVar.fJx.fJz = intent;
                    qwVar.fJx.fBA = this;
                    qwVar.fJx.fzQ = 1;
                    com.tencent.mm.sdk.b.a.xmy.m(qwVar);
                    return true;
                }
                u(0, rVar.token, rVar.sOM);
                return true;
            } else if (i == 1000 && i2 == 3) {
                u(-1, null, null);
                return true;
            }
        } else if (kVar instanceof com.tencent.mm.plugin.wallet.pwd.a.i) {
            if (i == 0 && i2 == 0) {
                eb(-1, 0);
                return true;
            }
            eb(-1, -1);
            return true;
        } else if (kVar instanceof com.tencent.mm.plugin.wallet.pwd.a.a) {
            if (i == 0 && i2 == 0) {
                eb(-1, 0);
            } else {
                eb(-1, -1);
            }
        }
        return false;
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        boolean z = true;
        String str = "MicroMsg.WalletLockCheckPwdUI";
        String str2 = "alvinluo WalletLockCheckPwdUI onActivityResult requestCode: %d, resultCode: %d, data == null: %b";
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(i);
        objArr[1] = Integer.valueOf(i2);
        if (intent != null) {
            z = false;
        }
        objArr[2] = Boolean.valueOf(z);
        x.v(str, str2, objArr);
        setResult(i2, intent);
        finish();
    }
}
