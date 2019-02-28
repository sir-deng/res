package com.tencent.mm.ui.chatting.gallery;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.af.f;
import com.tencent.mm.ap.a.c.i;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.modelvideo.r;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.model.app.an;
import com.tencent.mm.pluginsdk.model.app.b;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.o;
import com.tencent.mm.y.as;
import java.util.HashMap;
import java.util.Map;

public final class c extends o<au> implements OnClickListener {
    private static Map<String, Integer> tXA;
    private static Map<String, Integer> yMt;
    private LayoutInflater DF;
    public boolean hMK = false;
    String jXh;
    protected com.tencent.mm.ap.a.a.c liE = null;
    Context mContext;
    private boolean vGb;
    boolean vus;
    long yGO;
    private final ImageGalleryGridUI yMr;
    boolean yMs = false;

    protected static class a {
        public CheckBox mXO;
        public View mXP;
        public ImageView qwg;
        public View yGW;
        public TextView yGX;
        public ImageView yGY;
        public View yGZ;
        public ImageView yMw;
        public TextView yMx;
        public View yMy;

        protected a() {
        }
    }

    public final /* synthetic */ Object a(Object obj, Cursor cursor) {
        au auVar = new au();
        auVar.b(cursor);
        return auVar;
    }

    public c(Context context, au auVar, String str) {
        super(context, auVar);
        this.yMr = (ImageGalleryGridUI) context;
        this.jXh = str;
        this.vus = f.eG(this.jXh);
        if (this.vus) {
            this.yGO = auVar.field_bizChatId;
        }
        as.Hm();
        this.vGb = com.tencent.mm.y.c.isSDCardAvailable();
        this.DF = LayoutInflater.from(context);
        com.tencent.mm.ap.a.a.c.a aVar = new com.tencent.mm.ap.a.a.c.a();
        aVar.hFq = 1;
        aVar.hFL = true;
        aVar.hFs = com.tencent.mm.bu.a.eB(context) / 3;
        aVar.hFr = com.tencent.mm.bu.a.eB(context) / 3;
        aVar.hFE = R.e.bty;
        this.liE = aVar.PQ();
    }

    public final boolean areAllItemsEnabled() {
        return false;
    }

    public final void XH() {
        if (this.vus) {
            as.Hm();
            setCursor(com.tencent.mm.y.c.Fi().ap(this.jXh, this.yGO));
            return;
        }
        as.Hm();
        setCursor(com.tencent.mm.y.c.Fh().Fh(this.jXh));
    }

