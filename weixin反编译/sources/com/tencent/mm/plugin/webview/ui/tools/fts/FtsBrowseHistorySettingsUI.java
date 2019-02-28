package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.mm.R;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.webview.ui.tools.fts.a.d;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.statusbar.a;
import com.tencent.mm.ui.statusbar.b;
import com.tencent.mm.y.as;
import com.tencent.mm.y.c;
import com.tencent.smtt.sdk.WebView;

public class FtsBrowseHistorySettingsUI extends MMPreference {
    private f inW;
    private b jQc = null;
    private d tKe = new com.tencent.mm.plugin.webview.ui.tools.fts.a.b();

    public final int XK() {
        return R.o.fcc;
    }

    protected void initSwipeBack() {
        super.initSwipeBack();
        if (getSwipeBackLayout() != null && getSwipeBackLayout().getChildCount() > 0) {
            View childAt = getSwipeBackLayout().getChildAt(0);
            getSwipeBackLayout().removeView(childAt);
            this.jQc = new b(this);
            this.jQc.addView(childAt, new LayoutParams(-1, -1));
            getSwipeBackLayout().addView(this.jQc);
            getSwipeBackLayout().Iv = this.jQc;
        }
        a.d(this.mController.contentView, getResources().getColor(R.e.btQ), true);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setBackGroundColorResource(R.e.btQ);
        initView();
        CheckBoxPreference checkBoxPreference = (CheckBoxPreference) this.inW.Zu("settings_record");
        as.Hm();
        Object obj = c.Db().get(91, Boolean.valueOf(false));
        if (obj == null || !((Boolean) obj).booleanValue()) {
            checkBoxPreference.tYU = false;
        } else {
            checkBoxPreference.tYU = true;
        }
        cnJ();
        oj(WebView.NIGHT_MODE_COLOR);
        if (getSupportActionBar() != null) {
            getSupportActionBar().getCustomView().setBackgroundColor(getResources().getColor(R.e.btQ));
            getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.e.btQ)));
        }
    }

    protected final void initView() {
        setMMTitle(R.l.ekB);
        this.inW = this.yrJ;
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                FtsBrowseHistorySettingsUI.this.finish();
                return true;
            }
        });
    }

    public final boolean a(f fVar, Preference preference) {
        String str = preference.idX;
        x.i("MicroMsg.FtsBrowseHistorySettingsUI", str + " item has been clicked!");
        if ("settings_record".equals(str)) {
            if (((CheckBoxPreference) preference).isChecked()) {
                as.Hm();
                c.Db().set(91, Boolean.valueOf(true));
            } else {
                as.Hm();
                c.Db().set(91, Boolean.valueOf(false));
            }
        } else if ("settings_clear".equals(str)) {
            setResult(1);
            this.tKe.bUP();
            g.pWK.h(14963, Integer.valueOf(4));
        }
        return true;
    }
}
