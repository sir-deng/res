package com.tencent.mm.plugin.nearby.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.ap.o;
import com.tencent.mm.be.l;
import com.tencent.mm.cache.MCacheItem;
import com.tencent.mm.f.a.it;
import com.tencent.mm.f.a.oz;
import com.tencent.mm.f.b.ag;
import com.tencent.mm.j.g;
import com.tencent.mm.modelfriend.m;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiScanCode;
import com.tencent.mm.plugin.report.service.f;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.protocal.c.aor;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.base.r;
import com.tencent.mm.y.as;
import com.tencent.rtmp.TXLiveConstants;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import java.util.LinkedList;
import java.util.List;

public class NearbyFriendsUI extends MMActivity implements e {
    private com.tencent.mm.modelgeo.c gAg;
    private com.tencent.mm.modelgeo.a.a gAn = new com.tencent.mm.modelgeo.a.a() {
        public final boolean a(boolean z, float f, float f2, int i, double d, double d2, double d3) {
            if (NearbyFriendsUI.this.obI) {
                return false;
            }
            NearbyFriendsUI.this.obI = true;
            if (NearbyFriendsUI.this.hpb) {
                if (NearbyFriendsUI.this.tipDialog != null) {
                    NearbyFriendsUI.this.tipDialog.dismiss();
                    NearbyFriendsUI.this.tipDialog = null;
                }
                f.vT(11);
                return false;
            }
            if (z) {
                if (NearbyFriendsUI.this.tipDialog != null) {
                    NearbyFriendsUI.this.tipDialog.setMessage(NearbyFriendsUI.this.getString(R.l.exr));
                }
                NearbyFriendsUI.this.oUv = new a(f2, f, (int) d2);
                com.tencent.mm.modelstat.e.SZ().a(2001, i != 0, NearbyFriendsUI.this.gAg == null ? false : NearbyFriendsUI.this.gAg.hzA, f, f2, (int) d2);
                NearbyFriendsUI.this.oUh = new com.tencent.mm.plugin.nearby.a.c(NearbyFriendsUI.this.oUl, NearbyFriendsUI.this.oUv.hzr, NearbyFriendsUI.this.oUv.hzq, NearbyFriendsUI.this.oUv.accuracy, i, "", "");
                as.CN().a(NearbyFriendsUI.this.oUh, 0);
            } else {
                f.vT(11);
                if (NearbyFriendsUI.this.tipDialog != null) {
                    NearbyFriendsUI.this.tipDialog.dismiss();
                    NearbyFriendsUI.this.tipDialog = null;
                }
                NearbyFriendsUI.this.bfF();
                NearbyFriendsUI.this.findViewById(R.h.cza).setVisibility(0);
                NearbyFriendsUI.this.oUg.setVisibility(8);
                NearbyFriendsUI.this.oUs = true;
            }
            return false;
        }
    };
    private com.tencent.mm.sdk.b.c gAp = new com.tencent.mm.sdk.b.c<it>() {
        {
            this.xmG = it.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            it itVar = (it) bVar;
            if (itVar != null && (itVar instanceof it)) {
                ah.y(new Runnable() {
                    public final void run() {
                        NearbyFriendsUI.this.bfE();
                    }
                });
            }
            return false;
        }
    };
    boolean hpb = false;
    private List<aor> mgp = new LinkedList();
    private com.tencent.mm.plugin.nearby.a.c oTT;
    private b oUf;
    private ListView oUg;
    private com.tencent.mm.plugin.nearby.a.c oUh;
    private com.tencent.mm.plugin.nearby.a.d oUi;
    private boolean oUj = false;
    private String[] oUk;
    private int oUl = 1;
    private BindMobileOrQQHeaderView oUm;
    private ViewGroup oUn;
    private View oUo;
    private View oUp;
    private boolean oUq = false;
    private int oUr;
    private boolean oUs = false;
    private int oUt = 0;
    private View oUu = null;
    private a oUv;
    private boolean obI = false;
    private List<aor> ocZ = new LinkedList();
    private r tipDialog = null;

    static class c {
        public static int oUB = 10000;

        public static boolean uh(int i) {
            return i == oUB;
        }

        public static String b(aor aor) {
            if (aor != null) {
                return aor.hxf;
            }
            return null;
        }
    }

    static class d {
        ImageView hxJ;
        TextView hxK;
        TextView hxL;
        TextView oUC;
        TextView oUD;
        ImageView oUE;
        ImageView oUF;
        ImageView oUG;
        ImageView oUH;
        ImageView oUI;
        ImageView oUJ;

