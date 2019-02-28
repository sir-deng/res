package com.tencent.mm.plugin.wallet_payu.bind.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.mm.wallet_core.e.a.a;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class NetScenePayUElementQuery extends a {
    public String thZ;
    public PayUBankcardElement tib;

    public static class PayUBankcardElement implements Parcelable {
        public String cardType = "";
        public String fAK = "";
        public String pgd = "";
        public String tic = "";
        public String tie = "";

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.tic);
            parcel.writeString(this.pgd);
            parcel.writeString(this.tie);
            parcel.writeString(this.cardType);
            parcel.writeString(this.fAK);
        }
    }

    public NetScenePayUElementQuery(String str) {
        this.thZ = str;
        Map hashMap = new HashMap();
        hashMap.put("card_number", str);
        D(hashMap);
    }

    public final int bLx() {
        return 22;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        this.tib = new PayUBankcardElement();
        this.tib.tic = jSONObject.optString("bin");
        this.tib.pgd = jSONObject.optString("bank_name");
        this.tib.tie = jSONObject.optString("issuer_type");
        this.tib.cardType = jSONObject.optString("card_type");
        this.tib.fAK = jSONObject.optString("payu_reference");
    }
}
