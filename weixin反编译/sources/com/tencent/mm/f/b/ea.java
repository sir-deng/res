package com.tencent.mm.f.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class ea extends c {
    public static final String[] fNF = new String[0];
    private static final int fNO = "rowid".hashCode();
    private static final int gaM = "desc".hashCode();
    private static final int gkg = "tips".hashCode();
    private static final int gtW = "bindSerial".hashCode();
    private static final int gtX = "cardType".hashCode();
    private static final int gtY = "bankcardState".hashCode();
    private static final int gtZ = "forbidWord".hashCode();
    private static final int guA = "forbid_title".hashCode();
    private static final int guB = "forbid_url".hashCode();
    private static final int guC = "no_micro_word".hashCode();
    private static final int guD = "card_bottom_wording".hashCode();
    private static final int guE = "support_lqt_turn_in".hashCode();
    private static final int guF = "support_lqt_turn_out".hashCode();
    private static final int guG = "is_hightlight_pre_arrive_time_wording".hashCode();
    private static final int gua = "bankName".hashCode();
    private static final int gub = "bankcardType".hashCode();
    private static final int guc = "bankcardTypeName".hashCode();
    private static final int gud = "bankcardTag".hashCode();
    private static final int gue = "bankcardTail".hashCode();
    private static final int guf = "supportTag".hashCode();
    private static final int gug = "mobile".hashCode();
    private static final int guh = "trueName".hashCode();
    private static final int gui = "bankPhone".hashCode();
    private static final int guj = "bizUsername".hashCode();
    private static final int guk = "onceQuotaKind".hashCode();
    private static final int gul = "onceQuotaVirtual".hashCode();
    private static final int gum = "dayQuotaKind".hashCode();
    private static final int gun = "dayQuotaVirtual".hashCode();
    private static final int guo = "fetchArriveTime".hashCode();
    private static final int gup = "fetchArriveTimeWording".hashCode();
    private static final int guq = "repay_url".hashCode();
    private static final int gur = "wxcreditState".hashCode();
    private static final int gus = "bankcardClientType".hashCode();
    private static final int gut = "ext_msg".hashCode();
    private static final int guu = "support_micropay".hashCode();
    private static final int guv = "arrive_type".hashCode();
    private static final int guw = "avail_save_wording".hashCode();
    private static final int gux = "fetch_charge_rate".hashCode();
    private static final int guy = "full_fetch_charge_fee".hashCode();
    private static final int guz = "fetch_charge_info".hashCode();
    public String field_arrive_type;
    public String field_avail_save_wording;
    public String field_bankName;
    public String field_bankPhone;
    public int field_bankcardClientType;
    public int field_bankcardState;
    public int field_bankcardTag;
    public String field_bankcardTail;
    public String field_bankcardType;
    public String field_bankcardTypeName;
    public String field_bindSerial;
    public String field_bizUsername;
    public int field_cardType;
    public String field_card_bottom_wording;
    public double field_dayQuotaKind;
    public double field_dayQuotaVirtual;
    public String field_desc;
    public String field_ext_msg;
    public long field_fetchArriveTime;
    public String field_fetchArriveTimeWording;
    public String field_fetch_charge_info;
    public double field_fetch_charge_rate;
    public String field_forbidWord;
    public String field_forbid_title;
    public String field_forbid_url;
    public double field_full_fetch_charge_fee;
    public int field_is_hightlight_pre_arrive_time_wording;
    public String field_mobile;
    public String field_no_micro_word;
    public double field_onceQuotaKind;
    public double field_onceQuotaVirtual;
    public String field_repay_url;
    public int field_supportTag;
    public int field_support_lqt_turn_in;
    public int field_support_lqt_turn_out;
    public boolean field_support_micropay;
    public String field_tips;
    public String field_trueName;
    public int field_wxcreditState;
    private boolean gaI = true;
    private boolean gka = true;
    private boolean gtA = true;
    private boolean gtB = true;
    private boolean gtC = true;
    private boolean gtD = true;
    private boolean gtE = true;
    private boolean gtF = true;
    private boolean gtG = true;
    private boolean gtH = true;
    private boolean gtI = true;
    private boolean gtJ = true;
    private boolean gtK = true;
    private boolean gtL = true;
    private boolean gtM = true;
    private boolean gtN = true;
    private boolean gtO = true;
    private boolean gtP = true;
    private boolean gtQ = true;
    private boolean gtR = true;
    private boolean gtS = true;
    private boolean gtT = true;
    private boolean gtU = true;
    private boolean gtV = true;
    private boolean gtl = true;
    private boolean gtm = true;
    private boolean gtn = true;
    private boolean gto = true;
    private boolean gtp = true;
    private boolean gtq = true;
    private boolean gtr = true;
    private boolean gts = true;
    private boolean gtt = true;
    private boolean gtu = true;
    private boolean gtv = true;
    private boolean gtw = true;
    private boolean gtx = true;
    private boolean gty = true;
    private boolean gtz = true;

    public void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (gtW == hashCode) {
                    this.field_bindSerial = cursor.getString(i);
                    this.gtl = true;
                } else if (gtX == hashCode) {
                    this.field_cardType = cursor.getInt(i);
                } else if (gtY == hashCode) {
                    this.field_bankcardState = cursor.getInt(i);
                } else if (gtZ == hashCode) {
                    this.field_forbidWord = cursor.getString(i);
                } else if (gua == hashCode) {
                    this.field_bankName = cursor.getString(i);
                } else if (gub == hashCode) {
                    this.field_bankcardType = cursor.getString(i);
                } else if (guc == hashCode) {
                    this.field_bankcardTypeName = cursor.getString(i);
                } else if (gud == hashCode) {
                    this.field_bankcardTag = cursor.getInt(i);
                } else if (gue == hashCode) {
                    this.field_bankcardTail = cursor.getString(i);
                } else if (guf == hashCode) {
                    this.field_supportTag = cursor.getInt(i);
                } else if (gug == hashCode) {
                    this.field_mobile = cursor.getString(i);
                } else if (guh == hashCode) {
                    this.field_trueName = cursor.getString(i);
                } else if (gaM == hashCode) {
                    this.field_desc = cursor.getString(i);
                } else if (gui == hashCode) {
                    this.field_bankPhone = cursor.getString(i);
                } else if (guj == hashCode) {
                    this.field_bizUsername = cursor.getString(i);
                } else if (guk == hashCode) {
                    this.field_onceQuotaKind = cursor.getDouble(i);
                } else if (gul == hashCode) {
                    this.field_onceQuotaVirtual = cursor.getDouble(i);
                } else if (gum == hashCode) {
                    this.field_dayQuotaKind = cursor.getDouble(i);
                } else if (gun == hashCode) {
                    this.field_dayQuotaVirtual = cursor.getDouble(i);
                } else if (guo == hashCode) {
                    this.field_fetchArriveTime = cursor.getLong(i);
                } else if (gup == hashCode) {
                    this.field_fetchArriveTimeWording = cursor.getString(i);
                } else if (guq == hashCode) {
                    this.field_repay_url = cursor.getString(i);
                } else if (gur == hashCode) {
                    this.field_wxcreditState = cursor.getInt(i);
                } else if (gus == hashCode) {
                    this.field_bankcardClientType = cursor.getInt(i);
                } else if (gut == hashCode) {
                    this.field_ext_msg = cursor.getString(i);
                } else if (guu == hashCode) {
                    this.field_support_micropay = cursor.getInt(i) != 0;
                } else if (guv == hashCode) {
                    this.field_arrive_type = cursor.getString(i);
                } else if (guw == hashCode) {
                    this.field_avail_save_wording = cursor.getString(i);
                } else if (gux == hashCode) {
                    this.field_fetch_charge_rate = cursor.getDouble(i);
                } else if (guy == hashCode) {
                    this.field_full_fetch_charge_fee = cursor.getDouble(i);
                } else if (guz == hashCode) {
                    this.field_fetch_charge_info = cursor.getString(i);
                } else if (gkg == hashCode) {
                    this.field_tips = cursor.getString(i);
                } else if (guA == hashCode) {
                    this.field_forbid_title = cursor.getString(i);
                } else if (guB == hashCode) {
                    this.field_forbid_url = cursor.getString(i);
                } else if (guC == hashCode) {
                    this.field_no_micro_word = cursor.getString(i);
                } else if (guD == hashCode) {
                    this.field_card_bottom_wording = cursor.getString(i);
                } else if (guE == hashCode) {
                    this.field_support_lqt_turn_in = cursor.getInt(i);
                } else if (guF == hashCode) {
                    this.field_support_lqt_turn_out = cursor.getInt(i);
                } else if (guG == hashCode) {
                    this.field_is_hightlight_pre_arrive_time_wording = cursor.getInt(i);
                } else if (fNO == hashCode) {
                    this.xrR = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues vP() {
        ContentValues contentValues = new ContentValues();
        if (this.gtl) {
            contentValues.put("bindSerial", this.field_bindSerial);
        }
        if (this.gtm) {
            contentValues.put("cardType", Integer.valueOf(this.field_cardType));
        }
        if (this.gtn) {
            contentValues.put("bankcardState", Integer.valueOf(this.field_bankcardState));
        }
        if (this.gto) {
            contentValues.put("forbidWord", this.field_forbidWord);
        }
        if (this.gtp) {
            contentValues.put("bankName", this.field_bankName);
        }
        if (this.gtq) {
            contentValues.put("bankcardType", this.field_bankcardType);
        }
        if (this.gtr) {
            contentValues.put("bankcardTypeName", this.field_bankcardTypeName);
        }
        if (this.gts) {
            contentValues.put("bankcardTag", Integer.valueOf(this.field_bankcardTag));
        }
        if (this.gtt) {
            contentValues.put("bankcardTail", this.field_bankcardTail);
        }
        if (this.gtu) {
            contentValues.put("supportTag", Integer.valueOf(this.field_supportTag));
        }
        if (this.gtv) {
            contentValues.put("mobile", this.field_mobile);
        }
        if (this.gtw) {
            contentValues.put("trueName", this.field_trueName);
        }
        if (this.gaI) {
            contentValues.put("desc", this.field_desc);
        }
        if (this.gtx) {
            contentValues.put("bankPhone", this.field_bankPhone);
        }
        if (this.gty) {
            contentValues.put("bizUsername", this.field_bizUsername);
        }
        if (this.gtz) {
            contentValues.put("onceQuotaKind", Double.valueOf(this.field_onceQuotaKind));
        }
        if (this.gtA) {
            contentValues.put("onceQuotaVirtual", Double.valueOf(this.field_onceQuotaVirtual));
        }
        if (this.gtB) {
            contentValues.put("dayQuotaKind", Double.valueOf(this.field_dayQuotaKind));
        }
        if (this.gtC) {
            contentValues.put("dayQuotaVirtual", Double.valueOf(this.field_dayQuotaVirtual));
        }
        if (this.gtD) {
            contentValues.put("fetchArriveTime", Long.valueOf(this.field_fetchArriveTime));
        }
        if (this.gtE) {
            contentValues.put("fetchArriveTimeWording", this.field_fetchArriveTimeWording);
        }
        if (this.gtF) {
            contentValues.put("repay_url", this.field_repay_url);
        }
        if (this.gtG) {
            contentValues.put("wxcreditState", Integer.valueOf(this.field_wxcreditState));
        }
        if (this.gtH) {
            contentValues.put("bankcardClientType", Integer.valueOf(this.field_bankcardClientType));
        }
        if (this.gtI) {
            contentValues.put("ext_msg", this.field_ext_msg);
        }
        if (this.gtJ) {
            contentValues.put("support_micropay", Boolean.valueOf(this.field_support_micropay));
        }
        if (this.gtK) {
            contentValues.put("arrive_type", this.field_arrive_type);
        }
        if (this.gtL) {
            contentValues.put("avail_save_wording", this.field_avail_save_wording);
        }
        if (this.gtM) {
            contentValues.put("fetch_charge_rate", Double.valueOf(this.field_fetch_charge_rate));
        }
        if (this.gtN) {
            contentValues.put("full_fetch_charge_fee", Double.valueOf(this.field_full_fetch_charge_fee));
        }
        if (this.gtO) {
            contentValues.put("fetch_charge_info", this.field_fetch_charge_info);
        }
        if (this.gka) {
            contentValues.put("tips", this.field_tips);
        }
        if (this.gtP) {
            contentValues.put("forbid_title", this.field_forbid_title);
        }
        if (this.gtQ) {
            contentValues.put("forbid_url", this.field_forbid_url);
        }
        if (this.gtR) {
            contentValues.put("no_micro_word", this.field_no_micro_word);
        }
        if (this.gtS) {
            contentValues.put("card_bottom_wording", this.field_card_bottom_wording);
        }
        if (this.gtT) {
            contentValues.put("support_lqt_turn_in", Integer.valueOf(this.field_support_lqt_turn_in));
        }
        if (this.gtU) {
            contentValues.put("support_lqt_turn_out", Integer.valueOf(this.field_support_lqt_turn_out));
        }
        if (this.gtV) {
            contentValues.put("is_hightlight_pre_arrive_time_wording", Integer.valueOf(this.field_is_hightlight_pre_arrive_time_wording));
        }
        if (this.xrR > 0) {
            contentValues.put("rowid", Long.valueOf(this.xrR));
        }
        return contentValues;
    }
}