        d() {
        }
    }

    private class a {
        public int accuracy;
        public float hzq;
        public float hzr;

        public a(float f, float f2, int i) {
            this.hzq = f;
            this.hzr = f2;
            this.accuracy = i;
        }
    }

    class b extends BaseAdapter {
        private final Context context;
        com.tencent.mm.ui.applet.b hxF = new com.tencent.mm.ui.applet.b(new com.tencent.mm.ui.applet.b.a() {
            public final Bitmap la(String str) {
                return com.tencent.mm.ac.b.a(str, false, -1);
            }
        });
        private com.tencent.mm.ui.applet.b.b hxG = null;

        public final /* synthetic */ Object getItem(int i) {
            return ug(i);
        }

        public b(Context context) {
            this.context = context;
        }

        public final int getCount() {
            return NearbyFriendsUI.this.mgp.size();
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            d dVar;
            if (this.hxG == null) {
                this.hxG = new com.tencent.mm.ui.applet.b.b() {
                    public final String hF(int i) {
                        if (i < 0 || i >= b.this.getCount()) {
                            x.e("MicroMsg.NearbyFriend", "pos is invalid");
                            return null;
                        }
                        aor ug = b.this.ug(i);
                        if (ug != null) {
                            return ug.kyG;
                        }
                        return null;
                    }

                    public final int NP() {
                        return b.this.getCount();
                    }
                };
            }
            if (this.hxF != null) {
                this.hxF.a(i, this.hxG);
            }
            if (view == null) {
                d dVar2 = new d();
                view = View.inflate(this.context, R.i.doR, null);
                dVar2.hxK = (TextView) view.findViewById(R.h.czc);
                dVar2.oUD = (TextView) view.findViewById(R.h.czf);
                dVar2.oUC = (TextView) view.findViewById(R.h.cyX);
                dVar2.hxJ = (ImageView) view.findViewById(R.h.cyW);
                dVar2.hxL = (TextView) view.findViewById(R.h.cyZ);
                dVar2.oUE = (ImageView) view.findViewById(R.h.czh);
                dVar2.oUF = (ImageView) view.findViewById(R.h.czg);
                dVar2.oUH = (ImageView) view.findViewById(R.h.cyT);
                dVar2.oUI = (ImageView) view.findViewById(R.h.cyU);
                dVar2.oUJ = (ImageView) view.findViewById(R.h.cyV);
                LayoutParams layoutParams = dVar2.oUF.getLayoutParams();
                layoutParams.height = com.tencent.mm.bu.a.aa(this.context, R.f.bvK);
                layoutParams.width = com.tencent.mm.bu.a.aa(this.context, R.f.bvK);
                dVar2.oUF.setLayoutParams(layoutParams);
                dVar2.oUG = (ImageView) view.findViewById(R.h.cze);
                view.setTag(dVar2);
                dVar = dVar2;
            } else {
                dVar = (d) view.getTag();
            }
            aor aor = (aor) NearbyFriendsUI.this.mgp.get(i);
            dVar.hxK.setText(i.b(this.context, aor.kzN, dVar.hxK.getTextSize()));
            if (NearbyFriendsUI.this.oUl == 1) {
                switch (aor.hxe) {
                    case 1:
                        dVar.oUG.setVisibility(0);
                        dVar.oUG.setImageResource(R.k.dyY);
                        dVar.oUG.setContentDescription(this.context.getString(R.l.euP));
                        break;
                    case 2:
                        dVar.oUG.setVisibility(0);
                        dVar.oUG.setImageResource(R.k.dyX);
                        dVar.oUG.setContentDescription(this.context.getString(R.l.ehp));
                        break;
                    default:
                        dVar.oUG.setVisibility(8);
                        break;
                }
            }
            dVar.oUG.setVisibility(8);
            if (aor.wCq != 0) {
                dVar.oUE.setVisibility(0);
                dVar.oUE.setImageBitmap(com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.b(com.tencent.mm.y.ak.a.hhx.gP(aor.wCq), 2.0f));
                dVar.oUG.setVisibility(8);
            } else {
                dVar.oUE.setVisibility(8);
            }
            dVar.oUC.setText(aor.wCp);
            dVar.oUH.setVisibility(8);
            dVar.oUI.setVisibility(8);
            dVar.oUJ.setVisibility(8);
            if (aor instanceof com.tencent.mm.plugin.nearby.a.a) {
                LinkedList linkedList = ((com.tencent.mm.plugin.nearby.a.a) aor).oTA;
                if (linkedList != null && linkedList.size() == 1) {
                    dVar.oUH.setVisibility(0);
                    NearbyFriendsUI.l(dVar.oUH, (String) linkedList.get(0));
                } else if (linkedList != null && linkedList.size() == 2) {
                    dVar.oUH.setVisibility(0);
                    dVar.oUI.setVisibility(0);
                    NearbyFriendsUI.l(dVar.oUH, (String) linkedList.get(0));
                    NearbyFriendsUI.l(dVar.oUI, (String) linkedList.get(1));
                } else if (linkedList != null && linkedList.size() >= 3) {
                    dVar.oUH.setVisibility(0);
                    dVar.oUI.setVisibility(0);
                    dVar.oUJ.setVisibility(0);
                    NearbyFriendsUI.l(dVar.oUH, (String) linkedList.get(0));
                    NearbyFriendsUI.l(dVar.oUI, (String) linkedList.get(1));
                    NearbyFriendsUI.l(dVar.oUJ, (String) linkedList.get(2));
                }
            }
            if (aor.hxh == null || aor.hxh.trim().equals("")) {
                dVar.oUD.setVisibility(8);
            } else {
                dVar.oUD.setVisibility(0);
                dVar.oUD.setText(i.b(this.context, aor.hxh, dVar.oUD.getTextSize()));
            }
            if (aor.wCw == null || (aor.wCw.hxp & 1) <= 0) {
                dVar.oUF.setVisibility(8);
            } else {
                dVar.oUF.setVisibility(0);
            }
            if (c.uh(aor.hxe)) {
                dVar.hxJ.setImageBitmap(null);
                com.tencent.mm.ap.a.a.c.a aVar = new com.tencent.mm.ap.a.a.c.a();
                as.Hm();
                aVar.hFo = com.tencent.mm.y.c.Fp();
                aVar.hFl = true;
                aVar.hFI = true;
                o.PG().a(aor.kyG, dVar.hxJ, aVar.PQ());
                if (!bi.oN(aor.hxj)) {
                    dVar.hxL.setText(aor.hxj);
                    dVar.hxL.setVisibility(0);
                }
                dVar.hxL.setVisibility(8);
            } else {
                com.tencent.mm.pluginsdk.ui.a.b.a(dVar.hxJ, aor.kyG);
                as.Hm();
                if (com.tencent.mm.y.c.Ff().Xr(aor.kyG)) {
                    dVar.hxL.setVisibility(0);
                    if (com.tencent.mm.storage.x.DG(aor.wCq)) {
                        dVar.hxL.setText(NearbyFriendsUI.this.getString(R.l.exs));
                    } else {
                        as.Hm();
                        com.tencent.mm.storage.x Xt = com.tencent.mm.y.c.Ff().Xt(aor.kyG);
                        if (Xt != null) {
                            dVar.hxK.setText(i.b(this.context, bi.oN(Xt.AX()) ? aor.kzN : Xt.AX(), dVar.hxK.getTextSize()));
                        }
                        dVar.hxL.setText(NearbyFriendsUI.this.getString(R.l.exu));
                    }
                }
                dVar.hxL.setVisibility(8);
            }
            return view;
        }

