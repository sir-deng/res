package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.bl.d;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelgeo.Addr;
import com.tencent.mm.modelgeo.c;
import com.tencent.mm.modelstat.e;
import com.tencent.mm.modelstat.o;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.i;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.pluginsdk.r;
import com.tencent.mm.protocal.c.aos;
import com.tencent.mm.protocal.c.apl;
import com.tencent.mm.protocal.c.bet;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import java.util.ArrayList;
import java.util.Iterator;

public class LocationWidget extends LinearLayout {
    float biF;
    private int fXe;
    private String fXl;
    private String hMN;
    private boolean hzA;
    private float hzq;
    private float hzr;
    private Activity iTL;
    private com.tencent.mm.modelgeo.b.a nWl;
    private String nYL;
    private c oVF;
    float oVL;
    private com.tencent.mm.modelgeo.a.a oVX;
    private aos oWm;
    private com.tencent.mm.modelgeo.b obF;
    private View rAa;
    private View rAb;
    private int[] rAc;
    private ImageView[] rAd;
    private int rAe;
    private TextView rAf;
    private byte[] rAg;
    private String rAh;
    private String rAi;
    private int rAj;
    float rAk;
    int rAl;
    a rAm;
    private boolean rAn;
    private b rAo;
    private ImageView rxm;
    private TextView ryo;
    private int score;

    class b {
        String iVa = "";
        int index;
        long oVO = -1;
        long oVP = -1;
        long oVQ = -1;
        int oVR = 0;
        int ocI = 0;

        b() {
        }
    }

    public interface a {
        ArrayList<com.tencent.mm.compatible.util.Exif.a> bAm();

        boolean bAn();
    }

    public LocationWidget(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.rAc = new int[]{f.qJp, f.qJq, f.qJr, f.qJs, f.qJt};
        this.rAd = new ImageView[5];
        this.hzq = -1000.0f;
        this.hzr = -1000.0f;
        this.rAj = 0;
        this.oWm = null;
        this.fXe = 0;
        this.rAk = 0.0f;
        this.oVL = 0.0f;
        this.biF = 0.0f;
        this.rAl = -1;
        this.hzA = true;
        this.oVF = c.OV();
        this.rAm = null;
        this.rAn = false;
        this.nWl = new com.tencent.mm.modelgeo.b.a() {
            public final void b(Addr addr) {
                x.i("MicroMsg.LocationWidget", "get info %s", addr.toString());
                if (LocationWidget.this.rAn) {
                    LocationWidget.this.bAh();
                    if (bi.oN(LocationWidget.this.fXl)) {
                        LocationWidget.this.fXl = addr.hzh;
                        LocationWidget.this.bAh();
                    }
                }
            }
        };
        this.oVX = new com.tencent.mm.modelgeo.a.a() {
            public final boolean a(boolean z, float f, float f2, int i, double d, double d2, double d3) {
                if (!z) {
                    return true;
                }
                x.d("MicroMsg.LocationWidget", "get location %f %f", Float.valueOf(f2), Float.valueOf(f));
                e.SZ().a(2003, i != 0, LocationWidget.this.oVF == null ? false : LocationWidget.this.oVF.hzA, f, f2, (int) d2);
                o.a(2003, f, f2, 0);
                if (!LocationWidget.this.rAn) {
                    return false;
                }
                if (LocationWidget.this.hzq == -1000.0f || LocationWidget.this.hzr == -1000.0f) {
                    LocationWidget.this.hzq = f2;
                    LocationWidget.this.hzr = f;
                }
                return false;
            }
        };
        this.rAo = null;
        f((MMActivity) context);
    }

    public LocationWidget(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.rAc = new int[]{f.qJp, f.qJq, f.qJr, f.qJs, f.qJt};
        this.rAd = new ImageView[5];
        this.hzq = -1000.0f;
        this.hzr = -1000.0f;
        this.rAj = 0;
        this.oWm = null;
        this.fXe = 0;
        this.rAk = 0.0f;
        this.oVL = 0.0f;
        this.biF = 0.0f;
        this.rAl = -1;
        this.hzA = true;
        this.oVF = c.OV();
        this.rAm = null;
        this.rAn = false;
        this.nWl = /* anonymous class already generated */;
        this.oVX = /* anonymous class already generated */;
        this.rAo = null;
        f((MMActivity) context);
    }

