package com.tencent.mm.plugin.sns.ui.previewimageview;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.plugin.sns.i.d;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.i;
import com.tencent.mm.plugin.sns.ui.w;
import com.tencent.mm.plugin.sns.ui.w.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;
import java.util.List;

public final class e implements w {
    private Context context;
    private ImageView rKw;
    Rect rWA;
    private boolean rWs;
    c rWt;
    DynamicGridView rWu;
    a rWv;
    float rWw;
    View rWx;
    ImageView rWy;
    private View rWz;
    TextView rzk;

    static /* synthetic */ void a(e eVar) {
        eVar.rWz.setVisibility(8);
        ad.cgg().edit().putBoolean("key_show_tips", false).commit();
    }

    static /* synthetic */ void b(e eVar) {
        eVar.rWx.setBackgroundColor(Color.parseColor("#e64340"));
        eVar.rWy.setImageResource(i.qPd);
        eVar.rzk.setText("拖动到此处删除");
    }

    public e(final View view, View view2, View view3, final Context context, List<String> list, final DynamicGridView dynamicGridView, a aVar, c.a aVar2, boolean z) {
        this.rWs = z;
        this.context = context;
        this.rWv = aVar;
        this.rWx = view2;
        this.rWz = view3;
        this.rWu = dynamicGridView;
        this.rWy = (ImageView) view2.findViewById(f.qHR);
        this.rzk = (TextView) view2.findViewById(f.qHT);
        dynamicGridView.setColumnWidth(context.getResources().getDimensionPixelSize(d.qES) + (context.getResources().getDimensionPixelSize(d.qER) * 2));
        dynamicGridView.setNumColumns(4);
        dynamicGridView.setOverScrollMode(2);
        dynamicGridView.setStretchMode(0);
        dynamicGridView.setClipChildren(false);
        dynamicGridView.setClipToPadding(false);
        dynamicGridView.setSelector(new ColorDrawable(0));
        this.rWt = new c(context, list, 9, z, aVar2);
        bDb();
        dynamicGridView.setAdapter(this.rWt);
        dynamicGridView.rXb = new com.tencent.mm.plugin.sns.ui.previewimageview.DynamicGridView.e() {
            public final void yl(int i) {
                x.i("DynamicGrid", "drag started at position " + i);
                if (VERSION.SDK_INT >= 21) {
                    e.this.rWw = dynamicGridView.getElevation();
                    dynamicGridView.setElevation(100.0f);
                } else {
                    dynamicGridView.bringToFront();
                }
                e eVar = e.this;
                eVar.rWx.setVisibility(0);
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(eVar.rWx, "translationY", new float[]{(float) eVar.rWx.getHeight(), 0.0f});
                ofFloat.setDuration(200);
                ofFloat.start();
                e.a(e.this);
            }

            public final void ym(int i) {
                x.i("DynamicGrid", "drag to del " + i);
                a aVar = e.this.rWt;
                Object item = aVar.getItem(i);
                aVar.ep.remove(item);
                aVar.rWl.remove(item);
                aVar.notifyDataSetChanged();
                if (aVar.rWq != null) {
                    aVar.rWq.removeItem(i - aVar.rWm);
                }
            }

            public final void j(Rect rect) {
                if (k(rect)) {
                    e eVar = e.this;
                    eVar.rWx.setBackgroundColor(Color.parseColor("#ce3c39"));
                    eVar.rWy.setImageResource(i.qPe);
                    eVar.rzk.setText("松手即可删除");
                    return;
                }
                e.b(e.this);
            }

            public final void bDc() {
                e eVar = e.this;
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(eVar.rWx, "translationY", new float[]{0.0f, (float) eVar.rWx.getHeight()});
                ofFloat.setDuration(200);
                ofFloat.addListener(new AnimatorListener() {
                    public final void onAnimationStart(Animator animator) {
                        e.b(e.this);
                    }

                    public final void onAnimationEnd(Animator animator) {
                        e.this.rWx.setVisibility(4);
                        e.this.rWx.setTranslationY(0.0f);
                    }

                    public final void onAnimationCancel(Animator animator) {
                        e.this.rWx.setVisibility(4);
                        e.this.rWx.setTranslationY(0.0f);
                    }

                    public final void onAnimationRepeat(Animator animator) {
                    }
                });
                ofFloat.start();
                e.this.rWt.bCZ();
            }

            public final boolean k(Rect rect) {
                e eVar = e.this;
                if (rect == null) {
                    return false;
                }
                if (eVar.rWA == null) {
                    eVar.rWA = new Rect(eVar.rWx.getLeft(), eVar.rWx.getTop(), eVar.rWx.getRight(), eVar.rWx.getBottom());
                }
                x.d("DynamicGrid", "del area " + eVar.rWA + ", test rect " + rect);
                return eVar.rWA.intersects(rect.left, rect.top, rect.right, rect.bottom);
            }
        };
        dynamicGridView.setOnItemLongClickListener(new OnItemLongClickListener() {
            public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                return true;
            }
        });
        dynamicGridView.setOnItemClickListener(new OnItemClickListener() {
            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (e.this.rWv != null && view.getTag() != null) {
                    int intValue = ((Integer) view.getTag()).intValue();
                    x.i("DynamicGrid", "click " + intValue);
                    if (intValue != Integer.MAX_VALUE) {
                        e.this.rWv.xK(intValue);
                    }
                }
            }
        });
        dynamicGridView.rXa = new DynamicGridView.f() {
            public final void bDd() {
                DynamicGridView dynamicGridView = dynamicGridView;
                dynamicGridView.maC = false;
                dynamicGridView.requestDisallowInterceptTouchEvent(false);
                if (DynamicGridView.bDi() && dynamicGridView.rWX) {
                    dynamicGridView.iU(true);
                }
                if (VERSION.SDK_INT >= 21) {
                    dynamicGridView.setElevation(e.this.rWw);
                } else {
                    view.bringToFront();
                }
            }
        };
        dynamicGridView.getViewTreeObserver().addOnPreDrawListener(new OnPreDrawListener() {
            public final boolean onPreDraw() {
                dynamicGridView.getViewTreeObserver().removeOnPreDrawListener(this);
                MarginLayoutParams marginLayoutParams = (MarginLayoutParams) dynamicGridView.getLayoutParams();
                marginLayoutParams.setMargins(marginLayoutParams.leftMargin, view.getHeight() - (context.getResources().getDimensionPixelSize(d.qEQ) + (context.getResources().getDimensionPixelSize(d.qER) * 2)), marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin);
                dynamicGridView.setLayoutParams(marginLayoutParams);
                return true;
            }
        });
    }

    private void bDb() {
        if (!ad.cgg().getBoolean("key_show_tips", true) || this.rWt.bDa() <= 1) {
            this.rWz.setVisibility(8);
            return;
        }
        this.rWz.setVisibility(0);
        this.rKw = (ImageView) this.rWz.findViewById(f.qKA);
        this.rKw.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                e.a(e.this);
            }
        });
    }

    public final void bAc() {
        this.rWs = false;
    }

    public final void a(a aVar) {
        this.rWv = aVar;
    }

    public final View getView() {
        return this.rWu;
    }

    public final void bW(List<String> list) {
        if (this.rWt != null) {
            this.rWt.cb(list);
            bDb();
        }
    }

    public final void clean() {
        if (this.rWu != null && this.rWu.getAdapter() == null) {
            ((c) this.rWu.getAdapter()).rCb = true;
        }
    }
}
