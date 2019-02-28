package com.tencent.mm.plugin.wallet_core.c;

import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.mm.plugin.wallet_core.id_verify.model.Profession;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.ElementQuery;
import com.tencent.mm.plugin.wallet_core.model.q;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.c.o;
import com.tencent.mm.wallet_core.tenpay.model.i;
import com.tencent.mm.wallet_core.ui.e;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public final class t extends i {
    public String kOh;
    public String mTimeStamp;
    public String pOY;
    public List<ElementQuery> sOR;
    public ElementQuery sOS;
    private int sOT;
    private int sOU;
    private int sOV;
    public Profession[] sOW;

    public t(String str, String str2, PayInfo payInfo) {
        this(3, str, str2, payInfo, null, -1, -1);
    }

    public t(String str, String str2, PayInfo payInfo, int i) {
        this(3, str, str2, payInfo, null, -1, i);
    }

    public t(String str, String str2, PayInfo payInfo, String str3, int i, int i2) {
        this(3, str, str2, payInfo, str3, i, i2);
    }

    public t() {
        this(3, null, null, null, null, -1, -1);
    }

    private t(int i, String str, String str2, PayInfo payInfo, String str3, int i2, int i3) {
        this.sOR = null;
        this.sOS = null;
        this.mTimeStamp = null;
        this.kOh = null;
        this.pOY = null;
        this.sOT = 3;
        this.sOW = null;
        this.kOh = str2;
        this.sOT = 3;
        Map hashMap = new HashMap();
        Map hashMap2 = new HashMap();
        a(payInfo, hashMap, hashMap2);
        hashMap.put("req_key", str);
        hashMap.put("flag", "4");
        hashMap.put("card_id", str2);
        if (i3 > 0) {
            hashMap.put("realname_scene", String.valueOf(i3));
            x.i("MicroMsg.NetSenceTenPayBase", "realname_scene=%d", Integer.valueOf(i3));
        }
        if (i2 == 8) {
            hashMap.put("scene", "1003");
        }
        hashMap.put("bank_card_tag", new StringBuilder(TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL).toString());
        hashMap.put("token", str3);
        D(hashMap);
        if (o.cCj()) {
            hashMap2.put("uuid_for_bindcard", o.cCl());
            hashMap2.put("bindcard_scene", o.cCk());
        }
        aB(hashMap2);
    }

    public final int azx() {
        return 73;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        this.sOR = new ArrayList();
        try {
            String str2;
            int i2;
            JSONObject jSONObject2;
            this.mTimeStamp = jSONObject.optString("time_stamp");
            String optString = jSONObject.optString("bank_type");
            if (bi.oN(this.pOY)) {
                str2 = optString;
            } else {
                str2 = this.pOY;
            }
            JSONArray jSONArray = jSONObject.getJSONArray("Array");
            int length = jSONArray.length();
            for (i2 = 0; i2 < length; i2++) {
                jSONObject2 = jSONArray.getJSONObject(i2);
                ElementQuery elementQuery = new ElementQuery();
                elementQuery.hqe = jSONObject2;
                elementQuery.nHt = jSONObject2.optString("bank_name");
                elementQuery.pff = jSONObject2.optString("bank_type");
                elementQuery.sSJ = jSONObject2.optString("bankacc_type_name");
                elementQuery.sSL = jSONObject2.optString("bank_phone");
                elementQuery.sSO = jSONObject2.optString("forbid_word");
                elementQuery.sSN = jSONObject2.optString("bank_recommend_desc");
                elementQuery.sSM = jSONObject2.optString("bank_app_user_name");
                elementQuery.sSI = jSONObject2.optInt("bankacc_type", 1);
                elementQuery.sSB = e.h(jSONObject2, "canModifyName");
                elementQuery.sSC = e.h(jSONObject2, "canModifyCreID");
                elementQuery.sSG = "0".equals(jSONObject2.optString("is_sure"));
                elementQuery.sSD = "1".equals(jSONObject2.optString("needCVV"));
                elementQuery.sSE = "1".equals(jSONObject2.optString("needValiDate"));
                elementQuery.sSA = jSONObject2.optString("time_stamp");
                elementQuery.sSF = jSONObject2.optString("uesr_name");
                elementQuery.sSK = jSONObject2.optString("bank_flag");
                elementQuery.sSP = e.h(jSONObject2, "needFirstName");
                elementQuery.sSQ = e.h(jSONObject2, "needLastName");
                elementQuery.sSR = e.h(jSONObject2, "needCountry");
                elementQuery.sSS = e.h(jSONObject2, "needArea");
                elementQuery.sST = e.h(jSONObject2, "needCity");
                elementQuery.sSU = e.h(jSONObject2, "needAddress");
                elementQuery.sSV = e.h(jSONObject2, "needZip");
                elementQuery.sSW = e.h(jSONObject2, "needPhone");
                elementQuery.sSX = e.h(jSONObject2, "needEmail");
                elementQuery.sTa = e.h(jSONObject2, "needShowProtocol");
                elementQuery.sSY = jSONObject2.optString("support_cre_type");
                elementQuery.sOT = jSONObject2.optInt("bank_card_tag", 1);
                if (elementQuery.sOT == 1) {
                    if (!e.h(jSONObject2, "IsSaveYfq")) {
                        elementQuery.sSH = 0;
                    } else if (e.h(jSONObject2, "canReturnYfq")) {
                        elementQuery.sSH = 4;
                    } else {
                        elementQuery.sSH = 3;
                    }
                } else if (jSONObject2.optInt("auth_mode") == 1) {
                    elementQuery.sSH = 1;
                } else {
                    elementQuery.sSH = 2;
                }
                CharSequence optString2 = jSONObject2.optString("support_micropay");
                if (TextUtils.isEmpty(optString2)) {
                    elementQuery.sTb = true;
                } else if ("1".equals(optString2)) {
                    elementQuery.sTb = true;
                } else if ("0".equals(optString2)) {
                    elementQuery.sTb = false;
                }
                elementQuery.sQK = jSONObject2.optString("arrive_type");
                if (Bankcard.ec(this.sOT, elementQuery.sOT)) {
                    this.sOR.add(elementQuery);
                }
                if (str2 != null && str2.equals(elementQuery.pff)) {
                    this.sOS = elementQuery;
                }
            }
            SparseArray sparseArray = new SparseArray();
            jSONArray = jSONObject.getJSONArray("cre_type_map");
            length = jSONArray.length();
            for (i2 = 0; i2 < length; i2++) {
                jSONObject2 = jSONArray.getJSONObject(i2);
                int optInt = jSONObject2.optInt("key", 0);
                if (optInt > 0) {
                    sparseArray.put(optInt, jSONObject2.getString("val"));
                }
            }
            q bMk = com.tencent.mm.plugin.wallet_core.model.o.bMk();
            List list = this.sOR;
            bMk.sVx = sparseArray;
            bMk.sOR = list;
            this.sOU = jSONObject.optInt("need_area");
            this.sOV = jSONObject.optInt("need_profession");
            if (!(this.sOS == null || this.sOS.sOT == 1)) {
                x.i("MicroMsg.NetSenceTenPayBase", "oversea card, no need area and profession");
                this.sOU = 0;
                this.sOV = 0;
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("profession_array");
            if (optJSONArray != null) {
                this.sOW = new Profession[optJSONArray.length()];
                for (i2 = 0; i2 < optJSONArray.length(); i2++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
                    if (optJSONObject != null) {
                        String optString3 = optJSONObject.optString("profession_name");
                        int optInt2 = optJSONObject.optInt("profession_type");
                        if (bi.oN(optString3)) {
                            x.i("MicroMsg.NetSenceTenPayBase", "empty profession_name!");
                        } else {
                            this.sOW[i2] = new Profession(optString3, optInt2);
                        }
                    }
                }
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.NetSenceTenPayBase", e, "", new Object[0]);
        }
    }

    public final int Hx() {
        return 1505;
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/elementquerynew";
    }

    public final boolean bLu() {
        return this.sOU == 1;
    }

    public final boolean bLv() {
        return this.sOV == 1;
    }
}
