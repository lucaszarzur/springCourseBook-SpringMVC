package br.com.springMvcLivro.DAO;

import br.com.springMvcLivro.models.Product;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class ProductDAO {

    @PersistenceContext
    private EntityManager manager;
    public void save(Product product){
        manager.persist(product);
    }
}
