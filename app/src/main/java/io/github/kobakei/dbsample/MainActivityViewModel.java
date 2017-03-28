package io.github.kobakei.dbsample;

import android.content.Context;
import android.view.View;

/**
 * Created by keisukekobayashi on 2017/03/18.
 */

final public class MainActivityViewModel {

    private final Context context;

    MainActivityViewModel(Context context) {
        this.context = context;
    }

    public void onImagePicassoButtonClick(View view) {
        Navigator.navigateToImagePicasso(context);
    }

    public void onTextStrikeButtonClick(View view) {
        Navigator.navigateToTextStrike(context);
    }

    public void onRecyclerScrollButtonClick(View view) {
        Navigator.navigateToRecyclerScroll(context);
    }

    public void onListChoiceButtonClick(View view) {
        Navigator.navigateToListChoice(context);
    }
}
