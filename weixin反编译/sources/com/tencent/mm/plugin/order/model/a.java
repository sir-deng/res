package com.tencent.mm.plugin.order.model;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.f.b.ag;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.order.ui.a.e;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.h.d;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import java.util.LinkedList;
import java.util.List;

public final class a {

    public interface a {
        List<Preference> a(Context context, f fVar, MallTransactionObject mallTransactionObject);
    }

    public static e a(final Context context, final MallTransactionObject mallTransactionObject) {
        e eVar = new e(context);
        if (bi.oN(mallTransactionObject.pgp)) {
            eVar.pix = context.getString(i.vaq);
        } else {
            eVar.pix = context.getString(i.van);
        }
        eVar.mOnClickListener = new OnClickListener() {
            public final void onClick(View view) {
                List linkedList = new LinkedList();
                List linkedList2 = new LinkedList();
                if (!bi.oN(mallTransactionObject.pgg)) {
                    linkedList2.add(Integer.valueOf(0));
                    linkedList.add(context.getString(i.vao));
                }
                if (!bi.oN(mallTransactionObject.pfI)) {
                    linkedList2.add(Integer.valueOf(1));
                    linkedList.add(context.getString(i.vap));
                }
                if (!bi.oN(mallTransactionObject.pgp)) {
                    linkedList2.add(Integer.valueOf(2));
                    linkedList.add(context.getString(i.var));
                }
                if (linkedList2.size() == 1) {
                    a.a(((Integer) linkedList2.get(0)).intValue(), context, mallTransactionObject);
                    return;
                }
                h.a(context, null, linkedList, linkedList2, null, true, new d() {
                    public final void cr(int i, int i2) {
                        a.a(i2, context, mallTransactionObject);
                    }
                });
            }
        };
        return eVar;
    }

    public static void a(int i, Context context, MallTransactionObject mallTransactionObject) {
        switch (i) {
            case 0:
                g.Dr();
                ag Xv = ((com.tencent.mm.plugin.messenger.foundation.a.h) g.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).Ff().Xv(mallTransactionObject.pgg);
                if (Xv == null || !com.tencent.mm.k.a.ga(Xv.field_type)) {
                    com.tencent.mm.wallet_core.ui.e.S(context, mallTransactionObject.pgg);
                    return;
                } else {
                    com.tencent.mm.wallet_core.ui.e.bx(context, mallTransactionObject.pgg);
                    return;
                }
            case 1:
                com.tencent.mm.wallet_core.ui.e.by(context, mallTransactionObject.pfI);
                return;
            case 2:
                com.tencent.mm.wallet_core.ui.e.l(context, mallTransactionObject.pgp, false);
                return;
            default:
                return;
        }
    }
}
