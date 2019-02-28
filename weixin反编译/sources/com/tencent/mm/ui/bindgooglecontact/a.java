package com.tencent.mm.ui.bindgooglecontact;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.modelfriend.af;
import com.tencent.mm.modelfriend.p;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.o;

public final class a extends o<com.tencent.mm.modelfriend.o> {
    private Context mContext;
    private String mFilter;
    private LayoutInflater mLayoutInflater = LayoutInflater.from(this.mContext);
    private String ysY;
    a ytr;

    interface a {
        void FC(int i);
    }

    class b {
        ImageView ikl;
        TextView ikq;
        TextView ipR;
        int position;
        String ppC;
        TextView yts;
        View ytt;
        ProgressBar ytu;

        public b(View view) {
            this.ikl = (ImageView) view.findViewById(R.h.cnx);
            this.ipR = (TextView) view.findViewById(R.h.cnB);
            this.ytt = view.findViewById(R.h.cnC);
            this.ikq = (TextView) view.findViewById(R.h.cnD);
            this.ytu = (ProgressBar) view.findViewById(R.h.cnA);
            this.yts = (TextView) view.findViewById(R.h.cny);
            this.ytt.setOnClickListener(new OnClickListener(a.this) {
                public final void onClick(View view) {
                    x.d("MicroMsg.GoogleContact.GoogleFriendAdapter", "onClick");
                    if (a.this.ytr != null) {
                        a.this.ytr.FC(b.this.position);
                    }
                }
            });
        }
    }

    public final /* synthetic */ Object a(Object obj, Cursor cursor) {
        com.tencent.mm.modelfriend.o oVar = (com.tencent.mm.modelfriend.o) obj;
        if (oVar == null) {
            oVar = new com.tencent.mm.modelfriend.o();
        }
        oVar.b(cursor);
        return oVar;
    }

    public a(Context context, String str) {
        super(context, new com.tencent.mm.modelfriend.o());
        this.ysY = str;
        this.mContext = context;
    }

    protected final void XI() {
        XH();
    }

    public final void XH() {
        p OR = af.OR();
        String str = this.mFilter;
        String str2 = this.ysY;
        StringBuilder stringBuilder = new StringBuilder();
        if (TextUtils.isEmpty(str)) {
            stringBuilder.append(" WHERE ( GoogleFriend.googlegmail!='" + str2 + "' )");
        } else {
            stringBuilder.append(" WHERE ( ");
            stringBuilder.append("GoogleFriend.googlegmail!='" + str2 + "' AND ");
            stringBuilder.append("GoogleFriend.googlename LIKE '%" + str + "%' OR ");
            stringBuilder.append("GoogleFriend.googlenamepy LIKE '%" + str + "%' OR ");
            stringBuilder.append("GoogleFriend.googlegmail LIKE '%" + str + "%' OR ");
            stringBuilder.append("GoogleFriend.nickname LIKE '%" + str + "%' ) ");
        }
        stringBuilder.append(" GROUP BY googleid,contecttype");
        stringBuilder.append(" ORDER BY status , googlenamepy ASC , usernamepy ASC");
        setCursor(OR.gLA.rawQuery("SELECT GoogleFriend.googleid,GoogleFriend.googlename,GoogleFriend.googlephotourl,GoogleFriend.googlegmail,GoogleFriend.username,GoogleFriend.nickname,GoogleFriend.nicknameqp,GoogleFriend.usernamepy,GoogleFriend.small_url,GoogleFriend.big_url,GoogleFriend.ret,GoogleFriend.status,GoogleFriend.googleitemid,GoogleFriend.googlecgistatus,GoogleFriend.contecttype,GoogleFriend.googlenamepy FROM GoogleFriend  " + stringBuilder.toString(), null));
        super.notifyDataSetChanged();
    }

    public final void Ds(String str) {
        this.mFilter = bi.oL(str);
        aUU();
        XH();
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        b bVar;
        if (view == null || view.getTag() == null) {
            view = this.mLayoutInflater.inflate(R.i.dlz, null);
            b bVar2 = new b(view);
            view.setTag(bVar2);
            bVar = bVar2;
        } else {
            bVar = (b) view.getTag();
        }
        com.tencent.mm.modelfriend.o oVar = (com.tencent.mm.modelfriend.o) getItem(i);
        if (oVar != null) {
            bVar.position = i;
            bVar.ppC = oVar.field_googlegmail;
            Bitmap a;
            switch (oVar.field_status) {
                case 0:
                case 2:
                    if (oVar.field_small_url != null) {
                        a = com.tencent.mm.ac.b.a(oVar.field_username, false, -1);
                    } else {
                        a = null;
                    }
                    if (a != null) {
                        bVar.ikl.setImageBitmap(a);
                        break;
                    }
                    bVar.ikl.setImageDrawable(com.tencent.mm.bu.a.b(this.mContext, R.k.bBC));
                    break;
                case 1:
                    a = com.tencent.mm.ac.b.iR(oVar.field_googleid);
                    if (a != null) {
                        bVar.ikl.setImageBitmap(a);
                        break;
                    }
                    bVar.ikl.setImageDrawable(com.tencent.mm.bu.a.b(this.mContext, R.k.bBC));
                    break;
            }
            if (TextUtils.isEmpty(oVar.field_googlename)) {
                bVar.ipR.setText(bi.Wy(oVar.field_googlegmail));
            } else {
                bVar.ipR.setText(oVar.field_googlename);
            }
            switch (oVar.field_status) {
                case 0:
                    bVar.ytt.setClickable(true);
                    bVar.ytt.setBackgroundResource(R.g.bAc);
                    bVar.ikq.setText(R.l.env);
                    bVar.ikq.setTextColor(this.mContext.getResources().getColor(R.e.white));
                    break;
                case 1:
                    bVar.ytt.setClickable(true);
                    bVar.ytt.setBackgroundResource(R.g.bAd);
                    bVar.ikq.setText(R.l.enD);
                    bVar.ikq.setTextColor(this.mContext.getResources().getColor(R.e.btc));
                    break;
                case 2:
                    bVar.ytt.setClickable(false);
                    bVar.ytt.setBackgroundDrawable(null);
                    bVar.ikq.setText(R.l.enx);
                    bVar.ikq.setTextColor(this.mContext.getResources().getColor(R.e.btc));
                    break;
            }
            switch (oVar.field_googlecgistatus) {
                case 0:
                    bVar.ikq.setVisibility(4);
                    bVar.ytu.setVisibility(0);
                    break;
                case 1:
                    bVar.ytt.setClickable(false);
                    bVar.ytt.setBackgroundDrawable(null);
                    bVar.ikq.setVisibility(0);
                    bVar.ytu.setVisibility(8);
                    bVar.ikq.setTextColor(this.mContext.getResources().getColor(R.e.btc));
                    switch (oVar.field_status) {
                        case 0:
                            bVar.ikq.setText(R.l.enw);
                            break;
                        case 1:
                            bVar.ikq.setText(R.l.enE);
                            break;
                    }
                    break;
                case 2:
                    bVar.ikq.setVisibility(0);
                    bVar.ytu.setVisibility(8);
                    switch (oVar.field_status) {
                        case 0:
                            bVar.ikq.setText(R.l.env);
                            bVar.ikq.setTextColor(this.mContext.getResources().getColor(R.e.white));
                            break;
                        case 1:
                            bVar.ikq.setText(R.l.enD);
                            bVar.ikq.setTextColor(this.mContext.getResources().getColor(R.e.btc));
                            break;
                    }
                    break;
            }
            bVar.yts.setText(oVar.field_googlegmail);
        }
        return view;
    }
}
