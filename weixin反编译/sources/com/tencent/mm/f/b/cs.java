package com.tencent.mm.f.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import java.lang.reflect.Field;

public abstract class cs extends c {
    public static final String[] fNF = new String[0];
    private static final int fNO = "rowid".hashCode();
    private static final int gdG = DownloadInfo.FILENAME.hashCode();
    private static final int glL = "musicId".hashCode();
    private static final int gnC = "musicUrl".hashCode();
    private static final int gnD = "indexBitData".hashCode();
    private static final int gnE = "fileCacheComplete".hashCode();
    private static final int gnF = "pieceFileMIMEType".hashCode();
    public int field_fileCacheComplete;
    public String field_fileName;
    public byte[] field_indexBitData;
    public String field_musicId;
    public String field_musicUrl;
    public String field_pieceFileMIMEType;
    private boolean gdn = true;
    private boolean gle = true;
    private boolean gnA = true;
    private boolean gnB = true;
    private boolean gny = true;
    private boolean gnz = true;

    public static a vQ() {
        a aVar = new a();
        aVar.hUM = new Field[6];
        aVar.columns = new String[7];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "musicId";
        aVar.xrT.put("musicId", "TEXT PRIMARY KEY ");
        stringBuilder.append(" musicId TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.xrS = "musicId";
        aVar.columns[1] = "musicUrl";
        aVar.xrT.put("musicUrl", "TEXT");
        stringBuilder.append(" musicUrl TEXT");
        stringBuilder.append(", ");
        aVar.columns[2] = DownloadInfo.FILENAME;
        aVar.xrT.put(DownloadInfo.FILENAME, "TEXT");
        stringBuilder.append(" fileName TEXT");
        stringBuilder.append(", ");
        aVar.columns[3] = "indexBitData";
        aVar.xrT.put("indexBitData", "BLOB");
        stringBuilder.append(" indexBitData BLOB");
        stringBuilder.append(", ");
        aVar.columns[4] = "fileCacheComplete";
        aVar.xrT.put("fileCacheComplete", "INTEGER");
        stringBuilder.append(" fileCacheComplete INTEGER");
        stringBuilder.append(", ");
        aVar.columns[5] = "pieceFileMIMEType";
        aVar.xrT.put("pieceFileMIMEType", "TEXT");
        stringBuilder.append(" pieceFileMIMEType TEXT");
        aVar.columns[6] = "rowid";
        aVar.xrU = stringBuilder.toString();
        return aVar;
    }

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (glL == hashCode) {
                    this.field_musicId = cursor.getString(i);
                    this.gle = true;
                } else if (gnC == hashCode) {
                    this.field_musicUrl = cursor.getString(i);
                } else if (gdG == hashCode) {
                    this.field_fileName = cursor.getString(i);
                } else if (gnD == hashCode) {
                    this.field_indexBitData = cursor.getBlob(i);
                } else if (gnE == hashCode) {
                    this.field_fileCacheComplete = cursor.getInt(i);
                } else if (gnF == hashCode) {
                    this.field_pieceFileMIMEType = cursor.getString(i);
                } else if (fNO == hashCode) {
                    this.xrR = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues vP() {
        ContentValues contentValues = new ContentValues();
        if (this.gle) {
            contentValues.put("musicId", this.field_musicId);
        }
        if (this.gny) {
            contentValues.put("musicUrl", this.field_musicUrl);
        }
        if (this.gdn) {
            contentValues.put(DownloadInfo.FILENAME, this.field_fileName);
        }
        if (this.gnz) {
            contentValues.put("indexBitData", this.field_indexBitData);
        }
        if (this.gnA) {
            contentValues.put("fileCacheComplete", Integer.valueOf(this.field_fileCacheComplete));
        }
        if (this.gnB) {
            contentValues.put("pieceFileMIMEType", this.field_pieceFileMIMEType);
        }
        if (this.xrR > 0) {
            contentValues.put("rowid", Long.valueOf(this.xrR));
        }
        return contentValues;
    }
}
