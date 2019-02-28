package com.tencent.mm.f.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.protocal.c.aol;
import com.tencent.mm.protocal.c.ax;
import com.tencent.mm.protocal.c.cck;
import com.tencent.mm.protocal.c.nk;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.x;
import java.io.IOException;

public abstract class cd extends c {
    public static final String[] fNF = new String[0];
    private static final int fNO = "rowid".hashCode();
    private static final int fPG = "appId".hashCode();
    private static final int gjI = "appIdHash".hashCode();
    private static final int gjJ = "launchAction".hashCode();
    private static final int gjK = "jsapiInfo".hashCode();
    private static final int gjL = "hostInfo".hashCode();
    private static final int gjM = "actionsheetInfo".hashCode();
    private boolean fPp = true;
    public ax field_actionsheetInfo;
    public String field_appId;
    public int field_appIdHash;
    public cck field_hostInfo;
    public nk field_jsapiInfo;
    public aol field_launchAction;
    private boolean gjD = true;
    private boolean gjE = true;
    private boolean gjF = true;
    private boolean gjG = true;
    private boolean gjH = true;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                byte[] blob;
                if (gjI == hashCode) {
                    this.field_appIdHash = cursor.getInt(i);
                    this.gjD = true;
                } else if (fPG == hashCode) {
                    this.field_appId = cursor.getString(i);
                } else if (gjJ == hashCode) {
                    try {
                        blob = cursor.getBlob(i);
                        if (blob != null && blob.length > 0) {
                            this.field_launchAction = (aol) new aol().aH(blob);
                        }
                    } catch (IOException e) {
                        x.e("MicroMsg.SDK.BaseLaunchWxaAppRespTable", e.getMessage());
                    }
                } else if (gjK == hashCode) {
                    try {
                        blob = cursor.getBlob(i);
                        if (blob != null && blob.length > 0) {
                            this.field_jsapiInfo = (nk) new nk().aH(blob);
                        }
                    } catch (IOException e2) {
                        x.e("MicroMsg.SDK.BaseLaunchWxaAppRespTable", e2.getMessage());
                    }
                } else if (gjL == hashCode) {
                    try {
                        blob = cursor.getBlob(i);
                        if (blob != null && blob.length > 0) {
                            this.field_hostInfo = (cck) new cck().aH(blob);
                        }
                    } catch (IOException e22) {
                        x.e("MicroMsg.SDK.BaseLaunchWxaAppRespTable", e22.getMessage());
                    }
                } else if (gjM == hashCode) {
                    try {
                        blob = cursor.getBlob(i);
                        if (blob != null && blob.length > 0) {
                            this.field_actionsheetInfo = (ax) new ax().aH(blob);
                        }
                    } catch (IOException e222) {
                        x.e("MicroMsg.SDK.BaseLaunchWxaAppRespTable", e222.getMessage());
                    }
                } else if (fNO == hashCode) {
                    this.xrR = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues vP() {
        ContentValues contentValues = new ContentValues();
        if (this.gjD) {
            contentValues.put("appIdHash", Integer.valueOf(this.field_appIdHash));
        }
        if (this.fPp) {
            contentValues.put("appId", this.field_appId);
        }
        if (this.gjE && this.field_launchAction != null) {
            try {
                contentValues.put("launchAction", this.field_launchAction.toByteArray());
            } catch (IOException e) {
                x.e("MicroMsg.SDK.BaseLaunchWxaAppRespTable", e.getMessage());
            }
        }
        if (this.gjF && this.field_jsapiInfo != null) {
            try {
                contentValues.put("jsapiInfo", this.field_jsapiInfo.toByteArray());
            } catch (IOException e2) {
                x.e("MicroMsg.SDK.BaseLaunchWxaAppRespTable", e2.getMessage());
            }
        }
        if (this.gjG && this.field_hostInfo != null) {
            try {
                contentValues.put("hostInfo", this.field_hostInfo.toByteArray());
            } catch (IOException e22) {
                x.e("MicroMsg.SDK.BaseLaunchWxaAppRespTable", e22.getMessage());
            }
        }
        if (this.gjH && this.field_actionsheetInfo != null) {
            try {
                contentValues.put("actionsheetInfo", this.field_actionsheetInfo.toByteArray());
            } catch (IOException e222) {
                x.e("MicroMsg.SDK.BaseLaunchWxaAppRespTable", e222.getMessage());
            }
        }
        if (this.xrR > 0) {
            contentValues.put("rowid", Long.valueOf(this.xrR));
        }
        return contentValues;
    }
}