    protected final void XI() {
        if (this.vus) {
            as.Hm();
            setCursor(com.tencent.mm.y.c.Fi().ap(this.jXh, this.yGO));
            return;
        }
        as.Hm();
        setCursor(com.tencent.mm.y.c.Fh().Fh(this.jXh));
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            view = this.DF.inflate(R.i.dlJ, viewGroup, false);
            aVar = new a();
            aVar.qwg = (ImageView) view.findViewById(R.h.cnU);
            aVar.yGW = view.findViewById(R.h.cVH);
            aVar.yMx = (TextView) view.findViewById(R.h.chP);
            aVar.yMx.setVisibility(8);
            aVar.yMw = (ImageView) view.findViewById(R.h.chI);
            aVar.yGX = (TextView) view.findViewById(R.h.cVE);
            aVar.yGW.setVisibility(8);
            aVar.yGZ = view.findViewById(R.h.cOA);
            aVar.yGZ.setVisibility(8);
            aVar.yMy = view.findViewById(R.h.chT);
            aVar.yMy.setVisibility(8);
            aVar.yGY = (ImageView) view.findViewById(R.h.cnX);
            aVar.mXO = (CheckBox) view.findViewById(R.h.cvA);
            aVar.mXP = view.findViewById(R.h.cvB);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        aVar.yGZ.setVisibility(8);
        aVar.yGW.setVisibility(8);
        aVar.yMy.setVisibility(8);
        aVar.yMx.setVisibility(8);
        au auVar = (au) getItem(i);
        if (auVar != null) {
            if (!this.vGb) {
                aVar.qwg.setImageResource(R.g.bEj);
            } else if (this.yMr instanceof ImageGalleryGridUI) {
                String str = auVar.field_content;
                com.tencent.mm.x.g.a aVar2 = null;
                if (str != null) {
                    aVar2 = com.tencent.mm.x.g.a.I(str, auVar.field_reserved);
                }
                if (this.yMr.yMz == i) {
                    aVar.yGY.setVisibility(0);
                    if (!b.aZ(auVar) || aVar2 == null || aVar2.type == 3) {
                        if (aVar2 != null && aVar2.type == 3) {
                            aVar.yMw.setImageDrawable(this.yMr.getResources().getDrawable(f(aVar2)));
                        }
                        com.tencent.mm.ap.o.PG().a(bh(auVar), aVar.qwg, this.liE, new i() {
                            public final void a(String str, Bitmap bitmap, Object... objArr) {
                                ah.y(new Runnable() {
                                    public final void run() {
                                    }
                                });
                            }
                        });
                    } else {
                        aVar.yMw.setImageDrawable(this.yMr.getResources().getDrawable(f(aVar2)));
                        aVar.qwg.setImageResource(g(aVar2));
                    }
                } else {
                    aVar.yGY.setVisibility(0);
                    aVar.yGY.setBackgroundResource(R.e.bsQ);
                    if (!b.aZ(auVar) || aVar2 == null || aVar2.type == 3) {
                        if (aVar2 != null && aVar2.type == 3) {
                            aVar.yMw.setImageDrawable(this.yMr.getResources().getDrawable(f(aVar2)));
                        }
                        com.tencent.mm.ap.o.PG().a(bh(auVar), aVar.qwg, this.liE);
                    } else {
                        aVar.yMw.setImageDrawable(this.yMr.getResources().getDrawable(f(aVar2)));
                        aVar.qwg.setImageResource(g(aVar2));
                    }
                }
                aVar.qwg.setPadding(0, 0, 0, 0);
                int measuredWidth = aVar.qwg.getMeasuredWidth();
                int measuredHeight = aVar.qwg.getMeasuredHeight();
                if (measuredWidth > 0 && measuredHeight > 0) {
                    LayoutParams layoutParams = aVar.yGY.getLayoutParams();
                    layoutParams.width = measuredWidth;
                    layoutParams.height = measuredHeight;
                    aVar.yGY.setLayoutParams(layoutParams);
                }
                if (b.aX(auVar)) {
                    if (aVar != null) {
                        aVar.yGW.setVisibility(0);
                        r bq = i.bq(auVar);
                        if (bq != null) {
                            aVar.yGX.setText(t.iZ(bq.hXv));
                        }
                    }
                } else if (b.aY(auVar)) {
                    aVar.yGZ.setVisibility(0);
                } else if (b.aZ(auVar) && aVar != null) {
                    aVar.yMy.setVisibility(0);
                    aVar.yMx.setVisibility(0);
                    if (aVar2 != null) {
                        x.i("MicroMsg.ImageGalleryGridAdapter", "initFileName--->content:%s", t.oM(aVar2.title));
                        if (aVar2.type != 24) {
                            aVar.yMx.setText(com.tencent.mm.pluginsdk.ui.d.i.b(this.mContext, t.oM(aVar2.title), aVar.yMx.getTextSize()));
                        } else {
                            aVar.yMx.setText(com.tencent.mm.pluginsdk.ui.d.i.b(aVar.yMx.getContext(), aVar.yMx.getContext().getString(R.l.ehj), aVar.yMx.getTextSize()));
                        }
                    }
                }
            } else {
                throw new IllegalArgumentException("the context should be ImageGalleryGridUI");
            }
            aVar.mXO.setChecked(a.yNw.bo(auVar));
            aVar.mXO.setTag(auVar);
            aVar.mXP.setTag(aVar);
            aVar.mXP.setOnClickListener(this);
            if (a.yNw.yNu) {
                aVar.mXO.setVisibility(0);
                aVar.mXP.setVisibility(0);
                aVar.yGY.setVisibility(0);
            } else {
                aVar.mXO.setVisibility(8);
                aVar.mXP.setVisibility(8);
                aVar.yGY.setVisibility(8);
            }
        }
        return view;
    }

