package com.tencent.mm.plugin.card.sharecard.ui;

import android.content.Context;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mars.smc.IDKey;
import com.tencent.mm.R;
import com.tencent.mm.plugin.card.b.l;
import com.tencent.mm.plugin.card.b.m;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.base.c;
import com.tencent.mm.plugin.card.widget.CardTagTextView;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.protocal.c.bom;
import com.tencent.mm.protocal.c.oy;
import com.tencent.mm.sdk.platformtools.bi;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public final class j implements c {
    private BaseAdapter kUZ;
    private long kVa = 0;
    private long kVb = 0;
    private int kVc;
    private int kVd;
    private ArrayList<Integer> kVe = new ArrayList();
    private ArrayList<String> kVf = new ArrayList();
    private ArrayList<String> kVg = new ArrayList();
    protected LinkedList<CardTagTextView> kVh = new LinkedList();
    private Context mContext;

    public class a {
        public LinearLayout kVi;
        public TextView kVj;
        public TextView kVk;
        public RelativeLayout kVl;
        public ImageView kVm;
        public TextView kVn;
        public TextView kVo;
        public TextView kVp;
        public TextView kVq;
        public TextView kVr;
        public View kVs;
        public TextView kVt;
    }

    public j(Context context, BaseAdapter baseAdapter) {
        this.mContext = context;
        this.kUZ = baseAdapter;
        this.kVc = this.mContext.getResources().getDimensionPixelSize(R.f.bvM);
        this.kVd = this.mContext.getResources().getDimensionPixelSize(R.f.bvC);
        this.kVe.clear();
        this.kVf.clear();
        this.kVg.clear();
    }

    public final void release() {
        this.mContext = null;
        this.kUZ = null;
        if (this.kVb > 0) {
            ArrayList arrayList = new ArrayList();
            IDKey iDKey = new IDKey();
            iDKey.SetID(281);
            iDKey.SetKey(5);
            iDKey.SetValue(1);
            IDKey iDKey2 = new IDKey();
            iDKey2.SetID(281);
            iDKey2.SetKey(6);
            iDKey2.SetValue((long) ((int) (this.kVa / this.kVb)));
            arrayList.add(iDKey);
            arrayList.add(iDKey2);
            g.pWK.a(arrayList, true);
        }
        if (this.kVe.size() == this.kVf.size() && this.kVf.size() == this.kVg.size() && this.kVe.size() > 0) {
            long currentTimeMillis = System.currentTimeMillis();
            for (int i = 0; i < this.kVe.size(); i++) {
                g.pWK.h(13220, this.kVg.get(i), this.kVf.get(i), this.kVe.get(i), Long.valueOf(currentTimeMillis));
            }
        }
        this.kVe.clear();
        this.kVf.clear();
        this.kVg.clear();
        if (this.kVh != null) {
            this.kVh.clear();
        }
    }

    public final View a(int i, View view, b bVar) {
        a aVar;
        Object obj;
        StringBuilder stringBuilder;
        CharSequence wS;
        boolean oc;
        int wT;
        LayoutParams layoutParams;
        long currentTimeMillis = System.currentTimeMillis();
        if (view == null) {
            view = View.inflate(this.mContext, R.i.bSa, null);
            a aVar2 = new a();
            aVar2.kVi = (LinearLayout) view.findViewById(R.h.bSi);
            aVar2.kVj = (TextView) view.findViewById(R.h.bRd);
            aVar2.kVk = (TextView) view.findViewById(R.h.bRe);
            aVar2.kVl = (RelativeLayout) view.findViewById(R.h.bQk);
            aVar2.kVm = (ImageView) view.findViewById(R.h.bQZ);
            aVar2.kVn = (TextView) view.findViewById(R.h.bPQ);
            aVar2.kVo = (TextView) view.findViewById(R.h.bRy);
            aVar2.kVs = view.findViewById(R.h.bRf);
            aVar2.kVp = (TextView) view.findViewById(R.h.subtitle);
            aVar2.kVq = (TextView) view.findViewById(R.h.bPG);
            aVar2.kVr = (TextView) view.findViewById(R.h.bRz);
            aVar2.kVt = (TextView) view.findViewById(R.h.bQm);
            aVar2.kVp.setEllipsize(TruncateAt.MIDDLE);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        b bVar2 = (b) this.kUZ.getItem(i);
        int aur = bVar2.aur();
        if (com.tencent.mm.plugin.card.sharecard.a.b.oc(bVar2.aur())) {
            if (i == 0) {
                if (!TextUtils.isEmpty(bVar2.nW(aur))) {
                    obj = 1;
                    if (obj != null) {
                        aVar.kVj.setVisibility(0);
                        aVar.kVj.setText(bVar2.nW(aur));
                        if (TextUtils.isEmpty(bVar2.auq())) {
                            aVar.kVk.setVisibility(8);
                        } else {
                            aVar.kVk.setVisibility(0);
                            aVar.kVk.setText(bVar2.auq());
                        }
                    } else {
                        aVar.kVj.setVisibility(8);
                        aVar.kVk.setVisibility(8);
                        aVar.kVj.setText("");
                    }
                    if (bVar.atU()) {
                        aVar.kVm.setVisibility(0);
                        aVar.kVn.setVisibility(0);
                        aVar.kVi.setVisibility(0);
                        aVar.kVo.setVisibility(0);
                        aVar.kVt.setVisibility(0);
                        aVar.kVs.setVisibility(0);
                        aVar.kVp.setVisibility(0);
                        aVar.kVq.setVisibility(0);
                        aVar.kVr.setVisibility(8);
                        aVar.kVn.setText(bVar.aui().kQL);
                        if (!bVar.atR()) {
                            aVar.kVo.setText(bVar.aui().title);
                        } else if (bVar.aui().vYM == null && bVar.aui().vYM.size() == 1) {
                            aVar.kVo.setText(((oy) bVar.aui().vYM.get(0)).title);
                        } else if (bVar.aui().vYM != null && bVar.aui().vYM.size() == 2) {
                            stringBuilder = new StringBuilder();
                            stringBuilder.append(((oy) bVar.aui().vYM.get(0)).title);
                            stringBuilder.append("-");
                            stringBuilder.append(((oy) bVar.aui().vYM.get(1)).title);
                            aVar.kVo.setText(stringBuilder.toString());
                        }
                        m.a(aVar.kVm, bVar.aui().kPA, this.mContext.getResources().getDimensionPixelSize(R.f.bwu), R.g.bDU, true);
                        aVar.kVn.setTextColor(this.mContext.getResources().getColor(R.e.brJ));
                        wS = com.tencent.mm.plugin.card.sharecard.a.b.wS(bVar.aun());
                        if (TextUtils.isEmpty(wS)) {
                            aVar.kVq.setText("");
                        } else {
                            aVar.kVq.setText(wS);
                        }
                        wS = com.tencent.mm.plugin.card.sharecard.a.b.kr(bVar.aun());
                        oc = com.tencent.mm.plugin.card.sharecard.a.b.oc(bVar.aur());
                        if (TextUtils.isEmpty(wS) && oc) {
                            aVar.kVp.setText(i.c(this.mContext, wS, this.mContext.getResources().getDimensionPixelOffset(R.f.bvV)));
                        } else if (TextUtils.isEmpty(bVar.auo())) {
                            aVar.kVp.setText("");
                        } else {
                            if (TextUtils.isEmpty(l.xx(bVar.auo()))) {
                                aVar.kVp.setText("");
                            } else {
                                aVar.kVp.setText(i.c(this.mContext, this.mContext.getResources().getString(R.l.dPs, new Object[]{wS}), this.mContext.getResources().getDimensionPixelOffset(R.f.bvV)));
                            }
                        }
                        wT = com.tencent.mm.plugin.card.sharecard.a.b.wT(bVar.aun());
                        if (wT > 1 || !oc) {
                            aVar.kVt.setVisibility(8);
                        } else {
                            aVar.kVt.setText("X" + wT);
                            aVar.kVt.setVisibility(0);
                        }
                        if ((bVar.aui().vZf != null || bi.cC(bVar.aui().vZf.xaI)) && !com.tencent.mm.plugin.card.sharecard.a.b.wV(bVar.aun())) {
                            aVar.kVi.setVisibility(8);
                        } else {
                            aVar.kVi.setVisibility(0);
                            wT = 0;
                            while (true) {
                                int i2 = wT;
                                if (i2 >= aVar.kVi.getChildCount()) {
                                    break;
                                }
                                this.kVh.add((CardTagTextView) aVar.kVi.getChildAt(i2));
                                wT = i2 + 1;
                            }
                            aVar.kVi.removeAllViews();
                            if (com.tencent.mm.plugin.card.sharecard.a.b.wV(bVar.aun())) {
                                View avW = avW();
                                avW.setPadding(this.kVd, this.kVc, this.kVd, this.kVc);
                                avW.setTextColor(this.mContext.getResources().getColor(R.e.btC));
                                avW.setText(this.mContext.getString(R.l.dPA));
                                avW.setTextSize(12.0f);
                                ViewGroup.LayoutParams layoutParams2 = new LayoutParams(-2, -2);
                                layoutParams2.rightMargin = this.mContext.getResources().getDimensionPixelOffset(R.f.bvA);
                                aVar.kVi.addView(avW, layoutParams2);
                            }
                            if (!(bVar.aui().vZf == null || bi.cC(bVar.aui().vZf.xaI))) {
                                Iterator it = bVar.aui().vZf.xaI.iterator();
                                while (it.hasNext()) {
                                    bom bom = (bom) it.next();
                                    View avW2 = avW();
                                    avW2.setPadding(this.kVd, this.kVc, this.kVd, this.kVc);
                                    avW2.setTextColor(l.xu(bom.hdx));
                                    avW2.setText(bom.tag);
                                    avW2.setTextSize(12.0f);
                                    aVar.kVi.addView(avW2);
                                }
                            }
                        }
                    } else {
                        aVar.kVm.setVisibility(8);
                        aVar.kVn.setVisibility(8);
                        aVar.kVi.setVisibility(8);
                        aVar.kVo.setVisibility(8);
                        aVar.kVt.setVisibility(8);
                        aVar.kVs.setVisibility(8);
                        aVar.kVp.setVisibility(8);
                        aVar.kVq.setVisibility(8);
                        aVar.kVr.setVisibility(0);
                        aVar.kVr.setText(this.mContext.getResources().getString(R.l.dPc));
                    }
                    if (i != this.kUZ.getCount() - 1 && aVar.kVl != null) {
                        layoutParams = (LayoutParams) aVar.kVl.getLayoutParams();
                        if (layoutParams.bottomMargin != this.mContext.getResources().getDimensionPixelOffset(R.f.bvA)) {
                            layoutParams.bottomMargin = this.mContext.getResources().getDimensionPixelOffset(R.f.bvA);
                            aVar.kVl.setLayoutParams(layoutParams);
                        }
                    } else if (aVar.kVl != null) {
                        layoutParams = (LayoutParams) aVar.kVl.getLayoutParams();
                        if (layoutParams.bottomMargin != 0) {
                            layoutParams.bottomMargin = 0;
                            aVar.kVl.setLayoutParams(layoutParams);
                        }
                    }
                    this.kVa = (System.currentTimeMillis() - currentTimeMillis) + this.kVa;
                    this.kVb++;
                    if (!this.kVf.contains(bVar.aum())) {
                        this.kVf.add(bVar.aum());
                        this.kVg.add(bVar.aun());
                        this.kVe.add(Integer.valueOf(i));
                    }
                    return view;
                }
            } else if (aur != ((b) this.kUZ.getItem(i - 1)).aur()) {
                obj = 1;
                if (obj != null) {
                    aVar.kVj.setVisibility(8);
                    aVar.kVk.setVisibility(8);
                    aVar.kVj.setText("");
                } else {
                    aVar.kVj.setVisibility(0);
                    aVar.kVj.setText(bVar2.nW(aur));
                    if (TextUtils.isEmpty(bVar2.auq())) {
                        aVar.kVk.setVisibility(8);
                    } else {
                        aVar.kVk.setVisibility(0);
                        aVar.kVk.setText(bVar2.auq());
                    }
                }
                if (bVar.atU()) {
                    aVar.kVm.setVisibility(8);
                    aVar.kVn.setVisibility(8);
                    aVar.kVi.setVisibility(8);
                    aVar.kVo.setVisibility(8);
                    aVar.kVt.setVisibility(8);
                    aVar.kVs.setVisibility(8);
                    aVar.kVp.setVisibility(8);
                    aVar.kVq.setVisibility(8);
                    aVar.kVr.setVisibility(0);
                    aVar.kVr.setText(this.mContext.getResources().getString(R.l.dPc));
                } else {
                    aVar.kVm.setVisibility(0);
                    aVar.kVn.setVisibility(0);
                    aVar.kVi.setVisibility(0);
                    aVar.kVo.setVisibility(0);
                    aVar.kVt.setVisibility(0);
                    aVar.kVs.setVisibility(0);
                    aVar.kVp.setVisibility(0);
                    aVar.kVq.setVisibility(0);
                    aVar.kVr.setVisibility(8);
                    aVar.kVn.setText(bVar.aui().kQL);
                    if (!bVar.atR()) {
                        aVar.kVo.setText(bVar.aui().title);
                    } else {
                        if (bVar.aui().vYM == null) {
                        }
                        stringBuilder = new StringBuilder();
                        stringBuilder.append(((oy) bVar.aui().vYM.get(0)).title);
                        stringBuilder.append("-");
                        stringBuilder.append(((oy) bVar.aui().vYM.get(1)).title);
                        aVar.kVo.setText(stringBuilder.toString());
                    }
                    m.a(aVar.kVm, bVar.aui().kPA, this.mContext.getResources().getDimensionPixelSize(R.f.bwu), R.g.bDU, true);
                    aVar.kVn.setTextColor(this.mContext.getResources().getColor(R.e.brJ));
                    wS = com.tencent.mm.plugin.card.sharecard.a.b.wS(bVar.aun());
                    if (TextUtils.isEmpty(wS)) {
                        aVar.kVq.setText("");
                    } else {
                        aVar.kVq.setText(wS);
                    }
                    wS = com.tencent.mm.plugin.card.sharecard.a.b.kr(bVar.aun());
                    oc = com.tencent.mm.plugin.card.sharecard.a.b.oc(bVar.aur());
                    if (TextUtils.isEmpty(wS)) {
                    }
                    if (TextUtils.isEmpty(bVar.auo())) {
                        aVar.kVp.setText("");
                    } else {
                        if (TextUtils.isEmpty(l.xx(bVar.auo()))) {
                            aVar.kVp.setText("");
                        } else {
                            aVar.kVp.setText(i.c(this.mContext, this.mContext.getResources().getString(R.l.dPs, new Object[]{wS}), this.mContext.getResources().getDimensionPixelOffset(R.f.bvV)));
                        }
                    }
                    wT = com.tencent.mm.plugin.card.sharecard.a.b.wT(bVar.aun());
                    if (wT > 1) {
                    }
                    aVar.kVt.setVisibility(8);
                    if (bVar.aui().vZf != null) {
                    }
                    aVar.kVi.setVisibility(8);
                }
                if (i != this.kUZ.getCount() - 1) {
                }
                if (aVar.kVl != null) {
                    layoutParams = (LayoutParams) aVar.kVl.getLayoutParams();
                    if (layoutParams.bottomMargin != 0) {
                        layoutParams.bottomMargin = 0;
                        aVar.kVl.setLayoutParams(layoutParams);
                    }
                }
                this.kVa = (System.currentTimeMillis() - currentTimeMillis) + this.kVa;
                this.kVb++;
                if (this.kVf.contains(bVar.aum())) {
                    this.kVf.add(bVar.aum());
                    this.kVg.add(bVar.aun());
                    this.kVe.add(Integer.valueOf(i));
                }
                return view;
            }
        }
        obj = null;
        if (obj != null) {
            aVar.kVj.setVisibility(0);
            aVar.kVj.setText(bVar2.nW(aur));
            if (TextUtils.isEmpty(bVar2.auq())) {
                aVar.kVk.setVisibility(0);
                aVar.kVk.setText(bVar2.auq());
            } else {
                aVar.kVk.setVisibility(8);
            }
        } else {
            aVar.kVj.setVisibility(8);
            aVar.kVk.setVisibility(8);
            aVar.kVj.setText("");
        }
        if (bVar.atU()) {
            aVar.kVm.setVisibility(0);
            aVar.kVn.setVisibility(0);
            aVar.kVi.setVisibility(0);
            aVar.kVo.setVisibility(0);
            aVar.kVt.setVisibility(0);
            aVar.kVs.setVisibility(0);
            aVar.kVp.setVisibility(0);
            aVar.kVq.setVisibility(0);
            aVar.kVr.setVisibility(8);
            aVar.kVn.setText(bVar.aui().kQL);
            if (!bVar.atR()) {
                if (bVar.aui().vYM == null) {
                }
                stringBuilder = new StringBuilder();
                stringBuilder.append(((oy) bVar.aui().vYM.get(0)).title);
                stringBuilder.append("-");
                stringBuilder.append(((oy) bVar.aui().vYM.get(1)).title);
                aVar.kVo.setText(stringBuilder.toString());
            } else {
                aVar.kVo.setText(bVar.aui().title);
            }
            m.a(aVar.kVm, bVar.aui().kPA, this.mContext.getResources().getDimensionPixelSize(R.f.bwu), R.g.bDU, true);
            aVar.kVn.setTextColor(this.mContext.getResources().getColor(R.e.brJ));
            wS = com.tencent.mm.plugin.card.sharecard.a.b.wS(bVar.aun());
            if (TextUtils.isEmpty(wS)) {
                aVar.kVq.setText(wS);
            } else {
                aVar.kVq.setText("");
            }
            wS = com.tencent.mm.plugin.card.sharecard.a.b.kr(bVar.aun());
            oc = com.tencent.mm.plugin.card.sharecard.a.b.oc(bVar.aur());
            if (TextUtils.isEmpty(wS)) {
            }
            if (TextUtils.isEmpty(bVar.auo())) {
                if (TextUtils.isEmpty(l.xx(bVar.auo()))) {
                    aVar.kVp.setText(i.c(this.mContext, this.mContext.getResources().getString(R.l.dPs, new Object[]{wS}), this.mContext.getResources().getDimensionPixelOffset(R.f.bvV)));
                } else {
                    aVar.kVp.setText("");
                }
            } else {
                aVar.kVp.setText("");
            }
            wT = com.tencent.mm.plugin.card.sharecard.a.b.wT(bVar.aun());
            if (wT > 1) {
            }
            aVar.kVt.setVisibility(8);
            if (bVar.aui().vZf != null) {
            }
            aVar.kVi.setVisibility(8);
        } else {
            aVar.kVm.setVisibility(8);
            aVar.kVn.setVisibility(8);
            aVar.kVi.setVisibility(8);
            aVar.kVo.setVisibility(8);
            aVar.kVt.setVisibility(8);
            aVar.kVs.setVisibility(8);
            aVar.kVp.setVisibility(8);
            aVar.kVq.setVisibility(8);
            aVar.kVr.setVisibility(0);
            aVar.kVr.setText(this.mContext.getResources().getString(R.l.dPc));
        }
        if (i != this.kUZ.getCount() - 1) {
        }
        if (aVar.kVl != null) {
            layoutParams = (LayoutParams) aVar.kVl.getLayoutParams();
            if (layoutParams.bottomMargin != 0) {
                layoutParams.bottomMargin = 0;
                aVar.kVl.setLayoutParams(layoutParams);
            }
        }
        this.kVa = (System.currentTimeMillis() - currentTimeMillis) + this.kVa;
        this.kVb++;
        if (this.kVf.contains(bVar.aum())) {
            this.kVf.add(bVar.aum());
            this.kVg.add(bVar.aun());
            this.kVe.add(Integer.valueOf(i));
        }
        return view;
    }

    public final void u(View view, int i) {
    }

    public final void v(View view, int i) {
    }

    public final void a(View view, int i, OnClickListener onClickListener) {
    }

    private CardTagTextView avW() {
        if (this.kVh.size() == 0) {
            return new CardTagTextView(this.mContext);
        }
        return (CardTagTextView) this.kVh.removeFirst();
    }
}
