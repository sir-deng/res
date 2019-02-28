package com.tencent.mm.pluginsdk.ui.applet;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference.a;
import com.tencent.mm.pluginsdk.ui.applet.i.b;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.y.s;
import java.util.HashMap;

public final class g {
    private Context context;
    f inW;
    private View onR;
    private View orQ;
    public OnClickListener pMx;
    a saA;
    String username;
    String vub;
    private HashMap<String, Preference> vuc = new HashMap();
    boolean vud = false;
    boolean vue;
    public h vuf;
    b vug;
    private OnClickListener vuh;
    private OnClickListener vui;
    private OnClickListener vuj;
    private b vuk;
    private i.a vul;
    private h.a vum;

    public g(Context context) {
        boolean z = false;
        if (this.vud) {
            z = true;
        }
        this.vue = z;
        this.vug = null;
        this.pMx = null;
        this.saA = null;
        this.vuj = new OnClickListener() {
            public final void onClick(View view) {
                x.d("MicroMsg.ContactListArchor", "OnClickListener = onClick ");
            }
        };
        this.vuk = new b() {
            public final boolean ou(int i) {
                if (g.this.vuf.vuB && g.this.vuf.Cs(i) && !g.this.vuf.Cr(i)) {
                    x.d("MicroMsg.ContactListArchor", "onItemLongClick " + i);
                }
                return true;
            }
        };
        this.vul = new i.a() {
            public final void Cq(int i) {
                int i2 = 1;
                if (g.this.saA != null && g.this.vuf != null) {
                    h hVar = g.this.vuf;
                    int i3 = hVar.vuB ? (hVar.lhA || i != hVar.vuz + 2) ? 0 : 1 : (hVar.lhA || i != hVar.vuz + 1) ? 0 : 1;
                    if (i3 == 0) {
                        hVar = g.this.vuf;
                        if (hVar.lhA || i != hVar.vuz) {
                            i3 = 0;
                        } else {
                            i3 = 1;
                        }
                        if (i3 != 0) {
                            g.this.saA.ox(i);
                            return;
                        }
                        hVar = g.this.vuf;
                        if (hVar.lhA || i != hVar.vuz + 1) {
                            i2 = 0;
                        }
                        if (i2 != 0) {
                            if (!g.this.vuf.vuB) {
                                return;
                            }
                            if (s.eX(g.this.username)) {
                                g.this.saA.ov(i);
                            } else {
                                g.this.vuf.Cr(0);
                            }
                        } else if (g.this.vuf.lhA && g.this.vuf.Cs(i)) {
                            g.this.saA.ov(i);
                        } else if (g.this.vuf.lhA && !g.this.vuf.Cs(i)) {
                            g.this.saA.ayt();
                        } else if (!g.this.vuf.lhA && g.this.vuf.Cs(i)) {
                            g.this.saA.ow(i);
                        }
                    }
                }
            }
        };
        this.vum = new h.a() {
            public final void bYt() {
                if (g.this.inW != null) {
                    g.this.inW.notifyDataSetChanged();
                }
            }
        };
        this.context = context;
        this.vuf = new h(this.context);
        this.vuf.vuq = this.vum;
    }

