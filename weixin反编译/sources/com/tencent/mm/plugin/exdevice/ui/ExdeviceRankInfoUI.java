package com.tencent.mm.plugin.exdevice.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Looper;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ad.k;
import com.tencent.mm.f.a.ot;
import com.tencent.mm.f.a.qq;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.exdevice.a.b;
import com.tencent.mm.plugin.exdevice.f.a.j;
import com.tencent.mm.plugin.exdevice.f.a.j.a;
import com.tencent.mm.plugin.exdevice.f.b.a.c;
import com.tencent.mm.plugin.exdevice.f.b.a.d;
import com.tencent.mm.plugin.exdevice.f.b.e;
import com.tencent.mm.plugin.exdevice.f.b.f;
import com.tencent.mm.plugin.exdevice.model.ac;
import com.tencent.mm.plugin.exdevice.model.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMPullDownView;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.base.r;
import com.tencent.mm.ui.widget.g;
import com.tencent.mm.y.as;
import com.tencent.mm.y.q;
import com.tencent.mm.y.s;
import com.tencent.mm.y.u;
import com.tencent.wcdb.FileUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import junit.framework.Assert;

public class ExdeviceRankInfoUI extends MMActivity implements a, e, f, d {
    private static int mbF = FileUtils.S_IWUSR;
    private boolean GO;
    private String jPV;
    private String jvW;
    private boolean lUS;
    public boolean lVe;
    public String lVf;
    private r lYX = null;
    private Map<String, String> mbY = new HashMap();
    private ImageView mbn;
    private View mbt;
    private String mbv;
    private String mbw;
    private ListView mcB;
    private b mcC;
    private View mcD;
    private ExdeviceRankListHeaderView mcE;
    private ExdeviceRankChampionInfoView mcF;
    private View mcG;
    private String mcH;
    private String mcI;
    private String mcJ;
    private String mcK;
    private com.tencent.mm.plugin.exdevice.f.b.a.a mcL;
    private String mcM;
    private int mcN;
    private List<e> mcO;
    private ArrayList<c> mcP;
    private ArrayList<d> mcQ;
    private boolean mcR;
    private boolean mcS;
    private String mcT;
    private boolean mcU;
    private j mcV;
    private b<j> mcW = new b<j>() {
        public final /* synthetic */ void b(int i, int i2, String str, k kVar) {
            j jVar = (j) kVar;
            x.i("MicroMsg.Sport.ExdeviceRankInfoUI", "onNetSceneEndCallback, errType(%s), errCode(%s), errMsg(%s).", Integer.valueOf(i), Integer.valueOf(i2), str);
            if (ExdeviceRankInfoUI.this.isFinishing() || ExdeviceRankInfoUI.this.GO) {
                x.i("MicroMsg.Sport.ExdeviceRankInfoUI", "ExdeviceRankInfoUI has been destroyed.");
                return;
            }
            ExdeviceRankInfoUI.this.runOnUiThread(new Runnable() {
                public final void run() {
                    if (ExdeviceRankInfoUI.this.lYX != null && ExdeviceRankInfoUI.this.lYX.isShowing()) {
                        ExdeviceRankInfoUI.this.lYX.dismiss();
                        ExdeviceRankInfoUI.this.lYX = null;
                        x.d("MicroMsg.Sport.ExdeviceRankInfoUI", "dismiss tips dialog.");
                    }
                }
            });
            if (i == 0 && i2 == 0) {
                ExdeviceRankInfoUI.this.mbv = jVar.lUI;
                ExdeviceRankInfoUI.this.mbw = jVar.lUJ;
                ExdeviceRankInfoUI.this.lVf = jVar.lVf;
                ExdeviceRankInfoUI.this.lVe = jVar.lVe;
                ExdeviceRankInfoUI.this.lUS = jVar.lUS;
                ExdeviceRankInfoUI.this.eO(false);
                ExdeviceRankInfoUI.this.runOnUiThread(new Runnable() {
                    public final void run() {
                        ExdeviceRankInfoUI.this.aFS();
                        if (!bi.oN(ExdeviceRankInfoUI.this.mbv)) {
                            ExdeviceRankInfoUI.this.addIconOptionMenu(0, R.g.bDJ, new OnMenuItemClickListener() {
                                public final boolean onMenuItemClick(MenuItem menuItem) {
                                    com.tencent.mm.plugin.sport.b.d.qq(11);
                                    ExdeviceRankInfoUI.j(ExdeviceRankInfoUI.this);
                                    return true;
                                }
                            });
                        }
                        if (ExdeviceRankInfoUI.this.mcF != null) {
                            ExdeviceRankInfoUI.this.mcF.zW(ExdeviceRankInfoUI.this.mcM);
                        }
                    }
                });
            } else if (ExdeviceRankInfoUI.this.mcO == null || ExdeviceRankInfoUI.this.mcO.size() == 0) {
                ExdeviceRankInfoUI.this.runOnUiThread(new Runnable() {
                    public final void run() {
                        Toast.makeText(ExdeviceRankInfoUI.this, R.l.edB, 1).show();
                        ExdeviceRankInfoUI.this.finish();
                    }
                });
            }
        }
    };

