package com.tencent.mm.plugin.location.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import com.tencent.mm.f.a.lz;
import com.tencent.mm.f.a.ot;
import com.tencent.mm.f.a.rl;
import com.tencent.mm.j.g;
import com.tencent.mm.modelstat.o;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.plugin.location.model.l;
import com.tencent.mm.plugin.location.ui.impl.d;
import com.tencent.mm.pluginsdk.location.LocationIntent;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.y.as;
import com.tencent.mm.y.c;
import com.tencent.rtmp.TXLiveConstants;

@a(23)
public class RedirectUI extends Activity {
    private static long gAs = 86400000;
    private boolean fBn = false;
    private long frh;
    private final ag handler = new ag();
    private String info = "";
    private int kZv;
    private double nWe = 0.0d;
    private double nWf = 0.0d;
    private String nYX = "";
    private String nYY = "";
    private int nYZ;
    private boolean nYp = true;
    private final int nZa = 1;
    private boolean nZb = false;
    private final int nZc = 0;
    private final int nZd = 1;
    private final int nZe = 0;
    private final int nZf = 1;
    private int type = 0;
    private int zoom = 0;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (VERSION.SDK_INT >= 21) {
            getWindow().addFlags(Integer.MIN_VALUE);
            getWindow().setStatusBarColor(0);
        }
        as.Hm();
        if ((bi.bz(Long.valueOf(bi.c((Long) c.Db().get(81938, null))).longValue()) * 1000 > gAs ? 1 : 0) != 0) {
            com.tencent.mm.ay.c.QI().update();
        }
        this.type = getIntent().getIntExtra("map_view_type", -1);
        if (this.type == -1) {
            finish();
        }
        this.frh = getIntent().getLongExtra("kMsgId", -1);
        this.nYY = getIntent().getStringExtra("map_talker_name");
        x.d("MicroMsg.RedirectUI", "tofutest type: %s", Integer.valueOf(this.type));
        switch (this.type) {
            case 0:
            case 3:
            case 8:
                this.nYX = getIntent().getStringExtra("map_sender_name");
                this.kZv = getIntent().getIntExtra("view_type_key", 1);
                this.nYZ = getIntent().getIntExtra("key_get_location_type", 0);
                j(-85.0d, -1000.0d);
                return;
            case 1:
            case 2:
            case 7:
            case 9:
                this.nWe = getIntent().getDoubleExtra("kwebmap_slat", -85.0d);
                this.nWf = getIntent().getDoubleExtra("kwebmap_lng", -1000.0d);
                this.zoom = getIntent().getIntExtra("kwebmap_scale", 0);
                this.info = getIntent().getStringExtra("Kwebmap_locaion");
                j(this.nWe, this.nWf);
                return;
            case 6:
                com.tencent.mm.plugin.location.a.a Eh = l.aWb().Eh(this.nYY);
                x.i("MicroMsg.RedirectUI", "resume try to enter trackRoom " + (Eh != null));
                if (Eh != null) {
                    this.nWe = Eh.latitude;
                    this.nWf = Eh.longitude;
                    this.info = Eh.nWa;
                    x.i("MicroMsg.RedirectUI", "resume lat %f lng %f %s member size %d", Double.valueOf(this.nWe), Double.valueOf(this.nWf), this.info, Integer.valueOf(Eh.fBS.size()));
                    this.zoom = 0;
                    j(this.nWe, this.nWf);
                    return;
                }
                j(-1000.0d, -1000.0d);
                return;
            default:
                return;
        }
    }

    private void j(double d, double d2) {
        this.fBn = true;
        Intent w = d.w(this);
        switch (this.type) {
            case 0:
            case 3:
            case 8:
                String str = "MicroMsg.RedirectUI";
                StringBuilder stringBuilder = new StringBuilder("view poi      isHidePoiOversea : ");
                boolean z = bi.getInt(g.Ag().F("ShowConfig", "hidePoiOversea"), 1) == 1;
                x.d("MicroMsg.ConfigListDecoder", "isHidePoiOversea : " + z);
                x.d(str, stringBuilder.append(z).toString());
                w.putExtra("intent_map_key", 2);
                break;
            case 1:
            case 2:
            case 7:
                x.d("MicroMsg.RedirectUI", "view normal");
                w.putExtra("intent_map_key", 4);
                break;
            case 6:
                String stringExtra = getIntent().getStringExtra("fromWhereShare");
                x.d("MicroMsg.RedirectUI", "location resume");
                w.putExtra("intent_map_key", 5);
                if (!bi.oN(stringExtra)) {
                    w.putExtra("fromWhereShare", stringExtra);
                    break;
                }
                break;
            case 9:
                w.putExtra("intent_map_key", 4);
                break;
            default:
                x.d("MicroMsg.RedirectUI", "view type error");
                w = null;
                break;
        }
        switch (this.type) {
            case 0:
                w.putExtra("location_scene", 1);
                break;
        }
        if (r.ifl) {
            final double d3 = d;
            final double d4 = d2;
            this.handler.postDelayed(new Runnable() {
                public final void run() {
                    RedirectUI.this.a(w, d3, d4);
                }
            }, 2000);
            return;
        }
        a(w, d, d2);
    }

    private void a(Intent intent, double d, double d2) {
        if (intent != null) {
            intent.putExtra("kShowshare", getIntent().getBooleanExtra("kShowshare", true));
            as.Hm();
            intent.putExtra("kimg_path", c.Fp());
            intent.putExtra("kPoi_url", bi.aD(getIntent().getStringExtra("kPoi_url"), ""));
            intent.putExtra("map_view_type", getIntent().getIntExtra("map_view_type", 0));
            intent.putExtra("kFavInfoLocalId", getIntent().getLongExtra("kFavInfoLocalId", -1));
            intent.putExtra("kFavCanDel", getIntent().getBooleanExtra("kFavCanDel", true));
            intent.putExtra("kFavCanRemark", getIntent().getBooleanExtra("kFavCanRemark", true));
            intent.putExtra("kwebmap_slat", d);
            intent.putExtra("kwebmap_lng", d2);
            intent.putExtra("kPoiName", getIntent().getStringExtra("kPoiName"));
            intent.putExtra("kisUsername", bi.aD(getIntent().getStringExtra("kisUsername"), ""));
            intent.putExtra("map_talker_name", this.nYY);
            intent.putExtra("kIs_pick_poi", getIntent().getBooleanExtra("kIs_pick_poi", false));
            intent.putExtra("KFavLocSigleView", getIntent().getBooleanExtra("KFavLocSigleView", false));
            b rlVar = new rl();
            rlVar.fKc.fKd = true;
            com.tencent.mm.sdk.b.a.xmy.m(rlVar);
            if (this.type == 6) {
                intent.putExtra("kMsgId", getIntent().getLongExtra("kMsgId", -1));
                intent.putExtra("kRemark", getIntent().getStringExtra("kRemark"));
                if (this.zoom > 0) {
                    intent.putExtra("kwebmap_scale", this.zoom);
                }
                intent.putExtra("Kwebmap_locaion", this.info);
                intent.putExtra("soso_street_view_url", getIntent().getStringExtra("soso_street_view_url"));
                startActivityForResult(intent, 3);
                return;
            } else if (this.type == 1 || this.type == 2 || this.type == 7 || this.type == 9) {
                intent.putExtra("kMsgId", getIntent().getLongExtra("kMsgId", -1));
                intent.putExtra("kRemark", getIntent().getStringExtra("kRemark"));
                intent.putExtra("kTags", getIntent().getStringArrayListExtra("kTags"));
                if (this.zoom > 0) {
                    intent.putExtra("kwebmap_scale", this.zoom);
                }
                intent.putExtra("Kwebmap_locaion", this.info);
                intent.putExtra("soso_street_view_url", getIntent().getStringExtra("soso_street_view_url"));
                startActivityForResult(intent, 3);
                return;
            } else if (this.type == 0) {
                startActivityForResult(intent, 2);
                return;
            } else if (this.type == 3) {
                startActivityForResult(intent, 5);
                return;
            } else if (this.type == 8) {
                startActivityForResult(intent, 6);
                return;
            } else {
                return;
            }
        }
        finish();
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        x.i("MicroMsg.RedirectUI", "onAcvityResult requestCode:" + i);
        if (i2 != -1) {
            finish();
        } else if (intent == null) {
            finish();
        } else {
            LocationIntent locationIntent;
            switch (i) {
                case 2:
                    String str = this.nYY;
                    locationIntent = (LocationIntent) intent.getParcelableExtra("KLocationIntent");
                    x.i("MicroMsg.RedirectUI", "locationintent " + locationIntent.bEs());
                    b lzVar = new lz();
                    lzVar.fEm.fEo = this.nYZ;
                    lzVar.fEm.lat = locationIntent.lat;
                    lzVar.fEm.lng = locationIntent.lng;
                    lzVar.fEm.fAq = locationIntent.fAq;
                    lzVar.fEm.label = locationIntent.label;
                    lzVar.fEm.fEp = locationIntent.nYL;
                    com.tencent.mm.sdk.b.a.xmy.m(lzVar);
                    double d = locationIntent.lat;
                    double d2 = locationIntent.lng;
                    int i3 = locationIntent.fAq;
                    String str2 = locationIntent.label;
                    String str3 = locationIntent.nYL;
                    String str4 = locationIntent.vjB;
                    if (str3 == null) {
                        str3 = "";
                    }
                    str3 = "<msg><location x=\"" + d + "\" y=\"" + d2 + "\" scale=\"" + i3 + "\" label=\"" + bi.Wm(str2) + "\" poiname=\"" + bi.Wm(str3) + "\" infourl=\"" + bi.Wm(str4) + "\" maptype=\"0\" /></msg>";
                    x.d("MicroMsg.RedirectUI", "xml " + str3);
                    b otVar = new ot();
                    otVar.fHD.fHE = str;
                    otVar.fHD.content = str3;
                    otVar.fHD.type = 48;
                    otVar.fHD.flags = 0;
                    com.tencent.mm.sdk.b.a.xmy.m(otVar);
                    o.a(TXLiveConstants.PLAY_EVT_PLAY_BEGIN, (float) locationIntent.lng, (float) locationIntent.lat, 0);
                    break;
                case 5:
                    locationIntent = (LocationIntent) intent.getParcelableExtra("KLocationIntent");
                    x.i("MicroMsg.RedirectUI", "locationintent " + locationIntent.bEs());
                    if (locationIntent.vjC == 3) {
                        com.tencent.mm.plugin.report.service.g.pWK.h(10822, Integer.valueOf(1), locationIntent.nWi, Integer.valueOf(1));
                    } else {
                        com.tencent.mm.plugin.report.service.g.pWK.h(10822, Integer.valueOf(1), locationIntent.nWi, Integer.valueOf(0));
                    }
                    intent.putExtra("kwebmap_slat", locationIntent.lat);
                    intent.putExtra("kwebmap_lng", locationIntent.lng);
                    intent.putExtra("kwebmap_scale", locationIntent.fAq);
                    intent.putExtra("Kwebmap_locaion", locationIntent.label);
                    intent.putExtra("kTags", intent.getStringArrayListExtra("kTags"));
                    intent.putExtra("kPoiName", locationIntent.nYL.equals("") ? "" : locationIntent.nYL);
                    break;
                case 6:
                    locationIntent = (LocationIntent) intent.getParcelableExtra("KLocationIntent");
                    x.i("MicroMsg.RedirectUI", "locationintent " + locationIntent.bEs());
                    if (locationIntent.hzy != null) {
                        x.d("MicroMsg.RedirectUI", "addr: " + locationIntent.hzy.toString());
                    }
                    intent.putExtra("key_pick_addr", locationIntent.hzy);
                    break;
            }
            setResult(i2, intent);
            finish();
        }
    }

    protected void onDestroy() {
        this.nYp = false;
        super.onDestroy();
    }

    public void finish() {
        super.finish();
    }
}
