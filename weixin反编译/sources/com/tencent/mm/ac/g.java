package com.tencent.mm.ac;

import android.database.Cursor;
import com.tencent.mm.bx.h;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.bi;

public final class g extends j {
    public static final String[] gLy = new String[]{"CREATE TABLE IF NOT EXISTS hdheadimginfo ( username text  PRIMARY KEY , imgwidth int  , imgheigth int  , imgformat text  , totallen int  , startpos int  , headimgtype int  , reserved1 text  , reserved2 text  , reserved3 int  , reserved4 int  ) "};
    h hiZ;

    public g(h hVar) {
        this.hiZ = hVar;
    }

    public final int a(String str, f fVar) {
        return this.hiZ.update("hdheadimginfo", fVar.vP(), "username=?", new String[]{str});
    }

    public final f jn(String str) {
        f fVar = null;
        Cursor a = this.hiZ.a("select hdheadimginfo.username,hdheadimginfo.imgwidth,hdheadimginfo.imgheigth,hdheadimginfo.imgformat,hdheadimginfo.totallen,hdheadimginfo.startpos,hdheadimginfo.headimgtype,hdheadimginfo.reserved1,hdheadimginfo.reserved2,hdheadimginfo.reserved3,hdheadimginfo.reserved4 from hdheadimginfo   where hdheadimginfo.username = \"" + bi.oL(str) + "\"", null, 2);
        if (a != null) {
            if (a.moveToFirst()) {
                fVar = new f();
                fVar.username = a.getString(0);
                fVar.hmW = a.getInt(1);
                fVar.hmX = a.getInt(2);
                fVar.hmY = a.getString(3);
                fVar.hmZ = a.getInt(4);
                fVar.hna = a.getInt(5);
                fVar.hnb = a.getInt(6);
                fVar.hnc = a.getString(7);
                fVar.hnd = a.getString(8);
                fVar.hne = a.getInt(9);
                fVar.hnf = a.getInt(10);
            }
            a.close();
        }
        return fVar;
    }
}
