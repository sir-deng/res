package com.tencent.mm.f.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.protocal.c.vn;
import com.tencent.mm.protocal.c.wa;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import java.io.IOException;
import java.lang.reflect.Field;

public abstract class bc extends c {
    public static final String[] fNF = new String[]{"CREATE INDEX IF NOT EXISTS FavItemInfo_id_Index ON FavItemInfo(id)", "CREATE INDEX IF NOT EXISTS FavItemInfo_type_Index ON FavItemInfo(type)", "CREATE INDEX IF NOT EXISTS FavItemInfo_updateSeq_Index ON FavItemInfo(updateSeq)", "CREATE INDEX IF NOT EXISTS FavItemInfo_flag_Index ON FavItemInfo(flag)", "CREATE INDEX IF NOT EXISTS FavItemInfo_sourceId_Index ON FavItemInfo(sourceId)", "CREATE INDEX IF NOT EXISTS FavItemInfo_datatotalsize_Index ON FavItemInfo(datatotalsize)"};
    private static final int fNO = "rowid".hashCode();
    private static final int fOV = Columns.TYPE.hashCode();
    private static final int fOW = "sourceType".hashCode();
    private static final int fQa = "updateTime".hashCode();
    private static final int fRX = "xml".hashCode();
    private static final int fSd = "flag".hashCode();
    private static final int fYG = SlookAirButtonFrequentContactAdapter.ID.hashCode();
    private static final int gcA = "itemStatus".hashCode();
    private static final int gcB = "sourceCreateTime".hashCode();
    private static final int gcC = "fromUser".hashCode();
    private static final int gcD = "toUser".hashCode();
    private static final int gcE = "realChatName".hashCode();
    private static final int gcF = "favProto".hashCode();
    private static final int gcG = "ext".hashCode();
    private static final int gcH = "edittime".hashCode();
    private static final int gcI = "tagProto".hashCode();
    private static final int gcJ = "sessionId".hashCode();
    private static final int gcK = "datatotalsize".hashCode();
    private static final int gch = "localId".hashCode();
    private static final int gcx = "localSeq".hashCode();
    private static final int gcy = "updateSeq".hashCode();
    private static final int gcz = "sourceId".hashCode();
    private boolean fOA = true;
    private boolean fOz = true;
    private boolean fPY = true;
    private boolean fRT = true;
    private boolean fSb = true;
    private boolean fYD = true;
    public long field_datatotalsize;
    public long field_edittime;
    public String field_ext;
    public vn field_favProto;
    public int field_flag;
    public String field_fromUser;
    public int field_id;
    public int field_itemStatus;
    public long field_localId;
    public int field_localSeq;
    public String field_realChatName;
    public String field_sessionId;
    public long field_sourceCreateTime;
    public String field_sourceId;
    public int field_sourceType;
    public wa field_tagProto;
    public String field_toUser;
    public int field_type;
    public int field_updateSeq;
    public long field_updateTime;
    public String field_xml;
    private boolean gcf = true;
    private boolean gcj = true;
    private boolean gck = true;
    private boolean gcl = true;
    private boolean gcm = true;
    private boolean gcn = true;
    private boolean gco = true;
    private boolean gcp = true;
    private boolean gcq = true;
    private boolean gcr = true;
    private boolean gcs = true;
    private boolean gct = true;
    private boolean gcu = true;
    private boolean gcv = true;
    private boolean gcw = true;

