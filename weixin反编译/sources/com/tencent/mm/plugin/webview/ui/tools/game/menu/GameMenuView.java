package com.tencent.mm.plugin.webview.ui.tools.game.menu;

import android.content.Context;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import com.tencent.mm.R;
import com.tencent.mm.plugin.webview.ui.tools.game.menu.b.a;
import com.tencent.mm.plugin.webview.ui.tools.game.menu.b.c;
import com.tencent.mm.ui.base.o;

public class GameMenuView extends LinearLayout {
    private LayoutInflater DF;
    private Context mContext;
    private boolean tMG = false;
    private View tML;
    private LinearLayout tMM;
    private LinearLayout tMN;
    f tMO;
    c tMP;
    a tMQ;

    static /* synthetic */ void a(GameMenuView gameMenuView) {
        int count = gameMenuView.tMO.getCount();
        if (count != 0) {
            View childAt;
            int eC = (gameMenuView.tMG ? com.tencent.mm.bu.a.eC(gameMenuView.mContext) : com.tencent.mm.bu.a.eB(gameMenuView.mContext)) - (com.tencent.mm.bu.a.ab(gameMenuView.mContext, R.f.bxA) * 2);
            int ab = com.tencent.mm.bu.a.ab(gameMenuView.mContext, R.f.bxz);
            int ab2 = com.tencent.mm.bu.a.ab(gameMenuView.mContext, R.f.bxy);
            f fVar = gameMenuView.tMO;
            Object obj = (fVar.rQH == null || fVar.rQH.size() == 0) ? null : (fVar.rQH.size() + 1) / 2 > 4 ? 1 : null;
            int i = obj != null ? gameMenuView.tMG ? (int) (((((double) eC) - (0.375d * ((double) ab2))) - ((double) (ab2 * 4))) / 9.0d) : (int) (((((double) eC) - (0.5d * ((double) ab))) - ((double) (ab * 4))) / 9.0d) : gameMenuView.tMG ? (int) (((double) (eC - (ab2 * 4))) / 8.0d) : (int) (((double) (eC - (ab * 4))) / 8.0d);
            LayoutParams layoutParams = gameMenuView.tMG ? i > 0 ? new LinearLayout.LayoutParams(ab2, (i * 2) + ab2) : new LinearLayout.LayoutParams(ab2, ab2) : i > 0 ? new LinearLayout.LayoutParams((i * 2) + ab, ab) : new LinearLayout.LayoutParams(ab, ab);
            for (eC = 0; eC < count; eC++) {
                View view = gameMenuView.tMO.getView(eC, null, gameMenuView.tMM);
                if (view != null) {
                    view.setOnClickListener(new OnClickListener() {
                        public final void onClick(View view) {
                            if (GameMenuView.this.tMP != null) {
                                GameMenuView.this.tMP.g((o) view.getTag());
                            }
                            if (GameMenuView.this.tMQ != null) {
                                GameMenuView.this.tMQ.onDismiss();
                            }
                        }
                    });
                    view.setLayoutParams(layoutParams);
                    if (eC % 2 == 0) {
                        gameMenuView.tMM.addView(view);
                    } else {
                        gameMenuView.tMN.addView(view);
                    }
                }
            }
            while (true) {
                i = gameMenuView.tMM.getChildCount();
                if (i <= 0) {
                    break;
                }
                childAt = gameMenuView.tMM.getChildAt(i - 1);
                if (childAt != null && childAt.getTag() != null) {
                    break;
                }
                gameMenuView.tMM.removeViewAt(i - 1);
            }
            while (true) {
                i = gameMenuView.tMN.getChildCount();
                if (i <= 0) {
                    break;
                }
                childAt = gameMenuView.tMN.getChildAt(i - 1);
                if (childAt != null && childAt.getTag() != null) {
                    break;
                }
                gameMenuView.tMN.removeViewAt(i - 1);
            }
            if (gameMenuView.tMM.getChildCount() == 0 && gameMenuView.tMN.getChildCount() == 0) {
                if (gameMenuView.tMQ != null) {
                    gameMenuView.tMQ.onDismiss();
                }
            } else if (gameMenuView.tMM.getChildCount() == 0) {
                ((ViewGroup) gameMenuView.tMM.getParent()).setVisibility(8);
            } else if (gameMenuView.tMN.getChildCount() == 0) {
                ((ViewGroup) gameMenuView.tMN.getParent()).setVisibility(8);
            }
        }
    }

    public GameMenuView(Context context) {
        boolean z = false;
        super(context, null);
        this.mContext = context;
        this.DF = LayoutInflater.from(this.mContext);
        DisplayMetrics displayMetrics = this.mContext.getResources().getDisplayMetrics();
        if (displayMetrics.widthPixels > displayMetrics.heightPixels) {
            z = true;
        }
        this.tMG = z;
        initView();
    }

    public GameMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.mContext = context;
        initView();
    }

    private void initView() {
        View inflate;
        if (this.tMG) {
            setOrientation(0);
            this.DF.inflate(R.i.dkW, this, true);
            inflate = this.DF.inflate(R.i.dkT, this, true);
        } else {
            setOrientation(1);
            this.DF.inflate(R.i.dkX, this, true);
            inflate = this.DF.inflate(R.i.dkU, this, true);
        }
        this.tML = inflate.findViewById(R.h.cmM);
        this.tMM = (LinearLayout) inflate.findViewById(R.h.cmL);
        this.tMN = (LinearLayout) inflate.findViewById(R.h.cmN);
    }
}
