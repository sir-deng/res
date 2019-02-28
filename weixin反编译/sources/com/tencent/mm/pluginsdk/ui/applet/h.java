package com.tencent.mm.pluginsdk.ui.applet;

import android.content.Context;
import android.text.SpannableString;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import com.tencent.mm.ap.a.a.c;
import com.tencent.mm.ap.o;
import com.tencent.mm.f.b.ag;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.comm.a.e;
import com.tencent.mm.plugin.comm.a.f;
import com.tencent.mm.pluginsdk.ui.d;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.storage.q;
import com.tencent.mm.storage.x;
import com.tencent.mm.y.s;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public final class h extends BaseAdapter {
    public static int vuo = 44;
    public static int vup = 5;
    boolean fAu;
    private List<String> fBI = new ArrayList();
    q lfE;
    boolean lhA;
    c liE = null;
    private Context mContext;
    String username;
    d vuA;
    public boolean vuB = false;
    public boolean vuC = false;
    public boolean vuD = false;
    private boolean vuE = true;
    boolean vuF = false;
    int vuG = 12;
    String vuH;
    private final int vuI;
    public boolean vuJ = false;
    private boolean vuK = true;
    private boolean vuL = false;
    boolean vuM = true;
    public boolean vuN = false;
    a vuq;
    private ArrayList<x> vur = new ArrayList();
    boolean vus = false;
    public boolean vut = false;
    public boolean vuu = false;
    private List<x> vuv = new ArrayList();
    private List<Object> vuw = new ArrayList();
    private Set<String> vux = new HashSet();
    int vuy = 0;
    int vuz = 0;

    class b {
        public ImageView ikK;
        public TextView kHt;
        public ImageView kHw;
        public int kZv;
        public TextView liG;
        public ImageView qry;
        public ImageView vuO;

        b() {
        }
    }

    public interface a {
        void bYt();
    }

    public h(Context context) {
        this.mContext = context;
        this.lhA = false;
        this.vuI = context.getResources().getDimensionPixelSize(com.tencent.mm.plugin.comm.a.c.bup);
    }

    public final boolean cbH() {
        if (this.vus) {
            return this.vuu;
        }
        return s.eX(this.username);
    }

    public final void bU(List<String> list) {
        this.vuE = true;
        this.fBI = list;
    }

    public final void ac(ArrayList<x> arrayList) {
        this.vuE = false;
        this.vur = arrayList;
    }

    private void cbI() {
        if (this.vur != null) {
            com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ContactsListArchAdapter", "initData memberContactList.size %d", Integer.valueOf(this.vur.size()));
            this.vux.clear();
            this.vuv.clear();
            if (this.vur.size() > 0) {
                Iterator it = this.vur.iterator();
                while (it.hasNext()) {
                    x xVar = (x) it.next();
                    this.vuv.add(xVar);
                    this.vux.add(xVar.field_username);
                }
            }
            this.vuz = this.vuv.size();
        }
    }

    public final boolean Cr(int i) {
        if (this.lhA) {
            return false;
        }
        if (i >= this.vuz) {
            return true;
        }
        this.lhA = true;
        bYt();
        return true;
    }

    private void bYt() {
        if (this.vuq != null) {
            this.vuq.bYt();
        }
    }

    private b db(View view) {
        b bVar = new b();
        bVar.vuO = (ImageView) view.findViewById(e.cIr);
        bVar.ikK = (ImageView) view.findViewById(e.cIA);
        bVar.qry = (ImageView) view.findViewById(e.ltC);
        bVar.kHt = (TextView) view.findViewById(e.ltE);
        bVar.liG = (TextView) view.findViewById(e.cIz);
        bVar.kHw = (ImageView) view.findViewById(e.ltD);
        bVar.ikK.setScaleType(ScaleType.CENTER_CROP);
        view.setTag(bVar);
        return bVar;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        Object item;
        ag agVar;
        int i2;
        b db;
        int dimensionPixelSize;
        if (i < this.vuz) {
            if (this.vus) {
                item = getItem(i);
                agVar = null;
                i2 = 0;
            } else {
                item = null;
                agVar = (x) getItem(i);
                i2 = 0;
            }
        } else if (i == this.vuz && this.vuC) {
            item = null;
            agVar = null;
            i2 = 3;
        } else if (i == this.vuz + 1 && this.vuB) {
            item = null;
            agVar = null;
            i2 = 4;
        } else if (i == this.vuz + 1 && this.vuD && !this.vuB) {
            item = null;
            agVar = null;
            i2 = 5;
        } else if (i == this.vuz + 2 && this.vuD && this.vuB) {
            item = null;
            agVar = null;
            i2 = 5;
        } else {
            item = null;
            agVar = null;
            i2 = 2;
        }
        if (view == null) {
            view = View.inflate(this.mContext, f.dra, null);
            db = db(view);
        } else {
            b bVar = (b) view.getTag();
            if (bVar == null) {
                db = db(view);
            } else {
                db = bVar;
            }
        }
        if (vup == 4 || this.vuN) {
            dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(com.tencent.mm.plugin.comm.a.c.bvG);
            db.ikK.getLayoutParams().height = dimensionPixelSize;
            db.ikK.getLayoutParams().width = dimensionPixelSize;
        } else {
            dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(com.tencent.mm.plugin.comm.a.c.bvE);
            db.ikK.getLayoutParams().height = dimensionPixelSize;
            db.ikK.getLayoutParams().width = dimensionPixelSize;
        }
        db.vuO.setVisibility(8);
        TextView textView;
        if (i2 == 0) {
            CharSequence gw;
            db.ikK.setVisibility(0);
            if (this.fAu) {
                if (bi.oN(agVar.field_conRemark)) {
                    String str = agVar.field_username;
                    if (this.lfE == null) {
                        Object gw2 = null;
                    } else {
                        gw2 = this.lfE.gw(str);
                    }
                } else {
                    gw2 = agVar.field_conRemark;
                }
                if (bi.oN(gw2)) {
                    gw2 = agVar.field_conRemark;
                }
                if (bi.oN(gw2)) {
                    gw2 = agVar.AW();
                }
                gw2 = i.b(this.mContext, gw2, db.kHt.getTextSize());
            } else if (this.vus) {
                gw2 = i.b(this.mContext, com.tencent.mm.pluginsdk.ui.applet.n.a.vva.bQ(item), db.kHt.getTextSize());
            } else if (x.Xg(agVar.field_username)) {
                com.tencent.mm.openim.a.b bVar2 = (com.tencent.mm.openim.a.b) g.h(com.tencent.mm.openim.a.b.class);
                Context context = ad.getContext();
                String AX = agVar.AX();
                String str2 = agVar.field_openImAppid;
                gw2 = bVar2.b(context, AX, (int) db.kHt.getTextSize());
            } else {
                gw2 = i.b(this.mContext, agVar.AX(), db.kHt.getTextSize());
            }
            if (gw2 instanceof SpannableString) {
                db.kHt.setVisibility(8);
                db.liG.setVisibility(0);
                db.liG.setText(gw2);
            } else {
                db.kHt.setVisibility(0);
                db.liG.setVisibility(8);
                db.kHt.setText(gw2);
            }
            db.ikK.setContentDescription("");
            if (this.vus) {
                o.PG().a(com.tencent.mm.pluginsdk.ui.applet.n.a.vva.bR(item), db.ikK, this.liE);
                db.ikK.setBackgroundDrawable(null);
            } else {
                com.tencent.mm.pluginsdk.ui.a.b.a(db.ikK, agVar.field_username);
                com.tencent.mm.pluginsdk.ui.a aVar = (com.tencent.mm.pluginsdk.ui.a) db.ikK.getDrawable();
                if (this.vuA != null) {
                    this.vuA.a(aVar);
                }
            }
            if (this.vus) {
                if (!this.lhA || (this.vuH != null && this.vuH.equals(com.tencent.mm.pluginsdk.ui.applet.n.a.vva.bS(item)))) {
                    db.qry.setVisibility(8);
                } else {
                    db.qry.setVisibility(0);
                }
            } else if (!this.lhA || (this.vuH != null && this.vuH.equals(agVar.field_username))) {
                db.qry.setVisibility(8);
            } else {
                db.qry.setVisibility(0);
            }
        } else if (i2 == 3) {
            db.kHt.setVisibility(i == 0 ? 8 : 4);
            textView = db.liG;
            if (i == 0) {
                dimensionPixelSize = 8;
            } else {
                dimensionPixelSize = 4;
            }
            textView.setVisibility(dimensionPixelSize);
            db.qry.setVisibility(8);
            if (this.lhA) {
                db.ikK.setVisibility(4);
            } else {
                db.ikK.setVisibility(0);
                if (this.vus) {
                    o.PG().a("", db.ikK, this.liE);
                    db.ikK.setBackgroundDrawable(null);
                }
                db.ikK.setImageResource(com.tencent.mm.plugin.comm.a.d.bzl);
                db.ikK.setContentDescription(this.mContext.getString(com.tencent.mm.plugin.comm.a.h.lub));
            }
        } else if (i2 == 4) {
            db.kHt.setVisibility(1 == i ? 8 : 4);
            textView = db.liG;
            if (1 == i) {
                dimensionPixelSize = 8;
            } else {
                dimensionPixelSize = 4;
            }
            textView.setVisibility(dimensionPixelSize);
            db.qry.setVisibility(8);
            if (this.lhA || this.vuz == 0) {
                db.ikK.setVisibility(4);
            } else {
                db.ikK.setVisibility(0);
                if (this.vus) {
                    o.PG().a("", db.ikK, this.liE);
                    db.ikK.setBackgroundDrawable(null);
                }
                db.ikK.setImageResource(com.tencent.mm.plugin.comm.a.d.bzm);
                db.ikK.setContentDescription(this.mContext.getString(com.tencent.mm.plugin.comm.a.h.lui));
            }
        } else if (i2 == 5) {
            textView = db.kHt;
            if (i == 0) {
                dimensionPixelSize = 8;
            } else {
                dimensionPixelSize = 4;
            }
            textView.setVisibility(dimensionPixelSize);
            textView = db.liG;
            if (i == 0) {
                dimensionPixelSize = 8;
            } else {
                dimensionPixelSize = 4;
            }
            textView.setVisibility(dimensionPixelSize);
            db.qry.setVisibility(8);
            if (this.lhA) {
                db.ikK.setVisibility(4);
            } else {
                db.ikK.setVisibility(0);
                if (this.vus) {
                    o.PG().a("", db.ikK, this.liE);
                    db.ikK.setBackgroundDrawable(null);
                }
                db.ikK.setImageResource(com.tencent.mm.plugin.comm.a.d.ltw);
                db.ikK.setContentDescription(this.mContext.getString(com.tencent.mm.plugin.comm.a.h.luP));
            }
        } else if (i2 == 2) {
            if (this.vus) {
                o.PG().a("", db.ikK, this.liE);
            }
            db.kHt.setVisibility(4);
            db.liG.setVisibility(4);
            db.qry.setVisibility(8);
            db.ikK.setVisibility(4);
            db.ikK.setImageResource(com.tencent.mm.plugin.comm.a.d.bDK);
            db.ikK.setBackgroundResource(com.tencent.mm.plugin.comm.a.d.bDK);
        }
        if (!this.vus || item == null) {
            db.kHw.setVisibility(8);
        }
        db.kZv = i2;
        return view;
    }

    public final boolean Cs(int i) {
        return i < this.vuz;
    }

    public final void notifyChanged() {
        if (this.fBI != null || this.vur != null) {
            if (!this.vuE) {
                cbI();
            } else if (this.fBI != null) {
                com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ContactsListArchAdapter", "initData memberList.size %d", Integer.valueOf(this.fBI.size()));
                this.vux.clear();
                this.vuv.clear();
                this.vuw.clear();
                if (this.fBI.size() > 0) {
                    String str;
                    x xVar;
                    for (String str2 : this.fBI) {
                        if (this.vus) {
                            this.vuw.add(com.tencent.mm.pluginsdk.ui.applet.n.a.vva.SS(str2));
                        } else {
                            ag Xv = ((com.tencent.mm.plugin.messenger.foundation.a.h) g.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).Ff().Xv(str2);
                            if (Xv == null || bi.oN(Xv.field_username) || !Xv.field_username.equals(str2)) {
                                this.vuv.add(new x(this.username));
                            } else {
                                this.vuv.add(Xv);
                            }
                        }
                        this.vux.add(str2);
                    }
                    if (this.vuK && !bi.oN(this.vuH) && this.fBI.contains(this.vuH)) {
                        if (!this.vus) {
                            for (x xVar2 : this.vuv) {
                                if (this.vuH.equals(xVar2.field_username)) {
                                    this.vuv.remove(xVar2);
                                    this.vuv.add(0, xVar2);
                                    break;
                                }
                            }
                        }
                        for (Object next : this.vuw) {
                            if (this.vuH.equals(com.tencent.mm.pluginsdk.ui.applet.n.a.vva.bS(next))) {
                                this.vuw.remove(next);
                                this.vuw.add(0, next);
                                break;
                            }
                        }
                    }
                    if (this.vuL && !this.vus) {
                        String aD = bi.aD((String) g.Dq().Db().get(2, null), "");
                        if (this.fBI.contains(aD)) {
                            this.vux.remove(aD);
                            for (x xVar22 : this.vuv) {
                                if (aD.equals(xVar22.field_username)) {
                                    this.vuv.remove(xVar22);
                                    break;
                                }
                            }
                        }
                        ag Xv2 = ((com.tencent.mm.plugin.messenger.foundation.a.h) g.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).Ff().Xv(aD);
                        if (Xv2 == null || bi.oN(Xv2.field_username) || !Xv2.field_username.equals(aD)) {
                            this.vuv.add(1, new x(aD));
                        } else {
                            this.vuv.add(1, Xv2);
                        }
                        this.vux.add(aD);
                        if (this.vuM && this.vuv.size() >= 3) {
                            int size = this.vuv.size();
                            LinkedList linkedList = new LinkedList();
                            for (int i = 0; i < size; i++) {
                                xVar22 = (x) this.vuv.get(i);
                                if (xVar22.field_showHead > 0) {
                                    linkedList.add(xVar22.field_showHead);
                                } else if (!bi.oN(xVar22.field_conRemark)) {
                                    linkedList.add(xVar22.field_conRemark);
                                } else if (!bi.oN(xVar22.field_conRemarkPYShort)) {
                                    linkedList.add(xVar22.field_conRemarkPYShort);
                                } else if (!bi.oN(xVar22.field_conRemarkPYFull)) {
                                    linkedList.add(xVar22.field_conRemarkPYFull);
                                } else if (!bi.oN(xVar22.vX())) {
                                    linkedList.add(xVar22.vX());
                                } else if (!bi.oN(xVar22.field_username)) {
                                    linkedList.add(xVar22.field_username);
                                }
                            }
                            com.tencent.mm.sdk.platformtools.x.v("MicroMsg.ContactsListArchAdapter", "klem, order list:%s", linkedList.toString());
                            List arrayList = new ArrayList();
                            arrayList.add(this.vuv.get(0));
                            arrayList.add(this.vuv.get(1));
                            List linkedList2 = new LinkedList();
                            linkedList2.add(linkedList.get(0));
                            linkedList2.add(linkedList.get(0));
                            int size2 = this.vuv.size();
                            for (int i2 = 2; i2 < size2; i2++) {
                                str2 = (String) linkedList.get(i2);
                                int size3 = arrayList.size();
                                int i3 = 1;
                                while (i3 < size3 && str2.compareToIgnoreCase((String) linkedList2.get(i3)) >= 0) {
                                    i3++;
                                }
                                linkedList2.add(i3, str2);
                                arrayList.add(i3, this.vuv.get(i2));
                            }
                            this.vuv.clear();
                            this.vuv = arrayList;
                        }
                    }
                }
                if (this.vus) {
                    this.vuz = this.vuw.size();
                } else if (!this.fAu) {
                    this.vuz = this.vuv.size();
                } else if (bi.oN(this.vuH) || !(this.vuH == null || this.vuH.equals(com.tencent.mm.y.q.FY()))) {
                    this.vuz = this.vuv.size() >= vuo ? vuo : this.vuv.size();
                } else {
                    this.vuz = this.vuv.size() >= vuo + -1 ? vuo - 1 : this.vuv.size();
                }
            }
            if (this.vuz == 0) {
                this.vuy = vup;
            } else if (this.vuC && this.vuB && this.vuD) {
                this.vuy = (((this.vuz + 2) / vup) + 1) * vup;
            } else if ((this.vuC && this.vuB && !this.vuD) || ((this.vuC && !this.vuB && this.vuD) || (!this.vuC && this.vuB && this.vuD))) {
                this.vuy = (((this.vuz + 1) / vup) + 1) * vup;
            } else if ((this.vuC && !this.vuB && !this.vuD) || ((!this.vuC && this.vuB && !this.vuD) || (!this.vuC && !this.vuB && this.vuD))) {
                this.vuy = ((this.vuz / vup) + 1) * vup;
            } else if (!(this.vuC || this.vuB || this.vuD)) {
                this.vuy = (((this.vuz - 1) / vup) + 1) * vup;
            }
            com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ContactsListArchAdapter", "Number Size  contactSize :" + this.vuz + " realySize : " + this.vuy);
            bYt();
        }
    }

    public final int getCount() {
        if (this.vuF) {
            return Math.min(this.vuG, this.vuy);
        }
        return this.vuy;
    }

    public final Object getItem(int i) {
        if (i >= this.vuz) {
            return null;
        }
        if (this.vus) {
            return this.vuw.get(i);
        }
        return this.vuv.get(i);
    }

    public final long getItemId(int i) {
        return (long) i;
    }
}
