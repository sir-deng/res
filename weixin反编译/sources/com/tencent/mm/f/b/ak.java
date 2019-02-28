package com.tencent.mm.f.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;

public abstract class ak extends c {
    public static final String[] fNF = new String[0];
    private static final int fNO = "rowid".hashCode();
    private static final int fNU = DownloadInfo.STATUS.hashCode();
    private static final int fPZ = "username".hashCode();
    private static final int fPa = "content".hashCode();
    private static final int fSD = "unReadCount".hashCode();
    private static final int fSH = "digest".hashCode();
    private static final int fSI = "digestUser".hashCode();
    private static final int fSJ = "atCount".hashCode();
    private static final int fSK = "editingMsg".hashCode();
    private static final int fSM = "isSend".hashCode();
    private static final int fSN = "msgType".hashCode();
    private static final int fSO = "msgCount".hashCode();
    private static final int fSd = "flag".hashCode();
    private static final int fYi = "chatmode".hashCode();
    private static final int fYj = "conversationTime".hashCode();
    private static final int fYk = "customNotify".hashCode();
    private static final int fYl = "showTips".hashCode();
    private static final int fYm = "hasTrunc".hashCode();
    private static final int fYn = "parentRef".hashCode();
    private static final int fYo = "attrflag".hashCode();
    private static final int fYp = "sightTime".hashCode();
    private static final int fYq = "unReadMuteCount".hashCode();
    private static final int fYr = "lastSeq".hashCode();
    private static final int fYs = "UnDeliverCount".hashCode();
    private static final int fYt = "UnReadInvite".hashCode();
    private static final int fYu = "firstUnDeliverSeq".hashCode();
    private boolean fNR = false;
    private boolean fOE = false;
    private boolean fPX = false;
    private boolean fSA = false;
    private boolean fSb = false;
    private boolean fSp = false;
    private boolean fSt = false;
    private boolean fSu = false;
    private boolean fSv = false;
    private boolean fSw = false;
    private boolean fSy = false;
    private boolean fSz = false;
    private boolean fXV = false;
    private boolean fXW = false;
    private boolean fXX = false;
    public boolean fXY = false;
    private boolean fXZ = false;
    private boolean fYa = false;
    private boolean fYb = false;
    public boolean fYc = false;
    private boolean fYd = false;
    private boolean fYe = false;
    private boolean fYf = false;
    private boolean fYg = false;
    private boolean fYh = false;
    public int field_UnDeliverCount;
    public int field_UnReadInvite;
    public int field_atCount;
    public int field_attrflag;
    public int field_chatmode;
    public String field_content;
    public long field_conversationTime;
    private String field_customNotify;
    public String field_digest;
    public String field_digestUser;
    public String field_editingMsg;
    public long field_firstUnDeliverSeq;
    public long field_flag;
    private int field_hasTrunc;
    public int field_isSend;
    public long field_lastSeq;
    public int field_msgCount;
    public String field_msgType;
    public String field_parentRef;
    public int field_showTips;
    public long field_sightTime;
    public int field_status;
    public int field_unReadCount;
    public int field_unReadMuteCount;
    public String field_username;

    public final void eO(int i) {
        this.field_msgCount = i;
        this.fSA = true;
    }

    public final void setUsername(String str) {
        this.field_username = str;
        this.fPX = true;
    }

    public final String getUsername() {
        return this.field_username;
    }

    public final void eP(int i) {
        this.field_unReadCount = i;
        this.fSp = true;
    }

    public final int wb() {
        return this.field_unReadCount;
    }

    public final void eQ(int i) {
        this.field_chatmode = i;
        this.fXV = true;
    }

    public final void eR(int i) {
        this.field_status = i;
        this.fNR = true;
    }

    public final void eS(int i) {
        this.field_isSend = i;
        this.fSy = true;
    }

    public final void aj(long j) {
        this.field_conversationTime = j;
        this.fXW = true;
    }

