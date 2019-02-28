package com.tencent.mm.plugin.card.ui;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.card.b.l;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.widget.CardTextPreference;
import com.tencent.mm.protocal.c.oy;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.PreferenceSmallCategory;
import com.tencent.mm.ui.base.preference.PreferenceTitleCategory;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.smtt.sdk.WebView;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CardDetailPreference extends MMPreference {
    private final String TAG = "MicroMsg.CardDetailPreference";
    f jPY;
    private b kOv;
    private List<com.tencent.mm.plugin.card.model.b> kOz = new ArrayList();
    private TextView kWe;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
    }

    protected final void initView() {
        this.kOv = (b) getIntent().getParcelableExtra("key_card_info_data");
        if (this.kOv == null || this.kOv.aui() == null || this.kOv.auj() == null) {
            x.e("MicroMsg.CardDetailPreference", "mCardInfo == null or mCardInfo.getCardTpInfo() == null or mCardInfo.getDataInfo() == null");
            finish();
            return;
        }
        Preference cardTextPreference;
        StringBuilder stringBuilder = new StringBuilder();
        if (!TextUtils.isEmpty(this.kOv.aui().kQK)) {
            stringBuilder.append(this.kOv.aui().kQK);
        }
        stringBuilder.append(getString(R.l.dOk));
        setMMTitle(stringBuilder.toString());
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                CardDetailPreference.this.finish();
                return true;
            }
        });
        this.jPY = this.yrJ;
        this.kOz.clear();
        if (this.kOv.auj().vYe != null && this.kOv.auj().vYe.size() > 0) {
            this.kOz.addAll(l.ao(this.kOv.auj().vYe));
        }
        if (this.kOv.auj().vYf != null && this.kOv.auj().vYf.size() > 0) {
            Collection ao = l.ao(this.kOv.auj().vYf);
            ((com.tencent.mm.plugin.card.model.b) ao.get(0)).kPM = true;
            this.kOz.addAll(ao);
        }
        awa();
        avZ();
        avY();
        if (!TextUtils.isEmpty(this.kOv.aui().vYO)) {
            cardTextPreference = new CardTextPreference(this);
            cardTextPreference.setLayoutResource(R.i.dnz);
            cardTextPreference.setTitle(getString(R.l.dPd));
            cardTextPreference.setKey("key_pic_detail");
            cardTextPreference.axR();
            awa();
            this.jPY.a(cardTextPreference);
        }
        if (!TextUtils.isEmpty(this.kOv.aui().vYL)) {
            awa();
            cardTextPreference = new CardTextPreference(this);
            cardTextPreference.setLayoutResource(R.i.dnz);
            cardTextPreference.setKey("card_phone");
            cardTextPreference.setTitle(R.l.dOM);
            cardTextPreference.setSummary(this.kOv.aui().vYL);
            cardTextPreference.ldF = getResources().getColor(R.e.btd);
            cardTextPreference.axQ();
            this.jPY.a(cardTextPreference);
            xf("");
        }
        if (this.kOv.aui() != null && !TextUtils.isEmpty(this.kOv.aui().bhd) && this.kWe != null) {
            this.kWe.setText(this.kOv.aui().bhd);
            this.kWe.setVisibility(0);
        }
    }

    private void avY() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.kOz.size()) {
                com.tencent.mm.plugin.card.model.b bVar = (com.tencent.mm.plugin.card.model.b) this.kOz.get(i2);
                Preference preference = new Preference(this);
                preference.setLayoutResource(R.i.dnz);
                preference.setKey(bVar.title);
                preference.setTitle(bVar.title);
                if (!TextUtils.isEmpty(bVar.kPB)) {
                    preference.setSummary(bVar.kPB);
                }
                if (bVar.kPM) {
                    awa();
                }
                this.jPY.a(preference);
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    private void avZ() {
        if (this.kOv.aui().vYN != null && this.kOv.aui().vYN != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.kOv.aui().vYN.size()) {
                    oy oyVar = (oy) this.kOv.aui().vYN.get(i2);
                    if (!TextUtils.isEmpty(oyVar.kPB)) {
                        Preference cardTextPreference = new CardTextPreference(this);
                        cardTextPreference.setLayoutResource(R.i.dnz);
                        cardTextPreference.setTitle(oyVar.kPB);
                        cardTextPreference.axR();
                        xf(oyVar.title);
                        this.jPY.a(cardTextPreference);
                    }
                    i = i2 + 1;
                } else {
                    awa();
                    return;
                }
            }
        }
    }

    private void awa() {
        this.jPY.a(new PreferenceSmallCategory(this));
    }

    private void xf(String str) {
        Preference preferenceTitleCategory = new PreferenceTitleCategory(this);
        if (TextUtils.isEmpty(str)) {
            preferenceTitleCategory.setTitle((CharSequence) " ");
        } else {
            preferenceTitleCategory.setTitle((CharSequence) str);
        }
        this.jPY.a(preferenceTitleCategory);
    }

    public final int XK() {
        return R.o.fbB;
    }

    public final boolean a(f fVar, Preference preference) {
        if (preference.idX.equals("card_phone")) {
            String str = this.kOv.aui().vYL;
            Intent intent = new Intent("android.intent.action.DIAL");
            intent.setFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            intent.setData(Uri.parse(new StringBuilder(WebView.SCHEME_TEL).append(str).toString()));
            startActivity(intent);
        }
        if (preference.idX.equals("key_pic_detail")) {
            com.tencent.mm.plugin.card.b.b.a((MMActivity) this, this.kOv.aui().vYO, 0);
        } else {
            for (int i = 0; i < this.kOz.size(); i++) {
                com.tencent.mm.plugin.card.model.b bVar = (com.tencent.mm.plugin.card.model.b) this.kOz.get(i);
                if (!(bVar.title == null || !bVar.title.equals(preference.idX) || TextUtils.isEmpty(bVar.url))) {
                    if (com.tencent.mm.plugin.card.b.b.d(this.kOv.aum(), bVar.vYB, bVar.vYC, 1028, 0)) {
                        break;
                    }
                    com.tencent.mm.plugin.card.b.b.a((MMActivity) this, bVar.url, 1);
                }
            }
        }
        return false;
    }

    public final View awb() {
        View inflate = getLayoutInflater().inflate(R.i.cPh, null);
        this.kWe = (TextView) inflate.findViewById(R.h.cPf);
        this.kWe.setVisibility(8);
        return inflate;
    }
}
