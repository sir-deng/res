package com.tencent.mm.am;

import android.content.ContentValues;
import com.tencent.mm.bx.h;
import com.tencent.mm.sdk.e.j;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import com.tencent.wcdb.FileUtils;

public final class b extends j {
    public static final String[] gLy = new String[]{"CREATE TABLE IF NOT EXISTS getcontactinfov2 ( username text  PRIMARY KEY , inserttime long  , type int  , lastgettime int  , reserved1 int  , reserved2 int  , reserved3 text  , reserved4 text  ) "};
    h hiZ;

    public b(h hVar) {
        this.hiZ = hVar;
    }

    public final boolean a(a aVar) {
        aVar.fEo = -1;
        ContentValues contentValues = new ContentValues();
        if ((aVar.fEo & 1) != 0) {
            contentValues.put("username", aVar.getUsername());
        }
        if ((aVar.fEo & 2) != 0) {
            contentValues.put("inserttime", Long.valueOf(aVar.hAf));
        }
        if ((aVar.fEo & 4) != 0) {
            contentValues.put(Columns.TYPE, Integer.valueOf(aVar.type));
        }
        if ((aVar.fEo & 8) != 0) {
            contentValues.put("lastgettime", Integer.valueOf(aVar.hAg));
        }
        if ((aVar.fEo & 16) != 0) {
            contentValues.put("reserved1", Integer.valueOf(aVar.hiV));
        }
        if ((aVar.fEo & 32) != 0) {
            contentValues.put("reserved2", Integer.valueOf(aVar.hxZ));
        }
        if ((aVar.fEo & 64) != 0) {
            contentValues.put("reserved3", aVar.HT());
        }
        if ((aVar.fEo & FileUtils.S_IWUSR) != 0) {
            contentValues.put("reserved4", aVar.Pa());
        }
        if (((int) this.hiZ.replace("getcontactinfov2", "username", contentValues)) == -1) {
            return false;
        }
        WI(aVar.getUsername());
        return true;
    }

    public final boolean lg(String str) {
        if (this.hiZ.delete("getcontactinfov2", "username= ?", new String[]{str}) <= 0) {
            return false;
        }
        WI(str);
        return true;
    }
}
