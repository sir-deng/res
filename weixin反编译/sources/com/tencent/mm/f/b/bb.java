package com.tencent.mm.f.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.protocal.c.vd;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import java.io.IOException;
import java.lang.reflect.Field;

public abstract class bb extends c {
    public static final String[] fNF = new String[]{"CREATE INDEX IF NOT EXISTS FavModInfo_LocalId_Index ON FavEditInfo(localId)"};
    private static final int fNO = "rowid".hashCode();
    private static final int fOV = Columns.TYPE.hashCode();
    private static final int fPn = "scene".hashCode();
    private static final int fVc = "time".hashCode();
    private static final int gch = "localId".hashCode();
    private static final int gci = "modItem".hashCode();
    private boolean fOz = true;
    private boolean fPl = true;
    private boolean fUJ = true;
    public long field_localId;
    public vd field_modItem;
    public int field_scene;
    public long field_time;
    public int field_type;
    private boolean gcf = true;
    private boolean gcg = true;

    public static a vQ() {
        a aVar = new a();
        aVar.hUM = new Field[5];
        aVar.columns = new String[6];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "localId";
        aVar.xrT.put("localId", "LONG");
        stringBuilder.append(" localId LONG");
        stringBuilder.append(", ");
        aVar.columns[1] = "modItem";
        aVar.xrT.put("modItem", "BLOB");
        stringBuilder.append(" modItem BLOB");
        stringBuilder.append(", ");
        aVar.columns[2] = "time";
        aVar.xrT.put("time", "LONG");
        stringBuilder.append(" time LONG");
        stringBuilder.append(", ");
        aVar.columns[3] = Columns.TYPE;
        aVar.xrT.put(Columns.TYPE, "INTEGER");
        stringBuilder.append(" type INTEGER");
        stringBuilder.append(", ");
        aVar.columns[4] = "scene";
        aVar.xrT.put("scene", "INTEGER default '1' ");
        stringBuilder.append(" scene INTEGER default '1' ");
        aVar.columns[5] = "rowid";
        aVar.xrU = stringBuilder.toString();
        return aVar;
    }

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (gch == hashCode) {
                    this.field_localId = cursor.getLong(i);
                } else if (gci == hashCode) {
                    try {
                        byte[] blob = cursor.getBlob(i);
                        if (blob != null && blob.length > 0) {
                            this.field_modItem = (vd) new vd().aH(blob);
                        }
                    } catch (IOException e) {
                        x.e("MicroMsg.SDK.BaseFavEditInfo", e.getMessage());
                    }
                } else if (fVc == hashCode) {
                    this.field_time = cursor.getLong(i);
                } else if (fOV == hashCode) {
                    this.field_type = cursor.getInt(i);
                } else if (fPn == hashCode) {
                    this.field_scene = cursor.getInt(i);
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
        if (this.gcg && this.field_modItem != null) {
            try {
                contentValues.put("modItem", this.field_modItem.toByteArray());
            } catch (IOException e) {
                x.e("MicroMsg.SDK.BaseFavEditInfo", e.getMessage());
            }
        }
        if (this.fUJ) {
            contentValues.put("time", Long.valueOf(this.field_time));
        }
        if (this.fOz) {
            contentValues.put(Columns.TYPE, Integer.valueOf(this.field_type));
        }
        if (this.fPl) {
            contentValues.put("scene", Integer.valueOf(this.field_scene));
        }
        if (this.xrR > 0) {
            contentValues.put("rowid", Long.valueOf(this.xrR));
        }
        return contentValues;
    }
}
