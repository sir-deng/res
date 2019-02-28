package com.tencent.mm.modelfriend;

import android.database.Cursor;
import com.tencent.mm.bx.h;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.bi;
import junit.framework.Assert;

public final class i extends j {
    public static final String[] gLy = new String[]{"CREATE TABLE IF NOT EXISTS facebookfriend ( fbid long  PRIMARY KEY , fbname text  , fbimgkey int  , status int  , username text  , nickname text  , nicknamepyinitial text  , nicknamequanpin text  , sex int  , personalcard int  , province text  , city text  , signature text  , alias text  , type int  , email text  ) "};
    public h hiZ;

    public i(h hVar) {
        this.hiZ = hVar;
    }

    public final boolean a(h hVar) {
        Assert.assertTrue("Func Set always conv_flag == flag_all", hVar.fEo == -1);
        Cursor a = this.hiZ.a("select facebookfriend.fbid,facebookfriend.fbname,facebookfriend.fbimgkey,facebookfriend.status,facebookfriend.username,facebookfriend.nickname,facebookfriend.nicknamepyinitial,facebookfriend.nicknamequanpin,facebookfriend.sex,facebookfriend.personalcard,facebookfriend.province,facebookfriend.city,facebookfriend.signature,facebookfriend.alias,facebookfriend.type,facebookfriend.email from facebookfriend   where facebookfriend.fbid = \"" + bi.oL(String.valueOf(hVar.fXc)) + "\"", null, 2);
        boolean moveToFirst = a.moveToFirst();
        a.close();
        if (moveToFirst) {
            int update = this.hiZ.update("facebookfriend", hVar.vP(), "fbid=?", new String[]{hVar.fXc});
            if (update > 0) {
                doNotify();
            }
            if (update <= 0) {
                return false;
            }
            return true;
        }
        hVar.fEo = -1;
        return ((int) this.hiZ.insert("facebookfriend", "fbid", hVar.vP())) != -1;
    }

    public final boolean NM() {
        return this.hiZ.fD("facebookfriend", "delete from facebookfriend");
    }
}
