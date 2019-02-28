package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.ui.tools.AppChooserUI;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.lang.ref.WeakReference;
import java.net.URLEncoder;
import java.util.ArrayList;

public final class j implements com.tencent.mm.ui.MMActivity.a {
    WeakReference<Context> frC;
    com.tencent.mm.modelgeo.c hry = null;
    com.tencent.mm.modelgeo.b obF = null;
    boolean tQh = false;
    int tQi;
    e tQj;
    e tQk;
    String tQl;
    d tQm;
    com.tencent.mm.modelgeo.b.a tQn = null;
    com.tencent.mm.modelgeo.b.a tQo = null;
    com.tencent.mm.modelgeo.a.a tQp = null;
    final Runnable tQq = new Runnable() {
        public final void run() {
            if (j.this.tQp != null && j.this.hry != null) {
                j.this.obF.a(j.this.tQn);
                j.this.hry.c(j.this.tQp);
                j.this.tQp.a(false, 0.0f, 0.0f, 0, 0.0d, 0.0d, 0.0d);
            }
        }
    };
    int tzZ;

    private static abstract class f {
        protected abstract String getPackageName();

        private f() {
        }

        /* synthetic */ f(byte b) {
            this();
        }

        protected void a(Context context, e eVar, e eVar2, String str) {
            if (context != null) {
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("geo:" + eVar2.latitude + "," + eVar2.longitude));
                intent.setPackage(getPackageName());
                intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                context.startActivity(intent);
            }
        }
    }

    private static final class a extends f {
        private a() {
            super();
        }

        /* synthetic */ a(byte b) {
            this();
        }

        protected final void a(Context context, e eVar, e eVar2, String str) {
            if (context == null) {
                super.a(context, eVar, eVar2, str);
                return;
            }
            String format = String.format("baidumap://map/direction?destination=%f,%f&mode=driving", new Object[]{Double.valueOf(eVar2.latitude), Double.valueOf(eVar2.longitude)});
            if (eVar != null) {
                format = format + String.format("origin=%f,%f", new Object[]{Double.valueOf(eVar.latitude), Double.valueOf(eVar.longitude)});
            }
            x.d("MicroMsg.OpenMapNavigator", "url " + format);
            try {
                context.startActivity(Intent.parseUri(format + "&src=webapp.car.carroutelistmappg.weixindrivenav", 0));
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.OpenMapNavigator", e, "", new Object[0]);
            }
        }

        protected final String getPackageName() {
            return com.tencent.mm.pluginsdk.model.a.a.BaiduMap.getPackage();
        }
    }

    private static final class h extends f {
        private h() {
            super();
        }

        /* synthetic */ h(byte b) {
            this();
        }

        protected final void a(Context context, e eVar, e eVar2, String str) {
            if (context == null) {
                super.a(context, eVar, eVar2, str);
                return;
            }
            String format = String.format("sosomap://type=nav&tocoord=%f,%f", new Object[]{Double.valueOf(eVar2.longitude), Double.valueOf(eVar2.latitude)});
            if (eVar != null) {
                format = format + String.format("fromcoord=%f,%f", new Object[]{Double.valueOf(eVar.longitude), Double.valueOf(eVar.latitude)});
                if (!bi.oN(eVar.tQt)) {
                    format = format + String.format("&from=%s", new Object[]{URLEncoder.encode(eVar.tQt)});
                }
            }
            if (bi.oN(str)) {
                if (bi.oN(eVar2.tQt)) {
                    str = "地图选点";
                } else {
                    str = eVar2.tQt;
                }
            }
            format = format + String.format("&to=%s", new Object[]{URLEncoder.encode(str)});
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(format + "&referer=wx_client"));
            intent.setPackage(com.tencent.mm.pluginsdk.model.a.a.TencentMap.getPackage());
            context.startActivity(intent);
        }

        protected final String getPackageName() {
            return com.tencent.mm.pluginsdk.model.a.a.TencentMap.getPackage();
        }
    }

    private static final class b extends f {
        private b() {
            super();
        }

        /* synthetic */ b(byte b) {
            this();
        }

        protected final void a(Context context, e eVar, e eVar2, String str) {
            if (context == null) {
                super.a(context, eVar, eVar2, str);
                return;
            }
            String str2 = "android.intent.action.VIEW";
            Intent intent = new Intent(str2, Uri.parse(String.format("androidamap://navi?sourceApplication=%s&lat=%f&lon=%f&dev=1&style=2", new Object[]{"MicroMessager", Double.valueOf(eVar2.latitude), Double.valueOf(eVar2.longitude)})));
            intent.addCategory("android.intent.category.DEFAULT");
            intent.setPackage(com.tencent.mm.pluginsdk.model.a.a.AutonaviMap.getPackage());
            context.startActivity(intent);
        }

        protected final String getPackageName() {
            return com.tencent.mm.pluginsdk.model.a.a.AutonaviMap.getPackage();
        }
    }

    private static final class c extends f {
        private c() {
            super();
        }

        /* synthetic */ c(byte b) {
            this();
        }

        protected final void a(Context context, e eVar, e eVar2, String str) {
            if (context == null) {
                super.a(context, eVar, eVar2, str);
                return;
            }
            String format = String.format("http://maps.google.com/maps?f=d&daddr=%f,%f", new Object[]{Double.valueOf(eVar2.latitude), Double.valueOf(eVar2.longitude)});
            if (eVar != null) {
                format = format + String.format("&saddr=%f,%f", new Object[]{Double.valueOf(eVar.latitude), Double.valueOf(eVar.longitude)});
            }
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(format));
            intent.setClassName("com.google.android.apps.maps", "com.google.android.maps.MapsActivity");
            context.startActivity(intent);
        }

        protected final String getPackageName() {
            return com.tencent.mm.pluginsdk.model.a.a.GoogleMap.getPackage();
        }
    }

    interface d {
        void Bu(int i);

        void Bv(int i);

        void qi(int i);

        void vt(int i);
    }

    private static final class e {
        double latitude;
        double longitude;
        String tQt;

        /* synthetic */ e(double d, double d2, byte b) {
            this(d, d2);
        }

        private e(double d, double d2) {
            this.latitude = d;
            this.longitude = d2;
            this.tQt = null;
        }
    }

    private static final class g extends f {
        private g() {
            super();
        }

        /* synthetic */ g(byte b) {
            this();
        }

        protected final void a(Context context, e eVar, e eVar2, String str) {
            if (context == null) {
                super.a(context, eVar, eVar2, str);
                return;
            }
            String format = String.format("wechatnav://type=nav&tocoord=%f,%f", new Object[]{Double.valueOf(eVar2.latitude), Double.valueOf(eVar2.longitude)});
            if (eVar != null) {
                format = format + String.format("&fromcoord=%f,%f", new Object[]{Double.valueOf(eVar.latitude), Double.valueOf(eVar.longitude)});
                if (!bi.oN(eVar.tQt)) {
                    format = format + String.format("&from=%s", new Object[]{URLEncoder.encode(eVar.tQt)});
                }
            } else {
                format = format + String.format("&from=%s", new Object[]{"我的位置"});
            }
            if (bi.oN(str)) {
                if (bi.oN(eVar2.tQt)) {
                    str = "目的地";
                } else {
                    str = eVar2.tQt;
                }
            }
            String str2 = "android.intent.action.VIEW";
            Intent intent = new Intent(str2, Uri.parse(format + String.format("&to=%s", new Object[]{str})));
            intent.setPackage(com.tencent.mm.pluginsdk.model.a.a.SogouMap.getPackage());
            context.startActivity(intent);
        }

        protected final String getPackageName() {
            return com.tencent.mm.pluginsdk.model.a.a.SogouMap.getPackage();
        }
    }

    public final void b(int i, int i2, Intent intent) {
        Context context = (Context) this.frC.get();
        if (!(this.tQm == null || context == null)) {
            if (!this.tQh) {
                x.e("MicroMsg.OpenMapNavigator", "onActivityResult called without msgId attached...");
            } else if (i != 33) {
                x.e("MicroMsg.OpenMapNavigator", "onActivityResult, mismatched request_code = %d", Integer.valueOf(i));
                this.tQm.qi(this.tzZ);
            } else if (i2 == 4097 || i2 == 0) {
                this.tQm.Bu(this.tzZ);
            } else if (i2 == -1) {
                String stringExtra = intent.getStringExtra("selectpkg");
                if (bi.oN(stringExtra)) {
                    x.e("MicroMsg.OpenMapNavigator", "onActivityResult, get null packageName");
                    this.tQm.qi(this.tzZ);
                } else {
                    f cVar = com.tencent.mm.pluginsdk.model.a.a.GoogleMap.getPackage().equals(stringExtra) ? new c() : com.tencent.mm.pluginsdk.model.a.a.BaiduMap.getPackage().equals(stringExtra) ? new a() : com.tencent.mm.pluginsdk.model.a.a.SogouMap.getPackage().equals(stringExtra) ? new g() : com.tencent.mm.pluginsdk.model.a.a.AutonaviMap.getPackage().equals(stringExtra) ? new b() : new h();
                    cVar.a(context, this.tQj, this.tQk, this.tQl);
                    this.tQm.vt(this.tzZ);
                }
            } else {
                x.e("MicroMsg.OpenMapNavigator", "onActivityResult, not support result_code = %d", Integer.valueOf(i2));
                this.tQm.qi(this.tzZ);
            }
        }
        if (this.tQh && this.tQm != null) {
            this.tQm.Bv(this.tzZ);
        }
        this.tQh = false;
        this.tQi = com.tencent.mm.pluginsdk.model.a.a.TencentMap.code;
        this.tQj = null;
        this.tQk = null;
        this.frC = null;
        this.tQm = null;
        this.tQl = null;
        this.tQn = null;
        this.tQo = null;
        if (!(this.hry == null || this.tQp == null)) {
            this.hry.c(this.tQp);
        }
        this.hry = null;
        this.tQp = null;
        if (this.obF != null) {
            if (this.tQn != null) {
                this.obF.a(this.tQn);
            }
            if (this.tQo != null) {
                this.obF.a(this.tQo);
            }
        }
        this.obF = null;
        this.tQn = null;
        this.tQo = null;
    }

    j() {
    }

    final void bVB() {
        Context context = null;
        this.tQp = null;
        this.tQn = null;
        this.tQo = null;
        if (this.frC != null) {
            context = (Context) this.frC.get();
        }
        if (context != null) {
            Intent intent = new Intent(context, AppChooserUI.class);
            ArrayList arrayList = new ArrayList(5);
            arrayList.add(com.tencent.mm.pluginsdk.model.a.a.TencentMap.getPackage());
            arrayList.add(com.tencent.mm.pluginsdk.model.a.a.GoogleMap.getPackage());
            arrayList.add(com.tencent.mm.pluginsdk.model.a.a.SogouMap.getPackage());
            arrayList.add(com.tencent.mm.pluginsdk.model.a.a.BaiduMap.getPackage());
            arrayList.add(com.tencent.mm.pluginsdk.model.a.a.AutonaviMap.getPackage());
            intent.putStringArrayListExtra("targetwhitelist", arrayList);
            Parcelable intent2 = new Intent("android.intent.action.VIEW", Uri.parse(String.format("geo:%f,%f", new Object[]{Double.valueOf(this.tQk.latitude), Double.valueOf(this.tQk.longitude)})));
            intent.putExtra("targetintent", intent2);
            Bundle bundle = new Bundle(2);
            bundle.putInt("key_map_app", this.tQi);
            bundle.putParcelable("key_target_intent", intent2);
            intent.putExtra("key_recommend_params", bundle);
            intent.putExtra(Columns.TYPE, 2);
            intent.putExtra("title", context.getString(R.l.etn));
            ((MMActivity) context).b(this, intent, 33);
        }
    }
}
