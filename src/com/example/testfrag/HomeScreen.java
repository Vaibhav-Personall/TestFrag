package com.example.testfrag;

import android.app.ActionBar;
import android.app.Activity;
import android.app.FragmentTransaction;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.TextView;

public class HomeScreen extends Activity implements ActionBar.TabListener
{

   /**
    * The {@link android.support.v4.view.PagerAdapter} that will provide fragments for each of the sections. We use a
    * {@link android.support.v4.app.FragmentPagerAdapter} derivative, which will keep every loaded fragment in memory.
    * If this becomes too memory intensive, it may be best to switch to a
    * {@link android.support.v4.app.FragmentStatePagerAdapter}.
    */
   SectionsPagerAdapter mSectionsPagerAdapter;

   /**
    * The {@link ViewPager} that will host the section contents.
    */
   ViewPager mViewPager;
   boolean isLoggedIn = false;

   @Override
   public void onCreate(Bundle savedInstanceState)
   {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_home_screen);
      // Create the adapter that will return a fragment for each of the three primary sections
      // of the app.
      mSectionsPagerAdapter = new SectionsPagerAdapter();

      // Set up the action bar.
      final ActionBar actionBar = getActionBar();
      actionBar.setBackgroundDrawable(getResources().getDrawable(R.drawable.topbar_background));
      actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

      // Set up the ViewPager with the sections adapter.
      mViewPager = (ViewPager) findViewById(R.id.pager);
      mViewPager.setAdapter(mSectionsPagerAdapter);

      mViewPager.setOnTouchListener(new OnTouchListener()
         {

            @Override
            public boolean onTouch(View v, MotionEvent event)
            {
               // TODO Auto-generated method stub
               return true;
            }
         });
      // When swiping between different sections, select the corresponding tab.
      // We can also use ActionBar.Tab#select() to do this if we have a reference to the
      // Tab.
      mViewPager.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener()
         {
            @Override
            public void onPageSelected(int position)
            {
               actionBar.setSelectedNavigationItem(position);
            }
         });

      // For each of the sections in the app, add a tab to the action bar.
      for (int i = 0; i < mSectionsPagerAdapter.getCount(); i++)
      {
         // Create a tab with text corresponding to the page title defined by the adapter.
         // Also specify this Activity object, which implements the TabListener interface, as the
         // listener for when this tab is selected.
         actionBar.addTab(actionBar.newTab().setText(mSectionsPagerAdapter.getPageTitle(i)).setTabListener(this));
      }
   }

   @Override
   public boolean onCreateOptionsMenu(Menu menu)
   {
      getMenuInflater().inflate(R.menu.activity_home_screen, menu);
      return true;
   }

   @Override
   public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction)
   {
   }

   @Override
   public void onTabSelected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction)
   {
      // When the given tab is selected, switch to the corresponding page in the ViewPager.
      mViewPager.setCurrentItem(tab.getPosition());
   }

   @Override
   public void onTabReselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction)
   {
   }

   /**
    * A {@link FragmentPagerAdapter} that returns a fragment corresponding to one of the primary sections of the app.
    */
   public class SectionsPagerAdapter extends PagerAdapter
   {

      public SectionsPagerAdapter()
      {

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

         if (position == 0)
         {
            LayoutInflater inflater = (LayoutInflater) HomeScreen.this
                  .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View layout = inflater.inflate(R.layout.rest, null);

            TextView tv = (TextView) layout.findViewById(R.id.textView1);
            tv.setText("Vaibhav");
            //         Button button1 = (Button) layout.findViewById(R.id.button1);
            //         button1.setText("111111111111111");
            mViewPager.addView(layout);
            return layout;
         }
         else if (position == 1)
         {
            LayoutInflater inflater = (LayoutInflater) HomeScreen.this
                  .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View layout = inflater.inflate(R.layout.cards_info, null);
            TextView tv = (TextView) layout.findViewById(R.id.textView555555555555);
            tv.setText("TAB 1");
            //         Button button1 = (Button) layout.findViewById(R.id.button1);
            //         button1.setText("111111111111111");
            mViewPager.addView(layout);
            return layout;

         }
         else if (position == 2)
         {
            LayoutInflater inflater = (LayoutInflater) HomeScreen.this
                  .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View layout = inflater.inflate(R.layout.sssssss, null);
            mViewPager.addView(layout);
            return layout;
         }
         else
         {

            LayoutInflater inflater = (LayoutInflater) HomeScreen.this
                  .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View layout = inflater.inflate(R.layout.dd, null);

            //         Button button1 = (Button) layout.findViewById(R.id.button1);
            //         button1.setText("111111111111111");
            mViewPager.addView(layout);
            return layout;

         }
      }

      @Override
      public void destroyItem(ViewGroup container, int position, Object object)
      {
         ((ViewPager) mViewPager).removeView((View) object);
      }
   }
}
