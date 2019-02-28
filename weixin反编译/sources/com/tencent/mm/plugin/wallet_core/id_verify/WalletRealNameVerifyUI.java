package com.tencent.mm.plugin.wallet_core.id_verify;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;
import com.tencent.mm.ad.k;
import com.tencent.mm.plugin.wallet_core.id_verify.model.Profession;
import com.tencent.mm.plugin.wallet_core.id_verify.model.d;
import com.tencent.mm.plugin.wallet_core.id_verify.model.g;
import com.tencent.mm.plugin.wallet_core.model.ElementQuery;
import com.tencent.mm.plugin.wallet_core.ui.WalletSelectProfessionUI;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.c;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView.a;
import com.tencent.mm.wallet_core.ui.formview.a.b;
import java.util.LinkedList;
import java.util.List;

public class WalletRealNameVerifyUI extends WalletBaseUI implements OnClickListener, a {
    private String countryCode;
    private String hjg;
    private String hjh;
    private Button lXK;
    private TextView nSw;
    private Profession[] sOW;
    private WalletFormView sPO;
    private WalletFormView sPP;
    private WalletFormView sPQ;
    private WalletFormView sPR;
    private CheckBox sPS;
    private TextView sPT;
    private ElementQuery sPU;
    private Profession sPV;
    private boolean sPW = false;
    private boolean sPX = false;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.zSi.jl(1616);
        this.sPU = (ElementQuery) this.vf.getParcelable("elemt_query");
        initView();
        r(new g());
    }

    public void onDestroy() {
        this.zSi.jm(1616);
        super.onDestroy();
    }

    protected final void initView() {
        setMMTitle(i.vce);
        this.lXK = (Button) findViewById(f.cAl);
        this.sPO = (WalletFormView) findViewById(f.uyk);
        this.sPP = (WalletFormView) findViewById(f.unU);
        this.sPQ = (WalletFormView) findViewById(f.uAe);
        this.sPR = (WalletFormView) findViewById(f.uAd);
        this.sPT = (TextView) findViewById(f.urA);
        this.sPO.zST = this;
        this.sPP.zST = this;
        this.sPQ.zST = this;
        this.sPR.zST = this;
        this.sPO.setFocusable(true);
        this.sPO.pJR.setVisibility(8);
        com.tencent.mm.wallet_core.ui.formview.a.c(this.sPP);
        b bVar = this.sPP.zSV;
        if (bVar instanceof com.tencent.mm.wallet_core.ui.formview.a.a) {
            ((com.tencent.mm.wallet_core.ui.formview.a.a) bVar).HY(1);
        }
        this.sPQ.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                Intent intent = new Intent(WalletRealNameVerifyUI.this.mController.xRr, WalletSelectProfessionUI.class);
                intent.putExtra("key_profession_list", WalletRealNameVerifyUI.this.sOW);
                WalletRealNameVerifyUI.this.startActivityForResult(intent, 1);
            }
        });
        this.sPR.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                WalletRealNameVerifyUI.this.startActivityForResult(new Intent("com.tencent.mm.action.GET_ADRESS").putExtra("GetAddress", true).putExtra("ShowSelectedLocation", false).putExtra("IsRealNameVerifyScene", true).putExtra("IsNeedShowSearchBar", true), 2);
            }
        });
        this.lXK.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                WalletRealNameVerifyUI.this.b(new d(WalletRealNameVerifyUI.this.sPO.getText(), WalletRealNameVerifyUI.this.sPP.getText(), WalletRealNameVerifyUI.this.vf.getInt("entry_scene", -1)), true);
            }
        });
        e(this.sPP, 1, false);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                ((a) WalletRealNameVerifyUI.this.cCT()).d(WalletRealNameVerifyUI.this, 0);
                WalletRealNameVerifyUI.this.finish();
                return true;
            }
        });
        this.sPS = (CheckBox) findViewById(f.ukX);
        this.nSw = (TextView) findViewById(f.ukW);
        this.sPS.setChecked(true);
        this.sPS.setOnCheckedChangeListener(new OnCheckedChangeListener() {
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                if (z) {
                    WalletRealNameVerifyUI.this.lXK.setEnabled(true);
                    WalletRealNameVerifyUI.this.lXK.setClickable(true);
                    return;
                }
                WalletRealNameVerifyUI.this.lXK.setEnabled(false);
                WalletRealNameVerifyUI.this.lXK.setClickable(false);
            }
        });
        this.nSw.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                List linkedList = new LinkedList();
                List linkedList2 = new LinkedList();
                linkedList.add(WalletRealNameVerifyUI.this.getString(i.uWz));
                linkedList2.add(Integer.valueOf(0));
                if (WalletRealNameVerifyUI.this.sPU != null && WalletRealNameVerifyUI.this.sPU.sTa) {
                    linkedList.add(WalletRealNameVerifyUI.this.getString(i.uWy));
                    linkedList2.add(Integer.valueOf(1));
                }
                h.a(WalletRealNameVerifyUI.this, "", linkedList, linkedList2, "", new h.d() {
                    public final void cr(int i, int i2) {
                        Intent intent = new Intent();
                        switch (i) {
                            case 0:
                                intent.putExtra("rawUrl", WalletRealNameVerifyUI.this.getString(i.uVk, new Object[]{w.cfV()}));
                                break;
                            case 1:
                                if (WalletRealNameVerifyUI.this.sPU != null) {
                                    intent.putExtra("rawUrl", WalletRealNameVerifyUI.this.getString(i.uVj, new Object[]{w.cfV(), WalletRealNameVerifyUI.this.sPU.pff}));
                                    break;
                                }
                                break;
                        }
                        intent.putExtra("showShare", false);
                        com.tencent.mm.bl.d.b(WalletRealNameVerifyUI.this.mController.xRr, "webview", ".ui.tools.WebViewUI", intent);
                    }
                });
            }
        });
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        boolean z = false;
        if (i != 0 || i2 != 0) {
            x.e("MicroMsg.WalletRealNameVerifyUI", "NetSceneRealNameVerify response fail");
        } else if (kVar instanceof d) {
            c cCT = cCT();
            Bundle bundle = null;
            if (cCT != null) {
                bundle = cCT.mym;
            }
            String str2 = ((d) kVar).token;
            x.i("MicroMsg.WalletRealNameVerifyUI", "NetSceneRealNameVerify response succ");
            if (cCT == null) {
                return true;
            }
            bundle.putString("key_real_name_token", str2);
            bundle.putString("key_country_code", this.countryCode);
            bundle.putString("key_province_code", this.hjh);
            bundle.putString("key_city_code", this.hjg);
            bundle.putParcelable("key_profession", this.sPV);
            cCT.a((Activity) this, 0, bundle);
            return true;
        } else if (kVar instanceof g) {
            g gVar = (g) kVar;
            this.sPW = gVar.sOU == 1;
            if (gVar.sOV == 1) {
                z = true;
            }
            this.sPX = z;
            if (!this.sPX) {
                this.sPQ.setVisibility(8);
            }
            if (!this.sPW) {
                this.sPR.setVisibility(8);
            }
            if (this.sPW || this.sPX) {
                this.sPT.setText(i.vcc);
            }
            this.sOW = gVar.sQm;
            return true;
        }
        return false;
    }

    protected final int getLayoutId() {
        return com.tencent.mm.plugin.wxpay.a.g.uMk;
    }

    public void onClick(View view) {
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 1) {
            if (i2 == -1) {
                this.sPV = (Profession) intent.getParcelableExtra("key_select_profession");
                this.sPQ.setText(this.sPV.sQn);
                return;
            }
            x.i("MicroMsg.WalletRealNameVerifyUI", "no choose!");
        } else if (i != 2) {
        } else {
            if (i2 == -1) {
                String stringExtra = intent.getStringExtra("CountryName");
                String stringExtra2 = intent.getStringExtra("ProviceName");
                String stringExtra3 = intent.getStringExtra("CityName");
                this.countryCode = intent.getStringExtra("Country");
                this.hjh = intent.getStringExtra("Contact_Province");
                this.hjg = intent.getStringExtra("Contact_City");
                StringBuilder stringBuilder = new StringBuilder();
                if (!bi.oN(stringExtra)) {
                    stringBuilder.append(stringExtra);
                }
                if (!bi.oN(stringExtra2)) {
                    stringBuilder.append(" ").append(stringExtra2);
                }
                if (!bi.oN(stringExtra3)) {
                    stringBuilder.append(" ").append(stringExtra3);
                }
                this.sPR.setText(stringBuilder.toString());
                return;
            }
            x.i("MicroMsg.WalletRealNameVerifyUI", "no area choose!");
        }
    }

    public final void hB(boolean z) {
        boolean z2;
        x.d("MicroMsg.WalletRealNameVerifyUI", "check info");
        String text = this.sPO.getText();
        String text2 = this.sPP.getText();
        if (bi.oN(text)) {
            z2 = false;
        } else if (bi.oN(text2)) {
            z2 = false;
        } else {
            if (this.sPW) {
                z2 = (bi.oN(this.countryCode) && bi.oN(this.hjh) && bi.oN(this.hjg)) ? false : true;
                if (!z2) {
                    z2 = false;
                }
            }
            z2 = (this.sPX && this.sPV == null) ? false : true;
        }
        if (z2) {
            this.lXK.setEnabled(true);
            this.lXK.setClickable(true);
            return;
        }
        this.lXK.setEnabled(false);
        this.lXK.setClickable(false);
    }
}
