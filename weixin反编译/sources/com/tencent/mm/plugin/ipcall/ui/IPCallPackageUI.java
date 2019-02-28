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
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.plugin.ipcall.a.d.j;
import com.tencent.mm.plugin.ipcall.a.e.f;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.c.aim;
import com.tencent.mm.protocal.c.bye;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.y.as;
import java.util.List;

public class IPCallPackageUI extends MMActivity implements e {
    private ListView nQG = null;
    private TextView nQH = null;
    private ProgressDialog nQI = null;
    private ProgressDialog nQJ = null;
    private a nQK = null;
    private com.tencent.mm.plugin.ipcall.a.d.e nQL = null;
    private j nQM = null;
    private f nQN = new f();

    private static class a extends BaseAdapter {
        private IPCallPackageUI nQP = null;
        List<bye> nua = null;

        private class a {
            TextView ipR;
            TextView jbl;
            CdnImageView nQT;
            TextView nQU;
            TextView nQV;
            Button nQW;

            private a() {
            }

            /* synthetic */ a(a aVar, byte b) {
                this();
            }
        }

        public a(IPCallPackageUI iPCallPackageUI) {
            this.nQP = iPCallPackageUI;
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

        public final View getView(int i, View view, ViewGroup viewGroup) {
            a aVar;
            if (view == null) {
                view = ((LayoutInflater) this.nQP.getSystemService("layout_inflater")).inflate(R.i.dmu, viewGroup, false);
                aVar = new a();
                aVar.nQT = (CdnImageView) view.findViewById(R.h.cCm);
                aVar.ipR = (TextView) view.findViewById(R.h.cCp);
                aVar.nQU = (TextView) view.findViewById(R.h.cCq);
                aVar.nQV = (TextView) view.findViewById(R.h.cCj);
                aVar.jbl = (TextView) view.findViewById(R.h.cCk);
                aVar.nQW = (Button) view.findViewById(R.h.cCi);
                view.setTag(aVar);
            } else {
                aVar = (a) view.getTag();
            }
            bye bye = (bye) getItem(i);
            if (bye != null) {
                aVar.ipR.setText(bye.fpg);
                aVar.nQU.setText(bye.wMx);
                aVar.jbl.setText(bye.nkL);
                aVar.nQV.setText(bye.nMr);
                aVar.nQT.setVisibility(0);
                aVar.nQT.setUrl(bye.xfD);
                if (bye.vNC == 0) {
                    aVar.nQW.setEnabled(true);
                } else {
                    aVar.nQW.setEnabled(false);
                }
                aVar.nQW.setTag(Integer.valueOf(i));
                aVar.nQW.setOnClickListener(new OnClickListener() {
                    public final void onClick(View view) {
                        final bye bye = (bye) a.this.getItem(((Integer) view.getTag()).intValue());
                        if (bye == null || bi.oN(bye.vPI)) {
                            x.e("MicroMsg.IPCallPackageUI", "buyBtnClick: proToBuy is null");
                            return;
                        }
                        a.this.nQP.nQN.start();
                        f b = a.this.nQP.nQN;
                        b.nLI++;
                        a.this.nQP.nQN.nLM = bye.vPI;
                        h.a(a.this.nQP, a.this.nQP.getString(R.l.esa, new Object[]{bye.wMx, bye.fpg}), a.this.nQP.getString(R.l.esb), a.this.nQP.getString(R.l.erY), a.this.nQP.getString(R.l.erZ), false, new DialogInterface.OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                                f b = a.this.nQP.nQN;
                                b.nLJ++;
                                IPCallPackageUI.a(a.this.nQP, bye.vPI);
                            }
                        }, new DialogInterface.OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                                f b = a.this.nQP.nQN;
                                b.nLK++;
                                a.this.nQP.nQN.finish();
                            }
                        });
                    }
                });
            }
            return view;
        }
    }

    static /* synthetic */ void a(IPCallPackageUI iPCallPackageUI, String str) {
        x.i("MicroMsg.IPCallPackageUI", "startPurchasePackage productID:%s", str);
        if (iPCallPackageUI.nQJ == null) {
            Context context = iPCallPackageUI.mController.xRr;
            iPCallPackageUI.getString(R.l.dGZ);
            iPCallPackageUI.nQJ = h.a(context, iPCallPackageUI.getString(R.l.esg), false, new OnCancelListener() {
                public final void onCancel(DialogInterface dialogInterface) {
                }
            });
        } else {
            iPCallPackageUI.nQJ.show();
        }
        iPCallPackageUI.nQM = new j(str);
        as.CN().a(iPCallPackageUI.nQM, 0);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        as.CN().a(831, (e) this);
        as.CN().a(277, (e) this);
        this.nQN.start();
        f fVar = this.nQN;
        fVar.nLH++;
        this.nQN.finish();
        setMMTitle(R.l.esf);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                IPCallPackageUI.this.finish();
                return true;
            }
        });
        this.nQG = (ListView) findViewById(R.h.cCo);
        this.nQK = new a(this);
        this.nQG.setAdapter(this.nQK);
        this.nQH = (TextView) findViewById(R.h.cAA);
        aVh();
    }

    protected void onDestroy() {
        super.onDestroy();
        as.CN().b(831, (e) this);
        as.CN().b(277, (e) this);
    }

    protected final int getLayoutId() {
        return R.i.dmv;
    }

    protected final int getForceOrientation() {
        return 1;
    }

    private void aVh() {
        x.i("MicroMsg.IPCallPackageUI", "startGetPackageProductList");
        if (this.nQK != null) {
            this.nQK.nua = null;
            this.nQK.notifyDataSetChanged();
        }
        if (this.nQG != null) {
            this.nQG.setVisibility(8);
        }
        if (this.nQH != null) {
            this.nQH.setVisibility(8);
        }
        if (this.nQI == null) {
            Context context = this.mController.xRr;
            getString(R.l.dGZ);
            this.nQI = h.a(context, getString(R.l.erb), true, new OnCancelListener() {
                public final void onCancel(DialogInterface dialogInterface) {
                    try {
                        if (IPCallPackageUI.this.nQL != null) {
                            as.CN().c(IPCallPackageUI.this.nQL);
                        }
                        IPCallPackageUI.this.finish();
                    } catch (Exception e) {
                        x.e("MicroMsg.IPCallPackageUI", "cancel getPackageProductListNetScene error: %s", e.getMessage());
                    }
                }
            });
        } else {
            this.nQI.show();
        }
        this.nQL = new com.tencent.mm.plugin.ipcall.a.d.e();
        as.CN().a(this.nQL, 0);
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (this.nQI != null && this.nQI.isShowing()) {
            this.nQI.dismiss();
        }
        if (this.nQJ != null && this.nQJ.isShowing()) {
            this.nQJ.dismiss();
        }
        if (kVar instanceof com.tencent.mm.plugin.ipcall.a.d.e) {
            x.i("MicroMsg.IPCallPackageUI", "onSceneEnd NetSceneIPCallGetPackageProductList errCode:%d, errMsg:%s", Integer.valueOf(i2), str);
            if (i == 0 && i2 == 0) {
                aim aim = ((com.tencent.mm.plugin.ipcall.a.d.e) kVar).nLe;
                if (aim == null || aim.wwp == null || aim.wwp.size() <= 0) {
                    this.nQK.nua = null;
                    this.nQK.notifyDataSetChanged();
                    this.nQH.setVisibility(0);
                    return;
                }
                this.nQK.nua = aim.wwp;
                this.nQK.notifyDataSetChanged();
                this.nQG.setVisibility(0);
                return;
            }
            Toast.makeText(this.mController.xRr, getString(R.l.eqY), 0).show();
            finish();
        } else if (kVar instanceof j) {
            x.i("MicroMsg.IPCallPackageUI", "onSceneEnd NetSceneIPCallPurchasePackage errCode:%d, errMsg:%s", Integer.valueOf(i2), str);
            this.nQN.nLL = i2;
            if (i == 0 && i2 == 0) {
                this.nQN.finish();
                Toast.makeText(this.mController.xRr, getString(R.l.esh), 0).show();
                aVh();
            } else if (i2 == 101) {
                bye bye;
                a aVar = this.nQK;
                j jVar = (j) kVar;
                String str2 = jVar.nLo != null ? jVar.nLo.vPI : "";
                if (!(bi.oN(str2) || aVar.nua == null)) {
                    for (bye bye2 : aVar.nua) {
                        if (bye2 != null && bye2.vPI.equals(str2)) {
                            bye = bye2;
                            break;
                        }
                    }
                }
                bye = null;
                if (bye == null) {
                    x.e("MicroMsg.IPCallPackageUI", "onSceneEnd: proToBuy is null");
                    this.nQN.finish();
                    Toast.makeText(this.mController.xRr, getString(R.l.esc), 0).show();
                    return;
                }
                h.a(this.mController.xRr, this.mController.xRr.getString(R.l.esd, new Object[]{bye.wMx, bye.fpg}), this.mController.xRr.getString(R.l.ese), this.mController.xRr.getString(R.l.erl), this.mController.xRr.getString(R.l.erZ), false, new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        f b = IPCallPackageUI.this.nQN;
                        b.nLN++;
                        IPCallPackageUI.this.nQN.finish();
                        Intent intent = new Intent();
                        intent.setClass(IPCallPackageUI.this.mController.xRr, IPCallRechargeUI.class);
                        IPCallPackageUI.this.startActivity(intent);
                        IPCallPackageUI.this.finish();
                    }
                }, new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        f b = IPCallPackageUI.this.nQN;
                        b.nLO++;
                        IPCallPackageUI.this.nQN.finish();
                    }
                });
            } else {
                this.nQN.finish();
                Toast.makeText(this.mController.xRr, getString(R.l.esc), 0).show();
                aVh();
            }
        } else {
            x.i("MicroMsg.IPCallPackageUI", "onSceneEnd errCode:%d, errMsg:%s", Integer.valueOf(i2), str);
        }
    }
}
