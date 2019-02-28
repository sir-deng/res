package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.a.e;
import com.tencent.mm.ap.o;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiSetBackgroundAudioState;
import com.tencent.mm.plugin.downloader.model.FileDownloadTaskInfo;
import com.tencent.mm.plugin.game.d.c;
import com.tencent.mm.plugin.game.model.SubCoreGameCenter;
import com.tencent.mm.plugin.game.model.ap;
import com.tencent.mm.plugin.game.model.d;
import com.tencent.mm.plugin.game.model.g;
import com.tencent.mm.plugin.game.model.n;
import com.tencent.mm.plugin.game.model.n.b;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.q;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public class GameInstalledView extends LinearLayout implements OnClickListener {
    private static int nxA = 7;
    private static Map<String, Integer> nxx = new HashMap();
    private static int nxz = 6;
    private int count = 0;
    private Context mContext;
    int niV = 0;
    LinkedList<f> njn = new LinkedList();
    private TextView nqp;
    b nuo = new b() {
        public final void h(int i, String str, boolean z) {
            switch (i) {
                case 3:
                    SubCoreGameCenter.aRQ().init(GameInstalledView.this.mContext);
                    GameInstalledView.this.eN(false);
                    return;
                default:
                    return;
            }
        }
    };
    private int nxB = 4;
    private int nxC = 1;
    private int nxD = 999;
    a nxE;
    LinkedList<d> nxF;
    LayoutParams nxG = new LayoutParams(-1, -2);
    private LinearLayout nxu;
    private ImageView nxv;
    private TextView nxw;
    private final DisplayMetrics nxy = new DisplayMetrics();

    public static class a {
        public String iconUrl = "";
        public String jhS = "";
        public String title = "";
    }

    static /* synthetic */ int b(GameInstalledView gameInstalledView) {
        int i = gameInstalledView.count + 1;
        gameInstalledView.count = i;
        return i;
    }

    public GameInstalledView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        this.nxu = (LinearLayout) findViewById(R.h.cmt);
        n.a(this.nuo);
    }

    public final void eN(boolean z) {
        if (bi.cC(this.nxF)) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        Iterator it;
        if (z) {
            this.njn = g.aQD();
            if (!(bi.cC(this.nxF) || bi.cC(this.njn))) {
                it = this.nxF.iterator();
                while (it.hasNext()) {
                    d dVar = (d) it.next();
                    if (this.njn.contains(dVar)) {
                        this.njn.remove(dVar);
                        this.njn.addFirst(dVar);
                    }
                }
            }
        } else {
            f fVar;
            LinkedList linkedList = new LinkedList();
            linkedList.addAll(this.njn);
            LinkedList linkedList2 = new LinkedList();
            linkedList2.addAll(g.aQD());
            Collection linkedList3 = new LinkedList();
            Iterator it2 = linkedList.iterator();
            while (it2.hasNext()) {
                fVar = (f) it2.next();
                if (!(linkedList2.contains(fVar) || linkedList3.contains(fVar))) {
                    linkedList3.add(fVar);
                }
            }
            it2 = linkedList.iterator();
            while (it2.hasNext()) {
                fVar = (f) it2.next();
                if (linkedList2.contains(fVar)) {
                    linkedList2.remove(fVar);
                } else if (!com.tencent.mm.pluginsdk.model.app.g.a(this.mContext, fVar)) {
                    linkedList3.add(fVar);
                }
            }
            if (linkedList2.size() > 0) {
                Iterator it3 = linkedList2.iterator();
                while (it3.hasNext()) {
                    fVar = (f) it3.next();
                    if (!linkedList.contains(fVar)) {
                        linkedList.addFirst(fVar);
                    }
                }
            }
            if (linkedList3.size() > 0) {
                linkedList.removeAll(linkedList3);
            }
            linkedList2 = new LinkedList();
            it = linkedList.iterator();
            while (it.hasNext()) {
                linkedList2.add(com.tencent.mm.pluginsdk.model.app.g.aZ(((f) it.next()).field_appId, true));
            }
            this.njn = linkedList2;
        }
        aSk();
    }

    private void aSk() {
        if (bi.cC(this.njn)) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.nxu.removeAllViews();
        this.count = 0;
        LayoutInflater layoutInflater = (LayoutInflater) getContext().getSystemService("layout_inflater");
        if (this.njn.size() >= this.nxB - 1) {
            nxA = 7;
            nxz = 6;
            int b = BackwardSupportUtil.b.b(this.mContext, (float) ((nxz << 1) + 84));
            ((WindowManager) this.mContext.getSystemService("window")).getDefaultDisplay().getMetrics(this.nxy);
            int i = (int) (((float) (this.nxy.widthPixels * JsApiSetBackgroundAudioState.CTRL_INDEX)) / ((float) this.nxy.densityDpi));
            this.nxB = ((this.nxy.widthPixels - 1) / b) + 1;
            if (this.nxB == 3) {
                nxA = 3;
            }
            b = (nxz << 1) + 84;
            int i2 = (nxz + 6) + nxA;
            i = (i - 16) % b;
            if (i < i2) {
                nxz -= 2;
                BackwardSupportUtil.b.b(this.mContext, (float) ((nxz << 1) + 84));
            } else if (i > b - i2) {
                nxz = ((i - (b >> 1)) / this.nxB) + nxz;
                BackwardSupportUtil.b.b(this.mContext, (float) ((nxz << 1) + 84));
            }
        }
        this.nxG.setMargins(BackwardSupportUtil.b.b(this.mContext, (float) nxz), 0, BackwardSupportUtil.b.b(this.mContext, (float) nxz), 0);
        Iterator it = this.njn.iterator();
        while (it.hasNext()) {
            f fVar = (f) it.next();
            View inflate = layoutInflater.inflate(R.i.dlP, null);
            this.nxv = (ImageView) inflate.findViewById(R.h.cmn);
            this.nqp = (TextView) inflate.findViewById(R.h.cmX);
            this.nxw = (TextView) inflate.findViewById(R.h.cnl);
            Bitmap b2 = com.tencent.mm.pluginsdk.model.app.g.b(fVar.field_appId, 1, com.tencent.mm.bu.a.getDensity(this.mContext));
            if (b2 != null) {
                this.nxv.setImageBitmap(b2);
            } else {
                this.nxv.setImageResource(R.g.byY);
            }
            this.nqp.setText(com.tencent.mm.pluginsdk.model.app.g.a(this.mContext, fVar, null));
            if (com.tencent.mm.pluginsdk.model.app.g.a(this.mContext, fVar)) {
                int CQ = c.CQ(fVar.field_packageName);
                if (nxx.containsKey(fVar.field_appId) && ((Integer) nxx.get(fVar.field_appId)).intValue() > CQ) {
                    FileDownloadTaskInfo yo = com.tencent.mm.plugin.downloader.model.f.aAK().yo(fVar.field_appId);
                    this.nxw.setTextColor(this.mContext.getResources().getColor(R.e.bsA));
                    if (yo.status == 1) {
                        this.nxw.setText(R.l.eme);
                    } else {
                        this.nxw.setText(R.l.emd);
                    }
                } else if (bi.oN(fVar.fRB)) {
                    this.nxw.setText("");
                } else {
                    this.nxw.setText(fVar.fRB);
                    this.nxw.setTextColor(this.mContext.getResources().getColor(R.e.bsD));
                }
            } else {
                this.nxw.setTextColor(this.mContext.getResources().getColor(R.e.bsA));
                this.nxw.setText(R.l.emE);
            }
            inflate.setTag(fVar);
            inflate.setOnClickListener(this);
            this.nxu.addView(inflate, this.nxG);
        }
        if (this.nxE != null && this.nxE.iconUrl != null && this.nxE.title != null) {
            final View inflate2 = layoutInflater.inflate(R.i.dlP, null);
            this.nxv = (ImageView) inflate2.findViewById(R.h.cmn);
            this.nqp = (TextView) inflate2.findViewById(R.h.cmX);
            this.nxw = (TextView) inflate2.findViewById(R.h.cnl);
            com.tencent.mm.ap.a.a PG = o.PG();
            String str = this.nxE.iconUrl;
            ImageView imageView = this.nxv;
            com.tencent.mm.ap.a.a.c.a aVar = new com.tencent.mm.ap.a.a.c.a();
            aVar.hFk = true;
            PG.a(str, imageView, aVar.PQ(), new com.tencent.mm.ap.a.c.g() {
                public final void lF(String str) {
                }

                public final Bitmap a(String str, com.tencent.mm.ap.a.d.b bVar) {
                    return null;
                }

                public final void a(String str, View view, com.tencent.mm.ap.a.d.b bVar) {
                    if (bVar.status == 0) {
                        ah.y(new Runnable() {
                            public final void run() {
                                if (GameInstalledView.this.count == 0) {
                                    GameInstalledView.b(GameInstalledView.this);
                                    GameInstalledView.this.nxu.addView(inflate2, GameInstalledView.this.nxG);
                                }
                            }
                        });
                    }
                }
            });
            this.nqp.setText(this.nxE.title);
            this.nxw.setVisibility(8);
            inflate2.setTag(this.nxE);
            inflate2.setOnClickListener(this);
        }
    }

    public static void B(Map<String, Integer> map) {
        if (map != null && !map.isEmpty()) {
            nxx = map;
        }
    }

    public void onClick(View view) {
        if (view.getTag() != null) {
            if (view.getTag() instanceof f) {
                f fVar = (f) view.getTag();
                FileDownloadTaskInfo yo;
                if (fVar == null || bi.oN(fVar.field_appId)) {
                    x.e("MicroMsg.GameInstalledView", "appinfo is null or appid is null");
                } else if (com.tencent.mm.pluginsdk.model.app.g.a(this.mContext, fVar)) {
                    int CQ = c.CQ(fVar.field_packageName);
                    if (!nxx.containsKey(fVar.field_appId) || ((Integer) nxx.get(fVar.field_appId)).intValue() <= CQ) {
                        g.Y(this.mContext, fVar.field_appId);
                        ap.a(this.mContext, 10, 1002, this.nxC, 3, 0, fVar.field_appId, this.niV, 0, null, null, null);
                        this.njn.remove(fVar);
                        this.njn.addFirst(fVar);
                    } else {
                        yo = com.tencent.mm.plugin.downloader.model.f.aAK().yo(fVar.field_appId);
                        if (yo.status == 1) {
                            com.tencent.mm.plugin.downloader.model.f.aAK().bY(yo.id);
                        } else {
                            if (yo.status == 3) {
                                if (!e.bO(yo.path) || c.CR(yo.path) <= CQ) {
                                    com.tencent.mm.plugin.downloader.model.f.aAK().bY(yo.id);
                                } else {
                                    q.e(this.mContext, Uri.fromFile(new File(yo.path)));
                                }
                            }
                            n.a(fVar.fRx, fVar.fRC, 1002, fVar.field_appId, "");
                            com.tencent.mm.plugin.downloader.model.g.a aVar = new com.tencent.mm.plugin.downloader.model.g.a();
                            aVar.yr(fVar.fRx);
                            aVar.yt(com.tencent.mm.pluginsdk.model.app.g.a(this.mContext, fVar, null));
                            aVar.setAppId(fVar.field_appId);
                            aVar.yu(fVar.fRC);
                            aVar.et(true);
                            aVar.oP(1);
                            com.tencent.mm.plugin.downloader.model.f.aAK().a(aVar.lyp);
                        }
                    }
                    eN(false);
                } else {
                    yo = com.tencent.mm.plugin.downloader.model.f.aAK().yo(fVar.field_appId);
                    if (yo == null || yo.status != 3) {
                        x.i("MicroMsg.GameInstalledView", "app not installed or download sucess : [%s]", fVar.field_appName);
                        eN(false);
                    } else if (bi.oN(yo.path) || !e.bO(yo.path)) {
                        x.e("MicroMsg.GameInstalledView", "file status is success, while the download file not exsit:[%s]", yo.path);
                        com.tencent.mm.plugin.downloader.model.f.aAK().bY(yo.id);
                        eN(false);
                    } else {
                        q.e(this.mContext, Uri.fromFile(new File(yo.path)));
                    }
                }
            } else if (view.getTag() instanceof a) {
                a aVar2 = (a) view.getTag();
                Intent intent = new Intent();
                int i = 6;
                if (bi.oN(aVar2.jhS)) {
                    intent.setClass(this.mContext, GameLibraryUI.class);
                    intent.putExtra("game_report_from_scene", 1002);
                    this.mContext.startActivity(intent);
                } else {
                    i = c.p(this.mContext, aVar2.jhS, "game_center_installed_more");
                }
                ap.a(this.mContext, 10, 1002, this.nxD, i, 0, null, this.niV, 0, null, null, null);
            }
        }
    }
}
