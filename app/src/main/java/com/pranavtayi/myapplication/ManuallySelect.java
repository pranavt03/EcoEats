package com.pranavtayi.myapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;


import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class ManuallySelect extends AppCompatActivity {

    private ListView listView;
    private ArrayAdapter<String> adapter;
    private List<String> dataList;
    private List<Boolean> checkedItems;
    private SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.select_manually);

        listView = findViewById(R.id.listView);
        SearchView searchView = findViewById(R.id.searchView);
        Button confirmButton = findViewById(R.id.confirmButton);
        Button clearButton = findViewById(R.id.clearButton);

        preferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);

        dataList = Arrays.asList(
                "Salt",
                "Sugar",
                "Water",
                "Garlic",
                "Onion",
                "Black Pepper",
                "Olive Oil",
                "Vegetable Oil",
                "Butter",
                "Lemon Juice",
                "Vinegar",
                "Cinnamon",
                "Cumin",
                "Paprika",
                "Chili Powder",
                "Thyme",
                "Rosemary",
                "Basil",
                "Oregano",
                "Parsley",
                "Cilantro",
                "Mint",
                "Ginger",
                "Nutmeg",
                "Vanilla Extract",
                "Honey",
                "Maple Syrup",
                "Parmesan Cheese",
                "Cheddar Cheese",
                "Mozzarella Cheese",
                "Goat Cheese",
                "Feta Cheese",
                "Blue Cheese",
                "Swiss Cheese",
                "Provolone Cheese",
                "Monterey Jack Cheese",
                "Cream Cheese",
                "Sour Cream",
                "Yogurt",
                "Cottage Cheese",
                "Heavy Cream",
                "Whipped Cream",
                "Egg",
                "Milk",
                "Flour",
                "Soy Sauce",
                "Tomato Sauce",
                "Ketchup",
                "Mayonnaise",
                "Mustard",
                "Hot Sauce",
                "BBQ Sauce",
                "Salsa",
                "Peanut Butter",
                "Almond Butter",
                "Cashew Butter",
                "Sunflower Butter",
                "Nutella",
                "Jelly",
                "Jam",
                "Chocolate",
                "White Chocolate",
                "Dark Chocolate",
                "Milk Chocolate",
                "Cocoa Powder",
                "Coconut Milk",
                "Coconut Cream",
                "Coconut Oil",
                "Coconut Flakes",
                "Coconut Water",
                "Rice",
                "Pasta",
                "Bread",
                "Tortillas",
                "Pita Bread",
                "Baguette",
                "Croissant",
                "Rolls",
                "Bagels",
                "Pancake Mix",
                "Cereal",
                "Granola",
                "Oatmeal",
                "Corn Flakes",
                "Raisins",
                "Dried Cranberries",
                "Dried Apricots",
                "Dried Figs",
                "Dates",
                "Peanuts",
                "Almonds",
                "Cashews",
                "Pistachios",
                "Hazelnuts",
                "Macadamia Nuts",
                "Walnuts",
                "Pecans",
                "Sunflower Seeds",
                "Pumpkin Seeds",
                "Chia Seeds",
                "Flaxseeds",
                "Hemp Seeds",
                "Poppy Seeds",
                "Quinoa",
                "Brown Rice",
                "Wild Rice",
                "Barley",
                "Oats",
                "Couscous",
                "Bulgur",
                "Lentils",
                "Chickpeas",
                "Black Beans",
                "Pinto Beans",
                "Kidney Beans",
                "Lima Beans",
                "Green Beans",
                "Peas",
                "Corn",
                "Carrots",
                "Celery",
                "Potatoes",
                "Sweet Potatoes",
                "Spinach",
                "Kale",
                "Lettuce",
                "Cabbage",
                "Broccoli",
                "Cauliflower",
                "Tomatoes",
                "Cucumbers",
                "Zucchini",
                "Mushrooms",
                "Radishes",
                "Beets",
                "Bell Peppers",
                "Chili Peppers",
                "Jalapenos",
                "Habanero Peppers",
                "Eggplant",
                "Asparagus",
                "Artichokes",
                "Avocado",
                "Strawberries",
                "Blueberries",
                "Raspberries",
                "Blackberries",
                "Cranberries",
                "Apples",
                "Oranges",
                "Grapes",
                "Pineapple",
                "Mangoes",
                "Bananas",
                "Lemons",
                "Limes",
                "Peaches",
                "Plums",
                "Pears",
                "Watermelon",
                "Honeydew Melon",
                "Cantaloupe",
                "Kiwi",
                "Passion Fruit",
                "Dragon Fruit",
                "Pomegranate",
                "Guava",
                "Coconut",
                "Mint Leaves",
                "Parsley",
                "Cilantro",
                "Basil Leaves",
                "Rosemary",
                "Thyme",
                "Dill",
                "Bay Leaves",
                "Sage",
                "Tarragon",
                "Marjoram",
                "Oregano",
                "Chives",
                "Scallions",
                "Green Onions",
                "Red Onions",
                "Shallots",
                "Ginger",
                "Turmeric",
                "Cayenne Pepper",
                "Paprika",
                "Cinnamon",
                "Nutmeg",
                "Cloves",
                "Allspice",
                "Cardamom",
                "Vanilla Extract",
                "Almond Extract",
                "Lemon Zest",
                "Lime Zest",
                "Orange Zest",
                "Brown Sugar",
                "Powdered Sugar",
                "Granulated Sugar",
                "White Sugar",
                "Honey",
                "Maple Syrup",
                "Corn Syrup",
                "Agave Nectar",
                "Molasses",
                "Stevia",
                "Xylitol",
                "Coconut Sugar",
                "Artificial Sweeteners",
                "Black Pepper",
                "Garlic Powder",
                "Onion Powder",
                "Mustard Powder",
                "Coriander",
                "Fennel Seeds",
                "Caraway Seeds",
                "Sesame Seeds",
                "Peppercorns",
                "Vanilla Beans",
                "Coconut Flakes",
                "Brown Rice Syrup",
                "Pepper",
                "Garlic",
                "Canola Oil",
                "Sesame Oil",
                "Sunflower Oil",
                "Peanut Oil",
                "Cheese",
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
        );

        // init the checked items list
        checkedItems = new ArrayList<>();
        for (int i = 0; i < dataList.size(); i++) {
            boolean isChecked = preferences.getBoolean(dataList.get(i), false);
            checkedItems.add(isChecked);
        }

        // set adapter
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
        });

        confirmButton.setOnClickListener(v -> {
            showSelectedRestrictionsDialog();

            // Save the checked items to shared preferences
            SharedPreferences.Editor editor = preferences.edit();
            for (int i = 0; i < checkedItems.size(); i++) {
                boolean isChecked = checkedItems.get(i);
                editor.putBoolean(dataList.get(i), isChecked);
            }
            editor.apply();

            // Send the checked items to the server via POST request
            sendCheckedItemsToServer(checkedItems);
        });

        clearButton.setOnClickListener(v -> {
            // Clear checkboxes
            for (int i = 0; i < checkedItems.size(); i++) {
                checkedItems.set(i, false);
                listView.setItemChecked(i, false);
            }
            Toast.makeText(ManuallySelect.this, "All checkboxes cleared", Toast.LENGTH_SHORT).show();
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
        builder.setTitle("Selected Ingredients");
        StringBuilder selectedRestrictions = new StringBuilder();

        for (int i = 0; i < checkedItems.size(); i++) {
            boolean isChecked = checkedItems.get(i);
            if (isChecked) {
                selectedRestrictions.append(dataList.get(i)).append("\n");
            }
        }

        if (selectedRestrictions.length() == 0) {
            selectedRestrictions.append("No Ingredients selected.");
        }

        builder.setMessage(selectedRestrictions.toString());
        builder.setPositiveButton("OK", (dialog, which) -> {
        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }

    private void sendCheckedItemsToServer(List<Boolean> checkedItems) {
        OkHttpClient client = new OkHttpClient();
        Gson gson = new GsonBuilder().create();

        List<String> checkedLabelsList = new ArrayList<>();
        for (int i = 0; i < dataList.size(); i++) {
            if (checkedItems.get(i)) {
                String label = dataList.get(i);
                checkedLabelsList.add(label);
            }
        }

        // Create a JSON object with "prompts" key and the list of checked labels as the value
        JsonObject jsonObject = new JsonObject();
        JsonArray jsonArray = gson.toJsonTree(checkedLabelsList).getAsJsonArray();
        jsonObject.add("prompts", jsonArray);

        // Convert the JSON object to a JSON string
        String json = jsonObject.toString();

        MediaType JSON = MediaType.parse("application/json; charset=utf-8");
        RequestBody requestBody = RequestBody.create(json, JSON);

        Request request = new Request.Builder()
                .url("https://recipemajic.onrender.com/generate_recipe") // Replace with your server's API endpoint
                .post(requestBody)
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.isSuccessful()) {
                    // Handle the successful response here
                    final String responseBody = response.body().string();

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            // Start the LoadingActivity first
                            Intent loadingIntent = new Intent(ManuallySelect.this, LoadingActivity.class);
                            startActivity(loadingIntent);

                            // Pass the response data as an extra to the LoadingActivity
                            Intent intent = new Intent(ManuallySelect.this, DisplayResponseActivity.class);
                            intent.putExtra("responseData", responseBody);

                            // Start the DisplayResponseActivity with a delay of 2 seconds (adjust as needed)
                            Handler handler = new Handler();
                            handler.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    // Finish the LoadingActivity and start the DisplayResponseActivity
                                    startActivity(intent);
                                    finish();
                                }
                            }, 2000); // Delay of 2 seconds (adjust as needed)
                        }
                    });
                } else {
                    // Handle the error response here
                    final int errorCode = response.code();
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            // Show the API error as a Toast
                            Toast.makeText(ManuallySelect.this, "API Error: " + errorCode, Toast.LENGTH_LONG).show();
                        }
                    });
                }
            }
        });
    }

    // Helper class to represent the data sent to the server
    class CheckedItemsData {
        private List<String> checkedItems;

        public CheckedItemsData(List<String> checkedItems) {
            this.checkedItems = checkedItems;
        }
    }
}