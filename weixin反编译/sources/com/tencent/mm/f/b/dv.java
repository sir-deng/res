package com.tencent.mm.f.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;

public abstract class dv extends c {
    public static final String[] fNF = new String[]{"CREATE INDEX IF NOT EXISTS UserCardInfo_card_type_index ON UserCardInfo(card_type)"};
    private static final int fNO = "rowid".hashCode();
    private static final int fNU = DownloadInfo.STATUS.hashCode();
    private static final int fQa = "updateTime".hashCode();
    private static final int fVa = "card_type".hashCode();
    private static final int fVd = "card_id".hashCode();
    private static final int fVe = "card_tp_id".hashCode();
    private static final int gcy = "updateSeq".hashCode();
    private static final int gqo = "from_username".hashCode();
    private static final int gqr = "local_updateTime".hashCode();
    private static final int gqs = "begin_time".hashCode();
    private static final int gqt = "end_time".hashCode();
    private static final int gqu = "block_mask".hashCode();
    private static final int gqv = "dataInfoData".hashCode();
    private static final int gqw = "cardTpInfoData".hashCode();
    private static final int gqx = "shareInfoData".hashCode();
    private static final int gqy = "shopInfoData".hashCode();
    private static final int gsC = "delete_state_flag".hashCode();
    private static final int gsD = "create_time".hashCode();
    private static final int gsE = "stickyIndex".hashCode();
    private static final int gsF = "stickyEndTime".hashCode();
    private static final int gsG = "stickyAnnouncement".hashCode();
    private static final int gsH = "label_wording".hashCode();
    private static final int gsI = "is_dynamic".hashCode();
    private boolean fNR = true;
    private boolean fPY = true;
    private boolean fUH = true;
    private boolean fUK = true;
    private boolean fUL = true;
    public long field_begin_time;
    public String field_block_mask;
    public byte[] field_cardTpInfoData;
    public String field_card_id;
    public String field_card_tp_id;
    public int field_card_type;
    public long field_create_time;
    public byte[] field_dataInfoData;
    public int field_delete_state_flag;
    public long field_end_time;
    public String field_from_username;
    public boolean field_is_dynamic;
    public String field_label_wording;
    public long field_local_updateTime;
    public byte[] field_shareInfoData;
    public byte[] field_shopInfoData;
    public int field_status;
    public String field_stickyAnnouncement;
    public int field_stickyEndTime;
    public int field_stickyIndex;
    public long field_updateSeq;
    public long field_updateTime;
    private boolean gck = true;
    private boolean gqb = true;
    private boolean gqe = true;
    private boolean gqf = true;
    private boolean gqg = true;
    private boolean gqh = true;
    private boolean gqi = true;
    private boolean gqj = true;
    private boolean gqk = true;
    private boolean gql = true;
    private boolean gsA = true;
    private boolean gsB = true;
    private boolean gsv = true;
    private boolean gsw = true;
    private boolean gsx = true;
    private boolean gsy = true;
    private boolean gsz = true;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (fVd == hashCode) {
                    this.field_card_id = cursor.getString(i);
                    this.fUK = true;
                } else if (fVe == hashCode) {
                    this.field_card_tp_id = cursor.getString(i);
                } else if (gqo == hashCode) {
                    this.field_from_username = cursor.getString(i);
                } else if (fNU == hashCode) {
                    this.field_status = cursor.getInt(i);
                } else if (gsC == hashCode) {
                    this.field_delete_state_flag = cursor.getInt(i);
                } else if (gqr == hashCode) {
                    this.field_local_updateTime = cursor.getLong(i);
                } else if (fQa == hashCode) {
                    this.field_updateTime = cursor.getLong(i);
                } else if (gcy == hashCode) {
                    this.field_updateSeq = cursor.getLong(i);
                } else if (gsD == hashCode) {
                    this.field_create_time = cursor.getLong(i);
                } else if (gqs == hashCode) {
                    this.field_begin_time = cursor.getLong(i);
                } else if (gqt == hashCode) {
                    this.field_end_time = cursor.getLong(i);
                } else if (gqu == hashCode) {
                    this.field_block_mask = cursor.getString(i);
                } else if (gqv == hashCode) {
                    this.field_dataInfoData = cursor.getBlob(i);
                } else if (gqw == hashCode) {
                    this.field_cardTpInfoData = cursor.getBlob(i);
                } else if (gqx == hashCode) {
                    this.field_shareInfoData = cursor.getBlob(i);
                } else if (gqy == hashCode) {
                    this.field_shopInfoData = cursor.getBlob(i);
                } else if (gsE == hashCode) {
                    this.field_stickyIndex = cursor.getInt(i);
                } else if (gsF == hashCode) {
                    this.field_stickyEndTime = cursor.getInt(i);
                } else if (gsG == hashCode) {
                    this.field_stickyAnnouncement = cursor.getString(i);
                } else if (fVa == hashCode) {
                    this.field_card_type = cursor.getInt(i);
                } else if (gsH == hashCode) {
                    this.field_label_wording = cursor.getString(i);
                } else if (gsI == hashCode) {
                    this.field_is_dynamic = cursor.getInt(i) != 0;
                } else if (fNO == hashCode) {
                    this.xrR = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues vP() {
        ContentValues contentValues = new ContentValues();
        if (this.fUK) {
            contentValues.put("card_id", this.field_card_id);
        }
        if (this.fUL) {
            contentValues.put("card_tp_id", this.field_card_tp_id);
        }
        if (this.gqb) {
            contentValues.put("from_username", this.field_from_username);
        }
        if (this.fNR) {
            contentValues.put(DownloadInfo.STATUS, Integer.valueOf(this.field_status));
        }
        if (this.gsv) {
            contentValues.put("delete_state_flag", Integer.valueOf(this.field_delete_state_flag));
        }
        if (this.gqe) {
            contentValues.put("local_updateTime", Long.valueOf(this.field_local_updateTime));
        }
        if (this.fPY) {
            contentValues.put("updateTime", Long.valueOf(this.field_updateTime));
        }
        if (this.gck) {
            contentValues.put("updateSeq", Long.valueOf(this.field_updateSeq));
        }
        if (this.gsw) {
            contentValues.put("create_time", Long.valueOf(this.field_create_time));
        }
        if (this.gqf) {
            contentValues.put("begin_time", Long.valueOf(this.field_begin_time));
        }
        if (this.gqg) {
            contentValues.put("end_time", Long.valueOf(this.field_end_time));
        }
        if (this.gqh) {
            contentValues.put("block_mask", this.field_block_mask);
        }
        if (this.gqi) {
            contentValues.put("dataInfoData", this.field_dataInfoData);
        }
        if (this.gqj) {
            contentValues.put("cardTpInfoData", this.field_cardTpInfoData);
        }
        if (this.gqk) {
            contentValues.put("shareInfoData", this.field_shareInfoData);
        }
        if (this.gql) {
            contentValues.put("shopInfoData", this.field_shopInfoData);
        }
        if (this.gsx) {
            contentValues.put("stickyIndex", Integer.valueOf(this.field_stickyIndex));
        }
        if (this.gsy) {
            contentValues.put("stickyEndTime", Integer.valueOf(this.field_stickyEndTime));
        }
        if (this.gsz) {
            contentValues.put("stickyAnnouncement", this.field_stickyAnnouncement);
        }
        if (this.fUH) {
            contentValues.put("card_type", Integer.valueOf(this.field_card_type));
        }
        if (this.gsA) {
            contentValues.put("label_wording", this.field_label_wording);
        }
        if (this.gsB) {
            contentValues.put("is_dynamic", Boolean.valueOf(this.field_is_dynamic));
        }
        if (this.xrR > 0) {
            contentValues.put("rowid", Long.valueOf(this.xrR));
        }
        return contentValues;
    }
}
