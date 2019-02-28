package com.tencent.mm.f.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class bv extends c {
    public static final String[] fNF = new String[0];
    private static final int fNO = "rowid".hashCode();
    private static final int fPZ = "username".hashCode();
    private static final int ggY = "rankID".hashCode();
    private static final int ggZ = "appusername".hashCode();
    private static final int ghc = "score".hashCode();
    private static final int ghi = "ranknum".hashCode();
    private static final int ghj = "likecount".hashCode();
    private static final int ghk = "selfLikeState".hashCode();
    private boolean fPX = true;
    public String field_appusername;
    public int field_likecount;
    public String field_rankID;
    public int field_ranknum;
    public int field_score;
    public int field_selfLikeState;
    public String field_username;
    private boolean ggV = true;
    private boolean ggW = true;
    private boolean ghb = true;
    private boolean ghf = true;
    private boolean ghg = true;
    private boolean ghh = true;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (ggY == hashCode) {
                    this.field_rankID = cursor.getString(i);
                } else if (ggZ == hashCode) {
                    this.field_appusername = cursor.getString(i);
                } else if (fPZ == hashCode) {
                    this.field_username = cursor.getString(i);
                } else if (ghi == hashCode) {
                    this.field_ranknum = cursor.getInt(i);
                } else if (ghc == hashCode) {
                    this.field_score = cursor.getInt(i);
                } else if (ghj == hashCode) {
                    this.field_likecount = cursor.getInt(i);
                } else if (ghk == hashCode) {
                    this.field_selfLikeState = cursor.getInt(i);
                } else if (fNO == hashCode) {
                    this.xrR = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues vP() {
        ContentValues contentValues = new ContentValues();
        if (this.ggV) {
            contentValues.put("rankID", this.field_rankID);
        }
        if (this.ggW) {
            contentValues.put("appusername", this.field_appusername);
        }
        if (this.fPX) {
            contentValues.put("username", this.field_username);
        }
        if (this.ghf) {
            contentValues.put("ranknum", Integer.valueOf(this.field_ranknum));
        }
        if (this.ghb) {
            contentValues.put("score", Integer.valueOf(this.field_score));
        }
        if (this.ghg) {
            contentValues.put("likecount", Integer.valueOf(this.field_likecount));
        }
        if (this.ghh) {
            contentValues.put("selfLikeState", Integer.valueOf(this.field_selfLikeState));
        }
        if (this.xrR > 0) {
            contentValues.put("rowid", Long.valueOf(this.xrR));
        }
        return contentValues;
    }
}
