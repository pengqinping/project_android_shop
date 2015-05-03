/*
 * 版       权:  Royal.k.peng@gmail.com, All rights reserved
 * 作       者:  Royal
 * 座 右  铭:  Never give up, adhere to in the end.
 */
package com.twp.shopping.ui.inter;

import android.view.Menu;

/**
 * 页面实现方式，Activity + fragment ,fragment
 * 都依附于activity，fragment没有菜单的主动权。提供一个接口给fragment去实现
 * 
 * @author Royal
 * @Email Royal.k.peng@gmail.com
 */
public interface MenuCreate {

	void onActivityCreateMenu(Menu menu);

}
