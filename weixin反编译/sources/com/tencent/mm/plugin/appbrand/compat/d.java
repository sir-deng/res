package com.tencent.mm.plugin.appbrand.compat;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import com.tencent.mapsdk.raster.model.CameraPosition;
import com.tencent.mapsdk.raster.model.Circle;
import com.tencent.mapsdk.raster.model.LatLng;
import com.tencent.mapsdk.raster.model.LatLngBounds.Builder;
import com.tencent.mapsdk.raster.model.Marker;
import com.tencent.mapsdk.raster.model.Polyline;
import com.tencent.mapsdk.raster.model.TencentMapOptions;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.compat.a.b;
import com.tencent.mm.plugin.appbrand.compat.a.b.f;
import com.tencent.mm.plugin.appbrand.compat.a.b.i;
import com.tencent.mm.plugin.appbrand.compat.a.b.j;
import com.tencent.mm.plugin.appbrand.compat.a.b.k;
import com.tencent.mm.plugin.appbrand.compat.a.b.l;
import com.tencent.mm.plugin.appbrand.compat.a.b.m;
import com.tencent.mm.plugin.appbrand.compat.a.b.n;
import com.tencent.mm.plugin.appbrand.compat.a.b.o;
import com.tencent.mm.plugin.appbrand.compat.a.b.p;
import com.tencent.mm.plugin.appbrand.compat.a.b.q;
import com.tencent.mm.plugin.location_soso.SoSoMapView;
import com.tencent.tencentmap.mapsdk.map.g;
import com.tencent.tencentmap.mapsdk.map.g.a;
import com.tencent.tencentmap.mapsdk.map.g.c;
import com.tencent.tencentmap.mapsdk.map.g.e;
import com.tencent.tencentmap.mapsdk.map.g.h;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;

final class d implements b {
    final FrameLayout iPf;
    final SoSoMapView iPg;

    d(Context context) {
        this.iPf = (FrameLayout) LayoutInflater.from(context).inflate(R.i.dar, null);
        this.iPg = (SoSoMapView) this.iPf.findViewById(R.h.cku);
        this.iPf.setTag(R.h.bKs, this);
    }

    d(Context context, byte b) {
        this.iPf = new FrameLayout(context);
        LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.iPf.setBackgroundColor(0);
        this.iPf.setLayoutParams(layoutParams);
        TencentMapOptions tencentMapOptions = new TencentMapOptions();
        tencentMapOptions.enableHandDrawMap(true);
        this.iPg = new SoSoMapView(context, tencentMapOptions);
        this.iPf.addView(this.iPg, new FrameLayout.LayoutParams(-1, -1));
        this.iPf.setTag(R.h.bKs, this);
    }

    public final View getView() {
        return this.iPf;
    }

    public final boolean a(View view, double d, double d2) {
        this.iPg.addView(view, d, d2);
        return true;
    }

    public final boolean b(View view, double d, double d2) {
        if (view == null) {
            return false;
        }
        this.iPg.updateViewLayout(view, d, d2);
        return true;
    }

    public final f abK() {
        LatLng mapCenter = this.iPg.getMap().getMapCenter();
        return new f(mapCenter.getLatitude(), mapCenter.getLongitude());
    }

    public final f e(double d, double d2) {
        return new f(d, d2);
    }

    public final q abL() {
        return new j(this.iPg.getProjection());
    }

    public final void a(double d, double d2, int i) {
        g map = this.iPg.getMap();
        if (map != null) {
            map.moveCamera(com.tencent.tencentmap.mapsdk.map.b.a(new LatLng(d, d2), (float) i));
        }
    }

    public final void setCenter(double d, double d2) {
        this.iPg.getIController().setCenter(d, d2);
    }

    public final void jP(int i) {
        g map = this.iPg.getMap();
        if (map != null) {
            map.a(com.tencent.tencentmap.mapsdk.map.b.aK((float) i));
        }
    }

    public final void animateTo(double d, double d2) {
        this.iPg.getIController().animateTo(d, d2);
    }

