package com.tencent.mm.pluginsdk.ui.applet;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.text.TextUtils;
import android.widget.Toast;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.f.a.jn;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.comm.a.h;
import com.tencent.mm.pluginsdk.model.o;
import com.tencent.mm.protocal.c.bub;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.storage.x;
import com.tencent.mm.ui.base.r;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;
import org.xwalk.core.XWalkUpdater;

public final class a implements e {
    private String chatroomName = "";
    private Context context;
    public String mTU = "";
    private LinkedList<String> pCm;
    private LinkedList<Integer> pCn;
    private r tipDialog;
    public String vtA;
    public String vtB;
    public boolean vtC = true;
    public boolean vtD = true;
    public String vtE = "";
    public boolean vtF = false;
    private a vtv;
    public b vtw;
    private LinkedList<String> vtx;
    public String vty;
    String vtz = "";

    public interface a {
        void a(boolean z, boolean z2, String str, String str2);
    }

    public interface b {
        boolean DD(String str);
    }

    public a(Context context, a aVar) {
        this.context = context;
        this.vtv = aVar;
        this.pCm = new LinkedList();
        this.vtx = new LinkedList();
        this.tipDialog = null;
    }

    public final void b(String str, String str2, LinkedList<Integer> linkedList) {
        this.chatroomName = str2;
        a(str, (LinkedList) linkedList, false, "");
    }

    public final void c(String str, LinkedList<Integer> linkedList) {
        a(str, (LinkedList) linkedList, false, "");
    }

    public final void a(String str, LinkedList<Integer> linkedList, String str2) {
        a(str, (LinkedList) linkedList, false, str2);
    }

