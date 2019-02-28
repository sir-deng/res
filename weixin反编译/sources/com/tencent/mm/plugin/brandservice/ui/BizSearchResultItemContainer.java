package com.tencent.mm.plugin.brandservice.ui;

import android.content.Context;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.plugin.brandservice.a.h;
import com.tencent.mm.plugin.brandservice.a.i;
import com.tencent.mm.protocal.c.jm;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.as;
import java.util.List;

public class BizSearchResultItemContainer extends LinearLayout implements e {
    private int itU = 0;
    int kKZ;
    private ListView kLp;
    c kLq;
    private TextView kLr;
    c kLs;
    private a kLt;
    i kLu;
    b kLv;
    private long[] kLw;
    int kLx;
    private boolean kLy;
    int kLz;

    private static class c {
        public String foW;
        public int hGC;
        public long kKy;
        public boolean kLF;
        public boolean kLG;
        public int offset;

        private c() {
            this.hGC = 1;
        }

        /* synthetic */ c(byte b) {
            this();
        }
    }

    private static class a {
        View kLC;
        View kLD;
        View kLE;

        private a() {
        }

        /* synthetic */ a(byte b) {
            this();
        }

        public final void nP(int i) {
            switch (i) {
                case 1:
                    q(true, false);
                    return;
                case 2:
                    q(false, true);
                    return;
                case 3:
                    q(false, false);
                    return;
                default:
                    q(false, false);
                    return;
            }
        }

        private void q(boolean z, boolean z2) {
            int i;
            int i2 = 0;
            View view = this.kLC;
            if (z) {
                i = 0;
            } else {
                i = 8;
            }
            view.setVisibility(i);
            this.kLD.setVisibility(8);
            View view2 = this.kLE;
            if (!z2) {
                i2 = 8;
            }
            view2.setVisibility(i2);
        }
    }

    public interface b {
        void asX();

        void asY();
    }

    static /* synthetic */ boolean a(BizSearchResultItemContainer bizSearchResultItemContainer) {
        return (!bizSearchResultItemContainer.kLs.kLG || bizSearchResultItemContainer.kLs.hGC == 0 || bizSearchResultItemContainer.kLs.kLF) ? false : true;
    }

