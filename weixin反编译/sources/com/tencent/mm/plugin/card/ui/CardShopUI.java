package com.tencent.mm.plugin.card.ui;

import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.jsapi.lbs.e;
import com.tencent.mm.plugin.card.a.n;
import com.tencent.mm.plugin.card.b.b;
import com.tencent.mm.plugin.card.b.d.AnonymousClass7;
import com.tencent.mm.plugin.card.b.l;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.kr;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.statusbar.DrawStatusBarActivity;
import com.tencent.mm.y.as;
import java.util.ArrayList;

public class CardShopUI extends DrawStatusBarActivity implements com.tencent.mm.plugin.card.a.n.a {
    private ListView Fv;
    private OnClickListener iqi = new OnClickListener() {
        public final void onClick(View view) {
            if (view.getId() == R.h.cOk) {
                kr krVar = (kr) view.getTag();
                if (krVar != null) {
                    b.a(CardShopUI.this, krVar.fAo, krVar.fBX, krVar.hzf);
                    g.pWK.h(11941, Integer.valueOf(5), CardShopUI.this.kOv.aum(), CardShopUI.this.kOv.aun(), "", krVar.name);
                }
            }
        }
    };
    BroadcastReceiver jle = new BroadcastReceiver() {
        public final void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (action != null && action.equals("android.intent.action.LOCALE_CHANGED") && CardShopUI.awR()) {
                CardShopUI.this.awS();
            }
        }
    };
    private ArrayList<kr> kOB = new ArrayList();
    private String kOh;
    private com.tencent.mm.plugin.card.base.b kOv;
    private boolean kUN = false;
    private ProgressDialog laU;
    private String laV = "";
    private a laW;
    private LinearLayout laX;
    private View laY;
    private TextView laZ;

    class a extends BaseAdapter {

        class a {
            public TextView lbb;
            public TextView lbc;
            public TextView lbd;
            public ImageView lbe;
            public View lbf;

            a() {
            }
        }

        /* synthetic */ a(CardShopUI cardShopUI, byte b) {
            this();
        }

        public final /* synthetic */ Object getItem(int i) {
            return oo(i);
        }

        private a() {
        }

        public final int getCount() {
            return CardShopUI.this.kOB.size();
        }

        private kr oo(int i) {
            return (kr) CardShopUI.this.kOB.get(i);
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            a aVar;
            if (view == null) {
                view = View.inflate(CardShopUI.this.mController.xRr, R.i.dcI, null);
                a aVar2 = new a();
                aVar2.lbb = (TextView) view.findViewById(R.h.cOh);
                aVar2.lbc = (TextView) view.findViewById(R.h.cOg);
                aVar2.lbd = (TextView) view.findViewById(R.h.cOf);
                aVar2.lbe = (ImageView) view.findViewById(R.h.cOj);
                aVar2.lbf = view.findViewById(R.h.cOk);
                view.setTag(aVar2);
                aVar = aVar2;
            } else {
                aVar = (a) view.getTag();
            }
            kr oo = oo(i);
            if (oo == null) {
                aVar.lbb.setText("");
                aVar.lbc.setText("");
                aVar.lbd.setText("");
            } else {
                aVar.lbb.setText(oo.name);
                if (oo.vYA <= 0.0f) {
                    aVar.lbc.setVisibility(8);
                } else {
                    aVar.lbc.setText(l.f(CardShopUI.this.getBaseContext(), oo.vYA));
                    aVar.lbc.setVisibility(0);
                }
                aVar.lbd.setText(oo.fXk + oo.fXl + oo.hzf);
                aVar.lbf.setOnClickListener(CardShopUI.this.iqi);
                aVar.lbf.setTag(oo);
            }
            return view;
        }
    }

    public void onCreate(Bundle bundle) {
        CardShopUI cardShopUI;
        super.onCreate(bundle);
        this.kOv = (com.tencent.mm.plugin.card.base.b) getIntent().getParcelableExtra("key_card_info_data");
        Object stringExtra = getIntent().getStringExtra("KEY_CARD_TP_ID");
        String stringExtra2 = getIntent().getStringExtra("KEY_CARD_ID");
        if (this.kOv != null) {
            x.i("MicroMsg.CardShopUI", "onCreate  mCardInfo != null");
            this.laV = this.kOv.aun();
            stringExtra2 = this.kOv.aum();
            cardShopUI = this;
        } else {
            if (!TextUtils.isEmpty(stringExtra)) {
                this.laV = stringExtra;
                if (TextUtils.isEmpty(stringExtra2)) {
                    stringExtra2 = "";
                    cardShopUI = this;
                } else {
                    cardShopUI = this;
                }
            }
            if (TextUtils.isEmpty(this.laV)) {
                x.e("MicroMsg.CardShopUI", "onCreate  mCardTpid == null");
                finish();
            }
            x.i("MicroMsg.CardShopUI", "checkPermission checkLocation[%b]", Boolean.valueOf(com.tencent.mm.pluginsdk.g.a.a(this, "android.permission.ACCESS_COARSE_LOCATION", 69, null, null)));
            this.kUN = r0;
            if (this.kUN) {
                awQ();
            }
            initView();
        }
        cardShopUI.kOh = stringExtra2;
        if (TextUtils.isEmpty(this.laV)) {
            x.e("MicroMsg.CardShopUI", "onCreate  mCardTpid == null");
            finish();
        }
        x.i("MicroMsg.CardShopUI", "checkPermission checkLocation[%b]", Boolean.valueOf(com.tencent.mm.pluginsdk.g.a.a(this, "android.permission.ACCESS_COARSE_LOCATION", 69, null, null)));
        this.kUN = r0;
        if (this.kUN) {
            awQ();
        }
        initView();
    }

    protected final void initView() {
        if (TextUtils.isEmpty(this.kOv.aui().vZp)) {
            setMMTitle(R.l.dNQ);
        } else {
            setMMTitle(this.kOv.aui().vZp);
        }
        this.Fv = (ListView) findViewById(R.h.bSb);
        this.laX = (LinearLayout) View.inflate(getBaseContext(), R.i.dct, null);
        this.Fv.addHeaderView(this.laX);
        this.laW = new a();
        this.Fv.setAdapter(this.laW);
        final Intent intent = getIntent();
        this.Fv.setOnItemClickListener(new OnItemClickListener() {
            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (i == 0) {
                    x.v("MicroMsg.CardShopUI", "onItemClick pos is 0, click headerview");
                    return;
                }
                if (i > 0) {
                    i--;
                }
                kr krVar = (kr) CardShopUI.this.kOB.get(i);
                if (!TextUtils.isEmpty(krVar.vYB) && !TextUtils.isEmpty(krVar.vYC)) {
                    b.d(CardShopUI.this.kOh, krVar.vYB, krVar.vYC, 1052, intent.getIntExtra("key_from_appbrand_type", 0));
                } else if (!TextUtils.isEmpty(krVar.kRm)) {
                    b.a(CardShopUI.this, krVar.kRm, 1);
                    g.pWK.h(11941, Integer.valueOf(4), CardShopUI.this.kOv.aum(), CardShopUI.this.kOv.aun(), "", krVar.name);
                }
            }
        });
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                CardShopUI.this.finish();
                return true;
            }
        });
        this.laY = View.inflate(this, R.i.dcs, null);
        if (this.laX != null) {
            this.laX.addView(this.laY);
        }
        this.laZ = (TextView) this.laY.findViewById(R.h.bRi);
        this.laZ.setText(R.l.dPF);
        this.laY.setVisibility(8);
        com.tencent.mm.ui.statusbar.a.d(this.mController.contentView, getStatusBarColor(), true);
    }

    protected void onDestroy() {
        if (this.kUN) {
            unregisterReceiver(this.jle);
        }
        am.avk().a(this.laV, this);
        super.onDestroy();
    }

    protected final int getLayoutId() {
        return R.i.dcJ;
    }

    public final void a(boolean z, ArrayList<kr> arrayList) {
        if (this.laU != null) {
            this.laU.dismiss();
            this.laU = null;
        }
        String str = "MicroMsg.CardShopUI";
        String str2 = "onGotCardShop, isOk = %b, shop list size = %d";
        Object[] objArr = new Object[2];
        objArr[0] = Boolean.valueOf(z);
        objArr[1] = Integer.valueOf(arrayList == null ? 0 : arrayList.size());
        x.d(str, str2, objArr);
        if (!z) {
            x.e("MicroMsg.CardShopUI", "onGotCardShop fail");
        } else if (arrayList == null || arrayList.size() == 0) {
            x.e("MicroMsg.CardShopUI", "list == null || list.size() == 0");
        } else {
            if (this.kOB != null) {
                this.kOB.clear();
                this.kOB.addAll(arrayList);
                this.laY.setVisibility(0);
            } else {
                this.laY.setVisibility(8);
            }
            this.laW.notifyDataSetChanged();
        }
    }

    private void awQ() {
        x.i("MicroMsg.CardShopUI", e.NAME);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.LOCALE_CHANGED");
        registerReceiver(this.jle, intentFilter);
        if (awR()) {
            awS();
            return;
        }
        h.a((Context) this, getString(R.l.dQQ, new Object[]{getString(R.l.dNQ)}), getString(R.l.dGZ), new AnonymousClass7(this), new DialogInterface.OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
            }
        });
    }

    private static boolean awR() {
        boolean z;
        if (l.OW() || l.OX()) {
            z = false;
        } else {
            z = true;
        }
        return !z;
    }

    private void awS() {
        if (am.avk().a(this.laV, this.kOh, (com.tencent.mm.plugin.card.a.n.a) this)) {
            Context context = this.mController.xRr;
            getString(R.l.dGZ);
            this.laU = h.a(context, getString(R.l.dOr), true, new OnCancelListener() {
                public final void onCancel(DialogInterface dialogInterface) {
                    n avk = am.avk();
                    avk.a(CardShopUI.this.laV, CardShopUI.this);
                    if (avk.kPv != null) {
                        as.CN().c(avk.kPv);
                    }
                }
            });
            return;
        }
        h.bu(this, getString(R.l.dOq));
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        x.i("MicroMsg.CardShopUI", "summerper onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId()));
        switch (i) {
            case 69:
                if (iArr[0] == 0) {
                    x.i("MicroMsg.CardShopUI", "onMPermissionGranted LocationPermissionGranted " + this.kUN);
                    if (!this.kUN) {
                        this.kUN = true;
                        awQ();
                        return;
                    }
                    return;
                }
                h.a((Context) this, getString(R.l.eAc), getString(R.l.eAg), getString(R.l.esG), getString(R.l.cancel), false, new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        CardShopUI.this.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                    }
                }, null);
                return;
            default:
                return;
        }
    }
}