    public final void SP(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.vtx.add(str);
        }
    }

    public final void b(String str, LinkedList<Integer> linkedList, boolean z) {
        a(str, (LinkedList) linkedList, z, "");
    }

    private void a(String str, LinkedList<Integer> linkedList, boolean z, String str2) {
        boolean z2 = str != null && str.length() > 0;
        Assert.assertTrue(z2);
        if (linkedList != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        Assert.assertTrue(z2);
        this.vtC = z;
        g.Dp().gRu.a(30, (e) this);
        g.Dp().gRu.a(667, (e) this);
        if (this.vtD) {
            Context context = this.context;
            this.context.getString(h.dGZ);
            this.tipDialog = com.tencent.mm.ui.base.h.a(context, this.context.getString(h.luh), true, new OnCancelListener() {
                public final void onCancel(DialogInterface dialogInterface) {
                    a.this.c(false, false, a.this.vtz, a.this.vtE);
                }
            });
        }
        this.pCn = linkedList;
        this.pCm.add(str);
        this.vtz = str;
        if (x.Xg(str)) {
            g.Dp().gRu.a(new com.tencent.mm.openim.b.a(str, this.vtx.isEmpty() ? "" : (String) this.vtx.getFirst()), 0);
            return;
        }
        k oVar = new o(1, this.pCm, linkedList, this.vtx, "", this.mTU, null, this.chatroomName, str2);
        if (!bi.oN(this.vtA)) {
            oVar.fj(this.vtA, this.vtB);
        }
        g.Dp().gRu.a(oVar, 0);
    }

    private void c(boolean z, boolean z2, String str, String str2) {
        if (this.vtv != null) {
            this.vtv.a(z, z2, str, str2);
        }
        if (z) {
            com.tencent.mm.sdk.b.b jnVar = new jn();
            jnVar.fAZ.username = str;
            com.tencent.mm.sdk.b.a.xmy.m(jnVar);
        }
    }

    public final void a(int i, int i2, String str, final k kVar) {
        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.AddContact", "onSceneEnd, errType = " + i + ", errCode = " + i2 + "," + str);
        if (kVar.getType() == 30 || kVar.getType() == 667) {
            if (this.tipDialog != null) {
                this.tipDialog.dismiss();
                this.tipDialog = null;
            }
            g.Dp().gRu.b(30, (e) this);
            g.Dp().gRu.b(667, (e) this);
            if (i == 0 && i2 == 0) {
                if (kVar.getType() == 30) {
                    this.vtz = ((o) kVar).bZf();
                } else if (kVar.getType() == 667) {
                    this.vtz = ((com.tencent.mm.openim.b.a) kVar).idC;
                }
                c(true, false, this.vtz, this.vtE);
                return;
            } else if (i2 == -44) {
                String str2 = this.vtE;
                if (this.vtw != null) {
                    this.vtw.DD(this.vtx.isEmpty() ? "" : (String) this.vtx.getFirst());
                    c(false, false, this.vtz, str2);
                    return;
                }
                q qVar = new q(this.context, new com.tencent.mm.pluginsdk.ui.applet.q.a() {
                    public final void ep(boolean z) {
                        a.this.c(false, z, a.this.vtz, a.this.vtE);
                    }
                });
                if (this.vty != null) {
                    qVar.vty = this.vty;
                }
                if (this.vtC) {
                    List list = this.pCm;
                    List list2 = this.pCn;
                    qVar.vvd = false;
                    qVar.onStart();
                    qVar.vvc = list;
                    qVar.pCn = list2;
                    if (list.size() == 1 && x.Xg((String) list.getFirst())) {
                        qVar.cbO();
                        return;
                    } else {
                        g.Dp().gRu.a(new o(2, list, list2, "", ""), 0);
                        return;
                    }
                }
                qVar.a(this.pCm, this.pCn, this.vtx);
                return;
            } else if (i2 == -87) {
                com.tencent.mm.ui.base.h.b(this.context, this.context.getString(h.dUK), "", true);
                return;
            } else if (i2 == XWalkUpdater.ERROR_SET_VERNUM && !bi.oN(str)) {
                com.tencent.mm.sdk.platformtools.x.d("MicroMsg.AddContact", "jacks catch add Contact errCode: %d && errMsg: %s", Integer.valueOf(i2), str);
                com.tencent.mm.ui.base.h.a(this.context, str, "", false, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        a.this.c(false, false, a.this.vtz, a.this.vtE);
                    }
                });
                return;
            } else if (i2 == -302) {
                if (kVar.getType() != 667) {
                    com.tencent.mm.sdk.platformtools.x.d("MicroMsg.AddContact", "onSceneEnd, verify relation out of date, opCode = %d", Integer.valueOf(((o) kVar).fvG));
                    if (((o) kVar).fvG == 3) {
                        com.tencent.mm.ui.base.h.a(this.context, this.context.getString(h.dXr), this.context.getString(h.dGZ), this.context.getString(h.dDV), this.context.getString(h.dEy), new OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                                com.tencent.mm.sdk.platformtools.x.d("MicroMsg.AddContact", "dealwith verify relation out of date");
                                o oVar = (o) kVar;
                                LinkedList linkedList = (oVar.gLB == null || oVar.gLB.Kh() == null) ? null : ((bub) oVar.gLB.hnQ.hnY).xbK;
                                List list = ((o) kVar).vkg;
                                if (list != null && list.size() > 0) {
                                    a.this.c((String) list.get(0), linkedList);
                                }
                            }
                        }, null);
                        return;
                    }
                    return;
                }
                return;
            } else if (i2 != -2) {
                r(i, i2, str);
                return;
            } else if (bi.oN(str)) {
                r(i, i2, null);
                return;
            } else {
                com.tencent.mm.ui.base.h.a(this.context, str, this.context.getString(h.dGZ), this.context.getString(h.dGf), null);
                return;
            }
        }
        com.tencent.mm.sdk.platformtools.x.w("MicroMsg.AddContact", "not expected scene,  type = " + kVar.getType());
    }

    private void r(int i, int i2, String str) {
        if (this.vtF && !bi.oN(str)) {
            Toast.makeText(this.context, str, 1).show();
        } else if (i == 4 && i2 == -22) {
            Toast.makeText(this.context, this.context.getString(h.lud), 1).show();
        } else if (i == 4 && i2 == -24 && !bi.oN(str)) {
            Toast.makeText(this.context, str, 1).show();
        } else {
            Toast.makeText(this.context, this.context.getString(h.luc), 1).show();
        }
        c(false, false, this.vtz, this.vtE);
    }
}
