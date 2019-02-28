package com.tencent.mm.plugin.ipcall.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.ipcall.a.d.m;
import com.tencent.mm.plugin.ipcall.a.e;
import com.tencent.mm.plugin.ipcall.a.e.d;
import com.tencent.mm.plugin.ipcall.a.g.f;
import com.tencent.mm.plugin.ipcall.b.c;
import com.tencent.mm.pluginsdk.i.a.b.b;
import com.tencent.mm.protocal.c.byb;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.FlowLayout;
import com.tencent.mm.ui.base.PasterEditText;
import com.tencent.mm.y.as;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Locale;

public final class g extends Dialog {
    private ScrollView jmE;
    View kTo;
    private Activity mActivity;
    private int mAm = R.e.bsn;
    private int mAn = R.g.bCh;
    private Context mContext;
    private ag mHandler = new ag();
    private ArrayList<a> mItemList;
    private OnClickListener mOnClickListener = new OnClickListener() {
        public final void onClick(View view) {
            if (view == g.this.nPH) {
                g.this.rR(1);
            } else if (view == g.this.nPI) {
                g.this.rR(2);
            } else if (view == g.this.nPJ) {
                g.this.rR(3);
            }
        }
    };
    private int nPC = 0;
    private int nPD;
    private long nPE;
    private LinearLayout nPF;
    private LinearLayout nPG;
    private RelativeLayout nPH;
    private RelativeLayout nPI;
    private RelativeLayout nPJ;
    private ImageView nPK;
    private ImageView nPL;
    private ImageView nPM;
    private int nPN;
    private FrameLayout nPO;
    private FlowLayout nPP;
    private Button nPQ;
    private Button nPR;
    private PasterEditText nPS;
    private Button nPT;
    private Button nPU;
    private TextView nPV;
    private Animation nPW;
    private int nPX = R.g.bCg;
    private int nPY = R.e.buk;
    private CharSequence uU;

    public static class a {
        public String nMq;
        public String nMr;
        public boolean nQb;
    }

    static /* synthetic */ void a(g gVar, TextView textView) {
        a aVar = (a) textView.getTag();
        textView.setTextSize(0, gVar.getContext().getResources().getDimension(R.f.bxk) * com.tencent.mm.bu.a.ev(gVar.getContext()));
        if (aVar.nQb) {
            textView.setBackgroundResource(gVar.nPX);
            textView.setTextColor(gVar.mContext.getResources().getColor(gVar.nPY));
            textView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            return;
        }
        textView.setBackgroundResource(gVar.mAn);
        textView.setTextColor(gVar.mContext.getResources().getColor(gVar.mAm));
        textView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
    }

    static /* synthetic */ void g(g gVar) {
        as.CN().a(new m(gVar.nPD, gVar.nPN, gVar.rT(gVar.nPN)), 0);
        if (gVar.nPN == 3) {
            gVar.rU(2);
            return;
        }
        gVar.hide();
        gVar.mHandler.postDelayed(new Runnable() {
            public final void run() {
                g.this.dismiss();
            }
        }, 1800);
        com.tencent.mm.ui.snackbar.a.h(gVar.mActivity, gVar.mContext.getString(R.l.erP));
        d.a(1, -1, gVar.nPN, gVar.rS(gVar.nPN), 0, -1, -1, gVar.nPD, gVar.nPE);
    }

