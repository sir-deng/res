package com.tencent.mm.plugin.recharge.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract.CommonDataKinds.Phone;
import android.provider.ContactsContract.Contacts;
import android.telephony.PhoneNumberUtils;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.f.a.tb;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.recharge.model.f;
import com.tencent.mm.plugin.recharge.ui.form.InstantAutoCompleteTextView;
import com.tencent.mm.plugin.recharge.ui.form.MallFormView;
import com.tencent.mm.plugin.recharge.ui.form.c.b;
import com.tencent.mm.plugin.recharge.ui.form.d.a;
import com.tencent.mm.plugin.wallet.a.d;
import com.tencent.mm.plugin.wallet.a.m;
import com.tencent.mm.plugin.wallet.a.n;
import com.tencent.mm.plugin.wallet_core.model.mall.MallFunction;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.v;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PhoneRechargeUI extends MMActivity implements e, a {
    private String desc = "";
    private int errCode = 0;
    private String foE = "";
    protected Dialog ion = null;
    private String mAppId = "";
    private ArrayList<n> pHM = null;
    private ArrayList<n> pHN = null;
    private d pHO = null;
    private d pHP = null;
    private d pHQ = null;
    private d pHR = null;
    private d pHS = null;
    private TextView pIA = null;
    private TextView pIB = null;
    private GridView pIC = null;
    private GridView pID = null;
    private TextView pIE = null;
    private TextView pIF = null;
    private TextView pIG = null;
    private TextView pIH = null;
    private TextView pII = null;
    private TextView pIJ = null;
    private b pIK = null;
    private b pIL = null;
    private MallFunction pIM = null;
    private String pIN = "";
    private int pIO;
    private String pIP = "";
    private String pIQ = "";
    private b pIR = null;
    private m pIS = null;
    private boolean pIT = false;
    private List<String[]> pIU;
    private View pIw = null;
    private ImageView pIx = null;
    private TextView pIy = null;
    private MallFormView pIz = null;
    private boolean plo = false;
    private c plr = new c<tb>() {
        {
            this.xmG = tb.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            tb tbVar = (tb) bVar;
            if (tbVar instanceof tb) {
                if (tbVar.fMn.result != -1) {
                    x.i("MicroMsg.PhoneRechargeUI", "hy: MallRecharge pay result : cancel");
                } else if (!PhoneRechargeUI.this.plo) {
                    x.i("MicroMsg.PhoneRechargeUI", "hy: MallRecharge pay result : ok");
                    com.tencent.mm.plugin.recharge.a.a.bmX().a(new com.tencent.mm.plugin.recharge.model.a(PhoneRechargeUI.this.pIz.getText(), PhoneRechargeUI.this.pIR.pId != null ? bi.oM(PhoneRechargeUI.this.pIR.pId.name) : "", 0));
                    PhoneRechargeUI.this.finish();
                    PhoneRechargeUI.this.plo = true;
                }
                return true;
            }
            x.f("MicroMsg.PhoneRechargeUI", "hy: mismatched event");
            return false;
        }
    };

    static /* synthetic */ void IM(String str) {
        x.i("MicroMsg.PhoneRechargeUI", "do scene: %s", str);
        g.CN().a(new f(str), 0);
    }

    static /* synthetic */ com.tencent.mm.plugin.recharge.model.a a(PhoneRechargeUI phoneRechargeUI, String str) {
        x.i("MicroMsg.PhoneRechargeUI", "handle phone number: %s", str);
        com.tencent.mm.plugin.recharge.model.a bmZ = com.tencent.mm.plugin.recharge.a.a.bmZ();
        if (bmZ == null || !str.equals(bmZ.pHq)) {
            if (phoneRechargeUI.pIU == null || phoneRechargeUI.pIU.isEmpty()) {
                phoneRechargeUI.pIU = com.tencent.mm.pluginsdk.a.bW(phoneRechargeUI.mController.xRr);
            }
            com.tencent.mm.plugin.recharge.model.a aVar;
            if (phoneRechargeUI.pIU == null || phoneRechargeUI.pIU.isEmpty()) {
                List<com.tencent.mm.plugin.recharge.model.a> bmY = com.tencent.mm.plugin.recharge.a.a.bmX().bmY();
                if (bmY.isEmpty()) {
                    bmZ = new com.tencent.mm.plugin.recharge.model.a(str, "", 0);
                    bmZ.pHs = com.tencent.mm.plugin.recharge.model.a.pHo;
                    x.i("MicroMsg.PhoneRechargeUI", "empty history");
                    return bmZ;
                }
                for (com.tencent.mm.plugin.recharge.model.a bmZ2 : bmY) {
                    if (bmZ2.pHq.equals(str)) {
                        aVar = new com.tencent.mm.plugin.recharge.model.a(str, bmZ2.name, bmZ2.pHr, 2);
                        aVar.pHs = com.tencent.mm.plugin.recharge.model.a.pHo;
                        x.i("MicroMsg.PhoneRechargeUI", "find in history");
                        return aVar;
                    }
                }
                bmZ2 = new com.tencent.mm.plugin.recharge.model.a(str, phoneRechargeUI.getString(i.vcv), 0);
                bmZ2.pHs = com.tencent.mm.plugin.recharge.model.a.pHo;
                x.i("MicroMsg.PhoneRechargeUI", "not find in history");
                return bmZ2;
            }
            for (String[] strArr : phoneRechargeUI.pIU) {
                String II = com.tencent.mm.plugin.recharge.model.b.II(strArr[2]);
                if (str.equals(II)) {
                    aVar = new com.tencent.mm.plugin.recharge.model.a(II, strArr[1], 1);
                    aVar.pHs = com.tencent.mm.plugin.recharge.model.a.pHo;
                    x.i("MicroMsg.PhoneRechargeUI", "find in address number");
                    return aVar;
                }
            }
            bmZ2 = new com.tencent.mm.plugin.recharge.model.a(str, "", 1);
            bmZ2.pHs = com.tencent.mm.plugin.recharge.model.a.pHo;
            x.i("MicroMsg.PhoneRechargeUI", "not in address");
            return bmZ2;
        }
        x.i("MicroMsg.PhoneRechargeUI", "find bind mobile");
        return bmZ2;
    }

    static /* synthetic */ boolean a(PhoneRechargeUI phoneRechargeUI, final n nVar) {
        if (phoneRechargeUI.pIR.pId != null) {
            String string;
            com.tencent.mm.plugin.recharge.model.a aVar = phoneRechargeUI.pIR.pId;
            String text = phoneRechargeUI.pIz.getText();
            if (aVar.fqY == 1 && bi.oN(aVar.name)) {
                string = phoneRechargeUI.getString(i.uSs, new Object[]{phoneRechargeUI.pIz.getText(), phoneRechargeUI.getString(i.vcy)});
            } else if (aVar.fqY != 0) {
                if (aVar.fqY != 3 && nVar.sJU == 1) {
                    String str = "";
                    if (!bi.oN(aVar.name)) {
                        str = aVar.name;
                    } else if (!bi.oN(aVar.pHr)) {
                        str = aVar.pHr;
                    }
                    if (!bi.oN(str)) {
                        string = phoneRechargeUI.getString(i.uSt, new Object[]{text, str, nVar.name});
                    }
                }
                string = null;
            } else if (bi.oN(aVar.pHr)) {
                string = phoneRechargeUI.getString(i.uSs, new Object[]{text, phoneRechargeUI.getString(i.vcv)});
            } else {
                string = phoneRechargeUI.getString(i.uSu, new Object[]{text});
            }
            if (!bi.oN(string)) {
                h.a((Context) phoneRechargeUI, string, "", phoneRechargeUI.getString(i.uSv), phoneRechargeUI.getString(i.dUl), new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        PhoneRechargeUI.b(PhoneRechargeUI.this, nVar.id);
                    }
                }, null);
                return false;
            }
        }
        return true;
    }

    static /* synthetic */ void b(PhoneRechargeUI phoneRechargeUI, String str) {
        phoneRechargeUI.n(new com.tencent.mm.plugin.recharge.model.g(phoneRechargeUI.mAppId, phoneRechargeUI.pIM.pHt, str, "mobile=" + com.tencent.mm.plugin.recharge.model.b.II(phoneRechargeUI.pIz.getText()) + "&markup=" + (phoneRechargeUI.pIR.pId != null ? phoneRechargeUI.pIR.pId.name : "")));
    }

    static /* synthetic */ void d(PhoneRechargeUI phoneRechargeUI, String str) {
        try {
            x.d("MicroMsg.PhoneRechargeUI", "url: %s", str);
            Intent intent = new Intent();
            intent.putExtra("rawUrl", str);
            com.tencent.mm.bl.d.b(phoneRechargeUI, "webview", ".ui.tools.WebViewUI", intent);
        } catch (Exception e) {
            x.e("MicroMsg.PhoneRechargeUI", "hy: url decode failed: raw url: %s", str);
        }
    }

    static /* synthetic */ void g(PhoneRechargeUI phoneRechargeUI) {
        if (phoneRechargeUI.pIS != null) {
            String str = (String) g.Dq().Db().get(w.a.USERINFO_PHONE_RECHARGE_CLOSED_BANNER_STRING, (Object) "");
            g.Dq().Db().a(w.a.USERINFO_PHONE_RECHARGE_CLOSED_BANNER_STRING, bi.oN(str) ? String.valueOf(phoneRechargeUI.pIS.id) : str + ";" + phoneRechargeUI.pIS.id);
            g.Dq().Db().lO(true);
        }
    }

    private void bne() {
        this.mAppId = "";
        bnf();
        this.errCode = 0;
        this.foE = "";
        this.desc = "";
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        g.CN().a(1571, (e) this);
        g.CN().a(498, (e) this);
        this.pIM = (MallFunction) getIntent().getParcelableExtra("key_func_info");
        if (this.pIM == null) {
            x.e("MicroMsg.PhoneRechargeUI", "hy: function info is null");
            u.makeText(this, "function info is null", 1).show();
            finish();
        }
        bnf();
        setMMTitle(this.pIM.fJD);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                PhoneRechargeUI.this.aWY();
                PhoneRechargeUI.this.finish();
                return true;
            }
        });
        this.pHS = new d();
        this.pHS.name = getString(i.vct);
        this.pHS.url = getString(i.vcu);
        this.pIw = findViewById(com.tencent.mm.plugin.wxpay.a.f.uzX);
        this.pIx = (ImageView) findViewById(com.tencent.mm.plugin.wxpay.a.f.uyo);
        this.pIy = (TextView) findViewById(com.tencent.mm.plugin.wxpay.a.f.uyp);
        this.pIz = (MallFormView) findViewById(com.tencent.mm.plugin.wxpay.a.f.uBq);
        com.tencent.mm.plugin.recharge.ui.form.c.b(this.pIz);
        this.pIR = new b(this.pIz);
        b bVar = this.pIR;
        x.d(com.tencent.mm.plugin.recharge.ui.form.c.TAG, "hy: setMobileEditTv");
        MallFormView mallFormView = bVar.pJK;
        TextWatcher anonymousClass1 = new TextWatcher() {
            private int pIg = 0;

            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                String charSequence2 = charSequence.toString();
                int selectionStart = b.this.pJK.pJQ.getSelectionStart();
                String str = "";
                if (charSequence2 != null) {
                    StringBuilder stringBuilder = new StringBuilder(charSequence2.replaceAll(" ", ""));
                    int length = stringBuilder.length();
                    if (length >= 4) {
                        stringBuilder.insert(3, ' ');
                    }
                    if (length >= 8) {
                        stringBuilder.insert(8, ' ');
                    }
                    str = stringBuilder.toString();
                    length = str.length();
                    if (length > this.pIg) {
                        if ((selectionStart == 4 || selectionStart == 9) && i3 == 1) {
                            selectionStart++;
                        } else if ((selectionStart == 4 || selectionStart == 9) && i3 > 1) {
                            selectionStart += i3;
                        }
                    } else if (length < this.pIg && (selectionStart == 4 || selectionStart == 9)) {
                        selectionStart--;
                    }
                    this.pIg = length;
                }
                String str2 = str;
                int i4 = selectionStart;
                String str3 = str2;
                if (!charSequence2.equals(str3)) {
                    b.this.pJK.pJQ.setText(str3);
                    if (i4 < this.pIg) {
                        b.this.pJK.pJQ.setSelection(i4);
                    } else {
                        b.this.pJK.pJQ.setSelection(this.pIg);
                    }
                }
            }

            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void afterTextChanged(Editable editable) {
            }
        };
        if (mallFormView.pJQ != null) {
            mallFormView.pJQ.addTextChangedListener(anonymousClass1);
        }
        InstantAutoCompleteTextView instantAutoCompleteTextView = (InstantAutoCompleteTextView) bVar.pJK.pJQ;
        bVar.pIc = com.tencent.mm.pluginsdk.a.bW(bVar.pJK.getContext());
        bVar.pJL = new com.tencent.mm.plugin.recharge.ui.form.d(bVar.pJK, bVar.pIc);
        bVar.pJL.pKy = new com.tencent.mm.plugin.recharge.ui.form.d.d() {
        };
        bVar.pJL.pKz = this;
        bVar.hC(true);
        instantAutoCompleteTextView.pJJ = true;
        instantAutoCompleteTextView.setAdapter(bVar.pJL);
        instantAutoCompleteTextView.setOnItemClickListener(new com.tencent.mm.plugin.recharge.ui.form.c.b.AnonymousClass3(instantAutoCompleteTextView));
        bVar.pJK.setOnFocusChangeListener(new com.tencent.mm.plugin.recharge.ui.form.c.b.AnonymousClass4(instantAutoCompleteTextView));
        instantAutoCompleteTextView.setOnClickListener(new com.tencent.mm.plugin.recharge.ui.form.c.b.AnonymousClass5(instantAutoCompleteTextView));
        this.pIC = (GridView) findViewById(com.tencent.mm.plugin.wxpay.a.f.uBD);
        this.pIE = (TextView) findViewById(com.tencent.mm.plugin.wxpay.a.f.uBJ);
        this.pIF = (TextView) findViewById(com.tencent.mm.plugin.wxpay.a.f.uBK);
        this.pIG = (TextView) findViewById(com.tencent.mm.plugin.wxpay.a.f.uBp);
        this.pIH = (TextView) findViewById(com.tencent.mm.plugin.wxpay.a.f.uBB);
        this.pIA = (TextView) findViewById(com.tencent.mm.plugin.wxpay.a.f.uBF);
        this.pIB = (TextView) findViewById(com.tencent.mm.plugin.wxpay.a.f.uBH);
        this.pID = (GridView) findViewById(com.tencent.mm.plugin.wxpay.a.f.uBr);
        this.pII = (TextView) findViewById(com.tencent.mm.plugin.wxpay.a.f.uBE);
        this.pIJ = (TextView) findViewById(com.tencent.mm.plugin.wxpay.a.f.uBG);
        this.pIz.pJT = new MallFormView.a() {
            public final void hB(boolean z) {
                if (z) {
                    PhoneRechargeUI.this.aWY();
                    final String II = com.tencent.mm.plugin.recharge.model.b.II(PhoneRechargeUI.this.pIz.getText());
                    if (II == null) {
                        x.e("MicroMsg.PhoneRechargeUI", "null phone, return");
                        return;
                    }
                    com.tencent.mm.sdk.f.e.a(new Runnable() {
                        public final void run() {
                            long currentTimeMillis = System.currentTimeMillis();
                            final com.tencent.mm.plugin.recharge.model.a a = PhoneRechargeUI.a(PhoneRechargeUI.this, II);
                            x.d("MicroMsg.PhoneRechargeUI", "handle cost: %s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                            ah.y(new Runnable() {
                                public final void run() {
                                    PhoneRechargeUI.this.pIR.b(a);
                                    PhoneRechargeUI.IM(II);
                                }
                            });
                        }
                    }, "search_matched_mobile");
                    if (PhoneRechargeUI.this.pIT) {
                        PhoneRechargeUI.this.pIT = false;
                        return;
                    }
                    x.d("MicroMsg.PhoneRechargeUI", "clear focus");
                    PhoneRechargeUI.this.pIT = true;
                    return;
                }
                PhoneRechargeUI.this.pIz.pJS.setText("");
                PhoneRechargeUI.this.pIz.pJS.setTextColor(PhoneRechargeUI.this.getResources().getColor(com.tencent.mm.plugin.wxpay.a.c.btv));
                PhoneRechargeUI.this.bne();
                PhoneRechargeUI.this.w(false, false);
                if (bi.oN(PhoneRechargeUI.this.pIz.getText())) {
                    ((AutoCompleteTextView) PhoneRechargeUI.this.pIz.pJQ).showDropDown();
                }
            }
        };
        this.pIz.pJR.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                if (PhoneRechargeUI.this.getPackageManager().checkPermission("android.permission.READ_CONTACTS", ad.getPackageName()) == 0) {
                    Intent intent = new Intent("android.intent.action.PICK", Contacts.CONTENT_URI);
                    if (bi.k(PhoneRechargeUI.this, intent)) {
                        PhoneRechargeUI.this.startActivityForResult(intent, 1);
                        return;
                    }
                    return;
                }
                h.b(PhoneRechargeUI.this, PhoneRechargeUI.this.getString(i.vcx), "", true);
            }
        });
        this.pIK = new b();
        this.pIK.pIs = new b.a() {
            public final void a(n nVar) {
                if (nVar == null) {
                    x.e("MicroMsg.PhoneRechargeUI", "hy: no product item");
                } else if (PhoneRechargeUI.a(PhoneRechargeUI.this, nVar)) {
                    PhoneRechargeUI.b(PhoneRechargeUI.this, nVar.id);
                }
            }
        };
        this.pIL = new b();
        this.pIL.pIs = new b.a() {
            public final void a(n nVar) {
                if (!bi.oN(nVar.url)) {
                    PhoneRechargeUI.d(PhoneRechargeUI.this, PhoneRechargeUI.this.IK(nVar.url));
                } else if (PhoneRechargeUI.a(PhoneRechargeUI.this, nVar)) {
                    PhoneRechargeUI.b(PhoneRechargeUI.this, nVar.id);
                } else {
                    x.w("MicroMsg.PhoneRechargeUI", "error dataFlow click");
                }
            }
        };
        this.pIC.setAdapter(this.pIK);
        this.pID.setAdapter(this.pIL);
        this.pIx.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                if (PhoneRechargeUI.this.pIS != null) {
                    PhoneRechargeUI.g(PhoneRechargeUI.this);
                } else {
                    x.e("MicroMsg.PhoneRechargeUI", "hy: no banner but show ad. should not happen");
                }
                PhoneRechargeUI.this.pIw.setVisibility(8);
            }
        });
        this.pIy.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                if (PhoneRechargeUI.this.pIS != null && !bi.oN(PhoneRechargeUI.this.pIS.url)) {
                    com.tencent.mm.protocal.f.eE(6, 1);
                    try {
                        PhoneRechargeUI.d(PhoneRechargeUI.this, URLDecoder.decode(PhoneRechargeUI.this.pIS.url, ProtocolPackage.ServerEncoding));
                    } catch (Throwable e) {
                        x.printErrStackTrace("MicroMsg.PhoneRechargeUI", e, "", new Object[0]);
                    }
                }
            }
        });
        this.pIz.bno();
        int eB = (com.tencent.mm.bu.a.eB(this) / 4) - 20;
        x.i("MicroMsg.PhoneRechargeUI", "max width: %s", Integer.valueOf(eB));
        this.pIE.setMaxWidth(eB);
        this.pIF.setMaxWidth(eB);
        this.pIG.setMaxWidth(eB);
        this.pIH.setMaxWidth(eB);
        this.pIO = getResources().getColor(com.tencent.mm.plugin.wxpay.a.c.btv);
        if (!(this.pIR.pId == null || bi.oN(this.pIR.pId.name))) {
            this.desc = this.pIR.pId.name;
        }
        this.pIz.pJQ.setHintTextColor(getResources().getColor(com.tencent.mm.plugin.wxpay.a.c.uhI));
        if (bi.oN(this.pIz.getText())) {
            n(new f(""));
        } else {
            n(new f(this.pIz.getText()));
        }
    }

    private String IK(String str) {
        String str2;
        try {
            str2 = "";
            if (!(this.pIR == null || this.pIR.pId == null || bi.oN(this.pIR.pId.name))) {
                str2 = this.pIR.pId.name;
            }
            if (str2.equals(getString(i.vcw))) {
                str2 = "WeChatAccountBindNumber";
            }
            CharSequence text = this.pIz.getText();
            CharSequence encode = URLEncoder.encode(URLEncoder.encode(str2, ProtocolPackage.ServerEncoding), ProtocolPackage.ServerEncoding);
            if (str.startsWith("http://") || str.startsWith("https://")) {
                x.i("MicroMsg.PhoneRechargeUI", "new url");
                if (str.indexOf("%7Bphone%7D") > 0) {
                    str = str.replace("%7Bphone%7D", text);
                } else {
                    str = str.replace("{phone}", text);
                }
                if (str.indexOf("%7Bremark%7D") > 0) {
                    return str.replace("%7Bremark%7D", encode);
                }
                return str.replace("{remark}", encode);
            }
            x.i("MicroMsg.PhoneRechargeUI", "old url");
            return URLDecoder.decode(str, ProtocolPackage.ServerEncoding) + String.format("?phone=%s&remark=%s", new Object[]{text, encode});
        } catch (Throwable e) {
            Throwable th = e;
            str2 = str;
            x.printErrStackTrace("MicroMsg.PhoneRechargeUI", th, "", new Object[0]);
            return str2;
        }
    }

    private void m(k kVar) {
        if (this.ion != null && this.ion.isShowing() && kVar.getType() != 497) {
            this.ion.dismiss();
            this.ion = null;
        }
    }

    private void n(final k kVar) {
        if (this.ion == null || !(this.ion == null || this.ion.isShowing())) {
            this.ion = com.tencent.mm.wallet_core.ui.g.a(this.mController.xRr, true, new OnCancelListener() {
                public final void onCancel(DialogInterface dialogInterface) {
                    g.CN().c(kVar);
                }
            });
        }
        g.CN().a(kVar, 0);
    }

    protected void onResume() {
        super.onResume();
        w(false, true);
    }

    protected void onDestroy() {
        super.onDestroy();
        g.CN().b(1571, (e) this);
        g.CN().b(498, (e) this);
        com.tencent.mm.sdk.b.a.xmy.c(this.plr);
    }

    private void w(boolean z, boolean z2) {
        boolean z3;
        Iterator it;
        TextView textView;
        CharSequence string;
        MallFunction mallFunction;
        final String str;
        if (this.pIS != null) {
            if (this.pIS != null) {
                String str2 = (String) g.Dq().Db().get(w.a.USERINFO_PHONE_RECHARGE_CLOSED_BANNER_STRING, (Object) "");
                if (bi.oN(str2)) {
                    x.i("MicroMsg.PhoneRechargeUI", "hy: no banner before, show");
                    z3 = false;
                } else {
                    String[] split = str2.split(";");
                    if (split != null) {
                        for (String str3 : split) {
                            if (str3 != null && str3.equals(String.valueOf(this.pIS.id))) {
                                x.i("MicroMsg.PhoneRechargeUI", "hy: found closed. ");
                                z3 = true;
                                break;
                            }
                        }
                    }
                    x.i("MicroMsg.PhoneRechargeUI", "hy: not found closed banner.");
                    z3 = false;
                }
            } else {
                x.e("MicroMsg.PhoneRechargeUI", "hy: no banner");
                z3 = true;
            }
            if (!z3) {
                this.pIw.setVisibility(0);
                this.pIy.setText(this.pIS.name);
                x.d("MicroMsg.PhoneRechargeUI", "hy: Show banner!");
                com.tencent.mm.protocal.f.eE(6, 0);
                this.pIK.pIr = this.pHM;
                this.pIK.notifyDataSetChanged();
                this.pIL.pIr = this.pHN;
                this.pIL.notifyDataSetChanged();
                if (z) {
                    this.pII.setVisibility(8);
                } else {
                    it = this.pHM.iterator();
                    while (it.hasNext()) {
                        if (((n) it.next()).status != 0) {
                            z3 = false;
                            break;
                        }
                    }
                    z3 = true;
                    if (z3) {
                        this.pII.setVisibility(8);
                    } else {
                        this.pII.setVisibility(0);
                    }
                    it = this.pHN.iterator();
                    while (it.hasNext()) {
                        if (((n) it.next()).status != 0) {
                            z3 = false;
                            break;
                        }
                    }
                    z3 = true;
                    if (z3) {
                        this.pIJ.setVisibility(0);
                        if (z2) {
                            addTextOptionMenu(0, this.pHS.name, new OnMenuItemClickListener() {
                                public final boolean onMenuItemClick(MenuItem menuItem) {
                                    try {
                                        PhoneRechargeUI.d(PhoneRechargeUI.this, URLDecoder.decode(PhoneRechargeUI.this.pHS.url, ProtocolPackage.ServerEncoding));
                                    } catch (Throwable e) {
                                        x.printErrStackTrace("MicroMsg.PhoneRechargeUI", e, "", new Object[0]);
                                    }
                                    return false;
                                }
                            });
                        }
                        textView = this.pIA;
                        string = (this.pHM != null || this.pHM.size() <= 0 || bi.oN(((n) this.pHM.get(0)).sJQ)) ? getString(i.vcr) : ((n) this.pHM.get(0)).sJQ;
                        textView.setText(string);
                        textView = this.pIB;
                        string = (this.pHN != null || this.pHN.size() <= 0 || bi.oN(((n) this.pHN.get(0)).sJQ)) ? getString(i.vcs) : ((n) this.pHN.get(0)).sJQ;
                        textView.setText(string);
                        if (this.pHR != null || bi.oN(this.pHR.name) || bi.oN(this.pHR.url)) {
                            this.pIF.setVisibility(8);
                        } else {
                            this.pIF.setVisibility(0);
                            this.pIF.setText(this.pHR.name);
                            this.pIF.setOnClickListener(new View.OnClickListener() {
                                public final void onClick(View view) {
                                    x.d("MicroMsg.PhoneRechargeUI", "go to h5: %s", PhoneRechargeUI.this.IK(PhoneRechargeUI.this.pHR.url));
                                    PhoneRechargeUI.d(PhoneRechargeUI.this, r0);
                                }
                            });
                        }
                        if (this.pHO != null || bi.oN(this.pHO.name) || bi.oN(this.pHO.url)) {
                            this.pIE.setVisibility(8);
                        } else {
                            this.pIE.setVisibility(0);
                            this.pIE.setText(this.pHO.name);
                            this.pIE.setOnClickListener(new View.OnClickListener() {
                                public final void onClick(View view) {
                                    x.d("MicroMsg.PhoneRechargeUI", "go to h5: %s", PhoneRechargeUI.this.IK(PhoneRechargeUI.this.pHO.url));
                                    PhoneRechargeUI.d(PhoneRechargeUI.this, r0);
                                }
                            });
                        }
                        if (this.pHP != null || bi.oN(this.pHP.name) || bi.oN(this.pHP.url)) {
                            this.pIG.setVisibility(8);
                        } else {
                            this.pIG.setVisibility(0);
                            this.pIG.setText(this.pHP.name);
                            this.pIG.setOnClickListener(new View.OnClickListener() {
                                public final void onClick(View view) {
                                    x.d("MicroMsg.PhoneRechargeUI", "go to h5: %s", PhoneRechargeUI.this.IK(PhoneRechargeUI.this.pHP.url));
                                    PhoneRechargeUI.d(PhoneRechargeUI.this, r0);
                                }
                            });
                        }
                        if (this.pHQ != null || bi.oN(this.pHQ.name) || bi.oN(this.pHQ.url)) {
                            this.pIH.setVisibility(8);
                        } else {
                            this.pIH.setVisibility(0);
                            this.pIH.setText(this.pHQ.name);
                            this.pIH.setOnClickListener(new View.OnClickListener() {
                                public final void onClick(View view) {
                                    x.d("MicroMsg.PhoneRechargeUI", "go to h5: %s", PhoneRechargeUI.this.IK(PhoneRechargeUI.this.pHQ.url));
                                    PhoneRechargeUI.d(PhoneRechargeUI.this, r0);
                                }
                            });
                        }
                        mallFunction = this.pIM;
                        if (mallFunction.sWC == null && mallFunction.sWC.sUJ == 1 && !bi.oN(mallFunction.sWC.sWS)) {
                            g.Dr();
                            z3 = !((Boolean) g.Dq().Db().get(w.a.USERINFO_RECHARGE_SHOW_REMIND_BOOLEAN, Boolean.valueOf(false))).booleanValue();
                        } else {
                            z3 = false;
                        }
                        if (!z3) {
                            g.Dr();
                            g.Dq().Db().a(w.a.USERINFO_RECHARGE_SHOW_REMIND_BOOLEAN, Boolean.valueOf(true));
                            x.d("MicroMsg.PhoneRechargeUI", this.pIM.sWC.toString());
                            str = this.pIM.sWC.sWS;
                            h.a(this.mController.xRr, getString(i.vcB), v.fw(this).inflate(com.tencent.mm.plugin.wxpay.a.g.uKy, null), getString(i.vcC), getString(i.vcA), new OnClickListener() {
                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    x.d("MicroMsg.PhoneRechargeUI", "go to h5: %s", PhoneRechargeUI.this.IK(str));
                                    PhoneRechargeUI.d(PhoneRechargeUI.this, r0);
                                }
                            }, new OnClickListener() {
                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    dialogInterface.dismiss();
                                }
                            });
                        }
                    }
                }
                this.pIJ.setVisibility(8);
                if (z2) {
                    addTextOptionMenu(0, this.pHS.name, /* anonymous class already generated */);
                }
                textView = this.pIA;
                if (this.pHM != null) {
                }
                textView.setText(string);
                textView = this.pIB;
                if (this.pHN != null) {
                }
                textView.setText(string);
                if (this.pHR != null) {
                }
                this.pIF.setVisibility(8);
                if (this.pHO != null) {
                }
                this.pIE.setVisibility(8);
                if (this.pHP != null) {
                }
                this.pIG.setVisibility(8);
                if (this.pHQ != null) {
                }
                this.pIH.setVisibility(8);
                mallFunction = this.pIM;
                if (mallFunction.sWC == null) {
                }
                z3 = false;
                if (!z3) {
                    g.Dr();
                    g.Dq().Db().a(w.a.USERINFO_RECHARGE_SHOW_REMIND_BOOLEAN, Boolean.valueOf(true));
                    x.d("MicroMsg.PhoneRechargeUI", this.pIM.sWC.toString());
                    str = this.pIM.sWC.sWS;
                    h.a(this.mController.xRr, getString(i.vcB), v.fw(this).inflate(com.tencent.mm.plugin.wxpay.a.g.uKy, null), getString(i.vcC), getString(i.vcA), /* anonymous class already generated */, /* anonymous class already generated */);
                }
            }
        }
        this.pIw.setVisibility(8);
        x.d("MicroMsg.PhoneRechargeUI", "hy: dismiss banner!");
        this.pIK.pIr = this.pHM;
        this.pIK.notifyDataSetChanged();
        this.pIL.pIr = this.pHN;
        this.pIL.notifyDataSetChanged();
        if (z) {
            it = this.pHM.iterator();
            while (it.hasNext()) {
                if (((n) it.next()).status != 0) {
                    z3 = false;
                    break;
                }
            }
            z3 = true;
            if (z3) {
                this.pII.setVisibility(8);
            } else {
                this.pII.setVisibility(0);
            }
            it = this.pHN.iterator();
            while (it.hasNext()) {
                if (((n) it.next()).status != 0) {
                    z3 = false;
                    break;
                }
            }
            z3 = true;
            if (z3) {
                this.pIJ.setVisibility(0);
                if (z2) {
                    addTextOptionMenu(0, this.pHS.name, /* anonymous class already generated */);
                }
                textView = this.pIA;
                if (this.pHM != null) {
                }
                textView.setText(string);
                textView = this.pIB;
                if (this.pHN != null) {
                }
                textView.setText(string);
                if (this.pHR != null) {
                }
                this.pIF.setVisibility(8);
                if (this.pHO != null) {
                }
                this.pIE.setVisibility(8);
                if (this.pHP != null) {
                }
                this.pIG.setVisibility(8);
                if (this.pHQ != null) {
                }
                this.pIH.setVisibility(8);
                mallFunction = this.pIM;
                if (mallFunction.sWC == null) {
                }
                z3 = false;
                if (!z3) {
                    g.Dr();
                    g.Dq().Db().a(w.a.USERINFO_RECHARGE_SHOW_REMIND_BOOLEAN, Boolean.valueOf(true));
                    x.d("MicroMsg.PhoneRechargeUI", this.pIM.sWC.toString());
                    str = this.pIM.sWC.sWS;
                    h.a(this.mController.xRr, getString(i.vcB), v.fw(this).inflate(com.tencent.mm.plugin.wxpay.a.g.uKy, null), getString(i.vcC), getString(i.vcA), /* anonymous class already generated */, /* anonymous class already generated */);
                }
            }
        }
        this.pII.setVisibility(8);
        this.pIJ.setVisibility(8);
        if (z2) {
            addTextOptionMenu(0, this.pHS.name, /* anonymous class already generated */);
        }
        textView = this.pIA;
        if (this.pHM != null) {
        }
        textView.setText(string);
        textView = this.pIB;
        if (this.pHN != null) {
        }
        textView.setText(string);
        if (this.pHR != null) {
        }
        this.pIF.setVisibility(8);
        if (this.pHO != null) {
        }
        this.pIE.setVisibility(8);
        if (this.pHP != null) {
        }
        this.pIG.setVisibility(8);
        if (this.pHQ != null) {
        }
        this.pIH.setVisibility(8);
        mallFunction = this.pIM;
        if (mallFunction.sWC == null) {
        }
        z3 = false;
        if (!z3) {
            g.Dr();
            g.Dq().Db().a(w.a.USERINFO_RECHARGE_SHOW_REMIND_BOOLEAN, Boolean.valueOf(true));
            x.d("MicroMsg.PhoneRechargeUI", this.pIM.sWC.toString());
            str = this.pIM.sWC.sWS;
            h.a(this.mController.xRr, getString(i.vcB), v.fw(this).inflate(com.tencent.mm.plugin.wxpay.a.g.uKy, null), getString(i.vcC), getString(i.vcA), /* anonymous class already generated */, /* anonymous class already generated */);
        }
    }

    private void bnf() {
        this.pHM = new ArrayList();
        n nVar = new n();
        nVar.name = getString(i.vch);
        nVar.status = 0;
        n nVar2 = new n();
        nVar2.name = getString(i.vci);
        nVar2.status = 0;
        n nVar3 = new n();
        nVar3.name = getString(i.vcj);
        nVar3.status = 0;
        n nVar4 = new n();
        nVar4.name = getString(i.vck);
        nVar4.status = 0;
        n nVar5 = new n();
        nVar5.name = getString(i.vcl);
        nVar5.status = 0;
        n nVar6 = new n();
        nVar6.name = getString(i.vcm);
        nVar6.status = 0;
        this.pHM.add(nVar);
        this.pHM.add(nVar2);
        this.pHM.add(nVar3);
        this.pHM.add(nVar4);
        this.pHM.add(nVar5);
        this.pHM.add(nVar6);
        this.pHN = new ArrayList();
        nVar = new n();
        nVar.name = getString(i.vcn);
        nVar.status = 0;
        nVar2 = new n();
        nVar2.name = getString(i.vco);
        nVar2.status = 0;
        nVar3 = new n();
        nVar3.name = getString(i.vcp);
        nVar3.status = 0;
        this.pHN.add(nVar);
        this.pHN.add(nVar2);
        this.pHN.add(nVar3);
    }

    protected final int getLayoutId() {
        return com.tencent.mm.plugin.wxpay.a.g.uJW;
    }

    private void IL(String str) {
        h.a((Context) this, str, "", false, new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (kVar instanceof f) {
            f fVar = (f) kVar;
            if (fVar.cmdId != 0) {
                x.i("MicroMsg.PhoneRechargeUI", "do delete phone number");
            } else if (bi.oN(fVar.pny) || fVar.pny.equals(this.pIz.getText())) {
                m(kVar);
                if (fVar.pHL) {
                    x.e("MicroMsg.PhoneRechargeUI", "hy: cgi failed.");
                    IL(fVar.foE);
                    bne();
                    return;
                }
                boolean z;
                boolean z2;
                this.mAppId = fVar.appId;
                this.pHM = fVar.pHM;
                this.pHO = fVar.pHO;
                this.pHP = fVar.pHP;
                this.pHQ = fVar.pHQ;
                this.pHR = fVar.pHR;
                this.errCode = fVar.errCode;
                this.foE = fVar.foE;
                this.pIN = fVar.desc;
                x.i("MicroMsg.PhoneRechargeUI", "desc: %s, mobile: %s", this.pIN, this.pIz.getText());
                if (bi.oN(this.pIN)) {
                    this.desc = "";
                    this.pIO = getResources().getColor(com.tencent.mm.plugin.wxpay.a.c.btv);
                } else if (this.pIR.pId != null && this.pIR.pId.pHq.trim().equals(this.pIz.getText())) {
                    this.pIR.pId.pHr = this.pIN;
                    this.pIR.b(this.pIR.pId);
                }
                this.pIS = fVar.pHT;
                this.pHN = fVar.pHN;
                for (int size = this.pHN.size() - 1; size >= 0; size--) {
                    n nVar = (n) this.pHN.get(size);
                    if (nVar.name.isEmpty()) {
                        this.pHN.remove(nVar);
                    }
                }
                if (fVar.pHS == null || (fVar.pHS.name.equals(this.pHS.name) && fVar.pHS.url.equals(this.pHS.url))) {
                    z = false;
                } else {
                    x.i("MicroMsg.PhoneRechargeUI", "need to update head");
                    this.pHS = fVar.pHS;
                    z = true;
                }
                if (this.pIN.equals("")) {
                    z2 = false;
                } else {
                    z2 = true;
                }
                w(z2, z);
                List list = fVar.pHU;
                if (list != null) {
                    x.d("MicroMsg.PhoneRechargeUI", "update record history");
                    com.tencent.mm.plugin.recharge.a.a.bmX().bv(list);
                    if (this.pIR != null) {
                        if (fVar.pHV) {
                            this.pIR.hC(true);
                        } else {
                            this.pIR.hC(false);
                        }
                    }
                }
                this.pIz.postDelayed(new Runnable() {
                    public final void run() {
                        PhoneRechargeUI.this.pIz.bnp();
                    }
                }, 300);
            } else {
                x.i("MicroMsg.PhoneRechargeUI", "hy: mobiel num not match.abourt, %s, %s", fVar.pny, this.pIz.getText());
            }
        } else if (kVar instanceof com.tencent.mm.plugin.recharge.model.g) {
            m(kVar);
            if (i == 0 && i2 == 0) {
                PayInfo payInfo = ((com.tencent.mm.plugin.recharge.model.g) kVar).pHW;
                payInfo.fDQ = 6;
                payInfo.vGi = 100;
                payInfo.kPP = this.pIz.getText();
                payInfo.iLo = this.pIR.pId != null ? this.pIR.pId.name : "";
                com.tencent.mm.pluginsdk.wallet.h.a((Context) this, payInfo, 2);
                com.tencent.mm.sdk.b.a.xmy.b(this.plr);
                return;
            }
            IL(str);
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        String str = null;
        switch (i) {
            case 1:
                if (i2 == -1) {
                    this.pIT = true;
                    final List arrayList = new ArrayList();
                    Uri data = intent.getData();
                    if (data != null) {
                        if (com.tencent.mm.pluginsdk.g.a.aZ(this, "android.permission.READ_CONTACTS")) {
                            try {
                                Cursor query = getContentResolver().query(data, null, null, null, null);
                                if (query != null && query.getCount() > 0) {
                                    query.moveToFirst();
                                    int columnIndex = query.getColumnIndex("has_phone_number");
                                    if (columnIndex <= 0 || query.getInt(columnIndex) > 0) {
                                        String string = query.getString(query.getColumnIndex("_id"));
                                        Cursor query2 = getContentResolver().query(Phone.CONTENT_URI, null, "contact_id = " + string, null, null);
                                        if (query2 != null && query2.moveToFirst()) {
                                            String str2 = null;
                                            while (!query2.isAfterLast()) {
                                                columnIndex = query2.getColumnIndex("data1");
                                                int columnIndex2 = query2.getColumnIndex(SlookAirButtonFrequentContactAdapter.DISPLAY_NAME);
                                                String string2 = query2.getString(columnIndex);
                                                str2 = query2.getString(columnIndex2);
                                                x.d("MicroMsg.PhoneRechargeUI", "hy: username : " + str2);
                                                if (string2 != null) {
                                                    x.d("MicroMsg.PhoneRechargeUI", "hy: phoneNumber : " + string2);
                                                    string = com.tencent.mm.plugin.recharge.model.b.II(string2);
                                                    x.d("MicroMsg.PhoneRechargeUI", "hy: phoneNumber : " + string);
                                                    if (PhoneNumberUtils.isGlobalPhoneNumber(string) && string.length() == 11) {
                                                        arrayList.add(string);
                                                    }
                                                    x.d("MicroMsg.PhoneRechargeUI", "hy: phoneResult : " + string);
                                                }
                                                query2.moveToNext();
                                            }
                                            str = str2;
                                        }
                                        if (query2 != null) {
                                            query2.close();
                                        }
                                    }
                                }
                                if (!(query == null || query.isClosed())) {
                                    query.close();
                                }
                                if (arrayList.size() <= 1) {
                                    if (arrayList.size() != 1) {
                                        h.b(this, getString(i.uSx), "", true);
                                        break;
                                    }
                                    this.pIR.b(new com.tencent.mm.plugin.recharge.model.a((String) arrayList.get(0), str, 1));
                                    bng();
                                    break;
                                }
                                com.tencent.mm.ui.base.i a = h.a((Context) this, getString(i.vcz), arrayList, -1, new h.a() {
                                    public final void vE(int i) {
                                        x.d("MicroMsg.PhoneRechargeUI", "choose: %d", Integer.valueOf(i));
                                        PhoneRechargeUI.this.pIR.b(new com.tencent.mm.plugin.recharge.model.a((String) arrayList.get(i), str, 1));
                                        PhoneRechargeUI.this.bng();
                                    }
                                });
                                if (a != null) {
                                    a.setCanceledOnTouchOutside(true);
                                    break;
                                }
                            } catch (SecurityException e) {
                                x.e("MicroMsg.PhoneRechargeUI", "hy: permission denied: %s", e.toString());
                                h.b(this, getString(i.uSz), "", true);
                                break;
                            }
                        }
                        x.e("MicroMsg.PhoneRechargeUI", "no contact permission");
                        return;
                    }
                    x.e("MicroMsg.PhoneRechargeUI", "hy: uri == null");
                    return;
                }
                break;
            case 2:
                if (i2 == -1) {
                    if (!this.plo) {
                        x.i("MicroMsg.PhoneRechargeUI", "hy: MallRecharge pay result : ok");
                        com.tencent.mm.plugin.recharge.a.a.bmX().a(new com.tencent.mm.plugin.recharge.model.a(this.pIz.getText(), this.pIz.pJS.getText().toString(), 0));
                        finish();
                        this.plo = true;
                        break;
                    }
                }
                x.i("MicroMsg.PhoneRechargeUI", "hy: MallRecharge pay result : cancel");
                break;
                break;
        }
        super.onActivityResult(i, i2, intent);
    }

    private void bng() {
        g.CN().a(new f(this.pIz.getText()), 0);
    }

    public final void bnh() {
        g.CN().a(new f("", 1), 0);
    }
}
