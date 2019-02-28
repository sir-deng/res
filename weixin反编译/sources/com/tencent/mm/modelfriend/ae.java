package com.tencent.mm.modelfriend;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.bx.h;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.x;

public final class ae extends m {
    public static final String[] gLy = new String[]{"CREATE TABLE IF NOT EXISTS qqlist ( qq long  PRIMARY KEY , wexinstatus int  , groupid int  , username text  , nickname text  , pyinitial text  , quanpin text  , qqnickname text  , qqpyinitial text  , qqquanpin text  , qqremark text  , qqremarkpyinitial text  , qqremarkquanpin text  , reserved1 text  , reserved2 text  , reserved3 int  , reserved4 int  ) ", "CREATE INDEX IF NOT EXISTS groupid_index ON qqlist ( groupid ) ", "CREATE INDEX IF NOT EXISTS qq_index ON qqlist ( qq ) "};
    public final h hiZ;

    public ae(h hVar) {
        this.hiZ = hVar;
    }

    public final Cursor r(int i, boolean z) {
        String str;
        String[] strArr;
        if (z) {
            str = "select qqlist.qq,qqlist.wexinstatus,qqlist.groupid,qqlist.username,qqlist.nickname,qqlist.pyinitial,qqlist.quanpin,qqlist.qqnickname,qqlist.qqpyinitial,qqlist.qqquanpin,qqlist.qqremark,qqlist.qqremarkpyinitial,qqlist.qqremarkquanpin,qqlist.reserved1,qqlist.reserved2,qqlist.reserved3,qqlist.reserved4 from qqlist  where qqlist.groupid=?  order by reserved3";
            strArr = new String[]{String.valueOf(i)};
        } else {
            str = "select qqlist.qq,qqlist.wexinstatus,qqlist.groupid,qqlist.username,qqlist.nickname,qqlist.pyinitial,qqlist.quanpin,qqlist.qqnickname,qqlist.qqpyinitial,qqlist.qqquanpin,qqlist.qqremark,qqlist.qqremarkpyinitial,qqlist.qqremarkquanpin,qqlist.reserved1,qqlist.reserved2,qqlist.reserved3,qqlist.reserved4 from qqlist  where qqlist.groupid=? and (wexinstatus=? or wexinstatus=?) order by reserved3";
            strArr = new String[]{String.valueOf(i), "1", "2"};
        }
        return this.hiZ.a(str, strArr, 0);
    }

    public final Cursor c(int i, String str, boolean z) {
        x.d("MicroMsg.QQListStorage", "getByGroupID: GroupID:" + i + ", searchby:" + str);
        StringBuilder stringBuilder = new StringBuilder();
        if (z) {
            stringBuilder.append("select qqlist.qq,qqlist.wexinstatus,qqlist.groupid,qqlist.username,qqlist.nickname,qqlist.pyinitial,qqlist.quanpin,qqlist.qqnickname,qqlist.qqpyinitial,qqlist.qqquanpin,qqlist.qqremark,qqlist.qqremarkpyinitial,qqlist.qqremarkquanpin,qqlist.reserved1,qqlist.reserved2,qqlist.reserved3,qqlist.reserved4 from qqlist  where qqlist.groupid = \"" + i + "\" and ( ");
        } else {
            stringBuilder.append("select qqlist.qq,qqlist.wexinstatus,qqlist.groupid,qqlist.username,qqlist.nickname,qqlist.pyinitial,qqlist.quanpin,qqlist.qqnickname,qqlist.qqpyinitial,qqlist.qqquanpin,qqlist.qqremark,qqlist.qqremarkpyinitial,qqlist.qqremarkquanpin,qqlist.reserved1,qqlist.reserved2,qqlist.reserved3,qqlist.reserved4 from qqlist  where qqlist.groupid = \"" + i + "\" and (wexinstatus =\"1" + "\" or wexinstatus =\"2" + "\") and ( ");
        }
        stringBuilder.append("qqlist.qq like '%" + str + "%' or ");
        stringBuilder.append("qqlist.username like '%" + str + "%' or ");
        stringBuilder.append("qqlist.nickname like '%" + str + "%' or ");
        stringBuilder.append("qqlist.pyinitial like '%" + str + "%' or ");
        stringBuilder.append("qqlist.quanpin like '%" + str + "%' or ");
        stringBuilder.append("qqlist.qqnickname like '%" + str + "%' or ");
        stringBuilder.append("qqlist.qqpyinitial like '%" + str + "%' or ");
        stringBuilder.append("qqlist.qqquanpin like '%" + str + "%' or ");
        stringBuilder.append("qqlist.qqremark like '%" + str + "%' )");
        stringBuilder.append(" order by reserved3");
        return this.hiZ.a(stringBuilder.toString(), null, 0);
    }

