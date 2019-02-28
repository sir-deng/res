package com.tencent.mm.plugin.setting.ui.setting;

import android.content.Context;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.PreferenceCategory;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.p.b;

public class SetTextSizeUI extends MMPreference {
    private f inW;
    private float qnL;
    private int qnM = 1;

    private class a extends Preference {
        private float qnL;

        public a(Context context, float f) {
            super(context);
            this.qnL = f;
        }

        protected final void onBindView(View view) {
            super.onBindView(view);
            TextView textView = (TextView) view.findViewById(16908310);
            if (textView != null) {
                textView.setTextSize(1, SetTextSizeUI.ao(this.qnL));
            }
        }
    }

    public final int XK() {
        return -1;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
    }

    protected final void initView() {
        this.qnL = du(this);
        this.inW = this.yrJ;
        setMMTitle(R.l.eNG);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                SetTextSizeUI.this.aWY();
                SetTextSizeUI.this.finish();
                return true;
            }
        });
        a(0, getString(R.l.eLO), new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                com.tencent.mm.bu.a.h(SetTextSizeUI.this, SetTextSizeUI.this.qnL);
                SetTextSizeUI.this.finish();
                return true;
            }
        }, b.xSe);
        refresh();
    }

    public static float du(Context context) {
        float ev = com.tencent.mm.bu.a.ev(context);
        if (ev == 1.0f || ev == 0.875f || ev == 1.125f || ev == 1.25f || ev == 1.375f || ev == 1.625f || ev == 1.875f || ev == 2.025f) {
            return ev;
        }
        return 1.0f;
    }

    public static int dv(Context context) {
        float du = du(context);
        if (du == 0.875f) {
            return R.l.eKE;
        }
        if (du == 1.125f) {
            return R.l.eKC;
        }
        if (du == 1.25f) {
            return R.l.eKF;
        }
        if (du == 1.375f) {
            return R.l.eKB;
        }
        return R.l.eKD;
    }

    public static float ao(float f) {
        if (f == 0.875f) {
            return 14.0f;
        }
        if (f == 1.0f) {
            return 16.0f;
        }
        if (f == 1.125f) {
            return 18.0f;
        }
        if (f == 1.25f) {
            return 20.0f;
        }
        if (f == 1.375f) {
            return 22.0f;
        }
        if (f == 1.625f) {
            return 26.0f;
        }
        if (f == 1.875f) {
            return 28.0f;
        }
        if (f == 2.025f) {
            return 30.0f;
        }
        return 16.0f;
    }

    public final boolean a(f fVar, Preference preference) {
        String str = preference.idX;
        this.qnM = 1;
        if (str.equals("setting_text_size_small")) {
            this.qnL = 0.875f;
            this.qnM = 0;
        } else if (str.equals("setting_text_size_normal")) {
            this.qnL = 1.0f;
            this.qnM = 1;
        } else if (str.equals("setting_text_size_large")) {
            this.qnL = 1.125f;
            this.qnM = 2;
        } else if (str.equals("setting_text_size_super")) {
            this.qnL = 1.25f;
            this.qnM = 3;
        } else if (str.equals("setting_text_size_huge")) {
            this.qnL = 1.375f;
            this.qnM = 4;
        } else if (str.equals("setting_text_size_huger")) {
            this.qnL = 1.625f;
            this.qnM = 5;
        } else if (str.equals("setting_text_size_hugers")) {
            this.qnL = 1.625f;
            this.qnM = 6;
        } else if (str.equals("setting_text_size_hugerss")) {
            this.qnL = 1.625f;
            this.qnM = 7;
        }
        refresh();
        return false;
    }

    private void refresh() {
        this.inW.removeAll();
        Preference aVar = new a(this, 0.875f);
        aVar.setKey("setting_text_size_small");
        aVar.setLayoutResource(R.i.dnz);
        if (this.qnL == 0.875f) {
            aVar.setWidgetLayoutResource(R.i.dof);
        } else {
            aVar.setWidgetLayoutResource(R.i.dog);
        }
        this.inW.a(aVar);
        aVar = new a(this, 1.0f);
        aVar.setKey("setting_text_size_normal");
        aVar.setLayoutResource(R.i.dnz);
        if (this.qnL == 1.0f) {
            aVar.setWidgetLayoutResource(R.i.dof);
        } else {
            aVar.setWidgetLayoutResource(R.i.dog);
        }
        this.inW.a(aVar);
        aVar = new a(this, 1.125f);
        aVar.setKey("setting_text_size_large");
        aVar.setLayoutResource(R.i.dnz);
        if (this.qnL == 1.125f) {
            aVar.setWidgetLayoutResource(R.i.dof);
        } else {
            aVar.setWidgetLayoutResource(R.i.dog);
        }
        this.inW.a(aVar);
        aVar = new a(this, 1.25f);
        aVar.setKey("setting_text_size_super");
        aVar.setLayoutResource(R.i.dnz);
        if (this.qnL == 1.25f) {
            aVar.setWidgetLayoutResource(R.i.dof);
        } else {
            aVar.setWidgetLayoutResource(R.i.dog);
        }
        this.inW.a(aVar);
        aVar = new a(this, 1.375f);
        aVar.setKey("setting_text_size_huge");
        aVar.setLayoutResource(R.i.dnz);
        if (this.qnL == 1.375f) {
            aVar.setWidgetLayoutResource(R.i.dof);
        } else {
            aVar.setWidgetLayoutResource(R.i.dog);
        }
        this.inW.a(aVar);
        this.inW.a(new PreferenceCategory(this));
        this.inW.notifyDataSetChanged();
        ViewGroup viewGroup = (ViewGroup) this.mController.xRd;
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            if (childAt instanceof TextView) {
                x.d("ui.settings.SetTextSize", "id=" + childAt.getId());
            }
        }
    }
}