    private static int f(com.tencent.mm.x.g.a aVar) {
        if (aVar == null) {
            x.i("MicroMsg.ImageGalleryGridAdapter", "getIconId:" + R.k.dvI);
            return R.k.dvJ;
        } else if (aVar.type == 5 || aVar.type == 7 || aVar.type == 15) {
            return R.k.dvK;
        } else {
            if (aVar.type == 3) {
                return R.k.dvz;
            }
            if (aVar.type != 6 || !tXA.containsKey(t.oM(aVar.hcN))) {
                return R.k.dvJ;
            }
            x.i("MicroMsg.ImageGalleryGridAdapter", "getIconId:" + tXA.get(t.oM(aVar.hcN)));
            return ((Integer) tXA.get(t.oM(aVar.hcN))).intValue();
        }
    }

    private static int g(com.tencent.mm.x.g.a aVar) {
        if (aVar == null) {
            x.i("MicroMsg.ImageGalleryGridAdapter", "getIconId:" + R.e.brr);
            return R.e.brr;
        } else if (aVar.type == 5 || aVar.type == 7 || aVar.type == 15) {
            return R.e.brs;
        } else {
            if (aVar.type != 6 || !yMt.containsKey(t.oM(aVar.hcN))) {
                return R.e.brr;
            }
            x.i("MicroMsg.ImageGalleryGridAdapter", "getIconId:" + yMt.get(t.oM(aVar.hcN)));
            return ((Integer) yMt.get(t.oM(aVar.hcN))).intValue();
        }
    }

    private static String bh(au auVar) {
        String ny;
        if (auVar.cjW() || auVar.cjX()) {
            com.tencent.mm.modelvideo.o.Ub();
            ny = s.ny(auVar.field_imgPath);
        } else {
            ny = com.tencent.mm.ap.o.PC().b(auVar.field_imgPath, false, false);
            if (!(t.oN(ny) || ny.endsWith("hd") || !FileOp.bO(ny + "hd"))) {
                ny = ny + "hd";
            }
        }
        x.i("MicroMsg.ImageGalleryGridAdapter", "MsgInfoForMonetUri imgPath : %s", ny);
        if (!auVar.ckb()) {
            return ny;
        }
        com.tencent.mm.x.g.a fV = com.tencent.mm.x.g.a.fV(auVar.field_content);
        String str = null;
        if (!(fV == null || fV.for == null || fV.for.length() <= 0)) {
            b Se = an.aqK().Se(fV.for);
            if (Se != null) {
                str = Se.field_fileFullPath;
            }
        }
        if (str != null) {
            return str;
        }
        return ny;
    }

    public final void notifyDataSetChanged() {
        super.notifyDataSetChanged();
        this.yMs = false;
    }

    public final void onClick(View view) {
        a aVar = (a) view.getTag();
        if (aVar.mXO != null) {
            au auVar = (au) aVar.mXO.getTag();
            if (auVar != null) {
                g cvt = a.yNw;
                if (cvt.bo(auVar)) {
                    cvt.bn(auVar);
                } else {
                    cvt.bm(auVar);
                }
                if (a.yNw.bo(auVar)) {
                    aVar.mXO.setChecked(true);
                    aVar.yGY.setBackgroundResource(R.e.bsK);
                } else {
                    aVar.mXO.setChecked(false);
                    aVar.yGY.setBackgroundResource(R.e.bsQ);
                }
                if (!this.hMK && a.yNw.yLS.size() > 1) {
                    g.pWK.a(219, 20, 1, true);
                    this.hMK = true;
                }
            }
        }
    }

