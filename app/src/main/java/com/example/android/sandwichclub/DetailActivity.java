package com.example.android.sandwichclub;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.android.sandwichclub.models.Sandwich;

public class DetailActivity extends AppCompatActivity {

    private TextView mAlsoKnown;
    private TextView mPlaceOfOrigin;
    private TextView mDescription;
    private TextView mIngredient;
    private ImageView mImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        mAlsoKnown = findViewById(R.id.known_as);
        mPlaceOfOrigin = findViewById(R.id.place_of_origin);
        mDescription = findViewById(R.id.description);
        mIngredient = findViewById(R.id.ingredients);
        mImage = findViewById(R.id.imageView2);

        int position = getIntent().getExtras().getInt("Info");

        String[] sandwiches = getResources().getStringArray(R.array.sandwich_details);
        String json = sandwiches[position];
        Sandwich sandwich = SandwichUtils.parseJson(json);
        setTitle(sandwich.getMainName());


        for (int i = 0; i < sandwich.getAlsoKnownAs().size(); i++) {
            if (!sandwich.getAlsoKnownAs().isEmpty()) {
                mAlsoKnown.append(sandwich.getAlsoKnownAs().get(i) + "  ");
            }
        }


        mPlaceOfOrigin.setText(sandwich.getPlaceOfOrigin());
        mDescription.setText(sandwich.getDescription());

        for (int i = 0; i < sandwich.getIngredients().size(); i++) {
            if (!sandwich.getIngredients().isEmpty()) {
                mIngredient.append(sandwich.getIngredients().get(i) + "  ");
            }
        }


        Glide.with(this).load(sandwich.getImage()).into(mImage);

    }


}
