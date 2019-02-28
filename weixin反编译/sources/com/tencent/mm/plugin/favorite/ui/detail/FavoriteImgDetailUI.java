package com.tencent.mm.plugin.favorite.ui.detail;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import com.tencent.mm.R;
import com.tencent.mm.a.e;
import com.tencent.mm.f.a.ca;
import com.tencent.mm.f.a.mr;
import com.tencent.mm.f.a.mt;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.fav.a.f;
import com.tencent.mm.plugin.fav.a.i;
import com.tencent.mm.plugin.fav.ui.detail.BaseFavDetailReportUI;
import com.tencent.mm.plugin.favorite.a.j;
import com.tencent.mm.plugin.favorite.h;
import com.tencent.mm.plugin.favorite.ui.FavImgGalleryUI;
import com.tencent.mm.plugin.favorite.ui.FavTagEditUI;
import com.tencent.mm.plugin.favorite.ui.base.FavDetailFooterView;
import com.tencent.mm.plugin.favorite.ui.base.FavDetailTitleView;
import com.tencent.mm.plugin.favorite.ui.base.FavTagEntrance;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.uz;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.base.p.d;
import com.tencent.mm.ui.base.r;
import com.tencent.mm.ui.tools.l;
import com.tencent.mm.ui.widget.MMLoadScrollView;
import com.tencent.mm.y.as;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

public class FavoriteImgDetailUI extends BaseFavDetailReportUI implements i {
    private LinearLayout mCl;
    private FavDetailTitleView mCm;
    private FavDetailFooterView mCn;
    private FavTagEntrance mCo;
    private int mCp = 0;
    private f mCq;
    private HashMap<String, a> mCr = new HashMap();
    private Bitmap mCs;
    private boolean mCt = true;
    private OnLongClickListener mCu = new OnLongClickListener() {
        public final boolean onLongClick(View view) {
            a aVar = (a) FavoriteImgDetailUI.this.mCr.get(((uz) view.getTag()).mBr);
            FavoriteImgDetailUI.a(FavoriteImgDetailUI.this, aVar);
            if (!aVar.mCC) {
                FavoriteImgDetailUI.b(aVar);
            }
            return true;
        }
    };
    private OnClickListener myR = new OnClickListener() {
        public final void onClick(View view) {
            Intent intent = new Intent(FavoriteImgDetailUI.this.mController.xRr, FavImgGalleryUI.class);
            intent.putExtra("key_detail_info_id", FavoriteImgDetailUI.this.mCq.field_localId);
            intent.putExtra("key_detail_data_id", ((uz) view.getTag()).mBr);
            FavoriteImgDetailUI.this.startActivity(intent);
            com.tencent.mm.plugin.fav.a.g.a f = FavoriteImgDetailUI.this.muu;
            f.mtN++;
        }
    };
    private c myb = new c<mt>() {
        {
            this.xmG = mt.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            mt mtVar = (mt) bVar;
            String str = mtVar.fFy.filePath;
            a aVar = null;
            for (a aVar2 : FavoriteImgDetailUI.this.mCr.values()) {
                a aVar22;
                if (!str.equals(j.h(aVar22.fvZ))) {
                    aVar22 = aVar;
                }
                aVar = aVar22;
            }
            if (aVar != null) {
                aVar.mCD = bi.aD(mtVar.fFy.result, "");
                aVar.fqW = mtVar.fFy.fqW;
                aVar.fqX = mtVar.fFy.fqX;
                if (!bi.oN(aVar.mCD) && aVar.jqz.rQE.isShowing()) {
                    FavoriteImgDetailUI.a(FavoriteImgDetailUI.this, aVar);
                }
            }
            return true;
        }
    };

    private class a {
        int fqW;
        int fqX;
        uz fvZ;
        ImageView fwa;
        l jqz;
        boolean mCC;
        String mCD;

        private a() {
            this.jqz = new l(FavoriteImgDetailUI.this.mController.xRr);
            this.mCC = false;
            this.mCD = null;
            this.fqW = 0;
            this.fqX = 0;
        }

        /* synthetic */ a(FavoriteImgDetailUI favoriteImgDetailUI, byte b) {
            this();
        }
    }

