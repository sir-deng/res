package com.tencent.mm.plugin.sns.ui;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.f.b.ag;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.sns.i;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.model.ai;
import com.tencent.mm.plugin.sns.storage.m;
import com.tencent.mm.plugin.sns.storage.u;
import com.tencent.mm.protocal.c.are;
import com.tencent.mm.protocal.c.ati;
import com.tencent.mm.protocal.c.blf;
import com.tencent.mm.protocal.c.bpb;
import com.tencent.mm.protocal.c.ux;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.ar;
import com.tencent.mm.ui.ac;
import com.tencent.mm.ui.v;
import com.tencent.mm.ui.widget.QFadeImageView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@SuppressLint({"UseSparseArrays"})
public final class at extends BaseAdapter {
    private String country;
    private Activity fBA;
    boolean fva = false;
    List<m> list = new ArrayList();
    String mgB = "";
    private String nWh = "";
    String rCC = "";
    private ar rFL = null;
    private an rKZ;
    Map<Integer, Integer> rLa = new HashMap();
    private f rLb;
    boolean rLc = false;
    au rLd;
    private c rLe;
    int rLf = Integer.MAX_VALUE;
    int rLg = 0;
    private long rLh = 0;
    private long rLi = 0;
    int rLj = 0;
    protected OnClickListener rLk = new OnClickListener() {
        public final void onClick(View view) {
            if (view.getTag() instanceof bpb) {
                bpb bpb = (bpb) view.getTag();
                if (at.MG(bpb.nMq)) {
                    g.pWK.k(10231, "1");
                    com.tencent.mm.au.b.Qv();
                } else {
                    g.pWK.k(10090, "1,0");
                    if (!(com.tencent.mm.o.a.aW(at.this.fBA) || com.tencent.mm.o.a.aU(at.this.fBA))) {
                        ati a = ((com.tencent.mm.au.a.a) com.tencent.mm.kernel.g.h(com.tencent.mm.au.a.a.class)).a(ae.FJ(), bpb, 8);
                        a.wHJ = at.this.userName;
                        com.tencent.mm.au.b.b(a);
                    }
                }
                at.this.notifyDataSetChanged();
            }
        }
    };
    Map<Integer, Integer> rws = new HashMap();
    Map<Integer, Integer> rwt = new HashMap();
    int rwu = 0;
    int rwv = 0;
    private String userName = "";

    class e extends a {
        View rLG;
        TextView rLH;
        MaskLinearLayout rLN;
        MaskImageView rLy;
        TextView roY;

        e() {
            super();
        }

        public final void init() {
            super.init();
            this.rLy.setVisibility(8);
            this.roY.setVisibility(8);
            this.rLH.setVisibility(8);
            this.rLG.setVisibility(8);
            if (ac.ev(at.this.fBA) > 1.0f) {
                this.roY.setMaxLines(2);
            }
        }
    }

    static abstract class f {
        OnClickListener rLO = new OnClickListener() {
            public final void onClick(View view) {
                if (view.getTag() != null) {
                    x.d("MicroMsg.SnsphotoAdapter", "sign click");
                    f.this.rLR = (a) view.getTag();
                    f.this.dK(f.this.rLR.qXb, f.this.rLR.position + 2);
                }
            }
        };
        OnClickListener rLP = new OnClickListener() {
            public final void onClick(View view) {
                if (view.getTag() != null) {
                    x.d("MicroMsg.SnsphotoAdapter", "sign click");
                    f.this.rLR = (a) view.getTag();
                    f.this.yb(f.this.rLR.qXb);
                }
            }
        };
        OnClickListener rLQ = new OnClickListener() {
            public final void onClick(View view) {
                if (view.getTag() != null) {
                    x.d("MicroMsg.SnsphotoAdapter", "snssight click");
                    f.this.rLR = (a) view.getTag();
                    f.this.dK(f.this.rLR.qXb, f.this.rLR.position + 2);
                }
            }
        };
        public a rLR = new a();
        OnClickListener rwA = new OnClickListener() {
            public final void onClick(View view) {
                if (view.getTag() != null) {
                    f.this.rLR = (a) view.getTag();
                    f.this.dJ(f.this.rLR.qXb, f.this.rLR.position);
                }
            }
        };
        OnClickListener rwB = new OnClickListener() {
            public final void onClick(View view) {
                if (view.getTag() != null) {
                    f.this.rLR = (a) view.getTag();
                    f.this.dJ(f.this.rLR.qXb, f.this.rLR.position + 1);
                }
            }
        };
        OnClickListener rwC = new OnClickListener() {
            public final void onClick(View view) {
                if (view.getTag() != null) {
                    f.this.rLR = (a) view.getTag();
                    f.this.dJ(f.this.rLR.qXb, f.this.rLR.position + 2);
                }
            }
        };

        public static class a {
            public int position;
            public int qXb;
        }

        public abstract void dJ(int i, int i2);

        public abstract void dK(int i, int i2);

        public abstract void yb(int i);
    }

    class a {
        View rLn;
        TextView rLo;
        TextView rLp;
        LinearLayout rLq;
        ImageView rLr;
        TextView rLs;
        LinearLayout rLt;
        TextView rLu;
        LinearLayout rwJ;
        View rwK;

        a() {
        }

        public void init() {
            this.rLo.setVisibility(8);
            this.rLp.setVisibility(8);
            this.rLq.setVisibility(4);
            this.rLr.setVisibility(4);
            this.rwK.setVisibility(8);
            this.rLs.setVisibility(8);
            this.rLt.setVisibility(8);
        }
    }

    public interface c {
    }

    class d extends a {
        QFadeImageView rLA;
        QFadeImageView rLB;
        TextView rLC;
        TextView rLD;
        TextView rLE;
        TextView rLF;
        View rLG;
        TextView rLH;
        TextView rLI;
        TextView rLJ;
        TextView rLK;
        TextView rLL;
        TextView rLM;
        MaskLinearLayout rLN;
        MaskImageView rLy;
        QFadeImageView rLz;
        TextView roY;

        d() {
            super();
        }

        public final void init() {
            super.init();
            this.rLy.setVisibility(8);
            this.rLA.setVisibility(8);
            this.rLB.setVisibility(8);
            this.roY.setVisibility(8);
            this.rLC.setVisibility(8);
            this.rLD.setVisibility(8);
            this.rLE.setVisibility(8);
            this.rLF.setVisibility(8);
            this.rLG.setVisibility(8);
            this.rLz.setVisibility(8);
            this.rLH.setVisibility(8);
            this.rLI.setVisibility(8);
            this.rLJ.setVisibility(8);
            this.rLK.setVisibility(8);
            this.rLL.setVisibility(8);
            this.rLM.setVisibility(8);
            if (ac.ev(at.this.fBA) > 1.0f) {
                this.roY.setMaxLines(2);
            }
        }
    }

    class b extends a {
        TextView ikn;
        TextView jbl;
        TagImageView rLv;
        TextView rLw;
        View rLx;
        ImageView rxm;

        b() {
            super();
        }

