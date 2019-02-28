package com.tencent.mm.plugin.remittance.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.protocal.c.iu;
import com.tencent.mm.protocal.c.we;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONObject;

public class BusiRemittanceResp implements Parcelable {
    public static final Creator<BusiRemittanceResp> CREATOR = new Creator<BusiRemittanceResp>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new BusiRemittanceResp(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new BusiRemittanceResp[i];
        }
    };
    public int pPJ = 0;
    public String pPK = "";
    public String pPL = "";
    public int pPM;
    public String pPN;
    public String pPO;
    public List<we> pPP = new LinkedList();
    public iu pPQ;
    public int pPR = 0;
    public int pPS = 0;
    public int pPT = 400;

    BusiRemittanceResp() {
    }

    BusiRemittanceResp(JSONObject jSONObject) {
        this.pPJ = jSONObject.optInt("show_photo", 0);
        this.pPK = jSONObject.optString("photo_url", "");
        this.pPL = jSONObject.optString("favor_desc", "");
        this.pPM = jSONObject.optInt("scan_scene", 0);
        this.pPN = jSONObject.optString("favor_req_sign", "");
        this.pPO = jSONObject.optString("favor_req_extend", "");
        this.pPR = jSONObject.optInt("get_favor_flag", 0);
        this.pPS = jSONObject.optInt("photo_style", 0);
        this.pPT = jSONObject.optInt("get_favor_interval", 400);
        this.pPP = b.r(jSONObject.optJSONArray("favor_list"));
        JSONObject optJSONObject = jSONObject.optJSONObject("favor_comm_resp");
        if (optJSONObject != null) {
            this.pPQ = new iu();
            this.pPQ.vVG = optJSONObject.optString("default_fav_compose_id");
            this.pPQ.vVE = b.r(optJSONObject.optJSONArray("favor_info_list"));
            this.pPQ.vVH = optJSONObject.optString("favor_resp_sign");
            this.pPQ.vVI = optJSONObject.optString("no_compose_wording");
            this.pPQ.vVF = b.q(optJSONObject.optJSONArray("favor_compose_result_list"));
        }
    }

    protected BusiRemittanceResp(Parcel parcel) {
        int readInt;
        byte[] bArr;
        this.pPJ = parcel.readInt();
        this.pPK = parcel.readString();
        this.pPL = parcel.readString();
        this.pPM = parcel.readInt();
        this.pPN = parcel.readString();
        this.pPO = parcel.readString();
        this.pPR = parcel.readInt();
        this.pPS = parcel.readInt();
        this.pPT = parcel.readInt();
        this.pPP = new LinkedList();
        int readInt2 = parcel.readInt();
        for (int i = 0; i < readInt2; i++) {
            readInt = parcel.readInt();
            if (readInt > 0) {
                bArr = new byte[readInt];
                parcel.readByteArray(bArr);
                try {
                    we weVar = new we();
                    weVar.aH(bArr);
                    this.pPP.add(weVar);
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.BusiRemittanceResp", e, "", new Object[0]);
                }
            }
        }
        readInt = parcel.readInt();
        if (readInt > 0) {
            bArr = new byte[readInt];
            parcel.readByteArray(bArr);
            this.pPQ = new iu();
            try {
                this.pPQ.aH(bArr);
            } catch (Throwable e2) {
                x.printErrStackTrace("MicroMsg.BusiRemittanceResp", e2, "", new Object[0]);
            }
        }
    }

    public void writeToParcel(Parcel parcel, int i) {
        byte[] toByteArray;
        parcel.writeInt(this.pPJ);
        parcel.writeString(this.pPK);
        parcel.writeString(this.pPL);
        parcel.writeInt(this.pPM);
        parcel.writeString(this.pPN);
        parcel.writeString(this.pPO);
        parcel.writeInt(this.pPR);
        parcel.writeInt(this.pPS);
        parcel.writeInt(this.pPT);
        parcel.writeInt(this.pPP.size());
        if (this.pPP.size() > 0) {
            for (int i2 = 0; i2 < this.pPP.size(); i2++) {
                byte[] bArr = new byte[0];
                try {
                    toByteArray = ((we) this.pPP.get(i2)).toByteArray();
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.BusiRemittanceResp", e, "", new Object[0]);
                    toByteArray = bArr;
                }
                parcel.writeInt(toByteArray.length);
                if (toByteArray.length > 0) {
                    parcel.writeByteArray(toByteArray);
                }
            }
        }
        toByteArray = new byte[0];
        try {
            toByteArray = this.pPQ.toByteArray();
        } catch (Throwable e2) {
            x.printErrStackTrace("MicroMsg.BusiRemittanceResp", e2, "", new Object[0]);
        }
        parcel.writeInt(toByteArray.length);
        if (toByteArray.length > 0) {
            parcel.writeByteArray(toByteArray);
        }
    }

    public int describeContents() {
        return 0;
    }
}
