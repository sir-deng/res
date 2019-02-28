package com.tencent.mm.plugin.wallet_core.ui.view;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h.b;
import com.tencent.mm.ui.base.i;
import com.tencent.mm.ui.tools.a.c;

public final class a {
    public static i a(final Context context, String str, String str2, String str3, int i, final b bVar, OnClickListener onClickListener) {
        if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
            return null;
        }
        com.tencent.mm.ui.base.i.a aVar = new com.tencent.mm.ui.base.i.a(context);
        aVar.mp(false);
        aVar.mq(true);
        aVar.EW(com.tencent.mm.plugin.wxpay.a.i.dEy).b(onClickListener);
        aVar.Zm(str);
        View inflate = View.inflate(context, g.uKP, null);
        final EditText editText = (EditText) inflate.findViewById(f.cdl);
        if (!bi.oN(str2)) {
            editText.append(str2);
        }
        TextView textView = (TextView) inflate.findViewById(f.cSl);
        if (bi.oN(str3)) {
            textView.setVisibility(8);
        } else {
            textView.setText(str3);
        }
        aVar.EV(com.tencent.mm.plugin.wxpay.a.i.dGf).a(false, new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                boolean z = true;
                if (bVar != null) {
                    z = bVar.v(editText.getText().toString().trim());
                }
                if (z) {
                    dialogInterface.dismiss();
                    if (context instanceof MMActivity) {
                        ah.y(new Runnable() {
                            public final void run() {
                                ((MMActivity) context).aWY();
                            }
                        });
                    }
                }
            }
        });
        if (i > 0) {
            c.d(editText).Hg(i).a(null);
        }
        aVar.dk(inflate);
        Dialog ale = aVar.ale();
        ale.show();
        if (context instanceof MMActivity) {
            ((MMActivity) context).addDialog(ale);
        }
        if (context instanceof MMActivity) {
            inflate.post(new Runnable() {
                public final void run() {
                    ((MMActivity) context).showVKB();
                }
            });
        }
        return ale;
    }
}
