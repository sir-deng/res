package com.tencent.mm.ui.account;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.R;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.aq.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.account.LanguagePreference.a;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.PreferenceCategory;
import com.tencent.mm.ui.base.preference.f;

public class RegByMobileVoiceVerifySelectUI extends MMPreference implements e {
    private f inW;
    private String qpx;
    private a[] xZP;

    public final void a(int i, int i2, String str, k kVar) {
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.inW = this.yrJ;
        initView();
    }

    protected void onDestroy() {
        super.onDestroy();
    }

    public final int XK() {
        return R.i.dbp;
    }

    public final boolean a(f fVar, Preference preference) {
        if (!(preference instanceof LanguagePreference)) {
            return false;
        }
        a aVar = ((LanguagePreference) preference).xWP;
        if (aVar == null) {
            return false;
        }
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putString("voice_verify_language", aVar.xWQ);
        bundle.putString("voice_verify_code", aVar.xWS);
        intent.putExtras(bundle);
        setResult(0, intent);
        finish();
        return true;
    }

    protected final void initView() {
        aWY();
        this.qpx = getIntent().getExtras().getString("voice_verify_code");
        setMMTitle(R.l.dLV);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                RegByMobileVoiceVerifySelectUI.this.aWY();
                RegByMobileVoiceVerifySelectUI.this.finish();
                return true;
            }
        });
        this.xZP = coS();
        if (this.xZP != null && this.xZP.length > 0) {
            this.inW.removeAll();
            this.inW.a(new PreferenceCategory(this));
            for (a aVar : this.xZP) {
                if (aVar.xWS.equalsIgnoreCase(this.qpx)) {
                    aVar.nAl = true;
                }
                Preference languagePreference = new LanguagePreference(this);
                languagePreference.a(aVar);
                languagePreference.setKey(aVar.xWS);
                this.inW.a(languagePreference);
            }
        }
    }

    public static String Zh(String str) {
        a[] coS = coS();
        String lK = b.lK(str);
        for (a aVar : coS) {
            if (aVar.xWS.equalsIgnoreCase(lK)) {
                return aVar.xWQ;
            }
        }
        return "English";
    }

    private static a[] coS() {
        String[] split = ad.getContext().getString(R.l.dLS).trim().split(",");
        a[] aVarArr = new a[split.length];
        for (int i = 0; i < split.length; i++) {
            String[] split2 = split[i].trim().split(":");
            aVarArr[i] = new a(split2[1], split2[2], split2[0], false);
        }
        return aVarArr;
    }
}
