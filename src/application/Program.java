package application;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);

		SellerDao sellerDao = DaoFactory.createSellerDao();

		System.out.println("=== TEST 1: seller findById ====");
		Seller seller = sellerDao.findById(3);
		System.out.println(seller);

		System.out.println();
		System.out.println("=== TEST 2: seller findByIdDepartment ====");
		Department department = new Department(2, null);
		List<Seller> list = sellerDao.findByDepartment(department);
		for (Seller obj : list) {
			System.out.println(obj);
		}

		System.out.println();
		System.out.println("=== Test 3: seller findAll ====");
		list = sellerDao.findAll();
		for (Seller obj : list) {
			System.out.println(obj);
		}

		System.out.println();
		System.out.println("=== Test 4: seller insert ====");
		Seller newSeller = new Seller(null, "Greg", "greg@gmail.coom", new Date(), 4000.0, department);
		sellerDao.insert(newSeller);
		System.out.println("Inserted! New id = " + newSeller.getId());

		System.out.println();
		System.out.println("=== Test 5: seller update ====");
		seller = sellerDao.findById(1);
		seller.setName("Martha Waine");
		seller.setEmail("marthawaine@gmail.com");
		sellerDao.update(seller);
		System.out.println("Update Completed!");

		System.out.println();
		System.out.println("=== Test 6: seller delete ====");
		System.out.println("Enter id for delete teste: ");
		int id = in.nextInt();
		sellerDao.deleteById(id);

		System.out.println("Delete completed!");
		
		in.close();

	}

}
