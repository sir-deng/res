package android.support.design.widget;

import android.view.View;

final class z {
    private int lN;
    private int lO;
    int lP;
    int lQ;
    private final View mView;

    public z(View view) {
        this.mView = view;
    }

    public final void aC() {
        this.lN = this.mView.getTop();
        this.lO = this.mView.getLeft();
        aD();
    }

    final void aD() {
        android.support.v4.view.z.j(this.mView, this.lP - (this.mView.getTop() - this.lN));
        android.support.v4.view.z.k(this.mView, this.lQ - (this.mView.getLeft() - this.lO));
    }

    public final boolean p(int i) {
        if (this.lP == i) {
            return false;
        }
        this.lP = i;
        aD();
        return true;
    }
}