    private void f(MMActivity mMActivity) {
        this.iTL = mMActivity;
        View inflate = View.inflate(mMActivity, getLayoutResource(), this);
        this.rAa = inflate.findViewById(f.qIO);
        this.rAf = (TextView) this.rAa.findViewById(f.cuj);
        this.ryo = (TextView) this.rAa.findViewById(f.qIQ);
        this.rxm = (ImageView) this.rAa.findViewById(f.qIP);
        this.rAb = inflate.findViewById(f.qJo);
        for (int i = 0; i < 5; i++) {
            this.rAd[i] = (ImageView) this.rAb.findViewById(this.rAc[i]);
            this.rAd[i].setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    if (LocationWidget.this.score == i + 1) {
                        LocationWidget.this.score = LocationWidget.this.score - 1;
                    } else {
                        LocationWidget.this.score = i + 1;
                    }
                    LocationWidget.this.bAf();
                }
            });
        }
        this.obF = com.tencent.mm.modelgeo.b.OT();
        this.rAa.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                x.i("MicroMsg.LocationWidget", "summerper checkPermission checkLocation[%b]", Boolean.valueOf(com.tencent.mm.pluginsdk.g.a.a(LocationWidget.this.iTL, "android.permission.ACCESS_COARSE_LOCATION", 64, "", "")));
                if (com.tencent.mm.pluginsdk.g.a.a(LocationWidget.this.iTL, "android.permission.ACCESS_COARSE_LOCATION", 64, "", "")) {
                    LocationWidget.this.bAg();
                }
            }
        });
        this.rAi = mMActivity.getIntent().getStringExtra("kpoi_id");
        if (!bi.oN(this.rAi)) {
            this.hzq = mMActivity.getIntent().getFloatExtra("k_lat", -1000.0f);
            this.hzr = mMActivity.getIntent().getFloatExtra("k_lng", -1000.0f);
            this.nYL = mMActivity.getIntent().getStringExtra("kpoi_name");
            this.rAh = mMActivity.getIntent().getStringExtra("Kpoi_address");
            bAh();
        }
        if (g.Do().CF()) {
            this.rAe = bi.getInt(com.tencent.mm.j.g.Af().getValue("SnsPostPOICommentSwitch"), 0);
        } else {
            this.rAe = 0;
        }
        bAf();
    }

    private void bAf() {
        int i = 0;
        x.i("MicroMsg.LocationWidget", "updateScoreItem scoreSwtich:%d, classifyId:%s, poiClassifyType:%d, showFlag:%d, isOverSea:%b", Integer.valueOf(this.rAe), this.rAi, Integer.valueOf(this.rAj), Integer.valueOf(this.fXe), Boolean.valueOf(bi.chj()));
        if (bi.chj() || this.rAe == 0 || bi.oN(this.rAi) || this.rAj == 1 || (this.fXe & 1) == 0) {
            this.rAb.setVisibility(8);
            return;
        }
        this.rAb.setVisibility(0);
        while (i < this.score) {
            this.rAd[i].setImageResource(i.qPq);
            i++;
        }
        for (i = this.score; i < 5; i++) {
            this.rAd[i].setImageResource(i.qPp);
        }
    }

    public final void bAg() {
        Intent intent = new Intent();
        intent.putExtra("near_life_scene", 1);
        try {
            intent.putExtra("get_poi_item_buf", this.oWm.toByteArray());
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.LocationWidget", e, "", new Object[0]);
        }
        if (!bi.oN(this.rAi)) {
            intent.putExtra("get_poi_classify_id", this.rAi);
        } else if (!bi.oN(this.fXl)) {
            intent.putExtra("get_city", this.fXl);
        }
        intent.putExtra("get_lat", this.hzq);
        intent.putExtra("get_lng", this.hzr);
        intent.putExtra("request_id", this.hMN);
        if (this.rAm != null) {
            ArrayList bAm = this.rAm.bAm();
            if (bAm != null) {
                O(bAm);
                ArrayList arrayList = new ArrayList();
                Iterator it = bAm.iterator();
                while (it.hasNext()) {
                    com.tencent.mm.compatible.util.Exif.a aVar = (com.tencent.mm.compatible.util.Exif.a) it.next();
                    arrayList.add(String.format("%f\n%f", new Object[]{Double.valueOf(aVar.latitude), Double.valueOf(aVar.longitude)}));
                }
            }
        }
        d.b(getContext(), "nearlife", "com.tencent.mm.plugin.nearlife.ui.CheckInLifeUI", intent, 10);
    }

    private void O(ArrayList<com.tencent.mm.compatible.util.Exif.a> arrayList) {
        if (arrayList != null && arrayList.size() != 0) {
            com.tencent.mm.compatible.util.Exif.a aVar;
            com.tencent.mm.plugin.report.service.g.pWK.k(11139, "1");
            if (((double) Math.abs(-1000.0f - this.hzq)) > 1.0E-6d && ((double) Math.abs(-1000.0f - this.hzr)) > 1.0E-6d) {
                aVar = (com.tencent.mm.compatible.util.Exif.a) arrayList.get(arrayList.size() - 1);
                if (c(aVar.latitude, aVar.longitude, (double) this.hzq, (double) this.hzr)) {
                    com.tencent.mm.plugin.report.service.g.pWK.k(11139, "2");
                }
            }
            int i = 0;
            while (i < arrayList.size()) {
                Object obj;
                int i2 = i + 1;
                while (true) {
                    int i3 = i2;
                    if (i3 >= arrayList.size()) {
                        i2 = 1;
                        break;
                    }
                    aVar = (com.tencent.mm.compatible.util.Exif.a) arrayList.get(i);
                    com.tencent.mm.compatible.util.Exif.a aVar2 = (com.tencent.mm.compatible.util.Exif.a) arrayList.get(i3);
                    if (c(aVar.latitude, aVar.longitude, aVar2.latitude, aVar2.longitude)) {
                        com.tencent.mm.plugin.report.service.g.pWK.k(11139, TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL);
                        obj = null;
                        break;
                    }
                    i2 = i3 + 1;
                }
                if (obj != null) {
                    i++;
                } else {
                    return;
                }
            }
        }
    }

    private static boolean c(double d, double d2, double d3, double d4) {
        return r.d(d, d2, d3, d4) > 1000.0d;
    }

    public final void stop() {
        if (this.oVF != null) {
            this.oVF.c(this.oVX);
        }
        if (this.obF != null) {
            this.obF.a(this.nWl);
        }
    }

    public final boolean U(Intent intent) {
        if (intent != null) {
            this.rAj = intent.getIntExtra("get_poi_classify_type", 0);
            this.fXe = intent.getIntExtra("get_poi_showflag", 0);
            x.d("MicroMsg.LocationWidget", "onactivity result ok poiClassifyType %d", Integer.valueOf(this.rAj));
            this.nYL = bi.aD(intent.getStringExtra("get_poi_name"), "");
            this.fXl = bi.aD(intent.getStringExtra("get_city"), "");
            this.hzq = intent.getFloatExtra("get_lat", -1000.0f);
            this.hzr = intent.getFloatExtra("get_lng", -1000.0f);
            x.i("MicroMsg.LocationWidget", "check cur lat " + this.rAk + " " + this.oVL);
            this.rAk = intent.getFloatExtra("get_cur_lat", 0.0f);
            this.oVL = intent.getFloatExtra("get_cur_lng", 0.0f);
            this.rAl = intent.getIntExtra("get_loctype", -1);
            this.biF = intent.getFloatExtra("get_accuracy", 0.0f);
            this.hzA = intent.getBooleanExtra("get_is_mars", true);
            this.hMN = intent.getStringExtra("request_id");
            e.SZ().a(2003, this.rAl != 0, this.hzA, this.hzr, this.hzq, (int) this.biF);
            this.rAg = intent.getByteArrayExtra("location_ctx");
            if (!bi.oN(this.nYL)) {
                this.rAh = bi.aD(intent.getStringExtra("get_poi_address"), "");
                this.rAi = bi.aD(intent.getStringExtra("get_poi_classify_id"), "");
                this.oWm = new aos();
                try {
                    this.oWm = (aos) this.oWm.aH(intent.getByteArrayExtra("get_poi_item_buf"));
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.LocationWidget", e, "", new Object[0]);
                    this.oWm = null;
                }
                if (!bi.oN(this.rAi)) {
                    this.oWm = new aos();
                    this.oWm.oUX = this.rAi;
                    this.oWm.kzz = this.rAj;
                    this.oWm.fpg = this.nYL;
                    this.oWm.oVc.add(new bet().Vf(this.rAh));
                }
            } else if (bi.oN(this.fXl)) {
                this.hzq = -1000.0f;
                this.hzr = -1000.0f;
                this.nYL = "";
                this.rAh = "";
                this.fXl = "";
                this.rAi = "";
                this.oWm = null;
            } else {
                this.nYL = "";
                this.rAh = "";
                this.rAi = "";
                this.oWm = null;
            }
            x.d("MicroMsg.LocationWidget", "label %s poiname %s", this.rAh, this.nYL);
            bAh();
            bAf();
            this.rAo = new b();
            b bVar = this.rAo;
            if (intent != null) {
                bVar.index = intent.getIntExtra("report_index", -1);
                bVar.oVO = intent.getLongExtra("first_start_time", 0);
                bVar.oVP = intent.getLongExtra("lastSuccStamp", 0);
                bVar.oVQ = intent.getLongExtra("firstSuccStamp", 0);
                bVar.oVR = intent.getIntExtra("reqLoadCnt", 0);
                bVar.ocI = intent.getIntExtra("entry_time", 0);
                bVar.iVa = intent.getStringExtra("search_id");
            }
        }
        return true;
    }

    private void bAh() {
        if (!(this.rAf == null || this.ryo == null)) {
            if (!bi.oN(this.nYL)) {
                this.rAf.setText(this.nYL);
                this.ryo.setVisibility(8);
            } else if (bi.oN(this.fXl)) {
                this.rAf.setText(j.qRD);
                this.ryo.setVisibility(8);
            } else {
                this.rAf.setText(this.fXl);
                this.ryo.setVisibility(8);
            }
        }
        if (bi.oN(this.nYL) && bi.oN(this.fXl)) {
            this.rxm.setImageResource(bAi());
        } else {
            this.rxm.setImageResource(bAj());
        }
    }

    protected int bAi() {
        return i.qPj;
    }

    protected int bAj() {
        return i.qPk;
    }

    public final apl bAk() {
        apl apl = new apl();
        apl.vXy = this.hzq;
        apl.vXx = this.hzr;
        apl.wCV = 0;
        apl.score = this.score;
        if (this.rAg != null) {
            apl.wCW = new com.tencent.mm.bp.b(this.rAg);
        }
        if (!bi.oN(this.nYL)) {
            apl.rAh = this.rAh;
            apl.nYL = this.nYL;
            apl.wCS = this.rAi;
            apl.hxg = this.fXl;
            if (this.rAj == 0 || this.rAj != 1) {
                apl.rAj = 1;
            } else {
                apl.rAj = 2;
            }
            x.d("MicroMsg.LocationWidget", "getlocation type %d", Integer.valueOf(apl.rAj));
        } else if (!bi.oN(this.fXl)) {
            apl.hxg = this.fXl;
        }
        if (this.rAo != null) {
            String format = String.format("%f/%f", new Object[]{Float.valueOf(apl.vXy), Float.valueOf(apl.vXx)});
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("index " + this.rAo.index);
            stringBuffer.append("firstStartStamp " + this.rAo.oVO);
            stringBuffer.append("lastSuccStamp " + this.rAo.oVQ);
            stringBuffer.append("firstSuccStamp " + this.rAo.oVP);
            stringBuffer.append("reqLoadCnt " + this.rAo.oVR);
            stringBuffer.append("classifyId " + this.rAi);
            stringBuffer.append("entryTime " + this.rAo.ocI);
            stringBuffer.append("searchId" + this.rAo.iVa);
            x.d("MicroMsg.LocationWidget", "report %s", stringBuffer.toString());
            com.tencent.mm.plugin.report.service.g.pWK.h(11135, Integer.valueOf(5), Integer.valueOf(this.rAo.index + 1), Long.valueOf(this.rAo.oVO), Long.valueOf(this.rAo.oVQ), Long.valueOf(System.currentTimeMillis()), Long.valueOf(this.rAo.oVP), Integer.valueOf(this.rAo.oVR), format, this.rAi, Integer.valueOf(this.rAo.ocI), this.rAo.iVa, q.yL());
        }
        bAl();
        return apl;
    }

    private void bAl() {
        if (this.rAm != null) {
            boolean bAn = this.rAm.bAn();
            ArrayList bAm = this.rAm.bAm();
            if (bAm != null && bAm.size() != 0) {
                Iterator it = bAm.iterator();
                while (it.hasNext()) {
                    int i;
                    com.tencent.mm.compatible.util.Exif.a aVar = (com.tencent.mm.compatible.util.Exif.a) it.next();
                    x.d("MicroMsg.LocationWidget", "snsreport lat lng %f, %f", Double.valueOf(aVar.latitude), Double.valueOf(aVar.longitude));
                    com.tencent.mm.plugin.report.service.g gVar = com.tencent.mm.plugin.report.service.g.pWK;
                    Object[] objArr = new Object[4];
                    objArr[0] = Integer.valueOf((int) (aVar.latitude * 1000000.0d));
                    objArr[1] = Integer.valueOf((int) (aVar.longitude * 1000000.0d));
                    if (bAn) {
                        i = 1;
                    } else {
                        i = 2;
                    }
                    objArr[2] = Integer.valueOf(i);
                    objArr[3] = Integer.valueOf(2);
                    gVar.h(11345, objArr);
                }
            }
        }
    }

    protected int getLayoutResource() {
        return com.tencent.mm.plugin.sns.i.g.qIR;
    }
}