        public final void init() {
            super.init();
            this.jbl.setVisibility(8);
            this.rLv.setVisibility(8);
            this.rxm.setVisibility(8);
            this.ikn.setVisibility(8);
            this.rLw.setVisibility(8);
        }
    }

    public final void eX(long j) {
        if (0 == this.rLh) {
            this.rLh = j;
            this.rLi = 0;
        }
    }

    public at(Activity activity, f fVar, String str, final c cVar) {
        this.userName = str;
        this.fBA = activity;
        this.rLb = fVar;
        this.rLe = cVar;
        this.rFL = ae.bvT();
        String d = w.d(this.fBA.getSharedPreferences(ad.cgf(), 0));
        x.d("MicroMsg.SnsphotoAdapter", "filterLan temp " + d);
        if (!(d.equals("zh_CN") || d.equals("en") || d.equals("zh_TW"))) {
            d = d.equals("zh_HK") ? "zh_TW" : "en";
        }
        this.nWh = d;
        this.country = w.d(this.fBA.getSharedPreferences(ad.cgf(), 0));
        com.tencent.mm.kernel.g.Dr();
        if (this.userName.equals((String) com.tencent.mm.kernel.g.Dq().Db().get(2, null))) {
            this.fva = true;
        }
        x.d("MicroMsg.SnsphotoAdapter", "SnsphotoAdapter : userName : " + this.userName + " country: " + this.country);
        if (this.fva) {
            this.rKZ = an.cjF();
        } else {
            com.tencent.mm.kernel.g.Dr();
            ag Xv = ((h) com.tencent.mm.kernel.g.h(h.class)).Ff().Xv(str);
            if (Xv == null || !com.tencent.mm.k.a.ga(Xv.field_type)) {
                this.rKZ = an.cjG();
            } else {
                this.rKZ = an.cjE();
            }
        }
        this.rLd = new au(new com.tencent.mm.plugin.sns.ui.au.b() {
            public final void a(List<m> list, Map<Integer, Integer> map, Map<Integer, Integer> map2, Map<Integer, Integer> map3, int i, int i2) {
                x.d("MicroMsg.SnsphotoAdapter", "onFinishFixPos");
                at atVar = at.this;
                x.d("MicroMsg.SnsphotoAdapter", "setSnsList the thread id is " + Thread.currentThread().getId());
                if (list != null && list.size() > 0) {
                    int i3;
                    x.d("MicroMsg.SnsphotoAdapter", "copy list info");
                    int size = list.size();
                    atVar.list.clear();
                    atVar.rws.clear();
                    atVar.rwt.clear();
                    atVar.rLa.clear();
                    for (i3 = 0; i3 < size; i3++) {
                        atVar.list.add(m.x((m) list.get(i3)));
                    }
                    for (Integer intValue : map.keySet()) {
                        size = intValue.intValue();
                        atVar.rws.put(Integer.valueOf(size), Integer.valueOf(((Integer) map.get(Integer.valueOf(size))).intValue()));
                    }
                    for (Integer intValue2 : map2.keySet()) {
                        size = intValue2.intValue();
                        atVar.rwt.put(Integer.valueOf(size), Integer.valueOf(((Integer) map2.get(Integer.valueOf(size))).intValue()));
                    }
                    for (Integer intValue22 : map3.keySet()) {
                        size = intValue22.intValue();
                        atVar.rLa.put(Integer.valueOf(size), Integer.valueOf(((Integer) map3.get(Integer.valueOf(size))).intValue()));
                    }
                    map.clear();
                    map2.clear();
                    if (atVar.fva) {
                        i3 = atVar.list.size() <= 1 ? Integer.MAX_VALUE : ((m) atVar.list.get(1)).field_head;
                    } else {
                        i3 = atVar.list.isEmpty() ? Integer.MAX_VALUE : ((m) atVar.list.get(0)).field_head;
                    }
                    atVar.rLf = 0;
                    size = 0;
                    while (size < atVar.list.size()) {
                        if (!atVar.fva || size != 0) {
                            if (i3 != ((m) atVar.list.get(size)).field_head) {
                                break;
                            }
                            atVar.rLf = Math.max(atVar.rLf, ((m) atVar.list.get(size)).field_createTime);
                        }
                        size++;
                    }
                    if (atVar.list.isEmpty() || (atVar.fva && atVar.list.size() == 1)) {
                        atVar.rLf = Integer.MAX_VALUE;
                    }
                    i3 = atVar.list.isEmpty() ? 0 : ((m) atVar.list.get(atVar.list.size() - 1)).field_head;
                    atVar.rLg = Integer.MAX_VALUE;
                    int size2 = atVar.list.size() - 1;
                    while (size2 >= 0 && i3 != 0 && i3 == ((m) atVar.list.get(size2)).field_head) {
                        atVar.rLg = Math.min(atVar.rLg, ((m) atVar.list.get(size2)).field_createTime);
                        size2--;
                    }
                    if (atVar.list.isEmpty()) {
                        atVar.rLg = 0;
                    }
                    atVar.rwv = i;
                    atVar.rwu = i2;
                    x.d("MicroMsg.SnsphotoAdapter", "reallyCount " + i + " icount " + i2 + " stTime " + atVar.rLf + " edTIme " + atVar.rLg);
                    atVar.notifyDataSetChanged();
                }
            }

            public final void bCc() {
                at.this.notifyDataSetChanged();
            }
        }, str, this.fva);
        eY(0);
        iP(false);
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        int itemViewType = getItemViewType(i);
        x.i("MicroMsg.SnsphotoAdapter", "position " + itemViewType);
        d dVar;
        int i2;
        m mVar;
        int i3;
        bpb byF;
        CharSequence charSequence;
        a aVar;
        a aVar2;
        if (itemViewType == 0) {
            if (view == null || view.getTag() == null || !(view.getTag() instanceof d)) {
                dVar = new d();
                view = v.fw(this.fBA).inflate(i.g.qNK, null);
                dVar.rLp = (TextView) view.findViewById(com.tencent.mm.plugin.sns.i.f.qKs);
                dVar.rLo = (TextView) view.findViewById(com.tencent.mm.plugin.sns.i.f.qKP);
                dVar.rLy = (MaskImageView) view.findViewById(com.tencent.mm.plugin.sns.i.f.qIv);
                dVar.rLz = (QFadeImageView) view.findViewById(com.tencent.mm.plugin.sns.i.f.qLK);
                dVar.rLA = (MaskImageView) view.findViewById(com.tencent.mm.plugin.sns.i.f.qIw);
                dVar.rLB = (MaskImageView) view.findViewById(com.tencent.mm.plugin.sns.i.f.qIx);
                dVar.roY = (TextView) view.findViewById(com.tencent.mm.plugin.sns.i.f.caR);
                dVar.rLC = (TextView) view.findViewById(com.tencent.mm.plugin.sns.i.f.qMo);
                dVar.rLD = (TextView) view.findViewById(com.tencent.mm.plugin.sns.i.f.qMp);
                dVar.rLE = (TextView) view.findViewById(com.tencent.mm.plugin.sns.i.f.qMq);
                dVar.rLF = (TextView) view.findViewById(com.tencent.mm.plugin.sns.i.f.qIz);
                dVar.rLG = view.findViewById(com.tencent.mm.plugin.sns.i.f.qHX);
                dVar.rLs = (TextView) view.findViewById(com.tencent.mm.plugin.sns.i.f.dag);
                dVar.rLq = (LinearLayout) view.findViewById(com.tencent.mm.plugin.sns.i.f.qIL);
                dVar.rLr = (ImageView) view.findViewById(com.tencent.mm.plugin.sns.i.f.qIT);
                dVar.rwJ = (LinearLayout) view.findViewById(com.tencent.mm.plugin.sns.i.f.qIN);
                dVar.rwK = view.findViewById(com.tencent.mm.plugin.sns.i.f.qIK);
                dVar.rLz.setOnClickListener(this.rLb.rwA);
                dVar.rLy.setOnClickListener(this.rLb.rwA);
                dVar.rLA.setOnClickListener(this.rLb.rwB);
                dVar.rLB.setOnClickListener(this.rLb.rwC);
                dVar.rLH = (TextView) view.findViewById(com.tencent.mm.plugin.sns.i.f.qMi);
                dVar.rLI = (TextView) view.findViewById(com.tencent.mm.plugin.sns.i.f.qMj);
                dVar.rLJ = (TextView) view.findViewById(com.tencent.mm.plugin.sns.i.f.qMk);
                dVar.rLK = (TextView) view.findViewById(com.tencent.mm.plugin.sns.i.f.qMa);
                dVar.rLL = (TextView) view.findViewById(com.tencent.mm.plugin.sns.i.f.qMb);
                dVar.rLM = (TextView) view.findViewById(com.tencent.mm.plugin.sns.i.f.qMc);
                dVar.rLN = (MaskLinearLayout) view.findViewById(com.tencent.mm.plugin.sns.i.f.qKM);
                dVar.rLN.b(dVar.rLy);
                dVar.rLt = (LinearLayout) view.findViewById(com.tencent.mm.plugin.sns.i.f.qIi);
                dVar.rLu = (TextView) view.findViewById(com.tencent.mm.plugin.sns.i.f.qLc);
                dVar.rLu.setOnClickListener(new OnClickListener() {
                    public final void onClick(View view) {
                        Intent intent = new Intent();
                        intent.putExtra("enter_scene", com.tencent.mm.ui.e.e.xMQ);
                        com.tencent.mm.bl.d.b(at.this.fBA, "setting", ".ui.setting.SettingsPrivacyUI", intent);
                        g.pWK.h(14098, Integer.valueOf(8));
                    }
                });
                view.setTag(dVar);
            } else {
                dVar = (d) view.getTag();
            }
            ae.bwc().cu(dVar.rLy);
            ae.bwc().cu(dVar.rLA);
            ae.bwc().cu(dVar.rLB);
            i2 = -1;
            if (this.rws.get(Integer.valueOf(i)) != null) {
                i2 = ((Integer) this.rws.get(Integer.valueOf(i))).intValue();
            }
            dVar.init();
            dVar.rLN.frK = false;
            dVar.rLN.setBackgroundResource(0);
            dVar.rLN.setDescendantFocusability(WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT);
            dVar.rLN.setClickable(false);
            dVar.rLy.frK = true;
            dVar.rLy.setClickable(true);
            dVar.rLN.setOnClickListener(null);
            if (i2 >= this.rwv || i2 == -1) {
                view.setLayoutParams(new LayoutParams(-1, 1));
                view.setVisibility(8);
            } else {
                if (i2 - 1 >= 0) {
                    mVar = (m) getItem(i2 - 1);
                    i3 = mVar.field_head;
                    ai.K(mVar.field_localPrivate, this.fva);
                } else {
                    i3 = -1;
                }
                view.setLayoutParams(new LayoutParams(-1, -2));
                view.setVisibility(0);
                int intValue = this.rwt.get(Integer.valueOf(i)) != null ? ((Integer) this.rwt.get(Integer.valueOf(i))).intValue() : 1;
                m mVar2 = (m) getItem(i2);
                byF = mVar2.byF();
                if ((this.fva && i == 0) || i3 == -1 || mVar2.field_head != i3) {
                    a(dVar.rLo, dVar.rLp, (long) mVar2.field_createTime);
                    if (byF.wYh != null) {
                        charSequence = byF.wYh.hxg;
                        if (!(charSequence == null || charSequence.equals(""))) {
                            dVar.rLs.setText(charSequence);
                            dVar.rLs.setVisibility(0);
                        }
                    }
                    dVar.rwK.setVisibility(0);
                }
                if (this.rLi != 0 && mVar2.field_snsId == this.rLi) {
                    dVar.rLt.setVisibility(0);
                } else if (this.rLi != 0 || this.rLh == 0 || mVar2.field_snsId > this.rLh) {
                    dVar.rLt.setVisibility(8);
                } else {
                    dVar.rLt.setVisibility(0);
                    this.rLi = mVar2.field_snsId;
                }
                dVar.rLq.setVisibility(0);
                if (this.fva && i == 0) {
                    dVar.rLz.setVisibility(0);
                    dVar.rLz.setContentDescription(this.fBA.getString(j.qSv));
                    dVar.rLy.setVisibility(8);
                    dVar.roY.setText(this.rwu == 1 ? this.fBA.getString(j.qSM) : "");
                    dVar.roY.setVisibility(0);
                    dVar.rLG.setVisibility(0);
                    dVar.rLF.setVisibility(8);
                    ae.bwc().a(dVar.rLz, com.tencent.mm.plugin.sns.i.c.gWh, com.tencent.mm.plugin.sns.i.e.qFU, this.fBA.hashCode());
                    aVar = new a();
                    aVar.qXb = -1;
                    aVar.position = -1;
                    dVar.rLz.setTag(aVar);
                } else {
                    if (intValue > 0) {
                        a(i2, dVar.rLy, dVar.rLC, dVar.rLF, dVar.rLH, dVar.rLK, 1, dVar, i);
                    }
                    if (intValue >= 2) {
                        a(i2 + 1, dVar.rLA, dVar.rLD, dVar.rLF, dVar.rLI, dVar.rLL, 2, dVar, i);
                    }
                    if (intValue >= 3) {
                        a(i2 + 2, dVar.rLB, dVar.rLE, dVar.rLF, dVar.rLJ, dVar.rLM, 3, dVar, i);
                    }
                    if (intValue == 1) {
                        mVar = (m) getItem(i2);
                        if (!bi.oN(mVar.byF().wYg) && mVar.field_type == 1) {
                            dVar.rLN.setDescendantFocusability(393216);
                            dVar.rLN.setClickable(true);
                            dVar.rLy.setClickable(false);
                            dVar.rLy.frK = false;
                            dVar.rLN.setOnClickListener(this.rLb.rwA);
                            dVar.rLN.frK = true;
                            itemViewType = mVar2.ruM;
                            aVar2 = new a();
                            aVar2.qXb = itemViewType;
                            if (this.rLa.get(Integer.valueOf(i)) != null) {
                                aVar2.position = ((Integer) this.rLa.get(Integer.valueOf(i))).intValue();
                            } else {
                                aVar2.position = 0;
                            }
                            dVar.rLN.setTag(aVar2);
                        }
                    }
                    view.setDrawingCacheEnabled(false);
                }
            }
        } else {
            if (itemViewType == 2) {
                e eVar;
                if (view == null || view.getTag() == null || !(view.getTag() instanceof e)) {
                    e eVar2 = new e();
                    view = v.fw(this.fBA).inflate(i.g.qNU, null);
                    eVar2.rLp = (TextView) view.findViewById(com.tencent.mm.plugin.sns.i.f.qKs);
                    eVar2.rLo = (TextView) view.findViewById(com.tencent.mm.plugin.sns.i.f.qKP);
                    eVar2.rLy = (MaskImageView) view.findViewById(com.tencent.mm.plugin.sns.i.f.qIv);
                    eVar2.rLs = (TextView) view.findViewById(com.tencent.mm.plugin.sns.i.f.dag);
                    eVar2.rLq = (LinearLayout) view.findViewById(com.tencent.mm.plugin.sns.i.f.qIL);
                    eVar2.rLr = (ImageView) view.findViewById(com.tencent.mm.plugin.sns.i.f.qIT);
                    eVar2.rwJ = (LinearLayout) view.findViewById(com.tencent.mm.plugin.sns.i.f.qIN);
                    eVar2.rwK = view.findViewById(com.tencent.mm.plugin.sns.i.f.qIK);
                    eVar2.rLy.setOnClickListener(this.rLb.rLQ);
                    eVar2.rLH = (TextView) view.findViewById(com.tencent.mm.plugin.sns.i.f.qMi);
                    eVar2.rLN = (MaskLinearLayout) view.findViewById(com.tencent.mm.plugin.sns.i.f.qKM);
                    eVar2.rLN.b(eVar2.rLy);
                    eVar2.roY = (TextView) view.findViewById(com.tencent.mm.plugin.sns.i.f.caR);
                    eVar2.rLG = view.findViewById(com.tencent.mm.plugin.sns.i.f.qHX);
                    eVar2.rLt = (LinearLayout) view.findViewById(com.tencent.mm.plugin.sns.i.f.qIi);
                    eVar2.rLu = (TextView) view.findViewById(com.tencent.mm.plugin.sns.i.f.qLc);
                    eVar2.rLu.setOnClickListener(new OnClickListener() {
                        public final void onClick(View view) {
                            Intent intent = new Intent();
                            intent.putExtra("enter_scene", com.tencent.mm.ui.e.e.xMQ);
                            com.tencent.mm.bl.d.b(at.this.fBA, "setting", ".ui.setting.SettingsPrivacyUI", intent);
                            g.pWK.h(14098, Integer.valueOf(8));
                        }
                    });
                    view.setTag(eVar2);
                    eVar = eVar2;
                } else {
                    eVar = (e) view.getTag();
                }
                ae.bwc().cu(eVar.rLy);
                int intValue2 = this.rws.get(Integer.valueOf(i)) != null ? ((Integer) this.rws.get(Integer.valueOf(i))).intValue() : -1;
                eVar.init();
                eVar.rLN.frK = false;
                eVar.rLN.setBackgroundResource(0);
                eVar.rLN.setDescendantFocusability(WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT);
                eVar.rLN.setClickable(false);
                eVar.rLy.frK = true;
                eVar.rLy.setClickable(true);
                eVar.rLN.setOnClickListener(null);
                if (intValue2 >= this.rwv || intValue2 == -1) {
                    view.setLayoutParams(new LayoutParams(-1, 1));
                    view.setVisibility(8);
                } else {
                    if (intValue2 - 1 >= 0) {
                        mVar = (m) getItem(intValue2 - 1);
                        i2 = mVar.field_head;
                        ai.K(mVar.field_localPrivate, this.fva);
                    } else {
                        i2 = -1;
                    }
                    view.setLayoutParams(new LayoutParams(-1, -2));
                    view.setVisibility(0);
                    if (this.rwt.get(Integer.valueOf(i)) != null) {
                        ((Integer) this.rwt.get(Integer.valueOf(i))).intValue();
                    }
                    m mVar3 = (m) getItem(intValue2);
                    bpb byF2 = mVar3.byF();
                    if ((this.fva && i == 0) || r3 == -1 || mVar3.field_head != r3) {
                        a(eVar.rLo, eVar.rLp, (long) mVar3.field_createTime);
                        if (byF2.wYh != null) {
                            charSequence = byF2.wYh.hxg;
                            if (!(charSequence == null || charSequence.equals(""))) {
                                eVar.rLs.setText(charSequence);
                                eVar.rLs.setVisibility(0);
                            }
                        }
                        eVar.rwK.setVisibility(0);
                    }
                    if (this.rLi != 0 && mVar3.field_snsId == this.rLi) {
                        eVar.rLt.setVisibility(0);
                    } else if (this.rLi != 0 || this.rLh == 0 || mVar3.field_snsId > this.rLh) {
                        eVar.rLt.setVisibility(8);
                    } else {
                        eVar.rLt.setVisibility(0);
                        this.rLi = mVar3.field_snsId;
                    }
                    eVar.rLq.setVisibility(0);
                    ai.n(mVar3);
                    an anVar = new an(this.rKZ.tag);
                    anVar.time = mVar3.field_createTime;
                    eVar.rLy.setVisibility(0);
                    ae.bwc().a(byF2.wYj.wfh, eVar.rLy, this.fBA.hashCode(), com.tencent.mm.plugin.sns.model.g.a.qZx, anVar);
                    if (ai.K(mVar3.field_localPrivate, this.fva)) {
                        eVar.rLH.setVisibility(0);
                        eVar.rLH.setBackgroundResource(com.tencent.mm.plugin.sns.i.e.qFB);
                        com.tencent.mm.k.a Xv = this.rFL.Xv(mVar3.field_userName);
                        if (Xv != null) {
                            Xv.AX();
                        }
                    }
                    charSequence = ((m) getItem(intValue2)).byF().wYg;
                    if (!(charSequence == null || charSequence.equals(""))) {
                        eVar.rLG.setVisibility(0);
                        eVar.roY.setVisibility(0);
                        eVar.roY.setText(charSequence);
                        eVar.roY.setText(com.tencent.mm.pluginsdk.ui.d.i.b(this.fBA, charSequence, eVar.roY.getTextSize()));
                    }
                    eVar.rLN.setDescendantFocusability(393216);
                    eVar.rLN.setClickable(true);
                    eVar.rLy.setClickable(false);
                    eVar.rLy.frK = false;
                    eVar.rLN.setOnClickListener(this.rLb.rLQ);
                    eVar.rLN.frK = true;
                    itemViewType = mVar3.ruM;
                    aVar2 = new a();
                    aVar2.qXb = itemViewType;
                    if (this.rLa.get(Integer.valueOf(i)) != null) {
                        aVar2.position = ((Integer) this.rLa.get(Integer.valueOf(i))).intValue();
                    } else {
                        aVar2.position = 0;
                    }
                    eVar.rLN.setTag(aVar2);
                }
            } else if (itemViewType == 3) {
                if (view == null || view.getTag() == null || !(view.getTag() instanceof d)) {
                    dVar = new d();
                    view = v.fw(this.fBA).inflate(i.g.qNK, null);
                    dVar.rLp = (TextView) view.findViewById(com.tencent.mm.plugin.sns.i.f.qKs);
                    dVar.rLo = (TextView) view.findViewById(com.tencent.mm.plugin.sns.i.f.qKP);
                    dVar.rLy = (MaskImageView) view.findViewById(com.tencent.mm.plugin.sns.i.f.qIv);
                    dVar.rLz = (QFadeImageView) view.findViewById(com.tencent.mm.plugin.sns.i.f.qLK);
                    dVar.rLA = (MaskImageView) view.findViewById(com.tencent.mm.plugin.sns.i.f.qIw);
                    dVar.rLB = (MaskImageView) view.findViewById(com.tencent.mm.plugin.sns.i.f.qIx);
                    dVar.roY = (TextView) view.findViewById(com.tencent.mm.plugin.sns.i.f.caR);
                    dVar.rLC = (TextView) view.findViewById(com.tencent.mm.plugin.sns.i.f.qMo);
                    dVar.rLD = (TextView) view.findViewById(com.tencent.mm.plugin.sns.i.f.qMp);
                    dVar.rLE = (TextView) view.findViewById(com.tencent.mm.plugin.sns.i.f.qMq);
                    dVar.rLF = (TextView) view.findViewById(com.tencent.mm.plugin.sns.i.f.qIz);
                    dVar.rLG = view.findViewById(com.tencent.mm.plugin.sns.i.f.qHX);
                    dVar.rLs = (TextView) view.findViewById(com.tencent.mm.plugin.sns.i.f.dag);
                    dVar.rLq = (LinearLayout) view.findViewById(com.tencent.mm.plugin.sns.i.f.qIL);
                    dVar.rLr = (ImageView) view.findViewById(com.tencent.mm.plugin.sns.i.f.qIT);
                    dVar.rwJ = (LinearLayout) view.findViewById(com.tencent.mm.plugin.sns.i.f.qIN);
                    dVar.rwK = view.findViewById(com.tencent.mm.plugin.sns.i.f.qIK);
                    dVar.rLz.setOnClickListener(this.rLb.rLP);
                    dVar.rLy.setOnClickListener(this.rLb.rLP);
                    dVar.rLH = (TextView) view.findViewById(com.tencent.mm.plugin.sns.i.f.qMi);
                    dVar.rLI = (TextView) view.findViewById(com.tencent.mm.plugin.sns.i.f.qMj);
                    dVar.rLJ = (TextView) view.findViewById(com.tencent.mm.plugin.sns.i.f.qMk);
                    dVar.rLK = (TextView) view.findViewById(com.tencent.mm.plugin.sns.i.f.qMa);
                    dVar.rLL = (TextView) view.findViewById(com.tencent.mm.plugin.sns.i.f.qMb);
                    dVar.rLM = (TextView) view.findViewById(com.tencent.mm.plugin.sns.i.f.qMc);
                    dVar.rLN = (MaskLinearLayout) view.findViewById(com.tencent.mm.plugin.sns.i.f.qKM);
                    dVar.rLN.b(dVar.rLy);
                    dVar.rLt = (LinearLayout) view.findViewById(com.tencent.mm.plugin.sns.i.f.qIi);
                    dVar.rLu = (TextView) view.findViewById(com.tencent.mm.plugin.sns.i.f.qLc);
                    dVar.rLu.setOnClickListener(new OnClickListener() {
                        public final void onClick(View view) {
                            Intent intent = new Intent();
                            intent.putExtra("enter_scene", com.tencent.mm.ui.e.e.xMQ);
                            com.tencent.mm.bl.d.b(at.this.fBA, "setting", ".ui.setting.SettingsPrivacyUI", intent);
                            g.pWK.h(14098, Integer.valueOf(8));
                        }
                    });
                    view.setTag(dVar);
                } else {
                    dVar = (d) view.getTag();
                }
                ae.bwc().cu(dVar.rLy);
                ae.bwc().cu(dVar.rLA);
                ae.bwc().cu(dVar.rLB);
                i2 = -1;
                if (this.rws.get(Integer.valueOf(i)) != null) {
                    i2 = ((Integer) this.rws.get(Integer.valueOf(i))).intValue();
                }
                dVar.init();
                dVar.rLN.frK = false;
                dVar.rLN.setBackgroundResource(0);
                dVar.rLN.setDescendantFocusability(WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT);
                dVar.rLN.setClickable(false);
                dVar.rLy.frK = true;
                dVar.rLy.setClickable(true);
                dVar.rLN.setOnClickListener(null);
                if (i2 >= this.rwv || i2 == -1) {
                    view.setLayoutParams(new LayoutParams(-1, 1));
                    view.setVisibility(8);
                } else {
                    if (i2 - 1 >= 0) {
                        mVar = (m) getItem(i2 - 1);
                        i3 = mVar.field_head;
                        ai.K(mVar.field_localPrivate, this.fva);
                    } else {
                        i3 = -1;
                    }
                    view.setLayoutParams(new LayoutParams(-1, -2));
                    view.setVisibility(0);
                    m mVar4 = (m) getItem(i2);
                    byF = mVar4.byF();
                    if ((this.fva && i == 0) || r4 == -1 || mVar4.field_head != r4) {
                        a(dVar.rLo, dVar.rLp, (long) mVar4.field_createTime);
                        if (byF.wYh != null) {
                            charSequence = byF.wYh.hxg;
                            if (!(charSequence == null || charSequence.equals(""))) {
                                dVar.rLs.setText(charSequence);
                                dVar.rLs.setVisibility(0);
                            }
                        }
                        dVar.rwK.setVisibility(0);
                    }
                    if (this.rLi != 0 && mVar4.field_snsId == this.rLi) {
                        dVar.rLt.setVisibility(0);
                    } else if (this.rLi != 0 || this.rLh == 0 || mVar4.field_snsId > this.rLh) {
                        dVar.rLt.setVisibility(8);
                    } else {
                        dVar.rLt.setVisibility(0);
                        this.rLi = mVar4.field_snsId;
                    }
                    dVar.rLq.setVisibility(0);
                    if (this.fva && i == 0) {
                        dVar.rLz.setVisibility(0);
                        dVar.rLz.setContentDescription(this.fBA.getString(j.qSv));
                        dVar.rLy.setVisibility(8);
                        dVar.roY.setText(this.rwu == 1 ? this.fBA.getString(j.qSM) : "");
                        dVar.roY.setVisibility(0);
                        dVar.rLG.setVisibility(0);
                        dVar.rLF.setVisibility(8);
                        ae.bwc().a(dVar.rLz, com.tencent.mm.plugin.sns.i.c.gWh, com.tencent.mm.plugin.sns.i.e.qFU, this.fBA.hashCode());
                        aVar = new a();
                        aVar.qXb = -1;
                        aVar.position = -1;
                        dVar.rLz.setTag(aVar);
                    } else {
                        a(i2, dVar.rLy, dVar.rLC, dVar.rLF, dVar.rLH, dVar.rLK, 1, dVar, i);
                        mVar = (m) getItem(i2);
                        if (!bi.oN(mVar.byF().wYg) && mVar.field_type == 1) {
                            dVar.rLN.setDescendantFocusability(393216);
                            dVar.rLN.setClickable(true);
                            dVar.rLy.setClickable(false);
                            dVar.rLy.frK = false;
                            dVar.rLN.setOnClickListener(this.rLb.rLP);
                            dVar.rLN.frK = true;
                            itemViewType = mVar4.ruM;
                            aVar2 = new a();
                            aVar2.qXb = itemViewType;
                            if (this.rLa.get(Integer.valueOf(i)) != null) {
                                aVar2.position = ((Integer) this.rLa.get(Integer.valueOf(i))).intValue();
                            } else {
                                aVar2.position = 0;
                            }
                            dVar.rLN.setTag(aVar2);
                        }
                        view.setDrawingCacheEnabled(false);
                    }
                }
            } else {
                b bVar;
                if (view == null || view.getTag() == null || !(view.getTag() instanceof b)) {
                    b bVar2 = new b();
                    view = v.fw(this.fBA).inflate(i.g.qNJ, null);
                    bVar2.rLn = view.findViewById(com.tencent.mm.plugin.sns.i.f.bYS);
                    bVar2.rLp = (TextView) view.findViewById(com.tencent.mm.plugin.sns.i.f.qKs);
                    bVar2.rLo = (TextView) view.findViewById(com.tencent.mm.plugin.sns.i.f.qKP);
                    bVar2.rLs = (TextView) view.findViewById(com.tencent.mm.plugin.sns.i.f.dag);
                    bVar2.rwK = view.findViewById(com.tencent.mm.plugin.sns.i.f.qIK);
                    bVar2.rLs = (TextView) view.findViewById(com.tencent.mm.plugin.sns.i.f.dag);
                    bVar2.rLq = (LinearLayout) view.findViewById(com.tencent.mm.plugin.sns.i.f.qIL);
                    bVar2.rLr = (ImageView) view.findViewById(com.tencent.mm.plugin.sns.i.f.qIT);
                    bVar2.rwJ = (LinearLayout) view.findViewById(com.tencent.mm.plugin.sns.i.f.qIN);
                    bVar2.jbl = (TextView) view.findViewById(com.tencent.mm.plugin.sns.i.f.caU);
                    bVar2.rLv = (TagImageView) view.findViewById(com.tencent.mm.plugin.sns.i.f.qIs);
                    bVar2.rxm = (ImageView) view.findViewById(com.tencent.mm.plugin.sns.i.f.state);
                    bVar2.ikn = (TextView) view.findViewById(com.tencent.mm.plugin.sns.i.f.qLQ);
                    bVar2.rLw = (TextView) view.findViewById(com.tencent.mm.plugin.sns.i.f.qJm);
                    bVar2.rLn.setOnClickListener(this.rLb.rLO);
                    bVar2.rLx = view.findViewById(com.tencent.mm.plugin.sns.i.f.qIV);
                    bVar2.rLt = (LinearLayout) view.findViewById(com.tencent.mm.plugin.sns.i.f.qIi);
                    bVar2.rLu = (TextView) view.findViewById(com.tencent.mm.plugin.sns.i.f.qLc);
                    bVar2.rLu.setOnClickListener(new OnClickListener() {
                        public final void onClick(View view) {
                            Intent intent = new Intent();
                            intent.putExtra("enter_scene", com.tencent.mm.ui.e.e.xMQ);
                            com.tencent.mm.bl.d.b(at.this.fBA, "setting", ".ui.setting.SettingsPrivacyUI", intent);
                            g.pWK.h(14098, Integer.valueOf(8));
                        }
                    });
                    view.setTag(bVar2);
                    com.tencent.mm.plugin.sns.data.i.b(bVar2.rLv, this.fBA);
                    bVar = bVar2;
                } else {
                    bVar = (b) view.getTag();
                }
                i2 = this.rws.get(Integer.valueOf(i)) != null ? ((Integer) this.rws.get(Integer.valueOf(i))).intValue() : -1;
                bVar.init();
                if (i2 >= this.rwv || i2 == -1) {
                    view.setLayoutParams(new LayoutParams(-1, 1));
                    view.setVisibility(8);
                } else {
                    view.setVisibility(0);
                    if (i2 - 1 >= 0) {
                        mVar = (m) getItem(i2 - 1);
                        i3 = mVar.field_head;
                        ai.K(mVar.field_localPrivate, this.fva);
                    } else {
                        i3 = -1;
                    }
                    view.setLayoutParams(new LayoutParams(-1, -2));
                    view.setVisibility(0);
                    if (this.rwt.get(Integer.valueOf(i)) != null) {
                        ((Integer) this.rwt.get(Integer.valueOf(i))).intValue();
                    }
                    m mVar5 = (m) getItem(i2);
                    bpb byF3 = mVar5.byF();
                    if ((this.fva && i == 0) || r4 == -1 || mVar5.field_head != r4) {
                        a(bVar.rLo, bVar.rLp, (long) mVar5.field_createTime);
                        if (byF3.wYh != null) {
                            charSequence = byF3.wYh.hxg;
                            if (!(charSequence == null || charSequence.equals(""))) {
                                bVar.rLs.setText(charSequence);
                                bVar.rLs.setVisibility(0);
                            }
                        }
                        bVar.rwK.setVisibility(0);
                    }
                    if (this.rLi != 0 && mVar5.field_snsId == this.rLi) {
                        bVar.rLt.setVisibility(0);
                    } else if (this.rLi != 0 || this.rLh == 0 || mVar5.field_snsId > this.rLh) {
                        bVar.rLt.setVisibility(8);
                    } else {
                        bVar.rLt.setVisibility(0);
                        this.rLi = mVar5.field_snsId;
                    }
                    a aVar3 = new a();
                    aVar3.qXb = mVar5.ruM;
                    if (this.rLa.get(Integer.valueOf(i)) != null) {
                        aVar3.position = ((Integer) this.rLa.get(Integer.valueOf(i))).intValue();
                    } else {
                        aVar3.position = 0;
                    }
                    bVar.rLn.setTag(aVar3);
                    if (bi.oN(byF3.wYg)) {
                        bVar.jbl.setVisibility(8);
                    } else {
                        bVar.jbl.setVisibility(0);
                        bVar.jbl.setText(byF3.wYg);
                        bVar.jbl.setText(com.tencent.mm.pluginsdk.ui.d.i.b(this.fBA, byF3.wYg, bVar.jbl.getTextSize()));
                    }
                    bVar.rLq.setVisibility(0);
                    bVar.jbl.setSingleLine(true);
                    bVar.rLx.setVisibility(0);
                    itemViewType = byF3.wYj.wfg;
                    an anVar2 = new an(this.rKZ.tag);
                    anVar2.time = mVar5.field_createTime;
                    are are;
                    if (itemViewType == 2) {
                        bVar.jbl.setVisibility(0);
                        bVar.jbl.setSingleLine(false);
                        bVar.jbl.setMaxLines(2);
                        bVar.rLx.setVisibility(8);
                    } else if (itemViewType != 4) {
                        CharSequence MH;
                        CharSequence charSequence2;
                        bVar.ikn.setTextColor(this.fBA.getResources().getColor(com.tencent.mm.plugin.sns.i.c.qEy));
                        if (((com.tencent.mm.plugin.sns.model.al.a.bwF() & 1) <= 0 ? 1 : null) != null) {
                            MH = av.MH(byF3.wYj.nlE);
                        } else {
                            Object MH2 = "";
                        }
                        String str = byF3.wYj.fpg;
                        if (str == null || str.length() <= 40) {
                            Object charSequence22 = str;
                        } else {
                            charSequence22 = str.substring(0, 40) + "...";
                        }
                        if (bVar.rLv != null) {
                            bVar.rLv.setOnClickListener(null);
                        }
                        bVar.rxm.setVisibility(8);
                        if (!byF3.wYj.wfh.isEmpty()) {
                            bVar.rLv.setVisibility(0);
                            are = (are) byF3.wYj.wfh.get(0);
                            if (byF3.wYj.wfg == 5) {
                                MH2 = av.MH(are.nlE);
                                charSequence22 = are.fpg;
                                bVar.rxm.setVisibility(0);
                                ae.bwc().a(are, bVar.rLv, i.i.dvL, this.fBA.hashCode(), com.tencent.mm.plugin.sns.model.g.a.qZx, anVar2);
                            } else {
                                ae.bwc().a(are, bVar.rLv, this.fBA.hashCode(), com.tencent.mm.plugin.sns.model.g.a.qZx, anVar2);
                            }
                        } else if (byF3.wYj.wfg != 26) {
                            bVar.rLv.setVisibility(8);
                        } else {
                            bVar.rLv.setVisibility(0);
                            bVar.rLv.setImageResource(i.i.qOS);
                        }
                        if (bi.oN(MH2)) {
                            bVar.rLw.setVisibility(8);
                        } else {
                            bVar.rLw.setVisibility(0);
                            bVar.rLw.setText(MH2);
                        }
                        if (bi.oN(charSequence22)) {
                            bVar.ikn.setVisibility(8);
                        } else {
                            if (bVar.rLw.getVisibility() == 8) {
                                bVar.ikn.setMaxLines(2);
                            } else {
                                bVar.ikn.setMaxLines(1);
                            }
                            bVar.ikn.setVisibility(0);
                            if ((byF3.hcR & 1) > 0) {
                                bVar.ikn.setText(com.tencent.mm.plugin.sns.data.i.a(charSequence22, this.fBA, bVar.ikn));
                            } else {
                                bVar.ikn.setText(charSequence22);
                            }
                        }
                    } else if (byF3.wYj.wfh.isEmpty()) {
                        bVar.rLx.setVisibility(8);
                    } else {
                        bVar.rLv.setVisibility(0);
                        bVar.rxm.setVisibility(0);
                        bVar.rLx.setVisibility(0);
                        bVar.ikn.setMaxLines(1);
                        bVar.ikn.setTextColor(this.fBA.getResources().getColor(com.tencent.mm.plugin.sns.i.c.btS));
                        are = (are) byF3.wYj.wfh.get(0);
                        ae.bwc().a(are, bVar.rLv, i.i.dvy, this.fBA.hashCode(), com.tencent.mm.plugin.sns.model.g.a.qZx, anVar2);
                        bVar.rxm.setPressed(false);
                        if (MG(byF3.nMq)) {
                            bVar.rxm.setImageResource(com.tencent.mm.plugin.sns.i.e.bDS);
                        } else {
                            bVar.rxm.setImageResource(com.tencent.mm.plugin.sns.i.e.bDT);
                        }
                        bVar.rLv.setTag(byF3);
                        bVar.rLv.setOnClickListener(this.rLk);
                        are.qXb = mVar5.ruM;
                        bVar.rLx.setTag(byF3);
                        charSequence = are.nkL;
                        if (bi.oN(charSequence)) {
                            bVar.rLw.setVisibility(4);
                        } else {
                            bVar.rLw.setVisibility(0);
                            bVar.rLw.setText(charSequence);
                        }
                        charSequence = are.fpg;
                        if (bi.oN(charSequence)) {
                            bVar.ikn.setVisibility(8);
                        } else {
                            bVar.ikn.setVisibility(0);
                            bVar.ikn.setTag(aVar3);
                            bVar.ikn.setOnTouchListener(new ab());
                            bVar.ikn.setText(charSequence);
                        }
                    }
                }
            }
            view.setDrawingCacheEnabled(false);
        }
        return view;
    }

