package android.support.design.widget;

import android.support.v4.view.t;
import android.support.v4.view.z;
import android.view.View;
import com.tencent.mm.BuildConfig;

final class h implements g {
    h() {
    }

    public final void a(View view, t tVar) {
        if (z.Z(view)) {
            z.b(view, tVar);
            view.setSystemUiVisibility(BuildConfig.VERSION_CODE);
        }
    }
}