    static {
        Map hashMap = new HashMap();
        tXA = hashMap;
        hashMap.put("avi", Integer.valueOf(R.k.dvM));
        tXA.put("m4v", Integer.valueOf(R.k.dvM));
        tXA.put("vob", Integer.valueOf(R.k.dvM));
        tXA.put("mpeg", Integer.valueOf(R.k.dvM));
        tXA.put("mpe", Integer.valueOf(R.k.dvM));
        tXA.put("asx", Integer.valueOf(R.k.dvM));
        tXA.put("asf", Integer.valueOf(R.k.dvM));
        tXA.put("f4v", Integer.valueOf(R.k.dvM));
        tXA.put("flv", Integer.valueOf(R.k.dvM));
        tXA.put("mkv", Integer.valueOf(R.k.dvM));
        tXA.put("wmv", Integer.valueOf(R.k.dvM));
        tXA.put("wm", Integer.valueOf(R.k.dvM));
        tXA.put("3gp", Integer.valueOf(R.k.dvM));
        tXA.put("mp4", Integer.valueOf(R.k.dvM));
        tXA.put("rmvb", Integer.valueOf(R.k.dvM));
        tXA.put("rm", Integer.valueOf(R.k.dvM));
        tXA.put("ra", Integer.valueOf(R.k.dvM));
        tXA.put("ram", Integer.valueOf(R.k.dvM));
        tXA.put("mp3pro", Integer.valueOf(R.k.dvz));
        tXA.put("vqf", Integer.valueOf(R.k.dvz));
        tXA.put("cd", Integer.valueOf(R.k.dvz));
        tXA.put("md", Integer.valueOf(R.k.dvz));
        tXA.put("mod", Integer.valueOf(R.k.dvz));
        tXA.put("vorbis", Integer.valueOf(R.k.dvz));
        tXA.put("au", Integer.valueOf(R.k.dvz));
        tXA.put("amr", Integer.valueOf(R.k.dvz));
        tXA.put("silk", Integer.valueOf(R.k.dvz));
        tXA.put("wma", Integer.valueOf(R.k.dvz));
        tXA.put("mmf", Integer.valueOf(R.k.dvz));
        tXA.put("mid", Integer.valueOf(R.k.dvz));
        tXA.put("midi", Integer.valueOf(R.k.dvz));
        tXA.put("mp3", Integer.valueOf(R.k.dvz));
        tXA.put("aac", Integer.valueOf(R.k.dvz));
        tXA.put("ape", Integer.valueOf(R.k.dvz));
        tXA.put("aiff", Integer.valueOf(R.k.dvz));
        tXA.put("aif", Integer.valueOf(R.k.dvz));
        tXA.put("doc", Integer.valueOf(R.k.dvQ));
        tXA.put("docx", Integer.valueOf(R.k.dvQ));
        tXA.put("ppt", Integer.valueOf(R.k.dvF));
        tXA.put("pptx", Integer.valueOf(R.k.dvF));
        tXA.put("xls", Integer.valueOf(R.k.dvt));
        tXA.put("xlsx", Integer.valueOf(R.k.dvt));
        tXA.put("pdf", Integer.valueOf(R.k.dvD));
        tXA.put("unknown", Integer.valueOf(R.k.dvJ));
        hashMap = new HashMap();
        yMt = hashMap;
        hashMap.put("doc", Integer.valueOf(R.e.brn));
        yMt.put("docx", Integer.valueOf(R.e.brn));
        yMt.put("ppt", Integer.valueOf(R.e.brq));
        yMt.put("pptx", Integer.valueOf(R.e.brq));
        yMt.put("xls", Integer.valueOf(R.e.brt));
        yMt.put("xlsx", Integer.valueOf(R.e.brt));
        yMt.put("pdf", Integer.valueOf(R.e.brp));
        yMt.put("unknown", Integer.valueOf(R.e.brr));
        yMt.put("mp3pro", Integer.valueOf(R.e.bro));
        yMt.put("vqf", Integer.valueOf(R.e.bro));
        yMt.put("cd", Integer.valueOf(R.e.bro));
        yMt.put("md", Integer.valueOf(R.e.bro));
        yMt.put("mod", Integer.valueOf(R.e.bro));
        yMt.put("vorbis", Integer.valueOf(R.e.bro));
        yMt.put("au", Integer.valueOf(R.e.bro));
        yMt.put("amr", Integer.valueOf(R.e.bro));
        yMt.put("silk", Integer.valueOf(R.e.bro));
        yMt.put("wma", Integer.valueOf(R.e.bro));
        yMt.put("mmf", Integer.valueOf(R.e.bro));
        yMt.put("mid", Integer.valueOf(R.e.bro));
        yMt.put("midi", Integer.valueOf(R.e.bro));
        yMt.put("mp3", Integer.valueOf(R.e.bro));
        yMt.put("aac", Integer.valueOf(R.e.bro));
        yMt.put("ape", Integer.valueOf(R.e.bro));
        yMt.put("aiff", Integer.valueOf(R.e.bro));
        yMt.put("aif", Integer.valueOf(R.e.bro));
    }
}
