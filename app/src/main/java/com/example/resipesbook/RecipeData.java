package com.example.resipesbook;

public class RecipeData {
    private String itemName;
    private String itemDescription;
    private String itemKeyWord;
    private String itemImage;

    public RecipeData(String itemName, String itemDescription, String itemKeyWord, String itemImage) {
        this.itemName = itemName;
        this.itemDescription = itemDescription;
        this.itemKeyWord = itemKeyWord;
        this.itemImage = itemImage;
    }

    public String getItemName() {
        return itemName;
    }
    public String getItemDescription() {
        return itemDescription;
    }
    public String getItemKeyWord() {
        return itemKeyWord;
    }
    public String getItemImage() {
        return itemImage;
    }
    public RecipeData() {

    }

}
