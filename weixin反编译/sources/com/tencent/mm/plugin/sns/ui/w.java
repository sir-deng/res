package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.view.View.OnClickListener;
import java.util.List;

public interface w {

    public static abstract class a {
        public OnClickListener rzz = new OnClickListener() {
            public final void onClick(View view) {
                if (view.getTag() != null) {
                    a.this.xK(((Integer) view.getTag()).intValue());
                }
            }
        };

        public abstract void xK(int i);
    }

    void a(a aVar);

    void bAc();

    void bW(List<String> list);

    void clean();

    View getView();
}
