package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.f.a.gf;
import com.tencent.mm.f.b.ag;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sns.i;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.model.q;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.PreferenceTitleCategory;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.base.r;
import com.tencent.mm.ui.p;
import java.util.HashMap;

public class SnsNotInterestUI extends MMPreference implements e {
    private static final String[] rKe = new String[]{"sns_expose_reason_not_fav", "sns_expose_reason_too_freq", "sns_expose_reason_too_many_same_content", "sns_expose_reason_marketing", "sns_expose_reason_content_sexy", "sns_expose_reason_rumour", "sns_expose_reason_other"};
    private static final int[] rKf = new int[]{1, 2, 4, 8, 16, 32, 64};
    private static final int[] rKj = new int[]{j.qQH, j.qQL, j.qQM, j.qQG, j.qQF, j.qQJ, j.qQI};
    private f jPY;
    private r jqf = null;
    private String ptq = null;
    private HashMap<String, Boolean> rKg = new HashMap(rKe.length);
    private HashMap<Integer, Boolean> rKh = new HashMap(rKf.length);
    private HashMap<String, Integer> rKi = new HashMap(rKf.length);
    private TextView rKk;
    private EditText rKl;
    private ListView rKm;
    private LinearLayout rKn;
    private int rKo;
    private int rKp;
    private long rKq;
    private boolean rKr = false;
    private boolean rKs = false;
    q rKt = null;