    public final int getZoomLevel() {
        return this.iPg.getMap().getZoomLevel();
    }

    public final void clean() {
        this.iPg.clean();
    }

    public final void c(List<f> list, int i) {
        Builder builder = new Builder();
        Iterable linkedList = new LinkedList();
        for (f fVar : list) {
            if (fVar instanceof f) {
                linkedList.add(((f) fVar).iPp);
            } else {
                linkedList.add(new LatLng(fVar.abS(), fVar.abT()));
            }
        }
        builder.include(linkedList);
        this.iPg.getMap().a(com.tencent.tencentmap.mapsdk.map.b.a(builder.build(), i));
    }

    public final void a(final m mVar) {
        g map = this.iPg.getMap();
        map.mapContext.c().a(new g.f() {
            public final void abP() {
                if (mVar != null) {
                    mVar.abP();
                }
            }
        });
    }

    public final void a(final l lVar) {
        g map = this.iPg.getMap();
        map.mapContext.h().a(new e() {
            public final void c(LatLng latLng) {
                if (lVar != null) {
                    l lVar = lVar;
                    k.d(latLng);
                    lVar.abZ();
                }
            }
        });
    }

    public final void a(final k kVar) {
        g map = this.iPg.getMap();
        map.mapContext.h().a(new com.tencent.tencentmap.mapsdk.map.g.d() {
            public final void b(CameraPosition cameraPosition) {
                if (kVar != null) {
                    k kVar = kVar;
                    k.d(cameraPosition);
                    kVar.abX();
                }
            }

            public final void c(CameraPosition cameraPosition) {
                if (kVar != null) {
                    k kVar = kVar;
                    k.d(cameraPosition);
                    kVar.abY();
                }
            }
        });
    }

    public final void a(final j jVar) {
        g map = this.iPg.getMap();
        map.mapContext.h().a(new c() {
            public final void a(Marker marker) {
                if (jVar != null) {
                    jVar.b(new g(marker));
                }
            }
        });
    }

    public final void a(final n nVar) {
        g map = this.iPg.getMap();
        map.mapContext.h().a(new h() {
            public final boolean b(Marker marker) {
                return nVar != null && nVar.c(new g(marker));
            }
        });
    }

    public final void a(final b.e eVar) {
        a aVar;
        g map = this.iPg.getMap();
        if (eVar == null) {
            aVar = null;
        } else {
            aVar = new a() {
                public final View c(Marker marker) {
                    return eVar.a(new g(marker));
                }

                public final void d(Marker marker) {
                    g gVar = new g(marker);
                }
            };
        }
        map.mapContext.h().a(aVar);
    }

    public final i abM() {
        return new h();
    }

    public final b.h a(i iVar) {
        Marker addMarker;
        if (iVar instanceof h) {
            addMarker = this.iPg.getMap().addMarker(((h) iVar).iPs);
        } else {
            addMarker = null;
            Assert.assertTrue("Should use IAppBrandMapView.createMarkersOptions to initiate MarkerOptions!", true);
        }
        return new g(addMarker);
    }

    public final b.c abN() {
        return new c();
    }

    public final b.b a(b.c cVar) {
        Circle addCircle;
        if (cVar instanceof c) {
            addCircle = this.iPg.getMap().addCircle(((c) cVar).iPe);
        } else {
            addCircle = null;
            Assert.assertTrue("Should use IAppBrandMapView.createMarkersOptions to initiate CircleOptions!", true);
        }
        return new a(addCircle);
    }

    public final o a(p pVar) {
        Polyline addPolyline;
        if (pVar instanceof i) {
            addPolyline = this.iPg.getMap().addPolyline(((i) pVar).iPt);
        } else {
            addPolyline = null;
            Assert.assertTrue("Should use IAppBrandMapView.createPolylineOptions to initiate PolylineOptions!", true);
        }
        return new b(addPolyline);
    }

    public final p abO() {
        return new i();
    }
}
