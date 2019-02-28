package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.TextView;
import com.tencent.mm.ad.k;
import com.tencent.mm.plugin.wallet_core.c.r;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.wallet_core.c.u;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.formview.EditHintPasswdView;

@a(1)
public class WalletLqtSimpleCheckPwdUI extends WalletBaseUI {
    private EditHintPasswdView sHK;
    private r sHL;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setMMTitle(u.gh(this));
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                WalletLqtSimpleCheckPwdUI.this.finish();
                return false;
            }
        });
        ((TextView) findViewById(f.urA)).setText(i.uXz);
        this.sHK = (EditHintPasswdView) findViewById(f.ury);
        com.tencent.mm.wallet_core.ui.formview.a.a(this.sHK);
        this.sHK.zSM = new EditHintPasswdView.a() {
            public final void hB(boolean z) {
                if (z) {
                    WalletLqtSimpleCheckPwdUI.this.sHL = new r(WalletLqtSimpleCheckPwdUI.this.sHK.getText(), 7, WalletLqtSimpleCheckPwdUI.this.bKA());
                    WalletLqtSimpleCheckPwdUI.this.r(WalletLqtSimpleCheckPwdUI.this.sHL);
                }
            }
        };
        e(this.sHK, 0, false);
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        x.d("MicroMsg.WalletLqtSimpleCheckPwdUI", "scene end. errType: %d, errCode: %d, errMsg: %s", Integer.valueOf(i), Integer.valueOf(i2), str);
        if (kVar instanceof r) {
            if (i == 0 && i2 == 0) {
                String text = this.sHK.getText();
                Intent intent = new Intent();
                intent.putExtra("lqt_enc_pwd", text);
                setResult(-1, intent);
                finish();
                return true;
            } else if (this.sHK != null) {
                this.sHK.bnq();
            }
        }
        return false;
    }

    public final void uO(int i) {
        super.uO(i);
        if (this.sHK != null) {
            this.sHK.bnq();
        }
    }

    protected final int getLayoutId() {
        return g.uLL;
    }

    protected final int getForceOrientation() {
        return 1;
    }
}
