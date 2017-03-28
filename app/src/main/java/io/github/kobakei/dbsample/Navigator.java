package io.github.kobakei.dbsample;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by keisukekobayashi on 2017/03/18.
 */

public class Navigator {

    private static void navigatorToActivity(@NonNull Context from,
                                            Class<? extends AppCompatActivity> clazz) {
        Intent intent = new Intent(from, clazz);
        from.startActivity(intent);
    }

    static void navigateToImagePicasso(@NonNull Context from) {
        navigatorToActivity(from, ImagePicassoActivity.class);
    }

    static void navigateToTextStrike(@NonNull Context from) {
        navigatorToActivity(from, TextStrikeActivity.class);
    }

    static void navigateToRecyclerScroll(@NonNull Context from) {
        navigatorToActivity(from, RecyclerScrollActivity.class);
    }

    static void navigateToListChoice(@NonNull Context from) {
        navigatorToActivity(from, ListChoiceActivity.class);
    }
}
