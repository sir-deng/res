package com.tencent.mm.plugin.favorite.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.m;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar.LayoutParams;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.fav.a.n;
import com.tencent.mm.plugin.favorite.a.j;
import com.tencent.mm.plugin.favorite.b.h;
import com.tencent.mm.plugin.favorite.ui.a.b;
import com.tencent.mm.plugin.favorite.ui.a.c;
import com.tencent.mm.plugin.favorite.ui.base.FavCapacityPanel;
import com.tencent.mm.plugin.favorite.ui.base.FavSearchActionView;
import com.tencent.mm.plugin.favorite.ui.base.FavTagPanel;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.ui.applet.e;
import com.tencent.mm.pluginsdk.ui.applet.o;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMTagPanel.d;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.y.as;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

@a(19)
public class FavSearchUI extends MMActivity {
    private String flQ;
    private int hZV;
    private ListView kLp;
    private ag mHandler;
    private h mxJ;
    private b mxK;
    private FavCapacityPanel myA;
    private Animation myB;
    private Animation myC;
    private List<Integer> myD;
    private List<String> myE;
    private List<String> myF;
    private Set<String> myG = new HashSet();
    private View myH;
    private ImageButton myI;
    private MenuItem myJ;
    private List<Long> myK = new ArrayList();
    private TextView myL;
    private TextView myM;
    private TextView myN;
    private TextView myO;
    private TextView myP;
    private TextView myQ;
    private OnClickListener myR = new OnClickListener() {
        public final void onClick(View view) {
            int intValue = ((Integer) view.getTag()).intValue();
            FavSearchActionView a = FavSearchUI.this.myw;
            a.mAc.clear();
            a.mAc.add(Integer.valueOf(intValue));
            if (a.mzl != null) {
                a.aKh();
                FavTagPanel favTagPanel = a.mzl;
                String B = j.B(a.getContext(), intValue);
                if (bi.oN(B)) {
                    x.w("MicroMsg.FavTagPanel", "want to add type, but it is null or empty");
                } else {
                    String trim = B.trim();
                    Iterator it = favTagPanel.mAZ.iterator();
                    while (it.hasNext()) {
                        if (trim.equals(((d) it.next()).ymH)) {
                            x.w("MicroMsg.FavTagPanel", "want to add type %s, but it exsited!", trim);
                            break;
                        }
                    }
                    favTagPanel.mAZ.clear();
                    d cqw = favTagPanel.cqw();
                    favTagPanel.mAZ.add(cqw);
                    favTagPanel.a(cqw, trim, true);
                    cqw.ymI.setOnClickListener(favTagPanel.mBb);
                    favTagPanel.addView(cqw.ymI, favTagPanel.mAZ.size() - 1);
                    favTagPanel.cqx();
                }
                if (a.mAU != null) {
                    a.AV(a.mzl.cqq());
                    a.mAU.a(a.mAc, a.mAT, a.mAS, false);
                    g.pWK.h(11126, Integer.valueOf(1));
                }
            }
        }
    };
    private String mys;
    private Set<Integer> myt;
    private n myu;
    private c myv;
    private FavSearchActionView myw;
    private View myx;
    private ListView myy;
    private View myz;

    static /* synthetic */ void a(FavSearchUI favSearchUI, List list, List list2, List list3) {
        if ((list == null || list.isEmpty()) && ((list2 == null || list2.isEmpty()) && (list3 == null || list3.isEmpty()))) {
            favSearchUI.myI.setVisibility(8);
        } else {
            favSearchUI.myI.setVisibility(0);
        }
    }

