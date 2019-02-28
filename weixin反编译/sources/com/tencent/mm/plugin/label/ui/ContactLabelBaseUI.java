package com.tencent.mm.plugin.label.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.R;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.y.as;

public class ContactLabelBaseUI extends MMActivity {
    private ProgressDialog lzx;

    protected int getLayoutId() {
        return 0;
    }

    public final void DY(String str) {
        getString(R.l.dGZ);
        this.lzx = h.a((Context) this, str, true, new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                as.CN().cancel(636);
            }
        });
    }

    public final void aVF() {
        if (this.lzx != null && this.lzx.isShowing()) {
            this.lzx.dismiss();
        }
    }

    public final void zk(String str) {
        h.a((Context) this, str, "", new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
            }
        });
    }
}
