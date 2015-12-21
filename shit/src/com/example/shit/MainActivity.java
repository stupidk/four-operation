package com.example.shit;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.LinearLayout;

public class MainActivity extends Activity implements android.view.View.OnClickListener {
	private ViewPager mViewPager;// �������ý����л�
	private PagerAdapter mPagerAdapter;// ��ʼ��View������
	private List<View> mViews = new ArrayList<View>();// �������Tab01-04
	// �ĸ�Tab��ÿ��Tab����һ����ť
	private LinearLayout mTabWeiXin;
	private LinearLayout mTabAddress;
	private LinearLayout mTabFrd;
	private LinearLayout mTabSetting;
	// �ĸ���ť
	private ImageButton mWeiXinImg;
	private ImageButton mAddressImg;
	private ImageButton mFrdImg;
	private ImageButton mSettingImg;
	// ��ť
	private ImageButton in;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);
		initView();
		initViewPage();
		initEvent();

	}
	
	/**
	 * ��ʼ������
	 */
	private void initView() {
		mViewPager = (ViewPager) findViewById(R.id.id_viewpage);
		// ��ʼ���ĸ�LinearLayout
		mTabWeiXin = (LinearLayout) findViewById(R.id.id_tab_weixin);
		mTabAddress = (LinearLayout) findViewById(R.id.id_tab_address);
		mTabFrd = (LinearLayout) findViewById(R.id.id_tab_frd);
		mTabSetting = (LinearLayout) findViewById(R.id.id_tab_settings);
		// ��ʼ���ĸ���ť
		mWeiXinImg = (ImageButton) findViewById(R.id.id_tab_weixin_img);
 
		mAddressImg = (ImageButton) findViewById(R.id.id_tab_address_img);
		mFrdImg = (ImageButton) findViewById(R.id.id_tab_frd_img);
		mSettingImg = (ImageButton) findViewById(R.id.id_tab_settings_img);
		//��ʼ����ť
		
	}
	
	/**
	 * ��ʼ��ViewPage
	 */
	private void initViewPage() {

		// ��ʼ���ĸ�����
		LayoutInflater mLayoutInflater = LayoutInflater.from(this);
		View tab01 = mLayoutInflater.inflate(R.layout.tab01, null);
		View tab02 = mLayoutInflater.inflate(R.layout.tab02, null);
		View tab03 = mLayoutInflater.inflate(R.layout.tab03, null);
		View tab04 = mLayoutInflater.inflate(R.layout.tab04, null);
		in =(ImageButton)tab01.findViewById(R.id.in);
		in.setOnClickListener(new OnClickListener() {		
			@Override
			public void onClick(View arg0) {
			startActivity(new Intent(MainActivity.this,OperationActivity.class));	
			}
		});
		mViews.add(tab01);	
		mViews.add(tab02);
		mViews.add(tab03);
		mViews.add(tab04);

		// ��������ʼ��������
		mPagerAdapter = new PagerAdapter() {

			@Override
			public void destroyItem(ViewGroup container, int position,
					Object object) {
				container.removeView(mViews.get(position));

			}

			@Override
			public Object instantiateItem(ViewGroup container, int position) {
				View view = mViews.get(position);
				container.addView(view);
				return view;
			}

			@Override
			public boolean isViewFromObject(View arg0, Object arg1) {

				return arg0 == arg1;
			}

			@Override
			public int getCount() {

				return mViews.size();
			}
		};
		mViewPager.setAdapter(mPagerAdapter);
	}
	
	private void initEvent() {
		mTabWeiXin.setOnClickListener(this);
		mTabAddress.setOnClickListener(this);
		mTabFrd.setOnClickListener(this);
		mTabSetting.setOnClickListener(this);
		mViewPager.setOnPageChangeListener(new OnPageChangeListener() {
            /**
            *ViewPage���һ���ʱ
            */
			@Override
			public void onPageSelected(int arg0) {
				int currentItem = mViewPager.getCurrentItem();
				switch (currentItem) {
				case 0:
					 resetImg();
					mWeiXinImg.setImageResource(R.drawable.homepage3);
					break;
				case 1:
					 resetImg();
					mAddressImg.setImageResource(R.drawable.game3);
					break;
				case 2:
					 resetImg();
					mFrdImg.setImageResource(R.drawable.design3);
					break;
				case 3:
					 resetImg();
					mSettingImg.setImageResource(R.drawable.about3);
					break;
				default:
					break;
				}
			}

			private void resetImg() {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {

			}

			@Override
			public void onPageScrollStateChanged(int arg0) {

			}
		});
		
	
	}
	
	/**
	 * �ж��ĸ�Ҫ��ʾ�������ð�ťͼƬ
	 */
	@Override
	public void onClick(View v) {

		switch (v.getId()) {
		case R.id.id_tab_weixin:
			mViewPager.setCurrentItem(0);
			resetImg();
			mWeiXinImg.setImageResource(R.drawable.homepage3);
			break;
		case R.id.id_tab_address:
			mViewPager.setCurrentItem(1);
			resetImg();
			mAddressImg.setImageResource(R.drawable.game3);
			break;
		case R.id.id_tab_frd:
			mViewPager.setCurrentItem(2);
			resetImg();
			mFrdImg.setImageResource(R.drawable.design3);
			break;
		case R.id.id_tab_settings:
			mViewPager.setCurrentItem(3);
			resetImg();
			mSettingImg.setImageResource(R.drawable.about3);
			break;
		default:
			break;
		}
	}

	/**
	 * ������ͼƬ�䰵
	 */
	private void resetImg() {
		mWeiXinImg.setImageResource(R.drawable.homepage2);
		mAddressImg.setImageResource(R.drawable.game2);
		mFrdImg.setImageResource(R.drawable.design2);
		mSettingImg.setImageResource(R.drawable.about2);
	}



	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_main, container,
					false);
			return rootView;
		}
	}

	

}
