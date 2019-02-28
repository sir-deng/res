package com.tencent.mm.plugin.game.ui;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.SpannableString;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ad.k;
import com.tencent.mm.ad.u;
import com.tencent.mm.plugin.game.c.by;
import com.tencent.mm.plugin.game.c.bz;
import com.tencent.mm.plugin.game.c.ef;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.storage.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.y.as;
import com.tencent.mm.y.c;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class GameDetailRankLikedUI extends MMActivity {
    private static final String TAG = ("MicroMsg" + GameDetailRankLikedUI.class.getSimpleName());
    private Dialog jRG;
    private ListView ntX;
    private a ntY;

    private static class a extends BaseAdapter {
        private Context mContext;
        List<ef> nua = new LinkedList();

        private static class a {
            public ImageView hxJ;
            public TextView jSh;
            public TextView nub;

            private a() {
            }

            /* synthetic */ a(byte b) {
                this();
            }
        }

        public final /* synthetic */ Object getItem(int i) {
            return rm(i);
        }

        public a(Context context) {
            this.mContext = context;
        }

        public final int getCount() {
            return this.nua.size();
        }

        private ef rm(int i) {
            return (ef) this.nua.get(i);
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            a aVar;
            if (view == null) {
                view = LayoutInflater.from(this.mContext).inflate(R.i.dki, viewGroup, false);
                a aVar2 = new a();
                aVar2.hxJ = (ImageView) view.findViewById(R.h.clM);
                aVar2.jSh = (TextView) view.findViewById(R.h.clN);
                aVar2.nub = (TextView) view.findViewById(R.h.clO);
                view.setTag(aVar2);
                aVar = aVar2;
            } else {
                aVar = (a) view.getTag();
            }
            ef rm = rm(i);
            b.a(aVar.hxJ, rm.npW, 0.5f, false);
            as.Hm();
            x Xv = c.Ff().Xv(rm.npW);
            if (Xv != null) {
                aVar.jSh.setText(new SpannableString(i.b(this.mContext, Xv.AX(), aVar.jSh.getTextSize())));
            } else {
                aVar.jSh.setText("");
            }
            aVar.nub.setText(rm.npX);
            return view;
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
        String stringExtra = getIntent().getStringExtra("extra_appdi");
        if (bi.oN(stringExtra)) {
            finish();
            return;
        }
        com.tencent.mm.ad.b.a aVar = new com.tencent.mm.ad.b.a();
        aVar.hnT = new by();
        aVar.hnU = new bz();
        aVar.uri = "/cgi-bin/mmgame-bin/getuplist";
        aVar.hnS = 1331;
        com.tencent.mm.ad.b Kf = aVar.Kf();
        ((by) Kf.hnQ.hnY).nkU = stringExtra;
        u.a(Kf, new com.tencent.mm.ad.u.a() {
            public final int a(int i, int i2, String str, com.tencent.mm.ad.b bVar, k kVar) {
                if (i == 0 && i2 == 0) {
                    bz bzVar = (bz) bVar.hnR.hnY;
                    a a = GameDetailRankLikedUI.this.ntY;
                    Collection collection = bzVar.nov;
                    if (collection != null) {
                        a.nua.clear();
                        a.nua.addAll(collection);
                        a.notifyDataSetChanged();
                    }
                    GameDetailRankLikedUI.this.jRG.dismiss();
                } else {
                    com.tencent.mm.sdk.platformtools.x.e(GameDetailRankLikedUI.TAG, "CGI return is not OK. (%d, %d)(%s)", Integer.valueOf(i), Integer.valueOf(i2), str);
                    GameDetailRankLikedUI.this.finish();
                }
                return 0;
            }
        });
    }

    protected final int getLayoutId() {
        return R.i.dkh;
    }

    protected final void initView() {
        setMMTitle(R.l.emn);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                GameDetailRankLikedUI.this.finish();
                return true;
            }
        });
        this.ntX = (ListView) findViewById(R.h.clP);
        this.ntY = new a(this);
        this.ntX.setAdapter(this.ntY);
        this.jRG = com.tencent.mm.plugin.game.d.c.cS(this.mController.xRr);
        this.jRG.show();
    }
}
