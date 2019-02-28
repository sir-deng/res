package com.tencent.mm.ui.widget;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.support.design.widget.BottomSheetBehavior;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.t;
import android.text.method.LinkMovementMethod;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import com.tencent.mm.ca.a.e;
import com.tencent.mm.ca.a.f;
import com.tencent.mm.ca.a.h;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.p.c;
import com.tencent.mm.ui.base.p.d;
import com.tencent.wcdb.FileUtils;

public final class g implements OnGlobalLayoutListener {
    public static int zCs = 0;
    public static int zCt = 1;
    public static int zCu = 2;
    private ViewTreeObserver Md;
    private RecyclerView Va;
    private View hH;
    public View lHV;
    public Context mContext;
    public boolean pJJ = false;
    public c rQF;
    public d rQG;
    private n rQH;
    private boolean tMG = false;
    private boolean tMH;
    public boolean tMI;
    public boolean tMJ = false;
    private int yQU;
    private BottomSheetBehavior yQV;
    private boolean zCA = false;
    public boolean zCB = false;
    private boolean zCC = false;
    public int zCD = 0;
    private boolean zCE = false;
    public a zCF;
    private Dialog zCg;
    private d zCh;
    private n zCi;
    public Boolean zCj = Boolean.valueOf(false);
    private LinearLayout zCk;
    private LinearLayout zCl;
    private b zCm;
    private boolean zCn = false;
    private boolean zCo = false;
    private boolean zCp = false;
    private int zCq;
    public ImageView zCr;
    private int zCv = 4;
    private int zCw = (this.zCv * 3);
    private int zCx = 6;
    private int zCy;
    private boolean zCz;
    public com.tencent.mm.ui.base.p.a zux;
    public com.tencent.mm.ui.base.p.b zuy;

    public interface a {
        void onDismiss();
    }

    public class b extends android.support.v7.widget.RecyclerView.a<a> {
        OnItemClickListener SY;

        public class a extends t implements OnClickListener {
            ImageView jSg;
            TextView jtn;
            TextView roY;
            RadioButton zCH;
            ImageView zCI;
            LinearLayout zCJ;

            public a(View view) {
                super(view);
                view.setOnClickListener(this);
                this.jtn = (TextView) view.findViewById(e.title);
                this.jSg = (ImageView) view.findViewById(e.icon);
                this.zCJ = (LinearLayout) view.findViewById(e.cIB);
                if (g.this.zCo || g.this.zCp) {
                    this.roY = (TextView) view.findViewById(e.caR);
                    this.zCH = (RadioButton) view.findViewById(e.radio);
                    this.zCI = (ImageView) view.findViewById(e.divider);
                }
            }

            public final void onClick(View view) {
                if (b.this.SY != null) {
                    b.this.SY.onItemClick(null, view, getPosition(), (long) getPosition());
                }
            }
        }

        public final /* synthetic */ t a(ViewGroup viewGroup, int i) {
            View inflate = g.this.zCy == g.zCs ? LayoutInflater.from(g.this.mContext).inflate(f.zID, viewGroup, false) : g.this.zCy == g.zCu ? LayoutInflater.from(g.this.mContext).inflate(f.zIE, viewGroup, false) : LayoutInflater.from(g.this.mContext).inflate(f.zIF, viewGroup, false);
            return new a(inflate);
        }

