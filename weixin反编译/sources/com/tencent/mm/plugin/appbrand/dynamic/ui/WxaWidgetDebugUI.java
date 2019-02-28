package com.tencent.mm.plugin.appbrand.dynamic.ui;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.method.LinkMovementMethod;
import android.text.style.URLSpan;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.Toast;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.dynamic.html.CustomURLSpan;
import com.tencent.mm.plugin.appbrand.dynamic.widget.c;
import com.tencent.mm.plugin.appbrand.widget.a.a;
import com.tencent.mm.plugin.appbrand.widget.l;
import com.tencent.mm.plugin.appbrand.widget.m;
import com.tencent.mm.plugin.appbrand.wxawidget.b.b;
import com.tencent.mm.plugin.appbrand.wxawidget.b.e;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.MMSwitchBtn;

public class WxaWidgetDebugUI extends MMActivity {
    String appId;
    int fwH;
    int iJb;
    MMSwitchBtn iYo;
    l iYp;
    String id;

    public void onCreate(Bundle bundle) {
        String format;
        super.onCreate(bundle);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                WxaWidgetDebugUI.this.finish();
                return false;
            }
        });
        int i = e.kmW;
        Object[] objArr = new Object[1];
        if (((com.tencent.mm.modelappbrand.e) g.h(com.tencent.mm.modelappbrand.e.class)).Jd().Jg()) {
            format = String.format("(%s)", new Object[]{c.adE()});
        } else {
            format = "";
        }
        objArr[0] = format;
        setMMTitle(getString(i, objArr));
        Intent intent = getIntent();
        this.id = intent.getStringExtra(SlookAirButtonFrequentContactAdapter.ID);
        this.appId = intent.getStringExtra("app_id");
        this.fwH = intent.getIntExtra("pkg_type", 0);
        this.iJb = intent.getIntExtra("pkg_version", 0);
        setMMSubTitle(String.format("(%s)", new Object[]{this.id}));
        this.iYo = (MMSwitchBtn) findViewById(b.kmG);
        this.iYp = ((a) g.h(a.class)).Zv().vy(this.appId);
        if (this.iYp == null) {
            this.iYp = new l();
            this.iYp.field_appId = this.appId;
        }
        this.iYo.nJ(this.iYp.field_openDebug);
        this.iYo.zEt = new MMSwitchBtn.a() {
            public final void cy(boolean z) {
                WxaWidgetDebugUI.this.iYp.field_openDebug = z;
                m Zv = ((a) g.h(a.class)).Zv();
                com.tencent.mm.sdk.e.c cVar = WxaWidgetDebugUI.this.iYp;
                if (cVar != null && !bi.oN(cVar.field_appId)) {
                    cVar.field_appIdHash = cVar.field_appId.hashCode();
                    Zv.a(cVar);
                }
            }
        };
        TextView textView = (TextView) findViewById(b.kmt);
        CharSequence fromHtml = Html.fromHtml(getString(e.kmX), new com.tencent.mm.plugin.appbrand.dynamic.html.a(), new com.tencent.mm.plugin.appbrand.dynamic.html.b());
        if (fromHtml instanceof Spannable) {
            Spannable spannable = (Spannable) fromHtml;
            URLSpan[] uRLSpanArr = (URLSpan[]) spannable.getSpans(0, fromHtml.length(), URLSpan.class);
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(fromHtml);
            for (URLSpan uRLSpan : uRLSpanArr) {
                spannableStringBuilder.removeSpan(uRLSpan);
                spannableStringBuilder.setSpan(new CustomURLSpan(uRLSpan.getURL()), spannable.getSpanStart(uRLSpan), spannable.getSpanEnd(uRLSpan), 34);
            }
            fromHtml = spannableStringBuilder;
        }
        textView.setText(fromHtml);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        findViewById(b.kmK).setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                ((com.tencent.mm.modelappbrand.e) g.h(com.tencent.mm.modelappbrand.e.class)).Jc().restart();
                com.tencent.mm.by.a.i(new Runnable() {
                    public final void run() {
                        Toast.makeText(WxaWidgetDebugUI.this.mController.xRr, e.kmZ, 1).show();
                    }
                }, 1000);
            }
        });
        View findViewById = findViewById(b.kmO);
        if (((com.tencent.mm.modelappbrand.e) g.h(com.tencent.mm.modelappbrand.e.class)).Jd().Jg()) {
            findViewById.setVisibility(0);
            findViewById.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    Intent intent = new Intent(WxaWidgetDebugUI.this.mController.xRr, WxaWidgetSettingsUI.class);
                    intent.putExtra("app_id", WxaWidgetDebugUI.this.appId);
                    intent.putExtra("pkg_type", WxaWidgetDebugUI.this.fwH);
                    intent.putExtra("pkg_version", WxaWidgetDebugUI.this.iJb);
                    WxaWidgetDebugUI.this.startActivity(intent);
                }
            });
            return;
        }
        findViewById.setVisibility(8);
    }

    protected final int getLayoutId() {
        return com.tencent.mm.plugin.appbrand.wxawidget.b.c.kmS;
    }
}
