package com.tencent.mm.ui.chatting.b;

import android.content.Context;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.af.f;
import com.tencent.mm.f.a.fg;
import com.tencent.mm.f.a.fk;
import com.tencent.mm.modelvoice.m;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bl;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.chatting.viewitems.ah.d.a;
import com.tencent.mm.y.as;
import com.tencent.mm.y.c;
import com.tencent.mm.y.s;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

public final class ab {
    private static HashMap<Long, String> yLd = new HashMap();
    private static HashMap<Long, a> yLe = new HashMap();
    private static LinkedHashMap<Long, au> yLf = new LinkedHashMap();
    private static HashMap<Long, Boolean> yLg = new HashMap();
    private p fhH;
    public boolean yLh = false;
    long yLi = 0;
    boolean yLj = false;

    public ab(p pVar) {
        this.fhH = pVar;
    }

    public final synchronized void a(long j, String str, a aVar) {
        yLd.put(Long.valueOf(j), str);
        yLe.put(Long.valueOf(j), aVar);
        if (aVar == a.Transformed) {
            yLg.put(Long.valueOf(j), Boolean.valueOf(true));
        }
    }

    public final synchronized void gf(long j) {
        yLd.remove(Long.valueOf(j));
        yLe.remove(Long.valueOf(j));
    }

    public final synchronized String v(long j, String str) {
        String str2;
        str2 = (String) yLd.get(Long.valueOf(j));
        if (bi.oN(str2)) {
            bl Yv = m.UL().Yv(str);
            if (!(Yv == null || bi.oN(Yv.field_content))) {
                str2 = Yv.field_content;
            }
        }
        return str2;
    }

    public final synchronized a gg(long j) {
        a aVar;
        aVar = (a) yLe.get(Long.valueOf(j));
        if (aVar == null) {
            aVar = a.NoTransform;
        }
        return aVar;
    }

    private synchronized void c(long j, au auVar) {
        yLf.put(Long.valueOf(j), auVar);
    }

    public final synchronized boolean gh(long j) {
        boolean z;
        if (yLf.containsKey(Long.valueOf(j))) {
            z = true;
        } else {
            z = false;
        }
        return z;
    }

    public final synchronized au gi(long j) {
        return (au) yLf.get(Long.valueOf(j));
    }

    public final synchronized au cuN() {
        au auVar;
        Iterator it = yLf.entrySet().iterator();
        if (it.hasNext()) {
            auVar = (au) ((Entry) it.next()).getValue();
        } else {
            auVar = null;
        }
        return auVar;
    }

    public final synchronized void gj(long j) {
        if (yLf.containsKey(Long.valueOf(j))) {
            yLf.remove(Long.valueOf(j));
        }
    }

    public final synchronized void cuO() {
        yLf.clear();
    }

    public static boolean cuP() {
        as.Hm();
        return !((Boolean) c.Db().get(75, Boolean.valueOf(false))).booleanValue();
    }

    public static void cuQ() {
        as.Hm();
        c.Db().set(75, Boolean.valueOf(true));
    }

