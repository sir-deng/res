package com.tencent.mm.plugin.location.ui.impl;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import com.tencent.mm.R;
import com.tencent.mm.ad.e;
import com.tencent.mm.modelgeo.c;
import com.tencent.mm.plugin.location.model.LocationInfo;
import com.tencent.mm.plugin.location.model.d;
import com.tencent.mm.plugin.location.model.f;
import com.tencent.mm.plugin.location.model.o;
import com.tencent.mm.plugin.location.model.o.b;
import com.tencent.mm.plugin.location.ui.MyLocationButton;
import com.tencent.mm.plugin.location.ui.ShareHeader;
import com.tencent.mm.plugin.location.ui.TipSayingWidget;
import com.tencent.mm.plugin.location.ui.VolumeMeter;
import com.tencent.mm.plugin.location.ui.k;
import com.tencent.mm.plugin.location.ui.l;
import com.tencent.mm.plugin.location.ui.l.a;
import com.tencent.mm.plugin.location.ui.m;
import com.tencent.mm.plugin.location.ui.n;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.anl;
import com.tencent.mm.protocal.c.ayo;
import com.tencent.mm.protocal.c.bcu;
import com.tencent.mm.protocal.c.bpq;
import com.tencent.mm.protocal.c.bte;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.i;
import com.tencent.mm.y.as;
import com.tencent.mm.y.q;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class g extends i implements a {
    private com.tencent.mm.modelgeo.a.a gAn = new com.tencent.mm.modelgeo.a.a() {
        public final boolean a(boolean z, float f, float f2, int i, double d, double d2, double d3) {
            if (!z) {
                return false;
            }
            x.d("MicroMsg.ShareMapUI", "onGetLocation, latitude=%f, longtitude=%f, speed=%f", Float.valueOf(f2), Float.valueOf(f), Double.valueOf(d));
            if (f.m(d) && !g.this.odv.oaI) {
                x.d("MicroMsg.ShareMapUI", "set driving mode");
                g.this.odv.oaL = false;
                g.this.odv.gt(true);
                g.this.odt.aWu();
            }
            return true;
        }
    };
    private View nZw;
    private m.a oaS = new m.a() {
    };
    private c odA = c.OV();
    private ShareHeader odB;
    private String odC;
    private long odD = 0;
    private long odE = 0;
    private b odF = new b() {
        public final void aWn() {
            x.i("MicroMsg.ShareMapUI", "onJoinSucess");
            o oVar = g.this.odw;
            oVar.nXv = true;
            oVar.aWj();
            oVar.aWk();
            g.this.odv.gu(true);
            if (g.this.ody != null) {
                g.this.ody.aWD();
            }
        }

        public final void a(bcu bcu) {
            g.a(g.this, bcu);
        }

        public final void onError(int i, String str) {
            x.v("MicroMsg.ShareMapUI", "onError type %d msg %s", Integer.valueOf(i), str);
            com.tencent.mm.plugin.report.service.g.pWK.h(10997, "7", "", Integer.valueOf(0), Integer.valueOf(0));
            l lVar = g.this.odx;
            x.d("MicroMsg.TrackPoiDialogMgr", "showErrorDialog, errMsg=%s", str);
            Context context = ad.getContext();
            String str2 = null;
            if (!bi.oN(str)) {
                str2 = str;
            } else if (i == 0) {
                str2 = context.getString(R.l.eto);
            } else if (i == 1) {
                str2 = context.getString(R.l.etp);
            } else if (i == 2) {
                str2 = context.getString(R.l.etq);
            }
            h.a(lVar.mContext, str2, "", lVar.mResources.getString(R.l.dGf), false, new com.tencent.mm.plugin.location.ui.l.AnonymousClass8(i));
        }

        public final void aWo() {
            g.this.odv.gu(false);
            g.this.odw.stop();
            g.this.odw.se(3);
            k.aWG();
            g.this.activity.finish();
            g.this.activity.overridePendingTransition(R.a.bqn, R.a.bqp);
        }
    };
    private o.a odG = new o.a() {
        public final void aWm() {
            g gVar = g.this;
            i.a aVar = new i.a(gVar.activity);
            aVar.ET(R.l.eRM);
            aVar.EV(R.l.dGf).a(new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    g.this.odv.gu(false);
                    g.this.odw.stop();
                    g.this.odw.se(2);
                    k.aWG();
                    g.this.activity.finish();
                }
            });
            aVar.ale().show();
        }
    };
    private HashMap<String, bte> odH = new HashMap();
    private Button ods;
    MyLocationButton odt;
    private TipSayingWidget odu;
    m odv;
    o odw = com.tencent.mm.plugin.location.model.l.aWa();
    l odx;
    k ody;
    private com.tencent.mm.plugin.location.ui.i odz;
    private WakeLock wakeLock;

    static /* synthetic */ void a(g gVar, bcu bcu) {
        com.tencent.mm.plugin.location.a.a aVar;
        bte bte;
        x.d("MicroMsg.ShareMapUI", "refreshSuccess, timeout = %b", Boolean.valueOf(gVar.odw.fid));
        List<bte> list = bcu.wPB;
        List<bte> linkedList = new LinkedList();
        com.tencent.mm.plugin.location.a.a Eh = com.tencent.mm.plugin.location.model.l.aWb().Eh(gVar.nXy);
        if (Eh == null) {
            Eh = new com.tencent.mm.plugin.location.a.a();
            Eh.latitude = -1000.0d;
            Eh.longitude = -1000.0d;
            aVar = Eh;
        } else {
            aVar = Eh;
        }
        LinkedList linkedList2 = new LinkedList();
        for (bte bte2 : list) {
            linkedList2.add(bte2.vPp);
        }
        if (!linkedList2.contains(q.FY())) {
            linkedList2.add(q.FY());
        }
        com.tencent.mm.plugin.location.model.l.aWb().a(gVar.nXy, linkedList2, aVar.latitude, aVar.longitude, aVar.nWa, "", "");
        for (bte bte22 : list) {
            if (Math.abs(bte22.xbj.vUF) > 180.0d || Math.abs(bte22.xbj.vUG) > 90.0d) {
                bte bte3 = (bte) gVar.odH.get(bte22.vPp);
                if (bte3 != null) {
                    linkedList.add(bte3);
                    x.i("MicroMsg.ShareMapUI", "error from server get latlng %s %f %f and use old one %f %f", bte22.vPp, Double.valueOf(bte22.xbj.vUG), Double.valueOf(bte22.xbj.vUF), Double.valueOf(bte3.xbj.vUG), Double.valueOf(bte3.xbj.vUF));
                } else {
                    x.i("MicroMsg.ShareMapUI", "error from server get latlng %s %f %f cannot user old one", bte22.vPp, Double.valueOf(bte22.xbj.vUG), Double.valueOf(bte22.xbj.vUF));
                }
            } else {
                linkedList.add(bte22);
            }
        }
        gVar.odH.clear();
        for (bte bte222 : linkedList) {
            gVar.odH.put(bte222.vPp, bte222);
        }
        int size = linkedList.size();
        ArrayList arrayList = new ArrayList();
        arrayList.add(q.FY());
        if (size >= 0) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("refreshSuccess, count =  " + size);
            size = 0;
            while (true) {
                int i = size;
                if (i >= linkedList.size()) {
                    break;
                }
                bte222 = (bte) linkedList.get(i);
                stringBuilder.append("[" + bte222.vPp + " ] ");
                stringBuilder.append(bte222.xbj.wMf + " ");
                stringBuilder.append(bte222.xbj.vUG + " ");
                stringBuilder.append(bte222.xbj.vUF + " ");
                arrayList.add(bte222.vPp);
                size = i + 1;
            }
            x.v("MicroMsg.ShareMapUI", "refreshSuccess TrackRoom num: " + stringBuilder.toString());
            if (gVar.odv != null) {
                gVar.odv.bd(linkedList);
            }
        }
        if (gVar.odv.oaH) {
            m mVar = gVar.odv;
            bpq bpq = bcu.wPC;
            if (mVar.oaK == null) {
                mVar.oaK = new bpq();
            }
            if (bpq != null) {
                x.d("MicroMsg.TrackPointViewMgrImpl", "set trackitem  " + bpq.vUG + " " + bpq.vUF);
                mVar.oaK.wKq = bpq.wKq;
                mVar.oaK.vUG = bpq.vUG;
                mVar.oaK.vUF = bpq.vUF;
            }
        }
        gVar.odz.F(arrayList);
    }

    public final boolean aWZ() {
        return true;
    }

    public g(Activity activity) {
        super(activity);
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        x.i("MicroMsg.ShareMapUI", "onCreate");
        this.odD = System.currentTimeMillis();
    }

    final void aWX() {
        super.aWX();
        this.wakeLock = ((PowerManager) this.activity.getSystemService("power")).newWakeLock(26, "Track Lock");
        if (this.oef != null) {
            n nVar = this.oef;
            nVar.obq.setVisibility(4);
            nVar.isVisible = false;
        }
        findViewById(R.h.coq).setVisibility(8);
        this.odt = (MyLocationButton) findViewById(R.h.ctQ);
        MyLocationButton myLocationButton = this.odt;
        myLocationButton.nYs = this.obC.nYK;
        myLocationButton.nYr.setVisibility(0);
        myLocationButton.nYq.setVisibility(8);
        c.OV().b(myLocationButton.gAn, true);
        this.odt.aWt();
        this.odt.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                g.this.odt.aWt();
                g.this.odv.oaL = true;
                g.this.odv.a(g.this.obC.nYK);
                g.this.odv.gt(false);
                com.tencent.mm.plugin.report.service.g.pWK.h(10997, "6", "", Integer.valueOf(0), Integer.valueOf(0));
            }
        });
        this.nZw = findViewById(R.h.cop);
        this.odB = (ShareHeader) findViewById(R.h.cNS);
        this.odB.setVisibility(0);
        this.odz = new com.tencent.mm.plugin.location.ui.i(this.activity, this.odB.nZh, this.nZw, this.nXy, this.obC.nYK);
        this.odz.nZC = new com.tencent.mm.plugin.location.ui.i.a() {
            public final void Ep(String str) {
                TrackPoint trackPoint = (TrackPoint) g.this.obC.nYK.getViewByItag(str);
                if (trackPoint != null) {
                    d dVar;
                    trackPoint.bringToFront();
                    g.this.obC.nYK.invalidate();
                    m mVar = g.this.odv;
                    if (!bi.oN(str)) {
                        if (mVar.nXt == null || !str.equals(mVar.nXt.vPp)) {
                            if (mVar.oaA != null && mVar.oaA.size() > 0) {
                                for (bte bte : mVar.oaA) {
                                    if (bte.vPp.equals(str)) {
                                        dVar = new d(bte.xbj.vUF, bte.xbj.vUG);
                                        break;
                                    }
                                }
                            }
                        }
                        dVar = new d(mVar.nXt.xbj.vUF, mVar.nXt.xbj.vUG);
                        if (dVar != null) {
                            g.this.obC.nYK.getIController().animateTo(dVar.nWe, dVar.nWf);
                        }
                    }
                    dVar = null;
                    if (dVar != null) {
                        g.this.obC.nYK.getIController().animateTo(dVar.nWe, dVar.nWf);
                    }
                }
            }
        };
        this.odw.nXA = this.odG;
        if (this.odv == null) {
            this.odv = new m(this.activity, this.obC.nYK, true);
        }
        this.odv.oaS = this.oaS;
        this.odv.oaG = false;
        this.odx = new l(this.activity, this);
        this.odu = (TipSayingWidget) findViewById(R.h.cIT);
        this.ods = (Button) findViewById(R.h.cNU);
        this.ods.setVisibility(0);
        this.ody = new k(this.activity, this.ods);
        this.ody.oap = this.odz;
        this.odB.nZi.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                l lVar = g.this.odx;
                h.a(lVar.mContext, lVar.mResources.getString(R.l.etz), "", lVar.mResources.getString(R.l.dEV), lVar.mResources.getString(R.l.dEy), new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        if (l.this.oay != null) {
                            l.this.oay.aWP();
                        }
                    }
                }, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        g.pWK.h(10997, "18", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0));
                    }
                });
            }
        });
        this.odB.nZj.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                com.tencent.mm.plugin.report.service.g.pWK.h(10997, "11", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0));
                g.this.odx.aWN();
            }
        });
        ((LocationManager) this.activity.getSystemService("location")).isProviderEnabled("gps");
        e eVar = this.odw;
        LocationInfo locationInfo = this.obA;
        eVar.nXD = System.currentTimeMillis();
        eVar.hry = c.OV();
        eVar.hry.b(eVar.gAn, true);
        if (eVar.nXq == null) {
            eVar.nXq = com.tencent.mm.plugin.location.model.l.aWc();
        }
        eVar.nXq.a(eVar.nXF);
        if (locationInfo != null) {
            eVar.nXu = locationInfo;
        }
        if (eVar.fBn) {
            x.i("MicorMsg.TrackRefreshManager", "start location " + eVar.nXu.nWe + " " + eVar.nXu.nWf);
        } else {
            eVar.nXs = 1;
            eVar.nXt = new bte();
            eVar.nXt.xbj = new ayo();
            eVar.nXt.xbj.vUG = -1000.0d;
            eVar.nXt.xbj.vUF = -1000.0d;
            x.i("MicorMsg.TrackRefreshManager", "start location imp " + eVar.nXu.nWe + " " + eVar.nXu.nWf);
            as.CN().a(492, eVar);
            as.CN().a(490, eVar);
            as.CN().a(491, eVar);
            eVar.fid = false;
            eVar.fBn = true;
        }
        o oVar = this.odw;
        b bVar = this.odF;
        Iterator it = oVar.nXr.iterator();
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            if (weakReference != null && weakReference.get() != null && ((b) weakReference.get()).equals(bVar)) {
                break;
            }
        }
        oVar.nXr.add(new WeakReference(bVar));
        this.odC = this.activity.getIntent().getStringExtra("fromWhereShare");
        x.d("MicroMsg.ShareMapUI", "fromWhere=%s", this.odC);
        if (this.odw.aWf()) {
            x.i("MicroMsg.ShareMapUI", "has join");
            this.odv.gu(true);
            this.ody.aWD();
            return;
        }
        int i;
        String FY;
        com.tencent.mm.ad.k bVar2;
        o oVar2 = this.odw;
        String str = this.nXy;
        if (!bi.oN(this.odC)) {
            if (this.odC.equals("fromBanner")) {
                i = 0;
            } else if (!this.odC.equals("fromPluginLocation")) {
                if (this.odC.equals("fromPluginTalk")) {
                    i = 2;
                } else if (this.odC.equals("fromTrackButton")) {
                    i = 3;
                } else if (this.odC.equals("fromMessage")) {
                    i = 4;
                }
            }
            x.i("MicorMsg.TrackRefreshManager", "track join %s", str);
            oVar2.nXy = str;
            FY = q.FY();
            FY = str.contains("@chatroom") ? str : FY.compareTo(str) <= 0 ? str + FY : FY + str;
            bVar2 = new com.tencent.mm.plugin.location.model.a.b(FY);
            ((anl) bVar2.gLB.hnQ.hnY).sfa = i;
            as.CN().a(bVar2, 0);
        }
        i = 1;
        x.i("MicorMsg.TrackRefreshManager", "track join %s", str);
        oVar2.nXy = str;
        FY = q.FY();
        if (str.contains("@chatroom")) {
        }
        bVar2 = new com.tencent.mm.plugin.location.model.a.b(FY);
        ((anl) bVar2.gLB.hnQ.hnY).sfa = i;
        as.CN().a(bVar2, 0);
    }

    public final void onResume() {
        boolean z;
        x.i("MicroMsg.ShareMapUI", "resume");
        super.onResume();
        this.wakeLock.acquire();
        o oVar = this.odw;
        x.d("MicorMsg.TrackRefreshManager", "resume isPuase:" + oVar.nXw);
        if (oVar.nXw) {
            oVar.nXD = System.currentTimeMillis();
            oVar.hry.a(oVar.gAn);
            oVar.nXq.a(oVar.nXF);
        }
        oVar.nXw = false;
        oVar.aWg();
        oVar = this.odw;
        com.tencent.mm.plugin.p.d dVar = this.obC.nYK;
        oVar.nXs = oVar.nXx;
        x.d("MicorMsg.TrackRefreshManager", "resumeStatus upload_status  " + oVar.nXs + " %f %f %d ", Double.valueOf(oVar.nWe), Double.valueOf(oVar.nWf), Integer.valueOf(oVar.zoom));
        if (oVar.nWe == -1000.0d || oVar.nWf == -1000.0d || oVar.zoom == -1) {
            z = false;
        } else {
            dVar.getIController().setCenter(oVar.nWe, oVar.nWf);
            dVar.getIController().setZoom(oVar.zoom);
            z = true;
        }
        if (z) {
            this.odt.nYt = false;
            this.odt.aWu();
            this.odv.oaL = false;
            this.odv.oaF = true;
        }
        oVar = this.odw;
        com.tencent.mm.plugin.p.d dVar2 = this.obC.nYK;
        if (oVar.nXB != -1) {
            dVar2.getIController().setZoom(oVar.nXB);
        }
        if (this.odA != null) {
            this.odA.a(this.gAn);
        }
        if (this.odv != null) {
            this.odv.onResume();
        }
    }

    public final void onPause() {
        x.i("MicroMsg.ShareMapUI", "pause");
        super.onPause();
        this.wakeLock.release();
        o oVar = this.odw;
        x.d("MicorMsg.TrackRefreshManager", "pause isShared:" + oVar.nXv);
        if (!oVar.nXv) {
            oVar.hry.c(oVar.gAn);
            oVar.nXq.b(oVar.nXF);
            oVar.nXw = true;
            oVar.nXC = true;
        }
        oVar = this.odw;
        com.tencent.mm.plugin.p.d dVar = this.obC.nYK;
        oVar.nXx = oVar.nXs;
        oVar.nXs = 0;
        x.d("MicorMsg.TrackRefreshManager", "saveStatus pause_save_upload_status: " + oVar.nXx);
        if (oVar.aWl()) {
            oVar.nWe = (((double) dVar.getMapCenterX()) * 1.0d) / 1000000.0d;
            oVar.nWf = (((double) dVar.getMapCenterY()) * 1.0d) / 1000000.0d;
            oVar.zoom = dVar.getZoom();
        }
        com.tencent.mm.plugin.report.service.g.pWK.h(10997, "17", Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(System.currentTimeMillis() - this.odD));
        this.odD = System.currentTimeMillis();
        if (this.odA != null) {
            this.odA.c(this.gAn);
        }
        if (this.odv != null) {
            this.odv.onPause();
        }
    }

    public final void onDestroy() {
        super.onDestroy();
        o oVar = this.odw;
        b bVar = this.odF;
        Iterator it = oVar.nXr.iterator();
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            if (weakReference != null && weakReference.get() != null && ((b) weakReference.get()).equals(bVar)) {
                oVar.nXr.remove(weakReference);
                break;
            }
        }
        this.odw.nXA = null;
        if (this.ody != null) {
            Object obj = this.ody;
            obj.oao.b(obj);
            VolumeMeter volumeMeter = obj.oab;
            volumeMeter.oaU = true;
            volumeMeter.hwv = false;
            if (volumeMeter.oaY != null) {
                volumeMeter.oaY.getLooper().quit();
                volumeMeter.oaY = null;
            }
        }
        if (this.odv != null) {
            this.odv.destroy();
        }
        if (this.odt != null) {
            c.OV().c(this.odt.gAn);
        }
        x.i("MicroMsg.ShareMapUI", "onDestory");
    }

    public final void gs(boolean z) {
    }

    protected final void aWW() {
        super.aWW();
    }

    public final void aWO() {
        this.odw.nXB = this.obC.nYK.getZoom();
        this.activity.finish();
    }

    private void aXi() {
        aWY();
        this.odv.gu(false);
        this.odw.stop();
        this.odw.se(3);
        k.aWG();
        this.odw.nXB = this.obC.nYK.getZoom();
        this.activity.finish();
    }

    public final void aWP() {
        this.odv.gu(false);
        this.odw.stop();
        this.odw.se(0);
        k.aWG();
        this.activity.finish();
    }

    public final void si(int i) {
        if (i == 0) {
            com.tencent.mm.plugin.report.service.g.pWK.h(10997, "8", "", Integer.valueOf(0), Integer.valueOf(0));
            aXi();
        } else if (i == 1) {
            com.tencent.mm.plugin.report.service.g.pWK.h(10997, "8", "", Integer.valueOf(0), Integer.valueOf(0));
            aXi();
        } else if (i == 2) {
            aXi();
        }
    }

    public final void aWQ() {
        bpq bpq = this.odv.oaK;
        if (bpq != null) {
            LocationInfo locationInfo = this.obA;
            locationInfo.nWg = bpq.wKq;
            locationInfo.nWf = bpq.vUF;
            locationInfo.nWe = bpq.vUG;
            if (TextUtils.isEmpty(bpq.wKq)) {
                this.oef.setText("");
            } else {
                this.oef.setText(bpq.wKq);
            }
            this.oef.b(this.obA);
            n nVar = this.oef;
            nVar.nYK.updateLocaitonPinLayout(nVar.nYJ, nVar.nWe, nVar.nWf);
            this.obC.nYK.getIController().animateTo(this.obA.nWe, this.obA.nWf);
        }
    }

    public final void onBackPressed() {
        com.tencent.mm.plugin.report.service.g.pWK.h(10997, "11", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0));
        this.odx.aWN();
    }

    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent);
    }

    public final void aXj() {
        super.aXj();
        if (this.odv != null) {
            this.odv.oaL = false;
            this.odv.gt(false);
            this.odt.aWu();
        }
    }

    public final void aXk() {
        super.aXk();
    }

    protected final void aXl() {
        super.aXl();
        com.tencent.mm.plugin.report.service.g.pWK.h(10997, "1", "", Integer.valueOf(0), Integer.valueOf(0));
    }
}