    public final int getCount() {
        return this.rwu;
    }

    private void a(TextView textView, TextView textView2, long j) {
        String str = (String) az.a(this.fBA, 1000 * j, !this.nWh.equals("en"));
        String[] split;
        if (str.indexOf(":") > 0) {
            split = str.split(":");
            if (split[1].length() < 2) {
                split[1] = "0" + split[1];
            }
            textView.setText(split[0]);
            textView2.setText(split[1]);
            textView2.setVisibility(0);
            textView.setVisibility(0);
        } else if (str.indexOf("/") > 0) {
            split = str.split("/");
            if (split[1].length() < 2) {
                split[1] = "0" + split[1];
            }
            split[0] = az.t(this.fBA, split[0], this.nWh);
            textView.setText(split[0]);
            textView2.setText(split[1]);
            textView2.setVisibility(0);
            textView.setVisibility(0);
        } else {
            textView2.setVisibility(0);
            textView2.setText(str);
        }
    }

    public final int getItemViewType(int i) {
        if (this.fva && i == 0) {
            x.d("MicroMsg.SnsphotoAdapter", "position isSelf " + i + " - 0");
            return 0;
        }
        int intValue;
        if (this.rws.get(Integer.valueOf(i)) != null) {
            intValue = ((Integer) this.rws.get(Integer.valueOf(i))).intValue();
        } else {
            intValue = -1;
        }
        if (intValue == -1) {
            x.e("MicroMsg.SnsphotoAdapter", "unknow error " + intValue);
            return 0;
        }
        m mVar = (m) getItem(intValue);
        if (mVar.byF().wYj.wfg == 1) {
            x.d("MicroMsg.SnsphotoAdapter", "position " + i + " - 0");
            return 0;
        } else if (mVar.byF().wYj.wfg != 15) {
            return mVar.byF().wYj.wfg == 21 ? 3 : 1;
        } else {
            x.d("MicroMsg.SnsphotoAdapter", "position " + i + " - 2");
            return 2;
        }
    }

