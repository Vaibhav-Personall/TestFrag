package com.example.testfrag;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class bb extends Fragment
{
   @Override
   public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
   {
      // TODO Auto-generated method stub
      return inflater.inflate(R.layout.bb, container, false);
      //      return super.onCreateView(inflater, container, savedInstanceState);
   }
}
