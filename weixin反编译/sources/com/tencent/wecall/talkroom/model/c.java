package com.tencent.wecall.talkroom.model;

import android.text.TextUtils;
import com.tencent.pb.a.a.a;
import com.tencent.pb.common.b.a.a.at;
import com.tencent.pb.common.b.a.a.av;
import com.tencent.pb.common.b.a.a.aw;
import com.tencent.pb.common.c.e;
import com.tencent.pb.talkroom.sdk.MultiTalkGroup;
import com.tencent.pb.talkroom.sdk.MultiTalkGroupMember;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class c {
    public static boolean Awl = false;
    private static final e<c> Awm = new e<c>() {
        protected final /* synthetic */ Object cDM() {
            return new c();
        }
    };
    private static boolean DEBUG = false;
    Map<String, TalkRoom> Awn;
    Map<String, String> Awo;
    g Awp;

    /* synthetic */ c(byte b) {
        this();
    }

    public static c cIA() {
        return (c) Awm.get();
    }

    private c() {
        this.Awn = new HashMap();
        this.Awo = new HashMap();
        com.tencent.pb.common.c.c.d("TalkRoomManager", "asyncLoadCache");
    }

    public final boolean bu(String str, boolean z) {
        if (TextUtils.isEmpty(str)) {
            com.tencent.pb.common.c.c.m("TalkRoomManager", "isGroupActiveExceptMySelf groupid is null");
            return false;
        }
        TalkRoom acE = acE(str);
        if (acE == null) {
            com.tencent.pb.common.c.c.m("TalkRoomManager", "isGroupActiveExceptMySelf talkRoom is null");
            return false;
        }
        List<d> cIu = acE.cIu();
        if (cIu == null) {
            com.tencent.pb.common.c.c.m("TalkRoomManager", "isGroupActiveExceptMySelf TalkRoomMember list is null");
            return false;
        }
        boolean z2 = false;
        boolean z3 = false;
        for (d dVar : cIu) {
            if (dVar != null) {
                boolean z4;
                TalkRoom.cIq();
                if (dVar.getState() != 10) {
                    z4 = z2;
                    z2 = z3;
                } else if (dVar.cIE()) {
                    z4 = true;
                    z2 = z3;
                } else {
                    z4 = z2;
                    z2 = true;
                }
                if (z && z2) {
                    return true;
                }
                if (z4 && z2) {
                    com.tencent.pb.common.c.c.m("TalkRoomManager", "isGroupActiveExceptMySelf is true");
                    return true;
                }
                z3 = z2;
                z2 = z4;
            }
        }
        return false;
    }

    public final TalkRoom acE(String str) {
        TalkRoom talkRoom = (TalkRoom) this.Awn.get(str);
        if (talkRoom != null || !j.acQ(str)) {
            return talkRoom;
        }
        return (TalkRoom) this.Awn.get((String) this.Awo.get(str));
    }

    public final int acF(String str) {
        if (TextUtils.isEmpty(str)) {
            com.tencent.pb.common.c.c.m("TalkRoomManager", "getSelfMemberId invalid groupId");
            return -1;
        }
        TalkRoom acE = acE(str);
        if (acE == null) {
            com.tencent.pb.common.c.c.m("TalkRoomManager", "getSelfMemberId TalkRoom is null  groupId: ", str);
            return -1;
        }
        d acD = acE.acD(a.cDO());
        if (acD != null) {
            com.tencent.pb.common.c.c.m("TalkRoomManager", "getSelfMemberId TalkRoomMember is not null groupId: ", str, " uuid: ", a.cDO(), " memberId: ", Integer.valueOf(acD.cID()));
            return acD.cID();
        }
        com.tencent.pb.common.c.c.m("TalkRoomManager", "getSelfMemberId TalkRoomMember is null");
        return -1;
    }

    public final int acG(String str) {
        if (TextUtils.isEmpty(str)) {
            com.tencent.pb.common.c.c.m("TalkRoomManager", "getRountIdByGrouId invalid groupId");
            return 0;
        }
        TalkRoom acE = acE(str);
        if (acE != null) {
            return acE.cIr();
        }
        com.tencent.pb.common.c.c.m("TalkRoomManager", "getRountIdByGrouId TalkRoom is null  groupId: ", str);
        return 0;
    }

    public final boolean a(String str, String str2, int i, int i2, String... strArr) {
        com.tencent.pb.common.c.c.d("TalkRoomManager", "newTmpGroup groupId: ", str);
        if (!j.acQ(str)) {
            com.tencent.pb.common.c.c.m("TalkRoomManager", "newTmpGroup invalid clientGroupId");
            return false;
        } else if (strArr == null || strArr.length == 0) {
            com.tencent.pb.common.c.c.m("TalkRoomManager", "newTmpGroup empty uuid array");
            return false;
        } else {
            try {
                at atVar = new at();
                atVar.fws = 0;
                atVar.zYs = str2;
                atVar.zYr = a.cDO();
                TalkRoom talkRoom = new TalkRoom(str, null, atVar);
                int length = strArr.length;
                for (int i3 = 0; i3 != length; i3++) {
                    String str3 = strArr[i3];
                    av avVar = new av();
                    avVar.zXO = str3;
                    avVar.zYT = a.cDO();
                    avVar.status = 20;
                    avVar.nJK = -1;
                    avVar.zYH = (int) (System.currentTimeMillis() / 1000);
                    talkRoom.a(new d(avVar, new aw()));
                }
                this.Awn.put(str, talkRoom);
                cIB();
                return true;
            } catch (Exception e) {
                com.tencent.pb.common.c.c.m("TalkRoomManager", "newTmpGroup err: ", e);
                return false;
            }
        }
    }

    static void cIB() {
        com.tencent.pb.common.c.c.d("TalkRoomManager", "asyncWriteBackCache");
    }

    public static boolean acH(String str) {
        TalkRoom acE = cIA().acE(str);
        if (acE == null) {
            com.tencent.pb.common.c.c.m("TalkRoomManager", "isMySelfExit talkRoom is null");
            return true;
        }
        d cIw = acE.cIw();
        if (cIw == null || 20 == cIw.getState()) {
            return true;
        }
        return false;
    }

    public static int acI(String str) {
        TalkRoom acE = cIA().acE(str);
        if (acE == null) {
            com.tencent.pb.common.c.c.m("TalkRoomManager", "getMySelfReason talkRoom is null groupId: ", str);
            return 0;
        }
        int i;
        d cIw = acE.cIw();
        if (cIw == null || cIw.Awq == null) {
            i = 0;
        } else {
            i = cIw.Awq.aAk;
        }
        com.tencent.pb.common.c.c.m("TalkRoomManager", "getMySelfReason groupId: ", str, " reason: ", Integer.valueOf(i));
        return i;
    }

    public final MultiTalkGroup acJ(String str) {
        TalkRoom acE = acE(str);
        if (acE == null) {
            return null;
        }
        MultiTalkGroup multiTalkGroup = new MultiTalkGroup();
        multiTalkGroup.zZC = acE.zZC;
        multiTalkGroup.zZD = acE.zZD;
        multiTalkGroup.zVs = acE.zVs;
        multiTalkGroup.zZE = acE.zZE;
        multiTalkGroup.zZF = acE.zZF;
        List arrayList = new ArrayList();
        List<d> cIv = acE.cIv();
        if (cIv.size() > 0) {
            for (d dVar : cIv) {
                if (dVar != null) {
                    MultiTalkGroupMember multiTalkGroupMember = new MultiTalkGroupMember();
                    multiTalkGroupMember.zZH = dVar.cIC();
                    multiTalkGroupMember.zZI = dVar.Awq != null ? dVar.Awq.zYT : "";
                    multiTalkGroupMember.aAk = dVar.Awq != null ? dVar.Awq.aAk : 0;
                    multiTalkGroupMember.status = dVar.getState();
                    int i = (dVar.Awq == null || dVar.Awq.zYH == 0) ? 0 : dVar.Awq.zYH;
                    multiTalkGroupMember.zYH = i;
                    arrayList.add(multiTalkGroupMember);
                }
            }
        }
        multiTalkGroup.zZG = arrayList;
        return multiTalkGroup;
    }
}
