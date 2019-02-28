package com.tencent.mm.plugin.appbrand.wxawidget.console;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnKeyListener;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import com.tencent.mm.modelappbrand.LogInfo;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.MRecyclerView;
import com.tencent.mm.plugin.appbrand.wxawidget.a;
import com.tencent.mm.plugin.appbrand.wxawidget.b.b;
import com.tencent.mm.plugin.appbrand.wxawidget.b.c;
import com.tencent.mm.sdk.platformtools.bi;
import java.util.LinkedList;
import java.util.List;

public class ConsolePanel extends FrameLayout implements a {
    MRecyclerView jRE;
    final List<LogInfo> knc = new LinkedList();
    EditText kni;
    Button[] knj;
    Button knk;
    Button knl;
    a knm;
    int knn;
    String kno;

    static /* synthetic */ void a(ConsolePanel consolePanel) {
        consolePanel.knm.knc.clear();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < consolePanel.knc.size()) {
                LogInfo logInfo = (LogInfo) consolePanel.knc.get(i2);
                if ((consolePanel.knn <= 0 || logInfo.level == consolePanel.knn) && !consolePanel.vP(logInfo.message)) {
                    consolePanel.knm.knc.add(logInfo);
                }
                i = i2 + 1;
            } else {
                consolePanel.knm.UR.notifyChanged();
                return;
            }
        }
    }

    public ConsolePanel(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initialize();
    }

    public ConsolePanel(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initialize();
    }

    private void initialize() {
        LayoutInflater.from(getContext()).inflate(c.kmk, this, true);
        this.kni = (EditText) findViewById(b.kmj);
        this.kni.clearFocus();
        this.knj = new Button[5];
        ce(0, b.kmx);
        ce(1, b.kmA);
        ce(2, b.kmz);
        ce(3, b.kmC);
        ce(4, b.kmy);
        this.knj[0].setSelected(true);
        this.knn = 0;
        this.knk = (Button) findViewById(b.kmd);
        this.knl = (Button) findViewById(b.kmL);
        this.knl.setEnabled(false);
        this.knk.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                ConsolePanel.this.knc.clear();
                ConsolePanel.this.knm.knc.clear();
                ConsolePanel.this.knm.UR.notifyChanged();
            }
        });
        this.knl.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
            }
        });
        this.kni.addTextChangedListener(new TextWatcher() {
            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void afterTextChanged(Editable editable) {
            }
        });
        this.kni.setOnKeyListener(new OnKeyListener() {
            public final boolean onKey(View view, int i, KeyEvent keyEvent) {
                if (i != 66) {
                    return false;
                }
                ConsolePanel.this.kno = ConsolePanel.this.kni.getText().toString();
                ConsolePanel.a(ConsolePanel.this);
                f.ch(view);
                return true;
            }
        });
        this.kni.setOnFocusChangeListener(new OnFocusChangeListener() {
            public final void onFocusChange(View view, boolean z) {
                if (!z) {
                    f.ch(view);
                }
            }
        });
        findViewById(b.kmn).setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                ConsolePanel.this.kno = ConsolePanel.this.kni.getText().toString();
                ConsolePanel.a(ConsolePanel.this);
            }
        });
        setOnTouchListener(new OnTouchListener() {
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                f.ch(view);
                return false;
            }
        });
        this.jRE = (MRecyclerView) findViewById(b.kmB);
        this.knm = new a(getContext());
        MRecyclerView mRecyclerView = this.jRE;
        getContext();
        mRecyclerView.a(new LinearLayoutManager());
        this.jRE.a(null);
        this.jRE.a(this.knm);
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            int i;
            View currentFocus = ((Activity) getContext()).getCurrentFocus();
            if (currentFocus != null && (currentFocus instanceof EditText)) {
                int[] iArr = new int[]{0, 0};
                currentFocus.getLocationInWindow(iArr);
                int i2 = iArr[0];
                i = iArr[1];
                int height = currentFocus.getHeight() + i;
                int width = currentFocus.getWidth() + i2;
                if (motionEvent.getX() <= ((float) i2) || motionEvent.getX() >= ((float) width) || motionEvent.getY() <= ((float) i) || motionEvent.getY() >= ((float) height)) {
                    i = 1;
                    if (i != 0) {
                        f.ch(currentFocus);
                    }
                }
            }
            i = 0;
            if (i != 0) {
                f.ch(currentFocus);
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    private void ce(int i, int i2) {
        Button button = (Button) findViewById(i2);
        button.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                int i = 0;
                while (i < ConsolePanel.this.knj.length) {
                    boolean z;
                    View view2 = ConsolePanel.this.knj[i];
                    if (view2 == view) {
                        z = true;
                    } else {
                        z = false;
                    }
                    view2.setSelected(z);
                    if (z && ConsolePanel.this.knn != i) {
                        ConsolePanel.this.knn = i;
                        ConsolePanel.a(ConsolePanel.this);
                    }
                    i++;
                }
            }
        });
        this.knj[i] = button;
    }

    public final void ai(List<LogInfo> list) {
        if (list != null) {
            final List linkedList = new LinkedList();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= list.size()) {
                    break;
                }
                LogInfo logInfo = (LogInfo) list.get(i2);
                this.knc.add(logInfo);
                if ((logInfo.level == this.knn || this.knn == 0) && !vP(logInfo.message)) {
                    linkedList.add(logInfo);
                }
                i = i2 + 1;
            }
            if (!linkedList.isEmpty()) {
                com.tencent.mm.by.a.Z(new Runnable() {
                    public final void run() {
                        int itemCount = ConsolePanel.this.knm.getItemCount();
                        ConsolePanel.this.knm.knc.addAll(linkedList);
                        ConsolePanel.this.knm.W(itemCount, linkedList.size());
                        if (((LinearLayoutManager) ConsolePanel.this.jRE.TV).fb() == itemCount - 1) {
                            ConsolePanel.this.jRE.smoothScrollToPosition(ConsolePanel.this.knm.getItemCount() - 1);
                        }
                    }
                });
            }
        }
    }

    private boolean vP(String str) {
        return !bi.oN(this.kno) && (str == null || !str.toLowerCase().contains(this.kno.toLowerCase()));
    }
}
