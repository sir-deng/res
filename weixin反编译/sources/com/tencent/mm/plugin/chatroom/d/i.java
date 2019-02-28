package com.tencent.mm.plugin.chatroom.d;

import android.util.Pair;
import com.tencent.mm.ac.h;
import com.tencent.mm.ac.n;
import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.hardcoder.HardCoderJNI;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.abf;
import com.tencent.mm.protocal.c.abg;
import com.tencent.mm.protocal.c.mn;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ar;
import com.tencent.mm.y.as;
import com.tencent.mm.y.c;
import java.util.LinkedList;
import java.util.List;

public final class i extends k implements com.tencent.mm.network.k {
    private final String chatroomName;
    private final b gLB;
    private e gLE = null;
    private int hGs;
    private int lfd = 0;

    static /* synthetic */ void a(i iVar, int i) {
        iVar.lfd &= i ^ -1;
        if (iVar.lfd == 0) {
            HardCoderJNI.stopPerformace(HardCoderJNI.hcUpdateChatroomEnable, iVar.hGs);
            iVar.hGs = 0;
        }
    }

    public i(String str, int i) {
        int i2;
        a aVar = new a();
        aVar.hnT = new abf();
        aVar.hnU = new abg();
        aVar.uri = "/cgi-bin/micromsg-bin/getchatroommemberdetail";
        aVar.hnS = 551;
        aVar.hnV = 0;
        aVar.hnW = 0;
        this.gLB = aVar.Kf();
        this.chatroomName = str;
        as.Hm();
        int ciD = c.Fo().hH(str).ciD();
        ((abf) this.gLB.hnQ.hnY).wqZ = str;
        abf abf = (abf) this.gLB.hnQ.hnY;
        if (ciD < i) {
            i2 = i;
        } else {
            i2 = ciD;
        }
        abf.vRR = i2;
        x.i("MicroMsg.NetSceneGetChatroomMemberDetail", "summerChatRoom chatroomName:%s, oldVer:%d, localVer:%d, stack[%s]", str, Integer.valueOf(i), Integer.valueOf(ciD), bi.chl());
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        return a(eVar, this.gLB, this);
    }

