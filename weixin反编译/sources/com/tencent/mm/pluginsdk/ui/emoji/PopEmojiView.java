package com.tencent.mm.pluginsdk.ui.emoji;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import com.tencent.mm.plugin.m.a.c;
import com.tencent.mm.plugin.m.a.e;
import com.tencent.mm.plugin.m.a.f;

public class PopEmojiView extends LinearLayout {
    private ViewGroup jKO;
    public MMEmojiView vzn;
    private ProgressBar vzo;

    public enum a {
        ;

        static {
            vzq = 1;
            vzr = 2;
            vzs = new int[]{vzq, vzr};
        }

        public static int[] ccT() {
            return (int[]) vzs.clone();
        }
    }

    /* renamed from: com.tencent.mm.pluginsdk.ui.emoji.PopEmojiView$1 */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] vzp = new int[a.ccT().length];

        static {
            try {
                vzp[a.vzq - 1] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                vzp[a.vzr - 1] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    public PopEmojiView(Context context) {
        super(context);
        init(context);
    }

    public PopEmojiView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public PopEmojiView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    private void init(Context context) {
        this.jKO = (ViewGroup) inflate(getContext(), f.lPk, null);
        this.vzn = (MMEmojiView) this.jKO.findViewById(e.image);
        this.vzn.vzl = true;
        this.vzn.vzj = context.getResources().getDimensionPixelSize(c.ltv) - (context.getResources().getDimensionPixelSize(c.bvC) * 3);
        this.vzo = (ProgressBar) this.jKO.findViewById(e.progress);
        addView(this.jKO, -1, -1);
    }

    public final void CM(int i) {
        switch (AnonymousClass1.vzp[i - 1]) {
            case 1:
                this.vzn.setVisibility(4);
                this.vzo.setVisibility(0);
                return;
            case 2:
                this.vzn.setVisibility(0);
                this.vzo.setVisibility(8);
                return;
            default:
                return;
        }
    }
}