    public final int getViewTypeCount() {
        return 4;
    }

    private void a(int i, QFadeImageView qFadeImageView, TextView textView, TextView textView2, TextView textView3, TextView textView4, int i2, d dVar, int i3) {
        CharSequence AX;
        m mVar = (m) getItem(i);
        bpb byF = mVar.byF();
        blf n = ai.n(mVar);
        Object obj = null;
        if (n != null && (((n.wGH & 2) == 2 && n.wVc != null) || ((n.wGH & 4) == 4 && n.wFx != null))) {
            obj = 1;
        }
        if (!(!this.fva || n == null || obj == null || this.userName == null || !this.userName.equals(mVar.field_userName))) {
            textView3.setBackgroundResource(com.tencent.mm.plugin.sns.i.e.qFH);
            textView3.setVisibility(0);
        }
        com.tencent.mm.k.a Xv;
        if (i2 == 1) {
            if (ai.K(mVar.field_localPrivate, this.fva)) {
                textView3.setVisibility(0);
                textView3.setBackgroundResource(com.tencent.mm.plugin.sns.i.e.qFB);
                Xv = this.rFL.Xv(mVar.field_userName);
                AX = Xv == null ? "" : Xv.AX();
                if (!(AX.equals("") || this.userName.equals(mVar.field_userName))) {
                    textView.setVisibility(0);
                    textView.setText(AX);
                }
            }
        } else if (ai.K(mVar.field_localPrivate, this.fva)) {
            textView3.setVisibility(0);
            textView3.setBackgroundResource(com.tencent.mm.plugin.sns.i.e.qFB);
            Xv = this.rFL.Xv(mVar.field_userName);
            AX = Xv == null ? "" : Xv.AX();
            if (!(AX == null || AX.equals("") || this.userName.equals(mVar.field_userName))) {
                textView.setVisibility(0);
                textView.setText(AX);
            }
        }
        int i4 = mVar.ruM;
        a aVar = new a();
        aVar.qXb = i4;
        if (this.rLa.get(Integer.valueOf(i3)) != null) {
            aVar.position = ((Integer) this.rLa.get(Integer.valueOf(i3))).intValue();
        } else {
            aVar.position = 0;
        }
        qFadeImageView.setTag(aVar);
        an anVar = new an(this.rKZ.tag);
        anVar.time = mVar.field_createTime;
        if (byF.wYj.wfg == 1) {
            qFadeImageView.setVisibility(0);
            ae.bwc().a(byF.wYj.wfh, (View) qFadeImageView, this.fBA.hashCode(), com.tencent.mm.plugin.sns.model.g.a.qZx, anVar);
        } else if (byF.wYj.wfg == 2) {
            textView4.setText(bi.aD(byF.wYj.nkL, ""));
            textView4.setVisibility(0);
        } else if (byF.wYj.wfg == 21) {
            mVar.byS();
            boolean z = true;
            if (this.fva) {
                z = true;
            } else if (com.tencent.mm.plugin.sns.lucky.a.m.a(mVar, n)) {
                z = false;
            }
            qFadeImageView.setVisibility(0);
            ae.bwc().a(byF.wYj.wfh, (View) qFadeImageView, this.fBA.hashCode(), com.tencent.mm.plugin.sns.model.g.a.qZx, anVar, z);
        }
        if (mVar.bvO() && mVar.bzc()) {
            textView3.setVisibility(0);
            textView3.setBackgroundResource(com.tencent.mm.plugin.sns.i.e.qFA);
        }
        if (i2 == 1) {
            if (byF.wYj.wfh == null || byF.wYj.wfh.size() <= 1) {
                textView2.setVisibility(8);
            } else {
                dVar.rLG.setVisibility(0);
                textView2.setVisibility(0);
                textView2.setText(this.fBA.getResources().getQuantityString(i.h.qOx, i4, new Object[]{Integer.valueOf(byF.wYj.wfh.size())}));
            }
            AX = byF.wYg;
            if (AX != null && !AX.equals("")) {
                dVar.rLG.setVisibility(0);
                dVar.roY.setVisibility(0);
                dVar.roY.setText(AX);
                dVar.roY.setText(com.tencent.mm.pluginsdk.ui.d.i.b(this.fBA, AX, dVar.roY.getTextSize()));
            }
        }
    }

