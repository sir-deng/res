package com.tencent.mm.plugin.location.ui;

import android.content.Context;
import android.graphics.Point;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import com.tencent.mm.R;
import com.tencent.mm.modelgeo.c;
import com.tencent.mm.plugin.location.model.LocationInfo;
import com.tencent.mm.plugin.location.model.e;
import com.tencent.mm.plugin.location.model.f;
import com.tencent.mm.plugin.location.model.l;
import com.tencent.mm.plugin.location.ui.impl.TrackPoint;
import com.tencent.mm.plugin.location.ui.impl.TrackPointAnimAvatar;
import com.tencent.mm.plugin.p.d;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.ayo;
import com.tencent.mm.protocal.c.bpq;
import com.tencent.mm.protocal.c.bte;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.q;
import com.tencent.mm.y.s;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public final class m {
    private static Object oaB = new Object();
    private com.tencent.mm.modelgeo.a.a gAn = new com.tencent.mm.modelgeo.a.a() {
        public final boolean a(boolean z, float f, float f2, int i, double d, double d2, double d3) {
            if (!z) {
                return false;
            }
            m mVar = m.this;
            double d4 = (double) f2;
            double d5 = (double) f;
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("[refreshMyLocation] ");
            stringBuffer.append(String.format("latitude = %f, longtitude = %f", new Object[]{Double.valueOf(d4), Double.valueOf(d5)}));
            if (mVar.nXt == null) {
                mVar.nXt = new bte();
                mVar.nXt.xbj = new ayo();
                mVar.nXt.vPp = q.FY();
                mVar.nXt.xbj.vUG = d4;
                mVar.nXt.xbj.vUF = d5;
                if (mVar.nYt && mVar.oaE) {
                    mVar.aWR();
                }
            }
            mVar.nXt.xbj.vUG = d4;
            mVar.nXt.xbj.vUF = d5;
            View viewByItag = mVar.nYs.getViewByItag(mVar.nXt.vPp);
            if (viewByItag != null) {
                stringBuffer.append("[ view is not null hasCode: " + viewByItag.hashCode() + " ] ");
            } else {
                viewByItag = new TrackPoint(mVar.mContext);
                if (mVar.oaJ) {
                    ((TrackPoint) viewByItag).g(null);
                    ((TrackPoint) viewByItag).f(null);
                    ((TrackPoint) viewByItag).aXo();
                } else {
                    ((TrackPoint) viewByItag).g(mVar.oaR);
                    ((TrackPoint) viewByItag).f(mVar.oaQ);
                }
                if (!mVar.oaG) {
                    ((TrackPoint) viewByItag).aXq();
                }
                stringBuffer.append("[view is null new one: " + viewByItag.hashCode() + " ] ");
                mVar.nYs.addView(viewByItag, d4, d5, mVar.nXt.vPp);
                mVar.oaD = new TrackPointAnimAvatar(mVar.mContext);
            }
            x.d("MicroMsg.TrackPointViewMgrImpl", stringBuffer.toString());
            if (viewByItag instanceof TrackPoint) {
                mVar.oaC = (TrackPoint) viewByItag;
                x.d("MicroMsg.TrackPointViewMgrImpl", "udpate view layout");
                mVar.nYs.updateViewLayout(viewByItag, d4, d5);
                mVar.oaC.Ex(mVar.nXt.vPp);
                TrackPoint trackPoint = mVar.oaC;
                trackPoint.odV.setImageResource(R.g.bDz);
                trackPoint = mVar.oaC;
                if (trackPoint.jpi == -1.0d && trackPoint.jpj == -1.0d) {
                    trackPoint.jpi = d4;
                    trackPoint.jpg = d4;
                    trackPoint.jpj = d5;
                    trackPoint.jph = d5;
                } else {
                    trackPoint.jpi = trackPoint.jpg;
                    trackPoint.jpj = trackPoint.jph;
                    trackPoint.jph = d5;
                    trackPoint.jpg = d4;
                }
                if (mVar.oaG) {
                    mVar.oaC.odW.setVisibility(0);
                } else {
                    mVar.oaC.aXq();
                }
            }
            if (mVar.oaL) {
                mVar.nYs.getIController().setCenter(mVar.nXt.xbj.vUG, mVar.nXt.xbj.vUF);
            }
            return true;
        }
    };
    protected float kHQ = 0.0f;
    private boolean ktS = false;
    Context mContext;
    private com.tencent.mm.plugin.location.model.i.a nXF = new com.tencent.mm.plugin.location.model.i.a() {
        public final void n(double d) {
            if (m.this.oaC != null) {
                x.d("MicroMsg.TrackPointViewMgrImpl", "updateMyTrackPointDegree, degree = %f", Double.valueOf(d));
                m.this.oaC.o(d);
            }
        }
    };
    public bte nXt;
    d nYs;
    boolean nYt = false;
    protected float nrl = 0.0f;
    public List<bte> oaA;
    public TrackPoint oaC;
    TrackPointAnimAvatar oaD;
    boolean oaE = false;
    public boolean oaF = false;
    public boolean oaG = true;
    public boolean oaH = false;
    public boolean oaI = false;
    public boolean oaJ = false;
    public bpq oaK;
    public boolean oaL = true;
    public boolean oaM = true;
    private boolean oaN = false;
    private long oaO = 0;
    private OnTouchListener oaP = new OnTouchListener() {
        public final boolean onTouch(View view, MotionEvent motionEvent) {
            switch (motionEvent.getAction()) {
                case 0:
                    m.this.nrl = motionEvent.getX();
                    m.this.kHQ = motionEvent.getY();
                    m.this.oaO = System.currentTimeMillis();
                    m.this.ktS = false;
                    break;
                case 1:
                    if (!m.this.ktS && System.currentTimeMillis() - m.this.oaO < 200) {
                        m.c(m.this);
                        break;
                    }
                case 2:
                    if (Math.abs(motionEvent.getX() - m.this.nrl) > 10.0f || Math.abs(motionEvent.getY() - m.this.kHQ) > 10.0f) {
                        m.this.ktS = true;
                        break;
                    }
            }
            return false;
        }
    };
    OnClickListener oaQ = new OnClickListener() {
        public final void onClick(View view) {
            String str = (String) view.getTag();
            x.d("MicroMsg.TrackPointViewMgrImpl", "onLocationTpClick, username=%s", str);
            if (!bi.oN(str)) {
                View viewByItag = m.this.nYs.getViewByItag(str);
                if (viewByItag != null && (viewByItag instanceof TrackPoint)) {
                    TrackPoint trackPoint = (TrackPoint) viewByItag;
                    if (trackPoint.visible) {
                        trackPoint.aXo();
                    } else {
                        trackPoint.aXp();
                    }
                }
            }
        }
    };
    OnClickListener oaR = new OnClickListener() {
        public final void onClick(View view) {
            int[] iArr = new int[2];
            view.getLocationInWindow(iArr);
            m.a(m.this, iArr[0], iArr[1]);
        }
    };
    public a oaS = null;

    public interface a {
    }

    static /* synthetic */ boolean a(m mVar, int i, int i2) {
        if (mVar.oaA != null) {
            ArrayList arrayList = new ArrayList();
            float b = (float) b.b(mVar.mContext, 85.0f);
            for (bte bte : mVar.oaA) {
                Point pointByGeoPoint = mVar.nYs.getPointByGeoPoint(bte.xbj.vUG, bte.xbj.vUF);
                x.d("MicroMsg.TrackPointViewMgrImpl", "cal %f %f %d %d", Double.valueOf(bte.xbj.vUG), Double.valueOf(bte.xbj.vUF), Integer.valueOf(pointByGeoPoint.x), Integer.valueOf(pointByGeoPoint.y));
                if (f.l(pointByGeoPoint.x, pointByGeoPoint.y, i, i2) < ((double) b)) {
                    arrayList.add(bte.vPp);
                }
            }
            if (mVar.nXt != null) {
                Point pointByGeoPoint2 = mVar.nYs.getPointByGeoPoint(mVar.nXt.xbj.vUG, mVar.nXt.xbj.vUF);
                x.d("MicroMsg.TrackPointViewMgrImpl", "cal %f %f %d %d", Double.valueOf(mVar.nXt.xbj.vUG), Double.valueOf(mVar.nXt.xbj.vUF), Integer.valueOf(pointByGeoPoint2.x), Integer.valueOf(pointByGeoPoint2.y));
                if (f.l(pointByGeoPoint2.x, pointByGeoPoint2.y, i, i2) < ((double) b)) {
                    arrayList.add(mVar.nXt.vPp);
                }
            }
            x.d("MicroMsg.TrackPointViewMgrImpl", "cal username size %d ", Integer.valueOf(arrayList.size()));
            if (arrayList.size() > 1) {
                g.pWK.h(10997, "12", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0));
                b.b(mVar.mContext, arrayList);
            }
            if (arrayList.size() > 1) {
                return true;
            }
        }
        return false;
    }

    static /* synthetic */ void c(m mVar) {
        boolean z = true;
        if (mVar.oaI) {
            mVar.gt(false);
        }
        Collection<View> childs = mVar.nYs.getChilds();
        for (View view : childs) {
            if (view instanceof TrackPoint) {
                if (((TrackPoint) view).odX.getVisibility() == 0) {
                    break;
                }
            }
        }
        z = false;
        for (View view2 : childs) {
            if (view2 instanceof TrackPoint) {
                if (z) {
                    ((TrackPoint) view2).aXo();
                } else {
                    ((TrackPoint) view2).aXp();
                }
            }
        }
    }

    public m(Context context, d dVar, boolean z) {
        this.mContext = context;
        this.nYt = z;
        this.nYs = dVar;
        this.oaA = new ArrayList();
        dVar.setMapViewOnTouchListener(this.oaP);
    }

    public final void gt(boolean z) {
        if (z) {
            if ((this.oaC != null ? 1 : 0) != 0) {
                g.pWK.h(10997, "20", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0));
            } else {
                return;
            }
        }
        this.oaI = z;
    }

    public final void destroy() {
        synchronized (oaB) {
            if (this.oaA != null) {
                this.oaA.clear();
            }
        }
    }

    public final void gu(boolean z) {
        if (!(!z || this.oaH || this.nYs == null)) {
            for (View view : this.nYs.getChilds()) {
                if (view instanceof TrackPoint) {
                    ((TrackPoint) view).aXp();
                }
            }
        }
        this.oaH = z;
    }

    public final void bd(List<bte> list) {
        int i;
        this.oaE = true;
        int size = this.oaA.size() + 1;
        synchronized (oaB) {
            this.oaA.clear();
            for (i = 0; i < list.size(); i++) {
                this.oaA.add(list.get(i));
            }
        }
        int size2 = this.oaA.size() + 1;
        synchronized (oaB) {
            View view;
            Set<String> tags = this.nYs.getTags();
            HashSet hashSet = new HashSet();
            i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.oaA.size()) {
                    break;
                }
                hashSet.add(((bte) this.oaA.get(i2)).vPp);
                i = i2 + 1;
            }
            List<String> linkedList = new LinkedList();
            for (String str : tags) {
                if (!(hashSet.contains(str) || str.endsWith("myAnim"))) {
                    if (this.oaC == null || !this.oaC.equals(this.nYs.getViewByItag(str))) {
                        linkedList.add(str);
                    }
                }
            }
            for (String str2 : linkedList) {
                this.nYs.removeViewByTag(str2);
            }
            i = 0;
            while (true) {
                int i3 = i;
                if (i3 >= this.oaA.size()) {
                    break;
                }
                bte bte = (bte) this.oaA.get(i3);
                View viewByItag = this.nYs.getViewByItag(bte.vPp);
                x.d("MicroMsg.TrackPointViewMgrImpl", "position %d %s %f %f %f", Integer.valueOf(i3), bte.vPp, Double.valueOf(bte.xbj.vUG), Double.valueOf(bte.xbj.vUF), Double.valueOf(bte.xbj.wMf));
                if (viewByItag != null) {
                    this.nYs.updateViewLayout(viewByItag, bte.xbj.vUG, bte.xbj.vUF);
                    view = viewByItag;
                } else {
                    viewByItag = new TrackPoint(this.mContext);
                    viewByItag.setVisibility(0);
                    if (!this.oaG) {
                        ((TrackPoint) viewByItag).aXq();
                    }
                    this.nYs.addView(viewByItag, bte.xbj.vUG, bte.xbj.vUF, bte.vPp);
                    ((TrackPoint) viewByItag).g(this.oaR);
                    ((TrackPoint) viewByItag).f(this.oaQ);
                    view = viewByItag;
                }
                if (view instanceof TrackPoint) {
                    TrackPoint trackPoint = (TrackPoint) view;
                    trackPoint.Ex(bte.vPp);
                    trackPoint.o(bte.xbj.wMf);
                    if (!this.oaH) {
                        trackPoint.aXo();
                    }
                }
                i = i3 + 1;
            }
            if (this.nYt && this.oaE) {
                if (s.eX(l.aWa().nXy)) {
                    aWR();
                } else if (this.oaA.size() > 0) {
                    aWR();
                }
            }
            if (size < 10 && size2 >= 10) {
                for (View view2 : this.nYs.getChilds()) {
                    if (view2 instanceof TrackPoint) {
                        ((TrackPoint) view2).aXo();
                    }
                }
            } else if (size >= 10 && size2 < 10) {
                for (View view22 : this.nYs.getChilds()) {
                    if (view22 instanceof TrackPoint) {
                        ((TrackPoint) view22).aXp();
                    }
                }
            }
        }
    }

    final void aWR() {
        if (!this.oaF && this.nXt != null) {
            double d = 0.0d;
            double d2 = 0.0d;
            if (this.nXt != null) {
                LocationInfo locationInfo = l.aWa().nXu;
                if (this.nXt != null && e.h(locationInfo.nWe, locationInfo.nWf)) {
                    d = 2.0d * Math.abs(this.nXt.xbj.vUG - locationInfo.nWe);
                    d2 = Math.abs(this.nXt.xbj.vUF - locationInfo.nWf) * 2.0d;
                }
                double d3 = d2;
                double d4 = d;
                for (int i = 0; i < this.oaA.size(); i++) {
                    bte bte = (bte) this.oaA.get(i);
                    if (bte != null && e.h(bte.xbj.vUG, bte.xbj.vUF)) {
                        double abs = 2.0d * Math.abs(bte.xbj.vUG - this.nXt.xbj.vUG);
                        d = Math.abs(bte.xbj.vUF - this.nXt.xbj.vUF) * 2.0d;
                        if (abs > d4) {
                            d4 = abs;
                        }
                        if (d > d3) {
                            d3 = d;
                        }
                        x.d("MicroMsg.TrackPointViewMgrImpl", "update %s %f %f", bte.vPp, Double.valueOf(bte.xbj.vUG), Double.valueOf(bte.xbj.vUF));
                    }
                }
                if (Math.abs(d4 - -1000.0d) >= 0.5d && Math.abs(d3 - -1000.0d) >= 0.5d) {
                    x.d("MicroMsg.TrackPointViewMgrImpl", "zoomToSpan maxlat " + (1000000.0d * d4) + " maxlng " + (1000000.0d * d3) + " poi " + locationInfo.nWe + " " + locationInfo.nWf);
                    if (this.nXt != null) {
                        x.d("MicroMsg.TrackPointViewMgrImpl", "mPosition item %f %f", Double.valueOf(this.nXt.xbj.vUG), Double.valueOf(this.nXt.xbj.vUF));
                        this.nYs.zoomToSpan(this.nXt.xbj.vUG, this.nXt.xbj.vUF, d4, d3);
                    } else if (e.h(locationInfo.nWe, locationInfo.nWf)) {
                        this.nYs.zoomToSpan(locationInfo.nWe, locationInfo.nWf, d4, d3);
                    }
                }
            }
            this.oaF = true;
        }
    }

    public final void a(d dVar) {
        if (this.nXt != null) {
            double d = this.nXt.xbj.vUF;
            dVar.getIController().animateTo(this.nXt.xbj.vUG, d);
            if (dVar.getZoomLevel() < 16) {
                dVar.getIController().setZoom(16);
            }
        }
    }

    public final void onResume() {
        c.OV().b(this.gAn, true);
        l.aWc().a(this.nXF);
    }

    public final void onPause() {
        c.OV().c(this.gAn);
        l.aWc().b(this.nXF);
    }
}