    public final ad bf(long j) {
        ad adVar = null;
        Cursor a = this.hiZ.a("select qqlist.qq,qqlist.wexinstatus,qqlist.groupid,qqlist.username,qqlist.nickname,qqlist.pyinitial,qqlist.quanpin,qqlist.qqnickname,qqlist.qqpyinitial,qqlist.qqquanpin,qqlist.qqremark,qqlist.qqremarkpyinitial,qqlist.qqremarkquanpin,qqlist.reserved1,qqlist.reserved2,qqlist.reserved3,qqlist.reserved4 from qqlist  where qqlist.qq = \"" + j + "\"", null, 2);
        if (a != null) {
            if (a.moveToFirst()) {
                adVar = new ad();
                adVar.b(a);
            }
            a.close();
        }
        return adVar;
    }

    public final ad lf(String str) {
        ad adVar = null;
        Cursor a = this.hiZ.a("select qqlist.qq,qqlist.wexinstatus,qqlist.groupid,qqlist.username,qqlist.nickname,qqlist.pyinitial,qqlist.quanpin,qqlist.qqnickname,qqlist.qqpyinitial,qqlist.qqquanpin,qqlist.qqremark,qqlist.qqremarkpyinitial,qqlist.qqremarkquanpin,qqlist.reserved1,qqlist.reserved2,qqlist.reserved3,qqlist.reserved4 from qqlist  where qqlist.username = \"" + str + "\"", null, 2);
        if (a != null) {
            if (a.moveToFirst()) {
                adVar = new ad();
                adVar.b(a);
            }
            a.close();
        }
        return adVar;
    }

    public final int a(long j, ad adVar) {
        int i = 0;
        ContentValues OA = adVar.OA();
        if (OA.size() > 0) {
            i = this.hiZ.update("qqlist", OA, "qq=?", new String[]{String.valueOf(j)});
        }
        if (i > 0) {
            b(3, this, String.valueOf(j));
        }
        return i;
    }

    public final boolean a(ad adVar) {
        if (adVar == null) {
            return false;
        }
        x.d("MicroMsg.QQListStorage", "insert: name:" + adVar.OB());
        adVar.fEo = -1;
        if (((int) this.hiZ.insert("qqlist", "qq", adVar.OA())) == -1) {
            return false;
        }
        b(2, this, adVar.hyC);
        return true;
    }

    protected final boolean NK() {
        if (this.hiZ != null && !this.hiZ.chz()) {
            return true;
        }
        String str = "MicroMsg.QQListStorage";
        String str2 = "shouldProcessEvent db is close :%s";
        Object[] objArr = new Object[1];
        objArr[0] = this.hiZ == null ? "null" : Boolean.valueOf(this.hiZ.chz());
        x.w(str, str2, objArr);
        return false;
    }

    public final boolean hK(int i) {
        boolean z = false;
        Cursor cursor = null;
        try {
            cursor = this.hiZ.a("select reserved3 from qqlist where groupid=? and reserved3=?  limit 1", new String[]{String.valueOf(i), "0"}, 2);
            if (cursor != null && cursor.moveToFirst()) {
                z = true;
            }
            if (cursor != null) {
                cursor.close();
            }
        } catch (Exception e) {
            x.e("MicroMsg.QQListStorage", "[cpan] check qq list show head faild.:%s", e.toString());
            if (cursor != null) {
                cursor.close();
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
        }
        return z;
    }
}
