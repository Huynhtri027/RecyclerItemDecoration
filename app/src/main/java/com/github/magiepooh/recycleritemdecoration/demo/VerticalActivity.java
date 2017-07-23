package com.github.magiepooh.recycleritemdecoration.demo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import com.github.magiepooh.recycleritemdecoration.ItemDecorations;
import com.github.magiepooh.recycleritemdecoration.demo.binder.LandscapeDescriptionBinder;
import com.github.magiepooh.recycleritemdecoration.demo.binder.LandscapeItemBinder;
import com.github.magiepooh.recycleritemdecoration.demo.binder.LandscapeTileBinder;
import com.github.magiepooh.recycleritemdecoration.demo.binder.TitleBinder;
import jp.satorufujiwara.binder.recycler.RecyclerBinderAdapter;

/**
 * Created by magiepooh on 2015/08
 */
public class VerticalActivity extends AppCompatActivity {

  public static void startActivity(Activity activity) {
    activity.startActivity(new Intent(activity, VerticalActivity.class));
  }

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_vertical);

    RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_vertical);
    recyclerView.setLayoutManager(new LinearLayoutManager(this));

    // create ItemDecoration
    RecyclerView.ItemDecoration decoration = ItemDecorations.vertical(this)
        .first(R.drawable.shape_decoration_green_h_16)
        .type(DemoViewType.LANDSCAPE_ITEM.ordinal(), R.drawable.shape_decoration_gray_h_12_padding)
        .type(DemoViewType.LANDSCAPE_TILE.ordinal(),
            R.drawable.shape_decoration_cornflower_lilac_h_8)
        .type(DemoViewType.LANDSCAPE_DESCRIPTION.ordinal(), R.drawable.shape_decoration_red_h_8)
        .last(R.drawable.shape_decoration_flush_orange_h_16)
        .create();
    recyclerView.addItemDecoration(decoration);

    RecyclerBinderAdapter<DemoSectionType, DemoViewType> adapter = new RecyclerBinderAdapter<>();
    adapter.add(DemoSectionType.ITEM, new TitleBinder(this, "Pisa"));
    adapter.add(DemoSectionType.ITEM, new LandscapeItemBinder(this, R.drawable.demo0_1, "pisa_01"));
    adapter.add(DemoSectionType.ITEM, new LandscapeItemBinder(this, R.drawable.demo0_2, "pisa_02"));
    adapter.add(DemoSectionType.ITEM, new LandscapeItemBinder(this, R.drawable.demo0_3, "pisa_03"));
    adapter.add(DemoSectionType.ITEM, new LandscapeItemBinder(this, R.drawable.demo0_4, "pisa_04"));

    adapter.add(DemoSectionType.ITEM, new TitleBinder(this, "Venice"));
    adapter.add(DemoSectionType.ITEM,
        new LandscapeTileBinder(this, R.drawable.demo1_1, R.drawable.demo1_2));
    adapter.add(DemoSectionType.ITEM,
        new LandscapeTileBinder(this, R.drawable.demo1_3, R.drawable.demo1_4));
    adapter.add(DemoSectionType.ITEM,
        new LandscapeTileBinder(this, R.drawable.demo1_1, R.drawable.demo1_2));
    adapter.add(DemoSectionType.ITEM,
        new LandscapeTileBinder(this, R.drawable.demo1_3, R.drawable.demo1_4));
    adapter.add(DemoSectionType.ITEM, new TitleBinder(this, "Description"));
    adapter.add(DemoSectionType.ITEM, new LandscapeDescriptionBinder(this, "description: Pisa"));
    adapter.add(DemoSectionType.ITEM, new LandscapeDescriptionBinder(this, "description: Venice"));
    adapter.add(DemoSectionType.ITEM, new LandscapeDescriptionBinder(this, "description: Burano"));

    recyclerView.setAdapter(adapter);
  }
}
