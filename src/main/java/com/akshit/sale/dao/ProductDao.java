package com.akshit.sale.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;
import com.akshit.sale.pojo.Product;

@Repository
public class ProductDao extends AbstractDao {
	
	private static String select_all = "select p from Product p";
	private static String select_id = "select p from Product p where barcode=:barcode";
	private static String update_query ="update Product set brand_id = :brand_id, name=:name , mrp=:mrp,barcode =:barcode,name=:name  where id = :id";
	@PersistenceContext
	private EntityManager em;

	
	public List<Product> getall() {
		TypedQuery<Product> query = getQuery(select_all, Product.class);
		return query.getResultList();
	}
	@Transactional
	public void update(int id,Product p){

		em.createQuery(update_query).setParameter("id", id)
				.setParameter("brand_id",p.getBrand_id())
				.setParameter("name", p.getName())
				.setParameter("mrp", p.getMrp())
				.setParameter("barcode", p.getBarcode())
				.executeUpdate();
	}
	@Transactional
	public void add(Product x) {
		em.persist(x);
	}
	public Product select(String barcode) { 
		 TypedQuery<Product> query = getQuery(select_id, Product.class); 
		 query.setParameter("barcode", barcode); 
		 return getSingle(query); 
	}
	public Product select(int id) {
		TypedQuery<Product> query = getQuery("select p from Product p where product_id=:product_id", Product.class);
		query.setParameter("product_id", id);
		return getSingle(query);
	}
}
