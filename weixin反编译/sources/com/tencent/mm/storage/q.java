package com.tencent.mm.storage;

import com.tencent.mm.f.b.af;
import com.tencent.mm.h.a.a.b;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bj;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class q extends af {
    protected static a gKN;
    public Map<String, b> hsr = new HashMap();
    private com.tencent.mm.h.a.a.a xuQ = new com.tencent.mm.h.a.a.a();
    public com.tencent.mm.h.a.a.a xuR = this.xuQ;
    private List<String> xuS = new LinkedList();

    static {
        a aVar = new a();
        aVar.hUM = new Field[18];
        aVar.columns = new String[19];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "chatroomname";
        aVar.xrT.put("chatroomname", "TEXT default ''  PRIMARY KEY ");
        stringBuilder.append(" chatroomname TEXT default ''  PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.xrS = "chatroomname";
        aVar.columns[1] = "addtime";
        aVar.xrT.put("addtime", "LONG");
        stringBuilder.append(" addtime LONG");
        stringBuilder.append(", ");
        aVar.columns[2] = "memberlist";
        aVar.xrT.put("memberlist", "TEXT");
        stringBuilder.append(" memberlist TEXT");
        stringBuilder.append(", ");
        aVar.columns[3] = "displayname";
        aVar.xrT.put("displayname", "TEXT");
        stringBuilder.append(" displayname TEXT");
        stringBuilder.append(", ");
        aVar.columns[4] = "chatroomnick";
        aVar.xrT.put("chatroomnick", "TEXT");
        stringBuilder.append(" chatroomnick TEXT");
        stringBuilder.append(", ");
        aVar.columns[5] = "roomflag";
        aVar.xrT.put("roomflag", "INTEGER");
        stringBuilder.append(" roomflag INTEGER");
        stringBuilder.append(", ");
        aVar.columns[6] = "roomowner";
        aVar.xrT.put("roomowner", "TEXT");
        stringBuilder.append(" roomowner TEXT");
        stringBuilder.append(", ");
        aVar.columns[7] = "roomdata";
        aVar.xrT.put("roomdata", "BLOB");
        stringBuilder.append(" roomdata BLOB");
        stringBuilder.append(", ");
        aVar.columns[8] = "isShowname";
        aVar.xrT.put("isShowname", "INTEGER");
        stringBuilder.append(" isShowname INTEGER");
        stringBuilder.append(", ");
        aVar.columns[9] = "selfDisplayName";
        aVar.xrT.put("selfDisplayName", "TEXT");
        stringBuilder.append(" selfDisplayName TEXT");
        stringBuilder.append(", ");
        aVar.columns[10] = "style";
        aVar.xrT.put("style", "INTEGER");
        stringBuilder.append(" style INTEGER");
        stringBuilder.append(", ");
        aVar.columns[11] = "chatroomdataflag";
        aVar.xrT.put("chatroomdataflag", "INTEGER");
        stringBuilder.append(" chatroomdataflag INTEGER");
        stringBuilder.append(", ");
        aVar.columns[12] = "modifytime";
        aVar.xrT.put("modifytime", "LONG");
        stringBuilder.append(" modifytime LONG");
        stringBuilder.append(", ");
        aVar.columns[13] = "chatroomnotice";
        aVar.xrT.put("chatroomnotice", "TEXT");
        stringBuilder.append(" chatroomnotice TEXT");
        stringBuilder.append(", ");
        aVar.columns[14] = "chatroomVersion";
        aVar.xrT.put("chatroomVersion", "INTEGER");
        stringBuilder.append(" chatroomVersion INTEGER");
        stringBuilder.append(", ");
        aVar.columns[15] = "chatroomnoticeEditor";
        aVar.xrT.put("chatroomnoticeEditor", "TEXT");
        stringBuilder.append(" chatroomnoticeEditor TEXT");
        stringBuilder.append(", ");
        aVar.columns[16] = "chatroomnoticePublishTime";
        aVar.xrT.put("chatroomnoticePublishTime", "LONG");
        stringBuilder.append(" chatroomnoticePublishTime LONG");
        stringBuilder.append(", ");
        aVar.columns[17] = "chatroomLocalVersion";
        aVar.xrT.put("chatroomLocalVersion", "LONG");
        stringBuilder.append(" chatroomLocalVersion LONG");
        aVar.columns[18] = "rowid";
        aVar.xrU = stringBuilder.toString();
        gKN = aVar;
    }

    protected final a Aj() {
        return gKN;
    }

    public final List<String> My() {
        if (this.xuS == null || this.xuS.size() == 0) {
            this.xuS = Xc(this.field_memberlist);
        }
        return this.xuS;
    }

    private void a(com.tencent.mm.h.a.a.a aVar) {
        if (this.field_roomdata == null) {
            aVar = new com.tencent.mm.h.a.a.a();
        }
        Iterator it = aVar.gDp.iterator();
        while (it.hasNext()) {
            b bVar = (b) it.next();
            this.hsr.put(bVar.userName, bVar);
        }
    }

    public final void ciC() {
        if (!bi.by(this.field_roomdata)) {
            try {
                this.xuR = (com.tencent.mm.h.a.a.a) new com.tencent.mm.h.a.a.a().aH(this.field_roomdata);
            } catch (Exception e) {
                this.xuR = new com.tencent.mm.h.a.a.a();
            }
            a(this.xuR);
        }
    }

    public final boolean b(com.tencent.mm.h.a.a.a aVar) {
        return this.xuQ.bkL() == aVar.bkL();
    }

    public final b Xa(String str) {
        if (this.hsr.size() <= 0) {
            ciC();
        }
        if (this.hsr.containsKey(str)) {
            return (b) this.hsr.get(str);
        }
        return null;
    }

    public final int ciD() {
        if (b(this.xuR)) {
            ciC();
        }
        return this.xuR.fBU;
    }

    public final boolean ciE() {
        if (b(this.xuR)) {
            ciC();
        }
        return this.xuR.fBU < this.xuR.gDs;
    }

    public static boolean ciF() {
        return false;
    }

    public final void gb(int i) {
        this.field_chatroomdataflag = (this.xuR.fEo & -3) | (i & 2);
    }

    public final int ciG() {
        if (b(this.xuR)) {
            ciC();
        }
        return this.xuR.type;
    }

    public final int ciH() {
        if (b(this.xuR)) {
            ciC();
        }
        return this.xuR.gDq;
    }

    public final String gw(String str) {
        b Xa = Xa(str);
        if (Xa == null) {
            return "";
        }
        return bi.aD(Xa.gDt, "");
    }

    public final q lN(boolean z) {
        this.field_isShowname = z ? 1 : 0;
        return this;
    }

    public final boolean ciI() {
        return this.field_isShowname > 0;
    }

    private static int Lu(String str) {
        int i = 0;
        try {
            return bi.getInt(str, 0);
        } catch (Exception e) {
            if (str == null) {
                return i;
            }
            x.e("MicroMsg.ChatRoomMember", "parserInt error " + str);
            return i;
        }
    }

    private static com.tencent.mm.h.a.a.a Xb(String str) {
        com.tencent.mm.h.a.a.a aVar = new com.tencent.mm.h.a.a.a();
        if (bi.oN(str)) {
            return aVar;
        }
        int indexOf = str.indexOf(60);
        if (indexOf > 0) {
            str = str.substring(indexOf);
        }
        Map y = bj.y(str, "RoomData");
        if (y == null) {
            x.e("MicroMsg.ChatRoomMember", "parse RoomData failed");
            return null;
        }
        indexOf = 0;
        while (true) {
            try {
                Object obj;
                Object obj2;
                Object obj3;
                String obj4;
                int i = indexOf;
                b bVar = new b();
                if (i == 0) {
                    obj4 = ".RoomData.Member.$UserName";
                    obj2 = ".RoomData.Member.DisplayName";
                    obj3 = ".RoomData.Member.Flag";
                } else if (i != 0) {
                    String str2 = ".RoomData.Member" + i + ".$UserName";
                    String str3 = ".RoomData.Member" + i + ".DisplayName";
                    String str4 = ".RoomData.Member" + i + ".Flag";
                    obj4 = str2;
                    str2 = str3;
                    str3 = str4;
                } else {
                    obj3 = null;
                    obj2 = null;
                    obj4 = null;
                }
                obj4 = bi.aD((String) y.get(obj4), "");
                if (bi.oN(obj4)) {
                    aVar.type = Lu((String) y.get(".RoomData.Type"));
                    aVar.status = Lu((String) y.get(".RoomData.Status"));
                    aVar.gDq = Lu((String) y.get(".RoomData.MaxCount"));
                    aVar.gDr = bi.aD((String) y.get(".RoomData.ExtInfo.Upgrader"), "");
                    return aVar;
                }
                bVar.userName = obj4;
                bVar.gDt = bi.aD((String) y.get(obj2), "");
                bVar.gDu = Lu((String) y.get(obj3));
                aVar.gDp.add(bVar);
                indexOf = i + 1;
            } catch (Exception e) {
                return aVar;
            }
        }
    }

    public static List<String> Xc(String str) {
        List<String> linkedList = new LinkedList();
        if (bi.oN(str)) {
            return linkedList;
        }
        String[] split = str.split(";");
        for (Object add : split) {
            linkedList.add(add);
        }
        return linkedList;
    }

    public final q cF(List<String> list) {
        String str;
        if (list == null || list.size() == 0) {
            str = "";
        } else {
            str = "";
            for (int i = 0; i < list.size(); i++) {
                str = str + ((String) list.get(i));
                if (i < list.size() - 1) {
                    str = str + ";";
                }
            }
        }
        this.field_memberlist = str;
        return this;
    }

    public final q fI(String str, String str2) {
        return a(str, Xb(str2), false);
    }

    public final q a(String str, com.tencent.mm.h.a.a.a aVar, boolean z) {
        this.field_modifytime = System.currentTimeMillis();
        if (!z) {
            int i;
            b bVar = null;
            Iterator it = aVar.gDp.iterator();
            while (it.hasNext()) {
                b bVar2 = (b) it.next();
                if (bVar2.userName == null || !bVar2.userName.equals(str)) {
                    bVar2 = bVar;
                }
                bVar = bVar2;
            }
            if (bVar != null) {
                this.field_selfDisplayName = bVar.gDt;
                this.field_isShowname = bVar.gDu & 1;
                i = bVar.gDu;
            } else {
                i = 0;
            }
            x.d("MicroMsg.ChatRoomMember", "displayName[%s] roomFlag[%d] flag[%d]", this.field_selfDisplayName, Integer.valueOf(this.field_chatroomdataflag), Integer.valueOf(i));
            aVar.fEo = (i & 2) | (aVar.fEo & -3);
            this.field_chatroomdataflag = aVar.fEo;
        }
        try {
            this.field_roomdata = aVar.toByteArray();
            this.xuR = aVar;
        } catch (Throwable e) {
            x.e("MicroMsg.ChatRoomMember", "exception:%s", bi.i(e));
        }
        a(aVar);
        return this;
    }

    public final com.tencent.mm.h.a.a.a ciJ() {
        if (b(this.xuR)) {
            ciC();
        }
        return this.xuR;
    }
}