    private void iP(boolean z) {
        x.d("MicroMsg.SnsphotoAdapter", "limitSeq " + this.mgB);
        if (this.rLd != null) {
            this.rLd.e(this.mgB, this.rLc, z);
        }
    }

    public final void notifyDataSetChanged() {
        super.notifyDataSetChanged();
    }

    public final void bAd() {
        iP(true);
        notifyDataSetChanged();
    }

    public final void bCb() {
        x.d("MicroMsg.SnsphotoAdapter", "i addSize ");
        eY(this.list.isEmpty() ? 0 : ((m) this.list.get(this.list.size() - 1)).field_snsId);
    }

    private void eY(long j) {
        at atVar;
        String es = com.tencent.mm.plugin.sns.data.i.es(ae.bwf().a(j, ae.bvV().KU(this.userName), this.userName, this.fva));
        if (this.rCC.equals("")) {
            atVar = this;
        } else if (es.compareTo(this.rCC) < 0) {
            atVar = this;
        } else {
            es = this.rCC;
            atVar = this;
        }
        atVar.mgB = es;
        ux byR = ae.bwj().LV(this.userName).byR();
        if (byR.wjB != 0) {
            es = com.tencent.mm.plugin.sns.data.i.es(byR.wjB);
            if (this.mgB.equals("")) {
                this.mgB = es;
                return;
            }
            if (es.compareTo(this.mgB) <= 0) {
                es = this.mgB;
            }
            this.mgB = es;
        }
    }

