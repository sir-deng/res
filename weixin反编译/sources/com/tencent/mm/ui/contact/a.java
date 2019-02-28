package com.tencent.mm.ui.contact;

import android.content.Context;
import android.content.res.ColorStateList;
import android.database.Cursor;
import android.support.v4.app.Fragment;
import android.util.SparseArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.af.m;
import com.tencent.mm.f.b.ag;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bc;
import com.tencent.mm.ui.AddressView;
import com.tencent.mm.ui.base.MMSlideDelView;
import com.tencent.mm.ui.base.MMSlideDelView.c;
import com.tencent.mm.ui.base.MMSlideDelView.d;
import com.tencent.mm.ui.base.MMSlideDelView.e;
import com.tencent.mm.ui.f;
import com.tencent.mm.ui.v;
import com.tencent.mm.y.as;
import com.tencent.mm.y.q;
import com.tencent.mm.y.s;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class a extends f<String, com.tencent.mm.storage.f> implements com.tencent.mm.sdk.e.m.b {
    public static final ColorStateList nUY = com.tencent.mm.bu.a.Z(ad.getContext(), R.e.bth);
    public static final ColorStateList nUZ = com.tencent.mm.bu.a.Z(ad.getContext(), R.e.bsO);
    private com.tencent.mm.ui.applet.b hxF = null;
    private String inJ = "";
    protected MMSlideDelView.f kHo;
    protected c kHp;
    protected d kHr = MMSlideDelView.cql();
    private boolean kLF = false;
    protected List<String> koG = null;
    OnClickListener myR = new OnClickListener() {
        public final void onClick(View view) {
            x.v("MicroMsg.AddressAdapter", "on delView clicked");
            a.this.kHr.aVg();
            if (a.this.oUV != null) {
                a.this.oUV.bp(((ViewStub) a.this.yYR.get(view)).getTag());
            }
        }
    };
    protected e oUV;
    StringBuilder sb = new StringBuilder(32);
    private int type;
    protected String yYA = null;
    protected String yYB = null;
    private List<Object> yYC;
    private List<String> yYD;
    private int yYE = 0;
    protected int[] yYF;
    String[] yYG;
    protected com.tencent.mm.ui.contact.AddressUI.a yYH;
    private Set<Integer> yYI = new HashSet();
    private int yYJ = 0;
    private boolean yYK = true;
    a yYL;
    private boolean yYM = false;
    boolean yYN = false;
    private String yYO;
    LinkedList<View> yYP = new LinkedList();
    boolean yYQ;
    HashMap<View, ViewStub> yYR = new HashMap();
    private SparseArray<String> yYS = new SparseArray();
    private SparseArray<Integer> yYT = new SparseArray();
    private HashSet<String> yYU = new HashSet();
    public HashMap<String, com.tencent.mm.storage.f> yYz = new HashMap();
    private String[] yvM = null;

    public interface a {
    }

    protected static class b {
        public TextView nOK;
        public TextView nOL;
        public AddressView nVd;
        public TextView yYW;
        public View yYX;
        public TextView yYY;
    }

    public final /* synthetic */ com.tencent.mm.bx.a.a clM() {
        return new com.tencent.mm.storage.f();
    }

    public final /* synthetic */ void q(Object obj, int i) {
        dt((String) obj, i);
    }

    public final void dt(String str, int i) {
        if (i == 5) {
            this.yYU.add(str);
        }
        super.q(str, i);
    }

    public final void pause() {
        this.yYU.clear();
        super.pause();
    }

    public void notifyDataSetChanged() {
        this.yYO = q.FY();
        if (this.yYF == null) {
            cwv();
        }
        if (getCount() == 0) {
            super.notifyDataSetChanged();
            return;
        }
        this.yYJ = cmL();
        x.i("MicroMsg.AddressAdapter", "newcursor favourCount %d", Integer.valueOf(this.yYJ));
        super.notifyDataSetChanged();
    }

    public a(Context context, String str, String str2, int i, boolean z) {
        super(context);
        this.context = context;
        this.yYA = str;
        this.yYB = str2;
        this.type = i;
        this.yYM = true;
        this.yYC = new LinkedList();
        this.yYD = new LinkedList();
        this.yYO = q.FY();
        this.TAG = "MiscroMsg.AddressDrawWithCacheAdapter";
    }

    public final void l(Fragment fragment) {
        if (fragment instanceof com.tencent.mm.ui.contact.AddressUI.a) {
            this.yYH = (com.tencent.mm.ui.contact.AddressUI.a) fragment;
        }
    }

    public final void detach() {
        if (this.hxF != null) {
            this.hxF.detach();
            this.hxF = null;
        }
    }

    public final void a(MMSlideDelView.f fVar) {
        this.kHo = fVar;
    }

    public final void a(e eVar) {
        this.oUV = eVar;
    }

    public final void a(c cVar) {
        this.kHp = cVar;
    }

    public final void dv(List<String> list) {
        if (this.type != 2) {
            list.add(q.FY());
        }
        as.Hm();
        bc FE = com.tencent.mm.y.c.Fn().FE("@t.qq.com");
        if (FE != null) {
            list.add(FE.name);
        }
        if (this.type == 3 || this.type == 5 || this.type == 4 || this.type == 1 || this.type == 0) {
            for (String add : s.GI()) {
                list.add(add);
            }
        }
        list.add("blogapp");
        this.koG = list;
    }

    public final int getPositionForSection(int i) {
        if (this.yYF != null && i >= 0 && i < this.yYF.length) {
            i = this.yYF[i];
        }
        return this.yYJ + i;
    }

    private boolean cwt() {
        return this.yYA.equals("@micromsg.qq.com") || this.yYA.equals("@all.contact.without.chatroom");
    }

    protected Cursor cwu() {
        long currentTimeMillis = System.currentTimeMillis();
        List linkedList = new LinkedList();
        linkedList.add("weixin");
        as.Hm();
        Cursor a = com.tencent.mm.y.c.Ff().a(this.yYA, this.yYB, this.koG, linkedList, cwt(), this.yYM);
        x.d("MicroMsg.AddressAdapter", "kevin setCursor : " + (System.currentTimeMillis() - currentTimeMillis));
        return a;
    }

    protected final void cwv() {
        int count = getCount();
        if (count != 0) {
            int i;
            int i2;
            this.yYJ = cmL();
            if (this.yvM != null) {
                this.yYF = s.a(this.yYA, this.yYB, this.koG, this.yvM);
                this.yYG = s.a(this.yYA, this.yYB, this.yvM, this.koG);
            } else if (clE()) {
                long currentTimeMillis = System.currentTimeMillis();
                HashSet hashSet = new HashSet();
                this.yYF = new int[30];
                this.yYG = new String[30];
                i = this.yYJ;
                int i3 = 0;
                while (i < count) {
                    com.tencent.mm.storage.f fVar = (com.tencent.mm.storage.f) DV(i);
                    if (fVar != null) {
                        String b = b(fVar, i);
                        if (hashSet.add(b)) {
                            this.yYF[i3] = i - this.yYJ;
                            this.yYG[i3] = b;
                            i2 = i3 + 1;
                        }
                        i2 = i3;
                    } else {
                        x.d("MicroMsg.AddressAdapter", "newCursor getItem is null");
                        i2 = i3;
                    }
                    i++;
                    i3 = i2;
                }
                x.d("MicroMsg.AddressAdapter", "newCursor resetShowHead by Memory : " + (System.currentTimeMillis() - currentTimeMillis) + "favourCount : " + this.yYJ);
            } else {
                long currentTimeMillis2 = System.currentTimeMillis();
                this.yYF = s.b(this.yYA, this.yYB, this.koG, this.inJ);
                this.yYG = s.a(this.yYA, this.yYB, this.inJ, this.koG);
                x.d("MicroMsg.AddressAdapter", "kevin resetShowHead part1 : " + (System.currentTimeMillis() - currentTimeMillis2));
            }
            this.yYI.clear();
            for (int i4 : this.yYF) {
                this.yYI.add(Integer.valueOf(i4 - 1));
            }
        }
    }

    public final void cww() {
        this.kHr.aVg();
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        b bVar;
        int i2 = -1;
        if (!this.yYQ) {
            for (int i3 = 0; i3 < 8; i3++) {
                this.yYP.add(v.fw(this.context).inflate(R.i.dai, null));
            }
            this.yYQ = true;
        }
        com.tencent.mm.storage.f fVar = (com.tencent.mm.storage.f) DV(i);
        as.Hm();
        ag Xv = com.tencent.mm.y.c.Ff().Xv(fVar.field_username);
        x.d("MicroMsg.AddressAdapter", "user:%s, remark:%s", Xv.field_username, Xv.field_conRemark);
        if (view == null) {
            View view2;
            if (this.yYP.size() > 0) {
                View view3 = (View) this.yYP.getFirst();
                this.yYP.removeFirst();
                view2 = view3;
            } else {
                view2 = View.inflate(this.context, R.i.dai, null);
            }
            bVar = new b();
            bVar.nOK = (TextView) view2.findViewById(R.h.bYB);
            bVar.nOL = (TextView) view2.findViewById(R.h.bYG);
            bVar.nVd = (AddressView) view2.findViewById(R.h.cyE);
            bVar.yYW = (TextView) view2.findViewById(R.h.bYy);
            bVar.yYX = view2.findViewById(R.h.bYF);
            bVar.yYY = (TextView) view2.findViewById(R.h.cBQ);
            LayoutParams layoutParams = bVar.yYX.getLayoutParams();
            layoutParams.height = (int) (((float) com.tencent.mm.bu.a.ab(this.context, R.f.buB)) * com.tencent.mm.bu.a.ey(this.context));
            bVar.yYX.setLayoutParams(layoutParams);
            if (this.yYH != null) {
                this.yYH.lfI.a(bVar.nVd);
            }
            view2.setTag(bVar);
            view = view2;
        } else {
            bVar = (b) view.getTag();
        }
        if (fVar != null) {
            CharSequence b;
            String gQ;
            Context context;
            String str;
            Object obj;
            com.tencent.mm.storage.f fVar2 = (com.tencent.mm.storage.f) DV(i - 1);
            com.tencent.mm.storage.f fVar3 = (com.tencent.mm.storage.f) DV(i + 1);
            int a = fVar2 == null ? -1 : a(fVar2, i - 1);
            int a2 = a(fVar, i);
            if (fVar3 != null) {
                i2 = a(fVar3, i + 1);
            }
            if (this.yYK) {
                if (i == 0) {
                    b = b(fVar, i);
                    if (!t.oN(b)) {
                        bVar.nOK.setVisibility(0);
                        bVar.nOK.setText(b);
                        if (!this.yYK || a2 == i2) {
                            bVar.yYX.setBackgroundResource(R.g.bDq);
                        }
                        com.tencent.mm.pluginsdk.ui.a.b.a(bVar.nVd, fVar.field_username);
                        if (fVar.field_verifyFlag != 0) {
                            bVar.nVd.setMaskBitmap(null);
                        } else if (com.tencent.mm.y.ak.a.hhx != null) {
                            gQ = com.tencent.mm.y.ak.a.hhx.gQ(fVar.field_verifyFlag);
                            if (gQ != null) {
                                bVar.nVd.setMaskBitmap(m.ki(gQ));
                            } else {
                                bVar.nVd.setMaskBitmap(null);
                            }
                        } else {
                            bVar.nVd.setMaskBitmap(null);
                        }
                        bVar.nVd.updateTextColors();
                        b = fVar.xuN;
                        if (b == null) {
                            try {
                                if (com.tencent.mm.storage.x.Xg(fVar.field_username)) {
                                    b = ((com.tencent.mm.openim.a.b) g.h(com.tencent.mm.openim.a.b.class)).b(ad.getContext(), fVar.AX(), com.tencent.mm.bu.a.aa(this.context, R.f.bvL));
                                } else {
                                    context = this.context;
                                    b = fVar.AX();
                                    str = fVar.field_username;
                                    if (b == null || b.length() <= 0) {
                                        obj = str;
                                    }
                                    str = "";
                                    if (str.length() > 0 && !str.equals(b)) {
                                        this.sb.append(b);
                                        this.sb.append("(");
                                        this.sb.append(str);
                                        this.sb.append(")");
                                        b = this.sb.toString();
                                        this.sb.delete(0, this.sb.length());
                                    }
                                    b = i.c(context, b, com.tencent.mm.bu.a.aa(this.context, R.f.bvL));
                                }
                            } catch (Exception e) {
                                b = null;
                            }
                            if (b == null) {
                                b = "";
                            }
                            bVar.nVd.setName(b);
                        } else {
                            bVar.nVd.setName(b);
                        }
                        bVar.nVd.setDescription(t.oM(fVar.field_remarkDesc));
                        a(fVar, bVar);
                    }
                } else if (i > 0 && a2 != a) {
                    b = b(fVar, i);
                    if (!t.oN(b)) {
                        bVar.nOK.setVisibility(0);
                        bVar.nOK.setText(b);
                        bVar.yYX.setBackgroundResource(R.g.bDq);
                        com.tencent.mm.pluginsdk.ui.a.b.a(bVar.nVd, fVar.field_username);
                        if (fVar.field_verifyFlag != 0) {
                            bVar.nVd.setMaskBitmap(null);
                        } else if (com.tencent.mm.y.ak.a.hhx != null) {
                            bVar.nVd.setMaskBitmap(null);
                        } else {
                            gQ = com.tencent.mm.y.ak.a.hhx.gQ(fVar.field_verifyFlag);
                            if (gQ != null) {
                                bVar.nVd.setMaskBitmap(null);
                            } else {
                                bVar.nVd.setMaskBitmap(m.ki(gQ));
                            }
                        }
                        bVar.nVd.updateTextColors();
                        b = fVar.xuN;
                        if (b == null) {
                            bVar.nVd.setName(b);
                        } else {
                            if (com.tencent.mm.storage.x.Xg(fVar.field_username)) {
                                context = this.context;
                                b = fVar.AX();
                                str = fVar.field_username;
                                obj = str;
                                str = "";
                                this.sb.append(b);
                                this.sb.append("(");
                                this.sb.append(str);
                                this.sb.append(")");
                                b = this.sb.toString();
                                this.sb.delete(0, this.sb.length());
                                b = i.c(context, b, com.tencent.mm.bu.a.aa(this.context, R.f.bvL));
                            } else {
                                b = ((com.tencent.mm.openim.a.b) g.h(com.tencent.mm.openim.a.b.class)).b(ad.getContext(), fVar.AX(), com.tencent.mm.bu.a.aa(this.context, R.f.bvL));
                            }
                            if (b == null) {
                                b = "";
                            }
                            bVar.nVd.setName(b);
                        }
                        bVar.nVd.setDescription(t.oM(fVar.field_remarkDesc));
                        a(fVar, bVar);
                    }
                }
            }
            bVar.nOK.setVisibility(8);
            bVar.yYX.setBackgroundResource(R.g.bDq);
            com.tencent.mm.pluginsdk.ui.a.b.a(bVar.nVd, fVar.field_username);
            if (fVar.field_verifyFlag != 0) {
                bVar.nVd.setMaskBitmap(null);
            } else if (com.tencent.mm.y.ak.a.hhx != null) {
                gQ = com.tencent.mm.y.ak.a.hhx.gQ(fVar.field_verifyFlag);
                if (gQ != null) {
                    bVar.nVd.setMaskBitmap(m.ki(gQ));
                } else {
                    bVar.nVd.setMaskBitmap(null);
                }
            } else {
                bVar.nVd.setMaskBitmap(null);
            }
            bVar.nVd.updateTextColors();
            b = fVar.xuN;
            if (b == null) {
                if (com.tencent.mm.storage.x.Xg(fVar.field_username)) {
                    b = ((com.tencent.mm.openim.a.b) g.h(com.tencent.mm.openim.a.b.class)).b(ad.getContext(), fVar.AX(), com.tencent.mm.bu.a.aa(this.context, R.f.bvL));
                } else {
                    context = this.context;
                    b = fVar.AX();
                    str = fVar.field_username;
                    obj = str;
                    str = "";
                    this.sb.append(b);
                    this.sb.append("(");
                    this.sb.append(str);
                    this.sb.append(")");
                    b = this.sb.toString();
                    this.sb.delete(0, this.sb.length());
                    b = i.c(context, b, com.tencent.mm.bu.a.aa(this.context, R.f.bvL));
                }
                if (b == null) {
                    b = "";
                }
                bVar.nVd.setName(b);
            } else {
                bVar.nVd.setName(b);
            }
            bVar.nVd.setDescription(t.oM(fVar.field_remarkDesc));
            a(fVar, bVar);
        }
        bVar.nVd.updatePositionFlag();
        bVar.nVd.setContentDescription(bVar.nVd.getNickName() == null ? "" : bVar.nVd.getNickName().toString());
        return view;
    }

    protected void a(com.tencent.mm.storage.f fVar, b bVar) {
        try {
            bVar.yYY.setText(null);
            bVar.yYY.setVisibility(8);
            if (com.tencent.mm.storage.x.Xg(fVar.field_username)) {
                CharSequence aB = ((com.tencent.mm.openim.a.b) g.h(com.tencent.mm.openim.a.b.class)).aB(fVar.field_openImAppid, fVar.field_descWordingId);
                if (aB != null && aB.length() > 0) {
                    bVar.yYY.setVisibility(0);
                    bVar.yYY.setText(aB);
                }
            }
        } catch (Throwable th) {
        }
    }

    protected int a(com.tencent.mm.storage.f fVar, int i) {
        if (i < this.yYJ) {
            return 32;
        }
        if (fVar != null) {
            return fVar.field_showHead;
        }
        x.e("MicroMsg.AddressAdapter", "contact is null, position:%d", Integer.valueOf(i));
        return -1;
    }

    protected String b(com.tencent.mm.storage.f fVar, int i) {
        if (i < this.yYJ) {
            return getString(R.l.dDg);
        }
        if (fVar.field_showHead == 31) {
            return "";
        }
        if (fVar.field_showHead == 123) {
            return "#";
        }
        if (fVar.field_showHead == 33) {
            return getString(R.l.dCU);
        }
        if (fVar.field_showHead == 43) {
            return getString(R.l.eFK);
        }
        if (fVar.field_showHead == 32) {
            return getString(R.l.dDg);
        }
        String str = (String) this.yYS.get(fVar.field_showHead);
        if (str != null) {
            return str;
        }
        str = String.valueOf((char) fVar.field_showHead);
        this.yYS.put(fVar.field_showHead, str);
        return str;
    }

    public int getCount() {
        return super.getCount();
    }

    private String getString(int i) {
        String str = (String) this.yYS.get(i);
        if (str != null) {
            return str;
        }
        str = this.context.getString(i);
        this.yYS.put(i, str);
        return str;
    }

    public final com.tencent.mm.bx.a.d<String> cmM() {
        return (com.tencent.mm.bx.a.d) cwu();
    }

    public final ArrayList<com.tencent.mm.storage.f> ah(ArrayList<String> arrayList) {
        long currentTimeMillis = System.currentTimeMillis();
        List arrayList2 = new ArrayList();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= arrayList.size()) {
                break;
            }
            arrayList2.add((String) arrayList.get(i2));
            i = i2 + 1;
        }
        ArrayList<com.tencent.mm.storage.f> arrayList3 = new ArrayList(arrayList2.size());
        as.Hm();
        Cursor cL = com.tencent.mm.y.c.Ff().cL(arrayList2);
        while (cL.moveToNext()) {
            com.tencent.mm.storage.f fVar = new com.tencent.mm.storage.f();
            fVar.b(cL);
            arrayList3.add(fVar);
        }
        cL.close();
        x.d("MicroMsg.AddressAdapter", "rebulidAllChangeData :" + (System.currentTimeMillis() - currentTimeMillis));
        return arrayList3;
    }

    public final SparseArray<String>[] a(HashSet<com.tencent.mm.ui.f.b<String, com.tencent.mm.storage.f>> hashSet, SparseArray<String>[] sparseArrayArr) {
        SparseArray<String>[] sparseArrayArr2 = new SparseArray[sparseArrayArr.length];
        List linkedList = new LinkedList();
        linkedList.add("weixin");
        long currentTimeMillis = System.currentTimeMillis();
        as.Hm();
        Cursor b = com.tencent.mm.y.c.Ff().b(this.yYA, this.yYB, this.koG, linkedList, cwt(), this.yYM);
        int i;
        if (b instanceof com.tencent.mm.bx.a.e) {
            com.tencent.mm.bx.a.d[] dVarArr = ((com.tencent.mm.bx.a.e) b).xKu;
            int length = dVarArr.length;
            for (int i2 = 0; i2 < length; i2++) {
                dVarArr[i2].DW(5000);
                sparseArrayArr2[i2] = new SparseArray();
                i = 0;
                while (dVarArr[i2].moveToNext()) {
                    sparseArrayArr2[i2].put(i, dVarArr[i2].getString(0));
                    i++;
                }
            }
            this.yYJ = dVarArr[0].getCount();
        } else {
            sparseArrayArr2[0] = new SparseArray();
            i = 0;
            while (b.moveToNext()) {
                sparseArrayArr2[0].put(i, b.getString(0));
                i++;
            }
        }
        b.close();
        x.d("MicroMsg.AddressAdapter", "refreshPosistion last :" + (System.currentTimeMillis() - currentTimeMillis));
        return sparseArrayArr2;
    }

    public final void cwx() {
        super.q(null, 1);
    }

    public void a(int i, com.tencent.mm.sdk.e.m mVar, Object obj) {
        if (obj == null || !(obj instanceof String)) {
            x.d("MicroMsg.AddressAdapter", "onNotifyChange obj not String event:%d stg:%s obj:%s", Integer.valueOf(i), mVar, obj);
            return;
        }
        as.Hm();
        if (mVar != com.tencent.mm.y.c.Ff()) {
            return;
        }
        if (s.gG((String) obj) || this.yYU.contains((String) obj)) {
            x.d("MicroMsg.AddressAdapter", "newcursor is stranger ，return");
            return;
        }
        super.q((String) obj, 2);
        if (this.yYN && this.yYH != null) {
            this.yYH.yZs = true;
            x.d("MicroMsg.AddressAdapter", "ADDRESS onNotifyChange");
        }
    }
}
