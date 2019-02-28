package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.support.v7.widget.RecyclerView.g;
import android.support.v7.widget.RecyclerView.q;
import android.support.v7.widget.RecyclerView.t;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Scroller;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ad.k;
import com.tencent.mm.ad.u;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.LoadMoreRecyclerView;
import com.tencent.mm.plugin.game.c.aa;
import com.tencent.mm.plugin.game.c.ag;
import com.tencent.mm.plugin.game.c.as;
import com.tencent.mm.plugin.game.c.bk;
import com.tencent.mm.plugin.game.c.bl;
import com.tencent.mm.plugin.game.d.c;
import com.tencent.mm.plugin.game.d.e;
import com.tencent.mm.plugin.game.model.ad;
import com.tencent.mm.plugin.game.model.ak;
import com.tencent.mm.plugin.game.model.ap;
import com.tencent.mm.plugin.game.model.d;
import com.tencent.mm.plugin.game.model.f;
import com.tencent.mm.plugin.game.model.o;
import com.tencent.mm.plugin.game.widget.GameFeedSocialInfoView;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

public class GameIndexListView extends LoadMoreRecyclerView {
    private static boolean nsj = true;
    private static boolean nsn;
    private static int nsp = 0;
    private static int nwP = 0;
    private static int nws = 0;
    private View Lr;
    private Context mContext;
    private float nsk;
    private int nsl;
    private boolean nso;
    private ImageView nsq;
    private ImageView nsr;
    private b nwM;
    private bl nwN;
    private boolean nwO = true;
    private Scroller yJ;

    public class a extends g {
        private final Drawable RZ;
        private int hX;

        public a(Resources resources, int i) {
            this.RZ = new ColorDrawable(resources.getColor(i));
            this.hX = resources.getDimensionPixelSize(R.f.bve);
        }

        public final void a(Canvas canvas, RecyclerView recyclerView, q qVar) {
            int paddingLeft = recyclerView.getPaddingLeft();
            int width = recyclerView.getWidth() - recyclerView.getPaddingRight();
            int childCount = recyclerView.getChildCount();
            for (int i = 0; i < childCount - 1; i++) {
                View childAt = recyclerView.getChildAt(i);
                View childAt2 = ((ViewGroup) childAt).getChildAt(0);
                if ((childAt2 instanceof GameBestSellingItemView) || (childAt2 instanceof GameBestSellingTitle) || (childAt2 instanceof GameFeedModuleTitle)) {
                    super.a(canvas, recyclerView, qVar);
                } else {
                    LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                    int bottom = layoutParams.bottomMargin + childAt.getBottom();
                    this.RZ.setBounds(paddingLeft, bottom, width, this.hX + bottom);
                    this.RZ.draw(canvas);
                }
            }
        }

        public final void a(Rect rect, View view, RecyclerView recyclerView, q qVar) {
            rect.set(0, 0, 0, this.hX);
        }
    }

    public class b extends android.support.v7.widget.RecyclerView.a<a> {
        LinkedList<f> nwR = new LinkedList();

        public class a extends t {
            public View contentView;

            public a(View view) {
                super(view);
                this.contentView = ((ViewGroup) view).getChildAt(0);
            }
        }

        public final /* synthetic */ t a(ViewGroup viewGroup, int i) {
            View inflate;
            x.d("MicroMsg.GameIndexListView", "onCreateViewHolder, viewType = " + i);
            switch (i) {
                case 1:
                    inflate = LayoutInflater.from(GameIndexListView.this.mContext).inflate(R.i.dkp, viewGroup, false);
                    break;
                case 2:
                case 3:
                    inflate = LayoutInflater.from(GameIndexListView.this.mContext).inflate(R.i.dky, viewGroup, false);
                    break;
                case 4:
                    inflate = LayoutInflater.from(GameIndexListView.this.mContext).inflate(R.i.dkr, viewGroup, false);
                    break;
                case 5:
                    inflate = LayoutInflater.from(GameIndexListView.this.mContext).inflate(R.i.dko, viewGroup, false);
                    break;
                case 6:
                    inflate = LayoutInflater.from(GameIndexListView.this.mContext).inflate(R.i.dku, viewGroup, false);
                    break;
                case 8:
                    inflate = LayoutInflater.from(GameIndexListView.this.mContext).inflate(R.i.dkn, viewGroup, false);
                    break;
                case 9:
                    inflate = LayoutInflater.from(GameIndexListView.this.mContext).inflate(R.i.dkt, viewGroup, false);
                    break;
                case 10:
                    inflate = LayoutInflater.from(GameIndexListView.this.mContext).inflate(R.i.dkv, viewGroup, false);
                    break;
                case 1000:
                    inflate = LayoutInflater.from(GameIndexListView.this.mContext).inflate(R.i.djA, viewGroup, false);
                    break;
                case 1001:
                    inflate = LayoutInflater.from(GameIndexListView.this.mContext).inflate(R.i.djy, viewGroup, false);
                    break;
                case 1002:
                    inflate = LayoutInflater.from(GameIndexListView.this.mContext).inflate(R.i.djz, viewGroup, false);
                    break;
                case MMBitmapFactory.ERROR_IMG_BUG_DETECTED_BEGIN /*2000*/:
                    inflate = LayoutInflater.from(GameIndexListView.this.mContext).inflate(R.i.dks, viewGroup, false);
                    break;
                default:
                    inflate = new FrameLayout(GameIndexListView.this.getContext());
                    break;
            }
            return new a(inflate);
        }

