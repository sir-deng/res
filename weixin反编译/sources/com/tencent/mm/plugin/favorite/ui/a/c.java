package com.tencent.mm.plugin.favorite.ui.a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.favorite.h;
import com.tencent.mm.plugin.favorite.ui.base.FavTagPanel;
import com.tencent.mm.protocal.c.vx;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public abstract class c extends BaseAdapter implements com.tencent.mm.plugin.favorite.a.f.a, com.tencent.mm.ui.base.MMTagPanel.a {
    private Context context;
    private int mAm = R.e.btv;
    private int mAn = R.g.bCe;
    private Set<String> mAo = new HashSet();

    public static class a {
        TextView kKK;
        FavTagPanel mAp;
    }

    public abstract void AR(String str);

    public abstract void AS(String str);

    public /* synthetic */ Object getItem(int i) {
        return h.aIX().qa(i);
    }

    public c(Context context) {
        this.context = context;
    }

    public int getCount() {
        h.aIX();
        return 1;
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            view = View.inflate(this.context, R.i.dhU, null);
            a aVar2 = new a();
            aVar2.kKK = (TextView) view.findViewById(R.h.cgU);
            aVar2.mAp = (FavTagPanel) view.findViewById(R.h.chn);
            aVar2.mAp.ymq = this;
            aVar2.mAp.mAn = this.mAn;
            aVar2.mAp.mAm = this.mAm;
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        FavTagPanel favTagPanel = aVar.mAp;
        Collection collection = this.mAo;
        List<vx> qa = h.aIX().qa(i);
        if (qa == null || qa.isEmpty()) {
            boolean z;
            String str = "MicroMsg.FavTagPanel";
            String str2 = "setTagListByTagInfo,null == tags ?%B,";
            Object[] objArr = new Object[1];
            if (qa == null) {
                z = true;
            } else {
                z = false;
            }
            objArr[0] = Boolean.valueOf(z);
            x.e(str, str2, objArr);
        } else {
            x.i("MicroMsg.FavTagPanel", "setTagListByTagInfo,tags.size = %d", Integer.valueOf(qa.size()));
            List linkedList = new LinkedList();
            for (vx vxVar : qa) {
                linkedList.add(vxVar.tIP);
            }
            favTagPanel.a(collection, linkedList);
        }
        return view;
    }

    public final void zq(String str) {
    }

    public final void zr(String str) {
    }

    public final void zs(String str) {
    }

    public final void aEg() {
    }

    public final void AT(String str) {
        this.mAo.add(str);
        notifyDataSetChanged();
    }

    public final void AU(String str) {
        this.mAo.remove(str);
        notifyDataSetChanged();
    }

    public final void aO(List<String> list) {
        this.mAo.clear();
        if (list != null) {
            this.mAo.addAll(list);
        }
    }

    public final void zp(String str) {
        AT(str);
        AR(str);
    }

    public final void zo(String str) {
        AU(str);
        AS(str);
    }

    public final void aJf() {
        x.d("MicroMsg.FavoriteTagPanelAdapter", "on addtag callback");
        notifyDataSetChanged();
    }

    public final void aJg() {
        x.d("MicroMsg.FavoriteTagPanelAdapter", "on removetag callback");
        notifyDataSetChanged();
    }

    public final void j(boolean z, int i) {
    }
}