    final void Ev(String str) {
        h hVar = this.vuf;
        hVar.username = str;
        hVar.fAu = s.eX(str);
        if (!(hVar.fAu || n.a.vva == null)) {
            hVar.vus = n.a.vva.SR(str);
        }
        if (!hVar.vus) {
            hVar.lfE = ((com.tencent.mm.plugin.chatroom.b.b) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.chatroom.b.b.class)).Fo().hG(str);
        }
        if (hVar.vus && n.a.vva != null) {
            hVar.liE = n.a.vva.ST(hVar.username);
        }
        this.vuf.vuF = this.vue;
        this.vuf.notifyChanged();
        bmd();
    }

    private static String Cp(int i) {
        if (i >= 0) {
            return "pref_contact_list_row_" + i;
        }
        String str = "unkown";
        if (i == -1) {
            str = "header";
        } else if (i == -2) {
            str = "footer";
        }
        return "pref_contact_list_row_" + str;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void bmd() {
        /*
        r15 = this;
        r0 = r15.inW;
        if (r0 == 0) goto L_0x0008;
    L_0x0004:
        r0 = r15.vub;
        if (r0 != 0) goto L_0x0009;
    L_0x0008:
        return;
    L_0x0009:
        r0 = r15.vuc;
        r0 = r0.keySet();
        r1 = r0.iterator();
    L_0x0013:
        r0 = r1.hasNext();
        if (r0 == 0) goto L_0x0025;
    L_0x0019:
        r0 = r1.next();
        r0 = (java.lang.String) r0;
        r2 = r15.inW;
        r2.Zv(r0);
        goto L_0x0013;
    L_0x0025:
        r0 = r15.vuc;
        r0.clear();
        r0 = r15.inW;
        r1 = r15.vub;
        r1 = r0.indexOf(r1);
        r0 = 0;
        r2 = 0;
        r3 = r15.onR;
        if (r3 == 0) goto L_0x0039;
    L_0x0038:
        r0 = 1;
    L_0x0039:
        r3 = r15.orQ;
        if (r3 == 0) goto L_0x01d3;
    L_0x003d:
        r3 = r15.vud;
        if (r3 == 0) goto L_0x004c;
    L_0x0041:
        r3 = r15.vuf;
        r4 = r3.vuy;
        r3 = r3.vuG;
        if (r4 <= r3) goto L_0x0110;
    L_0x0049:
        r3 = 1;
    L_0x004a:
        if (r3 == 0) goto L_0x01d3;
    L_0x004c:
        r2 = 1;
        r7 = r2;
    L_0x004e:
        if (r0 == 0) goto L_0x007b;
    L_0x0050:
        r0 = new com.tencent.mm.pluginsdk.ui.applet.ContactListCustomPreference;
        r2 = r15.context;
        r0.<init>(r2);
        r2 = -1;
        r2 = Cp(r2);
        r0.setKey(r2);
        r2 = r15.onR;
        r0.setCustomView(r2);
        r2 = com.tencent.mm.plugin.comm.a.d.bBy;
        r0.background = r2;
        r2 = r15.vuh;
        r0.pMx = r2;
        r2 = r15.inW;
        r2.a(r0, r1);
        r2 = r15.vuc;
        r3 = r0.idX;
        r2.put(r3, r0);
        r0 = r1 + 1;
        r1 = r0;
    L_0x007b:
        r0 = r15.vug;
        if (r0 == 0) goto L_0x0113;
    L_0x007f:
        r0 = r15.vug;
        r2 = r0;
    L_0x0082:
        r0 = r15.pMx;
        if (r0 == 0) goto L_0x0118;
    L_0x0086:
        r0 = r15.pMx;
        r3 = r0;
    L_0x0089:
        r0 = r15.vuf;
        r0 = r0.vuH;
        r4 = r15.vuf;
        r5 = r4.cbH();
        r4 = com.tencent.mm.sdk.platformtools.bi.oN(r0);
        if (r4 != 0) goto L_0x00a5;
    L_0x0099:
        if (r0 == 0) goto L_0x011d;
    L_0x009b:
        r4 = com.tencent.mm.y.q.FY();
        r0 = r0.equals(r4);
        if (r0 != 0) goto L_0x011d;
    L_0x00a5:
        r0 = 0;
    L_0x00a6:
        r4 = r15.vuf;
        r4 = r4.vus;
        if (r4 == 0) goto L_0x01d0;
    L_0x00ac:
        r0 = r15.vuf;
        r0 = r0.vut;
        r4 = r0;
    L_0x00b1:
        r0 = r15.vuf;
        r6 = r0.vuz;
        if (r5 == 0) goto L_0x00b9;
    L_0x00b7:
        if (r4 == 0) goto L_0x011f;
    L_0x00b9:
        r0 = 2;
    L_0x00ba:
        r8 = r6 + r0;
        r6 = 0;
        r5 = r15.vuf;
        r9 = r15.context;
        if (r9 != 0) goto L_0x0121;
    L_0x00c3:
        r0 = 0;
    L_0x00c4:
        r5 = 0;
    L_0x00c5:
        r9 = r15.vuf;
        r9 = r9.getCount();
        if (r5 >= r9) goto L_0x01a7;
    L_0x00cd:
        if (r5 >= r8) goto L_0x01a7;
    L_0x00cf:
        r9 = new com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference;
        r10 = r15.context;
        r11 = 1;
        r9.<init>(r10, r11);
        r10 = Cp(r6);
        r9.setKey(r10);
        r10 = r9.vuU;
        r11 = r15.vuf;
        r10.vuf = r11;
        r10.row = r6;
        r10.index = r5;
        r10 = r9.vuU;
        r10.vuV = r0;
        r10 = r9.vuU;
        r10.lfB = r4;
        r10 = r9.vuU;
        r10.pMx = r3;
        r10 = r9.vuU;
        r11 = r15.vul;
        r10.vul = r11;
        r10 = r9.vuU;
        r10.vuW = r2;
        r10 = r15.inW;
        r11 = r1 + r6;
        r10.a(r9, r11);
        r10 = r15.vuc;
        r11 = r9.idX;
        r10.put(r11, r9);
        r5 = r5 + r0;
        r6 = r6 + 1;
        goto L_0x00c5;
    L_0x0110:
        r3 = 0;
        goto L_0x004a;
    L_0x0113:
        r0 = r15.vuk;
        r2 = r0;
        goto L_0x0082;
    L_0x0118:
        r0 = r15.vuj;
        r3 = r0;
        goto L_0x0089;
    L_0x011d:
        r0 = 1;
        goto L_0x00a6;
    L_0x011f:
        r0 = 1;
        goto L_0x00ba;
    L_0x0121:
        r0 = "window";
        r0 = r9.getSystemService(r0);
        r0 = (android.view.WindowManager) r0;
        r0 = r0.getDefaultDisplay();
        r10 = r0.getWidth();
        r0 = r0.getHeight();
        r11 = (float) r10;
        r12 = r9.getResources();
        r13 = com.tencent.mm.plugin.comm.a.c.bvG;
        r12 = r12.getDimension(r13);
        r13 = r9.getResources();
        r14 = com.tencent.mm.plugin.comm.a.c.bvC;
        r13 = r13.getDimension(r14);
        r14 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        r13 = r13 * r14;
        r12 = r12 + r13;
        r11 = r11 / r12;
        r12 = 1084227584; // 0x40a00000 float:5.0 double:5.356796015E-315;
        r11 = (r11 > r12 ? 1 : (r11 == r12 ? 0 : -1));
        if (r11 < 0) goto L_0x0198;
    L_0x0156:
        if (r0 <= r10) goto L_0x0198;
    L_0x0158:
        r0 = 1;
        r5.vuN = r0;
    L_0x015b:
        r0 = r9.getResources();
        r11 = com.tencent.mm.plugin.comm.a.c.bvC;
        r0 = r0.getDimension(r11);
        r11 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        r11 = r11 * r0;
        r0 = r5.vuN;
        if (r0 == 0) goto L_0x019c;
    L_0x016c:
        r0 = r9.getResources();
        r5 = com.tencent.mm.plugin.comm.a.c.bvG;
        r0 = r0.getDimension(r5);
    L_0x0176:
        r0 = r0 + r11;
        r0 = (int) r0;
        r0 = r10 / r0;
        r5 = "MicroMsg.ContactsListArchAdapter";
        r9 = "[getWrapColNum] :%s";
        r10 = 1;
        r10 = new java.lang.Object[r10];
        r11 = 0;
        r12 = java.lang.Integer.valueOf(r0);
        r10[r11] = r12;
        com.tencent.mm.sdk.platformtools.x.i(r5, r9, r10);
        com.tencent.mm.pluginsdk.ui.applet.h.vup = r0;
        r5 = 4;
        if (r0 != r5) goto L_0x00c4;
    L_0x0192:
        r5 = 43;
        com.tencent.mm.pluginsdk.ui.applet.h.vuo = r5;
        goto L_0x00c4;
    L_0x0198:
        r0 = 0;
        r5.vuN = r0;
        goto L_0x015b;
    L_0x019c:
        r0 = r9.getResources();
        r5 = com.tencent.mm.plugin.comm.a.c.bvE;
        r0 = r0.getDimension(r5);
        goto L_0x0176;
    L_0x01a7:
        if (r7 == 0) goto L_0x0008;
    L_0x01a9:
        r0 = new com.tencent.mm.pluginsdk.ui.applet.ContactListCustomPreference;
        r2 = r15.context;
        r0.<init>(r2);
        r2 = -2;
        r2 = Cp(r2);
        r0.setKey(r2);
        r2 = r15.orQ;
        r0.setCustomView(r2);
        r2 = r15.vui;
        r0.pMx = r2;
        r2 = r15.inW;
        r1 = r1 + r6;
        r2.a(r0, r1);
        r1 = r15.vuc;
        r2 = r0.idX;
        r1.put(r2, r0);
        goto L_0x0008;
    L_0x01d0:
        r4 = r0;
        goto L_0x00b1;
    L_0x01d3:
        r7 = r2;
        goto L_0x004e;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.pluginsdk.ui.applet.g.bmd():void");
    }
}
