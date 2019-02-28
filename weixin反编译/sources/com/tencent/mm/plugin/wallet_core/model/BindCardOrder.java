package com.tencent.mm.plugin.wallet_core.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.wallet_core.model.n.a;
import com.tencent.mm.plugin.wallet_core.model.n.b;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONObject;

public class BindCardOrder implements Parcelable {
    public static final Creator<BindCardOrder> CREATOR = new Creator<BindCardOrder>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new BindCardOrder(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new BindCardOrder[i];
        }
    };
    public static int sRQ = 1;
    public static int sRR = 2;
    public static int sRS = 6;
    public int jumpType;
    public String pff;
    private String sRP = "";
    public int sRT;
    public String sRU = "";
    public String sRV = "";
    public String sRW = "";
    public String sRX = "";
    public String sRY = "";
    public int sRZ;
    public int sSa;
    public n sSb;
    public a sSc;
    public b sSd;

    protected BindCardOrder(Parcel parcel) {
        this.sRP = parcel.readString();
        try {
            X(new JSONObject(this.sRP));
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.BindCardOrder", e, "", new Object[0]);
        }
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.sRP);
    }

    public int describeContents() {
        return 0;
    }

    public final boolean bLH() {
        return this.jumpType == sRQ && this.sSc != null;
    }

    public final boolean bLI() {
        return this.jumpType == sRS && this.sSc != null;
    }

    public final void X(JSONObject jSONObject) {
        this.sRP = jSONObject == null ? "" : jSONObject.toString();
        x.i("MicroMsg.BindCardOrder", "feed json %s", this.sRP);
        try {
            this.sRT = jSONObject.optInt("show_bind_succ_page", 0);
            this.sRU = jSONObject.optString("bind_succ_btn_wording", "");
            this.sRV = jSONObject.optString("bind_succ_remind_wording", "");
            this.jumpType = jSONObject.optInt("jump_type", 0);
            this.sRY = jSONObject.optString("bind_serial");
            JSONObject optJSONObject = jSONObject.optJSONObject("activity_info");
            this.sSb = new n();
            if (optJSONObject != null) {
                n nVar = this.sSb;
                nVar.sOB = optJSONObject.optLong("activity_id");
                nVar.sTB = optJSONObject.optLong("activity_type", 0);
                nVar.sTC = optJSONObject.optLong("award_id");
                nVar.sTD = optJSONObject.optInt("send_record_id");
                nVar.sTE = optJSONObject.optInt("user_record_id");
                nVar.sTF = optJSONObject.optLong("activity_mch_id", 0);
            }
            optJSONObject = jSONObject.optJSONObject("h5_info");
            if (optJSONObject != null) {
                this.sSc = new a();
                this.sSc.Y(optJSONObject);
            }
            optJSONObject = jSONObject.optJSONObject("native_info");
            if (optJSONObject != null) {
                this.sSc = new a();
                this.sSc.Y(optJSONObject);
            }
            optJSONObject = jSONObject.optJSONObject("tinyapp_info");
            if (optJSONObject != null) {
                this.sSd = new b();
                b bVar = this.sSd;
                bVar.sTI = optJSONObject.optString("tinyapp_name");
                bVar.sTJ = optJSONObject.optString("tinyapp_logo");
                bVar.sTK = optJSONObject.optString("tinyapp_desc");
                bVar.sGf = optJSONObject.optString("tinyapp_username");
                bVar.sGg = optJSONObject.optString("tinyapp_path");
                bVar.sTL = optJSONObject.optString("activity_tinyapp_btn_text");
                bVar.sTM = optJSONObject.optInt("tinyapp_version", 0);
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.BindCardOrder", e, "", new Object[0]);
        }
    }
}
