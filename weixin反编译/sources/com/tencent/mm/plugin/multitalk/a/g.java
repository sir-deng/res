package com.tencent.mm.plugin.multitalk.a;

import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import com.tencent.mm.f.a.my;
import com.tencent.mm.plugin.multitalk.ui.widget.e;
import com.tencent.mm.plugin.voip.model.d;
import com.tencent.mm.plugin.voip.ui.h;
import com.tencent.mm.pluginsdk.q.f;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.as;
import com.tencent.mm.y.c;
import com.tencent.mm.y.r;
import com.tencent.mm.y.s;
import com.tencent.pb.common.b.a.a.av;
import com.tencent.pb.common.b.a.a.bb;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class g implements com.tencent.mm.pluginsdk.q.g {
    private List<f> avD = new ArrayList();
    private ag handler = new ag(Looper.getMainLooper());
    private LinkedList<String> oMk = null;
    private LinkedList<String> oMl = new LinkedList();
    private LinkedList<String> oMm = new LinkedList();

    public final LinkedList<String> bdm() {
        if (this.oMm == null) {
            this.oMm = new LinkedList();
        }
        return this.oMm;
    }

    public final synchronized void a(f fVar) {
        this.avD.add(fVar);
    }

    public final synchronized void b(f fVar) {
        this.avD.remove(fVar);
    }

    public final void FX(final String str) {
        if (s.eX(str) && FZ(str)) {
            x.i("MicroMsg.MultiTalkRoomListMsg", "isKicked! now clean banner and check if i am in multitalk.");
            as.Hm();
            c.Db().get(2, null);
            if (o.bdB().oLN != null && o.bdB().oLN.zZE.equals(str)) {
                x.i("MicroMsg.MultiTalkRoomListMsg", "yes i am now in multitalk so i exit now!");
                o.bdB().c(false, false, false);
            }
            this.handler.postDelayed(new Runnable() {
                public final void run() {
                    g.this.Gg(str);
                    b myVar = new my();
                    myVar.fFP.type = 2;
                    a.xmy.m(myVar);
                }
            }, 2000);
        }
    }

    public final boolean FY(String str) {
        com.tencent.mm.at.b Gk = o.bdx().Gk(str);
        if (Gk == null || Gk.field_wxGroupId == null || !Gk.field_wxGroupId.equals(str)) {
            return false;
        }
        if (System.currentTimeMillis() - Gk.field_createTime <= 21600000) {
            return true;
        }
        x.i("MicroMsg.MultiTalkRoomListMsg", "wxGroupId:" + str + ",is out of time 6 hours..");
        Gg(str);
        return false;
    }

    public final boolean FZ(String str) {
        if (this.oMk == null) {
            bdp();
        }
        if (this.oMk == null || !this.oMk.contains(str)) {
            return false;
        }
        return true;
    }

    public final List<String> Ga(String str) {
        List<com.tencent.mm.plugin.multitalk.b.b> Gl = o.bdy().Gl(str);
        List linkedList = new LinkedList();
        for (com.tencent.mm.plugin.multitalk.b.b bVar : Gl) {
            linkedList.add(bVar.field_userName);
        }
        return linkedList;
    }

    public final boolean dw(String str, String str2) {
        if (o.bdy().dz(str, str2) != null) {
            return true;
        }
        return false;
    }

    public final boolean iI(String str) {
        if (this.oMk != null) {
            x.i("MicroMsg.MultiTalkRoomListMsg", "removewxGroupIdInMap:" + str);
            this.oMk.remove(str);
        } else {
            bdp();
        }
        return o.bdx().iI(str);
    }

    public final boolean bcZ() {
        return o.bdB().bcZ();
    }

    public final boolean bdb() {
        return o.bdB().bdb();
    }

    public final boolean bdn() {
        return o.bdB().bcZ() && (o.bdB().oLM == e.Starting || o.bdB().oLM == e.Creating);
    }

    public final boolean Gb(String str) {
        com.tencent.mm.plugin.voip.ui.g bGU = d.bGU();
        if (bGU != null) {
            Intent intent = bGU.intent;
            if (intent != null) {
                String stringExtra = intent.getStringExtra("enterMainUiWxGroupId");
                h hVar = bGU.syx;
                if (!com.tencent.pb.common.c.g.Bf(stringExtra) && str.equals(stringExtra) && hVar != null && hVar.getVisibility() == 0 && hVar.isShown()) {
                    return true;
                }
            }
        }
        return false;
    }

    public final boolean bdo() {
        return com.tencent.mm.plugin.voip.b.d.bJa() || o.bdB().bdb() || o.bdB().bcZ() || o.bdB().bda();
    }

    public final String dx(String str, String str2) {
        com.tencent.mm.plugin.multitalk.b.b dz = o.bdy().dz(str, str2);
        if (dz != null) {
            return dz.field_inviteUserName;
        }
        return null;
    }

    public final String gw(String str) {
        return r.gw(str);
    }

    public final boolean aW(Context context) {
        return com.tencent.mm.o.a.aW(context);
    }

    public final boolean Gc(String str) {
        com.tencent.mm.at.b Gk = o.bdx().Gk(str);
        if (Gk != null) {
            return com.tencent.wecall.talkroom.model.a.cIo().b(Gk.field_groupId, Gk.field_roomId, Gk.field_roomKey, 1);
        }
        return false;
    }

    public final void Gd(String str) {
        if (this.oMl == null) {
            this.oMl = new LinkedList();
            if (!this.oMl.contains(str)) {
                this.oMl.add(str);
            }
        } else if (!this.oMl.contains(str)) {
            this.oMl.add(str);
        }
    }

    public final boolean Ge(String str) {
        com.tencent.mm.at.b Gk = o.bdx().Gk(str);
        if (Gk != null) {
            return o.bdA().oLv.Ge(Gk.field_groupId);
        }
        return false;
    }

    public final boolean Gf(String str) {
        com.tencent.mm.at.b Gk = o.bdx().Gk(str);
        if (Gk != null) {
            return o.bdA().oLv.a(Gk.field_groupId, Gk.field_roomId, Gk.field_roomKey, Gk.field_routeId);
        }
        return false;
    }

    public final int dy(String str, String str2) {
        com.tencent.mm.plugin.multitalk.b.b dz = o.bdy().dz(str, str2);
        if (dz != null) {
            return dz.field_status;
        }
        return 30;
    }

    public final void Gg(String str) {
        if (com.tencent.pb.common.c.g.isNullOrEmpty(str)) {
            x.e("MicroMsg.MultiTalkRoomListMsg", "cleanBanner failure ! wxGroupId is null or empty!");
            return;
        }
        x.i("MicroMsg.MultiTalkRoomListMsg", "cleanBanner  wxGroupId = %s", str);
        iI(str);
        o.bdy().iI(str);
        Gj(str);
    }

    public final void a(String str, bb bbVar) {
        x.i("MicroMsg.MultiTalkRoomListMsg", "showBanner  wxGroupId = %s", str);
        if (bbVar != null) {
            av[] avVarArr = bbVar.zXq;
            if (avVarArr != null && avVarArr.length > 0) {
                o.bdy().iI(str);
                for (av avVar : avVarArr) {
                    com.tencent.mm.plugin.multitalk.b.b bVar = new com.tencent.mm.plugin.multitalk.b.b();
                    bVar.field_wxGroupId = str;
                    bVar.field_inviteUserName = avVar.zYT;
                    bVar.field_memberUuid = (long) avVar.vJp;
                    bVar.field_userName = avVar.zXO;
                    bVar.field_status = avVar.status;
                    if (!o.bdy().a(bVar)) {
                        x.e("MicroMsg.MultiTalkRoomListMsg", "save multiTalkMember failure! wxGroupId = %s,userName = %s,field_memberUuid = %d,multiTalkMember.field_inviteUserName = %s", str, avVar.zXO, Long.valueOf(bVar.field_memberUuid), bVar.field_inviteUserName);
                    }
                    x.i("MicroMsg.MultiTalkRoomListMsg", "save multiTalkMember success! wxGroupId = %s,userName = %s,field_memberUuid = %d,multiTalkMember.field_inviteUserName = %s", str, avVar.zXO, Long.valueOf(bVar.field_memberUuid), bVar.field_inviteUserName);
                }
            }
        }
        if (b(str, bbVar)) {
            x.i("MicroMsg.MultiTalkRoomListMsg", "addwxGroupIdInMap:" + str);
            if (this.oMk == null) {
                bdp();
                if (this.oMk != null) {
                    this.oMk.add(str);
                }
            } else if (!this.oMk.contains(str)) {
                this.oMk.add(str);
            }
        }
        Gj(str);
    }

    public final void Gh(String str) {
        if (this.oMl == null) {
            this.oMl = new LinkedList();
        } else {
            this.oMl.remove(str);
        }
    }

    public final boolean Gi(String str) {
        if (this.oMl == null) {
            return false;
        }
        return this.oMl.contains(str);
    }

    final void Gj(final String str) {
        for (final f fVar : this.avD) {
            this.handler.post(new Runnable() {
                public final void run() {
                    fVar.RP(str);
                }
            });
        }
    }

    public final com.tencent.mm.at.b Gk(String str) {
        return o.bdx().Gk(str);
    }

    public final void bdp() {
        LinkedList bdF = o.bdx().bdF();
        x.i("MicroMsg.MultiTalkRoomListMsg", "setMultitalkingwxGroupIdMap reset!");
        this.oMk = new LinkedList();
        Iterator it = bdF.iterator();
        while (it.hasNext()) {
            this.oMk.add(((com.tencent.mm.at.b) it.next()).field_wxGroupId);
        }
        b myVar = new my();
        myVar.fFP.type = 1;
        a.xmy.m(myVar);
    }

    private static boolean b(String str, bb bbVar) {
        int i = 0;
        if (bbVar == null) {
            return false;
        }
        com.tencent.mm.at.b bVar = new com.tencent.mm.at.b();
        bVar.field_wxGroupId = str;
        bVar.field_groupId = bbVar.groupId;
        bVar.field_roomId = bbVar.srH;
        bVar.field_roomKey = bbVar.srI;
        bVar.field_routeId = bbVar.zWd;
        bVar.field_inviteUserName = bbVar.zZp;
        av[] avVarArr = bbVar.zXq;
        if (avVarArr.length > 0) {
            i = avVarArr.length;
        }
        bVar.field_memberCount = i;
        bVar.field_createTime = System.currentTimeMillis();
        if (o.bdx().Gk(str) == null) {
            return o.bdx().a(bVar);
        }
        return o.bdx().b(bVar);
    }

    static boolean c(String str, bb bbVar) {
        if (bbVar == null) {
            return false;
        }
        av[] avVarArr = bbVar.zXq;
        List linkedList = new LinkedList();
        for (av avVar : avVarArr) {
            linkedList.add(avVar.zXO);
        }
        as.Hm();
        String str2 = (String) c.Db().get(2, null);
        if (str2 == null) {
            x.i("MicroMsg.MultiTalkRoomListMsg", "myUserName is null , go save delete all logic.");
            b(str, bbVar);
            return true;
        }
        boolean z;
        List<com.tencent.mm.plugin.multitalk.b.b> Gl = o.bdy().Gl(str);
        LinkedList linkedList2 = new LinkedList();
        com.tencent.mm.plugin.multitalk.b.b bVar = null;
        for (com.tencent.mm.plugin.multitalk.b.b bVar2 : Gl) {
            com.tencent.mm.plugin.multitalk.b.b bVar22;
            linkedList2.add(bVar22.field_userName);
            if (!bVar22.field_userName.equals(str2)) {
                bVar22 = bVar;
            }
            bVar = bVar22;
        }
        if (bVar == null || !linkedList.contains(str2)) {
            z = true;
        } else {
            z = true;
            for (av avVar2 : avVarArr) {
                if (!(avVar2.zXO == null || !avVar2.zXO.equals(str2) || avVar2.status == bVar.field_status)) {
                    com.tencent.mm.plugin.multitalk.b.b bVar3 = new com.tencent.mm.plugin.multitalk.b.b();
                    bVar3.field_wxGroupId = str;
                    bVar3.field_inviteUserName = avVar2.zYT;
                    bVar3.field_memberUuid = (long) avVar2.vJp;
                    bVar3.field_userName = avVar2.zXO;
                    bVar3.field_status = avVar2.status;
                    if (!o.bdy().a(bVar3)) {
                        x.e("MicroMsg.MultiTalkRoomListMsg", "updateMultiTalkMembers update myself failure! wxGroupId = %s,userName = %s,field_memberUuid = %d,multiTalkMember.field_inviteUserName = %s", str, avVar2.zXO, Long.valueOf(bVar3.field_memberUuid), bVar3.field_inviteUserName);
                        z = false;
                    }
                    x.i("MicroMsg.MultiTalkRoomListMsg", "updateMultiTalkMembers update myself success! wxGroupId = %s,userName = %s,field_memberUuid = %d,multiTalkMember.field_inviteUserName = %s", str, avVar2.zXO, Long.valueOf(bVar3.field_memberUuid), bVar3.field_inviteUserName);
                }
            }
        }
        boolean z2 = z;
        for (av avVar3 : avVarArr) {
            if (!linkedList2.contains(avVar3.zXO)) {
                com.tencent.mm.plugin.multitalk.b.b bVar4 = new com.tencent.mm.plugin.multitalk.b.b();
                bVar4.field_wxGroupId = str;
                bVar4.field_inviteUserName = avVar3.zYT;
                bVar4.field_memberUuid = (long) avVar3.vJp;
                bVar4.field_userName = avVar3.zXO;
                bVar4.field_status = avVar3.status;
                if (!o.bdy().a(bVar4)) {
                    x.e("MicroMsg.MultiTalkRoomListMsg", "updateMultiTalkMembers save multiTalkMember failure! wxGroupId = %s,userName = %s,field_memberUuid = %d,multiTalkMember.field_inviteUserName = %s", str, avVar3.zXO, Long.valueOf(bVar4.field_memberUuid), bVar4.field_inviteUserName);
                    z2 = false;
                }
                x.i("MicroMsg.MultiTalkRoomListMsg", "updateMultiTalkMembers save multiTalkMember success! wxGroupId = %s,userName = %s,field_memberUuid = %d,multiTalkMember.field_inviteUserName = %s", str, avVar3.zXO, Long.valueOf(bVar4.field_memberUuid), bVar4.field_inviteUserName);
            }
        }
        Iterator it = linkedList2.iterator();
        z = z2;
        while (it.hasNext()) {
            str2 = (String) it.next();
            if (!linkedList.contains(str2)) {
                if (o.bdy().bW(str, str2)) {
                    x.i("MicroMsg.MultiTalkRoomListMsg", "updateMultiTalkMembers delete success for wxGroupId = " + str + ", username = " + str2);
                } else {
                    z = false;
                    x.e("MicroMsg.MultiTalkRoomListMsg", "updateMultiTalkMembers delete fail for wxGroupId = " + str + ", username = " + str2);
                }
            }
            z = z;
        }
        return z;
    }
}
