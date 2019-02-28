package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.model.ai;
import com.tencent.mm.plugin.sns.storage.m;
import com.tencent.mm.plugin.sns.storage.u;
import com.tencent.mm.protocal.c.blf;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ac;
import com.tencent.mm.y.q;

public final class s extends LinearLayout implements v {
    private Context context;
    private boolean fva = false;
    int fvb;
    private String fvn = "";
    private String gAM = "";
    private int kZv = 0;
    b ryO = new b();
    private m ryP = null;
    a ryQ;
    private OnTouchListener ryR = bi.chk();
    private boolean ryS = true;

    public interface a {
        void bzG();
    }

    class b {
        ImageView ikl;
        TextView jbl;
        LinearLayout ryV;
        TextView ryW;
        LinearLayout ryX;
        LinearLayout ryY;
        ImageView ryZ;
        LinearLayout rza;
        LinearLayout rzb;
        TextView rzc;
        TextView rzd;
        TextView rze;
        LinearLayout rzf;
        ImageView rzg;
        ImageView rzh;
        LinearLayout rzi;
        LinearLayout rzj;
        TextView rzk;

        b() {
        }
    }

    public final void setVisibility(int i) {
        boolean z = false;
        if (this.kZv == 2 || this.kZv == 3) {
            super.setVisibility(i);
            if (i != 8) {
                z = true;
            }
            this.ryS = z;
        } else if (this.ryP != null && !this.ryP.byZ()) {
        } else {
            if (i == 8) {
                this.ryO.ryV.setVisibility(8);
                this.ryS = false;
            } else if (i == 0) {
                this.ryO.ryV.setVisibility(0);
                this.ryS = true;
            }
        }
    }

