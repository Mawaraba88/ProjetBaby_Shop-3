package projet.babyShop3.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


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
     
   // @Temporal(TemporalType.DATE)
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
	
	

    
    

}
