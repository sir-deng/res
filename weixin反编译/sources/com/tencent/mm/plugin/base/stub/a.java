package com.tencent.mm.plugin.base.stub;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.q.j;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.y.q;

public final class a extends d {
    public a(Context context, String str, String str2, com.tencent.mm.plugin.base.stub.d.a aVar) {
        super(context, str, str2, aVar);
    }

    protected final void Wk() {
        h.a(this.context, R.l.enc, R.l.dGZ, false, new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                j jVar = com.tencent.mm.pluginsdk.q.a.vjc;
                if (jVar != null) {
                    jVar.N(a.this.openId, q.Gb(), a.this.appId);
                }
                a.this.kAz.dT(false);
            }
        });
    }
}