    public BizSearchResultItemContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        View inflate = View.inflate(getContext(), R.i.cKh, this);
        this.kLs = new c();
        this.kLt = new a();
        this.kLr = (TextView) inflate.findViewById(R.h.cee);
        this.kLp = (ListView) inflate.findViewById(R.h.cHT);
    }

    public final void a(c cVar) {
        this.kLq = cVar;
        if (this.kLq != null) {
            this.kLq.lO(this.itU);
            ListView listView = this.kLp;
            a aVar = this.kLt;
            View inflate = View.inflate(getContext(), R.i.dmL, null);
            aVar.kLC = inflate.findViewById(R.h.ctD);
            aVar.kLD = inflate.findViewById(R.h.ctz);
            aVar.kLE = inflate.findViewById(R.h.ctF);
            aVar.kLC.setVisibility(8);
            aVar.kLD.setVisibility(8);
            aVar.kLE.setVisibility(8);
            listView.addFooterView(inflate, null, false);
            this.kLp.setAdapter(this.kLq);
            this.kLp.setOnScrollListener(new OnScrollListener() {
                boolean kLA = false;

                public final void onScrollStateChanged(AbsListView absListView, int i) {
                    if (i == 0 && this.kLA && BizSearchResultItemContainer.a(BizSearchResultItemContainer.this)) {
                        BizSearchResultItemContainer.this.b(BizSearchResultItemContainer.this.kLs.foW, BizSearchResultItemContainer.this.kLs.offset, BizSearchResultItemContainer.this.kLw[BizSearchResultItemContainer.this.kLw.length - 1]);
                    }
                }

                public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
                    if (i + i2 == i3) {
                        this.kLA = true;
                    } else {
                        this.kLA = false;
                    }
                }
            });
            this.kLp.setOnItemClickListener(this.kLq);
            if (this.kLs.kKy == 0) {
                d(1);
                return;
            }
            return;
        }
        this.kLp.setAdapter(this.kLq);
    }

    private void b(String str, int i, long j) {
        jm jmVar = null;
        this.kLs.kLF = true;
        as.CN().a(1071, (e) this);
        a bO = this.kLq.bO(this.kLw[this.kLw.length - 1]);
        List list = bO != null ? bO.kLo : null;
        if (list == null || list.size() == 0) {
            x.i("MicroMsg.BrandService.BizSearchResultItemContainer", "Get business content by type failed.(keyword : %s, offset : %s, businessType : %s)", str, Integer.valueOf(i), Long.valueOf(j));
        } else {
            jmVar = (jm) list.get(list.size() - 1);
        }
        x.d("MicroMsg.BrandService.BizSearchResultItemContainer", "keyword(%s), offset(%d), businessType(%d), searchId(%s).", str, Integer.valueOf(i), Long.valueOf(j), jmVar != null ? jmVar.vWw : "");
        as.CN().a(new h(str, j, i, this.itU, r6), 0);
        this.kLt.nP(1);
    }

    public final void a(int i, int i2, String str, k kVar) {
        int i3 = 3;
        x.i("MicroMsg.BrandService.BizSearchResultItemContainer", "errType (%d) , errCode (%d) , errMsg (errMsg)", Integer.valueOf(i), Integer.valueOf(i2), str);
        if (this.kLv != null) {
            this.kLv.asY();
        }
        if (i == 0 && i2 == 0) {
            this.kLy = false;
            if (kVar == null) {
                x.e("MicroMsg.BrandService.BizSearchResultItemContainer", "scene is null.");
                return;
            }
            int i4;
            int i5;
            if (kVar.getType() == 1070) {
                x.i("MicroMsg.BrandService.BizSearchResultItemContainer", "BizSearchHomePage.");
                as.CN().b(1070, (e) this);
                i iVar = (i) kVar;
                List list = iVar.kKz == null ? null : iVar.kKz.wRT;
                this.kLq.c(this.kLs.foW, list);
                a bO = this.kLq.bO(this.kLw[this.kLw.length - 1]);
                i5 = (bO == null || bO.kLn) ? 0 : bO.hGC;
                if (i5 != 0) {
                    i3 = 2;
                }
                if (list != null && list.size() > 0) {
                    jm jmVar = (jm) list.get(list.size() - 1);
                    if (jmVar != null) {
                        this.kLs.offset = jmVar.vUN + this.kLx;
                    }
                }
                i4 = i3;
                i3 = i5;
            } else if (kVar.getType() == 1071) {
                as.CN().b(1071, (e) this);
                x.i("MicroMsg.BrandService.BizSearchResultItemContainer", "BizSearchDetailPage.");
                jm asS = ((h) kVar).asS();
                if (asS == null || asS.nmz == null) {
                    x.e("MicroMsg.BrandService.BizSearchResultItemContainer", "BusinessContent or itemList is null.");
                }
                i5 = asS == null ? 0 : asS.vWu;
                if (i5 == 0) {
                    i4 = 3;
                } else {
                    i4 = 2;
                }
                this.kLq.a(asS, true);
                if (asS != null) {
                    x.d("MicroMsg.BrandService.BizSearchResultItemContainer", "searchId : %s.", asS.vWw);
                    this.kLs.offset = asS.vUN + this.kLx;
                }
                i3 = i5;
            } else {
                x.e("MicroMsg.BrandService.BizSearchResultItemContainer", "Error type(%d).", Integer.valueOf(kVar.getType()));
                return;
            }
            if (this.kLq.isEmpty()) {
                new ag(Looper.getMainLooper()).post(new Runnable() {
                    public final void run() {
                        BizSearchResultItemContainer.this.kLr.setVisibility(BizSearchResultItemContainer.this.kLq.isEmpty() ? 0 : 8);
                    }
                });
            } else {
                this.kLs.kLG = true;
            }
            this.kLs.hGC = i3;
            this.kLt.nP(i4);
            this.kLs.kLF = false;
            x.v("MicroMsg.BrandService.BizSearchResultItemContainer", "The next load data offset is (%d).", Integer.valueOf(this.kLs.offset));
            return;
        }
        this.kLs.kLF = false;
        this.kLy = true;
        Toast.makeText(getContext(), getContext().getString(R.l.ejr, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
    }

    final void reset() {
        this.kLq.asW();
        this.kLt.nP(0);
        this.kLs.kLG = false;
        this.kLs.kLF = false;
        this.kLs.offset = 0;
        this.kLs.foW = null;
        this.kLs.hGC = 1;
    }

    public final void d(long... jArr) {
        this.kLw = jArr;
        this.kLs.kKy = 0;
        for (int i = 0; i <= 0; i++) {
            c cVar = this.kLs;
            cVar.kKy |= jArr[0];
        }
        this.kLq.c(jArr);
    }

    public final void aW(String str, int i) {
        if (this.kLq.isEmpty()) {
            this.kLr.setVisibility(8);
        }
        if (str != null) {
            String trim = str.trim();
            if (!"".equals(trim)) {
                if ((!trim.equals(this.kLs.foW) || this.kLy) && !this.kLs.kLF) {
                    reset();
                    this.kLs.kLF = true;
                    this.kLs.foW = trim;
                    this.kLx = i;
                    if (this.kLz != 1) {
                        as.CN().a(1070, (e) this);
                        this.kLu = new i(this.kLs.foW, this.kLs.kKy, this.itU);
                        as.CN().a(this.kLu, 0);
                    } else if (this.kLw.length == 0) {
                        x.i("MicroMsg.BrandService.BizSearchResultItemContainer", "business type size is 0.");
                        return;
                    } else {
                        b(trim, i, this.kLw[0]);
                        this.kLt.nP(0);
                    }
                    if (this.kLv != null) {
                        this.kLv.asX();
                    }
                }
            }
        }
    }

    public final void lO(int i) {
        this.itU = i;
        this.kLq.lO(this.itU);
    }

    public final void ea(boolean z) {
        this.kLq.p(z, false);
    }

    public void setOnTouchListener(OnTouchListener onTouchListener) {
        super.setOnTouchListener(onTouchListener);
        this.kLp.setOnTouchListener(onTouchListener);
    }
}
