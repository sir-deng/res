package com.tencent.mm.plugin.card.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.view.KeyEvent;
import com.tencent.mm.R;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;

@a(7)
public class CardShowWaringTransparentUI extends MMActivity {
    protected final int getLayoutId() {
        return R.i.dcO;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        String stringExtra = getIntent().getStringExtra("KEY_BRAND_NAME");
        h.a((Context) this, getString(R.l.dPU, new Object[]{stringExtra}), getString(R.l.dPV), getString(R.l.dCa), new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
                CardShowWaringTransparentUI.this.finish();
            }
        });
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i == 4) {
            finish();
        }
        return super.onKeyUp(i, keyEvent);
    }
}
