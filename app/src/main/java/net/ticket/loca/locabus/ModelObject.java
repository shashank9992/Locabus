package net.ticket.loca.locabus;

public enum ModelObject {

    first(R.string.intro_first_fragment, R.layout.intro_first_fragment),
    second(R.string.intro_second_fragment, R.layout.intro_second_fragment),
    third(R.string.intro_third_fragment, R.layout.intro_third_fragment),
    sixth(R.string.activity_login_normal, R.layout.activity_login_normal),
    four(R.string.choose_language, R.layout.choose_language),
    fifth(R.string.activity_login_slang, R.layout.activity_login_slang);

    private int mTitleResId;
    private int mLayoutResId;

    ModelObject(int titleResId, int layoutResId) {
        mTitleResId = titleResId;
        mLayoutResId = layoutResId;
    }

    public int getTitleResId() {
        return mTitleResId;
    }

    public int getLayoutResId() {
        return mLayoutResId;

    }
}
