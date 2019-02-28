package com.tencent.mm.plugin.scanner.ui;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.e;
import android.support.v4.view.u;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.mm.R;
import com.tencent.mm.platformtools.j;
import com.tencent.mm.plugin.scanner.a.i;
import com.tencent.mm.plugin.scanner.util.n.a.a.b;
import com.tencent.mm.plugin.scanner.util.o;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.MMPageControlView;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.h.d;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class ProductFurtherInfoUI extends MMPreference {
    protected f jPY;
    private MMPageControlView qbv;
    private com.tencent.mm.plugin.scanner.util.n.a.a qbw;
    private String qbx;
    private ViewPager xS;

    class a extends u implements com.tencent.mm.platformtools.j.a {
        private Context mContext;
        List<String> qbA = new ArrayList();
        private Map<String, ImageView> qbB = new HashMap();
        private int qbC;

        public a(Context context) {
            this.mContext = context;
            j.a((com.tencent.mm.platformtools.j.a) this);
            this.qbC = this.mContext.getResources().getColor(R.e.bsP);
        }

        private ImageView Jj(String str) {
            if (this.qbB.containsKey(str)) {
                return (ImageView) this.qbB.get(str);
            }
            ImageView imageView = new ImageView(this.mContext);
            imageView.setScaleType(ScaleType.FIT_XY);
            imageView.setLayoutParams(new LayoutParams(-1, -1));
            this.qbB.put(str, imageView);
            return imageView;
        }

        public final Object b(ViewGroup viewGroup, int i) {
            String str = (String) this.qbA.get(i);
            View Jj = Jj(str);
            Bitmap a = j.a(new o(str));
            if (a == null || a.isRecycled()) {
                Jj.setImageBitmap(null);
                Jj.setBackgroundColor(this.qbC);
            } else {
                Jj.setImageBitmap(a);
                Jj.setBackgroundColor(0);
            }
            try {
                viewGroup.addView(Jj);
            } catch (Exception e) {
                x.e("MicroMsg.ProductFurtherInfoUI", "Add view failed: " + e.getMessage());
            }
            return Jj;
        }

        public final void a(ViewGroup viewGroup, int i, Object obj) {
            viewGroup.removeView((ImageView) obj);
            String str = (String) this.qbA.get(i);
            if (this.qbB.containsKey(str)) {
                this.qbB.remove(str);
            }
        }

        public final int getCount() {
            return this.qbA.size();
        }

        public final boolean a(View view, Object obj) {
            return view == obj;
        }

        public final void l(String str, final Bitmap bitmap) {
            if (bitmap != null && !bitmap.isRecycled() && !bi.oN(str)) {
                final ImageView Jj = Jj(str);
                if (Jj != null) {
                    ah.y(new Runnable() {
                        public final void run() {
                            Jj.setImageBitmap(bitmap);
                            Jj.setBackgroundColor(0);
                        }
                    });
                }
            }
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        com.tencent.mm.plugin.scanner.util.n.a bZ = i.bZ(getIntent().getStringExtra("key_Product_xml"), getIntent().getIntExtra("key_Product_funcType", 0));
        if (bZ == null || bZ.qhb == null) {
            x.e("MicroMsg.ProductFurtherInfoUI", "initView(), product or product field detail null -> finish");
            finish();
            return;
        }
        this.qbw = bZ.qhb;
        this.qbx = bZ.field_feedbackurl;
        initView();
    }

    protected final void initView() {
        int i = 0;
        setMMTitle(getIntent().getStringExtra("key_title"));
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                ProductFurtherInfoUI.this.finish();
                return false;
            }
        });
        addIconOptionMenu(0, R.g.bDJ, new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                List linkedList = new LinkedList();
                List linkedList2 = new LinkedList();
                linkedList.add(ProductFurtherInfoUI.this.getString(R.l.eIm));
                linkedList2.add(Integer.valueOf(0));
                h.a(ProductFurtherInfoUI.this.mController.xRr, "", linkedList, linkedList2, "", false, new d() {
                    public final void cr(int i, int i2) {
                        switch (i2) {
                            case 0:
                                if (!bi.oN(ProductFurtherInfoUI.this.qbx)) {
                                    Intent intent = new Intent();
                                    intent.putExtra("rawUrl", ProductFurtherInfoUI.this.qbx);
                                    com.tencent.mm.bl.d.b(ProductFurtherInfoUI.this.mController.xRr, "webview", ".ui.tools.WebViewUI", intent);
                                    return;
                                }
                                return;
                            default:
                                return;
                        }
                    }
                });
                return true;
            }
        });
        this.jPY = this.yrJ;
        List arrayList = new ArrayList();
        Iterator it = this.qbw.qhc.iterator();
        while (it.hasNext()) {
            arrayList.add(((com.tencent.mm.plugin.scanner.util.n.a.a.a) it.next()).hPT);
        }
        this.xS = (ViewPager) findViewById(R.h.cCs);
        this.qbv = (MMPageControlView) findViewById(R.h.cpN);
        this.qbv.ykM = R.i.dps;
        this.qbv.setVisibility(0);
        this.xS.setOnTouchListener(new OnTouchListener() {
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                if (!(view == null || view.getParent() == null)) {
                    view.getParent().requestDisallowInterceptTouchEvent(true);
                }
                return false;
            }
        });
        this.xS.zo = new e() {
            public final void a(int i, float f, int i2) {
            }

            public final void ae(int i) {
                if (ProductFurtherInfoUI.this.xS.getParent() != null) {
                    ProductFurtherInfoUI.this.xS.getParent().requestDisallowInterceptTouchEvent(true);
                }
                ProductFurtherInfoUI.this.qbv.xs(i);
            }

            public final void af(int i) {
            }
        };
        u aVar = new a(this);
        this.xS.a(aVar);
        if (arrayList.size() > 0) {
            aVar.qbA = arrayList;
            aVar.qby.qbv.eU(arrayList.size(), 0);
            aVar.notifyDataSetChanged();
            this.xS.setVisibility(0);
        }
        while (i < this.qbw.qhd.size()) {
            b bVar = (b) this.qbw.qhd.get(i);
            Preference preference = new Preference(this);
            preference.setKey(String.valueOf(i));
            preference.setLayoutResource(R.i.doB);
            preference.setTitle(bVar.title);
            preference.setSummary(bVar.desc);
            this.jPY.a(preference);
            i++;
        }
        this.jPY.notifyDataSetChanged();
    }

    public final int XK() {
        return R.o.dpH;
    }

    protected final int getLayoutId() {
        return R.i.dpH;
    }

    public final int atg() {
        return R.i.dpI;
    }

    public final boolean a(f fVar, Preference preference) {
        return false;
    }
}
