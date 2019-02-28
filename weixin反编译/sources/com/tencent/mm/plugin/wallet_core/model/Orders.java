package com.tencent.mm.plugin.wallet_core.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.bp.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet.a.f;
import com.tencent.mm.plugin.wallet.a.h;
import com.tencent.mm.plugin.wallet.a.k;
import com.tencent.mm.plugin.wallet.a.q;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.ui.e;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import d.a.a.c;
import d.a.a.d;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

public class Orders implements Parcelable {
    public static final Creator<Orders> CREATOR = new Creator<Orders>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new Orders(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new Orders[i];
        }
    };
    public static int sUr = 0;
    public static int sUs = 1;
    public String fqG;
    public String fvC = "";
    public String lUI = "";
    public String lhE = "0";
    public String oVl;
    public double pQx;
    public double pTQ = 0.0d;
    public String pgf;
    public int sOT;
    public String sQD;
    public long sTN;
    public double sTO = 0.0d;
    public int sTP;
    public String sTQ;
    public int sTR;
    public String sTS;
    public String sTT;
    public String sTU;
    public String sTV;
    public int sTW;
    public boolean sTX = false;
    public String sTY = "";
    public long sTZ = 0;
    public String sUa = "";
    public String sUb;
    public Set<String> sUc = new HashSet();
    public int sUd = 0;
    public String sUe = "";
    public List<Commodity> sUf = new ArrayList();
    public f sUg = new f();
    public int sUh = 0;
    public String sUi = "";
    public String sUj = "";
    public DeductInfo sUk;
    public long sUl;
    public long sUm;
    public int sUn = 0;
    public int sUo = 0;
    public int sUp = 0;
    public String sUq = "";
    public String token = "";
    public String username;

    public static class DeductInfo implements Parcelable {
        public static final Creator<DeductInfo> CREATOR = new Creator<DeductInfo>() {
            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new DeductInfo(parcel);
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new DeductInfo[i];
            }
        };
        public String desc;
        public String kRl;
        public int sLC;
        public String sLD;
        public int sMk;
        public String sUE;
        public List<DeductShowInfo> sUF = new ArrayList();
        public int sUG;
        public String sUH;
        public String title;

        public DeductInfo(Parcel parcel) {
            this.title = parcel.readString();
            this.desc = parcel.readString();
            this.sMk = parcel.readInt();
            this.sUE = parcel.readString();
            this.sUG = parcel.readInt();
            parcel.readTypedList(this.sUF, DeductShowInfo.CREATOR);
            this.sLC = parcel.readInt();
            this.kRl = parcel.readString();
            this.sLD = parcel.readString();
            this.sUH = parcel.readString();
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.title);
            parcel.writeString(this.desc);
            parcel.writeInt(this.sMk);
            parcel.writeString(this.sUE);
            parcel.writeInt(this.sUG);
            parcel.writeTypedList(this.sUF);
            parcel.writeInt(this.sLC);
            parcel.writeString(this.kRl);
            parcel.writeString(this.sLD);
            parcel.writeString(this.sUH);
        }
    }

    public static class DeductShowInfo implements Parcelable {
        public static final Creator<DeductShowInfo> CREATOR = new Creator<DeductShowInfo>() {
            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new DeductShowInfo(parcel);
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new DeductShowInfo[i];
            }
        };
        public String name;
        public String url;
        public String value;

        protected DeductShowInfo(Parcel parcel) {
            this.name = parcel.readString();
            this.value = parcel.readString();
            this.url = parcel.readString();
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.name);
            parcel.writeString(this.value);
            parcel.writeString(this.url);
        }
    }

    public static class Promotions implements Parcelable {
        public static final Creator<Promotions> CREATOR = new Creator<Promotions>() {
            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new Promotions(parcel);
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new Promotions[i];
            }
        };
        public String name;
        public String pgg;
        public String pkG;
        public long sOB;
        public int sTD;
        public int sTE;
        public long sTF;
        public String sTG;
        public int sUJ;
        public int sUK;
        public int sUL;
        public String sUM;
        public String sUN;
        public String sUO;
        public int sUP;
        public String sUQ;
        public String sUR;
        public c sUS;
        public String title;
        public int type;
        public String url;

        public Promotions(Parcel parcel) {
            this.type = parcel.readInt();
            this.pkG = parcel.readString();
            this.name = parcel.readString();
            this.sTG = parcel.readString();
            this.url = parcel.readString();
            this.pgg = parcel.readString();
            this.title = parcel.readString();
            this.sUJ = parcel.readInt();
            this.sOB = parcel.readLong();
            this.sUK = parcel.readInt();
            this.sUL = parcel.readInt();
            this.sTD = parcel.readInt();
            this.sTE = parcel.readInt();
            this.sUM = parcel.readString();
            this.sUN = parcel.readString();
            this.sUO = parcel.readString();
            this.sTF = parcel.readLong();
            this.sUP = parcel.readInt();
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.type);
            parcel.writeString(this.pkG);
            parcel.writeString(this.name);
            parcel.writeString(this.sTG);
            parcel.writeString(this.url);
            parcel.writeString(this.pgg);
            parcel.writeString(this.title);
            parcel.writeInt(this.sUJ);
            parcel.writeLong(this.sOB);
            parcel.writeInt(this.sUK);
            parcel.writeInt(this.sUL);
            parcel.writeInt(this.sTD);
            parcel.writeInt(this.sTE);
            parcel.writeString(this.sUM);
            parcel.writeString(this.sUN);
            parcel.writeString(this.sUO);
            parcel.writeLong(this.sTF);
            parcel.writeInt(this.sUP);
        }
    }

    public static class Commodity implements Parcelable {
        public static final Creator<Commodity> CREATOR = new Creator<Commodity>() {
            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new Commodity(parcel);
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new Commodity[i];
            }
        };
        public String desc;
        public String fvD;
        public double loS = 0.0d;
        public String pfI;
        public String pfR;
        public String pfS;
        public String pfT;
        public String pfU;
        public String pfW;
        public String pfY;
        public String pfZ;
        public int pgb;
        public String pgd;
        public String pgf;
        public String pgg;
        public String pgk;
        public int sTW;
        public RecommendTinyAppInfo sUA = null;
        public List<Promotions> sUB = new ArrayList();
        public boolean sUC = false;
        public a sUD = new a();
        public double sUt = 0.0d;
        public String sUu;
        public String sUv;
        public List<DiscountInfo> sUw = new ArrayList();
        public String sUx;
        public String sUy;
        public String sUz;

        public int describeContents() {
            return 0;
        }

        public Commodity(Parcel parcel) {
            this.pfR = parcel.readString();
            this.pfS = parcel.readString();
            this.pfT = parcel.readString();
            this.pfU = parcel.readString();
            this.desc = parcel.readString();
            this.pfW = parcel.readString();
            this.loS = parcel.readDouble();
            this.pfY = parcel.readString();
            this.pfZ = parcel.readString();
            this.pgb = parcel.readInt();
            this.fvD = parcel.readString();
            this.pgd = parcel.readString();
            this.pgf = parcel.readString();
            this.pgg = parcel.readString();
            this.pfI = parcel.readString();
            this.sUv = parcel.readString();
            this.pgk = parcel.readString();
            parcel.readTypedList(this.sUw, DiscountInfo.CREATOR);
            this.sUx = parcel.readString();
            this.sUz = parcel.readString();
            this.sUA = (RecommendTinyAppInfo) parcel.readParcelable(RecommendTinyAppInfo.class.getClassLoader());
            parcel.readTypedList(this.sUB, Promotions.CREATOR);
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.pfR);
            parcel.writeString(this.pfS);
            parcel.writeString(this.pfT);
            parcel.writeString(this.pfU);
            parcel.writeString(this.desc);
            parcel.writeString(this.pfW);
            parcel.writeDouble(this.loS);
            parcel.writeString(this.pfY);
            parcel.writeString(this.pfZ);
            parcel.writeInt(this.pgb);
            parcel.writeString(this.fvD);
            parcel.writeString(this.pgd);
            parcel.writeString(this.pgf);
            parcel.writeString(this.pgg);
            parcel.writeString(this.pfI);
            parcel.writeString(this.sUv);
            parcel.writeString(this.pgk);
            parcel.writeTypedList(this.sUw);
            parcel.writeString(this.sUx);
            parcel.writeString(this.sUz);
            parcel.writeParcelable(this.sUA, 0);
            parcel.writeTypedList(this.sUB);
        }
    }

    public static class RecommendTinyAppInfo implements Parcelable {
        public static final Creator<RecommendTinyAppInfo> CREATOR = new Creator<RecommendTinyAppInfo>() {
            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new RecommendTinyAppInfo(parcel);
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new RecommendTinyAppInfo[i];
            }
        };
        public String sGf;
        public String sGg;
        public String sTI;
        public String sTJ;
        public String sTK;
        public String sTL;
        public int sTM;
        public long sUT;
        public long sUU;
        public long sUV;
        public int sUW;
        public int sUX;
        public long sUY;

        public RecommendTinyAppInfo(Parcel parcel) {
            this.sTI = parcel.readString();
            this.sTJ = parcel.readString();
            this.sTK = parcel.readString();
            this.sGf = parcel.readString();
            this.sGg = parcel.readString();
            this.sTM = parcel.readInt();
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.sTI);
            parcel.writeString(this.sTJ);
            parcel.writeString(this.sTK);
            parcel.writeString(this.sGf);
            parcel.writeString(this.sGg);
            parcel.writeInt(this.sTM);
        }
    }

    public static class a {
        public String text = "";
        public String url = "";
    }

    public static class DiscountInfo implements Parcelable {
        public static final Creator<DiscountInfo> CREATOR = new Creator<DiscountInfo>() {
            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new DiscountInfo(parcel);
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new DiscountInfo[i];
            }
        };
        public String pPL;
        public double sUI;

        public DiscountInfo(Parcel parcel) {
            this.sUI = parcel.readDouble();
            this.pPL = parcel.readString();
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeDouble(this.sUI);
            parcel.writeString(this.pPL);
        }
    }

    public static Orders Z(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        Orders orders = new Orders();
        try {
            orders.sTN = bi.Wy();
            orders.pTQ = jSONObject.getDouble("total_fee") / 100.0d;
            orders.lhE = jSONObject.getString("num");
            orders.sOT = jSONObject.optInt("bank_card_tag", 1);
            orders.pgf = jSONObject.optString("fee_type", "");
            orders.pQx = jSONObject.optDouble("charge_fee", 0.0d) / 100.0d;
            orders.sTO = jSONObject.optDouble("fetch_fee", 0.0d) / 100.0d;
            orders.sTP = jSONObject.optInt("is_assign_userinfo_pay");
            orders.sQD = jSONObject.optString("true_name");
            orders.sTQ = jSONObject.optString("cre_id");
            orders.sTR = jSONObject.optInt("ce_type");
            orders.sTS = jSONObject.optString("assign_pay_info");
            JSONArray jSONArray = jSONObject.getJSONArray("Array");
            orders.sUl = jSONObject.optLong("free_fee");
            orders.sUm = jSONObject.optLong("remain_fee");
            orders.sUn = jSONObject.optInt("not_support_bind_card", 0);
            orders.sUo = jSONObject.optInt("not_support_retry", 0);
            int i = jSONObject.optInt("support_all_bank", 0) == 1 ? 1 : 0;
            if (i != 0) {
                orders.sUc = new HashSet();
            }
            int length = jSONArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                JSONObject jSONObject2 = jSONArray.getJSONObject(i2);
                Commodity commodity = new Commodity();
                commodity.desc = jSONObject2.getString("desc");
                commodity.loS = ((double) jSONObject2.getInt("fee")) / 100.0d;
                commodity.pfW = jSONObject2.optInt("count", 1);
                commodity.pfY = jSONObject2.getString("pay_status");
                commodity.pgd = jSONObject2.optString("buy_bank_name");
                commodity.pfZ = jSONObject2.getString("pay_status_name");
                commodity.pfT = jSONObject2.optString("spid");
                commodity.pfU = jSONObject2.optString("sp_name");
                commodity.pgb = jSONObject2.optInt("modify_timestamp");
                commodity.fvD = jSONObject2.getString("transaction_id");
                commodity.pgf = jSONObject2.optString("fee_type");
                if (bi.oN(orders.pgf)) {
                    orders.pgf = commodity.pgf;
                }
                commodity.pgg = jSONObject2.optString("appusername");
                commodity.pfI = jSONObject2.optString("app_telephone");
                orders.sUf.add(commodity);
                if (i == 0) {
                    orders.sUb = jSONObject2.optString("support_bank");
                    orders.sUc = Nx(orders.sUb);
                }
            }
            if (jSONObject.has("is_open_fee_protocal")) {
                orders.sTX = e.h(jSONObject, "is_open_fee_protocal");
            } else {
                orders.sTX = Bankcard.ec(orders.sOT, 2);
            }
            orders.sUg = aa(jSONObject);
            JSONObject optJSONObject = jSONObject.optJSONObject("bindqueryresp");
            if (optJSONObject == null) {
                x.e("MicroMsg.Orders", "bindqueryresp is null ");
            } else {
                optJSONObject = optJSONObject.optJSONObject("user_info");
                if (optJSONObject == null) {
                    x.e("MicroMsg.Orders", "user_info is null ");
                } else {
                    JSONObject optJSONObject2 = optJSONObject.optJSONObject("touch_info");
                    if (optJSONObject2 == null) {
                        x.e("MicroMsg.Orders", "touch_info is null ");
                    } else {
                        orders.sUd = ((l) g.h(l.class)).aKL() ? optJSONObject2.optInt("use_touch_pay", 0) : 0;
                        orders.sUe = optJSONObject2.optString("touch_forbidword");
                        String optString = optJSONObject2.optString("touch_challenge");
                        boolean z = 1 == optJSONObject2.optInt("need_change_auth_key");
                        s.sVy.mFv = optString;
                        s.sVy.mFw = z;
                        x.i("MicroMsg.Orders", "hy: use_touch_pay is %s, challenge is: %s, is need change: %b", Integer.valueOf(orders.sUd), optString, Boolean.valueOf(z));
                    }
                }
            }
            orders.sUh = jSONObject.optInt("needbindcardtoshowfavinfo");
            orders.sUi = jSONObject.optString("discount_wording");
            orders.sUj = jSONObject.optString("favor_rule_wording");
            a(orders, jSONObject.optJSONObject("entrustpayinfo"));
            return orders;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.Orders", e, "", new Object[0]);
            return orders;
        }
    }

    private static f aa(JSONObject jSONObject) {
        f fVar = new f();
        JSONObject optJSONObject = jSONObject.optJSONObject("favinfo");
        if (optJSONObject == null) {
            x.d("MicroMsg.Orders", "Parse getJsonObject(favinfo) null");
            return fVar;
        }
        int i;
        JSONArray optJSONArray;
        int i2;
        fVar.sJr = ((double) optJSONObject.optLong("tradeAmount")) / 100.0d;
        fVar.sJs = ((double) optJSONObject.optLong("totalFavAmount")) / 100.0d;
        fVar.sJt = ((double) optJSONObject.optLong("afterFavorTradeAmount")) / 100.0d;
        fVar.sJu = optJSONObject.optString("favorComposeId");
        fVar.sJx = optJSONObject.optInt("useNaturalDefense");
        fVar.sJy = optJSONObject.optString("discountWording");
        fVar.sJz = optJSONObject.optString("favorRuleWording");
        fVar.sJA = optJSONObject.optDouble("showFavorAmount", 0.0d) / 100.0d;
        fVar.sJB = optJSONObject.optDouble("invariableFavorAmount", 0.0d) / 100.0d;
        fVar.sJC = optJSONObject.optInt("isVariableFavor");
        fVar.sJD = optJSONObject.optString("invariableFavorDesc");
        fVar.sJE = optJSONObject.optString("variableFavorDesc");
        JSONArray optJSONArray2 = optJSONObject.optJSONArray("tradeFavList");
        for (i = 0; i < optJSONArray2.length(); i++) {
            JSONObject jSONObject2 = optJSONArray2.getJSONObject(i);
            q qVar = new q();
            qVar.sKd = jSONObject2.optInt("favType");
            qVar.sKe = jSONObject2.optInt("favSubType");
            qVar.sKf = jSONObject2.optLong("favProperty");
            qVar.sKg = jSONObject2.optString("favorTypeDesc");
            qVar.sJo = jSONObject2.optString("favId");
            qVar.sKh = jSONObject2.optString("favName");
            qVar.sKi = jSONObject2.optString("favDesc");
            qVar.sJp = jSONObject2.optString("favorUseManual");
            qVar.sJq = jSONObject2.optString("favorRemarks");
            qVar.sKj = ((double) jSONObject2.optLong("favPrice")) / 100.0d;
            qVar.sKk = ((double) jSONObject2.optLong("realFavFee")) / 100.0d;
            qVar.sKl = jSONObject2.optInt("needBankPay");
            qVar.sKm = jSONObject2.optString("bankNo");
            qVar.pgd = jSONObject2.optString("bankName");
            qVar.sKn = jSONObject2.optString("bankLogoUrl");
            optJSONArray = jSONObject2.optJSONArray("bind_serial_list");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                for (i2 = 0; i2 < optJSONArray.length(); i2++) {
                    qVar.sKo.add(b.be(optJSONArray.optString(i2).getBytes()));
                }
            }
            fVar.sJv.add(qVar);
        }
        JSONObject optJSONObject2 = optJSONObject.optJSONObject("favorComposeList");
        if (optJSONObject2 != null) {
            fVar.sJw = new com.tencent.mm.plugin.wallet.a.g();
            optJSONArray2 = optJSONObject2.optJSONArray("favorComposeInfo");
            i = 0;
            while (true) {
                i2 = i;
                if (i2 >= optJSONArray2.length()) {
                    break;
                }
                optJSONObject2 = optJSONArray2.getJSONObject(i2);
                h hVar = new h();
                hVar.sJI = optJSONObject2.optString("faovrComposeId");
                hVar.sJJ = ((double) optJSONObject2.optLong("totalFavorAmount")) / 100.0d;
                hVar.sJt = ((double) optJSONObject2.optLong("afterFavorTradeAmount")) / 100.0d;
                hVar.sJA = optJSONObject2.optDouble("showFavorAmount", 0.0d) / 100.0d;
                hVar.sJB = optJSONObject2.optDouble("invariableFavorAmount", 0.0d) / 100.0d;
                hVar.sJC = optJSONObject2.optInt("isVariableFavor");
                hVar.sJD = optJSONObject2.optString("invariableFavorDesc");
                hVar.sJE = optJSONObject2.optString("variableFavorDesc");
                optJSONArray = optJSONObject2.optJSONArray("composeArray");
                for (i = 0; i < optJSONArray.length(); i++) {
                    JSONObject jSONObject3 = optJSONArray.getJSONObject(i);
                    com.tencent.mm.plugin.wallet.a.e eVar = new com.tencent.mm.plugin.wallet.a.e();
                    eVar.sJo = jSONObject3.optString("favId");
                    eVar.sJp = jSONObject3.optString("favorUseManual");
                    eVar.sJq = jSONObject3.optString("favorRemarks");
                    hVar.sJK.add(eVar);
                }
                fVar.sJw.sJG.add(hVar);
                i = i2 + 1;
            }
        }
        com.tencent.mm.plugin.wallet.a.a aVar = new com.tencent.mm.plugin.wallet.a.a();
        optJSONObject = optJSONObject.optJSONObject("bank_card_info");
        if (optJSONObject != null) {
            JSONArray optJSONArray3 = optJSONObject.optJSONArray("bind_serial_favor_info_list");
            if (optJSONArray3 != null) {
                i = 0;
                while (true) {
                    i2 = i;
                    if (i2 >= optJSONArray3.length()) {
                        break;
                    }
                    com.tencent.mm.plugin.wallet.a.b bVar = new com.tencent.mm.plugin.wallet.a.b();
                    optJSONObject2 = optJSONArray3.getJSONObject(i2);
                    bVar.pfg = optJSONObject2.optString("bind_serial");
                    JSONArray optJSONArray4 = optJSONObject2.optJSONArray("bind_serial_favor_list");
                    if (optJSONArray4 != null && optJSONArray4.length() > 0) {
                        for (i = 0; i < optJSONArray4.length(); i++) {
                            com.tencent.mm.plugin.wallet.a.c cVar = new com.tencent.mm.plugin.wallet.a.c();
                            JSONObject optJSONObject3 = optJSONArray4.optJSONObject(i);
                            cVar.pPL = optJSONObject3.optString("favor_desc");
                            cVar.sJn = optJSONObject3.optInt("is_default_show", 0);
                            bVar.sJm.add(cVar);
                        }
                    }
                    aVar.sJk.add(bVar);
                    i = i2 + 1;
                }
            }
            JSONArray optJSONArray5 = optJSONObject.optJSONObject("new_bind_card_info").optJSONArray("new_bind_card_favor_list");
            if (optJSONArray5 != null && optJSONArray5.length() > 0) {
                aVar.sJl = new k();
                for (i = 0; i < optJSONArray5.length(); i++) {
                    com.tencent.mm.plugin.wallet.a.l lVar = new com.tencent.mm.plugin.wallet.a.l();
                    lVar.pPL = optJSONArray5.optJSONObject(i).optString("favor_desc");
                    aVar.sJl.sJP.add(lVar);
                }
            }
        }
        fVar.sJF = aVar;
        return fVar;
    }

    public static Orders a(JSONObject jSONObject, Orders orders) {
        if (jSONObject == null || orders == null) {
            x.w("MicroMsg.Orders", "oldOrders is null");
        } else {
            try {
                JSONObject optJSONObject = jSONObject.optJSONObject("appservice");
                if (optJSONObject != null) {
                    orders.sTU = optJSONObject.optString("app_recommend_desc");
                    orders.sTV = optJSONObject.optString("app_telephone");
                    orders.sTW = optJSONObject.optInt("recommend_level", 2);
                    orders.lUI = optJSONObject.optString("share_to_friends_url");
                }
                int i = orders.sTW;
                List<Commodity> list = orders.sUf;
                orders.sTY = jSONObject.optString("pay_result_tips");
                JSONArray jSONArray = jSONObject.getJSONArray("payresult");
                int length = jSONArray.length();
                for (int i2 = 0; i2 < length; i2++) {
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i2);
                    Commodity commodity;
                    if (list != null && list.size() == 1) {
                        commodity = (Commodity) list.get(0);
                        commodity.sUB = new ArrayList();
                        commodity.sUw = new ArrayList();
                        commodity.fvD = jSONObject2.getString("transaction_id");
                        a(commodity, jSONObject2, i);
                    } else if (list != null) {
                        String string = jSONObject2.getString("transaction_id");
                        for (Commodity commodity2 : list) {
                            if (string != null && string.equals(commodity2.fvD)) {
                                a(commodity2, jSONObject2, i);
                                break;
                            }
                        }
                    }
                }
                optJSONObject = jSONObject.optJSONObject("extinfo");
                if (optJSONObject != null) {
                    orders.sTZ = optJSONObject.optLong("fetch_pre_arrive_time") * 1000;
                    orders.sUa = optJSONObject.optString("fetch_pre_arrive_time_wording");
                }
                orders.sUp = jSONObject.optInt("is_use_new_paid_succ_page", 0);
                orders.sUq = jSONObject.optString("pay_succ_btn_wording");
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.Orders", e, "", new Object[0]);
            }
        }
        return orders;
    }

    private static void a(Commodity commodity, JSONObject jSONObject, int i) {
        int i2 = 0;
        commodity.pgk = jSONObject.optString("discount");
        commodity.pfY = jSONObject.getString("pay_status");
        commodity.pfZ = jSONObject.getString("pay_status_name");
        commodity.pgd = jSONObject.optString("buy_bank_name");
        commodity.pgb = jSONObject.optInt("pay_timestamp");
        commodity.sUv = jSONObject.optString("card_tail");
        commodity.sTW = i;
        commodity.sUx = jSONObject.optString("rateinfo");
        commodity.sUy = jSONObject.optString("discount_rateinfo");
        commodity.sUz = jSONObject.optString("original_feeinfo");
        if (jSONObject.has("total_fee")) {
            commodity.loS = jSONObject.optDouble("total_fee", 0.0d) / 100.0d;
        }
        commodity.sUt = jSONObject.optDouble("original_total_fee", -1.0d) / 100.0d;
        commodity.pgf = jSONObject.optString("fee_type", "");
        JSONObject optJSONObject = jSONObject.optJSONObject("subscribe_biz_info");
        if (optJSONObject != null) {
            Promotions promotions = new Promotions();
            promotions.type = sUr;
            promotions.name = optJSONObject.optString("nickname");
            promotions.pgg = optJSONObject.optString("username");
            commodity.sUu = promotions.pgg;
            promotions.pkG = optJSONObject.optString("logo_round_url");
            promotions.url = optJSONObject.optString("subscribe_biz_url");
            if (!(bi.oN(promotions.name) || bi.oN(promotions.url))) {
                commodity.sUB.add(promotions);
                commodity.sUC = true;
            }
        }
        JSONArray jSONArray = jSONObject.getJSONArray("activity_info");
        int length = jSONArray.length();
        for (int i3 = 0; i3 < length; i3++) {
            JSONObject jSONObject2 = jSONArray.getJSONObject(i3);
            Promotions promotions2 = new Promotions();
            promotions2.type = sUs;
            promotions2.pkG = jSONObject2.optString("icon");
            promotions2.name = jSONObject2.optString("wording");
            promotions2.url = jSONObject2.optString(SlookSmartClipMetaTag.TAG_TYPE_URL);
            promotions2.sTG = jSONObject2.optString("btn_text");
            promotions2.sUJ = jSONObject2.optInt(Columns.TYPE);
            promotions2.title = jSONObject2.optString("title");
            promotions2.sOB = jSONObject2.optLong("activity_id");
            promotions2.sUK = jSONObject2.optInt("activity_type", 0);
            promotions2.sUM = jSONObject2.optString("small_title");
            promotions2.sUL = jSONObject2.optInt("award_id");
            promotions2.sTD = jSONObject2.optInt("send_record_id");
            promotions2.sTE = jSONObject2.optInt("user_record_id");
            promotions2.sUN = jSONObject2.optString("activity_tinyapp_username");
            promotions2.sUO = jSONObject2.optString("activity_tinyapp_path");
            promotions2.sTF = jSONObject2.optLong("activity_mch_id");
            promotions2.sUP = jSONObject2.optInt("activity_tinyapp_version");
            promotions2.sUQ = jSONObject2.optString("get_award_params");
            promotions2.sUR = jSONObject2.optString("query_award_status_params");
            a(promotions2, jSONObject2.optJSONObject("exposure_info"));
            commodity.sUB.add(promotions2);
        }
        optJSONObject = jSONObject.optJSONObject("link_ativity_info");
        if (optJSONObject != null) {
            commodity.sUD.text = optJSONObject.optString("text");
            commodity.sUD.url = optJSONObject.optString(SlookSmartClipMetaTag.TAG_TYPE_URL);
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("discount_array");
        if (optJSONArray != null) {
            int length2 = optJSONArray.length();
            while (i2 < length2) {
                JSONObject optJSONObject2 = optJSONArray.optJSONObject(i2);
                DiscountInfo discountInfo = new DiscountInfo();
                if (optJSONObject2 != null) {
                    discountInfo.sUI = optJSONObject2.optDouble("payment_amount");
                    discountInfo.pPL = optJSONObject2.optString("favor_desc");
                    commodity.sUw.add(discountInfo);
                }
                i2++;
            }
        }
        JSONObject optJSONObject3 = jSONObject.optJSONObject("tinyapp_info");
        if (optJSONObject3 != null) {
            if (commodity.sUA == null) {
                commodity.sUA = new RecommendTinyAppInfo();
            }
            commodity.sUA.sTI = optJSONObject3.optString("tinyapp_name");
            commodity.sUA.sTJ = optJSONObject3.optString("tinyapp_logo");
            commodity.sUA.sTK = optJSONObject3.optString("tinyapp_desc");
            commodity.sUA.sGf = optJSONObject3.optString("tinyapp_username");
            commodity.sUA.sGg = optJSONObject3.optString("tinyapp_path");
            commodity.sUA.sTL = optJSONObject3.optString("activity_tinyapp_btn_text");
            commodity.sUA.sUT = optJSONObject3.optLong("activity_id");
            commodity.sUA.sUU = optJSONObject3.optLong("activity_type");
            commodity.sUA.sUV = optJSONObject3.optLong("award_id");
            commodity.sUA.sUW = optJSONObject3.optInt("send_record_id");
            commodity.sUA.sUX = optJSONObject3.optInt("user_record_id");
            commodity.sUA.sUY = optJSONObject3.optLong("activity_mch_id");
            commodity.sUA.sTM = optJSONObject3.optInt("tinyapp_version");
        }
    }

    public static void a(Promotions promotions, JSONObject jSONObject) {
        x.i("MicroMsg.Orders", "parseExposureInfo: %s", jSONObject);
        if (jSONObject == null) {
            promotions.sUS = null;
            return;
        }
        try {
            c cVar = new c();
            JSONArray optJSONArray = jSONObject.optJSONArray("single_exposure_info_list");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                cVar.wix = new LinkedList();
                for (int i = 0; i < optJSONArray.length(); i++) {
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                    d.a.a.g gVar = new d.a.a.g();
                    gVar.pkG = jSONObject2.optString("logo");
                    gVar.AEL = jSONObject2.optString("award_name");
                    gVar.AEM = jSONObject2.optString("award_description");
                    gVar.AEN = jSONObject2.optString("background_img");
                    gVar.AEP = jSONObject2.optString("award_description_color");
                    gVar.AEO = jSONObject2.optString("award_name_color");
                    cVar.wix.add(gVar);
                }
            }
            cVar.AEw = jSONObject.optInt("is_query_others", 0);
            cVar.wgE = jSONObject.optString("draw_lottery_params");
            cVar.wiy = jSONObject.optInt("is_show_btn");
            cVar.AEA = jSONObject.optString("background_img_whole");
            JSONObject optJSONObject = jSONObject.optJSONObject("btn_info");
            if (optJSONObject != null) {
                cVar.wiz = new d.a.a.a();
                cVar.wiz.AEo = optJSONObject.optString("btn_words");
                cVar.wiz.AEp = optJSONObject.optString("btn_color");
                cVar.wiz.AEq = optJSONObject.optInt("btn_op_type");
                cVar.wiz.url = optJSONObject.optString(SlookSmartClipMetaTag.TAG_TYPE_URL);
                cVar.wiz.wtj = optJSONObject.optString("get_lottery_params");
                optJSONObject = optJSONObject.optJSONObject("mini_app_info");
                if (optJSONObject != null) {
                    cVar.wiz.AEr = new d.a.a.f();
                    cVar.wiz.AEr.wKS = optJSONObject.optString("activity_tinyapp_username");
                    cVar.wiz.AEr.wKT = optJSONObject.optString("activity_tinyapp_path");
                    cVar.wiz.AEr.wKU = optJSONObject.optInt("activity_tinyapp_version");
                }
            }
            cVar.wiw = jSONObject.optString("exposure_info_modify_params");
            cVar.AEx = jSONObject.optInt("user_opertaion_type");
            cVar.AEy = jSONObject.optInt("is_show_layer");
            optJSONObject = jSONObject.optJSONObject("layer_info");
            if (optJSONObject != null) {
                cVar.AEz = new d.a.a.e();
                cVar.AEz.AEC = optJSONObject.optString("layer_title");
                cVar.AEz.AED = optJSONObject.optString("layer_logo");
                cVar.AEz.AEE = optJSONObject.optString("layer_type");
                cVar.AEz.AEF = optJSONObject.optString("layer_name");
                cVar.AEz.AEG = optJSONObject.optString("layer_description");
                cVar.AEz.AEH = optJSONObject.optInt("is_show_layer_btn");
                if (!bi.oN(optJSONObject.optString("voice_url"))) {
                    cVar.AEz.AEJ = new b(optJSONObject.optString("voice_url").getBytes());
                }
                if (!bi.oN(optJSONObject.optString("voice_data"))) {
                    cVar.AEz.AEK = new b(optJSONObject.optString("voice_data").getBytes());
                }
                optJSONObject = optJSONObject.optJSONObject("layer_btn_info");
                if (optJSONObject != null) {
                    cVar.AEz.AEI = new d();
                    cVar.AEz.AEI.AEo = optJSONObject.optString("btn_words");
                    cVar.AEz.AEI.AEp = optJSONObject.optString("btn_color");
                    cVar.AEz.AEI.AEq = optJSONObject.optInt("btn_op_type");
                    cVar.AEz.AEI.wtj = optJSONObject.optString("get_lottery_params");
                    cVar.AEz.AEI.url = optJSONObject.optString(SlookSmartClipMetaTag.TAG_TYPE_URL);
                    optJSONObject = optJSONObject.optJSONObject("mini_app_info");
                    if (optJSONObject != null) {
                        cVar.AEz.AEI.AEr = new d.a.a.f();
                        cVar.AEz.AEI.AEr.wKS = optJSONObject.optString("activity_tinyapp_username");
                        cVar.AEz.AEI.AEr.wKT = optJSONObject.optString("activity_tinyapp_path");
                        cVar.AEz.AEI.AEr.wKU = optJSONObject.optInt("activity_tinyapp_version");
                    }
                }
            }
            optJSONObject = jSONObject.optJSONObject("draw_lottery_info");
            if (optJSONObject != null) {
                cVar.AEB = new d.a.a.b();
                cVar.AEB.url = optJSONObject.optString(SlookSmartClipMetaTag.TAG_TYPE_URL);
                cVar.AEB.AEs = optJSONObject.optString("animation_wording");
                cVar.AEB.AEt = optJSONObject.optString("animation_wording_color");
                cVar.AEB.AEu = optJSONObject.optString("after_animation_wording");
                cVar.AEB.AEv = optJSONObject.optString("after_animation_wording_color");
                cVar.AEB.wZw = optJSONObject.optInt("op_type");
                optJSONObject = optJSONObject.optJSONObject("mini_app_info");
                if (optJSONObject != null) {
                    cVar.AEB.AEr = new d.a.a.f();
                    cVar.AEB.AEr.wKS = optJSONObject.optString("activity_tinyapp_username");
                    cVar.AEB.AEr.wKT = optJSONObject.optString("activity_tinyapp_path");
                    cVar.AEB.AEr.wKU = optJSONObject.optInt("activity_tinyapp_version");
                }
            }
            promotions.sUS = cVar;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.Orders", e, "parseExposureInfo error: %s", e.getMessage());
        }
    }

    private static void a(Orders orders, JSONObject jSONObject) {
        int i = 0;
        if (jSONObject != null) {
            x.i("MicroMsg.Orders", "parseDeductInfo json is not null");
            orders.sUk = new DeductInfo();
            orders.sUk.title = jSONObject.optString("contract_title");
            orders.sUk.desc = jSONObject.optString("contract_desc");
            orders.sUk.sMk = jSONObject.optInt("auto_deduct_flag", 0);
            orders.sUk.sUE = jSONObject.optString("contract_url");
            orders.sUk.sUG = jSONObject.optInt("is_select_pay_way", 0);
            orders.sUk.sLC = jSONObject.optInt("deduct_show_type", 0);
            orders.sUk.kRl = jSONObject.optString("button_wording", "");
            orders.sUk.sLD = jSONObject.optString("deduct_rule_wording", "");
            orders.sUk.sUH = jSONObject.optString("open_deduct_wording", "");
            JSONArray optJSONArray = jSONObject.optJSONArray("show_info");
            int length = optJSONArray.length();
            if (length > 0) {
                orders.sUk.sUF = new ArrayList();
                while (i < length) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                    if (optJSONObject != null) {
                        DeductShowInfo deductShowInfo = new DeductShowInfo();
                        deductShowInfo.name = optJSONObject.optString("name");
                        deductShowInfo.value = optJSONObject.optString(Columns.VALUE);
                        deductShowInfo.url = optJSONObject.optString(SlookSmartClipMetaTag.TAG_TYPE_URL);
                        orders.sUk.sUF.add(deductShowInfo);
                    } else {
                        x.e("MicroMsg.Orders", "parseDeductInfo's showInfo get a null value from json,index=" + i);
                    }
                    i++;
                }
                return;
            }
            x.e("MicroMsg.Orders", "parseDeductInfo's showInfo len is " + length);
            return;
        }
        x.i("MicroMsg.Orders", "parseDeductInfo json is null");
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("reqKey:").append(this.fvC).append("\n");
        stringBuilder.append("token").append(this.token).append("\n");
        stringBuilder.append("num").append(this.lhE).append("\n");
        stringBuilder.append("totalFee").append(this.pTQ).append("\n");
        return stringBuilder.toString();
    }

    public int describeContents() {
        return 0;
    }

    private static HashSet<String> Nx(String str) {
        HashSet<String> hashSet = new HashSet();
        if (!bi.oN(str)) {
            for (Object add : str.split("\\|")) {
                hashSet.add(add);
            }
            if (hashSet.size() > 0) {
                hashSet.retainAll(hashSet);
            } else {
                hashSet.clear();
            }
        }
        return hashSet;
    }

    public Orders(Parcel parcel) {
        boolean z = true;
        this.sTN = parcel.readLong();
        this.fvC = parcel.readString();
        this.token = parcel.readString();
        this.lhE = parcel.readString();
        this.pTQ = parcel.readDouble();
        this.sOT = parcel.readInt();
        this.pgf = parcel.readString();
        this.pQx = parcel.readDouble();
        this.sTO = parcel.readDouble();
        this.sTP = parcel.readInt();
        this.sQD = parcel.readString();
        this.sTQ = parcel.readString();
        this.sTR = parcel.readInt();
        this.sTS = parcel.readString();
        this.username = parcel.readString();
        this.fqG = parcel.readString();
        this.oVl = parcel.readString();
        this.sTT = parcel.readString();
        this.sTU = parcel.readString();
        this.sTV = parcel.readString();
        this.sTW = parcel.readInt();
        if (parcel.readInt() != 1) {
            z = false;
        }
        this.sTX = z;
        this.sTY = parcel.readString();
        this.lUI = parcel.readString();
        this.sTZ = parcel.readLong();
        this.sUa = parcel.readString();
        parcel.readTypedList(this.sUf, Commodity.CREATOR);
        this.sUb = parcel.readString();
        this.sUc = Nx(this.sUb);
        this.sUd = parcel.readInt();
        this.sUe = parcel.readString();
        this.sUk = (DeductInfo) parcel.readParcelable(DeductInfo.class.getClassLoader());
        this.sUn = parcel.readInt();
        this.sUo = parcel.readInt();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.sTN);
        parcel.writeString(this.fvC);
        parcel.writeString(this.token);
        parcel.writeString(this.lhE);
        parcel.writeDouble(this.pTQ);
        parcel.writeInt(this.sOT);
        parcel.writeString(this.pgf);
        parcel.writeDouble(this.pQx);
        parcel.writeDouble(this.sTO);
        parcel.writeInt(this.sTP);
        parcel.writeString(this.sQD);
        parcel.writeString(this.sTQ);
        parcel.writeInt(this.sTR);
        parcel.writeString(this.sTS);
        parcel.writeString(this.username);
        parcel.writeString(this.fqG);
        parcel.writeString(this.oVl);
        parcel.writeString(this.sTT);
        parcel.writeString(this.sTU);
        parcel.writeString(this.sTV);
        parcel.writeInt(this.sTW);
        parcel.writeInt(this.sTX ? 1 : 0);
        parcel.writeString(this.sTY);
        parcel.writeString(this.lUI);
        parcel.writeLong(this.sTZ);
        parcel.writeString(this.sUa);
        parcel.writeTypedList(this.sUf);
        parcel.writeString(this.sUb);
        parcel.writeInt(this.sUd);
        parcel.writeString(this.sUe);
        parcel.writeParcelable(this.sUk, 1);
        parcel.writeInt(this.sUn);
        parcel.writeInt(this.sUo);
    }
}