    public final void setContent(String str) {
        this.field_content = str;
        this.fOE = true;
    }

    public final void dG(String str) {
        this.field_msgType = str;
        this.fSz = true;
    }

    public final void ak(long j) {
        this.field_flag = j;
        this.fSb = true;
    }

    public final void dH(String str) {
        this.field_digest = str;
        this.fSt = true;
    }

    public final void dI(String str) {
        this.field_digestUser = str;
        this.fSu = true;
    }

    public final void eT(int i) {
        this.field_hasTrunc = i;
        this.fXZ = true;
    }

    public final void dJ(String str) {
        this.field_parentRef = str;
        this.fYa = true;
    }

    public final void eU(int i) {
        this.field_attrflag = i;
        this.fYb = true;
    }

    public final void dK(String str) {
        this.field_editingMsg = str;
        this.fSw = true;
    }

    public final void eV(int i) {
        this.field_atCount = i;
        this.fSv = true;
    }

    public final void eW(int i) {
        this.field_unReadMuteCount = i;
        this.fYd = true;
    }

    public final int wc() {
        return this.field_unReadMuteCount;
    }

    public final void al(long j) {
        this.field_lastSeq = j;
        this.fYe = true;
    }

    public final long wd() {
        return this.field_lastSeq;
    }

    public final void eX(int i) {
        this.field_UnDeliverCount = i;
        this.fYf = true;
    }

    public final int we() {
        return this.field_UnDeliverCount;
    }

    public final void eY(int i) {
        this.field_UnReadInvite = i;
        this.fYg = true;
    }

    public final void am(long j) {
        this.field_firstUnDeliverSeq = j;
        this.fYh = true;
    }

