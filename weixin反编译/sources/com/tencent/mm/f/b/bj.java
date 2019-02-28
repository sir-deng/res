package com.tencent.mm.f.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.protocal.c.bx;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import java.io.IOException;

public abstract class bj extends c {
    public static final String[] fNF = new String[0];
    private static final int fNO = "rowid".hashCode();
    private static final int fNU = DownloadInfo.STATUS.hashCode();
    private static final int fQv = "version".hashCode();
    private static final int geL = "cgi".hashCode();
    private static final int geM = "cmdid".hashCode();
    private static final int geN = "functionmsgid".hashCode();
    private static final int geO = "preVersion".hashCode();
    private static final int geP = "retryinterval".hashCode();
    private static final int geQ = "reportid".hashCode();
    private static final int geR = "successkey".hashCode();
    private static final int geS = "failkey".hashCode();
    private static final int geT = "finalfailkey".hashCode();
    private static final int geU = "custombuff".hashCode();
    private static final int geV = "addMsg".hashCode();
    private static final int geW = "needShow".hashCode();
    private boolean fNR = true;
    private boolean fQp = true;
    public bx field_addMsg;
    public String field_cgi;
    public int field_cmdid;
    public String field_custombuff;
    public int field_failkey;
    public int field_finalfailkey;
    public String field_functionmsgid;
    public boolean field_needShow;
    public long field_preVersion;
    public int field_reportid;
    public int field_retryinterval;
    public int field_status;
    public int field_successkey;
    public long field_version;
    private boolean geA = true;
    private boolean geB = true;
    private boolean geC = true;
    private boolean geD = true;
    private boolean geE = true;
    private boolean geF = true;
    private boolean geG = true;
    private boolean geH = true;
    private boolean geI = true;
    private boolean geJ = true;
    private boolean geK = true;
    private boolean gez = true;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (geL == hashCode) {
                    this.field_cgi = cursor.getString(i);
                } else if (geM == hashCode) {
                    this.field_cmdid = cursor.getInt(i);
                } else if (geN == hashCode) {
                    this.field_functionmsgid = cursor.getString(i);
                    this.geB = true;
                } else if (fQv == hashCode) {
                    this.field_version = cursor.getLong(i);
                } else if (geO == hashCode) {
                    this.field_preVersion = cursor.getLong(i);
                } else if (geP == hashCode) {
                    this.field_retryinterval = cursor.getInt(i);
                } else if (geQ == hashCode) {
                    this.field_reportid = cursor.getInt(i);
                } else if (geR == hashCode) {
                    this.field_successkey = cursor.getInt(i);
                } else if (geS == hashCode) {
                    this.field_failkey = cursor.getInt(i);
                } else if (geT == hashCode) {
                    this.field_finalfailkey = cursor.getInt(i);
                } else if (geU == hashCode) {
                    this.field_custombuff = cursor.getString(i);
                } else if (geV == hashCode) {
                    try {
                        byte[] blob = cursor.getBlob(i);
                        if (blob != null && blob.length > 0) {
                            this.field_addMsg = (bx) new bx().aH(blob);
                        }
                    } catch (IOException e) {
                        x.e("MicroMsg.SDK.BaseFunctionMsgItem", e.getMessage());
                    }
                } else if (fNU == hashCode) {
                    this.field_status = cursor.getInt(i);
                } else if (geW == hashCode) {
                    this.field_needShow = cursor.getInt(i) != 0;
                } else if (fNO == hashCode) {
                    this.xrR = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues vP() {
        ContentValues contentValues = new ContentValues();
        if (this.gez) {
            contentValues.put("cgi", this.field_cgi);
        }
        if (this.geA) {
            contentValues.put("cmdid", Integer.valueOf(this.field_cmdid));
        }
        if (this.geB) {
            contentValues.put("functionmsgid", this.field_functionmsgid);
        }
        if (this.fQp) {
            contentValues.put("version", Long.valueOf(this.field_version));
        }
        if (this.geC) {
            contentValues.put("preVersion", Long.valueOf(this.field_preVersion));
        }
        if (this.geD) {
            contentValues.put("retryinterval", Integer.valueOf(this.field_retryinterval));
        }
        if (this.geE) {
            contentValues.put("reportid", Integer.valueOf(this.field_reportid));
        }
        if (this.geF) {
            contentValues.put("successkey", Integer.valueOf(this.field_successkey));
        }
        if (this.geG) {
            contentValues.put("failkey", Integer.valueOf(this.field_failkey));
        }
        if (this.geH) {
            contentValues.put("finalfailkey", Integer.valueOf(this.field_finalfailkey));
        }
        if (this.geI) {
            contentValues.put("custombuff", this.field_custombuff);
        }
        if (this.geJ && this.field_addMsg != null) {
            try {
                contentValues.put("addMsg", this.field_addMsg.toByteArray());
            } catch (IOException e) {
                x.e("MicroMsg.SDK.BaseFunctionMsgItem", e.getMessage());
            }
        }
        if (this.fNR) {
            contentValues.put(DownloadInfo.STATUS, Integer.valueOf(this.field_status));
        }
        if (this.geK) {
            contentValues.put("needShow", Boolean.valueOf(this.field_needShow));
        }
        if (this.xrR > 0) {
            contentValues.put("rowid", Long.valueOf(this.xrR));
        }
        return contentValues;
    }
}
