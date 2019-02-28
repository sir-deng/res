package com.tencent.mm.plugin.card.a;

import android.database.Cursor;
import android.text.TextUtils;
import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.model.g;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.as;
import com.tencent.mm.y.c;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class l {
    private List<WeakReference<a>> kOg = new ArrayList();
    public List<g> kPq = new ArrayList();
    public int kPr = 0;

    public interface a {
        void a(g gVar);

        void asP();
    }

    public l() {
        loadFromDB();
        as.Hm();
        Object obj = c.Db().get(139268, null);
        this.kPr = obj == null ? 0 : ((Integer) obj).intValue();
    }

    public final void a(g gVar) {
        if (this.kOg != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.kOg.size()) {
                    WeakReference weakReference = (WeakReference) this.kOg.get(i2);
                    if (weakReference != null) {
                        a aVar = (a) weakReference.get();
                        if (aVar != null) {
                            aVar.a(gVar);
                        }
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public final void asP() {
        if (this.kOg != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.kOg.size()) {
                    WeakReference weakReference = (WeakReference) this.kOg.get(i2);
                    if (weakReference != null) {
                        a aVar = (a) weakReference.get();
                        if (aVar != null) {
                            aVar.asP();
                        }
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public final void a(a aVar) {
        if (this.kOg == null) {
            this.kOg = new ArrayList();
        }
        if (aVar != null) {
            this.kOg.add(new WeakReference(aVar));
        }
    }

    public final void b(a aVar) {
        if (this.kOg != null && aVar != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.kOg.size()) {
                    WeakReference weakReference = (WeakReference) this.kOg.get(i2);
                    if (weakReference != null) {
                        a aVar2 = (a) weakReference.get();
                        if (aVar2 != null && aVar2.equals(aVar)) {
                            this.kOg.remove(weakReference);
                            return;
                        }
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public static void c(g gVar) {
        if (!am.avj().b((com.tencent.mm.sdk.e.c) gVar)) {
            x.e("MicroMsg.CardMsgManager", "insert CardMsgInfo failed! id:" + gVar.field_msg_id);
        }
    }

    private void loadFromDB() {
        Cursor Tq = am.avj().Tq();
        if (Tq != null && Tq.getCount() > 0) {
            Tq.moveToFirst();
            int columnIndex = Tq.getColumnIndex("card_type");
            int columnIndex2 = Tq.getColumnIndex("title");
            int columnIndex3 = Tq.getColumnIndex("description");
            int columnIndex4 = Tq.getColumnIndex("logo_url");
            int columnIndex5 = Tq.getColumnIndex("time");
            int columnIndex6 = Tq.getColumnIndex("card_id");
            int columnIndex7 = Tq.getColumnIndex("card_tp_id");
            int columnIndex8 = Tq.getColumnIndex("msg_id");
            int columnIndex9 = Tq.getColumnIndex("msg_type");
            int columnIndex10 = Tq.getColumnIndex("jump_type");
            int columnIndex11 = Tq.getColumnIndex(SlookSmartClipMetaTag.TAG_TYPE_URL);
            int columnIndex12 = Tq.getColumnIndex("buttonData");
            int columnIndex13 = Tq.getColumnIndex("operData");
            int columnIndex14 = Tq.getColumnIndex("report_scene");
            int columnIndex15 = Tq.getColumnIndex("read_state");
            while (!Tq.isAfterLast()) {
                g gVar = new g();
                gVar.field_card_type = Tq.getInt(columnIndex);
                gVar.field_title = Tq.getString(columnIndex2);
                gVar.field_description = Tq.getString(columnIndex3);
                gVar.field_logo_url = Tq.getString(columnIndex4);
                gVar.field_time = Tq.getInt(columnIndex5);
                gVar.field_card_id = Tq.getString(columnIndex6);
                gVar.field_card_tp_id = Tq.getString(columnIndex7);
                gVar.field_msg_id = Tq.getString(columnIndex8);
                gVar.field_msg_type = Tq.getInt(columnIndex9);
                gVar.field_jump_type = Tq.getInt(columnIndex10);
                gVar.field_url = Tq.getString(columnIndex11);
                gVar.field_buttonData = Tq.getBlob(columnIndex12);
                gVar.field_operData = Tq.getBlob(columnIndex13);
                gVar.field_report_scene = Tq.getInt(columnIndex14);
                gVar.field_read_state = Tq.getInt(columnIndex15);
                Tq.moveToNext();
                this.kPq.add(gVar);
            }
        }
        if (Tq != null) {
            Tq.close();
        }
    }

    public static String h(Map<String, String> map, String str) {
        StringBuilder stringBuilder = new StringBuilder();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= 100) {
                break;
            }
            String str2 = str + ".jump_buttons" + (i2 > 0 ? Integer.valueOf(i2) : "");
            if (bi.oN((String) map.get(str2 + ".title"))) {
                break;
            }
            stringBuilder.append("<jump_buttons>");
            stringBuilder.append("<title>" + bi.Wm(bi.oM((String) map.get(str2 + ".title"))) + "</title>");
            stringBuilder.append("<description>" + bi.Wm(bi.oM((String) map.get(str2 + ".description"))) + "</description>");
            stringBuilder.append("<button_wording>" + bi.Wm(bi.oM((String) map.get(str2 + ".button_wording"))) + "</button_wording>");
            stringBuilder.append("<jump_url>" + bi.Wm(bi.oM((String) map.get(str2 + ".jump_url"))) + "</jump_url>");
            stringBuilder.append("</jump_buttons>");
            i = i2 + 1;
        }
        StringBuilder stringBuilder2 = new StringBuilder();
        if (!bi.oN(stringBuilder.toString())) {
            stringBuilder2.append("<jump_buttons_list>");
            stringBuilder2.append(stringBuilder.toString());
            stringBuilder2.append("</jump_buttons_list>");
        }
        return stringBuilder2.toString();
    }

    public static String i(Map<String, String> map, String str) {
        StringBuilder stringBuilder = new StringBuilder();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= 100) {
                break;
            }
            String str2 = str + ".accept_buttons" + (i2 > 0 ? Integer.valueOf(i2) : "");
            String str3 = (String) map.get(str2 + ".title");
            if (bi.oN((String) map.get(str2 + ".card_id")) && bi.oN(str3)) {
                break;
            }
            stringBuilder.append("<accept_buttons>");
            stringBuilder.append("<title>" + bi.Wm(bi.oM((String) map.get(str2 + ".title"))) + "</title>");
            stringBuilder.append("<sub_title>" + bi.Wm(bi.oM((String) map.get(str2 + ".sub_title"))) + "</sub_title>");
            stringBuilder.append("<card_id>" + bi.Wm(bi.oM((String) map.get(str2 + ".card_id"))) + "</card_id>");
            stringBuilder.append("<card_ext>" + bi.Wm(bi.oM((String) map.get(str2 + ".card_ext"))) + "</card_ext>");
            stringBuilder.append("<end_time>" + bi.Wm(bi.oM((String) map.get(str2 + ".end_time"))) + "</end_time>");
            stringBuilder.append("<action_type>" + bi.Wm(bi.oM((String) map.get(str2 + ".action_type"))) + "</action_type>");
            stringBuilder.append("</accept_buttons>");
            i = i2 + 1;
        }
        StringBuilder stringBuilder2 = new StringBuilder();
        if (!bi.oN(stringBuilder.toString())) {
            stringBuilder2.append("<accept_buttons_list>");
            stringBuilder2.append(stringBuilder.toString());
            stringBuilder2.append("</accept_buttons_list>");
        }
        return stringBuilder2.toString();
    }

    public static String j(Map<String, String> map, String str) {
        StringBuilder stringBuilder = new StringBuilder();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= 100) {
                break;
            }
            String str2 = str + ".unavailable_qr_code_list" + (i2 > 0 ? Integer.valueOf(i2) : "");
            if (bi.oN((String) map.get(str2 + ".code_id"))) {
                break;
            }
            stringBuilder.append("<unavailable_qr_codes>");
            stringBuilder.append("<code_id>" + bi.Wm(bi.oM((String) map.get(str2 + ".code_id"))) + "</code_id>");
            stringBuilder.append("</unavailable_qr_codes>");
            i = i2 + 1;
        }
        StringBuilder stringBuilder2 = new StringBuilder();
        if (!bi.oN(stringBuilder.toString())) {
            stringBuilder2.append("<unavailable_qr_code_list>");
            stringBuilder2.append(stringBuilder.toString());
            stringBuilder2.append("</unavailable_qr_code_list>");
        }
        return stringBuilder2.toString();
    }

    public final boolean wH(String str) {
        if (this.kPq == null || TextUtils.isEmpty(str)) {
            return false;
        }
        for (int i = 0; i < this.kPq.size(); i++) {
            g gVar = (g) this.kPq.get(i);
            if (gVar != null && gVar.field_msg_id != null && gVar.field_msg_id.equals(str)) {
                return true;
            }
        }
        return false;
    }

    public final boolean wI(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        g gVar;
        if (this.kPq == null || TextUtils.isEmpty(str)) {
            gVar = null;
        } else {
            for (int i = 0; i < this.kPq.size(); i++) {
                gVar = (g) this.kPq.get(i);
                if (str.equals(gVar.field_msg_id)) {
                    break;
                }
            }
            gVar = null;
        }
        if (gVar == null) {
            return false;
        }
        this.kPq.remove(gVar);
        d(gVar);
        return true;
    }

    public static boolean d(g gVar) {
        boolean z = false;
        if (gVar != null) {
            z = am.avj().a((com.tencent.mm.sdk.e.c) gVar, new String[0]);
            if (!z) {
                x.e("MicroMsg.CardMsgManager", "delete CardMsgInfo failed! id:" + gVar.field_msg_id);
            }
        }
        return z;
    }

    public final void auU() {
        this.kPr = 0;
        as.Hm();
        c.Db().set(139268, Integer.valueOf(this.kPr));
    }

    public static void auV() {
        x.i("MicroMsg.CardMsgManager", "clearRedDotAndWording()");
        e.post(new Runnable() {
            public final void run() {
                x.i("MicroMsg.CardMsgManager", "begin to clearRedDotAndWording()");
                as.Hm();
                c.Db().a(com.tencent.mm.storage.w.a.USERINFO_CARD_REDOT_WORDING_STRING_SYNC, (Object) "");
                as.Hm();
                c.Db().a(com.tencent.mm.storage.w.a.USERINFO_CARD_GET_LAYOUT_SCENE_INT_SYNC, Integer.valueOf(0));
                as.Hm();
                c.Db().a(com.tencent.mm.storage.w.a.USERINFO_CARD_REDOT_ICON_URL_STRING_SYNC, (Object) "");
                as.Hm();
                c.Db().a(com.tencent.mm.storage.w.a.USERINFO_CARD_MSG_TIPS_TITLE_STRING_SYNC, (Object) "");
                as.Hm();
                c.Db().a(com.tencent.mm.storage.w.a.USERINFO_CARD_MSG_TIPS_ICON_URL_STRING_SYNC, (Object) "");
                as.Hm();
                c.Db().a(com.tencent.mm.storage.w.a.USERINFO_CARD_MSG_CARD_ID_STRING_SYNC, (Object) "");
                as.Hm();
                c.Db().a(com.tencent.mm.storage.w.a.USERINFO_CARD_MSG_NEED_CHECK_BOOLEAN_SYNC, Boolean.valueOf(false));
                if (com.tencent.mm.r.c.Bx().aR(262152, 266256)) {
                    com.tencent.mm.r.c.Bx().p(262152, false);
                }
                if (com.tencent.mm.r.c.Bx().aQ(262152, 266256)) {
                    com.tencent.mm.r.c.Bx().o(262152, false);
                }
                if (com.tencent.mm.r.c.Bx().a(com.tencent.mm.storage.w.a.NEW_BANDAGE_DATASOURCE_NEW_CARD_REDDOT_WORDING_STRING_SYNC, com.tencent.mm.storage.w.a.NEW_BANDAGE_WATCHER_SETTING_CARD_ENTRY_REDDOT_WORDING_STRING_SYNC)) {
                    com.tencent.mm.r.c.Bx().a(com.tencent.mm.storage.w.a.NEW_BANDAGE_DATASOURCE_NEW_CARD_REDDOT_WORDING_STRING_SYNC, false);
                }
                if (com.tencent.mm.r.c.Bx().a(com.tencent.mm.storage.w.a.NEW_BANDAGE_DATASOURCE_NEW_CARD_ICON_STRING_SYNC, com.tencent.mm.storage.w.a.NEW_BANDAGE_WATCHER_SETTING_CARD_ENTRY_ICON_STRING_SYNC)) {
                    com.tencent.mm.r.c.Bx().a(com.tencent.mm.storage.w.a.NEW_BANDAGE_DATASOURCE_NEW_CARD_ICON_STRING_SYNC, false);
                }
                x.i("MicroMsg.CardMsgManager", "end to clearRedDotAndWording()");
            }
        }, "clearRedDotAndWording");
    }
}