        public final /* synthetic */ void a(t tVar, int i) {
            a aVar = (a) tVar;
            o oVar;
            if (i < g.this.rQH.size()) {
                if (g.this.zCD >= g.this.rQH.size()) {
                    g.this.zCD = 0;
                }
                oVar = (o) g.this.rQH.ykH.get(i);
                aVar.jtn.setText(oVar.getTitle());
                if (oVar.getIcon() != null) {
                    aVar.jSg.setVisibility(0);
                    aVar.jSg.setImageDrawable(oVar.getIcon());
                } else if (g.this.zux != null) {
                    aVar.jSg.setVisibility(0);
                    g.this.zux.a(aVar.jSg, oVar);
                } else if (g.this.zCB) {
                    aVar.jSg.setVisibility(4);
                } else {
                    aVar.jSg.setVisibility(8);
                }
                if (g.this.zuy != null) {
                    g.this.zuy.a(aVar.jtn, oVar);
                }
                if (oVar.wXJ) {
                    if (g.this.zCj.booleanValue()) {
                        aVar.jtn.setTextColor(g.this.mContext.getResources().getColor(com.tencent.mm.ca.a.b.bul));
                    } else {
                        aVar.jtn.setTextColor(g.this.mContext.getResources().getColor(com.tencent.mm.ca.a.b.zHS));
                    }
                    aVar.zCJ.setBackgroundResource(com.tencent.mm.ca.a.b.transparent);
                } else if (g.this.zCj.booleanValue()) {
                    aVar.jtn.setTextColor(g.this.mContext.getResources().getColor(com.tencent.mm.ca.a.b.buk));
                    aVar.zCJ.setBackgroundResource(com.tencent.mm.ca.a.d.zIl);
                } else {
                    aVar.jtn.setTextColor(g.this.mContext.getResources().getColor(com.tencent.mm.ca.a.b.iuW));
                    aVar.zCJ.setBackgroundResource(com.tencent.mm.ca.a.d.zIk);
                }
                if (aVar.roY != null) {
                    if (bi.N(oVar.qkf)) {
                        aVar.roY.setVisibility(8);
                    } else {
                        aVar.roY.setVisibility(0);
                        aVar.roY.setText(oVar.qkf);
                        aVar.roY.setMovementMethod(LinkMovementMethod.getInstance());
                    }
                }
                if (g.this.zCo) {
                    if (oVar.wXJ) {
                        aVar.zCH.setVisibility(8);
                        aVar.roY.setTextColor(g.this.mContext.getResources().getColor(com.tencent.mm.ca.a.b.zHS));
                    } else {
                        aVar.roY.setTextColor(g.this.mContext.getResources().getColor(com.tencent.mm.ca.a.b.zHT));
                        aVar.zCH.setVisibility(0);
                        if (g.this.zCD == i) {
                            aVar.zCH.setChecked(true);
                        } else {
                            aVar.zCH.setChecked(false);
                        }
                    }
                    aVar.zCI.setVisibility(0);
                }
            } else if (g.this.zCi.size() > 0 && i < g.this.rQH.size() + g.this.zCi.size()) {
                oVar = (o) g.this.zCi.ykH.get(i - g.this.rQH.size());
                aVar.jtn.setText(oVar.getTitle());
                if (g.this.zCD >= g.this.rQH.size() + g.this.zCi.size()) {
                    g.this.zCD = 0;
                }
                if (oVar.getIcon() != null) {
                    aVar.jSg.setVisibility(0);
                    aVar.jSg.setImageDrawable(oVar.getIcon());
                } else {
                    aVar.jSg.setVisibility(8);
                }
                if (oVar.wXJ) {
                    if (g.this.zCj.booleanValue()) {
                        aVar.jtn.setTextColor(g.this.mContext.getResources().getColor(com.tencent.mm.ca.a.b.bul));
                    } else {
                        aVar.jtn.setTextColor(g.this.mContext.getResources().getColor(com.tencent.mm.ca.a.b.zHS));
                    }
                    aVar.zCJ.setBackgroundResource(com.tencent.mm.ca.a.b.transparent);
                } else if (g.this.zCj.booleanValue()) {
                    aVar.jtn.setTextColor(g.this.mContext.getResources().getColor(com.tencent.mm.ca.a.b.buk));
                    aVar.zCJ.setBackgroundResource(com.tencent.mm.ca.a.d.zIl);
                } else {
                    aVar.jtn.setTextColor(g.this.mContext.getResources().getColor(com.tencent.mm.ca.a.b.iuW));
                    aVar.zCJ.setBackgroundResource(com.tencent.mm.ca.a.d.zIk);
                }
                if (aVar.roY != null) {
                    if (bi.N(oVar.qkf)) {
                        aVar.roY.setVisibility(8);
                    } else {
                        aVar.roY.setVisibility(0);
                        aVar.roY.setText(oVar.qkf);
                    }
                }
                if (g.this.zCo) {
                    if (oVar.wXJ) {
                        aVar.zCH.setVisibility(8);
                        aVar.roY.setTextColor(g.this.mContext.getResources().getColor(com.tencent.mm.ca.a.b.zHS));
                    } else {
                        aVar.roY.setTextColor(g.this.mContext.getResources().getColor(com.tencent.mm.ca.a.b.zHT));
                        aVar.zCH.setVisibility(0);
                        if (g.this.zCD == i) {
                            aVar.zCH.setChecked(true);
                        } else {
                            aVar.zCH.setChecked(false);
                        }
                    }
                    aVar.zCI.setVisibility(0);
                }
            } else if (g.this.zCn) {
                aVar.jtn.setText(h.dNm);
                aVar.jSg.setImageResource(com.tencent.mm.ca.a.g.zIK);
            }
        }

