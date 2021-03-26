package projet.babyShop3.entity;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name="category")

public class Category {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	  @Column(name = "idCategory", length = 20, nullable = false)
	private Integer idcategory;
	@NotEmpty
	@Size(min=4, max=20)
	@Column(name = "nameCategory", length = 20, nullable = false)
	private String nameCategory;

	@NotEmpty
	@Column
	private String photo;	
	@Transient 
	@OneToMany(mappedBy="category")	
	private Collection<Product> product;

	public Category() {
		super();
	}
	
	


	public Category(Integer idcategory) {
		super();
		this.idcategory = idcategory;
	}




	public Category(String nameCategory, String photo) {
		super();
		this.nameCategory = nameCategory;
		this.photo = photo;
	}


	public Integer getIdcategory() {
		return idcategory;
	}


	public void setIdcategory(Integer idcategory) {
		this.idcategory = idcategory;
	}


	public String getNameCategory() {
		return nameCategory;
	}


	public void setNameCategory(String nameCategory) {
		this.nameCategory = nameCategory;
	}


	
	  public String getPhoto() { return photo; }
	 

	public void setPhoto(String photo) {
		this.photo = photo;
	}


	public Collection<Product> getProduct() {
		return product;
	}


	public void setProduct(Collection<Product> product) {
		this.product = product;
	}

	
	
		
		 @Transient
		    public String getPhotoImagePath() {
		        if (photo == null || idcategory == null) return null;
		         
		        return "/imageBabyShop/" + idcategory + "/" + photo;
		    }


	

}
