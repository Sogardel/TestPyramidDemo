package microservice;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity // This tells Hibernate to make a table out of this class
public class Stock {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    private Integer stock;
    private Integer article;
    private String name;
    

	public Integer getId() {
		return id;
	}

	public Integer setId(Integer id) {
		this.id = id;
		return id;
	}

	public Integer getStock() {
		return stock;
	}

	public Integer setStock(Integer stock) {
		this.stock = stock;
		return stock;
	}

	public Integer getArticle() {
		return article;
	}

	public Integer setArticle(Integer article) {
		this.article = article;
		return article;
	}
	
	public String getName() {
		return name;
	}

	public String setName(String name) {
		this.name = name;
		return name;
	}
 
	
}

