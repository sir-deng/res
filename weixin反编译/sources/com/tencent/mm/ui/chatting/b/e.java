package com.tencent.mm.ui.chatting.b;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mm.R;
import com.tencent.mm.bl.d;
import com.tencent.mm.f.a.ao;
import com.tencent.mm.f.a.jx;
import com.tencent.mm.f.a.jy;
import com.tencent.mm.f.a.kc;
import com.tencent.mm.f.a.ro;
import com.tencent.mm.plugin.chatroom.d.k;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.q;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.u;
import com.tencent.mm.y.as;
import com.tencent.mm.y.m;
import com.tencent.mm.y.r;
import com.tencent.mm.y.s;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class e {
    public p fhH;
    public c yEL;
    public aa yEu;
    protected boolean yHH = false;
    protected Map<String, String> yHI = new HashMap();
    public c yHJ = new c<ao>() {
        {
            this.xmG = ao.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            ao aoVar = (ao) bVar;
            if ((aoVar instanceof ao) && e.this.fhH.csW() != null && !bi.oN(aoVar.fpA.username) && aoVar.fpA.username.equals(e.this.fhH.csW().field_username)) {
                e.this.cuc();
            }
            return false;
        }
    };
    public final a yHK = new a() {
        public final void a(String str, l lVar) {
            x.v("MicroMsg.ChattingUI.ChatroomImp", "roommember watcher notify " + str);
            if (e.this.yHH) {
                m.b(e.this.fhH.csn(), e.this.yHI);
            } else {
                e.this.yHI.clear();
            }
            if (!bi.oN(str)) {
                e.this.fhH.crM();
                e.this.fhH.cpZ();
                e.this.fhH.crN();
                e.this.yEu.mV(false);
            }
            e.this.fhH.ctm().a(null, null);
        }
    };
    public c yHL = new c<ro>() {
        {
            this.xmG = ro.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            ro roVar = (ro) bVar;
            if ((!(roVar instanceof ro) || e.this.fhH.csW().field_username.equals(roVar.fKj.userName)) && e.this.fhH.csW().field_username.toLowerCase().endsWith("@chatroom")) {
                h.b(e.this.fhH.cte().getContext(), e.this.fhH.cte().getMMString(R.l.eRC), null, true);
            }
            return false;
        }
    };
    public com.tencent.mm.pluginsdk.d.b yHM = new com.tencent.mm.pluginsdk.d.b() {
        public final void a(int i, int i2, String str, b bVar) {
            e.this.fhH.dismissDialog();
            if (bVar instanceof jx) {
                if (i == 0 && i2 == 0) {
                    if (i == 0 && i2 == 0) {
                        h.bu(e.this.fhH.cte().getContext(), e.this.fhH.cte().getMMString(R.l.eFx));
                    }
                } else if (i != 0 || i2 != 0) {
                    if (i2 == -2024) {
                        com.tencent.mm.g.a eC = com.tencent.mm.g.a.eC(str);
                        if (eC != null) {
                            eC.a(e.this.fhH.cte().getContext(), null, null);
                            return;
                        } else {
                            h.a(e.this.fhH.cte().getContext(), e.this.fhH.cte().getMMString(R.l.eFu), null, e.this.fhH.cte().getMMString(R.l.eFv), false, new OnClickListener() {
                                public final void onClick(DialogInterface dialogInterface, int i) {
                                }
                            });
                            return;
                        }
                    }
                    h.a(e.this.fhH.cte().getContext(), e.this.fhH.cte().getMMString(R.l.eFD), null, e.this.fhH.cte().getMMString(R.l.dGf), false, new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                        }
                    });
                }
            } else if (!(bVar instanceof kc)) {
            } else {
                if (i != 0 || i2 != 0) {
                    h.a(e.this.fhH.cte().getContext(), e.this.fhH.cte().getMMString(R.l.eFD), null, e.this.fhH.cte().getMMString(R.l.dGf), false, new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                        }
                    });
                } else if (i == 0 && i2 == 0) {
                    h.bu(e.this.fhH.cte().getContext(), e.this.fhH.cte().getMMString(R.l.eFs));
                }
            }
        }
    };

    /* renamed from: com.tencent.mm.ui.chatting.b.e$11 */
    class AnonymousClass11 implements OnClickListener {
        final /* synthetic */ int hNw = 1;
        final /* synthetic */ LinkedList yHz;

        AnonymousClass11(LinkedList linkedList, int i) {
            this.yHz = linkedList;
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            final b jxVar = new jx();
            Context context = e.this.fhH.cte().getContext();
            e.this.fhH.cte().getMMString(R.l.dGZ);
            e.this.fhH.b(h.a(context, e.this.fhH.cte().getMMString(R.l.eFl), true, new OnCancelListener() {
                public final void onCancel(DialogInterface dialogInterface) {
                    jxVar.fBQ.fBE = true;
                    com.tencent.mm.sdk.b.a.xmy.m(jxVar);
                }
            }));
            jxVar.fBQ.chatroomName = e.this.fhH.csW().field_username;
            jxVar.fBQ.fBS = this.yHz;
            jxVar.fBQ.scene = this.hNw;
            com.tencent.mm.sdk.b.a.xmy.m(jxVar);
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.b.e$3 */
    class AnonymousClass3 implements OnCancelListener {
        final /* synthetic */ k lgi;

        AnonymousClass3(k kVar) {
            this.lgi = kVar;
        }

        public final void onCancel(DialogInterface dialogInterface) {
            as.CN().c(this.lgi);
        }
    }

    public e(p pVar) {
        this.fhH = pVar;
    }

    public final boolean cua() {
        return this.yHH;
    }

    public final void cub() {
        if (s.eX(this.fhH.csn())) {
            this.yHH = m.gd(this.fhH.csn());
            if (this.yHH) {
                m.b(this.fhH.csn(), this.yHI);
            } else {
                this.yHI.clear();
            }
            x.d("MicroMsg.ChattingUI.ChatroomImp", "chatroom display  " + (this.yHH ? "show " : "not show"));
        } else if (this.yEL.yHs) {
            this.yHH = true;
        } else {
            this.yHH = false;
            this.yHI.clear();
        }
    }

    public final String gw(String str) {
        String gx = r.gx(str);
        if (!this.yEL.vus && !bi.oN(gx)) {
            return gx;
        }
        if (this.yHI.containsKey(str)) {
            gx = (String) this.yHI.get(str);
            if (!bi.oN(gx)) {
                return gx;
            }
        }
        if (this.yEL.vus) {
            return this.yEL.yvJ.gw(str);
        }
        return r.gw(str);
    }

    public final void cuc() {
        if (this.fhH.csW() == null) {
            x.e("MicroMsg.ChattingUI.ChatroomImp", "getChatroomMemberDetail() talker == null");
        } else if (s.eX(this.fhH.csW().field_username)) {
            x.d("MicroMsg.ChattingUI.ChatroomImp", "cpan[changeTalker]");
            new ag().postDelayed(new Runnable() {
                public final void run() {
                    as.Hm();
                    q hG = com.tencent.mm.y.c.Fo().hG(e.this.fhH.csW().field_username);
                    if (hG != null && hG.ciE()) {
                        x.d("MicroMsg.ChattingUI.ChatroomImp", "cpan[doScene NetSceneGetChatroomMemberDetail]");
                        b jyVar = new jy();
                        jyVar.fBT.chatroomName = e.this.fhH.csW().field_username;
                        jyVar.fBT.fBU = hG.ciD();
                        com.tencent.mm.sdk.b.a.xmy.m(jyVar);
                    }
                }
            }, 1000);
        }
    }

    public final void aA(LinkedList<String> linkedList) {
        as.Hm();
        q hG = com.tencent.mm.y.c.Fo().hG(this.fhH.csW().field_username);
        if (hG == null) {
            h.a(this.fhH.cte().getContext(), this.fhH.cte().getMMString(R.l.eFA), null, this.fhH.cte().getMMString(R.l.eFv), new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                }
            });
            return;
        }
        String str;
        String str2 = this.fhH.csW().field_username;
        List linkedList2 = new LinkedList();
        List My = hG.My();
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            str = (String) it.next();
            if (My != null && My.contains(str)) {
                linkedList2.add(str);
            }
        }
        if (linkedList2.size() == 0) {
            if (linkedList.size() == 1) {
                h.a(this.fhH.cte().getContext(), this.fhH.cte().getMMString(R.l.eFu), null, this.fhH.cte().getMMString(R.l.eFv), new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
            } else {
                h.a(this.fhH.cte().getContext(), this.fhH.cte().getMMString(R.l.eFq), null, this.fhH.cte().getMMString(R.l.eFv), new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
            }
        } else if (linkedList.size() == 1) {
            u cte = this.fhH.cte();
            int i = R.l.eFp;
            Object[] objArr = new Object[1];
            str = (String) linkedList.get(0);
            if (this.fhH.csR()) {
                as.Hm();
                com.tencent.mm.f.b.ag Xv = com.tencent.mm.y.c.Ff().Xv(str);
                if (!(Xv == null || ((int) Xv.gKO) == 0)) {
                    if (bi.oN(Xv.field_conRemark)) {
                        as.Hm();
                        hG = com.tencent.mm.y.c.Fo().hG(this.fhH.csW().field_username);
                        str = hG == null ? null : hG.gw(Xv.field_username);
                    } else {
                        str = Xv.field_conRemark;
                    }
                    if (bi.oN(str)) {
                        str = Xv.field_conRemark;
                    }
                    if (bi.oN(str)) {
                        str = Xv.AW();
                    }
                }
            } else {
                str = null;
            }
            objArr[0] = str;
            h.a(this.fhH.cte().getContext(), cte.getMMString(i, objArr), null, this.fhH.cte().getMMString(R.l.eFw), this.fhH.cte().getMMString(R.l.dEy), true, new AnonymousClass11(linkedList2, 1), new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                }
            });
        } else {
            Intent intent = new Intent();
            intent.putExtra("members", bi.d(linkedList2, ","));
            intent.putExtra("RoomInfo_Id", this.fhH.csW().field_username);
            intent.putExtra("scene", 1);
            d.b(this.fhH.cte().getContext(), "chatroom", ".ui.DelChatroomMemberUI", intent);
        }
    }
}