        public final int getItemCount() {
            if (g.this.zCn) {
                return (g.this.rQH.size() + g.this.zCi.size()) + 1;
            }
            return g.this.rQH.size() + g.this.zCi.size();
        }
    }

    public final void onGlobalLayout() {
        if (isShowing()) {
            View view = this.hH;
            if (view == null || !view.isShown()) {
                bxR();
            } else if (!isShowing()) {
            } else {
                if (this.tMG != baC() || this.zCq != getRotation()) {
                    bxR();
                }
            }
        }
    }

    @SuppressLint({"WrongConstant"})
    private int getRotation() {
        if (this.mContext instanceof Activity) {
            return ((Activity) this.mContext).getWindow().getWindowManager().getDefaultDisplay().getRotation();
        }
        return 0;
    }

    public g(Context context, int i, boolean z) {
        this.zCy = i;
        this.mContext = context;
        this.zCz = z;
        this.zCC = false;
        if (this.mContext instanceof Activity) {
            ViewGroup viewGroup = (ViewGroup) ((Activity) this.mContext).getWindow().getDecorView();
            if (viewGroup.getChildCount() > 0) {
                this.hH = viewGroup.getChildAt(0);
            } else {
                this.hH = viewGroup;
            }
        }
        ce(this.mContext);
    }

    public g(Context context, int i) {
        this.zCy = i;
        this.mContext = context;
        this.zCE = true;
        if (this.mContext instanceof Activity) {
            ViewGroup viewGroup = (ViewGroup) ((Activity) this.mContext).getWindow().getDecorView();
            if (viewGroup.getChildCount() > 0) {
                this.hH = viewGroup.getChildAt(0);
            } else {
                this.hH = viewGroup;
            }
        }
        ce(this.mContext);
    }