    static /* synthetic */ void c(ExdeviceRankInfoUI exdeviceRankInfoUI, String str) {
        Intent intent = new Intent();
        intent.putExtra("Select_Conv_Type", 3);
        intent.putExtra("select_is_ret", true);
        intent.putExtra("Retr_Msg_Type", 0);
        intent.putExtra("image_path", str);
        com.tencent.mm.bl.d.a((Context) exdeviceRankInfoUI, ".ui.transmit.SelectConversationUI", intent, 1);
    }

    static /* synthetic */ void j(ExdeviceRankInfoUI exdeviceRankInfoUI) {
        g gVar = new g(exdeviceRankInfoUI.mController.xRr, g.zCt, false);
        gVar.rQF = new p.c() {
            public final void a(n nVar) {
                int i;
                if (x.getLogLevel() == 0) {
                    i = 2;
                } else {
                    i = com.tencent.mm.j.g.Af().getInt("WeRunLaunchGroupRankWeAppSwitch", 0);
                }
                if (i == 2) {
                    nVar.a(3, ExdeviceRankInfoUI.this.getString(R.l.edE), R.k.dxb);
                }
                nVar.a(0, ExdeviceRankInfoUI.this.getString(R.l.edD), R.k.dxb);
                nVar.a(1, ExdeviceRankInfoUI.this.getString(R.l.edF), R.k.dwQ);
                nVar.a(2, ExdeviceRankInfoUI.this.getString(R.l.edC), R.k.dwG);
            }
        };
        gVar.rQG = new p.d() {
            public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                switch (menuItem.getItemId()) {
                    case 0:
                        com.tencent.mm.plugin.sport.b.d.qq(15);
                        ExdeviceRankInfoUI.n(ExdeviceRankInfoUI.this);
                        return;
                    case 1:
                        com.tencent.mm.plugin.sport.b.d.qq(16);
                        ExdeviceRankInfoUI.this.aFY();
                        return;
                    case 2:
                        com.tencent.mm.plugin.sport.b.d.qq(7);
                        ExdeviceRankInfoUI.o(ExdeviceRankInfoUI.this);
                        return;
                    case 3:
                        com.tencent.mm.plugin.sport.b.d.qq(36);
                        AppBrandStatObject appBrandStatObject = new AppBrandStatObject();
                        appBrandStatObject.scene = 1063;
                        ((com.tencent.mm.plugin.appbrand.n.d) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.appbrand.n.d.class)).a(null, "gh_1f9ebf140e39@app", null, 0, 0, null, appBrandStatObject);
                        return;
                    default:
                        return;
                }
            }
        };
        gVar.bUX();
    }

    static /* synthetic */ void n(ExdeviceRankInfoUI exdeviceRankInfoUI) {
        if (bi.oN(exdeviceRankInfoUI.lVf)) {
            com.tencent.mm.plugin.exdevice.f.b.a.a zI = ad.aEV().zI(exdeviceRankInfoUI.jPV);
            if (zI != null) {
                exdeviceRankInfoUI.lVf = zI.field_championUrl;
            }
        }
        d f = b.f(exdeviceRankInfoUI.jPV, exdeviceRankInfoUI.mcQ);
        String str = "--";
        String str2 = "0";
        if (f != null) {
            str = String.valueOf(f.field_ranknum);
            str2 = String.valueOf(f.field_score);
        }
        new ac().a((Context) exdeviceRankInfoUI, str, str2, exdeviceRankInfoUI.lVf, new ac.a() {
            public final void zA(String str) {
                ExdeviceRankInfoUI.c(ExdeviceRankInfoUI.this, str);
            }
        });
    }

    static /* synthetic */ void o(ExdeviceRankInfoUI exdeviceRankInfoUI) {
        Intent intent = new Intent();
        intent.putExtra("rawUrl", "https://ssl.gongyi.qq.com/yxj_health/index.html");
        com.tencent.mm.bl.d.b(exdeviceRankInfoUI, "webview", ".ui.tools.WebViewUI", intent);
    }

    static /* synthetic */ void p(ExdeviceRankInfoUI exdeviceRankInfoUI) {
        g gVar = new g(exdeviceRankInfoUI.mController.xRr, g.zCt, false);
        gVar.rQF = new p.c() {
            public final void a(n nVar) {
                if (ExdeviceRankInfoUI.this.lUS) {
                    nVar.f(1, ExdeviceRankInfoUI.this.getString(R.l.edJ));
                } else {
                    nVar.f(0, ExdeviceRankInfoUI.this.getString(R.l.edN));
                }
            }
        };
        gVar.rQG = new p.d() {
            public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                switch (i) {
                    case 0:
                        ExdeviceRankInfoUI.this.lUS = true;
                        com.tencent.mm.plugin.sport.b.d.qq(10);
                        ad.aEZ();
                        com.tencent.mm.plugin.exdevice.f.b.c.b("", ExdeviceRankInfoUI.this.mcJ, ExdeviceRankInfoUI.this.mcL.field_username, 3);
                        return;
                    default:
                        return;
                }
            }
        };
        gVar.bUX();
    }

    private void eO(boolean z) {
        if (!this.mcS || z) {
            ad.aEZ();
            this.mcQ = com.tencent.mm.plugin.exdevice.f.b.c.zE(this.mcK);
            this.mcP = ad.aET().aFf();
            this.mcO = this.mcC.b(this.mcP, this.mcQ, this.lVe);
            runOnUiThread(new Runnable() {
                public final void run() {
                    ExdeviceRankInfoUI.this.mcC.mbX = ExdeviceRankInfoUI.this.mcO;
                    ExdeviceRankInfoUI.this.mcC.notifyDataSetChanged();
                    ExdeviceRankInfoUI.this.mcG.setVisibility(0);
                }
            });
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.GO = false;
        this.jPV = q.FY();
        Intent intent = getIntent();
        this.mcH = intent.getStringExtra("key_rank_info");
        this.mcI = intent.getStringExtra("key_rank_semi");
        this.mcJ = intent.getStringExtra("app_username");
        this.mcK = intent.getStringExtra("rank_id");
        this.mcR = intent.getBooleanExtra("key_is_latest", false);
        this.mcM = intent.getStringExtra("key_champioin_username");
        this.mcN = intent.getIntExtra("device_type", 0);
        this.mcT = intent.getStringExtra("locate_to_username");
        this.mcS = intent.getBooleanExtra("key_only_show_latest_rank", false);
        if (bi.oN(this.mcK) || "#".equals(this.mcK)) {
            if (!this.mcS) {
                d dVar;
                com.tencent.mm.plugin.exdevice.f.b.b.d aES = ad.aES();
                Cursor a = aES.gLA.a(String.format("select * from %s order by %s desc limit 1", new Object[]{"HardDeviceRankInfo", "rankID"}), null, 2);
                if (a == null) {
                    x.e("MicroMsg.ExdeviceRankInfoStg", "Get no rank in DB");
                    dVar = null;
                } else {
                    if (a.moveToFirst()) {
                        dVar = new d();
                        dVar.b(a);
                    } else {
                        x.d("MicroMsg.ExdeviceRankInfoStg", "hy: no record");
                        dVar = null;
                    }
                    a.close();
                }
                if (dVar != null) {
                    this.mcK = dVar.field_rankID;
                    this.mcJ = dVar.field_appusername;
                }
            }
            this.mcM = null;
            this.mcR = true;
        }
        ad.aEZ();
        this.mcQ = com.tencent.mm.plugin.exdevice.f.b.c.zE(this.mcK);
        if (!this.mcS) {
            if (this.mcQ == null || this.mcQ.size() <= 0) {
                this.mcP = new ArrayList();
                this.mcQ = com.tencent.mm.plugin.exdevice.f.a.a.a(this.mcK, this.mcJ, this.mcH, this.mcI, this.mbY, this.mcP);
                ad.aEZ();
                com.tencent.mm.plugin.exdevice.f.b.c.d(this.mcK, this.mcQ);
            } else {
                com.tencent.mm.plugin.exdevice.f.a.a.a(this.mcH, this.mcI, this.mbY);
            }
            this.mcP = ad.aET().aFf();
        }
        this.mcC = new b(this, this.mcJ);
        this.mcC.mbY = this.mbY;
        this.mcO = this.mcC.b(this.mcP, this.mcQ, this.lVe);
        this.mcC.mbX = this.mcO;
        if (bi.oN(this.mcM)) {
            aFT();
        }
        this.mcL = ad.aEV().zI(this.mcM);
        if (this.mcL == null && !bi.oN(this.mcM)) {
            this.mcL = new com.tencent.mm.plugin.exdevice.f.b.a.a();
            this.mcL.field_username = this.mcM;
            this.mcL.field_championMotto = getIntent().getStringExtra("key_champion_info");
            this.mcL.field_championUrl = getIntent().getStringExtra("key_champion_coverimg");
            ad.aEZ();
            ad.aEV().a(this.mcL, true);
        }
        initView();
        if (this.mcQ != null && this.mcQ.size() > 0) {
            this.mcF.zW(((d) this.mcQ.get(0)).field_username);
        }
        ad.aFa().a(this);
        ad.aEZ().lVo = this;
        aFR();
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                ExdeviceRankInfoUI.this.finish();
                return false;
            }
        });
        setMMTitle(R.l.eef);
        showOptionMenu(true);
        aFS();
        com.tencent.mm.sdk.b.b qqVar = new qq();
        qqVar.fJc.action = 2;
        com.tencent.mm.sdk.b.a.xmy.a(qqVar, Looper.getMainLooper());
    }

    private void aFR() {
        x.i("MicroMsg.Sport.ExdeviceRankInfoUI", "updateRankInfoUIFromServer");
        this.mcV = new j(this.mcK, this.mcJ, this.mcM, this.mcR, this.mcW);
        this.mcV.lVh = this;
        as.CN().a(this.mcV, 0);
    }

    private void aFS() {
        x.i("MicroMsg.Sport.ExdeviceRankInfoUI", "try2LocateToUser, locate2User(%s), username(%s).", this.mcT, this.jPV);
        if (!bi.oN(this.mcT)) {
            int i;
            String str = this.mcT;
            x.i("MicroMsg.Sport.ExdeviceRankInfoUI", "locateToUser, locate2User(%s), username(%s).", str, this.jPV);
            if (bi.oN(str)) {
                i = -1;
            } else if (this.mcO == null || this.mcO.size() == 0) {
                i = -2;
            } else {
                i = 0;
                while (i < this.mcO.size()) {
                    d dVar = ((e) this.mcO.get(i)).meX;
                    int i2 = ((e) this.mcO.get(i)).meY;
                    if (dVar != null && str.equalsIgnoreCase(dVar.field_username) && !str.equalsIgnoreCase(this.jPV) && (i2 & 2) != 2) {
                        DisplayMetrics displayMetrics = new DisplayMetrics();
                        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
                        x.i("MicroMsg.Sport.ExdeviceRankInfoUI", "locateToUser pos(%d).(h : %d)", Integer.valueOf(i), Integer.valueOf(displayMetrics.heightPixels));
                        this.mcB.setSelectionFromTop(i, i2 / 4);
                        this.mcC.mbZ = str;
                        this.mcC.notifyDataSetInvalidated();
                        aFV();
                        break;
                    }
                    i++;
                }
                this.mcC.mbZ = null;
                i = -3;
            }
            if (i >= 0) {
                return;
            }
        }
        x.d("MicroMsg.Sport.ExdeviceRankInfoUI", "locate to username is null or nil.");
    }

    private void aFL() {
        if (this.mcL == null || this.jPV == null || !this.jPV.equals(this.mcL.field_username) || !bi.oN(this.mcL.field_championUrl)) {
            if (this.mbt != null) {
                this.mbt.setVisibility(8);
            }
            if (this.mcL != null && !bi.aD(this.mcL.field_username, "").equals(this.jPV) && !bi.oN(this.mcL.field_championUrl)) {
                this.mcE.mdb = new OnClickListener() {
                    public final void onClick(View view) {
                        ExdeviceRankInfoUI.p(ExdeviceRankInfoUI.this);
                    }
                };
                return;
            }
            return;
        }
        if (this.mbt != null) {
            this.mbt.setVisibility(0);
        }
        if (this.mcE != null) {
            this.mcE.mdb = new OnClickListener() {
                public final void onClick(View view) {
                    com.tencent.mm.plugin.exdevice.f.a.e.b(ExdeviceRankInfoUI.this);
                }
            };
        }
    }

    private void aFT() {
        String aFU = aFU();
        if (!bi.oN(aFU)) {
            this.mcM = aFU;
        }
    }

    private String aFU() {
        if (this.mcO != null) {
            for (e eVar : this.mcO) {
                d dVar = eVar.meX;
                if (dVar != null && dVar.field_ranknum == 1) {
                    return dVar.field_username;
                }
            }
        }
        return null;
    }

    protected final void initView() {
        int dimensionPixelSize;
        int size;
        boolean z;
        this.mcD = findViewById(R.h.cAL);
        ExdeviceRankListHeaderView exdeviceRankListHeaderView = new ExdeviceRankListHeaderView(this);
        Rect rect = new Rect();
        getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
        int i = rect.top;
        if (i == 0) {
            i = com.tencent.mm.plugin.exdevice.j.b.A(this, getResources().getDimensionPixelSize(R.f.buP));
        }
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        if (displayMetrics.widthPixels > displayMetrics.heightPixels) {
            dimensionPixelSize = getResources().getDimensionPixelSize(R.f.buG);
        } else {
            dimensionPixelSize = getResources().getDimensionPixelSize(R.f.buH);
        }
        Display defaultDisplay = getWindowManager().getDefaultDisplay();
        i = ((defaultDisplay.getHeight() / 2) - i) - dimensionPixelSize;
        if (defaultDisplay.getHeight() <= 0 || i <= 0) {
            i = getResources().getDimensionPixelSize(R.f.buO);
        }
        exdeviceRankListHeaderView.setMinimumHeight(i);
        exdeviceRankListHeaderView.setMinimumWidth(defaultDisplay.getWidth());
        exdeviceRankListHeaderView.setTag(Integer.valueOf(i));
        this.mcE = exdeviceRankListHeaderView;
        MMPullDownView mMPullDownView = (MMPullDownView) findViewById(R.h.cEp);
        this.mcB = (ListView) findViewById(R.h.cfv);
        this.mcF = (ExdeviceRankChampionInfoView) findViewById(R.h.bSA);
        this.mbt = findViewById(R.h.cLL);
        this.mbt.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                x.d("MicroMsg.Sport.ExdeviceRankInfoUI", "ap: start change cover");
                com.tencent.mm.plugin.exdevice.f.a.e.b(ExdeviceRankInfoUI.this);
            }
        });
        this.mcE.mdf = false;
        aFL();
        mMPullDownView.mu(false);
        mMPullDownView.mw(false);
        mMPullDownView.mv(false);
        mMPullDownView.mu(false);
        mMPullDownView.mt(false);
        mMPullDownView.ylo = true;
        mMPullDownView.ylr = new MMPullDownView.a() {
            public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
                boolean z;
                ExdeviceRankInfoUI exdeviceRankInfoUI = ExdeviceRankInfoUI.this;
                if (ExdeviceRankInfoUI.this.mcO == null || ExdeviceRankInfoUI.this.mcO.size() == 0) {
                    z = false;
                } else {
                    z = true;
                }
                exdeviceRankInfoUI.mcU = z;
                return false;
            }
        };
        mMPullDownView.ylg = new MMPullDownView.c() {
            public final boolean azT() {
                View childAt = ExdeviceRankInfoUI.this.mcB.getChildAt(ExdeviceRankInfoUI.this.mcB.getChildCount() - 1);
                int count = ExdeviceRankInfoUI.this.mcB.getCount();
                if (count <= 0 || childAt == null || childAt.getBottom() > ExdeviceRankInfoUI.this.mcB.getHeight() || ExdeviceRankInfoUI.this.mcB.getLastVisiblePosition() != count - 1) {
                    return false;
                }
                return true;
            }
        };
        mMPullDownView.ylz = new MMPullDownView.b() {
            public final void aFP() {
                ExdeviceRankInfoUI.this.aFV();
            }
        };
        mMPullDownView.ylh = new MMPullDownView.d() {
            public final boolean azS() {
                int firstVisiblePosition = ExdeviceRankInfoUI.this.mcB.getFirstVisiblePosition();
                if (firstVisiblePosition == 0) {
                    View childAt = ExdeviceRankInfoUI.this.mcB.getChildAt(firstVisiblePosition);
                    if (childAt != null && childAt.getTop() >= 0) {
                        return true;
                    }
                }
                return false;
            }
        };
        this.mcB.setOnScrollListener(new OnScrollListener() {
            public final void onScrollStateChanged(AbsListView absListView, int i) {
                ExdeviceRankInfoUI.this.aFV();
            }

            public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
                ExdeviceRankInfoUI.this.aFV();
            }
        });
        this.mcB.addHeaderView(this.mcE, null, false);
        View inflate = getLayoutInflater().inflate(R.i.dhj, null);
        this.mcG = inflate.findViewById(R.h.cqc);
        inflate.findViewById(R.h.cqb).setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                com.tencent.mm.plugin.sport.b.d.qq(24);
                Intent intent = new Intent();
                intent.putExtra("Select_Talker_Name", "gh_43f2581f6fd6");
                intent.putExtra("Select_block_List", "gh_43f2581f6fd6");
                intent.putExtra("Select_Conv_Type", 3);
                intent.putExtra("mutil_select_is_ret", true);
                intent.putExtra("Select_Send_Card", true);
                com.tencent.mm.bl.d.a(ExdeviceRankInfoUI.this, ".ui.transmit.SelectConversationUI", intent, 3);
            }
        });
        this.mcG.setVisibility(8);
        this.mcB.addFooterView(inflate);
        if (this.mcP != null) {
            dimensionPixelSize = this.mcP.size();
        } else {
            dimensionPixelSize = 0;
        }
        if (this.mcQ != null) {
            size = this.mcQ.size();
        } else {
            size = 0;
        }
        if (dimensionPixelSize + size == 0) {
            this.mcO = new ArrayList();
            this.mcC.mbX = this.mcO;
            getString(R.l.dGZ);
            this.lYX = h.a((Context) this, getString(R.l.ctG), true, new OnCancelListener() {
                public final void onCancel(DialogInterface dialogInterface) {
                    if (ExdeviceRankInfoUI.this.lYX != null) {
                        ExdeviceRankInfoUI.this.lYX.dismiss();
                        ExdeviceRankInfoUI.this.lYX = null;
                    }
                    ExdeviceRankInfoUI.this.finish();
                }
            });
        }
        this.mcB.setAdapter(this.mcC);
        this.mcC.mca = this;
        if (this.mcN == 1) {
            this.mcB.setVisibility(0);
            this.mcD.setVisibility(8);
            z = true;
        } else {
            this.mcB.setVisibility(8);
            this.mcD.setVisibility(0);
            z = false;
        }
        if (z) {
            this.mbn = (ImageView) findViewById(R.h.ceY);
            mMPullDownView.ylo = false;
            dimensionPixelSize = com.tencent.mm.bu.a.eB(this);
            i = ((Integer) this.mcE.getTag()).intValue();
            if (this.lVe) {
                i += (getResources().getDimensionPixelSize(R.f.buR) / 2) + getResources().getDimensionPixelSize(R.f.buQ);
            }
            this.mbn.setLayoutParams(new LayoutParams(dimensionPixelSize, i));
            aFW();
            eP(false);
            return;
        }
        x.d("MicroMsg.Sport.ExdeviceRankInfoUI", "hy: cannot handle this device type");
        finish();
    }

    private void aFV() {
        View childAt = this.mcB.getChildAt(0);
        int[] iArr = new int[2];
        if (childAt != null) {
            if (this.mcB.getFirstVisiblePosition() == 0) {
                childAt.getLocationOnScreen(iArr);
                if (bi.oN(this.mcT) && mbF == FileUtils.S_IWUSR) {
                    mbF = iArr[1];
                }
                int i = iArr[1];
                if (i > 0) {
                    float f;
                    if (i >= mbF) {
                        f = 1.0f;
                    } else {
                        f = ((float) i) / ((float) mbF);
                    }
                    x.d("MicroMsg.Sport.ExdeviceRankInfoUI", "ap-alpha: %s", Float.valueOf(f));
                    this.mcF.setAlpha(f);
                    this.mcF.setVisibility(0);
                    this.mbt.setAlpha(f);
                    return;
                }
            }
            this.mcF.setAlpha(0.0f);
            this.mbt.setAlpha(0.0f);
            this.mcF.setVisibility(8);
        }
    }

    protected void onResume() {
        super.onResume();
    }

    protected void onRestart() {
        super.onRestart();
        eO(true);
    }

    protected void onDestroy() {
        this.GO = true;
        if (this.mcC != null) {
            b.finish();
        }
        super.onDestroy();
        if (this.mcV != null) {
            this.mcV.lVh = null;
        }
        ad.aFa().b(this);
        ad.aEZ().lVo = null;
        ad.aEZ().lVp = null;
    }

    protected void onPause() {
        super.onPause();
    }

    protected final int getLayoutId() {
        return R.i.dhl;
    }

    private void aFW() {
        if (this.mcL == null) {
            this.mbn.setImageResource(R.e.brW);
            this.jvW = null;
        } else if (this.jvW == this.mcL.field_championUrl) {
        } else {
            if (this.jvW == null || !this.jvW.equals(this.mcL.field_championUrl)) {
                com.tencent.mm.plugin.exdevice.f.a.e.a(this, this.mbn, this.mcL.field_championUrl, R.e.brW);
                this.jvW = this.mcL.field_championUrl;
            }
        }
    }

    private void eP(boolean z) {
        if (z) {
            aFT();
        }
        if (bi.oN(this.mcJ)) {
            this.mcF.setVisibility(8);
            return;
        }
        this.mcF.zW(this.mcM);
        this.mcF.setVisibility(0);
    }

    public final void b(String str, com.tencent.mm.plugin.exdevice.f.b.d dVar) {
        boolean z = (dVar == null || bi.oN(str)) ? false : true;
        Assert.assertTrue(z);
        if ("HardDeviceRankInfo".equals(str)) {
            if (this.mcK != null && this.mcK.equals(dVar.lUU)) {
                x.i("MicroMsg.Sport.ExdeviceRankInfoUI", "onRankChange, rankId(%s).", this.mcK);
                eO(true);
                if (bi.oN(this.mcM) || !this.mcM.equals(aFU())) {
                    aFT();
                    this.mcL = ad.aEV().zI(this.mcM);
                    runOnUiThread(new Runnable() {
                        public final void run() {
                            ExdeviceRankInfoUI.this.aFL();
                            ExdeviceRankInfoUI.this.aFW();
                        }
                    });
                }
                runOnUiThread(new Runnable() {
                    public final void run() {
                        ExdeviceRankInfoUI.this.eP(true);
                        if (ExdeviceRankInfoUI.this.mcU) {
                            ExdeviceRankInfoUI.this.mcC.notifyDataSetChanged();
                        } else {
                            ExdeviceRankInfoUI.this.aFS();
                        }
                    }
                });
            }
        } else if ("HardDeviceChampionInfo".equals(str) && !bi.oN(this.mcM) && this.mcM.equals(dVar.username)) {
            this.mcL = ad.aEV().zI(this.mcM);
            runOnUiThread(new Runnable() {
                public final void run() {
                    ExdeviceRankInfoUI.this.aFL();
                    ExdeviceRankInfoUI.this.aFW();
                }
            });
        }
    }

    public final void zF(String str) {
        x.d("MicroMsg.Sport.ExdeviceRankInfoUI", "hy: rank changed to %s", str);
        this.mcK = str;
    }

    public final void zY(String str) {
        com.tencent.mm.plugin.sport.b.d.qq(6);
        Intent intent = new Intent(this, ExdeviceProfileUI.class);
        intent.putExtra("username", str);
        intent.putExtra("usernickname", (String) this.mbY.get(str));
        intent.putExtra("app_username", this.mcJ);
        intent.putExtra("rank_id", this.mcK);
        startActivityForResult(intent, 4);
    }

    public final void aFX() {
        com.tencent.mm.plugin.sport.b.d.qq(31);
        aFY();
    }

    public final void bj(String str, int i) {
        ad.aEZ();
        String str2 = this.mcK;
        String str3 = this.mcJ;
        com.tencent.mm.plugin.exdevice.f.b.b.d aES = ad.aES();
        boolean z = (bi.oN(str2) || bi.oN(str) || (i != 1 && i != 0 && i != 2)) ? false : true;
        Assert.assertTrue(z);
        d a = aES.a(new com.tencent.mm.plugin.exdevice.f.b.d(str2, null, str));
        if (a == null) {
            x.w("MicroMsg.ExdeviceRankInfoStg", "hy: info is null. abort");
        } else {
            a.field_selfLikeState = i;
            switch (a.field_selfLikeState) {
                case 0:
                    a.field_likecount--;
                    break;
                case 1:
                    a.field_likecount++;
                    break;
                default:
                    x.w("MicroMsg.ExdeviceRankInfoStg", "hy: still loading...abort");
                    break;
            }
            aES.a(a, true);
        }
        com.tencent.mm.plugin.exdevice.f.b.c.b(str2, str3, str, i);
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (!com.tencent.mm.plugin.exdevice.f.a.e.a(this, i, i2, intent, this.mcJ) && i2 == -1) {
            String stringExtra;
            switch (i) {
                case 1:
                    if (intent == null) {
                        x.e("MicroMsg.Sport.ExdeviceRankInfoUI", "onActivityResult, data is null.(reqestCode : %d)", Integer.valueOf(i));
                        return;
                    }
                    stringExtra = intent == null ? null : intent.getStringExtra("Select_Conv_User");
                    if (stringExtra == null || stringExtra.length() == 0) {
                        x.e("MicroMsg.Sport.ExdeviceRankInfoUI", "select conversation failed, toUser is null.");
                        return;
                    }
                    ac.a((Context) this, stringExtra, ac.cx(this), intent.getStringExtra("custom_send_text"), this.mbw);
                    h.bu(this.mController.xRr, getResources().getString(R.l.dGR));
                    x.d("MicroMsg.Sport.ExdeviceRankInfoUI", "Select conversation return.");
                    return;
                case 2:
                    h.bu(this.mController.xRr, getResources().getString(R.l.dGR));
                    x.d("MicroMsg.Sport.ExdeviceRankInfoUI", "Share to timeline return.");
                    return;
                case 3:
                    if (intent != null) {
                        List<String> F = bi.F(intent.getStringExtra("received_card_name").split(","));
                        String stringExtra2 = intent.getStringExtra("custom_send_text");
                        for (String stringExtra3 : F) {
                            com.tencent.mm.plugin.messenger.a.f.aZN().l("gh_43f2581f6fd6", stringExtra3, s.eX(stringExtra3));
                            if (!bi.oN(stringExtra2)) {
                                com.tencent.mm.sdk.b.b otVar = new ot();
                                otVar.fHD.fHE = stringExtra3;
                                otVar.fHD.content = stringExtra2;
                                otVar.fHD.type = s.hs(stringExtra3);
                                otVar.fHD.flags = 0;
                                com.tencent.mm.sdk.b.a.xmy.m(otVar);
                            }
                        }
                        return;
                    }
                    return;
                case 4:
                    if (intent != null && intent.getBooleanExtra("KeyNeedUpdateRank", false)) {
                        aFR();
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public final boolean zZ(String str) {
        if (bi.oN(this.mcK) || "#".equals(this.mcK)) {
            x.d("MicroMsg.Sport.ExdeviceRankInfoUI", "hy: rank id is not valid.abort the event");
            Toast.makeText(this, getString(R.l.edS), 0).show();
            return true;
        } else if (!q.FY().equals(str)) {
            return false;
        } else {
            x.d("MicroMsg.Sport.ExdeviceRankInfoUI", "hy: is self. see who likes me");
            Intent intent = new Intent(this, ExdeviceLikeUI.class);
            intent.putExtra("app_username", this.mcJ);
            intent.putExtra("rank_id", this.mcK);
            intent.putExtra("key_is_like_read_only", true);
            startActivity(intent);
            return true;
        }
    }

    private void aFY() {
        if (bi.oN(this.lVf)) {
            com.tencent.mm.plugin.exdevice.f.b.a.a zI = ad.aEV().zI(this.jPV);
            if (zI != null) {
                this.lVf = zI.field_championUrl;
            }
        }
        d f = b.f(this.jPV, this.mcQ);
        String str = "--";
        String str2 = "0";
        if (f != null) {
            str = String.valueOf(f.field_ranknum);
            str2 = String.valueOf(f.field_score);
        }
        new ac().a((Context) this, str, str2, this.lVf, new ac.a() {
            public final void zA(String str) {
                Intent intent = new Intent();
                intent.putExtra("Ksnsupload_appid", "wx7fa037cc7dfabad5");
                intent.putExtra("Ksnsupload_appname", ExdeviceRankInfoUI.this.getString(R.l.eee));
                intent.putExtra("Ksnsupload_source", 1);
                intent.putExtra("need_result", true);
                String hC = u.hC("wx_sport");
                u.GQ().t(hC, true).o("prePublishId", "wx_sport");
                intent.putExtra("reportSessionId", hC);
                intent.putExtra("Ksnsupload_type", 0);
                intent.putExtra("sns_kemdia_path", str);
                com.tencent.mm.bl.d.b(ExdeviceRankInfoUI.this, "sns", ".ui.SnsUploadUI", intent, 2);
            }
        });
    }

    public final void a(j jVar) {
        runOnUiThread(new Runnable() {
            public final void run() {
                if (ExdeviceRankInfoUI.this.lYX != null && ExdeviceRankInfoUI.this.lYX.isShowing()) {
                    ExdeviceRankInfoUI.this.lYX.dismiss();
                    ExdeviceRankInfoUI.this.lYX = null;
                    x.d("MicroMsg.Sport.ExdeviceRankInfoUI", "dismiss tips dialog.");
                }
            }
        });
        this.mbv = jVar.lUI;
        this.mbw = jVar.lUJ;
        this.lVf = jVar.lVf;
        this.lVe = jVar.lVe;
        this.lUS = jVar.lUS;
        this.mcQ = jVar.lUX;
        this.mcP = jVar.lUY;
        this.mcO = this.mcC.b(this.mcP, this.mcQ, this.lVe);
        runOnUiThread(new Runnable() {
            public final void run() {
                ExdeviceRankInfoUI.this.mcC.mbX = ExdeviceRankInfoUI.this.mcO;
                ExdeviceRankInfoUI.this.mcC.notifyDataSetChanged();
                ExdeviceRankInfoUI.this.mcG.setVisibility(0);
            }
        });
    }
}
