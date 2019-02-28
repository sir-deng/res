package com.tencent.mm.ui.voicesearch;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.database.Cursor;
import android.database.MergeCursor;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.booter.notification.a.h;
import com.tencent.mm.f.a.rk;
import com.tencent.mm.f.b.ag;
import com.tencent.mm.modelvoice.n;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.bc;
import com.tencent.mm.storage.x;
import com.tencent.mm.ui.o;
import com.tencent.mm.y.as;
import com.tencent.mm.y.m;
import com.tencent.mm.y.q;
import com.tencent.mm.y.r;
import com.tencent.mm.y.s;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@SuppressLint({"DefaultLocale"})
public final class a extends o<ae> {
    private com.tencent.mm.ui.applet.b hxF = new com.tencent.mm.ui.applet.b(new com.tencent.mm.ui.applet.b.a() {
        public final Bitmap la(String str) {
            return com.tencent.mm.ac.b.a(str, false, -1);
        }
    });
    private com.tencent.mm.ui.applet.b.b hxG = null;
    private String inJ;
    protected List<String> koG = null;
    private ColorStateList[] yvY = new ColorStateList[2];
    private HashMap<String, a> yvZ;
    private boolean zfI = true;
    private b zzw;

    public interface b {
    }

    public static class c {
        public ImageView ikK;
        public TextView kHt;
        public TextView kHu;
        public TextView kHv;
        public TextView kHx;
        public ImageView ywg;
        public ImageView ywh;
    }

    private class a {
        public CharSequence nickName;
        public CharSequence zgd;
        public CharSequence zge;
        public int zgf;

        private a() {
        }

        /* synthetic */ a(a aVar, byte b) {
            this();
        }
    }

    public final /* synthetic */ Object a(Object obj, Cursor cursor) {
        obj = (ae) obj;
        if (cursor.getString(0) != null && cursor.getString(0).equals("1")) {
            if (obj == null) {
                obj = new ae();
            }
            obj.b(cursor);
        } else if (cursor.getString(0).equals("2")) {
            as.Hm();
            ag Xq = com.tencent.mm.y.c.Ff().Xq(x.k(cursor));
            if (Xq == null) {
                Xq = new x();
                Xq.b(cursor);
                as.Hm();
                com.tencent.mm.y.c.Ff().P(Xq);
            }
            if (obj == null) {
                obj = new ae();
            }
            obj.eR(2);
            obj.aj(-1);
            obj.eS(1);
            obj.setContent(this.context.getString(R.l.ekz));
            obj.setUsername(Xq.field_username);
            obj.eP(0);
            obj.dG(Integer.toString(1));
        } else {
            if (obj == null) {
                obj = new ae();
            }
            obj.b(cursor);
        }
        return obj;
    }

    public a(Context context, com.tencent.mm.ui.o.a aVar) {
        super(context, new ae());
        this.xQN = aVar;
        this.yvY[0] = com.tencent.mm.bu.a.Z(context, R.e.btk);
        this.yvY[1] = com.tencent.mm.bu.a.Z(context, R.e.btl);
        this.yvZ = new HashMap();
    }

    public final void dv(List<String> list) {
        this.koG = list;
        a(null, null);
    }

    protected final void XI() {
        XH();
    }

