package com.bionic.webrestaurant.managebeans;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.model.UploadedFile;

import com.bionic.webrestaurant.entities.Menu;
import com.bionic.webrestaurant.entities.TypeDish;
import com.bionic.webrestaurant.service.MenuService;

@Named
@ManagedBean
@SessionScoped
public class DishBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<Menu> listDishes = null;

	private Menu dish;

	@Inject
	private MenuService menuService;

	private UploadedFile file;

	public DishBean() {
		dish = new Menu();
	}

	public List<Menu> getListDishes() {
		return listDishes;
	}

	public void setListDishes(List<Menu> dishes) {
		this.listDishes = dishes;
	}

	public Menu getDish() {
		return dish;
	}

	public void setDish(Menu dish) {
		this.dish = dish;
	}

	public UploadedFile getFile() {
		return file;
	}

	public void setFile(UploadedFile file) {
		this.file = file;
	}

	public void getAllDishes() {
		this.listDishes = menuService.getAllDishes();		
	}
	
	public void getListBeverage() {
		listDishes = menuService.getDishes(TypeDish.BEVERAGE);
	}

	public void getListDesserts() {
		listDishes = menuService.getDishes(TypeDish.DESSERT);
	}

	public void getListMainCourse() {
		listDishes = menuService.getDishes(TypeDish.MAIN_COURSE);
	}

	public void getListSalads() {
		listDishes = menuService.getDishes(TypeDish.SALAD);
	}

	public void getListSoups() {
		listDishes = menuService.getDishes(TypeDish.SOUP);
	}

	public String saveDish() {
		menuService.saveDish(dish);
		return "dishList.xhtml?faces-redirect=true";		
	}

	public String addNewDish() {
		dish = new Menu();
		return "newDish.xhtml?faces-redirect=true";
	}

	public String editDish(String id) {
		int n = Integer.valueOf(id);
		dish = menuService.findById(n);
		return "editDish.xhtml?faces-redirect=true";
	}

	public String setActiveStatusTrue(String id) {
		int n = Integer.valueOf(id);
		menuService.setActiveStatusTrue(n);
		return "dishList.xhtml?faces-redirect=true";
	}

	public String setActiveStatusFalse(String id) {
		int n = Integer.valueOf(id);
		menuService.setActiveStatusFalse(n);
		return "dishList.xhtml?faces-redirect=true";
	}
//
//	public StreamedContent getImage() {
//		if (dish.getPicture() != null) {
//			return new DefaultStreamedContent(new ByteArrayInputStream(
//					dish.getPicture()));
//		}
//		return new DefaultStreamedContent();
//
//	}
//
//	public String upload() {
//		System.out.println("sssss");
//		if (file != null) {
//			try {
//
//				dish.setPicture(file.getContents());
//				menuService.saveDish(dish);
//				FacesMessage msg = new FacesMessage("Succesful",
//						file.getFileName() + " is uploaded.");
//				FacesContext.getCurrentInstance().addMessage(null, msg);
//				return "editBeverage";
//			} catch (Exception e) {
//				System.out.println("Exception-File Upload." + e.getMessage());
//				return "editBeverage";
//			}
//		} else {
//			FacesMessage msg = new FacesMessage("Please select image!!");
//			FacesContext.getCurrentInstance().addMessage(null, msg);
//			return "editBeverage";
//		}
//	}

}
