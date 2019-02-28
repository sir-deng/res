package com.tencent.mm.plugin.multitalk.b;

import android.database.Cursor;
import com.tencent.mm.at.b;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.pb.common.c.g;
import java.util.LinkedHashMap;
import java.util.LinkedList;

public final class a extends i<b> {
    public static final String[] gLy = new String[]{i.a(b.gKN, "MultiTalkInfo"), "CREATE INDEX IF NOT EXISTS idx_MultiTalkInfo_key  on MultiTalkInfo  (  wxGroupId )"};
    public static LinkedHashMap<String, Class> mLU = new LinkedHashMap<String, Class>() {
        {
            put("wxGroupId", String.class);
            put("groupId", String.class);
            put("roomId", Integer.TYPE);
            put("roomKey", Long.TYPE);
            put("routeId", Integer.TYPE);
            put("createTime", Long.TYPE);
        }
    };

    public a(e eVar) {
        super(eVar, b.gKN, "MultiTalkInfo", null);
    }

    public final LinkedList<b> bdF() {
        Cursor rawQuery = rawQuery("select wxGroupId, groupId, roomId, roomKey, routeId, createTime from MultiTalkInfo", new String[0]);
        LinkedList<b> linkedList = new LinkedList();
        while (rawQuery != null) {
            try {
                if (!rawQuery.moveToNext()) {
                    break;
                }
                b bVar = new b();
                bVar.field_wxGroupId = rawQuery.getString(0);
                bVar.field_groupId = rawQuery.getString(1);
                bVar.field_roomId = rawQuery.getInt(2);
                bVar.field_roomKey = rawQuery.getLong(3);
                bVar.field_routeId = rawQuery.getInt(4);
                bVar.field_createTime = rawQuery.getLong(5);
                x.i("MicroMsg.MultiTalk.storage.MultiTalkInfoStorage", "getMultiTalkInfoList got value for wxGroupId = %s, groupId=%s, roomId = %d, roomKey = %d, routeId = %d, createTime=%d", bVar.field_wxGroupId, bVar.field_groupId, Integer.valueOf(bVar.field_roomId), Long.valueOf(bVar.field_roomKey), Integer.valueOf(bVar.field_routeId), Long.valueOf(bVar.field_createTime));
                linkedList.add(bVar);
            } catch (Exception e) {
                x.e("MicroMsg.MultiTalk.storage.MultiTalkInfoStorage", "getMultiTalkInfoList error!");
                return linkedList;
            } finally {
                if (rawQuery != null) {
                    rawQuery.close();
                }
            }
        }
        if (rawQuery != null) {
            rawQuery.close();
        }
        return linkedList;
    }

    public final boolean a(b bVar) {
        String str = bVar.field_wxGroupId;
        if (g.Bf(str)) {
            x.e("MicroMsg.MultiTalk.storage.MultiTalkInfoStorage", "save. multiTalkInfo wxGroupId is empty!");
            return false;
        }
        x.i("MicroMsg.MultiTalk.storage.MultiTalkInfoStorage", "save. wxGroupId=%s, groupId=%s, roomId =%d, roomKey =%d, routeId =%d, inviteUser=%s,memberCount=%d,createTime=%d", str, bVar.field_groupId, Integer.valueOf(bVar.field_roomId), Long.valueOf(bVar.field_roomKey), Integer.valueOf(bVar.field_routeId), bVar.field_inviteUserName, Integer.valueOf(bVar.field_memberCount), Long.valueOf(bVar.field_createTime));
        try {
            boolean b = b((c) bVar);
            x.i("MicroMsg.MultiTalk.storage.MultiTalkInfoStorage", "insert ret " + b + " for id=%s" + str);
            return b;
        } catch (Exception e) {
            x.e("MicroMsg.MultiTalk.storage.MultiTalkInfoStorage", "save mulitalTalk failure!" + e.toString());
            return false;
        }
    }

