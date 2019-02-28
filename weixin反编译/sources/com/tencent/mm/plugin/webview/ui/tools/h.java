package com.tencent.mm.plugin.webview.ui.tools;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.bg.c;
import com.tencent.mm.bl.d;
import com.tencent.mm.pluginsdk.ui.b.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;

public final class h extends b {
    private TextView ikn;

    public h(Context context) {
        super(context);
        if (this.view != null) {
            this.ikn = (TextView) this.view.findViewById(R.h.cYN);
            this.view.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    c cVar = c.ibc;
                    String Vl = c.Vl();
                    if (!bi.oN(Vl)) {
                        c cVar2 = c.ibc;
                        int Vm = c.Vm();
                        Intent intent = new Intent();
                        intent.putExtra("rawUrl", Vl);
                        intent.putExtra("is_from_keep_top", true);
                        intent.putExtra("keep_top_scene", Vm);
                        if (Vm == 2) {
                            intent.putExtra("custom_keep_top_url", Vl);
                            cVar2 = c.ibc;
                            intent.putExtra("custom_keep_top_title", c.Vk());
                        }
                        d.b((Context) h.this.vvl.get(), "webview", ".ui.tools.WebViewUI", intent);
                    }
                }
            });
        }
    }

    public final int getLayoutId() {
        return R.i.dun;
    }

    public final void destroy() {
    }

    public final void setVisibility(int i) {
        if (this.view != null) {
            this.view.findViewById(R.h.cYO).setVisibility(i);
        }
    }

    private void setTitle(String str) {
        if (this.ikn != null) {
            this.ikn.setText(str);
        }
    }

    public final boolean alN() {
        c cVar = c.ibc;
        if (c.Vi()) {
            cVar = c.ibc;
            if (c.Vm() == 2) {
                cVar = c.ibc;
                setTitle(c.Vk());
            } else {
                Context context = ad.getContext();
                int i = R.l.eYI;
                Object[] objArr = new Object[1];
                c cVar2 = c.ibc;
                objArr[0] = c.Vk();
                setTitle(context.getString(i, objArr));
            }
            setVisibility(0);
            return true;
        }
        setVisibility(8);
        return false;
    }
}
