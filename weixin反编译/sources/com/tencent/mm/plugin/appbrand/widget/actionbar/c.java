package com.tencent.mm.plugin.appbrand.widget.actionbar;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import com.tencent.mm.plugin.appbrand.e;

public interface c {

    public static class a {
        public static c c(Context context, e eVar) {
            if (eVar.YH()) {
                return new a(context);
            }
            return new b(context, false);
        }
    }

    void a(OnClickListener onClickListener);

    void a(OnLongClickListener onLongClickListener);

    CharSequence amR();

    double amS();

    void amT();

    void amW();

    void b(OnClickListener onClickListener);

    void b(com.tencent.mm.plugin.appbrand.page.a.a aVar);

    void c(OnClickListener onClickListener);

    void d(OnClickListener onClickListener);

    void ds(boolean z);

    void dt(boolean z);

    void du(boolean z);

    View getActionView();

    int getBackgroundColor();

    int getForegroundColor();

    LayoutParams getLayoutParams();

    ViewParent getParent();

    void k(double d);

    void mk(int i);

    void setBackgroundColor(int i);

    void setLayoutParams(LayoutParams layoutParams);

    void vA(String str);

    void vB(String str);

    void vz(String str);
}
