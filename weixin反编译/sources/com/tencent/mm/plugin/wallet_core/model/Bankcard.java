package com.tencent.mm.plugin.wallet_core.model;

import android.content.Context;
import android.database.Cursor;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.f.b.ea;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.wcdb.FileUtils;
import java.lang.reflect.Field;

public class Bankcard extends ea implements Parcelable {
    public static final Creator<Bankcard> CREATOR = new Creator<Bankcard>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new Bankcard(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new Bankcard[i];
        }
    };
    public static a gKN;
    public static int sRb = 1;
    public static int sRc = 2;
    public static int sRd = 4;
    public static int sRe = 8;
    public static int sRf = 16;
    public static int sRg = 32;
    public static int sRh = 64;
    public static int sRi = FileUtils.S_IWUSR;
    public int sQF;
    public String sQH;
    public String sRA;
    public int sRB;
    public String sRj;
    public String sRk;
    public String sRl;
    public String sRm;
    public String sRn;
    public double sRo;
    public String sRp;
    public double sRq;
    public String sRr;
    public String sRs;
    public String sRt;
    public String sRu;
    public boolean sRv;
    public e sRw;
    public long sRx;
    public long sRy;
    public long sRz;

    static {
        a aVar = new a();
        aVar.hUM = new Field[39];
        aVar.columns = new String[40];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "bindSerial";
        aVar.xrT.put("bindSerial", "TEXT PRIMARY KEY ");
        stringBuilder.append(" bindSerial TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.xrS = "bindSerial";
        aVar.columns[1] = "cardType";
        aVar.xrT.put("cardType", "INTEGER");
        stringBuilder.append(" cardType INTEGER");
        stringBuilder.append(", ");
        aVar.columns[2] = "bankcardState";
        aVar.xrT.put("bankcardState", "INTEGER");
        stringBuilder.append(" bankcardState INTEGER");
        stringBuilder.append(", ");
        aVar.columns[3] = "forbidWord";
        aVar.xrT.put("forbidWord", "TEXT");
        stringBuilder.append(" forbidWord TEXT");
        stringBuilder.append(", ");
        aVar.columns[4] = "bankName";
        aVar.xrT.put("bankName", "TEXT");
        stringBuilder.append(" bankName TEXT");
        stringBuilder.append(", ");
        aVar.columns[5] = "bankcardType";
        aVar.xrT.put("bankcardType", "TEXT");
        stringBuilder.append(" bankcardType TEXT");
        stringBuilder.append(", ");
        aVar.columns[6] = "bankcardTypeName";
        aVar.xrT.put("bankcardTypeName", "TEXT");
        stringBuilder.append(" bankcardTypeName TEXT");
        stringBuilder.append(", ");
        aVar.columns[7] = "bankcardTag";
        aVar.xrT.put("bankcardTag", "INTEGER");
        stringBuilder.append(" bankcardTag INTEGER");
        stringBuilder.append(", ");
        aVar.columns[8] = "bankcardTail";
        aVar.xrT.put("bankcardTail", "TEXT");
        stringBuilder.append(" bankcardTail TEXT");
        stringBuilder.append(", ");
        aVar.columns[9] = "supportTag";
        aVar.xrT.put("supportTag", "INTEGER");
        stringBuilder.append(" supportTag INTEGER");
        stringBuilder.append(", ");
        aVar.columns[10] = "mobile";
        aVar.xrT.put("mobile", "TEXT");
        stringBuilder.append(" mobile TEXT");
        stringBuilder.append(", ");
        aVar.columns[11] = "trueName";
        aVar.xrT.put("trueName", "TEXT");
        stringBuilder.append(" trueName TEXT");
        stringBuilder.append(", ");
        aVar.columns[12] = "desc";
        aVar.xrT.put("desc", "TEXT");
        stringBuilder.append(" desc TEXT");
        stringBuilder.append(", ");
        aVar.columns[13] = "bankPhone";
        aVar.xrT.put("bankPhone", "TEXT");
        stringBuilder.append(" bankPhone TEXT");
        stringBuilder.append(", ");
        aVar.columns[14] = "bizUsername";
        aVar.xrT.put("bizUsername", "TEXT");
        stringBuilder.append(" bizUsername TEXT");
        stringBuilder.append(", ");
        aVar.columns[15] = "onceQuotaKind";
        aVar.xrT.put("onceQuotaKind", "DOUBLE");
        stringBuilder.append(" onceQuotaKind DOUBLE");
        stringBuilder.append(", ");
        aVar.columns[16] = "onceQuotaVirtual";
        aVar.xrT.put("onceQuotaVirtual", "DOUBLE");
        stringBuilder.append(" onceQuotaVirtual DOUBLE");
        stringBuilder.append(", ");
        aVar.columns[17] = "dayQuotaKind";
        aVar.xrT.put("dayQuotaKind", "DOUBLE");
        stringBuilder.append(" dayQuotaKind DOUBLE");
        stringBuilder.append(", ");
        aVar.columns[18] = "dayQuotaVirtual";
        aVar.xrT.put("dayQuotaVirtual", "DOUBLE");
        stringBuilder.append(" dayQuotaVirtual DOUBLE");
        stringBuilder.append(", ");
        aVar.columns[19] = "fetchArriveTime";
        aVar.xrT.put("fetchArriveTime", "LONG");
        stringBuilder.append(" fetchArriveTime LONG");
        stringBuilder.append(", ");
        aVar.columns[20] = "fetchArriveTimeWording";
        aVar.xrT.put("fetchArriveTimeWording", "TEXT");
        stringBuilder.append(" fetchArriveTimeWording TEXT");
        stringBuilder.append(", ");
        aVar.columns[21] = "repay_url";
        aVar.xrT.put("repay_url", "TEXT");
        stringBuilder.append(" repay_url TEXT");
        stringBuilder.append(", ");
        aVar.columns[22] = "wxcreditState";
        aVar.xrT.put("wxcreditState", "INTEGER");
        stringBuilder.append(" wxcreditState INTEGER");
        stringBuilder.append(", ");
        aVar.columns[23] = "bankcardClientType";
        aVar.xrT.put("bankcardClientType", "INTEGER");
        stringBuilder.append(" bankcardClientType INTEGER");
        stringBuilder.append(", ");
        aVar.columns[24] = "ext_msg";
        aVar.xrT.put("ext_msg", "TEXT");
        stringBuilder.append(" ext_msg TEXT");
        stringBuilder.append(", ");
        aVar.columns[25] = "support_micropay";
        aVar.xrT.put("support_micropay", "INTEGER");
        stringBuilder.append(" support_micropay INTEGER");
        stringBuilder.append(", ");
        aVar.columns[26] = "arrive_type";
        aVar.xrT.put("arrive_type", "TEXT");
        stringBuilder.append(" arrive_type TEXT");
        stringBuilder.append(", ");
        aVar.columns[27] = "avail_save_wording";
        aVar.xrT.put("avail_save_wording", "TEXT");
        stringBuilder.append(" avail_save_wording TEXT");
        stringBuilder.append(", ");
        aVar.columns[28] = "fetch_charge_rate";
        aVar.xrT.put("fetch_charge_rate", "DOUBLE");
        stringBuilder.append(" fetch_charge_rate DOUBLE");
        stringBuilder.append(", ");
        aVar.columns[29] = "full_fetch_charge_fee";
        aVar.xrT.put("full_fetch_charge_fee", "DOUBLE");
        stringBuilder.append(" full_fetch_charge_fee DOUBLE");
        stringBuilder.append(", ");
        aVar.columns[30] = "fetch_charge_info";
        aVar.xrT.put("fetch_charge_info", "TEXT");
        stringBuilder.append(" fetch_charge_info TEXT");
        stringBuilder.append(", ");
        aVar.columns[31] = "tips";
        aVar.xrT.put("tips", "TEXT");
        stringBuilder.append(" tips TEXT");
        stringBuilder.append(", ");
        aVar.columns[32] = "forbid_title";
        aVar.xrT.put("forbid_title", "TEXT");
        stringBuilder.append(" forbid_title TEXT");
        stringBuilder.append(", ");
        aVar.columns[33] = "forbid_url";
        aVar.xrT.put("forbid_url", "TEXT");
        stringBuilder.append(" forbid_url TEXT");
        stringBuilder.append(", ");
        aVar.columns[34] = "no_micro_word";
        aVar.xrT.put("no_micro_word", "TEXT");
        stringBuilder.append(" no_micro_word TEXT");
        stringBuilder.append(", ");
        aVar.columns[35] = "card_bottom_wording";
        aVar.xrT.put("card_bottom_wording", "TEXT");
        stringBuilder.append(" card_bottom_wording TEXT");
        stringBuilder.append(", ");
        aVar.columns[36] = "support_lqt_turn_in";
        aVar.xrT.put("support_lqt_turn_in", "INTEGER");
        stringBuilder.append(" support_lqt_turn_in INTEGER");
        stringBuilder.append(", ");
        aVar.columns[37] = "support_lqt_turn_out";
        aVar.xrT.put("support_lqt_turn_out", "INTEGER");
        stringBuilder.append(" support_lqt_turn_out INTEGER");
        stringBuilder.append(", ");
        aVar.columns[38] = "is_hightlight_pre_arrive_time_wording";
        aVar.xrT.put("is_hightlight_pre_arrive_time_wording", "INTEGER");
        stringBuilder.append(" is_hightlight_pre_arrive_time_wording INTEGER");
        aVar.columns[39] = "rowid";
        aVar.xrU = stringBuilder.toString();
        gKN = aVar;
    }

    public Bankcard() {
        this.sRn = null;
        this.sRu = null;
        this.sRv = false;
    }

    public Bankcard(byte b) {
        this.sRn = null;
        this.sRu = null;
        this.sRv = false;
        this.field_bankcardTag = 1;
    }

    public static boolean ec(int i, int i2) {
        x.d("MicroMsg.Bankcard", "supportBankcardTag : " + i + ", bankcardTag : " + i2);
        return (i & i2) > 0;
    }

    public static boolean zy(int i) {
        return (i & 2) > 0;
    }

    public final int a(int i, Orders orders) {
        if (this.field_bankcardState != 0) {
            x.d("MicroMsg.Bankcard", " bankcardState : " + this.field_bankcardState);
            return this.field_bankcardState;
        } else if (orders != null && orders.fvC.equals(this.sRn)) {
            return 4;
        } else {
            int i2;
            if ((this.field_bankcardTag & i) > 0) {
                i2 = 1;
            } else {
                i2 = 0;
            }
            if (i2 == 0) {
                if (bLE()) {
                    return 5;
                }
                return 6;
            } else if (orders == null || orders.sUc.isEmpty() || orders.sUc.contains(this.field_bankcardType)) {
                return 0;
            } else {
                return 7;
            }
        }
    }

    public static String N(Context context, int i) {
        switch (i) {
            case 1:
                return context.getString(i.vaZ);
            case 2:
                return context.getString(i.vbf);
            case 3:
                return context.getString(i.vbk);
            case 4:
                return context.getString(i.vbb);
            case 5:
                return context.getString(i.vaX);
            case 6:
                return context.getString(i.vbd);
            case 7:
                return context.getString(i.vbi);
            default:
                return context.getString(i.vbg);
        }
    }

    public final boolean bLA() {
        boolean z = (this.field_cardType & sRd) > 0;
        x.d("MicroMsg.Bankcard", "isWXCredit, ret = " + z);
        return z;
    }

    public final boolean bLB() {
        boolean z = (this.field_cardType & sRe) > 0;
        x.d("MicroMsg.Bankcard", "isWXCredit, ret = " + z);
        return z;
    }

    public final boolean bLC() {
        boolean z = (this.field_cardType & sRh) > 0;
        x.d("MicroMsg.Bankcard", "isLqtCard, ret = " + z);
        return z;
    }

    public final boolean bLD() {
        boolean z = (this.field_cardType & sRc) > 0;
        x.d("MicroMsg.Bankcard", "isCredit, ret = " + z);
        return z;
    }

    public final boolean bLE() {
        boolean z = (this.field_cardType & sRb) <= 0;
        x.d("MicroMsg.Bankcard", "isDomestic, ret = " + z);
        return z;
    }

    public final boolean bLF() {
        return (this.field_cardType & sRi) > 0;
    }

    protected final a Aj() {
        return gKN;
    }

    public int describeContents() {
        return 0;
    }

    public Bankcard(Parcel parcel) {
        boolean z = true;
        this.sRn = null;
        this.sRu = null;
        this.sRv = false;
        this.field_bankName = parcel.readString();
        this.field_desc = parcel.readString();
        this.field_bankcardType = parcel.readString();
        this.field_bindSerial = parcel.readString();
        this.field_cardType = parcel.readInt();
        this.sRv = parcel.readInt() == 1;
        this.field_mobile = parcel.readString();
        this.field_onceQuotaKind = parcel.readDouble();
        this.field_onceQuotaVirtual = parcel.readDouble();
        this.field_dayQuotaKind = parcel.readDouble();
        this.field_dayQuotaVirtual = parcel.readDouble();
        this.field_bankcardTail = parcel.readString();
        this.field_bankPhone = parcel.readString();
        this.field_bankcardTag = parcel.readInt();
        this.field_bankcardState = parcel.readInt();
        this.sRn = parcel.readString();
        this.sQF = parcel.readInt();
        this.sRu = parcel.readString();
        this.field_bankcardClientType = parcel.readInt();
        this.field_ext_msg = parcel.readString();
        if (parcel.readInt() != 1) {
            z = false;
        }
        this.field_support_micropay = z;
        this.field_arrive_type = parcel.readString();
        this.field_fetch_charge_rate = parcel.readDouble();
        this.field_full_fetch_charge_fee = parcel.readDouble();
        this.field_no_micro_word = parcel.readString();
        this.field_card_bottom_wording = parcel.readString();
        this.sRA = parcel.readString();
        this.sRx = parcel.readLong();
        this.sRz = parcel.readLong();
        this.sRy = parcel.readLong();
        this.sRB = parcel.readInt();
    }

    public void writeToParcel(Parcel parcel, int i) {
        int i2 = 1;
        parcel.writeString(this.field_bankName);
        parcel.writeString(this.field_desc);
        parcel.writeString(this.field_bankcardType);
        parcel.writeString(this.field_bindSerial);
        parcel.writeInt(this.field_cardType);
        parcel.writeInt(this.sRv ? 1 : 0);
        parcel.writeString(this.field_mobile);
        parcel.writeDouble(this.field_onceQuotaKind);
        parcel.writeDouble(this.field_onceQuotaVirtual);
        parcel.writeDouble(this.field_dayQuotaKind);
        parcel.writeDouble(this.field_dayQuotaVirtual);
        parcel.writeString(this.field_bankcardTail);
        parcel.writeString(this.field_bankPhone);
        parcel.writeInt(this.field_bankcardTag);
        parcel.writeInt(this.field_bankcardState);
        parcel.writeString(this.sRn);
        parcel.writeInt(this.sQF);
        parcel.writeString(this.sRu);
        parcel.writeInt(this.field_bankcardClientType);
        parcel.writeString(this.field_ext_msg);
        if (!this.field_support_micropay) {
            i2 = 0;
        }
        parcel.writeInt(i2);
        parcel.writeString(this.field_arrive_type);
        parcel.writeDouble(this.field_fetch_charge_rate);
        parcel.writeDouble(this.field_full_fetch_charge_fee);
        parcel.writeString(this.field_no_micro_word);
        parcel.writeString(this.field_card_bottom_wording);
        parcel.writeString(this.sRA);
        parcel.writeLong(this.sRx);
        parcel.writeLong(this.sRz);
        parcel.writeLong(this.sRy);
        parcel.writeInt(this.sRB);
    }

    public final void b(Cursor cursor) {
        super.b(cursor);
    }
}
