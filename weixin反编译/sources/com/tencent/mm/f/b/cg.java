package com.tencent.mm.f.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.u;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;

public abstract class cg extends c {
    public static final String[] fNF = new String[0];
    private static final int fNN = "msgId".hashCode();
    private static final int fNO = "rowid".hashCode();
    private static final int fNU = DownloadInfo.STATUS.hashCode();
    private static final int fOS = "createTime".hashCode();
    private static final int fOV = Columns.TYPE.hashCode();
    private static final int fPa = "content".hashCode();
    private static final int fSB = "bizChatId".hashCode();
    private static final int fSM = "isSend".hashCode();
    private static final int fSd = "flag".hashCode();
    private static final int gbv = "talker".hashCode();
    private static final int gfE = "msgSeq".hashCode();
    private static final int ggG = "lvbuffer".hashCode();
    private static final int gkA = "bizChatUserId".hashCode();
    private static final int gks = "msgSvrId".hashCode();
    private static final int gkt = "isShowTimer".hashCode();
    private static final int gku = "imgPath".hashCode();
    private static final int gkv = "reserved".hashCode();
    private static final int gkw = "talkerId".hashCode();
    private static final int gkx = "transContent".hashCode();
    private static final int gky = "transBrandWording".hashCode();
    private static final int gkz = "bizClientMsgId".hashCode();
    private String fHB;
    private boolean fNJ = false;
    private boolean fNR = false;
    private boolean fOE = false;
    private boolean fOw = false;
    private boolean fOz = false;
    private boolean fSb = false;
    private boolean fSn = false;
    private boolean fSy = false;
    public long field_bizChatId;
    public String field_bizChatUserId;
    private String field_bizClientMsgId;
    public String field_content;
    public long field_createTime;
    public int field_flag;
    public String field_imgPath;
    public int field_isSend;
    public int field_isShowTimer;
    public byte[] field_lvbuffer;
    public long field_msgId;
    public long field_msgSeq;
    public long field_msgSvrId;
    public String field_reserved;
    public int field_status;
    public String field_talker;
    public int field_talkerId;
    public String field_transBrandWording;
    public String field_transContent;
    private int field_type;
    private boolean gbf = false;
    private boolean gfy = false;
    public boolean ggu = false;
    public String gkB;
    public int gkC;
    public String gkD;
    public int gkE;
    public int gkF;
    public int gkG;
    public int gkH;
    public int gkI;
    public int gkJ;
    public String gkK;
    public String gkL;
    public String gkM;
    public int gkN;
    private boolean gkj = false;
    public boolean gkk = false;
    private boolean gkl = false;
    private boolean gkm = false;
    public boolean gkn = false;
    private boolean gko = false;
    private boolean gkp = false;
    private boolean gkq = false;
    public boolean gkr = false;

    public final void ao(long j) {
        this.field_msgId = j;
        this.fNJ = true;
    }

    public final long wg() {
        return this.field_msgId;
    }

    public final void ap(long j) {
        this.field_msgSvrId = j;
        this.gkj = true;
    }

    public final long wh() {
        return this.field_msgSvrId;
    }

    public final void setType(int i) {
        this.field_type = i;
        this.fOz = true;
    }

    public int getType() {
        return this.field_type;
    }

    public void eR(int i) {
        this.field_status = i;
        this.fNR = true;
    }

    public final void eS(int i) {
        this.field_isSend = i;
        this.fSy = true;
    }

    public final int wi() {
        return this.field_isSend;
    }

    public final void aq(long j) {
        this.field_createTime = j;
        this.fOw = true;
    }

    public final long wj() {
        return this.field_createTime;
    }

    public final void dU(String str) {
        this.field_talker = str;
        this.gbf = true;
    }

    public final String wk() {
        return this.field_talker;
    }

    public final void setContent(String str) {
        this.field_content = str;
        this.fOE = true;
    }

    public final String wl() {
        return this.field_content;
    }

    public final void dV(String str) {
        this.field_imgPath = str;
        this.gkl = true;
    }

    public final void dW(String str) {
        this.field_reserved = str;
        this.gkm = true;
    }

    public final void A(byte[] bArr) {
        this.field_lvbuffer = bArr;
        this.ggu = true;
    }

    public final void dX(String str) {
        this.field_transContent = str;
        this.gko = true;
    }

