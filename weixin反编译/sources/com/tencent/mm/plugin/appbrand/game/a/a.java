package com.tencent.mm.plugin.appbrand.game.a;

public final class a extends com.tencent.mm.plugin.fts.a.a {
    protected final void Be() {
        if (Bf()) {
            v(-108, 1);
        }
    }

    protected final String getTableName() {
        return "MiniGame";
    }

    public final String getName() {
        return "FTS5MiniGameStorage";
    }

    public final int getType() {
        return 8;
    }

    public final int getPriority() {
        return 8;
    }

    protected final boolean Bf() {
        return !cF(-108, 1);
    }
}
