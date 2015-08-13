package test;

import java.util.List;

import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bionic.webrestaurant.entities.Menu;
import com.bionic.webrestaurant.entities.TypeDish;
import com.bionic.webrestaurant.service.MenuService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "test-config.xml")
public class MenuTest extends TestCase {

	@Autowired
	ApplicationContext context;

	MenuService menuService;

	@Before
	public void setUpBeforeClass() throws Exception {
		menuService = context.getBean(MenuService.class);

	}

	@Test
	public void test() {

		List<Menu> list = menuService.getDishes(TypeDish.BEVERAGE);

		for (Menu m : list) {
			System.out.println(m);
		}
		assertEquals(list.get(1).getId(), 1);
		
	}

}
