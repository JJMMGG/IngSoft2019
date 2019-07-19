package categoria;

import java.util.List;

import producto.Producto;

public interface ICategoria {
	public void agregarProducto(Producto producto)throws ExceptionCategory;
	public List<Producto> getListProducto();
	public String getNombreCategoria();
        public void agregarProductoPrivate(Producto producto)throws ExceptionCategory;
}
