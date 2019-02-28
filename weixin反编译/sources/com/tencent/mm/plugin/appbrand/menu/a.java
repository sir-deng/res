package com.tencent.mm.plugin.appbrand.menu;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfig;
import com.tencent.mm.plugin.appbrand.h;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.appbrand.q.d;
import com.tencent.mm.plugin.appbrand.q.e;
import com.tencent.mm.plugin.appbrand.q.j;
import com.tencent.mm.plugin.appbrand.ui.AppBrandProfileUI;
import com.tencent.mm.plugin.appbrand.widget.g.b;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.ui.base.n;

public final class a extends com.tencent.mm.plugin.appbrand.menu.a.a {
    public a() {
        super(m.jGs - 1);
    }

    public final void a(Context context, p pVar, n nVar, String str) {
        CharSequence charSequence;
        AppBrandSysConfig appBrandSysConfig = pVar.iuk.isS;
        int i = m.jGs - 1;
        String str2 = appBrandSysConfig.fsi;
        int i2 = appBrandSysConfig.iRU.iJa;
        boolean z = pVar.jJD;
        CharSequence string = context.getString(j.dEa, new Object[]{str2});
        str2 = com.tencent.mm.plugin.appbrand.appcache.a.jx(i2);
        if (bi.oN(str2)) {
            charSequence = string;
        } else {
            int c;
            int parseColor = Color.parseColor("#42000000");
            i2 = com.tencent.mm.bu.a.c(context, d.iuW);
            if (z) {
                parseColor = Color.parseColor("#80FFFFFF");
                c = com.tencent.mm.bu.a.c(context, d.buk);
            } else {
                c = i2;
            }
            b bVar = new b(str2, com.tencent.mm.bu.a.fromDPToPix(context, 11), com.tencent.mm.bu.a.fromDPToPix(context, 11), com.tencent.mm.bu.a.fromDPToPix(context, 9), parseColor, com.tencent.mm.bu.a.fromDPToPix(context, 2));
            int a = bVar.a(null);
            int[] alC = com.tencent.mm.plugin.appbrand.ui.j.alC();
            int aa = com.tencent.mm.bu.a.aa(context, e.ivr);
            TextPaint textPaint = new TextPaint(new Paint(c));
            textPaint.setTextSize((float) aa);
            CharSequence ellipsize = TextUtils.ellipsize(string, textPaint, (float) ((alC[0] - com.tencent.mm.bu.a.aa(context, e.ivq)) - a), TruncateAt.END);
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(ellipsize + str2);
            spannableStringBuilder.setSpan(new AbsoluteSizeSpan(aa, false), 0, ellipsize.length(), 18);
            spannableStringBuilder.setSpan(new ForegroundColorSpan(c), 0, ellipsize.length(), 18);
            spannableStringBuilder.setSpan(bVar, ellipsize.length(), spannableStringBuilder.length(), 18);
            Object charSequence2 = spannableStringBuilder;
        }
        nVar.f(i, charSequence2);
    }

    public final void a(Context context, p pVar, String str, l lVar) {
        AppBrandSysConfig appBrandSysConfig = pVar.iuk.isS;
        if (appBrandSysConfig != null) {
            String str2 = "";
            if (com.tencent.mm.plugin.appbrand.a.pl(str) != null) {
                str2 = bi.oM(h.e(pVar.iuk).iub);
            }
            com.tencent.mm.plugin.appbrand.jsapi.op_report.AppBrandOpReportLogic.a.agU();
            com.tencent.mm.plugin.appbrand.config.WxaExposedParams.a aVar = new com.tencent.mm.plugin.appbrand.config.WxaExposedParams.a();
            aVar.appId = appBrandSysConfig.appId;
            aVar.fqZ = 3;
            aVar.fDk = pVar.jJw == null ? "" : pVar.jJw.jdk;
            aVar.iJa = appBrandSysConfig.iRU.iJa;
            aVar.iJb = appBrandSysConfig.iRU.iJb;
            AppBrandProfileUI.a(context, appBrandSysConfig.foe, str2, aVar.acv());
            com.tencent.mm.plugin.appbrand.report.a.a(str, pVar.getURL(), 6, "", bi.Wx(), 1, 0);
        }
    }
}
