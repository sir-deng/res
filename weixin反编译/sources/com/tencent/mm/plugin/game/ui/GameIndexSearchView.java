package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import com.tencent.mm.plugin.game.d.c;
import com.tencent.mm.plugin.game.model.ap;
import com.tencent.mm.plugin.game.model.b;
import com.tencent.mm.plugin.game.model.b.a;

public class GameIndexSearchView extends LinearLayout {
    LayoutInflater DF = ((LayoutInflater) this.mContext.getSystemService("layout_inflater"));
    private Context mContext;

    /* renamed from: com.tencent.mm.plugin.game.ui.GameIndexSearchView$1 */
    class AnonymousClass1 implements OnClickListener {
        final /* synthetic */ int nrE;

        AnonymousClass1(int i) {
            this.nrE = i;
        }

        public final void onClick(View view) {
            int p;
            if (view.getTag() == null || !(view.getTag() instanceof String)) {
                a aQy = b.aQy();
                if (aQy.fEo == 2) {
                    p = c.p(GameIndexSearchView.this.mContext, aQy.url, "game_center_msgcenter");
                } else {
                    Intent intent = new Intent(GameIndexSearchView.this.mContext, GameSearchUI.class);
                    intent.putExtra("game_report_from_scene", 1001);
                    GameIndexSearchView.this.mContext.startActivity(intent);
                    p = 6;
                }
            } else {
                p = c.p(GameIndexSearchView.this.mContext, (String) view.getTag(), "game_center_msgcenter");
            }
            ap.a(GameIndexSearchView.this.mContext, 14, 1401, 1, p, 0, null, this.nrE, 0, null, null, null);
        }
    }

    public GameIndexSearchView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setOrientation(0);
        this.mContext = context;
    }
}
