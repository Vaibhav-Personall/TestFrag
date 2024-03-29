package com.example.testfrag;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

public class OffersFragment extends Fragment
{
   private static final String TAG = "OffersFragment";
   SectionsPagerAdapter9 mSectionsPagerAdapter;
   ViewPager mViewPager;

   @Override
   public void onCreate(Bundle savedInstanceState)
   {
      super.onCreate(savedInstanceState);
      mSectionsPagerAdapter = new SectionsPagerAdapter9();
      LayoutInflater inflater = (LayoutInflater) getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
      LinearLayout ll = (LinearLayout) inflater.inflate(R.layout.offers, null);
      mViewPager = (ViewPager) ll.findViewById(R.id.pager1);
      mViewPager.setAdapter(mSectionsPagerAdapter);
      Log.d(TAG, "onCreate ::" + mViewPager.getChildCount());
   }

   @Override
   public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
   {
      // TODO Auto-generated method stub
      return inflater.inflate(R.layout.offers, container, false);
   }

   public class SectionsPagerAdapter9 extends PagerAdapter
   {

      public SectionsPagerAdapter9()
      {
         Log.d(TAG, "SectionsPagerAdapter1 Constructor ::");
      }

      @Override
      public int getItemPosition(Object object)
      {
         // TODO Auto-generated method stub
         return POSITION_NONE;
      }

      @Override
      public CharSequence getPageTitle(int position)
      {
         switch (position)
         {
            case 0:
               return getString(R.string.title_section1).toUpperCase();
            case 1:
               return getString(R.string.title_section2).toUpperCase();
            case 2:
               return getString(R.string.title_section3).toUpperCase();
            case 3:
               return getString(R.string.title_section4).toUpperCase();

         }
         return null;
      }

      @Override
      public int getCount()
      {
         Log.d(TAG, "getCount ::");
         return 4;
      }

      @Override
      public boolean isViewFromObject(View arg0, Object arg1)
      {
         return arg0 == arg1;
      }

      @Override
      public Object instantiateItem(ViewGroup container, int position)
      {
         Log.d(TAG, "instantiateItem ::" + position);
         LayoutInflater inflater = (LayoutInflater) getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
         View layout = inflater.inflate(R.layout.cards_info, null);
         mViewPager.addView(layout);
         Log.d(TAG, "instantiateItem ::" + position);
         return layout;
      }

      @Override
      public void destroyItem(ViewGroup container, int position, Object object)
      {
         ((ViewPager) mViewPager).removeView((View) object);
      }
   }

}
