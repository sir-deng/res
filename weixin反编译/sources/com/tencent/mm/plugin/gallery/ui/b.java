package com.tencent.mm.plugin.gallery.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.gallery.model.GalleryItem.AlbumItem;
import com.tencent.mm.plugin.gallery.model.GalleryItem.ImageMediaItem;
import com.tencent.mm.plugin.gallery.model.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;

public final class b extends BaseAdapter {
    private Context mContext;
    private int mXj;
    ArrayList<AlbumItem> mYL;
    AlbumItem mYM;
    String mYN = "";
    private int mYO = 0;

    private static class a {
        public TextView ikM;
        public ImageView mDW;
        public ImageView mXK;
        public TextView mYP;
        public ImageView mYQ;

        private a() {
        }

        /* synthetic */ a(byte b) {
            this();
        }
    }

    public final /* synthetic */ Object getItem(int i) {
        return qO(i);
    }

    public b(Context context, int i) {
        this.mContext = context;
        this.mYL = new ArrayList();
        this.mXj = i;
        this.mYM = new AlbumItem("", 0);
        this.mYM.mWO = new ImageMediaItem();
        this.mYO = context.getResources().getDimensionPixelSize(R.f.bvT);
    }

    public final int getCount() {
        return this.mYL.size() + 1;
    }

    public final AlbumItem qO(int i) {
        if (i == 0) {
            return this.mYM;
        }
        return (AlbumItem) this.mYL.get(i - 1);
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        x.i("MicroMsg.GalleryAdapter", "duanyi test getview:" + i);
        AlbumItem qO = qO(i);
        if (view == null) {
            view = LayoutInflater.from(this.mContext).inflate(R.i.drv, viewGroup, false);
            a aVar2 = new a();
            aVar2.mXK = (ImageView) view.findViewById(R.h.ciU);
            aVar2.ikM = (TextView) view.findViewById(R.h.ciR);
            aVar2.mDW = (ImageView) view.findViewById(R.h.cVl);
            aVar2.mYP = (TextView) view.findViewById(R.h.ciQ);
            aVar2.mYQ = (ImageView) view.findViewById(R.h.ciT);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        if (this.mYN.equals(qO.mWN)) {
            aVar.mYQ.setVisibility(0);
        } else {
            aVar.mYQ.setVisibility(4);
        }
        if (i == 0) {
            aVar.mXK.setImageResource(R.g.bEG);
            if (qO.mWO != null) {
                h.a(aVar.mXK, qO.mWO.getType(), qO.aOC(), qO.mWO.hQc, qO.aOD());
            }
            if (c.aOl().aOP() == 1) {
                aVar.ikM.setText(R.l.eli);
            } else if (c.aOl().aOP() == 3) {
                aVar.ikM.setText(R.l.elj);
            } else {
                aVar.ikM.setText(R.l.elk);
            }
            aVar.mXK.setVisibility(0);
            aVar.ikM.setVisibility(0);
            aVar.mYP.setVisibility(8);
        } else {
            aVar.mXK.setVisibility(0);
            aVar.ikM.setVisibility(0);
            aVar.ikM.setText(qO.mWN);
            aVar.mYP.setVisibility(0);
            aVar.mYP.setText(this.mContext.getString(R.l.elr, new Object[]{Integer.valueOf(qO.fuA)}));
            if (!(aVar.mDW == null || qO.mWO == null)) {
                aVar.mDW.setVisibility(qO.mWO.getType() == 2 ? 0 : 8);
            }
            String aOC = qO.aOC();
            if (!bi.oN(aOC) && qO.mWO != null) {
                h.a(aVar.mXK, qO.mWO.getType(), aOC, qO.mWO.hQc, qO.aOD());
            } else if (qO.mWO == null || qO.mWO.getType() != 2) {
                x.e("MicroMsg.GalleryAdapter", "get folder failed");
                aVar.mXK.setVisibility(8);
                aVar.ikM.setVisibility(8);
            } else {
                h.a(aVar.mXK, qO.mWO.getType(), null, qO.mWO.hQc, qO.aOD());
            }
        }
        return view;
    }
}
