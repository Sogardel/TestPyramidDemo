package microservice;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import io.restassured.response.Response;
import junit.framework.Assert;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class MainControllerComponentTest {

    private MainController personService;

    private StockRepository personRepositoryMock;

    private static final Integer id = 1;
    private static final Integer stock = 1;
    private static final Integer article = 1;
    
    @Before
    public void setUp() {
        personService = new MainController();

        personRepositoryMock = mock(StockRepository.class);
     //   personService.addNewArticle(100,1);
    }

    @Test
    public void create() {
    //	Stock created = Stock.createDTO( id, stock, article);
   //  Stock persisted = (id, stock, article);
        
      //  when(personRepositoryMock.save(any(Stock.class))).
     	when(personRepositoryMock.save(any(Stock.class))).then(RETURNS_MOCKS);
     //	Mockito.doReturn("dawda").when(personRepositoryMock.save(any(Stock.class)));
    	  // Mockito.doReturn("test").when((personRepositoryMock.save(any(Stock.class))));
     	final String response = personService.addNewArticle(article, stock);
     	System.out.println(response);
    	    Assert.assertEquals(response, RETURNS_MOCKS);
/*        String Created = personService.addNewArticle(2, stock);

        ArgumentCaptor<Stock> personArgument = ArgumentCaptor.forClass(Stock.class);
        verify(personRepositoryMock, times(1)).save(personArgument.capture());
        verifyNoMoreInteractions(personRepositoryMock);
        
        //assertPerson(created, personArgument.getValue());
       // assertEquals(persisted, created);
      // System.out.println(persisted);
       System.out.println(Created);*/
    }
/*    @Test
    public void build() {
        Stock built = Stock.getBuilder(article, stock).build();
        
        assertEquals(FIRST_NAME, built.getFirstName());
        assertEquals(LAST_NAME, built.getLastName());
        assertEquals(0, built.getVersion());

        assertNull(built.getCreationTime());
        assertNull(built.getModificationTime());
        assertNull(built.getId());
    }*/
}
