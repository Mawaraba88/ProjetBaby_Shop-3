package projet.babyShop3.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.format.annotation.DateTimeFormat;


@Entity


@Table(name = "Products")//Mapping: correspondance de la classe avec la table
public class Product implements Serializable {
	
	private static final long serialVersionUID = -1000119078147252957L;
	 
    @Id
    @Column(name = "Code", length = 20, nullable = false)
    private String code;
 
    @Column(name = "Name", length = 255, nullable = false)
    private String name;
 
    @Column(name = "Price", nullable = false)
    private double price;
 
    
    @Column(name = "Image", length = Integer.MAX_VALUE, nullable = true)
    private String image;
     
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @Column(name = "Create_Date", nullable = true)
    private Date createDate;
	
	  @ManyToOne
	 
	  @JoinColumn(name="idcategory") 
	  private Category category;
	
	public Product(String code, String name, double price, Category category) {
		super();
		this.code = code;
		this.name = name;
		this.price = price;
		this.category = category;
	}


	public Product(String code, String name, double price, String image, Category category) {
		super();
		this.code = code;
		this.name = name;
		this.price = price;
		this.image = image;
		this.category = category;
	}

	
	

	public Product(String code, String name, double price, String image, Date createDate, Category category) {
		super();
		this.code = code;
		this.name = name;
		this.price = price;
		this.image = image;
		this.createDate = createDate;
		this.category = category;
	}

	
	

	public Product(String code, String name, double price, String image) {
		super();
		this.code = code;
		this.name = name;
		this.price = price;
		this.image = image;
	}
	
	


	public Product(String code, String name, double price, String image, Date createDate) {
		super();
		this.code = code;
		this.name = name;
		this.price = price;
		this.image = image;
		this.createDate = createDate;
	}


	public Product() {
		super();
	}


	public String getCode() {
		return code;
	}


	public void setCode(String code) {
		this.code = code;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	public String getImage() {
		return image;
	}


	public void setImage(String image) {
		this.image = image;
	}


	public Date getCreateDate() {
		return createDate;
	}


	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}


	public Category getCategory() {
		return category;
	}


	public void setCategory(Category category) {
		this.category = category;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

	 @Transient
	    public String getImageImagePath() {
	        if (image == null || code== null) return null;
	         
	        return "/imageBabyShop/" + code + "/" + image;
	    }



	

}
