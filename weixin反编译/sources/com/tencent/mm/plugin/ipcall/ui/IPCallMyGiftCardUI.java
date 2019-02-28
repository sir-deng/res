package com.tencent.mm.plugin.ipcall.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.plugin.ipcall.a.d.d;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.c.aik;
import com.tencent.mm.protocal.c.byc;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.y.as;
import java.util.List;
import junit.framework.Assert;

public class IPCallMyGiftCardUI extends MMActivity implements e {
    private ListView Fv;
    private View klX;
    private ProgressDialog lzx;
    private a nQv;
    private d nQw;

    private static class a extends BaseAdapter {
        private IPCallMyGiftCardUI nQy = null;
        aik nQz = null;
        List<byc> nua = null;

        private class a {
            TextView nQA;
            TextView nQB;
            TextView nQC;
            CdnImageView nQD;
            ImageView nQE;

            private a() {
            }

            /* synthetic */ a(a aVar, byte b) {
                this();
            }
        }

        public a(IPCallMyGiftCardUI iPCallMyGiftCardUI) {
            Assert.assertTrue(iPCallMyGiftCardUI != null);
            this.nQy = iPCallMyGiftCardUI;
        }

        public final int getCount() {
            return this.nua == null ? 0 : this.nua.size();
        }

        public final Object getItem(int i) {
            if (this.nua != null) {
                return this.nua.get(i);
            }
            return null;
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final int getViewTypeCount() {
            return 2;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            a aVar;
            if (view == null) {
                view = ((LayoutInflater) this.nQy.getSystemService("layout_inflater")).inflate(R.i.dms, viewGroup, false);
                aVar = new a();
                aVar.nQA = (TextView) view.findViewById(R.h.bZk);
                aVar.nQB = (TextView) view.findViewById(R.h.cao);
                aVar.nQC = (TextView) view.findViewById(R.h.cfK);
                aVar.nQD = (CdnImageView) view.findViewById(R.h.cos);
                aVar.nQE = (ImageView) view.findViewById(R.h.cau);
                view.setTag(aVar);
            } else {
                aVar = (a) view.getTag();
            }
            byc byc = (byc) getItem(i);
            if (byc != null) {
                if (bi.oN(byc.xfA)) {
                    aVar.nQA.setVisibility(0);
                    aVar.nQB.setVisibility(0);
                    aVar.nQC.setVisibility(8);
                    aVar.nQA.setText(byc.wMx);
                    aVar.nQB.setText(byc.xfz);
                } else {
                    aVar.nQA.setVisibility(8);
                    aVar.nQB.setVisibility(8);
                    aVar.nQC.setVisibility(0);
                    aVar.nQC.setText(byc.xfA);
                }
                b.a(aVar.nQE, "", 0.5f, false);
                if (bi.oN(byc.nlG)) {
                    aVar.nQE.setVisibility(0);
                    aVar.nQD.setVisibility(4);
                } else {
                    aVar.nQD.setVisibility(0);
                    aVar.nQD.setUrl(byc.nlG);
                    aVar.nQE.setVisibility(4);
                }
            }
            return view;
        }
    }

    protected final int getForceOrientation() {
        return 1;
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        as.CN().a(288, (e) this);
        setMMTitle(R.l.erT);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                IPCallMyGiftCardUI.this.finish();
                return true;
            }
        });
        addTextOptionMenu(0, this.mController.xRr.getString(R.l.erS), new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                Intent intent = new Intent();
                intent.putExtra("rawUrl", IPCallMyGiftCardUI.this.getString(R.l.eqS));
                intent.putExtra("showShare", false);
                com.tencent.mm.bl.d.b(IPCallMyGiftCardUI.this, "webview", ".ui.tools.WebViewUI", intent);
                return true;
            }
        });
        this.klX = findViewById(R.h.crm);
        this.Fv = (ListView) findViewById(R.h.crn);
        this.nQv = new a(this);
        this.Fv.setAdapter(this.nQv);
        Context context = this.mController.xRr;
        getString(R.l.dGZ);
        this.lzx = h.a(context, getString(R.l.erb), true, new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                try {
                    if (IPCallMyGiftCardUI.this.nQw != null) {
                        as.CN().c(IPCallMyGiftCardUI.this.nQw);
                    }
                    IPCallMyGiftCardUI.this.finish();
                } catch (Exception e) {
                    x.e("MicroMsg.IPCallMyGiftCardUI", "cancel getProductListScene error: %s", e.getMessage());
                }
            }
        });
        this.nQw = new d();
        as.CN().a(this.nQw, 0);
    }

    protected void onResume() {
        super.onResume();
    }

    protected void onDestroy() {
        super.onDestroy();
        as.CN().b(288, (e) this);
    }

    protected final int getLayoutId() {
        return R.i.dmt;
    }

    public final void a(int i, int i2, String str, k kVar) {
        x.i("MicroMsg.IPCallMyGiftCardUI", "onSceneEnd>errCode:%d,onSceneEnd>errMsg:%s", Integer.valueOf(i2), str);
        if (!(kVar instanceof d)) {
            return;
        }
        if (i == 0 && i2 == 0) {
            aik aik = ((d) kVar).nLc;
            if (this.lzx != null && this.lzx.isShowing()) {
                this.lzx.dismiss();
            }
            this.nQv.nua = aik.wwr;
            this.nQv.nQz = aik;
            this.nQv.notifyDataSetChanged();
            if (aik.wwr.size() == 0) {
                this.klX.setVisibility(0);
                return;
            }
            return;
        }
        if (this.lzx != null && this.lzx.isShowing()) {
            this.lzx.dismiss();
        }
        this.klX.setVisibility(0);
        Toast.makeText(this.mController.xRr, getString(R.l.eqY), 0).show();
    }
}
