package com.tencent.mm.ui.friend;

import android.database.Cursor;
import android.graphics.Bitmap;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.a.o;
import com.tencent.mm.modelfriend.ad;
import com.tencent.mm.modelfriend.af;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.y.as;
import com.tencent.mm.y.c;
import com.tencent.mm.y.q;
import java.util.LinkedList;

public final class f extends d {
    private final int JI;
    private final MMActivity fnF;
    private String inS;
    private com.tencent.mm.ui.friend.d.a zmb;
    boolean zmj = false;
    private a zmk = new a() {
        public final void i(int i, String str, int i2) {
            x.d("MicroMsg.QQFriendAdapterCaseB", "[cpan] postion:%d qq:%s status:%d", Integer.valueOf(i), str, Integer.valueOf(i2));
            ad adVar = (ad) f.this.getItem(i);
            if (adVar == null) {
                x.e("MicroMsg.QQFriendAdapterCaseB", "[cpan] qq friend is null. qq:%s", str);
                return;
            }
            x.d("MicroMsg.QQFriendAdapterCaseB", "qq friend:%s", adVar.toString());
            if (adVar.hyD == 1) {
                com.tencent.mm.pluginsdk.ui.applet.a aVar = new com.tencent.mm.pluginsdk.ui.applet.a(f.this.fnF, new com.tencent.mm.pluginsdk.ui.applet.a.a() {
                    public final void a(boolean z, boolean z2, String str, String str2) {
                        x.i("MicroMsg.QQFriendAdapterCaseB", "cpan ok:%b hasSendVerify:%b  username:%s gitemId:%s", Boolean.valueOf(z), Boolean.valueOf(z2), str, str2);
                        long longValue = new o(o.bY(str2)).longValue();
                        ad bf = af.OO().bf(longValue);
                        if (z && bf != null) {
                            bf.username = str;
                        }
                        if (bf != null) {
                            bf.hnf = 2;
                            x.d("MicroMsg.QQFriendAdapterCaseB", "f :%s", bf.toString());
                            af.OO().a(longValue, bf);
                            f.this.XH();
                        } else {
                            x.w("MicroMsg.QQFriendAdapterCaseB", "cpan qq friend is null. qq:%s", str2);
                        }
                        if (z && bf != null) {
                            d.aav(str);
                        }
                    }
                });
                aVar.vtE = adVar.hyC;
                aVar.vtD = false;
                LinkedList linkedList = new LinkedList();
                linkedList.add(Integer.valueOf(12));
                if (bi.oN(adVar.getUsername())) {
                    x.w("MicroMsg.QQFriendAdapterCaseB", "[cpan] qq friend username is null.");
                    return;
                }
                aVar.b(adVar.getUsername(), linkedList, true);
                adVar.hnf = 1;
                af.OO().a(adVar.hyC, adVar);
                f.this.XH();
            }
        }
    };

    interface a {
        void i(int i, String str, int i2);
    }

    class b {
        String hPj;
        ImageView ikl;
        TextView ikq;
        TextView jQN;
        ProgressBar pzF;
        int status;
        int xfR;
        View yva;
        TextView yvg;
        TextView yvh;

        public b(View view) {
            this.yvg = (TextView) view.findViewById(R.h.cjZ);
            this.ikl = (ImageView) view.findViewById(R.h.cjY);
            this.jQN = (TextView) view.findViewById(R.h.cka);
            this.yvh = (TextView) view.findViewById(R.h.ckd);
            this.yva = view.findViewById(R.h.cjX);
            this.ikq = (TextView) view.findViewById(R.h.ckc);
            this.pzF = (ProgressBar) view.findViewById(R.h.ckb);
            this.yva.setOnClickListener(new OnClickListener(f.this) {
                public final void onClick(View view) {
                    if (f.this.zmk != null) {
                        f.this.zmk.i(b.this.xfR, b.this.hPj, b.this.status);
                    }
                }
            });
        }
    }

    public final /* synthetic */ Object a(Object obj, Cursor cursor) {
        ad adVar = (ad) obj;
        if (adVar == null) {
            adVar = new ad();
        }
        adVar.b(cursor);
        return adVar;
    }

    public f(MMActivity mMActivity, int i) {
        super(mMActivity, new ad());
        this.fnF = mMActivity;
        this.JI = i;
        this.zmj = mMActivity.getIntent().getBooleanExtra("qqgroup_sendmessage", false);
        mb(true);
    }

    public final void a(com.tencent.mm.ui.friend.d.a aVar) {
        this.zmb = aVar;
    }

    public final void Ds(String str) {
        this.inS = bi.oL(str.trim());
        aUU();
        XH();
    }

    protected final void XI() {
        XH();
    }

