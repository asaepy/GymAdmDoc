/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicauca.gymadmdoc.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Ricardo
 */
@Entity
@Table(name = "upload_image")
@XmlRootElement
@NamedQueries({
   @NamedQuery(name = "UploadImage.findAll", query = "SELECT u FROM UploadImage u"),
   @NamedQuery(name = "UploadImage.findByImageId", query = "SELECT u FROM UploadImage u WHERE u.imageId = :imageId"),
   @NamedQuery(name = "UploadImage.findByImageName", query = "SELECT u FROM UploadImage u WHERE u.imageName = :imageName")})
public class UploadImage implements Serializable {

   private static final long serialVersionUID = 1L;
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Basic(optional = false)
   @Column(name = "IMAGE_ID")
   private Long imageId;
   @Basic(optional = false)
   @NotNull
   @Size(min = 1, max = 45)
   @Column(name = "IMAGE_NAME")
   private String imageName;
   @Basic(optional = false)
   @NotNull
   @Lob
   @Column(name = "IMAGE")
   private byte[] image;

   public UploadImage() {
   }

   public UploadImage(Long imageId) {
      this.imageId = imageId;
   }

   public UploadImage(Long imageId, String imageName, byte[] image) {
      this.imageId = imageId;
      this.imageName = imageName;
      this.image = image;
   }

   public Long getImageId() {
      return imageId;
   }

   public void setImageId(Long imageId) {
      this.imageId = imageId;
   }

   public String getImageName() {
      return imageName;
   }

   public void setImageName(String imageName) {
      this.imageName = imageName;
   }

   public byte[] getImage() {
      return image;
   }

   public void setImage(byte[] image) {
      this.image = image;
   }

   @Override
   public int hashCode() {
      int hash = 0;
      hash += (imageId != null ? imageId.hashCode() : 0);
      return hash;
   }

   @Override
   public boolean equals(Object object) {
      // TODO: Warning - this method won't work in the case the id fields are not set
      if (!(object instanceof UploadImage)) {
         return false;
      }
      UploadImage other = (UploadImage) object;
      if ((this.imageId == null && other.imageId != null) || (this.imageId != null && !this.imageId.equals(other.imageId))) {
         return false;
      }
      return true;
   }

   @Override
   public String toString() {
      return "co.edu.unicauca.gymadmdoc.entities.UploadImage[ imageId=" + imageId + " ]";
   }
   
}