    public final void XH() {
        Cursor[] cursorArr = new Cursor[2];
        cursorArr[0] = as.Hm().hgk.a(s.hgU, this.koG, this.inJ);
        List arrayList = new ArrayList();
        List arrayList2 = new ArrayList();
        if (this.koG != null && this.koG.size() > 0) {
            arrayList.addAll(this.koG);
        }
        while (cursorArr[0].moveToNext()) {
            try {
                String string = cursorArr[0].getString(cursorArr[0].getColumnIndex("username"));
                arrayList.add(string);
                if (!string.endsWith("@chatroom")) {
                    arrayList2.add(string);
                }
                com.tencent.mm.sdk.platformtools.x.d("MicroMsg.SearchConversationAdapter", "block user " + string);
            } catch (Throwable e) {
                com.tencent.mm.sdk.platformtools.x.printErrStackTrace("MicroMsg.SearchConversationAdapter", e, "", new Object[0]);
            }
        }
        cursorArr[1] = as.Hm().hgl.a(this.inJ, "@micromsg.with.all.biz.qq.com", arrayList, arrayList2);
        setCursor(new MergeCursor(cursorArr));
        if (!(this.zzw == null || this.inJ == null)) {
            getCursor().getCount();
        }
        super.notifyDataSetChanged();
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        int i2;
        c cVar;
        a aVar;
        a aVar2;
        CharSequence string;
        int textSize;
        int Gc;
        String str;
        Object obj;
        bc FE;
        int i3;
        ag Xv;
        com.tencent.mm.sdk.b.b rkVar;
        if (this.hxG == null) {
            this.hxG = new com.tencent.mm.ui.applet.b.b() {
                public final String hF(int i) {
                    if (i < 0 || i >= a.this.getCount()) {
                        com.tencent.mm.sdk.platformtools.x.e("MicroMsg.SearchConversationAdapter", "pos is invalid");
                        return null;
                    }
                    ae aeVar = (ae) a.this.getItem(i);
                    return aeVar == null ? null : aeVar.field_username;
                }

                public final int NP() {
                    return a.this.getCount();
                }
            };
        }
        if (this.hxF != null) {
            this.hxF.a(i, this.hxG);
        }
        ae aeVar = (ae) getItem(i);
        if (wv(aeVar.field_msgType) == 34 && aeVar.field_isSend == 0 && !t.oN(aeVar.field_content)) {
            String str2 = aeVar.field_content;
            if (aeVar.field_username.equals("qmessage") || aeVar.field_username.equals("floatbottle")) {
                String[] split = str2.split(":");
                if (split != null && split.length > 3) {
                    str2 = split[1] + ":" + split[2] + ":" + split[3];
                }
            }
            if (!new n(str2).hXo) {
                i2 = 1;
                if (view != null) {
                    cVar = new c();
                    view = View.inflate(this.context, R.i.drB, null);
                    cVar.ikK = (ImageView) view.findViewById(R.h.bLM);
                    cVar.kHt = (TextView) view.findViewById(R.h.cAs);
                    cVar.kHu = (TextView) view.findViewById(R.h.cTY);
                    cVar.kHv = (TextView) view.findViewById(R.h.csB);
                    cVar.kHx = (TextView) view.findViewById(R.h.cSe);
                    cVar.kHx.setBackgroundResource(com.tencent.mm.ui.tools.s.ge(this.context));
                    cVar.ywg = (ImageView) view.findViewById(R.h.cpv);
                    cVar.ywh = (ImageView) view.findViewById(R.h.cQF);
                    view.setTag(cVar);
                } else {
                    cVar = (c) view.getTag();
                }
                aVar = (a) this.yvZ.get(aeVar.field_username + aeVar.field_content);
                if (aVar == null) {
                    aVar2 = new a();
                    aVar2.nickName = i.b(this.context, r.gw(aeVar.field_username), cVar.kHt.getTextSize());
                    string = aeVar.field_status != 1 ? this.context.getString(R.l.euN) : aeVar.field_conversationTime != Long.MAX_VALUE ? "" : com.tencent.mm.pluginsdk.h.n.c(this.context, aeVar.field_conversationTime, true);
                    aVar2.zgd = string;
                    textSize = (int) cVar.kHv.getTextSize();
                    Gc = q.Gc();
                    str = aeVar.field_username;
                    as.Hm();
                    obj = t.e((Integer) com.tencent.mm.y.c.Db().get(17, null)) != 1 ? 1 : null;
                    if (str.equals("qqmail") || obj != null) {
                        as.Hm();
                        FE = com.tencent.mm.y.c.Fn().FE("@t.qq.com");
                        obj = (FE == null && FE.isEnable()) ? 1 : null;
                        if (str.equals("tmessage") || obj != null) {
                            string = (str.equals("qmessage") || ((Gc & 64) == 0 ? 1 : null) != null) ? i.c(this.context, h.a(aeVar.field_isSend, aeVar.field_username, aeVar.field_content, wv(aeVar.field_msgType), this.context), textSize) : this.context.getString(R.l.eMI);
                        } else {
                            string = this.context.getString(R.l.eMI);
                        }
                    } else {
                        string = this.context.getString(R.l.eMI);
                    }
                    aVar2.zge = string;
                    if (s.eX(aeVar.field_username) && m.gn(aeVar.field_username) == 0) {
                        aVar2.nickName = this.context.getString(R.l.dSY);
                    }
                    switch (aeVar.field_status) {
                        case 0:
                            i3 = -1;
                            break;
                        case 1:
                            i3 = R.k.dzp;
                            break;
                        case 2:
                            i3 = -1;
                            break;
                        case 5:
                            i3 = R.k.dzo;
                            break;
                        default:
                            i3 = -1;
                            break;
                    }
                    aVar2.zgf = i3;
                    this.yvZ.put(aeVar.field_username + aeVar.field_content, aVar2);
                    aVar = aVar2;
                }
                cVar.kHv.setTextColor(this.yvY[i2]);
                cVar.kHt.setText(aVar.nickName);
                cVar.kHu.setText(aVar.zgd);
                cVar.kHv.setText(i.b(this.context, aVar.zge.toString(), cVar.kHv.getTextSize()));
                if (aeVar.field_conversationTime != 0) {
                    cVar.kHu.setVisibility(8);
                } else {
                    cVar.kHu.setVisibility(0);
                }
                cVar.ywg.setVisibility(8);
                if (s.eX(aeVar.field_username)) {
                    as.Hm();
                    Xv = com.tencent.mm.y.c.Ff().Xv(aeVar.field_username);
                    if (Xv != null && Xv.fXi == 0) {
                        cVar.ywg.setVisibility(0);
                    }
                }
                com.tencent.mm.pluginsdk.ui.a.b.a(cVar.ikK, aeVar.field_username);
                if (this.zfI) {
                    if (aeVar.field_unReadCount > 100) {
                        cVar.kHx.setText("...");
                        cVar.kHx.setVisibility(0);
                    } else if (aeVar.field_unReadCount <= 0) {
                        cVar.kHx.setText(aeVar.field_unReadCount);
                        cVar.kHx.setVisibility(0);
                    } else {
                        cVar.kHx.setVisibility(4);
                    }
                }
                if (as.Hp()) {
                    if (!s.a(aeVar)) {
                        as.Hm();
                        if (com.tencent.mm.y.c.Fk().g(aeVar)) {
                            as.Hm();
                            com.tencent.mm.y.c.Fk().f(aeVar);
                        }
                    }
                    as.Hm();
                    if (com.tencent.mm.y.c.Fk().g(aeVar)) {
                        view.findViewById(R.h.bYZ).setBackgroundResource(R.g.bBy);
                    } else {
                        view.findViewById(R.h.bYZ).setBackgroundResource(R.g.bBx);
                    }
                }
                rkVar = new rk();
                rkVar.fJX.fJZ = true;
                com.tencent.mm.sdk.b.a.xmy.m(rkVar);
                if (!(0 == com.tencent.mm.plugin.messenger.foundation.a.a.a.a(aeVar, 7, 0) || aeVar.field_username.equals(rkVar.fJY.fKb))) {
                    aeVar.ak(com.tencent.mm.plugin.messenger.foundation.a.a.a.a(aeVar, 6, aeVar.field_conversationTime));
                    as.Hm();
                    com.tencent.mm.y.c.Fk().a(aeVar, aeVar.field_username);
                }
                if (com.tencent.mm.pluginsdk.q.a.viX == null && com.tencent.mm.pluginsdk.q.a.viX.MW(aeVar.field_username)) {
                    cVar.ywh.setVisibility(0);
                    if (aeVar.field_username.equals(rkVar.fJY.fKb)) {
                        cVar.ywh.setImageResource(R.k.dBl);
                    } else {
                        cVar.ywh.setImageResource(R.k.dBk);
                    }
                } else {
                    cVar.ywh.setVisibility(8);
                }
                return view;
            }
        }
        i2 = 0;
        if (view != null) {
            cVar = (c) view.getTag();
        } else {
            cVar = new c();
            view = View.inflate(this.context, R.i.drB, null);
            cVar.ikK = (ImageView) view.findViewById(R.h.bLM);
            cVar.kHt = (TextView) view.findViewById(R.h.cAs);
            cVar.kHu = (TextView) view.findViewById(R.h.cTY);
            cVar.kHv = (TextView) view.findViewById(R.h.csB);
            cVar.kHx = (TextView) view.findViewById(R.h.cSe);
            cVar.kHx.setBackgroundResource(com.tencent.mm.ui.tools.s.ge(this.context));
            cVar.ywg = (ImageView) view.findViewById(R.h.cpv);
            cVar.ywh = (ImageView) view.findViewById(R.h.cQF);
            view.setTag(cVar);
        }
        aVar = (a) this.yvZ.get(aeVar.field_username + aeVar.field_content);
        if (aVar == null) {
            aVar2 = new a();
            aVar2.nickName = i.b(this.context, r.gw(aeVar.field_username), cVar.kHt.getTextSize());
            if (aeVar.field_status != 1) {
                if (aeVar.field_conversationTime != Long.MAX_VALUE) {
                }
            }
            aVar2.zgd = string;
            textSize = (int) cVar.kHv.getTextSize();
            Gc = q.Gc();
            str = aeVar.field_username;
            as.Hm();
            if (t.e((Integer) com.tencent.mm.y.c.Db().get(17, null)) != 1) {
            }
            if (str.equals("qqmail")) {
            }
            as.Hm();
            FE = com.tencent.mm.y.c.Fn().FE("@t.qq.com");
            if (FE == null) {
            }
            if (str.equals("tmessage")) {
            }
            if ((Gc & 64) == 0) {
            }
            if (str.equals("qmessage")) {
            }
            aVar2.zge = string;
            aVar2.nickName = this.context.getString(R.l.dSY);
            switch (aeVar.field_status) {
                case 0:
                    i3 = -1;
                    break;
                case 1:
                    i3 = R.k.dzp;
                    break;
                case 2:
                    i3 = -1;
                    break;
                case 5:
                    i3 = R.k.dzo;
                    break;
                default:
                    i3 = -1;
                    break;
            }
            aVar2.zgf = i3;
            this.yvZ.put(aeVar.field_username + aeVar.field_content, aVar2);
            aVar = aVar2;
        }
        cVar.kHv.setTextColor(this.yvY[i2]);
        cVar.kHt.setText(aVar.nickName);
        cVar.kHu.setText(aVar.zgd);
        cVar.kHv.setText(i.b(this.context, aVar.zge.toString(), cVar.kHv.getTextSize()));
        if (aeVar.field_conversationTime != 0) {
            cVar.kHu.setVisibility(0);
        } else {
            cVar.kHu.setVisibility(8);
        }
        cVar.ywg.setVisibility(8);
        if (s.eX(aeVar.field_username)) {
            as.Hm();
            Xv = com.tencent.mm.y.c.Ff().Xv(aeVar.field_username);
            cVar.ywg.setVisibility(0);
        }
        com.tencent.mm.pluginsdk.ui.a.b.a(cVar.ikK, aeVar.field_username);
        if (this.zfI) {
            if (aeVar.field_unReadCount > 100) {
                cVar.kHx.setText("...");
                cVar.kHx.setVisibility(0);
            } else if (aeVar.field_unReadCount <= 0) {
                cVar.kHx.setVisibility(4);
            } else {
                cVar.kHx.setText(aeVar.field_unReadCount);
                cVar.kHx.setVisibility(0);
            }
        }
        if (as.Hp()) {
            if (s.a(aeVar)) {
                as.Hm();
                if (com.tencent.mm.y.c.Fk().g(aeVar)) {
                    as.Hm();
                    com.tencent.mm.y.c.Fk().f(aeVar);
                }
            }
            as.Hm();
            if (com.tencent.mm.y.c.Fk().g(aeVar)) {
                view.findViewById(R.h.bYZ).setBackgroundResource(R.g.bBx);
            } else {
                view.findViewById(R.h.bYZ).setBackgroundResource(R.g.bBy);
            }
        }
        rkVar = new rk();
        rkVar.fJX.fJZ = true;
        com.tencent.mm.sdk.b.a.xmy.m(rkVar);
        aeVar.ak(com.tencent.mm.plugin.messenger.foundation.a.a.a.a(aeVar, 6, aeVar.field_conversationTime));
        as.Hm();
        com.tencent.mm.y.c.Fk().a(aeVar, aeVar.field_username);
        if (com.tencent.mm.pluginsdk.q.a.viX == null) {
        }
        cVar.ywh.setVisibility(8);
        return view;
    }

    private static int wv(String str) {
        int i = 1;
        if (str == null || str.length() <= 0) {
            return i;
        }
        try {
            return Integer.valueOf(str).intValue();
        } catch (NumberFormatException e) {
            return i;
        }
    }

    public final void a(String str, l lVar) {
        if (str != null && !str.equals("") && this.yvZ != null) {
            this.yvZ.remove(str);
        } else if (this.yvZ != null) {
            this.yvZ.clear();
        }
        super.a(str, lVar);
    }

    public final void Ds(String str) {
        this.inJ = str;
        aUU();
        XH();
    }
}
