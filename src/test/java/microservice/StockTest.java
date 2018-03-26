package microservice;



import org.junit.Test;
import junit.framework.Assert;

public class StockTest {
	
	Stock stock2 = new Stock();
    private Integer id =1;
    private Integer stock =12;
    private Integer article = 22;
	
    @Test
	public void setArticleTest() {
    	Integer response = stock2.setArticle(article);
    	Assert.assertEquals(new Integer(22), response);
	}
    @Test
	public void setIdTest() {
    	Integer response = stock2.setId(id);
    	Assert.assertEquals(new Integer(1), response);
	}
    @Test
	public void setStockTest() {
    	Integer response = stock2.setStock(stock);
    	Assert.assertEquals(new Integer(12), response);
	}
}
