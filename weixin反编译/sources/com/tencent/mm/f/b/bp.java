package com.tencent.mm.f.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;

public abstract class bp extends c {
    public static final String[] fNF = new String[0];
    private static final int fNO = "rowid".hashCode();
    private static final int fNU = DownloadInfo.STATUS.hashCode();
    private static final int fPZ = "username".hashCode();
    private static final int fUB = "nickname".hashCode();
    private static final int gfS = "googleid".hashCode();
    private static final int gfT = "googlename".hashCode();
    private static final int gfU = "googlephotourl".hashCode();
    private static final int gfV = "googlegmail".hashCode();
    private static final int gfW = "nicknameqp".hashCode();
    private static final int gfX = "usernamepy".hashCode();
    private static final int gfY = "small_url".hashCode();
    private static final int gfZ = "big_url".hashCode();
    private static final int gga = "ret".hashCode();
    private static final int ggb = "googleitemid".hashCode();
    private static final int ggc = "googlecgistatus".hashCode();
    private static final int ggd = "contecttype".hashCode();
    private static final int gge = "googlenamepy".hashCode();
    private boolean fNR = true;
    private boolean fPX = true;
    private boolean fUx = true;
    public String field_big_url;
    public String field_contecttype;
    public int field_googlecgistatus;
    public String field_googlegmail;
    public String field_googleid;
    public String field_googleitemid;
    public String field_googlename;
    public String field_googlenamepy;
    public String field_googlephotourl;
    public String field_nickname;
    public String field_nicknameqp;
    public int field_ret;
    public String field_small_url;
    public int field_status;
    public String field_username;
    public String field_usernamepy;
    private boolean gfF = true;
    private boolean gfG = true;
    private boolean gfH = true;
    private boolean gfI = true;
    private boolean gfJ = true;
    private boolean gfK = true;
    private boolean gfL = true;
    private boolean gfM = true;
    private boolean gfN = true;
    private boolean gfO = true;
    private boolean gfP = true;
    private boolean gfQ = true;
    private boolean gfR = true;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (gfS == hashCode) {
                    this.field_googleid = cursor.getString(i);
                } else if (gfT == hashCode) {
                    this.field_googlename = cursor.getString(i);
                } else if (gfU == hashCode) {
                    this.field_googlephotourl = cursor.getString(i);
                } else if (gfV == hashCode) {
                    this.field_googlegmail = cursor.getString(i);
                } else if (fPZ == hashCode) {
                    this.field_username = cursor.getString(i);
                } else if (fUB == hashCode) {
                    this.field_nickname = cursor.getString(i);
                } else if (gfW == hashCode) {
                    this.field_nicknameqp = cursor.getString(i);
                } else if (gfX == hashCode) {
                    this.field_usernamepy = cursor.getString(i);
                } else if (gfY == hashCode) {
                    this.field_small_url = cursor.getString(i);
                } else if (gfZ == hashCode) {
                    this.field_big_url = cursor.getString(i);
                } else if (gga == hashCode) {
                    this.field_ret = cursor.getInt(i);
                } else if (fNU == hashCode) {
                    this.field_status = cursor.getInt(i);
                } else if (ggb == hashCode) {
                    this.field_googleitemid = cursor.getString(i);
                    this.gfO = true;
                } else if (ggc == hashCode) {
                    this.field_googlecgistatus = cursor.getInt(i);
                } else if (ggd == hashCode) {
                    this.field_contecttype = cursor.getString(i);
                } else if (gge == hashCode) {
                    this.field_googlenamepy = cursor.getString(i);
                } else if (fNO == hashCode) {
                    this.xrR = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues vP() {
        ContentValues contentValues = new ContentValues();
        if (this.gfF) {
            contentValues.put("googleid", this.field_googleid);
        }
        if (this.gfG) {
            contentValues.put("googlename", this.field_googlename);
        }
        if (this.gfH) {
            contentValues.put("googlephotourl", this.field_googlephotourl);
        }
        if (this.gfI) {
            contentValues.put("googlegmail", this.field_googlegmail);
        }
        if (this.fPX) {
            contentValues.put("username", this.field_username);
        }
        if (this.fUx) {
            contentValues.put("nickname", this.field_nickname);
        }
        if (this.gfJ) {
            contentValues.put("nicknameqp", this.field_nicknameqp);
        }
        if (this.gfK) {
            contentValues.put("usernamepy", this.field_usernamepy);
        }
        if (this.gfL) {
            contentValues.put("small_url", this.field_small_url);
        }
        if (this.gfM) {
            contentValues.put("big_url", this.field_big_url);
        }
        if (this.gfN) {
            contentValues.put("ret", Integer.valueOf(this.field_ret));
        }
        if (this.fNR) {
            contentValues.put(DownloadInfo.STATUS, Integer.valueOf(this.field_status));
        }
        if (this.gfO) {
            contentValues.put("googleitemid", this.field_googleitemid);
        }
        if (this.gfP) {
            contentValues.put("googlecgistatus", Integer.valueOf(this.field_googlecgistatus));
        }
        if (this.gfQ) {
            contentValues.put("contecttype", this.field_contecttype);
        }
        if (this.gfR) {
            contentValues.put("googlenamepy", this.field_googlenamepy);
        }
        if (this.xrR > 0) {
            contentValues.put("rowid", Long.valueOf(this.xrR));
        }
        return contentValues;
    }
}
