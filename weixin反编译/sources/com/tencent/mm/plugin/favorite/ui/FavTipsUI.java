package com.tencent.mm.plugin.favorite.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import com.tencent.mm.R;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.base.i.a;

public class FavTipsUI extends MMBaseActivity {
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        a aVar = new a(this);
        aVar.Zm(getString(R.l.efT));
        aVar.Zn(getString(R.l.efR) + "\n\n" + getString(R.l.efS));
        aVar.EV(R.l.efQ).a(new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                FavTipsUI.this.finish();
            }
        });
        aVar.d(new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                FavTipsUI.this.finish();
            }
        });
        aVar.ale().show();
    }
}
