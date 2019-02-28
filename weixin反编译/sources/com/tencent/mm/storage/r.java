package com.tencent.mm.storage;

import android.database.Cursor;
import com.tencent.mm.bx.g;
import com.tencent.mm.bx.g.a;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.ae;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;

public final class r extends i<q> implements a, ae {
    public static final String[] fNF = new String[]{"CREATE INDEX IF NOT EXISTS serverChatRoomUserIndex ON chatroom ( chatroomname )"};
    public static final String[] gLy = new String[]{i.a(q.gKN, "chatroom")};
    private e gLA;

    public final /* synthetic */ boolean a(c cVar) {
        q qVar = (q) cVar;
        if (super.a(qVar)) {
            WI(qVar.field_chatroomname);
            return true;
        }
        x.w("MicroMsg.ChatroomStorage", "replace error");
        return false;
    }

    public r(e eVar) {
        super(eVar, q.gKN, "chatroom", fNF);
        this.gLA = eVar;
    }

    public final q hG(String str) {
        c qVar = new q();
        qVar.field_chatroomname = str;
        return super.b(qVar, "chatroomname") ? qVar : null;
    }

    public final q hH(String str) {
        c qVar = new q();
        qVar.field_chatroomname = str;
        return super.b(qVar, "chatroomname") ? qVar : qVar;
    }

    public final void l(String str, long j) {
        this.gLA.fD("chatroom", "update chatroom set modifytime = " + j + " where chatroomname = '" + bi.oL(str) + "'");
    }

    public final String hI(String str) {
        Assert.assertTrue(str.length() > 0);
        Cursor a = this.gLA.a("select roomowner from chatroom where chatroomname='" + bi.oL(str) + "'", null, 2);
        if (a == null) {
            x.e("MicroMsg.ChatroomStorage", "getChatroomOwner fail, cursor is null");
            return null;
        }
        q qVar;
        if (a.moveToFirst()) {
            qVar = new q();
            qVar.b(a);
        } else {
            qVar = null;
        }
        a.close();
        if (qVar != null) {
            return qVar.field_roomowner;
        }
        return null;
    }

    public final String hJ(String str) {
        q qVar;
        Assert.assertTrue(str.length() > 0);
        Cursor a = this.gLA.a("select memberlist from chatroom where chatroomname='" + bi.oL(str) + "'", null, 2);
        if (a.moveToFirst()) {
            qVar = new q();
            qVar.b(a);
        } else {
            qVar = null;
        }
        a.close();
        if (qVar == null) {
            return null;
        }
        return qVar.field_memberlist;
    }

    public final String gw(String str) {
        q qVar;
        Assert.assertTrue(str.length() > 0);
        Cursor a = this.gLA.a("select displayname from chatroom where chatroomname='" + bi.oL(str) + "'", null, 2);
        if (a.moveToFirst()) {
            qVar = new q();
            qVar.b(a);
        } else {
            qVar = null;
        }
        a.close();
        if (qVar == null) {
            return null;
        }
        return qVar.field_displayname;
    }

    public final List<String> hK(String str) {
        String hJ = hJ(str);
        if (hJ == null) {
            return null;
        }
        List<String> linkedList = new LinkedList();
        if (!hJ.equals("")) {
            String[] split = hJ.split(";");
            for (Object add : split) {
                linkedList.add(add);
            }
        }
        return linkedList;
    }

    public final boolean hL(String str) {
        q qVar = null;
        Cursor a = this.gLA.a("select * from chatroom where chatroomname='" + bi.oL(str) + "'", null, 2);
        if (a.moveToFirst()) {
            qVar = new q();
            qVar.b(a);
        }
        a.close();
        return qVar != null && (qVar.field_roomflag & 1) == 0;
    }

    public final boolean hM(String str) {
        Assert.assertTrue(str.length() > 0);
        if (this.gLA.delete("chatroom", "chatroomname=?", new String[]{str}) == 0) {
            return false;
        }
        WI(str);
        return true;
    }

    public final int a(g gVar) {
        return 0;
    }
}