    public s(final Context context, int i, boolean z) {
        super(context);
        this.kZv = i;
        this.fva = z;
        this.context = context;
        if (this.kZv != -1) {
            this.gAM = q.FY();
            View inflate = LayoutInflater.from(context).inflate(g.qNq, this, true);
            this.ryO.ryV = (LinearLayout) inflate.findViewById(f.qLH);
            this.ryO.rzf = (LinearLayout) inflate.findViewById(f.qMh);
            this.ryO.ryY = (LinearLayout) inflate.findViewById(f.qIJ);
            this.ryO.ryY.setOnTouchListener(this.ryR);
            this.ryO.ryZ = (ImageView) inflate.findViewById(f.qIy);
            this.ryO.rza = (LinearLayout) inflate.findViewById(f.qHJ);
            this.ryO.rza.setOnTouchListener(this.ryR);
            this.ryO.rzb = (LinearLayout) inflate.findViewById(f.qHP);
            this.ryO.rzd = (TextView) inflate.findViewById(f.qKi);
            this.ryO.rze = (TextView) inflate.findViewById(f.qKj);
            this.ryO.rzc = (TextView) inflate.findViewById(f.qIo);
            this.ryO.ryW = (TextView) inflate.findViewById(f.qJu);
            this.ryO.ryX = (LinearLayout) inflate.findViewById(f.qJv);
            this.ryO.jbl = (TextView) inflate.findViewById(f.qKt);
            this.ryO.jbl.setTextSize(1, (this.ryO.jbl.getTextSize() * ac.ev(context)) / com.tencent.mm.bu.a.getDensity(this.ryO.jbl.getContext()));
            this.ryO.rzj = (LinearLayout) inflate.findViewById(f.qIB);
            ((LinearLayout) inflate.findViewById(f.qIB)).getBackground().setAlpha(50);
            this.ryO.ikl = (ImageView) inflate.findViewById(f.qHw);
            this.ryO.rzg = (ImageView) inflate.findViewById(f.qIS);
            this.ryO.rzh = (ImageView) inflate.findViewById(f.qIf);
            this.ryO.rzi = (LinearLayout) inflate.findViewById(f.qHS);
            this.ryO.rzk = (TextView) inflate.findViewById(f.qHT);
            if (this.kZv == 2) {
                this.ryO.rzf.setVisibility(8);
                this.ryO.rzi.setVisibility(8);
                this.ryO.ryX.setVisibility(0);
            } else if (this.kZv == 3) {
                this.ryO.rzf.setVisibility(8);
                this.ryO.ryX.setVisibility(8);
                this.ryO.rzi.setVisibility(0);
            } else {
                this.ryO.rzf.setVisibility(0);
                this.ryO.ryX.setVisibility(8);
                this.ryO.rzi.setVisibility(8);
            }
            this.ryO.ryY.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    if (s.this.ryP != null) {
                        if (s.this.ryP.field_likeFlag == 0) {
                            if (s.this.ryP.byZ()) {
                                com.tencent.mm.plugin.sns.model.al.a.a(s.this.ryP, 1, "", "", s.this.fvb);
                            } else {
                                com.tencent.mm.plugin.sns.model.al.a.a(s.this.ryP.field_userName, 5, "", s.this.ryP, s.this.fvb);
                            }
                            s.this.ryP.field_likeFlag = 1;
                            ae.bwf().z(s.this.ryP);
                        } else {
                            s.this.ryP.field_likeFlag = 0;
                            ae.bwf().z(s.this.ryP);
                            com.tencent.mm.plugin.sns.model.al.a.KV(s.this.ryP.byG());
                            s.this.ryP = ae.bwf().eS(s.this.ryP.field_snsId);
                        }
                        String er = s.this.ryP.field_snsId == 0 ? "" : i.er(s.this.ryP.field_snsId);
                        com.tencent.mm.plugin.report.service.g.pWK.h(11989, Integer.valueOf(1), er, Integer.valueOf(0));
                        new ag().postDelayed(new Runnable() {
                            public final void run() {
                                s.this.refresh();
                            }
                        }, 500);
                    }
                }
            });
            this.ryO.rza.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    x.d("MicroMsg.GalleryFooter", "comment cmd");
                    if (s.this.ryP != null) {
                        int i = s.this.ryP.ruM;
                        Intent intent = new Intent();
                        intent.putExtra("sns_comment_localId", i);
                        intent.putExtra("sns_source", s.this.fvb);
                        intent.setClass(context, SnsCommentUI.class);
                        String er = s.this.ryP.field_snsId == 0 ? "" : i.er(s.this.ryP.field_snsId);
                        com.tencent.mm.plugin.report.service.g.pWK.h(11989, Integer.valueOf(2), er, Integer.valueOf(0));
                        context.startActivity(intent);
                    }
                }
            });
            this.ryO.rzb.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    if (s.this.ryP != null) {
                        String er = s.this.ryP.field_snsId == 0 ? "" : i.er(s.this.ryP.field_snsId);
                        com.tencent.mm.plugin.report.service.g.pWK.h(11989, Integer.valueOf(3), er, Integer.valueOf(0));
                        int i = s.this.ryP.ruM;
                        Intent intent = new Intent();
                        intent.setClass(context, SnsCommentDetailUI.class);
                        intent.putExtra("INTENT_TALKER", s.this.ryP.field_userName);
                        intent.putExtra("INTENT_SNS_LOCAL_ID", u.ag("sns_table_", (long) i));
                        intent.putExtra("INTENT_FROMGALLERY", true);
                        ((MMActivity) context).startActivityForResult(intent, 1);
                    }
                }
            });
            this.ryO.ryW.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    if (s.this.ryQ != null) {
                        s.this.ryQ.bzG();
                    }
                }
            });
            this.ryO.rzk.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                }
            });
        }
    }

    public final void refresh() {
        if (this.kZv != -1) {
            this.ryP = ae.bwf().LR(this.fvn);
            if (!bi.oN(this.fvn) && this.ryP != null) {
                this.ryO.rzh.setVisibility(8);
                if (ai.K(this.ryP.field_localPrivate, this.fva)) {
                    this.ryO.rza.setVisibility(8);
                    this.ryO.ryY.setVisibility(8);
                } else if (this.ryP.byZ()) {
                    if (this.ryS) {
                        this.ryO.ryV.setVisibility(0);
                    }
                    this.ryO.rzb.setVisibility(0);
                    this.ryO.rza.setVisibility(0);
                    this.ryO.ryY.setVisibility(0);
                    this.ryO.rzf.setVisibility(0);
                } else {
                    this.ryO.rzj.setVisibility(0);
                    this.ryO.rzf.setVisibility(0);
                    this.ryO.ryV.setVisibility(8);
                    this.ryO.rzb.setVisibility(8);
                    this.ryO.rza.setVisibility(8);
                    this.ryO.ryY.setVisibility(8);
                }
                blf n = ai.n(this.ryP);
                if (n != null) {
                    if (this.ryP.byZ()) {
                        int i = n.wUS;
                        if (i > 0) {
                            this.ryO.rze.setText(String.valueOf(i));
                            this.ryO.rze.setVisibility(0);
                        } else {
                            this.ryO.rze.setVisibility(8);
                        }
                        int i2 = n.wUP;
                        if (i2 > 0) {
                            this.ryO.rzd.setText(String.valueOf(i2));
                            this.ryO.rzd.setVisibility(0);
                        } else {
                            this.ryO.rzd.setVisibility(8);
                        }
                        x.d("MicroMsg.GalleryFooter", "commentCount " + i + " " + i2);
                        if (this.ryP.field_likeFlag == 1) {
                            this.ryO.rzc.setText(getResources().getString(j.qQY));
                            this.ryO.ryZ.setImageResource(com.tencent.mm.plugin.sns.i.i.qOJ);
                        } else {
                            this.ryO.rzc.setText(getResources().getString(j.qQZ));
                            this.ryO.ryZ.setImageResource(com.tencent.mm.plugin.sns.i.i.qOK);
                        }
                    }
                    if (this.gAM.equals(this.ryP.field_userName) || !this.fva) {
                        this.ryO.ikl.setVisibility(8);
                    } else {
                        this.ryO.ikl.setVisibility(0);
                        com.tencent.mm.pluginsdk.ui.a.b.a(this.ryO.ikl, this.ryP.field_userName);
                    }
                }
                if (this.ryP.byF() == null) {
                    this.ryO.jbl.setVisibility(8);
                    return;
                }
                String str = this.ryP.byF().wYg;
                if (str == null || str.equals("")) {
                    this.ryO.jbl.setText("");
                    this.ryO.jbl.setVisibility(8);
                } else {
                    this.ryO.jbl.setText(com.tencent.mm.pluginsdk.ui.d.i.b(getContext(), str + " ", this.ryO.jbl.getTextSize()));
                    this.ryO.jbl.setVisibility(0);
                }
                if (ai.K(this.ryP.field_localPrivate, this.fva)) {
                    this.ryO.rzg.setVisibility(0);
                    this.ryO.jbl.setVisibility(0);
                } else {
                    this.ryO.rzg.setVisibility(8);
                }
                if (this.fva && this.ryP.bzc()) {
                    this.ryO.rzb.setVisibility(0);
                    this.ryO.jbl.setVisibility(0);
                    this.ryO.rzh.setVisibility(0);
                }
            }
        }
    }

    public final void Mt(String str) {
        this.fvn = str;
        refresh();
    }
}
