package com.tencent.mm.plugin.sns.lucky.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.i.k;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;

public final class a {
    public static Dialog e(Context context, final View view) {
        View inflate = LayoutInflater.from(context).inflate(g.qMA, null);
        String str = w.cfS() ? "font_1.otf" : w.cfT() ? "font_2.otf" : null;
        TextView textView = (TextView) inflate.findViewById(f.qIU);
        if (!bi.oN(str)) {
            textView.setTypeface(Typeface.createFromAsset(context.getAssets(), str));
        }
        if (!w.cfR()) {
            textView.setTextSize(1, 10.0f);
        }
        final Dialog dialog = new Dialog(context, k.eZl);
        dialog.setContentView(inflate);
        dialog.setTitle(null);
        dialog.setOnCancelListener(new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                x.i("MicroMsg.SnsLuckyCommentAlertUI", "showTipsDialog onCancel");
                if (dialog != null && dialog.isShowing()) {
                    dialog.dismiss();
                }
            }
        });
        ((TextView) inflate.findViewById(f.qIn)).setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                x.i("MicroMsg.SnsLuckyCommentAlertUI", "showTipsDialog onClick");
                if (dialog != null && dialog.isShowing()) {
                    dialog.dismiss();
                }
                View view2 = view;
                if (view2 != null) {
                    view2.performClick();
                }
            }
        });
        View findViewById = inflate.findViewById(f.qLP);
        int b = b.b(context, 10.0f);
        bi.j(findViewById, b, b, b, b);
        findViewById.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                x.i("MicroMsg.SnsLuckyCommentAlertUI", "showTipsDialog OnClick: close");
                if (dialog != null && dialog.isShowing()) {
                    dialog.dismiss();
                }
            }
        });
        dialog.show();
        return dialog;
    }
}
