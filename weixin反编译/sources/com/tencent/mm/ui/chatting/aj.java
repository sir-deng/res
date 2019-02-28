package com.tencent.mm.ui.chatting;

import android.view.View;
import java.util.LinkedList;

public final class aj {
    private static LinkedList<View> yGD = new LinkedList();
    private static LinkedList<View> yGE = new LinkedList();

    public static View FU(int i) {
        LinkedList linkedList = i == 1 ? yGD : yGE;
        if (linkedList.size() != 0) {
            return (View) linkedList.removeFirst();
        }
        return null;
    }

    public static void K(View view, int i) {
        LinkedList linkedList = i == 1 ? yGD : yGE;
        if (linkedList.size() >= 35) {
            linkedList.removeFirst();
        }
        linkedList.addLast(view);
    }

    public static void clear() {
        yGD.clear();
        yGE.clear();
    }
}
