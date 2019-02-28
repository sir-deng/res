package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.plugin.sns.data.SnsCmdList;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.model.b.b;
import com.tencent.mm.plugin.sns.model.p;
import com.tencent.mm.plugin.sns.model.q;
import com.tencent.mm.plugin.sns.storage.i;
import com.tencent.mm.plugin.sns.storage.m;
import com.tencent.mm.plugin.sns.storage.u;
import com.tencent.mm.protocal.c.ako;
import com.tencent.mm.protocal.c.are;
import com.tencent.mm.protocal.c.bko;
import com.tencent.mm.protocal.c.ble;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.ar;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMImageView;
import com.tencent.mm.ui.base.MMSlideDelView;
import com.tencent.mm.ui.base.MMSlideDelView.c;
import com.tencent.mm.ui.base.MMSlideDelView.f;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p.d;
import com.tencent.mm.ui.base.r;
import com.tencent.mm.ui.o;
import com.tencent.mm.ui.v;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SnsMsgUI extends MMActivity implements e, b {
    private ag handler = ae.aOA();
    private String hnt;
    private View jRL;
    private d kHD = new d() {
        public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
            switch (menuItem.getItemId()) {
                case 0:
                    SnsMsgUI.a(SnsMsgUI.this, SnsMsgUI.this.ruQ);
                    return;
                case 1:
                    h.a((Context) SnsMsgUI.this, SnsMsgUI.this.getString(j.qPI), "", SnsMsgUI.this.getString(j.qPH), SnsMsgUI.this.getString(j.dEy), new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            SnsMsgUI.a(SnsMsgUI.this, true);
                        }
                    }, null);
                    return;
                case 2:
                    SnsMsgUI.a(SnsMsgUI.this, false);
                    return;
                default:
                    return;
            }
        }
    };
    private View lap = null;
    private boolean laq = false;
    private ListView nQn;
    private View nQp;
    private ar rFL;
    private boolean rJA = false;
    private boolean rJB = false;
    private r rJC;
    private int[] rJD = new int[2];
    private View.OnClickListener rJE = new View.OnClickListener() {
        public final void onClick(View view) {
            if (view.getTag() instanceof ap) {
                SnsMsgUI.this.rxB.a(view, -1, null);
            } else if (view.getTag() instanceof i) {
                SnsMsgUI.a(SnsMsgUI.this, (i) view.getTag());
            } else {
                x.w("MicroMsg.SnsMsgUI", "v.getTag():" + view.getTag());
            }
        }
    };
    private com.tencent.mm.sdk.e.j.a rJF = new com.tencent.mm.sdk.e.j.a() {
        public final void a(String str, l lVar) {
            ae.aOA().post(new Runnable() {
                public final void run() {
                    synchronized (SnsMsgUI.this.rJy) {
                        x.v("MicroMsg.SnsMsgUI", "comment notify");
                        SnsMsgUI.this.rJA = true;
                        SnsMsgUI.this.rJy.a(null, null);
                    }
                }
            });
        }
    };
    Runnable rJG = new Runnable() {
        public final void run() {
            if (SnsMsgUI.this.rJy != null) {
                synchronized (SnsMsgUI.this.rJy) {
                    SnsMsgUI.this.rJy.a(null, null);
                    SnsMsgUI.this.rJz = false;
                }
            }
        }
    };
    private a rJy;
    private boolean rJz = false;
    long rgW;
    int ruQ;
    private ao rxB;
    private SnsCmdList rzl = new SnsCmdList();

    class a extends o<i> {
        int hLP = this.las;
        protected f kHo;
        protected c kHp;
        protected MMSlideDelView.d kHr = new MMSlideDelView.d() {
            public final void a(MMSlideDelView mMSlideDelView, boolean z) {
                if (z) {
                    nQt.add(mMSlideDelView);
                } else {
                    nQt.remove(mMSlideDelView);
                }
            }

            public final boolean aVe() {
                return nQt.size() > 0;
            }

            public final void aVf() {
                for (MMSlideDelView mMSlideDelView : nQt) {
                    if (mMSlideDelView != null) {
                        mMSlideDelView.cqp();
                    }
                }
                nQt.clear();
            }

            public final void aVg() {
                for (MMSlideDelView mMSlideDelView : nQt) {
                    if (mMSlideDelView != null) {
                        mMSlideDelView.cqo();
                    }
                }
                nQt.clear();
            }
        };
        int las = 10;
        private Set<MMSlideDelView> nQt = new HashSet();
        protected MMSlideDelView.e rJL;

        class a {
            View kHy;
            TextView kHz;
            TextView maq;
            TextView ppG;
            long qWM;
            ImageView rJN;
            TextView rJO;
            ImageView rJP;
            TextView rJQ;
            MMImageView rJR;
            ImageView rJS;

            a() {
            }
        }

        public final /* synthetic */ Object a(Object obj, Cursor cursor) {
            i iVar = (i) obj;
            if (iVar == null) {
                iVar = new i();
                x.d("MicroMsg.SnsMsgUI", "new SnsComment");
            }
            iVar.b(cursor);
            return iVar;
        }

        public a(Context context, i iVar) {
            super(context, iVar);
        }

        public final long getItemId(int i) {
            return ((i) getItem(i)).field_snsID;
        }

        protected final void XI() {
            aUU();
            XH();
        }

        public final void a(f fVar) {
            this.kHo = fVar;
        }

        public final void b(MMSlideDelView.e eVar) {
            this.rJL = eVar;
        }

        public final void a(c cVar) {
            this.kHp = cVar;
        }

        public final synchronized void a(String str, l lVar) {
            super.a(str, lVar);
        }

        public final void XH() {
            if (ae.bwk().Tx() <= 0 || SnsMsgUI.this.rJA) {
                this.hLP = ae.bwk().byM();
                com.tencent.mm.plugin.sns.storage.j bwk = ae.bwk();
                String str = com.tencent.mm.plugin.sns.storage.j.byK() + " where isSend = 0 order by createTime desc LIMIT " + this.las;
                x.v("MicroMsg.SnsCommentStorage", "getCursor sql:" + str);
                setCursor(bwk.hiZ.a(str, null, 0));
            } else {
                setCursor(ae.bwk().byL());
            }
            notifyDataSetChanged();
        }

        public final boolean awL() {
            return this.las >= this.hLP;
        }

        public final int awM() {
            if (awL()) {
                if (SnsMsgUI.this.lap.getParent() != null) {
                    SnsMsgUI.this.nQn.removeFooterView(SnsMsgUI.this.lap);
                }
                return 0;
            }
            this.las += 10;
            if (this.las <= this.hLP) {
                return 10;
            }
            this.las = this.hLP;
            return this.hLP % 10;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            a aVar;
            i iVar = (i) getItem(i);
            if (view == null || !(view.getTag() instanceof a)) {
                View view2 = (MMSlideDelView) v.fw(this.context).inflate(g.dbe, null);
                View inflate = v.fw(this.context).inflate(g.qNF, null);
                a aVar2 = new a();
                aVar2.rJN = (ImageView) inflate.findViewById(com.tencent.mm.plugin.sns.i.f.qKQ);
                aVar2.ppG = (TextView) inflate.findViewById(com.tencent.mm.plugin.sns.i.f.qKX);
                aVar2.rJQ = (TextView) inflate.findViewById(com.tencent.mm.plugin.sns.i.f.qKR);
                aVar2.rJP = (ImageView) inflate.findViewById(com.tencent.mm.plugin.sns.i.f.qKV);
                aVar2.maq = (TextView) inflate.findViewById(com.tencent.mm.plugin.sns.i.f.qKY);
                aVar2.rJR = (MMImageView) inflate.findViewById(com.tencent.mm.plugin.sns.i.f.qKT);
                aVar2.rJO = (TextView) inflate.findViewById(com.tencent.mm.plugin.sns.i.f.qKZ);
                aVar2.rJR.setOnClickListener(SnsMsgUI.this.rJE);
                aVar2.kHy = view2.findViewById(com.tencent.mm.plugin.sns.i.f.cOJ);
                aVar2.kHz = (TextView) view2.findViewById(com.tencent.mm.plugin.sns.i.f.cOK);
                aVar2.rJS = (ImageView) inflate.findViewById(com.tencent.mm.plugin.sns.i.f.qLs);
                view2.setView(inflate);
                view2.kHo = this.kHo;
                view2.kHp = this.kHp;
                view2.kHr = this.kHr;
                view2.mGx = false;
                view2.setTag(aVar2);
                aVar = aVar2;
                view = view2;
            } else {
                aVar = (a) view.getTag();
            }
            aVar.rJR.setTag(null);
            aVar.qWM = iVar.field_snsID;
            aVar.kHy.setTag(Integer.valueOf(iVar.ruQ));
            aVar.kHy.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    x.v("MicroMsg.SnsMsgUI", "on delView clicked");
                    a.this.kHr.aVg();
                    if (a.this.rJL != null) {
                        a.this.rJL.bp(view.getTag());
                    }
                }
            });
            String str = "";
            bko bko = (bko) new bko().aH(iVar.field_curActionBuf);
            String str2;
            com.tencent.mm.k.a Xv;
            CharSequence AX;
            m eS;
            String str3;
            TextView textView;
            int i2;
            Object obj;
            TextView textView2;
            long j;
            Drawable b;
            String str4;
            com.tencent.mm.plugin.sns.storage.e eL;
            com.tencent.mm.storage.x Xt;
            ako ako;
            com.tencent.mm.ui.widget.e eVar;
            ako ako2;
            com.tencent.mm.plugin.sns.storage.e eL2;
            m mVar;
            List list;
            Object obj2;
            int i3;
            MMImageView mMImageView;
            int i4;
            com.tencent.mm.sdk.e.c iVar2;
            try {
                str2 = ((bko) new bko().aH(iVar.field_refActionBuf)).wNo;
                try {
                    if (bi.oN(str2) || str2.equals(ae.bvL())) {
                        str = "";
                        try {
                            if (bi.oN(bko.wNo)) {
                                com.tencent.mm.pluginsdk.ui.a.b.a(aVar.rJN, bko.wNo);
                                str2 = bko.wNo;
                                aVar.rJN.setOnClickListener(new View.OnClickListener() {
                                    public final void onClick(View view) {
                                        Intent intent = new Intent();
                                        intent.putExtra("Contact_User", str2);
                                        com.tencent.mm.plugin.sns.c.a.ihN.d(intent, SnsMsgUI.this);
                                    }
                                });
                            } else {
                                x.e("MicroMsg.SnsMsgUI", "action.getFromUsername() is null or Nil");
                            }
                            Xv = SnsMsgUI.this.rFL.Xv(bko.wNo);
                            if (Xv == null) {
                                AX = Xv.AX();
                            } else if (bi.oN(bko.wUk)) {
                                AX = bko.wUk;
                            } else {
                                AX = bko.wNo;
                            }
                            aVar.ppG.setText(com.tencent.mm.pluginsdk.ui.d.i.b(SnsMsgUI.this, AX, aVar.ppG.getTextSize()));
                            eS = ae.bwf().eS(iVar.field_snsID);
                            if (eS == null && eS.field_type == 21) {
                                aVar.ppG.setTextColor(SnsMsgUI.this.getResources().getColor(com.tencent.mm.plugin.sns.i.c.ltu));
                            } else {
                                aVar.ppG.setTextColor(SnsMsgUI.this.getResources().getColor(com.tencent.mm.plugin.sns.i.c.btS));
                            }
                            str3 = bko.wNo;
                            textView = aVar.ppG;
                            i2 = bko.vON;
                            switch (iVar.field_type) {
                                case 1:
                                case 2:
                                    obj = null;
                                    break;
                                case 3:
                                case 5:
                                    obj = 1;
                                    break;
                                case 4:
                                    obj = null;
                                    break;
                                case 7:
                                case 8:
                                case 13:
                                case 14:
                                    obj = null;
                                    break;
                                default:
                                    obj = 1;
                                    break;
                            }
                            if (obj != null || SnsMsgUI.this.hnt.equals(str3)) {
                                textView.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
                            } else {
                                Drawable b2;
                                switch (i2) {
                                    case 18:
                                        b2 = com.tencent.mm.bu.a.b(this.context, com.tencent.mm.plugin.sns.i.e.qFE);
                                        break;
                                    case 22:
                                    case 23:
                                    case 24:
                                    case 26:
                                    case 27:
                                    case 28:
                                    case 29:
                                        b2 = com.tencent.mm.bu.a.b(this.context, com.tencent.mm.plugin.sns.i.e.qFG);
                                        break;
                                    case 25:
                                        b2 = com.tencent.mm.bu.a.b(this.context, com.tencent.mm.plugin.sns.i.e.qFC);
                                        break;
                                    case 30:
                                        b2 = com.tencent.mm.bu.a.b(this.context, com.tencent.mm.plugin.sns.i.e.qFD);
                                        break;
                                    default:
                                        b2 = com.tencent.mm.bu.a.b(this.context, com.tencent.mm.plugin.sns.i.e.qFF);
                                        break;
                                }
                                textView.setCompoundDrawablesWithIntrinsicBounds(null, null, b2, null);
                            }
                            textView2 = aVar.rJQ;
                            j = iVar.field_snsID;
                            if (((iVar.field_commentflag & 1) <= 0 ? 1 : null) == null) {
                                textView2.setTextColor(SnsMsgUI.this.getResources().getColor(com.tencent.mm.plugin.sns.i.c.black));
                                textView2.setBackgroundDrawable(null);
                                textView2.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
                                textView2.setText("");
                                textView2.setCompoundDrawablePadding(0);
                                switch (bko.kzz) {
                                    case 1:
                                    case 5:
                                        eS = ae.bwf().eS(iVar.field_snsID);
                                        if (eS != null || eS.field_type != 7) {
                                            b = com.tencent.mm.bu.a.b(this.context, com.tencent.mm.plugin.sns.i.i.qON);
                                            if (eS == null && eS.field_type == 21) {
                                                b.setColorFilter(SnsMsgUI.this.getResources().getColor(com.tencent.mm.plugin.sns.i.c.qED), Mode.SRC_ATOP);
                                            } else {
                                                b.clearColorFilter();
                                            }
                                            b.setBounds(0, 0, b.getIntrinsicWidth(), b.getIntrinsicHeight());
                                            AX = new SpannableString(" ");
                                            AX.setSpan(new ImageSpan(b), 0, 1, 18);
                                            textView2.setText(AX);
                                            textView2.setContentDescription(SnsMsgUI.this.mController.xRr.getString(j.qQR));
                                            break;
                                        }
                                        textView2.setText(SnsMsgUI.this.getString(j.qRB));
                                        break;
                                        break;
                                    case 2:
                                    case 3:
                                        str4 = bko.noL;
                                        str2 = "";
                                        eL = ae.bwi().eL(iVar.field_snsID);
                                        if (bko.wUs != 1) {
                                            if (eL != null) {
                                                com.tencent.mm.kernel.g.Dr();
                                                Xt = ((com.tencent.mm.plugin.messenger.foundation.a.h) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).Ff().Xt(eL.field_userName);
                                                str2 = this.context.getString(j.qRL, new Object[]{Xt.AX()});
                                            }
                                        } else if (!bi.oN(str)) {
                                            str2 = this.context.getString(j.qRM, new Object[]{str});
                                        }
                                        textView2.setText(com.tencent.mm.pluginsdk.ui.d.i.b(SnsMsgUI.this, str2 + str4 + " ", textView2.getTextSize()));
                                        break;
                                    case 4:
                                        textView2.setText(SnsMsgUI.this.getString(j.qSB));
                                        break;
                                    case 7:
                                        textView2.setCompoundDrawablesWithIntrinsicBounds(com.tencent.mm.bu.a.b(this.context, com.tencent.mm.plugin.sns.i.i.qON), null, null, null);
                                        textView2.setContentDescription(SnsMsgUI.this.mController.xRr.getString(j.qQR));
                                        break;
                                    case 8:
                                        str2 = "";
                                        str4 = bko.noL;
                                        eL = ae.bwi().eL(iVar.field_snsID);
                                        if (bko.wUs != 1) {
                                            if (eL != null) {
                                                com.tencent.mm.kernel.g.Dr();
                                                Xt = ((com.tencent.mm.plugin.messenger.foundation.a.h) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).Ff().Xt(eL.field_userName);
                                                str2 = this.context.getString(j.qRL, new Object[]{Xt.AX()});
                                            }
                                        } else if (!bi.oN(str)) {
                                            str2 = this.context.getString(j.qRM, new Object[]{str});
                                        }
                                        textView2.setText(com.tencent.mm.pluginsdk.ui.d.i.b(SnsMsgUI.this, str2 + str4 + " ", textView2.getTextSize()));
                                        break;
                                    case 13:
                                        ako = new ako();
                                        x.i("MicroMsg.SnsMsgUI", "curAction.HBBuffer " + bko.wUr);
                                        try {
                                            ako.aH(n.a(bko.wUr));
                                            x.i("MicroMsg.SnsMsgUI", "hbbuffer  " + ako.fMM);
                                        } catch (Exception e) {
                                            x.e("MicroMsg.SnsMsgUI", "parser hbbuffer " + e.getMessage());
                                        }
                                        SnsMsgUI.this.rFL.Xv(bko.wNo);
                                        b = null;
                                        if (ako.fMM != 0) {
                                            SnsMsgUI.this.rJB = true;
                                            AX = new SpannableString(SnsMsgUI.this.getString(j.qPE));
                                        } else {
                                            SnsMsgUI.this.rJB = false;
                                            AX = new SpannableString(" " + SnsMsgUI.this.getString(j.qPD, new Object[]{bi.t(((double) ako.fMM) / 100.0d)}));
                                            b = SnsMsgUI.this.getResources().getDrawable(com.tencent.mm.plugin.sns.i.e.qEW);
                                        }
                                        if (b != null) {
                                            b.setBounds(0, 0, b.getIntrinsicWidth(), b.getIntrinsicHeight());
                                            eVar = new com.tencent.mm.ui.widget.e(b, 1);
                                            eVar.zCd = (int) (((((float) b.getIntrinsicHeight()) - textView2.getTextSize()) + ((float) com.tencent.mm.bu.a.fromDPToPix(SnsMsgUI.this, 2))) / 2.0f);
                                            AX.setSpan(eVar, 0, 1, 33);
                                        }
                                        textView2.setText(AX);
                                        break;
                                    case 14:
                                        ako2 = new ako();
                                        x.i("MicroMsg.SnsMsgUI", "curAction.HBBuffer " + bko.wUr);
                                        try {
                                            ako2.aH(n.a(bko.wUr));
                                            x.i("MicroMsg.SnsMsgUI", "hbbuffer  " + ako2.fMM);
                                        } catch (Exception e2) {
                                            x.e("MicroMsg.SnsMsgUI", "parser hbbuffer " + e2.getMessage());
                                        }
                                        Xv = SnsMsgUI.this.rFL.Xv(bko.wNo);
                                        textView2.setText(SnsMsgUI.this.getString(j.qPC, new Object[]{Xv.AX(), bi.t(((double) ako2.fMM) / 100.0d)}));
                                        break;
                                }
                            }
                            textView2.setText(j.qRI);
                            textView2.setBackgroundColor(SnsMsgUI.this.getResources().getColor(com.tencent.mm.plugin.sns.i.c.qEx));
                            textView2.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
                            aVar.maq.setText(az.k(SnsMsgUI.this, ((long) bko.pgR) * 1000));
                            eS = null;
                            if (bko.kzz != 7 || bko.kzz == 8) {
                                eL2 = ae.bwi().eL(iVar.field_snsID);
                                if (eL2 != null) {
                                    eS = eL2.byH();
                                }
                                mVar = eS;
                            } else {
                                mVar = ae.bwf().eS(iVar.field_snsID);
                            }
                            aVar.rJR.setVisibility(8);
                            aVar.rJO.setVisibility(8);
                            aVar.rJS.setVisibility(8);
                            aVar.rJR.setImageBitmap(null);
                            ae.bwc().cw(aVar.rJR);
                            if (mVar == null) {
                                list = mVar.byF().wYj.wfh;
                                if (mVar.field_type != 2) {
                                    aVar.rJR.setTag(null);
                                    aVar.rJO.setVisibility(0);
                                    aVar.rJO.setText(com.tencent.mm.pluginsdk.ui.d.i.b(SnsMsgUI.this, mVar.byF().wYg, aVar.rJO.getTextSize()));
                                } else {
                                    obj2 = null;
                                    if (list.size() > 0) {
                                        i3 = mVar.field_type;
                                        mMImageView = aVar.rJR;
                                        i4 = -1;
                                        switch (i3) {
                                            case 1:
                                                i4 = com.tencent.mm.plugin.sns.i.e.byW;
                                                break;
                                            case 2:
                                                mMImageView.setImageDrawable(null);
                                                break;
                                            case 3:
                                                i4 = com.tencent.mm.plugin.sns.i.i.dvO;
                                                break;
                                            case 4:
                                                i4 = com.tencent.mm.plugin.sns.i.i.dvy;
                                                break;
                                            case 5:
                                                i4 = com.tencent.mm.plugin.sns.i.i.dvL;
                                                break;
                                            case 6:
                                                i4 = com.tencent.mm.plugin.sns.i.i.dvx;
                                                break;
                                            case 7:
                                                i4 = com.tencent.mm.plugin.sns.i.e.byW;
                                                break;
                                            case 8:
                                                mMImageView.setImageDrawable(null);
                                                break;
                                            default:
                                                i4 = com.tencent.mm.plugin.sns.i.i.dvO;
                                                break;
                                        }
                                        ae.bwc().b((are) list.get(0), aVar.rJR, i4, SnsMsgUI.this.hashCode(), an.xHv);
                                        if (mVar.field_type != 15 || (mVar.field_type == 27 && list.size() > 0 && ((are) list.get(0)).kzz == 6)) {
                                            aVar.rJS.setVisibility(0);
                                            iVar2 = new i();
                                            ae.bwk().b(iVar.xrR, iVar2);
                                            aVar.rJR.setTag(iVar2);
                                            obj2 = 1;
                                        } else {
                                            ap apVar = new ap();
                                            apVar.fvn = mVar.bza();
                                            apVar.index = 0;
                                            List arrayList = new ArrayList();
                                            arrayList.add(aVar.rJR);
                                            apVar.rHV = arrayList;
                                            apVar.position = i;
                                            aVar.rJR.setTag(apVar);
                                            i3 = 1;
                                        }
                                    }
                                    mMImageView = aVar.rJR;
                                    if (obj2 == null) {
                                        i3 = 0;
                                    } else {
                                        i3 = 8;
                                    }
                                    mMImageView.setVisibility(i3);
                                }
                            } else if (!(bko.kzz == 7 || bko.kzz == 8 || !p.ew(iVar.field_snsID))) {
                                com.tencent.mm.kernel.g.Dr();
                                com.tencent.mm.kernel.g.Dp().gRu.a(new p(iVar.field_snsID), 0);
                            }
                        } catch (Throwable e3) {
                            x.printErrStackTrace("MicroMsg.SnsMsgUI", e3, "", new Object[0]);
                        }
                        obj2 = (aVar.rJR.getVisibility() != 0 || aVar.rJS.getVisibility() == 0) ? 1 : null;
                        view.findViewById(com.tencent.mm.plugin.sns.i.f.qKW).setVisibility(obj2 == null ? 0 : 8);
                        view.findViewById(com.tencent.mm.plugin.sns.i.f.qLt).setVisibility(iVar.field_isSilence != 1 ? 0 : 8);
                        return view;
                    }
                    com.tencent.mm.k.a Xv2 = SnsMsgUI.this.rFL.Xv(str2);
                    if (!(Xv2 == null || bi.oN(Xv2.AX()))) {
                        str2 = Xv2.AX();
                    }
                    str = str2;
                    if (bi.oN(bko.wNo)) {
                        x.e("MicroMsg.SnsMsgUI", "action.getFromUsername() is null or Nil");
                    } else {
                        com.tencent.mm.pluginsdk.ui.a.b.a(aVar.rJN, bko.wNo);
                        str2 = bko.wNo;
                        aVar.rJN.setOnClickListener(/* anonymous class already generated */);
                    }
                    Xv = SnsMsgUI.this.rFL.Xv(bko.wNo);
                    if (Xv == null) {
                        AX = Xv.AX();
                    } else if (bi.oN(bko.wUk)) {
                        AX = bko.wNo;
                    } else {
                        AX = bko.wUk;
                    }
                    aVar.ppG.setText(com.tencent.mm.pluginsdk.ui.d.i.b(SnsMsgUI.this, AX, aVar.ppG.getTextSize()));
                    eS = ae.bwf().eS(iVar.field_snsID);
                    if (eS == null) {
                    }
                    aVar.ppG.setTextColor(SnsMsgUI.this.getResources().getColor(com.tencent.mm.plugin.sns.i.c.btS));
                    str3 = bko.wNo;
                    textView = aVar.ppG;
                    i2 = bko.vON;
                    switch (iVar.field_type) {
                        case 1:
                        case 2:
                            obj = null;
                            break;
                        case 3:
                        case 5:
                            obj = 1;
                            break;
                        case 4:
                            obj = null;
                            break;
                        case 7:
                        case 8:
                        case 13:
                        case 14:
                            obj = null;
                            break;
                        default:
                            obj = 1;
                            break;
                    }
                    if (obj != null) {
                    }
                    textView.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
                    textView2 = aVar.rJQ;
                    j = iVar.field_snsID;
                    if ((iVar.field_commentflag & 1) <= 0) {
                    }
                    if (((iVar.field_commentflag & 1) <= 0 ? 1 : null) == null) {
                        textView2.setTextColor(SnsMsgUI.this.getResources().getColor(com.tencent.mm.plugin.sns.i.c.black));
                        textView2.setBackgroundDrawable(null);
                        textView2.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
                        textView2.setText("");
                        textView2.setCompoundDrawablePadding(0);
                        switch (bko.kzz) {
                            case 1:
                            case 5:
                                eS = ae.bwf().eS(iVar.field_snsID);
                                if (eS != null) {
                                    break;
                                }
                                b = com.tencent.mm.bu.a.b(this.context, com.tencent.mm.plugin.sns.i.i.qON);
                                if (eS == null) {
                                    break;
                                }
                                b.clearColorFilter();
                                b.setBounds(0, 0, b.getIntrinsicWidth(), b.getIntrinsicHeight());
                                AX = new SpannableString(" ");
                                AX.setSpan(new ImageSpan(b), 0, 1, 18);
                                textView2.setText(AX);
                                textView2.setContentDescription(SnsMsgUI.this.mController.xRr.getString(j.qQR));
                                break;
                            case 2:
                            case 3:
                                str4 = bko.noL;
                                str2 = "";
                                eL = ae.bwi().eL(iVar.field_snsID);
                                if (bko.wUs != 1) {
                                    if (bi.oN(str)) {
                                        str2 = this.context.getString(j.qRM, new Object[]{str});
                                    }
                                } else if (eL != null) {
                                    com.tencent.mm.kernel.g.Dr();
                                    Xt = ((com.tencent.mm.plugin.messenger.foundation.a.h) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).Ff().Xt(eL.field_userName);
                                    str2 = this.context.getString(j.qRL, new Object[]{Xt.AX()});
                                }
                                textView2.setText(com.tencent.mm.pluginsdk.ui.d.i.b(SnsMsgUI.this, str2 + str4 + " ", textView2.getTextSize()));
                                break;
                            case 4:
                                textView2.setText(SnsMsgUI.this.getString(j.qSB));
                                break;
                            case 7:
                                textView2.setCompoundDrawablesWithIntrinsicBounds(com.tencent.mm.bu.a.b(this.context, com.tencent.mm.plugin.sns.i.i.qON), null, null, null);
                                textView2.setContentDescription(SnsMsgUI.this.mController.xRr.getString(j.qQR));
                                break;
                            case 8:
                                str2 = "";
                                str4 = bko.noL;
                                eL = ae.bwi().eL(iVar.field_snsID);
                                if (bko.wUs != 1) {
                                    if (bi.oN(str)) {
                                        str2 = this.context.getString(j.qRM, new Object[]{str});
                                    }
                                } else if (eL != null) {
                                    com.tencent.mm.kernel.g.Dr();
                                    Xt = ((com.tencent.mm.plugin.messenger.foundation.a.h) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).Ff().Xt(eL.field_userName);
                                    str2 = this.context.getString(j.qRL, new Object[]{Xt.AX()});
                                }
                                textView2.setText(com.tencent.mm.pluginsdk.ui.d.i.b(SnsMsgUI.this, str2 + str4 + " ", textView2.getTextSize()));
                                break;
                            case 13:
                                ako = new ako();
                                x.i("MicroMsg.SnsMsgUI", "curAction.HBBuffer " + bko.wUr);
                                ako.aH(n.a(bko.wUr));
                                x.i("MicroMsg.SnsMsgUI", "hbbuffer  " + ako.fMM);
                                SnsMsgUI.this.rFL.Xv(bko.wNo);
                                b = null;
                                if (ako.fMM != 0) {
                                    SnsMsgUI.this.rJB = false;
                                    AX = new SpannableString(" " + SnsMsgUI.this.getString(j.qPD, new Object[]{bi.t(((double) ako.fMM) / 100.0d)}));
                                    b = SnsMsgUI.this.getResources().getDrawable(com.tencent.mm.plugin.sns.i.e.qEW);
                                } else {
                                    SnsMsgUI.this.rJB = true;
                                    AX = new SpannableString(SnsMsgUI.this.getString(j.qPE));
                                }
                                if (b != null) {
                                    b.setBounds(0, 0, b.getIntrinsicWidth(), b.getIntrinsicHeight());
                                    eVar = new com.tencent.mm.ui.widget.e(b, 1);
                                    eVar.zCd = (int) (((((float) b.getIntrinsicHeight()) - textView2.getTextSize()) + ((float) com.tencent.mm.bu.a.fromDPToPix(SnsMsgUI.this, 2))) / 2.0f);
                                    AX.setSpan(eVar, 0, 1, 33);
                                }
                                textView2.setText(AX);
                                break;
                            case 14:
                                ako2 = new ako();
                                x.i("MicroMsg.SnsMsgUI", "curAction.HBBuffer " + bko.wUr);
                                ako2.aH(n.a(bko.wUr));
                                x.i("MicroMsg.SnsMsgUI", "hbbuffer  " + ako2.fMM);
                                Xv = SnsMsgUI.this.rFL.Xv(bko.wNo);
                                textView2.setText(SnsMsgUI.this.getString(j.qPC, new Object[]{Xv.AX(), bi.t(((double) ako2.fMM) / 100.0d)}));
                                break;
                        }
                    }
                    textView2.setText(j.qRI);
                    textView2.setBackgroundColor(SnsMsgUI.this.getResources().getColor(com.tencent.mm.plugin.sns.i.c.qEx));
                    textView2.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
                    aVar.maq.setText(az.k(SnsMsgUI.this, ((long) bko.pgR) * 1000));
                    eS = null;
                    if (bko.kzz != 7) {
                    }
                    eL2 = ae.bwi().eL(iVar.field_snsID);
                    if (eL2 != null) {
                        eS = eL2.byH();
                    }
                    mVar = eS;
                    aVar.rJR.setVisibility(8);
                    aVar.rJO.setVisibility(8);
                    aVar.rJS.setVisibility(8);
                    aVar.rJR.setImageBitmap(null);
                    ae.bwc().cw(aVar.rJR);
                    if (mVar == null) {
                        com.tencent.mm.kernel.g.Dr();
                        com.tencent.mm.kernel.g.Dp().gRu.a(new p(iVar.field_snsID), 0);
                    } else {
                        list = mVar.byF().wYj.wfh;
                        if (mVar.field_type != 2) {
                            obj2 = null;
                            if (list.size() > 0) {
                                i3 = mVar.field_type;
                                mMImageView = aVar.rJR;
                                i4 = -1;
                                switch (i3) {
                                    case 1:
                                        i4 = com.tencent.mm.plugin.sns.i.e.byW;
                                        break;
                                    case 2:
                                        mMImageView.setImageDrawable(null);
                                        break;
                                    case 3:
                                        i4 = com.tencent.mm.plugin.sns.i.i.dvO;
                                        break;
                                    case 4:
                                        i4 = com.tencent.mm.plugin.sns.i.i.dvy;
                                        break;
                                    case 5:
                                        i4 = com.tencent.mm.plugin.sns.i.i.dvL;
                                        break;
                                    case 6:
                                        i4 = com.tencent.mm.plugin.sns.i.i.dvx;
                                        break;
                                    case 7:
                                        i4 = com.tencent.mm.plugin.sns.i.e.byW;
                                        break;
                                    case 8:
                                        mMImageView.setImageDrawable(null);
                                        break;
                                    default:
                                        i4 = com.tencent.mm.plugin.sns.i.i.dvO;
                                        break;
                                }
                                ae.bwc().b((are) list.get(0), aVar.rJR, i4, SnsMsgUI.this.hashCode(), an.xHv);
                                if (mVar.field_type != 15) {
                                }
                                aVar.rJS.setVisibility(0);
                                iVar2 = new i();
                                ae.bwk().b(iVar.xrR, iVar2);
                                aVar.rJR.setTag(iVar2);
                                obj2 = 1;
                            }
                            mMImageView = aVar.rJR;
                            if (obj2 == null) {
                                i3 = 8;
                            } else {
                                i3 = 0;
                            }
                            mMImageView.setVisibility(i3);
                        } else {
                            aVar.rJR.setTag(null);
                            aVar.rJO.setVisibility(0);
                            aVar.rJO.setText(com.tencent.mm.pluginsdk.ui.d.i.b(SnsMsgUI.this, mVar.byF().wYg, aVar.rJO.getTextSize()));
                        }
                    }
                    if (aVar.rJR.getVisibility() != 0) {
                    }
                    if (obj2 == null) {
                    }
                    view.findViewById(com.tencent.mm.plugin.sns.i.f.qKW).setVisibility(obj2 == null ? 0 : 8);
                    if (iVar.field_isSilence != 1) {
                    }
                    view.findViewById(com.tencent.mm.plugin.sns.i.f.qLt).setVisibility(iVar.field_isSilence != 1 ? 0 : 8);
                    return view;
                } catch (Exception e4) {
                    str = str2;
                    if (bi.oN(bko.wNo)) {
                        x.e("MicroMsg.SnsMsgUI", "action.getFromUsername() is null or Nil");
                    } else {
                        com.tencent.mm.pluginsdk.ui.a.b.a(aVar.rJN, bko.wNo);
                        str2 = bko.wNo;
                        aVar.rJN.setOnClickListener(/* anonymous class already generated */);
                    }
                    Xv = SnsMsgUI.this.rFL.Xv(bko.wNo);
                    if (Xv == null) {
                        AX = Xv.AX();
                    } else if (bi.oN(bko.wUk)) {
                        AX = bko.wNo;
                    } else {
                        AX = bko.wUk;
                    }
                    aVar.ppG.setText(com.tencent.mm.pluginsdk.ui.d.i.b(SnsMsgUI.this, AX, aVar.ppG.getTextSize()));
                    eS = ae.bwf().eS(iVar.field_snsID);
                    if (eS == null) {
                    }
                    aVar.ppG.setTextColor(SnsMsgUI.this.getResources().getColor(com.tencent.mm.plugin.sns.i.c.btS));
                    str3 = bko.wNo;
                    textView = aVar.ppG;
                    i2 = bko.vON;
                    switch (iVar.field_type) {
                        case 1:
                        case 2:
                            obj = null;
                            break;
                        case 3:
                        case 5:
                            obj = 1;
                            break;
                        case 4:
                            obj = null;
                            break;
                        case 7:
                        case 8:
                        case 13:
                        case 14:
                            obj = null;
                            break;
                        default:
                            obj = 1;
                            break;
                    }
                    if (obj != null) {
                    }
                    textView.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
                    textView2 = aVar.rJQ;
                    j = iVar.field_snsID;
                    if ((iVar.field_commentflag & 1) <= 0) {
                    }
                    if (((iVar.field_commentflag & 1) <= 0 ? 1 : null) == null) {
                        textView2.setTextColor(SnsMsgUI.this.getResources().getColor(com.tencent.mm.plugin.sns.i.c.black));
                        textView2.setBackgroundDrawable(null);
                        textView2.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
                        textView2.setText("");
                        textView2.setCompoundDrawablePadding(0);
                        switch (bko.kzz) {
                            case 1:
                            case 5:
                                eS = ae.bwf().eS(iVar.field_snsID);
                                if (eS != null) {
                                    break;
                                }
                                b = com.tencent.mm.bu.a.b(this.context, com.tencent.mm.plugin.sns.i.i.qON);
                                if (eS == null) {
                                    break;
                                }
                                b.clearColorFilter();
                                b.setBounds(0, 0, b.getIntrinsicWidth(), b.getIntrinsicHeight());
                                AX = new SpannableString(" ");
                                AX.setSpan(new ImageSpan(b), 0, 1, 18);
                                textView2.setText(AX);
                                textView2.setContentDescription(SnsMsgUI.this.mController.xRr.getString(j.qQR));
                                break;
                            case 2:
                            case 3:
                                str4 = bko.noL;
                                str2 = "";
                                eL = ae.bwi().eL(iVar.field_snsID);
                                if (bko.wUs != 1) {
                                    if (bi.oN(str)) {
                                        str2 = this.context.getString(j.qRM, new Object[]{str});
                                    }
                                } else if (eL != null) {
                                    com.tencent.mm.kernel.g.Dr();
                                    Xt = ((com.tencent.mm.plugin.messenger.foundation.a.h) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).Ff().Xt(eL.field_userName);
                                    str2 = this.context.getString(j.qRL, new Object[]{Xt.AX()});
                                }
                                textView2.setText(com.tencent.mm.pluginsdk.ui.d.i.b(SnsMsgUI.this, str2 + str4 + " ", textView2.getTextSize()));
                                break;
                            case 4:
                                textView2.setText(SnsMsgUI.this.getString(j.qSB));
                                break;
                            case 7:
                                textView2.setCompoundDrawablesWithIntrinsicBounds(com.tencent.mm.bu.a.b(this.context, com.tencent.mm.plugin.sns.i.i.qON), null, null, null);
                                textView2.setContentDescription(SnsMsgUI.this.mController.xRr.getString(j.qQR));
                                break;
                            case 8:
                                str2 = "";
                                str4 = bko.noL;
                                eL = ae.bwi().eL(iVar.field_snsID);
                                if (bko.wUs != 1) {
                                    if (bi.oN(str)) {
                                        str2 = this.context.getString(j.qRM, new Object[]{str});
                                    }
                                } else if (eL != null) {
                                    com.tencent.mm.kernel.g.Dr();
                                    Xt = ((com.tencent.mm.plugin.messenger.foundation.a.h) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).Ff().Xt(eL.field_userName);
                                    str2 = this.context.getString(j.qRL, new Object[]{Xt.AX()});
                                }
                                textView2.setText(com.tencent.mm.pluginsdk.ui.d.i.b(SnsMsgUI.this, str2 + str4 + " ", textView2.getTextSize()));
                                break;
                            case 13:
                                ako = new ako();
                                x.i("MicroMsg.SnsMsgUI", "curAction.HBBuffer " + bko.wUr);
                                ako.aH(n.a(bko.wUr));
                                x.i("MicroMsg.SnsMsgUI", "hbbuffer  " + ako.fMM);
                                SnsMsgUI.this.rFL.Xv(bko.wNo);
                                b = null;
                                if (ako.fMM != 0) {
                                    SnsMsgUI.this.rJB = false;
                                    AX = new SpannableString(" " + SnsMsgUI.this.getString(j.qPD, new Object[]{bi.t(((double) ako.fMM) / 100.0d)}));
                                    b = SnsMsgUI.this.getResources().getDrawable(com.tencent.mm.plugin.sns.i.e.qEW);
                                } else {
                                    SnsMsgUI.this.rJB = true;
                                    AX = new SpannableString(SnsMsgUI.this.getString(j.qPE));
                                }
                                if (b != null) {
                                    b.setBounds(0, 0, b.getIntrinsicWidth(), b.getIntrinsicHeight());
                                    eVar = new com.tencent.mm.ui.widget.e(b, 1);
                                    eVar.zCd = (int) (((((float) b.getIntrinsicHeight()) - textView2.getTextSize()) + ((float) com.tencent.mm.bu.a.fromDPToPix(SnsMsgUI.this, 2))) / 2.0f);
                                    AX.setSpan(eVar, 0, 1, 33);
                                }
                                textView2.setText(AX);
                                break;
                            case 14:
                                ako2 = new ako();
                                x.i("MicroMsg.SnsMsgUI", "curAction.HBBuffer " + bko.wUr);
                                ako2.aH(n.a(bko.wUr));
                                x.i("MicroMsg.SnsMsgUI", "hbbuffer  " + ako2.fMM);
                                Xv = SnsMsgUI.this.rFL.Xv(bko.wNo);
                                textView2.setText(SnsMsgUI.this.getString(j.qPC, new Object[]{Xv.AX(), bi.t(((double) ako2.fMM) / 100.0d)}));
                                break;
                        }
                    }
                    textView2.setText(j.qRI);
                    textView2.setBackgroundColor(SnsMsgUI.this.getResources().getColor(com.tencent.mm.plugin.sns.i.c.qEx));
                    textView2.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
                    aVar.maq.setText(az.k(SnsMsgUI.this, ((long) bko.pgR) * 1000));
                    eS = null;
                    if (bko.kzz != 7) {
                    }
                    eL2 = ae.bwi().eL(iVar.field_snsID);
                    if (eL2 != null) {
                        eS = eL2.byH();
                    }
                    mVar = eS;
                    aVar.rJR.setVisibility(8);
                    aVar.rJO.setVisibility(8);
                    aVar.rJS.setVisibility(8);
                    aVar.rJR.setImageBitmap(null);
                    ae.bwc().cw(aVar.rJR);
                    if (mVar == null) {
                        com.tencent.mm.kernel.g.Dr();
                        com.tencent.mm.kernel.g.Dp().gRu.a(new p(iVar.field_snsID), 0);
                    } else {
                        list = mVar.byF().wYj.wfh;
                        if (mVar.field_type != 2) {
                            obj2 = null;
                            if (list.size() > 0) {
                                i3 = mVar.field_type;
                                mMImageView = aVar.rJR;
                                i4 = -1;
                                switch (i3) {
                                    case 1:
                                        i4 = com.tencent.mm.plugin.sns.i.e.byW;
                                        break;
                                    case 2:
                                        mMImageView.setImageDrawable(null);
                                        break;
                                    case 3:
                                        i4 = com.tencent.mm.plugin.sns.i.i.dvO;
                                        break;
                                    case 4:
                                        i4 = com.tencent.mm.plugin.sns.i.i.dvy;
                                        break;
                                    case 5:
                                        i4 = com.tencent.mm.plugin.sns.i.i.dvL;
                                        break;
                                    case 6:
                                        i4 = com.tencent.mm.plugin.sns.i.i.dvx;
                                        break;
                                    case 7:
                                        i4 = com.tencent.mm.plugin.sns.i.e.byW;
                                        break;
                                    case 8:
                                        mMImageView.setImageDrawable(null);
                                        break;
                                    default:
                                        i4 = com.tencent.mm.plugin.sns.i.i.dvO;
                                        break;
                                }
                                ae.bwc().b((are) list.get(0), aVar.rJR, i4, SnsMsgUI.this.hashCode(), an.xHv);
                                if (mVar.field_type != 15) {
                                }
                                aVar.rJS.setVisibility(0);
                                iVar2 = new i();
                                ae.bwk().b(iVar.xrR, iVar2);
                                aVar.rJR.setTag(iVar2);
                                obj2 = 1;
                            }
                            mMImageView = aVar.rJR;
                            if (obj2 == null) {
                                i3 = 8;
                            } else {
                                i3 = 0;
                            }
                            mMImageView.setVisibility(i3);
                        } else {
                            aVar.rJR.setTag(null);
                            aVar.rJO.setVisibility(0);
                            aVar.rJO.setText(com.tencent.mm.pluginsdk.ui.d.i.b(SnsMsgUI.this, mVar.byF().wYg, aVar.rJO.getTextSize()));
                        }
                    }
                    if (aVar.rJR.getVisibility() != 0) {
                    }
                    if (obj2 == null) {
                    }
                    view.findViewById(com.tencent.mm.plugin.sns.i.f.qKW).setVisibility(obj2 == null ? 0 : 8);
                    if (iVar.field_isSilence != 1) {
                    }
                    view.findViewById(com.tencent.mm.plugin.sns.i.f.qLt).setVisibility(iVar.field_isSilence != 1 ? 0 : 8);
                    return view;
                }
            } catch (Exception e5) {
                str2 = str;
                str = str2;
                if (bi.oN(bko.wNo)) {
                    com.tencent.mm.pluginsdk.ui.a.b.a(aVar.rJN, bko.wNo);
                    str2 = bko.wNo;
                    aVar.rJN.setOnClickListener(/* anonymous class already generated */);
                } else {
                    x.e("MicroMsg.SnsMsgUI", "action.getFromUsername() is null or Nil");
                }
                Xv = SnsMsgUI.this.rFL.Xv(bko.wNo);
                if (Xv == null) {
                    AX = Xv.AX();
                } else if (bi.oN(bko.wUk)) {
                    AX = bko.wUk;
                } else {
                    AX = bko.wNo;
                }
                aVar.ppG.setText(com.tencent.mm.pluginsdk.ui.d.i.b(SnsMsgUI.this, AX, aVar.ppG.getTextSize()));
                eS = ae.bwf().eS(iVar.field_snsID);
                if (eS == null) {
                }
                aVar.ppG.setTextColor(SnsMsgUI.this.getResources().getColor(com.tencent.mm.plugin.sns.i.c.btS));
                str3 = bko.wNo;
                textView = aVar.ppG;
                i2 = bko.vON;
                switch (iVar.field_type) {
                    case 1:
                    case 2:
                        obj = null;
                        break;
                    case 3:
                    case 5:
                        obj = 1;
                        break;
                    case 4:
                        obj = null;
                        break;
                    case 7:
                    case 8:
                    case 13:
                    case 14:
                        obj = null;
                        break;
                    default:
                        obj = 1;
                        break;
                }
                if (obj != null) {
                }
                textView.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
                textView2 = aVar.rJQ;
                j = iVar.field_snsID;
                if ((iVar.field_commentflag & 1) <= 0) {
                }
                if (((iVar.field_commentflag & 1) <= 0 ? 1 : null) == null) {
                    textView2.setTextColor(SnsMsgUI.this.getResources().getColor(com.tencent.mm.plugin.sns.i.c.black));
                    textView2.setBackgroundDrawable(null);
                    textView2.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
                    textView2.setText("");
                    textView2.setCompoundDrawablePadding(0);
                    switch (bko.kzz) {
                        case 1:
                        case 5:
                            eS = ae.bwf().eS(iVar.field_snsID);
                            if (eS != null) {
                                break;
                            }
                            b = com.tencent.mm.bu.a.b(this.context, com.tencent.mm.plugin.sns.i.i.qON);
                            if (eS == null) {
                                break;
                            }
                            b.clearColorFilter();
                            b.setBounds(0, 0, b.getIntrinsicWidth(), b.getIntrinsicHeight());
                            AX = new SpannableString(" ");
                            AX.setSpan(new ImageSpan(b), 0, 1, 18);
                            textView2.setText(AX);
                            textView2.setContentDescription(SnsMsgUI.this.mController.xRr.getString(j.qQR));
                            break;
                        case 2:
                        case 3:
                            str4 = bko.noL;
                            str2 = "";
                            eL = ae.bwi().eL(iVar.field_snsID);
                            if (bko.wUs != 1) {
                                if (eL != null) {
                                    com.tencent.mm.kernel.g.Dr();
                                    Xt = ((com.tencent.mm.plugin.messenger.foundation.a.h) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).Ff().Xt(eL.field_userName);
                                    str2 = this.context.getString(j.qRL, new Object[]{Xt.AX()});
                                }
                            } else if (bi.oN(str)) {
                                str2 = this.context.getString(j.qRM, new Object[]{str});
                            }
                            textView2.setText(com.tencent.mm.pluginsdk.ui.d.i.b(SnsMsgUI.this, str2 + str4 + " ", textView2.getTextSize()));
                            break;
                        case 4:
                            textView2.setText(SnsMsgUI.this.getString(j.qSB));
                            break;
                        case 7:
                            textView2.setCompoundDrawablesWithIntrinsicBounds(com.tencent.mm.bu.a.b(this.context, com.tencent.mm.plugin.sns.i.i.qON), null, null, null);
                            textView2.setContentDescription(SnsMsgUI.this.mController.xRr.getString(j.qQR));
                            break;
                        case 8:
                            str2 = "";
                            str4 = bko.noL;
                            eL = ae.bwi().eL(iVar.field_snsID);
                            if (bko.wUs != 1) {
                                if (eL != null) {
                                    com.tencent.mm.kernel.g.Dr();
                                    Xt = ((com.tencent.mm.plugin.messenger.foundation.a.h) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).Ff().Xt(eL.field_userName);
                                    str2 = this.context.getString(j.qRL, new Object[]{Xt.AX()});
                                }
                            } else if (bi.oN(str)) {
                                str2 = this.context.getString(j.qRM, new Object[]{str});
                            }
                            textView2.setText(com.tencent.mm.pluginsdk.ui.d.i.b(SnsMsgUI.this, str2 + str4 + " ", textView2.getTextSize()));
                            break;
                        case 13:
                            ako = new ako();
                            x.i("MicroMsg.SnsMsgUI", "curAction.HBBuffer " + bko.wUr);
                            ako.aH(n.a(bko.wUr));
                            x.i("MicroMsg.SnsMsgUI", "hbbuffer  " + ako.fMM);
                            SnsMsgUI.this.rFL.Xv(bko.wNo);
                            b = null;
                            if (ako.fMM != 0) {
                                SnsMsgUI.this.rJB = true;
                                AX = new SpannableString(SnsMsgUI.this.getString(j.qPE));
                            } else {
                                SnsMsgUI.this.rJB = false;
                                AX = new SpannableString(" " + SnsMsgUI.this.getString(j.qPD, new Object[]{bi.t(((double) ako.fMM) / 100.0d)}));
                                b = SnsMsgUI.this.getResources().getDrawable(com.tencent.mm.plugin.sns.i.e.qEW);
                            }
                            if (b != null) {
                                b.setBounds(0, 0, b.getIntrinsicWidth(), b.getIntrinsicHeight());
                                eVar = new com.tencent.mm.ui.widget.e(b, 1);
                                eVar.zCd = (int) (((((float) b.getIntrinsicHeight()) - textView2.getTextSize()) + ((float) com.tencent.mm.bu.a.fromDPToPix(SnsMsgUI.this, 2))) / 2.0f);
                                AX.setSpan(eVar, 0, 1, 33);
                            }
                            textView2.setText(AX);
                            break;
                        case 14:
                            ako2 = new ako();
                            x.i("MicroMsg.SnsMsgUI", "curAction.HBBuffer " + bko.wUr);
                            ako2.aH(n.a(bko.wUr));
                            x.i("MicroMsg.SnsMsgUI", "hbbuffer  " + ako2.fMM);
                            Xv = SnsMsgUI.this.rFL.Xv(bko.wNo);
                            textView2.setText(SnsMsgUI.this.getString(j.qPC, new Object[]{Xv.AX(), bi.t(((double) ako2.fMM) / 100.0d)}));
                            break;
                    }
                }
                textView2.setText(j.qRI);
                textView2.setBackgroundColor(SnsMsgUI.this.getResources().getColor(com.tencent.mm.plugin.sns.i.c.qEx));
                textView2.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
                aVar.maq.setText(az.k(SnsMsgUI.this, ((long) bko.pgR) * 1000));
                eS = null;
                if (bko.kzz != 7) {
                }
                eL2 = ae.bwi().eL(iVar.field_snsID);
                if (eL2 != null) {
                    eS = eL2.byH();
                }
                mVar = eS;
                aVar.rJR.setVisibility(8);
                aVar.rJO.setVisibility(8);
                aVar.rJS.setVisibility(8);
                aVar.rJR.setImageBitmap(null);
                ae.bwc().cw(aVar.rJR);
                if (mVar == null) {
                    list = mVar.byF().wYj.wfh;
                    if (mVar.field_type != 2) {
                        aVar.rJR.setTag(null);
                        aVar.rJO.setVisibility(0);
                        aVar.rJO.setText(com.tencent.mm.pluginsdk.ui.d.i.b(SnsMsgUI.this, mVar.byF().wYg, aVar.rJO.getTextSize()));
                    } else {
                        obj2 = null;
                        if (list.size() > 0) {
                            i3 = mVar.field_type;
                            mMImageView = aVar.rJR;
                            i4 = -1;
                            switch (i3) {
                                case 1:
                                    i4 = com.tencent.mm.plugin.sns.i.e.byW;
                                    break;
                                case 2:
                                    mMImageView.setImageDrawable(null);
                                    break;
                                case 3:
                                    i4 = com.tencent.mm.plugin.sns.i.i.dvO;
                                    break;
                                case 4:
                                    i4 = com.tencent.mm.plugin.sns.i.i.dvy;
                                    break;
                                case 5:
                                    i4 = com.tencent.mm.plugin.sns.i.i.dvL;
                                    break;
                                case 6:
                                    i4 = com.tencent.mm.plugin.sns.i.i.dvx;
                                    break;
                                case 7:
                                    i4 = com.tencent.mm.plugin.sns.i.e.byW;
                                    break;
                                case 8:
                                    mMImageView.setImageDrawable(null);
                                    break;
                                default:
                                    i4 = com.tencent.mm.plugin.sns.i.i.dvO;
                                    break;
                            }
                            ae.bwc().b((are) list.get(0), aVar.rJR, i4, SnsMsgUI.this.hashCode(), an.xHv);
                            if (mVar.field_type != 15) {
                            }
                            aVar.rJS.setVisibility(0);
                            iVar2 = new i();
                            ae.bwk().b(iVar.xrR, iVar2);
                            aVar.rJR.setTag(iVar2);
                            obj2 = 1;
                        }
                        mMImageView = aVar.rJR;
                        if (obj2 == null) {
                            i3 = 0;
                        } else {
                            i3 = 8;
                        }
                        mMImageView.setVisibility(i3);
                    }
                } else {
                    com.tencent.mm.kernel.g.Dr();
                    com.tencent.mm.kernel.g.Dp().gRu.a(new p(iVar.field_snsID), 0);
                }
                if (aVar.rJR.getVisibility() != 0) {
                }
                if (obj2 == null) {
                }
                view.findViewById(com.tencent.mm.plugin.sns.i.f.qKW).setVisibility(obj2 == null ? 0 : 8);
                if (iVar.field_isSilence != 1) {
                }
                view.findViewById(com.tencent.mm.plugin.sns.i.f.qLt).setVisibility(iVar.field_isSilence != 1 ? 0 : 8);
                return view;
            }
        }
    }

    static /* synthetic */ void a(SnsMsgUI snsMsgUI, int i) {
        ae.bwk().delete((long) i);
        snsMsgUI.rJy.a(null, null);
    }

    static /* synthetic */ void a(SnsMsgUI snsMsgUI, i iVar) {
        long j = iVar.field_snsID;
        if ((iVar.field_commentflag & 2) > 0) {
            h.h(snsMsgUI, j.qRK, j.dGZ);
            return;
        }
        Intent intent = new Intent();
        if (iVar.field_type == 3 || iVar.field_type == 5) {
            intent.setClass(snsMsgUI, SnsStrangerCommentDetailUI.class);
            intent.putExtra("INTENT_TALKER", iVar.field_talker);
            try {
                intent.putExtra("INTENT_SOURCE", ((bko) new bko().aH(iVar.field_curActionBuf)).vON);
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.SnsMsgUI", e, "", new Object[0]);
            }
        } else {
            intent.setClass(snsMsgUI, SnsCommentDetailUI.class);
        }
        if (iVar.field_type == 7 || iVar.field_type == 8) {
            intent.putExtra("INTENT_SNSID", u.af("ad_table_", j));
            if (ae.bwf().LQ(u.af("ad_table_", j)) == null) {
                x.i("MicroMsg.SnsMsgUI", "id " + j + " has delete");
                return;
            }
        }
        intent.putExtra("INTENT_SNSID", u.af("sns_table_", j));
        if (iVar.field_type == 2) {
            intent.putExtra("INTENT_FROMSUI", true);
            intent.putExtra("INTENT_FROMSUI_COMMENTID", iVar.field_commentSvrID);
        } else if (iVar.field_type == 8) {
            intent.putExtra("INTENT_FROMSUI", true);
            intent.putExtra("INTENT_FROMSUI_COMMENTID", iVar.field_commentSvrID);
        }
        snsMsgUI.startActivityForResult(intent, 1);
    }

    static /* synthetic */ void a(SnsMsgUI snsMsgUI, boolean z) {
        Object ble = new ble();
        ble.wUM = z ? 1 : 0;
        final k qVar = new q(snsMsgUI.rgW, 12, ble);
        com.tencent.mm.kernel.g.Dr();
        if (com.tencent.mm.kernel.g.Dp().gRu.a(qVar, 0)) {
            if (snsMsgUI.rJC != null) {
                snsMsgUI.rJC.dismiss();
            }
            snsMsgUI.getString(j.dGZ);
            snsMsgUI.rJC = h.a((Context) snsMsgUI, snsMsgUI.getString(j.qPL), true, new OnCancelListener() {
                public final void onCancel(DialogInterface dialogInterface) {
                    com.tencent.mm.kernel.g.Dr();
                    com.tencent.mm.kernel.g.Dp().gRu.c(qVar);
                }
            });
            snsMsgUI.rJC.show();
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        com.tencent.mm.kernel.g.Dr();
        com.tencent.mm.kernel.g.Dp().gRu.a((int) com.tencent.mm.plugin.appbrand.jsapi.share.i.CTRL_INDEX, (e) this);
        com.tencent.mm.kernel.g.Dr();
        com.tencent.mm.kernel.g.Dp().gRu.a(683, (e) this);
        com.tencent.mm.kernel.g.Dr();
        com.tencent.mm.kernel.g.Dp().gRu.a(218, (e) this);
        this.hnt = com.tencent.mm.y.q.FY();
        this.rFL = ae.bvT();
        this.rJA = getIntent().getBooleanExtra("sns_msg_force_show_all", false);
        if (this.rJA) {
            this.laq = true;
        }
        ae.bwk().c(this.rJF);
        initView();
    }

    public void onDestroy() {
        x.d("MicroMsg.SnsMsgUI", "msgui onDestroy");
        ae.bwk().avc();
        com.tencent.mm.kernel.g.Dr();
        com.tencent.mm.kernel.g.Dp().gRu.b((int) com.tencent.mm.plugin.appbrand.jsapi.share.i.CTRL_INDEX, (e) this);
        com.tencent.mm.kernel.g.Dr();
        com.tencent.mm.kernel.g.Dp().gRu.b(683, (e) this);
        com.tencent.mm.kernel.g.Dr();
        com.tencent.mm.kernel.g.Dp().gRu.b(218, (e) this);
        ae.bwk().j(this.rJF);
        this.rJy.aUU();
        ae.bwc().K(this);
        if (this.rJC != null) {
            this.rJC.dismiss();
            this.rJC = null;
        }
        super.onDestroy();
    }

    public void onResume() {
        ae.bwa().a((b) this);
        super.onResume();
    }

    public void onPause() {
        ae.bwa().b((b) this);
        super.onPause();
    }

    protected final int getLayoutId() {
        return g.qNG;
    }

    protected final void initView() {
        setMMTitle(j.qRN);
        addTextOptionMenu(0, getString(j.dEz), new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                h.a(SnsMsgUI.this.mController.xRr, SnsMsgUI.this.getString(j.qRH), "", new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        SnsMsgUI.this.nQn.setVisibility(8);
                        SnsMsgUI.this.nQp.setVisibility(0);
                        ae.bwk().hiZ.fD("SnsComment", "delete from SnsComment");
                        SnsMsgUI.this.enableOptionMenu(false);
                    }
                }, null);
                return true;
            }
        });
        this.rxB = new ao(this);
        this.nQp = findViewById(com.tencent.mm.plugin.sns.i.f.qKS);
        this.nQn = (ListView) findViewById(com.tencent.mm.plugin.sns.i.f.qKU);
        this.jRL = v.fw(this).inflate(g.qNE, null);
        this.lap = v.fw(this).inflate(g.dny, null);
        x.d("MicroMsg.SnsMsgUI", "autoLoad " + this.laq);
        if (this.laq) {
            this.nQn.addFooterView(this.lap);
        } else {
            this.nQn.addFooterView(this.jRL);
        }
        this.rJy = new a(this, new i());
        this.rJy.a(new c() {
            public final int ci(View view) {
                return SnsMsgUI.this.nQn.getPositionForView(view);
            }
        });
        this.rJy.a(new f() {
            public final void t(View view, int i) {
                SnsMsgUI.this.nQn.performItemClick(view, i, 0);
            }
        });
        this.rJy.b(new MMSlideDelView.e() {
            public final void bp(Object obj) {
                if (obj == null) {
                    x.e("MicroMsg.SnsMsgUI", "onItemDel object null");
                    return;
                }
                try {
                    SnsMsgUI.a(SnsMsgUI.this, bi.Wo(obj.toString()));
                } catch (Throwable e) {
                    x.e("MicroMsg.SnsMsgUI", "onItemDel object not int");
                    x.printErrStackTrace("MicroMsg.SnsMsgUI", e, "", new Object[0]);
                }
            }
        });
        this.rJy.xQN = new com.tencent.mm.ui.o.a() {
            public final void XF() {
            }

            public final void XE() {
                x.v("MicroMsg.SnsMsgUI", "total count:" + SnsMsgUI.this.rJy.hLP + " unread:" + ae.bwk().Tx() + "  showcount:" + SnsMsgUI.this.rJy.las);
                if (SnsMsgUI.this.rJy.getCount() == 0) {
                    SnsMsgUI.this.nQn.setVisibility(8);
                    SnsMsgUI.this.nQp.setVisibility(0);
                    SnsMsgUI.this.enableOptionMenu(false);
                } else {
                    SnsMsgUI.this.nQn.setVisibility(0);
                    SnsMsgUI.this.nQp.setVisibility(8);
                    SnsMsgUI.this.enableOptionMenu(true);
                }
                if ((SnsMsgUI.this.rJy.awL() && ae.bwk().Tx() == 0) || ae.bwk().Tx() == ae.bwk().byM()) {
                    SnsMsgUI.this.jRL.setVisibility(8);
                }
            }
        };
        this.nQn.setAdapter(this.rJy);
        this.nQn.setOnItemClickListener(new OnItemClickListener() {
            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (i == SnsMsgUI.this.rJy.getCount()) {
                    int i2;
                    if (ae.bwk().Tx() > 0) {
                        ae.bwk().avc();
                        i2 = SnsMsgUI.this.rJy.awL() ? 0 : 1;
                    } else {
                        i2 = SnsMsgUI.this.rJy.awM();
                    }
                    SnsMsgUI.this.rJy.a(null, null);
                    if (!SnsMsgUI.this.laq) {
                        if (SnsMsgUI.this.jRL.getParent() != null) {
                            x.d("MicroMsg.SnsMsgUI", "remove footer");
                            SnsMsgUI.this.nQn.removeFooterView(SnsMsgUI.this.jRL);
                        }
                        if (SnsMsgUI.this.lap.getParent() == null && i2 > 0) {
                            SnsMsgUI.this.nQn.addFooterView(SnsMsgUI.this.lap);
                            x.i("MicroMsg.SnsMsgUI", "add mLoadingFooterView");
                        }
                    }
                    SnsMsgUI.this.laq = true;
                    SnsMsgUI.this.jRL.setVisibility(8);
                    return;
                }
                SnsMsgUI.a(SnsMsgUI.this, (i) SnsMsgUI.this.rJy.getItem(i));
            }
        });
        com.tencent.mm.ui.tools.l lVar = new com.tencent.mm.ui.tools.l(this);
        this.nQn.setOnTouchListener(new OnTouchListener() {
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        SnsMsgUI.this.aWY();
                        SnsMsgUI.this.rJD[0] = (int) motionEvent.getRawX();
                        SnsMsgUI.this.rJD[1] = (int) motionEvent.getRawY();
                        break;
                }
                return false;
            }
        });
        this.nQn.setOnItemLongClickListener(new OnItemLongClickListener() {
            public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (i < SnsMsgUI.this.nQn.getHeaderViewsCount()) {
                    x.w("MicroMsg.SnsMsgUI", "on header view long click, ignore");
                    return true;
                }
                new com.tencent.mm.ui.widget.i(SnsMsgUI.this).a(view, i, j, SnsMsgUI.this, SnsMsgUI.this.kHD, SnsMsgUI.this.rJD[0], SnsMsgUI.this.rJD[1]);
                return true;
            }
        });
        this.nQn.setOnScrollListener(new OnScrollListener() {
            public final void onScrollStateChanged(AbsListView absListView, int i) {
                if (SnsMsgUI.this.laq && absListView.getLastVisiblePosition() == absListView.getCount() - 1) {
                    if (ae.bwk().Tx() > 0) {
                        ae.bwk().avc();
                    } else {
                        SnsMsgUI.this.rJy.awM();
                    }
                    SnsMsgUI.this.rJy.a(null, null);
                }
            }

            public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
            }
        });
        if (this.rJy.getCount() == 0) {
            this.nQn.setVisibility(8);
            this.nQp.setVisibility(0);
            enableOptionMenu(false);
        } else {
            this.nQn.setVisibility(0);
            this.nQp.setVisibility(8);
            enableOptionMenu(true);
        }
        if ((this.rJy.awL() && ae.bwk().Tx() == 0) || ae.bwk().Tx() == ae.bwk().byM()) {
            this.jRL.setVisibility(8);
        }
        if (this.rJy.awL() && this.laq) {
            this.nQn.removeFooterView(this.lap);
        }
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                Intent intent = new Intent();
                intent.putExtra("sns_cmd_list", SnsMsgUI.this.rzl);
                SnsMsgUI.this.setResult(-1, intent);
                SnsMsgUI.this.finish();
                return true;
            }
        });
        if (this.rJy.awL() && this.laq) {
            this.nQn.removeFooterView(this.lap);
        }
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        AdapterContextMenuInfo adapterContextMenuInfo = (AdapterContextMenuInfo) contextMenuInfo;
        i iVar = (i) this.rJy.getItem(adapterContextMenuInfo.position);
        if (iVar != null) {
            this.ruQ = iVar.ruQ;
            this.rgW = iVar.field_snsID;
            try {
                bko bko = (bko) new bko().aH(iVar.field_curActionBuf);
                if (bko != null) {
                    String AX;
                    com.tencent.mm.k.a Xv = this.rFL.Xv(bko.wNo);
                    if (Xv != null) {
                        AX = Xv.AX();
                    } else if (bi.oN(bko.wUk)) {
                        AX = bko.wNo;
                    } else {
                        AX = bko.wUk;
                    }
                    contextMenu.setHeaderTitle(bi.oM(AX));
                    if (iVar.field_isSilence == 0) {
                        contextMenu.add(adapterContextMenuInfo.position, 1, 1, getString(j.qPH));
                    } else {
                        contextMenu.add(adapterContextMenuInfo.position, 2, 1, getString(j.qPG));
                    }
                }
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.SnsMsgUI", e, "", new Object[0]);
            }
            contextMenu.add(adapterContextMenuInfo.position, 0, 0, getString(j.dEH));
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        x.i("MicroMsg.SnsMsgUI", "onAcvityResult requestCode:" + i);
        if (i2 == -1) {
            if (intent != null && intent.getBooleanExtra("result_finish", false)) {
                finish();
            } else if (intent != null) {
                this.rzl.wL(intent.getIntExtra("sns_gallery_op_id", 0));
            }
        }
    }

    public final void Ky(String str) {
        this.rJy.notifyDataSetChanged();
    }

    public final void aE(String str, boolean z) {
    }

    public final void buX() {
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() != 4 || keyEvent.getAction() != 0) {
            return super.dispatchKeyEvent(keyEvent);
        }
        x.d("MicroMsg.SnsMsgUI", "dispatchKeyEvent");
        Intent intent = new Intent();
        intent.putExtra("sns_cmd_list", this.rzl);
        setResult(-1, intent);
        finish();
        return true;
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (i == 0 && i2 == 0 && (kVar instanceof p)) {
            x.d("MicroMsg.SnsMsgUI", "onSceneEnd errtype errcode");
            if (!this.rJz) {
                this.rJz = true;
                this.handler.postDelayed(this.rJG, 500);
            } else {
                return;
            }
        }
        if (kVar.getType() == 218 && ((q) kVar).type == 12) {
            if (i == 0 && i2 == 0) {
                this.rJy.a(null, null);
                Toast.makeText(this, getString(j.qPK), 0).show();
            } else {
                Toast.makeText(this, getString(j.qPJ), 0).show();
            }
            if (this.rJC != null) {
                this.rJC.dismiss();
                this.rJC = null;
            }
        }
    }

    public final void aF(String str, boolean z) {
    }
}