    public final long wf() {
        return this.field_firstUnDeliverSeq;
    }

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (fSO == hashCode) {
                    this.field_msgCount = cursor.getInt(i);
                } else if (fPZ == hashCode) {
                    this.field_username = cursor.getString(i);
                    this.fPX = true;
                } else if (fSD == hashCode) {
                    this.field_unReadCount = cursor.getInt(i);
                } else if (fYi == hashCode) {
                    this.field_chatmode = cursor.getInt(i);
                } else if (fNU == hashCode) {
                    this.field_status = cursor.getInt(i);
                } else if (fSM == hashCode) {
                    this.field_isSend = cursor.getInt(i);
                } else if (fYj == hashCode) {
                    this.field_conversationTime = cursor.getLong(i);
                } else if (fPa == hashCode) {
                    this.field_content = cursor.getString(i);
                } else if (fSN == hashCode) {
                    this.field_msgType = cursor.getString(i);
                } else if (fYk == hashCode) {
                    this.field_customNotify = cursor.getString(i);
                } else if (fYl == hashCode) {
                    this.field_showTips = cursor.getInt(i);
                } else if (fSd == hashCode) {
                    this.field_flag = cursor.getLong(i);
                } else if (fSH == hashCode) {
                    this.field_digest = cursor.getString(i);
                } else if (fSI == hashCode) {
                    this.field_digestUser = cursor.getString(i);
                } else if (fYm == hashCode) {
                    this.field_hasTrunc = cursor.getInt(i);
                } else if (fYn == hashCode) {
                    this.field_parentRef = cursor.getString(i);
                } else if (fYo == hashCode) {
                    this.field_attrflag = cursor.getInt(i);
                } else if (fSK == hashCode) {
                    this.field_editingMsg = cursor.getString(i);
                } else if (fSJ == hashCode) {
                    this.field_atCount = cursor.getInt(i);
                } else if (fYp == hashCode) {
                    this.field_sightTime = cursor.getLong(i);
                } else if (fYq == hashCode) {
                    this.field_unReadMuteCount = cursor.getInt(i);
                } else if (fYr == hashCode) {
                    this.field_lastSeq = cursor.getLong(i);
                } else if (fYs == hashCode) {
                    this.field_UnDeliverCount = cursor.getInt(i);
                } else if (fYt == hashCode) {
                    this.field_UnReadInvite = cursor.getInt(i);
                } else if (fYu == hashCode) {
                    this.field_firstUnDeliverSeq = cursor.getLong(i);
                } else if (fNO == hashCode) {
                    this.xrR = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues vP() {
        ContentValues contentValues = new ContentValues();
        if (this.fSA) {
            contentValues.put("msgCount", Integer.valueOf(this.field_msgCount));
        }
        if (this.field_username == null) {
            this.field_username = "";
        }
        if (this.fPX) {
            contentValues.put("username", this.field_username);
        }
        if (this.fSp) {
            contentValues.put("unReadCount", Integer.valueOf(this.field_unReadCount));
        }
        if (this.fXV) {
            contentValues.put("chatmode", Integer.valueOf(this.field_chatmode));
        }
        if (this.fNR) {
            contentValues.put(DownloadInfo.STATUS, Integer.valueOf(this.field_status));
        }
        if (this.fSy) {
            contentValues.put("isSend", Integer.valueOf(this.field_isSend));
        }
        if (this.fXW) {
            contentValues.put("conversationTime", Long.valueOf(this.field_conversationTime));
        }
        if (this.field_content == null) {
            this.field_content = "";
        }
        if (this.fOE) {
            contentValues.put("content", this.field_content);
        }
        if (this.field_msgType == null) {
            this.field_msgType = "";
        }
        if (this.fSz) {
            contentValues.put("msgType", this.field_msgType);
        }
        if (this.field_customNotify == null) {
            this.field_customNotify = "";
        }
        if (this.fXX) {
            contentValues.put("customNotify", this.field_customNotify);
        }
        if (this.fXY) {
            contentValues.put("showTips", Integer.valueOf(this.field_showTips));
        }
        if (this.fSb) {
            contentValues.put("flag", Long.valueOf(this.field_flag));
        }
        if (this.field_digest == null) {
            this.field_digest = "";
        }
        if (this.fSt) {
            contentValues.put("digest", this.field_digest);
        }
        if (this.field_digestUser == null) {
            this.field_digestUser = "";
        }
        if (this.fSu) {
            contentValues.put("digestUser", this.field_digestUser);
        }
        if (this.fXZ) {
            contentValues.put("hasTrunc", Integer.valueOf(this.field_hasTrunc));
        }
        if (this.fYa) {
            contentValues.put("parentRef", this.field_parentRef);
        }
        if (this.fYb) {
            contentValues.put("attrflag", Integer.valueOf(this.field_attrflag));
        }
        if (this.field_editingMsg == null) {
            this.field_editingMsg = "";
        }
        if (this.fSw) {
            contentValues.put("editingMsg", this.field_editingMsg);
        }
        if (this.fSv) {
            contentValues.put("atCount", Integer.valueOf(this.field_atCount));
        }
        if (this.fYc) {
            contentValues.put("sightTime", Long.valueOf(this.field_sightTime));
        }
        if (this.fYd) {
            contentValues.put("unReadMuteCount", Integer.valueOf(this.field_unReadMuteCount));
        }
        if (this.fYe) {
            contentValues.put("lastSeq", Long.valueOf(this.field_lastSeq));
        }
        if (this.fYf) {
            contentValues.put("UnDeliverCount", Integer.valueOf(this.field_UnDeliverCount));
        }
        if (this.fYg) {
            contentValues.put("UnReadInvite", Integer.valueOf(this.field_UnReadInvite));
        }
        if (this.fYh) {
            contentValues.put("firstUnDeliverSeq", Long.valueOf(this.field_firstUnDeliverSeq));
        }
        if (this.xrR > 0) {
            contentValues.put("rowid", Long.valueOf(this.xrR));
        }
        return contentValues;
    }
}
