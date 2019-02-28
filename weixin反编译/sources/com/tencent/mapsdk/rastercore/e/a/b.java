package com.tencent.mapsdk.rastercore.e.a;

import android.content.Context;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.smtt.sdk.WebView;

final class b extends LinearLayout {
    private TextView a;
    private TextView b;
    private Context c;

    public b(Context context, String str, String str2) {
        super(context);
        this.c = context.getApplicationContext();
        setOrientation(1);
        if (!(str == null || str.isEmpty())) {
            this.a = new TextView(context);
            this.a.setText(str);
            this.a.setTextColor(WebView.NIGHT_MODE_COLOR);
            addView(this.a);
        }
        if (!(str2 == null || str2.isEmpty())) {
            this.b = new TextView(context);
            this.b.setTextColor(WebView.NIGHT_MODE_COLOR);
            this.b.setText(str2);
            addView(this.b);
        }
        try {
            setBackgroundDrawable(d.a(context, "infowindow_bg.9.png"));
        } catch (Exception e) {
        }
    }

    public final void a(String str, String str2) {
        if (str != null && !str.isEmpty()) {
            if (this.a == null) {
                this.a = new TextView(this.c);
                this.a.setText(str);
                this.a.setTextColor(WebView.NIGHT_MODE_COLOR);
                addView(this.a);
            }
            this.a.setText(str);
        } else if (this.a != null) {
            removeView(this.a);
            this.a = null;
        }
        if (str2 != null && !str2.isEmpty()) {
            if (this.b == null) {
                this.b = new TextView(this.c);
                this.b.setTextColor(WebView.NIGHT_MODE_COLOR);
                this.b.setText(str2);
                addView(this.b);
            }
            this.b.setText(str2);
        } else if (this.b != null) {
            removeView(this.b);
            this.b = null;
        }
    }
}
