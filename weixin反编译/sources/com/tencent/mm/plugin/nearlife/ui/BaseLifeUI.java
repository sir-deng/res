package com.tencent.mm.plugin.nearlife.ui;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.modelgeo.a.a;
import com.tencent.mm.modelgeo.c;
import com.tencent.mm.modelstat.o;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.r;
import com.tencent.mm.protocal.c.aot;
import com.tencent.mm.protocal.c.bes;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper.LatLongData;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMLoadMoreListView;
import com.tencent.mm.ui.tools.p;
import com.tencent.mm.ui.tools.p.b;
import com.tencent.mm.y.as;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public abstract class BaseLifeUI extends MMActivity implements e {
    boolean gAj = false;
    protected String hMN = "";
    boolean hpb = false;
    protected boolean hzA = true;
    protected String iVa = "";
    private p liK;
    private int nWw = 1;
    private boolean oUs = false;
    private a oVA;
    private a oVB;
    private View oVC;
    private TextView oVD;
    private TextView oVE;
    private c oVF = c.OV();
    private com.tencent.mm.plugin.nearlife.b.c oVG;
    private int oVH;
    private List<aot> oVI;
    protected aot oVJ = null;
    protected float oVK = 0.0f;
    protected float oVL = 0.0f;
    protected int oVM = 0;
    protected float oVN = 0.0f;
    protected long oVO = -1;
    protected long oVP = -1;
    protected long oVQ = -1;
    protected int oVR = 0;
    protected boolean oVS = false;
    protected int oVT = -1;
    protected boolean oVU = false;
    private OnClickListener oVV = new OnClickListener() {
        public final void onClick(View view) {
            BaseLifeUI.a(BaseLifeUI.this);
        }
    };
    private OnClickListener oVW = new OnClickListener() {
        public final void onClick(View view) {
            if (BaseLifeUI.this.oVJ == null) {
                x.e("MicroMsg.BaseLifeUI", "Location is null");
                return;
            }
            g.pWK.h(11138, "1", Integer.valueOf(BaseLifeUI.this.oVB.getCount() + 1), BaseLifeUI.this.iVa);
            Intent intent = new Intent();
            intent.setClass(BaseLifeUI.this, NearLifeCreatePoiUI.class);
            intent.putExtra("get_lat", BaseLifeUI.this.oVJ.vXy);
            intent.putExtra("get_lng", BaseLifeUI.this.oVJ.vXx);
            intent.putExtra("get_preci", BaseLifeUI.this.oVJ.wjv);
            intent.putExtra("get_poi_name", BaseLifeUI.this.oVB.bfJ());
            intent.putExtra("get_cur_lat", BaseLifeUI.this.oVK);
            intent.putExtra("get_cur_lng", BaseLifeUI.this.oVL);
            intent.putExtra("get_accuracy", BaseLifeUI.this.oVN);
            intent.putExtra("get_loctype", BaseLifeUI.this.oVM);
            intent.putExtra("search_id", BaseLifeUI.this.iVa);
            intent.putExtra("get_is_mars", BaseLifeUI.this.hzA);
            BaseLifeUI.this.startActivityForResult(intent, 1);
        }
    };
    private a oVX = new a() {
        public final boolean a(boolean z, float f, float f2, int i, double d, double d2, double d3) {
            if (BaseLifeUI.this.hpb) {
                return false;
            }
            if (BaseLifeUI.this.gAj) {
                return false;
            }
            if (!z) {
                return true;
            }
            o.a(2003, f, f2, (int) d2);
            BaseLifeUI.this.gAj = true;
            x.i("MicroMsg.BaseLifeUI", "on get location %f %f " + System.currentTimeMillis(), Float.valueOf(f2), Float.valueOf(f));
            BaseLifeUI.this.oVJ = new aot();
            BaseLifeUI.this.oVJ.wjx = "";
            BaseLifeUI.this.oVJ.wjy = 0;
            BaseLifeUI.this.oVJ.vXy = f2;
            BaseLifeUI.this.oVJ.vXx = f;
            BaseLifeUI.this.oVJ.wjw = "";
            BaseLifeUI.this.oVJ.wjv = (int) d2;
            BaseLifeUI.this.oVK = f2;
            BaseLifeUI.this.oVL = f;
            BaseLifeUI.this.oVM = i;
            BaseLifeUI.this.oVN = (float) d2;
            BaseLifeUI.this.hzA = BaseLifeUI.this.oVF == null ? false : BaseLifeUI.this.oVF.hzA;
            ArrayList arrayList = BaseLifeUI.this.oVA.oVr;
            if (arrayList == null || arrayList.size() <= 0) {
                BaseLifeUI.this.l((double) f2, (double) f);
            } else {
                LatLongData latLongData = (LatLongData) arrayList.get(arrayList.size() - 1);
                BaseLifeUI.this.l((double) latLongData.fAo, (double) latLongData.hDw);
                BaseLifeUI.this.oVU = BaseLifeUI.d(latLongData.fAo, latLongData.hDw, f2, f);
            }
            BaseLifeUI.this.oVA.oVv = new LatLongData(BaseLifeUI.this.oVJ.vXy, BaseLifeUI.this.oVJ.vXx);
            BaseLifeUI.this.oVB.oVv = new LatLongData(BaseLifeUI.this.oVJ.vXy, BaseLifeUI.this.oVJ.vXx);
            BaseLifeUI.a(BaseLifeUI.this, BaseLifeUI.this.odb ? BaseLifeUI.this.oVB : BaseLifeUI.this.oVA);
            BaseLifeUI.this.hc(false);
            BaseLifeUI.this.a(BaseLifeUI.this.liK);
            return false;
        }
    };
    private String oVl = "";
    private View oVy;
    private NearLifeErrorContent oVz;
    public int ocI = -1;
    MMLoadMoreListView ocb;
    boolean odb = false;
    int sceneType = 0;

    public abstract a bfL();

    public abstract a bfM();

    public abstract void l(double d, double d2);

    static /* synthetic */ void a(BaseLifeUI baseLifeUI) {
        if (baseLifeUI.oVH != -1 || baseLifeUI.oVG != null) {
            x.i("MicroMsg.BaseLifeUI", "is loading, please wait");
        } else if (baseLifeUI.hc(true)) {
            baseLifeUI.ocb.cqf();
        }
    }

    static /* synthetic */ void a(BaseLifeUI baseLifeUI, a aVar) {
        if (baseLifeUI.oVJ == null) {
            x.e("MicroMsg.BaseLifeUI", "location is null");
            return;
        }
        Map hashMap = new HashMap();
        baseLifeUI.oVI.clear();
        if (aVar.oVw && baseLifeUI.oVJ != null) {
            baseLifeUI.oVI.add(baseLifeUI.oVJ);
            hashMap.put(new LatLongData(baseLifeUI.oVJ.vXy, baseLifeUI.oVJ.vXx), Integer.valueOf(1));
        }
        Iterator it = aVar.oVr.iterator();
        while (it.hasNext()) {
            LatLongData latLongData = (LatLongData) it.next();
            if (!hashMap.containsKey(latLongData)) {
                aot aot = new aot();
                aot.wjx = "";
                aot.wjy = 0;
                aot.vXy = latLongData.fAo;
                aot.vXx = latLongData.hDw;
                aot.wjw = "";
                aot.wjv = 0;
                baseLifeUI.oVI.add(aot);
                hashMap.put(latLongData, Integer.valueOf(1));
            }
        }
        baseLifeUI.oVG = null;
        baseLifeUI.oVH = -1;
        x.i("MicroMsg.BaseLifeUI", "list size:" + baseLifeUI.oVI.size() + " show curpos: " + aVar.oVw);
    }

    static /* synthetic */ void a(BaseLifeUI baseLifeUI, String str) {
        x.d("MicroMsg.BaseLifeUI", "do auto query");
        baseLifeUI.ul(8);
        if (baseLifeUI.nWw <= 0) {
            x.i("MicroMsg.BaseLifeUI", "block by autoQueryInterval: %d", Integer.valueOf(baseLifeUI.nWw));
            return;
        }
        aot aot;
        if (baseLifeUI.oVG != null) {
            as.CN().c(baseLifeUI.oVG);
            baseLifeUI.oVG = null;
        }
        if (baseLifeUI.oVI.size() > 0) {
            aot = (aot) baseLifeUI.oVI.get(0);
        } else {
            x.i("MicroMsg.BaseLifeUI", "empty lbslist");
            aot = new aot();
        }
        baseLifeUI.oVH = 0;
        baseLifeUI.oVB.Hf(str);
        baseLifeUI.oVG = new com.tencent.mm.plugin.nearlife.b.c(1, baseLifeUI.sceneType, aot.vXx, aot.vXy, aot.wjv, aot.wjy, aot.wjw, aot.wjx, null, baseLifeUI.odb ? baseLifeUI.oVB.bfJ() : "", baseLifeUI.ocI, false);
        as.CN().a(baseLifeUI.oVG, 0);
    }

    static /* synthetic */ void b(BaseLifeUI baseLifeUI, String str) {
        if (!bi.oN(str)) {
            if (baseLifeUI.oVG == null || !str.equals(baseLifeUI.oVG.oVk)) {
                baseLifeUI.ul(8);
                if (baseLifeUI.oVG != null) {
                    as.CN().c(baseLifeUI.oVG);
                }
                if (baseLifeUI.oVJ != null) {
                    baseLifeUI.oVB.bfI();
                    baseLifeUI.oVB.Hf(str);
                    baseLifeUI.hc(false);
                    baseLifeUI.ocb.cqf();
                }
            }
        }
    }

    static /* synthetic */ boolean d(float f, float f2, float f3, float f4) {
        return r.d((double) f, (double) f2, (double) f3, (double) f4) > 1000.0d;
    }

    public void bfN() {
        x.d("MicroMsg.BaseLifeUI", "init header");
        this.oVC = View.inflate(this, R.i.dfr, null);
        this.oVD = (TextView) this.oVC.findViewById(R.h.cTl);
        this.oVE = (TextView) this.oVC.findViewById(R.h.cTk);
        this.oVC.setOnClickListener(this.oVW);
        this.oVy = View.inflate(this, R.i.dpB, null);
        this.ocb.addFooterView(this.oVy);
        this.oVy.setVisibility(8);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.ocI = (int) (System.currentTimeMillis() / 1000);
        com.tencent.mm.plugin.nearlife.b.c.clear();
        as.CN().a(603, (e) this);
        this.sceneType = getIntent().getIntExtra("near_life_scene", 0);
        this.hMN = getIntent().getStringExtra("request_id");
        this.oVI = new ArrayList();
        initView();
        this.ocb.cqf();
        if (this.oVF != null) {
            this.oVF.b(this.oVX);
        }
        this.hpb = false;
    }

    public final void initView() {
        this.ocb = (MMLoadMoreListView) findViewById(R.h.cyP);
        MMLoadMoreListView mMLoadMoreListView = this.ocb;
        mMLoadMoreListView.ykE.setText(getString(R.l.exj));
        this.oVz = (NearLifeErrorContent) findViewById(R.h.cyO);
        bfN();
        this.oVA = bfL();
        this.oVB = bfM();
        this.ocb.setAdapter(this.oVA);
        this.oVz.ipH = this.ocb;
        this.oVA.notifyDataSetChanged();
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                BaseLifeUI.this.a(-1, false, "");
                BaseLifeUI.this.finish();
                return true;
            }
        });
        AnonymousClass4 anonymousClass4 = new OnClickListener() {
            public final void onClick(View view) {
                BackwardSupportUtil.c.a(BaseLifeUI.this.ocb);
            }
        };
        this.liK = new p(true, true);
        this.liK.zvw = new b() {
            public final void XC() {
                x.d("MicroMsg.BaseLifeUI", "click clear");
                if (BaseLifeUI.this.oVG != null) {
                    as.CN().c(BaseLifeUI.this.oVG);
                    BaseLifeUI.this.oVG = null;
                }
                BaseLifeUI.this.oVB.bfI();
                BaseLifeUI.this.ul(8);
            }

            public final void XD() {
            }

            public final void pd(String str) {
                x.d("MicroMsg.BaseLifeUI", "onSearchBarChange  %s", str);
                if (bi.oN(str)) {
                    XC();
                } else {
                    BaseLifeUI.a(BaseLifeUI.this, str);
                }
            }

            public final void XA() {
                x.d("MicroMsg.BaseLifeUI", "search helper onQuitSearch");
                BaseLifeUI.this.odb = false;
                BaseLifeUI.this.ocb.setAdapter(BaseLifeUI.this.oVA);
                BaseLifeUI.this.oVA.notifyDataSetChanged();
                BaseLifeUI.this.oVz.um(BaseLifeUI.this.oVA.oVx);
                if (!(BaseLifeUI.this.oVA.bfK() || BaseLifeUI.this.oVy == null)) {
                    BaseLifeUI.this.oVy.setVisibility(0);
                }
                BaseLifeUI.this.ocb.setOnTouchListener(null);
                BaseLifeUI.this.ul(8);
                BaseLifeUI.a(BaseLifeUI.this, BaseLifeUI.this.oVA);
            }

            public final void XB() {
                x.d("MicroMsg.BaseLifeUI", "search helper onEnterSearch");
                BaseLifeUI.this.oVS = true;
                BaseLifeUI.this.liK.setHint(BaseLifeUI.this.getString(R.l.exi));
                BaseLifeUI.this.odb = true;
                BaseLifeUI.this.oVB.bfI();
                BaseLifeUI.this.ocb.setAdapter(BaseLifeUI.this.oVB);
                BaseLifeUI.this.oVB.notifyDataSetChanged();
                BaseLifeUI.this.ocb.cqe();
                BaseLifeUI.this.oVz.um(BaseLifeUI.this.oVB.oVx);
                if (BaseLifeUI.this.oVy != null) {
                    BaseLifeUI.this.oVy.setVisibility(8);
                }
                BaseLifeUI.this.ocb.setOnTouchListener(new OnTouchListener() {
                    public final boolean onTouch(View view, MotionEvent motionEvent) {
                        BaseLifeUI.this.aWY();
                        return false;
                    }
                });
                BaseLifeUI.a(BaseLifeUI.this, BaseLifeUI.this.oVB);
            }

            public final boolean pc(String str) {
                x.d("MicroMsg.BaseLifeUI", "search key click");
                BaseLifeUI.b(BaseLifeUI.this, str);
                return false;
            }
        };
        this.ocb.ykC = new MMLoadMoreListView.a() {
            public final void ayD() {
                BaseLifeUI.a(BaseLifeUI.this);
            }
        };
        this.ocb.cqd();
    }

    protected void onResume() {
        super.onResume();
        this.oVA.notifyDataSetChanged();
        this.oVF.a(this.oVX, true);
    }

    protected void onDestroy() {
        as.CN().b(603, (e) this);
        super.onDestroy();
        if (this.oVF != null) {
            this.oVF.c(this.oVX);
        }
    }

    protected void onPause() {
        super.onPause();
        this.oVF.c(this.oVX);
    }

    protected int getLayoutId() {
        return R.i.doN;
    }

    private boolean hc(boolean z) {
        while (this.oVG == null) {
            if (this.oVI.size() - 1 <= this.oVH) {
                this.oVH = -1;
                x.i("MicroMsg.BaseLifeUI", "index inc to end, ret");
                return false;
            }
            int b;
            this.oVH++;
            aot aot = (aot) this.oVI.get(this.oVH);
            if (this.oVH == 0) {
                this.oVR++;
            }
            if (this.odb) {
                b = this.oVB.b(new LatLongData(aot.vXy, aot.vXx));
                continue;
            } else {
                b = this.oVA.b(new LatLongData(aot.vXy, aot.vXx));
                continue;
            }
            if (b > 0) {
                bes a;
                if (this.odb) {
                    a = this.oVB.a(new LatLongData(aot.vXy, aot.vXx));
                } else {
                    a = this.oVA.a(new LatLongData(aot.vXy, aot.vXx));
                }
                int i = this.odb ? 1 : 0;
                if (com.tencent.mm.plugin.nearlife.b.c.ui(i)) {
                    if (-1 == this.oVO) {
                        this.oVO = System.currentTimeMillis();
                    }
                    this.oVG = new com.tencent.mm.plugin.nearlife.b.c(i, this.sceneType, aot.vXx, aot.vXy, aot.wjv, aot.wjy, aot.wjw, aot.wjx, a, this.odb ? this.oVB.bfJ() : "", this.ocI, z);
                    as.CN().a(this.oVG, 0);
                    x.i("MicroMsg.BaseLifeUI", "start get lbs life list, index:%d, lat:%f, long:%f", Integer.valueOf(this.oVH), Float.valueOf(aot.vXy), Float.valueOf(aot.vXx));
                    return true;
                }
                this.oVH = -1;
                return false;
            }
        }
        x.d("MicroMsg.BaseLifeUI", "scene is doing...");
        return false;
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (kVar.getType() == 603) {
            this.ocb.cqe();
            com.tencent.mm.plugin.nearlife.b.c cVar = (com.tencent.mm.plugin.nearlife.b.c) kVar;
            if (!bi.oN(cVar.oVl)) {
                this.oVl = cVar.oVl;
                LogoImageView logoImageView = (LogoImageView) this.oVy.findViewById(R.h.cEs);
                String str2 = this.oVl;
                as.Hm();
                logoImageView.imagePath = com.tencent.mm.y.c.Fq();
                logoImageView.url = str2;
                logoImageView.nZY = 0;
                logoImageView.mBg = 0;
                Bitmap decodeFile;
                if (str2 == null || str2.length() == 0) {
                    logoImageView.setVisibility(8);
                } else if (str2.startsWith("http")) {
                    decodeFile = BitmapFactory.decodeFile(logoImageView.imagePath + com.tencent.mm.a.g.s(str2.getBytes()));
                    if (decodeFile != null) {
                        if (logoImageView.nZY > 0 && logoImageView.mBg > 0) {
                            decodeFile = d.a(decodeFile, logoImageView.nZY, logoImageView.mBg, true, false);
                        }
                        logoImageView.setImageBitmap(decodeFile);
                    } else {
                        com.tencent.mm.sdk.f.e.post(new a(str2, logoImageView.handler), "LogoImageView_download");
                    }
                } else if (com.tencent.mm.a.e.bO(str2)) {
                    decodeFile = (logoImageView.nZY <= 0 || logoImageView.mBg <= 0) ? d.Vs(str2) : d.d(str2, logoImageView.nZY, logoImageView.mBg, true);
                    if (decodeFile == null) {
                        logoImageView.setVisibility(8);
                    } else {
                        logoImageView.setImageBitmap(decodeFile);
                    }
                } else {
                    logoImageView.setVisibility(8);
                }
            }
            this.iVa = cVar.iVa;
            this.nWw = cVar.nWw;
            com.tencent.mm.plugin.nearlife.b.c.uj(((com.tencent.mm.plugin.nearlife.b.c) kVar).fvo);
            if (this.oVG == null) {
                x.d("MicroMsg.BaseLifeUI", "scene is null");
                return;
            }
            x.i("MicroMsg.BaseLifeUI", "onSceneEnd: index:%d, errType=%d, errCode=%d, errMsg=%s opcde %d ", Integer.valueOf(this.oVH), Integer.valueOf(i), Integer.valueOf(i2), str, Integer.valueOf(r1));
            boolean z = i2 == 0 || i2 == 101;
            a aVar;
            if (i == 0 || z) {
                if (-1 == this.oVP) {
                    this.oVP = System.currentTimeMillis();
                }
                this.oVQ = System.currentTimeMillis();
                List list = cVar.oVm;
                aot aot = (aot) this.oVI.get(this.oVH);
                LatLongData latLongData = new LatLongData(aot.vXy, aot.vXx);
                if (this.odb && !this.oVG.oVn) {
                    this.oVB.bfI();
                }
                if (this.odb) {
                    this.oVB.a(latLongData, cVar.bfH(), cVar.bfG());
                } else {
                    this.oVA.a(latLongData, cVar.bfH(), cVar.bfG());
                }
                if (list == null || list.size() == 0) {
                    aVar = this.odb ? this.oVB : this.oVA;
                    if (this.oVI.size() - 1 == this.oVH) {
                        if (aVar.getCount() == 0) {
                            this.oVz.um(aVar.oVx);
                        }
                        this.ocb.cqe();
                        if (!(aVar.bfK() || i2 == 101)) {
                            bfO();
                        }
                    }
                } else {
                    aVar = this.odb ? this.oVB : this.oVA;
                    z = this.oVG.oVn;
                    this.ocb.setVisibility(0);
                    aVar.oVx = 0;
                    this.oVz.um(this.oVB.oVx);
                    aVar.a(latLongData, list);
                    aVar.notifyDataSetChanged();
                    if (this.oVI.size() - 1 == this.oVH && !aVar.bfK()) {
                        this.ocb.cqe();
                        bfO();
                    }
                }
                if (!(this.oVA.bfK() || this.oVy == null || this.odb)) {
                    this.oVy.setVisibility(0);
                }
                if (this.oVy != null && !this.odb) {
                    this.oVy.setVisibility(0);
                } else if (this.oVy != null) {
                    this.oVy.setVisibility(8);
                }
            } else {
                x.d("MicroMsg.BaseLifeUI", "error");
                if (this.odb) {
                    aVar = this.oVB;
                } else {
                    aVar = this.oVA;
                }
                if (this.oVI.size() - 1 == this.oVH && aVar.getCount() == 0) {
                    aVar.oVx = 1;
                    this.oVz.um(aVar.oVx);
                }
            }
            this.oVG = null;
            hc(false);
        }
    }

    private void bfO() {
        if (this.odb) {
            int i;
            try {
                x.i("MicroMsg.BaseLifeUI", "getDynamicConfig createpoi %d", Integer.valueOf(Integer.valueOf(com.tencent.mm.j.g.Af().getValue("POICreateForbiden")).intValue()));
                if (Integer.valueOf(com.tencent.mm.j.g.Af().getValue("POICreateForbiden")).intValue() == 1) {
                    return;
                }
            } catch (Exception e) {
            }
            a aVar = this.oVB;
            String trim = this.oVB.bfJ().trim();
            Iterator it = aVar.oVp.iterator();
            while (it.hasNext()) {
                if (trim.equals(((com.tencent.mm.plugin.nearlife.b.a) it.next()).fpg.trim())) {
                    i = 1;
                    break;
                }
            }
            i = 0;
            if (i == 0) {
                this.oVD.setText(String.format(getResources().getString(R.l.eyi), new Object[]{this.oVB.bfJ()}));
                ul(0);
                return;
            }
            ul(8);
            return;
        }
        x.i("MicroMsg.BaseLifeUI", "is not Search mode pass createpoi");
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        x.d("MicroMsg.BaseLifeUI", "onActivityResult requestCode %d %d", Integer.valueOf(i), Integer.valueOf(i2));
        if (i2 == -1) {
            switch (i) {
                case 1:
                    setResult(-1, intent);
                    finish();
                    return;
                default:
                    return;
            }
        }
    }

    protected final void a(int i, boolean z, String str) {
        int i2;
        String str2;
        Object obj;
        if (str != null && str.startsWith("mm_")) {
            str = "";
        }
        String str3 = "";
        String str4 = "";
        if (i >= 0) {
            i2 = z ? 3 : 1;
            if (this.oVU) {
                g gVar = g.pWK;
                Object[] objArr = new Object[1];
                objArr[0] = Integer.valueOf(z ? 5 : 4);
                gVar.h(11139, objArr);
            }
            if (z) {
                str2 = this.oVB.uk(i).odq;
                if (this.oVB.getCount() > 0) {
                    str3 = this.oVB.uk(1).hMN;
                    obj = str2;
                }
                str3 = str4;
                str4 = str2;
            } else {
                str2 = this.oVA.uk(i).odq;
                if (this.oVA.getCount() > 0) {
                    str3 = this.oVA.uk(1).hMN;
                    str4 = str2;
                }
                str3 = str4;
                str4 = str2;
            }
            if (bi.oN(str3)) {
                str3 = this.hMN;
            }
        } else {
            i2 = this.oVS ? 4 : 2;
            String str5 = str4;
            str4 = str3;
            str3 = str5;
        }
        if (this.oVJ == null) {
            str2 = "null/null";
        } else {
            str2 = String.format("%f/%f", new Object[]{Float.valueOf(this.oVJ.vXy), Float.valueOf(this.oVJ.vXx)});
        }
        x.d("MicroMsg.BaseLifeUI", "index: %s, bid: %s, index: %s, searchId: %s, requestId: %s", Integer.valueOf(i + 1), str, Integer.valueOf(i), obj, str3);
        g.pWK.h(11135, Integer.valueOf(i2), Integer.valueOf(i + 1), Long.valueOf(this.oVO), Long.valueOf(this.oVQ), Long.valueOf(System.currentTimeMillis()), Long.valueOf(this.oVP), Integer.valueOf(this.oVR), str2, str, Integer.valueOf(this.ocI), obj, q.yL(), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0), str3);
    }

    private void ul(int i) {
        this.ocb.removeFooterView(this.oVy);
        this.ocb.removeFooterView(this.oVC);
        MMLoadMoreListView mMLoadMoreListView = this.ocb;
        mMLoadMoreListView.removeFooterView(mMLoadMoreListView.lHm);
        this.oVC.setVisibility(i);
        this.oVD.setVisibility(i);
        this.oVE.setVisibility(i);
        if (i == 0) {
            this.ocb.addFooterView(this.oVC);
            return;
        }
        mMLoadMoreListView = this.ocb;
        if (mMLoadMoreListView.lHm == null) {
            mMLoadMoreListView.cqc();
        }
        try {
            mMLoadMoreListView.removeFooterView(mMLoadMoreListView.lHm);
            mMLoadMoreListView.addFooterView(mMLoadMoreListView.lHm);
        } catch (Exception e) {
        }
        this.ocb.addFooterView(this.oVy);
    }
}
