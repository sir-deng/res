package com.tencent.mm.plugin.wenote.model.nativenote.manager;

import android.text.Spannable;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.f.a.fw;
import com.tencent.mm.plugin.wenote.model.a.h;
import com.tencent.mm.plugin.wenote.model.nativenote.b.b;
import com.tencent.mm.plugin.wenote.model.nativenote.b.c;
import com.tencent.mm.plugin.wenote.model.nativenote.spans.g;
import com.tencent.mm.plugin.wenote.model.nativenote.spans.l;
import com.tencent.mm.plugin.wenote.model.nativenote.spans.m;
import com.tencent.mm.plugin.wenote.model.nativenote.spans.t;
import com.tencent.mm.plugin.wenote.model.nativenote.spans.u;
import com.tencent.mm.plugin.wenote.ui.nativenote.a;
import com.tencent.mm.pluginsdk.e;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.Iterator;

public final class k implements c {
    public static int mScreenHeight;
    public static int mScreenWidth;
    public static k uaB = null;
    private static DisplayMetrics uaC;
    public static int uaD = -1;
    private static int uaF = -1;
    public int MP;
    public long frf = -1;
    public int jSO;
    public a uaA;
    private int uaE;
    public long uaG = -1;
    private String uaH = "";
    public b uaI = null;
    private boolean uaJ = false;
    public int uaK = -1;
    public String uaL = null;
    public long uaM = -1;
    public int uaN = 0;
    public boolean uaO = false;
    private OnKeyListener uaP = new OnKeyListener() {
        public final boolean onKey(View view, int i, KeyEvent keyEvent) {
            if (keyEvent.getAction() != 0 || keyEvent.getKeyCode() != 67 || c.bXc().size() == 0) {
                return false;
            }
            WXRTEditText bXL = k.this.bXL();
            if (bXL == null) {
                return false;
            }
            int bXB = bXL.bXB();
            x.i("MicroMsg.Note.WXRTManager", "current focus pos: %d", Integer.valueOf(bXB));
            com.tencent.mm.plugin.wenote.model.a.b BL = c.bXc().BL(bXB);
            if (BL == null) {
                x.w("MicroMsg.Note.WXRTManager", "get current item is null %d", Integer.valueOf(bXB));
                return false;
            }
            com.tencent.mm.plugin.wenote.model.a.b BL2 = c.bXc().BL(bXB - 1);
            if (BL2 == null) {
                x.i("MicroMsg.Note.WXRTManager", "get preItem is null %d", Integer.valueOf(bXB));
                return false;
            }
            h hVar;
            switch (bXL.tZU) {
                case 0:
                    x.i("MicroMsg.Note.WXRTManager", "Handle Editor Type EDITTEXT");
                    int selectionStart = bXL.getSelectionStart();
                    if (selectionStart == bXL.getSelectionEnd()) {
                        if (selectionStart == bXL.bXH().Ww) {
                            bXL.uaf = true;
                            k.this.b(u.ucI, Boolean.valueOf(false));
                            k.this.b(u.ucJ, Boolean.valueOf(false));
                            k.this.b(u.ucH, Boolean.valueOf(false));
                            k.this.uaI.kP(false);
                            k.this.uaI.kQ(false);
                            k.this.uaI.kR(false);
                            bXL.uaf = false;
                        }
                        if (selectionStart == 0 && bXB != 0) {
                            boolean W;
                            String a = bXL.a(i.uav);
                            c.bXc().bXf();
                            if (BL2.getType() == 1) {
                                W = c.bXc().W(bXB, true);
                                hVar = (h) BL2;
                                int length = hVar.tXW.getText().toString().length();
                                hVar.content += a;
                                hVar.tXT = length;
                                hVar.tXR = true;
                                hVar.tXX = false;
                            } else {
                                if (bi.oN(a)) {
                                    W = c.bXc().W(bXB, true);
                                } else {
                                    W = false;
                                }
                                BL2.tXV.setSelection(0);
                                BL2.tXR = true;
                                BL2.tXX = false;
                            }
                            if (!W) {
                                k.this.uaA.bYw().er(bXB - 1, 2);
                                break;
                            }
                            k.this.uaA.bYw().BE(bXB - 1);
                            break;
                        }
                        return false;
                    }
                    return false;
                case 1:
                    x.i("MicroMsg.Note.WXRTManager", "Handle Editor Type PREBUTTON");
                    c.bXc().bXf();
                    if (BL2.getType() == 1) {
                        hVar = (h) BL2;
                        if (bi.oN(hVar.content)) {
                            BL.tXU.setSelection(0);
                            BL.tXR = true;
                            BL.tXX = true;
                            c.bXc().W(bXB - 1, true);
                            return true;
                        }
                        if (hVar.content.endsWith("<br/>")) {
                            hVar.content = hVar.content.substring(0, hVar.content.length() - 5);
                        }
                        hVar.tXT = -1;
                        hVar.tXR = true;
                        hVar.tXX = false;
                    } else {
                        BL2.tXV.setSelection(0);
                        BL2.tXR = true;
                        BL2.tXX = false;
                    }
                    k.this.uaA.bYw().er(bXB - 1, 2);
                    break;
                case 2:
                    x.i("MicroMsg.Note.WXRTManager", "Handle Editor Type NEXTBTTTON");
                    if (BL.getType() == 4 && ((com.tencent.mm.plugin.wenote.model.a.k) BL).tYf.booleanValue()) {
                        x.i("MicroMsg.Note.WXRTManager", "Current Item is Voice and Recording");
                        return false;
                    } else if (BL.tXY || BL.getType() == -1) {
                        c.bXc().bXf();
                        c.bXc().W(bXB, false);
                        k.this.uaA.bYw().BG(bXB);
                        BL2 = new h();
                        BL2.tXR = true;
                        BL2.tXX = false;
                        BL2.content = "";
                        BL2.tXT = 0;
                        c.bXc().a(bXB, BL2);
                        c.bXc().eu(bXB - 1, bXB + 1);
                        k.this.uaA.bYu().be(bXB);
                        break;
                    } else {
                        c.bXc().X(bXB, true);
                        return true;
                    }
                    break;
            }
            return true;
        }
    };
    public final al uaQ = new al(new al.a() {
        public final boolean uG() {
            if (-1 == k.this.uaG) {
                return false;
            }
            k.this.bXO();
            return true;
        }
    }, true);
    private transient ArrayList<WXRTEditText> uaz = new ArrayList();

