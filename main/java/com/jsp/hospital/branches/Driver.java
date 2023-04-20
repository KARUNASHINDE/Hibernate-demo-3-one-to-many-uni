package com.jsp.hospital.branches;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Driver {
	public static void main(String[] args) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("karuna");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		Hospital hospital = new Hospital();
		hospital.setName("APOLLO");
		hospital.setGst_no("kdfn459u69");

		Branches branches1 = new Branches();
		branches1.setName("APOLLO-1");
		branches1.setLocation("vashi");

		Branches branches2 = new Branches();
		branches2.setName("APOLLO-2");
		branches2.setLocation("dadar");

		Branches branches3 = new Branches();
		branches3.setName("APOLLO-3");
		branches3.setLocation("thane");

		List<Branches> Br = new ArrayList<Branches>();
		Br.add(branches1);
		Br.add(branches2);
		Br.add(branches3);

//		uni-direction
		hospital.setBranches(Br);

		entityTransaction.begin();
		entityManager.persist(hospital);
		entityManager.persist(branches1);
		entityManager.persist(branches2);
		entityManager.persist(branches3);
		entityTransaction.commit();

	}

}
