package com.example.myapplication;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class DietaryRestrictions extends AppCompatActivity {

    private ListView listView;
    private SearchView searchView;
    private ArrayAdapter<String> adapter;
    private List<String> dataList;
    private List<Boolean> checkedItems;
    private Button confirmButton;
    private Button clearButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.restrictions_dietary);

        listView = findViewById(R.id.listView);
        searchView = findViewById(R.id.searchView);
        confirmButton = findViewById(R.id.confirmButton);
        clearButton = findViewById(R.id.clearButton);

        // Initialize the data source
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
                "Monosodium Glutamate (MSG)",
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
                "Sodium Benzoate",
                "Aspartame",
                "Saccharin",
                "Sucralose",
                "Acesulfame Potassium",
                "Carrageenan"
                // Add more allergens as needed
        );

        // Initialize the checked items list
        checkedItems = new ArrayList<>();
        for (int i = 0; i < dataList.size(); i++) {
            checkedItems.add(false);
        }

        // Create and set the adapter
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_multiple_choice, dataList);
        listView.setAdapter(adapter);
        listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);

        // Set the search view listener
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

        // Set the list view item click listener
        listView.setOnItemClickListener((parent, view, position, id) -> {
            boolean isChecked = listView.isItemChecked(position);
            checkedItems.set(position, isChecked);
            Toast.makeText(DietaryRestrictions.this, dataList.get(position) + " - Checked: " + isChecked, Toast.LENGTH_SHORT).show();
        });

        confirmButton.setOnClickListener(v -> {
            // Do something with the checked items
            for (int i = 0; i < checkedItems.size(); i++) {
                boolean isChecked = checkedItems.get(i);
                String allergen = dataList.get(i);
                if (isChecked) {
                    // The allergen is checked
                    Toast.makeText(DietaryRestrictions.this, allergen + " - Checked", Toast.LENGTH_SHORT).show();
                } else {
                    // The allergen is not checked
                    Toast.makeText(DietaryRestrictions.this, allergen + " - Not Checked", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Set the clear button click listener
        clearButton.setOnClickListener(v -> {
            // Clear all the checkboxes
            for (int i = 0; i < checkedItems.size(); i++) {
                checkedItems.set(i, false);
                listView.setItemChecked(i, false);
            }
            Toast.makeText(DietaryRestrictions.this, "All checkboxes cleared", Toast.LENGTH_SHORT).show();
        });
    }

    @Override
    public void onBackPressed() {
        // Save the checked items when the back button is pressed
        super.onBackPressed();

        for (int i = 0; i < checkedItems.size(); i++) {
            boolean isChecked = listView.isItemChecked(i);
            checkedItems.set(i, isChecked);
        }
    }
}
