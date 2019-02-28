package com.tencent.mm.ui.chatting.b;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.mm.f.a.pl;
import com.tencent.mm.f.b.ak;
import com.tencent.mm.f.b.cg;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelmulti.b;
import com.tencent.mm.modelmulti.b.c;
import com.tencent.mm.modelmulti.q;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.plugin.report.d;
import com.tencent.mm.protocal.c.by;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.as.a;
import com.tencent.mm.storage.au;
import com.tencent.mm.y.as;

public final class w implements c, a {
    public static int yJP = 350;
    public p fhH;
    public boolean yJQ = false;
    public boolean yJR = false;
    public int yJS = -1;
    public int yJT = -1;
    public boolean yJU = true;
    public boolean yJV = false;
    public com.tencent.mm.sdk.b.c yJW = new com.tencent.mm.sdk.b.c<pl>() {
        {
            this.xmG = pl.class.getName().hashCode();
        }

        private boolean a(pl plVar) {
            byte[] bArr = plVar.fIi.data;
            if (bArr != null) {
                by byVar = new by();
                try {
                    byVar.aH(bArr);
                    final String a = n.a(byVar.vNV);
                    x.i("MicroMsg.ChattingUI.SilenceMsgImp", "summerbadcr SilenceNotifyEvent callback chatRoomId[%s], current talker[%s]", a, w.this.fhH.csW().field_username);
                    if (!bi.oN(a) && a.equals(w.this.fhH.csW().field_username)) {
                        final int i = byVar.vNU;
                        final int i2 = byVar.vNW;
                        as.Dt().F(new Runnable() {
                            public final void run() {
                                long j;
                                long j2;
                                x.i("MicroMsg.ChattingUI.SilenceMsgImp", "summerbadcr SilenceNotifyEvent in chatting lastSeq[%d], undeliverCount[%d]", Integer.valueOf(i), Integer.valueOf(i2));
                                long j3 = (long) i;
                                long j4 = (long) i;
                                long j5 = (long) i2;
                                long Fz = ((h) g.h(h.class)).aZO().Fz(a);
                                if (Fz <= 0 || Fz >= j4) {
                                    j = j5;
                                    j2 = j4;
                                } else {
                                    j = (Fz - Fz) - 1;
                                    j2 = Fz;
                                }
                                if (j <= 0) {
                                    j4 = 1;
                                } else {
                                    j4 = j;
                                }
                                x.i("MicroMsg.ChattingUI.SilenceMsgImp", "summerbadcr SilenceNotifyEvent in chatting down [%d, %d, %d, %d]", Long.valueOf(j3), Long.valueOf(j2), Long.valueOf(Fz), Long.valueOf(j4));
                                w.this.yJQ = false;
                                q.Qk().a(new b.a(a, (int) j3, (int) j2, (int) j4, 0), w.this);
                            }
                        });
                    }
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.ChattingUI.SilenceMsgImp", e, "summerbadcr SilenceNotifyEvent callback parse:", new Object[0]);
                }
            } else {
                x.e("MicroMsg.ChattingUI.SilenceMsgImp", "summerbadcr silenceNotifyListener callback event data is null");
            }
            return false;
        }
    };
    private boolean yJX = false;

    /* renamed from: com.tencent.mm.ui.chatting.b.w$2 */
    class AnonymousClass2 implements Runnable {
        final /* synthetic */ au yKc;

        public AnonymousClass2(au auVar) {
            this.yKc = auVar;
        }

