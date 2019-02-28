package com.tencent.mm.plugin.card.ui;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mm.R;
import com.tencent.mm.opensdk.channel.MMessageActV2;
import com.tencent.mm.opensdk.channel.MMessageActV2.Args;
import com.tencent.mm.opensdk.modelbiz.AddCardToWXCardPackage.Resp;
import com.tencent.mm.plugin.card.b.h;
import com.tencent.mm.plugin.card.model.e;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.protocal.c.kp;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@a(3)
public class CardAddEntranceUI extends MMActivity {
    private String appId;
    private int fHR = 8;
    LinkedList<kp> kVJ = new LinkedList();
    private String kVU = "";
    private String kVV;
    private int kVW = 0;

    protected final int getLayoutId() {
        return R.i.dbN;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        if (intent == null) {
            x.e("MicroMsg.CardAddEntranceUI", "CardAddEntranceUI onCreate() intent == null");
            setResult(0);
            finish();
            return;
        }
        x.i("MicroMsg.CardAddEntranceUI", "CardAddEntranceUI doRediect() handle data");
        String stringExtra = intent.getStringExtra("key_in_card_list");
        this.fHR = intent.getIntExtra("key_from_scene", 8);
        this.kVW = intent.getIntExtra("key_stastic_scene", 0);
        x.i("MicroMsg.CardAddEntranceUI", "doRediect() from_scene:" + this.fHR + "  from_origin_scene:" + this.kVW);
        this.kVU = intent.getStringExtra("key_package_name");
        String stringExtra2 = intent.getStringExtra("key_sign");
        String stringExtra3 = getIntent().getStringExtra("src_username");
        x.i("MicroMsg.CardAddEntranceUI", "doRediect() src_username:" + stringExtra3);
        String stringExtra4 = getIntent().getStringExtra("js_url");
        this.appId = getIntent().getStringExtra("key_app_id");
        this.kVV = getIntent().getStringExtra("key_transaction");
        String stringExtra5 = getIntent().getStringExtra("key_consumed_card_id");
        x.i("MicroMsg.CardAddEntranceUI", "doRediect() consumedCardId:" + stringExtra5);
        String stringExtra6 = getIntent().getStringExtra("key_template_id");
        List aZ = h.aZ(stringExtra, this.fHR);
        if (aZ == null || aZ.size() == 0) {
            x.e("MicroMsg.CardAddEntranceUI", "CardAddEntranceUI initView () tempList == null || tempList.size() == 0");
            setResult(0);
            finish();
            return;
        }
        this.kVJ.clear();
        this.kVJ.addAll(aZ);
        Intent intent2 = new Intent();
        intent2.putExtra("key_from_scene", this.fHR);
        intent2.putExtra("key_stastic_scene", this.kVW);
        if (aZ.size() == 1) {
            kp kpVar = (kp) aZ.get(0);
            intent2.putExtra("key_card_id", kpVar.kPy);
            intent2.putExtra("key_card_ext", kpVar.fHQ);
            intent2.putExtra("src_username", stringExtra3);
            intent2.putExtra("js_url", stringExtra4);
            intent2.putExtra("key_consumed_card_id", stringExtra5);
            intent2.putExtra("key_template_id", stringExtra6);
            intent2.putExtra("key_from_appbrand_type", intent.getIntExtra("key_from_appbrand_type", 0));
            intent2.setClass(this, CardDetailUI.class);
            startActivityForResult(intent2, 1);
            return;
        }
        intent2.putExtra("key_in_card_list", stringExtra);
        intent2.putExtra("key_package_name", this.kVU);
        intent2.putExtra("key_sign", stringExtra2);
        intent2.putExtra("src_username", stringExtra3);
        intent2.putExtra("js_url", stringExtra4);
        intent2.putExtra("key_consumed_card_id", stringExtra5);
        intent2.putExtra("key_template_id", stringExtra6);
        intent2.setClass(this, CardAcceptCardListUI.class);
        startActivityForResult(intent2, 2);
    }

