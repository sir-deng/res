package com.tencent.mm.plugin.wallet_core.ui;

import android.os.Bundle;
import android.widget.TextView;
import com.tencent.mm.ad.k;
import com.tencent.mm.plugin.wallet_core.e.c;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.wallet_core.c.u;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.formview.EditHintPasswdView;
import com.tencent.mm.y.q;

@a(19)
public class WalletSetPasswordUI extends WalletBaseUI {
    public EditHintPasswdView sHK;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setMMTitle(u.gg(this));
        initView();
        c.b(this, this.vf, 5);
    }

    protected final void initView() {
        TextView textView;
        if (this.vf.getInt("key_err_code", 0) == -1002) {
            textView = (TextView) findViewById(f.urx);
            textView.setVisibility(0);
            textView.setText(q.Gl() ? getString(i.vdq) : getString(i.vdp));
            this.vf.putInt("key_err_code", 0);
        }
        this.sHK = (EditHintPasswdView) findViewById(f.ury);
        com.tencent.mm.wallet_core.ui.formview.a.a(this.sHK);
        findViewById(f.umm).setVisibility(8);
        textView = (TextView) findViewById(f.uGH);
        com.tencent.mm.wallet_core.c ag = com.tencent.mm.wallet_core.a.ag(this);
        CharSequence string = (ag == null || !(ag instanceof com.tencent.mm.plugin.wallet_core.id_verify.a)) ? q.Gl() ? getString(i.vdo) : getString(i.uGH) : getString(i.vdn);
        textView.setText(string);
        this.sHK.zSM = new EditHintPasswdView.a() {
            public final void hB(boolean z) {
                if (z) {
                    String cDb = WalletSetPasswordUI.this.sHK.cDb();
                    Bundle bundle = new Bundle();
                    bundle.putString("key_new_pwd1", cDb);
                    WalletSetPasswordUI.this.sHK.bnq();
                    com.tencent.mm.wallet_core.a.j(WalletSetPasswordUI.this, bundle);
                }
            }
        };
        e(this.sHK, 0, false);
    }

    public void onResume() {
        this.sHK.requestFocus();
        super.onResume();
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        return false;
    }

    protected final int getLayoutId() {
        return g.uMs;
    }

    protected final boolean bKK() {
        return true;
    }

    protected final int getForceOrientation() {
        return 1;
    }
}
