package com.tencent.mm.ui.conversation.a;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.bl.d;
import com.tencent.mm.pluginsdk.ui.b.b;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.y.as;

public final class g extends b {
    boolean yxU = false;
    String zjM = null;
    String zjN = null;

    public g(Context context, String str, String str2, boolean z) {
        super(context);
        this.zjM = str;
        this.zjN = str2;
        this.yxU = z;
        if (this.view != null) {
            TextView textView = (TextView) this.view.findViewById(R.h.bUX);
            CharSequence W = as.Hm().FN().W(this.zjM, "wording");
            CharSequence W2 = as.Hm().FN().W(this.zjN, "wording");
            if (!bi.oN(W)) {
                textView.setText(W);
            } else if (!bi.oN(W2)) {
                textView.setText(W2);
            }
            ((TextView) this.view.findViewById(R.h.bUW)).setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    Intent intent = new Intent();
                    intent.putExtra("k_username", g.this.zjM);
                    int i = 39;
                    if (g.this.yxU) {
                        i = 36;
                    }
                    intent.putExtra("showShare", false);
                    intent.putExtra("rawUrl", String.format("https://weixin110.qq.com/security/readtemplate?t=weixin_report/w_type&scene=%d#wechat_redirect", new Object[]{Integer.valueOf(i)}));
                    if (g.this.vvl.get() != null) {
                        d.b((Context) g.this.vvl.get(), "webview", ".ui.tools.WebViewUI", intent);
                    }
                    as.Hm().FN().io(g.this.zjM);
                    as.Hm().FN().io(g.this.zjN);
                }
            });
            ((ImageView) this.view.findViewById(R.h.bUV)).setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    as.Hm().FN().io(g.this.zjM);
                    as.Hm().FN().io(g.this.zjN);
                }
            });
        }
    }

    public final int getLayoutId() {
        return R.i.dev;
    }

    public final void destroy() {
    }
}
