package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;
import com.tencent.mm.R;
import java.util.LinkedList;

public class GameDropdownView extends TextView implements OnClickListener, OnDismissListener {
    private Context mContext;
    private LinkedList<String> nvA;
    private int nvB = 0;
    private int nvC = 0;
    a nvD = null;
    View nvE = null;
    private OnClickListener nvF = new OnClickListener() {
        public final void onClick(View view) {
            if (GameDropdownView.this.nvz.getContentView() == null || !(GameDropdownView.this.nvz.getContentView() instanceof ViewGroup)) {
                GameDropdownView.this.nvz.dismiss();
                return;
            }
            GameDropdownView.a(GameDropdownView.this, ((ViewGroup) GameDropdownView.this.nvz.getContentView()).indexOfChild(view));
            GameDropdownView.this.nvz.dismiss();
        }
    };
    private b nvz;

    private static class b extends PopupWindow {
        public b(Context context) {
            super(context);
            setWindowLayoutMode(-1, -2);
            setBackgroundDrawable(new BitmapDrawable());
            setFocusable(true);
            setOutsideTouchable(true);
            setTouchInterceptor(new OnTouchListener() {
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    if (motionEvent.getAction() != 4) {
                        return false;
                    }
                    b.this.dismiss();
                    return true;
                }
            });
            setAnimationStyle(R.a.bqd);
        }
    }

    public interface a {
        void rn(int i);
    }

    static /* synthetic */ void a(GameDropdownView gameDropdownView, int i) {
        if (gameDropdownView.nvz.getContentView() != null && (gameDropdownView.nvz.getContentView() instanceof ViewGroup)) {
            ViewGroup viewGroup = (ViewGroup) gameDropdownView.nvz.getContentView();
            if (i <= gameDropdownView.nvC && gameDropdownView.nvB <= gameDropdownView.nvC && (viewGroup.getChildAt(i) instanceof TextView) && (viewGroup.getChildAt(gameDropdownView.nvB) instanceof TextView)) {
                ((TextView) viewGroup.getChildAt(gameDropdownView.nvB)).setTextColor(gameDropdownView.mContext.getResources().getColor(R.e.bsO));
                ((TextView) viewGroup.getChildAt(i)).setTextColor(gameDropdownView.mContext.getResources().getColor(R.e.btv));
                gameDropdownView.setText((CharSequence) gameDropdownView.nvA.get(i));
                if (!(gameDropdownView.nvD == null || gameDropdownView.nvB == i)) {
                    gameDropdownView.nvD.rn(i);
                }
                gameDropdownView.nvB = i;
            }
        }
    }

    public GameDropdownView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        this.nvz = new b(context);
        setOnClickListener(this);
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        setVisibility(8);
    }

    public void onClick(View view) {
        if (this.nvz.isShowing()) {
            this.nvz.dismiss();
        } else if (this.nvE == null) {
            this.nvz.showAsDropDown(this);
        } else {
            this.nvz.showAsDropDown(this.nvE);
        }
    }

    public void onDismiss() {
    }

    public final void c(LinkedList<String> linkedList, int i) {
        if (linkedList.size() != 0) {
            this.nvA = linkedList;
            this.nvC = linkedList.size() - 1;
            if (i < 0 || i > this.nvC) {
                this.nvB = 0;
            } else {
                this.nvB = i;
            }
            LayoutInflater layoutInflater = (LayoutInflater) this.mContext.getSystemService("layout_inflater");
            LinearLayout linearLayout = (LinearLayout) layoutInflater.inflate(R.i.dkK, null);
            for (int i2 = 0; i2 < linkedList.size(); i2++) {
                String str = (String) linkedList.get(i2);
                TextView textView = (TextView) layoutInflater.inflate(R.i.dkL, linearLayout, false);
                textView.setText(str);
                textView.setOnClickListener(this.nvF);
                if (i2 == this.nvB) {
                    textView.setTextColor(this.mContext.getResources().getColor(R.e.btv));
                    setText(str);
                }
                linearLayout.addView(textView);
            }
            this.nvz.setContentView(linearLayout);
            setVisibility(0);
        }
    }
}
