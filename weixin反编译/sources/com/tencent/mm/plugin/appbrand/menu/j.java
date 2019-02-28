package com.tencent.mm.plugin.appbrand.menu;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Typeface;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.ab;
import com.tencent.mm.plugin.appbrand.appcache.af;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfig;
import com.tencent.mm.plugin.appbrand.menu.a.a;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.appbrand.q.e;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.n;
import com.tencent.smtt.sdk.WebView;
import java.util.Locale;

final class j extends a {
    j() {
        super(m.jGm - 1);
    }

    public final void a(Context context, p pVar, n nVar, String str) {
        if (b.cfx()) {
            nVar.f(this.jGz, context.getString(com.tencent.mm.plugin.appbrand.q.j.iDL));
        }
    }

    @SuppressLint({"DefaultLocale"})
    public final void a(Context context, p pVar, String str, l lVar) {
        String str2;
        AppBrandSysConfig appBrandSysConfig = pVar.iuk.isS;
        Object stringBuilder = new StringBuilder("!PKG_INFO!\n");
        WxaPkgWrappingInfo aaa = ab.aaa();
        stringBuilder.append("\n[lib.src] ");
        if (aaa.iJd) {
            stringBuilder.append(af.aag() ? "local(force)" : "local");
        } else {
            stringBuilder.append("cgi");
        }
        stringBuilder.append("\n[lib.ver] ").append(aaa.iJb);
        if (aaa.iJa != 0) {
            StringBuilder append = stringBuilder.append("  ");
            if (aaa.iJa == 0) {
                str2 = "";
            } else {
                str2 = bi.fK(aaa.iJc);
            }
            append.append(str2);
        }
        WxaPkgWrappingInfo wxaPkgWrappingInfo = appBrandSysConfig.iRU;
        stringBuilder.append(10);
        stringBuilder.append("\n[app.version] ").append(wxaPkgWrappingInfo.iJb);
        if (appBrandSysConfig.iRU.iJa != 0) {
            stringBuilder.append("  ").append(bi.fK(wxaPkgWrappingInfo.iJc));
        }
        boolean z = !bi.cC(wxaPkgWrappingInfo.iJe);
        stringBuilder.append("\n[app.module ] ").append(String.valueOf(z));
        if (z) {
            str2 = pVar.iuk.itk.pL(pVar.getURL());
            stringBuilder.append(String.format(Locale.US, "  (%s)", new Object[]{str2}));
        }
        View textView = new TextView(context);
        textView.setText(stringBuilder);
        textView.setGravity(19);
        textView.setTextSize(1, 10.0f);
        textView.setLayoutParams(new LayoutParams(-1, -2));
        textView.setTextColor(WebView.NIGHT_MODE_COLOR);
        textView.setTypeface(Typeface.MONOSPACE);
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(e.bvw);
        textView.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        textView.setMovementMethod(ScrollingMovementMethod.getInstance());
        h.a(context, null, textView, null);
    }
}
