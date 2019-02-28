package com.tencent.mm.plugin.setting.ui.setting;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.bb.m;
import com.tencent.mm.plugin.aj.a.g;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.e;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.smtt.sdk.WebView;

public class SettingsAboutMMHeaderPreference extends Preference {
    String qnU = "";

    public SettingsAboutMMHeaderPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public SettingsAboutMMHeaderPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    protected final void onBindView(View view) {
        super.onBindView(view);
        TextView textView = (TextView) view.findViewById(R.h.bIe);
        textView.setText(String.format("%s %s", new Object[]{view.getResources().getString(R.l.app_name), this.qnU}));
        textView.setOnClickListener(new OnClickListener() {
            private long qnV = 0;

            public final void onClick(View view) {
                long Wy = bi.Wy();
                if (this.qnV > Wy || Wy - this.qnV > 300) {
                    this.qnV = Wy;
                    return;
                }
                this.qnV = Wy;
                Context context = SettingsAboutMMHeaderPreference.this.mContext;
                CharSequence stringBuilder = new StringBuilder();
                stringBuilder.append(String.format("[ver  ] %s %08X\n", new Object[]{f.b(context, d.vHl, true), Integer.valueOf(d.vHl)}));
                stringBuilder.append(e.atw());
                stringBuilder.append(String.format("[cid  ] %d\n", new Object[]{Integer.valueOf(f.fei)}));
                stringBuilder.append(String.format("[s.ver] %d\n", new Object[]{Integer.valueOf(g.Af(0))}));
                stringBuilder.append(String.format("[l.ver] %d\n", new Object[]{Integer.valueOf(g.Af(1))}));
                stringBuilder.append(String.format("[ws.ver] %d\n", new Object[]{Integer.valueOf(m.Rp())}));
                stringBuilder.append(String.format("[r.ver] %s\n", new Object[]{"0x26060532"}));
                View textView = new TextView(context);
                textView.setText(stringBuilder);
                textView.setGravity(19);
                textView.setTextSize(1, 10.0f);
                textView.setLayoutParams(new LayoutParams(-1, -2));
                textView.setTextColor(WebView.NIGHT_MODE_COLOR);
                textView.setTypeface(Typeface.MONOSPACE);
                int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.f.bvw);
                textView.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
                h.a(context, null, textView, null);
            }
        });
    }
}
