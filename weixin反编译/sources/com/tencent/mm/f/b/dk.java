package com.tencent.mm.f.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;

public abstract class dk extends c {
    public static final String[] fNF = new String[]{"CREATE INDEX IF NOT EXISTS file_name_hash_index ON SightDraftInfo(fileNameHash)"};
    private static final int fNO = "rowid".hashCode();
    private static final int fOS = "createTime".hashCode();
    private static final int gch = "localId".hashCode();
    private static final int gdG = DownloadInfo.FILENAME.hashCode();
    private static final int gqM = "fileNameHash".hashCode();
    private static final int gqN = "fileMd5".hashCode();
    private static final int gqO = "fileLength".hashCode();
    private static final int gqP = "fileStatus".hashCode();
    private static final int gqQ = "fileDuration".hashCode();
    private boolean fOw = true;
    public long field_createTime;
    public int field_fileDuration;
    public long field_fileLength;
    public String field_fileMd5;
    public String field_fileName;
    public int field_fileNameHash;
    public int field_fileStatus;
    public int field_localId;
    private boolean gcf = true;
    private boolean gdn = true;
    private boolean gqH = true;
    private boolean gqI = true;
    private boolean gqJ = true;
    private boolean gqK = true;
    private boolean gqL = true;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (gch == hashCode) {
                    this.field_localId = cursor.getInt(i);
                    this.gcf = true;
                } else if (gdG == hashCode) {
                    this.field_fileName = cursor.getString(i);
                } else if (gqM == hashCode) {
                    this.field_fileNameHash = cursor.getInt(i);
                } else if (gqN == hashCode) {
                    this.field_fileMd5 = cursor.getString(i);
                } else if (gqO == hashCode) {
                    this.field_fileLength = cursor.getLong(i);
                } else if (gqP == hashCode) {
                    this.field_fileStatus = cursor.getInt(i);
                } else if (gqQ == hashCode) {
                    this.field_fileDuration = cursor.getInt(i);
                } else if (fOS == hashCode) {
                    this.field_createTime = cursor.getLong(i);
                } else if (fNO == hashCode) {
                    this.xrR = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues vP() {
        ContentValues contentValues = new ContentValues();
        if (this.gcf) {
            contentValues.put("localId", Integer.valueOf(this.field_localId));
        }
        if (this.gdn) {
            contentValues.put(DownloadInfo.FILENAME, this.field_fileName);
        }
        if (this.gqH) {
            contentValues.put("fileNameHash", Integer.valueOf(this.field_fileNameHash));
        }
        if (this.field_fileMd5 == null) {
            this.field_fileMd5 = "";
        }
        if (this.gqI) {
            contentValues.put("fileMd5", this.field_fileMd5);
        }
        if (this.gqJ) {
            contentValues.put("fileLength", Long.valueOf(this.field_fileLength));
        }
        if (this.gqK) {
            contentValues.put("fileStatus", Integer.valueOf(this.field_fileStatus));
        }
        if (this.gqL) {
            contentValues.put("fileDuration", Integer.valueOf(this.field_fileDuration));
        }
        if (this.fOw) {
            contentValues.put("createTime", Long.valueOf(this.field_createTime));
        }
        if (this.xrR > 0) {
            contentValues.put("rowid", Long.valueOf(this.xrR));
        }
        return contentValues;
    }
}
