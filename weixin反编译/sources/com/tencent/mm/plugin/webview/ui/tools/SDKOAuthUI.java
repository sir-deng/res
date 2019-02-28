package com.tencent.mm.plugin.webview.ui.tools;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.ap.o;
import com.tencent.mm.f.a.gz;
import com.tencent.mm.opensdk.channel.MMessageActV2;
import com.tencent.mm.opensdk.channel.MMessageActV2.Args;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import com.tencent.mm.opensdk.modelmsg.SendAuth.Req;
import com.tencent.mm.opensdk.modelmsg.SendAuth.Resp;
import com.tencent.mm.plugin.webview.model.t;
import com.tencent.mm.plugin.webview.model.u;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.protocal.c.auf;
import com.tencent.mm.protocal.c.bfk;
import com.tencent.mm.protocal.c.bfm;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.r;
import com.tencent.mm.y.as;
import com.tencent.mm.y.c;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import java.util.LinkedList;

public final class SDKOAuthUI extends MMActivity implements e {
    private r jqf;
    private String mAppId;
    private al tDA;
    private a tDB;
    private boolean tDC;
    private Req tDz;

    private static final class a extends BaseAdapter {
        private LayoutInflater DF;
        private LinkedList<auf> tDF;

        private static final class a {
            ImageView iYZ;
            TextView iZa;

            private a() {
            }

            /* synthetic */ a(byte b) {
                this();
            }
        }

        public final /* synthetic */ Object getItem(int i) {
            return AV(i);
        }

        public a(Context context, LinkedList<auf> linkedList) {
            this.DF = LayoutInflater.from(context);
            this.tDF = linkedList;
        }