    public final void dY(String str) {
        this.field_bizClientMsgId = str;
        this.gkq = true;
    }

    public final void ar(long j) {
        this.field_bizChatId = j;
        this.fSn = true;
    }

    public final void as(long j) {
        this.field_msgSeq = j;
        this.gfy = true;
    }

    public final void fb(int i) {
        this.field_flag = i;
        this.fSb = true;
    }

    public void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (fNN == hashCode) {
                    this.field_msgId = cursor.getLong(i);
                    this.fNJ = true;
                } else if (gks == hashCode) {
                    this.field_msgSvrId = cursor.getLong(i);
                } else if (fOV == hashCode) {
                    this.field_type = cursor.getInt(i);
                } else if (fNU == hashCode) {
                    this.field_status = cursor.getInt(i);
                } else if (fSM == hashCode) {
                    this.field_isSend = cursor.getInt(i);
                } else if (gkt == hashCode) {
                    this.field_isShowTimer = cursor.getInt(i);
                } else if (fOS == hashCode) {
                    this.field_createTime = cursor.getLong(i);
                } else if (gbv == hashCode) {
                    this.field_talker = cursor.getString(i);
                } else if (fPa == hashCode) {
                    this.field_content = cursor.getString(i);
                } else if (gku == hashCode) {
                    this.field_imgPath = cursor.getString(i);
                } else if (gkv == hashCode) {
                    this.field_reserved = cursor.getString(i);
                } else if (ggG == hashCode) {
                    this.field_lvbuffer = cursor.getBlob(i);
                } else if (gkw == hashCode) {
                    this.field_talkerId = cursor.getInt(i);
                } else if (gkx == hashCode) {
                    this.field_transContent = cursor.getString(i);
                } else if (gky == hashCode) {
                    this.field_transBrandWording = cursor.getString(i);
                } else if (gkz == hashCode) {
                    this.field_bizClientMsgId = cursor.getString(i);
                } else if (fSB == hashCode) {
                    this.field_bizChatId = cursor.getLong(i);
                } else if (gkA == hashCode) {
                    this.field_bizChatUserId = cursor.getString(i);
                } else if (gfE == hashCode) {
                    this.field_msgSeq = cursor.getLong(i);
                } else if (fSd == hashCode) {
                    this.field_flag = cursor.getInt(i);
                } else if (fNO == hashCode) {
                    this.xrR = cursor.getLong(i);
                }
            }
            try {
                if (this.field_lvbuffer != null && this.field_lvbuffer.length != 0) {
                    u uVar = new u();
                    int bt = uVar.bt(this.field_lvbuffer);
                    if (bt != 0) {
                        x.e("MicroMsg.SDK.BaseMsgInfo", "parse LVBuffer error:" + bt);
                        return;
                    }
                    if (!uVar.cfJ()) {
                        this.gkB = uVar.getString();
                    }
                    if (!uVar.cfJ()) {
                        this.gkC = uVar.getInt();
                    }
                    if (!uVar.cfJ()) {
                        this.gkD = uVar.getString();
                    }
                    if (!uVar.cfJ()) {
                        this.gkE = uVar.getInt();
                    }
                    if (!uVar.cfJ()) {
                        this.gkF = uVar.getInt();
                    }
                    if (!uVar.cfJ()) {
                        this.gkG = uVar.getInt();
                    }
                    if (!uVar.cfJ()) {
                        this.gkH = uVar.getInt();
                    }
                    if (!uVar.cfJ()) {
                        this.gkI = uVar.getInt();
                    }
                    if (!uVar.cfJ()) {
                        this.gkJ = uVar.getInt();
                    }
                    if (!uVar.cfJ()) {
                        this.gkK = uVar.getString();
                    }
                    if (!uVar.cfJ()) {
                        this.gkL = uVar.getString();
                    }
                    if (!uVar.cfJ()) {
                        this.gkM = uVar.getString();
                    }
                    if (!uVar.cfJ()) {
                        this.gkN = uVar.getInt();
                    }
                    if (!uVar.cfJ()) {
                        this.fHB = uVar.getString();
                    }
                }
            } catch (Exception e) {
                x.e("MicroMsg.SDK.BaseMsgInfo", "get value failed");
            }
        }
    }

    public ContentValues vP() {
        try {
            if (this.ggu) {
                u uVar = new u();
                uVar.cfK();
                uVar.VA(this.gkB);
                uVar.Dw(this.gkC);
                uVar.VA(this.gkD);
                uVar.Dw(this.gkE);
                uVar.Dw(this.gkF);
                uVar.Dw(this.gkG);
                uVar.Dw(this.gkH);
                uVar.Dw(this.gkI);
                uVar.Dw(this.gkJ);
                uVar.VA(this.gkK);
                uVar.VA(this.gkL);
                uVar.VA(this.gkM);
                uVar.Dw(this.gkN);
                uVar.VA(this.fHB);
                this.field_lvbuffer = uVar.cfL();
            }
        } catch (Exception e) {
            x.e("MicroMsg.SDK.BaseMsgInfo", "get value failed, %s", e.getMessage());
        }
        ContentValues contentValues = new ContentValues();
        if (this.fNJ) {
            contentValues.put("msgId", Long.valueOf(this.field_msgId));
        }
        if (this.gkj) {
            contentValues.put("msgSvrId", Long.valueOf(this.field_msgSvrId));
        }
        if (this.fOz) {
            contentValues.put(Columns.TYPE, Integer.valueOf(this.field_type));
        }
        if (this.fNR) {
            contentValues.put(DownloadInfo.STATUS, Integer.valueOf(this.field_status));
        }
        if (this.fSy) {
            contentValues.put("isSend", Integer.valueOf(this.field_isSend));
        }
        if (this.gkk) {
            contentValues.put("isShowTimer", Integer.valueOf(this.field_isShowTimer));
        }
        if (this.fOw) {
            contentValues.put("createTime", Long.valueOf(this.field_createTime));
        }
        if (this.gbf) {
            contentValues.put("talker", this.field_talker);
        }
        if (this.field_content == null) {
            this.field_content = "";
        }
        if (this.fOE) {
            contentValues.put("content", this.field_content);
        }
        if (this.gkl) {
            contentValues.put("imgPath", this.field_imgPath);
        }
        if (this.gkm) {
            contentValues.put("reserved", this.field_reserved);
        }
        if (this.ggu) {
            contentValues.put("lvbuffer", this.field_lvbuffer);
        }
        if (this.gkn) {
            contentValues.put("talkerId", Integer.valueOf(this.field_talkerId));
        }
        if (this.field_transContent == null) {
            this.field_transContent = "";
        }
        if (this.gko) {
            contentValues.put("transContent", this.field_transContent);
        }
        if (this.field_transBrandWording == null) {
            this.field_transBrandWording = "";
        }
        if (this.gkp) {
            contentValues.put("transBrandWording", this.field_transBrandWording);
        }
        if (this.field_bizClientMsgId == null) {
            this.field_bizClientMsgId = "";
        }
        if (this.gkq) {
            contentValues.put("bizClientMsgId", this.field_bizClientMsgId);
        }
        if (this.fSn) {
            contentValues.put("bizChatId", Long.valueOf(this.field_bizChatId));
        }
        if (this.field_bizChatUserId == null) {
            this.field_bizChatUserId = "";
        }
        if (this.gkr) {
            contentValues.put("bizChatUserId", this.field_bizChatUserId);
        }
        if (this.gfy) {
            contentValues.put("msgSeq", Long.valueOf(this.field_msgSeq));
        }
        if (this.fSb) {
            contentValues.put("flag", Integer.valueOf(this.field_flag));
        }
        if (this.xrR > 0) {
            contentValues.put("rowid", Long.valueOf(this.xrR));
        }
        return contentValues;
    }

    public final void dZ(String str) {
        this.gkB = str;
        this.ggu = true;
    }

    public final void fc(int i) {
        this.gkC = i;
        this.ggu = true;
    }

    public final void ea(String str) {
        this.gkD = str;
        this.ggu = true;
    }

    public final void fd(int i) {
        this.gkE = i;
        this.ggu = true;
    }

    public final void fe(int i) {
        this.gkF = i;
        this.ggu = true;
    }

    public final void ff(int i) {
        this.gkJ = i;
        this.ggu = true;
    }

    public final void eb(String str) {
        this.gkL = str;
        this.ggu = true;
    }

    public final void ec(String str) {
        this.gkM = str;
        this.ggu = true;
    }

    public final void fg(int i) {
        this.gkN = i;
        this.ggu = true;
    }
}