    public final void e(au auVar, boolean z) {
        int i = 4;
        if (auVar == null) {
            x.d("MicroMsg.TransformImp", "go VoiceTransTextAct need MsgInfo but null");
        } else if (gk(auVar.field_msgId)) {
            x.i("MicroMsg.TransformImp", "go VoiceTransTextAct unsetflag MsgId:%s,isVoiceTransforming:%s", Long.valueOf(auVar.field_msgId), Boolean.valueOf(this.yLh));
            auVar.ckp();
            gl(auVar.field_msgId);
            notifyDataSetChanged();
        } else if (gh(auVar.field_msgId) && z) {
            if (gg(auVar.field_msgId) == a.PreTransform) {
                x.i("MicroMsg.TransformImp", "go VoiceTransTextAct unsetflag removeCache");
                gj(auVar.field_msgId);
                gf(auVar.field_msgId);
                c(5, auVar);
            } else if (this.yLh) {
                b fgVar = new fg();
                fgVar.fvl.fvo = 3;
                com.tencent.mm.sdk.b.a.xmy.m(fgVar);
                gj(auVar.field_msgId);
                gf(auVar.field_msgId);
                auVar.ckp();
                as.Hm();
                c.Fh().a(auVar.field_msgId, auVar);
                cuR();
            }
            notifyDataSetChanged();
        } else {
            bl Yv = m.UL().Yv(auVar.field_imgPath);
            if (Yv == null || bi.oN(Yv.field_content)) {
                int Ks = as.CN().Ks();
                if (Ks != 4 && Ks != 6) {
                    h.h(getContext(), R.l.dTr, R.l.dGZ);
                    c(2, auVar);
                    return;
                } else if (this.yLh) {
                    x.i("MicroMsg.TransformImp", "go VoiceTransformText insert transformQueue");
                    c(auVar.field_msgId, auVar);
                    a(auVar.field_msgId, "", a.PreTransform);
                    notifyDataSetChanged();
                    return;
                } else {
                    b fgVar2 = new fg();
                    fgVar2.fvl.fvo = 1;
                    com.tencent.mm.sdk.b.a.xmy.m(fgVar2);
                    fgVar2 = new fg();
                    fgVar2.fvl.fvn = String.valueOf(auVar.field_msgId);
                    fgVar2.fvl.fileName = auVar.field_imgPath;
                    fgVar2.fvl.fqZ = 1;
                    fgVar2.fvl.fvo = 0;
                    fg.a aVar = fgVar2.fvl;
                    if (!s.gI(this.fhH.csW().field_username)) {
                        i = this.fhH.csR() ? 2 : 1;
                    } else if (!this.fhH.csT()) {
                        i = f.jZ(this.fhH.csW().field_username) ? 3 : f.ka(this.fhH.csW().field_username) ? 0 : f.jW(this.fhH.csW().field_username) ? 6 : 7;
                    } else if (this.fhH.csU()) {
                        i = 5;
                    }
                    aVar.scene = i;
                    fgVar2.fvl.fvp = new Runnable() {
                        public final void run() {
                            if (fgVar2.fvm.aow) {
                                if (bi.oN(fgVar2.fvm.content)) {
                                    if (fgVar2.fvm.state == 2) {
                                        x.i("MicroMsg.TransformImp", "go VoiceTransTextAct translateVoice fail msgId:%s", fgVar2.fvl.fvn);
                                        ab.this.ZS(ab.this.getContext().getString(R.l.dTq));
                                    }
                                    ab.this.gf(Long.valueOf(fgVar2.fvl.fvn).longValue());
                                    ab.this.gj(Long.valueOf(fgVar2.fvl.fvn).longValue());
                                    ab.this.yLh = false;
                                    ab.this.notifyDataSetChanged();
                                } else {
                                    x.i("MicroMsg.TransformImp", "go VoiceTransTextAct isCompleted msgId:%s", fgVar2.fvl.fvn);
                                    au gi = ab.this.gi(Long.valueOf(fgVar2.fvl.fvn).longValue());
                                    if (gi != null) {
                                        ab.this.a(Long.valueOf(fgVar2.fvl.fvn).longValue(), fgVar2.fvm.content, a.Transformed);
                                        gi.ckq();
                                        as.Hm();
                                        c.Fh().a(gi.field_msgId, gi);
                                        ab.this.gj(Long.valueOf(fgVar2.fvl.fvn).longValue());
                                        ab.this.notifyDataSetChanged();
                                    }
                                    ab.this.yLh = false;
                                }
                                ab.this.cuR();
                                return;
                            }
                            if (!bi.oN(fgVar2.fvm.content)) {
                                ab.this.a(Long.valueOf(fgVar2.fvl.fvn).longValue(), fgVar2.fvm.content, a.Transforming);
                                x.i("MicroMsg.TransformImp", "go VoiceTransTextAct refresh msgId:%s", fgVar2.fvl.fvn);
                            }
                            ab.this.notifyDataSetChanged();
                        }
                    };
                    a(Long.valueOf(fgVar2.fvl.fvn).longValue(), "", a.Transforming);
                    c(auVar.field_msgId, auVar);
                    this.yLh = true;
                    notifyDataSetChanged();
                    if (com.tencent.mm.sdk.b.a.xmy.m(fgVar2)) {
                        x.i("MicroMsg.TransformImp", "go VoiceTransTextAct publish ExtTranslateVoiceEvent");
                        return;
                    }
                    x.i("MicroMsg.TransformImp", "go VoiceTransTextAct publish ExtTranslateVoiceEvent fail");
                    ZS(getContext().getString(R.l.dTq));
                    gf(Long.valueOf(fgVar2.fvl.fvn).longValue());
                    gj(Long.valueOf(fgVar2.fvl.fvn).longValue());
                    this.yLh = false;
                    cuR();
                    return;
                }
            }
            x.i("MicroMsg.TransformImp", "alvinluo VoiceTransformText has TransContent MsgId:%s, clientMsgId: %s", Long.valueOf(auVar.field_msgId), auVar.field_imgPath);
            auVar.ckq();
            a(auVar.field_msgId, Yv.field_content, a.Transformed);
            as.Hm();
            c.Fh().a(auVar.field_msgId, auVar);
        }
    }

    private static void c(int i, au auVar) {
        if (auVar != null) {
            b fkVar = new fk();
            fkVar.fvw.fvy = 0;
            fkVar.fvw.fvz = 0;
            fkVar.fvw.fvA = 0;
            fkVar.fvw.fvx = 0;
            fkVar.fvw.fileName = auVar.field_imgPath;
            fkVar.fvw.result = i;
            com.tencent.mm.sdk.b.a.xmy.m(fkVar);
        }
    }

    public final synchronized void cuR() {
        ag ctg = this.fhH != null ? this.fhH.ctg() : null;
        if (ctg != null) {
            ctg.post(new Runnable() {
                public final void run() {
                    au cuN = ab.this.cuN();
                    if (cuN != null) {
                        ab.this.e(cuN, false);
                    }
                }
            });
        }
    }

    private void notifyDataSetChanged() {
        if (this.fhH != null) {
            this.fhH.cpZ();
        }
    }

    private Context getContext() {
        if (this.fhH != null) {
            return this.fhH.cte().getContext();
        }
        return ad.getContext();
    }

    private void ZS(String str) {
        if (this.fhH != null && this.fhH.cte() != null && this.fhH.cte().getActivity() != null) {
            Toast makeText = Toast.makeText(this.fhH.cte().getActivity(), str, 0);
            makeText.setGravity(17, 0, 0);
            makeText.show();
        }
    }

    public final synchronized boolean gk(long j) {
        boolean booleanValue;
        Boolean bool = (Boolean) yLg.get(Long.valueOf(j));
        if (bool != null) {
            booleanValue = bool.booleanValue();
        } else {
            booleanValue = false;
        }
        return booleanValue;
    }

    private synchronized void gl(long j) {
        yLg.put(Long.valueOf(j), Boolean.valueOf(false));
    }
}
