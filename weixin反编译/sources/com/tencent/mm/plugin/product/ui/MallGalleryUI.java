package com.tencent.mm.plugin.product.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap.CompressFormat;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.e;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.bl.d;
import com.tencent.mm.f.a.cg;
import com.tencent.mm.f.a.fw;
import com.tencent.mm.plugin.wxpay.a.b;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.ui.tools.k;
import com.tencent.mm.protocal.c.uz;
import com.tencent.mm.protocal.c.vn;
import com.tencent.mm.protocal.c.vt;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.h.c;
import com.tencent.mm.y.q;
import java.util.List;

@a(3)
public class MallGalleryUI extends MallBaseUI {
    private final String TAG = "MicroMsg.MallGalleryUI";
    private ViewPager pkX;
    private g pkY;
    private List<String> pkZ;
    private int pla = 0;
    private boolean plb;

    static /* synthetic */ void c(MallGalleryUI mallGalleryUI) {
        mallGalleryUI.plb = !mallGalleryUI.plb;
        if (mallGalleryUI.plb) {
            mallGalleryUI.mController.showTitleView();
        } else {
            mallGalleryUI.mController.hideTitleView();
        }
    }

    protected final int getLayoutId() {
        return g.uJX;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.pkZ = getIntent().getStringArrayListExtra("keys_img_urls");
        this.mController.hideTitleView();
        this.plb = false;
        initView();
    }

    protected void onResume() {
        super.onResume();
        this.pkY.az(this.pkZ);
        this.pkY.notifyDataSetChanged();
        if (this.pkZ != null) {
            this.pkZ.size();
        }
    }

    protected final void initView() {
        this.pkX = (ViewPager) findViewById(f.uwt);
        this.pkX.zo = new e() {
            public final void ae(int i) {
                x.d("MicroMsg.MallGalleryUI", "Page Selected postion: %d", Integer.valueOf(i));
                MallGalleryUI.this.pla = i;
                if (MallGalleryUI.this.plb) {
                    MallGalleryUI.this.mController.hideTitleView();
                    MallGalleryUI.this.plb = false;
                }
            }

            public final synchronized void a(int i, float f, int i2) {
            }

            public final void af(int i) {
            }
        };
        this.pkY = new g(this);
        this.pkY.plx = new g.a() {
            public final void bjQ() {
                MallGalleryUI.c(MallGalleryUI.this);
            }
        };
        this.pkX.a(this.pkY);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                MallGalleryUI.this.finish();
                return false;
            }
        });
        addIconOptionMenu(0, com.tencent.mm.plugin.wxpay.a.e.bDJ, new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                String[] stringArray;
                if (d.Pu("favorite")) {
                    stringArray = MallGalleryUI.this.getResources().getStringArray(b.ugO);
                } else {
                    stringArray = MallGalleryUI.this.getResources().getStringArray(b.ugP);
                }
                h.a(MallGalleryUI.this.mController.xRr, null, stringArray, null, false, new c() {
                    public final void jo(int i) {
                        Context context;
                        switch (i) {
                            case 0:
                                context = MallGalleryUI.this;
                                Intent intent = new Intent();
                                intent.putExtra("Retr_Msg_content", "");
                                intent.putExtra("Retr_Msg_Type", 0);
                                if (bi.oN(context.bjP())) {
                                    x.e("MicroMsg.MallGalleryUI", "url is null or nil");
                                    return;
                                }
                                intent.putExtra("Retr_File_Name", context.bjP());
                                intent.putExtra("Retr_go_to_chattingUI", false);
                                intent.putExtra("Retr_show_success_tips", true);
                                d.a(context, ".ui.transmit.MsgRetransmitUI", intent);
                                return;
                            case 1:
                                context = MallGalleryUI.this;
                                String bjP = context.bjP();
                                if (bi.oN(bjP)) {
                                    x.w("MicroMsg.MallGalleryUI", "save error.");
                                    return;
                                }
                                x.d("MicroMsg.MallGalleryUI", "can save. img path: %s", bjP);
                                k.h(bjP, context);
                                return;
                            case 2:
                                Activity activity = MallGalleryUI.this;
                                String bjP2 = activity.bjP();
                                if (bi.oN(bjP2)) {
                                    x.w("MicroMsg.MallGalleryUI", "file path invalid");
                                    return;
                                }
                                x.d("MicroMsg.MallGalleryUI", "file path valid");
                                com.tencent.mm.sdk.b.b cgVar = new cg();
                                if (bi.oN(bjP2)) {
                                    x.w("MicroMsg.GetFavDataSource", "fill favorite event fail, event is null or image path is empty");
                                    cgVar.frk.frq = i.efu;
                                } else {
                                    x.i("MicroMsg.GetFavDataSource", "do fill event info(fav simple image), path %s sourceType %d", bjP2, Integer.valueOf(9));
                                    vn vnVar = new vn();
                                    vt vtVar = new vt();
                                    uz uzVar = new uz();
                                    uzVar.Dc(2);
                                    uzVar.Uj(bjP2);
                                    uzVar.Ui(com.tencent.mm.a.g.s((uzVar.toString() + 2 + System.currentTimeMillis()).getBytes()));
                                    com.tencent.mm.sdk.b.b fwVar = new fw();
                                    fwVar.fwl.type = 27;
                                    fwVar.fwl.fwn = uzVar;
                                    com.tencent.mm.sdk.b.a.xmy.m(fwVar);
                                    String str = fwVar.fwm.fwx;
                                    com.tencent.mm.sdk.platformtools.d.b(bjP2, 150, 150, CompressFormat.JPEG, 90, str);
                                    uzVar.Uk(str);
                                    vtVar.UN(q.FY());
                                    vtVar.UO(q.FY());
                                    vtVar.Dl(9);
                                    vtVar.fD(bi.Wy());
                                    vnVar.a(vtVar);
                                    vnVar.wlY.add(uzVar);
                                    cgVar.frk.title = uzVar.title;
                                    cgVar.frk.frm = vnVar;
                                    cgVar.frk.type = 2;
                                }
                                cgVar.frk.frr = 4;
                                cgVar.frk.activity = activity;
                                com.tencent.mm.sdk.b.a.xmy.m(cgVar);
                                return;
                            default:
                                return;
                        }
                    }
                });
                return true;
            }
        });
    }

    final String bjP() {
        String str;
        if (this.pkZ == null || this.pkZ.size() < this.pla + 1) {
            x.e("MicroMsg.MallGalleryUI", "data not ready.retransmit failed");
            str = null;
        } else {
            str = (String) this.pkZ.get(this.pla);
        }
        if (!bi.oN(str)) {
            return c.HZ(str);
        }
        x.w("MicroMsg.MallGalleryUI", "invoke error. No current url");
        return null;
    }
}
