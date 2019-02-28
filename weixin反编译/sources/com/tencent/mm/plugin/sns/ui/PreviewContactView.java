package com.tencent.mm.plugin.sns.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.pluginsdk.ui.a.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SuppressLint({"UseSparseArrays"})
public class PreviewContactView extends LinearLayout {
    private final Context context;
    private List<String> list = new ArrayList();
    private TableLayout rBU;
    private final Map<Integer, View> rBV = new HashMap();
    @SuppressLint({"UseSparseArrays"})
    private final Map<Integer, TableRow> rBW = new HashMap();
    private final int rBX = 5;

    public PreviewContactView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.context = context;
        this.rBU = (TableLayout) LayoutInflater.from(this.context).inflate(g.qNM, this, true).findViewById(f.content);
    }

    public final void bX(List<String> list) {
        if (list != null) {
            this.list = list;
            this.rBU.removeAllViews();
            if (list.size() != 0) {
                int size = list.size();
                int i = 0;
                int i2 = 0;
                while (i2 < size) {
                    View view;
                    int i3;
                    View view2 = (TableRow) this.rBW.get(Integer.valueOf(i));
                    if (view2 == null) {
                        view2 = new TableRow(this.context);
                        this.rBW.put(Integer.valueOf(i), view2);
                        view = view2;
                    } else {
                        view = view2;
                    }
                    view.removeAllViews();
                    int i4 = 0;
                    while (true) {
                        i3 = i2;
                        if (i4 >= 5 || i3 >= size) {
                            this.rBU.addView(view);
                            i++;
                            i2 = i3;
                        } else {
                            view2 = (View) this.rBV.get(Integer.valueOf(i3));
                            if (view2 == null) {
                                view2 = View.inflate(this.context, g.qNL, null);
                                this.rBV.put(Integer.valueOf(i3), view2);
                            }
                            View view3 = view2;
                            String str = (String) list.get(i3);
                            ImageView imageView = (ImageView) view3.findViewById(f.qIE);
                            imageView.setBackgroundDrawable(null);
                            b.a(imageView, str);
                            view3.setTag(Integer.valueOf(0));
                            view3.setClickable(false);
                            view.addView(view3);
                            i2 = i3 + 1;
                            i4++;
                        }
                    }
                    this.rBU.addView(view);
                    i++;
                    i2 = i3;
                }
            }
        }
    }
}
