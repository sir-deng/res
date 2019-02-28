package com.tencent.mm.plugin.sns.storage;

import android.database.Cursor;
import com.tencent.mm.bx.h;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.modelsfs.SFSContext.FileEntry;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.List;

public final class v {
    public boolean rvy = false;

    public static boolean a(h hVar, h hVar2) {
        try {
            if (bi.oN(hVar.getKey())) {
                hVar2.fD("", "ATTACH DATABASE '" + hVar.getPath() + "' AS old ");
            } else {
                hVar2.fD("", "ATTACH DATABASE '" + hVar.getPath() + "' AS old KEY '" + hVar.getKey() + "'");
            }
            x.i("MicroMsg.TrimSnsDb", "ATTACH DATABASE " + hVar.getKey());
            return true;
        } catch (Throwable e) {
            x.e("MicroMsg.TrimSnsDb", "ERROR : attach disk db [%s] , will do again !", e.getMessage());
            x.printErrStackTrace("MicroMsg.TrimSnsDb", e, "", new Object[0]);
            return false;
        }
    }

    public static int a(h hVar, h hVar2, String str) {
        String str2 = null;
        Cursor a = hVar.a(" select sql from sqlite_master where tbl_name=\"" + str + "\" and type = \"table\"", null, 0);
        if (a != null) {
            if (a.getCount() == 1) {
                a.moveToFirst();
                str2 = a.getString(0);
            }
            a.close();
        }
        if (str2 == null) {
            x.w("MicroMsg.TrimSnsDb", "diskDB has not this table !");
            return -1;
        }
        x.i("MicroMsg.TrimSnsDb", "create sql %s", str2);
        x.i("MicroMsg.TrimSnsDb", "create result " + hVar2.fD("", str2));
        return 1;
    }

    public static void Mo(String str) {
        List<FileEntry> F = FileOp.F(str, false);
        if (F != null) {
            for (FileEntry fileEntry : F) {
                if (fileEntry.name.startsWith("SnsMicroMsg.dberr")) {
                    x.i("MicroMsg.TrimSnsDb", "find error %s", str + fileEntry.name);
                    FileOp.deleteFile(str + fileEntry.name);
                }
            }
        }
    }
}