    static /* synthetic */ void a(FavSearchUI favSearchUI, boolean z) {
        favSearchUI.mxK.notifyDataSetChanged();
        if (8 != favSearchUI.myy.getVisibility()) {
            favSearchUI.myy.setVisibility(8);
            favSearchUI.myy.startAnimation(favSearchUI.myC);
        }
        if (favSearchUI.mxK.isEmpty()) {
            if (favSearchUI.myz.getVisibility() != 0) {
                favSearchUI.myz.setVisibility(0);
                favSearchUI.myz.startAnimation(favSearchUI.myB);
            }
            if (8 != favSearchUI.kLp.getVisibility()) {
                favSearchUI.kLp.setVisibility(8);
                favSearchUI.kLp.startAnimation(favSearchUI.myC);
            }
        } else {
            if (8 != favSearchUI.myz.getVisibility()) {
                favSearchUI.myz.setVisibility(8);
                favSearchUI.myz.startAnimation(favSearchUI.myC);
            }
            if (favSearchUI.kLp.getVisibility() != 0) {
                favSearchUI.kLp.setVisibility(0);
                favSearchUI.kLp.startAnimation(favSearchUI.myB);
            }
        }
        if (favSearchUI.mxK.isEmpty() && ((favSearchUI.myE == null || favSearchUI.myE.isEmpty()) && ((favSearchUI.myD == null || favSearchUI.myD.isEmpty()) && favSearchUI.myF != null && favSearchUI.myF.size() == 1))) {
            x.w("MicroMsg.FavSearchUI", "need del tag %s", (String) favSearchUI.myF.get(0));
            favSearchUI.myG.add(r0);
        }
        if (z) {
            favSearchUI.aWY();
        }
    }

    static /* synthetic */ void c(FavSearchUI favSearchUI) {
        favSearchUI.myv.notifyDataSetChanged();
        if (favSearchUI.myy.getVisibility() != 0) {
            favSearchUI.myy.setVisibility(0);
            favSearchUI.myy.startAnimation(favSearchUI.myB);
        }
        if (8 != favSearchUI.kLp.getVisibility()) {
            favSearchUI.kLp.setVisibility(8);
            favSearchUI.kLp.startAnimation(favSearchUI.myC);
        }
        if (8 != favSearchUI.myz.getVisibility()) {
            favSearchUI.myz.setVisibility(8);
            favSearchUI.myz.startAnimation(favSearchUI.myC);
        }
    }

    static /* synthetic */ int i(FavSearchUI favSearchUI) {
        int size = favSearchUI.myD.size();
        int size2 = favSearchUI.myE.size();
        int size3 = favSearchUI.myF.size();
        if (size == 0 && size2 == 0 && size3 > 0) {
            return 2;
        }
        if (size == 0 && size2 > 0 && size3 == 0) {
            return 3;
        }
        return (size > 0 && size2 == 0 && size3 == 0) ? 1 : 4;
    }

