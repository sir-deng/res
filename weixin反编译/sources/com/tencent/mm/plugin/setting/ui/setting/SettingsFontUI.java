package com.tencent.mm.plugin.setting.ui.setting;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.bu.a;
import com.tencent.mm.f.a.gg;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.setting.ui.widget.FontSelectorView;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ac;
import com.tencent.mm.ui.e.h;
import com.tencent.mm.y.q;

public class SettingsFontUI extends MMActivity {
    private int qpl = 0;
    private int qpm = 2;
    private int qpn = a.fromDPToPix(ad.getContext(), R.f.bwV);
    final float qpo = SetTextSizeUI.du(this.mController.xRr);

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
    }

    protected final int getLayoutId() {
        return R.i.dsl;
    }

    protected final void initView() {
        setMMTitle(R.l.eNG);
        x.i("MicroMsg.SettingsFontUI", "fontSizeBefore=" + this.qpo);
        final TextView textView = (TextView) findViewById(R.h.cMw);
        final TextView textView2 = (TextView) findViewById(R.h.cMu);
        final TextView textView3 = (TextView) findViewById(R.h.cMv);
        b.a((ImageView) findViewById(R.h.bTy), q.FY());
        FontSelectorView fontSelectorView = (FontSelectorView) findViewById(R.h.ciY);
        float du = SetTextSizeUI.du(this.mController.xRr);
        if (du < 0.875f || du > 2.025f) {
            du = 1.0f;
        }
        int i = du == 0.875f ? 0 : du == 1.125f ? 2 : du == 1.25f ? 3 : du == 1.375f ? 4 : du == 1.625f ? 5 : du == 1.875f ? 6 : du == 2.025f ? 7 : 1;
        fontSelectorView.qsT = i;
        fontSelectorView.qsU = new FontSelectorView.a() {
            public final void wk(int i) {
                float f = 1.0f;
                switch (i) {
                    case 0:
                        f = 0.875f;
                        break;
                    case 2:
                        f = 1.125f;
                        break;
                    case 3:
                        f = 1.25f;
                        break;
                    case 4:
                        f = 1.375f;
                        break;
                    case 5:
                        f = 1.625f;
                        break;
                    case 6:
                        f = 1.875f;
                        break;
                    case 7:
                        f = 2.025f;
                        break;
                }
                if (f != SettingsFontUI.this.qpo) {
                    SettingsFontUI.this.qpl = 1;
                } else {
                    SettingsFontUI.this.qpl = 0;
                }
                a.h(SettingsFontUI.this.mController.xRr, f);
                ac.h(SettingsFontUI.this.mController.xRr, f);
                Editor edit = SettingsFontUI.this.mController.xRr.getSharedPreferences(ad.cgf(), 0).edit();
                edit.putFloat("current_text_size_scale_key", f);
                edit.commit();
                SettingsFontUI.this.qpm = a.ew(SettingsFontUI.this.mController.xRr);
                float ev = a.ev(SettingsFontUI.this.mController.xRr);
                Context context = SettingsFontUI.this.mController.xRr;
                if (ev == 0.875f) {
                    SettingsFontUI.this.qpn = a.ab(context, R.f.bwW);
                } else if (ev == 1.125f) {
                    SettingsFontUI.this.qpn = a.ab(context, R.f.bwS);
                } else if (ev == 1.25f) {
                    SettingsFontUI.this.qpn = a.ab(context, R.f.bwX);
                } else if (ev == 1.375f) {
                    SettingsFontUI.this.qpn = a.ab(context, R.f.bwN);
                } else if (ev == 1.625f || ev == 1.875f || ev == 2.025f) {
                    SettingsFontUI.this.qpn = a.ab(context, R.f.bwO);
                }
                textView.setTextSize(1, SetTextSizeUI.ao(f));
                textView2.setTextSize(1, SetTextSizeUI.ao(f));
                textView3.setTextSize(1, SetTextSizeUI.ao(f));
                float ab = ((float) a.ab(context, R.f.bun)) * a.ex(context);
                SettingsFontUI.this.mController.xRy.setTextSize(0, ab);
            }
        };
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                g.pWK.h(11609, Integer.valueOf(SettingsFontUI.this.qpl), Integer.valueOf(SettingsFontUI.this.qpm), Integer.valueOf(0));
                x.i("MicroMsg.SettingsFontUI", "choose font size kvReport logID:%d , changeFontSize: %d, curFontSize:%d", Integer.valueOf(11609), Integer.valueOf(SettingsFontUI.this.qpl), Integer.valueOf(SettingsFontUI.this.qpm));
                SettingsFontUI.this.finish();
                SettingsFontUI.this.ap(SettingsFontUI.this.qpo);
                return true;
            }
        });
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || keyEvent.getAction() != 0) {
            return super.onKeyDown(i, keyEvent);
        }
        g.pWK.h(11609, Integer.valueOf(this.qpl), Integer.valueOf(this.qpm), Integer.valueOf(0));
        x.i("MicroMsg.SettingsFontUI", "choose font size kvReport logID:%d , changeFontSize: %d, curFontSize:%d", Integer.valueOf(11609), Integer.valueOf(this.qpl), Integer.valueOf(this.qpm));
        finish();
        ap(this.qpo);
        return true;
    }

    private void ap(float f) {
        float f2 = this.mController.xRr.getSharedPreferences(ad.cgf(), 0).getFloat("current_text_size_scale_key", 1.0f);
        x.i("MicroMsg.SettingsFontUI", "fontSizeAfter=" + f2);
        if (f != f2) {
            Intent intent = new Intent();
            intent.putExtra("Intro_Need_Clear_Top ", true);
            com.tencent.mm.plugin.setting.a.ihN.s(intent, this.mController.xRr);
            com.tencent.mm.sdk.b.b ggVar = new gg();
            ggVar.fxj.fxk = f;
            ggVar.fxj.fxl = f2;
            com.tencent.mm.sdk.b.a.xmy.m(ggVar);
            Intent intent2 = new Intent();
            intent2.setComponent(new ComponentName(h.xMS, "com.tencent.mm.booter.MMReceivers$ToolsProcessReceiver"));
            intent2.putExtra("tools_process_action_code_key", "com.tencent.mm.intent.ACTION_KILL_TOOLS_PROCESS");
            ad.getContext().sendBroadcast(intent2);
        }
    }
}
