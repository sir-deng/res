package com.tencent.mm.plugin.location.ui.impl;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.f.a.cb;
import com.tencent.mm.f.a.di;
import com.tencent.mm.modelgeo.a.a;
import com.tencent.mm.modelsimple.ab;
import com.tencent.mm.plugin.location.model.LocationInfo;
import com.tencent.mm.plugin.location.ui.n;
import com.tencent.mm.pluginsdk.ui.tools.AppChooserUI;
import com.tencent.mm.pluginsdk.ui.tools.r;
import com.tencent.mm.protocal.c.bff;
import com.tencent.mm.remoteservice.d;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.base.p.c;
import com.tencent.mm.ui.u;
import com.tencent.mm.ui.widget.g;
import com.tencent.mm.y.as;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import com.tencent.wcdb.database.SQLiteGlobal;
import java.util.ArrayList;

public class i extends a implements e {
    private boolean fCQ = true;
    protected long frh = -1;
    private boolean ktS = false;
    public d mlo = new d(this.activity);
    private long oaO = 0;
    private String oee = "";
    n oef;
    g oeg;
    boolean oeh = false;
    private Runnable oei;
    private a oej = new a() {
        public final boolean a(boolean z, float f, float f2, int i, double d, double d2, double d3) {
            if (!z) {
                return false;
            }
            x.d("MicroMsg.ViewMapUI", "onGetLocation flong " + f + " flat " + f2);
            if (((double) f2) == 0.0d && ((double) f) == 0.0d) {
                return true;
            }
            x.d("MicroMsg.ViewMapUI", "myLocation " + i.this.obB.nWe + " " + i.this.obB.nWf);
            if (!i.this.obB.aVQ()) {
                x.d("MicroMsg.ViewMapUI", "location my show");
                i.this.obB.nWe = (double) f2;
                i.this.obB.nWf = (double) f;
                i.this.obF.a(i.this.obB.nWe, i.this.obB.nWf, i.this.obM, i.this.obB.nWd);
            }
            return true;
        }
    };

    public i(Activity activity) {
        super(activity);
        as.CN().a(424, (e) this);
    }

    public boolean aWZ() {
        if (this.oeg == null || !this.oeg.isShowing()) {
            aXr();
            this.oeg.bUX();
        } else {
            this.oeg.bxR();
        }
        return true;
    }

