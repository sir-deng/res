package com.tencent.mm.plugin.readerapp.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.View.OnCreateContextMenuListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.platformtools.j;
import com.tencent.mm.pluginsdk.model.t;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.ui.base.p.d;
import com.tencent.mm.ui.tools.l;
import com.tencent.mm.ui.v;
import com.tencent.mm.y.bg;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import java.util.ArrayList;
import java.util.List;
import junit.framework.Assert;

public class ReaderItemListView extends ListView {
    private Context context;
    private LayoutInflater ntf;
    d otp;
    List<bg> pHe = new ArrayList();
    a pHf;
    OnCreateContextMenuListener pHg;
    private DisplayMetrics pHh;
    int position = 0;
    int type = 0;

    class a extends BaseAdapter {

        class a {
            ImageView jSg;
            TextView jSh;
            TextView jtn;
            ProgressBar lFV;
            ImageView pGR;
            View pGW;
            TextView pHl;
            ProgressBar pHm;

            a() {
            }
        }

        a() {
        }

        public final int getCount() {
            return ReaderItemListView.this.pHe.size();
        }

        public final Object getItem(int i) {
            return ReaderItemListView.this.pHe.get(i);
        }

        public final long getItemId(int i) {
            return 0;
        }

        public final int getItemViewType(int i) {
            if (((bg) ReaderItemListView.this.pHe.get(i)).type == 20) {
                if (i != 0) {
                    return 1;
                }
                String HR = ((bg) ReaderItemListView.this.pHe.get(i)).HR();
                String HS = ((bg) ReaderItemListView.this.pHe.get(i)).HS();
                if (bi.oN(HR)) {
                    if (bi.oN(HS)) {
                        return 1;
                    }
                    return 2;
                } else if (bi.oN(HS)) {
                    return 3;
                } else {
                    return 0;
                }
            } else if (i == 0) {
                if (getCount() == 1) {
                    return 8;
                }
                return 6;
            } else if (i == getCount() - 1) {
                return 7;
            } else {
                return 5;
            }
        }

        public final int getViewTypeCount() {
            return 9;
        }

