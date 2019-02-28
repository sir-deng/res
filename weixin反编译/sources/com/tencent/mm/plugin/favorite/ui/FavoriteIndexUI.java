package com.tencent.mm.plugin.favorite.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewStub;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ImageButton;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.f.a.kp;
import com.tencent.mm.f.a.kq;
import com.tencent.mm.j.b;
import com.tencent.mm.plugin.appbrand.jsapi.voicejoint.JsApiDownloadSilkVoice;
import com.tencent.mm.plugin.fav.a.f;
import com.tencent.mm.plugin.favorite.a.j;
import com.tencent.mm.plugin.favorite.ui.b.a.c;
import com.tencent.mm.plugin.favorite.ui.base.c.a;
import com.tencent.mm.plugin.favorite.ui.post.FavPostVoiceUI;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.uz;
import com.tencent.mm.protocal.c.vg;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p.d;
import com.tencent.mm.ui.tools.l;
import com.tencent.mm.ui.u;
import com.tencent.mm.y.as;
import com.tencent.mm.y.m;
import com.tencent.mm.y.s;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.io.File;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class FavoriteIndexUI extends FavBaseUI implements c, a {
    private static final long mzv = ((long) b.zN());
    private l contextMenuHelper;
    private d kHD = new d() {
        public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
            switch (FavoriteIndexUI.this.mzw) {
                case 0:
                    if (menuItem != null) {
                        AdapterContextMenuInfo adapterContextMenuInfo = (AdapterContextMenuInfo) menuItem.getMenuInfo();
                        switch (menuItem.getItemId()) {
                            case 0:
                                if (adapterContextMenuInfo.position >= FavoriteIndexUI.this.mxt.getHeaderViewsCount()) {
                                    x.i("MicroMsg.FavoriteIndexUI", "do delete, long click info is %s", Integer.valueOf(adapterContextMenuInfo.position));
                                    j.a(FavoriteIndexUI.this.mzx.qe((adapterContextMenuInfo.position - FavoriteIndexUI.this.mxt.getHeaderViewsCount()) - 1), null);
                                    return;
                                }
                                return;
                            case 1:
                                FavoriteIndexUI.this.startTime = bi.Wx();
                                x.i("MicroMsg.FavoriteIndexUI", "do edit, long click info is %s", Integer.valueOf(adapterContextMenuInfo.position));
                                FavoriteIndexUI.this.mzz = FavoriteIndexUI.this.mzx.qe((adapterContextMenuInfo.position - FavoriteIndexUI.this.mxt.getHeaderViewsCount()) - 1);
                                FavoriteIndexUI.b(FavoriteIndexUI.this, FavoriteIndexUI.this.mzz);
                                return;
                            case 2:
                                x.i("MicroMsg.FavoriteIndexUI", "do tag, long click info is %s", Integer.valueOf(adapterContextMenuInfo.position));
                                f qe = FavoriteIndexUI.this.mzx.qe((adapterContextMenuInfo.position - FavoriteIndexUI.this.mxt.getHeaderViewsCount()) - 1);
                                Intent intent = new Intent(FavoriteIndexUI.this.mController.xRr, FavTagEditUI.class);
                                intent.putExtra("key_fav_scene", 4);
                                intent.putExtra("key_fav_item_id", qe.field_localId);
                                FavoriteIndexUI.this.mController.xRr.startActivity(intent);
                                return;
                            case 3:
                                FavoriteIndexUI.this.startTime = bi.Wx();
                                x.i("MicroMsg.FavoriteIndexUI", "do transmit, long click info is %s", Integer.valueOf(adapterContextMenuInfo.position));
                                FavoriteIndexUI.this.mzC = FavoriteIndexUI.this.mzx.qe((adapterContextMenuInfo.position - FavoriteIndexUI.this.mxt.getHeaderViewsCount()) - 1);
                                FavoriteIndexUI.this.mzC = FavoriteIndexUI.this.mzC.aIx();
                                if (FavoriteIndexUI.this.mzC != null) {
                                    List linkedList = new LinkedList();
                                    linkedList.add(FavoriteIndexUI.this.mzC);
                                    if (j.a(linkedList, FavoriteIndexUI.this, new OnClickListener() {
                                        public final void onClick(DialogInterface dialogInterface, int i) {
                                            FavoriteIndexUI.a(FavoriteIndexUI.this, 4106);
                                        }
                                    })) {
                                        FavoriteIndexUI.a(FavoriteIndexUI.this, 4106);
                                        return;
                                    }
                                    return;
                                }
                                return;
                            default:
                                return;
                        }
                    }
                    return;
                default:
                    return;
            }
        }
    };
    private e mzA = new e() {
        public final void a(int i, int i2, String str, k kVar) {
            x.i("MicroMsg.FavoriteIndexUI", "onUsedCapacityChanged");
            FavoriteIndexUI.this.mxz.post(new Runnable() {
                public final void run() {
                    FavoriteIndexUI.this.mxz.aKg();
                }
            });
        }
    };
    private OnItemLongClickListener mzB = new OnItemLongClickListener() {
        public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (i < FavoriteIndexUI.this.mxt.getHeaderViewsCount()) {
                x.w("MicroMsg.FavoriteIndexUI", "on header view long click, ignore");
            } else {
                FavoriteIndexUI.this.contextMenuHelper.a(view, i, j, FavoriteIndexUI.this, FavoriteIndexUI.this.kHD);
            }
            return true;
        }
    };
    private f mzC;
    private int mzw = 0;
    private com.tencent.mm.plugin.favorite.ui.a.b mzx;
    private com.tencent.mm.plugin.favorite.ui.base.b mzy;
    private f mzz;
    private long startTime = 0;

    static /* synthetic */ void a(FavoriteIndexUI favoriteIndexUI, int i) {
        boolean z = false;
        if (i == 4105) {
            Intent intent = new Intent();
            intent.putExtra("Select_Conv_Type", 3);
            intent.putExtra("scene_from", 1);
            intent.putExtra("mutil_select_is_ret", true);
            if (favoriteIndexUI.mzx.aKd() == 1) {
                intent.putExtra("select_fav_local_id", ((f) favoriteIndexUI.mzx.fg(false).get(0)).field_localId);
                if (favoriteIndexUI.mzx.fg(false).get(0) != null && ((f) favoriteIndexUI.mzx.fg(false).get(0)).field_type == 3) {
                    h.bu(favoriteIndexUI.getApplicationContext(), favoriteIndexUI.getString(R.l.egF));
                    return;
                }
            }
            int i2;
            intent.putExtra("Retr_Msg_Type", 17);
            com.tencent.mm.plugin.favorite.a.d dVar = new com.tencent.mm.plugin.favorite.a.d();
            for (f e : favoriteIndexUI.mzx.fg(false)) {
                if (!dVar.e(e)) {
                    i2++;
                }
            }
            intent.putExtra("select_fav_select_count", i2);
            com.tencent.mm.bl.d.a((Context) favoriteIndexUI, ".ui.transmit.SelectConversationUI", intent, 4105);
        } else if (i == 4106) {
            Intent intent2 = new Intent();
            intent2.putExtra("Select_Conv_Type", 3);
            intent2.putExtra("scene_from", 1);
            intent2.putExtra("mutil_select_is_ret", true);
            if (favoriteIndexUI.mzC != null) {
                intent2.putExtra("select_fav_local_id", favoriteIndexUI.mzC.field_localId);
            }
            if (favoriteIndexUI.mzC != null) {
                int i3 = favoriteIndexUI.mzC.field_type;
                if (i3 == 1) {
                    z = true;
                } else if (i3 != 2) {
                    z = i3 == 16 ? true : i3 == 4 ? true : i3 == 14 ? true : i3 == 6 ? true : true;
                }
                if (!z) {
                    intent2.putExtra("Retr_Msg_Type", favoriteIndexUI.mzC.field_type);
                }
            }
            com.tencent.mm.bl.d.a((Context) favoriteIndexUI, ".ui.transmit.SelectConversationUI", intent2, 4106);
        }
    }

    static /* synthetic */ void a(FavoriteIndexUI favoriteIndexUI, final List list) {
        if (list != null && !list.isEmpty()) {
            final Dialog a = h.a(favoriteIndexUI.mController.xRr, favoriteIndexUI.getString(R.l.eeW), false, null);
            as.Dt().F(new Runnable() {
                public final void run() {
                    j.aM(list);
                    ah.y(new Runnable() {
                        public final void run() {
                            a.dismiss();
                        }

                        public final String toString() {
                            return super.toString() + "|batchDelFavItems";
                        }
                    });
                }
            });
        }
    }

    static /* synthetic */ void b(FavoriteIndexUI favoriteIndexUI, f fVar) {
        favoriteIndexUI.mzx.a(true, fVar);
        favoriteIndexUI.mxt.setOnItemLongClickListener(null);
        favoriteIndexUI.showOptionMenu(11, false);
        com.tencent.mm.plugin.favorite.ui.base.b bVar = favoriteIndexUI.mzy;
        if (!bVar.mAz) {
            if (bVar.mAA != null) {
                if (bVar.mAA instanceof ViewStub) {
                    bVar.mAA = ((ViewStub) bVar.mAA).inflate();
                }
                bVar.mAD = (ImageButton) bVar.mAA.findViewById(R.h.cgF);
                bVar.mAD.setEnabled(false);
                bVar.mAD.setContentDescription(bVar.mAD.getContext().getString(R.l.eRO));
                bVar.mAD.setOnClickListener(new View.OnClickListener() {
                    public final void onClick(View view) {
                        if (b.this.mAG != null) {
                            b.this.mAG.aJV();
                        }
                    }
                });
                bVar.mAE = (ImageButton) bVar.mAA.findViewById(R.h.cgC);
                bVar.mAE.setEnabled(false);
                bVar.mAE.setContentDescription(bVar.mAE.getContext().getString(R.l.dZv));
                bVar.mAE.setOnClickListener(new View.OnClickListener() {
                    public final void onClick(View view) {
                        if (b.this.mAG != null) {
                            b.this.mAG.aJW();
                        }
                    }
                });
                bVar.mAF = (ImageButton) bVar.mAA.findViewById(R.h.cgD);
                bVar.mAF.setEnabled(false);
                bVar.mAF.setContentDescription(bVar.mAF.getContext().getString(R.l.dYC));
                bVar.mAF.setOnClickListener(new View.OnClickListener() {
                    public final void onClick(View view) {
                        if (b.this.mAG != null) {
                            b.this.mAG.aJN();
                        }
                    }
                });
                bVar.mAz = true;
            } else {
                return;
            }
        }
        if (bVar.mAA.getVisibility() != 0) {
            bVar.mAA.setVisibility(0);
            bVar.mAA.startAnimation(AnimationUtils.loadAnimation(bVar.mAA.getContext(), R.a.bpZ));
        }
    }

    static /* synthetic */ void h(FavoriteIndexUI favoriteIndexUI) {
        long currentTimeMillis = System.currentTimeMillis();
        com.tencent.mm.sdk.b.b kpVar = new kp();
        if (com.tencent.mm.pluginsdk.model.c.vjO) {
            kpVar.fCH.field_localId = currentTimeMillis;
        } else {
            kpVar.fCH.field_localId = -1;
        }
        kpVar.fCH.context = favoriteIndexUI.mController.xRr;
        kpVar.fCH.type = 9;
        com.tencent.mm.sdk.b.a.xmy.m(kpVar);
        com.tencent.mm.sdk.b.b kqVar = new kq();
        kqVar.fCS.context = favoriteIndexUI.mController.xRr;
        kqVar.fCS.type = 3;
        kqVar.fCS.fCN = 1;
        com.tencent.mm.sdk.b.a.xmy.m(kqVar);
    }

    public void onCreate(Bundle bundle) {
        this.mxA = this;
        x.i("MicroMsg.FavoriteIndexUI", "onCreate favoriteindex");
        super.onCreate(bundle);
        if (com.tencent.mm.plugin.favorite.h.getFavItemInfoStorage().aIF() == null) {
            x.e("MicroMsg.FavoriteIndexUI", "onCreate favoriteindex, but favorite db is null ,return");
            finish();
            return;
        }
        com.tencent.mm.plugin.favorite.h.aIY().fb(false);
        setMMTitle(R.l.efP);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                if (FavoriteIndexUI.this.mzx.mAa) {
                    FavoriteIndexUI.this.aJT();
                } else {
                    FavoriteIndexUI.this.finish();
                }
                return true;
            }
        });
        this.mxt.setOnItemLongClickListener(this.mzB);
        as.CN().a((int) JsApiDownloadSilkVoice.CTRL_INDEX, this.mzA);
        as.CN().a(401, this.mzA);
        this.contextMenuHelper = new l(this);
        addIconOptionMenu(11, R.l.dCw, R.k.duZ, new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                FavoriteIndexUI.h(FavoriteIndexUI.this);
                return true;
            }
        });
        this.mzy = new com.tencent.mm.plugin.favorite.ui.base.b();
        com.tencent.mm.plugin.favorite.ui.base.b bVar = this.mzy;
        View findViewById = findViewById(R.h.cgE);
        bVar.mAz = false;
        bVar.mAA = findViewById;
        this.mzy.mAG = new com.tencent.mm.plugin.favorite.ui.base.b.a() {
            public final void aJV() {
                if (j.a(FavoriteIndexUI.this.mzx.fg(false), FavoriteIndexUI.this, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        FavoriteIndexUI.a(FavoriteIndexUI.this, 4105);
                    }
                })) {
                    FavoriteIndexUI.a(FavoriteIndexUI.this, 4105);
                }
            }

            public final void aJN() {
                h.a(FavoriteIndexUI.this.mController.xRr, FavoriteIndexUI.this.getString(R.l.eeV), "", new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        FavoriteIndexUI.a(FavoriteIndexUI.this, FavoriteIndexUI.this.mzx.fg(true));
                        g.pWK.h(11125, Integer.valueOf(r0.size()), Integer.valueOf(3));
                        if (FavoriteIndexUI.this.mzx.mAa) {
                            FavoriteIndexUI.this.aJT();
                        }
                    }
                }, null);
            }

            public final void aJW() {
                if (FavoriteIndexUI.this.mzx.aKd() > 0) {
                    if (FavoriteIndexUI.this.mzx.aKd() > 1) {
                        Intent intent = new Intent(FavoriteIndexUI.this.mController.xRr, FavTagEditUI.class);
                        intent.putExtra("key_fav_scene", 3);
                        FavoriteIndexUI.this.startActivityForResult(intent, 4104);
                        return;
                    }
                    f fVar = (f) FavoriteIndexUI.this.mzx.fg(false).get(0);
                    Intent intent2 = new Intent(FavoriteIndexUI.this.mController.xRr, FavTagEditUI.class);
                    intent2.putExtra("key_fav_scene", 3);
                    intent2.putExtra("key_fav_item_id", fVar.field_localId);
                    FavoriteIndexUI.this.startActivity(intent2);
                    if (FavoriteIndexUI.this.mzx.mAa) {
                        FavoriteIndexUI.this.aJT();
                    }
                }
            }
        };
        as.Dt().F(new Runnable() {
            public final void run() {
                long currentTimeMillis = System.currentTimeMillis();
                List aIM = com.tencent.mm.plugin.favorite.h.getFavItemInfoStorage().aIM();
                if (aIM != null) {
                    x.i("MicroMsg.FavoriteIndexUI", "initInvalidFavItem getInvalid favitems , size = %d,start time = %s", Integer.valueOf(aIM.size()), Long.valueOf(currentTimeMillis));
                    if (aIM.size() != 0) {
                        int size = aIM.size();
                        for (int i = 0; i < size; i++) {
                            com.tencent.mm.plugin.favorite.h.getFavItemInfoStorage().g((f) aIM.get(i));
                        }
                        x.i("MicroMsg.FavoriteIndexUI", "initInvalidFavItem  cost time = %s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                    }
                }
            }
        });
        com.tencent.mm.plugin.favorite.a.a.aJd().a(null);
        com.tencent.mm.pluginsdk.model.c.bYZ();
    }

    protected final void aJM() {
        super.aJM();
        this.hbP.post(new Runnable() {
            public final void run() {
            }
        });
    }

    protected void onDestroy() {
        super.onDestroy();
        if (com.tencent.mm.plugin.favorite.h.getFavItemInfoStorage().aIF() != null) {
            com.tencent.mm.plugin.favorite.h.aIY().fb(true);
            if (this.mzx != null) {
                this.mzx.finish();
            }
            com.tencent.mm.sdk.b.b kpVar = new kp();
            kpVar.fCH.type = 12;
            com.tencent.mm.sdk.b.a.xmy.m(kpVar);
            as.CN().b((int) JsApiDownloadSilkVoice.CTRL_INDEX, this.mzA);
            as.CN().b(401, this.mzA);
        }
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (4 != i || !this.mzx.mAa) {
            return super.onKeyUp(i, keyEvent);
        }
        aJT();
        return true;
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        com.tencent.mm.plugin.favorite.a.d dVar = new com.tencent.mm.plugin.favorite.a.d();
        f qe = this.mzx.qe((((AdapterContextMenuInfo) contextMenuInfo).position - this.mxt.getHeaderViewsCount()) - 1);
        switch (this.mzw) {
            case 0:
                contextMenu.setHeaderTitle(R.l.dGZ);
                boolean e = dVar.e(qe);
                if (!e) {
                    contextMenu.add(0, 3, 0, R.l.egE);
                }
                if (e && j.u(qe)) {
                    contextMenu.add(0, 3, 0, R.l.egE);
                }
                contextMenu.add(0, 2, 0, R.l.efl);
                contextMenu.add(0, 0, 0, R.l.eeU);
                contextMenu.add(0, 1, 0, R.l.egd);
                return;
            default:
                super.onCreateContextMenu(contextMenu, view, contextMenuInfo);
                return;
        }
    }

    private void aJT() {
        this.mzx.a(false, null);
        this.mxt.setOnItemLongClickListener(this.mzB);
        showOptionMenu(11, true);
        com.tencent.mm.plugin.favorite.ui.base.b bVar = this.mzy;
        if (bVar.mAz && bVar.mAA.getVisibility() != 8) {
            bVar.mAA.setVisibility(8);
            bVar.mAA.startAnimation(AnimationUtils.loadAnimation(bVar.mAA.getContext(), R.a.bqa));
        }
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        switch (this.mzw) {
            case 0:
                if (this.mzx != null) {
                    this.mzx.onItemClick(adapterView, view, i, j);
                    com.tencent.mm.plugin.favorite.ui.b.a.b bVar = (com.tencent.mm.plugin.favorite.ui.b.a.b) view.getTag();
                    if (bVar == null) {
                        x.w("MicroMsg.FavoriteIndexUI", "on item click, holder is null..");
                        return;
                    } else if (bVar.mwn == null) {
                        x.w("MicroMsg.FavoriteIndexUI", "on item click, info is null..");
                        return;
                    } else {
                        x.i("MicroMsg.FavoriteIndexUI", "click type is %d", Integer.valueOf(bVar.mwn.field_type));
                        g.pWK.h(12746, Integer.valueOf(bVar.mwn.field_type), Integer.valueOf(0), Integer.valueOf(i - 1));
                        return;
                    }
                }
                return;
            default:
                return;
        }
    }

    public final com.tencent.mm.plugin.favorite.ui.a.a aJI() {
        if (this.mzx == null) {
            ActionBarActivity actionBarActivity = this.mController.xRr;
            this.mzx = new com.tencent.mm.plugin.favorite.ui.a.b(this.muM, false);
            this.mzx.a(new com.tencent.mm.plugin.favorite.ui.a.a.a() {
                public final void aJX() {
                    FavoriteIndexUI.this.mxz.fh(true);
                }
            });
            this.mzx.mAh = this;
            this.mzx.scene = 1;
            this.mzx.mAk = this.mxt;
        }
        return this.mzx;
    }

    protected final void aJJ() {
        this.mxz.post(new Runnable() {
            public final void run() {
                FavoriteIndexUI.this.mxz.aKg();
            }
        });
    }

    protected final boolean aJK() {
        int aIG;
        switch (this.mzw) {
            case 3:
                aIG = com.tencent.mm.plugin.favorite.h.getFavItemInfoStorage().aIG();
                break;
            default:
                aIG = com.tencent.mm.plugin.favorite.h.getFavItemInfoStorage().getCount();
                break;
        }
        if (aIG > 0) {
            return true;
        }
        return false;
    }

    protected final void aJL() {
        switch (this.mzw) {
            case 3:
                this.mxu.setCompoundDrawablesWithIntrinsicBounds(0, R.k.dyJ, 0, 0);
                this.mxu.setCompoundDrawablePadding(com.tencent.mm.bu.a.fromDPToPix(this.mController.xRr, 10));
                this.mxu.setText(R.l.efo);
                return;
            default:
                this.mxu.setCompoundDrawablesWithIntrinsicBounds(0, R.g.bCf, 0, 0);
                this.mxu.setCompoundDrawablePadding(com.tencent.mm.bu.a.fromDPToPix(this.mController.xRr, 10));
                this.mxu.setText(R.l.efn);
                return;
        }
    }

    protected void onResume() {
        long currentTimeMillis = System.currentTimeMillis();
        super.onResume();
        this.hbP.post(new Runnable() {
            public final void run() {
                FavoriteIndexUI.this.mxz.aKg();
            }
        });
        x.d("MicroMsg.FavoriteIndexUI", "on resume use %d ms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
    }

    protected final void initHeaderView() {
        super.initHeaderView();
        this.mxz.fh(false);
    }

    private void a(List<f> list, String str, String str2) {
        if (list != null && !list.isEmpty() && !bi.oN(str2)) {
            boolean eX = s.eX(str2);
            com.tencent.mm.plugin.favorite.a.d dVar = new com.tencent.mm.plugin.favorite.a.d();
            List<f> linkedList = new LinkedList();
            for (f fVar : list) {
                if (!dVar.e(fVar)) {
                    g.pWK.h(10651, Integer.valueOf(fVar.field_type), Integer.valueOf(1), Integer.valueOf(0));
                    linkedList.add(fVar);
                    com.tencent.mm.plugin.favorite.a.h.a(eX ? com.tencent.mm.plugin.favorite.a.h.c.Chatroom : com.tencent.mm.plugin.favorite.a.h.c.Chat, fVar, com.tencent.mm.plugin.favorite.a.h.d.Samll, eX ? m.gn(str2) : 0);
                }
            }
            if (linkedList.isEmpty()) {
                x.i("MicroMsg.FavoriteIndexUI", "after filter, nothing");
                h.bu(getApplicationContext(), getString(R.l.egF));
                return;
            }
            final Dialog a = h.a(this.mController.xRr, getString(R.l.efM), false, null);
            com.tencent.mm.plugin.favorite.a.e.a(this.mController.xRr, str2, str, (List) linkedList, new Runnable() {
                public final void run() {
                    a.dismiss();
                    com.tencent.mm.ui.snackbar.a.h(FavoriteIndexUI.this, FavoriteIndexUI.this.getString(R.l.eip));
                }
            });
            for (f fVar2 : linkedList) {
                if (fVar2 != null && fVar2.field_type == 5) {
                    String str3 = "";
                    if (fVar2.field_favProto.wlf != null) {
                        str3 = fVar2.field_favProto.wlf.wmD;
                    }
                    if (fVar2.field_favProto.wlW != null && bi.oN(r1)) {
                        str3 = fVar2.field_favProto.wlW.hPT;
                    }
                    if (!bi.oN(str3)) {
                        x.d("MicroMsg.FavoriteIndexUI", "report(%s), url : %s, clickTimestamp : %d, scene : %d, actionType : %d, flag : %d", Integer.valueOf(13378), str3, Long.valueOf(this.startTime), Integer.valueOf(4), Integer.valueOf(1), Integer.valueOf(1));
                        String str4 = "";
                        try {
                            str4 = URLEncoder.encode(str3, "UTF-8");
                        } catch (Throwable e) {
                            x.printErrStackTrace("MicroMsg.FavoriteIndexUI", e, "", new Object[0]);
                        }
                        g.pWK.h(13378, str4, Long.valueOf(this.startTime), Integer.valueOf(4), Integer.valueOf(1), Integer.valueOf(1));
                    }
                }
            }
            g.pWK.h(11125, Integer.valueOf(linkedList.size()), Integer.valueOf(1));
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        x.i("MicroMsg.FavoriteIndexUI", "onActivityResult reqCode: %d, retCod: %d", Integer.valueOf(i), Integer.valueOf(i2));
        String stringExtra;
        String stringExtra2;
        if (i2 == -1) {
            int i3 = 2;
            stringExtra = intent.getStringExtra("custom_send_text");
            switch (i) {
                case Downloads.RECV_BUFFER_SIZE /*4096*/:
                    final ArrayList stringArrayListExtra = intent.getStringArrayListExtra("CropImage_OutputPath_List");
                    if (stringArrayListExtra != null && stringArrayListExtra.size() != 0) {
                        i3 = 0;
                        this.mxw.post(new Runnable() {
                            public final void run() {
                                FavoriteIndexUI.this.mxq = true;
                                com.tencent.mm.plugin.favorite.a.c.aL(stringArrayListExtra);
                            }
                        });
                        break;
                    }
                    x.e("MicroMsg.FavoriteIndexUI", "onActivityResult pathList is null or nil");
                    return;
                    break;
                case 4097:
                    final double doubleExtra = intent.getDoubleExtra("kwebmap_slat", 0.0d);
                    final double doubleExtra2 = intent.getDoubleExtra("kwebmap_lng", 0.0d);
                    final int intExtra = intent.getIntExtra("kwebmap_scale", 0);
                    final String aD = bi.aD(intent.getStringExtra("Kwebmap_locaion"), "");
                    final CharSequence charSequenceExtra = intent.getCharSequenceExtra("kRemark");
                    final String stringExtra3 = intent.getStringExtra("kPoiName");
                    final ArrayList stringArrayListExtra2 = intent.getStringArrayListExtra("kTags");
                    this.mxw.post(new Runnable() {
                        public final void run() {
                            FavoriteIndexUI.this.mxq = true;
                            double d = doubleExtra;
                            double d2 = doubleExtra2;
                            int i = intExtra;
                            String str = aD;
                            CharSequence charSequence = charSequenceExtra;
                            String str2 = stringExtra3;
                            List<String> list = stringArrayListExtra2;
                            vg vgVar = new vg();
                            vgVar.UE(str);
                            vgVar.s(d);
                            vgVar.r(d2);
                            vgVar.Dh(i);
                            vgVar.UF(str2);
                            f fVar = new f();
                            fVar.field_type = 6;
                            fVar.field_sourceType = 6;
                            fVar.field_favProto.b(vgVar);
                            if (!(charSequence == null || bi.oN(charSequence.toString()))) {
                                fVar.field_favProto.UK(charSequence.toString());
                                fVar.field_favProto.fB(bi.Wy());
                                g.pWK.h(10873, Integer.valueOf(6));
                            }
                            com.tencent.mm.plugin.favorite.a.c.j(fVar);
                            if (!(list == null || list.isEmpty())) {
                                for (String Ax : list) {
                                    fVar.Ax(Ax);
                                }
                            }
                            com.tencent.mm.plugin.favorite.b.a.B(fVar);
                            g.pWK.h(10648, Integer.valueOf(3), Integer.valueOf(0));
                            j.do(fVar.field_localId);
                            long j = fVar.field_localId;
                            f dc = com.tencent.mm.plugin.favorite.h.getFavItemInfoStorage().dc(j);
                            if (dc != null && dc.field_favProto.wld != null) {
                                com.tencent.mm.plugin.favorite.d.a(j, dc.field_favProto.wld, "", "", new ArrayList(), FavoriteIndexUI.this.mController.xRr);
                            }
                        }
                    });
                    i3 = 0;
                    break;
                case 4098:
                    Context applicationContext = getApplicationContext();
                    as.Hm();
                    stringExtra = com.tencent.mm.pluginsdk.ui.tools.k.b(applicationContext, intent, com.tencent.mm.y.c.Fp());
                    if (stringExtra != null) {
                        Intent intent2 = new Intent();
                        intent2.putExtra("CropImageMode", 4);
                        intent2.putExtra("CropImage_Filter", true);
                        intent2.putExtra("CropImage_ImgPath", stringExtra);
                        com.tencent.mm.plugin.favorite.d.ihN.a((Activity) this, intent2, 4099);
                        break;
                    }
                    x.w("MicroMsg.FavoriteIndexUI", "take picture result path is null");
                    return;
                case 4099:
                    stringExtra = intent.getStringExtra("CropImage_OutputPath");
                    if (stringExtra != null) {
                        i3 = 0;
                        final ArrayList arrayList = new ArrayList();
                        arrayList.add(stringExtra);
                        this.mxw.post(new Runnable() {
                            public final void run() {
                                FavoriteIndexUI.this.mxq = true;
                                com.tencent.mm.plugin.favorite.a.c.aL(arrayList);
                            }
                        });
                        break;
                    }
                    x.w("MicroMsg.FavoriteIndexUI", "crop picture resutl path is null");
                    return;
                case 4100:
                    stringExtra2 = intent.getStringExtra("choosed_file_path");
                    if (!bi.oN(stringExtra2)) {
                        File file = new File(stringExtra2);
                        if (file.exists()) {
                            if (file.length() < mzv) {
                                Object obj;
                                if (bi.oN(stringExtra2)) {
                                    obj = null;
                                } else {
                                    file = new File(stringExtra2);
                                    if (file.exists()) {
                                        f fVar = new f();
                                        fVar.field_type = 8;
                                        fVar.field_sourceType = 6;
                                        com.tencent.mm.plugin.favorite.a.c.j(fVar);
                                        fVar.field_favProto.UL(file.getName());
                                        uz uzVar = new uz();
                                        uzVar.Uj(stringExtra2);
                                        uzVar.lA(true);
                                        uzVar.TV(file.getName());
                                        uzVar.Dc(fVar.field_type);
                                        uzVar.Uf(com.tencent.mm.a.e.bQ(stringExtra2));
                                        fVar.field_favProto.wlY.add(uzVar);
                                        com.tencent.mm.plugin.favorite.b.a.B(fVar);
                                        g.pWK.h(10648, Integer.valueOf(5), Integer.valueOf(0));
                                        obj = 1;
                                    } else {
                                        obj = null;
                                    }
                                }
                                if (obj == null) {
                                    i3 = 1;
                                    break;
                                }
                                i3 = 0;
                                this.mxq = true;
                                break;
                            }
                            i3 = 3;
                            break;
                        }
                        i3 = 1;
                        break;
                    }
                    i3 = 1;
                    break;
                case 4101:
                case 4102:
                    i3 = 0;
                    this.mxq = true;
                    break;
                case 4103:
                    long longExtra = intent.getLongExtra("key_fav_result_local_id", -1);
                    if (-1 != longExtra) {
                        i3 = this.mzx.ds(longExtra);
                        if (-1 != i3) {
                            this.mxt.removeFooterView(this.mxx);
                            this.mxt.setSelection(i3);
                            return;
                        }
                        return;
                    }
                    return;
                case 4104:
                    final List fg = this.mzx.fg(false);
                    final String[] stringArrayExtra = intent.getStringArrayExtra("key_fav_result_array");
                    if (!(fg.isEmpty() || stringArrayExtra == null || stringArrayExtra.length <= 0)) {
                        final Dialog a = h.a(this.mController.xRr, "", false, null);
                        as.Dt().F(new Runnable() {
                            public final void run() {
                                j.a(fg, stringArrayExtra);
                                ah.y(new Runnable() {
                                    public final void run() {
                                        a.dismiss();
                                    }

                                    public final String toString() {
                                        return super.toString() + "|batchAddFavTags";
                                    }
                                });
                            }
                        });
                        g.pWK.h(11125, Integer.valueOf(stringArrayExtra.length), Integer.valueOf(2));
                        break;
                    }
                case 4105:
                    x.d("MicroMsg.FavoriteIndexUI", "select %s for sending", intent.getStringExtra("Select_Conv_User"));
                    a(this.mzx.fg(false), stringExtra, r4);
                    break;
                case 4106:
                    x.d("MicroMsg.FavoriteIndexUI", "select %s for sending", intent.getStringExtra("Select_Conv_User"));
                    List arrayList2 = new ArrayList();
                    arrayList2.add(this.mzC);
                    a(arrayList2, stringExtra, r4);
                    break;
            }
            if (i3 == 0) {
                h.bu(this.mController.xRr, getString(R.l.egi));
            } else if (1 == i3) {
                h.bu(this.mController.xRr, getString(R.l.eft));
            } else if (3 == i3) {
                Toast.makeText(this.mController.xRr, getString(R.l.ehb), 1).show();
            } else if (this.mzx.mAa) {
                aJT();
            }
        } else if ((this.mzC != null && this.mzC.field_type == 5) || (this.mzz != null && this.mzz.field_type == 5)) {
            stringExtra2 = "";
            if (this.mzz == null || this.mzz.field_favProto.wlW == null) {
                if (this.mzC.field_favProto.wlf != null) {
                    stringExtra2 = this.mzC.field_favProto.wlf.wmD;
                }
                if (this.mzC.field_favProto.wlW != null && bi.oN(r2)) {
                    stringExtra2 = this.mzC.field_favProto.wlW.hPT;
                }
            } else {
                stringExtra2 = this.mzz.field_favProto.wlW.hPT;
            }
            if (!bi.oN(stringExtra2)) {
                x.d("MicroMsg.FavoriteIndexUI", "report(%s), url : %s, clickTimestamp : %d, scene : %d, actionType : %d, flag : %d", Integer.valueOf(13378), stringExtra2, Long.valueOf(this.startTime), Integer.valueOf(4), Integer.valueOf(1), Integer.valueOf(3));
                stringExtra = "";
                try {
                    stringExtra2 = URLEncoder.encode(stringExtra2, "UTF-8");
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.FavoriteIndexUI", e, "", new Object[0]);
                    stringExtra2 = stringExtra;
                }
                g.pWK.h(13378, stringExtra2, Long.valueOf(this.startTime), Integer.valueOf(4), Integer.valueOf(1), Integer.valueOf(3));
            }
        }
    }

    public final void dr(long j) {
        if (this.mzx.mAa) {
            com.tencent.mm.plugin.favorite.ui.base.b bVar = this.mzy;
            boolean z = this.mzx.aKd() > 0;
            if (bVar.mAz) {
                bVar.mAD.setEnabled(z);
                bVar.mAE.setEnabled(z);
                bVar.mAF.setEnabled(z);
            }
        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuItem add = menu.add(0, 10, 0, R.l.eRz);
        add.setIcon(R.k.dvm);
        android.support.v4.view.m.a(add, 2);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 10) {
            return super.onOptionsItemSelected(menuItem);
        }
        Intent intent = new Intent(this.mController.xRr, FavSearchUI.class);
        intent.putExtra("key_enter_fav_search_from", 0);
        if (this.mzx.mAa) {
            intent.putExtra("key_search_type", 2);
            startActivityForResult(intent, 4103);
        } else {
            startActivity(intent);
        }
        return true;
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        x.i("MicroMsg.FavoriteIndexUI", "summerper onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId()));
        switch (i) {
            case 64:
                if (iArr[0] == 0) {
                    Intent intent = new Intent();
                    intent.putExtra(u.FLAG_OVERRIDE_EXIT_ANIMATION, R.a.bqm);
                    intent.putExtra(u.FLAG_OVERRIDE_ENTER_ANIMATION, R.a.bpZ);
                    intent.putExtra("map_view_type", 3);
                    com.tencent.mm.plugin.favorite.d.ihN.a(intent, 4097, (Activity) this);
                    return;
                }
                h.a((Context) this, getString(R.l.eAc), "", getString(R.l.esG), getString(R.l.cancel), false, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                        FavoriteIndexUI.this.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                    }
                }, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                return;
            case 80:
                if (iArr[0] == 0) {
                    startActivityForResult(new Intent(this, FavPostVoiceUI.class), 4102);
                    overridePendingTransition(0, 0);
                    return;
                }
                h.a((Context) this, getString(R.l.eAd), "", getString(R.l.esG), getString(R.l.cancel), false, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                        FavoriteIndexUI.this.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                    }
                }, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                return;
            default:
                return;
        }
    }

    public final void aJU() {
        Intent intent = new Intent(this.mController.xRr, FavCleanUI.class);
        intent.putExtra("key_enter_fav_cleanui_from", 0);
        this.mController.xRr.startActivity(intent);
    }
}
