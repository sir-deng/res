package com.tencent.mm.plugin.bottle.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.y.bj;

public class BottleWizardStep2 extends MMPreference {
    private c kId;

    public final int XK() {
        return R.o.fbA;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
    }

    public void onDestroy() {
        super.onDestroy();
    }

    protected final void initView() {
        setMMTitle(R.l.eMx);
        this.kId = new c(this, this.yrJ);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                BottleWizardStep2.this.goBack();
                return true;
            }
        });
        addTextOptionMenu(0, getString(R.l.dGb), new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                c.ast();
                bj HW = bj.HW();
                if (bi.a(Integer.valueOf(HW.fXa), 0) <= 0) {
                    h.b(BottleWizardStep2.this.mController.xRr, BottleWizardStep2.this.getString(R.l.dNc), BottleWizardStep2.this.getString(R.l.dGZ), true);
                } else if (bi.oN(HW.getProvince())) {
                    h.b(BottleWizardStep2.this.mController.xRr, BottleWizardStep2.this.getString(R.l.dNb), BottleWizardStep2.this.getString(R.l.dGZ), true);
                } else {
                    Intent intent = new Intent().setClass(BottleWizardStep2.this, BottleBeachUI.class);
                    intent.addFlags(67108864);
                    BottleWizardStep2.this.startActivity(intent);
                    BottleWizardStep2.this.finish();
                }
                return true;
            }
        });
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        goBack();
        return true;
    }

    private void goBack() {
        Intent intent = new Intent().setClass(this, BottleWizardStep1.class);
        intent.addFlags(67108864);
        startActivity(intent);
        aWY();
        finish();
    }

    public void onResume() {
        super.onResume();
        this.kId.update();
    }

    public void onPause() {
        super.onPause();
    }

    public final boolean a(f fVar, Preference preference) {
        String str = preference.idX;
        if (str.equals("settings_district")) {
            return this.kId.asv();
        }
        if (str.equals("settings_signature")) {
            return this.kId.asu();
        }
        return false;
    }
}
