package com.tencent.mm.wallet_core.tenpay.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import org.json.JSONObject;

public interface ITenpaySave {

    public static class RetryPayInfo implements Parcelable {
        public static final Creator<RetryPayInfo> CREATOR = new Creator<RetryPayInfo>() {
            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new RetryPayInfo(parcel);
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new RetryPayInfo[i];
            }
        };
        public int zRn;
        public int zRo;
        public String zRp;

        public RetryPayInfo() {
            this.zRn = -1;
            this.zRo = -1;
            this.zRp = "";
        }

        protected RetryPayInfo(Parcel parcel) {
            this.zRn = parcel.readInt();
            this.zRo = parcel.readInt();
            this.zRp = parcel.readString();
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.zRn);
            parcel.writeInt(this.zRo);
            parcel.writeString(this.zRp);
        }

        public int describeContents() {
            return 0;
        }

        public final boolean cCF() {
            if (this.zRn == -1 || this.zRo == -1) {
                return false;
            }
            return true;
        }

        public final void Y(JSONObject jSONObject) {
            if (jSONObject != null) {
                JSONObject optJSONObject = jSONObject.optJSONObject("retry_pay_info");
                if (optJSONObject != null) {
                    this.zRn = optJSONObject.optInt("retry_interval", -1);
                    this.zRo = optJSONObject.optInt("max_retry_count", -1);
                    this.zRp = optJSONObject.optString("retry_fail_wording", "");
                }
            }
        }
    }

    RetryPayInfo bJV();
}
