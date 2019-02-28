package com.tencent.mm.plugin.emoji.ui.v2;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.ui.emoji.PopEmojiView;
import com.tencent.mm.sdk.platformtools.ag;

public class PreViewListGridView extends ListView {
    private int RT;
    private WindowManager lJT;
    private boolean lOc = true;
    private LayoutParams lOi;
    private int lOj;
    private int lOk;
    private int lOl;
    private boolean lOm;
    private volatile int lOn = -1;
    private String lOo;
    private PopEmojiView lOp;
    private d lOq;
    private ag mHandler = new ag();

    public PreViewListGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public PreViewListGridView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    private void init(Context context) {
        this.lOp = new PopEmojiView(getContext());
        this.lOj = context.getResources().getDimensionPixelSize(R.f.bxj);
        this.lJT = (WindowManager) context.getSystemService("window");
        this.lOi = new LayoutParams(-1, -1, 2, 8, 1);
        this.lOi.width = this.lOj;
        this.lOi.height = this.lOj;
        this.lOi.gravity = 17;
        this.RT = getResources().getConfiguration().orientation;
        if (this.RT == 2) {
            this.lOk = this.lJT.getDefaultDisplay().getHeight();
            this.lOl = this.lJT.getDefaultDisplay().getWidth();
            return;
        }
        this.lOk = this.lJT.getDefaultDisplay().getWidth();
        this.lOl = this.lJT.getDefaultDisplay().getHeight();
    }

    public void setAdapter(ListAdapter listAdapter) {
        super.setAdapter(listAdapter);
        this.lOq = (d) listAdapter;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 1:
            case 3:
                if (this.lOm) {
                    aEh();
                    return true;
                }
                break;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public final void aEh() {
        if (this.lOm) {
            this.lJT.removeView(this.lOp);
            this.lOm = false;
        }
        this.lOo = "";
    }
}
