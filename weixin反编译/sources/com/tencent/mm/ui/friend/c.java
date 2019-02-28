package com.tencent.mm.ui.friend;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.a.o;

public final class c implements OnClickListener {
    private Context context;
    private a zlH;

    public interface a {
        void ns(boolean z);
    }

    public static class b {
        public int position;
        public String zlJ;
    }

    public c(Context context, a aVar) {
        this.context = context;
        this.zlH = aVar;
    }

    public final void onClick(View view) {
        b bVar = (b) view.getTag();
        String str = bVar.zlJ;
        final int i = bVar.position;
        new g(this.context, new com.tencent.mm.ui.friend.g.a() {
            public final void o(boolean z, String str) {
                c.this.zlH.ns(z);
            }
        }).q(new int[]{o.bY(str)});
    }
}