        public final View getView(final int i, View view, ViewGroup viewGroup) {
            a aVar;
            boolean z;
            Bitmap a;
            boolean z2 = true;
            ViewGroup viewGroup2 = null;
            int itemViewType = getItemViewType(i);
            if (view == null) {
                switch (itemViewType) {
                    case 0:
                    case 3:
                        aVar = new a();
                        view = ReaderItemListView.this.ntf.inflate(R.i.dqi, null);
                        aVar.jtn = (TextView) view.findViewById(R.h.cFN);
                        aVar.pGR = (ImageView) view.findViewById(R.h.cFH);
                        aVar.lFV = (ProgressBar) view.findViewById(R.h.cFI);
                        view.setTag(aVar);
                        break;
                    case 1:
                        aVar = new a();
                        view = ReaderItemListView.this.ntf.inflate(R.i.dql, null);
                        aVar.jtn = (TextView) view.findViewById(R.h.cFP);
                        view.setTag(aVar);
                        break;
                    case 2:
                        aVar = new a();
                        view = ReaderItemListView.this.ntf.inflate(R.i.dqj, null);
                        aVar.jtn = (TextView) view.findViewById(R.h.cFN);
                        aVar.pHl = (TextView) view.findViewById(R.h.cFJ);
                        view.setTag(aVar);
                        break;
                    case 4:
                        aVar = new a();
                        view = ReaderItemListView.this.ntf.inflate(R.i.dqo, null);
                        aVar.jtn = (TextView) view.findViewById(R.h.cFN);
                        aVar.pGR = (ImageView) view.findViewById(R.h.cFH);
                        aVar.lFV = (ProgressBar) view.findViewById(R.h.cFI);
                        aVar.jSh = (TextView) view.findViewById(R.h.cFM);
                        aVar.jSg = (ImageView) view.findViewById(R.h.cFK);
                        aVar.pHm = (ProgressBar) view.findViewById(R.h.cFL);
                        aVar.pGW = view.findViewById(R.h.cFG);
                        aVar.pGW.setBackgroundResource(R.g.bBm);
                        view.setTag(aVar);
                        break;
                    case 5:
                        aVar = new a();
                        view = ReaderItemListView.this.ntf.inflate(R.i.dqp, null);
                        aVar.jtn = (TextView) view.findViewById(R.h.cFN);
                        aVar.jSh = (TextView) view.findViewById(R.h.cFM);
                        aVar.jSg = (ImageView) view.findViewById(R.h.cFK);
                        aVar.pHm = (ProgressBar) view.findViewById(R.h.cFL);
                        aVar.pGW = view.findViewById(R.h.cFG);
                        aVar.pGW.setBackgroundResource(R.g.bBl);
                        view.setTag(aVar);
                        break;
                    case 6:
                        aVar = new a();
                        view = ReaderItemListView.this.ntf.inflate(R.i.dqr, null);
                        aVar.jtn = (TextView) view.findViewById(R.h.cFN);
                        aVar.jSh = (TextView) view.findViewById(R.h.cFM);
                        aVar.jSg = (ImageView) view.findViewById(R.h.cFK);
                        aVar.pHm = (ProgressBar) view.findViewById(R.h.cFL);
                        aVar.pGW = view.findViewById(R.h.cFG);
                        aVar.pGW.setBackgroundResource(R.g.bBm);
                        view.setTag(aVar);
                        break;
                    case 7:
                        aVar = new a();
                        view = ReaderItemListView.this.ntf.inflate(R.i.dqq, null);
                        aVar.jtn = (TextView) view.findViewById(R.h.cFN);
                        aVar.jSh = (TextView) view.findViewById(R.h.cFM);
                        aVar.jSg = (ImageView) view.findViewById(R.h.cFK);
                        aVar.pHm = (ProgressBar) view.findViewById(R.h.cFL);
                        aVar.pGW = view.findViewById(R.h.cFG);
                        aVar.pGW.setBackgroundResource(R.g.bBk);
                        view.setTag(aVar);
                        Object viewGroup22 = aVar;
                        break;
                    case 8:
                        aVar = new a();
                        view = ReaderItemListView.this.ntf.inflate(R.i.dqp, null);
                        aVar.jtn = (TextView) view.findViewById(R.h.cFN);
                        aVar.jSh = (TextView) view.findViewById(R.h.cFM);
                        aVar.jSg = (ImageView) view.findViewById(R.h.cFK);
                        aVar.pHm = (ProgressBar) view.findViewById(R.h.cFL);
                        aVar.pGW = view.findViewById(R.h.cFG);
                        aVar.pGW.setBackgroundResource(R.g.bBn);
                        view.setTag(aVar);
                        break;
                }
                aVar = viewGroup22;
            } else {
                aVar = (a) view.getTag();
            }
            if (aVar != null) {
                z = true;
            } else {
                z = false;
            }
            Assert.assertTrue(z);
            if (aVar.jtn == null) {
                z2 = false;
            }
            Assert.assertTrue(z2);
            aVar.jtn.setText(((bg) ReaderItemListView.this.pHe.get(i)).getTitle().trim());
            if (aVar.pHl != null) {
                aVar.pHl.setText(((bg) ReaderItemListView.this.pHe.get(i)).HS().trim());
            }
            if (aVar.jSh != null) {
                aVar.jSh.setText(((bg) ReaderItemListView.this.pHe.get(i)).HP().trim() + ReaderItemListView.this.getContext().getString(R.l.eCk));
            }
            if (aVar.jSg != null) {
                a = j.a(new t(((bg) ReaderItemListView.this.pHe.get(i)).HQ(), ((bg) ReaderItemListView.this.pHe.get(i)).type, "@S", false));
                if (a != null) {
                    aVar.jSg.setImageBitmap(a);
                    aVar.jSg.setVisibility(0);
                    aVar.pHm.setVisibility(8);
                } else {
                    aVar.pHm.setVisibility(0);
                    aVar.jSg.setVisibility(8);
                }
            }
            if (aVar.pGR != null) {
                a = j.a(new t(((bg) ReaderItemListView.this.pHe.get(i)).HR(), ((bg) ReaderItemListView.this.pHe.get(i)).type, "@T", false));
                if (a != null) {
                    aVar.pGR.setImageBitmap(a);
                    aVar.pGR.setVisibility(0);
                    aVar.lFV.setVisibility(8);
                } else {
                    aVar.lFV.setVisibility(0);
                    aVar.pGR.setVisibility(8);
                }
            }
            if (!(aVar.pGW == null || ReaderItemListView.this.pHg == null)) {
                aVar.pGW.setTag(Integer.valueOf(ReaderItemListView.this.position));
                aVar.pGW.setOnLongClickListener(new OnLongClickListener() {
                    public final boolean onLongClick(View view) {
                        new l(ReaderItemListView.this.getContext()).b(view, ReaderItemListView.this.pHg, ReaderItemListView.this.otp);
                        return true;
                    }
                });
                aVar.pGW.setOnClickListener(new OnClickListener() {
                    public final void onClick(View view) {
                        int i = i;
                        Intent intent = new Intent();
                        intent.putExtra("mode", 1);
                        String url = ((bg) ReaderItemListView.this.pHe.get(i)).getUrl();
                        if (url.contains("?")) {
                            url = url + "&dt=2&cv=0x" + Integer.toHexString(com.tencent.mm.protocal.d.vHl) + "&w=" + ReaderItemListView.this.pHh.widthPixels;
                        } else {
                            url = url + "?dt=2&cv=0x" + Integer.toHexString(com.tencent.mm.protocal.d.vHl) + "&w=" + ReaderItemListView.this.pHh.widthPixels;
                        }
                        intent.putExtra("rawUrl", url);
                        intent.putExtra("webpageTitle", ((bg) ReaderItemListView.this.pHe.get(i)).getTitle());
                        intent.putExtra("title", ReaderItemListView.this.context.getString(R.l.eoY));
                        intent.putExtra("useJs", true);
                        intent.putExtra("vertical_scroll", true);
                        Bundle bundle = new Bundle();
                        if (((bg) ReaderItemListView.this.pHe.get(i)).type == 20) {
                            bundle.putInt("snsWebSource", 3);
                        } else {
                            bundle.putInt("snsWebSource", 2);
                        }
                        intent.putExtra("jsapiargs", bundle);
                        intent.putExtra("shortUrl", ((bg) ReaderItemListView.this.pHe.get(i)).HO());
                        intent.putExtra(Columns.TYPE, ((bg) ReaderItemListView.this.pHe.get(i)).type);
                        intent.putExtra("tweetid", ((bg) ReaderItemListView.this.pHe.get(i)).HN());
                        intent.putExtra("geta8key_username", "blogapp");
                        com.tencent.mm.plugin.readerapp.a.a.ihN.j(intent, ReaderItemListView.this.context);
                    }
                });
            }
            return view;
        }
    }

    public ReaderItemListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    public ReaderItemListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    private void init(Context context) {
        boolean z = false;
        this.context = context;
        this.ntf = v.fw(context);
        this.type = ((Activity) context).getIntent().getIntExtra(Columns.TYPE, 0);
        if (bg.gW(this.type) != null) {
            z = true;
        }
        Assert.assertTrue(z);
        this.pHh = getResources().getDisplayMetrics();
        this.pHf = new a();
        setAdapter(this.pHf);
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, MeasureSpec.makeMeasureSpec(536870911, Integer.MIN_VALUE));
    }
}