    public final int getType() {
        return 551;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        if (i2 == 0 && i3 == 0) {
            x.i("MicroMsg.NetSceneGetChatroomMemberDetail", "onGYNetEnd errType:%d, errCode:%d, errMsg:%s", Integer.valueOf(i2), Integer.valueOf(i3), str);
            abg abg = (abg) this.gLB.hnR.hnY;
            as.Hm();
            com.tencent.mm.sdk.e.c hH = c.Fo().hH(this.chatroomName);
            long ciD = (long) hH.ciD();
            long j = 4294967295L & ((long) abg.kyx);
            String str2 = "MicroMsg.NetSceneGetChatroomMemberDetail";
            String str3 = "summerChatRoom svrVer:%d, modCnt:%d， localVer:%d";
            Object[] objArr = new Object[3];
            objArr[0] = Integer.valueOf(abg.kyx);
            objArr[1] = Integer.valueOf(abg.wra == null ? 0 : abg.wra.lfj);
            objArr[2] = Long.valueOf(ciD);
            x.i(str2, str3, objArr);
            if (ciD >= j) {
                x.e("MicroMsg.NetSceneGetChatroomMemberDetail", "summerChatRoom localVer[%d] serverVer[%d] is new and return", Long.valueOf(ciD), Long.valueOf(j));
                this.gLE.a(i2, i3, str, this);
                return;
            }
            int i4;
            final LinkedList linkedList;
            int i5 = abg.kyx;
            if (hH.b(hH.xuR)) {
                hH.ciC();
            }
            hH.xuR.fBU = i5;
            try {
                hH.field_roomdata = hH.xuR.toByteArray();
            } catch (Throwable e) {
                x.e("MicroMsg.ChatRoomMember", "exception:%s", bi.i(e));
            }
            com.tencent.mm.storage.q.ciF();
            if (abg.wra == null) {
                List list = null;
            } else {
                Object list2 = abg.wra.wbU;
            }
            String str4 = "MicroMsg.NetSceneGetChatroomMemberDetail";
            str2 = "summerChatRoom memInfoList size[%d]";
            Object[] objArr2 = new Object[1];
            objArr2[0] = Integer.valueOf(list2 == null ? -1 : list2.size());
            x.i(str4, str2, objArr2);
            str2 = com.tencent.mm.y.q.FY();
            if (hH.b(hH.xuR)) {
                hH.ciC();
            }
            for (mn mnVar : list2) {
                if (hH.hsr.containsKey(mnVar.kyG)) {
                    com.tencent.mm.h.a.a.b bVar = (com.tencent.mm.h.a.a.b) hH.hsr.get(mnVar.kyG);
                    bVar.gDt = mnVar.wbX;
                    bVar.gDu = mnVar.wca;
                    bVar.gDv = mnVar.wcb;
                }
            }
            hH.xuR.gDp.clear();
            for (String str5 : hH.hsr.keySet()) {
                hH.xuR.gDp.add(hH.hsr.get(str5));
            }
            hH.a(str2, hH.xuR, false);
            as.Hm();
            c.Fo().a(hH);
            as.Hm();
            ar Ff = c.Ff();
            com.tencent.mm.ac.i JW = n.JW();
            LinkedList linkedList2 = new LinkedList();
            LinkedList linkedList3 = new LinkedList();
            x.i("MicroMsg.NetSceneGetChatroomMemberDetail", "summerChatRoom memInfoList size[%d]", Integer.valueOf(list2 == null ? -1 : list2.size()));
            if (((long) (list2 == null ? -1 : list2.size())) > HardCoderJNI.hcUpdateChatroomMemberCount) {
                i4 = 0;
            } else {
                int cgq;
                boolean z = HardCoderJNI.hcUpdateChatroomEnable;
                int i6 = HardCoderJNI.hcUpdateChatroomDelay;
                int i7 = HardCoderJNI.hcUpdateChatroomCPU;
                int i8 = HardCoderJNI.hcUpdateChatroomIO;
                if (HardCoderJNI.hcUpdateChatroomThr) {
                    cgq = g.Dt().cgq();
                } else {
                    cgq = 0;
                }
                i4 = HardCoderJNI.startPerformance(z, i6, i7, i8, cgq, HardCoderJNI.hcUpdateChatroomTimeout, 401, HardCoderJNI.hcUpdateChatroomAction, "MicroMsg.NetSceneGetChatroomMemberDetail");
            }
            this.hGs = i4;
            for (mn mnVar2 : list2) {
                if (!(bi.oN(mnVar2.wbZ) || bi.oN(mnVar2.kyG))) {
                    h jp = JW.jp(mnVar2.kyG);
                    if (jp == null) {
                        jp = new h();
                        jp.username = mnVar2.kyG;
                    } else {
                        jp.JN().equals(mnVar2.wbZ);
                    }
                    jp.hni = mnVar2.wbY;
                    jp.hnh = mnVar2.wbZ;
                    jp.fWZ = 3;
                    jp.bC(!bi.oN(mnVar2.wbY));
                    linkedList3.add(jp);
                }
                com.tencent.mm.storage.x Xv = Ff.Xv(mnVar2.kyG);
                if (Xv == null) {
                    x.e("MicroMsg.NetSceneGetChatroomMemberDetail", "NetSceneGetChatroomMemberDetail memberlist username is null");
                } else if (Xv.AL()) {
                    Xv.dc(mnVar2.kzN);
                    linkedList2.add(new Pair(mnVar2.kyG, Xv));
                }
            }
            x.d("MicroMsg.NetSceneGetChatroomMemberDetail", "summerChatRoom update newImgFlagList size:%d, updateList size:%d", Integer.valueOf(linkedList3.size()), Integer.valueOf(linkedList2.size()));
            if (!linkedList3.isEmpty()) {
                this.lfd |= 1;
                linkedList = linkedList3;
                final com.tencent.mm.ac.i iVar = JW;
                new al(as.Dt().oFY.getLooper(), new al.a() {
                    public final boolean uG() {
                        int size = linkedList.size() < 25 ? linkedList.size() : 25;
                        x.d("MicroMsg.NetSceneGetChatroomMemberDetail", "summerChatRoom update img list size:%d, loopCount:%d", Integer.valueOf(linkedList.size()), Integer.valueOf(size));
                        if (size == 0) {
                            i.a(i.this, 1);
                            x.i("MicroMsg.NetSceneGetChatroomMemberDetail", "summerChatRoom update img done loopCount is 0");
                            return false;
                        } else if (linkedList.isEmpty()) {
                            i.a(i.this, 1);
                            x.i("MicroMsg.NetSceneGetChatroomMemberDetail", "summerChatRoom update img done newImgFlagList is empty");
                            return false;
                        } else {
                            long currentTimeMillis = System.currentTimeMillis();
                            as.Hm();
                            long dA = c.Fc().dA(Thread.currentThread().getId());
                            for (int i = 0; i < size; i++) {
                                h hVar = (h) linkedList.poll();
                                if (hVar == null) {
                                    break;
                                }
                                iVar.a(hVar);
                            }
                            as.Hm();
                            c.Fc().fT(dA);
                            x.d("MicroMsg.NetSceneGetChatroomMemberDetail", "summerChatRoom update img loopCount:%d, take time:%d(ms)", Integer.valueOf(size), Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                            if (!linkedList.isEmpty()) {
                                return true;
                            }
                            i.a(i.this, 1);
                            x.i("MicroMsg.NetSceneGetChatroomMemberDetail", "summerChatRoom update img done newImgFlagList is empty");
                            return false;
                        }
                    }
                }, true).K(100, 100);
            }
            if (!linkedList2.isEmpty()) {
                this.lfd |= 2;
                linkedList = linkedList2;
                final ar arVar = Ff;
                new al(as.Dt().oFY.getLooper(), new al.a() {
                    public final boolean uG() {
                        int size = linkedList.size() < 25 ? linkedList.size() : 25;
                        x.d("MicroMsg.NetSceneGetChatroomMemberDetail", "summerChatRoom update ctg list size:%d, loopCount:%d", Integer.valueOf(linkedList.size()), Integer.valueOf(size));
                        if (size == 0) {
                            i.a(i.this, 2);
                            x.i("MicroMsg.NetSceneGetChatroomMemberDetail", "summerChatRoom update ctg done loopCount is 0");
                            return false;
                        }
                        long currentTimeMillis = System.currentTimeMillis();
                        as.Hm();
                        long dA = c.Fc().dA(Thread.currentThread().getId());
                        for (int i = 0; i < size; i++) {
                            Pair pair = (Pair) linkedList.poll();
                            arVar.a((String) pair.first, (com.tencent.mm.storage.x) pair.second);
                        }
                        as.Hm();
                        c.Fc().fT(dA);
                        x.d("MicroMsg.NetSceneGetChatroomMemberDetail", "summerChatRoom update ctg loopCount:%d, take time:%d(ms)", Integer.valueOf(size), Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                        if (!linkedList.isEmpty()) {
                            return true;
                        }
                        i.a(i.this, 2);
                        x.i("MicroMsg.NetSceneGetChatroomMemberDetail", "summerChatRoom update ctg done updateList is empty");
                        return false;
                    }
                }, true).K(100, 100);
            }
            this.gLE.a(i2, i3, str, this);
            return;
        }
        x.e("MicroMsg.NetSceneGetChatroomMemberDetail", "onGYNetEnd errType:%d, errCode:%d, errMsg:%s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        this.gLE.a(i2, i3, str, this);
    }
}