    public k(a aVar) {
        this.uaA = aVar;
        uaB = this;
        this.MP = e.cj(aVar.bYv());
        this.jSO = e.ec(aVar.bYv());
        int[] aT = j.aT(aVar.bYv());
        mScreenHeight = aT[1];
        mScreenWidth = aT[0];
        uaC = aVar.bYv().getResources().getDisplayMetrics();
        this.uaE = ((mScreenHeight - this.MP) - this.jSO) - ((int) aq(8.0f));
        this.uaH = c.bXc().bXj();
        m.ucl = 0.0f;
    }

    public final void o(WXRTEditText wXRTEditText) {
        if (wXRTEditText.tZU == 0) {
            wXRTEditText.setTextSize(0, (float) com.tencent.mm.bu.a.aa(wXRTEditText.getContext(), R.f.bvL));
        }
        b.setTextSize(wXRTEditText.getTextSize());
        wXRTEditText.tZK = this;
        wXRTEditText.Rw(null);
        wXRTEditText.setOnKeyListener(this.uaP);
    }

    public final WXRTEditText bXL() {
        c bXc = c.bXc();
        ArrayList arrayList = this.uaz;
        if (arrayList != null) {
            arrayList.clear();
            synchronized (bXc) {
                if (bXc.jXe == null) {
                } else {
                    Iterator it = bXc.jXe.iterator();
                    while (it.hasNext()) {
                        com.tencent.mm.plugin.wenote.model.a.b bVar = (com.tencent.mm.plugin.wenote.model.a.b) it.next();
                        if (bVar.tXW != null) {
                            arrayList.add(bVar.tXW);
                        } else if (!(bVar.tXU == null || bVar.tXV == null)) {
                            arrayList.add(bVar.tXU);
                            arrayList.add(bVar.tXV);
                        }
                    }
                }
            }
        }
        if (this.uaz == null) {
            return null;
        }
        Iterator it2 = this.uaz.iterator();
        while (it2.hasNext()) {
            WXRTEditText wXRTEditText = (WXRTEditText) it2.next();
            if (wXRTEditText.hasFocus()) {
                return wXRTEditText;
            }
        }
        return null;
    }

    public final void f(boolean z, long j) {
        this.uaA.bYw().f(z, j);
    }

    public final void bWW() {
        this.uaA.bYw().bWW();
        bXN();
    }

    public final void BI(int i) {
        this.uaA.bYw().P(i, 0);
    }

    public final void a(WXRTEditText wXRTEditText, boolean z, int i) {
        synchronized (this) {
            if (z) {
                bXN();
            }
            this.uaA.bYw().a(wXRTEditText, z, i);
        }
    }

    public final void a(WXRTEditText wXRTEditText, int i, int i2) {
        if (this.uaN == 2 && this.uaO && wXRTEditText != null) {
            boolean z;
            boolean z2;
            boolean z3;
            boolean z4;
            this.uaA.bYw().es(i, i2);
            if (wXRTEditText.tZU == 0) {
                Iterator it = u.ucL.iterator();
                z = false;
                z2 = false;
                z3 = false;
                z4 = false;
                while (it.hasNext()) {
                    boolean z5;
                    t tVar = (t) it.next();
                    if (tVar.q(wXRTEditText)) {
                        if (tVar instanceof com.tencent.mm.plugin.wenote.model.nativenote.spans.b) {
                            z4 = true;
                        } else if (tVar instanceof com.tencent.mm.plugin.wenote.model.nativenote.spans.c) {
                            z3 = true;
                        } else if (tVar instanceof l) {
                            z2 = true;
                        } else if (tVar instanceof com.tencent.mm.plugin.wenote.model.nativenote.spans.j) {
                            z5 = true;
                            z = z5;
                        }
                    }
                    z5 = z;
                    z = z5;
                }
            } else {
                z = false;
                z2 = false;
                z3 = false;
                z4 = false;
            }
            this.uaI.kO(z4);
            this.uaI.kP(z3);
            this.uaI.kQ(z2);
            this.uaI.kR(z);
        }
    }

