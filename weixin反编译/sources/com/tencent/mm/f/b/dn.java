package com.tencent.mm.f.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;
import com.tencent.tmassistantsdk.storage.table.ClientInfoTable;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;

public abstract class dn extends c {
    public static final String[] fNF = new String[]{"CREATE INDEX IF NOT EXISTS SnsComment_snsID_index ON SnsComment(snsID)", "CREATE INDEX IF NOT EXISTS SnsComment_parentID_index ON SnsComment(parentID)", "CREATE INDEX IF NOT EXISTS SnsComment_isRead_index ON SnsComment(isRead)", "CREATE INDEX IF NOT EXISTS SnsComment_isSend_index ON SnsComment(isSend)"};
    private static final int fNO = "rowid".hashCode();
    private static final int fOS = "createTime".hashCode();
    private static final int fOV = Columns.TYPE.hashCode();
    private static final int fSM = "isSend".hashCode();
    private static final int gbv = "talker".hashCode();
    private static final int gfk = "isRead".hashCode();
    private static final int grn = "snsID".hashCode();
    private static final int gro = "parentID".hashCode();
    private static final int grp = "curActionBuf".hashCode();
    private static final int grq = "refActionBuf".hashCode();
    private static final int grr = "commentSvrID".hashCode();
    private static final int grs = ClientInfoTable.Columns.CLIENTID.hashCode();
    private static final int grt = "commentflag".hashCode();
    private static final int gru = "isSilence".hashCode();
    private boolean fOw = true;
    private boolean fOz = true;
    private boolean fSy = true;
    public String field_clientId;
    public long field_commentSvrID;
    public int field_commentflag;
    public int field_createTime;
    public byte[] field_curActionBuf;
    public short field_isRead;
    public boolean field_isSend;
    public int field_isSilence;
    public long field_parentID;
    public byte[] field_refActionBuf;
    public long field_snsID;
    public String field_talker;
    public int field_type;
    private boolean gbf = true;
    private boolean gfb = true;
    private boolean grf = true;
    private boolean grg = true;
    private boolean grh = true;
    private boolean gri = true;
    private boolean grj = true;
    private boolean grk = true;
    private boolean grl = true;
    private boolean grm = true;

    public void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (grn == hashCode) {
                    this.field_snsID = cursor.getLong(i);
                } else if (gro == hashCode) {
                    this.field_parentID = cursor.getLong(i);
                } else if (gfk == hashCode) {
                    this.field_isRead = cursor.getShort(i);
                } else if (fOS == hashCode) {
                    this.field_createTime = cursor.getInt(i);
                } else if (gbv == hashCode) {
                    this.field_talker = cursor.getString(i);
                } else if (fOV == hashCode) {
                    this.field_type = cursor.getInt(i);
                } else if (fSM == hashCode) {
                    this.field_isSend = cursor.getInt(i) != 0;
                } else if (grp == hashCode) {
                    this.field_curActionBuf = cursor.getBlob(i);
                } else if (grq == hashCode) {
                    this.field_refActionBuf = cursor.getBlob(i);
                } else if (grr == hashCode) {
                    this.field_commentSvrID = cursor.getLong(i);
                } else if (grs == hashCode) {
                    this.field_clientId = cursor.getString(i);
                } else if (grt == hashCode) {
                    this.field_commentflag = cursor.getInt(i);
                } else if (gru == hashCode) {
                    this.field_isSilence = cursor.getInt(i);
                } else if (fNO == hashCode) {
                    this.xrR = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues vP() {
        ContentValues contentValues = new ContentValues();
        if (this.grf) {
            contentValues.put("snsID", Long.valueOf(this.field_snsID));
        }
        if (this.grg) {
            contentValues.put("parentID", Long.valueOf(this.field_parentID));
        }
        if (this.gfb) {
            contentValues.put("isRead", Short.valueOf(this.field_isRead));
        }
        if (this.fOw) {
            contentValues.put("createTime", Integer.valueOf(this.field_createTime));
        }
        if (this.gbf) {
            contentValues.put("talker", this.field_talker);
        }
        if (this.fOz) {
            contentValues.put(Columns.TYPE, Integer.valueOf(this.field_type));
        }
        if (this.fSy) {
            contentValues.put("isSend", Boolean.valueOf(this.field_isSend));
        }
        if (this.grh) {
            contentValues.put("curActionBuf", this.field_curActionBuf);
        }
        if (this.gri) {
            contentValues.put("refActionBuf", this.field_refActionBuf);
        }
        if (this.grj) {
            contentValues.put("commentSvrID", Long.valueOf(this.field_commentSvrID));
        }
        if (this.grk) {
            contentValues.put(ClientInfoTable.Columns.CLIENTID, this.field_clientId);
        }
        if (this.grl) {
            contentValues.put("commentflag", Integer.valueOf(this.field_commentflag));
        }
        if (this.grm) {
            contentValues.put("isSilence", Integer.valueOf(this.field_isSilence));
        }
        if (this.xrR > 0) {
            contentValues.put("rowid", Long.valueOf(this.xrR));
        }
        return contentValues;
    }
}
