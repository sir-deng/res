package com.tencent.mm.pluginsdk.ui.tools;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.downloader.model.FileDownloadTaskInfo;
import com.tencent.mm.plugin.downloader.model.o;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.pluginsdk.model.app.q;
import com.tencent.mm.pluginsdk.model.u;
import com.tencent.mm.pluginsdk.model.v;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.ListViewInScrollView;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ae;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.i;
import com.tencent.mm.y.as;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@com.tencent.mm.ui.base.a(7)
public class AppChooserUI extends MMActivity {
    private OnDismissListener Gk = new OnDismissListener() {
        public final void onDismiss(DialogInterface dialogInterface) {
            AppChooserUI.this.finish();
        }
    };
    private PackageManager bgS;
    private String mimeType = null;
    private int scene = 0;
    private int vCA;
    private String vCB = null;
    private Bundle vCC = null;
    private u vCD = null;
    private ArrayList<String> vCE = null;
    private c vCF = null;
    private c vCG = new c();
    private List<c> vCH;
    private String vCI;
    private int vCJ;
    private int vCK;
    private boolean vCL = false;
    private boolean vCM = false;
    private boolean vCN = false;
    private long vCO;
    private e vCP;
    private OnItemClickListener vCQ = new OnItemClickListener() {
        public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (AppChooserUI.this.vCy != null) {
                AppChooserUI.this.vCF = AppChooserUI.this.vCy.CR(i);
                AppChooserUI.this.vCy.notifyDataSetChanged();
                if (AppChooserUI.this.vCP != null && AppChooserUI.this.vCP.iqG.isShowing()) {
                    if (AppChooserUI.this.vCF == null || !AppChooserUI.this.vCF.vDc || (AppChooserUI.this.vCF.nGP && (AppChooserUI.this.vCF.smA || AppChooserUI.this.vCJ >= AppChooserUI.this.vCK))) {
                        AppChooserUI.this.vCP.lw(true);
                    } else {
                        AppChooserUI.this.vCP.lw(false);
                    }
                }
                if ((AppChooserUI.this.scene == 6 || AppChooserUI.this.vCA == 2) && AppChooserUI.this.vCF != null && AppChooserUI.this.vCF.vCZ != null) {
                    AppChooserUI.this.j(-1, AppChooserUI.this.vCF.vCZ.activityInfo.packageName, false);
                    g.pWK.h(12809, Integer.valueOf(4), AppChooserUI.this.vCF.vCZ.activityInfo.packageName);
                }
            }
        }
    };
    private OnClickListener vCR = new OnClickListener() {
        public final void onClick(DialogInterface dialogInterface, int i) {
            if (AppChooserUI.this.vCF != null && AppChooserUI.this.vCF.vCZ != null) {
                as.Hm();
                com.tencent.mm.y.c.Db().set(AppChooserUI.this.CQ(274528), AppChooserUI.this.vCF.vCZ.activityInfo.packageName);
                AppChooserUI.this.j(-1, AppChooserUI.this.vCF.vCZ.activityInfo.packageName, true);
            }
        }
    };
    private OnClickListener vCS = new OnClickListener() {
        public final void onClick(DialogInterface dialogInterface, int i) {
            if (AppChooserUI.this.vCF != null && AppChooserUI.this.vCF.vCZ != null) {
                AppChooserUI.this.j(-1, AppChooserUI.this.vCF.vCZ.activityInfo.packageName, false);
            }
        }
    };
    private View.OnClickListener vCT = new View.OnClickListener() {
        public final void onClick(View view) {
            x.i("MicroMsg.AppChooserUI", "mDownloadOnClickListener");
            if (AppChooserUI.this.vCy != null) {
                int i = AppChooserUI.this.vCy.vCW;
                if (i == f.vDh) {
                    if (AppChooserUI.this.vCP != null && AppChooserUI.this.vCP.iqG.isShowing()) {
                        AppChooserUI.this.vCy.vCW = f.vDi;
                        AppChooserUI.this.vCy.notifyDataSetChanged();
                    }
                    com.tencent.mm.plugin.downloader.model.g.a aVar = new com.tencent.mm.plugin.downloader.model.g.a();
                    if (AppChooserUI.this.scene == 1) {
                        aVar.yr("http://mdc.html5.qq.com/d/directdown.jsp?channel_id=10375");
                    } else {
                        aVar.yr(AppChooserUI.this.vCD.Wp());
                    }
                    aVar.yt(AppChooserUI.this.vCD.bYX());
                    aVar.oP(1);
                    aVar.et(true);
                    com.tencent.mm.plugin.downloader.model.f.aAK().a(aVar.lyp);
                    v.bZh();
                    v.BX(AppChooserUI.this.vCA);
                    if (AppChooserUI.this.vCA == 0) {
                        if (AppChooserUI.this.vCM) {
                            g.pWK.h(11168, Integer.valueOf(4), Integer.valueOf(AppChooserUI.this.scene));
                        } else {
                            g.pWK.h(11168, Integer.valueOf(3), Integer.valueOf(AppChooserUI.this.scene));
                        }
                    }
                    if (AppChooserUI.this.vCA == 1) {
                        g.pWK.h(12809, Integer.valueOf(5), "");
                    }
                } else if (i == f.vDj) {
                    MMActivity mMActivity = AppChooserUI.this;
                    long j = AppChooserUI.this.vCO;
                    x.i("MicroMsg.AppChooserUI", "installRecommendApp");
                    x.d("MicroMsg.AppChooserUI", "filepath:%s", com.tencent.mm.plugin.downloader.model.f.aAK().bZ(j).path);
                    if (!q.e(mMActivity.mController.xRr, Uri.fromFile(new File(r1)))) {
                        as.Hm();
                        com.tencent.mm.y.c.Db().set(mMActivity.CQ(274560), Long.valueOf(0));
                        if (mMActivity.vCy != null) {
                            mMActivity.vCy.vCW = f.vDh;
                            mMActivity.vCy.notifyDataSetChanged();
                        }
                    } else if (mMActivity.vCy != null) {
                        mMActivity.vCy.vCW = f.vDj;
                        mMActivity.vCy.notifyDataSetChanged();
                    }
                }
            }
        }
    };
    private o vCU = new o() {
        public final void onTaskStarted(long j, String str) {
            AppChooserUI.this.vCO = j;
            as.Hm();
            com.tencent.mm.y.c.Db().set(AppChooserUI.this.CQ(274560), Long.valueOf(AppChooserUI.this.vCO));
            x.d("MicroMsg.AppChooserUI", "onTaskStarted downloadId:%s savedFilePath:%s", String.valueOf(j), str);
        }

        public final void onTaskRemoved(long j) {
            x.d("MicroMsg.AppChooserUI", "onTaskRemove downloadId:%s", Long.valueOf(j));
        }

        public final void c(long j, String str, boolean z) {
            x.d("MicroMsg.AppChooserUI", "onTaskFinished downloadId: %d, savedPath: %s", Long.valueOf(j), str);
            if (!bi.oN(str) && com.tencent.mm.a.e.bO(str)) {
                as.Hm();
                com.tencent.mm.y.c.Db().set(AppChooserUI.this.CQ(274560), Long.valueOf(AppChooserUI.this.vCO));
                if (AppChooserUI.this.vCy != null && AppChooserUI.this.vCO == j) {
                    AppChooserUI.this.vCy.vCW = f.vDj;
                    AppChooserUI.this.vCy.notifyDataSetChanged();
                }
            }
        }

        public final void c(long j, int i, boolean z) {
            x.d("MicroMsg.AppChooserUI", "onTaskFailed downloadId:%s", Long.valueOf(j));
            as.Hm();
            com.tencent.mm.y.c.Db().set(AppChooserUI.this.CQ(274560), Long.valueOf(0));
            if (AppChooserUI.this.vCy != null) {
                AppChooserUI.this.vCy.vCW = f.vDh;
                AppChooserUI.this.vCy.notifyDataSetChanged();
            }
        }

        public final void onTaskPaused(long j) {
            x.d("MicroMsg.AppChooserUI", "onTaskPaused downloadId:%s", Long.valueOf(j));
            as.Hm();
            com.tencent.mm.y.c.Db().set(AppChooserUI.this.CQ(274560), Long.valueOf(0));
            if (AppChooserUI.this.vCy != null) {
                AppChooserUI.this.vCy.vCW = f.vDh;
                AppChooserUI.this.vCy.notifyDataSetChanged();
            }
        }

        public final void cl(long j) {
        }

        public final void k(long j, String str) {
        }
    };
    a vCy;
    private Intent vCz = null;

    class a extends BaseAdapter {
        List<c> lzC = new ArrayList();
        int vCW = f.vDh;

        public final /* synthetic */ Object getItem(int i) {
            return CR(i);
        }

        public a() {
            AppChooserUI.this.bgS = AppChooserUI.this.getPackageManager();
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            b bVar;
            int i2 = 0;
            c CR = CR(i);
            if (view == null || view.getTag() == null) {
                view = LayoutInflater.from(AppChooserUI.this.mController.xRr).inflate(CR.vDc ? R.i.dav : R.i.dau, null);
                b bVar2 = new b(view);
                view.setTag(bVar2);
                bVar = bVar2;
            } else {
                bVar = (b) view.getTag();
            }
            if (CR.vDb == null) {
                new d().execute(new c[]{CR});
            }
            bVar.nAF.setImageDrawable(CR.vDb);
            bVar.nAG.setText(CR.vDa);
            if (CR == null || (!(!CR.vDc || CR.smA || (CR.vDc && CR.nGP && AppChooserUI.this.vCJ >= AppChooserUI.this.vCK)) || CR.vDd)) {
                bVar.vCX.setVisibility(0);
                bVar.vCY.setVisibility(8);
                bVar.vCX.setOnClickListener(AppChooserUI.this.vCT);
                if (this.vCW == f.vDh) {
                    if (CR.vDd) {
                        bVar.vCX.setText(R.l.dFZ);
                    } else {
                        bVar.vCX.setText(R.l.dEK);
                    }
                    bVar.vCX.setEnabled(true);
                } else if (this.vCW == f.vDi) {
                    bVar.vCX.setText(R.l.dEP);
                    bVar.vCX.setEnabled(false);
                } else if (this.vCW == f.vDj) {
                    if (CR.vDd) {
                        bVar.vCX.setText(R.l.dHb);
                    } else {
                        bVar.vCX.setText(R.l.dHa);
                    }
                    bVar.vCX.setEnabled(true);
                }
            } else {
                boolean z;
                bVar.vCX.setVisibility(8);
                bVar.vCY.setVisibility(0);
                RadioButton radioButton = bVar.vCY;
                c c = AppChooserUI.this.vCF;
                if (c instanceof c) {
                    c = c;
                    if (!(c.vCZ == null || CR.vCZ == null || !c.vCZ.activityInfo.packageName.equals(CR.vCZ.activityInfo.packageName)) || (c.vDc && CR.vDc)) {
                        z = true;
                        radioButton.setChecked(z);
                    }
                }
                z = false;
                radioButton.setChecked(z);
            }
            if (CR.vDc) {
                if (AppChooserUI.this.scene == 4) {
                    bVar.nAI.setText(R.l.eBw);
                } else {
                    bVar.nAI.setText(bi.oM(AppChooserUI.this.vCB));
                }
                TextView textView = bVar.nAI;
                if (bi.oN(AppChooserUI.this.vCB)) {
                    i2 = 8;
                }
                textView.setVisibility(i2);
            } else {
                bVar.nAI.setVisibility(8);
            }
            if (!(AppChooserUI.this.scene == 6 || AppChooserUI.this.vCF == null || !AppChooserUI.this.vCF.equals(CR))) {
                bVar.vCY.setChecked(true);
            }
            return view;
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final c CR(int i) {
            return this.lzC == null ? null : (c) this.lzC.get(i);
        }

        public final int getViewTypeCount() {
            return 2;
        }

        public final int getItemViewType(int i) {
            if (CR(i).vDc) {
                return 1;
            }
            return 0;
        }

        public final int getCount() {
            return this.lzC == null ? 0 : this.lzC.size();
        }
    }

    class b {
        ImageView nAF;
        TextView nAG;
        TextView nAI;
        TextView vCX;
        RadioButton vCY;

        public b(View view) {
            this.nAF = (ImageView) view.findViewById(R.h.bKz);
            this.nAG = (TextView) view.findViewById(R.h.app_name);
            this.nAI = (TextView) view.findViewById(R.h.bKt);
            this.vCX = (TextView) view.findViewById(R.h.bKL);
            this.vCY = (RadioButton) view.findViewById(R.h.bKJ);
        }
    }

    class c {
        boolean nGP;
        boolean smA;
        ResolveInfo vCZ;
        CharSequence vDa;
        Drawable vDb;
        boolean vDc;
        boolean vDd;

        public c(ResolveInfo resolveInfo, CharSequence charSequence) {
            this.vCZ = resolveInfo;
            this.vDa = charSequence;
            this.vDc = false;
            this.smA = true;
            this.vDd = false;
        }
    }

    public enum f {
        ;

        static {
            vDh = 1;
            vDi = 2;
            vDj = 3;
            vDk = new int[]{vDh, vDi, vDj};
        }
    }

    class d extends AsyncTask<c, Void, c> {
        d() {
        }

        protected final /* synthetic */ Object doInBackground(Object[] objArr) {
            c cVar = ((c[]) objArr)[0];
            if (cVar.vDb == null) {
                cVar.vDb = AppChooserUI.this.c(cVar.vCZ);
            }
            return cVar;
        }

        protected final /* synthetic */ void onPostExecute(Object obj) {
            AppChooserUI.this.vCy.notifyDataSetChanged();
        }
    }

    class e {
        OnDismissListener Gk;
        public i iqG;
        BaseAdapter kUZ;
        Context mContext;
        String mTitle;
        OnClickListener vCS;
        ListViewInScrollView vDe = ((ListViewInScrollView) View.inflate(this.mContext, R.i.dat, null));
        OnItemClickListener vDf;
        OnClickListener vDg;

        public e(Context context) {
            this.mContext = context;
        }

        public final void lw(boolean z) {
            if (this.iqG == null) {
                return;
            }
            if (z) {
                this.iqG.a(R.l.dHh, this.vCS);
                this.iqG.b(R.l.dHg, this.vDg);
                return;
            }
            this.iqG.a(R.l.dHh, null);
            this.iqG.b(R.l.dHg, null);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        v.bZh();
        v.BU(this.vCA);
        ae.a(getWindow());
        Intent intent = getIntent();
        Parcelable parcelableExtra = intent.getParcelableExtra("targetintent");
        if (parcelableExtra instanceof Intent) {
            this.vCz = (Intent) parcelableExtra;
            CharSequence stringExtra = intent.getStringExtra("title");
            this.vCA = intent.getIntExtra(Columns.TYPE, 0);
            this.vCC = intent.getBundleExtra("transferback");
            this.vCE = intent.getStringArrayListExtra("targetwhitelist");
            this.vCM = intent.getBooleanExtra("needupate", false);
            this.mimeType = intent.getStringExtra("mimetype");
            this.scene = intent.getIntExtra("scene", 0);
            if (as.Hp()) {
                boolean z;
                as.Hm();
                this.vCI = (String) com.tencent.mm.y.c.Db().get(CQ(274528), (Object) "");
                if (!TextUtils.isEmpty(this.vCI) && p.m(this.mController.xRr, this.vCI) && (this.vCE == null || this.vCE.isEmpty() || this.vCE.contains(this.vCI))) {
                    Intent intent2 = new Intent(this.vCz);
                    intent2.setPackage(this.vCI);
                    if (bi.k(this, intent2)) {
                        z = true;
                    } else {
                        z = false;
                    }
                } else {
                    z = false;
                }
                if (!z || this.scene == 6) {
                    boolean z2;
                    this.bgS = getPackageManager();
                    this.vCy = new a();
                    v.bZh();
                    this.vCD = v.t(this.vCA, intent.getBundleExtra("key_recommend_params"));
                    this.vCL = this.vCD.ed(this.mController.xRr);
                    as.Hm();
                    this.vCJ = ((Integer) com.tencent.mm.y.c.Db().get(274496 + this.vCA, Integer.valueOf(0))).intValue();
                    v.bZh();
                    this.vCK = v.BT(this.vCA);
                    x.d("MicroMsg.AppChooserUI", "jiaminchen mRecommendAppAvailable is %s, mAppRecommendCount is %d", String.valueOf(this.vCL), Integer.valueOf(this.vCJ));
                    this.vCN = !intent.getBooleanExtra("not_show_recommend_app", false);
                    if (this.vCJ >= this.vCK) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    this.vCH = a(this.vCz, cdg(), this.vCE);
                    if (!(z2 || this.vCL)) {
                        as.Hm();
                        com.tencent.mm.y.c.Db().set(274496 + this.vCA, Integer.valueOf(this.vCJ + 1));
                    }
                    if (this.vCL) {
                        v.bZh();
                        v.BW(this.vCA);
                    } else if (!z2) {
                        v.bZh();
                        v.BV(this.vCA);
                    }
                    if (this.vCH == null || this.vCH.size() != 1 || (cdg() && !this.vCL)) {
                        setTitleVisibility(8);
                        if (this.vCH == null || this.vCH.isEmpty()) {
                            j(4097, null, false);
                            return;
                        }
                        this.vCy.lzC = this.vCH;
                        as.Hm();
                        this.vCO = ((Long) com.tencent.mm.y.c.Db().get(CQ(274560), Long.valueOf(0))).longValue();
                        FileDownloadTaskInfo bZ = com.tencent.mm.plugin.downloader.model.f.aAK().bZ(this.vCO);
                        x.d("MicroMsg.AppChooserUI", "downloadId:" + this.vCO + ", status:" + bZ.status);
                        if (3 == bZ.status && com.tencent.mm.a.e.bO(bZ.path) && this.vCy != null) {
                            this.vCy.vCW = f.vDj;
                            this.vCy.notifyDataSetChanged();
                        }
                        this.vCP = new e(this.mController.xRr);
                        e eVar = this.vCP;
                        if (stringExtra != null) {
                            eVar.mTitle = stringExtra.toString();
                        } else {
                            eVar.mTitle = null;
                        }
                        this.vCP.vDf = this.vCQ;
                        this.vCP.vCS = this.vCS;
                        this.vCP.vDg = this.vCR;
                        this.vCP.kUZ = this.vCy;
                        this.vCP.Gk = this.Gk;
                        e eVar2 = this.vCP;
                        if (eVar2.vDf != null) {
                            eVar2.vDe.setOnItemClickListener(eVar2.vDf);
                        }
                        if (eVar2.kUZ != null) {
                            eVar2.vDe.setAdapter(eVar2.kUZ);
                        }
                        eVar2.iqG = h.a(eVar2.mContext, true, eVar2.mTitle, eVar2.vDe, eVar2.mContext.getString(R.l.dHh), eVar2.mContext.getString(R.l.dHg), eVar2.vCS, eVar2.vDg, R.e.bsE);
                        eVar2.iqG.setOnDismissListener(eVar2.Gk);
                        eVar2.iqG.show();
                        if (!(this.vCM || !this.vCL || z2)) {
                            this.vCF = this.vCG;
                            this.vCP.lw(true);
                        }
                        com.tencent.mm.plugin.downloader.model.f.aAK();
                        com.tencent.mm.plugin.downloader.model.c.a(this.vCU);
                        return;
                    }
                    c cVar = (c) this.vCH.get(0);
                    if (cVar == null) {
                        j(4097, null, false);
                        return;
                    } else if (cVar.vCZ != null) {
                        j(-1, cVar.vCZ.activityInfo.packageName, false);
                        return;
                    } else {
                        j(4098, null, false);
                        return;
                    }
                }
                j(-1, this.vCI, true);
                return;
            }
            x.e("MicroMsg.AppChooserUI", "acc not ready");
            j(4097, null, false);
            return;
        }
        x.w("ChooseActivity", "Target is not an intent: " + parcelableExtra);
        j(0, null, false);
    }

    protected void onResume() {
        super.onResume();
        if (this.vCM && this.vCz != null && this.vCD.w(this, this.vCz)) {
            x.i("MicroMsg.AppChooserUI", "user installed lasted recommend app");
            this.vCM = false;
            this.vCG.vDd = false;
        }
        this.vCL = this.vCD.ed(this.mController.xRr);
        this.vCH = a(this.vCz, cdg(), this.vCE);
        if (this.vCL && this.vCF == null) {
            this.vCF = this.vCG;
            this.vCP.lw(true);
        }
        if (this.vCy != null) {
            this.vCy.lzC = this.vCH;
            this.vCy.notifyDataSetChanged();
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        com.tencent.mm.plugin.downloader.model.f.aAK();
        com.tencent.mm.plugin.downloader.model.c.b(this.vCU);
        if (this.vCP != null) {
            this.vCP.iqG.dismiss();
        }
    }

    protected final int getLayoutId() {
        return -1;
    }

    public void onBackPressed() {
        super.onBackPressed();
        j(0, null, false);
    }

    final int CQ(int i) {
        if (this.mimeType != null) {
            return (this.vCA + i) + this.mimeType.hashCode();
        }
        return this.vCA + i;
    }

    private void j(int i, String str, boolean z) {
        Intent intent = new Intent();
        intent.putExtra("selectpkg", str);
        intent.putExtra("isalways", z);
        intent.putExtra("transferback", this.vCC);
        setResult(i, intent);
        finish();
    }

    private boolean cdg() {
        x.d("MicroMsg.AppChooserUI", "mShouldShowRecommendApp %s | mAppRecommendCount %d | mAppMaxRecommendCount %d | isOverseasUser %s", Boolean.valueOf(this.vCN), Integer.valueOf(this.vCJ), Integer.valueOf(this.vCK), Boolean.valueOf(bi.PZ()));
        if (!this.vCN || this.vCJ >= this.vCK || bi.PZ() || com.tencent.mm.sdk.platformtools.f.fei == 1) {
            return false;
        }
        return true;
    }

    private List<c> a(Intent intent, boolean z, ArrayList<String> arrayList) {
        List<c> arrayList2 = new ArrayList();
        List queryIntentActivities = this.bgS.queryIntentActivities(intent, 65536);
        com.tencent.mm.pluginsdk.model.v.a bYY = this.vCD.bYY();
        if (!bi.oN(bYY.vkA)) {
            this.vCB = bYY.vkA;
        } else if (bYY.vkz > 0) {
            this.vCB = getResources().getString(bYY.vkz);
        }
        if (bYY.vky > 0) {
            this.vCG.vDb = getResources().getDrawable(bYY.vky);
        }
        if (bYY.vkB > 0) {
            this.vCG.vDa = getResources().getString(bYY.vkB);
        } else {
            this.vCG.vDa = bYY.vkC;
        }
        this.vCG.vDc = true;
        this.vCG.smA = this.vCL;
        if (this.vCL) {
            this.vCG.nGP = true;
        }
        if (this.vCM) {
            this.vCG.vDd = true;
        }
        Object obj = null;
        if (queryIntentActivities != null && queryIntentActivities.size() > 0) {
            int size = queryIntentActivities.size();
            int i = 0;
            while (i < size) {
                Object obj2;
                x.d("MicroMsg.AppChooserUI", "cpan name:%s", ((ResolveInfo) queryIntentActivities.get(i)).activityInfo.name);
                ResolveInfo resolveInfo = (ResolveInfo) queryIntentActivities.get(i);
                if (resolveInfo != null) {
                    String str = resolveInfo.activityInfo.packageName;
                    if (arrayList == null || arrayList.isEmpty() || arrayList.contains(str)) {
                        if (this.vCD.RV(str)) {
                            this.vCG.vCZ = resolveInfo;
                            this.vCG.nGP = true;
                            if ((!z && this.vCL) || (!z && this.vCG.nGP)) {
                                arrayList2.add(0, this.vCG);
                                obj2 = 1;
                                i++;
                                obj = obj2;
                            }
                        } else {
                            arrayList2.add(new c(resolveInfo, this.vCD.a(this.mController.xRr, resolveInfo)));
                        }
                    }
                }
                obj2 = obj;
                i++;
                obj = obj2;
            }
        }
        if (z && obj == null) {
            if (this.vCA != 0 || this.mimeType == null) {
                arrayList2.add(0, this.vCG);
            } else {
                arrayList2.add(0, this.vCG);
                if (this.vCM) {
                    g.pWK.h(11168, Integer.valueOf(2), Integer.valueOf(this.scene));
                } else {
                    g.pWK.h(11168, Integer.valueOf(1), Integer.valueOf(this.scene));
                }
            }
        }
        HashSet hashSet = new HashSet();
        for (int size2 = arrayList2.size() - 1; size2 >= 0; size2--) {
            c cVar = (c) arrayList2.get(size2);
            if (cVar.vCZ != null) {
                String str2 = cVar.vCZ.activityInfo.packageName;
                if (!(bi.oN(str2) || hashSet.add(str2))) {
                    arrayList2.remove(size2);
                }
            }
        }
        return arrayList2;
    }

    private static Drawable a(Resources resources, int i) {
        try {
            return com.tencent.mm.bv.a.b(resources, i);
        } catch (NotFoundException e) {
            return null;
        }
    }

    private Drawable c(ResolveInfo resolveInfo) {
        try {
            Drawable a;
            if (!(resolveInfo.resolvePackageName == null || resolveInfo.icon == 0)) {
                a = a(this.bgS.getResourcesForApplication(resolveInfo.resolvePackageName), resolveInfo.icon);
                if (a != null) {
                    return a;
                }
            }
            int iconResource = resolveInfo.getIconResource();
            if (iconResource != 0) {
                a = a(this.bgS.getResourcesForApplication(resolveInfo.activityInfo.packageName), iconResource);
                if (a != null) {
                    return a;
                }
            }
        } catch (NameNotFoundException e) {
            x.e("MicroMsg.AppChooserUI", "Couldn't find resources for package", e);
        }
        return resolveInfo.loadIcon(this.bgS);
    }
}