    protected final int getLayoutId() {
        return R.i.dhQ;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mHandler = new ag();
        setMMTitle("");
        this.hZV = getIntent().getIntExtra("key_search_type", 0);
        if (1 == this.hZV) {
            this.flQ = getIntent().getStringExtra("key_to_user");
            this.mys = getIntent().getStringExtra("key_fav_item_id");
        }
        this.myy = (ListView) findViewById(R.h.cQl);
        this.kLp = (ListView) findViewById(R.h.cKg);
        this.myz = findViewById(R.h.cJM);
        this.myB = AnimationUtils.loadAnimation(this.mController.xRr, R.a.bqi);
        this.myC = AnimationUtils.loadAnimation(this.mController.xRr, R.a.bqj);
        aJQ();
        this.myx = View.inflate(this.mController.xRr, R.i.dhW, null);
        this.myL = (TextView) this.myx.findViewById(R.h.chf);
        this.myM = (TextView) this.myx.findViewById(R.h.chc);
        this.myN = (TextView) this.myx.findViewById(R.h.chh);
        this.myO = (TextView) this.myx.findViewById(R.h.che);
        this.myP = (TextView) this.myx.findViewById(R.h.chg);
        this.myQ = (TextView) this.myx.findViewById(R.h.chd);
        this.myL.setOnClickListener(this.myR);
        this.myL.setTag(Integer.valueOf(5));
        this.myM.setOnClickListener(this.myR);
        this.myM.setTag(Integer.valueOf(2));
        this.myN.setOnClickListener(this.myR);
        this.myN.setTag(Integer.valueOf(3));
        this.myO.setOnClickListener(this.myR);
        this.myO.setTag(Integer.valueOf(7));
        this.myP.setOnClickListener(this.myR);
        this.myP.setTag(Integer.valueOf(4));
        this.myQ.setOnClickListener(this.myR);
        this.myQ.setTag(Integer.valueOf(6));
        this.myA = (FavCapacityPanel) View.inflate(this.mController.xRr, R.i.dhx, null);
        this.myA.mAw = getIntent().getIntExtra("key_enter_fav_search_from", 0);
        this.myv = new c(this.mController.xRr) {
            protected final void AR(String str) {
                FavSearchActionView a = FavSearchUI.this.myw;
                a.mAS.add(str);
                if (a.mzl != null) {
                    a.mzl.Zs("");
                    a.mzl.bj(str, true);
                    if (a.mAU != null) {
                        a.AV(a.mzl.cqq());
                        a.mAU.a(a.mAc, a.mAT, a.mAS, false);
                        g.pWK.h(11126, Integer.valueOf(2));
                    }
                }
            }

            protected final void AS(String str) {
                FavSearchActionView a = FavSearchUI.this.myw;
                a.mAS.remove(str);
                if (a.mzl != null) {
                    if (a.mAS.isEmpty()) {
                        a.mzl.Zs(a.getResources().getString(R.l.dGK));
                    }
                    a.mzl.removeTag(str);
                    if (a.mAU != null) {
                        a.AV(a.mzl.cqq());
                        a.mAU.a(a.mAc, a.mAT, a.mAS, true);
                    }
                }
            }
        };
        this.myy.addHeaderView(this.myx);
        if (com.tencent.mm.plugin.favorite.h.aIX().aJe() > 0) {
            this.myy.addHeaderView((TextView) View.inflate(this.mController.xRr, R.i.dhT, null));
        }
        this.myy.addFooterView(this.myA);
        this.myy.setAdapter(this.myv);
        this.myy.setOnTouchListener(new OnTouchListener() {
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        FavSearchUI.this.aWY();
                        break;
                }
                return false;
            }
        });
        this.mxJ = new h(this.mController.xRr, 16);
        ActionBarActivity actionBarActivity = this.mController.xRr;
        this.mxK = new b(this.mxJ, false);
        this.mxK.scene = 2;
        this.mxK.mAk = this.kLp;
        if (1 == this.hZV) {
            this.myt = new HashSet();
            this.myu = new com.tencent.mm.plugin.favorite.a.d();
            if (!bi.oN(this.mys)) {
                for (String str : this.mys.split(",")) {
                    int i = bi.getInt(str, Integer.MAX_VALUE);
                    if (Integer.MAX_VALUE != i) {
                        this.myt.add(Integer.valueOf(i));
                    }
                }
            }
            this.mxK.e(this.myt);
            this.mxK.a(this.myu);
        }
        this.kLp.setAdapter(this.mxK);
        this.kLp.setOnItemClickListener(new OnItemClickListener() {
            public final void onItemClick(AdapterView<?> adapterView, View view, final int i, long j) {
                final com.tencent.mm.plugin.favorite.ui.b.a.b bVar = (com.tencent.mm.plugin.favorite.ui.b.a.b) view.getTag();
                if (1 == FavSearchUI.this.hZV) {
                    if (bVar == null) {
                        x.w("MicroMsg.FavSearchUI", "on item click, holder is null");
                    } else if (bVar.mwn == null) {
                        x.w("MicroMsg.FavSearchUI", "on item click, info is null");
                    } else {
                        e.a aVar = new e.a(FavSearchUI.this.mController.xRr);
                        aVar.bT(FavSearchUI.this.flQ);
                        com.tencent.mm.plugin.favorite.ui.b.e.a(aVar, FavSearchUI.this.mController.xRr, bVar.mwn);
                        com.tencent.mm.plugin.favorite.ui.b.e.b(aVar, FavSearchUI.this.mController.xRr, bVar.mwn);
                        aVar.f(Boolean.valueOf(true)).Co(R.l.dGL).a(new o.a() {
                            public final void a(boolean z, String str, int i) {
                                FavSearchUI.this.aWY();
                                if (z) {
                                    final Dialog a = com.tencent.mm.ui.base.h.a(FavSearchUI.this.mController.xRr, FavSearchUI.this.getString(R.l.efM), false, null);
                                    com.tencent.mm.plugin.favorite.a.e.a(FavSearchUI.this.mController.xRr, FavSearchUI.this.flQ, str, bVar.mwn, new Runnable() {
                                        public final void run() {
                                            if (a != null) {
                                                a.dismiss();
                                            }
                                            com.tencent.mm.ui.snackbar.a.h(FavSearchUI.this, FavSearchUI.this.getString(R.l.eip));
                                            ah.h(new Runnable() {
                                                public final void run() {
                                                    FavSearchUI.this.finish();
                                                }
                                            }, 1800);
                                        }
                                    });
                                }
                            }
                        }).pDT.show();
                    }
                } else if (2 != FavSearchUI.this.hZV) {
                    FavSearchUI.this.mxK.onItemClick(adapterView, view, i, j);
                    if (bVar.mwn != null) {
                        as.Dt().F(new Runnable() {
                            public final void run() {
                                int i;
                                x.d("MicroMsg.FavSearchUI", "type %s", Integer.valueOf(bVar.mwn.field_type));
                                long j = bVar.mwn.field_localId;
                                if (FavSearchUI.this.myK.size() == 0) {
                                    FavSearchUI.this.myK = com.tencent.mm.plugin.favorite.h.getFavItemInfoStorage().aIP();
                                }
                                if (FavSearchUI.this.myK.size() != 0) {
                                    Iterator it = FavSearchUI.this.myK.iterator();
                                    i = 1;
                                    while (it.hasNext() && ((Long) it.next()).longValue() != j) {
                                        i++;
                                    }
                                } else {
                                    i = 1;
                                }
                                g gVar = g.pWK;
                                Object[] objArr = new Object[3];
                                objArr[0] = Integer.valueOf(bVar.mwn.field_type);
                                objArr[1] = Integer.valueOf(FavSearchUI.i(FavSearchUI.this));
                                if (FavSearchUI.this.myK.size() == 0) {
                                    i = i;
                                }
                                objArr[2] = Integer.valueOf(i);
                                gVar.h(12746, objArr);
                            }
                        });
                    }
                } else if (bVar == null) {
                    x.w("MicroMsg.FavSearchUI", "on item click, holder is null");
                } else if (bVar.mwn == null) {
                    x.w("MicroMsg.FavSearchUI", "on item click, info is null");
                } else {
                    Intent intent = new Intent();
                    intent.putExtra("key_fav_result_local_id", bVar.mwn.field_localId);
                    FavSearchUI.this.setResult(-1, intent);
                    FavSearchUI.this.finish();
                }
            }
        });
        this.kLp.setOnTouchListener(new OnTouchListener() {
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        FavSearchUI.this.aWY();
                        break;
                }
                return false;
            }
        });
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                FavSearchUI.this.finish();
                return true;
            }
        });
        com.tencent.mm.plugin.favorite.h.aIX().a(this.myv);
        as.Dt().g(new Runnable() {
            public final void run() {
                FavSearchUI.this.myK = com.tencent.mm.plugin.favorite.h.getFavItemInfoStorage().aIP();
            }
        }, 1000);
    }

    protected void onDestroy() {
        super.onDestroy();
        this.mxJ.destory();
        this.mxJ = null;
        com.tencent.mm.plugin.favorite.h.aIX().a(this.myv);
        com.tencent.mm.plugin.favorite.h.aIX().c(this.myG);
        if (this.mxK != null) {
            this.mxK.finish();
        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        x.d("MicroMsg.FavSearchUI", "on create options menu");
        aJQ();
        this.myJ = menu.add(0, R.h.cvU, 0, R.l.dEU);
        m.a(this.myJ, this.myw);
        m.a(this.myJ, 9);
        this.myw.post(new Runnable() {
            public final void run() {
                FavSearchActionView a = FavSearchUI.this.myw;
                if (a.mzl != null) {
                    a.mzl.cqt();
                }
                FavSearchUI.this.showVKB();
            }
        });
        m.a(this.myJ, new m.e() {
            public final boolean onMenuItemActionExpand(MenuItem menuItem) {
                return true;
            }

            public final boolean onMenuItemActionCollapse(MenuItem menuItem) {
                FavSearchUI.this.finish();
                return true;
            }
        });
        this.mHandler.post(new Runnable() {
            public final void run() {
                if (FavSearchUI.this.myJ != null) {
                    m.b(FavSearchUI.this.myJ);
                    LayoutParams layoutParams = (LayoutParams) FavSearchUI.this.myw.getLayoutParams();
                    if (layoutParams != null) {
                        layoutParams.height = -1;
                        layoutParams.width = -1;
                    }
                    FavSearchUI.this.myw.setLayoutParams(layoutParams);
                }
            }
        });
        return true;
    }

    private void aJQ() {
        if (this.myw == null) {
            this.myw = (FavSearchActionView) View.inflate(this.mController.xRr, R.i.dhP, null);
            this.myH = this.myw.findViewById(R.h.bIc);
            this.myH.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    FavSearchUI.this.finish();
                }
            });
            this.myI = (ImageButton) this.myw.findViewById(R.h.cJA);
            this.myI.setVisibility(8);
            this.myw.mAU = new FavSearchActionView.a() {
                public final void XB() {
                    x.d("MicroMsg.FavSearchUI", "on enter search, show tag panel");
                    FavSearchUI.c(FavSearchUI.this);
                }

                public final void a(List<Integer> list, List<String> list2, List<String> list3, boolean z) {
                    x.d("MicroMsg.FavSearchUI", "on search, types %s keys %s tags %s", list, list2, list3);
                    FavSearchUI.this.myE = list2;
                    FavSearchUI.this.myF = list3;
                    FavSearchUI.this.myD = list;
                    FavSearchUI.this.myv.aO(list3);
                    if (z) {
                        FavSearchUI.c(FavSearchUI.this);
                        FavSearchUI.a(FavSearchUI.this, list, list2, list3);
                        return;
                    }
                    FavSearchUI.this.mxK.c(list, list2, list3);
                    FavSearchUI.a(FavSearchUI.this, true);
                    FavSearchUI.a(FavSearchUI.this, list, list2, list3);
                }

                public final void b(final List<Integer> list, final List<String> list2, final List<String> list3) {
                    FavSearchUI.this.myw.post(new Runnable() {
                        public final void run() {
                            FavSearchUI.a(FavSearchUI.this, list, list2, list3);
                            x.d("MicroMsg.FavSearchUI", "on text changed, types %s keys %s tags %s", list, list2, list3);
                            FavSearchUI.this.myE = list2;
                            FavSearchUI.this.myF = list3;
                            FavSearchUI.this.myD = list;
                            FavSearchUI.this.myv.aO(list3);
                            FavSearchUI.this.mxK.c(list, list2, list3);
                            FavSearchUI.a(FavSearchUI.this, false);
                        }
                    });
                }
            };
        }
    }

    protected void onResume() {
        long j = 0;
        this.mxK.aKb();
        this.mxK.notifyDataSetChanged();
        FavCapacityPanel favCapacityPanel = this.myA;
        if (favCapacityPanel.mAu != j.aJr() / 1048576) {
            favCapacityPanel.mAu = j.aJr() / 1048576;
            TextView textView = favCapacityPanel.mAv;
            Context context = favCapacityPanel.mAv.getContext();
            int i = R.l.eeK;
            Object[] objArr = new Object[2];
            if (favCapacityPanel.mAx - favCapacityPanel.mAu > 0) {
                j = favCapacityPanel.mAx - favCapacityPanel.mAu;
            }
            objArr[0] = Long.valueOf(j);
            objArr[1] = Long.valueOf(favCapacityPanel.mAu);
            textView.setText(context.getString(i, objArr));
        }
        super.onResume();
    }
}
