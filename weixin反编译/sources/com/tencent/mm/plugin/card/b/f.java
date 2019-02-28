package com.tencent.mm.plugin.card.b;

import android.text.TextUtils;
import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.a.o;
import com.tencent.mm.plugin.card.model.CardInfo;
import com.tencent.mm.plugin.card.sharecard.model.ShareCardInfo;
import com.tencent.mm.protocal.c.ajn;
import com.tencent.mm.protocal.c.aw;
import com.tencent.mm.protocal.c.bjq;
import com.tencent.mm.protocal.c.bom;
import com.tencent.mm.protocal.c.bsv;
import com.tencent.mm.protocal.c.in;
import com.tencent.mm.protocal.c.ko;
import com.tencent.mm.protocal.c.kq;
import com.tencent.mm.protocal.c.kw;
import com.tencent.mm.protocal.c.lb;
import com.tencent.mm.protocal.c.oy;
import com.tencent.mm.protocal.c.ri;
import com.tencent.mm.protocal.c.rj;
import com.tencent.mm.protocal.c.sb;
import com.tencent.mm.protocal.c.wl;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import java.util.ArrayList;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;

public final class f {
    public static ArrayList<ShareCardInfo> xm(String str) {
        if (TextUtils.isEmpty(str)) {
            x.e("MicroMsg.CardInfoParser", "parseShareCardArray jsonContent is null");
            return null;
        }
        try {
            JSONArray optJSONArray = new JSONObject(str).optJSONArray("card_list");
            if (optJSONArray == null || optJSONArray.length() == 0) {
                x.e("MicroMsg.CardInfoParser", "parseShareCardArray cardItemListJson is null");
                return null;
            }
            ArrayList<ShareCardInfo> arrayList = new ArrayList();
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                ShareCardInfo shareCardInfo = new ShareCardInfo();
                a(shareCardInfo, optJSONObject);
                arrayList.add(shareCardInfo);
            }
            return arrayList;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.CardInfoParser", e, "", new Object[0]);
            return null;
        }
    }

    public static void a(ShareCardInfo shareCardInfo, String str) {
        if (TextUtils.isEmpty(str)) {
            x.e("MicroMsg.CardInfoParser", "parserShareCardItemJson jsonContent is null");
            return;
        }
        try {
            a(shareCardInfo, new JSONObject(str).optJSONObject("share_card"));
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.CardInfoParser", e, "", new Object[0]);
            x.e("MicroMsg.CardInfoParser", e.getMessage());
        }
    }

    public static void a(ShareCardInfo shareCardInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            x.e("MicroMsg.CardInfoParser", "parserShareCardItemJson json is null");
            return;
        }
        shareCardInfo.field_card_id = xo(jSONObject.optString("card_id"));
        shareCardInfo.field_card_tp_id = xo(jSONObject.optString("card_tp_id"));
        shareCardInfo.field_app_id = jSONObject.optString("app_id");
        shareCardInfo.field_consumer = jSONObject.optString("consumer");
        shareCardInfo.field_share_time = (long) jSONObject.optInt("share_time");
        shareCardInfo.field_updateTime = (long) jSONObject.optInt("update_time");
        shareCardInfo.field_status = jSONObject.optInt("state_flag");
        shareCardInfo.field_updateSeq = jSONObject.optLong("sequence");
        shareCardInfo.field_from_username = jSONObject.optString("from_user_name");
        shareCardInfo.field_begin_time = jSONObject.optLong("begin_time");
        shareCardInfo.field_end_time = (long) jSONObject.optInt("end_time");
        JSONObject optJSONObject = jSONObject.optJSONObject("card_data_info");
        JSONObject optJSONObject2 = jSONObject.optJSONObject("card_tp_info");
        JSONObject optJSONObject3 = jSONObject.optJSONObject("share_info");
        shareCardInfo.kQE = y(optJSONObject);
        shareCardInfo.kQD = z(optJSONObject2);
        shareCardInfo.kQF = A(optJSONObject3);
        if (shareCardInfo.kQE != null) {
            shareCardInfo.a(shareCardInfo.kQE);
        }
        if (shareCardInfo.kQD != null) {
            kw kwVar = shareCardInfo.kQD;
            shareCardInfo.kQD = kwVar;
            try {
                shareCardInfo.field_cardTpInfoData = kwVar.toByteArray();
            } catch (Exception e) {
                x.e("MicroMsg.ShareCardInfo", "setCardTpInfo fail, ex = %s", e.getMessage());
            }
            shareCardInfo.field_end_time = (long) optJSONObject2.optInt("end_time");
            shareCardInfo.field_begin_time = (long) optJSONObject2.optInt("begin_time");
        }
        if (shareCardInfo.kQF != null) {
            bjq bjq = shareCardInfo.kQF;
            shareCardInfo.kQF = bjq;
            try {
                shareCardInfo.field_shareInfoData = bjq.toByteArray();
            } catch (Throwable e2) {
                x.e("MicroMsg.ShareCardInfo", "setShareInfo fail, ex = %s", e2.getMessage());
                x.printErrStackTrace("MicroMsg.ShareCardInfo", e2, "", new Object[0]);
            }
        }
        shareCardInfo.field_local_updateTime = (long) ((int) (System.currentTimeMillis() / 1000));
    }

    public static ArrayList<CardInfo> xn(String str) {
        if (TextUtils.isEmpty(str)) {
            x.e("MicroMsg.CardInfoParser", "parseCardArray jsonContent is null");
            return null;
        }
        try {
            JSONArray optJSONArray = new JSONObject(str).optJSONArray("card_array");
            if (optJSONArray == null || optJSONArray.length() == 0) {
                x.e("MicroMsg.CardInfoParser", "parseCardArray cardItemListJson is null");
                return null;
            }
            ArrayList<CardInfo> arrayList = new ArrayList();
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                CardInfo cardInfo = new CardInfo();
                a(cardInfo, optJSONObject);
                arrayList.add(cardInfo);
            }
            return arrayList;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.CardInfoParser", e, "", new Object[0]);
            return null;
        }
    }

    public static void a(CardInfo cardInfo, String str) {
        if (TextUtils.isEmpty(str)) {
            x.e("MicroMsg.CardInfoParser", "parserCardItemJson jsonContent is null");
            return;
        }
        try {
            a(cardInfo, new JSONObject(str));
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.CardInfoParser", e, "", new Object[0]);
        }
    }

    private static void a(CardInfo cardInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            x.e("MicroMsg.CardInfoParser", "parserCardItemJson json is null");
            return;
        }
        cardInfo.field_card_id = xo(jSONObject.optString("card_id"));
        cardInfo.field_card_tp_id = xo(jSONObject.optString("card_tp_id"));
        cardInfo.field_delete_state_flag = jSONObject.optInt("state_flag");
        cardInfo.field_updateTime = (long) jSONObject.optInt("update_time");
        cardInfo.field_updateSeq = jSONObject.optLong("sequence");
        cardInfo.field_from_username = jSONObject.optString("from_username");
        cardInfo.field_begin_time = jSONObject.optLong("begin_time", 0);
        cardInfo.field_end_time = jSONObject.optLong("end_time", 0);
        cardInfo.kPD = jSONObject.optString("encrypt_code");
        JSONObject optJSONObject = jSONObject.optJSONObject("card_data_info");
        JSONObject optJSONObject2 = jSONObject.optJSONObject("card_tp_info");
        JSONObject optJSONObject3 = jSONObject.optJSONObject("share_info");
        cardInfo.kQE = y(optJSONObject);
        cardInfo.kQD = z(optJSONObject2);
        cardInfo.kQF = A(optJSONObject3);
        if (cardInfo.kQD != null) {
            kw kwVar = cardInfo.kQD;
            cardInfo.kQD = kwVar;
            try {
                cardInfo.field_cardTpInfoData = kwVar.toByteArray();
            } catch (Exception e) {
                x.e("MicroMsg.CardInfo", "setCardTpInfo fail, ex = %s", e.getMessage());
            }
            cardInfo.field_block_mask = Integer.toString(cardInfo.kQD.vYT);
            cardInfo.field_card_type = cardInfo.kQD.kPz;
            if (TextUtils.isEmpty(cardInfo.field_card_tp_id)) {
                cardInfo.field_card_tp_id = cardInfo.kQD.kPy;
            }
            if (cardInfo.field_begin_time == 0 && optJSONObject2 != null) {
                cardInfo.field_begin_time = optJSONObject2.optLong("begin_time");
            }
            if (cardInfo.field_end_time == 0 && optJSONObject2 != null) {
                cardInfo.field_end_time = optJSONObject2.optLong("end_time");
            }
            if (cardInfo.kQD.vZr != null) {
                cardInfo.field_is_dynamic = cardInfo.kQD.vZr.wgH;
            }
        }
        if (cardInfo.kQE != null) {
            cardInfo.a(cardInfo.kQE);
            cardInfo.field_status = cardInfo.kQE.status;
        }
        if (cardInfo.kQF != null) {
            bjq bjq = cardInfo.kQF;
            cardInfo.kQF = bjq;
            try {
                cardInfo.field_shareInfoData = bjq.toByteArray();
            } catch (Throwable e2) {
                x.e("MicroMsg.CardInfo", "setShareInfo fail, ex = %s", e2.getMessage());
                x.printErrStackTrace("MicroMsg.CardInfo", e2, "", new Object[0]);
            }
        }
        cardInfo.field_local_updateTime = (long) ((int) (System.currentTimeMillis() / 1000));
    }

    private static String xo(String str) {
        if (TextUtils.isEmpty(str) || "null".equals(str)) {
            return "";
        }
        return str;
    }

    private static ko y(JSONObject jSONObject) {
        LinkedList linkedList = null;
        if (jSONObject == null) {
            x.e("MicroMsg.CardInfoParser", "parserCardDataInfo json is null");
            return null;
        }
        ko koVar = new ko();
        try {
            koVar.status = jSONObject.optInt(DownloadInfo.STATUS);
            koVar.vYb = jSONObject.optInt("init_balance");
            koVar.vYc = jSONObject.optInt("init_bonus");
            JSONArray optJSONArray = jSONObject.optJSONArray("cell_list0");
            if (optJSONArray != null) {
                koVar.vYd = k(optJSONArray);
            }
            optJSONArray = jSONObject.optJSONArray("cell_list1");
            if (optJSONArray != null) {
                koVar.vYe = k(optJSONArray);
            }
            optJSONArray = jSONObject.optJSONArray("cell_list2");
            if (optJSONArray != null) {
                koVar.vYf = k(optJSONArray);
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray("acceptors");
            if (optJSONArray2 != null) {
                if (!(optJSONArray2 == null || optJSONArray2.length() == 0)) {
                    LinkedList linkedList2 = new LinkedList();
                    for (int i = 0; i < optJSONArray2.length(); i++) {
                        linkedList2.add((String) optJSONArray2.get(i));
                    }
                    linkedList = linkedList2;
                }
                koVar.vYg = linkedList;
            }
            koVar.vYh = jSONObject.optInt("avail_num");
            koVar.vYi = jSONObject.optInt("code_type");
            koVar.code = jSONObject.optString(TMQQDownloaderOpenSDKConst.UINTYPE_CODE);
            JSONArray optJSONArray3 = jSONObject.optJSONArray("secondary_fields");
            if (optJSONArray3 != null) {
                koVar.vYj = l(optJSONArray3);
            }
            koVar.vYk = jSONObject.optLong("stock_num");
            koVar.vYl = jSONObject.optInt("limit_num");
            koVar.vYm = jSONObject.optString("user_report_url");
            JSONObject optJSONObject = jSONObject.optJSONObject("third_field");
            if (optJSONObject != null) {
                koVar.vYn = B(optJSONObject);
            }
            koVar.vYo = m(jSONObject.optJSONArray("action_sheets"));
            optJSONObject = jSONObject.optJSONObject("card_list_field");
            if (optJSONObject != null) {
                koVar.vYp = B(optJSONObject);
            }
            optJSONObject = jSONObject.optJSONObject("operate_field");
            if (optJSONObject != null) {
                koVar.vYq = B(optJSONObject);
            }
            optJSONObject = jSONObject.optJSONObject("limit_field");
            if (optJSONObject != null) {
                koVar.vYr = B(optJSONObject);
            }
            optJSONObject = jSONObject.optJSONObject("detail_table");
            if (optJSONObject != null) {
                koVar.vYs = E(optJSONObject);
            }
            koVar.vYt = jSONObject.optString("background_pic_url");
            optJSONObject = jSONObject.optJSONObject("gifting_info_cell");
            if (optJSONObject != null) {
                koVar.vYu = B(optJSONObject);
            }
            koVar.vYv = jSONObject.optString("sign_number");
            optJSONObject = jSONObject.optJSONObject("unavailable_qrcode_field");
            if (optJSONObject != null) {
                koVar.vYw = B(optJSONObject);
            }
            koVar.vYx = jSONObject.optBoolean("is_commom_card");
            koVar.vYy = jSONObject.optBoolean("is_location_authorized");
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.CardInfoParser", e, "", new Object[0]);
        }
        return koVar;
    }

    private static LinkedList<lb> k(JSONArray jSONArray) {
        if (jSONArray == null || jSONArray.length() == 0) {
            return null;
        }
        LinkedList<lb> linkedList = new LinkedList();
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObject = jSONArray.getJSONObject(i);
            lb lbVar = new lb();
            lbVar.title = jSONObject.optString("title");
            lbVar.kPB = jSONObject.optString("sub_title");
            lbVar.kTd = jSONObject.optString("tips");
            lbVar.url = jSONObject.optString(SlookSmartClipMetaTag.TAG_TYPE_URL);
            lbVar.vZQ = jSONObject.optLong("show_flag");
            lbVar.vZR = jSONObject.optString("primary_color");
            lbVar.vZS = jSONObject.optString("secondary_color");
            lbVar.pfi = jSONObject.optString("icon_url");
            lbVar.vYB = jSONObject.optString("app_brand_user_name");
            lbVar.vYC = jSONObject.optString("app_brand_pass");
            linkedList.add(lbVar);
        }
        return linkedList;
    }

    public static kw z(JSONObject jSONObject) {
        in inVar = null;
        if (jSONObject == null) {
            x.e("MicroMsg.CardInfoParser", "parserCardTpInfo json is null");
            return null;
        }
        kw kwVar = new kw();
        try {
            kq kqVar;
            bsv bsv;
            wl wlVar;
            aw awVar;
            kwVar.kPy = jSONObject.optString("card_tp_id");
            kwVar.kPA = jSONObject.optString("logo_url");
            kwVar.fGh = jSONObject.optString("appid");
            kwVar.vYJ = jSONObject.optString("app_username");
            kwVar.vYK = jSONObject.optInt("card_category");
            kwVar.kPz = jSONObject.optInt("card_type");
            kwVar.kQL = jSONObject.optString("brand_name");
            kwVar.title = jSONObject.optString("title");
            kwVar.kPB = jSONObject.optString("sub_title");
            kwVar.hdx = jSONObject.optString("color");
            kwVar.loF = jSONObject.optString("notice");
            kwVar.vYL = jSONObject.optString("service_phone");
            kwVar.vYO = jSONObject.optString("image_text_url");
            kwVar.vYP = jSONObject.optString("source_icon");
            kwVar.bhd = jSONObject.optString("source");
            JSONArray optJSONArray = jSONObject.optJSONArray("primary_fields");
            if (optJSONArray != null) {
                kwVar.vYM = l(optJSONArray);
            }
            optJSONArray = jSONObject.optJSONArray("introduce_fields");
            if (optJSONArray != null) {
                kwVar.vYN = l(optJSONArray);
            }
            kwVar.vYQ = jSONObject.optInt("shop_count");
            kwVar.vYR = jSONObject.optString("limit_wording");
            kwVar.kQK = jSONObject.optString("card_type_name");
            kwVar.vYS = jSONObject.optString("h5_show_url");
            kwVar.vYT = jSONObject.optInt("block_mask");
            kwVar.vYU = jSONObject.optString("middle_icon");
            kwVar.vYV = jSONObject.optString("accept_wording");
            kwVar.vYW = jSONObject.optLong("control_flag");
            kwVar.vYX = jSONObject.optString("advertise_wording");
            kwVar.vYY = jSONObject.optString("advertise_url");
            kwVar.vYZ = jSONObject.optString("public_service_name");
            JSONObject optJSONObject = jSONObject.optJSONObject("announcement");
            if (optJSONObject == null) {
                x.e("MicroMsg.CardInfoParser", "parserannoucement json is null");
                kqVar = null;
            } else {
                kqVar = new kq();
                kqVar.type = optJSONObject.optInt(Columns.TYPE);
                kqVar.text = optJSONObject.optString("text");
                kqVar.url = optJSONObject.optString(SlookSmartClipMetaTag.TAG_TYPE_URL);
                kqVar.quA = optJSONObject.optInt("endtime");
                kqVar.bZP = optJSONObject.optInt("create_time");
                kqVar.vYz = optJSONObject.optString("thumb_url");
            }
            kwVar.vZa = kqVar;
            kwVar.vZb = jSONObject.optString("public_service_tip");
            kwVar.vZc = jSONObject.optString("primary_sub_title");
            kwVar.vZd = jSONObject.optInt("gen_type");
            kwVar.vZe = C(jSONObject.optJSONObject("detail_struct"));
            JSONObject optJSONObject2 = jSONObject.optJSONObject("use_condition");
            if (optJSONObject2 == null) {
                x.e("MicroMsg.CardInfoParser", "parserUseCondition json is null");
                bsv = null;
            } else {
                int i;
                bom D;
                bsv = new bsv();
                bsv.title = optJSONObject2.optString("title");
                JSONArray optJSONArray2 = optJSONObject2.optJSONArray("outer_tag_list");
                if (optJSONArray2 == null || optJSONArray2.length() <= 0) {
                    x.e("MicroMsg.CardInfoParser", "parserUseCondition outer_tag_list is null");
                } else {
                    bsv.xaI = new LinkedList();
                    for (i = 0; i < optJSONArray2.length(); i++) {
                        D = D(optJSONArray2.optJSONObject(i));
                        if (D != null) {
                            bsv.xaI.add(D);
                        }
                    }
                }
                optJSONArray2 = optJSONObject2.optJSONArray("inner_tag_list");
                if (optJSONArray2 == null || optJSONArray2.length() <= 0) {
                    x.e("MicroMsg.CardInfoParser", "parserUseCondition inner_tag_list is null");
                } else {
                    bsv.xaJ = new LinkedList();
                    for (i = 0; i < optJSONArray2.length(); i++) {
                        D = D(optJSONArray2.optJSONObject(i));
                        if (D != null) {
                            bsv.xaJ.add(D);
                        }
                    }
                }
                JSONArray optJSONArray3 = optJSONObject2.optJSONArray("detail_field");
                if (optJSONArray3 == null || optJSONArray3.length() <= 0) {
                    x.e("MicroMsg.CardInfoParser", "parserUseCondition detail_field is null");
                } else {
                    bsv.xaK = l(optJSONArray3);
                }
            }
            kwVar.vZf = bsv;
            optJSONObject = jSONObject.optJSONObject("follow_box");
            if (optJSONObject == null) {
                x.e("MicroMsg.CardInfoParser", "parserFollowBox json is null");
                wlVar = null;
            } else {
                wlVar = new wl();
                wlVar.text = optJSONObject.optString("text");
                wlVar.wnE = optJSONObject.optInt("follow");
                x.i("MicroMsg.CardInfoParser", "follow:" + wlVar.wnE + "　text:" + wlVar.text);
            }
            kwVar.vZg = wlVar;
            optJSONObject = jSONObject.optJSONObject("guidance");
            if (optJSONObject == null) {
                x.e("MicroMsg.CardInfoParser", "parserActionSheet json is null");
                awVar = null;
            } else {
                awVar = new aw();
                awVar.text = optJSONObject.optString("text");
                awVar.url = optJSONObject.optString(SlookSmartClipMetaTag.TAG_TYPE_URL);
            }
            kwVar.vZh = awVar;
            kwVar.vZi = jSONObject.optInt("need_direct_jump", 0);
            kwVar.vZj = jSONObject.optInt("is_acceptable", 0);
            kwVar.vZk = jSONObject.optString("unacceptable_wording");
            kwVar.vZl = jSONObject.optInt("has_hongbao", 0);
            kwVar.vZm = jSONObject.optString("accept_ui_title");
            kwVar.vZn = jSONObject.optInt("show_accept_view", 0);
            JSONObject optJSONObject3 = jSONObject.optJSONObject("brand_field");
            if (optJSONObject3 != null) {
                kwVar.vZo = B(optJSONObject3);
            }
            kwVar.vZp = jSONObject.optString("shop_name");
            optJSONObject3 = jSONObject.optJSONObject("pay_and_qrcode_field");
            if (optJSONObject3 != null) {
                kwVar.vZq = B(optJSONObject3);
            }
            optJSONObject = jSONObject.optJSONObject("dynamic_qr_code_info");
            if (optJSONObject != null) {
                sb sbVar;
                if (optJSONObject == null) {
                    x.e("MicroMsg.CardInfoParser", "parserDynamicQrCodeInfo json is null");
                    sbVar = null;
                } else {
                    sbVar = new sb();
                    sbVar.wgH = optJSONObject.optBoolean("is_dynamic");
                    sbVar.wgI = optJSONObject.optBoolean("can_refresh");
                    sbVar.wgJ = optJSONObject.optString("refresh_wording");
                    x.i("MicroMsg.CardInfoParser", "is_dynamic:" + sbVar.wgH + "　can_refresh:" + sbVar.wgI + "　refresh_wording:" + sbVar.wgJ);
                }
                kwVar.vZr = sbVar;
            }
            kwVar.vZs = jSONObject.optBoolean("is_card_code_exposed");
            kwVar.vZt = jSONObject.optInt("qrcode_correct_level");
            kwVar.vZu = jSONObject.optBoolean("dismiss_qrcode_icon_on_card");
            kwVar.vZv = jSONObject.optBoolean("need_location");
            optJSONObject3 = jSONObject.optJSONObject("bluetooth_info");
            if (optJSONObject3 != null) {
                if (optJSONObject3 == null) {
                    x.e("MicroMsg.CardInfoParser", "parseBluetoothInfo json is null");
                } else {
                    inVar = new in();
                    inVar.name = optJSONObject3.optString("name");
                    inVar.vVk = optJSONObject3.optInt("report_time_interval", 0);
                    x.i("MicroMsg.CardInfoParser", "blueToothInfo.name:%s", inVar.name);
                }
                kwVar.vZw = inVar;
            }
            kwVar.vZx = jSONObject.optString("biz_nickname");
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.CardInfoParser", e, "", new Object[0]);
        }
        return kwVar;
    }

    private static LinkedList<oy> l(JSONArray jSONArray) {
        if (jSONArray == null || jSONArray.length() == 0) {
            return null;
        }
        LinkedList<oy> linkedList = new LinkedList();
        for (int i = 0; i < jSONArray.length(); i++) {
            oy B = B(jSONArray.getJSONObject(i));
            if (B != null) {
                linkedList.add(B);
            }
        }
        return linkedList;
    }

    private static bjq A(JSONObject jSONObject) {
        if (jSONObject == null) {
            x.e("MicroMsg.CardInfoParser", "parserShareInfo json is null");
            return null;
        }
        bjq bjq = new bjq();
        bjq.wTA = jSONObject.optString("gift_msg_title");
        return bjq;
    }

    private static LinkedList<aw> m(JSONArray jSONArray) {
        LinkedList<aw> linkedList = new LinkedList();
        if (jSONArray != null) {
            for (int i = 0; i < jSONArray.length(); i++) {
                try {
                    aw awVar = new aw();
                    JSONObject jSONObject = jSONArray.getJSONObject(i);
                    awVar.text = jSONObject.optString("text");
                    awVar.url = jSONObject.optString(SlookSmartClipMetaTag.TAG_TYPE_URL);
                    linkedList.add(awVar);
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.CardInfoParser", e, "", new Object[0]);
                }
            }
        }
        return linkedList;
    }

    private static oy B(JSONObject jSONObject) {
        ajn ajn = null;
        if (jSONObject == null) {
            x.e("MicroMsg.CardInfoParser", "parserThirdFiled json is null");
            return null;
        }
        oy oyVar = new oy();
        oyVar.title = jSONObject.optString("title");
        oyVar.kPC = jSONObject.optString("aux_title");
        oyVar.kPB = jSONObject.optString("sub_title");
        oyVar.url = jSONObject.optString(SlookSmartClipMetaTag.TAG_TYPE_URL);
        oyVar.vZQ = jSONObject.optLong("show_flag");
        oyVar.vZR = jSONObject.optString("primary_color");
        oyVar.vZS = jSONObject.optString("secondary_color");
        oyVar.pfi = jSONObject.optString("icon_url");
        JSONObject optJSONObject = jSONObject.optJSONObject("gifting_info");
        if (optJSONObject != null) {
            if (optJSONObject == null) {
                x.e("MicroMsg.CardInfoParser", "parserGiftInfo json is null");
            } else {
                x.d("MicroMsg.CardInfoParser", "parserGitfInfo:%s", optJSONObject);
                ajn = new ajn();
                ajn.vLy = o.bY(optJSONObject.optString("biz_uin"));
                ajn.vLz = optJSONObject.optString("order_id");
            }
            oyVar.weA = ajn;
        }
        oyVar.vYB = jSONObject.optString("app_brand_user_name");
        oyVar.vYC = jSONObject.optString("app_brand_pass");
        return oyVar;
    }

    private static ri C(JSONObject jSONObject) {
        if (jSONObject == null) {
            x.e("MicroMsg.CardInfoParser", "parserDetailStruct json is null");
            return null;
        }
        ri riVar = new ri();
        riVar.title = jSONObject.optString("title");
        riVar.url = jSONObject.optString(SlookSmartClipMetaTag.TAG_TYPE_URL);
        riVar.desc = jSONObject.optString("abstract");
        riVar.pkl = jSONObject.optString("detail");
        riVar.wgf = jSONObject.optString("ad_title");
        JSONArray optJSONArray = jSONObject.optJSONArray("icon_url_list");
        if (optJSONArray == null || optJSONArray.length() <= 0) {
            x.e("MicroMsg.CardInfoParser", "parserDetailStruct icon_url_list is null");
        } else {
            LinkedList linkedList = new LinkedList();
            for (int i = 0; i < optJSONArray.length(); i++) {
                Object obj = "";
                try {
                    obj = optJSONArray.getString(i);
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.CardInfoParser", e, "", new Object[0]);
                    x.e("MicroMsg.CardInfoParser", "getMessage:" + e.getMessage());
                }
                linkedList.add(obj);
            }
            riVar.wge = linkedList;
        }
        return riVar;
    }

    private static bom D(JSONObject jSONObject) {
        if (jSONObject == null) {
            x.e("MicroMsg.CardInfoParser", "parserUseCondition json is null");
            return null;
        }
        bom bom = new bom();
        bom.tag = jSONObject.optString("tag");
        bom.hdx = jSONObject.optString("color");
        return bom;
    }

    private static rj E(JSONObject jSONObject) {
        if (jSONObject == null) {
            x.e("MicroMsg.CardInfoParser", "parserDetailTable json is null");
            return null;
        }
        rj rjVar = new rj();
        rjVar.title = jSONObject.optString("title");
        rjVar.kPB = jSONObject.optString("sub_title");
        rjVar.wgg = jSONObject.optInt("show_num", 0);
        JSONArray optJSONArray = jSONObject.optJSONArray("rows");
        if (optJSONArray == null || optJSONArray.length() <= 0) {
            x.e("MicroMsg.CardInfoParser", "parserDetailTable jsonArray is  null");
            return rjVar;
        }
        try {
            rjVar.wgh = l(optJSONArray);
            return rjVar;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.CardInfoParser", e, "", new Object[0]);
            x.e("MicroMsg.CardInfoParser", e.getMessage());
            return rjVar;
        }
    }
}