    public final void XH() {
        aUU();
        if (bi.oN(this.inS)) {
            setCursor(af.OO().r(this.JI, this.zmj));
        } else {
            setCursor(af.OO().c(this.JI, this.inS, this.zmj));
        }
        if (!(this.zmb == null || this.inS == null)) {
            this.zmb.Ey(getCursor().getCount());
        }
        notifyDataSetChanged();
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        b bVar;
        ad adVar = (ad) getItem(i);
        if (view == null) {
            view = View.inflate(this.fnF, R.i.diP, null);
            b bVar2 = new b(view);
            view.setTag(bVar2);
            bVar = bVar2;
        } else {
            bVar = (b) view.getTag();
        }
        bVar.xfR = i;
        bVar.hPj = adVar.hyC;
        bVar.status = adVar.hyD;
        bVar.jQN.setText(i.b(this.fnF, adVar.getDisplayName(), bVar.jQN.getTextSize()));
        bVar.yvh.setText(i.b(this.fnF, adVar.vW(), bVar.yvh.getTextSize()));
        if (this.zmj) {
            Bitmap aP;
            if (o.bY(bVar.hPj) != 0) {
                aP = com.tencent.mm.ac.b.aP(adVar.hyC);
            } else {
                aP = null;
            }
            if (aP == null) {
                bVar.ikl.setImageDrawable(com.tencent.mm.bu.a.b(this.fnF, R.k.bBC));
            } else {
                bVar.ikl.setImageBitmap(aP);
            }
        } else {
            com.tencent.mm.pluginsdk.ui.a.b.a(bVar.ikl, adVar.getUsername());
        }
        if (!this.zmj) {
            switch (adVar.hyD) {
                case 1:
                case 2:
                    as.Hm();
                    if (!c.Ff().Xr(adVar.getUsername()) && !q.FY().equals(adVar.getUsername())) {
                        if (adVar.hnf != 2) {
                            bVar.yva.setClickable(true);
                            bVar.yva.setBackgroundResource(R.g.bAc);
                            bVar.ikq.setText(R.l.eks);
                            bVar.ikq.setTextColor(this.fnF.getResources().getColor(R.e.white));
                            break;
                        }
                        bVar.yva.setClickable(false);
                        bVar.yva.setBackgroundDrawable(null);
                        bVar.ikq.setText(R.l.ekx);
                        bVar.ikq.setTextColor(this.fnF.getResources().getColor(R.e.btc));
                        break;
                    }
                    bVar.yva.setClickable(false);
                    bVar.yva.setBackgroundDrawable(null);
                    bVar.ikq.setText(R.l.ekt);
                    bVar.ikq.setTextColor(this.fnF.getResources().getColor(R.e.btc));
                    break;
                    break;
            }
            switch (adVar.hnf) {
                case 0:
                case 2:
                    bVar.ikq.setVisibility(0);
                    bVar.pzF.setVisibility(4);
                    break;
                case 1:
                    bVar.ikq.setVisibility(4);
                    bVar.pzF.setVisibility(0);
                    break;
            }
        }
        bVar.yva.setVisibility(8);
        ad adVar2 = (ad) getItem(i - 1);
        int i2 = adVar2 == null ? -1 : adVar2.hne;
        String str = "MicroMsg.QQFriendAdapterCaseB";
        String str2 = "qq friend pre:%s";
        Object[] objArr = new Object[1];
        objArr[0] = adVar2 != null ? adVar2.toString() : "";
        x.d(str, str2, objArr);
        str = "MicroMsg.QQFriendAdapterCaseB";
        str2 = "qq friend:%s";
        objArr = new Object[1];
        objArr[0] = adVar != null ? adVar.toString() : "";
        x.d(str, str2, objArr);
        if (i == 0) {
            CharSequence b = b(adVar);
            if (bi.oN(b)) {
                x.w("MicroMsg.QQFriendAdapterCaseB", "get display show head return null, user[%s] pos[%d]", adVar.getUsername(), Integer.valueOf(i));
                bVar.yvg.setVisibility(8);
            } else {
                bVar.yvg.setVisibility(0);
                bVar.yvg.setText(b);
                bVar.yvg.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            }
        } else {
            boolean z;
            if (adVar.hne != i2) {
                z = true;
            } else {
                z = false;
            }
            CharSequence b2 = b(adVar);
            if (bi.oN(b2) || !z) {
                x.w("MicroMsg.QQFriendAdapterCaseB", "get display show head return null, user[%s] pos[%d]", adVar.getUsername(), Integer.valueOf(i));
                bVar.yvg.setVisibility(8);
            } else {
                bVar.yvg.setVisibility(0);
                bVar.yvg.setText(b2);
                bVar.yvg.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            }
        }
        return view;
    }

    private static String b(ad adVar) {
        if (adVar.hne == 123) {
            return "#";
        }
        return String.valueOf((char) adVar.hne);
    }

    public final void jk(String str) {
    }
}
