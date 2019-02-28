package com.tencent.mm.ui.account;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.R;
import com.tencent.mm.ad.k;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.y.as;

public abstract class b extends com.tencent.mm.ui.applet.SecurityImage.b {
    SecurityImage xSF = null;
    k xVU = null;

    /* renamed from: com.tencent.mm.ui.account.b$1 */
    class AnonymousClass1 implements OnClickListener {
        final /* synthetic */ Context rqA;

        AnonymousClass1(Context context) {
            this.rqA = context;
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            final k a = b.this.a(b.this.xVU, b.this.xSF.cpt());
            as.CN().a(a, 0);
            Context context = this.rqA;
            this.rqA.getString(R.l.dGZ);
            h.a(context, this.rqA.getString(R.l.etS), true, new OnCancelListener() {
                public final void onCancel(DialogInterface dialogInterface) {
                    as.CN().c(a);
                }
            });
        }
    }

    public abstract k a(k kVar, String str);

    public final void cox() {
        as.CN().a(a(this.xVU, ""), 0);
    }
}
