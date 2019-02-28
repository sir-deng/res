package com.tencent.mm.f.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.sdk.e.c;

public abstract class ac extends c {
    public static final String[] fNF = new String[0];
    private static final int fNO = "rowid".hashCode();
    private static final int fRY = "title".hashCode();
    private static final int fRZ = "description".hashCode();
    private static final int fVa = "card_type".hashCode();
    private static final int fVb = "logo_url".hashCode();
    private static final int fVc = "time".hashCode();
    private static final int fVd = "card_id".hashCode();
    private static final int fVe = "card_tp_id".hashCode();
    private static final int fVf = "msg_id".hashCode();
    private static final int fVg = "msg_type".hashCode();
    private static final int fVh = "jump_type".hashCode();
    private static final int fVi = SlookSmartClipMetaTag.TAG_TYPE_URL.hashCode();
    private static final int fVj = "buttonData".hashCode();
    private static final int fVk = "operData".hashCode();
    private static final int fVl = "report_scene".hashCode();
    private static final int fVm = "read_state".hashCode();
    private static final int fVn = "accept_buttons".hashCode();
    private static final int fVo = "consumed_box_id".hashCode();
    private static final int fVp = "jump_buttons".hashCode();
    private static final int fVq = "logo_color".hashCode();
    private static final int fVr = "unavailable_qr_code_list".hashCode();
    private static final int fVs = "all_unavailable".hashCode();
    private boolean fRU = true;
    private boolean fRV = true;
    private boolean fUH = true;
    private boolean fUI = true;
    private boolean fUJ = true;
    private boolean fUK = true;
    private boolean fUL = true;
    private boolean fUM = true;
    private boolean fUN = true;
    private boolean fUO = true;
    private boolean fUP = true;
    private boolean fUQ = true;
    private boolean fUR = true;
    private boolean fUS = true;
    private boolean fUT = true;
    private boolean fUU = true;
    private boolean fUV = true;
    private boolean fUW = true;
    private boolean fUX = true;
    private boolean fUY = true;
    private boolean fUZ = true;
    public String field_accept_buttons;
    public boolean field_all_unavailable;
    public byte[] field_buttonData;
    public String field_card_id;
    public String field_card_tp_id;
    public int field_card_type;
    public String field_consumed_box_id;
    public String field_description;
    public String field_jump_buttons;
    public int field_jump_type;
    public String field_logo_color;
    public String field_logo_url;
    public String field_msg_id;
    public int field_msg_type;
    public byte[] field_operData;
    public int field_read_state;
    public int field_report_scene;
    public int field_time;
    public String field_title;
    public String field_unavailable_qr_code_list;
    public String field_url;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (fVa == hashCode) {
                    this.field_card_type = cursor.getInt(i);
                } else if (fRY == hashCode) {
                    this.field_title = cursor.getString(i);
                } else if (fRZ == hashCode) {
                    this.field_description = cursor.getString(i);
                } else if (fVb == hashCode) {
                    this.field_logo_url = cursor.getString(i);
                } else if (fVc == hashCode) {
                    this.field_time = cursor.getInt(i);
                } else if (fVd == hashCode) {
                    this.field_card_id = cursor.getString(i);
                } else if (fVe == hashCode) {
                    this.field_card_tp_id = cursor.getString(i);
                } else if (fVf == hashCode) {
                    this.field_msg_id = cursor.getString(i);
                    this.fUM = true;
                } else if (fVg == hashCode) {
                    this.field_msg_type = cursor.getInt(i);
                } else if (fVh == hashCode) {
                    this.field_jump_type = cursor.getInt(i);
                } else if (fVi == hashCode) {
                    this.field_url = cursor.getString(i);
                } else if (fVj == hashCode) {
                    this.field_buttonData = cursor.getBlob(i);
                } else if (fVk == hashCode) {
                    this.field_operData = cursor.getBlob(i);
                } else if (fVl == hashCode) {
                    this.field_report_scene = cursor.getInt(i);
                } else if (fVm == hashCode) {
                    this.field_read_state = cursor.getInt(i);
                } else if (fVn == hashCode) {
                    this.field_accept_buttons = cursor.getString(i);
                } else if (fVo == hashCode) {
                    this.field_consumed_box_id = cursor.getString(i);
                } else if (fVp == hashCode) {
                    this.field_jump_buttons = cursor.getString(i);
                } else if (fVq == hashCode) {
                    this.field_logo_color = cursor.getString(i);
                } else if (fVr == hashCode) {
                    this.field_unavailable_qr_code_list = cursor.getString(i);
                } else if (fVs == hashCode) {
                    this.field_all_unavailable = cursor.getInt(i) != 0;
                } else if (fNO == hashCode) {
                    this.xrR = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues vP() {
        ContentValues contentValues = new ContentValues();
        if (this.fUH) {
            contentValues.put("card_type", Integer.valueOf(this.field_card_type));
        }
        if (this.fRU) {
            contentValues.put("title", this.field_title);
        }
        if (this.fRV) {
            contentValues.put("description", this.field_description);
        }
        if (this.fUI) {
            contentValues.put("logo_url", this.field_logo_url);
        }
        if (this.fUJ) {
            contentValues.put("time", Integer.valueOf(this.field_time));
        }
        if (this.fUK) {
            contentValues.put("card_id", this.field_card_id);
        }
        if (this.fUL) {
            contentValues.put("card_tp_id", this.field_card_tp_id);
        }
        if (this.fUM) {
            contentValues.put("msg_id", this.field_msg_id);
        }
        if (this.fUN) {
            contentValues.put("msg_type", Integer.valueOf(this.field_msg_type));
        }
        if (this.fUO) {
            contentValues.put("jump_type", Integer.valueOf(this.field_jump_type));
        }
        if (this.fUP) {
            contentValues.put(SlookSmartClipMetaTag.TAG_TYPE_URL, this.field_url);
        }
        if (this.fUQ) {
            contentValues.put("buttonData", this.field_buttonData);
        }
        if (this.fUR) {
            contentValues.put("operData", this.field_operData);
        }
        if (this.fUS) {
            contentValues.put("report_scene", Integer.valueOf(this.field_report_scene));
        }
        if (this.fUT) {
            contentValues.put("read_state", Integer.valueOf(this.field_read_state));
        }
        if (this.fUU) {
            contentValues.put("accept_buttons", this.field_accept_buttons);
        }
        if (this.fUV) {
            contentValues.put("consumed_box_id", this.field_consumed_box_id);
        }
        if (this.fUW) {
            contentValues.put("jump_buttons", this.field_jump_buttons);
        }
        if (this.fUX) {
            contentValues.put("logo_color", this.field_logo_color);
        }
        if (this.fUY) {
            contentValues.put("unavailable_qr_code_list", this.field_unavailable_qr_code_list);
        }
        if (this.fUZ) {
            contentValues.put("all_unavailable", Boolean.valueOf(this.field_all_unavailable));
        }
        if (this.xrR > 0) {
            contentValues.put("rowid", Long.valueOf(this.xrR));
        }
        return contentValues;
    }
}