    public final Object getItem(int i) {
        return this.list.get(i);
    }

    public final long getItemId(int i) {
        return 0;
    }

    public final ArrayList<com.tencent.mm.plugin.sns.g.b> dI(int i, int i2) {
        ArrayList<com.tencent.mm.plugin.sns.g.b> arrayList = new ArrayList();
        this.rLj = i2;
        for (int i3 = 0; i3 < this.list.size(); i3++) {
            m mVar = (m) this.list.get(i3);
            int i4 = mVar.ruM;
            if (!(mVar.byF() == null || mVar.byF().wYj == null || mVar.byF().wYj.wfh.size() == 0 || (mVar.byF().wYj.wfg != 1 && mVar.byF().wYj.wfg != 15))) {
                if (i4 == i) {
                    this.rLj = arrayList.size();
                }
                Iterator it = mVar.byF().wYj.wfh.iterator();
                int i5 = 0;
                while (it.hasNext()) {
                    are are = (are) it.next();
                    com.tencent.mm.plugin.sns.g.b bVar = new com.tencent.mm.plugin.sns.g.b();
                    bVar.fIx = are;
                    bVar.rgK = u.ag("sns_table_", (long) i4);
                    bVar.hBH = mVar.field_createTime;
                    int i6 = i5 + 1;
                    bVar.rgL = i5;
                    arrayList.add(bVar);
                    i5 = i6;
                }
            }
        }
        return arrayList;
    }

    protected static boolean MG(String str) {
        ati Qz = com.tencent.mm.au.b.Qz();
        if (Qz != null && com.tencent.mm.au.b.d(Qz) && str.equals(Qz.wdd) && com.tencent.mm.au.b.Qx()) {
            return true;
        }
        return false;
    }
}
