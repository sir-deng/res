package com.tencent.mm.f.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class af extends c {
    public static final String[] fNF = new String[0];
    private static final int fNO = "rowid".hashCode();
    private static final int fWb = "chatroomname".hashCode();
    private static final int fWc = "addtime".hashCode();
    private static final int fWd = "memberlist".hashCode();
    private static final int fWe = "displayname".hashCode();
    private static final int fWf = "chatroomnick".hashCode();
    private static final int fWg = "roomflag".hashCode();
    private static final int fWh = "roomowner".hashCode();
    private static final int fWi = "roomdata".hashCode();
    private static final int fWj = "isShowname".hashCode();
    private static final int fWk = "selfDisplayName".hashCode();
    private static final int fWl = "style".hashCode();
    private static final int fWm = "chatroomdataflag".hashCode();
    private static final int fWn = "modifytime".hashCode();
    private static final int fWo = "chatroomnotice".hashCode();
    private static final int fWp = "chatroomVersion".hashCode();
    private static final int fWq = "chatroomnoticeEditor".hashCode();
    private static final int fWr = "chatroomnoticePublishTime".hashCode();
    private static final int fWs = "chatroomLocalVersion".hashCode();
    private boolean fVJ = true;
    private boolean fVK = true;
    private boolean fVL = true;
    private boolean fVM = true;
    private boolean fVN = true;
    private boolean fVO = true;
    private boolean fVP = true;
    private boolean fVQ = true;
    private boolean fVR = true;
    private boolean fVS = true;
    private boolean fVT = true;
    private boolean fVU = true;
    private boolean fVV = true;
    private boolean fVW = true;
    private boolean fVX = true;
    private boolean fVY = true;
    private boolean fVZ = true;
    private boolean fWa = true;
    public long field_addtime;
    public long field_chatroomLocalVersion;
    public int field_chatroomVersion;
    public int field_chatroomdataflag;
    public String field_chatroomname;
    public String field_chatroomnick;
    public String field_chatroomnotice;
    public String field_chatroomnoticeEditor;
    public long field_chatroomnoticePublishTime;
    public String field_displayname;
    public int field_isShowname;
    public String field_memberlist;
    public long field_modifytime;
    public byte[] field_roomdata;
    public int field_roomflag;
    public String field_roomowner;
    public String field_selfDisplayName;
    public int field_style;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (fWb == hashCode) {
                    this.field_chatroomname = cursor.getString(i);
                    this.fVJ = true;
                } else if (fWc == hashCode) {
                    this.field_addtime = cursor.getLong(i);
                } else if (fWd == hashCode) {
                    this.field_memberlist = cursor.getString(i);
                } else if (fWe == hashCode) {
                    this.field_displayname = cursor.getString(i);
                } else if (fWf == hashCode) {
                    this.field_chatroomnick = cursor.getString(i);
                } else if (fWg == hashCode) {
                    this.field_roomflag = cursor.getInt(i);
                } else if (fWh == hashCode) {
                    this.field_roomowner = cursor.getString(i);
                } else if (fWi == hashCode) {
                    this.field_roomdata = cursor.getBlob(i);
                } else if (fWj == hashCode) {
                    this.field_isShowname = cursor.getInt(i);
                } else if (fWk == hashCode) {
                    this.field_selfDisplayName = cursor.getString(i);
                } else if (fWl == hashCode) {
                    this.field_style = cursor.getInt(i);
                } else if (fWm == hashCode) {
                    this.field_chatroomdataflag = cursor.getInt(i);
                } else if (fWn == hashCode) {
                    this.field_modifytime = cursor.getLong(i);
                } else if (fWo == hashCode) {
                    this.field_chatroomnotice = cursor.getString(i);
                } else if (fWp == hashCode) {
                    this.field_chatroomVersion = cursor.getInt(i);
                } else if (fWq == hashCode) {
                    this.field_chatroomnoticeEditor = cursor.getString(i);
                } else if (fWr == hashCode) {
                    this.field_chatroomnoticePublishTime = cursor.getLong(i);
                } else if (fWs == hashCode) {
                    this.field_chatroomLocalVersion = cursor.getLong(i);
                } else if (fNO == hashCode) {
                    this.xrR = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues vP() {
        ContentValues contentValues = new ContentValues();
        if (this.field_chatroomname == null) {
            this.field_chatroomname = "";
        }
        if (this.fVJ) {
            contentValues.put("chatroomname", this.field_chatroomname);
        }
        if (this.fVK) {
            contentValues.put("addtime", Long.valueOf(this.field_addtime));
        }
        if (this.fVL) {
            contentValues.put("memberlist", this.field_memberlist);
        }
        if (this.fVM) {
            contentValues.put("displayname", this.field_displayname);
        }
        if (this.fVN) {
            contentValues.put("chatroomnick", this.field_chatroomnick);
        }
        if (this.fVO) {
            contentValues.put("roomflag", Integer.valueOf(this.field_roomflag));
        }
        if (this.fVP) {
            contentValues.put("roomowner", this.field_roomowner);
        }
        if (this.fVQ) {
            contentValues.put("roomdata", this.field_roomdata);
        }
        if (this.fVR) {
            contentValues.put("isShowname", Integer.valueOf(this.field_isShowname));
        }
        if (this.fVS) {
            contentValues.put("selfDisplayName", this.field_selfDisplayName);
        }
        if (this.fVT) {
            contentValues.put("style", Integer.valueOf(this.field_style));
        }
        if (this.fVU) {
            contentValues.put("chatroomdataflag", Integer.valueOf(this.field_chatroomdataflag));
        }
        if (this.fVV) {
            contentValues.put("modifytime", Long.valueOf(this.field_modifytime));
        }
        if (this.fVW) {
            contentValues.put("chatroomnotice", this.field_chatroomnotice);
        }
        if (this.fVX) {
            contentValues.put("chatroomVersion", Integer.valueOf(this.field_chatroomVersion));
        }
        if (this.fVY) {
            contentValues.put("chatroomnoticeEditor", this.field_chatroomnoticeEditor);
        }
        if (this.fVZ) {
            contentValues.put("chatroomnoticePublishTime", Long.valueOf(this.field_chatroomnoticePublishTime));
        }
        if (this.fWa) {
            contentValues.put("chatroomLocalVersion", Long.valueOf(this.field_chatroomLocalVersion));
        }
        if (this.xrR > 0) {
            contentValues.put("rowid", Long.valueOf(this.xrR));
        }
        return contentValues;
    }
}