        public final LinkedList<String> bTd() {
            LinkedList<String> linkedList = new LinkedList();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.tDF.size()) {
                    return linkedList;
                }
                auf auf = (auf) this.tDF.get(i2);
                if (auf.wIZ == 2 || auf.wIZ == 3) {
                    linkedList.add(auf.scope);
                }
                i = i2 + 1;
            }
        }

        public final int getCount() {
            return this.tDF == null ? 0 : this.tDF.size();
        }

        private auf AV(int i) {
            return (auf) this.tDF.get(i);
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            if (this.tDF == null || this.tDF.size() <= 0) {
                return null;
            }
            a aVar;
            final auf AV = AV(i);
            if (view == null) {
                a aVar2 = new a();
                view = this.DF.inflate(R.i.drw, null, false);
                aVar2.iYZ = (ImageView) view.findViewById(R.h.bKq);
                aVar2.iZa = (TextView) view.findViewById(R.h.bKp);
                view.setTag(aVar2);
                aVar = aVar2;
            } else {
                aVar = (a) view.getTag();
            }
            if (AV.wIZ == 1) {
                aVar.iYZ.setImageResource(R.k.dzg);
            } else if (AV.wIZ == 3) {
                aVar.iYZ.setImageResource(R.k.dzf);
            } else {
                aVar.iYZ.setImageResource(R.k.dze);
            }
            aVar.iZa.setText(AV.desc);
            final ImageView imageView = aVar.iYZ;
            aVar.iYZ.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    if (AV.wIZ == 2) {
                        imageView.setImageResource(R.k.dzg);
                        AV.wIZ = 1;
                    } else if (AV.wIZ == 1) {
                        imageView.setImageResource(R.k.dze);
                        AV.wIZ = 2;
                    }
                }
            });
            return view;
        }
    }

    static /* synthetic */ void a(SDKOAuthUI sDKOAuthUI, String str, String str2, String str3, LinkedList linkedList) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < linkedList.size(); i++) {
            stringBuilder.append((String) linkedList.get(i)).append(",");
        }
        x.i("MicroMsg.SdkOAuthUI", "doSDKOauthAuthorizeConfirm selectedScopes: %s", stringBuilder.toString());
        if (sDKOAuthUI.tDA != null) {
            sDKOAuthUI.tDA.TN();
            sDKOAuthUI.tDA.K(3000, 3000);
        } else {
            sDKOAuthUI.tDA = new al(new com.tencent.mm.sdk.platformtools.al.a() {
                public final boolean uG() {
                    if (SDKOAuthUI.this.isFinishing()) {
                        x.i("MicroMsg.SdkOAuthUI", "onTimerExpired isFinishing");
                    } else {
                        SDKOAuthUI.this.bTa();
                    }
                    return false;
                }
            }, false);
            sDKOAuthUI.tDA.K(3000, 3000);
        }
        as.CN().a(new u(1, str, str2, str3, linkedList), 0);
    }

    static /* synthetic */ void b(SDKOAuthUI sDKOAuthUI, String str) {
        String PL = PL(sDKOAuthUI.mAppId);
        if (bi.oN(PL)) {
            x.e("MicroMsg.SdkOAuthUI", "dealWithError pkg nil");
            return;
        }
        Resp resp = new Resp();
        resp.transaction = sDKOAuthUI.tDz.transaction;
        resp.errCode = -1;
        resp.errStr = str;
        resp.lang = sDKOAuthUI.bTc();
        resp.country = getCountry();
        sDKOAuthUI.a(PL, resp);
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setMMTitle(getString(R.l.eXQ));
        setMMSubTitle(getString(R.l.eIG));
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                SDKOAuthUI.this.bSZ();
                SDKOAuthUI.this.finish();
                return true;
            }
        });
        if (as.Hp()) {
            this.tDC = false;
            Bundle extras = getIntent().getExtras();
            String string = extras.getString(ConstantsAPI.CONTENT);
            if (bi.oN(string)) {
                x.e("MicroMsg.SdkOAuthUI", "init content is nil");
                return;
            }
            this.mAppId = Uri.parse(string).getQueryParameter("appid");
            string = this.mAppId;
            f aZ = g.aZ(string, false);
            if (aZ != null && bi.oN(aZ.field_openId)) {
                x.i("MicroMsg.SdkOAuthUI", "checkGetAppSetting appId: %s ", string);
                b gzVar = new gz();
                gzVar.fyb.appId = string;
                com.tencent.mm.sdk.b.a.xmy.m(gzVar);
            }
            this.tDz = new Req(extras);
            string = this.mAppId;
            String str = this.tDz.scope;
            String str2 = this.tDz.state;
            String PL = PL(this.mAppId);
            x.i("MicroMsg.SdkOAuthUI", "doSDKOauthAuthorize appid: %s", string);
            bTa();
            as.CN().a(new t(string, str, str2, PL, bi.oN(PL) ? null : com.tencent.mm.a.g.s(p.aX(this, PL)[0].toByteArray())), 0);
            return;
        }
        x.e("MicroMsg.SdkOAuthUI", "start, hasSetUin fail");
        Toast.makeText(this, R.l.dCs, 1).show();
    }

    protected final void onResume() {
        super.onResume();
        as.CN().a(1346, (e) this);
        as.CN().a(1388, (e) this);
    }

    protected final void onPause() {
        super.onPause();
        as.CN().b(1388, (e) this);
        as.CN().b(1346, (e) this);
    }

    protected final void onDestroy() {
        super.onDestroy();
        if (this.jqf != null) {
            this.jqf.dismiss();
        }
        if (this.tDA != null) {
            this.tDA.TN();
        }
    }

    protected final int getLayoutId() {
        return R.i.drx;
    }

    public final void onSwipeBack() {
        super.onSwipeBack();
        bSZ();
    }

    public final boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || keyEvent.getRepeatCount() != 0) {
            return super.onKeyDown(i, keyEvent);
        }
        bSZ();
        finish();
        return true;
    }

    private void PJ(String str) {
        String str2 = null;
        x.i("MicroMsg.SdkOAuthUI", "dealWithLoginCallback url : %s", str);
        String PL = PL(this.mAppId);
        if (bi.oN(PL)) {
            x.e("MicroMsg.SdkOAuthUI", "dealWithLoginCallback pkg nil");
            return;
        }
        Uri uri;
        Resp resp = new Resp();
        resp.transaction = this.tDz.transaction;
        resp.lang = bTc();
        resp.country = getCountry();
        if (bi.oN(str)) {
            uri = null;
        } else {
            uri = Uri.parse(str);
        }
        if (uri != null) {
            str2 = uri.getQueryParameter(TMQQDownloaderOpenSDKConst.UINTYPE_CODE);
            resp.state = uri.getQueryParameter("state");
            resp.errStr = uri.getQueryParameter("reason");
        }
        if (bi.oN(str2)) {
            resp.errCode = -1;
        } else if (str2.toLowerCase().equals("authdeny")) {
            resp.errCode = -4;
        } else {
            resp.errCode = 0;
            resp.code = str2;
        }
        resp.url = str;
        x.i("MicroMsg.SdkOAuthUI", "dealWithLoginCallback, pkg:%s code:%s errCode:%d state:%s", PL, resp.code, Integer.valueOf(resp.errCode), resp.state);
        a(PL, resp);
        finish();
    }

    private void bSZ() {
        x.i("MicroMsg.SdkOAuthUI", "dealWithCancel");
        if (this.tDz != null) {
            LinkedList linkedList;
            String PL = PL(this.mAppId);
            String str = this.mAppId;
            String str2 = this.tDz.state;
            if (this.tDB == null) {
                linkedList = null;
            } else {
                linkedList = this.tDB.bTd();
            }
            as.CN().a(new u(2, str, str2, PL, linkedList), 0);
            Resp resp = new Resp();
            resp.transaction = this.tDz.transaction;
            resp.errCode = -2;
            resp.lang = bTc();
            resp.country = getCountry();
            a(PL, resp);
        }
    }

    private void a(String str, Resp resp) {
        if (this.tDC) {
            x.i("MicroMsg.SdkOAuthUI", "doCallback has callback");
        } else if (!bi.oN(str)) {
            this.tDC = true;
            Bundle bundle = new Bundle();
            resp.toBundle(bundle);
            p.ae(bundle);
            Args args = new Args();
            args.targetPkgName = str;
            args.bundle = bundle;
            MMessageActV2.send(this, args);
        }
    }

    private void PK(final String str) {
        h.a((Context) this, str, getString(R.l.eXG), new DialogInterface.OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                SDKOAuthUI.b(SDKOAuthUI.this, str);
            }
        });
    }

    private void bTa() {
        if (this.jqf == null || this.jqf.isShowing()) {
            this.jqf = h.a((Context) this, getString(R.l.ezS), true, new OnCancelListener() {
                public final void onCancel(DialogInterface dialogInterface) {
                    try {
                        dialogInterface.dismiss();
                    } catch (Exception e) {
                        x.e("MicroMsg.SdkOAuthUI", "showProgressDlg onCancel exp: %s ", e.getLocalizedMessage());
                    }
                }
            });
        } else {
            this.jqf.show();
        }
    }

    private void bTb() {
        if (this.jqf != null) {
            this.jqf.dismiss();
        }
    }

    private boolean AU(int i) {
        if (i == 1 || i == 2 || i == 7 || i == 8) {
            x.e("MicroMsg.SdkOAuthUI", "isNetworkAvailable false, errType = " + i);
            return false;
        } else if (ao.isConnected(this)) {
            return true;
        } else {
            x.e("MicroMsg.SdkOAuthUI", "isNetworkAvailable false, not connected");
            return false;
        }
    }

    private String bTc() {
        return w.d(getSharedPreferences(ad.cgf(), 0));
    }

    private static String getCountry() {
        as.Hm();
        return bi.aD((String) c.Db().get(274436, null), null);
    }

    private static String PL(String str) {
        f aZ = g.aZ(str, false);
        if (aZ != null) {
            return aZ.field_packageName;
        }
        x.w("MicroMsg.SdkOAuthUI", "dealWithCancel getAppInfo null; appid: %s", str);
        return null;
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (kVar instanceof t) {
            x.i("MicroMsg.SdkOAuthUI", "onSDKOauthAuthorizeEnd errType:%d errCode:%d", Integer.valueOf(i), Integer.valueOf(i2));
            bTb();
            if (i == 0 && i2 == 0) {
                final bfm bfm = (bfm) ((t) kVar).gLB.hnR.hnY;
                if (bfm.wIW || bfm.wIX) {
                    x.i("MicroMsg.SdkOAuthUI", "onSDKOauthAuthorizeEnd direct login");
                    PJ(bfm.wbT);
                    return;
                }
                ImageView imageView = (ImageView) findViewById(R.h.bKA);
                TextView textView = (TextView) findViewById(R.h.bKF);
                ListView listView = (ListView) findViewById(R.h.bLu);
                Button button = (Button) findViewById(R.h.cuo);
                com.tencent.mm.ap.a.a.c.a aVar = new com.tencent.mm.ap.a.a.c.a();
                aVar.hFA = R.k.dzq;
                o.PG().a(bfm.wIV, imageView, aVar.PQ());
                textView.setText(bfm.hea);
                this.tDB = new a(this, bfm.wIU);
                listView.setAdapter(this.tDB);
                button.setOnClickListener(new OnClickListener() {
                    public final void onClick(View view) {
                        if (bfm.wIY) {
                            SDKOAuthUI.a(SDKOAuthUI.this, SDKOAuthUI.this.mAppId, SDKOAuthUI.this.tDz.state, SDKOAuthUI.PL(SDKOAuthUI.this.mAppId), SDKOAuthUI.this.tDB.bTd());
                        } else {
                            SDKOAuthUI.this.PJ(bfm.wbT);
                        }
                    }
                });
                findViewById(R.h.cIB).setVisibility(0);
            } else if (AU(i)) {
                PK(str);
            } else {
                PK(getString(R.l.eXH));
            }
        } else if (kVar instanceof u) {
            x.i("MicroMsg.SdkOAuthUI", "onSDKOauthAuthorizeConfirmEnd errType:%d errCode:%d", Integer.valueOf(i), Integer.valueOf(i2));
            if (this.tDA != null) {
                this.tDA.TN();
            }
            bTb();
            if (i == 0 && i2 == 0) {
                PJ(((bfk) ((u) kVar).gLB.hnR.hnY).wbT);
            } else if (AU(i)) {
                PK(str);
            } else {
                PK(getString(R.l.eXH));
            }
        }
    }
}
