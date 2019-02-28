package com.tencent.mm.plugin.favorite.ui.detail;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.fav.a.f;
import com.tencent.mm.plugin.fav.a.i;
import com.tencent.mm.plugin.fav.ui.detail.BaseFavDetailReportUI;
import com.tencent.mm.plugin.favorite.a.d;
import com.tencent.mm.plugin.favorite.a.j;
import com.tencent.mm.plugin.favorite.b.b;
import com.tencent.mm.plugin.favorite.h;
import com.tencent.mm.plugin.favorite.ui.FavTagEditUI;
import com.tencent.mm.plugin.favorite.ui.base.FavDetailFooterView;
import com.tencent.mm.plugin.favorite.ui.base.FavDetailTitleView;
import com.tencent.mm.plugin.favorite.ui.base.FavTagEntrance;
import com.tencent.mm.pluginsdk.e;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerTextureView;
import com.tencent.mm.protocal.c.uz;
import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.base.p.c;
import com.tencent.mm.ui.base.r;
import com.tencent.mm.ui.widget.MMLoadScrollView;
import com.tencent.mm.ui.widget.MMPinProgressBtn;
import com.tencent.mm.ui.widget.g;
import com.tencent.mm.y.m;
import com.tencent.mm.y.s;

public class FavoriteSightDetailUI extends BaseFavDetailReportUI implements i, a {
    private uz fvZ;
    private boolean mBR = false;
    private boolean mBX = false;
    private ImageView mBj;
    private boolean mBo = false;
    private FavDetailTitleView mCE;
    private FavDetailFooterView mCF;
    private FavTagEntrance mCG;
    private View mCH;
    private ImageView mCI;
    private MMPinProgressBtn mCJ;
    private VideoPlayerTextureView mCK;
    private long mCL;
    private boolean mCM = true;
    private Runnable mCN = new Runnable() {
        public final void run() {
            if (!FavoriteSightDetailUI.this.mzi.isDone() || !j.e(FavoriteSightDetailUI.this.fvZ) || FavoriteSightDetailUI.this.mCK == null || !FavoriteSightDetailUI.this.mCK.isPlaying()) {
                FavoriteSightDetailUI.this.fl(true);
            }
        }
    };
    private boolean mCO = false;
    private d mze = new d();
    private f mzi;

    static /* synthetic */ void a(FavoriteSightDetailUI favoriteSightDetailUI, boolean z, Context context) {
        uz p = j.p(favoriteSightDetailUI.mzi);
        Intent intent;
        if (p == null) {
            x.e("MicroMsg.FavoriteSightDetailUI", "goPlayView, but dataitem is null , exit");
        } else if (p.wkN == null || (bi.oN(p.wkN.heZ) && bi.oN(p.wkN.hfd))) {
            intent = new Intent(context, FavoriteVideoPlayUI.class);
            intent.putExtra("key_detail_fav_scene", favoriteSightDetailUI.muu.scene);
            intent.putExtra("key_detail_fav_sub_scene", favoriteSightDetailUI.muu.mtU);
            intent.putExtra("key_detail_fav_path", j.h(p));
            intent.putExtra("key_detail_fav_thumb_path", j.i(p));
            intent.putExtra("key_detail_fav_video_duration", p.duration);
            intent.putExtra("key_detail_statExtStr", p.fHB);
            intent.putExtra("key_detail_data_valid", z);
            context.startActivity(intent);
        } else {
            x.i("MicroMsg.FavoriteSightDetailUI", "it is ad sight.use sight play");
            intent = new Intent(context, FavoriteFileDetailUI.class);
            intent.putExtra("key_detail_fav_scene", favoriteSightDetailUI.muu.scene);
            intent.putExtra("key_detail_fav_sub_scene", favoriteSightDetailUI.muu.mtU);
            intent.putExtra("key_detail_info_id", favoriteSightDetailUI.mzi.field_localId);
            intent.putExtra("key_detail_data_id", p.mBr);
            intent.putExtra("key_detail_can_delete", false);
            context.startActivity(intent);
        }
    }

    protected final int getLayoutId() {
        return R.i.dic;
    }