        public final /* synthetic */ void a(t tVar, int i) {
            a aVar = (a) tVar;
            x.d("MicroMsg.GameIndexListView", "onBindViewHolder， position = %d", Integer.valueOf(i));
            f fVar = (f) this.nwR.get(i);
            if (fVar != null) {
                ag agVar;
                int size;
                d a;
                switch (fVar.type) {
                    case 1:
                        GameFeedImageTextView gameFeedImageTextView = (GameFeedImageTextView) aVar.contentView;
                        if (fVar == null || fVar.nhb == null || fVar.nhb.nml == null) {
                            gameFeedImageTextView.setVisibility(8);
                            return;
                        }
                        gameFeedImageTextView.nrz = fVar;
                        agVar = fVar.nhb;
                        gameFeedImageTextView.setVisibility(0);
                        gameFeedImageTextView.nvI.a(agVar.nml.fpg, agVar.nml.noL, null);
                        if (bi.cC(agVar.nml.noM)) {
                            gameFeedImageTextView.nvM.setVisibility(8);
                            gameFeedImageTextView.nvQ.setVisibility(8);
                        } else {
                            size = agVar.nml.noM.size();
                            if (size == 1) {
                                gameFeedImageTextView.nvQ.setVisibility(8);
                                gameFeedImageTextView.nvM.setVisibility(0);
                                e.aSC().a(gameFeedImageTextView.nvM, (String) agVar.nml.noM.get(0), gameFeedImageTextView.getResources().getDimensionPixelSize(R.f.bvg), gameFeedImageTextView.getResources().getDimensionPixelSize(R.f.bvf), (c.getScreenWidth(gameFeedImageTextView.getContext()) - gameFeedImageTextView.getPaddingLeft()) - gameFeedImageTextView.getPaddingRight());
                            } else {
                                gameFeedImageTextView.nvM.setVisibility(8);
                                gameFeedImageTextView.nvQ.setVisibility(0);
                                gameFeedImageTextView.nvU.setVisibility(8);
                                com.tencent.mm.plugin.game.d.e.a.a aVar2 = new com.tencent.mm.plugin.game.d.e.a.a();
                                aVar2.nDa = true;
                                com.tencent.mm.plugin.game.d.e.a aSD = aVar2.aSD();
                                e.aSC().a(gameFeedImageTextView.nvR, (String) agVar.nml.noM.get(0), aSD);
                                e.aSC().a(gameFeedImageTextView.nvS, (String) agVar.nml.noM.get(1), aSD);
                                if (size > 2) {
                                    e.aSC().a(gameFeedImageTextView.nvT, (String) agVar.nml.noM.get(2), aSD);
                                    gameFeedImageTextView.nvT.setVisibility(0);
                                    if (size > 3) {
                                        gameFeedImageTextView.nvU.setVisibility(0);
                                        gameFeedImageTextView.nvU.setText(String.format("共%d张", new Object[]{Integer.valueOf(size)}));
                                    }
                                } else {
                                    gameFeedImageTextView.nvT.setVisibility(4);
                                }
                            }
                        }
                        gameFeedImageTextView.nvV.a(agVar);
                        if (!gameFeedImageTextView.nrz.nhd) {
                            ap.a(gameFeedImageTextView.getContext(), 10, (int) WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, gameFeedImageTextView.nrz.position, gameFeedImageTextView.nrz.nhb.nlV, GameIndexListView.aSh(), ap.CD(gameFeedImageTextView.nrz.nhb.nlr));
                            gameFeedImageTextView.nrz.nhd = true;
                            return;
                        }
                        return;
                    case 2:
                        GameFeedVideoView gameFeedVideoView = (GameFeedVideoView) aVar.contentView;
                        if (fVar == null || fVar.nhb == null || fVar.nhb.nmm == null || bi.oN(fVar.nhb.nmm.nkM)) {
                            gameFeedVideoView.setVisibility(8);
                            return;
                        }
                        gameFeedVideoView.nrz = fVar;
                        ag agVar2 = fVar.nhb;
                        gameFeedVideoView.setVisibility(0);
                        gameFeedVideoView.nvI.a(agVar2.nmm.fpg, agVar2.nmm.nkL, null);
                        e.aSC().a(gameFeedVideoView.nwo, agVar2.nmm.nkM, gameFeedVideoView.getResources().getDimensionPixelSize(R.f.bvg), gameFeedVideoView.getResources().getDimensionPixelSize(R.f.bvf), (c.getScreenWidth(gameFeedVideoView.getContext()) - gameFeedVideoView.getPaddingLeft()) - gameFeedVideoView.getPaddingRight());
                        if (bi.oN(agVar2.nmm.npX)) {
                            gameFeedVideoView.nwp.setVisibility(8);
                        } else {
                            gameFeedVideoView.nwp.setVisibility(0);
                            gameFeedVideoView.nwq.setVisibility(8);
                            gameFeedVideoView.nwr.setText(agVar2.nmm.npX);
                        }
                        gameFeedVideoView.nvV.a(agVar2);
                        return;
                    case 3:
                        GameFeedVideoView gameFeedVideoView2 = (GameFeedVideoView) aVar.contentView;
                        if (fVar == null || fVar.nhb == null || fVar.nhb.nmn == null) {
                            gameFeedVideoView2.setVisibility(8);
                            return;
                        }
                        gameFeedVideoView2.nrz = fVar;
                        agVar = fVar.nhb;
                        gameFeedVideoView2.setVisibility(0);
                        gameFeedVideoView2.nvI.a(agVar.nmn.fpg, agVar.nmn.nkL, null);
                        if (bi.oN(agVar.nmn.nkM)) {
                            gameFeedVideoView2.nvL.setVisibility(8);
                        } else {
                            gameFeedVideoView2.nvL.setVisibility(0);
                            e.aSC().a(gameFeedVideoView2.nwo, agVar.nmn.nkM, gameFeedVideoView2.getResources().getDimensionPixelSize(R.f.bvg), gameFeedVideoView2.getResources().getDimensionPixelSize(R.f.bvf), (c.getScreenWidth(gameFeedVideoView2.getContext()) - gameFeedVideoView2.getPaddingLeft()) - gameFeedVideoView2.getPaddingRight());
                        }
                        if (bi.oN(agVar.nmn.npg)) {
                            gameFeedVideoView2.nwp.setVisibility(8);
                        } else {
                            gameFeedVideoView2.nwp.setVisibility(0);
                            gameFeedVideoView2.nwq.setVisibility(0);
                            gameFeedVideoView2.nwr.setText(agVar.nmn.npg);
                        }
                        gameFeedVideoView2.nvV.a(agVar);
                        if (!gameFeedVideoView2.nrz.nhd) {
                            ap.a(gameFeedVideoView2.getContext(), 10, (int) WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, gameFeedVideoView2.nrz.position, gameFeedVideoView2.nrz.nhb.nlV, GameIndexListView.aSh(), ap.CD(gameFeedVideoView2.nrz.nhb.nlr));
                            gameFeedVideoView2.nrz.nhd = true;
                            return;
                        }
                        return;
                    case 4:
                        GameFeedMatchView gameFeedMatchView = (GameFeedMatchView) aVar.contentView;
                        if (fVar == null || fVar.nhb == null || fVar.nhb.nmo == null) {
                            gameFeedMatchView.setVisibility(8);
                            return;
                        }
                        gameFeedMatchView.nrz = fVar;
                        agVar = fVar.nhb;
                        gameFeedMatchView.setVisibility(0);
                        gameFeedMatchView.nvI.a(agVar.nmo.fpg, agVar.nmo.nkL, null);
                        if (bi.oN(agVar.nmo.nkM)) {
                            gameFeedMatchView.setVisibility(8);
                        } else {
                            gameFeedMatchView.nvY.setVisibility(0);
                            e.aSC().a(gameFeedMatchView.nvY, agVar.nmo.nkM, gameFeedMatchView.getResources().getDimensionPixelSize(R.f.bvj), gameFeedMatchView.getResources().getDimensionPixelSize(R.f.bvi), (c.getScreenWidth(gameFeedMatchView.getContext()) - gameFeedMatchView.getPaddingLeft()) - gameFeedMatchView.getPaddingRight());
                        }
                        gameFeedMatchView.nvV.a(agVar);
                        if (!gameFeedMatchView.nrz.nhd) {
                            ap.a(gameFeedMatchView.getContext(), 10, (int) WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, gameFeedMatchView.nrz.position, gameFeedMatchView.nrz.nhb.nlV, GameIndexListView.aSh(), ap.CD(gameFeedMatchView.nrz.nhb.nlr));
                            gameFeedMatchView.nrz.nhd = true;
                            return;
                        }
                        return;
                    case 5:
                        GameFeedGameTemplateView gameFeedGameTemplateView = (GameFeedGameTemplateView) aVar.contentView;
                        if (fVar == null || fVar.nhb == null || fVar.nhb.nmp == null) {
                            gameFeedGameTemplateView.setVisibility(8);
                            return;
                        }
                        gameFeedGameTemplateView.nrz = fVar;
                        ag agVar3 = fVar.nhb;
                        gameFeedGameTemplateView.setVisibility(0);
                        e.aSC().a(gameFeedGameTemplateView.nut, agVar3.nmp.nkO.nkU, com.tencent.mm.bu.a.getDensity(gameFeedGameTemplateView.getContext()));
                        gameFeedGameTemplateView.nuu.setText(agVar3.nmp.nkO.nkW);
                        gameFeedGameTemplateView.nvK.e(agVar3.nmp.nkO.nll, gameFeedGameTemplateView.nrx);
                        if (bi.oN(agVar3.nmp.nnj)) {
                            gameFeedGameTemplateView.lpZ.setVisibility(8);
                        } else {
                            gameFeedGameTemplateView.lpZ.setText(agVar3.nmp.nnj);
                            gameFeedGameTemplateView.lpZ.setVisibility(0);
                        }
                        gameFeedGameTemplateView.nvL.setVisibility(0);
                        if (!bi.oN(agVar3.nmp.nnl)) {
                            gameFeedGameTemplateView.b(gameFeedGameTemplateView.nvM, agVar3.nmp.nkM);
                            gameFeedGameTemplateView.nvN.setVisibility(0);
                        } else if (bi.oN(agVar3.nmp.nkM)) {
                            gameFeedGameTemplateView.nvL.setVisibility(8);
                        } else {
                            gameFeedGameTemplateView.b(gameFeedGameTemplateView.nvM, agVar3.nmp.nkM);
                            gameFeedGameTemplateView.nvN.setVisibility(8);
                        }
                        gameFeedGameTemplateView.nvL.setOnClickListener(gameFeedGameTemplateView);
                        gameFeedGameTemplateView.nvO.a(agVar3);
                        a = ad.a(gameFeedGameTemplateView.nrz.nhb.nmp.nkO);
                        a.scene = 10;
                        a.fGe = WXMediaMessage.DESCRIPTION_LENGTH_LIMIT;
                        a.position = gameFeedGameTemplateView.nrz.position;
                        gameFeedGameTemplateView.nvP.a(new o(a));
                        if (!gameFeedGameTemplateView.nrz.nhd) {
                            ap.a(gameFeedGameTemplateView.getContext(), 10, (int) WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, gameFeedGameTemplateView.nrz.position, gameFeedGameTemplateView.nrz.nhb.nlV, GameIndexListView.aSh(), ap.CD(gameFeedGameTemplateView.nrz.nhb.nlr));
                            gameFeedGameTemplateView.nrz.nhd = true;
                            return;
                        }
                        return;
                    case 6:
                        GameFeedNoGamePlayTemplate gameFeedNoGamePlayTemplate = (GameFeedNoGamePlayTemplate) aVar.contentView;
                        x.d("MicroMsg.GameFeedNoGamePlayTemplate", "setData");
                        if (fVar == null || fVar.nhb == null || fVar.nhb.nmq == null) {
                            gameFeedNoGamePlayTemplate.setVisibility(8);
                            return;
                        }
                        x.d("MicroMsg.GameFeedNoGamePlayTemplate", "setData 1");
                        gameFeedNoGamePlayTemplate.nrz = fVar;
                        agVar = fVar.nhb;
                        gameFeedNoGamePlayTemplate.setVisibility(0);
                        gameFeedNoGamePlayTemplate.nvZ.a(agVar.nmq.fpg, agVar.nmq.nkL, agVar.nmq.nlt);
                        gameFeedNoGamePlayTemplate.nwa.setVisibility(0);
                        if (bi.oN(agVar.nmq.nkM)) {
                            gameFeedNoGamePlayTemplate.nwa.setVisibility(8);
                        } else {
                            e.aSC().a(gameFeedNoGamePlayTemplate.nvM, agVar.nmq.nkM, gameFeedNoGamePlayTemplate.getResources().getDimensionPixelSize(R.f.bvj), gameFeedNoGamePlayTemplate.getResources().getDimensionPixelSize(R.f.bvi), (c.getScreenWidth(gameFeedNoGamePlayTemplate.getContext()) - gameFeedNoGamePlayTemplate.getPaddingLeft()) - gameFeedNoGamePlayTemplate.getPaddingRight());
                            if (bi.oN(agVar.nmq.nnl)) {
                                gameFeedNoGamePlayTemplate.nvN.setVisibility(8);
                            } else {
                                gameFeedNoGamePlayTemplate.nvN.setVisibility(0);
                            }
                        }
                        if (agVar.nmq.nkO != null) {
                            gameFeedNoGamePlayTemplate.nwb.setVisibility(0);
                            e.aSC().a(gameFeedNoGamePlayTemplate.kbb, agVar.nmq.nkO.nkU, com.tencent.mm.bu.a.getDensity(gameFeedNoGamePlayTemplate.getContext()));
                            gameFeedNoGamePlayTemplate.nwc.setText(agVar.nmq.nkO.nkW);
                            a = ad.a(agVar.nmq.nkO);
                            a.scene = 10;
                            a.fGe = WXMediaMessage.DESCRIPTION_LENGTH_LIMIT;
                            a.position = gameFeedNoGamePlayTemplate.nrz.position;
                            gameFeedNoGamePlayTemplate.nrv.a(new o(a));
                        }
                        if (!gameFeedNoGamePlayTemplate.nrz.nhd) {
                            ap.a(gameFeedNoGamePlayTemplate.getContext(), 10, (int) WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, gameFeedNoGamePlayTemplate.nrz.position, gameFeedNoGamePlayTemplate.nrz.nhb.nlV, GameIndexListView.aSh(), ap.CD(gameFeedNoGamePlayTemplate.nrz.nhb.nlr));
                            gameFeedNoGamePlayTemplate.nrz.nhd = true;
                            return;
                        }
                        return;
                    case 8:
                        GameFeedAddTopicView gameFeedAddTopicView = (GameFeedAddTopicView) aVar.contentView;
                        if (fVar == null || fVar.nhb == null || fVar.nhb.nms == null) {
                            gameFeedAddTopicView.setVisibility(8);
                            return;
                        }
                        gameFeedAddTopicView.nrz = fVar;
                        gameFeedAddTopicView.setVisibility(0);
                        gameFeedAddTopicView.nvI.a(fVar.nhb.nms.fpg, fVar.nhb.nms.nkL, null);
                        gameFeedAddTopicView.nvJ.setText(fVar.nhb.nms.nlI);
                        if (!gameFeedAddTopicView.nrz.nhd) {
                            ap.a(gameFeedAddTopicView.getContext(), 10, (int) WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, gameFeedAddTopicView.nrz.position, gameFeedAddTopicView.nrz.nhb.nlV, GameIndexListView.aSh(), ap.CD(gameFeedAddTopicView.nrz.nhb.nlr));
                            gameFeedAddTopicView.nrz.nhd = true;
                            return;
                        }
                        return;
                    case 9:
                        GameFeedMoreGameEntranceView gameFeedMoreGameEntranceView = (GameFeedMoreGameEntranceView) aVar.contentView;
                        if (fVar == null || fVar.nhb == null || fVar.nhb.nmt == null) {
                            gameFeedMoreGameEntranceView.setVisibility(8);
                            return;
                        }
                        gameFeedMoreGameEntranceView.nrz = fVar;
                        gameFeedMoreGameEntranceView.setVisibility(0);
                        gameFeedMoreGameEntranceView.kO.setText(fVar.nhb.nmt.nkL);
                        if (!gameFeedMoreGameEntranceView.nrz.nhd) {
                            ap.a(gameFeedMoreGameEntranceView.getContext(), 10, (int) WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, gameFeedMoreGameEntranceView.nrz.position, gameFeedMoreGameEntranceView.nrz.nhb.nlV, GameIndexListView.aSh(), ap.CD(gameFeedMoreGameEntranceView.nrz.nhb.nlr));
                            gameFeedMoreGameEntranceView.nrz.nhd = true;
                            return;
                        }
                        return;
                    case 10:
                        GameFeedQipaiView gameFeedQipaiView = (GameFeedQipaiView) aVar.contentView;
                        if (fVar == null || fVar.nhb == null || fVar.nhb.nmu == null) {
                            gameFeedQipaiView.setVisibility(8);
                            return;
                        }
                        agVar = fVar.nhb;
                        gameFeedQipaiView.setVisibility(0);
                        gameFeedQipaiView.nwg = agVar;
                        if (bi.oN(agVar.nmu.fpg)) {
                            gameFeedQipaiView.jOY.setVisibility(8);
                        } else {
                            gameFeedQipaiView.jOY.setText(agVar.nmu.fpg);
                            gameFeedQipaiView.jOY.setVisibility(0);
                        }
                        if (bi.oN(agVar.nmu.nmA)) {
                            gameFeedQipaiView.nwd.setVisibility(8);
                            gameFeedQipaiView.nwe.setVisibility(8);
                        } else {
                            gameFeedQipaiView.nwe.setVisibility(0);
                            gameFeedQipaiView.nwd.setVisibility(0);
                            gameFeedQipaiView.nwd.setText(agVar.nmu.nmA);
                        }
                        gameFeedQipaiView.nwf.removeAllViews();
                        if (!bi.cC(agVar.nmu.nlu)) {
                            Iterator it = agVar.nmu.nlu.iterator();
                            while (it.hasNext()) {
                                as asVar = (as) it.next();
                                View inflate = LayoutInflater.from(gameFeedQipaiView.getContext()).inflate(R.i.djJ, gameFeedQipaiView, false);
                                inflate.setOnClickListener(gameFeedQipaiView);
                                inflate.setTag(Integer.valueOf(agVar.nmu.nlu.indexOf(asVar)));
                                gameFeedQipaiView.nwf.addView(inflate, new LinearLayout.LayoutParams(-1, -2, 1.0f));
                                TextView textView = (TextView) inflate.findViewById(R.h.cGF);
                                ImageView imageView = (ImageView) inflate.findViewById(R.h.cGC);
                                TextView textView2 = (TextView) inflate.findViewById(R.h.cGE);
                                TextView textView3 = (TextView) inflate.findViewById(R.h.cGB);
                                textView.setVisibility(8);
                                e.aSC().h(imageView, asVar.nmW);
                                textView2.setText(asVar.fpg);
                                textView3.setText(asVar.nkL);
                            }
                        }
                        if (!fVar.nhd) {
                            ap.a(gameFeedQipaiView.getContext(), 10, 1023, fVar.position, fVar.nhb.nlV, GameIndexListView.aSh(), ap.CD(fVar.nhb.nlr));
                            fVar.nhd = true;
                            return;
                        }
                        return;
                    case 1000:
                        GameBestSellingTitle gameBestSellingTitle = (GameBestSellingTitle) aVar.contentView;
                        CharSequence charSequence = fVar.nhb.nmr.fpg;
                        if (bi.oN(charSequence)) {
                            gameBestSellingTitle.setVisibility(8);
                            return;
                        }
                        gameBestSellingTitle.setVisibility(0);
                        ((TextView) gameBestSellingTitle.findViewById(R.h.ckI)).setText(charSequence);
                        return;
                    case 1001:
                        GameBestSellingItemView gameBestSellingItemView = (GameBestSellingItemView) aVar.contentView;
                        if (fVar == null || fVar.nhb == null || fVar.nhb.nmr == null || bi.cC(fVar.nhb.nmr.nlu)) {
                            gameBestSellingItemView.setVisibility(8);
                            return;
                        }
                        gameBestSellingItemView.nrz = fVar;
                        aa aaVar = (aa) fVar.nhb.nmr.nlu.get(fVar.nhc);
                        size = fVar.nhc + 1;
                        if (aaVar == null || aaVar.nkO == null) {
                            gameBestSellingItemView.setVisibility(8);
                        } else {
                            gameBestSellingItemView.nry = aaVar;
                            d a2 = ad.a(gameBestSellingItemView.nry.nkO);
                            a2.scene = 10;
                            a2.fGe = 1022;
                            a2.position = gameBestSellingItemView.nrz.nhc + 1;
                            gameBestSellingItemView.nrv.a(new o(a2));
                            gameBestSellingItemView.setVisibility(0);
                            gameBestSellingItemView.nrr.setText(String.valueOf(size));
                            if (size == 1) {
                                gameBestSellingItemView.nrr.setTextColor(c.parseColor("#EED157"));
                            } else if (size == 2) {
                                gameBestSellingItemView.nrr.setTextColor(c.parseColor("#BDC5CB"));
                            } else if (size == 3) {
                                gameBestSellingItemView.nrr.setTextColor(c.parseColor("#D4B897"));
                            } else {
                                gameBestSellingItemView.nrr.setTextColor(c.parseColor("#B2B2B2"));
                            }
                            e.aSC().a(gameBestSellingItemView.nrs, aaVar.nkO.nkU, com.tencent.mm.bu.a.getDensity(gameBestSellingItemView.getContext()));
                            gameBestSellingItemView.nrt.setText(aaVar.nkO.nkW);
                            gameBestSellingItemView.nru.e(aaVar.nkO.nll, gameBestSellingItemView.nrx);
                            if (bi.cC(aaVar.nma) && aaVar.nmb == null && aaVar.nkL == null) {
                                gameBestSellingItemView.nrw.setVisibility(8);
                            } else {
                                if (gameBestSellingItemView.nrw instanceof ViewStub) {
                                    gameBestSellingItemView.nrw = ((ViewStub) gameBestSellingItemView.nrw).inflate();
                                }
                                GameFeedSocialInfoView gameFeedSocialInfoView = (GameFeedSocialInfoView) gameBestSellingItemView.nrw.findViewById(R.h.cnn);
                                if (bi.cC(aaVar.nma) && aaVar.nmb == null) {
                                    gameFeedSocialInfoView.nDE.setVisibility(8);
                                } else {
                                    gameFeedSocialInfoView.nDE.setVisibility(0);
                                    gameFeedSocialInfoView.nDF.I(aaVar.nma);
                                    if (aaVar.nmb != null) {
                                        gameFeedSocialInfoView.nDG.setText(aaVar.nmb);
                                        gameFeedSocialInfoView.nDG.setVisibility(0);
                                    } else {
                                        gameFeedSocialInfoView.nDG.setVisibility(8);
                                    }
                                }
                                if (aaVar.nkL != null) {
                                    gameFeedSocialInfoView.nDH.setVisibility(0);
                                    gameFeedSocialInfoView.lpZ.setText(aaVar.nkL);
                                } else {
                                    gameFeedSocialInfoView.nDH.setVisibility(8);
                                }
                            }
                        }
                        if (!fVar.nhd) {
                            ap.a(gameBestSellingItemView.getContext(), 10, 1022, fVar.nhc + 1, aaVar.nkO.nkU, GameIndexListView.aSh(), ap.CD(fVar.nhb.nlr));
                            fVar.nhd = true;
                            return;
                        }
                        return;
                    case 1002:
                        GameBestSellingMore gameBestSellingMore = (GameBestSellingMore) aVar.contentView;
                        gameBestSellingMore.nrz = fVar;
                        if (fVar == null || fVar.nhb == null || fVar.nhb.nmr == null || bi.oN(fVar.nhb.nmr.nmA)) {
                            gameBestSellingMore.nrA.setVisibility(8);
                            gameBestSellingMore.nrB.setVisibility(8);
                            gameBestSellingMore.setPadding(0, 0, 0, 0);
                            return;
                        }
                        gameBestSellingMore.setPadding(gameBestSellingMore.getResources().getDimensionPixelSize(R.f.bvh), 0, gameBestSellingMore.getResources().getDimensionPixelSize(R.f.bvh), gameBestSellingMore.getResources().getDimensionPixelSize(R.f.bvh));
                        gameBestSellingMore.nrA.setVisibility(0);
                        gameBestSellingMore.nrB.setVisibility(0);
                        gameBestSellingMore.nrA.setText(fVar.nhb.nmr.nmA);
                        return;
                    case MMBitmapFactory.ERROR_IMG_BUG_DETECTED_BEGIN /*2000*/:
                        GameFeedModuleTitle gameFeedModuleTitle = (GameFeedModuleTitle) aVar.contentView;
                        if (fVar == null || bi.oN(fVar.nha)) {
                            gameFeedModuleTitle.setVisibility(8);
                            return;
                        }
                        gameFeedModuleTitle.setVisibility(0);
                        gameFeedModuleTitle.jOY.setText(fVar.nha);
                        return;
                    default:
                        return;
                }
            }
        }

