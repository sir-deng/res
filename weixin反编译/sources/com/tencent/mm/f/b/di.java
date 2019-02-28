package com.tencent.mm.f.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;

public abstract class di extends c {
    public static final String[] fNF = new String[]{"CREATE INDEX IF NOT EXISTS ShareCardInfo_card_tp_id_index ON ShareCardInfo(card_tp_id)"};
    private static final int fNO = "rowid".hashCode();
    private static final int fNU = DownloadInfo.STATUS.hashCode();
    private static final int fQa = "updateTime".hashCode();
    private static final int fVd = "card_id".hashCode();
    private static final int fVe = "card_tp_id".hashCode();
    private static final int gas = "app_id".hashCode();
    private static final int gcy = "updateSeq".hashCode();
    private static final int gqA = "itemIndex".hashCode();
    private static final int gqo = "from_username".hashCode();
    private static final int gqp = "consumer".hashCode();
    private static final int gqq = "share_time".hashCode();
    private static final int gqr = "local_updateTime".hashCode();
    private static final int gqs = "begin_time".hashCode();
    private static final int gqt = "end_time".hashCode();
    private static final int gqu = "block_mask".hashCode();
    private static final int gqv = "dataInfoData".hashCode();
    private static final int gqw = "cardTpInfoData".hashCode();
    private static final int gqx = "shareInfoData".hashCode();
    private static final int gqy = "shopInfoData".hashCode();
    private static final int gqz = "categoryType".hashCode();
    private boolean fNR = true;
    private boolean fPY = true;
    private boolean fUK = true;
    private boolean fUL = true;
    private boolean fZT = true;
    public String field_app_id;
    public long field_begin_time;
    public long field_block_mask;
    public byte[] field_cardTpInfoData;
    public String field_card_id;
    public String field_card_tp_id;
    public int field_categoryType;
    public String field_consumer;
    public byte[] field_dataInfoData;
    public long field_end_time;
    public String field_from_username;
    public int field_itemIndex;
    public long field_local_updateTime;
    public byte[] field_shareInfoData;
    public long field_share_time;
    public byte[] field_shopInfoData;
    public int field_status;
    public long field_updateSeq;
    public long field_updateTime;
    private boolean gck = true;
    private boolean gqb = true;
    private boolean gqc = true;
    private boolean gqd = true;
    private boolean gqe = true;
    private boolean gqf = true;
    private boolean gqg = true;
    private boolean gqh = true;
    private boolean gqi = true;
    private boolean gqj = true;
    private boolean gqk = true;
    private boolean gql = true;
    private boolean gqm = true;
    private boolean gqn = true;

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
                } else if (gqp == hashCode) {
                    this.field_consumer = cursor.getString(i);
                } else if (gas == hashCode) {
                    this.field_app_id = cursor.getString(i);
                } else if (fNU == hashCode) {
                    this.field_status = cursor.getInt(i);
                } else if (gqq == hashCode) {
                    this.field_share_time = cursor.getLong(i);
                } else if (gqr == hashCode) {
                    this.field_local_updateTime = cursor.getLong(i);
                } else if (fQa == hashCode) {
                    this.field_updateTime = cursor.getLong(i);
                } else if (gqs == hashCode) {
                    this.field_begin_time = cursor.getLong(i);
                } else if (gqt == hashCode) {
                    this.field_end_time = cursor.getLong(i);
                } else if (gcy == hashCode) {
                    this.field_updateSeq = cursor.getLong(i);
                } else if (gqu == hashCode) {
                    this.field_block_mask = cursor.getLong(i);
                } else if (gqv == hashCode) {
                    this.field_dataInfoData = cursor.getBlob(i);
                } else if (gqw == hashCode) {
                    this.field_cardTpInfoData = cursor.getBlob(i);
                } else if (gqx == hashCode) {
                    this.field_shareInfoData = cursor.getBlob(i);
                } else if (gqy == hashCode) {
                    this.field_shopInfoData = cursor.getBlob(i);
                } else if (gqz == hashCode) {
                    this.field_categoryType = cursor.getInt(i);
                } else if (gqA == hashCode) {
                    this.field_itemIndex = cursor.getInt(i);
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
        if (this.gqc) {
            contentValues.put("consumer", this.field_consumer);
        }
        if (this.fZT) {
            contentValues.put("app_id", this.field_app_id);
        }
        if (this.fNR) {
            contentValues.put(DownloadInfo.STATUS, Integer.valueOf(this.field_status));
        }
        if (this.gqd) {
            contentValues.put("share_time", Long.valueOf(this.field_share_time));
        }
        if (this.gqe) {
            contentValues.put("local_updateTime", Long.valueOf(this.field_local_updateTime));
        }
        if (this.fPY) {
            contentValues.put("updateTime", Long.valueOf(this.field_updateTime));
        }
        if (this.gqf) {
            contentValues.put("begin_time", Long.valueOf(this.field_begin_time));
        }
        if (this.gqg) {
            contentValues.put("end_time", Long.valueOf(this.field_end_time));
        }
        if (this.gck) {
            contentValues.put("updateSeq", Long.valueOf(this.field_updateSeq));
        }
        if (this.gqh) {
            contentValues.put("block_mask", Long.valueOf(this.field_block_mask));
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
        if (this.gqm) {
            contentValues.put("categoryType", Integer.valueOf(this.field_categoryType));
        }
        if (this.gqn) {
            contentValues.put("itemIndex", Integer.valueOf(this.field_itemIndex));
        }
        if (this.xrR > 0) {
            contentValues.put("rowid", Long.valueOf(this.xrR));
        }
        return contentValues;
    }
}