    public final void a(WXRTEditText wXRTEditText, Spannable spannable, Spannable spannable2, int i) {
        String a = wXRTEditText.a(i.uav);
        com.tencent.mm.plugin.wenote.model.a.b BL;
        if (wXRTEditText.tZU == 0) {
            BL = c.bXc().BL(wXRTEditText.bXB());
            if (BL != null && BL.getType() == 1) {
                int RB = spannable == null ? 0 : com.tencent.mm.plugin.wenote.b.c.RB(spannable.toString());
                int RB2 = spannable2 == null ? 0 : com.tencent.mm.plugin.wenote.b.c.RB(spannable2.toString());
                if (c.bXc().et(RB2 - RB, 0)) {
                    this.uaA.bYw().bWM();
                    this.uaA.bYw().BE(wXRTEditText.bXB());
                    return;
                }
                c.bXc().bXf();
                ((h) BL).tXT = i;
                ((h) BL).content = a;
                ((h) BL).tXR = true;
                BL.tXX = false;
                c bXc = c.bXc();
                bXc.tZf = (RB2 - RB) + bXc.tZf;
                return;
            }
            return;
        }
        wXRTEditText.setText("");
        if (!bi.oN(a)) {
            String str;
            BL = new h();
            if (a.equals("<br/>")) {
                str = "";
            } else {
                str = a;
            }
            BL.content = str;
            int a2 = c.bXc().a(BL, wXRTEditText, true, false, false);
            c.bXc().eu(a2 - 1, a2 + 1);
        }
    }

    public static k bXM() {
        return uaB;
    }

    public final void bWY() {
        this.uaA.bYw().bWK();
    }

    public final void b(WXRTEditText wXRTEditText) {
        this.uaA.bYw().a(wXRTEditText);
    }

    public static float aq(float f) {
        return TypedValue.applyDimension(1, f, uaC);
    }

    private synchronized void aW(String str, boolean z) {
        com.tencent.mm.sdk.b.b fwVar = new fw();
        fwVar.fwl.type = 19;
        fwVar.fwl.frm = c.bXc().Ru(str);
        if (fwVar.fwl.frm == null) {
            x.e("MicroMsg.Note.WXRTManager", "updateNoteInfoStorage error, favProtoItem is null");
        } else {
            fwVar.fwl.title = str;
            fwVar.fwl.frf = this.frf;
            fwVar.fwl.fws = z ? 1 : 0;
            fwVar.fwl.desc = "fav_update_note_storage";
            com.tencent.mm.sdk.b.a.xmy.m(fwVar);
            if (z) {
                this.uaK = fwVar.fwl.fwo.getIntExtra("fav_note_item_status", -1);
                this.uaL = fwVar.fwl.fwo.getStringExtra("fav_note_xml");
                this.uaM = fwVar.fwl.fwo.getLongExtra("fav_note_item_updatetime", -1);
            }
        }
    }

    private void bXN() {
        if (this.uaG < 0 && this.frf > 0) {
            this.uaQ.K(60000, 60000);
            this.uaG = bi.Wz();
            this.uaH = c.bXc().bXj();
        }
    }

    public final void bXO() {
        if (this.frf > 0 && this.uaG > 0) {
            String bXj = c.bXc().bXj();
            if (!bXj.equals(this.uaH)) {
                this.uaH = bXj;
                if (this.uaJ) {
                    aW(this.uaH, false);
                    return;
                }
                this.uaJ = true;
                aW(this.uaH, true);
            }
        }
    }

    public final WXRTEditText bXP() {
        WXRTEditText bXL = bXL();
        if (bXL != null || this.uaz.size() <= 0) {
            return bXL;
        }
        return (WXRTEditText) this.uaz.get(this.uaz.size() - 1);
    }

    public final <V, C extends g<V>> void b(t<V, C> tVar, V v) {
        WXRTEditText bXL = bXL();
        if (bXL == null) {
            return;
        }
        if (bXL.tZU == 0) {
            int i = bXL.bXA().Ww;
            int length = bXL.getText().length();
            if ((v instanceof Boolean) && ((Boolean) v).booleanValue() && i == length) {
                bXL.bXC();
                bXL.getText().append("\n");
                bXL.bXD();
                bXL.setSelection(i);
            }
            bXL.a((t) tVar, (Object) v);
            return;
        }
        bXL.uag = true;
        bXL.tYb = tVar.bYg();
        bXL.getText().append("\n");
    }

    public static void bXQ() {
        if (uaB != null) {
            uaB.uaA.bYw().kN(true);
        }
    }
}