    private void ce(Context context) {
        int ab;
        this.rQH = new n();
        this.zCi = new n();
        if (this.zCE) {
            this.zCg = new a(context);
        } else {
            this.zCg = new android.support.design.widget.c(context);
        }
        this.lHV = View.inflate(context, f.zIC, null);
        this.zCk = (LinearLayout) this.lHV.findViewById(e.qHz);
        this.zCl = (LinearLayout) this.lHV.findViewById(e.zIm);
        this.zCr = (ImageView) this.lHV.findViewById(e.zIq);
        this.Va = (RecyclerView) this.lHV.findViewById(e.zIn);
        this.Va.Ub = true;
        this.tMG = baC();
        if (this.zCy == zCs) {
            if (this.tMG) {
                this.zCv = 7;
                this.zCw = this.zCv * 2;
                this.yQU = com.tencent.mm.bu.a.ab(this.mContext, com.tencent.mm.ca.a.c.zHY) + com.tencent.mm.bu.a.ab(this.mContext, com.tencent.mm.ca.a.c.bxC);
            } else {
                this.yQU = com.tencent.mm.bu.a.ab(this.mContext, com.tencent.mm.ca.a.c.zHX) + com.tencent.mm.bu.a.ab(this.mContext, com.tencent.mm.ca.a.c.bxC);
            }
            if (this.zCz) {
                this.yQU += com.tencent.mm.bu.a.ab(this.mContext, com.tencent.mm.ca.a.c.bxC);
            }
        } else if (this.zCy == zCu) {
            this.zCo = true;
            ab = com.tencent.mm.bu.a.ab(this.mContext, com.tencent.mm.ca.a.c.zIf);
            if (this.tMG) {
                this.zCx = 2;
                this.yQU = ((int) (((double) ab) * 2.5d)) + com.tencent.mm.bu.a.ab(this.mContext, com.tencent.mm.ca.a.c.zIe);
            } else {
                this.zCx = 3;
                this.yQU = ((int) (((double) ab) * 3.5d)) + com.tencent.mm.bu.a.ab(this.mContext, com.tencent.mm.ca.a.c.zIe);
            }
            if (this.zCz) {
                this.yQU += com.tencent.mm.bu.a.fromDPToPix(this.mContext, 88);
            }
        } else {
            this.zCp = true;
            ab = com.tencent.mm.bu.a.ab(this.mContext, com.tencent.mm.ca.a.c.zIg);
            if (this.tMG) {
                this.zCx = 4;
                this.yQU = ((int) (((double) ab) * 4.5d)) + com.tencent.mm.bu.a.ab(this.mContext, com.tencent.mm.ca.a.c.zIe);
            } else {
                this.zCx = 6;
                this.yQU = ((int) (((double) ab) * 6.5d)) + com.tencent.mm.bu.a.ab(this.mContext, com.tencent.mm.ca.a.c.zIe);
            }
            if (this.zCz) {
                this.yQU += com.tencent.mm.bu.a.ab(this.mContext, com.tencent.mm.ca.a.c.bxC);
            }
            if (this.zCE) {
                ab = com.tencent.mm.bu.a.fromDPToPix(this.mContext, 24);
                this.zCr.setPadding(ab, 0, ab, 0);
            }
        }
        if (this.zCz && this.zCr != null && this.zCC) {
            this.zCr.setVisibility(0);
        }
        if (this.zCy == zCs) {
            this.Va.a(new GridLayoutManager(this.mContext, this.zCv));
            int ab2 = com.tencent.mm.bu.a.ab(this.mContext, com.tencent.mm.ca.a.c.bxB);
            ab = com.tencent.mm.bu.a.ab(this.mContext, com.tencent.mm.ca.a.c.bxC);
            if (this.zCz) {
                ab = com.tencent.mm.bu.a.fromDPToPix(this.mContext, 0);
            }
            this.Va.setPadding(ab2, ab, ab2, 0);
        } else {
            this.Va.a(new LinearLayoutManager());
        }
        this.zCm = new b();
        this.zCm.SY = new OnItemClickListener() {
            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                o oVar = (o) g.this.rQH.ykH.get(i);
                if (oVar == null || !oVar.wXJ) {
                    if (i < g.this.rQH.size()) {
                        if (g.this.rQG != null) {
                            g.this.rQG.onMMMenuItemSelected(g.this.rQH.getItem(i), i);
                        }
                    } else if (g.this.zCi.size() > 0 && i < g.this.rQH.size() + g.this.zCi.size() && g.this.zCh != null) {
                        g.this.zCh.onMMMenuItemSelected(g.this.zCi.getItem(i - g.this.rQH.size()), i);
                    }
                    if (!g.this.pJJ) {
                        g.this.bxR();
                    }
                    g.this.zCA = true;
                    g.this.zCD = i;
                    g.this.zCm.UR.notifyChanged();
                }
            }
        };
        this.Va.a(this.zCm);
        this.Va.setOverScrollMode(1);
        this.zCg.setContentView(this.lHV);
        if (!this.zCE) {
            this.yQV = BottomSheetBehavior.i((View) this.lHV.getParent());
            this.yQV.q(this.yQU);
            this.yQV.fs = new android.support.design.widget.BottomSheetBehavior.a() {
                public final void u(int i) {
                }

                public final void e(float f) {
                    if (g.this.zCr != null && !g.this.zCC) {
                        if (g.this.Va.canScrollVertically(-1) && g.this.zCz && f != 0.0f) {
                            g.this.zCr.setVisibility(0);
                        } else {
                            g.this.zCr.setVisibility(4);
                        }
                    }
                }
            };
        }
        this.zCg.setOnDismissListener(new OnDismissListener() {
            public final void onDismiss(DialogInterface dialogInterface) {
                g.this.zCg = null;
            }
        });
    }

    public final void dO(View view) {
        if (view != null) {
            this.zCz = true;
            if (this.zCr != null) {
                this.zCr.setVisibility(0);
            }
            if (this.zCk != null) {
                this.zCk.setVisibility(0);
                this.zCk.removeAllViews();
                this.zCk.setGravity(17);
                this.zCk.addView(view, -1, -2);
            }
        }
    }

    public final void e(CharSequence charSequence, int i) {
        if (this.zCk != null && this.zCz) {
            this.zCk.setVisibility(0);
            this.zCk.removeAllViews();
            this.zCk.setGravity(i);
            View inflate = LayoutInflater.from(this.mContext).inflate(f.zIG, null);
            TextView textView = (TextView) inflate.findViewById(e.gYC);
            textView.setText(charSequence);
            textView.setGravity(i | 80);
            this.zCk.addView(inflate, -1, -2);
        }
    }

    public final void bUX() {
        this.tMG = baC();
        this.zCq = getRotation();
        if (this.rQF != null) {
            this.rQF.a(this.rQH);
        }
        if (this.zCg != null) {
            int ab;
            LayoutParams layoutParams = (LayoutParams) this.lHV.getLayoutParams();
            int size = this.rQH.size();
            if (this.zCn) {
                size++;
            } else if (this.zCi.size() > 0) {
                size += this.zCi.size();
            }
            if (this.zCE) {
                ab = com.tencent.mm.bu.a.ab(this.mContext, com.tencent.mm.ca.a.c.zIg);
                if (this.zCz) {
                    this.yQU = (((int) (((double) ab) * 4.5d)) + com.tencent.mm.bu.a.fromDPToPix(this.mContext, 132)) + com.tencent.mm.bu.a.ab(this.mContext, com.tencent.mm.ca.a.c.zIe);
                } else {
                    this.yQU = (int) (((double) ab) * 6.5d);
                }
            }
            if (this.zCy == zCs) {
                if (this.zCm.getItemCount() > this.zCw) {
                    layoutParams.height = this.yQU;
                }
            } else if (size > this.zCx) {
                layoutParams.height = this.yQU;
            }
            if (this.tMG && this.hH != null) {
                Rect rect = new Rect();
                this.hH.getWindowVisibleDisplayFrame(rect);
                if (this.zCE) {
                    layoutParams.width = (int) ((((float) rect.right) * 1.0f) / 2.0f);
                    layoutParams.height = rect.bottom;
                    if (this.zCz) {
                        ab = com.tencent.mm.bu.a.ab(this.mContext, com.tencent.mm.ca.a.c.zIg);
                        if (size <= this.zCx) {
                            size = layoutParams.height - (size * ab);
                        } else {
                            size = layoutParams.height - ((int) (((double) ((float) ab)) * (((double) this.zCx) + 0.5d)));
                            if (size > com.tencent.mm.bu.a.fromDPToPix(this.mContext, 150)) {
                                size -= ab;
                            }
                        }
                        if (this.zCk != null) {
                            this.zCk.setMinimumHeight(size);
                        }
                    }
                } else {
                    layoutParams.width = rect.right;
                }
            }
            this.lHV.setLayoutParams(layoutParams);
            if (!(this.zCi == null || this.zCm == null)) {
                this.zCm.UR.notifyChanged();
            }
            if (VERSION.SDK_INT >= 21) {
                this.zCg.getWindow().addFlags(Integer.MIN_VALUE);
            }
            if (this.tMH && VERSION.SDK_INT >= 23 && this.zCg != null) {
                this.zCg.getWindow().getDecorView().setSystemUiVisibility(9216);
                this.zCg.getWindow().setStatusBarColor(0);
            }
            if (this.tMI) {
                this.zCg.getWindow().addFlags(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
            }
            if (this.tMJ) {
                this.zCg.getWindow().setFlags(8, 8);
                this.zCg.getWindow().addFlags(131200);
                this.zCg.getWindow().getDecorView().setSystemUiVisibility(6);
            } else {
                this.zCg.getWindow().clearFlags(8);
                this.zCg.getWindow().clearFlags(WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT);
                this.zCg.getWindow().clearFlags(FileUtils.S_IWUSR);
                this.zCg.getWindow().getDecorView().setSystemUiVisibility(0);
            }
            if (this.yQV != null) {
                this.yQV.fj = false;
            }
            if (this.zCF != null) {
                this.zCg.setOnDismissListener(new OnDismissListener() {
                    public final void onDismiss(DialogInterface dialogInterface) {
                        if (!g.this.zCA) {
                            g.this.zCF.onDismiss();
                        }
                    }
                });
            }
            if (this.hH != null) {
                boolean z = this.Md == null;
                this.Md = this.hH.getViewTreeObserver();
                if (z) {
                    this.Md.addOnGlobalLayoutListener(this);
                }
            }
            this.zCg.show();
        }
    }

    public final void czC() {
        if (this.zCg != null) {
            if (!(this.zCi == null || this.zCm == null)) {
                this.zCm.UR.notifyChanged();
            }
            this.zCg.show();
        }
    }

    public final void bxR() {
        if (this.Md != null) {
            if (!this.Md.isAlive()) {
                this.Md = this.hH.getViewTreeObserver();
            }
            this.Md.removeGlobalOnLayoutListener(this);
            this.Md = null;
        }
        if (this.zCg != null) {
            if (this.yQV != null) {
                this.yQV.fj = true;
            }
            this.zCg.dismiss();
        }
    }

    public final boolean isShowing() {
        if (this.zCg == null || !this.zCg.isShowing()) {
            return false;
        }
        return true;
    }

    private boolean baC() {
        DisplayMetrics displayMetrics = this.mContext.getResources().getDisplayMetrics();
        if (displayMetrics.widthPixels > displayMetrics.heightPixels) {
            return true;
        }
        return false;
    }
}
