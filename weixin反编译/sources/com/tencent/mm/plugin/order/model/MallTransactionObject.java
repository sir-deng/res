package com.tencent.mm.plugin.order.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.plugin.order.model.MallOrderDetailObject.HelpCenter;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class MallTransactionObject implements Parcelable {
    public static final Creator<MallTransactionObject> CREATOR = new Creator<MallTransactionObject>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new MallTransactionObject(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new MallTransactionObject[i];
        }
    };
    public String desc;
    public int fjM;
    public int fqh;
    public String fvD;
    public int hBH;
    public String iRs;
    public double loS = 0.0d;
    public List<HelpCenter> pfF = new LinkedList();
    public int pfG = -1;
    public String pfI;
    public int pfQ;
    public String pfR;
    public String pfS;
    public String pfT;
    public String pfU;
    public String pfV;
    public String pfW;
    public String pfX;
    public String pfY;
    public String pfZ;
    public String pgA;
    public String pgB;
    public String pgC;
    public String pgD;
    public String pgE;
    public String pgF;
    public double pgG;
    public String pgH;
    public String pga;
    public int pgb;
    public String pgc;
    public String pgd;
    public String pge;
    public String pgf;
    public String pgg;
    public String pgh;
    public String pgi;
    public String pgj;
    public String pgk;
    public double pgl;
    public String pgm;
    public String pgn;
    public String pgo;
    public String pgp;
    public String pgq;
    public int pgr;
    public int pgs;
    public double pgt;
    public String pgu;
    public int pgv;
    public String pgw;
    public int pgx;
    public int pgy;
    public int pgz;
    public int type;

    public int describeContents() {
        return 0;
    }

    public MallTransactionObject(Parcel parcel) {
        this.fqh = parcel.readInt();
        this.pfQ = parcel.readInt();
        this.fjM = parcel.readInt();
        this.pfR = parcel.readString();
        this.pfS = parcel.readString();
        this.pfT = parcel.readString();
        this.pfU = parcel.readString();
        this.desc = parcel.readString();
        this.pfV = parcel.readString();
        this.pfW = parcel.readString();
        this.loS = parcel.readDouble();
        this.pfX = parcel.readString();
        this.pfY = parcel.readString();
        this.pfZ = parcel.readString();
        this.pga = parcel.readString();
        this.hBH = parcel.readInt();
        this.pgb = parcel.readInt();
        this.fvD = parcel.readString();
        this.pgc = parcel.readString();
        this.pgd = parcel.readString();
        this.pgf = parcel.readString();
        this.pgg = parcel.readString();
        this.pfI = parcel.readString();
        this.pgh = parcel.readString();
        this.iRs = parcel.readString();
        this.pgi = parcel.readString();
        this.pgj = parcel.readString();
        this.pgk = parcel.readString();
        this.pgl = parcel.readDouble();
        this.pgm = parcel.readString();
        this.pgn = parcel.readString();
        this.pgo = parcel.readString();
        this.pgp = parcel.readString();
        this.pgr = parcel.readInt();
        this.pgx = parcel.readInt();
        this.pgt = parcel.readDouble();
        this.pgu = parcel.readString();
        this.pgv = parcel.readInt();
        this.pgw = parcel.readString();
        this.pgx = parcel.readInt();
        this.pgy = parcel.readInt();
        this.pgz = parcel.readInt();
        this.pgA = parcel.readString();
        this.pgB = parcel.readString();
        this.pgC = parcel.readString();
        this.pgD = parcel.readString();
        this.pgE = parcel.readString();
        this.pgF = parcel.readString();
        this.pgG = parcel.readDouble();
        this.pgH = parcel.readString();
        this.pgq = parcel.readString();
        this.pfG = parcel.readInt();
        int readInt = parcel.readInt();
        this.pfF = new LinkedList();
        for (int i = 0; i < readInt; i++) {
            this.pfF.add((HelpCenter) parcel.readParcelable(HelpCenter.class.getClassLoader()));
        }
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.fqh);
        parcel.writeInt(this.pfQ);
        parcel.writeInt(this.fjM);
        parcel.writeString(this.pfR);
        parcel.writeString(this.pfS);
        parcel.writeString(this.pfT);
        parcel.writeString(this.pfU);
        parcel.writeString(this.desc);
        parcel.writeString(this.pfV);
        parcel.writeString(this.pfW);
        parcel.writeDouble(this.loS);
        parcel.writeString(this.pfX);
        parcel.writeString(this.pfY);
        parcel.writeString(this.pfZ);
        parcel.writeString(this.pga);
        parcel.writeInt(this.hBH);
        parcel.writeInt(this.pgb);
        parcel.writeString(this.fvD);
        parcel.writeString(this.pgc);
        parcel.writeString(this.pgd);
        parcel.writeString(this.pgf);
        parcel.writeString(this.pgg);
        parcel.writeString(this.pfI);
        parcel.writeString(this.pgh);
        parcel.writeString(this.iRs);
        parcel.writeString(this.pgi);
        parcel.writeString(this.pgj);
        parcel.writeString(this.pgk);
        parcel.writeDouble(this.pgl);
        parcel.writeString(this.pgm);
        parcel.writeString(this.pgn);
        parcel.writeString(this.pgo);
        parcel.writeString(this.pgp);
        parcel.writeInt(this.pgr);
        parcel.writeInt(this.pgx);
        parcel.writeDouble(this.pgt);
        parcel.writeString(this.pgu);
        parcel.writeInt(this.pgv);
        parcel.writeString(this.pgw);
        parcel.writeInt(this.pgx);
        parcel.writeInt(this.pgy);
        parcel.writeInt(this.pgz);
        parcel.writeString(this.pgA);
        parcel.writeString(this.pgB);
        parcel.writeString(this.pgC);
        parcel.writeString(this.pgD);
        parcel.writeString(this.pgE);
        parcel.writeString(this.pgF);
        parcel.writeDouble(this.pgG);
        parcel.writeString(this.pgH);
        parcel.writeString(this.pgq);
        parcel.writeInt(this.pfG);
        parcel.writeInt(this.pfF.size());
        for (HelpCenter writeParcelable : this.pfF) {
            parcel.writeParcelable(writeParcelable, i);
        }
    }

    public static MallTransactionObject Q(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        MallTransactionObject mallTransactionObject = new MallTransactionObject();
        mallTransactionObject.type = jSONObject.optInt("rec_type", 1);
        mallTransactionObject.fqh = jSONObject.optInt("sub_pay_type", 0);
        mallTransactionObject.pfQ = jSONObject.optInt("pay_scene");
        mallTransactionObject.fjM = jSONObject.optInt("user_type");
        mallTransactionObject.pfR = jSONObject.optString("buy_uin");
        mallTransactionObject.pfS = jSONObject.optString("buy_name");
        mallTransactionObject.pfT = jSONObject.optString("sale_uin");
        mallTransactionObject.pfU = jSONObject.optString("sale_name");
        mallTransactionObject.fvD = jSONObject.optString("trans_id");
        mallTransactionObject.pgc = jSONObject.optString("sp_billno");
        mallTransactionObject.desc = jSONObject.optString("goods_name");
        mallTransactionObject.pfV = jSONObject.optString("goods_detail");
        mallTransactionObject.loS = jSONObject.optDouble("fee") / 100.0d;
        mallTransactionObject.pfX = jSONObject.optString("fee_color");
        mallTransactionObject.pfY = jSONObject.optString("trade_state");
        mallTransactionObject.pfZ = jSONObject.optString("trade_state_name");
        mallTransactionObject.pga = jSONObject.optString("trade_state_color");
        mallTransactionObject.pgd = jSONObject.optString("buy_bank_name");
        mallTransactionObject.pge = jSONObject.optString("card_tail");
        mallTransactionObject.hBH = jSONObject.optInt("create_timestamp");
        mallTransactionObject.pgb = jSONObject.optInt("modify_timestamp");
        mallTransactionObject.pgf = jSONObject.optString("fee_type");
        JSONObject optJSONObject = jSONObject.optJSONObject("appinfo");
        if (optJSONObject != null) {
            mallTransactionObject.pgg = optJSONObject.optString("app_username");
            mallTransactionObject.pfI = optJSONObject.optString("app_telephone");
            mallTransactionObject.pgh = optJSONObject.optString("app_nickname");
            mallTransactionObject.iRs = optJSONObject.optString("app_icon_url");
            mallTransactionObject.pgp = optJSONObject.optString("safeguard_url");
            mallTransactionObject.pgq = optJSONObject.optString(SlookAirButtonFrequentContactAdapter.DISPLAY_NAME);
        }
        mallTransactionObject.pgi = jSONObject.optString("deliver_price");
        mallTransactionObject.pgj = jSONObject.optString("preferential_price");
        mallTransactionObject.pgk = jSONObject.optString("discount");
        mallTransactionObject.pgl = jSONObject.optDouble("original_total_fee") / 100.0d;
        mallTransactionObject.pgm = jSONObject.optString("total_price");
        mallTransactionObject.pgn = jSONObject.optString("receipt_company");
        mallTransactionObject.pgo = jSONObject.optString("biz_pledge");
        mallTransactionObject.pgr = jSONObject.optInt("pre_fetch_timestamp");
        mallTransactionObject.pgs = jSONObject.optInt("arrived_timestamp");
        mallTransactionObject.pgt = jSONObject.optDouble("transfer_fee") / 100.0d;
        mallTransactionObject.pgu = jSONObject.optString("receiver_name");
        mallTransactionObject.pgv = jSONObject.optInt("allow_resend_msg");
        mallTransactionObject.pgw = jSONObject.optString("charge_fee");
        mallTransactionObject.pgx = jSONObject.optInt("receive_timestamp");
        mallTransactionObject.pgy = jSONObject.optInt("refund_timestamp");
        mallTransactionObject.pgz = jSONObject.optInt("create_timestamp");
        mallTransactionObject.pgA = jSONObject.optString("buy_bank_type");
        mallTransactionObject.pgB = jSONObject.optString("payer_name");
        mallTransactionObject.pgC = jSONObject.optString("true_name");
        mallTransactionObject.pgD = jSONObject.optString("refund_bank_type");
        mallTransactionObject.pgE = jSONObject.optString("rateinfo");
        mallTransactionObject.pgF = jSONObject.optString("original_feeinfo");
        mallTransactionObject.pgG = jSONObject.optDouble("fetch_total_fee") / 100.0d;
        mallTransactionObject.pgH = jSONObject.optString("fetch_total_fee_color");
        mallTransactionObject.pfG = jSONObject.optInt("userroll_type");
        mallTransactionObject.pfF = R(jSONObject);
        return mallTransactionObject;
    }

    private static List<HelpCenter> R(JSONObject jSONObject) {
        List<HelpCenter> linkedList = new LinkedList();
        try {
            JSONArray jSONArray = jSONObject.getJSONArray("help_center");
            for (int i = 0; i < jSONArray.length(); i++) {
                HelpCenter helpCenter = new HelpCenter();
                JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                helpCenter.fpU = jSONObject2.optBoolean("is_show_button");
                helpCenter.name = jSONObject2.optString("name");
                helpCenter.url = jSONObject2.optString(SlookSmartClipMetaTag.TAG_TYPE_URL);
                linkedList.add(helpCenter);
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.MallTransactionObject", e, "", new Object[0]);
            x.e("MicroMsg.MallTransactionObject", "parseHelpCenter error %s", e.getMessage());
        }
        return linkedList;
    }
}
