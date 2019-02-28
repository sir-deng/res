package com.tencent.mm.plugin.label.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.f.b.ag;
import com.tencent.mm.platformtools.c;
import com.tencent.mm.plugin.label.b.d;
import com.tencent.mm.plugin.label.ui.widget.MMLabelPanel;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.btc;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bf;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.base.MMTagPanelScrollView;
import com.tencent.mm.ui.p.b;
import com.tencent.mm.ui.tools.h;
import com.tencent.mm.y.as;
import com.tencent.mm.y.q;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class ContactLabelUI extends ContactLabelBaseUI implements e {
    private String gBJ;
    private boolean nUM = true;
    private ArrayList<String> nVA = new ArrayList();
    private int nVB = a.nVG;
    private boolean nVC = false;
    private ArrayList<String> nVD;
    private MMTagPanelScrollView nVm;
    private MMLabelPanel nVn;
    private TextView nVo;
    private View nVp;
    private View nVq;
    private TextView nVr;
    private MMLabelPanel nVs;
    private ListView nVt;
    private ScrollView nVu;
    private b nVv;
    private String nVw;
    private ArrayList<String> nVx;
    private HashSet<String> nVy = new HashSet();
    private HashSet<String> nVz = new HashSet();

    private enum a {
        ;

        public static int[] aVP() {
            return (int[]) nVK.clone();
        }

        static {
            nVG = 1;
            nVH = 2;
            nVI = 3;
            nVJ = 4;
            nVK = new int[]{nVG, nVH, nVI, nVJ};
        }
    }

    /* renamed from: com.tencent.mm.plugin.label.ui.ContactLabelUI$4 */
    static /* synthetic */ class AnonymousClass4 {
        static final /* synthetic */ int[] nVF = new int[a.aVP().length];

        static {
            try {
                nVF[a.nVG - 1] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                nVF[a.nVH - 1] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                nVF[a.nVI - 1] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                nVF[a.nVJ - 1] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    static /* synthetic */ void a(ContactLabelUI contactLabelUI) {
        x.i("MicroMsg.Label.ContactLabelUI", "cpan[save]");
        if (contactLabelUI.nVn == null) {
            x.w("MicroMsg.Label.ContactLabelUI", "save fail. input view is null.");
            return;
        }
        contactLabelUI.DY(contactLabelUI.getString(R.l.esR));
        String cqq;
        if (contactLabelUI.nVC) {
            x.i("MicroMsg.Label.ContactLabelUI", "cpan[saveLabelStranger]");
            if (contactLabelUI.nVn != null) {
                cqq = contactLabelUI.nVn.cqq();
                if (!bi.oN(cqq)) {
                    contactLabelUI.nVn.bj(cqq, true);
                    contactLabelUI.nVn.cqr();
                    contactLabelUI.ap(cqq, contactLabelUI.nVC);
                }
            }
            if (contactLabelUI.nVz != null && contactLabelUI.nVz.size() > 0) {
                x.i("MicroMsg.Label.ContactLabelUI", "cpan[saveLabelStranger] save local");
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(contactLabelUI.nVz);
                if (!arrayList.isEmpty()) {
                    int size = arrayList.size();
                    List arrayList2 = new ArrayList();
                    for (int i = 0; i < size; i++) {
                        z zVar = new z();
                        cqq = (String) arrayList.get(i);
                        zVar.field_isTemporary = true;
                        zVar.field_labelName = cqq;
                        zVar.field_labelPYFull = c.oD(cqq);
                        zVar.field_labelPYShort = c.oE(cqq);
                        zVar.field_labelID = -((int) System.nanoTime());
                        x.i("MicroMsg.Label.ContactLabelUI", "cpan[saveLabelStranger]field_labelID:%s field_labelName:%s", Integer.valueOf(zVar.field_labelID), zVar.field_labelName);
                        arrayList2.add(zVar);
                    }
                    com.tencent.mm.plugin.label.e.aVC().cH(arrayList2);
                }
            }
            x.i("MicroMsg.Label.ContactLabelUI", "cpan[saveStranger]");
            as.Hm();
            com.tencent.mm.sdk.e.c FF = com.tencent.mm.y.c.Fg().FF(contactLabelUI.gBJ);
            if (contactLabelUI.nVn != null) {
                String aY = com.tencent.mm.plugin.label.a.a.aVD().aY(contactLabelUI.nVn.cqv());
                if (bi.oN(aY)) {
                    FF.field_contactLabels = "";
                    as.Hm();
                    com.tencent.mm.y.c.Fg().a(FF);
                } else {
                    FF.field_contactLabels = aY;
                    if (bi.oN(FF.field_encryptUsername)) {
                        FF.field_encryptUsername = contactLabelUI.gBJ;
                    }
                    as.Hm();
                    com.tencent.mm.y.c.Fg().a(FF);
                }
            }
            contactLabelUI.aVN();
            return;
        }
        x.i("MicroMsg.Label.ContactLabelUI", "cpan[saveLabel]");
        if (contactLabelUI.nVn != null) {
            cqq = contactLabelUI.nVn.cqq();
            if (!bi.oN(cqq)) {
                cqq = cqq.trim();
                contactLabelUI.nVn.bj(cqq, true);
                contactLabelUI.nVn.cqr();
                contactLabelUI.ap(cqq, contactLabelUI.nVC);
            }
        }
        if (contactLabelUI.nVz == null || contactLabelUI.nVz.size() <= 0) {
            x.i("MicroMsg.Label.ContactLabelUI", "cpan[saveLable] doSaveContact");
            contactLabelUI.aVM();
            return;
        }
        x.i("MicroMsg.Label.ContactLabelUI", "cpan[saveLable] doScene");
        List arrayList3 = new ArrayList();
        arrayList3.addAll(contactLabelUI.nVz);
        as.CN().a(new com.tencent.mm.plugin.label.b.a(arrayList3), 0);
        if (contactLabelUI.nVA == null || contactLabelUI.nVz.isEmpty()) {
            g.pWK.h(11347, Integer.valueOf(0), Integer.valueOf(0));
            return;
        }
        g.pWK.h(11347, Integer.valueOf(0), Integer.valueOf(1));
    }

    static /* synthetic */ void a(ContactLabelUI contactLabelUI, String str) {
        if (contactLabelUI.nVx != null && contactLabelUI.nVx.contains(str)) {
            contactLabelUI.nVy.add(str);
        }
        if (contactLabelUI.nVz != null && contactLabelUI.nVz.contains(str)) {
            contactLabelUI.nVz.remove(str);
        }
        if (contactLabelUI.aVO()) {
            contactLabelUI.enableOptionMenu(true);
        }
    }

    static /* synthetic */ void a(ContactLabelUI contactLabelUI, ArrayList arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            ah.h(new Runnable() {
                public final void run() {
                    ContactLabelUI.this.nVn.cqt();
                    ContactLabelUI.this.showVKB();
                }
            }, 50);
        } else {
            ah.h(new Runnable() {
                public final void run() {
                    ContactLabelUI.this.nVn.cqu();
                    ContactLabelUI.this.aWY();
                }
            }, 50);
        }
    }

    static /* synthetic */ void b(ContactLabelUI contactLabelUI, String str) {
        if (bi.oN(str)) {
            contactLabelUI.sd(a.nVG);
            return;
        }
        contactLabelUI.sd(a.nVH);
        if (contactLabelUI.nVn != null) {
            b bVar = contactLabelUI.nVv;
            List cqv = contactLabelUI.nVn.cqv();
            if (bVar.nVk != null) {
                bVar.nVk.clear();
            }
            if (bVar.nVl != null) {
                bVar.nVl.clear();
            }
            bVar.nVj = bi.aD(str, "");
            bVar.nVk = com.tencent.mm.plugin.label.e.aVC().o(str, cqv);
            bVar.notifyDataSetChanged();
        }
    }

    protected final int getLayoutId() {
        return R.i.deZ;
    }

    protected final void initView() {
        setMMTitle(getString(R.l.dCF));
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                ContactLabelUI.this.onBackPressed();
                return false;
            }
        });
        a(0, getString(R.l.dGI), new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                ContactLabelUI.a(ContactLabelUI.this);
                return false;
            }
        }, b.xSe);
        this.nVm = (MMTagPanelScrollView) findViewById(R.h.csv);
        this.nVm.ymK = 3;
        this.nVn = (MMLabelPanel) findViewById(R.h.csu);
        this.nVo = (TextView) findViewById(R.h.csx);
        this.nVp = findViewById(R.h.cst);
        this.nVq = findViewById(R.h.css);
        this.nVq.setBackgroundDrawable(null);
        this.nVr = (TextView) this.nVq.findViewById(16908310);
        this.nVr.setText(R.l.csr);
        this.nVs = (MMLabelPanel) findViewById(R.h.csr);
        this.nVt = (ListView) findViewById(R.h.csw);
        this.nVu = (ScrollView) findViewById(R.h.csy);
        if (this.nVu != null) {
            this.nVu.setOnTouchListener(new OnTouchListener() {
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    if (motionEvent.getAction() == 2) {
                        ContactLabelUI.this.aWY();
                    }
                    return false;
                }
            });
        }
        this.nVn.ymj = true;
        this.nVn.mz(true);
        this.nVn.Fi(R.g.bGC);
        this.nVn.ymq = new com.tencent.mm.ui.base.MMTagPanel.a() {
            public final void zo(String str) {
                x.d("MicroMsg.Label.ContactLabelUI", "cpan[Input onTagUnSelected] tag:%s", str);
                ContactLabelUI.this.nVn.removeTag(str);
                if (ContactLabelUI.this.nVs != null) {
                    ContactLabelUI.this.nVs.bk(str, false);
                }
                ContactLabelUI.a(ContactLabelUI.this, str);
            }

            public final void zp(String str) {
                x.d("MicroMsg.Label.ContactLabelUI", "cpan[Input onTagSelected] tag:%s", str);
            }

            public final void zq(String str) {
                x.d("MicroMsg.Label.ContactLabelUI", "cpan[Input onTagRemove] tag:%s", str);
                if (ContactLabelUI.this.nVs != null) {
                    ContactLabelUI.this.nVs.bk(str, false);
                }
                ContactLabelUI.a(ContactLabelUI.this, str);
            }

            public final void aEg() {
                x.d("MicroMsg.Label.ContactLabelUI", "cpan[Input onTagEditTextClick]");
            }

            public final void zr(String str) {
                x.d("MicroMsg.Label.ContactLabelUI", "cpan[Input onTagEditTextChange] curText:%s", str);
                ContactLabelUI.b(ContactLabelUI.this, str);
            }

            public final void zs(String str) {
                x.d("MicroMsg.Label.ContactLabelUI", "cpan[Input onTagCreate] tag:%s", str);
                if (bi.oN(str)) {
                    x.d("MicroMsg.Label.ContactLabelUI", "tag is null.");
                    return;
                }
                ContactLabelUI.this.nVn.bj(str, true);
                if (ContactLabelUI.this.nVs != null) {
                    ContactLabelUI.this.nVs.bk(str, true);
                }
                ContactLabelUI.this.ap(str, ContactLabelUI.this.nVC);
            }

            public final void j(boolean z, int i) {
                x.d("MicroMsg.Label.ContactLabelUI", "cpan[Input onTagLengthMax] match:%s exceedCount:%d", String.valueOf(z), Integer.valueOf(i));
                if (z) {
                    ContactLabelUI.this.enableOptionMenu(false);
                    ContactLabelUI.this.nVo.setVisibility(0);
                    ContactLabelUI.this.nVo.setText(R.l.esP);
                    ContactLabelUI.this.nVo.setText(String.format(ContactLabelUI.this.getString(R.l.esP), new Object[]{Integer.valueOf(h.be(36, "")), Integer.valueOf(i)}));
                    return;
                }
                ContactLabelUI.this.enableOptionMenu(true);
                ContactLabelUI.this.nVo.setVisibility(8);
            }
        };
        this.nVs.mz(false);
        this.nVs.ymq = new com.tencent.mm.ui.base.MMTagPanel.a() {
            public final void zo(String str) {
                x.d("MicroMsg.Label.ContactLabelUI", "cpan[All onTagUnSelected] tag:%s", str);
                if (ContactLabelUI.this.nVn != null) {
                    ContactLabelUI.this.nVn.removeTag(str);
                }
                ContactLabelUI.a(ContactLabelUI.this, str);
            }

            public final void zp(String str) {
                x.d("MicroMsg.Label.ContactLabelUI", "cpan[All onTagSelected] tag:%s", str);
                if (ContactLabelUI.this.nVn != null) {
                    ContactLabelUI.this.nVn.bj(str, true);
                }
                ContactLabelUI.this.ap(str, ContactLabelUI.this.nVC);
            }

            public final void zq(String str) {
            }

            public final void j(boolean z, int i) {
            }

            public final void aEg() {
            }

            public final void zr(String str) {
            }

            public final void zs(String str) {
            }
        };
        this.nVt.setAdapter(this.nVv);
        this.nVt.setOnItemClickListener(new OnItemClickListener() {
            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (ContactLabelUI.this.nVv != null) {
                    String kF = ContactLabelUI.this.nVv.kF(i);
                    if (!bi.oN(kF) && ContactLabelUI.this.nVn != null) {
                        ContactLabelUI.this.nVn.cqr();
                        ContactLabelUI.this.nVn.bj(kF, true);
                        ContactLabelUI.this.nVs.bk(kF, true);
                    }
                }
            }
        });
        enableOptionMenu(false);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.nVw = getIntent().getStringExtra("label_id_list");
        this.nVx = getIntent().getStringArrayListExtra("label_str_list");
        this.gBJ = getIntent().getStringExtra("label_username");
        this.nVC = getIntent().getBooleanExtra("is_stranger", false);
        this.nVv = new b(this);
        initView();
        if (!(bi.oN(this.nVw) || this.nVx == null || this.nVx.size() <= 0)) {
            this.nVn.a(this.nVx, this.nVx);
        }
        if (this.nVC) {
            this.nVD = getIntent().getStringArrayListExtra("label_str_list");
            this.nVn.a(this.nVD, this.nVD);
        }
    }

    protected void onResume() {
        as.CN().a(635, (e) this);
        as.CN().a(638, (e) this);
        ah.y(new Runnable() {
            public final void run() {
                Collection collection = null;
                ContactLabelUI.this.nVy.clear();
                ContactLabelUI.this.nVz.clear();
                if (ContactLabelUI.this.nVn != null) {
                    ag Xv;
                    String str;
                    if (ContactLabelUI.this.nVC) {
                        String str2;
                        as.Hm();
                        bf FF = com.tencent.mm.y.c.Fg().FF(ContactLabelUI.this.gBJ);
                        if (FF != null) {
                            str2 = FF.field_contactLabels;
                        }
                        if (bi.oN(str2)) {
                            as.Hm();
                            Xv = com.tencent.mm.y.c.Ff().Xv(ContactLabelUI.this.gBJ);
                            String str3 = Xv.field_encryptUsername;
                            if (!bi.oN(str3)) {
                                as.Hm();
                                bf FF2 = com.tencent.mm.y.c.Fg().FF(str3);
                                if (FF2 != null) {
                                    str2 = FF2.field_contactLabels;
                                }
                            }
                            if (bi.oN(str2)) {
                                str = Xv.field_username;
                                as.Hm();
                                FF = com.tencent.mm.y.c.Fg().FF(str);
                                if (FF != null) {
                                    str2 = FF.field_contactLabels;
                                }
                            }
                        }
                        collection = (ArrayList) com.tencent.mm.plugin.label.a.a.aVD().DV(str2);
                    } else {
                        as.Hm();
                        Xv = com.tencent.mm.y.c.Ff().Xv(ContactLabelUI.this.gBJ);
                        if (Xv != null) {
                            str = Xv.field_contactLabelIds;
                            if (!bi.oN(str)) {
                                ArrayList arrayList = (ArrayList) com.tencent.mm.plugin.label.a.a.aVD().DW(str);
                            }
                        }
                    }
                    ContactLabelUI.this.nVn.a(collection, (List) collection);
                    ContactLabelUI.a(ContactLabelUI.this, (ArrayList) collection);
                }
                if (ContactLabelUI.this.nVs != null) {
                    ContactLabelUI.this.nVA = com.tencent.mm.plugin.label.e.aVC().ciU();
                    if (ContactLabelUI.this.nVA != null && ContactLabelUI.this.nVA.size() > 0) {
                        ContactLabelUI.this.nVC;
                        ContactLabelUI.this.nVs.a(collection, ContactLabelUI.this.nVA);
                        if (ContactLabelUI.this.nUM) {
                            g.pWK.h(11346, Integer.valueOf(0), Integer.valueOf(1));
                            ContactLabelUI.this.nUM = false;
                        }
                    } else if (ContactLabelUI.this.nUM) {
                        g.pWK.h(11346, Integer.valueOf(0), Integer.valueOf(0));
                        ContactLabelUI.this.nUM = false;
                    }
                }
                ContactLabelUI.this.sd(a.nVG);
            }
        });
        super.onResume();
    }

    protected void onPause() {
        as.CN().b(635, (e) this);
        as.CN().b(638, (e) this);
        super.onPause();
    }

    protected void onDestroy() {
        super.onDestroy();
    }

    public final void a(int i, int i2, String str, k kVar) {
        x.i("MicroMsg.Label.ContactLabelUI", "cpan[onSceneEnd]errType:%d errCode:%d errMsg:%s", Integer.valueOf(i), Integer.valueOf(i2), str);
        switch (kVar.getType()) {
            case 635:
                if (i == 0 && i2 == 0) {
                    aVM();
                    return;
                } else {
                    aVI();
                    return;
                }
            case 638:
                if (i == 0 && i2 == 0) {
                    x.i("MicroMsg.Label.ContactLabelUI", "cpan[onSceneEnd] success.");
                    aVN();
                    return;
                }
                aVI();
                return;
            default:
                x.w("MicroMsg.Label.ContactLabelUI", "unknow type.");
                return;
        }
    }

    public void onBackPressed() {
        if (aVO()) {
            com.tencent.mm.ui.base.h.a((Context) this, getString(R.l.eHs), "", getString(R.l.dNs), getString(R.l.dNt), new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    ContactLabelUI.a(ContactLabelUI.this);
                }
            }, new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    ContactLabelUI.this.finish();
                }
            });
        } else {
            super.onBackPressed();
        }
    }

    private void sd(int i) {
        this.nVB = i;
        switch (AnonymousClass4.nVF[this.nVB - 1]) {
            case 1:
                this.nVt.setVisibility(8);
                if (this.nVA == null || this.nVA.size() <= 0) {
                    this.nVu.setVisibility(8);
                    this.nVp.setVisibility(8);
                } else {
                    this.nVp.setVisibility(0);
                    this.nVu.setVisibility(0);
                }
                this.nVo.setVisibility(8);
                return;
            case 2:
                this.nVu.setVisibility(8);
                this.nVt.setVisibility(0);
                this.nVp.setVisibility(8);
                this.nVo.setVisibility(8);
                return;
            case 3:
                this.nVt.setVisibility(8);
                this.nVu.setVisibility(8);
                this.nVp.setVisibility(8);
                this.nVo.setVisibility(0);
                this.nVo.setText(R.l.esP);
                return;
            case 4:
                this.nVt.setVisibility(8);
                this.nVu.setVisibility(8);
                this.nVp.setVisibility(8);
                this.nVo.setVisibility(0);
                this.nVo.setText(R.l.esP);
                return;
            default:
                return;
        }
    }

    private void ap(String str, boolean z) {
        if (bi.oN(str)) {
            x.w("MicroMsg.Label.ContactLabelUI", "tag is empty");
            return;
        }
        String trim = str.trim();
        if (bi.oN(trim)) {
            x.w("MicroMsg.Label.ContactLabelUI", "new tag is empty");
            return;
        }
        z Xm = com.tencent.mm.plugin.label.e.aVC().Xm(trim);
        if (z) {
            if (this.nVA == null || !this.nVA.contains(trim) || Xm == null) {
                this.nVz.add(trim);
            }
        } else if (this.nVA == null || !this.nVA.contains(trim) || (Xm != null && Xm.field_isTemporary)) {
            this.nVz.add(trim);
        }
        if (this.nVy != null && this.nVy.contains(trim)) {
            this.nVy.remove(trim);
        }
        if (aVO()) {
            enableOptionMenu(true);
        }
    }

    private void aVM() {
        x.i("MicroMsg.Label.ContactLabelUI", "cpan[saveContact]");
        if (this.nVn != null) {
            int size;
            int size2;
            int size3;
            x.i("MicroMsg.Label.ContactLabelUI", "cpan[saveContact] doScene");
            String str = "";
            ArrayList cqv = this.nVn.cqv();
            if (cqv.size() > 0) {
                str = com.tencent.mm.plugin.label.c.ba(com.tencent.mm.plugin.label.e.aVC().ae(cqv));
            }
            LinkedList linkedList = new LinkedList();
            btc btc = new btc();
            btc.wfP = str;
            btc.kyG = this.gBJ;
            linkedList.add(btc);
            as.CN().a(new d(linkedList), 0);
            if (this.nVz != null) {
                size = this.nVz.size();
            } else {
                size = 0;
            }
            if (this.nVx != null) {
                size2 = this.nVx.size();
            } else {
                size2 = 0;
            }
            if (this.nVy != null) {
                size3 = this.nVy.size();
            } else {
                size3 = 0;
            }
            size2 = ((size3 + this.nVn.cqv().size()) - size2) - size;
            if (size > 0 || size2 > 0) {
                x.d("MicroMsg.Label.ContactLabelUI", "cpan[saveContact]addLabelNum:%d,updateLabelNum:%d", Integer.valueOf(size), Integer.valueOf(size2));
                g.pWK.h(11220, q.FY(), Integer.valueOf(size), Integer.valueOf(size2), Integer.valueOf(0));
            }
        }
    }

    private void aVN() {
        aVF();
        this.nVz.clear();
        this.nVy.clear();
        finish();
    }

    private void aVI() {
        aVF();
        zk(getString(R.l.dCC));
    }

    private boolean aVO() {
        if (this.nVn != null) {
            if (this.nVx == null || this.nVx.size() <= 0) {
                this.nVn.cqv();
                if (this.nVn.cqv().size() > 0) {
                    return true;
                }
            }
            this.nVn.cqv();
            List cqv = this.nVn.cqv();
            Collections.sort(this.nVx);
            Collections.sort(cqv);
            if (this.nVx.equals(cqv)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public void finish() {
        if (this.nVn != null) {
            this.nVn.cqu();
        }
        Intent intent = new Intent();
        if (aVO()) {
            intent.putExtra("hasLableChange", true);
        } else {
            intent.putExtra("hasLableChange", false);
        }
        setResult(-1, intent);
        super.finish();
    }
}
