package com.tencent.mm.f.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.protocal.c.cbv;
import com.tencent.mm.protocal.c.cbw;
import com.tencent.mm.protocal.c.cdu;
import com.tencent.mm.protocal.c.nk;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.x;
import java.io.IOException;

public abstract class ce extends c {
    public static final String[] fNF = new String[0];
    private static final int fNO = "rowid".hashCode();
    private static final int fPG = "appId".hashCode();
    private static final int gjI = "appIdHash".hashCode();
    private static final int gjJ = "launchAction".hashCode();
    private static final int gjS = "pkgType".hashCode();
    private static final int gjT = "widgetType".hashCode();
    private static final int gjU = "jsApiInfo".hashCode();
    private static final int gjV = "versionInfo".hashCode();
    private static final int gjW = "widgetSetting".hashCode();
    private boolean fPp = true;
    public String field_appId;
    public int field_appIdHash;
    public nk field_jsApiInfo;
    public cbv field_launchAction;
    public int field_pkgType;
    public cbw field_versionInfo;
    public cdu field_widgetSetting;
    public int field_widgetType;
    private boolean gjD = true;
    private boolean gjE = true;
    private boolean gjN = true;
    private boolean gjO = true;
    private boolean gjP = true;
    private boolean gjQ = true;
    private boolean gjR = true;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                byte[] blob;
                if (gjI == hashCode) {
                    this.field_appIdHash = cursor.getInt(i);
                } else if (fPG == hashCode) {
                    this.field_appId = cursor.getString(i);
                } else if (gjS == hashCode) {
                    this.field_pkgType = cursor.getInt(i);
                } else if (gjT == hashCode) {
                    this.field_widgetType = cursor.getInt(i);
                } else if (gjJ == hashCode) {
                    try {
                        blob = cursor.getBlob(i);
                        if (blob != null && blob.length > 0) {
                            this.field_launchAction = (cbv) new cbv().aH(blob);
                        }
                    } catch (IOException e) {
                        x.e("MicroMsg.SDK.BaseLaunchWxaWidgetRespData", e.getMessage());
                    }
                } else if (gjU == hashCode) {
                    try {
                        blob = cursor.getBlob(i);
                        if (blob != null && blob.length > 0) {
                            this.field_jsApiInfo = (nk) new nk().aH(blob);
                        }
                    } catch (IOException e2) {
                        x.e("MicroMsg.SDK.BaseLaunchWxaWidgetRespData", e2.getMessage());
                    }
                } else if (gjV == hashCode) {
                    try {
                        blob = cursor.getBlob(i);
                        if (blob != null && blob.length > 0) {
                            this.field_versionInfo = (cbw) new cbw().aH(blob);
                        }
                    } catch (IOException e22) {
                        x.e("MicroMsg.SDK.BaseLaunchWxaWidgetRespData", e22.getMessage());
                    }
                } else if (gjW == hashCode) {
                    try {
                        blob = cursor.getBlob(i);
                        if (blob != null && blob.length > 0) {
                            this.field_widgetSetting = (cdu) new cdu().aH(blob);
                        }
                    } catch (IOException e222) {
                        x.e("MicroMsg.SDK.BaseLaunchWxaWidgetRespData", e222.getMessage());
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
        if (this.gjN) {
            contentValues.put("pkgType", Integer.valueOf(this.field_pkgType));
        }
        if (this.gjO) {
            contentValues.put("widgetType", Integer.valueOf(this.field_widgetType));
        }
        if (this.gjE && this.field_launchAction != null) {
            try {
                contentValues.put("launchAction", this.field_launchAction.toByteArray());
            } catch (IOException e) {
                x.e("MicroMsg.SDK.BaseLaunchWxaWidgetRespData", e.getMessage());
            }
        }
        if (this.gjP && this.field_jsApiInfo != null) {
            try {
                contentValues.put("jsApiInfo", this.field_jsApiInfo.toByteArray());
            } catch (IOException e2) {
                x.e("MicroMsg.SDK.BaseLaunchWxaWidgetRespData", e2.getMessage());
            }
        }
        if (this.gjQ && this.field_versionInfo != null) {
            try {
                contentValues.put("versionInfo", this.field_versionInfo.toByteArray());
            } catch (IOException e22) {
                x.e("MicroMsg.SDK.BaseLaunchWxaWidgetRespData", e22.getMessage());
            }
        }
        if (this.gjR && this.field_widgetSetting != null) {
            try {
                contentValues.put("widgetSetting", this.field_widgetSetting.toByteArray());
            } catch (IOException e222) {
                x.e("MicroMsg.SDK.BaseLaunchWxaWidgetRespData", e222.getMessage());
            }
        }
        if (this.xrR > 0) {
            contentValues.put("rowid", Long.valueOf(this.xrR));
        }
        return contentValues;
    }
}
