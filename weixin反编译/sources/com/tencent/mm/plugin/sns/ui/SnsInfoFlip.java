package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.f.a.pt;
import com.tencent.mm.memory.n;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.network.ab;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiGetAudioState;
import com.tencent.mm.plugin.sns.i;
import com.tencent.mm.plugin.sns.i.e;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.model.ai;
import com.tencent.mm.plugin.sns.model.am;
import com.tencent.mm.plugin.sns.storage.m;
import com.tencent.mm.plugin.sns.storage.u;
import com.tencent.mm.protocal.c.are;
import com.tencent.mm.protocal.c.bpb;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.an;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMPageControlView;
import com.tencent.mm.ui.base.MultiTouchImageView;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.tools.MMGestureGallery;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class SnsInfoFlip extends FlipView {
    private static int hcY = 0;
    private static int hcZ = 0;
    private Context context;
    private ag handler = new ag();
    List<com.tencent.mm.plugin.sns.g.b> hkf;
    boolean qWK = false;
    an qWV = an.xHx;
    boolean rFe = false;
    boolean rFg = false;
    b rHW;
    Gallery rHX;
    private boolean rHY = true;
    HashMap<Integer, Integer> rHZ = new HashMap();
    public int rIA = 0;
    public int rIB = 0;
    private HashMap<String, a> rIC = new HashMap();
    private com.tencent.mm.ui.base.MultiTouchImageView.a rID = new com.tencent.mm.ui.base.MultiTouchImageView.a() {
        public final void bBO() {
            if (SnsInfoFlip.this.rHX.getSelectedItem() != null && SnsInfoFlip.this.rHW != null) {
                int selectedItemPosition = SnsInfoFlip.this.rHX.getSelectedItemPosition();
                m LR = ae.bwf().LR(((com.tencent.mm.plugin.sns.g.b) SnsInfoFlip.this.rHX.getSelectedItem()).rgK);
                if (LR != null) {
                    ax.d(LR, selectedItemPosition);
                }
            }
        }

        public final void bBP() {
            if (SnsInfoFlip.this.rHX.getSelectedItem() != null && SnsInfoFlip.this.rHW != null) {
                int selectedItemPosition = SnsInfoFlip.this.rHX.getSelectedItemPosition();
                m LR = ae.bwf().LR(((com.tencent.mm.plugin.sns.g.b) SnsInfoFlip.this.rHX.getSelectedItem()).rgK);
                if (LR != null) {
                    ax.e(LR, selectedItemPosition);
                }
            }
        }
    };
    HashMap<Integer, Long> rIa = new HashMap();
    HashMap<Integer, Long> rIb = new HashMap();
    boolean rIc = false;
    boolean rId = false;
    boolean rIe = false;
    boolean rIf = false;
    boolean rIg = false;
    private boolean rIh = true;
    private boolean rIi = true;
    private float rIj = 1.0f;
    MMPageControlView rIk;
    Runnable rIl = null;
    private String rIm = "";
    private int rIn = -1;
    int rIo = -1;
    private boolean rIp = false;
    long rIq = 0;
    private HashSet<String> rIr = new HashSet();
    private Map<String, Boolean> rIs;
    private int rIt = 0;
    private int rIu = 0;
    private boolean rIv = false;
    c rIw;
    private HashMap<String, m> rIx = new HashMap();
    int rIy = -1;
    HashSet<String> rIz = new HashSet();
    public String username;

    public interface c {
        void xZ(int i);
    }

    class a {
        int hge;
        int networkType;
        int rIG = -1;
        long rIH = -1;
        long rII = -1;
        String rIJ;
        long rdT = -1;

        a() {
        }
    }

    class b extends BaseAdapter {
        private Context context;
        private String hjk = "";
        private boolean lyv = true;
        private boolean rIK = false;
        Map<String, WeakReference<View>> rIL = new HashMap();
        private String rIM;
        private int rwu = 0;

        public b(Context context) {
            this.context = context;
            this.rIK = g.cpy();
            this.rwu = SnsInfoFlip.this.hkf.size();
            com.tencent.mm.modelcontrol.c.MX();
            this.lyv = com.tencent.mm.modelcontrol.c.MZ();
        }

        public final int getCount() {
            return SnsInfoFlip.this.hkf == null ? 0 : SnsInfoFlip.this.hkf.size();
        }

        private void xX(int i) {
            are are = ((com.tencent.mm.plugin.sns.g.b) SnsInfoFlip.this.hkf.get(i)).fIx;
            an a = an.a(SnsInfoFlip.this.qWV, ((com.tencent.mm.plugin.sns.g.b) SnsInfoFlip.this.hkf.get(i)).hBH);
            if (are.kzz == 2) {
                boolean Mj = u.Mj(((com.tencent.mm.plugin.sns.g.b) SnsInfoFlip.this.hkf.get(i)).rgK);
                ae.bwc();
                Mj = com.tencent.mm.plugin.sns.model.g.a(are, a, Mj);
                if (SnsInfoFlip.this.rFe && !Mj) {
                    SnsInfoFlip.a(SnsInfoFlip.this, are.nMq);
                }
            }
        }

        public final int getViewTypeCount() {
            return 2;
        }

        public final int getItemViewType(int i) {
            if (((com.tencent.mm.plugin.sns.g.b) SnsInfoFlip.this.hkf.get(i)).fIx.kzz == 6) {
                return 0;
            }
            return 1;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            if (((com.tencent.mm.plugin.sns.g.b) SnsInfoFlip.this.hkf.get(i)).fIx.kzz == 6) {
                String str = "MicroMsg.SnsInfoFlip";
                String str2 = "fill view online sight %d convert view is null %b";
                Object[] objArr = new Object[2];
                objArr[0] = Integer.valueOf(i);
                objArr[1] = Boolean.valueOf(view == null);
                x.d(str, str2, objArr);
                com.tencent.mm.plugin.sns.g.b bVar = (com.tencent.mm.plugin.sns.g.b) SnsInfoFlip.this.hkf.get(i);
                if (bVar == null) {
                    x.w("MicroMsg.SnsInfoFlip", "fill online sight view, but flip item is null.");
                    return view;
                }
                str2 = bVar.rgK;
                if (bi.oN(str2)) {
                    x.w("MicroMsg.SnsInfoFlip", "fill online sight view, but sns local id is null.");
                    return view;
                }
                View onlineVideoView;
                WeakReference weakReference = (WeakReference) this.rIL.get(str2);
                if (weakReference == null || weakReference.get() == null) {
                    onlineVideoView = new OnlineVideoView(this.context);
                    this.rIL.put(str2, new WeakReference(onlineVideoView));
                } else {
                    onlineVideoView = (OnlineVideoView) weakReference.get();
                }
                if (bi.fA(str2, this.rIM)) {
                    xY(i);
                }
                x.i("MicroMsg.SnsInfoFlip", "return online sight view %d parent id %s", Integer.valueOf(onlineVideoView.hashCode()), bVar.rgK);
                return onlineVideoView;
            }
            d dVar;
            are are;
            Bitmap a;
            LayoutParams layoutParams;
            View multiTouchImageView;
            are are2 = ((com.tencent.mm.plugin.sns.g.b) SnsInfoFlip.this.hkf.get(i)).fIx;
            x.d("MicroMsg.SnsInfoFlip", "gallery position " + i + " " + this.rwu + " " + are2.nMq);
            if (i != SnsInfoFlip.this.rIn && (SnsInfoFlip.this.rHX instanceof MMGestureGallery)) {
                ((MMGestureGallery) SnsInfoFlip.this.rHX).zum = false;
            }
            if (view == null) {
                d dVar2 = new d();
                view = View.inflate(this.context, i.g.qNs, null);
                dVar2.rIN = view.findViewById(f.qHG);
                dVar2.nwK = (ProgressBar) view.findViewById(f.cEk);
                dVar2.obX = (TextView) view.findViewById(f.qKC);
                dVar2.rIO = (FrameLayout) view.findViewById(f.qHx);
                dVar2.fzb = (ImageView) view.findViewById(f.image);
                view.setTag(dVar2);
                dVar = dVar2;
            } else {
                dVar = (d) view.getTag();
            }
            dVar.position = i;
            an a2 = an.a(SnsInfoFlip.this.qWV, ((com.tencent.mm.plugin.sns.g.b) SnsInfoFlip.this.hkf.get(i)).hBH);
            view.setLayoutParams(new Gallery.LayoutParams(-1, -1));
            dVar.nwK.setVisibility(8);
            dVar.obX.setVisibility(8);
            dVar.rIO.setVisibility(0);
            Object obj = (bi.oN(SnsInfoFlip.this.rIm) || !SnsInfoFlip.this.rIm.equals(are2.nMq)) ? null : 1;
            if (are2.nMq.startsWith("Locall_path") && !bi.oN(((com.tencent.mm.plugin.sns.g.b) SnsInfoFlip.this.hkf.get(i)).rgK)) {
                m mVar = (m) SnsInfoFlip.this.rIx.get(((com.tencent.mm.plugin.sns.g.b) SnsInfoFlip.this.hkf.get(i)).rgK);
                if (mVar == null) {
                    m LR = ae.bwf().LR(((com.tencent.mm.plugin.sns.g.b) SnsInfoFlip.this.hkf.get(i)).rgK);
                    SnsInfoFlip.this.rIx.put(((com.tencent.mm.plugin.sns.g.b) SnsInfoFlip.this.hkf.get(i)).rgK, LR);
                    mVar = LR;
                }
                bpb byF = mVar.byF();
                if (byF.wYj.wfh.size() > ((com.tencent.mm.plugin.sns.g.b) SnsInfoFlip.this.hkf.get(i)).rgL) {
                    are = (are) byF.wYj.wfh.get(((com.tencent.mm.plugin.sns.g.b) SnsInfoFlip.this.hkf.get(i)).rgL);
                    a = ae.bwc().a(are, dVar.fzb, this.context.hashCode(), obj != null, a2, u.Mj(((com.tencent.mm.plugin.sns.g.b) SnsInfoFlip.this.hkf.get(i)).rgK));
                    if (a == null && SnsInfoFlip.this.rFe) {
                        SnsInfoFlip.a(SnsInfoFlip.this, are.nMq);
                    }
                    layoutParams = dVar.fzb.getLayoutParams();
                    layoutParams.width = -1;
                    layoutParams.height = -1;
                    dVar.fzb.setLayoutParams(layoutParams);
                    if (a != null && are.nMq != null && !are.nMq.startsWith("pre_temp_extend_pic")) {
                        LayoutParams layoutParams2 = dVar.fzb.getLayoutParams();
                        com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.b(this.context, 160.0f);
                        int b = com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.b(this.context, 200.0f);
                        com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.b(this.context, 44.0f);
                        com.tencent.mm.plugin.sns.model.g bwc = ae.bwc();
                        String aJ = com.tencent.mm.plugin.sns.data.i.aJ(1, are.nMq);
                        String str3 = are.nMq;
                        n KE = bwc.KE(aJ);
                        if (!com.tencent.mm.plugin.sns.data.i.b(KE)) {
                            KE = null;
                        }
                        if (KE != null) {
                            double width = (double) KE.bitmap.getWidth();
                            double height = (double) KE.bitmap.getHeight();
                            if (width > 0.0d && height > 0.0d) {
                                Math.min(((double) b) / width, ((double) b) / height);
                            }
                        }
                        dVar.fzb.setLayoutParams(layoutParams);
                        dVar.nwK.setVisibility(0);
                        dVar.fzb.setVisibility(0);
                        ae.bwc().cu(dVar.fzb);
                        ae.bwc().c(are, dVar.fzb, e.black, this.context.hashCode(), a2);
                        SnsInfoFlip.hcZ = layoutParams2.width;
                        SnsInfoFlip.hcY = layoutParams2.height;
                        if (obj != null) {
                            dVar.nwK.setVisibility(8);
                        }
                    } else if (this.rIK) {
                        dVar.nwK.setVisibility(8);
                        ae.bwc().a(are, dVar.fzb, this.context.hashCode(), a2, u.Mj(((com.tencent.mm.plugin.sns.g.b) SnsInfoFlip.this.hkf.get(i)).rgK));
                        dVar.fzb.setImageBitmap(a);
                        dVar.fzb.setVisibility(0);
                    } else {
                        dVar.nwK.setVisibility(8);
                        if (a != null) {
                            if (!SnsInfoFlip.this.rIv) {
                                return view;
                            }
                            x.i("MicroMsg.SnsInfoFlip", "update view ");
                            multiTouchImageView = new MultiTouchImageView(this.context, a.getWidth(), a.getHeight(), SnsInfoFlip.this.rID);
                            multiTouchImageView.rIg = SnsInfoFlip.this.rIg;
                            multiTouchImageView.setLayoutParams(new Gallery.LayoutParams(-1, -1));
                            ae.bwc().a(are, multiTouchImageView, this.context.hashCode(), a2, u.Mj(((com.tencent.mm.plugin.sns.g.b) SnsInfoFlip.this.hkf.get(i)).rgK));
                            multiTouchImageView.setImageBitmap(a);
                            x.d("MicroMsg.SnsInfoFlip", "dancy mediaId: %s, isbigImgLoaded: %s, view: %s", are.nMq, SnsInfoFlip.this.rIs.get(are.nMq), Integer.valueOf(multiTouchImageView.getId()));
                            return multiTouchImageView;
                        }
                    }
                    if (!this.lyv && ab.bC(this.context)) {
                        if (i - 1 >= 0) {
                            xX(i - 1);
                        }
                        if (i + 1 >= SnsInfoFlip.this.rHW.getCount()) {
                            return view;
                        }
                        xX(i + 1);
                        return view;
                    }
                }
            }
            are = are2;
            if (obj != null) {
            }
            a = ae.bwc().a(are, dVar.fzb, this.context.hashCode(), obj != null, a2, u.Mj(((com.tencent.mm.plugin.sns.g.b) SnsInfoFlip.this.hkf.get(i)).rgK));
            SnsInfoFlip.a(SnsInfoFlip.this, are.nMq);
            layoutParams = dVar.fzb.getLayoutParams();
            layoutParams.width = -1;
            layoutParams.height = -1;
            dVar.fzb.setLayoutParams(layoutParams);
            if (a != null) {
            }
            if (this.rIK) {
                dVar.nwK.setVisibility(8);
                ae.bwc().a(are, dVar.fzb, this.context.hashCode(), a2, u.Mj(((com.tencent.mm.plugin.sns.g.b) SnsInfoFlip.this.hkf.get(i)).rgK));
                dVar.fzb.setImageBitmap(a);
                dVar.fzb.setVisibility(0);
            } else {
                dVar.nwK.setVisibility(8);
                if (a != null) {
                    if (!SnsInfoFlip.this.rIv) {
                        return view;
                    }
                    x.i("MicroMsg.SnsInfoFlip", "update view ");
                    multiTouchImageView = new MultiTouchImageView(this.context, a.getWidth(), a.getHeight(), SnsInfoFlip.this.rID);
                    multiTouchImageView.rIg = SnsInfoFlip.this.rIg;
                    multiTouchImageView.setLayoutParams(new Gallery.LayoutParams(-1, -1));
                    ae.bwc().a(are, multiTouchImageView, this.context.hashCode(), a2, u.Mj(((com.tencent.mm.plugin.sns.g.b) SnsInfoFlip.this.hkf.get(i)).rgK));
                    multiTouchImageView.setImageBitmap(a);
                    x.d("MicroMsg.SnsInfoFlip", "dancy mediaId: %s, isbigImgLoaded: %s, view: %s", are.nMq, SnsInfoFlip.this.rIs.get(are.nMq), Integer.valueOf(multiTouchImageView.getId()));
                    return multiTouchImageView;
                }
            }
            return !this.lyv ? view : view;
        }

        public final void clear() {
            x.i("MicroMsg.SnsInfoFlip", "adapter clear.");
            this.rIL.clear();
        }

        public final void xY(int i) {
            com.tencent.mm.plugin.sns.g.b bVar = (com.tencent.mm.plugin.sns.g.b) SnsInfoFlip.this.hkf.get(i);
            if (bVar == null) {
                x.w("MicroMsg.SnsInfoFlip", "notify online sight play, but flip item is null.");
                return;
            }
            String str = bVar.rgK;
            if (bi.oN(str)) {
                x.w("MicroMsg.SnsInfoFlip", "notify online sight play, but sns local id is null.");
                return;
            }
            x.i("MicroMsg.SnsInfoFlip", "notify online sight play pos %s sns local id %s", Integer.valueOf(i), str);
            WeakReference weakReference = (WeakReference) this.rIL.get(str);
            if (weakReference == null) {
                x.w("MicroMsg.SnsInfoFlip", "notify online sight play, but view cache is null ");
                this.rIM = str;
                return;
            }
            OnlineVideoView onlineVideoView = (OnlineVideoView) weakReference.get();
            if (onlineVideoView == null) {
                x.w("MicroMsg.SnsInfoFlip", "online sight view is null, do nothing. snsLocalId %s", str);
                this.rIM = str;
                return;
            }
            x.i("MicroMsg.SnsInfoFlip", "%d notify online sight play video %s", Integer.valueOf(onlineVideoView.hashCode()), str);
            this.rIM = null;
            x.d("MicroMsg.OnlineVideoView", "%d register sns ui event", Integer.valueOf(onlineVideoView.hashCode()));
            com.tencent.mm.sdk.b.a.xmy.b(onlineVideoView.rBk);
            onlineVideoView.a(bVar.fIx, bVar.rgK, bVar.hBH);
            com.tencent.mm.sdk.b.b ptVar = new pt();
            ptVar.fIp.fvG = 1;
            ptVar.fIp.fvn = str;
            com.tencent.mm.sdk.b.a.xmy.m(ptVar);
        }

        public final void bBQ() {
            x.i("MicroMsg.SnsInfoFlip", "notify online sight stop %s", bi.chl());
            this.rIM = null;
            com.tencent.mm.sdk.b.b ptVar = new pt();
            ptVar.fIp.fvG = 2;
            com.tencent.mm.sdk.b.a.xmy.m(ptVar);
        }

        public final Object getItem(int i) {
            if (i >= SnsInfoFlip.this.hkf.size() || i < 0) {
                return null;
            }
            return SnsInfoFlip.this.hkf.get(i);
        }

        public final long getItemId(int i) {
            return 0;
        }

        public final void notifyDataSetChanged() {
            this.rwu = SnsInfoFlip.this.hkf.size();
            x.d("MicroMsg.SnsInfoFlip", "items.size:" + SnsInfoFlip.this.hkf.size());
            SnsInfoFlip.this.invalidate();
            SnsInfoFlip.this.requestLayout();
            super.notifyDataSetChanged();
            if (SnsInfoFlip.this.hkf.size() <= 0 && SnsInfoFlip.this.rIl != null) {
                SnsInfoFlip.this.rIl.run();
            }
        }
    }

    static class d {
        ImageView fzb;
        ProgressBar nwK;
        TextView obX;
        int position;
        View rIN;
        FrameLayout rIO;
        String videoPath = "";

        d() {
        }
    }

    static /* synthetic */ void a(SnsInfoFlip snsInfoFlip, String str) {
        x.d("MicroMsg.SnsInfoFlip", "recordLoadStart, bigPicId:%s", str);
        if (!snsInfoFlip.rIC.containsKey(str)) {
            a aVar = new a();
            aVar.hge = snsInfoFlip.getCount();
            aVar.networkType = bBL();
            aVar.rIH = System.currentTimeMillis();
            aVar.rIJ = str;
            snsInfoFlip.rIC.put(str, aVar);
            x.d("MicroMsg.SnsInfoFlip", "recordLoadStart, put to map");
        }
    }

    public SnsInfoFlip(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public SnsInfoFlip(Context context) {
        super(context);
        init(context);
    }

    public final boolean bzX() {
        return this.rFe;
    }

    private void init(final Context context) {
        this.rIq = System.currentTimeMillis();
        this.context = context;
        View inflate = inflate(context, i.g.qNv, this);
        if (g.cpy()) {
            inflate.findViewById(f.qIj).setVisibility(0);
            this.rHX = (Gallery) inflate.findViewById(f.qIj);
        } else {
            inflate.findViewById(f.qIk).setVisibility(0);
            this.rHX = (Gallery) inflate.findViewById(f.qIk);
        }
        if (this.rHX instanceof MMGestureGallery) {
            this.rHX.setSpacing(50);
            ((MMGestureGallery) this.rHX).zuj = new MMGestureGallery.f() {
                public final void awD() {
                    if (context instanceof SnsBrowseUI) {
                        ((SnsBrowseUI) context).awC();
                    } else if (SnsInfoFlip.this.rIe) {
                        ((MMActivity) context).finish();
                    } else {
                        SnsInfoFlip.this.handler.post(new Runnable() {
                            public final void run() {
                                if (SnsInfoFlip.this.ryy != null && SnsInfoFlip.this.rIf) {
                                    SnsInfoFlip.this.ryy.asq();
                                }
                            }
                        });
                    }
                }
            };
            ((MMGestureGallery) this.rHX).zul = new MMGestureGallery.e() {
                public final void bBN() {
                    if (SnsInfoFlip.this.ryy != null) {
                        SnsInfoFlip.this.ryy.bAa();
                    }
                }
            };
        }
        this.rIk = (MMPageControlView) findViewById(f.qMl);
        this.rIk.ykM = i.g.qOp;
        this.rIs = new HashMap();
    }

    public final void xU(int i) {
        this.infoType = i;
    }

    public final com.tencent.mm.plugin.sns.g.b bBG() {
        if (this.rHX == null) {
            return null;
        }
        return (com.tencent.mm.plugin.sns.g.b) this.rHX.getSelectedItem();
    }

    private static int b(String str, bpb bpb) {
        Iterator it = bpb.wYj.wfh.iterator();
        int i = 0;
        while (it.hasNext()) {
            i++;
            if (str.equals(((are) it.next()).nMq)) {
                return i;
            }
        }
        return 0;
    }

    private void a(are are, int i, String str) {
        long j = 0;
        if (this.rHX != null && (this.rHX instanceof MMGestureGallery)) {
            float f;
            float f2;
            if (are.wES != null) {
                f = are.wES.wFG;
                f2 = are.wES.wFF;
            } else {
                f = 0.0f;
                f2 = 0.0f;
            }
            float f3;
            if (f <= 0.0f || f2 <= 0.0f) {
                Options Vq = com.tencent.mm.sdk.platformtools.d.Vq(are.nMq.startsWith("Locall_path") ? am.r(ae.getAccSnsPath(), are.nMq) + com.tencent.mm.plugin.sns.data.i.m(are) : am.r(ae.getAccSnsPath(), are.nMq) + com.tencent.mm.plugin.sns.data.i.d(are));
                if (Vq != null) {
                    f3 = (float) Vq.outWidth;
                    f2 = (float) Vq.outHeight;
                }
            } else {
                f3 = f2;
                f2 = f;
            }
            if (f2 > 0.0f && f3 > 0.0f) {
                MMGestureGallery mMGestureGallery = (MMGestureGallery) this.rHX;
                if (!this.rIg || ((double) f3) * 1.0d <= ((double) f2) * 2.0d) {
                    x.d("MicroMsg.SnsInfoFlip", "set on fling false");
                    mMGestureGallery.ymX = false;
                } else {
                    x.d("MicroMsg.SnsInfoFlip", "set on fling true");
                    mMGestureGallery.ymX = true;
                }
            }
        }
        if (this.rIw != null) {
            this.rIw.xZ(i);
        }
        m LR = ae.bwf().LR(str);
        if (LR != null) {
            ax.c(LR, i);
        }
        if (this.rIn == -1) {
            this.rIn = i;
        }
        this.rIo = 1;
        String str2 = are.nMq;
        if (bi.oN(str)) {
            this.ryy.ew((i + 1) + " / " + this.rHW.getCount(), null);
            return;
        }
        LR = (m) this.rIx.get(str);
        if (LR == null) {
            LR = ae.bwf().LR(str);
            this.rIx.put(str, LR);
        }
        m mVar = LR;
        if (mVar != null) {
            String str3;
            if (are.kzz == 2) {
                if (this.rHX instanceof MMGestureGallery) {
                    ((MMGestureGallery) this.rHX).zum = false;
                }
            } else if (this.rHX instanceof MMGestureGallery) {
                ((MMGestureGallery) this.rHX).zum = true;
            }
            if (are.kzz != 6) {
                ae.aOA().post(new Runnable() {
                    public final void run() {
                        SnsInfoFlip.this.rHW.bBQ();
                    }
                });
            }
            x.d("MicroMsg.SnsInfoFlip", "onItemSelected  " + i + " localId " + str);
            if (this.rIy != i) {
                this.rHZ.put(Integer.valueOf(i), Integer.valueOf((this.rHZ.containsKey(Integer.valueOf(i)) ? ((Integer) this.rHZ.get(Integer.valueOf(i))).intValue() : 0) + 1));
                this.rIa.put(Integer.valueOf(i), Long.valueOf(bi.Wz()));
                if (this.rIy >= 0) {
                    long longValue;
                    if (this.rIa.containsKey(Integer.valueOf(this.rIy))) {
                        longValue = ((Long) this.rIa.get(Integer.valueOf(this.rIy))).longValue();
                    } else {
                        longValue = 0;
                    }
                    if (longValue > 0) {
                        this.rIa.put(Integer.valueOf(this.rIy), Long.valueOf(0));
                        if (this.rIb.containsKey(Integer.valueOf(this.rIy))) {
                            j = ((Long) this.rIb.get(Integer.valueOf(this.rIy))).longValue();
                        }
                        longValue = bi.bB(longValue);
                        j += longValue;
                        this.rIb.put(Integer.valueOf(this.rIy), Long.valueOf(j));
                        x.i("MicroMsg.SnsInfoFlip", "lastSelectPosition " + this.rIy + " curtime " + j + " passtime " + (((double) longValue) / 1000.0d));
                    }
                }
                if (this.rFe && this.rHW != null) {
                    com.tencent.mm.plugin.sns.g.b bVar = (com.tencent.mm.plugin.sns.g.b) this.rHW.getItem(this.rIy);
                    if (bVar != null) {
                        str3 = bVar.fIx.nMq;
                        x.d("MicroMsg.SnsInfoFlip", "recordMediaScollOver, bigPicId:%s", str3);
                        if (this.rIC.containsKey(str3)) {
                            a aVar = (a) this.rIC.get(str3);
                            aVar.networkType = bBL();
                            if (aVar.rII != -1) {
                                aVar.rIG = 1;
                                aVar.rdT = aVar.rII - aVar.rIH;
                                x.d("MicroMsg.SnsInfoFlip", "recordMediaScollOver, load success, costTime:%d", Long.valueOf(aVar.rdT));
                            } else {
                                aVar.rIG = 2;
                                aVar.rII = System.currentTimeMillis();
                                aVar.rdT = aVar.rII - aVar.rIH;
                                x.d("MicroMsg.SnsInfoFlip", "recordMediaScollOver, load failed, costTime:%d", Long.valueOf(aVar.rdT));
                            }
                        }
                    }
                }
            }
            this.rIy = i;
            if (this.ryx != null) {
                this.ryx.Mt(str);
            }
            int i2 = mVar.field_createTime;
            bpb byF = mVar.byF();
            String l = az.l(this.context, ((long) i2) * 1000);
            str3 = null;
            if (!(byF == null || byF.wYj == null || byF.wYj.wfh.size() <= 1)) {
                str3 = (((com.tencent.mm.plugin.sns.g.b) this.hkf.get(i)).rgL + 1) + " / " + byF.wYj.wfh.size();
                this.rIo = b(str2, byF);
            }
            this.ryy.ew(l, str3);
            this.ryy.cl(str, i);
            if (this.rHW != null) {
                this.rHW.xY(i);
            }
        }
    }

    public final void a(List<com.tencent.mm.plugin.sns.g.b> list, String str, int i, v vVar, com.tencent.mm.plugin.sns.ui.t.a aVar) {
        ae.bwa().a((com.tencent.mm.plugin.sns.model.b.b) this);
        this.hkf = list;
        this.rIp = this.hkf.size() > 1;
        ai.KR(str);
        this.ryx = vVar;
        this.ryy = aVar;
        this.rHW = new b(this.context);
        this.rHX.setAdapter(this.rHW);
        if (i >= 0 && i < this.hkf.size()) {
            this.rHX.setSelection(i);
            if (this.rIi) {
                this.rIi = false;
                are are = ((com.tencent.mm.plugin.sns.g.b) this.hkf.get(i)).fIx;
                if (are == null || are.wES == null || are.wES.wFG <= 0.0f) {
                    this.rIj = 1.0f;
                } else {
                    this.rIj = are.wES.wFF / are.wES.wFG;
                }
            }
        }
        this.rHX.setFadingEdgeLength(0);
        this.rHX.setOnItemSelectedListener(new OnItemSelectedListener() {
            public final void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
                if (SnsInfoFlip.this.rHW != null) {
                    if (SnsInfoFlip.this.rIc && SnsInfoFlip.this.rHW.getCount() > 1) {
                        SnsInfoFlip.this.rIk.setVisibility(0);
                        SnsInfoFlip.this.rIk.xs(i);
                    }
                    SnsInfoFlip.this.a(((com.tencent.mm.plugin.sns.g.b) SnsInfoFlip.this.rHW.getItem(i)).fIx, i, ((com.tencent.mm.plugin.sns.g.b) SnsInfoFlip.this.rHW.getItem(i)).rgK);
                    if (view instanceof MultiTouchImageView) {
                        ((MultiTouchImageView) view).cqG();
                    }
                    if ((SnsInfoFlip.this.rHX instanceof MMGestureGallery) && (SnsInfoFlip.this.context instanceof SnsBrowseUI)) {
                        ((SnsBrowseUI) SnsInfoFlip.this.context).bBj();
                    }
                }
            }

            public final void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
        if (this.rHY) {
            this.rHX.setOnItemLongClickListener(new OnItemLongClickListener() {
                public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                    if (!SnsInfoFlip.this.rHY) {
                        return true;
                    }
                    String str = ((com.tencent.mm.plugin.sns.g.b) SnsInfoFlip.this.rHW.getItem(i)).rgK;
                    if (bi.oN(str)) {
                        return false;
                    }
                    String str2 = ((com.tencent.mm.plugin.sns.g.b) SnsInfoFlip.this.rHW.getItem(i)).fIx.nMq;
                    SnsInfoFlip.this.e(am.r(ae.getAccSnsPath(), str2) + com.tencent.mm.plugin.sns.data.i.l(((com.tencent.mm.plugin.sns.g.b) SnsInfoFlip.this.rHW.getItem(i)).fIx), str, str2, true);
                    return true;
                }
            });
        }
        if (this.rIc && this.rHW.getCount() > 1) {
            this.rIk.setVisibility(0);
            this.rIk.eU(this.rHW.getCount(), i);
        }
        if (this.rFg && !bi.oN(((com.tencent.mm.plugin.sns.g.b) this.rHW.getItem(i)).rgK)) {
            Mq(am.r(ae.getAccSnsPath(), ((com.tencent.mm.plugin.sns.g.b) this.rHW.getItem(i)).fIx.nMq) + com.tencent.mm.plugin.sns.data.i.l(((com.tencent.mm.plugin.sns.g.b) this.rHW.getItem(i)).fIx));
        }
    }

    public final long bzW() {
        com.tencent.mm.plugin.sns.g.b bVar = (com.tencent.mm.plugin.sns.g.b) this.rHX.getSelectedItem();
        String str = bVar == null ? "" : bVar.rgK;
        if (bi.oN(str)) {
            return 0;
        }
        m LR = ae.bwf().LR(str);
        return LR == null ? 0 : LR.field_snsId;
    }

    public final int getPosition() {
        return this.rIo;
    }

    private void bBH() {
        if (this.rHX.getSelectedItem() != null && this.rHW != null) {
            int selectedItemPosition = this.rHX.getSelectedItemPosition();
            if (this.rIc && this.rHW.getCount() > 1) {
                this.rIk.setVisibility(0);
                this.rIk.xs(selectedItemPosition);
            }
            are are = ((com.tencent.mm.plugin.sns.g.b) this.rHX.getSelectedItem()).fIx;
            this.rIz.add(are.nMq);
            String str = ((com.tencent.mm.plugin.sns.g.b) this.rHX.getSelectedItem()).rgK;
            String str2 = are.nMq;
            if (bi.oN(this.rIm) || !this.rIm.equals(str2)) {
                this.rIm = "";
            }
            a(are, selectedItemPosition, str);
        }
    }

    public final void aHX() {
        if (this.rHW != null) {
            x.d("MicroMsg.SnsInfoFlip", "onRefresh ");
            this.rHW.notifyDataSetChanged();
            bBH();
        }
    }

    protected final void onPause() {
        super.onPause();
        if (this.rHW != null) {
            this.rHW.bBQ();
            this.rHW.clear();
        }
    }

    protected void onMeasure(int i, int i2) {
        this.rIv = true;
        super.onMeasure(i, i2);
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.rIv = false;
        super.onLayout(z, i, i2, i3, i4);
    }

    public final void bBI() {
        x.i("MicroMsg.SnsInfoFlip", "sns info flip on detch.");
        if (this.rHW != null) {
            this.rHW.bBQ();
            this.rHW.clear();
        }
        ae.bwa().b((com.tencent.mm.plugin.sns.model.b.b) this);
    }

    public final int bBJ() {
        if (this.rHX == null) {
            return -1;
        }
        this.hkf.remove(this.rHX.getSelectedItemPosition());
        this.rHW.notifyDataSetChanged();
        bBH();
        return this.rHW.getCount();
    }

    public final int getCount() {
        if (this.rHW != null) {
            return this.rHW.getCount();
        }
        return 0;
    }

    public final are bzY() {
        if (this.rHW != null) {
            int selectedItemPosition = this.rHX.getSelectedItemPosition();
            if (this.hkf != null && selectedItemPosition < this.hkf.size()) {
                return ((com.tencent.mm.plugin.sns.g.b) this.hkf.get(selectedItemPosition)).fIx;
            }
        }
        return null;
    }

    public final int bBK() {
        int i;
        int i2 = 0;
        Iterator it = this.hkf.iterator();
        int i3 = 0;
        while (true) {
            i = i2;
            if (!it.hasNext()) {
                break;
            }
            com.tencent.mm.plugin.sns.g.b bVar = (com.tencent.mm.plugin.sns.g.b) it.next();
            ae.bwc();
            if (FileOp.bO(com.tencent.mm.plugin.sns.model.g.C(bVar.fIx))) {
                i++;
            }
            i2 = i3 + 1;
            i3 = 9;
            if (i2 > 9) {
                break;
            }
        }
        return i;
    }

    public final void aE(String str, boolean z) {
        are are;
        if (!z) {
            are = ((com.tencent.mm.plugin.sns.g.b) this.rHX.getSelectedItem()).fIx;
            if (!(are == null || are.nMq == null || !are.nMq.equals(str))) {
                Toast.makeText(this.context, this.context.getString(j.qQA), 0).show();
                this.rIm = str;
            }
        }
        this.rIB++;
        if (this.rFe) {
            x.d("MicroMsg.SnsInfoFlip", "recordLoadEnd, bigPicId:%s, suceess:%b", str, Boolean.valueOf(z));
            if (z && this.rIC.containsKey(str)) {
                a aVar = (a) this.rIC.get(str);
                aVar.rII = System.currentTimeMillis();
                aVar.networkType = bBL();
                x.d("MicroMsg.SnsInfoFlip", "recordLoadEnd, update map");
                this.rIs.put(str, Boolean.valueOf(true));
            }
        }
        if (this.rHW != null && ((com.tencent.mm.plugin.sns.g.b) this.rHX.getSelectedItem()) != null) {
            are = ((com.tencent.mm.plugin.sns.g.b) this.rHX.getSelectedItem()).fIx;
            if (are != null && are.nMq != null && are.nMq.equals(str)) {
                this.rHW.notifyDataSetChanged();
                if (this.rFg && are != null) {
                    String r = am.r(ae.getAccSnsPath(), are.nMq);
                    String l = com.tencent.mm.plugin.sns.data.i.l(are);
                    if (FileOp.bO(r + l)) {
                        l = r + l;
                        Intent intent = new Intent();
                        x.i("MicroMsg.FlipView", "edit image path:%s", l);
                        intent.putExtra("before_photo_edit", l);
                        intent.putExtra("from_scene", JsApiGetAudioState.CTRL_INDEX);
                        intent.putExtra("after_photo_edit", "");
                        intent.putExtra("Retr_Compress_Type", 0);
                        intent.putExtra("Retr_Msg_Type", 0);
                        intent.putExtra("Retr_FromMainTimeline", bzX());
                        com.tencent.mm.bl.d.b(this.context, "photoedit", ".ui.MMNewPhotoEditUI", intent);
                    }
                }
            }
        }
    }

    public final void aF(String str, boolean z) {
        x.i("MicroMsg.SnsInfoFlip", "onSightFinish " + str + " " + z);
        if (!z) {
            are are = ((com.tencent.mm.plugin.sns.g.b) this.rHX.getSelectedItem()).fIx;
            if (!(are == null || are.nMq == null || !are.nMq.equals(str))) {
                Toast.makeText(this.context, this.context.getString(j.qQB), 0).show();
                this.rIm = str;
            }
        }
        if (this.rHW != null) {
            this.rHW.notifyDataSetChanged();
        }
    }

    private static int bBL() {
        Context context = ad.getContext();
        if (ao.is2G(context)) {
            return 1;
        }
        if (ao.is3G(context)) {
            return 2;
        }
        if (ao.is4G(context)) {
            return 3;
        }
        if (ao.isWifi(context)) {
            return 4;
        }
        return 0;
    }

    public final void bBM() {
        for (a aVar : this.rIC.values()) {
            if (aVar.rIG != -1) {
                com.tencent.mm.plugin.report.service.g.pWK.h(11601, Integer.valueOf(aVar.hge), Integer.valueOf(aVar.rIG), Long.valueOf(aVar.rdT), Integer.valueOf(aVar.networkType));
                x.d("MicroMsg.SnsInfoFlip", "report big pic load, picNum:%d, loadResult:%d, loadCostTime:%d, networkType:%d", Integer.valueOf(aVar.hge), Integer.valueOf(aVar.rIG), Long.valueOf(aVar.rdT), Integer.valueOf(aVar.networkType));
            } else if (aVar.rIH != -1) {
                if (aVar.rII != -1) {
                    aVar.rIG = 1;
                } else {
                    aVar.rIG = 2;
                    aVar.rII = System.currentTimeMillis();
                }
                aVar.rdT = aVar.rII - aVar.rIH;
                com.tencent.mm.plugin.report.service.g.pWK.h(11601, Integer.valueOf(aVar.hge), Integer.valueOf(aVar.rIG), Long.valueOf(aVar.rdT), Integer.valueOf(aVar.networkType));
                x.d("MicroMsg.SnsInfoFlip", "report big pic load, picNum:%d, loadResult:%d, loadCostTime:%d, networkType:%d", Integer.valueOf(aVar.hge), Integer.valueOf(aVar.rIG), Long.valueOf(aVar.rdT), Integer.valueOf(aVar.networkType));
            }
        }
        this.rIC.clear();
    }
}
