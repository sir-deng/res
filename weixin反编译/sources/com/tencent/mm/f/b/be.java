package com.tencent.mm.f.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.sdk.e.c;

public abstract class be extends c {
    public static final String[] fNF = new String[0];
    private static final int fNO = "rowid".hashCode();
    private static final int fRY = "title".hashCode();
    private static final int fVi = SlookSmartClipMetaTag.TAG_TYPE_URL.hashCode();
    private static final int gcZ = "featureId".hashCode();
    private static final int gda = "titlePY".hashCode();
    private static final int gdb = "titleShortPY".hashCode();
    private static final int gdc = "tag".hashCode();
    private static final int gdd = "actionType".hashCode();
    private static final int gde = "helpUrl".hashCode();
    private static final int gdf = "updateUrl".hashCode();
    private static final int gdg = "androidUrl".hashCode();
    private static final int gdh = "iconPath".hashCode();
    private static final int gdi = "timestamp".hashCode();
    private boolean fRU = true;
    private boolean fUP = true;
    public int field_actionType;
    public String field_androidUrl;
    public int field_featureId;
    public String field_helpUrl;
    public String field_iconPath;
    public String field_tag;
    public long field_timestamp;
    public String field_title;
    public String field_titlePY;
    public String field_titleShortPY;
    public String field_updateUrl;
    public String field_url;
    private boolean gcP = true;
    private boolean gcQ = true;
    private boolean gcR = true;
    private boolean gcS = true;
    private boolean gcT = true;
    private boolean gcU = true;
    private boolean gcV = true;
    private boolean gcW = true;
    private boolean gcX = true;
    private boolean gcY = true;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (gcZ == hashCode) {
                    this.field_featureId = cursor.getInt(i);
                    this.gcP = true;
                } else if (fRY == hashCode) {
                    this.field_title = cursor.getString(i);
                } else if (gda == hashCode) {
                    this.field_titlePY = cursor.getString(i);
                } else if (gdb == hashCode) {
                    this.field_titleShortPY = cursor.getString(i);
                } else if (gdc == hashCode) {
                    this.field_tag = cursor.getString(i);
                } else if (gdd == hashCode) {
                    this.field_actionType = cursor.getInt(i);
                } else if (fVi == hashCode) {
                    this.field_url = cursor.getString(i);
                } else if (gde == hashCode) {
                    this.field_helpUrl = cursor.getString(i);
                } else if (gdf == hashCode) {
                    this.field_updateUrl = cursor.getString(i);
                } else if (gdg == hashCode) {
                    this.field_androidUrl = cursor.getString(i);
                } else if (gdh == hashCode) {
                    this.field_iconPath = cursor.getString(i);
                } else if (gdi == hashCode) {
                    this.field_timestamp = cursor.getLong(i);
                } else if (fNO == hashCode) {
                    this.xrR = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues vP() {
        ContentValues contentValues = new ContentValues();
        if (this.gcP) {
            contentValues.put("featureId", Integer.valueOf(this.field_featureId));
        }
        if (this.fRU) {
            contentValues.put("title", this.field_title);
        }
        if (this.gcQ) {
            contentValues.put("titlePY", this.field_titlePY);
        }
        if (this.gcR) {
            contentValues.put("titleShortPY", this.field_titleShortPY);
        }
        if (this.gcS) {
            contentValues.put("tag", this.field_tag);
        }
        if (this.gcT) {
            contentValues.put("actionType", Integer.valueOf(this.field_actionType));
        }
        if (this.fUP) {
            contentValues.put(SlookSmartClipMetaTag.TAG_TYPE_URL, this.field_url);
        }
        if (this.gcU) {
            contentValues.put("helpUrl", this.field_helpUrl);
        }
        if (this.gcV) {
            contentValues.put("updateUrl", this.field_updateUrl);
        }
        if (this.gcW) {
            contentValues.put("androidUrl", this.field_androidUrl);
        }
        if (this.gcX) {
            contentValues.put("iconPath", this.field_iconPath);
        }
        if (this.gcY) {
            contentValues.put("timestamp", Long.valueOf(this.field_timestamp));
        }
        if (this.xrR > 0) {
            contentValues.put("rowid", Long.valueOf(this.xrR));
        }
        return contentValues;
    }
}