    public g(Activity activity, Context context, int i, long j) {
        CharSequence format;
        super(context, R.m.eZl);
        setCancelable(false);
        this.mContext = context;
        this.nPD = i;
        this.nPE = j;
        this.mActivity = activity;
        this.kTo = View.inflate(this.mContext, R.i.dmp, null);
        this.nPF = (LinearLayout) this.kTo.findViewById(R.h.csE);
        this.nPG = (LinearLayout) this.kTo.findViewById(R.h.csF);
        this.nPW = AnimationUtils.loadAnimation(ad.getContext(), R.a.bpO);
        this.nPW.setDuration(200);
        this.nPW.setStartOffset(100);
        aVd();
        this.nPH = (RelativeLayout) this.kTo.findViewById(R.h.csI);
        this.nPI = (RelativeLayout) this.kTo.findViewById(R.h.csJ);
        this.nPJ = (RelativeLayout) this.kTo.findViewById(R.h.csK);
        this.nPH.setOnClickListener(this.mOnClickListener);
        this.nPI.setOnClickListener(this.mOnClickListener);
        this.nPJ.setOnClickListener(this.mOnClickListener);
        this.nPK = (ImageView) this.kTo.findViewById(R.h.cpE);
        this.nPL = (ImageView) this.kTo.findViewById(R.h.cpF);
        this.nPM = (ImageView) this.kTo.findViewById(R.h.cpG);
        this.nPN = 0;
        rR(this.nPN);
        this.nPT = (Button) this.kTo.findViewById(R.h.cpX);
        this.nPU = (Button) this.kTo.findViewById(R.h.cpY);
        this.nPV = (TextView) this.kTo.findViewById(R.h.cpZ);
        if (c.aVw() != null) {
            format = String.format(this.mContext.getString(R.l.eso), new Object[]{r0.wwI});
        } else {
            format = null;
        }
        if (bi.oN(format)) {
            this.nPV.setVisibility(4);
        } else {
            this.nPV.setVisibility(0);
            this.nPV.setText(format);
        }
        this.nPT.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                g.this.dismiss();
                d.a(1, -1, g.this.nPN, g.this.rS(g.this.nPN), 1, -1, 1, g.this.nPD, g.this.nPE);
            }
        });
        this.nPU.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                g.this.dismiss();
                Intent intent = new Intent();
                intent.putExtra("IPCallShareCouponCardUI_KFrom", 2);
                intent.setClass(g.this.mContext, IPCallShareCouponCardUI.class);
                g.this.mContext.startActivity(intent);
                d.a(1, -1, g.this.nPN, g.this.rS(g.this.nPN), 1, 1, -1, g.this.nPD, g.this.nPE);
            }
        });
        this.jmE = (ScrollView) this.kTo.findViewById(R.h.chA);
        final View childAt = ((ViewGroup) this.mActivity.findViewById(16908290)).getChildAt(0);
        childAt.getViewTreeObserver().addOnGlobalLayoutListener(new OnGlobalLayoutListener() {
            public final void onGlobalLayout() {
                Rect rect = new Rect();
                childAt.getWindowVisibleDisplayFrame(rect);
                if (childAt.getRootView().getHeight() - (rect.bottom - rect.top) > 100) {
                    g gVar = g.this;
                    gVar.kTo.postDelayed(new Runnable() {
                        public final void run() {
                            g.this.jmE.fullScroll(130);
                        }
                    }, 100);
                }
            }
        });
    }

    protected final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(this.kTo);
        getWindow().getAttributes().width = getWindow().getWindowManager().getDefaultDisplay().getWidth();
        getWindow().getDecorView().setPadding(0, 0, 0, 0);
        rU(0);
    }

    private void rR(int i) {
        this.nPN = i;
        if (i == 0) {
            this.nPK.setVisibility(4);
            this.nPL.setVisibility(4);
            this.nPM.setVisibility(4);
            this.nPR.setEnabled(false);
            rU(0);
        } else if (i == 1) {
            this.nPK.setVisibility(0);
            this.nPL.setVisibility(4);
            this.nPM.setVisibility(4);
            this.nPR.setEnabled(true);
            rU(1);
        } else if (i == 2) {
            this.nPK.setVisibility(0);
            this.nPL.setVisibility(0);
            this.nPM.setVisibility(4);
            this.nPR.setEnabled(true);
            rU(1);
        } else if (i == 3) {
            this.nPK.setVisibility(0);
            this.nPL.setVisibility(0);
            this.nPM.setVisibility(0);
            this.nPR.setEnabled(true);
            rU(0);
        }
    }

    private void aVd() {
        String eA;
        f fVar;
        this.nPO = (FrameLayout) this.kTo.findViewById(R.h.cio);
        this.nPP = (FlowLayout) this.kTo.findViewById(R.h.cin);
        this.nPQ = (Button) this.kTo.findViewById(R.h.bWQ);
        this.nPR = (Button) this.kTo.findViewById(R.h.bWR);
        this.nPS = (PasterEditText) this.kTo.findViewById(R.h.bWW);
        this.nPQ.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                g.this.dismiss();
                int i = -1;
                d.a(-1, 1, i, "", 0, -1, -1, g.this.nPD, g.this.nPE);
            }
        });
        this.nPR.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                g.g(g.this);
            }
        });
        e aTX = e.aTX();
        if (aTX.nIe == null) {
            x.i("MicroMsg.IPCallFeedbackConfigUpdater", "getCurrentLanugageResource try get cacheResUpdate");
            c.vnr;
            eA = b.eA(39, 1);
            if (bi.oN(eA)) {
                x.i("MicroMsg.IPCallFeedbackConfigUpdater", "getCurrentLanugageResource get cacheResUpdate no filePath");
            } else {
                byte[] e = com.tencent.mm.a.e.e(eA, 0, -1);
                if (e != null) {
                    aTX.aB(e);
                } else {
                    x.e("MicroMsg.IPCallFeedbackConfigUpdater", "getCurrentLanugageResource file not exist");
                }
            }
        }
        if (aTX.nIe != null) {
            String str;
            eA = w.e(ad.getContext().getSharedPreferences(ad.cgf(), 0));
            if (!"language_default".equalsIgnoreCase(eA) || Locale.getDefault() == null) {
                str = eA;
            } else {
                str = Locale.getDefault().toString();
            }
            Iterator it = aTX.nIe.iterator();
            while (it.hasNext()) {
                fVar = (f) it.next();
                if (str.equalsIgnoreCase(fVar.nMs)) {
                    x.i("MicroMsg.IPCallFeedbackConfigUpdater", "curLang: %s,resListCount: %s", str, Integer.valueOf(aTX.nIe.size()));
                    break;
                }
            }
            x.e("MicroMsg.IPCallFeedbackConfigUpdater", "no lanuage equal curLang, curLang: %s,resListCount: %s", str, Integer.valueOf(aTX.nIe.size()));
        }
        fVar = null;
        if (fVar != null) {
            ArrayList arrayList = fVar.nMt;
            ArrayList arrayList2 = new ArrayList();
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                com.tencent.mm.plugin.ipcall.a.g.e eVar = (com.tencent.mm.plugin.ipcall.a.g.e) it2.next();
                a aVar = new a();
                aVar.nMq = eVar.nMq;
                aVar.nMr = eVar.nMr;
                aVar.nQb = false;
                arrayList2.add(aVar);
            }
            this.mItemList = arrayList2;
            Iterator it3 = this.mItemList.iterator();
            while (it3.hasNext()) {
                a aVar2 = (a) it3.next();
                FlowLayout flowLayout = this.nPP;
                View textView = new TextView(getContext());
                textView.setTextSize(0, getContext().getResources().getDimension(R.f.bxk) * com.tencent.mm.bu.a.ev(getContext()));
                textView.setBackgroundResource(this.mAn);
                textView.setTextColor(this.mContext.getResources().getColor(this.mAm));
                textView.setTag(aVar2);
                textView.setGravity(17);
                textView.setEllipsize(TruncateAt.END);
                textView.setSingleLine();
                textView.setText(aVar2.nMr);
                textView.setOnClickListener(new OnClickListener() {
                    public final void onClick(View view) {
                        a aVar = (a) view.getTag();
                        if (aVar.nQb) {
                            aVar.nQb = false;
                        } else {
                            aVar.nQb = true;
                        }
                        g.a(g.this, (TextView) view);
                    }
                });
                flowLayout.addView(textView);
            }
        }
    }

    private String rS(int i) {
        String str = "";
        if (i == 3) {
            return "";
        }
        if (!bi.oN(this.nPS.getText().toString().trim())) {
            str = "0";
        }
        if (this.mItemList == null) {
            return str;
        }
        Iterator it = this.mItemList.iterator();
        while (true) {
            String str2 = str;
            if (!it.hasNext()) {
                return str2;
            }
            a aVar = (a) it.next();
            if (!aVar.nQb) {
                str = str2;
            } else if (str2.equals("")) {
                str = aVar.nMq;
            } else {
                str = str2 + "_" + aVar.nMq;
            }
        }
    }

    private LinkedList<byb> rT(int i) {
        LinkedList<byb> linkedList = new LinkedList();
        if (i == 3) {
            return linkedList;
        }
        String trim = this.nPS.getText().toString().trim();
        if (!bi.oN(trim)) {
            byb byb = new byb();
            byb.fgJ = 0;
            byb.noL = trim;
            linkedList.add(byb);
        }
        if (this.mItemList != null) {
            Iterator it = this.mItemList.iterator();
            while (it.hasNext()) {
                a aVar = (a) it.next();
                if (aVar.nQb) {
                    byb byb2 = new byb();
                    try {
                        byb2.fgJ = bi.getInt(aVar.nMq, 0);
                        linkedList.add(byb2);
                    } catch (NumberFormatException e) {
                        x.e("MicroMsg.IPCallFeedbackDialog", "getFeedbackList error, id = " + aVar.nMq);
                    }
                }
            }
        }
        return linkedList;
    }

    public final void setTitle(CharSequence charSequence) {
        if (charSequence != null) {
            this.uU = charSequence;
        } else {
            this.uU = null;
        }
    }

    public final void show() {
        super.show();
    }

    public final void dismiss() {
        try {
            super.dismiss();
        } catch (Exception e) {
            x.e("MicroMsg.IPCallFeedbackDialog", "dismiss exception, e = " + e.getMessage());
        }
    }

    private void rU(int i) {
        if (i == 0) {
            this.nPF.setVisibility(0);
            this.nPG.setVisibility(4);
            if (this.nPC == 1) {
                ((LayoutParams) this.nPO.getLayoutParams()).height = 0;
                this.nPO.requestLayout();
            }
            bi.hideVKB(this.kTo);
        } else if (i == 1) {
            this.nPF.setVisibility(0);
            this.nPG.setVisibility(4);
            if (this.nPC == 0) {
                ((LayoutParams) this.nPO.getLayoutParams()).height = -2;
                this.nPO.requestLayout();
                this.nPO.startAnimation(this.nPW);
            }
        } else if (i == 2) {
            this.nPF.setVisibility(4);
            this.nPG.setVisibility(0);
            bi.hideVKB(this.kTo);
        }
        this.nPC = i;
    }
}
