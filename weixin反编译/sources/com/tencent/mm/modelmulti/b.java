package com.tencent.mm.modelmulti;

import com.tencent.mm.ad.k;
import com.tencent.mm.ad.u;
import com.tencent.mm.f.b.ak;
import com.tencent.mm.f.b.cg;
import com.tencent.mm.hardcoder.HardCoderJNI;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.plugin.bbom.q;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.plugin.report.d;
import com.tencent.mm.protocal.c.abb;
import com.tencent.mm.protocal.c.abc;
import com.tencent.mm.protocal.c.bx;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.au;
import com.tencent.mm.y.as;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public final class b implements com.tencent.mm.sdk.e.j.a {
    Queue<b> hAk = new LinkedList();
    al hAo = new al(as.Dt().oFY.getLooper(), new com.tencent.mm.sdk.platformtools.al.a() {
        public final boolean uG() {
            x.i("MicroMsg.GetChatRoomMsgService", "summerbadcr pusherTry onTimerExpired tryStartNetscene");
            b bVar = b.this;
            long Wy = t.Wy();
            if (bVar.hmq && Wy - bVar.hmA > 300000) {
                x.w("MicroMsg.GetChatRoomMsgService", "summerbadcr tryStartNetscene Not Callback too long:%d . Force Run Now", Long.valueOf(Wy - bVar.hmA));
                bVar.hmq = false;
            }
            if (bVar.hmq) {
                x.i("MicroMsg.GetChatRoomMsgService", "summerbadcr tryStartNetscene netSceneRunning: " + bVar.hmq + " ret");
            } else {
                a aVar;
                String str = null;
                a aVar2 = null;
                if (!bVar.hGn.isEmpty()) {
                    aVar = (a) bVar.hGn.poll();
                    str = aVar.hGv;
                    aVar2 = aVar;
                }
                if (aVar2 == null) {
                    synchronized (bVar.hGm) {
                        x.i("MicroMsg.GetChatRoomMsgService", "summerbadcr tryStartNetscene needGetInfosMap size[%d], content[%s]", Integer.valueOf(bVar.hGm.size()), bVar.hGm);
                        if (bVar.hGo == null || t.oN(bVar.hGo.Qa())) {
                            bVar.hGm.clear();
                            bVar.hGo = null;
                            x.i("MicroMsg.GetChatRoomMsgService", "summerbadcr tryStartNetscene currentListener is or its chatroomid is null ret");
                        } else {
                            str = bVar.hGo.Qa();
                            LinkedList linkedList = (LinkedList) bVar.hGm.get(str);
                            if (linkedList == null || linkedList.size() == 0) {
                                String str2 = "MicroMsg.GetChatRoomMsgService";
                                String str3 = "summerbadcr tryStartNetscene current talker[%s] no infos and ret infos size:%d";
                                Object[] objArr = new Object[2];
                                objArr[0] = str;
                                objArr[1] = Integer.valueOf(linkedList == null ? -1 : linkedList.size());
                                x.i(str2, str3, objArr);
                            } else {
                                while (!linkedList.isEmpty()) {
                                    a aVar3 = (a) linkedList.poll();
                                    if (aVar3 == null) {
                                        break;
                                    }
                                    as.Hm();
                                    cg H = com.tencent.mm.y.c.Fh().H(str, (long) aVar3.hGx);
                                    if (H.field_msgId == 0) {
                                        x.i("MicroMsg.GetChatRoomMsgService", "summerbadcr tryStartNetscene get nextInfo in map not in db:" + aVar3);
                                        aVar = aVar3;
                                        break;
                                    } else if ((H.field_flag & 1) != 0) {
                                        x.i("MicroMsg.GetChatRoomMsgService", "summerbadcr tryStartNetscene get nextInfo in map in db but fault: " + aVar3 + " flag:" + H.field_flag + " seq:" + H.field_msgSeq);
                                        aVar = aVar3;
                                        break;
                                    } else if (aVar3.hGz == 0) {
                                        x.i("MicroMsg.GetChatRoomMsgService", "summerbadcr tryStartNetscene get nextInfo in map in db not fault but down history: " + aVar3 + " flag:" + H.field_flag + " seq:" + H.field_msgSeq);
                                        aVar = aVar3;
                                        break;
                                    } else {
                                        x.i("MicroMsg.GetChatRoomMsgService", "summerbadcr tryStartNetscene get nextInfo in map in db but not fault: " + aVar3 + " flag:" + H.field_flag + " seq:" + H.field_msgSeq);
                                    }
                                }
                                aVar = aVar2;
                                if (aVar == null && !t.oN(str)) {
                                    as.Hm();
                                    ae XF = com.tencent.mm.y.c.Fk().XF(str);
                                    if (XF != null) {
                                        long j = XF.field_lastSeq;
                                        long j2 = XF.field_firstUnDeliverSeq;
                                        int i = XF.field_UnDeliverCount;
                                        x.i("MicroMsg.GetChatRoomMsgService", "summerbadcr tryStartNetscene filterSeq[%d], lastSeq[%d], undeliverCount[%d]", Long.valueOf(j2), Long.valueOf(j), Integer.valueOf(i));
                                        if (j != 0) {
                                            as.Hm();
                                            if (com.tencent.mm.y.c.Fh().H(str, j).field_msgId == 0) {
                                                aVar = new a(str, (int) j2, (int) j, i, 1);
                                                x.i("MicroMsg.GetChatRoomMsgService", "summerbadcr tryStartNetscene get nextInfo in db:" + aVar);
                                            } else {
                                                if (i > 0) {
                                                    XF.eP(0);
                                                    as.Hm();
                                                    com.tencent.mm.y.c.Fk().a(XF, str);
                                                }
                                                x.i("MicroMsg.GetChatRoomMsgService", "summerbadcr tryStartNetscene get nextInfo in db but has get msg id:%d, svrId:%d, undeliverCount[%d]", Long.valueOf(r5.field_msgId), Long.valueOf(r5.field_msgSvrId), Integer.valueOf(XF.field_UnDeliverCount));
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                } else {
                    aVar = aVar2;
                }
                x.i("MicroMsg.GetChatRoomMsgService", "summerbadcr tryStartNetscene nextInfo:" + aVar);
                if (aVar == null) {
                    bVar.hAo.K(500, 500);
                } else {
                    bVar.hmq = true;
                    bVar.hmA = Wy;
                    com.tencent.mm.bp.a abb = new abb();
                    abb.wqN = n.oK(str);
                    abb.vNU = aVar.hGx;
                    if (aVar.hGx == 0) {
                        abb.wqO = 0;
                        if (aVar.hGy != 0) {
                            x.w("MicroMsg.GetChatRoomMsgService", "summerbadcr tryStartNetscene msgSeq is 0 but needCount[%d], stack[%s]!", Integer.valueOf(aVar.hGy), t.WB());
                        }
                    } else {
                        abb.wqO = 18;
                    }
                    abb.wqP = aVar.hGz;
                    abb.wqR = aVar.hGw;
                    if ((abb.wqP != 0 && abb.wqR > abb.vNU) || (abb.wqP == 0 && abb.wqR < abb.vNU)) {
                        x.w("MicroMsg.GetChatRoomMsgService", "summerbadcr tryStartNetscene FilterSeq msgSeq UpDownFlag not match[%d][%d][%d], stack[%s]!", Integer.valueOf(abb.wqR), Integer.valueOf(abb.vNU), Integer.valueOf(abb.wqP), t.WB());
                        d.pVE.a(403, abb.wqP == 0 ? 0 : 1, 1, false);
                        int i2 = abb.wqR;
                        abb.wqR = abb.vNU;
                        abb.vNU = i2;
                    }
                    if (abb.wqP != 0 && abb.wqR == 0 && aVar.hGy < 18) {
                        if (aVar.hGy > 0) {
                            abb.wqO = aVar.hGy;
                        } else {
                            abb.wqO = 1;
                            d.pVE.a(403, 3, 1, false);
                        }
                        x.i("MicroMsg.GetChatRoomMsgService", "summerbadcr tryStartNetscene UpDownFlag FilterSeq 0 fix need nextInfo: %d req: %d", Integer.valueOf(aVar.hGy), Integer.valueOf(abb.wqO));
                    }
                    x.i("MicroMsg.GetChatRoomMsgService", "summerbadcr tryStartNetscene FilterSeq[%d], MsgSeq[%d], NeedCount[%d], UpDownFlag[%d], ClearFlag[%d]", Integer.valueOf(abb.wqR), Integer.valueOf(abb.vNU), Integer.valueOf(abb.wqO), Integer.valueOf(abb.wqP), Integer.valueOf(abb.wqQ));
                    com.tencent.mm.ad.b.a aVar4 = new com.tencent.mm.ad.b.a();
                    aVar4.hnT = abb;
                    aVar4.hnU = new abc();
                    aVar4.uri = "/cgi-bin/micromsg-bin/getcrmsg";
                    aVar4.hnS = 805;
                    aVar4.hnV = 0;
                    aVar4.hnW = 0;
                    d.pVE.a(403, abb.vNU == 0 ? 9 : 8, 1, false);
                    u.a(aVar4.Kf(), new com.tencent.mm.ad.u.a() {
                        public final int a(int i, int i2, String str, com.tencent.mm.ad.b bVar, k kVar) {
                            x.i("MicroMsg.GetChatRoomMsgService", "summerbadcr callback [%d,%d,%s]", Integer.valueOf(i), Integer.valueOf(i2), str);
                            if (kVar.getType() != 805) {
                                return 0;
                            }
                            b.this.hGr.TN();
                            d.pVE.a(403, 10, 1, false);
                            b.this.hmq = false;
                            if (i == 0 && i2 == 0 && bVar != null) {
                                abb abb = (abb) bVar.hnQ.hnY;
                                abc abc = (abc) bVar.hnR.hnY;
                                String a = n.a(abb.wqN);
                                String str2;
                                if (abb.vNU == 0) {
                                    String str3 = "MicroMsg.GetChatRoomMsgService";
                                    str2 = "summerbadcr clear chatroomId[%s], resp size[%d], ContinueFlag[%d]";
                                    Object[] objArr = new Object[3];
                                    objArr[0] = a;
                                    objArr[1] = Integer.valueOf(abc.wqS == null ? -1 : abc.wqS.size());
                                    objArr[2] = Integer.valueOf(abc.vWu);
                                    x.i(str3, str2, objArr);
                                    if (b.this.hAo.cgx()) {
                                        b.this.hAo.K(500, 500);
                                    }
                                    d.pVE.a(403, 12, 1, false);
                                    return 0;
                                }
                                int cgq;
                                String str4;
                                int i3;
                                x.i("MicroMsg.GetChatRoomMsgService", "summerbadcr callback req chatroomId[%s], resp ContinueFlag[%d]", a, Integer.valueOf(abc.vWu));
                                b bVar2 = b.this;
                                boolean z = HardCoderJNI.hcReceiveMsgEnable;
                                int i4 = HardCoderJNI.hcReceiveMsgDelay;
                                int i5 = HardCoderJNI.hcReceiveMsgCPU;
                                int i6 = HardCoderJNI.hcReceiveMsgIO;
                                if (HardCoderJNI.hcReceiveMsgThr) {
                                    cgq = g.Dt().cgq();
                                } else {
                                    cgq = 0;
                                }
                                bVar2.hGs = HardCoderJNI.startPerformance(z, i4, i5, i6, cgq, HardCoderJNI.hcReceiveMsgTimeout, 201, HardCoderJNI.hcReceiveMsgAction, "MicroMsg.GetChatRoomMsgService");
                                synchronized (b.this.hGm) {
                                    if (b.this.hGo == null || t.oN(b.this.hGo.Qa())) {
                                        b.this.hGm.clear();
                                        b.this.hGo = null;
                                        x.i("MicroMsg.GetChatRoomMsgService", "summerbadcr callback currentListener is or its chatroomid is null so clear map");
                                        d.pVE.a(403, 15, 1, false);
                                    } else if (b.this.hGo.Qa().equals(a)) {
                                        d.pVE.a(403, 13, 1, false);
                                        LinkedList linkedList = abc.wqS;
                                        str4 = "MicroMsg.GetChatRoomMsgService";
                                        String str5 = "summerbadcr callback currentListener still in and resp.ContinueFlag[%d], size[%d]";
                                        Object[] objArr2 = new Object[2];
                                        objArr2[0] = Integer.valueOf(abc.vWu);
                                        objArr2[1] = Integer.valueOf(linkedList == null ? -1 : linkedList.size());
                                        x.i(str4, str5, objArr2);
                                        if (!(abc.vWu <= 0 || linkedList == null || linkedList.isEmpty())) {
                                            i5 = ((bx) linkedList.getFirst()).vNU;
                                            i3 = ((bx) linkedList.getLast()).vNU;
                                            x.i("MicroMsg.GetChatRoomMsgService", "summerbadcr callback ContinueFlag[%d], list size[%d],firstSeq[%d], lastSeq[%d], UpDownFlag[%d]", Integer.valueOf(abc.vWu), Integer.valueOf(linkedList.size()), Integer.valueOf(i5), Integer.valueOf(i3), Integer.valueOf(abb.wqP));
                                        }
                                    } else {
                                        x.i("MicroMsg.GetChatRoomMsgService", "summerbadcr callback currentListener changed current[%s], old[%s]", b.this.hGo.Qa(), a);
                                        d.pVE.a(403, 14, 1, false);
                                    }
                                }
                                if (b.this.hAo.cgx()) {
                                    b.this.hAo.K(500, 500);
                                }
                                if (abc.wqS == null || abc.wqS.isEmpty()) {
                                    d.pVE.a(403, 19, 1, false);
                                    str2 = "MicroMsg.GetChatRoomMsgService";
                                    str4 = "summerbadcr callback resp.AddMsgList is null[%b], empty[%b]";
                                    Object[] objArr3 = new Object[2];
                                    objArr3[0] = Boolean.valueOf(b.this.hAk == null);
                                    objArr3[1] = Boolean.valueOf(b.this.hAk != null ? b.this.hAk.isEmpty() : true);
                                    x.i(str2, str4, objArr3);
                                    if (abc.vWu == 0 && abb.wqP != 0) {
                                        as.Hm();
                                        au H = com.tencent.mm.y.c.Fh().H(a, (long) abb.vNU);
                                        int i7;
                                        if (H.field_msgSeq == ((long) abb.vNU)) {
                                            i7 = H.field_flag;
                                            x.i("MicroMsg.GetChatRoomMsgService", "summerbadcr callback resp.AddMsgList is empty reset Fault[%d, %d, %d, %d, %d, %d, %d]", Integer.valueOf(H.field_flag), Integer.valueOf(H.field_isSend), Long.valueOf(H.field_msgId), Long.valueOf(H.field_msgSvrId), Long.valueOf(H.field_msgSeq), Long.valueOf(H.field_createTime), Integer.valueOf(H.getType()));
                                            if ((i7 & 1) != 0) {
                                                long j;
                                                H.fb(i7 & -2);
                                                as.Hm();
                                                com.tencent.mm.y.c.Fh().a(H.field_msgId, H);
                                                d dVar = d.pVE;
                                                if (t.bA(H.field_createTime) < 259200000) {
                                                    j = 36;
                                                } else {
                                                    j = 37;
                                                }
                                                dVar.a(403, j, 1, false);
                                            }
                                        } else {
                                            as.Hm();
                                            ae XF = com.tencent.mm.y.c.Fk().XF(a);
                                            if (XF != null) {
                                                as.Hm();
                                                cg Fe = com.tencent.mm.y.c.Fh().Fe(a);
                                                if (Fe != null) {
                                                    x.i("MicroMsg.GetChatRoomMsgService", "summerbadcr callback resp.AddMsgList is empty need reset lastseq by last receive id[%d] svrid[%d], flag[%d] createtime[%d] seq[%d -> %d]", Long.valueOf(Fe.field_msgId), Long.valueOf(Fe.field_msgSvrId), Integer.valueOf(Fe.field_flag), Long.valueOf(Fe.field_createTime), Long.valueOf(XF.field_lastSeq), Long.valueOf(Fe.field_msgSeq));
                                                    XF.al(Fe.field_msgSeq);
                                                } else {
                                                    x.i("MicroMsg.GetChatRoomMsgService", "summerbadcr callback resp.AddMsgList is empty but no receive msg!");
                                                    XF.al(0);
                                                }
                                                XF.eX(0);
                                                as.Hm();
                                                i7 = com.tencent.mm.y.c.Fk().a(XF, XF.field_username, false);
                                                x.i("MicroMsg.GetChatRoomMsgService", "summerbadcr callback resp.AddMsgList is empty and update conv ret:%d", Integer.valueOf(i7));
                                            } else {
                                                x.i("MicroMsg.GetChatRoomMsgService", "summerbadcr callback resp.AddMsgList but conv is null!");
                                            }
                                        }
                                    }
                                } else {
                                    boolean z2;
                                    boolean z3;
                                    b bVar3 = new b();
                                    bVar3.hGv = a;
                                    bVar3.hGz = abb.wqP;
                                    bVar3.hGC = abc.vWu;
                                    if (abc.vWu == 0) {
                                        bVar3.hGB = false;
                                        d.pVE.a(403, 21, 1, false);
                                    } else {
                                        d.pVE.a(403, 20, 1, false);
                                    }
                                    as.Hm();
                                    ae XF2 = com.tencent.mm.y.c.Fk().XF(a);
                                    if (abb.wqP != 0) {
                                        d.pVE.a(403, 18, (long) abc.wqS.size(), false);
                                        i4 = (XF2 == null ? 0 : XF2.field_UnDeliverCount) - abc.wqS.size();
                                        if (i4 < 0) {
                                            i4 = 0;
                                        }
                                        if (XF2 != null) {
                                            XF2.eX(i4);
                                            as.Hm();
                                            i5 = com.tencent.mm.y.c.Fk().a(XF2, XF2.field_username, false);
                                            x.i("MicroMsg.GetChatRoomMsgService", "summerbadcr callback up and FilterSeq 0 but NeedCount:%d, oldUnDeliverCount:%d, newUnDeliverCount:%d, ret:%d", Integer.valueOf(abb.wqO), Integer.valueOf(i3), Integer.valueOf(XF2.field_UnDeliverCount), Integer.valueOf(i5));
                                        }
                                        if (XF2 == null && i4 == 0) {
                                            bVar3.hGB = false;
                                        }
                                    } else {
                                        if (abb.wqR <= 0 || abb.wqR != abb.vNU) {
                                            d.pVE.a(403, 16, (long) abc.wqS.size(), false);
                                        } else {
                                            d.pVE.a(403, 17, (long) abc.wqS.size(), false);
                                        }
                                        if (XF2 != null) {
                                            i4 = XF2.field_UnDeliverCount;
                                            if (i4 > 0) {
                                                i3 = i4 - abc.wqS.size();
                                                if (i3 < 0) {
                                                    i3 = 0;
                                                }
                                                XF2.eX(i3);
                                                as.Hm();
                                                i3 = com.tencent.mm.y.c.Fk().a(XF2, XF2.field_username, false);
                                                x.i("MicroMsg.GetChatRoomMsgService", "summerbadcr callback down NeedCount:%d, oldUnDeliverCount:%d, newUnDeliverCount:%d, ret:%d", Integer.valueOf(abb.wqO), Integer.valueOf(i4), Integer.valueOf(XF2.field_UnDeliverCount), Integer.valueOf(i3));
                                            }
                                        }
                                    }
                                    as.Hm();
                                    i5 = (int) com.tencent.mm.y.c.FQ().EX(a);
                                    z = false;
                                    if (i5 != 0) {
                                        while (true) {
                                            z2 = z;
                                            if (abc.wqS.isEmpty() || ((bx) abc.wqS.peek()).vNU > i5) {
                                                break;
                                            }
                                            abc.wqS.poll();
                                            z = true;
                                        }
                                    } else {
                                        z2 = false;
                                    }
                                    if (z2) {
                                        bVar3.hGB = false;
                                    }
                                    if (abb.wqP == 0 || abc.wqS.isEmpty()) {
                                        z3 = false;
                                    } else {
                                        z3 = true;
                                    }
                                    if (abc.wqS.size() > 1 && z3) {
                                        Collections.reverse(abc.wqS);
                                    }
                                    if (!abc.wqS.isEmpty()) {
                                        bVar3.hGA = abc.wqS;
                                        b.this.hAk.add(bVar3);
                                        x.i("MicroMsg.GetChatRoomMsgService", "summerbadcr callback add resp to respList size[%d], dealFault[%b], lastDeleteSeq[%d], needReverse[%b], removed[%b]", Integer.valueOf(b.this.hAk.size()), Boolean.valueOf(bVar3.hGB), Integer.valueOf(i5), Boolean.valueOf(z3), Boolean.valueOf(z2));
                                    }
                                }
                                if (b.this.hAk.isEmpty() || !b.this.hAp.cgx()) {
                                    if (b.this.hGo != null) {
                                        x.i("MicroMsg.GetChatRoomMsgService", "summerbadcr callback resp.AddMsgList is empty[%b] stopped[%b] at last", Boolean.valueOf(b.this.hAk.isEmpty()), Boolean.valueOf(b.this.hAp.cgx()));
                                        b.this.hGo.id(1);
                                    }
                                    HardCoderJNI.stopPerformace(HardCoderJNI.hcReceiveMsgEnable, b.this.hGs);
                                } else {
                                    b.this.hAp.K(50, 50);
                                }
                                return 0;
                            }
                            x.e("MicroMsg.GetChatRoomMsgService", "summerbadcr callback errType:" + i + " errCode:" + i2 + " will retry");
                            if (b.this.hGo != null) {
                                x.e("MicroMsg.GetChatRoomMsgService", "summerbadcr callback err as ret errType, errcode[%d, %d]", Integer.valueOf(i), Integer.valueOf(i2));
                                b.this.hGo.id(1);
                            }
                            d.pVE.a(403, 11, 1, false);
                            b.this.hAo.K(5000, 5000);
                            return 0;
                        }
                    }, true);
                    bVar.hGr.K(5000, 5000);
                }
            }
            return false;
        }
    }, false);
    final al hAp = new al(as.Dt().oFY.getLooper(), new com.tencent.mm.sdk.platformtools.al.a() {
        private com.tencent.mm.plugin.messenger.foundation.a.g hGu;

        public final boolean uG() {
            as.Hm();
            com.tencent.mm.y.c.Fh().EZ("MicroMsg.GetChatRoomMsgService" + b.this.hashCode());
            if (b.this.hAk.isEmpty()) {
                x.i("MicroMsg.GetChatRoomMsgService", "summerbadcr respHandler queue maybe this time is null and return!");
                as.Hm();
                com.tencent.mm.y.c.Fh().Fa("MicroMsg.GetChatRoomMsgService" + b.this.hashCode());
                HardCoderJNI.stopPerformace(HardCoderJNI.hcReceiveMsgEnable, b.this.hGs);
                return false;
            }
            boolean z;
            long Wy = t.Wy();
            int i = (b.this.hmq ? 9 : 18) + 1;
            x.i("MicroMsg.GetChatRoomMsgService", "summerbadcr respHandler start maxCnt[%d]", Integer.valueOf(i));
            int i2 = 0;
            while (i2 < i) {
                b bVar = (b) b.this.hAk.peek();
                if (bVar == null) {
                    x.i("MicroMsg.GetChatRoomMsgService", "summerbadcr respHandler queue maybe this time is null and break! currentListener[%s]", b.this.hGo);
                    as.Hm();
                    com.tencent.mm.y.c.Fh().Fa("MicroMsg.GetChatRoomMsgService" + b.this.hashCode());
                    z = false;
                    if (b.this.hGo != null) {
                        b.this.hGo.id(0);
                    }
                    HardCoderJNI.stopPerformace(HardCoderJNI.hcReceiveMsgEnable, b.this.hGs);
                    b.this.hAo.K(0, 0);
                } else {
                    LinkedList linkedList = bVar.hGA;
                    int size = linkedList.size();
                    int i3 = size - 1;
                    int i4 = bVar.hAx;
                    if (size <= i4) {
                        b.this.hAk.poll();
                        if (b.this.hAk.isEmpty()) {
                            b.e(new HashMap(b.this.hGp), bVar.hGv);
                            as.Hm();
                            com.tencent.mm.y.c.Fh().Fa("MicroMsg.GetChatRoomMsgService" + b.this.hashCode());
                            String str = "MicroMsg.GetChatRoomMsgService";
                            String str2 = "summerbadcr respHandler resp proc fin gr.curIdx:%d size:%d and retList is empty break currentListener[%s], needCallBack[%b]";
                            Object[] objArr = new Object[4];
                            objArr[0] = Integer.valueOf(i4);
                            objArr[1] = Integer.valueOf(size);
                            objArr[2] = b.this.hGo;
                            objArr[3] = Boolean.valueOf(b.this.hGo == null ? false : b.this.hGo.Qb());
                            x.i(str, str2, objArr);
                            z = false;
                            if (b.this.hGo != null) {
                                b.this.hGo.id(0);
                            }
                            b.this.hAo.K(0, 0);
                        } else {
                            x.i("MicroMsg.GetChatRoomMsgService", "summerbadcr respHandler resp proc fin gr.curIdx:%d size:%d and retList is not empty continue next", Integer.valueOf(i4), Integer.valueOf(size));
                        }
                    } else {
                        boolean z2;
                        au H;
                        long j;
                        au H2;
                        bx bxVar = (bx) linkedList.get(i4);
                        x.d("MicroMsg.GetChatRoomMsgService", "summerbadcr respHandler process curIdx[%d] last[%d] dealFault[%b] MsgSeq[%d], CreateTime[%d], MsgType[%d]", Integer.valueOf(i4), Integer.valueOf(i3), Boolean.valueOf(bVar.hGB), Integer.valueOf(bxVar.vNU), Integer.valueOf(bxVar.pgR), Integer.valueOf(bxVar.nlX));
                        int i5 = -1;
                        if (bVar.hGB && i4 == i3) {
                            if (bVar.hGC != 0) {
                                boolean z3 = true;
                                as.Hm();
                                cg H3 = com.tencent.mm.y.c.Fh().H(bVar.hGv, (long) bxVar.vNU);
                                if (bVar.hGz == 0 && (H3.field_flag & 4) != 0) {
                                    as.Hm();
                                    ak XF = com.tencent.mm.y.c.Fk().XF(bVar.hGv);
                                    if (XF != null && XF.field_UnDeliverCount == 0) {
                                        z3 = false;
                                        x.i("MicroMsg.GetChatRoomMsgService", "summerbadcr respHandler process existed 1 curIdx == last[%d], MsgSeq[%d], flag[%d]", Integer.valueOf(i4), Long.valueOf(H3.field_msgSeq), Integer.valueOf(H3.field_flag));
                                    }
                                }
                                z2 = z3;
                            } else {
                                as.Hm();
                                if (com.tencent.mm.y.c.Fh().H(bVar.hGv, (long) bxVar.vNU).field_msgId == 0) {
                                    as.Hm();
                                    ak XF2 = com.tencent.mm.y.c.Fk().XF(bVar.hGv);
                                    if (XF2 == null) {
                                        z2 = true;
                                    } else {
                                        boolean z4;
                                        int i6;
                                        if ((bVar.hGz == 0 || XF2.field_firstUnDeliverSeq == ((long) bxVar.vNU)) && (bVar.hGz != 0 || XF2.field_lastSeq == ((long) bxVar.vNU))) {
                                            z4 = false;
                                            i6 = -1;
                                        } else {
                                            z4 = true;
                                            i6 = XF2.field_UnDeliverCount;
                                        }
                                        z2 = z4;
                                        i5 = i6;
                                    }
                                } else {
                                    x.i("MicroMsg.GetChatRoomMsgService", "summerbadcr respHandler process existed 2 curIdx == last[%d], MsgSeq[%d], flag[%d]", Integer.valueOf(i4), Long.valueOf(com.tencent.mm.y.c.Fh().H(bVar.hGv, (long) bxVar.vNU).field_msgSeq), Integer.valueOf(com.tencent.mm.y.c.Fh().H(bVar.hGv, (long) bxVar.vNU).field_flag));
                                }
                            }
                            x.i("MicroMsg.GetChatRoomMsgService", "summerbadcr respHandler process fault[%b] curIdx[%d] last[%d], upFlag[%d]，MsgSeq[%d]", Boolean.valueOf(z2), Integer.valueOf(i4), Integer.valueOf(i3), Integer.valueOf(bVar.hGz), Integer.valueOf(bxVar.vNU));
                            if (this.hGu == null) {
                                this.hGu = (com.tencent.mm.plugin.messenger.foundation.a.g) g.h(com.tencent.mm.plugin.messenger.foundation.a.g.class);
                            }
                            this.hGu.a(new com.tencent.mm.ad.d.a(bxVar, true, z2, bVar.hGz == 0), new q(true));
                            if (z2 && i5 == 0 && size > 1 && bVar.hGz == 0) {
                                as.Hm();
                                H = com.tencent.mm.y.c.Fh().H(bVar.hGv, (long) bxVar.vNU);
                                i5 = H.field_flag;
                                j = H.field_createTime;
                                x.i("MicroMsg.GetChatRoomMsgService", "summerbadcr respHandler process check fault meet size[%d], seq[%d], flag[%d], creatTime[%d]", Integer.valueOf(size), Integer.valueOf(bxVar.vNU), Integer.valueOf(i5), Long.valueOf(j));
                                if ((i5 & 4) == 0) {
                                    as.Hm();
                                    H2 = com.tencent.mm.y.c.Fh().H(bVar.hGv, (long) (bxVar.vNU + 1));
                                    if (H2.field_msgId == 0 && H2.field_msgSeq == ((long) (bxVar.vNU + 1))) {
                                        x.i("MicroMsg.GetChatRoomMsgService", "summerbadcr respHandler process check fault meet seq[%d], creatTime[%d], flag[%d]", Long.valueOf(H2.field_msgSeq), Long.valueOf(H2.field_createTime), Integer.valueOf(H2.field_flag));
                                        if ((H2.field_flag & 4) != 0) {
                                            H.fb(H.field_flag & -2);
                                            as.Hm();
                                            com.tencent.mm.y.c.Fh().a(H.field_msgId, H);
                                            H2.fb(H2.field_flag & -2);
                                            as.Hm();
                                            com.tencent.mm.y.c.Fh().a(H2.field_msgId, H2);
                                            x.i("MicroMsg.GetChatRoomMsgService", "summerbadcr respHandler process check fault meet update succ!");
                                            d.pVE.a(403, 34, 1, false);
                                        }
                                    } else {
                                        x.i("MicroMsg.GetChatRoomMsgService", "summerbadcr respHandler process check fault meet nextinfo is null[%b], id[%d], seq[%d]", Boolean.valueOf(false), Long.valueOf(H2.field_msgId), Long.valueOf(H2.field_msgSeq));
                                    }
                                }
                            }
                            bVar.hAx++;
                        }
                        z2 = false;
                        x.i("MicroMsg.GetChatRoomMsgService", "summerbadcr respHandler process fault[%b] curIdx[%d] last[%d], upFlag[%d]，MsgSeq[%d]", Boolean.valueOf(z2), Integer.valueOf(i4), Integer.valueOf(i3), Integer.valueOf(bVar.hGz), Integer.valueOf(bxVar.vNU));
                        if (this.hGu == null) {
                            this.hGu = (com.tencent.mm.plugin.messenger.foundation.a.g) g.h(com.tencent.mm.plugin.messenger.foundation.a.g.class);
                        }
                        if (bVar.hGz == 0) {
                        }
                        this.hGu.a(new com.tencent.mm.ad.d.a(bxVar, true, z2, bVar.hGz == 0), new q(true));
                        as.Hm();
                        H = com.tencent.mm.y.c.Fh().H(bVar.hGv, (long) bxVar.vNU);
                        i5 = H.field_flag;
                        j = H.field_createTime;
                        x.i("MicroMsg.GetChatRoomMsgService", "summerbadcr respHandler process check fault meet size[%d], seq[%d], flag[%d], creatTime[%d]", Integer.valueOf(size), Integer.valueOf(bxVar.vNU), Integer.valueOf(i5), Long.valueOf(j));
                        if ((i5 & 4) == 0) {
                            as.Hm();
                            H2 = com.tencent.mm.y.c.Fh().H(bVar.hGv, (long) (bxVar.vNU + 1));
                            if (H2.field_msgId == 0) {
                            }
                            x.i("MicroMsg.GetChatRoomMsgService", "summerbadcr respHandler process check fault meet nextinfo is null[%b], id[%d], seq[%d]", Boolean.valueOf(false), Long.valueOf(H2.field_msgId), Long.valueOf(H2.field_msgSeq));
                        }
                        bVar.hAx++;
                    }
                    i2++;
                }
                x.i("MicroMsg.GetChatRoomMsgService", "summerbadcr respHandler onTimerExpired netSceneRunning:" + b.this.hmq + " ret:" + z + " maxCnt:" + i + " take:" + (t.Wy() - Wy) + "ms");
                return z;
            }
            z = true;
            x.i("MicroMsg.GetChatRoomMsgService", "summerbadcr respHandler onTimerExpired netSceneRunning:" + b.this.hmq + " ret:" + z + " maxCnt:" + i + " take:" + (t.Wy() - Wy) + "ms");
            return z;
        }
    }, true);
    Map<String, LinkedList<a>> hGm = new HashMap();
    LinkedBlockingQueue<a> hGn = new LinkedBlockingQueue();
    c hGo;
    Map<Long, ao> hGp = new HashMap();
    com.tencent.mm.plugin.messenger.foundation.a.a.c.a hGq = new com.tencent.mm.plugin.messenger.foundation.a.a.c.a() {
        public final void a(com.tencent.mm.plugin.messenger.foundation.a.a.c cVar, com.tencent.mm.plugin.messenger.foundation.a.a.c.c cVar2) {
            if (cVar != null && cVar2 != null) {
                try {
                    if (cVar2.ouB != null && cVar2.ouA != null && cVar2.ouA.equals("delete")) {
                        x.i("MicroMsg.GetChatRoomMsgService", "summerbadcr msgListener delete msg count[%s] list[%s]", Integer.valueOf(cVar2.ouE), Integer.valueOf(cVar2.ouB.size()));
                        Iterator it = cVar2.ouB.iterator();
                        while (it.hasNext()) {
                            cg cgVar = (au) it.next();
                            if (!(cgVar == null || cgVar.field_msgId == 0 || cgVar.field_msgSeq <= 0 || (cgVar.field_flag & 1) == 0)) {
                                au U;
                                x.i("MicroMsg.GetChatRoomMsgService", "summerbadcr msgListener check fault[%d, %d, %d, %d, %d, %d, %d, %s]", Integer.valueOf(cgVar.field_flag), Integer.valueOf(cgVar.field_isSend), Long.valueOf(cgVar.field_msgId), Long.valueOf(cgVar.field_msgSvrId), Long.valueOf(cgVar.field_msgSeq), Long.valueOf(cgVar.field_createTime), Integer.valueOf(cgVar.getType()), cgVar.field_talker);
                                if ((cgVar.field_flag & 4) == 0) {
                                    U = ((h) g.h(h.class)).aZO().U(cgVar.field_talker, cgVar.field_msgSeq);
                                } else {
                                    cg U2 = ((h) g.h(h.class)).aZO().T(cgVar.field_talker, cgVar.field_msgSeq);
                                }
                                if (!(U2 == null || U2.field_msgId == 0)) {
                                    x.i("MicroMsg.GetChatRoomMsgService", "summerbadcr msgListener delete msg check next fault[%d, %d, %d, %d, %d, %d, %d, %s]", Integer.valueOf(U2.field_flag), Integer.valueOf(U2.field_isSend), Long.valueOf(U2.field_msgId), Long.valueOf(U2.field_msgSvrId), Long.valueOf(U2.field_msgSeq), Long.valueOf(U2.field_createTime), Integer.valueOf(U2.getType()), U2.field_talker);
                                    U2.fb(cgVar.field_flag);
                                    ((h) g.h(h.class)).aZO().a(U2.field_msgId, U2);
                                }
                            }
                        }
                    }
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.GetChatRoomMsgService", e, "delete msg", new Object[0]);
                }
            }
        }
    };
    al hGr = new al(as.Dt().oFY.getLooper(), new com.tencent.mm.sdk.platformtools.al.a() {
        public final boolean uG() {
            x.i("MicroMsg.GetChatRoomMsgService", "summerbadcr timeoutHandler onTimerExpired");
            if (b.this.hGo != null) {
                b.this.hGo.id(2);
            }
            d.pVE.a(403, 41, 1, false);
            return false;
        }
    }, false);
    int hGs;
    long hmA = 0;
    boolean hmq = false;

    class b {
        int hAx = 0;
        LinkedList<bx> hGA = new LinkedList();
        boolean hGB = true;
        int hGC = 0;
        String hGv;
        int hGz = 0;

        b() {
        }
    }

    public interface c {
        String Qa();

        boolean Qb();

        void id(int i);
    }

    public static class a {
        final String hGv;
        final int hGw;
        final int hGx;
        final int hGy;
        final int hGz;

        public a(String str, int i, int i2, int i3, int i4) {
            this.hGv = str;
            this.hGw = i;
            this.hGx = i2;
            this.hGy = i3;
            this.hGz = i4;
        }

        public final boolean equals(Object obj) {
            if (hashCode() == obj.hashCode()) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            if (this.hGw == aVar.hGw && this.hGx == aVar.hGx && this.hGy == aVar.hGy && this.hGz == aVar.hGz && this.hGv.equals(aVar.hGv)) {
                return true;
            }
            return false;
        }

        public final String toString() {
            return "GetChatRoomMsgInfo chatroomId[" + this.hGv + "], filterSeq[" + this.hGw + "], msgSeq[" + this.hGx + "], needCount[" + this.hGy + "], upDownFlag[" + this.hGz + "], hash[" + hashCode() + "]";
        }
    }

    static /* synthetic */ void e(Map map, String str) {
        if (map.size() != 0 && !t.oN(str)) {
            Iterator it = map.values().iterator();
            if (it != null) {
                while (it.hasNext()) {
                    ao aoVar = (ao) it.next();
                    if (aoVar != null && str.equals(aoVar.field_fromUserName)) {
                        as.Hm();
                        if (com.tencent.mm.y.c.Fh().G(str, aoVar.field_originSvrId).field_msgId != 0) {
                            x.i("MicroMsg.GetChatRoomMsgService", "summerbadcr dealSysCmdMsg msg id[%d], originsvrid[%d]", Long.valueOf(com.tencent.mm.y.c.Fh().G(str, aoVar.field_originSvrId).field_msgId), Long.valueOf(com.tencent.mm.y.c.Fh().G(str, aoVar.field_originSvrId).field_msgSvrId));
                            bx bxVar = new bx();
                            bxVar.vNT = aoVar.field_newMsgId;
                            bxVar.vNM = n.oK(aoVar.field_fromUserName);
                            bxVar.vNN = n.oK(aoVar.field_toUserName);
                            bxVar.pgR = (int) aoVar.field_createTime;
                            bxVar.vNO = n.oK(aoVar.field_content);
                            bxVar.vNR = aoVar.field_msgSource;
                            bxVar.vNU = aoVar.field_msgSeq;
                            int i = aoVar.field_flag;
                            bxVar.nlX = 10002;
                            d.pVE.a(403, 35, 1, false);
                            as.getSysCmdMsgExtension().b(new com.tencent.mm.ad.d.a(bxVar, (i & 2) != 0, (i & 1) != 0, (i & 4) != 0));
                        }
                    }
                }
            }
        }
    }

    b() {
    }

    public final void a(String str, l lVar) {
        if (!t.oN(str)) {
            try {
                long longValue = Long.valueOf(str).longValue();
                com.tencent.mm.sdk.e.c aoVar = new ao();
                aoVar.field_originSvrId = longValue;
                if (q.Ql().Qi().b(aoVar, new String[0])) {
                    this.hGp.put(Long.valueOf(longValue), aoVar);
                    x.i("MicroMsg.GetChatRoomMsgService", "summerbadcr onNotifyChange put info systemRowid[%d], svrId[%d]", Long.valueOf(aoVar.xrR), Long.valueOf(longValue));
                    return;
                }
                this.hGp.remove(Long.valueOf(longValue));
                x.i("MicroMsg.GetChatRoomMsgService", "summerbadcr onNotifyChange remove info svrId[%d]", Long.valueOf(longValue));
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.GetChatRoomMsgService", e, "summerbadcr onNotifyChange:", new Object[0]);
            }
        }
    }

    public final boolean a(a aVar, c cVar) {
        if (!b(aVar, cVar)) {
            return false;
        }
        this.hAo.K(0, 0);
        return true;
    }

    public final boolean a(a aVar) {
        if (aVar.hGx != 0) {
            return false;
        }
        x.i("MicroMsg.GetChatRoomMsgService", "summerbadcr clearChatRoomMsg info:%s, stack[%s]", aVar, t.WB());
        if (!this.hGn.add(aVar)) {
            return false;
        }
        this.hAo.K(0, 0);
        return true;
    }

    private boolean b(a aVar, c cVar) {
        if (aVar == null || cVar == null || t.oN(aVar.hGv) || !aVar.hGv.equals(cVar.Qa())) {
            return false;
        }
        x.i("MicroMsg.GetChatRoomMsgService", "summerbadcr addChatRoomMsg info:%s", aVar);
        synchronized (this.hGm) {
            LinkedList linkedList = (LinkedList) this.hGm.get(aVar.hGv);
            if (linkedList == null) {
                x.i("MicroMsg.GetChatRoomMsgService", "summerbadcr addChatRoomMsg new infos and add ret:%b, infos[%d], needGetInfosMap[%s]", Boolean.valueOf(linkedList.add(aVar)), Integer.valueOf(new LinkedList().hashCode()), this.hGm);
                this.hGm.put(aVar.hGv, linkedList);
            } else {
                x.i("MicroMsg.GetChatRoomMsgService", "summerbadcr addChatRoomMsg infos size:%s ", Integer.valueOf(linkedList.size()));
                if (linkedList.contains(aVar)) {
                    x.i("MicroMsg.GetChatRoomMsgService", "summerbadcr addChatRoomMsg infos already exist %s ", aVar);
                } else {
                    linkedList.addLast(aVar);
                }
                x.i("MicroMsg.GetChatRoomMsgService", "summerbadcr addChatRoomMsg to infos first:%b, infos[%d], size:%d, needGetInfosMap[%s]", Boolean.valueOf(false), Integer.valueOf(linkedList.hashCode()), Integer.valueOf(linkedList.size()), this.hGm);
            }
            this.hGo = cVar;
        }
        return true;
    }
}
