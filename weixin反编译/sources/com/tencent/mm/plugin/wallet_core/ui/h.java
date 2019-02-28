package com.tencent.mm.plugin.wallet_core.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.b;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h.a;
import com.tencent.mm.ui.base.i;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class h {
    public static Dialog a(Context context, List<Bankcard> list, String str, String str2, Bankcard bankcard, a aVar) {
        int i = 0;
        List linkedList = new LinkedList();
        if ((list == null || list.size() == 0) && bi.oN(str)) {
            x.w("MicroMsg.WalletDialogHelper", "hy: bankcard list is null and should not show new");
            return null;
        }
        int i2;
        if (list == null || list.size() == 0) {
            x.i("MicroMsg.WalletDialogHelper", "hy: no bankcard show new only");
            linkedList.add(str);
            i2 = 0;
        } else {
            Iterator it = list.iterator();
            int i3 = 0;
            while (true) {
                i2 = i;
                if (!it.hasNext()) {
                    break;
                }
                Bankcard bankcard2 = (Bankcard) it.next();
                linkedList.add(bankcard2.field_desc);
                if (bankcard != null && bankcard.equals(bankcard2)) {
                    i2 = i3;
                }
                i = i3 + 1;
            }
            if (!bi.oN(str)) {
                linkedList.add(str);
                if (bankcard == null) {
                    i2 = i3;
                }
            }
        }
        return com.tencent.mm.ui.base.h.a(context, str2, linkedList, i2, aVar);
    }

    public static i a(Context context, b bVar, boolean z, OnClickListener onClickListener, OnClickListener onClickListener2) {
        if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
            return null;
        }
        if (bVar == null || (TextUtils.isEmpty(bVar.sQT) && (bVar.sQU == null || bVar.sQU.isEmpty()))) {
            x.w("MicroMsg.WalletDialogHelper", "show showBalanceFetchAlert alert fail");
            return null;
        }
        i.a aVar = new i.a(context);
        aVar.mp(false);
        aVar.EW(com.tencent.mm.plugin.wxpay.a.i.dEy).b(onClickListener2);
        if (z) {
            aVar.EV(com.tencent.mm.plugin.wxpay.a.i.uVv).a(onClickListener);
        } else {
            aVar.ES(com.tencent.mm.plugin.wxpay.a.i.uVz);
            aVar.EV(com.tencent.mm.plugin.wxpay.a.i.uVD).a(onClickListener);
        }
        View inflate = View.inflate(context, g.uLx, null);
        if (bVar.sQU == null || bVar.sQU.isEmpty()) {
            x.e("MicroMsg.WalletDialogHelper", "fetch itemsList is empty");
        } else {
            LinearLayout linearLayout = (LinearLayout) inflate.findViewById(f.bYH);
            linearLayout.removeAllViews();
            int i = 0;
            while (i < bVar.sQU.size() && i < bVar.sQU.size()) {
                View inflate2 = View.inflate(context, g.uLw, null);
                TextView textView = (TextView) inflate2.findViewById(f.subtitle);
                ((TextView) inflate2.findViewById(f.title)).setText(((b.b) bVar.sQU.get(i)).aAM);
                textView.setText(((b.b) bVar.sQU.get(i)).value);
                linearLayout.addView(inflate2, i);
                i++;
            }
        }
        ((TextView) inflate.findViewById(f.title)).setText(bVar.sQT);
        if (z) {
            TextView textView2 = (TextView) inflate.findViewById(f.cSf);
            textView2.setVisibility(0);
            textView2.setText(context.getString(com.tencent.mm.plugin.wxpay.a.i.uVw));
        }
        aVar.dk(inflate);
        i ale = aVar.ale();
        ale.show();
        com.tencent.mm.ui.base.h.a(context, ale);
        return ale;
    }
}
