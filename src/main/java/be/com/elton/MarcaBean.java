package be.com.elton;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class MarcaBean {

	private Marca marca = new Marca();

	public void getMarca(Marca marca) {

		this.marca = marca;
	}
}
