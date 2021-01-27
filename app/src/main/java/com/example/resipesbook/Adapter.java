package com.example.resipesbook;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

//set ViewHolder, which will give us access to View-components
public class Adapter extends RecyclerView.Adapter<PageViewHolder> {
    private Context mContext;
    private ArrayList<RecipeData> myRecipeList;
    private int lastPosition = -1;

    public Adapter(Context mContext, ArrayList<RecipeData> myRecipeList) {
        this.mContext = mContext;
        this.myRecipeList = myRecipeList;
    }

    @NonNull
    @Override
    public PageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.pages_layout,parent,false);
        return new PageViewHolder(mView);
    }

    @Override
    public void onBindViewHolder(@NonNull final PageViewHolder holder, int position) {
        Glide.with(mContext)
                .load(myRecipeList.get(position).getItemImage())
                .into(holder.imageView);
        holder.mTitle.setText(myRecipeList.get(position).getItemName());
        holder.mDescription.setText(myRecipeList.get(position).getItemDescription());
        holder.mKeyWord.setText(myRecipeList.get(position).getItemKeyWord());

        holder.mCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext,FullRecipeActivity.class);
                intent.putExtra("Image",myRecipeList.get(holder.getAdapterPosition()).getItemImage());
                intent.putExtra("Description",myRecipeList.get(holder.getAdapterPosition()).getItemDescription());
                intent.putExtra("RecipeName",myRecipeList.get(holder.getAdapterPosition()).getItemName());
                intent.putExtra("KeyWord",myRecipeList.get(holder.getAdapterPosition()).getItemKeyWord());
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return myRecipeList.size();
    }

    public void searchItemName(ArrayList<RecipeData> recipeDataArrayList) {
        myRecipeList =recipeDataArrayList;
        notifyDataSetChanged();
    }
}

//this class gives a direct link to each View component
class PageViewHolder extends RecyclerView.ViewHolder{

    ImageView imageView;
    TextView mTitle,mDescription,mKeyWord;
    CardView mCardView;

    public PageViewHolder( View itemView) {
        super(itemView);

        imageView = itemView.findViewById(R.id.view_Image);
        mTitle = itemView.findViewById(R.id.view_Title);
        mDescription = itemView.findViewById(R.id.view_Description);
        mKeyWord = itemView.findViewById(R.id.view_KeyWord);
        mCardView = itemView.findViewById(R.id.myCardView);
    }
}