    final void aXr() {
        this.oeg = new g(this.activity, g.zCt, false);
        this.oeg.rQF = new c() {
            public final void a(com.tencent.mm.ui.base.n nVar) {
                nVar.a(1, i.this.getString(R.l.dGQ), 0);
                if (i.this.type == 1) {
                    nVar.a(3, i.this.getString(R.l.eAq), 0);
                } else if (i.this.type == 2 && i.this.activity.getIntent().getBooleanExtra("kFavCanDel", true)) {
                    nVar.a(5, i.this.getString(R.l.efl), 0);
                    nVar.a(4, i.this.getString(R.l.dEH), 0);
                }
                b diVar = new di();
                diVar.fsL.frh = i.this.frh;
                com.tencent.mm.sdk.b.a.xmy.m(diVar);
                if (diVar.fsM.fsk || com.tencent.mm.pluginsdk.model.app.g.m(ad.getContext(), 4)) {
                    nVar.a(6, i.this.getString(R.l.dZr), 0);
                }
            }
        };
        this.oeg.rQG = new p.d() {
            public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                Intent intent;
                switch (menuItem.getItemId()) {
                    case 0:
                        i.this.aXs();
                        return;
                    case 1:
                        if (i.this.type == 2) {
                            com.tencent.mm.plugin.report.service.g.pWK.h(10651, Integer.valueOf(6), Integer.valueOf(1), Integer.valueOf(0));
                        }
                        intent = new Intent();
                        intent.putExtra("Retr_Msg_content", com.tencent.mm.plugin.location.model.e.a(i.this.obA));
                        intent.putExtra("Retr_Msg_Type", 9);
                        com.tencent.mm.bl.d.a(i.this.activity, ".ui.transmit.MsgRetransmitUI", intent);
                        return;
                    case 2:
                        i.this.fvv = 0;
                        i.this.aXu();
                        return;
                    case 3:
                        i.this.aXt();
                        return;
                    case 4:
                        h.a(i.this.activity, i.this.activity.getString(R.l.dEI), "", new OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                                long longExtra = i.this.activity.getIntent().getLongExtra("kFavInfoLocalId", -1);
                                b cbVar = new cb();
                                cbVar.frd.frf = longExtra;
                                com.tencent.mm.sdk.b.a.xmy.m(cbVar);
                                x.d("MicroMsg.ViewMapUI", "do del fav voice, local id %d, result %B", Long.valueOf(longExtra), Boolean.valueOf(bi.a(Boolean.valueOf(cbVar.fre.fqR), false)));
                                if (bi.a(Boolean.valueOf(cbVar.fre.fqR), false)) {
                                    i.this.activity.finish();
                                }
                            }
                        }, null);
                        return;
                    case 5:
                        long longExtra = i.this.activity.getIntent().getLongExtra("kFavInfoLocalId", -1);
                        Intent intent2 = new Intent();
                        intent2.putExtra("key_fav_item_id", longExtra);
                        intent2.putExtra("key_fav_scene", 2);
                        com.tencent.mm.bl.d.b(i.this.activity, "favorite", ".ui.FavTagEditUI", intent2);
                        return;
                    case 6:
                        intent = new Intent();
                        intent.putExtra("Retr_Msg_content", com.tencent.mm.plugin.location.model.e.a(i.this.obA));
                        intent.putExtra("Retr_Msg_Id", i.this.frh);
                        com.tencent.mm.bl.d.a(i.this.activity, ".ui.chatting.ChattingSendDataToDeviceUI", intent);
                        return;
                    default:
                        return;
                }
            }
        };
    }

    void aWX() {
        this.obC.obT.setEnabled(true);
        this.obC.obO.setVisibility(8);
        c(this.obA);
        this.obC.nYK.getIController().setZoom(this.zoom);
        this.obC.obR.setEnabled(true);
        this.fCQ = this.activity.getIntent().getBooleanExtra("kShowshare", true);
        if (this.fCQ) {
            this.obC.obR.setVisibility(0);
        } else {
            this.obC.obR.setVisibility(8);
        }
        this.oee = this.activity.getIntent().getStringExtra("soso_street_view_url");
        if (!bi.oN(this.oee) && (w.cfT() || w.cfS())) {
            this.oeh = true;
        } else if (w.cfT() || w.cfS()) {
            this.oeh = false;
            try {
                bff bff = (bff) new ab((float) this.obA.nWf, (float) this.obA.nWe, this.frh).gLB.hnQ.hnY;
                ab abVar = new ab(bff);
                as.CN().a(new ab(bff), 0);
            } catch (Exception e) {
                x.e("MicroMsg.ViewMapUI", e.toString());
            }
        }
        this.obC.obR.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                i.this.aXr();
                i.this.oeg.bUX();
            }
        });
        this.oef = new n(this.obC.nYK, this.activity);
        n nVar = this.oef;
        if (nVar.obp != null) {
            nVar.obp.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    if (n.this.obq == null) {
                        return;
                    }
                    if (n.this.obq.getVisibility() == 0) {
                        n.this.obq.setVisibility(4);
                        n.this.isVisible = false;
                        return;
                    }
                    n.this.obq.setVisibility(0);
                    n.this.isVisible = true;
                }
            });
            nVar.obq.setVisibility(0);
        }
        a(this.oef);
        this.oef.b(this.obA);
        this.oef.Et("");
        if (!com.tencent.mm.plugin.location.model.e.h(this.obA.nWe, this.obA.nWf)) {
            x.d("MicroMsg.ViewMapUI", "isValidLatLng %f %f", Double.valueOf(this.obA.nWe), Double.valueOf(this.obA.nWf));
            nVar = this.oef;
            nVar.nYI = false;
            nVar.nYJ.setVisibility(8);
        }
        if (2 == this.type) {
            x.i("MicroMsg.ViewMapUI", "location id %s", this.obA.nWd);
            if (this.activity.getIntent().getBooleanExtra("kFavCanRemark", true)) {
                aWU();
            }
            if (!bi.oN(this.obA.nWg)) {
                this.obC.obP.setVisibility(0);
            }
        }
        this.obE.put(this.obA.nWd, this.oef);
        if (this.obA.aVR()) {
            if (!(this.nYL == null || this.nYL.equals(""))) {
                this.oef.nYL = this.nYL;
            }
            this.oef.setText(this.oef.nYi + this.obA.nWg);
        } else if (com.tencent.mm.plugin.location.model.e.h(this.obA.nWe, this.obA.nWf)) {
            this.obF.a(this.obA.nWe, this.obA.nWf, this.obM, this.obA.nWd);
        }
        this.obC.obU = this.oef.obt;
        this.obC.obU.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                i.this.fvv = 0;
                i.this.aXl();
                i.this.aXu();
            }
        });
        this.obC.obU.setVisibility(0);
    }

    protected void aXn() {
    }

    protected void aXl() {
    }

    protected final void aXs() {
        if (this.oeh) {
            r.a(new com.tencent.mm.pluginsdk.ui.tools.e());
            Intent intent = new Intent();
            intent.putExtra("show_bottom", false);
            intent.putExtra("jsapi_args_appid", "wx751a1acca5688ba3");
            intent.putExtra("rawUrl", this.oee);
            intent.putExtra("title", R.l.eHO);
            intent.putExtra("webview_bg_color_rsID", R.e.black);
            com.tencent.mm.bl.d.b(this.activity, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent);
        }
    }

    public void onResume() {
        super.onResume();
        x.d("MicroMsg.ViewMapUI", "onbaseGeoResume");
        if (this.obL != null) {
            this.obL.b(this.oej, true);
        }
    }

    public void onPause() {
        x.d("MicroMsg.ViewMapUI", "onbaseGeoResume");
        if (this.obL != null) {
            this.obL.c(this.oej);
        }
        super.onPause();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        double doubleExtra = this.activity.getIntent().getDoubleExtra("kwebmap_slat", 0.0d);
        double doubleExtra2 = this.activity.getIntent().getDoubleExtra("kwebmap_lng", 0.0d);
        x.i("MicroMsg.ViewMapUI", "start dslat " + doubleExtra + " " + doubleExtra2);
        this.zoom = this.activity.getIntent().getIntExtra("kwebmap_scale", 15);
        if (this.zoom <= 0) {
            this.zoom = 15;
        }
        this.nYL = this.activity.getIntent().getStringExtra("kPoiName");
        String stringExtra = this.activity.getIntent().getStringExtra("Kwebmap_locaion");
        x.d("MicroMsg.ViewMapUI", "view " + doubleExtra + " " + doubleExtra2);
        LocationInfo locationInfo = this.obA;
        locationInfo.nWe = doubleExtra;
        locationInfo.nWf = doubleExtra2;
        locationInfo.nWg = stringExtra;
        locationInfo.zoom = this.zoom;
        locationInfo.fEp = this.nYL;
        this.frh = this.activity.getIntent().getLongExtra("kMsgId", -1);
        this.nXy = this.activity.getIntent().getStringExtra("map_talker_name");
        initView();
    }

    protected void aWW() {
        Intent intent = new Intent();
        intent.putExtra("kopenGmapNums", this.obz.nYn);
        intent.putExtra("kopenOthersNums", this.obz.nYo);
        intent.putExtra("kopenreportType", this.obz.hLe);
        intent.putExtra("kRemark", aWV());
        intent.putExtra("soso_street_view_url", this.oee);
        this.activity.setResult(-1, intent);
    }

    protected final void aXt() {
        x.d("MicroMsg.ViewMapUI", "directlyFavorite lat %s, long %s, scale", Double.valueOf(this.obA.nWe), Double.valueOf(this.obA.nWf));
        Intent intent = new Intent();
        intent.putExtra("kfavorite", true);
        intent.putExtra("kopenGmapNums", this.obz.nYn);
        intent.putExtra("kopenOthersNums", this.obz.nYo);
        intent.putExtra("kopenreportType", this.obz.hLe);
        intent.putExtra("kRemark", aWV());
        intent.putExtra("kwebmap_slat", this.obA.nWe);
        intent.putExtra("kwebmap_lng", this.obA.nWf);
        intent.putExtra("Kwebmap_locaion", this.obA.nWg);
        intent.putExtra("kPoiName", this.nYL);
        this.activity.setResult(-1, intent);
        this.activity.getIntent().getIntExtra(u.FLAG_OVERRIDE_ENTER_ANIMATION, -1);
        this.activity.getIntent().getIntExtra(u.FLAG_OVERRIDE_EXIT_ANIMATION, -1);
        this.activity.finish();
    }

    protected final void aXu() {
        com.tencent.mm.plugin.report.service.g.pWK.h(12809, Integer.valueOf(3), "");
        x.d("MicroMsg.ViewMapUI", "locationLine, locationInfo.slat=%f, locationInfo.slong=%f, myLocation.slat=%f, myLocation.slong=%f", Double.valueOf(this.obA.nWe), Double.valueOf(this.obA.nWf), Double.valueOf(this.obB.nWe), Double.valueOf(this.obB.nWf));
        if (this.obB.aVQ()) {
            aXn();
            return;
        }
        this.obG = true;
        if (this.handler != null) {
            if (this.oei != null) {
                this.handler.removeCallbacks(this.oei);
            }
            this.oei = new Runnable() {
                public final void run() {
                    if (i.this.obG) {
                        if (i.this.inI != null) {
                            i.this.inI.dismiss();
                        }
                        i.this.aXn();
                    }
                    i.this.obG = false;
                }
            };
            this.handler.postDelayed(this.oei, 10000);
            Context context = this.activity;
            getString(R.l.dGZ);
            this.inI = h.a(context, getString(R.l.enN), true, new OnCancelListener() {
                public final void onCancel(DialogInterface dialogInterface) {
                    i.this.obG = false;
                }
            });
        }
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        switch (i) {
            case 4098:
            case 4099:
                com.tencent.mm.plugin.location.ui.d dVar = this.obz;
                Intent intent2;
                switch (i) {
                    case 4098:
                        Bundle bundleExtra;
                        ArrayList parcelableArrayList;
                        if (-1 == i2 && intent != null) {
                            String stringExtra = intent.getStringExtra("selectpkg");
                            bundleExtra = intent.getBundleExtra("transferback");
                            boolean booleanExtra = intent.getBooleanExtra("isalways", false);
                            parcelableArrayList = bundleExtra.getParcelableArrayList("locations");
                            dVar.a((LocationInfo) parcelableArrayList.get(0), (LocationInfo) parcelableArrayList.get(1), stringExtra, booleanExtra);
                            return;
                        } else if (4097 == i2) {
                            if (intent.getBooleanExtra("isalways", false)) {
                                com.tencent.mm.plugin.report.service.g.pWK.h(11091, Integer.valueOf(6), Integer.valueOf(2));
                            } else {
                                com.tencent.mm.plugin.report.service.g.pWK.h(11091, Integer.valueOf(6), Integer.valueOf(1));
                            }
                            parcelableArrayList = intent.getBundleExtra("transferback").getParcelableArrayList("locations");
                            LocationInfo locationInfo = (LocationInfo) parcelableArrayList.get(0);
                            LocationInfo locationInfo2 = (LocationInfo) parcelableArrayList.get(1);
                            Parcelable intent3 = new Intent("android.intent.action.VIEW", Uri.parse(String.format("http://maps.google.com/maps?f=d&saddr=%f,%f&daddr=%f,%f&hl=" + (bi.oN(locationInfo.nWh) ? "zh-cn" : locationInfo.nWh), new Object[]{Double.valueOf(locationInfo2.nWe), Double.valueOf(locationInfo2.nWf), Double.valueOf(locationInfo.nWe), Double.valueOf(locationInfo.nWf)})));
                            bundleExtra = new Bundle();
                            bundleExtra.putParcelable("targetintent", intent3);
                            intent2 = new Intent();
                            intent2.setClass(dVar.context, AppChooserUI.class);
                            intent2.putExtra(Columns.TYPE, 1);
                            intent2.putExtra("title", dVar.context.getResources().getString(R.l.etn));
                            intent2.putExtra("targetintent", intent3);
                            intent2.putExtra("transferback", bundleExtra);
                            intent2.putExtra("scene", 6);
                            ((Activity) dVar.context).startActivityForResult(intent2, 4099);
                            return;
                        } else {
                            return;
                        }
                    case 4099:
                        if (-1 == i2 && intent != null) {
                            String stringExtra2 = intent.getStringExtra("selectpkg");
                            intent2 = new Intent((Intent) intent.getBundleExtra("transferback").getParcelable("targetintent"));
                            intent2.setPackage(stringExtra2);
                            intent2.addFlags(SQLiteGlobal.journalSizeLimit);
                            dVar.context.startActivity(intent2);
                            return;
                        }
                        return;
                    default:
                        return;
                }
            default:
                return;
        }
    }

    public void onDestroy() {
        this.mlo.release();
        this.handler.removeCallbacks(this.oei);
        this.handler = null;
        as.CN().b(424, (e) this);
        super.onDestroy();
    }

    protected final String Xf() {
        return getString(R.l.ett);
    }

    public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.nrl = motionEvent.getX();
                this.kHQ = motionEvent.getY();
                this.oaO = System.currentTimeMillis();
                this.ktS = false;
                aXm();
                break;
            case 1:
                if (!this.ktS) {
                    System.currentTimeMillis();
                }
                aXk();
                break;
            case 2:
                if (Math.abs(motionEvent.getX() - this.nrl) > 10.0f || Math.abs(motionEvent.getY() - this.kHQ) > 10.0f) {
                    this.ktS = true;
                    aXj();
                    break;
                }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public void aXj() {
        if (this.oef != null) {
            this.oef.gv(false);
        }
    }

    public void aXk() {
        if (this.oef != null) {
            this.oef.gv(true);
        }
    }

    public void aXm() {
    }

    public final void a(int i, int i2, String str, k kVar) {
        x.d("MicroMsg.ViewMapUI", "onScene end %d %d %d", Integer.valueOf(kVar.getType()), Integer.valueOf(i), Integer.valueOf(i2));
        if (kVar.getType() != 424) {
            x.e("MicroMsg.ViewMapUI", "msg failed.errtype:%d, errcode:%d", Integer.valueOf(i), Integer.valueOf(i2));
        } else if (i2 == 0 && i == 0) {
            String mC = ab.mC(((ab) kVar).Su().vUQ);
            x.d("MicroMsg.ViewMapUI", "getUrl success! url is %s", mC);
            this.oee = mC;
            if (!bi.oN(mC)) {
                this.oeh = true;
            }
            if (this.type == 9 && !bi.oN(mC)) {
                TextView textView = (TextView) findViewById(R.h.cPG);
                textView.setVisibility(0);
                textView.setOnClickListener(new View.OnClickListener() {
                    public final void onClick(View view) {
                        i.this.aXs();
                    }
                });
            }
        }
    }
}
