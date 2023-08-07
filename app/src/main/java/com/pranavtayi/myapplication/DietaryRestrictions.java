package com.pranavtayi.myapplication;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DietaryRestrictions extends AppCompatActivity {

    private ListView listView;
    private ArrayAdapter<String> adapter;
    private List<String> dataList;
    private List<Boolean> checkedItems;
    private SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.restrictions_dietary);

        listView = findViewById(R.id.listView);
        SearchView searchView = findViewById(R.id.searchView);
        Button confirmButton = findViewById(R.id.confirmButton);
        Button clearButton = findViewById(R.id.clearButton);

        preferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);

        dataList = Arrays.asList(
                "Peanuts",
                "Tree Nuts",
                "Milk",
                "Eggs",
                "Wheat",
                "Soy",
                "Fish",
                "Shellfish",
                "Sesame",
                "Mustard",
                "Celery",
                "Sulfites",
                "Lupin",
                "Mollusks",
                "Corn",
                "Gluten",
                "Kiwi",
                "Avocado",
                "Banana",
                "Chocolate",
                "Strawberries",
                "Oranges",
                "Tomatoes",
                "Pineapple",
                "Grapes",
                "Apples",
                "Soybeans",
                "Beef",
                "Pork",
                "Chicken",
                "Turkey",
                "Lamb",
                "Venison",
                "Shrimp",
                "Crab",
                "Lobster",
                "Oysters",
                "Clams",
                "Mussels",
                "Scallops",
                "Squid",
                "Octopus",
                "Anchovies",
                "Salmon",
                "Tuna",
                "Trout",
                "Haddock",
                "Cod",
                "Sardines",
                "Mackerel",
                "Halibut",
                "Sole",
                "Swordfish",
                "Mahi Mahi",
                "Walnuts",
                "Almonds",
                "Cashews",
                "Pecans",
                "Hazelnuts",
                "Macadamia Nuts",
                "Pistachios",
                "Brazil Nuts",
                "Coconut",
                "Cashew",
                "Pine Nuts",
                "Hemp Seeds",
                "Chia Seeds",
                "Flaxseeds",
                "Sunflower Seeds",
                "Poppy Seeds",
                "Pumpkin Seeds",
                "Quinoa",
                "Barley",
                "Rye",
                "Oats",
                "Buckwheat",
                "Sorghum",
                "Millet",
                "Spelt",
                "Triticale",
                "Cornstarch",
                "Cornmeal",
                "Corn Syrup",
                "Soy Sauce",
                "Tamari",
                "Miso",
                "Tempeh",
                "Tofu",
                "Textured Vegetable Protein",
                "Wheat Starch",
                "Wheat Bran",
                "Wheat Germ",
                "Baker's Yeast",
                "Brewer's Yeast",
                "Caffeine",
                "Red Dye",
                "Yellow Dye",
                "Blue Dye",
                "Sulfur Dioxide",
                "Artificial Sweeteners",
                "Artificial Preservatives",
                "Artificial Flavors",
                "Artificial Colors",
                "Nitrates",
                "Nitrites",
                "Aspartame",
                "Saccharin"
        );

        // init the checked items list
        checkedItems = new ArrayList<>();
        for (int i = 0; i < dataList.size(); i++) {
            boolean isChecked = preferences.getBoolean(dataList.get(i), false);
            checkedItems.add(isChecked);
        }

        // set adapt
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_multiple_choice, dataList);
        listView.setAdapter(adapter);
        listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);


        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);
                return false;
            }
        });




        listView.setOnItemClickListener((parent, view, position, id) -> {
            boolean isChecked = listView.isItemChecked(position);
            checkedItems.set(position, isChecked);
            //Toast.makeText(MainActivity.this, dataList.get(position) + " - Checked: " + isChecked, Toast.LENGTH_SHORT).show();
        });

        confirmButton.setOnClickListener(v -> {
            showSelectedRestrictionsDialog();

            // conf
            SharedPreferences.Editor editor = preferences.edit();

            for (int i = 0; i < checkedItems.size(); i++) {
                boolean isChecked = checkedItems.get(i);
                editor.putBoolean(dataList.get(i), isChecked);
            }

            editor.apply();
        });


        clearButton.setOnClickListener(v -> {
            // Clear checkbxoes
            for (int i = 0; i < checkedItems.size(); i++) {
                checkedItems.set(i, false);
                listView.setItemChecked(i, false);
            }
            Toast.makeText(DietaryRestrictions.this, "All checkboxes cleared", Toast.LENGTH_SHORT).show();
        });
    }

    @Override
    public void onBackPressed() {

        super.onBackPressed();
        for (int i = 0; i < checkedItems.size(); i++) {
            boolean isChecked = listView.isItemChecked(i);
            checkedItems.set(i, isChecked);
        }
    }
    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences.Editor editor = preferences.edit();



        for (int i = 0; i < checkedItems.size(); i++) {
            boolean isChecked = listView.isItemChecked(i);
            editor.putBoolean(dataList.get(i), isChecked);
        }

        editor.apply();
    }

    @Override
    protected void onResume() {
        super.onResume();
        for (int i = 0; i < dataList.size(); i++) {
            boolean isChecked = preferences.getBoolean(dataList.get(i), false);
            checkedItems.set(i, isChecked);
            listView.setItemChecked(i, isChecked);
        }
    }

    private void showSelectedRestrictionsDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Selected Restrictions");
        StringBuilder selectedRestrictions = new StringBuilder();

        for (int i = 0; i < checkedItems.size(); i++) {
            boolean isChecked = checkedItems.get(i);
            if (isChecked) {
                selectedRestrictions.append(dataList.get(i)).append("\n");
            }
        }

        if (selectedRestrictions.length() == 0) {
            selectedRestrictions.append("No restrictions selected.");
        }

        builder.setMessage(selectedRestrictions.toString());
        builder.setPositiveButton("OK", (dialog, which) -> {
        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }
}