    static /* synthetic */ void a(FavoriteImgDetailUI favoriteImgDetailUI, final a aVar) {
        l lVar = aVar.jqz;
        lVar.rQF = new p.c() {
            public final void a(n nVar) {
                if (FavoriteImgDetailUI.this.mCt) {
                    if (FavoriteImgDetailUI.this.mCq.aIq()) {
                        nVar.f(2, FavoriteImgDetailUI.this.mController.xRr.getString(R.l.egM));
                    }
                    if (FavoriteImgDetailUI.this.mCq.aIr()) {
                        nVar.f(1, FavoriteImgDetailUI.this.mController.xRr.getString(R.l.ego));
                    }
                    nVar.f(3, FavoriteImgDetailUI.this.mController.xRr.getString(R.l.egH));
                    if (!bi.oN(aVar.mCD)) {
                        nVar.eT(4, com.tencent.mm.plugin.scanner.a.aF(aVar.fqW, aVar.mCD) ? R.l.egu : R.l.egt);
                    }
                }
            }
        };
        lVar.rQG = new d() {
            public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                String h = j.h(aVar.fvZ);
                if (e.bO(h)) {
                    switch (menuItem.getItemId()) {
                        case 1:
                            com.tencent.mm.plugin.favorite.d.c(h, FavoriteImgDetailUI.this.mController.xRr);
                            g.pWK.h(10651, Integer.valueOf(2), Integer.valueOf(0), Integer.valueOf(0));
                            return;
                        case 2:
                            if (com.tencent.mm.sdk.platformtools.p.Vw(h)) {
                                Intent intent = new Intent();
                                intent.putExtra("Select_Conv_Type", 3);
                                intent.putExtra("select_is_ret", true);
                                com.tencent.mm.bl.d.a(FavoriteImgDetailUI.this, ".ui.transmit.SelectConversationUI", intent, 1);
                            } else {
                                com.tencent.mm.plugin.favorite.d.d(h, FavoriteImgDetailUI.this.mController.xRr);
                            }
                            g.pWK.h(10651, Integer.valueOf(2), Integer.valueOf(1), Integer.valueOf(0));
                            return;
                        case 3:
                            com.tencent.mm.plugin.favorite.d.a(h, FavoriteImgDetailUI.this.getString(R.l.egG), FavoriteImgDetailUI.this.mController.xRr);
                            return;
                        case 4:
                            x.i("MicroMsg.FavoriteImgDetailUI", "request deal QBAR string");
                            b caVar = new ca();
                            caVar.fqV.activity = FavoriteImgDetailUI.this;
                            caVar.fqV.fpo = aVar.mCD;
                            caVar.fqV.fqW = aVar.fqW;
                            caVar.fqV.fqY = 7;
                            if (aVar.fvZ != null) {
                                caVar.fqV.imagePath = aVar.fvZ.wjN;
                                caVar.fqV.frb = aVar.fvZ.wjP;
                            }
                            caVar.fqV.fqX = aVar.fqX;
                            Bundle bundle = new Bundle(1);
                            bundle.putInt("stat_scene", 5);
                            caVar.fqV.frc = bundle;
                            com.tencent.mm.sdk.b.a.xmy.m(caVar);
                            return;
                        default:
                            return;
                    }
                }
                x.w("MicroMsg.FavoriteImgDetailUI", "file not exists");
            }
        };
        lVar.bCH();
    }

    static /* synthetic */ void a(FavoriteImgDetailUI favoriteImgDetailUI, a aVar, Bitmap bitmap) {
        int i = 0;
        if (bitmap == null) {
            bitmap = favoriteImgDetailUI.k(aVar.fvZ);
        }
        if (bitmap != null) {
            x.d("MicroMsg.FavoriteImgDetailUI", "update view bmp[%d, %d], displayWidth %d", Integer.valueOf(bitmap.getWidth()), Integer.valueOf(bitmap.getHeight()), Integer.valueOf(favoriteImgDetailUI.mCp));
        }
        if (bitmap.getWidth() > favoriteImgDetailUI.mCp / 3) {
            LayoutParams layoutParams = aVar.fwa.getLayoutParams();
            layoutParams.height = (int) ((((float) favoriteImgDetailUI.mCp) / ((float) bitmap.getWidth())) * ((float) bitmap.getHeight()));
            if (layoutParams.height > 2048) {
                int width = bitmap.getWidth();
                int height = bitmap.getHeight();
                if (VERSION.SDK_INT >= 11) {
                    com.tencent.mm.sdk.platformtools.n nVar = new com.tencent.mm.sdk.platformtools.n();
                    if (width >= 2048 || height >= 2048) {
                        i = 1;
                    }
                }
                if (i != 0) {
                    layoutParams.height = WXMediaMessage.TITLE_LENGTH_LIMIT;
                    aVar.fwa.setScaleType(ScaleType.CENTER_CROP);
                } else {
                    aVar.fwa.setScaleType(ScaleType.FIT_XY);
                }
            } else {
                aVar.fwa.setScaleType(ScaleType.FIT_XY);
            }
        } else {
            LayoutParams layoutParams2 = aVar.fwa.getLayoutParams();
            if (bitmap.getHeight() > 2048) {
                layoutParams2.height = WXMediaMessage.TITLE_LENGTH_LIMIT;
                aVar.fwa.setScaleType(ScaleType.CENTER_CROP);
            } else {
                if (aVar.fwa.getMinimumWidth() > bitmap.getWidth()) {
                    layoutParams2.width = aVar.fwa.getMinimumWidth();
                }
                aVar.fwa.setScaleType(ScaleType.FIT_CENTER);
            }
        }
        com.tencent.mm.sdk.platformtools.l.k(aVar.fwa, bitmap.getWidth(), bitmap.getHeight());
        String h = j.h(aVar.fvZ);
        if (com.tencent.mm.sdk.platformtools.p.Vw(h)) {
            try {
                Drawable cW = com.tencent.mm.plugin.gif.b.aSR().cW(h + "_detail", h);
                aVar.fwa.setImageDrawable(cW);
                cW.stop();
                cW.start();
                return;
            } catch (Exception e) {
            }
        }
        aVar.fwa.setImageBitmap(bitmap);
    }

    static /* synthetic */ void b(a aVar) {
        b mrVar = new mr();
        mrVar.fFv.filePath = j.h(aVar.fvZ);
        com.tencent.mm.sdk.b.a.xmy.m(mrVar);
        aVar.mCC = true;
    }

    protected final MMLoadScrollView aIS() {
        return (MMLoadScrollView) findViewById(R.h.cJn);
    }

    protected final int getLayoutId() {
        return R.i.dib;
    }

    public void onCreate(Bundle bundle) {
        com.tencent.mm.pluginsdk.e.h(this);
        super.onCreate(bundle);
        aKp();
        this.mCl = (LinearLayout) findViewById(R.h.cgS);
        this.mCm = (FavDetailTitleView) findViewById(R.h.cgB);
        this.mCn = (FavDetailFooterView) findViewById(R.h.cgA);
        this.mCo = (FavTagEntrance) findViewById(R.h.chk);
        this.mCq = h.getFavItemInfoStorage().dc(getIntent().getLongExtra("key_detail_info_id", -1));
        if (this.mCq == null) {
            finish();
            return;
        }
        h(this.mCq);
        this.mCm.F(this.mCq);
        this.mCn.F(this.mCq);
        Iterator it = this.mCq.field_favProto.wlY.iterator();
        int i = 0;
        while (it.hasNext()) {
            uz uzVar = (uz) it.next();
            x.d("MicroMsg.FavoriteImgDetailUI", "index[%d], dataid[%s]", Integer.valueOf(i), uzVar.mBr);
            a aVar = new a();
            aVar.fvZ = uzVar;
            int i2 = i + 1;
            View imageView = new ImageView(this.mController.xRr);
            int dimensionPixelSize = getResources().getDimensionPixelSize(R.f.bvT);
            LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            if (i > 0) {
                layoutParams.topMargin = dimensionPixelSize;
            }
            this.mCl.addView(imageView, layoutParams);
            imageView.setTag(uzVar);
            i = dimensionPixelSize / 2;
            imageView.setScaleType(ScaleType.CENTER_INSIDE);
            imageView.setPadding(i, i, i, i);
            imageView.setMinimumWidth(com.tencent.mm.bu.a.fromDPToPix(this.mController.xRr, 50));
            imageView.setMinimumHeight(com.tencent.mm.bu.a.fromDPToPix(this.mController.xRr, 50));
            imageView.setImageResource(R.k.dyJ);
            imageView.setOnClickListener(this.myR);
            imageView.setOnLongClickListener(this.mCu);
            aVar.fwa = imageView;
            this.mCr.put(uzVar.mBr, aVar);
            a(aVar);
            if (uzVar.wkV != 0) {
                this.mCt = false;
            }
            i = i2;
        }
        this.mCo.dt(this.mCq.field_localId);
        this.mCo.aP(this.mCq.field_tagProto.wmn);
        setMMTitle(getString(R.l.eeX));
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                FavoriteImgDetailUI.this.finish();
                return true;
            }
        });
        addIconOptionMenu(0, R.l.eRy, R.k.dvj, new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                com.tencent.mm.ui.widget.g gVar = new com.tencent.mm.ui.widget.g(FavoriteImgDetailUI.this.mController.xRr, com.tencent.mm.ui.widget.g.zCt, false);
                gVar.rQF = new p.c() {
                    public final void a(n nVar) {
                        if (FavoriteImgDetailUI.this.mCt) {
                            nVar.f(2, FavoriteImgDetailUI.this.getString(R.l.egM));
                        }
                        nVar.f(0, FavoriteImgDetailUI.this.getString(R.l.efl));
                        nVar.f(1, FavoriteImgDetailUI.this.mController.xRr.getString(R.l.dEH));
                    }
                };
                gVar.rQG = new d() {
                    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                        Intent intent;
                        com.tencent.mm.plugin.fav.a.g.a c;
                        switch (menuItem.getItemId()) {
                            case 0:
                                intent = new Intent(FavoriteImgDetailUI.this.mController.xRr, FavTagEditUI.class);
                                intent.putExtra("key_fav_scene", 2);
                                intent.putExtra("key_fav_item_id", FavoriteImgDetailUI.this.mCq.field_localId);
                                FavoriteImgDetailUI.this.mController.xRr.startActivity(intent);
                                c = FavoriteImgDetailUI.this.muu;
                                c.mtR++;
                                return;
                            case 1:
                                com.tencent.mm.ui.base.h.a(FavoriteImgDetailUI.this.mController.xRr, FavoriteImgDetailUI.this.getString(R.l.dEI), "", new DialogInterface.OnClickListener() {
                                    public final void onClick(DialogInterface dialogInterface, int i) {
                                        final r a = com.tencent.mm.ui.base.h.a(FavoriteImgDetailUI.this.mController.xRr, FavoriteImgDetailUI.this.getString(R.l.dEI), false, null);
                                        j.a(FavoriteImgDetailUI.this.mCq.field_localId, new Runnable() {
                                            public final void run() {
                                                FavoriteImgDetailUI.this.muu.mtS = true;
                                                a.dismiss();
                                                x.d("MicroMsg.FavoriteImgDetailUI", "do del, local id %d", Long.valueOf(FavoriteImgDetailUI.this.mCq.field_localId));
                                                FavoriteImgDetailUI.this.finish();
                                            }
                                        });
                                    }
                                }, null);
                                return;
                            case 2:
                                intent = new Intent();
                                intent.putExtra("Select_Conv_Type", 3);
                                intent.putExtra("scene_from", 1);
                                intent.putExtra("mutil_select_is_ret", true);
                                intent.putExtra("select_fav_local_id", FavoriteImgDetailUI.this.mCq.field_localId);
                                com.tencent.mm.bl.d.a(FavoriteImgDetailUI.this, ".ui.transmit.SelectConversationUI", intent, 1);
                                g.pWK.h(10651, Integer.valueOf(2), Integer.valueOf(1), Integer.valueOf(0));
                                c = FavoriteImgDetailUI.this.muu;
                                c.mtO++;
                                return;
                            default:
                                return;
                        }
                    }
                };
                gVar.bUX();
                return true;
            }
        });
        com.tencent.mm.pluginsdk.e.i(this);
        h.getFavItemInfoStorage().c(this.mCo);
        h.aIZ().a(this);
        com.tencent.mm.sdk.b.a.xmy.b(this.myb);
    }

    protected void onResume() {
        super.onResume();
        for (Entry value : this.mCr.entrySet()) {
            a((a) value.getValue());
        }
    }

    protected void onDestroy() {
        h.getFavItemInfoStorage().j(this.mCo);
        h.aIZ().b((i) this);
        com.tencent.mm.sdk.b.a.xmy.c(this.myb);
        super.onDestroy();
    }

    private void aKp() {
        DisplayMetrics displayMetrics;
        if (ad.getResources() != null) {
            displayMetrics = ad.getResources().getDisplayMetrics();
        } else {
            displayMetrics = getResources().getDisplayMetrics();
        }
        this.mCp = displayMetrics.widthPixels - (getResources().getDimensionPixelOffset(R.f.buY) * 2);
        this.mCp = Math.max(this.mCp, 0);
        x.d("MicroMsg.FavoriteImgDetailUI", "update display width %d", Integer.valueOf(this.mCp));
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        aKp();
        for (Entry value : this.mCr.entrySet()) {
            a((a) value.getValue());
        }
    }

    protected final String i(f fVar) {
        long j = 0;
        Iterator it = fVar.field_favProto.wlY.iterator();
        while (true) {
            long j2 = j;
            if (!it.hasNext()) {
                return String.valueOf(j2);
            }
            uz uzVar = (uz) it.next();
            j = uzVar.wki + (j2 + uzVar.wkt);
        }
    }

    private void a(final a aVar) {
        as.Dt().F(new Runnable() {
            public final void run() {
                Bitmap a = com.tencent.mm.plugin.favorite.b.h.a(aVar.fvZ, FavoriteImgDetailUI.this.mCq, false);
                if (a == null) {
                    x.d("MicroMsg.FavoriteImgDetailUI", "get big img fail");
                    a = FavoriteImgDetailUI.this.k(aVar.fvZ);
                }
                ah.y(new Runnable() {
                    public final void run() {
                        FavoriteImgDetailUI.a(FavoriteImgDetailUI.this, aVar, a);
                    }

                    public final String toString() {
                        return super.toString() + "|renderView";
                    }
                });
            }
        });
    }

    private Bitmap k(uz uzVar) {
        boolean z = true;
        Bitmap a = com.tencent.mm.plugin.favorite.b.h.a(uzVar, this.mCq);
        String str = "MicroMsg.FavoriteImgDetailUI";
        String str2 = "get thumb ok ? %B";
        Object[] objArr = new Object[1];
        if (a == null) {
            z = false;
        }
        objArr[0] = Boolean.valueOf(z);
        x.d(str, str2, objArr);
        if (a != null) {
            return a;
        }
        if (this.mCs == null) {
            this.mCs = com.tencent.mm.compatible.g.a.decodeResource(getResources(), R.k.dyJ);
        }
        return this.mCs;
    }

    public final void a(com.tencent.mm.plugin.fav.a.c cVar) {
        if (cVar != null && cVar.isFinished()) {
            x.d("MicroMsg.FavoriteImgDetailUI", "on cdn status change, dataid[%s]", cVar.field_dataId);
            a aVar = (a) this.mCr.get(cVar.field_dataId);
            if (aVar != null) {
                a(aVar);
            }
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        if (1 == i) {
            if (-1 == i2) {
                com.tencent.mm.plugin.favorite.a.d dVar = new com.tencent.mm.plugin.favorite.a.d();
                if (com.tencent.mm.plugin.favorite.a.d.k(this.mCq)) {
                    com.tencent.mm.ui.base.h.bu(this.mController.xRr, getString(R.l.dBY));
                    return;
                }
                String stringExtra = intent.getStringExtra("Select_Conv_User");
                String stringExtra2 = intent.getStringExtra("custom_send_text");
                x.d("MicroMsg.FavoriteImgDetailUI", "select %s for sending", stringExtra);
                final Dialog a = com.tencent.mm.ui.base.h.a(this.mController.xRr, getString(R.l.efM), false, null);
                com.tencent.mm.plugin.favorite.a.e.a(this.mController.xRr, stringExtra, stringExtra2, this.mCq, new Runnable() {
                    public final void run() {
                        a.dismiss();
                        com.tencent.mm.ui.snackbar.a.h(FavoriteImgDetailUI.this, FavoriteImgDetailUI.this.getString(R.l.eip));
                    }
                });
            } else {
                return;
            }
        }
        super.onActivityResult(i, i2, intent);
    }
}