    protected void onDestroy() {
        super.onDestroy();
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        x.v("MicroMsg.CardAddEntranceUI", "CardAddEntranceUI onActivityResult");
        if (i2 == -1) {
            x.i("MicroMsg.CardAddEntranceUI", "CardAddEntranceUI RESULT_OK");
        } else {
            x.i("MicroMsg.CardAddEntranceUI", "CardAddEntranceUI RESULT_CANCELED");
        }
        LinkedList linkedList = new LinkedList();
        Iterator it = this.kVJ.iterator();
        while (it.hasNext()) {
            kp kpVar = (kp) it.next();
            e eVar = new e();
            eVar.kPy = kpVar.kPy;
            eVar.fHQ = kpVar.fHQ;
            linkedList.add(eVar);
        }
        Intent intent2;
        if (i != 1) {
            if (i == 2) {
                x.i("MicroMsg.CardAddEntranceUI", "CardAddEntranceUI REQUEST_CARD_ACCEPT_CARD_LIST");
                Object obj = "";
                if (intent != null) {
                    obj = intent.getStringExtra("card_list");
                }
                if (this.fHR != 7 && this.fHR != 16) {
                    if (this.fHR != 26) {
                        switch (i2) {
                            case -1:
                                if (!TextUtils.isEmpty(obj)) {
                                    Z(-1, obj);
                                    break;
                                } else {
                                    Z(-1, h.a(linkedList, true, this.fHR));
                                    break;
                                }
                            case 0:
                                if (!TextUtils.isEmpty(obj)) {
                                    Z(0, obj);
                                    break;
                                } else {
                                    Z(0, h.a(linkedList, false, this.fHR));
                                    break;
                                }
                        }
                    }
                    intent2 = new Intent();
                    switch (i2) {
                        case -1:
                            if (intent != null && !TextUtils.isEmpty(obj)) {
                                intent.putExtra("card_list", h.ba(obj, this.fHR));
                                setResult(-1, intent);
                                break;
                            }
                            intent2.putExtra("card_list", h.a(linkedList, true, this.fHR));
                            setResult(-1, intent2);
                            break;
                        case 0:
                            if (intent != null && !TextUtils.isEmpty(obj)) {
                                intent.putExtra("card_list", h.ba(obj, this.fHR));
                                setResult(0, intent);
                                break;
                            }
                            intent2.putExtra("card_list", h.a(linkedList, false, this.fHR));
                            intent2.putExtra("result_code", 1);
                            setResult(0, intent2);
                            break;
                    }
                }
                intent2 = new Intent();
                switch (i2) {
                    case -1:
                        if (intent != null && !TextUtils.isEmpty(obj)) {
                            intent.putExtra("card_list", h.ba(obj, this.fHR));
                            setResult(-1, intent);
                            break;
                        }
                        intent2.putExtra("card_list", h.a(linkedList, true, this.fHR));
                        setResult(-1, intent2);
                        break;
                        break;
                    case 0:
                        if (intent != null && !TextUtils.isEmpty(obj)) {
                            intent.putExtra("card_list", h.ba(obj, this.fHR));
                            setResult(0, intent);
                            break;
                        }
                        intent2.putExtra("card_list", h.a(linkedList, false, this.fHR));
                        intent2.putExtra("result_code", 1);
                        setResult(0, intent2);
                        break;
                }
            }
        }
        x.i("MicroMsg.CardAddEntranceUI", "CardAddEntranceUI REQUEST_CARD_DETAIL");
        if (this.fHR != 7 && this.fHR != 16) {
            if (this.fHR != 26) {
                switch (i2) {
                    case -1:
                        if (intent != null && linkedList.size() > 0) {
                            ((e) linkedList.get(0)).code = intent.getStringExtra("key_code");
                        }
                        Z(-1, h.a(linkedList, true, this.fHR));
                        break;
                    case 0:
                        Z(0, h.a(linkedList, false, this.fHR));
                        break;
                }
            }
            intent2 = new Intent();
            switch (i2) {
                case -1:
                    if (intent != null && linkedList.size() > 0) {
                        ((e) linkedList.get(0)).code = intent.getStringExtra("key_code");
                    }
                    intent2.putExtra("card_list", h.a(linkedList, true, this.fHR));
                    setResult(-1, intent2);
                    break;
                case 0:
                    intent2.putExtra("card_list", h.a(linkedList, false, this.fHR));
                    setResult(0, intent2);
                    break;
            }
        }
        intent2 = new Intent();
        switch (i2) {
            case -1:
                if (intent != null && linkedList.size() > 0) {
                    ((e) linkedList.get(0)).code = intent.getStringExtra("key_code");
                }
                intent2.putExtra("card_list", h.a(linkedList, true, this.fHR));
                setResult(-1, intent2);
                break;
            case 0:
                intent2.putExtra("card_list", h.a(linkedList, false, this.fHR));
                setResult(0, intent2);
                break;
        }
        finish();
    }

    private void Z(int i, String str) {
        Bundle bundle = new Bundle();
        bundle.putString("_wxapi_add_card_to_wx_card_list", str);
        f aZ = g.aZ(this.appId, true);
        Resp resp = new Resp(bundle);
        if (aZ != null) {
            resp.openId = aZ.field_openId;
        }
        resp.transaction = this.kVV;
        String str2 = "MicroMsg.CardAddEntranceUI";
        String str3 = "setResultToSDK, appid : %s, appname : %s, openid : %s, transcation : %s";
        Object[] objArr = new Object[4];
        objArr[0] = this.appId;
        objArr[1] = aZ == null ? "null appinfo" : aZ.field_appName;
        objArr[2] = aZ == null ? "null appinfo" : aZ.field_openId;
        objArr[3] = this.kVV;
        x.i(str2, str3, objArr);
        resp.toBundle(bundle);
        x.i("MicroMsg.CardAddEntranceUI", "setResultToSDK result:" + i);
        if (i == -1) {
            resp.errCode = 0;
        } else {
            resp.errCode = -2;
        }
        Args args = new Args();
        args.targetPkgName = this.kVU;
        args.bundle = bundle;
        p.ae(bundle);
        p.af(bundle);
        MMessageActV2.send(ad.getContext(), args);
    }
}
