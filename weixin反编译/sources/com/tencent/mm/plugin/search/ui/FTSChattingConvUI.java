package com.tencent.mm.plugin.search.ui;

import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.q;
import android.support.v7.widget.RecyclerView.t;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.bl.d;
import com.tencent.mm.plugin.fts.d.g;
import com.tencent.mm.plugin.search.a.c;
import com.tencent.mm.storage.x;
import com.tencent.mm.y.as;
import com.tencent.mm.y.s;

public class FTSChattingConvUI extends FTSBaseUI implements OnClickListener {
    private x jQP;
    private String mRD;
    private View qie;
    private d qif;

    class a extends android.support.v7.widget.RecyclerView.a<b> {
        String[] qih;

        public final /* synthetic */ t a(ViewGroup viewGroup, int i) {
            return new b(LayoutInflater.from(FTSChattingConvUI.this.mController.xRr).inflate(R.i.djc, null));
        }

        public final /* synthetic */ void a(t tVar, int i) {
            b bVar = (b) tVar;
            bVar.ioR.setTag(Integer.valueOf(i));
            bVar.ioR.setText(this.qih[i]);
        }

        a() {
            if (s.eX(FTSChattingConvUI.this.mRD)) {
                this.qih = new String[7];
                this.qih[0] = FTSChattingConvUI.this.getResources().getString(R.l.eIM);
                this.qih[1] = FTSChattingConvUI.this.getResources().getString(R.l.eIJ);
                this.qih[2] = FTSChattingConvUI.this.getResources().getString(R.l.eIL);
                this.qih[3] = FTSChattingConvUI.this.getResources().getString(R.l.eIK);
                this.qih[4] = FTSChattingConvUI.this.getResources().getString(R.l.eIP);
                this.qih[5] = FTSChattingConvUI.this.getResources().getString(R.l.eIN);
                this.qih[6] = FTSChattingConvUI.this.getResources().getString(R.l.eIO);
            } else if (FTSChattingConvUI.this.bqT()) {
                this.qih = new String[2];
                this.qih[0] = FTSChattingConvUI.this.getResources().getString(R.l.eIJ);
                this.qih[1] = FTSChattingConvUI.this.getResources().getString(R.l.eIL);
            } else {
                this.qih = new String[6];
                this.qih[0] = FTSChattingConvUI.this.getResources().getString(R.l.eIJ);
                this.qih[1] = FTSChattingConvUI.this.getResources().getString(R.l.eIL);
                this.qih[2] = FTSChattingConvUI.this.getResources().getString(R.l.eIK);
                this.qih[3] = FTSChattingConvUI.this.getResources().getString(R.l.eIP);
                this.qih[4] = FTSChattingConvUI.this.getResources().getString(R.l.eIN);
                this.qih[5] = FTSChattingConvUI.this.getResources().getString(R.l.eIO);
            }
        }

        public final int getItemCount() {
            return this.qih.length;
        }
    }

    class b extends t {
        TextView ioR;

        public b(View view) {
            super(view);
            this.ioR = (TextView) view.findViewById(R.h.title);
            this.ioR.setOnClickListener(FTSChattingConvUI.this);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
        g bqz = c.bqz();
        if (bqz != null) {
            bqz.aOa();
        }
    }

    protected final void initView() {
        super.initView();
        this.qie = findViewById(R.h.cKd);
        this.qie.setVisibility(0);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.h.cnI);
        recyclerView.a(new GridLayoutManager(this.mController.xRr, bqT() ? 2 : 3));
        recyclerView.a(new RecyclerView.g() {
            Paint jbA = new Paint(1);
            final int offset = ((int) FTSChattingConvUI.this.getResources().getDimension(R.f.bus));

            public final void a(Rect rect, View view, RecyclerView recyclerView, q qVar) {
                super.a(rect, view, recyclerView, qVar);
                rect.set(this.offset, this.offset, this.offset, this.offset);
            }

            public final void a(Canvas canvas, RecyclerView recyclerView, q qVar) {
                super.a(canvas, recyclerView, qVar);
                this.jbA.setColor(-2434342);
                this.jbA.setStrokeWidth(1.0f);
                this.jbA.setStyle(Style.FILL);
                int childCount = recyclerView.getChildCount();
                int i = 0;
                while (i < childCount) {
                    if (i == 1 || i == 4) {
                        View childAt = recyclerView.getChildAt(i);
                        if (FTSChattingConvUI.this.bqT()) {
                            canvas.drawLine((float) (childAt.getLeft() - this.offset), (float) childAt.getTop(), (float) (childAt.getLeft() - this.offset), (float) childAt.getBottom(), this.jbA);
                        } else {
                            canvas.drawLine((float) (childAt.getLeft() - this.offset), (float) childAt.getTop(), (float) (childAt.getLeft() - this.offset), (float) childAt.getBottom(), this.jbA);
                            canvas.drawLine((float) (childAt.getRight() + this.offset), (float) childAt.getTop(), (float) (childAt.getRight() + this.offset), (float) childAt.getBottom(), this.jbA);
                        }
                    }
                    i++;
                }
            }
        });
        recyclerView.a(new a());
    }

    protected final void bqH() {
        this.mRD = getIntent().getStringExtra("detail_username");
        as.Hm();
        this.jQP = com.tencent.mm.y.c.Ff().Xv(this.mRD);
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.FTS.FTSChattingConvUI", "initSearchData conversation=%s", this.mRD);
    }

    private boolean bqT() {
        return this.jQP != null && x.Xg(this.jQP.field_username);
    }

    protected final b a(c cVar) {
        if (this.qif == null) {
            this.qif = new d(cVar, this.mRD);
        }
        return this.qif;
    }