    static /* synthetic */ void b(SnsNotInterestUI snsNotInterestUI) {
        snsNotInterestUI.rKp = 0;
        for (Integer intValue : snsNotInterestUI.rKh.keySet()) {
            int intValue2 = intValue.intValue();
            if (((Boolean) snsNotInterestUI.rKh.get(Integer.valueOf(intValue2))).booleanValue()) {
                if (snsNotInterestUI.rKp == 0) {
                    snsNotInterestUI.rKp = intValue2;
                } else {
                    snsNotInterestUI.rKp |= intValue2;
                }
            }
        }
        if (snsNotInterestUI.rKq != 0 && snsNotInterestUI.rKo != 0) {
            Context context = snsNotInterestUI.mController.xRr;
            snsNotInterestUI.getString(j.dGZ);
            snsNotInterestUI.jqf = h.a(context, snsNotInterestUI.getString(j.dHn), true, new OnCancelListener() {
                public final void onCancel(DialogInterface dialogInterface) {
                    g.Dr();
                    g.Dp().gRu.c(SnsNotInterestUI.this.rKt);
                }
            });
            x.d("MicroMsg.SnsNotInterestUI", "start send not inteset, snsId:%d, scene:%d, type:%d, isNeedSupplement:%b", Long.valueOf(snsNotInterestUI.rKq), Integer.valueOf(snsNotInterestUI.rKo), Integer.valueOf(snsNotInterestUI.rKp), Boolean.valueOf(snsNotInterestUI.rKs));
            snsNotInterestUI.rKt = new q(snsNotInterestUI.rKq, snsNotInterestUI.rKo, snsNotInterestUI.rKp, snsNotInterestUI.rKs ? snsNotInterestUI.rKl.getText().toString() : null);
            g.Dr();
            g.Dp().gRu.a(snsNotInterestUI.rKt, 0);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.rKo = getIntent().getIntExtra("sns_info_not_interest_scene", 0);
        this.rKq = getIntent().getLongExtra("sns_info_svr_id", 0);
        if (this.rKq != 0) {
            String str = ae.bwf().eS(this.rKq).field_userName;
            if (str != null) {
                g.Dr();
                ag Xu = ((com.tencent.mm.plugin.messenger.foundation.a.h) g.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).Ff().Xu(str);
                if (Xu.fXa == 2) {
                    rKj[1] = j.qQK;
                } else if (Xu.fXa == 1) {
                    rKj[1] = j.qQL;
                }
            }
        }
        g.Dr();
        g.Dp().gRu.a(218, (e) this);
        bBX();
        initView();
    }

    private void bBX() {
        int i = 0;
        for (Object put : rKe) {
            this.rKg.put(put, Boolean.valueOf(false));
        }
        for (int valueOf : rKf) {
            this.rKh.put(Integer.valueOf(valueOf), Boolean.valueOf(false));
        }
        while (i < rKf.length) {
            this.rKi.put(rKe[i], Integer.valueOf(rKf[i]));
            i++;
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        bBX();
        g.Dr();
        g.Dp().gRu.b(218, (e) this);
        b gfVar = new gf();
        gfVar.fxg.fxh = this.rKr;
        gfVar.fxg.fxi = this.rKq;
        a.xmy.m(gfVar);
    }

    protected final void initView() {
        super.initView();
        setMMTitle(j.qQP);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                SnsNotInterestUI.this.finish();
                return true;
            }
        });
        this.rKk = (TextView) findViewById(i.f.qKx);
        this.rKl = (EditText) findViewById(i.f.qKy);
        this.rKm = (ListView) findViewById(16908298);
        this.rKn = (LinearLayout) findViewById(i.f.qIg);
        this.rKn.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                SnsNotInterestUI.this.rKn.requestFocus();
                SnsNotInterestUI.this.aWY();
            }
        });
        this.rKl.setVisibility(8);
        this.rKk.setVisibility(8);
        this.jPY = this.yrJ;
        if (this.jPY == null) {
            x.e("MicroMsg.SnsNotInterestUI", "initPref error, PreferenceScreen is null!");
        } else {
            if (this.jPY.Zu("sns_expose_desc") == null) {
                Preference preferenceTitleCategory = new PreferenceTitleCategory(this);
                preferenceTitleCategory.setTitle(j.qQD);
                preferenceTitleCategory.setKey("sns_expose_desc");
                this.jPY.a(preferenceTitleCategory);
            }
            for (int i = 0; i < rKe.length; i++) {
                String str = rKe[i];
                int i2 = rKj[i];
                if (this.jPY.Zu(str) == null) {
                    Preference preference = new Preference(this);
                    preference.setTitle(i2);
                    preference.setKey(str);
                    preference.setLayoutResource(i.g.dnz);
                    preference.setWidgetLayoutResource(i.g.qME);
                    this.jPY.a(preference);
                }
            }
        }
        a(0, getString(j.qPy), new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                SnsNotInterestUI.b(SnsNotInterestUI.this);
                return true;
            }
        }, p.b.xSe);
        enableOptionMenu(0, false);
    }

    protected final int getLayoutId() {
        return i.g.qNp;
    }

    public final int XK() {
        return -1;
    }

    public final boolean a(f fVar, Preference preference) {
        if (preference == null) {
            return false;
        }
        String str = preference.idX;
        if (!this.rKg.containsKey(str)) {
            return false;
        }
        boolean z;
        boolean booleanValue = ((Boolean) this.rKg.get(str)).booleanValue();
        if (booleanValue) {
            preference.setWidgetLayoutResource(i.g.qME);
        } else {
            preference.setWidgetLayoutResource(i.g.qMD);
        }
        fVar.notifyDataSetChanged();
        if (booleanValue) {
            z = false;
        } else {
            z = true;
        }
        this.rKg.put(str, Boolean.valueOf(z));
        this.rKh.put(Integer.valueOf(((Integer) this.rKi.get(str)).intValue()), Boolean.valueOf(z));
        x.d("MicroMsg.SnsNotInterestUI", "click: %s, notInterestType: %d, isCheck: %b", str, Integer.valueOf(r0), Boolean.valueOf(z));
        for (Boolean booleanValue2 : this.rKg.values()) {
            if (booleanValue2.booleanValue()) {
                booleanValue = true;
                break;
            }
        }
        booleanValue = false;
        if (booleanValue) {
            enableOptionMenu(0, true);
        } else {
            enableOptionMenu(0, false);
        }
        if (z && str.equals("sns_expose_reason_other")) {
            this.rKl.setVisibility(0);
            this.rKk.setVisibility(0);
            this.rKl.requestFocus();
            this.rKs = true;
            showVKB();
        } else if (((Boolean) this.rKg.get("sns_expose_reason_other")).booleanValue()) {
            this.rKm.requestFocus();
            aWY();
        } else {
            this.rKl.setVisibility(8);
            this.rKk.setVisibility(8);
            this.rKm.requestFocus();
            this.rKs = false;
            aWY();
        }
        return true;
    }

    public final void a(int i, int i2, String str, k kVar) {
        x.d("MicroMsg.SnsNotInterestUI", "onSceneEnd, errType:%d, errCode:%d", Integer.valueOf(i), Integer.valueOf(i2));
        if (kVar.getType() == 218) {
            this.jqf.dismiss();
            this.jqf = null;
            if (((q) kVar).type != 9) {
                return;
            }
            if (i == 0 && i2 == 0) {
                this.rKr = true;
                Toast.makeText(this, j.qQO, 1).show();
                finish();
                return;
            }
            this.rKr = false;
            Toast.makeText(this, j.qQE, 1).show();
        }
    }
}