    public final boolean b(b bVar) {
        String str = bVar.field_wxGroupId;
        if (g.Bf(str)) {
            x.e("MicroMsg.MultiTalk.storage.MultiTalkInfoStorage", "update. multiTalkInfo wxGroupId is empty!");
            return false;
        }
        x.i("MicroMsg.MultiTalk.storage.MultiTalkInfoStorage", "update. wxGroupId=%s, groupId=%s, roomId =%d, roomKey =%d, routeId =%d, inviteUser=%s,memberCount=%d,createTime=%d,state=%d", str, bVar.field_groupId, Integer.valueOf(bVar.field_roomId), Long.valueOf(bVar.field_roomKey), Integer.valueOf(bVar.field_routeId), bVar.field_inviteUserName, Integer.valueOf(bVar.field_memberCount), Long.valueOf(bVar.field_createTime), Integer.valueOf(bVar.field_state));
        try {
            boolean c = c(bVar, "wxGroupId");
            x.i("MicroMsg.MultiTalk.storage.MultiTalkInfoStorage", "update ret " + c + " for id=%s" + str);
            return c;
        } catch (Exception e) {
            x.e("MicroMsg.MultiTalk.storage.MultiTalkInfoStorage", "save mulitalTalk failure!" + e.toString());
            return false;
        }
    }

    public final b Gk(String str) {
        x.i("MicroMsg.MultiTalk.storage.MultiTalkInfoStorage", "getMultiTaklInfo for wxGroupId = %s", str);
        Cursor rawQuery = rawQuery("select wxGroupId, groupId, roomId, roomKey, routeId, inviteUserName,memberCount,createTime,state from MultiTalkInfo where wxGroupId = '" + str + "'", new String[0]);
        if (rawQuery != null) {
            try {
                if (rawQuery.moveToNext()) {
                    b bVar = new b();
                    bVar.field_wxGroupId = rawQuery.getString(0);
                    bVar.field_groupId = rawQuery.getString(1);
                    bVar.field_roomId = rawQuery.getInt(2);
                    bVar.field_roomKey = rawQuery.getLong(3);
                    bVar.field_routeId = rawQuery.getInt(4);
                    bVar.field_inviteUserName = rawQuery.getString(5);
                    bVar.field_memberCount = rawQuery.getInt(6);
                    bVar.field_createTime = rawQuery.getLong(7);
                    bVar.field_state = rawQuery.getInt(8);
                    x.i("MicroMsg.MultiTalk.storage.MultiTalkInfoStorage", "getMultiTalkInfo got value for wxGroupId = %s, groupId=%s, roomId = %d, roomKey = %d, routeId = %d,inviteUser=%s,memberCount=%d, createTime=%d,field_state=%d", bVar.field_wxGroupId, bVar.field_groupId, Integer.valueOf(bVar.field_roomId), Long.valueOf(bVar.field_roomKey), Integer.valueOf(bVar.field_routeId), bVar.field_inviteUserName, Integer.valueOf(bVar.field_memberCount), Long.valueOf(bVar.field_createTime), Integer.valueOf(bVar.field_state));
                    if (rawQuery == null) {
                        return bVar;
                    }
                    rawQuery.close();
                    return bVar;
                }
            } catch (Exception e) {
                x.e("MicroMsg.MultiTalk.storage.MultiTalkInfoStorage", "getMultiTalkInfo error! " + e.toString());
                if (rawQuery != null) {
                    rawQuery.close();
                }
                return null;
            } catch (Throwable th) {
                if (rawQuery != null) {
                    rawQuery.close();
                }
                throw th;
            }
        }
        if (rawQuery != null) {
            rawQuery.close();
        }
        return null;
    }

    public final boolean iI(String str) {
        x.i("MicroMsg.MultiTalk.storage.MultiTalkInfoStorage", "delete id = %s", str);
        try {
            super.fD("MultiTalkInfo", "delete from MultiTalkInfo where wxGroupId = \"" + str + "\"");
            return true;
        } catch (Exception e) {
            x.e("MicroMsg.MultiTalk.storage.MultiTalkInfoStorage", "delete fail for wxGroupId = " + str);
            return false;
        }
    }
}
