package com.tencent.mm.modelfriend;

import android.database.Cursor;
import com.tencent.mm.bx.h;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.bi;

public final class r extends j {
    public static final String[] gLy = new String[]{"CREATE TABLE IF NOT EXISTS invitefriendopen ( username text  PRIMARY KEY , friendtype int  , updatetime int  , reserved1 int  , reserved2 int  , reserved3 text  , reserved4 text  ) "};
    private h hiZ;

    public r(h hVar) {
        this.hiZ = hVar;
    }

    public final boolean a(q qVar) {
        if (ld(qVar.getUsername())) {
            qVar.fEo = -1;
            if (this.hiZ.update("invitefriendopen", qVar.vP(), "username=?", new String[]{qVar.getUsername()}) > 0) {
                return true;
            }
            return false;
        }
        qVar.fEo = -1;
        if (((int) this.hiZ.insert("invitefriendopen", "username", qVar.vP())) == -1) {
            return false;
        }
        return true;
    }

    public final boolean ld(String str) {
        Cursor a = this.hiZ.a("select invitefriendopen.username,invitefriendopen.friendtype,invitefriendopen.updatetime,invitefriendopen.reserved1,invitefriendopen.reserved2,invitefriendopen.reserved3,invitefriendopen.reserved4 from invitefriendopen   where invitefriendopen.username = \"" + bi.oL(str) + "\"", null, 2);
        boolean moveToFirst = a.moveToFirst();
        a.close();
        return moveToFirst;
    }
}
