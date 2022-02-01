package application;

import java.util.Date;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		
		SellerDao sellerDao = DaoFactory.createSellerDao();
		System.out.println("====Teste 1: Seller findById ====");
		Seller seller = sellerDao.findById(3);
		
		System.out.println(seller);
		
		System.out.println("====Teste 2: Seller findByDepartment ====");
		Department department = new Department(2, null);
		List<Seller> list = sellerDao.findByDepartment(department);
		
		for(Seller obj : list) {
		System.out.println(obj);
		}
		
		System.out.println("====Teste 3: Seller findAll ====");
		list = sellerDao.findAll();
		
		for(Seller obj : list) {
		System.out.println(obj);
		}
		System.out.println("====Teste 4: Seller findAll ====");
		Seller nv = new Seller(null, "Ana", "ana@gmail.com", new Date(), 4000.0, department);
		sellerDao.insert(nv);
		System.out.println("Inserted! new Id=" + nv.getId());
		
		System.out.println("====Teste 4: Seller findAll ====");
		seller = sellerDao.findById(12);
		seller.setName("Marta");
		sellerDao.update(seller);
		System.out.println("Uptade completed");

		
	
	}

}
