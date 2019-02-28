package com.tencent.mm.ui.tools;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.R;
import com.tencent.mm.f.a.w;
import com.tencent.mm.modelsimple.d;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.y.as;

@a(3)
public class AccountDeletedAlphaAlertUI extends MMActivity {
    private static AccountDeletedAlphaAlertUI zpm = null;

    static /* synthetic */ void a(AccountDeletedAlphaAlertUI accountDeletedAlphaAlertUI) {
        accountDeletedAlphaAlertUI.finish();
        d.br(accountDeletedAlphaAlertUI);
        Intent intent = new Intent(accountDeletedAlphaAlertUI.mController.xRr, LauncherUI.class);
        intent.putExtra("Intro_Switch", true).addFlags(67108864);
        accountDeletedAlphaAlertUI.mController.xRr.startActivity(intent);
    }

    public static AccountDeletedAlphaAlertUI cym() {
        return zpm;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        zpm = this;
        com.tencent.mm.sdk.b.a.xmy.m(new w());
        as.hold();
        com.tencent.mm.g.a eC = com.tencent.mm.g.a.eC(getIntent().getStringExtra("errmsg"));
        if (eC != null) {
            eC.a(this, new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AccountDeletedAlphaAlertUI.a(AccountDeletedAlphaAlertUI.this);
                }
            }, null);
        } else {
            h.a((Context) this, getString(R.l.euG), null, false, new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AccountDeletedAlphaAlertUI.a(AccountDeletedAlphaAlertUI.this);
                }
            });
        }
    }

    public void onDestroy() {
        if (equals(zpm)) {
            zpm = null;
        }
        super.onDestroy();
    }

    protected final int getLayoutId() {
        return -1;
    }
}