        public final int getItemViewType(int i) {
            return ((f) this.nwR.get(i)).type;
        }

        public final int getItemCount() {
            return this.nwR.size();
        }
    }

    public static void rg(int i) {
        nws = i;
    }

    public static int aSh() {
        return nws;
    }

    public GameIndexListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        x.d("MicroMsg.GameIndexListView", "onFinishInflate");
        this.nsl = ViewConfiguration.get(this.mContext).getScaledTouchSlop();
        this.yJ = new Scroller(this.mContext);
        getContext();
        a(new LinearLayoutManager());
        this.nwM = new b();
        a(this.nwM);
        a(new a(getResources(), R.e.bsr));
        mM(R.i.dkq);
        this.klQ = new com.tencent.mm.plugin.appbrand.widget.recyclerview.LoadMoreRecyclerView.a() {
            public final void alD() {
                GameIndexListView.this.aSi();
            }
        };
        dF(true);
        aSi();
    }

    private void aSi() {
        com.tencent.mm.ad.b.a aVar = new com.tencent.mm.ad.b.a();
        com.tencent.mm.bp.a bkVar = new bk();
        bkVar.nob = this.nwN != null ? this.nwN.nod : null;
        aVar.hnT = bkVar;
        aVar.hnU = new bl();
        aVar.uri = "/cgi-bin/mmgame-bin/getgameindex4feedslist";
        aVar.hnS = 2943;
        aVar.hnV = 0;
        aVar.hnW = 0;
        u.a(aVar.Kf(), new com.tencent.mm.ad.u.a() {
            public final int a(int i, int i2, String str, com.tencent.mm.ad.b bVar, k kVar) {
                x.i("MicroMsg.GameIndexListView", "doCgi, errType = %d, errCode = %d, errMsg = %s", Integer.valueOf(i), Integer.valueOf(i2), str);
                if (i == 0 && i2 == 0) {
                    Collection collection;
                    GameIndexListView.this.nwN = (bl) bVar.hnR.hnY;
                    bl b = GameIndexListView.this.nwN;
                    boolean c = GameIndexListView.this.nwO;
                    if (b == null || bi.cC(b.noc)) {
                        collection = null;
                    } else {
                        LinkedList linkedList = new LinkedList();
                        if (c && !bi.oN(b.nlv)) {
                            f fVar = new f();
                            fVar.type = MMBitmapFactory.ERROR_IMG_BUG_DETECTED_BEGIN;
                            fVar.nha = b.nlv;
                            linkedList.add(fVar);
                        }
                        Iterator it = b.noc.iterator();
                        while (it.hasNext()) {
                            ag agVar = (ag) it.next();
                            f fVar2;
                            if (agVar.nlz != 7) {
                                fVar2 = new f();
                                fVar2.type = agVar.nlz;
                                fVar2.position = agVar.nlw;
                                fVar2.nhb = agVar;
                                linkedList.add(fVar2);
                            } else if (!(agVar.nmr == null || bi.cC(agVar.nmr.nlu))) {
                                if (!bi.oN(agVar.nmr.fpg)) {
                                    fVar2 = new f();
                                    fVar2.nhb = agVar;
                                    fVar2.type = 1000;
                                    linkedList.add(fVar2);
                                }
                                Iterator it2 = agVar.nmr.nlu.iterator();
                                while (it2.hasNext()) {
                                    aa aaVar = (aa) it2.next();
                                    f fVar3 = new f();
                                    fVar3.nhb = agVar;
                                    fVar3.type = 1001;
                                    fVar3.nhc = agVar.nmr.nlu.indexOf(aaVar);
                                    linkedList.add(fVar3);
                                }
                                fVar2 = new f();
                                fVar2.nhb = agVar;
                                fVar2.type = 1002;
                                linkedList.add(fVar2);
                            }
                        }
                        Object collection2 = linkedList;
                    }
                    GameIndexListView.this.nwO = false;
                    ak.a(GameIndexListView.this.nwN);
                    if (!GameIndexListView.this.nwN.noe) {
                        GameIndexListView.this.dF(false);
                    }
                    if (!bi.cC(collection2)) {
                        android.support.v7.widget.RecyclerView.a e = GameIndexListView.this.nwM;
                        e.nwR.addAll(collection2);
                        e.UR.notifyChanged();
                    }
                }
                return 0;
            }
        });
    }

    public static void fK(boolean z) {
        nsn = z;
    }

    public static void rk(int i) {
        nsp = i;
    }

    public static void rp(int i) {
        nwP = i;
        nsj = true;
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        x.d("MicroMsg.GameIndexListView", "onLayout, changed = " + z);
        super.onLayout(z, i, i2, i3, i4);
        if (nsj || this.Lr == null || this.nsr == null || this.nsq == null) {
            this.Lr = getChildAt(0);
            if (this.Lr != null) {
                this.Lr.setPadding(0, nwP, 0, 0);
                this.nsr = (ImageView) this.Lr.findViewById(R.h.cOT);
                this.nsq = (ImageView) this.Lr.findViewById(R.h.bMY);
            }
            nsj = false;
        }
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (!nsn || this.Lr == null) {
            return super.dispatchTouchEvent(motionEvent);
        }
        switch (motionEvent.getAction()) {
            case 0:
                this.nso = false;
                this.nsk = motionEvent.getRawY();
                break;
            case 2:
                boolean z;
                if (((LinearLayoutManager) this.TV).fa() == 0 && this.Lr != null && this.Lr.getTop() == 0) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    if (this.nso) {
                        return true;
                    }
                    int rawY = (int) (motionEvent.getRawY() - this.nsk);
                    if (this.Lr.getPaddingTop() <= nsp + this.nsl) {
                        if (rawY > 0 && Math.abs(rawY) >= this.nsl) {
                            this.nso = true;
                            this.yJ.startScroll(0, this.Lr.getPaddingTop(), 0, -this.Lr.getPaddingTop(), 500);
                            this.nsq.setClickable(true);
                            invalidate();
                            motionEvent.setAction(3);
                            super.dispatchTouchEvent(motionEvent);
                            return true;
                        }
                    } else if (this.Lr.getPaddingTop() >= (-this.nsl) && rawY < 0 && Math.abs(rawY) >= this.nsl) {
                        this.nso = true;
                        this.yJ.startScroll(0, 0, 0, nsp, 500);
                        invalidate();
                        motionEvent.setAction(3);
                        super.dispatchTouchEvent(motionEvent);
                        return true;
                    }
                }
                break;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public void computeScroll() {
        if (this.Lr != null && this.yJ.computeScrollOffset()) {
            int currY = this.yJ.getCurrY();
            x.d("MicroMsg.GameIndexListView", "computeScroll, currY = " + currY);
            this.Lr.setPadding(0, currY, 0, 0);
            float f = (((float) (nsp - currY)) / ((float) nsp)) * 255.0f;
            int i = 255 - ((int) f);
            currY = (int) f;
            this.nsr.setAlpha(i);
            this.nsq.setAlpha(currY);
            invalidate();
        }
    }
}
