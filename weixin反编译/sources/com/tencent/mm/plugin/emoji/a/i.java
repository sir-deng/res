package com.tencent.mm.plugin.emoji.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mm.R;
import com.tencent.mm.ap.o;
import com.tencent.mm.plugin.emoji.e.f;
import com.tencent.mm.plugin.emoji.e.m;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.plugin.emoji.ui.EmojiStoreVpHeader;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.ui.emoji.StoreBannerEmojiView;
import com.tencent.mm.protocal.c.sx;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.base.y;
import java.util.ArrayList;
import java.util.LinkedList;

public final class i extends y implements OnClickListener {
    public static int lAc = 60;
    public LinkedList<com.tencent.mm.plugin.emoji.model.a> lAb;
    private int lAd = 0;
    public boolean lAe = false;
    public ArrayList<String> lAf = new ArrayList();
    private com.tencent.mm.ap.a.c.i lAg = new com.tencent.mm.ap.a.c.i() {
        public final void a(String str, Bitmap bitmap, Object... objArr) {
            x.i("MicroMsg.emoji.EmojiStoreVpHeaderAdapter", "onImageLoadComplete url:%s", str);
            i.this.mHandler.post(new Runnable() {
                public final void run() {
                    i.this.notifyDataSetChanged();
                }
            });
        }
    };
    private Context mContext;
    private ag mHandler = new ag();

    class a {
        StoreBannerEmojiView lAj;
        ImageView lAk;

        public a(View view) {
            this.lAj = (StoreBannerEmojiView) view.findViewById(R.h.cdp);
            this.lAk = (ImageView) view.findViewById(R.h.cAh);
        }
    }

    public i(Context context, LinkedList<com.tencent.mm.plugin.emoji.model.a> linkedList) {
        if (linkedList == null) {
            throw new IllegalAccessError("must has emoji banner list");
        }
        this.mContext = context;
        this.lAb = new LinkedList();
        this.lAb.addAll(linkedList);
    }

    public final void I(LinkedList<com.tencent.mm.plugin.emoji.model.a> linkedList) {
        this.lAb.clear();
        this.lAb.addAll(linkedList);
        notifyDataSetChanged();
    }

    public final int getCount() {
        if (this.lAb == null) {
            return 0;
        }
        return this.lAb.size() != 1 ? this.lAb.size() * lAc : 1;
    }

    public final void notifyDataSetChanged() {
        if (this.lAe) {
            x.i("MicroMsg.emoji.EmojiStoreVpHeaderAdapter", "has destroy need to notify");
            return;
        }
        this.lAd = getCount();
        super.notifyDataSetChanged();
    }

    public final int k(Object obj) {
        if (this.lAd <= 0) {
            return super.k(obj);
        }
        this.lAd--;
        return -2;
    }

    public final View d(int i, View view) {
        if (this.lAb == null) {
            return null;
        }
        a aVar;
        int size = i % this.lAb.size();
        a aVar2;
        if (view == null) {
            x.i("MicroMsg.emoji.EmojiStoreVpHeaderAdapter", "getView inflate");
            view = View.inflate(this.mContext, R.i.dgo, null);
            aVar2 = new a(view);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar2 = (a) view.getTag();
            int i2 = EmojiStoreVpHeader.aT(this.mContext)[0];
            aVar2.lAj.setLayoutParams(new LayoutParams(i2, ((i2 * 3) / 8) + 1));
            aVar = aVar2;
        }
        view.setTag(R.h.cdA, Integer.valueOf(size));
        view.setOnClickListener(this);
        com.tencent.mm.plugin.emoji.model.a aVar3 = (com.tencent.mm.plugin.emoji.model.a) this.lAb.get(size);
        if (aVar3 == null) {
            x.e("MicroMsg.emoji.EmojiStoreVpHeaderAdapter", "BaseEmotionBanner is null.");
            return null;
        }
        String str;
        String str2;
        if (aVar3.lCY) {
            str = aVar3.lCW.whk.whl;
            if (bi.oN(aVar3.lCW.whm)) {
                str2 = "H5";
            } else {
                str2 = "Toptic";
            }
        } else {
            str = aVar3.lCX.whk.whl;
            str2 = aVar3.lCX.whj.vPI;
        }
        if (!(aVar3 == null || bi.oN(str))) {
            com.tencent.mm.bu.a.getDensity(this.mContext);
            EmojiInfo a = EmojiLogic.a(str2, 8, str, true);
            if (a != null) {
                aVar.lAj.cY(a.clq(), null);
            } else if (this.lAf.contains(str)) {
                x.i("MicroMsg.emoji.EmojiStoreVpHeaderAdapter", "url has add to list. no need to try load image.");
                aVar.lAj.cY("-", null);
            } else {
                o.PG().a(str, null, f.c(str2, str, str2, "BANNER"), this.lAg);
                this.lAf.add(str);
            }
        }
        x.d("MicroMsg.emoji.EmojiStoreVpHeaderAdapter", "position:%d allPostion:%d banner url:%s ", Integer.valueOf(size), Integer.valueOf(i), str);
        return view;
    }

    public final void onClick(View view) {
        com.tencent.mm.plugin.emoji.model.a aVar = (com.tencent.mm.plugin.emoji.model.a) this.lAb.get(((Integer) view.getTag(R.h.cdA)).intValue());
        if (aVar == null) {
            return;
        }
        if (aVar.lCY) {
            m.a(this.mContext, aVar.lCW, true);
            return;
        }
        sx sxVar = aVar.lCX.whj;
        if (sxVar != null) {
            String str = "MicroMsg.emoji.EmojiStoreVpHeaderAdapter";
            String str2 = "productId %s";
            Object[] objArr = new Object[1];
            objArr[0] = sxVar == null ? "" : sxVar.vPI;
            x.d(str, str2, objArr);
            g.pWK.h(11929, Integer.valueOf(0));
            m.a(this.mContext, sxVar, 15, -1, -1, "", 8);
        }
    }
}
