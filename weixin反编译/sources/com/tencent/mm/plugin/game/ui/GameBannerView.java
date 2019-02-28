package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.e;
import android.support.v4.view.u;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.mm.R;
import com.tencent.mm.plugin.game.d.c;
import com.tencent.mm.plugin.game.model.ap;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.MMDotView;
import com.tencent.mm.y.as;
import com.tencent.rtmp.TXLiveConstants;
import java.util.LinkedList;

public class GameBannerView extends LinearLayout implements e, OnClickListener {
    private float kHQ = 0.0f;
    private MMDotView kgN;
    private ViewPager lJI;
    private Context mContext;
    int niV = 0;
    private b nri;
    LinkedList<a> nrj;
    al nrk = new al(new com.tencent.mm.sdk.platformtools.al.a() {
        public final boolean uG() {
            if (GameBannerView.this.lJI == null || GameBannerView.this.nrj.size() <= 1) {
                GameBannerView.this.nrk.TN();
                return false;
            }
            GameBannerView.this.lJI.d(GameBannerView.this.lJI.yF + 1, true);
            return true;
        }
    }, true);
    private float nrl = 0.0f;

    public static class a {
        public String hlQ;
        public int index;
        public String ngB;
        public f nrn;
    }

    private final class b extends u {
        private b() {
        }

        /* synthetic */ b(GameBannerView gameBannerView, byte b) {
            this();
        }

        public final void a(ViewGroup viewGroup, int i, Object obj) {
            int size = i % GameBannerView.this.nrj.size();
            viewGroup.removeView((View) obj);
            x.i("MicroMsg.GameBannerView", "destroyItem : new positon = %d, now position = %d", Integer.valueOf(size), Integer.valueOf(i));
        }

        public final Object b(ViewGroup viewGroup, int i) {
            int size = i % GameBannerView.this.nrj.size();
            View inflate = View.inflate(GameBannerView.this.mContext, R.i.djx, null);
            inflate.setTag(GameBannerView.this.nrj.get(size));
            inflate.setOnClickListener(GameBannerView.this);
            ImageView imageView = (ImageView) inflate.findViewById(R.h.ckF);
            String str = ((a) GameBannerView.this.nrj.get(size)).hlQ;
            Drawable drawable = imageView.getDrawable();
            if (drawable == null || !(drawable instanceof k)) {
                imageView.setImageDrawable(new k(str, (byte) 0));
            } else {
                ((k) drawable).setUrl(str);
            }
            try {
                viewGroup.addView(inflate, 0);
            } catch (Exception e) {
                x.e("MicroMsg.GameBannerView", "add view failed, " + e.getMessage());
            }
            x.i("MicroMsg.GameBannerView", "instantiateItem : new positon = %d, now position = %d", Integer.valueOf(size), Integer.valueOf(i));
            return inflate;
        }

        public final int getCount() {
            return GameBannerView.this.nrj.size() <= 1 ? GameBannerView.this.nrj.size() : (GameBannerView.this.nrj.size() * 1000) * 2;
        }

        public final boolean a(View view, Object obj) {
            return view == obj;
        }
    }

    public GameBannerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        inflate(context, R.i.djw, this);
        this.nrj = new LinkedList();
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        this.kgN = (MMDotView) findViewById(R.h.ckD);
        this.lJI = (ViewPager) findViewById(R.h.ckE);
        this.lJI.zo = this;
        this.nri = new b();
    }

    public final void R(LinkedList<a> linkedList) {
        if (linkedList == null || linkedList.size() == 0) {
            x.e("MicroMsg.GameBannerView", "Empty banner list");
            setVisibility(8);
            return;
        }
        x.i("MicroMsg.GameBannerView", "bannerList size", Integer.valueOf(linkedList.size()));
        this.nrk.TN();
        this.nrj.clear();
        this.nrj.addAll(linkedList);
        this.lJI.a(this.nri);
        this.lJI.d(linkedList.size() * 1000, false);
        if (this.nrj.size() > 1) {
            this.nrk.K(5000, 5000);
        }
        this.kgN.setVisibility(8);
        setVisibility(0);
    }

    public final void af(int i) {
    }

    public final void a(int i, float f, int i2) {
    }

    public final void ae(int i) {
        int size = i % this.nrj.size();
        x.i("MicroMsg.GameBannerView", "now selected page %d, now exactly positon : %d", Integer.valueOf(i), Integer.valueOf(size));
        if (((a) this.nrj.get(size)).nrn != null && as.Hp()) {
            ap.a(this.mContext, 11, (int) TXLiveConstants.PUSH_WARNING_NET_BUSY, size + 1, 1, this.niV, null);
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        float rawX = motionEvent.getRawX();
        float rawY = motionEvent.getRawY();
        switch (action) {
            case 0:
                this.nrl = rawX;
                this.kHQ = rawY;
                break;
            case 1:
            case 3:
                fJ(false);
                this.nrl = 0.0f;
                this.kHQ = 0.0f;
                break;
            case 2:
                if (Math.abs((int) (rawX - this.nrl)) > Math.abs((int) (rawY - this.kHQ))) {
                    fJ(true);
                    break;
                }
                break;
        }
        switch (motionEvent.getAction()) {
            case 0:
                this.nrk.TN();
                break;
            case 1:
            case 3:
                this.nrk.K(5000, 5000);
                break;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    private void fJ(boolean z) {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(z);
        }
    }

    public void onClick(View view) {
        if (view.getTag() instanceof a) {
            a aVar = (a) view.getTag();
            f fVar = aVar.nrn;
            if (bi.oN(aVar.ngB)) {
                x.i("MicroMsg.GameBannerView", "null or nil url");
                Bundle bundle = new Bundle();
                bundle.putCharSequence("game_app_id", fVar.field_appId);
                bundle.putInt("game_report_from_scene", 5);
                ap.a(this.mContext, 11, (int) TXLiveConstants.PUSH_WARNING_NET_BUSY, 1, c.a(this.mContext, fVar.field_appId, null, bundle), this.niV, null);
                return;
            }
            ap.a(this.mContext, 11, (int) TXLiveConstants.PUSH_WARNING_NET_BUSY, 1, c.ac(this.mContext, aVar.ngB), this.niV, null);
        }
    }
}