        public final aor ug(int i) {
            return (aor) NearbyFriendsUI.this.mgp.get(i);
        }

        public final long getItemId(int i) {
            return 0;
        }
    }

    static /* synthetic */ void l(ImageView imageView, String str) {
        if (TextUtils.isEmpty(str)) {
            x.e("MicroMsg.NearbyFriend", "setImgBmp url is empty");
            return;
        }
        imageView.setImageBitmap(null);
        com.tencent.mm.ap.a.a.c.a aVar = new com.tencent.mm.ap.a.a.c.a();
        as.Hm();
        aVar.hFo = com.tencent.mm.y.c.Fp();
        aVar.hFl = true;
        aVar.hFI = true;
        o.PG().a(str, imageView, aVar.PQ());
    }

    static /* synthetic */ void w(NearbyFriendsUI nearbyFriendsUI) {
        if (nearbyFriendsUI.oUv != null) {
            nearbyFriendsUI.oUi = new com.tencent.mm.plugin.nearby.a.d(nearbyFriendsUI.oUv.hzr, nearbyFriendsUI.oUv.hzq, nearbyFriendsUI.oUv.accuracy, "", "");
            Context context = nearbyFriendsUI.mController.xRr;
            nearbyFriendsUI.getString(R.l.dGZ);
            nearbyFriendsUI.tipDialog = h.a(context, nearbyFriendsUI.getString(R.l.exG), true, new OnCancelListener() {
                public final void onCancel(DialogInterface dialogInterface) {
                    as.CN().c(NearbyFriendsUI.this.oUi);
                }
            });
            com.tencent.mm.plugin.nearby.a.b.uf(3);
            as.CN().a(nearbyFriendsUI.oUi, 0);
        }
    }