    protected final MMLoadScrollView aIS() {
        return (MMLoadScrollView) findViewById(R.h.cJn);
    }

    protected final int getForceOrientation() {
        return 1;
    }

    public void onCreate(Bundle bundle) {
        e.h(this);
        super.onCreate(bundle);
        this.mCL = getIntent().getLongExtra("key_detail_info_id", -1);
        this.mzi = h.getFavItemInfoStorage().dc(this.mCL);
        if (this.mzi == null) {
            x.w("MicroMsg.FavoriteSightDetailUI", "id[%d] info is null, return", Long.valueOf(this.mCL));
            finish();
            return;
        }
        h(this.mzi);
        com.tencent.mm.plugin.favorite.a.h.m(this.mzi);
        this.fvZ = j.p(this.mzi);
        this.mCE = (FavDetailTitleView) findViewById(R.h.cgB);
        this.mCF = (FavDetailFooterView) findViewById(R.h.cgA);
        this.mCG = (FavTagEntrance) findViewById(R.h.chk);
        this.mCI = (ImageView) findViewById(R.h.cPs);
        this.mCJ = (MMPinProgressBtn) findViewById(R.h.cVq);
        this.mCH = findViewById(R.h.bWj);
        this.mCK = (VideoPlayerTextureView) findViewById(R.h.cVJ);
        this.mBj = (ImageView) findViewById(R.h.cVD);
        this.mCG.dt(this.mzi.field_localId);
        this.mCG.aP(this.mzi.field_tagProto.wmn);
        this.mCE.F(this.mzi);
        this.mCF.F(this.mzi);
        this.mCH.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                if (!com.tencent.mm.o.a.aW(view.getContext()) && !com.tencent.mm.o.a.aU(view.getContext())) {
                    x.i("MicroMsg.FavoriteSightDetailUI", "click item favid %d, localid %d, itemstatus %d", Integer.valueOf(FavoriteSightDetailUI.this.mzi.field_id), Long.valueOf(FavoriteSightDetailUI.this.mzi.field_localId), Integer.valueOf(FavoriteSightDetailUI.this.mzi.field_itemStatus));
                    if (FavoriteSightDetailUI.this.mzi.isDone()) {
                        if (j.e(FavoriteSightDetailUI.this.fvZ)) {
                            com.tencent.mm.plugin.favorite.a.h.a(com.tencent.mm.plugin.favorite.a.h.a.EnterFullScreen, FavoriteSightDetailUI.this.mzi);
                            FavoriteSightDetailUI.a(FavoriteSightDetailUI.this, true, view.getContext());
                            return;
                        } else if (bi.oN(FavoriteSightDetailUI.this.fvZ.wjN)) {
                            FavoriteSightDetailUI.a(FavoriteSightDetailUI.this, false, view.getContext());
                            return;
                        } else {
                            x.w("MicroMsg.FavoriteSightDetailUI", "? info is done, source file not exist, cdn data url is not null");
                        }
                    } else if (FavoriteSightDetailUI.this.mzi.aIu()) {
                        if (bi.oN(FavoriteSightDetailUI.this.fvZ.wjN)) {
                            FavoriteSightDetailUI.a(FavoriteSightDetailUI.this, false, view.getContext());
                            return;
                        }
                    } else if (FavoriteSightDetailUI.this.mzi.isDownloading() || FavoriteSightDetailUI.this.mzi.aIs()) {
                        if (FavoriteSightDetailUI.this.mCJ.getVisibility() == 8) {
                            FavoriteSightDetailUI.this.fl(false);
                            return;
                        }
                        return;
                    }
                    if (FavoriteSightDetailUI.this.mzi.aIt()) {
                        j.n(FavoriteSightDetailUI.this.mzi);
                    } else {
                        j.o(FavoriteSightDetailUI.this.mzi);
                    }
                    FavoriteSightDetailUI.this.fl(false);
                }
            }
        });
        this.mCK.qAJ = new com.tencent.mm.pluginsdk.ui.tools.f.a() {
            public final void hY() {
                x.i("MicroMsg.FavoriteSightDetailUI", " onPrepared");
                FavoriteSightDetailUI.this.mCK;
                FavoriteSightDetailUI.this.mBo = FavoriteSightDetailUI.this.mCK.start();
                ah.y(new Runnable() {
                    public final void run() {
                        FavoriteSightDetailUI.this.mBj.setVisibility(8);
                    }
                });
            }

            public final void onError(int i, int i2) {
                x.e("MicroMsg.FavoriteSightDetailUI", "VideoPlay: on play video error what %d extra %d.", Integer.valueOf(i), Integer.valueOf(i2));
                if (i == -1) {
                    FavoriteSightDetailUI.this.mCK.stop();
                    if (com.tencent.mm.a.e.bO(j.h(FavoriteSightDetailUI.this.fvZ))) {
                        FavoriteSightDetailUI.this.aKq();
                    } else if (com.tencent.mm.a.e.bO(j.i(FavoriteSightDetailUI.this.fvZ))) {
                        FavoriteSightDetailUI.this.mBj.setVisibility(0);
                    }
                } else if (FavoriteSightDetailUI.this.mBo) {
                    vi();
                } else {
                    FavoriteSightDetailUI.this.mCK.stop();
                    if (!FavoriteSightDetailUI.this.mBR) {
                        FavoriteSightDetailUI.this.mBR = true;
                        ah.y(new Runnable() {
                            public final void run() {
                                com.tencent.mm.ui.base.h.h(FavoriteSightDetailUI.this.mController.xRr, R.l.eTs, R.l.dSM);
                            }
                        });
                    }
                }
            }

            public final void vi() {
                FavoriteSightDetailUI.this.mCK.q(0.0d);
            }

            public final int ck(int i, int i2) {
                return 0;
            }

            public final void cl(int i, int i2) {
            }
        };
        setMMTitle(getString(R.l.eeX));
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                FavoriteSightDetailUI.this.finish();
                return true;
            }
        });
        addIconOptionMenu(0, R.l.eRy, R.g.bDJ, new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                g gVar = new g(FavoriteSightDetailUI.this.mController.xRr, g.zCt, false);
                gVar.rQF = new c() {
                    public final void a(n nVar) {
                        int i = (!FavoriteSightDetailUI.this.mzi.aIq() || FavoriteSightDetailUI.this.mze.e(FavoriteSightDetailUI.this.mzi)) ? 0 : 1;
                        if (i != 0 && FavoriteSightDetailUI.this.fvZ.wkV == 0) {
                            nVar.f(0, FavoriteSightDetailUI.this.getString(R.l.egM));
                        }
                        nVar.f(3, FavoriteSightDetailUI.this.getString(R.l.efl));
                        nVar.f(2, FavoriteSightDetailUI.this.mController.xRr.getString(R.l.dEH));
                    }
                };
                gVar.rQG = new p.d() {
                    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                        Intent intent;
                        com.tencent.mm.plugin.fav.a.g.a k;
                        switch (menuItem.getItemId()) {
                            case 0:
                                com.tencent.mm.plugin.report.service.g.pWK.h(10651, Integer.valueOf(FavoriteSightDetailUI.this.mzi.field_type), Integer.valueOf(1), Integer.valueOf(0));
                                intent = new Intent();
                                intent.putExtra("Select_Conv_Type", 3);
                                intent.putExtra("scene_from", 1);
                                intent.putExtra("mutil_select_is_ret", true);
                                intent.putExtra("select_fav_local_id", FavoriteSightDetailUI.this.mzi.field_localId);
                                com.tencent.mm.bl.d.a(FavoriteSightDetailUI.this.mController.xRr, ".ui.transmit.SelectConversationUI", intent, 1);
                                k = FavoriteSightDetailUI.this.muu;
                                k.mtO++;
                                return;
                            case 2:
                                com.tencent.mm.ui.base.h.a(FavoriteSightDetailUI.this.mController.xRr, FavoriteSightDetailUI.this.getString(R.l.dEI), "", new DialogInterface.OnClickListener() {
                                    public final void onClick(DialogInterface dialogInterface, int i) {
                                        final r a = com.tencent.mm.ui.base.h.a(FavoriteSightDetailUI.this.mController.xRr, FavoriteSightDetailUI.this.getString(R.l.dEI), false, null);
                                        j.a(FavoriteSightDetailUI.this.mzi.field_localId, new Runnable() {
                                            public final void run() {
                                                FavoriteSightDetailUI.this.muu.mtS = true;
                                                a.dismiss();
                                                x.i("MicroMsg.FavoriteSightDetailUI", "do del fav file, local id %d, fav id %d", Long.valueOf(FavoriteSightDetailUI.this.mzi.field_localId), Integer.valueOf(FavoriteSightDetailUI.this.mzi.field_id));
                                                FavoriteSightDetailUI.this.finish();
                                            }
                                        });
                                    }
                                }, null);
                                return;
                            case 3:
                                k = FavoriteSightDetailUI.this.muu;
                                k.mtR++;
                                intent = new Intent(FavoriteSightDetailUI.this.mController.xRr, FavTagEditUI.class);
                                intent.putExtra("key_fav_scene", 2);
                                intent.putExtra("key_fav_item_id", FavoriteSightDetailUI.this.mzi.field_localId);
                                FavoriteSightDetailUI.this.mController.xRr.startActivity(intent);
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
        if (com.tencent.mm.a.e.bO(j.i(this.fvZ))) {
            Bitmap a = com.tencent.mm.plugin.favorite.b.h.a(this.fvZ, this.mzi);
            if (a != null) {
                int width = a.getWidth();
                int height = a.getHeight();
                if (!this.mCO) {
                    this.mCO = true;
                    DisplayMetrics displayMetrics = this.mCH.getResources().getDisplayMetrics();
                    float f = (displayMetrics.density * 36.0f) + 0.5f;
                    LayoutParams layoutParams = this.mCH.getLayoutParams();
                    if (layoutParams == null) {
                        x.e("MicroMsg.FavoriteSightDetailUI", "setViewResize, but params is null");
                    } else {
                        layoutParams.width = displayMetrics.widthPixels - ((int) f);
                        layoutParams.height = (height * layoutParams.width) / width;
                        this.mCH.setLayoutParams(layoutParams);
                    }
                }
                this.mBj.setImageBitmap(a);
                this.mBj.setVisibility(0);
            }
        } else if (!bi.oN(this.fvZ.hcU)) {
            j.b(this.mzi, this.fvZ, true);
        }
        fl(false);
        h.getFavItemInfoStorage().c(this.mCG);
        h.getFavItemInfoStorage().c(this);
        h.aIZ().a(this);
        e.i(this);
    }

    protected void onDestroy() {
        if (this.mCK != null) {
            this.mCK.qAJ = null;
            this.mCK.stop();
        }
        if (this.mCG != null) {
            h.getFavItemInfoStorage().j(this.mCG);
        }
        h.getFavItemInfoStorage().j(this);
        h.aIZ().b((i) this);
        super.onDestroy();
    }

    protected void onResume() {
        super.onResume();
        if (this.mCK != null) {
            if (!this.mCM) {
                aKq();
            } else if (!this.mCK.isPlaying()) {
                this.mCK.start();
            }
            this.mCM = false;
        }
    }

    protected void onPause() {
        if (this.mCK != null) {
            this.mCK.stop();
        }
        super.onPause();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    @android.annotation.SuppressLint({"ResourceType"})
    private void fl(boolean r5) {
        /*
        r4 = this;
        r3 = 8;
        r2 = 0;
        r0 = r4.mzi;
        r0 = r0.isDone();
        if (r0 == 0) goto L_0x0053;
    L_0x000b:
        r0 = r4.fvZ;
        r0 = com.tencent.mm.plugin.favorite.a.j.e(r0);
        if (r0 == 0) goto L_0x0021;
    L_0x0013:
        r0 = r4.mCI;
        r0.setVisibility(r3);
        r0 = r4.mCJ;
        r0.setVisibility(r3);
        r4.aKq();
    L_0x0020:
        return;
    L_0x0021:
        r0 = r4.fvZ;
        r0 = r0.wjN;
        r0 = com.tencent.mm.sdk.platformtools.bi.oN(r0);
        if (r0 == 0) goto L_0x0042;
    L_0x002b:
        r0 = r4.mCI;
        r1 = com.tencent.mm.R.k.dAT;
        r0.setImageResource(r1);
    L_0x0032:
        r0 = r4.mCI;
        r0.setVisibility(r2);
        r0 = r4.mCJ;
        r0.setVisibility(r3);
        r0 = r4.mBj;
        r0.setVisibility(r2);
        goto L_0x0020;
    L_0x0042:
        r0 = "MicroMsg.FavoriteSightDetailUI";
        r1 = "? info is done, source file not exist, cdn data url is not null";
        com.tencent.mm.sdk.platformtools.x.w(r0, r1);
        r0 = r4.mCI;
        r1 = com.tencent.mm.R.k.dAT;
        r0.setImageResource(r1);
        goto L_0x0032;
    L_0x0053:
        r0 = r4.mzi;
        r0 = r0.aIu();
        if (r0 == 0) goto L_0x0086;
    L_0x005b:
        r0 = r4.fvZ;
        r0 = r0.wjN;
        r0 = com.tencent.mm.sdk.platformtools.bi.oN(r0);
        if (r0 == 0) goto L_0x006f;
    L_0x0065:
        r0 = r4.mCI;
        r1 = com.tencent.mm.R.k.dAT;
        r0.setImageResource(r1);
        if (r5 == 0) goto L_0x0032;
    L_0x006e:
        goto L_0x0032;
    L_0x006f:
        r0 = r4.mCI;
        r1 = com.tencent.mm.R.k.dAT;
        r0.setImageResource(r1);
        if (r5 == 0) goto L_0x0032;
    L_0x0078:
        r0 = r4.mController;
        r0 = r0.xRr;
        r1 = com.tencent.mm.R.l.dZm;
        r1 = r4.getString(r1);
        com.tencent.mm.ui.base.h.bu(r0, r1);
        goto L_0x0032;
    L_0x0086:
        r0 = r4.mzi;
        r0 = r0.aIt();
        if (r0 == 0) goto L_0x00a5;
    L_0x008e:
        r0 = r4.mCI;
        r1 = com.tencent.mm.R.k.dAT;
        r0.setImageResource(r1);
        if (r5 == 0) goto L_0x0032;
    L_0x0097:
        r0 = r4.mController;
        r0 = r0.xRr;
        r1 = com.tencent.mm.R.l.eSv;
        r1 = r4.getString(r1);
        com.tencent.mm.ui.base.h.bu(r0, r1);
        goto L_0x0032;
    L_0x00a5:
        r0 = r4.mzi;
        r0 = r0.isDownloading();
        if (r0 != 0) goto L_0x00b5;
    L_0x00ad:
        r0 = r4.mzi;
        r0 = r0.aIs();
        if (r0 == 0) goto L_0x00e4;
    L_0x00b5:
        r0 = r4.mCI;
        r0.setVisibility(r3);
        r0 = r4.mCJ;
        r0.setVisibility(r2);
        r0 = com.tencent.mm.plugin.favorite.h.aIZ();
        r1 = r4.fvZ;
        r1 = r1.mBr;
        r0 = r0.Ay(r1);
        if (r0 == 0) goto L_0x00de;
    L_0x00cd:
        r1 = r4.mCJ;
        r0 = r0.getProgress();
        r0 = (int) r0;
        r1.setProgress(r0);
    L_0x00d7:
        r0 = r4.mBj;
        r0.setVisibility(r2);
        goto L_0x0020;
    L_0x00de:
        r0 = r4.mCJ;
        r0.setProgress(r2);
        goto L_0x00d7;
    L_0x00e4:
        r0 = "MicroMsg.FavoriteSightDetailUI";
        r1 = "other status, not done, downloading, uploading, downloadfail, uploadfail";
        com.tencent.mm.sdk.platformtools.x.w(r0, r1);
        r0 = r4.mCI;
        r1 = com.tencent.mm.R.k.dAT;
        r0.setImageResource(r1);
        goto L_0x0032;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.favorite.ui.detail.FavoriteSightDetailUI.fl(boolean):void");
    }

    public final void a(String str, l lVar) {
        int i = 0;
        x.i("MicroMsg.FavoriteSightDetailUI", "on favitem change, notifyId:%s, curId:%d", str, Long.valueOf(this.mzi.field_localId));
        f dc = h.getFavItemInfoStorage().dc(this.mzi.field_localId);
        if (dc == null) {
            x.w("MicroMsg.FavoriteSightDetailUI", "error, on notify change, cannot find info");
            finish();
            return;
        }
        this.mzi = dc;
        this.fvZ = j.p(dc);
        com.tencent.mm.plugin.fav.a.c Ay = h.aIZ().Ay(this.fvZ.mBr);
        if (!(Ay == null || this.mBX)) {
            if (Ay.field_status == 4 && h.aIZ().Ay(this.fvZ.mBr).field_extFlag != 0) {
                j.a(this.mzi, this.fvZ, true);
                this.mBX = true;
            }
            x.i("MicroMsg.FavoriteSightDetailUI", "FavoriteFileDetail download, check retry, return %B", Boolean.valueOf(this.mBX));
            i = this.mBX;
        }
        if (i == 0) {
            ah.K(this.mCN);
            ah.h(this.mCN, 500);
        }
    }

    public final void a(com.tencent.mm.plugin.fav.a.c cVar) {
        if (cVar == null || cVar.field_dataId == null) {
            x.w("MicroMsg.FavoriteSightDetailUI", "on cdn status changed, item is null");
            return;
        }
        x.i("MicroMsg.FavoriteSightDetailUI", "on cdn status changed, dataID is %s, field id is %s,offset is %d, total is %d,cdn status is %d, cdn type is %d (send or recieve)", this.fvZ.mBr, cVar.field_dataId, Integer.valueOf(cVar.field_offset), Integer.valueOf(cVar.field_totalLen), Integer.valueOf(cVar.field_status), Integer.valueOf(cVar.field_type));
        if (cVar.field_offset > cVar.field_totalLen) {
            x.e("MicroMsg.FavoriteSightDetailUI", "on cdn status changed, cdn offset length > cdn total length, do cdnLengthError()");
            if (1 == cVar.field_type) {
                cVar.field_status = 2;
            } else {
                cVar.field_status = 4;
            }
            h.aIZ().a(cVar, new String[0]);
            if (cVar.field_type == 0) {
                b.e(cVar);
            }
            if (cVar.field_type == 1) {
                b.f(cVar);
            }
        }
        if (cVar.field_dataId.equals(this.fvZ.mBr)) {
            final int progress = (int) cVar.getProgress();
            this.mCJ.post(new Runnable() {
                public final void run() {
                    FavoriteSightDetailUI.this.mCJ.setProgress(progress);
                }
            });
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        if (i == 1 && -1 == i2) {
            String str;
            String stringExtra = intent == null ? null : intent.getStringExtra("Select_Conv_User");
            if (intent == null) {
                str = null;
            } else {
                str = intent.getStringExtra("custom_send_text");
            }
            final Dialog a = com.tencent.mm.ui.base.h.a(this.mController.xRr, getString(R.l.efM), false, null);
            com.tencent.mm.plugin.favorite.a.e.a(this.mController.xRr, stringExtra, str, this.mzi, new Runnable() {
                public final void run() {
                    a.dismiss();
                }
            });
            boolean eX = s.eX(stringExtra);
            com.tencent.mm.plugin.favorite.a.h.a(eX ? com.tencent.mm.plugin.favorite.a.h.c.Chatroom : com.tencent.mm.plugin.favorite.a.h.c.Chat, this.mzi, com.tencent.mm.plugin.favorite.a.h.d.Samll, eX ? m.gn(stringExtra) : 0);
            com.tencent.mm.ui.snackbar.a.h(this, getString(R.l.eip));
            return;
        }
        super.onActivityResult(i, i2, intent);
    }

    private void aKq() {
        String h = j.h(this.fvZ);
        if (com.tencent.mm.a.e.bO(h)) {
            this.mCK.stop();
            this.mCK.setMute(true);
            this.mCK.setVideoPath(h);
        }
    }

    protected final String i(f fVar) {
        if (this.mzi.field_favProto.wlY.size() > 0) {
            return String.valueOf(j.p(this.mzi).duration);
        }
        return "0";
    }
}
