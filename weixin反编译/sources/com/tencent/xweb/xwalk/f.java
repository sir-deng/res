package com.tencent.xweb.xwalk;

import android.graphics.Bitmap;
import android.view.View;
import android.webkit.WebChromeClient.CustomViewCallback;
import com.tencent.xweb.c.e;
import com.tencent.xweb.xwalk.e.a;
import com.tencent.xweb.xwalk.e.c;
import com.tencent.xweb.xwalk.e.d;
import org.xwalk.core.XWalkView;

public final class f implements e {
    j ACn;
    k ACo;
    XWalkView ACp;

    public f(XWalkView xWalkView) {
        this.ACp = xWalkView;
        this.ACn = new j(xWalkView);
        this.ACo = new k(xWalkView);
    }

    public final void x(String str, Bitmap bitmap) {
        this.ACn.a(this.ACp, str);
    }

    public final void onShowCustomView(View view, CustomViewCallback customViewCallback) {
        if (customViewCallback instanceof a) {
            this.ACn.a(view, ((a) customViewCallback).ACj);
        }
    }

    public final void onHideCustomView() {
        this.ACn.cJM();
    }

    public final boolean a(String str, String str2, com.tencent.xweb.f fVar) {
        if (fVar instanceof c) {
            return this.ACn.b(this.ACp, str, str2, ((c) fVar).ACl);
        }
        return false;
    }

    public final boolean b(String str, String str2, com.tencent.xweb.f fVar) {
        if (fVar instanceof c) {
            return this.ACn.a(this.ACp, str, str2, ((c) fVar).ACl);
        }
        return false;
    }

    public final boolean a(String str, String str2, String str3, com.tencent.xweb.e eVar) {
        if (!(eVar instanceof d)) {
            return false;
        }
        return this.ACn.a(this.ACp, str, str2, str3, ((d) eVar).ACl);
    }
}