    public void onCreate(Bundle bundle) {
        f.vR(11);
        super.onCreate(bundle);
        setMMTitle(R.l.exE);
        as.CN().a((int) JsApiScanCode.CTRL_INDEX, (e) this);
        as.CN().a(376, (e) this);
        as.CN().a(1087, (e) this);
        this.gAg = com.tencent.mm.modelgeo.c.OV();
        initView();
        this.oUk = new String[]{getResources().getString(R.l.exy), getResources().getString(R.l.exx), getResources().getString(R.l.exw), getResources().getString(R.l.eHx)};
        as.Hm();
        this.oUl = bi.a((Integer) com.tencent.mm.y.c.Db().get(16386, null), 1);
        if (this.oUl == 3) {
            Ej(R.k.dyY);
        } else if (this.oUl == 4) {
            Ej(R.k.dyX);
        } else {
            Ej(0);
            this.oUl = 1;
        }
        bfD();
    }

    private void bfD() {
        this.obI = false;
        Context context = this.mController.xRr;
        getString(R.l.dGZ);
        this.tipDialog = h.a(context, getString(R.l.exv), true, new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                NearbyFriendsUI.this.hpb = true;
                f.vT(11);
                if (NearbyFriendsUI.this.oUh != null) {
                    as.CN().c(NearbyFriendsUI.this.oUh);
                }
                x.i("MicroMsg.NearbyFriend", "[MonsterzDai]  [loading cancel] cancel in loading");
                if (!NearbyFriendsUI.this.oUs) {
                    NearbyFriendsUI.this.finish();
                    x.i("MicroMsg.NearbyFriend", "[MonsterzDai]  [loading cancel] cancel in first loading");
                }
            }
        });
        this.hpb = false;
        if (this.gAg != null) {
            this.gAg.a(this.gAn, true);
        }
    }

    protected final int getLayoutId() {
        return R.i.doP;
    }

    private void bfE() {
        if (com.tencent.mm.bj.a.bYH()) {
            View view;
            if (this.oUu != null) {
                this.oUg.removeHeaderView(this.oUu);
                this.oUu = null;
            }
            View inflate = View.inflate(this, R.i.doT, null);
            TextView textView = (TextView) inflate.findViewById(R.h.cIO);
            int Tx = l.TF().Tx();
            if (Tx == 0) {
                inflate.setVisibility(8);
                view = null;
            } else {
                inflate.setVisibility(0);
                textView.setText(getResources().getQuantityString(R.j.duV, Tx, new Object[]{Integer.valueOf(Tx)}));
                ImageView imageView = (ImageView) inflate.findViewById(R.h.cvy);
                com.tencent.mm.be.h Ty = l.TF().Ty();
                if (Ty != null) {
                    com.tencent.mm.pluginsdk.ui.a.b.a(imageView, Ty.field_sayhiuser);
                }
                inflate.setOnClickListener(new OnClickListener() {
                    public final void onClick(View view) {
                        NearbyFriendsUI.this.oUg.removeHeaderView(NearbyFriendsUI.this.oUu);
                        NearbyFriendsUI.this.oUu = null;
                        Intent intent = new Intent(NearbyFriendsUI.this, NearbySayHiListUI.class);
                        intent.putExtra("k_say_hi_type", 2);
                        intent.putExtra("show_clear_header", true);
                        NearbyFriendsUI.this.startActivityForResult(intent, TXLiveConstants.PLAY_EVT_CHANGE_RESOLUTION);
                    }
                });
                view = inflate;
            }
            this.oUu = view;
            if (this.oUu != null) {
                this.oUg.addHeaderView(this.oUu);
            }
        }
    }

    protected final void initView() {
        this.oUg = (ListView) findViewById(R.h.czb);
        this.oUf = new b(this);
        ListView listView = this.oUg;
        if (this.oUn == null) {
            this.oUn = new LinearLayout(this);
            this.oUn.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
            ((LinearLayout) this.oUn).setGravity(17);
        }
        this.oUq = true;
        listView.addHeaderView(this.oUn);
        String value = g.Af().getValue("LBSShowBindPhone");
        if (value != null && value.length() > 0) {
            try {
                this.oUr = Integer.valueOf(value).intValue();
            } catch (Exception e) {
                this.oUr = 0;
            }
        }
        as.Hm();
        value = (String) com.tencent.mm.y.c.Db().get(6, null);
        if (value != null && value.length() > 0) {
            this.oUr = 0;
        }
        this.oUt = 0;
        if (com.tencent.mm.y.a.g.Ip().ih(TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL) != null) {
            value = com.tencent.mm.y.a.g.Ip().ih(TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL).value;
            com.tencent.mm.modelfriend.m.a NT = m.NT();
            if (value.equals("0")) {
                this.oUt = 0;
            } else if (value.equals("2")) {
                if (NT == com.tencent.mm.modelfriend.m.a.SUCC_UNLOAD) {
                    this.oUt = 2;
                    com.tencent.mm.y.a.f.il(TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL);
                }
            } else if (value.equals("1") && NT == com.tencent.mm.modelfriend.m.a.NO_INIT) {
                this.oUt = 2;
                com.tencent.mm.y.a.f.il(TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL);
            }
        }
        if ((this.oUr > 0 || this.oUt > 0) && this.oUt != 1) {
            this.oUm = new BindMobileOrQQHeaderView(this);
            this.oUg.addHeaderView(this.oUm);
        }
        this.oUg.setAdapter(this.oUf);
        this.oUg.setOnItemClickListener(new OnItemClickListener() {
            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (NearbyFriendsUI.this.oUr > 0 || NearbyFriendsUI.this.oUt > 0) {
                    i--;
                }
                if (com.tencent.mm.bj.a.bYH() && NearbyFriendsUI.this.oUu != null) {
                    i--;
                }
                if (NearbyFriendsUI.this.oUq) {
                    i--;
                }
                if (i >= 0 && i < NearbyFriendsUI.this.mgp.size()) {
                    aor aor = (aor) NearbyFriendsUI.this.mgp.get(i);
                    Intent intent;
                    if (c.uh(aor.hxe)) {
                        String b = c.b(aor);
                        x.d("MicroMsg.NearbyFriend", "poi item click, go:" + bi.oM(b));
                        if (!bi.oN(b)) {
                            intent = new Intent();
                            intent.putExtra("rawUrl", b);
                            intent.putExtra("geta8key_scene", 25);
                            intent.putExtra("stastic_scene", 12);
                            com.tencent.mm.bl.d.b(NearbyFriendsUI.this.mController.xRr, "webview", ".ui.tools.WebViewUI", intent);
                            return;
                        }
                        return;
                    }
                    String str = aor.kyG;
                    as.Hm();
                    ag Xv = com.tencent.mm.y.c.Ff().Xv(str);
                    if (com.tencent.mm.k.a.ga(Xv.field_type)) {
                        Intent intent2 = new Intent();
                        intent2.putExtra("Contact_User", str);
                        intent2.putExtra("Contact_Scene", 18);
                        intent2.putExtra("Sns_from_Scene", 18);
                        intent2.putExtra("lbs_ticket", aor.woW);
                        intent2.putExtra("Contact_IsLbsGotoChatting", true);
                        if (str != null && str.length() > 0) {
                            if (Xv.ciN()) {
                                com.tencent.mm.plugin.report.service.g.pWK.k(10298, str + ",18");
                            }
                            com.tencent.mm.sdk.b.b ozVar = new oz();
                            ozVar.fHJ.intent = intent2;
                            ozVar.fHJ.username = str;
                            com.tencent.mm.sdk.b.a.xmy.m(ozVar);
                            com.tencent.mm.plugin.nearby.a.ihN.d(intent2, NearbyFriendsUI.this);
                            return;
                        }
                        return;
                    }
                    intent = new Intent();
                    intent.putExtra("Contact_User", aor.kyG);
                    intent.putExtra("Contact_Alias", aor.hxj);
                    intent.putExtra("Contact_Nick", aor.kzN);
                    intent.putExtra("Contact_Distance", aor.wCp);
                    intent.putExtra("Contact_Signature", aor.hxh);
                    intent.putExtra("Contact_RegionCode", RegionCodeDecoder.ai(aor.hxn, aor.hxf, aor.hxg));
                    intent.putExtra("Contact_Sex", aor.hxe);
                    intent.putExtra("Contact_IsLBSFriend", true);
                    intent.putExtra("Contact_Scene", 18);
                    intent.putExtra("Contact_VUser_Info", aor.wCr);
                    intent.putExtra("Contact_VUser_Info_Flag", aor.wCq);
                    intent.putExtra("Contact_KWeibo_flag", aor.wCu);
                    intent.putExtra("Contact_KWeibo", aor.wCs);
                    intent.putExtra("Contact_KWeiboNick", aor.wCt);
                    intent.putExtra("Contact_KSnsIFlag", aor.wCw.hxp);
                    intent.putExtra("Contact_KSnsBgId", aor.wCw.hxr);
                    intent.putExtra("Contact_KSnsBgUrl", aor.wCw.hxq);
                    intent.putExtra("lbs_ticket", aor.woW);
                    intent.putExtra("Contact_IsLbsGotoChatting", true);
                    if (aor.hxo != null) {
                        com.tencent.mm.sdk.e.c dVar = new com.tencent.mm.af.d();
                        dVar.field_brandList = aor.hxo;
                        dVar.field_brandFlag = aor.wCx.hxs;
                        dVar.field_brandIconURL = aor.wCx.hxv;
                        dVar.field_extInfo = aor.wCx.hxt;
                        dVar.field_brandInfo = aor.wCx.hxu;
                        intent.putExtra("KBrandInfo_item", new MCacheItem(dVar));
                    }
                    intent.putExtra("Sns_from_Scene", 18);
                    com.tencent.mm.plugin.nearby.a.ihN.d(intent, NearbyFriendsUI.this);
                }
            }
        });
        this.oUg.setOnTouchListener(new OnTouchListener() {
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                if (NearbyFriendsUI.this.oUf != null) {
                    b s = NearbyFriendsUI.this.oUf;
                    if (s.hxF != null) {
                        s.hxF.onTouchEvent(motionEvent);
                    }
                }
                return false;
            }
        });
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                NearbyFriendsUI.this.finish();
                return true;
            }
        });
        AnonymousClass13 anonymousClass13 = new OnClickListener() {
            public final void onClick(View view) {
                com.tencent.mm.sdk.platformtools.BackwardSupportUtil.c.a(NearbyFriendsUI.this.oUg);
            }
        };
        addIconOptionMenu(0, R.g.bDJ, new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                com.tencent.mm.ui.widget.g gVar = new com.tencent.mm.ui.widget.g(NearbyFriendsUI.this, com.tencent.mm.ui.widget.g.zCt, false);
                gVar.rQG = new com.tencent.mm.ui.base.p.d() {
                    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                        switch (i) {
                            case 0:
                                NearbyFriendsUI.this.oUl = 4;
                                NearbyFriendsUI.this.oUj = false;
                                as.Hm();
                                com.tencent.mm.y.c.Db().set(16386, Integer.valueOf(NearbyFriendsUI.this.oUl));
                                NearbyFriendsUI.this.bfD();
                                return;
                            case 1:
                                NearbyFriendsUI.this.oUl = 3;
                                NearbyFriendsUI.this.oUj = false;
                                as.Hm();
                                com.tencent.mm.y.c.Db().set(16386, Integer.valueOf(NearbyFriendsUI.this.oUl));
                                NearbyFriendsUI.this.bfD();
                                return;
                            case 2:
                                NearbyFriendsUI.this.oUl = 1;
                                NearbyFriendsUI.this.oUj = false;
                                as.Hm();
                                com.tencent.mm.y.c.Db().set(16386, Integer.valueOf(NearbyFriendsUI.this.oUl));
                                NearbyFriendsUI.this.bfD();
                                return;
                            case 3:
                                Intent intent = new Intent(NearbyFriendsUI.this, NearbySayHiListUI.class);
                                intent.putExtra("k_say_hi_type", 2);
                                NearbyFriendsUI.this.startActivityForResult(intent, TXLiveConstants.PLAY_EVT_CHANGE_RESOLUTION);
                                return;
                            case 4:
                                NearbyFriendsUI.this.oTT = new com.tencent.mm.plugin.nearby.a.c(2, 0.0f, 0.0f, 0, 0, "", "");
                                as.CN().a(NearbyFriendsUI.this.oTT, 0);
                                NearbyFriendsUI nearbyFriendsUI = NearbyFriendsUI.this;
                                Context context = NearbyFriendsUI.this.mController.xRr;
                                NearbyFriendsUI.this.getString(R.l.dGZ);
                                nearbyFriendsUI.tipDialog = h.a(context, NearbyFriendsUI.this.getString(R.l.exp), true, new OnCancelListener() {
                                    public final void onCancel(DialogInterface dialogInterface) {
                                        as.CN().c(NearbyFriendsUI.this.oTT);
                                    }
                                });
                                return;
                            default:
                                return;
                        }
                    }
                };
                gVar.rQF = new com.tencent.mm.ui.base.p.c() {
                    public final void a(n nVar) {
                        nVar.eT(-1, R.l.exy);
                        nVar.eT(-1, R.l.exx);
                        nVar.eT(-1, R.l.exw);
                        nVar.eT(-1, R.l.eHx);
                        nVar.eT(-1, R.l.exl);
                    }
                };
                gVar.bUX();
                return true;
            }
        });
    }

    private void bfF() {
        com.tencent.mm.plugin.nearby.a.ihN.as(this);
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        x.d("MicroMsg.NearbyFriend", "onActivityResult, requestCode %s, resultCode %s", Integer.valueOf(i), Integer.valueOf(i2));
        switch (i) {
            case 1:
                if (i2 == -1) {
                    this.oUj = false;
                    bfD();
                    return;
                }
                return;
            case TXLiveConstants.PLAY_EVT_CHANGE_RESOLUTION /*2009*/:
                if (i2 == -1) {
                    finish();
                    return;
                }
                return;
            default:
                return;
        }
    }

    protected void onPause() {
        super.onPause();
        if (this.gAg != null) {
            this.gAg.c(this.gAn);
        }
        com.tencent.mm.sdk.b.a.xmy.c(this.gAp);
    }

    protected void onResume() {
        super.onResume();
        if (this.gAg != null) {
            this.gAg.a(this.gAn, true);
        }
        bfE();
        this.oUf.notifyDataSetChanged();
        if (l.TF().Tx() == 0) {
            this.oUg.removeHeaderView(this.oUp);
        }
        com.tencent.mm.sdk.b.a.xmy.b(this.gAp);
    }

    protected void onDestroy() {
        if (this.oUt > 0) {
            com.tencent.mm.y.a.f.im(TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL);
        }
        f.vT(11);
        as.CN().b((int) JsApiScanCode.CTRL_INDEX, (e) this);
        as.CN().b(376, (e) this);
        as.CN().b(1087, (e) this);
        if (this.tipDialog != null && this.tipDialog.isShowing()) {
            this.tipDialog.dismiss();
        }
        if (this.gAg != null) {
            this.gAg.c(this.gAn);
        }
        com.tencent.mm.ac.n.JY().cancel();
        if (this.oUf != null) {
            b bVar = this.oUf;
            if (bVar.hxF != null) {
                bVar.hxF.detach();
                bVar.hxF = null;
            }
        }
        super.onDestroy();
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (kVar.getType() == JsApiScanCode.CTRL_INDEX) {
            int IY = ((com.tencent.mm.plugin.nearby.a.c) kVar).IY();
            if (this.oUh != null || (IY != 1 && IY != 3 && IY != 4)) {
                if ((IY == 1 || IY == 3 || IY == 4) && this.oUj) {
                    x.v("MicroMsg.NearbyFriend", "onSceneEnd data already requested, code=%d", Integer.valueOf(IY));
                } else if (this.oTT != null || IY != 2) {
                    x.i("MicroMsg.NearbyFriend", "onSceneEnd: errType=%d, errCode=%d, errMsg=%s", Integer.valueOf(i), Integer.valueOf(i2), str);
                    if (kVar.getType() == JsApiScanCode.CTRL_INDEX) {
                        if (this.tipDialog != null) {
                            this.tipDialog.dismiss();
                            this.tipDialog = null;
                        }
                        if (i == 0 && i2 == 0) {
                            if (IY == 1 || IY == 3 || IY == 4) {
                                this.mgp = ((com.tencent.mm.plugin.nearby.a.c) kVar).bfB();
                                if (this.mgp == null || this.mgp.size() == 0) {
                                    findViewById(R.h.czd).setVisibility(0);
                                    this.oUg.setVisibility(8);
                                    bfF();
                                    f.vT(11);
                                } else {
                                    findViewById(R.h.czd).setVisibility(8);
                                    List linkedList = new LinkedList();
                                    int i3 = 0;
                                    for (aor aor : this.mgp) {
                                        as.Hm();
                                        if (com.tencent.mm.y.c.Ff().Xr(aor.kyG)) {
                                            linkedList.add(i3, aor);
                                            i3++;
                                        } else {
                                            linkedList.add(aor);
                                        }
                                    }
                                    this.mgp.clear();
                                    this.mgp = linkedList;
                                    if (this.ocZ != null) {
                                        for (IY = this.ocZ.size() - 1; IY >= 0; IY--) {
                                            if (this.ocZ.get(IY) != null) {
                                                this.mgp.add(0, this.ocZ.get(IY));
                                            }
                                        }
                                    }
                                    this.oUf.notifyDataSetChanged();
                                    if (this.oUf.getCount() > 0) {
                                        this.oUg.setSelection(0);
                                    }
                                    this.oUg.post(new Runnable() {
                                        public final void run() {
                                            f.vS(11);
                                        }
                                    });
                                }
                                if (this.oUl == 3) {
                                    Ej(R.k.dyY);
                                } else if (this.oUl == 4) {
                                    Ej(R.k.dyX);
                                } else {
                                    Ej(0);
                                    this.oUl = 1;
                                }
                                this.oUj = true;
                                this.oUh = null;
                            }
                            if (((com.tencent.mm.plugin.nearby.a.c) kVar).IY() == 2) {
                                h.a(this.mController.xRr, getString(R.l.exo), "", new DialogInterface.OnClickListener() {
                                    public final void onClick(DialogInterface dialogInterface, int i) {
                                        NearbyFriendsUI.this.finish();
                                    }
                                });
                                this.oTT = null;
                            }
                            if (((com.tencent.mm.plugin.nearby.a.c) kVar).bfz()) {
                                CharSequence string = getString(R.l.exH);
                                int bfA = ((com.tencent.mm.plugin.nearby.a.c) kVar).bfA();
                                if (this.oUn != null) {
                                    if (this.oUo == null) {
                                        this.oUo = View.inflate(this, R.i.doU, null);
                                        this.oUn.addView(this.oUo);
                                        this.oUo.setOnClickListener(new OnClickListener() {
                                            public final void onClick(View view) {
                                                NearbyFriendsUI.w(NearbyFriendsUI.this);
                                            }
                                        });
                                    } else {
                                        this.oUo.setVisibility(0);
                                    }
                                    ((TextView) this.oUo.findViewById(R.h.czj)).setText(string);
                                    if (bfA != 0) {
                                        ((TextView) this.oUo.findViewById(R.h.czi)).setText(String.format(getResources().getQuantityString(R.j.duO, bfA, new Object[]{Integer.valueOf(bfA)}), new Object[0]));
                                    }
                                }
                            } else if (!(this.oUo == null || this.oUn == null)) {
                                this.oUo.setVisibility(8);
                            }
                            this.oUs = true;
                            return;
                        }
                        if (IY == 1 || IY == 3 || IY == 4) {
                            com.tencent.mm.g.a aVar;
                            TextView textView = (TextView) findViewById(R.h.czd);
                            textView.setVisibility(0);
                            bfF();
                            if (str == null || str.length() <= 0) {
                                aVar = null;
                            } else {
                                aVar = com.tencent.mm.g.a.eC(str);
                            }
                            if (aVar != null && aVar.desc != null && aVar.desc.length() > 0) {
                                textView.setText(aVar.desc);
                            } else if (i2 == -2001) {
                                textView.setText(getString(R.l.exq));
                            } else {
                                textView.setText(getString(R.l.ext));
                            }
                            this.oUg.setVisibility(8);
                            this.oUh = null;
                        }
                        if (((com.tencent.mm.plugin.nearby.a.c) kVar).IY() == 2) {
                            Toast.makeText(this, R.l.exn, 1).show();
                            this.oTT = null;
                        }
                    }
                }
            }
        } else if (kVar.getType() == 376 && ((com.tencent.mm.plugin.nearby.a.d) kVar).IY() == 1) {
            if (this.tipDialog != null) {
                this.tipDialog.dismiss();
                this.tipDialog = null;
            }
            if (i == 0 && i2 == 0 && ((com.tencent.mm.plugin.nearby.a.d) kVar).idD != null) {
                String str2 = ((com.tencent.mm.plugin.nearby.a.d) kVar).idD;
                com.tencent.mm.plugin.nearby.a.b.dG(str2, ((com.tencent.mm.plugin.nearby.a.d) kVar).oTD);
                Intent intent = new Intent();
                intent.putExtra("Chat_User", str2);
                com.tencent.mm.plugin.nearby.a.ihN.f(intent, (Context) this);
                return;
            }
            h.a(this.mController.xRr, R.l.exF, R.l.dGZ, new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                }
            });
        }
    }
}
