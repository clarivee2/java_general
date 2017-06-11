package springapp.domain;

import java.io.Serializable;
import java.util.List;

/***
 * Service/Interface for products
 * 
 * @author Christian
 *
 */
public interface ProductManager extends Serializable {

	public void increasePrice(int percentage);

	public List<Product> getProducts();

}
