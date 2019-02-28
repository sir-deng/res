package com.tencent.mm.plugin.game.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.AbsListView.LayoutParams;
import android.widget.ListView;
import com.tencent.mm.R;
import com.tencent.mm.ui.MMActivity;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

public class GameRankUI extends MMActivity {
    private GameRankView nAa;
    private ListView nuc;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
        GameRankView gameRankView = this.nAa;
        getIntent().getStringExtra("extra_app_id");
        LinkedList linkedList = new LinkedList();
        Serializable serializableExtra = getIntent().getSerializableExtra("extra_user_ranks");
        if (serializableExtra != null && (serializableExtra instanceof List)) {
            linkedList.addAll((List) serializableExtra);
        }
        if (linkedList.size() == 0) {
            gameRankView.nAd.setVisibility(0);
            gameRankView.nAc.setVisibility(8);
            return;
        }
        gameRankView.nAe.T(linkedList);
        gameRankView.nAc.setAdapter(gameRankView.nAe);
        gameRankView.nAd.setVisibility(8);
        gameRankView.nAc.setVisibility(0);
    }

    public void onResume() {
        super.onResume();
    }

    protected final int getLayoutId() {
        return R.i.cnc;
    }

    protected final void initView() {
        setMMTitle(R.l.emx);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                GameRankUI.this.finish();
                return true;
            }
        });
        this.nAa = (GameRankView) findViewById(R.h.cnc);
        this.nuc = (ListView) this.nAa.findViewById(R.h.cnf);
        new View(this).setLayoutParams(new LayoutParams(-1, getResources().getDimensionPixelSize(R.f.bvw)));
        LayoutInflater layoutInflater = (LayoutInflater) getSystemService("layout_inflater");
        View inflate = layoutInflater.inflate(R.i.dlh, this.nuc, false);
        View inflate2 = layoutInflater.inflate(R.i.dlh, this.nuc, false);
        this.nuc.addHeaderView(inflate);
        this.nuc.addFooterView(inflate2);
    }
}
