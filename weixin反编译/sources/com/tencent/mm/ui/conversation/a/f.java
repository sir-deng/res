package com.tencent.mm.ui.conversation.a;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.liteav.network.TXCStreamUploader;
import com.tencent.mm.R;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.ui.b.b;
import com.tencent.mm.ui.contact.SelectContactUI;
import com.tencent.mm.ui.contact.s;
import com.tencent.mm.y.as;

public final class f extends b {
    String zjM = null;
    String zjN = null;

    public f(Context context, String str, String str2) {
        super(context);
        this.zjM = str;
        this.zjN = str2;
        if (this.view != null) {
            ImageView imageView = (ImageView) this.view.findViewById(R.h.bTA);
            this.view.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    Intent intent = new Intent((Context) f.this.vvl.get(), SelectContactUI.class);
                    intent.putExtra("list_attr", s.fe(s.zcy, 256));
                    intent.putExtra("list_type", 10);
                    intent.putExtra("received_card_name", f.this.zjM);
                    intent.putExtra("recommend_friends", true);
                    intent.putExtra("titile", ((Context) f.this.vvl.get()).getString(R.l.dDz));
                    ((Context) f.this.vvl.get()).startActivity(intent);
                    as.Hm().FM().io(f.this.zjM);
                    as.Hm().FM().io(f.this.zjN);
                    g.pWK.h((int) TXCStreamUploader.TXE_UPLOAD_INFO_NET_BUSY, f.this.zjM, Integer.valueOf(2), Integer.valueOf(0));
                }
            });
            imageView.setImageBitmap(com.tencent.mm.ac.b.a(this.zjM, true, -1));
        }
    }

    public final int getLayoutId() {
        return R.i.deu;
    }

    public final void destroy() {
    }
}