        public final void run() {
            d.pVE.a(403, 7, 1, false);
            w.this.aQ(this.yKc);
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.b.w$3 */
    class AnonymousClass3 implements Runnable {
        final /* synthetic */ ae yFB;
        final /* synthetic */ int yKd;

        public AnonymousClass3(int i, ae aeVar) {
            this.yKd = i;
            this.yFB = aeVar;
        }

        public final void run() {
            long j;
            x.i("MicroMsg.ChattingUI.SilenceMsgImp", "summerbadcr mGoBackToHistryMsgLayout try get undeliver msg from firstseq[%d]", Integer.valueOf(this.yKd));
            long j2 = this.yFB.field_lastSeq;
            as.Hm();
            cg FA = com.tencent.mm.y.c.Fh().FA(this.yFB.field_username);
            if (FA == null || FA.field_msgId <= 0) {
                j = j2;
            } else {
                j = FA.field_msgSeq;
            }
            w.this.yJQ = true;
            x.i("MicroMsg.ChattingUI.SilenceMsgImp", "summerbadcr mGoBackToHistryMsgLayout get msg mUnreadMessageBeforeCheckHistory[%d], filterSeq[%d], firstSeq[%d]", Integer.valueOf(w.this.yJS), Long.valueOf(j), Integer.valueOf(this.yKd));
            q.Qk().a(new b.a(this.yFB.field_username, (int) j, this.yKd, 18, 0), w.this);
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.b.w$12 */
    class AnonymousClass12 implements Runnable {
        final /* synthetic */ au hgJ;

        public AnonymousClass12(au auVar) {
            this.hgJ = auVar;
        }

        public final void run() {
            d.pVE.a(403, 6, 1, false);
            w.this.aQ(this.hgJ);
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.b.w$5 */
    class AnonymousClass5 implements Runnable {
        final /* synthetic */ String hGk;
        final /* synthetic */ int yKa;
        final /* synthetic */ long yKf;
        final /* synthetic */ long yKg;

        public AnonymousClass5(String str, long j, long j2, int i) {
            this.hGk = str;
            this.yKf = j;
            this.yKg = j2;
            this.yKa = i;
        }

        public final void run() {
            w.this.fhH.ctn().mu(false);
            w.this.fhH.ctn().mv(true);
            w.this.fhH.ctn().my(true);
            x.i("MicroMsg.ChattingUI.SilenceMsgImp", "summerbadcr forceBottomLoadData true needCheckHistoryTips true");
            w.this.yJQ = false;
            w.this.yJR = true;
            d.pVE.a(403, 5, 1, false);
            q.Qk().a(new b.a(this.hGk, (int) this.yKf, (int) this.yKg, this.yKa, 1), w.this);
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.b.w$4 */
    class AnonymousClass4 implements OnGlobalLayoutListener {
        final /* synthetic */ long gAc;

        public AnonymousClass4(long j) {
            this.gAc = j;
        }

        public final void onGlobalLayout() {
            x.i("MicroMsg.ChattingUI.SilenceMsgImp", "summerbadcr needCheckHistoryTips onGlobalLayout run delay[%d], BADCR_SCROLL_DELAY[%d] needCheckHistoryTips[%b]", Long.valueOf(System.currentTimeMillis() - this.gAc), Integer.valueOf(w.yJP), Boolean.valueOf(w.this.yJR));
            w.this.fhH.ctl().getViewTreeObserver().removeGlobalOnLayoutListener(this);
            w.this.fhH.mT(false);
            w.this.fhH.ctl().postDelayed(new Runnable() {
                public final void run() {
                    x.i("MicroMsg.ChattingUI.SilenceMsgImp", "summerbadcr needCheckHistoryTips run scrollToLastProtect BADCR_SCROLL_DELAY[%d]", Integer.valueOf(w.yJP));
                    w.this.fhH.mT(true);
                }
            }, (long) w.yJP);
        }
    }

    public w(p pVar) {
        this.fhH = pVar;
    }

    public final String Qa() {
        if (this.fhH.csS()) {
            return this.fhH.csW().field_username;
        }
        return "";
    }

    public final void id(int i) {
        x.i("MicroMsg.ChattingUI.SilenceMsgImp", "summerbadcr onGetFinish retcode[%d] thread[%d], dealHistoryGetMsg[%b], needCheckHistoryTips[%b]", Integer.valueOf(i), Long.valueOf(Thread.currentThread().getId()), Boolean.valueOf(this.yJQ), Boolean.valueOf(this.yJR));
        if (i == 0 && this.yJQ) {
            as.Hm();
            ak XF = com.tencent.mm.y.c.Fk().XF(this.fhH.csW().field_username);
            if (XF != null) {
                int i2 = XF.field_unReadCount;
                int i3 = XF.field_UnDeliverCount;
                as.Hm();
                int Fs = (com.tencent.mm.y.c.Fh().Fs(this.fhH.csW().field_username) - this.yJS) - i2;
                if (!(this.yJT == -1 || this.yJT - this.yJS == Fs)) {
                    Fs = this.yJT;
                }
                x.i("MicroMsg.ChattingUI.SilenceMsgImp", "summerbadcr onGetFinish unReadCount[%d] unDeliverCount[%d] beforemsgCount[%d], msgCount[%d] pos[%d] lastMessageCount[%d]", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(this.yJS), Integer.valueOf(r3), Integer.valueOf(Fs), Integer.valueOf(this.yJT));
                this.yJT = -1;
                ah.y(new Runnable() {
                    public final void run() {
                        x.i("MicroMsg.ChattingUI.SilenceMsgImp", "summerbadcr onGetFinish mLastBigFault[%s] skipNextTopLoad true", Boolean.valueOf(w.this.yJX));
                        if (w.this.yJX) {
                            w.this.fhH.ag(Fs, true);
                            w.this.yJX = false;
                        }
                        w.this.yJV = true;
                    }
                });
                return;
            }
            return;
        }
        ah.y(new Runnable() {
            public final void run() {
                w.this.fhH.ctn().mx(false);
                if (w.this.yJR) {
                    w.this.yJR = false;
                    w.this.fhH.ctn().mu(w.this.fhH.ctm().csB());
                    w.this.fhH.ctn().mv(w.this.fhH.ctr());
                    w.this.fhH.ctn().my(false);
                    x.i("MicroMsg.ChattingUI.SilenceMsgImp", "summerbadcr onGetFinish set needCheckHistoryTips[%b]", Boolean.valueOf(w.this.yJR));
                }
            }
        });
    }

    public final boolean Qb() {
        return this.yJQ;
    }

    public final void a(ae aeVar, com.tencent.mm.storage.as asVar) {
        x.i("MicroMsg.ChattingUI.SilenceMsgImp", "summerbadcr onMsgChangeNotify cvs.getUsername[%s] tid[%d]", aeVar.field_username, Long.valueOf(Thread.currentThread().getId()));
        if (this.fhH.csS() && this.fhH.csW().field_username.equals(aeVar.field_username)) {
            int i = aeVar.field_msgCount;
            int i2 = this.fhH.ctm().hLP;
            x.i("MicroMsg.ChattingUI.SilenceMsgImp", "summerbadcr onMsgChangeNotify newCvsCount[%d], total[%d], dealHistoryGetMsg[%b], UnDeliverCount[%d]", Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(this.yJQ), Integer.valueOf(aeVar.field_UnDeliverCount));
            if (i > i2) {
                cg cgVar = aeVar.xGE;
                if (cgVar != null && cgVar.field_msgId != 0) {
                    if (i - i2 > 1) {
                        this.yJX = true;
                    }
                    int i3 = cgVar.field_flag;
                    x.i("MicroMsg.ChattingUI.SilenceMsgImp", "summerbadcr onMsgChangeNotify receive get msg svrId[%d], seq[%d], flag[%d], stack[%s]", Long.valueOf(cgVar.field_msgSvrId), Long.valueOf(cgVar.field_msgSeq), Integer.valueOf(i3), bi.chl());
                    if ((i3 & 2) == 0) {
                        return;
                    }
                    int i4;
                    if (this.fhH.ctl() == null || this.fhH.ctm() == null || this.fhH.ctn() == null) {
                        x.i("MicroMsg.ChattingUI.SilenceMsgImp", "summerbadcr something is null %s %s %s", this.fhH.ctl(), this.fhH.ctm(), this.fhH.ctn());
                    } else if ((i3 & 4) == 0) {
                        x.i("MicroMsg.ChattingUI.SilenceMsgImp", "summerbadcr onMsgChangeNotify down dealHistoryGetMsg: %b", Boolean.valueOf(this.yJQ));
                        if (this.yJQ) {
                            x.i("MicroMsg.ChattingUI.SilenceMsgImp", "summerbadcr onMsgChangeNotify down but dealHistoryGetMsg so ignore");
                            return;
                        }
                        final int firstVisiblePosition = this.fhH.ctl().getFirstVisiblePosition();
                        i3 = this.fhH.ctm().getCount();
                        this.fhH.ctm().csy();
                        i4 = i - i2;
                        x.i("MicroMsg.ChattingUI.SilenceMsgImp", "summerbadcr onMsgChangeNotify down talker[%s],firstVisiblePosition:%d, new oldTotal[%d,%d,%d], now preCount:[%d,%d,%d] fromcount:%d, needCheckHistoryTips:%b", this.fhH.csW().field_username, Integer.valueOf(firstVisiblePosition), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i4), Integer.valueOf(this.fhH.ctm().getCount()), Integer.valueOf(i3), Integer.valueOf(this.fhH.ctm().getCount() - i3), Integer.valueOf(this.fhH.ctm().ljs), Boolean.valueOf(this.yJR));
                        if (this.fhH.ctm().getCount() - i3 > 1) {
                            ViewGroup ctl = this.fhH.ctl();
                            int firstVisiblePosition2 = ctl.getFirstVisiblePosition();
                            View view = (firstVisiblePosition < firstVisiblePosition2 || firstVisiblePosition > (ctl.getChildCount() + firstVisiblePosition2) - 1) ? ctl.getAdapter().getView(firstVisiblePosition, null, ctl) : ctl.getChildAt(firstVisiblePosition - firstVisiblePosition2);
                            i = (view == null ? 0 : view.getTop()) - this.fhH.ctn().ykX;
                            this.fhH.ctl().setAdapter(this.fhH.ctm());
                            t.a(this.fhH.ctl(), firstVisiblePosition, i, false);
                            x.i("MicroMsg.ChattingUI.SilenceMsgImp", "summerbadcr firstVisiblePosition %s firstView %s scrollY %s %s", Integer.valueOf(firstVisiblePosition), view, Integer.valueOf(i3), Integer.valueOf(i));
                            this.fhH.ctl().post(new Runnable() {
                                public final void run() {
                                    t.a(w.this.fhH.ctl(), firstVisiblePosition, i, false);
                                    x.i("MicroMsg.ChattingUI.SilenceMsgImp", "summerbadcr firstVisiblePosition 111 %s %s %s", Integer.valueOf(w.this.fhH.ctl().getFirstVisiblePosition()), Integer.valueOf(w.this.fhH.ctl().getLastVisiblePosition()), Integer.valueOf(w.this.fhH.ctm().getCount()));
                                }
                            });
                            this.fhH.ctl().postDelayed(new Runnable() {
                                public final void run() {
                                    t.a(w.this.fhH.ctl(), firstVisiblePosition, i, false);
                                    x.i("MicroMsg.ChattingUI.SilenceMsgImp", "summerbadcr firstVisiblePosition 222 %s %s %s", Integer.valueOf(w.this.fhH.ctl().getFirstVisiblePosition()), Integer.valueOf(w.this.fhH.ctl().getLastVisiblePosition()), Integer.valueOf(w.this.fhH.ctm().getCount()));
                                }
                            }, 200);
                        }
                    } else {
                        i4 = this.fhH.ctl().getFirstVisiblePosition();
                        int lastVisiblePosition = this.fhH.ctl().getLastVisiblePosition();
                        au auVar = (au) this.fhH.ctm().getItem(i4);
                        au auVar2 = (au) this.fhH.ctm().getItem(lastVisiblePosition);
                        int count = this.fhH.ctm().getCount();
                        this.fhH.ctm().csy();
                        int i5 = i - i2;
                        final int count2 = this.fhH.ctm().getCount() - count;
                        x.i("MicroMsg.ChattingUI.SilenceMsgImp", "summerbadcr onMsgChangeNotify up talker[%s],new oldTotal[%d,%d,%d], now preCount:[%d,%d,%d] fromcount:%d needCheckHistoryTips:%b", this.fhH.csW().field_username, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i5), Integer.valueOf(this.fhH.ctm().getCount()), Integer.valueOf(count), Integer.valueOf(count2), Integer.valueOf(this.fhH.ctm().ljs), Boolean.valueOf(this.yJR));
                        if (auVar2 != null && auVar2.field_msgId != 0 && auVar2.field_createTime < cgVar.field_createTime) {
                            x.i("MicroMsg.ChattingUI.SilenceMsgImp", "summerbadcr lastVisibleMsg getCreateTime < lastInsert msg");
                        } else if (count2 <= 0 || this.fhH.ctm().ljs < 0) {
                            x.i("MicroMsg.ChattingUI.SilenceMsgImp", "summerbadcr onMsgChangeNotify up incTotal incCount[%d, %d, %d] keep same", Integer.valueOf(i5), Integer.valueOf(count2), Integer.valueOf(this.fhH.ctm().ljs));
                        } else {
                            long j;
                            long j2;
                            this.fhH.ctm().FP(count2);
                            String str = "MicroMsg.ChattingUI.SilenceMsgImp";
                            String str2 = "summerbadcr firstVisiblePosition %s, lastVisiblePosition %s, createtime[%s, %s, %s]";
                            Object[] objArr = new Object[5];
                            objArr[0] = Integer.valueOf(i4);
                            objArr[1] = Integer.valueOf(lastVisiblePosition);
                            if (auVar == null) {
                                j = -1;
                            } else {
                                j = auVar.field_createTime;
                            }
                            objArr[2] = Long.valueOf(j);
                            if (auVar2 == null) {
                                j2 = -1;
                            } else {
                                j2 = auVar2.field_createTime;
                            }
                            objArr[3] = Long.valueOf(j2);
                            objArr[4] = Long.valueOf(cgVar.field_createTime);
                            x.i(str, str2, objArr);
                            x.i("MicroMsg.ChattingUI.SilenceMsgImp", "summerbadcr onMsgChangeNotify up nowCount > preCount on set select:%d position %d, firstVisiblePosition %s", Integer.valueOf(count2), Integer.valueOf(count2 + 1), Integer.valueOf(i4));
                            this.fhH.ctm().mM(true);
                            t.a(this.fhH.ctl(), count2 + 1, this.fhH.ctC() + this.fhH.ctn().ykW, false);
                            ah.y(new Runnable() {
                                public final void run() {
                                    t.a(w.this.fhH.ctl(), count2 + 1, w.this.fhH.ctC() + w.this.fhH.ctn().ykW, false);
                                    w.this.fhH.ctm().unlock();
                                }
                            });
                        }
                        this.fhH.ctn().mx(false);
                        this.fhH.ctm().yCg = true;
                        if (aeVar.field_UnDeliverCount <= 0) {
                            this.fhH.ctI();
                        }
                        if (this.yJR) {
                            this.yJR = false;
                            this.fhH.ctn().mu(this.fhH.ctm().csB());
                            this.fhH.ctn().mv(this.fhH.ctr());
                            this.fhH.ctn().my(false);
                            x.i("MicroMsg.ChattingUI.SilenceMsgImp", "summerbadcr onMsgChangeNotify set needCheckHistoryTips[%b]", Boolean.valueOf(this.yJR));
                            final ae aeVar2 = aeVar;
                            this.fhH.ctg().postDelayed(new Runnable() {
                                public final void run() {
                                    x.i("MicroMsg.ChattingUI.SilenceMsgImp", "summerbadcr onMsgChangeNotify updateGoBacktoHistroyMessage up UnDeliver:%d, UnRead:%d", Integer.valueOf(aeVar2.field_UnDeliverCount), Integer.valueOf(aeVar2.field_unReadCount));
                                    w.this.fhH.a(aeVar2, true);
                                }
                            }, 500);
                        }
                    }
                }
            }
        }
    }

    public final void aQ(au auVar) {
        if (auVar != null && auVar.field_msgId != 0) {
            long j;
            long j2 = auVar.field_msgSeq;
            boolean z = (auVar.field_flag & 4) != 0;
            int i = 18;
            as.Hm();
            ak XF = com.tencent.mm.y.c.Fk().XF(this.fhH.csW().field_username);
            if (XF != null) {
                j = z ? XF.field_firstUnDeliverSeq : XF.field_lastSeq;
                if (z && j == 0) {
                    i = XF.field_UnDeliverCount;
                }
                if (z && j > j2) {
                    cg U = ((h) g.h(h.class)).aZO().U(this.fhH.csW().field_username, j2);
                    if (U != null && U.field_msgSeq < j2) {
                        x.i("MicroMsg.ChattingUI.SilenceMsgImp", "summerbadcr getChatroomMsgWithFaultMsg revised filterSeq[%d] to [%d]", Long.valueOf(j), Long.valueOf(U.field_msgSeq));
                        j = U.field_msgSeq;
                    }
                }
            } else {
                j = 0;
            }
            x.i("MicroMsg.ChattingUI.SilenceMsgImp", "summerbadcr getChatroomMsgWithFaultMsg filterSeq[%d], lastSeq[%d], needCount[%d], flag[%d], up[%b]", Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i), Integer.valueOf(auVar.field_flag), Boolean.valueOf(z));
            this.yJQ = false;
            q.Qk().a(new b.a(this.fhH.csW().field_username, (int) j, (int) j2, i, z ? 1 : 0), (c) this);
        }
    }
}
