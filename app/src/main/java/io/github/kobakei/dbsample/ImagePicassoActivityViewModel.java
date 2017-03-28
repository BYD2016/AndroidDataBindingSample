package io.github.kobakei.dbsample;

import android.databinding.ObservableField;

/**
 * Created by keisukekobayashi on 2017/03/19.
 */

final public class ImagePicassoActivityViewModel {

    public final ObservableField<String> url = new ObservableField<>();

    ImagePicassoActivityViewModel() {
        this.url.set("https://ja.gravatar.com/userimage/47707269/a3f2615011f5b4260f13055826f486ff.jpeg");
    }
}
