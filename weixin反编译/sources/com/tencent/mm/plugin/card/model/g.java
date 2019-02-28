package com.tencent.mm.plugin.card.model;

import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.f.b.ac;
import com.tencent.mm.protocal.c.km;
import com.tencent.mm.protocal.c.kq;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bj;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class g extends ac {
    protected static com.tencent.mm.sdk.e.c.a gKN;
    public String kQS = "";
    public String kQT = "";
    public String kQU;
    public String kQV;
    public String kQW;
    public boolean kQX = false;
    public km kQY;
    public kq kQZ;
    public List<a> kRa = null;
    public List<b> kRb = null;
    public int kRc = 0;
    public int kRd = 0;
    public boolean kRe;
    public List<c> kRf = null;

    public class a {
        public String cardId;
        public String kRg;
        public String kRh;
        public int kRi;
        public int kRj;
        public String title;
    }

    public class c {
        public String kRn;
    }

    public class b {
        public String description;
        public String kRl;
        public String kRm;
        public String title;
    }

    static {
        com.tencent.mm.sdk.e.c.a aVar = new com.tencent.mm.sdk.e.c.a();
        aVar.hUM = new Field[21];
        aVar.columns = new String[22];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "card_type";
        aVar.xrT.put("card_type", "INTEGER");
        stringBuilder.append(" card_type INTEGER");
        stringBuilder.append(", ");
        aVar.columns[1] = "title";
        aVar.xrT.put("title", "TEXT");
        stringBuilder.append(" title TEXT");
        stringBuilder.append(", ");
        aVar.columns[2] = "description";
        aVar.xrT.put("description", "TEXT");
        stringBuilder.append(" description TEXT");
        stringBuilder.append(", ");
        aVar.columns[3] = "logo_url";
        aVar.xrT.put("logo_url", "TEXT");
        stringBuilder.append(" logo_url TEXT");
        stringBuilder.append(", ");
        aVar.columns[4] = "time";
        aVar.xrT.put("time", "INTEGER");
        stringBuilder.append(" time INTEGER");
        stringBuilder.append(", ");
        aVar.columns[5] = "card_id";
        aVar.xrT.put("card_id", "TEXT");
        stringBuilder.append(" card_id TEXT");
        stringBuilder.append(", ");
        aVar.columns[6] = "card_tp_id";
        aVar.xrT.put("card_tp_id", "TEXT");
        stringBuilder.append(" card_tp_id TEXT");
        stringBuilder.append(", ");
        aVar.columns[7] = "msg_id";
        aVar.xrT.put("msg_id", "TEXT PRIMARY KEY ");
        stringBuilder.append(" msg_id TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.xrS = "msg_id";
        aVar.columns[8] = "msg_type";
        aVar.xrT.put("msg_type", "INTEGER");
        stringBuilder.append(" msg_type INTEGER");
        stringBuilder.append(", ");
        aVar.columns[9] = "jump_type";
        aVar.xrT.put("jump_type", "INTEGER");
        stringBuilder.append(" jump_type INTEGER");
        stringBuilder.append(", ");
        aVar.columns[10] = SlookSmartClipMetaTag.TAG_TYPE_URL;
        aVar.xrT.put(SlookSmartClipMetaTag.TAG_TYPE_URL, "TEXT");
        stringBuilder.append(" url TEXT");
        stringBuilder.append(", ");
        aVar.columns[11] = "buttonData";
        aVar.xrT.put("buttonData", "BLOB");
        stringBuilder.append(" buttonData BLOB");
        stringBuilder.append(", ");
        aVar.columns[12] = "operData";
        aVar.xrT.put("operData", "BLOB");
        stringBuilder.append(" operData BLOB");
        stringBuilder.append(", ");
        aVar.columns[13] = "report_scene";
        aVar.xrT.put("report_scene", "INTEGER");
        stringBuilder.append(" report_scene INTEGER");
        stringBuilder.append(", ");
        aVar.columns[14] = "read_state";
        aVar.xrT.put("read_state", "INTEGER default '0' ");
        stringBuilder.append(" read_state INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[15] = "accept_buttons";
        aVar.xrT.put("accept_buttons", "TEXT");
        stringBuilder.append(" accept_buttons TEXT");
        stringBuilder.append(", ");
        aVar.columns[16] = "consumed_box_id";
        aVar.xrT.put("consumed_box_id", "TEXT");
        stringBuilder.append(" consumed_box_id TEXT");
        stringBuilder.append(", ");
        aVar.columns[17] = "jump_buttons";
        aVar.xrT.put("jump_buttons", "TEXT");
        stringBuilder.append(" jump_buttons TEXT");
        stringBuilder.append(", ");
        aVar.columns[18] = "logo_color";
        aVar.xrT.put("logo_color", "TEXT");
        stringBuilder.append(" logo_color TEXT");
        stringBuilder.append(", ");
        aVar.columns[19] = "unavailable_qr_code_list";
        aVar.xrT.put("unavailable_qr_code_list", "TEXT");
        stringBuilder.append(" unavailable_qr_code_list TEXT");
        stringBuilder.append(", ");
        aVar.columns[20] = "all_unavailable";
        aVar.xrT.put("all_unavailable", "INTEGER default 'false' ");
        stringBuilder.append(" all_unavailable INTEGER default 'false' ");
        aVar.columns[21] = "rowid";
        aVar.xrU = stringBuilder.toString();
        gKN = aVar;
    }

    protected final com.tencent.mm.sdk.e.c.a Aj() {
        return gKN;
    }

    public final km auX() {
        if (this.kQY != null) {
            return this.kQY;
        }
        try {
            this.kQY = (km) new km().aH(this.field_buttonData);
            return this.kQY;
        } catch (Throwable e) {
            x.e("MicroMsg.CardMsgInfo", "getCardButton fail, ex = %s", e.getMessage());
            x.printErrStackTrace("MicroMsg.CardMsgInfo", e, "", new Object[0]);
            return new km();
        }
    }

    public final kq auY() {
        if (this.kQZ != null) {
            return this.kQZ;
        }
        try {
            this.kQZ = (kq) new kq().aH(this.field_operData);
            return this.kQZ;
        } catch (Throwable e) {
            x.e("MicroMsg.CardMsgInfo", "getOperationRegion fail, ex = %s", e.getMessage());
            x.printErrStackTrace("MicroMsg.CardMsgInfo", e, "", new Object[0]);
            return new kq();
        }
    }

    public final void auZ() {
        if (this.kRa == null) {
            this.kRa = new ArrayList();
            if (!bi.oN(this.field_accept_buttons)) {
                Map y = bj.y(this.field_accept_buttons, "accept_buttons_list");
                if (y != null) {
                    int i = 0;
                    while (i < 100) {
                        String str = ".accept_buttons_list.accept_buttons" + (i > 0 ? Integer.valueOf(i) : "");
                        String str2 = (String) y.get(str + ".title");
                        if (!bi.oN((String) y.get(str + ".card_id")) || !bi.oN(str2)) {
                            int i2 = bi.getInt((String) y.get(str + ".end_time"), 0);
                            if (i2 == 0 || ((long) i2) > bi.Wx()) {
                                a aVar = new a();
                                aVar.title = (String) y.get(str + ".title");
                                aVar.kRg = (String) y.get(str + ".sub_title");
                                aVar.kRh = (String) y.get(str + ".card_ext");
                                aVar.cardId = (String) y.get(str + ".card_id");
                                aVar.kRj = bi.getInt((String) y.get(str + ".action_type"), 0);
                                aVar.kRi = i2;
                                this.kRa.add(aVar);
                            }
                            i++;
                        } else {
                            return;
                        }
                    }
                }
            }
        }
    }

    public final void ava() {
        if (this.kRb == null) {
            this.kRb = new ArrayList();
            if (!bi.oN(this.field_jump_buttons)) {
                Map y = bj.y(this.field_jump_buttons, "jump_buttons_list");
                if (y != null) {
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 < 100) {
                            String str = ".jump_buttons_list.jump_buttons" + (i2 > 0 ? Integer.valueOf(i2) : "");
                            if (!bi.oN((String) y.get(str + ".title"))) {
                                b bVar = new b();
                                bVar.title = (String) y.get(str + ".title");
                                bVar.description = (String) y.get(str + ".description");
                                bVar.kRl = (String) y.get(str + ".button_wording");
                                bVar.kRm = (String) y.get(str + ".jump_url");
                                this.kRb.add(bVar);
                                i = i2 + 1;
                            } else {
                                return;
                            }
                        }
                        return;
                    }
                }
            }
        }
    }

    public final void avb() {
        if (this.kRf == null) {
            this.kRf = new ArrayList();
            if (!bi.oN(this.field_unavailable_qr_code_list)) {
                Map y = bj.y(this.field_unavailable_qr_code_list, "unavailable_qr_code_list");
                if (y != null) {
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 < 100) {
                            String str = ".unavailable_qr_code_list.unavailable_qr_codes" + (i2 > 0 ? Integer.valueOf(i2) : "");
                            if (!bi.oN((String) y.get(str + ".code_id"))) {
                                c cVar = new c();
                                cVar.kRn = (String) y.get(str + ".code_id");
                                this.kRf.add(cVar);
                                i = i2 + 1;
                            } else {
                                return;
                            }
                        }
                        return;
                    }
                }
            }
        }
    }
}
