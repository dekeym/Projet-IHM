package com.example.android.challengeme;

import java.util.ArrayList;
import java.util.List;

import com.example.android.challengemestructure.Course;
import com.example.android.challengemestructure.ListCoureurs;
import com.example.android.challengemestructure.ListCourses;
import com.example.android.challengemestructure.ListTerritoires;
import com.example.android.navigationdrawerexample.R;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
    private DrawerLayout mDrawerLayout;
    private ListView mDrawerList;
    private ActionBarDrawerToggle mDrawerToggle;

    private CharSequence mDrawerTitle;
    private CharSequence mTitle;
    private String[] menuTitles;
    
    private MyListAdapter adapterList;
    private MyListAdapterHdefis adapterListDefis;
    private MyListAdapterDefisAutour adapterListDefis2;
    private MyListAdapterClassement adapterListClassement;
    private MyListAdapterTerritoire adapterListTerritoire;
    private MyListAdapterCalendar adapterListCalendar;
    private ListCourses historique;   
    private ListCourses listDefis;  
    private ListCoureurs listeCoureurs;
    private ListTerritoires listeTerritoires;
      
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
                      
        mTitle = mDrawerTitle = getTitle();
        menuTitles = getResources().getStringArray(R.array.menu);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerList = (ListView) findViewById(R.id.left_drawer);

        // mettre une ombre qui recouvre le contenu principal quand on ouvre le menu
        mDrawerLayout.setDrawerShadow(R.drawable.drawer_shadow, GravityCompat.START);
        // mise en place de liste du menu et cr�ation du listener sur les items de la liste
        mDrawerList.setAdapter(new ArrayAdapter<String>(this,
                R.layout.drawer_list_item, menuTitles));
        mDrawerList.setOnItemClickListener(new DrawerItemClickListener());

        // autoriser l'action d'ouvrir/fermer le menu lorsqu'on clique sur l'ic�ne de l'app
        getActionBar().setDisplayHomeAsUpEnabled(true);
        getActionBar().setHomeButtonEnabled(true);

        // ActionBarDrawerToggle ties together the the proper interactions
        // between the sliding drawer and the action bar app icon
        mDrawerToggle = new ActionBarDrawerToggle(
                this,                  /* host Activity */
                mDrawerLayout,         /* DrawerLayout object */
                R.drawable.ic_drawer,  /* nav drawer image to replace 'Up' caret */
                R.string.drawer_open,  /* "open drawer" description for accessibility */
                R.string.drawer_close  /* "close drawer" description for accessibility */
                ) {
            public void onDrawerClosed(View view) {
                getActionBar().setTitle(mTitle);
                invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu()
            }

            public void onDrawerOpened(View drawerView) {
                getActionBar().setTitle(mDrawerTitle);
                invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu()
            }
        };
        mDrawerLayout.setDrawerListener(mDrawerToggle);

        if (savedInstanceState == null) {
            selectItem(0);
        }
        
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    /* Called whenever we call invalidateOptionsMenu() */
    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        // If the nav drawer is open, hide action items related to the content view
        boolean drawerOpen = mDrawerLayout.isDrawerOpen(mDrawerList);

        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
         // The action bar home/up action should open or close the drawer.
         // ActionBarDrawerToggle will take care of this.
        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        // Handle action buttons
        switch(item.getItemId()) {
        
        default:
            return super.onOptionsItemSelected(item);
        }
    }

    /* The click listner for ListView in the navigation drawer */
    private class DrawerItemClickListener implements ListView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            selectItem(position);
        }
    }

    private void selectItem(int position) {
          	
        // update the main content by replacing fragments
        Fragment fragment = new AccueilFragment();
        Bundle args = new Bundle();
        FragmentManager fragmentManager = getFragmentManager();
        switch (position)
        {
	        case 1:
	        	historique = new ListCourses("train");
	        	listDefis = new ListCourses("compet");
	        	adapterList = new MyListAdapter(this, R.layout.rowlayout, historique.getListeCourses());
	        	adapterListDefis = new MyListAdapterHdefis(this, R.layout.rowlayoutdefis, listDefis.getListeCourses());
	        	fragment = new HistoricFragment();
	        	createFragment(args, fragment, fragmentManager, position);
	        	
	            break;
	            
	        case 2:
	        	fragment = new StatsFragment();
	        	createFragment(args, fragment, fragmentManager, position);
	        	
	            break;
	            
	        case 3:
	        	historique = new ListCourses("duo");
	        	adapterListCalendar = new MyListAdapterCalendar(this, R.layout.rowlayoutcalendar, historique.getListeCourses());
	        	fragment = new CalendarFragment();
	        	createFragment(args, fragment, fragmentManager, position);
	        	
	            break;
	            	                
	        case 4:
	        	fragment = new ProfilFragment();
	        	createFragment(args, fragment, fragmentManager, position);
	        	
	            break;
	            
	        case 5:
	        	listeCoureurs = new ListCoureurs();
	        	adapterListClassement = new MyListAdapterClassement(this, R.layout.rowlayoutranking, listeCoureurs.getListeCoureurs());
	        	listDefis = new ListCourses("compet");
	        	adapterListDefis2 = new MyListAdapterDefisAutour(this, R.layout.rowlayoutdefis2, listDefis.getListeCourses());
	        	fragment = new DefiAutourFragment();
	        	createFragment(args, fragment, fragmentManager, position);
	        	
	            break;
	            	            
	        case 6:
	        	fragment = new ProfilEquipeFragment();
	        	createFragment(args, fragment, fragmentManager, position);

	            break;
	            
	        case 7:
	        	listeCoureurs = new ListCoureurs();
	        	adapterListClassement = new MyListAdapterClassement(this, R.layout.rowlayoutranking, listeCoureurs.getListeCoureurs());
	        	listDefis = new ListCourses("compet");
	        	adapterListDefis2 = new MyListAdapterDefisAutour(this, R.layout.rowlayoutdefis2, listDefis.getListeCourses());
	        	listeTerritoires = new ListTerritoires();
	        	adapterListTerritoire = new MyListAdapterTerritoire(this, R.layout.rowlayoutterritoire, listeTerritoires.getListTerritoires());
	        	fragment = new TerritoiresFragment();
	        	createFragment(args, fragment, fragmentManager, position);

	            break;
	            
	        default:
	        	historique = new ListCourses("train");
	        	listDefis = new ListCourses("compet");
	        	adapterList = new MyListAdapter(this, R.layout.rowlayout, historique.getListeCourses());
	        	adapterListDefis = new MyListAdapterHdefis(this, R.layout.rowlayoutdefis, listDefis.getListeCourses());
	        	args.putInt(AccueilFragment.ARG_NUM_PAGE, position);
	        	createFragment(args, fragment, fragmentManager, position);
        }
        
    }
    
    public void createFragment(Bundle args, Fragment fragment, FragmentManager fragmentManager, int position)
    {
    	args.putInt(AccueilFragment.ARG_NUM_PAGE, position);
        fragment.setArguments(args);

        fragmentManager.beginTransaction().replace(R.id.content_frame, fragment).commit();

        // update selected item and title, then close the drawer
        mDrawerList.setItemChecked(position, true);
        setTitle(menuTitles[position]);
        mDrawerLayout.closeDrawer(mDrawerList);
    }

    @Override
    public void setTitle(CharSequence title) {
        mTitle = title;
        getActionBar().setTitle(mTitle);
    }


    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sync the toggle state after onRestoreInstanceState has occurred.
        mDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        // Pass any configuration change to the drawer toggls
        mDrawerToggle.onConfigurationChanged(newConfig);
    }

 
    public class AccueilFragment extends Fragment {
        public static final String ARG_NUM_PAGE = "num_page";

        public AccueilFragment() {
            // Empty constructor required for fragment subclasses
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_accueil, container, false);
            int i = getArguments().getInt(ARG_NUM_PAGE);
            String planet = getResources().getStringArray(R.array.menu)[i];
         
            // r�cup�ration de la liste teamActivity sur le layout
            ListView teamActivity = (ListView) rootView.findViewById(R.id.listTeamHistory);
            teamActivity.setAdapter(adapterList);
            
            // r�cup�ration de la liste teamActivity sur le layout
            ListView userActivity = (ListView) rootView.findViewById(R.id.listUserHistory);
            userActivity.setAdapter(adapterList);
            
            OnClickListener l = new OnClickListener() 
            {
            	public void onClick(View v)
            	{
            		Bundle args = new Bundle();
            		Fragment historique = new HistoricFragment();
                	args.putInt(ProfilFragment.ARG_NUM_PAGE, 1);
                	historique.setArguments(args);

                    FragmentManager fragmentManager = getFragmentManager();
                    fragmentManager.beginTransaction().replace(R.id.content_frame, historique).commit();
                    
                    // update selected item and title, then close the drawer
                    mDrawerList.setItemChecked(1, true);
                    setTitle(menuTitles[1]);
                    mDrawerLayout.closeDrawer(mDrawerList);
            		
            	}
            };
            
            Button btnHistorique = (Button) rootView.findViewById(R.id.history);
            btnHistorique.setOnClickListener(l);
            
            ListView x = (ListView) rootView.findViewById(R.id.listUserHistory);
    		x.setOnItemClickListener(new AdapterView.OnItemClickListener() {
    			ListCourses listCourses = new ListCourses("duo");    			
    			public void onItemClick(AdapterView<?> parent, View viewClicked, int position, long id)
    			{
    				Bundle args = new Bundle();
            		Fragment activity = new ActivityFragment();
                	args.putInt(ProfilFragment.ARG_NUM_PAGE, 1);
                	activity.setArguments(args);

                    FragmentManager fragmentManager = getFragmentManager();
                    fragmentManager.beginTransaction().replace(R.id.content_frame, activity).commit();
                    
                    // update selected item and title, then close the drawer
                    mDrawerList.setItemChecked(-1, true);
                    setTitle("Activit�");
                    mDrawerLayout.closeDrawer(mDrawerList);
    			}
    		});
            
            
            return rootView;
        }
    }
    
    public class ProfilFragment extends Fragment {
        public static final String ARG_NUM_PAGE = "page_number";

        public ProfilFragment() {
            // Empty constructor required for fragment subclasses
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_profil, container, false);
            int i = getArguments().getInt(ARG_NUM_PAGE);
            String item = getResources().getStringArray(R.array.menu)[i];
              		
            return rootView;
        }
        
    }
    
    public class ProfilEquipeFragment extends Fragment {
        public static final String ARG_NUM_PAGE = "page_number";

        public ProfilEquipeFragment() {
            // Empty constructor required for fragment subclasses
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_profilequipe, container, false);
            int i = getArguments().getInt(ARG_NUM_PAGE);
            String item = getResources().getStringArray(R.array.menu)[i];
            
            OnClickListener l = new OnClickListener() 
            {
            	public void onClick(View v)
            	{
            		Bundle args = new Bundle();
            		Fragment profil = new ProfilFragment();
                	args.putInt(ProfilFragment.ARG_NUM_PAGE, 4);
                	profil.setArguments(args);

                    FragmentManager fragmentManager = getFragmentManager();
                    fragmentManager.beginTransaction().replace(R.id.content_frame, profil).commit();
                    
                    // update selected item and title, then close the drawer
                    mDrawerList.setItemChecked(4, true);
                    setTitle(menuTitles[4]);
                    mDrawerLayout.closeDrawer(mDrawerList);
            		
            	}
            };
            
            LinearLayout linlay1 = (LinearLayout) rootView.findViewById(R.id.linlay1);
            LinearLayout linlay2 = (LinearLayout) rootView.findViewById(R.id.linlay2);
            LinearLayout linlay3 = (LinearLayout) rootView.findViewById(R.id.linlay3);
            LinearLayout linlay4 = (LinearLayout) rootView.findViewById(R.id.linlay4);
            LinearLayout linlay5 = (LinearLayout) rootView.findViewById(R.id.linlay5);
            LinearLayout linlay6 = (LinearLayout) rootView.findViewById(R.id.linlay6);
            LinearLayout linlay7 = (LinearLayout) rootView.findViewById(R.id.linlay7);
            
            linlay1.setClickable(true);
            linlay2.setClickable(true);
            linlay3.setClickable(true);
            linlay4.setClickable(true);
            linlay5.setClickable(true);
            linlay6.setClickable(true);
            linlay7.setClickable(true);
            
            linlay1.setOnClickListener(l);
            linlay2.setOnClickListener(l);
            linlay3.setOnClickListener(l);
            linlay4.setOnClickListener(l);
            linlay5.setOnClickListener(l);
            linlay6.setOnClickListener(l);
            linlay7.setOnClickListener(l);
             
            return rootView;
        }
        
    }

    public class HistoricFragment extends Fragment {
        public static final String ARG_NUM_PAGE = "num_page";

        public HistoricFragment() {
            // Empty constructor required for fragment subclasses
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_history, container, false);
            int i = getArguments().getInt(ARG_NUM_PAGE);
            String planet = getResources().getStringArray(R.array.menu)[i];
         
            // r�cup�ration de la liste historique entrainement sur le layout
            ListView userActivity = (ListView) rootView.findViewById(R.id.listHistoryUser);
            userActivity.setAdapter(adapterList);   
            
            // r�cup�ration de la liste historique compet sur le layout
            ListView userActivityCompet = (ListView) rootView.findViewById(R.id.listHistoryCompet);
            userActivityCompet.setAdapter(adapterListDefis);   


            ListView listHistoryUser = (ListView) rootView.findViewById(R.id.listHistoryUser);
            listHistoryUser.setOnItemClickListener(new AdapterView.OnItemClickListener() {
    			
    			public void onItemClick(AdapterView<?> parent, View viewClicked, int position, long id)
    			{
    				Bundle args = new Bundle();
            		Fragment activity = new ActivityFragment();
                	args.putInt(ProfilFragment.ARG_NUM_PAGE, 1);
                	activity.setArguments(args);

                    FragmentManager fragmentManager = getFragmentManager();
                    fragmentManager.beginTransaction().replace(R.id.content_frame, activity).commit();
                    
                    // update selected item and title, then close the drawer
                    mDrawerList.setItemChecked(-1, true);
                    setTitle("Activit�");
                    mDrawerLayout.closeDrawer(mDrawerList);
    			}
    		});
            
            ListView listHistoryCompet = (ListView) rootView.findViewById(R.id.listHistoryCompet);
            listHistoryCompet.setOnItemClickListener(new AdapterView.OnItemClickListener() {  			
    			public void onItemClick(AdapterView<?> parent, View viewClicked, int position, long id)
    			{
    				Bundle args = new Bundle();
    				Fragment activity;
    				
    				if (position == 1 || position == 2 ){
    					activity = new ActivityDefiLostFragment();
    					setTitle("D�fi manqu�");
    				} else {
    					activity = new ActivityDefiWinFragment();
    					setTitle("D�fi r�ussi");
    				}
	            		
                	args.putInt(ProfilFragment.ARG_NUM_PAGE, 1);
                	activity.setArguments(args);

                    FragmentManager fragmentManager = getFragmentManager();
                    fragmentManager.beginTransaction().replace(R.id.content_frame, activity).commit();
                    
                    // update selected item and title, then close the drawer
                    mDrawerList.setItemChecked(-1, true);
                    
	                    mDrawerLayout.closeDrawer(mDrawerList);
    			}
    		});
            
            
            return rootView;
        }
    }

    public class ActivityFragment extends Fragment {
        public static final String ARG_NUM_PAGE = "page_number";

        public ActivityFragment() {
            // Empty constructor required for fragment subclasses
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_activity, container, false);
            int i = getArguments().getInt(ARG_NUM_PAGE);
            String item = getResources().getStringArray(R.array.menu)[i];
              		
            return rootView;
        }
        
    }
    
    public class ActivityDefiWinFragment extends Fragment {
        public static final String ARG_NUM_PAGE = "page_number";

        public ActivityDefiWinFragment() {
            // Empty constructor required for fragment subclasses
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_activitydefiwin, container, false);
            int i = getArguments().getInt(ARG_NUM_PAGE);
            String item = getResources().getStringArray(R.array.menu)[i];
              		
            return rootView;
        }
        
    }
    
    public class DefiAutourFragment extends Fragment {
        public static final String ARG_NUM_PAGE = "page_number";

        public DefiAutourFragment() {
            // Empty constructor required for fragment subclasses
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_listdefis, container, false);
            int i = getArguments().getInt(ARG_NUM_PAGE);
            String item = getResources().getStringArray(R.array.menu)[i];
            
            ListView listDefis = (ListView) rootView.findViewById(R.id.listDefisAutour);
            listDefis.setAdapter(adapterListDefis2);
            
            ListView x = (ListView) rootView.findViewById(R.id.listDefisAutour);
    		x.setOnItemClickListener(new AdapterView.OnItemClickListener() {
    			
    			public void onItemClick(AdapterView<?> parent, View viewClicked, int position, long id)
    			{
    				Bundle args = new Bundle();
            		Fragment ranking = new ClassementFragment();
                	args.putInt(ProfilFragment.ARG_NUM_PAGE, 1);
                	ranking.setArguments(args);

                    FragmentManager fragmentManager = getFragmentManager();
                    fragmentManager.beginTransaction().replace(R.id.content_frame, ranking).commit();
                    
                    // update selected item and title, then close the drawer
                    mDrawerList.setItemChecked(-1, true);
                    setTitle("Activit�");
                    mDrawerLayout.closeDrawer(mDrawerList);
    			}
    		});
                       		
            return rootView;
        }
        
    }
    
    public class ActivityDefiLostFragment extends Fragment {
        public static final String ARG_NUM_PAGE = "page_number";

        public ActivityDefiLostFragment() {
            // Empty constructor required for fragment subclasses
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_activitydeflost, container, false);
            int i = getArguments().getInt(ARG_NUM_PAGE);
            String item = getResources().getStringArray(R.array.menu)[i];
              		
            return rootView;
        }
        
    }
    
    public class StatsFragment extends Fragment {
        public static final String ARG_NUM_PAGE = "page_number";

        public StatsFragment() {
            // Empty constructor required for fragment subclasses
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_stats, container, false);
            int i = getArguments().getInt(ARG_NUM_PAGE);
            String item = getResources().getStringArray(R.array.menu)[i];
              		
            return rootView;
        }
        
    }

    public class ClassementFragment extends Fragment {
        public static final String ARG_NUM_PAGE = "page_number";

        public ClassementFragment() {
            // Empty constructor required for fragment subclasses
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_classement, container, false);
            int i = getArguments().getInt(ARG_NUM_PAGE);
            String item = getResources().getStringArray(R.array.menu)[i];
              	
            ListView listClassement = (ListView) rootView.findViewById(R.id.rankinglistView);
            listClassement.setAdapter(adapterListClassement); 
            
            return rootView;
        }
        
    }
    
    public class TerritoiresFragment extends Fragment {
        public static final String ARG_NUM_PAGE = "page_number";

        public TerritoiresFragment() {
            // Empty constructor required for fragment subclasses
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_territoires, container, false);
            int i = getArguments().getInt(ARG_NUM_PAGE);
            String item = getResources().getStringArray(R.array.menu)[i];
              	
            ListView listTerritoires = (ListView) rootView.findViewById(R.id.listTerritoire);
            listTerritoires.setAdapter(adapterListTerritoire); 
            
            ListView x = (ListView) rootView.findViewById(R.id.listTerritoire);
    		x.setOnItemClickListener(new AdapterView.OnItemClickListener() {
    			
    			public void onItemClick(AdapterView<?> parent, View viewClicked, int position, long id)
    			{
    				Bundle args = new Bundle();
            		Fragment territoire = new DefisTerritoireFragment();
                	args.putInt(ProfilFragment.ARG_NUM_PAGE, 1);
                	territoire.setArguments(args);

                    FragmentManager fragmentManager = getFragmentManager();
                    fragmentManager.beginTransaction().replace(R.id.content_frame, territoire).commit();
                    
                    // update selected item and title, then close the drawer
                    mDrawerList.setItemChecked(-1, true);
                    setTitle("D�fis du territoire");
                    mDrawerLayout.closeDrawer(mDrawerList);
    			}
    		});
            
            return rootView;
        }
        
    }
    
    public class DefisTerritoireFragment extends Fragment {
        public static final String ARG_NUM_PAGE = "page_number";

        public DefisTerritoireFragment() {
            // Empty constructor required for fragment subclasses
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_defisterritoire, container, false);
            
            ListView listDefis = (ListView) rootView.findViewById(R.id.deflistTerritoire);
            listDefis.setAdapter(adapterListDefis2);
            
            ListView x = (ListView) rootView.findViewById(R.id.deflistTerritoire);
    		x.setOnItemClickListener(new AdapterView.OnItemClickListener() {
    			
    			public void onItemClick(AdapterView<?> parent, View viewClicked, int position, long id)
    			{
    				Bundle args = new Bundle();
            		Fragment ranking = new ClassementFragment();
                	args.putInt(ProfilFragment.ARG_NUM_PAGE, 1);
                	ranking.setArguments(args);

                    FragmentManager fragmentManager = getFragmentManager();
                    fragmentManager.beginTransaction().replace(R.id.content_frame, ranking).commit();
                    
                    // update selected item and title, then close the drawer
                    mDrawerList.setItemChecked(-1, true);
                    setTitle("Activit�");
                    mDrawerLayout.closeDrawer(mDrawerList);
    			}
    		});
                       		
            return rootView;
        }
        
    }

    public class CalendarFragment extends Fragment {
        public static final String ARG_NUM_PAGE = "page_number";

        public CalendarFragment() {
            // Empty constructor required for fragment subclasses
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_calendar, container, false);
            
            ListView listCAL = (ListView) rootView.findViewById(R.id.CalendarlistView1);
            listCAL.setAdapter(adapterListCalendar);
                                  		
            return rootView;
        }
        
    }

}