    public static a vQ() {
        a aVar = new a();
        aVar.hUM = new Field[21];
        aVar.columns = new String[22];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "localId";
        aVar.xrT.put("localId", "LONG PRIMARY KEY ");
        stringBuilder.append(" localId LONG PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.xrS = "localId";
        aVar.columns[1] = SlookAirButtonFrequentContactAdapter.ID;
        aVar.xrT.put(SlookAirButtonFrequentContactAdapter.ID, "INTEGER");
        stringBuilder.append(" id INTEGER");
        stringBuilder.append(", ");
        aVar.columns[2] = Columns.TYPE;
        aVar.xrT.put(Columns.TYPE, "INTEGER");
        stringBuilder.append(" type INTEGER");
        stringBuilder.append(", ");
        aVar.columns[3] = "localSeq";
        aVar.xrT.put("localSeq", "INTEGER");
        stringBuilder.append(" localSeq INTEGER");
        stringBuilder.append(", ");
        aVar.columns[4] = "updateSeq";
        aVar.xrT.put("updateSeq", "INTEGER");
        stringBuilder.append(" updateSeq INTEGER");
        stringBuilder.append(", ");
        aVar.columns[5] = "flag";
        aVar.xrT.put("flag", "INTEGER");
        stringBuilder.append(" flag INTEGER");
        stringBuilder.append(", ");
        aVar.columns[6] = "sourceId";
        aVar.xrT.put("sourceId", "TEXT");
        stringBuilder.append(" sourceId TEXT");
        stringBuilder.append(", ");
        aVar.columns[7] = "itemStatus";
        aVar.xrT.put("itemStatus", "INTEGER");
        stringBuilder.append(" itemStatus INTEGER");
        stringBuilder.append(", ");
        aVar.columns[8] = "sourceType";
        aVar.xrT.put("sourceType", "INTEGER");
        stringBuilder.append(" sourceType INTEGER");
        stringBuilder.append(", ");
        aVar.columns[9] = "sourceCreateTime";
        aVar.xrT.put("sourceCreateTime", "LONG");
        stringBuilder.append(" sourceCreateTime LONG");
        stringBuilder.append(", ");
        aVar.columns[10] = "updateTime";
        aVar.xrT.put("updateTime", "LONG");
        stringBuilder.append(" updateTime LONG");
        stringBuilder.append(", ");
        aVar.columns[11] = "fromUser";
        aVar.xrT.put("fromUser", "TEXT");
        stringBuilder.append(" fromUser TEXT");
        stringBuilder.append(", ");
        aVar.columns[12] = "toUser";
        aVar.xrT.put("toUser", "TEXT");
        stringBuilder.append(" toUser TEXT");
        stringBuilder.append(", ");
        aVar.columns[13] = "realChatName";
        aVar.xrT.put("realChatName", "TEXT");
        stringBuilder.append(" realChatName TEXT");
        stringBuilder.append(", ");
        aVar.columns[14] = "favProto";
        aVar.xrT.put("favProto", "BLOB");
        stringBuilder.append(" favProto BLOB");
        stringBuilder.append(", ");
        aVar.columns[15] = "xml";
        aVar.xrT.put("xml", "TEXT");
        stringBuilder.append(" xml TEXT");
        stringBuilder.append(", ");
        aVar.columns[16] = "ext";
        aVar.xrT.put("ext", "TEXT");
        stringBuilder.append(" ext TEXT");
        stringBuilder.append(", ");
        aVar.columns[17] = "edittime";
        aVar.xrT.put("edittime", "LONG");
        stringBuilder.append(" edittime LONG");
        stringBuilder.append(", ");
        aVar.columns[18] = "tagProto";
        aVar.xrT.put("tagProto", "BLOB");
        stringBuilder.append(" tagProto BLOB");
        stringBuilder.append(", ");
        aVar.columns[19] = "sessionId";
        aVar.xrT.put("sessionId", "TEXT");
        stringBuilder.append(" sessionId TEXT");
        stringBuilder.append(", ");
        aVar.columns[20] = "datatotalsize";
        aVar.xrT.put("datatotalsize", "LONG");
        stringBuilder.append(" datatotalsize LONG");
        aVar.columns[21] = "rowid";
        aVar.xrU = stringBuilder.toString();
        return aVar;
    }

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                byte[] blob;
                if (gch == hashCode) {
                    this.field_localId = cursor.getLong(i);
                    this.gcf = true;
                } else if (fYG == hashCode) {
                    this.field_id = cursor.getInt(i);
                } else if (fOV == hashCode) {
                    this.field_type = cursor.getInt(i);
                } else if (gcx == hashCode) {
                    this.field_localSeq = cursor.getInt(i);
                } else if (gcy == hashCode) {
                    this.field_updateSeq = cursor.getInt(i);
                } else if (fSd == hashCode) {
                    this.field_flag = cursor.getInt(i);
                } else if (gcz == hashCode) {
                    this.field_sourceId = cursor.getString(i);
                } else if (gcA == hashCode) {
                    this.field_itemStatus = cursor.getInt(i);
                } else if (fOW == hashCode) {
                    this.field_sourceType = cursor.getInt(i);
                } else if (gcB == hashCode) {
                    this.field_sourceCreateTime = cursor.getLong(i);
                } else if (fQa == hashCode) {
                    this.field_updateTime = cursor.getLong(i);
                } else if (gcC == hashCode) {
                    this.field_fromUser = cursor.getString(i);
                } else if (gcD == hashCode) {
                    this.field_toUser = cursor.getString(i);
                } else if (gcE == hashCode) {
                    this.field_realChatName = cursor.getString(i);
                } else if (gcF == hashCode) {
                    try {
                        blob = cursor.getBlob(i);
                        if (blob != null && blob.length > 0) {
                            this.field_favProto = (vn) new vn().aH(blob);
                        }
                    } catch (IOException e) {
                        x.e("MicroMsg.SDK.BaseFavItemInfo", e.getMessage());
                    }
                } else if (fRX == hashCode) {
                    this.field_xml = cursor.getString(i);
                } else if (gcG == hashCode) {
                    this.field_ext = cursor.getString(i);
                } else if (gcH == hashCode) {
                    this.field_edittime = cursor.getLong(i);
                } else if (gcI == hashCode) {
                    try {
                        blob = cursor.getBlob(i);
                        if (blob != null && blob.length > 0) {
                            this.field_tagProto = (wa) new wa().aH(blob);
                        }
                    } catch (IOException e2) {
                        x.e("MicroMsg.SDK.BaseFavItemInfo", e2.getMessage());
                    }
                } else if (gcJ == hashCode) {
                    this.field_sessionId = cursor.getString(i);
                } else if (gcK == hashCode) {
                    this.field_datatotalsize = cursor.getLong(i);
                } else if (fNO == hashCode) {
                    this.xrR = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues vP() {
        ContentValues contentValues = new ContentValues();
        if (this.gcf) {
            contentValues.put("localId", Long.valueOf(this.field_localId));
        }
        if (this.fYD) {
            contentValues.put(SlookAirButtonFrequentContactAdapter.ID, Integer.valueOf(this.field_id));
        }
        if (this.fOz) {
            contentValues.put(Columns.TYPE, Integer.valueOf(this.field_type));
        }
        if (this.gcj) {
            contentValues.put("localSeq", Integer.valueOf(this.field_localSeq));
        }
        if (this.gck) {
            contentValues.put("updateSeq", Integer.valueOf(this.field_updateSeq));
        }
        if (this.fSb) {
            contentValues.put("flag", Integer.valueOf(this.field_flag));
        }
        if (this.gcl) {
            contentValues.put("sourceId", this.field_sourceId);
        }
        if (this.gcm) {
            contentValues.put("itemStatus", Integer.valueOf(this.field_itemStatus));
        }
        if (this.fOA) {
            contentValues.put("sourceType", Integer.valueOf(this.field_sourceType));
        }
        if (this.gcn) {
            contentValues.put("sourceCreateTime", Long.valueOf(this.field_sourceCreateTime));
        }
        if (this.fPY) {
            contentValues.put("updateTime", Long.valueOf(this.field_updateTime));
        }
        if (this.gco) {
            contentValues.put("fromUser", this.field_fromUser);
        }
        if (this.gcp) {
            contentValues.put("toUser", this.field_toUser);
        }
        if (this.gcq) {
            contentValues.put("realChatName", this.field_realChatName);
        }
        if (this.gcr && this.field_favProto != null) {
            try {
                contentValues.put("favProto", this.field_favProto.toByteArray());
            } catch (IOException e) {
                x.e("MicroMsg.SDK.BaseFavItemInfo", e.getMessage());
            }
        }
        if (this.fRT) {
            contentValues.put("xml", this.field_xml);
        }
        if (this.gcs) {
            contentValues.put("ext", this.field_ext);
        }
        if (this.gct) {
            contentValues.put("edittime", Long.valueOf(this.field_edittime));
        }
        if (this.gcu && this.field_tagProto != null) {
            try {
                contentValues.put("tagProto", this.field_tagProto.toByteArray());
            } catch (IOException e2) {
                x.e("MicroMsg.SDK.BaseFavItemInfo", e2.getMessage());
            }
        }
        if (this.gcv) {
            contentValues.put("sessionId", this.field_sessionId);
        }
        if (this.gcw) {
            contentValues.put("datatotalsize", Long.valueOf(this.field_datatotalsize));
        }
        if (this.xrR > 0) {
            contentValues.put("rowid", Long.valueOf(this.xrR));
        }
        return contentValues;
    }
}
