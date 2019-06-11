package com.malbacinematicuniverse;

import android.view.View;

public class CustomOnItemClickListerner implements View.OnClickListener {

   public CustomOnItemClickListerner(int position, OnItemClickCallback onItemClickCallback) {
      this.position = position;
      this.onItemClickCallback = onItemClickCallback;
   }

   private int position;
   private OnItemClickCallback onItemClickCallback;

   @Override
   public void onClick(View v) {
      onItemClickCallback.onItemClicked(v, position);
   }

   public interface OnItemClickCallback{
      void onItemClicked(View view, int position);
   }
}