    public final void a(com.tencent.mm.plugin.fts.d.a.b bVar) {
        if (s.eX(this.mRD)) {
            com.tencent.mm.ui.contact.x.m(this.fEe, 10, 5, bVar.position + 1);
        } else {
            com.tencent.mm.ui.contact.x.m(this.fEe, 11, 5, bVar.position + 1);
        }
    }

    protected final void bqN() {
        super.bqN();
        this.qie.setVisibility(0);
    }

    protected final void bqL() {
        super.bqL();
        this.qie.setVisibility(8);
    }

    protected final void bqM() {
        super.bqM();
        this.qie.setVisibility(8);
    }

    protected final void bqK() {
        super.bqK();
        this.qie.setVisibility(8);
    }

    private void qq(int i) {
        if (s.eX(this.mRD)) {
            as.Hm();
            if (com.tencent.mm.y.c.Fo().hH(this.mRD).My() == null) {
                return;
            }
            if (i == 0) {
                com.tencent.mm.plugin.report.service.g.pWK.h(14569, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(r0.My().size()), Integer.valueOf(1));
                return;
            }
            com.tencent.mm.plugin.report.service.g.pWK.h(14569, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(r0.My().size()), Integer.valueOf(1));
        } else if (i == 0) {
            com.tencent.mm.plugin.report.service.g.pWK.h(14569, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0));
        } else {
            com.tencent.mm.plugin.report.service.g.pWK.h(14569, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0));
        }
    }

    protected final void Jz(String str) {
        int i = 1;
        super.Jz(str);
        boolean eX = s.eX(this.mRD);
        com.tencent.mm.plugin.report.service.g gVar = com.tencent.mm.plugin.report.service.g.pWK;
        Object[] objArr = new Object[9];
        objArr[0] = Integer.valueOf(0);
        objArr[1] = Integer.valueOf(1);
        objArr[2] = Integer.valueOf(0);
        objArr[3] = Integer.valueOf(0);
        objArr[4] = Integer.valueOf(0);
        objArr[5] = Integer.valueOf(0);
        objArr[6] = Integer.valueOf(0);
        objArr[7] = Integer.valueOf(0);
        if (!eX) {
            i = 0;
        }
        objArr[8] = Integer.valueOf(i);
        gVar.h(14569, objArr);
    }

    protected final int getLayoutId() {
        return R.i.diZ;
    }

    protected void onDestroy() {
        super.onDestroy();
        this.qif.finish();
        g bqz = c.bqz();
        if (bqz != null) {
            bqz.aNY();
        }
    }

    public void onClick(View view) {
        if (view instanceof TextView) {
            int intValue = ((Integer) view.getTag()).intValue();
            if (!s.eX(this.mRD)) {
                intValue++;
            }
            Intent intent;
            if (intValue == 0) {
                com.tencent.mm.sdk.platformtools.x.i("MicroMsg.FTS.FTSChattingConvUI", "onSearchMemberDetail");
                intent = new Intent();
                intent.putExtra("frome_scene", 1);
                intent.putExtra("RoomInfo_Id", this.mRD);
                intent.putExtra("title", getResources().getString(R.l.eJt));
                d.b(this, "chatroom", ".ui.SelectMemberUI", intent);
            } else if (intValue == 1) {
                com.tencent.mm.sdk.platformtools.x.i("MicroMsg.FTS.FTSChattingConvUI", "onSearchDateDetail");
                intent = new Intent();
                intent.putExtra("detail_username", this.mRD);
                d.b(this, "chatroom", ".ui.SelectDateUI", intent);
                qq(0);
            } else if (intValue == 2) {
                com.tencent.mm.sdk.platformtools.x.i("MicroMsg.FTS.FTSChattingConvUI", "onSeeImageVideoHistory");
                intent = new Intent();
                intent.putExtra("kintent_talker", this.mRD);
                intent.putExtra("key_media_type", 1);
                d.a((Context) this, "com.tencent.mm.ui.chatting.gallery.MediaHistoryGalleryUI", intent);
                qq(1);
            } else if (intValue == 3) {
                com.tencent.mm.sdk.platformtools.x.i("MicroMsg.FTS.FTSChattingConvUI", "onSeeFileHistory");
                intent = new Intent();
                intent.putExtra("kintent_talker", this.mRD);
                intent.putExtra("key_media_type", 2);
                d.a((Context) this, "com.tencent.mm.ui.chatting.gallery.MediaHistoryListUI", intent);
            } else if (intValue == 4) {
                com.tencent.mm.sdk.platformtools.x.i("MicroMsg.FTS.FTSChattingConvUI", "onSeeUrlHistory");
                intent = new Intent();
                intent.putExtra("kintent_talker", this.mRD);
                intent.putExtra("key_media_type", 3);
                d.a((Context) this, "com.tencent.mm.ui.chatting.gallery.MediaHistoryListUI", intent);
            } else if (intValue == 5) {
                com.tencent.mm.sdk.platformtools.x.i("MicroMsg.FTS.FTSChattingConvUI", "onSeeUrlHistory");
                intent = new Intent();
                intent.putExtra("kintent_talker", this.mRD);
                intent.putExtra("key_media_type", 4);
                d.a((Context) this, "com.tencent.mm.ui.chatting.gallery.MediaHistoryListUI", intent);
            } else if (intValue == 6) {
                com.tencent.mm.sdk.platformtools.x.i("MicroMsg.FTS.FTSChattingConvUI", "onSeePayHistory");
                intent = new Intent();
                intent.putExtra("kintent_talker", this.mRD);
                intent.putExtra("key_media_type", 5);
                d.a((Context) this, "com.tencent.mm.ui.chatting.gallery.MediaHistoryListUI", intent);
            }
        }
    }
}
