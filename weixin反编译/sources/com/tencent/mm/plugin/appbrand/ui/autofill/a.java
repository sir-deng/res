package com.tencent.mm.plugin.appbrand.ui.autofill;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.t;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.modelappbrand.a.f;
import com.tencent.mm.plugin.appbrand.q.d;
import com.tencent.mm.plugin.appbrand.q.g;
import com.tencent.mm.plugin.appbrand.q.h;
import com.tencent.mm.plugin.appbrand.q.j;
import com.tencent.mm.protocal.c.bju;
import com.tencent.mm.protocal.c.ee;
import com.tencent.mm.protocal.c.ef;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.b;
import com.tencent.mm.ui.u;
import com.tencent.mm.ui.v;
import java.util.List;

public final class a extends u {
    private ImageView jTd;
    com.tencent.mm.plugin.appbrand.ui.autofill.AppBrandIDCardUI.a jTe;
    private LinearLayout jTf;
    private View jTg;
    private RecyclerView jTh;
    private TextView jTi;
    private Button jTj;
    private TextView jTk;
    private TextView jTl;
    private LinearLayout jTm;
    private View jTn;
    private TextView jTo;
    private TextView jTp;
    private TextView jbl;
    private b mActionBarHelper;

    public static class a extends android.support.v7.widget.RecyclerView.a<a> {
        private List<ee> jTs;

        public static class a extends t {
            public TextView ipR;
            public TextView jTt;

            public a(View view) {
                super(view);
                this.ipR = (TextView) view.findViewById(g.iwu);
                this.jTt = (TextView) view.findViewById(g.iwv);
            }
        }

        public final /* synthetic */ t a(ViewGroup viewGroup, int i) {
            return new a(LayoutInflater.from(viewGroup.getContext()).inflate(h.izp, viewGroup, false));
        }

        public final /* synthetic */ void a(t tVar, int i) {
            a aVar = (a) tVar;
            ee eeVar = (ee) this.jTs.get(i);
            if (eeVar != null) {
                aVar.ipR.setText(eeVar.aAM);
                aVar.jTt.setText(eeVar.hjk);
            }
        }

        public a(List<ee> list) {
            this.jTs = list;
        }

        public final int getItemCount() {
            return this.jTs == null ? 0 : this.jTs.size();
        }
    }

    protected final void dealContentView(View view) {
        if (this.jTe == null || this.jTe.alH() == null) {
            x.e("MicroMsg.AppBrandIDCardShowFrag", "idCardUILogic or idCardUILogic.getIDCardShowInfo() is null, err");
            return;
        }
        this.jTf = (LinearLayout) view.findViewById(g.iww);
        this.jTd = (ImageView) view.findViewById(g.iwt);
        this.jbl = (TextView) view.findViewById(g.iws);
        this.jTh = (RecyclerView) view.findViewById(g.iwx);
        this.jTi = (TextView) view.findViewById(g.iwq);
        this.jTj = (Button) view.findViewById(g.iwr);
        this.jTk = (TextView) view.findViewById(g.iwy);
        this.jTl = (TextView) view.findViewById(g.ixn);
        this.jTm = (LinearLayout) view.findViewById(g.iwp);
        this.jTn = view.findViewById(g.iwB);
        this.jTo = (TextView) view.findViewById(g.iwz);
        this.jTp = (TextView) view.findViewById(g.iwA);
        this.jTg = v.fw(getContext()).inflate(h.dac, null);
        this.jTg.setBackgroundColor(getResources().getColor(d.bre));
        this.mActionBarHelper = new b(this.jTg);
        this.jTf.addView(this.jTg, 0, new LayoutParams(-1, com.tencent.mm.plugin.appbrand.widget.a.cj(getActivity())));
        final bju alH = this.jTe.alH();
        this.mActionBarHelper.setTitle(alH.title);
        this.mActionBarHelper.o(new OnClickListener() {
            public final void onClick(View view) {
                if (a.this.jTe != null) {
                    a.this.jTe.back();
                }
            }
        });
        com.tencent.mm.modelappbrand.a.b.Jp().a(this.jTd, alH.wIV, com.tencent.mm.modelappbrand.a.a.Jo(), f.hmb);
        this.jbl.setText(alH.hea + " " + alH.wTH);
        if (alH.wTI != null) {
            this.jTh.setVisibility(0);
            RecyclerView recyclerView = this.jTh;
            getContext();
            recyclerView.a(new LinearLayoutManager());
            this.jTh.a(new a(alH.wTI));
        } else {
            x.e("MicroMsg.AppBrandIDCardShowFrag", "idCardShowInfo.user_id_list is null");
            this.jTh.setVisibility(8);
        }
        this.jTi.setText(alH.wTJ);
        if (bi.oN(alH.wTK)) {
            this.jTj.setText(alH.wTK);
            this.jTk.setText(getString(j.iBW, alH.wTK));
        } else {
            this.jTj.setText(getString(j.iBV));
            this.jTk.setText(getString(j.iBW, getString(j.iBV)));
        }
        this.jTj.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                x.i("MicroMsg.AppBrandIDCardShowFrag", "verifyPayPassword click");
                if (a.this.jTe != null) {
                    a.this.jTe.alF();
                }
            }
        });
        if (alH.wTL != null) {
            this.jTl.setText(alH.wTL.name);
            this.jTl.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    if (a.this.jTe != null) {
                        a.this.jTe.uX(alH.wTL.url);
                    }
                }
            });
        }
        if (alH.wTM != null) {
            x.d("MicroMsg.AppBrandIDCardShowFrag", "idCardShowInfo.jump_list size:%d", Integer.valueOf(alH.wTM.size()));
            if (alH.wTM.size() == 0) {
                this.jTm.setVisibility(8);
            } else if (alH.wTM.size() == 1) {
                this.jTm.setVisibility(0);
                this.jTn.setVisibility(8);
                this.jTp.setVisibility(8);
                if (alH.wTM.get(0) != null) {
                    this.jTo.setText(((ef) alH.wTM.get(0)).name);
                    this.jTo.setOnClickListener(new OnClickListener() {
                        public final void onClick(View view) {
                            if (a.this.jTe != null) {
                                a.this.jTe.uY(((ef) alH.wTM.get(0)).url);
                            }
                        }
                    });
                }
            } else {
                this.jTm.setVisibility(0);
                this.jTn.setVisibility(0);
                this.jTp.setVisibility(0);
                if (alH.wTM.get(0) != null) {
                    this.jTo.setText(((ef) alH.wTM.get(0)).name);
                    this.jTo.setOnClickListener(new OnClickListener() {
                        public final void onClick(View view) {
                            x.i("MicroMsg.AppBrandIDCardShowFrag", "urlJump click");
                            if (a.this.jTe != null) {
                                a.this.jTe.uY(((ef) alH.wTM.get(0)).url);
                            }
                        }
                    });
                }
                if (alH.wTM.get(1) != null) {
                    this.jTp.setText(((ef) alH.wTM.get(1)).name);
                    this.jTp.setOnClickListener(new OnClickListener() {
                        public final void onClick(View view) {
                            if (a.this.jTe != null) {
                                a.this.jTe.uZ(((ef) alH.wTM.get(1)).url);
                            }
                        }
                    });
                }
            }
        }
    }

    public final boolean noActionBar() {
        return true;
    }

    public final boolean supportNavigationSwipeBack() {
        return false;
    }

    protected final int getLayoutId() {
        return h.izq;
    }

    public final void onSwipeBack() {
        if (this.jTe != null) {
            this.jTe.onSwipeBack();
        }
    }
}
